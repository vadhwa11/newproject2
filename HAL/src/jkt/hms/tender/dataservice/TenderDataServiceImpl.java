/**  
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * Class TenderDataServiceImpl.java 
 * Tendering Process 
 * Tables Used: store_tender_proposal, store_tender_m, store_tender_t, etc..
 * @author  Create Date: 20.03.2008  Name: Othivadivel K R 
 * Revision Date:      		Revision By: 
 * @version 1.0  
 * @see 
 **/

package jkt.hms.tender.dataservice;

import static jkt.hms.util.RequestConstants.*;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.sql.Connection;
import java.sql.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasStoreFinancial;
import jkt.hms.masters.business.MasStoreGroup;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasStoreSupplier;
import jkt.hms.masters.business.MasStoreSupplierGroup;
import jkt.hms.masters.business.StoreFyDocumentNo;
import jkt.hms.masters.business.StoreIndentM;
import jkt.hms.masters.business.StoreIndentT;
import jkt.hms.masters.business.StoreItemBatchStock;
import jkt.hms.masters.business.StorePoDetail;
import jkt.hms.masters.business.StorePoHeader;
import jkt.hms.masters.business.StoreReTenderProposal;
import jkt.hms.masters.business.StoreSetup;
import jkt.hms.masters.business.StoreTenderCommBidM;
import jkt.hms.masters.business.StoreTenderCommBidT;
import jkt.hms.masters.business.StoreTenderCommHodRecom;
import jkt.hms.masters.business.StoreTenderInvitaLetterToVender;
import jkt.hms.masters.business.StoreTenderInvitationLetter;
import jkt.hms.masters.business.StoreTenderLocalPurchaseM;
import jkt.hms.masters.business.StoreTenderLocalPurchaseT;
import jkt.hms.masters.business.StoreTenderM;
import jkt.hms.masters.business.StoreTenderProposal;
import jkt.hms.masters.business.StoreTenderT;
import jkt.hms.masters.business.StoreTenderTechnicalBidM;
import jkt.hms.masters.business.StoreTenderTechnicalBidT;
import jkt.hms.masters.business.StoreTenderToSupplier;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.PageUtil;
import jkt.hms.util.PagedArray;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class TenderDataServiceImpl extends HibernateDaoSupport implements
		TenderDataService {

	public Map<String, Object> getTenderNos(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List existingTenderNumbersList = new ArrayList();
		List<MasStoreGroup> masStoreGroupList = new ArrayList<MasStoreGroup>();
		List objectList = new ArrayList();
		int id = 0;
		String masterStatus = null;
		session = (Session) getSession();
		try {
			List<StoreTenderM> storeTenderMList = new ArrayList<StoreTenderM>();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			storeTenderMList = hbt
					.find("from jkt.hms.masters.business.StoreTenderM as inp order by inp.Id desc");
			for (Iterator iterator = storeTenderMList.iterator(); iterator
					.hasNext();) {
				StoreTenderM storeTenderM = (StoreTenderM) iterator.next();
				existingTenderNumbersList.add(storeTenderM.getTenderNo());
			}

			if (!box.getString(TENDER_NO).equals("")) {
				storeTenderMList = hbt
						.find("from jkt.hms.masters.business.StoreTenderM as inp where inp.TenderNo='"
								+ box.getString(TENDER_NO) + "'");
				masterStatus = storeTenderMList.get(0).getStatus();
				map.put("masterStatus", masterStatus);
				if (storeTenderMList != null && storeTenderMList.size() > 0) {
					String query = "SELECT distinct m.group_id FROM mas_store_item m, store_tender_proposal t  where m.item_id = t.item_id and t.tender_id ="
							+ storeTenderMList.get(0).getId();
					objectList = (List) session.createSQLQuery(query).list();
					if (objectList != null && objectList.size() > 0) {
						if (objectList.get(0) != null) {
							id = Integer.parseInt("" + objectList.get(0));
						}
						masStoreGroupList = (List<MasStoreGroup>) session
								.createCriteria(MasStoreGroup.class).add(
										(Restrictions.eq("Id", id))).list();
						map.put("masStoreGroupList", masStoreGroupList);
					}
				}
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("existingTenderNumbersList", existingTenderNumbersList);
		return map;
	}

	public Map<String, Object> showTenderCreationJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List existingTenderNumbersList = new ArrayList();
		List<MasStoreGroup> masStoreGroupList = new ArrayList<MasStoreGroup>();
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		List<StoreSetup> storeSetupList = new ArrayList<StoreSetup>();

		List mmfyears = new ArrayList();
		String last_tender_no = "";
		String new_tender_no = "";
		String proposals = "";
		String no = "";
		try {
			List<StoreTenderM> storeTenderMList = new ArrayList<StoreTenderM>();
			List<StoreIndentM> storeIndentMList = new ArrayList<StoreIndentM>();
			List<StoreTenderProposal> storeTenderProposalList = new ArrayList<StoreTenderProposal>();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			storeTenderMList = hbt
					.find("from jkt.hms.masters.business.StoreTenderM as inp order by inp.Id desc");
			storeIndentMList = hbt
					.find("from jkt.hms.masters.business.StoreIndentM as inp where inp.IndentType='p' order by inp.MmfForTheYear desc");
			storeTenderProposalList = hbt
					.find("from jkt.hms.masters.business.StoreTenderProposal as inp where inp.Status = 'o'");
			masStoreGroupList = hbt
					.find("from jkt.hms.masters.business.MasStoreGroup");
			if (storeTenderProposalList != null
					&& storeTenderProposalList.size() > 0) {
				proposals = "yes";
			}

			if (storeTenderMList != null && storeTenderMList.size() > 0) {
				last_tender_no = storeTenderMList.get(0).getTenderNo()
						.toString();
			}

			for (Iterator iterator = storeIndentMList.iterator(); iterator
					.hasNext();) {
				StoreIndentM storeIndentM = (StoreIndentM) iterator.next();
				mmfyears.add(storeIndentM.getMmfForTheYear());
			}

			try {
				storeSetupList = hbt
						.find("from jkt.hms.masters.business.StoreSetup");

				int exp_dept_id = storeSetupList.get(0).getStoreExpendable()
						.getId();
				storeFyDocumentNoList = (List) getHibernateTemplate().find(
						"from jkt.hms.masters.business.StoreFyDocumentNo ");
				for (StoreFyDocumentNo storeFyDocumentNo : storeFyDocumentNoList) {
					if (storeFyDocumentNo.getDepartment().getId() == exp_dept_id) {
						no = ("" + storeFyDocumentNo.getTenderNo());
						// //System.out.println("noooooooooooooooooooooooooooooooooo "+no);
						// no=getMaxNo(no);
						new_tender_no = getMaxNo(no);
						//System.out.println("no     " + no);
					}
				}
			} catch (Exception e) {
				//System.out.println("in db    " + e);
				e.printStackTrace();
			}

			// new_tender_no = getMaxNo(last_tender_no);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map = getTenderNos(box);
		map.put("mmfyears", mmfyears);
		map.put("proposals", proposals);
		map.put("new_tender_no", new_tender_no);
		map.put("masStoreGroupList", masStoreGroupList);
		return map;
	}

	public Map<String, Object> createTenderMasterAndTransaction(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;
		StoreIndentT storeIndentT = null;
		StoreIndentM storeIndentM = null;

		String pvms = null;
		String nomenclature = null;
		String strength = null;
		String au = null;
		BigDecimal qtymmf = null;
		BigDecimal annreq = null;
		int item_id = 0;
		int mmf_tender_month = 2;

		List<StoreIndentM> storeIndentMList = new ArrayList<StoreIndentM>();
		List<StoreIndentT> storeIndentTList = new ArrayList<StoreIndentT>();
		List<StoreSetup> storeSetupList = new ArrayList<StoreSetup>();
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		Set<StoreIndentT> storeIndentTSet = null;
		List existingTenderNumbersList = null;

		Session session = (Session) getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			storeIndentMList = hbt
					.find("from jkt.hms.masters.business.StoreIndentM as inp where inp.IndentType='p' and inp.MmfForTheYear='"
							+ box.get("mmfyear").toString() + "'");
			storeSetupList = hbt
					.find("from jkt.hms.masters.business.StoreSetup as inp");
			if (storeSetupList != null && storeSetupList.size() > 0) {
				mmf_tender_month = storeSetupList.get(0).getMmfTenderMonth();
			}

			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			StoreTenderM storeTenderM = new StoreTenderM();

			int hospital_id = Integer
					.parseInt(box.get("hospitalId").toString());
			int deptId = box.getInt("deptId");
			String groupId = box.getString("groupId");

			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(new Integer(deptId));

			MasHospital masHospital = new MasHospital();
			masHospital.setId(new Integer(hospital_id));

			storeTenderM.setHospital(masHospital);
			storeTenderM.setDepartment(masDepartment);
			storeTenderM.setTenderNo(box.get(TENDER_NO));
			storeTenderM.setTenderInvitationDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.get(DATE_INVITE_TENDER)));
			storeTenderM
					.setCommOfIssueDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(DATE_COMMENCEMENT)));
			storeTenderM.setIssueLastDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.get(LAST_DATE_TENDER_DOCUMENT)));
			storeTenderM.setTenderReceiptTime(box
					.get(TIME_RECEIPT_TENDER_SAMPLES));
			storeTenderM.setTenderReceiptPlace(box
					.get(PLACE_RECEIPT_TENDER_SAMPLES));
			storeTenderM.setTenderRecLastDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.get(LAST_DATE_RECEIPT_TENDER_SAMPLES)));
			storeTenderM.setTechnicalOpeningDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.get(DATE_OPENING_TECHNICAL)));
			storeTenderM.setCommercialOpeningDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.get(DATE_OPENING_COMMERCIAL)));
			storeTenderM.setTermsAndConditions(box.get(TERMS_CONDITIONS));
			storeTenderM.setLastChangedBy(box.get(CHANGED_BY));
			storeTenderM.setLastChangedDate(HMSUtil
					.convertStringTypeDateToDateType(box.get(CHANGED_DATE)));
			storeTenderM.setLastChangedTime(box.get(CHANGED_TIME));
			storeTenderM.setStatus("O");
			storeTenderM.setGroup(new MasStoreGroup(Integer.parseInt(groupId)));
			hbt.save(storeTenderM);

			Criteria c = session.createCriteria(StoreFyDocumentNo.class).add(
					Restrictions.eq("Department.Id", deptId));
			storeFyDocumentNoList = c.list();
			String tndStartNo = "";
			for (StoreFyDocumentNo storeFyDocumentNo : storeFyDocumentNoList) {
				if (storeFyDocumentNo.getTenderNo() != null) {
					tndStartNo = ("" + storeFyDocumentNo.getTenderNo());
					tndStartNo = getMaxNo(tndStartNo);
				} else {
					tndStartNo = getMaxNo("");
				}
			}
			int storeFyId = 0;
			for (StoreFyDocumentNo documentNo : storeFyDocumentNoList) {
				storeFyId = documentNo.getId();
			}
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) getHibernateTemplate()
					.load(StoreFyDocumentNo.class, storeFyId);
			storeFyDocumentNo.setTenderNo(tndStartNo);
			hbt.update(storeFyDocumentNo);
			hbt.refresh(storeFyDocumentNo);

			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			List<StoreTenderM> storeTenderMList = new ArrayList<StoreTenderM>();
			storeTenderMList = hbt
					.find("from jkt.hms.masters.business.StoreTenderM as inp where inp.TenderNo='"
							+ box.get(TENDER_NO).toString() + "'");

			int tender_id = 0;
			if (storeTenderMList.size() > 0) {
				storeTenderM = (StoreTenderM) storeTenderMList.get(0);
				tender_id = storeTenderM.getId();
			}

			storeTenderM = new StoreTenderM();
			storeTenderM.setId(tender_id);

			if (storeIndentMList.size() > 0) {
				storeIndentM = (StoreIndentM) storeIndentMList.get(0);
				storeIndentTSet = (Set) storeIndentM.getStoreIndentTs();
				int i = 0;
				for (Iterator iterator = storeIndentTSet.iterator(); iterator
						.hasNext();) {
					BigDecimal qtyInHand = null;
					storeIndentT = (StoreIndentT) iterator.next();
					MasStoreItem masStoreItem = new MasStoreItem();
					masStoreItem = storeIndentT.getItem();
					List<StoreItemBatchStock> storeItemBatchStockList = new ArrayList<StoreItemBatchStock>();
					String str = "select sum(inp.closing_stock) from store_item_batch_stock as inp where department_id = "
							+ box.getInt("deptId")
							+ " and item_id = "
							+ masStoreItem.getId();
					storeItemBatchStockList = session.createSQLQuery(str)
							.list();
					Iterator iterator1 = storeItemBatchStockList.iterator();
					while (iterator1.hasNext()) {
						qtyInHand = (BigDecimal) iterator1.next();
					}

					try {
						pvms = storeIndentT.getItem().getPvmsNo();
					} catch (Exception e) {
						pvms = "";
					}

					try {
						nomenclature = storeIndentT.getItem().getNomenclature();
					} catch (Exception e) {
						nomenclature = "";
					}

					try {
						strength = storeIndentT.getItem().getStrength();
					} catch (Exception e) {
						strength = "";
					}

					try {
						au = storeIndentT.getItem().getItemConversion()
								.getPurchaseUnit().getUnitName();
					} catch (Exception e) {
						au = "";
					}

					try {
						qtymmf = storeIndentT.getQtyInMmf();
					} catch (Exception e) {
						qtymmf = new BigDecimal(0);
					}

					try {
						annreq = qtymmf.multiply(new BigDecimal(
								mmf_tender_month));
					} catch (Exception e) {
						annreq = new BigDecimal(0);
					}

					try {
						item_id = storeIndentT.getItem().getId();
					} catch (Exception e) {
						item_id = 0;
					}

					hData = new HashMap<String, Object>();
					hData.put(TENDER_ITEM_ID, item_id);
					hData.put(TENDER_PVMS, pvms);
					hData.put(TENDER_NOMENCLATURE, nomenclature);
					hData.put(TENDER_STRENGTH, strength);
					hData.put(TENDER_MMFQTY, qtymmf);
					hData.put(TENDER_ANNREQ, annreq);
					hData.put(TENDER_AU, au);
					hData.put(TENDER_STOCK_IN_HAND, qtyInHand);

					vResult.add(hData);

					hbt.setFlushModeName("FLUSH_AUTO");
					hbt.setCheckWriteOperations(false);

					StoreTenderT storeTenderT = new StoreTenderT();

					masStoreItem = new MasStoreItem();
					masStoreItem.setId(item_id);

					storeTenderT.setTenderM(storeTenderM);
					storeTenderT.setItem(masStoreItem);
					storeTenderT.setSrNo(++i);
					storeTenderT.setQtyInMmf(qtymmf);
					storeTenderT.setTenderQty(annreq);

					hbt.save(storeTenderT);
				}
			}
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
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
		map = getTenderNos(box);
		map.put("pagedArray", pagedArray);
		return map;
	}

	public Map<String, Object> getMMFGridData(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> masterDataMap = new HashMap<String, Object>();
		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;
		StoreTenderT storeTenderT = new StoreTenderT();

		String pvms = null;
		String nomenclature = null;
		String strength = null;
		String au = null;
		BigDecimal qtymmf = null;
		BigDecimal annreq = null;
		int item_id = 0;
		int echs_dept_id = 0;
		int exp_dept_id = 0;
		// BigDecimal echs_tender_qty = new BigDecimal(0);
		// BigDecimal exp_tender_qty = new BigDecimal(0);

		List<StoreTenderT> storeTenderTList = new ArrayList<StoreTenderT>();
		List<StoreSetup> storeSetupList = new ArrayList<StoreSetup>();
		List<StoreTenderProposal> storeTenderProposalList1 = new ArrayList<StoreTenderProposal>();
		List<StoreTenderProposal> storeTenderProposalList2 = new ArrayList<StoreTenderProposal>();
		Session session = (Session) getSession();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			if (box.getString("pvmsNo").length() > 0) {
				storeTenderTList = hbt
						.find("from jkt.hms.masters.business.StoreTenderT as inp where inp.TenderM.TenderNo='"
								+ box.getString(TENDER_NO)
								+ "' and inp.Item.PvmsNo='"
								+ box.getString("pvmsNo") + "'");
			} else {
				storeTenderTList = hbt
						.find("from jkt.hms.masters.business.StoreTenderT as inp where inp.TenderM.TenderNo='"
								+ box.getString(TENDER_NO) + "'");
			}

			storeSetupList = hbt
					.find("from jkt.hms.masters.business.StoreSetup");
			echs_dept_id = storeSetupList.get(0).getStoreEchs().getId();
			exp_dept_id = storeSetupList.get(0).getStoreExpendable().getId();

			if (storeTenderTList != null && storeTenderTList.size() > 0) {
				StoreTenderM storeTenderM = storeTenderTList.get(0)
						.getTenderM();

				String dt = storeTenderM.getTenderInvitationDate().toString();
				String converted_date = dt.substring(8) + "/"
						+ dt.substring(5, 7) + "/" + dt.substring(0, 4);
				masterDataMap.put(DATE_INVITE_TENDER, converted_date);

				dt = storeTenderM.getCommOfIssueDate().toString();
				converted_date = dt.substring(8) + "/" + dt.substring(5, 7)
						+ "/" + dt.substring(0, 4);
				masterDataMap.put(DATE_COMMENCEMENT, converted_date);

				dt = storeTenderM.getIssueLastDate().toString();
				converted_date = dt.substring(8) + "/" + dt.substring(5, 7)
						+ "/" + dt.substring(0, 4);
				masterDataMap.put(LAST_DATE_TENDER_DOCUMENT, converted_date);

				masterDataMap.put(TIME_RECEIPT_TENDER_SAMPLES, storeTenderM
						.getTenderReceiptTime());
				masterDataMap.put(PLACE_RECEIPT_TENDER_SAMPLES, storeTenderM
						.getTenderReceiptPlace());

				dt = storeTenderM.getTenderRecLastDate().toString();
				converted_date = dt.substring(8) + "/" + dt.substring(5, 7)
						+ "/" + dt.substring(0, 4);
				masterDataMap.put(LAST_DATE_RECEIPT_TENDER_SAMPLES,
						converted_date);

				dt = storeTenderM.getTechnicalOpeningDate().toString();
				converted_date = dt.substring(8) + "/" + dt.substring(5, 7)
						+ "/" + dt.substring(0, 4);
				masterDataMap.put(DATE_OPENING_TECHNICAL, converted_date);

				dt = storeTenderM.getCommercialOpeningDate().toString();
				converted_date = dt.substring(8) + "/" + dt.substring(5, 7)
						+ "/" + dt.substring(0, 4);
				masterDataMap.put(DATE_OPENING_COMMERCIAL, converted_date);

				masterDataMap.put(TERMS_CONDITIONS, storeTenderM
						.getTermsAndConditions());
			}

			for (Iterator iterator = storeTenderTList.iterator(); iterator
					.hasNext();) {
				BigDecimal echs_tender_qty = new BigDecimal(0);
				BigDecimal exp_tender_qty = new BigDecimal(0);

				storeTenderT = (StoreTenderT) iterator.next();
				BigDecimal qtyInHand = null;
				MasStoreItem masStoreItem = new MasStoreItem();
				masStoreItem = storeTenderT.getItem();
				List<StoreItemBatchStock> storeItemBatchStockList = new ArrayList<StoreItemBatchStock>();
				String str = "select sum(inp.closing_stock) from store_item_batch_stock as inp where department_id = "
						+ box.getInt("deptId")
						+ " and item_id = "
						+ masStoreItem.getId();
				storeItemBatchStockList = session.createSQLQuery(str).list();
				Iterator iterator1 = storeItemBatchStockList.iterator();
				while (iterator1.hasNext()) {
					qtyInHand = (BigDecimal) iterator1.next();
				}

				str = " select tender_qty from store_tender_proposal where item_id = "
						+ masStoreItem.getId()
						+ " and department_id = "
						+ echs_dept_id
						+ " and tender_id  = "
						+ storeTenderT.getTenderM().getId();
				storeTenderProposalList1 = session.createSQLQuery(str).list();

				// storeTenderProposalList1 = hbt.find("from
				// jkt.hms.masters.business.StoreTenderProposal as inp where
				// inp.Item.Id =" + masStoreItem.getId() + " and
				// inp.Department.Id=" + echs_dept_id + " and inp.TenderId.Id =
				// " + storeTenderT.getTenderM().getId());
				// storeTenderProposalList2 = hbt.find("from
				// jkt.hms.masters.business.StoreTenderProposal as inp where
				// inp.Item.Id =" + masStoreItem.getId() + " and
				// inp.Department.Id=" + exp_dept_id + " and inp.TenderId.Id = "
				// + storeTenderT.getTenderM().getId());
				iterator1 = storeTenderProposalList1.iterator();
				while (iterator1.hasNext()) {
					echs_tender_qty = (BigDecimal) iterator1.next();
				}

				str = " select tender_qty from store_tender_proposal where item_id = "
						+ masStoreItem.getId()
						+ " and department_id = "
						+ exp_dept_id
						+ " and tender_id  = "
						+ storeTenderT.getTenderM().getId();
				storeTenderProposalList2 = session.createSQLQuery(str).list();

				iterator1 = storeTenderProposalList2.iterator();
				while (iterator1.hasNext()) {
					exp_tender_qty = (BigDecimal) iterator1.next();
				}

				try {
					pvms = storeTenderT.getItem().getPvmsNo();
				} catch (Exception e) {
					pvms = "";
				}

				try {
					nomenclature = storeTenderT.getItem().getNomenclature();
				} catch (Exception e) {
					nomenclature = "";
				}

				try {
					strength = storeTenderT.getItem().getStrength();
				} catch (Exception e) {
					strength = "";
				}

				try {
					au = storeTenderT.getItem().getItemConversion()
							.getPurchaseUnit().getUnitName();
				} catch (Exception e) {
					au = "";
				}

				try {
					qtymmf = storeTenderT.getQtyInMmf();
				} catch (Exception e) {
					qtymmf = new BigDecimal(0);
				}

				try {
					annreq = storeTenderT.getTenderQty();
				} catch (Exception e) {
					annreq = new BigDecimal(0);
				}

				try {
					item_id = storeTenderT.getItem().getId();
				} catch (Exception e) {
					item_id = 0;
				}

				hData = new HashMap<String, Object>();
				hData.put(TENDER_ITEM_ID, item_id);
				hData.put(TENDER_PVMS, pvms);
				hData.put(TENDER_NOMENCLATURE, nomenclature);
				hData.put(TENDER_STRENGTH, strength);
				hData.put(TENDER_MMFQTY, qtymmf);
				hData.put(TENDER_ANNREQ, annreq.toBigInteger());
				hData.put(TENDER_AU, au);
				hData.put(TENDER_STOCK_IN_HAND, qtyInHand);
				hData.put("echs_tender_qty", echs_tender_qty.toBigInteger());
				hData.put("exp_tender_qty", exp_tender_qty.toBigInteger());

				vResult.add(hData);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
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
		map = getTenderNos(box);
		map.put("masterDataMap", masterDataMap);
		map.put("pagedArray", pagedArray);
		return map;
	}

	public Map<String, Object> updateGridItems(Box box) {
		List<StoreTenderT> storeTenderTList = new ArrayList<StoreTenderT>();
		Map<String, Object> map = new HashMap<String, Object>();
		StoreTenderT storeTenderT = new StoreTenderT();
		Session session = (Session) getSession();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Vector srno = box.getVector(TENDER_SRNO);
			Vector annreq = box.getVector(TENDER_ANNREQ);
			Vector items = box.getVector(TENDER_ITEM_ID);

			String obj = null;
			for (int i = 0; i < srno.size(); i++) {
				int item_id = Integer.parseInt(items.get(i).toString());
				storeTenderTList = hbt
						.find("from jkt.hms.masters.business.StoreTenderT as inp where inp.TenderM.TenderNo='"
								+ box.get(TENDER_NO).toString()
								+ "' and inp.Item.Id= " + item_id);
				if (storeTenderTList.size() > 0) {
					storeTenderT = storeTenderTList.get(0);
					if (annreq.get(i).toString().trim().length() > 0) {
						storeTenderT.setTenderQty(new BigDecimal(annreq.get(i)
								.toString()));
					} else {
						storeTenderT.setTenderQty(new BigDecimal(0));
					}
					hbt.update(storeTenderT);
					hbt.refresh(storeTenderT);
				}
			}

			if (box.get("master_update") != null
					&& box.getInt("master_update") == 1) {
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				List<StoreTenderM> storeTenderMList = new ArrayList<StoreTenderM>();
				StoreTenderM storeTenderM = new StoreTenderM();
				storeTenderMList = hbt
						.find("from jkt.hms.masters.business.StoreTenderM as inp where inp.TenderNo='"
								+ box.get(TENDER_NO).toString() + "'");
				if (storeTenderMList != null && storeTenderMList.size() > 0) {
					storeTenderM = storeTenderMList.get(0);

					storeTenderM.setTenderInvitationDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(DATE_INVITE_TENDER)));
					storeTenderM.setCommOfIssueDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(DATE_COMMENCEMENT)));
					storeTenderM.setIssueLastDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(LAST_DATE_TENDER_DOCUMENT)));
					storeTenderM.setTenderReceiptTime(box
							.get(TIME_RECEIPT_TENDER_SAMPLES));
					storeTenderM.setTenderReceiptPlace(box
							.get(PLACE_RECEIPT_TENDER_SAMPLES));
					storeTenderM.setTenderRecLastDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(LAST_DATE_RECEIPT_TENDER_SAMPLES)));
					storeTenderM.setTechnicalOpeningDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(DATE_OPENING_TECHNICAL)));
					storeTenderM.setCommercialOpeningDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(DATE_OPENING_COMMERCIAL)));
					storeTenderM.setTermsAndConditions(box
							.get(TERMS_CONDITIONS));
					storeTenderM.setLastChangedBy(box.get(CHANGED_BY));
					storeTenderM.setLastChangedDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(CHANGED_DATE)));
					storeTenderM.setLastChangedTime(box.get(CHANGED_TIME));
					hbt.update(storeTenderM);
					hbt.refresh(storeTenderM);
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		/*
		 * Map<String, Object> map = new HashMap<String, Object>(); PagedArray
		 * pagedArray = null; HashMap<String, Object> hData = null;
		 * Vector<HashMap> vResult = new Vector<HashMap>(); HashMap[]
		 * testPageData = null;
		 * 
		 * 
		 * String pvms = null; String nomenclature = null; String strength =
		 * null; String au = null; BigDecimal qtymmf = null; BigDecimal annreq =
		 * null; int item_id = 0;
		 * 
		 * try { org.springframework.orm.hibernate3.HibernateTemplate hbt =
		 * getHibernateTemplate(); hbt.setFlushModeName("FLUSH_EAGER");
		 * hbt.setCheckWriteOperations(false); storeTenderTList = hbt.find("from
		 * jkt.hms.masters.business.StoreTenderT as inp where
		 * inp.TenderM.TenderNo='" + box.get(TENDER_NO).toString() + "'"); }
		 * catch (HibernateException e) { e.printStackTrace(); }
		 * 
		 * Map<String, Object> masterDataMap = new HashMap<String, Object>(); if
		 * (storeTenderTList !=null && storeTenderTList.size()>0) { StoreTenderM
		 * storeTenderM = storeTenderTList.get(0).getTenderM();
		 * 
		 * String dt = storeTenderM.getTenderInvitationDate().toString(); String
		 * converted_date = dt.substring(8) + "/" +dt.substring(5, 7) + "/" +
		 * dt.substring(0, 4); masterDataMap.put(DATE_INVITE_TENDER,
		 * converted_date);
		 * 
		 * 
		 * dt = storeTenderM.getCommOfIssueDate().toString(); converted_date =
		 * dt.substring(8) + "/" +dt.substring(5, 7) + "/" + dt.substring(0, 4);
		 * masterDataMap.put(DATE_COMMENCEMENT,converted_date);
		 * 
		 * 
		 * dt = storeTenderM.getIssueLastDate().toString(); converted_date =
		 * dt.substring(8) + "/" +dt.substring(5, 7) + "/" + dt.substring(0, 4);
		 * masterDataMap.put(LAST_DATE_TENDER_DOCUMENT,converted_date);
		 * 
		 * masterDataMap.put(TIME_RECEIPT_TENDER_SAMPLES,storeTenderM.
		 * getTenderReceiptTime());
		 * masterDataMap.put(PLACE_RECEIPT_TENDER_SAMPLES
		 * ,storeTenderM.getTenderReceiptPlace());
		 * 
		 * 
		 * dt = storeTenderM.getTenderRecLastDate().toString(); converted_date =
		 * dt.substring(8) + "/" +dt.substring(5, 7) + "/" + dt.substring(0, 4);
		 * masterDataMap.put(LAST_DATE_RECEIPT_TENDER_SAMPLES,converted_date);
		 * 
		 * dt = storeTenderM.getTechnicalOpeningDate().toString();
		 * converted_date = dt.substring(8) + "/" +dt.substring(5, 7) + "/" +
		 * dt.substring(0, 4);
		 * masterDataMap.put(DATE_OPENING_TECHNICAL,converted_date);
		 * 
		 * dt = storeTenderM.getCommercialOpeningDate().toString();
		 * converted_date = dt.substring(8) + "/" +dt.substring(5, 7) + "/" +
		 * dt.substring(0, 4);
		 * masterDataMap.put(DATE_OPENING_COMMERCIAL,converted_date);
		 * 
		 * masterDataMap.put(TERMS_CONDITIONS,
		 * storeTenderM.getTermsAndConditions()); }
		 * 
		 * 
		 * 
		 * for (Iterator iterator = storeTenderTList.iterator();
		 * iterator.hasNext();) { storeTenderT = (StoreTenderT) iterator.next();
		 * BigDecimal qtyInHand = null; MasStoreItem masStoreItem = new
		 * MasStoreItem(); masStoreItem = storeTenderT.getItem();
		 * List<StoreItemBatchStock> storeItemBatchStockList = new
		 * ArrayList<StoreItemBatchStock>(); String str = "select
		 * sum(inp.closing_stock) from store_item_batch_stock as inp where
		 * department_id = "+box.getInt("deptId") + " and item_id = " +
		 * masStoreItem.getId(); storeItemBatchStockList =
		 * session.createSQLQuery(str).list(); Iterator iterator1 =
		 * storeItemBatchStockList.iterator(); while (iterator1.hasNext()) {
		 * qtyInHand = (BigDecimal) iterator1.next(); }
		 * 
		 * try { pvms = storeTenderT.getItem().getPvmsNo(); } catch(Exception e)
		 * { pvms = ""; }
		 * 
		 * try { nomenclature = storeTenderT.getItem().getNomenclature(); }
		 * catch(Exception e) { nomenclature = ""; }
		 * 
		 * try { strength = storeTenderT.getItem().getStrength(); }
		 * catch(Exception e) { strength = ""; }
		 * 
		 * try { au =
		 * storeTenderT.getItem().getItemConversion().getItemUnitName(); }
		 * catch(Exception e) { au = ""; }
		 * 
		 * try { qtymmf = storeTenderT.getQtyInMmf(); } catch(Exception e) {
		 * qtymmf = new BigDecimal(0); }
		 * 
		 * try { annreq = storeTenderT.getTenderQty(); } catch(Exception e) {
		 * annreq = new BigDecimal(0); }
		 * 
		 * try { item_id = storeTenderT.getItem().getId(); } catch(Exception e)
		 * { item_id = 0; }
		 * 
		 * hData = new HashMap<String, Object>(); hData.put(TENDER_ITEM_ID,
		 * item_id); hData.put(TENDER_PVMS, pvms);
		 * hData.put(TENDER_NOMENCLATURE, nomenclature);
		 * hData.put(TENDER_STRENGTH, strength); hData.put(TENDER_MMFQTY,
		 * qtymmf); hData.put(TENDER_ANNREQ,annreq); hData.put(TENDER_AU, au);
		 * hData.put(TENDER_STOCK_IN_HAND, qtyInHand);
		 * 
		 * vResult.add(hData); }
		 * 
		 * 
		 * if (vResult.size()>0) { testPageData = new HashMap[vResult.size()];
		 * vResult.copyInto(testPageData); }
		 * 
		 * try { pagedArray = new
		 * PageUtil().convertToPagedArrayIndex(testPageData , box); }
		 * catch(Exception e) { e.printStackTrace(); } map = getTenderNos(box);
		 * map.put("pagedArray", pagedArray); map.put("masterDataMap",
		 * masterDataMap);
		 */map = getMMFGridData(box);
		return map;
	}

	public Map<String, Object> deleteGridItems(Box box) {
		Session session = (Session) getSession();
		List<StoreTenderT> storeTenderTList = new ArrayList<StoreTenderT>();
		StoreTenderT storeTenderT = new StoreTenderT();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Vector srno = box.getVector(TENDER_SRNO);
			Vector annreq = box.getVector(TENDER_ANNREQ);
			Vector items = box.getVector(TENDER_ITEM_ID);
			Vector delete = box.getVector(ITEMS_TO_BE_DELETED);

			String obj = null;
			for (int i = 0; i < delete.size(); i++) {
				int item_id = Integer.parseInt(delete.get(i).toString());
				int id = 0;
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				storeTenderTList = hbt
						.find("from jkt.hms.masters.business.StoreTenderT as a where a.TenderM.TenderNo='"
								+ box.getString(TENDER_NO)
								+ "' and a.Item.Id="
								+ item_id);
				if (storeTenderTList != null && storeTenderTList.size() > 0) {
					id = storeTenderTList.get(0).getId();
				}
				String hql = "delete from jkt.hms.masters.business.StoreTenderT as a where a.Id like :id";
				Query query = session.createQuery(hql).setParameter("id", id);
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

		map = getMMFGridData(box);
		return map;
	}

	public Map<String, Object> getItemDetails(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List<StoreIndentT> storeindentTList = new ArrayList<StoreIndentT>();
		List<StoreSetup> storeSetupList = new ArrayList<StoreSetup>();
		String message = "No Items Found (or) MMF not available";

		session = (Session) getSession();
		String pvms = null;
		String nomenclature = null;
		String strength = null;
		String au = null;
		String disp_type = null;
		BigDecimal annreq = null;
		int item_id = 0;
		String group_id = null;

		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector tenderTItems = new Vector();
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;

		Map dateMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) dateMap.get("currentDate");
		String mmfDate = date.substring(6, date.length());
		int mmfYear = Integer.parseInt(mmfDate);
		String mmfType = "";

		int month, year;
		Calendar cal = Calendar.getInstance();
		Calendar calendar = Calendar.getInstance();
		month = calendar.get(Calendar.MONTH) + 1;
		if (month < 4) {
			year = calendar.get(Calendar.YEAR) - 1;
		} else {
			year = calendar.get(Calendar.YEAR);
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt1 = getHibernateTemplate();
		hbt1.setFlushModeName("FLUSH_EAGER");
		hbt1.setCheckWriteOperations(false);
		storeSetupList = hbt1.find("from jkt.hms.masters.business.StoreSetup");
		int echs_dept_id = storeSetupList.get(0).getStoreEchs().getId();
		int exp_dept_id = storeSetupList.get(0).getStoreExpendable().getId();
		if (box.getInt("deptId") == exp_dept_id) {
			mmfType = "e";
		} else if (box.getInt("deptId") == echs_dept_id) {
			mmfType = "h";
		}

		// dateOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		// if (dateOfMonth < 10)
		// dateOnly.append("0");
		// dateOnly.append( dateOfMonth );

		System.out
				.println("mmf year to fetched from store indent T--------------------"
						+ mmfYear);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			if (!box.getString(TENDER_NO).equals("")) {
				List<StoreTenderT> storeTenderTList = new ArrayList<StoreTenderT>();
				storeTenderTList = hbt
						.find("from jkt.hms.masters.business.StoreTenderT as inp where inp.TenderM.TenderNo='"
								+ box.get(TENDER_NO).toString() + "'");
				for (Iterator iterator = storeTenderTList.iterator(); iterator
						.hasNext();) {
					StoreTenderT storeTenderT = (StoreTenderT) iterator.next();
					tenderTItems.add(storeTenderT.getItem().getId());
				}
			} else {
				List<StoreTenderProposal> storeTenderProposalList = new ArrayList<StoreTenderProposal>();
				storeTenderProposalList = hbt
						.find("from jkt.hms.masters.business.StoreTenderProposal as inp where inp.Status='o' and inp.Department.Id="
								+ box.getInt("deptId"));
				for (Iterator iterator = storeTenderProposalList.iterator(); iterator
						.hasNext();) {
					StoreTenderProposal storeTenderProposal = (StoreTenderProposal) iterator
							.next();
					tenderTItems.add(storeTenderProposal.getItem().getId());
				}
			}

			String str = "";
			Criteria c = null;
			String queryString = null;

			if (box.get("search_text") != null
					&& box.getString("search_text").length() > 0) {
				if (box.get("pvms") != null
						&& box.getString("pvms").length() > 0) {
					str = "%" + box.getString("search_text") + "%";
					pvms = box.getString("pvms");
					c = session.createCriteria(MasStoreItem.class).add(
							Restrictions.or(Restrictions.like("Nomenclature",
									str), Restrictions.eq("PvmsNo", pvms)))
							.add(
									Restrictions.eq("Group.Id", box
											.getInt("groupId"))).add(
									Restrictions.eq("Status", "y"));
				} else {
					str = "%" + box.getString("search_text") + "%";
					c = session.createCriteria(MasStoreItem.class).add(
							Restrictions.like("Nomenclature", str)).add(
							Restrictions.eq("Group.Id", box.getInt("groupId")))
							.add(Restrictions.eq("Status", "y"));
				}
			} else {
				if (box.get("pvms") != null
						&& box.getString("pvms").length() > 0) {
					pvms = box.getString("pvms");
					c = session.createCriteria(MasStoreItem.class).add(
							Restrictions.like("PvmsNo", pvms)).add(
							Restrictions.eq("Group.Id", box.getInt("groupId")))
							.add(Restrictions.eq("Status", "y"));
				} else {
					c = session.createCriteria(MasStoreItem.class).add(
							Restrictions.eq("Group.Id", box.getInt("groupId")))
							.add(Restrictions.eq("Status", "y"));
					c.setFirstResult(0);
					c.setMaxResults(1000);
				}
			}

			itemList = c.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		// //System.out.println("::::::::show all status:::::::::::"+box.get("show"));
		for (Iterator iterator = itemList.iterator(); iterator.hasNext();) {
			MasStoreItem masStoreItem = (MasStoreItem) iterator.next();

			String currYearMmfSumQuery = "SELECT sum(curr_year_mmf) FROM store_mmf_department_t t,store_mmf_department_m m,mas_store_item s where t.store_mmf_department_m_id=m.id and t.item_id=s.item_id and m.mmf_for_the_year='"
					+ year
					+ "'"
					+ " and s.item_id ='"
					+ masStoreItem.getId()
					+ "' and m.mmf_store_type='" + mmfType + "'";
			List objectCurrentYearList = new ArrayList();
			objectCurrentYearList = (List) session.createSQLQuery(
					currYearMmfSumQuery).list();

			BigDecimal qtymmf = null;
			if (objectCurrentYearList != null
					&& objectCurrentYearList.size() > 0) {
				if (objectCurrentYearList.get(0) != null) {
					qtymmf = new BigDecimal("" + objectCurrentYearList.get(0));
				}
			} else {
				qtymmf = new BigDecimal(0);
			}

			/*
			 * storeindentTList = session.createCriteria(StoreIndentT.class)
			 * .createAlias("Indent", "m").add(
			 * Restrictions.eq("m.MmfForTheYear", mmfYear)).add(
			 * Restrictions.eq("Item.Id", masStoreItem.getId())) .add(
			 * Restrictions.eq("m.Department.Id", box
			 * .getInt("deptId"))).list();
			 * 
			 * if (storeindentTList != null && storeindentTList.size() > 0) {
			 * qtymmf = storeindentTList.get(0).getQtyInMmf(); } else { qtymmf =
			 * new BigDecimal(0); }
			 */

			BigDecimal qtyInHand = null;
			List<StoreItemBatchStock> storeItemBatchStockList = new ArrayList<StoreItemBatchStock>();
			String str = "select sum(inp.closing_stock) from store_item_batch_stock as inp where department_id = "
					+ box.getInt("deptId")
					+ " and item_id = "
					+ masStoreItem.getId();
			storeItemBatchStockList = session.createSQLQuery(str).list();
			Iterator iterator1 = storeItemBatchStockList.iterator();
			while (iterator1.hasNext()) {
				qtyInHand = (BigDecimal) iterator1.next();
			}

			try {
				pvms = masStoreItem.getPvmsNo();
			} catch (Exception e) {
				pvms = "";
			}

			try {
				nomenclature = masStoreItem.getNomenclature();
			} catch (Exception e) {
				nomenclature = "";
			}

			try {
				strength = masStoreItem.getStrength();
			} catch (Exception e) {
				strength = "";
			}

			try {
				au = masStoreItem.getItemConversion().getPurchaseUnit()
						.getUnitName();
			} catch (Exception e) {
				au = "";
			}

			try {
				disp_type = masStoreItem.getItemConversion()
						.getIntermediateUnit().getUnitName();
			} catch (Exception e) {
				disp_type = "";
			}

			try {
				item_id = masStoreItem.getId();
			} catch (Exception e) {
				item_id = 0;
			}
			if (masStoreItem.getGroup() != null) {
				group_id = String.valueOf(masStoreItem.getGroup().getId());
			} else {
				group_id = null;
			}

			if (!tenderTItems.contains(item_id)) {

				// //System.out.println("mmf::::::::::::"+qtymmf);
				boolean mmfzero = false;
				if (qtymmf != null) {
					if (qtymmf.compareTo(new BigDecimal(0)) == 0) {
						mmfzero = true;
					}
				} else {
					// qtymmf = new BigDecimal("0");
					mmfzero = true;
				}
				if (box.get("show").equals("true")) {
					hData = new HashMap<String, Object>();
					hData.put(TENDER_ITEM_ID, item_id);
					hData.put(TENDER_PVMS, pvms);
					hData.put(TENDER_NOMENCLATURE, nomenclature);
					hData.put(TENDER_STRENGTH, strength);
					hData.put(TENDER_MMFQTY, qtymmf);
					// hData.put(TENDER_ANNREQ, annreq);
					if (qtymmf != new BigDecimal(0) && qtymmf != null) {
						hData.put(TENDER_ANNREQ, new BigDecimal(2)
								.multiply(qtymmf));
					} else {
						hData.put(TENDER_ANNREQ, annreq);
					}
					hData.put(TENDER_AU, au);
					hData.put("disp_type", disp_type);
					hData.put(TENDER_STOCK_IN_HAND, qtyInHand);
					hData.put("Item_group", group_id);
					vResult.add(hData);
				} else {
					if (!mmfzero) {
						hData = new HashMap<String, Object>();
						hData.put(TENDER_ITEM_ID, item_id);
						hData.put(TENDER_PVMS, pvms);
						hData.put(TENDER_NOMENCLATURE, nomenclature);
						hData.put(TENDER_STRENGTH, strength);
						hData.put(TENDER_MMFQTY, qtymmf);
						// hData.put(TENDER_ANNREQ, annreq);
						if (qtymmf != new BigDecimal(0) && qtymmf != null) {
							hData.put(TENDER_ANNREQ, new BigDecimal(2)
									.multiply(qtymmf));
						} else {
							hData.put(TENDER_ANNREQ, annreq);
						}
						hData.put(TENDER_AU, au);
						hData.put("disp_type", disp_type);
						hData.put(TENDER_STOCK_IN_HAND, qtyInHand);
						hData.put("Item_group", group_id);
						vResult.add(hData);
					}
				}
				/*
				 * hData = new HashMap<String, Object>();
				 * hData.put(TENDER_ITEM_ID, item_id); hData.put(TENDER_PVMS,
				 * pvms); hData.put(TENDER_NOMENCLATURE, nomenclature);
				 * hData.put(TENDER_STRENGTH, strength);
				 * hData.put(TENDER_MMFQTY, qtymmf); //hData.put(TENDER_ANNREQ,
				 * annreq); if(qtymmf != new BigDecimal(0) && qtymmf != null){
				 * hData.put(TENDER_ANNREQ, new BigDecimal(2).multiply(qtymmf));
				 * }else{ hData.put(TENDER_ANNREQ, annreq); }
				 * hData.put(TENDER_AU, au); hData.put("disp_type", disp_type);
				 * hData.put(TENDER_STOCK_IN_HAND, qtyInHand);
				 * hData.put("Item_group",group_id ); vResult.add(hData);
				 */
			} else {
				message = "Item is Already added";
			}
		}

		if (vResult.size() > 0) {
			// //System.out.println("::::::::"+vResult.size());
			testPageData = new HashMap[vResult.size()];
			vResult.copyInto(testPageData);
		}

		try {
			pagedArray = new PageUtil().convertToPagedArrayIndex(testPageData,
					box);
			// //System.out.println("total recs " + pagedArray.getNumOfRows());
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("message", message);
		map.put("pagedArray", pagedArray);
		map.put("groupId", box.getInt("groupId"));
		return map;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
    public Map<String, Object> getItemDetailsForNextRecord(Box box) {
            Session session = (Session) getSession();
            Map<String, Object> map = new HashMap<String, Object>();
            List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
            session = (Session) getSession();
            String pvms = null;
            String nomenclature = null;
            String strength = null;
            String au = null;
            String disp_type = null;
            BigDecimal qtymmf = null;
            BigDecimal annreq = null;
            String mmfType = "";
            int item_id = 0;
            String group_id = null;
            PagedArray pagedArray = null;
            HashMap<String, Object> hData = null;
            Vector tenderTItems = new Vector();
            Vector<HashMap> vResult = new Vector<HashMap>();
            HashMap[] testPageData = null;
            //---for mmf quantity by dipali---
            List<StoreSetup> storeSetupList = new ArrayList<StoreSetup>();
            org.springframework.orm.hibernate3.HibernateTemplate hbt1 = getHibernateTemplate();
            hbt1.setFlushModeName("FLUSH_EAGER");
            hbt1.setCheckWriteOperations(false);
            
            storeSetupList = hbt1.find("from jkt.hms.masters.business.StoreSetup");
            int echs_dept_id = storeSetupList.get(0).getStoreEchs().getId();
            int exp_dept_id = storeSetupList.get(0).getStoreExpendable().getId();
            if (box.getInt("deptId") == exp_dept_id) {
                    mmfType = "e";
            } else if (box.getInt("deptId") == echs_dept_id) {
                    mmfType = "h";
            }
            //-----End --for mmf quantity by dipali----------------------------
            Map dateMap = (Map) HMSUtil.getCurrentDateAndTime();
            String date = (String) dateMap.get("currentDate");
            String mmfDate = date.substring(6, date.length());
            int mmfYear = Integer.parseInt(mmfDate);
            try {
                    org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
                    hbt.setFlushModeName("FLUSH_EAGER");
                    hbt.setCheckWriteOperations(false);
                    if (!box.getString(TENDER_NO).equals("")) {
                            List<StoreTenderT> storeTenderTList = new ArrayList<StoreTenderT>();
                            storeTenderTList = hbt
                                            .find("from jkt.hms.masters.business.StoreTenderT as inp where inp.TenderM.TenderNo='"
                                                            + box.get(TENDER_NO).toString() + "'");
                            for (Iterator iterator = storeTenderTList.iterator(); iterator.hasNext();) {
                                    StoreTenderT storeTenderT = (StoreTenderT) iterator.next();
                                    tenderTItems.add(storeTenderT.getItem().getId());
                            }
                    } else {
                            List<StoreTenderProposal> storeTenderProposalList = new
ArrayList<StoreTenderProposal>();
                            storeTenderProposalList = hbt
                                            .find("from jkt.hms.masters.business.StoreTenderProposal as inp where inp.Status='o' and inp.Department.Id="
                                                            + box.getInt("deptId"));
                            
                            for (Iterator iterator = storeTenderProposalList.iterator(); iterator.hasNext();) {
                                    StoreTenderProposal storeTenderProposal = (StoreTenderProposal) iterator.next();
                                    tenderTItems.add(storeTenderProposal.getItem().getId());
                            }
                    }

                    String str = "";
                    Criteria c = null;

                    if (box.get("search_text") != null        && box.getString("search_text").length() > 0) {
                            if (box.get("pvms") != null        && box.getString("pvms").length() > 0) {
                                    str = "%" + box.getString("search_text") + "%";
                                    pvms = box.getString("pvms");
                                    c = session.createCriteria(MasStoreItem.class).add(
                                                    Restrictions.or(Restrictions.like("Nomenclature",str),
Restrictions.eq("PvmsNo", pvms)))
                                                    .add(Restrictions.eq("Group.Id", box.getInt("groupId")));
                            } else {
                                    str = "%" + box.getString("search_text") + "%";
                                    c =
session.createCriteria(MasStoreItem.class).add(Restrictions.like("Nomenclature",
str)).add(
                                                    Restrictions.eq("Group.Id", box.getInt("groupId")));
                            }
                    } else {
                            /*
                             * if (box.get("pvms") != null && box.getString("pvms").length()
                             * > 0) { pvms = box.getString("pvms"); c =
                             * session.createCriteria
                             * (MasStoreItem.class).add(Restrictions.like("PvmsNo",pvms)); }
                             * else { c = session.createCriteria(MasStoreItem.class);
                             * c.setFirstResult(0); c.setMaxResults(500); }
                             */
                            int itemId = 0;
                            if (box.getString("buttonName").equals("next")) {
                                    itemId = box.getInt("itemId");
                            } else {
                                    itemId = Integer.parseInt(box.getString("itemIdForNextRecord"));
                            }

                            c = session.createCriteria(MasStoreItem.class).add(        Restrictions.ge("Id",
itemId)).add(
                                            Restrictions.eq("Group.Id", box.getInt("groupId"))).addOrder(Order.asc("Id"));
                            c.setFirstResult(0);
                            c.setMaxResults(1000);
                            itemList = c.list();
                            String itemIdForNextRecord = Integer.toString(itemId);
                            map.put("itemIdForNextRecord", itemIdForNextRecord);

                    }

                    itemList = c.list();
            } catch (HibernateException e) {
                    e.printStackTrace();
            }

            for (Iterator iterator = itemList.iterator(); iterator.hasNext();) {
                    MasStoreItem masStoreItem = (MasStoreItem) iterator.next();
            //-----        for mmf quantity by dipali---
            try {
                    String currYearMmfSumQuery = "SELECT sum(curr_year_mmf) FROM store_mmf_department_t t,store_mmf_department_m m,mas_store_item s where "+
"t.store_mmf_department_m_id=m.id and t.item_id=s.item_id and m.mmf_for_the_year='"
                            + mmfYear
                            + "'"
                            + " and s.item_id ='"
                            + masStoreItem.getId()
                            + "' and m.mmf_store_type='" + mmfType + "'";
                    List objectCurrentYearList = new ArrayList();
                    objectCurrentYearList = (List) session.createSQLQuery(
                            currYearMmfSumQuery).list();
                    
                    if (objectCurrentYearList != null                        && objectCurrentYearList.size() > 0) {
                    if (objectCurrentYearList.get(0) != null) {
                            qtymmf = new BigDecimal("" + objectCurrentYearList.get(0));
                    }
                    } else {
                            qtymmf = new BigDecimal(0);
                    }
            } catch (HibernateException e1) {
                    e1.printStackTrace();
            }
    //--------End by Dipali for mmf Qty----
            
                    BigDecimal qtyInHand = null;
                    List<StoreItemBatchStock> storeItemBatchStockList = new
ArrayList<StoreItemBatchStock>();
                    String str = "select sum(inp.closing_stock) from store_item_batch_stock as inp where department_id = "
                                    + box.getInt("deptId")+ " and item_id = "+ masStoreItem.getId();
                    storeItemBatchStockList = session.createSQLQuery(str).list();
                    Iterator iterator1 = storeItemBatchStockList.iterator();
                    while (iterator1.hasNext()) {
                            qtyInHand = (BigDecimal) iterator1.next();
                    }

                    try {
                            pvms = masStoreItem.getPvmsNo();
                    } catch (Exception e) {
                            pvms = "";
                    }

                    try {
                            nomenclature = masStoreItem.getNomenclature();
                    } catch (Exception e) {
                            nomenclature = "";
                    }

                    try {
                            strength = masStoreItem.getStrength();
                    } catch (Exception e) {
                            strength = "";
                    }

                    try {
                            au = masStoreItem.getItemConversion().getPurchaseUnit()
                                            .getUnitName();
                    } catch (Exception e) {
                            au = "";
                    }

                    try {
                            disp_type = masStoreItem.getItemConversion().getIntermediateUnit().getUnitName();
                    } catch (Exception e) {
                            disp_type = "";
                    }

                    try {
                            item_id = masStoreItem.getId();
                    } catch (Exception e) {
                            item_id = 0;
                    }
                    if (masStoreItem.getGroup() != null) {
                            group_id = String.valueOf(masStoreItem.getGroup().getId());
                            
                    } else {
                            group_id = null;
                    }
                    if (!tenderTItems.contains(item_id)) {
                            boolean mmfzero = false;
                            if (qtymmf != null) {
                                    if (qtymmf.compareTo(new BigDecimal("0")) == 0) {
                                            mmfzero = true;
                                    }
                            } else {
                                    mmfzero = true;
                            }
                            hData = new HashMap<String, Object>();
                            hData.put(TENDER_ITEM_ID, item_id);
                            hData.put(TENDER_PVMS, pvms);
                            hData.put(TENDER_NOMENCLATURE, nomenclature);
                            hData.put(TENDER_STRENGTH, strength);
                            hData.put(TENDER_AU, au);
                            hData.put("disp_type", disp_type);
                            hData.put(TENDER_STOCK_IN_HAND, qtyInHand);
                            hData.put(TENDER_MMFQTY, qtymmf.intValue());
                            if (qtymmf != new BigDecimal(0) && qtymmf != null) {
                                    hData.put(TENDER_ANNREQ, new BigDecimal(2)
                                                    .multiply(qtymmf));
                            } else {
                                    hData.put(TENDER_ANNREQ, annreq);
                            }
                            hData.put("Item_group", group_id);
                            vResult.add(hData);
                    }
            }

            if (vResult.size() > 0) {
                    testPageData = new HashMap[vResult.size()];
                    vResult.copyInto(testPageData);
            }

            try {
                    pagedArray = new PageUtil().convertToPagedArrayIndex(testPageData,box);
            } catch (Exception e) {
                    e.printStackTrace();
            }
            map.put("pagedArray", pagedArray);
            map.put("groupId", box.getInt("groupId"));
            return map;
    
    }
	public Map<String, Object> doAddTenderItems(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		session = (Session) getSession();
		Vector items = box.getVector(TENDER_ITEM_ID);
		Vector qtymmf = box.getVector(TENDER_MMFQTY);
		Vector annreq = box.getVector(TENDER_ANNREQ);
		Vector items_to_be_added = box.getVector(ITEMS_TO_BE_ADDED);
		String tender_no = box.get(TENDER_NO);
		StoreTenderM storeTenderM = null;
		StoreTenderT storeTenderT = null;
		MasStoreItem masStoreItem = null;
		int sr_no = 0;
		try {
			List<StoreTenderM> storeTenderMList = new ArrayList<StoreTenderM>();
			List<StoreTenderT> storeTenderTList = new ArrayList<StoreTenderT>();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			storeTenderMList = hbt
					.find("from jkt.hms.masters.business.StoreTenderM as a where a.TenderNo ='"
							+ tender_no + "'");
			storeTenderTList = hbt
					.find("from jkt.hms.masters.business.StoreTenderT as b where b.TenderM.TenderNo ='"
							+ tender_no + "' order by b.SrNo desc");

			if (storeTenderMList.size() > 0) {
				storeTenderM = (StoreTenderM) storeTenderMList.get(0);
			}

			if (storeTenderTList.size() > 0) {
				sr_no = storeTenderTList.get(0).getSrNo().intValue();
			}

			for (int i = 0; i < items.size(); i++) {
				if (items_to_be_added.contains(items.get(i))) {
					masStoreItem = new MasStoreItem();
					masStoreItem
							.setId(Integer.valueOf(items.get(i).toString()));

					storeTenderT = new StoreTenderT();

					storeTenderT.setItem(masStoreItem);
					storeTenderT.setTenderM(storeTenderM);
					try {
						storeTenderT.setQtyInMmf(new BigDecimal(qtymmf.get(i)
								.toString()));
					} catch (Exception e) {
						storeTenderT.setQtyInMmf(new BigDecimal(0));
					}
					try {
						storeTenderT.setTenderQty(new BigDecimal(annreq.get(i)
								.toString()));
					} catch (Exception e) {
						storeTenderT.setTenderQty(new BigDecimal(0));
					}
					storeTenderT.setSrNo(++sr_no);
					hbt.save(storeTenderT);
				}
			}

			map.put("total_records", items.size());
			map.put("added_records", items_to_be_added.size());

			if (items.size() == items_to_be_added.size()) {
				if (box.getInt("currPage") > 1)
					box.put("currPage", box.getInt("currPage") - 1);
			}
			if (!box.getString("itemIdForNextRecord").equals("null")) {
				map = getItemDetailsForNextRecord(box);
			} else {
				map = getItemDetails(box);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> getInvitationForTenderDetails(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreGroup> masStoreGroupList = new ArrayList<MasStoreGroup>();
		List<StoreTenderInvitationLetter> storeTenderInvitationLetterList = new ArrayList<StoreTenderInvitationLetter>();
		List<StoreTenderM> storeTenderMList = new ArrayList<StoreTenderM>();
		List objectList = new ArrayList();
		int id = 0;

		session = (Session) getSession();

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			if (!box.getString("groupId").equals("")) {
				/*
				 * String query=
				 * "SELECT distinct m.group_id FROM mas_store_item m, store_tender_proposal t  where m.item_id = t.item_id and t.tender_id = "
				 * + box.get("tenderId"); objectList = (List)
				 * session.createSQLQuery(query).list(); if(objectList!=null &&
				 * objectList.size() > 0){ if(objectList.get(0) !=null){ id
				 * =Integer.parseInt(""+objectList.get(0)); }
				 */
				storeTenderMList = (List<StoreTenderM>) session.createCriteria(
						StoreTenderM.class).add(
						(Restrictions.eq("Group.Id", box.getInt("groupId"))))
						.list();

				/*
				 * masStoreGroupList = hbt.find(
				 * "select * from jkt.hms.masters.business.StoreTenderToSupplier inp where inp.Tender.Id="
				 * + box.get("tenderId"));
				 */
				// }
			} else {
				storeTenderMList = hbt
						.find("from jkt.hms.masters.business.StoreTenderM");
			}
			storeTenderInvitationLetterList = hbt
					.find("from jkt.hms.masters.business.StoreTenderInvitationLetter");
			masStoreGroupList = hbt
					.find("from jkt.hms.masters.business.MasStoreGroup");
			map.put("masStoreGroupList", masStoreGroupList);
			map.put("storeTenderInvitationLetterList",
					storeTenderInvitationLetterList);
			map.put("storeTenderMList", storeTenderMList);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> getInvitationTenderGridData(Box box) {

		Map<String, Object> map = new HashMap<String, Object>();
		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;
		Map statusData = new HashMap();
		MasStoreSupplierGroup masStoreSupplierGroup = new MasStoreSupplierGroup();
		List<StoreTenderInvitaLetterToVender> storeTenderInvitaletterToVenderList = new ArrayList<StoreTenderInvitaLetterToVender>();
		List<MasStoreSupplierGroup> masStoreSupplierGroupList = new ArrayList<MasStoreSupplierGroup>();
		Session session = (Session) getSession();
		int id = 0;
		String supplier_name = null;
		String supplier_address = null;
		String contact_no = null;
		String status = null;

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			masStoreSupplierGroupList = hbt
					.find("from jkt.hms.masters.business.MasStoreSupplierGroup as inp where inp.Group.Id="
							+ Integer.parseInt(box
									.getString(TENDER_SUPPLIER_GROUP_ID)));
			storeTenderInvitaletterToVenderList = hbt
					.find("from jkt.hms.masters.business.StoreTenderInvitaLetterToVender as inp where inp.Group.Id="
							+ box.getInt(TENDER_SUPPLIER_GROUP_ID)
							+ "and inp.TenderM.Id=" + box.getInt(TENDER_NO));
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		for (Iterator iterator = storeTenderInvitaletterToVenderList.iterator(); iterator
				.hasNext();) {
			StoreTenderInvitaLetterToVender storeTenderInvitaLetterToVender = (StoreTenderInvitaLetterToVender) iterator
					.next();
			statusData.put(storeTenderInvitaLetterToVender.getSupplier()
					.getId(), DateFormat.getDateInstance(DateFormat.MEDIUM)
					.format(storeTenderInvitaLetterToVender.getDate()));
		}

		for (Iterator iterator = masStoreSupplierGroupList.iterator(); iterator
				.hasNext();) {
			masStoreSupplierGroup = (MasStoreSupplierGroup) iterator.next();

			try {
				supplier_name = masStoreSupplierGroup.getSupplier()
						.getSupplierName();
			} catch (Exception e) {
				e.printStackTrace();
				supplier_name = "";
			}

			try {
				supplier_address = masStoreSupplierGroup.getSupplier()
						.getAddress1()
						+ " "
						+ masStoreSupplierGroup.getSupplier().getAddress2();
			} catch (Exception e) {
				supplier_address = "";
			}

			try {
				contact_no = masStoreSupplierGroup.getSupplier().getPhoneNo();
			} catch (Exception e) {
				contact_no = "";
			}

			try {
				id = masStoreSupplierGroup.getSupplier().getId();
				if (statusData.containsKey(id)) {
					status = "" + statusData.get(id);
				} else
					status = "";
			} catch (Exception e) {
				id = 0;
				status = "";
			}

			if (masStoreSupplierGroup.getSupplier().getStatus()
					.equalsIgnoreCase("Y")) {
				hData = new HashMap<String, Object>();
				hData.put(TENDER_VENDOR_SUPPLIER_ID, id);
				hData.put(TENDER_VENDOR_NAME, supplier_name);
				hData.put(TENDER_VENDOR_ADDRESS, supplier_address);
				hData.put(TENDER_VENDOR_CONTACT_NO, contact_no);
				hData.put(TENDER_VENDOR_INVITATION_STATUS, status);
				vResult.add(hData);
			}
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
		map = getInvitationForTenderDetails(box);
		map.put("pagedArray", pagedArray);
		return map;
	}

	public Map<String, Object> printInvitationLetter(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		StoreTenderInvitationLetter storeTenderInvitationLetter = null;
		MasStoreGroup masStoreGroup = null;
		StoreTenderM storeTenderM = null;
		List<StoreTenderM> storeTenderMList = new ArrayList<StoreTenderM>();
		List<StoreTenderInvitationLetter> storeTenderInvitationLetterList = new ArrayList<StoreTenderInvitationLetter>();
		StoreTenderInvitaLetterToVender storeTenderInvitaletterToVender = null;
		MasStoreSupplier masStoreSupplier = null;
		Transaction transaction = null;
		Session session = (Session) getSession();
		Vector tender_letters_to_be_sent = null;
		try {
			transaction = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			Vector supplier_id = box.getVector(TENDER_VENDOR_SUPPLIER_ID);
			tender_letters_to_be_sent = box
					.getVector(TENDER_LETTERS_TO_BE_SENT);

			String obj = null;
			int invitation_letter_id = box.getInt(TENDER_LETTER_NO);
			int tender_m_id = box.getInt(TENDER_NO);
			int group_id = box.getInt(TENDER_SUPPLIER_GROUP_ID);

			for (int i = 0; i < supplier_id.size(); i++) {
				if (tender_letters_to_be_sent.contains(supplier_id.get(i))) {
					storeTenderInvitationLetter = new StoreTenderInvitationLetter();
					storeTenderInvitationLetter.setId(invitation_letter_id);

					masStoreGroup = new MasStoreGroup();
					masStoreGroup.setId(group_id);

					masStoreSupplier = new MasStoreSupplier();
					masStoreSupplier.setId(Integer.parseInt(supplier_id.get(i)
							.toString()));

					storeTenderM = new StoreTenderM();
					storeTenderM.setId(tender_m_id);

					storeTenderInvitaletterToVender = new StoreTenderInvitaLetterToVender();

					storeTenderInvitaletterToVender
							.setInvitationLetter(storeTenderInvitationLetter);
					storeTenderInvitaletterToVender
							.setSupplier(masStoreSupplier);
					storeTenderInvitaletterToVender.setGroup(masStoreGroup);
					storeTenderInvitaletterToVender.setDate(HMSUtil
							.convertStringTypeDateToDateType(box.get("date")));
					storeTenderInvitaletterToVender.setTenderM(storeTenderM);
					hbt.save(storeTenderInvitaletterToVender);
				}
			}
			storeTenderM = new StoreTenderM();
			storeTenderMList = hbt
					.find("from jkt.hms.masters.business.StoreTenderM as inp where inp.Id="
							+ tender_m_id);
			if (storeTenderMList != null && storeTenderMList.size() > 0) {
				storeTenderM = (StoreTenderM) storeTenderMList.get(0);
				if (storeTenderM.getStatus().equalsIgnoreCase("O")) {
					storeTenderM.setStatus("P");
					hbt.update(storeTenderM);
				}
			}
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		}

		map = getInvitationTenderGridData(box);
		map.put("tender_letters_to_be_sent", tender_letters_to_be_sent);
		return map;
	}

	public Map<String, Object> addInvitationLetterDetails(Box box) {
		String action = box.getString("action");
		Map<String, Object> map = new HashMap<String, Object>();
		String message = null;
		StoreTenderInvitationLetter storeTenderInvitationLetter = new StoreTenderInvitationLetter();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			if (action.equals("A")) {
				storeTenderInvitationLetter.setFileNo(box
						.getString(TENDER_INVITATION_LETTER_FILE_NO));
				storeTenderInvitationLetter
						.setLetterDate(HMSUtil
								.convertStringTypeDateToDateType(box
										.getString(TENDER_INVITATION_LETTER_FILE_DATE)));
				storeTenderInvitationLetter.setSubject(box
						.getString(TENDER_INVITATION_LETTER_SUBJECT));
				storeTenderInvitationLetter.setContent(box
						.getString(TENDER_INVITATION_LETTER_CONTENT));
				hbt.save(storeTenderInvitationLetter);
				map.put("status", "success");
				map.put("message", "Invitation Letter Created Successfully");
			}
			if (action.equals("U")) {
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				storeTenderInvitationLetter = (StoreTenderInvitationLetter) hbt
						.load(StoreTenderInvitationLetter.class, box
								.getInt(TENDER_LETTER_NO));
				storeTenderInvitationLetter.setFileNo(box
						.getString(TENDER_INVITATION_LETTER_FILE_NO));
				storeTenderInvitationLetter
						.setLetterDate(HMSUtil
								.convertStringTypeDateToDateType(box
										.getString(TENDER_INVITATION_LETTER_FILE_DATE)));
				storeTenderInvitationLetter.setSubject(box
						.getString(TENDER_INVITATION_LETTER_SUBJECT));
				storeTenderInvitationLetter.setContent(box
						.getString(TENDER_INVITATION_LETTER_CONTENT));
				hbt.update(storeTenderInvitationLetter);
				map.put("status", "success");
				map.put("message", "Invitation Letter Updated Successfully");
			}

		} catch (HibernateException e) {
			e.printStackTrace();
			map.put("message",
					"Record Not Saved/Updated..... Please Try Again........");
		}
		return map;
	}

	public Map<String, Object> getLetterContents(Box box) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		String message = null;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			StoreTenderInvitationLetter storeTenderInvitationLetter = (StoreTenderInvitationLetter) hbt
					.load(StoreTenderInvitationLetter.class, box
							.getInt(TENDER_LETTER_NO));
			if (storeTenderInvitationLetter != null) {
				String dt = storeTenderInvitationLetter.getLetterDate()
						.toString();
				String converted_date = dt.substring(8) + "/"
						+ dt.substring(5, 7) + "/" + dt.substring(0, 4);
				map.put(TENDER_INVITATION_LETTER_FILE_NO,
						storeTenderInvitationLetter.getFileNo());
				map.put(TENDER_INVITATION_LETTER_FILE_DATE, converted_date);
				map.put(TENDER_INVITATION_LETTER_SUBJECT,
						storeTenderInvitationLetter.getSubject());
				map.put(TENDER_INVITATION_LETTER_CONTENT,
						storeTenderInvitationLetter.getContent());
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;
	}

	/*
	 * This method is user to evaluate auto generated number based on the year
	 * It takes one parameter that is coming from store_tender_m
	 */
	public String getMaxNo(String no) {
		String maxNo = "";
		String y1 = "";
		String y2 = "";
		String y3 = "";
		int tempMonth = 0;
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		int currentMonth = gregorianCalendar.get(Calendar.MONTH) + 1;
		String currentYear = "" + gregorianCalendar.get(Calendar.YEAR);
		try {

			if ((Integer.parseInt(currentYear.substring(2)) - 1) <= 9)
				y1 = "0" + (Integer.parseInt(currentYear.substring(2)) - 1);
			else
				y1 = "" + (Integer.parseInt(currentYear.substring(2)) - 1);

			if (Integer.parseInt(currentYear.substring(2)) <= 9)
				y2 = "0" + Integer.parseInt(currentYear.substring(2));
			else
				y2 = "" + Integer.parseInt(currentYear.substring(2));
			if ((Integer.parseInt(currentYear.substring(2)) + 1) <= 9)
				y3 = "0" + (Integer.parseInt(currentYear.substring(2)) + 1);
			else
				y3 = "" + (Integer.parseInt(currentYear.substring(2)) + 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (!no.equals("")) {
				StringTokenizer stringTokenizer = new StringTokenizer(no, "/");
				tempMonth = Integer.parseInt(stringTokenizer.nextToken());

				tempMonth++;

				if (currentMonth < 4) {

					maxNo = tempMonth + "/" + y1 + "-" + y2;
				} else {
					maxNo = tempMonth + "/" + y2 + "-" + y3;
				}

			} else {
				if (currentMonth < 4) {
					maxNo = "1" + "/" + y1 + "-" + y2;
				} else {
					maxNo = "1" + "/" + y2 + "-" + y3;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maxNo;
	}

	public Map<String, Object> getGroupAndTenderComboDetails(Box box) {
		// TODO Auto-generated method stub
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreGroup> masStoreGroupList = new ArrayList<MasStoreGroup>();
		List<StoreTenderM> storeTenderMList = new ArrayList<StoreTenderM>();
		List storeReTenderProposalList = new ArrayList();

		session = (Session) getSession();

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			if (!box.getString("groupId").equals("")) {
				storeTenderMList = (List<StoreTenderM>) session.createCriteria(
						StoreTenderM.class).add(
						(Restrictions.eq("Group.Id", box.getInt("groupId"))))
						.list();

				/*
				 * masStoreGroupList =hbt.find(
				 * "select distinct inp.Group from jkt.hms.masters.business.StoreTenderToSupplier inp where inp.Tender.Id="
				 * + box.get("tenderId"));
				 */
			} else {
				storeTenderMList = hbt
						.find("from jkt.hms.masters.business.StoreTenderM");
			}
			masStoreGroupList = hbt
					.find("from jkt.hms.masters.business.MasStoreGroup");
			storeReTenderProposalList = hbt
					.find("select distinct inp.ProposalId from jkt.hms.masters.business.StoreReTenderProposal as inp where Department.Id = '"
							+ box.get("dept")
							+ "' order by inp.ProposalId desc");

			map.put("masStoreGroupList", masStoreGroupList);
			map.put("storeTenderMList", storeTenderMList);
			map.put("storeReTenderProposalList", storeReTenderProposalList);

			// //System.out.println("masStore Group list:::::::"+masStoreGroupList.size());
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;

	}

	public Map<String, Object> showDocumentForTenderJspWithGridData(Box box) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;
		Map statusData = new HashMap();

		List<StoreTenderInvitaLetterToVender> storeTenderInvitaletterToVenderList = new ArrayList<StoreTenderInvitaLetterToVender>();
		List<StoreTenderToSupplier> storeTenderToSupplierList = new ArrayList<StoreTenderToSupplier>();
		List<MasStoreGroup> masStoreGroupList = new ArrayList<MasStoreGroup>();
		List<StoreTenderM> storeTenderMList = new ArrayList<StoreTenderM>();

		Session session = (Session) getSession();
		int id = 0;
		String supplier_name = null;
		String supplier_address = null;
		String contact_no = null;
		String invitation_status = null;
		String document_status = null;

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			storeTenderInvitaletterToVenderList = hbt
					.find("from jkt.hms.masters.business.StoreTenderInvitaLetterToVender as inp where inp.Group.Id="
							+ box.getInt(TENDER_SUPPLIER_GROUP_ID)
							+ " and inp.TenderM.Id="
							+ box.get(TENDER_NO)
							+ "order by inp.Supplier.Id");
			storeTenderToSupplierList = hbt
					.find("from jkt.hms.masters.business.StoreTenderToSupplier as inp where inp.Group.Id="
							+ box.getInt(TENDER_SUPPLIER_GROUP_ID)
							+ " and inp.Tender.Id=" + box.get(TENDER_NO));
			masStoreGroupList = hbt
					.find("from jkt.hms.masters.business.MasStoreGroup");
			storeTenderMList = hbt
					.find("from jkt.hms.masters.business.StoreTenderM");
			// map.put("masStoreGroupList", masStoreGroupList);
			// map.put("storeTenderMList", storeTenderMList);
			map.put("storeTenderInvitaletterToVenderList",
					storeTenderInvitaletterToVenderList);
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		for (Iterator iterator = storeTenderToSupplierList.iterator(); iterator
				.hasNext();) {
			StoreTenderToSupplier storeTenderToSupplier = (StoreTenderToSupplier) iterator
					.next();
			statusData.put(storeTenderToSupplier.getSupplier().getId(),
					DateFormat.getDateInstance(DateFormat.MEDIUM).format(
							storeTenderToSupplier.getDate()));
		}

		for (Iterator iterator = storeTenderInvitaletterToVenderList.iterator(); iterator
				.hasNext();) {
			StoreTenderInvitaLetterToVender storeTenderInvitaLetterToVender = (StoreTenderInvitaLetterToVender) iterator
					.next();

			try {
				supplier_name = storeTenderInvitaLetterToVender.getSupplier()
						.getSupplierName();
			} catch (Exception e) {
				e.printStackTrace();
				supplier_name = "";
			}

			try {
				supplier_address = storeTenderInvitaLetterToVender
						.getSupplier().getAddress1()
						+ " "
						+ storeTenderInvitaLetterToVender.getSupplier()
								.getAddress2();
			} catch (Exception e) {
				supplier_address = "";
			}

			try {
				contact_no = storeTenderInvitaLetterToVender.getSupplier()
						.getPhoneNo();
			} catch (Exception e) {
				contact_no = "";
			}

			try {
				invitation_status = DateFormat.getDateInstance(
						DateFormat.MEDIUM).format(
						storeTenderInvitaLetterToVender.getDate());
			} catch (Exception e) {
				invitation_status = "";
			}

			try {
				id = storeTenderInvitaLetterToVender.getSupplier().getId();
				if (statusData.containsKey(id)) {
					document_status = "" + statusData.get(id);
				} else
					document_status = "";
			} catch (Exception e) {
				id = 0;
				document_status = "";
			}

			hData = new HashMap<String, Object>();
			hData.put(TENDER_VENDOR_SUPPLIER_ID, id);
			hData.put(TENDER_VENDOR_NAME, supplier_name);
			hData.put(TENDER_VENDOR_ADDRESS, supplier_address);
			hData.put(TENDER_VENDOR_CONTACT_NO, contact_no);
			hData.put(TENDER_VENDOR_INVITATION_STATUS, invitation_status);
			hData.put(TENDER_VENDOR_DOCUMENT_STATUS, document_status);

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
		map = getDocumentForTenderDetails(box);
		map.put("pagedArray", pagedArray);
		return map;
	}

	public Map<String, Object> printTenderDocument(Box box) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		StoreTenderInvitationLetter storeTenderInvitationLetter = null;
		StoreTenderToSupplier storeTenderToSupplier = null;
		MasStoreGroup masStoreGroup = null;
		StoreTenderM storeTenderM = null;
		List<StoreTenderM> storeTenderMList = new ArrayList<StoreTenderM>();
		StoreTenderInvitaLetterToVender storeTenderInvitaletterToVender = null;
		MasStoreSupplier masStoreSupplier = null;
		Vector tender_letters_to_be_sent = null;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Vector supplier_id = box.getVector(TENDER_VENDOR_SUPPLIER_ID);
			tender_letters_to_be_sent = box
					.getVector(TENDER_LETTERS_TO_BE_SENT);
			int tender_m_id = box.getInt(TENDER_NO);
			int group_id = box.getInt(TENDER_SUPPLIER_GROUP_ID);

			for (int i = 0; i < supplier_id.size(); i++) {
				if (tender_letters_to_be_sent.contains(supplier_id.get(i))) {
					masStoreGroup = new MasStoreGroup();
					masStoreGroup.setId(group_id);

					masStoreSupplier = new MasStoreSupplier();
					masStoreSupplier.setId(Integer.parseInt(supplier_id.get(i)
							.toString()));

					storeTenderM = new StoreTenderM();
					storeTenderM.setId(tender_m_id);

					storeTenderToSupplier = new StoreTenderToSupplier();

					storeTenderToSupplier.setGroup(masStoreGroup);
					storeTenderToSupplier.setSupplier(masStoreSupplier);
					storeTenderToSupplier.setTender(storeTenderM);
					storeTenderToSupplier.setDate(HMSUtil
							.convertStringTypeDateToDateType(box.get("date")));
					hbt.save(storeTenderToSupplier);
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map = showDocumentForTenderJspWithGridData(box);
		map.put("tender_letters_to_be_sent", tender_letters_to_be_sent);
		return map;
	}

	public Map<String, Object> showInvitationLetterReport(Box box) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		StoreTenderInvitationLetter storeTenderInvitationLetter = null;
		MasStoreGroup masStoreGroup = null;
		StoreTenderM storeTenderM = null;
		List<StoreTenderM> storeTenderMList = new ArrayList<StoreTenderM>();
		List<StoreTenderInvitationLetter> storeTenderInvitationLetterList = new ArrayList<StoreTenderInvitationLetter>();
		StoreTenderInvitaLetterToVender storeTenderInvitaletterToVender = null;
		MasStoreSupplier masStoreSupplier = null;
		Session session = (Session) getSession();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			int invitation_letter_id = box.getInt(TENDER_LETTER_NO);
			int tender_m_id = box.getInt(TENDER_NO);
			int group_id = box.getInt(TENDER_SUPPLIER_GROUP_ID);

			storeTenderInvitationLetterList = hbt
					.find("from jkt.hms.masters.business.StoreTenderInvitationLetter as inp where inp.Id = "
							+ invitation_letter_id);
			if (storeTenderInvitationLetterList != null
					&& storeTenderInvitationLetterList.size() > 0) {
				storeTenderInvitationLetter = storeTenderInvitationLetterList
						.get(0);
				map.put("File_No", storeTenderInvitationLetter.getFileNo());
				map.put("Letter_date", DateFormat.getDateInstance(
						DateFormat.MEDIUM).format(
						storeTenderInvitationLetter.getLetterDate()));
				map.put("Subject", storeTenderInvitationLetter.getSubject());
				map.put("content", storeTenderInvitationLetter.getContent());
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		Connection con = session.connection();
		map.put("conn", con);
		List l = new ArrayList();
		StringTokenizer st = new StringTokenizer(box.getString("supplier_ids"),
				",");
		while (st.hasMoreElements()) {
			String token = st.nextToken();
			l.add(token);
		}
		map.put("supplier_ids", l);
		return map;
	}

	public Map<String, Object> printTenderDocumentReport(Box box) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();

		List<StoreTenderM> storeTenderMList = new ArrayList<StoreTenderM>();

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			Connection con = session.connection();
			List l = new ArrayList();
			StringTokenizer st = new StringTokenizer(box
					.getString("supplier_ids"), ",");
			while (st.hasMoreElements()) {
				String token = st.nextToken();
				l.add(token);
			}
			map.put("supplier_ids", l);
			map.put("conn", con);

			storeTenderMList = hbt
					.find("from jkt.hms.masters.business.StoreTenderM as inp where inp.Id = "
							+ box.getInt(TENDER_NO));
			if (storeTenderMList != null && storeTenderMList.size() > 0) {
				map.put("tender_date", storeTenderMList.get(0)
						.getTenderInvitationDate());
				map.put("issue_commence_date", storeTenderMList.get(0)
						.getCommOfIssueDate());
				map.put("issue_last_date", storeTenderMList.get(0)
						.getIssueLastDate());
				map
						.put("time_place_receipt", storeTenderMList.get(0)
								.getTenderReceiptTime()
								+ ","
								+ storeTenderMList.get(0)
										.getTenderReceiptPlace());
				map.put("last_date_receipt", storeTenderMList.get(0)
						.getTenderRecLastDate());
				map.put("technical_date", storeTenderMList.get(0)
						.getTechnicalOpeningDate());
				map.put("commercial_date", storeTenderMList.get(0)
						.getCommercialOpeningDate());
				map.put("tender_no", storeTenderMList.get(0).getTenderNo());
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> createScheduleSoftCopy(Box box) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<StoreTenderT> storeTenderTList = new ArrayList<StoreTenderT>();
		List<StoreTenderToSupplier> storeTenderToSupplierList = new ArrayList<StoreTenderToSupplier>();
		String grp_name = null;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			storeTenderToSupplierList = hbt
					.find("from jkt.hms.masters.business.StoreTenderToSupplier as inp where inp.Tender.Id = "
							+ box.getInt(TENDER_NO)
							+ " and inp.Group.Id = "
							+ box.getInt(TENDER_SUPPLIER_GROUP_ID));
			storeTenderTList = hbt
					.find("from jkt.hms.masters.business.StoreTenderT as inp where inp.TenderM.Id = "
							+ box.getInt(TENDER_NO)
							+ " and inp.Item.Group.Id = "
							+ box.getInt(TENDER_SUPPLIER_GROUP_ID));
			if (storeTenderToSupplierList != null
					&& storeTenderToSupplierList.size() > 0
					&& storeTenderTList != null && storeTenderTList.size() > 0) {
				try {
					grp_name = storeTenderToSupplierList.get(0).getGroup()
							.getGroupCode()
							+ "_Tender_"
							+ storeTenderToSupplierList.get(0).getTender()
									.getId();
					byte[] buffer = new byte[18024];
					grp_name = grp_name + ".zip";
					ZipOutputStream out = new ZipOutputStream(
							new FileOutputStream(grp_name));
					out.setLevel(Deflater.DEFAULT_COMPRESSION);
					for (Iterator itr = storeTenderToSupplierList.iterator(); itr
							.hasNext();) {
						StoreTenderToSupplier storeTenderToSupplier = (StoreTenderToSupplier) itr
								.next();

						HSSFWorkbook wb = new HSSFWorkbook();
						/*
						 * HSSFSheet sheet =
						 * wb.createSheet(storeTenderToSupplier
						 * .getGroup().getGroupCode());
						 */
						HSSFSheet sheet = wb.createSheet("Tender");
						// Create a new font and alter it.
						HSSFFont font = wb.createFont();
						font.setFontHeightInPoints((short) 10);
						font.setFontName(HSSFFont.FONT_ARIAL);
						font.setColor((short) 62);
						font.setItalic(false);
						font.setStrikeout(false);
						font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

						HSSFFont font1 = wb.createFont();
						font1.setFontHeightInPoints((short) 10);
						font1.setFontName(HSSFFont.FONT_ARIAL);
						font1.setColor((short) 80);
						font1.setItalic(false);
						font1.setStrikeout(false);
						font1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

						// Fonts are set into a style so create a new one to
						// use.
						HSSFCellStyle style = wb.createCellStyle();
						style.setFont(font);

						HSSFCellStyle style1 = wb.createCellStyle();
						style1.setFont(font1);
						style1.setLocked(true);

						/*
						 * HSSFRow row0 = sheet.createRow((short)0); HSSFCell
						 * cell027 = row0.createCell((short)27);
						 * cell027.setCellValue("Bottle of (gm)"); HSSFCell
						 * cell028 = row0.createCell((short)28);
						 * cell028.setCellValue("Bottle of (ml)"); HSSFCell
						 * cell029 = row0.createCell((short)29);
						 * cell029.setCellValue("Each"); HSSFCell cell030 =
						 * row0.createCell((short)30); cell030.setCellValue("Jar
						 * of (gm)"); HSSFCell cell031 =
						 * row0.createCell((short)31); cell031.setCellValue("Kit
						 * of (Tests)"); HSSFCell cell032 =
						 * row0.createCell((short)32);
						 * cell032.setCellValue("No"); HSSFCell cell033 =
						 * row0.createCell((short)33);
						 * cell033.setCellValue("Pack of (No)"); HSSFCell
						 * cell034 = row0.createCell((short)34);
						 * cell034.setCellValue("Reel of (Mtr)"); HSSFCell
						 * cell035 = row0.createCell((short)35);
						 * cell035.setCellValue("Strip of (No)"); HSSFCell
						 * cell036 = row0.createCell((short)36);
						 * cell036.setCellValue("Tests"); HSSFCell cell037 =
						 * row0.createCell((short)37);
						 * cell037.setCellValue("Tube of (gm)");
						 */

						HSSFRow row1 = sheet.createRow((short) 1);
						// Create a cell and put a value in it.
						HSSFCell cell10 = row1.createCell((short) 0);
						cell10.setCellValue("Supplier Code:");
						cell10.setCellStyle(style1);
						HSSFCell cell13 = row1.createCell((short) 2);
						cell13.setCellValue(storeTenderToSupplier.getSupplier()
								.getSupplierCode());
						cell13.setCellStyle(style1);

						sheet.addMergedRegion(new Region(1, (short) 0, 1,
								(short) 1));

						HSSFRow row2 = sheet.createRow((short) 2);
						// Create a cell and put a value in it.
						HSSFCell cell20 = row2.createCell((short) 0);
						cell20.setCellValue("Supplier Name:");
						cell20.setCellStyle(style1);
						HSSFCell cell23 = row2.createCell((short) 2);
						cell23.setCellValue(storeTenderToSupplier.getSupplier()
								.getSupplierName());
						cell23.setCellStyle(style1);

						HSSFRow row3 = sheet.createRow((short) 3);
						// Create a cell and put a value in it.
						HSSFCell cell30 = row3.createCell((short) 0);
						cell30.setCellValue("Tender No:");
						cell30.setCellStyle(style1);
						HSSFCell cell33 = row3.createCell((short) 2);
						cell33.setCellValue(storeTenderToSupplier.getTender()
								.getTenderNo());
						cell33.setCellStyle(style1);

						HSSFRow row4 = sheet.createRow((short) 4);
						// Create a cell and put a value in it.
						HSSFCell cell40 = row4.createCell((short) 0);
						cell40.setCellValue("Group :");
						cell40.setCellStyle(style1);
						HSSFCell cell43 = row4.createCell((short) 2);
						cell43.setCellValue(storeTenderToSupplier.getGroup()
								.getGroupName());
						cell43.setCellStyle(style1);

						// Create a row and put some cells in it. Rows are 0
						// based.
						HSSFRow headingRow = sheet.createRow((short) 6);
						// Create a cell and put a value in it.
						HSSFCell cell50 = headingRow.createCell((short) 0);
						cell50.setCellValue("Sl No");
						cell50.setCellStyle(style);
						HSSFCell cell51 = headingRow.createCell((short) 1);
						cell51.setCellValue("PVMS No");
						cell51.setCellStyle(style);
						HSSFCell cell52 = headingRow.createCell((short) 2);
						cell52.setCellValue("Generic Name");
						cell52.setCellStyle(style);
						/*
						 * HSSFCell cell53 = headingRow.createCell((short)3);
						 * cell53.setCellValue("Strength");
						 * cell53.setCellStyle(style);
						 */
						HSSFCell cell53 = headingRow.createCell((short) 3);
						cell53.setCellValue("A/U");
						cell53.setCellStyle(style);
						HSSFCell cell531 = headingRow.createCell((short) 4);
						cell531.setCellValue("Tender Qty");
						cell531.setCellStyle(style);
						HSSFCell cell54 = headingRow.createCell((short) 5);
						cell54.setCellValue("Brand");
						cell54.setCellStyle(style);
						HSSFCell cell55 = headingRow.createCell((short) 6);
						cell55.setCellValue("Manufacturer");
						cell55.setCellStyle(style);
						HSSFCell cell56 = headingRow.createCell((short) 7);
						cell56.setCellValue("Composition with measure/size");
						cell56.setCellStyle(style);
						HSSFCell cell57 = headingRow.createCell((short) 8);
						cell57.setCellValue("Dispensable Type");
						cell57.setCellStyle(style);
						HSSFCell cell58 = headingRow.createCell((short) 9);
						cell58.setCellValue("MDQ*");
						cell58.setCellStyle(style);
						HSSFCell cell59 = headingRow.createCell((short) 10);
						cell59.setCellValue("No. of Items Submitted");
						cell59.setCellStyle(style);
						HSSFCell cell510 = headingRow.createCell((short) 11);
						cell510.setCellValue("Tax in %");
						cell510.setCellStyle(style);
						HSSFCell cell511 = headingRow.createCell((short) 12);
						cell511.setCellValue("Rs. in Figures (Per MDQ)");
						cell511.setCellStyle(style);
						HSSFCell cell512 = headingRow.createCell((short) 13);
						cell512.setCellValue("Tax Amount(Per MDQ)");
						cell512.setCellStyle(style);
						HSSFCell cell513 = headingRow.createCell((short) 14);
						cell513.setCellValue("Total Rate Per MDQ(Incl. Taxes)");
						cell513.setCellStyle(style);
						HSSFCell cell514 = headingRow.createCell((short) 15);
						cell514.setCellValue("MRP in Figures (Per MDQ)");
						cell514.setCellStyle(style);

						int row = 7;
						int slno = 0;
						for (Iterator iterator = storeTenderTList.iterator(); iterator
								.hasNext();) {
							StoreTenderT storeTenderT = (StoreTenderT) iterator
									.next();
							String pvms = "";
							String nomenclature = "";
							String strength = "";
							String disp_type = "";
							String au = "";
							BigDecimal tender_qty = new BigDecimal(0);
							try {
								nomenclature = storeTenderT.getItem()
										.getNomenclature();
							} catch (Exception e) {
								nomenclature = "";
							}

							try {
								pvms = storeTenderT.getItem().getPvmsNo();
							} catch (Exception e) {
								pvms = "";
							}

							try {
								tender_qty = storeTenderT.getTenderQty();
							} catch (Exception e) {
								tender_qty = new BigDecimal(0);
							}

							try {
								strength = storeTenderT.getItem().getStrength();
							} catch (Exception e) {
								strength = "";
							}

							try {
								au = storeTenderT.getItem().getItemConversion()
										.getPurchaseUnit().getUnitName();
							} catch (Exception e) {
								au = "";
							}

							try {
								disp_type = storeTenderT.getItem()
										.getItemConversion()
										.getIntermediateUnit().getUnitName();
							} catch (Exception e) {
								disp_type = "";
							}

							sheet.createRow((short) row).createCell((short) 0)
									.setCellValue(++slno);
							sheet.createRow((short) row).createCell((short) 1)
									.setCellValue(pvms);
							sheet.createRow((short) row).createCell((short) 2)
									.setCellValue(nomenclature);
							sheet.createRow((short) row).createCell((short) 3)
									.setCellValue(au);
							sheet.createRow((short) row).createCell((short) 4)
									.setCellValue(tender_qty.doubleValue());
							sheet.createRow((short) row).createCell((short) 5)
									.setCellValue("");
							sheet.createRow((short) row).createCell((short) 6)
									.setCellValue("");

							/*
							 * short rowIx = (short)row; short colIx = 7;
							 * HSSFDataValidation data_validation = new
							 * HSSFDataValidation(rowIx, colIx,rowIx,colIx);
							 * data_validation
							 * .setDataValidationType(HSSFDataValidation
							 * .DATA_TYPE_LIST);
							 * data_validation.setFirstFormula("$AA$1:$AK$1");
							 * data_validation.setSecondFormula(null);
							 * data_validation.setSurppressDropDownArrow(false);
							 * data_validation.setShowPromptBox(false);
							 * data_validation.setShowErrorBox(false);
							 * sheet.addValidationData(data_validation);
							 */
							sheet.createRow((short) row).createCell((short) 7)
									.setCellValue("");
							sheet.createRow((short) row).createCell((short) 8)
									.setCellValue(disp_type);
							sheet.createRow((short) row).createCell((short) 9)
									.setCellValue("");
							sheet.createRow((short) row).createCell((short) 10)
									.setCellValue("");
							sheet.createRow((short) row).createCell((short) 11)
									.setCellValue("");
							sheet.createRow((short) row).createCell((short) 12)
									.setCellValue("");
							sheet.createRow((short) row).createCell((short) 13)
									.setCellValue("");
							sheet.createRow((short) row).createCell((short) 14)
									.setCellValue("");
							sheet.createRow((short) row).createCell((short) 15)
									.setCellValue("");

							sheet.setColumnWidth((short) 0, (short) (6 * 256));
							sheet.setColumnWidth((short) 1, (short) (11 * 256));
							sheet.setColumnWidth((short) 2, (short) (60 * 256));
							sheet.setColumnWidth((short) 3, (short) (15 * 256));
							sheet.setColumnWidth((short) 4, (short) (15 * 256));
							sheet.setColumnWidth((short) 5, (short) (15 * 256));
							sheet.setColumnWidth((short) 6, (short) (25 * 256));
							sheet.setColumnWidth((short) 7, (short) (20 * 256));
							sheet.setColumnWidth((short) 8, (short) (25 * 256));
							sheet.setColumnWidth((short) 9, (short) (10 * 256));
							sheet
									.setColumnWidth((short) 10,
											(short) (23 * 256));
							sheet
									.setColumnWidth((short) 11,
											(short) (10 * 256));
							sheet
									.setColumnWidth((short) 12,
											(short) (23 * 256));
							sheet
									.setColumnWidth((short) 13,
											(short) (25 * 256));
							sheet
									.setColumnWidth((short) 14,
											(short) (25 * 256));
							sheet
									.setColumnWidth((short) 15,
											(short) (30 * 256));
							row++;
						}
						// Write the output to a file
						FileOutputStream fileOut = new FileOutputStream(
								storeTenderToSupplier.getSupplier()
										.getSupplierCode()
										+ "_"
										+ storeTenderToSupplier.getSupplier()
												.getId()
										+ "_"
										+ storeTenderToSupplier.getTender()
												.getId()
										+ "_"
										+ storeTenderToSupplier.getGroup()
												.getGroupCode() + ".xls");
						wb.write(fileOut);
						fileOut.close();
						FileInputStream in = new FileInputStream(
								storeTenderToSupplier.getSupplier()
										.getSupplierCode()
										+ "_"
										+ storeTenderToSupplier.getSupplier()
												.getId()
										+ "_"
										+ storeTenderToSupplier.getTender()
												.getId()
										+ "_"
										+ storeTenderToSupplier.getGroup()
												.getGroupCode() + ".xls");
						out.putNextEntry(new ZipEntry(storeTenderToSupplier
								.getSupplier().getSupplierCode()
								+ "_"
								+ storeTenderToSupplier.getSupplier().getId()
								+ "_"
								+ storeTenderToSupplier.getTender().getId()
								+ "_"
								+ storeTenderToSupplier.getGroup()
										.getGroupCode() + ".xls"));
						int len;
						while ((len = in.read(buffer)) > 0) {
							out.write(buffer, 0, len);
						}
						out.closeEntry();
						in.close();
						File f = new File(storeTenderToSupplier.getSupplier()
								.getSupplierCode()
								+ "_"
								+ storeTenderToSupplier.getSupplier().getId()
								+ "_"
								+ storeTenderToSupplier.getTender().getId()
								+ "_"
								+ storeTenderToSupplier.getGroup()
										.getGroupCode() + ".xls");
						if (f.exists())
							f.delete();

					} // end of for loop storeTenderToSupplierList
					out.close();
					map = getGroupAndTenderComboDetails(box);
					map.put("flag", "DataFound");
					map.put("download_path", grp_name);
				} catch (IOException ioe) {
					ioe.printStackTrace();
					map = getGroupAndTenderComboDetails(box);
					map.put("flag", "NoData");
				}
			} else {
				map = getGroupAndTenderComboDetails(box);
				map.put("flag", "NoData");
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			map = getGroupAndTenderComboDetails(box);
			map.put("flag", "NoData");
		}
		return map;
	}

	public Map<String, Object> getGroupAndTenderAndSupplierComboDetails(Box box) {
		// TODO Auto-generated method stub
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreGroup> masStoreGroupList = new ArrayList<MasStoreGroup>();
		List<StoreTenderM> storeTenderMList = new ArrayList<StoreTenderM>();
		List<MasStoreSupplier> masStoreSupplierList = new ArrayList<MasStoreSupplier>();

		session = (Session) getSession();

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			if (!box.getString(TENDER_NO).equals("")
					&& !box.getString(TENDER_SUPPLIER_GROUP_ID).equals("")) {
				masStoreSupplierList = hbt
						.find("select distinct inp.Supplier from jkt.hms.masters.business.StoreTenderTechnicalBidM inp where inp.Tender.Id="
								+ box.get(TENDER_NO)
								+ " and inp.Group.Id = "
								+ box.get(TENDER_SUPPLIER_GROUP_ID));
				masStoreGroupList = hbt
						.find("from jkt.hms.masters.business.MasStoreGroup");

				storeTenderMList = (List<StoreTenderM>) session.createCriteria(
						StoreTenderM.class).add(
						(Restrictions.eq("Group.Id", box
								.getInt(TENDER_SUPPLIER_GROUP_ID)))).list();
				map.put("masStoreSupplierList", masStoreSupplierList);
				map.put("masStoreGroupList", masStoreGroupList);
				map.put("storeTenderMList", storeTenderMList);
			} else if (!box.getString(TENDER_SUPPLIER_GROUP_ID).equals("")) {
				storeTenderMList = (List<StoreTenderM>) session.createCriteria(
						StoreTenderM.class).add(
						(Restrictions.eq("Group.Id", box
								.getInt(TENDER_SUPPLIER_GROUP_ID)))).list();

				masStoreGroupList = hbt
						.find("from jkt.hms.masters.business.MasStoreGroup");
				map.put("masStoreGroupList", masStoreGroupList);
				map.put("storeTenderMList", storeTenderMList);
			} else {

				masStoreGroupList = hbt
						.find("from jkt.hms.masters.business.MasStoreGroup");

				map.put("masStoreGroupList", masStoreGroupList);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> getTenderTechnicalBidGrid(Box box) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;
		List<StoreTenderTechnicalBidM> storeTenderTechnicalBidMList = new ArrayList<StoreTenderTechnicalBidM>();
		List<StoreTenderTechnicalBidT> storeTenderTechnicalBidTList = new ArrayList<StoreTenderTechnicalBidT>();
		List<StoreTenderCommBidM> storeTenderCommBidMList = new ArrayList<StoreTenderCommBidM>();
		List<StoreTenderCommBidT> storeTenderCommBidTList = new ArrayList<StoreTenderCommBidT>();
		String pvms = null;
		String nomenclature = null;
		String strength = null;
		String brandname = null;
		String disp_type = null;
		String manuf_name = null;
		String au = null;
		int item_id = 0;
		int no_of_items_submitted = 0;
		String manufacturer_lab_practice = "";
		String standing_certificate = "";
		String no_conviction_issued = "";
		String manufacturer_licence = "";
		String certificate_to_market = "";
		String qualified = "";
		String remarks = "";
		String status = "O";
		String composition = "";
		BigDecimal ratePerMdq = null;
		BigDecimal mdq = new BigDecimal(0);

		Session session = (Session) getSession();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			int tender_id = box.getInt(TENDER_NO);
			int group_id = box.getInt(TENDER_SUPPLIER_GROUP_ID);
			int supplier_id = box.getInt(TENDER_VENDOR_SUPPLIER_ID);

			Criteria c = session.createCriteria(StoreTenderTechnicalBidM.class)
					.add(Restrictions.eq("Tender.Id", tender_id)).add(
							Restrictions.eq("Group.Id", group_id)).add(
							Restrictions.eq("Supplier.Id", supplier_id));
			storeTenderTechnicalBidMList = c.list();

			if (storeTenderTechnicalBidMList != null
					&& storeTenderTechnicalBidMList.size() > 0) {
				manufacturer_lab_practice = storeTenderTechnicalBidMList.get(0)
						.getGoodManufLabPractice();
				standing_certificate = storeTenderTechnicalBidMList.get(0)
						.getMarketStandingCertificate();
				no_conviction_issued = storeTenderTechnicalBidMList.get(0)
						.getNoConvictionIssued();
				status = storeTenderTechnicalBidMList.get(0).getStatus();

				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				StoreTenderTechnicalBidM storeTenderTechnicalBidM = (StoreTenderTechnicalBidM) storeTenderTechnicalBidMList
						.get(0);

				if (box.getString("pvmsNo").length() > 0) {
					String strForPvms = box.getString("pvmsNo");
					//System.out.println("value of strForPvms in ds layer------"+ strForPvms);
					strForPvms = strForPvms.replace(" ", "%") + "%";
					c = session.createCriteria(StoreTenderTechnicalBidT.class)
							.createAlias("Item", "item").add(
									Restrictions
											.like("item.PvmsNo", strForPvms))
							.add(
									Restrictions.eq("TechBidM.Id",
											storeTenderTechnicalBidMList.get(0)
													.getId()));
					storeTenderTechnicalBidTList = c.list();

				} else {
					c = session.createCriteria(StoreTenderTechnicalBidT.class)
							.add(
									Restrictions.eq("TechBidM.Id",
											storeTenderTechnicalBidMList.get(0)
													.getId()));
					storeTenderTechnicalBidTList = c.list();
				}
				for (Iterator iterator = storeTenderTechnicalBidTList
						.iterator(); iterator.hasNext();) {
					StoreTenderTechnicalBidT storeTenderTechnicalBidT = (StoreTenderTechnicalBidT) iterator
							.next();

					c = session.createCriteria(StoreTenderCommBidM.class).add(
							Restrictions.eq("Tender.Id", tender_id)).add(
							Restrictions.eq("Group.Id", group_id)).add(
							Restrictions.eq("Item.Id", storeTenderTechnicalBidT
									.getItem().getId()));
					storeTenderCommBidMList = c.list();

					if (storeTenderCommBidMList != null
							&& storeTenderCommBidMList.size() > 0) {
						c = session.createCriteria(StoreTenderCommBidT.class)
								.add(
										Restrictions.eq("CommBid.Id",
												storeTenderCommBidMList.get(0)
														.getId())).add(
										Restrictions.eq("Supplier.Id",
												supplier_id));
						storeTenderCommBidTList = c.list();

						try {
							ratePerMdq = storeTenderCommBidTList.get(0)
									.getRatePerMdq();
						} catch (Exception e) {
							ratePerMdq = new BigDecimal(0);
						}
					}

					try {
						pvms = storeTenderTechnicalBidT.getItem().getPvmsNo();
					} catch (Exception e) {
						pvms = "";
					}

					try {
						nomenclature = storeTenderTechnicalBidT.getItem()
								.getNomenclature();
					} catch (Exception e) {
						nomenclature = "";
					}

					try {
						strength = storeTenderTechnicalBidT.getItem()
								.getStrength();
					} catch (Exception e) {
						strength = "";
					}

					try {
						au = storeTenderTechnicalBidT.getItem()
								.getItemConversion().getPurchaseUnit()
								.getUnitName();
					} catch (Exception e) {
						au = "";
					}

					try {
						disp_type = storeTenderTechnicalBidT.getDispType();
					} catch (Exception e) {
						disp_type = "";
					}

					try {
						brandname = storeTenderTechnicalBidT.getBrandName();
					} catch (Exception e) {
						brandname = "";
					}

					try {
						manuf_name = storeTenderTechnicalBidT
								.getManufacturerName();
					} catch (Exception e) {
						manuf_name = "";
					}

					try {
						item_id = storeTenderTechnicalBidT.getItem().getId();
					} catch (Exception e) {
						item_id = 0;
					}

					try {
						manufacturer_licence = storeTenderTechnicalBidT
								.getManufacturerLicence();
					} catch (Exception e) {
						manufacturer_licence = "";
					}

					try {
						certificate_to_market = storeTenderTechnicalBidT
								.getCertificateToMarketProduct();
					} catch (Exception e) {
						certificate_to_market = "";
					}

					try {
						mdq = storeTenderTechnicalBidT.getMdqValue();
					} catch (Exception e) {
						mdq = new BigDecimal(0);
					}

					try {
						no_of_items_submitted = storeTenderTechnicalBidT
								.getNoOfItemSubmitted();
					} catch (Exception e) {
						no_of_items_submitted = 0;
					}

					try {
						qualified = storeTenderTechnicalBidT.getQualified();
					} catch (Exception e) {
						qualified = "";
					}

					try {
						remarks = storeTenderTechnicalBidT.getRemarks();
					} catch (Exception e) {
						remarks = "";
					}

					try {
						composition = storeTenderTechnicalBidT.getComposition();
					} catch (Exception e) {
						composition = "";
					}

					hData = new HashMap<String, Object>();
					hData.put(TENDER_TB_ITEM_ID, item_id);
					hData.put(TENDER_TB_PVMS, pvms);
					hData.put(TENDER_TB_NOMENCLATURE, nomenclature);
					hData.put(TENDER_TB_STRENGTH, strength);
					hData.put(TENDER_TB_BRAND, brandname);
					hData.put(TENDER_TB_DISP_TYPE, disp_type);
					hData.put(TENDER_TB_MANUFACTURER_NAME, manuf_name);
					hData.put(TENDER_TB_AU, au);
					hData.put(TENDER_TB_MANUFACTURE_LICENCE,
							manufacturer_licence);
					hData.put(TENDER_TB_CERTIFICATE_TO_MARKET_PRODUCT,
							certificate_to_market);
					hData.put(TENDER_TB_MDQ, mdq);
					hData.put(TENDER_TB_NO_OF_ITEMS, no_of_items_submitted);
					hData.put(TENDER_TB_DISQUALIFIED, qualified);
					hData.put(TENDER_TB_REMARKS, remarks);
					hData.put(TENDER_TB_REMARKS, remarks);
					hData.put(TENDER_CB_RATE_PER_MDQ, ratePerMdq);
					hData.put("composition", composition);

					vResult.add(hData);
				} // for ends here
			} // if ends here
		} // try ends here
		catch (HibernateException e) {
			e.printStackTrace();
		}

		if (vResult.size() > 0) {
			testPageData = new HashMap[vResult.size()];
			vResult.copyInto(testPageData);

			try {

				pagedArray = new PageUtil().convertToPagedArrayIndex(
						testPageData, box);

			}

			catch (Exception e) {
				e.printStackTrace();
			}
		}
		map = getGroupAndTenderAndSupplierComboDetails(box);
		map.put("pagedArray", pagedArray);
		map.put(TENDER_TB_GOOD_MANUF_LABORATORY_PRACTICES,
				manufacturer_lab_practice);
		map.put(TENDER_TB_MARKET_STANDING_CERTIFICATE, standing_certificate);
		map.put(TENDER_TB_NO_CONVICTION_CERTIFICATE, no_conviction_issued);
		map.put("status", status);
		return map;
	}

	public Map<String, Object> updateTechnicalBidGridItems(Box box) {
		List<StoreTenderTechnicalBidM> storeTenderTechnicalBidMList = new ArrayList<StoreTenderTechnicalBidM>();
		List<StoreTenderTechnicalBidT> storeTenderTechnicalBidTList = new ArrayList<StoreTenderTechnicalBidT>();
		List<StoreTenderCommBidM> storeTenderCommBidMList = new ArrayList<StoreTenderCommBidM>();
		List<StoreTenderCommBidT> storeTenderCommBidTList = new ArrayList<StoreTenderCommBidT>();
		Map<String, Object> map = new HashMap<String, Object>();
		StoreTenderTechnicalBidM storeTenderTechnicalBidM = new StoreTenderTechnicalBidM();
		StoreTenderTechnicalBidT storeTenderTechnicalBidT = new StoreTenderTechnicalBidT();
		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;
		int tb_master_id = 0;
		String pvms = null;
		String nomenclature = null;
		String strength = null;
		String brandname = null;
		String disp_type = null;
		String manuf_name = null;
		String au = null;
		String manufacturer_lab_practice = "";
		String standing_certificate = "";
		String no_conviction_issued = "";
		String manufacturer_licence = "";
		String certificate_to_market = "";
		String qualified = "";
		String remarks = "";
		String status = "";
		int no_of_items_submitted = 0;
		BigDecimal mdq = new BigDecimal(0);
		int item_id;
		BigDecimal ratePerMdq = null;

		Session session = (Session) getSession();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Vector srno = box.getVector(TENDER_TB_SLNO);
			Vector mdq_vector = box.getVector(TENDER_TB_MDQ);
			Vector no_of_items = box.getVector(TENDER_TB_NO_OF_ITEMS);
			Vector disp_type_vector = box.getVector(TENDER_TB_DISP_TYPE);
			Vector manufacture_licence = box
					.getVector(TENDER_TB_MANUFACTURE_LICENCE);
			Vector certificate_to_market_product = box
					.getVector(TENDER_TB_CERTIFICATE_TO_MARKET_PRODUCT);
			Vector remarks_vector = box.getVector(TENDER_TB_REMARKS);
			Vector disqualified = box.getVector(TENDER_TB_DISQUALIFIED);
			Vector items = box.getVector(TENDER_TB_ITEM_ID);
			int tender_id = box.getInt(TENDER_NO);
			int group_id = box.getInt(TENDER_SUPPLIER_GROUP_ID);
			int supplier_id = box.getInt(TENDER_VENDOR_SUPPLIER_ID);
			storeTenderTechnicalBidMList = hbt
					.find("from jkt.hms.masters.business.StoreTenderTechnicalBidM as inp where inp.Tender.Id="
							+ tender_id
							+ " and inp.Group.Id= "
							+ group_id
							+ " and inp.Supplier.Id = " + supplier_id);

			if (storeTenderTechnicalBidMList != null
					&& storeTenderTechnicalBidMList.size() > 0) {
				storeTenderTechnicalBidM = storeTenderTechnicalBidMList.get(0);
				tb_master_id = storeTenderTechnicalBidM.getId();
				storeTenderTechnicalBidM.setGoodManufLabPractice(box
						.getString(TENDER_TB_GOOD_MANUF_LABORATORY_PRACTICES));
				storeTenderTechnicalBidM.setNoConvictionIssued(box
						.getString(TENDER_TB_NO_CONVICTION_CERTIFICATE));
				storeTenderTechnicalBidM.setMarketStandingCertificate(box
						.getString(TENDER_TB_MARKET_STANDING_CERTIFICATE));
				storeTenderTechnicalBidM.setLastChgBy(box.get(CHANGED_BY));
				storeTenderTechnicalBidM.setLastChgTime(box.get(CHANGED_TIME));
				storeTenderTechnicalBidM
						.setLastChgDate(HMSUtil
								.convertStringTypeDateToDateType(box
										.get(CHANGED_DATE)));
				hbt.update(storeTenderTechnicalBidM);
			}

			String obj = null;
			for (int i = 0; i < srno.size(); i++) {
				item_id = Integer.parseInt(items.get(i).toString());
				storeTenderTechnicalBidTList = hbt
						.find("from jkt.hms.masters.business.StoreTenderTechnicalBidT as inp where inp.TechBidM.Id = "
								+ storeTenderTechnicalBidM.getId()
								+ " and inp.Item.Id = " + item_id);
				if (storeTenderTechnicalBidTList.size() > 0) {
					storeTenderTechnicalBidT = storeTenderTechnicalBidTList
							.get(0);
					try {
						storeTenderTechnicalBidT.setMdqValue(new BigDecimal(
								mdq_vector.get(i).toString()));
					} catch (Exception e) {
						storeTenderTechnicalBidT.setMdqValue(new BigDecimal(0));
					}

					try {
						storeTenderTechnicalBidT
								.setNoOfItemSubmitted(new Integer(no_of_items
										.get(i).toString()));
					} catch (Exception e) {
						storeTenderTechnicalBidT.setNoOfItemSubmitted(0);
					}

					storeTenderTechnicalBidT
							.setManufacturerLicence(manufacture_licence.get(i)
									.toString());
					storeTenderTechnicalBidT
							.setCertificateToMarketProduct(certificate_to_market_product
									.get(i).toString());

					try {
						storeTenderTechnicalBidT.setRemarks(remarks_vector.get(
								i).toString());
					} catch (Exception e) {
						storeTenderTechnicalBidT.setRemarks("");
					}

					try {
						storeTenderTechnicalBidT.setDispType(disp_type_vector
								.get(i).toString());
					} catch (Exception e) {
						storeTenderTechnicalBidT.setDispType("");
					}

					if (disqualified.contains(items.get(i))) {
						storeTenderTechnicalBidT.setQualified("N");
						StoreTenderCommBidM storeTenderCommBidM = new StoreTenderCommBidM();
						StoreTenderCommBidT storeTenderCommBidT = new StoreTenderCommBidT();
						storeTenderCommBidMList = hbt
								.find("from jkt.hms.masters.business.StoreTenderCommBidM as inp where inp.Tender.Id="
										+ tender_id
										+ " and inp.Group.Id= "
										+ group_id
										+ " and inp.Item.Id = "
										+ item_id);

						if (storeTenderCommBidMList != null
								&& storeTenderCommBidMList.size() > 0) {
							storeTenderCommBidM = storeTenderCommBidMList
									.get(0);
							storeTenderCommBidTList = hbt
									.find("from jkt.hms.masters.business.StoreTenderCommBidT as inp where inp.CommBid.Id = "
											+ storeTenderCommBidM.getId()
											+ " and inp.Supplier.Id = "
											+ supplier_id);
							if (storeTenderCommBidTList != null
									&& storeTenderCommBidTList.size() > 0) {
								storeTenderCommBidT = storeTenderCommBidTList
										.get(0);
								storeTenderCommBidT.setQualified("N");
								storeTenderCommBidT.setRemarks(remarks_vector
										.get(i).toString());
								storeTenderCommBidT
										.setDispType(disp_type_vector.get(i)
												.toString());
								storeTenderCommBidT.setMdqValue(new BigDecimal(
										mdq_vector.get(i).toString()));

								if (mdq_vector.get(i).toString() != null
										|| mdq_vector.get(i).toString().trim() != "") {
									Transaction tx = null;
									try {
										tx = session.beginTransaction();
										BigDecimal divisor = storeTenderCommBidT
												.getTotRateMdq();
										storeTenderCommBidT.setCompRate(divisor
												.divide(new BigDecimal(
														mdq_vector.get(i)
																.toString()),
														new MathContext(6)));
										tx.commit();
									} catch (Exception e) {
										if (tx != null)
											tx.rollback();
										System.out
												.println("exception in dsss   "
														+ e);
										// e.printStackTrace();
										// storeTenderCommBidT.setCompRate(new
										// BigDecimal(0));
									}

								}
								hbt.update(storeTenderCommBidT);
							}
						}
					} else {
						storeTenderTechnicalBidT.setQualified("Y");
						StoreTenderCommBidM storeTenderCommBidM = new StoreTenderCommBidM();
						StoreTenderCommBidT storeTenderCommBidT = new StoreTenderCommBidT();
						storeTenderCommBidMList = hbt
								.find("from jkt.hms.masters.business.StoreTenderCommBidM as inp where inp.Tender.Id="
										+ tender_id
										+ " and inp.Group.Id= "
										+ group_id
										+ " and inp.Item.Id = "
										+ item_id);

						if (storeTenderCommBidMList != null
								&& storeTenderCommBidMList.size() > 0) {
							storeTenderCommBidM = storeTenderCommBidMList
									.get(0);
							storeTenderCommBidTList = hbt
									.find("from jkt.hms.masters.business.StoreTenderCommBidT as inp where inp.CommBid.Id = "
											+ storeTenderCommBidM.getId()
											+ " and inp.Supplier.Id = "
											+ supplier_id);
							if (storeTenderCommBidTList != null
									&& storeTenderCommBidTList.size() > 0) {
								storeTenderCommBidT = storeTenderCommBidTList
										.get(0);
								storeTenderCommBidT.setQualified("Y");
								storeTenderCommBidT.setRemarks(remarks_vector
										.get(i).toString());
								storeTenderCommBidT
										.setDispType(disp_type_vector.get(i)
												.toString());
								storeTenderCommBidT.setMdqValue(new BigDecimal(
										mdq_vector.get(i).toString()));

								if (mdq_vector.get(i).toString() != null
										|| mdq_vector.get(i).toString().trim() != "") {
									Transaction tx = null;
									try {
										tx = session.beginTransaction();
										BigDecimal divisor = storeTenderCommBidT
												.getTotRateMdq();
										storeTenderCommBidT.setCompRate(divisor
												.divide(new BigDecimal(
														mdq_vector.get(i)
																.toString()),
														new MathContext(6)));
										tx.commit();
									} catch (Exception e) {
										if (tx != null)
											tx.rollback();
										System.out
												.println("exception in dsss   "
														+ e);
										// e.printStackTrace();
										// storeTenderCommBidT.setCompRate(new
										// BigDecimal(0));
									}

								}
								hbt.update(storeTenderCommBidT);
							}
						}

					}

					hbt.update(storeTenderTechnicalBidT);
				}
			}

			// get grid details

			Criteria c = session.createCriteria(StoreTenderTechnicalBidM.class)
					.add(Restrictions.eq("Tender.Id", tender_id)).add(
							Restrictions.eq("Group.Id", group_id)).add(
							Restrictions.eq("Supplier.Id", supplier_id));
			storeTenderTechnicalBidMList = c.list();

			if (storeTenderTechnicalBidMList != null
					&& storeTenderTechnicalBidMList.size() > 0) {
				manufacturer_lab_practice = storeTenderTechnicalBidMList.get(0)
						.getGoodManufLabPractice();
				standing_certificate = storeTenderTechnicalBidMList.get(0)
						.getMarketStandingCertificate();
				no_conviction_issued = storeTenderTechnicalBidMList.get(0)
						.getNoConvictionIssued();
				status = storeTenderTechnicalBidMList.get(0).getStatus();

				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				storeTenderTechnicalBidM = (StoreTenderTechnicalBidM) storeTenderTechnicalBidMList
						.get(0);

				c = session.createCriteria(StoreTenderTechnicalBidT.class).add(
						Restrictions.eq("TechBidM.Id",
								storeTenderTechnicalBidMList.get(0).getId()));
				storeTenderTechnicalBidTList = c.list();

				for (Iterator iterator = storeTenderTechnicalBidTList
						.iterator(); iterator.hasNext();) {
					storeTenderTechnicalBidT = (StoreTenderTechnicalBidT) iterator
							.next();
					c = session.createCriteria(StoreTenderCommBidM.class).add(
							Restrictions.eq("Tender.Id", tender_id)).add(
							Restrictions.eq("Group.Id", group_id)).add(
							Restrictions.eq("Item.Id", storeTenderTechnicalBidT
									.getItem().getId()));
					storeTenderCommBidMList = c.list();

					if (storeTenderCommBidMList != null
							&& storeTenderCommBidMList.size() > 0) {
						c = session.createCriteria(StoreTenderCommBidT.class)
								.add(
										Restrictions.eq("CommBid.Id",
												storeTenderCommBidMList.get(0)
														.getId())).add(
										Restrictions.eq("Supplier.Id",
												supplier_id));
						storeTenderCommBidTList = c.list();

						try {
							ratePerMdq = storeTenderCommBidTList.get(0)
									.getRatePerMdq();
						} catch (Exception e) {
							ratePerMdq = new BigDecimal(0);
						}
					}

					try {
						pvms = storeTenderTechnicalBidT.getItem().getPvmsNo();
					} catch (Exception e) {
						pvms = "";
					}

					try {
						nomenclature = storeTenderTechnicalBidT.getItem()
								.getNomenclature();
					} catch (Exception e) {
						nomenclature = "";
					}

					try {
						strength = storeTenderTechnicalBidT.getItem()
								.getStrength();
					} catch (Exception e) {
						strength = "";
					}

					try {
						au = storeTenderTechnicalBidT.getItem()
								.getItemConversion().getPurchaseUnit()
								.getUnitName();
					} catch (Exception e) {
						au = "";
					}

					try {
						disp_type = storeTenderTechnicalBidT.getDispType();
					} catch (Exception e) {
						disp_type = "";
					}

					try {
						brandname = storeTenderTechnicalBidT.getBrandName();
					} catch (Exception e) {
						brandname = "";
					}

					try {
						manuf_name = storeTenderTechnicalBidT
								.getManufacturerName();
					} catch (Exception e) {
						manuf_name = "";
					}

					try {
						item_id = storeTenderTechnicalBidT.getItem().getId();
					} catch (Exception e) {
						item_id = 0;
					}

					try {
						manufacturer_licence = storeTenderTechnicalBidT
								.getManufacturerLicence();
					} catch (Exception e) {
						manufacturer_licence = "";
					}

					try {
						certificate_to_market = storeTenderTechnicalBidT
								.getCertificateToMarketProduct();
					} catch (Exception e) {
						certificate_to_market = "";
					}

					try {
						mdq = storeTenderTechnicalBidT.getMdqValue();
					} catch (Exception e) {
						mdq = new BigDecimal(0);
					}

					try {
						no_of_items_submitted = storeTenderTechnicalBidT
								.getNoOfItemSubmitted();
					} catch (Exception e) {
						no_of_items_submitted = 0;
					}

					try {
						qualified = storeTenderTechnicalBidT.getQualified();
					} catch (Exception e) {
						qualified = "";
					}

					try {
						remarks = storeTenderTechnicalBidT.getRemarks();
					} catch (Exception e) {
						remarks = "";
					}

					hData = new HashMap<String, Object>();
					hData.put(TENDER_TB_ITEM_ID, item_id);
					hData.put(TENDER_TB_PVMS, pvms);
					hData.put(TENDER_TB_NOMENCLATURE, nomenclature);
					hData.put(TENDER_TB_STRENGTH, strength);
					hData.put(TENDER_TB_BRAND, brandname);
					hData.put(TENDER_TB_DISP_TYPE, disp_type);
					hData.put(TENDER_TB_MANUFACTURER_NAME, manuf_name);
					hData.put(TENDER_TB_AU, au);
					hData.put(TENDER_TB_MANUFACTURE_LICENCE,
							manufacturer_licence);
					hData.put(TENDER_TB_CERTIFICATE_TO_MARKET_PRODUCT,
							certificate_to_market);
					hData.put(TENDER_TB_MDQ, mdq);
					hData.put(TENDER_TB_NO_OF_ITEMS, no_of_items_submitted);
					hData.put(TENDER_TB_DISQUALIFIED, qualified);
					hData.put(TENDER_TB_REMARKS, remarks);
					hData.put(TENDER_TB_REMARKS, remarks);
					hData.put(TENDER_CB_RATE_PER_MDQ, ratePerMdq);

					vResult.add(hData);
				} // for ends here
			} // if ends here
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		if (vResult.size() > 0) {
			testPageData = new HashMap[vResult.size()];
			vResult.copyInto(testPageData);

			try {
				pagedArray = new PageUtil().convertToPagedArrayIndex(
						testPageData, box);
			}

			catch (Exception e) {
				e.printStackTrace();
			}
		}

		map = getGroupAndTenderAndSupplierComboDetails(box);
		map.put("pagedArray", pagedArray);
		map.put(TENDER_TB_GOOD_MANUF_LABORATORY_PRACTICES,
				manufacturer_lab_practice);
		map.put(TENDER_TB_MARKET_STANDING_CERTIFICATE, standing_certificate);
		map.put(TENDER_TB_NO_CONVICTION_CERTIFICATE, no_conviction_issued);
		map.put("status", status);
		return map;
	}

	public synchronized Map<String, Object> tenderImportCD(Box box) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		String supplier_code = null;
		String tender_no = null;
		String group_name = null;
		int tender_id = 0;
		int supplier_id = 0;
		int group_id = 0;
		boolean Already_Imported = true;
		String values = " technical bid M values ";
		Transaction tx = null;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			tx = session.beginTransaction();
			BufferedOutputStream out = null;
			ZipInputStream in = new ZipInputStream(new BufferedInputStream(
					new FileInputStream(box.getString("uploadURL") + "/"
							+ box.getString("filename"))));
			ZipEntry entry;

			while ((entry = in.getNextEntry()) != null) {
				int count;
				byte data[] = new byte[1000];
				String fileName = box.getString("uploadURL") + "/"
						+ entry.getName();
				out = new BufferedOutputStream(new FileOutputStream(fileName),
						1000);
				while ((count = in.read(data, 0, 1000)) != -1)
					out.write(data, 0, count);
				out.flush();
				out.close();

				POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(
						fileName));
				HSSFWorkbook wb = new HSSFWorkbook(fs);
				HSSFSheet sheet = wb.getSheetAt(0);

				HSSFRow row = sheet.getRow(1);
				HSSFCell cell = row.getCell((short) 2);
				try {
					supplier_code = cell.getStringCellValue();
				} catch (Exception e) {
					supplier_code = "";
				}

				row = sheet.getRow(3);
				cell = row.getCell((short) 2);
				try {
					tender_no = cell.getStringCellValue();
				} catch (Exception e) {
					tender_no = "";
				}

				row = sheet.getRow(4);
				cell = row.getCell((short) 2);
				try {
					group_name = cell.getStringCellValue();
				} catch (Exception e) {
					group_name = "";
				}

				List<StoreTenderM> storeTenderMList = new ArrayList<StoreTenderM>();
				List<MasStoreSupplier> masStoreSupplierList = new ArrayList<MasStoreSupplier>();
				List<MasStoreGroup> masStoreGroupList = new ArrayList<MasStoreGroup>();
				List<StoreTenderTechnicalBidM> storeTenderTechnicalBidMList = new ArrayList<StoreTenderTechnicalBidM>();
				List<MasStoreItem> masStoreItemList = new ArrayList<MasStoreItem>();
				List<StoreTenderCommBidM> storeTenderCommBidMList = new ArrayList<StoreTenderCommBidM>();
				List<StoreTenderCommBidT> storeTenderCommBidTList = new ArrayList<StoreTenderCommBidT>();

				storeTenderMList = hbt
						.find("from jkt.hms.masters.business.StoreTenderM as inp where inp.TenderNo='"
								+ tender_no + "'");
				masStoreSupplierList = hbt
						.find("from jkt.hms.masters.business.MasStoreSupplier as inp where inp.SupplierCode='"
								+ supplier_code + "'");
				masStoreGroupList = hbt
						.find("from jkt.hms.masters.business.MasStoreGroup as inp where inp.GroupName='"
								+ group_name + "'");

				if (storeTenderMList != null && storeTenderMList.size() > 0
						&& masStoreSupplierList != null
						&& masStoreSupplierList.size() > 0
						&& masStoreGroupList != null
						&& masStoreGroupList.size() > 0) {
					tender_id = storeTenderMList.get(0).getId();
					supplier_id = masStoreSupplierList.get(0).getId();
					group_id = masStoreGroupList.get(0).getId();
				}

				storeTenderTechnicalBidMList = hbt
						.find("from jkt.hms.masters.business.StoreTenderTechnicalBidM as inp where inp.Tender.Id="
								+ tender_id
								+ " and inp.Group.Id= "
								+ group_id
								+ " and inp.Supplier.Id = " + supplier_id);

				if (storeTenderTechnicalBidMList != null
						&& storeTenderTechnicalBidMList.size() > 0) {
					//System.out.println("Imported Records found.........");
				} else {
					Already_Imported = false;
					//System.out.println("Importing is done.........");
					String pvms = null;
					String dispensable_type = null;
					String composition = null;

					String brand = null;
					String manufacturer = null;
					// int mdq = 0;
					BigDecimal mdq = new BigDecimal(0);
					float vat = 0.0f;
					int no_of_items_submitted = 0;
					float rs_in_fig = 0.0f;
					float tx_amt = 0.0f;
					float tot_amt = 0.0f;
					String rs_in_words = null;
					float mrp_in_rs = 0.0f;
					int srno = 0;

					StoreTenderTechnicalBidM storeTenderTechnicalBidM = new StoreTenderTechnicalBidM();
					storeTenderTechnicalBidM.setTender(storeTenderMList.get(0));
					storeTenderTechnicalBidM.setSupplier(masStoreSupplierList
							.get(0));
					storeTenderTechnicalBidM.setGroup(masStoreGroupList.get(0));
					MasHospital masHospital = new MasHospital(box
							.getInt("hospitalId"));
					storeTenderTechnicalBidM.setHospital(masHospital);
					MasDepartment masDepartment = new MasDepartment(box
							.getInt("deptId"));
					storeTenderTechnicalBidM.setDepartment(masDepartment);
					storeTenderTechnicalBidM.setGoodManufLabPractice("Y");
					storeTenderTechnicalBidM.setNoConvictionIssued("Y");
					storeTenderTechnicalBidM.setMarketStandingCertificate("Y");
					storeTenderTechnicalBidM.setQualified("Y");
					storeTenderTechnicalBidM.setStatus("o");
					storeTenderTechnicalBidM.setLastChgBy(box.get(CHANGED_BY));
					storeTenderTechnicalBidM.setLastChgDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(CHANGED_DATE)));
					storeTenderTechnicalBidM.setLastChgTime(box
							.get(CHANGED_TIME));
					hbt.save(storeTenderTechnicalBidM);

					StoreTenderTechnicalBidT storeTenderTechnicalBidT = null;
					StoreTenderCommBidM storeTenderCommBidM = null;
					StoreTenderCommBidT storeTenderCommBidT = null;
					//System.out.println(":::ss::" + sheet.getLastRowNum());
					for (int i = 7; i <= sheet.getLastRowNum(); i++) {
						row = sheet.getRow(i);

						cell = row.getCell((short) 1);
						try {
							pvms = cell.getStringCellValue();

						} catch (Exception e) {
							pvms = "";
						}
						cell = row.getCell((short) 5);
						try {
							brand = cell.getStringCellValue();
						} catch (Exception e) {
							brand = "";
						}
						cell = row.getCell((short) 6);
						try {
							manufacturer = cell.getStringCellValue();
						} catch (Exception e) {
							manufacturer = "";
						}
						cell = row.getCell((short) 7);
						try {
							composition = cell.getStringCellValue();
						} catch (Exception e) {
							composition = "";
						}
						cell = row.getCell((short) 8);
						try {
							dispensable_type = cell.getStringCellValue();
						} catch (Exception e) {
							dispensable_type = "";
						}
						cell = row.getCell((short) 9);
						try {
							mdq = BigDecimal
									.valueOf(cell.getNumericCellValue());
						} catch (Exception e) {
							mdq = new BigDecimal(0);
						}
						cell = row.getCell((short) 10);
						try {
							no_of_items_submitted = (int) cell
									.getNumericCellValue();
						} catch (Exception e) {
							no_of_items_submitted = 0;
						}
						cell = row.getCell((short) 11);
						try {
							vat = (float) cell.getNumericCellValue();
						} catch (Exception e) {
							vat = 0;
						}
						cell = row.getCell((short) 12);
						try {
							rs_in_fig = (float) cell.getNumericCellValue();
						} catch (Exception e) {
							rs_in_fig = 0;
						}
						cell = row.getCell((short) 13);
						try {
							tx_amt = (float) cell.getNumericCellValue();
						} catch (Exception e) {
							tx_amt = 0;
						}
						cell = row.getCell((short) 14);
						try {
							tot_amt = (float) cell.getNumericCellValue();
						} catch (Exception e) {
							tot_amt = 0;
						}
						cell = row.getCell((short) 15);
						try {
							mrp_in_rs = (float) cell.getNumericCellValue();
						} catch (Exception e) {
							mrp_in_rs = 0;
						}

						if (rs_in_fig > 0) // (save items only with price)
						{
							masStoreItemList = hbt
									.find("from jkt.hms.masters.business.MasStoreItem as inp where inp.PvmsNo ='"
											+ pvms + "'");

							storeTenderTechnicalBidT = new StoreTenderTechnicalBidT();
							storeTenderTechnicalBidT.setItem(masStoreItemList
									.get(0));
							int item_id = masStoreItemList.get(0).getId();

							storeTenderTechnicalBidT.setBrandName(brand);

							storeTenderTechnicalBidT
									.setCertificateToMarketProduct("Y");
							storeTenderTechnicalBidT
									.setDispType(dispensable_type);
							storeTenderTechnicalBidT
									.setManufacturerLicence("Y");
							storeTenderTechnicalBidT
									.setManufacturerName(manufacturer);

							storeTenderTechnicalBidT.setMdqValue(mdq);
							storeTenderTechnicalBidT
									.setNoOfItemSubmitted(no_of_items_submitted);
							storeTenderTechnicalBidT.setQualified("Y");
							storeTenderTechnicalBidT.setRemarks("");
							storeTenderTechnicalBidT
									.setTechBidM(storeTenderTechnicalBidM);
							storeTenderTechnicalBidT
									.setComposition(composition);
							hbt.save(storeTenderTechnicalBidT);
							//System.out.println("::::" + pvms + "::::::::::::"	+ masStoreItemList.size() + ":::::::::" tender_id + "::::::::::" + group_id+ "::::::::" + item_id);
							storeTenderCommBidMList = hbt
									.find("from jkt.hms.masters.business.StoreTenderCommBidM as inp where inp.Tender.Id="
											+ tender_id
											+ " and inp.Group.Id= "
											+ group_id
											+ " and inp.Item.Id = "
											+ item_id);

							if (storeTenderCommBidMList != null
									&& storeTenderCommBidMList.size() > 0) {
								System.out
										.println("Comm Bid M Record Already found for this Item.........");
								storeTenderCommBidM = storeTenderCommBidMList
										.get(0);
							} else {
								storeTenderCommBidM = new StoreTenderCommBidM();
								storeTenderCommBidM
										.setDepartment(new MasDepartment(box
												.getInt("deptId")));
								storeTenderCommBidM
										.setHospital(new MasHospital(box
												.getInt("hospitalId")));
								storeTenderCommBidM.setItem(masStoreItemList
										.get(0));
								storeTenderCommBidM.setGroup(masStoreGroupList
										.get(0));
								storeTenderCommBidM.setLastChgBy(box
										.get(CHANGED_BY));
								storeTenderCommBidM.setLastChgDate(HMSUtil
										.convertStringTypeDateToDateType(box
												.get(CHANGED_DATE)));
								storeTenderCommBidM.setLastChgTime(box
										.get(CHANGED_TIME));
								storeTenderCommBidM.setStatus("O");
								storeTenderCommBidM.setTender(storeTenderMList
										.get(0));
								hbt.save(storeTenderCommBidM);
							}

							storeTenderCommBidTList = hbt
									.find("from jkt.hms.masters.business.StoreTenderCommBidT as inp where inp.CommBid.Id = "
											+ storeTenderCommBidM.getId()
											+ " order by inp.SrNo desc ");
							if (storeTenderCommBidTList != null
									&& storeTenderCommBidTList.size() > 0) {
								srno = storeTenderCommBidTList.get(0).getSrNo();
							} else {
								srno = 0;
							}

							storeTenderCommBidT = new StoreTenderCommBidT();
							storeTenderCommBidT.setSrNo(++srno);
							storeTenderCommBidT.setCommBid(storeTenderCommBidM);
							storeTenderCommBidT
									.setSupplier(masStoreSupplierList.get(0));

							storeTenderCommBidT.setBrandName(brand);
							storeTenderCommBidT
									.setManufacturerName(manufacturer);

							storeTenderCommBidT.setDispType(dispensable_type);
							storeTenderCommBidT.setMdqValue(mdq);

							try {
								storeTenderCommBidT
										.setVatPercent(new BigDecimal(vat));
							} catch (Exception e) {
								storeTenderCommBidT
										.setVatPercent(new BigDecimal(0));
							}

							try {
								storeTenderCommBidT
										.setRatePerMdq(new BigDecimal(rs_in_fig));
								storeTenderCommBidT
										.setNewRatePerMdq(new BigDecimal(
												rs_in_fig));
								storeTenderCommBidT
										.setFinalPricePerMdq(new BigDecimal(
												rs_in_fig));
							} catch (Exception e) {
								storeTenderCommBidT
										.setRatePerMdq(new BigDecimal(0));
								storeTenderCommBidT
										.setFinalPricePerMdq(new BigDecimal(0));
							}

							storeTenderCommBidT.setComposition(composition);

							try {
								storeTenderCommBidT
										.setTaxAmountMdq(new BigDecimal(tx_amt));
								storeTenderCommBidT
										.setNewTaxAmtPerMdq(new BigDecimal(
												tx_amt));
							} catch (Exception e) {
								storeTenderCommBidT
										.setTaxAmountMdq(new BigDecimal(0));
							}

							try {
								storeTenderCommBidT
										.setTotRateMdq(new BigDecimal(tot_amt));
								storeTenderCommBidT
										.setNewTotRateMdq(new BigDecimal(
												tot_amt));
							} catch (Exception e) {
								storeTenderCommBidT
										.setTotRateMdq(new BigDecimal(0));
							}

							try {
								BigDecimal divisor = storeTenderCommBidT
										.getTotRateMdq();
								storeTenderCommBidT.setCompRate(divisor.divide(
										mdq, new MathContext(6)));
							} catch (Exception e) {
								storeTenderCommBidT.setCompRate(new BigDecimal(
										0));
							}

							try {
								storeTenderCommBidT.setMrp(new BigDecimal(
										mrp_in_rs));
							} catch (Exception e) {
								storeTenderCommBidT.setMrp(new BigDecimal(0));
							}

							storeTenderCommBidT.setLcat("0");
							storeTenderCommBidT.setRemarks("");
							storeTenderCommBidT.setQualified("Y");
							hbt.save(storeTenderCommBidT);
						}// end of if stmt (save items only with price)
					} // end of for loop
				} // else part of techBidM if condition ends here
				File f = new File(fileName);
				if (f.exists()) {
					boolean t = f.delete();
				}
			}// while ends here

			// Write the output to a file
			if (Already_Imported)
				map.put("flag", "Already_Imported");
			else {
				tx.commit();
				map.put("flag", "Imported");
			}
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			map.put("flag", "Error");
			map.put("error", e.toString() + " " + values);
			e.printStackTrace();
		} catch (Exception e) {
			map.put("flag", "Error");
			map.put("error", e.toString());
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> getGroupAndTenderAndSupplierComboDetailsForCommercialBid(
			Box box) {
		// TODO Auto-generated method stub
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreGroup> masStoreGroupList = new ArrayList<MasStoreGroup>();
		List<StoreTenderM> storeTenderMList = new ArrayList<StoreTenderM>();
		List<MasStoreItem> masStoreItemList = new ArrayList<MasStoreItem>();

		session = (Session) getSession();

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			if (!box.getString(TENDER_NO).equals("")
					&& !box.getString(TENDER_SUPPLIER_GROUP_ID).equals("")) {
				masStoreItemList = hbt
						.find("select inp.Item from jkt.hms.masters.business.StoreTenderT inp where inp.TenderM.Id="
								+ box.get(TENDER_NO));
				masStoreGroupList = hbt
						.find("select distinct inp.Group from jkt.hms.masters.business.StoreTenderCommBidM inp");
				storeTenderMList = hbt
						.find("select distinct inp.Tender from jkt.hms.masters.business.StoreTenderCommBidM inp where inp.Group.Id="
								+ box.get(TENDER_SUPPLIER_GROUP_ID));
				map.put("masStoreItemList", masStoreItemList);
				map.put("masStoreGroupList", masStoreGroupList);
				map.put("storeTenderMList", storeTenderMList);
			} else if (!box.getString(TENDER_SUPPLIER_GROUP_ID).equals("")) {
				masStoreGroupList = hbt
						.find("select distinct inp.Group from jkt.hms.masters.business.StoreTenderCommBidM inp");
				storeTenderMList = hbt
						.find("select distinct inp.Tender from jkt.hms.masters.business.StoreTenderCommBidM inp where inp.Group.Id="
								+ box.get(TENDER_SUPPLIER_GROUP_ID));
				map.put("masStoreGroupList", masStoreGroupList);
				map.put("storeTenderMList", storeTenderMList);
			} else {
				/*
				 * masStoreGroupList = hbt
				 * .find("from jkt.hms.masters.business.MasStoreGroup");
				 */
				masStoreGroupList = hbt
						.find("select distinct inp.Group from jkt.hms.masters.business.StoreTenderCommBidM inp");
				map.put("masStoreGroupList", masStoreGroupList);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> getTenderCommercialBidGrid(Box box) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;
		List<StoreTenderCommBidM> storeTenderCommBidMList = new ArrayList<StoreTenderCommBidM>();
		List<StoreTenderCommBidT> storeTenderCommBidTList = new ArrayList<StoreTenderCommBidT>();
		List<MasStoreItem> masStoreItemList = new ArrayList<MasStoreItem>();

		String firm_name = null;
		String brand_name = null;
		String manuf_name = null;
		String disp_type = null;
		// int mdq = 0;
		BigDecimal mdq = new BigDecimal(0);
		BigDecimal vat = null;
		BigDecimal rate_per_mdq = null;
		BigDecimal comp_rate = null;
		BigDecimal mrp = null;
		BigDecimal final_price_per_mdq = null;
		String lcat = null;
		String remarks = null;
		String qualified = null;
		String nomenclature = null;
		String pvmsNo = null;
		String status = "O";
		String noitem = "no";
		String composition = "";
		BigDecimal tax_amount = null;
		BigDecimal tot_amount = null;
		StoreTenderCommBidM storeTenderCommBidM = new StoreTenderCommBidM();
		Set<StoreTenderCommBidT> storeTenderCommBidTSet = null;
		List<StoreTenderCommHodRecom> storeTenderCommHodRecomList = new ArrayList<StoreTenderCommHodRecom>();
		Session session = (Session) getSession();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			int tender_id = box.getInt(TENDER_NO);
			int group_id = box.getInt(TENDER_SUPPLIER_GROUP_ID);
			int item_id = box.getInt(TENDER_PVMS);
			int supplier_id = 0;

			storeTenderCommHodRecomList = hbt
					.find("from jkt.hms.masters.business.StoreTenderCommHodRecom");

			masStoreItemList = hbt
					.find("from jkt.hms.masters.business.MasStoreItem as inp where inp.Id="
							+ item_id);
			if (masStoreItemList != null && masStoreItemList.size() > 0) {
				nomenclature = masStoreItemList.get(0).getNomenclature();
				pvmsNo = masStoreItemList.get(0).getPvmsNo();
			}

			List<StoreTenderTechnicalBidM> storeTenderTechnicalBidMList = new ArrayList<StoreTenderTechnicalBidM>();
			Criteria c = session.createCriteria(StoreTenderTechnicalBidM.class)
					.add(Restrictions.eq("Tender.Id", tender_id)).add(
							Restrictions.eq("Group.Id", group_id));
			storeTenderTechnicalBidMList = c.list();

			if (storeTenderTechnicalBidMList != null
					&& storeTenderTechnicalBidMList.size() > 0) {
				status = storeTenderTechnicalBidMList.get(0).getStatus();
			}
			storeTenderCommBidMList = hbt
					.find("from jkt.hms.masters.business.StoreTenderCommBidM as inp where inp.Tender.Id="
							+ tender_id
							+ " and inp.Group.Id= "
							+ group_id
							+ " and inp.Item.Id = " + item_id);

			if (storeTenderCommBidMList != null
					&& storeTenderCommBidMList.size() > 0) {
				storeTenderCommBidM = storeTenderCommBidMList.get(0);
				// status = storeTenderCommBidM.getStatus();
				storeTenderCommBidTList = hbt
						.find("from jkt.hms.masters.business.StoreTenderCommBidT as inp where inp.CommBid.Id = "
								+ storeTenderCommBidM.getId()
								+ " order by inp.Qualified desc , inp.CompRate asc ");

				for (Iterator iterator = storeTenderCommBidTList.iterator(); iterator
						.hasNext();) {
					StoreTenderCommBidT storeTenderCommBidT = (StoreTenderCommBidT) iterator
							.next();
					try {
						firm_name = storeTenderCommBidT.getSupplier()
								.getSupplierName();
					} catch (Exception e) {
						firm_name = "";
					}

					try {
						brand_name = storeTenderCommBidT.getBrandName();
					} catch (Exception e) {
						brand_name = "";
					}

					try {
						manuf_name = storeTenderCommBidT.getManufacturerName();
					} catch (Exception e) {
						manuf_name = "";
					}

					try {
						disp_type = storeTenderCommBidT.getDispType();
					} catch (Exception e) {
						disp_type = "";
					}

					try {
						mdq = storeTenderCommBidT.getMdqValue();
					} catch (Exception e) {
						mdq = new BigDecimal(0);
					}

					try {
						vat = storeTenderCommBidT.getVatPercent();
					} catch (Exception e) {
						vat = new BigDecimal(0);
					}

					try {
						rate_per_mdq = storeTenderCommBidT.getRatePerMdq();
					} catch (Exception e) {
						rate_per_mdq = new BigDecimal(0);
					}

					try {

						// changed for comRate Calu
						comp_rate = storeTenderCommBidT.getCompRate();
						// comp_rate =
						// storeTenderCommBidT.getRatePerMdq()/storeTenderCommBidT.getRatePerMdq();

					} catch (Exception e) {
						comp_rate = new BigDecimal(0);
					}

					try {
						lcat = storeTenderCommBidT.getLcat();
					} catch (Exception e) {
						lcat = "";
					}

					try {
						final_price_per_mdq = storeTenderCommBidT
								.getFinalPricePerMdq();
					} catch (Exception e) {
						final_price_per_mdq = new BigDecimal(0);
					}

					try {
						remarks = storeTenderCommBidT.getRemarks();
					} catch (Exception e) {
						remarks = "";
					}

					try {
						qualified = storeTenderCommBidT.getQualified();
					} catch (Exception e) {
						qualified = "";
					}

					try {
						supplier_id = storeTenderCommBidT.getSupplier().getId();
					} catch (Exception e) {
						supplier_id = 0;
					}

					try {
						mrp = storeTenderCommBidT.getMrp();
					} catch (Exception e) {
						mrp = new BigDecimal(0);
					}

					try {
						composition = storeTenderCommBidT.getComposition();
					} catch (Exception e) {
						composition = "";
					}

					try {
						tax_amount = storeTenderCommBidT.getTaxAmountMdq();
					} catch (Exception e) {
						tax_amount = new BigDecimal(0);
					}
					try {
						tot_amount = storeTenderCommBidT.getTotRateMdq();
					} catch (Exception e) {
						tot_amount = new BigDecimal(0);
					}
					hData = new HashMap<String, Object>();
					hData.put(TENDER_CB_SUPPLIER_ID, supplier_id);
					hData.put(TENDER_CB_FIRM_NAME, firm_name);
					hData.put(TENDER_CB_BRAND_NAME, brand_name);
					hData.put(TENDER_CB_MANF_NAME, manuf_name);
					hData.put(TENDER_CB_DISP_TYPE, disp_type);
					hData.put(TENDER_CB_MDQ, mdq);
					hData.put(TENDER_CB_VAT, vat);
					hData.put(TENDER_CB_RATE_PER_MDQ, rate_per_mdq);
					hData.put(TENDER_CB_COMP_RATE, comp_rate);
					hData.put(TENDER_CB_LCAT, lcat);
					hData.put(TENDER_CB_FINAL_PRICE_PER_MDQ,
							final_price_per_mdq);
					hData.put(TENDER_CB_MRP, mrp);
					hData.put(TENDER_CB_REMARKS, remarks);
					hData.put(TENDER_CB_DISQUALIFIED, qualified);
					hData.put("composition", composition);
					hData.put("taxAmount", tax_amount);
					hData.put("totAmount", tot_amount);
					vResult.add(hData);
				} // for ends here
			} // if ends here
			else {
				noitem = "yes";
			}
		} // try ends here
		catch (HibernateException e) {
			e.printStackTrace();
		}

		if (vResult.size() > 0) {
			testPageData = new HashMap[vResult.size()];
			vResult.copyInto(testPageData);

			try {
				pagedArray = new PageUtil().convertToPagedArrayIndex(
						testPageData, box);
			}

			catch (Exception e) {
				e.printStackTrace();
			}
		}
		map = getGroupAndTenderAndSupplierComboDetailsForCommercialBid(box);
		map.put("nomenclature", nomenclature);
		map.put("pvmsNo", pvmsNo);
		map.put("status", status);
		map.put("pagedArray", pagedArray);
		map.put("noitem", noitem);
		map.put("storeTenderCommHodRecomList", storeTenderCommHodRecomList);
		return map;
	}

	public Map<String, Object> updateCommBidGridItems(Box box) {
		List<StoreTenderCommBidM> storeTenderCommBidMList = new ArrayList<StoreTenderCommBidM>();
		List<StoreTenderCommBidT> storeTenderCommBidTList = new ArrayList<StoreTenderCommBidT>();
		Map<String, Object> map = new HashMap<String, Object>();
		StoreTenderCommBidM storeTenderCommBidM = new StoreTenderCommBidM();
		StoreTenderCommBidT storeTenderCommBidT = new StoreTenderCommBidT();
		List<StoreTenderCommHodRecom> storeTenderCommHodRecomList = new ArrayList<StoreTenderCommHodRecom>();
		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;

		String firm_name = null;
		String brand_name = null;
		String manuf_name = null;
		String disp_type = null;
		// int mdq = 0;
		BigDecimal mdq = new BigDecimal(0);
		BigDecimal vat = null;
		BigDecimal rate_per_mdq = null;
		BigDecimal comp_rate = null;
		BigDecimal mrp = null;
		BigDecimal final_price_per_mdq = null;
		String lcat = null;
		String remarks = null;
		String qualified = null;
		String nomenclature = null;
		String status = "O";
		String composition = "";
		BigDecimal tax_amount = null;
		BigDecimal tot_amount = null;

		Session session = (Session) getSession();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			Vector srno = box.getVector(TENDER_CB_SLNO);
			Vector disp_type_vector = box.getVector(TENDER_CB_DISP_TYPE);
			Vector final_price_per_mdq_vector = box
					.getVector(TENDER_CB_RATE_PER_MDQ);
			Vector remarks_vector = box.getVector(TENDER_CB_REMARKS);
			Vector disqualified = box.getVector(TENDER_CB_DISQUALIFIED);

			Vector suppliers = box.getVector(TENDER_CB_SUPPLIER_ID);

			int tender_id = box.getInt(TENDER_NO);
			int group_id = box.getInt(TENDER_SUPPLIER_GROUP_ID);
			int item_id = box.getInt(TENDER_PVMS);
			int supplier_id = 0;

			storeTenderCommBidMList = hbt
					.find("from jkt.hms.masters.business.StoreTenderCommBidM as inp where inp.Tender.Id="
							+ tender_id
							+ " and inp.Group.Id= "
							+ group_id
							+ " and inp.Item.Id = " + item_id);

			if (storeTenderCommBidMList != null
					&& storeTenderCommBidMList.size() > 0) {
				storeTenderCommBidM = storeTenderCommBidMList.get(0);

				for (int i = 0; i < srno.size(); i++) {
					supplier_id = Integer.parseInt(suppliers.get(i).toString());

					storeTenderCommBidTList = hbt
							.find("from jkt.hms.masters.business.StoreTenderCommBidT as inp where inp.CommBid.Id = "
									+ storeTenderCommBidM.getId()
									+ " and inp.Supplier.Id = " + supplier_id);

					if (storeTenderCommBidTList.size() > 0) {
						storeTenderCommBidT = storeTenderCommBidTList.get(0);
						try {
							storeTenderCommBidT.setDispType(disp_type_vector
									.get(i).toString());
						} catch (Exception e) {
							storeTenderCommBidT.setDispType("");
						}
						try {
							storeTenderCommBidT.setRemarks(remarks_vector
									.get(i).toString());
						} catch (Exception e) {
							storeTenderCommBidT.setRemarks("");
						}
						if (disqualified.contains(suppliers.get(i))) {
							storeTenderCommBidT.setQualified("N");
						} else {
							storeTenderCommBidT.setQualified("Y");
						}

						hbt.update(storeTenderCommBidT);
					} // end of if ....
				} // end of for loop...
			} // end of if....

			// get grid data

			storeTenderCommHodRecomList = hbt
					.find("from jkt.hms.masters.business.StoreTenderCommHodRecom");

			List<MasStoreItem> masStoreItemList = new ArrayList<MasStoreItem>();
			masStoreItemList = hbt
					.find("from jkt.hms.masters.business.MasStoreItem as inp where inp.Id="
							+ item_id);
			if (masStoreItemList != null && masStoreItemList.size() > 0) {
				nomenclature = masStoreItemList.get(0).getNomenclature();
			}

			storeTenderCommBidMList = hbt
					.find("from jkt.hms.masters.business.StoreTenderCommBidM as inp where inp.Tender.Id="
							+ tender_id
							+ " and inp.Group.Id= "
							+ group_id
							+ " and inp.Item.Id = " + item_id);

			if (storeTenderCommBidMList != null
					&& storeTenderCommBidMList.size() > 0) {
				storeTenderCommBidM = storeTenderCommBidMList.get(0);
				status = storeTenderCommBidM.getStatus();
				storeTenderCommBidTList = hbt
						.find("from jkt.hms.masters.business.StoreTenderCommBidT as inp where inp.CommBid.Id = "
								+ storeTenderCommBidM.getId()
								+ " order by inp.Qualified desc , inp.CompRate asc ");

				for (Iterator iterator = storeTenderCommBidTList.iterator(); iterator
						.hasNext();) {
					storeTenderCommBidT = (StoreTenderCommBidT) iterator.next();
					try {
						firm_name = storeTenderCommBidT.getSupplier()
								.getSupplierName();
					} catch (Exception e) {
						firm_name = "";
					}

					try {
						brand_name = storeTenderCommBidT.getBrandName();
					} catch (Exception e) {
						brand_name = "";
					}

					try {
						manuf_name = storeTenderCommBidT.getManufacturerName();
					} catch (Exception e) {
						manuf_name = "";
					}

					try {
						disp_type = storeTenderCommBidT.getDispType();
					} catch (Exception e) {
						disp_type = "";
					}

					try {
						mdq = storeTenderCommBidT.getMdqValue();
					} catch (Exception e) {
						mdq = new BigDecimal(0);
					}

					try {
						vat = storeTenderCommBidT.getVatPercent();
					} catch (Exception e) {
						vat = new BigDecimal(0);
					}

					try {
						rate_per_mdq = storeTenderCommBidT.getRatePerMdq();
					} catch (Exception e) {
						rate_per_mdq = new BigDecimal(0);
					}

					try {
						comp_rate = storeTenderCommBidT.getCompRate();
					} catch (Exception e) {
						comp_rate = new BigDecimal(0);
					}

					try {
						lcat = storeTenderCommBidT.getLcat();
					} catch (Exception e) {
						lcat = "";
					}

					try {
						final_price_per_mdq = storeTenderCommBidT
								.getFinalPricePerMdq();
					} catch (Exception e) {
						final_price_per_mdq = new BigDecimal(0);
					}

					try {
						remarks = storeTenderCommBidT.getRemarks();
					} catch (Exception e) {
						remarks = "";
					}

					try {
						qualified = storeTenderCommBidT.getQualified();
					} catch (Exception e) {
						qualified = "";
					}

					try {
						supplier_id = storeTenderCommBidT.getSupplier().getId();
					} catch (Exception e) {
						supplier_id = 0;
					}

					try {
						mrp = storeTenderCommBidT.getMrp();
					} catch (Exception e) {
						mrp = new BigDecimal(0);
					}

					try {
						composition = storeTenderCommBidT.getComposition();
					} catch (Exception e) {
						composition = "";
					}

					try {
						tax_amount = storeTenderCommBidT.getTaxAmountMdq();
					} catch (Exception e) {
						tax_amount = new BigDecimal(0);
					}
					try {
						tot_amount = storeTenderCommBidT.getTotRateMdq();
					} catch (Exception e) {
						tot_amount = new BigDecimal(0);
					}
					hData = new HashMap<String, Object>();
					hData.put(TENDER_CB_SUPPLIER_ID, supplier_id);
					hData.put(TENDER_CB_FIRM_NAME, firm_name);
					hData.put(TENDER_CB_BRAND_NAME, brand_name);
					hData.put(TENDER_CB_MANF_NAME, manuf_name);
					hData.put(TENDER_CB_DISP_TYPE, disp_type);
					hData.put(TENDER_CB_MDQ, mdq);
					hData.put(TENDER_CB_VAT, vat);
					hData.put(TENDER_CB_RATE_PER_MDQ, rate_per_mdq);
					hData.put(TENDER_CB_COMP_RATE, comp_rate);
					hData.put(TENDER_CB_LCAT, lcat);
					hData.put(TENDER_CB_FINAL_PRICE_PER_MDQ,
							final_price_per_mdq);
					hData.put(TENDER_CB_MRP, mrp);
					hData.put(TENDER_CB_REMARKS, remarks);
					hData.put(TENDER_CB_DISQUALIFIED, qualified);
					hData.put("composition", composition);
					hData.put("taxAmount", tax_amount);
					hData.put("totAmount", tot_amount);
					vResult.add(hData);
				}
			}

			// end of getting grid data

		} // end of try
		catch (HibernateException e) {
			e.printStackTrace();
		}

		if (vResult.size() > 0) {
			testPageData = new HashMap[vResult.size()];
			vResult.copyInto(testPageData);

			try {
				pagedArray = new PageUtil().convertToPagedArrayIndex(
						testPageData, box);
			}

			catch (Exception e) {
				e.printStackTrace();
			}
		}
		map = getGroupAndTenderAndSupplierComboDetailsForCommercialBid(box);
		map.put("nomenclature", nomenclature);
		map.put("status", status);
		map.put("pagedArray", pagedArray);
		map.put("storeTenderCommHodRecomList", storeTenderCommHodRecomList);
		return map;
	}

	public synchronized Map<String, Object> getTenderCommercialMarkingL1(Box box) {
		// TODO Auto-generated method stub
		List<StoreTenderCommBidM> storeTenderCommBidMList = new ArrayList<StoreTenderCommBidM>();
		List<StoreTenderCommBidT> storeTenderCommBidTList = new ArrayList<StoreTenderCommBidT>();
		Map<String, Object> map = new HashMap<String, Object>();
		StoreTenderCommBidM storeTenderCommBidM = new StoreTenderCommBidM();
		StoreTenderCommBidT storeTenderCommBidT = new StoreTenderCommBidT();

		Session session = (Session) getSession();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			Vector srno = box.getVector(TENDER_CB_SLNO);
			Vector disp_type_vector = box.getVector(TENDER_CB_DISP_TYPE);
			Vector final_price_per_mdq_vector = box
					.getVector(TENDER_CB_FINAL_PRICE_PER_MDQ);
			Vector remarks_vector = box.getVector(TENDER_CB_REMARKS);
			Vector disqualified = box.getVector(TENDER_CB_DISQUALIFIED);

			Vector suppliers = box.getVector(TENDER_CB_SUPPLIER_ID);

			int tender_id = box.getInt(TENDER_NO);
			int group_id = box.getInt(TENDER_SUPPLIER_GROUP_ID);
			int item_id = box.getInt(TENDER_PVMS);
			int supplier_id = 0;

			storeTenderCommBidMList = hbt
					.find("from jkt.hms.masters.business.StoreTenderCommBidM as inp where inp.Tender.Id="
							+ tender_id + " and inp.Group.Id= " + group_id);

			// Code for Allot Ranking L1,L2,.... Category
			// First Make All Rank 0

			for (Iterator iterator = storeTenderCommBidMList.iterator(); iterator
					.hasNext();) {
				storeTenderCommBidM = (StoreTenderCommBidM) iterator.next();
				storeTenderCommBidTList = hbt
						.find("from jkt.hms.masters.business.StoreTenderCommBidT as inp where inp.CommBid.Id = "
								+ storeTenderCommBidM.getId());
				int rank = 0;
				for (Iterator iterator2 = storeTenderCommBidTList.iterator(); iterator2
						.hasNext();) {
					storeTenderCommBidT = (StoreTenderCommBidT) iterator2
							.next();
					storeTenderCommBidT.setLcat(String.valueOf(rank));
					hbt.update(storeTenderCommBidT);
				}
			}

			// Here Assign Actual Rank
			// If comp_rate is same for two suppliers, then both the suppliers
			// will get the same rank

			for (Iterator iterator = storeTenderCommBidMList.iterator(); iterator
					.hasNext();) {
				storeTenderCommBidM = (StoreTenderCommBidM) iterator.next();
				storeTenderCommBidTList = hbt
						.find("from jkt.hms.masters.business.StoreTenderCommBidT as inp where inp.CommBid.Id = "
								+ storeTenderCommBidM.getId()
								+ " and inp.Qualified = 'Y' "
								+ " order by inp.CompRate ");
				BigDecimal oldValue = new BigDecimal(0);
				BigDecimal newValue = new BigDecimal(0);
				int rank = 1;
				if (storeTenderCommBidTList != null
						&& storeTenderCommBidTList.size() > 0) {
					oldValue = storeTenderCommBidTList.get(0).getCompRate();
				}
				for (Iterator iterator2 = storeTenderCommBidTList.iterator(); iterator2
						.hasNext();) {
					storeTenderCommBidT = (StoreTenderCommBidT) iterator2
							.next();
					newValue = storeTenderCommBidT.getCompRate();

					if (oldValue.equals(newValue))
						storeTenderCommBidT.setLcat(String.valueOf(rank));
					else
						storeTenderCommBidT.setLcat(String.valueOf(++rank));

					hbt.update(storeTenderCommBidT);
					oldValue = newValue;
				}
			}

			List<StoreTenderTechnicalBidM> storeTenderTechnicalBidMList = new ArrayList<StoreTenderTechnicalBidM>();
			storeTenderTechnicalBidMList = hbt
					.find("from jkt.hms.masters.business.StoreTenderTechnicalBidM as inp where inp.Tender.Id="
							+ tender_id + " and inp.Group.Id= " + group_id);

			int count = 1;

			for (Iterator iterator = storeTenderTechnicalBidMList.iterator(); iterator
					.hasNext();) {

				StoreTenderTechnicalBidM storeTenderTechnicalBidM = (StoreTenderTechnicalBidM) iterator
						.next();

				count++;
				storeTenderTechnicalBidM.setStatus("P");
				hbt.update(storeTenderTechnicalBidM);
			}
			//System.out.println("counbt value" + count);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map = getTenderCommercialBidGrid(box);
		return map;
	}

	public Map<String, Object> getHODRecommendationDetails(Box box) {
		// TODO Auto-generated method stub
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreSupplier> masStoreSupplierList = new ArrayList<MasStoreSupplier>();
		List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();

		session = (Session) getSession();

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			masStoreSupplierList = hbt
					.find("from jkt.hms.masters.business.MasStoreSupplier");
			masEmployeeList = hbt
					.find("from jkt.hms.masters.business.MasEmployee");
			map.put("masStoreSupplierList", masStoreSupplierList);
			map.put("masEmployeeList", masEmployeeList);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> showTenderLPO(Box box) {
		// TODO Auto-generated method stub
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> masterDataMap = new HashMap<String, Object>();
		int deptId = 24;
		int note_no = 0;
		try {

			List<StoreTenderM> storeTenderMList = new ArrayList<StoreTenderM>();
			List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
			List<StoreTenderLocalPurchaseM> storeTenderLocalPurchaseMList = new ArrayList<StoreTenderLocalPurchaseM>();
			List existingNoteList = new ArrayList();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			// storeTenderMList = hbt
			// .find("from jkt.hms.masters.business.StoreTenderM as inp order by
			// inp.Id desc");
			storeTenderMList = session.createCriteria(StoreTenderM.class)
					.addOrder(Order.desc("Id")).list();
			employeeList = hbt
					.find("from jkt.hms.masters.business.MasEmployee as inp ");

			// storeTenderLocalPurchaseMList = hbt
			// .find("from jkt.hms.masters.business.StoreTenderLocalPurchaseM as
			// inp where inp.Department.Id="+box.getInt("deptId")+" order by
			// inp.NoteNo desc");

			storeTenderLocalPurchaseMList = session.createCriteria(
					StoreTenderLocalPurchaseM.class).add(
					Restrictions.eq("Department.Id", box.getInt("deptId")))
					.addOrder(Order.desc("NoteNo")).list();
			if (storeTenderLocalPurchaseMList != null
					&& storeTenderLocalPurchaseMList.size() > 0)
				note_no = storeTenderLocalPurchaseMList.get(0).getNoteNo();

			// storeTenderLocalPurchaseMList = hbt
			// .find("from jkt.hms.masters.business.StoreTenderLocalPurchaseM as
			// inp where inp.Department.Id="+box.getInt("deptId")+" inp.Status =
			// 'o'");
			storeTenderLocalPurchaseMList = session.createCriteria(
					StoreTenderLocalPurchaseM.class).add(
					Restrictions.eq("Department.Id", box.getInt("deptId")))
					.add(Restrictions.eq("Status", "o")).addOrder(
							Order.desc("NoteNo")).list();
			for (Iterator iterator = storeTenderLocalPurchaseMList.iterator(); iterator
					.hasNext();) {
				StoreTenderLocalPurchaseM storeTenderLocalPurchaseM = (StoreTenderLocalPurchaseM) iterator
						.next();
				existingNoteList.add(storeTenderLocalPurchaseM.getNoteNo());
			}

			if (box.get("fromSearch").equals("")) {
				map.put("storeTenderMList", storeTenderMList);
				//System.out.println("in if");
			} else {
				storeTenderMList = session.createCriteria(StoreTenderM.class)
						.add(Restrictions.eq("Id", box.getInt(TENDER_NO)))
						.addOrder(Order.desc("Id")).list();

				map.put("storeTenderMList", storeTenderMList);
				// getting supplierList for combo
				List<MasStoreItem> masStoreItemList = new ArrayList<MasStoreItem>();
				List<StoreTenderCommBidT> storeTenderCommBidTList = new ArrayList<StoreTenderCommBidT>();
				try {

					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);

					storeTenderCommBidTList = hbt
							.find("from jkt.hms.masters.business.StoreTenderCommBidT as inp where inp.CommBid.Tender.Id="
									+ box.getInt(TENDER_NO)
									+ " and inp.CommBid.Item.Id = "
									+ box.getInt("itemId")
									+ "  and inp.Lcat!='0' order by inp.Lcat ");
					// //System.out.println("sizeof commbid
					// "+storeTenderCommBidTList.size());
					// //System.out.println("itemid
					// "+box.getInt("itemId")+"tenderId
					// "+box.getInt(TENDER_NO));
					map.put("storeTenderCommBidTList", storeTenderCommBidTList);
				} catch (Exception e) {
					e.printStackTrace();
				}
				//System.out.println("in ");
			}

			map.put("employeeList", employeeList);
			map.put("note_no", ++note_no);
			map.put("existingNoteList", existingNoteList);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> getItemListForAutocomplete(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List objectList = new ArrayList();
		List objectList1 = new ArrayList();
		String itemField = box.get("requiredField");
		String autoHint = box.get(itemField);
		try {
			String str = "%" + autoHint + "%";
			String qry = "SELECT item_id FROM store_tender_t where tender_m_id="
					+ box.getInt("tenderId") + ";";
			objectList = (List) session.createSQLQuery(qry).list();
			String qry1 = "select a.item_id from store_tender_local_purchase_t a, store_tender_local_purchase_m b where a.store_tender_local_purchase_m_id = b.id and b.tender_id = "
					+ box.getInt("tenderId")
					+ " and b.note_no="
					+ box.getInt("noteNo") + ";";
			objectList1 = (List) session.createSQLQuery(qry1).list();
			if (objectList1 != null && objectList1.size() > 0) {
				Criteria c = session.createCriteria(MasStoreItem.class).add(
						Restrictions.like("Nomenclature", str)).add(
						Restrictions.eq("Department.Id", box.getInt("deptId")))
						.add(Restrictions.in("Id", objectList)).add(
								Restrictions.not(Restrictions.in("Id",
										objectList1)));
				c.setFirstResult(0);
				c.setMaxResults(10);
				itemList = c.list();
			} else {
				Criteria c = session.createCriteria(MasStoreItem.class).add(
						Restrictions.like("Nomenclature", str)).add(
						Restrictions.eq("Department.Id", box.getInt("deptId")))
						.add(Restrictions.in("Id", objectList));
				c.setFirstResult(0);
				c.setMaxResults(10);
				itemList = c.list();
			}

			map.put("itemList", itemList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	public Map<String, Object> populateSupplierInTenderLPO(Box box)
	// TODO Auto-generated method stub
	{
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> masStoreItemList = new ArrayList<MasStoreItem>();
		List<StoreTenderCommBidT> storeTenderCommBidTList = new ArrayList<StoreTenderCommBidT>();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			int item_id = 0;
			masStoreItemList = hbt
					.find("from jkt.hms.masters.business.MasStoreItem  as inp where inp.PvmsNo ='"
							+ box.getString("pvms") + "'");
			if (masStoreItemList != null && masStoreItemList.size() > 0)
				item_id = masStoreItemList.get(0).getId();
			storeTenderCommBidTList = hbt
					.find("from jkt.hms.masters.business.StoreTenderCommBidT as inp where inp.CommBid.Tender.Id="
							+ box.getInt("tenderId")
							+ " and inp.CommBid.Item.Id = "
							+ item_id
							+ "  and inp.Lcat!='0' order by inp.Lcat ");
			map.put("storeTenderCommBidTList", storeTenderCommBidTList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> addHODRecommendation(Box box) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			List<StoreTenderCommHodRecom> storeTenderCommHodRecomList = new ArrayList<StoreTenderCommHodRecom>();
			storeTenderCommHodRecomList = hbt
					.find("from jkt.hms.masters.business.StoreTenderCommHodRecom as inp order by inp.SrNo desc");
			int srno = 1;
			if (storeTenderCommHodRecomList != null
					&& storeTenderCommHodRecomList.size() > 0) {
				srno = storeTenderCommHodRecomList.get(0).getSrNo();
				srno++;
			}

			StoreTenderCommHodRecom storeTenderCommHodRecom = new StoreTenderCommHodRecom();
			storeTenderCommHodRecom.setSupplier(new MasStoreSupplier(box
					.getInt(TENDER_CB_HOD_SUPPLIER_ID)));
			storeTenderCommHodRecom.setSpecialist(new MasEmployee(box
					.getInt(TENDER_CB_HOD_SPECIALIST)));
			storeTenderCommHodRecom.setRemarks(box
					.getString(TENDER_CB_HOD_REMARKS));
			storeTenderCommHodRecom.setSrNo(srno);
			hbt.save(storeTenderCommHodRecom);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;
	}

	/*
	 * public Map<String, Object> generateLocalPurchaseOrder(Box box) { // TODO
	 * Auto-generated method stub
	 * 
	 * Map<String, Object> map = new HashMap<String, Object>();
	 * List<StoreTenderCommBidM> storeTenderCommBidMList = new
	 * ArrayList<StoreTenderCommBidM>(); List<StoreTenderCommBidT>
	 * storeTenderCommBidTList = new ArrayList<StoreTenderCommBidT>();
	 * List<StoreFyDocumentNo> storeFyDocumentNoList = new
	 * ArrayList<StoreFyDocumentNo>(); List<StorePoHeader> storePoHeaderList =
	 * new ArrayList<StorePoHeader>(); List<StorePoDetail> storePoDetailList =
	 * new ArrayList<StorePoDetail>(); List<StoreTenderT> storeTenderTList = new
	 * ArrayList<StoreTenderT>(); StoreTenderCommBidM storeTenderCommBidM = new
	 * StoreTenderCommBidM(); StoreTenderCommBidT storeTenderCommBidT = new
	 * StoreTenderCommBidT(); StorePoHeader storePoHeader = new StorePoHeader();
	 * StorePoDetail storePoDetail = new StorePoDetail(); Session session =
	 * (Session)getSession(); Transaction transaction = null; try {
	 * 
	 * org.springframework.orm.hibernate3.HibernateTemplate hbt =
	 * getHibernateTemplate(); hbt.setFlushModeName("FLUSH_EAGER");
	 * hbt.setCheckWriteOperations(false); transaction =
	 * session.beginTransaction(); int tender_id = box.getInt(TENDER_NO); int
	 * group_id = box.getInt(TENDER_SUPPLIER_GROUP_ID); int dept_id =
	 * box.getInt("deptId"); //change status to "p" coz LPO order data will be
	 * stored in StorePoHeader & Detail storeTenderCommBidMList = hbt.find("from
	 * jkt.hms.masters.business.StoreTenderCommBidM as inp where inp.Tender.Id="
	 * + tender_id + " and inp.Group.Id= " + group_id +
	 * " and inp.Department.Id = " + dept_id ); for (Iterator iterator =
	 * storeTenderCommBidMList.iterator(); iterator.hasNext();) {
	 * storeTenderCommBidM = (StoreTenderCommBidM) iterator.next();
	 * storeTenderCommBidM.setStatus("p"); hbt.update(storeTenderCommBidM); }
	 * 
	 * storeTenderCommBidTList = hbt.find("from
	 * jkt.hms.masters.business.StoreTenderCommBidT as inp where
	 * inp.CommBid.Tender.Id=" + tender_id + " and inp.CommBid.Group.Id= " +
	 * group_id + " and inp.CommBid.Department.Id = " + dept_id + " and inp.Lcat
	 * = 1 " + " order by Supplier.Id "); int old_supplier_id = 0; int
	 * new_supplier_id = 0; int serial_no = 0; int po_id = 0; int item_id = 0;
	 * BigDecimal tender_qty = new BigDecimal(0); BigDecimal req_qty = new
	 * BigDecimal(0); BigDecimal amount = new BigDecimal(0); BigDecimal
	 * taxpercent = new BigDecimal(0); BigDecimal mrp = new BigDecimal(0);
	 * BigDecimal otherTaxes = new BigDecimal(0); BigDecimal taxamount = new
	 * BigDecimal(0); BigDecimal finalamount = new BigDecimal(0); BigDecimal
	 * totalHeaderAmount = new BigDecimal(0); BigDecimal poAmount = null;
	 * java.util.Date poDate = null;
	 * 
	 * 
	 * if (storeTenderCommBidTList!=null && storeTenderCommBidTList.size() > 0)
	 * { old_supplier_id =storeTenderCommBidTList.get(0).getSupplier().getId();
	 * }
	 * 
	 * for (Iterator iterator = storeTenderCommBidTList.iterator();
	 * iterator.hasNext();) { storeTenderCommBidT = (StoreTenderCommBidT)
	 * iterator.next(); new_supplier_id =
	 * storeTenderCommBidT.getSupplier().getId();
	 * 
	 * if (old_supplier_id != new_supplier_id) { if (storePoHeaderList!=null &&
	 * storePoHeaderList.size()>0) //save the records from List { //Save
	 * StorePoHeader record storePoHeader = storePoHeaderList.get(0);
	 * storePoHeader.setNetAmount(totalHeaderAmount); poDate =
	 * storePoHeader.getPoDate(); poAmount = totalHeaderAmount;
	 * storePoHeader.setTenderM(new StoreTenderM(tender_id));
	 * storePoHeader.setGroup(new MasStoreGroup(group_id));
	 * hbt.save(storePoHeader); po_id = storePoHeader.getId();
	 * 
	 * //Save StorePoDetail records if (storePoDetailList!=null &&
	 * storePoDetailList.size()>0) { for (Iterator iterator2 =
	 * storePoDetailList.iterator(); iterator2.hasNext();) { storePoDetail =
	 * (StorePoDetail) iterator2.next(); storePoDetail.setPo(new
	 * StorePoHeader(po_id)); hbt.save(storePoDetail); } } storePoHeaderList =
	 * new ArrayList<StorePoHeader>(); storePoDetailList = new
	 * ArrayList<StorePoDetail>(); totalHeaderAmount = new BigDecimal(0);
	 * 
	 * 
	 * //Update MasStoreBudget Master record List<MasStoreFinancial>
	 * masStoreFinancialList = new ArrayList<MasStoreFinancial>();
	 * masStoreFinancialList =
	 * session.createCriteria(MasStoreFinancial.class).list(); java.util.Date
	 * start_date = null; java.util.Date end_date = null; int financial_id = 0;
	 * for (Iterator iterator2 = masStoreFinancialList.iterator();
	 * iterator2.hasNext();) { MasStoreFinancial masStoreFinancial =
	 * (MasStoreFinancial) iterator2.next(); start_date =
	 * (java.util.Date)masStoreFinancial.getStartDate(); end_date =
	 * (java.util.Date)masStoreFinancial.getEndDate(); if
	 * (poDate.after(start_date) && poDate.before(end_date)) { financial_id =
	 * masStoreFinancial.getId(); break; } else if (poDate.equals(start_date) ||
	 * poDate.equals(end_date)) { financial_id = masStoreFinancial.getId();
	 * break; } }
	 * 
	 * 
	 * List<MasStoreBudget> masStoreBudgetList = new
	 * ArrayList<MasStoreBudget>(); masStoreBudgetList =
	 * session.createCriteria(MasStoreBudget
	 * .class).add(Restrictions.eq("Financial.Id", financial_id)).list();
	 * BigDecimal existing_committed_amount = null; if (masStoreBudgetList!=null
	 * && masStoreBudgetList.size()>0) { MasStoreBudget masStoreBudget =
	 * masStoreBudgetList.get(0); try { existing_committed_amount = new
	 * BigDecimal(masStoreBudget.getPoComittedAmount()); } catch(Exception e) {
	 * existing_committed_amount = new BigDecimal(0); }
	 * 
	 * 
	 * masStoreBudget.setPoComittedAmount(existing_committed_amount.add(poAmount)
	 * .floatValue()); hbt.update(masStoreBudget); }
	 * 
	 * }// end -- if (storePoHeaderList!=null && storePoHeaderList.size()>0)
	 * 
	 * storePoHeader = new StorePoHeader();
	 * storePoHeader.setPoDate(HMSUtil.convertStringTypeDateToDateType
	 * (box.get(CHANGED_DATE)));
	 * storePoHeader.setPoTime(box.getString(CHANGED_TIME));
	 * storePoHeader.setQuotationNumber
	 * (storeTenderCommBidT.getCommBid().getTender().getTenderNo());
	 * storePoHeader.setDepartment(new MasDepartment(dept_id));
	 * storePoHeader.setSupplier(new MasStoreSupplier(new_supplier_id));
	 * storePoHeader
	 * .setDeliveryDate(HMSUtil.convertStringTypeDateToDateType(box.
	 * get(CHANGED_DATE))); storePoHeader.setLastChgBy(box.get(CHANGED_BY));
	 * storePoHeader
	 * .setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.get
	 * (CHANGED_DATE)));
	 * storePoHeader.setLastChgTime(box.getString(CHANGED_TIME));
	 * storePoHeader.setStatus("o");
	 * storePoHeader.setQuotationDate(storeTenderCommBidT
	 * .getCommBid().getTender().getTenderInvitationDate());
	 * storePoHeader.setRemarks(""); storePoHeader.setPayTerms("");
	 * storePoHeader.setDeliveryTerms("");
	 * storePoHeader.setApprovalAuthority("");
	 * storePoHeader.setSigningAuthority("");
	 * 
	 * storeFyDocumentNoList = hbt.find("from
	 * jkt.hms.masters.business.StoreFyDocumentNo as inp where inp.Department.Id
	 * = "+ dept_id); String no = ""; if(storeFyDocumentNoList != null &&
	 * storeFyDocumentNoList.size() > 0) { StoreFyDocumentNo storeFyDocumentNo =
	 * (StoreFyDocumentNo)storeFyDocumentNoList.get(0);
	 * no=(""+storeFyDocumentNo.getPoNo());
	 * storeFyDocumentNo.setPoNo(getMaxNo(no)); hbt.update(storeFyDocumentNo);
	 * hbt.refresh(storeFyDocumentNo); }
	 * storePoHeader.setPoNumber(getMaxNo(no));
	 * storePoHeaderList.add(storePoHeader); hbt.save(storePoHeader); po_id =
	 * storePoHeader.getId(); hbt.refresh(storePoHeader); serial_no = 1; } //end
	 * -- if (old_supplier_id != new_supplier_id)
	 * 
	 * BigDecimal finalRatePerMdq = new BigDecimal(0); item_id =
	 * storeTenderCommBidT.getCommBid().getItem().getId(); storeTenderTList =
	 * hbt.find("from jkt.hms.masters.business.StoreTenderT as inp where
	 * inp.TenderM.Department.Id = "+ dept_id + " and inp.TenderM.Id = " +
	 * tender_id + " and inp.Item.Id = " + item_id); if (storeTenderTList!=null
	 * && storeTenderTList.size()>0) { tender_qty =
	 * storeTenderTList.get(0).getTenderQty(); req_qty = tender_qty; }
	 * 
	 * try { if (storeTenderCommBidT.getFinalPricePerMdq()!=null &&
	 * storeTenderCommBidT.getFinalPricePerMdq().doubleValue() > 0 ) {
	 * BigDecimal bb = new
	 * BigDecimal(storeTenderCommBidT.getFinalPricePerMdq().doubleValue() /
	 * storeTenderCommBidT.getMdqValue().intValue(),new MathContext(4));
	 * //System.out.println("bb "+ bb); amount = req_qty.multiply(bb);
	 * finalRatePerMdq = storeTenderCommBidT.getFinalPricePerMdq(); } else {
	 * BigDecimal bb = new
	 * BigDecimal(storeTenderCommBidT.getFinalPricePerMdq().doubleValue() /
	 * storeTenderCommBidT.getMdqValue().intValue(),new MathContext(4));
	 * //System.out.println("bb "+ bb); amount = req_qty.multiply(bb);
	 * finalRatePerMdq = storeTenderCommBidT.getRatePerMdq(); } }
	 * catch(Exception e) { e.printStackTrace(); amount = new BigDecimal(0); }
	 * 
	 * 
	 * try { taxpercent = storeTenderCommBidT.getVatPercent().divide(new
	 * BigDecimal(100)); } catch(Exception e) { e.printStackTrace(); taxpercent
	 * = new BigDecimal(0); }
	 * 
	 * try { BigDecimal b1 = new BigDecimal(0); BigDecimal vat = new
	 * BigDecimal(0); b1 = storeTenderCommBidT.getMrp().divide(new
	 * BigDecimal(storeTenderCommBidT.getMdqValue()),new MathContext(4)); b1 =
	 * b1.multiply(req_qty); vat =
	 * storeTenderCommBidT.getVatPercent().divide(new BigDecimal(100));
	 * taxamount = b1.multiply(vat); } catch(Exception e) { e.printStackTrace();
	 * taxamount = new BigDecimal(0); }
	 * 
	 * try { finalamount = amount.add(taxamount); } catch(Exception e) {
	 * e.printStackTrace(); finalamount = new BigDecimal(0); }
	 * 
	 * 
	 * try { totalHeaderAmount = totalHeaderAmount.add(finalamount); }
	 * catch(Exception e) { e.printStackTrace(); totalHeaderAmount = new
	 * BigDecimal(0); }
	 * 
	 * 
	 * try { mrp = storeTenderCommBidT.getMrp(); } catch(Exception e) {
	 * e.printStackTrace(); mrp = new BigDecimal(0); }
	 * 
	 * storePoDetail = new StorePoDetail();
	 * storePoDetail.setItem(storeTenderCommBidT.getCommBid().getItem());
	 * storePoDetail.setUnitRate(finalRatePerMdq.divide(new
	 * BigDecimal(storeTenderCommBidT.getMdqValue()),new MathContext(4)));
	 * storePoDetail.setQuantityOrdered(req_qty);
	 * storePoDetail.setQuantityReceived(new BigDecimal(0));
	 * storePoDetail.setFreeQuantity(new BigDecimal(0));
	 * storePoDetail.setDiscountPercent(new BigDecimal(0));
	 * storePoDetail.setDiscountAmount(new BigDecimal(0));
	 * storePoDetail.setTaxAmount(new BigDecimal(0));
	 * storePoDetail.setTaxPercent(storeTenderCommBidT.getVatPercent());
	 * storePoDetail.setAmount(finalamount);
	 * storePoDetail.setSerialNo(serial_no++);
	 * storePoDetail.setDispType(storeTenderCommBidT.getDispType());
	 * storePoDetail.setMdqValue(storeTenderCommBidT.getMdqValue());
	 * storePoDetail.setRatePerMdq(finalRatePerMdq);
	 * storePoDetail.setFreeItem("n"); storePoDetail.setMrp(mrp);
	 * storePoDetail.setOtherTaxes(new BigDecimal(0));
	 * storePoDetailList.add(storePoDetail); old_supplier_id = new_supplier_id;
	 * } //CommBidTList for loop ends here
	 * 
	 * 
	 * if (storePoHeaderList!=null && storePoHeaderList.size()>0) //save the
	 * records from List { storePoHeader = storePoHeaderList.get(0);
	 * storePoHeader.setNetAmount(totalHeaderAmount); poDate =
	 * storePoHeader.getPoDate(); poAmount = totalHeaderAmount;
	 * storePoHeader.setTenderM(new StoreTenderM(tender_id));
	 * storePoHeader.setGroup(new MasStoreGroup(group_id));
	 * hbt.save(storePoHeader); po_id = storePoHeader.getId();
	 * 
	 * if (storePoDetailList!=null && storePoDetailList.size()>0) { for
	 * (Iterator iterator2 = storePoDetailList.iterator(); iterator2.hasNext();)
	 * { storePoDetail = (StorePoDetail) iterator2.next();
	 * storePoDetail.setPo(new StorePoHeader(po_id)); hbt.save(storePoDetail); }
	 * } totalHeaderAmount = new BigDecimal(0); storePoHeaderList = new
	 * ArrayList<StorePoHeader>(); storePoDetailList = new
	 * ArrayList<StorePoDetail>();
	 * 
	 * //Update MasStoreBudget Master record List<MasStoreFinancial>
	 * masStoreFinancialList = new ArrayList<MasStoreFinancial>();
	 * masStoreFinancialList =
	 * session.createCriteria(MasStoreFinancial.class).list(); java.util.Date
	 * start_date = null; java.util.Date end_date = null; int financial_id = 0;
	 * for (Iterator iterator2 = masStoreFinancialList.iterator();
	 * iterator2.hasNext();) { MasStoreFinancial masStoreFinancial =
	 * (MasStoreFinancial) iterator2.next(); start_date =
	 * (java.util.Date)masStoreFinancial.getStartDate(); end_date =
	 * (java.util.Date)masStoreFinancial.getEndDate(); if
	 * (poDate.after(start_date) && poDate.before(end_date)) { financial_id =
	 * masStoreFinancial.getId(); break; } else if (poDate.equals(start_date) ||
	 * poDate.equals(end_date)) { financial_id = masStoreFinancial.getId();
	 * break; } }
	 * 
	 * 
	 * List<MasStoreBudget> masStoreBudgetList = new
	 * ArrayList<MasStoreBudget>(); masStoreBudgetList =
	 * session.createCriteria(MasStoreBudget
	 * .class).add(Restrictions.eq("Financial.Id", financial_id)).list();
	 * BigDecimal existing_committed_amount = null; if (masStoreBudgetList!=null
	 * && masStoreBudgetList.size()>0) { MasStoreBudget masStoreBudget =
	 * masStoreBudgetList.get(0); try { existing_committed_amount = new
	 * BigDecimal(masStoreBudget.getPoComittedAmount()); } catch(Exception e) {
	 * existing_committed_amount = new BigDecimal(0); }
	 * 
	 * 
	 * masStoreBudget.setPoComittedAmount(existing_committed_amount.add(poAmount)
	 * .floatValue()); hbt.update(masStoreBudget); } } //save records from list
	 * ends here transaction.commit(); } catch(HibernateException e) {
	 * e.printStackTrace(); if (transaction!=null) transaction.rollback(); } map
	 * = getTenderPNCGrid(box); return map; }
	 */

	public Map<String, Object> generateLocalPurchaseOrderProcess(Box box) {
		// TODO Auto-generated method stub

		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreTenderCommBidM> storeTenderCommBidMList = new ArrayList<StoreTenderCommBidM>();
		List<StoreTenderCommBidT> storeTenderCommBidTList = new ArrayList<StoreTenderCommBidT>();
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		List<StorePoHeader> storePoHeaderList = new ArrayList<StorePoHeader>();
		List<StorePoDetail> storePoDetailList = new ArrayList<StorePoDetail>();
		StoreTenderCommBidM storeTenderCommBidM = new StoreTenderCommBidM();
		StoreTenderCommBidT storeTenderCommBidT = new StoreTenderCommBidT();
		StorePoHeader storePoHeader = new StorePoHeader();
		StorePoDetail storePoDetail = new StorePoDetail();
		Session session = (Session) getSession();
		Transaction transaction = null;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			transaction = session.beginTransaction();
			int tender_id = box.getInt(TENDER_NO);
			int group_id = box.getInt(TENDER_SUPPLIER_GROUP_ID);
			int dept_id = box.getInt("deptId");
			// change status to "p" coz LPO order data will be stored in
			// StorePoHeader & Detail
			storeTenderCommBidMList = hbt
					.find("from jkt.hms.masters.business.StoreTenderCommBidM as inp where inp.Tender.Id="
							+ tender_id + " and inp.Group.Id= " + group_id);

			for (Iterator iterator = storeTenderCommBidMList.iterator(); iterator
					.hasNext();) {
				storeTenderCommBidM = (StoreTenderCommBidM) iterator.next();
				storeTenderCommBidM.setStatus("p");
				hbt.update(storeTenderCommBidM);
			}

			storeTenderCommBidTList = hbt
					.find("from jkt.hms.masters.business.StoreTenderCommBidT as inp where inp.CommBid.Tender.Id="
							+ tender_id
							+ " and inp.CommBid.Group.Id= "
							+ group_id
							+ " and inp.Lcat = 1 "
							+ " order by Supplier.Id ");
			int old_supplier_id = 0;
			int new_supplier_id = 0;
			int serial_no = 0;
			int po_id = 0;
			int item_id = 0;
			BigDecimal tender_qty = new BigDecimal(0);
			BigDecimal req_qty = new BigDecimal(0);
			BigDecimal amount = new BigDecimal(0);
			BigDecimal taxpercent = new BigDecimal(0);
			BigDecimal mrp = new BigDecimal(0);
			BigDecimal otherTaxes = new BigDecimal(0);
			BigDecimal taxamount = new BigDecimal(0);
			BigDecimal finalamount = new BigDecimal(0);
			BigDecimal totalHeaderAmount = new BigDecimal(0);
			BigDecimal poAmount = null;
			java.util.Date poDate = null;

			if (storeTenderCommBidTList != null
					&& storeTenderCommBidTList.size() > 0) {
				old_supplier_id = storeTenderCommBidTList.get(0).getSupplier()
						.getId();
			}

			for (Iterator iterator = storeTenderCommBidTList.iterator(); iterator
					.hasNext();) {
				storeTenderCommBidT = (StoreTenderCommBidT) iterator.next();
				new_supplier_id = storeTenderCommBidT.getSupplier().getId();

				if (old_supplier_id != new_supplier_id) {
					if (storePoHeaderList != null
							&& storePoHeaderList.size() > 0) // save the records
																// from List
					{
						// Save StorePoHeader record
						storePoHeader = storePoHeaderList.get(0);
						storePoHeader.setNetAmount(totalHeaderAmount);
						poDate = storePoHeader.getPoDate();
						poAmount = totalHeaderAmount;
						storePoHeader.setTenderM(new StoreTenderM(tender_id));
						storePoHeader.setGroup(new MasStoreGroup(group_id));
						hbt.save(storePoHeader);
						po_id = storePoHeader.getId();

						// Save StorePoDetail records
						if (storePoDetailList != null
								&& storePoDetailList.size() > 0) {
							for (Iterator iterator2 = storePoDetailList
									.iterator(); iterator2.hasNext();) {
								storePoDetail = (StorePoDetail) iterator2
										.next();
								storePoDetail.setPo(new StorePoHeader(po_id));
								hbt.save(storePoDetail);
							}
						}
						storePoHeaderList = new ArrayList<StorePoHeader>();
						storePoDetailList = new ArrayList<StorePoDetail>();
						totalHeaderAmount = new BigDecimal(0);

						// Update MasStoreBudget Master record
						List<MasStoreFinancial> masStoreFinancialList = new ArrayList<MasStoreFinancial>();
						masStoreFinancialList = session.createCriteria(
								MasStoreFinancial.class).list();
						java.util.Date start_date = null;
						java.util.Date end_date = null;
						int financial_id = 0;
						for (Iterator iterator2 = masStoreFinancialList
								.iterator(); iterator2.hasNext();) {
							MasStoreFinancial masStoreFinancial = (MasStoreFinancial) iterator2
									.next();
							start_date = (java.util.Date) masStoreFinancial
									.getStartDate();
							end_date = (java.util.Date) masStoreFinancial
									.getEndDate();
							if (poDate.after(start_date)
									&& poDate.before(end_date)) {
								financial_id = masStoreFinancial.getId();
								break;
							} else if (poDate.equals(start_date)
									|| poDate.equals(end_date)) {
								financial_id = masStoreFinancial.getId();
								break;
							}
						}

						// should not be add to BudgetMaster
						/*
						 * List<MasStoreBudget> masStoreBudgetList = new
						 * ArrayList<MasStoreBudget>(); masStoreBudgetList =
						 * session.createCriteria( MasStoreBudget.class).add(
						 * Restrictions.eq("Financial.Id", financial_id))
						 * .list(); BigDecimal existing_committed_amount = null;
						 * if (masStoreBudgetList != null &&
						 * masStoreBudgetList.size() > 0) { MasStoreBudget
						 * masStoreBudget = masStoreBudgetList .get(0); try {
						 * existing_committed_amount = masStoreBudget
						 * .getPoComittedAmount(); } catch (Exception e) {
						 * existing_committed_amount = new BigDecimal(0); }
						 * 
						 * masStoreBudget
						 * .setPoComittedAmount(existing_committed_amount
						 * .add(poAmount)); hbt.update(masStoreBudget); }
						 */

					}// end -- if (storePoHeaderList!=null &&
					// storePoHeaderList.size()>0)

					storePoHeader = new StorePoHeader();
					storePoHeader.setPoDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(CHANGED_DATE)));
					storePoHeader.setPoTime(box.getString(CHANGED_TIME));
					storePoHeader.setQuotationNumber(storeTenderCommBidT
							.getCommBid().getTender().getTenderNo());
					storePoHeader.setDepartment(new MasDepartment(dept_id));
					storePoHeader.setSupplier(new MasStoreSupplier(
							new_supplier_id));
					storePoHeader.setDeliveryDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(CHANGED_DATE)));
					storePoHeader.setLastChgBy(box.get(CHANGED_BY));
					storePoHeader.setLastChgDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(CHANGED_DATE)));
					storePoHeader.setLastChgTime(box.getString(CHANGED_TIME));
					storePoHeader.setStatus("o");
					storePoHeader
							.setQuotationDate(storeTenderCommBidT.getCommBid()
									.getTender().getTenderInvitationDate());
					storePoHeader.setRemarks("");
					storePoHeader.setPayTerms("");
					storePoHeader.setDeliveryTerms("");
					storePoHeader.setApprovalAuthority("");
					storePoHeader.setSigningAuthority("");

					storeFyDocumentNoList = hbt
							.find("from jkt.hms.masters.business.StoreFyDocumentNo as inp where inp.Department.Id = "
									+ dept_id);
					String no = "";
					if (storeFyDocumentNoList != null
							&& storeFyDocumentNoList.size() > 0) {
						StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) storeFyDocumentNoList
								.get(0);
						no = ("" + storeFyDocumentNo.getPoNo());
						storeFyDocumentNo.setPoNo(getMaxNo(no));
						hbt.update(storeFyDocumentNo);
						hbt.refresh(storeFyDocumentNo);
					}
					storePoHeader.setPoNumber(getMaxNo(no));
					storePoHeaderList.add(storePoHeader);
					hbt.save(storePoHeader);
					po_id = storePoHeader.getId();
					hbt.refresh(storePoHeader);
					serial_no = 1;
				} // end -- if (old_supplier_id != new_supplier_id)

				BigDecimal finalRatePerMdq = new BigDecimal(0);
				item_id = storeTenderCommBidT.getCommBid().getItem().getId();
				List<StoreTenderProposal> storeTenderProposalList = new ArrayList<StoreTenderProposal>();
				storeTenderProposalList = hbt
						.find("from jkt.hms.masters.business.StoreTenderProposal as inp where inp.Department.Id = "
								+ dept_id
								+ " and inp.TenderId.Id = "
								+ tender_id + " and inp.Item.Id = " + item_id);
				if (storeTenderProposalList != null
						&& storeTenderProposalList.size() > 0) {
					tender_qty = storeTenderProposalList.get(0).getTenderQty();
					req_qty = tender_qty;
				}

				try {
					if (storeTenderCommBidT.getFinalPricePerMdq() != null
							&& storeTenderCommBidT.getFinalPricePerMdq()
									.doubleValue() > 0) {
						BigDecimal bb = new BigDecimal(storeTenderCommBidT
								.getFinalPricePerMdq().doubleValue()
								/ storeTenderCommBidT.getMdqValue().intValue(),
								new MathContext(4));
						amount = req_qty.multiply(bb);
						finalRatePerMdq = storeTenderCommBidT
								.getFinalPricePerMdq();
					} else {
						BigDecimal bb = new BigDecimal(storeTenderCommBidT
								.getFinalPricePerMdq().doubleValue()
								/ storeTenderCommBidT.getMdqValue().intValue(),
								new MathContext(4));
						amount = req_qty.multiply(bb);
						finalRatePerMdq = storeTenderCommBidT.getRatePerMdq();
					}

				} catch (Exception e) {
					e.printStackTrace();
					amount = new BigDecimal(0);
				}

				try {
					taxpercent = storeTenderCommBidT.getVatPercent().divide(
							new BigDecimal(100));
				} catch (Exception e) {
					e.printStackTrace();
					taxpercent = new BigDecimal(0);
				}

				try {
					BigDecimal b1 = new BigDecimal(0);
					BigDecimal vat = new BigDecimal(0);
					b1 = storeTenderCommBidT.getMrp().divide(
							storeTenderCommBidT.getMdqValue(),
							new MathContext(4));
					b1 = b1.multiply(req_qty);
					vat = storeTenderCommBidT.getVatPercent().divide(
							new BigDecimal(100));
					taxamount = b1.multiply(vat);
				} catch (Exception e) {
					e.printStackTrace();
					taxamount = new BigDecimal(0);
				}

				try {
					// finalamount = amount.add(taxamount);
					finalamount = amount;
				} catch (Exception e) {
					e.printStackTrace();
					finalamount = new BigDecimal(0);
				}

				try {
					totalHeaderAmount = totalHeaderAmount.add(finalamount);
				} catch (Exception e) {
					e.printStackTrace();
					totalHeaderAmount = new BigDecimal(0);
				}

				try {
					mrp = storeTenderCommBidT.getMrp();
				} catch (Exception e) {
					e.printStackTrace();
					mrp = new BigDecimal(0);
				}

				storePoDetail = new StorePoDetail();
				storePoDetail.setItem(storeTenderCommBidT.getCommBid()
						.getItem());
				storePoDetail.setUnitRate(finalRatePerMdq.divide(
						storeTenderCommBidT.getMdqValue(), new MathContext(4)));
				storePoDetail.setQuantityOrdered(req_qty);
				storePoDetail.setQuantityReceived(new BigDecimal(0));
				storePoDetail.setFreeQuantity(new BigDecimal(0));
				storePoDetail.setDiscountPercent(new BigDecimal(0));
				storePoDetail.setDiscountAmount(new BigDecimal(0));
				storePoDetail.setTaxAmount(taxamount);
				storePoDetail
						.setTaxPercent(storeTenderCommBidT.getVatPercent());
				storePoDetail.setAmount(finalamount);
				storePoDetail.setSerialNo(serial_no++);
				storePoDetail.setDispType(storeTenderCommBidT.getDispType());
				storePoDetail.setMdqValue(storeTenderCommBidT.getMdqValue());
				storePoDetail.setRatePerMdq(finalRatePerMdq);
				storePoDetail.setFreeItem("n");
				storePoDetail.setMrp(mrp);
				storePoDetail.setOtherTaxes("");
				storePoDetailList.add(storePoDetail);
				old_supplier_id = new_supplier_id;
			} // CommBidTList for loop ends here

			if (storePoHeaderList != null && storePoHeaderList.size() > 0) // save
																			// the
																			// records
																			// from
																			// List
			{
				storePoHeader = storePoHeaderList.get(0);
				storePoHeader.setNetAmount(totalHeaderAmount);
				poDate = storePoHeader.getPoDate();
				poAmount = totalHeaderAmount;
				storePoHeader.setTenderM(new StoreTenderM(tender_id));
				storePoHeader.setGroup(new MasStoreGroup(group_id));
				hbt.save(storePoHeader);
				po_id = storePoHeader.getId();

				if (storePoDetailList != null && storePoDetailList.size() > 0) {
					for (Iterator iterator2 = storePoDetailList.iterator(); iterator2
							.hasNext();) {
						storePoDetail = (StorePoDetail) iterator2.next();
						storePoDetail.setPo(new StorePoHeader(po_id));
						hbt.save(storePoDetail);
					}
				}
				totalHeaderAmount = new BigDecimal(0);
				storePoHeaderList = new ArrayList<StorePoHeader>();
				storePoDetailList = new ArrayList<StorePoDetail>();

				// Update MasStoreBudget Master record
				List<MasStoreFinancial> masStoreFinancialList = new ArrayList<MasStoreFinancial>();
				masStoreFinancialList = session.createCriteria(
						MasStoreFinancial.class).list();
				java.util.Date start_date = null;
				java.util.Date end_date = null;
				int financial_id = 0;
				for (Iterator iterator2 = masStoreFinancialList.iterator(); iterator2
						.hasNext();) {
					MasStoreFinancial masStoreFinancial = (MasStoreFinancial) iterator2
							.next();
					start_date = (java.util.Date) masStoreFinancial
							.getStartDate();
					end_date = (java.util.Date) masStoreFinancial.getEndDate();
					if (poDate.after(start_date) && poDate.before(end_date)) {
						financial_id = masStoreFinancial.getId();
						break;
					} else if (poDate.equals(start_date)
							|| poDate.equals(end_date)) {
						financial_id = masStoreFinancial.getId();
						break;
					}
				}

				// should not be add to the MasterBudget
				/*
				 * List<MasStoreBudget> masStoreBudgetList = new
				 * ArrayList<MasStoreBudget>(); masStoreBudgetList =
				 * session.createCriteria( MasStoreBudget.class).add(
				 * Restrictions.eq("Financial.Id", financial_id)).list();
				 * BigDecimal existing_committed_amount = null; if
				 * (masStoreBudgetList != null && masStoreBudgetList.size() > 0)
				 * { MasStoreBudget masStoreBudget = masStoreBudgetList.get(0);
				 * try { existing_committed_amount = masStoreBudget
				 * .getPoComittedAmount(); } catch (Exception e) {
				 * existing_committed_amount = new BigDecimal(0); }
				 * 
				 * masStoreBudget .setPoComittedAmount(existing_committed_amount
				 * .add(poAmount)); hbt.update(masStoreBudget); }
				 */

			} // save records from list ends here
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		}
		return map;
	}

	public Map<String, Object> generateLocalPurchaseOrder(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreSetup> storeSetupList = new ArrayList<StoreSetup>();
		StorePoHeader storePoHeader = null;
		StorePoDetail storePoDetail = null;
		Session session = (Session) getSession();
		BigDecimal net_amount = new BigDecimal(0);
		String tender_no = "";
		Date tender_date = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			Vector v = box.getVector(ITEMS_TO_BE_ADDED);
			String str = v.toString();
			String items = str.substring(1, str.length() - 1);
			items = "(" + items + ")";

			String query = "";
			query = query
					+ " select c.department_id, b.supplier_id, a.tender_id, a.group_id, a.item_id, ";
			query = query
					+ " case f.formula when 1 then truncate(((c.tender_qty * f.conversion_factor1) / b.mdq_value),0) else  c.tender_qty * f.conversion_factor1 end tender_qty, b.comp_rate, ";
			query = query
					+ " round(case f.formula when 1 then truncate(((c.tender_qty * f.conversion_factor1) / b.mdq_value),0) * b.new_totrate_mdq ";
			query = query
					+ " else  c.tender_qty * f.conversion_factor1 * b.new_totrate_mdq end,2) amount, ";
			query = query
					+ " ((b.mrp * b.vat_percent) / 100) tax_amount, b.vat_percent, b.disp_type, b.mdq_value, b.new_totrate_mdq, b.mrp, d.tender_no, d.tender_invitation_date,b.new_taxamt_per_mdq";
			query = query
					+ " from store_tender_comm_bid_m a, store_tender_comm_bid_t b, store_tender_proposal c, store_tender_m d, mas_store_item e, mas_store_item_conversion f ";
			query = query + " where a.id = b.comm_bid_id ";
			query = query + " and a.tender_id = d.id ";
			query = query + " and c.item_id = a.item_id ";
			query = query + " and a.item_id = e.item_id ";
			query = query + " and e.item_conversion_id = f.item_conversion_id ";
			query = query + " and c.department_id = " + box.getInt("dept_id");
			query = query + " and c.tender_id = " + box.getInt("tender_id");
			query = query + " and a.tender_id = " + box.getInt("tender_id");
			query = query + " and a.group_id = " + box.getInt("group_id");
			// query = query + " and b.lcat=1";
			query = query + " and b.supplier_id = " + box.getInt("supplier_id");
			query = query + " and a.item_id in " + items;

			List objectList = session.createSQLQuery(query).list();

			for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
				Object[] obj = (Object[]) iterator.next();
				tender_no = obj[14].toString();
				tender_date = (Date) obj[15];
				try {
					BigDecimal val = new BigDecimal(obj[7].toString());
					net_amount = net_amount.add(val);
				} catch (Exception e) {
					net_amount = net_amount.add(new BigDecimal(0));
				}
			}

			List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
			storeFyDocumentNoList = hbt
					.find("from jkt.hms.masters.business.StoreFyDocumentNo as inp where inp.Department.Id = "
							+ box.getInt("dept_id"));
			String no = "";
			if (storeFyDocumentNoList != null
					&& storeFyDocumentNoList.size() > 0) {
				StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) storeFyDocumentNoList
						.get(0);
				no = ("" + storeFyDocumentNo.getPoNo());
				storeFyDocumentNo.setPoNo(getMaxNo(no));
				hbt.update(storeFyDocumentNo);
				hbt.refresh(storeFyDocumentNo);
			}

			storePoHeader = new StorePoHeader();
			storePoHeader.setPoDate(HMSUtil.convertStringTypeDateToDateType(box
					.get(CHANGED_DATE)));
			storePoHeader.setPoTime(box.getString(CHANGED_TIME));
			storePoHeader.setQuotationNumber(tender_no);
			storePoHeader.setDepartment(new MasDepartment(box.getInt("dept_id")));
			storePoHeader.setSupplier(new MasStoreSupplier(box
					.getInt("supplier_id")));
			storePoHeader.setDeliveryDate(HMSUtil
					.convertStringTypeDateToDateType(box.get("delivery")));
			storePoHeader.setLastChgBy(box.get(CHANGED_BY));
			storePoHeader.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(box.get(CHANGED_DATE)));
			storePoHeader.setLastChgTime(box.getString(CHANGED_TIME));
			storePoHeader.setStatus("o");
			storePoHeader.setFlag("s");
			storePoHeader.setQuotationDate(tender_date);
			storePoHeader.setRemarks(box.getString("remarks"));
			storePoHeader.setPayTerms("");
			storePoHeader.setDeliveryTerms("");
			storePoHeader.setApprovalAuthority("");
			storePoHeader.setSigningAuthority("");
			storePoHeader.setTenderM(new StoreTenderM(box.getInt("tender_id")));
			storePoHeader.setGroup(new MasStoreGroup(box.getInt("group_id")));
			storePoHeader.setNetAmount(net_amount);
			storePoHeader.setPoNumber(getMaxNo(no));
			storePoHeader.setAppVide(box.getString("approval"));
			hbt.save(storePoHeader);
			hbt.refresh(storePoHeader);

			java.util.Date poDate = storePoHeader.getPoDate();
			// Update MasStoreBudget Master record
			List<MasStoreFinancial> masStoreFinancialList = new ArrayList<MasStoreFinancial>();
			masStoreFinancialList = session.createCriteria(
					MasStoreFinancial.class).list();
			java.util.Date start_date = null;
			java.util.Date end_date = null;
			int financial_id = 0;
			for (Iterator iterator2 = masStoreFinancialList.iterator(); iterator2
					.hasNext();) {
				MasStoreFinancial masStoreFinancial = (MasStoreFinancial) iterator2
						.next();
				start_date = (java.util.Date) masStoreFinancial.getStartDate();
				end_date = (java.util.Date) masStoreFinancial.getEndDate();
				if (poDate.after(start_date) && poDate.before(end_date)) {
					financial_id = masStoreFinancial.getId();
					break;
				} else if (poDate.equals(start_date) || poDate.equals(end_date)) {
					financial_id = masStoreFinancial.getId();
					break;
				}
			}
			// should not add to the master budget
			/*
			 * List<MasStoreBudget> masStoreBudgetList = new
			 * ArrayList<MasStoreBudget>(); masStoreBudgetList =
			 * session.createCriteria(MasStoreBudget.class)
			 * .add(Restrictions.eq("Financial.Id", financial_id)).list();
			 * BigDecimal existing_committed_amount = null; if
			 * (masStoreBudgetList != null && masStoreBudgetList.size() > 0) {
			 * MasStoreBudget masStoreBudget = masStoreBudgetList.get(0); try {
			 * existing_committed_amount = masStoreBudget
			 * .getPoComittedAmount(); } catch (Exception e) {
			 * existing_committed_amount = new BigDecimal(0); }
			 * masStoreBudget.setPoComittedAmount(existing_committed_amount
			 * .add(net_amount)); hbt.update(masStoreBudget); }
			 */
			int slno = 1;
			for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
				storePoDetail = new StorePoDetail();
				Object[] obj = (Object[]) iterator.next();
				storePoDetail.setAmount(new BigDecimal(obj[7].toString()));
				storePoDetail.setDispType(obj[10].toString());
				storePoDetail.setItem(new MasStoreItem(new Integer(obj[4]
						.toString())));
				storePoDetail.setMdqValue(new BigDecimal(obj[11].toString()));
				storePoDetail.setMrp(new BigDecimal(obj[13].toString()));
				storePoDetail.setPo(storePoHeader);
				storePoDetail.setQuantityOrdered(new BigDecimal(obj[5]
						.toString()));
				storePoDetail.setRatePerMdq(new BigDecimal(obj[12].toString()));
				storePoDetail.setSerialNo(slno++);
				storePoDetail.setTaxAmount(new BigDecimal(obj[8].toString()));
				storePoDetail.setTaxPercent(new BigDecimal(obj[9].toString()));
				storePoDetail.setUnitRate(new BigDecimal(obj[6].toString()));
				storePoDetail
						.setTaxAmtPerMdq(new BigDecimal(obj[16].toString()));
				hbt.save(storePoDetail);

				List<StoreTenderProposal> storeTenderProposalList = new ArrayList<StoreTenderProposal>();
				storeTenderProposalList = session.createCriteria(
						StoreTenderProposal.class).add(
						Restrictions.eq("TenderId.Id", new Integer(obj[2]
								.toString()))).add(
						Restrictions.eq("Item.Id", new Integer(obj[4]
								.toString()))).add(
						Restrictions.eq("Department.Id", new Integer(obj[0]
								.toString()))).list();

				if (storeTenderProposalList != null
						&& storeTenderProposalList.size() > 0) {
					StoreTenderProposal storeTenderProposal = storeTenderProposalList
							.get(0);
					storeTenderProposal.setPo(storePoHeader);
					hbt.update(storeTenderProposal);
				}

				List<StoreTenderCommBidT> storeTenderCommBidTList = new ArrayList<StoreTenderCommBidT>();
				storeTenderCommBidTList = session.createCriteria(
						StoreTenderCommBidT.class).createAlias("CommBid",
						"commbid").add(
						Restrictions.eq("commbid.Tender.Id", box
								.getInt("tender_id"))).add(
						Restrictions.eq("commbid.Group.Id", box
								.getInt("group_id"))).add(
						Restrictions.eq("Supplier.Id", box
								.getInt("supplier_id"))).add(
						Restrictions.eq("commbid.Item.Id", new Integer(obj[4]
								.toString()))).list();

				if (storeTenderCommBidTList != null
						&& storeTenderCommBidTList.size() > 0) {
					/*
					 * for (Iterator iterator =
					 * storeTenderCommBidTList.iterator(); iterator .hasNext();)
					 * {
					 */
					for (StoreTenderCommBidT storeTenderCommBidT : storeTenderCommBidTList) {
						StoreTenderCommBidM storeTenderCommBidM = storeTenderCommBidT
								.getCommBid();
						storeTenderCommBidM.setStatus("p");
						hbt.update(storeTenderCommBidM);
					}
				}
			}

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		map = getGroupAndTenderAndSupplierComboDetails(box);
		return map;
	}
	public Map<String, Object> searchForExistingNomenclature(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> masterDataMap = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;

		List objectList = new ArrayList();
		List objectList1 = new ArrayList();
		String itemField = box.get("requiredField");
		String pvmsNoField = box.get("pvmsNo");
		// //System.out.println("itemField "+itemField);
		// String autoHint = box.get(itemField);
		// //System.out.println("autoHint "+autoHint);
		try {
			String str = "%" + itemField + "%";
			String str1 = "%" + pvmsNoField + "%";
			String qry = "SELECT item_id FROM store_tender_t where tender_m_id="
					+ box.getInt(TENDER_NO) + ";";
			objectList = (List) session.createSQLQuery(qry).list();
			String qry1 = "select a.item_id from store_tender_local_purchase_t a, store_tender_local_purchase_m b where a.store_tender_local_purchase_m_id = b.id and b.tender_id = "
					+ box.getInt(TENDER_NO)
					+ " and b.dept_id='"
					+ box.getInt("deptId")
					+ "' and b.note_no="
					+ box.getInt(TENDER_LPO_NOTE_NO);
			//System.out.println("qrty" + qry1);
			objectList1 = (List) session.createSQLQuery(qry1).list();
			if (objectList1 != null && objectList1.size() > 0) {
				Criteria crit = null;
				crit = session.createCriteria(MasStoreItem.class).add(
						Restrictions.in("Id", objectList)).add(
						Restrictions.not(Restrictions.in("Id", objectList1)));
				if (pvmsNoField != "") {
					crit = crit.add(Restrictions.like("PvmsNo", str1));
				} else {
					crit = crit.add(Restrictions.like("Nomenclature", str));
				}

				// crit.setFirstResult(0);
				// crit.setMaxResults(15);
				itemList = crit.list();
			} else {
				Criteria crit = null;
				crit = session.createCriteria(MasStoreItem.class).add(
						Restrictions.in("Id", objectList));
				if (pvmsNoField != "") {
					crit = crit.add(Restrictions.like("PvmsNo", str1));
				} else {
					crit = crit.add(Restrictions.like("Nomenclature", str));
				}
				// crit.setFirstResult(0);
				// crit.setMaxResults(15);
				itemList = crit.list();
			}
			for (Iterator iterator = itemList.iterator(); iterator.hasNext();) {
				MasStoreItem masStoreItem = (MasStoreItem) iterator.next();
				int item_id = 0;
				String pvmsNo = null;
				String nomenclature = null;
				String au = null;

				pvmsNo = masStoreItem.getPvmsNo();
				item_id = masStoreItem.getId();
				nomenclature = masStoreItem.getNomenclature();

				if (masStoreItem.getItemConversion() != null) {
					au = masStoreItem.getItemConversion().getPurchaseUnit()
							.getUnitName();
				} else {
					au = "-";
				}
				hData = new HashMap<String, Object>();
				hData.put("itemId", item_id);
				hData.put(TENDER_LPO_PVMS_NO, pvmsNo);
				hData.put(TENDER_LPO_NOMENCLATURE, nomenclature);
				hData.put(TENDER_LPO_AU, au);
				vResult.add(hData);
			}
		} catch (Exception e) {
			e.printStackTrace();

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
		map.put("itemList", itemList);
		map.put("itemField", itemField);
		map.put("pvmsNoField", pvmsNoField);
		return map;
	}

	public Map<String, Object> createLPONoteMasterAndTransaction(Box box) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;
		StoreIndentT storeIndentT = null;
		StoreIndentM storeIndentM = null;
		int group_id = 0;
		int item_id = 0;
		int srNo = 0;

		List existingNoteList = null;
		Session session = (Session) getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			List<StoreTenderLocalPurchaseM> storeTenderLocalPurchaseMList = new ArrayList<StoreTenderLocalPurchaseM>();
			List<StoreTenderLocalPurchaseT> storeTenderLocalPurchaseTList = new ArrayList<StoreTenderLocalPurchaseT>();
			List<StoreTenderCommBidT> storeTenderCommBidTList = new ArrayList<StoreTenderCommBidT>();
			List<MasStoreItem> masStoreItemList = new ArrayList<MasStoreItem>();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			int note_no = box.getInt(TENDER_LPO_NOTE_NO);
			int dept_id = box.getInt("deptId");
			int tender_id = box.getInt(TENDER_NO);
			int hospital_id = box.getInt("hospitalId");
			int emp_id = box.getInt(TENDER_LPO_OIC);
			int master_id = 0;
			int supplier_id = box.getInt(TENDER_LPO_SUPPLIER_ID);

			// Get Item_Id from Nomenclature
			String nomen = box.getString(NAME_ITEM);
			int index1 = nomen.lastIndexOf("[");
			int index2 = nomen.lastIndexOf("]");
			index1++;
			String pvms = nomen.substring(index1, index2);
			masStoreItemList = hbt
					.find("from jkt.hms.masters.business.MasStoreItem  as inp where inp.PvmsNo = '"
							+ pvms + "'");
			if (masStoreItemList != null && masStoreItemList.size() > 0) {
				item_id = masStoreItemList.get(0).getId();
			}

			// Check Master Record Exists or Not

			storeTenderLocalPurchaseMList = hbt
					.find("from jkt.hms.masters.business.StoreTenderLocalPurchaseM as inp where inp.NoteNo = "
							+ note_no
							+ " and inp.Tender.Id = "
							+ box.getInt(TENDER_NO)
							+ " and inp.Department="
							+ box.getInt("deptId"));
			if (storeTenderLocalPurchaseMList != null
					&& storeTenderLocalPurchaseMList.size() > 0) // master
			// record
			// exists
			{
				master_id = storeTenderLocalPurchaseMList.get(0).getId();
				storeTenderLocalPurchaseTList = hbt
						.find("from jkt.hms.masters.business.StoreTenderLocalPurchaseT as inp where inp.StoreTenderLocalPurchaseM.Id = "
								+ master_id + " order by inp.SrNo desc");
				if (storeTenderLocalPurchaseTList != null
						&& storeTenderLocalPurchaseTList.size() > 0) {
					srNo = storeTenderLocalPurchaseTList.get(0).getSrNo();
				}
			} else {
				StoreTenderLocalPurchaseM storeTenderLocalPurchaseM = new StoreTenderLocalPurchaseM();
				storeTenderLocalPurchaseM.setDepartment(new MasDepartment(
						dept_id));
				storeTenderLocalPurchaseM.setHospital(new MasHospital(
						hospital_id));
				storeTenderLocalPurchaseM.setLastChgBy(box
						.getString(CHANGED_BY));
				storeTenderLocalPurchaseM.setLastChgDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString(CHANGED_DATE)));
				storeTenderLocalPurchaseM.setLastChgTime(box
						.getString(CHANGED_TIME));
				storeTenderLocalPurchaseM.setNoteDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString(TENDER_LPO_NOTE_DATE)));
				storeTenderLocalPurchaseM.setNoteNo(note_no);
				storeTenderLocalPurchaseM.setOic(new MasEmployee(emp_id));
				storeTenderLocalPurchaseM.setPeriod(box
						.getString(TENDER_LPO_NOTE_PERIOD));
				storeTenderLocalPurchaseM.setRemarks("");
				storeTenderLocalPurchaseM.setStatus("o");
				storeTenderLocalPurchaseM
						.setTender(new StoreTenderM(tender_id));
				hbt.save(storeTenderLocalPurchaseM);
				hbt.refresh(storeTenderLocalPurchaseM);
				master_id = storeTenderLocalPurchaseM.getId();
			}

			// Get Details from Commercial Bid Table
			storeTenderCommBidTList = hbt
					.find("from jkt.hms.masters.business.StoreTenderCommBidT as inp where inp.Supplier.Id = "
							+ supplier_id

							+ " and inp.CommBid.Tender.Id = "
							+ tender_id
							+ " and inp.CommBid.Item.Id = " + item_id);
			// cheack for existing trasaction not to insert
			List<StoreTenderLocalPurchaseT> existingTransactionList = new ArrayList<StoreTenderLocalPurchaseT>();

			existingTransactionList = session.createCriteria(
					StoreTenderLocalPurchaseT.class).createAlias(
					"StoreTenderLocalPurchaseM", "m").add(
					Restrictions.eq("m.Id", master_id)).list();
			boolean itemExist = false;

			if (storeTenderCommBidTList != null
					&& storeTenderCommBidTList.size() > 0) {
				StoreTenderCommBidT storeTenderCommBidT = storeTenderCommBidTList
						.get(0);

				StoreTenderLocalPurchaseT storeTenderLocalPurchaseT = new StoreTenderLocalPurchaseT();

				storeTenderLocalPurchaseT.setBrandName(storeTenderCommBidT
						.getBrandName());
				storeTenderLocalPurchaseT
						.setManufacturerName(storeTenderCommBidT
								.getManufacturerName());
				storeTenderLocalPurchaseT.setSupplier(new MasStoreSupplier(
						supplier_id));
				storeTenderLocalPurchaseT.setDispType(storeTenderCommBidT
						.getDispType());
				storeTenderLocalPurchaseT.setMdqValue(storeTenderCommBidT
						.getMdqValue());
				
				storeTenderLocalPurchaseT.setQtyRecd(box.getInt(TENDER_LPO_QUANTITY));
				storeTenderLocalPurchaseT.setNewRateMdq(storeTenderCommBidT
						.getNewRatePerMdq());
				storeTenderLocalPurchaseT.setNewTaxAmtMdq(storeTenderCommBidT
						.getNewTaxAmtPerMdq());

				BigDecimal final_price_per_mdq = new BigDecimal(0);
				BigDecimal price_per_mdq = new BigDecimal(0);
				int actualQty = 1;
				BigDecimal amount = new BigDecimal(0);

				try {
					final_price_per_mdq = storeTenderCommBidT
							.getNewTotRateMdq();
				} catch (Exception e) {
					final_price_per_mdq = new BigDecimal(0);
				}

				try {
					price_per_mdq = storeTenderCommBidT.getNewRatePerMdq();
				} catch (Exception e) {
					price_per_mdq = new BigDecimal(0);
				}
				try {
					// method added to save actual quantity
					if (storeTenderCommBidT.getCommBid().getItem()
							.getItemConversion().getFormula().equals("1")) {
						// BigDecimal(storeTenderLocalPurchaseT.getQtyRecd()));
						// BigDecimal(storeTenderCommBidT.getCommBid().getItem().getItemConversion().getConversionFactor1()));
						// BigDecimal(storeTenderLocalPurchaseT.getMdqValue()));
						try {
							actualQty = (storeTenderLocalPurchaseT.getQtyRecd() * storeTenderCommBidT
									.getCommBid().getItem().getItemConversion()
									.getConversionFactor1())
									/ (storeTenderLocalPurchaseT.getMdqValue()
											.intValue());
						} catch (Exception e) {
							actualQty = 0;
						}
						// if (actualQty == 0
						// && storeTenderLocalPurchaseT.getQtyRecd() != 0) {
						// actualQty = 1;
						// }
					} else {
						actualQty = storeTenderLocalPurchaseT.getQtyRecd();
					}
					storeTenderLocalPurchaseT.setActualQty(actualQty);
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					if (final_price_per_mdq.compareTo(new BigDecimal(0)) == 1) {
						storeTenderLocalPurchaseT
								.setFinalPricePerMdq(final_price_per_mdq);
						if (storeTenderCommBidT.getCommBid().getItem()
								.getItemConversion().getFormula().equals("1")) {
							amount = new BigDecimal(storeTenderLocalPurchaseT
									.getActualQty())
									.multiply(storeTenderLocalPurchaseT
											.getFinalPricePerMdq());

						} else {
							amount = new BigDecimal(box
									.getInt(TENDER_LPO_QUANTITY))
									.multiply(final_price_per_mdq);
						}
					} else {
						storeTenderLocalPurchaseT
								.setFinalPricePerMdq(price_per_mdq);
						amount = new BigDecimal(box.getInt(TENDER_LPO_QUANTITY))
								.multiply(price_per_mdq);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				storeTenderLocalPurchaseT.setItem(new MasStoreItem(item_id));
				storeTenderLocalPurchaseT
						.setLcat(storeTenderCommBidT.getLcat());
				storeTenderLocalPurchaseT.setSrNo(++srNo);
				storeTenderLocalPurchaseT
						.setStoreTenderLocalPurchaseM(new StoreTenderLocalPurchaseM(
								master_id));
				storeTenderLocalPurchaseT.setAmount(amount);
				for (StoreTenderLocalPurchaseT existingStoreTenderLocalPurchaseT : existingTransactionList) {
					if (existingStoreTenderLocalPurchaseT
							.getItem()
							.getId()
							.equals(storeTenderLocalPurchaseT.getItem().getId())) {
						itemExist = true;
						// //System.out.println("item exist true");
						map.put("itemExist", "itemExist");
						break;

					}
				}
				if (itemExist != true) {
					hbt.save(storeTenderLocalPurchaseT);
					hbt.refresh(storeTenderLocalPurchaseT);
				}
			}

			transaction.commit();

			storeTenderLocalPurchaseTList = hbt
					.find("from jkt.hms.masters.business.StoreTenderLocalPurchaseT as inp where inp.StoreTenderLocalPurchaseM.Id = "
							+ master_id + " order by inp.SrNo");
			item_id = 0;
			String pvmsNo = null;
			String nomenclature = null;
			String au = null;
			String brand_name = null;
			String manuf_name = null;
			String supplier_name = null;
			String lcat = null;
			String disp_type = null;
			// Integer mdq = null;
			BigDecimal mdq = null;
			BigDecimal rate_per_mdq = new BigDecimal(0);
			Integer qty_req = null;
			BigDecimal amount = null;
			Integer actual_qty = null;

			for (Iterator iterator = storeTenderLocalPurchaseTList.iterator(); iterator
					.hasNext();) {
				StoreTenderLocalPurchaseT storeTenderLocalPurchaseT = (StoreTenderLocalPurchaseT) iterator
						.next();
				pvmsNo = storeTenderLocalPurchaseT.getItem().getPvmsNo();
				item_id = storeTenderLocalPurchaseT.getItem().getId();
				nomenclature = storeTenderLocalPurchaseT.getItem()
						.getNomenclature();
				try {
					au = storeTenderLocalPurchaseT.getItem()
							.getItemConversion().getPurchaseUnit()
							.getUnitName();
				} catch (Exception e) {
					au = "-";
				}
				// code change by shailesh for lpo note
				try {
					group_id = storeTenderLocalPurchaseT.getItem().getGroup()
							.getId();
				} catch (Exception e) {
					group_id = 0;
				}

				brand_name = storeTenderLocalPurchaseT.getBrandName();
				manuf_name = storeTenderLocalPurchaseT.getManufacturerName();
				supplier_name = storeTenderLocalPurchaseT.getSupplier()
						.getSupplierName();
				lcat = storeTenderLocalPurchaseT.getLcat();
				disp_type = storeTenderLocalPurchaseT.getDispType();
				mdq = storeTenderLocalPurchaseT.getMdqValue();
				rate_per_mdq = storeTenderLocalPurchaseT.getFinalPricePerMdq();
				qty_req = storeTenderLocalPurchaseT.getQtyRecd();
				amount = storeTenderLocalPurchaseT.getAmount();

				actual_qty = storeTenderLocalPurchaseT.getActualQty();

				hData = new HashMap<String, Object>();
				hData.put(TENDER_LPO_ITEM_ID, item_id);
				hData.put(TENDER_LPO_PVMS_NO, pvmsNo);
				hData.put(TENDER_LPO_NOMENCLATURE, nomenclature);
				hData.put(TENDER_LPO_BRAND, brand_name);
				hData.put(TENDER_LPO_AU, au);
				hData.put(TENDER_LPO_MANUFACTURER, manuf_name);
				hData.put(TENDER_LPO_SUPPLIER, supplier_name);
				hData.put(TENDER_LPO_LCAT, lcat);
				hData.put(TENDER_LPO_DISP_TYPE, disp_type);
				hData.put(TENDER_LPO_MDQ, mdq);
				hData.put(TENDER_LPO_RATE_PER_MDQ, rate_per_mdq);
				hData.put(TENDER_LPO_QTY, qty_req);
				hData.put(TENDER_LPO_AMOUNT, amount);
				hData.put("actual_qty", actual_qty);

				// code amendded by shailesh for lpo note
				hData.put("group_id", group_id);
				hData.put("supplierId", storeTenderLocalPurchaseT.getSupplier()
						.getId());
				// //System.out.println("Group_id" + group_id);
				vResult.add(hData);
			}

		} catch (HibernateException e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
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
		map = getLPOGridData(box);
		map.put("pagedArray", pagedArray);

		return map;
	}

	public Map<String, Object> getTenderSupplierListForLPNote(Box box) {
		// TODO Auto-generated method stub
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		// map = getGroupAndTenderComboDetails(box);
		// List<StoreTenderCommBidM> storeTenderCommBidMList = new
		// ArrayList<StoreTenderCommBidM>();
		// List<StoreTenderCommBidT> storeTenderCommBidTList = new
		// ArrayList<StoreTenderCommBidT>();

		String query = "";
		query += "SELECT s.supplier_name, "
				+ " count(t.item_id) no_of_items,"
				+ " round(sum(t.actual_qty*t.final_price_per_mdq ),2) net_amount,"
				+ " t.supplier_id, m.status "
				+ " FROM store_tender_local_purchase_t t,store_tender_local_purchase_m m, mas_store_supplier s, "
				+ " mas_store_item i,mas_store_item_conversion f "
				+ " where m.id=t.store_tender_local_purchase_m_id "
				+ " and i.item_conversion_id = f.item_conversion_id "
				+ " and  t.supplier_id = s.supplier_id "
				+ " and t.item_id=i.item_id " + " and m.dept_id='"
				+ box.getInt("deptId") + "' " + " and m.note_no='"
				+ box.get("noteNo") + "' " + " group by t.supplier_id";
		//System.out.println("query" + query);
		List objectList = (List) session.createSQLQuery(query).list();
		// //System.out.println("size " + objectList.size());
		map.put("objectList", objectList);
		return map;
	}

	///--------------Method Commented by Vishal and new method come from Noida paste below-----
	/*public Map<String, Object> showSupplyOrderSplitUpForLpoNote(Box box) {
		// TODO Auto-generated method stub
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> cancelMap = new HashMap<String, Object>();
		Map<String, Object> remarksMap = new HashMap<String, Object>();
		Map<String, Object> supplierMap = new HashMap<String, Object>();
		Map<String, Object> lcatMap = new HashMap<String, Object>();
		List<StorePoHeader> storePoHeaderList = new ArrayList<StorePoHeader>();
		List<StorePoDetail> storePoDetailList = new ArrayList<StorePoDetail>();
		List<StorePoHeader> storePoRemain = new ArrayList<StorePoHeader>();
		String query = "";
		Map dateMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) dateMap.get("currentDate");
		
		 * query="select concat(s.supplier_name,' [',s.supplier_code,']') "+ "
		 * supplier_name, i.pvms_no, i.nomenclature,
		 * concat(truncate(t.qty_recd,0),' ',g.unit_name), "+ " t.disp_type,
		 * t.mdq_value, t.final_price_per_mdq, t.final_price_per_mdq, "+ "
		 * t.amount,t.amount, t.item_id, concat(s.supplier_name,'[L',t.lcat,']')
		 * "+ " from store_tender_local_purchase_m m,
		 * store_tender_local_purchase_t t, "+ " mas_store_supplier s,
		 * mas_store_item i, "+ " mas_store_item_conversion f, mas_store_unit g
		 * "+ " where m.id = t.store_tender_local_purchase_m_id "+ " and
		 * i.item_id = t.item_id "+ " and i.item_conversion_id =
		 * f.item_conversion_id "+ " and f.purchase_unit_id = g.unit_id "+ " and
		 * t.supplier_id = s.supplier_id "+ " and m.dept_id
		 * ='"+box.getInt("deptId")+"' "+ " and
		 * m.note_no='"+box.get("noteNo")+"' "+ " and t.supplier_id
		 * ='"+box.get("supplierId")+"' "+ " order by t.item_id ";
		 

		query = "select concat(s.supplier_name,' [',s.supplier_code,']') supplier_name,"
				+ " i.pvms_no, i.nomenclature, concat(truncate(t.qty_recd,2),' ',g.unit_name),"
				+ " t.disp_type, t.mdq_value, t.final_price_per_mdq,b.comp_rate,"
				+ " (t.actual_qty*t.final_price_per_mdq) amount1,  t.po_id, t.item_id, "
				+ " concat(s.supplier_name,'[L',t.lcat,']'),new_rate_mdq,new_taxamt_mdq  from "
				+ " store_tender_local_purchase_m m, store_tender_local_purchase_t t"
				+ ", store_tender_comm_bid_m a, store_tender_comm_bid_t b, mas_store_supplier s,"
				+ "  mas_store_item i,  mas_store_item_conversion f, mas_store_unit g "
				+ " where m.id = t.store_tender_local_purchase_m_id  and i.item_id = t.item_id "
				+ " and a.id = b.comm_bid_id and a.item_id=t.item_id  and "
				+ " i.item_conversion_id = f.item_conversion_id  and f.purchase_unit_id = g.unit_id"
				+ " and t.supplier_id = s.supplier_id  and m.dept_id ='"
				+ box.getInt("deptId")
				+ "'   and"
				+ " m.note_no='"
				+ box.get("noteNo")

				+ "'  and t.supplier_id ='"
				+ box.get("supplierId")
				+ "' "
				+ " and a.tender_id = '"
				+ box.get("tenderId")
				+ "' "
				+ " and b.supplier_id = '"
				+ box.get("supplierId")
				+ "' order by t.item_id";

		// //System.out.println("second query" + query);
		List objectList = (List) session.createSQLQuery(query).list();

		List<StoreTenderLocalPurchaseT> poIdContainingStoreTenderLocalPurchaseTList = new ArrayList<StoreTenderLocalPurchaseT>();
		List<StoreTenderLocalPurchaseT> tempStoreTenderLocalPurchaseTList = new ArrayList<StoreTenderLocalPurchaseT>();
		Set<StorePoHeader> poIdList = new HashSet<StorePoHeader>();

		if (objectList != null && objectList.size() > 0) {
			tempStoreTenderLocalPurchaseTList = session.createCriteria(
					StoreTenderLocalPurchaseT.class).createAlias(
					"StoreTenderLocalPurchaseM", "m").add(
					Restrictions.eq("m.Tender.Id", box.getInt("tenderId")))
					.add(
							Restrictions.eq("Supplier.Id", box
									.getInt("supplierId"))).add(
							Restrictions.eq("m.NoteNo", box.getInt("noteNo")))
					.add(
							Restrictions.eq("m.Department.Id", box
									.getInt("deptId"))).add(
							Restrictions.isNotNull("Po")).list();
			// //System.out.println("tempStoreTenderLocalPurchaseTList size"
			// + tempStoreTenderLocalPurchaseTList.size());
			for (StoreTenderLocalPurchaseT storeTenderLocalPurchaseT : tempStoreTenderLocalPurchaseTList) {
				poIdList.add(storeTenderLocalPurchaseT.getPo());
			}
			storePoHeaderList.addAll(poIdList);
		}

		storePoRemain = session.createCriteria(StorePoHeader.class).add(
				Restrictions.eq("Department.Id", box.getInt("deptId"))).add(
				Restrictions.eq("Supplier.Id", box.getInt("supplierId"))).add(
				Restrictions.eq("PoDate", HMSUtil
						.convertStringTypeDateToDateType(date))).list();
		BigDecimal remain = new BigDecimal("0");
		for (StorePoHeader Remain : storePoRemain) {
			remain = remain.add(Remain.getNetAmount());

		}

		
		 * if (objectList1!=null && objectList1.size() > 0) { storePoHeaderList
		 * = session.createCriteria(StorePoHeader.class)
		 * .add(Restrictions.eq("Department.Id", box.getInt("deptId")))
		 * .add(Restrictions.eq("Supplier.Id", box.getInt("supplierId")))
		 * .add(Restrictions.eq("TenderM.Id", box.getInt("tenderId")))
		 * 
		 * .add(Restrictions.eq("Flag", "s"))
		 * .add(Restrictions.not(Restrictions.in("Id", objectList1))) .list(); }
		 * else { storePoHeaderList =
		 * session.createCriteria(StorePoHeader.class)
		 * .add(Restrictions.eq("Department.Id", box.getInt("deptId")))
		 * .add(Restrictions.eq("Supplier.Id", box.getInt("supplierId")))
		 * .add(Restrictions.eq("TenderM.Id", box.getInt("tenderId")))
		 * 
		 * .add(Restrictions.eq("Flag", "s")) .list(); }
		 

		map.put("objectList", objectList);
		map.put("remain", remain);
		map.put("storePoHeaderList", storePoHeaderList);

		map.put("objectList", objectList);
		return map;
	}*/
	
	public Map<String, Object> showSupplyOrderSplitUpForLpoNote(Box box) {
		// TODO Auto-generated method stub
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> cancelMap = new HashMap<String, Object>();
		Map<String, Object> remarksMap = new HashMap<String, Object>();
		Map<String, Object> supplierMap = new HashMap<String, Object>();
		Map<String, Object> lcatMap = new HashMap<String, Object>();
		List<StorePoHeader> storePoHeaderList = new ArrayList<StorePoHeader>();
		List<StorePoDetail> storePoDetailList = new ArrayList<StorePoDetail>();
		List<StorePoHeader> storePoRemain = new ArrayList<StorePoHeader>();
		String query = "";
		Map dateMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) dateMap.get("currentDate");
		/*
		 * query="select concat(s.supplier_name,' [',s.supplier_code,']') "+ "
		 * supplier_name, i.pvms_no, i.nomenclature,
		 * concat(truncate(t.qty_recd,0),' ',g.unit_name), "+ " t.disp_type,
		 * t.mdq_value, t.final_price_per_mdq, t.final_price_per_mdq, "+ "
		 * t.amount,t.amount, t.item_id, concat(s.supplier_name,'[L',t.lcat,']')
		 * "+ " from store_tender_local_purchase_m m,
		 * store_tender_local_purchase_t t, "+ " mas_store_supplier s,
		 * mas_store_item i, "+ " mas_store_item_conversion f, mas_store_unit g
		 * "+ " where m.id = t.store_tender_local_purchase_m_id "+ " and
		 * i.item_id = t.item_id "+ " and i.item_conversion_id =
		 * f.item_conversion_id "+ " and f.purchase_unit_id = g.unit_id "+ " and
		 * t.supplier_id = s.supplier_id "+ " and m.dept_id
		 * ='"+box.getInt("deptId")+"' "+ " and
		 * m.note_no='"+box.get("noteNo")+"' "+ " and t.supplier_id
		 * ='"+box.get("supplierId")+"' "+ " order by t.item_id ";
		 */

		query = "select concat(s.supplier_name,' [',s.supplier_code,']') supplier_name,"
				+ " i.pvms_no, i.nomenclature, concat(truncate(t.qty_recd,2),' ',g.unit_name),"
				+ " t.disp_type, t.mdq_value, t.final_price_per_mdq,b.comp_rate,"
				+ " (t.actual_qty*t.final_price_per_mdq) amount1,  t.po_id, t.item_id, "
				+ " concat(s.supplier_name,'[L',t.lcat,']'),new_rate_mdq,new_taxamt_mdq  from "
				+ " store_tender_local_purchase_m m, store_tender_local_purchase_t t"
				+ ", store_tender_comm_bid_m a, store_tender_comm_bid_t b, mas_store_supplier s,"
				+ "  mas_store_item i,  mas_store_item_conversion f, mas_store_unit g "
				+ " where m.id = t.store_tender_local_purchase_m_id  and i.item_id = t.item_id "
				+ " and a.id = b.comm_bid_id and a.item_id=t.item_id  and "
				+ " i.item_conversion_id = f.item_conversion_id  and f.purchase_unit_id = g.unit_id"
				+ " and t.supplier_id = s.supplier_id  and m.dept_id ='"
				+ box.getInt("deptId")
				+ "'   and"
				+ " m.note_no='"
				+ box.get("noteNo")

				+ "'  and t.supplier_id ='"
				+ box.get("supplierId")
				+ "' "
				+ " and a.tender_id = '"
				+ box.get("tenderId")
				+ "' "
				+ " and b.supplier_id = '"
				+ box.get("supplierId")
				+ "' order by t.item_id";

		// //System.out.println("second query" + query);
		List objectList = (List) session.createSQLQuery(query).list();

		List<StoreTenderLocalPurchaseT> poIdContainingStoreTenderLocalPurchaseTList = new ArrayList<StoreTenderLocalPurchaseT>();
		List<StoreTenderLocalPurchaseT> tempStoreTenderLocalPurchaseTList = new ArrayList<StoreTenderLocalPurchaseT>();
		Set<StorePoHeader> poIdList = new HashSet<StorePoHeader>();
        int store_tender_local_purchase_id = 0 ;
		if (objectList != null && objectList.size() > 0) {
			tempStoreTenderLocalPurchaseTList = session.createCriteria(
					StoreTenderLocalPurchaseT.class).createAlias(
					"StoreTenderLocalPurchaseM", "m").add(
					Restrictions.eq("m.Tender.Id", box.getInt("tenderId")))
					.add(
							Restrictions.eq("Supplier.Id", box
									.getInt("supplierId"))).add(
							Restrictions.eq("m.NoteNo", box.getInt("noteNo")))
					.add(
							Restrictions.eq("m.Department.Id", box
									.getInt("deptId"))).add(
							Restrictions.isNotNull("Po")).list();
			// //System.out.println("tempStoreTenderLocalPurchaseTList size"
			// + tempStoreTenderLocalPurchaseTList.size());
			for (StoreTenderLocalPurchaseT storeTenderLocalPurchaseT : tempStoreTenderLocalPurchaseTList) {
				poIdList.add(storeTenderLocalPurchaseT.getPo());
				store_tender_local_purchase_id = storeTenderLocalPurchaseT.getStoreTenderLocalPurchaseM().getId();
				//System.out.println("store_tender_local_purchase_id::"+store_tender_local_purchase_id);
			}
			storePoHeaderList.addAll(poIdList);
		}

		storePoRemain = session.createCriteria(StorePoHeader.class).add(
				Restrictions.eq("Department.Id", box.getInt("deptId"))).add(
				Restrictions.eq("Supplier.Id", box.getInt("supplierId"))).add(
				Restrictions.eq("PoDate", HMSUtil
						.convertStringTypeDateToDateType(date))).list();
		BigDecimal remain = new BigDecimal("0");
		for (StorePoHeader Remain : storePoRemain) {
			remain = remain.add(Remain.getNetAmount());

		}

		/*
		 * if (objectList1!=null && objectList1.size() > 0) { storePoHeaderList
		 * = session.createCriteria(StorePoHeader.class)
		 * .add(Restrictions.eq("Department.Id", box.getInt("deptId")))
		 * .add(Restrictions.eq("Supplier.Id", box.getInt("supplierId")))
		 * .add(Restrictions.eq("TenderM.Id", box.getInt("tenderId")))
		 * 
		 * .add(Restrictions.eq("Flag", "s"))
		 * .add(Restrictions.not(Restrictions.in("Id", objectList1))) .list(); }
		 * else { storePoHeaderList =
		 * session.createCriteria(StorePoHeader.class)
		 * .add(Restrictions.eq("Department.Id", box.getInt("deptId")))
		 * .add(Restrictions.eq("Supplier.Id", box.getInt("supplierId")))
		 * .add(Restrictions.eq("TenderM.Id", box.getInt("tenderId")))
		 * 
		 * .add(Restrictions.eq("Flag", "s")) .list(); }
		 */
		for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
			Object[] obj = (Object[]) iterator.next();
			String supplier_name = new String();
			
			int item_id = (Integer) obj[10];

			// Find out the old po_id if exists otherwise use the new po_id
			// This is used to find out the cancelled items
			List<StorePoDetail> storePoDetailList1 = new ArrayList<StorePoDetail>();
			if (obj[9] != null) {

				int po_id = (Integer) obj[9];
				storePoDetailList1 = session.createCriteria(StorePoDetail.class)
						.createAlias("Po", "P").add(
								Restrictions.eq("P.Id", po_id)).add(
								Restrictions.eq("P.Department.Id", box
										.getInt("deptId"))).add(
								Restrictions.eq("P.Supplier.Id", box
										.getInt("supplierId"))).add(
								Restrictions.eq("P.TenderM.Id", box
										.getInt("tenderId"))).add(
								Restrictions.eq("P.Flag", "s")).add(
								Restrictions.eq("Item.Id", item_id)).list();
			}
			//System.out.println("::deptId::"+box.getInt("deptId")+"::supplierId::"+box.getInt("supplierId")+"::tenderId::"+box.getInt("tenderId"));
            //System.out.println("storePoDetailList1"+storePoDetailList1.size()+"::item_id::"+item_id);
			for (Iterator iterator2 = storePoDetailList1.iterator(); iterator2
					.hasNext();) {
				StorePoDetail storePoDetail = (StorePoDetail) iterator2.next();
				cancelMap.put(String.valueOf(item_id), storePoDetail
						.getCancelled());
				remarksMap.put(String.valueOf(item_id), storePoDetail
						.getRemarks());
			}
		}
		map.put("objectList", objectList);
		map.put("remain", remain);
		map.put("storePoHeaderList", storePoHeaderList);
		map.put("cancelMap", cancelMap);
		map.put("store_tender_local_purchase_id",store_tender_local_purchase_id);
		return map;
	}
	
	// ----------this method added come from Noida-----------------
	public Map<String , Object> cancelSupplyOrderItemsForLpoNote(Box box ){
		Map<String ,Object > map = new HashMap<String , Object>();
		List<StorePoDetail> storePoDetailList = new ArrayList<StorePoDetail>();
		//List<StoreTenderLocalPurchaseT> storeTenderLocalPurchaseTList = new ArrayList<StoreTenderLocalPurchaseT>();
		
		// StorePoHeader storePoHeader = null;
		StorePoDetail storePoDetail = null;
		Session session = (Session) getSession();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Vector cancel = box.getVector(ITEMS_TO_BE_DELETED);
			Vector remarks = box.getVector("remarks");
			Vector itemIds = box.getVector("itemIds");
			//Vector lcat = box.getVector("lcat");
			//System.out.println("::cancel::"+cancel.size()+"::remarks::"+remarks.size()+"::itemIds::"+itemIds.size());
			String Query ="";
			int j=1 ;
			for (Iterator iterator = cancel.iterator(); iterator.hasNext();) {
				int item_id = new Integer(iterator.next().toString());
				List objList = new ArrayList();
				Query = "SELECT p.po_detail_id  FROM store_tender_local_purchase_m m left outer join store_tender_local_purchase_t t "+
				               "on t.store_tender_local_purchase_m_id = m.id " +
				               "left outer join  store_po_detail p on p.po_id = t.po_id " +
				               "where m.dept_id ='" + box.getInt("deptId")+
				               "' and m.tender_id = '" + box.getInt("tenderId") +
				               "' and m.note_no = '" + box.getInt("noteNo") +
				               "' and t.item_id = '" + item_id +
				               "' and p.item_id = '" + item_id +"'";
				//System.out.println("::deptId::"+box.getInt("deptId")+"::tenderId::"+box.getInt("tenderId")+"::noteNo::"+box.getInt("noteNo")+"::item_id::"+item_id);
				objList = session.createSQLQuery(Query).list();
				
				if(objList!=null)
				{
					//System.out.println("::objList::"+objList.size());
				for(int i=0;i<objList.size(); i++)
				{
					
					Object obj=objList.get(i);
					int po_detail_id = Integer.parseInt(obj.toString());
					//System.out.println("::po_detail_id::"+po_detail_id);
					storePoDetailList = session.createCriteria(StorePoDetail.class).add(Restrictions.eq("Id",po_detail_id)).list();
					
				}
				}
								
				if (storePoDetailList != null && storePoDetailList.size() > 0) {
					storePoDetail = storePoDetailList.get(0);
					int po_id = storePoDetail.getPo().getId();
					StorePoHeader storePoHeader = new StorePoHeader();

					storePoDetail.setCancelled("y");
					int i = 0;
					for (Iterator iterator2 = itemIds.iterator(); iterator2
							.hasNext();) {
						int id = new Integer(iterator2.next().toString());
						if (item_id == id && remarks.get(i)!=null) {
							storePoDetail.setRemarks(remarks.get(i).toString());
							
						}
						i++;
					}
					storePoHeader = (StorePoHeader) hbt.load(
							StorePoHeader.class, po_id);
					BigDecimal net_amount = storePoHeader.getNetAmount();
					net_amount = net_amount.subtract(storePoDetail.getAmount());

					storePoHeader.setNetAmount(net_amount);
					hbt.update(storePoHeader);
					hbt.refresh(storePoHeader);

					hbt.update(storePoDetail);
					hbt.refresh(storePoDetail);
				}

			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map ;
	}

	public Map<String, Object> generateLocalPurchaseOrderForLpoNote(Box box) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreSetup> storeSetupList = new ArrayList<StoreSetup>();
		int groupId = 1;
		StorePoHeader storePoHeader = null;
		StorePoDetail storePoDetail = null;
		Session session = (Session) getSession();
		BigDecimal net_amount = new BigDecimal(0);
		String tender_no = "";
		Date tender_date = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			Vector v = box.getVector(ITEMS_TO_BE_ADDED);
			// //System.out.println("vector Elements" + v);

			String str = v.toString();
			String items = str.substring(1, str.length() - 1);
			items = "(" + items + ")";
			// //System.out.println("items  in uper " + items);
			String query = "";

			query = "select m.dept_id, t.supplier_id, m.tender_id, i.group_id, t.item_id, "
					+ " t.actual_qty  , b.comp_rate, "
					+ " (t.final_price_per_mdq * t.actual_qty) amount, "
					+ " ((b.mrp * b.vat_percent) / 100) tax_amount, b.vat_percent, t.disp_type, t.mdq_value, "
					+ " t.final_price_per_mdq, b.mrp, tn.tender_no, tn.tender_invitation_date,t.new_taxamt_mdq "
					+ " from store_tender_local_purchase_m m, store_tender_local_purchase_t t, "
					+ " store_tender_m tn, mas_store_item i, mas_store_item_conversion f, "
					+ " store_tender_comm_bid_m a,store_tender_comm_bid_t b "
					+ " where m.id = t.store_tender_local_purchase_m_id "
					+ " and m.tender_id = tn.id "
					+ " and a.id = b.comm_bid_id "
					+ " and a.tender_id = tn.id "
					+ " and t.item_id = i.item_id "
					+ " and a.item_id = t.item_id "
					+ " and a.item_id=i.item_id "
					+ " and a.tender_id ='"
					+ box.getInt("tenderId")
					+ "' "
					+ " and i.item_conversion_id = f.item_conversion_id "
					+ " and m.dept_id ='"
					+ box.getInt("deptId")
					+ "' "
					+ " and m.tender_id = '"
					+ box.getInt("tenderId")
					+ "' "
					+ " and b.supplier_id = '"
					+ box.get("supplierId")
					+ "' "
					+ " and t.supplier_id = '"
					+ box.get("supplierId")
					+ "' and m.note_no='"
					+ box.getInt("noteNo")
					+ "'"
					+ " and t.item_id in  " + items;
			// //System.out.println("3 rd query" + query);
			// //System.out.println("noteno " + box.getInt("noteNo"));
			List objectList = session.createSQLQuery(query).list();

			for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
				Object[] obj = (Object[]) iterator.next();
				tender_no = obj[14].toString();
				tender_date = (Date) obj[15];
				if (obj[3] != null) {
					groupId = (Integer) obj[3];
				}
				try {
					BigDecimal val = new BigDecimal(obj[7].toString());
					net_amount = net_amount.add(val);
				} catch (Exception e) {
					net_amount = net_amount.add(new BigDecimal(0));
				}
			}

			List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
			storeFyDocumentNoList = hbt
					.find("from jkt.hms.masters.business.StoreFyDocumentNo as inp where inp.Department.Id = "
							+ box.getInt("deptId"));
			String no = "";
			if (storeFyDocumentNoList != null
					&& storeFyDocumentNoList.size() > 0) {
				StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) storeFyDocumentNoList
						.get(0);
				no = ("" + storeFyDocumentNo.getPoNo());
				storeFyDocumentNo.setPoNo(getMaxNo(no));
				hbt.update(storeFyDocumentNo);
				hbt.refresh(storeFyDocumentNo);
			}

			storePoHeader = new StorePoHeader();
			storePoHeader.setPoDate(HMSUtil.convertStringTypeDateToDateType(box
					.get(CHANGED_DATE)));
			storePoHeader.setPoTime(box.getString(CHANGED_TIME));
			storePoHeader.setQuotationNumber(tender_no);
			storePoHeader
					.setDepartment(new MasDepartment(box.getInt("deptId")));
			storePoHeader.setSupplier(new MasStoreSupplier(box
					.getInt("supplierId")));
			storePoHeader.setDeliveryDate(HMSUtil
					.convertStringTypeDateToDateType(box.get("delivery")));
			storePoHeader.setLastChgBy(box.get(CHANGED_BY));
			storePoHeader.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(box.get(CHANGED_DATE)));
			storePoHeader.setLastChgTime(box.getString(CHANGED_TIME));
			storePoHeader.setStatus("o");
			storePoHeader.setFlag("s");
			storePoHeader.setQuotationDate(tender_date);
			storePoHeader.setRemarks(box.getString("remarks"));
			storePoHeader.setPayTerms("");
			storePoHeader.setDeliveryTerms("");
			storePoHeader.setApprovalAuthority("");
			storePoHeader.setSigningAuthority("");
			storePoHeader.setTenderM(new StoreTenderM(box.getInt("tenderId")));
			storePoHeader.setGroup(new MasStoreGroup(groupId));
			storePoHeader.setNetAmount(net_amount);
			storePoHeader.setPoNumber(getMaxNo(no));
			hbt.save(storePoHeader);
			hbt.refresh(storePoHeader);

			java.util.Date poDate = storePoHeader.getPoDate();
			// Update MasStoreBudget Master record
			List<MasStoreFinancial> masStoreFinancialList = new ArrayList<MasStoreFinancial>();
			masStoreFinancialList = session.createCriteria(
					MasStoreFinancial.class).list();
			java.util.Date start_date = null;
			java.util.Date end_date = null;
			int financial_id = 0;
			for (Iterator iterator2 = masStoreFinancialList.iterator(); iterator2
					.hasNext();) {
				MasStoreFinancial masStoreFinancial = (MasStoreFinancial) iterator2
						.next();
				start_date = (java.util.Date) masStoreFinancial.getStartDate();
				end_date = (java.util.Date) masStoreFinancial.getEndDate();
				if (poDate.after(start_date) && poDate.before(end_date)) {
					financial_id = masStoreFinancial.getId();
					break;
				} else if (poDate.equals(start_date) || poDate.equals(end_date)) {
					financial_id = masStoreFinancial.getId();
					break;
				}
			}

			// should not add to Masterbudget
			/*
			 * List<MasStoreBudget> masStoreBudgetList = new
			 * ArrayList<MasStoreBudget>(); masStoreBudgetList =
			 * session.createCriteria(MasStoreBudget.class)
			 * .add(Restrictions.eq("Financial.Id", financial_id)).list();
			 * BigDecimal existing_committed_amount = null; if
			 * (masStoreBudgetList != null && masStoreBudgetList.size() > 0) {
			 * MasStoreBudget masStoreBudget = masStoreBudgetList.get(0); try {
			 * // //System.out.println("updating masStoreBudgetList");
			 * existing_committed_amount = masStoreBudget
			 * .getPoComittedAmount(); } catch (Exception e) {
			 * existing_committed_amount = new BigDecimal(0); }
			 * masStoreBudget.setPoComittedAmount(existing_committed_amount
			 * .add(net_amount)); hbt.update(masStoreBudget); }
			 */

			int slno = 1;
			for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
				storePoDetail = new StorePoDetail();
				Object[] obj = (Object[]) iterator.next();
				storePoDetail.setAmount(new BigDecimal(obj[7].toString()));
				storePoDetail.setDispType(obj[10].toString());
				storePoDetail.setItem(new MasStoreItem(new Integer(obj[4]
						.toString())));
				storePoDetail.setMdqValue(new BigDecimal(obj[11].toString()));
				storePoDetail.setMrp(new BigDecimal(obj[13].toString()));
				storePoDetail.setPo(storePoHeader);
				storePoDetail.setQuantityOrdered(new BigDecimal(obj[5]
						.toString()));
				storePoDetail.setRatePerMdq(new BigDecimal(obj[12].toString()));
				storePoDetail.setSerialNo(slno++);
				storePoDetail.setTaxAmount(new BigDecimal(obj[8].toString()));
				storePoDetail.setTaxPercent(new BigDecimal(obj[9].toString()));
				storePoDetail.setUnitRate(new BigDecimal(obj[6].toString()));
				storePoDetail
						.setTaxAmtPerMdq(new BigDecimal(obj[16].toString()));
				hbt.save(storePoDetail);
				// commented as proposal is not of requirement
				/*
				 * List <StoreTenderProposal> storeTenderProposalList = new
				 * ArrayList<StoreTenderProposal>(); storeTenderProposalList =
				 * session.createCriteria(StoreTenderProposal.class)
				 * .add(Restrictions.eq("TenderId.Id", new
				 * Integer(obj[2].toString()))) .add(Restrictions.eq("Item.Id",
				 * new Integer(obj[4].toString())))
				 * .add(Restrictions.eq("Department.Id", new
				 * Integer(obj[0].toString()))) .list();
				 * 
				 * if (storeTenderProposalList!=null &&
				 * storeTenderProposalList.size()>0) {
				 * //System.out.println("upadtaing proposal"); StoreTenderProposal
				 * storeTenderProposal = storeTenderProposalList.get(0);
				 * storeTenderProposal.setPo(storePoHeader);
				 * hbt.update(storeTenderProposal); }
				 */

				List<StoreTenderCommBidT> storeTenderCommBidTList = new ArrayList<StoreTenderCommBidT>();
				storeTenderCommBidTList = session.createCriteria(
						StoreTenderCommBidT.class).createAlias("CommBid",
						"commbid").add(
						Restrictions.eq("commbid.Tender.Id", box
								.getInt("tenderId"))).add(
						Restrictions.eq("commbid.Group.Id", groupId)).add(
						Restrictions
								.eq("Supplier.Id", box.getInt("supplierId")))
						.add(
								Restrictions.eq("commbid.Item.Id", new Integer(
										obj[4].toString()))).list();

				if (storeTenderCommBidTList != null
						&& storeTenderCommBidTList.size() > 0) {
					for (StoreTenderCommBidT storeTenderCommBidT : storeTenderCommBidTList) {
						// System.out
						// .println("upadtaing StoreTenderCommBidT and storeTenderCommBidM ");
						StoreTenderCommBidM storeTenderCommBidM = storeTenderCommBidT
								.getCommBid();
						storeTenderCommBidM.setStatus("p");
						hbt.update(storeTenderCommBidM);
					}
				}
			}

			List<StorePoHeader> newlySavedPoHeaderList = new ArrayList<StorePoHeader>();
			Criteria c = session.createCriteria(StorePoHeader.class).addOrder(
					Order.desc("Id"));
			c.setFirstResult(0);
			c.setMaxResults(5);
			newlySavedPoHeaderList = c.list();
			String query1 = "select item_id from mas_store_item where item_id in "
					+ items;
			List objectList1 = session.createSQLQuery(query1).list();

			// saving poheader id in storetenderlocalpurchaseT
			List<StoreTenderLocalPurchaseT> storeTenderLocalPurchaseTList = new ArrayList<StoreTenderLocalPurchaseT>();
			List<StoreTenderLocalPurchaseT> tempStoreTenderLocalPurchaseTList = new ArrayList<StoreTenderLocalPurchaseT>();

			for (Object object : objectList1) {
				int ItemId = (Integer) object;
				tempStoreTenderLocalPurchaseTList = session.createCriteria(
						StoreTenderLocalPurchaseT.class).createAlias(
						"StoreTenderLocalPurchaseM", "m").createAlias("Item",
						"i").add(Restrictions.eq("i.Id", ItemId)).add(
						Restrictions.eq("m.Tender.Id", box.getInt("tenderId")))
						.add(
								Restrictions.eq("m.Department.Id", box
										.getInt("deptId"))).add(
								Restrictions.eq("Supplier.Id", box
										.getInt("supplierId"))).add(
								Restrictions.eq("m.NoteNo", box
										.getInt("noteNo"))).list();
				if (tempStoreTenderLocalPurchaseTList != null
						&& tempStoreTenderLocalPurchaseTList.size() > 0) {
					storeTenderLocalPurchaseTList
							.add(tempStoreTenderLocalPurchaseTList.get(0));

				}
			}

			// //System.out.println("size of storeTenderLocalPurchaseTList "
			// + storeTenderLocalPurchaseTList.size());

			for (StoreTenderLocalPurchaseT storeTenderLocalPurchaseT : storeTenderLocalPurchaseTList) {
				storeTenderLocalPurchaseT.setPo(new StorePoHeader(
						newlySavedPoHeaderList.get(0).getId()));
				hbt.update(storeTenderLocalPurchaseT);
				hbt.refresh(storeTenderLocalPurchaseT);
			}
			tx.commit();
		}

		catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		}
		map = getGroupAndTenderAndSupplierComboDetails(box);
		return map;
	}

	public Map<String, Object> getLPOGridData(Box box) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> masterDataMap = new HashMap<String, Object>();
		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;
		StoreTenderLocalPurchaseT storeTenderLocalPurchaseT = new StoreTenderLocalPurchaseT();
		StoreTenderLocalPurchaseM storeTenderLocalPurchaseM = new StoreTenderLocalPurchaseM();

		List<StoreTenderLocalPurchaseT> storeTenderLocalPurchaseTList = new ArrayList<StoreTenderLocalPurchaseT>();
		List<StoreTenderLocalPurchaseM> storeTenderLocalPurchaseMList = new ArrayList<StoreTenderLocalPurchaseM>();
		Session session = (Session) getSession();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			storeTenderLocalPurchaseMList = hbt
					.find("from jkt.hms.masters.business.StoreTenderLocalPurchaseM as inp where inp.NoteNo="
							+ box.getInt(TENDER_LPO_NOTE_NO)
							+ " and inp.Department.Id=" + box.getInt("deptId"));

			storeTenderLocalPurchaseTList = hbt
					.find("from jkt.hms.masters.business.StoreTenderLocalPurchaseT as inp where inp.StoreTenderLocalPurchaseM.NoteNo="
							+ box.getInt(TENDER_LPO_NOTE_NO)
							+ " and inp.StoreTenderLocalPurchaseM.Department.Id="
							+ box.getInt("deptId"));
			if (!box.getString("pvmsNo1").equals("")) {
				String pvms = box.getString("pvmsNo1");
				pvms = "%" + pvms + "%";
				storeTenderLocalPurchaseTList = session.createCriteria(
						StoreTenderLocalPurchaseT.class).createAlias(
						"StoreTenderLocalPurchaseM", "m").add(
						Restrictions.eq("m.NoteNo", box
								.getInt(TENDER_LPO_NOTE_NO))).createAlias(
						"Item", "i").add(Restrictions.like("i.PvmsNo", pvms))
						.add(
								Restrictions.eq("m.Department.Id", box
										.getInt("deptId"))).list();
			}

			if (storeTenderLocalPurchaseMList != null
					&& storeTenderLocalPurchaseMList.size() > 0) {
				storeTenderLocalPurchaseM = storeTenderLocalPurchaseMList
						.get(0);
				masterDataMap.put(TENDER_LPO_NOTE_NO, storeTenderLocalPurchaseM
						.getNoteNo());
				masterDataMap.put(TENDER_LPO_NOTE_DATE,
						storeTenderLocalPurchaseM.getNoteDate());
				masterDataMap.put(TENDER_LPO_NOTE_PERIOD,
						storeTenderLocalPurchaseM.getPeriod());
				masterDataMap.put(TENDER_LPO_OIC, storeTenderLocalPurchaseM
						.getOic().getId());
				masterDataMap.put(TENDER_NO, storeTenderLocalPurchaseM
						.getTender().getId());
			} else {
				// //System.out.println("tender id in dataservice"
				// + box.getInt(TENDER_NO));
				masterDataMap.put(TENDER_LPO_NOTE_NO, box
						.getInt(TENDER_LPO_NOTE_NO));
				// //System.out.println("TENDER_LPO_NOTE_NO"+ box
				// .getInt(TENDER_LPO_NOTE_NO));
				masterDataMap.put(TENDER_LPO_NOTE_DATE, box
						.get(TENDER_LPO_NOTE_DATE));
				// //System.out.println("TENDER_LPO_NOTE_DATE"+ box
				// .get(TENDER_LPO_NOTE_DATE));
				masterDataMap.put(TENDER_LPO_NOTE_PERIOD, box
						.get(TENDER_LPO_NOTE_PERIOD));
				// //System.out.println("TENDER_LPO_NOTE_PERIOD"+ box
				// .get(TENDER_LPO_NOTE_PERIOD));
				masterDataMap.put(TENDER_LPO_OIC, box.get(TENDER_LPO_OIC));
				// //System.out.println("TENDER_LPO_OIC"+ box
				// .getInt(TENDER_LPO_OIC));
				masterDataMap.put(TENDER_NO, box.getInt(TENDER_NO));
			}
			int item_id = 0;
			String pvmsNo = null;
			String nomenclature = null;
			String au = null;
			String brand_name = null;
			String manuf_name = null;
			String supplier_name = null;
			String lcat = null;
			String disp_type = null;
			// Integer mdq = null;
			BigDecimal mdq = null;
			BigDecimal rate_per_mdq = new BigDecimal(0);
			Integer qty_req = null;
			BigDecimal amount = null;
			Integer actual_qty = null;

			for (Iterator iterator = storeTenderLocalPurchaseTList.iterator(); iterator
					.hasNext();) {
				storeTenderLocalPurchaseT = (StoreTenderLocalPurchaseT) iterator
						.next();
				pvmsNo = storeTenderLocalPurchaseT.getItem().getPvmsNo();
				item_id = storeTenderLocalPurchaseT.getItem().getId();
				nomenclature = storeTenderLocalPurchaseT.getItem()
						.getNomenclature();
				try {
					au = storeTenderLocalPurchaseT.getItem()
							.getItemConversion().getPurchaseUnit()
							.getUnitName();
				} catch (Exception e) {
					au = "-";
				}
				brand_name = storeTenderLocalPurchaseT.getBrandName();
				manuf_name = storeTenderLocalPurchaseT.getManufacturerName();
				supplier_name = storeTenderLocalPurchaseT.getSupplier()
						.getSupplierName();
				lcat = storeTenderLocalPurchaseT.getLcat();
				disp_type = storeTenderLocalPurchaseT.getDispType();
				mdq = storeTenderLocalPurchaseT.getMdqValue();
				rate_per_mdq = storeTenderLocalPurchaseT.getFinalPricePerMdq();
				qty_req = storeTenderLocalPurchaseT.getQtyRecd();
				amount = storeTenderLocalPurchaseT.getAmount();

				actual_qty = storeTenderLocalPurchaseT.getActualQty();

				hData = new HashMap<String, Object>();
				hData.put(TENDER_LPO_ITEM_ID, item_id);
				hData.put(TENDER_LPO_PVMS_NO, pvmsNo);
				hData.put(TENDER_LPO_NOMENCLATURE, nomenclature);
				hData.put(TENDER_LPO_BRAND, brand_name);
				hData.put(TENDER_LPO_AU, au);
				hData.put(TENDER_LPO_MANUFACTURER, manuf_name);
				hData.put(TENDER_LPO_SUPPLIER, supplier_name);
				hData.put(TENDER_LPO_LCAT, lcat);
				hData.put(TENDER_LPO_DISP_TYPE, disp_type);
				hData.put(TENDER_LPO_MDQ, mdq);
				hData.put(TENDER_LPO_RATE_PER_MDQ, rate_per_mdq);
				hData.put(TENDER_LPO_QTY, qty_req);
				hData.put(TENDER_LPO_AMOUNT, amount);
				hData.put("actual_qty", actual_qty);

				vResult.add(hData);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		if (vResult.size() > 0) {
			testPageData = new HashMap[vResult.size()];
			// //System.out.println("vresult size"+vResult.size());
			vResult.copyInto(testPageData);
		}

		try {
			pagedArray = new PageUtil().convertToPagedArrayIndex(testPageData,
					box);

			String query = "select concat(nomenclature,'[',pvms_no,']') from mas_store_item where item_id = '"
					+ box.get("itemId") + "'";
			List objectList = new ArrayList();

			objectList = (List) session.createSQLQuery(query).list();
			String nomenclature = "";
			if (objectList != null && objectList.size() > 0) {
				nomenclature = (String) objectList.get(0);
			}
			map.put("nomenclature", nomenclature);

			// //System.out.println("go page "+pagedArray.getCurrentPage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		// //System.out.println("box values in datra "+box);
		map.putAll(showTenderLPO(box));
		map.put("masterDataMap", masterDataMap);
		map.put("pagedArray", pagedArray);

		return map;
	}

	public Map<String, Object> deleteLPOGridItems(Box box) {
		// TODO Auto-generated method stub
		Session session = (Session) getSession();
		List<StoreTenderLocalPurchaseT> storeTenderLocalPurchaseTList = new ArrayList<StoreTenderLocalPurchaseT>();
		StoreTenderLocalPurchaseT storeTenderLocalPurchaseT = new StoreTenderLocalPurchaseT();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			Vector srno = box.getVector(TENDER_LPO_SRNO);
			Vector items = box.getVector(TENDER_LPO_ITEM_ID);
			Vector delete = box.getVector(ITEMS_TO_BE_DELETED);
			String obj = null;
			int note_no = box.getInt(TENDER_LPO_NOTE_NO);
			for (int i = 0; i < delete.size(); i++) {
				int item_id = Integer.parseInt(delete.get(i).toString());
				int id = 0;
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				storeTenderLocalPurchaseTList = hbt
						.find("from jkt.hms.masters.business.StoreTenderLocalPurchaseT as a where a.StoreTenderLocalPurchaseM.NoteNo = "
								+ note_no + " and a.Item.Id = " + item_id);
				if (storeTenderLocalPurchaseTList != null
						&& storeTenderLocalPurchaseTList.size() > 0)
					id = storeTenderLocalPurchaseTList.get(0).getId();
				String hql = "delete from jkt.hms.masters.business.StoreTenderLocalPurchaseT as a where a.Id like :id ";
				Query query = session.createQuery(hql).setParameter("id", id);
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

		map = getLPOGridData(box);
		return map;
	}

	public Map<String, Object> updateLPOGridItems(Box box) {
		// TODO Auto-generated method stub
		List<StoreTenderLocalPurchaseT> storeTenderLocalPurchaseTList = new ArrayList<StoreTenderLocalPurchaseT>();
		StoreTenderLocalPurchaseT storeTenderLocalPurchaseT = new StoreTenderLocalPurchaseT();
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Vector srno = box.getVector(TENDER_LPO_SRNO);
			Vector qty = box.getVector(TENDER_LPO_QTY);
			Vector items = box.getVector(TENDER_LPO_ITEM_ID);
			Vector rate = box.getVector(TENDER_LPO_RATE_PER_MDQ);
			Integer actual_qty = null;

			String obj = null;
			for (int i = 0; i < srno.size(); i++) {
				int item_id = Integer.parseInt(items.get(i).toString());
				storeTenderLocalPurchaseTList = hbt
						.find("from jkt.hms.masters.business.StoreTenderLocalPurchaseT as inp where inp.StoreTenderLocalPurchaseM.NoteNo = '"
								+ box.getInt(TENDER_LPO_NOTE_NO)
								+ "' and inp.Item.Id= " + item_id);
				MasStoreItem masStoreItem = (MasStoreItem) hbt.load(
						MasStoreItem.class, item_id);

				if (storeTenderLocalPurchaseTList != null
						&& storeTenderLocalPurchaseTList.size() > 0) {
					storeTenderLocalPurchaseT = storeTenderLocalPurchaseTList
							.get(0);
					if (qty.get(i).toString().trim().length() > 0) {
						storeTenderLocalPurchaseT.setQtyRecd(new Integer(qty
								.get(i).toString()));
						if (masStoreItem.getItemConversion().getFormula()
								.equals("1")) {
							actual_qty = (storeTenderLocalPurchaseT
									.getQtyRecd() * masStoreItem
									.getItemConversion().getConversionFactor1())
									/ (storeTenderLocalPurchaseT.getMdqValue()
											.intValue());
							// if (actual_qty == 0
							// && storeTenderLocalPurchaseT.getQtyRecd() != 0) {
							// actual_qty = 1;
							// }
						} else {
							actual_qty = storeTenderLocalPurchaseT.getQtyRecd();
						}
						storeTenderLocalPurchaseT.setActualQty(actual_qty);
					} else {
						storeTenderLocalPurchaseT.setActualQty(0);
						storeTenderLocalPurchaseT.setQtyRecd(0);
					}
					storeTenderLocalPurchaseT.setAmount(new BigDecimal(rate
							.get(i).toString()).multiply(new BigDecimal(
							actual_qty)));

				}

				else {
					storeTenderLocalPurchaseT.setQtyRecd(new Integer(0));
					storeTenderLocalPurchaseT.setAmount(new BigDecimal(0));
				}
				hbt.update(storeTenderLocalPurchaseT);

			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map = getLPOGridData(box);
		return map;
	}

	public Map<String, Object> getConnection(Box box) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		map.put("conn", con);
		return map;
	}

	public Map<String, Object> getGroupAndTenderAndSupplierComboDetailsForPNC(
			Box box) {
		// TODO Auto-generated method stub
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreGroup> masStoreGroupList = new ArrayList<MasStoreGroup>();
		List<StoreTenderM> storeTenderMList = new ArrayList<StoreTenderM>();
		List<MasStoreSupplier> masStoreSupplierList = new ArrayList<MasStoreSupplier>();

		session = (Session) getSession();

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			if (!box.getString(TENDER_NO).equals("")
					&& !box.getString(TENDER_SUPPLIER_GROUP_ID).equals("")) {
				masStoreSupplierList = hbt
						.find("select distinct inp.Supplier from jkt.hms.masters.business.StoreTenderCommBidT inp where inp.CommBid.Tender.Id="
								+ box.get(TENDER_NO)
								+ " and inp.CommBid.Group.Id = "
								+ box.get(TENDER_SUPPLIER_GROUP_ID)
								+ " and inp.Lcat = 1");
				/*
				 * masStoreGroupList = hbt.find(
				 * "select distinct inp.Group from jkt.hms.masters.business.StoreTenderToSupplier inp "
				 * );
				 */
				masStoreGroupList = hbt
						.find("from jkt.hms.masters.business.MasStoreGroup");

				storeTenderMList = hbt
						.find("select distinct inp.Tender from jkt.hms.masters.business.StoreTenderToSupplier inp where inp.Group.Id="
								+ box.get(TENDER_SUPPLIER_GROUP_ID));
				/*
				 * storeTenderMList = hbt
				 * .find("from jkt.hms.masters.business.StoreTenderM");
				 */
				map.put("masStoreSupplierList", masStoreSupplierList);
				map.put("masStoreGroupList", masStoreGroupList);
				map.put("storeTenderMList", storeTenderMList);
			} else if (!box.getString(TENDER_SUPPLIER_GROUP_ID).equals("")) {
				storeTenderMList = hbt
						.find("select distinct inp.Tender from jkt.hms.masters.business.StoreTenderToSupplier inp where inp.Group.Id="
								+ box.get(TENDER_SUPPLIER_GROUP_ID));
				/*
				 * masStoreGroupList = hbt.find(
				 * "select distinct inp.Group from jkt.hms.masters.business.StoreTenderToSupplier inp "
				 * );
				 */
				masStoreGroupList = hbt
						.find("from jkt.hms.masters.business.MasStoreGroup");
				map.put("masStoreGroupList", masStoreGroupList);
				map.put("storeTenderMList", storeTenderMList);
			} else {
				/*
				 * masStoreGroupList = hbt.find(
				 * "select distinct inp.Group from jkt.hms.masters.business.StoreTenderToSupplier inp"
				 * );
				 */
				masStoreGroupList = hbt
						.find("from jkt.hms.masters.business.MasStoreGroup");
				map.put("masStoreGroupList", masStoreGroupList);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> getTenderPNCGrid(Box box) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;
		List<StoreTenderCommBidM> storeTenderCommBidMList = new ArrayList<StoreTenderCommBidM>();
		List<StoreTenderCommBidT> storeTenderCommBidTList = new ArrayList<StoreTenderCommBidT>();
		List<MasStoreItem> masStoreItemList = new ArrayList<MasStoreItem>();

		int item_id = 0;
		String pvms = null;
		String nomenclature = null;
		String firm_name = null;
		String brand_name = null;
		String manuf_name = null;
		String disp_type = null;
		// int mdq = 0;
		BigDecimal mdq = new BigDecimal(0);
		BigDecimal vat = null;
		BigDecimal rate_per_mdq = null;
		BigDecimal comp_rate = null;
		BigDecimal mrp = null;
		BigDecimal final_price_per_mdq = null;
		BigDecimal tax_amt_mdq = null;
		BigDecimal tot_rate_mdq = null;
		BigDecimal new_rate_mdq = null;
		BigDecimal new_taxamt_mdq = null;
		BigDecimal new_totrate_mdq = null;

		String lcat = null;
		String remarks = null;
		String status = "";

		StoreTenderCommBidM storeTenderCommBidM = new StoreTenderCommBidM();
		Session session = (Session) getSession();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			int tender_id = box.getInt(TENDER_NO);
			int group_id = box.getInt(TENDER_SUPPLIER_GROUP_ID);
			int supplier_id = box.getInt(TENDER_VENDOR_SUPPLIER_ID);

			if (box.getString("pvmsNo").length() > 0) {
				String strForPvms = box.getString("pvmsNo");
				storeTenderCommBidTList = hbt
						.find("from jkt.hms.masters.business.StoreTenderCommBidT as inp where inp.Supplier.Id = "
								+ supplier_id
								+ " and inp.CommBid.Tender.Id = "
								+ tender_id
								+ " and inp.Lcat = 1"
								+ " and inp.CommBid.Item.PvmsNo like '"
								+ strForPvms + "%'");
			} else {
				storeTenderCommBidTList = hbt
						.find("from jkt.hms.masters.business.StoreTenderCommBidT as inp where inp.Supplier.Id = "
								+ supplier_id
								+ " and inp.CommBid.Tender.Id = "
								+ tender_id + " and inp.Lcat = 1");
			}
			if (storeTenderCommBidTList != null
					&& storeTenderCommBidTList.size() > 0) {
				/*
				 * status = storeTenderCommBidTList.get(0).getCommBid()
				 * .getStatus();
				 */
				for (Iterator iterator = storeTenderCommBidTList.iterator(); iterator
						.hasNext();) {
					StoreTenderCommBidT storeTenderCommBidT = (StoreTenderCommBidT) iterator
							.next();
					storeTenderCommBidM = (StoreTenderCommBidM) storeTenderCommBidT
							.getCommBid();
					MasStoreItem masStoreItem = storeTenderCommBidM.getItem();

					try {
						firm_name = storeTenderCommBidT.getSupplier()
								.getSupplierName();
					} catch (Exception e) {
						firm_name = "";
					}

					try {
						nomenclature = masStoreItem.getNomenclature();
					} catch (Exception e) {
						nomenclature = "";
					}

					try {
						pvms = masStoreItem.getPvmsNo();
					} catch (Exception e) {
						pvms = "";
					}

					try {
						item_id = masStoreItem.getId();
					} catch (Exception e) {
						item_id = 0;
					}

					try {
						brand_name = storeTenderCommBidT.getBrandName();
					} catch (Exception e) {
						brand_name = "";
					}

					try {
						manuf_name = storeTenderCommBidT.getManufacturerName();
					} catch (Exception e) {
						manuf_name = "";
					}

					try {
						disp_type = storeTenderCommBidT.getDispType();
					} catch (Exception e) {
						disp_type = "";
					}

					try {
						mdq = storeTenderCommBidT.getMdqValue();
					} catch (Exception e) {
						mdq = new BigDecimal(0);
					}

					try {
						vat = storeTenderCommBidT.getVatPercent();
					} catch (Exception e) {
						vat = new BigDecimal(0);
					}

					try {
						rate_per_mdq = storeTenderCommBidT.getRatePerMdq();
					} catch (Exception e) {
						rate_per_mdq = new BigDecimal(0);
					}

					try {
						comp_rate = storeTenderCommBidT.getCompRate();
					} catch (Exception e) {
						comp_rate = new BigDecimal(0);
					}

					try {
						lcat = storeTenderCommBidT.getLcat();
					} catch (Exception e) {
						lcat = "";
					}

					try {
						final_price_per_mdq = storeTenderCommBidT
								.getFinalPricePerMdq();
					} catch (Exception e) {
						final_price_per_mdq = new BigDecimal(0);
					}

					try {
						remarks = storeTenderCommBidT.getRemarks();
					} catch (Exception e) {
						remarks = "";
					}

					try {
						supplier_id = storeTenderCommBidT.getSupplier().getId();
					} catch (Exception e) {
						supplier_id = 0;
					}

					try {
						mrp = storeTenderCommBidT.getMrp();
					} catch (Exception e) {
						mrp = new BigDecimal(0);
					}

					try {
						tax_amt_mdq = storeTenderCommBidT.getTaxAmountMdq();
					} catch (Exception e) {
						tax_amt_mdq = new BigDecimal(0);
					}

					try {
						tot_rate_mdq = storeTenderCommBidT.getTotRateMdq();
					} catch (Exception e) {
						tot_rate_mdq = new BigDecimal(0);
					}

					try {
						new_rate_mdq = storeTenderCommBidT.getNewRatePerMdq();
					} catch (Exception e) {
						new_rate_mdq = new BigDecimal(0);
					}

					try {
						new_taxamt_mdq = storeTenderCommBidT
								.getNewTaxAmtPerMdq();
					} catch (Exception e) {
						new_taxamt_mdq = new BigDecimal(0);
					}

					try {
						new_totrate_mdq = storeTenderCommBidT
								.getNewTotRateMdq();
					} catch (Exception e) {
						new_totrate_mdq = new BigDecimal(0);
					}

					hData = new HashMap<String, Object>();
					hData.put(TENDER_CB_SUPPLIER_ID, supplier_id);
					hData.put(TENDER_CB_FIRM_NAME, firm_name);
					hData.put(TENDER_CB_BRAND_NAME, brand_name);
					hData.put(TENDER_CB_MANF_NAME, manuf_name);
					hData.put(TENDER_CB_DISP_TYPE, disp_type);
					hData.put(TENDER_CB_MDQ, mdq);
					hData.put(TENDER_CB_VAT, vat);
					hData.put(TENDER_CB_RATE_PER_MDQ, rate_per_mdq);
					hData.put(TENDER_CB_COMP_RATE, comp_rate);
					hData.put(TENDER_CB_LCAT, lcat);
					hData.put(TENDER_CB_FINAL_PRICE_PER_MDQ,
							final_price_per_mdq);
					hData.put(TENDER_CB_MRP, mrp);
					hData.put(TENDER_CB_REMARKS, remarks);
					hData.put(TENDER_NOMENCLATURE, nomenclature);
					hData.put(TENDER_PVMS, pvms);
					hData.put(TENDER_ITEM_ID, item_id);
					hData.put(ITEM_STATUS, storeTenderCommBidM.getStatus());
					hData.put(TAX_AMT_MDQ, tax_amt_mdq);
					hData.put(TOT_RATE_MDQ, tot_rate_mdq);
					hData.put(NEW_RATE_MDQ, new_rate_mdq);
					hData.put(NEW_TAXAMT_MDQ, new_taxamt_mdq);
					hData.put(NEW_TOTRATE_MDQ, new_totrate_mdq);

					if (storeTenderCommBidM.getStatus().equalsIgnoreCase("O")) {
						status = storeTenderCommBidM.getStatus();
					}
					vResult.add(hData);
				} // for ends here
			} // if ends here
		} // try ends here
		catch (HibernateException e) {
			e.printStackTrace();
		}

		if (vResult.size() > 0) {
			testPageData = new HashMap[vResult.size()];
			vResult.copyInto(testPageData);

			try {
				pagedArray = new PageUtil().convertToPagedArrayIndex(
						testPageData, box);
			}

			catch (Exception e) {
				e.printStackTrace();
			}
		}
		map = getGroupAndTenderAndSupplierComboDetailsForPNC(box);
		map.put("pagedArray", pagedArray);
		map.put("status", status);
		return map;
	}

	public Map<String, Object> updatePNCGridItems(Box box) {
		List<StoreTenderCommBidM> storeTenderCommBidMList = new ArrayList<StoreTenderCommBidM>();
		List<StoreTenderCommBidT> storeTenderCommBidTList = new ArrayList<StoreTenderCommBidT>();
		Map<String, Object> map = new HashMap<String, Object>();
		StoreTenderCommBidM storeTenderCommBidM = new StoreTenderCommBidM();
		StoreTenderCommBidT storeTenderCommBidT = new StoreTenderCommBidT();
		List<StoreTenderCommHodRecom> storeTenderCommHodRecomList = new ArrayList<StoreTenderCommHodRecom>();
		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;
		String status = "";

		Session session = (Session) getSession();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			Vector srno = box.getVector(TENDER_CB_SLNO);
			/*
			 * Vector final_price_per_mdq_vector = box
			 * .getVector(TENDER_CB_FINAL_PRICE_PER_MDQ);
			 */
			Vector new_rate_mdq = box.getVector(NEW_RATE_MDQ);
			Vector new_taxamt_mdq = box.getVector(NEW_TAXAMT_MDQ);
			Vector new_totrate_mdq = box.getVector(NEW_TOTRATE_MDQ);
			Vector remarks_vector = box.getVector(TENDER_CB_REMARKS);
			Vector items = box.getVector(TENDER_ITEM_ID);

			int tender_id = box.getInt(TENDER_NO);
			int group_id = box.getInt(TENDER_SUPPLIER_GROUP_ID);
			int supplier_id = box.getInt(TENDER_VENDOR_SUPPLIER_ID);
			int item_id = 0;

			for (int i = 0; i < srno.size(); i++) {
				item_id = Integer.parseInt(items.get(i).toString());
				storeTenderCommBidTList = hbt
						.find("from jkt.hms.masters.business.StoreTenderCommBidT as inp where inp.CommBid.Tender.Id = "
								+ tender_id
								+ " and inp.CommBid.Group.Id = "
								+ group_id
								+ " and inp.Supplier.Id = "
								+ supplier_id
								+ " and inp.CommBid.Item.Id = "
								+ item_id);

				if (storeTenderCommBidTList.size() > 0) {
					storeTenderCommBidT = storeTenderCommBidTList.get(0);
					status = storeTenderCommBidT.getCommBid().getStatus();

					storeTenderCommBidT.setFinalPricePerMdq(new BigDecimal(0));

					try {
						storeTenderCommBidT.setNewRatePerMdq(new BigDecimal(
								new_rate_mdq.get(i).toString()));
					} catch (Exception e) {
						storeTenderCommBidT.setNewRatePerMdq(new BigDecimal(0));
					}
					try {
						storeTenderCommBidT.setNewTaxAmtPerMdq(new BigDecimal(
								new_taxamt_mdq.get(i).toString()));
					} catch (Exception e) {
						storeTenderCommBidT
								.setNewTaxAmtPerMdq(new BigDecimal(0));
					}
					try {
						storeTenderCommBidT.setNewTotRateMdq(new BigDecimal(
								new_totrate_mdq.get(i).toString()));
					} catch (Exception e) {
						storeTenderCommBidT.setNewTotRateMdq(new BigDecimal(0));
					}

					try {
						storeTenderCommBidT.setRemarks(remarks_vector.get(i)
								.toString());
					} catch (Exception e) {
						storeTenderCommBidT.setRemarks("");
					}

					hbt.update(storeTenderCommBidT);
				} // end of if ....
			} // end of for loop...
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map = getTenderPNCGrid(box);
		map.put("status", status);
		return map;
	}

	public Map<String, Object> getItemListForTenderForNomenclatureByAutocomplete(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreTenderT> itemList = new ArrayList<StoreTenderT>();
		Session session = (Session) getSession();
		int deptId = 0;
		deptId = Integer.parseInt("" + dataMap.get("deptId"));
		List objectList = new ArrayList();
		try {
			String str = "%" + dataMap.get("autoHint") + "%";
			String qry = "SELECT item_id FROM store_tender_t";
			objectList = (List) session.createSQLQuery(qry).list();
			Criteria c = session.createCriteria(MasStoreItem.class).add(
					Restrictions.like("Nomenclature", str)).add(
					Restrictions.in("Id", objectList));
			c.setFirstResult(0);
			c.setMaxResults(10);
			itemList = c.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("itemList", itemList);
		return map;
	}

	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> connectionMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		connectionMap.put("con", con);
		return connectionMap;
	}

	public Map<String, Object> doAddTenderProposalItems(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		session = (Session) getSession();
		Vector items = box.getVector(TENDER_ITEM_ID);
		Vector qtymmf = box.getVector(TENDER_MMFQTY);
		Vector annreq = box.getVector(TENDER_ANNREQ);
		Vector items_to_be_added = box.getVector(ITEMS_TO_BE_ADDED);
		StoreTenderProposal storeTenderProposal = null;
		MasStoreItem masStoreItem = null;
		int deptId = box.getInt("deptId");
		int hospitalId = box.getInt("hospitalId");

		int sr_no = 0;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);

			for (int i = 0; i < items.size(); i++) {
				if (items_to_be_added.contains(items.get(i))) {
					masStoreItem = new MasStoreItem();
					masStoreItem
							.setId(Integer.valueOf(items.get(i).toString()));

					storeTenderProposal = new StoreTenderProposal();

					storeTenderProposal.setItem(masStoreItem);
					storeTenderProposal
							.setDepartment(new MasDepartment(deptId));
					storeTenderProposal
							.setHospital(new MasHospital(hospitalId));
					try {
						storeTenderProposal.setQtyInMmf(new BigDecimal(qtymmf
								.get(i).toString()));
					} catch (Exception e) {
						storeTenderProposal.setQtyInMmf(new BigDecimal(0));
					}
					try {
						storeTenderProposal.setTenderQty(new BigDecimal(annreq
								.get(i).toString()));
					} catch (Exception e) {
						storeTenderProposal.setTenderQty(new BigDecimal(0));
					}
					storeTenderProposal.setLastChgBy(box.get(CHANGED_BY));
					storeTenderProposal.setLastChgDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(CHANGED_DATE)));
					storeTenderProposal.setLastChgTime(box.get(CHANGED_TIME));
					storeTenderProposal.setStatus("o");
					hbt.save(storeTenderProposal);
				}
			}

			map.put("total_records", items.size());
			map.put("added_records", items_to_be_added.size());

			if (items.size() == items_to_be_added.size()) {
				if (box.getInt("currPage") > 1)
					box.put("currPage", box.getInt("currPage") - 1);
			}
			if (!box.getString("itemIdForNextRecord").equals("null")) {
				map = getItemDetailsForNextRecord(box);
			} else {
				map = getItemDetails(box);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> showTenderProposalJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;
		StoreTenderProposal storeTenderProposal = new StoreTenderProposal();

		String pvms = null;
		String nomenclature = null;
		String strength = null;
		String disp_type = null;
		String au = null;
		BigDecimal qtymmf = null;
		BigDecimal annreq = null;
		int item_id = 0;
		Criteria c = null;

		List<StoreTenderProposal> storeTenderProposalList = new ArrayList<StoreTenderProposal>();
		List<MasStoreGroup> masStoreGroupList = new ArrayList<MasStoreGroup>();
		List<Object> existingList = new ArrayList<Object>();
		List<StoreTenderM> storeTenderMList = new ArrayList<StoreTenderM>();
		Session session = (Session) getSession();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			//System.out.println("::::::::::::" + box.getInt("groupId"));
			masStoreGroupList = hbt
					.find("from jkt.hms.masters.business.MasStoreGroup");

			if (box.getInt("groupId") != 0 && !box.get("groupId").equals("")) {
				if (box.getString("pvmsNo").length() > 0) {
					/*
					 * storeTenderProposalList = hbt.find(
					 * "from jkt.hms.masters.business.StoreTenderProposal as inp where inp.Status='o' and inp.Department.Id = "
					 * + box.getInt("deptId")+"");
					 */
					String strForPvms = box.getString("pvmsNo");
					//System.out.println("value of strForPvms in ds layer------"+ strForPvms);
					strForPvms = strForPvms.replace(" ", "%") + "%";
					c = session.createCriteria(StoreTenderProposal.class)
							.createAlias("Item", "item").add(
									Restrictions
											.like("item.PvmsNo", strForPvms))
							.createAlias("Department", "department").add(
									Restrictions.eq("department.Id", box
											.getInt("deptId"))).add(
									Restrictions.eq("item.Group.Id", box
											.getInt("groupId"))).add(
									Restrictions.eq("Status", "o"));
					storeTenderProposalList = c.list();

				} else {
					storeTenderProposalList = session.createCriteria(
							StoreTenderProposal.class).createAlias("Item",
							"item").add(
							Restrictions.eq("Department.Id", box
									.getInt("deptId"))).add(
							Restrictions.eq("item.Group.Id", box
									.getInt("groupId"))).add(
							Restrictions.eq("Status", "o"))
							.addOrder(Order.asc("item.PvmsNo")).list();

					/*
					 * String qry = "SELECT s.* FROM store_tender_proposal s," +
					 * "mas_store_item m where s.status = 'o' and m.item_id = s.item_id "
					 * + "and m.group_id = '" + box.getInt("groupId") +
					 * "' and s.department_id ='"+box.getInt("deptId")+"'";
					 */

					// storeTenderProposalList = (List)
					// session.createSQLQuery(qry).list();
					/*
					 * storeTenderProposalList = hbt.find(
					 * "from jkt.hms.masters.business.StoreTenderProposal as inp where inp.Status='o' and inp.Department.Id = "
					 * + box.getInt("deptId"));
					 */
				}
				String qry = "select i.group_id from store_tender_proposal p,mas_store_item i where p.item_id = i.item_id and p.status = 'o'"
						+ " and i.group_id  = '"
						+ box.getInt("groupId")
						+ "' and p.department_id = '"
						+ box.getInt("deptId")
						+ "'";
				existingList = session.createSQLQuery(qry).list();
				storeTenderMList = hbt
						.find("from jkt.hms.masters.business.StoreTenderM where Group.Id = '"
								+ box.getInt("groupId") + "'");

			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		for (Iterator iterator = storeTenderProposalList.iterator(); iterator
				.hasNext();) {

			storeTenderProposal = (StoreTenderProposal) iterator.next();
			BigDecimal qtyInHand = null;
			MasStoreItem masStoreItem = new MasStoreItem();
			masStoreItem = storeTenderProposal.getItem();
			List<StoreItemBatchStock> storeItemBatchStockList = new ArrayList<StoreItemBatchStock>();
			String str = "select round(sum(inp.closing_stock),2) from store_item_batch_stock as inp where department_id = "
					+ box.getInt("deptId")
					+ " and item_id = "
					+ masStoreItem.getId();
			storeItemBatchStockList = session.createSQLQuery(str).list();
			Iterator iterator1 = storeItemBatchStockList.iterator();
			while (iterator1.hasNext()) {
				qtyInHand = (BigDecimal) iterator1.next();
			}

			try {
				pvms = storeTenderProposal.getItem().getPvmsNo();
			} catch (Exception e) {
				pvms = "";
			}

			try {
				nomenclature = storeTenderProposal.getItem().getNomenclature();
			} catch (Exception e) {
				nomenclature = "";
			}

			try {
				strength = storeTenderProposal.getItem().getStrength();
			} catch (Exception e) {
				strength = "";
			}

			try {
				au = storeTenderProposal.getItem().getItemConversion()
						.getPurchaseUnit().getUnitName();
			} catch (Exception e) {
				au = "";
			}

			try {
				disp_type = storeTenderProposal.getItem().getItemConversion()
						.getIntermediateUnit().getUnitName();
			} catch (Exception e) {
				disp_type = "";
			}

			try {
				// qtymmf = storeTenderProposal.getQtyInMmf();
				qtymmf = new BigDecimal(new DecimalFormat("0.00##")
						.format(Double.valueOf(storeTenderProposal
								.getQtyInMmf().toString())));
			} catch (Exception e) {
				qtymmf = new BigDecimal(0);
			}

			try {

				// annreq = storeTenderProposal.getTenderQty();
				annreq = new BigDecimal(new DecimalFormat("0.00##")
						.format(Double.valueOf(storeTenderProposal
								.getTenderQty().toString())));
			} catch (Exception e) {
				annreq = new BigDecimal(0);
			}

			try {
				item_id = storeTenderProposal.getItem().getId();
			} catch (Exception e) {
				item_id = 0;
			}

			hData = new HashMap<String, Object>();
			hData.put(TENDER_ITEM_ID, item_id);
			hData.put(TENDER_PVMS, pvms);
			hData.put(TENDER_NOMENCLATURE, nomenclature);
			hData.put(TENDER_STRENGTH, strength);
			hData.put(TENDER_MMFQTY, qtymmf);
			hData.put(TENDER_ANNREQ, annreq);
			hData.put(TENDER_AU, au);
			hData.put("disp_type", disp_type);
			hData.put(TENDER_STOCK_IN_HAND, qtyInHand);

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
		map.put("masStoreGroupList", masStoreGroupList);
		map.put("existingList", existingList);
		map.put("storeTenderMList", storeTenderMList);
		return map;
	}

	public Map<String, Object> updateTenderProposalGridItems(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreTenderProposal> storeTenderProposalList = new ArrayList<StoreTenderProposal>();
		StoreTenderProposal storeTenderProposal = new StoreTenderProposal();
		Session session = (Session) getSession();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Vector srno = box.getVector(TENDER_SRNO);
			Vector annreq = box.getVector(TENDER_ANNREQ);
			Vector items = box.getVector(TENDER_ITEM_ID);

			String obj = null;
			for (int i = 0; i < srno.size(); i++) {
				int item_id = Integer.parseInt(items.get(i).toString());
				storeTenderProposalList = hbt
						.find("from jkt.hms.masters.business.StoreTenderProposal as inp where inp.Item.Id= "
								+ item_id
								+ " and inp.Status='o' and inp.Department.Id = "
								+ box.getInt("deptId"));
				if (storeTenderProposalList.size() > 0) {
					storeTenderProposal = storeTenderProposalList.get(0);
					if (annreq.get(i).toString().trim().length() > 0) {
						storeTenderProposal.setTenderQty(new BigDecimal(annreq
								.get(i).toString()));
					} else {
						storeTenderProposal.setTenderQty(new BigDecimal(0));
					}
					hbt.update(storeTenderProposal);
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map = showTenderProposalJsp(box);
		return map;
	}

	public Map<String, Object> deleteTenderProposalGridItems(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreTenderProposal> storeTenderProposalList = new ArrayList<StoreTenderProposal>();
		StoreTenderProposal storeTenderProposal = new StoreTenderProposal();
		Session session = (Session) getSession();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Vector srno = box.getVector(TENDER_SRNO);
			Vector annreq = box.getVector(TENDER_ANNREQ);
			Vector items = box.getVector(TENDER_ITEM_ID);
			Vector delete = box.getVector(ITEMS_TO_BE_DELETED);

			String obj = null;
			for (int i = 0; i < delete.size(); i++) {
				int item_id = Integer.parseInt(delete.get(i).toString());
				int id = 0;
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				storeTenderProposalList = hbt
						.find("from jkt.hms.masters.business.StoreTenderProposal as a where a.Item.Id="
								+ item_id
								+ " and a.Status='o' and a.Department.Id = "
								+ box.getInt("deptId"));
				if (storeTenderProposalList != null
						&& storeTenderProposalList.size() > 0) {
					id = storeTenderProposalList.get(0).getId();
				}
				String hql = "delete from jkt.hms.masters.business.StoreTenderProposal as a where a.Id like :id";
				Query query = session.createQuery(hql).setParameter("id", id);
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

		map = showTenderProposalJsp(box);
		return map;
	}

	public Map<String, Object> createTenderMasterAndTransactionForProposals(
			Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;
		StoreIndentT storeIndentT = null;
		StoreIndentM storeIndentM = null;

		String pvms = null;
		String nomenclature = null;
		String strength = null;
		String au = null;
		BigDecimal qtymmf = null;
		BigDecimal annreq = null;
		int item_id = 0;
		int mmf_tender_month = 2;

		List<StoreTenderProposal> storeTenderProposalList1 = new ArrayList<StoreTenderProposal>();
		List<StoreTenderProposal> storeTenderProposalList2 = new ArrayList<StoreTenderProposal>();
		List<StoreSetup> storeSetupList = new ArrayList<StoreSetup>();
		StoreTenderProposal storeTenderProposal = new StoreTenderProposal();
		List existingTenderNumbersList = null;

		Session session = (Session) getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			StoreTenderM storeTenderM = new StoreTenderM();

			int hospital_id = Integer
					.parseInt(box.get("hospitalId").toString());
			int deptId = box.getInt("deptId");

			String groupId = box.getString("groupId");

			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(new Integer(deptId));

			MasHospital masHospital = new MasHospital();
			masHospital.setId(new Integer(hospital_id));

			storeTenderM.setHospital(masHospital);
			storeTenderM.setDepartment(masDepartment);
			storeTenderM.setTenderNo(box.get(TENDER_NO));
			storeTenderM.setTenderInvitationDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.get(DATE_INVITE_TENDER)));
			storeTenderM
					.setCommOfIssueDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(DATE_COMMENCEMENT)));
			storeTenderM.setIssueLastDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.get(LAST_DATE_TENDER_DOCUMENT)));
			storeTenderM.setTenderReceiptTime(box
					.get(TIME_RECEIPT_TENDER_SAMPLES));
			storeTenderM.setTenderReceiptPlace(box
					.get(PLACE_RECEIPT_TENDER_SAMPLES));
			storeTenderM.setTenderRecLastDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.get(LAST_DATE_RECEIPT_TENDER_SAMPLES)));
			storeTenderM.setTechnicalOpeningDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.get(DATE_OPENING_TECHNICAL)));
			storeTenderM.setCommercialOpeningDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.get(DATE_OPENING_COMMERCIAL)));
			storeTenderM.setTermsAndConditions(box.get(TERMS_CONDITIONS));
			storeTenderM.setLastChangedBy(box.get(CHANGED_BY));
			storeTenderM.setLastChangedDate(HMSUtil
					.convertStringTypeDateToDateType(box.get(CHANGED_DATE)));
			storeTenderM.setLastChangedTime(box.get(CHANGED_TIME));
			storeTenderM.setStatus("O");
			storeTenderM.setGroup(new MasStoreGroup(Integer.parseInt(groupId)));
			hbt.save(storeTenderM);
			hbt.refresh(storeTenderM);

			List<StoreSetup> storeSetupList1 = new ArrayList<StoreSetup>();
			storeSetupList1 = hbt
					.find("from jkt.hms.masters.business.StoreSetup");
			int exp_dept_id1 = storeSetupList1.get(0).getStoreExpendable()
					.getId();

			Criteria c = session.createCriteria(StoreFyDocumentNo.class).add(
					Restrictions.eq("Department.Id", exp_dept_id1));
			storeFyDocumentNoList = c.list();
			String tndStartNo = "";
			for (StoreFyDocumentNo storeFyDocumentNo : storeFyDocumentNoList) {
				if (storeFyDocumentNo.getTenderNo() != null) {
					tndStartNo = ("" + storeFyDocumentNo.getTenderNo());
					tndStartNo = getMaxNo(tndStartNo);
				} else {
					tndStartNo = getMaxNo("");
				}
			}
			int storeFyId = 0;
			for (StoreFyDocumentNo documentNo : storeFyDocumentNoList) {
				storeFyId = documentNo.getId();
			}

			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) getHibernateTemplate()
					.load(StoreFyDocumentNo.class, storeFyId);
			storeFyDocumentNo.setTenderNo(tndStartNo);
			hbt.update(storeFyDocumentNo);
			hbt.refresh(storeFyDocumentNo);

			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			List<StoreTenderM> storeTenderMList = new ArrayList<StoreTenderM>();
			storeTenderMList = hbt
					.find("from jkt.hms.masters.business.StoreTenderM as inp where inp.TenderNo='"
							+ box.get(TENDER_NO).toString() + "'");

			int tender_id = 0;
			if (storeTenderMList.size() > 0) {
				storeTenderM = (StoreTenderM) storeTenderMList.get(0);
				tender_id = storeTenderM.getId();
			}

			storeTenderM = new StoreTenderM();
			storeTenderM.setId(tender_id);

			// String str = "select item_id, SUM(qty_in_mmf) total_qty_in_mmf ,
			// sum(tender_qty) total_tender_qty from store_tender_proposal where
			// status='o' group by item_id";
			String str = "select s.item_id, SUM(s.qty_in_mmf) total_qty_in_mmf , sum(s.tender_qty) total_tender_qty "
					+ "from store_tender_proposal s, mas_store_item m where s.status='o' and m.item_id = s.item_id "
					+ "and m.group_id ='" + groupId + "'group by s.item_id";
			List list = new ArrayList();
			list = session.createSQLQuery(str).list();
			Iterator ite = list.iterator();
			BigDecimal total_mmf_qty = new BigDecimal(0);
			BigDecimal total_tender_qty = new BigDecimal(0);
			BigDecimal qtyInHand = new BigDecimal(0);
			MasStoreItem masStoreItem = new MasStoreItem();
			BigDecimal echs_tender_qty = new BigDecimal(0);
			BigDecimal exp_tender_qty = new BigDecimal(0);
			int i = 0;
			while (ite.hasNext()) {
				Object[] pair = (Object[]) ite.next();

				if (pair[0] != null)
					item_id = (Integer) pair[0];

				if (pair[1] != null)
					total_mmf_qty = (BigDecimal) pair[1];

				if (pair[2] != null)
					total_tender_qty = (BigDecimal) pair[2];

				List<MasStoreItem> masStoreItemList = new ArrayList<MasStoreItem>();
				masStoreItemList = hbt
						.find("from jkt.hms.masters.business.MasStoreItem as inp where inp.Id ="
								+ item_id);

				if (masStoreItemList != null && masStoreItemList.size() > 0) {
					masStoreItem = masStoreItemList.get(0);
				}
				storeSetupList = hbt
						.find("from jkt.hms.masters.business.StoreSetup");
				int echs_dept_id = storeSetupList.get(0).getStoreEchs().getId();
				int exp_dept_id = storeSetupList.get(0).getStoreExpendable()
						.getId();
				storeTenderProposalList1 = hbt
						.find("from jkt.hms.masters.business.StoreTenderProposal as inp where inp.Item.Id ="
								+ item_id
								+ " and inp.Department.Id="
								+ echs_dept_id + " and inp.Status='o'");
				storeTenderProposalList2 = hbt
						.find("from jkt.hms.masters.business.StoreTenderProposal as inp where inp.Item.Id ="
								+ item_id
								+ " and inp.Department.Id="
								+ exp_dept_id + " and inp.Status='o'");

				if (storeTenderProposalList1 != null
						&& storeTenderProposalList1.size() > 0) {
					storeTenderProposal = storeTenderProposalList1.get(0);
					echs_tender_qty = storeTenderProposal.getTenderQty();
					storeTenderProposal.setStatus("p");
					storeTenderProposal
							.setTenderId(new StoreTenderM(tender_id));
					hbt.update(storeTenderProposal);
				} else
					echs_tender_qty = new BigDecimal(0);

				if (storeTenderProposalList2 != null
						&& storeTenderProposalList2.size() > 0) {
					storeTenderProposal = storeTenderProposalList2.get(0);
					exp_tender_qty = storeTenderProposal.getTenderQty();
					storeTenderProposal.setStatus("p");
					storeTenderProposal
							.setTenderId(new StoreTenderM(tender_id));
					hbt.update(storeTenderProposal);
				} else
					exp_tender_qty = new BigDecimal(0);

				List<StoreItemBatchStock> storeItemBatchStockList = new ArrayList<StoreItemBatchStock>();
				str = "select sum(inp.closing_stock) from store_item_batch_stock as inp where department_id = "
						+ box.getInt("deptId") + " and item_id = " + item_id;
				storeItemBatchStockList = session.createSQLQuery(str).list();
				Iterator iterator1 = storeItemBatchStockList.iterator();
				while (iterator1.hasNext()) {
					qtyInHand = (BigDecimal) iterator1.next();
				}

				try {
					pvms = masStoreItem.getPvmsNo();
				} catch (Exception e) {
					pvms = "";
				}

				try {
					nomenclature = masStoreItem.getNomenclature();
				} catch (Exception e) {
					nomenclature = "";
				}

				try {
					strength = masStoreItem.getStrength();
				} catch (Exception e) {
					strength = "";
				}

				try {
					au = masStoreItem.getItemConversion().getPurchaseUnit()
							.getUnitName();
				} catch (Exception e) {
					au = "";
				}
				qtymmf = total_mmf_qty;
				annreq = total_tender_qty;

				hData = new HashMap<String, Object>();
				hData.put(TENDER_ITEM_ID, item_id);
				hData.put(TENDER_PVMS, pvms);
				hData.put(TENDER_NOMENCLATURE, nomenclature);
				hData.put(TENDER_STRENGTH, strength);
				hData.put(TENDER_MMFQTY, qtymmf);
				hData.put(TENDER_ANNREQ, annreq);
				hData.put(TENDER_AU, au);
				hData.put(TENDER_STOCK_IN_HAND, qtyInHand);
				hData.put("echs_tender_qty", echs_tender_qty);
				hData.put("exp_tender_qty", exp_tender_qty);

				vResult.add(hData);

				hbt.setFlushModeName("FLUSH_AUTO");
				hbt.setCheckWriteOperations(false);

				StoreTenderT storeTenderT = new StoreTenderT();
				storeTenderT.setTenderM(storeTenderM);
				storeTenderT.setItem(masStoreItem);
				storeTenderT.setSrNo(++i);
				storeTenderT.setQtyInMmf(qtymmf);
				storeTenderT.setTenderQty(annreq);

				hbt.save(storeTenderT);
			}
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
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
		map = getTenderNos(box);
		map.put("pagedArray", pagedArray);
		return map;
	}

	public Map<String, Object> getTenderSupplierListForLPO(Box box) {
		// TODO Auto-generated method stub
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		map = getGroupAndTenderComboDetails(box);
		List<StoreTenderCommBidM> storeTenderCommBidMList = new ArrayList<StoreTenderCommBidM>();
		List<StoreTenderCommBidT> storeTenderCommBidTList = new ArrayList<StoreTenderCommBidT>();

		String query = "";
		query = query + " select d.supplier_name,";
		query = query + " count(a.item_id) no_of_items,";
		query = query
				+ " round(sum(case f.formula when 1 then truncate(((c.tender_qty * f.conversion_factor1) / b.mdq_value),0) * b.new_totrate_mdq else  c.tender_qty * f.conversion_factor1 * b.new_totrate_mdq end),2) net_amount,";
		query = query + " b.supplier_id, a.status ";
		query = query
				+ " from store_tender_comm_bid_m a, store_tender_comm_bid_t b, store_tender_proposal c, mas_store_supplier d, mas_store_item e, mas_store_item_conversion f";
		query = query + " where a.id = b.comm_bid_id ";
		query = query + " and c.item_id = a.item_id ";
		query = query + " and a.item_id = e.item_id ";
		query = query + " and e.item_conversion_id = f.item_conversion_id ";
		query = query + " and b.supplier_id = d.supplier_id ";
		query = query + " and c.department_id = " + box.getInt("deptId");
		query = query + " and c.tender_id = " + box.getInt(TENDER_NO);
		query = query + " and a.tender_id = " + box.getInt(TENDER_NO);
		query = query + " and a.group_id = "
				+ box.getInt(TENDER_SUPPLIER_GROUP_ID);
		query = query + " and b.lcat=1 ";
		query = query + " group by b.supplier_id";

		List objectList = (List) session.createSQLQuery(query).list();
		//System.out.println("size " + objectList.size());
		map.put("objectList", objectList);
		return map;
	}

	public Map<String, Object> showSupplyOrderSplitUp(Box box) {
		// TODO Auto-generated method stub
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> cancelMap = new HashMap<String, Object>();
		Map<String, Object> remarksMap = new HashMap<String, Object>();
		Map<String, Object> supplierMap = new HashMap<String, Object>();
		Map<String, Object> lcatMap = new HashMap<String, Object>();
		Map<String, Object> l1catMap = new HashMap<String, Object>();
		List<StorePoHeader> storePoHeaderList = new ArrayList<StorePoHeader>();

		List<StorePoHeader> storePoRemain = new ArrayList<StorePoHeader>();

		Map dateMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) dateMap.get("currentDate");

		String query = "";

		query = query
				+ " select concat(d.supplier_name,' [',d.supplier_code,']') supplier_name, e.pvms_no, e.nomenclature, truncate(c.tender_qty,2),g.unit_name, b.disp_type, b.mdq_value, b.rate_per_mdq, b.comp_rate, ";
		query = query
				+ " round(case f.formula when 1 then truncate(((c.tender_qty * f.conversion_factor1) / b.mdq_value),0) * b.new_totrate_mdq else c.tender_qty * f.conversion_factor1 * b.new_totrate_mdq end,2) amount, ";
		query = query
				+ " c.po_id, a.item_id, concat(d.supplier_name,'[L',b.lcat,']'),b.new_rate_per_mdq,b.new_taxamt_per_mdq ";
		query = query
				+ " from store_tender_comm_bid_m a, store_tender_comm_bid_t b, store_tender_proposal c, mas_store_supplier d, mas_store_item e, mas_store_item_conversion f, mas_store_unit g";
		query = query + " where a.id = b.comm_bid_id ";
		query = query + " and c.item_id = a.item_id ";
		query = query + " and a.item_id = e.item_id ";
		query = query + " and e.item_conversion_id = f.item_conversion_id ";
		query = query + " and f.purchase_unit_id = g.unit_id ";
		query = query + " and b.supplier_id = d.supplier_id ";
		query = query + " and c.department_id = " + box.getInt("dept_id");
		query = query + " and c.tender_id = " + box.getInt("tender_id");
		query = query + " and a.tender_id = " + box.getInt("tender_id");
		query = query + " and a.group_id = " + box.getInt("group_id");
		query = query + " and b.lcat=1 ";
		query = query + " and b.supplier_id = " + box.getInt("supplier_id");
		query = query + " order by a.item_id ";
		List objectList = (List) session.createSQLQuery(query).list();

		for (Iterator iterator1 = objectList.iterator(); iterator1.hasNext();) {
			Object[] obj = (Object[]) iterator1.next();
			int item_id = (Integer) obj[11];
			List<StoreTenderCommBidT> L1List = new ArrayList<StoreTenderCommBidT>();
			L1List = session.createCriteria(StoreTenderCommBidT.class)
					.createAlias("CommBid", "M").add(
							Restrictions.eq("M.Tender.Id", box
									.getInt("tender_id"))).add(
							Restrictions.eq("M.Item.Id", item_id)).add(
							Restrictions.eq("Lcat", "1")).add(
							Restrictions.eq("Qualified", "Y")).list();

			l1catMap.put(String.valueOf(item_id), L1List);
			// //System.out.println("::::::::"+item_id+":::::::::"+L1List.size());
		}
		for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
			Object[] obj = (Object[]) iterator.next();
			String supplier_name = new String();
			// if (obj[10] != null) {
			System.out
					.println("---------------------obj[10]-----------------------------------"
							+ obj[10]);

			int item_id = (Integer) obj[11];

			// Find out the old po_id if exists otherwise use the new po_id
			// This is used to find out the cancelled items
			List<StorePoDetail> storePoDetailList = new ArrayList<StorePoDetail>();
			if (obj[10] != null) {

				int po_id = (Integer) obj[10];
				storePoDetailList = session.createCriteria(StorePoDetail.class)
						.createAlias("Po", "P").add(
								Restrictions.eq("P.Department.Id", box
										.getInt("dept_id"))).add(
								Restrictions.eq("P.Supplier.Id", box
										.getInt("supplier_id"))).add(
								Restrictions.eq("P.TenderM.Id", box
										.getInt("tender_id"))).add(
								Restrictions.eq("P.Group.Id", box
										.getInt("group_id"))).add(
								Restrictions.eq("Item.Id", item_id)).add(
								Restrictions.eq("P.Flag", "s")).add(
								Restrictions.isNotNull("ReSupplierId")).list();
				// //System.out.println("list:::::::::"+storePoDetailList+"::::::item::::"+item_id);

				if (storePoDetailList != null && storePoDetailList.size() > 0) {
					po_id = storePoDetailList.get(0).getPo().getId();
					supplierMap.put(String.valueOf(item_id), storePoDetailList
							.get(0).getReSupplierId().getSupplierName());
				}

				storePoDetailList = session.createCriteria(StorePoDetail.class)
						.createAlias("Po", "P").add(
								Restrictions.eq("P.Id", po_id)).add(
								Restrictions.eq("P.Department.Id", box
										.getInt("dept_id"))).add(
								Restrictions.eq("P.Supplier.Id", box
										.getInt("supplier_id"))).add(
								Restrictions.eq("P.TenderM.Id", box
										.getInt("tender_id"))).add(
								Restrictions.eq("P.Group.Id", box
										.getInt("group_id"))).add(
								Restrictions.eq("P.Flag", "s")).add(
								Restrictions.eq("Item.Id", item_id)).list();
			}

			for (Iterator iterator2 = storePoDetailList.iterator(); iterator2
					.hasNext();) {
				StorePoDetail storePoDetail = (StorePoDetail) iterator2.next();
				cancelMap.put(String.valueOf(item_id), storePoDetail
						.getCancelled());
				remarksMap.put(String.valueOf(item_id), storePoDetail
						.getRemarks());
			}

			query = " SELECT b.supplier_id, concat(c.supplier_name,'[L',lcat,']') lcat "
					+ "FROM store_tender_comm_bid_m a, store_tender_comm_bid_t b,mas_store_supplier c ";
			query = query + " where a.id = b.comm_bid_id ";
			query = query + " and b.supplier_id = c.supplier_id ";
			query = query + " and a.tender_id = " + box.getInt("tender_id");
			query = query + " and a.group_id = " + box.getInt("group_id");
			// query = query + " and a.department_id = "+ box.getInt("dept_id");
			query = query + " and a.item_id = " + item_id;
			query = query + " and b.lcat not in (0,1) ";
			query = query + " order by b.comp_rate ";

			List lcatList = new ArrayList();
			lcatList = (List) session.createSQLQuery(query).list();
			lcatMap.put(String.valueOf(item_id), lcatList);

			// } // end obj[9]!=null
		}
		String qry = " select b.re_supply_order from store_po_header a, store_po_detail b ";
		qry = qry + " where a.po_id = b.po_id ";
		qry = qry + " and a.department_id = " + box.getInt("dept_id");
		qry = qry + " and a.tender_id = " + box.getInt("tender_id");
		qry = qry + " and a.group_id = " + box.getInt("group_id");
		qry = qry + " and a.flag = 's' ";
		qry = qry + " and b.re_supply_order is not null ";

		List objectList1 = null;
		objectList1 = (List) session.createSQLQuery(qry).list();

		if (objectList1 != null && objectList1.size() > 0) {
			storePoHeaderList = session.createCriteria(StorePoHeader.class)
					.add(
							Restrictions.eq("Department.Id", box
									.getInt("dept_id"))).add(
							Restrictions.eq("Supplier.Id", box
									.getInt("supplier_id"))).add(
							Restrictions.eq("TenderM.Id", box
									.getInt("tender_id")))
					.add(Restrictions.eq("Group.Id", box.getInt("group_id")))
					.add(Restrictions.eq("Flag", "s")).add(
							Restrictions
									.not(Restrictions.in("Id", objectList1)))
					.list();
		} else {
			storePoHeaderList = session.createCriteria(StorePoHeader.class)
					.add(
							Restrictions.eq("Department.Id", box
									.getInt("dept_id"))).add(
							Restrictions.eq("Supplier.Id", box
									.getInt("supplier_id"))).add(
							Restrictions.eq("TenderM.Id", box
									.getInt("tender_id")))
					.add(Restrictions.eq("Group.Id", box.getInt("group_id")))
					.add(Restrictions.eq("Flag", "s")).list();
		}

		List<StorePoHeader> storeLpoHeaderList = new ArrayList<StorePoHeader>();
		storeLpoHeaderList = session.createCriteria(
				StoreTenderLocalPurchaseT.class).createAlias(
				"StoreTenderLocalPurchaseM", "stlpm").add(
				Restrictions.isNotNull("Po")).add(
				Restrictions.eq("stlpm.Tender.Id", box.getInt("tender_id")))
				.add(
						Restrictions.eq("stlpm.Department.Id", box
								.getInt("dept_id"))).add(
						Restrictions.eq("Supplier.Id", box
								.getInt("supplier_id"))).setProjection(
						Projections.distinct(Projections.projectionList().add(
								Projections.property("Po")))).list();

		if (storeLpoHeaderList != null) {
			storePoHeaderList.removeAll(storeLpoHeaderList);
		}

		storePoRemain = session.createCriteria(StorePoHeader.class).add(
				Restrictions.eq("Department.Id", box.getInt("dept_id"))).add(
				Restrictions.eq("Supplier.Id", box.getInt("supplier_id"))).add(
				Restrictions.eq("PoDate", HMSUtil
						.convertStringTypeDateToDateType(date))).list();
		BigDecimal remain = new BigDecimal("0");
		for (StorePoHeader Remain : storePoRemain) {
			remain = remain.add(Remain.getNetAmount());

		}

		map.put("objectList", objectList);
		map.put("storePoHeaderList", storePoHeaderList);
		map.put("cancelMap", cancelMap);
		map.put("remarksMap", remarksMap);
		map.put("supplierMap", supplierMap);
		map.put("lcatMap", lcatMap);
		map.put("l1catMap", l1catMap);
		map.put("remain", remain);
		return map;
	}

	public Map<String, Object> getStoreSetUpData(Box box) {
		// TODO Auto-generated method stub
		List<StoreSetup> storeSetupList = new ArrayList<StoreSetup>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		map.put("conn", con);
		storeSetupList = session.createCriteria(StoreSetup.class).list();
		map.put("storeSetupList", storeSetupList);
		return map;
	}

	public Map<String, Object> cancelSupplyOrderItems(Box box) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		List<StorePoDetail> storePoDetailList = new ArrayList<StorePoDetail>();
		// StorePoHeader storePoHeader = null;
		StorePoDetail storePoDetail = null;
		Session session = (Session) getSession();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Vector cancel = box.getVector(ITEMS_TO_BE_DELETED);
			Vector remarks = box.getVector("remarks");
			Vector itemIds = box.getVector("itemIds");
			Vector lcat = box.getVector("lcat");

			for (Iterator iterator = cancel.iterator(); iterator.hasNext();) {
				int item_id = new Integer(iterator.next().toString());

				storePoDetailList = session.createCriteria(StorePoDetail.class)
						.createAlias("Po", "P").add(
								Restrictions.eq("P.Department.Id", box
										.getInt("dept_id"))).add(
								Restrictions.eq("P.Supplier.Id", box
										.getInt("supplier_id"))).add(
								Restrictions.eq("P.TenderM.Id", box
										.getInt("tender_id"))).add(
								Restrictions.eq("P.Group.Id", box
										.getInt("group_id"))).add(
								Restrictions.eq("P.Flag", "s")).add(
								Restrictions.eq("Item.Id", item_id)).list();

				if (storePoDetailList != null && storePoDetailList.size() > 0) {
					storePoDetail = storePoDetailList.get(0);
					int po_id = storePoDetail.getPo().getId();
					StorePoHeader storePoHeader = new StorePoHeader();

					storePoDetail.setCancelled("y");
					int i = 0;
					for (Iterator iterator2 = itemIds.iterator(); iterator2
							.hasNext();) {
						int id = new Integer(iterator2.next().toString());
						if (item_id == id) {
							storePoDetail.setRemarks(remarks.get(i).toString());
							if (!lcat.get(i).toString().equals("0"))
								storePoDetail
										.setReSupplierId(new MasStoreSupplier(
												Integer.parseInt(lcat.get(i)
														.toString())));
						}
						i++;
					}
					storePoHeader = (StorePoHeader) hbt.load(
							StorePoHeader.class, po_id);
					BigDecimal net_amount = storePoHeader.getNetAmount();
					net_amount = net_amount.subtract(storePoDetail.getAmount());

					storePoHeader.setNetAmount(net_amount);
					hbt.update(storePoHeader);
					hbt.refresh(storePoHeader);

					hbt.update(storePoDetail);
					hbt.refresh(storePoDetail);
				}

			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> getTenderSupplierListForReLPO(Box box) {
		// TODO Auto-generated method stub
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		map = getGroupAndTenderComboDetails(box);
		List<StoreTenderCommBidM> storeTenderCommBidMList = new ArrayList<StoreTenderCommBidM>();
		List<StoreTenderCommBidT> storeTenderCommBidTList = new ArrayList<StoreTenderCommBidT>();

		String query = "";

		query = query + " select d.supplier_name, ";
		query = query + " count(a.item_id) no_of_items, ";
		query = query
				+ " round(sum(case f.formula when 1 then truncate(((c.tender_qty * f.conversion_factor1) / b.mdq_value),0) * b.final_price_per_mdq else ";
		query = query
				+ " c.tender_qty * f.conversion_factor1 * b.final_price_per_mdq end),2) net_amount, ";
		query = query + " b.supplier_id, a.status ";
		query = query
				+ " from store_tender_comm_bid_m a, store_tender_comm_bid_t b, store_tender_proposal c, mas_store_supplier d, mas_store_item e,mas_store_item_conversion f, store_po_detail g, store_po_header h ";
		query = query + " where a.id = b.comm_bid_id ";
		query = query + " and c.item_id = a.item_id ";
		query = query + " and a.item_id = e.item_id  ";
		query = query + " and e.item_conversion_id = f.item_conversion_id ";
		query = query + " and b.supplier_id = g.re_supplier_id ";
		query = query + " and g.re_supplier_id = d.supplier_id ";
		query = query
				+ " and ((c.po_id = g.re_supply_order and a.item_id = g.item_id) or (c.po_id = g.po_id and a.item_id = g.item_id)) ";
		query = query + " and g.po_id = h.po_id ";
		query = query + " and c.department_id = " + box.getInt("deptId");
		query = query + " and c.tender_id = " + box.getInt(TENDER_NO);
		query = query + " and a.tender_id = " + box.getInt(TENDER_NO);
		query = query + " and a.group_id = "
				+ box.getInt(TENDER_SUPPLIER_GROUP_ID);
		query = query + " and g.cancelled='y' ";
		query = query + " group by g.re_supplier_id ";

		List objectList = (List) session.createSQLQuery(query).list();
		//System.out.println("size " + objectList.size());
		map.put("objectList", objectList);
		return map;
	}

	public Map<String, Object> showReSupplyOrderSplitUp(Box box) {
		// TODO Auto-generated method stub
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<StorePoHeader> storePoHeaderList = new ArrayList<StorePoHeader>();
		List<StorePoDetail> storePoDetailList = new ArrayList<StorePoDetail>();
		List<StorePoHeader> storePoRemain = new ArrayList<StorePoHeader>();
		Map dateMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) dateMap.get("currentDate");
		String query = "";

		query = query
				+ " select concat(d.supplier_name,' [',d.supplier_code,']') supplier_name, e.pvms_no, e.nomenclature, concat(truncate(c.tender_qty,2),' ',i.unit_name),  b.disp_type, b.mdq_value, b.rate_per_mdq, b.comp_rate, ";
		query = query
				+ " round(case f.formula when 1 then truncate(((c.tender_qty * f.conversion_factor1) / b.mdq_value),0) * b.new_totrate_mdq else c.tender_qty * f.conversion_factor1 * b.new_totrate_mdq end,2) amount, ";
		query = query
				+ " c.po_id, a.item_id, g.cancelled, g.re_supply_order,new_rate_per_mdq,new_taxamt_per_mdq ";
		query = query
				+ " from store_tender_comm_bid_m a, store_tender_comm_bid_t b, store_tender_proposal c, mas_store_supplier d, mas_store_item e, mas_store_item_conversion f, store_po_detail g, store_po_header h, mas_store_unit i ";
		query = query + " where a.id = b.comm_bid_id ";
		query = query + " and c.item_id = a.item_id ";
		query = query + " and a.item_id = e.item_id ";
		query = query + " and e.item_conversion_id = f.item_conversion_id ";
		query = query + " and f.purchase_unit_id = i.unit_id";
		query = query + " and b.supplier_id = g.re_supplier_id ";
		query = query + " and g.re_supplier_id = d.supplier_id ";
		query = query + " and (c.po_id = g.po_id and a.item_id = g.item_id) ";
		query = query + " and g.po_id = h.po_id ";
		query = query + " and c.department_id = " + box.getInt("dept_id");
		query = query + " and c.tender_id = " + box.getInt("tender_id");
		query = query + " and a.tender_id = " + box.getInt("tender_id");
		query = query + " and a.group_id = " + box.getInt("group_id");
		query = query + " and g.cancelled='y' and h.flag='s' ";
		query = query + " and g.re_supplier_id = " + box.getInt("supplier_id");
		// query = query + " order by a.item_id ";
		query = query + " union ";
		query = query
				+ " select concat(d.supplier_name,' [',d.supplier_code,']') supplier_name, e.pvms_no, e.nomenclature, concat(truncate(c.tender_qty,0),' ',i.unit_name),  b.disp_type, b.mdq_value, b.rate_per_mdq, b.comp_rate, ";
		query = query
				+ " round(case f.formula when 1 then truncate(((c.tender_qty * f.conversion_factor1) / b.mdq_value),0) * b.new_totrate_mdq else c.tender_qty * f.conversion_factor1 * b.new_totrate_mdq end,2) amount, ";
		query = query
				+ " c.po_id, a.item_id, g.cancelled, g.re_supply_order,new_rate_per_mdq,new_taxamt_per_mdq ";
		query = query
				+ " from store_tender_comm_bid_m a, store_tender_comm_bid_t b, store_tender_proposal c, mas_store_supplier d, mas_store_item e, mas_store_item_conversion f, store_po_detail g, store_po_header h, mas_store_unit i ";
		query = query + " where a.id = b.comm_bid_id ";
		query = query + " and c.item_id = a.item_id ";
		query = query + " and a.item_id = e.item_id ";
		query = query + " and e.item_conversion_id = f.item_conversion_id ";
		query = query + " and f.purchase_unit_id = i.unit_id";
		query = query + " and b.supplier_id = g.re_supplier_id ";
		query = query + " and g.re_supplier_id = d.supplier_id ";
		query = query
				+ " and (c.po_id = g.re_supply_order and a.item_id = g.item_id) ";
		query = query + " and g.po_id = h.po_id ";
		query = query + " and c.department_id = " + box.getInt("dept_id");
		query = query + " and c.tender_id = " + box.getInt("tender_id");
		query = query + " and a.tender_id = " + box.getInt("tender_id");
		query = query + " and a.group_id = " + box.getInt("group_id");
		query = query + " and g.cancelled='y' and h.flag='s' ";
		query = query + " and g.re_supplier_id = " + box.getInt("supplier_id");
		// query = query + " order by a.item_id ";

		List objectList = (List) session.createSQLQuery(query).list();

		String qry = " select distinct a.po_number from store_po_header a, store_po_detail b ";
		qry = qry + " where a.po_id = b.re_supply_order ";
		qry = qry + " and a.department_id = " + box.getInt("dept_id");
		qry = qry + " and a.tender_id = " + box.getInt("tender_id");
		qry = qry + " and a.group_id = " + box.getInt("group_id");
		qry = qry + " and a.supplier_id = " + box.getInt("supplier_id");
		qry = qry + " and a.flag = 's' ";
		qry = qry + " and b.re_supply_order is not null order by a.po_number ";

		List poList = null;
		poList = (List) session.createSQLQuery(qry).list();
		storePoRemain = session.createCriteria(StorePoHeader.class).add(
				Restrictions.eq("Department.Id", box.getInt("dept_id"))).add(
				Restrictions.eq("Supplier.Id", box.getInt("supplier_id"))).add(
				Restrictions.eq("PoDate", HMSUtil
						.convertStringTypeDateToDateType(date))).list();
		BigDecimal remain = new BigDecimal("0");
		for (StorePoHeader Remain : storePoRemain) {
			remain = remain.add(Remain.getNetAmount());
		}
		map.put("remain", remain);
		map.put("objectList", objectList);
		map.put("poList", poList);
		return map;
	}

	public Map<String, Object> generateReLocalPurchaseOrder(Box box) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreSetup> storeSetupList = new ArrayList<StoreSetup>();
		StorePoHeader storePoHeader = null;
		StorePoDetail storePoDetail = null;
		Session session = (Session) getSession();
		BigDecimal net_amount = new BigDecimal(0);
		String tender_no = "";
		Date tender_date = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			Vector v = box.getVector(ITEMS_TO_BE_ADDED);
			String str = v.toString();
			String items = str.substring(1, str.length() - 1);
			items = "(" + items + ")";

			String query = "";
			query = query
					+ " select c.department_id, b.supplier_id, a.tender_id, a.group_id, a.item_id, ";
			query = query
					+ " case f.formula when 1 then truncate(((c.tender_qty * f.conversion_factor1) / b.mdq_value),0) else  c.tender_qty * f.conversion_factor1 end tender_qty, b.comp_rate, ";
			query = query
					+ " round(case f.formula when 1 then truncate(((c.tender_qty * f.conversion_factor1) / b.mdq_value),0) * b.new_totrate_mdq ";
			query = query
					+ " else  c.tender_qty * f.conversion_factor1 * b.new_totrate_mdq end,2) amount, ";
			query = query
					+ " ((b.mrp * b.vat_percent) / 100) tax_amount, b.vat_percent, b.disp_type, b.mdq_value, b.new_totrate_mdq, b.mrp, d.tender_no, d.tender_invitation_date,b.new_taxamt_per_mdq ";
			query = query
					+ " from store_tender_comm_bid_m a, store_tender_comm_bid_t b, store_tender_proposal c, store_tender_m d, mas_store_item e, mas_store_item_conversion f ";
			query = query + " where a.id = b.comm_bid_id ";
			query = query + " and a.tender_id = d.id ";
			query = query + " and c.item_id = a.item_id ";
			query = query + " and a.item_id = e.item_id ";
			query = query + " and e.item_conversion_id = f.item_conversion_id ";
			query = query + " and c.department_id = " + box.getInt("dept_id");
			query = query + " and c.tender_id = " + box.getInt("tender_id");
			query = query + " and a.tender_id = " + box.getInt("tender_id");
			query = query + " and a.group_id = " + box.getInt("group_id");
			query = query + " and b.supplier_id = " + box.getInt("supplier_id");
			query = query + " and a.item_id in " + items;

			List objectList = session.createSQLQuery(query).list();

			for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
				Object[] obj = (Object[]) iterator.next();
				tender_no = obj[14].toString();
				tender_date = (Date) obj[15];
				try {
					BigDecimal val = new BigDecimal(obj[7].toString());
					net_amount = net_amount.add(val);
				} catch (Exception e) {
					net_amount = net_amount.add(new BigDecimal(0));
				}
			}

			List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
			storeFyDocumentNoList = hbt
					.find("from jkt.hms.masters.business.StoreFyDocumentNo as inp where inp.Department.Id = "
							+ box.getInt("dept_id"));
			String no = "";
			if (storeFyDocumentNoList != null
					&& storeFyDocumentNoList.size() > 0) {
				StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) storeFyDocumentNoList
						.get(0);
				no = ("" + storeFyDocumentNo.getPoNo());
				storeFyDocumentNo.setPoNo(getMaxNo(no));
				hbt.update(storeFyDocumentNo);
				hbt.refresh(storeFyDocumentNo);
			}

			storePoHeader = new StorePoHeader();
			storePoHeader.setPoDate(HMSUtil.convertStringTypeDateToDateType(box
					.get(CHANGED_DATE)));
			storePoHeader.setPoTime(box.getString(CHANGED_TIME));
			storePoHeader.setQuotationNumber(tender_no);
			storePoHeader
					.setDepartment(new MasDepartment(box.getInt("dept_id")));
			storePoHeader.setSupplier(new MasStoreSupplier(box
					.getInt("supplier_id")));
			storePoHeader.setDeliveryDate(HMSUtil
					.convertStringTypeDateToDateType(box.get("delivery")));
			storePoHeader.setLastChgBy(box.get(CHANGED_BY));
			storePoHeader.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(box.get(CHANGED_DATE)));
			storePoHeader.setLastChgTime(box.getString(CHANGED_TIME));
			storePoHeader.setStatus("o");
			storePoHeader.setFlag("s");
			storePoHeader.setQuotationDate(tender_date);
			storePoHeader.setRemarks(box.getString("remarks"));
			storePoHeader.setPayTerms("");
			storePoHeader.setDeliveryTerms("");
			storePoHeader.setApprovalAuthority("");
			storePoHeader.setSigningAuthority("");
			storePoHeader.setTenderM(new StoreTenderM(box.getInt("tender_id")));
			storePoHeader.setGroup(new MasStoreGroup(box.getInt("group_id")));
			storePoHeader.setNetAmount(net_amount);
			storePoHeader.setPoNumber(getMaxNo(no));
			hbt.save(storePoHeader);
			hbt.refresh(storePoHeader);

			java.util.Date poDate = storePoHeader.getPoDate();
			// Update MasStoreBudget Master record
			List<MasStoreFinancial> masStoreFinancialList = new ArrayList<MasStoreFinancial>();
			masStoreFinancialList = session.createCriteria(
					MasStoreFinancial.class).list();
			java.util.Date start_date = null;
			java.util.Date end_date = null;
			int financial_id = 0;
			for (Iterator iterator2 = masStoreFinancialList.iterator(); iterator2
					.hasNext();) {
				MasStoreFinancial masStoreFinancial = (MasStoreFinancial) iterator2
						.next();
				start_date = (java.util.Date) masStoreFinancial.getStartDate();
				end_date = (java.util.Date) masStoreFinancial.getEndDate();
				if (poDate.after(start_date) && poDate.before(end_date)) {
					financial_id = masStoreFinancial.getId();
					break;
				} else if (poDate.equals(start_date) || poDate.equals(end_date)) {
					financial_id = masStoreFinancial.getId();
					break;
				}
			}

			// should not add to MasterBudget
			/*
			 * List<MasStoreBudget> masStoreBudgetList = new
			 * ArrayList<MasStoreBudget>(); masStoreBudgetList =
			 * session.createCriteria(MasStoreBudget.class)
			 * .add(Restrictions.eq("Financial.Id", financial_id)).list();
			 * BigDecimal existing_committed_amount = null; if
			 * (masStoreBudgetList != null && masStoreBudgetList.size() > 0) {
			 * MasStoreBudget masStoreBudget = masStoreBudgetList.get(0); try {
			 * existing_committed_amount = masStoreBudget
			 * .getPoComittedAmount(); } catch (Exception e) {
			 * existing_committed_amount = new BigDecimal(0); }
			 * masStoreBudget.setPoComittedAmount(existing_committed_amount
			 * .add(net_amount)); hbt.update(masStoreBudget); }
			 */

			int slno = 1;
			for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
				storePoDetail = new StorePoDetail();
				Object[] obj = (Object[]) iterator.next();
				storePoDetail.setAmount(new BigDecimal(obj[7].toString()));
				storePoDetail.setDispType(obj[10].toString());
				storePoDetail.setItem(new MasStoreItem(new Integer(obj[4]
						.toString())));
				storePoDetail.setMdqValue(new BigDecimal(obj[11].toString()));
				storePoDetail.setMrp(new BigDecimal(obj[13].toString()));
				storePoDetail.setPo(storePoHeader);
				storePoDetail.setQuantityOrdered(new BigDecimal(obj[5]
						.toString()));
				storePoDetail.setRatePerMdq(new BigDecimal(obj[12].toString()));
				storePoDetail.setSerialNo(slno++);
				storePoDetail.setTaxAmount(new BigDecimal(obj[8].toString()));
				storePoDetail.setTaxPercent(new BigDecimal(obj[9].toString()));
				storePoDetail.setUnitRate(new BigDecimal(obj[6].toString()));
				storePoDetail
						.setTaxAmtPerMdq(new BigDecimal(obj[16].toString()));
				hbt.save(storePoDetail);

				List<StoreTenderProposal> storeTenderProposalList = new ArrayList<StoreTenderProposal>();
				storeTenderProposalList = session.createCriteria(
						StoreTenderProposal.class).add(
						Restrictions.eq("TenderId.Id", new Integer(obj[2]
								.toString()))).add(
						Restrictions.eq("Item.Id", new Integer(obj[4]
								.toString()))).add(
						Restrictions.eq("Department.Id", new Integer(obj[0]
								.toString()))).list();

				if (storeTenderProposalList != null
						&& storeTenderProposalList.size() > 0) {
					StoreTenderProposal storeTenderProposal = storeTenderProposalList
							.get(0);
					storeTenderProposal.setPo(storePoHeader);
					hbt.update(storeTenderProposal);
				}

				List<StoreTenderCommBidT> storeTenderCommBidTList = new ArrayList<StoreTenderCommBidT>();
				storeTenderCommBidTList = session.createCriteria(
						StoreTenderCommBidT.class).createAlias("CommBid",
						"commbid").add(
						Restrictions.eq("commbid.Tender.Id", box
								.getInt("tender_id"))).add(
						Restrictions.eq("commbid.Group.Id", box
								.getInt("group_id"))).add(
						Restrictions.eq("Supplier.Id", box
								.getInt("supplier_id"))).add(
						Restrictions.eq("commbid.Item.Id", new Integer(obj[4]
								.toString()))).list();

				if (storeTenderCommBidTList != null
						&& storeTenderCommBidTList.size() > 0) {
					for (Iterator iterator1 = storeTenderCommBidTList
							.iterator(); iterator1.hasNext();) {
						StoreTenderCommBidT storeTenderCommBidT = (StoreTenderCommBidT) iterator1
								.next();
						StoreTenderCommBidM storeTenderCommBidM = storeTenderCommBidT
								.getCommBid();
						storeTenderCommBidM.setStatus("p");
						hbt.update(storeTenderCommBidM);
					}
				}

				List<StorePoDetail> storePoDetailList = new ArrayList<StorePoDetail>();
				storePoDetailList = session.createCriteria(StorePoDetail.class)
						.createAlias("Po", "po").add(
								Restrictions.eq("po.TenderM.Id", box
										.getInt("tender_id"))).add(
								Restrictions.eq("po.Group.Id", box
										.getInt("group_id")))
						// .add(Restrictions.eq("po.Supplier.Id",
						// box.getInt("supplier_id")))
						.add(
								Restrictions.eq("po.Department.Id",
										new Integer(obj[0].toString()))).add(
								Restrictions.eq("po.Flag", "s")).add(
								Restrictions.eq("Item.Id", new Integer(obj[4]
										.toString()))).add(
								Restrictions.eq("Cancelled", "y")).list();

				if (storePoDetailList != null && storePoDetailList.size() > 0) {
					for (Iterator iterator1 = storePoDetailList.iterator(); iterator1
							.hasNext();) {
						StorePoDetail storePoDetail1 = (StorePoDetail) iterator1
								.next();
						storePoDetail1.setReSupplyOrder(storePoHeader);
						hbt.update(storePoDetail1);
					}
				}
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		map = getGroupAndTenderAndSupplierComboDetails(box);
		return map;
	}

	public Map<String, Object> deleteReTenderProposalGridItems(Box box) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreReTenderProposal> storeReTenderProposalList = new ArrayList<StoreReTenderProposal>();
		StoreReTenderProposal storeReTenderProposal = new StoreReTenderProposal();
		Session session = (Session) getSession();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Vector srno = box.getVector(TENDER_SRNO);
			Vector annreq = box.getVector(TENDER_ANNREQ);
			Vector items = box.getVector(TENDER_ITEM_ID);
			Vector delete = box.getVector(ITEMS_TO_BE_DELETED);

			String obj = null;
			for (int i = 0; i < delete.size(); i++) {
				int item_id = Integer.parseInt(delete.get(i).toString());
				int id = 0;
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				storeReTenderProposalList = hbt
						.find("from jkt.hms.masters.business.StoreReTenderProposal as a where a.Item.Id="
								+ item_id
								+ " and a.Status='o' and a.Department.Id = "
								+ box.getInt("deptId"));
				if (storeReTenderProposalList != null
						&& storeReTenderProposalList.size() > 0) {
					id = storeReTenderProposalList.get(0).getId();
				}
				String hql = "delete from jkt.hms.masters.business.StoreReTenderProposal as a where a.Id like :id";
				Query query = session.createQuery(hql).setParameter("id", id);
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

		map = showReTenderProposalJsp(box);
		return map;
	}

	public Map<String, Object> showReTenderProposalJsp(Box box) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;
		StoreReTenderProposal storeReTenderProposal = new StoreReTenderProposal();
		List<StoreTenderM> storeTenderMList = new ArrayList<StoreTenderM>();

		String pvms = null;
		String nomenclature = null;
		String strength = null;
		String disp_type = null;
		String au = null;
		BigDecimal qtymmf = null;
		BigDecimal annreq = null;
		int item_id = 0;
		Criteria c = null;

		List<StoreReTenderProposal> storeReTenderProposalList = new ArrayList<StoreReTenderProposal>();
		List<StoreReTenderProposal> storeReTenderProposalList1 = new ArrayList<StoreReTenderProposal>();

		Session session = (Session) getSession();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			if (box.getString("pvmsNo").length() > 0) {
				String strForPvms = box.getString("pvmsNo");
				strForPvms = strForPvms.replace(" ", "%") + "%";
				/*
				 * storeReTenderProposalList = hbt.find(
				 * "from jkt.hms.masters.business.StoreReTenderProposal as inp where inp.Status='o' and inp.Department.Id = "
				 * + box.getInt("deptId"));
				 */
				c = session.createCriteria(StoreReTenderProposal.class)
						.createAlias("Item", "item").add(
								Restrictions.like("item.PvmsNo", strForPvms))
						.createAlias("Department", "department").add(
								Restrictions.eq("department.Id", box
										.getInt("deptId"))).add(
								Restrictions.eq("Status", "o"));
				storeReTenderProposalList = c.list();
			} else {
				storeReTenderProposalList = hbt
						.find("from jkt.hms.masters.business.StoreReTenderProposal as inp where inp.Status='o' and inp.Department.Id = "
								+ box.getInt("deptId"));
			}
			if (storeReTenderProposalList != null
					&& storeReTenderProposalList.size() > 0) {
				storeTenderMList = hbt
						.find("select distinct inp.TenderM from jkt.hms.masters.business.StorePoHeader as inp where inp.Department.Id = "
								+ box.getInt("deptId")
								+ " and inp.TenderM.Id= "
								+ storeReTenderProposalList.get(0)
										.getTenderId().getId());
				map.put(TENDER_NO, storeReTenderProposalList.get(0)
						.getTenderId().getId());
				map.put(PROPOSAL_ID, storeReTenderProposalList.get(0)
						.getProposalId());
			} else {
				storeReTenderProposalList1 = hbt
						.find("from jkt.hms.masters.business.StoreReTenderProposal as inp where inp.Department.Id = "
								+ box.getInt("deptId")
								+ " order by inp.ProposalId desc");
				if (storeReTenderProposalList1 != null
						&& storeReTenderProposalList1.size() > 0) {
					int proposal_id = storeReTenderProposalList1.get(0)
							.getProposalId();
					map.put(PROPOSAL_ID, ++proposal_id);
				} else
					map.put(PROPOSAL_ID, 1);

				storeTenderMList = hbt
						.find("select distinct inp.TenderM from jkt.hms.masters.business.StorePoHeader as inp where inp.Department.Id = "
								+ box.getInt("deptId"));
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		for (Iterator iterator = storeReTenderProposalList.iterator(); iterator
				.hasNext();) {

			storeReTenderProposal = (StoreReTenderProposal) iterator.next();
			BigDecimal qtyInHand = null;
			MasStoreItem masStoreItem = new MasStoreItem();
			masStoreItem = storeReTenderProposal.getItem();
			List<StoreItemBatchStock> storeItemBatchStockList = new ArrayList<StoreItemBatchStock>();
			String str = "select sum(inp.closing_stock) from store_item_batch_stock as inp where department_id = "
					+ box.getInt("deptId")
					+ " and item_id = "
					+ masStoreItem.getId();
			storeItemBatchStockList = session.createSQLQuery(str).list();
			Iterator iterator1 = storeItemBatchStockList.iterator();
			while (iterator1.hasNext()) {
				qtyInHand = (BigDecimal) iterator1.next();
			}

			try {
				pvms = storeReTenderProposal.getItem().getPvmsNo();
			} catch (Exception e) {
				pvms = "";
			}

			try {
				nomenclature = storeReTenderProposal.getItem()
						.getNomenclature();
			} catch (Exception e) {
				nomenclature = "";
			}

			try {
				strength = storeReTenderProposal.getItem().getStrength();
			} catch (Exception e) {
				strength = "";
			}

			try {
				au = storeReTenderProposal.getItem().getItemConversion()
						.getPurchaseUnit().getUnitName();
			} catch (Exception e) {
				au = "";
			}

			try {
				disp_type = storeReTenderProposal.getItem().getItemConversion()
						.getIntermediateUnit().getUnitName();
			} catch (Exception e) {
				disp_type = "";
			}

			try {
				qtymmf = storeReTenderProposal.getTotalTenderQty();
			} catch (Exception e) {
				qtymmf = new BigDecimal(0);
			}

			try {
				annreq = storeReTenderProposal.getActualTenderQty();
			} catch (Exception e) {
				annreq = new BigDecimal(0);
			}

			try {
				item_id = storeReTenderProposal.getItem().getId();
			} catch (Exception e) {
				item_id = 0;
			}

			hData = new HashMap<String, Object>();
			hData.put(TENDER_ITEM_ID, item_id);
			hData.put(TENDER_PVMS, pvms);
			hData.put(TENDER_NOMENCLATURE, nomenclature);
			hData.put(TENDER_STRENGTH, strength);
			hData.put(TENDER_MMFQTY, qtymmf);
			hData.put(TENDER_ANNREQ, annreq);
			hData.put(TENDER_AU, au);
			hData.put("disp_type", disp_type);
			hData.put(TENDER_STOCK_IN_HAND, qtyInHand);

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
		map.put("storeTenderMList", storeTenderMList);
		return map;
	}

	public Map<String, Object> updateReTenderProposalGridItems(Box box) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreReTenderProposal> storeReTenderProposalList = new ArrayList<StoreReTenderProposal>();
		StoreReTenderProposal storeReTenderProposal = new StoreReTenderProposal();
		Session session = (Session) getSession();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Vector srno = box.getVector(TENDER_SRNO);
			Vector annreq = box.getVector(TENDER_ANNREQ);
			Vector items = box.getVector(TENDER_ITEM_ID);

			String obj = null;
			for (int i = 0; i < srno.size(); i++) {
				int item_id = Integer.parseInt(items.get(i).toString());
				storeReTenderProposalList = hbt
						.find("from jkt.hms.masters.business.StoreReTenderProposal as inp where inp.Item.Id= "
								+ item_id
								+ " and inp.Status='o' and inp.Department.Id = "
								+ box.getInt("deptId"));
				if (storeReTenderProposalList.size() > 0) {
					storeReTenderProposal = storeReTenderProposalList.get(0);
					if (annreq.get(i).toString().trim().length() > 0) {
						storeReTenderProposal
								.setActualTenderQty(new BigDecimal(annreq
										.get(i).toString()));
					} else {
						storeReTenderProposal
								.setActualTenderQty(new BigDecimal(0));
					}
					hbt.update(storeReTenderProposal);
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map = showReTenderProposalJsp(box);
		return map;
	}

	public Map<String, Object> getReTenderItemDetails(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreTenderProposal> storeTenderProposalList = new ArrayList<StoreTenderProposal>();
		session = (Session) getSession();
		String pvms = null;
		String nomenclature = null;
		String strength = null;
		String au = null;
		String disp_type = null;
		BigDecimal qtymmf = null;
		BigDecimal annreq = null;
		int item_id = 0;

		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector tenderTItems = new Vector();
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			List<StoreReTenderProposal> storeReTenderProposalList = new ArrayList<StoreReTenderProposal>();
			storeReTenderProposalList = hbt
					.find("from jkt.hms.masters.business.StoreReTenderProposal as inp where inp.Status='o' and inp.Department.Id="
							+ box.getInt("deptId"));
			for (Iterator iterator = storeReTenderProposalList.iterator(); iterator
					.hasNext();) {
				StoreReTenderProposal storeReTenderProposal = (StoreReTenderProposal) iterator
						.next();
				tenderTItems.add(storeReTenderProposal.getItem().getId());
			}

			String str = "";
			Criteria c = null;
			String queryString = null;
			c = session.createCriteria(StoreTenderProposal.class).add(
					Restrictions.eq("TenderId.Id", box.getInt(TENDER_NO))).add(
					Restrictions.eq("Department.Id", box.getInt("deptId")));
			storeTenderProposalList = c.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		for (Iterator iterator = storeTenderProposalList.iterator(); iterator
				.hasNext();) {
			StoreTenderProposal storeTenderProposal = (StoreTenderProposal) iterator
					.next();

			BigDecimal qtyInHand = null;
			List<StoreItemBatchStock> storeItemBatchStockList = new ArrayList<StoreItemBatchStock>();
			String str = "select sum(inp.closing_stock) from store_item_batch_stock as inp where department_id = "
					+ box.getInt("deptId")
					+ " and item_id = "
					+ storeTenderProposal.getItem().getId();
			storeItemBatchStockList = session.createSQLQuery(str).list();
			Iterator iterator1 = storeItemBatchStockList.iterator();
			while (iterator1.hasNext()) {
				qtyInHand = (BigDecimal) iterator1.next();
			}

			try {
				pvms = storeTenderProposal.getItem().getPvmsNo();
			} catch (Exception e) {
				pvms = "";
			}

			try {
				nomenclature = storeTenderProposal.getItem().getNomenclature();
			} catch (Exception e) {
				nomenclature = "";
			}

			try {
				strength = storeTenderProposal.getItem().getStrength();
			} catch (Exception e) {
				strength = "";
			}

			try {
				au = storeTenderProposal.getItem().getItemConversion()
						.getPurchaseUnit().getUnitName();
			} catch (Exception e) {
				au = "";
			}

			try {
				disp_type = storeTenderProposal.getItem().getItemConversion()
						.getIntermediateUnit().getUnitName();
			} catch (Exception e) {
				disp_type = "";
			}

			try {
				item_id = storeTenderProposal.getItem().getId();
			} catch (Exception e) {
				item_id = 0;
			}

			try {
				qtymmf = storeTenderProposal.getTenderQty();
				annreq = qtymmf.divide(new BigDecimal(2));
			} catch (Exception e) {
				qtymmf = new BigDecimal(0);
				annreq = new BigDecimal(0);
			}

			if (!tenderTItems.contains(item_id)) {
				hData = new HashMap<String, Object>();
				hData.put(TENDER_ITEM_ID, item_id);
				hData.put(TENDER_PVMS, pvms);
				hData.put(TENDER_NOMENCLATURE, nomenclature);
				hData.put(TENDER_STRENGTH, strength);
				hData.put(TENDER_MMFQTY, qtymmf);
				hData.put(TENDER_ANNREQ, annreq);
				hData.put(TENDER_AU, au);
				hData.put("disp_type", disp_type);
				hData.put(TENDER_STOCK_IN_HAND, qtyInHand);

				vResult.add(hData);
			}
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

	public Map<String, Object> doAddReTenderProposalItems(Box box) {
		// TODO Auto-generated method stub
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		session = (Session) getSession();
		Vector items = box.getVector(TENDER_ITEM_ID);
		Vector qtymmf = box.getVector(TENDER_MMFQTY);
		Vector annreq = box.getVector(TENDER_ANNREQ);
		Vector items_to_be_added = box.getVector(ITEMS_TO_BE_ADDED);
		StoreReTenderProposal storeReTenderProposal = null;
		MasStoreItem masStoreItem = null;
		int deptId = box.getInt("deptId");
		int hospitalId = box.getInt("hospitalId");
		int tender_no = box.getInt(TENDER_NO);
		int proposal_id = box.getInt("proposal_id");

		int sr_no = 0;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);

			for (int i = 0; i < items.size(); i++) {
				if (items_to_be_added.contains(items.get(i))) {
					masStoreItem = new MasStoreItem();
					masStoreItem
							.setId(Integer.valueOf(items.get(i).toString()));

					storeReTenderProposal = new StoreReTenderProposal();

					storeReTenderProposal.setItem(masStoreItem);
					storeReTenderProposal.setDepartment(new MasDepartment(
							deptId));
					storeReTenderProposal.setHospital(new MasHospital(
							hospitalId));
					storeReTenderProposal.setProposalId(proposal_id);
					try {
						storeReTenderProposal.setTotalTenderQty(new BigDecimal(
								qtymmf.get(i).toString()));
					} catch (Exception e) {
						storeReTenderProposal.setTotalTenderQty(new BigDecimal(
								0));
					}
					try {
						storeReTenderProposal
								.setActualTenderQty(new BigDecimal(annreq
										.get(i).toString()));
					} catch (Exception e) {
						storeReTenderProposal
								.setActualTenderQty(new BigDecimal(0));
					}
					storeReTenderProposal.setLastChgBy(box.get(CHANGED_BY));
					storeReTenderProposal.setLastChgDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(CHANGED_DATE)));
					storeReTenderProposal.setLastChgTime(box.get(CHANGED_TIME));
					storeReTenderProposal.setStatus("o");
					storeReTenderProposal.setTenderId(new StoreTenderM(
							tender_no));
					hbt.save(storeReTenderProposal);
				}
			}

			map.put("total_records", items.size());
			map.put("added_records", items_to_be_added.size());

			if (items.size() == items_to_be_added.size()) {
				if (box.getInt("currPage") > 1)
					box.put("currPage", box.getInt("currPage") - 1);
			}

			map = getReTenderItemDetails(box);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;

	}

	public Map<String, Object> getReTenderSupplierListForLPO(Box box) {
		// TODO Auto-generated method stub
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		map = getGroupAndTenderComboDetailsForProposal(box);
		String query = "";

		query = query + " select d.supplier_name,";
		query = query + " count(a.item_id) no_of_items,";
		query = query
				+ " round(sum(case f.formula when 1 then truncate(((c.actual_tender_qty * f.conversion_factor1) / b.mdq_value),0) * b.final_price_per_mdq else  c.actual_tender_qty * f.conversion_factor1 * b.final_price_per_mdq end),2) net_amount,";
		query = query + " b.supplier_id, a.status ";
		query = query
				+ " from store_tender_comm_bid_m a, store_tender_comm_bid_t b, store_re_tender_proposal c, mas_store_supplier d, mas_store_item e, mas_store_item_conversion f";
		query = query + " where a.id = b.comm_bid_id ";
		query = query + " and c.item_id = a.item_id ";
		query = query + " and a.item_id = e.item_id ";
		query = query + " and e.item_conversion_id = f.item_conversion_id ";
		query = query + " and b.supplier_id = d.supplier_id ";
		query = query + " and c.department_id = " + box.getInt("deptId");
		query = query + " and c.tender_id = " + box.getInt(TENDER_NO);
		query = query + " and a.tender_id = " + box.getInt(TENDER_NO);
		query = query + " and a.group_id = "
				+ box.getInt(TENDER_SUPPLIER_GROUP_ID);
		query = query + " and b.lcat=1 and c.proposal_id ="
				+ box.getInt(PROPOSAL_ID);
		query = query + " group by b.supplier_id";

		List objectList = (List) session.createSQLQuery(query).list();
		//System.out.println("size " + objectList.size());
		map.put("objectList", objectList);
		return map;
	}

	public Map<String, Object> showReTenderSupplyOrderSplitUp(Box box) {
		// TODO Auto-generated method stub
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> cancelMap = new HashMap<String, Object>();
		Map<String, Object> remarksMap = new HashMap<String, Object>();
		Map<String, Object> supplierMap = new HashMap<String, Object>();
		Map<String, Object> lcatMap = new HashMap<String, Object>();
		List<StorePoHeader> storePoHeaderList = new ArrayList<StorePoHeader>();
		List<StorePoDetail> storePoDetailList = new ArrayList<StorePoDetail>();
		List<StoreReTenderProposal> storeReTenderProposalList = new ArrayList<StoreReTenderProposal>();
		List<StorePoHeader> storePoRemain = new ArrayList<StorePoHeader>();
		Map dateMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) dateMap.get("currentDate");
		String query = "";

		query = query
				+ " select concat(d.supplier_name,' [',d.supplier_code,']') supplier_name, e.pvms_no, e.nomenclature, concat(truncate(c.actual_tender_qty,2),' ',g.unit_name), b.disp_type, b.mdq_value, b.rate_per_mdq, b.comp_rate, ";
		query = query
				+ " round(case f.formula when 1 then truncate(((c.actual_tender_qty * f.conversion_factor1) / b.mdq_value),0) * b.new_totrate_mdq else c.actual_tender_qty * f.conversion_factor1 * b.new_totrate_mdq end,2) amount, ";
		query = query
				+ " c.po_id, a.item_id, concat(d.supplier_name,'[L',b.lcat,']'),b.new_rate_per_mdq,new_taxamt_per_mdq ";
		query = query
				+ " from store_tender_comm_bid_m a, store_tender_comm_bid_t b, store_re_tender_proposal c, mas_store_supplier d, mas_store_item e, mas_store_item_conversion f, mas_store_unit g";
		query = query + " where a.id = b.comm_bid_id ";
		query = query + " and c.item_id = a.item_id ";
		query = query + " and a.item_id = e.item_id ";
		query = query + " and e.item_conversion_id = f.item_conversion_id ";
		query = query + " and f.purchase_unit_id = g.unit_id ";
		query = query + " and b.supplier_id = d.supplier_id ";
		query = query + " and c.department_id = " + box.getInt("dept_id");
		query = query + " and c.tender_id = " + box.getInt("tender_id");
		query = query + " and a.tender_id = " + box.getInt("tender_id");
		query = query + " and a.group_id = " + box.getInt("group_id");
		query = query + " and b.lcat=1 and c.proposal_id = "
				+ box.getInt(PROPOSAL_ID);
		query = query + " and b.supplier_id = " + box.getInt("supplier_id");
		query = query + " order by a.item_id ";
		List objectList = (List) session.createSQLQuery(query).list();

		for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
			Object[] obj = (Object[]) iterator.next();
			String supplier_name = new String();
			if (obj[9] != null) {
				int po_id = (Integer) obj[9];
				int item_id = (Integer) obj[10];

				// Find out the old po_id if exists otherwise use the new po_id
				// This is used to find out the cancelled items
				storePoDetailList = session.createCriteria(StorePoDetail.class)
						.createAlias("Po", "P").add(
								Restrictions.eq("P.Department.Id", box
										.getInt("dept_id"))).add(
								Restrictions.eq("P.Supplier.Id", box
										.getInt("supplier_id"))).add(
								Restrictions.eq("P.TenderM.Id", box
										.getInt("tender_id"))).add(
								Restrictions.eq("P.Group.Id", box
										.getInt("group_id"))).add(
								Restrictions.eq("Item.Id", item_id)).add(
								Restrictions.eq("P.Flag", "r")).add(
								Restrictions.eq("P.ProposalId", box
										.getInt("proposal_id"))).add(
								Restrictions.isNotNull("ReSupplierId")).list();

				if (storePoDetailList != null && storePoDetailList.size() > 0) {
					po_id = storePoDetailList.get(0).getPo().getId();
					supplierMap.put(String.valueOf(item_id), storePoDetailList
							.get(0).getReSupplierId().getSupplierName());
				}

				storePoDetailList = session.createCriteria(StorePoDetail.class)
						.createAlias("Po", "P").add(
								Restrictions.eq("P.Id", po_id)).add(
								Restrictions.eq("P.Department.Id", box
										.getInt("dept_id"))).add(
								Restrictions.eq("P.Supplier.Id", box
										.getInt("supplier_id"))).add(
								Restrictions.eq("P.TenderM.Id", box
										.getInt("tender_id"))).add(
								Restrictions.eq("P.Group.Id", box
										.getInt("group_id"))).add(
								Restrictions.eq("P.Flag", "r")).add(
								Restrictions.eq("P.ProposalId", box
										.getInt("proposal_id"))).add(
								Restrictions.eq("Item.Id", item_id)).list();

				for (Iterator iterator2 = storePoDetailList.iterator(); iterator2
						.hasNext();) {
					StorePoDetail storePoDetail = (StorePoDetail) iterator2
							.next();
					cancelMap.put(String.valueOf(item_id), storePoDetail
							.getCancelled());
					remarksMap.put(String.valueOf(item_id), storePoDetail
							.getRemarks());
				}

				query = " SELECT b.supplier_id, concat(c.supplier_name,'[L',lcat,']') lcat FROM store_tender_comm_bid_m a, store_tender_comm_bid_t b,mas_store_supplier c ";
				query = query + " where a.id = b.comm_bid_id ";
				query = query + " and b.supplier_id = c.supplier_id ";
				query = query + " and a.tender_id = " + box.getInt("tender_id");
				query = query + " and a.group_id = " + box.getInt("group_id");
				query = query + " and a.department_id = "
						+ box.getInt("dept_id");
				query = query + " and a.item_id = " + item_id;
				query = query + " and b.lcat not in (0,1) ";
				query = query + " order by b.comp_rate ";

				List lcatList = new ArrayList();
				lcatList = (List) session.createSQLQuery(query).list();
				lcatMap.put(String.valueOf(item_id), lcatList);
				//System.out.println(lcatList);
			} // end obj[9]!=null
		}

		String qry = " select b.re_supply_order from store_po_header a, store_po_detail b ";
		qry = qry + " where a.po_id = b.po_id ";
		qry = qry + " and a.department_id = " + box.getInt("dept_id");
		qry = qry + " and a.tender_id = " + box.getInt("tender_id");
		qry = qry + " and a.group_id = " + box.getInt("group_id");
		qry = qry + " and a.flag = 'r' ";
		qry = qry + " and a.proposal_id = " + box.getInt("proposal_id");
		qry = qry + " and b.re_supply_order is not null ";

		List objectList1 = null;
		objectList1 = (List) session.createSQLQuery(qry).list();

		if (objectList1 != null && objectList1.size() > 0) {
			storePoHeaderList = session.createCriteria(StorePoHeader.class)
					.add(
							Restrictions.eq("Department.Id", box
									.getInt("dept_id"))).add(
							Restrictions.eq("Supplier.Id", box
									.getInt("supplier_id"))).add(
							Restrictions.eq("TenderM.Id", box
									.getInt("tender_id")))
					.add(Restrictions.eq("Group.Id", box.getInt("group_id")))
					.add(Restrictions.eq("Flag", "r")).add(
							Restrictions.eq("ProposalId", box
									.getInt("proposal_id"))).add(
							Restrictions
									.not(Restrictions.in("Id", objectList1)))
					.list();
		} else {
			storePoHeaderList = session.createCriteria(StorePoHeader.class)
					.add(
							Restrictions.eq("Department.Id", box
									.getInt("dept_id"))).add(
							Restrictions.eq("Supplier.Id", box
									.getInt("supplier_id"))).add(
							Restrictions.eq("TenderM.Id", box
									.getInt("tender_id"))).add(
							Restrictions.eq("Flag", "r")).add(
							Restrictions.eq("ProposalId", box
									.getInt("proposal_id")))
					.add(Restrictions.eq("Group.Id", box.getInt("group_id")))
					.list();
		}

		storePoRemain = session.createCriteria(StorePoHeader.class).add(
				Restrictions.eq("Department.Id", box.getInt("dept_id"))).add(
				Restrictions.eq("Supplier.Id", box.getInt("supplier_id"))).add(
				Restrictions.eq("PoDate", HMSUtil
						.convertStringTypeDateToDateType(date))).list();
		BigDecimal remain = new BigDecimal("0");
		for (StorePoHeader Remain : storePoRemain) {
			remain = remain.add(Remain.getNetAmount());

		}
		map.put("remain", remain);
		map.put("objectList", objectList);
		map.put("storePoHeaderList", storePoHeaderList);
		map.put("cancelMap", cancelMap);
		map.put("remarksMap", remarksMap);
		map.put("supplierMap", supplierMap);
		map.put("lcatMap", lcatMap);
		return map;

	}

	public Map<String, Object> generateReTenderLocalPurchaseOrder(Box box) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreSetup> storeSetupList = new ArrayList<StoreSetup>();
		StorePoHeader storePoHeader = null;
		StorePoDetail storePoDetail = null;
		Session session = (Session) getSession();
		BigDecimal net_amount = new BigDecimal(0);
		String tender_no = "";
		Date tender_date = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			Vector v = box.getVector(ITEMS_TO_BE_ADDED);
			String str = v.toString();
			String items = str.substring(1, str.length() - 1);
			items = "(" + items + ")";

			String query = "";
			query = query
					+ " select c.department_id, b.supplier_id, a.tender_id, a.group_id, a.item_id, ";
			query = query
					+ " case f.formula when 1 then truncate(((c.actual_tender_qty * f.conversion_factor1) / b.mdq_value),0) else  c.actual_tender_qty * f.conversion_factor1 end tender_qty, b.comp_rate, ";
			query = query
					+ " round(case f.formula when 1 then truncate(((c.actual_tender_qty * f.conversion_factor1) / b.mdq_value),0) * b.new_totrate_mdq ";
			query = query
					+ " else  c.actual_tender_qty * f.conversion_factor1 * b.new_totrate_mdq end,2) amount, ";
			query = query
					+ " ((b.mrp * b.vat_percent) / 100) tax_amount, b.vat_percent, b.disp_type, b.mdq_value, b.new_totrate_mdq, b.mrp, d.tender_no, d.tender_invitation_date,new_taxamt_per_mdq ";
			query = query
					+ " from store_tender_comm_bid_m a, store_tender_comm_bid_t b, store_re_tender_proposal c, store_tender_m d, mas_store_item e, mas_store_item_conversion f ";
			query = query + " where a.id = b.comm_bid_id ";
			query = query + " and a.tender_id = d.id ";
			query = query + " and c.item_id = a.item_id ";
			query = query + " and a.item_id = e.item_id ";
			query = query + " and e.item_conversion_id = f.item_conversion_id ";
			query = query + " and c.department_id = " + box.getInt("dept_id");
			query = query + " and c.tender_id = " + box.getInt("tender_id");
			query = query + " and a.tender_id = " + box.getInt("tender_id");
			query = query + " and a.group_id = " + box.getInt("group_id");
			// query = query + " and b.lcat=1";
			query = query + " and b.supplier_id = " + box.getInt("supplier_id");
			query = query + " and c.proposal_id = " + box.getInt(PROPOSAL_ID);
			query = query + " and a.item_id in " + items;

			List objectList = session.createSQLQuery(query).list();

			for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
				Object[] obj = (Object[]) iterator.next();
				tender_no = obj[14].toString();
				tender_date = (Date) obj[15];
				try {
					BigDecimal val = new BigDecimal(obj[7].toString());
					net_amount = net_amount.add(val);
				} catch (Exception e) {
					net_amount = net_amount.add(new BigDecimal(0));
				}
			}

			List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
			storeFyDocumentNoList = hbt
					.find("from jkt.hms.masters.business.StoreFyDocumentNo as inp where inp.Department.Id = "
							+ box.getInt("dept_id"));
			String no = "";
			if (storeFyDocumentNoList != null
					&& storeFyDocumentNoList.size() > 0) {
				StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) storeFyDocumentNoList
						.get(0);
				no = ("" + storeFyDocumentNo.getPoNo());
				storeFyDocumentNo.setPoNo(getMaxNo(no));
				hbt.update(storeFyDocumentNo);
				hbt.refresh(storeFyDocumentNo);
			}

			storePoHeader = new StorePoHeader();
			storePoHeader.setPoDate(HMSUtil.convertStringTypeDateToDateType(box
					.get(CHANGED_DATE)));
			storePoHeader.setPoTime(box.getString(CHANGED_TIME));
			storePoHeader.setQuotationNumber(tender_no);
			storePoHeader
					.setDepartment(new MasDepartment(box.getInt("dept_id")));
			storePoHeader.setSupplier(new MasStoreSupplier(box
					.getInt("supplier_id")));
			storePoHeader.setDeliveryDate(HMSUtil
					.convertStringTypeDateToDateType(box.get("delivery")));
			storePoHeader.setLastChgBy(box.get(CHANGED_BY));
			storePoHeader.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(box.get(CHANGED_DATE)));
			storePoHeader.setLastChgTime(box.getString(CHANGED_TIME));
			storePoHeader.setStatus("o");
			storePoHeader.setFlag("r");
			storePoHeader.setQuotationDate(tender_date);
			storePoHeader.setRemarks(box.getString("remarks"));
			storePoHeader.setPayTerms("");
			storePoHeader.setDeliveryTerms("");
			storePoHeader.setApprovalAuthority("");
			storePoHeader.setSigningAuthority("");
			storePoHeader.setTenderM(new StoreTenderM(box.getInt("tender_id")));
			storePoHeader.setGroup(new MasStoreGroup(box.getInt("group_id")));
			storePoHeader.setNetAmount(net_amount);
			storePoHeader.setPoNumber(getMaxNo(no));
			storePoHeader.setProposalId(box.getInt(PROPOSAL_ID));
			hbt.save(storePoHeader);
			hbt.refresh(storePoHeader);

			java.util.Date poDate = storePoHeader.getPoDate();
			// Update MasStoreBudget Master record
			List<MasStoreFinancial> masStoreFinancialList = new ArrayList<MasStoreFinancial>();
			masStoreFinancialList = session.createCriteria(
					MasStoreFinancial.class).list();
			java.util.Date start_date = null;
			java.util.Date end_date = null;
			int financial_id = 0;
			for (Iterator iterator2 = masStoreFinancialList.iterator(); iterator2
					.hasNext();) {
				MasStoreFinancial masStoreFinancial = (MasStoreFinancial) iterator2
						.next();
				start_date = (java.util.Date) masStoreFinancial.getStartDate();
				end_date = (java.util.Date) masStoreFinancial.getEndDate();
				if (poDate.after(start_date) && poDate.before(end_date)) {
					financial_id = masStoreFinancial.getId();
					break;
				} else if (poDate.equals(start_date) || poDate.equals(end_date)) {
					financial_id = masStoreFinancial.getId();
					break;
				}
			}

			// should not add to the MasterBudget
			/*
			 * List<MasStoreBudget> masStoreBudgetList = new
			 * ArrayList<MasStoreBudget>(); masStoreBudgetList =
			 * session.createCriteria(MasStoreBudget.class)
			 * .add(Restrictions.eq("Financial.Id", financial_id)).list();
			 * BigDecimal existing_committed_amount = null; if
			 * (masStoreBudgetList != null && masStoreBudgetList.size() > 0) {
			 * MasStoreBudget masStoreBudget = masStoreBudgetList.get(0); try {
			 * existing_committed_amount = masStoreBudget
			 * .getPoComittedAmount(); } catch (Exception e) {
			 * existing_committed_amount = new BigDecimal(0); }
			 * masStoreBudget.setPoComittedAmount(existing_committed_amount
			 * .add(net_amount)); hbt.update(masStoreBudget); }
			 */

			int slno = 1;
			for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
				storePoDetail = new StorePoDetail();
				Object[] obj = (Object[]) iterator.next();
				storePoDetail.setAmount(new BigDecimal(obj[7].toString()));
				storePoDetail.setDispType(obj[10].toString());
				storePoDetail.setItem(new MasStoreItem(new Integer(obj[4]
						.toString())));
				storePoDetail.setMdqValue(new BigDecimal(obj[11].toString()));
				storePoDetail.setMrp(new BigDecimal(obj[13].toString()));
				storePoDetail.setPo(storePoHeader);
				storePoDetail.setQuantityOrdered(new BigDecimal(obj[5]
						.toString()));
				storePoDetail.setRatePerMdq(new BigDecimal(obj[12].toString()));
				storePoDetail.setSerialNo(slno++);
				storePoDetail.setTaxAmount(new BigDecimal(obj[8].toString()));
				storePoDetail.setTaxPercent(new BigDecimal(obj[9].toString()));
				storePoDetail.setUnitRate(new BigDecimal(obj[6].toString()));
				storePoDetail
						.setTaxAmtPerMdq(new BigDecimal(obj[16].toString()));
				hbt.save(storePoDetail);

				List<StoreReTenderProposal> storeReTenderProposalList = new ArrayList<StoreReTenderProposal>();
				storeReTenderProposalList = session.createCriteria(
						StoreReTenderProposal.class).add(
						Restrictions.eq("TenderId.Id", new Integer(obj[2]
								.toString()))).add(
						Restrictions.eq("Item.Id", new Integer(obj[4]
								.toString()))).add(
						Restrictions.eq("Department.Id", new Integer(obj[0]
								.toString()))).add(
						Restrictions.eq("ProposalId", box.getInt(PROPOSAL_ID)))
						.list();

				if (storeReTenderProposalList != null
						&& storeReTenderProposalList.size() > 0) {
					StoreReTenderProposal storeReTenderProposal = storeReTenderProposalList
							.get(0);
					storeReTenderProposal.setPo(storePoHeader);
					storeReTenderProposal.setStatus("p");
					hbt.update(storeReTenderProposal);
				}

				List<StoreTenderCommBidT> storeTenderCommBidTList = new ArrayList<StoreTenderCommBidT>();
				storeTenderCommBidTList = session.createCriteria(
						StoreTenderCommBidT.class).createAlias("CommBid",
						"commbid").add(
						Restrictions.eq("commbid.Tender.Id", box
								.getInt("tender_id"))).add(
						Restrictions.eq("commbid.Group.Id", box
								.getInt("group_id"))).add(
						Restrictions.eq("Supplier.Id", box
								.getInt("supplier_id"))).add(
						Restrictions.eq("commbid.Item.Id", new Integer(obj[4]
								.toString()))).list();

				if (storeTenderCommBidTList != null
						&& storeTenderCommBidTList.size() > 0) {
					for (StoreTenderCommBidT storeTenderCommBidT : storeTenderCommBidTList) {
						StoreTenderCommBidM storeTenderCommBidM = storeTenderCommBidT
								.getCommBid();
						storeTenderCommBidM.setStatus("p");
						hbt.update(storeTenderCommBidM);
					}
				}
			}

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		// map = getGroupAndTenderAndSupplierComboDetails(box);
		return map;
	}

	public Map<String, Object> cancelReTenderSupplyOrderItems(Box box) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		List<StorePoDetail> storePoDetailList = new ArrayList<StorePoDetail>();
		// StorePoHeader storePoHeader = null;
		StorePoDetail storePoDetail = null;
		Session session = (Session) getSession();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Vector cancel = box.getVector(ITEMS_TO_BE_DELETED);
			Vector remarks = box.getVector("remarks");
			Vector itemIds = box.getVector("itemIds");
			Vector lcat = box.getVector("lcat");

			for (Iterator iterator = cancel.iterator(); iterator.hasNext();) {
				int item_id = new Integer(iterator.next().toString());

				storePoDetailList = session.createCriteria(StorePoDetail.class)
						.createAlias("Po", "P").add(
								Restrictions.eq("P.Department.Id", box
										.getInt("dept_id"))).add(
								Restrictions.eq("P.Supplier.Id", box
										.getInt("supplier_id"))).add(
								Restrictions.eq("P.TenderM.Id", box
										.getInt("tender_id"))).add(
								Restrictions.eq("P.Group.Id", box
										.getInt("group_id"))).add(
								Restrictions.eq("Item.Id", item_id)).add(
								Restrictions.eq("P.Flag", "r")).add(
								Restrictions.eq("P.ProposalId", box
										.getInt(PROPOSAL_ID)))

						.list();

				if (storePoDetailList != null && storePoDetailList.size() > 0) {
					storePoDetail = storePoDetailList.get(0);
					int po_id = storePoDetail.getPo().getId();
					StorePoHeader storePoHeader = new StorePoHeader();
					storePoDetail.setCancelled("y");
					int i = 0;
					for (Iterator iterator2 = itemIds.iterator(); iterator2
							.hasNext();) {
						int id = new Integer(iterator2.next().toString());
						if (item_id == id) {
							storePoDetail.setRemarks(remarks.get(i).toString());
							if (!lcat.get(i).toString().equals("0"))
								storePoDetail
										.setReSupplierId(new MasStoreSupplier(
												Integer.parseInt(lcat.get(i)
														.toString())));
						}
						i++;
					}

					storePoHeader = (StorePoHeader) hbt.load(
							StorePoHeader.class, po_id);
					BigDecimal net_amount = storePoHeader.getNetAmount();
					net_amount = net_amount.subtract(storePoDetail.getAmount());

					storePoHeader.setNetAmount(net_amount);
					hbt.update(storePoHeader);
					hbt.refresh(storePoHeader);

					hbt.update(storePoDetail);
					hbt.refresh(storePoDetail);
				}

			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> getReTenderSupplierListForReLPO(Box box) {
		// // TODO Auto-generated method stub
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		map = getGroupAndTenderComboDetailsForProposal(box);
		List<StoreTenderCommBidM> storeTenderCommBidMList = new ArrayList<StoreTenderCommBidM>();
		List<StoreTenderCommBidT> storeTenderCommBidTList = new ArrayList<StoreTenderCommBidT>();

		String query = "";

		query = query + " select d.supplier_name, ";
		query = query + " count(a.item_id) no_of_items, ";
		query = query
				+ " round(sum(case f.formula when 1 then truncate(((c.actual_tender_qty * f.conversion_factor1) / b.mdq_value),0) * b.final_price_per_mdq else ";
		query = query
				+ " c.actual_tender_qty * f.conversion_factor1 * b.final_price_per_mdq end),2) net_amount, ";
		query = query + " b.supplier_id, a.status ";
		query = query
				+ " from store_tender_comm_bid_m a, store_tender_comm_bid_t b, store_re_tender_proposal c, mas_store_supplier d, mas_store_item e,mas_store_item_conversion f, store_po_detail g, store_po_header h ";
		query = query + " where a.id = b.comm_bid_id ";
		query = query + " and c.item_id = a.item_id ";
		query = query + " and a.item_id = e.item_id  ";
		query = query + " and e.item_conversion_id = f.item_conversion_id ";
		query = query + " and b.supplier_id = g.re_supplier_id ";
		query = query + " and g.re_supplier_id = d.supplier_id ";
		query = query
				+ " and ((c.po_id = g.re_supply_order and a.item_id = g.item_id) or (c.po_id = g.po_id and a.item_id = g.item_id)) ";
		query = query + " and g.po_id = h.po_id ";
		query = query + " and c.department_id = " + box.getInt("deptId");
		query = query + " and c.tender_id = " + box.getInt(TENDER_NO);
		query = query + " and a.tender_id = " + box.getInt(TENDER_NO);
		query = query + " and a.group_id = "
				+ box.getInt(TENDER_SUPPLIER_GROUP_ID);
		query = query + " and g.cancelled='y' ";
		query = query + " and c.proposal_id = " + box.getInt(PROPOSAL_ID);
		query = query + " group by g.re_supplier_id ";

		List objectList = (List) session.createSQLQuery(query).list();
		//System.out.println("size " + objectList.size());
		map.put("objectList", objectList);
		return map;
	}

	public Map<String, Object> showReTenderReSupplyOrderSplitUp(Box box) {
		// TODO Auto-generated method stub
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<StorePoHeader> storePoHeaderList = new ArrayList<StorePoHeader>();
		List<StorePoDetail> storePoDetailList = new ArrayList<StorePoDetail>();
		String query = "";

		query = query
				+ " select concat(d.supplier_name,' [',d.supplier_code,']') supplier_name, e.pvms_no, e.nomenclature, concat(truncate(c.actual_tender_qty,2),' ',i.unit_name),  b.disp_type, b.mdq_value, b.rate_per_mdq, b.comp_rate, ";
		query = query
				+ " round(case f.formula when 1 then truncate(((c.actual_tender_qty * f.conversion_factor1) / b.mdq_value),0) * b.new_totrate_mdq else c.actual_tender_qty * f.conversion_factor1 * b.new_totrate_mdq end,2) amount, ";
		query = query
				+ " c.po_id, a.item_id, g.cancelled, g.re_supply_order,b.new_rate_per_mdq,new_taxamt_per_mdq ";
		query = query
				+ " from store_tender_comm_bid_m a, store_tender_comm_bid_t b, store_re_tender_proposal c, mas_store_supplier d, mas_store_item e, mas_store_item_conversion f, store_po_detail g, store_po_header h, mas_store_unit i ";
		query = query + " where a.id = b.comm_bid_id ";
		query = query + " and c.item_id = a.item_id ";
		query = query + " and a.item_id = e.item_id ";
		query = query + " and e.item_conversion_id = f.item_conversion_id ";
		query = query + " and f.purchase_unit_id = i.unit_id";
		query = query + " and b.supplier_id = g.re_supplier_id ";
		query = query + " and g.re_supplier_id = d.supplier_id ";
		query = query + " and (c.po_id = g.po_id and a.item_id = g.item_id) ";
		query = query + " and g.po_id = h.po_id ";
		query = query + " and c.department_id = " + box.getInt("dept_id");
		query = query + " and c.tender_id = " + box.getInt("tender_id");
		query = query + " and a.tender_id = " + box.getInt("tender_id");
		query = query + " and a.group_id = " + box.getInt("group_id");
		query = query
				+ " and g.cancelled='y' and h.flag='r' and c.proposal_id = "
				+ box.getInt(PROPOSAL_ID);
		query = query + " and g.re_supplier_id = " + box.getInt("supplier_id");
		// query = query + " order by a.item_id ";
		query = query + " union ";
		query = query
				+ " select concat(d.supplier_name,' [',d.supplier_code,']') supplier_name, e.pvms_no, e.nomenclature, concat(truncate(c.actual_tender_qty,0),' ',i.unit_name),  b.disp_type, b.mdq_value, b.rate_per_mdq, b.comp_rate, ";
		query = query
				+ " round(case f.formula when 1 then truncate(((c.actual_tender_qty * f.conversion_factor1) / b.mdq_value),0) * b.final_price_per_mdq else c.actual_tender_qty * f.conversion_factor1 * b.final_price_per_mdq end,2) amount, ";
		query = query + " c.po_id, a.item_id, g.cancelled, g.re_supply_order ";
		query = query
				+ " from store_tender_comm_bid_m a, store_tender_comm_bid_t b, store_re_tender_proposal c, mas_store_supplier d, mas_store_item e, mas_store_item_conversion f, store_po_detail g, store_po_header h, mas_store_unit i ";
		query = query + " where a.id = b.comm_bid_id ";
		query = query + " and c.item_id = a.item_id ";
		query = query + " and a.item_id = e.item_id ";
		query = query + " and e.item_conversion_id = f.item_conversion_id ";
		query = query + " and f.purchase_unit_id = i.unit_id";
		query = query + " and b.supplier_id = g.re_supplier_id ";
		query = query + " and g.re_supplier_id = d.supplier_id ";
		query = query
				+ " and (c.po_id = g.re_supply_order and a.item_id = g.item_id) ";
		query = query + " and g.po_id = h.po_id ";
		query = query + " and c.department_id = " + box.getInt("dept_id");
		query = query + " and c.tender_id = " + box.getInt("tender_id");
		query = query + " and a.tender_id = " + box.getInt("tender_id");
		query = query + " and a.group_id = " + box.getInt("group_id");
		query = query
				+ " and g.cancelled='y' and h.flag='r' and c.proposal_id = "
				+ box.getInt(PROPOSAL_ID);
		query = query + " and g.re_supplier_id = " + box.getInt("supplier_id");
		// query = query + " order by a.item_id ";

		List objectList = (List) session.createSQLQuery(query).list();

		String qry = " select distinct a.po_number from store_po_header a, store_po_detail b ";
		qry = qry + " where a.po_id = b.re_supply_order ";
		qry = qry + " and a.department_id = " + box.getInt("dept_id");
		qry = qry + " and a.tender_id = " + box.getInt("tender_id");
		qry = qry + " and a.group_id = " + box.getInt("group_id");
		qry = qry + " and a.supplier_id = " + box.getInt("supplier_id");
		qry = qry + " and a.flag = 'r' ";
		qry = qry + " and b.re_supply_order is not null order by a.po_number ";

		List poList = null;
		poList = (List) session.createSQLQuery(qry).list();

		map.put("objectList", objectList);
		map.put("poList", poList);
		return map;
	}

	public Map<String, Object> generateReTenderReLocalPurchaseOrder(Box box) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreSetup> storeSetupList = new ArrayList<StoreSetup>();
		StorePoHeader storePoHeader = null;
		StorePoDetail storePoDetail = null;
		Session session = (Session) getSession();
		BigDecimal net_amount = new BigDecimal(0);
		String tender_no = "";
		Date tender_date = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			Vector v = box.getVector(ITEMS_TO_BE_ADDED);
			String str = v.toString();
			String items = str.substring(1, str.length() - 1);
			items = "(" + items + ")";

			String query = "";
			query = query
					+ " select c.department_id, b.supplier_id, a.tender_id, a.group_id, a.item_id, ";
			query = query
					+ " case f.formula when 1 then truncate(((c.actual_tender_qty * f.conversion_factor1) / b.mdq_value),0) else  c.actual_tender_qty * f.conversion_factor1 end tender_qty, b.comp_rate, ";
			query = query
					+ " round(case f.formula when 1 then truncate(((c.actual_tender_qty * f.conversion_factor1) / b.mdq_value),0) * b.final_price_per_mdq ";
			query = query
					+ " else  c.actual_tender_qty * f.conversion_factor1 * b.final_price_per_mdq end,2) amount, ";
			query = query
					+ " ((b.mrp * b.vat_percent) / 100) tax_amount, b.vat_percent, b.disp_type, b.mdq_value, b.final_price_per_mdq, b.mrp, d.tender_no, d.tender_invitation_date ";
			query = query
					+ " from store_tender_comm_bid_m a, store_tender_comm_bid_t b, store_re_tender_proposal c, store_tender_m d, mas_store_item e, mas_store_item_conversion f ";
			query = query + " where a.id = b.comm_bid_id ";
			query = query + " and a.tender_id = d.id ";
			query = query + " and c.item_id = a.item_id ";
			query = query + " and a.item_id = e.item_id ";
			query = query + " and e.item_conversion_id = f.item_conversion_id ";
			query = query + " and c.department_id = " + box.getInt("dept_id");
			query = query + " and c.tender_id = " + box.getInt("tender_id");
			query = query + " and a.tender_id = " + box.getInt("tender_id");
			query = query + " and a.group_id = " + box.getInt("group_id");
			query = query + " and b.supplier_id = " + box.getInt("supplier_id");
			query = query + " and c.proposal_id = " + box.getInt(PROPOSAL_ID);
			query = query + " and a.item_id in " + items;

			List objectList = session.createSQLQuery(query).list();

			for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
				Object[] obj = (Object[]) iterator.next();
				tender_no = obj[14].toString();
				tender_date = (Date) obj[15];
				try {
					BigDecimal val = new BigDecimal(obj[7].toString());
					net_amount = net_amount.add(val);
				} catch (Exception e) {
					net_amount = net_amount.add(new BigDecimal(0));
				}
			}

			List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
			storeFyDocumentNoList = hbt
					.find("from jkt.hms.masters.business.StoreFyDocumentNo as inp where inp.Department.Id = "
							+ box.getInt("dept_id"));
			String no = "";
			if (storeFyDocumentNoList != null
					&& storeFyDocumentNoList.size() > 0) {
				StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) storeFyDocumentNoList
						.get(0);
				no = ("" + storeFyDocumentNo.getPoNo());
				storeFyDocumentNo.setPoNo(getMaxNo(no));
				hbt.update(storeFyDocumentNo);
				hbt.refresh(storeFyDocumentNo);
			}

			storePoHeader = new StorePoHeader();
			storePoHeader.setPoDate(HMSUtil.convertStringTypeDateToDateType(box
					.get(CHANGED_DATE)));
			storePoHeader.setPoTime(box.getString(CHANGED_TIME));
			storePoHeader.setQuotationNumber(tender_no);
			storePoHeader
					.setDepartment(new MasDepartment(box.getInt("dept_id")));
			storePoHeader.setSupplier(new MasStoreSupplier(box
					.getInt("supplier_id")));
			storePoHeader.setDeliveryDate(HMSUtil
					.convertStringTypeDateToDateType(box.get("delivery")));
			storePoHeader.setLastChgBy(box.get(CHANGED_BY));
			storePoHeader.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(box.get(CHANGED_DATE)));
			storePoHeader.setLastChgTime(box.getString(CHANGED_TIME));
			storePoHeader.setStatus("o");
			storePoHeader.setFlag("r");
			storePoHeader.setQuotationDate(tender_date);
			storePoHeader.setRemarks(box.getString("remarks"));
			storePoHeader.setPayTerms("");
			storePoHeader.setDeliveryTerms("");
			storePoHeader.setApprovalAuthority("");
			storePoHeader.setSigningAuthority("");
			storePoHeader.setTenderM(new StoreTenderM(box.getInt("tender_id")));
			storePoHeader.setGroup(new MasStoreGroup(box.getInt("group_id")));
			storePoHeader.setNetAmount(net_amount);
			storePoHeader.setPoNumber(getMaxNo(no));
			storePoHeader.setProposalId(box.getInt(PROPOSAL_ID));
			hbt.save(storePoHeader);
			hbt.refresh(storePoHeader);

			java.util.Date poDate = storePoHeader.getPoDate();
			// Update MasStoreBudget Master record
			List<MasStoreFinancial> masStoreFinancialList = new ArrayList<MasStoreFinancial>();
			masStoreFinancialList = session.createCriteria(
					MasStoreFinancial.class).list();
			java.util.Date start_date = null;
			java.util.Date end_date = null;
			int financial_id = 0;
			for (Iterator iterator2 = masStoreFinancialList.iterator(); iterator2
					.hasNext();) {
				MasStoreFinancial masStoreFinancial = (MasStoreFinancial) iterator2
						.next();
				start_date = (java.util.Date) masStoreFinancial.getStartDate();
				end_date = (java.util.Date) masStoreFinancial.getEndDate();
				if (poDate.after(start_date) && poDate.before(end_date)) {
					financial_id = masStoreFinancial.getId();
					break;
				} else if (poDate.equals(start_date) || poDate.equals(end_date)) {
					financial_id = masStoreFinancial.getId();
					break;
				}
			}

			// should not add to the MasterBudget
			/*
			 * List<MasStoreBudget> masStoreBudgetList = new
			 * ArrayList<MasStoreBudget>(); masStoreBudgetList =
			 * session.createCriteria(MasStoreBudget.class)
			 * .add(Restrictions.eq("Financial.Id", financial_id)).list();
			 * BigDecimal existing_committed_amount = null; if
			 * (masStoreBudgetList != null && masStoreBudgetList.size() > 0) {
			 * MasStoreBudget masStoreBudget = masStoreBudgetList.get(0); try {
			 * existing_committed_amount = masStoreBudget
			 * .getPoComittedAmount(); } catch (Exception e) {
			 * existing_committed_amount = new BigDecimal(0); }
			 * masStoreBudget.setPoComittedAmount(existing_committed_amount
			 * .add(net_amount)); hbt.update(masStoreBudget); }
			 */

			int slno = 1;
			for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
				storePoDetail = new StorePoDetail();
				Object[] obj = (Object[]) iterator.next();
				storePoDetail.setAmount(new BigDecimal(obj[7].toString()));
				storePoDetail.setDispType(obj[10].toString());
				storePoDetail.setItem(new MasStoreItem(new Integer(obj[4]
						.toString())));
				storePoDetail.setMdqValue(new BigDecimal(obj[11].toString()));
				storePoDetail.setMrp(new BigDecimal(obj[13].toString()));
				storePoDetail.setPo(storePoHeader);
				storePoDetail.setQuantityOrdered(new BigDecimal(obj[5]
						.toString()));
				storePoDetail.setRatePerMdq(new BigDecimal(obj[12].toString()));
				storePoDetail.setSerialNo(slno++);
				storePoDetail.setTaxAmount(new BigDecimal(obj[8].toString()));
				storePoDetail.setTaxPercent(new BigDecimal(obj[9].toString()));
				storePoDetail.setUnitRate(new BigDecimal(obj[6].toString()));
				hbt.save(storePoDetail);

				List<StoreReTenderProposal> storeReTenderProposalList = new ArrayList<StoreReTenderProposal>();
				storeReTenderProposalList = session.createCriteria(
						StoreReTenderProposal.class).add(
						Restrictions.eq("TenderId.Id", new Integer(obj[2]
								.toString()))).add(
						Restrictions.eq("Item.Id", new Integer(obj[4]
								.toString()))).add(
						Restrictions.eq("Department.Id", new Integer(obj[0]
								.toString()))).add(
						Restrictions.eq("ProposalId", box.getInt(PROPOSAL_ID)))
						.list();

				if (storeReTenderProposalList != null
						&& storeReTenderProposalList.size() > 0) {
					StoreReTenderProposal storeReTenderProposal = storeReTenderProposalList
							.get(0);
					storeReTenderProposal.setPo(storePoHeader);
					hbt.update(storeReTenderProposal);
				}

				List<StoreTenderCommBidT> storeTenderCommBidTList = new ArrayList<StoreTenderCommBidT>();
				storeTenderCommBidTList = session.createCriteria(
						StoreTenderCommBidT.class).createAlias("CommBid",
						"commbid").add(
						Restrictions.eq("commbid.Tender.Id", box
								.getInt("tender_id"))).add(
						Restrictions.eq("commbid.Group.Id", box
								.getInt("group_id"))).add(
						Restrictions.eq("Supplier.Id", box
								.getInt("supplier_id"))).add(
						Restrictions.eq("commbid.Item.Id", new Integer(obj[4]
								.toString()))).list();

				if (storeTenderCommBidTList != null
						&& storeTenderCommBidTList.size() > 0) {
					for (Iterator iterator1 = storeTenderCommBidTList
							.iterator(); iterator1.hasNext();) {
						StoreTenderCommBidT storeTenderCommBidT = (StoreTenderCommBidT) iterator1
								.next();
						StoreTenderCommBidM storeTenderCommBidM = storeTenderCommBidT
								.getCommBid();
						storeTenderCommBidM.setStatus("p");
						hbt.update(storeTenderCommBidM);
					}
				}

				List<StorePoDetail> storePoDetailList = new ArrayList<StorePoDetail>();
				storePoDetailList = session.createCriteria(StorePoDetail.class)
						.createAlias("Po", "po").add(
								Restrictions.eq("po.TenderM.Id", box
										.getInt("tender_id"))).add(
								Restrictions.eq("po.Group.Id", box
										.getInt("group_id"))).add(
								Restrictions.eq("po.Department.Id",
										new Integer(obj[0].toString()))).add(
								Restrictions.eq("Item.Id", new Integer(obj[4]
										.toString()))).add(
								Restrictions.eq("po.Flag", "r")).add(
								Restrictions.eq("po.ProposalId", box
										.getInt(PROPOSAL_ID))).add(
								Restrictions.eq("Cancelled", "y")).list();

				if (storePoDetailList != null && storePoDetailList.size() > 0) {
					for (Iterator iterator1 = storePoDetailList.iterator(); iterator1
							.hasNext();) {
						StorePoDetail storePoDetail1 = (StorePoDetail) iterator1
								.next();
						storePoDetail1.setReSupplyOrder(storePoHeader);
						hbt.update(storePoDetail1);
					}
				}
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		// map = getGroupAndTenderAndSupplierComboDetails(box);
		return map;
	}

	public Map<String, Object> showPvmsNomencaltureSearchJsp(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();

		List<StoreTenderCommBidM> masStoreItemList = new ArrayList<StoreTenderCommBidM>();

		session = (Session) getSession();

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		String str = box.get("nomenclature");
		String strForPvms = box.get("pvms");
		if (str != null && str.length() > 0) {
			// //System.out.println("In if loop for nomenclature");
			str = "%" + str.replace(" ", "%") + "%";
			masStoreItemList = hbt
					.find(" from jkt.hms.masters.business.StoreTenderCommBidM as inp where inp.Tender.Id="
							+ box.get("tenderId")
							+ " and inp.Group.Id = "
							+ box.get("groupId")
							+ " and inp.Item.Nomenclature like '" + str + "'");
		} else if (strForPvms != null && strForPvms.length() > 0) {

			strForPvms = strForPvms.replace(" ", "%") + "%";
			// //System.out.println("In if loop for pvms------"+strForPvms);
			masStoreItemList = hbt
					.find(" from jkt.hms.masters.business.StoreTenderCommBidM as inp where inp.Tender.Id="
							+ box.get("tenderId")
							+ " and inp.Group.Id = "
							+ box.get("groupId")
							+ " and inp.Item.PvmsNo like '" + strForPvms + "' ");
		} else {
			masStoreItemList = hbt
					.find(" from jkt.hms.masters.business.StoreTenderCommBidM as inp where inp.Tender.Id="
							+ box.get("tenderId")
							+ " and inp.Group.Id = "
							+ box.get("groupId"));

		}
		map.put("masStoreItemList", masStoreItemList);
		return map;
	}

	public Map<String, Object> getImportProposals(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreTenderProposal> storeTenderProposalList = new ArrayList<StoreTenderProposal>();
		Session session = (Session) getSession();
		String groupId = "0";
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (dataMap.get("groupId") != null
				&& !dataMap.get("groupId").equals("")) {
			groupId = (String) dataMap.get("groupId");
		}

		try {

			/*
			 * String qry="SELECT * FROM MAS_STORE_ITEM m where m.item_id in" +
			 * "(select item_id from store_tender_proposal where status = 'o') "
			 * + "and m.group_id = '"+groupId+"'";
			 */

			String qry = "SELECT s.* FROM store_tender_proposal s,"
					+ "mas_store_item m where s.status = 'o' and m.item_id = s.item_id "
					+ "and m.group_id = '" + groupId + "'";

			storeTenderProposalList = (List) session.createSQLQuery(qry).list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("storeTenderProposalList", storeTenderProposalList);
		return map;
	}

	Session session;

	public Map<String, Object> getSuppliersListByAutocomplete(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreSupplier> suppliersList = new ArrayList<MasStoreSupplier>();
		session = (Session) getSession();
		List objectList = new ArrayList();
		try {
			String str = (String) dataMap.get("autoHint");
			if (str != null && str.length() > 0) {
				str = "%" + str.replace(" ", "%") + "%";
				// String str ="%"+dataMap.get("autoHint")+"%";
				String qry = "SELECT supplier_name FROM mas_store_supplier";
				objectList = (List) session.createSQLQuery(qry).list();
				Criteria c = session.createCriteria(MasStoreSupplier.class)
						.add(Restrictions.like("SupplierName", str)).add(
								Restrictions.in("SupplierName", objectList));
				c.setFirstResult(0);
				c.setMaxResults(20);
				suppliersList = c.list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("suppliersList", suppliersList);
		return map;

	}

	public Map<String, Object> getDocumentForTenderDetails(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreGroup> masStoreGroupList = new ArrayList<MasStoreGroup>();
		//List<StoreTenderInvitationLetter> storeTenderInvitationLetterList = new ArrayList<StoreTenderInvitationLetter>();
		List<StoreTenderM> storeTenderMList = new ArrayList<StoreTenderM>();
		List<MasStoreFinancial> masStoreFinancialList = new ArrayList<MasStoreFinancial>();
		List objectList = new ArrayList();
		int id = 0;

		session = (Session) getSession();

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			if (!box.getString("groupId").equals("")) {
				
				storeTenderMList = (List<StoreTenderM>) session.createCriteria(
						StoreTenderM.class).add(
						(Restrictions.eq("Group.Id", box.getInt("groupId"))))
						.list();

			} else {
				storeTenderMList = hbt
						.find("from jkt.hms.masters.business.StoreTenderM");
			}
			masStoreGroupList = hbt
					.find("from jkt.hms.masters.business.MasStoreGroup");
			masStoreFinancialList = hbt.find("from jkt.hms.masters.business.MasStoreFinancial");
			map.put("masStoreGroupList", masStoreGroupList);
			map.put("storeTenderMList", storeTenderMList);
			map.put("masStoreFinancialList", masStoreFinancialList);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> getItemId(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> masStoreItemList = new ArrayList<MasStoreItem>();
		Session session = (Session) getSession();
		String pvmsNo = "";
		int itemId = 0;
		pvmsNo = box.getString("pvmsNo");
		// //System.out.println("pvmsNo:::::::"+pvmsNo);
		if (!pvmsNo.equals("") && pvmsNo.length() > 0) {
			masStoreItemList = (List<MasStoreItem>) session.createCriteria(
					MasStoreItem.class)
					.add((Restrictions.eq("PvmsNo", pvmsNo))).add(
							Restrictions.eq("Status", "y")).list();

			if (masStoreItemList != null && masStoreItemList.size() > 0) {
				MasStoreItem masStoreItem = (MasStoreItem) masStoreItemList
						.get(0);
				itemId = masStoreItem.getId();
			}
		}
		map.put("itemId", itemId);
		return map;
	}

	public Map<String, Object> getGroupAndTenderComboDetailsForProposal(Box box) {
		// TODO Auto-generated method stub
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreGroup> masStoreGroupList = new ArrayList<MasStoreGroup>();
		List<StoreTenderM> storeTenderMList = new ArrayList<StoreTenderM>();
		List storeReTenderProposalList = new ArrayList();
		List objectList = new ArrayList();
		session = (Session) getSession();
		int id = 0;

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			if (!box.getString("proposalId").equals("")) {

				String query = "SELECT distinct t.tender_id FROM store_re_tender_proposal t  where t.department_id = '"
						+ box.getInt("dept")
						+ "'  and t.proposal_id = "
						+ box.get("proposalId");
				objectList = (List) session.createSQLQuery(query).list();
				if (objectList.get(0) != null) {
					id = Integer.parseInt("" + objectList.get(0));
				}

				storeTenderMList = (List<StoreTenderM>) session.createCriteria(
						StoreTenderM.class).add((Restrictions.eq("Id", id)))
						.list();

				int groupId = 0;
				for (StoreTenderM storeTenderM : storeTenderMList) {
					groupId = storeTenderM.getGroup().getId();
				}

				masStoreGroupList = (List<MasStoreGroup>) session
						.createCriteria(MasStoreGroup.class).add(
								Restrictions.eq("Id", groupId)).list();
				/*
				 * masStoreGroupList =hbt.find(
				 * "select distinct inp.Group from jkt.hms.masters.business.StoreTenderToSupplier inp where inp.Tender.Id="
				 * + box.get("tenderId"));
				 */
			} else {
				storeTenderMList = hbt
						.find("from jkt.hms.masters.business.StoreTenderM");

				masStoreGroupList = hbt
						.find("from jkt.hms.masters.business.MasStoreGroup");
			}

			storeReTenderProposalList = hbt
					.find("select distinct inp.ProposalId from jkt.hms.masters.business.StoreReTenderProposal as inp where inp.Department.Id ='"
							+ box.getInt("dept")
							+ "' order by inp.ProposalId desc");

			map.put("masStoreGroupList", masStoreGroupList);
			map.put("storeTenderMList", storeTenderMList);
			map.put("storeReTenderProposalList", storeReTenderProposalList);

			// //System.out.println("masStore Group list:::::::"+masStoreGroupList.size());
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;

	}

	public Map<String, Object> getSupplyOrderDetail(String soNo, int dept) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StorePoHeader> storePoHeaderList = new ArrayList<StorePoHeader>();
		List<StoreTenderLocalPurchaseT> storeNoteList = new ArrayList<StoreTenderLocalPurchaseT>();
		List<StoreSetup> storeSetUpList = new ArrayList<StoreSetup>();
		Session session = (Session) getSession();
		int po_id = 0;

		if (!soNo.equals("") && soNo.length() > 0) {
			storePoHeaderList = (List<StorePoHeader>) session.createCriteria(
					StorePoHeader.class).add(
					(Restrictions.eq("PoNumber", soNo))).add(
					Restrictions.eq("Department.Id", dept)).list();
		}
		for (StorePoHeader storePoHeader : storePoHeaderList) {
			po_id = storePoHeader.getId();
		}

		storeNoteList = (List<StoreTenderLocalPurchaseT>) session
				.createCriteria(StoreTenderLocalPurchaseT.class).add(
						Restrictions.eq("Po.Id", po_id)).list();

		storeSetUpList = (List<StoreSetup>) session.createCriteria(
				StoreSetup.class).list();

		map.put("storePoHeader", storePoHeaderList);
		map.put("stroeNote", storeNoteList);
		map.put("storeSet", storeSetUpList);

		return map;
	}

	public Map<String, Object> getExcelSheetDataForVendor(Box box) {
		int date = box.getInt(MMF_DEPARTMENT_DATE);
		String storeType = box.get("storeType");
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		String qry = "SELECT s.supplier_code,s.supplier_name,tm.tender_no,m.group_name FROM store_tender_to_supplier ts,mas_store_supplier s"
				+ "  ,mas_store_group m,store_tender_m tm "
				+ "  where ts.tender_id = tm.id "
				+ "  and ts.supplier_id = s.supplier_id"
				+ "  and ts.group_id = m.group_id and tm.id = '"
				+ box.getInt(TENDER_NO) + "'";
		try {
			List<Object> vendorDataList = new ArrayList<Object>();
			//System.out.println("qry::::::::" + qry);
			vendorDataList = session.createSQLQuery(qry).list();
			//System.out.println("mmfDataList" + vendorDataList.size());

			byte[] buffer = new byte[18024];
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet("TESTEXCEL");
			// Create a new font and alter it.
			HSSFFont font = wb.createFont();
			font.setFontHeightInPoints((short) 10);
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setColor((short) 62);
			font.setItalic(false);
			font.setStrikeout(false);
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			HSSFFont font1 = wb.createFont();
			font1.setFontHeightInPoints((short) 10);
			font1.setFontName(HSSFFont.FONT_ARIAL);
			font1.setColor((short) 80);
			font1.setItalic(false);
			font1.setStrikeout(false);
			font1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

			// Fonts are set into a style so create a new one to
			// use.
			HSSFCellStyle style = wb.createCellStyle();
			style.setFont(font);

			HSSFCellStyle style1 = wb.createCellStyle();
			style1.setFont(font1);
			style1.setLocked(true);

			/*
			 * HSSFRow row2 = sheet.createRow((short) 2); // Create a cell and
			 * put a value in it. HSSFCell cell20 = row2.createCell((short) 3);
			 * cell20.setCellValue("COMMAND HOSPITAL AIR FORCE, BANGALORE -7");
			 * cell20.setCellStyle(style1); sheet.addMergedRegion(new Region(2,
			 * (short) 3, 2, (short) 7));
			 * 
			 * HSSFRow row3 = sheet.createRow((short) 3); // Create a cell and
			 * put a value in it. HSSFCell cell30 = row3.createCell((short) 3);
			 * cell30.setCellValue("MMF Entry Approval Form Item Wise");
			 * cell30.setCellStyle(style1); sheet.addMergedRegion(new Region(3,
			 * (short) 3, 3, (short) 7));
			 * 
			 * HSSFRow row4 = sheet.createRow((short) 4); // Create a cell and
			 * put a value in it. HSSFCell cell40 = row4.createCell((short) 4);
			 * cell40.setCellValue("Mmf for The Year :"+date+"");
			 * cell40.setCellStyle(style1); HSSFCell cell43 =
			 * row4.createCell((short) 1);
			 * cell43.setCellValue("Mmf for The Year :"+date+"");
			 * cell43.setCellStyle(style1); sheet.addMergedRegion(new Region(4,
			 * (short) 1, 4, (short) 7));
			 * 
			 * HSSFRow row5 = sheet.createRow((short) 5);
			 * if(storeType.equalsIgnoreCase("e")){ storeType="Expandable"; }
			 * else{ storeType="ECHS"; } HSSFCell cell44 =
			 * row5.createCell((short) 5); cell40.setCellValue("Mmf Type :");
			 * cell40.setCellStyle(style1); HSSFCell cell45 =
			 * row5.createCell((short) 3);
			 * cell45.setCellValue("Mmf Type :"+storeType);
			 * cell45.setCellStyle(style1); sheet.addMergedRegion(new Region(5,
			 * (short) 3, 5, (short) 7));
			 */

			HSSFRow headingRow = sheet.createRow((short) 1);

			HSSFCell cell50 = headingRow.createCell((short) 0);
			cell50.setCellValue("Sl.No");
			cell50.setCellStyle(style);
			HSSFCell cell51 = headingRow.createCell((short) 1);
			cell51.setCellValue("Supplier Code");
			cell51.setCellStyle(style);
			HSSFCell cell52 = headingRow.createCell((short) 2);
			cell52.setCellValue("Supplier Name");
			cell52.setCellStyle(style);
			HSSFCell cell53 = headingRow.createCell((short) 3);
			cell53.setCellValue("Tender No");
			cell53.setCellStyle(style);
			HSSFCell cell54 = headingRow.createCell((short) 4);
			cell54.setCellValue("Group");
			cell54.setCellStyle(style);

			int row = 2;
			int slno = 0;
			for (Iterator iterator = vendorDataList.iterator(); iterator
					.hasNext();) {
				Object[] object = (Object[]) iterator.next();
				sheet.createRow((short) row).createCell((short) 0)
						.setCellValue(++slno);
				sheet.createRow((short) row).createCell((short) 1)
						.setCellValue((String) (object[0]));
				if (object[1] != null) {
					sheet.createRow((short) row).createCell((short) 2)
							.setCellValue(object[1].toString());
				} else {
					sheet.createRow((short) row).createCell((short) 2)
							.setCellValue("");
				}
				if (object[2] != null) {
					sheet.createRow((short) row).createCell((short) 3)
							.setCellValue(object[2].toString());
				} else {
					sheet.createRow((short) row).createCell((short) 3)
							.setCellValue("");
				}
				if (object[3] != null) {
					sheet.createRow((short) row).createCell((short) 4)
							.setCellValue((object[3]).toString());
				} else {
					sheet.createRow((short) row).createCell((short) 4)
							.setCellValue("");
				}

				sheet.setColumnWidth((short) 0, (short) (6 * 256));
				sheet.setColumnWidth((short) 1, (short) (15 * 256));
				sheet.setColumnWidth((short) 2, (short) (60 * 256));
				sheet.setColumnWidth((short) 3, (short) (20 * 256));
				sheet.setColumnWidth((short) 4, (short) (40 * 256));

				row++;
			}
			String grp_name = "VendorReports";
			// Write the output to a file
			grp_name = grp_name + ".xls";
			FileOutputStream fileOut = new FileOutputStream(grp_name);
			wb.write(fileOut);
			fileOut.close();

			map.put("flag", "DataFound");
			map.put("download_path", grp_name);
		} catch (IOException ioe) {
			ioe.printStackTrace();
			map.put("flag", "NoData");
		}

		return map;
	}

	public boolean importLastTenderProposal(Box box) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreTenderProposal> storeTenderProposalList = new ArrayList<StoreTenderProposal>();
		// StoreTenderProposal storeTenderProposal = new StoreTenderProposal();
		Session session = (Session) getSession();
		int month, year;
		String mmfType = "";
		Calendar cal = Calendar.getInstance();
		Calendar calendar = Calendar.getInstance();
		month = calendar.get(Calendar.MONTH) + 1;
		if (month < 4) {
			year = calendar.get(Calendar.YEAR) - 1;
		} else {
			year = calendar.get(Calendar.YEAR);
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt1 = getHibernateTemplate();
		hbt1.setFlushModeName("FLUSH_EAGER");
		hbt1.setCheckWriteOperations(false);
		List<StoreSetup> storeSetupList = new ArrayList<StoreSetup>();
		storeSetupList = hbt1.find("from jkt.hms.masters.business.StoreSetup");

		int echs_dept_id = storeSetupList.get(0).getStoreEchs().getId();
		int exp_dept_id = storeSetupList.get(0).getStoreExpendable().getId();
		if (box.getInt("deptId") == exp_dept_id) {
			mmfType = "e";
		} else if (box.getInt("deptId") == echs_dept_id) {
			mmfType = "h";
		}
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			storeTenderProposalList = session.createQuery(
					"SELECT p from StoreTenderProposal p where "
							+ " p.TenderId.Id = '" + box.getInt("tenderId")
							+ "' and Department.Id='" + box.getInt("deptId")
							+ "'").list();
			//System.out.println(":123:" + storeTenderProposalList.size());
			for (StoreTenderProposal storeTP : storeTenderProposalList) {
				StoreTenderProposal newStoreTP = new StoreTenderProposal();
				newStoreTP.setDepartment(new MasDepartment(storeTP
						.getDepartment().getId()));
				newStoreTP.setHospital(new MasHospital(storeTP.getHospital()
						.getId()));
				newStoreTP.setItem(new MasStoreItem(storeTP.getItem().getId()));

				String currYearMmfSumQuery = "SELECT sum(curr_year_mmf) FROM store_mmf_department_t t,store_mmf_department_m m,mas_store_item s where t.store_mmf_department_m_id=m.id and t.item_id=s.item_id and m.mmf_for_the_year='"
						+ year
						+ "'"
						+ " and s.item_id ='"
						+ storeTP.getItem().getId()
						+ "' and m.mmf_store_type='" + mmfType + "'";
				List objectCurrentYearList = new ArrayList();
				objectCurrentYearList = (List) session.createSQLQuery(
						currYearMmfSumQuery).list();

				BigDecimal qtymmf = null;
				if (objectCurrentYearList != null
						&& objectCurrentYearList.size() > 0) {
					if (objectCurrentYearList.get(0) != null) {
						qtymmf = new BigDecimal(""
								+ objectCurrentYearList.get(0));
					}
				} else {
					qtymmf = new BigDecimal(0);
				}
				if (qtymmf != new BigDecimal(0) && qtymmf != null) {
					newStoreTP.setQtyInMmf(qtymmf);
					newStoreTP.setTenderQty(qtymmf
							.multiply(new BigDecimal("2")));
				} else {
					newStoreTP.setQtyInMmf(new BigDecimal(0));
					newStoreTP.setTenderQty(new BigDecimal(0));
				}

				newStoreTP.setLastChgBy(box.get("puser"));
				newStoreTP.setLastChgDate(HMSUtil
						.convertStringTypeDateToDateType(box.get("pDate")));
				newStoreTP.setLastChgTime(box.get("pTime"));
				newStoreTP.setStatus("o");
				hbt.save(newStoreTP);
				hbt.refresh(newStoreTP);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map = showTenderProposalJsp(box);
		return false;
	}

	public Map<String, Object> getTenders(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;
		StoreTenderProposal storeTenderProposal = new StoreTenderProposal();

		String pvms = null;
		String nomenclature = null;
		String strength = null;
		String disp_type = null;
		String au = null;
		BigDecimal qtymmf = null;
		BigDecimal annreq = null;
		int item_id = 0;
		Criteria c = null;

		List<StoreTenderProposal> storeTenderProposalList = new ArrayList<StoreTenderProposal>();
		List<MasStoreGroup> masStoreGroupList = new ArrayList<MasStoreGroup>();
		List<StoreTenderM> storeTenderMList = new ArrayList<StoreTenderM>();
		List<Object> existingList = new ArrayList<Object>();
		Session session = (Session) getSession();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			//System.out.println("::::::::::::" + box.getInt("groupId"));
			masStoreGroupList = hbt
					.find("from jkt.hms.masters.business.MasStoreGroup");

			if (box.getInt("groupId") != 0 && !box.get("groupId").equals("")) {
				storeTenderMList = hbt
						.find("from jkt.hms.masters.business.StoreTenderM where Group.Id = '"
								+ box.getInt("groupId") + "'");
			}

			String qry = "select i.group_id from store_tender_proposal p,mas_store_item i where p.item_id = i.item_id and p.status = 'o'"
					+ " and i.group_id  = '"
					+ box.getInt("groupId")
					+ "' and p.department_id = '" + box.getInt("deptId") + "'";

			existingList = session.createSQLQuery(qry).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("masStoreGroupList", masStoreGroupList);
		map.put("storeTenderMList", storeTenderMList);
		map.put("existingList", existingList);
		return map;
	}
	// Method for Tendor Costing Report by Vishal---
	
	
	public Map<String, Object> getTenderDetailsForCosting(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreGroup> masStoreGroupList = new ArrayList<MasStoreGroup>();
		List<StoreTenderM> storeTenderMList = new ArrayList<StoreTenderM>();
		List<MasStoreFinancial> masStoreFinancialList = new ArrayList<MasStoreFinancial>();
		 List<MasStoreFinancial> searchMasStoreFinancialList = new ArrayList<MasStoreFinancial>();
		//MasStoreFinancial searchMasStoreFinancialList = new MasStoreFinancial();
		List objectList = new ArrayList();
		int id = 0;

		session = (Session) getSession();

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			if (!box.getString("groupId").equals("") && !box.getString("financialId").equals("")) {
			searchMasStoreFinancialList = hbt.find("from jkt.hms.masters.business.MasStoreFinancial where Id = '"
						+ box.getInt("financialId") + "'");
				
				
				Date startDate = (Date)searchMasStoreFinancialList.get(0).getStartDate();
				Date endDate   = (Date)searchMasStoreFinancialList.get(0).getEndDate();
				//System.out.println("startDate---"+startDate);
				//System.out.println("endDate----"+endDate);
				storeTenderMList = (List<StoreTenderM>) session.createCriteria(
						StoreTenderM.class).add((Restrictions.eq("Group.Id", box.getInt("groupId"))))
						.add((Restrictions.between("TenderInvitationDate", startDate, endDate))).list();

			} else {
				storeTenderMList = hbt.find("from jkt.hms.masters.business.StoreTenderM");
			}
			masStoreGroupList = hbt.find("from jkt.hms.masters.business.MasStoreGroup");
			masStoreFinancialList = hbt.find("from jkt.hms.masters.business.MasStoreFinancial");
			map.put("masStoreGroupList", masStoreGroupList);
			map.put("storeTenderMList", storeTenderMList);
			map.put("masStoreFinancialList", masStoreFinancialList);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;
	}

}
