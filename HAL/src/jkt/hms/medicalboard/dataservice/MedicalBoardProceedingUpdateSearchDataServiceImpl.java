package jkt.hms.medicalboard.dataservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasMedicalBoardProceedings;
import jkt.hms.masters.business.MasRank;
import jkt.hms.medicalboard.controller.MedicalBoardProceedingsUpdateSearchDTO;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class MedicalBoardProceedingUpdateSearchDataServiceImpl extends
		HibernateDaoSupport implements
		MedicalBoardProceedingUpdateSearchDataService {
	Map<String, Object> map = new HashMap<String, Object>();

	@SuppressWarnings("unchecked")
	public Map<String, Object> showMedicalBoardSearchJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasMedicalBoardProceedings> medicalBoardList = new ArrayList<MasMedicalBoardProceedings>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		medicalBoardList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasMedicalBoardProceedings");
		rankList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasRank ");
		map.put("rankList", rankList);
		map.put("medicalBoardList", medicalBoardList);

		return map;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchMedicalBoardProceedingSearch(
			MedicalBoardProceedingsUpdateSearchDTO medicalBoardProceedingsSearchDTO) {
		List<MasMedicalBoardProceedings> medicalBoardList = new ArrayList<MasMedicalBoardProceedings>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		Map<String, Object> medicalBoardSearchFieldsMap = new HashMap<String, Object>();

		String serviceNo = "";
		String adNo = "";
		String firstName = "";
		String lastName = "";
		String rank1 = "";
		Session session = (Session) getSession();
		serviceNo = medicalBoardProceedingsSearchDTO.getServiceNo();

		if (medicalBoardProceedingsSearchDTO.getServiceNo() != null) {

			serviceNo = medicalBoardProceedingsSearchDTO.getServiceNo();

		}

		if (medicalBoardProceedingsSearchDTO.getRank() != null) {
			rank1 = medicalBoardProceedingsSearchDTO.getRank();

		}

		if (medicalBoardProceedingsSearchDTO.getAdNo() != null) {
			adNo = medicalBoardProceedingsSearchDTO.getAdNo();

		}
		if (medicalBoardProceedingsSearchDTO.getFirstName() != null) {
			firstName = medicalBoardProceedingsSearchDTO.getFirstName();

		}
		if (medicalBoardProceedingsSearchDTO.getLastName() != null) {
			lastName = medicalBoardProceedingsSearchDTO.getLastName();

		}

		try {
			Criteria crit = session
					.createCriteria(MasMedicalBoardProceedings.class);

			if (firstName != null) {
				crit = crit.add(Restrictions.like("FirstName", "%" + firstName
						+ "%"));

			}
			if (lastName != null) {
				crit = crit.add(Restrictions.like("LastName", "%" + lastName
						+ "%"));

			}

			if (serviceNo != null) {

				crit = crit
						.add(Restrictions.like("ServiceNo", serviceNo + "%"));
			}
			if (adNo != null) {
				crit = crit.add(Restrictions.like("AdNo", adNo + "%"));

			}
			if (rank1 != null) {
				crit = crit.add(Restrictions
						.like("RankName", "%" + rank1 + "%"));

			}
			medicalBoardList = crit.list();
			Criteria crit1 = session.createCriteria(MasRank.class).add(
					Restrictions.eq("Status", "y"));
			rankList = crit1.list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		medicalBoardSearchFieldsMap.put("medicalBoardList", medicalBoardList);
		medicalBoardSearchFieldsMap.put("rankList", rankList);
		return medicalBoardSearchFieldsMap;
	}
}
