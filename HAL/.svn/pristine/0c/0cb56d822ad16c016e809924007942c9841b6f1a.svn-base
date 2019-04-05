package jkt.hms.medicalboard.dataservice;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.MbCertificateByCandidateMaster;
import jkt.hms.masters.business.MbCertificateByCandidateUnfitExpl;
import jkt.hms.medicalboard.controller.CertificateByTheCandidateUpdateDTO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CertificateByTheCandidatesUpdateDataServiceImpl extends
		HibernateDaoSupport implements
		CertificateByTheCandidatesUpdateDataService {

	@SuppressWarnings("unchecked")
	public Map<String, Object> showCertificateByTheCandidatesUpdateJsp(int Id) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<MbCertificateByCandidateMaster> updateList2 = new ArrayList<MbCertificateByCandidateMaster>();
		List<MbCertificateByCandidateUnfitExpl> mbCertificateByTheCandidateUnfitExpl = new ArrayList<MbCertificateByCandidateUnfitExpl>();
		updateList2 = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MbCertificateByCandidateMaster as mwd where mwd.Id ='"
								+ Id + "'");
		mbCertificateByTheCandidateUnfitExpl = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MbCertificateByCandidateUnfitExpl as mwd where mwd.CertificateByCandidateUnfitExpl ='"
								+ Id + "'");
		map.put("mbCertificateByTheCandidateUnfitExpl",
				mbCertificateByTheCandidateUnfitExpl);
		map.put("mbCertificateByTheCandidateMaster", updateList2);
		List<MasUnit> masUnitList = new ArrayList<MasUnit>();
		masUnitList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasUnit");
		map.put("masUnitList", masUnitList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean editCertificateByTheCandidatesUpdateToDatabase(
			Map<String, Object> generalMap) {
		boolean successfullyUpdated = false;
		int certificateByTheCandidatesUpdateId = 0;
		Session sess = (Session) getSession();
		Transaction tx = null;
		certificateByTheCandidatesUpdateId = Integer.parseInt(generalMap.get(
				"id").toString());
		// getting the updated entity
		MbCertificateByCandidateMaster mbCertificateByTheCandidateMaster = (MbCertificateByCandidateMaster) generalMap
				.get("masCertificateByTheCandidate");

		// getting the entity from the table
		MbCertificateByCandidateMaster mbCertificateByTheCandidatesUpdate = (MbCertificateByCandidateMaster) getHibernateTemplate()
				.load(MbCertificateByCandidateMaster.class,
						certificateByTheCandidatesUpdateId);

		// updating table entity to the updated entity
		if (mbCertificateByTheCandidateMaster.getEntryDate() != null) {
			mbCertificateByTheCandidatesUpdate
					.setEntryDate(mbCertificateByTheCandidateMaster
							.getEntryDate());
		}
		if (mbCertificateByTheCandidateMaster.getBatchNo() != null) {
			mbCertificateByTheCandidatesUpdate
					.setBatchNo(mbCertificateByTheCandidateMaster.getBatchNo());
		}
		if (mbCertificateByTheCandidateMaster.getChestNo() != null) {
			mbCertificateByTheCandidatesUpdate
					.setChestNo(mbCertificateByTheCandidateMaster.getChestNo());
		}
		if (mbCertificateByTheCandidateMaster.getName() != null) {
			mbCertificateByTheCandidatesUpdate
					.setName(mbCertificateByTheCandidateMaster.getName());
		}
		if (mbCertificateByTheCandidateMaster.getPlace() != null) {
			mbCertificateByTheCandidatesUpdate
					.setPlace(mbCertificateByTheCandidateMaster.getPlace());
		}
		if (mbCertificateByTheCandidateMaster.getOptReportAppealExamination() != null) {
			mbCertificateByTheCandidatesUpdate
					.setOptReportAppealExamination(mbCertificateByTheCandidateMaster
							.getOptReportAppealExamination());
		}

		mbCertificateByTheCandidatesUpdate
				.setLastChgBy(mbCertificateByTheCandidateMaster.getLastChgBy());
		mbCertificateByTheCandidatesUpdate
				.setLastChgDate(mbCertificateByTheCandidateMaster
						.getLastChgDate());
		mbCertificateByTheCandidatesUpdate
				.setLastChgTime(mbCertificateByTheCandidateMaster
						.getLastChgTime());

		// updating the record into the database
		org.springframework.orm.hibernate3.HibernateTemplate hbt1 = getHibernateTemplate();
		hbt1.setFlushModeName("FLUSH_EAGER");
		hbt1.setCheckWriteOperations(false);
		try {
			hbt1.update(mbCertificateByTheCandidatesUpdate);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// getting the second updated entity
		List<CertificateByTheCandidateUpdateDTO> mbiList = (List<CertificateByTheCandidateUpdateDTO>) generalMap
				.get("mbUnfitExplanationList");

		// getting entity from the table
		List<MbCertificateByCandidateUnfitExpl> mbiListFromDatabase = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MbCertificateByCandidateUnfitExpl as mwd where mwd.CertificateByCandidateUnfitExpl ='"
								+ certificateByTheCandidatesUpdateId + "'");

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		if (mbiListFromDatabase != null && mbiList != null) {
			tx = sess.beginTransaction();
			int counter;
			for (MbCertificateByCandidateUnfitExpl mbCertificateByTheCandidateUnfitExpl : mbiListFromDatabase) {
				counter = 1;
				for (CertificateByTheCandidateUpdateDTO mbCertificateByTheCandidateUpdateDTO : mbiList) {
					if (!mbCertificateByTheCandidateUpdateDTO.getId()
							.equals("")
							&& mbCertificateByTheCandidateUnfitExpl.getId() == Integer
									.parseInt(mbCertificateByTheCandidateUpdateDTO
											.getId())) {

						try {
							MbCertificateByCandidateUnfitExpl mbCertificateByTheCandidateUnfitExplUpdate = (MbCertificateByCandidateUnfitExpl) getHibernateTemplate()
									.get(
											MbCertificateByCandidateUnfitExpl.class,
											mbCertificateByTheCandidateUnfitExpl
													.getId());
							mbCertificateByTheCandidateUnfitExplUpdate
									.setUnfitExplanation(mbCertificateByTheCandidateUpdateDTO
											.getUnfitExplanation());
							hbt
									.update(mbCertificateByTheCandidateUnfitExplUpdate);

							mbCertificateByTheCandidateUpdateDTO.setId("0");// updating
							// DTO in
							// mbiList
							counter++;
							break;

						} catch (Exception e) {
							e.printStackTrace();
						}
					} else if (mbCertificateByTheCandidateUpdateDTO.getId()
							.equals("0")
							&& mbiList.size() > counter) {
						counter++;
						continue;
					} else if (!mbCertificateByTheCandidateUpdateDTO.getId()
							.equals("")) {
						try {
							MbCertificateByCandidateUnfitExpl mbCertificateByTheCandidateUnfitExplUpdate = (MbCertificateByCandidateUnfitExpl) getHibernateTemplate()
									.get(
											MbCertificateByCandidateUnfitExpl.class,
											mbCertificateByTheCandidateUnfitExpl
													.getId());

							hbt
									.delete(mbCertificateByTheCandidateUnfitExplUpdate);
							break;
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;
					}
				}

			}

			for (CertificateByTheCandidateUpdateDTO mbCertificateByTheCandidateUpdateDTO : mbiList) {
				if (mbCertificateByTheCandidateUpdateDTO.getId() != null
						&& mbCertificateByTheCandidateUpdateDTO.getId().equals(
								"")) {

					hbt.setCheckWriteOperations(false);
					MbCertificateByCandidateMaster mbCertificateByTheCandidateMaster1 = new MbCertificateByCandidateMaster();
					MbCertificateByCandidateUnfitExpl mbCertificateByTheCandidateUnfitExplUpdate = new MbCertificateByCandidateUnfitExpl();
					mbCertificateByTheCandidateUnfitExplUpdate
							.setUnfitExplanation(mbCertificateByTheCandidateUpdateDTO
									.getUnfitExplanation());
					mbCertificateByTheCandidateMaster1
							.setId(certificateByTheCandidatesUpdateId);
					mbCertificateByTheCandidateUnfitExplUpdate
							.setCertificateByCandidateUnfitExpl(mbCertificateByTheCandidateMaster1);
					hbt.save(mbCertificateByTheCandidateUnfitExplUpdate);
				}
			}

			successfullyUpdated = true;
			tx.commit();
		}
		return successfullyUpdated;
	}

	// ---------------------------------------------------------------------------------------------------------

	// Method For Getting the connection

	// ---------------------------------------------------------------------------------------------------------
	@SuppressWarnings("deprecation")
	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> connectionMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		connectionMap.put("con", con);
		return connectionMap;
	}
}
