package jkt.hms.laborroom.dataservice;

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

import jkt.hms.masters.business.BabyDetails;
import jkt.hms.masters.business.DeliveryDetails;
import jkt.hms.masters.business.Hospital;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasAdmissionType;
import jkt.hms.masters.business.MasBed;
import jkt.hms.masters.business.MasBedStatus;
import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.MasDeliveryType;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasEmployeeDependent;
import jkt.hms.masters.business.MasFrequency;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasPatientType;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasRelation;
import jkt.hms.masters.business.MasStoreItem;
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
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lowagie.text.pdf.codec.postscript.ParseException;


public class LaborRoomDataServiceImpl extends HibernateDaoSupport implements LaborRoomDataService {
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> getLRWaitingList(Map mapForDS) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		
		int hospitalId = 0;
		int userID = 0;
		
		List<Inpatient> patientList = new ArrayList<Inpatient>();
		try {
			 hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);
			 userID = (Integer) mapForDS.get(USER_ID);
			List<String>aList=new ArrayList<String>();
			aList.add("L");
			/*aList.add("R");*/
			Criteria crit= session.createCriteria(Inpatient.class)
                     .createAlias("Hin", "hin")
                     .add(Restrictions.eq("DeliveryStatus", "n"))
                       .add(Restrictions.isNull("DeliveryOtStatus"))
                        //.add(Restrictions.eq("DeliveryStatus", "n"))
                       // .add(Restrictions.or(Restrictions.eq("DeliveryStatus", "n"),Restrictions.ne("DeliveryOtStatus", "y") ))
					.add(Restrictions.eq("Hospital.Id", hospitalId));					
		
		
			if(mapForDS.get(PATIENT_NAME)!=null && mapForDS.get(PATIENT_NAME)!="")
			{
				crit = crit.add(Restrictions.like("hin.PFirstName", ((String)mapForDS.get(PATIENT_NAME)).toLowerCase()+"%").ignoreCase());
			}

			if (mapForDS.get("serviceNo") != null) {
				crit = crit.add(Restrictions.eq("hin.ServiceNo", (String) mapForDS.get("serviceNo")));
			}
		
			patientList = crit.list();

		} catch (HibernateException e) {
			map.put("error", "Error occured");
			e.printStackTrace();
		}
		map.put("patientList", patientList);
	
		return map;
	}


		public Map<String, Object> showLaborRoomSubmitJsp(Map mapForDS) {
			Map<String, Object> map = new HashMap<String, Object>();

			List<Inpatient> inPatientList = new ArrayList<Inpatient>();
			List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
			List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
			List<MasDeliveryType> deliveryTypeList = new ArrayList<MasDeliveryType>();
			List<MasRelation> relationList = new ArrayList<MasRelation>();
			int inpatientId = 0;
			int sonCode = 0;
			int daughterCode =0;
			
			Session session = (Session) getSession();
			if (mapForDS.get("inpatientId") != null) {
				inpatientId = (Integer) mapForDS.get("inpatientId");
			}
try
{	
	sonCode = Integer.parseInt(HMSUtil.getValuesFromPropertiesFile("adt.properties", "relationIdForSon"));
	daughterCode = Integer.parseInt(HMSUtil.getValuesFromPropertiesFile("adt.properties", "relationIdForDaughter"));
	
}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
			Integer rleationArray[] = {sonCode, daughterCode};
			
			try {
				inPatientList = session.createCriteria(Inpatient.class)
						.add(Restrictions.eq("Id", inpatientId)).list();

				employeeList = session.createCriteria(MasEmployee.class)
						.createAlias("EmpCategory", "empCat")
						.add(Restrictions.eq("empCat.EmpCategoryCode", "01"))
						.list();
				sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
				deliveryTypeList = session.createCriteria(MasDeliveryType.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
				relationList = session.createCriteria(MasRelation.class).add(Restrictions.eq("Status", "y").ignoreCase())
						       .add(Restrictions.in("Id", rleationArray))
						       .list();

				map.put("inPatientList", inPatientList);
				map.put("employeeList", employeeList);
				map.put("deliveryTypeList", deliveryTypeList);
				map.put("sexList", sexList);
				map.put("relationList", relationList);
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			return map;
		
	}
		
		public Map<String, Object> addMotherDetails(Map<String, Object> mapForDs) {
			Map<String, Object> map = new HashMap<String, Object>();
			int inpatientId = 0;
/*			String bloodLoss = "";
			String placenta = "";
			String treatment = "";
			Date dateOnSet = null;
			String timeOnSet = "";
			String purperium = "";
			String motherCondition = "";
			int pulse = 0;
			int perineum = 0;
			String bP = "";
			String bp2="";
			String additionalNotes = "";
			String complications = "";

			int assistedBy = 0;
			int masEmpIdConductedBy = 0;
			int masEmpIdAssistedBy = 0;*/
			int hospitalId = 0;
			int hinId = 0;
			int deptId = 0;
			int babyHinId = 0;
			Box box =null;
			
			//int tsn = 0;
			int id = 0;
			Session session = (Session) getSession();
			List<DeliveryDetails> deliveryDetailsList = new ArrayList<DeliveryDetails>();
			List<BabyDetails> birthList = new ArrayList<BabyDetails>();
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
			String currentDated = (String) utilMap.get("currentDate");
			String time = (String) utilMap.get("currentTime");

			if (mapForDs.get("hospitalId") != null) {
				hospitalId = (Integer) mapForDs.get("hospitalId");
			}
			if (mapForDs.get("hinId") != null) {
				hinId = (Integer) mapForDs.get("hinId");
			}
			if (mapForDs.get("box") != null) {
				box = (Box) mapForDs.get("box");
			}
			//System.out.println("hinId===="+hinId);
			if (mapForDs.get("inpatientId") != null) {
				inpatientId = (Integer) mapForDs.get("inpatientId");
			}
			
			if ( box.get("deptId")!=null) {
				deptId = box.getInt("deptId");
			}
			
			/*if (mapForDs.get("masEmpIdConductedBy") != null) {
				masEmpIdConductedBy = (Integer) mapForDs.get("masEmpIdConductedBy");
			}
			if (mapForDs.get("masEmpIdAssistedBy") != null) {
				masEmpIdAssistedBy = (Integer) mapForDs.get("masEmpIdAssistedBy");
			}
			
			if (mapForDs.get("bloodLoss") != null) {
				bloodLoss = (String) mapForDs.get("bloodLoss");
			}
			if (mapForDs.get("placenta") != null) {
				placenta = (String) mapForDs.get("placenta");
			}
			if (mapForDs.get("treatment") != null) {
				treatment = (String) mapForDs.get("treatment");
			}
			if (mapForDs.get("dateOnSet") != null) {
				dateOnSet = (Date) mapForDs.get("dateOnSet");
			}
			if (mapForDs.get("timeOnSet") != null) {
				timeOnSet = (String) mapForDs.get("timeOnSet");
			}
			if (mapForDs.get("purperium") != null) {
				purperium = (String) mapForDs.get("purperium");
			}
			if (mapForDs.get("motherCondition") != null) {
				motherCondition = (String) mapForDs.get("motherCondition");
			}
			if (mapForDs.get("pulse") != null) {
				pulse = (Integer) mapForDs.get("pulse");
			}
			if (mapForDs.get("perineum") != null) {
				perineum = (Integer) mapForDs.get("perineum");
			}
			if (mapForDs.get("bP") != null) {
				bP = (String) mapForDs.get("bP");
			}
			if (mapForDs.get("bp2") != null) {
				bp2 = (String) mapForDs.get("bp2");
			}
			System.out.println(bP+"/"+bp2);
			if (mapForDs.get("additionalNotes") != null) {
				additionalNotes = (String) mapForDs.get("additionalNotes");
			}
			if (mapForDs.get("complications") != null) {
				complications = (String) mapForDs.get("complications");
			}*/
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			boolean saved = false;
			boolean duplicate = true;
			String babyOfMotherName = "";
			String bplStatus="";
			String nationalDobStatus="";
			String motherHinNo ="";
			int patientTypeId=0;
			Date lastChangedate=null;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date=new Date();
			String curDate=sdf.format(date);
			Date currentDate = null;
			int  babyno=1;
			int  birthcertificateno=1;
			String babyHin = "";
			try {
				currentDate = sdf.parse(curDate);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Transaction tx = session.beginTransaction();
			try {
				
				String serviceNo = null;
				String patientCode = null;
				String patientName = null;
				String patientTypeNameForHAL = null;
				String patientTypeNameForOther = null;
				String Hal = null;
				String other = null;
				
				String hinNo = "";
				int babyGender = 0;
				String relationCode = null;
				int relationId = 0;
				String baby ="";
				int maleId = 0;
				int femaleId = 0;
				int otherId = 0;
				String billable = null;
				int  empId = 0;
				int rankId = 0;
				int srGender =0;
				Date srDob = date;
				String sf = null;
				String sm = null;
				String sl = null;
		
				List<Patient>ptList=new ArrayList<Patient>();
				ptList=session.createCriteria(Patient.class).add(Restrictions.eq("Id",hinId)).list();
				for(Patient pt:ptList){
					motherHinNo=pt.getHinNo();
					babyOfMotherName = pt.getPFirstName();
				
					if(pt.getPatientType() != null && pt.getPatientType().getId() != null){
						serviceNo = pt.getServiceNo();
						patientTypeId = (Integer)pt.getPatientType().getId();
						patientCode = pt.getPatientType().getPatientTypeCode();
						patientName = pt.getPatientType().getPatientTypeName();
						 billable = pt.getBillable();
						  empId = (Integer)pt.getEmployee().getId();
						 rankId = (Integer)pt.getRank().getId();
						 srGender = (Integer)pt.getSrSex().getId();
						 srDob = pt.getSrDob();
						 
						 sf = pt.getSFirstName();
						 sm = pt.getSMiddleName();
						 sl = pt.getSLastName();
					
					}
				break;
				}
				
				
			
				 Users users = new Users();
				 users.setId(box.getInt("userId"));
				
				 MasHospital masHospital = new MasHospital();
				 masHospital.setId(hospitalId);
				 
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(empId);
				
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(deptId);
				
				Inpatient inpatient = new Inpatient();
				inpatient.setId(inpatientId);
				
				deliveryDetailsList = session.createCriteria(DeliveryDetails.class)
						.add(Restrictions.eq("Inpatient.Id", inpatientId)).list();
				int count = box.getInt("noOfBaby");

				if (deliveryDetailsList.size() == 0) {
					duplicate = false;

					DeliveryDetails deliveryDetails = new DeliveryDetails();
					
					deliveryDetails.setInpatient(inpatient);
					deliveryDetails.setHospital(masHospital);
					
					Patient patient = new Patient();
					patient.setId(hinId);
					deliveryDetails.setHin(patient);
					
					//if(!box.getString("termOfGestation").equals("")){
						deliveryDetails.setGestation(box.getString("termOfGestation"));
					//}
			/*		if(!box.getString("durationOfDelivery").equals("")){
						deliveryDetails.setDeliveryDuration(box.getString("durationOfDelivery"));
					}*/
				/*	if(!box.getString("stageThree").equals("")){
						deliveryDetails.setStageThree(box.getString("stageThree"));
					}*/
					//if(!box.getString("episiotomy").equals("")){
						deliveryDetails.setEpisiotomy(box.getString("episiotomy"));
					//}
					//if(!box.getString("anaesthesia").equals("")){
						deliveryDetails.setAnaesthesia(box.getString("anaesthesia"));
					//}
					//if(!box.getString("perinealTears").equals("")){
						deliveryDetails.setPerinealTears(box.getString("perinealTears"));
					//}
					//if(!box.getString("placentaAndMembranes").equals("")){
						deliveryDetails.setPlacenta(box.getString("placentaAndMembranes"));
					//}
				/*	if(!box.getString("bleeding").equals("")){
						deliveryDetails.setBleeding(box.getString("bleeding"));
					}
					if(!box.getString("bloodTransfusion").equals("")){
						deliveryDetails.setBloodTransfusion(box.getString("bloodTransfusion"));
					}
					if(!box.getString("sutureMaterial").equals("")){
						deliveryDetails.setSutureMaterial(box.getString("sutureMaterial"));
					}
					if(!box.getString("stateOfUterus").equals("")){
						deliveryDetails.setStateOfUterus(box.getString("stateOfUterus"));
					}
					if(!box.getString("lactation").equals("")){
						deliveryDetails.setLactation(box.getString("lactation"));
					}
					if(!box.getString("stageComplications").equals("")){
						deliveryDetails.setStageFiveComplications(box.getString("stageComplications"));
					}*/
				
					if(!box.getString("induction").equals("")){
						deliveryDetails.setInduction(box.getString("induction"));
					}
					if(!box.getString("augment").equals("")){
						deliveryDetails.setAugmentation(box.getString("augment"));
					}
				//	if(!box.getString("deliverySubType").equals("")){
						deliveryDetails.setDeliveryType(box.getString("deliverySubType"));
					//}
				//	if(!box.getString("deliveryType").equals("")){
						deliveryDetails.setDeliverySubType(box.getString("deliveryType"));
					//}
					//if(!box.getString("otherdetails").equals("")){
						deliveryDetails.setOtherDetails(box.getString("otherdetails"));
					//}
					
					//if(!box.getString("otherRemarks").equals("")){
						deliveryDetails.setOtherRemarks(box.getString("otherRemarks"));
					//}
				
					hbt.save(deliveryDetails);
					
					Inpatient ip = (Inpatient)hbt.load(Inpatient.class, inpatientId);
					ip.setLrTransferStatus("n");
					if(count > 0)
					{
						ip.setDeliveryStatus("y");
						ip.setDeliveryOtStatus("n");
						hbt.save(ip);
					}
					else if(count == 0)
					{
						ip.setDeliveryStatus("n");
						ip.setDeliveryOtStatus("y");
						hbt.save(ip);
					}
					
					
					Date addEditDate = null;
					addEditDate = HMSUtil.convertStringTypeDateToDateType(currentDated);
					List<Integer> itemList = new ArrayList<Integer>();
					List<String> batchList = new ArrayList<String>();
					List<Integer> issuedStockList = new ArrayList<Integer>();
					
					itemList = (List<Integer>)mapForDs.get("itemList");
					issuedStockList = (List<Integer>)mapForDs.get("issuedStockList");
					batchList = (List<String>)mapForDs.get("batchList");
					
					
					if(itemList.size() >0)
					{
					//	if(itemList!=null && itemList.size() >0)
						
						PatientPrescriptionHeader patientPrescriptionHeader = new PatientPrescriptionHeader();
						//int item_class_id = 0;
						
						if(itemList.size() > 0){
							patientPrescriptionHeader.setHin(patient);
							masDepartment.setId(deptId);
					
							patientPrescriptionHeader.setDepartment(masDepartment);
						/*	Visit visit = new Visit();
							visit.setId(visitId);
							patientPrescriptionHeader.setVisit(visit);*/
						
							patientPrescriptionHeader.setHospital(masHospital);
							patientPrescriptionHeader.setStatus("I");
							patientPrescriptionHeader
									.setPrescriptionDate(addEditDate);
							patientPrescriptionHeader.setPrescriptionTime(time);
							patientPrescriptionHeader.setEmp(masEmployee);
									
							Map<String, Object> adMap = new HashMap<String, Object>();
						      adMap.put("tableObjectName", "PATIENT_PRESCRIPTION_HEADER");            
					            adMap.put("isHospitalWise", "y");
					            adMap.put("hospitalId", 1);
					            adMap.put("isYearly", "n");            
					            adMap.put("isMonthly", "n");
					            adMap.put("isPrefix", "n");
					
					        int prescriptionNo = Integer.parseInt(HMSUtil.generateTransactionSequence(adMap, session, hbt));
							patientPrescriptionHeader.setPrescriptionNo(prescriptionNo);
							patientPrescriptionHeader.setDepartment(masDepartment);
							patientPrescriptionHeader.setInpatient(inpatient);
			
							hbt.save(patientPrescriptionHeader);
							
							for (int k = 0; k < itemList.size(); k++) {
								
								if(itemList.get(k) !=0){
								//List<MasStoreItem> itemCodeList = new ArrayList<MasStoreItem>();
								PatientPrescriptionDetails patientPrescriptionDetails = new PatientPrescriptionDetails();
								if(itemList.get(k) != null){
									MasStoreItem masStoreItem = new MasStoreItem();
									masStoreItem.setId(itemList.get(k));
								patientPrescriptionDetails.setItem(masStoreItem);
								}
								
								patientPrescriptionDetails.setGivenQty(issuedStockList.get(k));
								patientPrescriptionDetails.setPrescription(patientPrescriptionHeader);
								//patientPrescriptionDetails.setDetailStatus("a");
								hbt.save(patientPrescriptionDetails);
								
								List<StoreItemBatchStock>storeItemBatch=session.createCriteria(StoreItemBatchStock.class).add(Restrictions.eq("BatchNo",batchList.get(k))).add(Restrictions.eq("Item.Id", itemList.get(k))).list();
								StoreItemBatchStock stock=null; 
								
								//System.out.println("batch "+k+" "+batchList.get(k) + " item id"+ itemList.get(k));
								
								if(storeItemBatch.size()>0){
									stock=storeItemBatch.get(0);
									stock.setClosingStock(stock.getClosingStock().subtract(new BigDecimal(issuedStockList.get(k))));
								}
								
								
								StoreOpPatientIssueM storeOpPatientIssueM = new StoreOpPatientIssueM();
								storeOpPatientIssueM.setDepartment(masDepartment);
								
						
							      adMap.put("tableObjectName", "StoreOpPatientIssueM");            
						            adMap.put("isHospitalWise", "y");
						            adMap.put("hospitalId", hospitalId);
						            adMap.put("isYearly", "y");            
						            adMap.put("isMonthly", "n");
						            adMap.put("isPrefix", "n");
								 //adtHandlerService.generateAdNumber(adMap);
								
								//String issueNo = generateTransactionSequence(adMap, session);
						            String issueNo = HMSUtil.generateTransactionSequence(adMap, session, hbt);
								storeOpPatientIssueM.setHospital(masHospital);
								storeOpPatientIssueM.setIssueDate(new Date());
								storeOpPatientIssueM.setIssueNo(issueNo);
								storeOpPatientIssueM.setStatus("y");
								storeOpPatientIssueM.setIssueType("I");
								storeOpPatientIssueM.setTypeOfIssue("P");
								hbt.save(storeOpPatientIssueM);
								
								StoreOpPatientIssueT storeOpPatientIssueT = new StoreOpPatientIssueT();
								storeOpPatientIssueT.setOpIssue(storeOpPatientIssueM);
								MasStoreItem masStoreItem = new MasStoreItem();
								masStoreItem.setId(itemList.get(k));
								storeOpPatientIssueT.setItemIdIssue(masStoreItem);
								storeOpPatientIssueT.setItemIdRequire(masStoreItem);
								storeOpPatientIssueT.setItem(masStoreItem);
								storeOpPatientIssueT.setBatchNo(batchList.get(k));
								storeOpPatientIssueT.setQtyIssued(new BigDecimal(issuedStockList.get(k)));
								storeOpPatientIssueT.setExpiryDate(stock.getExpiryDate());
								storeOpPatientIssueT.setPrescription(patientPrescriptionDetails);
								hbt.save(storeOpPatientIssueT);
						
								if(stock!=null){
									hbt.update(stock);
								}
								
							  }//prescription details and issued op
							}
							}// prescription header
						
					}
					
					
					
					int babyhdb = 0;  
					
					
					
					for(int i=1;i<=count;i++){
						//-------------------------	generate temporary registration of baby------------------------	
										
						    
							birthList=session.createCriteria(BabyDetails.class).list();
										
								if(birthList.size()>0){
									babyno=birthList.get((birthList.size()-1)).getBabyNo();
									babyno=babyno+1;
									birthcertificateno=Integer.parseInt(birthList.get((birthList.size()-1)).getBirthCertificationNo());
									birthcertificateno=birthcertificateno+1;
								}else{
									babyno=1;
									birthcertificateno=1;
								}
								
								Patient babyPatient = new Patient();
								babyPatient.setNewBornBaby("y");
								
								
								masHospital.setId(hospitalId);
								babyPatient.setHospital(masHospital);		
					
								
							/*	if(box.get(RELATION_ID+i)!=null)
								{
									relationId = box.getInt(RELATION_ID+i);
								}
								*/
								if(box.get("sexOfBaby"+i)!=null)
								{
									babyGender = box.getInt("sexOfBaby"+i);
								}
								
								try
								{	
									maleId = Integer.parseInt(HMSUtil.getValuesFromPropertiesFile("adt.properties", "administrativeSexMaleId"));
									femaleId = Integer.parseInt(HMSUtil.getValuesFromPropertiesFile("adt.properties", "administrativeSexFemaleId"));
									otherId = Integer.parseInt(HMSUtil.getValuesFromPropertiesFile("adt.properties", "administrativeSexOtherId"));
									
								}
											catch(Exception e)
											{
												System.out.println(e);
											}
								
								if(babyGender==maleId)
								{
									baby ="son";
									
								}
								else if(babyGender==femaleId)
								{
									baby ="daughter";
									
								}
							
								else if(babyGender==otherId)
								{
									baby ="other";
									
								}
								
								List<MasEmployeeDependent> dependentChildList = new ArrayList<MasEmployeeDependent>(); 
								List<MasRelation> relationList = new ArrayList<MasRelation>(); 
								dependentChildList=session.createCriteria(MasEmployeeDependent.class)
										.createAlias("Relation", "rel")
										 .add(Restrictions.like("rel.NewRelationName", baby +"%"))
										 .add(Restrictions.eq("Employee.Id", empId))
										 .list();
								if(dependentChildList.size()>0)
								{
									baby = baby+(dependentChildList.size()+1);
								}
								else
									baby = baby+1;
										
								relationList = session.createCriteria(MasRelation.class)
										.add(Restrictions.eq("NewRelationName", baby)).list(); 
								
									if(relationList.size()>0)
									{
										relationCode = relationList.get(0).getNewRelationCode();
										relationId =  relationList.get(0).getId();
									}
									
									//System.out.println(patientCode +" " +serviceNo+" " +relationCode);
									
									patientTypeNameForHAL = (String)HMSUtil.getValuesFromPropertiesFile("adt.properties", "patientTypeNameForHAL");
									patientTypeNameForOther = (String)HMSUtil.getValuesFromPropertiesFile("adt.properties", "patientTypeNameForOther");
									
								if(patientName.equalsIgnoreCase(patientTypeNameForHAL))	
									hinNo =  patientCode + serviceNo + relationCode;
								else 
								{
									hinNo = getHinIdOther(patientCode, hospitalId);
								}
								//System.out.println(hinNo + " hinno");
						babyPatient.setHinNo(hinNo);			
						
					/************* saving Dependent  *********/	
						
					//System.out.println(relationId +" relationId");
						MasRelation r = new MasRelation();
						r.setId(relationId);
				       int babyInaptientId = 0;
						if(box.getString("live"+i)!=null && (box.getString("live"+i).equalsIgnoreCase("live") || box.getString("live"+i).equalsIgnoreCase("Live cyanosed")) )
						{
							MasEmployeeDependent mep = new MasEmployeeDependent();
							mep.setEmployeeDependentFName("Baby"+i+" Of "+babyOfMotherName);
							mep.setDateOfBirth(HMSUtil.convertStringTypeDateToDateType(box.getString("birthDate"+i)));
						
							mep.setRelation(r);
							if (babyGender !=0) {
								MasAdministrativeSex masAdministrativeSex = new MasAdministrativeSex();
								masAdministrativeSex.setId(babyGender);
								mep.setGender(masAdministrativeSex);
							}
							
							mep.setStatus("y");
							masHospital.setId(hospitalId);
							mep.setHospital(masHospital);
							mep.setLastChgDate(addEditDate);
							mep.setLastChgTime(time);
								
							mep.setEmployee(masEmployee);
							hbt.save(mep);
							
										
							babyPatient.setPatientStatus("In Patient");
						}
						
						else if(box.getString("live"+i).equalsIgnoreCase("Masserated Still Birth") || box.getString("live"+i).equalsIgnoreCase("Fresh Still Birth"))
							  babyPatient.setPatientStatus("Expired");
						
						/**admission of baby **/	
						babyPatient.setRegDate(addEditDate);
									babyPatient.setAddEditTime(time);
									babyPatient.setRegTime(time);
						
						
						babyPatient.setAddEditDate(addEditDate);
						babyPatient.setRegDate(addEditDate);
						babyPatient.setAddEditTime(time);
						babyPatient.setRegTime(time);
						//Calendar calendar =Calendar.getInstance();
						babyPatient.setDateOfBirth(HMSUtil
								.convertStringTypeDateToDateType(box
										.getString("birthDate"+i)));
					
					/*	if (box.getInt("userId") != 0) {
							Users user = new Users();
							user.setId((Integer)mapForDs.get("userId"));
							babyPatient.setAddEditBy(user);
						}*/
					
						if (babyGender !=0) {
							MasAdministrativeSex masAdministrativeSex = new MasAdministrativeSex();
							masAdministrativeSex.setId(babyGender);
							babyPatient.setSex(masAdministrativeSex);
						}
						
						if (babyOfMotherName != null) {
							babyPatient.setPFirstName("Baby"+i+" Of "+babyOfMotherName);
						}
						
						/*if (bplStatus != null) {
							babyPatient.setBplStatus(bplStatus);
						}
						
						if (nationalDobStatus != null) {
							babyPatient.setNotionalDobStatus(nationalDobStatus);
						}*/
						
						if (motherHinNo != null) {
							babyPatient.setMotherHinNo(motherHinNo);
						}
						
						
						if (patientTypeId!= 0) {
						MasPatientType patientType = new MasPatientType();
						patientType.setId(patientTypeId);
						babyPatient.setPatientType(patientType);
						}

						babyPatient.setRelation(r);
						
						if(!box.getString("birthDate"+i).equals("")){
							babyPatient.setDateOfBirth(HMSUtil.convertStringTypeDateToDateType(box.getString("birthDate"+i)));
						}
						int days =HMSUtil.getNoOfDays(HMSUtil.convertStringTypeDateToDateType(box.getString("birthDate"+i)), currentDate);
						
						String babyAge="";
						
						if(days != 0){
							babyAge = days+" days";
						babyPatient.setAge(babyAge);
						}else{
							babyAge = (days+1) +" day";
							babyPatient.setAge(babyAge);
						}
						babyPatient.setStatus("y");
						babyPatient.setServiceNo(serviceNo);
						babyPatient.setCurrentVisitNo(1);
						babyPatient.setSrDob(srDob);
						babyPatient.setBillable(billable);
						
						if (srGender !=0) {
							MasAdministrativeSex masAdministrativeSex = new MasAdministrativeSex();
							masAdministrativeSex.setId(srGender);
							babyPatient.setSrSex(masAdministrativeSex);
						}
						
							babyPatient.setEmployee(masEmployee);
						
						if ( rankId!=0) {
							MasRank rank = new MasRank();
							rank.setId(rankId);
							babyPatient.setRank(rank);
						}
						
						babyPatient.setSFirstName(sf);
						babyPatient.setSMiddleName(sm);
						babyPatient.setSLastName(sl);
						
						
						hbt.save(babyPatient);
						babyHinId=babyPatient.getId();
					
						if(box.getString("live"+i)!=null && (box.getString("live"+i).equalsIgnoreCase("live") || box.getString("live"+i).equalsIgnoreCase("Live cyanosed")) )
						{
						
						//creating inpatient id for patient
						Inpatient babyinpatient = new Inpatient();
						//babyinpatient
						babyinpatient.setDateOfAddmission(addEditDate);
						babyinpatient.setTimeOfAddmission(time);
						//babyPatient.setMlcCases("n");
						babyinpatient.setAddEditDate(addEditDate);
						babyinpatient.setMlc("n");
						babyinpatient.setAddEditDate(addEditDate);
						babyinpatient.setAddEditTime(time);
						babyinpatient.setAdStatus("L");
						babyinpatient.setStatus("y");
						//babyinpatient.setPatientCondition(patientCondition); doublt
						babyinpatient.setConditionStatus("Lying");
						babyinpatient.setListDate(addEditDate);
						babyinpatient.setListTime(time);
						babyinpatient.setAttachedPatient("n");
						//babyinpatient.setBed(bed);
						babyinpatient.setHospital(masHospital);
						babyinpatient.setDepartment(masDepartment);
						babyinpatient.setHin(patient);
						babyinpatient.setAddEditBy(users);
						babyinpatient.setPatientCondition("Normal");
						
						//Patient patient = new Patient();
						patient.setId(babyHinId);
						babyinpatient.setHin(patient);
						
						babyinpatient.setHinNo(hinNo);
						babyinpatient.setAdNoType("a");
						babyinpatient.setAge(babyAge);
						babyinpatient.setAdStatus("L");
						
						Map<String, Object> adMap = new HashMap<String, Object>();
					    adMap.put("tableObjectName", "Inpatient");            
		                adMap.put("isHospitalWise", "y");
		                adMap.put("hospitalId", hospitalId);
		                adMap.put("isYearly", "y");            
		                adMap.put("isMonthly", "y");
		                adMap.put("isPrefix", "y");
		                adMap.put("transactionPrefixProperty", "transactionPrefixForIPD");
		                /*adNo = adtHandlerService.generateAdNumber(adMap);*/
		                
		                /*adNo = adtHandlerService.generateTransactionSequence(adMap, ses);*/
		               String adNo = HMSUtil.generateTransactionSequence(adMap, session, hbt);
						
						babyinpatient.setAdNo(adNo);
						//assign mother's info to baby
						
						List<Inpatient> motherInpatient =  session.createCriteria(Inpatient.class).add(Restrictions.eq("Id",inpatientId)).list();
						
						babyinpatient.setBed(motherInpatient.get(0).getBed());
						babyinpatient.setDoctor(motherInpatient.get(0).getDoctor());
						babyinpatient.setDepartment(motherInpatient.get(0).getDepartment());
						
						String newAdmission = HMSUtil.getValuesFromPropertiesFile("adt.properties", "AdmissionTypeCodeForNew");
						
						List <MasAdmissionType> admTypeList= session.createCriteria(MasAdmissionType.class).add(Restrictions.eq("AdmissionTypeCode",newAdmission)).list();
						
						babyinpatient.setAdmissionType(admTypeList.get(0));
						
						hbt.save(babyinpatient);
						babyInaptientId  = babyinpatient.getId();		
						
						}
						
						//****************** Baby Details table
						
						BabyDetails babyDetails = new BabyDetails();
						
						if(box.getInt("babyNo"+i) !=0){
							babyDetails.setBabyNo(box.getInt("babyNo"+i));
						}
						babyDetails.setBabyHin(babyPatient);
						babyDetails.setBirthCertificationNo(""+birthcertificateno);
						if(!box.getString("birthDate"+i).equals("")){
							babyDetails.setBirthCertificationDate(HMSUtil.convertStringTypeDateToDateType(box.getString("birthDate"+i)));
							}
						
						if(babyInaptientId!=0) //zero means baby is dead so now we can access info by delivery id in table baby details
						{
						inpatient.setId(babyInaptientId);
						babyDetails.setInpatient(inpatient);
						}
						
						if(box.getInt("sexOfBaby"+i) !=0){
							MasAdministrativeSex administrativeSex = new MasAdministrativeSex();
							administrativeSex.setId(box.getInt("sexOfBaby"+i));
							babyDetails.setSex(administrativeSex);
						}
						if(!box.getString("live"+i).equals("")){
							babyDetails.setLiveStillBorn(box.getString("live"+i));
						}
						
						if(!box.getString("birthWeight"+i).equals("")){
							babyDetails.setWeight(box.getString("birthWeight"+i));
						}
						
						if(!box.getString("timeOfDelivery"+i).equals("")){
							babyDetails.setTimeOfBirth(box.getString("timeOfDelivery"+i));
						}
						if(!box.getString("birthDate"+i).equals("")){
							babyDetails.setDateOfBirth(HMSUtil.convertStringTypeDateToDateType(box.getString("birthDate"+i)));
						}
						
					/*	if(box.getInt("typeOfDelivery"+i) !=0){
							MasDeliveryType masDeliveryType = new MasDeliveryType();
							masDeliveryType.setId(box.getInt("typeOfDelivery"+i));
							babyDetails.setDeliveryType(masDeliveryType);
						}
						if(!box.getString("presentation"+i).equals("")){
							babyDetails.setPresentation(box.getString("presentation"+i));
						}*/
						
						if(!box.getString("babyCry"+i).equals("")){
							babyDetails.setBabyCry(box.getString("babyCry"+i));
						}
						if(box.getInt("apgarAtone"+i) !=0){
							babyDetails.setApgarAt1(box.getInt("apgarAtone"+i));
						}
						if(box.getInt("apgarAtFive"+i) !=0){
							babyDetails.setApgarAt5(box.getInt("apgarAtFive"+i));
						}
						if(!box.getString("complications"+i).equals("")){
							babyDetails.setComplications(box.getString("complications"+i));
						}
						if(!box.getString("anomalies"+i).equals("")){
							babyDetails.setAnomalies(box.getString("anomalies"+i));
						}
						if(!box.getString("babyFeeding"+i).equals("")){
							babyDetails.setBabyFeeding(box.getString("babyFeeding"+i));
						}
						
						babyDetails.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDated));
						babyDetails.setLastChgTime(time);
							
						babyDetails.setLastChgBy(users);
						babyDetails.setDelivery(deliveryDetails);
						masHospital.setId(hospitalId);
						babyDetails.setHospital(masHospital);
						hbt.save(babyDetails);
						
						//Saving treatment details for each baby
						babyhdb = box.getInt("hdb"+i);
						
						if(babyhdb >0)
						{
								 itemList = new ArrayList<Integer>();
								 batchList = new ArrayList<String>();
								 issuedStockList = new ArrayList<Integer>();
						          String nomenclature = null;
						
								for(int j =1; j<=babyhdb; j++)
								{		
								if(box.get("baby" + i +"nomenclature"+ j)!=null)
									 nomenclature = box.getString("baby" + i +"nomenclature"+ j);
									if(nomenclature!=null && nomenclature!="")
									{
										 int index1 = nomenclature.lastIndexOf("(");
										 int index2 = nomenclature.lastIndexOf(")");
										 index1++;
										 try
										 {
										   itemList.add(Integer.parseInt(nomenclature.substring(index1, index2)));
										   issuedStockList.add(box.getInt("baby" + i +"dosage"+ j));
										   batchList.add(box.getString("baby" + i +"batch"+ j));
										 }
										 catch(NumberFormatException e)
										 {
											 e.printStackTrace();
										 }
								    }//outer if
						
								}
								
							
							//	if(itemList!=null && itemList.size() >0)
								
								PatientPrescriptionHeader patientPrescriptionHeader = new PatientPrescriptionHeader();
								//int item_class_id = 0;
								
								if(itemList.size() > 0){
									patientPrescriptionHeader.setHin(patient);
									masDepartment.setId(deptId);
							
									patientPrescriptionHeader.setDepartment(masDepartment);
								/*	Visit visit = new Visit();
									visit.setId(visitId);
									patientPrescriptionHeader.setVisit(visit);*/
								
									patientPrescriptionHeader.setHospital(masHospital);
									patientPrescriptionHeader.setStatus("I");
									patientPrescriptionHeader
											.setPrescriptionDate(addEditDate);
									patientPrescriptionHeader.setPrescriptionTime(time);
									patientPrescriptionHeader.setEmp(masEmployee);
											
									Map<String, Object> adMap = new HashMap<String, Object>();
								      adMap.put("tableObjectName", "PATIENT_PRESCRIPTION_HEADER");            
							            adMap.put("isHospitalWise", "y");
							            adMap.put("hospitalId", 1);
							            adMap.put("isYearly", "n");            
							            adMap.put("isMonthly", "n");
							            adMap.put("isPrefix", "n");
							
							        int prescriptionNo = Integer.parseInt(HMSUtil.generateTransactionSequence(adMap, session, hbt));
									patientPrescriptionHeader.setPrescriptionNo(prescriptionNo);
									patientPrescriptionHeader.setDepartment(masDepartment);
									patientPrescriptionHeader.setInpatient(inpatient);
									
									hbt.save(patientPrescriptionHeader);
									
									for (int k = 0; k < itemList.size(); k++) {
										
										if(itemList.get(k) !=0){
										//List<MasStoreItem> itemCodeList = new ArrayList<MasStoreItem>();
										PatientPrescriptionDetails patientPrescriptionDetails = new PatientPrescriptionDetails();
										if(itemList.get(k) != null){
											MasStoreItem masStoreItem = new MasStoreItem();
											masStoreItem.setId(itemList.get(k));
										patientPrescriptionDetails.setItem(masStoreItem);
										}
										
										patientPrescriptionDetails.setGivenQty(issuedStockList.get(k));
										patientPrescriptionDetails.setPrescription(patientPrescriptionHeader);
										//patientPrescriptionDetails.setDetailStatus("a");
										
										hbt.save(patientPrescriptionDetails);
										
										List<StoreItemBatchStock>storeItemBatch=session.createCriteria(StoreItemBatchStock.class).add(Restrictions.eq("BatchNo",batchList.get(k))).add(Restrictions.eq("Item.Id", itemList.get(k))).list();
										StoreItemBatchStock stock=null; 
										
										
										
										if(storeItemBatch.size()>0){
											stock=storeItemBatch.get(0);
											stock.setClosingStock(stock.getClosingStock().subtract(new BigDecimal(issuedStockList.get(k))));
										}
										
										
										StoreOpPatientIssueM storeOpPatientIssueM = new StoreOpPatientIssueM();
										storeOpPatientIssueM.setDepartment(masDepartment);
										
								
									      adMap.put("tableObjectName", "StoreOpPatientIssueM");            
								            adMap.put("isHospitalWise", "y");
								            adMap.put("hospitalId", hospitalId);
								            adMap.put("isYearly", "y");            
								            adMap.put("isMonthly", "n");
								            adMap.put("isPrefix", "n");
										 //adtHandlerService.generateAdNumber(adMap);
										
										//String issueNo = generateTransactionSequence(adMap, session);
								            String issueNo = HMSUtil.generateTransactionSequence(adMap, session, hbt);
										storeOpPatientIssueM.setHospital(masHospital);
										storeOpPatientIssueM.setIssueDate(new Date());
										storeOpPatientIssueM.setIssueNo(issueNo);
										storeOpPatientIssueM.setStatus("y");
										storeOpPatientIssueM.setIssueType("I");
										storeOpPatientIssueM.setTypeOfIssue("P");
										hbt.save(storeOpPatientIssueM);
										
										StoreOpPatientIssueT storeOpPatientIssueT = new StoreOpPatientIssueT();
										storeOpPatientIssueT.setOpIssue(storeOpPatientIssueM);
										MasStoreItem masStoreItem = new MasStoreItem();
										masStoreItem.setId(itemList.get(k));
										storeOpPatientIssueT.setItemIdIssue(masStoreItem);
										storeOpPatientIssueT.setItemIdRequire(masStoreItem);
										storeOpPatientIssueT.setItem(masStoreItem);
										storeOpPatientIssueT.setBatchNo(batchList.get(k));
										storeOpPatientIssueT.setQtyIssued(new BigDecimal(issuedStockList.get(k)));
										storeOpPatientIssueT.setExpiryDate(stock.getExpiryDate());
										storeOpPatientIssueT.setPrescription(patientPrescriptionDetails);
										hbt.save(storeOpPatientIssueT);
								
										if(stock!=null){
											hbt.update(stock);
										}
										
									  }//prescription details and issued op
									}// prescription header
									
								}
						}		
						
					}
				}  
				tx.commit();
				saved = true;
			} catch (Exception e) {
				babyHin = "";
				saved = false;
				e.printStackTrace();
				tx.rollback();
			}
			String msg = "";
			if (saved) {
				if (duplicate) {
					msg = "Data Duplicate";
				} else {
					if(saved)
					msg = "Mother Details Added Successfully";
					else
						msg = "Details could not be saved";
				}
			} else {
				msg = "Data could not Saved";
			}
			map.put("msg", msg);
			//map.put("hinNo", hinNo);
			map.put("babyHin", babyHin);
			return map;
		}
		
		@Override
		public Map<String, Object> displayStockNBatch(Map<String, Object> dataMap) {
			Map<String, Object> map = new HashMap<String, Object>();
			//List<MasStoreItem>itemMasterList = new ArrayList<MasStoreItem>();
			List<MasStoreItem>itemMasterListA = new ArrayList<MasStoreItem>();
			//List<Object[]>itemBatchStockList = new ArrayList<Object[]>();
			String pvmsNo ="";
			int hospitalId = 0;
			int deptId = (Integer)dataMap.get("deptId");
			if(dataMap.get("hospitalId") != null){
				hospitalId = (Integer)dataMap.get("hospitalId");
			}
			if(dataMap.get("pvmsNo") != null){
				pvmsNo = (String)dataMap.get("pvmsNo");
			}
			Session session = (Session)getSession();
			itemMasterListA = session.createCriteria(MasStoreItem.class).add(Restrictions.eq("PvmsNo", pvmsNo))						
								.list();
			int itemId = 0;
			if(itemMasterListA.size()>0){
				MasStoreItem storeItem = itemMasterListA.get(0);
				itemId = storeItem.getId();
			}
			int  phrDeptID = 0; 
			int  addDays = 0;
			
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
			String currentDate = (String) utilMap.get("currentDate");
			Properties properties = new Properties();
			URL resourcePath = Thread.currentThread()
					 .getContextClassLoader()
					 .getResource("adt.properties");
			
			try {
				properties.load(resourcePath.openStream());
				phrDeptID = Integer.parseInt(properties.getProperty("departmentIdForPharmacy"));
				addDays = Integer.parseInt(properties.getProperty("AddDaysInExpiryDate"));
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			Date date = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DATE, addDays); 
			 
			date = cal.getTime();
			Date expiryDate = HMSUtil.getExpiryDateYYYYMMDD();	
			String expiryStr = HMSUtil.convertDateToStringFormat(expiryDate, "yyyy-MM-dd");
			

			String str = "select sum(inp.closing_stock) from store_item_batch_stock inp  where item_id = "
					+ itemId + " and hospital_id = "+hospitalId+" and department_id =" + deptId +" and expiry_date > = '"+expiryStr+"'";
			
			/*String str = "select sum(inp.closing_stock) from store_item_batch_stock inp  where item_id = "
					+ itemId + " and hospital_id = "+hospitalId+" and department_id =" + deptId +" and expiry_date > =  DATEADD(day,"+ addDays +", "+currentDate+")";
			*/
			//System.out.println("str" +str);
			
			List<BigDecimal> itemBatchStockList = session.createSQLQuery(str).list();
			//System.out.println("itemBatchStockList==="+itemBatchStockList.size());
			if(itemBatchStockList != null){
			for (int i=0;i<itemBatchStockList.size();i++) {
				BigDecimal closingstock = itemBatchStockList.get(0);
				map.put("closingstock", closingstock);
				//System.out.println("closingstock===="+closingstock);
			 }
			}
			List<StoreItemBatchStock> batchList = new ArrayList<StoreItemBatchStock>();
			batchList = session.createCriteria(StoreItemBatchStock.class).createAlias("Item", "item")
					.add(Restrictions.eq("item.Id", itemId))
	  				.createAlias("Department", "dept")
	  				.add(Restrictions.ge("ExpiryDate", date))
	  				.add(Restrictions.eq("dept.Id", deptId))
	  				.add(Restrictions.eq("Hospital.Id", hospitalId))
	  				//.add(Restrictions.or( Restrictions.eq("dept.Id", deptId), Restrictions.eq("Hospital.Id", box.getInt("hospitalId"))))
	  				//.add(Restrictions.or(Restrictions.not(Restrictions.in("BlockStatus", blockStatus)), Restrictions.isNull("BlockStatus")))
	  				.list();
		
			map.put("itemMasterList", itemMasterListA);
			map.put("batchList", batchList);
			return map;
		}
		
		public String getHinIdOther(String patientCode, int hospitalId) {
			Session session = (Session) getSession();
			String previousHinNo = "";
			String maxSequenceNo = "";
			String hinNo ="";
			List<Patient> previousHinNoList = new ArrayList<Patient>();
			try {
				
					previousHinNoList = session.createCriteria(Patient.class).createAlias("PatientType", "pt")
							.add(Restrictions.eq("Hospital.Id", hospitalId))
							.add(Restrictions.eq("pt.PatientTypeCode", patientCode)).list();
				
				
				if (previousHinNoList.size() > 0) {

					ArrayList hinNoSequenceList = new ArrayList();
					for (Patient patient : previousHinNoList) {
						
							previousHinNo = patient.getHinNo();						
							String sequenceNo = previousHinNo.substring(2);
							int i = Integer.parseInt(sequenceNo);
							hinNoSequenceList.add(i);
							
						
					}

					if (hinNoSequenceList.size() > 0) {
						maxSequenceNo = Collections.max(hinNoSequenceList)
								.toString();
						Integer i;
						if (!maxSequenceNo.equals("")) {
							i = Integer.parseInt(maxSequenceNo) + 1;

						} else {
							i = 01;
						}
						String seqNo = "";
						if (i <= 9) {
							seqNo = "0" + i.toString();
						} else {
							seqNo = i.toString();
						}
						hinNo = patientCode.concat(seqNo.toString());
					}
				}
			} catch (HibernateException e) {
				e.printStackTrace();
			//	session.close();
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			return hinNo;

		}
		
		public Map<String, Object> getTransferPatientWaitingList(Map mapForDS) {
			Session session = (Session) getSession();
			Map<String, Object> map = new HashMap<String, Object>();
			
			int hospitalId = 0;
			int userID = 0;
			
			List<Inpatient> patientList = new ArrayList<Inpatient>();
			try {
				 hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);
				 userID = (Integer) mapForDS.get(USER_ID);
			/*	List<String>aList=new ArrayList<String>();
				aList.add("A");
				aList.add("R");*/
				Criteria crit= session.createCriteria(Inpatient.class)
	                    .createAlias("Hin", "hin")
	                    .add(Restrictions.eq("LrTransferStatus", "n"))
	               /*     .add(Restrictions.ne("DeliveryStatus", "n"))
	                    .add(Restrictions.ne("DeliveryOtStatus", "n"))*/
						.add(Restrictions.eq("Hospital.Id", hospitalId));					
			
				if(mapForDS.get(PATIENT_NAME)!=null && mapForDS.get(PATIENT_NAME)!="")
				{
					crit = crit.add(Restrictions.like("hin.PFirstName", ((String)mapForDS.get(PATIENT_NAME)).toLowerCase()+"%").ignoreCase());
				}

				if (mapForDS.get("serviceNo") != null) {
					crit = crit.add(Restrictions.eq("hin.ServiceNo", (String) mapForDS.get("serviceNo")));
				}
			
				patientList = crit.list();

			} catch (HibernateException e) {
				map.put("error", "Error occured");
				e.printStackTrace();
			}
			map.put("patientList", patientList);
		
			return map;
		}
		
		public Map<String, Object> getTransferPatientDetails(Map mapForDS) {
			Session session = (Session) getSession();
			Map<String, Object> map = new HashMap<String, Object>();
			int otDepartmentId = 0;
			int hospitalId = 0;
			int inpatientId = 0;
		//	int userID = 0;
			
			List<DeliveryDetails> deliveryDetailsList = new ArrayList<DeliveryDetails>();
			List<BabyDetails> babyList = new ArrayList<BabyDetails>();
			//List<DeliveryDetails> deliveryDetailsList = new ArrayList<DeliveryDetails>();
			List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			try {
				 hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);
				 inpatientId = (Integer) mapForDS.get("inpatientId");
				// userID = (Integer) mapForDS.get(USER_ID);
			/*	List<String>aList=new ArrayList<String>();
				aList.add("A");
				aList.add("R");*/
				 
				 
				Criteria crit= session.createCriteria(DeliveryDetails.class)
	                    .createAlias("Inpatient", "ip")
	                    .add(Restrictions.eq("ip.Id",inpatientId))
						.add(Restrictions.eq("Hospital.Id", hospitalId));					
				deliveryDetailsList = crit.list();
				
				if(deliveryDetailsList.size()> 0)
				{
				 int deliveryId = deliveryDetailsList.get(0).getId();
				 int wardId  = deliveryDetailsList.get(0).getInpatient().getDepartment().getId();
				
				babyList = session.createCriteria(BabyDetails.class)
	                    .createAlias("Delivery", "delivery")
	                    .add(Restrictions.eq("delivery.Id",deliveryId))
						.add(Restrictions.eq("Hospital.Id", hospitalId)).list();
				
				String wardDepartmentTypeCode = null;
				String departmentTypeCodeForOT = null;
			
				try
				{
					//departmentCodeForICU = HMSUtil.getValuesFromPropertiesFile("adt.properties", "departmentCodeForICU");
					wardDepartmentTypeCode = HMSUtil.getValuesFromPropertiesFile("adt.properties", "departmentTypeCodeForWard");
					 departmentTypeCodeForOT = HMSUtil.getValuesFromPropertiesFile("adt.properties", "departmentTypeCodeForOT");
					

				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				departmentList=session.createCriteria(MasDepartment.class)
						.add(Restrictions.eq("Status","y").ignoreCase())
						.createAlias("DepartmentType", "dt")
						.add(Restrictions.or(Restrictions.in("dt.DepartmentTypeCode",new String[] {departmentTypeCodeForOT,wardDepartmentTypeCode}), Restrictions.eq("Id", wardId) ) )
						.addOrder(Order.asc("DepartmentName"))
						.list();
				//System.out.println(babyList.size()+" patientList" +patientList.size() +" "+inpatientId +" "+hospitalId +" "+departmentTypeCodeForOT +" "+wardId);
				
				for(MasDepartment dept:departmentList)
				{
					
				    if(dept.getDepartmentCode().equalsIgnoreCase(departmentTypeCodeForOT))
				    {
				    	otDepartmentId = dept.getId();
				    	break;
				    }
				}
				
				}
			
			} catch (HibernateException e) {
				map.put("error", "Error occured");
				e.printStackTrace();
			}
			map.put("deliveryDetailsList", deliveryDetailsList);
			map.put("babyList", babyList);
			map.put("departmentList", departmentList);
			map.put("otDepartmentId", otDepartmentId);
			
			return map;
		}
		
		public Map<String, Object> submitPatientTransfer(Map mapForDS) {
			Session session = (Session) getSession();
			Map<String, Object> map = new HashMap<String, Object>();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setCheckWriteOperations(false);
			hbt.setFlushModeName("FLUSH_EAGER");
			boolean saved = false;
			int  empId = 0;
			int deptId = 0;
			int userId =0 ;
			int hospitalId = 0;
			Box box =null;
			Transaction tx = null;
			int motherInpatientId = 0;
			int motherTransferDept = 0;
		
			if (mapForDS.get("box") != null) {
				box = (Box) mapForDS.get("box");
			}
			
			 String currentTime = box.getString(CURRENT_TIME);
			 Date currentDate =  HMSUtil.convertStringTypeDateToDateType(box.getString(CURRENT_DATE));
			
			
			if (mapForDS.get(HOSPITAL_ID) != null) {
				hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);
			}
			if (mapForDS.get("deptId") != null) {
				deptId = (Integer) mapForDS.get("deptId");
			}
			
			if (mapForDS.get("empId") != null) {
				empId = (Integer) mapForDS.get("empId");
			}
			
			if (mapForDS.get(USER_ID) != null) {
				userId = (Integer) mapForDS.get(USER_ID);
			}
			if (box.get("motherinpatientid") != null) {
				motherInpatientId =box.getInt("motherinpatientid");
			}
			
			try
			{
			    tx = session.beginTransaction();
			    
			    Users user = new Users();
			    user.setId(userId);
			    
			    MasHospital hospital = new MasHospital();
			    hospital.setId(hospitalId);
			    
				MasEmployee laborDoctor = new MasEmployee();
				laborDoctor.setId(empId);
				
				MasDepartment laborDepartment = new MasDepartment();
				laborDepartment.setId(deptId);
				
				// Transferring mother 
				motherInpatientId =box.getInt("motherinpatientid");
			    Inpatient motherInpatient = new Inpatient();
			    motherInpatient.setId(motherInpatientId);
				int motherHindId = 0;
				int motherTransferDepartment = box.getInt("mothertoWard");
				int otDepartmentId = box.getInt("otDepartmentId");;
				int motherprocedureCount = box.getInt("motherProcCount");
				int motherCurrentWard = 0;
				OpdSurgeryHeader surHd=null;	
				List<Integer> surgeryDtIdList = new ArrayList<Integer>();

				List<Inpatient>	motherInpatientList = session.createCriteria(Inpatient.class)
                        .add(Restrictions.eq("Id", motherInpatientId)).list();
				
				Inpatient motherInpatientUpdate = (Inpatient) hbt.load(Inpatient.class , motherInpatientId);
				if(motherInpatientList.size()>0)
				{
					motherHindId = motherInpatientList.get(0).getHin().getId();
					motherCurrentWard = motherInpatientList.get(0).getDepartment().getId();
				}
				
				if(motherCurrentWard == motherTransferDepartment)
				{
					motherInpatientUpdate.setAdStatus("A");
				}
				
				else if(otDepartmentId == motherTransferDepartment)
				  {
					motherInpatientUpdate.setAdStatus("O");
					motherInpatientUpdate.setSurgeryStatus(null);
					
					Patient p =  new Patient();
					p.setId(motherHindId);
					
					  if(motherprocedureCount >0)
						   {
							for(int i= 1;i<=motherprocedureCount;i++)
							{
								   // Saving procedure in surgical tables
								int procedureId = 0;
								if(box.getString("procedureId"+i)!=null )
								{
									procedureId = box.getInt("procedureId"+i);
								}
							if(procedureId!=0)
							 {	
								if(i==1)
								{
									 //System.out.println("inpatient= "+box.getString("baby"+j+"InpatientId") +" procdureId="+ box.getString("baby"+j+"procedureId"+i));
									
									List<OpdSurgeryHeader>	opdSurgeryHeaderList = session.createCriteria(OpdSurgeryHeader.class)
					                        .add(Restrictions.eq("Inpatient.Id", motherInpatientId)).list();
									if(opdSurgeryHeaderList.size()==0)
										{
										surHd = new OpdSurgeryHeader();
										}
									else
									{
										surHd = opdSurgeryHeaderList.get(0);
									}
								
									surHd.setInpatient(motherInpatient);
									
									surHd.setPatientStatus("In Patient");
									surHd.setRequisitionDate(currentDate);
									surHd.setRequisitionTime(currentTime);
									surHd.setPrescribedDepartment(laborDepartment);
									surHd.setEmployee(laborDoctor);
									
									mapForDS.put("tableObjectName", "OpdSurgeryHeader");			
									mapForDS.put("isHospitalWise", "y");
									mapForDS.put("hospitalId", hospitalId);
									mapForDS.put("isYearly", "n");			
									mapForDS.put("isMonthly", "n");
									mapForDS.put("isPrefix", "n");
									
									int orderNo = orderNo = Integer.parseInt(HMSUtil.generateTransactionSequence(mapForDS, session, hbt));
									surHd.setOrderNo(orderNo);
									
									surHd.setHin(p);
									surHd.setHospital(hospital);
									surHd.setStatus("y");
									
									hbt.saveOrUpdate(surHd);
								}
						        OpdSurgeryDetail opdSurgeryDetail=new OpdSurgeryDetail();
								MasChargeCode masChargeCode=new MasChargeCode();
								masChargeCode.setId(procedureId);
								opdSurgeryDetail.setChargeCode(masChargeCode);
								opdSurgeryDetail.setOpdSurgery(surHd);
								opdSurgeryDetail.setAnestheisaPacStatus("y");
								opdSurgeryDetail.setSurgeryStatus("n");
								opdSurgeryDetail.setDepartment(laborDepartment);
								//opdSurgeryDetail.setTentativeDate(HMSUtil.dateFormatterDDMMYYYY(box.getString("tentativeDate"+l)));
								//opdSurgeryDetail.setRemarks(box.getString("procRemarks"+i));
								hbt.save(opdSurgeryDetail);
								surgeryDtIdList.add(opdSurgeryDetail.getId());
								
							  }
							}
							
							// Save data into pac hd and dt tables
							if(surgeryDtIdList.size() >0)
							{
								OtPreAnesthesiaHd pacHd = new OtPreAnesthesiaHd();
								pacHd.setInpatient(motherInpatient);
								pacHd.setHin(p);
								pacHd.setHospital(hospital);
								pacHd.setStatus("n");
								pacHd.setFitForSurgery("y");
								  hbt.save(pacHd);
								  
								for(int k: surgeryDtIdList)
								{
									OpdSurgeryDetail surDt = (OpdSurgeryDetail) hbt.load(OpdSurgeryDetail.class, k);
									OtPreAnesthesiaDetail pacDt = new OtPreAnesthesiaDetail();
									pacDt.setAnesthesiaHd(pacHd);
									pacDt.setStatus("n");
									pacDt.setOpdSurgeryDetail(surDt);
									hbt.save(pacDt);
									
									surDt.setAnestheisaPac(pacDt);
									hbt.update(surDt);
								}
								
							  }
							
						    } //procedure if	
				           } 
				
				else if(motherTransferDepartment!=0)
				  {	
					 motherInpatientUpdate.setAdStatus("A");
					 
					
					 int transferBedId = box.getInt("motherbedId");
					 
					 int transferedDoctorId = box.getInt("mothertoDoctor");;
					 int currentBedId = motherInpatientList.get(0).getBed().getId();
					 
					MasDepartment department = (MasDepartment) hbt.get(MasDepartment.class, motherTransferDepartment);
					
					MasBed masBed = new MasBed();
					masBed.setId(transferBedId);
					MasEmployee masEmp = (MasEmployee)  hbt.get(MasEmployee.class, transferedDoctorId);
					
					 
					 //Maintaining transfer transaction table
					 Transfer mothertransfer = new Transfer();
					  int motherTransferNo = 0;
						List<Integer> otSeqList = new ArrayList<Integer>();
						otSeqList = session.createCriteria(Transfer.class)
								   .setProjection(Projections.projectionList().add(Projections
										.max("TransferNo"))).list();
						
							for (Integer maxOrderNo : otSeqList) {
								if ( maxOrderNo != null) {
									motherTransferNo = maxOrderNo + 1;
								} else {
									motherTransferNo = Integer.valueOf(1);
								}
								break;
							}
					mothertransfer.setTransferNo(motherTransferNo);
					mothertransfer.setHin(motherInpatientList.get(0).getHin());
					mothertransfer.setAdNo(motherInpatientList.get(0).getAdNo());
					mothertransfer.setFromBed(motherInpatientList.get(0).getBed());
					mothertransfer.setFromDoctor(motherInpatientList.get(0).getDoctor());
					mothertransfer.setFromWard(motherInpatientList.get(0).getDepartment());
					mothertransfer.setToBed(masBed);
					mothertransfer.setToDoctor(masEmp);
					mothertransfer.setToWard(department);
					mothertransfer.setAdStatus("A");
					mothertransfer.setStatus("y");
					mothertransfer.setHospital(hospital);
					mothertransfer.setInpatient(motherInpatient);
					mothertransfer.setAddEditBy(user);
					mothertransfer.setAddEditDate(currentDate);
					mothertransfer.setAddEditTime(currentTime);
					mothertransfer.setDateOfTransfer(currentDate);
					mothertransfer.setTimeOfTransfer(currentTime);
					hbt.save(mothertransfer);
					
					
					//update mother inpatient
					
					// int currentBedId = box.getInt("baby"+j+"toDoctor");
					 motherInpatientUpdate.setDepartment(department);
					 motherInpatientUpdate.setBed(masBed);
					 motherInpatientUpdate.setDoctor(masEmp);
					 int bedstausUnOccupied = Integer.parseInt(HMSUtil.getValuesFromPropertiesFile("adt.properties", "bedStatusUnOccupiedId".trim()));
					 int bedstausOccupied = Integer.parseInt(HMSUtil.getValuesFromPropertiesFile("adt.properties", "bedStatusOccupiedId".trim()));
					 
					 MasBedStatus bedstatus = new MasBedStatus();
					 bedstatus.setId(bedstausOccupied);
					 
					 masBed = (MasBed) hbt.get(MasBed.class, transferBedId);
					 masBed.setBedStatus(bedstatus);
					 hbt.update(masBed);
					 
					 bedstatus.setId(bedstausUnOccupied);;
					 masBed = (MasBed) hbt.get(MasBed.class, currentBedId);
					 masBed.setBedStatus(bedstatus);
					 hbt.update(masBed);
					 
			
					
					
				  }
				
				 motherInpatientUpdate.setLrTransferStatus("y");
				 
				 hbt.update(motherInpatientUpdate);
			
				//capturing baby patient details 
				
			    int babyCount = 0;
			    if(box.getString("babyCount")!=null)
			    babyCount = box.getInt("babyCount");
					
					for(int j = 1;j<=babyCount;j++)
					{
						
						int babyInpatientId = 0;
						int babyHindId = 0;
						int babyTransferDepartment = 0;
						int babyId = box.getInt("baby"+j+"Id");
						
						int procedureCount =0;
						int babyCurrentWard = 0;
						
						surHd=null;	
					    surgeryDtIdList = new ArrayList<Integer>();
					
						babyHindId = box.getInt("baby"+j+"hinId");
						
						Patient p =  new Patient();
						p.setId(babyHindId);
						Inpatient babyInpatient = new Inpatient();
						
			
						List<BabyDetails>	babyInpatientList = session.createCriteria(BabyDetails.class)
		                        .add(Restrictions.eq("Id", babyId)).list();
						
			if(babyInpatientList.size()>0){
				
				Inpatient babyInpatientUpdate = null;
				if(babyInpatientList.get(0).getInpatient()!=null)
				{
				babyInpatientId = box.getInt("baby"+j+"InpatientId");
				procedureCount =box.getInt("baby"+j+"procCount");
				babyTransferDepartment = box.getInt("baby"+j+"toWard");
				babyCurrentWard = babyInpatientList.get(0).getInpatient().getDepartment().getId();
				babyInpatientUpdate = (Inpatient) hbt.load(Inpatient.class , babyInpatientId);
				babyInpatient.setId(babyInpatientId);
				}
				 
				 
				 
				 if(babyInpatientList.get(0).getInpatient()==null && (!babyInpatientList.get(0).getLiveStillBorn().equalsIgnoreCase("live") || !babyInpatientList.get(0).getLiveStillBorn().equalsIgnoreCase("Live cyanosed") ))
				 {
					
					 MortuaryDetails mdt = new MortuaryDetails();
					 mdt.setHin(p);
					 mdt.setDeadDepartment("Labor Room");
					 hbt.save(mdt);
					 
				 }
				 
				 else if(babyCurrentWard == babyTransferDepartment)
				{
					babyInpatientUpdate.setAdStatus("A");
				}
				
				else if(otDepartmentId == babyTransferDepartment)
				  {	
					babyInpatientUpdate.setAdStatus("O");
					  if(procedureCount >0)
						   {
							for(int i= 1;i<=procedureCount;i++)
							{
								   // Saving procedure in surgical tables
								int procedureId = 0;
								if(box.getString("baby"+j+"procedureId"+i)!=null )
								{
									procedureId = box.getInt("baby"+j+"procedureId"+i);
								}
							if(procedureId!=0)
							 {	
								if(i==1)
								{
									 
									
									List<OpdSurgeryHeader>	opdSurgeryHeaderList = session.createCriteria(OpdSurgeryHeader.class)
					                        .add(Restrictions.eq("Inpatient.Id", babyInpatientId)).list();
									if(opdSurgeryHeaderList.size()==0)
										{
										surHd = new OpdSurgeryHeader();
										}
									else
									{
										surHd = opdSurgeryHeaderList.get(0);
									}
								
									surHd.setInpatient(babyInpatient);
									
									surHd.setPatientStatus("In Patient");
									surHd.setRequisitionDate(currentDate);
									surHd.setRequisitionTime(currentTime);
									surHd.setPrescribedDepartment(laborDepartment);
									surHd.setEmployee(laborDoctor);
									
									mapForDS.put("tableObjectName", "OpdSurgeryHeader");			
									mapForDS.put("isHospitalWise", "y");
									mapForDS.put("hospitalId", hospitalId);
									mapForDS.put("isYearly", "n");			
									mapForDS.put("isMonthly", "n");
									mapForDS.put("isPrefix", "n");
									
									int orderNo = orderNo = Integer.parseInt(HMSUtil.generateTransactionSequence(mapForDS, session, hbt));
									surHd.setOrderNo(orderNo);
									
									surHd.setHin(p);
									surHd.setHospital(hospital);
									surHd.setStatus("y");
									
									hbt.saveOrUpdate(surHd);
								}
						        OpdSurgeryDetail opdSurgeryDetail=new OpdSurgeryDetail();
								MasChargeCode masChargeCode=new MasChargeCode();
								masChargeCode.setId(procedureId);
								opdSurgeryDetail.setChargeCode(masChargeCode);
								opdSurgeryDetail.setOpdSurgery(surHd);
								opdSurgeryDetail.setAnestheisaPacStatus("y");
								opdSurgeryDetail.setSurgeryStatus("n");
								opdSurgeryDetail.setDepartment(laborDepartment);
								//opdSurgeryDetail.setTentativeDate(HMSUtil.dateFormatterDDMMYYYY(box.getString("tentativeDate"+l)));
								//opdSurgeryDetail.setRemarks(box.getString("procRemarks"+i));
								hbt.save(opdSurgeryDetail);
								surgeryDtIdList.add(opdSurgeryDetail.getId());
								
							  }
							}
							
							// Save data into pac hd and dt tables
							if(surgeryDtIdList.size() >0)
							{
								OtPreAnesthesiaHd pacHd = new OtPreAnesthesiaHd();
								pacHd.setInpatient(babyInpatient);
								pacHd.setHin(p);
								pacHd.setHospital(hospital);
								pacHd.setStatus("n");
								pacHd.setFitForSurgery("y");
								  hbt.save(pacHd);
								  
								for(int k: surgeryDtIdList)
								{
									OpdSurgeryDetail surDt = (OpdSurgeryDetail) hbt.load(OpdSurgeryDetail.class, k);
									OtPreAnesthesiaDetail pacDt = new OtPreAnesthesiaDetail();
									pacDt.setAnesthesiaHd(pacHd);
									pacDt.setStatus("n");
									pacDt.setOpdSurgeryDetail(surDt);
									hbt.save(pacDt);
									
									surDt.setAnestheisaPac(pacDt);
									hbt.update(surDt);
								}
								
							  }
							
						    } //procedure if	
				           } 
				
				else if(babyTransferDepartment!=0)
				  {	
					babyInpatientUpdate.setAdStatus("A");
					 int transferBedId = box.getInt("baby"+j+"bedId");;
					 int transferedDoctorId = box.getInt("baby"+j+"toDoctor");;
					 int currentBedId = babyInpatientList.get(0).getInpatient().getBed().getId();
					 
					MasDepartment department = new MasDepartment();
					department.setId(babyTransferDepartment);
					MasBed masBed = new MasBed();
					masBed.setId(transferBedId);
					MasEmployee masEmp = new MasEmployee();
					masEmp.setId(transferedDoctorId);
					
					// int currentBedId = box.getInt("baby"+j+"toDoctor");
					 
					 //Maintaining transfer transaction table for baby
					 Transfer babytransfer = new Transfer();
					  int babytransferNo = 0;
						List<Integer> otSeqList = new ArrayList<Integer>();
						otSeqList = session.createCriteria(Transfer.class)
								   .setProjection(Projections.projectionList().add(Projections
										.max("TransferNo"))).list();
						
							for (Integer maxOrderNo : otSeqList) {
								if ( maxOrderNo != null) {
									babytransferNo = maxOrderNo + 1;
								} else {
									babytransferNo = Integer.valueOf(1);
								}
								break;
							}
					babytransfer.setTransferNo(babytransferNo);
					babytransfer.setHin(babyInpatientList.get(0).getInpatient().getHin());
					babytransfer.setAdNo(babyInpatientList.get(0).getInpatient().getAdNo());
					babytransfer.setFromBed(babyInpatientList.get(0).getInpatient().getBed());
					babytransfer.setFromDoctor(babyInpatientList.get(0).getInpatient().getDoctor());
					babytransfer.setFromWard(babyInpatientList.get(0).getInpatient().getDepartment());
					babytransfer.setToBed(masBed);
					babytransfer.setToDoctor(masEmp);
					babytransfer.setToWard(department);
					
					babytransfer.setAdStatus("A");
					babytransfer.setStatus("y");
					babytransfer.setHospital(hospital);
					babytransfer.setInpatient(babyInpatientList.get(0).getInpatient());
					babytransfer.setAddEditBy(user);
					babytransfer.setAddEditDate(currentDate);
					babytransfer.setAddEditTime(currentTime);
					babytransfer.setDateOfTransfer(currentDate);
					babytransfer.setTimeOfTransfer(currentTime);
					 
					hbt.save(babytransfer);
					
					//update baby patient
					
					 babyInpatientUpdate.setDepartment(department);
					 babyInpatientUpdate.setBed(masBed);
					 babyInpatientUpdate.setDoctor(masEmp);
					 
					 int bedstausUnOccupied = Integer.parseInt(HMSUtil.getValuesFromPropertiesFile("adt.properties", "bedStatusUnOccupiedId".trim()));
					 int bedstausOccupied = Integer.parseInt(HMSUtil.getValuesFromPropertiesFile("adt.properties", "bedStatusOccupiedId".trim()));
					 
					 MasBedStatus bedstatus = new MasBedStatus();
					 bedstatus.setId(bedstausOccupied);
					 
					 masBed = (MasBed) hbt.get(MasBed.class, transferBedId);
					 masBed.setBedStatus(bedstatus);
					 hbt.update(masBed);
					 
					 bedstatus.setId(bedstausUnOccupied);;
					 masBed = (MasBed) hbt.get(MasBed.class, currentBedId);
					 masBed.setBedStatus(bedstatus);
					 hbt.update(masBed);
					 
					
				  }
				 if(babyInpatientUpdate!=null)
				 {
				   //babyInpatientUpdate.setAdStatus("A");
				   hbt.update(babyInpatientUpdate);
				 }
				//update babyinpatient
						  }//checking baby inpatient List >0
						} //baby count loop
					tx.commit();
					saved = true;
			} 
		    catch (Exception e) {
							saved = false;
							tx.rollback();
							e.printStackTrace();
						}
			finally {
				// --------Session Closing----------
				session.close();
			}
			
			map.put("saved", saved);
			
			return map;
		}
		
}
