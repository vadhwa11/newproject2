package jkt.hms.masters.dataservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasAnesthesia;
import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasInstruction;
import jkt.hms.masters.business.MasOpInstruction;
import jkt.hms.masters.business.MasOt;
import jkt.hms.masters.business.MasOtDistribution;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasOpInstruction;
import jkt.hms.masters.business.OtMasChargeDetails;
import jkt.hms.masters.business.Users;
import jkt.hms.util.HMSUtil;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class OTMasterDataServiceImpl extends HibernateDaoSupport implements
		OTMasterDataService {

	// --------------------------------------Anesthesia-----------------------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> showAnesthesiaJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasAnesthesia> searchAnesthesiaList = new ArrayList<MasAnesthesia>();
		searchAnesthesiaList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasAnesthesia ");
		map.put("searchAnesthesiaList", searchAnesthesiaList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchAnesthesia(String anesthesiaCode,
			String anesthesiaName) {
		List<MasAnesthesia> searchAnesthesiaList = new ArrayList<MasAnesthesia>();
		Map anesthesiaFieldsMap = new HashMap();
		try {
			if ((anesthesiaName != null) || (anesthesiaCode == null)) {
				searchAnesthesiaList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasAnesthesia ma where ma.AnesthesiaName like '"
								+ anesthesiaName
								+ "%' order by ma.AnesthesiaName");
			} else {
				searchAnesthesiaList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasAnesthesia ma where ma.AnesthesiaCode like '"
								+ anesthesiaCode
								+ "%' order by ma.AnesthesiaCode");
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		anesthesiaFieldsMap.put("searchAnesthesiaList", searchAnesthesiaList);
		return anesthesiaFieldsMap;
	}

	public boolean addAnesthesia(MasAnesthesia anesthesiaMaster) {
		boolean dataSaved = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(anesthesiaMaster);
		dataSaved = true;
		return dataSaved;
	}

	public boolean deleteAnesthesia(int anesthesiaId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasAnesthesia masAnesthesia = new MasAnesthesia();
		masAnesthesia = (MasAnesthesia) getHibernateTemplate().load(
				MasAnesthesia.class, anesthesiaId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masAnesthesia.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masAnesthesia.setStatus("y");
				dataDeleted = false;
			}
		}
		masAnesthesia.setLastChgBy(changedBy);
		masAnesthesia.setLastChgDate(currentDate);
		masAnesthesia.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masAnesthesia);
		return dataDeleted;

	}

	public boolean editAnesthesiaToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String anesthesiaName = "";
		@SuppressWarnings("unused")
		String anesthesiaCode = "";
		int anesthesiaId = 0;
		String changedBy = "";
		anesthesiaId = (Integer) generalMap.get("id");
		anesthesiaCode = (String) generalMap.get("anesthesiaCode");
		anesthesiaName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasAnesthesia masAnesthesia = (MasAnesthesia) getHibernateTemplate()
				.load(MasAnesthesia.class, anesthesiaId);

		masAnesthesia.setId(anesthesiaId);
		masAnesthesia.setAnesthesiaName(anesthesiaName);
		masAnesthesia.setLastChgBy(changedBy);
		masAnesthesia.setLastChgDate(currentDate);
		masAnesthesia.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masAnesthesia);
		dataUpdated = true;
		return dataUpdated;
	}

	// //****************************************** Start Of OPD Instruction
	// Treatment by Mansi ****************************//

	public boolean addOt(MasOt ot) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(ot);
		successfullyAdded = true;
		return successfullyAdded;

	}

	public boolean deleteOt(int otId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasOt ot = new MasOt();
		ot = (MasOt) getHibernateTemplate().get(MasOt.class, otId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				ot.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				ot.setStatus("y");
				dataDeleted = false;
			}
		}
		ot.setLastChgBy(changedBy);
		ot.setLastChgDate(currentDate);
		ot.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(ot);
		return dataDeleted;
	}

	public boolean editOtToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String otName = "";
		@SuppressWarnings("unused")
		String otCode = "";
		int otId = 0;
		String changedBy = "";
		try {
			otId = (Integer) generalMap.get("id");
			otCode = (String) generalMap.get("otCode");
			otName = (String) generalMap.get("name");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");

		} catch (Exception e) {
			e.printStackTrace();
		}

		MasOt ot = (MasOt) getHibernateTemplate().get(MasOt.class, otId);

		ot.setId(otId);
		ot.setOtName(otName);
		ot.setLastChgBy(changedBy);
		ot.setLastChgDate(currentDate);
		ot.setLastChgTime(currentTime);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(ot);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchOt(String otCode, String otName) {
		List<MasOt> searchOtList = new ArrayList<MasOt>();

		Map<String, Object> otFieldsMap = new HashMap<String, Object>();
		try {
			if ((otName != null) || (otCode == null)) {

				searchOtList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasOt imc where imc.OtName like '"
								+ otName + "%' order by imc.OtName");
			} else {
				searchOtList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasOt imc where imc.OtCode like '"
								+ otCode + "%' order by imc.OtCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		otFieldsMap.put("searchOtList", searchOtList);
		return otFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showOtJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasOt> searchOtList = new ArrayList<MasOt>();
		searchOtList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasOt ");
		map.put("searchOtList", searchOtList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showOtDistributionJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasOtDistribution> searchMasOtDistributionList = new ArrayList<MasOtDistribution>();
		List<MasOt> otList = new ArrayList<MasOt>();
		List<MasOt> graidOtList = new ArrayList<MasOt>();

		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		try {
			searchMasOtDistributionList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasOtDistribution imc ");
			otList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasOt as ot where ot.Status='y'");
			graidOtList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasOt as ot where ot.Status='y'");
			departmentList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasDepartment as d where d.Status='y' ");
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		map.put("otList", otList);
		map.put("graidOtList", graidOtList);
		map.put("departmentList", departmentList);
		map.put("searchMasOtDistributionList", searchMasOtDistributionList);
		return map;
	}

	public boolean addOtDistribution(MasOtDistribution masOtDistribution) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masOtDistribution);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings( { "unused", "unchecked" })
	public Map<String, Object> checkForExistingDaysOt(
			Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List duplicateDaysOtList = new ArrayList();
		int otId = (Integer) generalMap.get("otId");
		int departmentId = (Integer) generalMap.get("departmentId");
		String days = (String) generalMap.get("days");
		Date validityStartDate = (Date) generalMap.get("validityStartDate");
		//System.out.println("validityStartDate-->" + validityStartDate);
		try {
			duplicateDaysOtList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasOtDistribution as mod join mod.Ot as ot join mod.Department as dep where ot.Id="
									+ otId
									+ " and dep.Id="
									+ departmentId
									+ " and  mod.Days='"
									+ days
									//+ "' and mod.ValidityStartDate='"
									//+ validityStartDate 
									+"'");
			map.put("duplicateDaysOtList", duplicateDaysOtList);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteOtDistribution(int otDistributionId,
			Map<String, Object> generalMap) {

		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasOtDistribution masOtDistribution = new MasOtDistribution();
		masOtDistribution = (MasOtDistribution) getHibernateTemplate().get(
				MasOtDistribution.class, otDistributionId);
		@SuppressWarnings("unused")
		Integer oTId = masOtDistribution.getOt().getId();
		String days = masOtDistribution.getDays();
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			@SuppressWarnings("unused")
			List oTList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasOt as isc where isc.Id='"
							+ oTId + "' and isc.Status='y'");
			@SuppressWarnings("unused")
			List masOtDistributionList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasOtDistribution as isc where isc.Days='"
							+ days + "' and isc.Status='y'");
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masOtDistribution.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masOtDistribution.setStatus("y");
				dataDeleted = false;
			}
		}
		masOtDistribution.setLastChgBy(changedBy);
		masOtDistribution.setLastChgDate(currentDate);
		masOtDistribution.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masOtDistribution);
		return dataDeleted;
	}

	public boolean editOtDistribution(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		int otDistributionId = 0;
		int otId = 0;
		String days = "";
		Date validityStartDate = new Date();
		int departmentId = 0;
		otDistributionId = (Integer) generalMap.get("id");
		otId = (Integer) generalMap.get("otId");
		days = (String) generalMap.get("days");
		validityStartDate = (Date) generalMap.get("validityStartDate");
		departmentId = (Integer) generalMap.get("departmentId");
		MasOtDistribution masOtDistribution = (MasOtDistribution) getHibernateTemplate()
				.get(MasOtDistribution.class, otDistributionId);

		masOtDistribution.setId(otDistributionId);

		MasOt masOt = new MasOt();
		masOt.setId(otId);
		masOtDistribution.setOt(masOt);

		masOtDistribution.setDays(days);

		masOtDistribution.setValidityStartDate(validityStartDate);

		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(departmentId);
		masOtDistribution.setDepartment(masDepartment);

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masOtDistribution);
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchOtDistribution(String oTName, String days) {
		List<MasOtDistribution> searchMasOtDistributionList = new ArrayList<MasOtDistribution>();
		Map<String, Object> usergroupHospitalFieldsMap = new HashMap<String, Object>();
		List<MasOt> otList = new ArrayList<MasOt>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasOt> graidOtList = new ArrayList<MasOt>();
		try {
			if ((oTName != null) || (days == null)) {

				searchMasOtDistributionList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasOtDistribution imc where imc.Ot.OtName like '"
										+ oTName + "%' order by imc.Ot.OtName");
			} else {
				searchMasOtDistributionList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasOtDistribution imc where imc.Days like '"
								+ days + "%' order by imc.Days");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		otList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasOt as ot where ot.Status='y'");
		departmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment as d where d.Status='y' ");
		graidOtList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasOt as ot where ot.Status='y'");
		usergroupHospitalFieldsMap.put("otList", otList);
		usergroupHospitalFieldsMap.put("graidOtList", graidOtList);
		usergroupHospitalFieldsMap.put("departmentList", departmentList);
		usergroupHospitalFieldsMap.put("searchMasOtDistributionList",
				searchMasOtDistributionList);
		return usergroupHospitalFieldsMap;
	}

	// --------------------------------------- Master OT Charge
	// Details-----------------------------------

	public boolean addOtMasChargeDetails(OtMasChargeDetails masChargeDetails) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masChargeDetails);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteOtMasChargeDetails(int otMasChargeDetailsId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		OtMasChargeDetails masChargeDetails = new OtMasChargeDetails();
		masChargeDetails = (OtMasChargeDetails) getHibernateTemplate().get(
				OtMasChargeDetails.class, otMasChargeDetailsId);
		Integer chargeId = masChargeDetails.getChargeCode().getId();
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			@SuppressWarnings("unused")
			List oTList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasChargeCode as isc where isc.Id='"
							+ chargeId + "' and isc.Status='y'");
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masChargeDetails.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masChargeDetails.setStatus("y");
				dataDeleted = false;
			}
		}
		masChargeDetails.setLastChgBy(changedBy);
		masChargeDetails.setLastChgDate(currentDate);
		masChargeDetails.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masChargeDetails);
		return dataDeleted;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchOtMasChargeDetails(String chargeCodeName) {
		List<OtMasChargeDetails> searchOtMasChangeDetailsList = new ArrayList<OtMasChargeDetails>();
		Map<String, Object> otMasChargeDetailsFieldsMap = new HashMap<String, Object>();
		List<MasChargeCode> masChargeCodeList = new ArrayList<MasChargeCode>();
		try {
			if ((chargeCodeName != null)) {

				searchOtMasChangeDetailsList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.OtMasChargeDetails imc where imc.ChargeCode.ChargeCodeName like '"
										+ chargeCodeName
										+ "%' order by imc.ChargeCode.ChargeCodeName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("searchOtMasChangeDetailsList--in DS->>>"+ searchOtMasChangeDetailsList.size());
		masChargeCodeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasChargeCode as ot where ot.Status='y'");
		otMasChargeDetailsFieldsMap.put("masChargeCodeList", masChargeCodeList);
		otMasChargeDetailsFieldsMap.put("searchOtMasChangeDetailsList",
				searchOtMasChangeDetailsList);
		return otMasChargeDetailsFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showOtMasChargeDetailsJsp() {

		Map<String, Object> map = new HashMap<String, Object>();
		List<OtMasChargeDetails> searchOtMasChangeDetailsList = new ArrayList<OtMasChargeDetails>();
		List<MasChargeCode> masChargeCodeList = new ArrayList<MasChargeCode>();

		try {
			searchOtMasChangeDetailsList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.OtMasChargeDetails imc ");
			masChargeCodeList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasChargeCode as ot where ot.Status='y'");
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		map.put("masChargeCodeList", masChargeCodeList);
		map.put("searchOtMasChangeDetailsList", searchOtMasChangeDetailsList);
		return map;

	}

	public boolean editOtMasChargeDetails(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		int otMasChargeDetailsId = 0;
		String chargeCodeName = "";
		String otChargeType = "";
		String approxDuration = "";
		otMasChargeDetailsId = (Integer) generalMap.get("id");
		chargeCodeName = (String) generalMap.get("chargeCodeName");
		otChargeType = (String) generalMap.get("otChargeType");
		approxDuration = (String) generalMap.get("approxDuration");
		OtMasChargeDetails masChargeDetails = (OtMasChargeDetails) getHibernateTemplate()
				.get(OtMasChargeDetails.class, otMasChargeDetailsId);

		masChargeDetails.setId(otMasChargeDetailsId);

		int index1 = chargeCodeName.lastIndexOf("[");
		int index2 = chargeCodeName.lastIndexOf("]");
		index1++;
		int chargeCodeId = Integer.parseInt(chargeCodeName.substring(index1,
				index2));

		MasChargeCode masChargeCode = new MasChargeCode();
		masChargeCode.setId(chargeCodeId);
		masChargeDetails.setChargeCode(masChargeCode);

		masChargeDetails.setOtChargeType(otChargeType);

		masChargeDetails.setApproxDuration(approxDuration);

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masChargeDetails);
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;

	}

	public Map<String, Object> getChageCodeByAutocomplete(
			Map<String, Object> dataMap) {
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		Session session = (Session) getSession();
		try {
			String str = "%" + dataMap.get("autoHint") + "%";
			String query = "from MasChargeCode as icd where icd.ChargeCodeName like '"
					+ str + "'";
			Query q = session.createQuery(query);
			q.setFirstResult(0);
			q.setMaxResults(10);
			chargeCodeList = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataMap.put("chargeCodeList", chargeCodeList);
		return dataMap;
	}

	public Map<String, Object> fillChargeCodeNameInGrid(
			Map<String, Object> dataMap) {

		Session session = (Session) getSession();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		try {
			String str = "" + dataMap.get("pvmsNo");
			Criteria c = session.createCriteria(MasStoreItem.class).add(
					Restrictions.eq("PvmsNo", str));
			itemList = c.list();
			dataMap.put("itemList", itemList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataMap;

	}

	public Map<String, Object> checkForExistingChargeCodeId(
			Map<String, Object> generalMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		List duplicateChargeCodeIdList = new ArrayList();
		int chargeCodeId = (Integer) generalMap.get("chargeCodeId");
		try {
			duplicateChargeCodeIdList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.OtMasChargeDetails as mod join mod.ChargeCode as ot where ot.Id="
									+ chargeCodeId);
			map.put("duplicateChargeCodeIdList", duplicateChargeCodeIdList);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return map;

	}

	public Map<String, Object> checkForExistingChargeCodeName(
			Map<String, Object> generalMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		List duplicateChargeCodeNameList = new ArrayList();
		String chargeCodeName = (String) generalMap.get("chargeCodeName");
		String otChargeType = "";
		String approxDuration = "";
		otChargeType = (String) generalMap.get("otChargeType");
		approxDuration = (String) generalMap.get("approxDuration");
		int index1 = chargeCodeName.lastIndexOf("[");
		int index2 = chargeCodeName.lastIndexOf("]");
		index1++;
		int chargeCodeId = Integer.parseInt(chargeCodeName.substring(index1,
				index2));
		try {
			duplicateChargeCodeNameList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.OtMasChargeDetails as mod join mod.ChargeCode as ot where ot.Id="
									+ chargeCodeId
									+ " and mod.OtChargeType='"
									+ otChargeType
									+ "'and mod.ApproxDuration='"
									+ approxDuration + "'");
			map.put("duplicateChargeCodeNameList", duplicateChargeCodeNameList);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return map;
	}

	@Override
	public Map<String, Object> showOpInstructionJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasOpInstruction> searchOpInstructionList = new ArrayList<MasOpInstruction>();
		searchOpInstructionList = getHibernateTemplate().find("from jkt.hms.masters.business.MasOpInstruction ");
		map.put("searchOpInstructionList", searchOpInstructionList);
		
		List<MasInstruction> instructionList = new ArrayList<MasInstruction>();
		instructionList = getHibernateTemplate().find("from jkt.hms.masters.business.MasInstruction as mit where mit.Status = 'y'");
		map.put("instructionList", instructionList);
		return map;
	}

	@Override
	public boolean addOpInstructionJsp(MasOpInstruction masOpInstruction) {

		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masOpInstruction);
		successfullyAdded = true;
		return successfullyAdded;
	
		
	}

	@Override
	public Map<String, Object> checkForExistingOpInstruction(
			Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		int instruction = 0;
		instruction=(Integer) generalMap.get("instruction");
		String name = "";
		String flag = "";
		name=(String) generalMap.get("name");
		Session session = (Session) getSession();
		List<MasOpInstruction> opInstructionList = new ArrayList<MasOpInstruction>();
		System.out.println("instruction"+instruction);
		System.out.println("name"+name);
		if(!name.equals("") && instruction!=0){

			System.out.println("instruction---"+instruction);
			System.out.println("name---"+name);
			opInstructionList = session.createCriteria(MasOpInstruction.class).add(
				Restrictions.like("Instruction",name)).
					createAlias("Op", "e")
					.add(Restrictions.eq("e.Id",instruction))
				.list();
			
			
			System.out.println(opInstructionList.size()+"---------opInstructionList");
		}

		map.put("opInstructionList", opInstructionList);
		return map;
	
	}

	@Override
	public boolean editOpInstruction(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String wardName = "";
		int opInstructionId = 0;
		int instruction= 0;
		Users changedBy = new Users();
		try {
			opInstructionId = (Integer) generalMap.get("id");
			wardName = (String) generalMap.get("name");
			instruction= (Integer) generalMap.get("instruction");
			changedBy = (Users) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
		} catch (Exception e) {
			//System.out.println("Exception before masTitle in dataserviceImpl "+ e);
		}

		System.out.println("wardName "+wardName);
		MasOpInstruction masOpInstruction = (MasOpInstruction) getHibernateTemplate().get(
				MasOpInstruction.class, opInstructionId);

		masOpInstruction.setId(opInstructionId);
		masOpInstruction.setInstruction(wardName);
		
		MasInstruction mih = new MasInstruction();
		mih.setId(instruction);
		masOpInstruction.setOp(mih);
		
		
		masOpInstruction.setLastChgBy(changedBy);
		masOpInstruction.setLastChgDate(currentDate);
		masOpInstruction.setLastChgTime(currentTime);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(masOpInstruction);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@Override
	public boolean deleteOpInstruction(int opInstructionId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		Users changedBy = new Users();
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasOpInstruction masOpInstruction = new MasOpInstruction();
		masOpInstruction = (MasOpInstruction) getHibernateTemplate().get(MasOpInstruction.class,
				opInstructionId);
		changedBy = (Users) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masOpInstruction.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masOpInstruction.setStatus("y");
				dataDeleted = false;
			}
		}
		masOpInstruction.setLastChgBy(changedBy);
		masOpInstruction.setLastChgDate(currentDate);
		masOpInstruction.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(masOpInstruction);
		return dataDeleted;
	}

	@Override
	public Map<String, Object> searchOpInstruction(int instructionSearch) {
		List<MasOpInstruction> searchOpInstructionList = new ArrayList<MasOpInstruction>();
		Map<String, Object> opInstructionFieldsMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		String instructionName="";
		try {
			if (instructionSearch != 0) {
				
				
				searchOpInstructionList = session.createCriteria(MasOpInstruction.class).
							createAlias("Op", "e")
							.add(Restrictions.eq("e.Id", instructionSearch))
						.list();
				
					instructionName=searchOpInstructionList.get(0).getOp().getOpInsName();
					
					

				
				
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<MasInstruction> instructionList = new ArrayList<MasInstruction>();
		instructionList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasInstruction as mit where mit.Status = 'y'");
		opInstructionFieldsMap.put("instructionList", instructionList);
		
		opInstructionFieldsMap.put("searchOpInstructionList", searchOpInstructionList);
		opInstructionFieldsMap.put("instructionName", instructionName);
		return opInstructionFieldsMap;
	}

}
