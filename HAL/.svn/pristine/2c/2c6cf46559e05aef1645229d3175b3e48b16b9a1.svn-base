package jkt.hms.workservices.dataservice;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDepartmentType;
import jkt.hms.masters.business.MasMinorWorkDetail;
import jkt.hms.masters.business.MasMinorWorkProposal;
import jkt.hms.masters.business.MasWorkCategory;
import jkt.hms.masters.business.MasWorkType;
import jkt.hms.masters.business.ProposalDepartment;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.masters.business.WorkNoDepartment;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;
import jkt.hms.workservices.controller.AgendaDTO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class MinorWorkDetailDataServiceImpl extends HibernateDaoSupport
		implements MinorWorkDetailDataService {

	public Map<String, Object> showMinorWorkDetailJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasWorkCategory> workCategoryList = new ArrayList<MasWorkCategory>();
		List<MasWorkType> worktypeList = new ArrayList<MasWorkType>();
		List<MasMinorWorkDetail> minorWorkDetailList = new ArrayList<MasMinorWorkDetail>();

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

		List<MasDepartment> departmentTypeList = new ArrayList<MasDepartment>();
		departmentTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment ");
		map.put("departmentTypeList", departmentTypeList);

		workCategoryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasWorkCategory ");
		worktypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasWorkType ");
		minorWorkDetailList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasMinorWorkDetail");
		map.put("session", session);
		map.put("workCategoryList", workCategoryList);
		map.put("workTypeList", worktypeList);
		map.put("minorWorkDetailList", minorWorkDetailList);
		return map;

	}

	public Map<String, Object> showUserCommentsJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasWorkCategory> workCategoryList = new ArrayList<MasWorkCategory>();
		List<MasWorkType> worktypeList = new ArrayList<MasWorkType>();
		List<MasMinorWorkDetail> minorWorkDetailList = new ArrayList<MasMinorWorkDetail>();

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
		worktypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasWorkType ");
		map.put("session", session);
		map.put("workTypeList", worktypeList);
		return map;

	}

	public boolean addMinorWorkDetail(Map<String, Object> generalMap,
			int proposalNoId) {
		boolean successfullyAdded = false;
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		MasMinorWorkDetail minorworkdetail = (MasMinorWorkDetail) generalMap
				.get("masMinorWorkdetail");
		String date = "";
		jkt.hms.util.Box box = (jkt.hms.util.Box) generalMap.get("box");
		date = (String) utilMap.get("currentDate");
		Vector deptId = box
				.getVector(RequestConstants.MINOR_WORK_PROPOSAL_DEPARTMENT);
		List<MasDepartment> departmentTypeList = new ArrayList<MasDepartment>();
		departmentTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment");
		StringBuffer departmentName = new StringBuffer();

		for (MasDepartment masDepartmentType : departmentTypeList) {
			for (int i = 0; i < deptId.size(); i++) {
				if (masDepartmentType.getId() == Integer.parseInt(deptId.get(i)
						.toString()))
					departmentName
							.append(masDepartmentType.getDepartmentName());
			}
		}

		String[] currentDate = date.split("/");
		String currentMonth = currentDate[1];
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		try {
			minorworkdetail.setDepartmentName(departmentName.toString());
			hbt.save(minorworkdetail);
			successfullyAdded = true;
			for (int i = 0; i < deptId.size(); i++) {
				WorkNoDepartment complaintDepartment = new WorkNoDepartment();
				complaintDepartment.setWorkNoType(minorworkdetail);
				if (deptId.get(i) != null && !deptId.get(i).equals("")) {
					MasDepartmentType masdept = new MasDepartmentType();
					masdept.setId(Integer.parseInt((String) deptId.get(i)));
					complaintDepartment.setDepartment(masdept);
				}
				hbt.save(complaintDepartment);
				hbt.refresh(complaintDepartment);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		MasMinorWorkProposal masMinorWorkProposalUpdate = (MasMinorWorkProposal) hbt
				.load(MasMinorWorkProposal.class, proposalNoId);

		masMinorWorkProposalUpdate.setLastChgBy(minorworkdetail.getLastChgBy());
		masMinorWorkProposalUpdate.setLastChgDate(minorworkdetail
				.getLastChgDate());
		masMinorWorkProposalUpdate.setLastChgTime(minorworkdetail
				.getLastChgTime());
		masMinorWorkProposalUpdate.setStatus("a");
		// org.springframework.orm.hibernate3.HibernateTemplate hbt1 =
		// getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(true);
		hbt.update(masMinorWorkProposalUpdate);
		hbt.refresh(masMinorWorkProposalUpdate);

		if (successfullyAdded) {

			// org.springframework.orm.hibernate3.HibernateTemplate hbt2 =
			// getHibernateTemplate();
			// hbt.setFlushModeName("FLUSH_EAGER");
			// hbt.setCheckWriteOperations(false);
			List<TransactionSequence> minorWorkNoList = new ArrayList<TransactionSequence>();
			minorWorkNoList = session.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "MWN")).list();

			if (minorWorkNoList.size() > 0) {
				for (TransactionSequence transactionSequence : minorWorkNoList) {
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

					hbt.update(transactionSequenceObj);
				}
			}
		}

		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public String generateMinorWorkNumber(String userName) {
		List<TransactionSequence> minorWorkNoList = new ArrayList<TransactionSequence>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		Session session = (Session) getSession();
		String minorWorkNo = "";
		String date = "";
		date = (String) utilMap.get("currentDate");

		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		String[] currentDate = date.split("/");
		String currentMonth = currentDate[1];
		minorWorkNoList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "MWN")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (minorWorkNoList.size() > 0) {
			for (TransactionSequence transactionSequence : minorWorkNoList) {
				TransactionSequence obj = transactionSequence;
				int id = obj.getId();
				int seqNo = obj.getTransactionSequenceNumber();

				minorWorkNo = minorWorkNo.concat(String.valueOf(seqNo));
				minorWorkNo = minorWorkNo.concat("/").concat(currentMonth);
				minorWorkNo = minorWorkNo.concat("/").concat(currentYear);
			}
		} else if (minorWorkNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("MasMinorWorkDetail");
			tsObj.setTransactionPrefix("MWN");
			tsObj.setTransactionSequenceName("Minor Work No");
			tsObj.setTransactionSequenceNumber(0);
			hbt.save(tsObj);
		}
		return minorWorkNo;
	}

	public boolean editUserComments(Map<String, Object> generalMap) {
		boolean updateSuccessfully = false;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		String userComment = "";
		int minorWorkId = 0;
		if (generalMap.get("changedBy") != null) {
			changedBy = (String) generalMap.get("changedBy");
		}
		if (generalMap.get("changedDate") != null) {
			changedDate = (Date) generalMap.get("changedDate");
		}
		if (generalMap.get("changedTime") != null) {
			changedTime = (String) generalMap.get("changedTime");
		}
		if (generalMap.get("userComment") != null) {
			userComment = (String) generalMap.get("userComment");
		}
		if (generalMap.get("minorWorkId") != null) {
			minorWorkId = Integer.parseInt((String) generalMap
					.get("minorWorkId"));
		}
		try {
			MasMinorWorkDetail masApprovalOfMinorWorkDetail = (MasMinorWorkDetail) getHibernateTemplate()
					.load(MasMinorWorkDetail.class, minorWorkId);

			masApprovalOfMinorWorkDetail.setUserComments(userComment);

			masApprovalOfMinorWorkDetail.setLastChgBy(changedBy);
			masApprovalOfMinorWorkDetail.setLastChgDate(changedDate);
			masApprovalOfMinorWorkDetail.setLastChgTime(changedTime);

			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(true);
			hbt.update(masApprovalOfMinorWorkDetail);
			updateSuccessfully = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return updateSuccessfully;
	}

	public Map<String, Object> showPopUpProposalJsp(Map<String, Object> map)

	{
        Map<String, Object> dataMap = new HashMap<String, Object>();
		List<MasMinorWorkDetail> minorWorkProposalList = null;
		String status = "a";

		minorWorkProposalList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasMinorWorkDetail as imc where imc.Status='"
						+ status + "'");

		dataMap.put("minorWorkProposalList", minorWorkProposalList);
		return dataMap;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchMinorWorkDetailDepartmentForUpdate(
			AgendaDTO minorWorkDetailSearch) {
		List<MasMinorWorkProposal> searchMinorWorkDetailSearchList = new ArrayList<MasMinorWorkProposal>();
		Map<String, Object> minorWorkDetailSearchFieldsMap = new HashMap<String, Object>();
		String minorWorkNo = "";
		List<MasDepartment> departmentTypeList = new ArrayList<MasDepartment>();
		List<ProposalDepartment> searchDetailDeptList = new ArrayList<ProposalDepartment>();

		departmentTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment ");

		Session session = (Session) getSession();

		if (minorWorkDetailSearch.getMinorWorkNo() != null
				&& !minorWorkDetailSearch.getMinorWorkNo().equalsIgnoreCase("")) {
			minorWorkNo = minorWorkDetailSearch.getMinorWorkNo();
		}

		searchMinorWorkDetailSearchList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasMinorWorkDetail as imc where imc.MinorWorkDetailNo='"
								+ minorWorkNo + "'");
		if (searchMinorWorkDetailSearchList != null
				&& searchMinorWorkDetailSearchList.size() > 0) {
			searchDetailDeptList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.DetailDepartment as imc where imc.DetailType='"
							+ searchMinorWorkDetailSearchList.get(0).getId()
							+ "'");
		}
		minorWorkDetailSearchFieldsMap.put("departmentTypeList",
				departmentTypeList);
		minorWorkDetailSearchFieldsMap.put("searchProposalDeptList",
				searchDetailDeptList);

		minorWorkDetailSearchFieldsMap.put("searchMinorWorkDetailSearchList",
				searchMinorWorkDetailSearchList);
		return minorWorkDetailSearchFieldsMap;
	}

	public Map<String, Object> showViewUserCommentsJsp(
			Map<String, Object> generalMap) {
		boolean updateSuccessfully = false;
		List<MasMinorWorkDetail> minorWorkDetailList = new ArrayList<MasMinorWorkDetail>();
		Map<String, Object> dataMap = new HashMap<String, Object>();

		int minorWorkId = 0;
		if (generalMap.get("minorWorkId") != null) {
			minorWorkId = Integer.parseInt((String) generalMap
					.get("minorWorkId"));
		}

		minorWorkDetailList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasMinorWorkDetail as imc where imc.Id='"
						+ minorWorkId + "'");

		dataMap.put("minorWorkDetailList", minorWorkDetailList);
		return dataMap;
	}

}
