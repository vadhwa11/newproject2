package jkt.hms.agendapoints.dataservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import jkt.hms.masters.business.MasAgendaPointForWorkServices;
import jkt.hms.masters.business.MomAgendaSummary;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.util.HMSUtil;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class MomDetailAgainstAgendaDataServiceImpl extends HibernateDaoSupport
		implements MomDetailAgainstAgendaDataService {

	int sId = 0;

	@SuppressWarnings("unchecked")
	public Map<String, Object> showMomDetailAgainstAgendaJsp(int Id) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<MasAgendaPointForWorkServices> momAgendaDetailList = new ArrayList<MasAgendaPointForWorkServices>();
		momAgendaDetailList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasAgendaPointForWorkServices  where Id='"
						+ Id + "'");

		map.put("momAgendaDetailList", momAgendaDetailList);

		map.put("Id", Id);
		return map;

	}

	@SuppressWarnings("unchecked")
	public boolean addMomDetailAgainstAgenda(Map<String, Object> generalMap) {
		Session session = (Session) getSession();
		boolean dataSave = false;
		Vector v = new Vector();
		String momActualStartedTime1 = "";
		String momActualEndingTime1 = "";
		String momAttendees1 = "";
		String momAbsentees1 = "";
		String momChairedBy1 = "";
		String momMintsBy1 = "";
		String momDate = "";
		String momNo = "";

		List<TransactionSequence> momNoList = new ArrayList<TransactionSequence>();

		Date momDateFormate = null;
		int id = 0;
		boolean agendaPointsUpdated = false;
		String agendaSummaryDiscussion = "";
		id = Integer.parseInt(generalMap.get("Id").toString());
		momActualStartedTime1 = (String) generalMap.get("momActualStartedTime");
		momActualEndingTime1 = (String) generalMap.get("momActualEndingTime");
		momAttendees1 = (String) generalMap.get("momAttendees");
		momAbsentees1 = (String) generalMap.get("momAbsentees");
		momChairedBy1 = (String) generalMap.get("momChairedBy");
		momMintsBy1 = (String) generalMap.get("momMintsBy");
		agendaSummaryDiscussion = (String) generalMap.get("momAgendaSummary");
		momNo = (String) generalMap.get("momNo");
		momDate = (String) generalMap.get("momDate");
		momDateFormate = HMSUtil.dateFormatterDDMMYYYY(momDate);
		v = (Vector) generalMap.get("v");
		MasAgendaPointForWorkServices masAgendaPointForWorkServices = (MasAgendaPointForWorkServices) getHibernateTemplate()
				.load(MasAgendaPointForWorkServices.class, id);
		org.springframework.orm.hibernate3.HibernateTemplate hbt1 = getHibernateTemplate();
		hbt1.setFlushModeName("FLUSH_EAGER");
		hbt1.setCheckWriteOperations(false);

		MasAgendaPointForWorkServices masAgendaPointForWorkServices1 = new MasAgendaPointForWorkServices();
		masAgendaPointForWorkServices
				.setActualStartedTime(momActualStartedTime1);
		masAgendaPointForWorkServices.setActualEndedTime(momActualEndingTime1);
		masAgendaPointForWorkServices.setAttendees(momAttendees1);
		masAgendaPointForWorkServices.setAbsentees(momAbsentees1);
		masAgendaPointForWorkServices.setChairedBy(momChairedBy1);
		masAgendaPointForWorkServices.setMintsBy(momMintsBy1);
		masAgendaPointForWorkServices.setStatus("y");
		masAgendaPointForWorkServices.setMomDate(momDateFormate);
		masAgendaPointForWorkServices.setMomNo(momNo);
		masAgendaPointForWorkServices.setAgendaSummary(agendaSummaryDiscussion);
		try {
			hbt1.update(masAgendaPointForWorkServices);
			agendaPointsUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// SessionFactory sessFactory = getSessionFactory();
		// Session sess = sessFactory.openSession();
		// String sqlQuery = "select max(id)from MasAgendaPointForWorkServices";
		// Query query = sess.createQuery(sqlQuery);
		// List list = query.list();
		// sess.close();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		if (agendaPointsUpdated) {
			// int id1 = Integer.parseInt(list.get(0).toString());
			for (int i = 0; i < v.size(); i++) {
				MomAgendaSummary momAgendaSummary = new MomAgendaSummary();
				String summary = (String) v.get(i);
				masAgendaPointForWorkServices1.setId(id);
				momAgendaSummary.setAgendaSummaryPoints(summary);
				momAgendaSummary.setSummary(masAgendaPointForWorkServices1);
				hbt.save(momAgendaSummary);
				dataSave = true;
			}
		} else
			dataSave = false;

		momNoList = session.createCriteria(TransactionSequence.class).add(
				Restrictions.eq("TransactionPrefix", "MOM")).list();

		HibernateTemplate hbt2 = getHibernateTemplate();
		hbt2.setFlushModeName("FLUSH_EAGER");
		hbt2.setCheckWriteOperations(false);

		if (dataSave) {
			for (TransactionSequence transactionSequence : momNoList) {
				TransactionSequence obj = transactionSequence;
				int id1 = obj.getId();
				int seqNo = obj.getTransactionSequenceNumber();

				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
						.load(TransactionSequence.class, id1);
				transactionSequenceObj.setTransactionSequenceNumber(++seqNo);
				hbt2.update(transactionSequenceObj);
			}
		}
		return dataSave;
	}

	@SuppressWarnings("unchecked")
	public String generateMomNumber(String userName) {
		List<TransactionSequence> momNoList = new ArrayList<TransactionSequence>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		Session session = (Session) getSession();
		String momNo = "";
		String date = "";
		date = (String) utilMap.get("currentDate");

		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		momNoList = session.createCriteria(TransactionSequence.class).add(
				Restrictions.eq("TransactionPrefix", "MOM")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (momNoList.size() > 0) {
			for (TransactionSequence transactionSequence : momNoList) {
				TransactionSequence obj = transactionSequence;
				int seqNo = obj.getTransactionSequenceNumber();
				momNo = momNo.concat(String.valueOf(seqNo));
				momNo = momNo.concat("/").concat(currentYear);
			}
		} else if (momNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("MasAgendaPointForWorkServices");
			tsObj.setTransactionPrefix("MOM");
			tsObj.setTransactionSequenceName("MOM No");
			tsObj.setTransactionSequenceNumber(0);
			hbt.save(tsObj);
		}
		return momNo;
	}

}
