package jkt.hms.workservices.dataservice;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasMinorWorkDetail;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.util.HMSUtil;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CompletionOfMinorWorkDetailsDataServiceImpl extends
		HibernateDaoSupport implements CompletionOfMinorWorkDetailsDataService {

	@SuppressWarnings("unchecked")
	public Map<String, Object> showCompletionOfMinorWorkDetailsJsp(int Id) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeDesignationList = new ArrayList<MasEmployee>();
		List<MasMinorWorkDetail> updateList = new ArrayList<MasMinorWorkDetail>();
		employeeDesignationList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasEmployee ");

		updateList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasMinorWorkDetail as mwd where mwd.Id ='"
						+ Id + "'");
		map.put("masEmployee", employeeDesignationList);
		map.put("minorWorkDetailUpdateList", updateList);
		return map;
	}

	public boolean editCompletionOfMinorWorkDetailsToDatabase(
			Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		int completionOfMinorWorkDetailsId = 0;

		String adminName = "";
		String completionDate = "";
		String completionTime = "";
		String remark = "";
		Session session = (Session) getSession();
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";

		completionOfMinorWorkDetailsId = (Integer) generalMap.get("id");
		adminName = (String) generalMap.get("adminName");
		completionDate = (String) generalMap.get("completionDate");
		completionTime = (String) generalMap.get("completionTime");
		remark = (String) generalMap.get("remark");
		changedBy = (String) generalMap.get("changedBy");
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		DateFormat myDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date myDate = null;
		try {
			myDate = myDateFormat.parse(completionDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		MasMinorWorkDetail masCompletionOfMinorWorkDetails = (MasMinorWorkDetail) getHibernateTemplate()
				.load(MasMinorWorkDetail.class, completionOfMinorWorkDetailsId);
		masCompletionOfMinorWorkDetails.setId((completionOfMinorWorkDetailsId));

		masCompletionOfMinorWorkDetails.setAdminApprovalNo(adminName);
		masCompletionOfMinorWorkDetails.setAdminApprovalDate(myDate);
		masCompletionOfMinorWorkDetails.setAdminApprovalTime(completionTime);
		masCompletionOfMinorWorkDetails.setMinorWorkDetailRemarks(remark);
		masCompletionOfMinorWorkDetails.setStatus("w");
		masCompletionOfMinorWorkDetails.setLastChgBy(changedBy);
		masCompletionOfMinorWorkDetails.setLastChgDate(currentDate);
		masCompletionOfMinorWorkDetails.setLastChgTime(currentTime);
		try {

			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(true);
			hbt.update(masCompletionOfMinorWorkDetails);
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (dataUpdated) {

			org.springframework.orm.hibernate3.HibernateTemplate hbt2 = getHibernateTemplate();
			hbt2.setFlushModeName("FLUSH_EAGER");
			hbt2.setCheckWriteOperations(false);
			List<TransactionSequence> minorWorkNoList = new ArrayList<TransactionSequence>();
			minorWorkNoList = session.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "MCN")).list();

			if (minorWorkNoList.size() > 0) {
				for (TransactionSequence transactionSequence : minorWorkNoList) {
					TransactionSequence obj = transactionSequence;
					int id1 = obj.getId();
					int seqNo = obj.getTransactionSequenceNumber();
					TransactionSequence transactionSequenceObj = (TransactionSequence) hbt2
							.load(TransactionSequence.class, id1);
					transactionSequenceObj
							.setTransactionSequenceNumber(++seqNo);

					hbt2.update(transactionSequenceObj);
				}
			}
		}

		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public String generateCompletionNumber(String userName) {
		List<TransactionSequence> completionNoList = new ArrayList<TransactionSequence>();
		Session session = (Session) getSession();
		String completionNo = "";

		completionNoList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "MCN")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (completionNoList.size() > 0) {
			for (TransactionSequence transactionSequence : completionNoList) {
				TransactionSequence obj = transactionSequence;
				int seqNo = obj.getTransactionSequenceNumber();

				completionNo = "CHAFB";
				completionNo = completionNo.concat("/");
				completionNo = completionNo.concat(String.valueOf(seqNo));

			}
		} else if (completionNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("MasMinorWorkDetail");
			tsObj.setTransactionPrefix("MCN");
			tsObj.setTransactionSequenceName("MW Completion No");
			tsObj.setTransactionSequenceNumber(0);
			hbt.save(tsObj);
		}
		return completionNo;
	}
}
