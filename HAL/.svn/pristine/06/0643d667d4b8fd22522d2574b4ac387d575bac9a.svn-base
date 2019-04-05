package jkt.hms.medicalboard.dataservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MbResultOfAppealMedicalboardMaster;
import jkt.hms.masters.business.MbResultOfAppealMedicalboardUnfitExpl;
import jkt.hms.masters.business.TransactionSequence;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class ResultOfAppealMedicalboardDataServiceImpl extends
		HibernateDaoSupport implements ResultOfAppealMedicalboardDataService {

	@SuppressWarnings("unchecked")
	public Map<String, Object> showResultOfAppealMedicalboardJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MbResultOfAppealMedicalboardMaster> resultOfAppealMedicalboardList = new ArrayList<MbResultOfAppealMedicalboardMaster>();
		resultOfAppealMedicalboardList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MbResultOfAppealMedicalboardMaster");
		map.put("resultOfAppealMedicalboardList",
				resultOfAppealMedicalboardList);
		List list = new ArrayList();
		int id = 0;
		list = getHibernateTemplate().find(
				"select max(Id)from MbResultOfAppealMedicalboardMaster");
		if (list != null && list.size() > 0 && list.get(0) != null) {
			id = Integer.parseInt(list.get(0).toString());
			map.put("id", id);
		}
		return map;

	}

	@SuppressWarnings("unchecked")
	public boolean addResultOfAppealMedicalboard(Map generalMap) {
		boolean successfullyAdded = false;
		Session session = (Session) getSession();
		HibernateTemplate hbt1 = getHibernateTemplate();
		hbt1.setFlushModeName("FLUSH_AUTO");
		hbt1.setCheckWriteOperations(false);
		boolean resultOfAppealMedicalboard = false;
		MbResultOfAppealMedicalboardMaster mbResultOfAppealMedicalboardMaster = (MbResultOfAppealMedicalboardMaster) generalMap
				.get("masResultOfAppealMedicalboard");
		List<MbResultOfAppealMedicalboardUnfitExpl> mbiList = (List<MbResultOfAppealMedicalboardUnfitExpl>) generalMap
				.get("mbUnfitExplanationList");

		try {
			hbt1.save(mbResultOfAppealMedicalboardMaster);
			resultOfAppealMedicalboard = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		SessionFactory sessFactory = getSessionFactory();
		Session sess = sessFactory.openSession();
		String sqlQuery = "select max(id)from MbResultOfAppealMedicalboardMaster";
		Query query = sess.createQuery(sqlQuery);
		List list = query.list();
		int id = Integer.parseInt(list.get(0).toString());
		sess.close();

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		if (resultOfAppealMedicalboard && mbiList != null) {
			MbResultOfAppealMedicalboardMaster mbResultOfAppealMedicalboardMaster1 = new MbResultOfAppealMedicalboardMaster();
			mbResultOfAppealMedicalboardMaster1.setId(id);
			for (MbResultOfAppealMedicalboardUnfitExpl mbResultOfAppealMedicalboardUnfitExpl : mbiList) {
				MbResultOfAppealMedicalboardUnfitExpl mbResultOfAppealMedicalboardUnfitExpl1 = new MbResultOfAppealMedicalboardUnfitExpl();
				mbResultOfAppealMedicalboardUnfitExpl1 = mbResultOfAppealMedicalboardUnfitExpl;

				mbResultOfAppealMedicalboardUnfitExpl1
						.setResultOfAppealMedicalboardUnfitExpl(mbResultOfAppealMedicalboardMaster1);
				hbt.save(mbResultOfAppealMedicalboardUnfitExpl1);
			}
			successfullyAdded = true;
		}
		if (successfullyAdded) {

			org.springframework.orm.hibernate3.HibernateTemplate hbt2 = getHibernateTemplate();
			hbt2.setFlushModeName("FLUSH_EAGER");
			hbt2.setCheckWriteOperations(false);
			List<TransactionSequence> resultOfAppealMedicalboardNoList = new ArrayList<TransactionSequence>();
			resultOfAppealMedicalboardNoList = session.createCriteria(
					TransactionSequence.class).add(
					Restrictions.eq("TransactionPrefix", "RAM")).list();

			if (resultOfAppealMedicalboardNoList.size() > 0) {
				for (TransactionSequence transactionSequence : resultOfAppealMedicalboardNoList) {
					TransactionSequence obj = transactionSequence;
					int id1 = obj.getId();
					int seqNo = obj.getTransactionSequenceNumber();

					TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
							.load(TransactionSequence.class, id1);
					transactionSequenceObj
							.setTransactionSequenceNumber(++seqNo);
					hbt2.update(transactionSequenceObj);
				}
			}
		}
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public String generateResultOfAppealMedicalboardNo(String userName) {

		Session session = (Session) getSession();
		String entryNo = "";
		List<TransactionSequence> resultOfAppealMedicalboardNoList = new ArrayList<TransactionSequence>();
		resultOfAppealMedicalboardNoList = session.createCriteria(
				TransactionSequence.class).add(
				Restrictions.eq("TransactionPrefix", "RAM")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		if (resultOfAppealMedicalboardNoList.size() > 0) {
			for (TransactionSequence transactionSequence : resultOfAppealMedicalboardNoList) {
				TransactionSequence obj = transactionSequence;
				int seqNo = obj.getTransactionSequenceNumber();
				entryNo = entryNo.concat(String.valueOf(seqNo));
			}
		} else if (resultOfAppealMedicalboardNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("MbResultOfAppealMboardMaster");
			tsObj.setTransactionPrefix("RAM");
			tsObj.setTransactionSequenceName("Entry No");
			tsObj.setTransactionSequenceNumber(0);
			hbt.save(tsObj);
		}
		return entryNo;
	}

}
