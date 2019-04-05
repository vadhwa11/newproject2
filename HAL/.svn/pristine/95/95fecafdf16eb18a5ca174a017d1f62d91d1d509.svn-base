package jkt.hms.medicalboard.dataservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.MbCertificateByCandidateMaster;
import jkt.hms.masters.business.MbCertificateByCandidateUnfitExpl;
import jkt.hms.masters.business.TransactionSequence;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CertificateByTheCandidateDataServiceImpl extends
		HibernateDaoSupport implements CertificateByTheCandidateDataService {

	@SuppressWarnings("unchecked")
	public Map<String, Object> showCertificateByTheCandidateJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MbCertificateByCandidateMaster> certificateByTheCandidateList = new ArrayList<MbCertificateByCandidateMaster>();
		List<MasUnit> masUnitList = new ArrayList<MasUnit>();

		certificateByTheCandidateList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MbCertificateByCandidateMaster");
		masUnitList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasUnit");
		map.put("certificateByTheCandidateList", certificateByTheCandidateList);
		map.put("masUnitList", masUnitList);
		List list = new ArrayList();
		int id = 0;
		list = getHibernateTemplate().find(
				"select max(Id)from MbCertificateByCandidateMaster");
		if (list != null && list.size() > 0 && list.get(0) != null) {
			id = Integer.parseInt(list.get(0).toString());
			map.put("id", id);
		}
		return map;

	}

	@SuppressWarnings("unchecked")
	public boolean addCertificateByTheCandidate(Map generalMap) {
		boolean successfullyAdded = false;
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();

		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		boolean certificateByTheCandidate = false;
		MbCertificateByCandidateMaster mbCertificateByTheCandidateMaster = (MbCertificateByCandidateMaster) generalMap
				.get("masCertificateByTheCandidate");
		List<MbCertificateByCandidateUnfitExpl> mbiList = (List<MbCertificateByCandidateUnfitExpl>) generalMap
				.get("mbUnfitExplanationList");

		try {
			hbt.save(mbCertificateByTheCandidateMaster);
			hbt.refresh(mbCertificateByTheCandidateMaster);
			certificateByTheCandidate = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		SessionFactory sessFactory = getSessionFactory();
		Session sess = sessFactory.openSession();
		String sqlQuery = "select max(id)from MbCertificateByCandidateMaster";
		Query query = sess.createQuery(sqlQuery);
		List list = query.list();
		int id = Integer.parseInt(list.get(0).toString());
		sess.close();

		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		if (certificateByTheCandidate && mbiList != null) {
			MbCertificateByCandidateMaster mbCertificateByTheCandidateMaster1 = new MbCertificateByCandidateMaster();
			mbCertificateByTheCandidateMaster1.setId(id);
			for (MbCertificateByCandidateUnfitExpl mbCertificateByTheCandidateUnfitExpl : mbiList) {
				MbCertificateByCandidateUnfitExpl mbCertificateByTheCandidateUnfitExpl1 = new MbCertificateByCandidateUnfitExpl();
				mbCertificateByTheCandidateUnfitExpl1 = mbCertificateByTheCandidateUnfitExpl;

				mbCertificateByTheCandidateUnfitExpl1
						.setCertificateByCandidateUnfitExpl(mbCertificateByTheCandidateMaster1);
				hbt.save(mbCertificateByTheCandidateUnfitExpl1);
				hbt.refresh(mbCertificateByTheCandidateUnfitExpl1);
			}
			successfullyAdded = true;
		}
		if (successfullyAdded) {

			// org.springframework.orm.hibernate3.HibernateTemplate hbt2 =
			// getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			List<TransactionSequence> certificateByTheCandidateNoList = new ArrayList<TransactionSequence>();
			certificateByTheCandidateNoList = session.createCriteria(
					TransactionSequence.class).add(
					Restrictions.eq("TransactionPrefix", "CBC")).list();

			if (certificateByTheCandidateNoList.size() > 0) {
				for (TransactionSequence transactionSequence : certificateByTheCandidateNoList) {
					TransactionSequence obj = transactionSequence;
					int id1 = obj.getId();
					int seqNo = obj.getTransactionSequenceNumber();

					TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
							.load(TransactionSequence.class, id1);
					transactionSequenceObj
							.setTransactionSequenceNumber(++seqNo);
					hbt.update(transactionSequenceObj);
				}
			}
		}
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public String generateCertificateByCandidateNo(String userName) {

		Session session = (Session) getSession();
		String entryNo = "";
		List<TransactionSequence> certificateByTheCandidateNoList = new ArrayList<TransactionSequence>();
		certificateByTheCandidateNoList = session.createCriteria(
				TransactionSequence.class).add(
				Restrictions.eq("TransactionPrefix", "CBC")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		if (certificateByTheCandidateNoList.size() > 0) {
			for (TransactionSequence transactionSequence : certificateByTheCandidateNoList) {
				TransactionSequence obj = transactionSequence;
				int seqNo = obj.getTransactionSequenceNumber();
				entryNo = entryNo.concat(String.valueOf(seqNo));
			}
		} else if (certificateByTheCandidateNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("MbCertificateByCandidateMaster");
			tsObj.setTransactionPrefix("CBC");
			tsObj.setTransactionSequenceName("Entry No");
			tsObj.setTransactionSequenceNumber(0);
			hbt.save(tsObj);
		}
		return entryNo;
	}

}
