package jkt.hms.masters.dataservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasBloodBankStatus;
import jkt.hms.masters.business.MasBloodDonationType;
import jkt.hms.masters.business.MasBloodGroup;
import jkt.hms.util.HMSUtil;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BloodBankMasterDataServiceImpl extends HibernateDaoSupport
		implements BloodBankMasterDataService {
	Map<String, Object> map = new HashMap<String, Object>();

	// -------------------------------------Blood Bank
	// Status------------------------------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> showBloodBankStatusJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasBloodBankStatus> searchBloodBankStatusList = new ArrayList<MasBloodBankStatus>();
		searchBloodBankStatusList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasBloodBankStatus ");
		map.put("searchBloodBankStatusList", searchBloodBankStatusList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchBloodBankStatus(
			String bloodBankStatusCode, String bloodBankStatusName) {
		List<MasBloodBankStatus> searchBloodBankStatusList = new ArrayList<MasBloodBankStatus>();
		Map bloodBankStatusFieldsMap = new HashMap();
		try {
			if ((bloodBankStatusName != null) || (bloodBankStatusCode == null)) {
				searchBloodBankStatusList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasBloodBankStatus mbg where mbg.BloodBankStatusName like '"
										+ bloodBankStatusName
										+ "%' order by mbg.BloodBankStatusName");
			} else {
				searchBloodBankStatusList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasBloodBankStatus mbg where mbg.BloodBankStatusCode like '"
										+ bloodBankStatusCode
										+ "%' order by mbg.BloodBankStatusCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		bloodBankStatusFieldsMap.put("searchBloodBankStatusList",
				searchBloodBankStatusList);
		return bloodBankStatusFieldsMap;
	}

	public boolean addBloodBankStatus(MasBloodBankStatus masBloodBankStatus) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(masBloodBankStatus);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteBloodBankStatus(int bloodBankStatusId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasBloodBankStatus masBloodBankStatus = new MasBloodBankStatus();
		masBloodBankStatus = (MasBloodBankStatus) getHibernateTemplate().get(
				MasBloodBankStatus.class, bloodBankStatusId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masBloodBankStatus.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masBloodBankStatus.setStatus("y");
				dataDeleted = false;
			}
		}
		masBloodBankStatus.setLastChgBy(changedBy);
		masBloodBankStatus.setLastChgDate(currentDate);
		masBloodBankStatus.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masBloodBankStatus);
		return dataDeleted;
	}

	public boolean editBloodBankStatusToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String bloodBankStatusName = "";
		@SuppressWarnings("unused")
		String bloodBankStatusCode = "";
		int bloodBankStatusId = 0;
		String changedBy = "";
		bloodBankStatusId = (Integer) generalMap.get("id");
		bloodBankStatusCode = (String) generalMap.get("bloodBankStatusCode");
		bloodBankStatusName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasBloodBankStatus masBloodBankStatus = (MasBloodBankStatus) getHibernateTemplate()
				.get(MasBloodBankStatus.class, bloodBankStatusId);
		masBloodBankStatus.setId(bloodBankStatusId);
		masBloodBankStatus.setBloodBankStatusName(bloodBankStatusName);
		masBloodBankStatus.setLastChgBy(changedBy);
		masBloodBankStatus.setLastChgDate(currentDate);
		masBloodBankStatus.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masBloodBankStatus);
		dataUpdated = true;
		return dataUpdated;
	}

	// ----------------------------------------------For Blood Donation
	// type-----------------------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> showBloodDonationTypeJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasBloodDonationType> searchBloodDonationTypeList = new ArrayList<MasBloodDonationType>();
		searchBloodDonationTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasBloodDonationType ");
		map.put("searchBloodDonationTypeList", searchBloodDonationTypeList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchBloodDonationType(
			String bloodDonationTypeCode, String bloodDonationTypeName) {
		List<MasBloodDonationType> searchBloodDonationTypeList = new ArrayList<MasBloodDonationType>();
		Map bloodDonationTypeFieldsMap = new HashMap();
		try {
			if ((bloodDonationTypeName != null)
					|| (bloodDonationTypeCode == null)) {

				searchBloodDonationTypeList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasBloodDonationType mbg where mbg.BloodDonationTypeName like '"
										+ bloodDonationTypeName
										+ "%' order by mbg.BloodDonationTypeName");
			} else {
				searchBloodDonationTypeList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasBloodDonationType mbg where mbg.BloodDonationTypeCode like '"
										+ bloodDonationTypeCode
										+ "%' order by mbg.BloodDonationTypeCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		bloodDonationTypeFieldsMap.put("searchBloodDonationTypeList",
				searchBloodDonationTypeList);
		return bloodDonationTypeFieldsMap;
	}

	public boolean addBloodDonationType(
			MasBloodDonationType masBloodDonationType) {
		boolean dataSaved = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(masBloodDonationType);
		dataSaved = true;
		return dataSaved;
	}

	public boolean deleteBloodDonationType(int bloodDonationTypeId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasBloodDonationType masBloodDonationType = new MasBloodDonationType();
		masBloodDonationType = (MasBloodDonationType) getHibernateTemplate()
				.get(MasBloodDonationType.class, bloodDonationTypeId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masBloodDonationType.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masBloodDonationType.setStatus("y");
				dataDeleted = false;
			}
		}
		masBloodDonationType.setLastChgBy(changedBy);
		masBloodDonationType.setLastChgDate(currentDate);
		masBloodDonationType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masBloodDonationType);
		return dataDeleted;
	}

	public boolean editBloodDonationTypeToDatabase(
			Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String bloodDonationTypeName = "";
		@SuppressWarnings("unused")
		String bloodDonationTypeCode = "";
		int bloodDonationTypeId = 0;
		String changedBy = "";
		bloodDonationTypeId = (Integer) generalMap.get("id");
		bloodDonationTypeCode = (String) generalMap
				.get("bloodDonationTypeCode");
		bloodDonationTypeName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasBloodDonationType masBloodDonationType = (MasBloodDonationType) getHibernateTemplate()
				.get(MasBloodDonationType.class, bloodDonationTypeId);
		masBloodDonationType.setId(bloodDonationTypeId);
		masBloodDonationType.setBloodDonationTypeName(bloodDonationTypeName);
		masBloodDonationType.setLastChgBy(changedBy);
		masBloodDonationType.setLastChgDate(currentDate);
		masBloodDonationType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masBloodDonationType);
		dataUpdated = true;
		return dataUpdated;
	}

	// -----------------------------------------Blood
	// Group--------------------------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> showBloodGroupJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasBloodGroup> searchBloodGroupList = new ArrayList<MasBloodGroup>();
		searchBloodGroupList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasBloodGroup ");
		map.put("searchBloodGroupList", searchBloodGroupList);
		return map;
	}

	public boolean addBloodGroup(MasBloodGroup masBloodGroup) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(masBloodGroup);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteBloodGroup(int bloodGroupId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasBloodGroup masBloodGroup = new MasBloodGroup();
		masBloodGroup = (MasBloodGroup) getHibernateTemplate().get(
				MasBloodGroup.class, bloodGroupId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masBloodGroup.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masBloodGroup.setStatus("y");
				dataDeleted = false;
			}
		}
		masBloodGroup.setLastChgBy(changedBy);
		masBloodGroup.setLastChgDate(currentDate);
		masBloodGroup.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masBloodGroup);
		return dataDeleted;
	}

	public boolean editBloodGroupToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String bloodGroupName = "";
		@SuppressWarnings("unused")
		String bloodGroupCode = "";
		int bloodGroupId = 0;
		String changedBy = "";
		bloodGroupId = (Integer) generalMap.get("id");
		bloodGroupCode = (String) generalMap.get("bloodGroupCode");
		bloodGroupName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasBloodGroup masBloodGroup = (MasBloodGroup) getHibernateTemplate()
				.get(MasBloodGroup.class, bloodGroupId);

		masBloodGroup.setId(bloodGroupId);
		masBloodGroup.setBloodGroupName(bloodGroupName);
		masBloodGroup.setLastChgBy(changedBy);
		masBloodGroup.setLastChgDate(currentDate);
		masBloodGroup.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masBloodGroup);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchBloodGroup(String bloodGroupCode,
			String bloodGroupName) {
		List<MasBloodGroup> searchBloodGroupList = new ArrayList<MasBloodGroup>();
		Map bloodGroupFieldsMap = new HashMap();
		try {
			if ((bloodGroupName != null) || (bloodGroupCode == null)) {
				searchBloodGroupList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasBloodGroup mbg where mbg.BloodGroupName like '"
										+ bloodGroupName
										+ "%' order by mbg.BloodGroupName");
			} else {
				searchBloodGroupList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasBloodGroup mbg where mbg.BloodGroupCode like '"
										+ bloodGroupCode
										+ "%' order by mbg.BloodGroupCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		bloodGroupFieldsMap.put("searchBloodGroupList", searchBloodGroupList);
		return bloodGroupFieldsMap;
	}

}