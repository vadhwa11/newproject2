package jkt.hms.workservices.dataservice;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import jkt.hms.masters.business.MajorWorkStatus;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasMajorWorkDetail;
import jkt.hms.masters.business.MasWorkCategory;
import jkt.hms.masters.business.MasWorkType;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class MajorWorkDetailDataServiceImpl extends HibernateDaoSupport
		implements MajorWorkDetailDataService {

	public Map<String, Object> showMajorWorkDetailJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasWorkCategory> workCategoryList = new ArrayList<MasWorkCategory>();
		List<MasWorkType> worktypeList = new ArrayList<MasWorkType>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasMajorWorkDetail> majorWorkDetailList = new ArrayList<MasMajorWorkDetail>();
		List<MasDepartment> departmentTypeList = new ArrayList<MasDepartment>();
		departmentTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment ");
		map.put("departmentTypeList", departmentTypeList);

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

		workCategoryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasWorkCategory ");
		worktypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasWorkType ");
		employeeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasEmployee ");
		majorWorkDetailList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasMajorWorkDetail");
		map.put("session", session);
		map.put("workCategoryList", workCategoryList);
		map.put("workTypeList", worktypeList);
		map.put("employeeList", employeeList);
		map.put("majorWorkDetailList", majorWorkDetailList);
		return map;
	}

	public Map<String, Object> showMajorWorkDetailStatusMessageJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MajorWorkStatus> searchStatusMesssageList = new ArrayList<MajorWorkStatus>();

		searchStatusMesssageList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MajorWorkStatus ");
		map.put("searchStatusMesssageList", searchStatusMesssageList);

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

		map.put("session", session);
		return map;
	}

	public boolean addMajorWorkDetail(Map<String, Object> generalMap) {
		boolean successfullyAdded = false;
		String date = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		date = (String) utilMap.get("currentDate");
		String[] currentDate = date.split("/");
		String currentMonth = currentDate[1];
		Session session = (Session) getSession();
		jkt.hms.util.Box box = (jkt.hms.util.Box) generalMap.get("box");
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		MasMajorWorkDetail majorworkdetail = (MasMajorWorkDetail) generalMap
				.get("masMajorWorkdetail");
		Vector deptId = box
				.getVector(RequestConstants.MINOR_WORK_PROPOSAL_DEPARTMENT);
		List<MasDepartment> departmentTypeList = new ArrayList<MasDepartment>();
		departmentTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment ");
		StringBuffer departmentName = new StringBuffer();

		for (MasDepartment masDepartment : departmentTypeList) {
			for (int i = 0; i < deptId.size(); i++) {
				if (masDepartment.getId() == Integer.parseInt(deptId.get(i)
						.toString()))
					departmentName.append(masDepartment.getDepartmentName());
			}
		}
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		try {
			majorworkdetail.setDepartmentName(departmentName.toString());
			hbt.save(majorworkdetail);
			successfullyAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (successfullyAdded) {

			org.springframework.orm.hibernate3.HibernateTemplate hbt2 = getHibernateTemplate();
			hbt2.setFlushModeName("FLUSH_EAGER");
			hbt2.setCheckWriteOperations(false);
			List<TransactionSequence> majorWorkNoList = new ArrayList<TransactionSequence>();
			majorWorkNoList = session.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "MJN")).list();

			if (majorWorkNoList.size() > 0) {
				for (TransactionSequence transactionSequence : majorWorkNoList) {
					TransactionSequence obj = transactionSequence;
					int id1 = obj.getId();
					int seqNo = obj.getTransactionSequenceNumber();
					TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
							.load(TransactionSequence.class, id1);
					transactionSequenceObj
							.setTransactionSequenceNumber(++seqNo);
					if (currentMonth.equalsIgnoreCase("01")) {
						transactionSequenceObj.setTransactionSequenceNumber(1);
						seqNo = 1;
					}

					hbt2.update(transactionSequenceObj);
				}
			}
		}
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public String generateMajorWorkNumber(String userName) {
		List<TransactionSequence> majorWorkNoList = new ArrayList<TransactionSequence>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		Session session = (Session) getSession();
		String majorWorkNo = "";
		String date = "";
		date = (String) utilMap.get("currentDate");

		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		String[] currentDate = date.split("/");
		String currentMonth = currentDate[1];
		majorWorkNoList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "MJN")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (majorWorkNoList.size() > 0) {
			for (TransactionSequence transactionSequence : majorWorkNoList) {
				TransactionSequence obj = transactionSequence;
				int seqNo = obj.getTransactionSequenceNumber();
				majorWorkNo = majorWorkNo.concat(String.valueOf(seqNo));
				// majorWorkNo = majorWorkNo.concat("/").concat(currentMonth);
				majorWorkNo = majorWorkNo.concat("/").concat(currentYear);
			}
		} else if (majorWorkNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("MasMajorWorkDetail");
			tsObj.setTransactionPrefix("MJN");
			tsObj.setTransactionSequenceName("Major Work No");
			tsObj.setTransactionSequenceNumber(0);
			hbt.save(tsObj);
		}
		return majorWorkNo;
	}

	public boolean editStatusMessageToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String statusMessage = "";
		@SuppressWarnings("unused")
		String workCategoryCode = "";
		String desc1 = "";
		String maxLimit = "";
		int statusMessageId = 0;
		String changedBy = "";
		statusMessageId = (Integer) generalMap.get("id");
		statusMessage = (String) generalMap.get("name");
		desc1 = (String) generalMap.get("minLimit");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MajorWorkStatus majorWorkStatus = (MajorWorkStatus) getHibernateTemplate()
				.load(MajorWorkStatus.class, statusMessageId);

		majorWorkStatus.setId(statusMessageId);
		majorWorkStatus.setMajorWorkStatusMessage(statusMessage);
		majorWorkStatus.setMajorWorkStatusDescription(desc1);
		majorWorkStatus.setLastChgBy(changedBy);
		majorWorkStatus.setLastChgDate(currentDate);
		majorWorkStatus.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		// hbt.setFlushMode(FlushMode.ALWAYS);
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(majorWorkStatus);
		dataUpdated = true;
		return dataUpdated;
	}

}
