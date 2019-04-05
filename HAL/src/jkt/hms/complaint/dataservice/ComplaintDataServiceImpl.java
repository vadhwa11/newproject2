package jkt.hms.complaint.dataservice;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;

import jkt.hms.masters.business.ComplaintDepartment;
import jkt.hms.masters.business.ComplaintRegister;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.MasComplaintRegister;

import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasSmq;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class ComplaintDataServiceImpl extends HibernateDaoSupport implements
		ComplaintDataService {

	public Map<String, Object> showComplaintTypeJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		int id = 5;
		/*List<MasComplaintsType> searchComplaintTypeList = new ArrayList<MasComplaintsType>();*/
		List<MasDepartment> departmentTypeList = new ArrayList<MasDepartment>();
		List<ComplaintDepartment> complaintDepartment = new ArrayList<ComplaintDepartment>();
		List gridDepartmentList = null;
		gridDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.ComplaintDepartment");
		complaintDepartment = getHibernateTemplate().find(
				"from jkt.hms.masters.business.ComplaintDepartment as isc");
		departmentTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment as isc where isc.DepartmentType='"
						+ id + "'");
		/*searchComplaintTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasComplaintsType ");*/
		/*map.put("searchComplaintTypeList", searchComplaintTypeList);*/
		map.put("departmentTypeList", departmentTypeList);
		map.put("complaintDepartment", complaintDepartment);
		map.put("gridDepartmentList", gridDepartmentList);
		return map;
	}

	public Map<String, Object> searchComplaintType(String complaintTypeCode,
			String complaintTypeName) {
		/*List<MasComplaintsType> searchComplaintTypeList = new ArrayList<MasComplaintsType>();*/
		Map<String, Object> complaintTypeFieldsMap = new HashMap<String, Object>();
		List gridDepartmentList = null;
		/*List<MasComplaintsType> complaintDepartment = new ArrayList<MasComplaintsType>();*/
		try {
		/*	if ((complaintTypeName != null) || (complaintTypeCode == null)) {

				searchComplaintTypeList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasComplaintsType imc where imc.ComplaintTypeName like '"
										+ complaintTypeName
										+ "%' order by imc.ComplaintTypeName");
			} else {
				searchComplaintTypeList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasComplaintsType imc where imc.ComplaintTypeCode like '"
										+ complaintTypeCode
										+ "%' order by imc.ComplaintTypeCode");
			}*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		gridDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment");
		complaintTypeFieldsMap.put("gridDepartmentList", gridDepartmentList);
	/*	complaintTypeFieldsMap.put("searchComplaintTypeList",
				searchComplaintTypeList);
		complaintTypeFieldsMap.put("complaintDepartment", complaintDepartment);*/
		return complaintTypeFieldsMap;
	}

	public Map addComplaintType(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		/*MasComplaintsType masComplaintType = new MasComplaintsType();*/
		Box box = null;
		boolean saved = false;
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String time = (String) utilMap.get("currentTime");
		if (dataMap.get("box") != null) {
			box = (Box) dataMap.get("box");
		}
		String complaintTypeCode = (String) dataMap.get("complaintTypeCode");
		String complaintTypeName = (String) dataMap.get("complaintTypeName");
		int departmentName = (Integer) dataMap.get("departmentName");
		String lstChangedBy = (String) dataMap.get("lstChangedBy");
		Date lstChangedDate = (Date) dataMap.get("lstChangedDate");
		String lstChangedTime = (String) dataMap.get("lstChangedTime");

		/*masComplaintType.setComplaintTypeCode(complaintTypeCode);
		masComplaintType.setComplaintTypeName(complaintTypeName);*/
		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(departmentName);
	/*	masComplaintType.setDepartment(masDepartment);
		masComplaintType.setStatus("y");
		masComplaintType.setLstChangedBy(lstChangedBy);
		masComplaintType.setLstChangedDate(lstChangedDate);
		masComplaintType.setLstChangedTime(lstChangedTime);*/
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);

			/*hbt.save(masComplaintType);
			hbt.refresh(masComplaintType);*/
			Vector deptId = box.getVector(RequestConstants.DEPARTMENT_TYPE_ID);
			for (int i = 0; i < deptId.size(); i++) {
				ComplaintDepartment complaintDepartment = new ComplaintDepartment();
				/*complaintDepartment.setComplaintType(masComplaintType);*/
				if (deptId.get(i) != null && !deptId.get(i).equals("")) {
					MasDepartment masdept = new MasDepartment();
					masdept.setId(Integer.parseInt((String) deptId.get(i)));
					complaintDepartment.setDepartment(masdept);
				}
				hbt.save(complaintDepartment);
				hbt.refresh(complaintDepartment);
			}

			saved = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			//System.out.println("Error ocurred!! please try again");
			e.printStackTrace();

		}
		map.put("saved", saved);
		return map;
	}

	public boolean editComplaintTypeToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Session session = (Session) getSession();
		Date lstChangedDate = new Date();
		String lstChangedTime = "";
		lstChangedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String complaintTypeName = "";
		@SuppressWarnings("unused")
		String complaintTypeCode = "";
		int departmentName = 1;
		String maxLimit = "";
		int complaintId = 0;
		String deptStr = null;
		String lstChangedBy = "";
		complaintId = (Integer) generalMap.get("id");
		complaintTypeCode = (String) generalMap.get("complaintTypeCode");
		complaintTypeName = (String) generalMap.get("complaintTypeName");

		if (generalMap.get("deptStr") != null) {
			deptStr = (String) generalMap.get("deptStr");
		}

		lstChangedBy = (String) generalMap.get("lstChangedBy");
		lstChangedDate = (Date) generalMap.get("lstChangedDate");
		lstChangedTime = (String) generalMap.get("lstChangedTime");
		StringTokenizer str = new StringTokenizer(deptStr, ",");
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

	/*	MasComplaintsType masComplaintsType = (MasComplaintsType) getHibernateTemplate()
				.load(MasComplaintsType.class, complaintId);*/

		/*masComplaintsType.setId(complaintId);
		masComplaintsType.setComplaintTypeCode(complaintTypeCode);
		masComplaintsType.setComplaintTypeName(complaintTypeName);*/

		if (departmentName != 0) {

			MasDepartment masdepartmentType = new MasDepartment();
			masdepartmentType.setId(departmentName);
			/*masComplaintsType.setDepartment(masdepartmentType);*/

		}

	/*	masComplaintsType.setLstChangedBy(lstChangedBy);
		masComplaintsType.setLstChangedDate(lstChangedDate);
		masComplaintsType.setLstChangedTime(lstChangedTime);*/

		try {
			/*hbt.saveOrUpdate(masComplaintsType);*/
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		List<ComplaintDepartment> complaintDepartmentList = hbt
				.find("from jkt.hms.masters.business.ComplaintDepartment ud where ud.ComplaintType.Id="
						+ complaintId);
		for (Iterator iterator = complaintDepartmentList.iterator(); iterator
				.hasNext();) {
			ComplaintDepartment complaintDepartment = (ComplaintDepartment) iterator
					.next();
			int id = complaintDepartment.getId();
			String hql = "delete from jkt.hms.masters.business.ComplaintDepartment as a where a.Id = "
					+ id;
			Query query = session.createQuery(hql);
			int row = query.executeUpdate();
		}
		while (str.hasMoreTokens()) {
			ComplaintDepartment complaintDepartment = new ComplaintDepartment();
			int departmentId = Integer.parseInt(str.nextToken());
			complaintDepartment.setDepartment(new MasDepartment(departmentId));
			/*complaintDepartment.setComplaintType(masComplaintsType);*/

			try {
				hbt.save(complaintDepartment);
				hbt.refresh(complaintDepartment);
				dataUpdated = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dataUpdated;
	}

	public boolean deleteComplaintType(int complaintId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String lstChangedBy = "";
		Date lstChangedDate = new Date();
		String lstChangedTime = "";
		lstChangedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
	/*	MasComplaintsType masComplaintsType = new MasComplaintsType();
		masComplaintsType = (MasComplaintsType) getHibernateTemplate().load(
				MasComplaintsType.class, complaintId);*/
		lstChangedBy = (String) generalMap.get("lstChangedBy");
		lstChangedDate = (Date) generalMap.get("lstChangedDate");
		lstChangedTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				/*masComplaintsType.setStatus("n");*/
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				/*masComplaintsType.setStatus("y");*/
				dataDeleted = false;
			}
		}
		/*masComplaintsType.setLstChangedBy(lstChangedBy);
		masComplaintsType.setLstChangedDate(lstChangedDate);
		masComplaintsType.setLstChangedTime(lstChangedTime);*/
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		/*hbt.update(masComplaintsType);*/
		return dataDeleted;
	}

	// //////// Show Complaint Register Jsp/////////////////////

	public Map<String, Object> showComplaintRegisterJsp(int empId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasComplaintRegister> searchComplaintRegisterList = new ArrayList<MasComplaintRegister>();
		/*List<MasComplaintsType> complaintTypeList = new ArrayList<MasComplaintsType>();*/
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<ComplaintRegister> complaintRegister = new ArrayList<ComplaintRegister>();
		List<MasSmq> smqList = new ArrayList<MasSmq>();
		List gridDepartmentList = null;
		List gridSmqList = null;
		List gridComplaintList = null;
		List<MasEmployee> masEmployee = new ArrayList<MasEmployee>();

		masEmployee = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasEmployee where Id = "
								+ empId);

		map.put("masEmployee", masEmployee);
		gridComplaintList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasComplaintsType as ComplaintTypeName where Status = 'y'");
		gridDepartmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment as DepartmentName");
		searchComplaintRegisterList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasComplaintRegister");
		smqList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasSmq");
		gridSmqList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasSmq as SmqName");
	/*	complaintTypeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasComplaintsType as mc where mc.Status = 'y'");*/
		complaintRegister = getHibernateTemplate().find(
				"from jkt.hms.masters.business.ComplaintRegister");
		departmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment");
		map.put("searchComplaintRegisterList", searchComplaintRegisterList);
		map.put("gridComplaintList", gridComplaintList);
		map.put("gridDepartmentList", gridDepartmentList);
		/*map.put("complaintTypeList", complaintTypeList);*/
		map.put("smqList", smqList);
		map.put("complaintRegister", complaintRegister);
		map.put("gridSmqList", gridSmqList);
		map.put("departmentList", departmentList);
		return map;
	}

	public Map<String, Object> searchComplaintRegister(String complaintNo,
			String complaintDesc, int empId) {
		List<MasComplaintRegister> searchComplaintRegisterList = new ArrayList<MasComplaintRegister>();
		List<MasEmployee> masEmployee = new ArrayList<MasEmployee>();
		Map<String, Object> complaintRegisterFieldsMap = new HashMap<String, Object>();
		List gridComplaintList = null;
		List gridDepartmentList = null;
		List gridSmqList = null;
		try {
			if ((complaintNo != null) || (complaintDesc == null)) {

				searchComplaintRegisterList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasComplaintRegister imc where imc.ComplaintNo like '"
										+ complaintNo
										+ "%' order by imc.ComplaintNo");
			} else {
				searchComplaintRegisterList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasComplaintRegister imc where imc.ComplaintDetails like '"
										+ complaintDesc
										+ "%' order by imc.ComplaintDetails");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		masEmployee = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasEmployee where Id = "
								+ empId);
		gridSmqList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasSmq as SmqName");
		gridDepartmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment as DepartmentName");
		gridComplaintList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasComplaintsType as ComplaintTypeName");
		complaintRegisterFieldsMap.put("masEmployee", masEmployee);

		complaintRegisterFieldsMap
				.put("gridDepartmentList", gridDepartmentList);
		complaintRegisterFieldsMap.put("gridSmqList", gridSmqList);
		complaintRegisterFieldsMap.put("searchComplaintRegisterList",
				searchComplaintRegisterList);
		return complaintRegisterFieldsMap;
	}

	public boolean addComplaintRegister(
			MasComplaintRegister masComplaintRegister,
			List<ComplaintRegister> complaintRegister) {

		List<TransactionSequence> complaintRegisterList = new ArrayList<TransactionSequence>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		Session session = (Session) getSession();
		String date = "";
		date = (String) utilMap.get("currentDate");
		String[] currentDate = date.split("/");
		String currentMonth = currentDate[1];

		boolean successfullyAdded = false;
		HibernateTemplate hbt1 = getHibernateTemplate();
		hbt1.setFlushModeName("FLUSH_AUTO");
		hbt1.setCheckWriteOperations(false);
		boolean complRegister = false;
		try {
			hbt1.save(masComplaintRegister);
			hbt1.refresh(masComplaintRegister);
			complRegister = true;
			successfullyAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		SessionFactory sessFactory = getSessionFactory();
		Session sess = sessFactory.openSession();
		String sqlQuery = "select max(id)from MasComplaintRegister";
		Query query = sess.createQuery(sqlQuery);
		List list = query.list();
		int id = Integer.parseInt(list.get(0).toString());
		sess.close();

		// Adding complaint register data for the new complaint.checking weather
		// the complaint have repeat complaint or not
		if (masComplaintRegister.getComplaintCriteria() != null
				&& masComplaintRegister.getComplaintCriteria()
						.equalsIgnoreCase("repeat")) {
			// org.springframework.orm.hibernate3.HibernateTemplate hbt =
			// getHibernateTemplate();
			hbt1.setFlushModeName("FLUSH_AUTO");
			hbt1.setCheckWriteOperations(false);
			if (complaintRegister != null && complRegister) {

				for (ComplaintRegister complaintReg : complaintRegister) {
					MasComplaintRegister masComplaint = new MasComplaintRegister();
					masComplaint.setId(id);
					complaintReg.setComplaint(masComplaint);
					hbt1.save(complaintReg);
					hbt1.refresh(complaintReg);
				}

			}
		}
		complaintRegisterList = session.createCriteria(
				TransactionSequence.class).add(
				Restrictions.eq("TransactionPrefix", "CL")).list();
		// HibernateTemplate hbtTransection = getHibernateTemplate();
		hbt1.setFlushModeName("FLUSH_EAGER");
		hbt1.setCheckWriteOperations(false);

		if (complaintRegisterList.size() > 0) {
			for (TransactionSequence transactionSequence : complaintRegisterList) {
				TransactionSequence obj = transactionSequence;
				int idTransection = obj.getId();
				int seqNo = obj.getTransactionSequenceNumber();

				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt1
						.load(TransactionSequence.class, idTransection);
				transactionSequenceObj.setTransactionSequenceNumber(++seqNo);
				if (currentMonth.equalsIgnoreCase("01")) {
					transactionSequenceObj.setTransactionSequenceNumber(1);
					seqNo = 1;
				}
				hbt1.update(transactionSequenceObj);
			}
		}

		return successfullyAdded;
	}

	public String generateComplaintNo(Map<String, Object> infoMap) {
		List<TransactionSequence> complaintRegisterList = new ArrayList<TransactionSequence>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		Session session = (Session) getSession();
		String entryNo = "";
		String date = "";
		date = (String) utilMap.get("currentDate");

		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		String[] currentDate = date.split("/");
		String currentMonth = currentDate[1];
		complaintRegisterList = session.createCriteria(
				TransactionSequence.class).add(
				Restrictions.eq("TransactionPrefix", "CL")).list();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (complaintRegisterList.size() > 0) {
			for (TransactionSequence transactionSequence : complaintRegisterList) {
				TransactionSequence obj = transactionSequence;
				int seqNo = obj.getTransactionSequenceNumber() + 1;

				entryNo = entryNo.concat(String.valueOf(seqNo));
				// entryNo = entryNo.concat("/").concat(currentMonth);
				entryNo = entryNo.concat("/").concat(currentYear);
			}
		} else if (complaintRegisterList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("MasComplaintRegister");
			tsObj.setTransactionPrefix("CL");
			tsObj.setTransactionSequenceName("Complaint Register");
			tsObj.setTransactionSequenceNumber(0);
			hbt.save(tsObj);
		}
		return entryNo;
	}

	public Map<String, Object> showWorkCompletionJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasComplaintRegister> searchComplaintRegisterList = new ArrayList<MasComplaintRegister>();
		List<MasComplaintRegister> complaintRegisterList = new ArrayList<MasComplaintRegister>();
		/*List<MasComplaintsType> complaintTypeList = new ArrayList<MasComplaintsType>();*/
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List gridDepartmentList = null;
		List<MasSmq> smqList = new ArrayList<MasSmq>();
		List gridSmqList = null;
		List gridComplaintList = null;
		gridDepartmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment as DepartmentName");
		gridComplaintList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasComplaintRegister as ComplaintTypeName");
		departmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment");

		smqList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasSmq");
		gridSmqList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasSmq as SmqName");
		/*complaintTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasComplaintsType");*/
		complaintRegisterList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasComplaintRegister ");
		//System.out.println("sizeeeeee" + complaintRegisterList.size());
		searchComplaintRegisterList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasComplaintRegister ");
		map.put("searchComplaintRegisterList", searchComplaintRegisterList);
		/*map.put("complaintTypeList", complaintTypeList);*/
		map.put("gridComplaintList", gridComplaintList);
		map.put("smqList", smqList);
		map.put("gridSmqList", gridSmqList);
		map.put("complaintRegisterList", complaintRegisterList);
		map.put("gridDepartmentList", gridDepartmentList);
		map.put("departmentList", departmentList);
		return map;
	}

	public Map<String, Object> searchWorkCompletion(String complaintNo,
			String complaintDesc, String pdcOver, int deptId, int complaintType) {
		List<MasComplaintRegister> searchComplaintRegisterList = new ArrayList<MasComplaintRegister>();
		List departmentList = null;
		List complaintTypeList = null;
		List complaintRegistList = null;
		Criteria crit = null;
		Session session = (Session) getSession();
		Map<String, Object> workCompletionFieldsMap = new HashMap<String, Object>();
		List gridDepartmentList = null;
		List gridComplaintList = null;
		int departmentId = 0;
		List gridSmqList = null;
		List gridcomplaintRegistList = null;

		Map utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String currentTime = (String) utilMap.get("currentTime");

		try {
			crit = session.createCriteria(MasComplaintRegister.class);
			// crit = crit.add(Restrictions.eq("Status", "p"));
			if ((complaintNo != null) && (complaintDesc == null)) {
				crit = crit.add(Restrictions.like("ComplaintNo", "%"
						+ complaintNo + "%"));

			} else if ((complaintNo == null) && (complaintDesc != null)) {
				crit = crit.add(Restrictions.like("ComplaintDetails", "%"
						+ complaintDesc + "%"));

			}

			if (pdcOver.equalsIgnoreCase("c")) {
				crit = crit.add(Restrictions.le("Pdc", HMSUtil
						.convertStringTypeDateToDateType(currentDate)));
			}
			/*
			 * else {//System.out.println("current date "+HMSUtil.
			 * convertStringTypeDateToDateType(currentDate)); crit =
			 * crit.add(Restrictions.ge("Pdc",
			 * HMSUtil.convertStringTypeDateToDateType(currentDate))); }
			 */
			if (deptId != 0) {
				crit = crit.add(Restrictions.eq("Department.Id", deptId));
			}
			if (complaintType != 0) {
				crit = crit.add(Restrictions.eq("ComplaintType.Id",
						complaintType));
			}

			searchComplaintRegisterList = crit.list();
		} catch (Exception e)

		{
			e.printStackTrace();
		}

		gridSmqList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasSmq as SmqName");
		gridComplaintList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasComplaintsType as ComplaintTypeName");
		complaintTypeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasComplaintsType as mc where mc.Status = 'y'");
		departmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment as mc where mc.Status = 'y'");
		gridDepartmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment as DepartmentName");
		complaintRegistList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasComplaintRegister");
		gridcomplaintRegistList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasComplaintRegister ");

		workCompletionFieldsMap.put("departmentList", departmentList);
		workCompletionFieldsMap.put("complaintTypeList", complaintTypeList);
		workCompletionFieldsMap.put("gridDepartmentList", gridDepartmentList);
		workCompletionFieldsMap.put("complaintRegistList", complaintRegistList);
		workCompletionFieldsMap.put("gridComplaintRegistList",
				gridcomplaintRegistList);
		workCompletionFieldsMap.put("gridComplaintList", gridComplaintList);
		workCompletionFieldsMap.put("gridSmqList", gridSmqList);
		workCompletionFieldsMap.put("searchComplaintRegisterList",
				searchComplaintRegisterList);
		//System.out.println("departmentList in  dataservice "+ departmentList.size());
		//System.out.println("searchComplaintRegisterList in  dataservice "+ searchComplaintRegisterList.size());

		return workCompletionFieldsMap;
	}

	public boolean addWorkCompletion(
			MasComplaintRegister masComplaintRegister1,
			Map<String, Object> generalMap) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		int id = (Integer) generalMap.get("complaintId");
		//System.out.println("iddddddddddd" + id);
		MasComplaintRegister masComplaintRegister = (MasComplaintRegister) getHibernateTemplate()
				.load(MasComplaintRegister.class, id);
		if (masComplaintRegister1.getCompletionDate() != null) {
			masComplaintRegister.setStatus("c");
			masComplaintRegister.setCompletionDate(masComplaintRegister1
					.getCompletionDate());
		}

		else {
			masComplaintRegister.setStatus("p");
			masComplaintRegister.setPdc(masComplaintRegister1.getPdc());
		}

		masComplaintRegister.setDocketNo(masComplaintRegister1.getDocketNo());
		if (masComplaintRegister1.getAllocatedTo() != null) {
			masComplaintRegister.setAllocatedTo(masComplaintRegister1
					.getAllocatedTo());
		}

		if (masComplaintRegister1.getMesRemark() != null) {
			masComplaintRegister.setMesRemark(masComplaintRegister1
					.getMesRemark());
		}
		if (masComplaintRegister1.getComplaintAttandedDate() != null) {
			masComplaintRegister.setComplaintAttandedDate(masComplaintRegister1
					.getComplaintAttandedDate());
		}

		//System.out.println("status" + masComplaintRegister.getStatus());
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		// hbt.save(masComplaintRegister1);
		hbt.update(masComplaintRegister);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public Map<String, Object> getRecordsForWorkCompletion(
			Map<String, Object> map) {
		List<MasComplaintRegister> searchComplaintType = new ArrayList<MasComplaintRegister>();
		List<MasSmq> smqList = new ArrayList<MasSmq>();
		Map<String, Object> workMap = new HashMap<String, Object>();
		List<MasDepartment> departmentNameList = new ArrayList<MasDepartment>();
		List departmentList = null;
		List complaintRegistList = null;
		List complaintTypeList = null;
		List gridDepartmentList = null;
		List gridComplaintList = null;
		int departmentId = 0;
		List gridSmqList = null;
		List gridcomplaintRegistList = null;
		int complaintType = 0;
		Session session = (Session) getSession();
		int deptId = 0;
		if (map.get("deptId") != null) {
			deptId = (Integer) map.get("deptId");
			//System.out.println("deptttttttt" + deptId);

		}
		if (map.get("complaintType") != null) {
			complaintType = (Integer) map.get("complaintType");
		}

		try {
			if (deptId != 0) {
				searchComplaintType = session.createCriteria(
						MasComplaintRegister.class).add(
						Restrictions.eq("Department.Id", deptId)).list();
				//System.out.println("complaintRegisterList"+ searchComplaintType.size());
			} else {
				searchComplaintType = session.createCriteria(
						MasComplaintRegister.class).add(
						Restrictions.eq("ComplaintType.Id", complaintType))
						.list();
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		gridSmqList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasSmq as SmqName");
		gridComplaintList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasComplaintsType as ComplaintTypeName");
		departmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment as mc where mc.Status = 'y'");
		complaintTypeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasComplaintsType as mc where mc.Status = 'y'");
		gridDepartmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment as DepartmentName");
		complaintRegistList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasComplaintRegister as cr where cr.Status='y'");
		gridcomplaintRegistList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasComplaintRegister ");
		smqList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasSmq as ms where ms.Status='y'");
		workMap.put("departmentList", departmentList);
		workMap.put("gridDepartmentList", gridDepartmentList);
		workMap.put("complaintRegistList", complaintRegistList);
		workMap.put("complaintTypeList", complaintTypeList);
		workMap.put("gridComplaintRegistList", gridcomplaintRegistList);
		workMap.put("gridComplaintList", gridComplaintList);
		workMap.put("gridSmqList", gridSmqList);
		workMap.put("smqList", smqList);
		workMap.put("searchComplaintRegisterList", searchComplaintType);
		return workMap;
	}

	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		map.put("conn", con);
		return map;
	}

	public Map<String, Object> showWorkNotCompletionJsp() {
		Session session = getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasComplaintRegister> searchComplaintRegisterList = new ArrayList<MasComplaintRegister>();
		/*List<MasComplaintsType> complaintTypeList = new ArrayList<MasComplaintsType>();*/
		List<MasDepartment> departmentNameList = new ArrayList<MasDepartment>();
		List<MasComplaintRegister> workCompletion = new ArrayList<MasComplaintRegister>();
		List<MasComplaintRegister> workCompletionList = new ArrayList<MasComplaintRegister>();
		List<MasComplaintRegister> complRegistList = new ArrayList<MasComplaintRegister>();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -3);
		String date = sdf.format(cal.getTime());
		//System.out.println("Today's date is " + sdf.format(cal.getTime()));
		//System.out.println("Yesterday's date was " + sdf.format(cal.getTime()));

		if (workCompletionList.size() > 0) {
			int complaint = workCompletionList.get(0).getId();
			complRegistList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasComplaintRegister where Id= '"
							+ complaint + "'");
		}
		List<MasSmq> smqList = new ArrayList<MasSmq>();
		List gridSmqList = null;
		List gridDepartmentList = null;
		List gridComplaintList = null;
		gridDepartmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment as DepartmentName");
		gridComplaintList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasComplaintsType as ComplaintTypeName");
		departmentNameList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment");
		smqList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasSmq");
		gridSmqList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasSmq as SmqName");
	/*	complaintTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasComplaintsType");*/

		int days = 3;
		searchComplaintRegisterList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasComplaintRegister as mr where mr.Status = 'p' or mr.Status = 'r' and mr.ComplaintDate < '"
								+ date + "'");
		workCompletionList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasComplaintRegister");
		workCompletion = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasComplaintRegister");
		map.put("searchComplaintRegisterList", searchComplaintRegisterList);
		/*map.put("complaintTypeList", complaintTypeList);*/
		map.put("gridComplaintList", gridComplaintList);
		map.put("workCompletion", workCompletion);
		map.put("workCompletionList", workCompletionList);
		map.put("complRegistList", complRegistList);
		map.put("gridDepartmentList", gridDepartmentList);
		map.put("gridSmqList", gridSmqList);
		map.put("smqList", smqList);
		map.put("departmentNameList", departmentNameList);
		return map;
	}

	public Map<String, Object> searchWorkNotCompletion(String complaintNo,
			String complaintDesc) {
		List<MasComplaintRegister> searchComplaintRegisterList = new ArrayList<MasComplaintRegister>();
		List departmentNameList = null;
		List gridComplaintList = null;
		List complaintRegistList = null;
		List<MasComplaintRegister> workCompletionList = new ArrayList<MasComplaintRegister>();
		List complaintTypeList = null;
		Map<String, Object> workCompletionFieldsMap = new HashMap<String, Object>();
		List gridDepartmentList = null;
		List gridSmqList = null;
		List gridcomplaintRegistList = null;
		try {
			if ((complaintNo != null) || (complaintDesc == null)) {
				searchComplaintRegisterList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasComplaintRegister sc where sc.ComplaintNo like '"
										+ complaintNo
										+ "%' order by sc.ComplaintNo");

			} else {

				searchComplaintRegisterList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasComplaintRegister sc where sc.ComplaintDetails like '"
										+ complaintDesc
										+ "%' order by sc.ComplaintDetails");
			}
		} catch (Exception e)

		{
			e.printStackTrace();
		}
		complaintTypeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasComplaintsType as mc where mc.Status = 'y'");
		workCompletionList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasComplaintRegister");
		gridSmqList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasSmq as SmqName");
		departmentNameList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment as mc where mc.Status = 'y'");
		complaintTypeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasComplaintsType where ma.Status = 'y'");
		gridDepartmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment as DepartmentName");
		complaintRegistList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasComplaintRegister as cr where cr.Status='y'");
		gridcomplaintRegistList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasComplaintRegister ");
		gridComplaintList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasComplaintsType as ComplaintTypeName");
		workCompletionFieldsMap.put("departmentNameList", departmentNameList);
		workCompletionFieldsMap.put("gridDepartmentList", gridDepartmentList);
		workCompletionFieldsMap.put("complaintRegistList", complaintRegistList);
		workCompletionFieldsMap.put("gridComplaintList", gridComplaintList);
		workCompletionFieldsMap.put("gridSmqList", gridSmqList);
		workCompletionFieldsMap.put("workCompletionList", workCompletionList);
		workCompletionFieldsMap.put("complaintTypeList", complaintTypeList);
		workCompletionFieldsMap.put("gridComplaintRegistList",
				gridcomplaintRegistList);
		workCompletionFieldsMap.put("searchComplaintRegisterList",
				searchComplaintRegisterList);
		//System.out.println("searchComplaintRegisterList in  dataservice "	+ searchComplaintRegisterList.size());

		return workCompletionFieldsMap;
	}

	public boolean addMasComplaintRegister(
			MasComplaintRegister masComplaintRegister) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		MasComplaintRegister masComplaints = (MasComplaintRegister) hbt.load(
				MasComplaintRegister.class, masComplaintRegister.getId());
		masComplaints.setId(masComplaintRegister.getId());
		masComplaints.setCadoRemark(masComplaintRegister.getCadoRemark());
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masComplaints);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean addCommandantRemark(MasComplaintRegister masComplaintRegister) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		MasComplaintRegister masComplaints = (MasComplaintRegister) hbt.load(
				MasComplaintRegister.class, masComplaintRegister.getId());
		masComplaints.setId(masComplaintRegister.getId());
		masComplaints.setCommandantRemark(masComplaintRegister
				.getCommandantRemark());
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masComplaints);
		successfullyAdded = true;
		return successfullyAdded;
	}

	// / Report Generation Methods
	public Map<String, Object> showComplaintRegister() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = getSession();
	/*	List<MasComplaintsType> complaintTypeList = new ArrayList<MasComplaintsType>();
		complaintTypeList = session.createCriteria(MasComplaintsType.class)
				.add(Restrictions.eq("Status", "y")).list();*/
		/*if (complaintTypeList.size() > 0) {

			map.put("complaintTypeList", complaintTypeList);
		}*/
		return map;
	}

	public Map<String, Object> showWorkCompletionRegister() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = getSession();
		/*List<MasComplaintsType> complaintTypeList = new ArrayList<MasComplaintsType>();*/
		List<MasComplaintRegister> complaintRegisterList = new ArrayList<MasComplaintRegister>();
		List<MasComplaintRegister> workCompletionList = new ArrayList<MasComplaintRegister>();
		/*complaintTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasComplaintsType ");*/
		complaintRegisterList = session.createCriteria(
				MasComplaintRegister.class).add(Restrictions.eq("Status", "y"))
				.list();
		workCompletionList = session.createCriteria(MasComplaintRegister.class)
				.add(Restrictions.eq("Status", "y")).list();
		map.put("complaintRegisterList", complaintRegisterList);
		map.put("workCompletionList", workCompletionList);
		/*map.put("complaintTypeList", complaintTypeList);*/

		return map;
	}

	public String generateEntryNo(Map<String, Object> adMap) {
		// Instance variable declaration
		Session session = (Session) getSession();
		int complaintTypeId = 0;
		String adNo = "";

		List<TransactionSequence> adList = new ArrayList<TransactionSequence>();
		List<Inpatient> admissionNoList = new ArrayList<Inpatient>();
		String serviceTypeCode = (String) adMap.get("serviceTypeCode");
		complaintTypeId = Integer.parseInt("" + adMap.get("complaintTypeId"));
		String date = (String) adMap.get("date");
		String lastAdNo = "";
		String lastAdmMonth = "";
		String stCode = "";
		String sNo = "";
		String lastAdmYear = "";
		String currentMonth = "";

		// Calculating the current month in MM format
		currentMonth = date.substring(date.indexOf("/") + 1, date
				.lastIndexOf("/"));
		session = (Session) getSession();
		try {
			// Getting Inpatient List excluding manual(Back Date Entry List )
			admissionNoList = session
					.createCriteria(MasComplaintRegister.class).add(
							(Restrictions.ne("ComplaintType", "m"))).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("admissionNoList " + admissionNoList.size());
		// Finding Last auto generated AdNo
		for (Inpatient inpatient : admissionNoList) {
			lastAdNo = inpatient.getAdNo();
		}
		// Calculating the month in Last auto generated AdNo
		StringTokenizer str = new StringTokenizer(lastAdNo, "/");
		while (str.hasMoreTokens()) {
			stCode = str.nextToken();
			sNo = str.nextToken();
			lastAdmMonth = str.nextToken();
			lastAdmYear = str.nextToken();

		}
		//System.out.println("lastAdmMonth    " + lastAdmMonth);
		System.out
				.println("serviceTypeId ==================== in DS=========================  "
						+ complaintTypeId);
		// Getting the list From TransactionSequence with given serviceTypeId
		try {
			adList = session.createCriteria(TransactionSequence.class).add(
					Restrictions.eq("TransactionPrefix", "AD")).add(
					Restrictions.eq("ServiceType.Id", complaintTypeId)).list();
			//System.out.println(adList.size());
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (adList.size() > 0) {
			for (TransactionSequence transactionSequence : adList) {
				TransactionSequence obj = (TransactionSequence) adList.get(0);
				int id = obj.getId();
				int seqNo = 0;

				if (currentMonth.equals(lastAdmMonth)) {
					seqNo = obj.getTransactionSequenceNumber();
				} else {
					seqNo = 0;
				}

				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
						.load(TransactionSequence.class, id);
				transactionSequenceObj.setTransactionSequenceNumber(seqNo + 1);
				++seqNo;
				hbt.update(transactionSequenceObj);
				hbt.refresh(transactionSequenceObj);
				adNo = serviceTypeCode.concat("/");
				adNo = adNo.concat(String.valueOf(seqNo)).concat("/");
				date = date.substring(3, date.length());
				adNo = adNo.concat(date);
			}
		} else if (adList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("Inpatient");
			tsObj.setTransactionPrefix("AD");
			tsObj.setTransactionSequenceName("Ad No");
			tsObj.setTransactionSequenceNumber(1);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");
			hbt.save(tsObj);
			adNo = serviceTypeCode.concat("/");
			adNo = adNo.concat(String.valueOf(1)).concat("/");
			date = date.substring(3, date.length());
			adNo = adNo.concat(date);
		}

		return adNo;
	}

	public Map<String, Object> getRecordsForWorkNotCompletion(
			Map<String, Object> map) {
		List<MasComplaintRegister> searchComplaintType = new ArrayList<MasComplaintRegister>();
		List<MasSmq> smqList = new ArrayList<MasSmq>();
		Map<String, Object> workMap = new HashMap<String, Object>();
		List<MasDepartment> departmentNameList = new ArrayList<MasDepartment>();
		Criteria crit = null;
		List departmentList = null;
		List complaintTypeList = null;
		List complaintRegistList = null;
		List gridDepartmentList = null;
		List gridComplaintList = null;
		int departmentId = 0;
		List gridSmqList = null;
		List gridcomplaintRegistList = null;
		int complaintType = 0;
		Session session = (Session) getSession();
		int deptId = 0;
		if (map.get("deptId") != null) {
			deptId = (Integer) map.get("deptId");
			//System.out.println("deptttttttt" + deptId);

		}
		if (map.get("complaintType") != null) {
			complaintType = (Integer) map.get("complaintType");
		}

		try {
			if (deptId != 0) {
				searchComplaintType = session.createCriteria(
						MasComplaintRegister.class).add(
						Restrictions.eq("Department.Id", deptId)).list();
				//System.out.println("complaintRegisterList"+ searchComplaintType.size());
			} else {
				searchComplaintType = session.createCriteria(
						MasComplaintRegister.class).add(
						Restrictions.eq("ComplaintType.Id", complaintType))
						.list();
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		gridSmqList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasSmq as SmqName");
		gridComplaintList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasComplaintsType as ComplaintTypeName");
		departmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment as mc where mc.Status = 'y'");
		gridDepartmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment as DepartmentName");
		complaintRegistList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasComplaintRegister as cr where cr.Status='y'");
		gridcomplaintRegistList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasComplaintRegister ");
		complaintTypeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasComplaintsType as mc where mc.Status = 'y'");
		workMap.put("departmentList", departmentList);
		workMap.put("gridDepartmentList", gridDepartmentList);
		workMap.put("complaintRegistList", complaintRegistList);
		workMap.put("gridComplaintRegistList", gridcomplaintRegistList);
		workMap.put("gridComplaintList", gridComplaintList);
		workMap.put("gridSmqList", gridSmqList);
		workMap.put("complaintTypeList", complaintTypeList);
		workMap.put("searchComplaintRegisterList", searchComplaintType);
		return workMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> fillItemsForComplaintNo(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<MasComplaintRegister> complaintList = new ArrayList<MasComplaintRegister>();
		Session session = (Session) getSession();
		String complaintNo = (String) dataMap.get("complaintNo");
		try {
			complaintList = session.createCriteria(MasComplaintRegister.class)
					.add(Restrictions.eq("ComplaintNo", complaintNo)).list();
			map.put("complaintList", complaintList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

}
