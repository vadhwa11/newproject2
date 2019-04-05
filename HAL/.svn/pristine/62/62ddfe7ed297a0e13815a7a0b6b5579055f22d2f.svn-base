package jkt.hms.medicalboard.dataservice;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasMedicalExaminationReportOnEntry;
import jkt.hms.masters.business.MbInstructionToCandidateMaster;
import jkt.hms.masters.business.MbInstructionToCandidateUnfitExpl;
import jkt.hms.masters.business.TransactionSequence;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class InstructionToCandidateDataServiceImpl extends HibernateDaoSupport
		implements InstructionToCandidateDataService {

	@SuppressWarnings("unchecked")
	public Map<String, Object> showInstructionToCandidateJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MbInstructionToCandidateMaster> instructionToCandidateList = new ArrayList<MbInstructionToCandidateMaster>();

		Calendar c = Calendar.getInstance();
		Integer i;
		Integer year;
		Integer sessionyear = 0;
		String session = "";
		year = c.get(Calendar.YEAR);
		i = c.get(Calendar.MONTH) + 1;
		if (i >= 4) {
			sessionyear = year + 1;
			session = "" + year + "-" + sessionyear;

		} else {
			sessionyear = year - 1;
			session = "" + sessionyear + "-" + year;
		}
		instructionToCandidateList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MbInstructionToCandidateMaster");
		map.put("session", session);
		map.put("instructionToCandidateList", instructionToCandidateList);
		List list = new ArrayList();
		int id = 0;
		list = getHibernateTemplate().find(
				"select max(Id)from MbInstructionToCandidateMaster");
		if (list != null && list.size() > 0 && list.get(0) != null) {
			id = Integer.parseInt(list.get(0).toString());
			map.put("id", id);
		}
		return map;

	}

	@SuppressWarnings("unchecked")
	public boolean addInstructionToCandidate(Map generalMap) {
		boolean successfullyAdded = false;
		Session session = (Session) getSession();
		HibernateTemplate hbt1 = getHibernateTemplate();
		hbt1.setFlushModeName("FLUSH_AUTO");
		hbt1.setCheckWriteOperations(false);
		boolean instructionToCandidate = false;
		MbInstructionToCandidateMaster mbInstructionToCandidateMaster = (MbInstructionToCandidateMaster) generalMap
				.get("masInstructionToCandidate");
		List<MbInstructionToCandidateUnfitExpl> mbiList = (List<MbInstructionToCandidateUnfitExpl>) generalMap
				.get("mbUnfitExplanationList");

		try {
			hbt1.save(mbInstructionToCandidateMaster);
			hbt1.refresh(mbInstructionToCandidateMaster);
			instructionToCandidate = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		SessionFactory sessFactory = getSessionFactory();
		Session sess = sessFactory.openSession();
		String sqlQuery = "select max(id)from MbInstructionToCandidateMaster";
		Query query = sess.createQuery(sqlQuery);
		List list = query.list();
		int id = Integer.parseInt(list.get(0).toString());
		sess.close();

		// org.springframework.orm.hibernate3.HibernateTemplate hbt =
		// getHibernateTemplate();
		hbt1.setFlushModeName("FLUSH_AUTO");
		hbt1.setCheckWriteOperations(false);
		if (instructionToCandidate && mbiList != null) {
			MbInstructionToCandidateMaster mbInstructionToCandidateMaster1 = new MbInstructionToCandidateMaster();
			mbInstructionToCandidateMaster1.setId(id);
			for (MbInstructionToCandidateUnfitExpl mbInstructionToCandidateUnfitExpl : mbiList) {
				MbInstructionToCandidateUnfitExpl mbInstructionToCandidateUnfitExpl1 = new MbInstructionToCandidateUnfitExpl();
				mbInstructionToCandidateUnfitExpl1 = mbInstructionToCandidateUnfitExpl;

				mbInstructionToCandidateUnfitExpl1
						.setIntructionToCandidateUnfitExplanation(mbInstructionToCandidateMaster1);
				hbt1.save(mbInstructionToCandidateUnfitExpl1);
				hbt1.refresh(mbInstructionToCandidateUnfitExpl1);
			}
			successfullyAdded = true;
		}
		if (successfullyAdded) {

			// org.springframework.orm.hibernate3.HibernateTemplate hbt2 =
			// getHibernateTemplate();
			hbt1.setFlushModeName("FLUSH_EAGER");
			hbt1.setCheckWriteOperations(false);
			List<TransactionSequence> instructionToCandidateNoList = new ArrayList<TransactionSequence>();
			instructionToCandidateNoList = session.createCriteria(
					TransactionSequence.class).add(
					Restrictions.eq("TransactionPrefix", "ITC")).list();

			if (instructionToCandidateNoList.size() > 0) {
				for (TransactionSequence transactionSequence : instructionToCandidateNoList) {
					TransactionSequence obj = transactionSequence;
					int id1 = obj.getId();
					int seqNo = obj.getTransactionSequenceNumber();
					TransactionSequence transactionSequenceObj = (TransactionSequence) hbt1
							.load(TransactionSequence.class, id1);
					transactionSequenceObj
							.setTransactionSequenceNumber(++seqNo);
					hbt1.update(transactionSequenceObj);
				}
			}
		}
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public String generateMinorWorkNumber(String userName) {

		Session session = (Session) getSession();
		String entryNo = "";
		List<TransactionSequence> instructionToCandidateNoList = new ArrayList<TransactionSequence>();
		instructionToCandidateNoList = session.createCriteria(
				TransactionSequence.class).add(
				Restrictions.eq("TransactionPrefix", "ITC")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (instructionToCandidateNoList.size() > 0) {
			for (TransactionSequence transactionSequence : instructionToCandidateNoList) {
				TransactionSequence obj = transactionSequence;
				int seqNo = obj.getTransactionSequenceNumber();
				entryNo = entryNo.concat(String.valueOf(seqNo));
			}
		} else if (instructionToCandidateNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("MbInstructionToCandidateMaster");
			tsObj.setTransactionPrefix("ITC");
			tsObj.setTransactionSequenceName("Entry No");
			tsObj.setTransactionSequenceNumber(0);
			hbt.save(tsObj);
		}
		return entryNo;
	}

	public Map<String, List<MasMedicalExaminationReportOnEntry>> checkUnfitEntry(
			Map inMap) {
		Session session = (Session) getSession();
		String batchNo = (String) inMap.get("batchNo");
		String chestNo = (String) inMap.get("chestNo");
		Map<String, List<MasMedicalExaminationReportOnEntry>> map1 = new HashMap<String, List<MasMedicalExaminationReportOnEntry>>();
		List<MasMedicalExaminationReportOnEntry> masMedicalExamList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		Criteria crit = session
				.createCriteria(MasMedicalExaminationReportOnEntry.class);
		crit.add(Restrictions.eq("MedicalStatus", "u"));
		crit.add(Restrictions.eq("BatchNo", batchNo));
		crit.add(Restrictions.eq("MedicalStatus", chestNo));
		masMedicalExamList = crit.list();
		map1.put("unfitList", masMedicalExamList);
		return map1;
	}

}
