package jkt.hms.medicalboard.dataservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.Patient;
import jkt.hms.medicalboard.controller.MedicalBoardProceedingSearchDTO;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class MedicalBoardProceedingSearchDataServiceImpl extends
		HibernateDaoSupport implements MedicalBoardProceedingSearchDataService {

	public Map<String, Object> showMedicalBoard() {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();

		rankList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasRank ");
		map.put("rankList", rankList);

		return map;
	}

	public Map<String, Object> searchMedicalBoardProceeding(
			MedicalBoardProceedingSearchDTO medicalBoardDTO) {

		Map<String, Object> map = new HashMap<String, Object>();

		List<Object> patientList = new ArrayList<Object>();
		Session session = (Session) getSession();
		String serviceNo = "";
		int rankId = 0;
		String patientFName = "";
		String patientLName = "";
		String adNo = "";

		if (medicalBoardDTO.getServiceNo() != null) {
			serviceNo = (String) medicalBoardDTO.getServiceNo();
		}

		if (medicalBoardDTO.getRank() != null) {
			rankId = Integer.parseInt(medicalBoardDTO.getRank());
		}

		if (medicalBoardDTO.getFirstName() != null) {
			patientFName = medicalBoardDTO.getFirstName();
		}

		if (medicalBoardDTO.getLastName() != null) {
			patientLName = medicalBoardDTO.getLastName();
		}

		if (medicalBoardDTO.getAdNo() != null) {
			adNo = medicalBoardDTO.getAdNo();
		}

		Criteria crit = session.createCriteria(Patient.class).add(
				Restrictions.eq("Status", "y"));

		crit = crit.createAlias("ServiceStatus", "mss").add(
				Restrictions.eq("mss.Id", 1));
		crit = crit.createAlias("Relation", "mrn").add(
				Restrictions.eq("mrn.Id", 8));
		if (!serviceNo.equals("")) {
			crit = crit.add(Restrictions.like("ServiceNo", serviceNo + "%"));
		}
		if (!patientFName.equals("")) {
			crit = crit
					.add(Restrictions.like("PFirstName", patientFName + "%"));
		}
		if (!patientLName.equals("")) {
			crit = crit.add(Restrictions.like("PLastName", patientLName + "%"));
		}
		if (rankId != 0) {
			crit = crit.createAlias("Rank", "mr").add(
					Restrictions.eq("mr.Id", rankId));
		}

		patientList = crit.list();
		List<MasRank> rankList = new ArrayList<MasRank>();

		rankList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasRank ");
		map.put("rankList", rankList);

		map.put("patientList", patientList);
		return map;
	}

	public Map<String, Object> showMedicalBoardForEmployee() {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();

		rankList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasRank ");
		map.put("rankList", rankList);

		return map;
	}

	public Map<String, Object> searchMedicalBoardProceedingForEmployee(
			MedicalBoardProceedingSearchDTO medicalBoardDTO) {

		Map<String, Object> map = new HashMap<String, Object>();

		List<Object> empList = new ArrayList<Object>();
		Session session = (Session) getSession();
		String serviceNo = "";
		int rankId = 0;
		String patientFName = "";
		String patientLName = "";
		String adNo = "";

		if (medicalBoardDTO.getServiceNo() != null) {
			serviceNo = (String) medicalBoardDTO.getServiceNo();
		}

		if (medicalBoardDTO.getRank() != null) {
			rankId = Integer.parseInt(medicalBoardDTO.getRank());
		}

		if (medicalBoardDTO.getFirstName() != null) {
			patientFName = medicalBoardDTO.getFirstName();
		}

		if (medicalBoardDTO.getLastName() != null) {
			patientLName = medicalBoardDTO.getLastName();
		}

		if (medicalBoardDTO.getAdNo() != null) {
			adNo = medicalBoardDTO.getAdNo();
		}

		Criteria crit = session.createCriteria(MasEmployee.class).add(
				Restrictions.ne("Status", "n"));

		// crit = crit.createAlias("ServiceStatus",
		// "mss").add(Restrictions.eq("mss.Id", 1));
		// crit = crit.createAlias("Relation",
		// "mrn").add(Restrictions.eq("mrn.Id", 8));
		if (!serviceNo.equals("")) {
			crit = crit.add(Restrictions.like("ServiceNo", serviceNo + "%"));
		}
		if (!patientFName.equals("")) {
			crit = crit.add(Restrictions.like("FirstName", patientFName + "%"));
		}
		if (!patientLName.equals("")) {
			crit = crit.add(Restrictions.like("LastName", patientLName + "%"));
		}
		if (rankId != 0) {
			crit = crit.createAlias("Rank", "mr").add(
					Restrictions.eq("mr.Id", rankId));
		}

		empList = crit.list();
		List<MasRank> rankList = new ArrayList<MasRank>();

		rankList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasRank ");
		map.put("rankList", rankList);

		map.put("patientList", empList);
		return map;
	}

}
