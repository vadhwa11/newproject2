package jkt.hms.medicalboard.dataservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MbInstructionToCandidateMaster;
import jkt.hms.medicalboard.controller.InstructionToCandidateSearchDTO;
import jkt.hms.util.HMSUtil;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class InstructionToCandidateSearchDataServiceImpl extends
		HibernateDaoSupport implements InstructionToCandidateSearchDataService {
	Map<String, Object> map = new HashMap<String, Object>();

	@SuppressWarnings("unchecked")
	public Map<String, Object> showInstructionToCandidateSearchJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MbInstructionToCandidateMaster> instructionToCandidateList = new ArrayList<MbInstructionToCandidateMaster>();

		instructionToCandidateList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MbInstructionToCandidateMaster");
		map.put("mbInstructionToCandidateMasterList",
				instructionToCandidateList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchInstructionToCandidateSearch(
			InstructionToCandidateSearchDTO instructionToCandidateSearch) {
		List<MbInstructionToCandidateMaster> searchInstructionToCandidateSearchList = new ArrayList<MbInstructionToCandidateMaster>();

		Map<String, Object> instructionToCandidateSearchFieldsMap = new HashMap<String, Object>();

		String entryNo = "";
		String entryDate = "";
		String batchNo = "";
		String chestNo = "";
		String name = "";
		int entryNoIntValue = 0;
		Date entryDate1 = null;
		Session session = (Session) getSession();
		if (instructionToCandidateSearch.getEntryNo() != null
				&& !instructionToCandidateSearch.getEntryNo().equalsIgnoreCase(
						"")) {
			entryNo = instructionToCandidateSearch.getEntryNo();
			entryNoIntValue = Integer.parseInt(entryNo);
		}

		if (instructionToCandidateSearch.getEntryDate() != null
				&& !instructionToCandidateSearch.getEntryDate()
						.equalsIgnoreCase("")) {
			entryDate = instructionToCandidateSearch.getEntryDate();
			entryDate1 = HMSUtil.convertStringTypeDateToDateType(entryDate);
		}
		if (instructionToCandidateSearch.getBatchNo() != null
				&& !instructionToCandidateSearch.getBatchNo().equalsIgnoreCase(
						"")) {
			batchNo = instructionToCandidateSearch.getBatchNo();
		}
		if (instructionToCandidateSearch.getChestNo() != null
				&& !instructionToCandidateSearch.getChestNo().equalsIgnoreCase(
						"")) {
			chestNo = instructionToCandidateSearch.getChestNo();
		}
		if (instructionToCandidateSearch.getName() != null
				&& !instructionToCandidateSearch.getName().equalsIgnoreCase("")) {
			name = instructionToCandidateSearch.getName();
		}

		try {
			Criteria crit = session
					.createCriteria(MbInstructionToCandidateMaster.class);

			if (entryNoIntValue != 0) {
				crit = crit.add(Restrictions.eq("EntryNo", entryNoIntValue));
			}
			if (entryDate1 != null && !entryDate1.equals("")) {
				crit = crit.add(Restrictions.eq("EntryDate", entryDate1));
			}
			if (!batchNo.equals("")) {
				crit = crit.add(Restrictions.like("BatchNo", batchNo + "%"));
			}
			if (!chestNo.equals("")) {
				crit = crit.add(Restrictions.like("ChestNo", chestNo + "%"));
			}
			if (!name.equals("")) {
				crit = crit.add(Restrictions.like("Name", name + "%"));
			}
			searchInstructionToCandidateSearchList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		instructionToCandidateSearchFieldsMap.put(
				"searchInstructionToCandidateSearchList",
				searchInstructionToCandidateSearchList);
		return instructionToCandidateSearchFieldsMap;
	}
}
