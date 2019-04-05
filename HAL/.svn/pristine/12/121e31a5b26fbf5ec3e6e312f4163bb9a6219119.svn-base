package jkt.hms.stores.dataservice;

import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CONDEMNATION_ID;
import static jkt.hms.util.RequestConstants.CONDEMNATION_NO;
import static jkt.hms.util.RequestConstants.ITEMS_TO_BE_DELETED;
import static jkt.hms.util.RequestConstants.WORK_ORDER_ID;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.OpdSurgeryDetail;
import jkt.hms.masters.business.OpdSurgeryHeader;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.StoreCondemnationM;
import jkt.hms.masters.business.StoreCondemnationT;
import jkt.hms.masters.business.StoreWorkOrderM;
import jkt.hms.masters.business.StoreWorkOrderT;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.masters.business.Visit;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.PageUtil;
import jkt.hms.util.PagedArray;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class NonExpendableNewStoresDataServiceImpl extends HibernateDaoSupport
		implements NonExpendableNewStoresDataService {

	// ******************************CONDEMNATION ENTRY
	// Form**********************************

	@SuppressWarnings( { "unchecked", "unused" })
	public Map<String, Object> showCondemnationJsp(Box box,
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();

		String userName = "";
		int deptId = 0;
		int hospitalId = 0;

		if (dataMap.get("deptId") != null) {
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		}
		if (dataMap.get("hospitalId") != null) {
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		}
		if (dataMap.get("userName") != null) {
			userName = ("" + dataMap.get("userName"));
		}

		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<StoreWorkOrderM> workOrderMList = new ArrayList<StoreWorkOrderM>();
		List<StoreCondemnationM> condemnationMList = new ArrayList<StoreCondemnationM>();
		List<StoreCondemnationM> searchCondemnationMList = new ArrayList<StoreCondemnationM>();

		int condemnationNo = 0;
		Session session = (Session) getSession();
		try {
	/*		departmentList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasDepartment as ms where ms.Status = 'y'");
*/			departmentList=session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
			
			/*workOrderMList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreWorkOrderM as inp where inp.Department.Id = "
									+ deptId);*/
			workOrderMList=session.createCriteria(StoreWorkOrderM.class).add(Restrictions.eq("Department.Id", deptId)).list();
			
/*			condemnationMList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreCondemnationM as inp where inp.Department.Id = "
									+ deptId
									+ "order by inp.CondemnationNo desc");
*/			condemnationMList=session.createCriteria(StoreCondemnationM.class).add(Restrictions.eq("Department.Id", deptId)).addOrder(Order.desc("CondemnationNo")).list();
			
			if (condemnationMList != null && condemnationMList.size() > 0) {
				condemnationNo = Integer.parseInt((condemnationMList.get(0)
						.getCondemnationNo()));
			} else {
				condemnationNo = 0;
			}

/*			searchCondemnationMList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreCondemnationM as inp where inp.Department.Id = "
									+ deptId + " and inp.Status = 'o'");
*/			searchCondemnationMList=session.createCriteria(StoreCondemnationM.class).add(Restrictions.eq("Department.Id", deptId)).add(Restrictions.eq("Status", "o")).list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("searchCondemnationMList", searchCondemnationMList);
		map.put("departmentList", departmentList);
		map.put("workOrderMList", workOrderMList);
		map.put("condemnationNo", condemnationNo + 1);

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getWorkOrderDetails(Box box) {

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		session = (Session) getSession();

		String pvms = null;
		String nomenclature = null;
		String serialNo = null;
		Integer qty = null;
		String reason = null;
		String partNo = null;

		int id = 0;

		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;

		List<StoreWorkOrderT> storeWorkOrderTList = new ArrayList<StoreWorkOrderT>();
		List<StoreWorkOrderM> workOrderMList = new ArrayList<StoreWorkOrderM>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<StoreCondemnationT> storeCondemnationTList = new ArrayList<StoreCondemnationT>();

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			int workOrderId = box.getInt(WORK_ORDER_ID);
			int workId=box.getInt("workId");
			int deptId = box.getInt("deptId");
			int condemnationNo = box.getInt(CONDEMNATION_NO);

			departmentList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasDepartment as ms where ms.Status = 'y'");
			workOrderMList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreWorkOrderM as inp where inp.Department.Id = "
									+ deptId);
			/*
			 * storeWorkOrderTList =
			 * session.createCriteria(StoreWorkOrderT.class)
			 * .add(Restrictions.eq("WorkOrderM.Id", box.getInt(WORK_ORDER_ID)))
			 * .add(Restrictions.eq("WorkOrderM.Department.Id", deptId))
			 * .list();
			 */

			map.put("workOrderMList", workOrderMList);
			map.put("departmentList", departmentList);
			map.put("condemnationNo", condemnationNo);

			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			storeWorkOrderTList = hbt
					.find("from jkt.hms.masters.business.StoreWorkOrderT as inp where inp.WorkOrderM.Id="
							+ workId
							+ " and inp.WorkOrderM.Department.Id=" + deptId);

			map.put("storeWorkOrderTList", storeWorkOrderTList);

			if (storeWorkOrderTList != null && storeWorkOrderTList.size() > 0) {

				StoreCondemnationM storeCondemnationM = new StoreCondemnationM();
				storeCondemnationM.setCondemnationDate(new Date());
				storeCondemnationM.setCondemnationNo(box.get(CONDEMNATION_NO));

				MasDepartment department = new MasDepartment();
				department.setId(deptId);
				storeCondemnationM.setDepartment(department);

				MasHospital hospital = new MasHospital();
				hospital.setId(box.getInt("hospitalId"));
				storeCondemnationM.setHospital(hospital);

				storeCondemnationM.setLastChgBy(box.get(CHANGED_BY));
				storeCondemnationM.setLastChgDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString(CHANGED_DATE)));
				storeCondemnationM.setLastChgTime(box.get(CHANGED_TIME));

				storeCondemnationM.setStatus("o");

				StoreWorkOrderM workOrder = new StoreWorkOrderM();
				workOrder.setId(box.getInt(WORK_ORDER_ID));
				storeCondemnationM.setWorkOrder(workOrder);

				storeCondemnationM.setWorkOrderDate(new Date());

				hbt.save(storeCondemnationM);

				for (Iterator iterator = storeWorkOrderTList.iterator(); iterator
						.hasNext();) {
					StoreWorkOrderT tObj = (StoreWorkOrderT) iterator.next();

					StoreCondemnationT storeCondemnationT = new StoreCondemnationT();

					StoreCondemnationM mObj = new StoreCondemnationM();
					mObj.setId(storeCondemnationM.getId());
					storeCondemnationT.setCondemM(mObj);

					storeCondemnationT.setItem(tObj.getItem());
					storeCondemnationT.setPartNo(box.get("partNo"));
					storeCondemnationT.setQty(tObj.getQuantity());
					storeCondemnationT.setReasonForSentence(box.get("reason"));
					storeCondemnationT.setSerialNo(tObj.getSerialNo());
					storeCondemnationT
							.setSrNo(Integer.parseInt(tObj.getSrNo()));

					hbt.save(storeCondemnationT);
					hbt.refresh(storeCondemnationT);
				}

				storeCondemnationTList = hbt
						.find("from jkt.hms.masters.business.StoreCondemnationT as inp where inp.CondemM.CondemnationNo="
								+ box.getInt(CONDEMNATION_NO)
								+ " and inp.CondemM.Department.Id=" + deptId);

			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		for (Iterator iterator = storeCondemnationTList.iterator(); iterator
				.hasNext();) {
			StoreCondemnationT storeCondemnationT = (StoreCondemnationT) iterator
					.next();

			try {
				id = storeCondemnationT.getId();
			} catch (Exception e) {
				id = 0;
			}

			try {
				pvms = storeCondemnationT.getItem().getPvmsNo();
			} catch (Exception e) {
				pvms = "";
			}

			try {
				nomenclature = storeCondemnationT.getItem().getNomenclature();
			} catch (Exception e) {
				nomenclature = "";
			}

			try {
				serialNo = storeCondemnationT.getSerialNo();
			} catch (Exception e) {
				serialNo = "";
			}

			try {
				// reason = storeWorkOrderT.getWorkOrderM().getRepairingCell();
			} catch (Exception e) {
				reason = "";
			}

			hData = new HashMap<String, Object>();
			hData.put("id", id);
			hData.put("pvms", pvms);
			hData.put("nomenclature", nomenclature);
			hData.put("serialNo", serialNo);
			hData.put("partNo", "");
			hData.put("qty", 1);
			hData.put("reason", "");

			vResult.add(hData);
		}

		if (vResult.size() > 0) {
			testPageData = new HashMap[vResult.size()];
			vResult.copyInto(testPageData);
		}

		try {
			pagedArray = new PageUtil().convertToPagedArrayIndex(testPageData,
					box);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("pagedArray", pagedArray);
		return map;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getWorkOrderDataForDisplayGrid(Box box) {

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		session = (Session) getSession();

		String pvms = null;
		String nomenclature = null;
		String serialNo = null;
		Integer qty = null;
		String reason = null;
		String partNo = null;

		int id = 0;

		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;

		List<StoreCondemnationT> storeCondemnationTList = new ArrayList<StoreCondemnationT>();
		List<StoreCondemnationM> condemnationMList = new ArrayList<StoreCondemnationM>();
		List<StoreWorkOrderM> workOrderMList = new ArrayList<StoreWorkOrderM>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<StoreCondemnationM> condemnationNoMList = new ArrayList<StoreCondemnationM>();

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			int workOrderId = box.getInt(WORK_ORDER_ID);
			int deptId = box.getInt("deptId");
			int condemnationNo = box.getInt(CONDEMNATION_NO);

			departmentList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasDepartment as ms where ms.Status = 'y'");
			condemnationMList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreCondemnationM as inp where inp.Department.Id = "
									+ deptId);
			workOrderMList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreWorkOrderM as inp where inp.Department.Id = "
									+ deptId);

			map.put("workOrderMList", workOrderMList);
			map.put("condemnationNo", condemnationNo);

			condemnationNoMList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreCondemnationM as inp where inp.Department.Id = "
									+ deptId
									+ "and inp.CondemnationNo = "
									+ condemnationNo);

			if (condemnationNoMList != null && condemnationNoMList.size() > 0) {
				condemnationNo = Integer.parseInt(condemnationNoMList.get(0)
						.getCondemnationNo());
				workOrderId = condemnationNoMList.get(0).getWorkOrder().getId();

				String condemnationDate = HMSUtil
						.convertDateToStringWithoutTime(condemnationNoMList
								.get(0).getCondemnationDate());
				String workOrderDate = HMSUtil
						.convertDateToStringWithoutTime(condemnationNoMList
								.get(0).getWorkOrderDate());

				map.put("workOrderDate", workOrderDate);
				map.put("condemnationDate", condemnationDate);
			}

			/*
			 * storeWorkOrderTList =
			 * session.createCriteria(StoreWorkOrderT.class)
			 * .add(Restrictions.eq("WorkOrderM.Id", box.getInt(WORK_ORDER_ID)))
			 * .add(Restrictions.eq("WorkOrderM.Department.Id", deptId))
			 * .list();
			 * 
			 * //System.out.println("storeWorkOrderTList -------------- "+
			 * storeWorkOrderTList.size());
			 */

			map.put("condemnationMList", condemnationMList);
			map.put("departmentList", departmentList);

			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			/*
			 * storeCondemnationTList = hbt.find(
			 * "from jkt.hms.masters.business.StoreCondemnationT as inp where inp.CondemM.Id="
			 * + box.getInt(WORK_ORDER_ID) + " and inp.CondemM.Department.Id=" +
			 * deptId);
			 */

			storeCondemnationTList = hbt
					.find("from jkt.hms.masters.business.StoreCondemnationT as inp where inp.CondemM.CondemnationNo="
							+ box.getInt(CONDEMNATION_NO)
							+ " and inp.CondemM.Department.Id=" + deptId);
			map.put("storeCondemnationTList", storeCondemnationTList);

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		for (Iterator iterator = storeCondemnationTList.iterator(); iterator
				.hasNext();) {
			StoreCondemnationT storeCondemnationT = (StoreCondemnationT) iterator
					.next();

			try {
				id = storeCondemnationT.getId();
			} catch (Exception e) {
				id = 0;
			}

			try {
				pvms = storeCondemnationT.getItem().getPvmsNo();
			} catch (Exception e) {
				pvms = "";
			}

			try {
				nomenclature = storeCondemnationT.getItem().getNomenclature();
			} catch (Exception e) {
				nomenclature = "";
			}

			try {
				serialNo = storeCondemnationT.getSerialNo();
			} catch (Exception e) {
				serialNo = "";
			}

			try {
				reason = storeCondemnationT.getReasonForSentence();
			} catch (Exception e) {
				reason = "";
			}

			try {
				partNo = storeCondemnationT.getPartNo();
			} catch (Exception e) {
				partNo = "";
			}

			hData = new HashMap<String, Object>();
			hData.put("id", id);
			hData.put("pvms", pvms);
			hData.put("nomenclature", nomenclature);
			hData.put("serialNo", serialNo);
			hData.put("partNo", partNo);
			hData.put("qty", 1);
			hData.put("reason", reason);

			vResult.add(hData);
		}

		if (vResult.size() > 0) {
			testPageData = new HashMap[vResult.size()];
			vResult.copyInto(testPageData);
		}

		try {
			pagedArray = new PageUtil().convertToPagedArrayIndex(testPageData,
					box);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("pagedArray", pagedArray);
		return map;

	}

	public Map<String, Object> deleteGridItemsForCondemnation(Box box) {

		Session session = (Session) getSession();
		List<StoreCondemnationT> storeCondemnationTList = new ArrayList<StoreCondemnationT>();
		StoreCondemnationT storeCondemnationT = new StoreCondemnationT();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			HibernateTemplate hbt = getHibernateTemplate();

			Vector srno = box.getVector("srno");
			// Vector annreq = box.getVector(TENDER_ANNREQ);
			Vector items = box.getVector("id");
			Vector delete = box.getVector(ITEMS_TO_BE_DELETED);

			String obj = null;
			for (int i = 0; i < delete.size(); i++) {
				int itemId = Integer.parseInt(delete.get(i).toString());
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				// String hql="delete from
				// jkt.hms.masters.business.StoreMmfDepartmentT as a where
				// a.Item.Id = "+itemId;
				String hql = "delete from jkt.hms.masters.business.StoreCondemnationT as a where a.Id like :itemId";
				Query query = session.createQuery(hql).setParameter("itemId",
						itemId);
				int row = query.executeUpdate();

			}
			map.put("total_records", srno.size());
			map.put("deleted_records", delete.size());
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		if (Integer.parseInt(map.get("total_records").toString()) == Integer
				.parseInt(map.get("deleted_records").toString())) {
			if (box.getInt("currPage") > 1)
				box.put("currPage", box.getInt("currPage") - 1);
		}

		map = getWorkOrderDataForDisplayGrid(box);
		return map;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> updateGridItemsInCondemnation(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Vector srno = box.getVector("srno");
			Vector items = box.getVector("id");
			//Vector partNo = box.getVector("partNo");
			Vector reason = box.getVector("reason");
			Vector reportRemarks = box.getVector("reportRemarks");
			Vector remarks = box.getVector("remarks");

			String obj = null;
			for (int i = 0; i >srno.size(); i++) {
				int itemId = Integer.parseInt(items.get(i).toString());
				StoreCondemnationT tObj = (StoreCondemnationT) hbt.load(
						StoreCondemnationT.class, itemId);
				//tObj.setPartNo(partNo.get(i).toString());
				tObj.setReasonForSentence(reason.get(i).toString());
				hbt.update(tObj);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map = getWorkOrderDataForDisplayGrid(box);
		return map;
	}
	@Override
	public Map<String, Object> saveCondemnationEntry(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Transaction tx = null;
		int orderNo = 0;
		boolean succesfullyAdded = false;
		int hospitalId = 0;
		int deptId = 0;
		try {
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			String currentDate = (String) utilMap.get("currentDate");
			String time = (String) utilMap.get("currentTime");
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			StoreCondemnationM storeCondemnationM = new StoreCondemnationM();
			storeCondemnationM.setCondemnationNo(box.getString("IVNo"));
			storeCondemnationM.setCondemnationDate(HMSUtil.convertStringTypeDateToDateType(box.getString("condemnationDate")));
			System.out.println("dept=="+box.getInt("deptId"));
			MasDepartment masDepartmentObj = new MasDepartment();
			masDepartmentObj.setId(box.getInt("deptId"));
			storeCondemnationM.setDepartment(masDepartmentObj);
			System.out.println("hospital=="+box.getInt("hospitalId"));

			MasHospital masHospital= new MasHospital();
			masHospital.setId(box.getInt("hospitalId"));
			storeCondemnationM.setHospital(masHospital);
			storeCondemnationM.setStatus("o");
			storeCondemnationM.setLastChgBy("admin");
			storeCondemnationM.setLastChgDate(new Date());
			storeCondemnationM.setLastChgTime(time);
			hbt.save(storeCondemnationM);
			System.out.println("item=="+box.getInt("nameItem1"));
			if(!box.getString("nameItem1").equals("")){
				StoreCondemnationT storeCondemnationT = new StoreCondemnationT();
				 	int index1 = box.getString("nameItem1").lastIndexOf("[");
				    int index2 = box.getString("nameItem1").lastIndexOf("]");
				    index1++;
				    String pvms = box.getString("nameItem1").substring(index1,index2);
				List<MasStoreItem> itemIdList = new ArrayList<MasStoreItem>();
				itemIdList = session.createCriteria(MasStoreItem.class).add(Restrictions.eq("PvmsNo",pvms )).list();
				if(itemIdList.size()>0){
					MasStoreItem masStoreItem = itemIdList.get(0);
				System.out.println("itemId==="+masStoreItem.getId());
					masStoreItem.setId(masStoreItem.getId());
					storeCondemnationT.setItem(masStoreItem);
				}
				storeCondemnationT.setSerialNo(box.getString("serialNo"));
				storeCondemnationT.setSrNo(1);
				storeCondemnationT.setReasonForSentence(box.getString("reason"));
				storeCondemnationT.setPartNo(box.getString("reportRemarks"));
				storeCondemnationT.setRemarks(box.getString("remarks"));
				storeCondemnationT.setQty(box.getInt("qty"));
				storeCondemnationT.setCondemM(storeCondemnationM);
				hbt.save(storeCondemnationT);
			}
			

			succesfullyAdded = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		} 
		map.put("succesfullyAdded", succesfullyAdded);
		return map;
	}

	@SuppressWarnings( { "unused", "unchecked" })
	public Map<String, Object> searchCondemnation(Box box) {

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		session = (Session) getSession();

		String pvms = null;
		String nomenclature = null;
		String serialNo = null;
		Integer qty = null;
		String reason = null;
		String partNo = null;

		int id = 0;

		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;

		List<StoreCondemnationT> storeCondemnationTList = new ArrayList<StoreCondemnationT>();
		List<StoreCondemnationM> condemnationMList = new ArrayList<StoreCondemnationM>();
		List<StoreCondemnationM> searchCondemnationMList = new ArrayList<StoreCondemnationM>();
		List<StoreCondemnationM> condemnationNoMList = new ArrayList<StoreCondemnationM>();
		List<StoreWorkOrderM> workOrderMList = new ArrayList<StoreWorkOrderM>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			int condemnationId = box.getInt(CONDEMNATION_ID);
			int deptId = box.getInt("deptId");

			// int condemnationNo = box.getInt(CONDEMNATION_NO);

			condemnationNoMList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreCondemnationM as inp where inp.Department.Id = "
									+ deptId + "and inp.Id = " + condemnationId);

			int condemnationNo = 0;
			int workOrderId = 0;

			if (condemnationNoMList != null && condemnationNoMList.size() > 0) {
				condemnationNo = Integer.parseInt(condemnationNoMList.get(0)
						.getCondemnationNo());
				workOrderId = condemnationNoMList.get(0).getWorkOrder().getId();

				String condemnationDate = HMSUtil
						.convertDateToStringWithoutTime(condemnationNoMList
								.get(0).getCondemnationDate());
				String workOrderDate = HMSUtil
						.convertDateToStringWithoutTime(condemnationNoMList
								.get(0).getWorkOrderDate());

				map.put("workOrderDate", workOrderDate);
				map.put("condemnationDate", condemnationDate);
				map.put("condemnationNo", condemnationNo);
				map.put("workOrderId", workOrderId);
			}
			searchCondemnationMList = getHibernateTemplate()
			.find(
					"from jkt.hms.masters.business.StoreCondemnationM as inp where inp.Department.Id = "
							+ deptId + " and inp.Status = 'o'");
			
			departmentList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasDepartment as ms where ms.Status = 'y'");
			condemnationMList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreCondemnationM as inp where inp.Department.Id = "
									+ deptId);
			workOrderMList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreWorkOrderM as inp where inp.Department.Id = "
									+ deptId);
			map.put("searchCondemnationMList", searchCondemnationMList);
			map.put("workOrderMList", workOrderMList);
			map.put("condemnationNo", condemnationNo);

			/*
			 * storeWorkOrderTList =
			 * session.createCriteria(StoreWorkOrderT.class)
			 * .add(Restrictions.eq("WorkOrderM.Id", box.getInt(WORK_ORDER_ID)))
			 * .add(Restrictions.eq("WorkOrderM.Department.Id", deptId))
			 * .list();
			 * 
			 * //System.out.println("storeWorkOrderTList -------------- "+
			 * storeWorkOrderTList.size());
			 */

			map.put("condemnationMList", condemnationMList);
			map.put("departmentList", departmentList);

			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			/*
			 * storeCondemnationTList = hbt.find(
			 * "from jkt.hms.masters.business.StoreCondemnationT as inp where inp.CondemM.Id="
			 * + box.getInt(WORK_ORDER_ID) + " and inp.CondemM.Department.Id=" +
			 * deptId);
			 */

			storeCondemnationTList = hbt
					.find("from jkt.hms.masters.business.StoreCondemnationT as inp where inp.CondemM.Id="
							+ box.getInt(CONDEMNATION_ID)
							+ " and inp.CondemM.Department.Id=" + deptId);

			map.put("storeCondemnationTList", storeCondemnationTList);

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		for (Iterator iterator = storeCondemnationTList.iterator(); iterator
				.hasNext();) {
			StoreCondemnationT storeCondemnationT = (StoreCondemnationT) iterator
					.next();

			try {
				id = storeCondemnationT.getId();
			} catch (Exception e) {
				id = 0;
			}

			try {
				pvms = storeCondemnationT.getItem().getPvmsNo();
			} catch (Exception e) {
				pvms = "";
			}

			try {
				nomenclature = storeCondemnationT.getItem().getNomenclature();
			} catch (Exception e) {
				nomenclature = "";
			}

			try {
				serialNo = storeCondemnationT.getSerialNo();
			} catch (Exception e) {
				serialNo = "";
			}

			try {
				reason = storeCondemnationT.getReasonForSentence();
			} catch (Exception e) {
				reason = "";
			}

			try {
				partNo = storeCondemnationT.getPartNo();
			} catch (Exception e) {
				partNo = "";
			}

			hData = new HashMap<String, Object>();
			hData.put("id", id);
			hData.put("pvms", pvms);
			hData.put("nomenclature", nomenclature);
			hData.put("serialNo", serialNo);
			hData.put("partNo", partNo);
			hData.put("qty", 1);
			hData.put("reason", reason);

			vResult.add(hData);
		}

		if (vResult.size() > 0) {
			testPageData = new HashMap[vResult.size()];
			vResult.copyInto(testPageData);
		}

		try {
			pagedArray = new PageUtil().convertToPagedArrayIndex(testPageData,
					box);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("pagedArray", pagedArray);
		return map;

	}

	public Map<String, Object> getCondemnationPrintMap(int condemnationId) {

		Map map = new HashMap();
		Session session = (Session) getSession();
		List<StoreCondemnationM> storeCondemnationMList = new ArrayList<StoreCondemnationM>();
		String indentType = "";

		Connection con = session.connection();
		try {

			storeCondemnationMList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreCondemnationM as md where md.Id = '"
							+ condemnationId + "'");
			for (StoreCondemnationM storeCondemnationM : storeCondemnationMList) {
				// condemnationId = storeCondemnationM.getId();
				// map.put("indentor",""+ "CHAF,Bangalore");
				// map.put("projectionTo", "DGAFMS");
				// map.put("mmfYear",""+ indentM.getMmfForTheYear());
				// map.put("Hosp_Name",
				// ""+indentM.getHospital().getHospitalName());
				map.put("condemnationId", condemnationId);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;

		/*
		 * Session session = (Session)getSession(); Map map=new HashMap();
		 * List<StoreCondemnationM> list =
		 * session.createCriteria(StoreCondemnationM
		 * .class).add(Restrictions.eq("Id", condemnationId)).list();
		 * //System.out.println("List Ka SIZZEEEE---------" +list.size());
		 * if(list.size() > 0){ StoreCondemnationM mObj =
		 * (StoreCondemnationM)list.get(0); docNo = mObj.getDocNo();
		 * //System.out.println("Doc No isn DSSS ========= "+docNo); } return
		 * docNo;
		 */

	}

	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> connectionMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		connectionMap.put("con", con);
		return connectionMap;
	}

	

}
