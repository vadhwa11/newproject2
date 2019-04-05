package jkt.hms.stores.dataservice;

import static jkt.hms.util.RequestConstants.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;

import jkt.hms.masters.business.StoreInternalIndentM;
import jkt.hms.masters.business.StoreIssueM;
import jkt.hms.masters.business.StoreIssueT;
import jkt.hms.masters.business.StoreLoanOutM;
import jkt.hms.masters.business.MasDiscount;
import jkt.hms.masters.business.MasItemCategory;
import jkt.hms.masters.business.MasMedicalExaminationReportOnEntry;
import jkt.hms.masters.business.MasRepairStation;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasManufacturer;
import jkt.hms.masters.business.MasStoreAirForceDepot;
import jkt.hms.masters.business.MasStoreBrand;
import jkt.hms.masters.business.MasStoreBudget;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasStoreItemConversion;
import jkt.hms.masters.business.MasStoreMeScale;
import jkt.hms.masters.business.MasStoreSection;
import jkt.hms.masters.business.MasStoreSupplier;
import jkt.hms.masters.business.MasSubChargecode;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PatientInvestigationDetails;
import jkt.hms.masters.business.StoreAmcM;
import jkt.hms.masters.business.StoreAmcT;
import jkt.hms.masters.business.StoreBosM;
import jkt.hms.masters.business.StoreBosT;
import jkt.hms.masters.business.StoreCondemnationM;
import jkt.hms.masters.business.StoreCondemnationT;
import jkt.hms.masters.business.StoreFyDocumentNo;
import jkt.hms.masters.business.StoreGrnM;
import jkt.hms.masters.business.StoreGrnT;
import jkt.hms.masters.business.StoreIndentM;
import jkt.hms.masters.business.StoreIndentT;
import jkt.hms.masters.business.StoreItemBatchStock;
import jkt.hms.masters.business.StoreLoanOutT;
import jkt.hms.masters.business.StoreLoaninM;
import jkt.hms.masters.business.StoreLoaninT;
import jkt.hms.masters.business.StoreLoanoutExpendM;
import jkt.hms.masters.business.StoreLoanoutExpendT;
import jkt.hms.masters.business.StoreMeScaleDetails;
import jkt.hms.masters.business.StoreMmfDepartmentT;
import jkt.hms.masters.business.StorePoDetail;
import jkt.hms.masters.business.StorePoHeader;
import jkt.hms.masters.business.StoreRepairCivilFirm;
import jkt.hms.masters.business.StoreSetup;
import jkt.hms.masters.business.StoreWorkOrderM;
import jkt.hms.masters.business.StoreWorkOrderT;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.PageUtil;
import jkt.hms.util.PagedArray;
import jkt.hms.util.RequestConstants;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lowagie.text.pdf.codec.postscript.ParseException;

//import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class NonExpendableStoresDataServiceImpl extends HibernateDaoSupport
		implements NonExpendableStoresDataService {

	HibernateTransactionManager transactionManager = null;
	Session session;

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
		if ((no == null) || (no.equals("0"))) {
			no = "";
		}
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
					if (tempMonth < 10) {
						maxNo = "0" + tempMonth + "/" + y1 + "-" + y2;
					} else {
						maxNo = tempMonth + "/" + y1 + "-" + y2;
					}
				} else {
					if (tempMonth < 10) {
						maxNo = "0" + tempMonth + "/" + y2 + "-" + y3;
					} else {
						maxNo = tempMonth + "/" + y2 + "-" + y3;
					}
				}

			} else {
				if (currentMonth < 4) {
					maxNo = "01" + "/" + y1 + "-" + y2;
				} else {
					maxNo = "01" + "/" + y2 + "-" + y3;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maxNo;
	}
	// --- for non expendable grn

	public Map<String, Object> showNeGrnJsp(Box box, Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		if (dataMap.get("deptId") != null)
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		if (dataMap.get("hospitalId") != null)
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		if (dataMap.get("userName") != null)
			userName = ("" + dataMap.get("userName"));

		List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
		List<MasManufacturer> manufacturerList = new ArrayList<MasManufacturer>();
		List<StoreGrnM> searchGrnList = new ArrayList<StoreGrnM>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<StoreIndentM> indentForAfmsdList = new ArrayList<StoreIndentM>();
		List<MasStoreAirForceDepot> unitList = new ArrayList<MasStoreAirForceDepot>();
		List<StoreGrnM> grnList = new ArrayList<StoreGrnM>();
		List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
		List<MasStoreMeScale> meScaleList = new ArrayList<MasStoreMeScale>();
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();

		int poId = 0;
		String max = "";
		String startNo = "";
		String no = "";

		Session session = (Session) getSession();
		try {
			/*supplierList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasStoreSupplier as ms where ms.Status = 'y'");
			manufacturerList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasManufacturer as mi where mi.Status = 'y'");
			searchGrnList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreGrnM as mi where mi.Department.Id='"
							+ deptId + "'");
		*/
//commented By Ujjwal
			/*			employeeList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasEmployee as mi where mi.Status = 'y'");
*/		/*
		 * By Ujjwal for sql injection
		 */
			employeeList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
			
			/*indentForAfmsdList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreIndentM as mi where mi.IndentType = 'd'");*/
/*			meScaleList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasStoreMeScale as me where me.Status = 'y'");
*/
			/*
			 *By Ujjwal For Sql Injection 
			 */
			meScaleList=session.createCriteria(MasStoreMeScale.class).add(Restrictions.eq("Status", "y")).list();
			
			
			/*unitList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasStoreAirForceDepot as mi where mi.Status = 'y'");*/
			unitList=session.createCriteria(MasStoreAirForceDepot.class).add(Restrictions.eq("Status", "y")).list();
			/*grnList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreGrnM as sgm");
			brandList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasStoreBrand as msb");*/
			storeFyDocumentNoList = session.createCriteria(
					StoreFyDocumentNo.class)
					.add(Restrictions.eq("Department.Id", deptId))
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.list();
			for (StoreFyDocumentNo storeFyDocumentNo : storeFyDocumentNoList) {
				if (storeFyDocumentNo.getGrnNo() != null) {
					no = ("" + storeFyDocumentNo.getGrnNo());
					no = getMaxNo(no);
				} else {
					no = getMaxNo("");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("supplierList", supplierList);
		map.put("manufacturerList", manufacturerList);
		map.put("searchGrnList", searchGrnList);
		map.put("employeeList", employeeList);
		map.put("indentForAfmsdList", indentForAfmsdList);
		map.put("unitList", unitList);
		map.put("grnList", grnList);
		map.put("brandList", brandList);
		map.put("meScaleList", meScaleList);
		map.put("max", no);
		return map;

	}

	// add grn method
	public boolean addGrns(Map<String, Object> infoMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		StoreGrnM storeGrnM = (StoreGrnM) infoMap.get("storeGrnM");
		MasStoreBudget masStoreBudget = (MasStoreBudget) infoMap
				.get("masStoreBudget");
		List<StoreGrnT> storeGrnTlist = (ArrayList<StoreGrnT>) infoMap
				.get("storeGrnTlist");
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		String userName = "";
		int deptId = 0;
	  int hospitalId = 0;
		String max = "";
		String no = "";
		Box box=(Box)infoMap.get("box");
		if (infoMap.get("deptId") != null)
			deptId = Integer.parseInt("" + infoMap.get("deptId"));
		// if(infoMap.get("hospitalId") !=null)
		 hospitalId = Integer.parseInt(""+infoMap.get("hospitalId"));
		// if(infoMap.get("userName") !=null)
		// userName = (""+infoMap.get("userName"));
		int storeFyId = 0;

		boolean successfullyAdded = false;
		StoreGrnM storeGrnM2 = new StoreGrnM();
		int indentId = 0;
		if (infoMap.get("indentId") != null) {
			indentId = Integer.parseInt("" + infoMap.get("indentId"));
		}
		String sos = "";
		if (infoMap.get("sourceOfSupply") != ""
				|| infoMap.get("sourceOfSupply") != null) {
			sos = (String) infoMap.get("sourceOfSupply");
		}
		session = (Session) getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
				hbt.save(storeGrnM);
				String grnNo = "";
				grnNo = (String) infoMap.get("grnNo");
				// javed khan 
				Criteria c = session.createCriteria(StoreFyDocumentNo.class)
						.add(Restrictions.eq("Department.Id", deptId))
						.add(Restrictions.eq("Hospital.Id", hospitalId));
				storeFyDocumentNoList = c.list();
				for (StoreFyDocumentNo documentNo : storeFyDocumentNoList) {
					storeFyId = documentNo.getId();
				}
				StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) getHibernateTemplate()
						.load(StoreFyDocumentNo.class, storeFyId);
				storeFyDocumentNo.setGrnNo(grnNo);
				hbt.update(storeFyDocumentNo);

				HibernateTemplate hbt3 = getHibernateTemplate();
				hbt3.setFlushModeName("FLUSH_EAGER");
				hbt3.setCheckWriteOperations(false);
				if ((sos.equalsIgnoreCase("g"))) {
					StoreIndentM storeIndentM = (StoreIndentM) getHibernateTemplate()
							.load(StoreIndentM.class, indentId);
					storeIndentM.setStatus("p");
					hbt3.update(storeIndentM);
				}

				List<MasStoreBudget> grnList = new ArrayList<MasStoreBudget>();
				int tempId = 0;
				grnList = hbt
						.find("from jkt.hms.masters.business.MasStoreBudget");
				for (MasStoreBudget masStoreBudget2 : grnList) {

					tempId = Integer.parseInt("" + masStoreBudget2.getId());
					BigDecimal bigDecimal = new BigDecimal(""
							+ storeGrnM.getGrnValue());

					/*String qry = "update mas_store_budget as s set s.crv_comitted_amount =(s.crv_comitted_amount+'"
							+ bigDecimal
							+ "') where budget_id='"
							+ tempId
							+ "' ";
					Query query2 = session.createSQLQuery(qry);
					int row2 = query2.executeUpdate();*/
					
					// javed khan 
					MasStoreBudget msb = (MasStoreBudget) hbt.load(
							MasStoreBudget.class, tempId);
					msb.setCrvComittedAmount(bigDecimal);
					hbt.update(msb);
					hbt.refresh(msb);
					
				}

			

			List<StoreItemBatchStock> storeItemBatchStockList = new ArrayList<StoreItemBatchStock>();
			StoreItemBatchStock storeItemBatchStock = null;

			
			
			//int sizeOfArray=(Integer)infoMap.get("sizeOfArray");
			Vector srno = box.getVector(SR_NO);
			Vector pvms = box.getVector(ITEM_CODE);
			Vector items = box.getVector(ITEM_ID);
			Vector<String> itemName=box.getVector("nameItem");
			Vector au = box.getVector(AV);
			Vector serialNo = box.getVector(BATCH_NO);
			Vector manufactureId = box.getVector(MANUFACTURER_ID);
			Vector lotNo = box.getVector(LOT_NO);
			Vector freeItem = box.getVector(FREE_ITEM);
			Vector freeQty=box.getVector(FREE_QTY);
			Vector taxPer = box.getVector(TAX_PERCENT);
			Vector unitRate = box.getVector(UNIT_RATE);
			Vector discountPercentage = box.getVector(DISCOUNT_PERCENTAGE);
			Vector amount = box.getVector(AMOUNT);
			Vector quantityReceived = box.getVector(QUANTITY_RECEIVED);
			Vector costPrice = box.getVector(COST_PRICE);
			Vector manufactureDate = box.getVector(MANUFACTURING_DATE);
			Vector expiryDate = box.getVector(EXPIRY_DATE);
			Vector AmcStartDate = box.getVector("AmcStartDate");
			Vector WarrantyDate = box.getVector("WarrantyDate");
			Vector InstallationDate = box.getVector("InstallationDate");
			
			
			
			
				for (int i = 0; i < items.size(); i++) {
					if(items.get(i)!="")
					{
					StoreGrnT storeGrnTObj = new StoreGrnT();
					
				
						storeGrnTObj.setGrnMaster(storeGrnM);
				
					
					
					
					//storeGrnTObj.setSerialNo (new Integer(serialNo.get(i).toString()));
						storeGrnTObj.setBatchNo(serialNo.get(i).toString());
					MasStoreItem masStoreItem=new MasStoreItem();
					masStoreItem.setId(new Integer(items.get(i).toString()));
					storeGrnTObj.setItem(masStoreItem);
					MasManufacturer masManufacturer = new MasManufacturer();
					masManufacturer.setId(new Integer(manufactureId.get(i).toString()));
					storeGrnTObj.setManufacturer(masManufacturer);
					storeGrnTObj.setReceivedQty(new BigDecimal(quantityReceived.get(i).toString()));
					//storeGrnTObj.setTax(new BigDecimal(taxPer.get(i).toString()));
					storeGrnTObj.setAmountValue(new BigDecimal(amount.get(i).toString()));
					storeGrnTObj.setUnitRate(new BigDecimal(unitRate.get(i).toString()));
					//storeGrnTObj.setLotNo(lotNo.get(i).toString());
					storeGrnTObj.setDiscount(new BigDecimal(discountPercentage.get(i).toString()));
					storeGrnTObj.setFinalCostPrice(new BigDecimal(0));
					storeGrnTObj.setManufacturerDate(HMSUtil.convertStringTypeDateToDateType(manufactureDate.get(i).toString()));
					//storeGrnTObj.setExpiryDate(HMSUtil.convertStringTypeDateToDateType(expiryDate.get(i).toString()));
					storeGrnTObj.setAmcStartDate((AmcStartDate.get(i).toString()));
					storeGrnTObj.setWarrantyDate((WarrantyDate.get(i).toString()));
				//	storeGrnTObj.setInstallationDate(InstallationDate.get(i).toString());
					
					//storeGrnTObj.setFreeQty(new Integer(freeQty.get(i).toString()));
					
					//storeGrnTObj.setFreeItem(freeItem.get(i).toString());
					hbt.save(storeGrnTObj);
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);

					int item_id = storeGrnTObj.getItem().getId();
					String batch_no = "";
					String batch_no1 = "";
					batch_no = storeGrnTObj.getLotNo();
					batch_no1 = storeGrnTObj.getBatchNo();
					int department_id = storeGrnM.getDepartment().getId();
					BigDecimal cost_price = storeGrnTObj.getFinalCostPrice();

					/*
					 * Commented BY Ujjwal
					 */
					/*storeItemBatchStockList = hbt
							.find("from jkt.hms.masters.business.StoreItemBatchStock as inp where inp.Item.Id = "
									+ item_id
									+ "and inp.Department.Id= "
									+ department_id
									+ "and inp.BatchNo ='"
									+batch_no1+"'");*/
									//+ batch_no.valueOf(batch_no1));
					/*
					 *  BY Ujjwal For SQL Injection
					 */
									
					storeItemBatchStockList=session.createCriteria(StoreItemBatchStock.class)	
												   .add(Restrictions.eq("Item.Id", item_id))
												   .add(Restrictions.eq("Department.Id", department_id))
												   .add(Restrictions.eq("BatchNo", batch_no1))
												   .list();
					
					//end By Ujjwal
					if (storeItemBatchStockList != null
							&& storeItemBatchStockList.size() > 0) {

						int free_qty = 0;
						//free_qty = storeGrnTObj.getFreeQty();
						storeItemBatchStock = storeItemBatchStockList.get(0);
						BigDecimal existing_qty = storeItemBatchStock
								.getReceivedQty();
						BigDecimal recd_qty = storeGrnTObj.getReceivedQty();

						BigDecimal new_qty = new BigDecimal(0);
						new_qty = existing_qty.add(recd_qty);
						BigDecimal existing_closing_stock = storeItemBatchStock
								.getClosingStock();
						BigDecimal new_closing_stock = new BigDecimal(0);
						new_closing_stock = existing_closing_stock
								.add(recd_qty);
						BigDecimal cost_prices = storeItemBatchStock
								.getCostPrice();

						int id = storeItemBatchStock.getId();
						storeItemBatchStock = (StoreItemBatchStock) getHibernateTemplate()
								.load(StoreItemBatchStock.class, id);
						storeItemBatchStock.setReceivedQty(new_qty
								.add(new BigDecimal(free_qty)));
						storeItemBatchStock.setClosingStock(new_closing_stock
								.add(new BigDecimal(free_qty)));
						/*storeItemBatchStock.setBatchNo(storeGrnTObj
								.getLotNo());*/
						storeItemBatchStock.setItem(storeGrnTObj.getItem());
						if (storeItemBatchStock.getCostPrice() != null) {
							BigDecimal new_cost_price = new BigDecimal(0);
							new_cost_price = cost_prices.add(cost_price);
							storeItemBatchStock.setCostPrice(new_cost_price);
						} else {
							storeItemBatchStock.setCostPrice(null);
						}
						MasHospital masHospital = new MasHospital();
						masHospital.setId(hospitalId);
						storeItemBatchStock.setHospital(masHospital);
					
						
						HibernateTemplate hbt1 = getHibernateTemplate();
						hbt1.setFlushModeName("FLUSH_EAGER");
						hbt1.setCheckWriteOperations(false);
						hbt1.update(storeItemBatchStock);

					} else {
						storeItemBatchStock = new StoreItemBatchStock();
						storeItemBatchStock.setDepartment(storeGrnM
								.getDepartment());
						storeItemBatchStock.setLotNo(storeGrnTObj.getLotNo());
						storeItemBatchStock.setReceivedQty(storeGrnTObj
								.getReceivedQty());
						storeItemBatchStock.setFreeItem(storeGrnTObj
								.getFreeItem());
						storeItemBatchStock.setClosingStock(storeGrnTObj
								.getReceivedQty());
						storeItemBatchStock.setItem(storeGrnTObj.getItem());
						
						
						//if (storeGrnTObj.getLotNo().equals("0")) {
						
						// comment by javed khan
						/*if (storeGrnTObj.getLotNo()==null) {
							storeItemBatchStock.setCostPrice(storeGrnTObj
									.getFinalCostPrice());
							storeItemBatchStock.setBatchNo("0");
						} else {
							storeItemBatchStock.setBatchNo(storeGrnTObj
									.getLotNo());
							storeItemBatchStock.setCostPrice(new BigDecimal(0));
						}*/
						
						//added by javed khan 
						storeItemBatchStock.setBatchNo(storeGrnTObj.getBatchNo());
						storeItemBatchStock.setCostPrice(new BigDecimal(0));
						
						HibernateTemplate hbt1 = getHibernateTemplate();
						hbt1.setFlushModeName("FLUSH_EAGER");
						hbt1.setCheckWriteOperations(false);
						hbt1.save(storeItemBatchStock);
					}
				}
					else
					{
						break;
					}
			
				}
				
				
				
				
				
				
				Criteria c1 = session.createCriteria(StoreFyDocumentNo.class).add(
						Restrictions.eq("Department.Id", deptId));
				storeFyDocumentNoList = c1.list();
				/*String grnStartNo = "";
				for (StoreFyDocumentNo storeFyDocumentNo1 : storeFyDocumentNoList) {
					if (storeFyDocumentNo1.getGrnNo() != null) {
						grnStartNo = ("" + storeFyDocumentNo.getGrnNo());
						grnStartNo = getMaxNo(grnStartNo);
					} else {
						grnStartNo = getMaxNo("");
					}
				}
				//storeGrnM.setGrnNo(grnStartNo);

				*/

				for (StoreFyDocumentNo documentNo : storeFyDocumentNoList) {
					storeFyId = documentNo.getId();
				}
				 storeFyDocumentNo = (StoreFyDocumentNo) getHibernateTemplate()
						.load(StoreFyDocumentNo.class, storeFyId);
				
				
					storeFyDocumentNo.setGrnNo(grnNo);
				
				storeFyDocumentNo.setGrnStartNo(grnNo);
				hbt.update(storeFyDocumentNo);
				hbt.refresh(storeFyDocumentNo);

			successfullyAdded = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			// throw e; // or display error message
			e.printStackTrace();
		}
		map.put("maxIndentNo", no);

		return successfullyAdded;

	}

	// end of add method
	public Map<String, Object> getListForNeGrn(String choice) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
		List<StoreIndentM> indentMList = new ArrayList<StoreIndentM>();
		List<MasStoreAirForceDepot> unitList = new ArrayList<MasStoreAirForceDepot>();
		session = (Session) getSession();
		
		if (choice.equalsIgnoreCase("s") || choice.equalsIgnoreCase("d")) {
			
			
			indentMList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreIndentM as si where si.Status= 'o'");
			map.put("indentMList", indentMList);
		}
		
		if (choice.equalsIgnoreCase("b") || choice.equalsIgnoreCase("c")) {
			supplierList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasStoreSupplier as mi where mi.Status= 'y'");
			map.put("first_combo", supplierList);
		} 
		/*else if (choice.equalsIgnoreCase("D")) {
			unitList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasStoreAirForceDepot as mi where mi.Status= 'y'and mi.AirForceDepotType='d'");
			map.put("first_combo", unitList);

		} else if (choice.equalsIgnoreCase("s")) {
			supplierList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasStoreSupplier as mi where mi.Status= 'y'");
			map.put("first_combo", supplierList);}*/
		  if (choice.equalsIgnoreCase("a") || choice.equalsIgnoreCase("d")) {
			unitList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasStoreAirForceDepot as mi where mi.Status= 'y'");
			map.put("first_combo", unitList);
		} else {
			supplierList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasStoreSupplier as mi where mi.Status= 'y'");
			map.put("first_combo", supplierList);
		}
		map.put("choice", choice);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map getResponseIndentList(Box box) {

		Map map = new HashMap();
		List<StoreIndentM> indentList = new ArrayList<StoreIndentM>();
		map.put("choice", box.getString(SOURCE_OF_SUPPLY));

		if (box.getString(SOURCE_OF_SUPPLY).equalsIgnoreCase("a")) {
			indentList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreIndentM as md where md.IndentType ='d' and md.SuppliedBy.Id = "
									//+ box.getInt(SUPPLIER_ID)
									+box.getInt("UnitName")
									+ " and md.Department.Id = "
									+ box.getInt("deptId"));
			map.put("second_combo", indentList);
		}
		if (box.getString(SOURCE_OF_SUPPLY).equalsIgnoreCase("S")) {
			indentList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreIndentM as mi where mi.IndentType ='s' and mi.SuppliedBy.Id = "
									+ box.getInt(SUPPLIER_ID)
									+ " and mi.Department.Id = "
									+ box.getInt("deptId"));
			map.put("second_combo", indentList);
		}
		return map;
	}

	public Map<String, Object> showGridJsp(Box box) {

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();

		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();

		List<StoreIndentT> storeIndentTList = new ArrayList<StoreIndentT>();
		List<StorePoDetail> storePoDetailList = new ArrayList<StorePoDetail>();

		int poId = 0;
		String max = "";
		String startNo = "";
		String no = "";

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			if (box.getString("sourceOfSupply").equals("d")) {
				// indent
				storeIndentTList = hbt
						.find("from jkt.hms.masters.business.StoreIndentT as inp where inp.Indent.Id = "
								+ box.getInt("indentId")
								+ " and inp.Indent.IndentType='d' ");
				for (Iterator iterator = storeIndentTList.iterator(); iterator
						.hasNext();) {
					StoreIndentT storeIndentT = (StoreIndentT) iterator.next();
					itemList.add(storeIndentT.getItem());

				}
			} else if (box.getString("sourceOfSupply").equals("s")) {
				// indent
				storeIndentTList = hbt
						.find("from jkt.hms.masters.business.StoreIndentT as inp where inp.Indent.Id = "
								+ box.getInt("indentId")
								+ " and inp.Indent.IndentType !='d' ");
				for (Iterator iterator = storeIndentTList.iterator(); iterator
						.hasNext();) {
					StoreIndentT storeIndentT = (StoreIndentT) iterator.next();
					itemList.add(storeIndentT.getItem());

				}
			}

			else if (box.getString("sourceOfSupply").equals("g")
					|| box.getString("sourceOfSupply").equals("m")) {
				itemList = hbt
						.find("from jkt.hms.masters.business.MasStoreItem");
			} else if (box.getString("sourceOfSupply").equals("p")) {
				// store po detail
				storePoDetailList = hbt
						.find("from jkt.hms.masters.business.StorePoDetail as inp where inp.Po.Id = "
								+ box.getInt("indentId"));
				for (Iterator iterator = storePoDetailList.iterator(); iterator
						.hasNext();) {
					StorePoDetail storePoDetail = (StorePoDetail) iterator
							.next();
					itemList.add(storePoDetail.getItem());
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		if (itemList != null && itemList.size() > 0) {
			for (Iterator iterator = itemList.iterator(); iterator.hasNext();) {
				MasStoreItem masStoreItem = (MasStoreItem) iterator.next();

			}
		}

		map.put("itemList", itemList);

		return map;

	}

	// --------- new GRid----------------------

	public Map<String, Object> getItemListForGrnByAutocomplete(
			Map<String, Object> dataMap) {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		Box box = (Box) dataMap.get("box");
		String sos = box.getString("sourceOfSupply").trim();
		String pvmsNo = null;
		int deptId = 0;
		int indentId = 0;
		int hospitalId = 0;
		deptId = Integer.parseInt("" + dataMap.get("deptId"));
		indentId = Integer.parseInt("" + dataMap.get("indentId"));
		hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		List objectList = new ArrayList();
		try {
			String str = dataMap.get("autoHint") + "%";
			if (sos.equalsIgnoreCase("s")) {
				String qry = "Select item_id from store_indent_t where indent_id in(select indent_id  from store_indent_m where indent_id ='"
						+ indentId + "')";
				objectList = (List) session.createSQLQuery(qry).list();

				Criteria c = session.createCriteria(MasStoreItem.class).add(
						Restrictions.like("Nomenclature", str)).add(
						Restrictions.eq("Department.Id", deptId)).add(Restrictions.eq("TypeOfItem", "NE")).add(
								Restrictions.eq("Hospital.Id", hospitalId));
						//.add(	Restrictions.in("Id", objectList));
				c.setFirstResult(0);
				c.setMaxResults(10);
				itemList = c.list();
				
			}
			if ((sos.equalsIgnoreCase("a")) || sos.equalsIgnoreCase("b")
					|| sos.equalsIgnoreCase("c")) {

				// ********** comment by javed khan
				
				/*
				
				String qry = "Select item_id from mas_store_item where department_id ="
						+ deptId + "";
				objectList = (List) session.createSQLQuery(qry).list();
				Criteria c = session.createCriteria(MasStoreItem.class).add(
						Restrictions.like("Nomenclature", str)).add(
						Restrictions.eq("Department.Id", deptId));
						//.add(
						//Restrictions.in("Id", objectList));
						 
						 */
				
				itemList = getHibernateTemplate().find("select item from jkt.hms.masters.business.MasStoreItem as item where upper(item.Nomenclature) like '"+str+"' and TypeOfItem='NE'  and item.ItemType.Id='2'and item.Hospital.Id='"+hospitalId+"'  and rownum < 15");
				/*Criteria c = session.createCriteria(MasStoreItem.class).add(
						Restrictions.like("Nomenclature", str).ignoreCase()).add(
								Restrictions.eq("TypeOfItem", "NE")).add(
						Restrictions.eq("Hospital.Id", hospitalId));*/
				//c.setFirstResult(0);
				//c.setMaxResults(10);
				//itemList = c.list();
				
			}

			if (sos.equalsIgnoreCase("d")) {
				
			/*	String qry = "Select item_id from store_indent_t where indent_id in(select indent_id  from store_indent_m where indent_id ='"
						+ indentId + "')";
				objectList = (List) session.createSQLQuery(qry).list();
				Criteria c = session.createCriteria(MasStoreItem.class).add(
						Restrictions.like("Nomenclature", str)).add(
						Restrictions.eq("Department.Id", deptId));*/
						//.add(
						//Restrictions.in("Id", objectList));
				
				// add by javed khan
				
				Criteria c = session.createCriteria(MasStoreItem.class).add(
						Restrictions.like("Nomenclature", str).ignoreCase()).add(
								Restrictions.eq("TypeOfItem", "NE")).add(
						Restrictions.eq("Hospital.Id", hospitalId));
				
				c.setFirstResult(0);
				c.setMaxResults(10);
				itemList = c.list();
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("itemList", itemList);
		return map;
	}

	public Map<String, Object> fillItemsForGrn(Map<String, Object> dataMap) {

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
		session = (Session) getSession();
		String pvms = null;

		int deptId = 0;
		if (dataMap.get("deptId") != null) {
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		}
		int indentId = 0;
		if (dataMap.get("indentId") != null) {
			indentId = Integer.parseInt("" + dataMap.get("indentId"));
		}
		int itemId1=0;
		if (dataMap.get("itemId") != null) {
			itemId1 = Integer.parseInt("" + dataMap.get("itemId"));
		}
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			String queryString = null;
			String str = "" + dataMap.get("nomenclature");
			StringBuffer output_str = new StringBuffer();
			StringTokenizer s = new StringTokenizer(str, "%");

			while (s.hasMoreTokens()) {
				output_str.append(s.nextToken());
				if (s.hasMoreTokens()) {
					output_str.append("\\%");
				}
			}

			Criteria c = session.createCriteria(MasStoreItem.class);
			//.add(Restrictions.eq("PvmsNo", str));
			itemList = c.list();
			
			
			Criteria c1 = session.createCriteria(MasStoreBrand.class).add(
					Restrictions.eq("Item.Id", itemId1));
			brandList = c1.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		try {
			int itemId = 0;
			for (MasStoreItem masStoreItem : itemList) {
				itemId = masStoreItem.getId();

			}
			map.put("itemList", itemList);
			map.put("brandList", brandList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;

	}

	public Map searchGrn(Map searchFieldMap){
		Map<String, Object> map = new HashMap<String, Object>();
		String fromDate = "";
		String toDate = "";
		List<StoreGrnM> gridGrnHeaderList = new ArrayList<StoreGrnM>();
		List<StoreGrnT> gridGrnDetailList = new ArrayList<StoreGrnT>();
		String grnNo = "";
		session = (Session) getSession();
		Criteria c = session.createCriteria(StoreGrnM.class);
		try {
			if ((!searchFieldMap.get("fromDate").equals(""))
					&& (!searchFieldMap.get("toDate").equals(""))) {
				
				fromDate = (String) searchFieldMap.get("fromDate");
				toDate = (String) searchFieldMap.get("toDate");
				/*SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
				String date4MySQL1 = formatterOut.format(formatterIn
						.parse(fromDate));
				String date4MySQL2 = formatterOut.format(formatterIn
						.parse(toDate));
				java.sql.Date startDate = java.sql.Date.valueOf(date4MySQL1);
				java.sql.Date endDate = java.sql.Date.valueOf(date4MySQL2);*/
				
				  SimpleDateFormat formatterIn = new SimpleDateFormat(
			      "dd/MM/yyyy");
			    SimpleDateFormat formatterOut = new SimpleDateFormat(
			      "yyyy-MM-dd");
			    String date4MySQL2 = formatterOut.format(formatterIn
			      .parse(toDate));
			    String date4ToMySQL = formatterOut.format(formatterIn.parse(toDate));
			    Date datestr1 = java.sql.Date.valueOf(date4ToMySQL);
			    SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			    String eDate=sdf.format(datestr1);
			    Date endDate=sdf.parse(eDate);

			    String date4MySQL = formatterOut.format(formatterIn.parse(fromDate));
			    Date datestr = java.sql.Date.valueOf(date4MySQL);
			    SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yyyy");
			    String sDate=sdf1.format(datestr);
			    Date startDate=sdf1.parse(sDate);

			    /*gridGrnDetailList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.StoreGrnT ");
				gridGrnHeaderList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.StoreGrnM as poh where "
								+ " poh.GrnDate between '" + startDate
								+ "' and '" + endDate + "'");*/
			
				c.add(Restrictions.between("GrnDate", startDate, endDate));

			}
			
			if (!searchFieldMap.get("grnNo").equals("")
					&& !searchFieldMap.get("grnNo").equals(0)) {
				grnNo = (String) searchFieldMap.get("grnNo");
				
				c.add(Restrictions.eq("GrnNo", grnNo));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			/*if (!searchFieldMap.get("grnNo").equals("0")) {

				grnNo = (String) searchFieldMap.get("grnNo");
				gridGrnDetailList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.StoreGrnT ");
				gridGrnHeaderList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.StoreGrnM as pod where pod.GrnNo = '"
								+ grnNo + "'");

			}*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
		gridGrnHeaderList =  c.addOrder(Order.desc("Id")).list();
		//map.put("gridGrnDetailList", gridGrnDetailList);
		map.put("gridGrnHeaderList", gridGrnHeaderList);

		return map;
	}

	// ----------------- NON EXPANDABLE LOANIN---------------------

	public Map showNeLoanInJsp(Box box, Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();

		int deptId = 0;
		int hospitalId = 0;
		String userName = "";
		if (dataMap.get("deptId") != null)
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		if (dataMap.get("hospitalId") != null)
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		if (dataMap.get("userName") != null)
			userName = ("" + dataMap.get("userName"));

		List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
		List<StoreLoaninM> searchLoanInList = new ArrayList<StoreLoaninM>();
		List<StorePoHeader> poList = new ArrayList<StorePoHeader>();
		List<MasManufacturer> manufacturerList = new ArrayList<MasManufacturer>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<StoreGrnM> grnList = new ArrayList<StoreGrnM>();
		List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
		List<MasStoreMeScale> meScaleList = new ArrayList<MasStoreMeScale>();
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		List<MasStoreAirForceDepot> unitList = new ArrayList<MasStoreAirForceDepot>();

		String max = "";
		String startNo = "";
		String no = "";

		Session session = (Session) getSession();
		try {
			searchLoanInList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreLoaninM as sl");
			supplierList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasStoreSupplier as ms where ms.Status = 'y'");
			manufacturerList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasManufacturer as mi where mi.Status = 'y'");
			employeeList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasEmployee as mi where mi.Status = 'y'");
			unitList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasStoreAirForceDepot as mi where mi.Status = 'y'");
			poList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StorePoHeader as mi where mi.Status = 'y'");
			meScaleList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasStoreMeScale as me where me.Status = 'y'");
			brandList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasStoreBrand as msb");
			storeFyDocumentNoList = (List) getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreFyDocumentNo as sfdn where sfdn.Department.Id='"
									+ deptId + "'");
			for (StoreFyDocumentNo storeFyDocumentNo : storeFyDocumentNoList) {
				if (storeFyDocumentNo.getLoaninNo() != null) {
					no = ("" + storeFyDocumentNo.getLoaninNo());
					no = getMaxNo(no);
				} else {
					no = getMaxNo("");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("supplierList", supplierList);
		map.put("manufacturerList", manufacturerList);
		map.put("employeeList", employeeList);
		map.put("unitList", unitList);
		map.put("grnList", grnList);
		map.put("brandList", brandList);
		map.put("meScaleList", meScaleList);
		map.put("poList", poList);
		map.put("searchLoanInList", searchLoanInList);
		map.put("max", no);
		return map;

	}

	// ---------- adding loanin
	public boolean addLoanIn(Map<String, Object> infoMap) {
		StoreLoaninM storeLoaninM = (StoreLoaninM) infoMap.get("storeLoaninM");
		List<StoreLoaninT> storeLoaninTlist = (ArrayList<StoreLoaninT>) infoMap
				.get("storeLoaninTlist");
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		boolean successfullyAdded = false;
		StoreItemBatchStock storeItemBatchStock1 = new StoreItemBatchStock();
		StoreLoaninM storeLoaninM2 = new StoreLoaninM();
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		String max = "";
		String no = "";

		if (infoMap.get("deptId") != null)
			deptId = Integer.parseInt("" + infoMap.get("deptId"));
		if (infoMap.get("hospitalId") != null)
			hospitalId = Integer.parseInt("" + infoMap.get("hospitalId"));
		if (infoMap.get("userName") != null)
			userName = ("" + infoMap.get("userName"));
		int storeFyId = 0;

		session = (Session) getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			if (!(infoMap.get("headerStored") + "").equals("yes")) {

				hbt.save(storeLoaninM);
				int poId = storeLoaninM.getId();
				String loanInNo = "";
				loanInNo = (String) infoMap.get("loanInNo");
				Criteria c = session.createCriteria(StoreFyDocumentNo.class)
						.add(Restrictions.eq("Department.Id", deptId));
				storeFyDocumentNoList = c.list();
				for (StoreFyDocumentNo documentNo : storeFyDocumentNoList) {
					storeFyId = documentNo.getId();
				}
				StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) getHibernateTemplate()
						.load(StoreFyDocumentNo.class, storeFyId);
				storeFyDocumentNo.setLoaninNo(loanInNo);
				hbt.update(storeFyDocumentNo);

			}

			List<StoreItemBatchStock> storeItemBatchStockList = new ArrayList<StoreItemBatchStock>();

			StoreItemBatchStock storeItemBatchStock = null;

			if (storeLoaninTlist.size() > 0) {

				if ((infoMap.get("headerStored") + "").equals("yes")) {
					int id = Integer.parseInt("" + infoMap.get("loanInId"));
					storeLoaninM2.setId(id);
				}

				for (int i = 0; i < storeLoaninTlist.size(); i++) {
					StoreLoaninT StoreLoaninTObj = new StoreLoaninT();
					StoreLoaninTObj = (StoreLoaninT) storeLoaninTlist.get(i);
					if ((infoMap.get("headerStored") + "").equals("yes")) {

						StoreLoaninTObj.setLoaninMaster(storeLoaninM2);
					} else {
						StoreLoaninTObj.setLoaninMaster(storeLoaninM);
					}
					hbt.save(StoreLoaninTObj);

					int item_id = StoreLoaninTObj.getItem().getId();

					String batch_no = StoreLoaninTObj.getBatchNo();
					int department_id = storeLoaninM.getDepartment().getId();
					BigDecimal cost_price = StoreLoaninTObj.getFinalCostPrice();

					storeItemBatchStockList = hbt
							.find("from jkt.hms.masters.business.StoreItemBatchStock as inp where inp.Item.Id = "
									+ item_id
									+ " and inp.Department.Id= "
									+ department_id
									+ " and inp.BatchNo ="
									+ batch_no.valueOf("batch_no"));
					if (storeItemBatchStockList != null
							&& storeItemBatchStockList.size() > 0) {

						int free_qty = 0;
						free_qty = StoreLoaninTObj.getFreeQty();
						storeItemBatchStock = storeItemBatchStockList.get(0);
						BigDecimal existing_qty = storeItemBatchStock
								.getReceivedQty();
						BigDecimal recd_qty = StoreLoaninTObj.getReceivedQty();

						BigDecimal new_qty = new BigDecimal(0);
						new_qty = existing_qty.add(recd_qty);
						BigDecimal existing_closing_stock = storeItemBatchStock
								.getClosingStock();
						BigDecimal new_closing_stock = new BigDecimal(0);
						new_closing_stock = existing_closing_stock
								.add(recd_qty);
						BigDecimal cost_prices = storeItemBatchStock
								.getCostPrice();

						int id = storeItemBatchStock.getId();
						storeItemBatchStock = (StoreItemBatchStock) getHibernateTemplate()
								.load(StoreItemBatchStock.class, id);
						storeItemBatchStock.setReceivedQty(new_qty
								.add(new BigDecimal(free_qty)));
						storeItemBatchStock.setClosingStock(new_closing_stock
								.add(new BigDecimal(free_qty)));
						storeItemBatchStock.setBatchNo(StoreLoaninTObj
								.getBatchNo());
						storeItemBatchStock.setItem(StoreLoaninTObj.getItem());
						if (storeItemBatchStock.getCostPrice() != null) {
							BigDecimal new_cost_price = new BigDecimal(0);
							new_cost_price = cost_prices.add(cost_price);
							storeItemBatchStock.setCostPrice(new_cost_price);
						} else {
							storeItemBatchStock.setCostPrice(null);
						}

						HibernateTemplate hbt1 = getHibernateTemplate();
						hbt1.setFlushModeName("FLUSH_EAGER");
						hbt1.setCheckWriteOperations(false);
						hbt1.update(storeItemBatchStock);

					} else {
						storeItemBatchStock = new StoreItemBatchStock();
						storeItemBatchStock.setDepartment(storeLoaninM
								.getDepartment());
						storeItemBatchStock
								.setLotNo(StoreLoaninTObj.getLotNo());
						storeItemBatchStock.setReceivedQty(StoreLoaninTObj
								.getReceivedQty());
						storeItemBatchStock.setFreeItem(StoreLoaninTObj
								.getFreeItem());
						storeItemBatchStock.setClosingStock(StoreLoaninTObj
								.getReceivedQty());
						storeItemBatchStock.setItem(StoreLoaninTObj.getItem());
						if (StoreLoaninTObj.getBatchNo().equals("0")) {
							storeItemBatchStock.setCostPrice(StoreLoaninTObj
									.getFinalCostPrice());
							storeItemBatchStock.setBatchNo("0");
						} else {
							storeItemBatchStock.setBatchNo(StoreLoaninTObj
									.getBatchNo());
							storeItemBatchStock.setCostPrice(null);
						}

						HibernateTemplate hbt1 = getHibernateTemplate();
						hbt1.setFlushModeName("FLUSH_AUTO");
						hbt1.setCheckWriteOperations(false);
						hbt1.save(storeItemBatchStock);
						hbt.refresh(storeItemBatchStock);

					}
				}
			}

			successfullyAdded = true;
			tx.commit();

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			// throw e; // or display error message
			e.printStackTrace();
		} finally {
			session.close();
		}

		return successfullyAdded;
	}

	public Map searchLoanin(Map searchFieldMap){
		Map<String, Object> map = new HashMap<String, Object>();
		String fromDate = "";
		String toDate = "";
		List<StoreLoaninM> gridLoaninHeaderList = new ArrayList<StoreLoaninM>();
		List<StoreLoaninT> gridLoaninDetailList = new ArrayList<StoreLoaninT>();
		String loanInNo = "";
		try {
			if ((!searchFieldMap.get("fromDate").equals(""))
					&& (!searchFieldMap.get("toDate").equals(""))) {
				fromDate = (String) searchFieldMap.get("fromDate");
				toDate = (String) searchFieldMap.get("toDate");

				SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
				String date4MySQL1 = formatterOut.format(formatterIn
						.parse(fromDate));
				String date4MySQL2 = formatterOut.format(formatterIn
						.parse(toDate));
				java.sql.Date startDate = java.sql.Date.valueOf(date4MySQL1);
				java.sql.Date endDate = java.sql.Date.valueOf(date4MySQL2);

				gridLoaninDetailList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.StoreLoaninT ");
				gridLoaninHeaderList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.StoreLoaninM as poh where "
								+ " poh.GrnDate between '" + startDate
								+ "' and '" + endDate + "'");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			if (!searchFieldMap.get("loanInNo").equals("0")) {
				loanInNo = (String) searchFieldMap.get("loanInNo");
				gridLoaninDetailList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.StoreLoaninT ");
				gridLoaninHeaderList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.StoreLoaninM as pod where pod.LoaninNo = '"
								+ loanInNo + "'");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("gridLoaninDetailList", gridLoaninDetailList);
		map.put("gridLoaninHeaderList", gridLoaninHeaderList);

		return map;
	}

	public Map<String, Object> modifyLoanin(int loanInId, int pageNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreLoaninT> storeLoanInTList = new ArrayList<StoreLoaninT>();
		List<StoreLoaninM> storeLoanInMList = new ArrayList<StoreLoaninM>();

		int firstResult = 0;
		int maxResults = 10;

		if (pageNo != 0) {
			firstResult = firstResult + (pageNo) * 10;
		}

		Session session = (Session) getSession();
		Criteria c = session.createCriteria(StoreLoaninT.class).add(
				Restrictions.eq("LoaninMaster.Id", loanInId));
		c.setFirstResult(firstResult);
		c.setMaxResults(maxResults);
		storeLoanInTList = c.list();

		storeLoanInMList = session.createCriteria(StoreLoaninM.class).add(
				Restrictions.eq("Id", loanInId)).list();

		map.put("storeLoanInTList", storeLoanInTList);
		map.put("storeLoanInMList", storeLoanInMList);
		return map;
	}

	// --------- new GRid----------------------

	public Map<String, Object> getItemListForLoanInByAutocomplete(
			Map<String, Object> dataMap) {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		Box box = (Box) dataMap.get("box");
		String sos = box.getString("sourceOfSupply").trim();
		String pvmsNo = null;
		int deptId = 0;
		int indentId = 0;
		deptId = Integer.parseInt("" + dataMap.get("deptId"));
		indentId = Integer.parseInt("" + dataMap.get("indentId"));
		List objectList = new ArrayList();
		try {
			String str = dataMap.get("autoHint") + "%";

			String qry = "Select item_id from mas_store_item where department_id ='"
					+ deptId + "';";
			objectList = (List) session.createSQLQuery(qry).list();
			Criteria c = session.createCriteria(MasStoreItem.class).add(
					Restrictions.like("Nomenclature", str)).add(
					Restrictions.eq("Department.Id", deptId)).add(
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

	public Map<String, Object> fillItemsForLoanIn(Map<String, Object> dataMap) {

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
		session = (Session) getSession();
		String pvms = null;

		int deptId = 0;
		if (dataMap.get("deptId") != null) {
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		}
		int indentId = 0;
		if (dataMap.get("indentId") != null) {
			indentId = Integer.parseInt("" + dataMap.get("indentId"));
		}
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			String queryString = null;
			String str = "" + dataMap.get("nomenclature");
			StringBuffer output_str = new StringBuffer();
			StringTokenizer s = new StringTokenizer(str, "%");

			while (s.hasMoreTokens()) {
				output_str.append(s.nextToken());
				if (s.hasMoreTokens()) {
					output_str.append("\\%");
				}
			}

			Criteria c = session.createCriteria(MasStoreItem.class).add(
					Restrictions.eq("PvmsNo", str));
			itemList = c.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		try {
			int itemId = 0;
			for (MasStoreItem masStoreItem : itemList) {
				itemId = masStoreItem.getId();

			}
			map.put("itemList", itemList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;

	}

	// =================== WORK ORDER=================
	public Map<String, Object> showWorkOrderJsp(Box box,
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		String userName = "";
		String departmentName = "";
		int deptId = 0;
		int hospitalId = 0;
		if (dataMap.get("deptId") != null)
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		if (dataMap.get("hospitalId") != null)
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		if (dataMap.get("userName") != null)
			userName = ("" + dataMap.get("userName"));
		if (dataMap.get("departmentName") != null)
			departmentName = ("" + dataMap.get("departmentName"));

		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<StoreWorkOrderM> searchWorkOrderList = new ArrayList<StoreWorkOrderM>();
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		List<MasEmployee> issueByList = new ArrayList<MasEmployee>();
		List<MasRepairStation>repairStationList=new ArrayList<MasRepairStation>();

		String max = "";
		String startNo = "";
		String no = "";

		Session session = (Session) getSession();
		try {
			
			repairStationList=session.createCriteria(MasRepairStation.class)
			.add(Restrictions.eq("Status", "y"))
			.add(Restrictions.eq("Hospital.Id", hospitalId)).list();
			
			hospitalList=session.createCriteria(MasHospital.class)
			.add(Restrictions.eq("Id", hospitalId))
			.add(Restrictions.eq("Status", "y")).list();
			
			departmentList = session.createCriteria(MasDepartment.class)
								.add(Restrictions.eq("Status", "y")).list();
			
			/*
			 * By Ujjwal For SQL Injection
			 */
			/*searchWorkOrderList = getHibernateTemplate().find(
								"from jkt.hms.masters.business.StoreWorkOrderM as mi");*/
			
			searchWorkOrderList=session.createCriteria(StoreWorkOrderM.class).list();
			
			//end By Ujjwal
			issueByList=session.createCriteria(MasEmployee.class)
								.add(Restrictions.eq("Status", "y"))
								.add(Restrictions.eq("Hospital.Id", hospitalId)).list();
			storeFyDocumentNoList =session.createCriteria(StoreFyDocumentNo.class)
								.add(Restrictions.eq("Hospital.Id", hospitalId))
								.add(Restrictions.eq("Department.Id", deptId)).list();
				
				
				/* (List) getHibernateTemplate()
					.find("from jkt.hms.masters.business.StoreFyDocumentNo as sfdn where sfdn.Department.Id='"
									+ deptId + "'");*/
			
			
			for (StoreFyDocumentNo storeFyDocumentNo : storeFyDocumentNoList) {
				if (storeFyDocumentNo.getWorkOrderNo() != null) {
					no = ("" + storeFyDocumentNo.getWorkOrderNo());
					no = getMaxNo(no);
				} else {
					no = getMaxNo("");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("departmentList", departmentList);
		map.put("searchWorkOrderList", searchWorkOrderList);
		map.put("hospitalList",hospitalList);
		map.put("issueByList",issueByList);
		map.put("repairStationList",repairStationList);
		
		map.put("max", no);
		return map;

	}

	public Map<String, Object> getItemListForWorkOrderByAutocomplete(
			Map<String, Object> dataMap) {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
//		List<StoreItemBatchStock> itemList = new ArrayList<StoreItemBatchStock>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List<MasStoreItem> itemList1 = new ArrayList<MasStoreItem>();
		Box box = (Box) dataMap.get("box");

		String pvmsNo = null;
		int deptId = 0;
		int hospitalId=0;
		deptId = Integer.parseInt("" + dataMap.get("deptId"));
		hospitalId= Integer.parseInt("" + dataMap.get("hospitalId"));
		List<Integer[]> objectList = new ArrayList<Integer[]>();
		
		try {
			//String str = dataMap.get("autoHint") + "%";
			String str =""+ dataMap.get("autoHint");
			str=str.toUpperCase()+ "%";
			//System.out.println("str in DataServiceImple---->"+str);
			/*String qry = "SELECT item_id FROM store_item_batch_stock where hospital_id='"
					+ hospitalId + "'";
			objectList = (List<Integer[]>) session.createSQLQuery(qry).list();*/
			/*Criteria c = session.createCriteria(MasStoreItem.class).createAlias("Item", "item").add(
					Restrictions.like("item.Nomenclature", str)).add(
					Restrictions.eq("Department.Id", deptId)).add(Restrictions.eq("item.TypeOfItem", "NE"));*/
					//.add(Restrictions.in("Id", new Integer[] { 2225, 2226, 2227}));
					
			//itemList = session.createCriteria(MasStoreItem.class).createAlias("Id", "item").add(Restrictions.like("item.Nomenclature", str)).list();
			//.add(	Restrictions.eq("Department.Id", deptId)).add(Restrictions.eq("item.TypeOfItem", "NE")).add(
							//Restrictions.eq("Hospital.Id", hospitalId)).list();
			
			/*Criteria c = session.createCriteria(MasStoreItem.class).add(
					Restrictions.like("Nomenclature", str).ignoreCase()).add(
					Restrictions.eq("Department.Id", deptId))
					.add(Restrictions.eq("Status", "y"))
					.add(Restrictions.eq("TypeOfItem", "NE"));*/
	
			/*c.setFirstResult(0);
			c.setMaxResults(10);
			itemList = c.list();*/
			
			//Criteria c = session.createCriteria(StoreItemBatchStock.class)
			
				//.createAlias("Item", "item").add(Restrictions.like("item.Nomenclature", str))
				//.add(Restrictions.eq("item.TypeOfItem", "NE"));
				//.createAlias("Hospital", "").add(Restrictions.eq("hsp.Id", hospitalId))));
				//.add(Restrictions.gt("ClosingStock", new BigDecimal(0.0)))
				
				//.add(Restrictions.eq("item.Department.Id", deptId))
				//.add(Restrictions.eqProperty("item.Id","Item"))
			//.setProjection(Projections.distinct(Projections.projectionList().add(
				//Projections.property("item.Id")).add(
						//Projections.property("item.Nomenclature")).add(
								//Projections.property("item.PvmsNo"))));
			//c.setFirstResult(0);
			//c.setMaxResults(10);
			
			//itemList = c.list();
			//itemList = session.createCriteria(MasStoreItem.class).add(
					//Restrictions.like("Nomenclature", str).ignoreCase()).list();			
			//itemList=getHibernateTemplate().find("select item from jkt.hms.masters.business.MasStoreItem as item where upper(item.Nomenclature) like '"+str+"'");			
			//itemList = getHibernateTemplate().find("select item from jkt.hms.masters.business.MasStoreItem as item where upper(item.Nomenclature) like '"+str+"'" );
			itemList=getHibernateTemplate().find("select item from jkt.hms.masters.business.MasStoreItem as item where upper(item.Nomenclature) like '"+str+"' and item.Status='y'  and item.ItemType.Id='2' and item.TypeOfItem='NE'  and item.Hospital.Id='"+hospitalId+"'");
			itemList1=getHibernateTemplate().find("select item from jkt.hms.masters.business.MasStoreItem as item where upper(item.Nomenclature) like '"+str+"' and item.Status='y' and item.ItemType.Id='1' and item.TypeOfItem='NE' ");

			itemList.addAll(itemList1);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		map.put("itemList", itemList);
		map.put("objectList", objectList);
		return map;
	}

	
	public Map<String, Object> fillItemsForWorkOrder(Map<String, Object> dataMap) {

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
		List<StoreItemBatchStock> batchList = new ArrayList<StoreItemBatchStock>();
		session = (Session) getSession();
		String pvms = null;

		int deptId = 0;
		if (dataMap.get("deptId") != null) {
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		}

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			String queryString = null;
			String str = "" + dataMap.get("pvmsNo");
			StringBuffer output_str = new StringBuffer();
			StringTokenizer s = new StringTokenizer(str, "%");

			while (s.hasMoreTokens()) {
				output_str.append(s.nextToken());
				if (s.hasMoreTokens()) {
					output_str.append("\\%");
				}
			}

			Criteria c = session.createCriteria(MasStoreItem.class).add(
					Restrictions.eq("PvmsNo", str));
			itemList = c.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		try {
			int itemId = 0;
			for (MasStoreItem masStoreItem : itemList) {
				itemId = masStoreItem.getId();

			}
			if (itemId != 0) {
				Criteria c3 = session.createCriteria(StoreItemBatchStock.class)
						.add(Restrictions.eq("Item.Id", itemId)).add(
								Restrictions.eq("Department.Id", deptId));
				batchList = c3.list();
			}
			map.put("batchList", batchList);
			map.put("itemList", itemList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;

	}

	public List<StoreWorkOrderM> getWorkOrderList() {
		Session session = (Session) getSession();
		List<StoreWorkOrderM> workOrderList = session.createCriteria(
				StoreWorkOrderM.class).add(Restrictions.eq("Status", "o")).addOrder(Order.desc("WorkOrderNo"))
				.list();
		return workOrderList;
	}

	// ========== method for report ==========

	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> connectionMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		connectionMap.put("con", con);
		return connectionMap;
	}

	// ========= end of method for report ================

	public boolean addWorkOrder(Map<String, Object> infoMap) {
		StoreWorkOrderM storeWorkOrderM = (StoreWorkOrderM) infoMap
				.get("storeWorkOrderM");
		List<StoreWorkOrderT> storeWorkOrderTlist = (ArrayList<StoreWorkOrderT>) infoMap
				.get("storeWorkOrderTlist");
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		boolean successfullyAdded = false;
		@SuppressWarnings("unused")
		int pageNo = 0;
		String workOrderNo = "";
		int storeFyId = 0;
		int deptId = 0;
		int hospitalId = 0;
		String userName = "";
		String repairStation="";
		if (infoMap.get("deptId") != null)
			deptId = Integer.parseInt("" + infoMap.get("deptId"));
		if (infoMap.get("hospitalId") != null)
			hospitalId = Integer.parseInt("" + infoMap.get("hospitalId"));
		if (infoMap.get("userName") != null)
			userName = ("" + infoMap.get("userName"));
		if (infoMap.get("repairStation") != null)
		{
			repairStation = ("" + infoMap.get("repairStation"));
			System.out.println("repairStation----->"+repairStation);
		}

		StoreWorkOrderM storeWorkOrderM2 = new StoreWorkOrderM();

		session = (Session) getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			
			hbt.save(storeWorkOrderM);
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			MasRepairStation masrepairStation = new MasRepairStation();
			masrepairStation.setStationName(repairStation);
			hbt.save(masrepairStation);
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			workOrderNo = (String) infoMap.get("workOrderNo");
			/*Criteria c = session.createCriteria(StoreFyDocumentNo.class).add(
					Restrictions.eq("Department.Id", deptId));*/
			//-Change By dipali as discussed by bambam sir
			Criteria c = session.createCriteria(StoreFyDocumentNo.class).add(
					Restrictions.eq("Hospital.Id", hospitalId)).add(Restrictions.eq("Department.Id", deptId));
			storeFyDocumentNoList = c.list();
			if (storeFyDocumentNoList.size() > 0) {
			for (StoreFyDocumentNo documentNo : storeFyDocumentNoList) {
				storeFyId = documentNo.getId();
			}
			StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) getHibernateTemplate()
					.load(StoreFyDocumentNo.class, storeFyId);
			storeFyDocumentNo.setWorkOrderNo(workOrderNo);
			//---added by dipali
			
			hbt.update(storeFyDocumentNo);
			}if (storeFyDocumentNoList.size() == 0) {
				StoreFyDocumentNo storeFyDocumentNo = new StoreFyDocumentNo();
				MasDepartment masDepartment = new MasDepartment();
				//masDepartment.setId(deptId);
				//storeFyDocumentNo.setDepartment(masDepartment);
				
				MasHospital hospital=new MasHospital();
				//hospital.setId(hospitalId);
				//storeFyDocumentNo.setHospital(hospital);
				//storeFyDocumentNo.setWorkOrderNo(workOrderNo);
				hbt.save(storeFyDocumentNo);
			}
			//-------------
			List<Integer> itemIdList = new ArrayList<Integer>();
			itemIdList= (List) infoMap.get("itemIdList");
			List<String> srList = new ArrayList<String>();
			srList= (List) infoMap.get("srList");
			List<String>  serialNoList = new ArrayList<String>();
			serialNoList= (List) infoMap.get("serialNoList");
			List<Integer> quantityList = new ArrayList<Integer>();
			quantityList= (List) infoMap.get("quantityList");
			List<String> natureOfWorkList = new ArrayList<String>();
			natureOfWorkList= (List) infoMap.get("natureOfWorkList");
			List<String> parEqptList = new ArrayList<String>();
			parEqptList= (List) infoMap.get("parEqptList");
			List<String> remarksList = new ArrayList<String>();
			remarksList= (List) infoMap.get("remarksList");
			if (itemIdList.size() > 0) {
				for (int i = 0; i < itemIdList.size(); i++) {
					StoreWorkOrderT storeWorkOrderTObj = new StoreWorkOrderT();
					if(itemIdList.get(i) != null){
						MasStoreItem masStoreItem = new MasStoreItem();
						masStoreItem.setId(itemIdList.get(i));
						storeWorkOrderTObj.setItem(masStoreItem);
					}
					storeWorkOrderTObj.setSrNo(srList.get(i));
					storeWorkOrderTObj.setWorkOrderM(storeWorkOrderM);
					storeWorkOrderTObj.setSerialNo(serialNoList.get(i));
					storeWorkOrderTObj.setQuantity(quantityList.get(i));
					storeWorkOrderTObj.setNatureOfWork(natureOfWorkList.get(i));
					storeWorkOrderTObj.setParticularEqupRv(parEqptList.get(i));
					storeWorkOrderTObj.setRemarks(remarksList.get(i));
					hbt.save(storeWorkOrderTObj);

				}
				
			}
		/*	if (storeWorkOrderTlist.size() > 0) {
				if ((infoMap.get("headerStored") + "").equals("yes")) {
					int id = Integer.parseInt("" + infoMap.get("workOrderId"));
					storeWorkOrderM2.setId(id);
				}
				for (int i = 0; i < storeWorkOrderTlist.size(); i++) {
					StoreWorkOrderT storeWorkOrderTObj = new StoreWorkOrderT();
					storeWorkOrderTObj = (StoreWorkOrderT) storeWorkOrderTlist
							.get(i);
					if ((infoMap.get("headerStored") + "").equals("yes")) {
						storeWorkOrderTObj.setWorkOrderM(storeWorkOrderM2);
					} else {
						storeWorkOrderTObj.setWorkOrderM(storeWorkOrderM);
					}
					hbt.save(storeWorkOrderTObj);
				}

			}*/
			successfullyAdded = true;
			tx.commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// throw e; // or display error message
			e.printStackTrace();
		} finally {
			session.close();
		}

		return successfullyAdded;
	}

	public Map getWorkOrderModify(Map<String, Object> infoMap) {

		Map map = new HashMap();
		List<StoreWorkOrderM> gridWorkOrderMList = new ArrayList<StoreWorkOrderM>();
		List<StoreWorkOrderT> gridWorkOrderTList = new ArrayList<StoreWorkOrderT>();
		@SuppressWarnings("unused")
		int id = 0;
		int firstResult = 0;
		int maxResults = 8;
		int workOrderId=0;
		int pageNo = 1;
		int hospitalId=0;
		int deptId=0;
		workOrderId = (Integer) infoMap.get("radio_str");
		pageNo = (Integer) infoMap.get("pageNo");
		hospitalId = (Integer) infoMap.get("hospitalId");
		deptId = (Integer) infoMap.get("deptId");
		List<StoreWorkOrderM> searchWorkOrderList = new ArrayList<StoreWorkOrderM>();
		List<StoreWorkOrderM> list = new ArrayList<StoreWorkOrderM>();
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		List<MasEmployee> issueByList = new ArrayList<MasEmployee>();
		List<MasRepairStation>repairStationList=new ArrayList<MasRepairStation>();
		session = (Session) getSession();
		List objectList = new ArrayList();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		int year = Integer.parseInt(date.substring(6));
		session = (Session) getSession();
		Transaction tx = null;
		try {
			// --------------Transaction Started----------
			tx = session.beginTransaction();
			Criteria c = session.createCriteria(StoreWorkOrderT.class).add(
					Restrictions.eq("WorkOrderM.Id", workOrderId));
			c.setFirstResult(firstResult);
			c.setMaxResults(maxResults);
			gridWorkOrderTList = c.list();
			/*
			 * By Ujjwal
			 */
			/*gridWorkOrderMList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreWorkOrderM as md where md.Id = '"
							+ workOrderId + "' and md.Status='o'");
			*/
			gridWorkOrderMList=session.createCriteria(StoreWorkOrderM.class).add(Restrictions.eq("Id", workOrderId)).add(Restrictions.eq("Id", workOrderId)).list();
/*			String qry = "select item_id,pvms_no,nomenclature from mas_store_item ";
			objectList = (List) session.createSQLQuery(qry).list();
*/			objectList=session.createCriteria(MasStoreItem.class)
							  .setProjection(Projections.property("Id"))
							  .setProjection(Projections.property("Nomenclature"))
			.list();
			// --------------Transaction Ended----------
			issueByList=session.createCriteria(MasEmployee.class)
			.add(Restrictions.eq("Status", "y"))
			.add(Restrictions.eq("Hospital.Id", hospitalId)).list();
			repairStationList=session.createCriteria(MasRepairStation.class)
			//.add(Restrictions.eq("Status", "y"))
			.add(Restrictions.eq("Hospital.Id", hospitalId)).list();
			tx.commit();
		} catch (Exception e) {
			// --------------In case of Transaction Failure----------
			if (tx != null)
				tx.rollback();

			e.printStackTrace();

		}

		map.put("gridWorkOrderMList", gridWorkOrderMList);
		map.put("gridWorkOrderTList", gridWorkOrderTList);
		map.put("workOrderId", workOrderId);
		map.put("objectList", objectList);
		map.put("repairStationList", repairStationList);
		map.put("issueByList", issueByList);

		return map;
	}

	public Map<String, Object> modifyGrn(int grnId, int pageNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreGrnM> gridGrnMList = new ArrayList<StoreGrnM>();
		List<StoreGrnT> gridGrnTList = new ArrayList<StoreGrnT>();
		int firstResult = 0;
		int maxResults = 10;

		if (pageNo != 0) {
			firstResult = firstResult + (pageNo) * 10;
		}

		Session session = (Session) getSession();
		Criteria c = session.createCriteria(StoreGrnT.class).add(
				Restrictions.eq("GrnMaster.Id", grnId));
		c.setFirstResult(firstResult);
		c.setMaxResults(maxResults);
		gridGrnTList = c.list();
		gridGrnMList = session.createCriteria(StoreGrnM.class).add(
				Restrictions.eq("Id", grnId)).list();

		map.put("gridGrnTList", gridGrnTList);
		map.put("gridGrnMList", gridGrnMList);
		return map;
	}

	public List<StoreGrnM> getCrvNumberList(Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		// Map<String, Object>dataMap = new HashMap<String, Object>();
		int deptId = 0;
		if (dataMap.get("deptId") != null)
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		List<StoreGrnM> crvNumberList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.StoreGrnM as md where md.Department.Id="
						+ deptId + " and md.Status='o'");
		return crvNumberList;
	}

	public List<StoreLoaninM> getloanList(Map<String, Object> dataMap) {
		List<StoreLoaninM> loaninList = new ArrayList<StoreLoaninM>();
		int deptId = 0;
		if (dataMap.get("deptId") != null)
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		loaninList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.StoreLoaninM as md where md.Department.Id="
						+ deptId + " and  md.Status = 'o'");
		return loaninList;
	}

	public List<StoreLoaninT> getLoanInListForMoreInfo(int loaninDetailId) {
		Session session = (Session) getSession();
		List<StoreLoaninT> loanInMoreInfoList = session.createCriteria(
				StoreLoaninT.class).add(Restrictions.eq("Id", loaninDetailId))
				.list();
		return loanInMoreInfoList;
	}

	public List<StoreGrnT> getStoreGrnTListForMoreInfo(int storeGrnTId) {
		Session session = (Session) getSession();
		List<StoreGrnT> storeGrnTMoreInfoList = session.createCriteria(
				StoreGrnT.class).add(Restrictions.eq("Id", storeGrnTId)).list();
		return storeGrnTMoreInfoList;
	}

	// ===========hitesh methods started =======//
	public Map<String, Object> showAmcMaintenanceJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();

		List departmentList = new ArrayList();

		departmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment  as md order by md.Id");
		map.put("departmentList", departmentList);
		return map;

	}

	public Map getNomenclature(int departmentId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List itemList = new ArrayList();
		//List<MasStoreItem> nomencalatureList = new ArrayList<MasStoreItem>();
		List<StoreItemBatchStock> nomencalatureList = new ArrayList<StoreItemBatchStock>();
		
		/*itemList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasStoreItem  as msi where msi.Department.Id = "
						+ departmentId);*/
		
		itemList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.StoreItemBatchStock  as msi where msi.Department.Id = "
						+ departmentId);
		if (itemList != null && itemList.size() > 0) {
			for (int i = 0; i < itemList.size(); i++) {
				StoreItemBatchStock sibs = (StoreItemBatchStock) itemList.get(i);
				nomencalatureList.add(sibs);
			}
		}
		map.put("nomenclatureList", nomencalatureList);
		return map;
	}

	public Map getPvmsNoAndGetSerialNo(int nomenclatureId) {
		Map<String, Object> map = new HashMap<String, Object>();
		String pvmsNo = "";
		String BatchNo = "";
		String auNo = "";
		String serialNo = "";
		int itemId=0;
		List serialNoList = new ArrayList();
		List serialList = new ArrayList();
		List<MasStoreItem> pvmsNoList = new ArrayList<MasStoreItem>();
		List<MasStoreItemConversion> auList = new ArrayList<MasStoreItemConversion>();
		/*auList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasStoreItemConversion as msic where msic.Id="
						+ nomenclatureId);
		if (auList != null && auList.size() > 0) {
			for (int i = 0; i < auList.size(); i++) {
				MasStoreItemConversion misc = (MasStoreItemConversion) auList
						.get(i);
				auNo = misc.getItemUnitName();
				map.put("auNo", auNo);
			}
		}*/
		pvmsNoList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasStoreItem as msi where msi.PvmsNo="
						+ nomenclatureId);
		
		if (pvmsNoList != null && pvmsNoList.size() > 0) {
			for (int i = 0; i < pvmsNoList.size(); i++) {
				MasStoreItem mis = (MasStoreItem) pvmsNoList.get(i);
				pvmsNo = mis.getPvmsNo();
				itemId=mis.getId();
				auNo=mis.getItemConversion().getItemUnitName();
				Set<StoreItemBatchStock> storeItemBatchStockSet = mis
						.getStoreItemBatchStocks();
				for (Iterator stoteItemBatchStockSetItr = storeItemBatchStockSet
						.iterator(); stoteItemBatchStockSetItr.hasNext();) {
					StoreItemBatchStock storeItemBatchStock = (StoreItemBatchStock) stoteItemBatchStockSetItr
							.next();
					serialNoList.add(storeItemBatchStock);
				}
				map.put("auNo", auNo);
				map.put("pvmsNo", pvmsNo);
				map.put("itemId", itemId);
				map.put("serialNoList", serialNoList);

			}
			serialList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreItemBatchStock as sibs where sibs.Item.Id="
							+ nomenclatureId);
			if (serialList.size() > 0 && !serialList.isEmpty()) {
				StoreItemBatchStock storeItemBatchStock = (StoreItemBatchStock) serialList
						.get(0);
				serialNo = storeItemBatchStock.getBatchNo();
			}
		}
		map.put("serialNo", serialNo);
		return map;
	}

	public Map getSerialNoDetails(String serialNo, int itemId) {
		Map<String, Object> map = new HashMap<String, Object>();
		int id = 0;
		StoreAmcM storeAmcM = null;
		StoreGrnT storeGrnT = null;
		StoreAmcT storeAmcT = null;
		List<StoreAmcM> serialNoDetailList = new ArrayList<StoreAmcM>();
		List<StoreGrnT> serialNoDetailsList = new ArrayList<StoreGrnT>();
		List<StoreAmcT> amcTDetailsList = new ArrayList<StoreAmcT>();

		serialNoDetailList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.StoreAmcM as sam where sam.SerialNo='"
						+ serialNo + "'  and sam.Item =" + itemId);
		if (serialNoDetailList.size() > 0 && !serialNoDetailList.isEmpty()) {
			storeAmcM = (StoreAmcM) serialNoDetailList.get(0);
			map.put("storeAmcM", storeAmcM);
			id = storeAmcM.getId();
			amcTDetailsList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreAmcT as sat where sat.AmcM="
							+ id);
			if (amcTDetailsList.size() > 0 && !amcTDetailsList.isEmpty())
				storeAmcT = (StoreAmcT) amcTDetailsList.get(0);
			map.put("storeAmcT", storeAmcT);
			map.put("amcTDetailsList", amcTDetailsList);
		}

		List entryNo = getAmcMList();
		if (serialNoDetailList.size() == 0 && serialNoDetailList.isEmpty())
			serialNoDetailsList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreGrnT as sgt where sgt.LotNo='"
							+ serialNo + "'  and sgt.Item =" + itemId);

		if (serialNoDetailsList.size() > 0 && !serialNoDetailsList.isEmpty())
			storeGrnT = (StoreGrnT) serialNoDetailsList.get(0);
		map.put("StoreGrnT", storeGrnT);
		map.put("entryNoList", entryNo);

		return map;
	}

	public List getSupplierList() {
		List<MasStoreSupplier> suppList = null;
		suppList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasStoreSupplier  as mss order by mss.Id");
		return suppList;
	}

	public boolean addAmcMDetailsandaddAmcTDetails(StoreAmcM storeAmcM,
			List<StoreAmcT> storeList) throws Exception {

		Session sess = (Session) getSession();
		Transaction tx = null;
		boolean record_added = false;
		List<StoreAmcM> amcM = new ArrayList<StoreAmcM>();
		List<StoreAmcT> amcT = new ArrayList<StoreAmcT>();
		try {
			tx = sess.beginTransaction();
			String entryNo = storeAmcM.getEntryNo();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			amcM = hbt
					.find("from jkt.hms.masters.business.StoreAmcM as sam where sam.EntryNo='"
							+ entryNo + "'");

			if (amcM != null && amcM.size() > 0) {
				// Master Already Exists
				storeAmcM = amcM.get(0);
			} else {
				// Master Records Not Created
				hbt.save(storeAmcM);
			}

			// Delete existing records from StoreAmcT for particular EntryNo

			amcT = hbt
					.find("from jkt.hms.masters.business.StoreAmcT as sam where sam.AmcM.EntryNo='"
							+ entryNo + "'");
			for (Iterator iterator = amcT.iterator(); iterator.hasNext();) {
				StoreAmcT storeAmcT = (StoreAmcT) iterator.next();
				hbt.delete(storeAmcT);
			}

			for (Iterator iterator = storeList.iterator(); iterator.hasNext();) {
				StoreAmcT storeAmcT = (StoreAmcT) iterator.next();
				storeAmcT.setAmcM(storeAmcM);
				hbt.save(storeAmcT);
			}
			tx.commit();
			record_added = true;

		} catch (Exception e) {
			if (tx != null) {
				
				tx.rollback();
			e.printStackTrace();
				return false;
			}
		}
		if (record_added)
			return true;
		else
			return false;
	}

	public List getAmcMList() {
		StoreAmcM storeAmcM = null;
		String entryNo = "";
		List<StoreAmcM> amcMList = null;
		List<String> entryNoList = new ArrayList<String>();
		amcMList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.StoreAmcM  as sam order by sam.Id");
		if (amcMList != null) {
			if (amcMList.size() > 0 && !amcMList.isEmpty()) {
				for (int i = 0; i < amcMList.size(); i++) {
					storeAmcM = (StoreAmcM) amcMList.get(i);
					entryNo = storeAmcM.getEntryNo();

				}
			}
		}
		String entryno = getMaxNo(entryNo);
		entryNoList.add(entryno);

		return entryNoList;
	}

	public List getRepairNoList() {
		StoreRepairCivilFirm storeRepairCivilFirm = null;
		String repairNo = "";
		List<StoreRepairCivilFirm> storerepairList = null;
		List<String> repairNoList = new ArrayList<String>();
		storerepairList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.StoreRepairCivilFirm  as srcf order by srcf.Id");
		if (storerepairList != null) {
			if (storerepairList.size() > 0 && !storerepairList.isEmpty()) {
				for (int i = 0; i < storerepairList.size(); i++) {
					storeRepairCivilFirm = (StoreRepairCivilFirm) storerepairList
							.get(i);
					repairNo = storeRepairCivilFirm.getRepairNo();
				}
			}
		}
		String repairno = getMaxNo(repairNo);
		repairNoList.add(repairno);
		return repairNoList;
	}

	public List getRepairNo() {
		StoreRepairCivilFirm storeRepairCivilFirm = null;
		String repairNo = "";
		List<StoreRepairCivilFirm> storerepairList = null;
		List<String> repairNoList = new ArrayList<String>();
		storerepairList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.StoreRepairCivilFirm  as srcf order by srcf.Id");
		return storerepairList;
	}

	public List getDocEntryNo() {
		StoreAmcM storeAmcM = null;
		String docentryNo = "";
		List<StoreAmcM> docentryNoList = null;
		docentryNoList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.StoreAmcM  as sam order by sam.Id");
		return docentryNoList;
	}

	public Map addStoreRepairCivilFirm(StoreRepairCivilFirm storeRepairCivilFirm)
			throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean successfullyAdded = false;
		int nomenclatureId = storeRepairCivilFirm.getItem().getId();
		String repariNo = storeRepairCivilFirm.getRepairNo();
		session = (Session) getSession();
		Transaction tx = null;
		List civilFirmList = new ArrayList();
		try {
			tx = session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			hbt.save(storeRepairCivilFirm);
			tx.commit();
			successfullyAdded = true;

		} catch (Exception e) {
			
			if (tx != null)
				tx.rollback();
			// throw e; // or display error message
			e.printStackTrace();
		} finally {
			//session.close();
		}

		if (successfullyAdded) {
			map = getAmcRepairDetails(nomenclatureId, repariNo);

		}

		return map;
	}

	public Map updateStoreRepairCivilFirm(
			StoreRepairCivilFirm storeRepairCivilFirm) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean successfullyAdded = false;
		int nomenclatureId = storeRepairCivilFirm.getItem().getId();
		String repariNo = storeRepairCivilFirm.getRepairNo();
		session = (Session) getSession();
		Transaction tx = null;
		List civilFirmList = new ArrayList();
		try {
			tx = session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			int id = storeRepairCivilFirm.getId();
			StoreRepairCivilFirm civilFirm = (StoreRepairCivilFirm) hbt.load(
					StoreRepairCivilFirm.class, id);
			storeRepairCivilFirm.setId(civilFirm.getId());
			hbt.update(storeRepairCivilFirm);
			tx.commit();
			successfullyAdded = true;
			if (successfullyAdded) {
				map = getAmcRepairDetails(nomenclatureId, repariNo);

			}

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			// throw e; // or display error message
			e.printStackTrace();
		} finally {
			session.close();
		}
		return map;
	}

	public Map getAmcRepairDetails(int nomenclatureId, String repairNO) {
		Map<String, Object> map = new HashMap<String, Object>();
		List amcRepairDetails = new ArrayList();
		try {
			if (nomenclatureId != 0 && repairNO != "") {
				amcRepairDetails = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.StoreRepairCivilFirm as srcf where srcf.RepairNo='"
										+ repairNO
										+ "' and srcf.Item ='"
										+ nomenclatureId + "'");
			}

			if (nomenclatureId != 0 && repairNO == "") {
				amcRepairDetails = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.StoreRepairCivilFirm as srcf where srcf.Item = '"
										+ nomenclatureId + "'");
			}

			if (repairNO != "" && nomenclatureId == 0) {
				amcRepairDetails = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.StoreRepairCivilFirm as srcf where srcf.RepairNo ='"
										+ repairNO + "'");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("amcRepairDetails", amcRepairDetails);

		return map;

	}

	public Map getAmcSearchResult(Map searchFieldMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreAmcM> amcMaintenanceDetails = new ArrayList<StoreAmcM>();
		List<MasStoreItem> nomenclatureList = new ArrayList<MasStoreItem>();
		List departmentList = new ArrayList();
		String docEntryNo = "";
		int departmentCode = 0;
		int itemId = 0;
		String serialNo = "";
		try {
			if ((!searchFieldMap.get("docentryno").equals("")))
				docEntryNo = (String) searchFieldMap.get("docentryno");
			if ((!searchFieldMap.get("departmentId").equals("")))
				departmentCode = (Integer) searchFieldMap.get("departmentId");
			if ((!searchFieldMap.get("nomenclature").equals(0)))
				itemId = (Integer) searchFieldMap.get("nomenclature");
			if ((!searchFieldMap.get("SERIAL_NUMBER").equals("")))
				serialNo = (String) searchFieldMap.get("SERIAL_NUMBER");

			if (docEntryNo != "") {
				amcMaintenanceDetails = getHibernateTemplate().find(
						"from jkt.hms.masters.business.StoreAmcM as sam where sam.EntryNo='"
								+ docEntryNo + "'");
			}

			if (docEntryNo != "" && departmentCode != 0 && itemId != 0
					&& serialNo != "") {
				amcMaintenanceDetails = getHibernateTemplate().find(
						"from jkt.hms.masters.business.StoreAmcM as sam where sam.EntryNo = '"
								+ docEntryNo + "' and sam.Department="
								+ departmentCode + "and sam.Item='" + itemId
								+ "'and sam.SerialNo='" + serialNo + "'");
			}

			departmentList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasDepartment  as md order by md.Id");
			map.put("departmentList", departmentList);

			nomenclatureList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasStoreItem  as msi order by msi.Id");
			map.put("nomenclatureList", nomenclatureList);
		} catch (Exception e) {
e.printStackTrace();
		}
		map.put("amcMaintenanceDetails", amcMaintenanceDetails);

		return map;
	}

	public List getStoreAmcT(int id) {

		List<StoreAmcT> storeamcList = new ArrayList<StoreAmcT>();
		storeamcList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.StoreAmcT as sat where sat.AmcM="
						+ id);
		return storeamcList;
	}

	public Map showBoardOfSurvey() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreBosM> storeBosMList = new ArrayList<StoreBosM>();
		String BosNo = "";
		StoreItemBatchStock StoreItemBatchStock=null;
		List<StoreItemBatchStock> storeItemBatchStockMList = new ArrayList<StoreItemBatchStock>();
		session = (Session) getSession();
		StoreBosM storeBosM = null;
		storeBosMList = getHibernateTemplate().find("from jkt.hms.masters.business.StoreBosM as sbm order by sbm.Id");
		
	storeItemBatchStockMList=session.createCriteria(StoreItemBatchStock.class).setProjection(Projections.property("Item")).list();
			
		
		storeItemBatchStockMList=	getHibernateTemplate()
		.find("from jkt.hms.masters.business.StoreItemBatchStock as sbm "); 
		
		storeItemBatchStockMList=session.createCriteria(StoreItemBatchStock.class).list();
		
		if (storeBosMList.size() > 0 && !storeBosMList.isEmpty()) {
			for (int i = 0; i < storeBosMList.size(); i++) {
				storeBosM = storeBosMList.get(i);
				BosNo = storeBosM.getBosNo();
			}
		}
		BosNo = getMaxNo(BosNo);
		// String Bono= BosNo.substring(0, 1);
		map.put("BosNo", BosNo);
		map.put("StoreBosMList", storeBosMList);
		map.put("storeItemBatchStockMList", storeItemBatchStockMList);
		return map;
	}

	public Map createAndImportBosData(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreCondemnationT> condemnationList = new ArrayList<StoreCondemnationT>();
		// StoreCondemnationM storeCondemnationM = null;
		StoreCondemnationT storeCondemnationT = null;
		String pvms = null;
		String ser = null;
		String obs = null;
		int us = 0;
		String backloaded = null;
		String rep = null;
		String nomenclature = null;
		String destroyed = null;
		String recser = null;
		String bunser = null;
		String boardreduced = null;
		String remarks = null;
		Date bosdate = null;
		String bosno = null;
		String au = null;
		String itemId = null;
		BigDecimal costprice = null;
		int Srno = 0;
		int qty = 0;
		String crvno = null;
		BigDecimal cost = null;
		String crvnocost = null;
		String serialNo = null;
		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;
		Set<StoreGrnT> storeSet = new HashSet<StoreGrnT>();
		String bosNo = box.get(BOS_ID);
		String bosDate = box.get(BOS_DATE);
		Date bosDate1 = HMSUtil.convertStringTypeDateToDateType(bosDate);
		String username = box.get(CHANGED_BY);
		int hospitalId = box.getInt("hospitalId");
		int deptId = box.getInt("deptId");
		String lastchangedtime = box.get(CHANGED_TIME);
		String lastchangedDate = box.get(CHANGED_DATE);
		Date lastchgdate = HMSUtil
				.convertStringTypeDateToDateType(lastchangedDate);
		session = (Session) getSession();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			condemnationList = hbt
					.find("from jkt.hms.masters.business.StoreCondemnationT as sct where sct.CondemM.Status = 'o'");
			if (condemnationList.size() > 0 && !condemnationList.isEmpty()) {
				for (int i = 0; i < condemnationList.size(); i++) {
					storeCondemnationT = (StoreCondemnationT) condemnationList
							.get(i);

					// int id = storeCondemnationT.getId();
					// storeCondemnationM=(StoreCondemnationM)hbt.load(StoreCondemnationM.class,
					// id);
					List storelist = hbt
							.find("from jkt.hms.masters.business.StoreCondemnationM as scm where scm.Status = 'o' ");
					if (storelist != null && !storelist.isEmpty()) {
						for (int j = 0; j < storelist.size(); j++) {
							StoreCondemnationM storeCondemnationM = (StoreCondemnationM) storelist
									.get(j);
							storeCondemnationM.setStatus("p");
							hbt.update(storeCondemnationM);
						}

					}

				}
				// ====== saving the bos m=======//
				StoreBosM storeBosM = new StoreBosM();
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(deptId);
				storeBosM.setDepartment(masDepartment);
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				storeBosM.setHospital(masHospital);
				storeBosM.setBosDate(bosDate1);
				storeBosM.setBosNo(bosNo);
				storeBosM.setLastChgBy(username);
				storeBosM.setLastChgDate(lastchgdate);
				storeBosM.setLastChgTime(lastchangedtime);
				storeBosM.setStatus("o");
				hbt.save(storeBosM);

				for (Iterator iterator = condemnationList.iterator(); iterator
						.hasNext();) {
					StoreCondemnationT storeCondemnationT1 = (StoreCondemnationT) iterator
							.next();

					try {
						if (storeCondemnationT1.getId() != null) {
							Srno = storeCondemnationT1.getId();
						} else {
							Srno = 0;
						}
					} catch (Exception e) {
						Srno = 0;
					}

					try {
						if (storeCondemnationT1.getItem().getPvmsNo() != null) {
							pvms = storeCondemnationT1.getItem().getPvmsNo();
						} else {
							pvms = "";
						}
					} catch (Exception e) {
						pvms = "";
					}

					try {
						if (storeCondemnationT1.getItem().getNomenclature() != null) {
							nomenclature = storeCondemnationT1.getItem()
									.getNomenclature();
						} else {
							nomenclature = "";
						}
					} catch (Exception e) {
						nomenclature = "";
					}

					try {
						if (storeCondemnationT1.getItem().getItemConversion()
								.getItemUnitName() != null) {
							au = storeCondemnationT1.getItem()
									.getItemConversion().getItemUnitName();
						} else {
							au = "";
						}

					} catch (Exception e) {
						au = "";
					}

					try {
						if (storeCondemnationT1.getSerialNo() != null) {
							serialNo = storeCondemnationT1.getSerialNo();
						} else {
							serialNo = "";
						}
					} catch (Exception e) {
						serialNo = "";
					}
					try {
						if (storeCondemnationT1.getQty() != null) {
							qty = storeCondemnationT1.getQty();
						} else {
							qty = 0;
						}
					} catch (Exception e) {
						qty = 0;
					}
					try {
						ser = "";
					} catch (Exception e) {
						ser = "";
					}
					try {
						obs = "";
					} catch (Exception e) {
						obs = "";
					}
					try {
						rep = "";
					} catch (Exception e) {
						rep = "";
					}
					try {
						if (storeCondemnationT1.getQty() != null) {
							us = storeCondemnationT1.getQty();
						} else {
							us = 0;
						}
					} catch (Exception e) {
						us = 0;
					}
					try {
						backloaded = "";
					} catch (Exception e) {
						backloaded = "";
					}
					try {
						destroyed = "";
					}

					catch (Exception e) {
						destroyed = "";
					}
					try {
						recser = "";
					} catch (Exception e) {
						recser = "";
					}
					try {
						boardreduced = "";
					} catch (Exception e) {
						boardreduced = "";
					}
					MasStoreItem item = storeCondemnationT1.getItem();
					int id = item.getId();
					Criteria c = session.createCriteria(StoreGrnT.class).add(
							Restrictions.eq("Item.Id", id));
					List storeGrntList = c.list();

					if (storeGrntList != null && !storeGrntList.isEmpty()) {
						for (int k = 0; k < storeGrntList.size(); k++) {
							StoreGrnT storeGrnT = (StoreGrnT) storeGrntList
									.get(k);

							if (storeGrnT.getFinalCostPrice() != null) {
								cost = storeGrnT.getFinalCostPrice();
							} else {
								BigDecimal costval = new BigDecimal(0);
								cost = costval;
							}
							Date dt = null;
							if (storeGrnT.getGrnMaster().getGrnDate() != null) {
								dt = storeGrnT.getGrnMaster().getGrnDate();
							} else {
								dt = null;
							}
							crvno = storeGrnT.getGrnMaster().getGrnNo();

							try {
								if ((dt != null) && (crvno != null))
									crvnocost = crvno.concat(dt.toString()
											+ cost.toString());
							} catch (Exception e) {
								crvnocost = "";
							}
							try {
								costprice = storeGrnT.getFinalCostPrice();
							} catch (Exception e) {
								costprice = new BigDecimal("0");
							}
						}
					} else {
						costprice = new BigDecimal("0");
						crvnocost = "";
					}
					try {
						remarks = "";
					} catch (Exception e) {
						remarks = "";
					}
					try {
						bosdate = null;
					} catch (Exception e) {
						bosdate = null;
					}
					try {
						bunser = "";
					} catch (Exception e) {
						bunser = "";
					}
					hData = new HashMap<String, Object>();
					hData.put("Srno", Srno);
					hData.put("pvms", pvms);
					hData.put("nomenclature", nomenclature);
					hData.put("au", au);
					hData.put("serialNo", serialNo);
					hData.put("qty", qty);
					hData.put("ser", ser);
					hData.put("obs", obs);
					hData.put("rep", rep);
					hData.put("us", us);
					hData.put("backloaded", backloaded);
					hData.put("destroyed", destroyed);
					hData.put("recser", recser);
					hData.put("boardreduced", boardreduced);
					hData.put("crvnocost", crvnocost);
					hData.put("cost", cost);
					hData.put("remarks", remarks);
					hData.put("bosno", bosno);
					hData.put("bosdate", bosdate);
					hData.put("bunser", bunser);
					vResult.add(hData);

					// ====== saving the bos t=======//

					StoreBosT storeBosT = new StoreBosT();
					storeBosT.setBosM(storeBosM);
					storeBosT.setCostDetails(costprice);
					storeBosT.setCrvnoDate(crvnocost);
					storeBosT.setItem(item);
					storeBosT.setQty(qty);
					storeBosT.setSerialNo(serialNo);
					storeBosT.setSrNo(Srno);
					storeBosT.setConditionUs(us);
					hbt.save(storeBosT);

				}
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
		List<StoreBosM> storeBosMList = new ArrayList<StoreBosM>();
		String BosNo = "";
		StoreBosM storeBosM = null;
		storeBosMList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.StoreBosM as sbm order by sbm.Id");
		if (storeBosMList.size() > 0 && !storeBosMList.isEmpty()) {
			for (int i = 0; i < storeBosMList.size(); i++) {
				storeBosM = storeBosMList.get(i);
				BosNo = storeBosM.getBosNo();
			}
		}

		// String Bono= BosNo.substring(0, 1);
		map.put("BosNo", BosNo);
		map.put("StoreBosMList", storeBosMList);
		return map;
	}

	public boolean updateGridItemsBos(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean updategrid = false;

		
		/*Vector retainedInService = box.getVector(BOARD_SERVICABLE);
		Vector repairNecessary = box.getVector(BACKLOADED);
		Vector returnToAFMSD = box.getVector(BOARD_DESTROYED);
		Vector disposedOff = box.getVector(BOARD_UN_SERVICABLE);
		Vector convertedToProduce = box.getVector(REDUCED_TO);
		
		Vector srno = box.getVector(SR_NO);
		Vector pvms = box.getVector(PVMS_NO);
		Vector items = box.getVector(NOMENCLATURE);
		Vector au = box.getVector(AU);
		Vector serialNo = box.getVector(SERIAL_NUMBER);
		Vector qty = box.getVector(QTY);
		Vector servicable = box.getVector(SERVICABLE);
		Vector repairable = box.getVector(REPAIRABLE);
		Vector unservicable = box.getVector(UN_SERVICABLE);
		Vector obs = box.getVector(OBS);
		Vector boardservicable = box.getVector(BOARD_SERVICABLE);
		Vector backloaded = box.getVector(BACKLOADED);
		Vector boardunservicable = box.getVector(BOARD_UN_SERVICABLE);
		Vector destyroyed = box.getVector(BOARD_DESTROYED);
		Vector reducedTo = box.getVector(REDUCED_TO);
		Vector crvcost = box.getVector(CRV_COST);
		Vector costprice = box.getVector(COST);
		Vector remarks = box.getVector(REMARKS);*/
		
		
		int retainedInService = box.getInt(BOARD_SERVICABLE);
		int repairNecessary = box.getInt(BACKLOADED);
		int returnToAFMSD = box.getInt(BOARD_DESTROYED);
		int disposedOff = box.getInt(BOARD_UN_SERVICABLE);
		int convertedToProduce = box.getInt(REDUCED_TO);
		
		int srno = box.getInt(SR_NO);
		String pvms = box.getString(PVMS_NO);
		String items = box.getString("nameItem1");
		String au = box.getString(AU);
		String serialNo = box.getString(SERIAL_NUMBER);
		int qty = box.getInt(QTY);
		int servicable = box.getInt(SERVICABLE);
		int repairable = box.getInt(REPAIRABLE);
		int unservicable = box.getInt(UN_SERVICABLE);
		int obs = box.getInt(OBS);
		String boardservicable = box.getString(BOARD_SERVICABLE);
		String backloaded = box.getString(BACKLOADED);
		String boardunservicable = box.getString(BOARD_UN_SERVICABLE);
		String destyroyed = box.getString(BOARD_DESTROYED);
		String reducedTo = box.getString(REDUCED_TO);
		String crvcost = box.getString(CRV_COST);
		String costprice = box.getString(COST);
		String remarks = box.getString(REMARKS);
		
		String bosNo = box.get(BOS_ID);
		String bosDate = box.get(BOS_DATE);
		Date bosDate1 = HMSUtil.convertStringTypeDateToDateType(bosDate);
		String username = box.get(CHANGED_BY);
		int hospitalId = box.getInt("hospitalId");
		int deptId = box.getInt("deptId");
		int sr_no = 0;
		String lastchangedtime = box.get(CHANGED_TIME);
		String lastchangedDate = box.get(CHANGED_DATE);
		Date lastchgdate = HMSUtil
				.convertStringTypeDateToDateType(lastchangedDate);

		try {
			List<StoreBosM> storeBosMList = new ArrayList<StoreBosM>();
			List<StoreBosT> storeBosTList = new ArrayList<StoreBosT>();
			StoreBosM storeBosM = new StoreBosM();
			
			session = (Session) getSession();
			Transaction tx = null;
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			tx = session.beginTransaction();
			storeBosMList = hbt
					.find("from jkt.hms.masters.business.StoreBosM as a where a.BosNo ='"
							+ bosNo + "'");

			if (storeBosMList.size() > 0) {
				storeBosM = (StoreBosM) storeBosMList.get(0);
				hbt.update(storeBosM);
				tx.commit();
			} else {

				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(deptId);
				storeBosM.setDepartment(masDepartment);
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				storeBosM.setHospital(masHospital);
				storeBosM.setBosDate(bosDate1);
				if(bosNo != null)
				{
				storeBosM.setBosNo(bosNo);
				}
				storeBosM.setLastChgBy(username);
				storeBosM.setLastChgDate(lastchgdate);
				storeBosM.setLastChgTime(lastchangedtime);
				storeBosM.setStatus("o");
				hbt.save(storeBosM);
				tx.commit();

			}
			

		
				
				tx = session.beginTransaction();
				/*storeBosTList = (List) hbt
						.find("from jkt.hms.masters.business.StoreBosT as a where a.SrNo ='"
								+ srno + "'");
				
				System.out.println("storeBosTList--->"+storeBosTList.size());
				if (storeBosTList.size() > 0 && !storeBosTList.isEmpty()) {
					for (Iterator iterator = storeBosTList.iterator(); iterator
							.hasNext();) {
						storeBosT = (StoreBosT) iterator.next();

					}
				}*/

				String item_id = items.substring(0, items.indexOf("["));
				MasStoreItem item = null;
				List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
				itemList = hbt
						.find("from jkt.hms.masters.business.MasStoreItem as a where a.Nomenclature ='"
								+ item_id + "'");
				if(itemList.size()>0){
					item = itemList.get(0);
					StoreBosT storeBosT = new StoreBosT();
					storeBosM.setId(storeBosM.getId());
					
					storeBosT.setBosM(storeBosM);
				/*storeBosT.setBoardBackload(""+backloaded.get(1));
				storeBosT.setBoardDestroy(""+destyroyed.get(1));
				storeBosT.setBoardRecSer(""+boardservicable.get(1));
				storeBosT.setBoardReduced(""+reducedTo.get(1));
				storeBosT.setBoardUs(""+boardunservicable.get(1));*/
				storeBosT.setConditionObs(obs);
				storeBosT.setConditionRep(repairable);
				storeBosT.setConditionSer(servicable);
				storeBosT.setConditionUs(unservicable);
				if ((costprice != null)
						&& (!costprice.equals("") && !costprice
								.equals("null"))) {
					storeBosT.setCostDetails(new BigDecimal(costprice
							.toString()));
				} else {
					BigDecimal costpricefinal = new BigDecimal(0);
					storeBosT.setCostDetails(costpricefinal);
				}
				storeBosT.setRetainedInService(retainedInService);
				storeBosT.setRepairNecessary(repairNecessary);
				storeBosT.setDisposedOff(disposedOff);
				storeBosT.setReturnToAFMSD(returnToAFMSD);
				storeBosT.setConvertedToProduce(convertedToProduce);
				
				storeBosT.setCrvnoDate(crvcost);
				storeBosT.setItem(item);
				storeBosT.setQty((qty));
				storeBosT.setRemarks(remarks);
				if(!serialNo.equals(""))
				{
				storeBosT.setSerialNo(serialNo);
				}else
				{
					storeBosT.setSerialNo("0");
				}
				storeBosT.setSrNo(srno);

				hbt.save(storeBosT);
				tx.commit();

			}
				//}
			/*System.out.println("srno.size--->"+srno.size());
			for (int i = 0; i > srno.size(); i++) {
				
				System.out.println("in-in for loop--");
				String srNo = srno.get(1).toString();
				System.out.println("in-srNo->"+srNo);
				StoreBosT storeBosT = new StoreBosT();
				tx = session.beginTransaction();
				storeBosTList = (List) hbt
						.find("from jkt.hms.masters.business.StoreBosT as a where a.SrNo ='"
								+ srNo + "'");
				
				System.out.println("storeBosTList--->"+storeBosTList.size());
				if (storeBosTList.size() > 0 && !storeBosTList.isEmpty()) {
					for (Iterator iterator = storeBosTList.iterator(); iterator
							.hasNext();) {
						storeBosT = (StoreBosT) iterator.next();

					}
				}

				String item_id = items.get(1).toString();
				MasStoreItem item = null;
				List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();

				itemList = hbt
						.find("from jkt.hms.masters.business.MasStoreItem as a where a.Nomenclature ='"
								+ item_id + "'");
				
				if(itemList.size()>0){
					item = itemList.get(0);
					 
					storeBosM.setId(storeBosM.getId());
					
					storeBosT.setBosM(storeBosM);
				storeBosT.setBoardBackload(""+backloaded.get(1));
				storeBosT.setBoardDestroy(""+destyroyed.get(1));
				storeBosT.setBoardRecSer(""+boardservicable.get(1));
				storeBosT.setBoardReduced(""+reducedTo.get(1));
				storeBosT.setBoardUs(""+boardunservicable.get(1));
				storeBosT.setConditionObs(obs.get(1).toString());
				storeBosT.setConditionRep(repairable.get(1).toString());
				storeBosT.setConditionSer(servicable.get(1).toString());
				storeBosT.setConditionUs(unservicable.get(1).toString());
				if ((costprice.get(1) != null)
						&& (!costprice.get(1).equals("") && !costprice.get(1)
								.equals("null"))) {
					storeBosT.setCostDetails(new BigDecimal(costprice.get(1)
							.toString()));
				} else {
					BigDecimal costpricefinal = new BigDecimal(0);
					storeBosT.setCostDetails(costpricefinal);
				}
				storeBosT.setRetainedInService(new Integer(retainedInService.get(1).toString()));
				storeBosT.setRepairNecessary(new Integer(repairNecessary.get(1).toString()));
				storeBosT.setDisposedOff(new Integer(disposedOff.get(1).toString()));
				storeBosT.setReturnToAFMSD(new Integer(returnToAFMSD.get(1).toString()));
				storeBosT.setConvertedToProduce(new Integer(convertedToProduce.get(1).toString()));
				
				storeBosT.setCrvnoDate(crvcost.get(1).toString());
				storeBosT.setItem(item);
				storeBosT.setQty(new Integer(qty.get(1).toString()));
				storeBosT.setRemarks(remarks.get(1).toString());
				storeBosT.setSerialNo(serialNo.get(1).toString());
				storeBosT.setSrNo(new Integer(srno.get(1).toString()));

				hbt.saveOrUpdate(storeBosT);
				tx.commit();

			}
				}*/

			updategrid = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (updategrid) {
			map = searchBosData(bosNo, box);

		}
        map.put("updategrid", updategrid);
		//return map;
        return updategrid;
	}

	public Map searchBosData(String BosNo, Box box) {
		String pvms = null;
		//String ser = null;
		int ser=0;
		//String obs = null;
		int us = 0;
		int obs = 0;
		int rep = 0;
		 
		//String us = null;
		String backloaded = null;
		//String rep = null;
		String nomenclature = null;
		String destroyed = null;
		String recser = null;
		String bunser = null;
		String boardreduced = null;
		String remarks = null;
		Date bosdate = null;
		String bosno = null;
		String au = null;
		String itemId = null;
		String costprice = null;
		int Srno = 0;
		int qty = 0;
		String crvno = null;
		BigDecimal cost = null;
		String crvnocost = null;
		String serialNo = null;
		String bosStatus = "o";
		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;
		StoreBosT storeBosT = null;
		StoreBosM storeBosM = null;
		Map<String, Object> map = new HashMap<String, Object>();
		List storeBosList = new ArrayList();
		session = (Session) getSession();
		Transaction tx = null;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		tx = session.beginTransaction();
		storeBosList = hbt
				.find("from jkt.hms.masters.business.StoreBosT as b where b.BosM.BosNo ='"
						+ BosNo + "'");
		if (storeBosList.size() > 0 && !storeBosList.isEmpty()) {
			for (int i = 0; i < storeBosList.size(); i++) {
				storeBosT = (StoreBosT) storeBosList.get(i);
				int id = storeBosT.getBosM().getId();
				storeBosM = (StoreBosM) hbt.get(StoreBosM.class, id);
				bosStatus = storeBosM.getStatus();
			}

			tx.commit();
			for (Iterator iterator = storeBosList.iterator(); iterator
					.hasNext();) {
				StoreBosT storeBosT1 = (StoreBosT) iterator.next();
				try {
					if (storeBosT1.getId() != null) {
						Srno = storeBosT1.getId();
					} else {
						Srno = 0;
					}
				} catch (Exception e) {
					Srno = 0;
				}

				try {
					if (storeBosT1.getItem().getPvmsNo() != null) {
						pvms = storeBosT1.getItem().getPvmsNo();
					} else {
						pvms = "";
					}
				} catch (Exception e) {
					pvms = "";
				}

				try {
					if (storeBosT1.getItem().getNomenclature() != null) {
						nomenclature = storeBosT1.getItem().getNomenclature();
					} else {
						nomenclature = "";
					}
				} catch (Exception e) {
					nomenclature = "";
				}

				try {
					if (storeBosT1.getItem().getItemConversion()
							.getItemUnitName() != null) {
						au = storeBosT1.getItem().getItemConversion()
								.getItemUnitName();
					} else {
						au = "";
					}

				} catch (Exception e) {
					au = "";
				}

				try {
					if (storeBosT1.getSerialNo() != null) {
						serialNo = storeBosT1.getSerialNo();
					} else {
						serialNo = "";
					}
				} catch (Exception e) {
					serialNo = "";
				}
				try {
					if (storeBosT1.getQty() != null) {
						qty = storeBosT1.getQty();
					} else {
						qty = 0;
					}
				} catch (Exception e) {
					qty = 0;
				}
				try {
					if (storeBosT1.getConditionSer() != null) {
						ser = storeBosT1.getConditionSer();
					} else {
						ser = 0;
					}
				} catch (Exception e) {
					ser = 0;
				}
				try {
					if (storeBosT1.getConditionObs() != null) {
						obs = storeBosT1.getConditionObs();
					} else {
						obs = 0;
					}
				} catch (Exception e) {
					obs = 0;
				}
				try {
					if (storeBosT1.getConditionRep() != null) {
						rep = storeBosT1.getConditionRep();
					} else {
						rep = 0;
					}
				} catch (Exception e) {
					rep = 0;
				}
				try {
					if (storeBosT1.getConditionUs() != null) {
						us = storeBosT1.getConditionUs();
					} else {
						us = 0;
					}
				} catch (Exception e) {
					us = 0;
				}
				try {
					if (storeBosT1.getBoardBackload() != null) {
						backloaded = storeBosT1.getBoardBackload();
					} else {
						backloaded = "";
					}
				} catch (Exception e) {
					backloaded = "";
				}
				try {
					if (storeBosT1.getBoardDestroy() != null) {
						destroyed = storeBosT1.getBoardDestroy();
					} else {
						destroyed = "";
					}

				} catch (Exception e) {
					destroyed = "";
				}
				try {
					if (storeBosT1.getBoardRecSer() != null) {
						recser = storeBosT1.getBoardRecSer();
					} else {
						recser = "";
					}
				} catch (Exception e) {
					recser = "";
				}
				try {
					if (storeBosT1.getBoardReduced() != null) {
						boardreduced = storeBosT1.getBoardReduced();
					} else {
						boardreduced = "";
					}
				} catch (Exception e) {
					boardreduced = "";
				}
				try {
					if (storeBosT1.getCrvnoDate() != null) {
						crvnocost = storeBosT1.getCrvnoDate();
					} else {
						crvnocost = "";
					}
				} catch (Exception e) {
					crvnocost = "";
				}
				try {
					if (storeBosT1.getCostDetails() != null) {
						cost = storeBosT1.getCostDetails();
					} else {
						cost = null;
					}
				} catch (Exception e) {
					cost = null;
				}
				try {
					if (storeBosT1.getRemarks() != null) {
						remarks = storeBosT1.getRemarks();
					} else {
						remarks = "";
					}
				} catch (Exception e) {
					remarks = "";
				}

				try {

					bosno = storeBosT1.getBosM().getBosNo();
				} catch (Exception e) {
					bosno = "";
				}
				try {
					bosdate = storeBosT1.getBosM().getBosDate();
				} catch (Exception e) {
					bosdate = null;
				}
				try {
					if (storeBosT1.getBoardUs() != null) {
						bunser = storeBosT1.getBoardUs();
					} else {
						bunser = "";
					}
				} catch (Exception e) {
					bunser = "";
				}
				hData = new HashMap<String, Object>();
				hData.put("Srno", Srno);
				hData.put("pvms", pvms);
				hData.put("nomenclature", nomenclature);
				hData.put("au", au);
				hData.put("serialNo", serialNo);
				hData.put("qty", qty);
				hData.put("ser", ser);
				hData.put("obs", obs);
				hData.put("rep", rep);
				hData.put("us", us);
				hData.put("backloaded", backloaded);
				hData.put("destroyed", destroyed);
				hData.put("recser", recser);
				hData.put("boardreduced", boardreduced);
				hData.put("crvnocost", crvnocost);
				hData.put("cost", cost);
				hData.put("remarks", remarks);
				hData.put("bosno", bosno);
				hData.put("bosdate", bosdate);
				hData.put("bunser", bunser);
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
		List<StoreBosM> storeBosMList = new ArrayList<StoreBosM>();
		storeBosMList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.StoreBosM as sbm order by sbm.Id");
		map.put("StoreBosMList", storeBosMList);
		map.put("pagedArray", pagedArray);
		map.put("bosno", bosno);
		map.put("bosStatus", bosStatus);
		return map;
	}

	public Map updateSearchGridItemsBos(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean updategrid = false;
		Vector srno = box.getVector(SR_NO);
		Vector pvms = box.getVector(PVMS_NO);
		Vector items = box.getVector(NOMENCLATURE);
		Vector au = box.getVector(AU);
		Vector serialNo = box.getVector(SERIAL_NUMBER);
		Vector qty = box.getVector(QTY);
		Vector servicable = box.getVector(SERVICABLE);
		Vector repairable = box.getVector(REPAIRABLE);
		Vector unservicable = box.getVector(UN_SERVICABLE);
		Vector obs = box.getVector(OBS);
		Vector boardservicable = box.getVector(BOARD_SERVICABLE);
		Vector backloaded = box.getVector(BACKLOADED);
		Vector boardunservicable = box.getVector(BOARD_UN_SERVICABLE);
		Vector destyroyed = box.getVector(BOARD_DESTROYED);
		Vector reducedTo = box.getVector(REDUCED_TO);
		Vector crvcost = box.getVector(CRV_COST);
		Vector costprice = box.getVector(COST);
		Vector remarks = box.getVector(REMARKS);
		String bosNo = box.get(BOS_ID);
		String bosDate = box.get(BOS_DATE);
		Date bosDate1 = HMSUtil.convertStringTypeDateToDateType(bosDate);
		String username = box.get(CHANGED_BY);
		int hospitalId = box.getInt("hospitalId");
		int deptId = box.getInt("deptId");
		int sr_no = 0;
		String lastchangedtime = box.get(CHANGED_TIME);
		String lastchangedDate = box.get(CHANGED_DATE);
		Date lastchgdate = HMSUtil
				.convertStringTypeDateToDateType(lastchangedDate);

		try {
			List<StoreBosM> storeBosMList = new ArrayList<StoreBosM>();
			List<StoreBosT> storeBosTList = new ArrayList<StoreBosT>();
			StoreBosM storeBosM = new StoreBosM();

			session = (Session) getSession();
			Transaction tx = null;
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			tx = session.beginTransaction();
			storeBosMList = hbt
					.find("from jkt.hms.masters.business.StoreBosM as a where a.BosNo ='"
							+ bosNo + "'");

			if (storeBosMList.size() > 0 && !storeBosMList.isEmpty()) {
				storeBosM = (StoreBosM) storeBosMList.get(0);
				hbt.update(storeBosM);
				tx.commit();
			} else {

				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(deptId);
				storeBosM.setDepartment(masDepartment);
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				storeBosM.setHospital(masHospital);
				storeBosM.setBosDate(bosDate1);
				storeBosM.setBosNo(bosNo);
				storeBosM.setLastChgBy(username);
				storeBosM.setLastChgDate(lastchgdate);
				storeBosM.setLastChgTime(lastchangedtime);
				storeBosM.setStatus("o");
				hbt.save(storeBosM);
				tx.commit();

			}

			for (int i = 0; i < srno.size(); i++) {
				StoreBosT storeBosT = new StoreBosT();
				tx = session.beginTransaction();
				storeBosTList = hbt
						.find("from jkt.hms.masters.business.StoreBosT as b where b.BosM.BosNo ='"
								+ bosNo + "'");
				if (storeBosTList.size() > 0 && !storeBosTList.isEmpty()) {
					storeBosT = storeBosTList.get(i);
					storeBosT.setBosM(storeBosTList.get(i).getBosM());
					String item_id = items.get(i).toString();
					MasStoreItem item = null;
					List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();

					itemList = hbt
							.find("from jkt.hms.masters.business.MasStoreItem as a where a.Nomenclature ='"
									+ item_id + "'");
					if (itemList.size() > 0)
						item = itemList.get(0);
					storeBosT.setItem(item);
					{
						try {
							sr_no = storeBosTList.get(i).getSrNo().intValue();
							storeBosT.setSrNo(sr_no);
						} catch (Exception e) {
							storeBosT.setSrNo(0);
						}

						try {
							storeBosT.setSerialNo(serialNo.get(i).toString());
						} catch (Exception e) {
							storeBosT.setSerialNo("");
						}
						try {
							storeBosT.setRemarks(remarks.get(i).toString());
						} catch (Exception e) {
							storeBosT.setRemarks("");
						}

						try {
							storeBosT
									.setQty(new Integer(qty.get(i).toString()));
						} catch (Exception e) {
							storeBosT.setQty(0);
						}
						try {
							storeBosT.setCrvnoDate(crvcost.get(i).toString());
						} catch (Exception e) {
							storeBosT.setCrvnoDate("");
						}
						try {
							BigDecimal costprice1 = new BigDecimal(costprice
									.get(i).toString());
							storeBosT.setCostDetails(costprice1);
						} catch (Exception e) {
							storeBosT.setCostDetails(null);
						}

						try {
							//storeBosT.setConditionUs(unservicable.get(i).toString());
							storeBosT.setConditionUs(new Integer(unservicable.get(i).toString()));
						} catch (Exception e) {
							storeBosT.setConditionUs(0);
						}
						try {
							storeBosT.setCrvnoDate(crvcost.get(i).toString());
						} catch (Exception e) {
							storeBosT.setCrvnoDate("");
						}
						try {
							//storeBosT.setConditionSer(servicable.get(i).toString());
							storeBosT.setConditionSer(new Integer(servicable.get(i).toString()));
						} catch (Exception e) {
							storeBosT.setConditionSer(0);
						}
						try {
							//storeBosT.setConditionRep(repairable.get(i).toString());
							storeBosT.setConditionRep(new Integer(repairable.get(i).toString()));
						} catch (Exception e) {
							storeBosT.setConditionRep(0);
						}
						try {
							//storeBosT.setConditionObs(obs.get(i).toString());
							storeBosT.setConditionObs(new Integer(obs.get(i).toString()));
						} catch (Exception e) {
							storeBosT.setConditionObs(0);
						}
						try {
							storeBosT.setBoardUs(boardunservicable.get(i)
									.toString());
						} catch (Exception e) {
							storeBosT.setBoardUs("");
						}
						try {
							storeBosT.setBoardReduced(reducedTo.get(i)
									.toString());
						} catch (Exception e) {
							storeBosT.setBoardReduced("");
						}
						try {
							storeBosT.setBoardRecSer(boardservicable.get(i)
									.toString());
						} catch (Exception e) {
							storeBosT.setBoardRecSer("");
						}
						try {
							storeBosT.setBoardDestroy(destyroyed.get(i)
									.toString());
						} catch (Exception e) {
							storeBosT.setBoardDestroy("");
						}
						try {
							storeBosT.setBoardBackload(backloaded.get(i)
									.toString());
						} catch (Exception e) {
							storeBosT.setBoardBackload("");
						}
						hbt.update(storeBosT);
						tx.commit();
					}
				} else {
					{

						tx = session.beginTransaction();
						String item_id = items.get(i).toString();
						MasStoreItem item = null;
						List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();

						itemList = hbt
								.find("from jkt.hms.masters.business.MasStoreItem as a where a.Nomenclature ='"
										+ item_id + "'");
						if (itemList.size() > 0)
							item = itemList.get(0);
						storeBosT
								.setBoardBackload(backloaded.get(i).toString());
						storeBosT.setBoardDestroy(destyroyed.get(i).toString());
						storeBosT.setBoardRecSer(boardservicable.get(i)
								.toString());
						storeBosT.setBoardReduced(reducedTo.get(i).toString());
						storeBosT.setBoardUs(boardunservicable.get(i)
								.toString());
						storeBosT.setBosM(storeBosM);
						/*storeBosT.setConditionObs(obs.get(i).toString());
						storeBosT.setConditionRep(repairable.get(i).toString());
						storeBosT.setConditionSer(servicable.get(i).toString());
						storeBosT.setConditionUs(unservicable.get(i).toString());*/
						
						storeBosT.setConditionObs(new Integer(obs.get(i).toString()));
						storeBosT.setConditionRep(new Integer(repairable.get(i).toString()));
						storeBosT.setConditionSer(new Integer(servicable.get(i).toString()));
						storeBosT.setConditionUs(new Integer(unservicable.get(i).toString()));
						
						if (costprice.get(i).toString() != null) {
							BigDecimal costBigDecimal = new BigDecimal(
									costprice.get(i).toString());
							storeBosT.setCostDetails(costBigDecimal);
						}
						storeBosT.setCrvnoDate(crvcost.get(i).toString());
						storeBosT.setItem(item);
						storeBosT.setQty(new Integer(qty.get(i).toString()));
						storeBosT.setRemarks(remarks.get(i).toString());
						storeBosT.setSerialNo(serialNo.get(i).toString());
						storeBosT.setSrNo(new Integer(srno.get(i).toString()));

						hbt.save(storeBosT);
						tx.commit();

					}
				}
			}
			updategrid = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		map = searchBosData(bosNo, box);
		return map;
	}

	public Map getBosData(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<StoreBosT> storeBosList = new ArrayList<StoreBosT>();
		// StoreCondemnationM storeCondemnationM = null;
		StoreCondemnationT storeCondemnationT = null;
		String pvms = null;
		String nomenclature = null;
		String au = null;
		String itemId = null;
		/*String ser = null;
		String obs = null;
		String unser = null;
		String rep = null;*/
		int ser=0;
		int obs=0;
		int unser=0;
		int rep=0;
		
		String backloaded = null;
		String destroyed = null;
		String recser = null;
		String bunser = null;
		String boardreduced = null;
		String remarks = null;
		Date bosdate = null;
		String bosno = null;
		int Srno = 0;
		int qty = 0;
		String crvno = null;
		BigDecimal cost = null;
		BigDecimal costprice = null;
		String crvnocost = null;
		String serialNo = null;
		String bosNo = box.get(BOS_ID);
		int departmentId = box.getInt("deptId");
		int hospitalId = box.getInt("hospitalId");
		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;
		Set<StoreGrnT> storeSet = new HashSet<StoreGrnT>();
		session = (Session) getSession();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			storeBosList = hbt
					.find("from jkt.hms.masters.business.StoreBosT as sbt where sbt.BosM.BosNo ='"
							+ bosNo
							+ "' and sbt.BosM.Department.Id='"
							+ departmentId
							+ "'and sbt.BosM.Hospital.Id='"
							+ hospitalId + "'");

			for (Iterator iterator = storeBosList.iterator(); iterator
					.hasNext();) {
				StoreBosT storeBosT = (StoreBosT) iterator.next();

				try {
					if (storeBosT.getId() != null) {
						Srno = storeBosT.getId();
					} else {
						Srno = 0;
					}
				} catch (Exception e) {
					Srno = 0;
				}

				try {
					if (storeBosT.getItem().getPvmsNo() != null) {
						pvms = storeBosT.getItem().getPvmsNo();
					} else {
						pvms = "";
					}
				} catch (Exception e) {
					pvms = "";
				}

				try {
					if (storeBosT.getItem().getNomenclature() != null) {
						nomenclature = storeBosT.getItem().getNomenclature();
					} else {
						nomenclature = "";
					}
				} catch (Exception e) {
					nomenclature = "";
				}

				try {
					if (storeBosT.getItem().getItemConversion()
							.getItemUnitName() != null) {
						au = storeBosT.getItem().getItemConversion()
								.getItemUnitName();
					} else {
						au = "";
					}

				} catch (Exception e) {
					au = "";
				}

				try {
					if (storeBosT.getSerialNo() != null) {
						serialNo = storeBosT.getSerialNo();
					} else {
						serialNo = "";
					}
				} catch (Exception e) {
					serialNo = "";
				}
				try {
					if (storeBosT.getQty() != null) {
						qty = storeBosT.getQty();
					} else {
						qty = 0;
					}
				} catch (Exception e) {
					qty = 0;
				}
				try {
					if (storeBosT.getConditionSer() != null) {
						ser = storeBosT.getConditionSer();
					} else {
						ser = 0;
					}
				} catch (Exception e) {
					ser = 0;
				}
				try {
					if (storeBosT.getConditionObs() != null) {
						obs = storeBosT.getConditionObs();
					} else {
						obs = 0;
					}
				} catch (Exception e) {
					obs = 0;
				}
				try {
					if (storeBosT.getConditionRep() != null) {
						rep = storeBosT.getConditionRep();
					} else {
						rep = 0;
					}
				} catch (Exception e) {
					rep = 0;
				}
				try {
					if (storeBosT.getConditionUs() != null) {
						unser = storeBosT.getConditionUs();
					} else {
						unser = 0;
					}
				} catch (Exception e) {
					unser = 0;
				}
				try {
					if (storeBosT.getBoardBackload() != null) {
						backloaded = storeBosT.getBoardBackload();
					} else {
						backloaded = "";
					}
				} catch (Exception e) {
					backloaded = "";
				}
				try {
					if (storeBosT.getBoardDestroy() != null) {
						destroyed = storeBosT.getBoardDestroy();
					} else {
						destroyed = "";
					}

				} catch (Exception e) {
					destroyed = "";
				}
				try {
					if (storeBosT.getBoardRecSer() != null) {
						recser = storeBosT.getBoardRecSer();
					} else {
						recser = "";
					}
				} catch (Exception e) {
					recser = "";
				}
				try {
					if (storeBosT.getBoardReduced() != null) {
						boardreduced = storeBosT.getBoardReduced();
					} else {
						boardreduced = "";
					}
				} catch (Exception e) {
					boardreduced = "";
				}
				try {
					if (storeBosT.getCrvnoDate() != null) {
						crvnocost = storeBosT.getCrvnoDate();
					} else {
						crvnocost = "";
					}
				} catch (Exception e) {
					crvnocost = "";
				}
				try {
					if (storeBosT.getCostDetails() != null) {
						cost = storeBosT.getCostDetails();
					} else {
						cost = null;
					}
				} catch (Exception e) {
					cost = null;
				}
				try {
					if (storeBosT.getRemarks() != null) {
						remarks = storeBosT.getRemarks();
					} else {
						remarks = "";
					}
				} catch (Exception e) {
					remarks = "";
				}

				try {

					bosno = storeBosT.getBosM().getBosNo();
				} catch (Exception e) {
					bosno = "";
				}
				try {
					bosdate = storeBosT.getBosM().getBosDate();
				} catch (Exception e) {
					bosdate = null;
				}
				try {
					if (storeBosT.getBoardUs() != null) {
						bunser = storeBosT.getBoardUs();
					} else {
						bunser = "";
					}
				} catch (Exception e) {
					bunser = "";
				}

				hData = new HashMap<String, Object>();
				hData.put("Srno", Srno);
				hData.put("pvms", pvms);
				hData.put("nomenclature", nomenclature);
				hData.put("au", au);
				hData.put("serialNo", serialNo);
				hData.put("qty", qty);
				hData.put("ser", ser);
				hData.put("obs", obs);
				hData.put("rep", rep);
				hData.put("unser", unser);
				hData.put("backloaded", backloaded);
				hData.put("destroyed", destroyed);
				hData.put("recser", recser);
				hData.put("boardreduced", boardreduced);
				hData.put("crvnocost", crvnocost);
				hData.put("cost", cost);
				hData.put("remarks", remarks);
				hData.put("bosno", bosno);
				hData.put("bosdate", bosdate);
				hData.put("bunser", bunser);
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
		List<StoreBosM> storeBosMList = new ArrayList<StoreBosM>();
		String BosNo = "";
		StoreBosM storeBosM = null;
		storeBosMList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.StoreBosM as sbm order by sbm.Id");
		if (storeBosMList.size() > 0 && !storeBosMList.isEmpty()) {
			for (int i = 0; i < storeBosMList.size(); i++) {
				storeBosM = storeBosMList.get(i);
				BosNo = storeBosM.getBosNo();
			}
		}

		map.put("BosNo", BosNo);
		map.put("StoreBosMList", storeBosMList);
		return map;

	}

	// ==========hitesh methods end=====//

	// *********************************************************************************************************************
	// ------------------------------------Start of Methods Written By Anand &
	// Vivek ------------------------------------------
	// ****************************************************************************************************************

	// ============================Start of ME Scale Equipment
	// Details==============================

	public Map getMeScaleDescription(int meScaleNumber, Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasStoreMeScale masStoreMeScale = null;
		StoreMeScaleDetails meScaleDetails = null;
		MasStoreItem masStoreItem = null;
		String meScaleDescription = "";
		Session session = (Session) getSession();
		String pvms = null;
		String oldpvms = null;
		String nomenclature = null;
		String au = null;
		BigDecimal qty = null;
		String section = "";
		int id = 0;
		int itemConversionId = 0;
		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;

		// ---------Session Information------------------
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		if (box.get("deptId") != null) {
			deptId = Integer.parseInt("" + box.get("deptId"));
		}
		if (box.get("hospitalId") != null) {
			hospitalId = Integer.parseInt("" + box.get("hospitalId"));
		}
		// ---------------------------------------------------
		int meScaleMasterId = 0;
		if (box.get(ME_SCALE_NUMBER) != null) {
			meScaleMasterId = Integer.parseInt("" + box.get(ME_SCALE_NUMBER));
		}
		List<MasStoreMeScale> tempList = new ArrayList<MasStoreMeScale>();
		String meScaleDesc = "";
		tempList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasStoreMeScale as msms where msms.Id='"
						+ meScaleMasterId + "' ");
		for (MasStoreMeScale masStoreMeScale2 : tempList) {
			meScaleDesc = "" + masStoreMeScale2.getMeScaleDescription();
		}
		List<StoreMeScaleDetails> storeMeScaleDetailsList = new ArrayList<StoreMeScaleDetails>();
		storeMeScaleDetailsList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.StoreMeScaleDetails as masms where masms.MeScale.id='"
								+ meScaleMasterId
								+ "' and masms.Department.Id='"
								+ deptId
								+ "'  and masms.Hospital.Id='"
								+ hospitalId
								+ "'");
		List<MasStoreMeScale> searchMeScaleList = new ArrayList<MasStoreMeScale>();
		searchMeScaleList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasStoreMeScale as msms where msms.Status='y'");
		if (storeMeScaleDetailsList.size() > 0) {

		} else {

		}
		map.put("storeMeScaleDetailsList", storeMeScaleDetailsList);
		for (Iterator iterator = storeMeScaleDetailsList.iterator(); iterator
				.hasNext();) {

			StoreMeScaleDetails storeMeScaleDetails = (StoreMeScaleDetails) iterator
					.next();

			try {
				id = Integer.parseInt("" + storeMeScaleDetails.getId());
			} catch (Exception e) {
				id = 0;
			}
			try {
				pvms = "" + storeMeScaleDetails.getItem().getPvmsNo();
			} catch (Exception e) {
				pvms = "";
			}
			try {
				oldpvms = storeMeScaleDetails.getItem().getOldNivNo();
			} catch (Exception e) {
				oldpvms = "";
			}
			try {
				nomenclature = storeMeScaleDetails.getItem().getNomenclature();
			} catch (Exception e) {
				nomenclature = "";
			}
			try {
				au = storeMeScaleDetails.getItem().getItemConversion()
						.getItemUnitName();
			} catch (Exception e) {
				au = "";
			}
			try {
				section = storeMeScaleDetails.getItem().getSection()
						.getSectionName();
			} catch (Exception e) {
				section = "";
			}
			try {
				qty = new BigDecimal("" + storeMeScaleDetails.getQty());
			} catch (Exception e) {
				qty = new BigDecimal(0);
			}
			hData = new HashMap<String, Object>();
			hData.put("pvms", pvms);
			hData.put("nomenclature", nomenclature);
			hData.put("oldpvms", oldpvms);
			hData.put("section", section);
			hData.put("au", au);
			hData.put("qty", qty);
			hData.put("id", id);
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
		map.put("searchMeScaleList", searchMeScaleList);
		map.put("meScaleDesc", meScaleDesc);
		return map;
	}

	public Map<String, Object> getMeScaleData(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasStoreMeScale masStoreMeScale = null;
		StoreMeScaleDetails meScaleDetails = null;
		MasStoreItem masStoreItem = null;
		String meScaleDescription = "";
		Session session = (Session) getSession();
		String pvms = null;
		String oldpvms = null;
		String nomenclature = null;
		String au = null;
		BigDecimal qty = null;
		String section = "";
		int id = 0;
		int itemConversionId = 0;
		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;

		// ---------Session Information------------------
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		if (box.get("deptId") != null) {
			deptId = Integer.parseInt("" + box.get("deptId"));
		}
		if (box.get("hospitalId") != null) {
			hospitalId = Integer.parseInt("" + box.get("hospitalId"));
		}
		// ---------------------------------------------------
		int meScaleMasterId = 0;
		if (box.get(ME_SCALE_NUMBER) != null) {
			meScaleMasterId = Integer.parseInt("" + box.get(ME_SCALE_NUMBER));
		}
		List<MasStoreMeScale> tempList = new ArrayList<MasStoreMeScale>();
		String meScaleDesc = "";
		tempList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasStoreMeScale as msms where msms.Id='"
						+ meScaleMasterId + "' ");
		for (MasStoreMeScale masStoreMeScale2 : tempList) {
			meScaleDesc = "" + masStoreMeScale2.getMeScaleDescription();
		}
		List<StoreMeScaleDetails> storeMeScaleDetailsList = new ArrayList<StoreMeScaleDetails>();
		storeMeScaleDetailsList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.StoreMeScaleDetails as masms where masms.MeScale.id='"
								+ meScaleMasterId
								+ "' and masms.Department.Id='"
								+ deptId
								+ "'  and masms.Hospital.Id='"
								+ hospitalId
								+ "'");
		List<MasStoreMeScale> searchMeScaleList = new ArrayList<MasStoreMeScale>();
		searchMeScaleList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasStoreMeScale as msms where msms.Status='y'");
		if (storeMeScaleDetailsList.size() > 0) {

		} else {
		}
		map.put("storeMeScaleDetailsList", storeMeScaleDetailsList);
		for (Iterator iterator = storeMeScaleDetailsList.iterator(); iterator
				.hasNext();) {

			StoreMeScaleDetails storeMeScaleDetails = (StoreMeScaleDetails) iterator
					.next();

			try {
				id = Integer.parseInt("" + storeMeScaleDetails.getId());
			} catch (Exception e) {
				id = 0;
			}
			try {
				pvms = "" + storeMeScaleDetails.getItem().getPvmsNo();
			} catch (Exception e) {
				pvms = "";
			}
			try {
				oldpvms = storeMeScaleDetails.getItem().getOldNivNo();
			} catch (Exception e) {
				oldpvms = "";
			}
			try {
				nomenclature = storeMeScaleDetails.getItem().getNomenclature();
			} catch (Exception e) {
				nomenclature = "";
			}
			try {
				au = storeMeScaleDetails.getItem().getItemConversion()
						.getItemUnitName();
			} catch (Exception e) {
				au = "";
			}
			try {
				section = storeMeScaleDetails.getItem().getSection()
						.getSectionName();
			} catch (Exception e) {
				section = "";
			}
			try {
				qty = new BigDecimal("" + storeMeScaleDetails.getQty());
			} catch (Exception e) {
				qty = new BigDecimal(0);
			}
			hData = new HashMap<String, Object>();
			hData.put("pvms", pvms);
			hData.put("nomenclature", nomenclature);
			hData.put("oldpvms", oldpvms);
			hData.put("section", section);
			hData.put("au", au);
			hData.put("qty", qty);
			hData.put("id", id);
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
		map.put("searchMeScaleList", searchMeScaleList);
		map.put("meScaleDesc", meScaleDesc);
		return map;
	}

	public Map<String, Object> updateGridItemsInViewMeScale(Box box) {
		boolean flag = false;
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreMeScaleDetails> storeMeScaleDetailsList = new ArrayList<StoreMeScaleDetails>();
		List<MasStoreMeScale> meScaleDescriptionList = new ArrayList<MasStoreMeScale>();
		StoreMeScaleDetails storeMeScaleDetails = new StoreMeScaleDetails();
		;
		Session session = (Session) getSession();
		// ---------Session Information------------------
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		if (box.get("deptId") != null) {
			deptId = Integer.parseInt("" + box.get("deptId"));
		}
		if (box.get("hospitalId") != null) {
			hospitalId = Integer.parseInt("" + box.get("hospitalId"));
		}
		// ---------------------------------------------------

		Vector qty = box.getVector("qty");
		Vector id = box.getVector("id");
		int meScaleNumber = Integer.parseInt(box.get(ME_SCALE_NUMBER)
				.toString());
		try {
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			String obj = null;
			for (int i = 0; i < id.size(); i++) {
				int tempId = Integer.parseInt(id.get(i).toString());
				StoreMeScaleDetails tObj = (StoreMeScaleDetails) hbt.load(
						StoreMeScaleDetails.class, tempId);
				BigDecimal val = new BigDecimal(Integer.parseInt(qty.get(i)
						.toString()));
				tObj.setQty(val);
				hbt.update(tObj);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		box.put("deptId", deptId);
		box.put("hospitalId", hospitalId);
		map = getMeScaleDescription(meScaleNumber, box);
		return map;
	}

	public Map<String, Object> searchItemsForMEScale(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();

		String pvms = null;
		String nomenclature = null;
		String strength = null;
		String au = null;
		Integer qtymmf = null;
		// BigDecimal qty = null;
		int item_id = 0;

		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector meItems = new Vector();
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;

		List<StoreMeScaleDetails> storeMeScaleList = new ArrayList<StoreMeScaleDetails>();
		// ---------Session Information------------------
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		if (box.get("deptId") != null) {
			deptId = Integer.parseInt("" + box.get("deptId"));
		}
		if (box.get("hospitalId") != null) {
			hospitalId = Integer.parseInt("" + box.get("hospitalId"));
		}
		// ---------------------------------------------------
		int meScaleMasterId = 0;
		try {
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			meScaleMasterId = Integer.parseInt("" + box.get("meScaleMasterId"));
			if (box.getInt("meScaleMasterId") != 0)
				storeMeScaleList = hbt
						.find("from jkt.hms.masters.business.StoreMeScaleDetails as smsd where smsd.MeScale.Id='"
								+ meScaleMasterId
								+ "' and smsd.Department.Id='"
								+ deptId
								+ "' and smsd.Hospital.Id='" + hospitalId + "'");

			for (Iterator iterator = storeMeScaleList.iterator(); iterator
					.hasNext();) {
				StoreMeScaleDetails details = (StoreMeScaleDetails) iterator
						.next();
				meItems.add(details.getItem().getId());
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		try {
			List objectList = new ArrayList();
			String str = box.getString("search_text") + "%";
			String qry1 = "SELECT  mesc.item_id FROM store_me_scale_details mesc where mesc.me_scale_id='"
					+ meScaleMasterId
					+ "' and mesc.department_id='"
					+ deptId
					+ "' ";
			objectList = (List) session.createSQLQuery(qry1).list();
			if (objectList.size() != 0) {
				Criteria c = session.createCriteria(MasStoreItem.class).add(
						Restrictions.like("Nomenclature", str)).add(
						Restrictions.eq("Department.Id", deptId)).add(
						Restrictions.not(Restrictions.in("Id", objectList)));

				itemList = c.list();
			} else {
				Criteria c = session.createCriteria(MasStoreItem.class).add(
						Restrictions.like("Nomenclature", str)).add(
						Restrictions.eq("Department.Id", deptId));

				itemList = c.list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (Iterator iterator = itemList.iterator(); iterator.hasNext();) {
			MasStoreItem masStoreItem = (MasStoreItem) iterator.next();

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
				au = masStoreItem.getItemConversion().getItemUnitName();
			} catch (Exception e) {
				au = "";
			}

			try {
				item_id = masStoreItem.getId();
			} catch (Exception e) {
				item_id = 0;
			}

			if (!meItems.contains(item_id)) {
				hData = new HashMap<String, Object>();
				hData.put("itemId", item_id);
				hData.put("pvms", pvms);
				hData.put("nomenclature", nomenclature);
				hData.put("strength", strength);
				hData.put("qtymmf", 0);
				hData.put("au", au);

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

	/*******************************  For Save Me Scale By Tirath   *******************************/
	public Map<String, Object> saveItemToMeScale(Box box) {

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List<StoreMeScaleDetails> storeMeScaleDetailsList = new ArrayList<StoreMeScaleDetails>();
		Vector items = box.getVector("itemId");
		Vector items_to_be_added = box.getVector(ITEMS_TO_BE_ADDED);
		int meScaleMasterId = Integer.parseInt(""
				+ box.getInt("meScaleMasterId"));
		// ---------Session Information------------------
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		if (box.get("deptId") != null) {
			deptId = Integer.parseInt("" + box.get("deptId"));
		}
		if (box.get("hospitalId") != null) {
			hospitalId = Integer.parseInt("" + box.get("hospitalId"));
		}
		// ---------------------------------------------------
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date cuurentDate = null;
		SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
		String date4MySQL = "";

		try {
			date4MySQL = formatterOut.format(formatterIn.parse("" + date));
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}

		cuurentDate = java.sql.Date.valueOf(date4MySQL);
		MasStoreItem masStoreItem = null;

		int sr_no = 0;

		try {

			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			if (box.getInt("meScaleMasterId") != 0) {

				storeMeScaleDetailsList = hbt
						.find("from jkt.hms.masters.business.StoreMeScaleDetails as smsd where smsd.MeScale.Id='"
								+ meScaleMasterId
								+ "' and smsd.Department.Id='"
								+ deptId
								+ "' and smsd.Hospital.Id='" + hospitalId + "'");
					int j=0;
				for (int i = 0; i < items_to_be_added.size(); i++) {
					StoreMeScaleDetails meScaleDetails = new StoreMeScaleDetails();
					j=i;
					meScaleDetails.setSerialNo(++j);
					MasDepartment masDepartment = new MasDepartment();
					masDepartment.setId(deptId);
					meScaleDetails.setDepartment(masDepartment);

					MasHospital masHospital = new MasHospital();
					masHospital.setId(hospitalId);
					meScaleDetails.setHospital(masHospital);

					MasStoreItem item = new MasStoreItem();
					item.setId(Integer.parseInt("" + items_to_be_added.get(i)));
					meScaleDetails.setItem(item);

					MasStoreMeScale meScale = new MasStoreMeScale();
					meScale.setId(meScaleMasterId);
					meScaleDetails.setMeScale(meScale);

					meScaleDetails.setLastChgBy(userName);
					meScaleDetails.setLastChgDate(cuurentDate);
					meScaleDetails.setLastChgTime(time);
					hbt.save(meScaleDetails);
					hbt.refresh(meScaleDetails);
				}

			}
			box.put("deptId", deptId);
			box.put("hospitalId", hospitalId);
			box.put("meScaleMasterId", meScaleMasterId);

			map = searchItemsForMEScale(box);
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return map;

	}

	public Map<String, Object> deleteMeScaleItems(Box box) {

		Session session = (Session) getSession();
		List<StoreMmfDepartmentT> storeMmfDepartmentTList = new ArrayList<StoreMmfDepartmentT>();
		StoreMmfDepartmentT storeMmfDepartmentT = new StoreMmfDepartmentT();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			HibernateTemplate hbt = getHibernateTemplate();

			Vector items = box.getVector("id");
			Vector delete = box.getVector(ITEMS_TO_BE_DELETED);

			String obj = null;
			for (int i = 0; i < delete.size(); i++) {
				int itemId = Integer.parseInt(delete.get(i).toString());
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);

				String hql = "delete from jkt.hms.masters.business.StoreMeScaleDetails as a where a.Id like :itemId";
				Query query = session.createQuery(hql).setParameter("itemId",
						itemId);
				int row = query.executeUpdate();
			}
			map.put("total_records", items.size());
			map.put("deleted_records", delete.size());
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		if (Integer.parseInt(map.get("total_records").toString()) == Integer
				.parseInt(map.get("deleted_records").toString())) {
			if (box.getInt("currPage") > 1)
				box.put("currPage", box.getInt("currPage") - 1);
		}
		int meScaleMasterId = 0;
		map = getMeScaleDescription(meScaleMasterId, box);
		return map;

	}

	public Map<String, Object> viewMeScaleJsp() {

		Map<String, Object> map = new HashMap<String, Object>();
		MasStoreMeScale masStoreMeScale = null;
		StoreMeScaleDetails storeMeScaleDetails = null;
		String meScaleDescription = "";
		Session session = (Session) getSession();
		List<MasStoreMeScale> searchMeScaleList = new ArrayList<MasStoreMeScale>();
		/*searchMeScaleList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasStoreMeScale as msms where msms.Status='y'");*/
		/*
		 * By Ujjwal For SQL Injection
		 */
		searchMeScaleList=session.createCriteria(MasStoreMeScale.class)
								  .add(Restrictions.eq("Status","y")).list();
		
		List<StoreMeScaleDetails> viewMeScaleList = new ArrayList<StoreMeScaleDetails>();
		viewMeScaleList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.StoreMeScaleDetails ");
		
		viewMeScaleList=session.createCriteria(StoreMeScaleDetails.class)
		  .list();
		
		//end by Ujjwal
		map.put("searchMeScaleList", searchMeScaleList);
		map.put("viewMeScaleList", viewMeScaleList);
		return map;

	}

	public Map<String, Object> showWorkRegisterReportJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreWorkOrderT> searchMasStoreItemList = new ArrayList<StoreWorkOrderT>();
		session = (Session) getSession();
		String pvmsNo = "";
		pvmsNo = (String) map.get("pvmsNo");

		try {
			searchMasStoreItemList = getHibernateTemplate().find("from jkt.hms.masters.business.StoreWorkOrderT ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("searchMasStoreItemList", searchMasStoreItemList);
		return map;
	}
	
	
	
	public Map<String, Object> getItemListForGrnByAutocompleteForNnExpendableGrn(
			Map<String, Object> dataMap) {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		Box box = (Box) dataMap.get("box");
		String sos = box.getString("sourceOfSupply").trim();

		String pvmsNo = null;
		int deptId = 0;
		int indentId = 0;

		deptId = Integer.parseInt("" + dataMap.get("deptId"));
		if (deptId == 38) {
			deptId = 24;
		}
		indentId = Integer.parseInt("" + dataMap.get("indentId"));
		List objectList = new ArrayList();
		try {
			String str = "%" + dataMap.get("autoHint") + "%";
			if (sos.equalsIgnoreCase("p")) {
				String qry = "Select item_id from store_indent_t where indent_id in(select indent_id  from store_indent_m where indent_type !='d' )";
				objectList = (List) session.createSQLQuery(qry).list();

				Criteria c = session.createCriteria(MasStoreItem.class).add(
						Restrictions.like("Nomenclature", str)).add(
						Restrictions.eq("Department.Id", deptId)).add(
						Restrictions.eq("Status", "y")).add(
						Restrictions.in("Id", objectList));
				c.setFirstResult(0);
				c.setMaxResults(10);
				itemList = c.list();
			}
			if (sos.equalsIgnoreCase("l")) {
				String qry = " SELECT item_id FROM store_po_detail where po_id='"
						+ indentId + "';";
				objectList = (List) session.createSQLQuery(qry).list();

				Criteria c = session.createCriteria(MasStoreItem.class).add(
						Restrictions.like("Nomenclature", str)).add(
						Restrictions.eq("Department.Id", deptId)).add(
						Restrictions.eq("Status", "y")).add(
						Restrictions.in("Id", objectList));
				c.setFirstResult(0);
				c.setMaxResults(10);
				itemList = c.list();
			}
			if (sos.equalsIgnoreCase("a")) {
				String qry = "Select item_id from store_indent_t where indent_id in(select indent_id  from store_indent_m where indent_type ='d' )";
				objectList = (List) session.createSQLQuery(qry).list();

				Criteria c = session.createCriteria(MasStoreItem.class).add(
						Restrictions.like("Nomenclature", str)).add(
						Restrictions.eq("Department.Id", deptId)).add(
						Restrictions.eq("Status", "y"));
				// .add(Restrictions.in("Id", objectList));
				c.setFirstResult(0);
				c.setMaxResults(10);
				itemList = c.list();
			}
			if (sos.equalsIgnoreCase("o") || sos.equalsIgnoreCase("w")
					|| sos.equalsIgnoreCase("i")) {

				String qry = "Select item_id from mas_store_item where Status='y'";
				objectList = (List) session.createSQLQuery(qry).list();

				Criteria c = session.createCriteria(MasStoreItem.class).add(
						Restrictions.like("Nomenclature", str)).add(
						Restrictions.eq("Department.Id", deptId)).add(
						Restrictions.eq("Status", "y")).add(
						Restrictions.in("Id", objectList));
				c.setFirstResult(0);
				c.setMaxResults(10);
				itemList = c.list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("itemList", itemList);
		return map;
	}
	
	public Map<String, Object> getindenList(int indentId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreIndentT> indentTList = new ArrayList<StoreIndentT>();
		List<MasManufacturer> manufactureList = new ArrayList<MasManufacturer>();
		session = (Session) getSession();
		String pvmsNo = "";
		pvmsNo = (String) map.get("pvmsNo");

		try {
			indentTList = session.createCriteria(StoreIndentT.class)
						  .add(Restrictions.eq("Indent.Id", indentId)).list();
			
			manufactureList = session.createCriteria(MasManufacturer.class)
			  .add(Restrictions.eq("Status", "y")).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("indentTList", indentTList);
		map.put("manufactureList", manufactureList);
		return map;
	}

	public Map<String, Object> showInstallationCertificate(Map<String, Object> dataMap)
	{
		Map<String,Object>map=new HashMap<String, Object>();
		List<StoreGrnM>storeGrnMList=new ArrayList<StoreGrnM>();
		session=(Session)getSession();
		int deptId=(Integer)dataMap.get("deptId");
		
		storeGrnMList=session.createCriteria(StoreGrnM.class)
		.add(Restrictions.eq("Department.Id", deptId)).list();
		
		map.put("storeGrnMList", storeGrnMList);
		return map;
	}
	
	
	
	public Map<String, Object> responseNomenclature(Map<String, Object> dataMap)
	{
		Map<String,Object>map=new HashMap<String, Object>();
		List<StoreGrnT>storeGrnTList=new ArrayList<StoreGrnT>();
		session=(Session)getSession();
		int grnMId=(Integer)dataMap.get("grnMId");
		
		storeGrnTList=session.createCriteria(StoreGrnT.class)
		.add(Restrictions.eq("GrnMaster.Id", grnMId)).list();
		
		map.put("storeGrnTList", storeGrnTList);
		return map;
	}
	
	
	public Map<String, Object> updateInstallationDate(Map<String, Object> dataMap)
	{
		Map<String,Object>map=new HashMap<String, Object>();
		StoreGrnM storeGrnM=null;
		session=(Session)getSession();
		boolean flag=false;
		Transaction tx = null;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		try
		{
			tx = session.beginTransaction();
		int grnMId=(Integer)dataMap.get("grnMId");
		Date installationDate=(Date)dataMap.get("installationDate");
		
		storeGrnM = (StoreGrnM) getHibernateTemplate()
		.load(StoreGrnM.class, grnMId);
		
		/*storeGrnM.setInstalationStatus("y");
		storeGrnM.setInstallationDate(installationDate);*/
		hbt.update(storeGrnM);
		flag=true;
		tx.commit();
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			// TODO: handle exception
		}
		map.put("flag", flag);
		return map;
	}
	
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> showInitialDeficiencyIndentJspDepot(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;

		if (dataMap.get("deptId") != null)
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		if (dataMap.get("hospitalId") != null)
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		if (dataMap.get("userName") != null)
			userName = ("" + dataMap.get("userName"));

		List<StoreIndentM> searchIndentList = new ArrayList<StoreIndentM>();
		List<MasStoreSection> sectionList = new ArrayList<MasStoreSection>();
		List<MasStoreAirForceDepot> masStoreAirForceDepotList = new ArrayList<MasStoreAirForceDepot>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List<StoreIndentM> list = new ArrayList<StoreIndentM>();
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		int grnStartNo = 0;
		String no = "";
		session = (Session) getSession();
		List objectList = new ArrayList();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		int year = Integer.parseInt(date.substring(6));
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			String qry = "select mas.item_id,mas.pvms_no,mas.nomenclature,mas.strength,b.stock,c.qty_in_mmf,mas.old_niv_no,mas.department_id,con.item_unit_name from mas_store_item mas inner join mas_store_item_conversion con on mas.item_conversion_id= con.item_conversion_id left outer join (select ba.item_id,sum(ba.closing_stock) stock from store_item_batch_stock ba where department_id=1 group by ba.item_id)b on mas.item_id=b.item_id left outer join (select it.qty_in_mmf, it.item_id from  store_indent_m im inner join store_indent_t it on im.indent_id=it.indent_id where im.mmf_for_the_year='"
					+ year + "' )c on mas.item_id=c.item_id;";
			objectList = (List) session.createSQLQuery(qry).list();
			masStoreAirForceDepotList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasStoreAirForceDepot as md where md.Status = 'y'");
			searchIndentList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreIndentM as md where md.Status = 'o'and  md.Department.Id='"
									+ deptId + "' and md.IndentType='d' ");
			sectionList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasStoreSection ");
			storeFyDocumentNoList = (List) getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreFyDocumentNo as sfdn where sfdn.Department.Id='"
									+ deptId + "'");
			for (StoreFyDocumentNo storeFyDocumentNo : storeFyDocumentNoList) {
				if (storeFyDocumentNo.getIndentToDepotNo() != null) {
					no = ("" + storeFyDocumentNo.getIndentToDepotNo());
					no = getMaxNo(no);
				} else {
					no = getMaxNo("");
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("masStoreAirForceDepotList", masStoreAirForceDepotList);
		map.put("searchIndentList", searchIndentList);
		map.put("sectionList", sectionList);
		map.put("maxIndentNo", no);
		map.put("objectList", objectList);
		return map;

	}
	
	
	public Map<String, Object> fillItemsForIndentToDepot(
			Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		session = (Session) getSession();
		String pvmsNo = null;
		int deptId = 0;
		int item_id = 0;
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		int year = Integer.parseInt(date.substring(6));
		List objectList = new ArrayList();
		pvmsNo = "" + dataMap.get("pvmsNo");
		try {
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
			String qry = "select mas.item_id,mas.pvms_no,mas.nomenclature,mas.strength,b.stock,sm.qty,mas.old_niv_no, mas.department_id,con.item_unit_name,sec.section_code from mas_store_item mas inner join mas_store_item_conversion con on mas.item_conversion_id=con.item_conversion_id inner join mas_store_section sec on  mas.section_id=sec.section_id left outer join (select ba.item_id,sum(ba.closing_stock) stock from store_item_batch_stock ba where department_id='"
					+ deptId
					+ "' group by ba.item_id)b on mas.item_id=b.item_id left outer join store_me_scale_details sm on sm.item_id=mas.item_id where mas.pvms_no='"
					+ pvmsNo + "';";
			objectList = (List) session.createSQLQuery(qry).list();
			pvmsNo = "" + dataMap.get("pvmsNo");
			Criteria c = session.createCriteria(MasStoreItem.class).add(
					Restrictions.like("PvmsNo", pvmsNo)).add(
					Restrictions.eq("Status", "y"));
			itemList = c.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("objectList", objectList);
		return map;

	}

	public Map<String, Object> getSupplierListForNeGrn(Map<String, Object> dataMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<StorePoHeader> poNoList = new ArrayList<StorePoHeader>();
		List<StoreIndentM> indentMList = new ArrayList<StoreIndentM>();
		List<MasStoreAirForceDepot> unitList = new ArrayList<MasStoreAirForceDepot>();
		session = (Session) getSession();
		int supplierId=(Integer)dataMap.get("supplierId");
		try
		{
		poNoList=session.createCriteria(StorePoHeader.class)
		.add(Restrictions.eq("Supplier.Id",supplierId)).
		add(Restrictions.eq("TypeOfItem","N")).
		addOrder(Order.desc("Id")).list();
			
		
			map.put("first_combo", poNoList);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return map;
	}
	
	
	public Map<String, Object> getPoList(int poId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StorePoDetail> poDetailsList = new ArrayList<StorePoDetail>();
		List<MasManufacturer> manufactureList = new ArrayList<MasManufacturer>();
		session = (Session) getSession();
		String pvmsNo = "";
		pvmsNo = (String) map.get("pvmsNo");

		try {
			poDetailsList = session.createCriteria(StorePoDetail.class)
						  .add(Restrictions.eq("Po.Id", poId)).list();
			
			manufactureList = session.createCriteria(MasManufacturer.class)
			  .add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ManufacturerName")).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("poDetailsList", poDetailsList);
		map.put("manufactureList", manufactureList);
		return map;
	}
	
	public int countNo(String workOrderNo)
	{
		int count=0;
		List countList=new ArrayList();
		Session session = (Session) getSession();
		String query="select count(swt.item_id) from store_work_order_t swt left outer join " +
				"store_work_order_m swm on swt.work_order_m_id=swm.id  " +
				"where swm.work_order_no ='"+workOrderNo+"'";
		countList=session.createSQLQuery(query).list();
		if(countList.size()>0)
		{
			count=Integer.parseInt(countList.get(0).toString());
		}
		
		return count; 
	}
	
	public Map<String,Object>showRepairStationJsp(Map dataMap)
	{
		Map<String,Object>map=new HashMap<String, Object>();
		String userName="";
		int deptId = 0;
		int hospitalId=0;			 	
		List<MasRepairStation>repairStationList=new ArrayList<MasRepairStation>();
		Session session = (Session) getSession();	
		hospitalId=(Integer)dataMap.get("hospitalId");
		 userName=  (String)dataMap.get("userName"); 
		 if(dataMap.get("deptId")!= null)
		 {
		 deptId = (Integer)dataMap.get("deptId");
		 }
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList= new ArrayList<MasDepartment>();
		List<StoreLoanOutM> storeLoanOutMList= new ArrayList<StoreLoanOutM>();
		try{
			employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status","y")).add(Restrictions.eq("Hospital.Id", hospitalId)).addOrder(Order.asc("FirstName")).list();
		/*employeeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasEmployee as me where me.Status='y' and me.Hospital.Id='" + hospitalId + "' order by me.FirstName asc");*/
		//employeeList=session.createCriteria(MasEmployee.class)
		repairStationList=session.createCriteria(MasRepairStation.class)
		//.add(Restrictions.eq("Status", "y"))
		.add(Restrictions.eq("Hospital.Id", hospitalId)).list();
		
		departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status","y")).list();
		
		/*departmentList = getHibernateTemplate().find(
		"from jkt.hms.masters.business.MasDepartment as me where me.Status='y'");*/
		
		storeLoanOutMList = session.createCriteria(StoreLoanOutM.class).add(Restrictions.eq("Department.Id", deptId)).add(Restrictions.eq("Hospital.Id", hospitalId)).addOrder(Order.desc("Id")).list();
		
		/*storeLoanOutMList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.StoreLoanOutM slem where slem.Department.Id='"
				+ deptId
				+ "' and slem.Hospital.Id='"
				+hospitalId
				+"' order by slem.Id desc ");*/
		
		}
		catch(Exception e)
		{e.printStackTrace();}
		map.put("repairStationList",repairStationList);
		map.put("employeeList",employeeList);
		map.put("departmentList", departmentList);
		map.put("storeLoanOutMList", storeLoanOutMList);
		return map;
	}
	public Map<String, Object> showUpdateWorkOrder(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		int deptId = 0;
		int hospitalId = 0;
		if (dataMap.get("deptId") != null)
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		if (dataMap.get("hospitalId") != null)
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		List<MasEmployee> issueByList = new ArrayList<MasEmployee>();
		List<MasRepairStation>repairStationList=new ArrayList<MasRepairStation>();
		List<StoreWorkOrderM> workOrderList = session.createCriteria(
				StoreWorkOrderM.class).add(Restrictions.eq("Status", "o")).list();
		issueByList=session.createCriteria(MasEmployee.class)
			.add(Restrictions.eq("Status", "y"))
			.add(Restrictions.eq("Hospital.Id", hospitalId)).list();
		storeFyDocumentNoList =session.createCriteria(StoreFyDocumentNo.class)
			.add(Restrictions.eq("Hospital.Id", hospitalId))
			.add(Restrictions.eq("Department.Id", deptId)).list();
		map.put("issueByList",issueByList);
		map.put("repairStationList",repairStationList);
		map.put("workOrderList",workOrderList);
		map.put("storeFyDocumentNoList",storeFyDocumentNoList);
		return map;
	}

	@Override
	public List<StorePoHeader> getPoNumberList(int deptId, int hospitalId) {
		Session session = (Session) getSession();
		List<StorePoHeader> poNumberList = session.createCriteria(StorePoHeader.class).add(Restrictions.eq("TypeOfItem", "N")).add(Restrictions.eq("Department.Id", deptId)).add(Restrictions.eq("Hospital.Id", hospitalId)).add(Restrictions.isNull("TenderM")).addOrder(Order.desc("Id"))
		.list();
		return poNumberList;
	}


	@Override
	public Map<String, Object> showNonPurchaseOrderJsp(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> storeList = new ArrayList<MasDepartment>();
		List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
		// List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List<MasDiscount> discountList = new ArrayList<MasDiscount>();
		List<MasManufacturer> manufacturerList = new ArrayList<MasManufacturer>();
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

		storeList = session.createCriteria(MasDepartment.class)
		.add(Restrictions.eq("Hospital.Id",hospitalId))
		.add(Restrictions.eq("Status", "y")).list();

		supplierList = session.createCriteria(MasStoreSupplier.class)
		.add(Restrictions.eq("Hospital.Id",hospitalId))
		.add(Restrictions.eq("Status", "y")).addOrder(
				Order.asc("SupplierName")).list();

		discountList = session.createCriteria(MasDiscount.class).add(
				Restrictions.eq("Status", "y")).list();

		masItemCategory=session.createCriteria(MasItemCategory.class).add(
				Restrictions.eq("Status", "y")).list();

		manufacturerList = session.createCriteria(MasManufacturer.class)
		//.add(Restrictions.eq("Hospital.Id",hospitalId))
		.add(Restrictions.eq("Status", "y")).addOrder(
				Order.asc("ManufacturerName")).list();
		storeFyDocumentNoList = hbt
		.find("from jkt.hms.masters.business.StoreFyDocumentNo as inp where inp.Hospital.Id="+hospitalId+" and  inp.Department.Id = "
				+ deptId);
		if (storeFyDocumentNoList != null && storeFyDocumentNoList.size() > 0) {
			StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) storeFyDocumentNoList
					.get(0);
			// startNo=(""+storeFyDocumentNo.getPoStartNo());
			no = ("" + storeFyDocumentNo.getPoNo());
		}
		map.put("storeList", storeList);
		map.put("supplierList", supplierList);
		map.put("discountList", discountList);
		map.put("manufacturerList", manufacturerList);
		map.put("masItemCategory",masItemCategory);
		try {
			max = getMaxNo(no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("max", max);
		return map;
	}
	
	@SuppressWarnings("unchecked")
	public int getPurchaseOrderId(String poNumber,int hospitalId) {
		int poId = 0;
		List<StorePoHeader> list = new ArrayList<StorePoHeader>();
		Session session = (Session) getSession();

		list = session.createCriteria(StorePoHeader.class).add(
				Restrictions.eq("Status", "o")).add(
				Restrictions.eq("PoNumber", poNumber)).add(Restrictions.eq("Hospital.Id",hospitalId))
				.add(Restrictions.eq("TypeOfItem", "N")).list();
		for (StorePoHeader storePoHeader : list) {
			poId = Integer.parseInt("" + storePoHeader.getId());
		}
		return poId;
	}

	@SuppressWarnings( { "unused", "unchecked" })
	public List<StorePoHeader> getPoHeader(int poId) {
		Session session = (Session) getSession();
		List<StorePoHeader> poHeaderList = session.createCriteria(
				StorePoHeader.class).add(Restrictions.eq("Id", poId)).add(Restrictions.eq("TypeOfItem", "N")).list();
		return poHeaderList;
	}
	@SuppressWarnings("unchecked")
	public String getnextPurchaseOrder(String poNumber, int departmentId) {
		String po_number = "";
		int poId = 0;
		List<StorePoHeader> list = new ArrayList<StorePoHeader>();
		Session session = (Session) getSession();
		list = session.createCriteria(StorePoHeader.class).add(
				Restrictions.eq("Status", "o")).add(
				Restrictions.eq("PoNumber", poNumber)).add(Restrictions.eq("TypeOfItem", "N")).list();
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
	public Map<String, Object> submitNonPurchaseOrder(Map<String, Object> infoMap) {
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
				List<StoreFyDocumentNo> fyList = session.createCriteria(StoreFyDocumentNo.class)
					.add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.eq("Department.Id", departmentId)).list();
				if (fyList != null && fyList.size() > 0) {
					StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) fyList
							.get(0);
					no = ("" + storeFyDocumentNo.getPoNo());
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

	@Override
	public Map<String, Object> fillItemsForNonLpo(Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		session = (Session) getSession();
		String pvmsNo = null;
		int item_id = 0;
		int hospitalId=0;
		try {
			pvmsNo = "" + dataMap.get("pvmsNo");

			hospitalId=(Integer)dataMap.get("hospitalId");
				Criteria c3 = session.createCriteria(MasStoreItem.class)
							.add(Restrictions.like("PvmsNo", pvmsNo))
							.add(Restrictions.eq("Hospital.Id", hospitalId))
							.add(Restrictions.eq("TypeOfItem", "NE"));

				itemList = c3.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("itemList", itemList);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> getItemListNonSupplyOrder(Map<String, Object> dataMap) {
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
			String qry1 = "SELECT t.item_id FROM store_po_detail t,store_po_header m where t.po_detail_id='"
					+ poId + "' and m.po_id=t.po_detail_id ";
			objectList = (List) session.createSQLQuery(qry1).list();

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
					itemList=getHibernateTemplate().find("select item from jkt.hms.masters.business.MasStoreItem as item where upper(item.Nomenclature) like '"+str+"' and TypeOfItem='NE'  and item.ItemType.Id='2' and item.Hospital.Id='"+hospitalId+"'  and item.Id not in("+sql+") and rownum < 15");
					itemList1=getHibernateTemplate().find("select item from jkt.hms.masters.business.MasStoreItem as item where upper(item.Nomenclature) like '"+str+"' and TypeOfItem='NE' and item.ItemType.Id='1'  and item.Id not in("+sql+") and rownum < 15");
					itemList.addAll(itemList1);

				}else{
					itemList=getHibernateTemplate().find("select item from jkt.hms.masters.business.MasStoreItem as item where upper(item.Nomenclature) like '"+str+"' and TypeOfItem='NE' and item.ItemType.Id='2' and item.Hospital.Id='"+hospitalId+"'");
					itemList1=getHibernateTemplate().find("select item from jkt.hms.masters.business.MasStoreItem as item where upper(item.Nomenclature) like '"+str+"' and TypeOfItem='NE' and item.ItemType.Id='1'");
					itemList.addAll(itemList1);
				}
			} else {
				Criteria c = session.createCriteria(MasStoreItem.class).add(
						Restrictions.like("Nomenclature", str).ignoreCase()).add(
						Restrictions.eq("Department.Id", deptId))
						.add(Restrictions.eq("Status", "y"))
						.add(Restrictions.eq("TypeOfItem", "NE"));;
				c.setFirstResult(0);
				c.setMaxResults(10);
				itemList = c.list();

				itemList=getHibernateTemplate().find("select item from jkt.hms.masters.business.MasStoreItem as item where upper(item.Nomenclature) like '"+str+"' and TypeOfItem='NE' and item.Status='y'  and item.ItemType.Id='2' and item.Hospital.Id='"+hospitalId+"'");
				itemList1=getHibernateTemplate().find("select item from jkt.hms.masters.business.MasStoreItem as item where upper(item.Nomenclature) like '"+str+"' and TypeOfItem='NE' and item.Status='y' and item.ItemType.Id='1'");
				itemList.addAll(itemList1);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("itemList", itemList);
		return map;
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
			poDetailList = session.createCriteria(StorePoDetail.class).createAlias("Po", "po")
							.add(Restrictions.eq("po.TypeOfItem", "N")).list();
			supplierList = session.createCriteria(MasStoreSupplier.class).add(Restrictions.eq("Hospital.Id",hospitalId)).add(Restrictions.eq("Status", "y")).list();
			poHeaderList = session.createCriteria(StorePoHeader.class).add(Restrictions.eq("Hospital.Id",hospitalId)).add(Restrictions.eq("Status", "y"))
							.add(Restrictions.eq("TypeOfItem", "N")).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("poDetailList", poDetailList);
		map.put("poHeaderList", poHeaderList);
		map.put("supplierList", supplierList);

		return map;
	}
	@SuppressWarnings( { "unchecked", "unused" })
	public Map<String, Object> searchPO(Map<String, Object> searchMap){
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
		c = session.createCriteria(StorePoHeader.class).add(Restrictions.eq("TypeOfItem", "N"));
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
				SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
				date4MySQL1 = formatterOut.format(formatterIn.parse(fromDate));
				date4MySQL2 = formatterOut.format(formatterIn.parse(toDate));
				Date startDate = java.sql.Date.valueOf(date4MySQL1);
				Date endDate = java.sql.Date.valueOf(date4MySQL2);

				c = c.add(Restrictions.between("PoDate", startDate, endDate));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		c = c.add(Restrictions.isNull("TenderM"));
		searchPoHeaderList = c.addOrder(Order.desc("Id")).list();

		if ((Integer) searchMap.get("departmentId") != 0) {
			departmentId = (Integer) searchMap.get("departmentId");
			searchPoHeaderList = session.createCriteria(StorePoHeader.class).add(Restrictions.eq("TypeOfItem", "N"))
					.createAlias("Department","department").add(Restrictions.eq("department.Id", departmentId)).createAlias("Hospital","hospital").add(Restrictions.eq("hospital.Id", hospitalId)).list();
		}

		//map.put("searchPoDetailList", searchPoDetailList);
		map.put("searchSupplierList", searchSupplierList);
		map.put("searchPoHeaderList", searchPoHeaderList);

		return map;
	}

	@Override
	public Map<String, Object> poModifyMap(int poId, int pageNo,
			String buttonFlag) {
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
					.createAlias("Item", "item").add(Restrictions.like("item.Id", storePoDetail
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

		masItemCategory=session.createCriteria(MasItemCategory.class).add(Restrictions.eq("Status", "y")).list();

		map.put("poDetailList", poDetailList);
		map.put("poHeaderList", poHeaderList);
		map.put("totalPages", totalPages);
		map.put("currAmount", currAmount);
		map.put("grnHeaderList", grnHeaderList.size());
		map.put("crvNo", crvNo);
		map.put("masItemCategory", masItemCategory);
		return map;
	}

	@Override
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
						StorePoDetail storePoDetail = (StorePoDetail) poDetailListAdd.get(i);
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
	@Override
	public boolean updateWorkOrder(Map<String, Object> infoMap) {
	//	StoreWorkOrderM storeWorkOrderM = (StoreWorkOrderM) infoMap.get("storeWorkOrderM");
	List<StoreWorkOrderT> storeWorkOrderTlist = (ArrayList<StoreWorkOrderT>) infoMap
			.get("storeWorkOrderTlist");
	List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
	boolean successfullyAdded = false;
	@SuppressWarnings("unused")
	int pageNo = 0;
	String workOrderNo = "";
	int storeFyId = 0;
	int deptId = 0;
	int hospitalId = 0;
	int workOrderId=0;
	String userName = "";
	if (infoMap.get("deptId") != null)
		deptId = Integer.parseInt("" + infoMap.get("deptId"));
	if (infoMap.get("hospitalId") != null)
		hospitalId = Integer.parseInt("" + infoMap.get("hospitalId"));
	if (infoMap.get("userName") != null)
		userName = ("" + infoMap.get("userName"));

session = (Session) getSession();
Transaction tx = null;
try {
	tx = session.beginTransaction();
	HibernateTemplate hbt = getHibernateTemplate();
	workOrderId=Integer.parseInt("" + infoMap.get("workOrderId"));
	
	StoreWorkOrderM storeWorkOrderM = (StoreWorkOrderM) getHibernateTemplate()
	.load(StoreWorkOrderM.class, workOrderId);
	
	hbt.update(storeWorkOrderM);
	hbt.refresh(storeWorkOrderM);
	
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	workOrderNo = (String) infoMap.get("workOrderNo");
	/*Criteria c = session.createCriteria(StoreFyDocumentNo.class).add(
			Restrictions.eq("Department.Id", deptId));*/
	//-Change By dipali as discussed by bambam sir
	Criteria c = session.createCriteria(StoreFyDocumentNo.class).add(
			Restrictions.eq("Hospital.Id", hospitalId)).add(Restrictions.eq("Department.Id", deptId));
	storeFyDocumentNoList = c.list();
	if (storeFyDocumentNoList.size() > 0) {
	for (StoreFyDocumentNo documentNo : storeFyDocumentNoList) {
		storeFyId = documentNo.getId();
	}
	StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) getHibernateTemplate()
			.load(StoreFyDocumentNo.class, storeFyId);
	storeFyDocumentNo.setWorkOrderNo(workOrderNo);
	//---added by dipali
	
	hbt.update(storeFyDocumentNo);
	}if (storeFyDocumentNoList.size() == 0) {
		StoreFyDocumentNo storeFyDocumentNo = new StoreFyDocumentNo();
		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(deptId);
		storeFyDocumentNo.setDepartment(masDepartment);
		MasHospital hospital=new MasHospital();
		hospital.setId(hospitalId);
		storeFyDocumentNo.setHospital(hospital);
		storeFyDocumentNo.setWorkOrderNo(workOrderNo);
		hbt.save(storeFyDocumentNo);
	}
	//-------------
	List<Integer> workDtIdList = new ArrayList<Integer>();
	if(infoMap.get("workDtIdList") !=null){
	workDtIdList= (List) infoMap.get("workDtIdList");
	}
	List<Integer> itemIdList = new ArrayList<Integer>();
	itemIdList= (List) infoMap.get("itemIdList");
	List<String> srList = new ArrayList<String>();
	srList= (List) infoMap.get("srList");
	List<String>  serialNoList = new ArrayList<String>();
	serialNoList= (List) infoMap.get("serialNoList");
	List<Integer> quantityList = new ArrayList<Integer>();
	quantityList= (List) infoMap.get("quantityList");
	List<String> natureOfWorkList = new ArrayList<String>();
	natureOfWorkList= (List) infoMap.get("natureOfWorkList");
	List<String> parEqptList = new ArrayList<String>();
	parEqptList= (List) infoMap.get("parEqptList");
	List<String> remarksList = new ArrayList<String>();
	remarksList= (List) infoMap.get("remarksList");
	
	//if (itemIdList.size() > 0) {
		for (int i = 0; i < itemIdList.size(); i++) {
			if(Integer.parseInt(workDtIdList.get(i).toString()) != 0){
				int workDtId = Integer.parseInt(workDtIdList.get(i).toString()) ;
			StoreWorkOrderT storeWorkOrderTObj = (StoreWorkOrderT) getHibernateTemplate()
			.load(StoreWorkOrderT.class, workDtId);
			/*if(itemIdList.get(i) != null){
				MasStoreItem masStoreItem = new MasStoreItem();
				masStoreItem.setId(itemIdList.get(i));
				storeWorkOrderTObj.setItem(masStoreItem);
			}*/
		//	storeWorkOrderTObj.setSrNo(srList.get(i));
			//storeWorkOrderTObj.setWorkOrderM(storeWorkOrderM);
		//	storeWorkOrderTObj.setSerialNo(serialNoList.get(i));
			storeWorkOrderTObj.setQuantity(quantityList.get(i));
			storeWorkOrderTObj.setNatureOfWork(natureOfWorkList.get(i));
			storeWorkOrderTObj.setParticularEqupRv(parEqptList.get(i));
			storeWorkOrderTObj.setRemarks(remarksList.get(i));
			hbt.update(storeWorkOrderTObj);

		}
		
	else{
				StoreWorkOrderT storeWorkOrderTObj = new StoreWorkOrderT();
				if(itemIdList.get(i) != null){
					MasStoreItem masStoreItem = new MasStoreItem();
					masStoreItem.setId(itemIdList.get(i));
					storeWorkOrderTObj.setItem(masStoreItem);
				}
				storeWorkOrderTObj.setSrNo(srList.get(i));
				storeWorkOrderTObj.setWorkOrderM(storeWorkOrderM);
				storeWorkOrderTObj.setSerialNo(serialNoList.get(i));
				storeWorkOrderTObj.setQuantity(quantityList.get(i));
				storeWorkOrderTObj.setNatureOfWork(natureOfWorkList.get(i));
				storeWorkOrderTObj.setParticularEqupRv(parEqptList.get(i));
				storeWorkOrderTObj.setRemarks(remarksList.get(i));
				hbt.save(storeWorkOrderTObj);

			}
			
	}
	//}
/*	if (storeWorkOrderTlist.size() > 0) {
		if ((infoMap.get("headerStored") + "").equals("yes")) {
			int id = Integer.parseInt("" + infoMap.get("workOrderId"));
			storeWorkOrderM2.setId(id);
		}
		for (int i = 0; i < storeWorkOrderTlist.size(); i++) {
			StoreWorkOrderT storeWorkOrderTObj = new StoreWorkOrderT();
			storeWorkOrderTObj = (StoreWorkOrderT) storeWorkOrderTlist
					.get(i);
			if ((infoMap.get("headerStored") + "").equals("yes")) {
				storeWorkOrderTObj.setWorkOrderM(storeWorkOrderM2);
			} else {
				storeWorkOrderTObj.setWorkOrderM(storeWorkOrderM);
			}
			hbt.save(storeWorkOrderTObj);
		}

	}*/
	successfullyAdded = true;
	tx.commit();

} catch (RuntimeException e) {
	if (tx != null)
		tx.rollback();
	// throw e; // or display error message
	e.printStackTrace();
} finally {
	session.close();
}

return successfullyAdded;
}

	@Override
	public StoreWorkOrderM loadWorkOrderObj(int workOrderId) {
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		StoreWorkOrderM storeWorkOrderM = new StoreWorkOrderM();
		try {

			storeWorkOrderM = (StoreWorkOrderM) hbt.load(
					StoreWorkOrderM.class, workOrderId);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return storeWorkOrderM;
	}

	@Override
	public String getHospitalAddress(int hospitalId) {
		Session session = (Session) getSession();
		String hospitalAddress= "";
		List<MasHospital> list = session.createCriteria(MasHospital.class).add(
				Restrictions.eq("Status", "y")).add(Restrictions.eq("Id", hospitalId)).list();
		if (list != null && list.size() > 0) {
			MasHospital obj = (MasHospital) list.get(0);
			hospitalAddress = obj.getAddress();
		}
		return hospitalAddress;
	}

	@Override
	public String getHospitalName(int hospitalId) {
		Session session = (Session) getSession();
		String hospitalName = "";
		List<MasHospital> list = session.createCriteria(MasHospital.class).add(
				Restrictions.eq("Status", "y")).add(Restrictions.eq("Id", hospitalId)).list();
		if (list != null && list.size() > 0) {
			MasHospital obj = (MasHospital) list.get(0);
			hospitalName = obj.getHospitalName();
		}
		return hospitalName;
	}
	@Override
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
	//------------End By dipali
	//---------------Method Added by javed---
	@Override
	public Map<String, Object> getListForNeGrn1(String choice, int hospitalId) {

			Map<String, Object> map = new HashMap<String, Object>();
			List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
			List<StoreIndentM> indentMList = new ArrayList<StoreIndentM>();
			List<MasStoreAirForceDepot> unitList = new ArrayList<MasStoreAirForceDepot>();
			session = (Session) getSession();
			
			if (choice.equalsIgnoreCase("s") || choice.equalsIgnoreCase("d")) {
				
				
				indentMList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.StoreIndentM as si where si.Status= 'o'");
				map.put("indentMList", indentMList);
			}
			
			if (choice.equalsIgnoreCase("b") || choice.equalsIgnoreCase("c")) {
				supplierList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasStoreSupplier as mi where mi.Status= 'y' and mi.Hospital.Id = "+hospitalId);
				map.put("first_combo", supplierList);
			} 
			/*else if (choice.equalsIgnoreCase("D")) {
				unitList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasStoreAirForceDepot as mi where mi.Status= 'y'and mi.AirForceDepotType='d'");
				map.put("first_combo", unitList);

			} else if (choice.equalsIgnoreCase("s")) {
				supplierList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasStoreSupplier as mi where mi.Status= 'y'");
				map.put("first_combo", supplierList);}*/
			  if (choice.equalsIgnoreCase("a") || choice.equalsIgnoreCase("d")) {
				unitList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasStoreAirForceDepot as mi where mi.Status= 'y'");
				map.put("first_combo", unitList);
			} else {
				supplierList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasStoreSupplier as mi where mi.Status= 'y'and mi.Hospital.Id = "+hospitalId);
				map.put("first_combo", supplierList);
			}
			map.put("choice", choice);
			return map;
		
	}

	public Map<String, Object> getManuList() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StorePoDetail> poDetailsList = new ArrayList<StorePoDetail>();
		List<MasManufacturer> manufactureList = new ArrayList<MasManufacturer>();
		session = (Session) getSession();
		String pvmsNo = "";	

		try {
			
			
			manufactureList = session.createCriteria(MasManufacturer.class)
			  .add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ManufacturerName")).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		map.put("manufactureList", manufactureList);
		return map;
	}
	
	// add javed khan
	public Map<String, Object> showIndentToDepoNe(Map<String,Object>dataMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;

		if (dataMap.get("deptId") != null)
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		if (dataMap.get("hospitalId") != null)
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		if (dataMap.get("userName") != null)
			userName = ("" + dataMap.get("userName"));

		List<StoreIndentM> searchIndentList = new ArrayList<StoreIndentM>();
		List<MasStoreSection> sectionList = new ArrayList<MasStoreSection>();
		List<MasStoreAirForceDepot> masStoreAirForceDepotList = new ArrayList<MasStoreAirForceDepot>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List<StoreIndentM> list = new ArrayList<StoreIndentM>();
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		int grnStartNo = 0;
		String no = "";
		session = (Session) getSession();
		List objectList = new ArrayList();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		int year = Integer.parseInt(date.substring(6));
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			String qry = "select mas.item_id,mas.pvms_no,mas.nomenclature,mas.strength,b.stock,c.qty_in_mmf," +
					"mas.old_niv_no,mas.department_id," +
					" con.item_unit_name from mas_store_item mas " +
					" inner join mas_store_item_conversion con on mas.item_conversion_id= con.item_conversion_id " +
					" left outer join " +
					"(select ba.item_id,sum(ba.closing_stock) stock from " +
					" store_item_batch_stock ba where department_id=1 group by ba.item_id)b" +
					" on mas.item_id=b.item_id left outer join " +
					" (select it.qty_in_mmf, it.item_id from  store_indent_m im inner join store_indent_t it " +
					"on im.indent_id=it.indent_id where im.mmf_for_the_year=" + year + " )c on mas.item_id=c.item_id";
			objectList = (List) session.createSQLQuery(qry).list();
			masStoreAirForceDepotList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasStoreAirForceDepot as md where md.Status = 'y'");
			searchIndentList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreIndentM as md where md.Status = 'o'and  md.Department.Id='"
									+ deptId + "' and md.IndentType='d' order by md.IndentNo desc ");
			sectionList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasStoreSection ");
			storeFyDocumentNoList = (List) getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreFyDocumentNo as sfdn where sfdn.Department.Id='"
									+ deptId + "' and sfdn.Hospital.Id='"+hospitalId+"'");
			for (StoreFyDocumentNo storeFyDocumentNo : storeFyDocumentNoList) {
				if (storeFyDocumentNo.getIndentToDepotNo() != null) {
					no = ("" + storeFyDocumentNo.getIndentToDepotNo());
					no = getMaxNo(no);
				} else {
					no = getMaxNo("");
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("masStoreAirForceDepotList", masStoreAirForceDepotList);
		map.put("searchIndentList", searchIndentList);
		map.put("sectionList", sectionList);
		map.put("maxIndentNo", no);
		map.put("objectList", objectList);
		return map;

	
	}
	
	// add javed khan
	
	public Map<String, Object> getItemListForIndentToDepot(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		session = (Session) getSession();
		String pvmsNo = null;
		int deptId = 0;
		int indentId = 0;
		int sec =0 ;
		deptId = Integer.parseInt("" + dataMap.get("deptId"));
		indentId = Integer.parseInt("" + dataMap.get("indentId"));
		sec=Integer.parseInt(""+dataMap.get("sec"));
		List objectList = new ArrayList();
		try {
			String str = dataMap.get("autoHint") + "%";
			String qry1 = "SELECT t.item_id FROM store_indent_t t,store_indent_m m where t.indent_id='"
					+ indentId + "' and m.indent_id=t.indent_id";
			objectList = (List) session.createSQLQuery(qry1).list();
			if(sec==0){
			if (objectList.size() != 0) {
				Criteria c = session.createCriteria(MasStoreItem.class).add(
						Restrictions.like("Nomenclature", str).ignoreCase()).add(
						//Restrictions.eq("Department.Id", deptId)).add(
							Restrictions.eq("TypeOfItem", "NE")).add(
						Restrictions.not(Restrictions.in("Id", objectList)));
				c.setFirstResult(0);
				c.setMaxResults(10);
				itemList = c.list();
			} else {
				Criteria c = session.createCriteria(MasStoreItem.class).add(
						Restrictions.like("Nomenclature", str).ignoreCase())//.add(
						//Restrictions.eq("Department.Id", deptId));
						.add(Restrictions.eq("TypeOfItem", "NE"));
						
				c.setFirstResult(0);
				c.setMaxResults(10);
				itemList = c.list();
			}
		}else{
			Criteria c = session.createCriteria(MasStoreItem.class).add(
					Restrictions.like("Nomenclature", str).ignoreCase())
					.add(Restrictions.eq("Section.Id", sec))
					.add(Restrictions.eq("TypeOfItem", "NE"));
					
			c.setFirstResult(0);
			c.setMaxResults(10);
			itemList = c.list();
			
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("itemList", itemList);
		return map;

	}
// addd javed khan
	
	public Map<String, Object> addNextOrSubmitIndentToDepot(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;

		if (dataMap.get("deptId") != null)
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		if (dataMap.get("hospitalId") != null)
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		if (dataMap.get("userName") != null)
			userName = ("" + dataMap.get("userName"));
		session = (Session) getSession();
		String successfullyAdded = "no";
		@SuppressWarnings("unused")
		int pageNo = 0;
		String maxIndentNo = "";
		StoreIndentM storeIndentM = new StoreIndentM();
		List<StoreIndentM> storeIndentMlist = new ArrayList<StoreIndentM>();
		List<StoreIndentT> storeIndentTlist = new ArrayList<StoreIndentT>();
		List<MasStoreAirForceDepot> masStoreAirForceDepotList = new ArrayList<MasStoreAirForceDepot>();
		// For Show Jsp
		List<StoreIndentM> searchIndentList = new ArrayList<StoreIndentM>();
		List<MasStoreSection> sectionList = new ArrayList<MasStoreSection>();
		List<MasStoreSupplier> masStoreSupplierList = new ArrayList<MasStoreSupplier>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List<StoreIndentM> list = new ArrayList<StoreIndentM>();
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();

		session = (Session) getSession();
		List objectList = new ArrayList();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		int year = Integer.parseInt(date.substring(6));

		int indentId = 0;
		int storeFyId = 0;
		String indentNo = "";
		if (dataMap.get("storeIndentM") != null) {
			storeIndentM = (StoreIndentM) dataMap.get("storeIndentM");
		}
		if (dataMap.get("indentNo") != null) {
			indentNo = "" + dataMap.get("indentNo");
		
		}

		if (dataMap.get("storeIndentTlist") != null) {
			storeIndentTlist = (List<StoreIndentT>) dataMap
					.get("storeIndentTlist");
		}
		if (dataMap.get("pageNo") != null) {
			pageNo = Integer.parseInt("" + dataMap.get("pageNo"));
		}
		if (dataMap.get("indentId") != null) {
			indentId = Integer.parseInt("" + dataMap.get("indentId"));
		}
		// Session sess = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			if (pageNo == 1) {

				hbt.save(storeIndentM);
				indentId = storeIndentM.getId();
				/*
				 * storeIndentMlist=getHibernateTemplate().find("from
				 * jkt.hms.masters.business.StoreIndentM as md where md.IndentNo =
				 * '"+indentNo+"'"); for(StoreIndentM
				 * storeIndentM2:storeIndentMlist){
				 * indentId=storeIndentM2.getId(); 
				 * in DS "+indentId); }
				 */
				Criteria c = session.createCriteria(StoreFyDocumentNo.class)
						.add(Restrictions.eq("Department.Id", deptId)).add(
								Restrictions.eq("Hospital.Id", hospitalId)); // addd javed khan
				storeFyDocumentNoList = c.list();
				
				for (StoreFyDocumentNo documentNo : storeFyDocumentNoList) {
					storeFyId = documentNo.getId();
					
				}
				StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) getHibernateTemplate()
						.load(StoreFyDocumentNo.class, storeFyId);
				storeFyDocumentNo.setIndentToDepotNo(indentNo);
				hbt.update(storeFyDocumentNo);
			}


			String buttonName="";
			if(dataMap.get("buttonName")!=null){
							buttonName=(String)dataMap.get("buttonName");
						}

			if(buttonName.equals("close"))
						{
							StoreIndentM storeIndentM1 = (StoreIndentM) getHibernateTemplate()
							.load(StoreIndentM.class, indentId);
							storeIndentM1.setStatus("o");
					hbt.update(storeIndentM1);
						}



			if (storeIndentTlist.size() > 0) {
				if (pageNo != 1) {
					storeIndentM.setId(indentId);
				}
				for (int i = 0; i < storeIndentTlist.size(); i++) {

					StoreIndentT storeIndentTObj = new StoreIndentT();
					storeIndentTObj = (StoreIndentT) storeIndentTlist.get(i);
					storeIndentTObj.setIndent(storeIndentM);
					hbt.save(storeIndentTObj);
				}

			}
			successfullyAdded = "yes";
			String qry = "select mas.item_id,mas.pvms_no,mas.nomenclature,mas.strength,b.stock,c.qty_in_mmf,mas.old_niv_no,mas.department_id,con.item_unit_name from mas_store_item mas inner join mas_store_item_conversion con on mas.item_conversion_id= con.item_conversion_id left outer join (select ba.item_id,sum(ba.closing_stock) stock from store_item_batch_stock ba where department_id='"
					+ deptId
					+ "' group by ba.item_id)b on mas.item_id=b.item_id left outer join (select it.qty_in_mmf, it.item_id from  store_indent_m im inner join store_indent_t it on im.indent_id=it.indent_id where im.mmf_for_the_year='"
					+ year + "' )c on mas.item_id=c.item_id";
			objectList = (List) session.createSQLQuery(qry).list();
			masStoreSupplierList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasStoreSupplier as md where Hospital.Id ="+hospitalId+" order by md.SupplierName");
			searchIndentList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreIndentM as md where md.Status = 'y'");
			sectionList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasStoreSection ");
			masStoreAirForceDepotList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasStoreAirForceDepot as md where md.Status = 'y'");
			tx.commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			// //session.close();
		}

		map.put("masStoreSupplierList", masStoreSupplierList);
		map.put("searchIndentList", searchIndentList);
		map.put("sectionList", sectionList);
		map.put("objectList", objectList);
		map.put("successfullyAdded", successfullyAdded);
		map.put("indentId", indentId);
		map.put("masStoreAirForceDepotList", masStoreAirForceDepotList);

		return map;

	}
	
	// javed khan
	public Map<String, Object> generateExcelForDepotNe(Map<String,Object> dataMap)
	{
	int hospitalId = (Integer)dataMap.get("hospitalId");
	int deptId = (Integer)dataMap.get("deptId");
	String hospitalName = (String)dataMap.get("hospitalName");
	String deptName = (String)dataMap.get("deptName");
	String indentNo = (String)dataMap.get("indentNo");
	String indentDate="";
	String postalAddress="";
	String nrs="";
	String authority="";
	String Indentor="";
	String IndentType="";
	String self_life="";
	String section="";
	String code_head="";
	Session session = (Session) getSession();
	Map<String, Object> map = new HashMap<String, Object>();
	List<StoreIndentM>storeIndentMList=new

	ArrayList<StoreIndentM>();
	List<StoreIndentT>storeIndentTList=new ArrayList<StoreIndentT>();
	int indentId=0;
	try {


		storeIndentMList=session.createCriteria(StoreIndentM.class)
		.add(Restrictions.eq("IndentNo",indentNo))
		.add(Restrictions.eq("Department.Id",deptId))
		.add(Restrictions.eq("Hospital.Id",hospitalId))
		.add(Restrictions.eq("IndentType","d")).list();

		if(storeIndentMList.size()>0)
		{
			indentId=storeIndentMList.get(0).getId();



			storeIndentTList=session.createCriteria(StoreIndentT.class)
		.add(Restrictions.eq("Indent.Id",indentId)).list();

		if(storeIndentMList.get(0).getIndentDate()!=null)
		{


			indentDate=HMSUtil.changeDateToddMMyyyy(storeIndentMList.get(0).getIndentDate());
		}
		else
		{
			indentDate="";
		}
		if(storeIndentMList.get(0).getNrs()!=null)
		{
		nrs=storeIndentMList.get(0).getNrs();
		}
		else
		{
			nrs="";
		}


		if(storeIndentMList.get(0).getPatientDetails()!=null)
		{


		postalAddress=storeIndentMList.get(0).getPatientDetails();
		}
		else
		{
			postalAddress="";
		}
		if(storeIndentMList.get(0).getAuthority()!=null)
		{
		authority=storeIndentMList.get(0).getAuthority();
		}
		else
		{

			authority="";
		}
		if(storeIndentMList.get(0).getIndentOption().equals("I")){
			IndentType="Initial";
			}
		else if(storeIndentMList.get(0).getIndentOption().equals("R")){
			IndentType="Replacement";
		}
		/*else if(storeIndentMList.get(0).getIndentOption().equals("3")){    // javed khan
			IndentType="6 Months";
		}*/
		

		if(storeIndentMList.get(0).getSelfLife()!=null)
		{
			self_life=storeIndentMList.get(0).getSelfLife();
		}
		else{
			self_life="";
		}

		if(storeIndentMList.get(0).getSection() !=null)
		{
			section=storeIndentMList.get(0).getSection().getSectionCode();
		}
		else{
			section="";
		}

		if(storeIndentMList.get(0).getCodeHead() !=null)
		{
			code_head=storeIndentMList.get(0).getCodeHead();
		}
		else{
			code_head="";
		}

	Indentor=storeIndentMList.get(0).getHospital().getHospitalName()+" "+
						storeIndentMList.get(0).getHospital().getAddress();
		}

		byte[] buffer = new byte[18024];
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("TESTEXCEL");
		// Create a new font and alter it.
		HSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 13);
		font.setFontName(HSSFFont.FONT_ARIAL);
		font.setColor((short) 0x0);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

		HSSFFont font1 = wb.createFont();
		font1.setFontHeightInPoints((short) 10);
		font1.setFontName(HSSFFont.FONT_ARIAL);
		font1.setColor((short) 0x0);
		font1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

		HSSFCellStyle style1 = wb.createCellStyle();
		style1.setFont(font);

		HSSFCellStyle style = wb.createCellStyle();
		style.setFont(font1);


		HSSFRow hr1 = sheet.createRow(0);
		HSSFCell hc1=hr1.createCell((short)2);
		hc1.setCellValue("     ");
		hc1.setCellStyle(style1);


		HSSFRow hr2 = sheet.createRow(1);
		HSSFCell hc2=hr2.createCell((short)3);
		hc2.setCellValue("INDENT DEMAND ISSUE VOUCHER");
		hc2.setCellStyle(style);

		HSSFRow hr221 = sheet.createRow(1);
		HSSFCell hc221=hr221.createCell((short)8);
		hc221.setCellValue("In Lieu of F-1216");
		hc221.setCellStyle(style);

		HSSFRow hr222 = sheet.createRow(2);
		HSSFCell hc222=hr222.createCell((short)0);
		hc222.setCellValue(" "+IndentType+" Indent "+self_life+" Group Sec- "+section);
		hc222.setCellStyle(style);

		HSSFRow hr3 = sheet.createRow(4);
		HSSFCell hc3=hr3.createCell((short)0);
		hc3.setCellValue("Indent Demand No.");
		hc3.setCellStyle(style);

		HSSFRow hr4 = sheet.createRow(4);
		HSSFCell hc4=hr4.createCell((short)1);
		hc4.setCellValue(indentNo);

		HSSFRow hr33 = sheet.createRow(4);
		HSSFCell hc33=hr33.createCell((short)3);
		hc33.setCellValue("Supply Depot");
		hc33.setCellStyle(style);

		HSSFRow hr34 = sheet.createRow(4);
		HSSFCell hc34=hr34.createCell((short)4);
		hc34.setCellValue(storeIndentMList.get(0).getSuppliedBy().getAirForceDepotName());

		HSSFRow hr35 = sheet.createRow(4);
		HSSFCell hc35=hr35.createCell((short)7);
		hc35.setCellValue("PAYMENT ISSUE BY BOOK DEBIT");
		hc35.setCellStyle(style);

		HSSFRow hr5 = sheet.createRow(5);
		HSSFCell hc5=hr5.createCell((short)0);
		hc5.setCellValue("Dated");
		hc5.setCellStyle(style);

		HSSFRow hr6 = sheet.createRow(5);
		HSSFCell hc6=hr6.createCell((short)1);
		hc6.setCellValue(indentDate);


		HSSFRow hr7 = sheet.createRow(6);
		HSSFCell hc7=hr7.createCell((short)0);
		hc7.setCellValue("Sheet No.");
		hc7.setCellStyle(style);

		HSSFRow hr8 = sheet.createRow(6);
		HSSFCell hc8=hr8.createCell((short)1);
		hc8.setCellValue("01");

		HSSFRow hr9 = sheet.createRow(7);
		HSSFCell hc9=hr9.createCell((short)0);
		hc9.setCellValue("Authy Scale");
		hc9.setCellStyle(style);

		HSSFRow hr10 = sheet.createRow(7);
		HSSFCell hc10=hr10.createCell((short)1);
		hc10.setCellValue(authority);

		HSSFRow hr11 = sheet.createRow(8);
		HSSFCell hc11=hr11.createCell((short)0);
		hc11.setCellValue("Indentor");
		hc11.setCellStyle(style);

		HSSFRow hr12 = sheet.createRow(8);
		HSSFCell hc12=hr12.createCell((short)1);
		hc12.setCellValue(Indentor);


		HSSFRow hr13 = sheet.createRow(9);
		HSSFCell hc13=hr13.createCell((short)0);
		hc13.setCellValue("Address");
		hc13.setCellStyle(style);

		HSSFRow hr14 = sheet.createRow(9);
		HSSFCell hc14=hr14.createCell((short)1);
		hc14.setCellValue(postalAddress);

		HSSFRow hr15 = sheet.createRow(10);
		HSSFCell hc15=hr15.createCell((short)0);
		hc15.setCellValue("Signature");
		hc15.setCellStyle(style);

		HSSFRow hr151= sheet.createRow(10);
		HSSFCell hc151=hr151.createCell((short)1);
		hc151.setCellValue(" ");

		HSSFRow hr155 = sheet.createRow(11);
		HSSFCell hc155=hr155.createCell((short)0);
		hc155.setCellValue("Code Head");
		hc155.setCellStyle(style);

		HSSFRow hr156= sheet.createRow(11);
		HSSFCell hc156=hr156.createCell((short)1);
		hc156.setCellValue(code_head);

		HSSFRow hr16 = sheet.createRow(13);
		HSSFCell hc16=hr16.createCell((short)0);
		hc16.setCellValue("Sl No.");
		hc16.setCellStyle(style);

		HSSFRow hr17= sheet.createRow(13);
		HSSFCell hc17=hr17.createCell((short)1);
		hc17.setCellValue("PVMS No.");
		hc17.setCellStyle(style);

		HSSFRow hr18 = sheet.createRow(13);
		HSSFCell hc18=hr18.createCell((short)2);
		hc18.setCellValue("Nomenclature");
		hc18.setCellStyle(style);

		HSSFRow hr19 = sheet.createRow(13);
		HSSFCell hc19=hr19.createCell((short)3);
		hc19.setCellValue("A/U");
		hc19.setCellStyle(style);

		HSSFRow hr20 = sheet.createRow(13);
		HSSFCell hc20=hr20.createCell((short)4);
		hc20.setCellValue("Qty Held");
		hc20.setCellStyle(style);

		HSSFRow hr21 = sheet.createRow(13);
		HSSFCell hc21=hr21.createCell((short)5);
		hc21.setCellValue("Qty Auth.");
		hc21.setCellStyle(style);

		HSSFRow hr22 = sheet.createRow(13);
		HSSFCell hc22=hr22.createCell((short)6);
		hc22.setCellValue("Qty Demanded");
		hc22.setCellStyle(style);

		HSSFRow hr23 = sheet.createRow(13);
		HSSFCell hc23=hr23.createCell((short)7);
		hc23.setCellValue("Qty Sanction");
		hc23.setCellStyle(style);

		HSSFRow hr24= sheet.createRow(13);
		HSSFCell hc24=hr24.createCell((short)8);
		hc24.setCellValue("Qty Issued");
		hc24.setCellStyle(style);

		HSSFRow hr25 = sheet.createRow(13);
		HSSFCell hc25=hr25.createCell((short)9);
		hc25.setCellValue("Qty Outstanding");
		hc25.setCellStyle(style);

		HSSFRow hr26 = sheet.createRow(13);
		HSSFCell hc26=hr26.createCell((short)10);
		hc26.setCellValue("Cost Rs P");
		hc26.setCellStyle(style);

		HSSFRow hr27 = sheet.createRow(13);
		HSSFCell hc27=hr27.createCell((short)11);
		hc27.setCellValue("Remarks");
		hc27.setCellStyle(style);

		int row = 14;
		int slno = 0;

		String address="";
		String pvms="";
		String nomenclature="";
		String au="";
		double qtyStock=0f;
		double qtyDemand=0f;
		double qtyMmf=0f;
		double stockHeld=0f;
		for (StoreIndentT storeIndentT:storeIndentTList) {

			if(storeIndentT.getItem()!=null)
			{


				pvms=storeIndentT.getItem().getPvmsNo();


				nomenclature=storeIndentT.getItem().getNomenclature();


				au=storeIndentT.getItem().getItemConversion().getIssueUnit().getUnitName();
			}

			if(storeIndentT.getStockIn()!=null)
			{


				qtyStock=storeIndentT.getStockIn().doubleValue();
			}

			if(storeIndentT.getQtyInDemand()!=null)
			{


					qtyDemand=storeIndentT.getQtyInDemand().doubleValue();
			}
			// javed khan
			if(storeIndentT.getQtyInMmf()!=null)
			{


					qtyMmf=storeIndentT.getQtyInMmf().doubleValue();
			}
			if(storeIndentT.getStockIn()!=null)
			{


					stockHeld=storeIndentT.getStockIn().doubleValue();
			}

			HSSFRow r1 = sheet.createRow(row);
			HSSFCell c1=r1.createCell((short)0);
			c1.setCellValue(++slno);


			HSSFCell c2=r1.createCell((short)1);
			c2.setCellValue(pvms);

			HSSFCell c3=r1.createCell((short)2);
			c3.setCellValue(nomenclature);

			HSSFCell c4=r1.createCell((short)3);
			c4.setCellValue(au);

			HSSFCell c5=r1.createCell((short)4);
			c5.setCellValue(stockHeld);

			HSSFCell c6=r1.createCell((short)5);
			c6.setCellValue(qtyMmf);

			HSSFCell c7=r1.createCell((short)6);
			c7.setCellValue(qtyDemand);

			HSSFCell c8=r1.createCell((short)7);
			c8.setCellValue(" ");

			HSSFCell c9=r1.createCell((short)8);
			c9.setCellValue(" ");

			HSSFCell c10=r1.createCell((short)9);
			c10.setCellValue(" ");

			HSSFCell c11=r1.createCell((short)10);
			c11.setCellValue(" ");

			HSSFCell c12=r1.createCell((short)11);
			c12.setCellValue(" ");

			sheet.setColumnWidth((short)0,(short)(12 * 256));
			sheet.setColumnWidth((short)1,(short)(10 * 270));
			sheet.setColumnWidth((short)2,(short)(35 * 256));
			sheet.setColumnWidth((short)3,(short)(20 * 256));
			sheet.setColumnWidth((short)4,(short)(15 * 256));
			sheet.setColumnWidth((short)5,(short)(15 * 256));
			sheet.setColumnWidth((short)6,(short)(15 * 256));
			sheet.setColumnWidth((short)7,(short)(14 * 256));
			sheet.setColumnWidth((short)8,(short)(10 * 256));
			sheet.setColumnWidth((short)9,(short)(13 * 256));
			sheet.setColumnWidth((short)10,(short)(10 * 256));
			sheet.setColumnWidth((short)11,(short)(10 * 256));


			row++;
		}

		HSSFRow hr30 = sheet.createRow(15+slno);
		HSSFCell hc30=hr30.createCell((short)0);
		hc30.setCellValue("Total Item in this Indent - "+slno+" Item only");
		hc30.setCellStyle(style);

		HSSFRow hr31 = sheet.createRow(17+slno);
		HSSFCell hc31=hr31.createCell((short)7);
		hc31.setCellValue("Certificate");
		hc31.setCellStyle(style);

		HSSFRow hr32 = sheet.createRow(19+slno);
		HSSFCell hc32=hr32.createCell((short)4);
		hc32.setCellValue("Certified that M/M demended vide our indent No "+indentNo+" & issued vide");
		hc32.setCellStyle(style);

		HSSFRow hr37 = sheet.createRow(20+slno);
		HSSFCell hc37=hr37.createCell((short)4);
		hc37.setCellValue("your depot no  P-168/03/2011 has been taken into account while  submitting the indent.");
		hc37.setCellStyle(style);

		String fileName = "IndentToDepot.xls";

		FileOutputStream fileOut = new

		FileOutputStream(fileName);
		wb.write(fileOut);
		fileOut.close();

		map.put("flag", "DataFound");

		map.put("download_path", fileName);
	} catch (IOException ioe) {
		ioe.printStackTrace();
		map.put("flag", "NoData");
	}

	return map;
   }
	
	@Override
	public Map<String, Object> newSearchIndentNe(Map<String, Object> searchFieldMap) {
		//System.out.println("showIndentJspDepot");
		Map<String, Object> map = new HashMap<String, Object>();
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		int indentId = 0;

		if (searchFieldMap.get("deptId") != null)
			deptId = Integer.parseInt("" + searchFieldMap.get("deptId"));
		if (searchFieldMap.get("hospitalId") != null)
			hospitalId = Integer.parseInt("" + searchFieldMap.get("hospitalId"));
		if (searchFieldMap.get("userName") != null)
			userName = ("" + searchFieldMap.get("userName"));
		if (searchFieldMap.get("indentId") != null)
			indentId = Integer.parseInt("" + searchFieldMap.get("indentId"));

		List<StoreIndentM> searchIndentList = new ArrayList<StoreIndentM>();
		List<MasStoreSection> sectionList = new ArrayList<MasStoreSection>();
		List<MasStoreAirForceDepot> masStoreAirForceDepotList = new ArrayList<MasStoreAirForceDepot>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List<StoreIndentM> list = new ArrayList<StoreIndentM>();

		int grnStartNo = 0;
		String no = "";
		session = (Session) getSession();
		List objectList = new ArrayList();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		int year = Integer.parseInt(date.substring(6));
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {

	/*		masStoreAirForceDepotList =getHibernateTemplate().find(
							"from jkt.hms.masters.business.MasStoreAirForceDepot as md where md.Status = 'y'");
	*/		
			masStoreAirForceDepotList=session.createCriteria(MasStoreAirForceDepot.class).add(Restrictions.eq("Status", "y")).list();
			if (indentId!=0 ){
				searchIndentList=session.createCriteria(StoreIndentM.class)
				.add(Restrictions.eq("Status","o"))
				.add(Restrictions.eq("Department.Id",deptId))
				.add(Restrictions.eq("IndentType","d"))
				.add(Restrictions.eq("Hospital.Id",hospitalId))
				.add(Restrictions.eq("Id",indentId))
				.list();	
			}else if(indentId == 0 && searchFieldMap.get("fromDate") == null &&  searchFieldMap.get("toDate")== null){
			/*searchIndentList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreIndentM as md where md.Status = 'o'and  md.Department.Id='"
									+ deptId + "' and md.IndentType='d' and md.Hospital.Id="+hospitalId+" order by md.Id desc ");
	*/		searchIndentList=session.createCriteria(StoreIndentM.class)
							.add(Restrictions.eq("Status","o"))
							.add(Restrictions.eq("Department.Id",deptId))
							.add(Restrictions.eq("IndentType","d"))
							.add(Restrictions.eq("Hospital.Id",hospitalId))
							.addOrder(Order.desc("Id"))
							.list();		
			}else if(searchFieldMap.get("fromDate") != null &&  searchFieldMap.get("toDate")!= null)
			{
				String fromDate=(String)searchFieldMap.get("fromDate");
				String toDate=(String)searchFieldMap.get("toDate");
				/*SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
				String date4MySQL1 = formatterOut.format(formatterIn
						.parse(fromDate));
				String date4MySQL2 = formatterOut.format(formatterIn
						.parse(toDate));

				System.out.println("fromDate----- imp"+ date4MySQL1);
				System.out.println("fromDate----- imp"+ date4MySQL2);

				java.sql.Date startDate = java.sql.Date.valueOf(date4MySQL1);
				java.sql.Date endDate = java.sql.Date.valueOf(date4MySQL2);*/


	//session.createSQLQuery("select sim.INDENT_ID FROM STORE_INDENT_M sim WHERE SIM.STATUS='o' AND SIM.INDENT_TYPE='d' and sim.DEPARTMENT_ID='"+deptId+"' and sim.HOSPITAL_ID='"+hospitalId+"'  and SIM.INDENT_DATE BETWEEN TO_DATE('"+fromDate+"','DD/MM/YYYY') AND TO_DATE('"+toDate+"','DD/MM/YYYY') order by sim.INDENT_ID").list();			
		//	List indentList=
			Criteria c=	session.createCriteria(StoreIndentM.class)
	.add(Restrictions.eq("Status","o"))
							.add(Restrictions.eq("Department.Id",deptId))
							.add(Restrictions.eq("IndentType","d"))
							.add(Restrictions.eq("Hospital.Id",hospitalId))
							.add(Restrictions.between("IndentDate", HMSUtil.convertStringTypeDateToDateType(fromDate), HMSUtil.convertStringTypeDateToDateType(toDate)));
					c=c.setProjection(Projections.projectionList().add(Projections.property("Id")));
					List indentList=c.addOrder(Order.desc("Id")).list();

				for(int i=0;i<indentList.size();i++){
					/*Object[] object=(Object[])indentList.get(i);
					System.out.println(object[0]);*/
					int IndentId=Integer.parseInt(indentList.get(i).toString());
				    StoreIndentM sim = new StoreIndentM();
				    sim=(StoreIndentM) hbt.load(StoreIndentM.class,IndentId);
				    searchIndentList.add(sim);
				}
				/*searchIndentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.StoreIndentM as md where md.Status = 'o'and  md.Department.Id="+ deptId+ " and md.IndentDate between '" + startDate+ "' and '"+ endDate +" and  md.IndentType='d' and md.Hospital.Id="+hospitalId+" order by md.Id desc ");*/

			}else{
				
	/*			searchIndentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.StoreIndentM as md where md.Status = 'o'and  md.Department.Id='"
								+ deptId + "' and md.IndentType='d' and md.Id="+indentId+" and md.Hospital.Id="+hospitalId+" order by md.Id desc ");
	*/
				
				
				searchIndentList=session.createCriteria(StoreIndentM.class)
				.add(Restrictions.eq("Status","o"))
				.add(Restrictions.eq("Department.Id",deptId))
				.add(Restrictions.eq("IndentType","d"))
				.add(Restrictions.eq("Hospital.Id",hospitalId))
				.add(Restrictions.eq("IndentNo",hospitalId))
				.addOrder(Order.desc("Id"))
				.list();	
			
			}
	/*		sectionList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasStoreSection ");
	*/
			
			sectionList=session.createCriteria(MasStoreSection.class).list();
			

		} catch (Exception e) {
			//System.out.println("1");
			e.printStackTrace();
		}
		//System.out.println("masStoreAirForceDepotList  "+ masStoreAirForceDepotList.size());
		map.put("masStoreAirForceDepotList", masStoreAirForceDepotList);
		map.put("searchIndentList", searchIndentList);
		map.put("sectionList", sectionList);
		map.put("maxIndentNo", no);

		return map;
	}

	//--------------End By Javed
	// this method by sanjay yadav
	public Map<String, Object> getItemListForDefectiveDrugsByAutocomplete(	Map<String, Object> dataMap) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List<MasStoreItem> itemList1 = new ArrayList<MasStoreItem>();
		session = (Session) getSession();
		//String pvmsNo = null;
		//Box box = (Box) dataMap.get("box");
		int hospitalId=0;
		int deptId = 0;
		hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		deptId = Integer.parseInt("" + dataMap.get("deptId"));
		List objectList = new ArrayList();
		try {
			String str = (String) dataMap.get("autoHint");
			str=str.toUpperCase()+ "%";
			//String qry = "SELECT item_id FROM store_item_batch_stock where department_id="
				//+ deptId+" and hospital_id="+hospitalId ;

			//objectList = (List) session.createSQLQuery(qry).list();
			/*if (objectList.size() != 0) {
				List<BigDecimal> objectNewList = new ArrayList<BigDecimal>();
				String sql="";
				for (int i=0;i<objectList.size();i++) {
					if(i<100){
						if(i==0){
							sql=""+objectList.get(i);
						}else{
							sql=sql+" , "+objectList.get(i);
						}
					}
				}
				Criteria c = session.createCriteria(MasStoreItem.class)
					.add(Restrictions.like("Nomenclature", str))

					.add(Restrictions.in("Id", objectList));
			c.setFirstResult(0);
			c.setMaxResults(10);
			itemList = c.list();
				if(!sql.equals(""))

				{ 
					itemList=getHibernateTemplate().find("select item from jkt.hms.masters.business.MasStoreItem as item where upper(item.Nomenclature) like '"+str+"'  and item.ItemType.Id='2' and item.Hospital.Id='"+hospitalId+"'");
					itemList1=getHibernateTemplate().find("select item from jkt.hms.masters.business.MasStoreItem as item where upper(item.Nomenclature) like '"+str+"' and item.ItemType.Id='1'");
					itemList.addAll(itemList1);

				}else{
					itemList=getHibernateTemplate().find("select item from jkt.hms.masters.business.MasStoreItem as item where upper(item.Nomenclature) like '"+str+"'  and item.ItemType.Id='2' and item.Hospital.Id='"+hospitalId+"'");
					itemList1=getHibernateTemplate().find("select item from jkt.hms.masters.business.MasStoreItem as item where upper(item.Nomenclature) like '"+str+"' and item.ItemType.Id='1'");
					itemList.addAll(itemList1);
				}



			}*/ 
			//else {
				/*Criteria c = session.createCriteria(MasStoreItem.class)
						.add(Restrictions.eq("Status", "y")).add(Restrictions.like("Nomenclature", str).ignoreCase());
				c.setFirstResult(0);
				c.setMaxResults(10);
				itemList = c.list();*/

				itemList=getHibernateTemplate().find("select item from jkt.hms.masters.business.MasStoreItem as item where upper(item.Nomenclature) like '"+str+"' and item.Status='y'  and item.ItemType.Id='2' and item.TypeOfItem='NE'  and item.Hospital.Id='"+hospitalId+"'");
				itemList1=getHibernateTemplate().find("select item from jkt.hms.masters.business.MasStoreItem as item where upper(item.Nomenclature) like '"+str+"' and item.Status='y' and item.ItemType.Id='1' and item.TypeOfItem='NE' ");

				itemList.addAll(itemList1);
			//}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("itemList", itemList);
		map.put("objectList", objectList);
		return map;
	}

	@Override
	public Map<String, Object> getItemListForCondemnationByAutocomplete(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreItemBatchStock> itemList = new ArrayList<StoreItemBatchStock>();
		//List<MasStoreItem> itemList1 = new ArrayList<MasStoreItem>();
		session = (Session) getSession();
		//String pvmsNo = null;
		//Box box = (Box) dataMap.get("box");
		int hospitalId=0;
		int deptId = 0;
		hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		deptId = Integer.parseInt("" + dataMap.get("deptId"));
		List objectList = new ArrayList();
		try {
			String str = (String) dataMap.get("autoHint");
			str=str.toUpperCase()+ "%";
			/*String qry = "SELECT item_id FROM store_item_batch_stock where department_id="
				+ deptId+" and hospital_id="+hospitalId ;*/
			itemList = session.createCriteria(StoreItemBatchStock.class)
								.createAlias("Item", "item").add(Restrictions.like("item.Nomenclature", str))
								.add(Restrictions.eq("Department.Id", deptId)).add(Restrictions.eq("Hospital.Id", hospitalId))
								.add(Restrictions.eq("item.TypeOfItem", "NE")).list();
			System.out.println(itemList.size()+"  "+str+"    "+deptId);

		
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("itemList", itemList);
		//map.put("objectList", objectList);
		return map;
	}

	
	// By Sanjay Yadav
	public Map<String, Object> fillItemsForDefectiveDrugs(
			Map<String, Object> dataMap) {
		session = (Session) getSession();
		String pvms = null;
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
		List<StoreItemBatchStock> batchList = new ArrayList<StoreItemBatchStock>();
		List objectList = new ArrayList();
		int deptId = 0;
		int hospitalId=0;
		BigDecimal  qty =new BigDecimal(0);
		BigDecimal stockIn = null;
		if (dataMap.get("deptId") != null) {
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		}
		if (dataMap.get("hospitalId") != null) {
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		}
		BigDecimal stock = new BigDecimal(0);
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
		String date4MySQL = null;
		try {
			date4MySQL = formatterOut.format(formatterIn.parse(date));
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		Date datestr = java.sql.Date.valueOf(date4MySQL);
		//String issueDate=sdf.format(datestr);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		String issueDate=sdf.format(datestr);
		try {
			String str = "" + dataMap.get("pvmsNo");

			// add Sanjay

			// comment by Sanjay Yadav for SQL Injuction on 19-03-2013

			/*String sqlQry="select  msi.ITEM_TYPE_ID  from mas_store_item msi  where msi.PVMS_NO=UPPER('"+str+"')";
			List nivList=session.createSQLQuery(sqlQry).list();*/

			// comment by Sanjay Yadav for SQL Injuction on 19-03-2013


			// add by Sanjay Yadav for SQL Injuction on 19-03-2013

			Criteria c = session.createCriteria(MasStoreItem.class);
			List nivList=c.setProjection(Projections.projectionList().add(Projections.property("ItemType.Id"))).add(
					Restrictions.eq("PvmsNo", str.toUpperCase())).list();

			// add by Sanjay Yadav for SQL Injuction on 19-03-2013
			if(nivList != null)
			{

			if(nivList.size() > 0 && (Integer.parseInt((""+nivList.get(0)))) == 2){
				itemList = session.createCriteria(MasStoreItem.class)
				.add(Restrictions.eq("PvmsNo", str).ignoreCase()).add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.eq("Status", "y")).list();
			}else{
				itemList = session.createCriteria(MasStoreItem.class)
				.add(Restrictions.eq("PvmsNo", str).ignoreCase())
				.add(Restrictions.eq("Status", "y")).list();
			}
			}

			/*Criteria c = session.createCriteria(MasStoreItem.class).add(
					Restrictions.eq("PvmsNo", str).ignoreCase()).add(
					Restrictions.eq("Status", "y"));
			itemList = c.list();*/
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		if(itemList.size()>0){
			try {
				int itemId = 0;
				for (MasStoreItem masStoreItem : itemList) {
					itemId = masStoreItem.getId();
				}
				if (itemId != 0) {
					Criteria c2 = session.createCriteria(MasStoreBrand.class).add(
							Restrictions.eq("Item.Id", itemId));
					brandList = c2.list();
				}
				if (itemId != 0) {
					Criteria c3 = session.createCriteria(StoreItemBatchStock.class)
					.add(Restrictions.eq("Item.Id", itemId)).add(Restrictions.eq("Hospital.Id", hospitalId)).add(Restrictions.gt("ClosingStock", new BigDecimal(0.0)));// add javed khan
					batchList = c3.list();
				}
				if(itemId != 0)
				{
					String qry = "select qty from store_me_scale_details  sm where  sm.item_id='"+itemId+"'";
					List itemListForMeScale	= session.createSQLQuery(qry).list();
					if(itemListForMeScale.size()>0){
					 qty = (BigDecimal)itemListForMeScale.get(0);
					}else{
						qty = new BigDecimal(0);
					}
					
				}
				//  Turn over Register
				List<StoreItemBatchStock> batchListForTurnOver = new ArrayList<StoreItemBatchStock>();
				if (itemId != 0) {
					Criteria c4 = session.createCriteria(StoreItemBatchStock.class)
					.add(Restrictions.eq("Item.Id", itemId)).add(Restrictions.eq("Department.Id", deptId))
					.add(Restrictions.eq("Hospital.Id", hospitalId)).add(Restrictions.gt("ClosingStock", new BigDecimal(0.0)));   // add javed khan
					batchListForTurnOver = c4.list();
				}
				if (itemList != null && itemList.size() > 0) {
					itemId = itemList.get(0).getId();
					String str3 = "select sum(a.closing_stock) from store_item_batch_stock a,mas_store_item i " +
					" where a.item_id=i.item_id and a.item_id = '"
					+ itemId
					+ "' and a.department_id='"
					+ deptId
					+"' and a.hospital_id='"
					+ hospitalId
					+ "' and a.expiry_date > '"
					+issueDate
					+ "' and a.closing_stock >0 "
					+ " group by a.item_id ";


					List stockAvailableList = session.createSQLQuery(str3).list();
					if (stockAvailableList.size() > 0
							&& stockAvailableList.get(0) != null) {
						stock = (BigDecimal) stockAvailableList.get(0);
					} else {
						stock = new BigDecimal("0");
					}
				}
				map.put("brandList", brandList);
				map.put("itemList", itemList);
				map.put("batchList", batchList);
				map.put("batchListForTurnOver", batchListForTurnOver);
				map.put("stock", stock);
				map.put("qty", qty);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return map;
	}
	//Add by Sanjay Yadav
	public Map<String, Object> getItemListForIssueToDispensary(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List<MasStoreItem> itemList1 = new ArrayList<MasStoreItem>();
		List<StoreSetup> storeSetupList = new ArrayList<StoreSetup>();
		List<Integer> stockIdList = new ArrayList<Integer>();
		session = (Session) getSession();
		String pvmsNo = null;
		int deptId = 0;
		int issueId = 0;
		int hospitalId=0;

		try {
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			String date = (String) utilMap.get("currentDate");
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			String date4MySQL = formatterOut.format(formatterIn.parse(date));
			Date datestr = java.sql.Date.valueOf(date4MySQL);
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			String issueDate=sdf.format(datestr);
			//	Date issueDate = java.sql.Date.valueOf(date4MySQL);

			deptId = Integer.parseInt("" + dataMap.get("deptId"));
			issueId = Integer.parseInt("" + dataMap.get("issueId"));
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));  // add javed khan
			List objectList = new ArrayList();
			String str = dataMap.get("autoHint") + "%";
			String qry = " SELECT item_id FROM store_issue_t where issue_m_id='"
				+ issueId + "'";

			String qry2 = "SELECT item_id FROM store_item_batch_stock where department_id="
				+ deptId
				+"and hospital_id= "
				+hospitalId
				+ " and closing_stock > 0 and  expiry_date > '"
				+ issueDate + "'";

			stockIdList = (List) session.createSQLQuery(qry2).list();
			objectList = (List) session.createSQLQuery(qry).list();
			/*
			 * if((objectList.size() > 0)&&(stockIdList.size()>0)){
			 *
			 * Criteria c =
			 * session.createCriteria(MasStoreItem.class).add(Restrictions.like("Nomenclature",str))
			 * .add(Restrictions.eq("Department.Id", deptId))
			 * .add(Restrictions.in("Id",stockIdList))
			 * .add(Restrictions.not(Restrictions.in("Id", objectList)));
			 * c.setFirstResult(0); c.setMaxResults(10); itemList = c.list();
			 * }else if((stockIdList.size()>0)){ Criteria c =
			 * session.createCriteria(MasStoreItem.class).add(Restrictions.like("Nomenclature",str))
			 * .add(Restrictions.in("Id",stockIdList))
			 * .add(Restrictions.eq("Department.Id", deptId));
			 *
			 * c.setFirstResult(0); c.setMaxResults(10); itemList = c.list();
			 *  }
			 */



			/*if (dataMap.get("typeOfIssue") != null
					&& dataMap.get("typeOfIssue").toString().equalsIgnoreCase("OtherUnits")) {
				storeSetupList = session.createCriteria(StoreSetup.class).list();
				if (storeSetupList != null && storeSetupList.size() > 0) {
					deptId = storeSetupList.get(0).getStoreExpendable().getId();
				}
			}*/

			if(dataMap.get("deptId") != null )
			{
				deptId=(Integer)dataMap.get("deptId");
			}

			if ((stockIdList.size() > 0)) {
				/*Criteria c = session.createCriteria(MasStoreItem.class).add(
						Restrictions.like("Nomenclature", str).ignoreCase())
						//.add( Restrictions.in("Id", stockIdList))
						.add(Restrictions.eq("Department.Id", deptId))
						.add(Restrictions.eq("Status", "y"));
				 */


			

				Criteria c = session.createCriteria(MasStoreItem.class).add(
						Restrictions.like("Nomenclature", str).ignoreCase())
						//.add( Restrictions.in("Id", stockIdList))
						.add(Restrictions.eq("ItemType.Id", 2))
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("Status", "y"));


				c.setFirstResult(0);
				c.setMaxResults(10);
				itemList = c.list();

				Criteria c1 = session.createCriteria(MasStoreItem.class).add(
						Restrictions.like("Nomenclature", str).ignoreCase())
						.add(Restrictions.eq("ItemType.Id", 1))
						.add(Restrictions.eq("Status", "y"));
				c1.setFirstResult(0);
				c1.setMaxResults(10);
				itemList1 = c1.list();
				itemList.addAll(itemList1);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("itemList", itemList);
		return map;

	}
// Add By Sanjay Yadav
	public Map<String, Object> fillItemsForIssueToDispensary(
			Map<String, Object> dataMap) {

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		String pvmsNo = null;
		int deptId = 0;
		int hospitalId = 0;
		pvmsNo = "" + dataMap.get("pvmsNo");

		deptId = Integer.parseInt("" + dataMap.get("deptId"));
		hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));  
		BigDecimal stock = new BigDecimal(0);
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
		String date4MySQL = null;
		try {
			date4MySQL = formatterOut.format(formatterIn.parse(date));
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		Date datestr = java.sql.Date.valueOf(date4MySQL);
		//String issueDate=sdf.format(datestr);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		String issueDate=sdf.format(datestr);
		List<StoreItemBatchStock> batchList = new ArrayList<StoreItemBatchStock>();

		//Date issueDate = java.sql.Date.valueOf(date4MySQL);

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			String queryString = null;
			String str = "" + dataMap.get("nomenclature");


			String sqlQry="select  msi.ITEM_TYPE_ID  from mas_store_item msi  where msi.PVMS_NO=UPPER('"+pvmsNo+"')";

			List nivList=session.createSQLQuery(sqlQry).list();
		
				itemList = session.createCriteria(MasStoreItem.class)
				.add(Restrictions.eq("PvmsNo", pvmsNo).ignoreCase()).add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.eq("Status", "y")).list();
				/*if((Integer.parseInt((""+nivList.get(0)))) == 1){

			}else{
				itemList = session.createCriteria(MasStoreItem.class)
				.add(Restrictions.eq("PvmsNo", pvmsNo).ignoreCase())
				.add(Restrictions.eq("Status", "y")).list();
			}*/



			/*Criteria c = session.createCriteria(MasStoreItem.class).add(
					Restrictions.like("PvmsNo", pvmsNo).ignoreCase()).add(
					Restrictions.eq("Hospital.Id", hospitalId)).add(
					Restrictions.eq("Status", "y"));
			itemList = c.list();*/

			if (itemList != null && itemList.size() > 0) {
				int itemId = itemList.get(0).getId();
				String str3 = "select sum(a.closing_stock) from store_item_batch_stock a,mas_store_item i " +
				" where a.item_id=i.item_id and a.item_id = '"
				+ itemId
				+ "' and a.department_id='"
				+ deptId
				+"' and a.hospital_id='"
				+ hospitalId
				+ "' and a.expiry_date > '"
				+issueDate
				+ "' and a.closing_stock >0 "
				+ " group by a.item_id ";


				List stockAvailableList = session.createSQLQuery(str3).list();

			

				Criteria c4 = session.createCriteria(StoreItemBatchStock.class)
				.add(Restrictions.eq("Item.Id", itemId)).add(Restrictions.eq("Department.Id", deptId))
				.add(Restrictions.eq("Hospital.Id", hospitalId)).add(Restrictions.gt("ClosingStock", new BigDecimal(0.0)));  // add javed khan
				batchList = c4.list();


				if (stockAvailableList.size() > 0
						&& stockAvailableList.get(0) != null) {
					stock = (BigDecimal) stockAvailableList.get(0);
				} else {
					stock = new BigDecimal("0");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("batchList", batchList);
		map.put("itemList", itemList);
		map.put("stock", stock);
		return map;

	}
	public boolean submitMeScale(Map map)
	{ 
		int hospitalId = 0;
		int departmentId =0;
		Integer meScaleNumber= 0;
		List<String> meScaleDescription = new ArrayList<String>();
		List<String>  itemCode = new ArrayList<String>();
		List<String>  nameItem = new ArrayList<String>();
		List<Integer> itemId = new ArrayList<Integer>();
		List<String> au = new ArrayList<String> ();
		List<BigDecimal> qty = new ArrayList<BigDecimal>();
		List<StoreMeScaleDetails> storeMeScaleDetailIdList = new ArrayList<StoreMeScaleDetails>();
		Session session = (Session)getSession();
		int hdb =1;
		boolean successfullyAdded = false;
		if(map.get("hospitalId")!= null && !(map.get("hospitalId")).equals(""))
	    {
		hospitalId= (Integer)map.get("hospitalId");
	    }
	    if(map.get("departmentId")!= null && !(map.get("departmentId")).equals(""))
	    {
		departmentId = (Integer)map.get("departmentId");
	    }
	    if(map.get("itemIdList")!= null && !(map.get("itemIdList")).equals(""))
	    {
	    	itemId = (List)map.get("itemIdList");
	    }
	    
		 if(map.get("meScaleNumber")!= null && !(map.get("meScaleNumber")).equals(""))
		    {
			 meScaleNumber = (Integer)map.get("meScaleNumber");
		    }
		 if(map.get("meScaleDescription")!= null && !(map.get("meScaleDescription")).equals(""))
		    {
			 meScaleDescription = (List)map.get("meScaleDescription");
		    }
		 if(map.get("itemCode")!= null && !(map.get("itemCode")).equals(""))
		    {
			 itemCode = (List)map.get("itemCode");
		    }
		 if(map.get("nameItem")!= null && !(map.get("nameItem")).equals(""))
		    {
			 nameItem = (List)map.get("nameItem");
		    }
		 if(map.get("au")!= null && !(map.get("au")).equals(""))
		    {
			 au = (List)map.get("au");
		    }
		 if(map.get("qty")!= null && !(map.get("qty")).equals(""))
		    {
			 qty = (List)map.get("qty");
		    }
		 if(map.get("hdb1")!= null && !(map.get("hdb1")).equals(""))
		    {
			   hdb = (Integer)map.get("hdb1");
		    }
		
		try
		{
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		       hbt.setFlushModeName("FLUSH_EAGER");
			   hbt.setCheckWriteOperations(false);
			   
			  
		   int itemIdMeScale = 0;
		   int storeMeScaleId = 0;
		 for(int i=0; i<hdb; i++  ){ 
			 storeMeScaleDetailIdList = session.createCriteria(StoreMeScaleDetails.class)
			 .createAlias("Item", "item").add(Restrictions.eq("item.Id", itemId.get(i)))
			 .add(Restrictions.eq("Department.Id", departmentId)).add(Restrictions.eq("Hospital.Id", hospitalId)).list();
	    if(storeMeScaleDetailIdList.size()>0){
			   for(int j=0; j<storeMeScaleDetailIdList.size(); j++ ){ 
				   StoreMeScaleDetails storeMeScaleDetails =storeMeScaleDetailIdList.get(j) ;
				   itemIdMeScale = storeMeScaleDetails.getItem().getId();
				   storeMeScaleId = storeMeScaleDetails.getId();
			   }}
	    		if(itemIdMeScale == itemId.get(i)){
				   StoreMeScaleDetails  meDetails = (StoreMeScaleDetails)hbt.load(StoreMeScaleDetails.class, storeMeScaleId);
				   if(qty.get(i) != null ) {
			    	  BigDecimal newQuantity = (BigDecimal)qty.get(i);
			    	  meDetails.setQty( newQuantity) ;
				    }
				   hbt.update(meDetails);
				   successfullyAdded = true;
			   
		   
		   }else{
			    StoreMeScaleDetails  storeMeScaleDetails = new StoreMeScaleDetails();
				 //  System.out.println("In For Loop");
				MasHospital masHospital = new MasHospital();
			    masHospital.setId(hospitalId);
			   
			    storeMeScaleDetails.setHospital(masHospital);
			    MasDepartment masDepartment = new MasDepartment();
			    masDepartment.setId(departmentId);
			    storeMeScaleDetails.setDepartment(masDepartment);
			   
			    if(itemId.get(i)!=null && !(itemId.get(i)).equals("") )
			    {
			    MasStoreItem masStoreItem = new MasStoreItem();				   
			    masStoreItem.setId(itemId.get(i));
			    storeMeScaleDetails.setItem(masStoreItem);
			    }
			  
			    if(map.get("meScaleNumber")!= null && !(map.get("meScaleNumber")).equals(""))
			    {
			    storeMeScaleDetails.setSerialNo(meScaleNumber);
			    }
			   
			    if(qty.get(i) != null )
			    {
			    	BigDecimal newQuantity = (BigDecimal)qty.get(i);
			    	  storeMeScaleDetails.setQty( newQuantity) ;
			    }
			  
			    hbt.save(storeMeScaleDetails);
			    successfullyAdded = true;
			    }
			  
		   }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return successfullyAdded;
		
	}
	
	//----By Dipali For Board of survy---
	public Map<String, Object> getItemListForBoardOfSurveyAutocom(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = (Session) getSession();
		int hospitalId=0;
		int deptId = 0;
		hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		deptId = Integer.parseInt("" + dataMap.get("deptId"));
		List objectList = new ArrayList();
			try {
				String str = "";
				if (dataMap.get("autoHint") != null) {
					str = dataMap.get("autoHint") + "%";
				}
			List<StoreItemBatchStock> itemList = new ArrayList<StoreItemBatchStock>();
			itemList=session.createCriteria(StoreItemBatchStock.class).add(Restrictions.eq("Department.Id", deptId))
				.add(Restrictions.eq("Hospital.Id", hospitalId)).createAlias("Item","itm").
				add(Restrictions.like("itm.Nomenclature", str.toUpperCase()))
				.add(Restrictions.eq("itm.TypeOfItem", "NE")).list();
				/*List<StoreCondemnationT> itemList = new ArrayList<StoreCondemnationT>();		
				itemList=session.createCriteria(StoreCondemnationT.class).
				  createAlias("CondemM","cnm").add(Restrictions.eq("cnm.Department.Id", deptId))
				.add(Restrictions.eq("cnm.Hospital.Id", hospitalId))
				.createAlias("Item","itm").add(Restrictions.like("itm.Nomenclature", str.toUpperCase())).list();*/
				map.put("itemList", itemList);
			} catch (HibernateException e) {
				e.printStackTrace();
			}
		return map;
	}


	@Override
	public Map<String, Object> getItemListForEquipmentLoanOut(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = (Session) getSession();
		int hospitalId=0;
		int deptId = 0;
		hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		deptId = Integer.parseInt("" + dataMap.get("deptId"));
		List objectList = new ArrayList();
			try {
				String str = "";
				if (dataMap.get("autoHint") != null) {
					str = dataMap.get("autoHint") + "%";
				}
		List<StoreItemBatchStock> batchItemList = new ArrayList<StoreItemBatchStock>();
		batchItemList=session.createCriteria(StoreItemBatchStock.class)
							.add(Restrictions.eq("Department.Id", deptId))
								.add(Restrictions.eq("Hospital.Id", hospitalId)).createAlias("Item","itm").
									add(Restrictions.like("itm.Nomenclature", str.toUpperCase()))
										.add(Restrictions.eq("itm.TypeOfItem", "NE")).list();
			
		map.put("batchItemList", batchItemList);
			} catch (HibernateException e) {
				e.printStackTrace();
			}
return map;
	}

	@Override
	public Map<String, Object> fillItemsForEquipmentLoanOut(
			Map<String, Object> dataMap) {
		session = (Session) getSession();
		String pvms = null;
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
		List<StoreItemBatchStock> batchList = new ArrayList<StoreItemBatchStock>();
		List objectList = new ArrayList();
		int deptId = 0;
		int hospitalId=0;
		BigDecimal stockIn = null;
		if (dataMap.get("deptId") != null) {
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		}
		if (dataMap.get("hospitalId") != null) {
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		}
		try {
			String str = "" + dataMap.get("pvmsNo");

			Criteria c = session.createCriteria(MasStoreItem.class);
			List nivList=c.setProjection(Projections.projectionList().add(Projections.property("ItemType.Id"))).add(
					Restrictions.eq("PvmsNo", str.toUpperCase())).list();

			if(nivList != null)
			{

			if(nivList.size() > 0 && (Integer.parseInt((""+nivList.get(0)))) == 2){
				itemList = session.createCriteria(MasStoreItem.class)
				.add(Restrictions.eq("PvmsNo", str).ignoreCase()).add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.eq("Status", "y")).list();

			}else{
				itemList = session.createCriteria(MasStoreItem.class)
				.add(Restrictions.eq("PvmsNo", str).ignoreCase())
				.add(Restrictions.eq("Status", "y")).list();
			}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		if(itemList.size()>0){
			try {
				int itemId = 0;
				for (MasStoreItem masStoreItem : itemList) {
					itemId = masStoreItem.getId();

				}
				if (itemId != 0) {
					Criteria c2 = session.createCriteria(MasStoreBrand.class).add(
							Restrictions.eq("Item.Id", itemId));
					brandList = c2.list();
				}

				if (itemId != 0) {
					Criteria c3 = session.createCriteria(StoreItemBatchStock.class)
					.add(Restrictions.eq("Item.Id", itemId)).add(Restrictions.eq("Hospital.Id", hospitalId)).add(Restrictions.gt("ClosingStock", new BigDecimal(0.0)));// add javed khan
					batchList = c3.list();
				}

				map.put("brandList", brandList);
				map.put("itemList", itemList);
				map.put("batchList", batchList);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return map;
	}

	@Override
	public Map addBrandDetailsForEquipLoanOut(Box box) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		if (box.get("deptId") != null) {
			deptId = Integer.parseInt("" + box.get("deptId"));
		}
		if (box.get("hospitalId") != null) {
			hospitalId = Integer.parseInt("" + box.get("hospitalId"));
		}
		if (box.get("userName") != null) {
			userName = ("" + box.get("userName"));
		}
		Map map = new HashMap();
		int itemId = 0;
		int detailId = 0;
		int itemIssuedIdArray[] = null;
		String qtyIssuedTempArray[] = null;
		//List<StoreIssueT> storeIssueTList = new ArrayList<StoreIssueT>();
		String successfullyAdded = "n";
		int issueId = 0;
		//List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		int storeFyId = 0;
		session = (Session) getSession();
		Transaction tx = null;

		try {
			// --------------Transaction Started----------
			tx = session.beginTransaction();

			//Vector brandId = box.getVector(RequestConstants.BRAND_ID);
			Vector qtyIssued = box.getVector(QTY_ISSUED);
			Vector Item_id = box.getVector(RequestConstants.ITEM_ID);
			Vector batchId = box.getVector(RequestConstants.BATCH_ID);
			Vector batchNo = box.getVector(RequestConstants.BATCH_NO);
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			String issueNo = "" + box.get("issueNo");
			issueId = Integer.parseInt("" + box.get("issueId"));
			int departmentIdTemp = Integer.parseInt(""
					+ box.get("issuedTo"));
			//StoreIssueM storeIssueM = new StoreIssueM();

			StoreLoanOutM storeIssueM = new StoreLoanOutM ();


			if (issueId == 0) {
				storeIssueM.setIssueType("l");
				storeIssueM.setIssueNo(box.get("issueNo"));
				SimpleDateFormat formatterIn = new SimpleDateFormat(
				"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
				"yyyy-MM-dd");
				String dd = "" + box.get("issueDate");
				String date4MySQL ="";
				try {
					date4MySQL = formatterOut.format(formatterIn.parse(dd));
				} catch (java.text.ParseException e) {

					e.printStackTrace();
				}
				java.sql.Date issueDate = java.sql.Date.valueOf(date4MySQL);
				storeIssueM.setIssueDate(issueDate);
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(deptId);
				storeIssueM.setDepartment(masDepartment);
				
				MasDepartment masDepartment2 = new MasDepartment();
				masDepartment2.setId(Integer.parseInt(""
						+ box.get("issuedTo")));
				storeIssueM.setToStore(masDepartment2);
				storeIssueM.setRequestNo(null);
				storeIssueM.setRequestDate(null);

				/*MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(Integer.parseInt("" + box.get("requestBy")));
				storeIssueM.setRequestBy(masEmployee);*/
				MasEmployee masEmployee2 = new MasEmployee();
				masEmployee2.setId(Integer.parseInt("" + box.get("issuedBy")));
				storeIssueM.setIssuedBy(masEmployee2);
				MasEmployee masEmployee3 = new MasEmployee();
				//masEmployee3
				//.setId(Integer.parseInt("" + box.get("approvedBy")));
				masEmployee3
				.setId(Integer.parseInt("" + box.get("issuedBy")));
				storeIssueM.setApprovedBy(masEmployee3);
				storeIssueM.setStatus("l");
				//storeIssueM.setDocNo(box.get("docNo"));
				storeIssueM.setToUnit(null);
				storeIssueM.setToDepot(null);
				MasHospital masHospital = new MasHospital();
				masHospital.setId(Integer.parseInt("" + box.get("hospitalId")));
				storeIssueM.setHospital(masHospital);
				storeIssueM.setLastChgBy(box.get("changed_by"));
				storeIssueM.setLastChgDate(issueDate);

				storeIssueM.setLastChgTime(box.get("changed_time"));
				if ((box.get("patientName") != null)
						&& (!box.get("patientName").equals(""))) {
					String qry = "SELECT hin_id FROM patient where hin_no='"
						+ box.get("patientName") + "'";
					List listForHin = (List) session.createSQLQuery(qry).list();
					Integer hinId = (Integer) listForHin.get(0);
					Patient hin = new Patient();
					hin.setId(hinId);
					storeIssueM.setHin(hin);
				} else {
					storeIssueM.setHin(null);
				}
				hbt.save(storeIssueM);
				hbt.refresh(storeIssueM);

				//tx.commit();
			} else {
				storeIssueM.setId(issueId);
			}
			int count = Integer.parseInt(""+box.get("count"));
			//for (int i = 0; i < brandId.size(); i++) {
			for(int i = 0; i < qtyIssued.size(); i++) {
				if ( qtyIssued.get(i) != null  && !qtyIssued.get(i).equals("")) {
					if(Integer.parseInt("" + qtyIssued.get(i)) != 0 ){
						//StoreIssueT storeIssueT = new StoreIssueT();
						StoreLoanOutT storeIssueT = new StoreLoanOutT();
						BigDecimal costprice = null;
						/*if ((new BigDecimal("" + costPrice.get(i))) != (new BigDecimal(
							"0"))) {
						costprice = new BigDecimal("" + costPrice.get(i));
					} else {*/
						costprice = new BigDecimal("0");
						//}

						MasStoreItem masStoreItem = new MasStoreItem();
						//masStoreItem.setId(Integer.parseInt("" + box.get("itemId")));
						masStoreItem.setId(Integer.parseInt("" + Item_id.get(i)));
						storeIssueT.setItem(masStoreItem);
						storeIssueT.setQtyRequest(new BigDecimal(0));
						storeIssueT.setItem(masStoreItem);
						storeIssueT.setBatchNo("" + batchNo.get(i));

						storeIssueT.setCostPrice(new BigDecimal("" + costprice));

						storeIssueT.setQtyIssued(new BigDecimal(""
								+ qtyIssued.get(i)));
						storeIssueT.setRemarks(box.get("remarks"));
						storeIssueT.setItemOrder("2");
						/*SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
						SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
						String date4MySQL ="";
						try {
							date4MySQL = formatterOut.format(formatterIn
									.parse(null);
						} catch (ParseException e2) {

							e2.printStackTrace();
						}
						Date expDateT = java.sql.Date.valueOf(date4MySQL);
						try {
							storeIssueT.setExpiryDate(expDateT);
						} catch (Exception e) {
							storeIssueT.setExpiryDate(null);
						}

						MasStoreBrand brand = new MasStoreBrand();
						if(!brandId.get(i).equals("") && brandId.get(i) != null){
							brand.setId(Integer.parseInt("" + brandId.get(i)));
						}else{
							brand.setId(Integer.parseInt("3982"));
						}
						storeIssueT.setBrand(brand);*/

						StoreItemBatchStock stock1 = new StoreItemBatchStock();
						if(!batchId.get(i).equals("") && batchId.get(i) != null){
							//brand.setId(Integer.parseInt("" + brandId
							stock1.setId(Integer.parseInt("" + batchId.get(i)));
						}else{
							stock1.setId(Integer.parseInt("3982"));
						}
						storeIssueT.setBatchStock(stock1);

						/*if (("" + remarks.get(i)).equals("emptyString")) {
						storeIssueT.setRemarks(null);
					} else {
						storeIssueT.setRemarks("" + remarks.get(i));
					}*/

						storeIssueT.setIssueM(storeIssueM);
						storeIssueT.setSrNo(0);
						storeIssueT.setIssued("y");
						storeIssueT.setItemIssued(masStoreItem);
						hbt.save(storeIssueT);
						hbt.refresh(storeIssueT);

						// -Start of Stock Updating--------------------------
						BigDecimal stock = null;
						BigDecimal loanOutQty = null;
						/*String qry3 = "select closing_stock,loan_out_qty from store_item_batch_stock as a where a.brand_id='"
							+ brandId.get(i)
							+ "'and a.department_id='"
							+ deptId
							+ "'and a.batch_no='"
							+ batchNo.get(i)
							+ "'and a.cost_price='" + costprice + "';";*/
						String qry3 = "select closing_stock,loan_out_qty from store_item_batch_stock  a where a.department_id='"
							+ deptId
							+ "'and a.item_id='"
							+Integer.parseInt("" + Item_id.get(i))
							+ "'and a.batch_no='"
							+ batchNo.get(i)+"'";
						List c2 = (List) session.createSQLQuery(qry3).list();
						
						Object[] object = (Object[]) c2.get(0);
						if (object[0] == null) {
							stock = new BigDecimal("0");
						} else {
							stock = (BigDecimal) object[0];
						}
						if (object[1] == null) {
							loanOutQty = new BigDecimal("0");
						} else {
							loanOutQty = (BigDecimal) object[1];
						}

						/*String hql2 = "update from jkt.hms.masters.business.StoreItemBatchStock  as a set a.ClosingStock='"
							+ stock.subtract(new BigDecimal(""
									+ qtyIssued.get(i)))
							+ "'  where a.Brand.Id='"
							+ brandId.get(i)
							+ "'and a.Department.Id='"
							+ deptId
							+ "'and a.BatchNo='"
							+ batchNo.get(i)
							+ "'and a.CostPrice='" + costprice + "'";*/
						/*String hql2 = "update from jkt.hms.masters.business.StoreItemBatchStock  as a set a.ClosingStock='"
							+ stock.subtract(new BigDecimal(""
									+ qtyIssued.get(i)))
									+ "'  where a.Department.Id='"
									+ deptId
									+ "'and a.Item.Id='"
									+Integer.parseInt("" + Item_id.get(i))
									+ "'and a.BatchNo='"
									+ batchNo.get(i)+"'";*/

						/*String hql3 = "update from jkt.hms.masters.business.StoreItemBatchStock  as a set a.LoanOutQty='"
							+ loanOutQty.add(new BigDecimal(""
									+ qtyIssued.get(i)))
							+ "'  where a.Brand.Id='"
							+ brandId.get(i)
							+ "'and a.Department.Id='"
							+ deptId
							+ "'and a.BatchNo='"
							+ batchNo.get(i)
							+ "'and a.CostPrice='" + costprice + "'";*/
					/*	String hql3 = "update from jkt.hms.masters.business.StoreItemBatchStock  as a set a.LoanOutQty='"
							+ loanOutQty.add(new BigDecimal(""
									+ qtyIssued.get(i)))
									+ "'  where a.Department.Id='"
									+ deptId
									+ "'and a.Item.Id='"
									+Integer.parseInt("" + Item_id.get(i))
									+ "'and a.BatchNo='"
									+ batchNo.get(i)+"'";*/


						BigDecimal stockdis = null;
						BigDecimal loanInQtydis= null;
						String qry4 = "select closing_stock,loan_in_qty from store_item_batch_stock  a where a.department_id='"
							+ departmentIdTemp
							+ "'and a.item_id='"
							+Integer.parseInt("" + Item_id.get(i))
							+ "'and a.batch_no='"
							+ batchNo.get(i)+"'";
						List c4 = (List) session.createSQLQuery(qry4).list();
						
						if(c4.size()>0){
							Object[] object1 = (Object[]) c4.get(0);
							if (object1[0] == null) {
								stockdis  = new BigDecimal("0");
							} else {
								stockdis  = (BigDecimal) object1[0];
							}
							if (object1[1] == null) {
								loanInQtydis = new BigDecimal("0");
							} else {
								loanInQtydis = (BigDecimal) object1[1];
							}

							if(!stockdis.equals("0.0")){
								String hql4 = "update from jkt.hms.masters.business.StoreItemBatchStock  as a set a.ClosingStock='"
									+ stockdis.add(new BigDecimal(""
											+ qtyIssued.get(i)))
											+ "'  where a.Department.Id='"
											+ departmentIdTemp
											+ "'and a.Item.Id='"
											+Integer.parseInt("" + Item_id.get(i))
											+ "'and a.BatchNo='"
											+ batchNo.get(i)+"'";
								Query query4 = session.createQuery(hql4);
								int row4 = query4.executeUpdate();
							}
						}else{
							StoreItemBatchStock sibs= new StoreItemBatchStock();
							MasStoreItem masStoreItem1 = new MasStoreItem();
							//masStoreItem1.setId(Integer.parseInt("" + box.get("itemId")));

							masStoreItem1.setId(Integer.parseInt("" + Item_id.get(i)));
							sibs.setItem(masStoreItem1);
							sibs.setBatchNo("" + batchNo.get(i));
							MasDepartment masDepartment3 = new MasDepartment();
							masDepartment3.setId(Integer.parseInt(""
									+ box.get("issuedTo")));
							sibs.setDepartment(masDepartment3);


							// add javed khan hospitalId
							MasHospital masHospital = new MasHospital();
							masHospital.setId(hospitalId);
							sibs.setHospital(masHospital);


							hbt.save(sibs);
							hbt.refresh(sibs);

						}
/*
						Query query2 = session.createQuery(hql2);
						int row2 = query2.executeUpdate();
						Query query3 = session.createQuery(hql3);*/
						//int row3 = query3.executeUpdate();
					}
				}
			}

			/*String qry = "select id from store_issue_m where issue_no='"
					+ issueNo + "' and issue_type='l' and department_id='"
					+ deptId + "' and to_store='" + departmentIdTemp + "';";
			List objectList = (List) session.createSQLQuery(qry).list();
			issueId = Integer.parseInt("" + objectList.get(0));*/

			/*Criteria c = session.createCriteria(StoreFyDocumentNo.class).add(
					Restrictions.eq("Department.Id", deptId)).add(
							Restrictions.eq("Hospital.Id", hospitalId));
			storeFyDocumentNoList = c.list();
			for (StoreFyDocumentNo documentNo : storeFyDocumentNoList) {
				storeFyId = documentNo.getId();
			}
			StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) getHibernateTemplate()
			.load(StoreFyDocumentNo.class, storeFyId);
			storeFyDocumentNo.setIssueLoanoutNo(issueNo);
			hbt.update(storeFyDocumentNo);*/
			// --------------Transaction End----------
			tx.commit();

			successfullyAdded = "y";


		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			//tx.commit();
			e.printStackTrace();
		} finally {
			// //session.close();
		}



		// --------------Transaction End----------

		map.put("successfullyAdded", successfullyAdded);
		map.put("issueId", issueId);
		return map;
	}


	public List<StoreBosM> printBOSJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<StoreBosM> storeBosMList = session.createCriteria(
				StoreBosM.class).addOrder(Order.desc("BosNo"))
				.list();
		map.put("storeBosMList", storeBosMList);
		return storeBosMList;
	
	}
	

	public Map searchEquipmentLoanOut(Box box) {
		int issueId = 0;
		int deptId = 0;
		String deptName = "";
		List<StoreIssueM> searchListForPopup = new ArrayList<StoreIssueM>();
		List<StoreIssueT> storeIssueTList = new ArrayList<StoreIssueT>();
		
		List<MasDepartment> departmentNameSendToJsp = new ArrayList<MasDepartment>();
		
		Map<String, Object> pageMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> valueMap = new HashMap<String, Object>();
		
		StoreIssueM issueM = new StoreIssueM();
		List<StoreIssueM> list = new ArrayList<StoreIssueM>();
		List<StoreLoanOutM> list1 = new ArrayList<StoreLoanOutM>();// javed khan
		StoreLoanOutM LoanoutExpendM = new StoreLoanOutM(); // javed khan
		List<StoreLoanOutT> storeLoanOutTList = new ArrayList<StoreLoanOutT>(); // javed khan
		deptId = Integer.parseInt("" + box.get("deptId"));
		session = (Session) getSession();
		Transaction tx = null;
		int pageNo = 1;
		String issued = "n";
		if (box.get("issueUnit") != null) {
			issueId = Integer.parseInt(box.get("issueUnit"));

		}
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
	
		list1=session.createCriteria(StoreLoanOutM.class).add(Restrictions.eq("Id", issueId)).list();
		try {
			// --------------Transaction Started----------
			tx = session.beginTransaction();


			StoreLoanOutM storeLoanOutM = (StoreLoanOutM) list1.get(0);
			valueMap.put("issueNo", storeLoanOutM.getIssueNo());


			if (storeLoanOutM.getDocNo() != null)
				valueMap.put("reference", storeLoanOutM.getDocNo());

		

			valueMap.put("departmentIdTemp", storeLoanOutM.getToStore().getId());

			//valueMap.put("requestBy", storeLoanOutM.getRequestBy().getId());
			valueMap.put("approvedBy", storeLoanOutM.getApprovedBy().getId());
			valueMap.put("issuedBy", storeLoanOutM.getIssuedBy().getId());

			try {
				box.put("issuedDate", HMSUtil
						.convertDateToStringWithoutTime(LoanoutExpendM.getIssueDate()));
			} catch (Exception e) {
				box.put("issuedDate", "");
			}
			try {
				box.put("demandDate",
						HMSUtil.convertDateToStringWithoutTime(LoanoutExpendM
								.getRequestDate()));
			} catch (Exception e) {
				box.put("demandDate", "");
			}
		
			departmentNameSendToJsp=session.createCriteria(MasDepartment.class).add(Restrictions.eq("Id", deptId)).list();
			storeIssueTList=session.createCriteria(StoreIssueT.class)
			 .createAlias("IssueM", "sim").add(Restrictions.eq("sim.Id", issueId)).list();
				
			storeLoanOutTList=session.createCriteria(StoreLoanOutT.class)
			 .createAlias("IssueM", "sim").add(Restrictions.eq("sim.Id", issueId)).list();

			 MasDepartment masDepartment = departmentNameSendToJsp.get(0);
			 deptName = masDepartment.getDepartmentName();
			 valueMap.put("deptName", deptName);
			 // --------------Transaction Ended----------
			 tx.commit();

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		}
		valueMap.put("issueId", issueId);
		valueMap.put("pageNo", pageNo);
		valueMap.put("deptId", deptId);
		valueMap.put("issue_type", "l");
		map = getIssueDetailPageByPage(valueMap);
		map.put("valueMap", valueMap);
		map.put("storeIssueTList", storeIssueTList);
		map.put("storeLoanOutTList", storeLoanOutTList); // javed khan
		return map;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> getIssueDetailPageByPage(Map<String, Object> pageMap) {
		List<StoreIssueM> searchListForPopup = new ArrayList<StoreIssueM>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		// List<StoreIssueT> issueTList=new ArrayList<StoreIssueT>();
		List<StoreIssueT> loanList = new ArrayList<StoreIssueT>(); // javed khan
		List issueTList = new ArrayList();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<StoreSetup> storeSetupList = new ArrayList<StoreSetup>();
		List stockAvailableList = new ArrayList();
		List loanOutList = new ArrayList();
		StoreSetup storeSetup = new StoreSetup();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		SimpleDateFormat formatterIn1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut1 = new SimpleDateFormat("yyyy-MM-dd");
		Map mapbatch = new HashMap(); // add javed for modify civ
		int issueId = 0;
		int pageNo = 1;
		String issued = "n";
		int deptId = 0;
		deptId = Integer.parseInt("" + pageMap.get("deptId"));
		HibernateTemplate hbt = getHibernateTemplate();
		session = (Session) getSession();
		session.flush();

		if (pageMap.get("pageNo") != null) {
			pageNo = Integer.parseInt("" + pageMap.get("pageNo"));
		}

		int firstResult = 0;
		int maxResults = 20;

		if (pageNo != 1) {
			firstResult = firstResult + (pageNo - 1) * 20;
		}

		try {
			String date4MySQL = formatterOut1.format(formatterIn1.parse(date));
			Date datestr = java.sql.Date.valueOf(date4MySQL);
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			String issueDate=sdf.format(datestr);
			//Date issueDate=dateFormatterDDMMYYYY.parse(dateate);
			if (pageMap.get("issueId") != null) {
				issueId = Integer.parseInt("" + pageMap.get("issueId"));
			}

			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			storeSetupList = session.createCriteria(StoreSetup.class).list();
			if (storeSetupList != null && storeSetupList.size() > 0) {
				storeSetup = (StoreSetup) storeSetupList.get(0);
			}

			// Hibernate Pagination
			String pvmsSearch = "";
			String query="";
			if (pageMap.get("pvmsSearch") != null
					&& !((String) pageMap.get("pvmsSearch")).equals(""))
			{
				pvmsSearch = "%" + (String) pageMap.get("pvmsSearch") + "%";
				map.put("pvmsNo1", pvmsSearch);
				// String query = " select b.item_id, i.pvms_no, i.nomenclature,
				// d.unit_name,a.department_id, a.id, b.id, max(b.qty_request),
				// sum(b.qty_issued) from store_issue_m a, store_issue_t
				// b,mas_store_item i, mas_store_item_conversion c,
				// mas_store_unit d where i.item_conversion_id =
				// c.item_conversion_id and c.purchase_unit_id = d.unit_id and
				// b.item_id=i.item_id and a.id = b.issue_m_id and b.issue_m_id
				// = " + issueId + " and (i.pvms_no like '" + pvmsSearch + "' or
				// i.nomenclature like '" + pvmsSearch + "') group by
				// b.item_id";
				// add b.CIV_LOAN by javed khan
				query = " select b.item_id, i.pvms_no, i.nomenclature, d.unit_name,a.department_id, a.id as id1,   b.id, max(b.qty_request), sum(b.qty_issued),i.BRANDED_GENERIC,b.BATCH_NO,b.CIV_LOAN from store_issue_m a, store_issue_t b,mas_store_item i, mas_store_item_conversion c, mas_store_unit d " +
				"where i.item_conversion_id = c.item_conversion_id and c.purchase_unit_id = d.unit_id and b.item_id=i.item_id and a.id = b.issue_m_id and b.issue_m_id = "
				+ issueId
				+ " and i.pvms_no like '"
				+ pvmsSearch
				+ "' group by b.item_id, i.pvms_no, i.nomenclature, d.unit_name,a.department_id, a.id,   b.id ,i.BRANDED_GENERIC,b.BATCH_NO, b.CIV_LOAN";
				issueTList = session.createSQLQuery(query).setFirstResult(firstResult).setMaxResults(maxResults).list();
			}
			else
			{
				// add b.CIV_LOAN by javed khan
				query = "select b.item_id, i.pvms_no, i.nomenclature, d.unit_name,a.department_id, a.id as id1,   b.id , b.expiry_date, max(b.qty_request), sum(b.qty_issued),i.BRANDED_GENERIC,b.BATCH_NO, b.CIV_LOAN  from store_issue_m a, store_issue_t b,mas_store_item i, mas_store_item_conversion c, mas_store_unit d where i.item_conversion_id = c.item_conversion_id and c.purchase_unit_id = d.unit_id  and b.item_id=i.item_id and a.id = b.issue_m_id and b.issue_m_id  = "
					+ issueId + " group by b.item_id, i.pvms_no, i.nomenclature, d.unit_name,a.department_id, a.id,   b.id, b.expiry_date,i.BRANDED_GENERIC,b.BATCH_NO ,b.CIV_LOAN";
				issueTList = session.createSQLQuery(query).setFirstResult(firstResult).setMaxResults(maxResults).list();


			}
			employeeList = session.createCriteria(MasEmployee.class).list();
			departmentList = session.createCriteria(MasDepartment.class).list();


			// javed for batch by issue
			List BatchList = new ArrayList();

			for(int k=0; k<issueTList.size();k++){
				Object[] object=(Object[])issueTList.get(k);
				String query123="select sibs.BATCH_NO from store_item_batch_stock sibs where sibs.ITEM_ID="+object[0]+"and sibs.CLOSING_STOCK>0 and sibs.DEPARTMENT_ID="+deptId+" group by sibs.BATCH_NO";
				BatchList=session.createSQLQuery(query123).list();
				mapbatch.put(object[0],BatchList);

			}


			if (pageMap.get("issue_type") != null
					&& pageMap.get("issue_type").toString().equals("l")) {
				searchListForPopup = session.createCriteria(StoreIssueM.class)
				.add(Restrictions.eq("Department.Id", deptId)).add(
						Restrictions.eq("Status", "o")).add(
								Restrictions.eq("IssueType", "l")).list();
			} else {
				searchListForPopup = session.createCriteria(StoreIssueM.class)
				.add(Restrictions.eq("Department.Id", deptId)).add(
						Restrictions.eq("IssueType", "i")).list();
			}
			// Get Loan Out Details
			List stockList = new ArrayList();
			List loanOutQtyList = new ArrayList();
			List objectList = new ArrayList();

			for (Iterator iterator = issueTList.iterator(); iterator.hasNext();) {
				Object[] object = (Object[]) iterator.next();
				String str = "";
				if (pageMap.get("issue_type") != null
						&& pageMap.get("issue_type").toString().equals("l")) {
					str = "select sum(b.qty_issued) from store_issue_m a, store_issue_t b,mas_store_item i where b.item_id=i.item_id and a.id = b.issue_m_id and a.status='o' and  a.issue_type='l' and b.item_order=2 and b.item_issued = '"
						+ object[0] + "' order by i.pvms_no ";
				} else {
					str = "select sum(b.qty_issued) from store_issue_m a, store_issue_t b,mas_store_item i where b.item_id=i.item_id and a.id = b.issue_m_id and a.status='o' and  a.issue_type='i' and b.item_order=2 and b.item_issued = '"
						+ object[0] + "' order by i.pvms_no ";
				}
				objectList = session.createSQLQuery(str).list();
				if (objectList.get(0) != null)
					map.put(object[0].toString(), objectList.get(0).toString());
				else
					map.put(object[0].toString(), "0");

				int itemId = Integer.parseInt(object[0].toString());
				int departmentId = Integer.parseInt(object[4].toString());
				int issueMId = Integer.parseInt(object[5].toString());

				BigDecimal stock = null;
				BigDecimal loanOutQty = null;
				String str3 = "select sum(nvl(a.closing_stock,0)) from store_item_batch_stock a,mas_store_item i " +
				" where a.item_id=i.item_id and a.item_id = '"
				+ itemId
				+ "' and a.department_id='"
				+ departmentId
				+ "' and a.expiry_date > '"
				+ issueDate
				+ "' group by a.item_id ";

				stockAvailableList = session.createSQLQuery(str3).list();

				String str1 = "select sum(a.qty_issued) from store_issue_t a,mas_store_item i " +
				"where a.item_id=i.item_id and a.item_id = '"
				+ itemId
				+ "' and a.issue_m_id='"
				+ issueMId
				+ "' and a.item_order='"
				+ 2
				+ "' group by a.item_id";

				loanOutList = session.createSQLQuery(str1).list();

				if (stockAvailableList.size() > 0
						&& stockAvailableList.get(0) != null) {
					stock = (BigDecimal) stockAvailableList.get(0);
				} else {
					stock = new BigDecimal("0");
				}

				if (loanOutList.size() > 0 && loanOutList.get(0) != null) {
					loanOutQty = (BigDecimal) loanOutList.get(0);
				} else {
					loanOutQty = new BigDecimal("0");
				}
				stockList.add(stock);
				loanOutQtyList.add(loanOutQty);
			}
			// for complete stock list

			int totalPages = 0;
			double totalPage = 0.0;
			if (pageMap.get("pvmsSearch") != null
					&& !((String) pageMap.get("pvmsSearch")).equals("")) {

				String str1 = "select count(*) from store_issue_t a,store_issue_m b,mas_store_item i  where a.item_id=i.item_id and  a.issue_m_id=b.id and a.issue_m_id='"
					+ issueId
					+ "' and i.pvms_no like '"
					+ pvmsSearch
					+ "'	";
				List countList = session.createSQLQuery(str1).list();
				if (countList != null && countList.size() > 0) {
					totalPage = (double) countList.size() / (double) 20;
					Double d = new Double(Math.ceil(totalPage));
					totalPages = d.intValue();
				}
			} else {
				String str1 = "select count(*) from store_issue_t a,store_issue_m b  where a.issue_m_id=b.id and a.issue_m_id='"
					+ issueId + "' group by a.item_id";
				List countList = session.createSQLQuery(str1).list();
				if (countList != null && countList.size() > 0) {
					totalPage = (double) countList.size() / (double) 20;
					Double d = new Double(Math.ceil(totalPage));
					totalPages = d.intValue();
				}
			}

			/*
			 * Map<String,Object> utilMap = new HashMap<String,Object>();
			 * utilMap = (Map)HMSUtil.getCurrentDateAndTime(); String date11 =
			 * (String)utilMap.get("currentDate");
			 */
			try {

				List<StoreIssueM> storeIssueMList1 = new ArrayList<StoreIssueM>();
				storeIssueMList1 = session.createCriteria(StoreIssueM.class)
				.add(Restrictions.eq("Id", issueId)).list();
				StoreIssueM storeIssueM = new StoreIssueM();
				String issueMStatus = "";
				if (storeIssueMList1.size() > 0 && storeIssueMList1 != null) {
					storeIssueM = storeIssueMList1.get(0);
					issueMStatus = storeIssueM.getStatus();
					map.put("issueMStatus", issueMStatus);
					map.put("departmentIdTemp", storeIssueM.getToStore()
							.getId());

				}
				SimpleDateFormat formatterIn = new SimpleDateFormat(
				"yyyy-MM-dd");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
				"dd/MM/yyyy");

				if (storeIssueM.getIssueDate() != null) {
					String date4MySQL1 = formatterOut.format(storeIssueM
							.getIssueDate());
					map.put("issueDate", date4MySQL1);
				} else {
					map.put("requestDate", date);
				}

				if (storeIssueM.getRequestDate() != null) {
					String requestedDate4MySQL = formatterOut
					.format(storeIssueM.getRequestDate());
					map.put("requestDate", requestedDate4MySQL);
				} else
					map.put("requestDate", date);

				List<StoreInternalIndentM> storeInternalIndentMList = new ArrayList<StoreInternalIndentM>();
				storeInternalIndentMList = session.createCriteria(
						StoreInternalIndentM.class).add(
								Restrictions.eq("ToStore.Id", deptId)).list();

				if (storeInternalIndentMList != null
						&& storeInternalIndentMList.size() > 0) {
					map.put("storeInternalIndentMList",
							storeInternalIndentMList);
					if (storeIssueM.getRequestNo() != null)
						map
						.put("requestNo", storeIssueM.getRequestNo()
								.getId());
				}

				loanList = session.createCriteria(StoreIssueT.class).add(Restrictions.eq("CivLoan", "Loan"))
				.add(Restrictions.eq("IssueM.Id", issueId)).list();
			} catch (Exception e) {
				map.put("issueDate", date);
				map.put("requestDate", date);
				e.printStackTrace();
			}

			map.put("stockList", stockList);
			map.put("totalPages", totalPages);
			map.put("loanOutQtyList", loanOutQtyList);
			session.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("mapbatch",mapbatch);// add javed for modify civ
		map.put("searchListForPopup", searchListForPopup);
		map.put("issueTList", issueTList);
		map.put("departmentList", departmentList);
		map.put("employeeList", employeeList);
		map.put("issueId", issueId);
		map.put("storeSetup", storeSetup);
		map.put("loanList", loanList);// add javed khan
		return map;
	}
	
}
