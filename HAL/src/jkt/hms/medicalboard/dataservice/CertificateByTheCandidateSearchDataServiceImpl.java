package jkt.hms.medicalboard.dataservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MbCertificateByCandidateMaster;
import jkt.hms.medicalboard.controller.CertificateByTheCandidateSearchDTO;
import jkt.hms.util.HMSUtil;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CertificateByTheCandidateSearchDataServiceImpl extends
		HibernateDaoSupport implements
		CertificateByTheCandidateSearchDataService {
	Map<String, Object> map = new HashMap<String, Object>();

	@SuppressWarnings("unchecked")
	public Map<String, Object> showCertificateByTheCandidateSearchJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MbCertificateByCandidateMaster> certificateByTheCandidateList = new ArrayList<MbCertificateByCandidateMaster>();

		certificateByTheCandidateList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MbCertificateByCandidateMaster");
		map.put("mbCertificateByTheCandidateMasterList",
				certificateByTheCandidateList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchCertificateByTheCandidateSearch(
			CertificateByTheCandidateSearchDTO certificateByTheCandidateSearch) {
		List<MbCertificateByCandidateMaster> searchCertificateByTheCandidateSearchList = new ArrayList<MbCertificateByCandidateMaster>();

		Map<String, Object> certificateByTheCandidateSearchFieldsMap = new HashMap<String, Object>();

		String entryNo = "";
		String entryDate = "";
		String batchNo = "";
		String chestNo = "";
		String name = "";
		int entryNoIntValue = 0;
		Date entryDate1 = null;
		Session session = (Session) getSession();
		if (certificateByTheCandidateSearch.getEntryNo() != null
				&& !certificateByTheCandidateSearch.getEntryNo()
						.equalsIgnoreCase("")) {
			entryNo = certificateByTheCandidateSearch.getEntryNo();
			entryNoIntValue = Integer.parseInt(entryNo);
		}

		if (certificateByTheCandidateSearch.getEntryDate() != null
				&& !certificateByTheCandidateSearch.getEntryDate()
						.equalsIgnoreCase("")) {
			entryDate = certificateByTheCandidateSearch.getEntryDate();
			entryDate1 = HMSUtil.convertStringTypeDateToDateType(entryDate);
		}
		if (certificateByTheCandidateSearch.getBatchNo() != null
				&& !certificateByTheCandidateSearch.getBatchNo()
						.equalsIgnoreCase("")) {
			batchNo = certificateByTheCandidateSearch.getBatchNo();
		}
		if (certificateByTheCandidateSearch.getChestNo() != null
				&& !certificateByTheCandidateSearch.getChestNo()
						.equalsIgnoreCase("")) {
			chestNo = certificateByTheCandidateSearch.getChestNo();
		}
		if (certificateByTheCandidateSearch.getName() != null
				&& !certificateByTheCandidateSearch.getName().equalsIgnoreCase(
						"")) {
			name = certificateByTheCandidateSearch.getName();
		}

		try {
			Criteria crit = session
					.createCriteria(MbCertificateByCandidateMaster.class);

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
			searchCertificateByTheCandidateSearchList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		certificateByTheCandidateSearchFieldsMap.put(
				"searchCertificateByTheCandidateSearchList",
				searchCertificateByTheCandidateSearchList);
		return certificateByTheCandidateSearchFieldsMap;
	}
}
