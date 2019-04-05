package jkt.hms.payroll.dataservice;

import java.math.BigDecimal;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.HrAdvance;
import jkt.hms.masters.business.HrAdvanceDetail;
import jkt.hms.masters.business.HrArrear;
import jkt.hms.masters.business.HrArrearSalary;
import jkt.hms.masters.business.HrBonusDetail;
import jkt.hms.masters.business.HrEmployeePayStructure;
import jkt.hms.masters.business.HrLoanDetail;
import jkt.hms.masters.business.HrLoanHeader;
import jkt.hms.masters.business.HrMasBonus;
import jkt.hms.masters.business.HrMasLoan;
import jkt.hms.masters.business.HrMasPayElement;
import jkt.hms.masters.business.HrMasReimbersement;
import jkt.hms.masters.business.HrReimbDetail;
import jkt.hms.masters.business.HrReimbHeader;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasGrade;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.Users;
import jkt.hms.util.HMSUtil;

import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class LoanDataServiceImpl extends HibernateDaoSupport implements LoanDataService {
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> showLoanHeaderJsp(Map<String,Object> detailMap) {
		Map<String,Object> map = new HashMap<String, Object>();
		List<HrLoanHeader> loanHeaderList = new ArrayList<HrLoanHeader>();
		List<HrLoanDetail> loanDetailList = new ArrayList<HrLoanDetail>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<HrMasLoan> loanList = new ArrayList<HrMasLoan>();
		Session session = (Session)getSession();
		int divisionIdForMedicalDivision = Integer.parseInt(HMSUtil.getProperties("adt.properties", "divisionIdForMedicalDivision"));
		
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y"))
				.add(Restrictions.eq("Division.Id", divisionIdForMedicalDivision))
				.addOrder(Order.asc("FirstName").ignoreCase()).list();
		loanList = session.createCriteria(HrMasLoan.class).list();
		loanDetailList = session.createCriteria(HrLoanDetail.class).list();
		loanHeaderList = session.createCriteria(HrLoanHeader.class).list();
		departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Division.Id", divisionIdForMedicalDivision)).add(Restrictions.eq("Status", "y")).list();
		
		map.put("employeeList", employeeList);
		map.put("loanList", loanList);
		map.put("loanDetailList", loanDetailList);
		map.put("loanHeaderList", loanHeaderList);
		map.put("departmentList", departmentList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> saveLoanHeader(HrLoanHeader hrLoanHeader) {
		Map<String,Object> map = new HashMap<String, Object>();
		List<HrLoanHeader> loanHeaderList = new ArrayList<HrLoanHeader>();
		List<HrLoanHeader> existingLoanHeaderList = new ArrayList<HrLoanHeader>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<HrMasLoan> loanList = new ArrayList<HrMasLoan>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Session session = (Session)getSession();
		int employeeId = hrLoanHeader.getEmployee().getId();
		SimpleDateFormat sdf= new  SimpleDateFormat("yyyy-MM-dd");
		String loanDate = sdf.format(hrLoanHeader.getLoanDate());
		String message = "";
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		
		int divisionIdForMedicalDivision = Integer.parseInt(HMSUtil.getProperties("adt.properties", "divisionIdForMedicalDivision"));
		int empActiveStatus = Integer.parseInt(HMSUtil.getProperties("adt.properties", "MAS_EMP_ACTIVE_STATUS"));
		
		existingLoanHeaderList = getHibernateTemplate().find("from jkt.hms.masters.business.HrLoanHeader as lh where lh.Employee.Id = '"+employeeId+"' and lh.LoanDate = '"+loanDate+"'");
		if(existingLoanHeaderList.size()>0){
			message = "Record already Exist";
		}else{
			hbt.save(hrLoanHeader);
			message = "Record saved successfully!";
		}
		departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Division.Id", divisionIdForMedicalDivision)).add(Restrictions.eq("Status", "y")).list();
		loanList = getHibernateTemplate().find("from jkt.hms.masters.business.HrMasLoan");
		employeeList = getHibernateTemplate().find("from jkt.hms.masters.business.MasEmployee e where e.Division="+ divisionIdForMedicalDivision +" and e.EmployeeStatus="+ empActiveStatus +" and e.Status='y' order by e.FirstName");
		loanHeaderList = getHibernateTemplate().find("from jkt.hms.masters.business.HrLoanHeader");
		map.put("loanHeaderList", loanHeaderList);
		map.put("employeeList", employeeList);
		map.put("loanList", loanList);
		map.put("message", message);
		map.put("departmentList", departmentList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showLoanDetailJsp() {
		Map<String, Object > map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<HrLoanHeader> loanHeaderList = new ArrayList<HrLoanHeader>();
		List<HrLoanDetail> loanDetailList = new ArrayList<HrLoanDetail>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasGrade> gradeList = new ArrayList<MasGrade>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<Integer> maxIdList = new ArrayList<Integer>();
		List<HrMasLoan> loanList = new ArrayList<HrMasLoan>();
		List<HrLoanDetail> maxLoanDetailList = new ArrayList<HrLoanDetail>();
		loanHeaderList = session.createCriteria(HrLoanHeader.class).list();
		HrLoanHeader hrLoanHeader = new HrLoanHeader();
		
		int divisionIdForMedicalDivision = Integer.parseInt(HMSUtil.getProperties("adt.properties", "divisionIdForMedicalDivision"));
		int empActiveStatus = Integer.parseInt(HMSUtil.getProperties("adt.properties", "MAS_EMP_ACTIVE_STATUS"));
		
		int loanHeaderId = 0;
		if(loanHeaderList != null && !(loanHeaderList.isEmpty())){
		 hrLoanHeader = (HrLoanHeader)loanHeaderList.get(0);
		loanHeaderId = hrLoanHeader.getId();
		}
		loanList = session.createCriteria(HrMasLoan.class).list();
		loanDetailList = session.createCriteria(HrLoanDetail.class).list();
		try {
			maxIdList = getHibernateTemplate().find("select max(detail.Id) from jkt.hms.masters.business.HrLoanDetail detail join detail.LoanHeader as header  where header.Id = "+loanHeaderId+" ");
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		int maxLoanHeaderId = 0;
		if (maxIdList!=null && !maxIdList.isEmpty() && maxIdList.get(0)!=null) {
			
			maxLoanHeaderId = maxIdList.get(0);
			
		}
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y"))
				.add(Restrictions.eq("Division.Id", divisionIdForMedicalDivision))
				.addOrder(Order.asc("FirstName").ignoreCase()).list();
										
		departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Division.Id", divisionIdForMedicalDivision)).add(Restrictions.eq("Status", "y")).list();
		gradeList =session.createCriteria(MasGrade.class).list();
		maxLoanDetailList = session.createCriteria(HrLoanDetail.class).add(Restrictions.idEq(maxLoanHeaderId)).list();
		map.put("loanList", loanList);
		map.put("loanHeaderList", loanHeaderList);
		map.put("loanDetailList", loanDetailList);
		map.put("gradeList", gradeList);
		map.put("employeeList", employeeList);
		map.put("departmentList", departmentList);
		map.put("maxLoanDetailList", maxLoanDetailList);
		return map;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> updateLoanHeader(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrLoanHeader> existingLoanHeaderList = new ArrayList<HrLoanHeader>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<HrMasLoan> loanList = new ArrayList<HrMasLoan>();
		List<HrLoanHeader> loanHeaderList = new ArrayList<HrLoanHeader>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Session session = (Session)getSession();
		
		int divisionIdForMedicalDivision = Integer.parseInt(HMSUtil.getProperties("adt.properties", "divisionIdForMedicalDivision"));
		int empActiveStatus = Integer.parseInt(HMSUtil.getProperties("adt.properties", "MAS_EMP_ACTIVE_STATUS"));
		
		int loanheaderId = 0;
		if (generalMap.get("loanheaderId")!= null) {
			 loanheaderId = (Integer)generalMap.get("loanheaderId");
		}
		int employeeId =  0;
		if (generalMap.get("employeeId")!= null) {
			employeeId  = (Integer)generalMap.get("employeeId");
		}
		
		int loanId = 0;
		if (generalMap.get("loanId")!= null) {
			loanId = (Integer)generalMap.get("loanId");
		}
		Date  loanDate = new Date();
		if (generalMap.get("loanDate")!= null) {
			loanDate = (Date)generalMap.get("loanDate");
		}
		int loanPeriod = 0;
		if (generalMap.get("loanPeriod")!= null) {
			loanPeriod = (Integer)generalMap.get("loanPeriod");
		}
		BigDecimal loanPAmount = null;
		if (generalMap.get("loanPAmount")!= null) {
			loanPAmount= (BigDecimal)generalMap.get("loanPAmount");
		}
		Float loanInterest = null;
		if (generalMap.get("loanInterest")!= null) {
		 loanInterest = (Float)generalMap.get("loanInterest");
		}
		BigDecimal loanCAmount = null;
		if (generalMap.get("loanCAmount")!= null) {
			loanCAmount = (BigDecimal)generalMap.get("loanCAmount");
		}
		Date interestDate = new Date();
		if (generalMap.get("interestDate")!= null) {
			interestDate = (Date)generalMap.get("interestDate");
		}
		BigDecimal monthlyInstallment  = null;
		if (generalMap.get("monthlyInstallment")!= null) {
			monthlyInstallment = (BigDecimal)generalMap.get("monthlyInstallment");
		}
		Date  lastPaymentDate = null;
		if (generalMap.get("lastPaymentDate")!= null) {
			lastPaymentDate = (Date)generalMap.get("lastPaymentDate");
		}
		BigDecimal balanceCLoan = null;
		if (generalMap.get("balanceCLoan")!= null) {
			 balanceCLoan = (BigDecimal)generalMap.get("balanceCLoan");
		}
		String loanStatus = "";
		if (generalMap.get("loanStatus")!= null) {
			loanStatus = (String)generalMap.get("loanStatus");
		}
		String deductFrom = "";
		if (generalMap.get("deductFrom")!= null) {
			deductFrom = (String)generalMap.get("deductFrom");
		}
		Users changedBy =null;
		if (generalMap.get("changedBy")!= null) {
			changedBy = (Users)generalMap.get("changedBy"); 
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
		HrLoanHeader hrLoanHeader= (HrLoanHeader)hbt.load(HrLoanHeader.class,loanheaderId );
		MasEmployee masEmployee = new MasEmployee();
		masEmployee.setId(employeeId);
		hrLoanHeader.setEmployee(masEmployee);
		HrMasLoan hrMasLoan = new HrMasLoan();
		hrMasLoan.setId(loanId);
		hrLoanHeader.setLoan(hrMasLoan);
		hrLoanHeader.setLoanDate(loanDate);
		hrLoanHeader.setLoanPeriod(loanPeriod);
		hrLoanHeader.setLoanPAmount(loanPAmount);
		hrLoanHeader.setLoanInterest(loanInterest);
		hrLoanHeader.setLoanCAmount(loanCAmount);
		hrLoanHeader.setLoanInterestDate(interestDate);
		hrLoanHeader.setMonthlyInstall(monthlyInstallment);
		hrLoanHeader.setLastPaymentDate(lastPaymentDate);
		hrLoanHeader.setLoanStatus(loanStatus);
		hrLoanHeader.setDeductFrom(deductFrom);
		hrLoanHeader.setLastChgBy(changedBy);
		hrLoanHeader.setLastChgDate(currentDate);
		hrLoanHeader.setLastChgTime(currentTime);
		System.out.println(loanDate);
		/*existingLoanHeaderList = getHibernateTemplate().find("from jkt.hms.masters.business.HrLoanHeader as lh where lh.Employee.Id = '"+employeeId+"' and  lh.LoanDate = '"+loanDate+"' ");*/
		existingLoanHeaderList =session.createCriteria(HrLoanHeader.class)
				.add(Restrictions.eq("Employee.Id", employeeId))
				.add(Restrictions.eq("LoanDate", loanDate)).list();
		String message = "";
		if(existingLoanHeaderList.size()>0){
			message = "Record already exist";
		}else{
			hbt.update(hrLoanHeader);
			message = "Record update successfully";
		}
		departmentList = session.createCriteria(MasDepartment.class).list();
		loanHeaderList = session.createCriteria(HrLoanHeader.class).list();
		loanList = getHibernateTemplate().find("from jkt.hms.masters.business.HrMasLoan");
		employeeList = getHibernateTemplate().find("from jkt.hms.masters.business.MasEmployee e where e.Division="+ divisionIdForMedicalDivision +" and e.EmployeeStatus="+ empActiveStatus +" and e.Status='y' order by e.FirstName");
		map.put("loanList", loanList);
		map.put("employeeList", employeeList);
		map.put("message", message);
		map.put("loanHeaderList", loanHeaderList);
		map.put("departmentList", departmentList);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> saveLoanDetail(HrLoanDetail hrLoanDetail) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrLoanHeader> loanHeaderList = new ArrayList<HrLoanHeader>();
		List<HrLoanDetail> loanDetailList = new ArrayList<HrLoanDetail>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasGrade> gradeList = new ArrayList<MasGrade>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<HrMasLoan> loanList = new ArrayList<HrMasLoan>();
		List<HrLoanDetail> existingLoanDetailList = new ArrayList<HrLoanDetail>();
		Session session = (Session)getSession();
		SimpleDateFormat sdf= new  SimpleDateFormat("yyyy-MM-dd");
		String installmentDate = sdf.format(hrLoanDetail.getInstallDate());
		int loanHeaderId = hrLoanDetail.getLoanHeader().getId();
		BigDecimal balanceCLoan = hrLoanDetail.getBalanceLoan();
		Date lastPaymentDate = hrLoanDetail.getInstallDate();
		int divisionIdForMedicalDivision = Integer.parseInt(HMSUtil.getProperties("adt.properties", "divisionIdForMedicalDivision"));
		int empActiveStatus = Integer.parseInt(HMSUtil.getProperties("adt.properties", "MAS_EMP_ACTIVE_STATUS"));
		String message = "";
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		HrLoanHeader hrLoanHeader =(HrLoanHeader)hbt.load(HrLoanHeader.class, loanHeaderId);
		hrLoanHeader.setBalanceLoan(balanceCLoan);
		hrLoanHeader.setLastPaymentDate(lastPaymentDate);
		if (balanceCLoan.intValue() == 0) {
			hrLoanHeader.setLoanStatus("close");
		}
		hbt.update(hrLoanHeader);
		hbt.flush();
		hbt.refresh(hrLoanHeader);
	
		existingLoanDetailList = getHibernateTemplate().find("from jkt.hms.masters.business.HrLoanDetail as  detail where detail.InstallDate = '"+installmentDate+"' and detail.LoanHeader.Id = '"+loanHeaderId+"'");
		if(existingLoanDetailList.size()>0){
			message = "Record already Exist";
		}else{
			hbt.save(hrLoanDetail);
			message = "Record saved successfully!";
		}
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y"))
				.add(Restrictions.eq("Division.Id", divisionIdForMedicalDivision))
				.addOrder(Order.asc("FirstName").ignoreCase()).list();
										
		departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Division.Id", divisionIdForMedicalDivision)).add(Restrictions.eq("Status", "y")).list();	
		
		loanList = session.createCriteria(HrMasLoan.class).list();
		gradeList =session.createCriteria(MasGrade.class).list();
		loanDetailList = session.createCriteria(HrLoanDetail.class).list();
		loanHeaderList = session.createCriteria(HrLoanHeader.class).list();
		map.put("message", message);
		map.put("loanList", loanList);
		map.put("departmentList", departmentList);
		map.put("gradeList", gradeList);
		map.put("loanDetailList", loanDetailList);
		map.put("loanHeaderList", loanHeaderList);
		map.put("employeeList", employeeList);
		return map;
	}

	public Map<String, Object> getLoanDetailFromAjax(int loanHeaderId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<HrLoanHeader> loanHeaderList = new ArrayList<HrLoanHeader>();
		List<HrLoanDetail> loanDetailList = new ArrayList<HrLoanDetail>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasGrade> gradeList = new ArrayList<MasGrade>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<Integer> maxIdList = new ArrayList<Integer>();
		List<HrLoanDetail> maxLoanDetailList = new ArrayList<HrLoanDetail>();
		loanHeaderList = getHibernateTemplate().find("from jkt.hms.masters.business.HrLoanHeader as lh where lh.Id = "+loanHeaderId);
		
		try {
			maxIdList = getHibernateTemplate().find("select max(detail.Id) from jkt.hms.masters.business.HrLoanDetail detail join detail.LoanHeader as header  where header.Id = "+loanHeaderId+" ");
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		System.out.println("maxIdList----"+maxIdList);
		int maxLoanHeaderId = 0;
		try {
			if (maxIdList.get(0) != null && maxIdList.size()>0) {
				maxLoanHeaderId = maxIdList.get(0);
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		System.out.println("gfbfbf maxLoanHeaderId------------"+maxLoanHeaderId);
		maxLoanDetailList = session.createCriteria(HrLoanDetail.class).add(Restrictions.idEq(maxLoanHeaderId)).list();
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("FirstName")).list();
		departmentList = session.createCriteria(MasDepartment.class).list();
		gradeList =session.createCriteria(MasGrade.class).list();
		map.put("loanHeaderList", loanHeaderList);
		map.put("loanDetailList", loanDetailList);
		map.put("maxLoanDetailList", maxLoanDetailList);
		map.put("departmentList", departmentList);
		map.put("gradeList", gradeList);
		map.put("employeeList", employeeList);
		return map;
	}

	public Map<String, Object> editLoanDetail(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrLoanDetail> loanDetailBalanceLoanList = new ArrayList<HrLoanDetail>();
		List<HrLoanHeader> loanHeaderList = new ArrayList<HrLoanHeader>();
		List<HrLoanDetail> loanDetailList = new ArrayList<HrLoanDetail>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<HrMasLoan> loanList = new ArrayList<HrMasLoan>();
		Session session = (Session)getSession();
		int loandetailId = 0;
		if (generalMap.get("loandetailId")!= null) {
			loandetailId = (Integer)generalMap.get("loandetailId");
		}
		int loanHeaderId = 0;
		if (generalMap.get("loanHeaderId")!= null) {
			loanHeaderId = (Integer)generalMap.get("loanHeaderId");
		}
		BigDecimal balanceLoan = null;
		if (generalMap.get("balanceLoan")!= null) {
			balanceLoan = (BigDecimal)generalMap.get("balanceLoan");
		}
		System.out.println("balanceLoan--------"+balanceLoan);
		Date installDate= new Date();
		if (generalMap.get("installDate")!= null) {
			installDate = (Date)generalMap.get("installDate");
		}
		BigDecimal installAmount = null;
		if (generalMap.get("installAmount")!= null) {
			installAmount = (BigDecimal)generalMap.get("installAmount");
		}
		System.out.println("installAmount------"+installAmount);
		BigDecimal interestPaid  = null;
		if (generalMap.get("interestPaid")!= null) {
			interestPaid = (BigDecimal)generalMap.get("interestPaid");
		}
		BigDecimal prinPaid = null;
		if (generalMap.get("prinPaid")!= null) {
			prinPaid = (BigDecimal)generalMap.get("prinPaid");
		}
		String remark = "";
		if (generalMap.get("remark")!= null) {
			remark = (String)generalMap.get("remark");
		}
		Users changedBy =null;
		if (generalMap.get("changedBy")!= null) {
			changedBy = (Users)generalMap.get("changedBy"); 
		}	
		Date currentDate = null; 
		if (generalMap.get("currentDate")!= null) {
			currentDate = (Date)generalMap.get("currentDate"); 
		}
		String currentTime = "";
		if (generalMap.get("currentTime")!= null) {
			currentTime = (String)generalMap.get("currentTime"); 
		}
		BigDecimal updateLoanDetailBalanceLoan = null;
		BigDecimal updateLoanDetailInstallAmount = null;
		loanDetailBalanceLoanList = session.createCriteria(HrLoanDetail.class).add(Restrictions.idEq(loandetailId)).list();
	    if (loanDetailBalanceLoanList.size()>0) {
	    	HrLoanDetail hrLoanDetail = (HrLoanDetail)loanDetailBalanceLoanList.get(0);
	    	updateLoanDetailBalanceLoan = hrLoanDetail.getBalanceLoan();
	    	updateLoanDetailInstallAmount = hrLoanDetail.getInstallAmount();
		}
	    System.out.println("updateLoanDetailBalanceLoan---------------"+updateLoanDetailBalanceLoan);
	    System.out.println("updateLoanDetailInstallAmount---------------"+updateLoanDetailInstallAmount);
	    BigDecimal lastTotalBalnceLoan = updateLoanDetailBalanceLoan.add(updateLoanDetailInstallAmount);
	    System.out.println("lastTotalBalnceLoan----------"+lastTotalBalnceLoan);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		HrLoanHeader hrLoanHeader = (HrLoanHeader)hbt.load(HrLoanHeader.class, loanHeaderId);
		
		BigDecimal	latestTotalBalanceLoan = lastTotalBalnceLoan.subtract(installAmount);
		System.out.println("latestTotalBalanceLoan-----------"+latestTotalBalanceLoan);
		hrLoanHeader.setBalanceLoan(latestTotalBalanceLoan);
		hbt.update(hrLoanHeader);
		HrLoanDetail hrLoanDetail = (HrLoanDetail)hbt.load(HrLoanDetail.class, loandetailId);
		hrLoanHeader.setId(loanHeaderId);
		hrLoanDetail.setLoanHeader(hrLoanHeader);
		hrLoanDetail.setBalanceLoan(latestTotalBalanceLoan);
		hrLoanDetail.setInstallDate(installDate);
		hrLoanDetail.setInstallAmount(installAmount);
		hrLoanDetail.setPPaid(prinPaid);
		hrLoanDetail.setInterestPaid(interestPaid);
		hrLoanDetail.setRemark(remark);
		hrLoanDetail.setLastChgBy(changedBy);
		hrLoanDetail.setLastChgDate(currentDate);
		hrLoanDetail.setLastChgTime(currentTime);
		hbt.update(hrLoanDetail);
		//existingloanDetailList = getHibernateTemplate().find("from jkt.hms.masters.business.HrLoanDetail as ld where ld.InstallDate = '"+installDate+"' ");
		boolean updated = false;
		updated =  true;
		String message = "";
		if(updated){
			message = "Data update Successfully.";
		}else{
			message = "Some Problem Occured.";
		}
		loanHeaderList = session.createCriteria(HrLoanHeader.class).list();
		loanDetailList = session.createCriteria(HrLoanDetail.class).list();
		loanList = getHibernateTemplate().find("from jkt.hms.masters.business.HrMasLoan");
		employeeList = getHibernateTemplate().find("from jkt.hms.masters.business.MasEmployee as emp where emp.Status='y' order by emp.FirstName");
		map.put("loanList", loanList);
		map.put("employeeList", employeeList);
		map.put("message", message);
		map.put("loanDetailList", loanDetailList);
		map.put("loanHeaderList", loanHeaderList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showReimbHeaderJsp(Map<String, Object> detailMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<HrMasReimbersement> reimbList = new ArrayList<HrMasReimbersement>();
		List<HrReimbHeader> reimbHeaderList = new ArrayList<HrReimbHeader>();
		int divisionIdForMedicalDivision = Integer.parseInt(HMSUtil.getProperties("adt.properties", "divisionIdForMedicalDivision"));
		
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y"))
				.add(Restrictions.eq("Division.Id", divisionIdForMedicalDivision))
				.addOrder(Order.asc("FirstName").ignoreCase()).list();
		reimbList  = session.createCriteria(HrMasReimbersement.class).add(Restrictions.eq("Status", "y")).list();
		reimbHeaderList = session.createCriteria(HrReimbHeader.class).list();
		map.put("employeeList", employeeList);
		map.put("reimbList", reimbList);
		map.put("reimbHeaderList", reimbHeaderList);
		return map;
	}

	public Map<String, Object> saveReimbHeader(HrReimbHeader hrReimbHeader) {
		Map<String,Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<HrMasReimbersement> reimbList = new ArrayList<HrMasReimbersement>();
		List<HrReimbHeader> existingReimbHeaderList = new ArrayList<HrReimbHeader>();
		List<HrReimbHeader> reimbHeaderList = new ArrayList<HrReimbHeader>();
		Session session = (Session)getSession();
		boolean saved = false;
		int employeeId = hrReimbHeader.getEmployee().getId();
		//Date fromDate = hrReimbHeader.getFromDate();
		//Date toDate = hrReimbHeader.getToDate();
		
		SimpleDateFormat sdf= new  SimpleDateFormat("yyyy-MM-dd");
		String fromDate = sdf.format(hrReimbHeader.getFromDate());
		String toDate = sdf.format(hrReimbHeader.getToDate());
		int reimbId = hrReimbHeader.getReimb().getId();
		int divisionIdForMedicalDivision = Integer.parseInt(HMSUtil.getProperties("adt.properties", "divisionIdForMedicalDivision"));
		String message = "";
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		existingReimbHeaderList = hbt.find("from jkt.hms.masters.business.HrReimbHeader as header where header.Employee.Id = "+employeeId+" and header.FromDate = '"+fromDate+"' and header.ToDate = '"+toDate+"' and header.Reimb.Id = "+reimbId+" ");
		
		if(existingReimbHeaderList.size()>0){
			message = "Record already Exist";
		}else{
			hbt.save(hrReimbHeader);
			hbt.refresh(hrReimbHeader);
			message = "Record save successfully";
		}
		
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y"))
				.add(Restrictions.eq("Division.Id", divisionIdForMedicalDivision))
				.addOrder(Order.asc("FirstName").ignoreCase()).list();
		
		reimbList  = session.createCriteria(HrMasReimbersement.class).list();
		reimbHeaderList = session.createCriteria(HrReimbHeader.class).list();
		map.put("reimbHeaderList", reimbHeaderList);
		map.put("reimbList", reimbList);
		map.put("employeeList", employeeList);
		map.put("message", message);
		return map;
	}

	public Map<String, Object> updateReimbHeader(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<HrMasReimbersement> reimbList = new ArrayList<HrMasReimbersement>();
		List<HrReimbHeader> reimbHeaderList = new ArrayList<HrReimbHeader>();
		List<HrReimbHeader> existingReimbHeaderList = new ArrayList<HrReimbHeader>();
		Session session = (Session)getSession();
		boolean updated = false;
		int reimbHeaderId = 0;
		if (generalMap.get("reimbHeaderId")!= null) {
			reimbHeaderId = (Integer)generalMap.get("reimbHeaderId");
		}
		
		Date fromDate = new Date();
		if (generalMap.get("fromDate")!= null) {
			fromDate = (Date)generalMap.get("fromDate");
		}
		Date toDate = new Date();
		if (generalMap.get("toDate")!= null) {
			toDate = (Date)generalMap.get("toDate");
		}
		int employeeId = 0;
		if (generalMap.get("employeeId")!= null) {
			employeeId = (Integer)generalMap.get("employeeId");
		}
		String payMode = "";
		if (generalMap.get("payMode")!= null) {
			payMode = (String)generalMap.get("payMode");
		}
		int reimbId = 0;
		if (generalMap.get("reimbId")!= null) {
			reimbId = (Integer)generalMap.get("reimbId");
		}
		String  remark = "";
		if (generalMap.get("remark")!= null) {
			remark = (String)generalMap.get("remark");
		}
		BigDecimal maxAmount = null;
		if (generalMap.get("maxAmount")!= null) {
			maxAmount = (BigDecimal)generalMap.get("maxAmount");
		}
		BigDecimal totalReimbAmount = null;
		if (generalMap.get("totalReimbAmount")!= null) {
			totalReimbAmount = (BigDecimal)generalMap.get("totalReimbAmount");
		}
		String reimbStatus = "";
		if (generalMap.get("reimbStatus")!= null) {
			reimbStatus = (String)generalMap.get("reimbStatus");
		}
		Users changedBy  = null;
		if (generalMap.get("changedBy")!= null) {
			changedBy = (Users)generalMap.get("changedBy");
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
		HrReimbHeader hrReimbHeader = (HrReimbHeader)hbt.load(HrReimbHeader.class, reimbHeaderId);
		hrReimbHeader.setFromDate(fromDate);
	    hrReimbHeader.setToDate(toDate);
		
		MasEmployee masEmployee = new MasEmployee();
		masEmployee.setId(employeeId);
		hrReimbHeader.setEmployee(masEmployee);
		hrReimbHeader.setPaymode(payMode);
		
		HrMasReimbersement hrMasReimbersement = new HrMasReimbersement();
		hrMasReimbersement.setId(reimbId);
		hrReimbHeader.setReimb(hrMasReimbersement);
		hrReimbHeader.setRemark(remark);
		hrReimbHeader.setMaxAmount(maxAmount);
		hrReimbHeader.setTotalReimbAmt(totalReimbAmount);
		hrReimbHeader.setReimbStatus(reimbStatus);
		hrReimbHeader.setLastChgBy(changedBy);
		hrReimbHeader.setLastChgDate(currentDate);
		hrReimbHeader.setLastChgTime(currentTime);
		//existingReimbHeaderList = getHibernateTemplate().find("from jkt.hms.masters.business.HrReimbHeader as header where header.Employee.Id = '"+employeeId+"'");
		hbt.update(hrReimbHeader);
		String message = "";
		updated = true;
		if(updated){
			message = "Record update successfully";
		}else{
			message = "Some Problem Occured";
		}
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("FirstName")).list();
		reimbList  = session.createCriteria(HrMasReimbersement.class).list();
		reimbHeaderList = session.createCriteria(HrReimbHeader.class).list();
		map.put("reimbHeaderList", reimbHeaderList);
		map.put("reimbList", reimbList);
		map.put("employeeList", employeeList);
		map.put("message", message);
		return map;
	}

	public Map<String, Object> showReimbDetailJsp(Map<String, Object> detailMap) {
		Map<String,Object> map= new HashMap<String, Object>();
		List<HrReimbHeader> reimbHeaderList = new ArrayList<HrReimbHeader>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		List<HrReimbDetail> reimDetailList = new ArrayList<HrReimbDetail>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<HrMasReimbersement> reimbList = new ArrayList<HrMasReimbersement>();
		int centreId =(Integer) detailMap.get("centreId");
		Session session = (Session)getSession();
		reimbHeaderList = session.createCriteria(HrReimbHeader.class).list();
		reimDetailList = session.createCriteria(HrReimbDetail.class).list();
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Hospital.Id", centreId))
				.addOrder(Order.asc("FirstName").ignoreCase()).list();
		reimbList  = session.createCriteria(HrMasReimbersement.class).list();
		
		map.put("reimbHeaderList", reimbHeaderList);
		map.put("reimDetailList", reimDetailList);
		map.put("employeeList", employeeList);
		map.put("reimbList", reimbList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> saveReimbDetail(Map<String, Object> generalMap) {
		Map<String,Object> map= new HashMap<String, Object>();
		List<HrReimbHeader> reimbHeaderList = new ArrayList<HrReimbHeader>();
		List<HrReimbDetail> reimDetailList = new ArrayList<HrReimbDetail>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<HrMasReimbersement> reimbList = new ArrayList<HrMasReimbersement>();
		List<HrReimbDetail> existingReimDetailList = new ArrayList<HrReimbDetail>();
		
		int divisionIdForMedicalDivision = Integer.parseInt(HMSUtil.getProperties("adt.properties", "divisionIdForMedicalDivision"));
		
		boolean saved = false;
		String message ="";
		HrReimbDetail hrReimbDetail = new HrReimbDetail();
		Session session = (Session)getSession();
		if (generalMap.get("hrReimbDetail")!= null) {
			hrReimbDetail = (HrReimbDetail)generalMap.get("hrReimbDetail");
		}
		int hospitalId =0;
		if (generalMap.get("hospitalId")!= null) {
			hospitalId = (Integer)generalMap.get("hospitalId");
		}
		int reimbHeaderId  = 0;
		int reimbId =0;
			reimbHeaderId = hrReimbDetail.getReimbHeader().getId();
			if (generalMap.get("reimbId")!= null) {
				reimbId = (Integer)generalMap.get("reimbId");
			}
		SimpleDateFormat sdf= new  SimpleDateFormat("yyyy-MM-dd");
		String claimDate = sdf.format(hrReimbDetail.getClaimDate());
		String paid = hrReimbDetail.getPaid();
		
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		hrReimbDetail.setHospital(masHospital);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		HrReimbHeader hrReimbHeader=(HrReimbHeader)hbt.load(HrReimbHeader.class, reimbHeaderId);
		if (paid.equals("y")) {
			hrReimbHeader.setReimbStatus("close");
			hbt.update(hrReimbHeader);
		}
		existingReimDetailList = getHibernateTemplate().find("from jkt.hms.masters.business.HrReimbDetail as detail where detail.ReimbHeader.Id = "+reimbHeaderId+" and detail.ClaimDate = '"+claimDate+"' and detail.ReimbHeader.Reimb.Id = "+reimbId+"  ");
		
		
		if(existingReimDetailList.size()>0){
			message = "Data Already Exist";
		}else{
			hbt.save(hrReimbDetail);
			message = "Data Saved Successfully.";
		}
		reimbList  = session.createCriteria(HrMasReimbersement.class).list();
		
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y"))
				.add(Restrictions.eq("Division.Id", divisionIdForMedicalDivision))
				.addOrder(Order.asc("FirstName").ignoreCase()).list();
		
		reimbHeaderList = session.createCriteria(HrReimbHeader.class).list();
		reimDetailList = session.createCriteria(HrReimbDetail.class).list();
		map.put("message", message);
		map.put("reimDetailList", reimDetailList);
		map.put("reimbHeaderList", reimbHeaderList);
		map.put("employeeList", employeeList);
		map.put("reimbList", reimbList);
		return map;
	}

	public Map<String, Object> updateReimbDetail(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrReimbHeader> reimbHeaderList = new ArrayList<HrReimbHeader>();
		List<HrReimbDetail> reimDetailList = new ArrayList<HrReimbDetail>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<HrMasReimbersement> reimbList = new ArrayList<HrMasReimbersement>();
		Session session = (Session)getSession();
		boolean saved = false;
		int reimbDetailId = 0;
		if (generalMap.get("reimbDetailId")!= null) {
			reimbDetailId= (Integer)generalMap.get("reimbDetailId");
		}
		int reimbHeaderId = 0;
		if (generalMap.get("reimbHeaderId")!= null) {
			reimbHeaderId= (Integer)generalMap.get("reimbHeaderId");
		}
		Date claimDate = new Date();
		if (generalMap.get("claimDate")!= null) {
			claimDate= (Date)generalMap.get("claimDate");
		}
		BigDecimal claimAmount = null;
		if (generalMap.get("claimAmount")!= null) {
			claimAmount = (BigDecimal)generalMap.get("claimAmount");
		}
		String paid = "";
		if (generalMap.get("paid")!= null) {
			paid = (String)generalMap.get("paid");
		}
		Date reimbDate = new Date();
		if (generalMap.get("reimbDate")!= null) {
			reimbDate= (Date)generalMap.get("reimbDate");
		}
		BigDecimal reimbAmount = null;
		if (generalMap.get("reimbAmount")!= null) {
			reimbAmount= (BigDecimal)generalMap.get("reimbAmount");
		}
		String remark = "";
		if (generalMap.get("remark")!= null) {
			remark = (String)generalMap.get("remark");
		}
		Users	changedBy = null;
		if (generalMap.get("changedBy")!= null) {
			changedBy = (Users)generalMap.get("changedBy");
		}
		Date currentDate = new Date();
		if (generalMap.get("currentDate")!= null) {
			currentDate = (Date)generalMap.get("currentDate");
		}
		String	currentTime = "";
	    if (generalMap.get("currentTime")!= null) {
	    	currentTime = (String)generalMap.get("currentTime");
		}
	    org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		HrReimbDetail hrReimbDetail = (HrReimbDetail)hbt.load(HrReimbDetail.class, reimbDetailId);
		
		HrReimbHeader hrReimbHeader = new HrReimbHeader();
		hrReimbHeader.setId(reimbHeaderId);
		hrReimbDetail.setReimbHeader(hrReimbHeader);
		hrReimbDetail.setClaimAmount(claimAmount);
		hrReimbDetail.setClaimDate(claimDate);
		hrReimbDetail.setPaid(paid);
		hrReimbDetail.setReimbAmount(reimbAmount);
		hrReimbDetail.setReimbDate(reimbDate);
		hrReimbDetail.setRemarks(remark);
		hrReimbDetail.setLastChgBy(changedBy);
		hrReimbDetail.setLastChgDate(currentDate);
		hrReimbDetail.setLastChgTime(currentTime);
		hbt.update(hrReimbDetail);
		saved =  true;
		String message = "";
		if(saved){
			message = "Data update Successfully.";
		}else{
			message = "Some Problem Occured.";
		}
		reimbList  = session.createCriteria(HrMasReimbersement.class).list();
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("FirstName")).list();
		reimbHeaderList = session.createCriteria(HrReimbHeader.class).list();
		reimDetailList = session.createCriteria(HrReimbDetail.class).list();
		map.put("reimDetailList", reimDetailList);
		map.put("reimbHeaderList", reimbHeaderList);
		map.put("employeeList", employeeList);
		map.put("reimbList", reimbList);
		map.put("message", message);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showBonusDetailJsp(Map<String,Object> detailMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<HrMasBonus> bonusList = new ArrayList<HrMasBonus>();
		List<HrBonusDetail> bonusDetailList = new ArrayList<HrBonusDetail>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		List<HrEmployeePayStructure> payStructureElementList = new ArrayList<HrEmployeePayStructure>();
		int divisionIdForMedicalDivision = Integer.parseInt(HMSUtil.getProperties("adt.properties", "divisionIdForMedicalDivision"));
		Session session = (Session)getSession();
		bonusDetailList =  session.createCriteria(HrBonusDetail.class).list();
		
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y"))
				.add(Restrictions.eq("Division.Id", divisionIdForMedicalDivision))
				.addOrder(Order.asc("FirstName").ignoreCase()).list();
		
		bonusList = session.createCriteria(HrMasBonus.class).list();
		hospitalList = session.createCriteria(MasHospital.class).list();
		payStructureElementList = session.createCriteria(HrEmployeePayStructure.class).list();
		map.put("employeeList", employeeList);
		map.put("bonusList", bonusList);
		map.put("bonusDetailList", bonusDetailList);
		map.put("hospitalList", hospitalList);
		map.put("payStructureElementList", payStructureElementList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> saveBonusDetail(HrBonusDetail hrBonusDetail) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrBonusDetail> bonusDetailList = new ArrayList<HrBonusDetail>();
		List<HrBonusDetail> existingBonusDetailList = new ArrayList<HrBonusDetail>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<HrMasBonus> bonusList = new ArrayList<HrMasBonus>();
		List<HrEmployeePayStructure> payStructureElementList = new ArrayList<HrEmployeePayStructure>();
		int divisionIdForMedicalDivision = Integer.parseInt(HMSUtil.getProperties("adt.properties", "divisionIdForMedicalDivision"));
		Session session = (Session)getSession();
		int employeeId = hrBonusDetail.getEmployee().getId();
		SimpleDateFormat sdf= new  SimpleDateFormat("yyyy-MM-dd");
		String paidDate = sdf.format(hrBonusDetail.getPaidDate());
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		existingBonusDetailList = getHibernateTemplate().find("from jkt.hms.masters.business.HrBonusDetail as detail where detail.Employee.Id = "+employeeId+" and detail.PaidDate = '"+paidDate+"' ");
		String message = "";
		if(existingBonusDetailList.size()>0){
			message = "Record already Exist";
		}else{
			hbt.save(hrBonusDetail);
			message = "Record save successfully";
		}
		bonusDetailList = session.createCriteria(HrBonusDetail.class).list();
		
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y"))
				.add(Restrictions.eq("Division.Id", divisionIdForMedicalDivision))
				.addOrder(Order.asc("FirstName").ignoreCase()).list();
		
		bonusList = session.createCriteria(HrMasBonus.class).list();
		payStructureElementList = session.createCriteria(HrEmployeePayStructure.class).list();
		System.out.println("payStructureElementList======"+payStructureElementList.size());
		map.put("employeeList", employeeList);
		map.put("bonusList", bonusList);
		map.put("bonusDetailList", bonusDetailList);
		map.put("message", message);
		map.put("payStructureElementList", payStructureElementList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> updateBonusDetail(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrBonusDetail> bonusDetailList = new ArrayList<HrBonusDetail>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<HrMasBonus> bonusList = new ArrayList<HrMasBonus>();
		List<HrEmployeePayStructure> payStructureElementList = new ArrayList<HrEmployeePayStructure>();
		Session session = (Session)getSession();
		int divisionIdForMedicalDivision = Integer.parseInt(HMSUtil.getProperties("adt.properties", "divisionIdForMedicalDivision"));
		boolean updated = false;
		int bonusDetailId = 0;
		if (generalMap.get("bonusDetailId")!= null) {
			bonusDetailId =(Integer) generalMap.get("bonusDetailId");
		}
		int employeeId = 0;
		if (generalMap.get("employeeId")!= null) {
			employeeId =(Integer) generalMap.get("employeeId");
		}
		int bonusId = 0;
		if (generalMap.get("bonusId")!= null) {
			bonusId =(Integer) generalMap.get("bonusId");
		}
		Date fromDate = new Date();
		if (generalMap.get("fromDate")!= null) {
			fromDate =(Date) generalMap.get("fromDate");
		}
		Date toDate = new Date();
		if (generalMap.get("toDate")!= null) {
			toDate =(Date) generalMap.get("toDate");
		}
		BigDecimal bonusAmuont = null;
		if (generalMap.get("bonusAmuont")!= null) {
			bonusAmuont =(BigDecimal) generalMap.get("bonusAmuont");
		}
		Date paidDate = new Date();
		if (generalMap.get("paidDate")!= null) {
			paidDate =(Date) generalMap.get("paidDate");
		}
		Date dueDate = new Date();
		if (generalMap.get("dueDate")!= null) {
			dueDate =(Date) generalMap.get("dueDate");
		}
		String remark  = "";
		if (generalMap.get("remark")!= null) {
			remark =(String) generalMap.get("remark");
		}
		Users	changedBy = null;
		if (generalMap.get("changedBy")!= null) {
			changedBy = (Users)generalMap.get("changedBy");
		}
		Date currentDate = new Date();
		if (generalMap.get("currentDate")!= null) {
			currentDate = (Date)generalMap.get("currentDate");
		}
		String	currentTime = "";
	    if (generalMap.get("currentTime")!= null) {
	    	currentTime = (String)generalMap.get("currentTime");
		}
	    org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		HrBonusDetail hrBonusDetail = (HrBonusDetail)hbt.load(HrBonusDetail.class, bonusDetailId);
		
		MasEmployee masEmployee = new MasEmployee();
		masEmployee.setId(employeeId);
		hrBonusDetail.setEmployee(masEmployee);
		
		HrMasBonus hrMasBonus = new HrMasBonus();
		hrMasBonus.setId(bonusId);
		hrBonusDetail.setBonus(hrMasBonus);
		hrBonusDetail.setFromDate(fromDate);
		hrBonusDetail.setToDate(toDate);
		hrBonusDetail.setBonusAmount(bonusAmuont);
		hrBonusDetail.setPaidDate(paidDate);
		hrBonusDetail.setDueDate(dueDate);
		hrBonusDetail.setRemarks(remark);
		hrBonusDetail.setLastChgBy(changedBy);
		hrBonusDetail.setLastChgDate(currentDate);
		hrBonusDetail.setLastChgTime(currentTime);
		hbt.update(hrBonusDetail);
		updated =  true;
		String message = "";
		if(updated){
			message = "Data update Successfully.";
		}else{
			message = "Some Problem Occured.";
		}
		payStructureElementList = session.createCriteria(HrEmployeePayStructure.class).list();
		bonusDetailList = session.createCriteria(HrBonusDetail.class).list();
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y"))
				.add(Restrictions.eq("Division.Id", divisionIdForMedicalDivision))
				.addOrder(Order.asc("FirstName").ignoreCase()).list();
		bonusList = session.createCriteria(HrMasBonus.class).list();
		map.put("employeeList", employeeList);
		map.put("bonusList", bonusList);
		map.put("bonusDetailList", bonusDetailList);
		map.put("message", message);
		map.put("payStructureElementList", payStructureElementList);
		return map;
	}

	public Map<String, Object> showAdvanceJsp(Map<String,Object> detailMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		List<HrAdvance> advanceList = new ArrayList<HrAdvance>();
		int centreId =(Integer) detailMap.get("centreId");
		Session session = (Session)getSession();
		int divisionIdForMedicalDivision = Integer.parseInt(HMSUtil.getProperties("adt.properties", "divisionIdForMedicalDivision"));
		hospitalList = session.createCriteria(MasHospital.class).list();
		
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y"))
				.add(Restrictions.eq("Division.Id", divisionIdForMedicalDivision))
				.addOrder(Order.asc("FirstName").ignoreCase()).list();
		
		advanceList = session.createCriteria(HrAdvance.class).list();
		map.put("employeeList", employeeList);
		map.put("hospitalList", hospitalList);
		map.put("advanceList", advanceList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> saveAdvance( Map<String, Object> detailMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrAdvance> advanceList = new ArrayList<HrAdvance>();
		List<HrAdvance> existingAdvanceList = new ArrayList<HrAdvance>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		Session session = (Session)getSession();
		int divisionIdForMedicalDivision = Integer.parseInt(HMSUtil.getProperties("adt.properties", "divisionIdForMedicalDivision"));

		HrAdvance hrAdvance  = (HrAdvance)detailMap.get("hrAdvance");
		int employeeId = hrAdvance.getEmployee().getId();
		SimpleDateFormat sdf= new  SimpleDateFormat("yyyy-MM-dd");
		String advanceDate = sdf.format(hrAdvance.getAdvanceDate());
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		String message = "";
		existingAdvanceList = getHibernateTemplate().find("from jkt.hms.masters.business.HrAdvance as advance where advance.Employee.Id = "+employeeId+" and advance.AdvanceDate = '"+advanceDate+"' ");
		if(existingAdvanceList.size()>0){
			message = "Record already Exist";
		}else{
			hbt.save(hrAdvance);
			message = "Record saved successfully!";
		}
		advanceList = session.createCriteria(HrAdvance.class).list();
		
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y"))
				.add(Restrictions.eq("Division.Id", divisionIdForMedicalDivision))
				.addOrder(Order.asc("FirstName").ignoreCase()).list();
		
		map.put("employeeList", employeeList);
		map.put("advanceList", advanceList);
		map.put("message", message);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> updateAdvance(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrAdvance> advanceList = new ArrayList<HrAdvance>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		Session session = (Session)getSession();
		boolean updated = false;
		int advanceId = 0;
		int divisionIdForMedicalDivision = Integer.parseInt(HMSUtil.getProperties("adt.properties", "divisionIdForMedicalDivision"));
		if (generalMap.get("advanceId")!= null) {
			advanceId = (Integer)generalMap.get("advanceId");
		}
		int employeeId = 0;
		if (generalMap.get("employeeId")!= null) {
			employeeId = (Integer)generalMap.get("employeeId");
		}
		String advanceCode = "";
		if (generalMap.get("advanceCode")!= null) {
			advanceCode = (String)generalMap.get("advanceCode");
		}
		Date advanceDate = new Date();
		if (generalMap.get("advanceDate")!= null) {
			advanceDate = (Date)generalMap.get("advanceDate");
		}
		BigDecimal advanceAmount = null;
		if (generalMap.get("advanceAmount")!= null) {
			advanceAmount = (BigDecimal)generalMap.get("advanceAmount");
		}
		String recoveryMode = "";
		if (generalMap.get("recoveryMode")!= null) {
			recoveryMode = (String)generalMap.get("recoveryMode");
		}
		BigDecimal monthlyDeduction = null;
		if (generalMap.get("monthlyDeduction")!= null) {
			monthlyDeduction = (BigDecimal)generalMap.get("monthlyDeduction");
		}
		BigDecimal recoveredHeaderAmount = null;
		if (generalMap.get("recoveredHeaderAmount")!= null) {
			recoveredHeaderAmount = (BigDecimal)generalMap.get("recoveredHeaderAmount");
		}
		Float recoveryPeriod=null;
		if (generalMap.get("recoveryPeriod")!= null) {
			recoveryPeriod = (Float)(generalMap.get("recoveryPeriod"));
		}
		String	changedBy = "";
		if (generalMap.get("changedBy")!= null) {
			changedBy = (String)generalMap.get("changedBy");
		}
		Date currentDate = new Date();
		if (generalMap.get("currentDate")!= null) {
			currentDate = (Date)generalMap.get("currentDate");
		}
		String	currentTime = "";
	    if (generalMap.get("currentTime")!= null) {
	    	currentTime = (String)generalMap.get("currentTime");
		}
	    Users user=null;
	    if (generalMap.get("user")!= null) {
	    	user = (Users)generalMap.get("user");
		}
	    org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		HrAdvance hrAdvance = (HrAdvance)hbt.load(HrAdvance.class, advanceId);
		MasEmployee masEmployee = new MasEmployee();
		masEmployee.setId(employeeId);
		hrAdvance.setEmployee(masEmployee);
		hrAdvance.setAdvanceCode(advanceCode);
		hrAdvance.setAdvanceDate(advanceDate);
		hrAdvance.setAdvanceAmount(advanceAmount);
		hrAdvance.setRecoveryMode(recoveryMode);
		hrAdvance.setRecoveryPeriod(recoveryPeriod);
		hrAdvance.setRecoveredAmount(recoveredHeaderAmount);
		hrAdvance.setMonthlyDeduction(monthlyDeduction);
		hrAdvance.setLastChgBy(user);
		hrAdvance.setLastChgDate(currentDate);
		hrAdvance.setLastChgTime(currentTime);
		hbt.update(hrAdvance);
		updated =  true;
		String message = "";
		if(updated){
			message = "Data update Successfully.";
		}else{
			message = "Some Problem Occured.";
		}
		advanceList = session.createCriteria(HrAdvance.class).list();
		
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y"))
				.add(Restrictions.eq("Division.Id", divisionIdForMedicalDivision))
				.addOrder(Order.asc("FirstName").ignoreCase()).list();
		
		map.put("employeeList", employeeList);
		map.put("advanceList", advanceList);
		map.put("message", message);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> showAdvanceDetailJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<HrAdvance> advanceList = new ArrayList<HrAdvance>();
		List<HrAdvanceDetail> advanceDetailList = new ArrayList<HrAdvanceDetail>();
		Session session = (Session)getSession();
		
		int divisionIdForMedicalDivision = Integer.parseInt(HMSUtil.getProperties("adt.properties", "divisionIdForMedicalDivision"));
		
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y"))
				.add(Restrictions.eq("Division.Id", divisionIdForMedicalDivision))
				.addOrder(Order.asc("FirstName").ignoreCase()).list();
		advanceDetailList = session.createCriteria(HrAdvanceDetail.class).list();
		advanceList = session.createCriteria(HrAdvance.class).list();
		map.put("employeeList", employeeList);
		map.put("advanceList", advanceList);
		map.put("advanceDetailList", advanceDetailList);
		return map;
	}

	public Map<String, Object> saveAdvanceDetail(HrAdvanceDetail hrAdvanceDetail) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<HrAdvanceDetail> advanceDetailList = new ArrayList<HrAdvanceDetail>();
		List<HrAdvanceDetail> existingAdvanceList = new ArrayList<HrAdvanceDetail>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<HrAdvance> advanceList = new ArrayList<HrAdvance>();
		
		int divisionIdForMedicalDivision = Integer.parseInt(HMSUtil.getProperties("adt.properties", "divisionIdForMedicalDivision"));
		int advanceId = hrAdvanceDetail.getAdvance().getId();
		
		BigDecimal recoveredDetailAmount = hrAdvanceDetail.getRecoveredAmount();
		System.out.println(advanceId+"<<<<recoveredDetailAmount---------"+hrAdvanceDetail.getRecoveredAmount());
		SimpleDateFormat sdf= new  SimpleDateFormat("yyyy-MM-dd");
		String recoveryDate = sdf.format(hrAdvanceDetail.getRecoveryDate());
		String message = "";
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		
		HrAdvance hrAdvance = (HrAdvance)hbt.load(HrAdvance.class, advanceId);
		BigDecimal recoveredHeaderAmt = null;
		if(hrAdvance.getRecoveredAmount()!= null){
		recoveredHeaderAmt = hrAdvance.getRecoveredAmount();
		}
		System.out.println("recoveredHeaderAmt---------"+hrAdvance.getRecoveredAmount());
		BigDecimal totalrecAmount =recoveredDetailAmount.add(recoveredHeaderAmt);
		System.out.println("totalrecAmount---------"+totalrecAmount);
		//if (totalrecAmount.ROUND_UP == advanceAmount.ROUND_UP) {
			hrAdvance.setRecoveredAmount(totalrecAmount);
			hbt.saveOrUpdate(hrAdvance);
			 hbt.flush();
			hbt.refresh(hrAdvance);

		existingAdvanceList = getHibernateTemplate().find("from jkt.hms.masters.business.HrAdvanceDetail as  detail where detail.RecoveryDate = '"+recoveryDate+"' and detail.Advance.Id = '"+advanceId+"'");
		if(existingAdvanceList.size()>0){
			message = "Record already Exist";
		}else{
			hbt.save(hrAdvanceDetail);
			message = "Record saved successfully!";
		}
		
		advanceList = session.createCriteria(HrAdvance.class).list();
		advanceDetailList = session.createCriteria(HrAdvanceDetail.class).list();
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y"))
				.add(Restrictions.eq("Division.Id", divisionIdForMedicalDivision))
				.addOrder(Order.asc("FirstName").ignoreCase()).list();
		map.put("advanceDetailList", advanceDetailList);
		map.put("message", message);
		map.put("advanceList", advanceList);
		map.put("employeeList", employeeList);
		return map;
	}

	public Map<String, Object> updateAdvanceDetail(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrAdvanceDetail> advanceDetailList = new ArrayList<HrAdvanceDetail>();
		List<HrAdvanceDetail> recAmountadvanceDetailList = new ArrayList<HrAdvanceDetail>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<HrAdvance> advanceList = new ArrayList<HrAdvance>();
		Session session = (Session)getSession();
		int divisionIdForMedicalDivision = Integer.parseInt(HMSUtil.getProperties("adt.properties", "divisionIdForMedicalDivision"));
		boolean updated = false;
		int advanceDetailId = 0;
		if (generalMap.get("advanceDetailId")!= null) {
			advanceDetailId = (Integer)generalMap.get("advanceDetailId");
		}
		int advanceId  = 0;
		if (generalMap.get("advanceId")!= null) {
			advanceId = (Integer)generalMap.get("advanceId");
		}
		BigDecimal recoveredDetailAmount = null;
		if (generalMap.get("recoveredDetailAmount")!= null) {
			recoveredDetailAmount = (BigDecimal)generalMap.get("recoveredDetailAmount");
		}
		System.out.println("recoveredDetailAmount----------"+recoveredDetailAmount);
		Date recoveryDate = new Date();
		if (generalMap.get("recoveryDate")!= null) {
			recoveryDate = (Date)generalMap.get("recoveryDate");
		}
		String remark = "";
		if (generalMap.get("remark")!= null) {
			remark = (String)generalMap.get("remark");
		}
		Users changedBy  = null;
		if (generalMap.get("changedBy")!= null) {
			changedBy = (Users)generalMap.get("changedBy");
		}
		Date currentDate = new Date();
		if (generalMap.get("currentDate")!= null) {
			currentDate = (Date)generalMap.get("currentDate");
		}
		String	currentTime = "";
	    if (generalMap.get("currentTime")!= null) {
	    	currentTime = (String)generalMap.get("currentTime");
		}
	    BigDecimal updateDetailRecAmount = null;
	    recAmountadvanceDetailList = session.createCriteria(HrAdvanceDetail.class).add(Restrictions.idEq(advanceDetailId)).list();
	    if (recAmountadvanceDetailList.size()>0) {
	    	HrAdvanceDetail hrAdvanceDetail = (HrAdvanceDetail)recAmountadvanceDetailList.get(0);
	    	updateDetailRecAmount = hrAdvanceDetail.getRecoveredAmount();
		}
	    System.out.println("updateDetailRecAmount-----------"+updateDetailRecAmount);
	    org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		HrAdvance hrAdvance = (HrAdvance)hbt.load(HrAdvance.class, advanceId);
		BigDecimal	recoHeaderAmount = null;
		if(hrAdvance.getRecoveredAmount()!= null){
		recoHeaderAmount = hrAdvance.getRecoveredAmount();
		}
		System.out.println("recoHeaderAmount-----------"+recoHeaderAmount);
		BigDecimal	balanceRecAmount = recoHeaderAmount.subtract(updateDetailRecAmount);
		System.out.println("balanceRecAmount-----------"+balanceRecAmount);
		BigDecimal totalRecHeaderAmount = balanceRecAmount.add(recoveredDetailAmount);
		System.out.println("totalRecHeaderAmount----"+totalRecHeaderAmount);
		hrAdvance.setRecoveredAmount(totalRecHeaderAmount);
		hbt.update(hrAdvance);
		
		HrAdvanceDetail hrAdvanceDetail = (HrAdvanceDetail)hbt.load(HrAdvanceDetail.class, advanceDetailId);
		hrAdvance.setId(advanceId);
		hrAdvanceDetail.setAdvance(hrAdvance);
		hrAdvanceDetail.setRecoveredAmount(recoveredDetailAmount);
		hrAdvanceDetail.setRecoveryDate(recoveryDate);
		hrAdvanceDetail.setRemark(remark);
		hrAdvanceDetail.setLastChgBy(changedBy);
		hrAdvanceDetail.setLastChgDate(currentDate);
		hrAdvanceDetail.setLastChgTime(currentTime);
		hbt.update(hrAdvanceDetail);
		updated =  true;
		String message = "";
		if(updated){
			message = "Data update Successfully.";
		}else{
			message = "Some Problem Occured.";
		}
		advanceList = session.createCriteria(HrAdvance.class).list();
		advanceDetailList = session.createCriteria(HrAdvanceDetail.class).list();
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y"))
				.add(Restrictions.eq("Division.Id", divisionIdForMedicalDivision))
				.addOrder(Order.asc("FirstName").ignoreCase()).list();
		map.put("advanceDetailList", advanceDetailList);
		map.put("message", message);
		map.put("advanceList", advanceList);
		map.put("employeeList", employeeList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showArrearJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<HrMasPayElement> payElementList = new ArrayList<HrMasPayElement>();
		List<HrArrear> arrearList = new ArrayList<HrArrear>();
		Session session = (Session)getSession();
		int divisionIdForMedicalDivision = Integer.parseInt(HMSUtil.getProperties("adt.properties", "divisionIdForMedicalDivision"));
		
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y"))
				.add(Restrictions.eq("Division.Id", divisionIdForMedicalDivision))
				.addOrder(Order.asc("FirstName").ignoreCase()).list();
		
		payElementList = session.createCriteria(HrMasPayElement.class).list();
		arrearList = session.createCriteria(HrArrear.class).list();
		map.put("employeeList", employeeList);
		map.put("payElementList", payElementList);
		map.put("arrearList", arrearList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> saveArrear(HrArrear hrArrear) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrArrear> existingArrearList = new ArrayList<HrArrear>();
		List<HrArrear> arrearList = new ArrayList<HrArrear>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<HrMasPayElement> payElementList = new ArrayList<HrMasPayElement>();
		Session session = (Session)getSession();
		int divisionIdForMedicalDivision = Integer.parseInt(HMSUtil.getProperties("adt.properties", "divisionIdForMedicalDivision"));
		int employeeId = hrArrear.getEmployee().getId();
		SimpleDateFormat sdf= new  SimpleDateFormat("yyyy-MM-dd");
		String fromDate = sdf.format(hrArrear.getFromDate());
		String toDate = sdf.format(hrArrear.getToDate());
		String message = "";
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		
		int payelement = hrArrear.getPayElement().getId();
		
		existingArrearList = getHibernateTemplate().find("from jkt.hms.masters.business.HrArrear as  arrear where arrear.FromDate <= '"+fromDate+"' and arrear.ToDate >= '"+toDate+"' and arrear.PayElement.Id="+payelement+" and arrear.Employee.Id = '"+employeeId+"'");
		if(existingArrearList.size()>0){
			message = "Record already Exist";
		}else{
			hbt.save(hrArrear);
			message = "Record saved successfully!";
		}
		arrearList = session.createCriteria(HrArrear.class).list();
	
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y"))
				.add(Restrictions.eq("Division.Id", divisionIdForMedicalDivision))
				.addOrder(Order.asc("FirstName").ignoreCase()).list();
		payElementList = session.createCriteria(HrMasPayElement.class).list();
		map.put("employeeList", employeeList);
		map.put("payElementList", payElementList);
		map.put("message", message);
		map.put("arrearList", arrearList);
		return map;
	}

	@SuppressWarnings({ "unchecked", "unchecked" })
	public Map<String, Object> updateArrear(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrArrear> arrearList = new ArrayList<HrArrear>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<HrMasPayElement> payElementList = new ArrayList<HrMasPayElement>();
		Session session = (Session)getSession();
		int divisionIdForMedicalDivision = Integer.parseInt(HMSUtil.getProperties("adt.properties", "divisionIdForMedicalDivision"));
		boolean updated = false;
		int arrearId = 0;
		if (generalMap.get("arrearId")!= null) {
			arrearId = (Integer)generalMap.get("arrearId");
		}
		int employeeId = 0;
		if (generalMap.get("employeeId")!= null) {
			employeeId = (Integer)generalMap.get("employeeId");
		}
		int payElementId = 0;
		if (generalMap.get("payElementId")!= null) {
			payElementId = (Integer)generalMap.get("payElementId");
		}
		Date fromDate = new Date();
		if (generalMap.get("fromDate")!= null) {
			fromDate = (Date)generalMap.get("fromDate");
		}
		Date toDate = new Date();
		if (generalMap.get("toDate")!= null) {
			toDate = (Date)generalMap.get("toDate");
		}
		BigDecimal arrearAmount = null;
		if (generalMap.get("arrearAmount")!= null) {
			arrearAmount = (BigDecimal)generalMap.get("arrearAmount");
		}
		String pf = "";
		if (generalMap.get("pf")!= null) {
			pf = (String)generalMap.get("pf");
		}
		Date arrearDate = new Date();
		if (generalMap.get("arrearDate")!= null) {
			arrearDate = (Date)generalMap.get("arrearDate");
		}
		Date paidDate = null;
		if (generalMap.get("paidDate")!= null) {
			paidDate = (Date)generalMap.get("paidDate");
		}
		String arrearStatus = "";
		if (generalMap.get("arrearStatus")!= null) {
			arrearStatus = (String)generalMap.get("arrearStatus");
		}
		String remark = "";
		if (generalMap.get("remark")!= null) {
			remark = (String)generalMap.get("remark");
		}
		Users 	changedBy = null;
		if (generalMap.get("changedBy")!= null) {
			changedBy = (Users)generalMap.get("changedBy");
		}
		Date currentDate = new Date();
		if (generalMap.get("currentDate")!= null) {
			currentDate = (Date)generalMap.get("currentDate");
		}
		String	currentTime = "";
	    if (generalMap.get("currentTime")!= null) {
	    	currentTime = (String)generalMap.get("currentTime");
		}
	    org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		HrArrear hrArrear = (HrArrear)hbt.load(HrArrear.class, arrearId);
		
		MasEmployee masEmployee = new MasEmployee();
		masEmployee.setId(employeeId);
		hrArrear.setEmployee(masEmployee);
		
		HrMasPayElement hrMasPayElement = new HrMasPayElement();
		hrMasPayElement.setId(payElementId);
		hrArrear.setPayElement(hrMasPayElement);
		hrArrear.setFromDate(fromDate);
		hrArrear.setToDate(toDate);
		hrArrear.setArrearAmount(arrearAmount);
		hrArrear.setArrearDate(arrearDate);
		hrArrear.setPf(pf);
		hrArrear.setPaidDate(paidDate);
		hrArrear.setArrearStatus(arrearStatus);
		hrArrear.setRemark(remark);
		hrArrear.setLastChgBy(changedBy);
		hrArrear.setLastChgDate(currentDate);
		hrArrear.setLastChgTime(currentTime);
		hbt.update(hrArrear);
		updated =  true;
		String message = "";
		if(updated){
			message = "Data update Successfully.";
		}else{
			message = "Some Problem Occured.";
		}
		arrearList = session.createCriteria(HrArrear.class).list();
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y"))
				.add(Restrictions.eq("Division.Id", divisionIdForMedicalDivision))
				.addOrder(Order.asc("FirstName").ignoreCase()).list();
		payElementList = session.createCriteria(HrMasPayElement.class).list();
		map.put("employeeList", employeeList);
		map.put("payElementList", payElementList);
		map.put("message", message);
		map.put("arrearList", arrearList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showArrearSalaryJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<HrArrearSalary> arrearSalaryList = new ArrayList<HrArrearSalary>();
		Session session = (Session)getSession();
		int divisionIdForMedicalDivision = Integer.parseInt(HMSUtil.getProperties("adt.properties", "divisionIdForMedicalDivision"));
		
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y"))
				.add(Restrictions.eq("Division.Id", divisionIdForMedicalDivision))
				.addOrder(Order.asc("FirstName").ignoreCase()).list();
		arrearSalaryList = session.createCriteria(HrArrearSalary.class).list();
		map.put("employeeList", employeeList);
		map.put("arrearSalaryList", arrearSalaryList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> saveArrearSalary(HrArrearSalary hrArrearSalary) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrArrearSalary> arrearSalaryList = new ArrayList<HrArrearSalary>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<HrArrearSalary> existingArrearSalaryList = new ArrayList<HrArrearSalary>();
		Session session = (Session)getSession();
		int employeeId = hrArrearSalary.getEmployee().getId();
		SimpleDateFormat sdf= new  SimpleDateFormat("yyyy-MM-dd");
		String fromDate = sdf.format(hrArrearSalary.getFromDate());
		String toDate = sdf.format(hrArrearSalary.getToDate());;
		String message = "";
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		
		int divisionIdForMedicalDivision = Integer.parseInt(HMSUtil.getProperties("adt.properties", "divisionIdForMedicalDivision"));
		
		existingArrearSalaryList = getHibernateTemplate().find("from jkt.hms.masters.business.HrArrearSalary as  salary where salary.FromDate <= '"+fromDate+"' and salary.ToDate >= '"+toDate+"'  and salary.Employee.Id = '"+employeeId+"'");
		if(existingArrearSalaryList.size()>0){
			message = "Record already Exist";
		}else{
			hbt.save(hrArrearSalary);
			message = "Record saved successfully!";
		}
		arrearSalaryList = session.createCriteria(HrArrearSalary.class).list();
		
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y"))
				.add(Restrictions.eq("Division.Id", divisionIdForMedicalDivision))
				.addOrder(Order.asc("FirstName").ignoreCase()).list();
		map.put("employeeList", employeeList);
		map.put("arrearSalaryList", arrearSalaryList);
		map.put("message", message);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> updateArrearSalary(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrArrearSalary> arrearSalaryList = new ArrayList<HrArrearSalary>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		Session session = (Session)getSession();
		int divisionIdForMedicalDivision = Integer.parseInt(HMSUtil.getProperties("adt.properties", "divisionIdForMedicalDivision"));
		arrearSalaryList = session.createCriteria(HrArrearSalary.class).list();
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y"))
				.add(Restrictions.eq("Division.Id", divisionIdForMedicalDivision))
				.addOrder(Order.asc("FirstName").ignoreCase()).list();
		
		map.put("employeeList", employeeList);
		map.put("arrearSalaryList", arrearSalaryList);
		int arrearSalaryId = 0;
		if (generalMap.get("arrearSalaryId")!= null) {
			arrearSalaryId = (Integer)generalMap.get("arrearSalaryId");
		}
		int employeeId = 0;
		if (generalMap.get("employeeId")!= null) {
			employeeId = (Integer)generalMap.get("employeeId");
		}
		Date fromDate = new Date();
		if (generalMap.get("fromDate")!= null) {
			fromDate = (Date)generalMap.get("fromDate");
		}
		Date toDate = new Date();
		if (generalMap.get("toDate")!= null) {
			toDate = (Date)generalMap.get("toDate");
		}
		Date paymentDate = null;
		if (generalMap.get("paymentDate")!= null) {
			paymentDate = (Date)generalMap.get("paymentDate");
		}
	
		
		String remark = "";
		if(generalMap.get("remark")!= null){
			remark = (String)generalMap.get("remark");
		}
		Users	changedBy = null;
		if (generalMap.get("changedBy")!= null) {
			changedBy = (Users)generalMap.get("changedBy");
		}
		Date currentDate = new Date();
		if (generalMap.get("currentDate")!= null) {
			currentDate = (Date)generalMap.get("currentDate");
		}
		String	currentTime = "";
	    if (generalMap.get("currentTime")!= null) {
	    	currentTime = (String)generalMap.get("currentTime");
		}
	  
		
		
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		System.out.println(arrearSalaryId+"----------------arrearSalaryId");

		
		HrArrearSalary hrArrearSalary = (HrArrearSalary)hbt.load(HrArrearSalary.class, arrearSalaryId);
		MasEmployee masEmployee = new MasEmployee();
		masEmployee.setId(employeeId);
		hrArrearSalary.setEmployee(masEmployee);
		hrArrearSalary.setFromDate(fromDate);
		hrArrearSalary.setToDate(toDate);
		if(generalMap.get("arrearDays")!= null){
			Float arrearDays = (Float)generalMap.get("arrearDays");
			hrArrearSalary.setArrearDays(arrearDays);
		}
		
		hrArrearSalary.setRemark(remark);
		hrArrearSalary.setLastChgBy(changedBy);
		hrArrearSalary.setLastChgDate(currentDate);
		hrArrearSalary.setLastChgTime(currentTime);
		hrArrearSalary.setPaymentDate(paymentDate);
		hbt.update(hrArrearSalary);
		
		
		successfullyAdded =  true;
		String message = "";
		if(successfullyAdded){
			message = "Data update Successfully.";
		}else{
			message = "Some Problem Occured.";
		}
		
		map.put("message", message);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showAdvanceStatementJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		Session session = (Session)getSession();
		int divisionIdForMedicalDivision = Integer.parseInt(HMSUtil.getProperties("adt.properties", "divisionIdForMedicalDivision"));
		
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y"))
				.add(Restrictions.eq("Division.Id", divisionIdForMedicalDivision))
				.addOrder(Order.asc("FirstName").ignoreCase()).list();
		departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Division.Id", divisionIdForMedicalDivision)).add(Restrictions.eq("Status", "y")).list();	
		rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status","y")).list();
		map.put("employeeList", employeeList);
		map.put("departmentList", departmentList);
		map.put("rankList", rankList);
		return map;
	}

	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		Connection con = session.connection();
		map.put("conn",con);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showloanstatement() {
		// TODO Auto-generated method stub

		Map<String, Object>  map=new HashMap<String, Object>();
		Session session=getSession();
		int divisionIdForMedicalDivision = Integer.parseInt(HMSUtil.getProperties("adt.properties", "divisionIdForMedicalDivision"));
		try{
			List<MasEmployee>employeeList=new ArrayList<MasEmployee>();
			List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y"))
					.add(Restrictions.eq("Division.Id", divisionIdForMedicalDivision))
					.addOrder(Order.asc("FirstName").ignoreCase()).list();
											
					departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Division.Id", divisionIdForMedicalDivision)).add(Restrictions.eq("Status", "y")).list();	
			map.put("departmentList", departmentList);
			map.put("employeeList", employeeList);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	
	}

	

	

	
}
