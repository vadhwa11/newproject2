package jkt.hms.purchaseOrder.dataservice;

import static jkt.hms.util.RequestConstants.ACTUAL_QTY;
import static jkt.hms.util.RequestConstants.AMOUNT;
import static jkt.hms.util.RequestConstants.BRAND_ID;
import static jkt.hms.util.RequestConstants.COST_PRICE;
import static jkt.hms.util.RequestConstants.DISCOUNT_AMOUNT;
import static jkt.hms.util.RequestConstants.DISCOUNT_PERCENTAGE;
import static jkt.hms.util.RequestConstants.ITEM_ID;
import static jkt.hms.util.RequestConstants.MANUFACTURER_ID;
import static jkt.hms.util.RequestConstants.QUANTITY;
import static jkt.hms.util.RequestConstants.TAX_AMOUNT;
import static jkt.hms.util.RequestConstants.TAX_PERCENT;

import java.math.BigDecimal;

import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;


import jkt.hms.masters.business.MasAuthorizer;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDiscount;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasManufacturer;
import jkt.hms.masters.business.MasStoreBrand;
import jkt.hms.masters.business.MasStoreBudget;
import jkt.hms.masters.business.MasStoreBudgetT;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasStorePoDeliveryTerms;
import jkt.hms.masters.business.MasStoreSupplier;
import jkt.hms.masters.business.StoreFyDocumentNo;
import jkt.hms.masters.business.StoreGrnM;
import jkt.hms.masters.business.StoreItemBatchStock;
import jkt.hms.masters.business.StorePoDetail;
import jkt.hms.masters.business.StorePoHeader;
import jkt.hms.masters.business.StoreSetup;
import jkt.hms.masters.business.MasItemCategory;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.JKTRequestUtils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

//import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class PurchaseOrderDataServiceImpl extends HibernateDaoSupport implements
		PurchaseOrderDataService {

	@SuppressWarnings("unchecked")
	public Map<String, Object> showPurchaseOrderJsp(Map<String,Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
//		List<MasDepartment> storeList = new ArrayList<MasDepartment>();
		List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
		// List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		/*List<MasDiscount> discountList = new ArrayList<MasDiscount>();
		List<MasManufacturer> manufacturerList = new ArrayList<MasManufacturer>();*/
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		List<MasItemCategory>masItemCategory=new ArrayList<MasItemCategory>();
		String max = "";
		String no = "";
		int hospitalId=(Integer)dataMap.get("hospitalId");
		int deptId=(Integer)dataMap.get("deptId");
		Session session = (Session) getSession();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
/**
 * Commented By ritu
 * Date 21-05-0213
 */
	/*	storeList = session.createCriteria(MasDepartment.class)

		.add(Restrictions.eq("Hospital.Id",hospitalId))
		.add(Restrictions.eq("Status", "y")).list();*/



		supplierList = session.createCriteria(MasStoreSupplier.class)
		.add(Restrictions.eq("Hospital.Id",hospitalId))
		.add(Restrictions.eq("Status", "y")).addOrder(
				Order.asc("SupplierName")).list();

		masItemCategory=session.createCriteria(MasItemCategory.class).add(
				Restrictions.eq("Status", "y")).addOrder(Order.asc("ItemCategoryName")). list();
		/**
		 * Commented By ritu
		 * Date 21-05-0213
		 */
	/*	discountList = session.createCriteria(MasDiscount.class).add(
				Restrictions.eq("Status", "y")).list();

		manufacturerList = session.createCriteria(MasManufacturer.class)
		.add(Restrictions.eq("Hospital.Id",hospitalId))
		.add(Restrictions.eq("Status", "y")).addOrder(
				Order.asc("ManufacturerName")).list();*/

		/*storeFyDocumentNoList = hbt
		.find("from jkt.hms.masters.business.StoreFyDocumentNo as inp where inp.Hospital.Id="+hospitalId+" and  inp.Department.Id = "
				+ deptId);*/
		storeFyDocumentNoList = session.createCriteria(StoreFyDocumentNo.class).add(Restrictions.eq("Hospital.Id", hospitalId)).add(Restrictions.eq("Department.Id", deptId)).list();
		if (storeFyDocumentNoList != null && storeFyDocumentNoList.size() > 0) {
			StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) storeFyDocumentNoList
					.get(0);
			// startNo=(""+storeFyDocumentNo.getPoStartNo());
			no = storeFyDocumentNo.getPoNo()!=null?("" + storeFyDocumentNo.getPoNo()):"";
		}
		// itemList =
		// hbt.find("from jkt.hms.masters.business.MasStoreItem as ma where ma.Id < 100");
		// itemList =
		// session.createCriteria(MasStoreItem.class).add(Restrictions.eq("Status",
		// "y")).list();

		// storeFyDocumentNoList =
		// session.createCriteria(StoreFyDocumentNo.class).add(Restrictions.eq("Department.Id",
		// deptId)).list();


		// storeFyDocumentNoList =
		// session.createSQLQuery("select po_no from store_fy_document_no as syd where syd.department_id="+
		// deptId).list();
		// for (StoreFyDocumentNo storeFyDocumentNo :storeFyDocumentNoList ) {
		/*
		 * if(storeFyDocumentNo.getDepartment().getId() == deptId) {
		 */

		// }
		// }
		// map.put("itemList", itemList);
		//map.put("storeList", storeList);
		map.put("supplierList", supplierList);
		/*map.put("discountList", discountList);
		map.put("manufacturerList", manufacturerList);*/
		map.put("masItemCategory",masItemCategory);
		try {
			max = getMaxNo(no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("max", max);
		return map;
	}

	/*
	 * This method is user to evaluate auto generated number based on the year
	 * It takes one parameter that is coming from store_fy_document_no
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

		try {
			if (!no.equals("")) {
				StringTokenizer stringTokenizer = new StringTokenizer(no, "/");
				tempMonth = Integer.parseInt(stringTokenizer.nextToken());

				tempMonth++;

				if (currentMonth < 4) {

					maxNo = tempMonth + "/" + y1 + "-" + y2 +"/" +"SO";
				} else {
					maxNo = tempMonth + "/" + y2 + "-" + y3 +"/" +"SO";
				}

			} else {
				if (currentMonth < 4) {
					maxNo = "01" + "/" + y1 + "-" + y2 +"/" +"SO";
				} else {
					maxNo = "01" + "/" + y2 + "-" + y3 +"/" +"SO";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return maxNo;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> submitPurchaseOrder(Map<String, Object> infoMap) {
		boolean flag = false;
		StorePoHeader storePoHeader = null;
		List<StorePoDetail> poDetailList = new ArrayList<StorePoDetail>();
		List<StorePoHeader> list = new ArrayList<StorePoHeader>();
		Map<String, Object> poMap = new HashMap<String, Object>();
		int departmentId = 0;
		String poNumber = "";
		int noOfRecords=0;
		if(infoMap.get("noOfRecords")!=null){
			noOfRecords=(Integer)infoMap.get("noOfRecords");
		}
		BigDecimal[] quantityArr = new BigDecimal[noOfRecords-1];
		int patientIdArr[]=new int[noOfRecords-1];
		int hospitalId=0;
		String requestType="";
		poNumber = (String) infoMap.get("poNumber");

		if (infoMap.get("storePoHeader") != null) {
			storePoHeader = (StorePoHeader) infoMap.get("storePoHeader");
		}
		if (infoMap.get("departmentId") != null) {
			departmentId = (Integer) infoMap.get("departmentId");
		}
		if (infoMap.get("hospitalId") != null) {
			hospitalId = (Integer) infoMap.get("hospitalId");
		}

		if(infoMap.get("requestType")!=null){
			requestType=(String)infoMap.get("requestType");
		}
		if(infoMap.get("quantityArr")!=null){
			quantityArr=(BigDecimal[]) infoMap.get("quantityArr");
		}
		if(infoMap.get("patientIdArr")!=null){
			patientIdArr=(int[]) infoMap.get("patientIdArr");
		}
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session) getSession();
		Transaction transaction = null;
		String no = "";
		java.util.Date poDate = null;
		BigDecimal poAmount = null;
		try {
			transaction = session.beginTransaction();
			if (!(infoMap.get("headerStored") + "").equals("yes")) {
				list = session.createCriteria(StorePoHeader.class).add(
						Restrictions.eq("PoNumber", poNumber)).list();
				/*
				 * if(list !=null && list.size() > 0){ String no1 = "";
				 * List<StoreFyDocumentNo> fycheckList =
				 * session.createCriteria(StoreFyDocumentNo
				 * .class).add(Restrictions.eq("Department.Id",
				 * departmentId)).list();
				 * //System.out.println("list is=============== "
				 * +fycheckList.size()); if(fycheckList != null &&
				 * fycheckList.size() > 0){ StoreFyDocumentNo storeFyDocumentNo
				 * = (StoreFyDocumentNo)fycheckList.get(0);
				 * //storeFyDocumentNo.setPoNo(poNumber); no1 = ("" +
				 * storeFyDocumentNo.getPoNo());
				 * //System.out.println("getMaxNo(no1)::::::::::"+getMaxNo(no1));
				 * storePoHeader.setPoNumber(getMaxNo(no1)); } }
				 */
				List<StoreFyDocumentNo> fyList = session
				.createCriteria(StoreFyDocumentNo.class)
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.eq("Department.Id", departmentId))
				.list();
				if (fyList != null && fyList.size() > 0) {
					StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) fyList
							.get(0);
					no = storeFyDocumentNo.getPoNo()!=null?("" + storeFyDocumentNo.getPoNo()):"";
					no = getMaxNo(no);
					storeFyDocumentNo.setPoNo(no);
					HibernateTemplate hbt2 = getHibernateTemplate();
					hbt2.setFlushModeName("FLUSH_EAGER");
					hbt2.update(storeFyDocumentNo);
				}
				poDate = (java.util.Date) storePoHeader.getPoDate();
				poAmount = storePoHeader.getNetAmount();
				storePoHeader.setPoNumber(no);
				hbt.save(storePoHeader);
				int poId = storePoHeader.getId();
				poMap.put("poId", poId);
			} else {
				int id = Integer.parseInt("" + infoMap.get("poId"));
				storePoHeader = (StorePoHeader) getHibernateTemplate().load(
						StorePoHeader.class, id);
				storePoHeader.setNetAmount(new BigDecimal(infoMap.get("totalAmount").toString()));
				hbt.update(storePoHeader);
			}
			if (infoMap.get("poDetailList") != null) {
				poDetailList = (List<StorePoDetail>) infoMap.get("poDetailList");
				if (poDetailList.size() > 0) {
					StorePoHeader storePoHeaderObj = new StorePoHeader();
					if ((infoMap.get("headerStored") + "").equals("yes")) {
						int id = Integer.parseInt("" + infoMap.get("poId"));
						storePoHeaderObj.setId(id);
					}
					for (int i = 0; i < poDetailList.size(); i++) {
						StorePoDetail storePoDetailObj = (StorePoDetail) poDetailList
								.get(i);
						if ((infoMap.get("headerStored") + "").equals("yes")) {
							storePoDetailObj.setPo(storePoHeaderObj);
							hbt.save(storePoDetailObj);
						} else {
							storePoDetailObj.setPo(storePoHeader);
							hbt.save(storePoDetailObj);
						}

					}
					int pageNo = 0;
					pageNo = Integer.parseInt("" + infoMap.get("pageNo"));
					poNumber = (String) infoMap.get("poNumber");

				}



				/*
				poDetailList = (List<StorePoDetail>) infoMap
						.get("poDetailList");
				System.out.println("poDetailList.size()  in DS >"+poDetailList.size() );
				if (poDetailList.size() > 0) {
					StorePoHeader storePoHeaderObj = new StorePoHeader();
					int id = Integer.parseInt("" + infoMap.get("poId"));
					if ((infoMap.get("headerStored") + "").equals("yes")) {
						// int id = Integer.parseInt(""+infoMap.get("poId"));
						storePoHeaderObj.setId(id);
					}

					for (int i = 0; i < poDetailList.size(); i++) {
						StorePoDetail storePoDetailObj = (StorePoDetail) poDetailList
								.get(i);
						List<StorePoDetail> itemExistList = new ArrayList<StorePoDetail>();

						itemExistList = session.createCriteria(
								StorePoDetail.class).createAlias("Po", "po")
								.createAlias("Item", "item").add(
										Restrictions.eq("po.Id", id)).add(
										Restrictions.eq("item.Id",
												storePoDetailObj.getItem()
														.getId())).list();
						if (itemExistList.size() == 0) {
							if ((infoMap.get("headerStored") + "")
									.equals("yes")) {
								storePoDetailObj.setPo(storePoHeaderObj);
								session.save(storePoDetailObj);
							} else {
								try {
									storePoDetailObj.setPo(storePoHeader);
									session.save(storePoDetailObj);
								} catch (DataAccessException e) {
									e.printStackTrace();
								}
							}
						}
					}
					int pageNo = 0;

					pageNo = Integer.parseInt("" + infoMap.get("pageNo"));
					pageNo = Integer.parseInt("" + infoMap.get("pageNo"));
					poNumber = (String) infoMap.get("poNumber");
					if (pageNo == 1) {
						String no = "";
						List<StoreFyDocumentNo> fyList = session
								.createCriteria(StoreFyDocumentNo.class).add(
										Restrictions.eq("Department.Id",departmentId)).list();
						if (fyList != null && fyList.size() > 0) {
							StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) fyList
									.get(0);
							// storeFyDocumentNo.setPoNo(poNumber);
							no = ("" + storeFyDocumentNo.getPoNo());
							storeFyDocumentNo.setPoNo(getMaxNo(no));
							HibernateTemplate hbt2 = getHibernateTemplate();
							hbt2.setFlushModeName("FLUSH_EAGER");
							hbt2.update(storeFyDocumentNo);
							hbt.refresh(storeFyDocumentNo);
						}
					}
				}
			*/}

			/*
			 * List<MasStoreFinancial> masStoreFinancialList = new
			 * ArrayList<MasStoreFinancial>(); masStoreFinancialList =
			 * session.createCriteria(MasStoreFinancial.class).list();
			 * java.util.Date start_date = null; java.util.Date end_date = null;
			 * int financial_id = 0;
			 */
			/*
			 * for (Iterator iterator = masStoreFinancialList.iterator();
			 * iterator.hasNext();) { MasStoreFinancial masStoreFinancial =
			 * (MasStoreFinancial) iterator.next(); start_date =
			 * (java.util.Date)masStoreFinancial.getStartDate(); end_date =
			 * (java.util.Date)masStoreFinancial.getEndDate(); if
			 * (poDate.after(start_date) && poDate.before(end_date)) {
			 * financial_id = masStoreFinancial.getId(); break; } else if
			 * (poDate.equals(start_date) || poDate.equals(end_date)) {
			 * financial_id = masStoreFinancial.getId(); break; } }
			 */
			// //System.out.println("Financial Id "+financial_id);

			/*
			 * List<MasStoreBudget> masStoreBudgetList = new
			 * ArrayList<MasStoreBudget>(); masStoreBudgetList =
			 * session.createCriteria
			 * (MasStoreBudget.class).add(Restrictions.eq("Financial.Id",
			 * financial_id)).list(); BigDecimal existing_committed_amount =
			 * null; if (masStoreBudgetList!=null &&
			 * masStoreBudgetList.size()>0) { MasStoreBudget masStoreBudget =
			 * masStoreBudgetList.get(0); try { existing_committed_amount =
			 * masStoreBudget.getPoComittedAmount(); } catch(Exception e) {
			 * existing_committed_amount = new BigDecimal(0); }
			 *
			 * masStoreBudget.setPoComittedAmount(existing_committed_amount.add(
			 * poAmount)); hbt.update(masStoreBudget);
			 * //System.out.println("Budget master updated successfully"); }
			 */
			if(requestType.equalsIgnoreCase("importLp")){
				Query query=null;
				int i=0;
				String updatePendingPre="update PatientPrescriptionDetails as ppd  set ppd.SoId=:SoId" +
				",ppd.SoItem=:SoItem,ppd.SoQty=:SoQty" +
				" where ppd.Id=:Id ";
				query=session.createQuery(updatePendingPre);
				for(int j=0;j<noOfRecords-1;j++){
				query.setParameter("SoId",poNumber);
				query.setParameter("SoItem","y");
				query.setParameter("SoQty", Integer.parseInt(quantityArr[j].toString()));
				query.setParameter("Id",patientIdArr[j] );
				query.executeUpdate();
				}
			}
			flag = true;
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		}
		poMap.put("flag", flag);
		poMap.put("fPoNumber", storePoHeader.getPoNumber());
		return poMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDetailsForMoreInfoPurchase() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
		List<MasManufacturer> manufacturerList = new ArrayList<MasManufacturer>();
		Session session = (Session) getSession();

		brandList = session.createCriteria(MasStoreBrand.class).add(
				Restrictions.eq("Status", "y")).list();
		manufacturerList = session.createCriteria(MasManufacturer.class).add(
				Restrictions.eq("Status", "y")).list();

		map.put("brandList", brandList);
		map.put("manufacturerList", manufacturerList);

		return map;
	}

	@SuppressWarnings("unchecked")
	public int getPurchaseOrderId(String poNumber,int hospitalId) {
		int poId = 0;
		List<StorePoHeader> list = new ArrayList<StorePoHeader>();
		Session session = (Session) getSession();

		list = session.createCriteria(StorePoHeader.class).add(
				Restrictions.eq("Status", "o")).add(
				Restrictions.eq("PoNumber", poNumber)).add(Restrictions.eq("Hospital.Id",hospitalId)).list();
		for (StorePoHeader storePoHeader : list) {
			poId = Integer.parseInt("" + storePoHeader.getId());
		}
		return poId;
	}

	@SuppressWarnings( { "unused", "unchecked" })
	public List<StorePoHeader> getPoHeader(int poId) {
		Session session = (Session) getSession();
		List<StorePoHeader> poHeaderList = session.createCriteria(
				StorePoHeader.class).add(Restrictions.eq("Id", poId)).list();
		return poHeaderList;
	}

	@SuppressWarnings("unchecked")
	public List<StorePoHeader> getPoNumberList(int deptId,int hospitalId) {
		Session session = (Session) getSession();
		List<StorePoHeader> poNumberList = session.createCriteria(StorePoHeader.class).add(Restrictions.eq("Department.Id", deptId)).add(Restrictions.eq("Hospital.Id", hospitalId)).add(Restrictions.isNull("TenderM")).addOrder(Order.desc("Id")).list();
		return poNumberList;
	}

	public List<MasStoreItem> getLpItemList(List itemList) {
		Session session = (Session) getSession();
		List<MasStoreItem>itemListid=new ArrayList<MasStoreItem>();
		for(int i=0;i<itemList.size();i++){
			List<MasStoreItem>item=session.createCriteria(MasStoreItem.class).add(Restrictions.eq("Id",Integer.parseInt(itemList.get(i).toString()))).list();
			itemListid.addAll(item);
		}
		return itemListid;
	}

	@SuppressWarnings("unchecked")
	public List<MasStoreBudget> getBudgetStatusList() {
		Session session = (Session) getSession();
		java.util.Date date = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.get(Calendar.YEAR);
		int currentYear = cal.get(Calendar.YEAR);
		int advanceYear = currentYear+1;
		String finacialYearStartDate = "01/03/"+currentYear;//""+currentYear+"-04-01" ;
		String finacialYearEndDate = "31/03/"+advanceYear;//""+advanceYear+"-03-31";
		List<MasStoreBudget> budgetStatusList = session.createCriteria(
				MasStoreBudget.class).add(Restrictions.eq("Status", "y"))
				.createAlias("Financial", "finacialYear")
				.add(Restrictions.eq("finacialYear.StartDate", HMSUtil.convertStringTypeDateToDateType(finacialYearStartDate)))
				.add(Restrictions.eq("finacialYear.EndDate", HMSUtil.convertStringTypeDateToDateType(finacialYearEndDate)))
				.add(Restrictions.eq("finacialYear.Status", "y"))
				.list();
		return budgetStatusList;
	}

	@SuppressWarnings("unchecked")
	public Map getViewAllMap(int hospitalId)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
		List<StorePoDetail> poDetailList = new ArrayList<StorePoDetail>();
		List<StorePoHeader> poHeaderList = new ArrayList<StorePoHeader>();
		Session session = (Session) getSession();
		try {
			poDetailList = session.createCriteria(StorePoDetail.class).list();
			supplierList = session.createCriteria(MasStoreSupplier.class).add(Restrictions.eq("Hospital.Id",hospitalId)).add(Restrictions.eq("Status", "y")).list();
			poHeaderList = session.createCriteria(StorePoHeader.class).add(Restrictions.eq("Hospital.Id",hospitalId)).add(Restrictions.eq("Status", "y")).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("poDetailList", poDetailList);
		map.put("poHeaderList", poHeaderList);
		map.put("supplierList", supplierList);

		return map;
	}

	@SuppressWarnings( { "unchecked", "unused" })
	public Map<String, Object> searchPO(Map<String, Object> searchMap)
			{
		String fromDate = "";
		String toDate = "";
		int supplierId = 0;
		int poId = 0;
		int departmentId = 0;
		int hospitalId=0;

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreSupplier> searchSupplierList = new ArrayList<MasStoreSupplier>();
		//List<StorePoDetail> searchPoDetailList = new ArrayList<StorePoDetail>();
		List<StorePoHeader> searchPoHeaderList = new ArrayList<StorePoHeader>();
		Session session = (Session) getSession();
		hospitalId=(Integer)searchMap.get("hospitalId");
		//searchPoDetailList = session.createCriteria(StorePoDetail.class).list();
		searchSupplierList = session.createCriteria(MasStoreSupplier.class).createAlias("Hospital","hospital").add(Restrictions.eq("hospital.Id", hospitalId)).add(Restrictions.eq("Status", "y")).list();
		Criteria c = null;
		c = session.createCriteria(StorePoHeader.class);
		c=c.createAlias("Hospital","hospital").add(Restrictions.eq("hospital.Id", hospitalId));
		if ((Integer) searchMap.get("poId") != 0) {
			poId = (Integer) searchMap.get("poId");
			c = c.add(Restrictions.eq("Id", poId));
		}
		if ((Integer) searchMap.get("supplierId") != 0) {
			supplierId = (Integer) searchMap.get("supplierId");
			c = c.add(Restrictions.eq("Supplier.Id", supplierId));
		}

		if (!(searchMap.get("fromDate").equals(""))
				&& (!searchMap.get("toDate").equals(""))) {
			fromDate = (String) searchMap.get("fromDate");
			toDate = (String) searchMap.get("toDate");

			String date4MySQL1;
			String date4MySQL2;
			try {
				SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
				date4MySQL1 = formatterOut.format(formatterIn.parse(fromDate));
				date4MySQL2 = formatterOut.format(formatterIn.parse(toDate));
				Date startDate = Date.valueOf(date4MySQL1);
				Date endDate = Date.valueOf(date4MySQL2);

				c = c.add(Restrictions.between("PoDate", startDate, endDate));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		c = c.add(Restrictions.isNull("TenderM"));
		searchPoHeaderList = c.addOrder(Order.desc("Id")).list();

		if ((Integer) searchMap.get("departmentId") != 0) {
			departmentId = (Integer) searchMap.get("departmentId");
			searchPoHeaderList = session.createCriteria(StorePoHeader.class)
					.createAlias("Department","department").add(Restrictions.eq("department.Id", departmentId)).createAlias("Hospital","hospital").add(Restrictions.eq("hospital.Id", hospitalId)).list();
		}

		//map.put("searchPoDetailList", searchPoDetailList);
		map.put("searchSupplierList", searchSupplierList);
		map.put("searchPoHeaderList", searchPoHeaderList);

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> poModifyMap(int poId, int pageNo,String buttonFlag) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StorePoDetail> poDetailList = new ArrayList<StorePoDetail>();
		List<StorePoHeader> poHeaderList = new ArrayList<StorePoHeader>();
		List<StoreGrnM> grnHeaderList = new ArrayList<StoreGrnM>();
		List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
		List<MasItemCategory>masItemCategory=new ArrayList<MasItemCategory>();
		int totalPages = 1;
		int firstResult = 0;
		int maxResults = 10;
		String crvNo = "";

		if (pageNo != 0) {
			firstResult = firstResult + (pageNo - 1) * 10;
		}
		Session session = (Session) getSession();
		Criteria c = session.createCriteria(StorePoDetail.class).createAlias(
				"Po", "Po").add(Restrictions.eq("Po.Id", poId)).addOrder(Order.asc("SerialNo") );
		//c.setFirstResult(firstResult);
		//c.setMaxResults(maxResults);
		poDetailList = c.list();

		poHeaderList = session.createCriteria(StorePoHeader.class).add(
				Restrictions.eq("Id", poId)).list();
		grnHeaderList = session.createCriteria(StoreGrnM.class).add(
				Restrictions.eq("Po.Id", poId)).list();

		for (StoreGrnM storeGrnM : grnHeaderList) {
			crvNo = storeGrnM.getGrnNo();
		}
		BigDecimal currAmount = new BigDecimal("0");
		for (Iterator iterator = poDetailList.iterator(); iterator.hasNext();) {
			StorePoDetail storePoDetail = (StorePoDetail) iterator.next();

			currAmount = currAmount.add(storePoDetail.getAmount());
			Criteria c1 = session.createCriteria(MasStoreBrand.class)
					.createAlias("Item", "item").add(
							Restrictions.like("item.Id", storePoDetail
									.getItem().getId()));
			brandList = c1.list();
			map.put(storePoDetail.getItem().getId().toString(), brandList);
		}

		String str1 = "select count(*) from store_po_detail a,store_po_header b  where a.po_id=b.po_id and a.po_id= '"
				+ poId + "'";
		List itemList = session.createSQLQuery(str1).list();
		int totalitems = (Integer.parseInt("" + itemList.get(0)));
		if (itemList.size() > 0 && itemList != null) {

			totalPages = ((Integer.parseInt("" + itemList.get(0))) / 10) + 1;
		}

		masItemCategory=session.createCriteria(MasItemCategory.class).add(
				Restrictions.eq("Status", "y")).list();

		map.put("poDetailList", poDetailList);
		map.put("poHeaderList", poHeaderList);
		map.put("totalPages", totalPages);
		map.put("currAmount", currAmount);
		map.put("grnHeaderList", grnHeaderList.size());
		map.put("crvNo", crvNo);
		map.put("masItemCategory", masItemCategory);
		return map;
	}

	@SuppressWarnings("unchecked")
	public List<StorePoDetail> getPoDetailListForMoreInfoPurchase(int poDetailId) {
		Session session = (Session) getSession();
		List<StorePoDetail> poDetailMoreInfoList = session.createCriteria(
				StorePoDetail.class).add(Restrictions.eq("Id", poDetailId))
				.list();
		return poDetailMoreInfoList;
	}

	@SuppressWarnings( { "unchecked", "unused", "unchecked" })
	public boolean updatePurchaseOrder(Map<String, Object> infoMap) {
		boolean successfullyAdded = false;
		StorePoHeader storePoHeader = null;
		int pageNo = 0;
		int poId = 0;
		List<StorePoDetail> poDetailList = new ArrayList<StorePoDetail>();
		List<StorePoDetail> poDetailListAdd = new ArrayList<StorePoDetail>();

		if (infoMap.get("pageNo") != null) {
			pageNo = Integer.parseInt("" + infoMap.get("pageNo"));
		}
		if (infoMap.get("poId") != null) {
			poId = Integer.parseInt("" + infoMap.get("poId"));
		}

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {

			storePoHeader = (StorePoHeader) infoMap.get("storePoHeader");
			hbt.update(storePoHeader);

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {

			if (infoMap.get("poDetailList") != null) {
				poDetailList = (List<StorePoDetail>) infoMap
						.get("poDetailList");
				if (poDetailList.size() > 0) {
					for (int i = 0; i < poDetailList.size(); i++) {
						StorePoDetail storePoDetail = new StorePoDetail();
						storePoDetail = (StorePoDetail) poDetailList.get(i);
						hbt.update(storePoDetail);
					}
				}
				successfullyAdded = true;
			}
			if (infoMap.get("poDetailListAdd") != null) {
				poDetailListAdd = (List<StorePoDetail>) infoMap
						.get("poDetailListAdd");
				BigDecimal Amount = new BigDecimal("0");
				if (poDetailListAdd.size() > 0) {
					for (int i = 0; i < poDetailListAdd.size(); i++) {
						StorePoDetail storePoDetail = (StorePoDetail) poDetailListAdd
								.get(i);
						hbt.save(storePoDetail);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public List<MasAuthorizer> getApprovalAuthoritiesList() {
		List<MasAuthorizer> authorityList = new ArrayList<MasAuthorizer>();
		Session session = (Session) getSession();

		authorityList = session.createCriteria(MasAuthorizer.class).list();
		return authorityList;
	}

	@SuppressWarnings("deprecation")
	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> connectionMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		connectionMap.put("con", con);
		return connectionMap;
	}

	@SuppressWarnings("unchecked")
	public boolean submitApprovalAuthority(String approvalIds, int poId) {
		boolean flag = false;

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (poId != 0) {
			List<StorePoHeader> list = hbt
					.find("from jkt.hms.masters.business.StorePoHeader as sph where sph.Id = '"
							+ poId + "'");

			if (!approvalIds.equals("")) {
				List<MasAuthorizer> authorizerList = hbt
						.find("from jkt.hms.masters.business.MasAuthorizer as ma where ma.Id IN ( "
								+ approvalIds + ")");
				List<MasAuthorizer> unAuthorizerList = hbt
						.find("from jkt.hms.masters.business.MasAuthorizer as ma where ma.Id NOT IN ( "
								+ approvalIds + ")");

				for (MasAuthorizer masAuthorizer1 : authorizerList) {
					masAuthorizer1.setStatus("y");
					hbt.update(masAuthorizer1);
				}
				for (MasAuthorizer masAuthorizer2 : unAuthorizerList) {
					masAuthorizer2.setStatus("n");
					hbt.update(masAuthorizer2);
				}

				if (list.size() > 0) {
					StorePoHeader storePoHeader = (StorePoHeader) list.get(0);
					storePoHeader.setApprovalAuthority(approvalIds);
					hbt.update(storePoHeader);
					flag = true;
				}
			} else {
				List<MasAuthorizer> allAuthorizerList = hbt
						.find("from jkt.hms.masters.business.MasAuthorizer as ma");
				for (MasAuthorizer masAuthorizer : allAuthorizerList) {
					masAuthorizer.setStatus("n");
					hbt.update(masAuthorizer);
				}
				if (list.size() > 0) {
					StorePoHeader storePoHeader = (StorePoHeader) list.get(0);
					storePoHeader.setApprovalAuthority("0");
					hbt.update(storePoHeader);
					flag = true;
				}
			}
		} else {
			flag = false;
		}
		return flag;
	}

	@SuppressWarnings("unchecked")
	public List<MasStoreSupplier> getSupplierList() {
		Session session = (Session) getSession();
		List<MasStoreSupplier> supplierList = session.createCriteria(
				MasStoreSupplier.class).add(Restrictions.eq("Status", "y"))
				.list();
		return supplierList;
	}

	public Map<String, Object> getStockDetails(Map<String, Object> costMap) {
		Map<String, Object> stockMap = new HashMap<String, Object>();
		float costPriceForAClass = 0f;
		float costPriceForBClass = 0f;
		if (costMap.get("costPriceForAClass") != null) {
			costPriceForAClass = (Float) costMap.get("costPriceForAClass");
		}
		if (costMap.get("costPriceForBClass") != null) {
			costPriceForBClass = (Float) costMap.get("costPriceForBClass");
		}
		Session session = (Session) getSession();
		List<StoreItemBatchStock> sumList = session
				.createQuery(
						"select sum(ss.ClosingStock*ss.CostPrice) from StoreItemBatchStock as ss")
				.list();
		float sumOfStock = Float.valueOf(sumList.toString().substring(1,
				sumList.toString().length() - 1));

		// float sumOfStock = Float.parseFloat(sum);
		/*
		 * for (StoreItemBatchStock storeItemBatchStock : sumList) {
		 */
		/*
		 * float sumOfStock = Float.v(sumList.get(0));
		 */
		stockMap.put("sumOfStock", sumOfStock);

		return stockMap;
	}

	@SuppressWarnings( { "unused", "unchecked" })
	public Map<String, Object> getStoreSetUpDetails() {
		Map<String, Object> classMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<StoreSetup> classList = session.createCriteria(StoreSetup.class)
				.list();
		classMap.put("classList", classList);
		return classMap;
	}

	@SuppressWarnings("unchecked")
	public List<MasStorePoDeliveryTerms> getPaymentDetails() {
		List<MasStorePoDeliveryTerms> paymentDetailsList = new ArrayList<MasStorePoDeliveryTerms>();

		Session session = (Session) getSession();
		paymentDetailsList = session.createCriteria(
				MasStorePoDeliveryTerms.class).add(
				Restrictions.eq("Status", "y")).add(
				Restrictions.eq("PoDeliveryTermsName", "Payment")).list();
		return paymentDetailsList;
	}

	@SuppressWarnings("unchecked")
	public List<MasStorePoDeliveryTerms> getDeliveryDetails() {
		List<MasStorePoDeliveryTerms> deliveryDetailsList = new ArrayList<MasStorePoDeliveryTerms>();

		Session session = (Session) getSession();
		deliveryDetailsList = session.createCriteria(
				MasStorePoDeliveryTerms.class).add(
				Restrictions.eq("Status", "y")).add(
				Restrictions.eq("PoDeliveryTermsName", "Delivery")).list();
		return deliveryDetailsList;
	}

	@SuppressWarnings("unchecked")
	public List<MasStorePoDeliveryTerms> getDescriptionForDeliveryTermId(
			int poDeliveryTermId) {
		List<MasStorePoDeliveryTerms> detailsList = new ArrayList<MasStorePoDeliveryTerms>();
		Session session = (Session) getSession();
		detailsList = session.createCriteria(MasStorePoDeliveryTerms.class)
				.add(Restrictions.eq("Status", "y")).add(
						Restrictions.eq("Id", poDeliveryTermId)).list();
		return detailsList;
	}

	@SuppressWarnings("unchecked")
	public String getHospitalName(int hospitalId) {
		Session session = (Session) getSession();
		String hospitalName = "";
		List<MasHospital> list = session.createCriteria(MasHospital.class).add(
				Restrictions.eq("Status", "y")).add(
				Restrictions.eq("Id", hospitalId)).list();
		if (list != null && list.size() > 0) {
			MasHospital obj = (MasHospital) list.get(0);
			hospitalName = obj.getHospitalName();
		}
		return hospitalName;
	}
// javed khan
	public String getHospitalAddress(int hospitalId) {
		Session session = (Session) getSession();
		String hospitalAddress= "";
		List<MasHospital> list = session.createCriteria(MasHospital.class).add(
				Restrictions.eq("Status", "y")).add(
				Restrictions.eq("Id", hospitalId)).list();
		if (list != null && list.size() > 0) {
			MasHospital obj = (MasHospital) list.get(0);
			hospitalAddress = obj.getAddress();
		}
		return hospitalAddress;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getItemListForPurchaseOrder(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List<MasStoreItem> itemList1 = new ArrayList<MasStoreItem>();
		List objectList = new ArrayList();
		int hospitalId=0;
		Session session = (Session) getSession();
		int deptId = 0;
		int poId = 0;

		hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		deptId = Integer.parseInt("" + dataMap.get("deptId"));
		poId = Integer.parseInt("" + dataMap.get("poId"));
		try {
			String str =dataMap.get("autoHint").toString();
			str=str.toUpperCase()+ "%";
			/*String qry1 = "SELECT t.item_id FROM store_po_detail t,store_po_header m where t.po_detail_id='"
					+ poId + "' and m.po_id=t.po_detail_id ";
			objectList = (List) session.createSQLQuery(qry1).list();
			if (objectList.size() != 0) {
				Criteria c = session.createCriteria(MasStoreItem.class).add(
						Restrictions.like("Nomenclature", str)).add(
						Restrictions.eq("Department.Id", deptId)).add(
						Restrictions.not(Restrictions.in("Id", objectList)));
				c.setFirstResult(0);
				c.setMaxResults(10);
				itemList = c.list();

			if (objectList.size() != 0) {
				List<BigDecimal> objectNewList = new ArrayList<BigDecimal>();
				String sql="";
				for (int i=0;i<objectList.size();i++) {
					if(i==0){
						sql=""+objectList.get(i);
					}else{
						sql=sql+" , "+objectList.get(i);
					}
				}
				if(sql!="")

				{
					itemList=getHibernateTemplate().find("select item from jkt.hms.masters.business.MasStoreItem as item where upper(item.Nomenclature) like '"+str+"'  and item.ItemType.Id='2' and item.Hospital.Id='"+hospitalId+"'  and item.Id not in("+sql+") and rownum < 15");
					itemList1=getHibernateTemplate().find("select item from jkt.hms.masters.business.MasStoreItem as item where upper(item.Nomenclature) like '"+str+"' and item.ItemType.Id='1'  and item.Id not in("+sql+") and rownum < 15");
					itemList.addAll(itemList1);

				}else{
					itemList=getHibernateTemplate().find("select item from jkt.hms.masters.business.MasStoreItem as item where upper(item.Nomenclature) like '"+str+"'  and item.ItemType.Id='2' and item.Hospital.Id='"+hospitalId+"'");
					itemList1=getHibernateTemplate().find("select item from jkt.hms.masters.business.MasStoreItem as item where upper(item.Nomenclature) like '"+str+"' and item.ItemType.Id='1'");
					itemList.addAll(itemList1);
				}
			} else {
				Criteria c = session.createCriteria(MasStoreItem.class).add(
						Restrictions.like("Nomenclature", str).ignoreCase()).add(
						Restrictions.eq("Department.Id", deptId))
						.add(Restrictions.eq("Status", "y"));
				c.setFirstResult(0);
				c.setMaxResults(10);
				itemList = c.list();



				itemList=getHibernateTemplate().find("select item from jkt.hms.masters.business.MasStoreItem as item where upper(item.Nomenclature) like '"+str+"' and item.Status='y'  and item.ItemType.Id='2' and item.Hospital.Id='"+hospitalId+"'");
				itemList1=getHibernateTemplate().find("select item from jkt.hms.masters.business.MasStoreItem as item where upper(item.Nomenclature) like '"+str+"' and item.Status='y' and item.ItemType.Id='1'");

				itemList.addAll(itemList1);

			}*/
			
			itemList=getHibernateTemplate().find("select item from jkt.hms.masters.business.MasStoreItem as item where upper(item.Nomenclature) like '"+str+"' and status='y' and item_classification_id=1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("itemList", itemList);
		return map;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> getItemListForPurchaseOrderForRC(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List<MasStoreItem> itemList1 = new ArrayList<MasStoreItem>();
		List objectList = new ArrayList();
		int hospitalId=0;
		Session session = (Session) getSession();
		int deptId = 0;
		int poId = 0;

		hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		deptId = Integer.parseInt("" + dataMap.get("deptId"));
		poId = Integer.parseInt("" + dataMap.get("poId"));
		try {
			String str =dataMap.get("autoHint").toString();
			str=str.toUpperCase()+ "%";
		
			
			itemList=getHibernateTemplate().find("select item from jkt.hms.masters.business.MasStoreItem as item where upper(item.Nomenclature) like '"+str+"' and status='y' ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("itemList", itemList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public String getnextPurchaseOrder(String poNumber, int departmentId) {
		String po_number = "";
		int poId = 0;
		List<StorePoHeader> list = new ArrayList<StorePoHeader>();
		Session session = (Session) getSession();
		list = session.createCriteria(StorePoHeader.class).add(
				Restrictions.eq("Status", "o")).add(
				Restrictions.eq("PoNumber", poNumber)).list();
		for (StorePoHeader storePoHeader : list) {
			poId = Integer.parseInt("" + storePoHeader.getId());
		}
		String no = "";
		if (poId != 0) {
			List<StoreFyDocumentNo> fycheckList = session.createCriteria(
					StoreFyDocumentNo.class).add(
					Restrictions.eq("Department.Id", departmentId)).list();
			if (fycheckList != null && fycheckList.size() > 0) {
				StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) fycheckList
						.get(0);
				// storeFyDocumentNo.setPoNo(poNumber);
				no = ("" + storeFyDocumentNo.getPoNo());
			}
		}
		return getMaxNo(no);
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> deletePurchaseOrderItem(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		String po_number = "";
		int poId = 0;
		boolean deletion = false;
		List<StorePoHeader> sPHList = new ArrayList<StorePoHeader>();
		List<StorePoDetail> sPDList = new ArrayList<StorePoDetail>();
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Vector deleteItem = box.getVector("deleteItem");
		int po_id = box.getInt("poId");
		BigDecimal netAmount = new BigDecimal("0");
		Transaction transaction = null;
		session.beginTransaction();
		try {
			String detail = "";
			for (int i = 0; i < deleteItem.size(); i++) {
				if (!(deleteItem.get(i).toString()).equals("")) {
					int DetailId = Integer.parseInt(deleteItem.get(i)
							.toString());

					if (detail.length() == 0) {
						detail = detail + DetailId;
					} else {
						detail = detail + "," + DetailId;
					}
				}
			}
			if (detail.length() > 0) {
				String hql = "delete from jkt.hms.masters.business.StorePoDetail as a where a.Id in ("
						+ detail + ")";
				Query query1 = session.createQuery(hql);
				int row = query1.executeUpdate();

				sPDList = session.createCriteria(StorePoDetail.class).add(
						Restrictions.eq("Po.Id", po_id)).list();
				if (sPDList != null && sPDList.size() > 0) {
					int i = 1;
					for (StorePoDetail spd : sPDList) {
						StorePoDetail storePodetail = (StorePoDetail) getHibernateTemplate()
								.load(StorePoDetail.class, spd.getId());
						storePodetail.setSerialNo(i);
						netAmount = netAmount.add(storePodetail.getAmount());
						hbt.update(storePodetail);
						hbt.refresh(storePodetail);
						i++;
					}
				}
				StorePoHeader storePoHeader = (StorePoHeader) getHibernateTemplate()
						.load(StorePoHeader.class, po_id);
				storePoHeader.setNetAmount(netAmount);
				hbt.update(storePoHeader);
				hbt.refresh(storePoHeader);
				deletion = true;
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		}
		map.put("deletion", deletion);
		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean cancelLso(Box box) {
		boolean flag = false;

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		int poId = box.getInt("poId");
		Vector poDetailIds = box.getVector("poDetailsId");
		BigDecimal subQty = new BigDecimal(0);
		double subTotal = 0.0;
		StorePoDetail storePoDetail = null ;
		if (poId != 0) {
			for(int i=0 ; i<poDetailIds.size();i++){
				int poDetailId = Integer.parseInt((String)poDetailIds.get(i));
				storePoDetail = (StorePoDetail)hbt.load(StorePoDetail.class,poDetailId );
				subQty.add(storePoDetail.getAmount());
				subTotal +=storePoDetail.getAmount().doubleValue();
				storePoDetail.setCancelled("y");
				hbt.merge(storePoDetail);

			}
			StorePoHeader storePoHeader = (StorePoHeader) getHibernateTemplate().load(StorePoHeader.class, poId);
			BigDecimal balanceQty = storePoHeader.getNetAmount().subtract(new BigDecimal(subTotal));
			storePoHeader.setNetAmount(balanceQty);
			if(balanceQty.equals(new BigDecimal(0)))
			storePoHeader.setStatus("c");
			hbt.merge(storePoHeader);
			hbt.refresh(storePoHeader);
			hbt.flush();
			flag=true;
		} else {
			flag = false;
		}
		return flag;
	}

	@SuppressWarnings("unchecked")
	public String getPoNumber(int poId) {
		Session session = (Session) getSession();
		String poNumber = "";
		StorePoHeader storePoHeader = (StorePoHeader) getHibernateTemplate()
				.load(StorePoHeader.class, poId);
		if (storePoHeader != null) {
			poNumber = storePoHeader.getPoNumber();
		}
		return poNumber;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getCurVendorSoAmount(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<StorePoHeader> storePoRemain = new ArrayList<StorePoHeader>();
		int venderId = (Integer) dataMap.get("vendorId");
		String soDate = (String) dataMap.get("soDate");
		int deptId = (Integer) dataMap.get("deptId");
		Map dateMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) dateMap.get("currentDate");
		Criteria c = null;
		c = session.createCriteria(StorePoHeader.class).add(
				Restrictions.eq("Department.Id", deptId)).add(
				Restrictions.eq("Supplier.Id", venderId));
		if (soDate != null) {
			c = c.add(Restrictions.eq("PoDate", HMSUtil
					.convertStringTypeDateToDateType(soDate)));
		} else {
			c = c.add(Restrictions.eq("PoDate", HMSUtil
					.convertStringTypeDateToDateType(date)));
		}
		storePoRemain = c.list();
		BigDecimal remain = new BigDecimal("0");
		for (StorePoHeader Remain : storePoRemain) {
			if(Remain.getNetAmount()!=null){
			remain = remain.add(Remain.getNetAmount());
			}
		}
		map.put("remain", remain);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getBudgetDetails(Box box) {
		// TODO Auto-generated method stub
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreBudgetT> storeBudTList = new ArrayList<MasStoreBudgetT>();
		List<MasStoreBudget> storeBudList = new ArrayList<MasStoreBudget>();
		int mId = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String fromDate = "";
		String toDate = "";
		storeBudList = session.createCriteria(MasStoreBudget.class).add(
				Restrictions.ge("LastChgDate", HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("fromDate")))).addOrder(
				Order.asc("Id")).list();

		if (storeBudList.size() > 0) {
			MasStoreBudget bud = (MasStoreBudget) storeBudList.get(0);
			mId = bud.getId();
		}
		fromDate = sdf.format(HMSUtil.convertStringTypeDateToDateType(box
				.getString("fromDate")));
		toDate = sdf.format(HMSUtil.convertStringTypeDateToDateType(box
				.getString("toDate")));

		storeBudTList = session.createCriteria(MasStoreBudgetT.class).add(
				Restrictions.eq("Budget.Id", mId)).add(
				Restrictions.le("AddedDate", HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("toDate")))).list();

		BigDecimal allotAmt = new BigDecimal("0");
		BigDecimal soBalance = new BigDecimal("0");
		BigDecimal crvBalance = new BigDecimal("0");
		BigDecimal crvDone = new BigDecimal("0");
		int soPendingNo = 0;
		BigDecimal soPendingAmt = new BigDecimal("0");
		BigDecimal pendngLATAmt = new BigDecimal("0");

		for (MasStoreBudgetT budt : storeBudTList) {
			allotAmt = allotAmt.add(budt.getBudgetedAmount());
		}
		String PLAT = "select count(grn_master_id) from store_grn_m where grn_date between '"
				+ fromDate
				+ "' and  '"
				+ toDate
				+ "'"
				+ " and department_id = '"
				+ box.getInt("deptId")
				+ "' and (status = 'o' or grn_master_id in (select grn_master_id from store_grn_m "
				+ " where status = 'v' and  grn_date between '"
				+ fromDate
				+ "' and '"
				+ toDate
				+ "' "
				+ " and last_chg_date > '"
				+ toDate
				+ "' and department_id = '" + box.getInt("deptId") + "'))";
		int pendingLAT = Integer.parseInt(session.createSQLQuery(PLAT).list()
				.get(0).toString());

		String PLATAMT = "select ifnull(sum(invoice_amount),0) from store_grn_m where grn_date between '"
				+ fromDate
				+ "' and  '"
				+ toDate
				+ "'"
				+ " and department_id = '"
				+ box.getInt("deptId")
				+ "' and (status = 'o' or grn_master_id in (select grn_master_id from store_grn_m "
				+ " where status = 'v' and  grn_date between '"
				+ fromDate
				+ "' and '"
				+ toDate
				+ "' "
				+ " and last_chg_date > '"
				+ toDate
				+ "' and department_id = '" + box.getInt("deptId") + "'))";

		pendngLATAmt = new BigDecimal(session.createSQLQuery(PLATAMT).list()
				.get(0).toString());

		String SOP = "select ifnull(sum(net_amount),0) from store_po_header where "
				+ " po_date between '"
				+ fromDate
				+ "' and '"
				+ toDate
				+ "' and status != 'c' and department_id = '"
				+ box.getInt("deptId") + "'";

		BigDecimal soPlaced = new BigDecimal(session.createSQLQuery(SOP).list()
				.get(0).toString());

		soBalance = allotAmt.subtract(soPlaced);

		String CRVA = "select ifnull(sum(invoice_amount),0) from store_grn_m where receive_type = 'l' and +"
				+ " grn_date between '"
				+ fromDate
				+ "' and  '"
				+ toDate
				+ "' and department_id = '" + box.getInt("deptId") + "'";
		BigDecimal crvAmt = new BigDecimal(session.createSQLQuery(CRVA).list()
				.get(0).toString());

		String crvD = "select ifnull(sum(invoice_amount),0) from store_grn_m where grn_date between '"
				+ fromDate
				+ "' and  '"
				+ toDate
				+ "'"
				+ " and status = 'v' and last_chg_date <= '2009-11-06' and department_id = '"
				+ box.getInt("deptId") + "'";

		crvDone = new BigDecimal(session.createSQLQuery(crvD).list().get(0)
				.toString());

		crvBalance = allotAmt.subtract(crvAmt);

		/*
		 * String soPA =
		 * "select sum(net_amount) from store_po_header where po_date between '"
		 * +fromDate+"' and '"+toDate+"' " +
		 * " and department_id = '"+box.getInt("deptId")+"' and status = 'o' ";
		 */

		// soPendingAmt = new
		// BigDecimal(session.createSQLQuery(soPA).list().get(0).toString());
		soPendingAmt = soPlaced.subtract(crvAmt);
		String soPN = "select count(po_id) from store_po_header where po_date between '"
				+ fromDate
				+ "' and '"
				+ toDate
				+ "' "
				+ " and department_id = '"
				+ box.getInt("deptId")
				+ "' and status = 'o' ";

		soPendingNo = Integer.parseInt(session.createSQLQuery(soPN).list().get(
				0).toString());

		map.put("fromDate", fromDate);
		map.put("allotAmt", allotAmt);
		map.put("pendingLAT", pendingLAT);
		map.put("soPlaced", soPlaced);
		map.put("soBalance", soBalance);
		map.put("crvAmt", crvAmt);
		map.put("crvBalance", crvBalance);
		map.put("crvDone", crvDone);
		map.put("soPendingAmt", soPendingAmt);
		map.put("soPendingNo", soPendingNo);
		map.put("pendngLATAmt", pendngLATAmt);

		return map;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getpendingLATList(Box box) {
		// TODO Auto-generated method stub
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String fromDate = "";
		String toDate = "";
		fromDate = sdf.format(HMSUtil.convertStringTypeDateToDateType(box
				.getString("fromDate")));
		toDate = sdf.format(HMSUtil.convertStringTypeDateToDateType(box
				.getString("toDate")));
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		String PLAT = "select grn_master_id from store_grn_m where grn_date between '"
				+ fromDate
				+ "' and  '"
				+ toDate
				+ "'"
				+ " and department_id = '"
				+ box.getInt("deptId")
				+ "' and (status = 'o' or grn_master_id in (select grn_master_id from store_grn_m "
				+ " where status = 'v' and  grn_date between '"
				+ fromDate
				+ "' and '"
				+ toDate
				+ "' "
				+ " and last_chg_date > '"
				+ toDate
				+ "' and department_id = '" + box.getInt("deptId") + "'))";
		List objectList = (List) session.createSQLQuery(PLAT).list();

		ArrayList<StoreGrnM> storeGrnMList = new ArrayList<StoreGrnM>();

		for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
			Integer obj = (Integer) iterator.next();
			StoreGrnM storeGrnM = (StoreGrnM) hbt.load(StoreGrnM.class, obj);
			storeGrnMList.add(storeGrnM);
		}

		map.put("storeGrnMList", storeGrnMList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> pendingSOCRVList(Box box) {
		// TODO Auto-generated method stub
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String fromDate = "";
		String toDate = "";
		fromDate = sdf.format(HMSUtil.convertStringTypeDateToDateType(box
				.getString("fromDate")));
		toDate = sdf.format(HMSUtil.convertStringTypeDateToDateType(box
				.getString("toDate")));
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		/*String PSO ="select a.po_number, a.po_date, d.pvms_no, d.nomenclature, f.unit_name,a.net_amount , b.quantity_ordered, " +
				" ifnull(b.quantity_received,0) quantity_received,  (b.quantity_ordered - ifnull(b.quantity_received,0)) quantity_pending, " +
				" concat(c.supplier_name,' [',c.supplier_code,']') supplier_name, concat('Distributor: ',c.cf_local_distributor_name) cf_local_distributor_name, c.cf_local_distributor_address1, c.cf_local_distributor_address2 " +
				" ,case when a.status = 'c' then '[Cancelled]' else '' end as status " +
				" from store_po_header a, store_po_detail b, mas_store_supplier c, mas_store_item d, mas_store_item_conversion e, mas_store_unit f " +
				" where a.po_id = b.po_id and a.supplier_id = c.supplier_id and b.item_id  = d.item_id " +
				" and d.item_conversion_id = e.item_conversion_id and e.purchase_unit_id = f.unit_id " +
				" and a.department_id = '" + box.getInt("deptId") + "' and a.po_date between '"+fromDate+"' AND '"+toDate+"' " +
				" and (b.quantity_ordered - ifnull(b.quantity_received,0)) !=0 order by a.po_number,a.po_date, d.pvms_no";
		*/
		String PSO = "select po_number , po_date , mss.supplier_name , net_amount " +
                     " from store_po_header sph left outer join mas_store_supplier mss on sph.supplier_id = mss.supplier_id " +
                     " where po_date between '"+fromDate+"' and '"+toDate+"' and department_id = '"+box.getInt("deptId")+"' and sph.status = 'o'";
		List objectList = (List) session.createSQLQuery(PSO).list();

		/*ArrayList<StoreGrnM> storeGrnMList = new ArrayList<StoreGrnM>();

		for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
			Integer obj = (Integer) iterator.next();
			StoreGrnM storeGrnM = (StoreGrnM) hbt.load(StoreGrnM.class, obj);
			storeGrnMList.add(storeGrnM);
		}*/

		map.put("objectList", objectList);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> getSupplyOrderNoAutocomplete(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StorePoHeader> soList = new ArrayList<StorePoHeader>();
		Session session = getSession();
		String autoHint = "";
		int deptId = 0;
		String itemNameField = box.getString("requiredField");
		autoHint = box.getString(itemNameField);
		deptId =  box.getInt("deptId");
		soList = session.createCriteria(StorePoHeader.class).add(Restrictions.like("PoNumber", autoHint+"%"))
					.createAlias("Department", "dept").add(Restrictions.eq("dept.Id", deptId))
					.add(Restrictions.ne("Status", "c")).add(Restrictions.ne("Status", "l")).list();


		map.put("soList", soList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getSODetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StorePoDetail> poDetailsList = new ArrayList<StorePoDetail>();
		Session session = getSession();
		String soNumber = "";
		soNumber = box.getString("soNumber");
		int deptId =  box.getInt("deptId");
		poDetailsList = session.createCriteria(StorePoDetail.class)
						.createAlias("Po", "po").add(Restrictions.eq("po.PoNumber", soNumber))
						.createAlias("po.Department", "dept").add(Restrictions.eq("dept.Id", deptId))
					.list();
		map.put("poDetailsList", poDetailsList);
		return map;
	}

	public Map<String, Object> closePOItem(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		int counter = box.getInt("counter");
		int poHdId =  box.getInt("poId");
		boolean flag = false;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Vector poDetailIdList = box.getVector("poDetailsId");
		int size = poDetailIdList.size();
		int poDetailIds = 0 ;
		StorePoDetail poDetail =null;
		try {
			for(int i=0 ; i<poDetailIdList.size();i++){
				poDetailIds = Integer.parseInt((String)poDetailIdList.get(i));
				poDetail = (StorePoDetail)hbt.load(StorePoDetail.class, poDetailIds);
				poDetail.setClosed("y");
				hbt.merge(poDetail);

			}
			hbt.flush();
			flag = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		map.put("flag", flag);
		return map;
	}



	public Map<String, Object> generateExcelToVendor(Map<String,Object> map)
	{
		String hospitalName = null;
	    int hospitalId=0;
	    int deptId=0;
		String deptName = null;
		String query="";
		String po_id="";
		List<MasStoreSupplier> supplierList=null;
		 Map<String, Object> dataMap = new HashMap<String, Object>();
		Session session = getSession();
	    List storeItmBatchList=new ArrayList();
		if(map.get("hospitalName") != null){
	    	hospitalName = (String)map.get("hospitalName");
	    }
	    if(map.get("hospitalId") != null){
	    	hospitalId = (Integer)map.get("hospitalId");
	    }
	    if(map.get("deptName") != null){
	    	deptName = (String)map.get("deptName");
	    }
	    if(map.get("deptId") != null){
	    	deptId = (Integer)map.get("deptId");
	    }
	    if(map.get("query") != null){
	    	query = (String)map.get("query");
	    }
	    if(map.get("po_id")!=null){
	    	po_id=(String)map.get("po_id");
	    }

	    //String qry="SELECT ('Brand:' || mas_store_brand.brand_name) AS brand_name,store_po_header.supplier_id AS header_supplier_id,mas_store_supplier.supplier_name AS supplier_supplier_name,mas_manufacturer.MANUFACTURER_NAME as manufacturer_name,store_po_header.po_date AS store_po_header_po_date,store_po_header.po_number AS store_po_header_po_no,mas_store_item.ITEM_ID AS item_id,mas_store_item.nomenclature AS mas_store_item_nomenclature,mas_store_item.BRANDED_GENERIC as BRANDED_GENERIC,store_po_detail.rate_per_mdq AS store_po_detail_unit_rate,store_po_detail.mrp AS mrp,store_po_detail.DISCOUNT_PERCENT AS discount_percent,store_po_detail.amount AS store_po_detail_amount,store_po_detail.DISP_TYPE AS store_po_detail_disp_type,store_po_detail.MDQ_VALUE as store_po_detail_mdq,store_po_detail.LSO_QTY as store_po_detail_lso_qty,store_po_detail.TAX_OQ as store_po_detail_tax_oq,mas_store_unit.unit_name AS conversion_item_unit_name,store_po_header.delivery_date AS store_po_header_delivery_date,store_po_header.quotation_number AS quotation_number,store_po_header.quotation_date AS quotation_date,store_po_header.approval_authority AS approval_authority,store_po_detail.quantity_ordered AS quantity_ordered,round(store_po_header.net_amount, 2) AS header_net_amount,store_po_header.delivery_date AS store_po_header_delivery_date,store_po_header.po_date AS po_date,store_po_header.remarks as remarks FROM store_po_header store_po_header left outer join  store_po_detail store_po_detail ON store_po_header.po_id = store_po_detail.po_id LEFT OUTER JOIN mas_store_supplier mas_store_supplier ON store_po_header.supplier_id = mas_store_supplier.supplier_id LEFT OUTER JOIN mas_store_item mas_store_item ON store_po_detail.item_id = mas_store_item.item_id LEFT OUTER JOIN mas_district mas_district ON mas_store_supplier.local_city = mas_district.district_id LEFT OUTER JOIN mas_store_item_conversion mas_store_item_conversion ON mas_store_item.item_conversion_id = mas_store_item_conversion.item_conversion_id left outer join  mas_manufacturer mas_manufacturer on mas_store_item.MANUFACTURER_ID=mas_manufacturer.MANUFACTURER_ID LEFT OUTER JOIN mas_store_unit mas_store_unit ON mas_store_item_conversion.purchase_unit_id = mas_store_unit.unit_id LEFT OUTER JOIN mas_store_unit mas_store_unit_in ON mas_store_item_conversion.intermediate_unit_id = mas_store_unit_in.unit_id LEFT OUTER JOIN mas_store_brand mas_store_brand ON store_po_detail.brand_id = mas_store_brand.brand_id WHERE store_po_header.po_number ='"+po_id+"' and store_po_header.department_id ='24' and store_po_detail.cancelled IS NULL and mas_store_item.item_conversion_id = mas_store_item_conversion.item_conversion_id";
	  //in down previos query
	 //  String qry="SELECT mas_store_brand.brand_name AS brand_name,store_po_header.supplier_id AS header_supplier_id,mas_store_supplier.supplier_name AS supplier_supplier_name,mas_manufacturer.MANUFACTURER_NAME as manufacturer_name,store_po_header.po_date AS store_po_header_po_date,store_po_header.po_number AS store_po_header_po_no,mas_store_item.ITEM_ID AS item_id,mas_store_item.nomenclature AS mas_store_item_nomenclature,mas_store_item.BRANDED_GENERIC as BRANDED_GENERIC,store_po_detail.rate_per_mdq AS store_po_detail_unit_rate,store_po_detail.mrp AS mrp,store_po_detail.DISCOUNT_PERCENT AS discount_percent,store_po_detail.amount AS store_po_detail_amount,store_po_detail.DISP_TYPE AS store_po_detail_disp_type,store_po_detail.MDQ_VALUE as store_po_detail_mdq,store_po_detail.LSO_QTY as store_po_detail_lso_qty,store_po_detail.TAX_OQ as store_po_detail_tax_oq,mas_store_unit.unit_name AS conversion_item_unit_name,store_po_header.delivery_date AS store_po_header_delivery_date,store_po_header.quotation_number AS quotation_number,store_po_header.quotation_date AS quotation_date,store_po_header.approval_authority AS approval_authority,store_po_detail.quantity_ordered AS quantity_ordered,round(store_po_header.net_amount, 2) AS header_net_amount,store_po_header.delivery_date AS store_po_header_delivery_date,store_po_header.po_date AS po_date,store_po_header.remarks as remarks FROM store_po_header store_po_header left outer join  store_po_detail store_po_detail ON store_po_header.po_id = store_po_detail.po_id LEFT OUTER JOIN mas_store_supplier mas_store_supplier ON store_po_header.supplier_id = mas_store_supplier.supplier_id LEFT OUTER JOIN mas_store_item mas_store_item ON store_po_detail.item_id = mas_store_item.item_id LEFT OUTER JOIN mas_district mas_district ON mas_store_supplier.local_city = mas_district.district_id LEFT OUTER JOIN mas_store_item_conversion mas_store_item_conversion ON mas_store_item.item_conversion_id = mas_store_item_conversion.item_conversion_id left outer join  mas_manufacturer mas_manufacturer on store_po_detail.MANUFACTURER_ID=mas_manufacturer.MANUFACTURER_ID LEFT OUTER JOIN mas_store_unit mas_store_unit ON mas_store_item_conversion.purchase_unit_id = mas_store_unit.unit_id LEFT OUTER JOIN mas_store_unit mas_store_unit_in ON mas_store_item_conversion.intermediate_unit_id = mas_store_unit_in.unit_id LEFT OUTER JOIN mas_store_brand mas_store_brand ON store_po_detail.brand_id = mas_store_brand.brand_id WHERE store_po_header.po_number ='"+po_id+"' and store_po_header.department_id ='"+deptId+"' and store_po_header.HOSPITAL_ID='"+hospitalId+"' and store_po_detail.cancelled IS NULL and mas_store_item.item_conversion_id = mas_store_item_conversion.item_conversion_id order by mas_store_item.NOMENCLATURE";

	   String qry="SELECT mas_store_brand.brand_name AS brand_name,store_po_header.supplier_id AS header_supplier_id,mas_store_supplier.supplier_name AS supplier_supplier_name,mas_manufacturer.MANUFACTURER_NAME as manufacturer_name,store_po_header.po_date AS store_po_header_po_date,store_po_header.po_number AS store_po_header_po_no,mas_store_item.ITEM_ID AS item_id,mas_store_item.nomenclature AS mas_store_item_nomenclature,mas_store_item.BRANDED_GENERIC as BRANDED_GENERIC,store_po_detail.rate_per_mdq AS store_po_detail_unit_rate,store_po_detail.mrp AS mrp,store_po_detail.DISCOUNT_PERCENT AS discount_percent,store_po_detail.amount AS store_po_detail_amount,store_po_detail.DISP_TYPE AS store_po_detail_disp_type,store_po_detail.MDQ_VALUE as store_po_detail_mdq,sum(store_po_detail.LSO_QTY) as store_po_detail_lso_qty,store_po_detail.TAX_OQ as store_po_detail_tax_oq,mas_store_unit.unit_name AS conversion_item_unit_name,store_po_header.delivery_date AS store_po_header_delivery_date,store_po_header.quotation_number AS quotation_number,store_po_header.quotation_date AS quotation_date,store_po_header.approval_authority AS approval_authority,sum(store_po_detail.quantity_ordered) AS quantity_ordered,round(store_po_header.net_amount, 2) AS header_net_amount,store_po_header.delivery_date AS store_po_header_delivery_date,store_po_header.po_date AS po_date,store_po_header.remarks as remarks,store_po_detail.BRANDED_GENERIC AS BG FROM store_po_header store_po_header left outer join  store_po_detail store_po_detail ON store_po_header.po_id = store_po_detail.po_id  LEFT OUTER JOIN mas_store_supplier mas_store_supplier ON store_po_header.supplier_id = mas_store_supplier.supplier_id  LEFT OUTER JOIN mas_store_item mas_store_item ON store_po_detail.item_id = mas_store_item.item_id LEFT OUTER JOIN mas_district mas_district ON mas_store_supplier.local_city = mas_district.district_id  LEFT OUTER JOIN mas_store_item_conversion mas_store_item_conversion ON mas_store_item.item_conversion_id = mas_store_item_conversion.item_conversion_id  left outer join  mas_manufacturer mas_manufacturer on store_po_detail.MANUFACTURER_ID=mas_manufacturer.MANUFACTURER_ID  LEFT OUTER JOIN mas_store_unit mas_store_unit ON mas_store_item_conversion.purchase_unit_id = mas_store_unit.unit_id  LEFT OUTER JOIN mas_store_unit mas_store_unit_in ON mas_store_item_conversion.intermediate_unit_id = mas_store_unit_in.unit_id LEFT OUTER JOIN mas_store_brand mas_store_brand ON store_po_detail.brand_id = mas_store_brand.brand_id WHERE store_po_header.po_number ='"+po_id+"' and store_po_header.department_id ='"+deptId+"' and store_po_header.HOSPITAL_ID='"+hospitalId+"' and store_po_detail.cancelled IS NULL and mas_store_item.item_conversion_id = mas_store_item_conversion.item_conversion_id group by mas_store_brand.brand_name ,store_po_header.supplier_id ,mas_store_supplier.supplier_name ,mas_manufacturer.MANUFACTURER_NAME ,store_po_header.po_date ,store_po_header.po_number,mas_store_item.ITEM_ID ,mas_store_item.nomenclature ,mas_store_item.BRANDED_GENERIC ,store_po_detail.rate_per_mdq ,store_po_detail.mrp ,store_po_detail.DISCOUNT_PERCENT ,store_po_detail.amount ,store_po_detail.DISP_TYPE ,store_po_detail.MDQ_VALUE ,store_po_detail.TAX_OQ ,mas_store_unit.unit_name ,store_po_header.delivery_date ,store_po_header.quotation_number ,store_po_header.quotation_date ,store_po_header.approval_authority ,store_po_header.delivery_date ,store_po_header.po_date ,store_po_header.remarks,store_po_header.net_amount,store_po_detail.BRANDED_GENERIC order by mas_store_item.NOMENCLATURE";

	    storeItmBatchList=session.createSQLQuery(qry).list();
	    Iterator itr=storeItmBatchList.iterator();
	    Iterator iter=storeItmBatchList.iterator();
       try
       {

			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet("Supply Order for Vendor");
			//sheet.setColumnWidth((short) 1, (short)10);
			// Create a new font and alter it.

			HSSFFont font = wb.createFont();
			font.setFontHeightInPoints((short) 10);
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setColor((short) 80);
			font.setItalic(false);
			font.setStrikeout(false);
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

			HSSFFont font1 = wb.createFont();
			font1.setFontHeightInPoints((short) 12);
			font1.setFontName(HSSFFont.FONT_ARIAL);
			font1.setColor((short) 80);
			font1.setItalic(false);
			font1.setStrikeout(false);
			font1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

			HSSFFont font2 = wb.createFont();
			font2.setFontHeightInPoints((short) 9);
			font2.setFontName(HSSFFont.FONT_ARIAL);
			font2.setColor((short) 80);
			font2.setItalic(false);
			font2.setStrikeout(false);
			font2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

			// Fonts are set into a style so create a new one to
			// use.
			HSSFCellStyle style = wb.createCellStyle();
			style.setFont(font);
			style.setAlignment((short) 2);


			HSSFCellStyle style1 = wb.createCellStyle();
			style1.setFont(font1);
			style1.setAlignment((short) 2);


			HSSFCellStyle style2 = wb.createCellStyle();
			style2.setFont(font2);
			style2.setAlignment((short) 2);

			//style1.setLocked(true);

				HSSFRow row2 = sheet.createRow((short) 2);
				HSSFCell cell20 = row2.createCell((short) 2);
				cell20.setCellValue(new HSSFRichTextString(hospitalName));
				cell20.setCellStyle(style1);
				sheet.addMergedRegion(new Region(2, (short) 2, 2, (short) 4));

				HSSFRow row3 = sheet.createRow((short) 3);
				HSSFCell cell30 = row3.createCell((short) 2);
				SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
				//String dateStringFormat = java.util.Date.valueOf((sdf.format(new Date())));
				cell30.setCellValue(new HSSFRichTextString("Purchase Order for Vendor"));
				cell30.setCellStyle(style1);
				sheet.addMergedRegion(new Region(3, (short) 2, 3, (short) 4));

				//HSSFCell cell32 = row3.createCell((short) 7);
				//cell32.setCellValue(new HSSFRichTextString("25/12/2011"));

				HSSFRow row4 = sheet.createRow((short) 4);
				HSSFCell cell40 = row4.createCell((short)1);
				cell40.setCellStyle(style1);
				cell40.setCellValue(new HSSFRichTextString(""));
				sheet.addMergedRegion(new Region(4, (short) 0, 4, (short) 7));


				//=====Header row data=============================
				HSSFRow headerRow1 = sheet.createRow((short) 5);
				if(iter.hasNext()){
					Object[] pair_value = (Object[]) iter.next();
					supplierList=session.createCriteria(MasStoreSupplier.class).add(
							Restrictions.eq("id",Integer.parseInt(pair_value[1].toString()))).list();

				HSSFCell cell50 = headerRow1.createCell((short) 2);
				cell50.setCellValue(new HSSFRichTextString("SO No."));
				cell50.setCellStyle(style2);
				sheet.autoSizeColumn((short) 0);

				HSSFCell cell51 = headerRow1.createCell((short) 3);
				cell51.setCellValue(new HSSFRichTextString(pair_value[5].toString()));
				cell51.setCellStyle(style2);
				sheet.autoSizeColumn((short) 1);

				HSSFCell cell52 = headerRow1.createCell((short) 4);
				cell52.setCellValue(new HSSFRichTextString(""));
				cell52.setCellStyle(style2);
				sheet.autoSizeColumn((short) 2);

				HSSFCell cell53 = headerRow1.createCell((short) 5);
				cell53.setCellValue(new HSSFRichTextString("SO Date"));
				cell53.setCellStyle(style2);
				sheet.autoSizeColumn((short) 3);

				HSSFCell cell54 = headerRow1.createCell((short) 6);
				cell54.setCellValue(new HSSFRichTextString(pair_value[4].toString().substring(0,10)));
				cell54.setCellStyle(style2);
				sheet.autoSizeColumn((short) 4);


				HSSFCell cell55 = headerRow1.createCell((short) 7);
				cell55.setCellValue(new HSSFRichTextString(""));
				cell55.setCellStyle(style2);
				sheet.autoSizeColumn((short) 5);

				HSSFCell cell56 = headerRow1.createCell((short) 8);
				cell56.setCellValue(new HSSFRichTextString("Challan No."));
				cell56.setCellStyle(style2);
				sheet.autoSizeColumn((short) 6);

				HSSFCell cell57 = headerRow1.createCell((short) 9);
				cell57.setCellValue(new HSSFRichTextString(""));
				cell57.setCellStyle(style2);
				sheet.autoSizeColumn((short) 7);






				HSSFRow headerRow2 = sheet.createRow((short) 6);

				HSSFCell cell60 = headerRow2.createCell((short) 2);
				cell60.setCellValue(new HSSFRichTextString("Challan Date"));
				cell60.setCellStyle(style2);
				sheet.autoSizeColumn((short) 0);

				HSSFCell cell61 = headerRow2.createCell((short) 3);
				cell61.setCellValue(new HSSFRichTextString(""));
				cell61.setCellStyle(style2);
				sheet.autoSizeColumn((short) 1);

				HSSFCell cell62 = headerRow2.createCell((short) 4);
				cell62.setCellValue(new HSSFRichTextString(""));
				cell62.setCellStyle(style2);
				sheet.autoSizeColumn((short) 2);

				HSSFCell cell63 = headerRow2.createCell((short) 5);
				cell63.setCellValue(new HSSFRichTextString("Challan Amount"));
				cell63.setCellStyle(style2);
				sheet.autoSizeColumn((short) 3);

				HSSFCell cell64 = headerRow2.createCell((short) 4);
				cell64.setCellValue(new HSSFRichTextString(""));
				cell64.setCellStyle(style2);
				sheet.autoSizeColumn((short) 4);
				}
				HSSFRow row7 = sheet.createRow((short) 7);
				HSSFCell cell00 = row4.createCell((short)1);
				cell00.setCellStyle(style1);
				cell00.setCellValue(new HSSFRichTextString(""));
				sheet.addMergedRegion(new Region(7, (short) 0, 7, (short) 7));




	           // =====Heading Row Start===========================

				HSSFRow headingRow1 = sheet.createRow((short) 8);

				HSSFCell cell70 = headingRow1.createCell((short) 0);
				cell70.setCellValue(new HSSFRichTextString("Sl No."));
				cell70.setCellStyle(style2);
				sheet.autoSizeColumn((short) 0);

				HSSFCell cell71 = headingRow1.createCell((short) 1);
				cell71.setCellValue(new HSSFRichTextString("Item ID"));
				cell71.setCellStyle(style2);
				sheet.autoSizeColumn((short) 1);

				HSSFCell cell72 = headingRow1.createCell((short) 2);
				cell72.setCellValue(new HSSFRichTextString("       Nomenclature                "));
				cell72.setCellStyle(style2);
				sheet.autoSizeColumn((short) 2);

				HSSFCell cell73 = headingRow1.createCell((short) 3);
				cell73.setCellValue(new HSSFRichTextString(" A/U "));
				cell73.setCellStyle(style2);
				sheet.autoSizeColumn((short) 3);


				HSSFCell cell74 = headingRow1.createCell((short) 4);
				cell74.setCellValue(new HSSFRichTextString(" B/G "));
				cell74.setCellStyle(style2);
				sheet.autoSizeColumn((short) 4);



				HSSFCell cell75 = headingRow1.createCell((short) 5);
				cell75.setCellStyle(style);
				cell75.setCellValue(new HSSFRichTextString(" Brand "));
				cell75.setCellStyle(style2);
				sheet.autoSizeColumn((short) 5);


				HSSFCell cell76 = headingRow1.createCell((short) 6);
				cell76.setCellValue(new HSSFRichTextString(" Manufacturer "));
				cell76.setCellStyle(style2);
				sheet.autoSizeColumn((short) 6);



				HSSFCell cell77 = headingRow1.createCell((short) 7);
				cell77.setCellValue(new HSSFRichTextString(" QtyReq. "));
				cell77.setCellStyle(style2);
				sheet.autoSizeColumn((short) 7);


				HSSFCell cell78 = headingRow1.createCell((short) 8);
				cell78.setCellValue(new HSSFRichTextString(" Dispen.Type "));
				cell78.setCellStyle(style2);
				sheet.autoSizeColumn((short) 8);


				HSSFCell cell79 = headingRow1.createCell((short) 9);
				cell79.setCellValue(new HSSFRichTextString(" Packaging "));
				cell79.setCellStyle(style2);
				sheet.autoSizeColumn((short) 9);


				HSSFCell cell80 = headingRow1.createCell((short) 10);
				cell80.setCellValue(new HSSFRichTextString(" Ordered Quantity "));
				cell80.setCellStyle(style2);
				sheet.autoSizeColumn((short) 10);
				
				HSSFCell cell81 = headingRow1.createCell((short) 11);
				cell81.setCellValue(new HSSFRichTextString(" S B/G "));
				cell81.setCellStyle(style2);
				sheet.autoSizeColumn((short) 11);
				
				HSSFCell cell82 = headingRow1.createCell((short) 12);
				cell82.setCellValue(new HSSFRichTextString(" S Brand "));
				cell82.setCellStyle(style2);
				sheet.autoSizeColumn((short) 12);
				
				HSSFCell cell83 = headingRow1.createCell((short) 13);
				cell83.setCellValue(new HSSFRichTextString(" S Manufacturer "));
				cell83.setCellStyle(style2);
				sheet.autoSizeColumn((short) 13);
				
				HSSFCell cell84 = headingRow1.createCell((short) 14);
				cell84.setCellValue(new HSSFRichTextString(" Supplied Qty "));
				cell84.setCellStyle(style2);
				sheet.autoSizeColumn((short) 14);
				
				
				


				HSSFCell cell85 = headingRow1.createCell((short) 15);
				cell85.setCellValue(new HSSFRichTextString(" Batch "));
				cell85.setCellStyle(style2);
				sheet.autoSizeColumn((short) 15);





				HSSFCell cell86 = headingRow1.createCell((short) 16);
				cell86.setCellValue(new HSSFRichTextString(" DOM "));
				cell86.setCellStyle(style2);
				sheet.autoSizeColumn((short) 16);

				HSSFCell cell87 = headingRow1.createCell((short) 17);
				cell87.setCellValue(new HSSFRichTextString(" Pick DOM "));
				cell87.setCellStyle(style2);
				sheet.autoSizeColumn((short) 17);

				HSSFCell cell88 = headingRow1.createCell((short) 18);
				cell88.setCellValue(new HSSFRichTextString(" DOE "));
				cell88.setCellStyle(style2);
				sheet.autoSizeColumn((short) 18);

				HSSFCell cell89 = headingRow1.createCell((short) 19);
				cell89.setCellValue(new HSSFRichTextString(" Pick DOE "));
				cell89.setCellStyle(style2);
				sheet.autoSizeColumn((short) 19);



				HSSFCell cell810 = headingRow1.createCell((short) 20);
				cell810.setCellValue(new HSSFRichTextString(" MRP per Packaging  "));
				cell810.setCellStyle(style2);
				sheet.autoSizeColumn((short) 20);

				HSSFCell cell811 = headingRow1.createCell((short) 21);
				cell811.setCellValue(new HSSFRichTextString(" Discount(%) "));
				cell811.setCellStyle(style2);
				sheet.autoSizeColumn((short) 21);

				HSSFCell cell812 = headingRow1.createCell((short) 22);
				cell812.setCellValue(new HSSFRichTextString(" Tax(%) "));
				cell812.setCellStyle(style2);
				sheet.autoSizeColumn((short) 22);


				HSSFCell cell813 = headingRow1.createCell((short) 23);
				cell813.setCellValue(new HSSFRichTextString(" Total Value "));
				cell813.setCellStyle(style2);
				sheet.autoSizeColumn((short) 23);

				//============Heading Completed=======================

				//Region(int rowFrom, short colFrom, int rowTo, short colTo)
			//	sheet.addMergedRegion(new Region(6, (short) 1, 6, (short) 2));


	    int row=9;
	    int i=1;
	    while(itr.hasNext())
	    {
	    	Object[] pair = (Object[]) itr.next();

	    	//String received_qty=pair[0].toString();
	    	//String issue_qty=pair[1].toString();
	    	//String opening_balance_qty=pair[2].toString();

	        //String nomenclature=pair[4].toString();
	    	String pvms_no="";
	    	String Nomenclature="";
	    	String AccountinUnit="";
	    	String Brand_generic="";
	    	String Brand="";
	    	String Manufacturer="";
	    	float qtyRequired=(float) 0.0;
	    	String DispenceType="";
	    	float Packaging=(float) 0.0;
	    	float OderedQuantity=(float) 0.0;
	    	float MRP=(float) 0.0;
	    	float discount=(float) 0.0;
	    	float Tax=(float) 0.0;
	    	float totalAmount=(float) 0.0;


	    	if(pair[6]!=null){
	    		pvms_no=pair[6].toString();
	    	}else{
	    		pvms_no="na";
	    	}
	    	if(pair[7]!=null){
	    	 Nomenclature=pair[7].toString();
	    	}else{
	    		 Nomenclature="na";
	    	}if(pair[17]!=null){
	    	 AccountinUnit=pair[17].toString();
	    	}else{
	    		AccountinUnit="na";
	    	}
	    	if(pair[27]!=null){
	    	Brand_generic=pair[27].toString();
	    	}else{
		    Brand_generic="B";
	    	}
	    	if(pair[0]!=null){
	    	Brand=pair[0].toString();
	    	}else{
	    	Brand="na";
	    	}
	    	if(pair[3]!=null){
	    	 Manufacturer=pair[3].toString();
	    	}else{
	    		Manufacturer="na";
	    	}
	    	if(pair[15]!=null){
	    	qtyRequired=Float.parseFloat(pair[15].toString());
	    	}else{
	    	qtyRequired=(float)0.0;
	    	}
	    	if(pair[13]!=null){
	    	DispenceType=pair[13].toString();
	    	}else{
	    	DispenceType="na";
	    	}
	    	if(pair[14]!=null){
	    	Packaging=Float.parseFloat(pair[14].toString());
	    	}else{
	         Packaging=(float)0.0;
	    	}
	    	if(pair[22]!=null){
	    	OderedQuantity=Float.parseFloat(pair[22].toString());
	    	}else{
	    		OderedQuantity=(float)0.0;
	    	}if(pair[10]!=null){
	    	MRP=Float.parseFloat(pair[10].toString());
	    	}else{
	    		MRP=(float)0.0;
	    	}if(pair[11]!=null){
	    	discount=Float.parseFloat(pair[11].toString());
	    	}else{
	    		discount=(float)0.0;
	    	}
	    	if(pair[16]!=null){
	    	Tax=Float.parseFloat(pair[16].toString());
	    	}else{
	    		Tax=(float)0.0;
	    	}
	    	if(pair[12]!=null){
	    	totalAmount=Float.parseFloat(pair[12].toString());
	    	}else{
	    	totalAmount=(float)0.0;
	    	}


	        //String item_id=pair[6].toString();

	    	HSSFRow detailRow = sheet.createRow((short) row);

	    	HSSFCell cell90 = detailRow.createCell((short) 0);
			cell90.setCellValue(i);

			HSSFCell cell91 = detailRow.createCell((short) 1);
			cell91.setCellValue(new HSSFRichTextString(pvms_no));


			HSSFCell cell92 = detailRow.createCell((short) 2);
			cell92.setCellValue(new HSSFRichTextString(Nomenclature));

			HSSFCell cell93 = detailRow.createCell((short) 3);
			cell93.setCellValue(AccountinUnit);

			HSSFCell cell94 = detailRow.createCell((short) 4);
			cell94.setCellValue(Brand_generic);

			HSSFCell cell95 = detailRow.createCell((short) 5);
			cell95.setCellValue(Brand);


			HSSFCell cell97 = detailRow.createCell((short) 6);
			cell97.setCellValue(Manufacturer);

			HSSFCell cell98 = detailRow.createCell((short) 7);
			cell98.setCellValue(qtyRequired);


			HSSFCell cell99 = detailRow.createCell((short) 8);
			cell99.setCellValue(DispenceType);

			HSSFCell cell100 = detailRow.createCell((short) 9);
			cell100.setCellValue(Packaging);

			HSSFCell cell101 = detailRow.createCell((short) 10);
			cell101.setCellValue(OderedQuantity);
			
			HSSFCell cell102 = detailRow.createCell((short) 11);
			cell102.setCellValue("");
			
			HSSFCell cell103 = detailRow.createCell((short) 12);
			cell103.setCellValue("");
			
			HSSFCell cell104 = detailRow.createCell((short) 13);
			cell104.setCellValue("");
			
			HSSFCell cell105 = detailRow.createCell((short) 14);
			cell104.setCellValue("");

			HSSFCell cell106 = detailRow.createCell((short) 15);
			cell106.setCellValue("");

			HSSFCell cell107 = detailRow.createCell((short) 16);
			cell107.setCellValue("");

			HSSFCell cell108 = detailRow.createCell((short) 17);
			cell108.setCellValue("");

			HSSFCell cell109 = detailRow.createCell((short) 18);
			cell109.setCellValue("");

			HSSFCell cell1010 = detailRow.createCell((short) 19);
			cell1010.setCellValue("");

			HSSFCell cell1011 = detailRow.createCell((short) 20);
			cell1011.setCellValue(MRP);


			HSSFCell cell1012 = detailRow.createCell((short) 21);
			cell1012.setCellValue(discount);


			HSSFCell cell1013 = detailRow.createCell((short) 22);
			cell1013.setCellValue(Tax);

			HSSFCell cell1014 = detailRow.createCell((short) 23);
			cell1014.setCellValue(totalAmount);

			i++;
			row = row + 1;
	    }

	    dataMap.put("wb", wb);
	    dataMap.put("supplierList",supplierList);
       }
		catch (Exception e) {
			e.printStackTrace();
		}
		return dataMap;
   }
	
	
	public Map<String, Object> generateExcelToVendorSearch(Map<String,Object> map)
	{
		String hospitalName = null;
	    int hospitalId=0;
	    int deptId=0;
		String deptName = null;
		String query="";
		String po_id="";
		List<MasStoreSupplier> supplierList=null;
		 Map<String, Object> dataMap = new HashMap<String, Object>();
		Session session = getSession();
	    List storeItmBatchList=new ArrayList();
		if(map.get("hospitalName") != null){
	    	hospitalName = (String)map.get("hospitalName");
	    }
	    if(map.get("hospitalId") != null){
	    	hospitalId = (Integer)map.get("hospitalId");
	    }
	    if(map.get("deptName") != null){
	    	deptName = (String)map.get("deptName");
	    }
	    if(map.get("deptId") != null){
	    	deptId = (Integer)map.get("deptId");
	    }
	    if(map.get("query") != null){
	    	query = (String)map.get("query");
	    }
	    if(map.get("po_id")!=null){
	    	po_id=(String)map.get("po_id");
	    }

	    //String qry="SELECT ('Brand:' || mas_store_brand.brand_name) AS brand_name,store_po_header.supplier_id AS header_supplier_id,mas_store_supplier.supplier_name AS supplier_supplier_name,mas_manufacturer.MANUFACTURER_NAME as manufacturer_name,store_po_header.po_date AS store_po_header_po_date,store_po_header.po_number AS store_po_header_po_no,mas_store_item.ITEM_ID AS item_id,mas_store_item.nomenclature AS mas_store_item_nomenclature,mas_store_item.BRANDED_GENERIC as BRANDED_GENERIC,store_po_detail.rate_per_mdq AS store_po_detail_unit_rate,store_po_detail.mrp AS mrp,store_po_detail.DISCOUNT_PERCENT AS discount_percent,store_po_detail.amount AS store_po_detail_amount,store_po_detail.DISP_TYPE AS store_po_detail_disp_type,store_po_detail.MDQ_VALUE as store_po_detail_mdq,store_po_detail.LSO_QTY as store_po_detail_lso_qty,store_po_detail.TAX_OQ as store_po_detail_tax_oq,mas_store_unit.unit_name AS conversion_item_unit_name,store_po_header.delivery_date AS store_po_header_delivery_date,store_po_header.quotation_number AS quotation_number,store_po_header.quotation_date AS quotation_date,store_po_header.approval_authority AS approval_authority,store_po_detail.quantity_ordered AS quantity_ordered,round(store_po_header.net_amount, 2) AS header_net_amount,store_po_header.delivery_date AS store_po_header_delivery_date,store_po_header.po_date AS po_date,store_po_header.remarks as remarks FROM store_po_header store_po_header left outer join  store_po_detail store_po_detail ON store_po_header.po_id = store_po_detail.po_id LEFT OUTER JOIN mas_store_supplier mas_store_supplier ON store_po_header.supplier_id = mas_store_supplier.supplier_id LEFT OUTER JOIN mas_store_item mas_store_item ON store_po_detail.item_id = mas_store_item.item_id LEFT OUTER JOIN mas_district mas_district ON mas_store_supplier.local_city = mas_district.district_id LEFT OUTER JOIN mas_store_item_conversion mas_store_item_conversion ON mas_store_item.item_conversion_id = mas_store_item_conversion.item_conversion_id left outer join  mas_manufacturer mas_manufacturer on mas_store_item.MANUFACTURER_ID=mas_manufacturer.MANUFACTURER_ID LEFT OUTER JOIN mas_store_unit mas_store_unit ON mas_store_item_conversion.purchase_unit_id = mas_store_unit.unit_id LEFT OUTER JOIN mas_store_unit mas_store_unit_in ON mas_store_item_conversion.intermediate_unit_id = mas_store_unit_in.unit_id LEFT OUTER JOIN mas_store_brand mas_store_brand ON store_po_detail.brand_id = mas_store_brand.brand_id WHERE store_po_header.po_number ='"+po_id+"' and store_po_header.department_id ='24' and store_po_detail.cancelled IS NULL and mas_store_item.item_conversion_id = mas_store_item_conversion.item_conversion_id";
	  //in down previos query
	 //  String qry="SELECT mas_store_brand.brand_name AS brand_name,store_po_header.supplier_id AS header_supplier_id,mas_store_supplier.supplier_name AS supplier_supplier_name,mas_manufacturer.MANUFACTURER_NAME as manufacturer_name,store_po_header.po_date AS store_po_header_po_date,store_po_header.po_number AS store_po_header_po_no,mas_store_item.ITEM_ID AS item_id,mas_store_item.nomenclature AS mas_store_item_nomenclature,mas_store_item.BRANDED_GENERIC as BRANDED_GENERIC,store_po_detail.rate_per_mdq AS store_po_detail_unit_rate,store_po_detail.mrp AS mrp,store_po_detail.DISCOUNT_PERCENT AS discount_percent,store_po_detail.amount AS store_po_detail_amount,store_po_detail.DISP_TYPE AS store_po_detail_disp_type,store_po_detail.MDQ_VALUE as store_po_detail_mdq,store_po_detail.LSO_QTY as store_po_detail_lso_qty,store_po_detail.TAX_OQ as store_po_detail_tax_oq,mas_store_unit.unit_name AS conversion_item_unit_name,store_po_header.delivery_date AS store_po_header_delivery_date,store_po_header.quotation_number AS quotation_number,store_po_header.quotation_date AS quotation_date,store_po_header.approval_authority AS approval_authority,store_po_detail.quantity_ordered AS quantity_ordered,round(store_po_header.net_amount, 2) AS header_net_amount,store_po_header.delivery_date AS store_po_header_delivery_date,store_po_header.po_date AS po_date,store_po_header.remarks as remarks FROM store_po_header store_po_header left outer join  store_po_detail store_po_detail ON store_po_header.po_id = store_po_detail.po_id LEFT OUTER JOIN mas_store_supplier mas_store_supplier ON store_po_header.supplier_id = mas_store_supplier.supplier_id LEFT OUTER JOIN mas_store_item mas_store_item ON store_po_detail.item_id = mas_store_item.item_id LEFT OUTER JOIN mas_district mas_district ON mas_store_supplier.local_city = mas_district.district_id LEFT OUTER JOIN mas_store_item_conversion mas_store_item_conversion ON mas_store_item.item_conversion_id = mas_store_item_conversion.item_conversion_id left outer join  mas_manufacturer mas_manufacturer on store_po_detail.MANUFACTURER_ID=mas_manufacturer.MANUFACTURER_ID LEFT OUTER JOIN mas_store_unit mas_store_unit ON mas_store_item_conversion.purchase_unit_id = mas_store_unit.unit_id LEFT OUTER JOIN mas_store_unit mas_store_unit_in ON mas_store_item_conversion.intermediate_unit_id = mas_store_unit_in.unit_id LEFT OUTER JOIN mas_store_brand mas_store_brand ON store_po_detail.brand_id = mas_store_brand.brand_id WHERE store_po_header.po_number ='"+po_id+"' and store_po_header.department_id ='"+deptId+"' and store_po_header.HOSPITAL_ID='"+hospitalId+"' and store_po_detail.cancelled IS NULL and mas_store_item.item_conversion_id = mas_store_item_conversion.item_conversion_id order by mas_store_item.NOMENCLATURE";

	   String qry="SELECT mas_store_brand.brand_name AS brand_name,store_po_header.supplier_id AS header_supplier_id,mas_store_supplier.supplier_name AS supplier_supplier_name,mas_manufacturer.MANUFACTURER_NAME as manufacturer_name,store_po_header.po_date AS store_po_header_po_date,store_po_header.po_number AS store_po_header_po_no,mas_store_item.ITEM_ID AS item_id,mas_store_item.nomenclature AS mas_store_item_nomenclature,mas_store_item.BRANDED_GENERIC as BRANDED_GENERIC,store_po_detail.rate_per_mdq AS store_po_detail_unit_rate,store_po_detail.mrp AS mrp,store_po_detail.DISCOUNT_PERCENT AS discount_percent,store_po_detail.amount AS store_po_detail_amount,store_po_detail.DISP_TYPE AS store_po_detail_disp_type,store_po_detail.MDQ_VALUE as store_po_detail_mdq,sum(store_po_detail.LSO_QTY) as store_po_detail_lso_qty,store_po_detail.TAX_OQ as store_po_detail_tax_oq,mas_store_unit.unit_name AS conversion_item_unit_name,store_po_header.delivery_date AS store_po_header_delivery_date,store_po_header.quotation_number AS quotation_number,store_po_header.quotation_date AS quotation_date,store_po_header.approval_authority AS approval_authority,sum(store_po_detail.quantity_ordered) AS quantity_ordered,round(store_po_header.net_amount, 2) AS header_net_amount,store_po_header.delivery_date AS store_po_header_delivery_date,store_po_header.po_date AS po_date,store_po_header.remarks as remarks,store_po_detail.BRANDED_GENERIC AS BG FROM store_po_header store_po_header left outer join  store_po_detail store_po_detail ON store_po_header.po_id = store_po_detail.po_id  LEFT OUTER JOIN mas_store_supplier mas_store_supplier ON store_po_header.supplier_id = mas_store_supplier.supplier_id  LEFT OUTER JOIN mas_store_item mas_store_item ON store_po_detail.item_id = mas_store_item.item_id LEFT OUTER JOIN mas_district mas_district ON mas_store_supplier.local_city = mas_district.district_id  LEFT OUTER JOIN mas_store_item_conversion mas_store_item_conversion ON mas_store_item.item_conversion_id = mas_store_item_conversion.item_conversion_id  left outer join  mas_manufacturer mas_manufacturer on store_po_detail.MANUFACTURER_ID=mas_manufacturer.MANUFACTURER_ID  LEFT OUTER JOIN mas_store_unit mas_store_unit ON mas_store_item_conversion.purchase_unit_id = mas_store_unit.unit_id  LEFT OUTER JOIN mas_store_unit mas_store_unit_in ON mas_store_item_conversion.intermediate_unit_id = mas_store_unit_in.unit_id LEFT OUTER JOIN mas_store_brand mas_store_brand ON store_po_detail.brand_id = mas_store_brand.brand_id WHERE store_po_header.PO_ID ='"+po_id+"' and store_po_header.department_id ='"+deptId+"' and store_po_header.HOSPITAL_ID='"+hospitalId+"' and store_po_detail.cancelled IS NULL and mas_store_item.item_conversion_id = mas_store_item_conversion.item_conversion_id group by mas_store_brand.brand_name ,store_po_header.supplier_id ,mas_store_supplier.supplier_name ,mas_manufacturer.MANUFACTURER_NAME ,store_po_header.po_date ,store_po_header.po_number,mas_store_item.ITEM_ID ,mas_store_item.nomenclature ,mas_store_item.BRANDED_GENERIC ,store_po_detail.rate_per_mdq ,store_po_detail.mrp ,store_po_detail.DISCOUNT_PERCENT ,store_po_detail.amount ,store_po_detail.DISP_TYPE ,store_po_detail.MDQ_VALUE ,store_po_detail.TAX_OQ ,mas_store_unit.unit_name ,store_po_header.delivery_date ,store_po_header.quotation_number ,store_po_header.quotation_date ,store_po_header.approval_authority ,store_po_header.delivery_date ,store_po_header.po_date ,store_po_header.remarks,store_po_header.net_amount,store_po_detail.BRANDED_GENERIC order by mas_store_item.NOMENCLATURE";

	    storeItmBatchList=session.createSQLQuery(qry).list();
	    Iterator itr=storeItmBatchList.iterator();
	    Iterator iter=storeItmBatchList.iterator();
       try
       {

			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet("Supply Order for Vendor");
			//sheet.setColumnWidth((short) 1, (short)10);
			// Create a new font and alter it.

			HSSFFont font = wb.createFont();
			font.setFontHeightInPoints((short) 10);
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setColor((short) 80);
			font.setItalic(false);
			font.setStrikeout(false);
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

			HSSFFont font1 = wb.createFont();
			font1.setFontHeightInPoints((short) 12);
			font1.setFontName(HSSFFont.FONT_ARIAL);
			font1.setColor((short) 80);
			font1.setItalic(false);
			font1.setStrikeout(false);
			font1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

			HSSFFont font2 = wb.createFont();
			font2.setFontHeightInPoints((short) 9);
			font2.setFontName(HSSFFont.FONT_ARIAL);
			font2.setColor((short) 80);
			font2.setItalic(false);
			font2.setStrikeout(false);
			font2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

			// Fonts are set into a style so create a new one to
			// use.
			HSSFCellStyle style = wb.createCellStyle();
			style.setFont(font);
			style.setAlignment((short) 2);


			HSSFCellStyle style1 = wb.createCellStyle();
			style1.setFont(font1);
			style1.setAlignment((short) 2);


			HSSFCellStyle style2 = wb.createCellStyle();
			style2.setFont(font2);
			style2.setAlignment((short) 2);

			//style1.setLocked(true);

				HSSFRow row2 = sheet.createRow((short) 2);
				HSSFCell cell20 = row2.createCell((short) 2);
				cell20.setCellValue(new HSSFRichTextString(hospitalName));
				cell20.setCellStyle(style1);
				sheet.addMergedRegion(new Region(2, (short) 2, 2, (short) 4));

				HSSFRow row3 = sheet.createRow((short) 3);
				HSSFCell cell30 = row3.createCell((short) 2);
				SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
				//String dateStringFormat = java.util.Date.valueOf((sdf.format(new Date())));
				cell30.setCellValue(new HSSFRichTextString("Purchase Order for Vendor"));
				cell30.setCellStyle(style1);
				sheet.addMergedRegion(new Region(3, (short) 2, 3, (short) 4));

				//HSSFCell cell32 = row3.createCell((short) 7);
				//cell32.setCellValue(new HSSFRichTextString("25/12/2011"));

				HSSFRow row4 = sheet.createRow((short) 4);
				HSSFCell cell40 = row4.createCell((short)1);
				cell40.setCellStyle(style1);
				cell40.setCellValue(new HSSFRichTextString(""));
				sheet.addMergedRegion(new Region(4, (short) 0, 4, (short) 7));


				//=====Header row data=============================
				HSSFRow headerRow1 = sheet.createRow((short) 5);
				if(iter.hasNext()){
					Object[] pair_value = (Object[]) iter.next();
					supplierList=session.createCriteria(MasStoreSupplier.class).add(
							Restrictions.eq("id",Integer.parseInt(pair_value[1].toString()))).list();

				HSSFCell cell50 = headerRow1.createCell((short) 2);
				cell50.setCellValue(new HSSFRichTextString("SO No."));
				cell50.setCellStyle(style2);
				sheet.autoSizeColumn((short) 0);

				HSSFCell cell51 = headerRow1.createCell((short) 3);
				cell51.setCellValue(new HSSFRichTextString(pair_value[5].toString()));
				cell51.setCellStyle(style2);
				sheet.autoSizeColumn((short) 1);

				HSSFCell cell52 = headerRow1.createCell((short) 4);
				cell52.setCellValue(new HSSFRichTextString(""));
				cell52.setCellStyle(style2);
				sheet.autoSizeColumn((short) 2);

				HSSFCell cell53 = headerRow1.createCell((short) 5);
				cell53.setCellValue(new HSSFRichTextString("SO Date"));
				cell53.setCellStyle(style2);
				sheet.autoSizeColumn((short) 3);

				HSSFCell cell54 = headerRow1.createCell((short) 6);
				cell54.setCellValue(new HSSFRichTextString(pair_value[4].toString().substring(0,10)));
				cell54.setCellStyle(style2);
				sheet.autoSizeColumn((short) 4);


				HSSFCell cell55 = headerRow1.createCell((short) 7);
				cell55.setCellValue(new HSSFRichTextString(""));
				cell55.setCellStyle(style2);
				sheet.autoSizeColumn((short) 5);

				HSSFCell cell56 = headerRow1.createCell((short) 8);
				cell56.setCellValue(new HSSFRichTextString("Challan No."));
				cell56.setCellStyle(style2);
				sheet.autoSizeColumn((short) 6);

				HSSFCell cell57 = headerRow1.createCell((short) 9);
				cell57.setCellValue(new HSSFRichTextString(""));
				cell57.setCellStyle(style2);
				sheet.autoSizeColumn((short) 7);






				HSSFRow headerRow2 = sheet.createRow((short) 6);

				HSSFCell cell60 = headerRow2.createCell((short) 2);
				cell60.setCellValue(new HSSFRichTextString("Challan Date"));
				cell60.setCellStyle(style2);
				sheet.autoSizeColumn((short) 0);

				HSSFCell cell61 = headerRow2.createCell((short) 3);
				cell61.setCellValue(new HSSFRichTextString(""));
				cell61.setCellStyle(style2);
				sheet.autoSizeColumn((short) 1);

				HSSFCell cell62 = headerRow2.createCell((short) 4);
				cell62.setCellValue(new HSSFRichTextString(""));
				cell62.setCellStyle(style2);
				sheet.autoSizeColumn((short) 2);

				HSSFCell cell63 = headerRow2.createCell((short) 5);
				cell63.setCellValue(new HSSFRichTextString("Challan Amount"));
				cell63.setCellStyle(style2);
				sheet.autoSizeColumn((short) 3);

				HSSFCell cell64 = headerRow2.createCell((short) 4);
				cell64.setCellValue(new HSSFRichTextString(""));
				cell64.setCellStyle(style2);
				sheet.autoSizeColumn((short) 4);
				}
				HSSFRow row7 = sheet.createRow((short) 7);
				HSSFCell cell00 = row4.createCell((short)1);
				cell00.setCellStyle(style1);
				cell00.setCellValue(new HSSFRichTextString(""));
				sheet.addMergedRegion(new Region(7, (short) 0, 7, (short) 7));




	           // =====Heading Row Start===========================

				HSSFRow headingRow1 = sheet.createRow((short) 8);

				HSSFCell cell70 = headingRow1.createCell((short) 0);
				cell70.setCellValue(new HSSFRichTextString("Sl No."));
				cell70.setCellStyle(style2);
				sheet.autoSizeColumn((short) 0);

				HSSFCell cell71 = headingRow1.createCell((short) 1);
				cell71.setCellValue(new HSSFRichTextString("Item ID"));
				cell71.setCellStyle(style2);
				sheet.autoSizeColumn((short) 1);

				HSSFCell cell72 = headingRow1.createCell((short) 2);
				cell72.setCellValue(new HSSFRichTextString("       Nomenclature                "));
				cell72.setCellStyle(style2);
				sheet.autoSizeColumn((short) 2);

				HSSFCell cell73 = headingRow1.createCell((short) 3);
				cell73.setCellValue(new HSSFRichTextString(" A/U "));
				cell73.setCellStyle(style2);
				sheet.autoSizeColumn((short) 3);


				HSSFCell cell74 = headingRow1.createCell((short) 4);
				cell74.setCellValue(new HSSFRichTextString(" B/G "));
				cell74.setCellStyle(style2);
				sheet.autoSizeColumn((short) 4);



				HSSFCell cell75 = headingRow1.createCell((short) 5);
				cell75.setCellStyle(style);
				cell75.setCellValue(new HSSFRichTextString(" Brand "));
				cell75.setCellStyle(style2);
				sheet.autoSizeColumn((short) 5);


				HSSFCell cell76 = headingRow1.createCell((short) 6);
				cell76.setCellValue(new HSSFRichTextString(" Manufacturer "));
				cell76.setCellStyle(style2);
				sheet.autoSizeColumn((short) 6);



				HSSFCell cell77 = headingRow1.createCell((short) 7);
				cell77.setCellValue(new HSSFRichTextString(" QtyReq. "));
				cell77.setCellStyle(style2);
				sheet.autoSizeColumn((short) 7);


				HSSFCell cell78 = headingRow1.createCell((short) 8);
				cell78.setCellValue(new HSSFRichTextString(" Dispen.Type "));
				cell78.setCellStyle(style2);
				sheet.autoSizeColumn((short) 8);


				HSSFCell cell79 = headingRow1.createCell((short) 9);
				cell79.setCellValue(new HSSFRichTextString(" Packaging "));
				cell79.setCellStyle(style2);
				sheet.autoSizeColumn((short) 9);


				HSSFCell cell80 = headingRow1.createCell((short) 10);
				cell80.setCellValue(new HSSFRichTextString(" Ordered Quantity "));
				cell80.setCellStyle(style2);
				sheet.autoSizeColumn((short) 10);
				
				HSSFCell cell81 = headingRow1.createCell((short) 11);
				cell81.setCellValue(new HSSFRichTextString(" S B/G "));
				cell81.setCellStyle(style2);
				sheet.autoSizeColumn((short) 11);
				
				HSSFCell cell82 = headingRow1.createCell((short) 12);
				cell82.setCellValue(new HSSFRichTextString(" S Brand "));
				cell82.setCellStyle(style2);
				sheet.autoSizeColumn((short) 12);
				
				HSSFCell cell83 = headingRow1.createCell((short) 13);
				cell83.setCellValue(new HSSFRichTextString(" S Manufacturer "));
				cell83.setCellStyle(style2);
				sheet.autoSizeColumn((short) 13);
				
				HSSFCell cell84 = headingRow1.createCell((short) 14);
				cell84.setCellValue(new HSSFRichTextString(" Supplied Qty "));
				cell84.setCellStyle(style2);
				sheet.autoSizeColumn((short) 14);
				
				
				


				HSSFCell cell85 = headingRow1.createCell((short) 15);
				cell85.setCellValue(new HSSFRichTextString(" Batch "));
				cell85.setCellStyle(style2);
				sheet.autoSizeColumn((short) 15);





				HSSFCell cell86 = headingRow1.createCell((short) 16);
				cell86.setCellValue(new HSSFRichTextString(" DOM "));
				cell86.setCellStyle(style2);
				sheet.autoSizeColumn((short) 16);

				HSSFCell cell87 = headingRow1.createCell((short) 17);
				cell87.setCellValue(new HSSFRichTextString(" Pick DOM "));
				cell87.setCellStyle(style2);
				sheet.autoSizeColumn((short) 17);

				HSSFCell cell88 = headingRow1.createCell((short) 18);
				cell88.setCellValue(new HSSFRichTextString(" DOE "));
				cell88.setCellStyle(style2);
				sheet.autoSizeColumn((short) 18);

				HSSFCell cell89 = headingRow1.createCell((short) 19);
				cell89.setCellValue(new HSSFRichTextString(" Pick DOE "));
				cell89.setCellStyle(style2);
				sheet.autoSizeColumn((short) 19);



				HSSFCell cell810 = headingRow1.createCell((short) 20);
				cell810.setCellValue(new HSSFRichTextString(" MRP per Packaging  "));
				cell810.setCellStyle(style2);
				sheet.autoSizeColumn((short) 20);

				HSSFCell cell811 = headingRow1.createCell((short) 21);
				cell811.setCellValue(new HSSFRichTextString(" Discount(%) "));
				cell811.setCellStyle(style2);
				sheet.autoSizeColumn((short) 21);

				HSSFCell cell812 = headingRow1.createCell((short) 22);
				cell812.setCellValue(new HSSFRichTextString(" Tax(%) "));
				cell812.setCellStyle(style2);
				sheet.autoSizeColumn((short) 22);


				HSSFCell cell813 = headingRow1.createCell((short) 23);
				cell813.setCellValue(new HSSFRichTextString(" Total Value "));
				cell813.setCellStyle(style2);
				sheet.autoSizeColumn((short) 23);

				//============Heading Completed=======================

				//Region(int rowFrom, short colFrom, int rowTo, short colTo)
			//	sheet.addMergedRegion(new Region(6, (short) 1, 6, (short) 2));


	    int row=9;
	    int i=1;
	    while(itr.hasNext())
	    {
	    	Object[] pair = (Object[]) itr.next();

	    	//String received_qty=pair[0].toString();
	    	//String issue_qty=pair[1].toString();
	    	//String opening_balance_qty=pair[2].toString();

	        //String nomenclature=pair[4].toString();
	    	String pvms_no="";
	    	String Nomenclature="";
	    	String AccountinUnit="";
	    	String Brand_generic="";
	    	String Brand="";
	    	String Manufacturer="";
	    	float qtyRequired=(float) 0.0;
	    	String DispenceType="";
	    	float Packaging=(float) 0.0;
	    	float OderedQuantity=(float) 0.0;
	    	float MRP=(float) 0.0;
	    	float discount=(float) 0.0;
	    	float Tax=(float) 0.0;
	    	float totalAmount=(float) 0.0;


	    	if(pair[6]!=null){
	    		pvms_no=pair[6].toString();
	    	}else{
	    		pvms_no="na";
	    	}
	    	if(pair[7]!=null){
	    	 Nomenclature=pair[7].toString();
	    	}else{
	    		 Nomenclature="na";
	    	}if(pair[17]!=null){
	    	 AccountinUnit=pair[17].toString();
	    	}else{
	    		AccountinUnit="na";
	    	}
	    	if(pair[27]!=null){
	    	Brand_generic=pair[27].toString();
	    	}else{
		    Brand_generic="B";
	    	}
	    	if(pair[0]!=null){
	    	Brand=pair[0].toString();
	    	}else{
	    	Brand="na";
	    	}
	    	if(pair[3]!=null){
	    	 Manufacturer=pair[3].toString();
	    	}else{
	    		Manufacturer="na";
	    	}
	    	if(pair[15]!=null){
	    	qtyRequired=Float.parseFloat(pair[15].toString());
	    	}else{
	    	qtyRequired=(float)0.0;
	    	}
	    	if(pair[13]!=null){
	    	DispenceType=pair[13].toString();
	    	}else{
	    	DispenceType="na";
	    	}
	    	if(pair[14]!=null){
	    	Packaging=Float.parseFloat(pair[14].toString());
	    	}else{
	         Packaging=(float)0.0;
	    	}
	    	if(pair[22]!=null){
	    	OderedQuantity=Float.parseFloat(pair[22].toString());
	    	}else{
	    		OderedQuantity=(float)0.0;
	    	}if(pair[10]!=null){
	    	MRP=Float.parseFloat(pair[10].toString());
	    	}else{
	    		MRP=(float)0.0;
	    	}if(pair[11]!=null){
	    	discount=Float.parseFloat(pair[11].toString());
	    	}else{
	    		discount=(float)0.0;
	    	}
	    	if(pair[16]!=null){
	    	Tax=Float.parseFloat(pair[16].toString());
	    	}else{
	    		Tax=(float)0.0;
	    	}
	    	if(pair[12]!=null){
	    	totalAmount=Float.parseFloat(pair[12].toString());
	    	}else{
	    	totalAmount=(float)0.0;
	    	}


	        //String item_id=pair[6].toString();

	    	HSSFRow detailRow = sheet.createRow((short) row);

	    	HSSFCell cell90 = detailRow.createCell((short) 0);
			cell90.setCellValue(i);

			HSSFCell cell91 = detailRow.createCell((short) 1);
			cell91.setCellValue(new HSSFRichTextString(pvms_no));


			HSSFCell cell92 = detailRow.createCell((short) 2);
			cell92.setCellValue(new HSSFRichTextString(Nomenclature));

			HSSFCell cell93 = detailRow.createCell((short) 3);
			cell93.setCellValue(AccountinUnit);

			HSSFCell cell94 = detailRow.createCell((short) 4);
			cell94.setCellValue(Brand_generic);

			HSSFCell cell95 = detailRow.createCell((short) 5);
			cell95.setCellValue(Brand);


			HSSFCell cell97 = detailRow.createCell((short) 6);
			cell97.setCellValue(Manufacturer);

			HSSFCell cell98 = detailRow.createCell((short) 7);
			cell98.setCellValue(qtyRequired);


			HSSFCell cell99 = detailRow.createCell((short) 8);
			cell99.setCellValue(DispenceType);

			HSSFCell cell100 = detailRow.createCell((short) 9);
			cell100.setCellValue(Packaging);

			HSSFCell cell101 = detailRow.createCell((short) 10);
			cell101.setCellValue(OderedQuantity);
			
			HSSFCell cell102 = detailRow.createCell((short) 11);
			cell102.setCellValue("");
			
			HSSFCell cell103 = detailRow.createCell((short) 12);
			cell103.setCellValue("");
			
			HSSFCell cell104 = detailRow.createCell((short) 13);
			cell104.setCellValue("");
			
			HSSFCell cell105 = detailRow.createCell((short) 14);
			cell104.setCellValue("");

			HSSFCell cell106 = detailRow.createCell((short) 15);
			cell106.setCellValue("");

			HSSFCell cell107 = detailRow.createCell((short) 16);
			cell107.setCellValue("");

			HSSFCell cell108 = detailRow.createCell((short) 17);
			cell108.setCellValue("");

			HSSFCell cell109 = detailRow.createCell((short) 18);
			cell109.setCellValue("");

			HSSFCell cell1010 = detailRow.createCell((short) 19);
			cell1010.setCellValue("");

			HSSFCell cell1011 = detailRow.createCell((short) 20);
			cell1011.setCellValue(MRP);


			HSSFCell cell1012 = detailRow.createCell((short) 21);
			cell1012.setCellValue(discount);


			HSSFCell cell1013 = detailRow.createCell((short) 22);
			cell1013.setCellValue(Tax);

			HSSFCell cell1014 = detailRow.createCell((short) 23);
			cell1014.setCellValue(totalAmount);

			i++;
			row = row + 1;
	    }

	    dataMap.put("wb", wb);
	    dataMap.put("supplierList",supplierList);
       }
		catch (Exception e) {
			e.printStackTrace();
		}
		return dataMap;
   }
	
// javed
	public Map<String, Object> getExpiryDrug(Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		session = (Session) getSession();
		int deptId = 0;
		int hosId = 0; // add javed khan

		java.util.Date fromDate=null;

		String qry="";
		Map<String, Object> utilMap = new HashMap<String, Object>();

		List objectList = new ArrayList();

		try {
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
			fromDate=HMSUtil.convertStringTypeDateToDateType(dataMap.get("fromDate").toString());
			hosId = Integer.parseInt("" + dataMap.get("hospitalId"));
			int month = (Integer)dataMap.get("month");
			int year = (Integer)dataMap.get("year");
				  /*qry="SELECT a.stock_id, b.pvms_no, b.nomenclature,e.unit_name au, a.batch_no, a.expiry_date,"+
				  	   " a.closing_stock,a.cost_price as rate, (a.closing_stock*a.cost_price) as amount"+
				  	   "  FROM store_item_batch_stock a, mas_store_item b, mas_store_brand c, mas_store_item_conversion d, mas_store_unit e"+
				  	   " where a.item_id = b.item_id"+
				  	   " and a.brand_id = c.brand_id"+
				  	   " and b.item_conversion_id = d.item_conversion_id"+
				  	   " and d.purchase_unit_id = e.unit_id"+
				  	   " and a.expiry_date <="+
				  	   " to_date('"+fromDate +"',"+"'dd-mm-yyyy'"+")"+
				  	   " and a.department_id ='"+deptId+"'"+
				  	   " and a.hospital_id ='"+hosId+"'"+

				  	   "  order by b.pvms_no";*/
/*

			 qry="SELECT  b.pvms_no, b.nomenclature,e.unit_name au, a.batch_no, a.expiry_date,"+
		  	   " sum(a.closing_stock)"+
		  	   "  FROM store_item_batch_stock a, mas_store_item b, mas_store_brand c, mas_store_item_conversion d, mas_store_unit e"+
		  	   " where a.item_id = b.item_id"+
		  	  // " and a.brand_id = c.brand_id"+  // comment by javed
		  	   " and b.item_conversion_id = d.item_conversion_id"+
		  	   " and d.purchase_unit_id = e.unit_id"+
		  	   " and a.expiry_date <="+
		  	   " to_date('"+fromDate +"',"+"'dd-mm-yyyy'"+")"+
		  	   " and a.department_id ='"+deptId+"'"+
		  	   " and a.hospital_id ='"+hosId+"'"+
		  	   " and a.CLOSING_STOCK>0"+
		  	   " group by  b.pvms_no, b.nomenclature,e.unit_name , a.batch_no, a.expiry_date "+ // add javed
		  	   "  order by b.pvms_no";
			 
			 */
			 
			  // comment and add  by javed khan 29-08-12
			 
			 qry=" SELECT b.pvms_no, b.nomenclature,e.unit_name au, a.batch_no, a.expiry_date, sum(a.closing_stock)"+
			 	" FROM store_item_batch_stock a "+  
			 	" left outer join mas_store_item b on a.item_id = b.item_id "+ 
			 	" left outer join mas_store_item_conversion d on  b.item_conversion_id = d.item_conversion_id "+ 
			 	" left outer join  mas_store_unit e  on d.purchase_unit_id = e.unit_id "+
			 	" where a.expiry_date <= convert(date,"+fromDate +")" +
			 	//" where extract(month from a.expiry_date) <= "+month+ " and extract(year from a.expiry_date)<="+year+
			 	" and a.department_id ='"+deptId+"'"+			 	
			 	 " and a.CLOSING_STOCK>0"+
			 " group by b.pvms_no,a.BATCH_NO, b.nomenclature,e.unit_name , a.batch_no,a.expiry_date, a.closing_stock  "+
			 " order by b.pvms_no";

			
			objectList = (List) session.createSQLQuery(qry).list();



		} catch (HibernateException e) {
			e.printStackTrace();
		}
		/*for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
			Object[] object = (Object[]) iterator.next();
			System.out.println("object "+object.length);
			for(int i=0; i<object.length;i++)
			{
			System.out.println("-------"+object[i]);
			}
		}*/

		map.put("objectList", objectList);
		return map;

	}
	public Map<String, Object> getAbcItem(Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		session = (Session) getSession();
		// System.out.println("IN SMC DATAIMPL");
		int deptId = 0;

		String query="";
		String fromDate="";
		String toDate="";
		String hospitalName = "";
		float sumOfStock= 0.0f;
		float costPriceForAClass = 0.0f;
		float costPriceForBClass = 0.0f;
		Map<String, Object> utilMap = new HashMap<String, Object>();

		List objectList = new ArrayList();
		if (dataMap.get("fromDate") != null
				&& !(dataMap.get("fromDate").equals(""))) {
			fromDate =(String)dataMap.get("fromDate");}
		if (dataMap.get("toDate") != null
				&& !(dataMap.get("toDate").equals(""))) {
			toDate =(String)dataMap.get("toDate");}
		if (dataMap.get("sumOfStock") != null
				&& !(dataMap.get("sumOfStock").equals(""))) {
			sumOfStock =(Float)dataMap.get("sumOfStock");}
		if (dataMap.get("costPriceForAClass") != null
				&& !(dataMap.get("costPriceForAClass").equals(""))) {
			costPriceForAClass =(Float)dataMap.get("costPriceForAClass");}
		if (dataMap.get("costPriceForBClass") != null
				&& !(dataMap.get("costPriceForBClass").equals(""))) {
			costPriceForBClass =(Float)dataMap.get("costPriceForBClass");}

		try {
			//deptId = Integer.parseInt("" + dataMap.get("deptId"));
			//query=(String)dataMap.get("QUERY");
			// System.out.println("deptId "+deptId+" FROM_DATE "+fromDate+" TO_DATE "+toDate);
			/*String qry="select a.cost_price,sum(sit.qty_issued),d.pvms_no,d.nomenclature,'smc',a.item_id,a.stock_id,a.closing_stock as stock_qty,a.closing_stock*a.cost_price as value,(a.closing_stock*a.cost_price)*100/'"
				        +sumOfStock+"' as per,SUM((b.closing_stock*b.cost_price)*100/'"
				        +sumOfStock+"') as cum,concat('A Class Items >=', '"
				        +costPriceForAClass+"') as class from store_item_batch_stock a,store_item_batch_stock b left outer join STORE_ISSUE_T sit on b.item_id=sit.item_id ,mas_store_item d where a.item_id=d.item_id and a.cost_price >= b.cost_price and a.cost_price >='"
				        +costPriceForAClass+"' GROUP BY a.cost_price,sit.qty_issued,d.pvms_no,d.nomenclature"
						+",a.item_id,a.stock_id,a.closing_stock union"
						+" select a.cost_price,sum(sit.qty_issued),d.pvms_no,d.nomenclature,'smc',a.item_id,a.stock_id,a.closing_stock as stock_qty,a.closing_stock*a.cost_price as value,(a.closing_stock*a.cost_price)*100/'"
				        +sumOfStock+"' as per,SUM((b.closing_stock*b.cost_price)*100/'"
				        +sumOfStock+"') as cum, 'B Class Items >= ' || '"
				        +costPriceForBClass+"' || '& < ' || '"
				        +costPriceForAClass+"'  as class from store_item_batch_stock a,store_item_batch_stock b left outer join STORE_ISSUE_T sit on b.item_id=sit.item_id ,mas_store_item d where a.item_id=d.item_id and a.cost_price >= b.cost_price and a.cost_price <'"
				        +costPriceForAClass+"' and a.cost_price >='"
				        +costPriceForBClass+"' GROUP BY a.cost_price,sit.qty_issued,d.pvms_no,d.nomenclature,a.item_id,a.stock_id,a.closing_stock union"
						+" select a.cost_price,sum(sit.qty_issued),d.pvms_no,d.nomenclature,'smc',a.item_id,a.stock_id,a.closing_stock as stock_qty,a.closing_stock*a.cost_price as value,(a.closing_stock*a.cost_price)*100/'"
				        +sumOfStock+"' as per,SUM((b.closing_stock*b.cost_price)*100/'"
				        +sumOfStock+"') as cum,concat('C Class Items < ','"
				        +costPriceForBClass+"') as class from store_item_batch_stock a,store_item_batch_stock b left outer join STORE_ISSUE_T sit on b.item_id=sit.item_id ,mas_store_item d where a.item_id=d.item_id and a.cost_price >= b.cost_price and a.cost_price <100000.0 GROUP BY a.cost_price,sit.qty_issued,d.pvms_no,d.nomenclature,a.item_id,a.stock_id,a.closing_stock order by cost_price";*/

			/*String qry="select a.cost_price,sit.qty_issued,d.pvms_no,d.nomenclature,'smc',a.item_id,a.stock_id,a.closing_stock as stock_qty,a.closing_stock*a.cost_price as value,(a.closing_stock*a.cost_price)*100/'"
		        +sumOfStock+"' as per,SUM((b.closing_stock*b.cost_price)*100/'"
		        +sumOfStock+"') as cum,concat('A Class Items >=', '"
		        +costPriceForAClass+"') as class from store_item_batch_stock a,store_item_batch_stock b ,mas_store_item d left outer join STORE_ISSUE_T sit on d.item_id=sit.item_id where a.item_id=d.item_id and a.cost_price >= b.cost_price and a.cost_price >='"
		        +costPriceForAClass+"' GROUP BY a.cost_price,d.pvms_no,d.nomenclature,sit.qty_issued"
				+",a.item_id,a.stock_id,a.closing_stock union"
				+" select a.cost_price,sit.qty_issued,d.pvms_no,d.nomenclature,'smc',a.item_id,a.stock_id,a.closing_stock as stock_qty,a.closing_stock*a.cost_price as value,(a.closing_stock*a.cost_price)*100/'"
		        +sumOfStock+"' as per,SUM((b.closing_stock*b.cost_price)*100/'"
		        +sumOfStock+"') as cum, 'B Class Items >= ' || '"
		        +costPriceForBClass+"' || '& < ' || '"
		        +costPriceForAClass+"'  as class from store_item_batch_stock a,store_item_batch_stock b  ,mas_store_item d left outer join STORE_ISSUE_T sit on d.item_id=sit.item_id where a.item_id=d.item_id and a.cost_price >= b.cost_price and a.cost_price <'"
		        +costPriceForAClass+"' and a.cost_price >='"
		        +costPriceForBClass+"' GROUP BY a.cost_price,d.pvms_no,d.nomenclature,sit.qty_issued,a.item_id,a.stock_id,a.closing_stock union"
				+" select a.cost_price,sit.qty_issued,d.pvms_no,d.nomenclature,'smc',a.item_id,a.stock_id,a.closing_stock as stock_qty,a.closing_stock*a.cost_price as value,(a.closing_stock*a.cost_price)*100/'"
		        +sumOfStock+"' as per,SUM((b.closing_stock*b.cost_price)*100/'"
		        +sumOfStock+"') as cum,concat('C Class Items < ','"
		        +costPriceForBClass+"') as class from store_item_batch_stock a,store_item_batch_stock b ,mas_store_item d left outer join STORE_ISSUE_T sit on d.item_id=sit.item_id where a.item_id=d.item_id and a.cost_price >= b.cost_price and a.cost_price <100000.0 GROUP BY a.cost_price,d.pvms_no,d.nomenclature,sit.qty_issued, a.item_id,a.stock_id,a.closing_stock order by cost_price";*/


			String qry="select a.cost_price,sit.qty_issued,d.pvms_no,d.nomenclature,'smc',a.item_id,a.stock_id,a.closing_stock as stock_qty,a.closing_stock*a.cost_price as value,(a.closing_stock*a.cost_price)*100/'"
		        +sumOfStock+"' as per,SUM((b.closing_stock*b.cost_price)*100/'"
		        +sumOfStock+"') as cum,concat('A Class Items >=', '"
		        +costPriceForAClass+"') as class,MAS_STORE_ITEM_CONVERSION.ITEM_UNIT_NAME from store_item_batch_stock a,store_item_batch_stock b ,mas_store_item d left outer join STORE_ISSUE_T sit on d.item_id=sit.item_id left outer join MAS_STORE_ITEM_CONVERSION  MAS_STORE_ITEM_CONVERSION on d.ITEM_CONVERSION_ID= MAS_STORE_ITEM_CONVERSION.ITEM_CONVERSION_ID, STORE_ISSUE_M  sim where a.item_id=d.item_id and sim.id= sit.ISSUE_M_ID  and a.cost_price >= b.cost_price and a.cost_price >='"
		        +costPriceForAClass+"' and sim.issue_date between to_date('"+fromDate +"',"+"'dd-mm-yyyy'"+") and to_date('"+toDate +"',"+"'dd-mm-yyyy'"+")  GROUP BY a.cost_price,d.pvms_no,d.nomenclature,sit.qty_issued"
				+",a.item_id,a.stock_id,a.closing_stock,MAS_STORE_ITEM_CONVERSION.ITEM_UNIT_NAME union"
				+" select a.cost_price,sit.qty_issued,d.pvms_no,d.nomenclature,'smc',a.item_id,a.stock_id,a.closing_stock as stock_qty,a.closing_stock*a.cost_price as value,(a.closing_stock*a.cost_price)*100/'"
		        +sumOfStock+"' as per,SUM((b.closing_stock*b.cost_price)*100/'"
		        +sumOfStock+"') as cum, 'B Class Items >= ' || '"
		        +costPriceForBClass+"' || '& < ' || '"
		        +costPriceForAClass+"'  as class, MAS_STORE_ITEM_CONVERSION.ITEM_UNIT_NAME from store_item_batch_stock a,store_item_batch_stock b  ,mas_store_item d left outer join STORE_ISSUE_T sit on d.item_id=sit.item_id left outer join MAS_STORE_ITEM_CONVERSION  MAS_STORE_ITEM_CONVERSION on d.ITEM_CONVERSION_ID= MAS_STORE_ITEM_CONVERSION.ITEM_CONVERSION_ID , STORE_ISSUE_M  sim where a.item_id=d.item_id and sim.id= sit.ISSUE_M_ID  and a.cost_price >= b.cost_price and a.cost_price <'"
		        +costPriceForAClass+"' and a.cost_price >='"
		        +costPriceForBClass+"' and sim.issue_date between to_date('"+fromDate +"',"+"'dd-mm-yyyy'"+") and to_date('"+toDate +"',"+"'dd-mm-yyyy'"+")  GROUP BY a.cost_price,d.pvms_no,d.nomenclature,sit.qty_issued,a.item_id,a.stock_id,a.closing_stock,MAS_STORE_ITEM_CONVERSION.ITEM_UNIT_NAME  union"
				+" select a.cost_price,sit.qty_issued,d.pvms_no,d.nomenclature,'smc',a.item_id,a.stock_id,a.closing_stock as stock_qty,a.closing_stock*a.cost_price as value,(a.closing_stock*a.cost_price)*100/'"
		        +sumOfStock+"' as per,SUM((b.closing_stock*b.cost_price)*100/'"
		        +sumOfStock+"') as cum,concat('C Class Items < ','"
		        +costPriceForBClass+"') as class, MAS_STORE_ITEM_CONVERSION.ITEM_UNIT_NAME from store_item_batch_stock a,store_item_batch_stock b ,mas_store_item d left outer join STORE_ISSUE_T sit on d.item_id=sit.item_id left outer join MAS_STORE_ITEM_CONVERSION  MAS_STORE_ITEM_CONVERSION on d.ITEM_CONVERSION_ID= MAS_STORE_ITEM_CONVERSION.ITEM_CONVERSION_ID , STORE_ISSUE_M  sim where a.item_id=d.item_id and sim.id= sit.ISSUE_M_ID  and a.cost_price >= b.cost_price and a.cost_price <100000.0  "
		        +"and sim.issue_date between to_date('"+fromDate +"',"+"'dd-mm-yyyy'"+") and to_date('"+toDate +"',"+"'dd-mm-yyyy'"+")  GROUP BY a.cost_price,d.pvms_no,d.nomenclature,sit.qty_issued, a.item_id,a.stock_id,a.closing_stock,MAS_STORE_ITEM_CONVERSION.ITEM_UNIT_NAME order by cost_price";

			objectList = (List) session.createSQLQuery(qry).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		/*for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
			Object[] object = (Object[]) iterator.next();
			System.out.println("object "+object.length);
			for(int i=0; i<object.length;i++)
			{
			System.out.println("-------"+object[i]);
			}


		}
*/
		map.put("objectList", objectList);
		return map;

	}


	// javed khan

	public Map<String, Object> getResultValue(String pro,int hospitalId) {
		Map<String, Object> result = new HashMap<String, Object>();
		String prob=pro;
		Session session = (Session) getSession();
		List buList=new ArrayList();
		List nivList=new ArrayList();
		List pvmsList=new ArrayList();
		List brandItem=new ArrayList();
		List genItem=new ArrayList();
		List amtBrandItem=new ArrayList();
		List amtGenList=new ArrayList();


//		buList=session.createSQLQuery("SELECT MSB.TOTAL_ALLOCATED_AMOUNT FROM MAS_STORE_BUDGET MSB WHERE MSB.BUDGET_ID=100").list();
		buList=session.createSQLQuery("SELECT MSB.TOTAL_ALLOCATED_AMOUNT FROM MAS_STORE_BUDGET MSB WHERE MSB.HOSPITAL_ID="+hospitalId).list();

		String BudgetAmt="";
		if(buList.size() >0){
			BudgetAmt = buList.get(0).toString();
		}

		nivList=session.createSQLQuery("select count(*) from store_po_header sph left outer join store_po_detail spd on sph.PO_ID=spd.PO_ID,mas_store_item msi  where sph.PO_NUMBER='"+prob+"' and sph.HOSPITAL_ID='"+hospitalId+"' and spd.ITEM_ID=msi.ITEM_ID and msi.ITEM_TYPE_ID=2").list();
		String nivItem="";
		if(nivList.get(0)!=null){
		nivItem=nivList.get(0).toString();
		}



		pvmsList=session.createSQLQuery("select count(*) from store_po_header sph left outer join store_po_detail spd on sph.PO_ID=spd.PO_ID,mas_store_item msi where sph.PO_NUMBER='"+prob+"' and spd.ITEM_ID=msi.ITEM_ID and msi.ITEM_TYPE_ID=1").list();
		String pvmsItem="";
		if(pvmsList.get(0)!=null){
		pvmsItem=pvmsList.get(0).toString();
		}



		brandItem=session.createSQLQuery("select count(*) from store_po_header sph left outer join store_po_detail spd on sph.PO_ID=spd.PO_ID,mas_store_item msi where sph.PO_NUMBER='"+prob+"' and sph.HOSPITAL_ID='"+hospitalId+"' and spd.ITEM_ID=msi.ITEM_ID and msi.BRANDED_GENERIC='B'").list();
		String BrandItem="";
		if(brandItem.get(0)!=null){
		BrandItem=brandItem.get(0).toString();
		}


		genItem=session.createSQLQuery("select count(*) from store_po_header sph left outer join store_po_detail spd on sph.PO_ID=spd.PO_ID,mas_store_item msi where sph.PO_NUMBER='"+prob+"' and spd.ITEM_ID=msi.ITEM_ID and msi.BRANDED_GENERIC='G'").list();
		String genericItem="";
		if(genItem.get(0)!=null){
		genericItem=genItem.get(0).toString();
		}


		amtBrandItem=session.createSQLQuery("select NVL(SUM(spd.AMOUNT ),0.0),NVL(SUM(spd.DISCOUNT_AMOUNT  ),0.0) from store_po_header sph left outer join store_po_detail spd on sph.PO_ID=spd.PO_ID ,mas_store_item msi where sph.PO_NUMBER='"+prob+"' and sph.HOSPITAL_ID='"+hospitalId+"' and spd.ITEM_ID=msi.ITEM_ID and msi.BRANDED_GENERIC='B'").list();
		Iterator itr=amtBrandItem.iterator();
		String amtValueBrand="";
		String disValueBrand="";
		while(itr.hasNext()){
		Object[] tuple = (Object[]) itr.next();
		amtValueBrand=tuple[0].toString();
		disValueBrand=tuple[1].toString();
		}



		amtGenList=session.createSQLQuery("select NVL(SUM(spd.AMOUNT ),0.0),NVL(SUM(spd.DISCOUNT_AMOUNT  ),0.0) from store_po_header sph left outer join store_po_detail spd on sph.PO_ID=spd.PO_ID ,mas_store_item msi where sph.PO_NUMBER='"+prob+"' and spd.ITEM_ID=msi.ITEM_ID and msi.BRANDED_GENERIC='G'").list();
		Iterator itr1=amtGenList.iterator();
		String amtValueGen="";
		String disValueGen="";
		while(itr1.hasNext()){
		Object[] tuple = (Object[]) itr1.next();
		amtValueGen=tuple[0].toString();
		disValueGen=tuple[1].toString();
		}

		result.put("BudgetAmt",BudgetAmt);
		result.put("nivItem",nivItem);
		result.put("pvmsItem",pvmsItem);
		result.put("BrandItem",BrandItem);
		result.put("genericItem",genericItem);
		result.put("amtValueBrand",amtValueBrand);
		result.put("disValueBrand",disValueBrand);
		result.put("amtValueGen",amtValueGen);
		result.put("disValueGen",disValueGen);


		return result;
	}

	@Override
	public Map<String, Object> showLPApprovalJsp(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId=(Integer)dataMap.get("hospitalId");
		int deptId=(Integer)dataMap.get("deptId");
		Session session = (Session) getSession();
		
		
		List<StorePoHeader> poNumberList = new ArrayList<StorePoHeader>();
		poNumberList = session.createCriteria(StorePoHeader.class).add(Restrictions.eq("Department.Id", deptId)).add(Restrictions.eq("Hospital.Id", hospitalId)).add(Restrictions.eq("Status", "p")).addOrder(Order.desc("Id")).list();
		map.put("poNumberList", poNumberList);
		
		return map;
	}

	@Override
	public Map<String, Object> getSoDetailsForApproval(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId=box.getInt("hospitalId");
		int deptId=box.getInt("deptId");
		Session session = (Session) getSession();
		
		List<StorePoHeader> poNumberList = new ArrayList<StorePoHeader>();
		poNumberList = session.createCriteria(StorePoHeader.class).add(Restrictions.eq("Department.Id", deptId)).add(Restrictions.eq("Hospital.Id", hospitalId)).add(Restrictions.eq("Status", "p")).addOrder(Order.desc("Id")).list();
		List<StorePoHeader> poDetailsList = new ArrayList<StorePoHeader>();
		poDetailsList = session.createCriteria(StorePoHeader.class).add(Restrictions.idEq(box.getInt("poId"))).list();
		map.put("poNumberList", poNumberList);
		map.put("poDetailsList", poDetailsList);
		
		return map;
	}

	@Override
	public Map<String, Object> approvePurchaseOrder(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId=box.getInt("hospitalId");
		int deptId=box.getInt("deptId");
		Session session = (Session)getSession();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		boolean flag = false;
		Vector poDetailIds = box.getVector("poDetailId") ;
		Vector itemIds = box.getVector(ITEM_ID) ;

		Vector manufacturerIdArr = box.getVector(MANUFACTURER_ID);
		Vector brandIdArr = box.getVector(BRAND_ID);
		
		Vector actualQty = box.getVector(ACTUAL_QTY);
		Vector quantity = box.getVector(QUANTITY);
		
		Vector discountPer = box.getVector(DISCOUNT_PERCENTAGE);
		Vector discountAmt = box.getVector(DISCOUNT_AMOUNT);
		Vector taxPer = box.getVector(TAX_PERCENT);
		Vector taxAmt = box.getVector(TAX_AMOUNT);
		Vector amt = box.getVector(AMOUNT);
		
		Vector costPrice = box.getVector(COST_PRICE);
		Vector dispenseType = box.getVector("dipenseType");
		Vector mdq = box.getVector("mdq");
		Vector mrp = box.getVector("mrp");
		Vector BG=box.getVector("BG");
		
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			if(itemIds.size() > 0){
				for(int i=0;i<itemIds.size();i++){
					if(!itemIds.get(i).toString().equals("0") &&  poDetailIds.get(i).toString().equals("0")){
						StorePoDetail storePoDetail = new StorePoDetail();
						storePoDetail.setSerialNo(i + 1);
						MasStoreItem masItem = new MasStoreItem();
						masItem.setId(Integer.parseInt(itemIds.get(i).toString()));
						storePoDetail.setItem(masItem);
						if(!quantity.get(i).toString().equals(""))
							storePoDetail.setQuantityOrdered(new BigDecimal(quantity.get(i).toString()));
						if(!discountPer.get(i).toString().equals(""))
							storePoDetail.setDiscountPercent(new BigDecimal(discountPer.get(i).toString()));
						if(!discountAmt.get(i).toString().equals(""))
							storePoDetail.setDiscountAmount(new BigDecimal(discountAmt.get(i).toString()));
						if(!taxPer.get(i).toString().equals(""))
							storePoDetail.setTaxPercent(new BigDecimal(taxPer.get(i).toString()));
						if(!taxAmt.get(i).toString().equals(""))
							storePoDetail.setTaxAmount(new BigDecimal(taxAmt.get(i).toString()));
						if(!amt.get(i).toString().equals(""))
							storePoDetail.setAmount(new BigDecimal(amt.get(i).toString()));

						if (manufacturerIdArr.get(i)!=null && !manufacturerIdArr.get(i).equals(""))
						{
							MasManufacturer masManufacturer = new MasManufacturer();
							masManufacturer.setId(Integer
									.parseInt(manufacturerIdArr.get(i).toString()));
							storePoDetail.setManufacturer(masManufacturer);
						}

						storePoDetail.setNotes("");
						
						if (brandIdArr.get(i)!=null && !brandIdArr.get(i).equals("")) {
							MasStoreBrand masStoreBrand = new MasStoreBrand();
							masStoreBrand.setId(Integer.parseInt(brandIdArr.get(i)
									.toString()));
							storePoDetail.setBrand(masStoreBrand);
						}
						try {
							storePoDetail.setMrp(new BigDecimal(mrp.get(i).toString()));
						} catch (Exception e) {
							storePoDetail.setMrp(new BigDecimal(0));
						}
						if(!actualQty.get(i).toString().equals(""))
							storePoDetail.setLsoQty(new BigDecimal(actualQty.get(i).toString()));
					
						if(!costPrice.get(i).toString().equals(""))
							storePoDetail.setUnitRate(new BigDecimal(costPrice.get(i).toString()));

					StorePoHeader poHeader = new StorePoHeader();
					poHeader.setId( box.getInt("poId"));
					storePoDetail.setPo(poHeader);
					
					storePoDetail.setDispType(dispenseType.get(i).toString());
					if(!mdq.get(i).toString().equals(""))
						storePoDetail.setMdqValue(new BigDecimal(mdq.get(i).toString()));
					storePoDetail.setBrandedGeneric(BG.get(i).toString());
						
					hbt.save(storePoDetail);
					}
					
				}
				StorePoHeader storePoHeader = (StorePoHeader)hbt.load(StorePoHeader.class,  box.getInt("poId"));
				storePoHeader.setStatus("o");
				storePoHeader.setApprovalAuthority(box.getString("empName"));
				hbt.update(storePoHeader);
				map.put("PONO", storePoHeader.getPoNumber()); // add by javed khan on 21-10-2013
				
			}
			tx.commit();
			flag = true;
			
		} catch (NumberFormatException e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		} catch (DataAccessException e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		map.put("flag", flag);
	
		
		return map;
	}

	@Override
	public Map<String, Object> deletePoDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId=box.getInt("hospitalId");
		int deptId=box.getInt("deptId");
		Session session = (Session) getSession();
		boolean flag = false;
		Transaction tx= null;
		try {
			tx= session.beginTransaction();
			String deletedIds = box.getString("deletedIds");

			String qry = "delete from StorePoDetail as spd where spd.Id in ("+deletedIds+")";
			session.createQuery(qry).executeUpdate();
			tx.commit();
			flag = true;
		} catch (HibernateException e) {
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}
		map.put("flag", flag);
		return map;
	}
	
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> getItemListForPurchaseOrderNew(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List<MasStoreItem> itemList1 = new ArrayList<MasStoreItem>();
		List objectList = new ArrayList();
		int hospitalId=0;
		Session session = (Session) getSession();
		int deptId = 0;
		int poId = 0;

		hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		deptId = Integer.parseInt("" + dataMap.get("deptId"));
		poId = Integer.parseInt("" + dataMap.get("poId"));
		try {
			String str =dataMap.get("autoHint").toString();
			str="%"+str.toUpperCase()+ "%";
			
			
			itemList=getHibernateTemplate().find("select item from jkt.hms.masters.business.MasStoreItem as item where upper(item.Nomenclature) like '"+str+"' and status='y' and prescribed_from ='o' and item_classification_id=1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("itemList", itemList);
		return map;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> getItemListForPurchaseOrderMR(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List<MasStoreItem> itemList1 = new ArrayList<MasStoreItem>();
		List objectList = new ArrayList();
		int hospitalId=0;
		Session session = (Session) getSession();
		int deptId = 0;
		int poId = 0;

		hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		deptId = Integer.parseInt("" + dataMap.get("deptId"));
		poId = Integer.parseInt("" + dataMap.get("poId"));
		try {
			String str =dataMap.get("autoHint").toString();
			str="%"+str.toUpperCase()+ "%";
			
			
			itemList=getHibernateTemplate().find("select item from jkt.hms.masters.business.MasStoreItem as item where upper(item.Nomenclature) like '"+str+"' and status='y' and item_classification_id=1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("itemList", itemList);
		return map;
	}
	
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> getItemListForPurchaseOrderForFAC(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List<MasStoreItem> itemList1 = new ArrayList<MasStoreItem>();
		List objectList = new ArrayList();
		int hospitalId=0;
		Session session = (Session) getSession();
		int deptId = 0;
		int poId = 0;

		hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		deptId = Integer.parseInt("" + dataMap.get("deptId"));
		poId = Integer.parseInt("" + dataMap.get("poId"));
		try {
			String str =dataMap.get("autoHint").toString();
			str="%"+str.toUpperCase()+ "%";
			
			
			itemList=getHibernateTemplate().find("select item from jkt.hms.masters.business.MasStoreItem as item where upper(item.Nomenclature) like '"+str+"' and status='y' and  prescribed_from ='o' and item_classification_id=1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("itemList", itemList);
		return map;
	}
	

}
