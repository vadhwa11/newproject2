package jkt.hms.bloodBank.dataservice;

import static jkt.hms.util.RequestConstants.*;
import static jkt.hms.util.RequestConstants.BLOOD_BAG_NO;
import static jkt.hms.util.RequestConstants.BLOOD_COMPONENT_ID;
import static jkt.hms.util.RequestConstants.BLOOD_GROUP_ID;
import static jkt.hms.util.RequestConstants.BLOOD_REQUEST_ID;
import static jkt.hms.util.RequestConstants.COLLECTION_DATE;
import static jkt.hms.util.RequestConstants.DEPARTMENT_ID;
import static jkt.hms.util.RequestConstants.DONER_NAME;
import static jkt.hms.util.RequestConstants.EMPLOYEE_ID;
import static jkt.hms.util.RequestConstants.EXPIRY_DATE;
import static jkt.hms.util.RequestConstants.HIN_ID;
import static jkt.hms.util.RequestConstants.INPATIENT_ID;
import static jkt.hms.util.RequestConstants.QUANTITY;
import static jkt.hms.util.RequestConstants.RANK_ID;
import static jkt.hms.util.RequestConstants.REMARKS;
import static jkt.hms.util.RequestConstants.SELECTED_RADIO;
import static jkt.hms.util.RequestConstants.STOCK_NO;
import static jkt.hms.util.RequestConstants.UNIT_ADDRESS;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;

import jkt.hms.masters.business.BloodDiscardEntry;
import jkt.hms.masters.business.BloodDonationEntryDetail;
import jkt.hms.masters.business.BloodDonationEntryHeader;
import jkt.hms.masters.business.BloodDonorSampleScreeningDetail;
import jkt.hms.masters.business.BloodDonorSampleScreeningHeader;
import jkt.hms.masters.business.BloodIssueDetail;
import jkt.hms.masters.business.BloodIssueHeader;
import jkt.hms.masters.business.BloodMasComponent;
import jkt.hms.masters.business.BloodOpeningStockDetail;
import jkt.hms.masters.business.BloodOpeningStockMain;
import jkt.hms.masters.business.BloodReactionEntry;
import jkt.hms.masters.business.BloodRequestEntryDetail;
import jkt.hms.masters.business.BloodRequestEntryHeader;
import jkt.hms.masters.business.BloodSampleCollection;
import jkt.hms.masters.business.BloodSampleScreeningDetail;
import jkt.hms.masters.business.BloodSampleScreeningHeader;
import jkt.hms.masters.business.BloodStockDetail;
import jkt.hms.masters.business.BloodStockMain;
import jkt.hms.masters.business.BloodTestEntryDetail;
import jkt.hms.masters.business.BloodTestEntryHeader;
import jkt.hms.masters.business.BloodTransfusion;
import jkt.hms.masters.business.BloodTransfussionReactionDt;
import jkt.hms.masters.business.BloodTransfussionReactionHd;
import jkt.hms.masters.business.DgMasInvestigation;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasBloodGroup;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasOccupation;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasRelation;
import jkt.hms.masters.business.MasServiceType;
import jkt.hms.masters.business.MasState;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BloodBankDataServiceImpl extends HibernateDaoSupport implements
		BloodBankDataService {

	// --------------BloodComponent-------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> showBloodComponentJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodMasComponent> searchBloodComponentList = new ArrayList<BloodMasComponent>();
		searchBloodComponentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.BloodMasComponent ");
		map.put("searchBloodComponentList", searchBloodComponentList);
		return map;
	}

	public boolean addBloodComponent(BloodMasComponent bloodMasComponent) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(bloodMasComponent);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteBloodComponent(int bloodComponentId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		BloodMasComponent bloodMasComponent = new BloodMasComponent();
		bloodMasComponent = (BloodMasComponent) getHibernateTemplate().get(
				BloodMasComponent.class, bloodComponentId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				bloodMasComponent.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				bloodMasComponent.setStatus("y");
				dataDeleted = false;
			}
		}
		bloodMasComponent.setLastChgBy(changedBy);
		bloodMasComponent.setLastChgDate(currentDate);
		bloodMasComponent.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(bloodMasComponent);
		return dataDeleted;
	}

	public boolean editBloodComponent(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
		String bloodComponentName = "";
		String bloodComponentCode = "";
		String changedBy = "";
		String wholeBlood = "";
		int bloodComponentId = 0;
		int qtyUnit = 0;
		int temperature = 0;
		int lifeSpan = 0;

		bloodComponentId = (Integer) generalMap.get("id");
		bloodComponentCode = (String) generalMap.get("bloodComponentCode");
		bloodComponentName = (String) generalMap.get("name");
		wholeBlood = (String) generalMap.get("wholeBlood");
		qtyUnit = (Integer) generalMap.get("qtyUnit");
		temperature = (Integer) generalMap.get("temperature");
		lifeSpan = (Integer) generalMap.get("lifeSpan");
		wholeBlood = (String) generalMap.get("wholeBlood");

		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		BloodMasComponent bloodMasComponent = (BloodMasComponent) getHibernateTemplate()
				.get(BloodMasComponent.class, bloodComponentId);

		bloodMasComponent.setId(bloodComponentId);
		bloodMasComponent.setComponentName(bloodComponentName);
		bloodMasComponent.setLifeSpan(lifeSpan);
		bloodMasComponent.setQtyUnit(qtyUnit);
		bloodMasComponent.setTemperature(temperature);
		bloodMasComponent.setWholeBlood(wholeBlood);
		bloodMasComponent.setLastChgBy(changedBy);
		bloodMasComponent.setLastChgDate(currentDate);
		bloodMasComponent.setLastChgTime(currentTime);

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(bloodMasComponent);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchBloodComponent(String bloodComponentCode,
			String bloodComponentName) {
		List<BloodMasComponent> searchBloodComponentList = new ArrayList<BloodMasComponent>();
		Map bloodComponentFieldsMap = new HashMap();
		try {
			if ((bloodComponentName != null) || (bloodComponentCode == null)) {
				searchBloodComponentList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.BloodMasComponent bmc where bmc.ComponentName like '"
										+ bloodComponentName
										+ "%' order by bmc.ComponentName");
			} else {
				searchBloodComponentList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.BloodMasComponent mbg where mbg.ComponentCode like '"
										+ bloodComponentCode
										+ "%' order by mbg.ComponentCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		bloodComponentFieldsMap.put("searchBloodComponentList",
				searchBloodComponentList);
		return bloodComponentFieldsMap;
	}

	public Map<String, Object> showPatientSearchForBloodTransfusionJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();

		Session session = (Session) getSession();

		try {
			rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).list();
			map.put("rankList", rankList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> getPatientForBloodTransfusion(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		Session session = (Session) getSession();

		String serviceNo = "";
		String hinNo = "";
		String adNo = "";
		String patientFName = "";
		String patientLName = "";
		int hinId = 0;
		int rankId = 0;

		if (mapForDs.get("serviceNo") != null) {
			serviceNo = (String) mapForDs.get("serviceNo");
		}
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}
		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		if (mapForDs.get("patientLName") != null) {
			patientLName = (String) mapForDs.get("patientLName");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		if (mapForDs.get("adNo") != null) {
			adNo = (String) mapForDs.get("adNo");
		}
		if (mapForDs.get("rankId") != null) {
			rankId = (Integer) mapForDs.get("rankId");
		}

		try {
			Criteria crit = session.createCriteria(Inpatient.class).add(
					Restrictions.eq("AdStatus", "A"));
			if (!serviceNo.equals("") || !hinNo.equals("") || rankId != 0
					|| !patientFName.equals("") || !patientLName.equals("")) {
				crit = crit.createAlias("Hin", "hn");
			}
			if (!serviceNo.equals("")) {
				crit = crit.add(Restrictions.like("hn.ServiceNo", serviceNo
						+ "%"));
			}
			if (!hinNo.equals("")) {
				crit = crit.add(Restrictions.like("hn.HinNo", hinNo + "%"));
			}
			if (rankId != 0) {
				crit = crit.createAlias("hn.Rank", "rn").add(Restrictions.eq("rn.Id", rankId));
			}
			if (!patientFName.equals("")) {
				crit = crit.add(Restrictions.like("hn.PFirstName", patientFName + "%"));
			}
			if (!patientLName.equals("")) {
				crit = crit.add(Restrictions.like("hn.PLastName", patientLName + "%"));
			}
			if (!adNo.equals("")) {
				crit = crit.add(Restrictions.like("AdNo", adNo + "%"));
			}

			inpatientList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("inpatientList", inpatientList);
		return map;
	}

	public int getTransfusionEntrySeqForDisplay(String string) {
		int maxSeqNo = 0;
		List<Integer> seqNoList = new ArrayList<Integer>();
		int entrySeqNo = 0;
		Session session = (Session) getSession();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			seqNoList = session.createCriteria(TransactionSequence.class).add(
					Restrictions.eq("TransactionPrefix", "TEN")).setProjection(
					Projections.projectionList().add(Projections.max("TransactionSequenceNumber"))).list();

			if (seqNoList.get(0) == null || seqNoList.size() == 0) {
				TransactionSequence tsObj = new TransactionSequence();
				tsObj.setStatus("y");
				tsObj.setTablename("BloodTransfusion");
				tsObj.setTransactionPrefix("TEN");
				tsObj.setTransactionSequenceName("Entry No");
				tsObj.setTransactionSequenceNumber(0);
				tsObj.setCreatedby("admin");
				tsObj.setStatus("y");
				hbt.save(tsObj);
				entrySeqNo = Integer.valueOf(1);
			} else if (seqNoList.get(0) != null) {
				maxSeqNo = seqNoList.get(0);
				entrySeqNo = Integer.valueOf(maxSeqNo + 1);

			} else {
				entrySeqNo = Integer.valueOf(1);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return entrySeqNo;
	}

	public Map<String, Object> showConsentBloodTransfusion(int inpatientId) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<BloodMasComponent> componentList = new ArrayList<BloodMasComponent>();
		Session session = (Session) getSession();

		try {
			componentList = session.createCriteria(BloodMasComponent.class).add(Restrictions.eq("Status", "y")).list();
			if (componentList.size() > 0) {
				detailsMap.put("componentList", componentList);
			}
			inpatientList = session.createCriteria(Inpatient.class).add(Restrictions.eq("Id", inpatientId)).list();
					
			if (inpatientList != null || inpatientList.size() > 0) {
				detailsMap.put("inpatientList", inpatientList);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	public int generateTransfusionEntryNumber() {
		int entrySeqNo = 0;
		List<TransactionSequence> seqNoList = new ArrayList<TransactionSequence>();

		Session session = (Session) getSession();
		try {
			seqNoList = session.createCriteria(TransactionSequence.class).add(
					Restrictions.eq("TransactionPrefix", "TEN")).list();
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
			tsObj.setTablename("BloodTransfusion");
			tsObj.setTransactionPrefix("TEN");
			tsObj.setTransactionSequenceName("Entry No");
			tsObj.setTransactionSequenceNumber(0);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");
			hbt.save(entrySeqNo);
		}
		return entrySeqNo;
	}

	public boolean submitBloodTransfusion(BloodTransfusion bloodTransfusion) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(bloodTransfusion);
		successfullyAdded = true;
		return successfullyAdded;
	}

	// -----Blood Request Entry-------------------------------------

	public Map<String, Object> showPatientSearchForBloodRequestJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();

		Session session = (Session) getSession();

		try {
			rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).list();
			map.put("rankList", rankList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	// -----------------method for seaching patient-----
	public Map<String, Object> getPatientForBloodRequest(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		String serviceNo = "";
		String hinNo = "";
		int rankId = 0;
		String patientFName = "";
		String patientLName = "";
		int hinId = 0;
		String pType = "";

		Session session = (Session) getSession();

		if (mapForDs.get("serviceNo") != null) {
			serviceNo = (String) mapForDs.get("serviceNo");
		}
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}
		if (mapForDs.get("rankId") != null) {
			rankId = (Integer) mapForDs.get("rankId");
		}
		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		if (mapForDs.get("patientLName") != null) {
			patientLName = (String) mapForDs.get("patientLName");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		if (mapForDs.get("pType") != null) {
			pType = (String) mapForDs.get("pType");
		}

		try {

			StringBuffer hqlQuery = new StringBuffer("");

			hqlQuery
					.append("select p.Id,p.ServiceNo,p.HinNo,p.PFirstName,p.PLastName,p.Rank,p.PatientStatus from Patient p where p.PatientStatus!='expired' ");

			if (hinId != 0) {
				hqlQuery.append("and p.Id = " + hinId);
			}
			if (!serviceNo.equals("")) {
				hqlQuery.append("and p.ServiceNo like '" + serviceNo + "%' ");
			}
			if (!hinNo.equals("")) {
				hqlQuery.append("and p.HinNo like '" + hinNo + "%' ");
			}
			if (!patientFName.equals("")) {
				hqlQuery.append("and p.PFirstName like '" + patientFName + "%' ");
						
			}
			if (!patientLName.equals("")) {
				hqlQuery
						.append("and p.PLastName like '" + patientLName + "%' ");
			}
			if (!pType.equals("")) {
				hqlQuery.append("and p.PatientStatus like '%" + pType + "%' ");
			}
			if (rankId != 0) {
				hqlQuery.append("and p.Rank.Id = " + rankId + "");
			}
			List<Object> list = (List<Object>) session.createQuery(hqlQuery.toString()).list();

			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				Patient patient = new Patient();

				Object[] object = (Object[]) iterator.next();
				patient.setId((Integer) object[0]);
				if (object[1] != null)
					patient.setServiceNo((String) object[1]);
				if (object[2] != null)
					patient.setHinNo((String) object[2]);
				if (object[3] != null)
					patient.setPFirstName((String) object[3]);
				if (object[4] != null)
					patient.setPLastName((String) object[4]);
				if (object[5] != null) {
					patient.setRank((MasRank) object[5]);
				}
				if (object[6] != null)
					patient.setPatientStatus((String) object[6]);
				patientList.add(patient);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("patientList", patientList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getComponentNameForAutoComplete(Map<String, Object> parameterMap) 
	{
		Session session = (Session) getSession();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<BloodMasComponent> bloodComponentList = new ArrayList<BloodMasComponent>();
		String str = "";
		if (parameterMap.get("autoHint") != null) {
			str = parameterMap.get("autoHint") + "%";
		}

		bloodComponentList = session.createCriteria(BloodMasComponent.class)
				.add(Restrictions.like("ComponentName", str)).add(Restrictions.like("Status", "y")).list();
		if (bloodComponentList.size() > 0) {
			detailsMap.put("componentList", bloodComponentList);
		}
		return detailsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getComponentNameSeparationForAutoComplete(Map<String, Object> parameterMap) {
		Session session = (Session) getSession();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<BloodMasComponent> bloodComponentList = new ArrayList<BloodMasComponent>();
		String str = "";
		if (parameterMap.get("autoHint") != null) {
			str = parameterMap.get("autoHint") + "%";
		}

		bloodComponentList = session.createCriteria(BloodMasComponent.class)
				.add(Restrictions.like("ComponentName", str)).add(Restrictions.like("Status", "y")).add(
						Restrictions.eq("WholeBlood", "n")).list();

		if (bloodComponentList.size() > 0) {
			detailsMap.put("componentList", bloodComponentList);
		}
		return detailsMap;
	}

	// ------------method for component name for Auto Complete...........
	public Map<String, Object> fillItemsForComponentname(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();

		List componentList = new ArrayList();
		Session session = (Session) getSession();
		String componentName = (String) dataMap.get("componentName");
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			componentList = session.createCriteria(BloodMasComponent.class)
					.add(Restrictions.eq("ComponentName", componentName)).list();
					
			map.put("componentList", componentList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDetailsForSearch() {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<BloodMasComponent> componentList = new ArrayList<BloodMasComponent>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();

		try {
			componentList = session.createCriteria(BloodMasComponent.class)
					.add(Restrictions.eq("Status", "y")).list();
			if (componentList.size() > 0) {
				detailsMap.put("componentList", componentList);
			}
			departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).list();
			if (departmentList.size() > 0) {
				detailsMap.put("departmentList", departmentList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return detailsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showBloodRequestEntryJsp(int hinId) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<BloodMasComponent> componentList = new ArrayList<BloodMasComponent>();
		Session session = (Session) getSession();

		try {
			componentList = session.createCriteria(BloodMasComponent.class)
					.add(Restrictions.eq("Status", "y")).list();
			if (componentList.size() > 0) {
				detailsMap.put("componentList", componentList);
			}
			patientList = session.createCriteria(Patient.class).add(Restrictions.eq("Id", hinId)).list();
			if (patientList != null || patientList.size() > 0) {
				detailsMap.put("patientList", patientList);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	public String getOrderSeqForDisplay(String string) {
		List<Integer> orderSeqNoList = new ArrayList<Integer>();
		List<BloodRequestEntryHeader> seqNoList = new ArrayList<BloodRequestEntryHeader>();
		String orderSeqNo = "";
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
			seqNoList = session.createCriteria(BloodRequestEntryHeader.class)
					.list();
			if (seqNoList.size() > 0) {
				for (BloodRequestEntryHeader requestEntryHeader : seqNoList) {
					lastSeqNo = requestEntryHeader.getOrderNo();
				}
				StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
				while (str.hasMoreTokens()) {
					lastSeqYear = str.nextToken();
				}
			} else {
				lastSeqYear = currentYear;
			}

			orderSeqNoList = session.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "RON"))
					.setProjection(
							Projections.projectionList().add(
									Projections
											.max("TransactionSequenceNumber")))
					.list();
			if (orderSeqNoList.get(0) == null || orderSeqNoList.size() == 0) {
				TransactionSequence tsObj = new TransactionSequence();
				tsObj.setStatus("y");
				tsObj.setTablename("BloodRequestEntryHeader");
				tsObj.setTransactionPrefix("RON");
				tsObj.setTransactionSequenceName("Order No");
				tsObj.setTransactionSequenceNumber(0);
				tsObj.setCreatedby("admin");
				tsObj.setStatus("y");
				hbt.save(tsObj);
				orderSeqNo = String.valueOf(1);
			} else if (orderSeqNoList.size() > 0) {
				for (Integer maxOrderNo : orderSeqNoList) {
					if (currentYear.equals(lastSeqYear)) {
						orderSeqNo = String.valueOf(maxOrderNo + 1);
					} else {
						orderSeqNo = String.valueOf(1);
					}
				}
			}
			orderSeqNo = orderSeqNo.concat("/").concat(
					String.valueOf(lastSeqYear));
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return orderSeqNo;
	}

	@SuppressWarnings("unchecked")
	public String generateOrderNumber() {
		Map<String, Object> map = new HashMap<String, Object>();
		String orderSeqNo = "";
		List<TransactionSequence> orderSeqNoList = new ArrayList<TransactionSequence>();
		List<BloodRequestEntryHeader> seqNoList = new ArrayList<BloodRequestEntryHeader>();
		String lastSeqNo = "";
		String lastSeqYear = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		seqNoList = session.createCriteria(BloodRequestEntryHeader.class)
				.list();
		if (seqNoList.size() > 0) {
			for (BloodRequestEntryHeader requestEntryHeader : seqNoList) {
				lastSeqNo = requestEntryHeader.getOrderNo();
			}
			StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
			while (str.hasMoreTokens()) {
				lastSeqYear = str.nextToken();

			}
		} else if (lastSeqYear.equals("")) {
			lastSeqYear = currentYear;
		}
		orderSeqNoList = session.createCriteria(TransactionSequence.class).add(
				Restrictions.eq("TransactionPrefix", "RON")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (orderSeqNoList.size() > 0) {
			for (TransactionSequence transactionSequence : orderSeqNoList) {
				TransactionSequence obj = (TransactionSequence) orderSeqNoList
						.get(0);
				int id = obj.getId();
				int seqNo = 0;

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
				orderSeqNo = orderSeqNo.concat("/").concat(
						String.valueOf(lastSeqYear));
			}
		} else if (orderSeqNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("BloodRequestEntryHeader");
			tsObj.setTransactionPrefix("RON");
			tsObj.setTransactionSequenceName("Order No");
			tsObj.setTransactionSequenceNumber(0);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");
			hbt.save(tsObj);
			orderSeqNo = orderSeqNo.concat("/").concat(
					String.valueOf(lastSeqYear));
		}
		return orderSeqNo;
	}

	public boolean submitBloodRequestEntry(Map<String, Object> infoMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		BloodRequestEntryHeader bloodEntryHeader = new BloodRequestEntryHeader();
		List componentList = new ArrayList();
		Box box = null;
		int componentMainIdFromRequest = 0;
		int BloodhdId = 0;
		int departmentId = 0;
		int hospitalId = 0;
		int hinId = 0;
		String userName = "";
		String orderSeqNo = "";
		List quantity = null;
		List req_date = null;

		if (infoMap.get("hospitalId") != null) {
			hospitalId = (Integer) infoMap.get("hospitalId");
		}
		if (infoMap.get("departmentId") != null) {
			departmentId = (Integer) infoMap.get("departmentId");
		}
		if (infoMap.get("userName") != null) {
			userName = (String) infoMap.get("userName");
		}
		if (infoMap.get("bloodEntryHeader") != null) {
			bloodEntryHeader = (BloodRequestEntryHeader) infoMap
					.get("bloodEntryHeader");
		}
		if (infoMap.get("quantity") != null) {
			quantity = (List) infoMap.get("quantity");
		}
		if (infoMap.get("req_date") != null) {
			req_date = (List) infoMap.get("req_date");
		}
		if (infoMap.get("componentMainIdFromRequest") != null) {
			componentMainIdFromRequest = (Integer) infoMap
					.get("componentMainIdFromRequest");
		}
		if (infoMap.get("hinId") != null) {
			hinId = (Integer) infoMap.get("hinId");
		}
		if (infoMap.get("orderSeqNo") != null) {
			orderSeqNo = (String) infoMap.get("orderSeqNo");
		}
		if (infoMap.get("box") != null) {
			box = (Box) infoMap.get("box");
		}
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String time = (String) utilMap.get("currentTime");
		Session session = (Session) getSession();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			if (infoMap.get("bloodEntryHeader") != null) {
				bloodEntryHeader = (BloodRequestEntryHeader) infoMap
						.get("bloodEntryHeader");
				hbt.save(bloodEntryHeader);
				hbt.refresh(bloodEntryHeader);
				BloodhdId = bloodEntryHeader.getId();
				map.put("BloodhdId", BloodhdId);
			} else {

				BloodRequestEntryHeader bloodEntryHeaderObj = new BloodRequestEntryHeader();
				bloodEntryHeaderObj = (BloodRequestEntryHeader) hbt.load(
						BloodRequestEntryHeader.class,
						componentMainIdFromRequest);
				hbt.update(bloodEntryHeaderObj);
			}
			if (infoMap.get("componentList") != null) {
				componentList = (List) infoMap.get("componentList");
				if (componentList.size() > 0) {
					for (int i = 0; i < componentList.size(); i++) {

						BloodRequestEntryDetail bloodEntryDetail = new BloodRequestEntryDetail();
						BloodMasComponent bloodMasComponent = new BloodMasComponent();

						try {
							if (componentList.get(i) != null
									&& !componentList.get(i).equals("")) {
								int componentId = Integer
										.parseInt(componentList.get(i)
												.toString());
								bloodMasComponent.setId(componentId);
								bloodEntryDetail
										.setComponent(bloodMasComponent);

								if (quantity != null && !quantity.equals("")) {
									bloodEntryDetail
											.setQty(Integer
													.parseInt((String) quantity
															.get(i)));
								}
								bloodEntryDetail
										.setReqDate(HMSUtil
												.convertStringTypeDateToDateType((String) req_date
														.get(i)));
								bloodEntryDetail.setLastChgBy(userName);
								bloodEntryDetail.setLastChgDate(date);
								bloodEntryDetail.setLastChgTime(time);
								if (infoMap.get("bloodEntryHeader") != null) {
									bloodEntryDetail
											.setRequest(bloodEntryHeader);

								} else {
									BloodRequestEntryHeader entryHeader = new BloodRequestEntryHeader();
									entryHeader
											.setId(componentMainIdFromRequest);
									bloodEntryDetail.setRequest(entryHeader);
								}
								hbt.save(bloodEntryDetail);
								saved = true;
							}

						} catch (RuntimeException e) {
							e.printStackTrace();
						}

					}
				}
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		// Vector componen_Id = box.getVector(BLOOD_COMPONENT_ID);
		BloodSampleCollection bldSampleCollection = new BloodSampleCollection();
		List<BloodMasComponent> componentCodeList = new ArrayList<BloodMasComponent>();
		int compId = Integer.parseInt("" + componentList.get(0));
		componentCodeList = session.createCriteria(BloodMasComponent.class)
				.add(Restrictions.eq("Id", compId)).list();
		org.springframework.orm.hibernate3.HibernateTemplate hbt1 = getHibernateTemplate();
		hbt1.setFlushModeName("FLUSH_EAGER");
		hbt1.setCheckWriteOperations(false);
		if (componentCodeList.size() > 0) {
			for (BloodMasComponent masComponent : componentCodeList) {
				try {
					int inpatientId = 0;
					if (box.getInt(INPATIENT_ID) != 0) {
						inpatientId = box.getInt(INPATIENT_ID);
						Inpatient inpatient = new Inpatient();
						inpatient.setId(inpatientId);
						bldSampleCollection.setInpatient(inpatient);

					}
					int hin_Id = box.getInt(HIN_ID);

					if (hinId != 0) {
						Patient patient = new Patient();
						patient.setId(hinId);
						bldSampleCollection.setHin(patient);
					}
					if (hospitalId != 0) {
						MasHospital hospital = new MasHospital();
						hospital.setId(hospitalId);
						bldSampleCollection.setHospital(hospital);
					}

					bldSampleCollection.setRequest(bloodEntryHeader);
					bldSampleCollection
							.setSampleCollectionNo(generateSampleCollectionNumber());

					bldSampleCollection.setSampleStatus("P");
					bldSampleCollection.setSampleCollectionDate(date);
					bldSampleCollection.setSampleCollectionTime(time);
					bldSampleCollection.setLastChgBy(userName);
					bldSampleCollection.setLastChgDate(date);
					bldSampleCollection.setLastChgTime(time);
					hbt1.save(bldSampleCollection);
					BloodRequestEntryHeader bloodRequestHeader = (BloodRequestEntryHeader) hbt1
							.load(BloodRequestEntryHeader.class,
									bloodEntryHeader.getId());
					bloodRequestHeader.setRequestStatus("C");
					hbt1.update(bloodRequestHeader);
					hbt1.refresh(bloodRequestHeader);
					saved = true;

				} catch (DataAccessException e) {
					e.printStackTrace();
				}
			}

		}
		return saved;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showBloodDonationEntryJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<BloodMasComponent> searchBloodDonationEntryList = new ArrayList<BloodMasComponent>();
		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
		List<MasState> stateList = new ArrayList<MasState>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasOccupation> occupationList = new ArrayList<MasOccupation>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();

		sexList = session.createCriteria(MasAdministrativeSex.class).add(
				Restrictions.eq("Status", "y")).list();
		stateList = session.createCriteria(MasState.class).add(
				Restrictions.eq("Status", "y")).list();
		searchBloodDonationEntryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.BloodMasComponent ");
		rankList = session.createCriteria(MasRank.class).add(
				Restrictions.eq("Status", "y")).list();
		occupationList = session.createCriteria(MasOccupation.class).add(
				Restrictions.eq("Status", "y")).list();
		employeeList = session.createCriteria(MasEmployee.class).add(
				Restrictions.eq("Status", "y")).createAlias("Department",
				"dept").createAlias("dept.DepartmentType", "deptType").add(
				Restrictions.eq("deptType.Id", 24)).list();
		bloodGroupList = session.createCriteria(MasBloodGroup.class).add(
				Restrictions.eq("Status", "y")).list();

		map.put("sexList", sexList);
		map.put("bloodGroupList", bloodGroupList);
		map.put("employeeList", employeeList);
		map.put("stateList", stateList);
		map.put("rankList", rankList);
		map.put("occupationList", occupationList);
		map.put("searchBloodDonationEntryList", searchBloodDonationEntryList);
		return map;
	}

	public Map<String, Object> getDetailsForSampleCollection() {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();

		try {
			departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).list();
			if (departmentList.size() > 0) {
				detailsMap.put("departmentList", departmentList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return detailsMap;
	}

	public Map<String, Object> getSampleCollectionGrid(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodRequestEntryHeader> patientDetailList = new ArrayList<BloodRequestEntryHeader>();
		Date currentDate = new Date();
		Session session = (Session) getSession();
		Criteria crit = null;
		if (mapForDs.get("currentDate") != null) {
			currentDate = (Date) mapForDs.get("currentDate");
		}
		try {
			crit = session.createCriteria(BloodRequestEntryHeader.class).add(
					Restrictions.eq("RequestStatus", "P")).add(
					Restrictions.eq("OrderDate", currentDate));
			patientDetailList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientDetailList", patientDetailList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getBloodSampleCollectionDetails(Map orderMap) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<BloodRequestEntryHeader> requesthdList = new ArrayList<BloodRequestEntryHeader>();
		int hinId = 0;
		Session session = (Session) getSession();

		try {
			employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).createAlias("Department",
					"dept").createAlias("dept.DepartmentType", "deptType").add(
					Restrictions.eq("deptType.Id", 24)).list();
			if (employeeList.size() > 0) {
				detailsMap.put("employeeList", employeeList);
			}
			if (orderMap != null && orderMap.size() > 0)
				requesthdList = session.createCriteria(
						BloodRequestEntryHeader.class).add(
						Restrictions.eq("RequestStatus", "P")).add(
						Restrictions.eq("Id", (Integer) orderMap
								.get("requestId"))).list();
			if (requesthdList != null && requesthdList.size() > 0) {
				detailsMap.put("requesthdList", requesthdList);

				hinId = requesthdList.get(0).getHin().getId();
				patientList = session.createCriteria(Patient.class).add(
						Restrictions.eq("Id", hinId)).list();
				if (patientList != null || patientList.size() > 0) {
					detailsMap.put("patientDetailList", patientList);
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	public Map<String, Object> getPatientDetailSampleCollection(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodRequestEntryHeader> patientDetailList = new ArrayList<BloodRequestEntryHeader>();

		Date fromDate = new Date();
		Date toDate = new Date();
		String serviceNo = "";
		String hinNo = "";
		String patientFName = "";
		String patientLName = "";
		String adNo = "";
		String pType = "";

		int departmentId = 0;

		Criteria crit = null;
		Session session = (Session) getSession();

		if (mapForDs.get("serviceNo") != null) {
			serviceNo = (String) mapForDs.get("serviceNo");
		}
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}
		if (mapForDs.get("departmentId") != null) {
			departmentId = (Integer) mapForDs.get("departmentId");
		}

		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		if (mapForDs.get("patientLName") != null) {
			patientLName = (String) mapForDs.get("patientLName");
		}

		if (mapForDs.get("adNo") != null) {
			adNo = (String) mapForDs.get("adNo");
		}

		if (mapForDs.get("pType") != null) {
			pType = (String) mapForDs.get("pType");
		}
		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}

		try {

			crit = session.createCriteria(BloodRequestEntryHeader.class).add(
					Restrictions.eq("RequestStatus", "P")).add(
					Restrictions.between("OrderDate", fromDate, toDate));

			if (!adNo.equals("")) {

				crit = crit.createAlias("Inpatient", "pt").add(
						Restrictions.like("pt.AdNo", adNo + "%"));
				if (departmentId != 0) {
					crit = crit.createAlias("pt.Department", "dp").add(
							Restrictions.eq("dp.Id", departmentId));
				}
			}
			if (!serviceNo.equals("") || !hinNo.equals("")
					|| !patientFName.equals("") || !patientLName.equals("")
					|| !pType.equals("")) {
				crit = crit.createAlias("Hin", "hn");

			}
			if (!serviceNo.equals("")) {
				crit = crit.add(Restrictions.like("hn.ServiceNo", serviceNo
						+ "%"));
			}

			if (!hinNo.equals("")) {
				crit = crit.add(Restrictions.like("hn.HinNo", hinNo + "%"));
			}
			if (!patientFName.equals("")) {
				crit = crit.add(Restrictions.like("hn.PFirstName", patientFName
						+ "%"));
			}
			if (!patientLName.equals("")) {
				crit = crit.add(Restrictions.like("hn.PLastName", patientLName
						+ "%"));
			}

			if (!pType.equals("")) {
				if (pType.equals("In Patient")) {
					crit = crit.add(Restrictions.eq("hn.PatientStatus",
							"In Patient"));
				} else if (pType.equals("Out Patient")) {
					crit = crit.add(Restrictions.eq("hn.PatientStatus",
							"Out Patient"));
				}
			}
			patientDetailList = crit.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientDetailList", patientDetailList);
		return map;
	}

	public String getSampleCollectionSeqForDisplay(String string) {
		List<Integer> collectionSeqNoList = new ArrayList<Integer>();
		List<BloodSampleCollection> seqNoList = new ArrayList<BloodSampleCollection>();
		String collectionSeqNo = "";
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
			seqNoList = session.createCriteria(BloodSampleCollection.class)
					.list();
			if (seqNoList.size() > 0) {
				for (BloodSampleCollection bloodSampleCollection : seqNoList) {
					lastSeqNo = bloodSampleCollection.getSampleCollectionNo();
				}
				StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
				while (str.hasMoreTokens()) {
					lastSeqYear = str.nextToken();
				}
			} else {
				lastSeqYear = currentYear;
			}

			collectionSeqNoList = session.createCriteria(
					TransactionSequence.class).add(
					Restrictions.eq("TransactionPrefix", "SCN")).setProjection(
					Projections.projectionList().add(
							Projections.max("TransactionSequenceNumber")))
					.list();
			if (collectionSeqNoList.get(0) == null
					|| collectionSeqNoList.size() == 0) {
				TransactionSequence tsObj = new TransactionSequence();
				tsObj.setStatus("y");
				tsObj.setTablename("BloodSampleCollection");
				tsObj.setTransactionPrefix("SCN");
				tsObj.setTransactionSequenceName("SampleCollection No");
				tsObj.setTransactionSequenceNumber(0);
				tsObj.setCreatedby("admin");
				tsObj.setStatus("y");
				hbt.save(tsObj);
				collectionSeqNo = String.valueOf(1);
			} else if (collectionSeqNoList.size() > 0) {
				for (Integer maxOrderNo : collectionSeqNoList) {
					if (currentYear.equals(lastSeqYear)) {
						collectionSeqNo = String.valueOf(maxOrderNo + 1);
					} else {
						collectionSeqNo = String.valueOf(1);
					}
				}
			} else {
				collectionSeqNo = String.valueOf(1);
			}
			collectionSeqNo = collectionSeqNo.concat("/").concat(
					String.valueOf(lastSeqYear));
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return collectionSeqNo;
	}

	public String generateSampleCollectionNumber() {
		Map<String, Object> map = new HashMap<String, Object>();
		String collectionSeqNo = "";
		List<TransactionSequence> collectionSeqNoList = new ArrayList<TransactionSequence>();
		List<BloodSampleCollection> seqNoList = new ArrayList<BloodSampleCollection>();
		String lastSeqNo = "";
		String lastSeqYear = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		seqNoList = session.createCriteria(BloodSampleCollection.class).list();
		if (seqNoList.size() > 0) {
			for (BloodSampleCollection bloodSampleCollection : seqNoList) {
				lastSeqNo = bloodSampleCollection.getSampleCollectionNo();
			}
			StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
			while (str.hasMoreTokens()) {
				lastSeqYear = str.nextToken();

			}
		} else if (lastSeqYear.equals("")) {
			lastSeqYear = currentYear;
		}
		collectionSeqNoList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "SCN")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (collectionSeqNoList.size() > 0) {
			for (TransactionSequence transactionSequence : collectionSeqNoList) {
				TransactionSequence obj = (TransactionSequence) collectionSeqNoList
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
				collectionSeqNo = seqNo.toString().concat("/").concat(
						String.valueOf(lastSeqYear));
			}
		} else if (collectionSeqNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("BloodSampleCollection");
			tsObj.setTransactionPrefix("SCN");
			tsObj.setTransactionSequenceName("SampleCollection No");
			tsObj.setTransactionSequenceNumber(0);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");
			hbt.save(tsObj);
			collectionSeqNo = collectionSeqNo.concat("/").concat(
					String.valueOf(lastSeqYear));
		}
		return collectionSeqNo;
	}

	public Map<String, Object> getSampleCollectionDetailsForNext(
			int newRequestId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Object> submitBloodSampleCollection(
			Map<String, Object> parameterMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		Box box = null;
		int hospitalId = 0;
		String userName = "";
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");

		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		if (parameterMap.get("box") != null) {
			box = (Box) parameterMap.get("box");
		}
		if (parameterMap.get("hospitalId") != null) {
			hospitalId = (Integer) parameterMap.get("hospitalId");
		}
		if (parameterMap.get("userName") != null) {
			userName = (String) parameterMap.get("userName");
		}

		BloodSampleCollection bloodSampleCollection = new BloodSampleCollection();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			int inpatientId = 0;
			if (box.getString(INPATIENT_ID) != null
					&& !box.getString(INPATIENT_ID).equals("")) {
				inpatientId = box.getInt(INPATIENT_ID);
				Inpatient inpatient = new Inpatient();
				inpatient.setId(inpatientId);
				bloodSampleCollection.setInpatient(inpatient);
			}
			int hinId = box.getInt(HIN_ID);
			int requestId = box.getInt(BLOOD_REQUEST_ID);
			int collectedBy = box.getInt(EMPLOYEE_ID);
			Patient patient = new Patient();
			patient.setId(hinId);
			bloodSampleCollection.setHin(patient);

			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			bloodSampleCollection.setHospital(hospital);

			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(collectedBy);
			bloodSampleCollection.setCollectedBy(masEmployee);

			if (requestId != 0) {
				BloodRequestEntryHeader bloodEntryHeader = new BloodRequestEntryHeader();
				bloodEntryHeader.setId(requestId);
				bloodSampleCollection.setRequest(bloodEntryHeader);
			}

			bloodSampleCollection
					.setSampleCollectionNo(generateSampleCollectionNumber());

			bloodSampleCollection.setSampleStatus("P");
			bloodSampleCollection.setSampleCollectionDate(date);
			bloodSampleCollection.setSampleCollectionTime(time);
			bloodSampleCollection.setLastChgBy(userName);
			bloodSampleCollection.setLastChgDate(date);
			bloodSampleCollection.setLastChgTime(time);
			hbt.save(bloodSampleCollection);
			BloodRequestEntryHeader bloodRequestHeader = (BloodRequestEntryHeader) hbt
					.load(BloodRequestEntryHeader.class, requestId);
			bloodRequestHeader.setRequestStatus("C");
			hbt.update(bloodRequestHeader);
			hbt.refresh(bloodRequestHeader);
			saved = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		map.put("saved", saved);
		return map;
	}

	public Map<String, Object> showBloodSampleColletionJsp(int requestId) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<BloodRequestEntryHeader> requesthdList = new ArrayList<BloodRequestEntryHeader>();
		int hinId = 0;
		Session session = (Session) getSession();

		try {
			requesthdList = session.createCriteria(
					BloodRequestEntryHeader.class).add(
					Restrictions.eq("RequestStatus", "P")).add(
					Restrictions.eq("Id", requestId)).list();
			if (requesthdList != null && requesthdList.size() > 0) {
				detailsMap.put("requesthdList", requesthdList);

				hinId = requesthdList.get(0).getHin().getId();
				patientList = session.createCriteria(Patient.class).add(
						Restrictions.eq("Id", hinId)).list();
				if (patientList != null || patientList.size() > 0) {
					detailsMap.put("patientDetailList", patientList);
				}
			}
			employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).createAlias("Department",
					"dept").createAlias("dept.DepartmentType", "deptType").add(
					Restrictions.eq("deptType.Id", 24)).list();
			if (employeeList.size() > 0) {
				detailsMap.put("employeeList", employeeList);
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	public Map<String, Object> getDetailsForSampleValidation() {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();

		try {
			departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).list();
			if (departmentList.size() > 0) {
				detailsMap.put("departmentList", departmentList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return detailsMap;
	}

	public Map<String, Object> getPatientDetailSampleValidation(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodSampleCollection> patientDetailList = new ArrayList<BloodSampleCollection>();

		Date fromDate = new Date();
		Date toDate = new Date();
		String serviceNo = "";
		String hinNo = "";
		int departmentId = 0;
		String patientFName = "";
		String patientLName = "";
		String adNo = "";
		String pType = "";

		Criteria crit = null;
		Session session = (Session) getSession();

		if (mapForDs.get("serviceNo") != null) {
			serviceNo = (String) mapForDs.get("serviceNo");
		}
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}
		if (mapForDs.get("departmentId") != null) {
			departmentId = (Integer) mapForDs.get("departmentId");
		}
		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		if (mapForDs.get("patientLName") != null) {
			patientLName = (String) mapForDs.get("patientLName");
		}
		if (mapForDs.get("adNo") != null) {
			adNo = (String) mapForDs.get("adNo");
		}
		if (mapForDs.get("pType") != null) {
			pType = (String) mapForDs.get("pType");
		}
		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}

		try {
			crit = session.createCriteria(BloodSampleCollection.class).add(
					Restrictions.eq("SampleStatus", "P")).add(
					Restrictions.between("SampleCollectionDate", fromDate,
							toDate));
			if (!adNo.equals("")) {
				crit = crit.createAlias("Inpatient", "ip").add(
						Restrictions.like("ip.AdNo", adNo + "%"));

				if (departmentId != 0) {
					crit = crit.createAlias("Inpatient", "ip").createAlias(
							"ip.Department", "dept").add(
							Restrictions.eq("dept.Id", departmentId));
				}
			}
			if (!serviceNo.equals("") || !hinNo.equals("")
					|| !patientFName.equals("") || !patientLName.equals("")
					|| !pType.equals("")) {
				crit = crit.createAlias("Hin", "pt");

			}

			if (!serviceNo.equals("")) {
				crit = crit.add(Restrictions.like("pt.ServiceNo", serviceNo
						+ "%"));
			}
			if (!hinNo.equals("")) {
				crit = crit.add(Restrictions.like("pt.HinNo", hinNo + "%"));
			}
			if (!patientFName.equals("")) {
				crit = crit.add(Restrictions.like("pt.PFirstName", patientFName
						+ "%"));
			}
			if (!patientLName.equals("")) {
				crit = crit.add(Restrictions.like("pt.PLastName", patientLName
						+ "%"));
			}
			if (!pType.equals("")) {
				if (pType.equals("In Patient")) {
					crit = crit.add(Restrictions.eq("pt.PatientStatus",
							"In Patient"));
				} else if (pType.equals("Out Patient")) {
					crit = crit.add(Restrictions.eq("pt.PatientStatus",
							"Out Patient"));
				}
			}
			patientDetailList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientDetailList", patientDetailList);
		return map;
	}

	public Map<String, Object> getSampleValidationGrid(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodSampleCollection> patientDetailList = new ArrayList<BloodSampleCollection>();
		Date currentDate = new Date();
		Session session = (Session) getSession();
		Criteria crit = null;
		if (mapForDs.get("currentDate") != null) {
			currentDate = (Date) mapForDs.get("currentDate");
		}
		try {
			crit = session.createCriteria(BloodSampleCollection.class).add(
					Restrictions.eq("SampleStatus", "P")).add(
					Restrictions.eq("SampleCollectionDate", currentDate));
			patientDetailList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientDetailList", patientDetailList);
		return map;
	}

	public Map<String, Object> showBloodSampleValidationJsp(int sampleId) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<BloodSampleCollection> sampleList = new ArrayList<BloodSampleCollection>();
		int hinId = 0;
		Session session = (Session) getSession();

		try {
			employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).createAlias("Department",
					"dept").createAlias("dept.DepartmentType", "deptType").add(
					Restrictions.eq("deptType.Id", 24)).list();
			if (employeeList.size() > 0) {
				detailsMap.put("employeeList", employeeList);
			}

			sampleList = session.createCriteria(BloodSampleCollection.class)
					.add(Restrictions.eq("SampleStatus", "P")).add(
							Restrictions.eq("Id", sampleId)).list();
			if (sampleList != null && sampleList.size() > 0) {
				detailsMap.put("sampleList", sampleList);

				hinId = sampleList.get(0).getHin().getId();
				patientList = session.createCriteria(Patient.class).add(
						Restrictions.eq("Id", hinId)).list();
				if (patientList != null || patientList.size() > 0) {
					detailsMap.put("patientDetailList", patientList);
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	public boolean submitBloodSampleValidation(Map<String, Object> parameterMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String dateTime = (String) utilMap.get("dateTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		Map<String, Object> date1 = HMSUtil.getCurrentDateAndTime();
		String time = (String) utilMap.get("currentTime");
		Session session = (Session) getSession();
		boolean updatedSuccessfully = false;
		Box box = null;
		String userName = "";
		if (parameterMap.get("userName") != null) {
			userName = (String) parameterMap.get("userName");
		}
		if (parameterMap.get("box") != null) {
			box = (Box) parameterMap.get("box");
		}

		int sampleCollectionId = (Integer) box.getInt("sampleCollectionId");
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			BloodSampleCollection sampleCollection = (BloodSampleCollection) hbt
					.load(BloodSampleCollection.class, sampleCollectionId);
			int employeeId = box.getInt(EMPLOYEE_ID);
			String remarks = box.getString(REMARKS);
			String accRej = box.getString(SELECTED_RADIO);
			if (employeeId != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(employeeId);
				sampleCollection.setValidatedBy(masEmployee);
			}
			sampleCollection.setSampleValidationDate(date);
			sampleCollection.setSampleValidationTime(time);
			sampleCollection.setRemarks(remarks);
			sampleCollection.setLastChgBy(userName);
			sampleCollection.setLastChgDate(date);
			sampleCollection.setLastChgTime(time);
			if(accRej.equalsIgnoreCase("y")){
			sampleCollection.setSampleStatus("V");
			}else{
				sampleCollection.setSampleStatus("R");
			}
			hbt.saveOrUpdate(sampleCollection);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		updatedSuccessfully = true;
		return updatedSuccessfully;
	}

	public Map<String, Object> getPatientDetailBloodSampleScreening(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodSampleCollection> patientDetailList = new ArrayList<BloodSampleCollection>();

		Date fromDate = new Date();
		Date toDate = new Date();
		String serviceNo = "";
		String hinNo = "";
		String patientFName = "";
		String patientLName = "";
		String adNo = "";
		String pType = "";
		int hinId = 0;
		int departmentId = 0;

		Criteria crit = null;
		Session session = (Session) getSession();

		if (mapForDs.get("serviceNo") != null) {
			serviceNo = (String) mapForDs.get("serviceNo");
		}
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}
		if (mapForDs.get("departmentId") != null) {
			departmentId = (Integer) mapForDs.get("departmentId");
		}
		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		if (mapForDs.get("patientLName") != null) {
			patientLName = (String) mapForDs.get("patientLName");
		}
		if (mapForDs.get("adNo") != null) {
			adNo = (String) mapForDs.get("adNo");
		}
		if (mapForDs.get("pType") != null) {
			pType = (String) mapForDs.get("pType");
		}
		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}

		try {
			crit = session.createCriteria(BloodSampleCollection.class).add(
					Restrictions.eq("SampleStatus", "V")).add(
					Restrictions.between("SampleValidationDate", fromDate,
							toDate));
			if (!adNo.equals("")) {
				crit = crit.createAlias("Inpatient", "ip").add(
						Restrictions.like("ip.AdNo", adNo + "%"));

				if (departmentId != 0) {
					crit = crit.createAlias("Inpatient", "ip").createAlias(
							"ip.Department", "dept").add(
							Restrictions.eq("dept.Id", departmentId));
				}
			}
			if (!serviceNo.equals("") || !hinNo.equals("")
					|| !patientFName.equals("") || !patientLName.equals("")
					|| !pType.equals("")) {
				crit = crit.createAlias("Hin", "pt");

			}
			if (!serviceNo.equals("")) {
				crit = crit.add(Restrictions.like("pt.ServiceNo", serviceNo
						+ "%"));
			}
			if (!hinNo.equals("")) {
				crit = crit.add(Restrictions.like("pt.HinNo", hinNo + "%"));
			}
			if (!patientFName.equals("")) {
				crit = crit.add(Restrictions.like("pt.PFirstName", patientFName
						+ "%"));
			}
			if (!patientLName.equals("")) {
				crit = crit.add(Restrictions.like("pt.PLastName", patientLName
						+ "%"));
			}

			if (!pType.equals("")) {
				if (pType.equals("In Patient")) {
					crit = crit.add(Restrictions.eq("pt.PatientStatus",
							"In Patient"));
				} else if (pType.equals("Out Patient")) {
					crit = crit.add(Restrictions.eq("pt.PatientStatus",
							"Out Patient"));
				}
			}
			patientDetailList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientDetailList", patientDetailList);
		return map;
	}

	public String getSampleTestSeqForDisplay(String string) {
		List<Integer> testSeqNoList = new ArrayList<Integer>();
		List<BloodSampleScreeningHeader> seqNoList = new ArrayList<BloodSampleScreeningHeader>();
		String testSeqNo = "";
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
			seqNoList = session
					.createCriteria(BloodSampleScreeningHeader.class).list();
			if (seqNoList.size() > 0) {
				for (BloodSampleScreeningHeader screeningHeader : seqNoList) {
					lastSeqNo = screeningHeader.getSampleTestNo();
				}
				StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
				while (str.hasMoreTokens()) {
					lastSeqYear = str.nextToken();
				}
			} else {
				lastSeqYear = currentYear;
			}

			testSeqNoList = session.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "STN"))
					.setProjection(
							Projections.projectionList().add(
									Projections
											.max("TransactionSequenceNumber")))
					.list();

			if (testSeqNoList.get(0) == null || testSeqNoList.size() == 0) {
				TransactionSequence tsObj = new TransactionSequence();
				tsObj.setStatus("y");
				tsObj.setTablename("BloodSampleScreeningHeader");
				tsObj.setTransactionPrefix("STN");
				tsObj.setTransactionSequenceName("SampleTest No");
				tsObj.setTransactionSequenceNumber(0);
				tsObj.setCreatedby("admin");
				tsObj.setStatus("y");
				hbt.save(tsObj);
				testSeqNo = String.valueOf(1);
			} else if (testSeqNoList.size() > 0) {
				for (Integer maxTestNo : testSeqNoList) {
					if (currentYear.equals(lastSeqYear)) {
						testSeqNo = String.valueOf(maxTestNo + 1);
					} else {
						testSeqNo = String.valueOf(1);
					}
				}
			}
			testSeqNo = testSeqNo.concat("/").concat(
					String.valueOf(lastSeqYear));
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return testSeqNo;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showBloodSampleScreening(int sampleId) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<BloodSampleCollection> sampleList = new ArrayList<BloodSampleCollection>();
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		int hinId = 0;
		Session session = (Session) getSession();

		try {
			employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).createAlias("Department",
					"dept").createAlias("dept.DepartmentType", "deptType").add(
					Restrictions.eq("deptType.Id", 24)).list();
			if (employeeList.size() > 0) {
				detailsMap.put("employeeList", employeeList);
			}

			sampleList = session.createCriteria(BloodSampleCollection.class)
					.add(Restrictions.eq("SampleStatus", "V")).add(
							Restrictions.eq("Id", sampleId)).list();
			investigationList = session
					.createCriteria(DgMasInvestigation.class).add(
							Restrictions.eq("Status", "y")).add(
							Restrictions.eq("BloodBankScreenTest", "y")).list();
			if (investigationList.size() > 0) {
				detailsMap.put("investigationList", investigationList);
			}

			if (sampleList != null && sampleList.size() > 0) {
				detailsMap.put("sampleList", sampleList);

				hinId = sampleList.get(0).getHin().getId();
				patientList = session.createCriteria(Patient.class).add(
						Restrictions.eq("Id", hinId)).list();
				if (patientList != null || patientList.size() > 0) {
					detailsMap.put("patientDetailList", patientList);
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	public String generateSampleTestNumber() {
		Map<String, Object> map = new HashMap<String, Object>();
		String testSeqNo = "";
		List<TransactionSequence> testSeqNoList = new ArrayList<TransactionSequence>();
		List<BloodSampleScreeningHeader> seqNoList = new ArrayList<BloodSampleScreeningHeader>();
		String lastSeqNo = "";
		String lastSeqYear = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		seqNoList = session.createCriteria(BloodSampleScreeningHeader.class)
				.list();
		if (seqNoList.size() > 0) {
			for (BloodSampleScreeningHeader screeningHeader : seqNoList) {
				lastSeqNo = screeningHeader.getSampleTestNo();
			}
			StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
			while (str.hasMoreTokens()) {
				lastSeqYear = str.nextToken();

			}
		} else if (lastSeqYear.equals("")) {
			lastSeqYear = currentYear;
		}
		testSeqNoList = session.createCriteria(TransactionSequence.class).add(
				Restrictions.eq("TransactionPrefix", "STN")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (testSeqNoList.size() > 0) {
			for (TransactionSequence transactionSequence : testSeqNoList) {
				TransactionSequence obj = (TransactionSequence) testSeqNoList
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
				testSeqNo = seqNo.toString().concat("/").concat(
						String.valueOf(lastSeqYear));
			}
		} else if (testSeqNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("BloodSampleScreeningHeader");
			tsObj.setTransactionPrefix("STN");
			tsObj.setTransactionSequenceName("SampleTest No");
			tsObj.setTransactionSequenceNumber(0);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");
			hbt.save(tsObj);
			testSeqNo = testSeqNo.concat("/").concat(
					String.valueOf(lastSeqYear));
		}
		return testSeqNo;
	}

	public Map<String, Object> getDetailsForSampleScreeningTest() {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();

		try {
			departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).list();
			if (departmentList.size() > 0) {
				detailsMap.put("departmentList", departmentList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return detailsMap;
	}

	public Map<String, Object> getSampleScreeningTestGrid(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodSampleCollection> patientDetailList = new ArrayList<BloodSampleCollection>();
		Date currentDate = new Date();
		Session session = (Session) getSession();
		Criteria crit = null;
		if (mapForDs.get("currentDate") != null) {
			currentDate = (Date) mapForDs.get("currentDate");
		}
		try {
			crit = session.createCriteria(BloodSampleCollection.class).add(
					Restrictions.eq("SampleStatus", "V")).add(
					Restrictions.eq("SampleValidationDate", currentDate));
			patientDetailList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientDetailList", patientDetailList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getTestName(Map<String, Object> parameterMap) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		Session session = (Session) getSession();
		String str = "";
		if (parameterMap.get("autoHint") != null) {
			str = parameterMap.get("autoHint") + "%";
		}
		try {
			Criteria c  = session
					.createCriteria(DgMasInvestigation.class).add(
							Restrictions.like("InvestigationName", str)).add(
							Restrictions.eq("Status", "y"));
			c.setFirstResult(0);
			c.setMaxResults(20);
			investigationList = c.list();
			if (investigationList.size() > 0) {
				detailsMap.put("investigationList", investigationList);
			}
		} catch (DataAccessResourceFailureException e) {
			e.printStackTrace();
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> fillItemsForInvestigationName(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();

		List investigationList = new ArrayList();
		Session session = (Session) getSession();
		String investigationName = (String) dataMap.get("investigationName");
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			investigationList = session
					.createCriteria(DgMasInvestigation.class).add(
							Restrictions.like("InvestigationName",
									investigationName)).list();
			map.put("investigationList", investigationList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean submitBloodSampleScreeningTest(Map<String, Object> infoMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		BloodSampleScreeningHeader sampleScreeningHeader = new BloodSampleScreeningHeader();
		List investigationList = new ArrayList();
		Session session = (Session) getSession();
		boolean success = false;
		@SuppressWarnings("unused")
		Box box = null;
		int componentMainIdFromRequest = 0;
		int scrneeinghdId = 0;
		int departmentId = 0;
		int hospitalId = 0;
		int hinId = 0;
		int sampleCollectionId = 0;
		String userName = "";
		String testSeqNo = "";
		Vector result = null;
		if (infoMap.get("hospitalId") != null) {
			hospitalId = (Integer) infoMap.get("hospitalId");
		}
		if (infoMap.get("departmentId") != null) {
			departmentId = (Integer) infoMap.get("departmentId");
		}
		if (infoMap.get("userName") != null) {
			userName = (String) infoMap.get("userName");
		}
		if (infoMap.get("sampleScreeningHeader") != null) {
			sampleScreeningHeader = (BloodSampleScreeningHeader) infoMap
					.get("sampleScreeningHeader");
		}
		if (infoMap.get("componentMainIdFromRequest") != null) {
			componentMainIdFromRequest = (Integer) infoMap
					.get("componentMainIdFromRequest");
		}
		if (infoMap.get("hinId") != null) {
			hinId = (Integer) infoMap.get("hinId");
		}
		if (infoMap.get("testSeqNo") != null) {
			testSeqNo = (String) infoMap.get("testSeqNo");
		}
		if (infoMap.get("sampleCollectionId") != null) {
			sampleCollectionId = (Integer) infoMap.get("sampleCollectionId");
		}
		if (infoMap.get("box") != null) {
			box = (Box) infoMap.get("box");
		}
		if (infoMap.get("result") != null) {
			result = (Vector) infoMap.get("result");
		}
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			if (infoMap.get("sampleScreeningHeader") != null) {
				sampleScreeningHeader = (BloodSampleScreeningHeader) infoMap
						.get("sampleScreeningHeader");
				hbt.save(sampleScreeningHeader);
				scrneeinghdId = sampleScreeningHeader.getId();
				map.put("scrneeinghdId", scrneeinghdId);
			} else {

				BloodSampleScreeningHeader bloodSampleScreeningHeader = new BloodSampleScreeningHeader();
				bloodSampleScreeningHeader = (BloodSampleScreeningHeader) hbt
						.load(BloodSampleScreeningHeader.class,
								componentMainIdFromRequest);
				hbt.update(bloodSampleScreeningHeader);
			}
			int sampleId = sampleScreeningHeader.getSampleCollection().getId();
			BloodSampleCollection sampleCollection = (BloodSampleCollection) hbt
					.load(BloodSampleCollection.class, sampleId);
			sampleCollection.setSampleStatus("y");
			hbt.update(sampleCollection);
			hbt.refresh(sampleCollection);

			if (infoMap.get("investigationList") != null) {
				investigationList = (List) infoMap.get("investigationList");
				if (investigationList.size() > 0) {
					for (int i = 0; i < investigationList.size(); i++) {

						BloodSampleScreeningDetail sampleScreeningDetail = new BloodSampleScreeningDetail();
						DgMasInvestigation masInvestigation = new DgMasInvestigation();

						try {
							if (investigationList.get(i) != null
									&& !investigationList.get(i).equals("")) {
								int investigationId = Integer
										.parseInt(investigationList.get(i)
												.toString());
								masInvestigation.setId(investigationId);
								sampleScreeningDetail
										.setInvestigation(masInvestigation);

								if (result != null && !result.equals("")) {
									sampleScreeningDetail
											.setResult((String) result.get(i)
													.toString());
								}

								sampleScreeningDetail.setLastChgBy(userName);
								sampleScreeningDetail.setLastChgDate(HMSUtil
										.convertStringTypeDateToDateType(date));
								sampleScreeningDetail.setLastChgTime(time);
								sampleScreeningDetail.setBloodIssued("n");
								if (infoMap.get("sampleScreeningHeader") != null) {
									sampleScreeningDetail
											.setScreenTest(sampleScreeningHeader);

								} else {
									BloodSampleScreeningHeader bloodScreeningHeader = new BloodSampleScreeningHeader();
									bloodScreeningHeader
											.setId(componentMainIdFromRequest);
									sampleScreeningDetail
											.setScreenTest(bloodScreeningHeader);
								}
							}

							hbt.save(sampleScreeningDetail);
							saved = true;

						} catch (RuntimeException e) {
							e.printStackTrace();
							saved = false;
						}

					}
				}
			}
			saved = true;
		} catch (RuntimeException e) {
			e.printStackTrace();
			saved = false;
		}
		return saved;
	}

	public Map<String, Object> getBloodIssueGrid(Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodSampleScreeningHeader> patientDetailList = new ArrayList<BloodSampleScreeningHeader>();
		Date currentDate = new Date();
		Session session = (Session) getSession();
		Criteria crit = null;
		if (mapForDs.get("currentDate") != null) {
			currentDate = (Date) mapForDs.get("currentDate");
		}
		try {
			crit = session.createCriteria(BloodSampleScreeningHeader.class)
					.add(Restrictions.eq("FitBloodIssue", "y")).add(
							Restrictions.eq("BloodIssue", "n")).add(
							Restrictions.eq("SampleTestDate", currentDate));
			patientDetailList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientDetailList", patientDetailList);
		return map;
	}

	public Map<String, Object> getDetailsForBloodIssue() {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();

		try {
			departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).list();
			if (departmentList.size() > 0) {
				detailsMap.put("departmentList", departmentList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return detailsMap;
	}

	public Map<String, Object> showStockOpeningBalance() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodMasComponent> componentList = new ArrayList<BloodMasComponent>();
		List<MasDepartment> wardList = new ArrayList<MasDepartment>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
		List<BloodOpeningStockMain> openingStockList = new ArrayList<BloodOpeningStockMain>();
		Session session = (Session) getSession();

		int hinId = 0;
		try {
			wardList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).list();
			employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).createAlias("Department",
					"dept").createAlias("dept.DepartmentType", "deptType").add(
					Restrictions.eq("deptType.Id", 24)).list();
			componentList = session.createCriteria(BloodMasComponent.class)
					.add(Restrictions.eq("Status", "y")).list();
			rankList = session.createCriteria(MasRank.class).add(
					Restrictions.eq("Status", "y")).list();
			bloodGroupList = session.createCriteria(MasBloodGroup.class).add(
					Restrictions.eq("Status", "y")).list();
			// patientList = session.createCriteria(Patient.class).list();
			openingStockList = session.createCriteria(
					BloodOpeningStockMain.class).list();
			map.put("openingStockList", openingStockList);
			/*
			 * if (patientList != null || patientList.size() > 0) {
			 * map.put("patientList", patientList); }
			 */
			map.put("bloodGroupList", bloodGroupList);
			map.put("wardList", wardList);
			map.put("employeeList", employeeList);
			map.put("componentList", componentList);
			map.put("rankList", rankList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showBloodDiscardJsp(int bloodStockDetailId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodMasComponent> componentList = new ArrayList<BloodMasComponent>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<BloodStockDetail> stockList = new ArrayList<BloodStockDetail>();
		Session session = (Session) getSession();
		Date currentDate = new Date();

		int hinId = 0;

		try {
			departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).list();
			employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).createAlias("Department",
					"dept").createAlias("dept.DepartmentType", "deptType").add(
					Restrictions.eq("deptType.Id", 24)).list();
			componentList = session.createCriteria(BloodMasComponent.class)
					.add(Restrictions.eq("Status", "y")).list();
			stockList = session.createCriteria(BloodStockDetail.class)
					.createAlias("StockMain", "main").add(
							Restrictions.le("main.ExpiryDate", currentDate))
					.add(Restrictions.eq("Id", bloodStockDetailId)).list();
			patientList = session.createCriteria(Patient.class).add(
					Restrictions.eq("Id", hinId)).list();
			if (patientList != null || patientList.size() > 0) {
				map.put("patientList", patientList);
			}
			map.put("wardList", departmentList);
			map.put("employeeList", employeeList);
			map.put("componentList", componentList);
			map.put("stockList", stockList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public String generateOpeningNumber() {
		String stockSeqNo = "";
		int stockNo = 0;
		List<TransactionSequence> seqNoList = new ArrayList<TransactionSequence>();
		List<BloodOpeningStockMain> stockSeqNoList = new ArrayList<BloodOpeningStockMain>();
		Session session = (Session) getSession();
		try {
			seqNoList = session.createCriteria(TransactionSequence.class).add(
					Restrictions.eq("TransactionPrefix", "BSN")).list();
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
				stockNo = ++seqNo;
				transactionSequenceObj.setTransactionSequenceNumber(stockNo);
				hbt.update(transactionSequenceObj);
			}
		} else if (seqNoList.size() == 0) {
			stockNo = 1;
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("BloodOpeningStockMain");
			tsObj.setTransactionPrefix("BSN");
			tsObj.setTransactionSequenceName("Stock No");
			tsObj.setTransactionSequenceNumber(stockNo);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");

			hbt.save(tsObj);
		}

		stockSeqNo = String.valueOf(stockNo);
		return stockSeqNo;
	}

	public Map<String, Object> submitStockOpeningBalance(
			Map<String, Object> infoMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		Box box = null;
		int hospitalId = 0;
		int deptId = 0;
		String userName = "";
		String stockSeqNo = "";
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");

		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		if (infoMap.get("box") != null) {
			box = (Box) infoMap.get("box");
		}
		if (infoMap.get("hospitalId") != null) {
			hospitalId = (Integer) infoMap.get("hospitalId");
		}
		if (infoMap.get("userName") != null) {
			userName = (String) infoMap.get("userName");
		}
		if (infoMap.get("deptId") != null) {
			deptId = (Integer) infoMap.get("deptId");
		}
		BloodOpeningStockMain bldOpeningStockMain = new BloodOpeningStockMain();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {

			if (hospitalId != 0) {
				MasHospital hospital = new MasHospital();
				hospital.setId(hospitalId);
				bldOpeningStockMain.setHospital(hospital);
			}

			if (deptId != 0) {
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(deptId);
				bldOpeningStockMain.setDepartment(masDepartment);
			}
			String openingNo = box.getString(STOCK_NO);
			bldOpeningStockMain.setOpeningNo(openingNo);

			int employeeId = box.getInt(EMPLOYEE_ID);
			if (employeeId != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(employeeId);
				bldOpeningStockMain.setApprovedBy(masEmployee);
			}
			String remarks = box.getString(REMARKS);
			if (remarks != null) {
				bldOpeningStockMain.setRemarks(remarks);
			}
			bldOpeningStockMain.setDate1(date);
			bldOpeningStockMain.setLastChgBy(userName);
			bldOpeningStockMain.setLastChgDate(date);
			bldOpeningStockMain.setLastChgTime(time);
			bldOpeningStockMain.setDate1(date);
			hbt.save(bldOpeningStockMain);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		try {
			Vector blood_bag_no = box.getVector(BLOOD_BAG_NO);
			Vector collection_date = box.getVector(COLLECTION_DATE);
			Vector componet_Id = box.getVector(BLOOD_COMPONENT_ID);
			Vector qty = box.getVector(QUANTITY);
			Vector hinId = box.getVector(HIN_ID);
			Vector rank_id = box.getVector(RANK_ID);
			Vector name = box.getVector(DONER_NAME);
			Vector unit_address = box.getVector(UNIT_ADDRESS);
			Vector expiry_date = box.getVector(EXPIRY_DATE);
			Vector bld_group_id = box.getVector(BLOOD_GROUP_ID);
			for (int i = 0; i < blood_bag_no.size(); i++) {
				BloodOpeningStockDetail bloodOpeningStockDetail = new BloodOpeningStockDetail();
				if (blood_bag_no.get(i) != null
						&& !blood_bag_no.get(i).equals("")) {
					bloodOpeningStockDetail.setOpeningMain(bldOpeningStockMain);

					bloodOpeningStockDetail.setBloodBagNo((String) blood_bag_no
							.get(i));

					bloodOpeningStockDetail.setName((String) name.get(i));

					if (componet_Id.get(i) != null
							&& !componet_Id.get(i).equals("")) {
						BloodMasComponent bloodMasComponent = new BloodMasComponent();
						bloodMasComponent.setId(Integer
								.parseInt((String) componet_Id.get(i)));
						bloodOpeningStockDetail.setComponent(bloodMasComponent);
					}
					bloodOpeningStockDetail.setCollectionDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(RequestConstants.COLLECTION_DATE)));
					if (qty.get(i) != null) {
						bloodOpeningStockDetail.setQty(Integer
								.parseInt((String) qty.get(i)));
					}
					if (hinId.get(i) != null && !hinId.get(i).equals("")) {
						Patient patient = new Patient();
						patient.setId(Integer.parseInt((String) hinId.get(i)));
						bloodOpeningStockDetail.setHin(patient);
					}

					if (rank_id.get(i) != null && !rank_id.get(i).equals("0")) {
						MasRank masRank = new MasRank();
						masRank
								.setId(Integer
										.parseInt((String) rank_id.get(i)));
						bloodOpeningStockDetail.setRank(masRank);
					}
					if (unit_address.get(i) != null) {
						bloodOpeningStockDetail
								.setUnitAddress((String) unit_address.get(i));
					}

					bloodOpeningStockDetail.setExpiryDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(RequestConstants.EXPIRY_DATE)));
					if (bld_group_id.get(i) != null
							&& !bld_group_id.get(i).equals("")) {
						MasBloodGroup bloodGroup = new MasBloodGroup();
						bloodGroup.setId(Integer.parseInt((String) bld_group_id
								.get(i)));
						bloodOpeningStockDetail.setBloodGroup(bloodGroup);
					}

					hbt.save(bloodOpeningStockDetail);
				}
			}
			// -Stock Table
			BloodStockMain bloodStockMain = new BloodStockMain();
			HibernateTemplate hbt1 = getHibernateTemplate();
			hbt1.setFlushModeName("FLUSH_EAGER");
			hbt1.setCheckWriteOperations(false);
			if (hospitalId != 0) {
				MasHospital hospital = new MasHospital();
				hospital.setId(hospitalId);
				bloodStockMain.setHospital(hospital);
			}

			if (deptId != 0) {
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(deptId);
				bloodStockMain.setDepartment(masDepartment);
			}

			int bloodGroupId = box.getInt(BLOOD_GROUP_ID);
			if (bloodGroupId != 0) {
				MasBloodGroup bloodGroup = new MasBloodGroup();
				bloodGroup.setId(bloodGroupId);
				bloodStockMain.setBloodGroup(bloodGroup);
			}
			int rankId = box.getInt(RANK_ID);
			if (rankId != 0) {
				MasRank masRank = new MasRank();
				masRank.setId(rankId);
				bloodStockMain.setRank(masRank);
			}
			int hinnId = box.getInt(HIN_ID);
			if (hinnId != 0) {
				Patient patient = new Patient();
				patient.setId(hinnId);
				bloodStockMain.setHin(patient);
			}
			String unitAddress = box.getString(UNIT_ADDRESS);
			if (unitAddress != null) {
				bloodStockMain.setUnitAddress(unitAddress);
			}
			String name1 = box.getString(DONER_NAME);
			if (name1 != null) {
				bloodStockMain.setName(name1);
			}
			String expDate = box.getString(EXPIRY_DATE);
			String collectionDate = box.getString(COLLECTION_DATE);
			bloodStockMain.setExpiryDate(HMSUtil
					.convertStringTypeDateToDateType(expDate));
			bloodStockMain.setCollectionDate(HMSUtil
					.convertStringTypeDateToDateType(collectionDate));
			hbt1.save(bloodStockMain);
			for (int i = 0; i < blood_bag_no.size(); i++) {
				BloodStockDetail stockDetail = new BloodStockDetail();
				if (blood_bag_no.get(i) != null
						&& !blood_bag_no.get(i).equals("")) {
					stockDetail.setStockMain(bloodStockMain);

					stockDetail.setBloodBagNo((String) blood_bag_no.get(i));
					if (componet_Id.get(i) != null
							&& !componet_Id.get(i).equals("")) {
						BloodMasComponent bloodMasComponent = new BloodMasComponent();
						bloodMasComponent.setId(Integer
								.parseInt((String) componet_Id.get(i)));
						stockDetail.setComponent(bloodMasComponent);
					}
					if (qty.get(i) != null) {
						stockDetail.setQty(Integer
								.parseInt((String) qty.get(i)));
					}
					stockDetail.setBloodIssued("n");
					hbt1.save(stockDetail);
					hbt1.refresh(stockDetail);
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		saved = true;
		// ----End-------Saving Data in stock table-----
		map.put("saved", saved);
		return map;
	}

	public List<Patient> getPateintDetail(String serviceNo) {
		Session session = (Session) getSession();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		try {
			patientList = session.createCriteria(Patient.class).add(
					Restrictions.eq("ServiceNo", serviceNo)).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return patientList;
	}

	public String getStockSeqNoForDisplay(String string) {
		int maxSeqNo = 0;
		List<Integer> seqNoList = new ArrayList<Integer>();
		String seqNo = "";
		Session session = (Session) getSession();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			seqNoList = session.createCriteria(TransactionSequence.class).add(
					Restrictions.eq("TransactionPrefix", "BSN")).setProjection(
					Projections.projectionList().add(
							Projections.max("TransactionSequenceNumber")))
					.list();
			if (seqNoList.get(0) == null || seqNoList.size() == 0) {
				TransactionSequence tsObj = new TransactionSequence();
				tsObj.setStatus("y");
				tsObj.setTablename("BloodOpeningStockMain");
				tsObj.setTransactionPrefix("BSN");
				tsObj.setTransactionSequenceName("Stock No");
				tsObj.setTransactionSequenceNumber(0);
				tsObj.setCreatedby("admin");
				tsObj.setStatus("y");
				hbt.save(tsObj);
				seqNo = String.valueOf(1);
			} else if (seqNoList.get(0) != null) {
				maxSeqNo = seqNoList.get(0);
				seqNo = String.valueOf(maxSeqNo + 1);
			} else {
				seqNo = String.valueOf(1);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return seqNo;
	}

	public Map<String, Object> getDetailsForBloodRequestEnquiry() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDonationSeqNoForDisplay(String string) {
		List<Integer> donationSeqNoList = new ArrayList<Integer>();
		List<BloodDonationEntryHeader> seqNoList = new ArrayList<BloodDonationEntryHeader>();
		String donationSeqNo = "";
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
			seqNoList = session.createCriteria(BloodDonationEntryHeader.class)
					.list();
			if (seqNoList.size() > 0) {
				for (BloodDonationEntryHeader bloodDonationEntryHeader : seqNoList) {
					lastSeqNo = bloodDonationEntryHeader.getDonationNo();
				}
				StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
				while (str.hasMoreTokens()) {
					lastSeqYear = str.nextToken();
				}
			} else {
				lastSeqYear = currentYear;
			}

			donationSeqNoList = session.createCriteria(
					TransactionSequence.class).add(
					Restrictions.eq("TransactionPrefix", "BDN")).setProjection(
					Projections.projectionList().add(
							Projections.max("TransactionSequenceNumber")))
					.list();
			if (donationSeqNoList.get(0) == null
					|| donationSeqNoList.size() == 0) {
				TransactionSequence tsObj = new TransactionSequence();
				tsObj.setStatus("y");
				tsObj.setTablename("BloodDonationEntryHeader");
				tsObj.setTransactionPrefix("BDN");
				tsObj.setTransactionSequenceName("Blood Donation No");
				tsObj.setTransactionSequenceNumber(0);
				tsObj.setCreatedby("admin");
				tsObj.setStatus("y");
				hbt.save(tsObj);
				donationSeqNo = String.valueOf(1);
			} else if (donationSeqNoList.size() > 0) {
					for (Integer maxOrderNo : donationSeqNoList) {
					if (currentYear.equals(lastSeqYear)) {
							donationSeqNo = String.valueOf(maxOrderNo + 1);
					} else {
							donationSeqNo = String.valueOf(1);
					}
				}
			}
			donationSeqNo = donationSeqNo.concat("/").concat(
					String.valueOf(currentYear));
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return donationSeqNo;
	}

	@SuppressWarnings("unchecked")
	public String generateDonationNumber() {
		Map<String, Object> map = new HashMap<String, Object>();
		String donationSeqNo = "";
		List<TransactionSequence> donationSeqNoList = new ArrayList<TransactionSequence>();
		List<BloodDonationEntryHeader> seqNoList = new ArrayList<BloodDonationEntryHeader>();
		String lastSeqNo = "";
		String lastSeqYear = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		seqNoList = session.createCriteria(BloodDonationEntryHeader.class)
				.list();
		if (seqNoList.size() > 0) {
			for (BloodDonationEntryHeader bloodDonationEntryHeader : seqNoList) {
				lastSeqNo = bloodDonationEntryHeader.getDonationNo();
			}
			StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
			while (str.hasMoreTokens()) {
				lastSeqYear = str.nextToken();

			}
		} else if (lastSeqYear.equals("")) {
			lastSeqYear = currentYear;
		}
		donationSeqNoList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "BDN")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (donationSeqNoList.size() > 0) {
			for (TransactionSequence transactionSequence : donationSeqNoList) {
				TransactionSequence obj = (TransactionSequence) donationSeqNoList
						.get(0);
				int id = obj.getId();
				int seqNo = 0;

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
				donationSeqNo = donationSeqNo.concat("/").concat(
						String.valueOf(lastSeqYear));
			}
		} else if (donationSeqNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("BloodDonationEntryHeader");
			tsObj.setTransactionPrefix("BDN");
			tsObj.setTransactionSequenceName("Blood Doantion No");
			tsObj.setTransactionSequenceNumber(0);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");
			hbt.save(tsObj);
			donationSeqNo = donationSeqNo.concat("/").concat(
					String.valueOf(lastSeqYear));
		}
		return donationSeqNo;
	}

	public boolean submitBloodDonationEntry(Map<String, Object> infoMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		BloodDonationEntryHeader donationEntryHeader = new BloodDonationEntryHeader();
		List componentList = new ArrayList();
		List qtyList = new ArrayList();
		Box box = null;
		int donationMainIdFromRequest = 0;
		int donationhdId = 0;
		int departmentId = 0;
		int hospitalId = 0;
		int hinId = 0;
		int rankId = 0;
		String userName = "";
		String donationSeqNo = "";
		Vector quantity = null;
		Vector blood_Bag_No = null;
		Vector blood_donation_detail_id = null;
		Vector expDate=null;

		if (infoMap.get("hospitalId") != null) {
			hospitalId = (Integer) infoMap.get("hospitalId");
		}
		if (infoMap.get("departmentId") != null) {
			departmentId = (Integer) infoMap.get("departmentId");
		}
		if (infoMap.get("hinId") != null) {
			hinId = (Integer) infoMap.get("hinId");
		}
		if (infoMap.get("userName") != null) {
			userName = (String) infoMap.get("userName");
		}
		if (infoMap.get("blood_Bag_No") != null) {
			blood_Bag_No = (Vector) infoMap.get("blood_Bag_No");
		}
		if (infoMap.get("quantity") != null) {
			quantity = (Vector) infoMap.get("quantity");
		}
		if (infoMap.get("expDate") != null) {
			expDate = (Vector) infoMap.get("expDate");
		}
		if (infoMap.get("blood_donation_detail_id") != null) {
			blood_donation_detail_id = (Vector) infoMap
					.get("blood_donation_detail_id");
		}
		if (infoMap.get("donationEntryHeader") != null) {
			donationEntryHeader = (BloodDonationEntryHeader) infoMap
					.get("donationEntryHeader");
		}
		if (infoMap.get("donationMainIdFromRequest") != null) {
			donationMainIdFromRequest = (Integer) infoMap
					.get("donationMainIdFromRequest");
		}
		if (infoMap.get("donationSeqNo") != null) {
			donationSeqNo = (String) infoMap.get("donationSeqNo");
		}
		if (infoMap.get("box") != null) {
			box = (Box) infoMap.get("box");
		}
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			if (infoMap.get("donationEntryHeader") != null) {
				donationEntryHeader = (BloodDonationEntryHeader) infoMap
						.get("donationEntryHeader");
				hbt.save(donationEntryHeader);
			} else {

				BloodDonationEntryHeader donationEntryHeaderObj = new BloodDonationEntryHeader();
				donationEntryHeaderObj = (BloodDonationEntryHeader) hbt.load(
						BloodDonationEntryHeader.class,
						donationMainIdFromRequest);
				hbt.update(donationEntryHeaderObj);
			}

			if (infoMap.get("componentList") != null) {
				componentList = (List) infoMap.get("componentList");
				if (componentList.size() > 0) {
					for (int i = 0; i < componentList.size(); i++) {

						BloodDonationEntryDetail donationEntryDetail = new BloodDonationEntryDetail();
						BloodMasComponent bloodMasComponent = new BloodMasComponent();

						try {
							if (componentList.get(i) != null
									&& !componentList.get(i).equals("")) {

								if (blood_Bag_No != null
										&& !blood_Bag_No.equals("")) {
									donationEntryDetail
											.setBloodBagNo((String) blood_Bag_No
													.get(i));
								}
								if (quantity != null && !quantity.equals("")) {
									donationEntryDetail
											.setQty(Integer
													.parseInt((String) quantity
															.get(i)));
								}
								if (expDate != null && !expDate.equals("")) {
									donationEntryDetail
											.setExpiryDate(HMSUtil.convertStringTypeDateToDateType((String)expDate	.get(i)));
								}
								int componentId = Integer
										.parseInt(componentList.get(i)
												.toString());
								bloodMasComponent.setId(componentId);
								donationEntryDetail
										.setComponent(bloodMasComponent);

								donationEntryDetail.setSampleScreeningTest("n");
								if (infoMap.get("donationEntryHeader") != null) {
									donationEntryDetail
											.setDonation(donationEntryHeader);
								} else {
									BloodDonationEntryHeader bldDonationEntryHeader = new BloodDonationEntryHeader();
									bldDonationEntryHeader
											.setId(donationMainIdFromRequest);
									donationEntryDetail
											.setDonation(bldDonationEntryHeader);
								}
								hbt.saveOrUpdate(donationEntryDetail);
								saved = true;
							}
						} catch (RuntimeException e) {
							e.printStackTrace();
						}

					}
				}
			}

			// ----------Saving Data in Blood Stocktables--------------

			Vector component_Id = box.getVector(BLOOD_COMPONENT_ID);
			Vector blood_bag_no = box.getVector(BLOOD_BAG_NO);
			Vector qty = box.getVector(QUANTITY);
			BloodStockMain bloodStockMain = new BloodStockMain();
			List<BloodMasComponent> bloodComponentList = new ArrayList<BloodMasComponent>();
			Session session = (Session) getSession();
			for (int j = 0; j < componentList.size(); j++) {
				int componentId = Integer.parseInt("" + component_Id.get(j));
				bloodComponentList = session.createCriteria(
						BloodMasComponent.class).add(
						Restrictions.eq("Id", componentId)).list();
			}
			if (bloodComponentList.size() > 0) {
				for (BloodMasComponent masComponent : bloodComponentList) {
					try {
						int department_Id = box.getInt(DEPARTMENT_ID);
						int hin_Id = box.getInt(HIN_ID);
						int rank_Id = box.getInt(RANK_ID);
						int blood_group_Id = box.getInt(BLOOD_GROUP_ID);
						String donor_Name = box.getString(DONER_NAME);
						String unit_address = box.getString(UNIT_ADDRESS);
						if (hospitalId != 0) {
							MasHospital hospital = new MasHospital();
							hospital.setId(hospitalId);
							bloodStockMain.setHospital(hospital);
						}
						bloodStockMain.setCollectionDate(HMSUtil
								.convertStringTypeDateToDateType(date));
						bloodStockMain.setExpiryDate(HMSUtil
								.convertStringTypeDateToDateType(date));
						if (hin_Id != 0) {
							Patient patient = new Patient();
							patient.setId(hin_Id);
							bloodStockMain.setHin(patient);
						}
						if (department_Id != 0) {
							MasDepartment department = new MasDepartment();
							department.setId(department_Id);
							bloodStockMain.setDepartment(department);
						}
						if (rank_Id != 0) {
							MasRank masRank = new MasRank();
							masRank.setId(rank_Id);
							bloodStockMain.setRank(masRank);
						}
						if (blood_group_Id != 0) {
							MasBloodGroup bloodGroup = new MasBloodGroup();
							bloodGroup.setId(blood_group_Id);
							bloodStockMain.setBloodGroup(bloodGroup);
						}
						bloodStockMain.setName(donor_Name);
						bloodStockMain.setUnitAddress(unit_address);
						hbt.save(bloodStockMain);
					} catch (DataAccessException e) {
						e.printStackTrace();
					}
					try {

						for (int i = 0; i < component_Id.size(); i++) {
							int componentId = 0;
							if (component_Id.get(i) != null
									&& !component_Id.get(i).equals("")) {
								componentId = Integer
										.parseInt((String) component_Id.get(i));
								BloodMasComponent bldMasComponent = (BloodMasComponent) session
										.createCriteria(BloodMasComponent.class)
										.add(Restrictions.eq("Id", componentId))
										.list().get(0);

								BloodStockDetail bloodStockDetail = new BloodStockDetail();
								bloodStockDetail.setStockMain(bloodStockMain);

								BloodMasComponent bloodMasComponent = new BloodMasComponent();
								bloodMasComponent
										.setId(Integer
												.parseInt((String) component_Id
														.get(i)));
								bloodStockDetail
										.setComponent(bloodMasComponent);

								bloodStockDetail.setBloodIssued("n");

								if (blood_bag_no != null
										&& !blood_bag_no.equals("")) {
									bloodStockDetail
											.setBloodBagNo((String) blood_bag_no
													.get(i));
								}
								if (quantity != null && !quantity.equals("")) {
									bloodStockDetail
											.setQty(Integer
													.parseInt((String) quantity
															.get(i)));
								}
								try {
									hbt.save(bloodStockDetail);
								} catch (RuntimeException e) {
									e.printStackTrace();
								}
							}
						}
					} catch (NumberFormatException e) {
						e.printStackTrace();
					}
				}
			}

		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return saved;
	}

	public Map<String, Object> getDetailsForDonorSampleScreening() {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();

		try {
			departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).list();
			if (departmentList.size() > 0) {
				detailsMap.put("departmentList", departmentList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return detailsMap;
	}

	public Map<String, Object> getDonorSampleScreeningGrid(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodDonationEntryDetail> patientDetailList = new ArrayList<BloodDonationEntryDetail>();
		Date currentDate = new Date();
		Session session = (Session) getSession();
		Criteria crit = null;
		if (mapForDs.get("currentDate") != null) {
			currentDate = (Date) mapForDs.get("currentDate");
		}
		try {
			crit = session.createCriteria(BloodDonationEntryDetail.class).add(
					Restrictions.eq("SampleScreeningTest", "n")).createAlias(
					"Donation", "sampleHeader")
					.add(
							Restrictions.eq("sampleHeader.CollectionDate",
									currentDate));

			patientDetailList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientDetailList", patientDetailList);
		return map;
	}

	public Map<String, Object> showDonorBloodSampleScreeningTest(int donationId) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<BloodDonationEntryDetail> doantionDetailList = new ArrayList<BloodDonationEntryDetail>();
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		int hinId = 0;
		Session session = (Session) getSession();

		try {
			employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).createAlias("Department",
					"dept").createAlias("dept.DepartmentType", "deptType").add(
					Restrictions.eq("deptType.Id", 24)).list();
			if (employeeList.size() > 0) {
				detailsMap.put("employeeList", employeeList);
			}

			doantionDetailList = session.createCriteria(
					BloodDonationEntryDetail.class).add(
					Restrictions.eq("SampleScreeningTest", "n")).createAlias(
					"Donation", "don").add(
					Restrictions.eq("don.Id", donationId)).list();
			investigationList = session
					.createCriteria(DgMasInvestigation.class).add(Restrictions.eq("Status", "y")).add(
							Restrictions.eq("BloodBankScreenTest", "y")).list();
			if (investigationList.size() > 0) {
				detailsMap.put("investigationList", investigationList);
			}

			if (doantionDetailList != null && doantionDetailList.size() > 0) {
				detailsMap.put("doantionDetailList", doantionDetailList);
				if (doantionDetailList.get(0).getDonation().getHin() != null) {
					hinId = doantionDetailList.get(0).getDonation().getHin()
							.getId();
				}
				patientList = session.createCriteria(Patient.class).add(
						Restrictions.eq("Id", hinId)).list();
				if (patientList != null || patientList.size() > 0) {
					detailsMap.put("patientDetailList", patientList);
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	public String getDonorSampleTestSeqForDisplay(String string) {
		List<Integer> testSeqNoList = new ArrayList<Integer>();
		List<BloodDonorSampleScreeningHeader> seqNoList = new ArrayList<BloodDonorSampleScreeningHeader>();
		String testSeqNo = "";
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
			seqNoList = session.createCriteria(
					BloodDonorSampleScreeningHeader.class).list();
			if (seqNoList.size() > 0) {
				for (BloodDonorSampleScreeningHeader screeningHeader : seqNoList) {
					lastSeqNo = screeningHeader.getSampleTestNo();
				}
				StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
				while (str.hasMoreTokens()) {
					lastSeqYear = str.nextToken();
				}
			} else {
				lastSeqYear = currentYear;
			}
			testSeqNoList = session.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "DSTN"))
					.setProjection(
							Projections.projectionList().add(
									Projections
											.max("TransactionSequenceNumber")))
					.list();
			if (testSeqNoList.get(0) == null || testSeqNoList.size() == 0) {
				TransactionSequence tsObj = new TransactionSequence();
				tsObj.setStatus("y");
				tsObj.setTablename("BldDoSmpScrnHd");
				tsObj.setTransactionPrefix("DSTN");
				tsObj.setTransactionSequenceName("SampleTest No");
				tsObj.setTransactionSequenceNumber(0);
				tsObj.setCreatedby("admin");
				tsObj.setStatus("y");
				hbt.save(tsObj);
				testSeqNo = String.valueOf(1);
			} else if (testSeqNoList.size() > 0) {
				for (Integer maxTestNo : testSeqNoList) {
					if (currentYear.equals(lastSeqYear)) {
						testSeqNo = String.valueOf(maxTestNo + 1);
					} else {
						testSeqNo = String.valueOf(1);
					}
				}
			}
			testSeqNo = testSeqNo.concat("/").concat(
					String.valueOf(lastSeqYear));
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return testSeqNo;
	}

	public String generateDonorSampleTestNumber() {
		Map<String, Object> map = new HashMap<String, Object>();
		String testSeqNo = "";
		List<TransactionSequence> testSeqNoList = new ArrayList<TransactionSequence>();
		List<BloodDonorSampleScreeningHeader> seqNoList = new ArrayList<BloodDonorSampleScreeningHeader>();
		String lastSeqNo = "";
		String lastSeqYear = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		seqNoList = session.createCriteria(
				BloodDonorSampleScreeningHeader.class).list();
		if (seqNoList.size() > 0) {
			for (BloodDonorSampleScreeningHeader screeningHeader : seqNoList) {
				lastSeqNo = screeningHeader.getSampleTestNo();
			}
			StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
			while (str.hasMoreTokens()) {
				lastSeqYear = str.nextToken();

			}
		} else if (lastSeqYear.equals("")) {
			lastSeqYear = currentYear;
		}
		testSeqNoList = session.createCriteria(TransactionSequence.class).add(
				Restrictions.eq("TransactionPrefix", "DSTN")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (testSeqNoList.size() > 0) {
			for (TransactionSequence transactionSequence : testSeqNoList) {
				TransactionSequence obj = (TransactionSequence) testSeqNoList
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
				testSeqNo = seqNo.toString().concat("/").concat(
						String.valueOf(lastSeqYear));
			}
		} else if (testSeqNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("BloodDonorSampleScreeningHeader");
			tsObj.setTransactionPrefix("DSTN");
			tsObj.setTransactionSequenceName("Sample Test No");
			tsObj.setTransactionSequenceNumber(0);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");
			hbt.save(tsObj);
			testSeqNo = testSeqNo.concat("/").concat(
					String.valueOf(lastSeqYear));
		}
		return testSeqNo;
	}

	// -----------------------Get -Donor Deatil For Sample
	// Screening--------------------------------
	public Map<String, Object> getDonorDetailBloodSampleScreening(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodDonationEntryDetail> patientDetailList = new ArrayList<BloodDonationEntryDetail>();
		Session session = (Session) getSession();
		String serviceNo = "";
		String hinNo = "";
		Date fromDate = new Date();
		Date toDate = new Date();
		String screeningStatus = "";
		String donationNo = "";
		String patName = "";

		int donationId = 0;
		int hinId = 0;
		Criteria crit = null;
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}
		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}
		if (mapForDs.get("serviceNo") != null) {
			serviceNo = (String) mapForDs.get("serviceNo");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		if (mapForDs.get("patName") != null) {
			patName = (String) mapForDs.get("patName");
		}
		if (mapForDs.get("screeningStatus") != null) {
			screeningStatus = (String) mapForDs.get("screeningStatus");
		}
		if (mapForDs.get("donationNo") != null) {
			donationNo = (String) mapForDs.get("donationNo");
		}
		if (mapForDs.get("donationId") != null) {
			donationId = (Integer) mapForDs.get("donationId");
		}
		try {
			crit = session.createCriteria(BloodDonationEntryDetail.class).add(
					Restrictions.eq("SampleScreeningTest", "n")).createAlias(
					"Donation", "bloodHeader").add(
					Restrictions.between("bloodHeader.CollectionDate",
							fromDate, toDate));

			if (hinNo.equals("") || serviceNo.equals("")) {
				if (!donationNo.equals("")) {

					crit = crit.add(Restrictions.like("bloodHeader.DonationNo",
							donationNo + "%"));
				}

				if (!patName.equals("")) {
					crit = crit.add(Restrictions.like("bloodHeader.DonerName",
							patName + "%"));
				}
			} else {

				if (!serviceNo.equals("")) {
					crit = crit.createAlias("bloodHeader.Hin", "pt").add(
							Restrictions.like("pt.ServiceNo", serviceNo + "%"));
				}

				if (!hinNo.equals("")) {
					crit = crit.createAlias("bloodHeader.Hin", "pt").add(
							Restrictions.like("pt.HinNo", hinNo + "%"));
				}

			}
			patientDetailList = crit.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("patientDetailList", patientDetailList);
		return map;
	}

	public boolean submitDonorBloodSampleScreeningTest(
			Map<String, Object> infoMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		BloodDonorSampleScreeningHeader donorSampleScreeningHeader = new BloodDonorSampleScreeningHeader();
		List investigationList = new ArrayList();
		List donationList = new ArrayList();
		Box box = null;
		int componentMainIdFromRequest = 0;
		int scrneeinghdId = 0;
		int departmentId = 0;
		int hospitalId = 0;
		int hinId = 0;
		String userName = "";
		String testSeqNo = "";
		Vector result = null;
		Vector donation_id = null;
		if (infoMap.get("hospitalId") != null) {
			hospitalId = (Integer) infoMap.get("hospitalId");
		}
		if (infoMap.get("departmentId") != null) {
			departmentId = (Integer) infoMap.get("departmentId");
		}
		if (infoMap.get("userName") != null) {
			userName = (String) infoMap.get("userName");
		}
		if (infoMap.get("donationList") != null) {
			donationList = (List) infoMap.get("donationList");
		}
		if (infoMap.get("donorSampleScreeningHeader") != null) {
			donorSampleScreeningHeader = (BloodDonorSampleScreeningHeader) infoMap
					.get("donorSampleScreeningHeader");
		}
		if (infoMap.get("componentMainIdFromRequest") != null) {
			componentMainIdFromRequest = (Integer) infoMap
					.get("componentMainIdFromRequest");
		}
		if (infoMap.get("hinId") != null) {
			hinId = (Integer) infoMap.get("hinId");
		}
		if (infoMap.get("testSeqNo") != null) {
			testSeqNo = (String) infoMap.get("testSeqNo");
		}
		if (infoMap.get("result") != null) {
			result = (Vector) infoMap.get("result");
		}
		if (infoMap.get("donation_id") != null) {
			donation_id = (Vector) infoMap.get("donation_id");
		}
		if (infoMap.get("box") != null) {
			box = (Box) infoMap.get("box");
		}
		int donationId = (Integer) box.getInt("donationId");
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			if (infoMap.get("donorSampleScreeningHeader") != null) {
				donorSampleScreeningHeader = (BloodDonorSampleScreeningHeader) infoMap
						.get("donorSampleScreeningHeader");
				hbt.save(donorSampleScreeningHeader);
				scrneeinghdId = donorSampleScreeningHeader.getId();
				map.put("scrneeinghdId", scrneeinghdId);
			} else {

				BloodDonorSampleScreeningHeader bloodSampleScreeningHeader = new BloodDonorSampleScreeningHeader();
				bloodSampleScreeningHeader = (BloodDonorSampleScreeningHeader) hbt
						.load(BloodDonorSampleScreeningHeader.class,
								componentMainIdFromRequest);
				hbt.update(bloodSampleScreeningHeader);
			}

			int sId = donorSampleScreeningHeader.getDonationDetail().getId();
			BloodDonationEntryDetail donationDetails = (BloodDonationEntryDetail) getHibernateTemplate()
					.load(BloodDonationEntryDetail.class, sId);
			donationDetails.setSampleScreeningTest("y");
			hbt.update(donationDetails);
			hbt.refresh(donationDetails);
			if (infoMap.get("investigationList") != null) {
				investigationList = (List) infoMap.get("investigationList");
				if (investigationList.size() > 0) {
					for (int i = 0; i < investigationList.size(); i++) {

						BloodDonorSampleScreeningDetail donorSampleScreeningDetail = new BloodDonorSampleScreeningDetail();
						DgMasInvestigation masInvestigation = new DgMasInvestigation();
						BloodDonationEntryDetail bloodDonationEntryDetail = new BloodDonationEntryDetail();

						try {
							if (investigationList.get(i) != null
									&& !investigationList.get(i).equals("")) {
								int investigationId = Integer
										.parseInt(investigationList.get(i)
												.toString());
								masInvestigation.setId(investigationId);
								donorSampleScreeningDetail
										.setInvestigation(masInvestigation);

								if (result != null && !result.equals("")) {
									donorSampleScreeningDetail
											.setResult((String) result.get(i)
													.toString());
								}
								donorSampleScreeningDetail
										.setLastChgBy(userName);
								donorSampleScreeningDetail
										.setLastChgDate(HMSUtil
												.convertStringTypeDateToDateType(date));
								donorSampleScreeningDetail.setLastChgTime(time);
								if (infoMap.get("donorSampleScreeningHeader") != null) {
									donorSampleScreeningDetail
											.setScreeningHeader(donorSampleScreeningHeader);

								} else {
									BloodDonorSampleScreeningHeader bloodScreeningHeader = new BloodDonorSampleScreeningHeader();
									bloodScreeningHeader
											.setId(componentMainIdFromRequest);
									donorSampleScreeningDetail
											.setScreeningHeader(bloodScreeningHeader);
								}
							}
							hbt.save(donorSampleScreeningDetail);
							saved = true;
						} catch (RuntimeException e) {
							e.printStackTrace();
						}

					}
				}
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return saved;
	}

	public Map<String, Object> showBloodComponentSeparationJsp() {

		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<BloodStockDetail> stockList = new ArrayList<BloodStockDetail>();
		List<BloodMasComponent> componentList = new ArrayList<BloodMasComponent>();
		stockList = session.createCriteria(BloodStockDetail.class).add(
				Restrictions.eq("BloodIssued", "n")).createAlias("Component",
				"cmt").add(Restrictions.eq("cmt.WholeBlood", "y")).add(
				Restrictions.not(Restrictions.eq("BloodIssued", "d"))).list();
		
		componentList = session.createCriteria(BloodMasComponent.class).add(
				Restrictions.eq("Status", "y")).list();
		map.put("componentList", componentList);
		map.put("stockList", stockList);
		return map;
	}

	public Map<String, Object> getBloodBagNoForAutoComplete(
			Map<String, Object> parameterMap) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<BloodStockDetail> stockList = new ArrayList<BloodStockDetail>();
		String str = "";
		if (parameterMap.get("autoHint") != null) {
			str = parameterMap.get("autoHint") + "%";
		}
		Session session = (Session) getSession();
		stockList = session.createCriteria(BloodStockDetail.class).add(
				Restrictions.like("BloodBagNo", str)).createAlias("Component",
				"cmt").add(Restrictions.eq("cmt.WholeBlood", "y")).add(
				Restrictions.eq("cmt.BloodIssued", "n")).list();

		if (stockList.size() > 0) {
			detailsMap.put("stockList", stockList);
		}

		return detailsMap;
	}

	public Map<String, Object> showBloodTestEntryJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		// List<DgMasInvestigation> investigationList = new
		// ArrayList<DgMasInvestigation>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
		List<MasRelation> relationList = new ArrayList<MasRelation>();
		Session session = (Session) getSession();

		try {
			departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).list();
			employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).createAlias("Department",
					"dept").createAlias("dept.DepartmentType", "deptType").add(
					Restrictions.eq("deptType.Id", 24)).list();

			rankList = session.createCriteria(MasRank.class).add(
					Restrictions.eq("Status", "y")).list();
			unitList = session.createCriteria(MasUnit.class).add(
					Restrictions.eq("Status", "y")).list();
			sexList = session.createCriteria(MasAdministrativeSex.class).add(
					Restrictions.eq("Status", "y")).list();
			relationList = session.createCriteria(MasRelation.class).add(
					Restrictions.eq("Status", "y")).list();
			// investigationList =
			// session.createCriteria(DgMasInvestigation.class).add(Restrictions.eq("Status",
			// "y"))
			// .list();
			
			 /* patientList = session.createCriteria(Patient.class).add(Restrictions.eq("PatientStatus","Out Patient")).list();
			  if(patientList != null || patientList.size() > 0) {
			 map.put("patientList", patientList); }*/
			
			map.put("departmentList", departmentList);
			map.put("employeeList", employeeList);
			// map.put("investigationList", investigationList);
			map.put("rankList", rankList);
			map.put("sexList", sexList);
			map.put("unitList", unitList);
			map.put("relationList", relationList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> getPatientList(String serviceNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		Session session = (Session) getSession();

		if (map.get("serviceNo") != null) {
			serviceNo = (String) map.get("serviceNo");
		}
		patientList = session.createCriteria(Patient.class).add(
				Restrictions.eq("ServiceNo", serviceNo)).list();
		if (patientList != null || patientList.size() > 0) {
			map.put("patientList", patientList);
		}
		return map;
	}

	public boolean submitBloodTestEntry(Map<String, Object> infoMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean success = false;
		boolean saved = false;
		BloodTestEntryHeader testEntryHeader = new BloodTestEntryHeader();
		List investigationList = new ArrayList();
		Box box = null;
		int componentMainIdFromRequest = 0;
		int testhdId = 0;
		int departmentId = 0;
		int hospitalId = 0;
		int hinId = 0;
		String userName = "";
		String serialSeqNo = "";
		Vector result = null;

		if (infoMap.get("hospitalId") != null) {
			hospitalId = (Integer) infoMap.get("hospitalId");
		}
		if (infoMap.get("departmentId") != null) {
			departmentId = (Integer) infoMap.get("departmentId");
		}
		if (infoMap.get("userName") != null) {
			userName = (String) infoMap.get("userName");
		}
		if (infoMap.get("testEntryHeader") != null) {
			testEntryHeader = (BloodTestEntryHeader) infoMap
					.get("testEntryHeader");
		}
		if (infoMap.get("componentMainIdFromRequest") != null) {
			componentMainIdFromRequest = (Integer) infoMap
					.get("componentMainIdFromRequest");
		}
		if (infoMap.get("hinId") != null) {
			hinId = (Integer) infoMap.get("hinId");
		}
		if (infoMap.get("serialSeqNo") != null) {
			serialSeqNo = (String) infoMap.get("serialSeqNo");
		}
		if (infoMap.get("box") != null) {
			box = (Box) infoMap.get("box");
		}
		if (infoMap.get("result") != null) {
			result = (Vector) infoMap.get("result");
		}
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			if (infoMap.get("testEntryHeader") != null) {
				testEntryHeader = (BloodTestEntryHeader) infoMap
						.get("testEntryHeader");
				hbt.save(testEntryHeader);
				testhdId = testEntryHeader.getId();
				map.put("testhdId", testhdId);
			} else {

				BloodTestEntryHeader bloodTestHeaderObj = new BloodTestEntryHeader();
				bloodTestHeaderObj = (BloodTestEntryHeader) hbt.load(
						BloodTestEntryHeader.class, componentMainIdFromRequest);
				hbt.update(bloodTestHeaderObj);
			}
			if (infoMap.get("investigationList") != null) {
				investigationList = (List) infoMap.get("investigationList");
				if (investigationList.size() > 0) {
					for (int i = 0; i < investigationList.size(); i++) {

						BloodTestEntryDetail testEntryDetail = new BloodTestEntryDetail();
						DgMasInvestigation masInvestigation = new DgMasInvestigation();
						try {
							if (investigationList.get(i) != null
									&& !investigationList.get(i).equals("0")) {
								int investigationId = Integer
										.parseInt(investigationList.get(i)
												.toString());
								masInvestigation.setId(investigationId);
								testEntryDetail
										.setInvestigation(masInvestigation);

								if (result != null && !result.equals("")) {
									testEntryDetail.setResult((String) result
											.get(i));
								}
								if (infoMap.get("testEntryHeader") != null) {
									testEntryDetail
											.setTestHeader(testEntryHeader);

								} else {
									BloodTestEntryHeader bloodTestHeader = new BloodTestEntryHeader();
									bloodTestHeader
											.setId(componentMainIdFromRequest);
									testEntryDetail
											.setTestHeader(testEntryHeader);
								}
							}
							hbt.save(testEntryDetail);
							success = true;

						} catch (RuntimeException e) {
							e.printStackTrace();
						}

					}
				}
			}
			saved = true;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return saved;
	}

	public Map<String, Object> getPatientDetailBloodIssue(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodSampleScreeningHeader> patientDetailList = new ArrayList<BloodSampleScreeningHeader>();

		Date fromDate = new Date();
		Date toDate = new Date();
		String serviceNo = "";
		String hinNo = "";
		String serPersonName = "";
		String patientFName = "";
		String patientLName = "";
		String adNo = "";
		String orderNo = "";
		String pType = "";
		int hinId = 0;
		int deptId = 0;
		int sampleId = 0;

		Criteria crit = null;
		Session session = (Session) getSession();

		if (mapForDs.get("serviceNo") != null) {
			serviceNo = (String) mapForDs.get("serviceNo");
		}
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}
		if (mapForDs.get("departmentId") != null) {
			deptId = (Integer) mapForDs.get("departmentId");
		}
		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		if (mapForDs.get("adNo") != null) {
			adNo = (String) mapForDs.get("adNo");
		}
		if (mapForDs.get("orderNo") != null) {
			orderNo = (String) mapForDs.get("orderNo");
		}
		if (mapForDs.get("pType") != null) {
			pType = (String) mapForDs.get("pType");
		}
		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}

		try {
			crit = session.createCriteria(BloodSampleScreeningHeader.class)
					.add(Restrictions.eq("BloodIssue", "n")).add(
							Restrictions.between("SampleTestDate", fromDate,
									toDate));
			if (!adNo.equals("")) {
				crit = crit.createAlias("Inpatient", "ip").add(
						Restrictions.like("ip.AdNo", adNo + "%"));

				if (deptId != 0) {
					crit = crit.createAlias("ip.Department", "dept").add(
							Restrictions.eq("dept.Id", deptId));
				}
			}
			if (!serviceNo.equals("") || !hinNo.equals("")
					|| !patientFName.equals("") || !patientLName.equals("")
					|| !pType.equals("")) {
				crit = crit.createAlias("Hin", "pt");

			}
			if (!serviceNo.equals("")) {
				crit = crit.add(Restrictions.like("pt.ServiceNo", serviceNo
						+ "%"));
			}
			if (!hinNo.equals("")) {
				crit = crit.add(Restrictions.like("pt.HinNo", hinNo + "%"));
			}
			if (!patientFName.equals("")) {
				crit = crit.add(Restrictions.like("pt.PFirstName", patientFName
						+ "%"));
			}
			if (!patientLName.equals("")) {
				crit = crit.add(Restrictions.like("pt.PLastName", patientLName
						+ "%"));
			}
			if (!pType.equals("")) {
				if (pType.equals("In Patient")) {
					crit = crit.add(Restrictions.eq("pt.PatientStatus",
							"In Patient"));
				} else if (pType.equals("Out Patient")) {
					crit = crit.add(Restrictions.eq("pt.PatientStatus",
							"Out Patient"));
				}
			}
			patientDetailList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientDetailList", patientDetailList);
		return map;
	}

	public String getBloodIssueSeqForDisplay(String string) {
		List<Integer> monthlySeqNoList = new ArrayList<Integer>();
		List<BloodIssueHeader> seqNoList = new ArrayList<BloodIssueHeader>();
		String monthlySeqNo = "";
		String lastSeqNo = "";
		String lastSeqMonth = "";

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");

		String currentMonth = date.substring(date.indexOf("/") + 1, date
				.lastIndexOf("/"));
		Session session = (Session) getSession();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			seqNoList = session.createCriteria(BloodIssueHeader.class).list();
			if (seqNoList.size() > 0) {
				for (BloodIssueHeader issueHeader : seqNoList) {
					lastSeqNo = issueHeader.getMonthlyNo();
				}
				StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
				while (str.hasMoreTokens()) {
					lastSeqMonth = str.nextToken();
				}
			}
			monthlySeqNoList = session
					.createCriteria(TransactionSequence.class).add(
							Restrictions.eq("TransactionPrefix", "MIN"))
					.setProjection(
							Projections.projectionList().add(
									Projections
											.max("TransactionSequenceNumber")))
					.list();
			if (monthlySeqNoList.get(0) == null || monthlySeqNoList.size() == 0) {
				TransactionSequence tsObj = new TransactionSequence();
				tsObj.setStatus("y");
				tsObj.setTablename("BloodIssueHeader");
				tsObj.setTransactionPrefix("MIN");
				tsObj.setTransactionSequenceName("Monthly Issue No");
				tsObj.setTransactionSequenceNumber(0);
				tsObj.setCreatedby("admin");
				tsObj.setStatus("y");
				hbt.save(tsObj);
				monthlySeqNo = String.valueOf(1);
			} else if (monthlySeqNoList.size() > 0) {
				for (Integer maxOrderNo : monthlySeqNoList) {
					if (currentMonth.equals(lastSeqMonth)) {
						monthlySeqNo = String.valueOf(maxOrderNo + 1);
					} else {
						monthlySeqNo = String.valueOf(1);
					}
				}
			}
			monthlySeqNo = monthlySeqNo.concat("/").concat(
					String.valueOf(currentMonth));
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return monthlySeqNo;
	}

	public Map<String, Object> showBloodIssueJsp(int screeningId) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<BloodSampleScreeningHeader> screeningList = new ArrayList<BloodSampleScreeningHeader>();
		List<BloodStockDetail> stockList = new ArrayList<BloodStockDetail>();
		List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
		Set<BloodMasComponent> componentList = new HashSet<BloodMasComponent>();

		int hinId = 0;
		int requestHdId = 0;
		Session session = (Session) getSession();

		try {
			employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).createAlias("Department",
					"dept").createAlias("dept.DepartmentType", "deptType").add(
					Restrictions.eq("deptType.Id", 24)).list();
			if (employeeList.size() > 0) {
				detailsMap.put("employeeList", employeeList);
			}

			bloodGroupList = session.createCriteria(MasBloodGroup.class).add(
					Restrictions.eq("Status", "y")).list();
			if (bloodGroupList.size() > 0) {
				detailsMap.put("bloodGroupList", bloodGroupList);
			}
			screeningList = session.createCriteria(
					BloodSampleScreeningHeader.class).add(
					Restrictions.eq("BloodIssue", "n")).add(
					Restrictions.eq("Id", screeningId)).list();
			if (screeningList != null && screeningList.size() > 0) {
				Set<BloodRequestEntryDetail> bloodRequestEntryDetailsSet = screeningList
						.get(0).getSampleCollection().getRequest()
						.getBloodRequestEntryDetails();
				for (BloodRequestEntryDetail bloodRequestEntryDetail : bloodRequestEntryDetailsSet) {
					componentList.add(bloodRequestEntryDetail.getComponent());

				}
			}
			// componentList =
			// session.createCriteria(BloodMasComponent.class).add(Restrictions.eq("Status",
			// "y")).list();
			detailsMap.put("componentList", componentList);

			stockList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.BloodStockDetail");
			detailsMap.put("stockList", stockList);

			if (screeningList != null && screeningList.size() > 0) {
				detailsMap.put("screeningList", screeningList);
				hinId = screeningList.get(0).getHin().getId();
				patientList = session.createCriteria(Patient.class).add(
						Restrictions.eq("Id", hinId)).list();
				if (patientList != null || patientList.size() > 0) {
					detailsMap.put("patientDetailList", patientList);
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	public String generateMonthlyNumber() {
		Map<String, Object> map = new HashMap<String, Object>();
		String monthlySeqNo = "";
		List<TransactionSequence> monthlySeqNoList = new ArrayList<TransactionSequence>();
		List<BloodIssueHeader> seqNoList = new ArrayList<BloodIssueHeader>();
		String lastSeqNo = "";
		String lastSeqMonth = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String currentMonth = date.substring(date.indexOf("/") + 1, date
				.lastIndexOf("/"));
		Session session = (Session) getSession();

		seqNoList = session.createCriteria(BloodIssueHeader.class).list();
		if (seqNoList.size() > 0) {
			for (BloodIssueHeader bloodIssueHeader : seqNoList) {
				lastSeqNo = bloodIssueHeader.getMonthlyNo();
			}
			StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
			while (str.hasMoreTokens()) {
				lastSeqMonth = str.nextToken();

			}
		}
		monthlySeqNoList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "MIN")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (monthlySeqNoList.size() > 0) {
			for (TransactionSequence transactionSequence : monthlySeqNoList) {
				TransactionSequence obj = (TransactionSequence) monthlySeqNoList
						.get(0);
				int id = obj.getId();
				int seqNo = 0;

				if (currentMonth.equals(lastSeqMonth)) {
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
				monthlySeqNo = monthlySeqNo.concat("/").concat(
						String.valueOf(currentMonth));
			}
		} else if (monthlySeqNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("BloodIssueHeader");
			tsObj.setTransactionPrefix("MIN");
			tsObj.setTransactionSequenceName("Monthly Issue No");
			tsObj.setTransactionSequenceNumber(0);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");
			hbt.save(tsObj);
			monthlySeqNo = monthlySeqNo.concat("/").concat(
					String.valueOf(currentMonth));
		}
		return monthlySeqNo;
	}

	public boolean submitBloodIssue(Map<String, Object> infoMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		Box box = null;
		BloodIssueHeader bloodIssueHeader = new BloodIssueHeader();
		List stockList = new ArrayList();
		List componentList = new ArrayList();
		Session session = (Session) getSession();

		int componentMainIdFromRequest = 0;
		int issuehdId = 0;
		int departmentId = 0;
		int hospitalId = 0;
		int hinId = 0;
		String userName = "";
		String testSeqNo = "";
		String result = "";
		if (infoMap.get("hospitalId") != null) {
			hospitalId = (Integer) infoMap.get("hospitalId");
		}
		if (infoMap.get("departmentId") != null) {
			departmentId = (Integer) infoMap.get("departmentId");
		}
		if (infoMap.get("userName") != null) {
			userName = (String) infoMap.get("userName");
		}
		if (infoMap.get("bloodIssueHeader") != null) {
			bloodIssueHeader = (BloodIssueHeader) infoMap
					.get("bloodIssueHeader");
		}
		if (infoMap.get("componentMainIdFromRequest") != null) {
			componentMainIdFromRequest = (Integer) infoMap
					.get("componentMainIdFromRequest");
		}
		if (infoMap.get("hinId") != null) {
			hinId = (Integer) infoMap.get("hinId");
		}
		if (infoMap.get("testSeqNo") != null) {
			testSeqNo = (String) infoMap.get("testSeqNo");
		}
		if (infoMap.get("box") != null) {
			box = (Box) infoMap.get("box");
		}
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		List<Inpatient> inPatientList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.Inpatient as isc where isc.AdStatus='A' and isc.Hin.Id="
								+ hinId);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			int sreeningId = (Integer) box.getInt("sreeningId");
			if (infoMap.get("bloodIssueHeader") != null) {
				bloodIssueHeader = (BloodIssueHeader) infoMap
						.get("bloodIssueHeader");
				if (inPatientList.size() > 0) {
					Inpatient inpatient = new Inpatient();
					inpatient.setId(inPatientList.get(0).getId());
					bloodIssueHeader.setInpatient(inpatient);
				}
				hbt.save(bloodIssueHeader);
				issuehdId = bloodIssueHeader.getId();
				map.put("issuehdId", issuehdId);
			} else {

				BloodIssueHeader issueHeader = new BloodIssueHeader();
				issueHeader = (BloodIssueHeader) hbt.load(
						BloodIssueHeader.class, componentMainIdFromRequest);
				hbt.update(issueHeader);
			}
			int screenHdId = bloodIssueHeader.getScreeningHd().getId();
			BloodSampleScreeningHeader sampleScreening = (BloodSampleScreeningHeader) hbt
					.load(BloodSampleScreeningHeader.class, screenHdId);
			sampleScreening.setBloodIssue("y");
			hbt.update(sampleScreening);
			hbt.refresh(sampleScreening);

			if (infoMap.get("stockList") != null) {
				stockList = (List) infoMap.get("stockList");
				if (stockList.size() > 0) {
					for (int i = 0; i < stockList.size(); i++) {

						BloodIssueDetail bloodIssueDetail = new BloodIssueDetail();
						BloodStockDetail bloodStockDetail = new BloodStockDetail();
						BloodMasComponent masComponent = new BloodMasComponent();
						try {
							if (stockList.get(i) != null
									&& !stockList.get(i).equals("")) {
								int stockDetailId = Integer.parseInt(stockList
										.get(i).toString());
								bloodStockDetail.setId(stockDetailId);
								bloodIssueDetail
										.setStockDetail(bloodStockDetail);

								if (infoMap.get("bloodIssueHeader") != null) {
									bloodIssueDetail
											.setIssueHeader(bloodIssueHeader);

								} else {
									BloodIssueHeader bloodissue = new BloodIssueHeader();
									bloodissue
											.setId(componentMainIdFromRequest);
									bloodIssueDetail.setIssueHeader(bloodissue);
								}

								hbt.save(bloodIssueDetail);

								int stockId = Integer.parseInt(stockList.get(i)
										.toString());
								BloodStockDetail stockDetail = (BloodStockDetail) getHibernateTemplate()
										.load(BloodStockDetail.class, stockId);
								stockDetail.setBloodIssued("y");
								hbt.update(stockDetail);
								hbt.refresh(stockDetail);

								saved = true;
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return saved;

	}

	public String getDiscardSeqForDisplay(String string) {
		int maxSeqNo = 0;
		List<Integer> seqNoList = new ArrayList<Integer>();
		String discardSeqNo = "";
		Session session = (Session) getSession();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			seqNoList = session.createCriteria(TransactionSequence.class).add(
					Restrictions.eq("TransactionPrefix", "DSN")).setProjection(
					Projections.projectionList().add(
							Projections.max("TransactionSequenceNumber")))
					.list();
			if (seqNoList.get(0) == null || seqNoList.size() == 0) {
				TransactionSequence tsObj = new TransactionSequence();
				tsObj.setStatus("y");
				tsObj.setTablename("BloodDiscardEntry");
				tsObj.setTransactionPrefix("DSN");
				tsObj.setTransactionSequenceName("Discard No");
				tsObj.setTransactionSequenceNumber(0);
				tsObj.setCreatedby("admin");
				tsObj.setStatus("y");
				hbt.save(tsObj);
				discardSeqNo = String.valueOf(1);
			} else if (seqNoList.size() > 0) {
				maxSeqNo = seqNoList.get(0);
				discardSeqNo = String.valueOf(maxSeqNo + 1);
			} else {
				discardSeqNo = String.valueOf(1);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return discardSeqNo;
	}

	public String generateDiscardNumber() {
		Map<String, Object> map = new HashMap<String, Object>();
		String discardSeqNo = "";
		int discardNo = 0;
		List<TransactionSequence> discardSeqNoList = new ArrayList<TransactionSequence>();
		List<BloodDiscardEntry> seqNoList = new ArrayList<BloodDiscardEntry>();
		String lastSeqNo = "";
		Session session = (Session) getSession();
		seqNoList = session.createCriteria(BloodDiscardEntry.class).list();
		if (seqNoList.size() > 0) {
			for (BloodDiscardEntry bloodDiscardEntry : seqNoList) {
				lastSeqNo = bloodDiscardEntry.getDiscardNo();
			}
		}
		discardSeqNoList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "DSN")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (discardSeqNoList.size() > 0) {
			for (TransactionSequence transactionSequence : discardSeqNoList) {
				int id = transactionSequence.getId();
				int seqNo = transactionSequence.getTransactionSequenceNumber();
				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
						.load(TransactionSequence.class, id);
				discardNo = ++seqNo;
				transactionSequenceObj.setTransactionSequenceNumber(discardNo);
				hbt.update(transactionSequenceObj);
			}
		} else if (discardSeqNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("BloodDiscardEntry");
			tsObj.setTransactionPrefix("DSN");
			tsObj.setTransactionSequenceName("Discard No");
			tsObj.setTransactionSequenceNumber(0);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");
			hbt.save(tsObj);
		}
		discardSeqNo = String.valueOf(discardNo);
		return discardSeqNo;
	}

	public boolean submitBloodDiscard(Map<String, Object> parameterMap) {
		boolean saved = false;
		BloodDiscardEntry bloodDiscardEntry = new BloodDiscardEntry();
		if (parameterMap.get("bloodDiscardEntry") != null) {
			bloodDiscardEntry = (BloodDiscardEntry) parameterMap
					.get("bloodDiscardEntry");
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(bloodDiscardEntry);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt1 = getHibernateTemplate();
			hbt1.setFlushModeName("FLUSH_EAGER");
			hbt1.setCheckWriteOperations(false);
			int stockDetailId = (Integer) parameterMap.get("stockDetailId");

			BloodStockDetail bloodStockDetail = (BloodStockDetail) hbt1.load(
					BloodStockDetail.class, stockDetailId);
			bloodStockDetail.setBloodIssued("d");
			hbt1.update(bloodStockDetail);
			hbt1.refresh(bloodStockDetail);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		saved = true;
		return saved;
	}

	public Map<String, Object> showSearchPatientForReactionJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> wardList = new ArrayList<MasDepartment>();

		Session session = (Session) getSession();

		try {
			wardList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).list();
			map.put("wardList", wardList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> searchPatientForBloodReaction(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<MasDepartment> wardList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();

		String serviceNo = "";
		String hinNo = "";
		String adNo = "";
		String patientFName = "";
		String patientLName = "";
		int hinId = 0;
		int rankId = 0;

		if (mapForDs.get("serviceNo") != null) {
			serviceNo = (String) mapForDs.get("serviceNo");
		}
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}
		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		if (mapForDs.get("patientLName") != null) {
			patientLName = (String) mapForDs.get("patientLName");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		if (mapForDs.get("adNo") != null) {
			adNo = (String) mapForDs.get("adNo");
		}
		if (mapForDs.get("rankId") != null) {
			rankId = (Integer) mapForDs.get("rankId");
		}

		try {
			Criteria crit = session.createCriteria(Inpatient.class).add(
					Restrictions.eq("AdStatus", "A"));
			if (!adNo.equals("")) {
				crit = crit.add(Restrictions.like("AdNo", adNo + "%"));
			}
			if (!serviceNo.equals("") || !hinNo.equals("") || rankId != 0
					|| !patientFName.equals("") || !patientLName.equals("")) {
				crit = crit.createAlias("Hin", "hn");

				if (!serviceNo.equals("")) {
					crit = crit.add(Restrictions.like("hn.ServiceNo", serviceNo
							+ "%"));
				}
				if (!hinNo.equals("")) {
					crit = crit.add(Restrictions.like("hn.HinNo", hinNo + "%"));
				}
				if (rankId != 0) {
					crit = crit.createAlias("hn.Rank", "rn").add(
							Restrictions.eq("rn.Id", rankId));
				}
				if (!patientFName.equals("")) {
					crit = crit.add(Restrictions.like("hn.PFirstName",
							patientFName + "%"));
				}
				if (!patientLName.equals("")) {
					crit = crit.add(Restrictions.like("hn.PLastName",
							patientLName + "%"));
				}

			}
			inpatientList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		wardList = session.createCriteria(MasDepartment.class).add(
				Restrictions.eq("Status", "y")).list();
		map.put("inpatientList", inpatientList);
		map.put("wardList", wardList);

		return map;
	}

	public Map<String, Object> showReactionFormEntryJsp(int inpatientId) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<BloodStockDetail> stockList = new ArrayList<BloodStockDetail>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
		List<MasServiceType> sevcieTypeList = new ArrayList<MasServiceType>();
		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
		List<BloodIssueHeader> issueHdList = new ArrayList<BloodIssueHeader>();
		List<BloodIssueDetail> issueDtList = new ArrayList<BloodIssueDetail>();
		Session session = (Session) getSession();

		try {
			inpatientList = session.createCriteria(Inpatient.class).add(
					Restrictions.eq("Id", inpatientId)).add(Restrictions.eq("AdStatus", "A")).list();
			if (inpatientList != null || inpatientList.size() > 0) {
				detailsMap.put("inpatientList", inpatientList);
			}
			employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y"))
			         .createAlias("Department",	"dept").createAlias("dept.DepartmentType", "deptType").add(
					Restrictions.eq("deptType.Id", 24)).list();
			if (employeeList.size() > 0) {
				detailsMap.put("employeeList", employeeList);
			}
			bloodGroupList = session.createCriteria(MasBloodGroup.class).add(
					Restrictions.eq("Status", "y")).list();
			if (bloodGroupList.size() > 0) {
				detailsMap.put("bloodGroupList", bloodGroupList);
			}
			sevcieTypeList = session.createCriteria(MasServiceType.class).add(
					Restrictions.eq("Status", "y")).list();
			if (sevcieTypeList.size() > 0) {
				detailsMap.put("sevcieTypeList", sevcieTypeList);
			}
			sexList = session.createCriteria(MasAdministrativeSex.class).add(
					Restrictions.eq("Status", "y")).list();
			if (sexList.size() > 0) {
				detailsMap.put("sexList", sexList);
			}
			stockList = session.createCriteria(BloodStockDetail.class).list();
			if (stockList.size() > 0) {
				detailsMap.put("stockList", stockList);
			}
			int issueHdId=0;
			issueHdList = session.createCriteria(BloodIssueHeader.class).add(Restrictions.eq("Inpatient.Id", inpatientId)).list();
			issueHdId = issueHdList.get(0).getId();
			issueDtList = session.createCriteria(BloodIssueDetail.class).createAlias("IssueHeader", "btd")
			        .add(Restrictions.eq("btd.Inpatient.Id", inpatientId)).list();
			
			if (issueDtList.size() > 0) {
				detailsMap.put("issueDtList", issueDtList);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	public String getEntrySeqForDisplay(String string) {
		List<Integer> orderSeqNoList = new ArrayList<Integer>();
		List<BloodReactionEntry> seqNoList = new ArrayList<BloodReactionEntry>();
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
			seqNoList = session.createCriteria(BloodReactionEntry.class).list();
			if (seqNoList.size() > 0) {
				for (BloodReactionEntry bloodReactionEntry : seqNoList) {
					lastSeqNo = bloodReactionEntry.getEntryNo();
				}
				StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
				while (str.hasMoreTokens()) {
					lastSeqYear = str.nextToken();
				}
			} else {
				lastSeqYear = currentYear;
			}
			orderSeqNoList = session.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "EN"))
					.setProjection(
							Projections.projectionList().add(
									Projections
											.max("TransactionSequenceNumber")))
					.list();
			if (orderSeqNoList.get(0) == null || orderSeqNoList.size() == 0) {
				TransactionSequence tsObj = new TransactionSequence();
				tsObj.setStatus("y");
				tsObj.setTablename("BloodReactionEntry");
				tsObj.setTransactionPrefix("EN");
				tsObj.setTransactionSequenceName("Entry No");
				tsObj.setTransactionSequenceNumber(0);
				tsObj.setCreatedby("admin");
				tsObj.setStatus("y");
				hbt.save(tsObj);
				entrySeqNo = String.valueOf(1);
			} else if (orderSeqNoList.size() > 0) {
				for (Integer maxOrderNo : orderSeqNoList) {
					if (currentYear.equals(lastSeqYear)) {
						entrySeqNo = String.valueOf(maxOrderNo + 1);
					} else {
						entrySeqNo = String.valueOf(1);
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

	@SuppressWarnings("unchecked")
	public String generateEntryNumber() {
		Map<String, Object> map = new HashMap<String, Object>();
		String entrySeqNo = "";
		List<TransactionSequence> orderSeqNoList = new ArrayList<TransactionSequence>();
		List<BloodReactionEntry> seqNoList = new ArrayList<BloodReactionEntry>();
		String lastSeqNo = "";
		String lastSeqYear = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		seqNoList = session.createCriteria(BloodReactionEntry.class).list();
		if (seqNoList.size() > 0) {
			for (BloodReactionEntry bloodReactionEntry : seqNoList) {
				lastSeqNo = bloodReactionEntry.getEntryNo();

			}
			StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
			while (str.hasMoreTokens()) {
				lastSeqYear = str.nextToken();

			}
		} else if (lastSeqYear.equals("")) {
			lastSeqYear = currentYear;
		}
		orderSeqNoList = session.createCriteria(TransactionSequence.class).add(
				Restrictions.eq("TransactionPrefix", "EN")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (orderSeqNoList.size() > 0) {
			for (TransactionSequence transactionSequence : orderSeqNoList) {
				TransactionSequence obj = (TransactionSequence) orderSeqNoList
						.get(0);
				int id = obj.getId();
				int seqNo = 0;

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
				entrySeqNo = entrySeqNo.concat("/").concat(
						String.valueOf(lastSeqYear));
			}
		} else if (orderSeqNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("BloodReactionEntry");
			tsObj.setTransactionPrefix("EN");
			tsObj.setTransactionSequenceName("Entry No");
			tsObj.setTransactionSequenceNumber(0);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");
			hbt.save(tsObj);
			entrySeqNo = entrySeqNo.concat("/").concat(
					String.valueOf(lastSeqYear));
		}
		return entrySeqNo;
	}

	public boolean submitBloodReactionEntry(BloodReactionEntry bldReactionEntry) {
		boolean saved = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(bldReactionEntry);
		saved = true;
		return saved;
	}

	public Map<String, Object> showDirectIndirectRegisterReport() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		investigationList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.DgMasInvestigation as md where md.Status = 'y'");
		map.put("investigationList", investigationList);
		return map;
	}

	public String getSerialSeqForDisplay(String string) {
		List<Integer> serialSeqNoList = new ArrayList<Integer>();
		List<BloodTestEntryHeader> seqNoList = new ArrayList<BloodTestEntryHeader>();
		String serialSeqNo = "";
		String lastSeqNo = "";
		String lastSeqMonth = "";

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");

		String currentMonth = date.substring(date.indexOf("/") + 1, date
				.lastIndexOf("/"));
		Session session = (Session) getSession();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			seqNoList = session.createCriteria(BloodTestEntryHeader.class)
					.list();
			if (seqNoList.size() > 0) {
				for (BloodTestEntryHeader bloodTestEntryHeader : seqNoList) {
					lastSeqNo = bloodTestEntryHeader.getSerialNo();
				}
				StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
				while (str.hasMoreTokens()) {
					str.nextToken();
					lastSeqMonth = str.nextToken();
				}
			}

			serialSeqNoList = session.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "TSN"))
					.setProjection(
							Projections.projectionList().add(
									Projections
											.max("TransactionSequenceNumber")))
					.list();
			if (serialSeqNoList.get(0) == null || serialSeqNoList.size() == 0) {
				TransactionSequence tsObj = new TransactionSequence();
				tsObj.setStatus("y");
				tsObj.setTablename("BloodReactionEntry");
				tsObj.setTransactionPrefix("TSN");
				tsObj.setTransactionSequenceName("Serial No");
				tsObj.setTransactionSequenceNumber(0);
				tsObj.setCreatedby("admin");
				tsObj.setStatus("y");
				hbt.save(tsObj);
				serialSeqNo = String.valueOf(1);
			} else if (serialSeqNoList.size() > 0) {
				for (Integer maxOrderNo : serialSeqNoList) {
					if (currentMonth.equals(lastSeqMonth)) {
						serialSeqNo = String.valueOf(maxOrderNo + 1);
					} else {
						serialSeqNo = String.valueOf(1);
					}
				}
			}

			serialSeqNo = serialSeqNo.concat("/").concat(
					String.valueOf(currentMonth));
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return serialSeqNo;
	}

	public String generateSerialNumber() {
		Map<String, Object> map = new HashMap<String, Object>();
		String serialSeqNo = "";
		List<TransactionSequence> monthlySeqNoList = new ArrayList<TransactionSequence>();
		List<BloodTestEntryHeader> seqNoList = new ArrayList<BloodTestEntryHeader>();
		String lastSeqNo = "";
		String lastSeqMonth = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String currentMonth = date.substring(date.indexOf("/") + 1, date
				.lastIndexOf("/"));
		Session session = (Session) getSession();

		seqNoList = session.createCriteria(BloodTestEntryHeader.class).list();
		if (seqNoList.size() > 0) {
			for (BloodTestEntryHeader bloodTestEntryHeader : seqNoList) {
				lastSeqNo = bloodTestEntryHeader.getSerialNo();
			}
			StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
			while (str.hasMoreTokens()) {
				lastSeqMonth = str.nextToken();

			}
		}
		monthlySeqNoList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "TSN")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (monthlySeqNoList.size() > 0) {
			for (TransactionSequence transactionSequence : monthlySeqNoList) {
				TransactionSequence obj = (TransactionSequence) monthlySeqNoList
						.get(0);
				int id = obj.getId();
				int seqNo = 0;

				if (currentMonth.equals(lastSeqMonth)) {
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
				serialSeqNo = serialSeqNo.concat("/").concat(
						String.valueOf(currentMonth));
			}
		} else if (monthlySeqNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("BloodTestEntryHeader");
			tsObj.setTransactionPrefix("TSN");
			tsObj.setTransactionSequenceName("Serial No");
			tsObj.setTransactionSequenceNumber(0);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");
			hbt.save(tsObj);
			serialSeqNo = serialSeqNo.concat("/").concat(
					String.valueOf(currentMonth));
		}
		return serialSeqNo;
	}

	public Map<String, Object> getDBConnection() {
		Map<String, Object> connectionMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		connectionMap.put("con", con);
		return connectionMap;
	}

	public Map<String, Object> fillPatientDetail(Map map) {

		Session session = (Session) getSession();
		List<Patient> patientList = new ArrayList<Patient>();
		@SuppressWarnings("unused")
		int deptId = 0;
		try {
			String str = "" + map.get("serviceNo");
			Criteria c = session.createCriteria(Patient.class).add(
					Restrictions.eq("ServiceNo", str));
			patientList = c.list();
			map.put("patientList", patientList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	public Map<String, Object> showPatientSearchForDonationJsp() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Object> getPatientForUpdateDonation(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodDonationEntryHeader> donorList = new ArrayList<BloodDonationEntryHeader>();
		Criteria crit = null;

		String serviceNo = "";
		String donationNo = "";
		String donorName = "";
		int hinId = 0;

		Session session = (Session) getSession();
		if (mapForDs.get("donationNo") != null) {
			donationNo = (String) mapForDs.get("donationNo");
		}
		if (mapForDs.get("serviceNo") != null) {
			serviceNo = (String) mapForDs.get("serviceNo");
		}

		if (mapForDs.get("donorName") != null) {
			donorName = (String) mapForDs.get("donorName");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		try {
			crit = session.createCriteria(BloodDonationEntryHeader.class).add(
					Restrictions.eq("SampleScreening", "n"));

			if (!serviceNo.equals("") || hinId != 0)
				crit = crit.createAlias("Hin", "hn");
			if (!serviceNo.equals("")) {
				crit = crit.add(Restrictions.like("hn.ServiceNo", serviceNo
						+ "%"));
			}
			if (hinId != 0) {
				if (!donorName.equals("")) {
					crit = crit.add(Restrictions.like("hn.PFirstName",
							donorName + "%"));
				}
			}
			if (!donorName.equals("")) {
				crit = crit
						.add(Restrictions.like("DonerName", donorName + "%"));
			}
			if (!donationNo.equals("")) {
				crit = crit.add(Restrictions.like("DonationNo", donationNo
						+ "%"));
			}

			donorList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("donorList", donorList);
		return map;
	}

	public Map<String, Object> showUpdateDonationEntry(int bloodDonationId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<BloodDonationEntryHeader> donorList = new ArrayList<BloodDonationEntryHeader>();
		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
		List<MasState> stateList = new ArrayList<MasState>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasOccupation> occupationList = new ArrayList<MasOccupation>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();

		sexList = session.createCriteria(MasAdministrativeSex.class).add(
				Restrictions.eq("Status", "y")).list();
		stateList = session.createCriteria(MasState.class).add(
				Restrictions.eq("Status", "y")).list();
		donorList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.BloodDonationEntryHeader as bld where bld.Id="
						+ bloodDonationId + " ");
		rankList = session.createCriteria(MasRank.class).add(
				Restrictions.eq("Status", "y")).list();
		occupationList = session.createCriteria(MasOccupation.class).add(
				Restrictions.eq("Status", "y")).list();
		employeeList = session.createCriteria(MasEmployee.class).add(
				Restrictions.eq("Status", "y")).createAlias("Department",
				"dept").createAlias("dept.DepartmentType", "deptType").add(
				Restrictions.eq("deptType.Id", 24)).list();
		bloodGroupList = session.createCriteria(MasBloodGroup.class).add(
				Restrictions.eq("Status", "y")).list();

		map.put("sexList", sexList);
		map.put("bloodGroupList", bloodGroupList);
		map.put("employeeList", employeeList);
		map.put("stateList", stateList);
		map.put("rankList", rankList);
		map.put("occupationList", occupationList);
		map.put("donorList", donorList);
		return map;
	}

	public Map<String, Object> showPopUpBloodIssueJsp(Map<String, Object> map) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		int bloodComponentId = 0;
		if (map.get("bloodComponentId") != null) {
			bloodComponentId = (Integer) map.get("bloodComponentId");
		}
		List<BloodStockDetail> stocktList = new ArrayList<BloodStockDetail>();
		stocktList = session.createCriteria(BloodStockDetail.class)
				.createAlias("StockMain", "s").add(
						Restrictions.eq("BloodIssued", "n")).add(
						Restrictions.eq("Component.Id", bloodComponentId))
				.addOrder(Order.desc("s.ExpiryDate")).list();
		dataMap.put("stockList", stocktList);
		return dataMap;
	}

	public Map<String, Object> showUpdateReactonEntry(int reactionId) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<BloodReactionEntry> reactionList = new ArrayList<BloodReactionEntry>();
		List<BloodStockDetail> stockList = new ArrayList<BloodStockDetail>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
		List<MasServiceType> sevcieTypeList = new ArrayList<MasServiceType>();
		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
		Session session = (Session) getSession();

		try {
			employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).createAlias("Department",
					"dept").createAlias("dept.DepartmentType", "deptType").add(
					Restrictions.eq("deptType.Id", 24)).list();
			if (employeeList.size() > 0) {
				detailsMap.put("employeeList", employeeList);
			}
			bloodGroupList = session.createCriteria(MasBloodGroup.class).add(
					Restrictions.eq("Status", "y")).list();
			if (bloodGroupList.size() > 0) {
				detailsMap.put("bloodGroupList", bloodGroupList);
			}
			sevcieTypeList = session.createCriteria(MasServiceType.class).add(
					Restrictions.eq("Status", "y")).list();
			if (sevcieTypeList.size() > 0) {
				detailsMap.put("sevcieTypeList", sevcieTypeList);
			}
			sexList = session.createCriteria(MasAdministrativeSex.class).add(
					Restrictions.eq("Status", "y")).list();
			if (sexList.size() > 0) {
				detailsMap.put("sexList", sexList);
			}
			stockList = session.createCriteria(BloodStockDetail.class).list();
			if (stockList.size() > 0) {
				detailsMap.put("stockList", stockList);
			}
			reactionList = session.createCriteria(BloodReactionEntry.class)
					.add(Restrictions.eq("Id", reactionId)).list();
			if (reactionList != null || reactionList.size() > 0) {
				detailsMap.put("reactionList", reactionList);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	public Map<String, Object> searchPatientForUpdateReaction(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodReactionEntry> reactionList = new ArrayList<BloodReactionEntry>();
		Criteria crit = null;

		String serviceNo = "";
		String entryNo = "";
		String patientName = "";
		int hinId = 0;

		Session session = (Session) getSession();

		if (mapForDs.get("serviceNo") != null) {
			serviceNo = (String) mapForDs.get("serviceNo");
		}
		String hinNo = "";
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}
		if (mapForDs.get("entryNo") != null) {
			entryNo = (String) mapForDs.get("entryNo");
		}
		if (mapForDs.get("patientName") != null) {
			patientName = (String) mapForDs.get("patientName");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		try {
			crit = session.createCriteria(BloodReactionEntry.class).add(
					Restrictions.eq("Screening", "n"));
			if (!entryNo.equals("")) {
				crit = crit.add(Restrictions.like("EntryNo", entryNo + "%"));
			}
			if (!serviceNo.equals("") || !hinNo.equals("")
					|| !patientName.equals(""))
				crit = crit.createAlias("Hin", "hn");

			if (!serviceNo.equals("")) {
				crit = crit.add(Restrictions.like("hn.ServiceNo", serviceNo
						+ "%"));
			}
			if (!hinNo.equals("")) {
				crit = crit.add(Restrictions.like("hn.HinNo", hinNo + "%"));
			}
			if (hinId != 0) {
				if (!patientName.equals("")) {
					crit = crit.add(Restrictions.like("hn.PFirstName",
							patientName + "%"));
				}
			} else {
				crit = crit.add(Restrictions.like("DonorName", patientName
						+ "%"));
			}

			reactionList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("reactionList", reactionList);
		return map;
	}

	public boolean updateBloodReaction(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String caseTypeName = "";
		@SuppressWarnings("unused")
		String caseTypeCode = "";
		int blooReactionId = 0;
		Date reactionDate = new Date();
		Date issuedDate = new Date();
		Date dateTransfussion = new Date();

		String changedBy = "";
		String date = "";
		String time = "";
		String issuedTime = "";
		String donorName = "";
		String issuedTo = "";
		String entrySeqNo = "";
		String pyrexia = "";
		String itching = "";
		String urticarla = "";
		String elseWehere = "";
		String painBack = "";
		String head = "";
		String chest = "";
		String jaundice = "";
		String anaphylaxia = "";
		String fallOfBp = "";
		String rigor = "";
		String riseTemp = "";
		String haemoglobinuria = "";
		String timeCompleted = "";
		String anuria = "";
		String bloodBagNo = "";
		String tempTransfussion = "";
		String wdNo = "";
		String timeStarted = "";
		String untowardReaction = "";
		String userName = "";

		int hinId = 0;
		int inpatientId = 0;
		int issuedBy = 0;
		int crossMatchedBy = 0;
		int stockDetailId = 0;
		int bloodGroupId = 0;
		blooReactionId = (Integer) generalMap.get("blooReactionId");
		reactionDate = (Date) generalMap.get("currentDate");
		issuedDate = (Date) generalMap.get("currentDate");
		dateTransfussion = (Date) generalMap.get("currentDate");
		time = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");

		changedBy = (String) generalMap.get("changedBy");
		hinId = (Integer) generalMap.get("hinId");
		inpatientId = (Integer) generalMap.get("inpatientId");
		issuedBy = (Integer) generalMap.get("issuedBy");
		crossMatchedBy = (Integer) generalMap.get("crossMatchedBy");
		bloodGroupId = (Integer) generalMap.get("bloodGroupId");
		issuedTime = (String) generalMap.get("issuedTime");
		donorName = (String) generalMap.get("donorName");
		issuedTo = (String) generalMap.get("issuedTo");
		entrySeqNo = (String) generalMap.get("entrySeqNo");
		pyrexia = (String) generalMap.get("pyrexia");
		itching = (String) generalMap.get("itching");
		urticarla = (String) generalMap.get("urticarla");
		elseWehere = (String) generalMap.get("elseWehere");
		painBack = (String) generalMap.get("painBack");
		head = (String) generalMap.get("head");
		chest = (String) generalMap.get("chest");
		jaundice = (String) generalMap.get("jaundice");
		anaphylaxia = (String) generalMap.get("anaphylaxia");
		fallOfBp = (String) generalMap.get("fallOfBp");
		rigor = (String) generalMap.get("rigor");
		riseTemp = (String) generalMap.get("riseTemp");
		haemoglobinuria = (String) generalMap.get("haemoglobinuria");
		timeCompleted = (String) generalMap.get("timeCompleted");
		anuria = (String) generalMap.get("anuria");
		bloodBagNo = (String) generalMap.get("bloodBagNo");
		tempTransfussion = (String) generalMap.get("tempTransfussion");
		wdNo = (String) generalMap.get("wdNo");
		timeStarted = (String) generalMap.get("timeStarted");
		untowardReaction = (String) generalMap.get("untowardReaction");
		userName = (String) generalMap.get("userName");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("time");

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		BloodReactionEntry bloodReactionEntry = (BloodReactionEntry) getHibernateTemplate()
				.get(BloodReactionEntry.class, blooReactionId);
		bloodReactionEntry.setEntryNo(entrySeqNo);
		bloodReactionEntry.setRactionDate(currentDate);

		if (hinId != 0) {
			Patient patient = new Patient();
			patient.setId(hinId);
			bloodReactionEntry.setHin(patient);
		}
		if (inpatientId != 0) {
			Inpatient inpatient = new Inpatient();
			inpatient.setId(inpatientId);
			bloodReactionEntry.setInpatient(inpatient);
		}

		bloodReactionEntry.setBloodBagNo(bloodBagNo);
		bloodReactionEntry.setIssuedTo(issuedTo);
		bloodReactionEntry.setIssuedDate(currentDate);
		bloodReactionEntry.setIssuedTime(issuedTime);
		bloodReactionEntry.setDonorName(donorName);
		if (bloodGroupId != 0) {
			MasBloodGroup masBloodGroup = new MasBloodGroup();
			masBloodGroup.setId(bloodGroupId);
			bloodReactionEntry.setBloodGroup(masBloodGroup);
		}
		if (crossMatchedBy != 0) {
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(crossMatchedBy);
			bloodReactionEntry.setCrossMatchedBy(masEmployee);
		}

		bloodReactionEntry.setIssuedTo(issuedTo);
		if (issuedBy != 0) {
			MasEmployee masEmployee1 = new MasEmployee();
			masEmployee1.setId(issuedBy);
			bloodReactionEntry.setIssuedBy(masEmployee1);
		}
		bloodReactionEntry.setWdNo(wdNo);
		bloodReactionEntry.setTransfussion(tempTransfussion);
		bloodReactionEntry.setDateTransfussion(currentDate);
		bloodReactionEntry.setTimeStarted(timeStarted);
		bloodReactionEntry.setTimeCompleted(timeCompleted);
		bloodReactionEntry.setPyrexia(pyrexia);
		bloodReactionEntry.setRigor(rigor);
		bloodReactionEntry.setRiseTemp(riseTemp);
		bloodReactionEntry.setFallOfBp(fallOfBp);
		bloodReactionEntry.setItching(itching);
		bloodReactionEntry.setUrticarla(urticarla);
		bloodReactionEntry.setAnaphylaxia(anaphylaxia);
		bloodReactionEntry.setPainBack(painBack);
		bloodReactionEntry.setHead(head);
		bloodReactionEntry.setChest(chest);
		bloodReactionEntry.setElseWehere(elseWehere);
		bloodReactionEntry.setJaundice(jaundice);
		bloodReactionEntry.setAnuria(anuria);
		bloodReactionEntry.setHaemoglobinuria(haemoglobinuria);
		bloodReactionEntry.setUntowardReaction(untowardReaction);
		bloodReactionEntry.setLastChgBy(userName);
		bloodReactionEntry.setLastChgDate(currentDate);
		bloodReactionEntry.setLastChgTime(time);

		hbt.update(bloodReactionEntry);
		dataUpdated = true;
		return dataUpdated;
	}

	public Map<String, Object> showPendingForTransfussionReaction() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();

		Session session = (Session) getSession();

		try {
			rankList = session.createCriteria(MasRank.class).add(
					Restrictions.eq("Status", "y")).list();
			map.put("rankList", rankList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> searchPatientForTransfussionReaction(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodReactionEntry> reactionList = new ArrayList<BloodReactionEntry>();
		Criteria crit = null;

		String bloodBagNo = "";
		String entryNo = "";
		String patientLName = "";
		String patientFName = "";
		String reactionDate = "";
		int hinId = 0;
		int rankId = 0;
		String donorName = "";
		Session session = (Session) getSession();

		if (mapForDs.get("bloodBagNo") != null) {
			bloodBagNo = (String) mapForDs.get("bloodBagNo");
		}
		if (mapForDs.get("entryNo") != null) {
			entryNo = (String) mapForDs.get("entryNo");
		}
		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		if (mapForDs.get("patientLName") != null) {
			patientLName = (String) mapForDs.get("patientLName");
		}
		if (mapForDs.get("donorName") != null) {
			donorName = (String) mapForDs.get("donorName");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}

		try {
			crit = session.createCriteria(BloodReactionEntry.class).add(
					Restrictions.eq("Screening", "n"));

			if (!patientFName.equals("") || !patientLName.equals("")) {
				crit = crit.createAlias("Hin", "hn");
			}
			if (!bloodBagNo.equals("")) {
				crit = crit.add(Restrictions.like("BloodBagNo", bloodBagNo
						+ "%"));
			}
			if (!entryNo.equals("")) {
				crit = crit.add(Restrictions.like("EntryNo", entryNo + "%"));
			}
			if (hinId != 0) {
				if (!patientFName.equals("")) {
					crit = crit.add(Restrictions.like("hn.PFirstName",
							patientFName + "%"));
				}
				if (!patientLName.equals("")) {
					crit = crit.add(Restrictions.like("hn.PLastName",
							patientLName + "%"));
				}
			}
			if (!donorName.equals("")) {
				crit = crit
						.add(Restrictions.like("DonorName", donorName + "%"));
			}

			reactionList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("reactionList", reactionList);
		return map;
	}

	public String getTransfussionTestSeqForDisplay(String string) {
		int maxSeqNo = 0;
		List<Integer> seqNoList = new ArrayList<Integer>();
		String seqNo = "";
		Session session = (Session) getSession();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			seqNoList = session.createCriteria(TransactionSequence.class).add(
					Restrictions.eq("TransactionPrefix", "TRN")).setProjection(
					Projections.projectionList().add(
							Projections.max("TransactionSequenceNumber")))
					.list();
			if (seqNoList.get(0) == null || seqNoList.size() == 0) {
				TransactionSequence tsObj = new TransactionSequence();
				tsObj.setStatus("y");
				tsObj.setTablename("BloodTransfussionReactionHd");
				tsObj.setTransactionPrefix("TRN");
				tsObj.setTransactionSequenceName("Test No");
				tsObj.setTransactionSequenceNumber(0);
				tsObj.setCreatedby("admin");
				tsObj.setStatus("y");
				hbt.save(tsObj);
				seqNo = String.valueOf(1);
			} else if (seqNoList.get(0) != null) {
				maxSeqNo = seqNoList.get(0);
				seqNo = String.valueOf(maxSeqNo + 1);
			} else {
				seqNo = String.valueOf(1);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return seqNo;
	}

	public Map<String, Object> showTransfussionReaction(int bloodReactionId) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<BloodReactionEntry> reactionList = new ArrayList<BloodReactionEntry>();
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		int hinId = 0;
		Session session = (Session) getSession();

		try {
			employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).createAlias("Department",
					"dept").createAlias("dept.DepartmentType", "deptType").add(
					Restrictions.eq("deptType.Id", 24)).list();
			if (employeeList.size() > 0) {
				detailsMap.put("employeeList", employeeList);
			}

			reactionList = session.createCriteria(BloodReactionEntry.class)
					.add(Restrictions.eq("Screening", "n")).add(
							Restrictions.eq("Id", bloodReactionId)).list();
			if (reactionList != null) {
				detailsMap.put("reactionList", reactionList);
			}

			investigationList = session
					.createCriteria(DgMasInvestigation.class).add(
							Restrictions.eq("Status", "y")).add(
							Restrictions.eq("BloodReactionTest", "y")).list();
			if (investigationList.size() > 0) {
				detailsMap.put("investigationList", investigationList);
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	public Map<String, Object> fillDonorDetail(Map map) {

		Session session = (Session) getSession();
		List<Patient> patientList = new ArrayList<Patient>();
		@SuppressWarnings("unused")
		int deptId = 0;
		try {
			String str = "" + map.get("hinNo");
			Criteria c = session.createCriteria(Patient.class).add(
					Restrictions.eq("HinNo", str));
			patientList = c.list();
			map.put("patientList", patientList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;

	}
	
	public boolean submitPopbloodIssue(int stockDetailId,
			Map<String, Object> generalMap) {
		boolean saved = false;
		BloodStockDetail stockDetail = new BloodStockDetail();
		stockDetail = (BloodStockDetail) getHibernateTemplate().get(
				BloodStockDetail.class, stockDetailId);

		stockDetail.setBloodIssued("y");

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(stockDetail);
		saved = true;
		return saved;
	}

	public boolean updateBloodDonation(Box box) {
		boolean successfullyAdded = false;
		Session session = (Session) getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			List<BloodDonationEntryHeader> donationHdList = session
					.createCriteria(BloodDonationEntryHeader.class).add(
							Restrictions.eq("Id", box.getInt("donationhdId")))
					.list();
			BloodDonationEntryHeader bonationEntryHeaderObj = (BloodDonationEntryHeader) donationHdList
					.get(0);
			int donationHdId = bonationEntryHeaderObj.getId();
			BloodDonationEntryHeader donationEntryHeader = (BloodDonationEntryHeader) hbt
					.load(BloodDonationEntryHeader.class, box
							.getInt("donationhdId"));

			if (box.getString("donerName") != null
					&& !box.getString("donerName").equals(""))
				donationEntryHeader.setDonerName(box.getString("donerName"));

			if (box.getString("fatherName") != null
					&& !box.getString("fatherName").equals(""))
				donationEntryHeader.setFatherName(box.getString("fatherName"));

			if (box.getString("husbandName") != null
					&& !box.getString("husbandName").equals(""))
				donationEntryHeader.setHusbandName("husbandName");

			MasOccupation masOccupation = new MasOccupation();
			if (box.getString("occupationId") != null
					&& !box.getString("occupationId").equals("")) {
				masOccupation.setId(Integer.parseInt(box
						.getString("occupationId")));
				donationEntryHeader.setOccupation(masOccupation);
			}
			if (box.getString("organization") != null
					&& !box.getString("organization").equals(""))
				donationEntryHeader.setOrganization(box
						.getString("organization"));

			MasRank masRank = new MasRank();
			if (box.getString("rankId") != null
					&& !box.getString("rankId").equals("")) {
				masRank.setId(Integer.parseInt(box.getString("rankId")));
				donationEntryHeader.setRank(masRank);
			}
			/*
			 * MasAdministrativeSex administrativeSex = new
			 * MasAdministrativeSex(); if (box.getString("sexId") != null &&
			 * !box.getString("sexId").equals(""))
			 * administrativeSex.setId(Integer
			 * .parseInt(box.getString("sexId")));
			 * donationEntryHeader.setSex(administrativeSex);
			 */

			if (box.getString("age") != null
					&& !box.getString("age").equals(""))
				donationEntryHeader.setAge(box.getString("age"));

			if (box.getString("unitAddress") != null
					&& !box.getString("unitAddress").equals(""))
				donationEntryHeader
						.setUnitAddress(box.getString("unitAddress"));

			if (box.getString("teleNo") != null
					&& !box.getString("teleNo").equals(""))
				donationEntryHeader.setTelNo(box.getString("teleNo"));

			if (box.getString("mobilNo") != null
					&& !box.getString("mobilNo").equals(""))
				donationEntryHeader.setMobNo(box.getString("mobilNo"));

			MasState state = new MasState();
			if (box.getString("stateId") != null
					&& !box.getString("stateId").equals("")) {
				state.setId(Integer.parseInt(box.getString("stateId")));
				donationEntryHeader.setState(state);
			}
			MasAdministrativeSex sex = new MasAdministrativeSex();
			if (box.getString("sexId") != null
					&& !box.getString("sexId").equals("")) {
				sex.setId(Integer.parseInt(box.getString("sexId")));
				donationEntryHeader.setSex(sex);
			}
			MasBloodGroup masBloodGroup = new MasBloodGroup();
			if (box.getString("bloodGroupId") != null
					&& !box.getString("bloodGroupId").equals("")) {
				masBloodGroup.setId(Integer.parseInt(box
						.getString("bloodGroupId")));
				donationEntryHeader.setBloodGroup(masBloodGroup);
			}
			if (box.getString("previoulsyDonated") != null
					&& !box.getString("previoulsyDonated").equals(""))
				donationEntryHeader.setPreviouslyDonated("previoulsyDonated");

			if (box.getString("lastDonatedDate") != null
					&& !box.getString("lastDonatedDate").equals(""))
				donationEntryHeader.setLastDonated(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("lastDonatedDate")));

			if (box.getString("discomfort") != null
					&& !box.getString("discomfort").equals(""))
				donationEntryHeader.setDiscomfort(box.getString("discomfort"));

			if (box.getString("wellToday") != null
					&& !box.getString("wellToday").equals(""))
				donationEntryHeader.setWellToday(box.getString("wellToday"));

			if (box.getString("smthingEat") != null
					&& !box.getString("smthingEat").equals(""))
				donationEntryHeader.setSmthingEat(box.getString("smthingEat"));
			if (box.getString("sleepLast") != null
					&& !box.getString("sleepLast").equals(""))
				donationEntryHeader.setSleepLastNight(box
						.getString("sleepLast"));

			if (box.getString("infectedDisease") != null
					&& !box.getString("infectedDisease").equals(""))
				donationEntryHeader.setHepatitis(box
						.getString("infectedDisease"));

			if (box.getString("weightLoss") != null
					&& !box.getString("weightLoss").equals(""))
				donationEntryHeader.setWeightLoss(box.getString("weightLoss"));

			if (box.getString("diarrhoces") != null
					&& !box.getString("diarrhoces").equals(""))
				donationEntryHeader.setDiasrrhoes(box.getString("diarrhoces"));
			if (box.getString("swollen") != null
					&& !box.getString("swollen;").equals(""))
				donationEntryHeader.setSwollwn(box.getString("swollen"));

			if (box.getString("lowGradeFever") != null
					&& !box.getString("lowGradeFever").equals(""))
				donationEntryHeader.setLowGradeFever("lowGradeFever");
			if (box.getString("na1") != null
					&& !box.getString("na1").equals(""))
				donationEntryHeader.setNA1(box.getString("na1"));

			if (box.getString("tattooing") != null
					&& !box.getString("tattooing").equals(""))
				donationEntryHeader.setTattoing(box.getString("tattooing"));

			if (box.getString("EarPiercing") != null
					&& !box.getString("EarPiercing").equals(""))
				donationEntryHeader
						.setEarPiercing(box.getString("EarPiercing"));

			if (box.getString("dentalExtraction") != null
					&& !box.getString("dentalExtraction").equals(""))
				donationEntryHeader.setDentalExtraction(box
						.getString("dentalExtraction"));
			if (box.getString("na2") != null
					&& !box.getString("na2").equals(""))
				donationEntryHeader.setNA2(box.getString("na2"));

			if (box.getString("heartDisease") != null
					&& !box.getString("heartDisease").equals(""))
				donationEntryHeader.setHeartDisease(box
						.getString("heartDisease"));

			if (box.getString("lungDisease") != null
					&& !box.getString("lungDisease").equals(""))
				donationEntryHeader
						.setLungDisease(box.getString("lungDisease"));

			if (box.getString("kidneyDisease") != null
					&& !box.getString("kidneyDisease").equals(""))
				donationEntryHeader.setKidneyDisease(box
						.getString("kidneyDisease"));
			if (box.getString("cancerisease") != null
					&& !box.getString("cancerisease").equals(""))
				donationEntryHeader.setCancerDisease(box
						.getString("cancerisease"));

			if (box.getString("epilepsy") != null
					&& !box.getString("epilepsy").equals(""))
				donationEntryHeader.setEpilepsy(box.getString("epilepsy"));
			if (box.getString("cdiabetes") != null
					&& !box.getString("cdiabetes").equals(""))
				donationEntryHeader.setCdiabetes(box.getString("cdiabetes"));

			if (box.getString("tuberculosis") != null
					&& !box.getString("tuberculosis").equals(""))
				donationEntryHeader.setTuberculosis(box
						.getString("tuberculosis"));
			if (box.getString("abnormalBleeding") != null
					&& !box.getString("abnormalBleeding").equals(""))
				donationEntryHeader.setAbnormalBleeding(box
						.getString("abnormalBleeding"));

			if (box.getString("dentalExtraction1") != null
					&& !box.getString("dentalExtraction1").equals(""))
				donationEntryHeader.setDentalExtraction1(box
						.getString("dentalExtraction1"));

			if (box.getString("sexuallyTransmittedDisease") != null
					&& !box.getString("sexuallyTransmittedDisease").equals(""))
				donationEntryHeader.setSexuallyDisease(box
						.getString("sexuallyTransmittedDisease"));
			if (box.getString("jaundicelast") != null
					&& !box.getString("jaundicelast").equals(""))
				donationEntryHeader.setJaundiceLastYear(box
						.getString("jaundicelast"));

			if (box.getString("typhoidLast") != null
					&& !box.getString("typhoidLast").equals(""))
				donationEntryHeader.setTyphoidLastOne(box
						.getString("typhoidLast"));

			if (box.getString("malariaLast") != null
					&& !box.getString("malariaLast").equals(""))
				donationEntryHeader.setMalariaSixMonth(box
						.getString("malariaLast"));

			if (box.getString("faintingSpell") != null
					&& !box.getString("faintingSpell").equals(""))
				donationEntryHeader.setFaintingSpells(box
						.getString("faintingSpell"));
			if (box.getString("leprosy") != null
					&& !box.getString("leprosy").equals(""))
				donationEntryHeader.setLeprosy(box.getString("leprosy"));

			if (box.getString("schizophernia") != null
					&& !box.getString("schizophernia").equals(""))
				donationEntryHeader.setSchizophernia(box
						.getString("schizophernia"));
			if (box.getString("endocrineDisorders") != null
					&& !box.getString("endocrineDisorders").equals(""))
				donationEntryHeader.setEndocrineDisorders(box
						.getString("endocrineDisorders"));

			if (box.getString("na3") != null
					&& !box.getString("na3").equals(""))
				donationEntryHeader.setNA3(box.getString("na3"));

			if (box.getString("abortion") != null
					&& !box.getString("abortion").equals(""))
				donationEntryHeader.setAbortion(box.getString("abortion"));

			if (box.getString("acuteNephritis") != null
					&& !box.getString("acuteNephritis").equals(""))
				donationEntryHeader.setAcuteNephritis(box
						.getString("acuteNephritis"));

			if (box.getString("bloodTransfusionHo") != null
					&& !box.getString("bloodTransfusionHo").equals(""))
				donationEntryHeader.setHoBloodTransfusion(box
						.getString("bloodTransfusionHo"));

			if (box.getString("ImmunoglobulinNephritis") != null
					&& !box.getString("ImmunoglobulinNephritis").equals(""))
				donationEntryHeader.setImmunoglobulinNephritis(box
						.getString("ImmunoglobulinNephritis"));

			if (box.getString("alcholism") != null
					&& !box.getString("alcholism").equals(""))
				donationEntryHeader.setAlcholism(box.getString("alcholism"));

			if (box.getString("rabiesVaccination") != null
					&& !box.getString("rabiesVaccination").equals(""))
				donationEntryHeader.setRabieVaccination(box
						.getString("rabiesVaccination"));
			if (box.getString("minorSurgery") != null
					&& !box.getString("minorSurgery").equals(""))
				donationEntryHeader.setMinorSurgery(box
						.getString("minorSurgery"));

			if (box.getString("majorSurgery") != null
					&& !box.getString("majorSurgery").equals(""))
				donationEntryHeader.setMajorSurgery(box
						.getString("majorSurgery"));

			if (box.getString("hoHepatitis") != null
					&& !box.getString("hoHepatitis").equals(""))
				donationEntryHeader
						.setHoHapatitis(box.getString("hoHepatitis"));

			if (box.getString("dentalExtraction1") != null
					&& !box.getString("dentalExtraction1").equals(""))
				donationEntryHeader.setDentalExtraction1(box
						.getString("dentalExtraction1"));

			/*
			 * if (box.getString("immunozalic") != null &&
			 * !box.getString("immunozalic").equals(""))
			 * donationEntryHeader.setImmunoglobulinNephritis("immunozalic");
			 */
			if (box.getString("typhoid") != null
					&& !box.getString("typhoid").equals(""))
				donationEntryHeader.setTyphoid(box.getString("typhoid"));

			if (box.getString("hoMalaria") != null
					&& !box.getString("hoMalaria").equals(""))
				donationEntryHeader.setHoMalaria(box.getString("hoMalaria"));

			if (box.getString("tattooing1") != null
					&& !box.getString("tattooing1").equals(""))
				donationEntryHeader.setTattoing1(box.getString("tattooing1"));

			if (box.getString("breastFeeding") != null
					&& !box.getString("breastFeeding").equals(""))
				donationEntryHeader.setBreastFeeding(box
						.getString("breastFeeding"));
			if (box.getString("na4") != null
					&& !box.getString("na4").equals(""))
				donationEntryHeader.setNA4(box.getString("na4"));

			if (box.getString("pregnant") != null
					&& !box.getString("pregnant").equals(""))
				donationEntryHeader.setPregnent(box.getString("pregnant"));
			if (box.getString("abortion1") != null
					&& !box.getString("abortion1").equals(""))
				donationEntryHeader.setAbortionLastThree(box
						.getString("abortion1"));

			if (box.getString("childLess") != null
					&& !box.getString("childLess").equals(""))
				donationEntryHeader.setChildLess(box.getString("childLess"));

			if (box.getString(UNDER_MENSES) != null && !box.getString(UNDER_MENSES).equals("")){
						donationEntryHeader.setMenses(box.getString(UNDER_MENSES));
			}		

			if (box.getString("na5") != null
					&& !box.getString("na5").equals(""))
				donationEntryHeader.setNA5(box.getString("na5"));

			if (box.getString("selectedRadio") != null
					&& !box.getString("selectedRadio").equals(""))
				donationEntryHeader.setBloodTransfusionSix(box
						.getString("selectedRadio"));

			if (box.getString("abnormalTestResult") != null
					&& !box.getString("abnormalTestResult").equals(""))
				donationEntryHeader.setAbnormalTestResult(box
						.getString("abnormalTestResult"));

			donationEntryHeader.setCollectionDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString("collectionDate")));

			if (box.getString("collectionTime") != null
					&& !box.getString("collectionTime").equals(""))
				donationEntryHeader.setCollectionTime(box
						.getString("collectionTime"));

			if (box.getString("general") != null
					&& !box.getString("general").equals(""))
				donationEntryHeader.setGeneral(box.getString("general"));
			if (box.getString("height") != null
					&& !box.getString("height").equals(""))
				donationEntryHeader.setHeight(box.getInt("height"));

			if (box.getString("weight") != null
					&& !box.getString("weight").equals(""))
				donationEntryHeader.setWeight(box.getInt("weight"));

			if (box.getString("pulse") != null
					&& !box.getString("pulse").equals(""))
				donationEntryHeader.setPulse(box.getFloat("pulse"));

			if (box.getString("temperature") != null
					&& !box.getString("temperature").equals(""))
				donationEntryHeader.setTemp(box.getFloat("temperature"));

			if (box.getString("hbDl") != null
					&& !box.getString("hbDl").equals(""))
				donationEntryHeader.setHbDl(Float.parseFloat(box.getString("hbDl")));

			if (box.getString("bp") != null && !box.getString("bp").equals(""))
				donationEntryHeader.setBp(box.getString("bp"));

			if (box.getString("phlebotomySite") != null
					&& !box.getString("phlebotomySite").equals(""))
				donationEntryHeader.setPhlebotomy(box
						.getString("phlebotomySite"));

			 donationEntryHeader.setCollectionDate(HMSUtil.convertStringTypeDateToDateType(box.getString("collectionDate")));

			MasEmployee masEmployee = new MasEmployee();
			if (box.getString("employeeId") != null
					&& !box.getString("employeeId").equals("")) {
				masEmployee
						.setId(Integer.parseInt(box.getString("employeeId")));
				donationEntryHeader.setCollectedBy(masEmployee);
			}
						
			Patient patient = new Patient();
			if(!box.getString("hinId").equals("0")){
				patient.setId(Integer.parseInt(box.getString("hinId")));
				donationEntryHeader.setHin(patient);
			}	

			if (box.getString("volRep") != null
					&& !box.getString("volRep").equals(""))
					donationEntryHeader.setVolRep(box.getString("volRep"));
			
			if (box.getString("donerType") != null
					&& !box.getString("donerType").equals(""))
				donationEntryHeader.setDonerType(box.getString("donerType"));

			/*
			 * MasIcd masIcd = new MasIcd(); if (box.getString("diagnosisId") !=
			 * null && !box.getString("diagnosisId").equals(""))
			 * masIcd.setId(Integer.parseInt(box.getString("diagnosisId")));
			 * donationEntryHeader.set(masIcd);
			 * 
			 * 
			 * 
			 * if (box.getString("appointmentDate") != null &&
			 * !box.getString("appointmentDate").equals(""))
			 * specialInvestigationHd
			 * .setAppointmentDate(HMSUtil.convertStringTypeDateToDateType(box
			 * .getString("appointmentDate")));
			 */

			donationEntryHeader.setLastChgBy(box.getString("changed_by"));
			donationEntryHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString("changed_date")));
			donationEntryHeader.setLastChgTime(box.getString("changed_time"));
			hbt.update(donationEntryHeader);

			int donationHeadId = donationEntryHeader.getId();
			List<BloodDonationEntryDetail> donationdetailList = session
					.createCriteria(BloodDonationEntryDetail.class)
					.createAlias("Donation", "dn").add(
							Restrictions
									.eq("dn.Id", box.getInt("donationhdId")))
					.list();
			hbt.deleteAll(donationdetailList);

			try {
				Vector blood_bag_no = box.getVector(BLOOD_BAG_NO);
				Vector component_id = box.getVector(BLOOD_COMPONENT_ID);
				Vector qty = box.getVector(QUANTITY);
				Vector expiryDate = box.getVector(EXPIRY_DATE);
			//	String Date = expiryDate;
				for (int i = 0; i < blood_bag_no.size(); i++) {
					if (blood_bag_no.get(i) != null
							&& !blood_bag_no.get(i).equals("")) {
						BloodDonationEntryDetail donationEntryDetail = new BloodDonationEntryDetail();
						donationEntryDetail
								.setDonation(new BloodDonationEntryHeader(
										donationHeadId));

						if (blood_bag_no.get(i) != null
								&& !blood_bag_no.get(i).equals("")) {
							donationEntryDetail
									.setBloodBagNo((String) blood_bag_no.get(i));
						}
						if (qty.get(i) != null && !qty.get(i).equals("")) {
							donationEntryDetail.setQty(Integer
									.parseInt((String) qty.get(i)));
						}
						
						if (component_id.get(i) != null
								&& !component_id.get(i).equals("")) {
							BloodMasComponent bloodMasComponent = new BloodMasComponent();
							bloodMasComponent.setId(Integer
									.parseInt((String) component_id.get(i)));
							donationEntryDetail.setComponent(bloodMasComponent);
						}
						if(expiryDate.get(i) != null){
							donationEntryDetail.setExpiryDate(HMSUtil
									.convertStringTypeDateToDateType(box
											.getString(EXPIRY_DATE)));
						}
						donationEntryDetail.setSampleScreeningTest("n");
						hbt.save(donationEntryDetail);
					}
				}

			} catch (RuntimeException e) {
				e.printStackTrace();
			}
			successfullyAdded = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		} finally {
			// --------Session Closing----------
			session.close();
		}
		return successfullyAdded;
	}

	public boolean updateBloodTestEntry(Box box) {
		boolean successfullyAdded = false;
		Session session = (Session) getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			List<BloodTestEntryHeader> testHdList = session.createCriteria(BloodTestEntryHeader.class).add(
					Restrictions.eq("Id", box.getInt("bloodTestHdId"))).list();
			BloodTestEntryHeader testHdObj = (BloodTestEntryHeader) testHdList.get(0);
			int reactionHdId = testHdObj.getId();
			BloodTestEntryHeader bloodTestHd = (BloodTestEntryHeader) hbt.load(
					BloodTestEntryHeader.class, box.getInt("bloodTestHdId"));

			Patient patient = new Patient();
			if(!box.getString("hinId").equals("0")){
				patient.setId(Integer.parseInt(box.getString("hinId")));
				bloodTestHd.setHin(patient);
			}

			if (box.getString("name") != null && !box.getString("name").equals(""))
				bloodTestHd.setName(box.getString("name"));

			MasRank masRank = new MasRank();
			if (box.getString("rankId") != null
					&& !box.getString("rankId").equals("")) {
				masRank.setId(Integer.parseInt(box.getString("rankId")));
				bloodTestHd.setRank(masRank);
			}

			MasRelation masRelation = new MasRelation();
			if (box.getString("relationId") != null && !box.getString("relationId").equals("")) {
				masRelation.setId(Integer.parseInt(box.getString("relationId")));
				bloodTestHd.setRelation(masRelation);
			}
			MasUnit masUnit = new MasUnit();
			if (box.getString("unitId") != null && !box.getString("unitId").equals("")) {
				masUnit.setId(Integer.parseInt(box.getString("unitId")));
				bloodTestHd.setUnit(masUnit);
			}

			MasAdministrativeSex masSex = new MasAdministrativeSex();
			if (box.getString("sexId") != null && !box.getString("sexId").equals(""))
				masSex.setId(Integer.parseInt(box.getString("sexId")));
			bloodTestHd.setSex(masSex);
			if (box.getString("patientType") != null && !box.getString("patientType").equals(""))
				bloodTestHd.setType(box.getString("patientType"));

			if (box.getString("contact_number") != null	&& !box.getString("contact_number").equals(""))
				bloodTestHd.setTeleNo(box.getString("contact_number"));

			if (box.getString("age") != null && !box.getString("age").equals(""))
				bloodTestHd.setType(box.getString("age"));

			MasEmployee masEmployee = new MasEmployee();
			if (box.getString("employeeId") != null	&& !box.getString("employeeId").equals(""))
				masEmployee.setId(Integer.parseInt(box.getString("employeeId")));
			bloodTestHd.setReceivedBy(masEmployee);

			bloodTestHd.setLastChgBy(box.getString("changed_by"));
			bloodTestHd.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString("changed_date")));
			bloodTestHd.setLastChgTime(box.getString("changed_time"));

			hbt.update(bloodTestHd);
			hbt.refresh(bloodTestHd);

			int testHd = bloodTestHd.getId();
			List<BloodTestEntryDetail> bloodTestDetailList = session
					.createCriteria(BloodTestEntryDetail.class).createAlias(
							"TestHeader", "dn").add(
							Restrictions.eq("dn.Id", box
									.getInt("bloodTestHdId"))).list();
			hbt.deleteAll(bloodTestDetailList);

			try {
				Vector investigation_id = box.getVector("investigationId");
				Vector result = box.getVector("result");
				for (int i = 0; i < investigation_id.size(); i++) {
					if (investigation_id.get(i) != null
							&& !investigation_id.get(i).equals("")
							&& !investigation_id.get(i).equals("0")) {
						BloodTestEntryDetail bloodTestEntryDetail = new BloodTestEntryDetail();

						bloodTestEntryDetail
								.setTestHeader(new BloodTestEntryHeader(box
										.getInt("bloodTestHdId")));

						if (investigation_id.get(i) != null
								&& !investigation_id.get(i).equals("")) {
							DgMasInvestigation masInvestigation = new DgMasInvestigation();
							masInvestigation
									.setId(Integer
											.parseInt((String) investigation_id
													.get(i)));
							bloodTestEntryDetail
									.setInvestigation(masInvestigation);
						}
						if (result.get(i) != null && !result.get(i).equals("")) {
							bloodTestEntryDetail.setResult((String) result
									.get(i));
						}
						hbt.save(bloodTestEntryDetail);

					}
				}
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
			successfullyAdded = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		} finally {
			// --------Session Closing----------
			session.close();
		}
		return successfullyAdded;
	}

	public Map<String, Object> searchPatientForUpdateTest(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodTestEntryHeader> testList = new ArrayList<BloodTestEntryHeader>();
		Criteria crit = null;

		String serviceNo = "";
		String entryNo = "";
		String patientName = "";
		int hinId = 0;

		Session session = (Session) getSession();

		if (mapForDs.get("serviceNo") != null) {
			serviceNo = (String) mapForDs.get("serviceNo");
		}
		if (mapForDs.get("entryNo") != null) {
			entryNo = (String) mapForDs.get("entryNo");
		}
		if (mapForDs.get("patientName") != null) {
			patientName = (String) mapForDs.get("patientName");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		try {
			crit = session.createCriteria(BloodTestEntryHeader.class);
			if (!entryNo.equals("")) {
				crit = crit.add(Restrictions.like("SerialNo", entryNo + "%"));
			}
			if (!serviceNo.equals("") || hinId != 0)
				crit = crit.createAlias("Hin", "hn");
			if (!serviceNo.equals("")) {
				crit = crit.add(Restrictions.like("hn.ServiceNo", serviceNo
						+ "%"));
			}
			if (hinId != 0) {
				if (!patientName.equals("")) {
					crit = crit.add(Restrictions.like("hn.PFirstName",
							patientName + "%"));
				}
			} else {
				crit = crit.add(Restrictions.like("Name", patientName + "%"));
			}
			if (hinId != 0) {
				crit = crit.add(Restrictions.like("hn.Id", hinId + "%"));
			}

			testList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("testList", testList);
		return map;
	}

	public Map<String, Object> showUpdateTestEntry(int bloodTestId) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<BloodTestEntryHeader> testList = new ArrayList<BloodTestEntryHeader>();
		List<BloodTestEntryDetail> bloodTestdtList = new ArrayList<BloodTestEntryDetail>();
		List<BloodStockDetail> stockList = new ArrayList<BloodStockDetail>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasRelation> relationList = new ArrayList<MasRelation>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
		Session session = (Session) getSession();

		try {
			employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).createAlias("Department",
					"dept").createAlias("dept.DepartmentType", "deptType").add(
					Restrictions.eq("deptType.Id", 24)).list();
			if (employeeList.size() > 0) {
				detailsMap.put("employeeList", employeeList);
			}
			rankList = session.createCriteria(MasRank.class).add(
					Restrictions.eq("Status", "y")).list();
			if (rankList.size() > 0) {
				detailsMap.put("rankList", rankList);
			}
			sexList = session.createCriteria(MasAdministrativeSex.class).add(
					Restrictions.eq("Status", "y")).list();
			if (sexList.size() > 0) {
				detailsMap.put("sexList", sexList);
			}
			relationList = session.createCriteria(MasRelation.class).add(
					Restrictions.eq("Status", "y")).list();
			if (relationList.size() > 0) {
				detailsMap.put("relationList", relationList);
			}
			unitList = session.createCriteria(MasUnit.class).add(
					Restrictions.eq("Status", "y")).list();
			if (unitList.size() > 0) {
				detailsMap.put("unitList", unitList);
			}
			testList = session.createCriteria(BloodTestEntryHeader.class).add(
					Restrictions.eq("Id", bloodTestId)).list();
			if (testList != null || testList.size() > 0) {
				detailsMap.put("testList", testList);
				;
				bloodTestdtList = session.createCriteria(
						BloodTestEntryDetail.class).add(
						Restrictions.eq("TestHeader.Id", testList.get(0)
								.getId())).list();
				detailsMap.put("bloodTestdtList", bloodTestdtList);

			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	public int generateTransfusionTestNumber() {
		int testSeqNo = 0;
		List<TransactionSequence> seqNoList = new ArrayList<TransactionSequence>();

		Session session = (Session) getSession();
		try {
			seqNoList = session.createCriteria(TransactionSequence.class).add(
					Restrictions.eq("TransactionPrefix", "TRN")).list();
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
				testSeqNo = ++seqNo;
				transactionSequenceObj.setTransactionSequenceNumber(testSeqNo);
				hbt.update(transactionSequenceObj);
			}
		} else if (seqNoList.size() == 0) {
			testSeqNo = 1;
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("BloodTransfussionReactionHd");
			tsObj.setTransactionPrefix("TRN");
			tsObj.setTransactionSequenceName("Test No");
			tsObj.setTransactionSequenceNumber(0);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");
			hbt.save(testSeqNo);
		}
		return testSeqNo;
	}

	public boolean submitTransfussionReaction(Map<String, Object> infoMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		BloodTransfussionReactionHd transfussionReactionHd = new BloodTransfussionReactionHd();
		List investigationList = new ArrayList();
		Session session = (Session) getSession();
		boolean success = false;
		@SuppressWarnings("unused")
		Box box = null;
		int componentMainIdFromRequest = 0;
		int trnasfusionHdId = 0;
		int departmentId = 0;
		int hospitalId = 0;
		int hinId = 0;
		int reactionId = 0;
		int testSeqNo = 0;
		String userName = "";
		Vector result = null;
		if (infoMap.get("hospitalId") != null) {
			hospitalId = (Integer) infoMap.get("hospitalId");
		}
		if (infoMap.get("departmentId") != null) {
			departmentId = (Integer) infoMap.get("departmentId");
		}
		if (infoMap.get("userName") != null) {
			userName = (String) infoMap.get("userName");
		}
		if (infoMap.get("transfussionReactionHd") != null) {
			transfussionReactionHd = (BloodTransfussionReactionHd) infoMap.get("transfussionReactionHd");
		}
		if (infoMap.get("componentMainIdFromRequest") != null) {
			componentMainIdFromRequest = (Integer) infoMap
					.get("componentMainIdFromRequest");
		}
		if (infoMap.get("hinId") != null) {
			hinId = (Integer) infoMap.get("hinId");
		}
		if (infoMap.get("testSeqNo") != null) {
			testSeqNo = (Integer) infoMap.get("testSeqNo");
		}
		if (infoMap.get("reactionId") != null) {
			reactionId = (Integer) infoMap.get("reactionId");
		}
		if (infoMap.get("box") != null) {
			box = (Box) infoMap.get("box");
		}
		if (infoMap.get("result") != null) {
			result = (Vector) infoMap.get("result");
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date changeDate = HMSUtil.convertStringTypeDateToDateType(date);
		List reactionList = session.createCriteria(BloodReactionEntry.class)
								.add(Restrictions.eq("Id",	reactionId)).list();
		BloodReactionEntry reactionEntry = (BloodReactionEntry) reactionList.get(0);
		reactionEntry.setScreening("y");
		hbt.update(reactionEntry);
		
		try {
			hbt.save(transfussionReactionHd);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		try {

			if (infoMap.get("investigationList") != null) {
				investigationList = (List) infoMap.get("investigationList");
				if (investigationList.size() > 0) {
					for (int i = 0; i < investigationList.size(); i++) {

						BloodTransfussionReactionDt transfussionReactionDt = new BloodTransfussionReactionDt();
						DgMasInvestigation masInvestigation = new DgMasInvestigation();

						try {
							if (investigationList.get(i) != null
									&& !investigationList.get(i).equals("")) {
								int investigationId = Integer
										.parseInt(investigationList.get(i)
												.toString());
								masInvestigation.setId(investigationId);
								transfussionReactionDt
										.setInvestigation(masInvestigation);

								if (result != null && !result.equals("")) {
									transfussionReactionDt
											.setResult((String) result.get(i)
													.toString());
								}
								transfussionReactionDt
										.setTransfusionHd(transfussionReactionHd);
								try {
									hbt.save(transfussionReactionDt);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}

						} catch (RuntimeException e) {
							e.printStackTrace();
						}

					}
					saved = true;
				}
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return saved;
	}

	public Map<String, Object> fillBloodbagForDiscrad(
			Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		List<BloodStockDetail> bagList = new ArrayList<BloodStockDetail>();
		@SuppressWarnings("unused")
		int deptId = 0;
		try {
			String str = "" + dataMap.get("bloodbagNo");
			Criteria c = session.createCriteria(BloodStockDetail.class).add(
					Restrictions.eq("ServiceNo", str)).add(
					Restrictions.eq("BloodIssued", "n"));
			bagList = c.list();
			dataMap.put("bagList", bagList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dataMap;

	}

	public Map<String, Object> getTransfusionReactionGrid(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodReactionEntry> reactionList = new ArrayList<BloodReactionEntry>();
		Date currentDate = new Date();
		Session session = (Session) getSession();
		Criteria crit = null;
		if (mapForDs.get("currentDate") != null) {
			currentDate = (Date) mapForDs.get("currentDate");
		}
		try {
			crit = session.createCriteria(BloodReactionEntry.class).add(
					Restrictions.eq("Screening", "n")).add(
					Restrictions.eq("RactionDate", currentDate));
			reactionList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("reactionList", reactionList);
		return map;
	}

	public Map<String, Object> fillBloodbagForReaction(
			Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		List<BloodStockDetail> bagList = new ArrayList<BloodStockDetail>();
		@SuppressWarnings("unused")
		int deptId = 0;
		try {
			String str = "" + dataMap.get("bloodBagNo");
			Criteria c = session.createCriteria(BloodStockDetail.class).add(
					Restrictions.eq("BloodBagNo", str)).add(
					Restrictions.eq("BloodIssued", "n"));
			bagList = c.list();
			dataMap.put("bagList", bagList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dataMap;
	}

	public Map<String, Object> showPendingBloodDiscard(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodStockDetail> stockDetailList = new ArrayList<BloodStockDetail>();
		Session session = (Session) getSession();
		Date currentDate = new Date();

		int hinId = 0;

		try {
			stockDetailList = session.createCriteria(BloodStockDetail.class)
					.add(Restrictions.eq("BloodIssued", "n")).createAlias(
							"StockMain", "stockMain").add(
							Restrictions
									.le("stockMain.ExpiryDate", currentDate))
					.list();
			map.put("stockDetailList", stockDetailList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> chechBloodBag(Map<String, Object> dataMap) {
		String bloodBagId = "";
		String exists = "no";
		List<BloodDonationEntryDetail> donationdetailList = new ArrayList<BloodDonationEntryDetail>();
		Map<String, Object> map = new HashMap<String, Object>();
		if (dataMap.get("bloodBagId") != null) {
			bloodBagId = "" + dataMap.get("bloodBagId");
		}
		Session session = (Session) getSession();
		donationdetailList = session.createCriteria(
				BloodDonationEntryDetail.class).add(
				Restrictions.eq("BloodBagNo", bloodBagId)).list();
		if (donationdetailList.size() == 0) {
			dataMap.put("flag", "NoDuplicateFound");
		}
		if (donationdetailList.size() > 0) {
			exists = "yes";
		}
		map.put("exists", exists);
		return map;
	}

	public Map<String, Object> fillItemsForComponentnameSeparation(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();

		List componentList = new ArrayList();
		Session session = (Session) getSession();
		String componentName = (String) dataMap.get("componentName");
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			componentList = session.createCriteria(BloodMasComponent.class)
					.add(Restrictions.eq("ComponentName", componentName)).add(
							Restrictions.eq("WholeBlood", "n")).list();
			map.put("componentList", componentList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> submitBloodComponentSeperation(Box box,
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		int stockMainId = 0;
		int componentMainIdFromRequest = 0;
		Session session = (Session) getSession();
		BloodStockMain stockMain = new BloodStockMain();
		List qtyList = new ArrayList();
		List componentList = new ArrayList();
		Vector quantity = null;
		Vector blood_bag_no = null;
		Vector stock_mainId = null;
		int stockDtId = 0;
		if (dataMap.get("box") != null) {
			box = (Box) dataMap.get("box");
		}
		if (dataMap.get("stockDtId") != null) {
			stockDtId = (Integer) dataMap.get("stockDtId");
		}
		int stockMaId = 0;
		if (dataMap.get("stockMaId") != null) {
			stockMaId = (Integer) dataMap.get("stockMaId");
		}
		if (dataMap.get("qtyList") != null) {
			qtyList = (List) dataMap.get("qtyList");
		}
		if (dataMap.get("stockMain") != null) {
			stockMain = (BloodStockMain) dataMap.get("stockMain");
		}
		if (dataMap.get("quantity") != null) {
			quantity = (Vector) dataMap.get("quantity");
		}
		if (dataMap.get("blood_bag_no") != null) {
			blood_bag_no = (Vector) dataMap.get("blood_bag_no");
		}
		if (dataMap.get("stock_mainId") != null) {
			stock_mainId = (Vector) dataMap.get("stock_mainId");
		}
		Transaction tx = null;
		tx = session.beginTransaction();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {

			List<BloodStockDetail> stockList = session.createCriteria(
					BloodStockDetail.class).createAlias("StockMain", "sm").add(
					Restrictions.eq("sm.Id", box.getInt("stockMainId"))).list();

			hbt.deleteAll(stockList);

			if (dataMap.get("componentList") != null) {
				componentList = (List) dataMap.get("componentList");
				if (componentList.size() > 0) {
					BloodStockDetail previousBloodStockDetail = (BloodStockDetail) session
					.load(BloodStockDetail.class, stockDtId);
			hbt.delete(previousBloodStockDetail);
					for (int i = 0; i < componentList.size(); i++) {
						BloodStockDetail bloodStockDetail = new BloodStockDetail();
						BloodMasComponent bloodMasComponent = new BloodMasComponent();
						if (componentList.get(i) != null
								&& !componentList.get(i).equals("")) {
							
					
							bloodStockDetail.setStockMain(new BloodStockMain(
									Integer.parseInt((String) stock_mainId
											.get(i))));
							int componentId = Integer.parseInt(componentList
									.get(i).toString());
							bloodMasComponent.setId(componentId);
							bloodStockDetail.setComponent(bloodMasComponent);
							if (blood_bag_no != null
									&& !blood_bag_no.equals("")) {
								bloodStockDetail
										.setBloodBagNo((String) blood_bag_no.get(i));
							}
							if (quantity != null && !quantity.equals("")) {
								bloodStockDetail.setQty(Integer
										.parseInt((String) quantity.get(i)));
							}
							bloodStockDetail.setBloodIssued("n");

							hbt.save(bloodStockDetail);
							
						}
						saved = true;
					}
				}

			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			// throw e; // or display error message
			e.printStackTrace();
		}

		map.put("saved", saved);
		return map;
	}

	@Override
	public Map<String, Object> getComponentNameDonationForAutoComplete(
			Map<String, Object> parameterMap) {
		Session session = (Session) getSession();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<BloodMasComponent> bloodComponentList = new ArrayList<BloodMasComponent>();
		String str = "";
		if (parameterMap.get("autoHint") != null) {
			str = parameterMap.get("autoHint") + "%";
		}

		bloodComponentList = session.createCriteria(BloodMasComponent.class)
				.add(Restrictions.like("ComponentName", str)).add(
						Restrictions.like("Status", "y")).add(Restrictions.eq("WholeBlood", "y")).list();

		if (bloodComponentList.size() > 0) {
			detailsMap.put("componentList", bloodComponentList);
		}
		return detailsMap;
	}



	@Override
	public Map<String, Object> showBloodStockRegisterjsp() {
		 Session session = (Session) getSession();
         Map<String, Object> map = new HashMap<String, Object>();
         List<BloodMasComponent> bldMasCompList = new ArrayList<BloodMasComponent>();

         try {
               bldMasCompList = session.createCriteria(BloodMasComponent.class).add(Restrictions.eq("Status", "y")).list();
            
         } catch (HibernateException e) {
               e.printStackTrace();
         }
         map.put("bldMasCompList", bldMasCompList);
         return map;

	}


	@Override
	public List<Patient> getHinNoForDonor(String serviceNo) {
		List<Patient> patientList = new ArrayList<Patient>();
		Session session = (Session) getSession();
		try {
			patientList = session.createCriteria(Patient.class).add(
					Restrictions.eq("ServiceNo", serviceNo)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return patientList;
	}

	@Override
	public List<Patient> getDonorDetails(String hinNo) {
		List<Patient> patientList = new ArrayList<Patient>();
		Session session = (Session) getSession();
		try {
			patientList = session.createCriteria(Patient.class).add(
					Restrictions.eq("HinNo", hinNo)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return patientList;
	}


	@Override
	public Map<String, Object> fillPatientTestDetail(Map map) {
		Session session = (Session) getSession();
		List<Patient> patientList = new ArrayList<Patient>();
		@SuppressWarnings("unused")
		int deptId = 0;
		try {
			String str = "" + map.get("serviceNo");
			Criteria c = session.createCriteria(Patient.class).add(
					Restrictions.eq("ServiceNo", str));
			patientList = c.list();
			map.put("patientList", patientList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

}
