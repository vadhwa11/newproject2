package jkt.hms.referral.dataservice;



import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.LAST_CHANGED_TIME;
import static jkt.hms.util.RequestConstants.TO_DATE;
import static jkt.hms.util.RequestConstants.USER_ID;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.ByteBuffer;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import jkt.hms.masters.business.DischargeIcdCode;
import jkt.hms.masters.business.InjAppointmentDetails;
import jkt.hms.masters.business.InjAppointmentHeader;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDivision;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasEmployeeDependent;
import jkt.hms.masters.business.MasFrequency;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasImpanneledHospital;
import jkt.hms.masters.business.MasMaritalStatus;
import jkt.hms.masters.business.MasMedicalExaminationDetail;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasRankCategory;
import jkt.hms.masters.business.MasRelation;
import jkt.hms.masters.business.MasSection;
import jkt.hms.masters.business.MasServiceStatus;
import jkt.hms.masters.business.MasServiceType;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasTherapyType;
import jkt.hms.masters.business.MasTitle;
import jkt.hms.masters.business.MasTrade;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.MasWardImpanneledHospital;
import jkt.hms.masters.business.OpdPatientDetails;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PatientDietIndoorDetail;
import jkt.hms.masters.business.PatientPrescriptionDetails;
import jkt.hms.masters.business.PatientPrescriptionHeader;
import jkt.hms.masters.business.ReferralClarificationDetails;
import jkt.hms.masters.business.ReferralClarrificationHeader;
import jkt.hms.masters.business.ReferralNotesheetHeader;
import jkt.hms.masters.business.ReferralPatientBilling;
import jkt.hms.masters.business.ReferralPatientDetails;
import jkt.hms.masters.business.ReferralPatientHeader;
import jkt.hms.masters.business.StoreInternalIndentT;
import jkt.hms.masters.business.StoreItemBatchStock;
import jkt.hms.masters.business.StoreMaterialPurchaseReqT;
import jkt.hms.masters.business.StoreQuotationRequestM;
import jkt.hms.masters.business.UploadDocuments;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.Visit;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class ReferralDataServiceImpl extends HibernateDaoSupport implements ReferralDataService {

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getReferralWaitingList(Box box) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		Criteria cr = null;
		List<OpdPatientDetails> OpdPatientDetailsEmpanelledList = new ArrayList<OpdPatientDetails>();	
		Session session = (Session) getSession();
		int pagingSize = 10;
		int pageNo = 1;	
		int hospitalId = box.getInt("hospitalId");		
		String empNo ="";
		String referralNo ="";
		int impHospitalId = 0;
        int divisionId = 0;		
		String ServiceNo = box.getString("ServiceNo");
		if (box.getString("PN") != null)
			pageNo = Integer.parseInt(box.getString("PN"));	
		
		if (box.getString("empNo") != null)
			empNo = box.getString("empNo");
		if (box.getString("referralNo") != null)
			referralNo = box.getString("referralNo");
		if (box.get("impHospitalId") != null)
			impHospitalId = box.getInt("impHospitalId");
		if (box.get("divisionId") != null)
			divisionId = box.getInt("divisionId");	
		
		cr = session.createCriteria(OpdPatientDetails.class)		
				.createAlias("Visit", "v")
				.createAlias("v.Hin", "hin")
				.createAlias("hin.Employee", "emp")
				.add(Restrictions.eq("EmpanelStatus", "WR"))
				//.add(Restrictions.eq("ReferredType", "Empanel"))
				.add(Restrictions.or(Restrictions.eq("ReferredType", "Both"), Restrictions.eq("ReferredType", "Empanel")))
				.add(Restrictions.eq("Hospital.Id", hospitalId))
                .addOrder(Order.desc("ReferredDate"));		
		
		   if (!empNo.equals("")) {
				
				cr = cr.add(Restrictions.eq("emp.ServiceNo", empNo));
			}
			
			if (impHospitalId != 0 ) {
				cr = cr.createAlias("ImpanneledHospital", "th");
				cr = cr.add(Restrictions.eq("th.Id", impHospitalId));
			}
			
			if (divisionId != 0 ) {
				
				cr = cr.add(Restrictions.eq("emp.Division.Id", divisionId));
			}
				
		
		
		List totalMatches = cr.list();
		cr = cr.setFirstResult(pagingSize * (pageNo - 1));
		cr = cr.setMaxResults(pagingSize);
		OpdPatientDetailsEmpanelledList = cr.list();
		System.out.println("totalMatches"+totalMatches.size());
		System.out.println("totalMatches"+OpdPatientDetailsEmpanelledList.size());

		int totalRecords = totalMatches.size();
		totalMatches.clear();	
		map.put("OpdPatientDetailsEmpanelledList", OpdPatientDetailsEmpanelledList);		
		map.put("totalRecords", totalRecords);
		
				
		return map;
	}
	
	
	@Override
	public Map<String, Object> getReferralWaitingListForDoctor(Box box) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		Criteria cr = null;
		List<OpdPatientDetails> OpdPatientDetailsEmpanelledList = new ArrayList<OpdPatientDetails>();	
		Session session = (Session) getSession();
		int pagingSize = 10;
		int pageNo = 1;	
		int hospitalId = box.getInt("hospitalId");
		int empId = box.getInt("empId");
		String empNo ="";
		String referralNo ="";
		int impHospitalId = 0;
        int divisionId = 0;	
         
        String date = "";
		String ServiceNo = box.getString("ServiceNo");
		if (box.getString("PN") != null)
			pageNo = Integer.parseInt(box.getString("PN"));	
		
		if (box.getString("empNo") != null)
			empNo = box.getString("empNo");
		if (box.getString("referralNo") != null)
			referralNo = box.getString("referralNo");
		if (box.get("impHospitalId") != null)
			impHospitalId = box.getInt("impHospitalId");
		if (box.get("divisionId") != null)
			divisionId = box.getInt("divisionId");	
		if (box.get("date") != null)
			date = box.getString("date");	
		
		System.out.println("fromDate"+date);
		
		cr = session.createCriteria(OpdPatientDetails.class)
				/*.add(Restrictions.eq("EmpanelStatus", "WR"))*/
				.createAlias("Visit", "v")
				.createAlias("v.Hin", "hin")
				.createAlias("hin.Employee", "emp")
				.add(Restrictions.eq("ReferredType", "Empanel"))
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.eq("Employee.Id", empId))
		        .addOrder(Order.desc("ReferredDate"));	
		
		  if (!empNo.equals("")) {
				
				cr = cr.add(Restrictions.eq("emp.ServiceNo", empNo));
			}
		   
		   if (!date.equals("")) {
				
				cr = cr.add(Restrictions.eq("ReferredDate", HMSUtil.convertStringTypeDateToDateType(date)));
			}
			
			if (impHospitalId != 0 ) {
				cr = cr.createAlias("ImpanneledHospital", "th");
				cr = cr.add(Restrictions.eq("th.Id", impHospitalId));
			}
			
            if (divisionId != 0 ) {
				
				cr = cr.add(Restrictions.eq("emp.Division.Id", divisionId));
			}
				
		
		
		List totalMatches = cr.list();
		cr = cr.setFirstResult(pagingSize * (pageNo - 1));
		cr = cr.setMaxResults(pagingSize);
		OpdPatientDetailsEmpanelledList = cr.list();
		System.out.println("totalMatches"+totalMatches.size());
		System.out.println("totalMatches"+OpdPatientDetailsEmpanelledList.size());

		int totalRecords = totalMatches.size();
		totalMatches.clear();	
		map.put("OpdPatientDetailsEmpanelledList", OpdPatientDetailsEmpanelledList);		
		map.put("totalRecords", totalRecords);
		
				
		return map;
	}
	
	@Override
	public Map<String, Object> getExtensionWaitingList(Box box) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		Criteria cr = null;
		List<ReferralPatientHeader> referralPatientHeaderExtensionList = new ArrayList<ReferralPatientHeader>();	
		Session session = (Session) getSession();
		int pagingSize = 10;
		int pageNo = 1;	
		int hospitalId = box.getInt("hospitalId");
		String ServiceNo = box.getString("ServiceNo");
		String empNo ="";
		int impHospitalId = 0;
        int rankCategoryId = 0;
        int divisionId = 0;
		if (box.getString("empNo") != null)
			empNo = box.getString("empNo");
		if (box.get("impHospitalId") != null)
			impHospitalId = box.getInt("impHospitalId");
		if (box.get("rankCategoryId") != null)
			rankCategoryId = box.getInt("rankCategoryId");
		if (box.get("divisionId") != null)
			divisionId = box.getInt("divisionId");	
		
		if (box.getString("PN") != null)
			pageNo = Integer.parseInt(box.getString("PN"));	
		
		cr = session.createCriteria(ReferralPatientHeader.class)
				.add(Restrictions.eq("ExtensionStatus", "DA"))				
				.add(Restrictions.eq("Hospital.Id", hospitalId));
		 if (!empNo.equals("")) {
				
				cr = cr.add(Restrictions.eq("EmpNo", empNo));
			}
			
			if (impHospitalId != 0 ) {
				cr = cr.createAlias("ToHospital", "th");
				cr = cr.add(Restrictions.eq("th.Id", impHospitalId));
			}
			
			if (rankCategoryId != 0 ) {
				cr = cr.createAlias("Hin", "hin");
				cr = cr.createAlias("hin.Employee", "emp");
				cr = cr.createAlias("emp.RankCategory", "rc");
				cr = cr.add(Restrictions.eq("rc.Id", rankCategoryId));
			}
			
			if (divisionId != 0 ) {
				
				cr = cr.add(Restrictions.eq("Division.Id", divisionId));
			}		
		
		
		List totalMatches = cr.list();
		cr = cr.setFirstResult(pagingSize * (pageNo - 1));
		cr = cr.setMaxResults(pagingSize);
		referralPatientHeaderExtensionList = cr.list();
		

		int totalRecords = totalMatches.size();
		totalMatches.clear();	
		map.put("referralPatientHeaderExtensionList", referralPatientHeaderExtensionList);		
		map.put("totalRecords", totalRecords);
		
				
		return map;
	}
	
	@Override
	public Map<String, Object> getInvoiceWaitingList(Box box) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		Criteria cr = null;
		/*List<OpdPatientDetails> OpdPatientDetailsEmpanelledList = new ArrayList<OpdPatientDetails>();	*/
		List<ReferralPatientHeader> referralPatientHeaderList = new ArrayList<ReferralPatientHeader>();
		Session session = (Session) getSession();
		int pagingSize = 10;
		int pageNo = 1;	
		int hospitalId = box.getInt("hospitalId");
		String ServiceNo = box.getString("ServiceNo");
		if (box.getString("PN") != null)
			pageNo = Integer.parseInt(box.getString("PN"));	
		
		String empNo ="";
		String referralNo ="";
		int impHospitalId = 0;
        int rankCategoryId = 0;
        int divisionId = 0;
		if (box.getString("empNo") != null)
			empNo = box.getString("empNo");
		if (box.getString("referralNo") != null)
			referralNo = box.getString("referralNo");
		if (box.get("impHospitalId") != null)
			impHospitalId = box.getInt("impHospitalId");
		if (box.get("rankCategoryId") != null)
			rankCategoryId = box.getInt("rankCategoryId");
		if (box.get("divisionId") != null)
			divisionId = box.getInt("divisionId");	
		
		System.out.println("referralNo"+referralNo);
		cr = session.createCriteria(ReferralPatientHeader.class)
				.add(Restrictions.eq("ApprovalStatus", "WA").ignoreCase())			
				.add(Restrictions.eq("FromHospital.Id", hospitalId))
				.addOrder(Order.desc("LastChgDate"))
		        .addOrder(Order.desc("LastChgTime")); 
		
		 if (!empNo.equals("")) {
				
				cr = cr.add(Restrictions.eq("EmpNo", empNo));
			}
		 
		 if (!referralNo.equals("")) {
				
				cr = cr.add(Restrictions.eq("ReferralNo", referralNo));
			}
			
			if (impHospitalId != 0 ) {
				cr = cr.createAlias("ToHospital", "th");
				cr = cr.add(Restrictions.eq("th.Id", impHospitalId));
			}
			
			if (rankCategoryId != 0 ) {
				cr = cr.createAlias("Hin", "hin");
				cr = cr.createAlias("hin.Employee", "emp");
				cr = cr.createAlias("emp.RankCategory", "rc");
				cr = cr.add(Restrictions.eq("rc.Id", rankCategoryId));
			}
			
			if (divisionId != 0 ) {
				
				cr = cr.add(Restrictions.eq("Division.Id", divisionId));
			}
		
		List totalMatches = cr.list();
		cr = cr.setFirstResult(pagingSize * (pageNo - 1));
		cr = cr.setMaxResults(pagingSize);
		referralPatientHeaderList = cr.list();
		
	
		int totalRecords = totalMatches.size();
		totalMatches.clear();	
		/*map.put("OpdPatientDetailsEmpanelledList", OpdPatientDetailsEmpanelledList);*/
		map.put("referralPatientHeaderList", referralPatientHeaderList);
		System.out.println("referralPatientHeaderList"+referralPatientHeaderList.size());
		System.out.println("totalRecords"+totalRecords);
		
		map.put("totalRecords", totalRecords);
		
				
		return map;
	}
	
	@Override
	public Map<String, Object> getInvoiceWaitingListRejected(Box box) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		Criteria cr = null;
		/*List<OpdPatientDetails> OpdPatientDetailsEmpanelledList = new ArrayList<OpdPatientDetails>();	*/
		List<ReferralPatientHeader> referralPatientHeaderList = new ArrayList<ReferralPatientHeader>();
		Session session = (Session) getSession();
		int pagingSize = 10;
		int pageNo = 1;	
		int hospitalId = box.getInt("hospitalId");
		String ServiceNo = box.getString("ServiceNo");
		if (box.getString("PN") != null)
			pageNo = Integer.parseInt(box.getString("PN"));	
		
		String empNo ="";
		String referralNo ="";
		int impHospitalId = 0;
        int rankCategoryId = 0;
        int divisionId = 0;
		if (box.getString("empNo") != null)
			empNo = box.getString("empNo");
		if (box.getString("referralNo") != null)
			referralNo = box.getString("referralNo");
		if (box.get("impHospitalId") != null)
			impHospitalId = box.getInt("impHospitalId");
		if (box.get("rankCategoryId") != null)
			rankCategoryId = box.getInt("rankCategoryId");
		if (box.get("divisionId") != null)
			divisionId = box.getInt("divisionId");	
		
		System.out.println("referralNo"+referralNo);
		cr = session.createCriteria(ReferralPatientHeader.class)
				.add(Restrictions.or(Restrictions.eq("ApprovalStatus", "RHD").ignoreCase(), Restrictions.eq("ApprovalStatus", "RA").ignoreCase()))		
				.add(Restrictions.eq("FromHospital.Id", hospitalId))
				.addOrder(Order.desc("LastChgDate"))
				.addOrder(Order.desc("LastChgTime"));
		
		 if (!empNo.equals("")) {
				
				cr = cr.add(Restrictions.eq("EmpNo", empNo));
			}
		 
		 if (!referralNo.equals("")) {
				
				cr = cr.add(Restrictions.eq("ReferralNo", referralNo));
			}
			
			if (impHospitalId != 0 ) {
				cr = cr.createAlias("ToHospital", "th");
				cr = cr.add(Restrictions.eq("th.Id", impHospitalId));
			}
			
			if (rankCategoryId != 0 ) {
				cr = cr.createAlias("Hin", "hin");
				cr = cr.createAlias("hin.Employee", "emp");
				cr = cr.createAlias("emp.RankCategory", "rc");
				cr = cr.add(Restrictions.eq("rc.Id", rankCategoryId));
			}
			
			if (divisionId != 0 ) {
				
				cr = cr.add(Restrictions.eq("Division.Id", divisionId));
			}
		
		List totalMatches = cr.list();
		cr = cr.setFirstResult(pagingSize * (pageNo - 1));
		cr = cr.setMaxResults(pagingSize);
		referralPatientHeaderList = cr.list();
		
	
		int totalRecords = totalMatches.size();
		totalMatches.clear();	
		/*map.put("OpdPatientDetailsEmpanelledList", OpdPatientDetailsEmpanelledList);*/
		map.put("referralPatientHeaderList", referralPatientHeaderList);
		System.out.println("referralPatientHeaderList"+referralPatientHeaderList.size());
		System.out.println("totalRecords"+totalRecords);
		
		map.put("totalRecords", totalRecords);
		
				
		return map;
	}
	
	@Override
	public Map<String, Object> getInvoiceWaitingListAlreadySend(Box box) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		Criteria cr = null;
		/*List<OpdPatientDetails> OpdPatientDetailsEmpanelledList = new ArrayList<OpdPatientDetails>();	*/
		List<ReferralPatientHeader> referralPatientHeaderList = new ArrayList<ReferralPatientHeader>();
		Session session = (Session) getSession();
		int pagingSize = 10;
		int pageNo = 1;	
		int hospitalId = box.getInt("hospitalId");
		String ServiceNo = box.getString("ServiceNo");
		if (box.getString("PN") != null)
			pageNo = Integer.parseInt(box.getString("PN"));	
		
		String empNo ="";
		String referralNo ="";
		int impHospitalId = 0;
        int rankCategoryId = 0;
        int divisionId = 0;
		if (box.getString("empNo") != null)
			empNo = box.getString("empNo");
		if (box.getString("referralNo") != null)
			referralNo = box.getString("referralNo");
		if (box.get("impHospitalId") != null)
			impHospitalId = box.getInt("impHospitalId");
		if (box.get("rankCategoryId") != null)
			rankCategoryId = box.getInt("rankCategoryId");
		if (box.get("divisionId") != null)
			divisionId = box.getInt("divisionId");	
		String[] status = {"WHD", "WNS","RFA", "WFA", "FA", "PFD", "WCB", "C"};
		System.out.println("referralNo"+referralNo);
		cr = session.createCriteria(ReferralPatientHeader.class)
				.add(Restrictions.in("ApprovalStatus", status))				
				.add(Restrictions.eq("FromHospital.Id", hospitalId))
				.addOrder(Order.desc("LastChgDate"))
				.addOrder(Order.desc("LastChgTime"));
		
		 if (!empNo.equals("")) {
				
				cr = cr.add(Restrictions.eq("EmpNo", empNo));
			}
		 
		 if (!referralNo.equals("")) {
				
				cr = cr.add(Restrictions.eq("ReferralNo", referralNo));
			}
			
			if (impHospitalId != 0 ) {
				cr = cr.createAlias("ToHospital", "th");
				cr = cr.add(Restrictions.eq("th.Id", impHospitalId));
			}
			
			if (rankCategoryId != 0 ) {
				cr = cr.createAlias("Hin", "hin");
				cr = cr.createAlias("hin.Employee", "emp");
				cr = cr.createAlias("emp.RankCategory", "rc");
				cr = cr.add(Restrictions.eq("rc.Id", rankCategoryId));
			}
			
			if (divisionId != 0 ) {
				
				cr = cr.add(Restrictions.eq("Division.Id", divisionId));
			}
		
		List totalMatches = cr.list();
		cr = cr.setFirstResult(pagingSize * (pageNo - 1));
		cr = cr.setMaxResults(pagingSize);
		referralPatientHeaderList = cr.list();
		
	
		int totalRecords = totalMatches.size();
		totalMatches.clear();	
		/*map.put("OpdPatientDetailsEmpanelledList", OpdPatientDetailsEmpanelledList);*/
		map.put("referralPatientHeaderList", referralPatientHeaderList);
		System.out.println("referralPatientHeaderList"+referralPatientHeaderList.size());
		System.out.println("totalRecords"+totalRecords);
		
		map.put("totalRecords", totalRecords);
		
				
		return map;
	}
	
	@Override
	public Map<String, Object> getInvoiceWaitingListForHRDivision(Box box) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		Criteria cr = null;
		/*List<OpdPatientDetails> OpdPatientDetailsEmpanelledList = new ArrayList<OpdPatientDetails>();	*/
		List<ReferralPatientHeader> referralPatientHeaderList = new ArrayList<ReferralPatientHeader>();
		Session session = (Session) getSession();
		int pagingSize = 10;
		int pageNo = 1;	
		String empNo ="";
		int impHospitalId = 0;
        int rankCategoryId = 0;
		int hospitalId = box.getInt("hospitalId");
		String ServiceNo = box.getString("ServiceNo");
		int userId = 0;
		Users user = new Users();	
		if (box.get("userId") != null)
		{
			userId = Integer.parseInt(box.getString("userId"));	
		    user =  (Users)session.load(Users.class, userId);
		}
		System.out.println("user.getEmployee().getId()"+user.getEmployee().getId());
		if (box.getString("PN") != null)
			pageNo = Integer.parseInt(box.getString("PN"));	
		

		if (box.getString("empNo") != null)
			empNo = box.getString("empNo");
		if (box.get("impHospitalId") != null)
			impHospitalId = box.getInt("impHospitalId");
		if (box.get("rankCategoryId") != null)
			rankCategoryId = box.getInt("rankCategoryId");	
		
			
		
		cr = session.createCriteria(ReferralPatientHeader.class)
				.add(Restrictions.eq("ApprovalStatus", "WHD").ignoreCase())							
				.add(Restrictions.eq("FromHospital.Id", hospitalId))
				.add(Restrictions.eq("Division.Id", user.getEmployee().getDivision().getId()))
				.addOrder(Order.desc("LastChgDate"))
				.addOrder(Order.desc("LastChgTime"));
		
        if (!empNo.equals("")) {
			
			cr = cr.add(Restrictions.eq("EmpNo", empNo));
		}
		
		if (impHospitalId != 0 ) {
			cr = cr.createAlias("ToHospital", "th"); 
			cr = cr.add(Restrictions.eq("th.Id", impHospitalId));
		}
		
		if (rankCategoryId != 0 ) {
			cr = cr.createAlias("Hin", "hin");
			cr = cr.createAlias("hin.Employee", "emp");
			cr = cr.createAlias("emp.RankCategory", "rc");
			cr = cr.add(Restrictions.eq("rc.Id", rankCategoryId));
		}
		
		List totalMatches = cr.list();
		cr = cr.setFirstResult(pagingSize * (pageNo - 1));
		cr = cr.setMaxResults(pagingSize);
		referralPatientHeaderList = cr.list();
		
		System.out.println("totalMatches"+totalMatches.size());
		System.out.println("totalMatches"+referralPatientHeaderList.size());

		int totalRecords = totalMatches.size();
		totalMatches.clear();	
		/*map.put("OpdPatientDetailsEmpanelledList", OpdPatientDetailsEmpanelledList);*/
		map.put("referralPatientHeaderList", referralPatientHeaderList);	
		map.put("totalRecords", totalRecords);
		
				
		return map;
	}
	
	@Override
	public Map<String, Object> getInvoiceWaitingListForHRDivisionRejected(Box box) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		Criteria cr = null;
		/*List<OpdPatientDetails> OpdPatientDetailsEmpanelledList = new ArrayList<OpdPatientDetails>();	*/
		List<ReferralPatientHeader> referralPatientHeaderList = new ArrayList<ReferralPatientHeader>();
		Session session = (Session) getSession();
		int pagingSize = 10;
		int pageNo = 1;	
		String empNo ="";
		String noteSheetNo ="";
		int impHospitalId = 0;
        int rankCategoryId = 0;
		int hospitalId = box.getInt("hospitalId");
		String ServiceNo = box.getString("ServiceNo");
		int userId = 0;
		Users user = new Users();	
		if (box.get("userId") != null)
		{
			userId = Integer.parseInt(box.getString("userId"));	
		    user =  (Users)session.load(Users.class, userId);
		}
		System.out.println("user.getEmployee().getId()"+user.getEmployee().getId());
		if (box.getString("PN") != null)
			pageNo = Integer.parseInt(box.getString("PN"));	
		

		if (box.getString("empNo") != null)
			empNo = box.getString("empNo");
		if (box.getString("noteSheetNo") != null)
			noteSheetNo = box.getString("noteSheetNo");
		if (box.get("impHospitalId") != null)
			impHospitalId = box.getInt("impHospitalId");
		if (box.get("rankCategoryId") != null)
			rankCategoryId = box.getInt("rankCategoryId");	
		
			
		
		cr = session.createCriteria(ReferralPatientHeader.class)
				.add(Restrictions.eq("ApprovalStatus", "RFA").ignoreCase())							
				.add(Restrictions.eq("FromHospital.Id", hospitalId))
				.add(Restrictions.eq("Division.Id", user.getEmployee().getDivision().getId()));
				/*.addOrder(Order.desc("LastChgDate"))
				.addOrder(Order.desc("LastChgTime"));*/
		
        if (!empNo.equals("")) {
			
			cr = cr.add(Restrictions.eq("EmpNo", empNo));
		}
		
		if (impHospitalId != 0 ) {
			cr = cr.createAlias("ToHospital", "th"); 
			cr = cr.add(Restrictions.eq("th.Id", impHospitalId));
		}
		
		if (rankCategoryId != 0 ) {
			cr = cr.createAlias("Hin", "hin");
			cr = cr.createAlias("hin.Employee", "emp");
			cr = cr.createAlias("emp.RankCategory", "rc");
			cr = cr.add(Restrictions.eq("rc.Id", rankCategoryId));
		}
		
		 if (!noteSheetNo.equals("") && !noteSheetNo.equals("0")) {
				
				cr = cr.add(Restrictions.eq("NoteSheetNo", noteSheetNo));
			}
		
		List totalMatches = cr.list();
		cr = cr.setFirstResult(pagingSize * (pageNo - 1));
		cr = cr.setMaxResults(pagingSize);
		referralPatientHeaderList = cr.list();
		
		System.out.println("totalMatches"+totalMatches.size());
		System.out.println("totalMatches"+referralPatientHeaderList.size());

		int totalRecords = totalMatches.size();
		totalMatches.clear();	
		/*map.put("OpdPatientDetailsEmpanelledList", OpdPatientDetailsEmpanelledList);*/
		map.put("referralPatientHeaderList", referralPatientHeaderList);	
		map.put("totalRecords", totalRecords);
		
				
		return map;
	}
	
	@Override
	public Map<String, Object> getInvoiceWaitingListForFinanceDivision(Box box) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		Criteria cr = null;
		/*List<OpdPatientDetails> OpdPatientDetailsEmpanelledList = new ArrayList<OpdPatientDetails>();	*/
		List<ReferralPatientHeader> referralPatientHeaderList = new ArrayList<ReferralPatientHeader>();
		Session session = (Session) getSession();
		int pagingSize = 10;
		int pageNo = 1;	
		String empNo ="";
		int impHospitalId = 0;
        int rankCategoryId = 0;
		int hospitalId = box.getInt("hospitalId");
		String ServiceNo = box.getString("ServiceNo");
		int userId = 0;
		Users user = new Users();	
		if (box.get("userId") != null)
		{
			userId = Integer.parseInt(box.getString("userId"));	
		    user =  (Users)session.load(Users.class, userId);
		}
		if (box.getString("PN") != null)
			pageNo = Integer.parseInt(box.getString("PN"));	
		

		if (box.getString("empNo") != null)
			empNo = box.getString("empNo");
		if (box.get("impHospitalId") != null)
			impHospitalId = box.getInt("impHospitalId");
		if (box.get("rankCategoryId") != null)
			rankCategoryId = box.getInt("rankCategoryId");		
		
		
	
		
		
		
		cr = session.createCriteria(ReferralPatientHeader.class)
				.add(Restrictions.eq("ApprovalStatus", "WFA").ignoreCase())				
				.add(Restrictions.eq("FromHospital.Id", hospitalId))
				.add(Restrictions.eq("Division.Id", user.getEmployee().getDivision().getId()))
				.addOrder(Order.desc("LastChgDate"))
				.addOrder(Order.desc("LastChgTime"));
if (!empNo.equals("")) {
			
			cr = cr.add(Restrictions.eq("EmpNo", empNo));
		}
		
		if (impHospitalId != 0 ) {
			cr = cr.createAlias("ToHospital", "th");
			cr = cr.add(Restrictions.eq("th.Id", impHospitalId));
		}
		
		if (rankCategoryId != 0 ) {
			cr = cr.createAlias("Hin", "hin");
			cr = cr.createAlias("hin.Employee", "emp");
			cr = cr.createAlias("emp.RankCategory", "rc");
			cr = cr.add(Restrictions.eq("rc.Id", rankCategoryId));
		}
		
		
		List totalMatches = cr.list();
		cr = cr.setFirstResult(pagingSize * (pageNo - 1));
		cr = cr.setMaxResults(pagingSize);
		referralPatientHeaderList = cr.list();
		
		System.out.println("totalMatches"+totalMatches.size());
		System.out.println("totalMatches"+referralPatientHeaderList.size());

		int totalRecords = totalMatches.size();
		totalMatches.clear();	
		/*map.put("OpdPatientDetailsEmpanelledList", OpdPatientDetailsEmpanelledList);*/
		map.put("referralPatientHeaderList", referralPatientHeaderList);	
		map.put("totalRecords", totalRecords);
		
				
		return map;
	}
	
	@Override
	public Map<String, Object> getInvoiceWaitingListForGM(Box box) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		Criteria cr = null;
		/*List<OpdPatientDetails> OpdPatientDetailsEmpanelledList = new ArrayList<OpdPatientDetails>();	*/
		List<ReferralPatientHeader> referralPatientHeaderList = new ArrayList<ReferralPatientHeader>();
		
		
		Session session = (Session) getSession();
		int pagingSize = 10;
		int pageNo = 1;	
		String empNo ="";
		String noteSheetNo ="";
		int impHospitalId = 0;
        int rankCategoryId = 0;
		int hospitalId = box.getInt("hospitalId");
		String ServiceNo = box.getString("ServiceNo");
		String deducted = box.getString("deducted");
		
		
		int userId = 0;
		Users user = new Users();	
		if (box.get("userId") != null)
		{
			userId = Integer.parseInt(box.getString("userId"));	
		    user =  (Users)session.load(Users.class, userId);
		}
		
		if (box.getString("PN") != null)
			pageNo = Integer.parseInt(box.getString("PN"));	
		
		if (box.getString("noteSheetNo") != null)
			noteSheetNo = box.getString("noteSheetNo");
		
		if (box.getString("deducted") != null)
			deducted = box.getString("deducted");
		
		if (box.getString("empNo") != null)
			empNo = box.getString("empNo");
		if (box.get("impHospitalId") != null)
			impHospitalId = box.getInt("impHospitalId");
		if (box.get("rankCategoryId") != null)
			rankCategoryId = box.getInt("rankCategoryId");		
		
		
	
		System.out.println("user.getEmployee().getDivision().getId()"+user.getEmployee().getDivision().getId());
		cr = session.createCriteria(ReferralPatientHeader.class)
				.add(Restrictions.eq("ApprovalStatus", "WCB").ignoreCase())				
				.add(Restrictions.eq("FromHospital.Id", hospitalId))
				.add(Restrictions.eq("Division.Id", user.getEmployee().getDivision().getId()))
				.addOrder(Order.desc("LastChgDate"))
				.addOrder(Order.desc("LastChgTime"));
		
		if (!empNo.equals("")) {
			/*System.out.println("hi4");*/
			cr = cr.add(Restrictions.eq("EmpNo", empNo));
		}
		
        if (deducted.equals("n")) {
			/*System.out.println("hi");*/
			cr = cr.add(Restrictions.and(Restrictions.or(Restrictions.isNull("Deducted"), Restrictions.ne("Deducted", "y").ignoreCase()), Restrictions.gt("DeductionFromSalary", (new BigDecimal(0.0)))));
			
		}
		
		if (impHospitalId != 0 ) {
			/*System.out.println("hi1");*/
			cr = cr.createAlias("ToHospital", "th");
			cr = cr.add(Restrictions.eq("th.Id", impHospitalId));
		}
		
		if (rankCategoryId != 0 ) {
		/*	System.out.println("hi2");*/
			cr = cr.createAlias("Hin", "hin");
			cr = cr.createAlias("hin.Employee", "emp");
			cr = cr.createAlias("emp.RankCategory", "rc");
			cr = cr.add(Restrictions.eq("rc.Id", rankCategoryId));
		}
		 if (!noteSheetNo.equals("") && !noteSheetNo.equals("0")) {
			 System.out.println("hi3");
				cr = cr.add(Restrictions.eq("NoteSheetNo", noteSheetNo));
			}
			
		System.out.println("pagingSize="+pagingSize+"pageNo="+pageNo);
		List totalMatches = cr.list();
		/*cr = cr.setFirstResult(pagingSize * (pageNo - 1));
		cr = cr.setMaxResults(pagingSize);*/
		referralPatientHeaderList = cr.list(); 
		
		System.out.println("totalMatches"+totalMatches.size());
		System.out.println("totalMatches"+referralPatientHeaderList.size());

		int totalRecords = totalMatches.size();
		totalMatches.clear();	
		/*map.put("OpdPatientDetailsEmpanelledList", OpdPatientDetailsEmpanelledList);*/
		map.put("referralPatientHeaderList", referralPatientHeaderList);
		
		map.put("totalRecords", totalRecords);
		
				
		return map;
	}
	
	
	@Override
	public Map<String, Object> getInvoiceWaitingListForNoteSheet(Box box) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		Criteria cr = null;
		/*List<OpdPatientDetails> OpdPatientDetailsEmpanelledList = new ArrayList<OpdPatientDetails>();	*/
		List<ReferralPatientHeader> referralPatientHeaderList = new ArrayList<ReferralPatientHeader>();
		
		
		Session session = (Session) getSession();
		int pagingSize = 10;
		int pageNo = 1;	
		String empNo ="";
		int impHospitalId = 0;
        int rankCategoryId = 0;
		int hospitalId = box.getInt("hospitalId");
		String ServiceNo = box.getString("ServiceNo");
		
		int userId = 0;
		Users user = new Users();	
		if (box.get("userId") != null)
		{
			userId = Integer.parseInt(box.getString("userId"));	
		    user =  (Users)session.load(Users.class, userId);
		}
		
		if (box.getString("PN") != null)
			pageNo = Integer.parseInt(box.getString("PN"));	
	
		if (box.getString("empNo") != null)
			empNo = box.getString("empNo");
		if (box.get("impHospitalId") != null)
			impHospitalId = box.getInt("impHospitalId");
		if (box.get("rankCategoryId") != null)
			rankCategoryId = box.getInt("rankCategoryId");		
		
		
	
		
		cr = session.createCriteria(ReferralPatientHeader.class)
				.add(Restrictions.eq("ApprovalStatus", "WNS").ignoreCase())				
				.add(Restrictions.eq("FromHospital.Id", hospitalId))
				.add(Restrictions.eq("Division.Id", user.getEmployee().getDivision().getId()))
				.addOrder(Order.desc("LastChgDate"))
				.addOrder(Order.desc("LastChgTime"));
		
		if (!empNo.equals("")) {
			
			cr = cr.add(Restrictions.eq("EmpNo", empNo));
		}
		
		if (impHospitalId != 0 ) {
			cr = cr.createAlias("ToHospital", "th");
			cr = cr.add(Restrictions.eq("th.Id", impHospitalId));
		}
		
		if (rankCategoryId != 0 ) {
			cr = cr.createAlias("Hin", "hin");
			cr = cr.createAlias("hin.Employee", "emp");
			cr = cr.createAlias("emp.RankCategory", "rc");
			cr = cr.add(Restrictions.eq("rc.Id", rankCategoryId));
		}
			
		
		List totalMatches = cr.list();
		cr = cr.setFirstResult(0);
		cr = cr.setMaxResults(totalMatches.size());
		referralPatientHeaderList = cr.list();
		
		System.out.println("totalMatches"+totalMatches.size());
		System.out.println("totalMatches"+referralPatientHeaderList.size());

		int totalRecords = totalMatches.size();
		totalMatches.clear();	
		/*map.put("OpdPatientDetailsEmpanelledList", OpdPatientDetailsEmpanelledList);*/
		map.put("referralPatientHeaderList", referralPatientHeaderList);
		
		map.put("totalRecords", totalRecords);
		
				
		return map;
	}
	
	@Override
	public Map<String, Object> getInvoiceWaitingListForFA(Box box) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		Criteria cr = null;
		/*List<OpdPatientDetails> OpdPatientDetailsEmpanelledList = new ArrayList<OpdPatientDetails>();	*/
		List<ReferralPatientHeader> referralPatientHeaderList = new ArrayList<ReferralPatientHeader>();
		
		
		Session session = (Session) getSession();
		int pagingSize = 10;
		int pageNo = 1;	
		String empNo ="";
		String noteSheetNo ="";
		int impHospitalId = 0;
        int rankCategoryId = 0;
		int hospitalId = box.getInt("hospitalId");
		String ServiceNo = box.getString("ServiceNo");
		
		int userId = 0;
		Users user = new Users();	
		if (box.get("userId") != null)
		{
			userId = Integer.parseInt(box.getString("userId"));	
		    user =  (Users)session.load(Users.class, userId);
		}
		
		if (box.getString("PN") != null)
			pageNo = Integer.parseInt(box.getString("PN"));	
	
		if (box.getString("empNo") != null)
			empNo = box.getString("empNo");

		if (box.getString("noteSheetNo") != null)
			noteSheetNo = box.getString("noteSheetNo");
		if (box.get("impHospitalId") != null)
			impHospitalId = box.getInt("impHospitalId");
		if (box.get("rankCategoryId") != null)
			rankCategoryId = box.getInt("rankCategoryId");		
		
		
	
		
		cr = session.createCriteria(ReferralPatientHeader.class)
				.add(Restrictions.eq("ApprovalStatus", "WFA").ignoreCase())				
				.add(Restrictions.eq("FromHospital.Id", hospitalId))
				.add(Restrictions.eq("Division.Id", user.getEmployee().getDivision().getId()));
				/*.addOrder(Order.desc("LastChgDate"))
				.addOrder(Order.desc("LastChgTime"));*/
		
		if (!empNo.equals("")) {
			
			cr = cr.add(Restrictions.eq("EmpNo", empNo));
		}
		
		System.out.println("noteSheetNo"+noteSheetNo);
        if (!noteSheetNo.equals("") && !noteSheetNo.equals("0")) {
			
			cr = cr.add(Restrictions.eq("NoteSheetNo", noteSheetNo));
		}

		if (impHospitalId != 0 ) {
			cr = cr.createAlias("ToHospital", "th");
			cr = cr.add(Restrictions.eq("th.Id", impHospitalId));
		}
		
		if (rankCategoryId != 0 ) {
			cr = cr.createAlias("Hin", "hin");
			cr = cr.createAlias("hin.Employee", "emp");
			cr = cr.createAlias("emp.RankCategory", "rc");
			cr = cr.add(Restrictions.eq("rc.Id", rankCategoryId));
		}
			
		
		List totalMatches = cr.list();
		cr = cr.setFirstResult(pagingSize * (pageNo - 1));
		cr = cr.setMaxResults(pagingSize);
		referralPatientHeaderList = cr.list();
		
		System.out.println("totalMatches"+totalMatches.size());
		System.out.println("totalMatches"+referralPatientHeaderList.size());

		int totalRecords = totalMatches.size();
		totalMatches.clear();	
		/*map.put("OpdPatientDetailsEmpanelledList", OpdPatientDetailsEmpanelledList);*/
		map.put("referralPatientHeaderList", referralPatientHeaderList);
		
		map.put("totalRecords", totalRecords);
		
				
		return map;
	}

	@Override
	public Map<String, Object> getInvoiceWaitingListForPFD(Box box) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		Criteria cr = null;
		/*List<OpdPatientDetails> OpdPatientDetailsEmpanelledList = new ArrayList<OpdPatientDetails>();	*/
		List<ReferralPatientHeader> referralPatientHeaderList = new ArrayList<ReferralPatientHeader>();
		
		
		Session session = (Session) getSession();
		int pagingSize = 10;
		int pageNo = 1;	
		String empNo ="";
		String noteSheetNo ="";
		int impHospitalId = 0;
        int rankCategoryId = 0;
		int hospitalId = box.getInt("hospitalId");
		String ServiceNo = box.getString("ServiceNo");
		
		int userId = 0;
		Users user = new Users();	
		if (box.get("userId") != null)
		{
			userId = Integer.parseInt(box.getString("userId"));	
		    user =  (Users)session.load(Users.class, userId);
		}
		
		if (box.getString("PN") != null)
			pageNo = Integer.parseInt(box.getString("PN"));	
	
		if (box.getString("empNo") != null)
			empNo = box.getString("empNo");

		if (box.getString("noteSheetNo") != null)
			noteSheetNo = box.getString("noteSheetNo");
		if (box.get("impHospitalId") != null)
			impHospitalId = box.getInt("impHospitalId");
		if (box.get("rankCategoryId") != null)
			rankCategoryId = box.getInt("rankCategoryId");		
		
		
	
		
		cr = session.createCriteria(ReferralPatientHeader.class)
				.add(Restrictions.eq("ApprovalStatus", "PFD").ignoreCase())				
				.add(Restrictions.eq("FromHospital.Id", hospitalId))
				.add(Restrictions.eq("Division.Id", user.getEmployee().getDivision().getId()));
			/*	.addOrder(Order.desc("LastChgDate"))
				.addOrder(Order.desc("LastChgTime"));*/
		
		if (!empNo.equals("")) {
			
			cr = cr.add(Restrictions.eq("EmpNo", empNo));
		}
		
		
        if (!noteSheetNo.equals("") && !noteSheetNo.equals("0")) {
			
			cr = cr.add(Restrictions.eq("NoteSheetNo", noteSheetNo));
		}

		if (impHospitalId != 0 ) {
			cr = cr.createAlias("ToHospital", "th");
			cr = cr.add(Restrictions.eq("th.Id", impHospitalId));
		}
		
		if (rankCategoryId != 0 ) {
			cr = cr.createAlias("Hin", "hin");
			cr = cr.createAlias("hin.Employee", "emp");
			cr = cr.createAlias("emp.RankCategory", "rc");
			cr = cr.add(Restrictions.eq("rc.Id", rankCategoryId));
		}
			
		
		List totalMatches = cr.list();
		cr = cr.setFirstResult(pagingSize * (pageNo - 1));
		cr = cr.setMaxResults(pagingSize);
		referralPatientHeaderList = cr.list();
		
		System.out.println("totalMatches"+totalMatches.size());
		System.out.println("totalMatches"+referralPatientHeaderList.size());

		int totalRecords = totalMatches.size();
		totalMatches.clear();	
		/*map.put("OpdPatientDetailsEmpanelledList", OpdPatientDetailsEmpanelledList);*/
		map.put("referralPatientHeaderList", referralPatientHeaderList);
		
		map.put("totalRecords", totalRecords);
		
				
		return map;
	}

	
	@Override
	public Map<String, Object> getInvoiceWaitingFilterData(Box box) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		Criteria cr = null;
		
		
		List<MasRankCategory> rankCategoryList = new ArrayList<MasRankCategory>();
		List<MasImpanneledHospital> impHospitalList = new ArrayList<MasImpanneledHospital>();
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasDivision> divisionList = new ArrayList<MasDivision>();
		List<Object[]> noteSheetNoList = new ArrayList<Object[]>();
		int userId = 0;
		String departmentTypeCodeForOpd = "";
		departmentTypeCodeForOpd = HMSUtil.getProperties("adt.properties", "departmentTypeCodeForOpd");
		String empCategoryCodeForDoctor = "";
		empCategoryCodeForDoctor = HMSUtil.getProperties("adt.properties", "empCategoryCodeForDoctor");
		
		
		
		
		Session session = (Session) getSession();
		
		int hospitalId = box.getInt("hospitalId");
		
		Users user = new Users();	
		if (box.get("userId") != null && !box.getString("userId").equals("") && box.get("status") != null && !box.getString("status").equals(""))
		{
			userId = Integer.parseInt(box.getString("userId"));	
		    user =  (Users)session.load(Users.class, userId);
			  noteSheetNoList = session.createCriteria(ReferralPatientHeader.class)
						.add(Restrictions.eq("ApprovalStatus", box.getString("status")).ignoreCase())				
						.add(Restrictions.eq("FromHospital.Id", hospitalId))
						.add(Restrictions.isNotNull("NoteSheetNo"))
						.add(Restrictions.eq("Division.Id", user.getEmployee().getDivision().getId()))
						.setProjection(Projections.property("NoteSheetNo")) 
						.setProjection(Projections.groupProperty("NoteSheetNo")).list();
			  System.out.println("noteSheetNoList"+noteSheetNoList.size());
			  System.out.println("userId"+user.getEmployee().getDivision().getId());
			  System.out.println("hospitalId"+hospitalId);
		}
		
		rankCategoryList = session.createCriteria(MasRankCategory.class)
		.add(Restrictions.eq("Status", "y").ignoreCase())
		.addOrder(Order.asc("RankCategoryName")).list();
		
	
		
		doctorList = session.createCriteria(MasEmployee.class)
				.createAlias("EmpCategory", "cat")
				.add(Restrictions.eq("cat.EmpCategoryCode", empCategoryCodeForDoctor).ignoreCase())
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.addOrder(Order.asc("FirstName")).list();
		
		departmentList = session.createCriteria(MasDepartment.class)
				.createAlias("DepartmentType", "dt")
				.add(Restrictions.eq("dt.DepartmentTypeCode", departmentTypeCodeForOpd).ignoreCase())
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.addOrder(Order.asc("DepartmentName")).list();
		
		impHospitalList = session.createCriteria(MasImpanneledHospital.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.addOrder(Order.asc("ImpanneledHospitalName")).list();
		
		divisionList = session.createCriteria(MasDivision.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.addOrder(Order.asc("DivisionName")).list();
		
		
		map.put("rankCategoryList", rankCategoryList);
		map.put("noteSheetNoList", noteSheetNoList);
		map.put("divisionList", divisionList);
		map.put("impHospitalList", impHospitalList);
		map.put("doctorList", doctorList);
		map.put("departmentList", departmentList);
		
		return map;
	}
	
	
	@Override
	public Map<String, Object> getInvoiceWaitingFilterDataForReports(Box box) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		Criteria cr = null;
		
		
		List<MasRankCategory> rankCategoryList = new ArrayList<MasRankCategory>();
		List<MasImpanneledHospital> impHospitalList = new ArrayList<MasImpanneledHospital>();
		List<MasDivision> divisionList = new ArrayList<MasDivision>();
		List<Object[]> noteSheetNoList = new ArrayList<Object[]>();
		List<Object[]> dispatchLetterList = new ArrayList<Object[]>();
		int userId = 0;
		
		
		
		
		Session session = (Session) getSession();
		
		int hospitalId = box.getInt("hospitalId");
		
		Users user = new Users();	
		if (box.get("userId") != null && !box.getString("userId").equals("") && box.get("status") != null && !box.getString("status").equals(""))
		{
			userId = Integer.parseInt(box.getString("userId"));	
		    user =  (Users)session.load(Users.class, userId);
			  noteSheetNoList = session.createCriteria(ReferralPatientHeader.class)
						/*.add(Restrictions.eq("ApprovalStatus", box.getString("status")).ignoreCase())	*/			
						.add(Restrictions.eq("FromHospital.Id", hospitalId))
						.add(Restrictions.isNotNull("NoteSheetNo"))
						.add(Restrictions.eq("Division.Id", user.getEmployee().getDivision().getId()))
						.setProjection(Projections.property("NoteSheetNo")) 
						.setProjection(Projections.groupProperty("NoteSheetNo")).list();
			  
			  dispatchLetterList = session.createCriteria(ReferralPatientHeader.class)
						/*.add(Restrictions.eq("ApprovalStatus", box.getString("status")).ignoreCase())	*/			
						.add(Restrictions.eq("FromHospital.Id", hospitalId))
						.add(Restrictions.isNotNull("DispatchNumber"))
						.add(Restrictions.eq("Division.Id", user.getEmployee().getDivision().getId()))
						.setProjection(Projections.property("DispatchNumber")) 
						.setProjection(Projections.groupProperty("DispatchNumber")).list();
			 
		}
		
		rankCategoryList = session.createCriteria(MasRankCategory.class)
		.add(Restrictions.eq("Status", "y").ignoreCase())
		.addOrder(Order.asc("RankCategoryName")).list();
		
	
		
		impHospitalList = session.createCriteria(MasImpanneledHospital.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.addOrder(Order.asc("ImpanneledHospitalName")).list();
		
		divisionList = session.createCriteria(MasDivision.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.addOrder(Order.asc("DivisionName")).list();
		
		
		map.put("rankCategoryList", rankCategoryList);
		map.put("noteSheetNoList", noteSheetNoList);
		map.put("dispatchLetterList", dispatchLetterList);
		map.put("divisionList", divisionList);
		map.put("impHospitalList", impHospitalList);
		
		
		return map;
	}
	
	
	@Override
	public Map<String, Object> accountedAndUnaccountedBills(Box box, HttpServletResponse response) {
		
		Map<String, Object> map = new HashMap<String, Object>();

		int userId = 0;
		
		Session session = (Session) getSession();
		
		int hospitalId = box.getInt("hospitalId");
		int divisionId = box.getInt("divisionId");
		
		try{
		
		 //code starts for generating excel
		List<Object[]> referralPatientBillingList = new ArrayList<Object[]>();	
		Object[] header = {"S.No.", "EMP NO", "PATIENT NAME", "RELATIONSHIP", "DIVISION", "TREATMENT TYPE", "DISPATCH NO", "NOTE SHEET NO", "COVER NOTE NO", "REFERRAL No", "BILL NO", "BILL DATE", "CHEQUE NO", "CHEQUE DATE",  "APPROVED BILL AMT", "EMPANELLED  HOSPITAL","STATUS"};
		
		referralPatientBillingList.add(header);
		
		List<List<Object[]>> sheetList = new ArrayList<List<Object[]>>();					
				
	
		int headerId = box.getInt("headerId");		
		
		Criteria cr = session.createCriteria(ReferralPatientBilling.class)
				.createAlias("ReferralDetails", "dt")
				.createAlias("dt.ReferralPatientHeader", "h")						
				.createAlias("h.Hin", "p")
				.createAlias("p.Employee", "e")
				.createAlias("e.Division", "d")
				.createAlias("p.Relation", "r")	
				.createAlias("h.OpdPatientDetails", "opd")
				.createAlias("opd.Visit", "v")
				.createAlias("v.Department", "de")
				.createAlias("h.ToHospital", "toH")
				.createAlias("v.Doctor", "doc")						
				.setProjection(Projections.projectionList()
				.add(Projections.property("Id"))
				.add(Projections.property("p.ServiceNo"))
                .add(Projections.property("p.PFirstName"))
                .add(Projections.property("r.RelationName"))
                /*.add(Projections.property("p.PFirstName"))*/
                /*.add(Projections.property("de.DepartmentName"))*/
               /* .add(Projections.property("toH.ImpanneledHospitalName"))	
                .add(Projections.property("dt.ReferralExtensionDate"))*/
                 .add(Projections.property("d.DivisionName"))  
                .add(Projections.property("dt.TreatmentType"))                 
               /* .add(Projections.property("doc.FirstName"))*/
                .add(Projections.property("h.DispatchNumber"))
                .add(Projections.property("h.NoteSheetNo"))
                 .add(Projections.property("h.CovernoteNumber"))
                .add(Projections.property("dt.ReferralNo"))		                
               
                .add(Projections.property("BillNo"))
                .add(Projections.property("BillDate"))
                .add(Projections.property("CheckNo"))
                .add(Projections.property("CheckDate"))
                .add(Projections.property("AdminBillAmt"))
                .add(Projections.property("toH.ImpanneledHospitalName"))
                .add(Projections.property("h.ApprovalStatus")));
                /*.add(Projections.property("TaxAmount"))
                .add(Projections.property("NetAmount"))
                .add(Projections.property("CheckNo"))
                .add(Projections.property("CheckDate")))                
                .add(Projections.property("BillNo"))
                .add(Projections.property("BillDate"))
                .add(Projections.property("dt.ReferralNo"))
                .add(Projections.property("dt.ReferralExtensionDate"))
                .add(Projections.property("AdminBillAmt"))
                .add(Projections.property("TaxAmount"))		               
                .add(Projections.property("CheckAmount"))
                .add(Projections.property("p.ServiceNo"))*/	                
               
             
					
					if (box.getString("paymentStatus").equalsIgnoreCase("C")) {						
						cr = cr.add(Restrictions.eq("h.ApprovalStatus", "C").ignoreCase());
					}
					else
					{
						cr = cr.add(Restrictions.ne("h.ApprovalStatus", "C").ignoreCase());
					}
                
					if (divisionId != 0 ) {						
						cr = cr.add(Restrictions.eq("d.Id", divisionId));
					}
                
				
				referralPatientBillingList.addAll(cr.list());
			            sheetList.add(referralPatientBillingList);
			         
			           
			            for(int i=1; i<referralPatientBillingList.size(); i++)
			            {
			            	
			            	referralPatientBillingList.get(i)[0]=i;
			            	if(referralPatientBillingList.get(i)[11]!=null && !referralPatientBillingList.get(i)[11].toString().trim().equals(""))
			            	{
			            		referralPatientBillingList.get(i)[11]=HMSUtil.convertDateToStringFormat((Date)referralPatientBillingList.get(i)[11], "dd-MM-YYYY");
			            	}
			            	
			            	if(referralPatientBillingList.get(i)[13]!=null && !referralPatientBillingList.get(i)[13].toString().trim().equals(""))
			            	{
			            		referralPatientBillingList.get(i)[13]=HMSUtil.convertDateToStringFormat((Date)referralPatientBillingList.get(i)[13], "dd-MM-YYYY");
			            	}
			            	
			            	if(referralPatientBillingList.get(i)[5].equals("2"))
			            	{
			            		referralPatientBillingList.get(i)[5]="Admission";
			            	}
			            	else
			            	{
			            		referralPatientBillingList.get(i)[5]="OPD";
			            	}
			            	
			            		            	
			            	if(referralPatientBillingList.get(i)[16]!=null)
							{
								if(referralPatientBillingList.get(i)[16].toString().equalsIgnoreCase("WA"))
								{
									referralPatientBillingList.get(i)[16]="Waiting For Medical Approval";
								}	
								else if(referralPatientBillingList.get(i)[16].toString().equalsIgnoreCase("PFD"))
								{
									referralPatientBillingList.get(i)[16]="Pending for Dispatch To Payable";
								}	
								else if(referralPatientBillingList.get(i)[16].toString().equalsIgnoreCase("WCB"))
								{
									referralPatientBillingList.get(i)[16]="Waiting For Consolidation of Bills";
								}	
								else if(referralPatientBillingList.get(i)[16].toString().equalsIgnoreCase("WNS"))
								{
									referralPatientBillingList.get(i)[16]="Waiting For NoteSheet Generation";
								}					
								else if(referralPatientBillingList.get(i)[16].toString().equalsIgnoreCase("WHD"))
								{
									referralPatientBillingList.get(i)[16]="Waiting For HR Division Approval";
								}	
								else if(referralPatientBillingList.get(i)[16].toString().equalsIgnoreCase("WFA"))
								{
									referralPatientBillingList.get(i)[16]="Waiting For Finance Audit Approval";
								}	
								else if(referralPatientBillingList.get(i)[16].toString().equalsIgnoreCase("FA"))
								{
									referralPatientBillingList.get(i)[16]="Approved By Finance Audit";
								}
								else if(referralPatientBillingList.get(i)[16].toString().equalsIgnoreCase("DLG"))
								{
									referralPatientBillingList.get(i)[16]="Divisional Approval Letter Generated";
								}
								else if(referralPatientBillingList.get(i)[16].toString().equalsIgnoreCase("RHD"))
								{
									referralPatientBillingList.get(i)[16]="Rejected By HR Division";
								}
								else if(referralPatientBillingList.get(i)[16].toString().equalsIgnoreCase("RFA"))
								{
									referralPatientBillingList.get(i)[16]="Rejected By Finance Audit";
								}
								else if(referralPatientBillingList.get(i)[16].toString().equalsIgnoreCase("CBG"))
								{
									referralPatientBillingList.get(i)[16]="Waiting For Document Upload";
								}
								else if(referralPatientBillingList.get(i)[16].toString().equalsIgnoreCase("C"))
								{
									referralPatientBillingList.get(i)[16]="Complete";
								}
								
								else
								{
									referralPatientBillingList.get(i)[16]="";
								}
							}
							else
							{
								referralPatientBillingList.get(i)[16]="";
							}
			            	
			            	
			            }
        
		
		       	System.out.println("referralPatientBillingList"+referralPatientBillingList.size());
		        map.put("fileName", "Referral Bills");
		        List<String> sheetNames = new ArrayList<String>();
		        sheetNames.add("Referral Bills");
			HMSUtil.excelWriter(sheetList, map, response, sheetNames);						
		//code ends for generating excel
			
		} catch (Exception e) {
			e.printStackTrace();
		
			
		}     
		finally
		{
			session.close();
			
		}
		
		return map;
	}
	
	
	@Override
	public Map<String, Object> getInvoiceWaitingFilterDataPFD(Box box) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		Criteria cr = null;
		
		
		List<MasRankCategory> rankCategoryList = new ArrayList<MasRankCategory>();
		List<MasImpanneledHospital> impHospitalList = new ArrayList<MasImpanneledHospital>();
		List<MasDivision> divisionList = new ArrayList<MasDivision>();
		List<Object[]> noteSheetNoList = new ArrayList<Object[]>();
		int userId = 0;
		
		
		
		
		Session session = (Session) getSession();
		
		int hospitalId = box.getInt("hospitalId");
		
		Users user = new Users();	
		if (box.get("userId") != null && !box.getString("userId").equals(""))
		{
			userId = Integer.parseInt(box.getString("userId"));	
		    user =  (Users)session.load(Users.class, userId);
			  noteSheetNoList = session.createCriteria(ReferralPatientHeader.class)
						.add(Restrictions.eq("ApprovalStatus", "PFD").ignoreCase())				
						.add(Restrictions.eq("FromHospital.Id", hospitalId))
						.add(Restrictions.isNotNull("NoteSheetNo"))
						.add(Restrictions.eq("Division.Id", user.getEmployee().getDivision().getId()))
						.setProjection(Projections.property("NoteSheetNo")) 
						.setProjection(Projections.groupProperty("NoteSheetNo")).list();
			  System.out.println("noteSheetNoList"+noteSheetNoList.size());
			  System.out.println("userId"+user.getEmployee().getDivision().getId());
			  System.out.println("hospitalId"+hospitalId);
		}
		
		rankCategoryList = session.createCriteria(MasRankCategory.class)
		.add(Restrictions.eq("Status", "y").ignoreCase())
		.addOrder(Order.asc("RankCategoryName")).list();
		
	
		
		impHospitalList = session.createCriteria(MasImpanneledHospital.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.addOrder(Order.asc("ImpanneledHospitalName")).list();
		
		divisionList = session.createCriteria(MasDivision.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.addOrder(Order.asc("DivisionName")).list();
		
		
		map.put("rankCategoryList", rankCategoryList);
		map.put("noteSheetNoList", noteSheetNoList);
		map.put("divisionList", divisionList);
		map.put("impHospitalList", impHospitalList);
		
		
		return map;
	}
	
	
	@Override
	public Map<String, Object> getInvoiceWaitingListForAll(Box box) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		Criteria cr = null;
		/*List<OpdPatientDetails> OpdPatientDetailsEmpanelledList = new ArrayList<OpdPatientDetails>();	*/
		List<ReferralPatientHeader> referralPatientHeaderList = new ArrayList<ReferralPatientHeader>();
		Session session = (Session) getSession();
		int pagingSize = 10;
		int pageNo = 1;	
		int hospitalId = box.getInt("hospitalId");
		String ServiceNo = box.getString("ServiceNo");
		String empNo ="";
		String paymentStatus ="";
		String deductionFS ="";
		int impHospitalId = 0;
        int rankCategoryId = 0;
        int divisionId = 0;
		if (box.getString("empNo") != null)
			empNo = box.getString("empNo");
		if (box.getString("paymentStatus") != null)
			paymentStatus = box.getString("paymentStatus");
		if (box.getString("deductionFS") != null)
			deductionFS = box.getString("deductionFS");
		if (box.get("impHospitalId") != null)
			impHospitalId = box.getInt("impHospitalId");
		if (box.get("rankCategoryId") != null)
			rankCategoryId = box.getInt("rankCategoryId");
		if (box.get("divisionId") != null)
			divisionId = box.getInt("divisionId");	
		
		if (box.getString("PN") != null)
			pageNo = Integer.parseInt(box.getString("PN"));	
		
		/*cr = session.createCriteria(OpdPatientDetails.class)
				.add(Restrictions.eq("EmpanelStatus", "TC").ignoreCase())
				.add(Restrictions.eq("ReferredType", "Empanel"))
				.add(Restrictions.eq("Hospital.Id", hospitalId));
		
		
		List totalMatches = cr.list();
		cr = cr.setFirstResult(pagingSize * (pageNo - 1));
		cr = cr.setMaxResults(pagingSize);
		OpdPatientDetailsEmpanelledList = cr.list();*/
	
		
		cr = session.createCriteria(ReferralPatientHeader.class)							
				.add(Restrictions.eq("FromHospital.Id", hospitalId))
				.add(Restrictions.ne("ApprovalStatus", "WA"))
				.addOrder(Order.desc("LastChgDate"))
				.addOrder(Order.desc("LastChgTime"));
		
		 if (!empNo.equals("")) {
				
				cr = cr.add(Restrictions.eq("EmpNo", empNo));
			}
		 if (paymentStatus.equals("C")) {
				
				cr = cr.add(Restrictions.eq("ApprovalStatus", "C").ignoreCase());
			}
		 else  if (paymentStatus.equals("P")) {
				
				cr = cr.add(Restrictions.ne("ApprovalStatus", "C").ignoreCase());
			}
			
			if (impHospitalId != 0 ) {
				cr = cr.createAlias("ToHospital", "th");
				cr = cr.add(Restrictions.eq("th.Id", impHospitalId));
			}
			
			if (rankCategoryId != 0 ) {
				cr = cr.createAlias("Hin", "hin");
				cr = cr.createAlias("hin.Employee", "emp");
				cr = cr.createAlias("emp.RankCategory", "rc");
				cr = cr.add(Restrictions.eq("rc.Id", rankCategoryId));
			}
			
			if (divisionId != 0 ) {
				
				cr = cr.add(Restrictions.eq("Division.Id", divisionId));
			}
			
			 if (deductionFS.equals("p")) {
					
				 cr = cr.add(Restrictions.and(Restrictions.gt("DeductionFromSalary", (new BigDecimal(0.0))), Restrictions.isNotNull("DeductionFromSalary")));
				}
			 else if (deductionFS.equals("n")) {
					
					cr = cr.add(Restrictions.or(Restrictions.eq("DeductionFromSalary", (new BigDecimal(0.0))), Restrictions.isNull("DeductionFromSalary")));
				}
			 
		
		List totalMatches = cr.list();
		cr = cr.setFirstResult(pagingSize * (pageNo - 1));
		cr = cr.setMaxResults(pagingSize);
		referralPatientHeaderList = cr.list();
		
		System.out.println("totalMatches"+totalMatches.size());
		System.out.println("totalMatches"+referralPatientHeaderList.size());

		int totalRecords = totalMatches.size();
		totalMatches.clear();	
		/*map.put("OpdPatientDetailsEmpanelledList", OpdPatientDetailsEmpanelledList);*/
		map.put("referralPatientHeaderList", referralPatientHeaderList);	
		map.put("totalRecords", totalRecords);
		
				
		return map;
	}
	
	@Override
	public Map<String, Object> getReferralDashboardData(Box box) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		Criteria cr = null;
	
		List<MasDivision> divisionList = new ArrayList<MasDivision>();
		List<Object[]> accountedReferral = new ArrayList<Object[]>();
		List<Object[]> unAccountedReferral = new ArrayList<Object[]>();	
		List<Object[]> accountedBills = new ArrayList<Object[]>();
		List<Object[]> unAccountedBills = new ArrayList<Object[]>();
		List<Object[]> dashboardData = new ArrayList<Object[]>();
		
		Session session = (Session) getSession();
		int pagingSize = 10;
		int pageNo = 1;	
		int hospitalId = box.getInt("hospitalId");
		
		String paymentStatus ="";
		
        int divisionId = 0;
	
		if (box.get("divisionId") != null)
			divisionId = box.getInt("divisionId");	
		
		if (box.getString("PN") != null)
			pageNo = Integer.parseInt(box.getString("PN"));	
		
		cr = session.createCriteria(MasDivision.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.addOrder(Order.asc("DivisionName"));
		divisionList = cr.list();	
		
		accountedReferral = session.createCriteria(ReferralPatientHeader.class, "h")	
				/*.createAlias("ReferralPatientHeader", "h")*/
				.createAlias("h.Hin", "p")
				.createAlias("p.Employee", "e")
				.createAlias("p.Relation", "r")	
				.createAlias("h.OpdPatientDetails", "opd")
				.createAlias("opd.Visit", "v")
				.createAlias("v.Department", "de")
				.createAlias("h.ToHospital", "toH")
				.createAlias("v.Doctor", "doc")			          
				.createAlias("e.Division", "d")
				.setProjection(Projections.projectionList()
                .add(Projections.property("d.Id"))
                .add(Projections.count("ReferralNo"))
                .add(Projections.groupProperty("d.Id")))					
				.add(Restrictions.in("h.Division", divisionList))	
				.add(Restrictions.eq("h.ApprovalStatus", "C").ignoreCase()).list(); 
		
		accountedBills = session.createCriteria(ReferralPatientBilling.class)	
				.createAlias("ReferralDetails", "dt")
				.createAlias("dt.ReferralPatientHeader", "h")
				.createAlias("h.Hin", "p")
		.createAlias("p.Employee", "e")
		.createAlias("p.Relation", "r")	
		.createAlias("h.OpdPatientDetails", "opd")
		.createAlias("opd.Visit", "v")
		.createAlias("v.Department", "de")
		.createAlias("h.ToHospital", "toH")
		.createAlias("v.Doctor", "doc")	
				.createAlias("e.Division", "d")
				.setProjection(Projections.projectionList()
                .add(Projections.property("d.Id"))
                .add(Projections.sum("AdminBillAmt"))
                .add(Projections.groupProperty("d.Id")))						
				.add(Restrictions.in("h.Division", divisionList))	
				.add(Restrictions.eq("h.ApprovalStatus", "C").ignoreCase()).list(); 
		
		/*Object[] status ={"C"};*/
		unAccountedReferral = session.createCriteria(ReferralPatientHeader.class, "h")		
				/*.createAlias("ReferralPatientHeader", "h")*/
				.createAlias("h.Hin", "p")
				.createAlias("p.Employee", "e")
				.createAlias("p.Relation", "r")	
				.createAlias("h.OpdPatientDetails", "opd")
				.createAlias("opd.Visit", "v")
				.createAlias("v.Department", "de")
				.createAlias("h.ToHospital", "toH")
				.createAlias("v.Doctor", "doc")	
				.createAlias("e.Division", "d")
				.setProjection(Projections.projectionList()
                .add(Projections.property("d.Id"))
                .add(Projections.count("ReferralNo"))
                .add(Projections.groupProperty("d.Id")))					
				.add(Restrictions.in("h.Division", divisionList))	
				.add(Restrictions.and(Restrictions.ne("h.ApprovalStatus", "WA").ignoreCase(), Restrictions.ne("h.ApprovalStatus", "C").ignoreCase())).list();
		
		
		
		
		unAccountedBills = session.createCriteria(ReferralPatientBilling.class)	
				.createAlias("ReferralDetails", "dt")
				.createAlias("dt.ReferralPatientHeader", "h")
				.createAlias("h.Hin", "p")
		.createAlias("p.Employee", "e")
		.createAlias("p.Relation", "r")	
		.createAlias("h.OpdPatientDetails", "opd")
		.createAlias("opd.Visit", "v")
		.createAlias("v.Department", "de")
		.createAlias("h.ToHospital", "toH")
		.createAlias("v.Doctor", "doc")	
				.createAlias("e.Division", "d")
				.setProjection(Projections.projectionList()
                .add(Projections.property("d.Id"))
                .add(Projections.sum("AdminBillAmt"))
                .add(Projections.groupProperty("d.Id")))		
				.add(Restrictions.in("h.Division", divisionList))	
				.add(Restrictions.and(Restrictions.ne("h.ApprovalStatus", "WA").ignoreCase(), Restrictions.ne("h.ApprovalStatus", "C").ignoreCase())).list(); 
		
		for(int i=0; i<divisionList.size(); i++)
		{
			Object[] dashboardRow = new Object[6];
			dashboardRow[0] = divisionList.get(i).getId();
			dashboardRow[1] = divisionList.get(i).getDivisionName();
			dashboardRow[2] = 0;
			dashboardRow[3] = 0;
			dashboardRow[4] = 0;
			dashboardRow[5] = 0;
			for(int j=0; j<accountedReferral.size(); j++)
			{
				
				
				if(divisionList.get(i).getId().intValue() == Integer.parseInt(accountedReferral.get(j)[0].toString()))
				{
					
					dashboardRow[2] = accountedReferral.get(j)[1];	
									
				}
				
			}
			
			for(int j=0; j<accountedBills.size(); j++)
			{
				
				
				if(divisionList.get(i).getId().intValue() == Integer.parseInt(accountedBills.get(j)[0].toString()))
				{					
					dashboardRow[3] = accountedBills.get(j)[1];	
													
				}
				
			}
			
			for(int j=0; j<unAccountedReferral.size(); j++)
			{
				
				
				if(divisionList.get(i).getId().intValue() == Integer.parseInt(unAccountedReferral.get(j)[0].toString()))
				{
					
					dashboardRow[4] = unAccountedReferral.get(j)[1];	
									
				}
				
			}
			
			for(int j=0; j<unAccountedBills.size(); j++)
			{
				
				
				if(divisionList.get(i).getId().intValue() == Integer.parseInt(unAccountedBills.get(j)[0].toString()))
				{					
					dashboardRow[5] = unAccountedBills.get(j)[1];	
													
				}
				
			}
			
			dashboardData.add(dashboardRow);	
						
		}
		
	
		
		/*	if (divisionId != 0 ) {
				
				cr = cr.add(Restrictions.eq("Division.Id", divisionId));
			}
			*/
			
		
		List totalMatches = cr.list();
		cr = cr.setFirstResult(pagingSize * (pageNo - 1));
		cr = cr.setMaxResults(pagingSize);
		
		
		System.out.println("totalMatches"+totalMatches.size());
		System.out.println("totalMatches"+dashboardData.size());

		int totalRecords = totalMatches.size();
		totalMatches.clear();	
		/*map.put("OpdPatientDetailsEmpanelledList", OpdPatientDetailsEmpanelledList);*/
		map.put("dashboardData", dashboardData);	
		map.put("totalRecords", totalRecords);
		
				
		return map;
	}
	
	@Override
	public Map<String, Object> getWaitingListForReferralExtension(Box box) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		Criteria cr = null;
		/*List<OpdPatientDetails> OpdPatientDetailsEmpanelledList = new ArrayList<OpdPatientDetails>();	*/
		List<ReferralPatientHeader> referralPatientHeaderList = new ArrayList<ReferralPatientHeader>();
		Session session = (Session) getSession();
		int pagingSize = 10;
		int pageNo = 1;	
		int hospitalId = box.getInt("hospitalId");
		int userId = box.getInt("userId");
		String ServiceNo = box.getString("ServiceNo");
		
		String empNo ="";
		String referralNo ="";
		int impHospitalId = 0;
        int rankCategoryId = 0;
        int divisionId = 0;
		if (box.getString("empNo") != null)
			empNo = box.getString("empNo");
		/*if (box.getString("referralNo") != null)
			referralNo = box.getString("referralNo");*/
		if (box.get("impHospitalId") != null)
			impHospitalId = box.getInt("impHospitalId");
		/*if (box.get("rankCategoryId") != null)
			rankCategoryId = box.getInt("rankCategoryId");*/
	/*	if (box.get("divisionId") != null)
			divisionId = box.getInt("divisionId");	*/
		
		
	     
		if (box.getString("PN") != null)
			pageNo = Integer.parseInt(box.getString("PN"));	
		
		/*cr = session.createCriteria(OpdPatientDetails.class)
				.add(Restrictions.eq("EmpanelStatus", "TC").ignoreCase())
				.add(Restrictions.eq("ReferredType", "Empanel"))
				.add(Restrictions.eq("Hospital.Id", hospitalId));
		
		
		List totalMatches = cr.list();
		cr = cr.setFirstResult(pagingSize * (pageNo - 1));
		cr = cr.setMaxResults(pagingSize);
		OpdPatientDetailsEmpanelledList = cr.list();*/
	
		Users user = (Users)session.get(Users.class, userId);
		
		cr = session.createCriteria(ReferralPatientHeader.class)							
				.add(Restrictions.eq("ExtensionStatus", "WDA").ignoreCase())
				.add(Restrictions.eq("ApprovalStatus", "WA").ignoreCase())
				.add(Restrictions.eq("FromHospital.Id", hospitalId))
				.add(Restrictions.eq("Doctor.Id", user.getEmployee().getId()))
				.addOrder(Order.asc("Id"));
		
		
		
		 if (!empNo.equals("")) {
				
				cr = cr.add(Restrictions.eq("EmpNo", empNo));
			}
		 
	/*	 if (!referralNo.equals("")) {
				
				cr = cr.add(Restrictions.eq("ReferralNo", referralNo));
			}*/
			
		/*	if (impHospitalId != 0 ) {
				cr = cr.createAlias("ToHospital", "th");
				cr = cr.add(Restrictions.eq("th.Id", impHospitalId));
			}*/
			
					
		/*	if (divisionId != 0 ) {
				
				cr = cr.add(Restrictions.eq("Division.Id", divisionId));
			}*/
		
		
		List totalMatches = cr.list();
		cr = cr.setFirstResult(pagingSize * (pageNo - 1));
		cr = cr.setMaxResults(pagingSize);
		referralPatientHeaderList = cr.list();
		
		System.out.println("totalMatches"+totalMatches.size());
		System.out.println("totalMatches"+referralPatientHeaderList.size());

		int totalRecords = totalMatches.size();
		totalMatches.clear();	
		/*map.put("OpdPatientDetailsEmpanelledList", OpdPatientDetailsEmpanelledList);*/
		map.put("referralPatientHeaderList", referralPatientHeaderList);	
		map.put("totalRecords", totalRecords);
		
				
		return map;
	}
	
	
	@Override
	public Map<String, Object> getExcelWaitingList(Box box) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		Criteria cr = null;
		List<ReferralPatientHeader> referralPatientHeaderList = new ArrayList<ReferralPatientHeader>();	
		Session session = (Session) getSession();
		int pagingSize = 10;
		int pageNo = 1;	
		int hospitalId = box.getInt("hospitalId");
		String ServiceNo = box.getString("ServiceNo");
		if (box.getString("PN") != null)
			pageNo = Integer.parseInt(box.getString("PN"));	
		
		cr = session.createCriteria(ReferralPatientHeader.class)
				.add(Restrictions.eq("ExcelStatus", "WEG").ignoreCase())				
				.add(Restrictions.eq("FromHospital.Id", hospitalId));
		
		
		List totalMatches = cr.list();
		cr = cr.setFirstResult(pagingSize * (pageNo - 1));
		cr = cr.setMaxResults(pagingSize);
		referralPatientHeaderList = cr.list();
		System.out.println("totalMatches"+totalMatches.size());
		System.out.println("totalMatches"+referralPatientHeaderList.size());

		int totalRecords = totalMatches.size();
		totalMatches.clear();	
		map.put("referralPatientHeaderList", referralPatientHeaderList);		
		map.put("totalRecords", totalRecords);
		
				
		return map;
	}
	
	@Override
	public Map<String, Object> generateReferralLetterPage(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<DischargeIcdCode> diagnosisList = new ArrayList<DischargeIcdCode>();
		List<MasWardImpanneledHospital> imWardList = new ArrayList<MasWardImpanneledHospital>();
		int hinId = 0;
		OpdPatientDetails opdPatientDetails = new OpdPatientDetails();	
		try{
			opdPatientDetails =  (OpdPatientDetails)session.load(OpdPatientDetails.class , box.getInt("opdId"));
			if(opdPatientDetails.getVisit()!=null)
			{
				hinId = opdPatientDetails.getVisit().getHin().getId();
			}
			else
			{
				opdPatientDetails.getInpatient().getHin().getId();
			}
			
			
			diagnosisList = session.createCriteria(DischargeIcdCode.class).createAlias("OpdPatientDetails", "opd").add(Restrictions.eq("opd.id", box.getInt("opdId"))).addOrder(Order.desc("Id")).list();	
			imWardList = session.createCriteria(MasWardImpanneledHospital.class)
					     .add(Restrictions.eq("ImpanneledHospital.Id", opdPatientDetails.getImpanneledHospital().getId())).list();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		map.put("diagnosisList", diagnosisList);
		map.put("imWardList", imWardList);	
		map.put("opdPatientDetails", opdPatientDetails);
		return map;
	}
	
	@Override
	public Map<String, Object> generateExtensionLetterPage(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<DischargeIcdCode> diagnosisList = new ArrayList<DischargeIcdCode>();
		int hinId = 0;
		OpdPatientDetails opdPatientDetails = new OpdPatientDetails();	
		List<MasWardImpanneledHospital> imWardList = new ArrayList<MasWardImpanneledHospital>();
 		List<ReferralPatientDetails> referralPatientDetailsList = new ArrayList<ReferralPatientDetails>();
		try{
			opdPatientDetails =  (OpdPatientDetails)session.load(OpdPatientDetails.class , box.getInt("opdId"));
			if(opdPatientDetails.getVisit()!=null)
			{
				hinId = opdPatientDetails.getVisit().getHin().getId();
			}
			else
			{
				opdPatientDetails.getInpatient().getHin().getId();
			}
			
			
			diagnosisList = session.createCriteria(DischargeIcdCode.class).createAlias("OpdPatientDetails", "opd").add(Restrictions.eq("opd.id", box.getInt("opdId"))).addOrder(Order.desc("Id")).list();
			referralPatientDetailsList = session.createCriteria(ReferralPatientDetails.class)
					.createAlias("ReferralPatientHeader", "h")
					.createAlias("h.OpdPatientDetails", "opd")
					.add(Restrictions.eq("opd.id", box.getInt("opdId")))
					.addOrder(Order.asc("Id")).list();
			imWardList = session.createCriteria(MasWardImpanneledHospital.class)
				     .add(Restrictions.eq("ImpanneledHospital.Id", opdPatientDetails.getImpanneledHospital().getId())).list();
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		map.put("diagnosisList", diagnosisList);	
		map.put("imWardList", imWardList);
		map.put("opdPatientDetails", opdPatientDetails);
		map.put("referralPatientDetailsList", referralPatientDetailsList);
		return map;
	}
	
	@Override
	public Map<String, Object> generateInvoicePage(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<DischargeIcdCode> diagnosisList = new ArrayList<DischargeIcdCode>();
		List<ReferralPatientDetails> referralPatientDetailsList = new ArrayList<ReferralPatientDetails>();
		List<ReferralPatientBilling> referralPatientBillingList = new ArrayList<ReferralPatientBilling>();
		List<ReferralClarrificationHeader> referralClarrificationHeaderList = new ArrayList<ReferralClarrificationHeader>();
		List<MasImpanneledHospital> impanelHospitalList = new ArrayList<MasImpanneledHospital>();
		List<MasWardImpanneledHospital> imWardList = new ArrayList<MasWardImpanneledHospital>();
		String departmentTypeCodeForOpd="";
		List<MasDepartment> departmentList = null;
		/*int hinId = 0;*/
		OpdPatientDetails opdPatientDetails = new OpdPatientDetails();	
		try{
			departmentTypeCodeForOpd = HMSUtil.getProperties("adt.properties", "departmentTypeCodeForOpd");
			/*opdPatientDetails =  (OpdPatientDetails)session.load(OpdPatientDetails.class , box.getInt("opdId"));*/
			
		/*	if(opdPatientDetails.getVisit()!=null)
			{
				hinId = opdPatientDetails.getVisit().getHin().getId();
			}
			else
			{
				opdPatientDetails.getInpatient().getHin().getId();
			}*/
			
			referralPatientDetailsList = session.createCriteria(ReferralPatientDetails.class)
					.createAlias("ReferralPatientHeader", "h")
					.createAlias("h.OpdPatientDetails", "opd")
					.add(Restrictions.eq("h.id", box.getInt("opdId")))
					.addOrder(Order.asc("Id")).list();
			
			
			opdPatientDetails = referralPatientDetailsList.get(0).getReferralPatientHeader().getOpdPatientDetails();
			
			diagnosisList = session.createCriteria(DischargeIcdCode.class).createAlias("OpdPatientDetails", "opd").add(Restrictions.eq("opd.id", opdPatientDetails.getId())).addOrder(Order.desc("Id")).list();
			
			
			referralPatientBillingList = session.createCriteria(ReferralPatientBilling.class)
					.createAlias("ReferralDetails", "d")
					.createAlias("d.ReferralPatientHeader", "h")
					.createAlias("h.OpdPatientDetails", "opd")
					.add(Restrictions.eq("h.id", box.getInt("opdId")))
					.addOrder(Order.asc("Id")).list();
			
			referralClarrificationHeaderList = session.createCriteria(ReferralClarrificationHeader.class)					
					.createAlias("ReferralHeader", "h")
					.add(Restrictions.eq("h.Id", box.getInt("opdId")))
					.addOrder(Order.asc("Id")).list();
			
			departmentList=session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status","y").ignoreCase())
					.createAlias("DepartmentType", "dt")
					.add(Restrictions.eq("dt.DepartmentTypeCode", departmentTypeCodeForOpd))
					.addOrder(Order.asc("DepartmentName"))
					.list();
			
			impanelHospitalList=session.createCriteria(MasImpanneledHospital.class)
					.add(Restrictions.eq("Status","y").ignoreCase())					
					.addOrder(Order.asc("ImpanneledHospitalName"))
					.list();
			
			imWardList = session.createCriteria(MasWardImpanneledHospital.class)
				     .add(Restrictions.eq("ImpanneledHospital.Id", opdPatientDetails.getImpanneledHospital().getId())).list();
			System.out.println("imWardList"+imWardList.size());
					
					
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		map.put("impanelHospitalList", impanelHospitalList);
		map.put("departmentList", departmentList);
		map.put("diagnosisList", diagnosisList);
		map.put("referralPatientDetailsList", referralPatientDetailsList);			
		map.put("referralPatientBillingList", referralPatientBillingList);
		map.put("referralClarrificationHeaderList", referralClarrificationHeaderList);
		map.put("opdPatientDetails", opdPatientDetails);
		map.put("imWardList", imWardList);
		return map;
	}
	

	@Override
	public Map<String, Object> generateInvoicePageAlreadySend(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<DischargeIcdCode> diagnosisList = new ArrayList<DischargeIcdCode>();
		List<ReferralPatientDetails> referralPatientDetailsList = new ArrayList<ReferralPatientDetails>();
		List<ReferralPatientBilling> referralPatientBillingList = new ArrayList<ReferralPatientBilling>();
		List<ReferralClarrificationHeader> referralClarrificationHeaderList = new ArrayList<ReferralClarrificationHeader>();
		List<MasImpanneledHospital> impanelHospitalList = new ArrayList<MasImpanneledHospital>();
		List<MasWardImpanneledHospital> imWardList = new ArrayList<MasWardImpanneledHospital>();
		String departmentTypeCodeForOpd="";
		List<MasDepartment> departmentList = null;
		int hinId = 0;
		OpdPatientDetails opdPatientDetails = new OpdPatientDetails();	
		try{
			departmentTypeCodeForOpd = HMSUtil.getProperties("adt.properties", "departmentTypeCodeForOpd");
			ReferralPatientHeader rfh = (ReferralPatientHeader)session.get(ReferralPatientHeader.class, box.getInt("opdId"));
			opdPatientDetails =  rfh.getOpdPatientDetails();
			if(opdPatientDetails.getVisit()!=null)
			{
				hinId = opdPatientDetails.getVisit().getHin().getId();
			}
			else
			{
				opdPatientDetails.getInpatient().getHin().getId();
			}
			
			
			diagnosisList = session.createCriteria(DischargeIcdCode.class).createAlias("OpdPatientDetails", "opd").add(Restrictions.eq("opd.id", opdPatientDetails.getId())).addOrder(Order.desc("Id")).list();
			referralPatientDetailsList = session.createCriteria(ReferralPatientDetails.class)
					.createAlias("ReferralPatientHeader", "h")
					.createAlias("h.OpdPatientDetails", "opd")
					.add(Restrictions.eq("h.id", box.getInt("opdId")))
					.addOrder(Order.asc("Id")).list();
			
			referralPatientBillingList = session.createCriteria(ReferralPatientBilling.class)
					.createAlias("ReferralDetails", "d")
					.createAlias("d.ReferralPatientHeader", "h")
					.createAlias("h.OpdPatientDetails", "opd")
					.add(Restrictions.eq("h.id", box.getInt("opdId")))
					.addOrder(Order.asc("Id")).list();
			
			referralClarrificationHeaderList = session.createCriteria(ReferralClarrificationHeader.class)					
					.createAlias("ReferralHeader", "h")
					.add(Restrictions.eq("h.Id", referralPatientDetailsList.get(0).getReferralPatientHeader().getId()))
					.addOrder(Order.asc("Id")).list();
			
			departmentList=session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status","y").ignoreCase())
					.createAlias("DepartmentType", "dt")
					.add(Restrictions.eq("dt.DepartmentTypeCode", departmentTypeCodeForOpd))
					.addOrder(Order.asc("DepartmentName"))
					.list();
			
			impanelHospitalList=session.createCriteria(MasImpanneledHospital.class)
					.add(Restrictions.eq("Status","y").ignoreCase())					
					.addOrder(Order.asc("ImpanneledHospitalName"))
					.list();
			
			imWardList = session.createCriteria(MasWardImpanneledHospital.class)
				     .add(Restrictions.eq("ImpanneledHospital.Id", opdPatientDetails.getImpanneledHospital().getId())).list();
			System.out.println("imWardList"+imWardList.size());
					
					
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		map.put("impanelHospitalList", impanelHospitalList);
		map.put("departmentList", departmentList);
		map.put("diagnosisList", diagnosisList);
		map.put("referralPatientDetailsList", referralPatientDetailsList);			
		map.put("referralPatientBillingList", referralPatientBillingList);
		map.put("referralClarrificationHeaderList", referralClarrificationHeaderList);
		map.put("opdPatientDetails", opdPatientDetails);
		map.put("imWardList", imWardList);
		return map;
	}
	
	@Override
	public Map<String, Object> generateInvoicePageForHRDivision(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<DischargeIcdCode> diagnosisList = new ArrayList<DischargeIcdCode>();
		List<ReferralPatientDetails> referralPatientDetailsList = new ArrayList<ReferralPatientDetails>();
		List<ReferralPatientBilling> referralPatientBillingList = new ArrayList<ReferralPatientBilling>();
		
		int hinId = 0;
		OpdPatientDetails opdPatientDetails = new OpdPatientDetails();	
		try{
			ReferralPatientHeader rfh = (ReferralPatientHeader)session.get(ReferralPatientHeader.class, box.getInt("opdId"));
			opdPatientDetails =  rfh.getOpdPatientDetails();
			if(opdPatientDetails.getVisit()!=null)
			{
				hinId = opdPatientDetails.getVisit().getHin().getId();
			}
			else
			{
				opdPatientDetails.getInpatient().getHin().getId();
			}
			
			
			diagnosisList = session.createCriteria(DischargeIcdCode.class).createAlias("OpdPatientDetails", "opd").add(Restrictions.eq("opd.id", opdPatientDetails.getId())).addOrder(Order.desc("Id")).list();
			
			referralPatientDetailsList = session.createCriteria(ReferralPatientDetails.class)
					.createAlias("ReferralPatientHeader", "h")
					.createAlias("h.OpdPatientDetails", "opd")
					.add(Restrictions.eq("h.Id", box.getInt("opdId")))
					.addOrder(Order.asc("Id")).list();
			
			referralPatientBillingList = session.createCriteria(ReferralPatientBilling.class)
					.createAlias("ReferralDetails", "d")
					.createAlias("d.ReferralPatientHeader", "h")
					.createAlias("h.OpdPatientDetails", "opd")
					.add(Restrictions.eq("h.Id", box.getInt("opdId")))
					.addOrder(Order.asc("Id")).list();
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		map.put("diagnosisList", diagnosisList);
		map.put("referralPatientDetailsList", referralPatientDetailsList);	
		map.put("referralPatientBillingList", referralPatientBillingList);	
		map.put("opdPatientDetails", opdPatientDetails);
		return map;
	}
	
	@Override
	public Map<String, Object> generateInvoicePageForFinanceDivision(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<DischargeIcdCode> diagnosisList = new ArrayList<DischargeIcdCode>();
		List<ReferralPatientDetails> referralPatientDetailsList = new ArrayList<ReferralPatientDetails>();
		List<ReferralPatientBilling> referralPatientBillingList = new ArrayList<ReferralPatientBilling>();
		int hinId = 0;
		OpdPatientDetails opdPatientDetails = new OpdPatientDetails();	
		try{
			ReferralPatientHeader rfh = (ReferralPatientHeader)session.get(ReferralPatientHeader.class, box.getInt("opdId"));
			opdPatientDetails =  rfh.getOpdPatientDetails();
			if(opdPatientDetails.getVisit()!=null)
			{
				hinId = opdPatientDetails.getVisit().getHin().getId();
			}
			else
			{
				opdPatientDetails.getInpatient().getHin().getId();
			}
			
			
			diagnosisList = session.createCriteria(DischargeIcdCode.class).createAlias("OpdPatientDetails", "opd").add(Restrictions.eq("opd.id", opdPatientDetails.getId())).addOrder(Order.desc("Id")).list();
			referralPatientDetailsList = session.createCriteria(ReferralPatientDetails.class)
					.createAlias("ReferralPatientHeader", "h")
					.createAlias("h.OpdPatientDetails", "opd")
					.add(Restrictions.eq("h.Id", box.getInt("opdId")))
					.addOrder(Order.asc("Id")).list();
			referralPatientBillingList = session.createCriteria(ReferralPatientBilling.class)
					.createAlias("ReferralDetails", "d")
					.createAlias("d.ReferralPatientHeader", "h")
					.createAlias("h.OpdPatientDetails", "opd")
					.add(Restrictions.eq("h.Id", box.getInt("opdId")))
					.addOrder(Order.asc("Id")).list();
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		map.put("diagnosisList", diagnosisList);
		map.put("referralPatientDetailsList", referralPatientDetailsList);	
		map.put("referralPatientBillingList", referralPatientBillingList);	
		map.put("opdPatientDetails", opdPatientDetails);
		return map;
	}
	
	@Override
	public Map<String, Object> generateInvoicePageForGM(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<DischargeIcdCode> diagnosisList = new ArrayList<DischargeIcdCode>();
		List<ReferralPatientDetails> referralPatientDetailsList = new ArrayList<ReferralPatientDetails>();
		List<ReferralPatientBilling> referralPatientBillingList = new ArrayList<ReferralPatientBilling>();
		int hinId = 0;
		OpdPatientDetails opdPatientDetails = new OpdPatientDetails();	
		try{
			ReferralPatientHeader rfh = (ReferralPatientHeader)session.get(ReferralPatientHeader.class, box.getInt("opdId"));
			opdPatientDetails =  rfh.getOpdPatientDetails();
			if(opdPatientDetails.getVisit()!=null)
			{
				hinId = opdPatientDetails.getVisit().getHin().getId();
			}
			else
			{
				opdPatientDetails.getInpatient().getHin().getId();
			}
			
			
			diagnosisList = session.createCriteria(DischargeIcdCode.class).createAlias("OpdPatientDetails", "opd").add(Restrictions.eq("opd.id", opdPatientDetails.getId())).addOrder(Order.desc("Id")).list();
			referralPatientDetailsList = session.createCriteria(ReferralPatientDetails.class)
					.createAlias("ReferralPatientHeader", "h")
					.createAlias("h.OpdPatientDetails", "opd")
					.add(Restrictions.eq("h.Id", box.getInt("opdId")))
					.addOrder(Order.asc("Id")).list();
			referralPatientBillingList = session.createCriteria(ReferralPatientBilling.class)
					.createAlias("ReferralDetails", "d")
					.createAlias("d.ReferralPatientHeader", "h")
					.createAlias("h.OpdPatientDetails", "opd")
					.add(Restrictions.eq("h.Id", box.getInt("opdId")))
					.addOrder(Order.asc("Id")).list();
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		map.put("diagnosisList", diagnosisList);
		map.put("referralPatientDetailsList", referralPatientDetailsList);		
		map.put("referralPatientBillingList", referralPatientBillingList);	
		map.put("opdPatientDetails", opdPatientDetails);
		return map;
	}
	
	@Override
	public Map<String, Object> generateInvoicePageForAll(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<DischargeIcdCode> diagnosisList = new ArrayList<DischargeIcdCode>();
		List<ReferralPatientDetails> referralPatientDetailsList = new ArrayList<ReferralPatientDetails>();
		List<ReferralPatientBilling> referralPatientBillingList = new ArrayList<ReferralPatientBilling>();
		List<ReferralClarrificationHeader> referralClarrificationHeaderList = new ArrayList<ReferralClarrificationHeader>();
		int hinId = 0;
		OpdPatientDetails opdPatientDetails = new OpdPatientDetails();	
		try{
			ReferralPatientHeader rfh = (ReferralPatientHeader)session.get(ReferralPatientHeader.class, box.getInt("opdId"));
			opdPatientDetails =  rfh.getOpdPatientDetails();
			if(opdPatientDetails.getVisit()!=null)
			{
				hinId = opdPatientDetails.getVisit().getHin().getId();
			}
			else
			{
				opdPatientDetails.getInpatient().getHin().getId();
			}
			
			
			diagnosisList = session.createCriteria(DischargeIcdCode.class).createAlias("OpdPatientDetails", "opd").add(Restrictions.eq("opd.id", opdPatientDetails.getId())).addOrder(Order.desc("Id")).list();
			
			referralPatientDetailsList = session.createCriteria(ReferralPatientDetails.class)
					.createAlias("ReferralPatientHeader", "h")
					.createAlias("h.OpdPatientDetails", "opd")
					.add(Restrictions.eq("h.Id", box.getInt("opdId")))
					.addOrder(Order.asc("Id")).list();
			referralPatientBillingList = session.createCriteria(ReferralPatientBilling.class)
					.createAlias("ReferralDetails", "d")
					.createAlias("d.ReferralPatientHeader", "h")
					.createAlias("h.OpdPatientDetails", "opd")
					.add(Restrictions.eq("h.Id", box.getInt("opdId")))
					.addOrder(Order.asc("Id")).list();
			
			referralClarrificationHeaderList = session.createCriteria(ReferralClarrificationHeader.class)					
					.createAlias("ReferralHeader", "h")
					.add(Restrictions.eq("h.Id", box.getInt("opdId")))
					.addOrder(Order.asc("Id")).list();
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		map.put("diagnosisList", diagnosisList);
		map.put("referralClarrificationHeaderList", referralClarrificationHeaderList);
		map.put("referralPatientDetailsList", referralPatientDetailsList);		
		map.put("referralPatientBillingList", referralPatientBillingList);	
		map.put("opdPatientDetails", opdPatientDetails);
		return map;
	}
	
	@Override
	public Map<String, Object> generateInvoicePageForExtention(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<DischargeIcdCode> diagnosisList = new ArrayList<DischargeIcdCode>();
		List<ReferralPatientDetails> referralPatientDetailsList = new ArrayList<ReferralPatientDetails>();
		List<ReferralPatientBilling> referralPatientBillingList = new ArrayList<ReferralPatientBilling>();
		int hinId = 0;
		OpdPatientDetails opdPatientDetails = new OpdPatientDetails();	
		try{
			opdPatientDetails =  (OpdPatientDetails)session.load(OpdPatientDetails.class , box.getInt("opdId"));
			if(opdPatientDetails.getVisit()!=null)
			{
				hinId = opdPatientDetails.getVisit().getHin().getId();
			}
			else
			{
				opdPatientDetails.getInpatient().getHin().getId();
			}
			
			
			diagnosisList = session.createCriteria(DischargeIcdCode.class).createAlias("OpdPatientDetails", "opd").add(Restrictions.eq("opd.id", box.getInt("opdId"))).addOrder(Order.desc("Id")).list();
			referralPatientDetailsList = session.createCriteria(ReferralPatientDetails.class)
					.createAlias("ReferralPatientHeader", "h")
					.createAlias("h.OpdPatientDetails", "opd")
					.add(Restrictions.eq("opd.id", box.getInt("opdId")))
					.addOrder(Order.asc("Id")).list();
			referralPatientBillingList = session.createCriteria(ReferralPatientBilling.class)
					.createAlias("ReferralDetails", "d")
					.createAlias("d.ReferralPatientHeader", "h")
					.createAlias("h.OpdPatientDetails", "opd")
					.add(Restrictions.eq("opd.id", box.getInt("opdId")))
					.addOrder(Order.asc("Id")).list();
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		map.put("diagnosisList", diagnosisList);
		map.put("referralPatientDetailsList", referralPatientDetailsList);		
		map.put("referralPatientBillingList", referralPatientBillingList);	
		map.put("opdPatientDetails", opdPatientDetails);
		return map;
	}
	
	@SuppressWarnings("unchecked")
	public synchronized Map<String, Object> submitReferralLetterPage(
			Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean succesfullyAdded = false;
	
	
		Session session = (Session) getSession();
		Users user = new Users();
		user.setId(box.getInt("userId"));
		MasHospital hospital = new MasHospital();
		hospital.setId(box.getInt("hospitalId"));
		
		int hinId =0;
		int opdPatientDetailsId =0;
		String referral_note = "";
		String referral_no = "";
		int validity_period =0;
		int employee_dependent_id =0;
		String subject = "";
		String flag = "";
		String referralTreatmentType = "";
		ReferralPatientHeader referralPatientHeader = new ReferralPatientHeader();
		ReferralPatientDetails referralPatientDetails = new ReferralPatientDetails();
		List<MasEmployeeDependent> masEmployeeDependentList = new ArrayList<MasEmployeeDependent>();
        Patient patient = new Patient();
        OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
       
		if(box.get("hinId")!= null){
			hinId = (Integer)box.getInt("hinId");
		}
		
		if(box.get("opdPatientDetailsId")!= null){
			opdPatientDetailsId = (Integer)box.getInt("opdPatientDetailsId");
		}
		
		if(box.get("referral_note")!= null){
			referral_note = box.getString("referral_note");
		}
		
		if(box.get("validity_period")!= null){
			validity_period = box.getInt("validity_period");
		}
		if(box.get("subject")!= null){
			subject = box.getString("subject");
		}
	
	
		Transaction tx = null;
		
	
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			session.clear();
			hbt.clear();
			
			map.put("tableObjectName", "ReferralPatientDetails");			
			map.put("isHospitalWise", "y");
			map.put("hospitalId", box.getInt("hospitalId"));
			map.put("isYearly", "y");			
			map.put("isMonthly", "y");
			map.put("isPrefix", "y");
			map.put("transactionPrefixProperty", "transactionPrefixForReferralNo");
			
			referral_no = HMSUtil.generateTransactionSequence(map, session, hbt);
			
			
			
			patient = (Patient)session.load(Patient.class, hinId);
			masEmployeeDependentList = session.createCriteria(MasEmployeeDependent.class)
			       .add(Restrictions.eq("Employee.Id", patient.getEmployee().getId()))
			       .add(Restrictions.eq("Relation.Id", patient.getRelation().getId())).list();
			if(masEmployeeDependentList.size()>0)
			{
				referralPatientHeader.setEmployeeDependent(masEmployeeDependentList.get(0));
			}
			opdPatientDetails = (OpdPatientDetails)session.load(OpdPatientDetails.class, opdPatientDetailsId);
			referralPatientHeader.setHin(patient);
			referralPatientHeader.setOpdPatientDetails(opdPatientDetails);
			referralPatientHeader.setDoctor(opdPatientDetails.getEmployee());
			referralPatientHeader.setReferralDate(opdPatientDetails.getReferredDate());
			referralPatientHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
		    referralPatientHeader.setLastChgTime(box.getString(CHANGED_TIME));
		    referralPatientHeader.setLastChgBy(user);
		    referralPatientHeader.setHospital(hospital);
		    referralPatientHeader.setName(patient.getPFirstName()+(patient.getPMiddleName()!=null?(patient.getPMiddleName()+" "):"")+(patient.getPLastName()!=null?patient.getPLastName():""));
		    referralPatientHeader.setRelation(patient.getRelation());
		    referralPatientHeader.setAge(patient.getAge());
		    referralPatientHeader.setGender(patient.getSex());
		    referralPatientHeader.setGenderName(patient.getSex().getAdministrativeSexName());
		    referralPatientHeader.setEmpNo(patient.getServiceNo());
		    referralPatientHeader.setDivision(patient.getEmployee().getDivision());
		    referralPatientHeader.setDivisionName(patient.getEmployee().getDivision().getDivisionName());
		    referralPatientHeader.setContactNo(patient.getContactNo());
		    referralPatientHeader.setFromHospital(hospital);
		    referralPatientHeader.setToHospital(opdPatientDetails.getImpanneledHospital());
		    referralPatientHeader.setReferralNo(referral_no);
		    referralPatientHeader.setExtensionStatus("WDA");
		    /*opdPatientDetails.setEmpanelStatus("WPH");*/ //waiting portal HAL
		    referralPatientHeader.setExcelStatus("WEG"); // waiting for excel generation
		    referralPatientHeader.setApprovalStatus("WA");  // Waiting for Admin approval (for temporary purpose in case of unavalibility of Internet Portal)
		    hbt.save(referralPatientHeader); 
		    hbt.flush();
		    System.out.println("in Submit");
		    
		    referralPatientDetails.setReferralPatientHeader(referralPatientHeader);
		    referralPatientDetails.setNoOfDays(opdPatientDetails.getReferralDays());
		    referralPatientDetails.setReferralExtensionDate(opdPatientDetails.getReferredDate());
		    referralPatientDetails.setTreatmentType(opdPatientDetails.getReferralTreatmentType());
		    referralPatientDetails.setReferredFor(box.getString("referredFor"));
		    referralPatientDetails.setReferralNote(referral_note);
		    referralPatientDetails.setLetterValidityPeriod(validity_period);
		    referralPatientDetails.setSubject(subject);
		    referralPatientDetails.setDoctorRemarks(opdPatientDetails.getReferralNotes());		   
		    referralPatientDetails.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
		    referralPatientDetails.setLastChgTime(box.getString(CHANGED_TIME));
		    referralPatientDetails.setLastChgBy(user);
		    referralPatientDetails.setDoctor(opdPatientDetails.getEmployee());
		    referralPatientDetails.setReferralNo(referral_no+".1");	
		    if(box.getInt("wardId")!=0)
		    {
		    	MasWardImpanneledHospital mwih = new MasWardImpanneledHospital();
			    mwih.setId(box.getInt("wardId"));
			    referralPatientDetails.setWard(mwih);
		    }
		    
		    hbt.save(referralPatientDetails);                  
		    
		    opdPatientDetails.setEmpanelStatus("TC");  //Treatment complete (for temporary purpose in case of unavalibility of Internet Portal)
		    hbt.update(referralPatientDetails);
		    hbt.flush(); 
			
			// code starts for parameters of generating referral letter 
			
			if(referralPatientHeader.getEmployeeDependent()!=null)
			{
				flag="dependent";
			}
			else
			{
				flag="employee";
			}
			
			 referralTreatmentType = referralPatientHeader.getOpdPatientDetails().getReferralTreatmentType();
			
			 //code ends for parameters of generating referral letter
			 
			 
		     succesfullyAdded = true;
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
			
		}     
		finally
		{
			session.close();
			
		}
		map.put("succesfullyAdded", succesfullyAdded);
		map.put("flag", flag);
		map.put("referralTreatmentType", referralTreatmentType);
		map.put("referralPatientDetailsId", referralPatientDetails.getId());

		return map;
	}
	
	
	@SuppressWarnings("unchecked")
	public synchronized Map<String, Object> submitExtensionLetterPage(
			Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean succesfullyAdded = false;
	
	
		Session session = (Session) getSession();
		Users user = new Users();
		user.setId(box.getInt("userId"));
		MasHospital hospital = new MasHospital();
		hospital.setId(box.getInt("hospitalId"));
		
		int referralPatientHeaderId =0;
		int referralPatientDetailsId =0;
		int opdPatientDetailsId =0;
		int indexOfDot =0;
		String pre_str = "";
		String post_str = "";
		String referral_note = "";
		String referral_no = "";
		int validity_period =0;
		String subject = "";
		String flag = "";
		String referralTreatmentType = "";
		ReferralPatientHeader referralPatientHeader = new ReferralPatientHeader();
		ReferralPatientDetails referralPatientDetails = new ReferralPatientDetails();
        Patient patient = new Patient();
       
       
		if(box.get("referralPatientHeaderId")!= null){
			referralPatientHeaderId = (Integer)box.getInt("referralPatientHeaderId");
		}
		
		if(box.get("referralPatientDetailsId")!= null){
			referralPatientDetailsId = (Integer)box.getInt("referralPatientDetailsId");
		}
		
		if(box.get("opdPatientDetailsId")!= null){
			opdPatientDetailsId = (Integer)box.getInt("opdPatientDetailsId");
		}
		
		if(box.get("referral_note")!= null){
			referral_note = box.getString("referral_note");
		}
		
		if(box.get("validity_period")!= null){
			validity_period = box.getInt("validity_period");
		}
		if(box.get("subject")!= null){
			subject = box.getString("subject");
		}
		if(box.get("last_referral_no")!= null){
			referral_no = box.getString("last_referral_no");
		}
	    
	
		Transaction tx = null;
		
	
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			session.clear();
			hbt.clear();
			
			/*map.put("tableObjectName", "ReferralPatientDetails");			
			map.put("isHospitalWise", "y");
			map.put("hospitalId", box.getInt("hospitalId"));
			map.put("isYearly", "n");			
			map.put("isMonthly", "n");
			map.put("isPrefix", "y");
			map.put("transactionPrefixProperty", "transactionPrefixForReferralNo");
			
			referral_no = HMSUtil.generateTransactionSequence(map, session, hbt);*/
			System.out.println("referral_no"+referral_no.length());
			indexOfDot = referral_no.indexOf('.');
			System.out.println("indexOfDot"+indexOfDot);
			pre_str = referral_no.substring(0, indexOfDot);
			System.out.println("pre_str"+pre_str);
			post_str = referral_no.substring(indexOfDot+1, referral_no.length());
			System.out.println("post_str"+post_str);
			post_str = String.valueOf((Integer.parseInt(post_str)+1));
			System.out.println("post_str"+post_str);
			referral_no = pre_str+"."+post_str;
			System.out.println("referral_no"+referral_no);
			
			
			referralPatientHeader = (ReferralPatientHeader)session.load(ReferralPatientHeader.class, referralPatientHeaderId);
			referralPatientDetails = (ReferralPatientDetails)session.load(ReferralPatientDetails.class, referralPatientDetailsId);
			
			referralPatientHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
		    referralPatientHeader.setLastChgTime(box.getString(CHANGED_TIME));
		    referralPatientHeader.setLastChgBy(user);
		    /*referralPatientHeader.setExtensionStatus("ENG");*/
		    referralPatientHeader.setExtensionStatus("WDA");
		    /*opdPatientDetails.setEmpanelStatus("WPH");*/ //waiting portal HAL
		    referralPatientHeader.setExcelStatus("WEG"); // waiting for excel generation
		    referralPatientHeader.setApprovalStatus("WA");  // Waiting for Admin approval (for temporary purpose in case of unavalibility of Internet Portal)
		    hbt.update(referralPatientHeader);
		    hbt.flush();
		    System.out.println("in Submit");
		    
		    
		    
		    referralPatientDetails.setReferralNote(referral_note);
		    referralPatientDetails.setLetterValidityPeriod(validity_period);
		    referralPatientDetails.setSubject(subject);	
		    referralPatientDetails.setReferredFor(box.getString("referredFor"));
		    referralPatientDetails.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
		    referralPatientDetails.setLastChgTime(box.getString(CHANGED_TIME));
		    referralPatientDetails.setLastChgBy(user);
		    referralPatientDetails.setDoctor(referralPatientHeader.getDoctor());
		    referralPatientDetails.setReferralNo(referral_no);
		    if(box.getInt("wardId")!=0)
		    {
		    MasWardImpanneledHospital mwih = new MasWardImpanneledHospital();
		    mwih.setId(box.getInt("wardId"));
		    referralPatientDetails.setWard(mwih);
		    }
		    hbt.update(referralPatientDetails);                  
		    
		    hbt.flush(); 
			
			// code starts for parameters of generating referral letter 
			
			if(referralPatientHeader.getEmployeeDependent()!=null)
			{
				flag="dependent";
			}
			else
			{
				flag="employee";
			}
			
			 referralTreatmentType = referralPatientDetails.getTreatmentType();
			
			 //code ends for parameters of generating referral letter
			 
			 
		     succesfullyAdded = true;
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
			
		}     
		finally
		{
			session.close();
			
		}
		map.put("succesfullyAdded", succesfullyAdded);
		map.put("referral_no", referral_no);
		map.put("flag", flag);
		map.put("referralTreatmentType", referralTreatmentType);
		map.put("referralPatientDetailsId", referralPatientDetails.getId());

		return map;
	}
	
	
	@SuppressWarnings("deprecation")
	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		map.put("conn", con);
		return map;
	}
	
	@SuppressWarnings("deprecation")
	public Map<String, Object> getMedicalHR() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		String flag = "employee";
		MasDivision md = (MasDivision)session.get(MasDivision.class, 17);
	    map.put("hrMedical", md.getCoveringLetterAuthority()!=null?md.getCoveringLetterAuthority().trim()+"-M&H":"");
		
		return map;
	}
	
	@SuppressWarnings("deprecation")
	public String getReportFlag(int referralPatientDetailsId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		String flag = "employee";
		if(((ReferralPatientDetails)session.load(ReferralPatientDetails.class, referralPatientDetailsId)).getReferralPatientHeader().getEmployeeDependent()!=null)
		{
			flag = "dependent";
		}
		
		return flag;
	}
	
	@SuppressWarnings("unchecked")
	public synchronized Map<String, Object> submitInvoicePage(
			Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean succesfullyAdded = false;
	
	
		Session session = (Session) getSession();
		Users user = new Users();
		user.setId(box.getInt("userId"));
		MasHospital hospital = new MasHospital();
		hospital.setId(box.getInt("hospitalId"));
		
		int hinId =0;
		int opdPatientDetailsId =0;
		int divCountBilling =0;
		int referralPatientDetailsId = 0;		
		int referralBillingId = 0;
		double impanelled_bill = 0.0;
		double hal_bill = 0.0;
		String bill_no = "";
		Date bill_date = null;
		String admin_remarks = "";
		String covernote_no = "";
		double totalBillAmt = 0;
		double adminBillAmt=0;
		double deductionFS=0;
		String flag="";
		boolean clarificationFlag = true;
		String clf_no = "";
		
		
		
        Patient patient = new Patient();
        OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
       
		if(box.get("hinId")!= null){
			hinId = (Integer)box.getInt("hinId");
		}
		
		if(box.get("opdPatientDetailsId")!= null){
			opdPatientDetailsId = (Integer)box.getInt("opdPatientDetailsId");
		}
		
		
		
	
		if(box.get("divCountBilling")!= null){
			divCountBilling = box.getInt("divCountBilling");
		}
		
		if(box.get("deductionFS")!= null){
			deductionFS = box.getDouble("deductionFS");
			
		}
		
		
		
		
	
	
		Transaction tx = null;
		
	
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			session.clear();
			hbt.clear();
			
			
			
			/*referralPatientBilling = (ReferralPatientBilling)session.load(ReferralPatientBilling.class, referralPatientBillingId);*/
		
		    ReferralClarrificationHeader referralClarrificationHeader = new ReferralClarrificationHeader();
		   for(int i = 1; i<=divCountBilling; i++)
		   {	
			   System.out.println("i"+i);
			   if(box.get("referralNoId"+i)!= null && box.getInt("referralNoId"+i)!=0){
			   impanelled_bill = 0.0;
			   hal_bill = 0.0;
			   admin_remarks = "";
			   bill_no = "";
			   bill_date = null;
			   ReferralPatientBilling referralPatientBilling = new ReferralPatientBilling();
			   if(box.get("referralBillingId"+i)!= null && box.getInt("referralBillingId"+i)!=0){
				   referralBillingId = box.getInt("referralBillingId"+i);
				   referralPatientBilling.setId(referralBillingId);
				   System.out.println("referralBillingId"+referralBillingId);
				}
			 
				
			   
			   
				ReferralPatientDetails referralPatientDetails = new ReferralPatientDetails();
				ReferralClarificationDetails referralClarificationDetail = new ReferralClarificationDetails();	
				if(box.get("referralNoId"+i)!= null){
					referralPatientDetailsId = box.getInt("referralNoId"+i);
					referralPatientDetails = (ReferralPatientDetails)session.get(ReferralPatientDetails.class, referralPatientDetailsId);
				}
				
				if(box.get("impanelled_bill"+i)!= null){
					impanelled_bill = box.getDouble("impanelled_bill"+i);
					totalBillAmt += impanelled_bill;
				}
				System.out.println("impanelled_bill"+impanelled_bill);
				System.out.println("totalBillAmt"+totalBillAmt);
				if(box.get("hal_bill"+i)!= null){
					hal_bill = box.getDouble("hal_bill"+i);
					
					adminBillAmt += hal_bill;
				}
				
				
				
				if(box.get("admin_remarks"+i)!= null){
					admin_remarks = box.getString("admin_remarks"+i);
				}
				if(box.get("bill_no"+i)!= null){
					bill_no = box.getString("bill_no"+i);
				}
				if(box.get("bill_date"+i)!= null){
					bill_date = HMSUtil.convertStringTypeDateToDateType(box.getString("bill_date"+i));
				}
			referralPatientBilling.setReferralDetails(referralPatientDetails);
			referralPatientBilling.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			referralPatientBilling.setLastChgTime(box.getString(CHANGED_TIME));
			referralPatientBilling.setLastChgBy(user);						
			referralPatientBilling.setTotalBillAmt(new BigDecimal(impanelled_bill).setScale(2, BigDecimal.ROUND_HALF_UP));
			referralPatientBilling.setAdminBillAmt(new BigDecimal(hal_bill).setScale(2, BigDecimal.ROUND_HALF_UP));
			referralPatientBilling.setAdminRemarks(admin_remarks);
			referralPatientBilling.setBillNo(bill_no);
			referralPatientBilling.setBillDate(bill_date);
			referralPatientDetails.getReferralPatientHeader().setDeductionFromSalary(new BigDecimal(deductionFS).setScale(2, BigDecimal.ROUND_HALF_UP));
			if(box.get("saveAs")!= null && box.get("saveAs").equals("draft")){
				/*referralPatientBilling.setApprovalStatus("WA");*/
				if(i==divCountBilling)
				{
				/*referralPatientDetails.getReferralPatientHeader().setApprovalStatus("WA");*/
				
				if(referralPatientDetails.getReferralPatientHeader().getCovernoteNumber()==null || referralPatientDetails.getReferralPatientHeader().getCovernoteNumber().trim().equals(""))
									{
					map.put("tableObjectName", "ReferralPatientHeader");			
				map.put("isHospitalWise", "n");
				/*map.put("hospitalId", box.getInt("hospitalId"));*/
				map.put("isYearly", "y");			
				map.put("isMonthly", "n");
				map.put("isPrefix", "y");
				map.put("transactionPrefixProperty", "transactionPrefixForCoverNoteNo");				
				covernote_no = HMSUtil.generateTransactionSequence(map, session, hbt);
				referralPatientDetails.getReferralPatientHeader().setCovernoteNumber(covernote_no);
				referralPatientDetails.getReferralPatientHeader().setCovernoteDate(new Date());
				
				
			
			
				
				}
				}
			}
			else
			{
				referralPatientBilling.setApprovalStatus("WHD");
				referralPatientDetails.getReferralPatientHeader().setApprovalStatus("WHD");	
				referralPatientDetails.getReferralPatientHeader().setAdminApprovalDate(new Date());
				referralPatientDetails.getReferralPatientHeader().setAdminApprovalTime(box.getString(LAST_CHANGED_TIME));
				referralPatientDetails.getReferralPatientHeader().setAdminBillAmt(new BigDecimal(adminBillAmt).setScale(2, BigDecimal.ROUND_HALF_UP));
				referralPatientDetails.getReferralPatientHeader().setTotalBillAmt(new BigDecimal(totalBillAmt).setScale(2, BigDecimal.ROUND_HALF_UP));
				
				if(referralPatientDetails.getReferralPatientHeader().getCovernoteNumber()==null || referralPatientDetails.getReferralPatientHeader().getCovernoteNumber().trim().equals(""))
				{
            map.put("tableObjectName", "ReferralPatientHeader");			
            map.put("isHospitalWise", "n");
            /*map.put("hospitalId", box.getInt("hospitalId"));*/
            map.put("isYearly", "y");			
map.put("isMonthly", "n");
map.put("isPrefix", "y");
map.put("transactionPrefixProperty", "transactionPrefixForCoverNoteNo");				
covernote_no = HMSUtil.generateTransactionSequence(map, session, hbt);
referralPatientDetails.getReferralPatientHeader().setCovernoteNumber(covernote_no);
referralPatientDetails.getReferralPatientHeader().setCovernoteDate(new Date());
}
			}
			covernote_no = referralPatientDetails.getReferralPatientHeader().getCovernoteNumber();
			map.put("referral_patient_details_id", referralPatientDetailsId);
			map.put("referral_patient_header_id", referralPatientDetails.getReferralPatientHeader().getId());
		/*	else
			{
				referralPatientBilling.setApprovalStatus("WHD");
				if(i==divCountBilling)
				{
					map.put("tableObjectName", "ReferralPatientHeader");			
					map.put("isHospitalWise", "n");
					map.put("hospitalId", box.getInt("hospitalId"));
					map.put("isYearly", "y");			
					map.put("isMonthly", "n");
					map.put("isPrefix", "y");
					map.put("transactionPrefixProperty", "transactionPrefixForCoverNoteNo");				
					covernote_no = HMSUtil.generateTransactionSequence(map, session, hbt);
					referralPatientDetails.getReferralPatientHeader().setCovernoteNumber(covernote_no);
					referralPatientDetails.getReferralPatientHeader().setCovernoteDate(new Date());
					referralPatientDetails.getReferralPatientHeader().setApprovalStatus("WHD");	
					referralPatientDetails.getReferralPatientHeader().setAdminApprovalDate(new Date());
					referralPatientDetails.getReferralPatientHeader().setAdminApprovalTime(box.getString(LAST_CHANGED_TIME));;
					
					referralPatientDetails.getReferralPatientHeader().setAdminBillAmt(new BigDecimal(adminBillAmt).setScale(2, BigDecimal.ROUND_HALF_UP));
					referralPatientDetails.getReferralPatientHeader().setTotalBillAmt(new BigDecimal(totalBillAmt).setScale(2, BigDecimal.ROUND_HALF_UP));
					map.put("referral_patient_details_id", referralPatientDetailsId);
					map.put("referral_patient_header_id", referralPatientDetails.getReferralPatientHeader().getId());
				}
				
			}*/
			
		    hbt.saveOrUpdate(referralPatientBilling);
		    
		    if(box.get("saveAs")!= null && box.get("saveAs").equals("draft")){
			if(box.get("clarri_bill"+i)!=null && box.getString("clarri_bill"+i).equalsIgnoreCase("y"))
			{
				
			if(clarificationFlag)
			{
				map.put("tableObjectName", "ReferralClarrificationHeader");			
				map.put("isHospitalWise", "y");
				map.put("hospitalId", box.getInt("hospitalId"));
				map.put("isYearly", "n");			
				map.put("isMonthly", "n");
				map.put("isPrefix", "y");
				map.put("transactionPrefixProperty", "transactionPrefixForReferralClarrification");
				
				clf_no = HMSUtil.generateTransactionSequence(map, session, hbt);
				
				referralClarrificationHeader.setClarificationNo(clf_no);
				referralClarrificationHeader.setReferralHeader(referralPatientDetails.getReferralPatientHeader());
				referralClarrificationHeader.setClarificationRemarks(box.getString("clarri_remarks"));
				referralClarrificationHeader.setGenerationDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
				referralClarrificationHeader.setGeneratedBy(user);
				referralClarrificationHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
				referralClarrificationHeader.setLastChgBy(user);
				referralClarrificationHeader.setLastChgTime(box.getString(CHANGED_TIME));
				hbt.save(referralClarrificationHeader);
				clarificationFlag = false;
				map.put("referralClarrificationHeaderId", referralClarrificationHeader.getId());
			}
				
			referralClarificationDetail.setClarificationHeader(referralClarrificationHeader);
			referralClarificationDetail.setReferralBilling(referralPatientBilling);
			hbt.save(referralClarificationDetail);
		}
			int  clarriCount = box.getInt("clarriCount");
			for(int j =1; j<=clarriCount; j++)
			{
				
				if(box.get("impanel_remarks"+j)!= null && !box.get("impanel_remarks"+j).trim().equals("")){
					ReferralClarrificationHeader rcch = new ReferralClarrificationHeader();
					rcch = (ReferralClarrificationHeader)session.load(ReferralClarrificationHeader.class, box.getInt("clarriHeaderId"+j));
					rcch.setImpaneledRemarks(box.get("impanel_remarks"+j));
					hbt.update(rcch);
					
				}
			}
			
		   }
			
		    hbt.flush(); 
		   } }
			succesfullyAdded = true;
			tx.commit();
				
			
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
			
		}     
		finally
		{
			session.close();
			
		}
		map.put("succesfullyAdded", succesfullyAdded);	
		map.put("covernote_no", covernote_no);
		

		return map;
	}
	
	
	@SuppressWarnings("unchecked")
	public synchronized Map<String, Object> submitInvoicePageAlreadySend(
			Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean succesfullyAdded = false;
	
	
		Session session = (Session) getSession();
		Users user = new Users();
		user.setId(box.getInt("userId"));
		MasHospital hospital = new MasHospital();
		hospital.setId(box.getInt("hospitalId"));
		
		int hinId =0;
		int referralPatientHeaderId =0;
		int opdPatientDetailsId =0;
		int divCountBilling =0;
		int referralPatientDetailsId = 0;		
		int referralBillingId = 0;
		double impanelled_bill = 0.0;
		double hal_bill = 0.0;
		String bill_no = "";
		Date bill_date = null;
		String admin_remarks = "";
		String covernote_no = "";
		double totalBillAmt = 0;
		double adminBillAmt=0;
		double deductionFS=0;
		String flag="";
		boolean clarificationFlag = true;
		String clf_no = "";
		
		
		
        Patient patient = new Patient();
        OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
       
		if(box.get("hinId")!= null){
			hinId = (Integer)box.getInt("hinId");
		}
		
		if(box.get("opdPatientDetailsId")!= null){
			opdPatientDetailsId = (Integer)box.getInt("opdPatientDetailsId");
		}
		if(box.get("deductionFS")!= null){
			deductionFS = box.getDouble("deductionFS");
			
		}
		
		
		
	
		if(box.get("divCountBilling")!= null){
			divCountBilling = box.getInt("divCountBilling");
		}
		
		if(box.get("referralPatientHeaderId")!= null){
			referralPatientHeaderId = box.getInt("referralPatientHeaderId");
		}
		
		
		
	
	
		Transaction tx = null;
		
	
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			session.clear();
			hbt.clear();
			
			
			ReferralPatientHeader referralPatientHeaderOld = new ReferralPatientHeader();
			referralPatientHeaderOld = (ReferralPatientHeader)session.get(ReferralPatientHeader.class, referralPatientHeaderId);
			ReferralPatientHeader referralPatientHeaderNew = new ReferralPatientHeader(referralPatientHeaderOld);	
			referralPatientHeaderNew.setDeductionFromSalary(new BigDecimal(deductionFS).setScale(2, BigDecimal.ROUND_HALF_UP));
			hbt.save(referralPatientHeaderNew);
			hbt.flush();
			
			
			List<ReferralPatientDetails> rPDList = new ArrayList<ReferralPatientDetails>();
			rPDList = session.createCriteria(ReferralPatientDetails.class)
					.add(Restrictions.eq("ReferralPatientHeader.Id", referralPatientHeaderId)).list();
			/*referralPatientBilling = (ReferralPatientBilling)session.load(ReferralPatientBilling.class, referralPatientBillingId);*/
			for(ReferralPatientDetails rpd : rPDList)
			{
				ReferralPatientDetails rpdcopy = new ReferralPatientDetails(rpd);				
				rpdcopy.setReferralPatientHeader(referralPatientHeaderNew);
				hbt.save(rpdcopy);
				hbt.flush();
				for(int i = 1; i<=divCountBilling; i++)
				   {	
					System.out.println("box.getInt(i)"+box.getInt("referralNoId"+i));
					if(rpd.getId() == box.getInt("referralNoId"+i))
					{
						box.put("referralNoId"+i, rpdcopy.getId());
					}
				   }
				
			}
		
		    ReferralClarrificationHeader referralClarrificationHeader = new ReferralClarrificationHeader();
		   for(int i = 1; i<=divCountBilling; i++)
		   {	
			   if(box.get("bill_no"+i)!= null && !box.getString("bill_no"+i).trim().equals("")){
			   impanelled_bill = 0.0;
			   hal_bill = 0.0;
			   admin_remarks = "";
			   bill_no = "";
			   bill_date = null;
			   ReferralPatientBilling referralPatientBilling = new ReferralPatientBilling();
			   if(box.get("referralBillingId"+i)!= null && box.getInt("referralBillingId"+i)!=0){
				   referralBillingId = box.getInt("referralBillingId"+i);
				   referralPatientBilling.setId(referralBillingId);
				   System.out.println("referralBillingId"+referralBillingId);
				}
			 
				
			   
			   
				ReferralPatientDetails referralPatientDetails = new ReferralPatientDetails();
				ReferralClarificationDetails referralClarificationDetail = new ReferralClarificationDetails();	
				if(box.get("referralNoId"+i)!= null){
					referralPatientDetailsId = box.getInt("referralNoId"+i);
					referralPatientDetails = (ReferralPatientDetails)session.get(ReferralPatientDetails.class, referralPatientDetailsId);
				}
				
				if(box.get("impanelled_bill"+i)!= null){
					impanelled_bill = box.getDouble("impanelled_bill"+i);
					totalBillAmt += impanelled_bill;
				}
				System.out.println("impanelled_bill"+impanelled_bill);
				System.out.println("totalBillAmt"+totalBillAmt);
				if(box.get("hal_bill"+i)!= null){
					hal_bill = box.getDouble("hal_bill"+i);
					
					adminBillAmt += hal_bill;
				}
				
				if(box.get("admin_remarks"+i)!= null){
					admin_remarks = box.getString("admin_remarks"+i);
				}
				if(box.get("bill_no"+i)!= null){
					bill_no = box.getString("bill_no"+i);
				}
				if(box.get("bill_date"+i)!= null){
					bill_date = HMSUtil.convertStringTypeDateToDateType(box.getString("bill_date"+i));
				}
			referralPatientBilling.setReferralDetails(referralPatientDetails);
			referralPatientBilling.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			referralPatientBilling.setLastChgTime(box.getString(CHANGED_TIME));
			referralPatientBilling.setLastChgBy(user);						
			referralPatientBilling.setTotalBillAmt(new BigDecimal(impanelled_bill).setScale(2, BigDecimal.ROUND_HALF_UP));
			referralPatientBilling.setAdminBillAmt(new BigDecimal(hal_bill).setScale(2, BigDecimal.ROUND_HALF_UP));
			referralPatientBilling.setAdminRemarks(admin_remarks);
			referralPatientBilling.setBillNo(bill_no);
			referralPatientBilling.setBillDate(bill_date);
			if(box.get("saveAs")!= null && box.get("saveAs").equals("draft")){
				referralPatientBilling.setApprovalStatus("WA");
				if(i==divCountBilling)
				{
				referralPatientDetails.getReferralPatientHeader().setApprovalStatus("WA");
				
				if(referralPatientDetails.getReferralPatientHeader().getCovernoteNumber()==null || referralPatientDetails.getReferralPatientHeader().getCovernoteNumber().trim().equals(""))
									{
					map.put("tableObjectName", "ReferralPatientHeader");			
				map.put("isHospitalWise", "n");
				/*map.put("hospitalId", box.getInt("hospitalId"));*/
				map.put("isYearly", "y");			
				map.put("isMonthly", "n");
				map.put("isPrefix", "y");
				map.put("transactionPrefixProperty", "transactionPrefixForCoverNoteNo");				
				covernote_no = HMSUtil.generateTransactionSequence(map, session, hbt);
				referralPatientDetails.getReferralPatientHeader().setCovernoteNumber(covernote_no);
				referralPatientDetails.getReferralPatientHeader().setCovernoteDate(new Date());
			
			
				
				}
				}
			}
			else
			{
				referralPatientBilling.setApprovalStatus("WHD");
				referralPatientDetails.getReferralPatientHeader().setApprovalStatus("WHD");	
				referralPatientDetails.getReferralPatientHeader().setAdminApprovalDate(new Date());
				referralPatientDetails.getReferralPatientHeader().setAdminApprovalTime(box.getString(LAST_CHANGED_TIME));
				referralPatientDetails.getReferralPatientHeader().setAdminBillAmt(new BigDecimal(adminBillAmt).setScale(2, BigDecimal.ROUND_HALF_UP));
				referralPatientDetails.getReferralPatientHeader().setTotalBillAmt(new BigDecimal(totalBillAmt).setScale(2, BigDecimal.ROUND_HALF_UP));
				
				if(referralPatientDetails.getReferralPatientHeader().getCovernoteNumber()==null || referralPatientDetails.getReferralPatientHeader().getCovernoteNumber().trim().equals(""))
				{
            map.put("tableObjectName", "ReferralPatientHeader");			
            map.put("isHospitalWise", "n");
            /*map.put("hospitalId", box.getInt("hospitalId"));*/
            map.put("isYearly", "y");			
map.put("isMonthly", "n");
map.put("isPrefix", "y");
map.put("transactionPrefixProperty", "transactionPrefixForCoverNoteNo");				
covernote_no = HMSUtil.generateTransactionSequence(map, session, hbt);
referralPatientDetails.getReferralPatientHeader().setCovernoteNumber(covernote_no);
referralPatientDetails.getReferralPatientHeader().setCovernoteDate(new Date());
}
			}
			covernote_no = referralPatientDetails.getReferralPatientHeader().getCovernoteNumber();
			map.put("referral_patient_details_id", referralPatientDetailsId);
			map.put("referral_patient_header_id", referralPatientDetails.getReferralPatientHeader().getId());
		/*	else
			{
				referralPatientBilling.setApprovalStatus("WHD");
				if(i==divCountBilling)
				{
					map.put("tableObjectName", "ReferralPatientHeader");			
					map.put("isHospitalWise", "n");
					map.put("hospitalId", box.getInt("hospitalId"));
					map.put("isYearly", "y");			
					map.put("isMonthly", "n");
					map.put("isPrefix", "y");
					map.put("transactionPrefixProperty", "transactionPrefixForCoverNoteNo");				
					covernote_no = HMSUtil.generateTransactionSequence(map, session, hbt);
					referralPatientDetails.getReferralPatientHeader().setCovernoteNumber(covernote_no);
					referralPatientDetails.getReferralPatientHeader().setCovernoteDate(new Date());
					referralPatientDetails.getReferralPatientHeader().setApprovalStatus("WHD");	
					referralPatientDetails.getReferralPatientHeader().setAdminApprovalDate(new Date());
					referralPatientDetails.getReferralPatientHeader().setAdminApprovalTime(box.getString(LAST_CHANGED_TIME));;
					
					referralPatientDetails.getReferralPatientHeader().setAdminBillAmt(new BigDecimal(adminBillAmt).setScale(2, BigDecimal.ROUND_HALF_UP));
					referralPatientDetails.getReferralPatientHeader().setTotalBillAmt(new BigDecimal(totalBillAmt).setScale(2, BigDecimal.ROUND_HALF_UP));
					map.put("referral_patient_details_id", referralPatientDetailsId);
					map.put("referral_patient_header_id", referralPatientDetails.getReferralPatientHeader().getId());
				}
				
			}*/
			
		    hbt.saveOrUpdate(referralPatientBilling);
		    
		    if(box.get("saveAs")!= null && box.get("saveAs").equals("draft")){
			if(box.get("clarri_bill"+i)!=null && box.getString("clarri_bill"+i).equalsIgnoreCase("y"))
			{
				
			if(clarificationFlag)
			{
				map.put("tableObjectName", "ReferralClarrificationHeader");			
				map.put("isHospitalWise", "y");
				map.put("hospitalId", box.getInt("hospitalId"));
				map.put("isYearly", "n");			
				map.put("isMonthly", "n");
				map.put("isPrefix", "y");
				map.put("transactionPrefixProperty", "transactionPrefixForReferralClarrification");
				
				clf_no = HMSUtil.generateTransactionSequence(map, session, hbt);
				
				referralClarrificationHeader.setClarificationNo(clf_no);
				referralClarrificationHeader.setReferralHeader(referralPatientDetails.getReferralPatientHeader());
				referralClarrificationHeader.setClarificationRemarks(box.getString("clarri_remarks"));
				referralClarrificationHeader.setGenerationDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
				referralClarrificationHeader.setGeneratedBy(user);
				referralClarrificationHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
				referralClarrificationHeader.setLastChgBy(user);
				referralClarrificationHeader.setLastChgTime(box.getString(CHANGED_TIME));
				hbt.save(referralClarrificationHeader);
				clarificationFlag = false;
				map.put("referralClarrificationHeaderId", referralClarrificationHeader.getId());
			}
				
			referralClarificationDetail.setClarificationHeader(referralClarrificationHeader);
			referralClarificationDetail.setReferralBilling(referralPatientBilling);
			hbt.save(referralClarificationDetail);
		}
			int  clarriCount = box.getInt("clarriCount");
			for(int j =1; j<=clarriCount; j++)
			{
				
				if(box.get("impanel_remarks"+j)!= null && !box.get("impanel_remarks"+j).trim().equals("")){
					ReferralClarrificationHeader rcch = new ReferralClarrificationHeader();
					rcch = (ReferralClarrificationHeader)session.load(ReferralClarrificationHeader.class, box.getInt("clarriHeaderId"+j));
					rcch.setImpaneledRemarks(box.get("impanel_remarks"+j));
					hbt.update(rcch);
					
				}
			}
			
		   }
			
		    hbt.flush(); 
		   }}
			succesfullyAdded = true;
			tx.commit();
				
			
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
			
		}     
		finally
		{
			session.close();
			
		}
		map.put("succesfullyAdded", succesfullyAdded);	
		map.put("covernote_no", covernote_no);
		

		return map;
	}

	@Override
	public String checkBillNo(Box box) {
		
		Session session = (Session) getSession();		
		int toHospital = 0;
		String isDuplicate = "true";
		if (box.getInt("toHospital") != 0)
			toHospital = box.getInt("toHospital");	
				System.out.println("box.getString()"+box.getString("bill_no"));
				System.out.println("hospitalId"+toHospital);
		
		List<ReferralPatientBilling> rpbList = new ArrayList<ReferralPatientBilling>();
		
		 rpbList = session.createCriteria(ReferralPatientBilling.class)
				.createAlias("ReferralDetails", "rd")
				.createAlias("rd.ReferralPatientHeader", "rh")
				.add(Restrictions.eq("BillNo", box.getString("bill_no").trim()))				
				.add(Restrictions.eq("rh.ToHospital.Id", toHospital))
				.list();
			
        if(rpbList.size()==0)
        {
        	isDuplicate="false";
        }
		return isDuplicate;

	}

	
	@SuppressWarnings("unchecked")
	public synchronized Map<String, Object> generateExtension(
			Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean succesfullyAdded = false;
	
	
		Session session = (Session) getSession();
		Users user = new Users();
		user.setId(box.getInt("userId"));
		MasHospital hospital = new MasHospital();
		hospital.setId(box.getInt("hospitalId"));
		
		
		int referralPatientHeaderId =0;	
		int employeeId =0;	
		String message = "";
		
		if(box.get("referralPatientHeaderId")!= null){
			referralPatientHeaderId = (Integer)box.getInt("referralPatientHeaderId");
		}
		if(box.get("employeeId")!= null){
			employeeId = (Integer)box.getInt("employeeId");
		}
		
	
	
		Transaction tx = null;
		
	
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			session.clear();
			hbt.clear();
			
			
			
			/*referralPatientBilling = (ReferralPatientBilling)session.load(ReferralPatientBilling.class, referralPatientBillingId);*/
		
		    
		 
			   ReferralPatientHeader referralPatientHeader = new ReferralPatientHeader();
			   
				   referralPatientHeaderId = box.getInt("referralPatientHeaderId");
				   referralPatientHeader = (ReferralPatientHeader)session.load(ReferralPatientHeader.class, referralPatientHeaderId);
				   System.out.println("referralPatientHeaderId"+referralPatientHeaderId);
				 /*  if(referralPatientHeader.getExtensionStatus()!=null && (referralPatientHeader.getExtensionStatus().equalsIgnoreCase("WDA") || referralPatientHeader.getExtensionStatus().equalsIgnoreCase("DA")))
				   {
					   message = "Extension already generated";
				   }*/
				   if(referralPatientHeader.getExtensionStatus()!=null && referralPatientHeader.getExtensionStatus().equalsIgnoreCase("DA"))
				   {
					   message = "Extension Already Approved By Doctor";
				   }
				   else
				   {
					   MasEmployee doctor = new MasEmployee();
					   doctor.setId(employeeId);
					   referralPatientHeader.setDoctor(doctor);
					   referralPatientHeader.setExtensionStatus("WDA");	
				   }
				   			
			   
			
		    hbt.update(referralPatientHeader);		    
		    hbt.flush(); 
		   
			succesfullyAdded = true;
			tx.commit();
				
			
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
			
		}     
		finally
		{
			session.close();
			
		}
		map.put("succesfullyAdded", succesfullyAdded);	
		map.put("message", message);
		

		return map;
	}
	
	@SuppressWarnings("unchecked")
	public synchronized Map<String, Object> updateReferralDetails(
			Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean succesfullyAdded = false;
	
	
		Session session = (Session) getSession();
		Users user = new Users();
		user.setId(box.getInt("userId"));
		MasHospital hospital = new MasHospital();
		hospital.setId(box.getInt("hospitalId"));
		
		
		int referralPatientDetailsId =0;	

		String message = "";
		
		if(box.get("referralPatientDetailsId")!= null){
			referralPatientDetailsId = box.getInt("referralPatientDetailsId");
		}
		
		
	
	
		Transaction tx = null;
		
	
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			session.clear();
			hbt.clear();
			
		
		 
			   ReferralPatientDetails referralPatientDetails = (ReferralPatientDetails)hbt.load(ReferralPatientDetails.class, referralPatientDetailsId);
			   OpdPatientDetails opdPatientDetails = referralPatientDetails.getReferralPatientHeader().getOpdPatientDetails();
			 
			   
			   if(box.get("empanelledHospitalId")!=null && !box.getString("empanelledHospitalId").trim().equals(""))
			   {
				   MasImpanneledHospital impanelledHospital = new MasImpanneledHospital();
				   impanelledHospital.setId(box.getInt("empanelledHospitalId")); 
				   referralPatientDetails.getReferralPatientHeader().setToHospital(impanelledHospital);
				   opdPatientDetails.setImpanneledHospital(impanelledHospital);
			   }
			   if(box.get("referredFor")!=null && !box.getString("referredFor").trim().equals(""))
			   {
				   referralPatientDetails.setReferredFor(box.getString("referredFor").trim());
				   opdPatientDetails.setReferredFor(box.getString("referredFor").trim());
				   
			   }
			   if(box.get("treatmentType")!=null && !box.getString("treatmentType").trim().equals(""))
			   {
				   referralPatientDetails.setTreatmentType(box.getString("treatmentType").trim());
				   opdPatientDetails.setReferralTreatmentType(box.getString("treatmentType").trim());
				   if(box.getString("treatmentType").trim().equals("2") && box.getString("wardId")!=null && !box.getString("wardId").equals("0"))
				   {
					   MasWardImpanneledHospital mwih = new MasWardImpanneledHospital();
					   mwih.setId(Integer.parseInt(box.getString("wardId"))); 
					   referralPatientDetails.setWard(mwih);
				   }
				   
			   }
			   if(box.get("doctorNote")!=null && !box.getString("doctorNote").trim().equals(""))
			   {
				   referralPatientDetails.setDoctorRemarks(box.getString("doctorNote").trim());
				   opdPatientDetails.setReferralNotes(box.getString("doctorNote").trim());
				 
			   }
			   if(box.get("note")!=null && !box.getString("note").trim().equals(""))
			   {
				   referralPatientDetails.setReferralNote(box.getString("note").trim());
				
			   }
			   if(box.get("validityPeriod")!=null && !box.getString("validityPeriod").trim().equals(""))
			   {
				   referralPatientDetails.setLetterValidityPeriod(box.getInt("validityPeriod"));
				   opdPatientDetails.setReferralDays(box.getInt("validityPeriod"));
				  
				   
			   }
			   if(box.get("subject")!=null && !box.getString("subject").trim().equals(""))
			   {
				   referralPatientDetails.setSubject(box.getString("subject"));
				  
			   }
			   referralPatientDetails.setLastChgDate((HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE))));
			   referralPatientDetails.setLastChgTime(box.get(CHANGED_TIME));
			   referralPatientDetails.setLastChgBy(user);
			   
			   
			hbt.update(opdPatientDetails);	   
			hbt.update(referralPatientDetails);		    	    
		    hbt.flush(); 
		   
			succesfullyAdded = true;
			tx.commit();
			message = "Referral Details Updated Successfully";	
			
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
			
			message = "Some problem Occured! Try Again";	
		}     
		finally
		{
			session.close();
			
		}
		map.put("succesfullyAdded", succesfullyAdded);	
		map.put("message", message);
		

		return map;
	}
	
	
	@SuppressWarnings("unchecked")
	public synchronized Map<String, Object> submitInvoicePageForHRDivision(
			Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean succesfullyAdded = false;
	
	
		Session session = (Session) getSession();
		Users user = new Users();
		user.setId(box.getInt("userId"));
		MasHospital hospital = new MasHospital();
		hospital.setId(box.getInt("hospitalId"));
		
		int hinId =0;
		int opdPatientDetailsId =0;
		int divCountBilling =0;
		int referralPatientDetailsId = 0;
		int referralPatientHeaderId = 0;
		double deductionFS=0;
		int impanelled_bill = 0;
		int referralBillingId = 0;
		int hal_bill = 0;
		String hr_remarks = "";	
		String flag ="";
		
		ReferralPatientDetails referralPatientDetails = new ReferralPatientDetails();
        Patient patient = new Patient();
        OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
        ReferralPatientHeader referralPatientHeader = new ReferralPatientHeader();
        
       
		/*if(box.get("hinId")!= null){
			hinId = (Integer)box.getInt("hinId");
		}
		
		if(box.get("opdPatientDetailsId")!= null){
			opdPatientDetailsId = (Integer)box.getInt("opdPatientDetailsId");
		}*/
		
	/*	if(box.get("referralPatientDetailsId")!= null){
			referralPatientDetailsId = box.getInt("referralPatientDetailsId");
		}*/
		
		/*if(box.get("impanelled_bill")!= null){
			impanelled_bill = box.getInt("impanelled_bill");
		}
		
		if(box.get("hal_bill")!= null){
			hal_bill = box.getInt("hal_bill");
		}*/
        if(box.get("flag")!= null){
			flag = box.getString("flag");
		}
        
        if(box.get("referralPatientHeaderId")!= null){
        	referralPatientHeaderId = box.getInt("referralPatientHeaderId");
		}
		
        if(box.get("hr_remarks")!= null){
			hr_remarks = box.getString("hr_remarks");
		}
        
        if(box.get("deductionFS")!= null){
			deductionFS = box.getDouble("deductionFS");
			
		}
	
		Transaction tx = null;
		
	   
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			session.clear();
			hbt.clear();
			
			if(box.get("divCountBilling")!= null){
				divCountBilling = box.getInt("divCountBilling");
			}
			referralPatientHeader = (ReferralPatientHeader)session.load(ReferralPatientHeader.class, referralPatientHeaderId);
			referralPatientHeader.setDeductionFromSalary(new BigDecimal(deductionFS).setScale(2, BigDecimal.ROUND_HALF_UP));
			/*referralPatientDetails = (ReferralPatientDetails)session.load(ReferralPatientDetails.class, referralPatientDetailsId);*/
		
			 for(int i = 1; i<=divCountBilling; i++)
			   {	
				 referralBillingId =0; 
				  
				   ReferralPatientBilling referralPatientBilling = new ReferralPatientBilling();
				   referralPatientBilling = (ReferralPatientBilling)session.load(ReferralPatientBilling.class, box.getInt("referralBillingId"+i));
				 /*  if(box.get("referralBillingId"+i)!= null && box.getInt("referralBillingId"+i)!=0){
					   referralBillingId = box.getInt("referralBillingId"+i);
					   referralPatientBilling.setId(referralBillingId);
					   System.out.println("referralBillingId"+referralBillingId);
					}*/
				 
				
					
					
					
				
				referralPatientBilling.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
				referralPatientBilling.setLastChgTime(box.getString(CHANGED_TIME));
				referralPatientBilling.setLastChgBy(user);				
				/*referralPatientBilling.setHrRemarks(hr_remarks);*/
				if(flag.equals("rejected"))
				{
					referralPatientBilling.setApprovalStatus("RHD");
				}
				else
				{
					referralPatientBilling.setApprovalStatus("WNS");
				}
				
				if(i==divCountBilling)
				{
					if(flag.equals("rejected"))
					{
						referralPatientHeader.setApprovalStatus("RHD");
					}
					else
					{
						referralPatientHeader.setApprovalStatus("WNS");
						referralPatientHeader.setHrApprovalDate(new Date());
						referralPatientHeader.setHrApprovalTime(box.getString(LAST_CHANGED_TIME));
					}
					
					
					referralPatientHeader.setHrRemarks(hr_remarks);
				}
				
				
				
			    hbt.update(referralPatientBilling);		    
			    hbt.flush(); 
			   }
			   
			succesfullyAdded = true;
			tx.commit();
				
			
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
			
		}     
		finally
		{
			session.close();
			
		}
		map.put("succesfullyAdded", succesfullyAdded);	

		return map;
	}
	
	@SuppressWarnings("unchecked")
	public synchronized Map<String, Object> submitInvoicePageForGM(
			Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean succesfullyAdded = false;
	
	
		Session session = (Session) getSession();
		Users user = new Users();
		user.setId(box.getInt("userId"));
		MasHospital hospital = new MasHospital();
		hospital.setId(box.getInt("hospitalId"));
		
		int hinId =0;
		int opdPatientDetailsId =0;
		int referralPatientDetailsId = 0;
		int divCountBilling =0;
		int referralBillingId =0;		
		int referralPatientHeaderId = 0;
		int impanelled_bill = 0;
		int hal_bill = 0;
		String gm_remarks = "";	
		
		ReferralPatientDetails referralPatientDetails = new ReferralPatientDetails();
        Patient patient = new Patient();
        OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
        ReferralPatientHeader referralPatientHeader = new ReferralPatientHeader();
       
		/*if(box.get("hinId")!= null){
			hinId = (Integer)box.getInt("hinId");
		}
		
		if(box.get("opdPatientDetailsId")!= null){
			opdPatientDetailsId = (Integer)box.getInt("opdPatientDetailsId");
		}
		
		if(box.get("referralPatientDetailsId")!= null){
			referralPatientDetailsId = box.getInt("referralPatientDetailsId");
		}
		
		if(box.get("impanelled_bill")!= null){
			impanelled_bill = box.getInt("impanelled_bill");
		}
		
		if(box.get("hal_bill")!= null){
			hal_bill = box.getInt("hal_bill");
		}*/
		
		
		
		 if(box.get("referralPatientHeaderId")!= null){
	        	referralPatientHeaderId = box.getInt("referralPatientHeaderId");
			}
			if(box.get("gm_remarks")!= null){
				gm_remarks = box.getString("gm_remarks");
			}
	
		Transaction tx = null;
		
	
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			session.clear();
			hbt.clear();
			
			
			if(box.get("divCountBilling")!= null){
				divCountBilling = box.getInt("divCountBilling");
			}
			referralPatientHeader = (ReferralPatientHeader)session.load(ReferralPatientHeader.class, referralPatientHeaderId);
			/*referralPatientDetails = (ReferralPatientDetails)session.load(ReferralPatientDetails.class, referralPatientDetailsId);*/
		
			 for(int i = 1; i<=divCountBilling; i++)
			   {	
				 referralBillingId =0; 
				
				   ReferralPatientBilling referralPatientBilling = new ReferralPatientBilling();
				   referralPatientBilling = (ReferralPatientBilling)session.load(ReferralPatientBilling.class, box.getInt("referralBillingId"+i));
				  /* if(box.get("referralBillingId"+i)!= null && box.getInt("referralBillingId"+i)!=0){
					   referralBillingId = box.getInt("referralBillingId"+i);
					   referralPatientBilling.setId(referralBillingId);
					   System.out.println("referralBillingId"+referralBillingId);
					}*/
				 
				
					
				
					
				
				referralPatientBilling.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
				referralPatientBilling.setLastChgTime(box.getString(CHANGED_TIME));
				referralPatientBilling.setLastChgBy(user);				
				referralPatientBilling.setGmRemarks(gm_remarks);			
				referralPatientBilling.setApprovalStatus("DLG");
				if(i==divCountBilling)
				{
					referralPatientHeader.setApprovalStatus("DLG");
					referralPatientHeader.setGmApprovalDate(new Date());
					referralPatientHeader.setGmApprovalTime(box.getString(LAST_CHANGED_TIME));
					referralPatientHeader.setGmRemarks(gm_remarks);
				}
				
				
				
			    hbt.update(referralPatientBilling);		    
			    hbt.flush(); 
			   }
			succesfullyAdded = true;
			tx.commit();
				
			
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
			
		}     
		finally
		{
			session.close();
			
		}
		map.put("succesfullyAdded", succesfullyAdded);	

		return map;
	}
	
	@SuppressWarnings("unchecked")
	public synchronized Map<String, Object> generateDivisionalApprovalLetter(
			Box box, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean succesfullyAdded = false;
	
	
		Session session = (Session) getSession();
		Users user = new Users();
		user.setId(box.getInt("userId"));
		MasHospital hospital = new MasHospital();
		hospital.setId(box.getInt("hospitalId"));
		
		int hinId =0;
		int opdPatientDetailsId =0;
		int referralPatientDetailsId = 0;
		int checkboxCount =0;
		int referralBillingId =0;
		/*String referral_patient_header_id ="";*/
		String consolidateNumber = "";
		
		Transaction tx = null;
		
	
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			session.clear();
			hbt.clear();
			
			
			
			if(box.get("checkboxCount")!= null){
				checkboxCount = box.getInt("checkboxCount");
			}
			
			
		
			
			map.put("tableObjectName", "ReferralPatientHeader");			
			map.put("isHospitalWise", "y");
			map.put("hospitalId", box.getInt("hospitalId")); 
			map.put("isDivisionWise", "y");
			map.put("divisionId", box.getInt("divisionId"));
			map.put("isYearly", "n");			
			map.put("isMonthly", "n");
			map.put("isPrefix", "y");
			map.put("transactionPrefixProperty", "transactionPrefixForConsolidatedNo");
			
			consolidateNumber = HMSUtil.generateTransactionSequence(map, session, hbt);
			
			List headerIds = new ArrayList();
			 for(int i = 0; i<checkboxCount; i++)
			   {	
				
				if(box.get("headerId"+i)!=null && box.getInt("headerId"+i)!=0)
				{
					   ReferralPatientHeader referralPatientHeader = (ReferralPatientHeader)session.load(ReferralPatientHeader.class, box.getInt("headerId"+i));
					   
					 
					
					   referralPatientHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
					   referralPatientHeader.setLastChgTime(box.getString(CHANGED_TIME));
					   referralPatientHeader.setLastChgBy(user);				
					
					
						referralPatientHeader.setApprovalStatus("CBG");
						referralPatientHeader.setConsolidateNumber(consolidateNumber);
						referralPatientHeader.setConsolidateDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
						
					
						
						
					    /*referral_patient_header_id+=","+box.getInt("headerId"+i); */
						 
					
				    hbt.update(referralPatientHeader);		    
				    hbt.flush(); 
				    headerIds.add(box.getInt("headerId"+i));
				}
				
				
				
			   }
			 
			 System.out.println("headerIds"+headerIds);
			 //code starts for generating excel
				List<Object[]> referralPatientBillingList = new ArrayList<Object[]>();	
				Object[] header = {"S.No.", "Div_Code", "DIV_NAME", "Cheque No", "Cheque Date", "CHEQUE AMT", "HOSPITAL_CODE", "Hospital", "Bill No", "Bill Date", "Referral Number", "HAL_REF_DATE", "Amount", "TAX AMT", "CHEQUE AMT", "PB No", "EMP_NAME", "PATIENT_NAME", "RELATIONSHIP", "ERP POSTING DATE"};
				
				referralPatientBillingList.add(header);
				
				List<List<Object[]>> sheetList = new ArrayList<List<Object[]>>();					
						
			
				int headerId = box.getInt("headerId");				
				
				referralPatientBillingList.addAll(session.createCriteria(ReferralPatientBilling.class)
						.createAlias("ReferralDetails", "dt")
						.createAlias("dt.ReferralPatientHeader", "h")						
						.createAlias("h.ToHospital", "th")
						.createAlias("h.Hin", "p")
						.createAlias("p.Employee", "e")
						.createAlias("e.Division", "d")
						.createAlias("p.Relation", "r")	
						.setProjection(Projections.projectionList()
						.add(Projections.property("Id"))
						.add(Projections.property("d.DivisionCode"))
		                .add(Projections.property("d.DivisionName"))
		                .add(Projections.property("CheckNo"))
		                .add(Projections.property("CheckDate"))
		                .add(Projections.property("CheckAmount"))
		                .add(Projections.property("th.ImpanneledHospitalCode"))
		                .add(Projections.property("th.ImpanneledHospitalName"))		                
		                .add(Projections.property("BillNo"))
		                .add(Projections.property("BillDate"))
		                .add(Projections.property("dt.ReferralNo"))
		                .add(Projections.property("dt.ReferralExtensionDate"))
		                .add(Projections.property("AdminBillAmt"))
		                .add(Projections.property("TaxAmount"))		               
		                .add(Projections.property("CheckAmount"))
		                .add(Projections.property("p.ServiceNo"))
		                .add(Projections.property("e.FirstName"))
		                .add(Projections.property("p.PFirstName"))
		                .add(Projections.property("r.RelationName")))
		                /*.add(Projections.property("CheckDate"))) */
		                .add(Restrictions.in("h.Id", headerIds))
		                .list());
				
				
					
				
					for(int i= 1; i<referralPatientBillingList.size(); i++)
				{
						Object[] rpb = referralPatientBillingList.get(i);
						if(rpb[4]!=null && !rpb[4].toString().trim().equals(""))
						{
							rpb[4] = HMSUtil.convertDateToStringFormat((Date)rpb[4], "dd-MM-YYYY");		
						}
						
						if(rpb[9]!=null && !rpb[9].toString().trim().equals(""))
						{
							rpb[9] = HMSUtil.convertDateToStringFormat((Date)rpb[9], "dd-MM-YYYY");
						}
						if(rpb[11]!=null && !rpb[11].toString().trim().equals(""))
						{
							rpb[11] = HMSUtil.convertDateToStringFormat((Date)rpb[11], "dd-MM-YYYY");
						}
						
						/*if(rpb[19]!=null && !rpb[19].toString().trim().equals(""))
						{
							rpb[19] = HMSUtil.convertDateToStringFormat((Date)rpb[19], "dd-MM-YYYY");
						}*/
					
				}
					
			            sheetList.add(referralPatientBillingList);
			         
				       	System.out.println("referralPatientBillingList"+referralPatientBillingList.size());
				        map.put("fileName", "ConsolidationOfBills");
				        List<String> sheetNames = new ArrayList<String>();
				        sheetNames.add("Bills");
					HMSUtil.excelWriter(sheetList, map, response, sheetNames);						
				//code ends for generating excel
					
			succesfullyAdded = true;
			tx.commit();
				
			
		} catch (Exception e) {
			e.printStackTrace();
			succesfullyAdded = false;
			if(tx!=null)
				tx.rollback();
			
		}     
		finally
		{
			session.close();
			
		}
		map.put("succesfullyAdded", succesfullyAdded);
		map.put("consolidateNumber", consolidateNumber);
		/*map.put("referral_patient_header_id", referral_patient_header_id);	*/

		return map;
	}
	
	
	@SuppressWarnings("unchecked")
	public synchronized Map<String, Object> generateReferralExcelReport(
			Box box, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean succesfullyAdded = false;
	
	
		Session session = (Session) getSession();
		Users user = new Users();
		user.setId(box.getInt("userId"));
		MasHospital hospital = new MasHospital();
		hospital.setId(box.getInt("hospitalId"));
		int hinId =0;
		int opdPatientDetailsId =0;
		int referralPatientDetailsId = 0;
		int checkboxCount =0;
		int referralBillingId =0;
		/*String referral_patient_header_id ="";*/
		String consolidateNumber = "";
		
		Transaction tx = null;
		
	
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			session.clear();
			hbt.clear();
			
			
			
			if(box.get("checkboxCount")!= null){
				checkboxCount = box.getInt("checkboxCount");
			}
			Date fromDate = null;
			Date toDate = null;
			if (box.get(FROM_DATE) != null
					&& !(box.getString(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(box
						.getString(FROM_DATE));
							
			}
			if (box.get(TO_DATE) != null
					&& !(box.getString(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(box
						.getString(TO_DATE));
								
			
			}
			
			int impHospitalId = 0;
	        int divisionId = 0;		
	    	int doctorId = 0;
	        int departmentId = 0;		
		
	    	if (box.get("doctorId") != null)
				doctorId = box.getInt("doctorId");
			if (box.get("departmentId") != null)
				departmentId = box.getInt("departmentId");
			
			if (box.get("impHospitalId") != null)
				impHospitalId = box.getInt("impHospitalId");
			if (box.get("divisionId") != null)
				divisionId = box.getInt("divisionId");	
			
		
		
			 
			 
			 //code starts for generating excel
				List<Object[]> referralPatientBillingList = new ArrayList<Object[]>();	
				Object[] header = {"S.No.", "P.B. NO", "EMPLOYEE NAME", "RELATIONSHIP", "PATIENT NAME", "DEPT", "HOSPITAL NAME", "REFERRAL DATE", "TREATMENT TYPE", "DIVISION", "DIAGNOSIS", "DOCTOR NAME", "REFERRAL No.", "SPECIAL APPROVAL", "REFERRED FOR"};
				
				referralPatientBillingList.add(header);
				
				List<List<Object[]>> sheetList = new ArrayList<List<Object[]>>();					
						
			
				int headerId = box.getInt("headerId");		
				
				Criteria cr = session.createCriteria(ReferralPatientDetails.class, "dt")						
				.createAlias("dt.ReferralPatientHeader", "h")						
				.createAlias("h.Hin", "p")
				.createAlias("p.Employee", "e")
				.createAlias("e.Division", "d")
				.createAlias("p.Relation", "r")	
				.createAlias("h.OpdPatientDetails", "opd")
				.createAlias("opd.Visit", "v")
				.createAlias("v.Department", "de")
				.createAlias("h.ToHospital", "toH")
				.createAlias("v.Doctor", "doc")						
				.setProjection(Projections.projectionList()
				.add(Projections.property("Id"))
				.add(Projections.property("p.ServiceNo"))
                .add(Projections.property("e.FirstName"))
                .add(Projections.property("r.RelationName"))
                .add(Projections.property("p.PFirstName"))
                .add(Projections.property("de.DepartmentName"))
                .add(Projections.property("toH.ImpanneledHospitalName"))	
                .add(Projections.property("dt.ReferralExtensionDate"))
                .add(Projections.property("dt.TreatmentType"))
                .add(Projections.property("d.DivisionName"))		                	                
                .add(Projections.property("opd.InitialDiagnosis"))
                .add(Projections.property("doc.FirstName"))
                .add(Projections.property("dt.ReferralNo"))		                
                .add(Projections.property("opd.alb"))
                .add(Projections.property("dt.ReferredFor")))		                
                /*.add(Projections.property("BillNo"))
                .add(Projections.property("BillDate"))
                .add(Projections.property("dt.ReferralNo"))
                .add(Projections.property("dt.ReferralExtensionDate"))
                .add(Projections.property("AdminBillAmt"))
                .add(Projections.property("TaxAmount"))		               
                .add(Projections.property("CheckAmount"))
                .add(Projections.property("p.ServiceNo"))*/	
               /* .add(Restrictions.eq("h.ApprovalStatus", "C").ignoreCase())*/
                .add(Restrictions.between("dt.ReferralExtensionDate", fromDate, toDate));
				
				if (doctorId != 0 ) {					
					cr = cr.add(Restrictions.eq("doc.Id", doctorId));
				}
				
				if (departmentId != 0 ) {					
					cr = cr.add(Restrictions.eq("de.Id", departmentId));
				}
				
					if (impHospitalId != 0 ) {						
						cr = cr.add(Restrictions.eq("toH.Id", impHospitalId));
					}
					
					if (divisionId != 0 ) {						
						cr = cr.add(Restrictions.eq("d.Id", divisionId));
					}
                
				
				referralPatientBillingList.addAll(cr.list());
			            sheetList.add(referralPatientBillingList);
			         
			           
			            for(int i=1; i<referralPatientBillingList.size(); i++)
			            {
			            	
			            	referralPatientBillingList.get(i)[0]=i;
			            	if(referralPatientBillingList.get(i)[8].equals("2"))
			            	{
			            		referralPatientBillingList.get(i)[8]="Admission";
			            	}
			            	else
			            	{
			            		referralPatientBillingList.get(i)[8]="OPD";
			            	}
			            	if(referralPatientBillingList.get(i)[7]!=null && !referralPatientBillingList.get(i)[7].toString().trim().equals(""))
			            	{
			            		referralPatientBillingList.get(i)[7]=HMSUtil.convertDateToStringFormat((Date)referralPatientBillingList.get(i)[7], "dd-MM-YYYY");
			            	}
			            	
			            	referralPatientBillingList.get(i)[13]="No";
			            }
				       	System.out.println("referralPatientBillingList"+referralPatientBillingList.size());
				        map.put("fileName", "Excel Report");
				        List<String> sheetNames = new ArrayList<String>();
				        sheetNames.add("Referral Details");
					HMSUtil.excelWriter(sheetList, map, response, sheetNames);						
				//code ends for generating excel
					
			succesfullyAdded = true;
			tx.commit();
				
			
		} catch (Exception e) {
			e.printStackTrace();
			succesfullyAdded = false;
			if(tx!=null)
				tx.rollback();
			
		}     
		finally
		{
			session.close();
			
		}
		map.put("succesfullyAdded", succesfullyAdded);
		map.put("consolidateNumber", consolidateNumber);
		/*map.put("referral_patient_header_id", referral_patient_header_id);	*/

		return map;
	}
	
	

	@SuppressWarnings("unchecked")
	public synchronized Map<String, Object> generateReferralExcelBillingReport(
			Box box, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean succesfullyAdded = false;
	
	
		Session session = (Session) getSession();
		Users user = new Users();
		user.setId(box.getInt("userId"));
		MasHospital hospital = new MasHospital();
		hospital.setId(box.getInt("hospitalId"));
		int hinId =0;
		int opdPatientDetailsId =0;
		int referralPatientDetailsId = 0;
		int checkboxCount =0;
		int referralBillingId =0;
		/*String referral_patient_header_id ="";*/
		String consolidateNumber = "";
		
		Transaction tx = null;
		
	
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			session.clear();
			hbt.clear();
			
			
			
			if(box.get("checkboxCount")!= null){
				checkboxCount = box.getInt("checkboxCount");
			}
			Date fromDate = null;
			Date toDate = null;
			if (box.get(FROM_DATE) != null
					&& !(box.getString(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(box
						.getString(FROM_DATE));
							
			}
			if (box.get(TO_DATE) != null
					&& !(box.getString(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(box
						.getString(TO_DATE));
								
			
			}
			
			int impHospitalId = 0;
	        int divisionId = 0;		
	    	int doctorId = 0;
	        int departmentId = 0;		
		
	    	if (box.get("doctorId") != null)
				doctorId = box.getInt("doctorId");
			if (box.get("departmentId") != null)
				departmentId = box.getInt("departmentId");
			
			if (box.get("impHospitalId") != null)
				impHospitalId = box.getInt("impHospitalId");
			if (box.get("divisionId") != null)
				divisionId = box.getInt("divisionId");	
			
		
		
			 
			 
			 //code starts for generating excel
				List<Object[]> referralPatientBillingList = new ArrayList<Object[]>();	
				Object[] header = {"S.No.", "P.B. NO", "EMPLOYEE NAME", "RELATIONSHIP", "PATIENT NAME", "DEPT", "HOSPITAL NAME", "REFERRAL DATE", "TREATMENT TYPE", "DIVISION", "DOCTOR", "REFERRAL No.", "COVERING LETTER NO.", "BILL NO.", "BILL DATE", "BILL AMOUNT", "TAX DEDUCTED", "FINAL AMOUNT PAYABLE", "CHEQUE NO./UTR NO.", "CHEQUE DATE"};
				
				referralPatientBillingList.add(header);
				
				List<List<Object[]>> sheetList = new ArrayList<List<Object[]>>();					
						
			
				int headerId = box.getInt("headerId");		
				
				Criteria cr = session.createCriteria(ReferralPatientBilling.class)
				.createAlias("ReferralDetails", "dt")
				.createAlias("dt.ReferralPatientHeader", "h")						
				.createAlias("h.Hin", "p")
				.createAlias("p.Employee", "e")
				.createAlias("e.Division", "d")
				.createAlias("p.Relation", "r")	
				.createAlias("h.OpdPatientDetails", "opd")
				.createAlias("opd.Visit", "v")
				.createAlias("v.Department", "de")
				.createAlias("h.ToHospital", "toH")
				.createAlias("v.Doctor", "doc")						
				.setProjection(Projections.projectionList()
				.add(Projections.property("Id"))
				.add(Projections.property("p.ServiceNo"))
                .add(Projections.property("e.FirstName"))
                .add(Projections.property("r.RelationName"))
                .add(Projections.property("p.PFirstName"))
                .add(Projections.property("de.DepartmentName"))
                .add(Projections.property("toH.ImpanneledHospitalName"))	
                .add(Projections.property("dt.ReferralExtensionDate"))
                .add(Projections.property("dt.TreatmentType"))
                .add(Projections.property("d.DivisionName"))    
                .add(Projections.property("doc.FirstName"))
                .add(Projections.property("dt.ReferralNo"))		                
                .add(Projections.property("h.CovernoteNumber"))
                .add(Projections.property("BillNo"))
                .add(Projections.property("BillDate"))
                .add(Projections.property("AdminBillAmt"))
                .add(Projections.property("TaxAmount"))
                .add(Projections.property("NetAmount"))
                .add(Projections.property("CheckNo"))
                .add(Projections.property("CheckDate")))		                
                /*.add(Projections.property("BillNo"))
                .add(Projections.property("BillDate"))
                .add(Projections.property("dt.ReferralNo"))
                .add(Projections.property("dt.ReferralExtensionDate"))
                .add(Projections.property("AdminBillAmt"))
                .add(Projections.property("TaxAmount"))		               
                .add(Projections.property("CheckAmount"))
                .add(Projections.property("p.ServiceNo"))*/	
                .add(Restrictions.eq("h.ApprovalStatus", "C").ignoreCase())
                .add(Restrictions.between("dt.ReferralExtensionDate", fromDate, toDate));
				
				if (doctorId != 0 ) {					
					cr = cr.add(Restrictions.eq("doc.Id", doctorId));
				}
				
				if (departmentId != 0 ) {					
					cr = cr.add(Restrictions.eq("de.Id", departmentId));
				}
				
					if (impHospitalId != 0 ) {						
						cr = cr.add(Restrictions.eq("toH.Id", impHospitalId));
					}
					
					if (divisionId != 0 ) {						
						cr = cr.add(Restrictions.eq("d.Id", divisionId));
					}
                
				
				referralPatientBillingList.addAll(cr.list());
			            sheetList.add(referralPatientBillingList);
			         
			           
			            for(int i=1; i<referralPatientBillingList.size(); i++)
			            {
			            	
			            	referralPatientBillingList.get(i)[0]=i;
			            	if(referralPatientBillingList.get(i)[8].equals("2"))
			            	{
			            		referralPatientBillingList.get(i)[8]="Admission";
			            	}
			            	else
			            	{
			            		referralPatientBillingList.get(i)[8]="OPD";
			            	}
			            	if(referralPatientBillingList.get(i)[7]!=null && !referralPatientBillingList.get(i)[7].toString().trim().equals(""))
			            	{
			            		referralPatientBillingList.get(i)[7]=HMSUtil.convertDateToStringFormat((Date)referralPatientBillingList.get(i)[7], "dd-MM-YYYY");
			            	}
			            	if(referralPatientBillingList.get(i)[14]!=null && !referralPatientBillingList.get(i)[14].toString().trim().equals(""))
			            	{
			            		referralPatientBillingList.get(i)[14]=HMSUtil.convertDateToStringFormat((Date)referralPatientBillingList.get(i)[14], "dd-MM-YYYY");
			            	}
			            	if(referralPatientBillingList.get(i)[19]!=null && !referralPatientBillingList.get(i)[19].toString().trim().equals(""))
			            	{
			            		referralPatientBillingList.get(i)[19]=HMSUtil.convertDateToStringFormat((Date)referralPatientBillingList.get(i)[19], "dd-MM-YYYY");
			            	}
			           
			            	
			            }
				       	System.out.println("referralPatientBillingList"+referralPatientBillingList.size());
				        map.put("fileName", "Excel Report");
				        List<String> sheetNames = new ArrayList<String>();
				        sheetNames.add("Billing Details");
					HMSUtil.excelWriter(sheetList, map, response, sheetNames);						
				//code ends for generating excel
					
			succesfullyAdded = true;
			tx.commit();
				
			
		} catch (Exception e) {
			e.printStackTrace();
			succesfullyAdded = false;
			if(tx!=null)
				tx.rollback();
			
		}     
		finally
		{
			session.close();
			
		}
		map.put("succesfullyAdded", succesfullyAdded);
		map.put("consolidateNumber", consolidateNumber);
		/*map.put("referral_patient_header_id", referral_patient_header_id);	*/

		return map;
	}
	
	
	@SuppressWarnings("unchecked")
	public synchronized Map<String, Object> approveFinanceAudit(
			Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean succesfullyAdded = false;
	
	
		Session session = (Session) getSession();
		Users user = new Users();
		user.setId(box.getInt("userId"));
		MasHospital hospital = new MasHospital();
		hospital.setId(box.getInt("hospitalId"));
		
		int hinId =0;
		int opdPatientDetailsId =0;
		int referralPatientDetailsId = 0;
		int checkboxCount =0;
		int referralBillingId =0;
		/*String referral_patient_header_id ="";*/
		/*String consolidateNumber = "";*/
		
		Transaction tx = null;
		
	
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			session.clear();
			hbt.clear();
			
			
			
			if(box.get("checkboxCount")!= null){
				checkboxCount = box.getInt("checkboxCount");
			}
			
			/*map.put("tableObjectName", "ReferralPatientHeader");			
			map.put("isHospitalWise", "y");
			map.put("hospitalId", box.getInt("hospitalId"));
			map.put("isYearly", "n");			
			map.put("isMonthly", "n");
			map.put("isPrefix", "y");
			map.put("transactionPrefixProperty", "transactionPrefixForConsolidatedNo");
			
			consolidateNumber = HMSUtil.generateTransactionSequence(map, session, hbt);*/
			
				
				String dateFormat  = "yyyy-MM-dd";
				if(box.get("noteSheetNo")!=null && !box.getString("noteSheetNo").equals("0"))
				{
					 
					   session.createQuery("update ReferralPatientHeader h set h.FinanceRemarks=isNull(h.FinanceRemarks,'')+ ' "+box.getString("finance_remarks")+"', h.LastChgDate='"+HMSUtil.convertDateToStringFormat(new Date(), dateFormat)+"',h.LastChgTime='"+box.getString(CHANGED_TIME)+"',h.LastChgBy="+user.getId()+",h.ApprovalStatus='PFD' where h.NoteSheetNo='"+box.getString("noteSheetNo")+"' and NoteSheetNo is not null and h.ApprovalStatus='WFA'").executeUpdate();
					      
				    hbt.flush(); 
				}
				
			
			succesfullyAdded = true;
			tx.commit();
				
			
		} catch (Exception e) {
			e.printStackTrace();
			succesfullyAdded = false;
			if(tx!=null)
				tx.rollback();
			
		}     
		finally
		{
			session.close();
			
		}
		map.put("succesfullyAdded", succesfullyAdded);
		
		/*map.put("referral_patient_header_id", referral_patient_header_id);	*/

		return map;
	}
	
	
	@SuppressWarnings("unchecked")
	public synchronized Map<String, Object> revertToHRDivision(
			Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean succesfullyAdded = false;
		String headerIds="";
	
	
		Session session = (Session) getSession();
		Users user = new Users();
		user.setId(box.getInt("userId"));
		MasHospital hospital = new MasHospital();
		hospital.setId(box.getInt("hospitalId"));
		
		int hinId =0;
		int opdPatientDetailsId =0;
		int referralPatientDetailsId = 0;
		int checkboxCount =0;
		int referralBillingId =0;
		/*String referral_patient_header_id ="";*/
		/*String consolidateNumber = "";*/
		
		Transaction tx = null;
		
	
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			session.clear();
			hbt.clear();
			
			
			
			if(box.get("checkboxCount")!= null){
				checkboxCount = box.getInt("checkboxCount");
			}
			
		for(int i=0; i<checkboxCount; i++)
		{
			headerIds += ",'" + box.getString("headerId"+i)+"'";
		}
		headerIds=headerIds.substring(1);
		System.out.println("headerIds"+headerIds);
				String dateFormat  = "yyyy-MM-dd";
				if(box.get("noteSheetNo")!=null && !box.getString("noteSheetNo").equals("0"))
				{
					 
					   session.createQuery("update ReferralPatientHeader h set h.LastChgDate='"+HMSUtil.convertDateToStringFormat(new Date(), dateFormat)+"',h.LastChgTime='"+box.getString(CHANGED_TIME)+"',h.LastChgBy="+user.getId()+",h.ApprovalStatus='WHD' where h.Id in ("+headerIds+") and h.ApprovalStatus='WNS'").executeUpdate();
					      
				    hbt.flush(); 
				}
				
			
			succesfullyAdded = true;
			tx.commit();
				
			
		} catch (Exception e) {
			e.printStackTrace();
			succesfullyAdded = false;
			if(tx!=null)
				tx.rollback();
			
		}     
		finally
		{
			session.close();
			
		}
		map.put("succesfullyAdded", succesfullyAdded);
		
		/*map.put("referral_patient_header_id", referral_patient_header_id);	*/

		return map;
	}
	

	@SuppressWarnings("unchecked")
	public synchronized Map<String, Object> submitDeduction(
			Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean succesfullyAdded = false;
		String headerIds="";
	
	
		Session session = (Session) getSession();
		Users user = new Users();
		user.setId(box.getInt("userId"));
		MasHospital hospital = new MasHospital();
		hospital.setId(box.getInt("hospitalId"));
	
		int referralHeaderId = box.getInt("referralHeaderId");
		/*String referral_patient_header_id ="";*/
		/*String consolidateNumber = "";*/
		
		Transaction tx = null;
		
	
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			session.clear();
			hbt.clear();
			
			
		
	
				String dateFormat  = "yyyy-MM-dd";
			
					   session.createQuery("update ReferralPatientHeader h set h.LastChgDate='"+HMSUtil.convertDateToStringFormat(new Date(), dateFormat)+"',h.LastChgTime='"+box.getString(CHANGED_TIME)+"',h.LastChgBy="+user.getId()+",h.Deducted='y' where h.Id ="+referralHeaderId).executeUpdate();
					      
				    hbt.flush(); 
			
				
			
			succesfullyAdded = true;
			tx.commit();
				
			
		} catch (Exception e) {
			e.printStackTrace();
			succesfullyAdded = false;
			if(tx!=null)
				tx.rollback();
			
		}     
		finally
		{
			session.close();
			
		}
		map.put("succesfullyAdded", succesfullyAdded);
		
		/*map.put("referral_patient_header_id", referral_patient_header_id);	*/

		return map;
	}
	
	@SuppressWarnings("unchecked")
	public synchronized Map<String, Object> rejectFinanceAudit(
			Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean succesfullyAdded = false;
		List<ReferralPatientHeader> referralHeaderList = new ArrayList<ReferralPatientHeader>();
	
	
		Session session = (Session) getSession();
		Users user = new Users();
		user.setId(box.getInt("userId"));
		MasHospital hospital = new MasHospital();
		hospital.setId(box.getInt("hospitalId"));
		
		int hinId =0;
		int opdPatientDetailsId =0;
		int referralPatientDetailsId = 0;
		int checkboxCount =0;
		int referralBillingId =0;
		/*String referral_patient_header_id ="";*/
		/*String consolidateNumber = "";*/
		
		Transaction tx = null;
		
	
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			session.clear();
			hbt.clear();
			
			
			
			if(box.get("checkboxCount")!= null){
				checkboxCount = box.getInt("checkboxCount");
			}
			
			/*map.put("tableObjectName", "ReferralPatientHeader");			
			map.put("isHospitalWise", "y");
			map.put("hospitalId", box.getInt("hospitalId"));
			map.put("isYearly", "n");			
			map.put("isMonthly", "n");
			map.put("isPrefix", "y");
			map.put("transactionPrefixProperty", "transactionPrefixForConsolidatedNo");
			
			consolidateNumber = HMSUtil.generateTransactionSequence(map, session, hbt);*/
			referralHeaderList = session.createCriteria(ReferralPatientHeader.class)
					.add(Restrictions.eq("NoteSheetNo", box.getString("noteSheetNo")))
					.add(Restrictions.eq("ApprovalStatus", "WFA")).list();
					
			for(ReferralPatientHeader rph : referralHeaderList)
			{
				ReferralNotesheetHeader nsh = new ReferralNotesheetHeader();
				nsh.setLastChgBy(user);
				nsh.setLastChgDate(new Date());
				nsh.setLastChgTime(box.getString(CHANGED_TIME));
				nsh.setNoteSheetNo(box.getString("noteSheetNo"));
				nsh.setReferralHeader(rph);
				nsh.setRemarks(box.getString("finance_remarks"));
				hbt.save(nsh);
			}
				String dateFormat  = "yyyy-MM-dd";
				if(box.get("noteSheetNo")!=null && !box.getString("noteSheetNo").equals("0"))
				{
					 
					   session.createQuery("update ReferralPatientHeader h set h.FinanceRemarks=isNull(h.FinanceRemarks,'')+ ' "+box.getString("finance_remarks")+"', h.LastChgDate='"+HMSUtil.convertDateToStringFormat(new Date(), dateFormat)+"',h.LastChgTime='"+box.getString(CHANGED_TIME)+"',h.LastChgBy="+user.getId()+",h.ApprovalStatus='RFA' where h.NoteSheetNo='"+box.getString("noteSheetNo")+"' and h.ApprovalStatus='WFA'").executeUpdate();
					      
				    hbt.flush(); 
				}
				
			
			succesfullyAdded = true;
			tx.commit();
				
			
		} catch (Exception e) {
			e.printStackTrace();
			succesfullyAdded = false;
			if(tx!=null)
				tx.rollback();
			
		}     
		finally
		{
			session.close();
			
		}
		map.put("succesfullyAdded", succesfullyAdded);
		
		/*map.put("referral_patient_header_id", referral_patient_header_id);	*/

		return map;
	}
	
	
	@SuppressWarnings("unchecked")
	public synchronized Map<String, Object> approveFinanceAuditPFD(
			Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean succesfullyAdded = false;
	
	
		Session session = (Session) getSession();
		Users user = new Users();
		user.setId(box.getInt("userId"));
		MasHospital hospital = new MasHospital();
		hospital.setId(box.getInt("hospitalId"));
		
		int hinId =0;
		int opdPatientDetailsId =0;
		int referralPatientDetailsId = 0;
		int checkboxCount =0;
		int referralBillingId =0;
		/*String referral_patient_header_id ="";*/
		String dispatchNumber = "";
		
		Transaction tx = null;
		
	
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			session.clear();
			hbt.clear();
			
			
			
			if(box.get("checkboxCount")!= null){
				checkboxCount = box.getInt("checkboxCount");
			}
			
			map.put("tableObjectName", "ReferralPatientHeader");			
			map.put("isHospitalWise", "y");
			map.put("hospitalId", box.getInt("hospitalId"));
			map.put("isDivisionWise", "y");
			map.put("divisionId", box.getInt("divisionId"));
			map.put("isYearly", "y");			
			map.put("isMonthly", "n");
			map.put("isPrefix", "y");
			map.put("transactionPrefixProperty", "transactionPrefixForPFDispatch");
			
			dispatchNumber = HMSUtil.generateTransactionSequence(map, session, hbt);
			
				
				String dateFormat  = "yyyy-MM-dd";
				if(box.get("noteSheetNo")!=null && !box.getString("noteSheetNo").equals("0"))
				{
					 
					   session.createQuery("update ReferralPatientHeader h set h.DispatchDate='"+HMSUtil.convertDateToStringFormat(new Date(), dateFormat)+"',h.LastChgDate='"+HMSUtil.convertDateToStringFormat(new Date(), dateFormat)+"',h.LastChgTime='"+box.getString(CHANGED_TIME)+"',h.LastChgBy="+user.getId()+",h.ApprovalStatus='WCB', h.DispatchNumber ='"+dispatchNumber+"' where h.NoteSheetNo='"+box.getString("noteSheetNo")+"' and NoteSheetNo is not null and h.ApprovalStatus='PFD'").executeUpdate();
					      
				    hbt.flush(); 
				}
				
			
			succesfullyAdded = true;
			tx.commit();
				
			
		} catch (Exception e) {
			e.printStackTrace();
			succesfullyAdded = false;
			if(tx!=null)
				tx.rollback();
			
		}     
		finally
		{
			session.close();
			
		}
		map.put("succesfullyAdded", succesfullyAdded);
		map.put("dispatchNumber", dispatchNumber);
		
		/*map.put("referral_patient_header_id", referral_patient_header_id);	*/

		return map;
	}

	@SuppressWarnings("unchecked")
	public synchronized Map<String, Object> generateNoteSheetLetter(
			Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean succesfullyAdded = false;
	
	
		Session session = (Session) getSession();
		Users user = new Users();
		user.setId(box.getInt("userId"));
		MasHospital hospital = new MasHospital();
		hospital.setId(box.getInt("hospitalId"));
		
		int hinId =0;
		int opdPatientDetailsId =0;
		int referralPatientDetailsId = 0;
		int checkboxCount =0;
		int referralBillingId =0;
		/*String referral_patient_header_id ="";*/
		String consolidateNumber = "";
		
		Transaction tx = null;
		
	
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			session.clear();
			hbt.clear();
			
			
			
			if(box.get("checkboxCount")!= null){
				checkboxCount = box.getInt("checkboxCount");
			}
			
			map.put("tableObjectName", "ReferralPatientHeader");			
			map.put("isHospitalWise", "y");
			map.put("hospitalId", box.getInt("hospitalId"));
			map.put("isDivisionWise", "y");
			map.put("divisionId", box.getInt("divisionId"));
			map.put("isYearly", "y");			
			map.put("isMonthly", "n");
			map.put("isPrefix", "y");
			map.put("transactionPrefixProperty", "transactionPrefixForNoteSheet");
			
			consolidateNumber = HMSUtil.generateTransactionSequence(map, session, hbt);
			
			 for(int i = 0; i<checkboxCount; i++)
			   {	
				
				if(box.get("headerId"+i)!=null && box.getInt("headerId"+i)!=0)
				{
					   ReferralPatientHeader referralPatientHeader = (ReferralPatientHeader)session.load(ReferralPatientHeader.class, box.getInt("headerId"+i));
					   
					 
					
					   referralPatientHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
					   referralPatientHeader.setLastChgTime(box.getString(CHANGED_TIME));
					   referralPatientHeader.setLastChgBy(user);				
					
					
						referralPatientHeader.setApprovalStatus("WFA");
						referralPatientHeader.setNoteSheetNo(consolidateNumber);
						referralPatientHeader.setNoteSheetDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
						
					
						
						
					    /*referral_patient_header_id+=","+box.getInt("headerId"+i); */
						 
					
				    hbt.update(referralPatientHeader);		    
				    hbt.flush(); 
				}
				
				
				
			   }
			 /*referral_patient_header_id = referral_patient_header_id.substring(1);*/
			succesfullyAdded = true;
			tx.commit();
				
			
		} catch (Exception e) {
			e.printStackTrace();
			succesfullyAdded = false;
			if(tx!=null)
				tx.rollback();
			
		}     
		finally
		{
			session.close();
			
		}
		map.put("succesfullyAdded", succesfullyAdded);
		map.put("consolidateNumber", consolidateNumber);
		/*map.put("referral_patient_header_id", referral_patient_header_id);	*/

		return map;
	}

	
	@SuppressWarnings("unchecked")
	public synchronized Map<String, Object> submitReferralExtension(
			Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean succesfullyAdded = false;
	
	
		Session session = (Session) getSession();
		Users user = new Users();
		user.setId(box.getInt("userId"));
		MasHospital hospital = new MasHospital();
		hospital.setId(box.getInt("hospitalId"));
		
		
		int referralPatientDetailsId = 0;
				
		int referralPatientHeaderId = 0;
		int noOfDays = 0;
		String referral_treatment_type ="";
		String referredFor ="";
		String doctorRemarks ="";
		Date date = new Date();
		
		
		ReferralPatientDetails referralPatientDetails = new ReferralPatientDetails();
       
        ReferralPatientHeader referralPatientHeader = new ReferralPatientHeader();
       
		
		
		 if(box.get("referralPatientHeaderId")!= null){
	        	referralPatientHeaderId = box.getInt("referralPatientHeaderId");
			}
		 if(box.get("referdays")!= null){
			 noOfDays = box.getInt("referdays");
			}
		 if(box.get("referral_treatment_type")!= null){
			 referral_treatment_type = box.getString("referral_treatment_type");
			}
		 if(box.get("referredFor")!= null){
			 referredFor = box.getString("referredFor");
			}
		 if(box.get("doctorRemarks")!= null){
			 doctorRemarks = box.getString("doctorRemarks");
			}
	
		Transaction tx = null;
		
	
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			session.clear();
			hbt.clear();
			
			
		
			referralPatientHeader = (ReferralPatientHeader)session.load(ReferralPatientHeader.class, referralPatientHeaderId);
			referralPatientHeader.setExtensionStatus("DA");
			referralPatientDetails.setReferralPatientHeader(referralPatientHeader);
			referralPatientDetails.setNoOfDays(noOfDays);
			referralPatientDetails.setTreatmentType(referral_treatment_type);
			referralPatientDetails.setReferredFor(referredFor);
			referralPatientDetails.setDoctorRemarks(doctorRemarks);
			referralPatientDetails.setReferralExtensionDate(date);
			referralPatientDetails.setLastChgDate(date);
			referralPatientDetails.setLastChgBy(user);
			referralPatientDetails.setLastChgTime(box.getString(CHANGED_TIME));
			
			
				
				
					
				
					
				
				
				
				
				
			    hbt.save(referralPatientDetails);		    
			    
			   
			succesfullyAdded = true;
			tx.commit();
				
			
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
			
		}     
		finally
		{
			session.close();
			
		}
		map.put("succesfullyAdded", succesfullyAdded);	

		return map;
	}
	
	@SuppressWarnings("unchecked")
	public synchronized Map<String, Object> submitInvoicePageForFinanceDivision(
			Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean succesfullyAdded = false;
	
	
		Session session = (Session) getSession();
		Users user = new Users();
		user.setId(box.getInt("userId"));
		MasHospital hospital = new MasHospital();
		hospital.setId(box.getInt("hospitalId"));
		
		int hinId =0;
		int opdPatientDetailsId =0;
		int referralPatientDetailsId = 0;
		int impanelled_bill = 0;
		int divCountBilling = 0;
		int referralBillingId = 0;
		int referralPatientHeaderId = 0;
		int hal_bill = 0;
		String finance_remarks = "";	
		String flag="";
		
		ReferralPatientDetails referralPatientDetails = new ReferralPatientDetails();
        Patient patient = new Patient();
        OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
        ReferralPatientHeader referralPatientHeader = new ReferralPatientHeader();
       
		/*if(box.get("hinId")!= null){
			hinId = (Integer)box.getInt("hinId");
		}
		
		if(box.get("opdPatientDetailsId")!= null){
			opdPatientDetailsId = (Integer)box.getInt("opdPatientDetailsId");
		}
		
		if(box.get("referralPatientDetailsId")!= null){
			referralPatientDetailsId = box.getInt("referralPatientDetailsId");
		}
		
		if(box.get("impanelled_bill")!= null){
			impanelled_bill = box.getInt("impanelled_bill");
		}
		
		if(box.get("hal_bill")!= null){
			hal_bill = box.getInt("hal_bill");
		}*/
        
        if(box.get("flag")!= null){
			flag = box.getString("flag");
		}
        
		if(box.get("referralPatientHeaderId")!= null){
        	referralPatientHeaderId = box.getInt("referralPatientHeaderId");
		}
		
		if(box.get("finance_remarks")!= null){
			finance_remarks = box.getString("finance_remarks");
		}
	
	
		Transaction tx = null;
		
	
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			session.clear();
			hbt.clear();
			
			
			if(box.get("divCountBilling")!= null){
				divCountBilling = box.getInt("divCountBilling");
			}
			referralPatientHeader = (ReferralPatientHeader)session.load(ReferralPatientHeader.class, referralPatientHeaderId);
			/*referralPatientDetails = (ReferralPatientDetails)session.load(ReferralPatientDetails.class, referralPatientDetailsId);*/
		
			 for(int i = 1; i<=divCountBilling; i++)
			   {	
				 referralBillingId =0; 
				 
				   ReferralPatientBilling referralPatientBilling = new ReferralPatientBilling();
				   referralPatientBilling = (ReferralPatientBilling)session.load(ReferralPatientBilling.class, box.getInt("referralBillingId"+i));
				 /*  if(box.get("referralBillingId"+i)!= null && box.getInt("referralBillingId"+i)!=0){
					   referralBillingId = box.getInt("referralBillingId"+i);
					   referralPatientBilling.setId(referralBillingId);
					   System.out.println("referralBillingId"+referralBillingId);
					}*/
				 
				
					
					
					
				
				referralPatientBilling.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
				referralPatientBilling.setLastChgTime(box.getString(CHANGED_TIME));
				referralPatientBilling.setLastChgBy(user);				
				referralPatientBilling.setFinanceRemarks(finance_remarks);			
				if(flag.equals("rejected"))
				{
					referralPatientBilling.setApprovalStatus("RFA");
				}
				else
				{
					referralPatientBilling.setApprovalStatus("FA");
				}
				if(i==divCountBilling)
				{
					if(flag.equals("rejected"))
					{
						referralPatientHeader.setApprovalStatus("RFA");
					}
					else
					{
						referralPatientHeader.setApprovalStatus("FA");
						referralPatientHeader.setFinanceApprovalDate(new Date());
						referralPatientHeader.setFinanceApprovalTime(box.getString(LAST_CHANGED_TIME));
					}
					
					referralPatientHeader.setFinanceRemarks(finance_remarks);
				}
				
				
				
			    hbt.update(referralPatientBilling);		    
			    hbt.flush(); 
			   }
			succesfullyAdded = true;
			tx.commit();
				
			
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
			
		}     
		finally
		{
			session.close();
			
		}
		map.put("succesfullyAdded", succesfullyAdded);	

		return map;
	}
	

	@Override
	public Map<String, Object> generateExcelForPortal(Box box) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		Criteria cr = null;
		List<List<Object[]>> sheetList = new ArrayList<List<Object[]>>();	
		List<Object[]> referralPatientHeaderList = new ArrayList<Object[]>();	
		List<Object[]> referralPatientDetailsList = new ArrayList<Object[]>();	
		List<Object[]> referralPatientBillingList = new ArrayList<Object[]>();	
		Session session = (Session) getSession();
		try {
		int hospitalId = box.getInt("hospitalId");
		
		
		referralPatientHeaderList = session.createCriteria(ReferralPatientHeader.class)
				/*.add(Restrictions.eq("ExcelStatus", "WEG").ignoreCase())*/				
				/*.add(Restrictions.eq("FromHospital.Id", hospitalId))*/
				.setProjection(Projections.projectionList()
                .add(Projections.property("Id"))
                .add(Projections.property("LastChgDate"))
                .add(Projections.property("LastChgTime"))
                .add(Projections.property("Name"))
                .add(Projections.property("Age"))
                .add(Projections.property("GenderName"))
                .add(Projections.property("EmpNo"))
                .add(Projections.property("DivisionName"))
                .add(Projections.property("ContactNo"))
                .add(Projections.property("ReferralNo"))
                .add(Projections.property("ReferralDate"))
                .add(Projections.property("CompleteBill"))
                .add(Projections.property("ApprovalStatus"))
                .add(Projections.property("ExcelStatus"))
                .add(Projections.property("TotalBillAmt"))
                .add(Projections.property("AdminBillAmt"))
                .add(Projections.property("CovernoteNumber"))
                .add(Projections.property("CovernoteDate"))
                .add(Projections.property("ConsolidateNumber"))
                .add(Projections.property("ConsolidateDate"))
                .add(Projections.property("HrRemarks"))
                .add(Projections.property("FinanceRemarks"))
                .add(Projections.property("GmRemarks"))
                .add(Projections.property("ExtensionStatus"))
                .add(Projections.property("Relation.Id"))
                .add(Projections.property("LastChgBy.Id"))
                .add(Projections.property("Gender.Id"))
                .add(Projections.property("Hospital.Id"))
                .add(Projections.property("EmployeeDependent.Id"))
                .add(Projections.property("FromHospital.Id"))
                .add(Projections.property("Hin.Id"))
                .add(Projections.property("ToHospital.Id"))
                .add(Projections.property("OpdPatientDetails.id"))
                .add(Projections.property("Division.Id"))
                .add(Projections.property("Doctor.Id")))                
                .list();       
		
		
		
		referralPatientDetailsList = session.createCriteria(ReferralPatientDetails.class)
				/*.add(Restrictions.eq("ExcelStatus", "WEG").ignoreCase())*/				
				/*.add(Restrictions.eq("FromHospital.Id", hospitalId))*/
				.setProjection(Projections.projectionList()
                .add(Projections.property("Id"))
                .add(Projections.property("ReferralExtensionDate"))
                .add(Projections.property("TreatmentType"))
                .add(Projections.property("ReferredFor"))
                .add(Projections.property("NoOfDays"))
                .add(Projections.property("ReferralNote"))
                .add(Projections.property("DoctorRemarks"))
                .add(Projections.property("LetterValidityPeriod"))
                .add(Projections.property("Subject"))
                .add(Projections.property("LastChgDate"))
                .add(Projections.property("LastChgTime"))
                .add(Projections.property("ReferralNo"))
                .add(Projections.property("TotalBillAmt"))
                .add(Projections.property("AdminBillAmt"))
                .add(Projections.property("ReferralPatientHeader.Id"))
                .add(Projections.property("LastChgBy.Id")))              
                .list();            
               
		
		referralPatientBillingList = session.createCriteria(ReferralPatientBilling.class)
				/*.add(Restrictions.eq("ExcelStatus", "WEG").ignoreCase())*/				
				/*.add(Restrictions.eq("FromHospital.Id", hospitalId))*/
				.setProjection(Projections.projectionList()
                .add(Projections.property("Id"))
                .add(Projections.property("BillNo"))
                .add(Projections.property("BillDate"))
                .add(Projections.property("TotalBillAmt"))
                .add(Projections.property("AdminBillAmt"))
                .add(Projections.property("AdminRemarks"))
                .add(Projections.property("HrRemarks"))
                .add(Projections.property("FinanceRemarks"))
                .add(Projections.property("GmRemarks"))
                .add(Projections.property("ApprovalStatus"))
                .add(Projections.property("CheckNo"))
                .add(Projections.property("CheckDate"))
                .add(Projections.property("CheckAmount"))
                .add(Projections.property("LastChgDate"))
                .add(Projections.property("LastChgTime"))
                .add(Projections.property("NetAmount"))
                .add(Projections.property("TaxAmount"))
                .add(Projections.property("ErpPostingDate"))
                .add(Projections.property("ErpUploadingDate"))
                .add(Projections.property("LastChgBy.Id"))  
                .add(Projections.property("ReferralDetails.Id")))                
                .list(); 
		
		
		String hql = "UPDATE ReferralPatientHeader set ExcelStatus = 'EG' "  + 
	             "WHERE ExcelStatus = 'WEG' AND FromHospital.Id = "+hospitalId;
	             Query query = session.createQuery(hql);	
	            /*int result = query.executeUpdate();*/
	            sheetList.add(referralPatientHeaderList);
	            sheetList.add(referralPatientDetailsList);
	            sheetList.add(referralPatientBillingList);
		map.put("sheetList", sheetList);	
		
			/*HMSUtil.excelWriter();*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("message", "Some Error Has occured! Try Again.");
		}
		
		
				
		return map;
	}
	

	@Override
	public Map<String, Object> generateExcelForBillsPaybal(Box box) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		Criteria cr = null;
		List<List<Object[]>> sheetList = new ArrayList<List<Object[]>>();	
		/*List<Object[]> referralPatientHeaderList = new ArrayList<Object[]>();	*/
		List<Object[]> referralPatientBillingList = new ArrayList<Object[]>();	
		
		Session session = (Session) getSession();
		try {
		int headerId = box.getInt("headerId");
		
		
		referralPatientBillingList = session.createCriteria(ReferralPatientBilling.class)
				.createAlias("ReferralDetails", "d")
				.createAlias("d.ReferralPatientHeader", "h")
				.createAlias("ReferralDetails", "dt")
				.createAlias("h.ToHospital", "th")
				.createAlias("h.Hin", "p")
				.createAlias("p.Employee", "e")
				.createAlias("e.Division", "d")
				.createAlias("p.Relation", "r")				
				/*.add(Restrictions.eq("ExcelStatus", "WEG").ignoreCase())*/				
				.add(Restrictions.eq("Id", headerId))
				.setProjection(Projections.projectionList()
                .add(Projections.property("d.DivisionName"))
                .add(Projections.property("d.DivisionCode"))
                .add(Projections.property("th.ImpanneledHospitalName"))
                .add(Projections.property("th.ImpanneledHospitalCode"))
                .add(Projections.property("BillNo"))
                .add(Projections.property("BillDate"))
                .add(Projections.property("dt.ReferralNo"))
                .add(Projections.property("dt.ReferralExtensionDate"))
                .add(Projections.property("r.RelationName"))
                .add(Projections.property("AdminBillAmt"))
                .add(Projections.property("p.ServiceNo"))
                .add(Projections.property("p.PFirstName"))
                .add(Projections.property("e.FirstName")))                           
                .list();       
		
		
		
	/*	String hql = "UPDATE ReferralPatientHeader set ExcelStatus = 'EG' "  + 
	             "WHERE ExcelStatus = 'WEG' AND FromHospital.Id = "+hospitalId;
	             Query query = session.createQuery(hql);	*/
	            /*int result = query.executeUpdate();*/
	            sheetList.add(referralPatientBillingList);
	         
		map.put("sheetList", sheetList);	
		
			/*HMSUtil.excelWriter();*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("message", "Some Error Has occured! Try Again.");
		}
		
		
				
		return map;
	}
	
	
	@Override
	public Map<String, Object> uploadExcelForHAL(HttpServletRequest request) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		Criteria cr = null;
		List<Object[][]> sheetList = new ArrayList<Object[][]>();	
		
		Session session = (Session) getSession();
		Transaction tx = null;
		boolean succesfullyAdded = true;
		
		
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			session.clear();
			hbt.clear();
			 sheetList = HMSUtil.excelReader(request);
			 Object[][] headerTable = sheetList.get(0);
			 
				 for(int i=0; i<sheetList.get(0).length; i++)
				 {
					 
					
						 System.out.println("out"+headerTable[i][9].toString());
						 ReferralPatientHeader header = new ReferralPatientHeader();
						 header.setId(headerTable[i][0]!=null?Integer.parseInt(headerTable[i][0].toString()):null);
						 header.setLastChgDate(headerTable[i][1]!=null?HMSUtil.dateFormatteryyyymmdd(headerTable[i][1].toString()):null);
						 header.setLastChgTime(headerTable[i][2]!=null?headerTable[i][2].toString():null);
						 header.setName(headerTable[i][3]!=null?headerTable[i][3].toString():null);
						 header.setAge(headerTable[i][4]!=null?headerTable[i][4].toString():null);
						 header.setGenderName(headerTable[i][5]!=null?headerTable[i][5].toString():null);
						 header.setEmpNo(headerTable[i][6]!=null?headerTable[i][6].toString():null);
						 header.setDivisionName(headerTable[i][7]!=null?headerTable[i][7].toString():null);
						 header.setContactNo(headerTable[i][8]!=null?headerTable[i][8].toString():null);
						 header.setReferralNo(headerTable[i][9]!=null?headerTable[i][9].toString():null);
						 header.setReferralDate(headerTable[i][10]!=null?HMSUtil.dateFormatteryyyymmdd(headerTable[i][10].toString()):null);
						 header.setCompleteBill(headerTable[i][11]!=null?headerTable[i][11].toString():null);
						 header.setApprovalStatus(headerTable[i][12]!=null?headerTable[i][12].toString():null);
						 header.setExcelStatus(headerTable[i][13]!=null?headerTable[i][13].toString():null);
						 header.setTotalBillAmt(headerTable[i][14]!=null?new BigDecimal(headerTable[i][14].toString()):null);
						 header.setAdminBillAmt(headerTable[i][15]!=null?new BigDecimal(headerTable[i][15].toString()):null);
						 header.setCovernoteNumber(headerTable[i][16]!=null?headerTable[i][16].toString():null);
						 header.setCovernoteDate(headerTable[i][17]!=null?HMSUtil.dateFormatteryyyymmdd(headerTable[i][17].toString()):null);
						 header.setConsolidateNumber(headerTable[i][18]!=null?headerTable[i][18].toString():null);
						 header.setConsolidateDate(headerTable[i][19]!=null?HMSUtil.dateFormatteryyyymmdd(headerTable[i][19].toString()):null);
						 header.setHrRemarks(headerTable[i][20]!=null?headerTable[i][20].toString():null);
						 header.setFinanceRemarks(headerTable[i][21]!=null?headerTable[i][21].toString():null);
						 header.setGmRemarks(headerTable[i][22]!=null?headerTable[i][22].toString():null);
						 header.setExcelStatus(headerTable[i][23]!=null?headerTable[i][23].toString():null);
						 if(headerTable[i][24]!=null)
						 {
							 MasRelation relation = new MasRelation();
							 relation.setId(Integer.parseInt(headerTable[i][24].toString()));
							 header.setRelation(relation); 
						 }
						 else
						 {
							 header.setRelation(null); 
						 }
						 if(headerTable[i][25]!=null)
						 {
							 Users user = new Users();
							 user.setId(Integer.parseInt(headerTable[i][25].toString()));
							 header.setLastChgBy(user);
						 }
						 else
						 {
							 header.setLastChgBy(null); 
						 }
						 if(headerTable[i][26]!=null)
						 {
							 MasAdministrativeSex gender = new MasAdministrativeSex();
							 gender.setId(Integer.parseInt(headerTable[i][26].toString()));
							 header.setGender(gender);
						 }
						 else
						 {
							 header.setGender(null); 
						 }
						 if(headerTable[i][27]!=null)
						 {
							 MasHospital hospital = new MasHospital();
							 hospital.setId(Integer.parseInt(headerTable[i][27].toString()));
							 header.setHospital(hospital);
						 }
						 else
						 {
							 header.setHospital(null); 
						 }
						 
						 if(headerTable[i][28]!=null)
						 {
							 MasEmployeeDependent dependent = new MasEmployeeDependent();
							 dependent.setId(Integer.parseInt(headerTable[i][28].toString()));
							 header.setEmployeeDependent(dependent);
						 }
						 else
						 {
							 header.setEmployeeDependent(null); 
						 }
						 
						 if(headerTable[i][29]!=null)
						 {
							 MasHospital fromHospital = new MasHospital();
							 fromHospital.setId(Integer.parseInt(headerTable[i][29].toString()));
							 header.setFromHospital(fromHospital);
						 }
						 else
						 {
							 header.setFromHospital(null); 
						 }
						 
						 if(headerTable[i][30]!=null)
						 {
							 Patient patient = new Patient();
							 patient.setId(Integer.parseInt(headerTable[i][30].toString()));
							 header.setHin(patient);
						 }
						 else
						 {
							 header.setHin(null); 
						 }
						 if(headerTable[i][31]!=null)
						 {
							 MasImpanneledHospital toHospital = new MasImpanneledHospital();
							 toHospital.setId(Integer.parseInt(headerTable[i][31].toString()));
							 header.setToHospital(toHospital);
						 }
						 else
						 {
							 header.setToHospital(null); 
						 }
						 if(headerTable[i][32]!=null)
						 {
							 OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
							 opdPatientDetails.setId(Integer.parseInt(headerTable[i][32].toString()));
							 header.setOpdPatientDetails(opdPatientDetails);
						 }
						 else
						 {
							 header.setOpdPatientDetails(null); 
						 }
						 if(headerTable[i][33]!=null)
						 {
							 MasDivision division = new MasDivision();
							 division.setId(Integer.parseInt(headerTable[i][33].toString()));
							 header.setDivision(division);
						 }
						 else
						 {
							 header.setDivision(null); 
						 }
						 if(headerTable[i][34]!=null)
						 {
							 MasEmployee doctor = new MasEmployee();
							 doctor.setId(Integer.parseInt(headerTable[i][34].toString()));
							 header.setDoctor(doctor);
						 }
						 else
						 {
							 header.setDoctor(null); 
						 }
						 
						
						 
						 hbt.saveOrUpdate(header);
						 hbt.flush();
						
					 
				 }
				 headerTable = sheetList.get(1);
				 for(int i=0; i<sheetList.get(1).length; i++)
				 {
					 
					
						 System.out.println("out"+headerTable[i][9].toString());
						 ReferralPatientDetails details = new ReferralPatientDetails();
						 details.setId(headerTable[i][0]!=null?Integer.parseInt(headerTable[i][0].toString()):null);
						 details.setReferralExtensionDate(headerTable[i][1]!=null?HMSUtil.dateFormatteryyyymmdd(headerTable[i][1].toString()):null);
						 details.setTreatmentType(headerTable[i][2]!=null?headerTable[i][2].toString():null);
						 details.setReferredFor(headerTable[i][3]!=null?headerTable[i][3].toString():null);
						 details.setNoOfDays(headerTable[i][4]!=null?Integer.parseInt(headerTable[i][4].toString()):null);						 
						 details.setReferralNote(headerTable[i][5]!=null?headerTable[i][5].toString():null);						 
						 details.setDoctorRemarks(headerTable[i][6]!=null?headerTable[i][6].toString():null);
						 details.setLetterValidityPeriod(headerTable[i][7]!=null?Integer.parseInt(headerTable[i][7].toString()):null);						 
						 details.setSubject(headerTable[i][8]!=null?headerTable[i][8].toString():null);
						 details.setLastChgDate(headerTable[i][9]!=null?HMSUtil.dateFormatteryyyymmdd(headerTable[i][9].toString()):null);
						 details.setLastChgTime(headerTable[i][10]!=null?headerTable[i][10].toString():null);
						 details.setReferralNo(headerTable[i][11]!=null?headerTable[i][11].toString():null);
						 details.setTotalBillAmt(headerTable[i][12]!=null?new BigDecimal(headerTable[i][12].toString()):null);
						 details.setAdminBillAmt(headerTable[i][13]!=null?new BigDecimal(headerTable[i][13].toString()):null);
						
						 if(headerTable[i][14]!=null)
						 {
							 ReferralPatientHeader header = new ReferralPatientHeader();
							 header.setId(Integer.parseInt(headerTable[i][14].toString()));
							 details.setReferralPatientHeader(header); 
						 }
						 else
						 {
							 details.setReferralPatientHeader(null); 
						 }
						 if(headerTable[i][15]!=null)
						 {
							 Users user = new Users();
							 user.setId(Integer.parseInt(headerTable[i][15].toString()));
							 details.setLastChgBy(user);
						 }
						 else
						 {
							 details.setLastChgBy(null); 
						 }
						
						 
						
						 
						 hbt.saveOrUpdate(details);
						 hbt.flush();
						
					 
				 }
				 
				 headerTable = sheetList.get(2);
				 for(int i=0; i<sheetList.get(1).length; i++)
				 {
					 
					
						 
						 ReferralPatientBilling billing = new ReferralPatientBilling();
						 billing.setId(headerTable[i][0]!=null?Integer.parseInt(headerTable[i][0].toString()):null);
						 billing.setBillNo(headerTable[i][1]!=null?headerTable[i][1].toString():null);
						 billing.setBillDate(headerTable[i][2]!=null?HMSUtil.dateFormatteryyyymmdd(headerTable[i][2].toString()):null);
						 billing.setTotalBillAmt(headerTable[i][3]!=null?new BigDecimal(headerTable[i][3].toString()):null);
						 billing.setAdminBillAmt(headerTable[i][4]!=null?new BigDecimal(headerTable[i][4].toString()):null);						 
						 billing.setAdminRemarks(headerTable[i][5]!=null?headerTable[i][5].toString():null);						 
						 billing.setHrRemarks(headerTable[i][6]!=null?headerTable[i][6].toString():null);
						 billing.setFinanceRemarks(headerTable[i][7]!=null?headerTable[i][7].toString():null);						 
						 billing.setGmRemarks(headerTable[i][8]!=null?headerTable[i][8].toString():null);
						 billing.setApprovalStatus(headerTable[i][9]!=null?headerTable[i][9].toString():null);
						 billing.setCheckNo(headerTable[i][10]!=null?headerTable[i][10].toString():null);
						 billing.setCheckDate(headerTable[i][11]!=null?HMSUtil.dateFormatteryyyymmdd(headerTable[i][11].toString()):null);
						 billing.setCheckAmount(headerTable[i][12]!=null?new BigDecimal(headerTable[i][12].toString()):null);
						 billing.setLastChgDate(headerTable[i][13]!=null?HMSUtil.dateFormatteryyyymmdd(headerTable[i][13].toString()):null);
						 billing.setLastChgTime(headerTable[i][14]!=null?headerTable[i][14].toString():null);
						 billing.setNetAmount(headerTable[i][15]!=null?new BigDecimal(headerTable[i][15].toString()):null);
						 billing.setTaxAmount(headerTable[i][16]!=null?new BigDecimal(headerTable[i][16].toString()):null);
						 billing.setErpPostingDate(headerTable[i][17]!=null?HMSUtil.dateFormatteryyyymmdd(headerTable[i][17].toString()):null);
						 billing.setErpUploadingDate(headerTable[i][18]!=null?HMSUtil.dateFormatteryyyymmdd(headerTable[i][18].toString()):null);
						
						 if(headerTable[i][19]!=null)
						 {
							 Users user = new Users();
							 user.setId(Integer.parseInt(headerTable[i][19].toString()));
							 billing.setLastChgBy(user);
						 }
						 else
						 {
							 billing.setLastChgBy(null); 
						 }
						 
						 if(headerTable[i][20]!=null)
						 {
							 ReferralPatientDetails details = new ReferralPatientDetails();
							 details.setId(Integer.parseInt(headerTable[i][20].toString()));
							 billing.setReferralDetails(details); 
						 }
						 else
						 {
							 billing.setReferralDetails(null); 
						 }
						 
						
						 
						
						 
						 hbt.saveOrUpdate(billing);
						 hbt.flush();
						
					 
				 }
				 
				
			 
		
				 succesfullyAdded = true;
					tx.commit();
						
					
				} catch (Exception e) {
					e.printStackTrace();
					succesfullyAdded = false;
					if(tx!=null)
						tx.rollback();
					
				}     
				finally
				{
					session.close();
					
				}
				map.put("succesfullyAdded", succesfullyAdded);	
		
				
		return map;
	}
	
	@Override
	public Map<String, Object> submitERPUpload(HttpServletRequest request) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		Criteria cr = null;
		List<Object[][]> sheetList = new ArrayList<Object[][]>();	
		
		Session session = (Session) getSession();
		Transaction tx = null;
		boolean succesfullyAdded = true;
		String message = "";
		boolean flag = true;
		List<ReferralPatientBilling> billingList = new ArrayList<ReferralPatientBilling>();
		
		
		try {
			
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			session.clear();
			hbt.clear();
			 sheetList = HMSUtil.excelReader(request);
			 Object[][] table = sheetList.get(0);
			 int alreadyUpdated = 0;
			 int totalUpdation = 0;
			 int failedUpdation =0;
			 
			 String alreadyUpdatedMsg = "";
			 String totalUpdationMsg = "";
			 String failedUpdationMsg ="";
			 
				 for(int i=1; i<sheetList.get(0).length; i++)
				 {
					 try{
					 System.out.println("table[i][4]--"+table[i][4]);
					 System.out.println("table[i][9]--"+table[i][9]);
					 System.out.println("table[i][11]--"+table[i][11]);
					 System.out.println("table[i][19]--"+table[i][19]);
					 if(table[i][15].toString().contains("."))
					 {
						 table[i][15] = table[i][15].toString().substring(0, table[i][15].toString().indexOf(".")); 
					 }
					 
					 /*System.out.println("table[i][15]"+table[i][15].toString());*/
					 System.out.println("table[i][8].toString()"+table[i][8].toString());
					 billingList =session.createCriteria(ReferralPatientBilling.class)
							 .createAlias("ReferralDetails", "dt")
							 .createAlias("dt.ReferralPatientHeader", "hd")
							 .add(Restrictions.eq("BillNo", table[i][8].toString().trim()))
							 .add(Restrictions.eq("dt.ReferralNo", table[i][10].toString().trim()))
					         .add(Restrictions.eq("hd.EmpNo", table[i][15].toString().trim())).list();
					 System.out.println("billingList"+billingList.size());
					 if(billingList.size()>0)
					 {
						 tx = session.beginTransaction();
						 ReferralPatientBilling billing = new ReferralPatientBilling();
						 billing = (ReferralPatientBilling)session.load(ReferralPatientBilling.class, billingList.get(0).getId());
						/* try
						 {	*/
						 if(billing.getNetAmount()==null || billing.getNetAmount().compareTo(new BigDecimal(0.0))==0)
						 {
							 if(table[i][3]!=null && table[i][4]!=null && table[i][5]!=null && table[i][13]!=null && table[i][14]!=null && table[i][19]!=null 
							&& !table[i][3].toString().trim().equals("") && !table[i][4].toString().trim().equals("") && !table[i][5].toString().trim().equals("") && !table[i][13].toString().trim().equals("") && !table[i][14].toString().trim().equals("") && !table[i][19].toString().trim().equals(""))
							 {
							if(HMSUtil.dateFormatterddmmyy(table[i][4].toString())!=null || HMSUtil.dateFormatterddmmyy(table[i][19].toString())!=null) 
							{	 
						 billing.setCheckNo(table[i][3]!=null?table[i][3].toString():null);						 
						 billing.setCheckDate(table[i][4]!=null?HMSUtil.dateFormatterddmmyy(table[i][4].toString()):null);						 
						 billing.setCheckAmount(table[i][5]!=null?new BigDecimal(table[i][5].toString()):null);
						 billing.setTaxAmount(table[i][13]!=null?new BigDecimal(table[i][13].toString()):null);						
						 billing.setNetAmount(table[i][14]!=null?new BigDecimal(table[i][14].toString()):null);						 
						 billing.setErpPostingDate(table[i][19]!=null?HMSUtil.dateFormatterddmmyy(table[i][19].toString()):null);
						 billing.setErpUploadingDate(new Date());
						 hbt.save(billing);
						 billing.getReferralDetails().getReferralPatientHeader().setApprovalStatus("C");
						 totalUpdation++;
						 hbt.flush();
						 tx.commit();
						 totalUpdationMsg+="PB No:"+table[i][15].toString()+" Bill No:"+table[i][8].toString()+" Referral No: "+table[i][10].toString()+"<br>";
							}
						 else
						 {
							 flag = false;
							 failedUpdationMsg+="Date format is incorrect for PB No:"+table[i][15].toString()+" Bill No:"+table[i][8].toString()+" Referral No:"+table[i][10].toString()+"<br>";
							 failedUpdation++;
						 }
							 }
							 else
							 {
								 flag = false;
								 failedUpdationMsg+="There are blank fields for PB No:"+table[i][15].toString()+" Bill No:"+table[i][8].toString()+" Referral No:"+table[i][10].toString()+"<br>";
								 failedUpdation++;
							 }
						 }
						 else
						 {
							 flag = false;
							 alreadyUpdatedMsg+="PB No:"+table[i][15].toString()+" Bill No:"+table[i][8].toString()+" Referral No: "+table[i][10].toString()+"<br>";
								alreadyUpdated++;
						 }
						/* }
						 catch (Exception e) {
								e.printStackTrace();
								flag = false;
								failedUpdationMsg+="Check Data of PB No:"+table[i][15].toString()+" Bill No:"+table[i][8].toString()+" Referral No:"+table[i][10].toString()+"<br>";
								failedUpdation++;
						 }*/
					 }
						 
					 else
					 {
						 flag = false;
						 failedUpdationMsg+="Data not available in HMIS for PB No:"+table[i][15].toString()+" Bill No:"+table[i][8].toString()+" Referral No:"+table[i][10].toString()+"<br>";
						 failedUpdation++;
					 }
					
				 }
				 catch (Exception e) 
				 {
					 e.printStackTrace();
						flag = false;
						failedUpdationMsg+="Check Data of PB No:"+table[i][15].toString()+" Bill No:"+table[i][8].toString()+" Referral No:"+table[i][10].toString()+"<br>";
						failedUpdation++;
				 }
				 }
				/* if(!totalUpdationMsg.equals("")){
					 totalUpdationMsg = totalUpdationMsg.substring(0, (totalUpdationMsg.length()-2));
				 }*/
              /*   if(!totalUpdationMsg.equals("")){
	                 alreadyUpdatedMsg = alreadyUpdatedMsg.substring(0, (alreadyUpdatedMsg.length()-2));
				 }*/
               /*  if(!totalUpdationMsg.equals("")){
	                 failedUpdationMsg = failedUpdationMsg.substring(0, (failedUpdationMsg.length()-2));
                 }*/
				
				 message = "<br><font color = 'green'>Total Updation="+totalUpdation+"<br>"+totalUpdationMsg+"</font><br><font color = 'blue'>Already Updated ="+alreadyUpdated+"<br>"+alreadyUpdatedMsg+"</font><br><font color = 'red'>Failed Updation="+failedUpdation+"<br>(Note: There should be no blank space and date should be in correct format(dd-MM-yyyy))<br>"+failedUpdationMsg+"</font>";
				 if(flag)
				 {
					 message = "<font color = 'green'>All Bills Uploaded Successfully</font>";
				 }
				
				 
				 succesfullyAdded = true;
					
						
					
				 } catch (Exception e) {
					e.printStackTrace();
					succesfullyAdded = false;
				/*	if(tx!=null)
						tx.rollback();*/
					message = "Some Error Has occured! Kindly check excel file(There should be no blank space and date should be in correct format(dd-MM-yyyy))";
				}     
				finally
				{
					session.close();
					
				}
				map.put("succesfullyAdded", succesfullyAdded);	
				map.put("message", message);
		
				
		return map;
	}
	
	
	@Override
	public Map<String, Object> submitERPUploadTemp(HttpServletRequest request) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		Criteria cr = null;
		List<Object[][]> sheetList = new ArrayList<Object[][]>();	
		
		Session session = (Session) getSession();
		Transaction tx = null;
		boolean succesfullyAdded = true;
		String message = "";
		boolean flag = true;
		List<ReferralPatientBilling> billingList = new ArrayList<ReferralPatientBilling>();
		
		
		try {
			
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			session.clear();
			hbt.clear();
			 sheetList = HMSUtil.excelReader(request);
			 Object[][] table = sheetList.get(0);
			 int alreadyUpdated = 0;
			 int totalUpdation = 0;
			 int failedUpdation =0;
			 
			 String alreadyUpdatedMsg = "";
			 String totalUpdationMsg = "";
			 String failedUpdationMsg ="";
			 
				 for(int i=1; i<sheetList.get(0).length; i++)
				 {
					 try{
					 System.out.println("table[i][4]--"+table[i][4]);
					 System.out.println("table[i][9]--"+table[i][9]);
					 System.out.println("table[i][11]--"+table[i][11]);
					 System.out.println("table[i][19]--"+table[i][19]);
					 if(table[i][15].toString().contains("."))
					 {
						 table[i][15] = table[i][15].toString().substring(0, table[i][15].toString().indexOf(".")); 
					 }
					 
					 /*System.out.println("table[i][15]"+table[i][15].toString());*/
					 System.out.println("table[i][8].toString()"+table[i][8].toString());
					 billingList =session.createCriteria(ReferralPatientBilling.class)
							 .createAlias("ReferralDetails", "dt")
							 .createAlias("dt.ReferralPatientHeader", "hd")
							 .add(Restrictions.eq("BillNo", table[i][8].toString().trim()))
							 .add(Restrictions.eq("dt.ReferralNo", table[i][10].toString().trim()))
					         .add(Restrictions.eq("hd.EmpNo", table[i][15].toString().trim())).list();
					 System.out.println("billingList"+billingList.size());
					 if(billingList.size()>0)
					 {
						 tx = session.beginTransaction();
						 ReferralPatientBilling billing = new ReferralPatientBilling();
						 billing = (ReferralPatientBilling)session.load(ReferralPatientBilling.class, billingList.get(0).getId());
						/* try
						 {	*/
						 if(!billing.getReferralDetails().getReferralPatientHeader().getApprovalStatus().equalsIgnoreCase("C"))
						 {
							 if(table[i][3]!=null && table[i][4]!=null && table[i][5]!=null && table[i][13]!=null && table[i][14]!=null && table[i][19]!=null 
							&& !table[i][3].toString().trim().equals("") && !table[i][4].toString().trim().equals("") && !table[i][5].toString().trim().equals("") && !table[i][13].toString().trim().equals("") && !table[i][14].toString().trim().equals("") && !table[i][19].toString().trim().equals(""))
							 {
							if(HMSUtil.dateFormatterddmmyy(table[i][4].toString())!=null || HMSUtil.dateFormatterddmmyy(table[i][19].toString())!=null) 
							{	 
						 billing.setCheckNo(table[i][3]!=null?table[i][3].toString():null);						 
						 billing.setCheckDate(table[i][4]!=null?HMSUtil.dateFormatterddmmyy(table[i][4].toString()):null);						 
						 billing.setCheckAmount(table[i][5]!=null?new BigDecimal(table[i][5].toString()):null);
						 billing.setTaxAmount(table[i][13]!=null?new BigDecimal(table[i][13].toString()):null);						
						 billing.setNetAmount(table[i][14]!=null?new BigDecimal(table[i][14].toString()):null);						 
						 billing.setErpPostingDate(table[i][19]!=null?HMSUtil.dateFormatterddmmyy(table[i][19].toString()):null);
						 billing.setErpUploadingDate(new Date());
						 hbt.save(billing);
						 billing.getReferralDetails().getReferralPatientHeader().setApprovalStatus("C");
						 totalUpdation++;
						 hbt.flush();
						 tx.commit();
						 totalUpdationMsg+="PB No:"+table[i][15].toString()+" Bill No:"+table[i][8].toString()+" Referral No: "+table[i][10].toString()+"<br>";
							}
						 else
						 {
							 flag = false;
							 failedUpdationMsg+="Date format is incorrect for PB No:"+table[i][15].toString()+" Bill No:"+table[i][8].toString()+" Referral No:"+table[i][10].toString()+"<br>";
							 failedUpdation++;
						 }
							 }
							 else
							 {
								 flag = false;
								 failedUpdationMsg+="There are blank fields for PB No:"+table[i][15].toString()+" Bill No:"+table[i][8].toString()+" Referral No:"+table[i][10].toString()+"<br>";
								 failedUpdation++;
							 }
						 }
						 else
						 {
							 flag = false;
							 alreadyUpdatedMsg+="PB No:"+table[i][15].toString()+" Bill No:"+table[i][8].toString()+" Referral No: "+table[i][10].toString()+"<br>";
								alreadyUpdated++;
						 }
						/* }
						 catch (Exception e) {
								e.printStackTrace();
								flag = false;
								failedUpdationMsg+="Check Data of PB No:"+table[i][15].toString()+" Bill No:"+table[i][8].toString()+" Referral No:"+table[i][10].toString()+"<br>";
								failedUpdation++;
						 }*/
					 }
						 
					 else
					 {
						 flag = false;
						 failedUpdationMsg+="Data not available in HMIS for PB No:"+table[i][15].toString()+" Bill No:"+table[i][8].toString()+" Referral No:"+table[i][10].toString()+"<br>";
						 failedUpdation++;
					 }
					
				 }
				 catch (Exception e) 
				 {
					 e.printStackTrace();
						flag = false;
						failedUpdationMsg+="Check Data of PB No:"+table[i][15].toString()+" Bill No:"+table[i][8].toString()+" Referral No:"+table[i][10].toString()+"<br>";
						failedUpdation++;
				 }
				 }
				/* if(!totalUpdationMsg.equals("")){
					 totalUpdationMsg = totalUpdationMsg.substring(0, (totalUpdationMsg.length()-2));
				 }*/
              /*   if(!totalUpdationMsg.equals("")){
	                 alreadyUpdatedMsg = alreadyUpdatedMsg.substring(0, (alreadyUpdatedMsg.length()-2));
				 }*/
               /*  if(!totalUpdationMsg.equals("")){
	                 failedUpdationMsg = failedUpdationMsg.substring(0, (failedUpdationMsg.length()-2));
                 }*/
				
				 message = "<br><font color = 'green'>Total Updation="+totalUpdation+"<br>"+totalUpdationMsg+"</font><br><font color = 'blue'>Already Updated ="+alreadyUpdated+"<br>"+alreadyUpdatedMsg+"</font><br><font color = 'red'>Failed Updation="+failedUpdation+"<br>(Note: There should be no blank space and date should be in correct format(dd-MM-yyyy))<br>"+failedUpdationMsg+"</font>";
				 if(flag)
				 {
					 message = "<font color = 'green'>All Bills Uploaded Successfully</font>";
				 }
				
				 
				 succesfullyAdded = true;
					
						
					
				 } catch (Exception e) {
					e.printStackTrace();
					succesfullyAdded = false;
				/*	if(tx!=null)
						tx.rollback();*/
					message = "Some Error Has occured! Kindly check excel file(There should be no blank space and date should be in correct format(dd-MM-yyyy))";
				}     
				finally
				{
					session.close();
					
				}
				map.put("succesfullyAdded", succesfullyAdded);	
				map.put("message", message);
		
				
		return map;
	}
	
	@Override
	public Map<String, Object> DeleteFromDatabase_AddRemoveGrid(Box box) {
		Map<String,Object> datamap = new HashMap<String,Object>();
		List<ReferralClarificationDetails> otherClariDetails = new ArrayList<ReferralClarificationDetails>();
		List<ReferralPatientBilling> billDetails = new ArrayList<ReferralPatientBilling>();
		List<ReferralClarificationDetails> clariDetails = new ArrayList<ReferralClarificationDetails>();
		
		
		
		Transaction tx = null;
		Session session = (Session) getSession();		
		boolean bSuccessfullyDelete = false;		
			
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		int Id = 0;
		
		Id = box.getInt("Id");
		
		
			try{
					
				
				tx = session.beginTransaction();
				clariDetails =  session.createCriteria(ReferralClarificationDetails.class)
						                           .add(Restrictions.eq("ReferralBilling.Id", Id))
						                           .list();	
                for(ReferralClarificationDetails rcd: clariDetails)
                {
                	int clariHeaderId = rcd.getClarificationHeader().getId();
                	otherClariDetails =  session.createCriteria(ReferralClarificationDetails.class)
    						.add(Restrictions.eq("ClarificationHeader.Id", clariHeaderId))
    						.list();	
               	 hbt.delete(rcd);	
					if(otherClariDetails.size()==1)
					{
						hbt.delete(rcd.getClarificationHeader());	
					}
                }
			
				
					
				 hbt.flush();
				 
				 
				billDetails =  session.createCriteria(ReferralPatientBilling.class)
						.add(Restrictions.eq("Id", Id))
						.list(); 
				
				if(billDetails.size() > 0)
				{
/*					billDetails.get(0).getReferralDetails().getReferralPatientHeader().setAdminBillAmt((billDetails.get(0).getReferralDetails().getReferralPatientHeader().getAdminBillAmt().subtract(billDetails.get(0).getAdminBillAmt())));
					billDetails.get(0).getReferralDetails().getReferralPatientHeader().setTotalBillAmt((billDetails.get(0).getReferralDetails().getReferralPatientHeader().getTotalBillAmt().subtract(billDetails.get(0).getTotalBillAmt())));*/
					hbt.deleteAll(billDetails);					
				}
				
			
			tx.commit();
			bSuccessfullyDelete = true;
			}catch(Exception e)
			{
				System.out.println("dd="+e);
				if (tx != null) {
					tx.rollback();
					e.printStackTrace();
					System.out.print(e);
				}
			}
		
		
		
		
		
		
			datamap.put("bSuccessfullyDelete", bSuccessfullyDelete);
		return datamap;
	}
	
	
	

	
}
