package jkt.hms.laundry.dataservice;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;

import jkt.hms.masters.business.CarDiaryEntry;
import jkt.hms.masters.business.MachineActivity;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasLaundryMachine;
import jkt.hms.masters.business.MasLinenWeight;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.masters.business.WorkLoadEntry;
import jkt.hms.masters.business.WorkLoadEntryDetail;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class LaundryDataServiceImpl extends HibernateDaoSupport implements
		LaundryDataService {

	// ---------------------------- method to get laundry machine list
	// -----------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> showLaundryJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasLaundryMachine> searchLaundryList = new ArrayList<MasLaundryMachine>();
		searchLaundryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasLaundryMachine ");
		map.put("searchLaundryList", searchLaundryList);
		return map;
	}

	public boolean addLaundry(MasLaundryMachine masLaundryMachine) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(masLaundryMachine);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unused")
	public boolean editLaundry(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String machineName = (String) generalMap.get("machineName");

		int laundryId = 0;
		String changedBy = "";
		try {
			laundryId = (Integer) generalMap.get("id");
			machineName = (String) generalMap.get("name");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
		} catch (Exception e) {
			System.out
					.println("Exception before MasLaundryMachine in dataserviceImpl "
							+ e);
		}

		MasLaundryMachine masLaundryMachine = (MasLaundryMachine) getHibernateTemplate()
				.get(MasLaundryMachine.class, laundryId);

		masLaundryMachine.setId(laundryId);
		masLaundryMachine.setMahineName(machineName);
		masLaundryMachine.setLastChgBy(changedBy);
		masLaundryMachine.setLastChgDate(currentDate);
		masLaundryMachine.setLastChgTime(currentTime);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(masLaundryMachine);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	public boolean deleteLaundry(int laundryId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasLaundryMachine masLaundryMachine = new MasLaundryMachine();
		masLaundryMachine = (MasLaundryMachine) getHibernateTemplate().get(
				MasLaundryMachine.class, laundryId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masLaundryMachine.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masLaundryMachine.setStatus("y");
				dataDeleted = false;
			}
		}
		masLaundryMachine.setLastChgBy(changedBy);
		masLaundryMachine.setLastChgDate(currentDate);
		masLaundryMachine.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(masLaundryMachine);
		return dataDeleted;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchLaundry(String machineName) {
		List<MasLaundryMachine> searchLaundryList = new ArrayList<MasLaundryMachine>();
		Map<String, Object> machineFieldsMap = new HashMap<String, Object>();
		try {
			if (machineName != null) {

				searchLaundryList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasLaundryMachine imc where imc.MahineName like '"
										+ machineName
										+ "%' order by imc.MahineName");
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchPoolCategoryList  " + e);
		}
		machineFieldsMap.put("searchLaundryList", searchLaundryList);
		return machineFieldsMap;
	}

	/**
	 * ------------------------------ method to show linen weight
	 * master----------------------------
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> showLinenWeightJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasLinenWeight> searchLinenWeightList = new ArrayList<MasLinenWeight>();
		searchLinenWeightList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasLinenWeight ");
		map.put("searchLinenWeightList", searchLinenWeightList);
		return map;
	}

	public boolean addLinenWeight(MasLinenWeight masLinen) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(masLinen);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unused")
	public boolean editLinenWeight(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String name = (String) generalMap.get("name");
		String code = (String) generalMap.get("code");
		BigDecimal weight = (BigDecimal) generalMap.get("weight");

		int linenId = 0;
		String changedBy = "";
		try {
			linenId = (Integer) generalMap.get("id");
			name = (String) generalMap.get("name");
			code = (String) generalMap.get("code");
			weight = (BigDecimal) generalMap.get("weight");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
		} catch (Exception e) {
			System.out
					.println("Exception before MasLaundryMachine in dataserviceImpl "
							+ e);
		}

		MasLinenWeight masLinenWeight = (MasLinenWeight) getHibernateTemplate()
				.get(MasLinenWeight.class, linenId);

		masLinenWeight.setId(linenId);
		masLinenWeight.setItemCode(code);
		masLinenWeight.setItemName(name);
		masLinenWeight.setWeight(weight);
		masLinenWeight.setLastChgBy(changedBy);
		masLinenWeight.setLastChgDate(currentDate);
		masLinenWeight.setLastChgTime(currentTime);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(masLinenWeight);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	public boolean deleteLinenWeight(int linenId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasLinenWeight masLinen = new MasLinenWeight();
		masLinen = (MasLinenWeight) getHibernateTemplate().get(
				MasLinenWeight.class, linenId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masLinen.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masLinen.setStatus("y");
				dataDeleted = false;
			}
		}
		masLinen.setLastChgBy(changedBy);
		masLinen.setLastChgDate(currentDate);
		masLinen.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(masLinen);
		return dataDeleted;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchLinenWeight(String linenCode,
			String linenName) {
		List<MasLinenWeight> searchLinenWeightList = new ArrayList<MasLinenWeight>();
		Map<String, Object> linenFieldsMap = new HashMap<String, Object>();
		try {
			if ((linenName != null) || (linenCode == null)) {

				searchLinenWeightList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasLinenWeight imc where imc.ItemName like '"
								+ linenName + "%' order by imc.ItemName");
			} else {
				searchLinenWeightList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasLinenWeight imc where imc.ItemCode like '"
								+ linenCode + "%' order by imc.ItemCode");
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchLinenWeightList  " + e);
		}
		linenFieldsMap.put("searchLinenWeightList", searchLinenWeightList);
		return linenFieldsMap;
	}

	/**
	 * --------------------------------------method for machine activity
	 * entry------------------------
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> showMachineActivityEntry() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MachineActivity> machineActivityList = new ArrayList<MachineActivity>();
		List<MasLaundryMachine> laundryList = new ArrayList<MasLaundryMachine>();
		List<MasLaundryMachine> gridLaundryList = new ArrayList<MasLaundryMachine>();
		machineActivityList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MachineActivity");
		laundryList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasLaundryMachine where Status='y'");
		gridLaundryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasLaundryMachine as isc");
		map.put("machineActivityList", machineActivityList);
		map.put("laundryList", laundryList);
		map.put("gridLaundryList", gridLaundryList);
		return map;
	}

	/**
	 * ------------------------ method to get entry no in machine activity entry
	 * -----------------------------------
	 */

	@SuppressWarnings("unchecked")
	public String generateEntryNumber(Map<String, Object> diagMap) {
		List<TransactionSequence> yearlySeqNoList = new ArrayList<TransactionSequence>();
		List<MachineActivity> seqNoList = new ArrayList<MachineActivity>();
		String lastSeqNo = "";
		String lastSeqYear = "";
		String entryNo = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		seqNoList = session.createCriteria(MachineActivity.class).list();
		if (seqNoList.size() > 0) {
			for (MachineActivity mac : seqNoList) {
				lastSeqNo = mac.getEntryNo();
			}
			StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
			while (str.hasMoreTokens()) {
				lastSeqYear = str.nextToken();

			}
		} else if (lastSeqYear.equals("")) {
			lastSeqYear = currentYear;
		}
		yearlySeqNoList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "MEN")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (yearlySeqNoList.size() > 0) {
			for (TransactionSequence transactionSequence : yearlySeqNoList) {
				TransactionSequence obj = (TransactionSequence) yearlySeqNoList
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
				entryNo = entryNo.concat("/").concat(
						String.valueOf(lastSeqYear));
			}

		} else if (yearlySeqNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("MachineActivity");
			tsObj.setTransactionPrefix("MEN");
			tsObj.setTransactionSequenceName("MachineEntryNo");
			tsObj.setTransactionSequenceNumber(0);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");
			hbt.save(tsObj);
			entryNo = entryNo.concat("/").concat(String.valueOf(lastSeqYear));
		}
		return entryNo;
	}

	@SuppressWarnings("unchecked")
	public String getEntryNumber(String string) {

		List<Integer> entrySeqNoList = new ArrayList<Integer>();
		List<MachineActivity> seqNoList = new ArrayList<MachineActivity>();
		String entryNo = "";
		String lastSeqNo = "";
		String lastSeqYear = "";

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");

		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		try {
			seqNoList = session.createCriteria(MachineActivity.class).list();
			if (seqNoList.size() > 0) {
				for (MachineActivity accom : seqNoList) {
					lastSeqNo = accom.getEntryNo();
				}
				StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
				while (str.hasMoreTokens()) {
					lastSeqYear = str.nextToken();
				}
			} else {
				lastSeqYear = currentYear;
			}

			entrySeqNoList = session.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "MEN"))
					.setProjection(
							Projections.projectionList().add(
									Projections
											.max("TransactionSequenceNumber")))
					.list();
			if (entrySeqNoList.size() > 0 && entrySeqNoList.get(0) != null) {
				for (Integer maxOrderNo : entrySeqNoList) {
					if (currentYear.equals(lastSeqYear)) {
						entryNo = String.valueOf(maxOrderNo + 1);
					} else {
						entryNo = String.valueOf(1);
					}
				}
			} else {
				entryNo = String.valueOf(1);
			}

			entryNo = entryNo.concat("/").concat(String.valueOf(lastSeqYear));
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return entryNo;
			
	}

	public boolean addMachineActivityEntry(MachineActivity machineActivity) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(machineActivity);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unused")
	public boolean editMachineActivity(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int machineActivityId = 0;
		Date entryDate = new Date();
		Date activityDate = new Date();
		int machineName = 0;
		String timeOn = "";
		String timeOff = "";
		String totalTime = "";
		String entry = "";

		String changedBy = "";
		try {
			machineActivityId = (Integer) generalMap.get("id");
			activityDate = (Date) generalMap.get("activityDate");
			entryDate = (Date) generalMap.get("entryDate");
			machineName = (Integer) generalMap.get("machineName");
			timeOn = (String) generalMap.get("timeOn");
			timeOff = (String) generalMap.get("timeOff");
			totalTime = (String) generalMap.get("totalTime");
			currentDate = (Date) generalMap.get("currentDate");
			changedBy = (String) generalMap.get("changedBy");
			entry = (String) generalMap.get("entry");

			currentTime = (String) generalMap.get("currentTime");
		} catch (Exception e) {
			System.out
					.println("Exception before MachineActivity in dataserviceImpl "
							+ e);
		}

		MachineActivity obj = (MachineActivity) getHibernateTemplate().get(
				MachineActivity.class, machineActivityId);

		obj.setId(machineActivityId);
		obj.setEntryNo(entry);
		obj.setActivityDate(activityDate);
		obj.setEntryDate(entryDate);
		obj.setTimeOff(timeOff);
		obj.setTimeOn(timeOn);
		obj.setTotalHrs(totalTime);
		obj.setLastChgBy(changedBy);
		obj.setLastChgDate(currentDate);
		obj.setLastChgTime(currentTime);
		if (machineName != '0') {
			MasLaundryMachine maslaun = new MasLaundryMachine();
			maslaun.setId(machineName);
			obj.setMachine(maslaun);
		}
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(obj);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	public boolean deleteMachineActivity(int machineActivityId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MachineActivity machineActivity = new MachineActivity();
		machineActivity = (MachineActivity) getHibernateTemplate().get(
				MachineActivity.class, machineActivityId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				machineActivity.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				machineActivity.setStatus("y");
				dataDeleted = false;
			}
		}
		machineActivity.setLastChgBy(changedBy);
		machineActivity.setLastChgDate(currentDate);
		machineActivity.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(machineActivity);
		return dataDeleted;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchMachineActivity(String entryId,
			Date entryDate) {
		List<MachineActivity> machineActivityList = new ArrayList<MachineActivity>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasLaundryMachine> laundryList = new ArrayList<MasLaundryMachine>();
		List<MasLaundryMachine> gridLaundryList = new ArrayList<MasLaundryMachine>();

		Session session = (Session) getSession();
		Criteria crit = null;
		if (mapForDs.get("entryDate") != null) {
			entryDate = (Date) mapForDs.get("entryDate");
		}
		if (mapForDs.get("entryId") != null) {
			entryId = (String) mapForDs.get("entryId");
		}

		try {
			crit = session.createCriteria(MachineActivity.class);
			if (!entryId.equals("")) {
				crit = crit.add(Restrictions.like("EntryNo", entryId + "%"));
			}
			if (!entryDate.equals("")) {
				crit = crit.add(Restrictions.eq("EntryDate", entryDate));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		machineActivityList = crit.list();

		laundryList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasLaundryMachine where Status='y'");
		gridLaundryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasLaundryMachine as isc");
		map.put("laundryList", laundryList);
		map.put("machineActivityList", machineActivityList);
		map.put("gridLaundryList", gridLaundryList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public String generateEntryNumberForDiaryEntry(Map<String, Object> diagMap) {
		List<TransactionSequence> yearlySeqNoList = new ArrayList<TransactionSequence>();
		List<CarDiaryEntry> seqNoList = new ArrayList<CarDiaryEntry>();
		String lastSeqNo = "";
		String lastSeqYear = "";
		String entryNo = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		seqNoList = session.createCriteria(CarDiaryEntry.class).list();
		if (seqNoList.size() > 0) {
			for (CarDiaryEntry mac : seqNoList) {
				lastSeqNo = mac.getEntryNo();
			}
			StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
			while (str.hasMoreTokens()) {
				lastSeqYear = str.nextToken();

			}
		} else if (lastSeqYear.equals("")) {
			lastSeqYear = currentYear;
		}
		yearlySeqNoList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "DEN")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (yearlySeqNoList.size() > 0) {
			for (TransactionSequence transactionSequence : yearlySeqNoList) {
				TransactionSequence obj = (TransactionSequence) yearlySeqNoList
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
				entryNo = seqNo + "";
				entryNo = entryNo.concat("/").concat(
						String.valueOf(lastSeqYear));
			}

		} else if (yearlySeqNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("CarDiaryEntry");
			tsObj.setTransactionPrefix("DEN");
			tsObj.setTransactionSequenceName("DiaryEntryNo");
			tsObj.setTransactionSequenceNumber(0);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");
			hbt.save(tsObj);
			entryNo = entryNo.concat("/").concat(String.valueOf(lastSeqYear));
		}
		return entryNo;
	}

	@SuppressWarnings("unchecked")
	public String getEntryNumberForDiaryEntry(String string) {
		List<Integer> entrySeqNoList = new ArrayList<Integer>();
		List<CarDiaryEntry> seqNoList = new ArrayList<CarDiaryEntry>();
		String entryNo = "";
		String lastSeqNo = "";
		String lastSeqYear = "";

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");

		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		try {
			seqNoList = session.createCriteria(CarDiaryEntry.class).list();
			if (seqNoList.size() > 0) {
				for (CarDiaryEntry accom : seqNoList) {
					lastSeqNo = accom.getEntryNo();
				}
				StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
				while (str.hasMoreTokens()) {
					lastSeqYear = str.nextToken();
				}
			} else {
				lastSeqYear = currentYear;
			}

			entrySeqNoList = session.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "DEN"))
					.setProjection(
							Projections.projectionList().add(
									Projections
											.max("TransactionSequenceNumber")))
					.list();
			if (entrySeqNoList.size() > 0 && entrySeqNoList.get(0) != null) {
				for (Integer maxOrderNo : entrySeqNoList) {
					if (currentYear.equals(lastSeqYear)) {
						entryNo = String.valueOf(maxOrderNo + 1);
					} else {
						entryNo = String.valueOf(1);
					}
				}
			} else {
				entryNo = String.valueOf(1);
			}

			entryNo = entryNo.concat("/").concat(String.valueOf(lastSeqYear));
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return entryNo;
	}

	/**
	 * -------------- method to show jsp of Drivers Car Diary
	 * Entry----------------------------------
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> showCarDiaryEntry() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<CarDiaryEntry> carDiaryEntryList = new ArrayList<CarDiaryEntry>();
		carDiaryEntryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.CarDiaryEntry");
		map.put("carDiaryEntryList", carDiaryEntryList);
		return map;
	}

	/**
	 * ------------------- method to add car diary entry-------------------
	 */

	public boolean addCarDiaryEntry(CarDiaryEntry carDiaryEntry) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(carDiaryEntry);
		successfullyAdded = true;
		return successfullyAdded;
	}

	/**
	 * --------------- method to delete car diary
	 * entry------------------------------
	 */
	public boolean deleteCarDiaryEntry(int carEntryId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		CarDiaryEntry carDiaryEntry = new CarDiaryEntry();
		carDiaryEntry = (CarDiaryEntry) getHibernateTemplate().get(
				CarDiaryEntry.class, carEntryId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				carDiaryEntry.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				carDiaryEntry.setStatus("y");
				dataDeleted = false;
			}
		}
		carDiaryEntry.setLastChgBy(changedBy);
		carDiaryEntry.setLastChgDate(currentDate);
		carDiaryEntry.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(carDiaryEntry);
		return dataDeleted;
	}

	/**
	 * -----------------------method to edit car diary
	 * entry-----------------------
	 */
	@SuppressWarnings("unused")
	public boolean editCarDiaryEntry(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int carEntryId = 0;
		Date entryDate = new Date();
		String specification = "";
		String fromPlace = "";
		String toPlace = "";
		BigDecimal totalKm = null;

		String changedBy = "";
		try {
			carEntryId = (Integer) generalMap.get("id");
			entryDate = (Date) generalMap.get("entryDate");
			//System.out.println("entryDate----  " + entryDate);
			specification = (String) generalMap.get("specification");
			fromPlace = (String) generalMap.get("fromPlace");
			toPlace = (String) generalMap.get("toPlace");
			totalKm = (BigDecimal) generalMap.get("totalKm");
			currentDate = (Date) generalMap.get("currentDate");
			changedBy = (String) generalMap.get("changedBy");

			currentTime = (String) generalMap.get("currentTime");
		} catch (Exception e) {
			System.out
					.println("Exception before MasLaundryMachine in dataserviceImpl "
							+ e);
		}

		CarDiaryEntry obj = (CarDiaryEntry) getHibernateTemplate().get(
				CarDiaryEntry.class, carEntryId);

		obj.setId(carEntryId);
		obj.setEntryDate(entryDate);
		obj.setFromPlace(fromPlace);
		obj.setToPlace(toPlace);
		obj.setSpecificationOfDuty(specification);
		obj.setTotalKm(totalKm);
		obj.setLastChgBy(changedBy);
		obj.setLastChgDate(currentDate);
		obj.setLastChgTime(currentTime);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(obj);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchCarDiaryEntry(String entryNo,
			Date entryDate) {
		List<CarDiaryEntry> carDiaryEntryList = new ArrayList<CarDiaryEntry>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Criteria crit = null;
		if (mapForDs.get("entryDate") != null) {
			entryDate = (Date) mapForDs.get("entryDate");
		}
		if (mapForDs.get("entryNo") != null) {
			entryNo = (String) mapForDs.get("entryNo");
		}
		try {
			crit = session.createCriteria(CarDiaryEntry.class);
			if (!entryNo.equals("")) {
				crit = crit.add(Restrictions.like("EntryNo", entryNo + "%"));
			}
			if (!entryDate.equals("")) {
				crit = crit.add(Restrictions.eq("EntryDate", entryDate));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		carDiaryEntryList = crit.list();
		map.put("carDiaryEntryList", carDiaryEntryList);
		return map;
	}

	/**
	 * ------------------- method to generate entry no for daily
	 * workload------------------
	 */
	@SuppressWarnings("unchecked")
	public String generateEntryNumberForDailyWorkLoad(
			Map<String, Object> diagMap) {
		List<TransactionSequence> yearlySeqNoList = new ArrayList<TransactionSequence>();
		List<WorkLoadEntry> seqNoList = new ArrayList<WorkLoadEntry>();
		String lastSeqNo = "";
		String lastSeqYear = "";
		String entryNo = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		seqNoList = session.createCriteria(WorkLoadEntry.class).list();
		if (seqNoList.size() > 0) {
			for (WorkLoadEntry mac : seqNoList) {
				lastSeqNo = mac.getEntryNo();
			}
			//System.out.println("lastSeqNo  " + lastSeqNo);
			StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
			while (str.hasMoreTokens()) {
				lastSeqYear = str.nextToken();

			}
		} else if (lastSeqYear.equals("")) {
			lastSeqYear = currentYear;
		}
		yearlySeqNoList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "DWEN")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (yearlySeqNoList.size() > 0) {
			for (TransactionSequence transactionSequence : yearlySeqNoList) {
				TransactionSequence obj = (TransactionSequence) yearlySeqNoList
						.get(0);
				int id = obj.getId();
				int seqNo = 0;

				if (currentYear.equals(lastSeqYear)) {
					seqNo = obj.getTransactionSequenceNumber();
				} else {
					seqNo = 0;
				}
				//System.out.println("seqNo  " + seqNo);
				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
						.load(TransactionSequence.class, id);
				transactionSequenceObj.setTransactionSequenceNumber(seqNo + 1);
				++seqNo;
				hbt.update(transactionSequenceObj);
				hbt.refresh(transactionSequenceObj);
				entryNo = entryNo.concat("/").concat(
						String.valueOf(lastSeqYear));
			}
		} else if (yearlySeqNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("WorkLoadEntry");
			tsObj.setTransactionPrefix("DWEN");
			tsObj.setTransactionSequenceName("WorkLoadEntryNo");
			tsObj.setTransactionSequenceNumber(0);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");
			hbt.save(tsObj);
			entryNo = entryNo.concat("/").concat(String.valueOf(lastSeqYear));
		}
		return entryNo;
	}

	@SuppressWarnings("unchecked")
	public String getEntryNumberForWorkLoad(String string) {
		List<Integer> entrySeqNoList = new ArrayList<Integer>();
		List<WorkLoadEntry> seqNoList = new ArrayList<WorkLoadEntry>();
		String entryNo = "";
		String lastSeqNo = "";
		String lastSeqYear = "";

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");

		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		try {
			seqNoList = session.createCriteria(WorkLoadEntry.class).list();
			if (seqNoList.size() > 0) {
				for (WorkLoadEntry accom : seqNoList) {
					lastSeqNo = accom.getEntryNo();
				}
				StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
				while (str.hasMoreTokens()) {
					lastSeqYear = str.nextToken();
				}
			} else {
				lastSeqYear = currentYear;
			}

			entrySeqNoList = session.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "DWEN"))
					.setProjection(
							Projections.projectionList().add(
									Projections
											.max("TransactionSequenceNumber")))
					.list();
			if (entrySeqNoList.size() > 0 && entrySeqNoList.get(0) != null) {
				for (Integer maxOrderNo : entrySeqNoList) {
					if (currentYear.equals(lastSeqYear)) {
						entryNo = String.valueOf(maxOrderNo + 1);
					} else {
						entryNo = String.valueOf(1);
					}
				}
			} else {
				entryNo = String.valueOf(1);
			}

			entryNo = entryNo.concat("/").concat(String.valueOf(lastSeqYear));
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return entryNo;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showDailyWorkLoad() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		departmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment as md where md.DepartmentType.Id='"
								+ 10 + "' and md.Status='y'");
		map.put("departmentList", departmentList);
		return map;
	}

	Session session;

	@SuppressWarnings("unchecked")
	public Map<String, Object> getItemListByAutocomplete(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasLinenWeight> itemList = new ArrayList<MasLinenWeight>();
		session = (Session) getSession();
		List<MasLinenWeight> objectList = new ArrayList<MasLinenWeight>();
		try {
			String str = dataMap.get("autoHint") + "%";
			String qry = "SELECT linen_weight_id FROM mas_linen_weight";
			objectList = (List<MasLinenWeight>) session.createSQLQuery(qry)
					.list();
			Criteria c = session.createCriteria(MasLinenWeight.class).add(
					Restrictions.like("ItemName", str)).add(
					Restrictions.in("Id", objectList));
			c.setFirstResult(0);
			c.setMaxResults(10);
			itemList = c.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("itemList.size()    " + itemList.size());
		map.put("itemList", itemList);
		return map;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDailyWorkLoad(String entryNo, Date entryDate) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<WorkLoadEntry> workLoadList = new ArrayList<WorkLoadEntry>();
		Map<String, Object> diagMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Criteria crit = null;
		if (diagMap.get("entryDate") != null) {
			entryDate = (Date) diagMap.get("entryDate");
		}
		//System.out.println("entryDate :  " + entryDate);
		if (diagMap.get("entryNo") != null) {
			entryNo = (String) diagMap.get("entryNo");
		}
		//System.out.println("entryNo :  " + entryNo);
		try {
			crit = session.createCriteria(WorkLoadEntry.class);
			if (!entryNo.equals("")) {
				crit = crit.add(Restrictions.like("EntryNo", entryNo + "%"));
			}
			if (!entryDate.equals("")) {
				crit = crit.add(Restrictions.eq("EntryDate", entryDate));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		workLoadList = crit.list();
		//System.out.println("workLoadList.size()  >>  " + workLoadList.size());
		String wrkLoadNo = "";
		List<WorkLoadEntryDetail> workLoadDetailList = new ArrayList<WorkLoadEntryDetail>();
		for (WorkLoadEntry workLoad : workLoadList)
		{
			wrkLoadNo = workLoad.getEntryNo();
			workLoadDetailList = getHibernateTemplate().find("from jkt.hms.masters.business.WorkLoadEntryDetail as wd where wd.WorkLoad.EntryNo='" + wrkLoadNo + "'");
		}
		//System.out.println("workLoadDetailList  >>  size "+ workLoadDetailList.size());
		//System.out.println("wrkLoadNo "	+ wrkLoadNo);
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		departmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment as md where md.DepartmentType.Id='"
								+ 10 + "' and md.Status='y'");
		map.put("departmentList", departmentList);
		map.put("workLoadList", workLoadList);
		map.put("workLoadDetailList", workLoadDetailList);
		return map;
	}

	/**
	 * ----------------- method to add daily work load details
	 * --------------------------
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> addDailyWorkLoadEntry(Box box,
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		WorkLoadEntry workLoadEntry = new WorkLoadEntry();
		boolean saved = false;
		Session session = (Session) getSession();
		if (dataMap.get("box") != null) {
			box = (Box) dataMap.get("box");
		}
		String entryNo = box.getString(RequestConstants.ENTRY_NO);
		Date entryDate = HMSUtil.dateFormatterDDMMYYYY(box
				.getString(RequestConstants.ENTRY_DATE));
		int deptId = box.getInt("deptId");
		int hospitalId = box.getInt("hospitalId");
		String changedBy = box.getString(RequestConstants.CHANGED_BY);
		String currentTime = box.getString(RequestConstants.CHANGED_TIME);
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		workLoadEntry.setEntryNo(entryNo);
		workLoadEntry.setEntryDate(entryDate);
		MasDepartment masDept = new MasDepartment();
		masDept.setId(deptId);
		workLoadEntry.setDepartment(masDept);
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		workLoadEntry.setHospital(masHospital);
		workLoadEntry.setLastChgBy(changedBy);
		workLoadEntry.setLastChgTime(currentTime);
		workLoadEntry.setStatus("y");
		workLoadEntry.setLastChgDate(date);

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(workLoadEntry);

			Integer departmentId = box.getInt(RequestConstants.DEPARTMENT_ID);
			//System.out.println("departmentId  --  " + departmentId);
			Vector item = box.getVector(RequestConstants.ITEM_ID);
			//System.out.println("item  --  " + item);
			Vector quantity = box.getVector(RequestConstants.QUANTITY);
			//System.out.println("quantity  --  " + quantity);
			Vector select = box.getVector("select");
			//System.out.println("select  --  " + select);

			for (int i = 0; i < select.size(); i++) {
				if (select.get(i) != null && !select.get(i).equals("")) {
					int item_id = Integer.parseInt((String) item.get(i));
					WorkLoadEntryDetail workLoadEntryDetail = new WorkLoadEntryDetail();
					workLoadEntryDetail.setWorkLoad(workLoadEntry);

					if (departmentId != null && !departmentId.equals("")) {
						MasDepartment masDepartment = new MasDepartment();
						masDepartment.setId(departmentId);
						workLoadEntryDetail.setDepartment(masDepartment);
					}

					workLoadEntryDetail.setQuantity(new BigDecimal(quantity
							.get(i).toString()));
					if (select != null && !select.equals("")) {
						workLoadEntryDetail.setSelectStatus("y");
					}

					MasLinenWeight masLinenWeight = new MasLinenWeight();
					masLinenWeight.setId(item_id);
					workLoadEntryDetail.setLinenWeight(masLinenWeight);

					hbt.save(workLoadEntryDetail);
				}
			}
			saved = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			//System.out.println("Error ocurred!! please try again");
			e.printStackTrace();

		}
		map.put("saved", saved);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> fillItems(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();

		List itemList = new ArrayList();
		Session session = (Session) getSession();
		String itemName = (String) dataMap.get("itemName");
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			itemList = session.createCriteria(MasLinenWeight.class).add(
					Restrictions.eq("ItemName", itemName)).list();
			map.put("itemList", itemList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> editDailyWorkLoadEntry(Box box,
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		WorkLoadEntry workLoadEntry = new WorkLoadEntry();
		boolean saved = false;
		Session session = (Session) getSession();
		if (dataMap.get("box") != null) {
			box = (Box) dataMap.get("box");
		}
		int workId = box.getInt("workId");
		//System.out.println("workId---->"+workId);
		String entryNo = box.getString(RequestConstants.ENTRY_NO);
		Date entryDate = HMSUtil.dateFormatterddmmyy(box.getString(RequestConstants.ENTRY_DATE));
		int deptId = box.getInt("deptId");
		int hospitalId = box.getInt("hospitalId");
		String changedBy = box.getString(RequestConstants.CHANGED_BY);
		String currentTime = box.getString(RequestConstants.CHANGED_TIME);

		workLoadEntry.setId(workId);
		workLoadEntry.setEntryNo(entryNo);
		workLoadEntry.setEntryDate(entryDate);
		MasDepartment masDept = new MasDepartment();
		masDept.setId(deptId);
		workLoadEntry.setDepartment(masDept);
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		workLoadEntry.setHospital(masHospital);
		workLoadEntry.setLastChgBy(changedBy);
		workLoadEntry.setLastChgTime(currentTime);

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			List<WorkLoadEntryDetail> workDetailList = new ArrayList<WorkLoadEntryDetail>();
			workDetailList = session.createCriteria(WorkLoadEntryDetail.class)
					.add(Restrictions.eq("WorkLoad.Id", workId)).list();
			hbt.deleteAll(workDetailList);

			Vector departmentId = box.getVector(RequestConstants.DEPARTMENT_ID);
			Vector item = box.getVector(RequestConstants.ITEM_ID);
			Vector quantity = box.getVector(RequestConstants.QUANTITY);
			Vector select = box.getVector("select");
			for (int i = 0; i < select.size(); i++) {
				if (select.get(i) != null && !select.get(i).equals("")) {

					WorkLoadEntryDetail workLoadEntryDetail = new WorkLoadEntryDetail();
					workLoadEntryDetail.setWorkLoad(workLoadEntry);

					MasDepartment masDepartment = new MasDepartment();
					masDepartment.setId(Integer.parseInt((String) departmentId.get(i)));
					workLoadEntryDetail.setDepartment(masDepartment);
					workLoadEntryDetail.setQuantity(new BigDecimal(quantity.get(i).toString()));
					if (select != null && !select.equals("")) {
						workLoadEntryDetail.setSelectStatus("y");
					}
					if (item.get(i) != null && !item.get(i).equals("")) {
						int item_id = Integer.parseInt((String) item.get(i));
						MasLinenWeight masLinenWeight = new MasLinenWeight();
						masLinenWeight.setId(item_id);
						workLoadEntryDetail.setLinenWeight(masLinenWeight);
					}
					hbt.save(workLoadEntryDetail);
				}
			}
			saved = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			//System.out.println("Error ocurred!! please try again");
			e.printStackTrace();

		}
		map.put("saved", saved);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> checkForExistingMasters(
			Map<String, Object> generalMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasLaundryMachine> duplicateGeneralNameList = new ArrayList<MasLaundryMachine>();

		int id = 0;

		String pojoPropertyName = "";

		if (generalMap.get("id") != null) {
			id = (Integer) generalMap.get("id");
		}

		String machineName = (String) generalMap.get("machineName");
		if (generalMap.get("pojoPropertyName") != null)
			pojoPropertyName = (String) generalMap.get("pojoPropertyName");
		if (!pojoPropertyName.equals("")) {

			duplicateGeneralNameList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasLaundryMachine as g where g.MahineName='"
							+ machineName + "'");
		}

		map.put("duplicateGeneralNameList", duplicateGeneralNameList);
		return map;
	}

	/**
	 * method for report connection
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> getConnectionForReport() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Connection conn = session.connection();
		map.put("conn", conn);
		return map;

	}

}
