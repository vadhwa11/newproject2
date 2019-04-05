package jkt.hms.medicalboard.dataservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MbTypeOfEntryMaster;
import jkt.hms.util.HMSUtil;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class TypeOfEntryMasterDataServiceImpl extends HibernateDaoSupport
		implements TypeOfEntryMasterDataService {

	@SuppressWarnings("unchecked")
	public Map<String, Object> showTypeOfEntryMasterJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MbTypeOfEntryMaster> searchTypeOfEntryMasterList = new ArrayList<MbTypeOfEntryMaster>();
		searchTypeOfEntryMasterList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MbTypeOfEntryMaster");
		map.put("searchTypeOfEntryMasterList", searchTypeOfEntryMasterList);
		return map;
	}

	public boolean addTypeOfEntryMaster(MbTypeOfEntryMaster masTypeOfEntryMaster) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(masTypeOfEntryMaster);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchTypeOfEntryMaster(
			String typeOfEntryMasterName) {
		List<MbTypeOfEntryMaster> searchTypeOfEntryMasterList = new ArrayList<MbTypeOfEntryMaster>();
		Map<String, Object> typeOfEntryMasterFieldsMap = new HashMap<String, Object>();
		try {
			if ((typeOfEntryMasterName != null)) {

				searchTypeOfEntryMasterList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MbTypeOfEntryMaster imc where imc.TypeName like '"
										+ typeOfEntryMasterName
										+ "%' order by imc.TypeName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		typeOfEntryMasterFieldsMap.put("searchTypeOfEntryMasterList",
				searchTypeOfEntryMasterList);
		return typeOfEntryMasterFieldsMap;

	}

	public boolean editTypeOfEntryMasterToDatabase(
			Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		String status = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String typeOfEntryMasterName = "";
		@SuppressWarnings("unused")
		String typeOfEntryMasterCode = "";
		int typeOfEntryMasterId = 0;
		String changedBy = "";
		typeOfEntryMasterId = (Integer) generalMap.get("id");
		typeOfEntryMasterName = (String) generalMap
				.get("typeOfEntryMasterName");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		status = (String) generalMap.get("status");
		MbTypeOfEntryMaster masTypeOfEntryMaster = (MbTypeOfEntryMaster) getHibernateTemplate()
				.load(MbTypeOfEntryMaster.class, typeOfEntryMasterId);

		masTypeOfEntryMaster.setId(typeOfEntryMasterId);
		masTypeOfEntryMaster.setTypeName(typeOfEntryMasterName);
		masTypeOfEntryMaster.setLastChgBy(changedBy);
		masTypeOfEntryMaster.setLastChgDate(currentDate);
		masTypeOfEntryMaster.setLastChgTime(currentTime);
		masTypeOfEntryMaster.setStatus(status);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masTypeOfEntryMaster);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean deleteTypeOfEntryMaster(int typeOfEntryMasterId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MbTypeOfEntryMaster masTypeOfEntryMaster = new MbTypeOfEntryMaster();
		masTypeOfEntryMaster = (MbTypeOfEntryMaster) getHibernateTemplate()
				.load(MbTypeOfEntryMaster.class, typeOfEntryMasterId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masTypeOfEntryMaster.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masTypeOfEntryMaster.setStatus("y");
				dataDeleted = false;
			}
		}
		masTypeOfEntryMaster.setLastChgBy(changedBy);
		masTypeOfEntryMaster.setLastChgDate(currentDate);
		masTypeOfEntryMaster.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masTypeOfEntryMaster);
		return dataDeleted;
	}
}
