package jkt.hms.mediClaim.dataservice;

import static jkt.hms.util.RequestConstants.AMOUNT;
import static jkt.hms.util.RequestConstants.BILL_DATE;
import static jkt.hms.util.RequestConstants.BILL_NO;
import static jkt.hms.util.RequestConstants.CHARGE_NAME;
import static jkt.hms.util.RequestConstants.CONTINGENT_BILL_HD_ID;
import static jkt.hms.util.RequestConstants.DEPARTMENT_ID;
import static jkt.hms.util.RequestConstants.DETAILS;
import static jkt.hms.util.RequestConstants.DISPATCH;
import static jkt.hms.util.RequestConstants.ENTRY_NO;
import static jkt.hms.util.RequestConstants.FROM;
import static jkt.hms.util.RequestConstants.HIN_ID;
import static jkt.hms.util.RequestConstants.TO;
import static jkt.hms.util.RequestConstants.UNIT_ID;

import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;

import jkt.hms.masters.business.DgMasInvestigation;
import jkt.hms.masters.business.DgOrderhd;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.MasCaseType;
import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasIcd;
import jkt.hms.masters.business.MasMedicalExaminationReportOnEntry;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasReference;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.MdBillMovement;
import jkt.hms.masters.business.MdCardicClaimAdvance;
import jkt.hms.masters.business.MdCardicContingentBillDt;
import jkt.hms.masters.business.MdCardicContingentBillHd;
import jkt.hms.masters.business.MdContigentMedicalBillDt;
import jkt.hms.masters.business.MdContigentMedicalBillHd;
import jkt.hms.masters.business.MdCoveringLetterUnitDt;
import jkt.hms.masters.business.MdCoveringLetterUnitHd;
import jkt.hms.masters.business.MdGeneralCoveringDt;
import jkt.hms.masters.business.MdGeneralCoveringHd;
import jkt.hms.masters.business.MdMasAuthority;
import jkt.hms.masters.business.MdSpecialInvestigationDt;
import jkt.hms.masters.business.MdSpecialInvestigationHd;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.TransactionSequence;
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
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class MedicalClaimDataServiceImpl extends HibernateDaoSupport implements MedicalClaimDataService
{
   public Map<String, Object> showAuthorityJsp()
   {
      Map<String, Object> map = new HashMap<String, Object>();
      List<MdMasAuthority> searchAuthorityList = new ArrayList<MdMasAuthority>();
      searchAuthorityList = getHibernateTemplate().find("from jkt.hms.masters.business.MdMasAuthority ");
      map.put("searchAuthorityList", searchAuthorityList);
      return map;
   }

   public boolean addAuthority(MdMasAuthority masAuthority)
   {
      boolean successfullyAdded = false;
      org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
      hbt.setFlushModeName("FLUSH_AUTO");
      hbt.setCheckWriteOperations(false);
      hbt.save(masAuthority);
      successfullyAdded = true;
      return successfullyAdded;
   }

   public boolean deleteAuthority(int authorityId, Map<String, Object> generalMap)
   {
      boolean dataDeleted = false;
      String changedBy = "";
      Date currentDate = new Date();
      String currentTime = "";
      currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
      MdMasAuthority masAuthority = new MdMasAuthority();
      masAuthority = (MdMasAuthority) getHibernateTemplate().get(MdMasAuthority.class, authorityId);
      changedBy = (String) generalMap.get("changedBy");
      currentDate = (Date) generalMap.get("currentDate");
      currentTime = (String) generalMap.get("currentTime");
      if (generalMap.get("flag") != null)
      {
         String flag = (String) generalMap.get("flag");
         if (flag.equals("InActivate"))
         {
            masAuthority.setStatus("n");
            dataDeleted = true;
         } else if (flag.equals("Activate"))
         {
            masAuthority.setStatus("y");
            dataDeleted = false;
         }
      }
      masAuthority.setLastChgBy(changedBy);
      masAuthority.setLastChgDate(currentDate);
      masAuthority.setLastChgTime(currentTime);
      org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
      hbt.setFlushModeName("FLUSH_EAGER");
      hbt.setCheckWriteOperations(false);
      hbt.update(masAuthority);
      return dataDeleted;

   }

   public boolean editAuthority(Map<String, Object> generalMap)
   {
      boolean dataUpdated = false;
      Date currentDate = new Date();
      String currentTime = "";
      currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
      String authorityName = "";
      @SuppressWarnings("unused")
      String authorityCode = "";
      int authorityId = 0;
      String changedBy = "";
      authorityId = (Integer) generalMap.get("id");
      authorityCode = (String) generalMap.get("caseTypeCode");
      authorityName = (String) generalMap.get("name");
      changedBy = (String) generalMap.get("changedBy");
      currentDate = (Date) generalMap.get("currentDate");
      currentTime = (String) generalMap.get("currentTime");
      MdMasAuthority masAuthority = (MdMasAuthority) getHibernateTemplate().get(MdMasAuthority.class, authorityId);

      masAuthority.setId(authorityId);
      masAuthority.setAuthorityName(authorityName);
      masAuthority.setLastChgBy(changedBy);
      masAuthority.setLastChgDate(currentDate);
      masAuthority.setLastChgTime(currentTime);
      org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
      hbt.setFlushModeName("FLUSH_EAGER");
      hbt.setCheckWriteOperations(false);
      hbt.update(masAuthority);
      dataUpdated = true;
      return dataUpdated;

   }

   public Map<String, Object> searchAuthority(String authorityCode, String authorityName)
   {
      List<MasCaseType> searchAuthorityList = new ArrayList<MasCaseType>();
      Map<String, Object> authorityFieldsMap = new HashMap<String, Object>();
      try
      {
         if ((authorityName != null) || (authorityCode == null))
         {
            searchAuthorityList = getHibernateTemplate().find(
                  "from jkt.hms.masters.business.MdMasAuthority imc where imc.AuthorityName like '" + authorityName
                        + "%' order by imc.AuthorityName");
         } else
         {
            searchAuthorityList = getHibernateTemplate().find(
                  "from jkt.hms.masters.business.MdMasAuthority imc where imc.AuthorityCode like '" + authorityCode
                        + "%' order by imc.AuthorityCode");
         }
      } catch (Exception e)
      {
         e.printStackTrace();
      }
      authorityFieldsMap.put("searchAuthorityList", searchAuthorityList);
      return authorityFieldsMap;
   }

   public Map<String, Object> showPatientSearchForSpecialinvestigationJsp()
   {
      Map<String, Object> map = new HashMap<String, Object>();
      List<MasRank> rankList = new ArrayList<MasRank>();
      List<MasReference> masReffenceList = new ArrayList<MasReference>();
      Session session = (Session) getSession();
      try
      {
    	  masReffenceList = session.createCriteria(MasReference.class).addOrder(Order.asc("ReferenceName")).list();
         rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankName")).list();
         map.put("rankList", rankList);
         map.put("masReffenceList", masReffenceList);
      } catch (Exception e)
      {
         e.printStackTrace();
      }
      return map;
   }

   public Map<String, Object> getPatientDetails(Map<String, Object> mapForDs)
   {
      Map<String, Object> patientMap = new HashMap<String, Object>();
      List<Patient> patientList = new ArrayList<Patient>();
      String serviceNo = "";
      String hinNo = "";
      int rankId = 0;
      String serPersonFName = "";
      String serPersonLName = "";
      String patientFName = "";
      String patientLName = "";
      @SuppressWarnings("unused")
      int hinId = 0;
      Session session = (Session) getSession();

      if (mapForDs.get("serviceNo") != null)
      {
         serviceNo = (String) mapForDs.get("serviceNo");
      }
      if (mapForDs.get("hinNo") != null)
      {
         hinNo = (String) mapForDs.get("hinNo");
      }
      if (mapForDs.get("rankId") != null)
      {
         rankId = (Integer) mapForDs.get("rankId");
      }
      /*
       * if (mapForDs.get("patientStatus") != null) { patientStatus = (String)
       * mapForDs.get("patientStatus"); }
       */
      if (mapForDs.get("serPersonFName") != null)
      {
         serPersonFName = (String) mapForDs.get("serPersonFName");
      }
      if (mapForDs.get("serPersonLName") != null)
      {
         serPersonLName = (String) mapForDs.get("serPersonLName");
      }
      if (mapForDs.get("patientFName") != null)
      {
         patientFName = (String) mapForDs.get("patientFName");
      }
      if (mapForDs.get("patientLName") != null)
      {
         patientLName = (String) mapForDs.get("patientLName");
      }
      if (mapForDs.get("hinId") != null)
      {
         hinId = (Integer) mapForDs.get("hinId");
      }

      try
      {
      
      StringBuffer hqlQuery=new StringBuffer("");
      
      
      hqlQuery.append("select p.Id,p.ServiceNo,p.HinNo,p.PFirstName,p.PLastName,p.Rank,p.PatientStatus from Patient p where p.PatientStatus!='expired' ");
    	  
    	  
  			if(!serviceNo.equals("") ){
  				hqlQuery.append("and p.ServiceNo like '%"+serviceNo+"%' ");
  			}
  			if(!hinNo.equals("")){
  				hqlQuery.append("and p.HinNo like '%"+hinNo+"%' ");
  			}
  			if(!patientFName.equals("")){
  				hqlQuery.append("and p.PFirstName like '"+patientFName+"%' ");
			}
			if(!patientLName.equals("")){
				hqlQuery.append("and p.PLastName like '"+patientLName+"%' ");
			}
			
			 if(rankId != 0){
					hqlQuery.append("and p.Rank.Id = "+rankId+"");
				}
       List<Object> list=( List<Object>)session.createQuery(hqlQuery.toString()).list();
     
       for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Patient patient =new Patient();
			
			Object[] object = (Object[]) iterator.next();
			patient.setId((Integer)object[0]);
			if(object[1]!=null)
			patient.setServiceNo((String)object[1]);
			if(object[2]!=null)
			patient.setHinNo((String)object[2]);
			if(object[3]!=null)
			patient.setPFirstName((String)object[3]);
			if(object[4]!=null)
				patient.setPLastName((String)object[4]);
			if(object[5]!=null){
				patient.setRank((MasRank)object[5]);
			}
			/*if(object[6]!=null)
				patient.setPatientStatus((String)object[6]);*/
			patientList.add(patient);
		
       
      } }catch (Exception e)
      {
         e.printStackTrace();
      }

      patientMap.put("patientList", patientList);
      return patientMap;
   }

   @SuppressWarnings("unchecked")
   public Map<String, Object> getPatientforInvestigationDetails(int hinId)
   {
      Map<String, Object> map = new HashMap<String, Object>();
      List<MasHospital> hospitalList = new ArrayList<MasHospital>();
      List<MasChargeCode> chargeList = new ArrayList<MasChargeCode>();
      List<Patient> patientList = new ArrayList<Patient>();
      List<MasReference> masReffenceList = new ArrayList<MasReference>();
      Session session = (Session) getSession();
      hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).list();
      patientList = session.createCriteria(Patient.class).add(Restrictions.eq("Id", hinId)).add(Restrictions.not(Restrictions.eq("PatientStatus", "Expired"))).list();

	  /*masReffenceList = getHibernateTemplate().find(
              "from jkt.hms.masters.business.MasReference imc order by imc.ReferenceName");*/
	  masReffenceList =session.createCriteria(MasReference.class).addOrder(Order.asc("ReferenceName")).list();
      map.put("patientList", patientList);
      map.put("hospitalList", hospitalList);
      map.put("masReffenceList", masReffenceList);

      return map;
   }

   public Map<String, Object> getChargeName(Map<String, Object> parameterMap)
   {
      Map<String, Object> detailsMap = new HashMap<String, Object>();
      List<MasChargeCode> chargeList = new ArrayList<MasChargeCode>();
   //   String testType=(String)parameterMap.get("testType") ;
     /* String str = "";
      if (parameterMap.get("autoHint") != null)
      {
         str = parameterMap.get("autoHint") + "%";
      }*/
      try
      {
         Session session = (Session) getSession();
        /* if(testType.equals("MEDCLAIMS")){
        	 chargeList = session.createCriteria(MasChargeCode.class).add(Restrictions.like("ChargeCodeName", str))
        	 			.createAlias("Department", "dept").add(Restrictions.eq("dept.DepartmentName","Medical Claims" ))
        	 			.createAlias("SubChargecode", "scc").add(Restrictions.eq("scc.SubChargecodeName","General Claims")).list();
        	 
        	 chargeList = session.createCriteria(MasChargeCode.class).add(Restrictions.like("ChargeCodeName", str))
	 			.createAlias("Department", "dept").add(Restrictions.eq("dept.DepartmentName","Statistics" ))
	 			.createAlias("SubChargecode", "scc").add(Restrictions.eq("scc.SubChargecodeName","General Claims")).list();	 
         }else{
        	 
        	 chargeList = session.createCriteria(MasChargeCode.class).add(Restrictions.like("ChargeCodeName", str)).list();
         }----------Commented By dipali as discuss with Girjesh Sir*/
         try {
 			// int deptId=(Integer)mapForDS.get("deptId");

 			String str = "%" + parameterMap.get("autoHint") + "%";
 			String chargeType = "DIAG";
 			
 			chargeList=getHibernateTemplate().find("select mcc from jkt.hms.masters.business.DgMasInvestigation as dmi join dmi.ChargeCode as mcc join mcc.ChargeType as ct where ct.ChargeTypeCode='"+chargeType+"' and  upper(mcc.ChargeCodeName) like upper('"+str+"') ");
 			
 			
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
         if (chargeList.size() > 0)
         {
            detailsMap.put("chargeCodeList", chargeList);
         }
      } catch (DataAccessResourceFailureException e)
      {
         e.printStackTrace();
      } catch (HibernateException e)
      {
         e.printStackTrace();
      } catch (IllegalStateException e)
      {
         e.printStackTrace();
      }
      return detailsMap;
   }

   public Map<String, Object> fillItemsForChargeName(Map<String, Object> dataMap)
   {
      Map<String, Object> map = new HashMap<String, Object>();

      List chargeList = new ArrayList();
      Session session = (Session) getSession();
      String chargeName = (String) dataMap.get("chargeName");
      try
      {
         org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
         hbt.setFlushModeName("FLUSH_EAGER");
         hbt.setCheckWriteOperations(false);
         chargeList = session.createCriteria(MasChargeCode.class).add(Restrictions.eq("ChargeCodeName", chargeName))
               .list();
         map.put("chargeList", chargeList);

      } catch (Exception e)
      {
         e.printStackTrace();
      }
      return map;
   }

   public Map<String, Object> getDiagnosis(Map<String, Object> parameterMap)
   {
      Map<String, Object> map = new HashMap<String, Object>();
      List<MasIcd> diagnosisList = new ArrayList<MasIcd>();

      String str = "";
      if (parameterMap.get("autoHint") != null)
      {
         str = parameterMap.get("autoHint") + "%";
      }
      try
      {
         Session session = (Session) getSession();
         diagnosisList = session.createCriteria(MasIcd.class).add(Restrictions.like("IcdName", str)).add(
               Restrictions.like("Status", "y")).list();

         if (diagnosisList.size() > 0)
         {
            map.put("diagnosisList", diagnosisList);
         }
      } catch (DataAccessResourceFailureException e)
      {
         e.printStackTrace();
      } catch (HibernateException e)
      {
         e.printStackTrace();
      } catch (IllegalStateException e)
      {
         e.printStackTrace();
      }
      return map;
   }
   
   public Map<String,Object> submitSpecialinvestigation(Map<String, Object> infoMap)
   {
      MdSpecialInvestigationHd specialInvestigationHd = new MdSpecialInvestigationHd();
      String userName = "";
      boolean saved = false;
      boolean flag = false;
      Map<String,Object> map=new HashMap<String,Object>();
      Session session = (Session)getSession();
      List chargeList = new ArrayList();
      List specialDetailIdList = new ArrayList();
      String []yearlyNo=null;
      int hinId = 0;
      int hospitalId = 0;
      int inpatientId = 0;

      if (infoMap.get("specialInvestigationHd") != null)
      {
         specialInvestigationHd = (MdSpecialInvestigationHd) infoMap.get("specialInvestigationHd");
      }

      if (infoMap.get("hinId") != null)
      {
         hinId = (Integer) infoMap.get("hinId");
      }
      if (infoMap.get("userName") != null)
      {
         userName = (String) infoMap.get("userName");
      }
      if (infoMap.get("hospitalId") != null)
      {
         hospitalId = (Integer) infoMap.get("hospitalId");
      }
      if (infoMap.get("specialDetailIdList") != null)
      {
         specialDetailIdList = (List) infoMap.get("specialDetailIdList");
      }
      MasHospital hospital = new MasHospital();
      hospital.setId(hospitalId);

      org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
      hbt.setFlushModeName("FLUSH_EAGER");
      hbt.setCheckWriteOperations(false);
      List<TransactionSequence> tranSeq = session.createCriteria(TransactionSequence.class).add(Restrictions.eq("Tablename", "MdSpecialInvestigationHd")).list();
      Map<String, Object> utilMap = new HashMap<String, Object>();
      utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
      String date = (String) utilMap.get("currentDate");
      String time = (String) utilMap.get("currentTime");
      Date changeDate = HMSUtil.convertStringTypeDateToDateType(date);
      String entryNo =specialInvestigationHd.getYearlyNo();
      yearlyNo=entryNo.split("/");
      int numberS=Integer.parseInt(yearlyNo[0]);
      int numberT=tranSeq.get(0).getTransactionSequenceNumber()+1;
      entryNo = ""+numberT+"/"+yearlyNo[1];
      specialInvestigationHd.setYearlyNo(entryNo);
      specialInvestigationHd.setStatus("p");
      TransactionSequence transactionSequence = (TransactionSequence)tranSeq.get(0);
      transactionSequence.setTransactionSequenceNumber(numberT);
      try
      {
         hbt.save(specialInvestigationHd);
         hbt.saveOrUpdate(transactionSequence);
        
      
      } catch (DataAccessException e)
      {
         e.printStackTrace();
      }
      try
      {
         if (infoMap.get("chargeList") != null)
         {
            chargeList = (List) infoMap.get("chargeList");
            try
            {
               if (chargeList.size() > 0)
               {
                  for (int i = 0; i < chargeList.size(); i++)
                  {
                     MdSpecialInvestigationDt specialInvestigationDt = new MdSpecialInvestigationDt();
                     MasChargeCode masChargeCode = new MasChargeCode();
                     if (chargeList.get(i) != null && !chargeList.get(i).equals(""))
                     {
                        int chargeId = Integer.parseInt(chargeList.get(i).toString());
                        masChargeCode.setId(chargeId);
                        specialInvestigationDt.setCharge(masChargeCode);

                        specialInvestigationDt.setSpecialInv(specialInvestigationHd);
                        try
                        {
                           hbt.save(specialInvestigationDt);
                        } catch (Exception e)
                        {
                           e.printStackTrace();
                        }
                     }

                     else if (!specialDetailIdList.get(i).toString().equals(""))
                     {
                        MdSpecialInvestigationDt specialInvDt = (MdSpecialInvestigationDt) hbt
                              .load(MdSpecialInvestigationDt.class, (Integer.parseInt(specialDetailIdList.get(i)
                                    .toString())));
                        hbt.update(specialInvDt);

                     }
                  }
               }
            } catch (DataAccessException e)
            {
               e.printStackTrace();
            }
         }
         
         saved = true;
      } catch (NumberFormatException e)
      {
         e.printStackTrace();
      }
      map.put("Id",specialInvestigationHd.getId());
      map.put("saved", saved);
      return map;
   }

   // ---------Method for get Unit Name------
   @SuppressWarnings("unchecked")
   public Map<String, Object> getUnitName(Map<String, Object> parameterMap)
   {
      Map<String, Object> map = new HashMap<String, Object>();
      List<MasUnit> unitList = new ArrayList<MasUnit>();

      String str = "";
      if (parameterMap.get("autoHint") != null)
      {
         str = "%" + parameterMap.get("autoHint") + "%";
      }
      try
      {
         Session session = (Session) getSession();
         unitList = session.createCriteria(MasUnit.class).add(Restrictions.like("UnitName", str)).add(
               Restrictions.like("Status", "y")).list();
         if (unitList.size() > 0)
         {
            map.put("unitList", unitList);
         }
      } catch (DataAccessResourceFailureException e)
      {
         e.printStackTrace();
      } catch (HibernateException e)
      {
         e.printStackTrace();
      } catch (IllegalStateException e)
      {
         e.printStackTrace();
      }
      return map;
   }

  /* public Map<String, Object> showPatientSearchForContingentBill()
   {
      Map<String, Object> map = new HashMap<String, Object>();
      List<MasRank> rankList = new ArrayList<MasRank>();
      Session session = (Session) getSession();
      try
      {
         rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).list();
         map.put("rankList", rankList);
      } catch (Exception e)
      {
         e.printStackTrace();
      }
      return map;
   }*/
   
   public Map<String, Object> showPatientSearchForContingentBill()
   {
      Map<String, Object> map = new HashMap<String, Object>();
      List<MasRank> rankList = new ArrayList<MasRank>();
      Session session = (Session) getSession();
      Date date=new Date();
      SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
      String currentDate=sdf.format(date);
      String from_Date=currentDate.substring(0,2)+"/"+(Integer.parseInt(currentDate.substring(3,5))-1)+"/"+currentDate.substring(6);
      Date fromDate=HMSUtil.dateFormatterDDMMYYYY(from_Date);
      Date toDate=HMSUtil.dateFormatterDDMMYYYY(currentDate);
      List<MdSpecialInvestigationHd> patientList=null;
      try
      {
         rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankName")).list();
         map.put("rankList", rankList);
         patientList= session.createCriteria(MdSpecialInvestigationHd.class)
                                       .add(Restrictions.between("SpecialDate", fromDate, toDate)) 
                                       .add(Restrictions.eq("Status","p" )).list();
      } catch (Exception e)
      {
         e.printStackTrace();
      }
      map.put("patientList", patientList);
      return map;
   }
   public Map<String, Object> getPatientDetailsForContingentBill(Map<String, Object> mapForDs)
   {
      Map<String, Object> map = new HashMap<String, Object>();
      List<MdSpecialInvestigationHd> patientList = new ArrayList<MdSpecialInvestigationHd>();

      String serviceNo = "";
      String hinNo = "";
      String serPersonFName = "";
      String serPersonLName = "";
      String patientFName = "";
      String patientLName = "";
      String patientStatus = "";
      int rankId=0;
      int hinId = 0;
      int specInvHdId = 0;
      Session session = (Session) getSession();

      if (mapForDs.get("serviceNo") != null)
      {
         serviceNo = (String) mapForDs.get("serviceNo");
      }
      if (mapForDs.get("hinNo") != null)
      {
         hinNo = (String) mapForDs.get("hinNo");
      }
      if (mapForDs.get("rankId") != null)
      {
    	  rankId = (Integer) mapForDs.get("rankId");
      }
      if (mapForDs.get("serPersonFName") != null)
      {
         serPersonFName = (String) mapForDs.get("serPersonFName");
      }
      if (mapForDs.get("serPersonLName") != null)
      {
         serPersonLName = (String) mapForDs.get("serPersonLName");
      }
      if (mapForDs.get("patientFName") != null)
      {
         patientFName = (String) mapForDs.get("patientFName");
      }
      if (mapForDs.get("patientLName") != null)
      {
         patientLName = (String) mapForDs.get("patientLName");
      }
      if (mapForDs.get("specInvHdId") != null)
      {
         specInvHdId = (Integer) mapForDs.get("specInvHdId");
      }
      if (mapForDs.get("hinId") != null)
      {
         hinId = (Integer) mapForDs.get("hinId");
      }
      Criteria crit = session.createCriteria(MdSpecialInvestigationHd.class).createAlias("Hin", "hn")
                        .add(Restrictions.eq("Status","p" ));
      if (!serviceNo.equals(""))
      {
         String str = serviceNo + "%";
         crit = crit.add(Restrictions.like("hn.ServiceNo", str));
      }
      if (!hinNo.equals(""))
      {
         crit = crit.add(Restrictions.like("hn.HinNo", hinNo + "%"));
      }
      if (!patientFName.equals(""))
      {
         crit = crit.add(Restrictions.like("hn.PFirstName", patientFName + "%"));
      }
      if (!patientLName.equals(""))
      {
         crit = crit.add(Restrictions.like("hn.PLastName", patientLName + "%"));
      }
      if (!serPersonFName.equals(""))
      {
         crit = crit.add(Restrictions.like("hn.SFirstName", serPersonFName + "%"));
      }
      if (!serPersonLName.equals(""))
      {
         crit = crit.add(Restrictions.like("hn.SLastName", serPersonLName + "%"));
      }
      if (rankId!=0)
      {
         crit = crit.createAlias("hn.Rank", "rank").add(Restrictions.eq("rank.Id", rankId));
      }
      patientList = crit.list();
      map.put("patientList", patientList);
      return map;
   }

   @SuppressWarnings("unchecked")
   public Map<String, Object> getPatientForContingentBillDetails(int specInvHdId)
   {
      Map<String, Object> map = new HashMap<String, Object>();
      List<MdMasAuthority> authorityList = new ArrayList<MdMasAuthority>();
      List<MasChargeCode> chargeList = new ArrayList<MasChargeCode>();
      List<Patient> patientList = new ArrayList<Patient>();
      List<MdSpecialInvestigationHd> specialInvHdList = new ArrayList<MdSpecialInvestigationHd>();
      Session session = (Session) getSession();
      authorityList = session.createCriteria(MdMasAuthority.class).add(Restrictions.eq("Status", "y")).list();
      chargeList = session.createCriteria(MasChargeCode.class).add(Restrictions.eq("Status", "y")).list();
      specialInvHdList = session.createCriteria(MdSpecialInvestigationHd.class).add(
            Restrictions.eq("Id", (Integer) map.get("specInvHdId"))).list();
      if (specialInvHdList != null && specialInvHdList.size() > 0)
      {
         map.put("specialInvHdList", specialInvHdList);
      }
      map.put("authorityList", authorityList);
      map.put("chargeList", chargeList);
      return map;
   }

   @SuppressWarnings("unchecked")
   public Map<String, Object> getPatientForContingentBillDetails(Map<String, Object> mapForDs)
   {
	   Map<String, Object> map = new HashMap<String, Object>();
	   //List<MdMasAuthority> authorityList = new ArrayList<MdMasAuthority>();
	   List<MasChargeCode> chargeList = new ArrayList<MasChargeCode>();
	   List<Patient> patientList = new ArrayList<Patient>();
	   List<MdSpecialInvestigationDt> masInvestigationDtList = new ArrayList<MdSpecialInvestigationDt>();
	   List<MasEmployee> employeeList = new ArrayList<MasEmployee>();

	   MdSpecialInvestigationHd specialInvestigationHd = new MdSpecialInvestigationHd();
	   List<MdSpecialInvestigationHd> specialInvHdList = new ArrayList<MdSpecialInvestigationHd>();
	   List<MdSpecialInvestigationDt> specialInvestigationDtList = new ArrayList<MdSpecialInvestigationDt>();
	   int hinId = 0;
	   int Id=(Integer) mapForDs.get("specInvHdId");
	   int hospitalId=(Integer) mapForDs.get("hospitalId");

	   Properties properties = new Properties();
	   URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
	   try {
		   properties.load(resourcePath.openStream());
	   } catch (Exception e) {
		   e.printStackTrace();
	   }
	   String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");

	   Session session = (Session) getSession();
	   //   authorityList = session.createCriteria(MdMasAuthority.class).add(Restrictions.eq("Status", "y")).list();
	   employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).createAlias("EmpCategory", "ec",CriteriaSpecification.LEFT_JOIN)
	   				.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId)).add(Restrictions.eq("ec.EmpCategoryCode", empCategoryCodeForDoctor)).addOrder(Order.asc("FirstName")).list();
	   chargeList = session.createCriteria(MasChargeCode.class).add(Restrictions.eq("Status", "y")).list();
	   masInvestigationDtList = getHibernateTemplate().find(
			   "from jkt.hms.masters.business.MdSpecialInvestigationDt imc where imc.SpecialInv.Id='"+Id+"'");
	   if (mapForDs != null && mapForDs.size() > 0)
		   specialInvHdList = session.createCriteria(MdSpecialInvestigationHd.class).add(
				   Restrictions.eq("Id", (Integer) mapForDs.get("specInvHdId"))).list();
	   if (specialInvHdList != null && specialInvHdList.size() > 0)
	   {
		   map.put("specialInvHdList", specialInvHdList);
	   }

	   hinId = specialInvHdList.get(0).getHin().getId();
	   patientList = session.createCriteria(Patient.class).add(Restrictions.eq("Id", hinId)).add(Restrictions.not(Restrictions.eq("PatientStatus", "Expired"))).list();
	   if (patientList != null || patientList.size() > 0)
	   {
		   map.put("patientDetailList", patientList);
	   }
	   // map.put("authorityList", authorityList);
	   map.put("employeeList", employeeList);
	   map.put("chargeList", chargeList);
	   map.put("masInvestigationDtList", masInvestigationDtList);
	   return map;
   }

   public String deleteAuthority(String string)
   {
      // TODO Auto-generated method stub
      return null;
   }

   public Map<String, Object> submitContingentBill(Map<String, Object> infoMap)
   {
      Map<String,Object> returnmap = new HashMap<String,Object>();
	  MdContigentMedicalBillHd contigentMedicalBillHd = new MdContigentMedicalBillHd();
	  Session session = (Session)getSession();
      String userName = "";
      boolean saved = false;
      boolean flag = false;

      List chargeList = new ArrayList();
      List contingentDetailIdList = new ArrayList();
      int hospitalId = 0;
      int specialInvId = 0;
Transaction tx= null;
      if (infoMap.get("contigentMedicalBillHd") != null)
      {
         contigentMedicalBillHd = (MdContigentMedicalBillHd) infoMap.get("contigentMedicalBillHd");
      }
      if (infoMap.get("userName") != null)
      {
         userName = (String) infoMap.get("userName");
      }
      if (infoMap.get("hospitalId") != null)
      {
         hospitalId = (Integer) infoMap.get("hospitalId");
      }
      if (infoMap.get("contingentDetailIdList") != null)
      {
         contingentDetailIdList = (List) infoMap.get("contingentDetailIdList");
      }
      if (infoMap.get("specialInvId") != null)
      {
    	  specialInvId = (Integer) infoMap.get("specialInvId");
      }
      MasHospital hospital = new MasHospital();
      hospital.setId(hospitalId);

      org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
      hbt.setFlushModeName("FLUSH_EAGER");
      hbt.setCheckWriteOperations(false);

      Map<String, Object> utilMap = new HashMap<String, Object>();
      utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
      String date = (String) utilMap.get("currentDate");
      String time = (String) utilMap.get("currentTime");
      Date changeDate = HMSUtil.convertStringTypeDateToDateType(date);
      
      try
      {
    	  tx = session.beginTransaction();
    	  List<TransactionSequence> transacsequence = new ArrayList<TransactionSequence>();
          transacsequence = session.createCriteria(TransactionSequence.class).add(Restrictions.eq("Tablename","MdContigentMedicalBillHd")).list();
          TransactionSequence tranSeq = transacsequence.get(0);
          int numberT = tranSeq.getTransactionSequenceNumber()+1;
          tranSeq.setTransactionSequenceNumber(numberT);
          String []yearlyNo = contigentMedicalBillHd.getEntryNo().split("/");
          String entryNo = ""+numberT+"/"+yearlyNo[1];
          contigentMedicalBillHd.setEntryNo(entryNo);
         hbt.save(contigentMedicalBillHd);
         hbt.saveOrUpdate(tranSeq);
         hbt.refresh(contigentMedicalBillHd);
         hbt.refresh(tranSeq);
     
    
         if (infoMap.get("chargeList") != null)
         {
            chargeList = (List) infoMap.get("chargeList");
           
               if (chargeList.size() > 0)
               {
                  for (int i = 0; i < chargeList.size(); i++)
                  {
                     MdContigentMedicalBillDt contigentMedicalBillDt = new MdContigentMedicalBillDt();
                     MasChargeCode masChargeCode = new MasChargeCode();
                     if (chargeList.get(i) != null && !chargeList.get(i).equals(""))
                     {
                        int chargeId = Integer.parseInt(chargeList.get(i).toString());
                        masChargeCode.setId(chargeId);
                        contigentMedicalBillDt.setCharge(masChargeCode);

                        contigentMedicalBillDt.setBillHeader(contigentMedicalBillHd);
                        try
                        {
                           hbt.save(contigentMedicalBillDt);
                        } catch (Exception e)
                        {
                           e.printStackTrace();
                        }
                     }

                     else if (!contingentDetailIdList.get(i).toString().equals(""))
                     {
                        MdContigentMedicalBillDt specialInvDt = (MdContigentMedicalBillDt) hbt.load(
                              MdContigentMedicalBillDt.class, (Integer.parseInt(contingentDetailIdList.get(i)
                                    .toString())));
                        hbt.update(specialInvDt);

                     }
                  }
               }
               
               MdSpecialInvestigationHd specialInvHd = (MdSpecialInvestigationHd) hbt.load(
            		   MdSpecialInvestigationHd.class, specialInvId);
               specialInvHd.setStatus("A");
               hbt.update(specialInvHd);
           
         saved = true;
         returnmap.put("saved",saved);
         returnmap.put("contigentMedicalBill_Id",contigentMedicalBillHd.getId() );
         tx.commit();
         }
         } catch (DataAccessException e)
         {
        	 if(tx!=null)
        		 tx.rollback();
            e.printStackTrace();
         }

      return returnmap;
   }

   @SuppressWarnings("unchecked")
   public Map<String, Object> showPatientForCoveringLetterUnit(Map<String, Object> dataMap)
   {
      Map<String, Object> map = new HashMap<String, Object>();
      List<MasUnit> unitList = new ArrayList<MasUnit>();
      List<MdContigentMedicalBillHd> continegentList = new ArrayList<MdContigentMedicalBillHd>();
      List<Patient> patientList = new ArrayList<Patient>();
      int hinId = 0;
      Session session = (Session) getSession();

      unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y")).list();
      dataMap.put("unitList", unitList);
      if (dataMap != null && dataMap.size() > 0)
         /*continegentList = getHibernateTemplate()
               .find("from jkt.hms.masters.business.MdContigentMedicalBillHd m where m.DispatchStatus = 'P' and m.Amount <= 10000");*/
    	  continegentList=session.createCriteria(MdContigentMedicalBillHd.class)
    	  					.add(Restrictions.eq("DispatchStatus", "P")).list();
      if (continegentList != null && continegentList.size() > 0)
      {
         dataMap.put("continegentList", continegentList);

         hinId = continegentList.get(0).getHin().getId();
         patientList = session.createCriteria(Patient.class).add(Restrictions.eq("Id", hinId)).add(Restrictions.not(Restrictions.eq("PatientStatus", "Expired"))).list();
         if (patientList != null || patientList.size() > 0)
         {
            dataMap.put("patientDetailList", patientList);
         }
      }
      return dataMap;
   }

   public Map<String, Object> fillItemsForUnitName(Map<String, Object> dataMap)
   {
      Map<String, Object> map = new HashMap<String, Object>();

      List unitList = new ArrayList();
      Session session = (Session) getSession();
      String unitName = (String) dataMap.get("unitName");
      try
      {
         org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
         hbt.setFlushModeName("FLUSH_EAGER");
         hbt.setCheckWriteOperations(false);
         unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("UnitName", unitName)).list();
         map.put("unitList", unitList);

      } catch (Exception e)
      {
         e.printStackTrace();
      }
      return map;
   }

   // -------------------------General Covering Letter----------------

   @SuppressWarnings("unchecked")
   public Map<String, Object> showGeneralClaimCoveringLetter(Map<String, Object> dataMap)
   {
      Map<String, Object> map = new HashMap<String, Object>();
      List<MdContigentMedicalBillHd> continegentList = new ArrayList<MdContigentMedicalBillHd>();
      List<Patient> patientList = new ArrayList<Patient>();
      int hinId = 0;
      Session session = (Session) getSession();

      continegentList = getHibernateTemplate()
            .find(
                  "from jkt.hms.masters.business.MdContigentMedicalBillHd m where m.DispatchStatus = 'P' and m.Amount >= 10000");

      if (continegentList != null && continegentList.size() > 0)
      {
         dataMap.put("continegentList", continegentList);

         hinId = continegentList.get(0).getHin().getId();
         patientList = session.createCriteria(Patient.class).add(Restrictions.eq("Id", hinId)).add(Restrictions.not(Restrictions.eq("PatientStatus", "Expired"))).list();
         if (patientList != null || patientList.size() > 0)
         {
            dataMap.put("patientDetailList", patientList);
         }
      }
      return dataMap;
   }

   public Map<String, Object> submitCoveringletter(Map<String, Object> parameterMap)
   {
      Map<String, Object> map = new HashMap<String, Object>();
      
      boolean saved = false;
      Box box = null;
      int hospitalId = 0;
      String userName = "";
      Session session = (Session) getSession();
      Map<String, Object> utilMap = new HashMap<String, Object>();
      utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
      String currentDate = (String) utilMap.get("currentDate");
      String time = (String) utilMap.get("currentTime");

      Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

      if (parameterMap.get("box") != null)
      {
         box = (Box) parameterMap.get("box");
      }
      if (parameterMap.get("hospitalId") != null)
      {
         hospitalId = (Integer) parameterMap.get("hospitalId");
      }
      if (parameterMap.get("userName") != null)
      {
         userName = (String) parameterMap.get("userName");
      }

      MdCoveringLetterUnitHd coveringLetterUnitHd = new MdCoveringLetterUnitHd();
      HibernateTemplate hbt = getHibernateTemplate();
      hbt.setFlushModeName("FLUSH_EAGER");
      hbt.setCheckWriteOperations(false);
      try
      {
         /*int unitId = 0;
         if (box.getString(UNIT_ID) != null && !box.getString(UNIT_ID).equals("0"))
         {
            unitId = box.getInt(UNIT_ID);
            MasUnit masUnit = new MasUnit();
            masUnit.setId(unitId);
            coveringLetterUnitHd.setUnit(masUnit);
         } */
         String entrySeqNo = box.getString(ENTRY_NO);
         int departmentId=0;
         if( box.getInt(DEPARTMENT_ID)!=0){
        	 departmentId = box.getInt(DEPARTMENT_ID);
         }
         MasHospital hospital = new MasHospital();
         hospital.setId(hospitalId);
         coveringLetterUnitHd.setHospital(hospital);

        if(departmentId!=0){
         MasDepartment department = new MasDepartment();
         department.setId(departmentId);
         coveringLetterUnitHd.setDepartment(department);
      }
         coveringLetterUnitHd.setEntryNo(generateCoveringEntryNumber());

         coveringLetterUnitHd.setLastChgBy(userName);
         coveringLetterUnitHd.setLastChgDate(date);
         coveringLetterUnitHd.setLastChgTime(time);
         coveringLetterUnitHd.setDispatchDate(date);
         coveringLetterUnitHd.setEntryDate(date);
         hbt.save(coveringLetterUnitHd);
         hbt.refresh(coveringLetterUnitHd);
      } catch (DataAccessException e)
      {
         e.printStackTrace();
      }

      try
      {
         Vector dispatch = box.getVector(DISPATCH);
         Vector hin_Id = box.getVector(HIN_ID);
         Vector contingentHdId = box.getVector(CONTINGENT_BILL_HD_ID);
         for (int i = 0; i < dispatch.size(); i++)
         {
            if (dispatch.get(i) != null && !dispatch.get(i).equals(""))
            {
               for(int j=0;j<contingentHdId.size();j++){
            	   if(dispatch.get(i).equals(contingentHdId.get(j)))
            	   {
            		   MdCoveringLetterUnitDt coveringLetterUnitDt = new MdCoveringLetterUnitDt();
            		   coveringLetterUnitDt.setCoveringHd(coveringLetterUnitHd);

            		   coveringLetterUnitDt.setDispatch("y");

            		   if (hin_Id.get(j) != null && !hin_Id.get(j).equals(""))
            		   {
            			   Patient patient = new Patient();
            			   patient.setId(Integer.parseInt((String) hin_Id.get(j)));
            			   coveringLetterUnitDt.setHin(patient);
            		   }
            		   int contId = 0;
            		   contId = Integer.parseInt((String) contingentHdId.get(j));
            		   if (contingentHdId.get(j) != null && !contingentHdId.get(j).equals(""))
            		   {
            			   MdContigentMedicalBillHd contigentMedicalBillHd = new MdContigentMedicalBillHd();
            			   contigentMedicalBillHd.setId(Integer.parseInt((String) contingentHdId.get(j)));
            			   coveringLetterUnitDt.setContingentHd(contigentMedicalBillHd);
            		   }

            		   MdContigentMedicalBillHd mdContigentMedicalBillHd = (MdContigentMedicalBillHd) getHibernateTemplate()
            		   	.load(MdContigentMedicalBillHd.class, contId);
            		   mdContigentMedicalBillHd.setDispatchStatus("D");
            		   hbt.update(mdContigentMedicalBillHd);
            		   hbt.save(coveringLetterUnitDt);
            		   hbt.refresh(mdContigentMedicalBillHd);
            		   hbt.refresh(coveringLetterUnitDt);
            }
            	   }
               }
         }
         saved = true;
      } catch (NumberFormatException e)
      {
         e.printStackTrace();
      } catch (DataAccessException e)
      {
         e.printStackTrace();
      }
      map.put("covering_hd_id",coveringLetterUnitHd.getId());
      map.put("saved", saved);
      return map;
   }

   public Map<String, Object> submitGeneralCoveringletter(Map<String, Object> parameterMap)
   {
      Map<String, Object> map = new HashMap<String, Object>();
      boolean saved = false;
      Box box = null;
      int hospitalId = 0;
      int deptId = 0;
      String userName = "";
      Session session = (Session) getSession();
      Map<String, Object> utilMap = new HashMap<String, Object>();
      utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
      String currentDate = (String) utilMap.get("currentDate");
      String time = (String) utilMap.get("currentTime");

      Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

      if (parameterMap.get("box") != null)
      {
         box = (Box) parameterMap.get("box");
      }
      if (parameterMap.get("hospitalId") != null)
      {
         hospitalId = (Integer) parameterMap.get("hospitalId");
      }
      if (parameterMap.get("deptId") != null)
      {
         deptId = (Integer) parameterMap.get("deptId");
      }
      if (parameterMap.get("userName") != null)
      {
         userName = (String) parameterMap.get("userName");
      }

      HibernateTemplate hbt = getHibernateTemplate();
      hbt.setFlushModeName("FLUSH_EAGER");
      hbt.setCheckWriteOperations(false);
      MdGeneralCoveringHd generalCoveringHd = new MdGeneralCoveringHd();
      try
      {
         String entrySeqNo = box.getString(ENTRY_NO);
         String from = box.getString(FROM);
         String to = box.getString(TO);
         int departmentId = box.getInt(DEPARTMENT_ID);

         MasHospital hospital = new MasHospital();
         hospital.setId(hospitalId);
         generalCoveringHd.setHospital(hospital);

         MasDepartment department = new MasDepartment();
         department.setId(deptId);
         generalCoveringHd.setDepartment(department);

         generalCoveringHd.setFrom1(from);
         generalCoveringHd.setTo1(to);
         generalCoveringHd.setDispatch("y");
         generalCoveringHd.setDispatchDate(date);
         generalCoveringHd.setEntryDate(date);
         generalCoveringHd.setLastChgBy(userName);
         generalCoveringHd.setLastChgDate(date);
         generalCoveringHd.setLastChgTime(time);

         generalCoveringHd.setEntryNo(generateGeneralEntryNumber());

         hbt.save(generalCoveringHd);
      } catch (DataAccessException e)
      {
         e.printStackTrace();
      }

      try
      {
         Vector dispatch = box.getVector(DISPATCH);
         Vector hin_Id = box.getVector(HIN_ID);
         Vector contingentHdId = box.getVector(CONTINGENT_BILL_HD_ID);
         for (int i = 0; i < dispatch.size(); i++)
         {
            if (dispatch.get(i) != null && !dispatch.get(i).equals(""))
            {
               MdGeneralCoveringDt generalCoveringDt = new MdGeneralCoveringDt();
               generalCoveringDt.setGeneralHd(generalCoveringHd);

               generalCoveringDt.setDispatch((String) dispatch.get(i));

               if (hin_Id.get(i) != null && !hin_Id.get(i).equals(""))
               {
                  Patient patient = new Patient();
                  patient.setId(Integer.parseInt((String) hin_Id.get(i)));
                  generalCoveringDt.setHin(patient);
               }
               int contId = 0;
               contId = Integer.parseInt((String) contingentHdId.get(i));
               if (contingentHdId.get(i) != null && !contingentHdId.get(i).equals(""))
               {
                  MdContigentMedicalBillHd contigentMedicalBillHd = new MdContigentMedicalBillHd();
                  contigentMedicalBillHd.setId(Integer.parseInt((String) contingentHdId.get(i)));
                  generalCoveringDt.setConingentHd(contigentMedicalBillHd);
               }

               MdContigentMedicalBillHd mdContigentMedicalBillHd = (MdContigentMedicalBillHd) getHibernateTemplate()
                     .load(MdContigentMedicalBillHd.class, contId);
               mdContigentMedicalBillHd.setDispatchStatus("D");
               hbt.update(mdContigentMedicalBillHd);
               hbt.refresh(mdContigentMedicalBillHd);
               hbt.save(generalCoveringDt);

               saved = true;
            }
         }

      } catch (Exception e)
      {
         e.printStackTrace();
      }
      map.put("saved", saved);
      return map;
   }

   // ----------------General Claim Tracking------------------------------

   public Map<String, Object> showPatientForGeneralClaim()
   {
      Map<String, Object> map = new HashMap<String, Object>();
      List<MasRank> rankList = new ArrayList<MasRank>();
      Session session = (Session) getSession();
      try
      {
         rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankName")).list();

         map.put("rankList", rankList);
      } catch (Exception e)
      {
         e.printStackTrace();
      }
      return map;
   }

   public Map<String, Object> getPatientDetailsForGeneralTracking(Map<String, Object> mapForDs)
   {
      Map<String, Object> map = new HashMap<String, Object>();
      List<MdContigentMedicalBillHd> patientList = new ArrayList<MdContigentMedicalBillHd>();

      String serviceNo = "";
      String hinNo = "";
      String serPersonFName = "";
      String serPersonLName = "";
      String patientFName = "";
      String patientLName = "";
      int rankId = 0;
      int contingentHdID = 0;
      Session session = (Session) getSession();

      if (mapForDs.get("serviceNo") != null)
      {
         serviceNo = (String) mapForDs.get("serviceNo");
      }
      if (mapForDs.get("hinNo") != null)
      {
         hinNo = (String) mapForDs.get("hinNo");
      }
      if (mapForDs.get("rankId") != null)
      {
    	  rankId = (Integer) mapForDs.get("rankId");
      }
      if (mapForDs.get("serPersonFName") != null)
      {
         serPersonFName = (String) mapForDs.get("serPersonFName");
      }
      if (mapForDs.get("serPersonLName") != null)
      {
         serPersonLName = (String) mapForDs.get("serPersonLName");
      }
      if (mapForDs.get("patientFName") != null)
      {
         patientFName = (String) mapForDs.get("patientFName");
      }
      if (mapForDs.get("patientLName") != null)
      {
         patientLName = (String) mapForDs.get("patientLName");
      }
      if (mapForDs.get("contingentHdID") != null)
      {
         contingentHdID = (Integer) mapForDs.get("contingentHdID");
      }
      int hinId=0;
      if (mapForDs.get("hinId") != null)
      {
         hinId = (Integer) mapForDs.get("hinId");
      }
      Criteria crit = session.createCriteria(MdContigentMedicalBillHd.class);
      if(!serviceNo.equals("") || !hinNo.equals("") || !patientFName.equals("") || !patientLName.equals("") || !serPersonFName.equals("") || !serPersonLName.equals("")||rankId!=0){
     		crit = crit.createAlias("Hin", "hn");
     		
     	}
      try {
		if (!serviceNo.equals(""))
		  {
		     String str = serviceNo + "%";
		     crit = crit.add(Restrictions.like("hn.ServiceNo", str));
		  }
		  if (!hinNo.equals(""))
		  {
		     crit = crit.add(Restrictions.like("hn.HinNo", hinNo + "%"));
		  }
		  if (!patientFName.equals(""))
		  {
		     crit = crit.add(Restrictions.like("hn.PFirstName", patientFName + "%"));
		  }
		  if (!patientLName.equals(""))
		  {
		     crit = crit.add(Restrictions.like("hn.PLastName", patientLName + "%"));
		  }
		  if (!serPersonFName.equals(""))
		  {
		     crit = crit.add(Restrictions.like("hn.SFirstName", serPersonFName + "%"));
		  }
		  if (!serPersonLName.equals(""))
		  {
		     crit = crit.add(Restrictions.like("hn.SLastName", serPersonLName + "%"));
		  }
		  if (rankId!=0)
		  {
		     crit = crit.createAlias("hn.Rank", "rank").add(Restrictions.eq("rank.Id", rankId));
		  }
	} catch (HibernateException e) {
		e.printStackTrace();
	}
      patientList = crit.list();
      map.put("patientList", patientList);
      return map;
   }

   public Map<String, Object> getPatientForGeneralTracking(Map<String, Object> mapForDs)
   {
      Map<String, Object> map = new HashMap<String, Object>();
      List<MdContigentMedicalBillHd> contingentHdList = new ArrayList<MdContigentMedicalBillHd>();
      Session session = (Session) getSession();
      if (mapForDs != null && mapForDs.size() > 0)
         contingentHdList = session.createCriteria(MdContigentMedicalBillHd.class).add(
               Restrictions.eq("Id", (Integer) mapForDs.get("contingentHdID"))).list();
      if (contingentHdList != null && contingentHdList.size() > 0)
      {
         map.put("contingentHdList", contingentHdList);
      }
      return map;
   }

   public Map<String, Object> showPatientCardicClaimAdvance()
   {
      Map<String, Object> map = new HashMap<String, Object>();
      List<MasRank> rankList = new ArrayList<MasRank>();
      Session session = (Session) getSession();
      try
      {
         rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankName")).list();
         map.put("rankList", rankList);
      } catch (Exception e)
      {
         e.printStackTrace();
      }
      return map;
   }

   public Map<String, Object> getPatientDetailsCardicClaim(Map<String, Object> mapForDs)
   {
      Map<String, Object> map = new HashMap<String, Object>();
      List<Patient> patientList = new ArrayList<Patient>();

      String serviceNo = "";
      String hinNo = "";
      String serPersonFName = "";
      String serPersonLName = "";
      String patientFName = "";
      String patientLName = "";
      int rankId=0;
      int hinId = 0;
      Session session = (Session) getSession();

      if (mapForDs.get("serviceNo") != null)
      {
         serviceNo = (String) mapForDs.get("serviceNo");
      }
      if (mapForDs.get("hinNo") != null)
      {
         hinNo = (String) mapForDs.get("hinNo");
      }
      if (mapForDs.get("rankId") != null)
      {
    	  rankId = (Integer) mapForDs.get("rankId");
      }
      if (mapForDs.get("serPersonFName") != null)
      {
         serPersonFName = (String) mapForDs.get("serPersonFName");
      }
      if (mapForDs.get("serPersonLName") != null)
      {
         serPersonLName = (String) mapForDs.get("serPersonLName");
      }
      if (mapForDs.get("patientFName") != null)
      {
         patientFName = (String) mapForDs.get("patientFName");
      }
      if (mapForDs.get("patientLName") != null)
      {
         patientLName = (String) mapForDs.get("patientLName");
      }
      if (mapForDs.get("hinId") != null)
      {
         hinId = (Integer) mapForDs.get("hinId");
      }

      try
      {
      
      StringBuffer hqlQuery=new StringBuffer("");
      
      
      hqlQuery.append("select p.Id,p.ServiceNo,p.HinNo,p.PFirstName,p.PLastName,p.SFirstName,p.SLastName,p.Rank from Patient p where p.PatientStatus!='expired' ");
    	  
    	  
  			if(!serviceNo.equals("") ){
  				hqlQuery.append("and p.ServiceNo like '%"+serviceNo+"%' ");
  			}
  			if(!hinNo.equals("")){
  				hqlQuery.append("and p.HinNo like '%"+hinNo+"%' ");
  			}
  			if(!patientFName.equals("")){
  				hqlQuery.append("and p.PFirstName like '"+patientFName+"%' ");
			}
			if(!patientLName.equals("")){
				hqlQuery.append("and p.PLastName like '"+patientLName+"%' ");
			}
			if(!serPersonFName.equals("")){
  				hqlQuery.append("and p.SFirstName like '"+serPersonFName+"%' ");
			}
			if(!serPersonLName.equals("")){
				hqlQuery.append("and p.SLastName like '"+serPersonLName+"%' ");
			}
			 if(rankId != 0){
					hqlQuery.append("and p.Rank.Id = "+rankId+"");
				}
       List<Object> list=( List<Object>)session.createQuery(hqlQuery.toString()).list();
     
       for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Patient patient =new Patient();
			
			Object[] object = (Object[]) iterator.next();
			patient.setId((Integer)object[0]);
			if(object[1]!=null)
			patient.setServiceNo((String)object[1]);
			if(object[2]!=null)
			patient.setHinNo((String)object[2]);
			if(object[3]!=null)
			patient.setPFirstName((String)object[3]);
			if(object[4]!=null)
				patient.setPLastName((String)object[4]);
			if(object[5]!=null)
				patient.setSFirstName((String)object[5]);
				if(object[6]!=null)
					patient.setSLastName((String)object[6]);
			if(object[7]!=null){
				patient.setRank((MasRank)object[7]);
			}
			patientList.add(patient);
       
      } }catch (Exception e)
      {
         e.printStackTrace();
      }
      map.put("patientList", patientList);
      return map;
   }

   public Map<String, Object> getPatientforCardicAdvance(int hinId)
   {
      Map<String, Object> map = new HashMap<String, Object>();
      List<MasReference> hospitalList = new ArrayList<MasReference>();
      List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
      List<Patient> patientList = new ArrayList<Patient>();

      Session session = (Session) getSession();
     // hospitalList = session.createCriteria(MasReference.class).add(Restrictions.eq("Status", "y")).list();
      employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
      patientList = session.createCriteria(Patient.class).add(Restrictions.eq("Id", hinId)).list();
      if (patientList != null || patientList.size() > 0)
      {
         map.put("patientList", patientList);
      }
      //map.put("hospitalList", hospitalList);
      map.put("employeeList", employeeList);
      return map;
   }

   public Map submitCardicClaimAdvance(MdCardicClaimAdvance cardicClaimAdvance)
   {
      boolean successfullyAdded = false;
      Map map = new HashMap();
      Session session = (Session)getSession();
      org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
      hbt.setFlushModeName("FLUSH_EAGER");
      hbt.setCheckWriteOperations(false);
      /*String entryNoFromJsp=cardicClaimAdvance.getEntryNo();
      String []currentyear=entryNoFromJsp.split("/");
      List<TransactionSequence> yearlySeqNoList = new ArrayList<TransactionSequence>();
      yearlySeqNoList =session.createCriteria(TransactionSequence.class).add(Restrictions.eq("Tablename","MdCardicClaimAdvance")).list();
      TransactionSequence tranSeq=yearlySeqNoList.get(0);
      int numberT=tranSeq.getTransactionSequenceNumber()+1;
      tranSeq.setTransactionSequenceNumber(numberT);
      String entryNo = ""+numberT+"/"+currentyear[1];
      cardicClaimAdvance.setEntryNo(entryNo);*/
      hbt.save(cardicClaimAdvance);
      hbt.refresh(cardicClaimAdvance);
      //hbt.saveOrUpdate(tranSeq);
     // hbt.refresh(tranSeq);
      int serviceTypeId=cardicClaimAdvance.getHin().getServiceType().getId();
      successfullyAdded = true;
     
      List list = new ArrayList();
		int id = 0;
		list = getHibernateTemplate().find(
				"select max(Id)from MdCardicClaimAdvance");
		if (list != null && list.size() > 0 && list.get(0) != null) {
			id = Integer.parseInt(list.get(0).toString());
			map.put("id", id);
		}
		map.put("sucessfullyAdded", successfullyAdded);
		map.put("serviceTypeId", serviceTypeId);
      return map;
   }

   // ------- Cardiac claim – Contingent Bill for Reimbursement-----
   public Map<String, Object> showPatientSearchForCardicReimbursement()
   {
      Map<String, Object> map = new HashMap<String, Object>();
      List<MasRank> rankList = new ArrayList<MasRank>();
      Session session = (Session) getSession();
      try
      {
         rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankName")).list();

         map.put("rankList", rankList);
      } catch (Exception e)
      {
         e.printStackTrace();
      }
      return map;
   }

   public Map<String, Object> getPatientDetailsForCardicAdvance(Map<String, Object> mapForDs)
   {
      Map<String, Object> map = new HashMap<String, Object>();
      List<MdCardicClaimAdvance> patientList = new ArrayList<MdCardicClaimAdvance>();

      String serviceNo = "";
      String hinNo = "";
      String serPersonFName = "";
      String serPersonLName = "";
      String patientFName = "";
      String patientLName = "";
      int rankId=0;
      int cardicClaimId = 0;
      Session session = (Session) getSession();

      if (mapForDs.get("serviceNo") != null)
      {
         serviceNo = (String) mapForDs.get("serviceNo");
      }
      if (mapForDs.get("hinNo") != null)
      {
         hinNo = (String) mapForDs.get("hinNo");
      }
      if (mapForDs.get("rankId") != null)
      {
    	  rankId = (Integer) mapForDs.get("rankId");
      }
      if (mapForDs.get("serPersonFName") != null)
      {
         serPersonFName = (String) mapForDs.get("serPersonFName");
      }
      if (mapForDs.get("serPersonLName") != null)
      {
         serPersonLName = (String) mapForDs.get("serPersonLName");
      }
      if (mapForDs.get("patientFName") != null)
      {
         patientFName = (String) mapForDs.get("patientFName");
      }
      if (mapForDs.get("patientLName") != null)
      {
         patientLName = (String) mapForDs.get("patientLName");
      }
      if (mapForDs.get("cardicClaimId") != null)
      {
         cardicClaimId = (Integer) mapForDs.get("cardicClaimId");
      }

      Criteria crit = session.createCriteria(MdCardicClaimAdvance.class);
      if(!serviceNo.equals("") || !hinNo.equals("") || !patientFName.equals("") || !patientLName.equals("") || !serPersonFName.equals("") || !serPersonLName.equals("")||rankId!=0){
     		crit = crit.createAlias("Hin", "hn");
     		
     	}
      if (!serviceNo.equals(""))
      {
         String str = serviceNo + "%";
         crit = crit.add(Restrictions.like("hn.ServiceNo", str));
      }

      if (!hinNo.equals(""))
      {
         crit = crit.add(Restrictions.like("hn.HinNo", hinNo + "%"));
      }
      if (!patientFName.equals(""))
      {
         crit = crit.add(Restrictions.like("hn.PFirstName", patientFName + "%"));
      }
      if (!patientLName.equals(""))
      {
         crit = crit.add(Restrictions.like("hn.PLastName", patientLName + "%"));
      }
      if (!serPersonFName.equals(""))
      {
         crit = crit.add(Restrictions.like("hn.SFirstName", serPersonFName + "%"));
      }
      if (!serPersonLName.equals(""))
      {
         crit = crit.add(Restrictions.like("hn.SLastName", serPersonLName + "%"));
      }
      if (rankId!=0)
      {
         crit = crit.createAlias("hn.Rank", "rank").add(Restrictions.eq("rank.Id", rankId));
      }
      patientList = crit.list();
      map.put("patientList", patientList);
      return map;
   }

   public Map<String, Object> getPatientForCardicAdvanceBill(Map<String, Object> mapForDs)
   {
      Map<String, Object> map = new HashMap<String, Object>();
      List<Patient> patientList = new ArrayList<Patient>();
      List<MdCardicClaimAdvance> cardcAdvanceList = new ArrayList<MdCardicClaimAdvance>();
      int hinId = 0;
      Session session = (Session) getSession();
      if (mapForDs != null && mapForDs.size() > 0)
         cardcAdvanceList = session.createCriteria(MdCardicClaimAdvance.class).add(
               Restrictions.eq("Id", (Integer) mapForDs.get("cardicClaimId"))).list();
      if (cardcAdvanceList != null && cardcAdvanceList.size() > 0)
      {
         map.put("cardcAdvanceList", cardcAdvanceList);
      }

      hinId = cardcAdvanceList.get(0).getHin().getId();
      patientList = session.createCriteria(Patient.class).add(Restrictions.eq("Id", hinId)).add(Restrictions.not(Restrictions.eq("PatientStatus", "Expired"))).list();
      if (patientList != null || patientList.size() > 0)
      {
         map.put("patientDetailList", patientList);
      }

      return map;
   }

   // ---------- Contingent bill movement entry-------------
   public Map<String, Object> showPatientSearchContingentBillMovement()
   {
      Map<String, Object> map = new HashMap<String, Object>();
      List<MasRank> rankList = new ArrayList<MasRank>();
      Session session = (Session) getSession();
      try
      {
         rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankName")).list();
         map.put("rankList", rankList);
      } catch (Exception e)
      {
         e.printStackTrace();
      }
      return map;
   }

   public String generateEntryNoForContingentEntry(Map<String, Object> diagMap)
   {
	      List<TransactionSequence> seqList = new ArrayList<TransactionSequence>();
	      Map<String, Object> utilMap = new HashMap<String, Object>();
	      utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
	      Session session = (Session) getSession();
	      String entrySeqNo = "";
	      String date = "";
	      date = (String) utilMap.get("currentDate");

	      String currentYear = date.substring(date.lastIndexOf("/") + 1);
	      seqList = session.createCriteria(TransactionSequence.class).add(Restrictions.eq("TransactionPrefix", "CREN"))
	            .list();

	      HibernateTemplate hbt = getHibernateTemplate();
	      hbt.setFlushModeName("FLUSH_EAGER");
	      hbt.setCheckWriteOperations(false);

	      if (seqList.size() > 0)
	      {
	         for (TransactionSequence transactionSequence : seqList)
	            ;
	         {
	            TransactionSequence obj = (TransactionSequence) seqList.get(0);
	            int id = obj.getId();
	            int seqNo = obj.getTransactionSequenceNumber();

	            TransactionSequence transactionSequenceObj = (TransactionSequence) hbt.load(TransactionSequence.class, id);
	            transactionSequenceObj.setTransactionSequenceNumber(++seqNo);
	            hbt.update(transactionSequenceObj);

	            entrySeqNo = entrySeqNo.concat(String.valueOf(seqNo));
	            entrySeqNo = entrySeqNo.concat("/").concat(currentYear);
	         }
	      } else if (seqList.size() == 0)
	      {
	         TransactionSequence tsObj = new TransactionSequence();
	         tsObj.setStatus("y");
	         tsObj.setTablename("MdCardicContingentBillHd");
	         tsObj.setTransactionPrefix("CREN");
	         tsObj.setTransactionSequenceName("Cardic Reimu Entry No");
	         tsObj.setTransactionSequenceNumber(0);

	         hbt.save(tsObj);
	      }
	      return entrySeqNo;
	   }

   public Map<String, Object> submitCardicReimbursement(Box box, Map<String, Object> dataMap)
   {
      Map<String, Object> map = new HashMap<String, Object>();
      MdCardicContingentBillHd cardicContingentBillHd = new MdCardicContingentBillHd();
      boolean saved = false;
      Session session = (Session) getSession();
      Map<String, Object> utilMap = new HashMap<String, Object>();
      utilMap = (Map) HMSUtil.getCurrentDateAndTime();
      String time = (String) utilMap.get("currentTime");
      int hospitalId = 0;
      int deptId = 0;
      String userName = "";
      if (dataMap.get("box") != null)
      {
         box = (Box) dataMap.get("box");
      }
      if (dataMap.get("hospitalId") != null)
      {
         hospitalId = (Integer) dataMap.get("hospitalId");
      }
      if (dataMap.get("deptId") != null)
      {
         deptId = (Integer) dataMap.get("deptId");
      }
      if (dataMap.get("userName") != null)
      {
         userName = (String) dataMap.get("userName");
      }
      String entrySeqNo = box.getString(RequestConstants.ENTRY_NO);
      Date entryDate = new Date(box.getString(RequestConstants.ENTRY_DATE));
      int hinId = box.getInt(RequestConstants.HIN_ID);
      int cardicId = box.getInt(RequestConstants.CARDIC_CLAIM_ID);
      int inpatientId = box.getInt(RequestConstants.INPATIENT_ID);
      BigDecimal qualifyingAmount = new BigDecimal(box.getString(RequestConstants.QUALIFYING_RS));
     // BigDecimal reimbursRs = new BigDecimal(box.getString(RequestConstants.REIMBURS_RS));
      BigDecimal is2 = new BigDecimal(box.getString(RequestConstants.IS2));
      BigDecimal receivedRs = new BigDecimal(box.getString(RequestConstants.RECEIVED_RS));
      String payableTo = box.getString(RequestConstants.PAYABLE_TO);
     // String cghsCode = box.getString(RequestConstants.CGHS_CODE);
      String cghsRates = box.getString(RequestConstants.CGHS_RATES);
      //String is1 = box.getString(RequestConstants.IS1);
      BigDecimal totalRs = new BigDecimal(box.getString(RequestConstants.TOTAL_RS));

      String currentDate = (String) utilMap.get("currentDate");
      Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

      cardicContingentBillHd.setEntryNo(entrySeqNo);
      cardicContingentBillHd.setEntryDate(entryDate);
      
      MdCardicClaimAdvance calimAdvance = new MdCardicClaimAdvance();
      calimAdvance.setId(cardicId);
      cardicContingentBillHd.setCardicAdvance(calimAdvance);

      MasHospital hospital = new MasHospital();
      hospital.setId(hospitalId);
      cardicContingentBillHd.setHospital(hospital);

      MasDepartment department = new MasDepartment();
      department.setId(deptId);
      cardicContingentBillHd.setDepartment(department);
      if(hinId!=0){
      Patient patient = new Patient();
      patient.setId(hinId);
      cardicContingentBillHd.setHin(patient);
      }
      if(inpatientId!=0){
      Inpatient inpatient = new Inpatient();
      inpatient.setId(inpatientId);
      cardicContingentBillHd.setInpatient(inpatient);
      }

      cardicContingentBillHd.setQualifyingAmount(qualifyingAmount);
      cardicContingentBillHd.setReceivedRs(receivedRs);
    //  cardicContingentBillHd.setReimburseRs(reimbursRs);
      cardicContingentBillHd.setPayableTo(payableTo);
    //  cardicContingentBillHd.setCghsCode(cghsCode);
   //   cardicContingentBillHd.setIs1(is1);
      cardicContingentBillHd.setIs2(is2);
      cardicContingentBillHd.setTotalRs(totalRs);
      cardicContingentBillHd.setCghsRates(cghsRates);
      cardicContingentBillHd.setLastChgBy(userName);
      cardicContingentBillHd.setLastChgTime(time);
      cardicContingentBillHd.setLastChgDate(date);

      Transaction tx = null;
      try
      {
         tx = session.beginTransaction();
         org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
         hbt.setFlushModeName("FLUSH_EAGER");
         hbt.setCheckWriteOperations(false);
         //***transaction sequence number generation 
         String entryNoFromJsp=cardicContingentBillHd.getEntryNo();
         String []currentyear=entryNoFromJsp.split("/");
         List<TransactionSequence> yearlySeqNoList = new ArrayList<TransactionSequence>();
         yearlySeqNoList =session.createCriteria(TransactionSequence.class).add(Restrictions.eq("Tablename","MdCardicContingentBillHd")).list();
         TransactionSequence tranSeq=yearlySeqNoList.get(0);
         int numberT=tranSeq.getTransactionSequenceNumber()+1;
         tranSeq.setTransactionSequenceNumber(numberT);
         String entryNo = ""+numberT+"/"+currentyear[1];
         cardicContingentBillHd.setEntryNo(entryNo);
         //*****
         hbt.save(cardicContingentBillHd);
         hbt.refresh(cardicContingentBillHd);
         hbt.saveOrUpdate(tranSeq);
         hbt.refresh(tranSeq);
         Vector selectedChrage1 = box.getVector("selectedChrage1");
         Vector selectedChrage = box.getVector("selectedChrage");
         Vector bill_no = box.getVector(BILL_NO);
         Vector detail = box.getVector("chargeCodeId");
         Vector bill_date = box.getVector(BILL_DATE);
         Vector amount = box.getVector(AMOUNT);
         int j=0;
         BigDecimal totalRs1= new BigDecimal("0");
         for(int i=0;i<selectedChrage1.size();i++)
         {
        	 if(selectedChrage.contains(selectedChrage1.get(i))){
        		 j++;
        		 MdCardicContingentBillDt cardicContingentBillDt = new MdCardicContingentBillDt();
                 
                 cardicContingentBillDt.setCardicHd(cardicContingentBillHd);

                 cardicContingentBillDt.setBillNo((String) bill_no.get(i));

                 if (detail.get(i) != null && !detail.get(i).equals(""))
                 {
                	 MasChargeCode masChargeCode = new MasChargeCode();
                	masChargeCode.setId(Integer.parseInt((String)detail.get(i)));
                    cardicContingentBillDt.setDetails(masChargeCode);
                 }
                 if (bill_date.get(i) != null && !bill_date.get(i).equals(""))
                 {
                    cardicContingentBillDt.setBillDate(HMSUtil.convertStringTypeDateToDateType(box.get(BILL_DATE)));
                 }
                 if (amount.get(i) != null && !amount.get(i).equals(""))
                 {
                    cardicContingentBillDt.setAmount(new BigDecimal(box.get(AMOUNT)));
                    totalRs1=totalRs1.add(new BigDecimal(box.getString(AMOUNT)));
                 }

                 hbt.save(cardicContingentBillDt);
                 hbt.refresh(cardicContingentBillDt);
        	 }
         }
         /* for(int j=0;j<selectedChrage.size();j++)
         {
         for (int i = 0; i < bill_no.size(); i++)
         {
            
        	 if (bill_no.get(i) != null && !bill_no.get(i).equals(""))
              {
               MdCardicContingentBillDt cardicContingentBillDt = new MdCardicContingentBillDt();
               
               cardicContingentBillDt.setCardicHd(cardicContingentBillHd);

               cardicContingentBillDt.setBillNo((String) bill_no.get(i));

               if (detail.get(i) != null && !detail.get(i).equals(""))
               {
                  cardicContingentBillDt.setDetails((String) detail.get(i));
               }
               if (bill_date.get(i) != null && !bill_date.get(i).equals(""))
               {
                  cardicContingentBillDt.setBillDate(HMSUtil.convertStringTypeDateToDateType(box.get(BILL_DATE)));
               }
               if (amount.get(i) != null && !amount.get(i).equals(""))
               {
                  cardicContingentBillDt.setAmount(new BigDecimal(box.get(AMOUNT)));
               }

               hbt.save(cardicContingentBillDt);
               hbt.refresh(cardicContingentBillDt);
            }
         }
             }*/
         cardicContingentBillHd.setTotalRs(totalRs1);
         hbt.saveOrUpdate(cardicContingentBillHd);
         hbt.refresh(cardicContingentBillHd);
         saved = true;
         tx.commit();
      } catch (Exception e)
      {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();

      }
      int serviceTypeId=cardicContingentBillHd.getHin().getRank().getServiceType().getId();
      map.put("saved", saved);
      map.put("cardicContigentId", cardicContingentBillHd.getId());
      map.put("Id", cardicContingentBillHd.getCardicAdvance().getId());
      map.put("serviceTypeId", serviceTypeId);
      return map;
   }

   public Map<String, Object> getPatientDetailsForBillMovement(Map<String, Object> mapForDs)
   {
      Map<String, Object> map = new HashMap<String, Object>();
      List<MdCardicContingentBillHd> patientList = new ArrayList<MdCardicContingentBillHd>();

      String serviceNo = "";
      String hinNo = "";
      int rankId=0;
      String serPersonFName = "";
      String serPersonLName = "";
      String patientFName = "";
      String patientLName = "";
      String patientStatus = "";
      int hinId = 0;
      int contingentHdID = 0;
      Session session = (Session) getSession();

      if (mapForDs.get("serviceNo") != null)
      {
         serviceNo = (String) mapForDs.get("serviceNo");
      }
      if (mapForDs.get("hinNo") != null)
      {
         hinNo = (String) mapForDs.get("hinNo");
      }
      if (mapForDs.get("rankId") != null)
      {
    	  rankId = (Integer) mapForDs.get("rankId");
      }
      if (mapForDs.get("serPersonFName") != null)
      {
         serPersonFName = (String) mapForDs.get("serPersonFName");
      }
      if (mapForDs.get("serPersonLName") != null)
      {
         serPersonLName = (String) mapForDs.get("serPersonLName");
      }
      if (mapForDs.get("patientFName") != null)
      {
         patientFName = (String) mapForDs.get("patientFName");
      }
      if (mapForDs.get("patientLName") != null)
      {
         patientLName = (String) mapForDs.get("patientLName");
      }
      if (mapForDs.get("contingentHdID") != null)
      {
         contingentHdID = (Integer) mapForDs.get("contingentHdID");
      }
      if (mapForDs.get("hinId") != null)
      {
         hinId = (Integer) mapForDs.get("hinId");
      }

      Criteria crit = session.createCriteria(MdCardicContingentBillHd.class);
      if(!serviceNo.equals("") || !hinNo.equals("") || !patientFName.equals("") || !patientLName.equals("") || !serPersonFName.equals("") || !serPersonLName.equals("")||rankId!=0){
     		crit = crit.createAlias("Hin", "hn");
     		
     	}
      if (!serviceNo.equals(""))
      {
         String str = serviceNo + "%";
         crit = crit.add(Restrictions.like("hn.ServiceNo", str));
      }

      if (!hinNo.equals(""))
      {
         crit = crit.add(Restrictions.like("hn.HinNo", hinNo + "%"));
      }
      if (!patientFName.equals(""))
      {
         crit = crit.add(Restrictions.like("hn.PFirstName", patientFName + "%"));
      }
      if (!patientLName.equals(""))
      {
         crit = crit.add(Restrictions.like("hn.PLastName", patientLName + "%"));
      }
      if (!serPersonFName.equals(""))
      {
         crit = crit.add(Restrictions.like("hn.SFirstName", serPersonFName + "%"));
      }
      if (!serPersonLName.equals(""))
      {
         crit = crit.add(Restrictions.like("hn.SLastName", serPersonLName + "%"));
      }
      if (rankId!=0)
      {
         crit = crit.createAlias("hn.Rank", "rank").add(Restrictions.eq("rank.Id", rankId));
      }
      patientList = crit.list();
      map.put("patientList", patientList);

      return map;
   }

   public Map<String, Object> getPatientForCardicBillMovement(String serviceNo, Map<String, Object> mapForDs)
   {
      Map<String, Object> map = new HashMap<String, Object>();
      List<Patient> patientList = new ArrayList<Patient>();
      List<MdCardicContingentBillHd> cardicBillList = new ArrayList<MdCardicContingentBillHd>();
      List<MdMasAuthority> authorityList = new ArrayList<MdMasAuthority>();
      List<MdBillMovement> billMovementList = new ArrayList<MdBillMovement>();
      int hinId = 0;
      
      Session session = (Session) getSession();
      if (mapForDs != null && mapForDs.size() > 0)
         cardicBillList = session.createCriteria(MdCardicContingentBillHd.class).add(
               Restrictions.eq("Id", (Integer) mapForDs.get("contingentHdID"))).list();
      if (cardicBillList != null && cardicBillList.size() > 0)
      {
         map.put("cardicBillList", cardicBillList);
         billMovementList = session.createCriteria(MdBillMovement.class).createAlias(
                 "Hin", "hn").add(Restrictions.eq("hn.ServiceNo", cardicBillList.get(0).getHin().getServiceNo())).list();
           if (billMovementList != null && billMovementList.size() > 0)
           {
              map.put("billMovementList", billMovementList);
           }
         
      }
      authorityList = session.createCriteria(MdMasAuthority.class).add(Restrictions.eq("Status", "y")).list();
      map.put("authorityList", authorityList);
      
     
      return map;
   }

   public Map<String, Object> submitCardicBillMovement(Box box, Map<String, Object> dataMap)
   {
      Map<String, Object> map = new HashMap<String, Object>();
      MdBillMovement billMovement = new MdBillMovement();
      boolean saved = false;
      Session session = (Session) getSession();
      Map<String, Object> utilMap = new HashMap<String, Object>();
      utilMap = (Map) HMSUtil.getCurrentDateAndTime();
      String time = (String) utilMap.get("currentTime");
      int hospitalId = 0;
      int deptId = 0;
      String userName = "";
      if (dataMap.get("box") != null)
      {
         box = (Box) dataMap.get("box");
      }
      if (dataMap.get("hospitalId") != null)
      {
         hospitalId = (Integer) dataMap.get("hospitalId");
      }
      if (dataMap.get("deptId") != null)
      {
         deptId = (Integer) dataMap.get("deptId");
      }
      if (dataMap.get("userName") != null)
      {
         userName = (String) dataMap.get("userName");
      }
      String documnetNo = box.getString(RequestConstants.DOCUMENT_NO);
      Date fwtDate = new Date(box.getString(RequestConstants.DATE));
      int hinId = box.getInt(RequestConstants.HIN_ID);
      int inpatientId = box.getInt(RequestConstants.INPATIENT_ID);
      int contingentHdID = box.getInt(RequestConstants.CONTINGENT_BILL_HD_ID);
      int contingentDtID = box.getInt(RequestConstants.CONTINGENT_BILL_DT_ID);
      String billStatus = box.getString(RequestConstants.BILL_STATUS);
      int fwtTo = box.getInt(RequestConstants.FWT_TO);

      String currentDate = (String) utilMap.get("currentDate");
      Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

      MasHospital hospital = new MasHospital();
      hospital.setId(hospitalId);
      billMovement.setHospital(hospital);

      MasDepartment masDepartment = new MasDepartment();
      masDepartment.setId(deptId);
      billMovement.setDepartment(masDepartment);

      Patient patient = new Patient();
      patient.setId(hinId);
      billMovement.setHin(patient);

      Inpatient inpatient = new Inpatient();
      inpatient.setId(inpatientId);
      billMovement.setInpatient(inpatient);

      MdCardicContingentBillHd mardicContingentBillHd = new MdCardicContingentBillHd();
      mardicContingentBillHd.setId(contingentHdID);
      billMovement.setContingentHd(mardicContingentBillHd);

      MdCardicContingentBillDt cardicContingentBillDt = new MdCardicContingentBillDt();
      cardicContingentBillDt.setId(contingentDtID);
      billMovement.setContingentDt(cardicContingentBillDt);

      MdMasAuthority masAuthority = new MdMasAuthority();
      masAuthority.setId(fwtTo);
      billMovement.setFwtTo(masAuthority);

      billMovement.setDocumnetNo(documnetNo);
      billMovement.setFwtDate(date);
      billMovement.setBillStatus(billStatus);
      billMovement.setLastChgBy(userName);
      billMovement.setLastChgTime(time);
      billMovement.setLastChgDate(date);

      Transaction tx = null;
      try
      {
         tx = session.beginTransaction();
         org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
         hbt.setFlushModeName("FLUSH_EAGER");
         hbt.setCheckWriteOperations(false);
         hbt.saveOrUpdate(billMovement);

         saved = true;
         tx.commit();
      } catch (Exception e)
      {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      }
      map.put("saved", saved);
      return map;
   }

   // --------Cardic Claim Tracking ---------
   public Map<String, Object> showPatientForCardicClaim()
   {
      Map<String, Object> map = new HashMap<String, Object>();
      List<MasRank> rankList = new ArrayList<MasRank>();
      Session session = (Session) getSession();
      try
      {
         rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).list();
         map.put("rankList", rankList);
      } catch (Exception e)
      {
         e.printStackTrace();
      }
      return map;
   }

   public Map<String, Object> getPatientDetailsForCardicTracking(Map<String, Object> mapForDs)
   {
      Map<String, Object> map = new HashMap<String, Object>();
      List<MdBillMovement> patientList = new ArrayList<MdBillMovement>();

      String serviceNo = "";
      String hinNo = "";
      int rankId = 0;
      String serPersonFName = "";
      String serPersonLName = "";
      String patientFName = "";
      String patientLName = "";
      int hinId = 0;
      int billMovementID = 0;
      Session session = (Session) getSession();

      if (mapForDs.get("serviceNo") != null)
      {
         serviceNo = (String) mapForDs.get("serviceNo");
      }
      if (mapForDs.get("hinNo") != null)
      {
         hinNo = (String) mapForDs.get("hinNo");
      }
      if (mapForDs.get("rankId") != null)
      {
    	  rankId = (Integer) mapForDs.get("rankId");
      }
      if (mapForDs.get("serPersonFName") != null)
      {
         serPersonFName = (String) mapForDs.get("serPersonFName");
      }
      if (mapForDs.get("serPersonLName") != null)
      {
         serPersonLName = (String) mapForDs.get("serPersonLName");
      }
      if (mapForDs.get("patientFName") != null)
      {
         patientFName = (String) mapForDs.get("patientFName");
      }
      if (mapForDs.get("patientLName") != null)
      {
         patientLName = (String) mapForDs.get("patientLName");
      }
      if (mapForDs.get("billMovementID") != null)
      {
         billMovementID = (Integer) mapForDs.get("billMovementID");
      }
      if (mapForDs.get("hinId") != null)
      {
         hinId = (Integer) mapForDs.get("hinId");
      }
      Criteria crit = session.createCriteria(MdBillMovement.class);
      if(!serviceNo.equals("") || !hinNo.equals("") || !patientFName.equals("") || !patientLName.equals("") || !serPersonFName.equals("") || !serPersonLName.equals("")||rankId!=0){
     		crit = crit.createAlias("Hin", "hn");
     		
     	}
      if (!serviceNo.equals(""))
      {
         String str = serviceNo + "%";
         crit = crit.add(Restrictions.like("hn.ServiceNo", str));
      }
      if (!hinNo.equals(""))
      {
         crit = crit.add(Restrictions.like("hn.HinNo", hinNo + "%"));
      }
      if (!patientFName.equals(""))
      {
         crit = crit.add(Restrictions.like("hn.PFirstName", patientFName + "%"));
      }
      if (!patientLName.equals(""))
      {
         crit = crit.add(Restrictions.like("hn.PLastName", patientLName + "%"));
      }
      if (!serPersonFName.equals(""))
      {
         crit = crit.add(Restrictions.like("hn.SFirstName", serPersonFName + "%"));
      }
      if (!serPersonLName.equals(""))
      {
         crit = crit.add(Restrictions.like("hn.SLastName", serPersonLName + "%"));
      }
      if (rankId!=0)
      {
         crit = crit.createAlias("hn.Rank", "rank").add(Restrictions.eq("rank.Id", rankId));
      }
      patientList = crit.list();
      map.put("patientList", patientList);
      return map;
   }

   public Map<String, Object> getPatientForCardicTracking(int billMovementID)
   {

      Map<String, Object> map = new HashMap<String, Object>();
      List<MdBillMovement> billMovementList = new ArrayList<MdBillMovement>();
      Session session = (Session) getSession();
      billMovementList = session.createCriteria(MdBillMovement.class).add(Restrictions.eq("Id", billMovementID)).list();
      if (billMovementList != null && billMovementList.size() > 0)
      {
         map.put("billMovementList", billMovementList);
      }
      return map;
   }

   public Map<String, Object> getDataForSpecialInvetigationJsp()
   {
      Session session = (Session) getSession();
      Map<String, Object> map = new HashMap<String, Object>();
      List<MasRank> rankList = new ArrayList<MasRank>();
      try
      {

         rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankName")).list();

      } catch (HibernateException e)
      {
         e.printStackTrace();
      }

      map.put("rankList", rankList);

      return map;
   }

   public Map<String, Object> showPatientUpdateSpecialInv(Map<String, Object> mapForDs)
   {
      Map<String, Object> map = new HashMap<String, Object>();
      List<MdSpecialInvestigationHd> patientList = new ArrayList<MdSpecialInvestigationHd>();
      String serviceNo = "";
      String hinNo = "";
      int rankId=0;
      String serPersonFName = "";
      String serPersonLName = "";
      String patientFName = "";
      String patientLName = "";
      String patientStatus = "";
      @SuppressWarnings("unused")
      int hinId = 0;
      int specInvHdId = 0;
      Session session = (Session) getSession();

      if (mapForDs.get("serviceNo") != null)
      {
         serviceNo = (String) mapForDs.get("serviceNo");
      }
      if (mapForDs.get("hinNo") != null)
      {
         hinNo = (String) mapForDs.get("hinNo");
      }
      if (mapForDs.get("rankId") != null)
      {
    	  rankId = (Integer) mapForDs.get("rankId");
      }
      if (mapForDs.get("serPersonFName") != null)
      {
         serPersonFName = (String) mapForDs.get("serPersonFName");
      }
      if (mapForDs.get("serPersonLName") != null)
      {
         serPersonLName = (String) mapForDs.get("serPersonLName");
      }
      if (mapForDs.get("patientFName") != null)
      {
         patientFName = (String) mapForDs.get("patientFName");
      }
      if (mapForDs.get("patientLName") != null)
      {
         patientLName = (String) mapForDs.get("patientLName");
      }
      if (mapForDs.get("hinId") != null)
      {
         hinId = (Integer) mapForDs.get("hinId");
      }
      if (mapForDs.get("specInvHdId") != null)
      {
         specInvHdId = (Integer) mapForDs.get("specInvHdId");
      }
      Criteria crit = session.createCriteria(MdSpecialInvestigationHd.class);
      if(!serviceNo.equals("") || !hinNo.equals("") || !patientFName.equals("") || !patientLName.equals("") || !serPersonFName.equals("") || !serPersonLName.equals("")||rankId!=0){
     		crit = crit.createAlias("Hin", "hn");
     		
     	}
      try {
		if (!serviceNo.equals(""))
		  {
		     crit = crit.add(Restrictions.like("hn.ServiceNo", serviceNo + "%"));
		  }

		  if (!patientStatus.equals(""))
		  {
		     crit = crit.add(Restrictions.eq("hn.PatientStatus", patientStatus));
		  }
		  if (!hinNo.equals(""))
		  {
		     crit = crit.add(Restrictions.like("hn.HinNo", hinNo + "%"));
		  }
		  if (!patientFName.equals(""))
		  {
		     crit = crit.add(Restrictions.like("hn.PFirstName", patientFName + "%"));
		  }
		  if (!patientLName.equals(""))
		  {
		     crit = crit.add(Restrictions.like("hn.PLastName", patientLName + "%"));
		  }
		  if (!serPersonFName.equals(""))
		  {
		     crit = crit.add(Restrictions.like("hn.SFirstName", serPersonFName + "%"));
		  }
		  if (!serPersonLName.equals(""))
		  {
		     crit = crit.add(Restrictions.like("hn.SLastName", serPersonLName + "%"));
		  }
		  if (rankId!=0)
		  {
		     crit = crit.createAlias("hn.Rank", "rank").add(Restrictions.eq("rank.Id", rankId));
		  }
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

      patientList = crit.list();
      map.put("patientList", patientList);
      return map;
   }

   public Map<String, Object> showUpdateSpecialInvestigation(int specInvHdId)
   {
      Map<String, Object> map = new HashMap<String, Object>();
      Session session = (Session) getSession();
      MdSpecialInvestigationHd specialInvestigationHd = new MdSpecialInvestigationHd();
      List<MdSpecialInvestigationHd> specialInvestigationList = new ArrayList<MdSpecialInvestigationHd>();
      List<MdSpecialInvestigationDt> specialInvestigationDtList = new ArrayList<MdSpecialInvestigationDt>();
      List<MasReference> hospitalList = new ArrayList<MasReference>();

      specialInvestigationHd = (MdSpecialInvestigationHd) session.load(MdSpecialInvestigationHd.class, specInvHdId);
      specialInvestigationList.add(specialInvestigationHd);
      specialInvestigationDtList = session.createCriteria(MdSpecialInvestigationDt.class).createAlias("SpecialInv", "spec").add(
            Restrictions.eq("spec.Id", specInvHdId)).list();
      hospitalList = session.createCriteria(MasReference.class).add(Restrictions.eq("Status", "y")).list();

      map.put("hospitalList", hospitalList);
      map.put("specialInvestigationList", specialInvestigationList);
      map.put("specialInvestigationDtList", specialInvestigationDtList);
      return map;
   }

   public boolean updateAdvanceClaim(Box box)
   {
      boolean successfullyAdded = false;
      Session session = (Session) getSession();
      Transaction tx = null;
      try
      {
         tx = session.beginTransaction();
         org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
         hbt.setFlushModeName("FLUSH_EAGER");
         hbt.setCheckWriteOperations(false);

         List<MdCardicClaimAdvance> cardicAdvanceList = session.createCriteria(MdCardicClaimAdvance.class).add(Restrictions.eq("Id", box.getInt("cardicAdvanceId"))).list();
         MdCardicClaimAdvance cardicAdvanceObj = (MdCardicClaimAdvance) cardicAdvanceList.get(0);
         int cardicClaimId = cardicAdvanceObj.getId();
         MdCardicClaimAdvance cardicClaimAdvance = (MdCardicClaimAdvance) hbt.load(MdCardicClaimAdvance.class,
               cardicClaimId);

         
         MasIcd masIcd = new MasIcd();
         if (box.getString("diagnosisId") != null && !box.getString("diagnosisId").equals(""))
        	 masIcd.setId(Integer.parseInt(box.getString("diagnosisId")));
         cardicClaimAdvance.setDiagnosis(masIcd);
        /* if (box.getString("detailsOfTreatment") != null && !box.getString("detailsOfTreatment").equals(""))
            cardicClaimAdvance.setTreatmentDetail(box.getString("detailsOfTreatment")); */

         MasEmployee masEmployee = new MasEmployee();
         if (box.getString("specialistName") != null && !box.getString("specialistName").equals(""))
            masEmployee.setId(Integer.parseInt(box.getString("specialistName")));
         cardicClaimAdvance.setSpecialistName(masEmployee);

         MasUnit masUnit = new MasUnit();
         if (box.getString("unitId") != null && !box.getString("unitId").equals(""))
            masUnit.setId(Integer.parseInt(box.getString("unitId")));
         cardicClaimAdvance.setUnitTo(masUnit);

         MasReference masHospital = new MasReference();
         if (box.getString("payableTo") != null && !box.getString("payableTo").equals(""))
            masHospital.setId(Integer.parseInt(box.getString("payableTo")));
         cardicClaimAdvance.setPayableTo(masHospital);
         

         if (box.getString("advanceAmt") != null && !box.getString("advanceAmt").equals(""))
            cardicClaimAdvance.setAdvanceAmount(new BigDecimal(box.getString("advanceAmt")));
         else
            cardicClaimAdvance.setAdvanceAmount(new BigDecimal("0"));

         if (box.getString("qualifyingRs") != null && !box.getString("qualifyingRs").equals(""))
            cardicClaimAdvance.setQualifyingAmount(new BigDecimal(box.getString("qualifyingRs")));
         else
            cardicClaimAdvance.setQualifyingAmount(new BigDecimal("0"));
         
         if (box.getString("cdaPayOffice") != null && !box.getString("cdaPayOffice").equals("")){
             cardicClaimAdvance.setCdaName(box.getString("cdaPayOffice"));
          } 
         if (box.getString("cghsCode") != null && !box.getString("cghsCode").equals(""))
             cardicClaimAdvance.setCghsCode(box.getString("cghsCode"));
         
         cardicClaimAdvance.setIs1(box.getString("is1"));

         if (box.getString("is2") != null && !box.getString("is2").equals(""))
            cardicClaimAdvance.setIs2(new BigDecimal(box.getString("is2")));
         else
            cardicClaimAdvance.setIs2(new BigDecimal("0"));
         
         if (box.getString("cghsRates") != null && !box.getString("cghsRates").equals(""))
             cardicClaimAdvance.setCghsRate(box.getString("cghsRates"));
         

         if (box.getString("basicPay") != null && !box.getString("basicPay").equals("")){
            cardicClaimAdvance.setBasicPay(new BigDecimal(box.getString("basicPay")));
         } else{
            cardicClaimAdvance.setBasicPay(new BigDecimal("0"));
         }
         if (box.getString("identificationMarks1") != null && !box.getString("identificationMarks1").equals(""))
             cardicClaimAdvance.setIdentificationMark(box.getString("identificationMarks1"));
         
         if (box.getString("copy3") != null && !box.getString("copy3").equals(""))
             cardicClaimAdvance.setCopy3(box.getString("copy3"));
         cardicClaimAdvance.setCopy1(box.getString("copy1"));
         if (box.getString("copy2") != null && !box.getString("copy2").equals(""))
            cardicClaimAdvance.setCopy2(box.getString("copy2"));
         if (box.getString("copy3") != null && !box.getString("copy3").equals(""))
            cardicClaimAdvance.setCopy3(box.getString("copy3"));
         cardicClaimAdvance.setDgmsTo(box.getString("dgmsTo"));
         if (box.getString("dispatchDate") != null && !box.getString("dispatchDate").equals(""))
             cardicClaimAdvance.setDgmsDispatchDate(HMSUtil.convertStringTypeDateToDateType(box
                   .getString("dispatchDate")));
         if (box.getString("retirementDate") != null && !box.getString("retirementDate").equals(""))
            cardicClaimAdvance.setRetirementDate(HMSUtil.convertStringTypeDateToDateType(box
                  .getString("retirementDate")));
         
         if (box.getString("cdaDispatchDate") != null && !box.getString("cdaDispatchDate").equals(""))
            cardicClaimAdvance.setUnitDispatchDate(HMSUtil.convertStringTypeDateToDateType(box
                  .getString("cdaDispatchDate")));
         if (box.getString("pao") != null && !box.getString("pao").equals(""))
            cardicClaimAdvance.setPao(box.getString("pao"));
        
         if (box.getString("exPost") != null && !box.getString("exPost").equals(""))
            cardicClaimAdvance.setExPost(box.getString("exPost"));
         cardicClaimAdvance.setLastChgBy(box.getString("changed_by"));
         cardicClaimAdvance.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString("changed_date")));
         cardicClaimAdvance.setLastChgTime(box.getString("changed_time"));
         hbt.update(cardicClaimAdvance);

         successfullyAdded = true;
         tx.commit();
      } catch (Exception e)
      {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();

      } finally
      {
         // --------Session Closing----------
         session.close();
      }
      return successfullyAdded;

   }

   public Map<String, Object> getPateintForCardicAdvance()
   {
      Map<String, Object> map = new HashMap<String, Object>();
      List<MasRank> rankList = new ArrayList<MasRank>();
      Session session = (Session) getSession();
      try
      {
         rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).list();
         map.put("rankList", rankList);
      } catch (Exception e)
      {
         e.printStackTrace();
      }
      return map;
   }

   public Map<String, Object> showPatientUpdateCardicAdvance(Map<String, Object> mapForDs)
   {
	      Map<String, Object> map = new HashMap<String, Object>();
	      List<MdCardicClaimAdvance> patientList = new ArrayList<MdCardicClaimAdvance>();

	      String serviceNo = "";
	      String hinNo = "";
	      String serPersonFName = "";
	      String serPersonLName = "";
	      String patientFName = "";
	      String patientLName = "";
	      int rankId=0;
	      int cardicClaimId = 0;
	      Session session = (Session) getSession();

	      if (mapForDs.get("serviceNo") != null)
	      {
	         serviceNo = (String) mapForDs.get("serviceNo");
	      }
	      if (mapForDs.get("hinNo") != null)
	      {
	         hinNo = (String) mapForDs.get("hinNo");
	      }
	      if (mapForDs.get("rankId") != null)
	      {
	    	  rankId = (Integer) mapForDs.get("rankId");
	      }
	      if (mapForDs.get("serPersonFName") != null)
	      {
	         serPersonFName = (String) mapForDs.get("serPersonFName");
	      }
	      if (mapForDs.get("serPersonLName") != null)
	      {
	         serPersonLName = (String) mapForDs.get("serPersonLName");
	      }
	      if (mapForDs.get("patientFName") != null)
	      {
	         patientFName = (String) mapForDs.get("patientFName");
	      }
	      if (mapForDs.get("patientLName") != null)
	      {
	         patientLName = (String) mapForDs.get("patientLName");
	      }
	      if (mapForDs.get("cardicClaimId") != null)
	      {
	         cardicClaimId = (Integer) mapForDs.get("cardicClaimId");
	      }

	      Criteria crit = session.createCriteria(MdCardicClaimAdvance.class);
	      if(!serviceNo.equals("") || !hinNo.equals("") || !patientFName.equals("") || !patientLName.equals("") || !serPersonFName.equals("") || !serPersonLName.equals("")||rankId!=0){
	     		crit = crit.createAlias("Hin", "hn");
	     		
	     	}
	      if (!serviceNo.equals(""))
	      {
	         String str = serviceNo + "%";
	         crit = crit.add(Restrictions.like("hn.ServiceNo", str));
	      }

	      if (!hinNo.equals(""))
	      {
	         crit = crit.add(Restrictions.like("hn.HinNo", hinNo + "%"));
	      }
	      if (!patientFName.equals(""))
	      {
	         crit = crit.add(Restrictions.like("hn.PFirstName", patientFName + "%"));
	      }
	      if (!patientLName.equals(""))
	      {
	         crit = crit.add(Restrictions.like("hn.PLastName", patientLName + "%"));
	      }
	      if (!serPersonFName.equals(""))
	      {
	         crit = crit.add(Restrictions.like("hn.SFirstName", serPersonFName + "%"));
	      }
	      if (!serPersonLName.equals(""))
	      {
	         crit = crit.add(Restrictions.like("hn.SLastName", serPersonLName + "%"));
	      }
	      if (rankId!=0)
	      {
	         crit = crit.createAlias("hn.Rank", "rank").add(Restrictions.eq("rank.Id", rankId));
	      }
	      patientList = crit.list();
	      map.put("patientList", patientList);
	      return map;
	   }

   public Map<String, Object> showUpdateCardicClaim(int cardicClaimId)
   {
      Map<String, Object> map = new HashMap<String, Object>();
      Session session = (Session) getSession();
      List<MdCardicClaimAdvance> cardicClaimList = new ArrayList<MdCardicClaimAdvance>();
      List<MasHospital> hospitalList = new ArrayList<MasHospital>();
      List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
      cardicClaimList = session.createCriteria(MdCardicClaimAdvance.class).add(Restrictions.eq("Id", cardicClaimId))
            .list();

      hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).list();
      employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
      map.put("hospitalList", hospitalList);
      map.put("employeeList", employeeList);
      map.put("cardicClaimList", cardicClaimList);
      return map;
   }

   public Map<String, Object> getPateintForCardicBill()
   {
      Map<String, Object> map = new HashMap<String, Object>();
      List<MasRank> rankList = new ArrayList<MasRank>();
      Session session = (Session) getSession();
      try
      {
         rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).list();
         map.put("rankList", rankList);
      } catch (Exception e)
      {
         e.printStackTrace();
      }
      return map;
   }

   public Map<String, Object> showPatientUpdateCardicBill(Map<String, Object> mapForDs)
   {
	      Map<String, Object> map = new HashMap<String, Object>();
	      List<MdCardicContingentBillHd> patientList = new ArrayList<MdCardicContingentBillHd>();

	      String serviceNo = "";
	      String hinNo = "";
	      int rankId=0;
	      String serPersonFName = "";
	      String serPersonLName = "";
	      String patientFName = "";
	      String patientLName = "";
	      String patientStatus = "";
	      int hinId = 0;
	      int contingentHdID = 0;
	      Session session = (Session) getSession();

	      if (mapForDs.get("serviceNo") != null)
	      {
	         serviceNo = (String) mapForDs.get("serviceNo");
	      }
	      if (mapForDs.get("hinNo") != null)
	      {
	         hinNo = (String) mapForDs.get("hinNo");
	      }
	      if (mapForDs.get("rankId") != null)
	      {
	    	  rankId = (Integer) mapForDs.get("rankId");
	      }
	      if (mapForDs.get("serPersonFName") != null)
	      {
	         serPersonFName = (String) mapForDs.get("serPersonFName");
	      }
	      if (mapForDs.get("serPersonLName") != null)
	      {
	         serPersonLName = (String) mapForDs.get("serPersonLName");
	      }
	      if (mapForDs.get("patientFName") != null)
	      {
	         patientFName = (String) mapForDs.get("patientFName");
	      }
	      if (mapForDs.get("patientLName") != null)
	      {
	         patientLName = (String) mapForDs.get("patientLName");
	      }
	      if (mapForDs.get("contingentHdID") != null)
	      {
	         contingentHdID = (Integer) mapForDs.get("contingentHdID");
	      }
	      if (mapForDs.get("hinId") != null)
	      {
	         hinId = (Integer) mapForDs.get("hinId");
	      }

	      Criteria crit = session.createCriteria(MdCardicContingentBillHd.class);
	      if(!serviceNo.equals("") || !hinNo.equals("") || !patientFName.equals("") || !patientLName.equals("") || !serPersonFName.equals("") || !serPersonLName.equals("")||rankId!=0){
	     		crit = crit.createAlias("Hin", "hn");
	     		
	     	}
	      if (!serviceNo.equals(""))
	      {
	         String str = serviceNo + "%";
	         crit = crit.add(Restrictions.like("hn.ServiceNo", str));
	      }

	      if (!hinNo.equals(""))
	      {
	         crit = crit.add(Restrictions.like("hn.HinNo", hinNo + "%"));
	      }
	      if (!patientFName.equals(""))
	      {
	         crit = crit.add(Restrictions.like("hn.PFirstName", patientFName + "%"));
	      }
	      if (!patientLName.equals(""))
	      {
	         crit = crit.add(Restrictions.like("hn.PLastName", patientLName + "%"));
	      }
	      if (!serPersonFName.equals(""))
	      {
	         crit = crit.add(Restrictions.like("hn.SFirstName", serPersonFName + "%"));
	      }
	      if (!serPersonLName.equals(""))
	      {
	         crit = crit.add(Restrictions.like("hn.SLastName", serPersonLName + "%"));
	      }
	      if (rankId!=0)
	      {
	         crit = crit.createAlias("hn.Rank", "rank").add(Restrictions.eq("rank.Id", rankId));
	      }
	      patientList = crit.list();
	      map.put("patientList", patientList);

	      return map;
	   }

   public Map<String, Object> showUpdateCardicBill(int contingentHdID)
   {
      Map<String, Object> map = new HashMap<String, Object>();
      Session session = (Session) getSession();
      MdCardicContingentBillHd mdCardicContingentBillHd = new MdCardicContingentBillHd();
      List<MdCardicContingentBillHd> cardicContingentBillList = new ArrayList<MdCardicContingentBillHd>();
      List<MdCardicContingentBillDt> contingentdetailList = new ArrayList<MdCardicContingentBillDt>();
      // cardicContingentBillList =
      // session.createCriteria(MdCardicContingentBillHd.class).add(
      // Restrictions.eq("Id", contingentHdID)).list();
      mdCardicContingentBillHd = (MdCardicContingentBillHd) session
            .load(MdCardicContingentBillHd.class, contingentHdID);
      cardicContingentBillList.add(mdCardicContingentBillHd);
      contingentdetailList = session.createCriteria(MdCardicContingentBillDt.class).createAlias("CardicHd", "ch").add(
            Restrictions.eq("ch.Id", contingentHdID)).list();
      map.put("contingentdetailList", contingentdetailList);
      map.put("cardicContingentBillList", cardicContingentBillList);

      return map;
   }

   public boolean updateCardicBill(Box box)
   {
      boolean successfullyAdded = false;
      Session session = (Session) getSession();
      Transaction tx = null;
      try
      {
         tx = session.beginTransaction();
         org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
         hbt.setFlushModeName("FLUSH_EAGER");
         hbt.setCheckWriteOperations(false);

         List<MdCardicContingentBillHd> cardicContingentBillList = session.createCriteria(
               MdCardicContingentBillHd.class).add(
                       Restrictions.eq("Id", box.getInt("contingentHdID"))).list();
         MdCardicContingentBillHd cardicBillHdObj = (MdCardicContingentBillHd) cardicContingentBillList.get(0);
         int contingentHdID = cardicBillHdObj.getId();
         MdCardicContingentBillHd cardicContingentBillHd = (MdCardicContingentBillHd) hbt.load(
               MdCardicContingentBillHd.class, contingentHdID);
         
         /*if (box.getString("reimbursRs") != null && !box.getString("reimbursRs").equals(""))
             cardicContingentBillHd.setReimburseRs(new BigDecimal(box.getString("reimbursRs")));
          else
             cardicContingentBillHd.setReimburseRs(new BigDecimal("0"));
            */
          if (box.getString("receivedRs") != null && !box.getString("receivedRs").equals(""))
             cardicContingentBillHd.setReceivedRs(new BigDecimal(box.getString("receivedRs")));
          else
             cardicContingentBillHd.setReceivedRs(new BigDecimal("0"));

          if (box.getString("qualifyingRs") != null && !box.getString("qualifyingRs").equals(""))
             cardicContingentBillHd.setQualifyingAmount(new BigDecimal(box.getString("qualifyingRs")));
          else
             cardicContingentBillHd.setQualifyingAmount(new BigDecimal("0"));

         if (box.getString("cghsCode") != null && !box.getString("cghsCode").equals(""))
            cardicContingentBillHd.setCghsCode(box.getString("cghsCode"));

         if (box.getString("payableTo") != null && !box.getString("payableTo").equals(""))
            cardicContingentBillHd.setPayableTo(box.getString("payableTo"));

         cardicContingentBillHd.setIs1(box.getString("is1"));
         
         if (box.getString("is1") != null && !box.getString("is1").equals(""))
             cardicContingentBillHd.setIs1(box.getString("is1"));
          else
             cardicContingentBillHd.setIs1("");

         if (box.getString("is2") != null && !box.getString("is2").equals(""))
            cardicContingentBillHd.setIs2(new BigDecimal(box.getString("is2")));
         else
            cardicContingentBillHd.setIs2(new BigDecimal("0"));

         if (box.getString("cghsRates") != null && !box.getString("cghsRates").equals(""))
            cardicContingentBillHd.setCghsCode(box.getString("cghsRates"));

         cardicContingentBillHd.setLastChgBy(box.getString("changed_by"));
         cardicContingentBillHd.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString("changed_date")));
         cardicContingentBillHd.setLastChgTime(box.getString("changed_time"));
         hbt.update(cardicContingentBillHd);

         int cardicContingentBillHdId = cardicContingentBillHd.getId();
         List<MdCardicContingentBillDt> contingentdetailList = session.createCriteria(MdCardicContingentBillDt.class)
               .createAlias("CardicHd", "cb").add(Restrictions.eq("cb.Id",  box.getInt("contingentHdID"))).list();
         hbt.deleteAll(contingentdetailList);

         try
         {
            Vector bill_no = box.getVector(BILL_NO);
            Vector detail = box.getVector(DETAILS);
            Vector bill_date = box.getVector(BILL_DATE);
            Vector amount = box.getVector(AMOUNT);
            for (int i = 0; i < bill_no.size(); i++)
            {
               if (bill_no.get(i) != null && !bill_no.get(i).equals(""))
               {
                  MdCardicContingentBillDt cardicContingentBillDt = new MdCardicContingentBillDt();
                  cardicContingentBillDt.setCardicHd(new MdCardicContingentBillHd(box.getInt("contingentHdID")));
                  cardicContingentBillDt.setBillNo((String) bill_no.get(i));

                  if (detail.get(i) != null && !detail.get(i).equals(""))
                  {
                      MasChargeCode masChargeCode = new MasChargeCode();
                      masChargeCode.setId(Integer.parseInt((String) detail.get(i)));
                	  cardicContingentBillDt.setDetails(masChargeCode);
                  }
                  if (bill_date.get(i) != null && !bill_date.get(i).equals(""))
                  {
                     cardicContingentBillDt.setBillDate(HMSUtil.convertStringTypeDateToDateType(box.get(BILL_DATE)));
                  }
                  if (detail.get(i) != null && !detail.get(i).equals(""))
                  {
                     cardicContingentBillDt.setAmount(new BigDecimal(box.get(AMOUNT)));
                  }

                  hbt.save(cardicContingentBillDt);

               }
            }
         } catch (RuntimeException e)
         {
            e.printStackTrace();
         }
         successfullyAdded = true;
         tx.commit();
      } catch (Exception e)
      {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();

      } finally
      {
         // --------Session Closing----------
         session.close();
      }
      return successfullyAdded;
   }

   public Map<String, Object> getDataForMedicalBillJsp()
   {
      Session session = (Session) getSession();
      Map<String, Object> map = new HashMap<String, Object>();
      List<MasRank> rankList = new ArrayList<MasRank>();
      try
      {
         rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).list();

      } catch (HibernateException e)
      {
         e.printStackTrace();
      }

      map.put("rankList", rankList);

      return map;
   }

   public Map<String, Object> showPatientUpdateMedicalBill(Map<String, Object> mapForDs)
   {
      Map<String, Object> map = new HashMap<String, Object>();
      List<MdContigentMedicalBillHd> patientList = new ArrayList<MdContigentMedicalBillHd>();
      String serviceNo = "";
      String hinNo = "";
      int rankId = 0;
      String serPersonFName = "";
      String serPersonLName = "";
      String patientFName = "";
      String patientLName = "";
      String patientStatus = "";
      @SuppressWarnings("unused")
      int hinId = 0;
      Session session = (Session) getSession();

      if (mapForDs.get("serviceNo") != null)
      {
         serviceNo = (String) mapForDs.get("serviceNo");
      }
      if (mapForDs.get("hinNo") != null)
      {
         hinNo = (String) mapForDs.get("hinNo");
      }
      if (mapForDs.get("rankId") != null)
      {
    	  rankId = (Integer) mapForDs.get("rankId");
      }
      if (mapForDs.get("serPersonFName") != null)
      {
         serPersonFName = (String) mapForDs.get("serPersonFName");
      }
      if (mapForDs.get("serPersonLName") != null)
      {
         serPersonLName = (String) mapForDs.get("serPersonLName");
      }
      if (mapForDs.get("patientFName") != null)
      {
         patientFName = (String) mapForDs.get("patientFName");
      }
      if (mapForDs.get("patientLName") != null)
      {
         patientLName = (String) mapForDs.get("patientLName");
      }
      if (mapForDs.get("hinId") != null)
      {
         hinId = (Integer) mapForDs.get("hinId");
      }
      Criteria crit = session.createCriteria(MdContigentMedicalBillHd.class).add(
            Restrictions.eq("DispatchStatus", "P"));
      if(!serviceNo.equals("") || !hinNo.equals("") || !patientFName.equals("") || !patientLName.equals("") || !serPersonFName.equals("") || !serPersonLName.equals("")||rankId!=0){
     		crit = crit.createAlias("Hin", "hn");
     		
     	}
      try {
		if (!serviceNo.equals(""))
		  {
		     crit = crit.add(Restrictions.like("hn.ServiceNo", serviceNo + "%"));
		  }
		  if (!hinNo.equals(""))
		  {
		     crit = crit.add(Restrictions.like("hn.HinNo", hinNo + "%"));
		  }
		  if (!patientFName.equals(""))
		  {
		     crit = crit.add(Restrictions.like("hn.PFirstName", patientFName + "%"));
		  }
		  if (!patientLName.equals(""))
		  {
		     crit = crit.add(Restrictions.like("hn.PLastName", patientLName + "%"));
		  }
		  if (!serPersonFName.equals(""))
		  {
		     crit = crit.add(Restrictions.like("hn.SFirstName", serPersonFName + "%"));
		  }
		  if (!serPersonLName.equals(""))
		  {
		     crit = crit.add(Restrictions.like("hn.SLastName", serPersonLName + "%"));
		  }
		  if (rankId!=0)
		  {
		     crit = crit.createAlias("hn.Rank", "rank").add(Restrictions.eq("rank.Id", rankId));
		  }
	} catch (HibernateException e) {
		e.printStackTrace();
	}

      patientList = crit.list();
      map.put("patientList", patientList);
      return map;
   }

   public Map<String, Object> showUpdateMedicalBill(int contingentHdID)
   {
      Map<String, Object> map = new HashMap<String, Object>();
      Session session = (Session) getSession();
      MdContigentMedicalBillHd contigentMedicalBillHd = new MdContigentMedicalBillHd();
      List<MdContigentMedicalBillHd> medicalBillList = new ArrayList<MdContigentMedicalBillHd>();
      List<MdContigentMedicalBillDt> medicalBillDtList = new ArrayList<MdContigentMedicalBillDt>();
      List<MdMasAuthority> authorityList = new ArrayList<MdMasAuthority>();

      contigentMedicalBillHd = (MdContigentMedicalBillHd) session.load(MdContigentMedicalBillHd.class, contingentHdID);
      medicalBillList.add(contigentMedicalBillHd);
      medicalBillDtList = session.createCriteria(MdContigentMedicalBillDt.class).add(
            Restrictions.eq("BillHeader.Id", contingentHdID)).list();
      authorityList = session.createCriteria(MdMasAuthority.class).add(Restrictions.eq("Status", "y")).list();
      map.put("authorityList", authorityList);
      map.put("medicalBillList", medicalBillList);
      map.put("medicalBillDtList", medicalBillDtList);
      return map;
   }

   public boolean updateMedicalBill(Box box)
   {
      boolean successfullyAdded = false;
      Session session = (Session) getSession();
      Transaction tx = null;
      try
      {
         tx = session.beginTransaction();
         org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
         hbt.setFlushModeName("FLUSH_EAGER");
         hbt.setCheckWriteOperations(false);

         int contingentHdID = box.getInt("contigentMedicalBillHdId");
         MdContigentMedicalBillHd contigentMedicalBillHd = (MdContigentMedicalBillHd) hbt.load(
               MdContigentMedicalBillHd.class, contingentHdID);

         if (box.getString("entryDate") != null && !box.getString("entryDate").equals(""))
            contigentMedicalBillHd.setEntryDate(HMSUtil.convertStringTypeDateToDateType(box.getString("entryDate")));

         if (box.getString("claimType") != null && !box.getString("claimType").equals(""))
            contigentMedicalBillHd.setClaimType("claimType");

         if (box.getString("billNo") != null && !box.getString("billNo").equals(""))
            contigentMedicalBillHd.setBillNo("billNo");

         if (box.getString("billDate") != null && !box.getString("billDate").equals(""))
            contigentMedicalBillHd.setBillDate(HMSUtil.convertStringTypeDateToDateType(box.getString("billDate")));

         if (box.getString("amount") != null && !box.getString("amount").equals(""))
            contigentMedicalBillHd.setAmount(new BigDecimal(box.getString("amount")));
         else
            contigentMedicalBillHd.setAmount(new BigDecimal("0"));

         if (box.getString("qualifyingRs") != null && !box.getString("qualifyingRs").equals(""))
            contigentMedicalBillHd.setQualifyingAmount(new BigDecimal(box.getString("qualifyingRs")));
         else
            contigentMedicalBillHd.setQualifyingAmount(new BigDecimal("0"));

         if (box.getString("payableTo") != null && !box.getString("payableTo").equals(""))
            contigentMedicalBillHd.setPayableTo(box.getString("payableTo"));
         else
            contigentMedicalBillHd.setPayableTo("");

         if (box.getString("namePayOfficer") != null && !box.getString("namePayOfficer").equals(""))
            contigentMedicalBillHd.setAccountOfficer(box.getString("namePayOfficer"));
         else
            contigentMedicalBillHd.setPayableTo("");

         if (box.getString("subDate") != null && !box.getString("subDate").equals(""))
            contigentMedicalBillHd.setSubmissionDate(HMSUtil.convertStringTypeDateToDateType(box.getString("subDate")));

         if (box.getString("receivedRs") != null && !box.getString("receivedRs").equals(""))
            contigentMedicalBillHd.setReceivedRs(new BigDecimal(box.getString("receivedRs")));
         else
            contigentMedicalBillHd.setReceivedRs(new BigDecimal("0"));

         MdMasAuthority masAuthority = new MdMasAuthority();
         if (box.getString("authorityId") != null && !box.getString("authorityId").equals(""))
            masAuthority.setId(Integer.parseInt(box.getString("authorityId")));
         contigentMedicalBillHd.setFwtTo(masAuthority);

         if (box.getString("fwtDate") != null && !box.getString("fwtDate").equals(""))
            contigentMedicalBillHd.setFwtDate(HMSUtil.convertStringTypeDateToDateType(box.getString("fwtDate")));

         contigentMedicalBillHd.setLastChgBy(box.getString("changed_by"));
         contigentMedicalBillHd.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString("changed_date")));
         contigentMedicalBillHd.setLastChgTime(box.getString("changed_time"));
         hbt.update(contigentMedicalBillHd);

         int contingentBillHdId = contigentMedicalBillHd.getId();
         List<MdContigentMedicalBillDt> contingentdetailList = session.createCriteria(MdContigentMedicalBillDt.class)
               .createAlias("BillHeader", "bl").add(Restrictions.eq("bl.Id",  box.getInt("contigentMedicalBillHdId"))).list();
               hbt.deleteAll(contingentdetailList);
       //  String qry = "delete from md_contigent_medical_bill_dt where bill_header_id=" + contingentBillHdId + "";
      //   int x = session.createSQLQuery(qry).executeUpdate();

         try
         {
             Vector charge_code_id = box.getVector("chargeId");
             for (int i = 0; i < charge_code_id.size(); i++)
             {
                if (charge_code_id.get(i) != null && !charge_code_id.get(i).equals(""))
                {
                	MdContigentMedicalBillDt contigentMedicalBillDt = new MdContigentMedicalBillDt();

                	contigentMedicalBillDt.setBillHeader(new MdContigentMedicalBillHd(box.getInt("contigentMedicalBillHdId")));

                   if (charge_code_id.get(i) != null && !charge_code_id.get(i).equals(""))
                   {
                      MasChargeCode masChargeCode = new MasChargeCode();
                      masChargeCode.setId(Integer.parseInt((String) charge_code_id.get(i)));
                      contigentMedicalBillDt.setCharge(masChargeCode);
                   }

                   hbt.save(contigentMedicalBillDt);

                }
             }
          } catch (RuntimeException e)
         {
            e.printStackTrace();
         }
         successfullyAdded = true;
         tx.commit();
      } catch (Exception e)
      {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();

      } finally
      {
         // --------Session Closing----------
         session.close();
      }
      return successfullyAdded;
   }

   public Map<String, Object> updateSpecialInvestigation(Box box)
   {
	   Map<String, Object> map = new HashMap<String, Object>();
      boolean successfullyAdded = false;
      Session session = (Session) getSession();
      Transaction tx = null;
      try
      {
         tx = session.beginTransaction();
         org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
         hbt.setFlushModeName("FLUSH_EAGER");
         hbt.setCheckWriteOperations(false);
         List<MdSpecialInvestigationHd> specialInvHdList = session.createCriteria(MdSpecialInvestigationHd.class)
              .add(Restrictions.eq("Id", box.getInt("specInvHdId"))).list();
         
         MdSpecialInvestigationHd specialInvHdObj = (MdSpecialInvestigationHd) specialInvHdList.get(0);
         int specInvHdId = specialInvHdObj.getId();
         MdSpecialInvestigationHd specialInvestigationHd = (MdSpecialInvestigationHd) hbt.load(
               MdSpecialInvestigationHd.class, specInvHdId);

         if (box.getString("date") != null && !box.getString("date").equals(""))
            specialInvestigationHd.setSpecialDate(HMSUtil.convertStringTypeDateToDateType(box.getString("date")));

         
         if (box.getString("refferedTo") != null && !box.getString("refferedTo").equals(""))
        	 specialInvestigationHd.setSuggestTo(box.getString("refferedTo") );
        	 
        	 /*   MasReference masHospital = new MasReference();
        if (box.getString("referredTo") != null && !box.getString("referredTo").equals(""))
            masHospital.setId(Integer.parseInt(box.getString("referredTo")));
         specialInvestigationHd.setReferredTo(masHospital);*/

       
         if (box.getString("diagnosisId") != null && !box.getString("diagnosisId").equals("0"))
        	 specialInvestigationHd.setWorkingDiagnosis(box.getString("diagnosisId"));
        

         if (box.getString("appointmentTime") != null && !box.getString("appointmentTime").equals(""))
            specialInvestigationHd.setAppointmnetTime(box.getString("appointmentTime"));

         if (box.getString("appointmentDate") != null && !box.getString("appointmentDate").equals(""))
            specialInvestigationHd.setAppointmentDate(HMSUtil.convertStringTypeDateToDateType(box
                  .getString("appointmentDate")));

         specialInvestigationHd.setLastChgBy(box.getString("changed_by"));
         specialInvestigationHd.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString("changed_date")));
         specialInvestigationHd.setLastChgTime(box.getString("changed_time"));
         hbt.update(specialInvestigationHd);

         List<MdSpecialInvestigationDt> investigationdetailList = session
         .createCriteria(MdSpecialInvestigationDt.class).createAlias("SpecialInv", "ih").add(
               Restrictions.eq("ih.Id", box.getInt("specInvHdId"))).list();
   hbt.deleteAll(investigationdetailList);

         try
         {
        	 int cnt = box.getInt("hiddenValueCharge");
            for (int i = 1; i <= cnt; i++)
            {
            	int charge_code_id = box.getInt("chargeId"+i);
            	if (charge_code_id!=0)
            	{
            		MdSpecialInvestigationDt specialInvestigationDt = new MdSpecialInvestigationDt();

            		specialInvestigationDt.setSpecialInv(new MdSpecialInvestigationHd(box.getInt("specInvHdId")));

            		MasChargeCode masChargeCode = new MasChargeCode();
            		masChargeCode.setId(charge_code_id);
            		specialInvestigationDt.setCharge(masChargeCode);

            		hbt.save(specialInvestigationDt);

            	}
            }
         } catch (RuntimeException e)
         {
            e.printStackTrace();
         }
         successfullyAdded = true;
         tx.commit();
      } catch (Exception e)
      {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();

      } finally
      {
         // --------Session Closing----------
         session.close();
      }
      map.put("successfullyAdded", successfullyAdded);
      map.put("ID",  box.getInt("specInvHdId"));
      return map;
   }

   public Map<String, Object> getDataForCoveringLettersp()
   {
      Session session = (Session) getSession();
      Map<String, Object> map = new HashMap<String, Object>();
      List<MasUnit> unitList = new ArrayList<MasUnit>();
      try
      {
         unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y")).list();

      } catch (HibernateException e)
      {
         e.printStackTrace();
      }

      map.put("unitList", unitList);

      return map;
   }

   public Map<String, Object> showPatientUpdateCoveringLetter(Map<String, Object> mapForDs)
   {
      Map<String, Object> map = new HashMap<String, Object>();
      List<MdCoveringLetterUnitHd> patientList = new ArrayList<MdCoveringLetterUnitHd>();
      String entryNo = "";
      Date entryDate = new Date();
      int unitId = 0;
      Session session = (Session) getSession();

      if (mapForDs.get("entryNo") != null)
      {
         entryNo = (String) mapForDs.get("entryNo");
      }
      if (mapForDs.get("entryDate") != null)
      {
         entryDate = (Date) mapForDs.get("entryDate");
      }
      if (mapForDs.get("unitId") != null)
      {
         unitId = (Integer) mapForDs.get("unitId");
      }
      Criteria crit = session.createCriteria(MdCoveringLetterUnitHd.class);

      if (!entryNo.equals(""))
      {
         crit = crit.add(Restrictions.like("EntryNo", entryNo + "%"));
      }

      if (!entryDate.equals(""))
      {
         crit = crit.add(Restrictions.like("EntryDate", entryDate));
      }
      if (unitId != 0)
      {
         crit = crit.createAlias("Unit", "un").add(Restrictions.like("un.Id", unitId));
      }

      patientList = crit.list();
      map.put("patientList", patientList);
      return map;
   }

   public Map<String, Object> showUpdateCoveringLetter(int coveringLetterId)
   {
      Map<String, Object> map = new HashMap<String, Object>();
      Session session = (Session) getSession();
      MdCoveringLetterUnitHd coveringLetterUnitHd = new MdCoveringLetterUnitHd();
      List<MdCoveringLetterUnitHd> coveringLetterHdList = new ArrayList<MdCoveringLetterUnitHd>();
      List<MdCoveringLetterUnitDt> coveringLetterDtList = new ArrayList<MdCoveringLetterUnitDt>();

      coveringLetterUnitHd = (MdCoveringLetterUnitHd) session.load(MdCoveringLetterUnitHd.class, coveringLetterId);
      coveringLetterHdList.add(coveringLetterUnitHd);
      coveringLetterDtList = session.createCriteria(MdCoveringLetterUnitDt.class).add(
            Restrictions.eq("CoveringHd.Id", coveringLetterId)).list();

      map.put("coveringLetterHdList", coveringLetterHdList);
      map.put("coveringLetterDtList", coveringLetterDtList);
      return map;
   }

   // -------------Method For Connction of Reports-------------------------
   public Map<String, Object> getConnectionForReport()
   {
      Map<String, Object> connectionMap = new HashMap<String, Object>();
      Session session = (Session) getSession();
      Connection con = session.connection();
      connectionMap.put("con", con);
      return connectionMap;
   }

   // -------Displaying And Generating Numbers-----------
   // --------Dispaly number for Special Investigation-------
  /* public String getyearlySeqForDisplay(String string)
   {
      List<Integer> yearlySeqNoList = new ArrayList<Integer>();
      List<MdSpecialInvestigationHd> seqNoList = new ArrayList<MdSpecialInvestigationHd>();
      String yearlySeqNo = "";
      String lastSeqNo = "";
      String lastSeqYear = "";

      Map<String, Object> utilMap = new HashMap<String, Object>();
      utilMap = (Map) HMSUtil.getCurrentDateAndTime();
      String date = (String) utilMap.get("currentDate");

      String currentYear = date.substring(date.lastIndexOf("/") + 1);
      Session session = (Session) getSession();

      HibernateTemplate hbt = getHibernateTemplate();
      hbt.setFlushModeName("FLUSH_EAGER");
      hbt.setCheckWriteOperations(false);
      try
      {
         seqNoList = session.createCriteria(MdSpecialInvestigationHd.class)
         			.addOrder(Order.desc("Id")).setMaxResults(1).list();
         if (seqNoList.size() > 0)
         {
            for (MdSpecialInvestigationHd specialInvestigationHd : seqNoList)
            {
               lastSeqNo = specialInvestigationHd.getYearlyNo();
            }
            StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
            while (str.hasMoreTokens())
            {
               lastSeqYear = str.nextToken();
            }
         } else
         {
            lastSeqYear = currentYear;
         }

         yearlySeqNoList = session.createCriteria(TransactionSequence.class).add(
               Restrictions.eq("TransactionPrefix", "YRN")).setProjection(
               Projections.projectionList().add(Projections.max("TransactionSequenceNumber"))).list();
         if (yearlySeqNoList.get(0) == null || yearlySeqNoList.size() == 0)
         {
            TransactionSequence tsObj = new TransactionSequence();
            tsObj.setStatus("y");
            tsObj.setTablename("MdSpecialInvestigationHd");
            tsObj.setTransactionPrefix("YRN");
            tsObj.setTransactionSequenceName("YearlySrNo");
            tsObj.setTransactionSequenceNumber(0);
            tsObj.setCreatedby("admin");
            tsObj.setStatus("y");
            hbt.save(tsObj);
            yearlySeqNo = String.valueOf(1);
         } else if (yearlySeqNoList.size() > 0)
         {
            for (Integer maxOrderNo : yearlySeqNoList)
            {
               if (currentYear.equals(lastSeqYear))
               {
                  yearlySeqNo = String.valueOf(maxOrderNo + 1);
               } else
               {
                  yearlySeqNo = String.valueOf(1);
                  lastSeqYear=currentYear;
               }
            }
         }
          yearlySeqNo = yearlySeqNo.concat("/").concat(String.valueOf(lastSeqYear));
         //yearlySeqNo = "01/2010";
      } catch (HibernateException e)
      {
         e.printStackTrace();
      }
      return yearlySeqNo;
   }*/
   
   public String getyearlySeqForDisplay(String string)
   {

		Map<String, Object> map = new HashMap<String, Object>();
		List<TransactionSequence> orderSeqNoList = new ArrayList<TransactionSequence>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = "";

		Session session = (Session) getSession();
		String yearlySeqNo = "";
		date = (String) utilMap.get("currentDate");
		String currentyear = "";
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		String lastOrderNo = "";
		String lastOrderYear = "";
		int seqNo = 1;
		//List<DgOrderhd> orderNoList = new ArrayList<DgOrderhd>();
      /*
		orderNoList = session.createCriteria(DgOrderhd.class).list();
		for (DgOrderhd dgOrderhd : orderNoList) {
			lastOrderNo = dgOrderhd.getOrderNo();
		}
		StringTokenizer str = new StringTokenizer(lastOrderNo, "/");
		while (str.hasMoreTokens()) {

			lastOrderYear = str.nextToken();

		}
		*/
		try {
			orderSeqNoList = session.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "YRN")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (orderSeqNoList.size() > 0) {
			for (TransactionSequence transactionSequence : orderSeqNoList) {
				TransactionSequence obj = (TransactionSequence) orderSeqNoList
						.get(0);
				int id = obj.getId();
				String seqNoStr=obj.getTransactionSequenceNumber().toString();
				lastOrderYear=obj.getMonth().toString();
				if (currentYear.equals(lastOrderYear)) {
					seqNo = Integer.parseInt(seqNoStr);
				} else {
					seqNo = 0;
					lastOrderYear=currentYear;
				}
				seqNo=seqNo+1;
				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
							.load(TransactionSequence.class, id);
		        
				yearlySeqNo = yearlySeqNo.concat(String.valueOf(seqNo));
				//orderSeqNo = orderSeqNo.concat("/").concat(String.valueOf(lastOrderYear));
				transactionSequenceObj.setTransactionSequenceNumber(Integer.parseInt(yearlySeqNo));
				transactionSequenceObj.setMonth(Integer.parseInt(lastOrderYear));
				hbt.update(transactionSequenceObj);
		       hbt.refresh(transactionSequenceObj);
			}
		} else if (orderSeqNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("MdSpecialInvestigationHd");
			tsObj.setTransactionPrefix("YRN");
			tsObj.setTransactionSequenceName("YearlySrNo");
			yearlySeqNo = yearlySeqNo.concat(String.valueOf(seqNo));
			//orderSeqNo = orderSeqNo.concat("/").concat(String.valueOf(currentYear));
			lastOrderYear=currentYear;
			tsObj.setTransactionSequenceNumber(Integer.parseInt(yearlySeqNo));
			tsObj.setMonth(Integer.parseInt(currentYear));
			hbt.save(tsObj);
			
		}		yearlySeqNo = yearlySeqNo.concat("/").concat(String.valueOf(lastOrderYear));
		return yearlySeqNo;
	 }

   // -------------Generate number for Special Investigation----------------
   public String generateYearlyNumber()
   {
      Map<String, Object> map = new HashMap<String, Object>();
      String orderSeqNo = "";
      List<TransactionSequence> yearlySeqNoList = new ArrayList<TransactionSequence>();
      List<MdSpecialInvestigationHd> seqNoList = new ArrayList<MdSpecialInvestigationHd>();
      String lastSeqNo = "";
      String lastSeqYear = "";
      Map<String, Object> utilMap = new HashMap<String, Object>();
      utilMap = (Map) HMSUtil.getCurrentDateAndTime();
      String date = (String) utilMap.get("currentDate");
      String currentYear = date.substring(date.lastIndexOf("/") + 1);
      Session session = (Session) getSession();
      seqNoList = session.createCriteria(MdSpecialInvestigationHd.class).list();
      if (seqNoList.size() > 0)
      {
         for (MdSpecialInvestigationHd specialInvestigationHd : seqNoList)
         {
            lastSeqNo = specialInvestigationHd.getYearlyNo();
         }
         StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
         while (str.hasMoreTokens())
         {
            lastSeqYear = str.nextToken();

         }
      } else if (lastSeqYear.equals(""))
      {
         lastSeqYear = currentYear;
      }
      yearlySeqNoList = session.createCriteria(TransactionSequence.class).add(
            Restrictions.eq("TransactionPrefix", "YRN")).list();

      HibernateTemplate hbt = getHibernateTemplate();
      hbt.setFlushModeName("FLUSH_EAGER");
      hbt.setCheckWriteOperations(false);

      if (yearlySeqNoList.size() > 0)
      {
         for (TransactionSequence transactionSequence : yearlySeqNoList)
         {
            TransactionSequence obj = (TransactionSequence) yearlySeqNoList.get(0);
            int id = obj.getId();
            int seqNo = 0;

            if (currentYear.equals(lastSeqYear))
            {
               seqNo = obj.getTransactionSequenceNumber();
            } else
            {
               seqNo = 0;
               lastSeqYear=currentYear;
            }
            TransactionSequence transactionSequenceObj = (TransactionSequence) hbt.load(TransactionSequence.class, id);
            transactionSequenceObj.setTransactionSequenceNumber(seqNo + 1);
            ++seqNo;
            hbt.update(transactionSequenceObj);
            hbt.refresh(transactionSequenceObj);
            orderSeqNo = orderSeqNo.concat("/").concat(String.valueOf(lastSeqYear));
         }
      } else if (yearlySeqNoList.size() == 0)
      {
         TransactionSequence tsObj = new TransactionSequence();
         tsObj.setStatus("y");
         tsObj.setTablename("MdSpecialInvestigationHd");
         tsObj.setTransactionPrefix("YRN");
         tsObj.setTransactionSequenceName("YearlySrNo");
         tsObj.setTransactionSequenceNumber(0);
         tsObj.setCreatedby("admin");
         tsObj.setStatus("y");
         hbt.save(tsObj);
         orderSeqNo = orderSeqNo.concat("/").concat(String.valueOf(lastSeqYear));
      }
      return orderSeqNo;
   }

   // ---------Display number for Contingent Medical bill-----------------------
   public String getEntrySeqForDisplay(String string)
   {

      List<Integer> entrySeqNoList = new ArrayList<Integer>();
      List<MdContigentMedicalBillHd> seqNoList = new ArrayList<MdContigentMedicalBillHd>();
      String entrySeqNo = "";
      String lastSeqNo = "";
      String lastSeqYear = "";

      Map<String, Object> utilMap = new HashMap<String, Object>();
      utilMap = (Map) HMSUtil.getCurrentDateAndTime();
      String date = (String) utilMap.get("currentDate");

      String currentYear = date.substring(date.lastIndexOf("/") + 1);
      Session session = (Session) getSession();

      HibernateTemplate hbt = getHibernateTemplate();
      hbt.setFlushModeName("FLUSH_EAGER");
      hbt.setCheckWriteOperations(false);
      try
      {
         seqNoList = session.createCriteria(MdContigentMedicalBillHd.class).list();
         if (seqNoList.size() > 0)
         {
            for (MdContigentMedicalBillHd contigentMedicalBillHd : seqNoList)
            {
               lastSeqNo = contigentMedicalBillHd.getEntryNo();
            }
            StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
            while (str.hasMoreTokens())
            {
               lastSeqYear = str.nextToken();
            }
         } else
         {
            lastSeqYear = currentYear;
         }

         entrySeqNoList = session.createCriteria(TransactionSequence.class).add(
               Restrictions.eq("TransactionPrefix", "CMEN")).setProjection(
               Projections.projectionList().add(Projections.max("TransactionSequenceNumber"))).list();
         if (entrySeqNoList.get(0) == null || entrySeqNoList.size() == 0)
         {
            TransactionSequence tsObj = new TransactionSequence();
            tsObj.setStatus("y");
            tsObj.setTablename("MdContigentMedicalBillHd");
            tsObj.setTransactionPrefix("CMEN");
            tsObj.setTransactionSequenceName("Medical Entry No");
            tsObj.setTransactionSequenceNumber(0);
            tsObj.setCreatedby("admin");
            tsObj.setStatus("y");
            hbt.save(tsObj);
            entrySeqNo = String.valueOf(1);
         } else if (entrySeqNoList.size() > 0)
         {
            for (Integer maxOrderNo : entrySeqNoList)
            {
               if (currentYear.equals(lastSeqYear))
               {
                  entrySeqNo = String.valueOf(maxOrderNo + 1);
               } else
               {
                  entrySeqNo = String.valueOf(1);
                  lastSeqYear=currentYear;
               }
            }
         }
         entrySeqNo = entrySeqNo.concat("/").concat(String.valueOf(lastSeqYear));
      } catch (HibernateException e)
      {
         e.printStackTrace();
      }
      return entrySeqNo;
   }

   // ---------Generating number for Contingent Medicalbill---

   public String generateEntryNumber()
   {
      Map<String, Object> map = new HashMap<String, Object>();
      String entrySeqNo = "";
      List<TransactionSequence> yearlySeqNoList = new ArrayList<TransactionSequence>();
      List<MdContigentMedicalBillHd> seqNoList = new ArrayList<MdContigentMedicalBillHd>();
      String lastSeqNo = "";
      String lastSeqYear = "";
      Map<String, Object> utilMap = new HashMap<String, Object>();
      utilMap = (Map) HMSUtil.getCurrentDateAndTime();
      String date = (String) utilMap.get("currentDate");
      String currentYear = date.substring(date.lastIndexOf("/") + 1);
      Session session = (Session) getSession();
      seqNoList = session.createCriteria(MdContigentMedicalBillHd.class).list();
      if (seqNoList.size() > 0)
      {
         for (MdContigentMedicalBillHd contigentMedicalBillHd : seqNoList)
         {
            lastSeqNo = contigentMedicalBillHd.getEntryNo();
         }
         StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
         while (str.hasMoreTokens())
         {
            lastSeqYear = str.nextToken();

         }
      } else if (lastSeqYear.equals(""))
      {
         lastSeqYear = currentYear;
      }
      yearlySeqNoList = session.createCriteria(TransactionSequence.class).add(
            Restrictions.eq("TransactionPrefix", "CMEN")).list();

      HibernateTemplate hbt = getHibernateTemplate();
      hbt.setFlushModeName("FLUSH_EAGER");
      hbt.setCheckWriteOperations(false);

      if (yearlySeqNoList.size() > 0)
      {
         for (TransactionSequence transactionSequence : yearlySeqNoList)
         {
            TransactionSequence obj = (TransactionSequence) yearlySeqNoList.get(0);
            int id = obj.getId();
            int seqNo = 0;

            if (currentYear.equals(lastSeqYear))
            {
               seqNo = obj.getTransactionSequenceNumber();
            } else
            {
               seqNo = 0;
            }
            TransactionSequence transactionSequenceObj = (TransactionSequence) hbt.load(TransactionSequence.class, id);
            transactionSequenceObj.setTransactionSequenceNumber(seqNo + 1);
            ++seqNo;
            hbt.update(transactionSequenceObj);
            hbt.refresh(transactionSequenceObj);
            entrySeqNo = entrySeqNo.concat("/").concat(String.valueOf(lastSeqYear));
         }
      } else if (yearlySeqNoList.size() == 0)
      {
         TransactionSequence tsObj = new TransactionSequence();
         tsObj.setStatus("y");
         tsObj.setTablename("MdContigentMedicalBillHd");
         tsObj.setTransactionPrefix("CMEN");
         tsObj.setTransactionSequenceName("Medical Entry No");
         tsObj.setTransactionSequenceNumber(0);
         tsObj.setCreatedby("admin");
         tsObj.setStatus("y");
         hbt.save(tsObj);
         entrySeqNo = entrySeqNo.concat("/").concat(String.valueOf(lastSeqYear));
      }
      return entrySeqNo;
   }

   // ---------Generating number for Covering Letter-----------------------
   @SuppressWarnings("unchecked")
   public String getCoveringEntrySeqForDisplay(String string)
   {
      List<Integer> entrySeqNoList = new ArrayList<Integer>();
      List<MdCoveringLetterUnitHd> seqNoList = new ArrayList<MdCoveringLetterUnitHd>();
      String entrySeqNo = "";
      String lastSeqNo = "";
      String lastSeqYear = "";

      Map<String, Object> utilMap = new HashMap<String, Object>();
      utilMap = (Map) HMSUtil.getCurrentDateAndTime();
      String date = (String) utilMap.get("currentDate");

      String currentYear = date.substring(date.lastIndexOf("/") + 1);
      Session session = (Session) getSession();

      HibernateTemplate hbt = getHibernateTemplate();
      hbt.setFlushModeName("FLUSH_EAGER");
      hbt.setCheckWriteOperations(false);
      try
      {
         seqNoList = session.createCriteria(MdCoveringLetterUnitHd.class).list();
         if (seqNoList.size() > 0)
         {
            for (MdCoveringLetterUnitHd coveringLetterUnitHd : seqNoList)
            {
               lastSeqNo = coveringLetterUnitHd.getEntryNo();
            }
            StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
            while (str.hasMoreTokens())
            {
               lastSeqYear = str.nextToken();
            }
         } else
         {
            lastSeqYear = currentYear;
         }

         entrySeqNoList = session.createCriteria(TransactionSequence.class).add(
               Restrictions.eq("TransactionPrefix", "CLEN")).setProjection(
               Projections.projectionList().add(Projections.max("TransactionSequenceNumber"))).list();
         if (entrySeqNoList.get(0) == null || entrySeqNoList.size() == 0)
         {
            TransactionSequence tsObj = new TransactionSequence();
            tsObj.setStatus("y");
            tsObj.setTablename("MdCoveringLetterUnitHd");
            tsObj.setTransactionPrefix("CLEN");
            tsObj.setTransactionSequenceName("Covering Entry No");
            tsObj.setTransactionSequenceNumber(0);
            tsObj.setCreatedby("admin");
            tsObj.setStatus("y");
            hbt.save(tsObj);
            entrySeqNo = String.valueOf(1);
         } else if (entrySeqNoList.size() > 0)
         {
            for (Integer maxOrderNo : entrySeqNoList)
            {
               if (currentYear.equals(lastSeqYear))
               {
                  entrySeqNo = String.valueOf(maxOrderNo + 1);
               } else
               {
                  entrySeqNo = String.valueOf(1);
               }
            }
         } else
         {
            entrySeqNo = String.valueOf(1);
         }
         entrySeqNo = entrySeqNo.concat("/").concat(String.valueOf(lastSeqYear));
      } catch (HibernateException e)
      {
         e.printStackTrace();
      }
      return entrySeqNo;
   }

   // ------------generate Covering Letter-------------------

   private String generateCoveringEntryNumber()
   {

	      Map<String, Object> map = new HashMap<String, Object>();
	      String entrySeqNo = "";
	      List<TransactionSequence> yearlySeqNoList = new ArrayList<TransactionSequence>();
	      List<MdCoveringLetterUnitHd> seqNoList = new ArrayList<MdCoveringLetterUnitHd>();
	      String lastSeqNo = "";
	      String lastSeqYear = "";
	      Map<String, Object> utilMap = new HashMap<String, Object>();
	      utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	      String date = (String) utilMap.get("currentDate");
	      String currentYear = date.substring(date.lastIndexOf("/") + 1);
	      Session session = (Session) getSession();
	      seqNoList = session.createCriteria(MdCoveringLetterUnitHd.class).list();
	      if (seqNoList.size() > 0)
	      {
	         for (MdCoveringLetterUnitHd generalCoveringHd : seqNoList)
	         {
	            lastSeqNo = generalCoveringHd.getEntryNo();
	         }
	         StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
	         while (str.hasMoreTokens())
	         {
	            lastSeqYear = str.nextToken();

	         }
	      } else if (lastSeqYear.equals(""))
	      {
	         lastSeqYear = currentYear;
	      }
	      yearlySeqNoList = session.createCriteria(TransactionSequence.class).add(
	            Restrictions.eq("TransactionPrefix", "CLEN")).list();

	      HibernateTemplate hbt = getHibernateTemplate();
	      hbt.setFlushModeName("FLUSH_EAGER");
	      hbt.setCheckWriteOperations(false);

	      if (yearlySeqNoList.size() > 0)
	      {
	         for (TransactionSequence transactionSequence : yearlySeqNoList)
	         {
	            TransactionSequence obj = (TransactionSequence) yearlySeqNoList.get(0);
	            int id = obj.getId();
	            int seqNo = 0;

	            if (currentYear.equals(lastSeqYear))
	            {
	               seqNo = obj.getTransactionSequenceNumber();
	            } else
	            {
	               seqNo = 0;
	               lastSeqYear=currentYear;
	            }
	            try
	            {
	               TransactionSequence transactionSequenceObj = new TransactionSequence();
	               try
	               {
	                  if (id != 0)
	                  {
	                     transactionSequenceObj = (TransactionSequence) session.createCriteria(TransactionSequence.class)
	                           .add(Restrictions.eq("Id", id)).list().get(0);
	                  }
	               } catch (Exception e)
	               {
	                  e.printStackTrace();
	               }

	               transactionSequenceObj.setTransactionSequenceNumber(seqNo + 1);
	               ++seqNo;
	               hbt.update(transactionSequenceObj);
	               hbt.refresh(transactionSequenceObj);
	            } catch (DataAccessException e)
	            {
	               e.printStackTrace();
	            }
	              entrySeqNo=""+seqNo+"/"+lastSeqYear;
	            //entrySeqNo = entrySeqNo.concat("/").concat(String.valueOf(lastSeqYear));
	         }
	      } else if (yearlySeqNoList.size() == 0)
	      {
	    	  TransactionSequence tsObj = new TransactionSequence();
	          tsObj.setStatus("y");
	          tsObj.setTablename("MdCoveringLetterUnitHd");
	          tsObj.setTransactionPrefix("CLEN");
	          tsObj.setTransactionSequenceName("Covering Entry No");
	          tsObj.setTransactionSequenceNumber(1);
	          tsObj.setCreatedby("admin");
	          tsObj.setStatus("y");
	          hbt.save(tsObj);
	          entrySeqNo=""+1+"/"+lastSeqYear ;
	         // entrySeqNo = entrySeqNo.concat("/").concat(String.valueOf(lastSeqYear));
	      }
	      return entrySeqNo;
	   

   }

   // -----------------generate General Covering Letter number-
   public String getGenCoverEntryNoDisplay(String string)
   {
      List<Integer> entrySeqNoList = new ArrayList<Integer>();
      List<MdGeneralCoveringHd> seqNoList = new ArrayList<MdGeneralCoveringHd>();
      String entrySeqNo = "";
      String lastSeqNo = "";
      String lastSeqYear = "";

      Map<String, Object> utilMap = new HashMap<String, Object>();
      utilMap = (Map) HMSUtil.getCurrentDateAndTime();
      String date = (String) utilMap.get("currentDate");

      String currentYear = date.substring(date.lastIndexOf("/") + 1);
      Session session = (Session) getSession();

      HibernateTemplate hbt = getHibernateTemplate();
      hbt.setFlushModeName("FLUSH_EAGER");
      hbt.setCheckWriteOperations(false);
      try
      {
         seqNoList = session.createCriteria(MdGeneralCoveringHd.class).list();
         if (seqNoList.size() > 0)
         {
            for (MdGeneralCoveringHd generalCoveringHd : seqNoList)
            {
               lastSeqNo = generalCoveringHd.getEntryNo();
            }
            StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
            while (str.hasMoreTokens())
            {
               lastSeqYear = str.nextToken();
            }
         } else
         {
            lastSeqYear = currentYear;
         }

         entrySeqNoList = session.createCriteria(TransactionSequence.class).add(
               Restrictions.eq("TransactionPrefix", "GCEN")).setProjection(
               Projections.projectionList().add(Projections.max("TransactionSequenceNumber"))).list();
         if (entrySeqNoList.get(0) == null || entrySeqNoList.size() == 0)
         {
            TransactionSequence tsObj = new TransactionSequence();
            tsObj.setStatus("y");
            tsObj.setTablename("MdGeneralCoveringHd");
            tsObj.setTransactionPrefix("GCEN");
            tsObj.setTransactionSequenceName("GeneralCovering No");
            tsObj.setTransactionSequenceNumber(0);
            tsObj.setCreatedby("admin");
            tsObj.setStatus("y");
            hbt.save(tsObj);
            entrySeqNo = String.valueOf(1);
         } else if (entrySeqNoList.size() > 0)
         {
            for (Integer maxOrderNo : entrySeqNoList)
            {
               if (currentYear.equals(lastSeqYear))
               {
                  entrySeqNo = String.valueOf(maxOrderNo + 1);
               } else
               {
                  entrySeqNo = String.valueOf(1);
               }
            }
         }
         entrySeqNo = entrySeqNo.concat("/").concat(String.valueOf(lastSeqYear));
      } catch (HibernateException e)
      {
         e.printStackTrace();
      }
      return entrySeqNo;
   }

   private String generateGeneralEntryNumber()
   {
      Map<String, Object> map = new HashMap<String, Object>();
      List<TransactionSequence> yearlySeqNoList = new ArrayList<TransactionSequence>();
      List<MdGeneralCoveringHd> seqNoList = new ArrayList<MdGeneralCoveringHd>();
      String lastSeqNo = "";
      String entrySeqNo = "";
      String lastSeqYear = "";
      Map<String, Object> utilMap = new HashMap<String, Object>();
      utilMap = (Map) HMSUtil.getCurrentDateAndTime();
      String date = (String) utilMap.get("currentDate");
      String currentYear = date.substring(date.lastIndexOf("/") + 1);
      Session session = (Session) getSession();
      seqNoList = session.createCriteria(MdGeneralCoveringHd.class).list();
      if (seqNoList.size() > 0)
      {
         for (MdGeneralCoveringHd mdGeneralCoveringHd : seqNoList)
         {
            lastSeqNo = mdGeneralCoveringHd.getEntryNo();
         }
         StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
         while (str.hasMoreTokens())
         {
            lastSeqYear = str.nextToken();

         }
      } else if (lastSeqYear.equals(""))
      {
         lastSeqYear = currentYear;
      }
      yearlySeqNoList = session.createCriteria(TransactionSequence.class).add(
            Restrictions.eq("TransactionPrefix", "GCEN")).list();

      HibernateTemplate hbt = getHibernateTemplate();
      hbt.setFlushModeName("FLUSH_EAGER");
      hbt.setCheckWriteOperations(false);

      if (yearlySeqNoList.size() > 0)
      {
         for (TransactionSequence transactionSequence : yearlySeqNoList)
         {
            TransactionSequence obj = (TransactionSequence) yearlySeqNoList.get(0);
            int id = obj.getId();
            int seqNo = 0;

            if (currentYear.equals(lastSeqYear))
            {
               seqNo = obj.getTransactionSequenceNumber();
            } else
            {
               seqNo = 0;
            }
            TransactionSequence transactionSequenceObj = (TransactionSequence) hbt.load(TransactionSequence.class, id);
            transactionSequenceObj.setTransactionSequenceNumber(seqNo + 1);
            ++seqNo;
            hbt.update(transactionSequenceObj);
            hbt.refresh(transactionSequenceObj);
            entrySeqNo = entrySeqNo.concat("/").concat(String.valueOf(lastSeqYear));
         }
      } else if (yearlySeqNoList.size() == 0)
      {
         TransactionSequence tsObj = new TransactionSequence();
         tsObj.setStatus("y");
         tsObj.setTablename("MdGeneralCoveringHd");
         tsObj.setTransactionPrefix("GCEN");
         tsObj.setTransactionSequenceName("General Entry No");
         tsObj.setTransactionSequenceNumber(0);
         tsObj.setCreatedby("admin");
         tsObj.setStatus("y");
         hbt.save(tsObj);
         entrySeqNo = entrySeqNo.concat("/").concat(String.valueOf(lastSeqYear));
      }
      return entrySeqNo;
   }

   @SuppressWarnings("unchecked")
   public String getyearlyEntryForDisplay(String string)
   {
      List<Integer> yearlySeqNoList = new ArrayList<Integer>();
      List<MdCardicClaimAdvance> seqNoList = new ArrayList<MdCardicClaimAdvance>();
      String entrySeqNo = "";
      String lastSeqNo = "";
      String lastSeqYear = "";

      Map<String, Object> utilMap = new HashMap<String, Object>();
      utilMap = (Map) HMSUtil.getCurrentDateAndTime();
      String date = (String) utilMap.get("currentDate");

      String currentYear = date.substring(date.lastIndexOf("/") + 1);
      Session session = (Session) getSession();

      HibernateTemplate hbt = getHibernateTemplate();
      hbt.setFlushModeName("FLUSH_EAGER");
      hbt.setCheckWriteOperations(false);
      try
      {
         seqNoList = session.createCriteria(MdCardicClaimAdvance.class).list();
         if (seqNoList.size() > 0)
         {
            for (MdCardicClaimAdvance cardicClaimAdvance : seqNoList)
            {
               lastSeqNo = cardicClaimAdvance.getEntryNo();
            }
            StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
            while (str.hasMoreTokens())
            {
               lastSeqYear = str.nextToken();
            }
         } else
         {
            lastSeqYear = currentYear;
         }

         yearlySeqNoList = session.createCriteria(TransactionSequence.class).add(
               Restrictions.eq("TransactionPrefix", "CYEN")).setProjection(
               Projections.projectionList().add(Projections.max("TransactionSequenceNumber"))).list();
         if (yearlySeqNoList.get(0) == null || yearlySeqNoList.size() == 0)
         {
            TransactionSequence tsObj = new TransactionSequence();
            tsObj.setStatus("y");
            tsObj.setTablename("MdCardicClaimAdvance");
            tsObj.setTransactionPrefix("CYEN");
            tsObj.setTransactionSequenceName("Cardic Entry No");
            tsObj.setTransactionSequenceNumber(0);
            tsObj.setCreatedby("admin");
            tsObj.setStatus("y");
            hbt.save(tsObj);
            entrySeqNo = String.valueOf(1);
         } else if (yearlySeqNoList.size() > 0)
         {
            for (Integer maxOrderNo : yearlySeqNoList)
            {
               if (currentYear.equals(lastSeqYear))
               {
                  entrySeqNo = String.valueOf(maxOrderNo + 1);
               } else
               {
                  entrySeqNo = String.valueOf(1);
                  lastSeqYear=currentYear;
               }
            }
         }
         entrySeqNo = entrySeqNo.concat("/").concat(String.valueOf(lastSeqYear));
      } catch (HibernateException e)
      {
         e.printStackTrace();
      }
      return entrySeqNo;
   }

   // ---------generate Cardic Claim Number-------------------
   public String generateAdvanceEntryNumber()
   {
      Map<String, Object> map = new HashMap<String, Object>();
      String entrySeqNo = "";
      List<TransactionSequence> yearlySeqNoList = new ArrayList<TransactionSequence>();
      List<MdCardicClaimAdvance> seqNoList = new ArrayList<MdCardicClaimAdvance>();
      String lastSeqNo = "";
      String lastSeqYear = "";
      Map<String, Object> utilMap = new HashMap<String, Object>();
      utilMap = (Map) HMSUtil.getCurrentDateAndTime();
      String date = (String) utilMap.get("currentDate");
      String currentYear = date.substring(date.lastIndexOf("/") + 1);
      Session session = (Session) getSession();
      seqNoList = session.createCriteria(MdCardicClaimAdvance.class).list();
      if (seqNoList.size() > 0)
      {
         for (MdCardicClaimAdvance cardicClaimAdvance : seqNoList)
         {
            lastSeqNo = cardicClaimAdvance.getEntryNo();
         }
         StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
         while (str.hasMoreTokens())
         {
            lastSeqYear = str.nextToken();

         }
      } else if (lastSeqYear.equals(""))
      {
         lastSeqYear = currentYear;
      }
      yearlySeqNoList = session.createCriteria(TransactionSequence.class).add(
            Restrictions.eq("TransactionPrefix", "CYEN")).list();

      HibernateTemplate hbt = getHibernateTemplate();
      hbt.setFlushModeName("FLUSH_EAGER");
      hbt.setCheckWriteOperations(false);

      if (yearlySeqNoList.size() > 0)
      {
         for (TransactionSequence transactionSequence : yearlySeqNoList)
         {
            TransactionSequence obj = (TransactionSequence) yearlySeqNoList.get(0);
            int id = obj.getId();
            int seqNo = 0;

            if (currentYear.equals(lastSeqYear))
            {
               seqNo = obj.getTransactionSequenceNumber();
            } else
            {
               seqNo = 0;
            }
            TransactionSequence transactionSequenceObj = (TransactionSequence) hbt.load(TransactionSequence.class, id);
            transactionSequenceObj.setTransactionSequenceNumber(seqNo + 1);
            ++seqNo;
            hbt.update(transactionSequenceObj);
            hbt.refresh(transactionSequenceObj);
            entrySeqNo = entrySeqNo.concat("/").concat(String.valueOf(lastSeqYear));
         }
      } else if (yearlySeqNoList.size() == 0)
      {
         TransactionSequence tsObj = new TransactionSequence();
         tsObj.setStatus("y");
         tsObj.setTablename("MdCardicClaimAdvance");
         tsObj.setTransactionPrefix("CYEN");
         tsObj.setTransactionSequenceName("Cardic Entry No");
         tsObj.setTransactionSequenceNumber(0);
         tsObj.setCreatedby("admin");
         tsObj.setStatus("y");
         hbt.save(tsObj);
         entrySeqNo = entrySeqNo.concat("/").concat(String.valueOf(lastSeqYear));
      }
      return entrySeqNo;
   }

   public String getCardicEntryForDisplay(String string)
   {
      List<Integer> yearlySeqNoList = new ArrayList<Integer>();
      List<MdCardicContingentBillHd> seqNoList = new ArrayList<MdCardicContingentBillHd>();
      String entrySeqNo = "";
      String lastSeqNo = "";
      String lastSeqYear = "";

      Map<String, Object> utilMap = new HashMap<String, Object>();
      utilMap = (Map) HMSUtil.getCurrentDateAndTime();
      String date = (String) utilMap.get("currentDate");

      String currentYear = date.substring(date.lastIndexOf("/") + 1);
      Session session = (Session) getSession();

      HibernateTemplate hbt = getHibernateTemplate();
      hbt.setFlushModeName("FLUSH_EAGER");
      hbt.setCheckWriteOperations(false);
      try
      {
         seqNoList = session.createCriteria(MdCardicContingentBillHd.class).list();
         if (seqNoList.size() > 0)
         {
            for (MdCardicContingentBillHd cardicContingentBillHd : seqNoList)
            {
               lastSeqNo = cardicContingentBillHd.getEntryNo();
            }
            StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
            while (str.hasMoreTokens())
            {
               lastSeqYear = str.nextToken();
            }
         } else
         {
            lastSeqYear = currentYear;
         }

         yearlySeqNoList = session.createCriteria(TransactionSequence.class).add(
               Restrictions.eq("TransactionPrefix", "CREN")).setProjection(
               Projections.projectionList().add(Projections.max("TransactionSequenceNumber"))).list();
         if (yearlySeqNoList.get(0) == null || yearlySeqNoList.size() == 0)
         {
            TransactionSequence tsObj = new TransactionSequence();
            tsObj.setStatus("y");
            tsObj.setTablename("MdCardicContingentBillHd");
            tsObj.setTransactionPrefix("CREN");
            tsObj.setTransactionSequenceName("Cardic Reimu Entry No");
            tsObj.setTransactionSequenceNumber(0);
            tsObj.setCreatedby("admin");
            tsObj.setStatus("y");
            hbt.save(tsObj);
            entrySeqNo = String.valueOf(1);
         } else if (yearlySeqNoList.size() > 0)
         {
            for (Integer maxOrderNo : yearlySeqNoList)
            {
               if (currentYear.equals(lastSeqYear))
               {
                  entrySeqNo = String.valueOf(maxOrderNo + 1);
               } else
               {
                  entrySeqNo = String.valueOf(1);
                  lastSeqYear=currentYear;
               }
            }
         }
         entrySeqNo = entrySeqNo.concat("/").concat(String.valueOf(lastSeqYear));
      } catch (HibernateException e)
      {
         e.printStackTrace();
      }
      return entrySeqNo;
   }

@Override
public Map<String, Object> showApprovePatientSearchContBill() {
    Map<String, Object> map = new HashMap<String, Object>();
    List<MasRank> rankList = new ArrayList<MasRank>();
    Session session = (Session) getSession();
    Date date=new Date();
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
    String currentDate=sdf.format(date);
    String from_Date=currentDate.substring(0,2)+"/"+(Integer.parseInt(currentDate.substring(3,5))-1)+"/"+currentDate.substring(6);
    Date fromDate=HMSUtil.dateFormatterDDMMYYYY(from_Date);
    Date toDate=HMSUtil.dateFormatterDDMMYYYY(currentDate);
    List<MdContigentMedicalBillHd> patientList=null;
    try
    {
       rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankName")).list();
       map.put("rankList", rankList);
       patientList= session.createCriteria(MdContigentMedicalBillHd.class)
                                     .add(Restrictions.between("EntryDate", fromDate, toDate)) 
                                     .add(Restrictions.eq("DispatchStatus","P" )).list();
    } catch (Exception e)
    {
       e.printStackTrace();
    }
    map.put("patientList", patientList);
    return map;
 }

@Override
public Map<String, Object> getApprovePatientContingentBill(
		Map<String, Object> mapForDs) {
    Map<String, Object> map = new HashMap<String, Object>();
    List<MdMasAuthority> authorityList = new ArrayList<MdMasAuthority>();
    List<MasChargeCode> chargeList = new ArrayList<MasChargeCode>();
    List<Patient> patientList = new ArrayList<Patient>();
    List<MdContigentMedicalBillDt> masInvestigationDtList = new ArrayList<MdContigentMedicalBillDt>();
    
    MdContigentMedicalBillHd specialInvestigationHd = new MdContigentMedicalBillHd();
    List<MdContigentMedicalBillHd> specialInvHdList = new ArrayList<MdContigentMedicalBillHd>();
    List<MdContigentMedicalBillDt> specialInvestigationDtList = new ArrayList<MdContigentMedicalBillDt>();
    int hinId = 0;
    int Id=(Integer) mapForDs.get("contHdId");
    System.out.println("contHdId--in DS----DS---->"+Id);
    Session session = (Session) getSession();
    authorityList = session.createCriteria(MdMasAuthority.class).add(Restrictions.eq("Status", "y")).list();
    chargeList = session.createCriteria(MasChargeCode.class).add(Restrictions.eq("Status", "y")).list();
    masInvestigationDtList = getHibernateTemplate().find(
  	      "from jkt.hms.masters.business.MdContigentMedicalBillDt imc where imc.BillHeader.Id='"+Id+"'");
    if (mapForDs != null && mapForDs.size() > 0)
       specialInvHdList = session.createCriteria(MdContigentMedicalBillHd.class).add(
             Restrictions.eq("Id", (Integer) mapForDs.get("contHdId"))).list();
    System.out.println("specialInvHdList--in DS first---->"+specialInvHdList.size());
    if (specialInvHdList != null && specialInvHdList.size() > 0)
    {
       map.put("specialInvHdList", specialInvHdList);
    }

    hinId = specialInvHdList.get(0).getHin().getId();
    patientList = session.createCriteria(Patient.class).add(Restrictions.eq("Id", hinId)).add(Restrictions.not(Restrictions.eq("PatientStatus", "Expired"))).list();
    if (patientList != null || patientList.size() > 0)
    {
       map.put("patientDetailList", patientList);
    }
    map.put("authorityList", authorityList);
    map.put("chargeList", chargeList);
    map.put("masInvestigationDtList", masInvestigationDtList);
    return map;
 }

@Override
public Map<String, Object> getApprovePatientContBillDetails(
		Map<String, Object> mapForDs) {
	/*   Map<String, Object> map = new HashMap<String, Object>();
	   List<MdMasAuthority> authorityList = new ArrayList<MdMasAuthority>();
	   List<MasChargeCode> chargeList = new ArrayList<MasChargeCode>();
	   List<Patient> patientList = new ArrayList<Patient>();
	    List<MdContigentMedicalBillHd> specialInvHdList = new ArrayList<MdContigentMedicalBillHd>();
	   Session session = (Session) getSession();
	   authorityList = session.createCriteria(MdMasAuthority.class).add(Restrictions.eq("Status", "y")).list();
	   chargeList = session.createCriteria(MasChargeCode.class).add(Restrictions.eq("Status", "y")).list();
	   specialInvHdList = session.createCriteria(MdContigentMedicalBillHd.class).add(
	         Restrictions.eq("Id", (Integer) mapForDs.get("contHdId"))).list();

	   if (specialInvHdList != null && specialInvHdList.size() > 0)
	   {
	      map.put("specialInvHdList", specialInvHdList);
	   }
	   map.put("authorityList", authorityList);
	   map.put("chargeList", chargeList);

	   return map;*/
	   
	   
	   
	   

	      Map<String, Object> map = new HashMap<String, Object>();
	      List<MdContigentMedicalBillHd> patientList = new ArrayList<MdContigentMedicalBillHd>();

	      String serviceNo = "";
	      String hinNo = "";
	      String serPersonFName = "";
	      String serPersonLName = "";
	      String patientFName = "";
	      String patientLName = "";
	      String patientStatus = "";
	      int rankId=0;
	      int hinId = 0;
	      int specInvHdId = 0;
	      Session session = (Session) getSession();

	      if (mapForDs.get("serviceNo") != null)
	      {
	         serviceNo = (String) mapForDs.get("serviceNo");
	      }
	      if (mapForDs.get("hinNo") != null)
	      {
	         hinNo = (String) mapForDs.get("hinNo");
	      }
	      if (mapForDs.get("rankId") != null)
	      {
	    	  rankId = (Integer) mapForDs.get("rankId");
	      }
	      if (mapForDs.get("serPersonFName") != null)
	      {
	         serPersonFName = (String) mapForDs.get("serPersonFName");
	      }
	      if (mapForDs.get("serPersonLName") != null)
	      {
	         serPersonLName = (String) mapForDs.get("serPersonLName");
	      }
	      if (mapForDs.get("patientFName") != null)
	      {
	         patientFName = (String) mapForDs.get("patientFName");
	      }
	      if (mapForDs.get("patientLName") != null)
	      {
	         patientLName = (String) mapForDs.get("patientLName");
	      }
	      if (mapForDs.get("specInvHdId") != null)
	      {
	         specInvHdId = (Integer) mapForDs.get("specInvHdId");
	      }
	      if (mapForDs.get("hinId") != null)
	      {
	         hinId = (Integer) mapForDs.get("hinId");
	      }
	      Criteria crit = session.createCriteria(MdContigentMedicalBillHd.class).createAlias("Hin", "hn")
	                        .add(Restrictions.eq("DispatchStatus","P" ));
	      if (!serviceNo.equals(""))
	      {
	         String str = serviceNo + "%";
	         crit = crit.add(Restrictions.like("hn.ServiceNo", str));
	      }
	      if (!hinNo.equals(""))
	      {
	         crit = crit.add(Restrictions.like("hn.HinNo", hinNo + "%"));
	      }
	      if (!patientFName.equals(""))
	      {
	         crit = crit.add(Restrictions.like("hn.PFirstName", patientFName + "%"));
	      }
	      if (!patientLName.equals(""))
	      {
	         crit = crit.add(Restrictions.like("hn.PLastName", patientLName + "%"));
	      }
	      if (!serPersonFName.equals(""))
	      {
	         crit = crit.add(Restrictions.like("hn.SFirstName", serPersonFName + "%"));
	      }
	      if (!serPersonLName.equals(""))
	      {
	         crit = crit.add(Restrictions.like("hn.SLastName", serPersonLName + "%"));
	      }
	      if (rankId!=0)
	      {
	         crit = crit.createAlias("hn.Rank", "rank").add(Restrictions.eq("rank.Id", rankId));
	      }
	      patientList = crit.list();
	      map.put("patientList", patientList);
	      return map;
	   
}

@Override
public MdContigentMedicalBillHd loadContBillObj(int contHdId) {
	
	HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);

	MdContigentMedicalBillHd contigentMedicalBillHd = new MdContigentMedicalBillHd();
	try {

		contigentMedicalBillHd = (MdContigentMedicalBillHd) hbt.load(MdContigentMedicalBillHd.class, contHdId);
	} catch (DataAccessException e) {
		e.printStackTrace();
	}
	return contigentMedicalBillHd;
}

@Override
public Map<String, Object> validateContBill(Map<String, Object> infoMap) {
	Map<String, Object> map = new HashMap<String, Object>();
	boolean saved = false;
	HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	
	 MdContigentMedicalBillHd contigentMedicalBillHd = new MdContigentMedicalBillHd();
	if (infoMap.get("contigentMedicalBillHd") != null) {
		contigentMedicalBillHd = (MdContigentMedicalBillHd) infoMap.get("contigentMedicalBillHd");
	}
	try{
	hbt.update(contigentMedicalBillHd);
	}catch (Exception e) {
		e.printStackTrace();}
	saved=true;
	map.put("saved",saved);
	map.put("contigentMedicalBill_Id",contigentMedicalBillHd.getId() );
	return map;
}
}
