package jkt.hms.workservices.dataservice;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;

import jkt.hms.masters.business.MasDepartment;
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
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class MinorWorkProposalDataServiceImpl extends HibernateDaoSupport
		implements MinorWorkProposalDataService {

	public Map<String, Object> showMinorWorkProposalJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasWorkType> worktypeList = new ArrayList<MasWorkType>();
		List<MasMinorWorkProposal> minorWorkProposalList = new ArrayList<MasMinorWorkProposal>();
		List minorWorkProposalListMax = new ArrayList();
		List<MasDepartment> departmentTypeList = new ArrayList<MasDepartment>();
		
		worktypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasWorkType as isc where isc.Status = 'y'");
		minorWorkProposalList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasMinorWorkProposal as isc where isc.Status = 'y'");
		
		departmentTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment as isc where isc.Status = 'y'");
		
		minorWorkProposalListMax = getHibernateTemplate()
				.find(
						"select max(Id) from jkt.hms.masters.business.MasMinorWorkProposal");
		map.put("departmentTypeList", departmentTypeList);
		int id = 0;
		if (minorWorkProposalListMax != null
				&& minorWorkProposalListMax.size() > 0
				&& minorWorkProposalListMax.get(0) != null) {
			id = Integer.parseInt(minorWorkProposalListMax.get(0).toString());
			map.put("id", id);
		}
		map.put("workTypeList", worktypeList);
		map.put("minorWorkProposalList", minorWorkProposalList);
		return map;

	}

	public Map<String, Object> showMinorWorkProposalCancellationJsp() {
		Map<String, Object> map = new HashMap<String, Object>();

		return map;

	}
	public Map<String, Object> popUpForProposalJsp() {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<MasWorkType> masWorkTypelList = null;
		Session session = getSession();
		Criteria ctr = session.createCriteria(MasWorkType.class).add(Restrictions.eq("Status", "y"));
		masWorkTypelList = ctr.list();
		dataMap.put("masWorkTypelList", masWorkTypelList);
		return dataMap;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> showPopUpProposalJsp(Map<String, Object> map) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<MasMinorWorkProposal> minorWorkProposalList = null;
		List<MasWorkType> masWorkTypelList = null;
		Box box = (Box)map.get("box");
		Date fromDate = null;
		Date toDate = null;
		int workType =0;
		String detailDescribtion ="";
		Session session = getSession();
		if(box.getString(RequestConstants.MINOR_WORK_FROM_DATE)!=null && !box.getString(RequestConstants.MINOR_WORK_FROM_DATE).equalsIgnoreCase("")){
		fromDate=HMSUtil.convertStringTypeDateToDateType(box.getString(RequestConstants.MINOR_WORK_FROM_DATE));
		}
		if(box.getString(RequestConstants.MINOR_WORK_TO_DATE)!=null && !box.getString(RequestConstants.MINOR_WORK_TO_DATE).equalsIgnoreCase("")){
			fromDate=HMSUtil.convertStringTypeDateToDateType(box.getString(RequestConstants.MINOR_WORK_TO_DATE));
		}
		if(box.getString("workType")!=null && !box.getString("workType").equalsIgnoreCase("") ){
			workType = box.getInt("workType");
			
		}
		if(box.getString("detailDescribtion")!=null && !box.getString("detailDescribtion").equalsIgnoreCase("") ){
			detailDescribtion = box.getString("detailDescribtion");
			
		}
		String status = "a";
		Criteria ctr = session.createCriteria(MasMinorWorkProposal.class);
		if(fromDate!=null && toDate!=null ){
			ctr.add(Restrictions.between("MinorWorkProposalDate", fromDate, toDate));
		}
		if(workType!=0){
			ctr.createAlias("WorkType", "wt").add(Restrictions.eq("wt.Id",workType));
		}
		if(!detailDescribtion.equalsIgnoreCase("")){
			ctr.add(Restrictions.like("MinorWorkDetail", "%"+detailDescribtion+"%"));
		}
		ctr.add(Restrictions.eq("Status", "y")).addOrder(Order.asc("MinorWorkProposalNo"));
		minorWorkProposalList =ctr.list();
	    ctr = session.createCriteria(MasWorkType.class).add(Restrictions.eq("Status", "y"));
		masWorkTypelList = ctr.list();
		dataMap.put("masWorkTypelList", masWorkTypelList);
		dataMap.put("minorWorkProposalList", minorWorkProposalList);
		return dataMap;
	}

	public boolean addMinorWorkProposal(MasMinorWorkProposal minorworkdetailno,
			Map<String, Object> dataMap) {
		boolean successfullyAdded = false;
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		List<MasDepartment> departmentTypeList = new ArrayList<MasDepartment>();

		String date = "";
		Box box = null;
		date = (String) utilMap.get("currentDate");

		String[] currentDate = date.split("/");
		String currentMonth = currentDate[1];
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		if (dataMap.get("box") != null) {
			box = (Box) dataMap.get("box");
		}
		try {
			hbt.save(minorworkdetailno);
			hbt.refresh(minorworkdetailno);
			successfullyAdded = true;
			Vector deptId = box.getVector(RequestConstants.DEPARTMENT_TYPE_ID);
			for (int i = 0; i < deptId.size(); i++) {
				ProposalDepartment complaintDepartment = new ProposalDepartment();
				complaintDepartment.setProposalType(minorworkdetailno);
				if (deptId.get(i) != null && !deptId.get(i).equals("")) {
					MasDepartment masdept = new MasDepartment();
					masdept.setId(Integer.parseInt((String) deptId.get(i)));
					complaintDepartment.setDepartment(masdept);
				}
				hbt.save(complaintDepartment);
				hbt.refresh(complaintDepartment);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (successfullyAdded) {

			org.springframework.orm.hibernate3.HibernateTemplate hbt2 = getHibernateTemplate();
			hbt2.setFlushModeName("FLUSH_EAGER");
			hbt2.setCheckWriteOperations(false);
			List<TransactionSequence> minorWorkNoList = new ArrayList<TransactionSequence>();
			minorWorkNoList = session.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "MWP")).list();

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

					hbt2.update(transactionSequenceObj);
				}
			}
		}

		return successfullyAdded;
	}

	public boolean cancleMinorWorkProposal(
			MasMinorWorkProposal minorworkdetailno) {
		boolean successfullyAdded = false;

		try {

			MasMinorWorkProposal masMinorWorkDetailsUpdate = (MasMinorWorkProposal) getHibernateTemplate()
					.load(MasMinorWorkProposal.class, minorworkdetailno.getId());
			masMinorWorkDetailsUpdate.setStatus("c");
			masMinorWorkDetailsUpdate.setCancellationReason(minorworkdetailno
					.getCancellationReason());
			masMinorWorkDetailsUpdate.setLastChgBy(minorworkdetailno
					.getLastChgBy());
			masMinorWorkDetailsUpdate.setLastChgDate(minorworkdetailno
					.getLastChgDate());
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(true);
			hbt.update(masMinorWorkDetailsUpdate);
			successfullyAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public String generateMinorWorkNumber(String userName)
	{
		Map<String, Object> utilMap = null;
		List<MasMinorWorkProposal> masMinorWorkProposalList = null;
		List<TransactionSequence> orderSeqNoList = null;
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		String entrySeqNo="";
		String lastSeqNo="";
		String lastSeqYear="";
		Session session = getSession();

		try {
			masMinorWorkProposalList = session.createCriteria(MasMinorWorkProposal.class).list();
			if (masMinorWorkProposalList != null && masMinorWorkProposalList.size() > 0) {
				for (MasMinorWorkProposal masMinorWorkProposal : masMinorWorkProposalList) {
					lastSeqNo = masMinorWorkProposal.getMinorWorkProposalNo();
				}
				StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
				while (str.hasMoreTokens()) {
					lastSeqYear = str.nextToken();
				}
			} else {
				lastSeqYear = currentYear;
			}

			orderSeqNoList = session.createCriteria(TransactionSequence.class).add(Restrictions.eq("TransactionPrefix", "MWP")).list();
			if (orderSeqNoList != null && orderSeqNoList.size() > 0) {
				for (TransactionSequence maxOrderNo : orderSeqNoList) {
					if (currentYear.equals(lastSeqYear)) {
						entrySeqNo = String.valueOf(maxOrderNo
								.getTransactionSequenceNumber() + 1);
					} else {
						entrySeqNo = String.valueOf(1);
						maxOrderNo.setTransactionSequenceNumber(0);
						session.saveOrUpdate(maxOrderNo);

					}
				}
			} else {
				entrySeqNo = String.valueOf(1);
				TransactionSequence transactionSequence = new TransactionSequence();
				transactionSequence.setTransactionPrefix("MWP");
				transactionSequence.setTransactionSequenceName("Minor Work Proposal No");
				transactionSequence.setTransactionSequenceNumber(0);
				transactionSequence.setTablename("MasMinorWorkProposal");
				transactionSequence.setStatus("y");
				session.save(transactionSequence);
			}
			entrySeqNo = entrySeqNo.concat("/").concat(
					String.valueOf(lastSeqYear));
		} catch (HibernateException e) {
			e.printStackTrace();
			session.close();
		}
		return entrySeqNo;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> searchMinorWorkProposalCancellationSearch(
			AgendaDTO minorWorkDetailSearch) {
		List<MasMinorWorkProposal> searchMinorWorkDetailSearchList = new ArrayList<MasMinorWorkProposal>();
		Map<String, Object> minorWorkDetailSearchFieldsMap = new HashMap<String, Object>();
		String minorWorkNo = "";
		List<MasDepartment> departmentTypeList = new ArrayList<MasDepartment>();
		List<ProposalDepartment> searchProposalDeptList = new ArrayList<ProposalDepartment>();

		departmentTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment ");

		Session session = (Session) getSession();

		if (minorWorkDetailSearch.getMinorWorkNo() != null
				&& !minorWorkDetailSearch.getMinorWorkNo().equalsIgnoreCase("")) {
			minorWorkNo = minorWorkDetailSearch.getMinorWorkNo();
		}

		searchMinorWorkDetailSearchList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasMinorWorkProposal as imc where imc.MinorWorkProposalNo='"
								+ minorWorkNo + "'");
		if (searchMinorWorkDetailSearchList != null
				&& searchMinorWorkDetailSearchList.size() > 0) {
			searchProposalDeptList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.ProposalDepartment as imc where imc.ProposalType='"
									+ searchMinorWorkDetailSearchList.get(0)
											.getId() + "'");
		}
		/*
		 * List<ProposalDepartment> gridTypeList = new
		 * ArrayList<ProposalDepartment>(); gridTypeList =
		 * getHibernateTemplate().find( "from
		 * jkt.hms.masters.business.ProposalDepartment as imc where
		 * imc.ProposalType ='" + searchMinorWorkDetailSearchList.get(0).getId()
		 * + "'"); minorWorkDetailSearchFieldsMap.put("gridTypeList",
		 * gridTypeList);
		 */
		minorWorkDetailSearchFieldsMap.put("departmentTypeList",
				departmentTypeList);
		minorWorkDetailSearchFieldsMap.put("searchProposalDeptList",
				searchProposalDeptList);

		minorWorkDetailSearchFieldsMap.put("searchMinorWorkDetailSearchList",
				searchMinorWorkDetailSearchList);
		return minorWorkDetailSearchFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchMinorWorkDetail(
			AgendaDTO minorWorkDetailSearch) {
		List<MasMinorWorkDetail> searchMinorWorkDetailSearchList = new ArrayList<MasMinorWorkDetail>();
		Map<String, Object> minorWorkDetailSearchFieldsMap = new HashMap<String, Object>();
		String minorWorkNo = "";
		List<MasDepartment> departmentTypeList = new ArrayList<MasDepartment>();

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

		List<WorkNoDepartment> gridTypeList = new ArrayList<WorkNoDepartment>();
		if (searchMinorWorkDetailSearchList != null
				&& searchMinorWorkDetailSearchList.size() > 0) {
			gridTypeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.WorkNoDepartment as imc where imc.WorkNoType ='"
							+ searchMinorWorkDetailSearchList.get(0).getId()
							+ "'");
		}
		minorWorkDetailSearchFieldsMap.put("gridTypeList", gridTypeList);

		minorWorkDetailSearchFieldsMap.put("departmentTypeList",
				departmentTypeList);
		minorWorkDetailSearchFieldsMap.put("searchMinorWorkDetailSearchList",
				searchMinorWorkDetailSearchList);
		return minorWorkDetailSearchFieldsMap;
	}

	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> connectionMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		connectionMap.put("con", con);
		return connectionMap;
	}

}
