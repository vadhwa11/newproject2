
package jkt.hms.payroll.dataservice;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.HrMasBonus;
import jkt.hms.masters.business.HrMasItaxExemption;
import jkt.hms.masters.business.HrMasItaxSurcharge;
import jkt.hms.masters.business.HrMasLoan;
import jkt.hms.masters.business.HrMasPayElement;
import jkt.hms.masters.business.HrMasPayroll;
import jkt.hms.masters.business.HrMasReimbersement;
import jkt.hms.masters.business.HrMasSurcharge;
import jkt.hms.masters.business.MasGrade;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasStoreFinancial;
import jkt.hms.masters.business.Users;
import jkt.hms.util.HMSUtil;

import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class PayrollMastersDataServiceImpl extends HibernateDaoSupport implements PayrollMastersDataService {

	//Start code
	public Map<String, Object> showPayElementJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasPayElement> payElementList = new ArrayList<HrMasPayElement>();
		List<MasHospital> locationList = new ArrayList<MasHospital>();
		List<MasHospital> lList = new ArrayList<MasHospital>();
		Session session = (Session)getSession();
		payElementList = session.createCriteria(HrMasPayElement.class).list();
		locationList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).addOrder(Order.desc("HospitalName")).list();
		lList = session.createCriteria(MasHospital.class).list();
		
		
		map.put("payElementList", payElementList);
		map.put("locationList", locationList);
		map.put("lList", lList);
		return map;
	}

	@Override
	public Map<String, Object> duplicatePayElement(
			Map<String, Object> generalMap) {
		// TODO Auto-generated method stub

		String name = "";
		String code="";
		Map<String, Object> map = new HashMap<String, Object>();
		if(generalMap.get("name") != null){
			name = (String)generalMap.get("name");
		}
		if(generalMap.get("code") != null){
			code = (String)generalMap.get("code");
		}
		int locationId=0;
		if(generalMap.get("locationId") != null){
			locationId = (Integer)generalMap.get("locationId");
		}
		
		Session session = getSession();
		List<HrMasPayElement> duplicatePayElementList = new ArrayList<HrMasPayElement>();
		
		duplicatePayElementList=session.createCriteria(HrMasPayElement.class).add(Restrictions.eq("PayElementDesc",name)).add(Restrictions.eq("PayElementCode",code)).add(Restrictions.eq("Hospital.Id",locationId)).list();
		
		map.put("duplicatePayElementList", duplicatePayElementList);
		return map;
	
	}

	@Override
	public Map<String, Object> savePayElement(HrMasPayElement hrMasPayElement) {
		// TODO Auto-generated method stub

		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasPayElement> payElementList = new ArrayList<HrMasPayElement>();
		List<HrMasPayElement> existingPayElementList = new ArrayList<HrMasPayElement>();
		Session session = (Session)getSession();
		String message = "";
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
	
		hbt.save(hrMasPayElement);
		payElementList = session.createCriteria(HrMasPayElement.class).list();
		map.put("payElementList", payElementList);
		return map;
	
	}

	@Override
	public Map<String, Object> editPayElement(Map<String, Object> generalMap) {
		// TODO Auto-generated method stub

		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasPayElement> payElementList = new ArrayList<HrMasPayElement>();
		List<HrMasPayElement> existingPayElementList = new ArrayList<HrMasPayElement>();
		List<MasHospital> locationList = new ArrayList<MasHospital>();
		List<MasHospital> lList = new ArrayList<MasHospital>();
		
		Session session = (Session)getSession();
		int payElementId = 0;
		if (generalMap.get("payElementId")!= null) {
			payElementId = (Integer)generalMap.get("payElementId"); 
		}
		String payElementCode = "";
		if (generalMap.get("payElementCode")!= null) {
			payElementCode = (String)generalMap.get("payElementCode"); 
		}
		String payElementDescription = "";
		if (generalMap.get("payElementDescription")!= null) {
			payElementDescription = (String)generalMap.get("payElementDescription"); 
		}
		Date effectiveDate =new Date();
		if (generalMap.get("effectiveDate")!= null) {
			effectiveDate = (Date)generalMap.get("effectiveDate"); 
		}
		String payElementType = "";
		if (generalMap.get("payElementType")!= null) {
			payElementType = (String)generalMap.get("payElementType"); 
		}
		String taxableElement = "";
		if (generalMap.get("taxableElement")!= null) {
			taxableElement = (String)generalMap.get("taxableElement"); 
		}
		String otCalculation = "";
		if (generalMap.get("otCalculation")!= null) {
			otCalculation = (String)generalMap.get("otCalculation"); 
		}
		Float basicMultiplier = 0.0f;
		if (generalMap.get("basicMultiplier")!= null) {
			basicMultiplier = (Float)generalMap.get("basicMultiplier"); 
		}
		
		Float prevailingPercentage = 0.0f;
		if (generalMap.get("prevailingPercentage")!= null) {
			prevailingPercentage = (Float)generalMap.get("prevailingPercentage"); 
		}
		
		String arrearElement = "";
		if (generalMap.get("arrearElement")!= null) {
			arrearElement = (String)generalMap.get("arrearElement"); 
		}
		String reimbElement = "";
		if (generalMap.get("reimbElement")!= null) {
			reimbElement = (String)generalMap.get("reimbElement"); 
		}
		
		String basicDependent = "";
		if (generalMap.get("basicDependent")!= null) {
			basicDependent = (String)generalMap.get("basicDependent"); 
		}
		
		String valPrePercentage = "";
		if (generalMap.get("lblPrePercentage")!= null) {
			valPrePercentage = (String)generalMap.get("lblPrePercentage"); 
		}
		
		String showInPayslip = "";
		if (generalMap.get("showInPayslip")!= null) {
			showInPayslip = (String)generalMap.get("showInPayslip"); 
		}
		
		String pfDependent = "";
		if (generalMap.get("pfDependent")!= null) {
			pfDependent = (String)generalMap.get("pfDependent"); 
		}
		
		BigDecimal maxAmount = null;
		if (generalMap.get("maxAmount")!= null) {
			maxAmount = (BigDecimal)generalMap.get("maxAmount"); 
		}
		
		String ctcHeading = "";
		if (generalMap.get("ctcHeading")!= null) {
			ctcHeading = (String)generalMap.get("ctcHeading"); 
		}
		
		String payElementStatus = "";
		if (generalMap.get("payElementStatus")!= null) {
			payElementStatus = (String)generalMap.get("payElementStatus"); 
		}
		Date statusDate =new Date();
		if (generalMap.get("statusDate")!= null) {
			statusDate = (Date)generalMap.get("statusDate"); 
		}
	
		Date currentDate = null; 
		if (generalMap.get("currentDate")!= null) {
			currentDate = (Date)generalMap.get("currentDate"); 
		}
		String currentTime = "";
		if (generalMap.get("currentTime")!= null) {
			currentTime = (String)generalMap.get("currentTime"); 
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		HrMasPayElement hrMasPayElement = (HrMasPayElement)hbt.load(HrMasPayElement.class, payElementId);
		hrMasPayElement.setPayElementCode(payElementCode);
		hrMasPayElement.setPayElementDesc(payElementDescription);
		hrMasPayElement.setEffectiveDate(effectiveDate);
		hrMasPayElement.setPayElementType(payElementType);
		hrMasPayElement.setTaxableElement(taxableElement);
		hrMasPayElement.setOtCalculation(otCalculation);
		hrMasPayElement.setBasicMultiplier(basicMultiplier);
		hrMasPayElement.setArrearElement(arrearElement);
		hrMasPayElement.setReimbElement(reimbElement);
		hrMasPayElement.setBasicDependent(basicDependent);
		hrMasPayElement.setPfDependent(pfDependent);
		hrMasPayElement.setStatusDate(statusDate);
		hrMasPayElement.setMaxAmount(maxAmount);
		hrMasPayElement.setCtcHeading(ctcHeading);
		hrMasPayElement.setPayElementStatus(payElementStatus);
		hrMasPayElement.setPercentage(prevailingPercentage);
		hrMasPayElement.setPrevailingPercentage(valPrePercentage);
		
		int locationId = 0;
		if(generalMap.get("locationId")!=null){
			locationId = (Integer)generalMap.get("locationId");
		}
		System.out.println("locationId--"+locationId);
		MasHospital masHospital = new MasHospital();
		masHospital.setId(locationId);
		hrMasPayElement.setHospital(masHospital);
		
		int userId = 0;
		if(generalMap.get("userId")!=null){
			userId = (Integer)generalMap.get("userId");
		}
		if(userId !=0){
			Users users=new Users();
			users.setId(userId);
			hrMasPayElement.setLastChgBy(users);
			}
		hrMasPayElement.setLastChgDate(currentDate);
		hrMasPayElement.setLastChgTime(currentTime);
		hrMasPayElement.setShowInPayslip(showInPayslip);
	
		hbt.update(hrMasPayElement);
		payElementList = session.createCriteria(HrMasPayElement.class).list();
		map.put("payElementList", payElementList);
		map.put("locationList", locationList);
		map.put("lList", lList);
		return map;
	
	}

	@Override
	public Map<String, Object> deletePayElement(Map<String, Object> generalMap) {
		// TODO Auto-generated method stub

		Map<String,Object> map = new HashMap<String, Object>();
		List<HrMasPayElement> payElementList = new ArrayList<HrMasPayElement>();
		List<MasHospital> locationList = new ArrayList<MasHospital>();
		List<MasHospital> lList = new ArrayList<MasHospital>();
		
		Session session = (Session)getSession();
		 boolean dataDeleted=false;
		 int payElementId=0;
		if (generalMap.get("payElementId")!= null) {
			payElementId = (Integer)generalMap.get("payElementId"); 
		}
		
		Date currentDate = new Date(); 
		if (generalMap.get("currentDate")!= null) {
			currentDate = (Date)generalMap.get("currentDate"); 
		}
		String currentTime = "";
		if (generalMap.get("currentTime")!= null) {
			currentTime = (String)generalMap.get("currentTime"); 
		}
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		HrMasPayElement hrMasPayElement = (HrMasPayElement)hbt.load(HrMasPayElement.class, payElementId);
		int userId = 0;
		if(map.get("userId")!=null){
			userId = (Integer)map.get("userId");
		}
		if(userId !=0){
			Users users=new Users();
			users.setId(userId);
			hrMasPayElement.setLastChgBy(users);
			}
		hrMasPayElement.setLastChgDate(currentDate);
		hrMasPayElement.setLastChgTime(currentTime);
		if(generalMap.get("flag") != null){
			  String flag = (String)generalMap.get("flag");
			  if (flag.equals("InActivate")){
				  hrMasPayElement.setStatus("n");
				  hrMasPayElement.setPayElementStatus("InActive");
			   dataDeleted=true;
			  }else if(flag.equals("Activate")){
				  hrMasPayElement.setStatus("y");
				  hrMasPayElement.setPayElementStatus("Active");
				  dataDeleted=false;
			  }
		  }
		hbt.update(hrMasPayElement);
		String message = "";
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}

		else{
			message="Record is Activated successfully !!";
		}
		locationList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).addOrder(Order.desc("HospitalName")).list();
		lList = session.createCriteria(MasHospital.class).list();
		
		
		payElementList = session.createCriteria(HrMasPayElement.class).list();

		map.put("locationList", locationList);
		map.put("lList", lList);
		map.put("payElementList", payElementList);
		map.put("message", message);
		return map;
	
	}

	@Override
	public Map<String, Object> searchPayElement(String payElementCode,
			String payElementDescription) {
		// TODO Auto-generated method stub

		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasPayElement> payElementList = new ArrayList<HrMasPayElement>();
		List<MasHospital> locationList = new ArrayList<MasHospital>();
		List<MasHospital> lList = new ArrayList<MasHospital>();
		Session session = (Session)getSession();
			try{
			if((payElementCode==null) || (payElementDescription != null)){
				
				payElementList = session.createCriteria(HrMasPayElement.class).add(Restrictions.like("PayElementDesc",payElementDescription+"%")).addOrder( Property.forName("PayElementDesc").asc() ).list();
				System.out.println("in if");
			}
			else{
				payElementList = session.createCriteria(HrMasPayElement.class).add(Restrictions.like("PayElementCode",payElementCode+"%")).addOrder( Property.forName("PayElementCode").asc() ).list();
				System.out.println("in else");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		locationList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).addOrder(Order.desc("HospitalName")).list();
		lList = session.createCriteria(MasHospital.class).list();
			map.put("payElementList", payElementList);
			map.put("locationList", locationList);
			map.put("payElementCode", payElementCode);
			map.put("lList", lList);
			map.put("payElementDescription", payElementDescription);
		return map;
	
	}

	@Override
	public Map<String, Object> showPayrollJsp() {
		// TODO Auto-generated method stub

		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasPayroll> payrollList = new ArrayList<HrMasPayroll>();
		Session session = (Session)getSession();
		payrollList = session.createCriteria(HrMasPayroll.class).list();
		map.put("payrollList", payrollList);
		return map;
	
	}

	@Override
	public Map<String, Object> checkForExistingMasters(
			Map<String, Object> generalMap) {
		// TODO Auto-generated method stub

		Map<String,Object> map = new HashMap<String, Object>();
		List duplicateMastersList = new ArrayList();
		List duplicateGeneralNameList = new ArrayList();
		List duplicateGeneralCodeList = new ArrayList();
		List duplicateGeneralAddressList = new ArrayList();
		int id = 0;
		String pojoPropertyCode = "";
		String pojoPropertyAddress = "";
		String pojoPropertyName = "";
		if(generalMap.get("id") != null){
			id = (Integer)generalMap.get("id");
		}
		String name = (String)generalMap.get("name");
		String pojoName = (String)generalMap.get("pojoName");
		if(generalMap.get("pojoPropertyName") != null)
			pojoPropertyName = (String)generalMap.get("pojoPropertyName");
		
		if(generalMap.get("pojoPropertyCode") != null){
			pojoPropertyCode = (String)generalMap.get("pojoPropertyCode");
		}
		if(generalMap.get("pojoPropertyAddress") != null){
			pojoPropertyAddress = (String)generalMap.get("pojoPropertyAddress");
		}
		if(generalMap.get("flag") == null){
			String code = (String)generalMap.get("code");
			String address = (String)generalMap.get("address");
			
			if(!pojoPropertyCode.equals("")){
				duplicateGeneralCodeList = getHibernateTemplate().find("from jkt.hms.masters.business."+pojoName+" as g where g."+pojoPropertyCode+" ='"+code+"'");
			}
			if(!pojoPropertyName.equals("")){
				duplicateGeneralNameList = getHibernateTemplate().find("from jkt.hms.masters.business."+pojoName+" as g where g."+pojoPropertyName+" = '"+name+"'");
			}
			if(!pojoPropertyAddress.equals("")){
				duplicateGeneralAddressList = getHibernateTemplate().find("from jkt.hms.masters.business."+pojoName+" as g where g."+pojoPropertyAddress+" ='"+address+"'");
			}
			
		}
		else if(generalMap.get("flag") != null){
			boolean flag = (Boolean)generalMap.get("flag");
			duplicateMastersList = getHibernateTemplate().find("from jkt.hms.masters.business."+pojoName+" as g where g."+pojoPropertyName+" = '"+name+"' and g.Id != "+id);
		}
		map.put("duplicateGeneralNameList", duplicateGeneralNameList);
		map.put("duplicateGeneralCodeList", duplicateGeneralCodeList);
		map.put("duplicateGeneralAddressList", duplicateGeneralAddressList);
		map.put("duplicateMastersList", duplicateMastersList);

		return map;
	
	}

	@Override
	public Map<String, Object> savePayroll(HrMasPayroll hrMasPayroll) {
		// TODO Auto-generated method stub

		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasPayroll> payrollList = new ArrayList<HrMasPayroll>();
		List<HrMasPayroll> existingpayrollList = new ArrayList<HrMasPayroll>();
		Session session = (Session)getSession();
		String message = "";
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(hrMasPayroll);
		payrollList = session.createCriteria(HrMasPayroll.class).list();
		map.put("payrollList", payrollList);
		return map;
	
	}

	@Override
	public Map<String, Object> editPayroll(Map<String, Object> generalMap) {
		// TODO Auto-generated method stub

		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasPayroll> payrollList = new ArrayList<HrMasPayroll>();
		List<HrMasPayroll> existingPayrollList = new ArrayList<HrMasPayroll>();
		Session session = (Session)getSession();
		int payrollId = 0;
		if (generalMap.get("payrollId")!= null) {
			payrollId = (Integer)generalMap.get("payrollId"); 
		}
		String payrollCode = "";
		if (generalMap.get("payrollCode")!= null) {
			payrollCode = (String)generalMap.get("payrollCode"); 
		}
		String payrollDescription = "";
		if (generalMap.get("payrollDescription")!= null) {
			payrollDescription = (String)generalMap.get("payrollDescription"); 
		}
		Date fromDate =new Date();
		if (generalMap.get("fromDate")!= null) {
			fromDate = (Date)generalMap.get("fromDate"); 
		}
		
		Date toDate =new Date();
		if (generalMap.get("toDate")!= null) {
			toDate = (Date)generalMap.get("toDate"); 
		}
		String frequency = "";
		if (generalMap.get("frequency")!= null) {
			frequency = (String)generalMap.get("frequency"); 
		}
		
		Date currentDate = null; 
		if (generalMap.get("currentDate")!= null) {
			currentDate = (Date)generalMap.get("currentDate"); 
		}
		String currentTime = "";
		if (generalMap.get("currentTime")!= null) {
			currentTime = (String)generalMap.get("currentTime"); 
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		HrMasPayroll hrMasPayroll = (HrMasPayroll)hbt.load(HrMasPayroll.class, payrollId);
		hrMasPayroll.setPayrollCode(payrollCode);
		hrMasPayroll.setPayrollDescription(payrollDescription);
		hrMasPayroll.setFromDate(fromDate);
		hrMasPayroll.setToDate(toDate);
		hrMasPayroll.setFrequency(frequency);
		int userId = 0;
		if(map.get("userId")!=null){
			userId = (Integer)map.get("userId");
		}
		if(userId !=0){
			Users users=new Users();
			users.setId(userId);
			hrMasPayroll.setLastChgBy(users);
			}
		hrMasPayroll.setLastChgDate(currentDate);
		hrMasPayroll.setLastChgTime(currentTime);
		hbt.update(hrMasPayroll);
			
		payrollList = session.createCriteria(HrMasPayroll.class).list();
		map.put("payrollList", payrollList);
		return map;
		
	}

	@Override
	public Map<String, Object> deletePayroll(Map<String, Object> generalMap) {
		// TODO Auto-generated method stub

		Map<String,Object> map = new HashMap<String, Object>();
		List<HrMasPayroll> payrollList = new ArrayList<HrMasPayroll>();
		Session session = (Session)getSession();
		 boolean dataDeleted=false;
		 int payrollId=0;
		if (generalMap.get("payrollId")!= null) {
			payrollId = (Integer)generalMap.get("payrollId"); 
		}
		
		Date currentDate = new Date(); 
		if (generalMap.get("currentDate")!= null) {
			currentDate = (Date)generalMap.get("currentDate"); 
		}
		String currentTime = "";
		if (generalMap.get("currentTime")!= null) {
			currentTime = (String)generalMap.get("currentTime"); 
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		HrMasPayroll hrMasPayroll = (HrMasPayroll)hbt.load(HrMasPayroll.class, payrollId);
		int userId = 0;
		if(map.get("userId")!=null){
			userId = (Integer)map.get("userId");
		}
		if(userId !=0){
			Users users=new Users();
			users.setId(userId);
			hrMasPayroll.setLastChgBy(users);
			}
		hrMasPayroll.setLastChgDate(currentDate);
		hrMasPayroll.setLastChgTime(currentTime);
		if(generalMap.get("flag") != null){
			  String flag = (String)generalMap.get("flag");
			  if (flag.equals("InActivate")){
				  hrMasPayroll.setStatus("n");
			   dataDeleted=true;
			  }else if(flag.equals("Activate")){
				  hrMasPayroll.setStatus("y");
				  dataDeleted=false;
			  }
		  }
		hbt.update(hrMasPayroll);
		String message = "";
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}

		else{
			message="Record is Activated successfully !!";
		}
		payrollList = session.createCriteria(HrMasPayroll.class).list();
		map.put("payrollList", payrollList);
		map.put("message", message);
		return map;
	
	}

	@Override
	public Map<String, Object> searchPayroll(String payrollCode,
			String payrollDescription) {
		// TODO Auto-generated method stub

		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasPayroll> payrollList = new ArrayList<HrMasPayroll>();
		Session session = (Session)getSession();
			try{
			if((payrollCode==null) || (payrollDescription != null)){
				
				payrollList = session.createCriteria(HrMasPayroll.class).add(Restrictions.like("PayrollDescription",payrollDescription+"%")).addOrder( Property.forName("PayrollDescription").asc() ).list();
				System.out.println("in if");
			}
			else{
				payrollList = session.createCriteria(HrMasPayroll.class).add(Restrictions.like("PayrollCode",payrollCode+"%")).addOrder( Property.forName("PayrollCode").asc() ).list();
				System.out.println("in else");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
			map.put("payrollList", payrollList);
			map.put("payrollCode", payrollCode);
			map.put("payrollDescription", payrollDescription);
		return map;
	
	}

	@Override
	public Map<String, Object> showLoanJsp() {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasLoan> loanList = new ArrayList<HrMasLoan>(); 
		Session session = (Session)getSession();
		loanList = session.createCriteria(HrMasLoan.class).list();
		map.put("loanList", loanList);
		return map;
	}

	@Override
	public Map<String, Object> saveLoan(HrMasLoan hrMasLoan) {
		// TODO Auto-generated method stub

		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<HrMasLoan> existingLoanList = new ArrayList<HrMasLoan>();
		List<HrMasLoan> loanList = new ArrayList<HrMasLoan>(); 
		String message = "";
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(hrMasLoan);
		loanList = session.createCriteria(HrMasLoan.class).list();
		map.put("loanList", loanList);
		return map;
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> editLoan(Map<String, Object> generalMap) {
		// TODO Auto-generated method stub

		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasLoan> loanList = new ArrayList<HrMasLoan>();
		List<HrMasLoan> existingloanList = new ArrayList<HrMasLoan>();
		Session session = (Session)getSession();
		int loanId = 0;
		if (generalMap.get("loanId")!= null) {
			loanId = (Integer)generalMap.get("loanId"); 
		}
		String loanCode = "";
		if (generalMap.get("loanCode")!= null) {
			loanCode = (String)generalMap.get("loanCode"); 
		}
		String loanDescription = "";
		if (generalMap.get("loanDescription")!= null) {
			loanDescription = (String)generalMap.get("loanDescription"); 
		}
		
		BigDecimal maxAmount = null;
		if (generalMap.get("maxAmount")!= null) {
			maxAmount = (BigDecimal)generalMap.get("maxAmount"); 
		}
		Float interestPercent = null;
		if (generalMap.get("interestPercent")!= null) {
			interestPercent = (Float)generalMap.get("interestPercent"); 
		}
		
		Date currentDate = null; 
		if (generalMap.get("currentDate")!= null) {
			currentDate = (Date)generalMap.get("currentDate"); 
		}
		String currentTime = "";
		if (generalMap.get("currentTime")!= null) {
			currentTime = (String)generalMap.get("currentTime"); 
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		HrMasLoan hrMasLoan = (HrMasLoan)hbt.load(HrMasLoan.class, loanId);
		hrMasLoan.setLoanCode(loanCode);
		hrMasLoan.setLoanDescription(loanDescription);
		hrMasLoan.setMaxAmount(maxAmount);
		hrMasLoan.setInterestPercent(interestPercent);
		int userId = 0;
		if(map.get("userId")!=null){
			userId = (Integer)map.get("userId");
		}
		if(userId !=0){
			Users users=new Users();
			users.setId(userId);
			hrMasLoan.setLastChgBy(users);
			}
		hrMasLoan.setLastChgTime(currentTime);
		hrMasLoan.setLastChgDate(currentDate);
		
		
			hbt.update(hrMasLoan);
			hbt.refresh(hrMasLoan);
		loanList = session.createCriteria(HrMasLoan.class).list();
		map.put("loanList", loanList);
		return map;
	
	}

	@Override
	public Map<String, Object> deleteLoan(Map<String, Object> generalMap) {
		// TODO Auto-generated method stub

		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasLoan> loanList = new ArrayList<HrMasLoan>();
		Session session = (Session)getSession();
		 boolean dataDeleted=false;
		 int loanId=0;
		if (generalMap.get("loanId")!= null) {
			loanId = (Integer)generalMap.get("loanId"); 
		}
		
		Date currentDate = new Date(); 
		if (generalMap.get("currentDate")!= null) {
			currentDate = (Date)generalMap.get("currentDate"); 
		}
		String currentTime = "";
		if (generalMap.get("currentTime")!= null) {
			currentTime = (String)generalMap.get("currentTime"); 
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		HrMasLoan hrMasLoan = (HrMasLoan)hbt.load(HrMasLoan.class, loanId);
		int userId = 0;
		if(map.get("userId")!=null){
			userId = (Integer)map.get("userId");
		}
		if(userId !=0){
			Users users=new Users();
			users.setId(userId);
			hrMasLoan.setLastChgBy(users);
			}
		hrMasLoan.setLastChgDate(currentDate);
		hrMasLoan.setLastChgTime(currentTime);
		if(generalMap.get("flag") != null){
			  String flag = (String)generalMap.get("flag");
			  if (flag.equals("InActivate")){
				  hrMasLoan.setStatus("n");
			   dataDeleted=true;
			  }else if(flag.equals("Activate")){
				  hrMasLoan.setStatus("y");
				  dataDeleted=false;
			  }
		  }
		hbt.update(hrMasLoan);
		String message = "";
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}

		else{
			message="Record is Activated successfully !!";
		}
		loanList = session.createCriteria(HrMasLoan.class).list();
		map.put("loanList", loanList);
		map.put("message", message);
		return map;
	
	}

	@Override
	public Map<String, Object> searchLoan(String loanCode,
			String loanDescription) {
		// TODO Auto-generated method stub

		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasLoan> loanList = new ArrayList<HrMasLoan>();
		Session session = (Session)getSession();
			try{
			if((loanCode==null) || (loanDescription != null)){
				
				loanList = getHibernateTemplate().find("from jkt.hms.masters.business.HrMasLoan ml where ml.LoanDescription like '"+ loanDescription+"%' order by ml.LoanDescription");
			}
			else{
				loanList=getHibernateTemplate().find("from jkt.hms.masters.business.HrMasLoan ml where ml.LoanCode like '"+ loanCode+"' order by ml.LoanCode");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		map.put("loanList", loanList);
		map.put("loanCode", loanCode);
		map.put("loanDescription", loanDescription);
		return map;
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showReimbersementJsp() {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasReimbersement> reimbList = new ArrayList<HrMasReimbersement>(); 
		Session session = (Session)getSession();
		reimbList = session.createCriteria(HrMasReimbersement.class).list();
		map.put("reimbList", reimbList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> saveReimbersement(
			HrMasReimbersement hrMasReimbersement) {
		// TODO Auto-generated method stub

		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<HrMasReimbersement> reimbList = new ArrayList<HrMasReimbersement>(); 
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(hrMasReimbersement);
		reimbList = session.createCriteria(HrMasReimbersement.class).list();
		map.put("reimbList", reimbList);
		return map;
	
	}

	@Override
	public Map<String, Object> editReimbersement(Map<String, Object> generalMap) {
		// TODO Auto-generated method stub

		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasReimbersement> existingReimbList = new ArrayList<HrMasReimbersement>();
		List<HrMasReimbersement> reimbList = new ArrayList<HrMasReimbersement>();
		Session session = (Session)getSession();
		int	reimbId = 0;
		if (generalMap.get("reimbId")!= null) {
			reimbId = (Integer)generalMap.get("reimbId");
		}
		String	reimbCode = "";
		if (generalMap.get("reimbCode")!= null) {
			reimbCode = (String)generalMap.get("reimbCode");
		}
		String	reimbDescription = "";
		if (generalMap.get("reimbDescription")!= null) {
			reimbDescription = (String)generalMap.get("reimbDescription");
		}
		BigDecimal maxAmount = null;
		if (generalMap.get("maxAmount")!= null) {
			maxAmount = (BigDecimal)generalMap.get("maxAmount");
		}
		String taxable = "";
		if (generalMap.get("taxable")!= null) {
			taxable = (String)generalMap.get("taxable");
		}
		BigDecimal maxTaxExemption = null;
		if (generalMap.get("maxTaxExemption")!= null) {
			maxTaxExemption = (BigDecimal)generalMap.get("maxTaxExemption");
		}
		String carryForward = "";
		if (generalMap.get("carryForward")!= null) {
			carryForward = (String)generalMap.get("carryForward");
		}
		
		Date currentDate = null; 
		if (generalMap.get("currentDate")!= null) {
			currentDate = (Date)generalMap.get("currentDate"); 
		}
		String currentTime = "";
		if (generalMap.get("currentTime")!= null) {
			currentTime = (String)generalMap.get("currentTime"); 
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		HrMasReimbersement hrMasReimbersement = (HrMasReimbersement)hbt.load(HrMasReimbersement.class, reimbId);
			hrMasReimbersement.setReimbCode(reimbCode);
			hrMasReimbersement.setReimbDesc(reimbDescription);
			hrMasReimbersement.setMaxAmount(maxAmount);
			hrMasReimbersement.setTaxable(taxable);
			hrMasReimbersement.setMaxTaxExemption(maxTaxExemption);
			hrMasReimbersement.setCarryForward(carryForward);
			int userId = 0;
			if(map.get("userId")!=null){
				userId = (Integer)map.get("userId");
			}
			if(userId !=0){
				Users users=new Users();
				users.setId(userId);
				hrMasReimbersement.setLastChgBy(users);
				}
			hrMasReimbersement.setLastChgDate(currentDate);
			hrMasReimbersement.setLastChgTime(currentTime);
		
			hbt.update(hrMasReimbersement);
			reimbList = session.createCriteria(HrMasReimbersement.class).list();
		map.put("reimbList", reimbList);
		return map;
	
	}

	@Override
	public Map<String, Object> deleteReimbersement(
			Map<String, Object> generalMap) {
		// TODO Auto-generated method stub

		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasReimbersement> reimbList = new ArrayList<HrMasReimbersement>();
		Session session = (Session)getSession();
		 boolean dataDeleted=false;
		 int reimbId=0;
		if (generalMap.get("reimbId")!= null) {
			reimbId = (Integer)generalMap.get("reimbId"); 
		}
	
		Date currentDate = new Date(); 
		if (generalMap.get("currentDate")!= null) {
			currentDate = (Date)generalMap.get("currentDate"); 
		}
		String currentTime = "";
		if (generalMap.get("currentTime")!= null) {
			currentTime = (String)generalMap.get("currentTime"); 
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		HrMasReimbersement hrMasReimbersement= (HrMasReimbersement)hbt.load(HrMasReimbersement.class, reimbId);
		int userId = 0;
		if(map.get("userId")!=null){
			userId = (Integer)map.get("userId");
		}
		if(userId !=0){
			Users users=new Users();
			users.setId(userId);
			hrMasReimbersement.setLastChgBy(users);
			}
		hrMasReimbersement.setLastChgDate(currentDate);
		hrMasReimbersement.setLastChgTime(currentTime);
		if(generalMap.get("flag") != null){
			  String flag = (String)generalMap.get("flag");
			  if (flag.equals("InActivate")){
				  hrMasReimbersement.setStatus("n");
			   dataDeleted=true;
			  }else if(flag.equals("Activate")){
				  hrMasReimbersement.setStatus("y");
				  dataDeleted=false;
			  }
		  }
		hbt.update(hrMasReimbersement);
		String message = "";
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}

		else{
			message="Record is Activated successfully !!";
		}
		reimbList = session.createCriteria(HrMasReimbersement.class).list();
		map.put("reimbList", reimbList);
		map.put("message", message);
		return map;
	
	}

	@Override
	public Map<String, Object> searchReimbersement(String reimbCode,
			String reimbDescription) {
		// TODO Auto-generated method stub

		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasReimbersement> reimbList = new ArrayList<HrMasReimbersement>();
		Session session = (Session)getSession();
			try{
			if((reimbCode==null) || (reimbDescription != null)){
				
				reimbList = getHibernateTemplate().find("from jkt.hms.masters.business.HrMasReimbersement reimb where reimb.ReimbDesc like '"+ reimbDescription+"%' order by reimb.ReimbDesc");
			}
			else{
				reimbList=getHibernateTemplate().find("from jkt.hms.masters.business.HrMasReimbersement reimb where reimb.ReimbCode like '"+ reimbCode+"%' order by reimb.ReimbCode");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		map.put("reimbList", reimbList);
		map.put("reimbCode", reimbCode);
		map.put("reimbDescription", reimbDescription);
		return map;
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showBonusJsp() {
		// TODO Auto-generated method stub

		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasBonus> bonusList = new ArrayList<HrMasBonus>();
		List<MasGrade> gradeList = new ArrayList<MasGrade>();
		bonusList = getHibernateTemplate().find("from jkt.hms.masters.business.HrMasBonus as bonus ");
		gradeList = getHibernateTemplate().find("from jkt.hms.masters.business.MasGrade");
		map.put("bonusList", bonusList);
		map.put("gradeList", gradeList);
		return map;
	
	}
	
	@Override
	public Map<String, Object> saveBonus(HrMasBonus hrMasBonus) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasBonus> bonusList = new ArrayList<HrMasBonus>();
		List<HrMasBonus> existingBonusList = new ArrayList<HrMasBonus>();
		List<MasGrade> gradeList = new ArrayList<MasGrade>();
		String message = "";
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
			hbt.save(hrMasBonus);
		bonusList = getHibernateTemplate().find("from jkt.hms.masters.business.HrMasBonus");
		gradeList = getHibernateTemplate().find("from jkt.hms.masters.business.MasGrade");
		map.put("gradeList", gradeList);
		map.put("bonusList", bonusList);
		return map;
	}

	@Override
	public Map<String, Object> editBonus(Map<String, Object> generalMap) {
		Map<String,Object> map = new HashMap<String, Object>();
		List<HrMasBonus> bonusList = new ArrayList<HrMasBonus>();
		List<MasGrade> gradeList = new ArrayList<MasGrade>();
		Session session = (Session)getSession();
		int bonusId = 0;
		if (generalMap.get("bonusId")!= null) {
			bonusId = (Integer)generalMap.get("bonusId"); 
		}
		String bonusCode = "";
		if (generalMap.get("bonusCode")!= null) {
			bonusCode = (String)generalMap.get("bonusCode"); 
		}
		String bonusDescription = "";
		if (generalMap.get("bonusDescription")!= null) {
			bonusDescription = (String)generalMap.get("bonusDescription"); 
		}
		Date fromDate =new Date();
		if (generalMap.get("fromDate")!= null) {
			fromDate = (Date)generalMap.get("fromDate"); 
		}
		Date toDate =new Date();
		if (generalMap.get("toDate")!= null) {
			toDate = (Date)generalMap.get("toDate"); 
		}
		Date dueDate =new Date();
		if (generalMap.get("dueDate")!= null) {
			dueDate = (Date)generalMap.get("dueDate"); 
		}
		String bonusType = "";
		if (generalMap.get("bonusType")!= null) {
			bonusType = (String)generalMap.get("bonusType"); 
		}
		String paymentFrequency = "";
		if (generalMap.get("paymentFrequency")!= null) {
			paymentFrequency = (String)generalMap.get("paymentFrequency"); 
		}
		
		Float bonusRate =null;
		if (generalMap.get("bonusRate")!= null) {
			bonusRate = (Float)generalMap.get("bonusRate"); 
		}
		BigDecimal fixedAmount = null;
		if (generalMap.get("fixedAmount")!= null) {
			fixedAmount = (BigDecimal)generalMap.get("fixedAmount"); 
		}
		BigDecimal maxBasic = null;
		if (generalMap.get("maxBasic")!= null) {
			maxBasic = (BigDecimal)generalMap.get("maxBasic"); 
		}
		int gradeId = 0;
		if (generalMap.get("gradeId")!= null) {
			gradeId = (Integer)generalMap.get("gradeId"); 
		}
		String taxable = "";
		if (generalMap.get("taxable")!= null) {
			taxable = (String)generalMap.get("taxable"); 
		}
			
		Date currentDate = null; 
		if (generalMap.get("currentDate")!= null) {
			currentDate = (Date)generalMap.get("currentDate"); 
		}
		String currentTime = "";
		if (generalMap.get("currentTime")!= null) {
			currentTime = (String)generalMap.get("currentTime"); 
		}
		int userId = 0;
		if(map.get("userId")!=null){
			userId = (Integer)map.get("userId");
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		HrMasBonus hrMasBonus= (HrMasBonus)hbt.load(HrMasBonus.class, bonusId);
		hrMasBonus.setBonusCode(bonusCode);
		hrMasBonus.setDescription(bonusDescription);
		hrMasBonus.setFromDate(fromDate);
		hrMasBonus.setToDate(toDate);
		hrMasBonus.setDueDate(dueDate);
		hrMasBonus.setPaymentFrequency(paymentFrequency);
		hrMasBonus.setBonusType(bonusType);
		hrMasBonus.setBonusRate(bonusRate);
		hrMasBonus.setFixedAmount(fixedAmount);
		hrMasBonus.setMaxBasic(maxBasic);
		
		MasGrade masGrade = new MasGrade();
		masGrade.setId(gradeId);
		hrMasBonus.setGrade(masGrade);
		hrMasBonus.setTaxable(taxable);
		
		if(userId !=0){
			Users users=new Users();
			users.setId(userId);
			hrMasBonus.setLastChgBy(users);
			}
		hrMasBonus.setLastChgDate(currentDate);
		hrMasBonus.setLastChgTime(currentTime);
		hbt.update(hrMasBonus);
		bonusList = session.createCriteria(HrMasBonus.class).list();
		gradeList = getHibernateTemplate().find("from jkt.hms.masters.business.MasGrade");
		map.put("gradeList", gradeList);
		map.put("bonusList", bonusList);
		return map;
	}
	
	@Override
	public Map<String, Object> deleteBonus(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasBonus> bonusList = new ArrayList<HrMasBonus>();
		Session session = (Session)getSession();
		 boolean dataDeleted=false;
		 int bonusId=0;
		if (generalMap.get("bonusId")!= null) {
			bonusId = (Integer)generalMap.get("bonusId"); 
		}
		
		Date currentDate = new Date(); 
		if (generalMap.get("currentDate")!= null) {
			currentDate = (Date)generalMap.get("currentDate"); 
		}
		String currentTime = "";
		if (generalMap.get("currentTime")!= null) {
			currentTime = (String)generalMap.get("currentTime"); 
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		HrMasBonus hrMasBonus = (HrMasBonus)hbt.load(HrMasBonus.class, bonusId);
		int userId = 0;
		if(map.get("userId")!=null){
			userId = (Integer)map.get("userId");
		}
		if(userId !=0){
			Users users=new Users();
			users.setId(userId);
			hrMasBonus.setLastChgBy(users);
			}
		hrMasBonus.setLastChgDate(currentDate);
		hrMasBonus.setLastChgTime(currentTime);
		if(generalMap.get("flag") != null){
			  String flag = (String)generalMap.get("flag");
			  if (flag.equals("InActivate")){
				  hrMasBonus.setStatus("n");
			   dataDeleted=true;
			  }else if(flag.equals("Activate")){
				  hrMasBonus.setStatus("y");
				  dataDeleted=false;
			  }
		  }
		hbt.update(hrMasBonus);
		String message = "";
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}

		else{
			message="Record is Activated successfully !!";
		}
		bonusList = session.createCriteria(HrMasBonus.class).list();
		map.put("bonusList", bonusList);
		map.put("message", message);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> searchBonus(String bonusCode,String bonusDescription) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasBonus> bonusList = new ArrayList<HrMasBonus>();
			try{
			if((bonusCode==null) || (bonusDescription != null)){
				
				bonusList = getHibernateTemplate().find("from jkt.hms.masters.business.HrMasBonus mb where mb.Description like '"+ bonusDescription+"%' order by mb.Description");
			}
			else{
				bonusList=getHibernateTemplate().find("from jkt.hms.masters.business.HrMasBonus mb where mb.BonusCode like '"+ bonusCode+"' order by mb.BonusCode");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
			
			List<MasGrade> gradeList = new ArrayList<MasGrade>();
			gradeList = getHibernateTemplate().find("from jkt.hms.masters.business.MasGrade");
			map.put("gradeList", gradeList);
			map.put("bonusList", bonusList);
			map.put("bonusCode", bonusCode);
			map.put("bonusDescription", bonusDescription);
			return map;
	}

	@Override
	public Map<String, Object> showIncomeTaxExemptJsp() {
		// TODO Auto-generated method stub

		Map map = new HashMap();
		Session session = (Session)getSession();
		List<HrMasItaxExemption> searchItaxExemptMasterList = session.createCriteria(HrMasItaxExemption.class).list();
		List<MasStoreFinancial> hrMasFinancialYearList = session.createCriteria(MasStoreFinancial.class).add(Restrictions.eq("Status", "y")).list();
		if(searchItaxExemptMasterList != null)
		{
			map.put("searchItaxExemptMasterList",searchItaxExemptMasterList);
		}
		if(hrMasFinancialYearList != null)
		{
			map.put("hrMasFinancialYearList",hrMasFinancialYearList);
		}
		return map;
	
	}

	@Override
	public Map<String, Object> searchIncomeTaxExemptMaster(String financialYear) {
		// TODO Auto-generated method stub

		Session session = (Session)getSession();
		List<HrMasItaxExemption> searchItaxExemptMasterList = new ArrayList<HrMasItaxExemption>();
		List<MasStoreFinancial> hrMasFinancialYearList = session.createCriteria(MasStoreFinancial.class).add(Restrictions.eq("Status", "y")).list(); 
		Map<String, Object> generalMap =new HashMap<String, Object>();
	
		if(hrMasFinancialYearList != null)
		{
			generalMap.put("hrMasFinancialYearList",hrMasFinancialYearList);
		}
		
		Integer fYear =  Integer.parseInt(financialYear);
		try {
			if(fYear != null) {
				
				searchItaxExemptMasterList =session.createCriteria(HrMasItaxExemption.class).add(Restrictions.eq("FinancialYear.Id",fYear )).list();
				}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
			
	
		generalMap.put("searchItaxExemptMasterList", searchItaxExemptMasterList);
		return generalMap;
	
	}

	@Override
	public Map<String, Object> copyIncomeTaxExemptMaster(int copyFromYear,
			int copyToYear) {
		// TODO Auto-generated method stub
		String msg = "";
		boolean dataCopied=false;
		Date   currentDate = new Date();
		String currentTime = "";
		currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		String changedBy = "";
		
		String sectionCode="";
		String secDesc="";
		BigDecimal maxExemption;
		BigDecimal minAmt;
		BigDecimal maxAmt;
		BigDecimal exemptionPercent;
		String exemptionBase="";
		
		Session session = (Session)getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		List<HrMasItaxExemption> prevItaxExemptMasterList = new ArrayList<HrMasItaxExemption>();
		List<HrMasItaxExemption> newItaxExemptMasterList = new ArrayList<HrMasItaxExemption>();
		List<HrMasItaxExemption> searchItaxExemptMasterList = new ArrayList<HrMasItaxExemption>();
		MasStoreFinancial hrMasFinancialYear = new MasStoreFinancial();

		
		List<MasStoreFinancial> hrMasFinancialYearList = session.createCriteria(MasStoreFinancial.class).add(Restrictions.eq("Status", "y")).list(); 
		Map<String, Object> generalMap =new HashMap<String, Object>();
	
		if(hrMasFinancialYearList != null)
		{
			generalMap.put("hrMasFinancialYearList",hrMasFinancialYearList);
		}
		
		Integer fYear =  copyFromYear;
		try {
			if(fYear != null) {
				
				prevItaxExemptMasterList = session.createCriteria(HrMasItaxExemption.class).add(Restrictions.eq("FinancialYear.Id",fYear )).list();
			}
			Integer tYear =  copyToYear;
			if(tYear != null) {
				newItaxExemptMasterList = session.createCriteria(HrMasItaxExemption.class).add(Restrictions.eq("FinancialYear.Id",tYear )).list();
			}
			
			
			if(prevItaxExemptMasterList.size() <= 0){
				msg = "From Year Having no records";
			}
			else if(newItaxExemptMasterList.size() > 0){
				msg = "Already Records Exist for To Year";
			}
			
			if((prevItaxExemptMasterList.size() > 0) && (newItaxExemptMasterList.size() <= 0)) {
				
				hrMasFinancialYear.setId(tYear);
				for(HrMasItaxExemption prevHrMasItaxExemption : prevItaxExemptMasterList){
					HrMasItaxExemption itaxExemptMasterObj = new HrMasItaxExemption();
					sectionCode = prevHrMasItaxExemption.getSectionCode();
					secDesc     = prevHrMasItaxExemption.getSectionDesc();
					maxExemption = prevHrMasItaxExemption.getMaxExemption();
					maxAmt       = prevHrMasItaxExemption.getMaximumAmt();
					minAmt       = prevHrMasItaxExemption.getMinimumAmt();
					exemptionPercent = prevHrMasItaxExemption.getExemptionPercentage();
					exemptionBase    = prevHrMasItaxExemption.getExemptionBase();
					
					itaxExemptMasterObj.setExemptionBase(exemptionBase);
					itaxExemptMasterObj.setExemptionPercentage(exemptionPercent);
					itaxExemptMasterObj.setSectionCode(sectionCode);
					itaxExemptMasterObj.setSectionDesc(secDesc);
					itaxExemptMasterObj.setMaxExemption(maxExemption);
					itaxExemptMasterObj.setMaximumAmt(maxAmt);
					itaxExemptMasterObj.setMinimumAmt(minAmt);
					itaxExemptMasterObj.setStatus("y");
					itaxExemptMasterObj.setLastChgDate(currentDate);
					itaxExemptMasterObj.setLastChgTime(currentTime);
					itaxExemptMasterObj.setFinancialYear(hrMasFinancialYear);
					
					hbt.save(itaxExemptMasterObj);
					hbt.refresh(itaxExemptMasterObj);
					msg = "Data Update Successfully"; 
					searchItaxExemptMasterList =session.createCriteria(HrMasItaxExemption.class).add(Restrictions.eq("FinancialYear.Id",tYear )).list();
				
				}
			}
				
			
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		generalMap.put("searchItaxExemptMasterList", searchItaxExemptMasterList);
		generalMap.put("message",msg);	
		return generalMap;
	
	}

	@Override
	public Map<String, Object> existingIncomeTaxExemptJsp(
			Map<String, Object> generalMap) {
		// TODO Auto-generated method stub

		String name = "";
		String code="";
		Map<String, Object> map = new HashMap<String, Object>();
		if(generalMap.get("name") != null){
			name = (String)generalMap.get("name");
		}
		if(generalMap.get("code") != null){
			code = (String)generalMap.get("code");
		}
		Session session = getSession();
		List<HrMasItaxExemption> incomeTaxExempTypeList = new ArrayList<HrMasItaxExemption>();
		
		incomeTaxExempTypeList=session.createCriteria(HrMasItaxExemption.class).add(Restrictions.eq("FinancialYear.Id",new Integer(name))).add(Restrictions.eq("SectionCode",code)).list();
		
		map.put("incomeTaxExempTypeList", incomeTaxExempTypeList);
		return map;
	
	}

	@Override
	public boolean addIncomeTaxExemptMaster(
			HrMasItaxExemption hrMasItaxExemption) {
		// TODO Auto-generated method stub

		boolean successfullyAdded = false;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(hrMasItaxExemption);
		hbt.refresh(hrMasItaxExemption);
		successfullyAdded =true;
		
		return successfullyAdded;
	
	}

	@Override
	public boolean editIncomeTaxExemptMaster(Map<String, Object> map) {
		// TODO Auto-generated method stub

		boolean dataUpdated=false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		String sectionCode="";
		String financialyear="";
		int hospitalId=0;
		int id=0;
		String minAmt="";
		String maxAmt="";
		String exemptionBase="";
		String exemptionPercent="";
		String maxExemption="";
		Date changedDate = null;
		String changedTime = "";
		String secDesc="";
		try {
			id=(Integer)map.get("id");
		
			sectionCode=(String)map.get("code");
			secDesc=(String)map.get("secDesc");
			financialyear=(String)map.get("name");
			minAmt=(String)map.get("minAmt");	
			maxAmt = (String)map.get("maxAmt");
			exemptionBase = (String)map.get("exemptionBase");
			exemptionPercent = (String)map.get("exemptionPercent");
			maxExemption = (String)map.get("maxExemption");
			int userId = 0;
			if(map.get("userId")!=null){
				userId = (Integer)map.get("userId");
			}
			
			currentDate=(Date)map.get("currentDate");
			currentTime=(String)map.get("currentTime");
			HrMasItaxExemption hrMasItaxExemption=(HrMasItaxExemption)getHibernateTemplate().load(HrMasItaxExemption.class,id);
		
			hrMasItaxExemption.setId(id);
			hrMasItaxExemption.setSectionCode(sectionCode);
			hrMasItaxExemption.setSectionDesc(secDesc);
			
			MasStoreFinancial hrMasFinancialYear= new MasStoreFinancial();
			hrMasFinancialYear.setId(new Integer(financialyear));
			hrMasItaxExemption.setFinancialYear(hrMasFinancialYear);
			
			
			hrMasItaxExemption.setMinimumAmt(new BigDecimal(minAmt));
			hrMasItaxExemption.setMaximumAmt(new BigDecimal(maxAmt));
			hrMasItaxExemption.setExemptionBase(exemptionBase);
			hrMasItaxExemption.setMaxExemption(new BigDecimal(maxExemption));
			hrMasItaxExemption.setExemptionPercentage(new BigDecimal(exemptionPercent));
			if(userId !=0){
				Users users=new Users();
				users.setId(userId);
				hrMasItaxExemption.setLastChgBy(users);
				}
			
			hrMasItaxExemption.setLastChgDate(currentDate);
			hrMasItaxExemption.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrMasItaxExemption);
			dataUpdated = true;
			}catch (Exception e) {
				System.out.println("eXCP in DS "+e);
			}
			return dataUpdated;
	
	}

	@Override
	public boolean deleteIncomeTaxExemptMaster(int slabid,
			Map<String, Object> generalMap) {
		// TODO Auto-generated method stub

		boolean dataDeleted=false;
			  Date currentDate = new Date();
		  String currentTime = "";
		  currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		try{
			HrMasItaxExemption hrMasItaxExemption =new HrMasItaxExemption();
			hrMasItaxExemption=(HrMasItaxExemption)getHibernateTemplate().load(HrMasItaxExemption.class,slabid);
			currentDate=(Date)generalMap.get("currentDate");
			currentTime=(String)generalMap.get("currentTime");
			if (hrMasItaxExemption.getStatus().equals("y")){
				hrMasItaxExemption.setStatus("n");
				dataDeleted=true;
			}else{
				hrMasItaxExemption.setStatus("y");
				dataDeleted=false;
		}
			
			int userId = 0;
			if(generalMap.get("userId")!=null){
				userId = (Integer)generalMap.get("userId");
			}
			if(userId !=0){
				Users users=new Users();
				users.setId(userId);
				hrMasItaxExemption.setLastChgBy(users);
				}
			hrMasItaxExemption.setLastChgDate(currentDate);
			hrMasItaxExemption.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(hrMasItaxExemption);
		}catch (Exception e) {
			System.out.println("exc in DS "+e);
		}
		return dataDeleted;
	
	}

	@Override
	public Map<String, Object> showIncomeTaxSurchargeJsp() {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		Session session = (Session)getSession();
		List<HrMasItaxSurcharge> searchItaxSurchargeMasterList = session.createCriteria(HrMasItaxSurcharge.class).list();
		List<HrMasSurcharge> hrMasSurchargeList = session.createCriteria(HrMasSurcharge.class).add(Restrictions.eq("Status", "y")).list();
		List<MasStoreFinancial> hrMasFinancialYearList = session.createCriteria(MasStoreFinancial.class).add(Restrictions.eq("Status", "y")).list();
		if(searchItaxSurchargeMasterList != null)
		{
			map.put("searchItaxSurchargeMasterList",searchItaxSurchargeMasterList);
		}
		if(hrMasSurchargeList != null)
		{
			map.put("hrMasSurchargeList",hrMasSurchargeList);
		}
		if(hrMasFinancialYearList != null)
		{
			map.put("hrMasFinancialYearList",hrMasFinancialYearList);
		}
		return map;
	
	}

	@Override
	public Map<String, Object> copyIncomeTaxSurchargeJsp(int copyFromYear,
			int copyToYear) {
		// TODO Auto-generated method stub

		String msg = "";
		boolean dataCopied=false;
		Date   currentDate = new Date();
		String currentTime = "";
		currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		String changedBy = "Admin";
		
		BigDecimal lowerLimit;
		BigDecimal upperLimit;
		BigDecimal minTaxSal = null;
		BigDecimal perOne;
		BigDecimal perTwo;
		String surchargeBase="";
				
		Session session = (Session)getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		List<HrMasItaxSurcharge> prevHrMasItaxSurchargeList = new ArrayList<HrMasItaxSurcharge>();
		List<HrMasItaxSurcharge> newHrMasItaxSurchargeList = new ArrayList<HrMasItaxSurcharge>();
		List<HrMasItaxSurcharge> searchItaxSurchargeMasterList = new ArrayList<HrMasItaxSurcharge>();
		
		
		List<HrMasSurcharge>      hrMasSurchargeList = session.createCriteria(HrMasSurcharge.class).add(Restrictions.eq("Status", "y")).list();
		List<MasStoreFinancial> hrMasFinancialYearList = session.createCriteria(MasStoreFinancial.class).add(Restrictions.eq("Status", "y")).list();
		
		MasStoreFinancial  hrMasFinancialYear  = new MasStoreFinancial();
		HrMasSurcharge      hrMasSurcharge = new HrMasSurcharge();
		
		Map<String, Object> generalMap =new HashMap<String, Object>();
	
		if(hrMasFinancialYearList != null)
		{
			generalMap.put("hrMasFinancialYearList",hrMasFinancialYearList);
		}
		if(hrMasSurchargeList != null)
		{
			generalMap.put("hrMasSurchargeList",hrMasSurchargeList);
		}
						
		Integer fYear =  copyFromYear;
		try {
			if(fYear != null) {
				
				prevHrMasItaxSurchargeList = session.createCriteria(HrMasItaxSurcharge.class).add(Restrictions.eq("FinancialYear.Id",fYear )).list();
			}
			Integer tYear =  copyToYear;
			
			if(tYear != null) {
				
				newHrMasItaxSurchargeList = session.createCriteria(HrMasItaxSurcharge.class).add(Restrictions.eq("FinancialYear.Id",tYear )).list();
			}
			
			System.out.println("newHrMasItaxSecInvestmentList==="+newHrMasItaxSurchargeList.size());
			
			if(prevHrMasItaxSurchargeList.size() <= 0){
				msg = "From Year Having no records";
			}
			else if(newHrMasItaxSurchargeList.size() > 0){
				msg = "Already Records Exist for To Year";
			}
			
			if((prevHrMasItaxSurchargeList.size() > 0) && (newHrMasItaxSurchargeList.size() <= 0)) {
				
				hrMasFinancialYear.setId(tYear);
				
				for(HrMasItaxSurcharge hrMasItaxSurcharge : prevHrMasItaxSurchargeList){
										
					lowerLimit        = hrMasItaxSurcharge.getLowerLimit();
					upperLimit        = hrMasItaxSurcharge.getUpperLimit();
					minTaxSal         = hrMasItaxSurcharge.getMinTaxSal();
					perOne            = hrMasItaxSurcharge.getPercentOne();
					perTwo            = hrMasItaxSurcharge.getPercentTwo();
					surchargeBase     = hrMasItaxSurcharge.getSurchargeBase();
					
					HrMasItaxSurcharge hrMasItaxSurchargeObj = new HrMasItaxSurcharge();
					hrMasSurcharge.setId(hrMasItaxSurcharge.getHrMasSurcharge().getId());
					
					
					hrMasItaxSurchargeObj.setLowerLimit(lowerLimit);
					hrMasItaxSurchargeObj.setUpperLimit(upperLimit);
					hrMasItaxSurchargeObj.setMinTaxSal(minTaxSal);
					hrMasItaxSurchargeObj.setPercentOne(perOne);
					hrMasItaxSurchargeObj.setPercentTwo(perTwo);
					hrMasItaxSurchargeObj.setSurchargeBase(surchargeBase);
					hrMasItaxSurchargeObj.setStatus("y");
				
						Users users=new Users();
						users.setId(1);
						hrMasItaxSurchargeObj.setLastChgBy(users);
						
					hrMasItaxSurchargeObj.setLastChgDate(currentDate);
					hrMasItaxSurchargeObj.setLastChgTime(currentTime);
					hrMasItaxSurchargeObj.setFinancialYear(hrMasFinancialYear);
					hrMasItaxSurchargeObj.setHrMasSurcharge(hrMasSurcharge);
					
					hbt.save(hrMasItaxSurchargeObj);
					hbt.refresh(hrMasItaxSurchargeObj);
					msg = "Data Update Successfully"; 
					searchItaxSurchargeMasterList =session.createCriteria(HrMasItaxSurcharge.class).add(Restrictions.eq("FinancialYear.Id",tYear )).list();
				
				}
				
				
				
			}
				
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	   	
		generalMap.put("searchItaxSurchargeMasterList", searchItaxSurchargeMasterList);
		generalMap.put("hrMasSurchargeList", hrMasSurchargeList);
		
		generalMap.put("message",msg);	
		return generalMap;
	
	}

	@Override
	public Map<String, Object> searchIncomeTaxSurchargeJsp(String financialYear) {
		// TODO Auto-generated method stub

		Session session = (Session)getSession();
		List<HrMasItaxSurcharge> searchItaxSurchargeMasterList = session.createCriteria(HrMasItaxSurcharge.class).list();
		List<HrMasSurcharge> hrMasSurchargeList = session.createCriteria(HrMasSurcharge.class).add(Restrictions.eq("Status", "y")).list();
		List<MasStoreFinancial> hrMasFinancialYearList = session.createCriteria(MasStoreFinancial.class).add(Restrictions.eq("Status", "y")).list();
		Map<String, Object> generalMap =new HashMap<String, Object>();
	
		
		if(hrMasSurchargeList != null)
		{
			generalMap.put("hrMasSurchargeList",hrMasSurchargeList);
		}
		if(hrMasFinancialYearList != null)
		{
			generalMap.put("hrMasFinancialYearList",hrMasFinancialYearList);
		}
		
		Integer fYear =  Integer.parseInt(financialYear);
		System.out.println("fYear=="+fYear);
		try {
			if(fYear != null) {
				
				searchItaxSurchargeMasterList =session.createCriteria(HrMasItaxSurcharge.class).add(Restrictions.eq("FinancialYear.Id",fYear )).list();
				System.out.println("searchItaxSurchargeMasterList== "+searchItaxSurchargeMasterList.size());
			}
			/*if(searchItaxSurchargeMasterList != null)
			{
				generalMap.put("searchItaxSurchargeMasterList",searchItaxSurchargeMasterList);
			}*/
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		generalMap.put("searchItaxSurchargeMasterList",searchItaxSurchargeMasterList);
		return generalMap;
	
	}

	@Override
	public Map<String, Object> exitistingIncomeTaxSurchargeJsp(
			Map<String, Object> generalMap) {
		// TODO Auto-generated method stub

		String name = "";
		String code="";
		Map<String, Object> map = new HashMap<String, Object>();
		if(generalMap.get("name") != null){
			name = (String)generalMap.get("name");
		}
		if(generalMap.get("code") != null){
			code = (String)generalMap.get("code");
		}
		System.out.println("code--"+code);
		System.out.println("name--"+name);
		Session session = getSession();
		List<HrMasItaxSurcharge> financialsurChargeTypeCodeList = new ArrayList<HrMasItaxSurcharge>();
		
		financialsurChargeTypeCodeList=session.createCriteria(HrMasItaxSurcharge.class).add(Restrictions.eq("FinancialYear.Id",new Integer(name))).add(Restrictions.eq("HrMasSurcharge.Id",new Integer(code))).list();
		System.out.println("financialsurChargeTypeCodeList--"+financialsurChargeTypeCodeList.size());
		map.put("financialsurChargeTypeCodeList", financialsurChargeTypeCodeList);
		return map;
	
	}

	@Override
	public boolean addIncomeTaxSurchargeJsp(
			HrMasItaxSurcharge hrMasItaxSurcharge) {
		// TODO Auto-generated method stub

		boolean successfullyAdded = false;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(hrMasItaxSurcharge);
		hbt.refresh(hrMasItaxSurcharge);
		successfullyAdded =true;
		
		return successfullyAdded;
	
	}

	@Override
	public boolean editIncomeTaxSurchargeJsp(Map<String, Object> map) {
		// TODO Auto-generated method stub

		boolean dataUpdated=false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		
		String financialyear="";
		int hospitalId=0;
		int id=0;
		String surchargeCode="";
		String lowerLimit="";
		String upperLimit="";
		BigDecimal minTaxSal = null;
		BigDecimal perOne= null;
		BigDecimal perTwo= null;
		String surchargeBase="";
		int userId=0;
	
		
		try {
			id=(Integer)map.get("id");
		
			surchargeCode=(String)map.get("code");
			financialyear=(String)map.get("name");
			lowerLimit=(String)map.get("lowerLimit");	
			upperLimit = (String)map.get("upperLimit");
			minTaxSal = (BigDecimal)map.get("minTaxSal");
			perOne = (BigDecimal)map.get("perOne");
			perTwo = (BigDecimal)map.get("perTwo");
			surchargeBase = (String)map.get("surchargeBase");
			if(map.get("userId")!=null){
				userId = (Integer)map.get("userId");
			}
		
			currentDate=(Date)map.get("currentDate");
			currentTime=(String)map.get("currentTime");
			HrMasItaxSurcharge hrMasItaxSurcharge=(HrMasItaxSurcharge)getHibernateTemplate().load(HrMasItaxSurcharge.class,id);
		
			hrMasItaxSurcharge.setId(id);
			HrMasSurcharge hrMasSurcharge = new HrMasSurcharge();
			hrMasSurcharge.setId(new Integer(surchargeCode));
			hrMasItaxSurcharge.setHrMasSurcharge(hrMasSurcharge);
			
				
			MasStoreFinancial financialYear = new MasStoreFinancial();
			financialYear.setId(new Integer(financialyear));
			hrMasItaxSurcharge.setFinancialYear(financialYear);
			hrMasItaxSurcharge.setLowerLimit(new BigDecimal(lowerLimit));
			hrMasItaxSurcharge.setUpperLimit(new BigDecimal(upperLimit));
			hrMasItaxSurcharge.setMinTaxSal(minTaxSal);
			hrMasItaxSurcharge.setPercentOne(perOne);
			hrMasItaxSurcharge.setPercentTwo(perTwo);
			hrMasItaxSurcharge.setSurchargeBase(surchargeBase);
			hrMasItaxSurcharge.setStatus("y");
			if(userId !=0){
				Users users=new Users();
				users.setId(userId);
				hrMasItaxSurcharge.setLastChgBy(users);
				}
			hrMasItaxSurcharge.setLastChgDate(currentDate);
			hrMasItaxSurcharge.setLastChgTime(currentTime);
			
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrMasItaxSurcharge);
			dataUpdated = true;
			}catch (Exception e) {
				System.out.println("eXCP in DS "+e);
			}
			return dataUpdated;
		
	
	}

	@Override
	public boolean deleteIncomeTaxSurchargeJsp(int id,
			Map<String, Object> generalMap) {
		// TODO Auto-generated method stub

		boolean dataDeleted=false;
		  Date currentDate = new Date();
		  String currentTime = "";
		  int userId=0;
		  currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		try{
			HrMasItaxSurcharge hrMasItaxSurcharge =new HrMasItaxSurcharge();
			hrMasItaxSurcharge=(HrMasItaxSurcharge)getHibernateTemplate().load(HrMasItaxSurcharge.class,id);
			currentDate=(Date)generalMap.get("currentDate");
			currentTime=(String)generalMap.get("currentTime");
			if(generalMap.get("userId")!=null){
				userId = (Integer)generalMap.get("userId");
			}
			if (hrMasItaxSurcharge.getStatus().equals("y")){
				hrMasItaxSurcharge.setStatus("n");
				dataDeleted=true;
			}else{
				hrMasItaxSurcharge.setStatus("y");
				dataDeleted=false;
		}
			if(userId !=0){
				Users users=new Users();
				users.setId(userId);
				hrMasItaxSurcharge.setLastChgBy(users);
				}
		hrMasItaxSurcharge.setLastChgDate(currentDate);
		hrMasItaxSurcharge.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(hrMasItaxSurcharge);
		}catch (Exception e) {
			System.out.println("exc in DS "+e);
		}
		return dataDeleted;
	
	}
	
}