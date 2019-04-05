package jkt.hms.FacilityManagement.dataservice;

import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.INPATIENT_ID;
import static jkt.hms.util.RequestConstants.PATIENT_NAME;
import static jkt.hms.util.RequestConstants.USER_ID;
import static jkt.hms.util.RequestConstants.SERVICE_NO;
import static jkt.hms.util.RequestConstants.PATIENT_CODE;
import static jkt.hms.util.RequestConstants.RELATION_ID;
import static jkt.hms.util.RequestConstants.CURRENT_TIME;
import static jkt.hms.util.RequestConstants.CURRENT_DATE;
import jkt.hms.masters.business.Users;

import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.registry.infomodel.User;

import jkt.hms.masters.business.BabyDetails;
import jkt.hms.masters.business.DeliveryDetails;
import jkt.hms.masters.business.EmpScMapping;
import jkt.hms.masters.business.HesEquipmentAmcDetailsEntry;
import jkt.hms.masters.business.HesEquipmentAssessories;
import jkt.hms.masters.business.HesEquipmentMaster;
import jkt.hms.masters.business.Hospital;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasAdmissionType;
import jkt.hms.masters.business.MasBed;
import jkt.hms.masters.business.MasBedStatus;
import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.MasCostCenter;
import jkt.hms.masters.business.MasDeliveryType;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasEmployeeDependent;
import jkt.hms.masters.business.MasFrequency;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasItemCategory;
import jkt.hms.masters.business.MasItemClass;
import jkt.hms.masters.business.MasItemType;
import jkt.hms.masters.business.MasManufacturer;
import jkt.hms.masters.business.MasPatientType;
import jkt.hms.masters.business.MasPriorityCodes;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasRelation;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasStoreSection;
import jkt.hms.masters.business.MasStoreSupplier;
import jkt.hms.masters.business.MasStoreSupplierType;
import jkt.hms.masters.business.MmInspectionReport;
import jkt.hms.masters.business.MmMasRequestStatus;
import jkt.hms.masters.business.MmServiceRequest;
import jkt.hms.masters.business.MortuaryDetails;
import jkt.hms.masters.business.OpdSurgeryDetail;
import jkt.hms.masters.business.OpdSurgeryHeader;
import jkt.hms.masters.business.OtBooking;
import jkt.hms.masters.business.OtPreAnesthesiaDetail;
import jkt.hms.masters.business.OtPreAnesthesiaHd;
import jkt.hms.masters.business.PacsTemplate;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PatientPrescriptionDetails;
import jkt.hms.masters.business.PatientPrescriptionHeader;
import jkt.hms.masters.business.PrqAssetDetails;
import jkt.hms.masters.business.StoreItemBatchStock;
import jkt.hms.masters.business.StoreOpPatientIssueM;
import jkt.hms.masters.business.StoreOpPatientIssueT;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.masters.business.Transfer;
import jkt.hms.masters.business.Visit;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lowagie.text.pdf.codec.postscript.ParseException;


public class FacilityManagementDataServiceImpl extends HibernateDaoSupport implements FacilityManagementDataService {
	
	public Map<String, Object> showPendingListForEnterEquipmentDetailJsp(
			Box box, Map<String, Object> dataMap) {
		Map<String, Object> map=new HashMap<String, Object>();
		/*List<StoreGrnT> storeGrnT=new ArrayList<StoreGrnT>();*/
		List<StoreItemBatchStock> batchStockList=new ArrayList<StoreItemBatchStock>();
		List<MasDepartment> masDepartments=new ArrayList<MasDepartment>();
		List<MasManufacturer> masManufacturers=new ArrayList<MasManufacturer>();
	/*	List<MasDepartment> instituteDepartments=new ArrayList<MasDepartment>();*/
		List<PrqAssetDetails> assetDetails=new ArrayList<PrqAssetDetails>();
	/*	SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");*/
		String[] equipmentCode=null;
		Session session = (Session)getSession();
	/*	URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("maintenance.properties");*/
		try {
			//java.util.Properties prop = new java.util.Properties();
			//prop.load(new FileInputStream(new File(resourcePath.getFile())));
			equipmentCode = HMSUtil.getProperties("adt.properties", "ItemTypeCodeForAsset") .split("#");
		} catch (Exception e) {
			  e.printStackTrace();
		}
		
/*		if(box.getInt("itemId") != 0){
			Criteria cr1=
					getSession().createCriteria(StoreItemBatchStock.class,"sgt")
					.createAlias("sgt.Item", "i").add(Restrictions.eq("i.Id", box.getInt("itemId")))
					.createAlias("i.ItemType", "it")
					.add(Restrictions.in("it.ItemTypeCode", equipmentCode))
					//.add(Restrictions.isNull("EquipmentDetailStatus"))
					.add(Restrictions.eq("Hospital.Id", (Integer)dataMap.get("hospitalId")));
			batchStockList=cr1.list();
		}else{*/
			Criteria cr1=
					session.createCriteria(StoreItemBatchStock.class)
					.createAlias("Item", "i")
					.createAlias("i.ItemType", "it")
					.add(Restrictions.in("it.ItemTypeCode", equipmentCode))
					.add(Restrictions.isNull("EquipmentDetailStatus"))
					.add(Restrictions.eq("Hospital.Id", (Integer)dataMap.get("hospitalId")));
			batchStockList=cr1.list();	
			
		/*}*/
		
		
		/*Criteria cr=
				getSession().createCriteria(StoreGrnT.class,"sgt").createAlias("sgt.GrnMaster", "sgm")
				.createAlias("sgt.Item", "i")
				.createAlias("sgm.Hospital", "h")
				.createAlias("i.ItemType", "it")
				.add(Restrictions.in("it.ItemTypeCode", equipmentCode));
		Criteria cr1=
				getSession().createCriteria(StoreItemBatchStock.class,"sgt")
				.createAlias("sgt.Item", "i")
				.createAlias("i.ItemType", "it")
				.add(Restrictions.in("it.ItemTypeCode", equipmentCode))
				.add(Restrictions.eq("Hospital.Id", (Integer)dataMap.get("hospitalId")));
		Criteria department=getSession().createCriteria(MasInstituteDepartment.class, "mid");
		Criteria manufacturer=getSession().createCriteria(MasManufacturer.class, "m");
		
		if(dataMap.get("hospitalId")!=null){
			cr=cr.add(Restrictions.eq("h.Id", (Integer)dataMap.get("hospitalId")));
			department=department.createAlias("mid.Institute", "h").add(Restrictions.eq("h.Id", (Integer)dataMap.get("hospitalId")));
		}
		if(box.getString("grnDate")!=null && box.getString("grnDate")!=""){
			try{
			cr=cr.add(Restrictions.eq("sgm.GrnDate", sdf.parse(box.getString("grnDate"))));
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		if(box.getString("grnNo")!=null && box.getString("grnNo")!=""){
			cr=cr.add(Restrictions.eq("sgm.GrnNo", box.getString("grnNo")));
		}
		if(box.getString("requestId")!=null && box.getString("requestId")!=""){
			cr=cr.add(Restrictions.eq("sgt.Id", box.getInt("requestId")));
		}
		if(box.getString("equipmentName")!=null && box.getString("equipmentName")!=""){
			cr=cr.add(Restrictions.like("i.Nomenclature", box.getString("equipmentName")));
		}
		storeGrnT=cr.add(Restrictions.or(Restrictions.ltProperty("sgt.EqpDetailQty", "sgt.ReceivedQty"), Restrictions.isNull("sgt.EqpDetailQty"))).list();
		masDepartments=department.createAlias("Department", "d").list();
		System.out.println("maslist"+masDepartments.size());
		System.out.println("maslist+++"+storeGrnT.size());
		System.out.println("maslist+++"+masManufacturers.size());
		masManufacturers=manufacturer.addOrder(Order.asc("m.ManufacturerName")).list();
		Criteria criteria1=(Criteria) getSession().createCriteria(PrqAssetDetails.class)
				              .createAlias("Item", "item").add(Restrictions.eq("item.Id", box.getInt("itemId")));
		assetDetails=criteria1.list();
		batchStocks=cr1.list();*/
		
		//masDepartments=session.createCriteria(MasDepartment.class).addOrder(Order.asc("DepartmentName")).list();
		//masDepartments=department.createAlias("Department", "d").list();
		
		/*Criteria manufacturer=getSession().createCriteria(MasManufacturer.class, "m");
		masManufacturers=  manufacturer.addOrder(Order.asc("m.ManufacturerName")).list();*/
		
		//masManufacturers=session.createCriteria(MasManufacturer.class).addOrder(Order.asc("ManufacturerName")).list();
		
		
	/*	assetDetails =session.createCriteria(PrqAssetDetails.class)
				              .createAlias("Item", "item").add(Restrictions.eq("item.Id", box.getInt("itemId")))
				              .list();*/
		
	
		map.put("batchStockList", batchStockList);
    	//map.put("assetDetails", assetDetails);
		//map.put("masDepartments", masDepartments);
		//map.put("masManufacturers", masManufacturers);
		return map;
	}

	@Override
	public Map<String, Object> showEquipmentDetailJsp(Map<String, Object> dataMap)
			 {
		Box box = (Box) dataMap.get("box");
		Map<String, Object> map=new HashMap<String, Object>();
		List<StoreItemBatchStock> batchStockList=new ArrayList<StoreItemBatchStock>();
		List<MasDepartment> masDepartments=new ArrayList<MasDepartment>();
		List<MasManufacturer> masManufacturers=new ArrayList<MasManufacturer>();
	//	List<MasInstituteDepartment> instituteDepartments=new ArrayList<MasInstituteDepartment>();
		List<PrqAssetDetails> assetDetails=new ArrayList<PrqAssetDetails>();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		String[] equipmentCode=null;
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("maintenance.properties");
		try {
			equipmentCode = 		 HMSUtil.getProperties("adt.properties", "ItemTypeCodeForAsset") .split("#");;
		} catch (Exception e) {
			e.printStackTrace();
		}
		Session session = (Session)getSession();
		batchStockList = session.createCriteria(StoreItemBatchStock.class)
							.createAlias("Item", "i")
							.createAlias("i.ItemType", "it")
							.add(Restrictions.in("it.ItemTypeCode", equipmentCode)).add(Restrictions.eq("Id", box.getInt("batchStockId")))
							//.add(Restrictions.isNull("EquipmentDetailStatus"))
							.add(Restrictions.eq("Hospital.Id", (Integer)dataMap.get("hospitalId"))).list();
	//	Criteria department=getSession().createCriteria(MasInstituteDepartment.class, "mid");
		/*masDepartments=department.createAlias("Department", "d").list();*/ // commented by amit das on 02-09-2016
		
		/*masDepartments=department.createAlias("Department", "d")
				.createAlias("Institute", "i").setProjection(Projections.distinct(Projections.property("mid.Department")))
				.add(Restrictions.eq("i.Id", (Integer)dataMap.get("hospitalId"))).list(); // added by amit das on 02-09-2016
				
				
*/		
		
		masDepartments = session.createCriteria(MasDepartment.class)
						.add(Restrictions.eq("Hospital.Id", (Integer)dataMap.get("hospitalId")))
						.list();
		
		Criteria manufacturer=getSession().createCriteria(MasManufacturer.class, "m");
		masManufacturers=manufacturer.addOrder(Order.asc("m.ManufacturerName")).list();
		
		Criteria criteria1=(Criteria) getSession().createCriteria(PrqAssetDetails.class)
				              .createAlias("Item", "item").add(Restrictions.eq("item.Id", box.getInt("itemId")));
		assetDetails=criteria1.list();
	
		map.put("batchStockList", batchStockList);
		map.put("assetDetails", assetDetails);
		map.put("masDepartments", masDepartments);
		map.put("masManufacturers", masManufacturers);
		return map;
	}
	
	public Map<String, Object> submitEquipmentDetails(
			Map<String, Object> dataMap) {
		Map<String, Object> map=new HashMap<String, Object>();
		Box box = (Box) dataMap.get("box");
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		List<MmMasRequestStatus> mmMasRequestStatus=new ArrayList<MmMasRequestStatus>();
		HesEquipmentMaster hesEquipmentMaster=null;
		MasDepartment masDepartment=null;
		MasManufacturer masManufacturer=null;
		MasStoreItem storeItem=null;
		/*StoreGrnT storeGrnT=null;*/
		MasHospital hospital=null;
		Users user=null;
		String status="Yes";
		String message="";
		int itemCount=box.getInt("itemCount");
		Transaction tx=null;
		if(itemCount>0){
		try{
				tx=getSession().beginTransaction();
			for(int i=1;i<=itemCount;i++){
				hesEquipmentMaster=new HesEquipmentMaster();
				if(box.getString("department"+i)!=null && box.getString("department"+i)!=""){
					masDepartment=new MasDepartment();
					masDepartment.setId(box.getInt("department"+i));
					hesEquipmentMaster.setDepartment(masDepartment);
				}
				if(box.getString("modelNumber"+i)!=null && box.getString("modelNumber"+i)!=""){
					hesEquipmentMaster.setModelName(box.getString("modelNumber"+i));
				}
				if(box.getString("serialNumber"+i)!=null && box.getString("serialNumber"+i)!=""){
					hesEquipmentMaster.setSerialNo(box.getString("serialNumber"+i));
				}
				if(box.getString("Depreciation"+i)!=null && box.getString("Depreciation"+i)!=""){
					hesEquipmentMaster.setDepreciation(box.getInt("Depreciation"+i));
				}
				if(box.getString("make"+i)!=null && box.getString("make"+i)!=""){
					hesEquipmentMaster.setMake(box.getString("make"+i));
				}
				if(box.getString("manufacture"+i)!=null && box.getString("manufacture"+i)!=""){
					masManufacturer=new MasManufacturer();
					masManufacturer.setId(box.getInt("manufacture"+i));
					hesEquipmentMaster.setManufacturer(masManufacturer);;
				}
				if(box.getString("technicalSpecification"+i)!=null && box.getString("technicalSpecification"+i)!=""){
					hesEquipmentMaster.setTechnicalSpecifications(box.getString("technicalSpecification"+i));
				}
				if(box.getString("itemId")!=null && box.getString("itemId")!=""){
					storeItem=new MasStoreItem();
					storeItem.setId(box.getInt("itemId"));
					hesEquipmentMaster.setItem(storeItem);
				}
				/*if(box.getString("storeGrnId")!=null && box.getString("storeGrnId")!=""){
					storeGrnT=(StoreGrnT)hbt.get(StoreGrnT.class, box.getInt("storeGrnId"));
//					storeGrnT.setId(box.getInt("grnId"));
					hesEquipmentMaster.setGrnT(storeGrnT);
					if(storeGrnT.getEqpDetailQty()!=null)
					{
						storeGrnT.setEqpDetailQty(storeGrnT.getEqpDetailQty().add(new BigDecimal(1)));
					}
					else
					{
						storeGrnT.setEqpDetailQty(new BigDecimal(1));
					}
				}*/
				if(box.getInt("batchStockId")!=0 ){
					StoreItemBatchStock storeItemBatchStock =(StoreItemBatchStock)hbt.load(StoreItemBatchStock.class, box.getInt("batchStockId"));
					storeItemBatchStock.setEquipmentDetailStatus("y");
					hbt.update(storeItemBatchStock);
				}
				
				if(dataMap.get("hospitalId")!=null && dataMap.get("hospitalId")!=""){
					hospital=new MasHospital();
					hospital.setId((Integer)dataMap.get("hospitalId"));
					hesEquipmentMaster.setHospital(hospital);
				}
				if(dataMap.get("userId")!=null && dataMap.get("userId")!=""){
					user=new Users();
					user.setId((Integer)dataMap.get("userId"));
					hesEquipmentMaster.setLastChgBy(user);;
				}
				if(box.getString("currentDate")!=null && box.getString("currentDate")!=""){
					hesEquipmentMaster.setLastChgDate(HMSUtil.dateFormatterDDMMYYYY(box.getString("currentDate")));
				}
				if(box.getString("currentTime")!=null && box.getString("currentTime")!=""){
					hesEquipmentMaster.setLastChgTime(box.getString("currentTime"));
				}
				if(box.getString("equipmentDetailDate")!=null && box.getString("equipmentDetailDate")!=""){
					try{
						hesEquipmentMaster.setEquipmentDetailDate(sdf.parse(box.getString("equipmentDetailDate")));
					}catch(Exception e){e.printStackTrace();}
				}
				if(box.getString("equipmentStatus"+i)!=null && box.getString("equipmentStatus"+i)!=""){
					if(box.getString("installationDate"+i)!=null && box.getString("installationDate"+i)!=""){
						try{
							hesEquipmentMaster.setDateOfInstallation(sdf.parse(box.getString("installationDate"+i)));
						}catch(Exception e){e.printStackTrace();}
					}
				}
				if(box.getString("userStatus"+i)!=null && box.getString("userStatus"+i)!=""){
					mmMasRequestStatus=getSession().createCriteria(MmMasRequestStatus.class).add(Restrictions.eq("StatusCode", "ACPT")).list();
					MmMasRequestStatus masRequestStatus=new MmMasRequestStatus();
					if(mmMasRequestStatus.size()>0){
						masRequestStatus.setId(mmMasRequestStatus.get(0).getId());
						hesEquipmentMaster.setEquipStatus(masRequestStatus);
					}
				}else{
					mmMasRequestStatus=getSession().createCriteria(MmMasRequestStatus.class).add(Restrictions.eq("StatusCode", "RJT")).list();
					MmMasRequestStatus masRequestStatus=new MmMasRequestStatus();
					if(mmMasRequestStatus.size()>0){
						masRequestStatus.setId(mmMasRequestStatus.get(0).getId());
						hesEquipmentMaster.setEquipStatus(masRequestStatus);
						if(box.getString("reson"+i)!=null && box.getString("reson"+i)!=""){
							hesEquipmentMaster.setRejectionDetail(box.getString("reson"+i));
						}
					}
				}
				if(box.getString("assetId"+i)!=null && box.getString("assetId"+i)!=""){
					PrqAssetDetails assetDetails=new PrqAssetDetails();
					assetDetails.setId(box.getInt("assetId"+i));
					hesEquipmentMaster.setAsset(assetDetails);
				}
//				---Equipment Code------
				hesEquipmentMaster.setStatus("y");
				hesEquipmentMaster.setReplacementValue(new BigDecimal(0.0));
				int equipmentId=(Integer)hbt.save(hesEquipmentMaster);
				hbt.flush();
			
				String entryNo="EQNO"+equipmentId+"/"+HMSUtil.changeDateToddMMyyyy(new Date());
//				---End-------
				hesEquipmentMaster.setId(equipmentId);
				hesEquipmentMaster.setEntryNo(entryNo);
				if(box.getString("warranty"+i)!=null && box.getString("warranty"+i)!=""){
					status="Yes";
					hesEquipmentMaster.setWarrentyStatus(status);
					String[] warrantyType=box.getString("warranty"+i).trim().split(",");
					if("1".equalsIgnoreCase(warrantyType[1])){
						hesEquipmentMaster.setWarrantyType("warranty");
					}else if("2".equalsIgnoreCase(warrantyType[1])){
						hesEquipmentMaster.setWarrantyType("camc");
					}else if("3".equalsIgnoreCase(warrantyType[1])){
						hesEquipmentMaster.setWarrantyType("cmc");
					}else if("4".equalsIgnoreCase(warrantyType[1])){
						hesEquipmentMaster.setWarrantyType("amc");
					}
//				-------	warranty details Start----------
					if(box.getString("warrantyStartDate"+i)!=null && box.getString("warrantyStartDate"+i)!=""){
						try{
							hesEquipmentMaster.setWarrentyStartDate(sdf.parse(box.getString("warrantyStartDate"+i)));
						}catch(Exception e){e.printStackTrace();}
						}
					if(box.getString("warrantyStartDate"+i)!=null && box.getString("warrantyStartDate"+i)!=""){
						try{
							
							hesEquipmentMaster.setWarrentyEndDate(sdf.parse(box.getString("warrantyEndDate"+i)));
						}catch(Exception e){e.printStackTrace();}
						}
					if(box.getString("warrantyDetails"+i)!=null && box.getString("warrantyDetails"+i)!=""){
						hesEquipmentMaster.setWarrantyDetails(box.getString("warrantyDetails"+i));
						}
//				--- Preventive Start-------	
					String preventiveStaus="No";
						if(box.getString("preventive"+i)!=null && box.getString("preventive"+i)!=""){
							preventiveStaus="Yes";
						    hesEquipmentMaster.setPreventiveStatus(preventiveStaus);
						if(box.getString("totalPreventive"+i)!=null && box.getString("totalPreventive"+i)!=""){
							hesEquipmentMaster.setPreventiveCycle(box.getInt("totalPreventive"+i));
							hesEquipmentMaster.setPreventiveCompletedCycle(0);
						}
//				------ Check List Start ------
						String checkListStatus="No";
						if(box.getString("checkList"+i)!=null && box.getString("checkList"+i)!=""){
							checkListStatus="Yes";
							hesEquipmentMaster.setChecklistStatus(checkListStatus);
					/*		if(box.getString("checkListName"+i)!=null && box.getString("checkListName"+i)!=""){
							String[] checkListName=box.getString("checkListName"+i).split("@#");
								if(checkListName.length>0){
									for(int ch=0;ch<checkListName.length;ch++){
										MmPreventiveCheckList mmPreventiveCheckList=new MmPreventiveCheckList();
										mmPreventiveCheckList.setCheckListName(checkListName[ch]);
										if(hesEquipmentMaster.getId()!=null){
										mmPreventiveCheckList.setEquipment(hesEquipmentMaster);
										}
										hbt.save(mmPreventiveCheckList);
										hbt.flush();
										hbt.clear();
									}
								}
							}*/
						}else{
							hesEquipmentMaster.setChecklistStatus(checkListStatus);
						}
//						------ Check List End ------
						
					}else{
						hesEquipmentMaster.setPreventiveStatus(preventiveStaus);
					}
//						--- Preventive End-------	
					
				}else{
					hesEquipmentMaster.setWarrentyStatus(status);
				}
//				-------	warranty details End----------
//				-------	Accessory details Start----------
				if(box.getString("accessory"+i)!=null && box.getString("accessory"+i)!=""){
					int accessoryCount=box.getInt("accessoryCount"+i);
					if(accessoryCount>0){
						for(int a=1;a<=accessoryCount;a++){
							HesEquipmentAssessories hesEquipmentAssessories=new HesEquipmentAssessories();
							MasStoreItem masStoreItem=new MasStoreItem();
							if(hesEquipmentMaster.getId()!=null){
								hesEquipmentAssessories.setEquipment(hesEquipmentMaster);
								}
							if(box.getString("accessoryItemId"+i+a)!=null && box.getString("accessoryItemId"+i+a)!=""){
								masStoreItem.setId(box.getInt("accessoryItemId"+i+a));
								hesEquipmentAssessories.setItem(masStoreItem);
							}
							if(box.getString("accessoryItemName"+i+a)!=null && box.getString("accessoryItemName"+i+a)!=""){
								hesEquipmentAssessories.setAssessoryName(box.getString("accessoryItemName"+i+a));
							}
							if(box.getString("serialNo"+i+a)!=null && box.getString("serialNo"+i+a)!=""){
								hesEquipmentAssessories.setSerialNo(box.getString("serialNo"+i+a));
							}
							if(box.getString("modelNo"+i+a)!=null && box.getString("modelNo"+i+a)!=""){
								hesEquipmentAssessories.setModelNo(box.getString("modelNo"+i+a));
							}
							if(box.getString("warrantyStartDate"+i+a)!=null && box.getString("warrantyStartDate"+i+a)!=""){
								try{
									hesEquipmentAssessories.setWarrantyStartDate(sdf.parse(box.getString("warrantyStartDate"+i+a)));
								}catch(Exception e){e.printStackTrace();}
							}
							if(box.getString("warrantyEndDate"+i+a)!=null && box.getString("warrantyEndDate"+i+a)!=""){
								try{
									hesEquipmentAssessories.setWarrantyEndDate(sdf.parse(box.getString("warrantyEndDate"+i+a)));
								}catch(Exception e){e.printStackTrace();}
							}
							if(box.getString("details"+i+a)!=null && box.getString("details"+i+a)!=""){
								hesEquipmentAssessories.setRemarks(box.getString("details"+i+a));
							}
							if(dataMap.get("hospitalId")!=null && dataMap.get("hospitalId")!=""){
								hospital=new MasHospital();
								hospital.setId((Integer)dataMap.get("hospitalId"));
								hesEquipmentAssessories.setHospital(hospital);
							}
							if(dataMap.get("userId")!=null && dataMap.get("userId")!=""){
								user=new Users();
								user.setId((Integer)dataMap.get("userId"));
								hesEquipmentAssessories.setLastChgBy(user);;
							}
							if(box.getString("currentDate")!=null && box.getString("currentDate")!=""){
								hesEquipmentAssessories.setLastChgDate(HMSUtil.dateFormatterDDMMYYYY(box.getString("currentDate")));
							}
							if(box.getString("currentTime")!=null && box.getString("currentTime")!=""){
								hesEquipmentAssessories.setLastChgTime(box.getString("currentTime"));
							}
							if(box.getString("department"+i)!=null && box.getString("department"+i)!=""){
								masDepartment=new MasDepartment();
								masDepartment.setId(box.getInt("department"+i));
								hesEquipmentAssessories.setDepartment(masDepartment);
							}
							hesEquipmentAssessories.setStatus("y");
							hbt.save(hesEquipmentAssessories);
							hbt.flush();
							hbt.clear();
						}
					}
				}
//				-------	Accessory details End----------
				hbt.update(hesEquipmentMaster);
				hbt.flush();
				hbt.clear();
			}
			tx.commit();
			message="<span style='color: green'>Successfully Saved.</span>";
		}catch(Exception e){
			e.printStackTrace();
			if(tx==null){
				tx.rollback();
				message="<span style='color: red'>Try Again...</span>";
			}
		}
		}
		map.put("message", message);
		return map;
	}
	
	public Map<String, Object> getEquipmentDetails(Map<String, Object> details) {
		Map<String,Object> map=new HashMap<String,Object>();
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		MmServiceRequest reRequest=new MmServiceRequest();
		List<HesEquipmentMaster> hesEquipmentMaster=new ArrayList<HesEquipmentMaster>();
		List<MasItemType> masItemTypes=new ArrayList<MasItemType>();
		List<MasItemClass> masItemClass=new ArrayList<MasItemClass>();
		List<MasItemCategory> masCategories=new ArrayList<MasItemCategory>();
		List<MasStoreSection> masStoreSection=new ArrayList<MasStoreSection>();
		List<MasPriorityCodes> masPriorityCodes=new ArrayList<MasPriorityCodes>();
		List<MmServiceRequest> masServiceRequests=new ArrayList<MmServiceRequest>();
		List<MasDepartment> departmentList=new ArrayList<MasDepartment>();
		List<MasManufacturer> masManufacturerList =null;
		List<Users> userList =null;
		
		List<HesEquipmentAmcDetailsEntry> hesEquipmentAmcDetailsEntry=new ArrayList<HesEquipmentAmcDetailsEntry>();
//		String[] statusCode={"PN", "AP", "ATE", "UO", "SC", "WO", "TA", "CA", "WOC", "SOC", "SOCL", "RAS", "SCH", "OH"};
		String[] priorityCode=null;
		String[] statusCode = null;
		
		try
		{
			statusCode = HMSUtil.getProperties("adt.properties", "requestStatusCode").split("#");
			priorityCode = HMSUtil.getProperties("adt.properties", "priorityCode").split("#");
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	/*	URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("maintenance.properties");
				try {
			java.util.Properties prop = new java.util.Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			statusCode = prop.getProperty("create.request.list").split("#");
			priorityCode = prop.getProperty("priority.code.list").split("#");
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		List<Integer> status=getMaintenanceId(getMaintenanceStatus(statusCode));
//		Integer[] status={1,2,3,4,7,8,9,11,13,14,15,16,17,18};
//		String[] priorityCode={"NOR", "URG", "CRT"};
		List<Integer> priority=getMaintenancePriorityId(getMaintenancePriorityCode(priorityCode));
		
		if(details.get("requestId")!=null){
			Map<String, Object> rquestDetail=new HashMap<String, Object>();
			rquestDetail.put("equipmentId", details.get("requestId"));
			masServiceRequests=getServiceRequestDetails(rquestDetail, status);
			hesEquipmentAmcDetailsEntry = getAMCDetails(rquestDetail);
		}
		if(details.get("department")!=null || details.get("requestId")!=null){
			hesEquipmentMaster=getEquipment(details);
		}
		masItemTypes=session.createCriteria(MasItemType.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ItemTypeName")).list();
		masItemClass=session.createCriteria(MasItemClass.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ItemClassName")).list();
		masCategories=session.createCriteria(MasItemCategory.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ItemCategoryName")).list();
		masStoreSection=session.createCriteria(MasStoreSection.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("SectionName")).list();
		masPriorityCodes=session.createCriteria(MasPriorityCodes.class).add(Restrictions.eq("Status", "y")).add(Restrictions.in("Id", priority)).addOrder(Order.asc("CodesName")).list();
		departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
		
		if(details.get("serviceRequestId")!=null){
			reRequest=(MmServiceRequest)hbt.get(MmServiceRequest.class, Integer.parseInt((String)details.get("serviceRequestId")));
		}
		
	if(hesEquipmentMaster.size() >0 && hesEquipmentMaster.get(0).getManufacturer()==null)
		masManufacturerList=session.createCriteria(MasManufacturer.class).addOrder(Order.asc("ManufacturerName")).list();
		
	
	userList = session.createCriteria(Users.class).addOrder(Order.asc("LoginName")).list();
	System.out.println(hesEquipmentMaster.size() +" ");
		map.put("masItemTypes", masItemTypes);
		map.put("masItemClass", masItemClass);
		map.put("masCategories", masCategories);
		map.put("masStoreSection", masStoreSection);
		map.put("hesEquipmentMaster", hesEquipmentMaster);
		map.put("priority", masPriorityCodes);
		map.put("masServiceRequests", masServiceRequests);
		map.put("hesEquipmentAmcDetailsEntry", hesEquipmentAmcDetailsEntry);
		map.put("reRequest", reRequest);
		map.put("departmentList", departmentList);
		map.put("masManufacturerList", masManufacturerList);
		map.put("userList", userList);
		
		
		
		return map;
	}
		
	//------  For Get Maitenance Status ------
	
	public List<MmMasRequestStatus> getMaintenanceStatus(String[] statusCode){
		List<MmMasRequestStatus> mmMasRequestStatus=new ArrayList<MmMasRequestStatus>();
		Session session=(Session)getSession();
		
		Criteria cr=session.createCriteria(MmMasRequestStatus.class);
		if(statusCode!=null){
		if(statusCode.length!=0){
			cr=cr.add(Restrictions.in("StatusCode", statusCode));
		}
		}
		cr=cr.add(Restrictions.eq("Status", "y").ignoreCase());
		mmMasRequestStatus=cr.list();
		return mmMasRequestStatus;
	}
	
	
	//------------    For Get MasPriorityCode --------
	public List<MasPriorityCodes> getMaintenancePriorityCode(String[] priorityCode){
		List<MasPriorityCodes> masPriorityCodes=new ArrayList<MasPriorityCodes>();
		Session session=(Session)getSession();
		Criteria cr=session.createCriteria(MasPriorityCodes.class);
		if(priorityCode!=null){
		if(priorityCode.length!=0){
			cr=cr.add(Restrictions.in("CodesCode", priorityCode));
		}
		}
		cr=cr.add(Restrictions.eq("Status", "y").ignoreCase());
		masPriorityCodes=cr.list();
		return masPriorityCodes;
	}
	
	public List<Integer> getMaintenanceId(List<MmMasRequestStatus> list){
		List<Integer> listId=new ArrayList<Integer>();
		for(int i=0;i<list.size();i++){
			listId.add(list.get(i).getId());
		
		}
		return listId;
		
	}
	
	public List<Integer> getMaintenancePriorityId(List<MasPriorityCodes> list){
		List<Integer> listId=new ArrayList<Integer>();
		for(int i=0;i<list.size();i++){
			listId.add(list.get(i).getId());
		}
		return listId;
	}
	
	//-------- Service Request
		public List<MmServiceRequest> getServiceRequestDetails(Map<String, Object> details, List<Integer> status){
			List<MmServiceRequest> mmServiceRequests=new ArrayList<MmServiceRequest>();
			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
			Date fromDate=null;
			Date toDate=null;
			Session session= (Session)getSession();
			Criteria criteria=session.createCriteria(MmServiceRequest.class, "sr")
					.createAlias("sr.Equipment", "e")
					.createAlias("sr.RequestStatus", "rs")
					.createAlias("sr.Hospital", "h");
			if(details.get("equipmentId")!=null)
					criteria=criteria.add(Restrictions.eq("e.Id", Integer.parseInt((String)details.get("equipmentId"))));
			if(status!=null)
				criteria=criteria.add(Restrictions.in("rs.Id", status));
			if(details.get("hospitalId")!=null){
				criteria=criteria.add(Restrictions.eq("h.Id", (Integer)details.get("hospitalId")));
			}
			if(details.get("requestId")!=null){
				criteria=criteria.add(Restrictions.eq("sr.Id", (Integer)details.get("requestId")));
			}
			if(details.get("fromDate")!=null && details.get("toDate")!=null){
				try{
					fromDate=sdf.parse((String)details.get("fromDate"));
					toDate=sdf.parse((String)details.get("toDate"));
				}catch(Exception e){e.printStackTrace();}
				criteria=criteria.add(Restrictions.between("sr.RequestDate", fromDate, toDate));
			}
			mmServiceRequests = criteria.list();
			return mmServiceRequests;
		}
		
		//---------------      AMC Details
		public List<HesEquipmentAmcDetailsEntry> getAMCDetails(Map<String, Object> details){
			List<HesEquipmentAmcDetailsEntry> hesEquipmentAmcDetailsEntry=new ArrayList<HesEquipmentAmcDetailsEntry>();
			Session session= (Session)getSession();
			Criteria criteria=session.createCriteria(HesEquipmentAmcDetailsEntry.class, "sr")
					.createAlias("sr.Epuipment", "e");
			if(details.get("equipmentId")!=null)
					criteria=criteria.add(Restrictions.eq("e.Id", Integer.parseInt((String)details.get("equipmentId"))));
			if(details.get("requestId")!=null)
				criteria=criteria.add(Restrictions.eq("e.Id", Integer.parseInt((String)details.get("requestId"))));
			hesEquipmentAmcDetailsEntry = criteria.addOrder(Order.desc("sr.Id")).list();
			return hesEquipmentAmcDetailsEntry;
		}
	
		//----   For Equipment Details  ------------
		public List<HesEquipmentMaster> getEquipment(Map<String, Object> details){
			Session session=(Session)getSession();
			List<HesEquipmentMaster> hesEquipmentMasters=new ArrayList<HesEquipmentMaster>();
			Criteria criteria=session.createCriteria(HesEquipmentMaster.class, "em")
					.createAlias("em.Hospital", "h")
					.createAlias("em.Department", "d")
					.createAlias("em.Item", "i")
					.createAlias("em.Manufacturer", "m", CriteriaSpecification.LEFT_JOIN)
					.createAlias("em.GrnT", "g", CriteriaSpecification.LEFT_JOIN);
			if(details.get("hospitalId")!=null){
				criteria=criteria.add(Restrictions.eq("h.Id", (Integer)details.get("hospitalId")));
			}
			if(details.get("department")!=null){
				criteria=criteria.add(Restrictions.eq("d.Id", (Integer.parseInt(""+details.get("department")))));
			}
			if(details.get("itemType")!=null){
				criteria=criteria.createAlias("i.ItemType", "it").add(Restrictions.eq("it.Id", (Integer.parseInt(""+details.get("itemType")))));
			}
			if(details.get("section")!=null){
				criteria=criteria.createAlias("i.Section", "s").add(Restrictions.eq("s.Id", (Integer.parseInt(""+details.get("section")))));
			}
			if(details.get("category")!=null){
				criteria=criteria.createAlias("i.ItemCategory", "ic").add(Restrictions.eq("ic.Id", (Integer.parseInt(""+details.get("category")))));
			}
			if(details.get("class")!=null){
				criteria=criteria.createAlias("i.ItemClass", "icl").add(Restrictions.eq("icl.Id", (Integer.parseInt(""+details.get("class")))));
			}
			if(details.get("requestId")!=null){
				criteria=criteria.add(Restrictions.eq("em.Id", (Integer.parseInt(""+details.get("requestId")))));
			}
			if(details.get("equipmentId")!=null){
				criteria=criteria.add(Restrictions.eq("em.Id", (Integer.parseInt(""+details.get("equipmentId")))));
			}
			hesEquipmentMasters = criteria.addOrder(Order.asc("i.Nomenclature")).createAlias("em.EquipStatus", "es", CriteriaSpecification.LEFT_JOIN)
					.add(Restrictions.or(Restrictions.isNull("em.EquipStatus"), Restrictions.ne("es.StatusCode", "CNMD"))).list();
			return hesEquipmentMasters;
		}
		
		@SuppressWarnings("unchecked")
		@Override
		public Map<String, Object> getEquipmentHistory(Map<String, Object> details) {
			Session session=(Session)getSession();
			Map<String, Object> map=new HashMap<String, Object>();
			List<HesEquipmentMaster> equipmentMaster=new ArrayList<HesEquipmentMaster>();
			List<MmServiceRequest> serviceDetail = new ArrayList<MmServiceRequest>(); 
			Criteria cr=session.createCriteria(HesEquipmentMaster.class).add(Restrictions.eq("Id", (Integer)details.get("eqId")));
			equipmentMaster=cr.list();
			serviceDetail=session.createCriteria(MmServiceRequest.class,"sr").createAlias("sr.Equipment", "e")
					.createAlias("sr.Hospital", "h")
					.add(Restrictions.eq("e.Id", (Integer)details.get("eqId"))).add(Restrictions.eq("h.Id", (Integer)details.get("hospitalId")))
					.addOrder(Order.desc("RequestDate")).list();
			map.put("equipmentMaster", equipmentMaster);
			map.put("serviceDetail", serviceDetail);
			return map;
		}
		
		@Override
		public Map<String, Object> equipmentDashBoard(Map<String, Object> details) {
			Map<String, Object> map=new HashMap<String, Object>();
			List<MmServiceRequest> mmServiceRequest=new ArrayList<MmServiceRequest>();
			List<Integer> status=null;
			String[] statusCode={"CL", "SC"};
			status=getMaintenanceId(getMaintenanceStatus(statusCode));
			mmServiceRequest=getServiceRequestDetails(details, status);
			
			map.put("mmServiceRequest", mmServiceRequest);
			return map;
		}
		
		public Map<String, Object> saveServiceDetails(Map<String, Object> details) {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			Session session=(Session)getSession();
			Map<String, Object> map=new HashMap<String, Object>();
			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
			MmServiceRequest mmServiceRequest=new MmServiceRequest();
			HesEquipmentMaster hesEquipmentMaster=new HesEquipmentMaster();
			MasPriorityCodes masPriorityCodes=new MasPriorityCodes();
			MmMasRequestStatus masRequestStatus=new MmMasRequestStatus();
			HesEquipmentAmcDetailsEntry hesEquipmentAmcDetailsEntry=new HesEquipmentAmcDetailsEntry();
			Users user=new Users();
			MasHospital masHospital=new MasHospital();
			//Date cd=new Date();
			Date requiredDate=null;
			Date lastChangeDate=null;
			//int i=0;
			int equipId =0;
			Transaction tx=null;
			String msg="";
			try{
				
				if(details.get("equipmentId")!=null){
					equipId = Integer.parseInt((String)details.get("equipmentId"));
				}
				
				tx=session.beginTransaction();
					if(details.get("serviceRequestId")!=null){
						mmServiceRequest=(MmServiceRequest)hbt.get(MmServiceRequest.class, Integer.parseInt((String)details.get("serviceRequestId")));
					}
					if(details.get("RequestType")!=null)
						mmServiceRequest.setRequestType((String)details.get("RequestType"));
					if(details.get("equipmentId")!=null){
						hesEquipmentMaster.setId(equipId);
						mmServiceRequest.setEquipment(hesEquipmentMaster);
					}
					if(details.get("requestType")!=null)
						mmServiceRequest.setRequestType((String)details.get("requestType"));
					if(details.get("priority")!=null){
						List<MasPriorityCodes> preorityCode=new ArrayList<MasPriorityCodes>();
						String[] data={(String)details.get("priority")};
						preorityCode=getMaintenancePriorityCode(data);
						masPriorityCodes.setId(preorityCode.get(0).getId());
						mmServiceRequest.setPriority(masPriorityCodes);
					}
					if(details.get("requiredDate")!=null){
						try{
							requiredDate=sdf.parse((String)details.get("requiredDate"));
						}catch(Exception e){e.printStackTrace();}
						mmServiceRequest.setRequiredDate(requiredDate);;
					}
					if(details.get("description")!=null)
						mmServiceRequest.setDescription((String)details.get("description"));
					if(details.get("userId")!=null){
						user.setId((Integer)details.get("userId"));
						mmServiceRequest.setLastChgBy(user);
					}
					if(details.get("hospitalId")!=null){
						masHospital.setId((Integer)details.get("hospitalId"));
						mmServiceRequest.setHospital(masHospital);
					}
					if(details.get("lastChgDate")!=null){
						try{
							lastChangeDate=sdf.parse((String)details.get("lastChgDate"));
						}catch(Exception e){e.printStackTrace();}
						mmServiceRequest.setLastChgDate(lastChangeDate);
						mmServiceRequest.setRequestDate(lastChangeDate);
					}
					if(details.get("amcId")!=null){
						hesEquipmentAmcDetailsEntry.setId(Integer.parseInt((String)details.get("amcId")));
						mmServiceRequest.setAmc(hesEquipmentAmcDetailsEntry);
					}
				/*	if(details.get("warranty")!=null){
						mmServiceRequest.setWarrentyStatus((String)details.get("warranty"));
						if(!details.get("warranty").toString().equalsIgnoreCase("None")){
							masRequestStatus.setId(2);
						}else{
							masRequestStatus.setId(1);
						}
					}*/
					
					masRequestStatus.setId(1);
					
					mmServiceRequest.setRequestStatus(masRequestStatus);
					if(details.get("lastChgTime")!=null){
						mmServiceRequest.setLastChgTime((String)details.get("lastChgTime"));
						mmServiceRequest.setRequestTime((String)details.get("lastChgTime"));
					}
					if(details.get("serviceRequestId")==null){
						Integer requestNo=(Integer)hbt.save(mmServiceRequest);
						hbt.flush();
						hbt.clear();
						String requestId="RID"+requestNo+"/"+details.get("lastChgDate");
						mmServiceRequest.setServiceRequestNo(requestId);
					}
				
					MasManufacturer mm = new MasManufacturer();
					mm.setId(Integer.parseInt(details.get("manufacture").toString()));
					mmServiceRequest.setManufacturer(mm);
					
					if(equipId!=0)
					{	
						hesEquipmentMaster = (HesEquipmentMaster) hbt.load(HesEquipmentMaster.class, equipId);
						hesEquipmentMaster.setId(equipId);
						hesEquipmentMaster.setManufacturer(mm);
						hbt.update(hesEquipmentMaster);
					}
					
					
					Users approval = new Users();
					approval.setId(Integer.parseInt(details.get("approval").toString()));
					mmServiceRequest.setApprovedBy(approval);
					
					
					hbt.update(mmServiceRequest);
					//-------SMS and mail Alert Start---
					String warrantyStatus=(String)details.get("warrantyStatus");
			/*		if(details.get("sms")!=null && details.get("sms")=="y"){
						if(warrantyStatus.equalsIgnoreCase("warranty")){
							OneToOne oneToOne=new OneToOne();
							String sms="Department of "+hesEquipmentMaster.getDepartment().getDepartmentName()+" the equipment request Number "+mmServiceRequest.getServiceRequestNo()+" - "+hesEquipmentMaster.getItem().getNomenclature()+" is under maintenance kindly attend to the same immediately";
							String mobileNumber=hesEquipmentMaster.getGrnT().getGrnMaster().getSupplier().getMobileNo();
							System.out.println(mobileNumber+"==="+sms);
							if(mobileNumber!=null){
								oneToOne.setMobileNo(mobileNumber);
								oneToOne.setMessage(sms);
								oneToOne.setStatus("U");
								oneToOne.setType("T");
								oneToOne.setSentTime((String)details.get("lastChgTime"));
								oneToOne.setSentDate(HMSUtil.convertStringTypeDateToDateType((String)details.get("lastChgDate")));
								oneToOne.setHospital(masHospital);
								hbt.save(oneToOne);
							}
						}
					}
					if(details.get("mail")!=null && details.get("mail")=="y"){
						
					}*/
					//-------SMS and mail Alert End---
					hbt.flush();
					hbt.clear();
				tx.commit();
					msg="<span style='color: green'>Request Created Successfully. Request Number: "+mmServiceRequest.getServiceRequestNo()+".</span>";
			}catch(Exception e){
				e.printStackTrace();
				tx.rollback();
				msg="<span style='color: red'>Try Again.</span>";
			}
			map.put("msg",msg);
			return map;
		}
		
		@Override
		public Map<String, Object> getPendingServiceRequest(
				Map<String, Object> details) {
			Session session=(Session)getSession();
			Map<String, Object> map=new HashMap<String, Object>();
			List<MmServiceRequest> mmServiceRequest=new ArrayList<MmServiceRequest>();
			List<MasPriorityCodes> priority=new ArrayList<MasPriorityCodes>();
			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
			Date fromDate=new Date();
			Date toDate=new Date();
			int hospitalId=0;
			if(details.get("hospitalId")!=null){
				hospitalId=Integer.parseInt(details.get("hospitalId").toString());
			}
			Criteria cr=session.createCriteria(MmServiceRequest.class)
					.createAlias("Equipment", "em")
					.createAlias("RequestStatus", "rs")
					.createAlias("em.Hospital", "h")
					.createAlias("Priority", "pr")
					.createAlias("em.Department", "d")
					.createAlias("LastChgBy", "u")
					//.setProjection(Projections.projectionList().add(Projections.property("sr.Id")).add(Projections.property("sr.RequestDate")).add(Projections.property("sr.ServiceRequestNo")).add(Projections.property("em.EntryNo")).add(Projections.property("em.EquipmentName")).add(Projections.property("pr.CodesName")).add(Projections.property("u.UserName")).add(Projections.property("d.DepartmentName")).add(Projections.property("rs.StatusName")))
					.add(Restrictions.eq("h.Id", hospitalId)).add(Restrictions.eq("rs.StatusCode", "PN"))
					.add(Restrictions.eq("ApprovedBy.Id", (Integer)details.get("user")));
			
			if(details.get("fromDate")!=null && details.get("fromDate")!="" && details.get("toDate")!=null && details.get("toDate")!=""){
				try{
				fromDate=sdf.parse(details.get("fromDate").toString());
				toDate=sdf.parse(details.get("toDate").toString());
				}catch(Exception e){e.printStackTrace();}
				cr=cr.add(Restrictions.between("RequestDate", fromDate, toDate));
			}
			if(details.get("requestId")!=null && details.get("requestId")!=""){
				cr=cr.add(Restrictions.eq("ServiceRequestNo", details.get("requestId")));
			}
			if(details.get("itemCode")!=null && details.get("itemCode")!=""){
				cr=cr.add(Restrictions.eq("em.EntryNo", details.get("itemCode")));
			}
			if(details.get("priority")!=null && details.get("priority")!=""){
				cr=cr.add(Restrictions.eq("pr.Id", Integer.parseInt(details.get("priority").toString())));
			}
		//	if(details.get("user")!=null && details.get("user")!=""){
				//cr=cr.add(Restrictions.eq("u.Id", (Integer)details.get("user")));
		//	}
			
			mmServiceRequest=cr.list();
			priority=session.createCriteria(MasPriorityCodes.class).add(Restrictions.eq("Status", "y")).list();
			map.put("mmServiceRequest", mmServiceRequest);
			map.put("priority", priority);
			return map;
		}
		
		public Map<String, Object> getRequestDetails(Map<String, Object> details) {
			Map<String, Object> map=new HashMap<String, Object>();
			List<MmServiceRequest> serviceDetail=new ArrayList<MmServiceRequest>();
			List<HesEquipmentMaster> hesEquipmentMasters=new ArrayList<HesEquipmentMaster>();
			List<HesEquipmentAmcDetailsEntry> hesEquipmentAmcDetailsEntry=new ArrayList<HesEquipmentAmcDetailsEntry>();
			List<MmMasRequestStatus> status=new ArrayList<MmMasRequestStatus>();
			List<MasDepartment> departmentList=new ArrayList<MasDepartment>();
			String[] statusCode = null;
		/*	URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("maintenance.properties");*/
			try {
				//java.util.Properties prop = new java.util.Properties();
				//prop.load(new FileInputStream(new File(resourcePath.getFile())));
				statusCode =  HMSUtil.getProperties("adt.properties", "requestStatusCode").split("#");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			Session session=(Session)getSession();
			serviceDetail=session.createCriteria(MmServiceRequest.class).add(Restrictions.eq("Id", Integer.parseInt(details.get("requestId").toString()))).list();
			status=session.createCriteria(MmMasRequestStatus.class).add(Restrictions.in("StatusCode", statusCode)).list();
			departmentList=session.createCriteria(MasDepartment.class).createAlias("DepartmentType", "dt").createAlias("Hospital", "h")
					.addOrder(Order.asc("DepartmentName"))
					//.add(Restrictions.eq("dt.DepartmentTypeCode", "MNT").ignoreCase())
					.add(Restrictions.eq("h.Id", Integer.parseInt(details.get("hospitalId").toString()))).list();
			/*department = session.createCriteria(MasInstituteDepartment.class).createAlias("Department", "dept")
											.createAlias("dept.DepartmentType", "dt").createAlias("Institute", "h").addOrder(Order.asc("dept.DepartmentName"))
											.add(Restrictions.eq("dt.DepartmentTypeCode", "MNT").ignoreCase())
											.add(Restrictions.eq("h.Id", Integer.parseInt(details.get("hospitalId").toString()))).list();
*/
			Map<String, Object> data=new HashMap<String, Object>();
			data.put("equipmentId", serviceDetail.get(0).getEquipment().getId().toString());
			hesEquipmentMasters=getEquipment(data);
			hesEquipmentAmcDetailsEntry=getAMCDetails(data);
			map.put("departmentList", departmentList);
			map.put("serviceDetail", serviceDetail);
			map.put("status", status);
			map.put("hesEquipmentMaster", hesEquipmentMasters);
			map.put("hesEquipmentAmcDetailsEntry", hesEquipmentAmcDetailsEntry);
			return map;
		}
		public Map<String, Object> saveServiceRequest(Map<String, Object> details) {
			Map<String, Object> map=new HashMap<String, Object>();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			MmMasRequestStatus status=new MmMasRequestStatus();
			MasDepartment department=new MasDepartment();
			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
			Session session =(Session)getSession();
			Date currentDate=new Date();
			Users users=new Users();
			String msg="";
			Transaction tx=null;
			try{
				tx=session.beginTransaction();
			MmServiceRequest mmServiceRequest=(MmServiceRequest) hbt.get(MmServiceRequest.class, (Integer.parseInt((String)details.get("requestId"))));
			List<MmMasRequestStatus> mmMasRequestStatus=new ArrayList<MmMasRequestStatus>();
			String[] data={(String)details.get("status")};
			mmMasRequestStatus=getMaintenanceStatus(data);
			status.setId(mmMasRequestStatus.get(0).getId());
			mmServiceRequest.setRequestStatus(status);
			if(!details.get("forwardTo").equals("")){
			department.setId(Integer.parseInt((String)details.get("forwardTo")));
			mmServiceRequest.setForwardDepartment(department);
			}
			if(!details.get("Remark").equals(""))
			mmServiceRequest.setRemarks((String)details.get("Remark"));
			users.setId((Integer)details.get("approvedBy"));
			mmServiceRequest.setApprovedBy(users);
			mmServiceRequest.setApprovedDate(currentDate);
			hbt.update(mmServiceRequest);
			hbt.flush();
			hbt.clear();
			tx.commit();
			msg="<span style='color: green'>Successfully Saved.</span>";
			}catch(Exception e){
				e.printStackTrace();
				tx.rollback();
				msg="<span style='color: red'>Try Again.</span>";
			}
			
			map.put("msg", msg);
			return map;
		}
		
		@Override
		public Map<String, Object> getPendingListOfInspection(
				Map<String, Object> details) {
			Map<String, Object> map=new HashMap<String, Object>();
			Session session=(Session)getSession();
			List<MmServiceRequest> mmServiceRequests=new ArrayList<MmServiceRequest>();
			List<MasPriorityCodes> priority=new ArrayList<MasPriorityCodes>();
			List<MasDepartment> departmentList=new ArrayList<MasDepartment>();
			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
			Date fromDate=new Date();
			Date toDate=new Date();
			int hospitalId=0;
//			Integer[] status={2,16};
			String[] statusCode=null;
	/*		URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("maintenance.properties");
			try {
				java.util.Properties prop = new java.util.Properties();
				prop.load(new FileInputStream(new File(resourcePath.getFile())));
				if(prop.getProperty("pending.list.inspection.status")!=null)
				statusCode = prop.getProperty("pending.list.inspection.status").split("#");
				
			} catch (IOException e) {
				e.printStackTrace();
			}*/
			
			try
			{
				statusCode = HMSUtil.getProperties("adt.properties", "requestStatusCode").split("#");
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
			if(details.get("hospitalId")!=null && details.get("hospitalId")!=""){
				hospitalId=(Integer)details.get("hospitalId");
			}
			Criteria cr=session.createCriteria(MmServiceRequest.class, "sr").createAlias("sr.Hospital", "h").createAlias("sr.RequestStatus", "rs")
					.createAlias("sr.Priority", "pr").createAlias("sr.Equipment", "em").createAlias("em.Department", "de")
					.add(Restrictions.eq("h.Id", hospitalId)).addOrder(Order.desc("RequestDate"));
			//System.out.println("statusCode=="+statusCode.toString());
			if(statusCode!=null){
				cr=cr.add(Restrictions.in("rs.StatusCode", statusCode));
			}
			if(details.get("fromDate")!=null && details.get("fromDate")!="" && details.get("toDate")!=null && details.get("toDate")!=""){
				try{
				fromDate=sdf.parse(details.get("fromDate").toString());
				toDate=sdf.parse(details.get("toDate").toString());
				}catch(Exception e){e.printStackTrace();}
				cr=cr.add(Restrictions.between("sr.RequestDate", fromDate, toDate));
			}
			if(details.get("requestId")!=null && details.get("requestId")!=""){
				cr=cr.add(Restrictions.eq("sr.ServiceRequestNo", details.get("requestId")));
			}
			if(details.get("itemCode")!=null && details.get("itemCode")!=""){
				cr=cr.add(Restrictions.eq("em.EntryNo", details.get("itemCode")));
			}
			if(details.get("priority")!=null && details.get("priority")!=""){
				cr=cr.add(Restrictions.eq("pr.Id", Integer.parseInt(details.get("priority").toString())));
			}
			if(details.get("RequestedFrom")!=null && details.get("RequestedFrom")!=""){
				cr=cr.add(Restrictions.eq("de.Id", Integer.parseInt(details.get("RequestedFrom").toString())));
			}
			mmServiceRequests=cr.list();
			priority=session.createCriteria(MasPriorityCodes.class).add(Restrictions.eq("Status", "y")).list();
			departmentList=session.createCriteria(MasDepartment.class,"d").createAlias("d.Hospital", "h").add(Restrictions.eq("h.Id", hospitalId)).addOrder(Order.asc("d.DepartmentName")).list();
			map.put("mmServiceRequests", mmServiceRequests);
			map.put("priority", priority);
			map.put("departmentList", departmentList);
			return map;
		}
		
		public Map<String, Object> showAllPendingListOfInspctionJsp(Map<String, Object> details) {
			Map<String, Object> map=new HashMap<String, Object>();
			Session session=(Session)getSession();
			List<MmServiceRequest> mmServiceRequests=new ArrayList<MmServiceRequest>();
			List<MasPriorityCodes> priority=new ArrayList<MasPriorityCodes>();
			List<MasDepartment> departmentList=new ArrayList<MasDepartment>();
			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
			Date fromDate=new Date();
			Date toDate=new Date();
			int hospitalId=0;
//			Integer[] status={2,16};
			String[] statusCode=null;
	/*		URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("maintenance.properties");
			try {
				java.util.Properties prop = new java.util.Properties();
				prop.load(new FileInputStream(new File(resourcePath.getFile())));
				if(prop.getProperty("pending.list.inspection.status")!=null)
				statusCode = prop.getProperty("pending.list.inspection.status").split("#");
			} catch (IOException e) {
				e.printStackTrace();
			}*/
			
			try
			{
				statusCode = HMSUtil.getProperties("adt.properties", "requestStatusCode").split("#");
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
			if(details.get("hospitalId")!=null && details.get("hospitalId")!=""){
				hospitalId=(Integer)details.get("hospitalId");
			}
			Criteria cr=session.createCriteria(MmServiceRequest.class, "sr").createAlias("sr.Hospital", "h").createAlias("sr.RequestStatus", "rs")
					.createAlias("sr.Priority", "pr").createAlias("sr.Equipment", "em").createAlias("em.Department", "de")
					.add(Restrictions.eq("h.Id", hospitalId)).addOrder(Order.desc("RequestDate"));
			if(statusCode!=null){
				cr=cr.add(Restrictions.in("rs.StatusCode", statusCode));
			}
			/*if(details.get("fromDate")!=null && details.get("fromDate")!="" && details.get("toDate")!=null && details.get("toDate")!=""){
				try{
				fromDate=sdf.parse(details.get("fromDate").toString());
				toDate=sdf.parse(details.get("toDate").toString());
				}catch(Exception e){e.printStackTrace();}
				cr=cr.add(Restrictions.between("sr.RequestDate", fromDate, toDate));
			}
			if(details.get("requestId")!=null && details.get("requestId")!=""){
				cr=cr.add(Restrictions.eq("sr.ServiceRequestNo", details.get("requestId")));
			}
			if(details.get("itemCode")!=null && details.get("itemCode")!=""){
				cr=cr.add(Restrictions.eq("em.EntryNo", details.get("itemCode")));
			}
			if(details.get("priority")!=null && details.get("priority")!=""){
				cr=cr.add(Restrictions.eq("pr.Id", Integer.parseInt(details.get("priority").toString())));
			}
			if(details.get("RequestedFrom")!=null && details.get("RequestedFrom")!=""){
				cr=cr.add(Restrictions.eq("de.Id", Integer.parseInt(details.get("RequestedFrom").toString())));
			}*/
			mmServiceRequests=cr.list();
			priority = session.createCriteria(MasPriorityCodes.class).add(Restrictions.eq("Status", "y")).list();
			departmentList=session.createCriteria(MasDepartment.class,"d").createAlias("d.Hospital", "h").add(Restrictions.eq("h.Id", hospitalId)).addOrder(Order.asc("d.DepartmentName")).list();
			map.put("mmServiceRequests", mmServiceRequests);
			map.put("priority", priority);
			map.put("departmentList", departmentList);
			return map;
		}

		@Override
		public Map<String, Object> getAssignResource(Map<String, Object> details) {
			Map<String, Object> map=new HashMap<String, Object>();
			List<HesEquipmentMaster> hesEquipmentMaster=new ArrayList<HesEquipmentMaster>();
			List<HesEquipmentAmcDetailsEntry> hesEquipmentAmcDetailsEntry=new ArrayList<HesEquipmentAmcDetailsEntry>();
			List<MasPriorityCodes> masPriorityCodes=new ArrayList<MasPriorityCodes>();
			Map<String, Object> data=new HashMap<String, Object>();
			
			Session session=(Session)getSession();
			List<MmServiceRequest> mmServiceRequests=new ArrayList<MmServiceRequest>();
			List<MasDepartment> masDepartment=new ArrayList<MasDepartment>();
			//List<MasInstituteDepartment> masInstituteDepartments=new ArrayList<MasInstituteDepartment>();
			
			mmServiceRequests=session.createCriteria(MmServiceRequest.class).add(Restrictions.eq("Id", Integer.parseInt(details.get("requestId").toString()))).list();
			masDepartment=session.createCriteria(MasDepartment.class, "d").createAlias("d.Hospital", "h").addOrder(Order.asc("DepartmentName")).add(Restrictions.eq("h.Id", (Integer)details.get("hospitalId"))).list();
			masPriorityCodes=session.createCriteria(MasPriorityCodes.class).add(Restrictions.eq("Status", "r").ignoreCase()).list();
			/*masInstituteDepartments=session.createCriteria(MasInstituteDepartment.class, "mid").createAlias("mid.Institute", "h").createAlias("mid.Department", "d").add(Restrictions.eq("h.Id", (Integer)details.get("hospitalId"))).addOrder(Order.asc("d.DepartmentName")).list();
			data.put("equipmentId", mmServiceRequests.get(0).getEquipment().getId().toString());
			*/
			hesEquipmentMaster=getEquipment(data);
			hesEquipmentAmcDetailsEntry=getAMCDetails(data);
			map.put("mmServiceRequests", mmServiceRequests);
			map.put("masDepartment", masDepartment);
			map.put("hesEquipmentMaster", hesEquipmentMaster);
			map.put("hesEquipmentAmcDetailsEntry", hesEquipmentAmcDetailsEntry);
			//map.put("masInstituteDepartments", masInstituteDepartments);
			map.put("masPriorityCodes", masPriorityCodes);
			return map;
		}
		
		@Override
		public Map<String, Object> getResourceList(Map<String, Object> details) {
			Map<String, Object> map=new HashMap<String, Object>();
			Session session=(Session)getSession();
//			List<UserDepartment> userList=new ArrayList<UserDepartment>();
			List<EmpScMapping> empScMappings=new ArrayList<EmpScMapping>();
			empScMappings=session.createCriteria(EmpScMapping.class,"esm")
					.createAlias("esm.Department", "d").createAlias("esm.Hospital", "hos")
					.add(Restrictions.eq("d.Id", (Integer)details.get("departmentId")))
							.add(Restrictions.eq("hos.Id", (Integer)details.get("hospitalId"))).list(); // hospital_id restriction added by Amit Das on 29-03-2016
			/*userList=session.createCriteria(UserDepartment.class, "ud")
					//.createAlias("ud.User","us")
					//.createAlias("us.Hospital", "hos")
					.createAlias("ud.Department", "d")
					//.add(Restrictions.eq("hos.Id", (Integer)details.get("hospitalId")))
					.add(Restrictions.eq("d.Id", (Integer)details.get("departmentId"))).list();
			System.out.println("----"+(Integer)details.get("hospitalId"));
			map.put("userList", userList);*/
			map.put("empScMappings", empScMappings);
			return map;
		}
		
		@Override
		public Map<String, Object> saveAssignResource(Map<String, Object> details) {
			Map<String, Object> map=new HashMap<String, Object>();
			String msg="";
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			List<MmMasRequestStatus> mmMasRequestStatus=new ArrayList<MmMasRequestStatus>();
			MmMasRequestStatus masRequestStatus=new MmMasRequestStatus();
			MmMasRequestStatus mmMasRequestStatusRe=new MmMasRequestStatus();
		/*	Integer priorityId=0;
			if(details.get("priorityId")!=null&&!"".equalsIgnoreCase(details.get("priorityId").toString())){
				priorityId=Integer.parseInt(details.get("priorityId").toString());
			}*/
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			MasEmployee masEmployee=new MasEmployee();
			Session session=(Session)getSession();
			Transaction tx=null;
			try{
				tx=session.beginTransaction();
			mmMasRequestStatus=session.createCriteria(MmMasRequestStatus.class).add(Restrictions.eq("StatusCode", "ATE").ignoreCase()).list();//Ate - Resource Assigned
			MmServiceRequest mmServiceRequest=(MmServiceRequest) hbt.get(MmServiceRequest.class, (Integer.parseInt((String)details.get("RequestNo"))));
			if(mmServiceRequest.getRequestStatus().getStatusCode().equalsIgnoreCase("RAS")){//re-assign
				mmMasRequestStatusRe.setId(mmServiceRequest.getTrReqStatus().getId());
				mmServiceRequest.setRequestStatus(mmMasRequestStatusRe);
			}else{
				masRequestStatus.setId(mmMasRequestStatus.get(0).getId());
				mmServiceRequest.setRequestStatus(masRequestStatus);
			}
		/*	if(priorityId!=0){
				MasPriorityCodes priority=new MasPriorityCodes();
				priority.setId(priorityId);
				mmServiceRequest.setPriority(priority);
			}*/
		
			masEmployee.setId(Integer.parseInt((String)details.get("Resource")));
			if(details.get("department")!=null){
				MasDepartment forwordDepartment = new MasDepartment();
				forwordDepartment.setId(Integer.parseInt((String)details.get("department")));
				mmServiceRequest.setForwardDepartment(forwordDepartment);
			}
			
			mmServiceRequest.setResourceUser(masEmployee);
			mmServiceRequest.setResourceRemarks((String)details.get("ResourceRemark"));
			hbt.update(mmServiceRequest);
			hbt.flush();
			hbt.clear();
			msg="<span style='color: green'>Successfully Assigned To Engineer.</span>";
			tx.commit();
			}catch (Exception e){
				e.printStackTrace();
				tx.rollback();
				msg="<span style='color: red'>Try Again.</span>";
			}
			map.put("msg", msg);
			return map;
		}
		
		@Override
		public Map<String, Object> getPendingServiceRequestList(
				Map<String, Object> details) {
			Map<String, Object> map=new HashMap<String, Object>();
			Session session=(Session)getSession();
			List<MmServiceRequest> mmServiceRequests=new ArrayList<MmServiceRequest>();
			List<MasPriorityCodes> priority=new ArrayList<MasPriorityCodes>();
			List<MmMasRequestStatus>masRequestStatus=new ArrayList<MmMasRequestStatus>();
			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
			Date fromDate=new Date();
			Date toDate=new Date();
			int hospitalId=0;
			String[] statusCode=null;
			String[] priorityCode=null;
			String flag = "";
/*			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("maintenance.properties");
			try {
				java.util.Properties prop = new java.util.Properties();
				prop.load(new FileInputStream(new File(resourcePath.getFile())));
				statusCode = prop.getProperty("pending.service.request.status.list").split("#");
				priorityCode = prop.getProperty("priority.code.list").split("#");
			} catch (IOException e) {
				e.printStackTrace();
			}*/
			try
			{
				statusCode = HMSUtil.getProperties("adt.properties", "requestStatusCode").split("#");
				priorityCode = HMSUtil.getProperties("adt.properties", "priorityCode").split("#");
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
			List<Integer> status=getMaintenanceId(getMaintenanceStatus(statusCode));
			if(details.get("hospitalId")!=null && details.get("hospitalId")!=""){
				hospitalId=(Integer)details.get("hospitalId");
			}
			if(details.get("flag")!=null && details.get("flag")!=""){
				flag=(String)details.get("flag");
			}
			if(flag.equalsIgnoreCase("all")){
					Criteria cr=session.createCriteria(MmServiceRequest.class, "sr").createAlias("sr.Hospital", "h").createAlias("sr.RequestStatus", "rs")
							.createAlias("sr.Priority", "pr").createAlias("sr.Equipment", "em").createAlias("sr.ResourceUser", "ru").createAlias("em.Item", "i")
							.add(Restrictions.eq("h.Id", hospitalId)).add(Restrictions.in("rs.Id", status))
							.add(Restrictions.eq("ru.Id", (Integer)details.get("empId")))
							.addOrder(Order.desc("RequestDate"));
					mmServiceRequests=cr.list();
			}else{
					Criteria cr=session.createCriteria(MmServiceRequest.class, "sr").createAlias("sr.Hospital", "h").createAlias("sr.RequestStatus", "rs")
							.createAlias("sr.Priority", "pr").createAlias("sr.Equipment", "em").createAlias("sr.ResourceUser", "ru").createAlias("em.Item", "i")
							.add(Restrictions.eq("h.Id", hospitalId)).add(Restrictions.in("rs.Id", status))
							.add(Restrictions.eq("ru.Id", (Integer)details.get("empId")));
					if(details.get("fromDate")!=null && details.get("fromDate")!="" && details.get("toDate")!=null && details.get("toDate")!=""){
						try{
						fromDate=sdf.parse(details.get("fromDate").toString());
						toDate=sdf.parse(details.get("toDate").toString());
						}catch(Exception e){e.printStackTrace();}
						cr=cr.add(Restrictions.between("sr.RequestDate", fromDate, toDate));
					}
					if(details.get("requestId")!=null && details.get("requestId")!=""){
						cr=cr.add(Restrictions.eq("sr.ServiceRequestNo", details.get("requestId")));
					}
					if(details.get("itemCode")!=null && details.get("itemCode")!=""){
						cr=cr.add(Restrictions.eq("i.PvmsNo", details.get("itemCode")));
					}
					if(details.get("priority")!=null && details.get("priority")!=""){
						cr=cr.add(Restrictions.eq("pr.Id", Integer.parseInt(details.get("priority").toString())));
					}
					if(details.get("ItemName")!=null && details.get("ItemName")!=""){
						cr=cr.add(Restrictions.eq("i.Nomenclature", details.get("ItemName").toString()));
					}
					if(details.get("status")!=null && details.get("status")!=""){
						cr=cr.add(Restrictions.eq("rs.Id",  Integer.parseInt(details.get("status").toString())));
					}
					mmServiceRequests=cr.list();
			}
			priority=session.createCriteria(MasPriorityCodes.class).add(Restrictions.in("CodesCode", priorityCode)).list();
			masRequestStatus=session.createCriteria(MmMasRequestStatus.class).list(); 
			List<MmServiceRequest> finalList=new ArrayList<MmServiceRequest>();
			List<MmServiceRequest> criticalList=new ArrayList<MmServiceRequest>();
			List<MmServiceRequest> urgentList=new ArrayList<MmServiceRequest>();
			List<MmServiceRequest> normalList=new ArrayList<MmServiceRequest>();
	        for(MmServiceRequest orginal:mmServiceRequests){
	        	if("CRT".equalsIgnoreCase(orginal.getPriority().getCodesCode())){
	        		criticalList.add(orginal);
	        	}else if("URG".equalsIgnoreCase(orginal.getPriority().getCodesCode())){
	        		urgentList.add(orginal);
	        	}else if("NOR".equalsIgnoreCase(orginal.getPriority().getCodesCode())){
	        		normalList.add(orginal);
	        	}else{
	        		normalList.add(orginal);
	        	}
	        }
	        finalList.addAll(criticalList);
	        finalList.addAll(urgentList);
	        finalList.addAll(normalList);
			map.put("masRequestStatus", masRequestStatus);
			map.put("priority", priority);
			map.put("mmServiceRequest", finalList);
			return map;
		}
		
		@Override
		public Map<String, Object> getInspectionDetails(Map<String, Object> details) {
			Map<String, Object> map=new HashMap<String, Object>();
			HibernateTemplate hbt=getHibernateTemplate();
			List<MmServiceRequest> mmServiceRequests=new ArrayList<MmServiceRequest>();
/*			List<MasCostCenter> costCenter=new ArrayList<MasCostCenter>();
			List<MasStoreSupplierType> supplierType=new ArrayList<MasStoreSupplierType>();*/
			List<MmMasRequestStatus> mmMasRequestStatus=new ArrayList<MmMasRequestStatus>();
			List<MmInspectionReport> mmInspectionReport=new ArrayList<MmInspectionReport>();
			List<HesEquipmentAmcDetailsEntry> hesEquipmentAmcDetailsEntry=new ArrayList<HesEquipmentAmcDetailsEntry>();
			List<HesEquipmentMaster> hesEquipmentMaster=new ArrayList<HesEquipmentMaster>();
			//List<MasStoreSupplier> suppliers=new ArrayList<MasStoreSupplier>();
		/*	List<MmPreventiveCheckList> mmPreventiveCheckList=new ArrayList<MmPreventiveCheckList>();
			List<MmPreventiveCheckListDetails> mmPreventiveCheckListDetails=new ArrayList<MmPreventiveCheckListDetails>();
			List<FaMasAccount> faMasAccounts=new ArrayList<FaMasAccount>();*/
			Map<String, Object> data=new HashMap<String, Object>();
			Session session=(Session)getSession();
			//String[] statusCode={"SC", "UO", "WO", "SCH", "OH", "CND"};
//			List<MmMasRequestStatus> status=getMaintenanceStatus(statusCode);
//			Integer[] status={7,4,8,17,18,19};
			Integer[] status={5,4,8,17,18,19};
			Integer[] sup={1,2,3,4};
			mmServiceRequests=session.createCriteria(MmServiceRequest.class).add(Restrictions.eq("Id", Integer.parseInt(details.get("requestId").toString()))).list();
			/*costCenter=session.createCriteria(MasCostCenter.class).addOrder(Order.asc("CostCenterName")).list();*/
			/*supplierType=session.createCriteria(MasStoreSupplierType.class).add(Restrictions.eq("Status", "y")).list();*/
			mmMasRequestStatus=session.createCriteria(MmMasRequestStatus.class).add(Restrictions.in("Id", status)).list();
			mmInspectionReport=session.createCriteria(MmInspectionReport.class, "ir")
					.createAlias("ir.Request", "sr")
					.add(Restrictions.eq("sr.Id", mmServiceRequests.get(0).getId())).list();
			//suppliers=session.createCriteria(MasStoreSupplier.class,"s").createAlias("s.SupplierType", "st").add(Restrictions.in("st.Id", sup)).addOrder(Order.asc("SupplierName")).list();
		/*	if(mmInspectionReport.size()!=0){
			mmPreventiveCheckListDetails=session.createCriteria(MmPreventiveCheckListDetails.class,"pcld")
					.createAlias("pcld.InspectionReport", "ir")
					.add(Restrictions.eq("ir.Id", mmInspectionReport.get(0).getId())).add(Restrictions.eq("pcld.Status", "y")).list();
			}*/
			data.put("equipmentId", mmServiceRequests.get(0).getEquipment().getId().toString());
			hesEquipmentMaster=getEquipment(data);
			hesEquipmentAmcDetailsEntry=getAMCDetails(data);
		/*	if(mmServiceRequests.get(0).getRequestType().equalsIgnoreCase("Preventive")){
				if(mmServiceRequests.get(0).getAmc()!=null){
					data.put("amcId", mmServiceRequests.get(0).getAmc().getId());
					mmPreventiveCheckList=getCheckList(data);
				}else{
					mmPreventiveCheckList=getCheckList(data);
				}
			}*/
	/*		Criteria faAccount=session.createCriteria(FaMasAccount.class);
			if(details.get("hospitalId")!=null){
				faAccount.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", (Integer)details.get("hospitalId")));
			}*/
			//faMasAccounts=faAccount.list();
			//map.put("faMasAccounts", faMasAccounts);
			//map.put("suppliers", suppliers);
			map.put("mmServiceRequests", mmServiceRequests);
			System.out.println("dd "+mmServiceRequests.size());
		//	map.put("costCenter", costCenter);
			//map.put("supplierType", supplierType);
			map.put("mmMasRequestStatus", mmMasRequestStatus);
			map.put("mmInspectionReport", mmInspectionReport);
			map.put("hesEquipmentAmcDetailsEntry", hesEquipmentAmcDetailsEntry);
			map.put("hesEquipmentMaster", hesEquipmentMaster);
		//	map.put("mmPreventiveCheckList", mmPreventiveCheckList);
			//map.put("mmPreventiveCheckListDetails", mmPreventiveCheckListDetails);
			return map;
		}
		
		
		@SuppressWarnings("unchecked")
		@Override
		public Map<String, Object> submitInspectionReport(
				Map<String, Object> details) {
			Map<String, Object> map=new HashMap<String, Object>();
			Session session= (Session)getSession();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Transaction tx = null;
			String msg="";
			MmServiceRequest mmServiceRequest=new MmServiceRequest();
			MmInspectionReport mmInspectionReport=new MmInspectionReport();
			HesEquipmentAmcDetailsEntry hesEquipmentAmcDetailsEntry=new HesEquipmentAmcDetailsEntry();
			HesEquipmentMaster hesEquipmentMaster=new HesEquipmentMaster();
			//MmSafetyProcedureMaterials mmSafetyProcedureMaterial=new MmSafetyProcedureMaterials();
			MmMasRequestStatus mmMasRequestStatus=new MmMasRequestStatus();
			MasStoreItem masStoreItem=new MasStoreItem();
			MasHospital hospital=new MasHospital();
			Users user=new Users();
			MasStoreSupplier masStoreSupplier=new MasStoreSupplier();
			/*List<MmSafetyProcedureMaterials> mmSafetyProcedureMaterials=new ArrayList<MmSafetyProcedureMaterials>();
			List<MmPreventiveCheckListDetails> mmPreventiveCheckListDetails=new ArrayList<MmPreventiveCheckListDetails>();*/
			List<Integer> mmCheckLists=new ArrayList<Integer>();
			List<Integer> allCheckLists=new ArrayList<Integer>();
/*			List<MmPreventiveCheckList> mmPreventiveCheckLists=new ArrayList<MmPreventiveCheckList>();
			List<MmPreventiveCheckList> preventiveCheckLists=new ArrayList<MmPreventiveCheckList>();*/
			Date lastChgDate=null;
			String lastChgTime="";
			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
			
			try {
				tx = session.beginTransaction();
				//-------    Populate Value ---------
				if(details.get("ServiceRequestId")!=null){
					mmServiceRequest=(MmServiceRequest)hbt.get(MmServiceRequest.class, Integer.parseInt((String)details.get("ServiceRequestId")));
					
					if(mmServiceRequest.getId()!=null){
						List<MmInspectionReport> mmIns=new ArrayList<MmInspectionReport>();
						mmIns=session.createCriteria(MmInspectionReport.class, "ins").createAlias("ins.Request", "r")
								.add(Restrictions.eq("r.Id", mmServiceRequest.getId())).list();
						if(mmIns.size()!=0)
						mmInspectionReport=(MmInspectionReport)hbt.get(MmInspectionReport.class, mmIns.get(0).getId());
					}
				/*	if(mmInspectionReport.getId()!=null){
						mmSafetyProcedureMaterials=session.createCriteria(MmSafetyProcedureMaterials.class)
								.createAlias("InspectionReport", "ir")
								.add(Restrictions.eq("ir.Id", mmInspectionReport.getId())).list();
						mmPreventiveCheckListDetails=session.createCriteria(MmPreventiveCheckListDetails.class)
								.createAlias("InspectionReport", "ir")
								.add(Restrictions.eq("ir.Id", mmInspectionReport.getId())).list();
					}*/
				}
			
				//-------    Inspection Details Set Data----------
				
				if(details.get("remarks")!=null){
					mmInspectionReport.setRemarks((String)details.get("remarks"));
				}
				
				if(details.get("hospitalId")!=null){
					hospital.setId((Integer)details.get("hospitalId"));
					mmInspectionReport.setHospital(hospital);
				}
				if(details.get("userId")!=null){
					user.setId((Integer)details.get("userId"));
					mmInspectionReport.setLastChgBy(user);
				}
				if(mmServiceRequest.getId()!=null){
					mmInspectionReport.setRequest(mmServiceRequest);
					hesEquipmentMaster.setId(mmServiceRequest.getEquipment().getId());
					mmInspectionReport.setEquipment(hesEquipmentMaster);
					if(details.get("ActionType")!=null){
						if(details.get("ActionType").equals("SC")){
							hesEquipmentMaster=(HesEquipmentMaster)hbt.get(HesEquipmentMaster.class,mmServiceRequest.getEquipment().getId());
							hesEquipmentMaster.setPreventiveCompletedCycle(mmServiceRequest.getEquipment().getPreventiveCompletedCycle()+1);
							hesEquipmentMaster.setId(mmServiceRequest.getEquipment().getId());
							hbt.update(hesEquipmentMaster);
							hbt.flush();
						}
					}
				}
				if(details.get("SupplierName")!=null){
					masStoreSupplier.setId(Integer.parseInt((String)details.get("SupplierName")));
					mmInspectionReport.setVendor(masStoreSupplier);
				}
				if(details.get("lastChgDate")!=null){
					lastChgDate=sdf.parse((String)details.get("lastChgDate"));
					mmInspectionReport.setLastChgDate(lastChgDate);
				}
				if(details.get("lastChgTime")!=null){
					lastChgTime=(String)details.get("lastChgTime");
					mmInspectionReport.setLastChgTime(lastChgTime);
				}
				if(details.get("ActionType")!=null){
					List<MmMasRequestStatus> mmMasRequestStatus2=new ArrayList<MmMasRequestStatus>();
					String[] data={(String)details.get("ActionType")};
					mmMasRequestStatus2=getMaintenanceStatus(data);
					mmMasRequestStatus.setId(mmMasRequestStatus2.get(0).getId());
					mmInspectionReport.setRequestStatus(mmMasRequestStatus);
					mmServiceRequest.setRequestStatus(mmMasRequestStatus);
					if(details.get("ActionType").equals("SC") || details.get("ActionType").equals("CL")){
						mmServiceRequest.setCloseDate(lastChgDate);
						mmServiceRequest.setCloseTime(lastChgTime);
					}
				}
				
				if(details.get("CloseType")!=null){
					mmInspectionReport.setCloseType((String)details.get("CloseType"));
				}
				if(details.get("WorkOrderType")!=null){
					mmInspectionReport.setWorkOrderType((String)details.get("WorkOrderType"));
				}
				if(details.get("ResourceRequirment")!=null){
					mmInspectionReport.setResourceRequirement((String)details.get("ResourceRequirment"));
				}
				if(details.get("DescriptionOfWork")!=null){
					mmInspectionReport.setDescriptionOfWork((String)details.get("DescriptionOfWork"));
				}
				if(details.get("obDate")!=null){
					Date obDate=sdf.parse((String)details.get("obDate"));
					mmInspectionReport.setObservationDate(obDate);
				}
				if(details.get("ObservationTime")!=null){
					mmInspectionReport.setObservationTime((String)details.get("ObservationTime"));
				}
				if(details.get("ObservationRemark")!=null){
					mmInspectionReport.setObservationRemark((String)details.get("ObservationRemark"));
				}
				if(details.get("ServiceCost")!=null){
					mmInspectionReport.setServiceCost(new BigDecimal((String)details.get("ServiceCost")));
				}
				if(details.get("MeterialCost")!=null){
					mmInspectionReport.setMaterialCost(new BigDecimal((String)details.get("MeterialCost")));
				}
				if(details.get("PlannedCost")!=null){
					mmInspectionReport.setPlannedCost(new BigDecimal((String)details.get("PlannedCost")));
				}
				if(details.get("WorkOrderRemark")!=null){
					mmInspectionReport.setWoRemarks((String)details.get("WorkOrderRemark"));
				}
				if(details.get("PreventiveDoneOn")!=null){
					Date preventiveDoneOn=sdf.parse((String)details.get("PreventiveDoneOn"));
					mmInspectionReport.setPreventiveDoneOn(preventiveDoneOn);
				}
				if(details.get("ScheduledDate")!=null){
					Date scheduledDate=sdf.parse((String)details.get("ScheduledDate"));
					mmInspectionReport.setScheduledDate(scheduledDate);
				}
				if(details.get("ScheduledTime")!=null){
					mmInspectionReport.setScheduledTime((String)details.get("ScheduledTime"));
				}
				if(details.get("ContactPerson")!=null){
					mmInspectionReport.setContactPerson((String)details.get("ContactPerson"));
				}
				if(details.get("OnHoldReason")!=null){
					mmInspectionReport.setReason((String)details.get("OnHoldReason"));
				}
				if(details.get("WORequiredDate")!=null){
					mmInspectionReport.setWoReqDate(HMSUtil.convertStringTypeDateToDateType((String)details.get("WORequiredDate")));;
				}
				if(details.get("PlannedEndDate")!=null){
					mmInspectionReport.setPlannedEndDate(HMSUtil.convertStringTypeDateToDateType((String)details.get("PlannedEndDate")));;
				}
				if(details.get("PlannedStartDate")!=null){
					mmInspectionReport.setPlannedStartDate(HMSUtil.convertStringTypeDateToDateType((String)details.get("PlannedStartDate")));;
				}
				
			
				
				
		/*		if(details.get("Account")!=null){
					FaMasAccount faMasAccount=new FaMasAccount();
					faMasAccount.setId(Integer.parseInt((String)details.get("Account")));
					mmInspectionReport.setAccount(faMasAccount);;
				}*/
				//----- For Emergency Indent
				if(details.get("ImergencyIndent")!=null){
					List<MmMasRequestStatus> mmMasRequestStatus4=new ArrayList<MmMasRequestStatus>();
					mmInspectionReport.setEmergencyIndent((String)details.get("ImergencyIndent"));
					mmMasRequestStatus4=session.createCriteria(MmMasRequestStatus.class).add(Restrictions.eq("StatusCode", "CA")).list();
					MmMasRequestStatus status=new MmMasRequestStatus(mmMasRequestStatus4.get(0).getId());
					mmInspectionReport.setRequestStatus(status);
					mmServiceRequest.setRequestStatus(status);
				}else{
					mmInspectionReport.setEmergencyIndent("n");
				}
				
				if(details.get("equipRecDate")!=null){
					mmServiceRequest.setEquipReceivedDate(HMSUtil.convertStringTypeDateToDateType((String)details.get("equipRecDate")));;
				}
				System.out.println(details.get("equipRecDate"));
				
				hbt.saveOrUpdate(mmInspectionReport);
				hbt.flush();
				hbt.clear();
				hbt.update(mmServiceRequest);
				hbt.flush();
				hbt.clear();
				/*if(details.get("ItemId")!=null && details.get("RequiredQty")!=null){
					Object[] data=(Object[])details.get("ItemId");
					Object[] requiredQty=(Object[])details.get("RequiredQty");
					int i=0;
					if(data.length>0){
					for(Object ob:data){
						mmSafetyProcedureMaterial.setInspectionReport(mmInspectionReport);
						masStoreItem.setId(Integer.parseInt((String)ob));
						mmSafetyProcedureMaterial.setItem(masStoreItem);
						mmSafetyProcedureMaterial.setRequiredQty(new BigDecimal((String)requiredQty[i]));
						if(details.get("specification") != null){
							Object[] specification = (Object[])details.get("specification");
							mmSafetyProcedureMaterial.setSpecification((String)specification[i]);
						}
						mmSafetyProcedureMaterial.setLastChgBy(user);
						mmSafetyProcedureMaterial.setLastChgDate(new Date());
						if(details.get("ImergencyIndent")!=null){
							mmSafetyProcedureMaterial.setStatus("c");
						}else{mmSafetyProcedureMaterial.setStatus("p");}
						mmSafetyProcedureMaterial.setLastChgBy(user);
						mmSafetyProcedureMaterial.setLastChgDate(lastChgDate);
						mmSafetyProcedureMaterial.setLastChgTime(lastChgTime);
						hbt.save(mmSafetyProcedureMaterial);
						hbt.flush();
						hbt.clear();
						++i;
					}
					}
				}*/
			/*	if(details.get("AllCheckList")!=null){
					allCheckLists.addAll((List<Integer>)details.get("AllCheckList"));
					if(details.get("mmCheckLists")!=null){
						mmCheckLists.addAll((List<Integer>)details.get("mmCheckLists"));
					}
					if(allCheckLists.size()!=0)
					mmPreventiveCheckLists=session.createCriteria(MmPreventiveCheckList.class).add(Restrictions.in("Id", allCheckLists)).list();
					if(mmCheckLists.size()!=0)
					preventiveCheckLists=session.createCriteria(MmPreventiveCheckList.class).add(Restrictions.in("Id", mmCheckLists)).list();
					for(MmPreventiveCheckList mmCheckList:mmPreventiveCheckLists){
						MmPreventiveCheckListDetails mmPreventiveCheckListDetails2=new MmPreventiveCheckListDetails();
						if(mmPreventiveCheckListDetails.size()!=0){
							List<MmPreventiveCheckListDetails> mmPreventiveCheckListDetails3=new ArrayList<MmPreventiveCheckListDetails>();
							mmPreventiveCheckListDetails3=session.createCriteria(MmPreventiveCheckListDetails.class, "pcl")
									.createAlias("pcl.CheckList", "cl")
									.createAlias("pcl.InspectionReport", "ir")
									.createAlias("ir.Request", "r")
									.add(Restrictions.eq("cl.Id", mmCheckList.getId())).add(Restrictions.eq("r.Id", mmServiceRequest.getId())).list();
							if(mmPreventiveCheckListDetails3.size()!=0){
								mmPreventiveCheckListDetails2=(MmPreventiveCheckListDetails)hbt.get(MmPreventiveCheckListDetails.class, mmPreventiveCheckListDetails3.get(0).getId());
							}
						}

						mmPreventiveCheckListDetails2.setCheckList(mmCheckList);
						mmPreventiveCheckListDetails2.setRequest(mmServiceRequest);
						mmPreventiveCheckListDetails2.setPreventiveNo(1);
						mmPreventiveCheckListDetails2.setHospital(hospital);
						mmPreventiveCheckListDetails2.setInspectionReport(mmInspectionReport);
						String status="n";
						for(MmPreventiveCheckList  preventiveStatus:preventiveCheckLists){
							if(preventiveStatus.getId()==mmCheckList.getId()){
								status="y";
							}
						}
						mmPreventiveCheckListDetails2.setStatus(status);
						hbt.saveOrUpdate(mmPreventiveCheckListDetails2);
						hbt.flush();
						hbt.clear();
					}
				}*/
				tx.commit();
				msg="<span style='color: green'>Successfully Saved.</span>";
				} catch (Exception e) {
				if (tx != null)
					tx.rollback();
				msg="<span style='color: red'>Try Again...</span>";
				e.printStackTrace();
			}
			
			
			
			
			
			
			
			/*Map<String, Object> map=new HashMap<String, Object>();
				MmInspectionReport mmInspectionReport=new MmInspectionReport();
				MmServiceRequest mmServiceRequest=new MmServiceRequest();
				MmMasRequestStatus mmMasRequestStatus=new MmMasRequestStatus();
				HesEquipmentMaster hesEquipmentMaster=new HesEquipmentMaster();
				MasCostCenter masCostCenter=new MasCostCenter();
				MasStoreSupplier masStoreSupplier=new MasStoreSupplier();
				MmSafetyProcedureMaterials mmSafetyProcedureMaterials=new MmSafetyProcedureMaterials();
				MasStoreItem masStoreItem=new MasStoreItem();
				Users user=new Users();
				MasHospital hospital=new MasHospital();
				List<MmInspectionReport> flag=new ArrayList<MmInspectionReport>();
				List<MmSafetyProcedureMaterials> flag1=new ArrayList<MmSafetyProcedureMaterials>();
				List<Integer> mmCheckLists=new ArrayList<Integer>();
				List<MmPreventiveCheckList> mmPreventiveCheckLists=new ArrayList<MmPreventiveCheckList>();
				List<MmPreventiveCheckListDetails> mmPreventiveCheckListDetails=new ArrayList<MmPreventiveCheckListDetails>();
				Session session=(Session)getSession();	
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_AUTO");
				hbt.setCheckWriteOperations(false);
				SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
				Date pfromDate=new Date();
				Date ptoDate=new Date();
				String msg="";
				boolean WOflag=false;
				int ServiceRequestId=0;
				if(details.get("ServiceRequestId")!=null)
					ServiceRequestId=Integer.parseInt((String)details.get("ServiceRequestId"));
				flag=session.createCriteria(MmInspectionReport.class).createAlias("Request", "r").add(Restrictions.eq("r.Id", ServiceRequestId)).list();
				if(flag.size()!=0){
					mmInspectionReport=(MmInspectionReport) hbt.get(MmInspectionReport.class, flag.get(0).getId());
					flag1=session.createCriteria(MmSafetyProcedureMaterials.class).createAlias("InspectionReport", "ir").add(Restrictions.eq("ir.Id", flag.get(0).getId())).list();
					if(flag1.size()!=0){
						mmSafetyProcedureMaterials=(MmSafetyProcedureMaterials)hbt.get(MmSafetyProcedureMaterials.class, flag1.get(0).getId());
					}
				}
				if(details.get("CloseType")!=null){
					mmInspectionReport.setCloseType((String)details.get("CloseType"));
				}
				if(details.get("ServiceRequestId")!=null){
					mmServiceRequest=(MmServiceRequest) hbt.get(MmServiceRequest.class, Integer.parseInt(details.get("ServiceRequestId").toString()));
					mmInspectionReport.setRequest(mmServiceRequest);
				}
				if(details.get("mmCheckLists")!=null){
					mmCheckLists.addAll((List<Integer>)details.get("mmCheckLists"));
					mmPreventiveCheckLists=session.createCriteria(MmPreventiveCheckList.class).add(Restrictions.in("Id", mmCheckLists)).list();
					for(MmPreventiveCheckList mmCheckList:mmPreventiveCheckLists){
						MmPreventiveCheckListDetails mmPreventiveCheckListDetails2=new MmPreventiveCheckListDetails();
						mmPreventiveCheckListDetails2.setCheckList(mmCheckList);
						mmPreventiveCheckListDetails2.setRequest(mmServiceRequest);
						hbt.save(mmPreventiveCheckListDetails2);
						hbt.flush();
						hbt.clear();
					}
					System.out.println("===="+mmPreventiveCheckLists.size());
				}
				hesEquipmentMaster=(HesEquipmentMaster) hbt.get(HesEquipmentMaster.class, mmServiceRequest.getEquipment().getId());
				if(details.get("ActionType")!=null){
					mmMasRequestStatus=(MmMasRequestStatus) hbt.get(MmMasRequestStatus.class, Integer.parseInt((String)details.get("ActionType")));
					mmServiceRequest.setRequestStatus(mmMasRequestStatus);
					mmInspectionReport.setRequestStatus(mmMasRequestStatus);
					if(details.get("ActionType").equals("8")){
						WOflag=true;
					}
				}
				if(details.get("WorkOrderType")!=null){
					mmInspectionReport.setWorkOrderType((String)details.get("WorkOrderType"));
				}
				if(details.get("ResourceRequirment")!=null){
					mmInspectionReport.setResourceRequirement((String)details.get("ResourceRequirment"));				
				}
				if(details.get("DescriptionOfWork")!=null){
					mmInspectionReport.setDescriptionOfWork((String)details.get("DescriptionOfWork"));
				}
				if(details.get("obDate")!=null){
					Date obDate=null;
					try{
						obDate=sdf.parse(details.get("obDate").toString());
						}catch(Exception e){e.printStackTrace();}
					mmInspectionReport.setObservationDate(obDate);
				}
				if(details.get("ObservationTime")!=null){
					mmInspectionReport.setObservationTime((String)details.get("ObservationTime"));
				}
				if(details.get("WorkOrderRemark")!=null){
					mmInspectionReport.setWorkOrderRemark((String)details.get("WorkOrderRemark"));
				}
				if(details.get("ObservationRemark")!=null){
					mmInspectionReport.setObservationRemark((String)details.get("ObservationRemark"));
				}
				if(details.get("equipmentId")!=null){
//					hesEquipmentMaster.setId(Integer.parseInt(details.get("equipmentId").toString()));
					mmInspectionReport.setEquipment(hesEquipmentMaster);
				}
				if(details.get("mmCheckLists")!=null){
					
				}
				if(mmServiceRequest.getRequestType().equalsIgnoreCase("Preventive") && Integer.parseInt((String)details.get("ActionType"))==7){
					hesEquipmentMaster.setPreventiveCompletedCycle(hesEquipmentMaster.getPreventiveCompletedCycle()+1);
					hbt.update(hesEquipmentMaster);
					hbt.flush();
					hbt.clear();
				}
				if(details.get("ServiceCost")!=null){
					mmInspectionReport.setServiceCost(new BigDecimal((String)details.get("ServiceCost")));
				}
				if(details.get("MeterialCost")!=null){
					mmInspectionReport.setMaterialCost(new BigDecimal((String)details.get("MeterialCost")));
				}
				if(details.get("PlannedCost")!=null && details.get("PlannedCost")!=""){
					mmInspectionReport.setPlannedCost(new BigDecimal(""+details.get("PlannedCost")));
				}
				if(details.get("SupplierName")!=null && details.get("SupplierName")!=""){
					masStoreSupplier.setId(Integer.parseInt((String)details.get("SupplierName")));
					mmInspectionReport.setVendor(masStoreSupplier);
				}
				if(details.get("WorkOrderRemark")!=null){
					mmInspectionReport.setRemarks((String)details.get("WorkOrderRemark"));
				}
				if(details.get("hospitalId")!=null){
					hospital.setId((Integer)details.get("hospitalId"));
					mmInspectionReport.setHospital(hospital);
				}
				if(details.get("userId")!=null){
					user.setId((Integer)details.get("userId"));
					mmInspectionReport.setLastChgBy(user);
					mmInspectionReport.setLastChgDate(new Date());
				}
				
				if(flag.size()==0){
					int workOrderNo=(Integer)hbt.save(mmInspectionReport);
					Date workOrderDate=new Date();
					String workOrder="WO"+workOrderNo+"/"+workOrderDate.getYear()+"/"+workOrderDate.getMonth()+"/"+workOrderDate.getDay();
					if(WOflag){
						mmInspectionReport=(MmInspectionReport) hbt.get(MmInspectionReport.class, workOrderNo);
						mmInspectionReport.setWorkOrderNo(workOrder);
						mmInspectionReport.setWorkOrderDate(workOrderDate);
						hbt.update(mmInspectionReport);
					}
					hbt.flush();
					hbt.clear();
				}else{
					hbt.update(mmInspectionReport);
					hbt.flush();
					hbt.clear();
				}
				if(details.get("ItemId")!=null){
					Object[] data=(Object[])details.get("ItemId");
					Object[] requiredQty=(Object[])details.get("RequiredQty");
					int i=0;
					if(data.length>0){
					for(Object ob:data){
						mmSafetyProcedureMaterials.setInspectionReport(mmInspectionReport);
						masStoreItem.setId(Integer.parseInt((String)ob));
						mmSafetyProcedureMaterials.setItem(masStoreItem);
						mmSafetyProcedureMaterials.setRequiredQty(new BigDecimal((String)requiredQty[i]));
						mmSafetyProcedureMaterials.setLastChgBy(user);
						mmSafetyProcedureMaterials.setLastChgDate(new Date());
						mmSafetyProcedureMaterials.setStatus("p");
						hbt.save(mmSafetyProcedureMaterials);
						hbt.flush();
						hbt.clear();
						++i;
					}
					}
				}
				if(details.get("ServiceRequestId")!=null){
				hbt.update(mmServiceRequest);
				hbt.flush();
				hbt.clear();
				}*/
				
				map.put("msg", msg);
			return map;
		}
		
		public Map<String, Object> getPreventiveMaintenanceList(
				Map<String, Object> details) {
			Map<String, Object> map=new HashMap<String, Object>();
			List<HesEquipmentMaster> hesEquipmentMasters=new ArrayList<HesEquipmentMaster>();
			List<HesEquipmentAmcDetailsEntry> hesEquipmentAmcDetailsEntry=new ArrayList<HesEquipmentAmcDetailsEntry>();
			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
			String flag = "";
			if(details.get("flag")!= null){
				flag = (String)details.get("flag");
			}
			
			Criteria amc=getSession().createCriteria(HesEquipmentAmcDetailsEntry.class, "amc")
					.createAlias("amc.Hospital", "h")
					.createAlias("amc.Epuipment", "e")
					.createAlias("e.Item", "i")
					.add(Restrictions.eq("h.Id", (Integer)details.get("hospitalId")));
			if(details.get("fromDate")!=null && details.get("toDate")!=null){
				Date fromDate=new Date();
				Date toDate=new Date();
				try {
					fromDate=   HMSUtil.dateFormatterDDMMYYYY((String)details.get("fromDate"));
					toDate=HMSUtil.dateFormatterDDMMYYYY((String)details.get("toDate"));
				} catch (Exception e) {
					e.printStackTrace();
				}
//				cr=cr.add(Restrictions.between("", fromDate, toDate));
			}
			if(details.get("ItemCode")!=null){
				amc=amc.add(Restrictions.eq("i.PvmsNo", (String)details.get("ItemCode")));
			}
			if(details.get("ItemName")!=null){
				amc=amc.add(Restrictions.eq("i.Nomenclature", (String)details.get("ItemName")));
			}
			if(details.get("ModelNo")!=null){
				amc=amc.add(Restrictions.eq("e.ModelName", (String)details.get("ModelNo")));
			}
			
			amc=amc.add(Restrictions.gt("amc.AmcWarrentyEndDate", new Date())).createAlias("e.EquipStatus", "es", CriteriaSpecification.LEFT_JOIN)
					.add(Restrictions.or(Restrictions.isNull("e.EquipStatus"), Restrictions.ne("es.StatusCode", "CNMD")));
		
			hesEquipmentAmcDetailsEntry=amc.list();
			if(flag.equalsIgnoreCase("all")){
				Criteria cr=getSession().createCriteria(HesEquipmentMaster.class, "e")
						.createAlias("e.Hospital", "h")
						.createAlias("e.Item", "i")
						.add(Restrictions.eq("h.Id", (Integer)details.get("hospitalId")))
						.add(Restrictions.leProperty("e.PreventiveCompletedCycle", "e.PreventiveCycle"));
				cr=cr.add(Restrictions.gt("e.WarrentyEndDate", new Date())).createAlias("e.EquipStatus", "es", CriteriaSpecification.LEFT_JOIN)
						.add(Restrictions.or(Restrictions.isNull("e.EquipStatus"), Restrictions.ne("es.StatusCode", "CNMD")));
				hesEquipmentMasters=cr.list();
				
			}else{
				Criteria cr=getSession().createCriteria(HesEquipmentMaster.class, "e")
						.createAlias("e.Hospital", "h")
						.createAlias("e.Item", "i")
						.add(Restrictions.eq("h.Id", (Integer)details.get("hospitalId")))
						.add(Restrictions.leProperty("e.PreventiveCompletedCycle", "e.PreventiveCycle"));
				if(details.get("ItemCode")!=null){
					cr=cr.add(Restrictions.eq("i.PvmsNo", (String)details.get("ItemCode")));
					amc=amc.add(Restrictions.eq("i.PvmsNo", (String)details.get("ItemCode")));
				}
				if(details.get("ItemName")!=null){
					cr=cr.add(Restrictions.eq("i.Nomenclature", (String)details.get("ItemName")));
				}
				if(details.get("ModelNo")!=null){
					cr=cr.add(Restrictions.eq("e.ModelName", (String)details.get("ModelNo")));
				}
				cr=cr.add(Restrictions.gt("e.WarrentyEndDate", new Date())).createAlias("e.EquipStatus", "es", CriteriaSpecification.LEFT_JOIN)
						.add(Restrictions.or(Restrictions.isNull("e.EquipStatus"), Restrictions.ne("es.StatusCode", "CNMD")));
				hesEquipmentMasters=cr.list();
				
			}
			//for current month
	/*		List<HesEquipmentMaster> hesEquipmentMastersFilter = null;
			
			if(hesEquipmentMasters.size() >0)
			{
				Calendar now = Calendar.getInstance();
				hesEquipmentMastersFilter =new ArrayList<HesEquipmentMaster>();
				int warrentyMonth = 0;
			    int nextPreventive = 0;
				for(HesEquipmentMaster hem :hesEquipmentMasters)
				{
					if(hem.getWarrentyStartDate()!=null)
						warrentyMonth  = hem.getWarrentyStartDate().getMonth();
					 nextPreventive = 12/(hem.getPreventiveCycle());
					    nextPreventive = nextPreventive + warrentyMonth;
					if(now.get(Calendar.MONTH) == nextPreventive)
						hesEquipmentMastersFilter.add(hem);
				}
			}*/
			
			map.put("hesEquipmentMasters", hesEquipmentMasters);
			//map.put("hesEquipmentMasters", hesEquipmentMastersFilter);
			map.put("hesEquipmentAmcDetailsEntry", hesEquipmentAmcDetailsEntry);
			return map;
		}
		
		
		
}

