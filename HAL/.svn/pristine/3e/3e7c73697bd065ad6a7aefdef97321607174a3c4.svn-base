
package jkt.hms.account.dataservice;

import static jkt.hms.util.RequestConstants.ACCOUNT_GROUP_ID;
import static jkt.hms.util.RequestConstants.ACCOUNT_ID;
import static jkt.hms.util.RequestConstants.ACCOUNT_NAME;
import static jkt.hms.util.RequestConstants.ACCOUNT_NARRATION;
import static jkt.hms.util.RequestConstants.ACCOUNT_SUB_GROUP_ID;
import static jkt.hms.util.RequestConstants.AMOUNT;
import static jkt.hms.util.RequestConstants.AS_ON_DATE;
import static jkt.hms.util.RequestConstants.BALANCE_TYPE;
import static jkt.hms.util.RequestConstants.BANK_ACCOUNT;
import static jkt.hms.util.RequestConstants.BANK_NAME;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CHEQUE_DATE;
import static jkt.hms.util.RequestConstants.CHEQUE_NO;
import static jkt.hms.util.RequestConstants.CHEQUE_STATUS;
import static jkt.hms.util.RequestConstants.COMMON_ID;
import static jkt.hms.util.RequestConstants.COMPANY_BALANCE;
import static jkt.hms.util.RequestConstants.COST_CENTER_ID;
import static jkt.hms.util.RequestConstants.CR_AMOUNT;
import static jkt.hms.util.RequestConstants.DR_AMOUNT;
import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.NARRATION;
import static jkt.hms.util.RequestConstants.OPENING_BALANCE;
import static jkt.hms.util.RequestConstants.OPENING_DATE;
import static jkt.hms.util.RequestConstants.SEARCH_FIELD;
import static jkt.hms.util.RequestConstants.SEARCH_NAME;
import static jkt.hms.util.RequestConstants.SELECTED_RADIO;
import static jkt.hms.util.RequestConstants.SUBLEDGER_ID;
import static jkt.hms.util.RequestConstants.SUB_LDEGER_NAME;
import static jkt.hms.util.RequestConstants.SUB_LEDGER_CODE;
import static jkt.hms.util.RequestConstants.SUB_LEDGER_CODE_BANK;
import static jkt.hms.util.RequestConstants.SUB_LEDGER_ID;
import static jkt.hms.util.RequestConstants.TOTAL_AMOUNT;
import static jkt.hms.util.RequestConstants.TOTAL_CR_AMOUNT;
import static jkt.hms.util.RequestConstants.TOTAL_DR_AMOUNT;
import static jkt.hms.util.RequestConstants.TO_DATE;
import static jkt.hms.util.RequestConstants.VOUCHER_DATE;
import static jkt.hms.util.RequestConstants.VOUCHER_DT_ID;
import static jkt.hms.util.RequestConstants.VOUCHER_HD_ID;
import static jkt.hms.util.RequestConstants.VOUCHER_TYPE;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
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

import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.HrInsuranceDetails;
//import jkt.hms.masters.business.HrMasBonus;
import jkt.hms.masters.business.HrMasFinancialYear;
import jkt.hms.masters.business.HrMasInsurance;

import jkt.hms.masters.business.AccountGroupTransac;
import jkt.hms.masters.business.AccountMainTransac;
import jkt.hms.masters.business.AccountSubGroupTransac;
import jkt.hms.masters.business.AccountSubLedTransac;


import jkt.hms.masters.business.FaAccountOpening;
import jkt.hms.masters.business.FaAccountParameter;
import jkt.hms.masters.business.FaBankReconciliationDetails;
import jkt.hms.masters.business.FaBankReconciliationHeader;
import jkt.hms.masters.business.FaBranchAccountMaster;
import jkt.hms.masters.business.FaChequeCancel;
import jkt.hms.masters.business.FaChequeDetails;
import jkt.hms.masters.business.FaEmdRegister;
import jkt.hms.masters.business.FaMasAccount;
import jkt.hms.masters.business.FaMasAccountGroup;
import jkt.hms.masters.business.FaMasAccountSubGroup;
import jkt.hms.masters.business.FaMasFdRegister;
import jkt.hms.masters.business.FaMasNarration;
import jkt.hms.masters.business.FaMasSubLed;
import jkt.hms.masters.business.FaVoucherDetails;
import jkt.hms.masters.business.FaVoucherHeader;

import jkt.hms.masters.business.MasApprovalStatus;
import jkt.hms.masters.business.MasBankMaster;

import jkt.hms.masters.business.MasCostCenter;

import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasScheduleMaster;
import jkt.hms.masters.business.MasStoreFinancial;
import jkt.hms.masters.business.MasStoreSupplier;

import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.masters.business.Users;

import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StringType;
import org.hibernate.type.Type;
import org.jgroups.tests.adaptjms.Request;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class AccountDataServiceImpl extends HibernateDaoSupport implements AccountDataService {

	//--------------------------------Code by Anamika----------------------------------------------------------------//
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> showAccountsGroupMasterJsp(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> faMasAccountGroupList = new ArrayList<Object[]>();
		Session session = (Session)getSession();
		int fYear = 0;
		int locationId = 0;
		if(generalMap.get("fYear")!= null){
			fYear = (Integer)generalMap.get("fYear");
		}
		if(generalMap.get("locationId")!= null){
			locationId = (Integer)generalMap.get("locationId");
		}
		faMasAccountGroupList = session.createCriteria(FaMasAccountGroup.class)
								.list();
		System.out.println("faMasAccountGroupList=====>>"+faMasAccountGroupList.size());
		map.put("faMasAccountGroupList", faMasAccountGroupList);
		return map;
	}
	
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> searchAccountGroup(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccountGroup> faMasAccountGroupList = new ArrayList<FaMasAccountGroup>();
		Session session = getSession();
		int searchRadio = 0;
		String searchField = "";
		Criteria crit = null;
		searchField = box.getString(SEARCH_FIELD);
		searchRadio = box.getInt(SELECTED_RADIO);

		crit = session.createCriteria(FaMasAccountGroup.class);
					
		if (searchRadio == 1) {
			crit = crit.add(Restrictions.eq("AccountGroupCode", Integer.parseInt(searchField)));

		} else {
			crit = crit.add(Restrictions.like("AccountGroupDesc", searchField+"%"));
		}

		faMasAccountGroupList = crit.add(Restrictions.eq("Status", "y"))
								.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", box.getInt("fYear")))
									.add(Restrictions.eq("Hospital.Id", box.getInt("locationId"))).list();
		map.put("faMasAccountGroupList", faMasAccountGroupList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showAccountMasterJsp(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccountGroup> accountGroupList = new ArrayList<FaMasAccountGroup>();
		List<FaMasAccountSubGroup> accountSubGroupList = new ArrayList<FaMasAccountSubGroup>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		List<MasBankMaster> bankMasterList = new ArrayList<MasBankMaster>();
		Session session = (Session)getSession();
		/*List<HrMasFinancialYear> financialYearList = new ArrayList<HrMasFinancialYear>();
		String currentDate = HMSUtil.convertDateToStringTypeDate(new Date());
		financialYearList = session.createCriteria(HrMasFinancialYear.class).add(Restrictions.le("YearFromDate", HMSUtil.dateFormatterDDMMYYYY(currentDate)))
							.add(Restrictions.ge("YearToDate", HMSUtil.dateFormatterDDMMYYYY(currentDate)))
								.add(Restrictions.eq("Status", "y"))
									.list();
		int fYear = 0;
		if(financialYearList.size()>0){
			for(HrMasFinancialYear financialYear : financialYearList){
				fYear = financialYear.getId();
			}
		}*/
	/*	int branchId  = 0;
		if(generalMap.get("branchId")!= null){
			branchId = (Integer)generalMap.get("branchId");
		}*/
		int accountSubGroupId =0;
		if(generalMap.get("accountSubGroupId") != null){
			accountSubGroupId = (Integer)generalMap.get("accountSubGroupId");
		}
		
		int fYear = 0;
		if(generalMap.get("fYear") != null){
			fYear = (Integer)generalMap.get("fYear");
		}
		int locationId = 0;
		if(generalMap.get("locationId") != null){
			locationId = (Integer)generalMap.get("locationId");
		}
		accountSubGroupList = session.createCriteria(FaMasAccountSubGroup.class).add(Restrictions.eq("Status", "y"))
									.add(Restrictions.eq("FYear.Id", fYear))/*.add(Restrictions.eq("Hospital.Id", locationId))*/.list();
		if(accountSubGroupId != 0){
		accountList = session.createCriteria(FaMasAccount.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("AccountSubGroup.Id", accountSubGroupId))
									.addOrder(Order.asc("AccCode"))/*.add(Restrictions.eq("Hospital.Id", locationId))*/.add(Restrictions.eq("FYear.Id", fYear)).list();
		}else{
			accountList = session.createCriteria(FaMasAccount.class).add(Restrictions.eq("Status", "y"))
								.addOrder(Order.asc("AccCode"))/*.add(Restrictions.eq("Hospital.Id", locationId))*/.add(Restrictions.eq("FYear.Id", fYear)).list();
		}
		
		accountGroupList = session.createCriteria(FaMasAccountGroup.class).add(Restrictions.eq("Status", "y"))
									.add(Restrictions.eq("FYear.Id", fYear))/*.add(Restrictions.eq("Hospital.Id", locationId))*/.list();
		bankMasterList = session.createCriteria(MasBankMaster.class).add(Restrictions.eq("Status", "y")).list();
		map.put("accountSubGroupList", accountSubGroupList);
		map.put("accountList", accountList);
		map.put("accountGroupList", accountGroupList);
		map.put("accountList", accountList);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> showAccountMasterBalance(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccount> accountListForBalance = new ArrayList<FaMasAccount>();
		List<HrMasFinancialYear> financialYearList = new ArrayList<HrMasFinancialYear>();
		Session session = (Session)getSession();
		int branchId = 0;
		if(generalMap.get("branchId")!= null){
			branchId = (Integer)generalMap.get("branchId");
		}
		String currentDate = HMSUtil.convertDateToStringTypeDate(new Date());
		financialYearList = session.createCriteria(HrMasFinancialYear.class).add(Restrictions.le("YearFromDate", HMSUtil.dateFormatterDDMMYYYY(currentDate)))
							.add(Restrictions.ge("YearToDate", HMSUtil.dateFormatterDDMMYYYY(currentDate)))
								.add(Restrictions.eq("Status", "y"))
									.list();
		int fYear = 0;
		if(financialYearList.size()>0){
			for(HrMasFinancialYear financialYear : financialYearList){
				fYear = financialYear.getId();
			}
		}
		String qry = "select ma.acc_id,ma.acc_code,ma.acc_desc, " +
		" sum(isnull(v.dr_amount,0))as dr_amount ,sum(isnull(v.cr_amount,0))as cr_amount, " +
		" sum(isnull(v.opening_amt_cr,0))as opening_amt_cr,sum(isnull(v.opening_amt_dr,0))as opening_amt_dr, " +
		" (sum(isnull(v.dr_amount,0))+ sum(isnull(v.opening_amt_dr,0)))as TotalDr, " +
		" (sum(isnull(v.cr_amount,0)) +  sum(isnull(v.opening_amt_cr,0))) as TotalCR, " +
		" DrBalance=case when (sum(isnull(v.dr_amount,0))+ sum(isnull(v.opening_amt_dr,0))) " +
		" > (sum(isnull(v.cr_amount,0)) +  sum(isnull(v.opening_amt_cr,0))) " +
		" then (sum(isnull(v.dr_amount,0))+ sum(isnull(v.opening_amt_dr,0))) " +
		" - (sum(isnull(v.cr_amount,0)) +  sum(isnull(v.opening_amt_cr,0))) end, " +
		" CrBalance=case when (sum(isnull(v.cr_amount,0)) +  sum(isnull(v.opening_amt_cr,0))) > " +
		" (sum(isnull(v.dr_amount,0))+ sum(isnull(v.opening_amt_dr,0))) " +
		" then (sum(isnull(v.cr_amount,0)) +  sum(isnull(v.opening_amt_cr,0))) " +
		" - (sum(isnull(v.dr_amount,0))+ sum(isnull(v.opening_amt_dr,0))) " +
		" else 0 end, v.branch_id,v.f_year_id  from vwFinalAccountsBalance v " +
		" right outer join fa_mas_account ma on v.account_id= ma.acc_id  " +
		" where v.branch_id = "+branchId+" and v.f_year_id = "+fYear+"  group by ma.acc_id,ma.acc_code,ma.acc_desc ,v.branch_id,v.f_year_id";

		accountListForBalance =session.createSQLQuery(qry).list();
		map.put("accountListForBalance", accountListForBalance);
		return map;
	}
	
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> getAccCodeForAccSubGrp(Box box) {
		Map<String, Object> map =new HashMap<String, Object>();
		List<Integer> maxAccIdList = new ArrayList<Integer>();
		List<Integer> accCodeList = new ArrayList<Integer>();
		Session session = getSession();
		int accSubGrpId = box.getInt(ACCOUNT_SUB_GROUP_ID);
		Integer subGrpCode = box.getInt("subGrpCode");
		maxAccIdList = session.createCriteria(FaMasAccount.class)
						.createAlias("AccountSubGroup", "subGrp").add(Restrictions.eq("subGrp.Id", accSubGrpId))
						.setProjection(Projections.max("Id"))
						.list();

		int maxAccId = 0;
		Integer accCode = 0;
		if(maxAccIdList.size() > 0 && maxAccIdList.get(0)!= null){
			maxAccId = maxAccIdList.get(0);

			accCodeList = session.createCriteria(FaMasAccount.class)
							.add(Restrictions.idEq(maxAccId))
							.setProjection(Projections.property("AccCode")).list();
			if(accCodeList.size() > 0){
				accCode = Integer.parseInt(accCodeList.get(0).toString())+1;
			}

		}else{

			String acccodestr = "";
			acccodestr =  subGrpCode.toString().concat("01");
			accCode = Integer.parseInt(acccodestr);

		}
		map.put("accCode", accCode);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> addAccountMaster(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccountGroup> accountGroupList = new ArrayList<FaMasAccountGroup>();
		List<FaMasAccountSubGroup> accountSubGroupList = new ArrayList<FaMasAccountSubGroup>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		List<FaMasAccount> existingAccountList = new ArrayList<FaMasAccount>();
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		int  financialYearId = 0;
		int locationId = 0;
		String message = "";
		try {
			FaMasAccount faMasAccount = new FaMasAccount();
			if(generalMap.get("faMasAccount")!= null){
				faMasAccount = (FaMasAccount)generalMap.get("faMasAccount");
			}
			Box box =null;
			if(generalMap.get("box")!= null){
				box = (Box)generalMap.get("box");
			}
			Integer accountCode = faMasAccount.getAccCode();
			String accountName = faMasAccount.getAccDesc();
			
			if(generalMap.get("fYear")!= null){
				financialYearId =(Integer)generalMap.get("fYear");
			}
			if(generalMap.get("locationId")!= null){
				locationId =(Integer)generalMap.get("locationId");
			}
			int groupId =0;
			if(generalMap.get("accountgroupId")!= null){
				groupId = (Integer)generalMap.get("accountgroupId");
			}
			int subGroupId =0;
			if(generalMap.get("accountSubGroupId")!= null){
				subGroupId = (Integer)generalMap.get("accountSubGroupId");
			}
			
			BigDecimal openingBalanceDr = new BigDecimal(0);
			BigDecimal openingBalanceCr = new BigDecimal(0);
			if(generalMap.get("opDrBalance")!= null){
				openingBalanceDr =(BigDecimal)generalMap.get("opDrBalance");
			}else if(generalMap.get("opCrBalance")!= null){
				openingBalanceCr =(BigDecimal)generalMap.get("opCrBalance");
			}
			existingAccountList = session.createCriteria(FaMasAccount.class).add(Restrictions.eq("AccCode", accountCode))
									//.add(Restrictions.eq("FYear.Id", financialYearId))
									.list();
			if (existingAccountList.size() > 0) {
				message = "Record already Exist";
			} else {
				hbt.save(faMasAccount);
				session.refresh(faMasAccount);
				message = "Record saved successfully!";

//-----------------------For Branch Account master------------------------------------------
		//---------commented by anamika on 10/08/2014----------------
				/*int count = 0;
				if(box.getInt("totalBranchId")!= 0){
					count = box.getInt("totalBranchId");
				}
				for (int i = 1; i <= count; i++) {
					FaBranchAccountMaster branchAccountMaster = new FaBranchAccountMaster();
					if(box.getInt("branchId"+i)!=0 ){
						MasBranch masBranch = new MasBranch();
						masBranch.setId(box.getInt("branchId"+i));
						branchAccountMaster.setBranch(masBranch);
						branchAccountMaster.setAccount(faMasAccount);

						if(!box.getString("opBalanceDr"+i).equals("") ){
							branchAccountMaster.setOpBalanceDr(new BigDecimal(box.getString("opBalanceDr"+i)));
							branchAccountMaster.setClBalanceDr(new BigDecimal(box.getString("opBalanceDr"+i)));
						}else if(!box.getString("opBalanceCr"+i).equals("")){
							branchAccountMaster.setOpBalanceCr(new BigDecimal(box.getString("opBalanceCr"+i)));
							branchAccountMaster.setClBalanceCr(new BigDecimal(box.getString("opBalanceCr"+i)));
						}
						hbt.save(branchAccountMaster);

					}
				}*/

			//----------------update account group--------------
			/*BigDecimal groupClBalanceDr = new BigDecimal(0);
			BigDecimal groupClBalanceCr = new BigDecimal(0);

			 FaMasAccountGroup faMasAccountGroup = (FaMasAccountGroup)hbt.load(FaMasAccountGroup.class, groupId);
			 if(faMasAccountGroup.getClBalanceDr() != null)
				 groupClBalanceDr =  faMasAccountGroup.getClBalanceDr();
			 if(faMasAccountGroup.getClBalanceCr() != null)
				 groupClBalanceCr = faMasAccountGroup.getClBalanceCr();

			 if(openingBalanceDr.compareTo(new BigDecimal(0))>0){
				 if(groupClBalanceCr.compareTo(new BigDecimal(0)) > 0){
				 	 if(groupClBalanceCr.compareTo(openingBalanceDr) > 0 ){
						  groupClBalanceCr = groupClBalanceCr.subtract(openingBalanceDr);
						  faMasAccountGroup.setClBalanceCr(groupClBalanceCr);
						  faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
				 	 }else if(openingBalanceDr.compareTo(groupClBalanceCr) > 0 ){
				 		 groupClBalanceDr =openingBalanceDr.subtract(groupClBalanceCr);
				 		 faMasAccountGroup.setClBalanceDr(groupClBalanceDr);
				 		 faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
				 		}else if(groupClBalanceDr.compareTo(openingBalanceCr)==0){
				 		 faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
				 		 faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
				 	 }else if(openingBalanceDr.compareTo(groupClBalanceCr)==0 ){
				 		 faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
				 		 faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
				 	 }
				 }else {
						  groupClBalanceDr = groupClBalanceDr.add(openingBalanceDr);
						  faMasAccountGroup.setClBalanceDr(groupClBalanceDr);
					  }

			}else if(openingBalanceCr.compareTo(new BigDecimal(0))>0){
				if(groupClBalanceDr.compareTo(new BigDecimal(0)) > 0){
				  if(groupClBalanceDr.compareTo(openingBalanceCr) > 0){
					  
					  groupClBalanceDr =groupClBalanceDr.subtract(openingBalanceCr);
					  faMasAccountGroup.setClBalanceDr(groupClBalanceDr);
					  faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
				  }else if(openingBalanceCr.compareTo(groupClBalanceDr) > 0 ){
				 		 groupClBalanceCr =openingBalanceCr.subtract(groupClBalanceDr);
				 		 faMasAccountGroup.setClBalanceCr(groupClBalanceCr);
				 		 faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
				  }else if(openingBalanceCr.compareTo(groupClBalanceDr) == 0 ){
				 		 faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
				 		 faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
				 	 }
				}else{
					  
					  groupClBalanceCr = groupClBalanceCr.add(openingBalanceCr);
					  faMasAccountGroup.setClBalanceCr(groupClBalanceCr);
				  }
			}
			
//-----------------------------------opening Balance--------------------------------------//
			 BigDecimal groupOpBalanceDr = new BigDecimal(0);
				BigDecimal groupOPBalanceCr = new BigDecimal(0);

				 if(faMasAccountGroup.getOpBalanceDr() != null)
					 groupOpBalanceDr =  faMasAccountGroup.getOpBalanceDr();
				 if(faMasAccountGroup.getOpBalanceCr() != null)
					 groupOPBalanceCr = faMasAccountGroup.getOpBalanceCr();
			 if(openingBalanceDr.compareTo(new BigDecimal(0))>0){
				 if(groupOPBalanceCr.compareTo(new BigDecimal(0)) > 0){
				 	 if(groupOPBalanceCr.compareTo(openingBalanceDr) > 0 ){
				 		groupOPBalanceCr = groupOPBalanceCr.subtract(openingBalanceDr);
						  faMasAccountGroup.setOpBalanceCr(groupOPBalanceCr);
						  faMasAccountGroup.setOpBalanceDr(new BigDecimal(0.00));
				 	 }else if(openingBalanceDr.compareTo(groupOPBalanceCr) > 0 ){
				 		groupOpBalanceDr =openingBalanceDr.subtract(groupOPBalanceCr);
				 		 faMasAccountGroup.setOpBalanceDr(groupOpBalanceDr);
				 		 faMasAccountGroup.setOpBalanceCr(new BigDecimal(0.00));
				 	 }else if(openingBalanceDr.compareTo(groupOPBalanceCr)== 0 ){
					 		 faMasAccountGroup.setOpBalanceDr(new BigDecimal(0.00));
					 		 faMasAccountGroup.setOpBalanceCr(new BigDecimal(0.00));
					 	 }
				 }else {
					 groupOpBalanceDr = groupOpBalanceDr.add(openingBalanceDr);
						  faMasAccountGroup.setOpBalanceDr(groupOpBalanceDr);
					  }

			}else if(openingBalanceCr.compareTo(new BigDecimal(0))>0){
				if(groupOpBalanceDr.compareTo(new BigDecimal(0)) > 0){
				  if(groupOpBalanceDr.compareTo(openingBalanceCr) > 0){
					  
					  groupOpBalanceDr =groupOpBalanceDr.subtract(openingBalanceCr);
					  faMasAccountGroup.setOpBalanceDr(groupOpBalanceDr);
					  faMasAccountGroup.setOpBalanceCr(new BigDecimal(0.00));
				  }else if(openingBalanceCr.compareTo(groupOpBalanceDr) > 0 ){
					 
					  groupOPBalanceCr =openingBalanceCr.subtract(groupOpBalanceDr);
				 		 faMasAccountGroup.setOpBalanceCr(groupOPBalanceCr);
				 		 faMasAccountGroup.setOpBalanceDr(new BigDecimal(0.00));
				 	 }else if(openingBalanceCr.compareTo(groupOpBalanceDr) == 0 ){
				 		 faMasAccountGroup.setOpBalanceCr(new BigDecimal(0.00));
				 		 faMasAccountGroup.setOpBalanceDr(new BigDecimal(0.00));
				 	 }
				}else{
					
					groupOPBalanceCr = groupOPBalanceCr.add(openingBalanceCr);
					  faMasAccountGroup.setOpBalanceCr(groupOPBalanceCr);
				  }
			}
			hbt.update(faMasAccountGroup);

				//--------------------------------------------update subGroup group--------------
				BigDecimal subGroupClBalanceDr = new BigDecimal(0);
				BigDecimal subGroupClBalanceCr = new BigDecimal(0);

				FaMasAccountSubGroup faMasAccountSubGroup = (FaMasAccountSubGroup)hbt.load(FaMasAccountSubGroup.class, subGroupId);
				if(faMasAccountSubGroup.getClBalanceDr() != null)
					subGroupClBalanceDr =  faMasAccountSubGroup.getClBalanceDr();
				if(faMasAccountSubGroup.getClBalanceCr() != null)
					subGroupClBalanceCr = faMasAccountSubGroup.getClBalanceCr();


				 if(openingBalanceDr.compareTo(new BigDecimal(0))>0){
					 if(subGroupClBalanceCr.compareTo(new BigDecimal(0)) > 0){
						 if(subGroupClBalanceCr.compareTo(openingBalanceDr) > 0){
					 		 subGroupClBalanceDr = subGroupClBalanceCr.subtract(openingBalanceDr);
					 		 faMasAccountSubGroup.setClBalanceCr(subGroupClBalanceDr);
					 		 faMasAccountSubGroup.setClBalanceDr(new BigDecimal(0.00));
					 	 }else if(openingBalanceDr.compareTo(subGroupClBalanceCr) > 0 ){
					 		subGroupClBalanceDr =openingBalanceDr.subtract(subGroupClBalanceCr);
					 		faMasAccountSubGroup.setClBalanceDr(subGroupClBalanceDr);
					 		faMasAccountSubGroup.setClBalanceCr(new BigDecimal(0.00));
					 	 }else if(openingBalanceDr.compareTo(subGroupClBalanceCr)== 0 ){
						 		faMasAccountSubGroup.setClBalanceDr(new BigDecimal(0.00));
						 		faMasAccountSubGroup.setClBalanceCr(new BigDecimal(0.00));
						 	 }
					 }else{

						  subGroupClBalanceDr = subGroupClBalanceDr.add(openingBalanceDr);
						  faMasAccountSubGroup.setClBalanceDr(subGroupClBalanceDr);
					  }
				}else if(openingBalanceCr.compareTo(new BigDecimal(0))>0){
					 if(subGroupClBalanceDr.compareTo(new BigDecimal(0)) > 0){
						 if(subGroupClBalanceDr.compareTo(openingBalanceCr) > 0){

							  subGroupClBalanceCr = subGroupClBalanceDr.subtract(openingBalanceCr);
							  faMasAccountSubGroup.setClBalanceDr(subGroupClBalanceCr);
							  faMasAccountSubGroup.setClBalanceCr(new BigDecimal(0.00));
						  }else if(openingBalanceCr.compareTo(subGroupClBalanceDr) > 0 ){
							  	subGroupClBalanceCr =openingBalanceCr.subtract(subGroupClBalanceDr);
							  	faMasAccountSubGroup.setClBalanceCr(subGroupClBalanceCr);
							  	faMasAccountSubGroup.setClBalanceDr(new BigDecimal(0.00));
						 	 }else if(openingBalanceCr.compareTo(subGroupClBalanceDr) == 0 ){
								  	subGroupClBalanceCr =openingBalanceCr.subtract(subGroupClBalanceDr);
								  	faMasAccountSubGroup.setClBalanceCr(new BigDecimal(0.00));
								  	faMasAccountSubGroup.setClBalanceDr(new BigDecimal(0.00));
							 	 }
					 }
					 else{
						  subGroupClBalanceCr = subGroupClBalanceCr.add(openingBalanceCr);
						  faMasAccountSubGroup.setClBalanceCr(subGroupClBalanceCr);
					  }
				}
//--------------------------opening Balance------------------------------------------//
				 BigDecimal subGroupOpBalanceDr = new BigDecimal(0);
					BigDecimal subGroupOpBalanceCr = new BigDecimal(0);

					if(faMasAccountSubGroup.getOpBalanceDr() != null)
						subGroupOpBalanceDr =  faMasAccountSubGroup.getOpBalanceDr();
					if(faMasAccountSubGroup.getOpBalanceCr() != null)
						subGroupOpBalanceCr = faMasAccountSubGroup.getOpBalanceCr();


					 if(openingBalanceDr.compareTo(new BigDecimal(0))>0){
						 if(subGroupOpBalanceCr.compareTo(new BigDecimal(0)) > 0){
							 if(subGroupOpBalanceCr.compareTo(openingBalanceDr) > 0){
								 subGroupOpBalanceDr = subGroupOpBalanceCr.subtract(openingBalanceDr);
						 		 faMasAccountSubGroup.setOpBalanceCr(subGroupOpBalanceDr);
						 		 faMasAccountSubGroup.setOpBalanceDr(new BigDecimal(0.00));
						 	 }else if(openingBalanceDr.compareTo(subGroupOpBalanceCr) > 0 ){
						 		subGroupOpBalanceDr =openingBalanceDr.subtract(subGroupOpBalanceCr);
						 		faMasAccountSubGroup.setOpBalanceDr(subGroupOpBalanceDr);
						 		faMasAccountSubGroup.setOpBalanceCr(new BigDecimal(0.00));
						 	 }else if(openingBalanceDr.compareTo(subGroupOpBalanceCr)== 0 ){
							 		faMasAccountSubGroup.setOpBalanceDr(new BigDecimal(0.00));
							 		faMasAccountSubGroup.setOpBalanceCr(new BigDecimal(0.00));
							 	 }
						 }else{

							 subGroupOpBalanceDr = subGroupOpBalanceDr.add(openingBalanceDr);
							  faMasAccountSubGroup.setOpBalanceDr(subGroupOpBalanceDr);
						  }
					}else if(openingBalanceCr.compareTo(new BigDecimal(0))>0){
						 if(subGroupOpBalanceDr.compareTo(new BigDecimal(0)) > 0){
							 if(subGroupOpBalanceDr.compareTo(openingBalanceCr) > 0){

								 subGroupOpBalanceCr = subGroupOpBalanceDr.subtract(openingBalanceCr);
								  faMasAccountSubGroup.setOpBalanceDr(subGroupOpBalanceCr);
								  faMasAccountSubGroup.setOpBalanceCr(new BigDecimal(0.00));
							  }else if(openingBalanceCr.compareTo(subGroupOpBalanceDr) > 0 ){
								  subGroupOpBalanceCr =openingBalanceCr.subtract(subGroupOpBalanceDr);
								  	faMasAccountSubGroup.setOpBalanceCr(subGroupOpBalanceCr);
								  	faMasAccountSubGroup.setOpBalanceDr(new BigDecimal(0.00));
							 	 }else if(openingBalanceCr.compareTo(subGroupOpBalanceDr) == 0 ){
									  	faMasAccountSubGroup.setOpBalanceCr(new BigDecimal(0.00));
									  	faMasAccountSubGroup.setOpBalanceDr(new BigDecimal(0.00));
								 	 }
						 }
						 else{
							 subGroupOpBalanceCr = subGroupOpBalanceCr.add(openingBalanceCr);
							  faMasAccountSubGroup.setOpBalanceCr(subGroupOpBalanceCr);
						  }
					}

			 	hbt.update(faMasAccountSubGroup);
			}*/
				
			
			
			}
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//--------------------------------------------------------------
		List<FaMasAccount> faMasAccountList = new ArrayList<FaMasAccount>();
		List<FaMasAccountSubGroup> faMasAccountSubGroupList = new ArrayList<FaMasAccountSubGroup>();
		List<FaMasAccountSubGroup> gridMasAccountSubGroupList = new ArrayList<FaMasAccountSubGroup>();
		List<FaMasAccountGroup> faMasAccountGroupList = new ArrayList<FaMasAccountGroup>();
		List<FaMasAccountGroup> gridMasAccountGroupList = new ArrayList<FaMasAccountGroup>();
		List<FaMasAccount> mainAccountList = new ArrayList<FaMasAccount>();
		
		mainAccountList=session.createCriteria(FaMasAccount.class).add(Restrictions.eq("Status", "y")).list();
				
		faMasAccountList=session.createCriteria(FaMasAccount.class).add(Restrictions.eq("Status", "y"))
				/*.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", 1))*/
				.list();
		faMasAccountGroupList = session.createCriteria(FaMasAccountGroup.class).add(Restrictions.eq("Status", "y"))
								/*.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", 1))*/
								.list();
		gridMasAccountGroupList=session.createCriteria(FaMasAccountGroup.class).add(Restrictions.eq("Status", "y"))
				/*.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", 1))*/
				.list();
		faMasAccountSubGroupList=session.createCriteria(FaMasAccountSubGroup.class).add(Restrictions.eq("Status", "y"))
				/*.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", 1))*/
				.list();
		gridMasAccountSubGroupList=session.createCriteria(FaMasAccountSubGroup.class).add(Restrictions.eq("Status", "y"))
				/*.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", 1))*/
				.list();
		
		
		
		map.put("faMasAccountGroupList", faMasAccountGroupList);
		map.put("faMasAccountSubGroupList",faMasAccountSubGroupList);
		map.put("gridMasAccountGroupList",gridMasAccountGroupList);
		map.put("faMasAccountList",faMasAccountList);
		map.put("mainAccountList",mainAccountList);
		map.put("gridMasAccountSubGroupList",gridMasAccountSubGroupList);
		map.put("message", message);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> editAccountMaster(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccount> accountIdList = new ArrayList<FaMasAccount>();
		List<FaMasAccount> mainAccountList = new ArrayList<FaMasAccount>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		List<FaMasAccountGroup> accountGroupList = new ArrayList<FaMasAccountGroup>();
		List<FaMasAccountSubGroup> accountSubGroupList = new ArrayList<FaMasAccountSubGroup>();
		Session session = (Session)getSession();
		mainAccountList=session.createCriteria(FaMasAccount.class).add(Restrictions.eq("Status", "y")).list();
		
		accountIdList = session.createCriteria(FaMasAccount.class).add(Restrictions.idEq(box.getInt("accountId"))).list();
		accountSubGroupList = session.createCriteria(FaMasAccountSubGroup.class).createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", box.getInt("fYear")))
									.add(Restrictions.eq("Hospital.Id", box.getInt("locationId"))).add(Restrictions.eq("Status", "y")).list();
		accountGroupList = session.createCriteria(FaMasAccountGroup.class).createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", box.getInt("fYear")))
										.add(Restrictions.eq("Hospital.Id", box.getInt("locationId"))).add(Restrictions.eq("Status", "y")).list();
		accountList = session.createCriteria(FaMasAccount.class).createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", box.getInt("fYear")))
										.add(Restrictions.eq("Hospital.Id", box.getInt("locationId"))).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AccCode")).list();
		map.put("accountSubGroupList", accountSubGroupList);
		map.put("accountGroupList", accountGroupList);
		map.put("accountList", accountList);
		map.put("accountIdList", accountIdList);
		map.put("mainAccountList", mainAccountList);
		
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> updateAccountMaster(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccountGroup> accountGroupList = new ArrayList<FaMasAccountGroup>();
		List<FaMasAccountSubGroup> accountSubGroupList = new ArrayList<FaMasAccountSubGroup>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		List<FaMasAccount> mainAccountList = new ArrayList<FaMasAccount>();
		List<FaMasAccount> existingAccountList = new ArrayList<FaMasAccount>();
		Session session = (Session)getSession();
		String message = "";
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		try {
			existingAccountList = session.createCriteria(FaMasAccount.class).add(Restrictions.eq("AccDesc", box.getString(ACCOUNT_NAME))).add(Restrictions.ne("Id", box.getInt("accountId"))).list();
			
			if (existingAccountList.size() > 0) {
				message = "Record already Exist";
			} else {

			FaMasAccount faMasAccount = (FaMasAccount) hbt.load(FaMasAccount.class,box.getInt("accountId"));
			faMasAccount.setAccDesc(box.getString(ACCOUNT_NAME));
			
			FaMasAccountSubGroup faMasAccountSubGroup1 = new FaMasAccountSubGroup();
			faMasAccountSubGroup1.setId(box.getInt(ACCOUNT_SUB_GROUP_ID));
			faMasAccount.setAccountSubGroup(faMasAccountSubGroup1);
			MasStoreFinancial masStoreFinancial = new MasStoreFinancial();
			masStoreFinancial.setId(box.getInt("fYear"));
			faMasAccount.setFYear(masStoreFinancial);
			if(box.getString("parentStatus")!= null){
				faMasAccount.setParentStatus("y");
			}else{
				faMasAccount.setParentStatus("n");
			}
			if(box.getString("subLedgerStatus")!= null){
				faMasAccount.setSubLedger("y");
			}else{
				faMasAccount.setSubLedger("n");
			}
			FaMasAccount masAccount = new FaMasAccount();
			masAccount.setId(box.getInt(ACCOUNT_ID));
			faMasAccount.setParent(masAccount);
			BigDecimal opBalanceDr = new BigDecimal(0.0);
			BigDecimal opBalanceCr = new BigDecimal(0.0);
			if(box.getString("accountTypeA").equals("Dr")){
				faMasAccount.setOpBalanceDr(new BigDecimal(box.getString("openingBalance")));
				faMasAccount.setOpBalanceCr(new BigDecimal(0.0));
				faMasAccount.setClBalanceDr(new BigDecimal(box.getString("openingBalance")));
				faMasAccount.setClBalanceCr(new BigDecimal(0.0));
				opBalanceDr = new BigDecimal(box.getString("openingBalance"));
			}else if(box.getString("accountTypeA").equals("Cr")){
				faMasAccount.setOpBalanceCr(new BigDecimal(box.getString("openingBalance")));
				faMasAccount.setClBalanceCr(new BigDecimal(box.getString("openingBalance")));
				faMasAccount.setOpBalanceDr(new BigDecimal(0.0));
				faMasAccount.setClBalanceDr(new BigDecimal(0.0));
				opBalanceCr = new BigDecimal(box.getString("openingBalance"));
			}
			Users user = new Users();
			user.setId(box.getInt("changedBy"));
			faMasAccount.setLastChgBy(user);
			MasHospital masHospital = new MasHospital();
			masHospital.setId(box.getInt("locationId"));
			faMasAccount.setHospital(masHospital);
			
			faMasAccount.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			faMasAccount.setLastChgTime(box.getString(CHANGED_TIME));
			hbt.update(faMasAccount);
			message = "Record updated successfully!";
//----------------------------------------------calculation for last Balance---------------------------------
			BigDecimal lastOpeningDrBalance = new BigDecimal(0.0);
			BigDecimal lastOpeningCrBalance = new BigDecimal(0.0);
			BigDecimal openingBalanceDr = new BigDecimal(0.0);
			BigDecimal openingBalanceCr = new BigDecimal(0.0);
			
			if(!box.getString("lastOpeningBalanceDr").equals("") ){
				lastOpeningDrBalance = new BigDecimal(box.getString("lastOpeningBalanceDr"));
			}else if(!box.getString("lastOpeningBalanceCr").equals("")){
				lastOpeningCrBalance = new BigDecimal(box.getString("lastOpeningBalanceCr"));
			}
			
			
			 if(opBalanceDr.compareTo(new BigDecimal(0))>0){
				 if(lastOpeningCrBalance.compareTo(new BigDecimal(0)) > 0){
				 	 if(lastOpeningCrBalance.compareTo(opBalanceDr) > 0 ){
				 		openingBalanceCr = lastOpeningCrBalance.subtract(opBalanceDr);
				 	 	}else if(opBalanceDr.compareTo(lastOpeningCrBalance) > 0 ){
				 	 		openingBalanceDr =opBalanceDr.subtract(lastOpeningCrBalance);
				 	 	}
				 	 }else if(lastOpeningDrBalance.compareTo(new BigDecimal(0)) > 0) {
				 		 if(opBalanceDr.compareTo(lastOpeningDrBalance)>0){
				 			 openingBalanceDr = opBalanceDr.subtract(lastOpeningDrBalance);
				 		 }else if(lastOpeningDrBalance.compareTo(opBalanceDr)>0){
				 			 
				 			openingBalanceCr = lastOpeningDrBalance.subtract(opBalanceDr);
				 		 }
					  }
				
			 }else if(opBalanceCr.compareTo(new BigDecimal(0))>0){
					if(lastOpeningDrBalance.compareTo(new BigDecimal(0)) > 0){
					  if(lastOpeningDrBalance.compareTo(opBalanceCr) > 0){
						  openingBalanceDr =lastOpeningDrBalance.subtract(opBalanceCr);
					  	}else if(opBalanceCr.compareTo(lastOpeningDrBalance) > 0 ){
						  	openingBalanceCr =opBalanceCr.subtract(lastOpeningDrBalance);
					 	 }
					}else{
						  
						openingBalanceCr = lastOpeningCrBalance.subtract(opBalanceCr);
						if(opBalanceCr.compareTo(lastOpeningCrBalance)>0){
							openingBalanceCr = opBalanceCr.subtract(lastOpeningCrBalance);
				 		 }else if(lastOpeningCrBalance.compareTo(opBalanceCr)>0){
				 			openingBalanceDr = lastOpeningCrBalance.subtract(opBalanceCr);
				 		 }
						
				  }
			 }
//-----------------------------------------------update account group------------------------------------
			BigDecimal groupClBalanceDr = new BigDecimal(0);
			BigDecimal groupClBalanceCr = new BigDecimal(0);

			 FaMasAccountGroup faMasAccountGroup = (FaMasAccountGroup)hbt.load(FaMasAccountGroup.class, box.getInt(ACCOUNT_GROUP_ID));
			 if(faMasAccountGroup.getClBalanceDr() != null)
				 groupClBalanceDr =  faMasAccountGroup.getClBalanceDr();
			 if(faMasAccountGroup.getClBalanceCr() != null)
				 groupClBalanceCr = faMasAccountGroup.getClBalanceCr();

			 if(openingBalanceDr.compareTo(new BigDecimal(0))>0){
				 if(groupClBalanceCr.compareTo(new BigDecimal(0)) > 0){
				 	 if(groupClBalanceCr.compareTo(openingBalanceDr) > 0 ){
						  groupClBalanceCr = groupClBalanceCr.subtract(openingBalanceDr);
						  faMasAccountGroup.setClBalanceCr(groupClBalanceCr);
						  faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
				 	 }else if(openingBalanceDr.compareTo(groupClBalanceCr) > 0 ){
				 		 groupClBalanceDr =openingBalanceDr.subtract(groupClBalanceCr);
				 		 faMasAccountGroup.setClBalanceDr(groupClBalanceDr);
				 		 faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
				 	 }
				 }else {
						  groupClBalanceDr = groupClBalanceDr.add(openingBalanceDr);
						  faMasAccountGroup.setClBalanceDr(groupClBalanceDr);
					  }

			}else if(openingBalanceCr.compareTo(new BigDecimal(0))>0){
				if(groupClBalanceDr.compareTo(new BigDecimal(0)) > 0){
				  if(groupClBalanceDr.compareTo(openingBalanceCr) > 0){
					  
					  groupClBalanceDr =groupClBalanceDr.subtract(openingBalanceCr);
					  faMasAccountGroup.setClBalanceDr(groupClBalanceDr);
					  faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
				  }else if(openingBalanceCr.compareTo(groupClBalanceDr) > 0 ){
					
				 		 groupClBalanceCr =openingBalanceCr.subtract(groupClBalanceDr);
				 		 faMasAccountGroup.setClBalanceCr(groupClBalanceCr);
				 		 faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
				 	 }
				}else{
					  
					  groupClBalanceCr = groupClBalanceCr.add(openingBalanceCr);
					  faMasAccountGroup.setClBalanceCr(groupClBalanceCr);
				  }
			}
			
//-----------------------------------opening Balance--------------------------------------//
			 BigDecimal groupOpBalanceDr = new BigDecimal(0);
				BigDecimal groupOPBalanceCr = new BigDecimal(0);

				 if(faMasAccountGroup.getOpBalanceDr() != null)
					 groupOpBalanceDr =  faMasAccountGroup.getOpBalanceDr();
				 if(faMasAccountGroup.getOpBalanceCr() != null)
					 groupOPBalanceCr = faMasAccountGroup.getOpBalanceCr();
			 if(openingBalanceDr.compareTo(new BigDecimal(0))>0){
				 if(groupOPBalanceCr.compareTo(new BigDecimal(0)) > 0){
				 	 if(groupOPBalanceCr.compareTo(openingBalanceDr) > 0 ){
				 		groupOPBalanceCr = groupOPBalanceCr.subtract(openingBalanceDr);
						  faMasAccountGroup.setOpBalanceCr(groupOPBalanceCr);
						  faMasAccountGroup.setOpBalanceDr(new BigDecimal(0.00));
				 	 }else if(openingBalanceDr.compareTo(groupOPBalanceCr) > 0 ){
				 		groupOpBalanceDr =openingBalanceDr.subtract(groupOPBalanceCr);
				 		 faMasAccountGroup.setOpBalanceDr(groupOpBalanceDr);
				 		 faMasAccountGroup.setOpBalanceCr(new BigDecimal(0.00));
				 	 }
				 }else {
					 groupOpBalanceDr = groupOpBalanceDr.add(openingBalanceDr);
						  faMasAccountGroup.setOpBalanceDr(groupOpBalanceDr);
					  }

			}else if(openingBalanceCr.compareTo(new BigDecimal(0))>0){
				if(groupOpBalanceDr.compareTo(new BigDecimal(0)) > 0){
				  if(groupOpBalanceDr.compareTo(openingBalanceCr) > 0){
					  
					  groupOpBalanceDr =groupOpBalanceDr.subtract(openingBalanceCr);
					  faMasAccountGroup.setOpBalanceDr(groupOpBalanceDr);
					  faMasAccountGroup.setOpBalanceCr(new BigDecimal(0.00));
				  }else if(openingBalanceCr.compareTo(groupOpBalanceDr) > 0 ){
					 
					  groupOPBalanceCr =openingBalanceCr.subtract(groupOpBalanceDr);
				 		 faMasAccountGroup.setOpBalanceCr(groupOPBalanceCr);
				 		 faMasAccountGroup.setOpBalanceDr(new BigDecimal(0.00));
				 	 }
				}else{
					
					groupOPBalanceCr = groupOPBalanceCr.add(openingBalanceCr);
					  faMasAccountGroup.setOpBalanceCr(groupOPBalanceCr);
				  }
			}
			hbt.update(faMasAccountGroup);		
//--------------------------------------------update subGroup group--------------
			BigDecimal subGroupClBalanceDr = new BigDecimal(0);
			BigDecimal subGroupClBalanceCr = new BigDecimal(0);

			FaMasAccountSubGroup faMasAccountSubGroup = (FaMasAccountSubGroup)hbt.load(FaMasAccountSubGroup.class, box.getInt(ACCOUNT_SUB_GROUP_ID));
			if(faMasAccountSubGroup.getClBalanceDr() != null)
				subGroupClBalanceDr =  faMasAccountSubGroup.getClBalanceDr();
			if(faMasAccountSubGroup.getClBalanceCr() != null)
				subGroupClBalanceCr = faMasAccountSubGroup.getClBalanceCr();


			 if(openingBalanceDr.compareTo(new BigDecimal(0))>0){
				 if(subGroupClBalanceCr.compareTo(new BigDecimal(0)) > 0){
					 if(subGroupClBalanceCr.compareTo(openingBalanceDr) > 0){
				 		 subGroupClBalanceDr = subGroupClBalanceCr.subtract(openingBalanceDr);
				 		 faMasAccountSubGroup.setClBalanceCr(subGroupClBalanceDr);
				 		 faMasAccountSubGroup.setClBalanceDr(new BigDecimal(0.00));
				 	 }else if(openingBalanceDr.compareTo(subGroupClBalanceCr) > 0 ){
				 		subGroupClBalanceDr =openingBalanceDr.subtract(subGroupClBalanceCr);
				 		faMasAccountSubGroup.setClBalanceDr(subGroupClBalanceDr);
				 		faMasAccountSubGroup.setClBalanceCr(new BigDecimal(0.00));
				 	 }
				 }else{

					  subGroupClBalanceDr = subGroupClBalanceDr.add(openingBalanceDr);
					  faMasAccountSubGroup.setClBalanceDr(subGroupClBalanceDr);
				  }
			}else if(openingBalanceCr.compareTo(new BigDecimal(0))>0){
				 if(subGroupClBalanceDr.compareTo(new BigDecimal(0)) > 0){
					 if(subGroupClBalanceDr.compareTo(openingBalanceCr) > 0){

						  subGroupClBalanceCr = subGroupClBalanceDr.subtract(openingBalanceCr);
						  faMasAccountSubGroup.setClBalanceDr(subGroupClBalanceCr);
						  faMasAccountSubGroup.setClBalanceCr(new BigDecimal(0.00));
					  }else if(openingBalanceCr.compareTo(subGroupClBalanceDr) > 0 ){
						  	subGroupClBalanceCr =openingBalanceCr.subtract(subGroupClBalanceDr);
						  	faMasAccountSubGroup.setClBalanceCr(subGroupClBalanceCr);
						  	faMasAccountSubGroup.setClBalanceDr(new BigDecimal(0.00));
					 	 }
				 }
				 else{
					  subGroupClBalanceCr = subGroupClBalanceCr.add(openingBalanceCr);
					  faMasAccountSubGroup.setClBalanceCr(subGroupClBalanceCr);
				  }
			}
//--------------------------opening Balance------------------------------------------//
			 BigDecimal subGroupOpBalanceDr = new BigDecimal(0);
				BigDecimal subGroupOpBalanceCr = new BigDecimal(0);

				if(faMasAccountSubGroup.getOpBalanceDr() != null)
					subGroupOpBalanceDr =  faMasAccountSubGroup.getOpBalanceDr();
				if(faMasAccountSubGroup.getOpBalanceCr() != null)
					subGroupOpBalanceCr = faMasAccountSubGroup.getOpBalanceCr();


				 if(openingBalanceDr.compareTo(new BigDecimal(0))>0){
					 if(subGroupOpBalanceCr.compareTo(new BigDecimal(0)) > 0){
						 if(subGroupOpBalanceCr.compareTo(openingBalanceDr) > 0){
							 subGroupOpBalanceDr = subGroupOpBalanceCr.subtract(openingBalanceDr);
					 		 faMasAccountSubGroup.setOpBalanceCr(subGroupOpBalanceDr);
					 		 faMasAccountSubGroup.setOpBalanceDr(new BigDecimal(0.00));
					 	 }else if(openingBalanceDr.compareTo(subGroupOpBalanceCr) > 0 ){
					 		subGroupOpBalanceDr =openingBalanceDr.subtract(subGroupOpBalanceCr);
					 		faMasAccountSubGroup.setOpBalanceDr(subGroupOpBalanceDr);
					 		faMasAccountSubGroup.setOpBalanceCr(new BigDecimal(0.00));
					 	 }
					 }else{

						 subGroupOpBalanceDr = subGroupOpBalanceDr.add(openingBalanceDr);
						  faMasAccountSubGroup.setOpBalanceDr(subGroupOpBalanceDr);
					  }
				}else if(openingBalanceCr.compareTo(new BigDecimal(0))>0){
					 if(subGroupOpBalanceDr.compareTo(new BigDecimal(0)) > 0){
						 if(subGroupOpBalanceDr.compareTo(openingBalanceCr) > 0){

							 subGroupOpBalanceCr = subGroupOpBalanceDr.subtract(openingBalanceCr);
							  faMasAccountSubGroup.setOpBalanceDr(subGroupOpBalanceCr);
							  faMasAccountSubGroup.setOpBalanceCr(new BigDecimal(0.00));
						  }else if(openingBalanceCr.compareTo(subGroupOpBalanceDr) > 0 ){
							  subGroupOpBalanceCr =openingBalanceCr.subtract(subGroupOpBalanceDr);
							  	faMasAccountSubGroup.setOpBalanceCr(subGroupOpBalanceCr);
							  	faMasAccountSubGroup.setOpBalanceDr(new BigDecimal(0.00));
						 	 }
					 }
					 else{
						 subGroupOpBalanceCr = subGroupOpBalanceCr.add(openingBalanceCr);
						  faMasAccountSubGroup.setOpBalanceCr(subGroupOpBalanceCr);
					  }
				}

		 	hbt.update(faMasAccountSubGroup);
			
			}
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		accountSubGroupList = session.createCriteria(FaMasAccountSubGroup.class).createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", box.getInt("fYear")))
									.add(Restrictions.eq("Hospital.Id", box.getInt("locationId"))).add(Restrictions.eq("Status", "y")).list();
		accountList = session.createCriteria(FaMasAccount.class).createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", box.getInt("fYear")))
								.add(Restrictions.eq("Hospital.Id", box.getInt("locationId"))).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AccCode")).list();
		accountGroupList = session.createCriteria(FaMasAccountGroup.class).createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", box.getInt("fYear")))
								.add(Restrictions.eq("Hospital.Id", box.getInt("locationId"))).add(Restrictions.eq("Status", "y")).list();
		mainAccountList=session.createCriteria(FaMasAccount.class).add(Restrictions.eq("Status", "y")).list();
		map.put("message", message);
		map.put("accountSubGroupList", accountSubGroupList);
		map.put("accountList", accountList);
		map.put("accountGroupList", accountGroupList);
		map.put("mainAccountList", mainAccountList);
		
		return map;
	}
			
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> searchAccountMaster(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		List<FaMasAccount> mainAccountList = new ArrayList<FaMasAccount>();
		Session session = getSession();
		int searchRadio = 0;
		String searchField = "";
		Criteria crit = null;
		searchField = box.getString(SEARCH_FIELD);
		searchRadio = box.getInt(SELECTED_RADIO);

		crit = session.createCriteria(FaMasAccount.class);
	if (searchRadio == 1) {
			crit = crit.add(Restrictions.eq("AccCode", Integer.parseInt(searchField)));
			map.put("accCode",searchField);

		} else {
			crit = crit.add(Restrictions.like("AccDesc", searchField+"%"));
			map.put("accDesc",searchField);
		}

		accountList = crit.list();
		
System.out.println("accountList.size()---------->>"+accountList.size());

		/*Map<String, Object> map = new HashMap<String, Object>();*/
		List<FaMasAccount> faMasAccountList = new ArrayList<FaMasAccount>();
		List<FaMasAccountSubGroup> faMasAccountSubGroupList = new ArrayList<FaMasAccountSubGroup>();
		List<FaMasAccountSubGroup> gridMasAccountSubGroupList = new ArrayList<FaMasAccountSubGroup>();
		List<FaMasAccountGroup> faMasAccountGroupList = new ArrayList<FaMasAccountGroup>();
		List<FaMasAccountGroup> gridMasAccountGroupList = new ArrayList<FaMasAccountGroup>();
		/*Session session = (Session)getSession();
		int fYear = 0;
		int locationId = 0;
		if(generalMap.get("fYear")!= null){
			fYear = (Integer)generalMap.get("fYear");
		}
		if(generalMap.get("locationId")!= null){
			locationId = (Integer)generalMap.get("locationId");
		}*/
		mainAccountList=session.createCriteria(FaMasAccount.class).add(Restrictions.eq("Status", "y"))
				//.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", fYear))
				.list();
		int fYear=1;
		faMasAccountGroupList = session.createCriteria(FaMasAccountGroup.class).add(Restrictions.eq("Status", "y"))
								//.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", fYear))
								.list();
		gridMasAccountGroupList=session.createCriteria(FaMasAccountGroup.class).add(Restrictions.eq("Status", "y"))
				//.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", fYear))
				.list();
		faMasAccountSubGroupList=session.createCriteria(FaMasAccountSubGroup.class).add(Restrictions.eq("Status", "y"))
				//.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", fYear))
				.list();
		gridMasAccountSubGroupList=session.createCriteria(FaMasAccountSubGroup.class).add(Restrictions.eq("Status", "y"))
				//.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", fYear))
				.list();
		System.out.println("faMasAccountGroupList=====>>"+faMasAccountGroupList.size());
		map.put("faMasAccountGroupList", faMasAccountGroupList);
		map.put("faMasAccountSubGroupList",faMasAccountSubGroupList);
		map.put("gridMasAccountGroupList",gridMasAccountGroupList);
		map.put("mainAccountList",mainAccountList);
		map.put("gridMasAccountSubGroupList",gridMasAccountSubGroupList);
		map.put("faMasAccountList", accountList);
		
		

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showCashVoucherJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<FaMasAccount> accList = new ArrayList<FaMasAccount>();
		List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
		Session session = (Session)getSession();
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int subGroupIdForPayment = 0;
		
		
		subGroupIdForPayment = Integer.parseInt(properties.getProperty("subGroupIdForPayment"));
		Properties properties2 = new Properties();
		URL resourcePath2 = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int subGroupIdForPayment2 = 0;
		
		
		subGroupIdForPayment2 = Integer.parseInt(properties.getProperty("subGroupIdForPayment2"));

		
		Object[] selectedId = {subGroupIdForPayment2,subGroupIdForPayment};
				paramMap.put("locationId", box.getInt("locationId"));
		paramMap.put("suffix", box.getString("fYearDesc"));
		paramMap.put("flag", "display");
		paramMap.put("prefix", "RV");
		paramMap.put("voucherType", "Reciept");
		/*int voucherNo = generateVoucherNo(paramMap);*/
		/*map.put("voucherNo", voucherNo);*/
		accList = session.createCriteria(FaMasAccount.class)
					.createAlias("AccountSubGroup", "subGroup").add(Restrictions.in("subGroup.Id", selectedId))
					.add(Restrictions.or(Restrictions.eq("Parent.Id", 38) , Restrictions.eq("Parent.Id", 40)))
					.list();
		costCenterList = session.createCriteria(MasCostCenter.class).add(Restrictions.eq("Status", "y")).list();
		map.put("costCenterList", costCenterList);
		System.out.println("accList size ---------->>>>"+accList.size());
		map.put("accList", accList);
		return map;
	}
	/*@SuppressWarnings("unchecked")
	public Map<String, Object> getFinancialYear(String voucherDate) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<FaMasAccount> accList = new ArrayList<FaMasAccount>();
		List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
		List<MasBranch> branchList = new ArrayList<MasBranch>();
		List<HrMasFinancialYear> financialYearList = new ArrayList<HrMasFinancialYear>();
		Session session = (Session)getSession();
		Object[] selectedId = {"Bank A/C","Cash In Hand"};
		
		//String currentYear = voucherDate.substring(6, 10);
		financialYearList = session.createCriteria(HrMasFinancialYear.class).add(Restrictions.le("YearFromDate", HMSUtil.dateFormatterDDMMYYYY(voucherDate)))
							.add(Restrictions.ge("YearToDate", HMSUtil.dateFormatterDDMMYYYY(voucherDate)))
						.add(Restrictions.eq("Status", "y"))
						.list();
	
		int financialYearId = 0;
		String fYearDesc = "";
		if(financialYearList.size()>0){
			for(HrMasFinancialYear financialYear : financialYearList){
				financialYearId = financialYear.getId();
				fYearDesc = financialYear.getYearDescription();
			}
		}
		paramMap.put("suffix", fYearDesc);
		paramMap.put("flag", "display");
		paramMap.put("prefix", "RV");
		paramMap.put("voucherType", "Reciept");
		int voucherNo = generateVoucherNo(paramMap);
		map.put("voucherNo", voucherNo);
		accList = session.createCriteria(FaMasAccount.class)
					.add(Restrictions.eq("ParentStatus", "n")).add(Restrictions.eq("FYear.Id", financialYearId)).createAlias("AccountSubGroup", "subGroup")
						.add(Restrictions.or(Restrictions.eq("subGroup.AccountSubGroupName", "Bank A/C"),
						Restrictions.eq("subGroup.AccountSubGroupName", "Cash In Hand"))).list();
		costCenterList = session.createCriteria(MasCostCenter.class).add(Restrictions.eq("Status", "y")).list();
		branchList = session.createCriteria(MasBranch.class).add(Restrictions.eq("Status", "y")).list();
		map.put("costCenterList", costCenterList);
		map.put("accList", accList);
		map.put("branchList", branchList);
		map.put("financialYearId", financialYearId);
		map.put("fYearDesc", fYearDesc);
		return map;
	}
*/

	@SuppressWarnings("unchecked")
	public Map<String, Object> getAccountCodeForAutoComplete(Map<String, Object> parameterMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccount> accList = new ArrayList<FaMasAccount>();
		String accountNameStr = "";
		if(parameterMap.get("accountNameStr")!= null){
			accountNameStr = (String)parameterMap.get("accountNameStr");
		}
		String amtType = "";
		if(parameterMap.get("amtType")!= null){
			amtType =(String)parameterMap.get("amtType");
		}
		String voucherType = "";
		if(parameterMap.get("salesVoucherType")!= null){
			voucherType =(String)parameterMap.get("salesVoucherType");
		}
		int locationId = 0;
		if(parameterMap.get("locationId")!= null){
			locationId =(Integer)parameterMap.get("locationId");
		}
		/*int financialYearId = 0;
		if(parameterMap.get("financialYearId")!= null){
			financialYearId = (Integer)parameterMap.get("financialYearId");
		}*/
		Session session = (Session)getSession();
		List<MasHospital>hospitalList=new ArrayList<MasHospital>();
		hospitalList=session.createCriteria(MasHospital.class).add(Restrictions.idEq(locationId)).list();
	
		Criteria crit =null;
	
		crit = session.createCriteria(FaMasAccount.class).add(Restrictions.like("AccDesc",accountNameStr+"%"));
			
		
		
			
		String[] jSelected = null;
		Integer[] jSelectedId = null;
		String[] salesSelected=null;
		Integer[] salesSelectedId=null;
		String[] purchaseSelected=null;
		Integer[] purchaseSelectedId=null;
		
		
		 Properties properties = new Properties();
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("adt.properties");
			try {
				properties.load(resourcePath.openStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			jSelected= properties.getProperty("j_Selected_Id").split(",");
			jSelectedId = convertIntArray(jSelected);
			 
			salesSelected= properties.getProperty("sales_Selected").split(",");
			salesSelectedId = convertIntArray(salesSelected);
			
			purchaseSelected= properties.getProperty("purchase_Selected").split(",");
			purchaseSelectedId = convertIntArray(purchaseSelected);
			
		if(voucherType.equals("journal")){
			crit = crit.createAlias("Parent", "Parent",CriteriaSpecification.LEFT_JOIN).
					add(Restrictions.or(Restrictions.not(Restrictions.in("Parent.Id", jSelectedId)), Restrictions.isNull("Parent.Id")));
			}else if(voucherType.equals("salesReturn") && voucherType.equals("sales")){
				crit = crit.createAlias("AccountSubGroup", "subGroup").add(Restrictions.in("subGroup.Id", salesSelectedId));
			}else if(voucherType.equals("purchase") && voucherType.equals("purchaseReturn")){
				crit = crit.createAlias("AccountSubGroup", "subGroup").add(Restrictions.in("subGroup.Id", purchaseSelectedId));
			}else{
				crit = crit.createAlias("AccountSubGroup", "subGroup");
			}
			accList = crit.list();
		map.put("accList", accList);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> getSubLedgerForAccount(Map<String, Object> parameterMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasSubLed> subLedgerList = new ArrayList<FaMasSubLed>();
		List<FaMasAccount>accountIdList = new ArrayList<FaMasAccount>();
		int locationId=0;
		int fYear = 0;
		if(parameterMap.get("fYear")!= null){
			fYear = (Integer)parameterMap.get("fYear");
		}
		String accName = "";
		if(parameterMap.get("accountName")!= null){
			accName = (String)parameterMap.get("accountName");
		}
		String flag="";
		if(parameterMap.get("flag")!=null && parameterMap.get("flag")!=""){
			flag= (String)parameterMap.get("flag");
		}
			
		Session session = (Session)getSession();
		
		/*String chkHo="";
		if(parameterMap.get("chkHo")!=null && parameterMap.get("chkHo")!=""){
			chkHo= (String)parameterMap.get("chkHo");
		}*/
		
	/*	if(chkHo.equalsIgnoreCase("y")){
			locationId = 1;	
		}else{
			if(parameterMap.get("locationId")!= null){
				locationId= (Integer)parameterMap.get("locationId");
			}
		}*/
		
		/*if(parameterMap.get("locationId")!= null){
			locationId= (Integer)parameterMap.get("locationId");
		}*/
		
		locationId= (Integer)parameterMap.get("locationId");
		
		subLedgerList = session.createCriteria(FaMasSubLed.class).createAlias("Account", "acc")
				.add(Restrictions.eq("acc.AccCode",Integer.parseInt(accName)))
				.createAlias("Hospital", "Centre")
				.add(Restrictions.eq("Centre.Id",locationId))
				.add(Restrictions.eq("Status", "y"))
				.list();
		
		/*if(locationId==1){*/
		/*	if(flag.equals("flagOP")){
				subLedgerList = session.createCriteria(FaMasSubLed.class).createAlias("Account", "acc")
						.add(Restrictions.eq("acc.AccCode",Integer.parseInt(accName)))
						.createAlias("Hospital", "Centre")
						.add(Restrictions.eq("Centre.Id",locationId))
						.add(Restrictions.eq("Status", "y"))
						.list();
			}else{
				subLedgerList = session.createCriteria(FaMasSubLed.class).createAlias("Account", "acc")
						.add(Restrictions.eq("acc.AccCode",Integer.parseInt(accName)))
						.add(Restrictions.eq("Status", "y"))
						.list();
			}*/
			
		/*}else{
			subLedgerList = session.createCriteria(FaMasSubLed.class).createAlias("Account", "acc")
					//.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", fYear))
					.add(Restrictions.eq("acc.AccCode",Integer.parseInt(accName)))//.add(Restrictions.eq("acc.SubLedger", "y"))
					.createAlias("Hospital", "Centre")
					.add(Restrictions.eq("Centre.Id",locationId))
					.add(Restrictions.eq("Status", "y"))
					.list();
		}*/
	

		accountIdList = session.createCriteria(FaMasAccount.class).add(Restrictions.eq("AccCode", Integer.parseInt(accName))).list();
		int accountId = 0;
		int groupId = 0;
		int subGroupId = 0;
		BigDecimal closingBalance = new BigDecimal(0.0);
		if(accountIdList.size()>0){
			for(FaMasAccount faMasAccount :accountIdList){
				accountId = faMasAccount.getId();
				groupId = faMasAccount.getAccountSubGroup().getAccountGroup().getId();
				subGroupId = faMasAccount.getAccountSubGroup().getId();
				if(faMasAccount.getClBalanceCr()!= null){
					closingBalance = faMasAccount.getClBalanceCr();
				}else{
					closingBalance = faMasAccount.getClBalanceDr();
				}
			}
		}

		map.put("closingBalance", closingBalance);
		map.put("accountId", accountId);
		map.put("groupId", groupId);
		map.put("subGroupId", subGroupId);
		map.put("subLedgerList", subLedgerList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getNarrationForAutoComplete(Map<String, Object> parameterMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasNarration> voucherNarationList  = new ArrayList<FaMasNarration>();
		String narrationStr = "";
		if(parameterMap.get("narrationStr")!= null){
			narrationStr = (String)parameterMap.get("narrationStr");
		}

		Session session =  (Session)getSession();
		voucherNarationList = session.createCriteria(FaMasNarration.class).add(Restrictions.like("NarrationDesc",narrationStr+"%"))
					.list();
		map.put("voucherNarationList", voucherNarationList);
		return map;

	}

	public Map<String, Object> addVoucherNarration(FaMasNarration faMasNarration) {
		Map<String, Object> map = new HashMap<String, Object>();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		boolean saved = false;
		String message = "";
		try {
			hbt.save(faMasNarration);
			saved = true;
			if(saved == true){
				message = "Narration saved";
			}else{
				message = "Some Problem Occured";
			}

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		map.put("message", message);
		return map;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showAccountBalance(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<AccountMainTransac> accountList = new ArrayList<AccountMainTransac>();
		List<AccountSubLedTransac> accountListSubLed = new ArrayList<AccountSubLedTransac>();
		Session session = (Session)getSession();
		int locationId = box.getInt("locationId");
		int fyear = box.getInt("fyear");
		int accountId = box.getInt("accountId");
		int subledId = box.getInt("subledId");
		String flag="";
		
		if(accountId!=0){
			if(subledId !=0){
				accountListSubLed = session.createCriteria(AccountSubLedTransac.class)
						.createAlias("SubLed", "acc")
						.createAlias("Location", "location")
						.createAlias("FYear", "yr")
						.add(Restrictions.eq("yr.Id",fyear))
						.add(Restrictions.eq("location.Id",locationId))
						.add(Restrictions.eq("acc.Id",subledId))
						.list();
				
				flag="subLed";
				map.put("flag", "subLed");
				map.put("accountListSubLed", accountListSubLed);
			}else{
				accountList = session.createCriteria(AccountMainTransac.class)
						.createAlias("Account", "acc")
						.createAlias("Location", "location")
						.createAlias("FinancialYear", "yr")
						.add(Restrictions.eq("yr.Id",fyear))
						.add(Restrictions.eq("location.Id",locationId))
						.add(Restrictions.eq("acc.Id",accountId))
						.list();
				flag="accMain";
				map.put("flag", "accMain");
				map.put("accountList", accountList);
			}
			return map;
		}
		
		return map;
	}


	@SuppressWarnings("unchecked")
	public Map<String, Object> getAccountNarrationForAutoComplete(
			Map<String, Object> parameterMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasNarration> voucherNarationList  = new ArrayList<FaMasNarration>();
		String accountNarration = "";
		if(parameterMap.get("accountNarration")!= null){
			accountNarration = (String)parameterMap.get("accountNarration");
		}

		Session session =  (Session)getSession();
		voucherNarationList = session.createCriteria(FaMasNarration.class).add(Restrictions.like("NarrationDesc",accountNarration+"%"))
					.list();
		map.put("voucherNarationList", voucherNarationList);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> submitReceiptVoucher(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<FaMasAccount> accList = new ArrayList<FaMasAccount>();
		List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
		int vhId=0;
		String voucherNo="";
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session)getSession();
		Transaction tx = null;
		boolean saved = false;
		int accountListLength = box.getInt("hiddenValueCharge");

		try {
			tx = session.beginTransaction();
			FaVoucherHeader faVoucherHeader = new FaVoucherHeader();
			MasHospital masHospital = new MasHospital();
			masHospital.setId(box.getInt("locationId"));
			faVoucherHeader.setHospital(masHospital);
			faVoucherHeader.setVoucherDate(HMSUtil.convertStringTypeDateToDateType(box.getString(VOUCHER_DATE)));
			faVoucherHeader.setNarration(box.getString(NARRATION));
			Users users = new Users();
			users.setId( box.getInt("changedBy"));
			faVoucherHeader.setLastChgBy(users);
			faVoucherHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			faVoucherHeader.setLastChgTime(box.getString(CHANGED_TIME));
			faVoucherHeader.setVoucherTime(box.getString(CHANGED_TIME));
			faVoucherHeader.setVoucherType("RV");
			faVoucherHeader.setStatus("y");
			
			BigDecimal totalAmountCr = new BigDecimal(0.0);
			if (!box.getString(TOTAL_AMOUNT).equals("")) {
				totalAmountCr = new BigDecimal(box.getString(TOTAL_AMOUNT));
			}
			faVoucherHeader.setDrAmount(totalAmountCr);
			faVoucherHeader.setCrAmount(totalAmountCr);

			MasStoreFinancial masStoreFinancial = new MasStoreFinancial();
			masStoreFinancial.setId(box.getInt("fYear"));
			faVoucherHeader.setFYear(masStoreFinancial);
			if (!box.getString(BANK_NAME).equals("")) {
				faVoucherHeader.setBankName(box.getString(BANK_NAME));
			}
			if (!box.getString(CHEQUE_DATE).equals("")) {
				faVoucherHeader.setIssueDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHEQUE_DATE )));
			}
			if (!box.getString("checkNo").equals("")) {
				faVoucherHeader.setChequeNo(box.getString("checkNo"));
			}
			/*paramMap.put("locationId", box.getInt("locationId"));
			paramMap.put("suffix", box.getString("fYearDesc"));
			paramMap.put("flag", "save");
			paramMap.put("prefix", "RV");
			paramMap.put("voucherType", "Reciept");
			paramMap.put("financialYearId", box.getInt("fYear"));
			int voucherNo = generateVoucherNo(paramMap);
			String locationCode="";
			String yearDesc="";
			List<MasStoreFinancial>financialList=new ArrayList<MasStoreFinancial>();
			List<MasHospital>hospitalList=new ArrayList<MasHospital>();
			hospitalList=session.createCriteria(MasHospital.class).add(Restrictions.idEq(box.getInt("locationId"))).list();
			for(MasHospital mg:hospitalList){
				locationCode=mg.getHospitalCode();
			}
			financialList=session.createCriteria(MasStoreFinancial.class).add(Restrictions.idEq(box.getInt("fYear"))).list();
			for(MasStoreFinancial msf1:financialList){
				yearDesc=msf1.getYearDescription();
			}
			faVoucherHeader.setVoucherNo("RV/"+locationCode+"/"+yearDesc+"/"+voucherNo);
			
			voucherNo1=locationCode+"/"+yearDesc+"/"+voucherNo;*/
			
			map.put("tableObjectName", "FaVoucherHeader");			
			map.put("isHospitalWise", "y");
			map.put("hospitalId", box.getInt("locationId")); 
			/*map.put("isDivisionWise", "n");
			map.put("divisionId", box.getInt("divisionId"));*/
			map.put("isYearly", "y");			
			/*map.put("isMonthly", "n");*/
			map.put("isPrefix", "y");
			map.put("transactionPrefixProperty", "transactionPrefixForRV");
			
			
			try {
				voucherNo = HMSUtil.generateTransactionSequence(map, session, hbt);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			faVoucherHeader.setVoucherNo(voucherNo);
		
			hbt.save(faVoucherHeader);
			map.put("voucherType", faVoucherHeader.getVoucherType());
			
			int subLedId=0;
			if(box.getInt("subLedId")!=0 ){
				subLedId= box.getInt("subLedId");
			}
			
			FaVoucherDetails voucherDetails = new FaVoucherDetails();
			FaMasAccount masAccount = new FaMasAccount();
			masAccount.setId(box.getInt(ACCOUNT_ID));
			voucherDetails.setAccount(masAccount);
			voucherDetails.setCrAmount(totalAmountCr);
			voucherDetails.setVoucherHeader(faVoucherHeader);
			voucherDetails.setNarration(box.getString(NARRATION));
			
				if(subLedId!=0){
					FaMasSubLed masSubled = new FaMasSubLed();
					masSubled.setId(subLedId);
					voucherDetails.setSubLed(masSubled);	
				}
				
//------------------------------code for account id report--------------------------------------
				if(accountListLength > 0){
					if (box.getInt("accountId1") != 0) {
						FaMasAccount account = new FaMasAccount();
						account.setId(box.getInt("accountId1") );
						voucherDetails.setAccountIdForReport(account);
					}
					if (box.getInt(SUB_LEDGER_CODE+"1") != 0) {
						FaMasSubLed subLed = new FaMasSubLed();
						subLed.setId(box.getInt(SUB_LEDGER_CODE+"1"));
						voucherDetails.setSubLedIdForReport(subLed);
					}
				}

				hbt.save(voucherDetails);
				
		//--------------------------------------------------------------
		if(accountListLength > 0){
			for (int i = 1; i <= accountListLength; i++) {
				FaVoucherDetails faVoucherDetails = new FaVoucherDetails();
				if(!box.getString(AMOUNT+i).equals("") ){
					faVoucherDetails.setVoucherHeader(faVoucherHeader);
				BigDecimal amountDr = new BigDecimal(box.getString(AMOUNT+ i));
				faVoucherDetails.setDrAmount(amountDr);
				int cashAccountId = 0;
				if (box.getInt("accountId"+ i) != 0) {
					FaMasAccount faMasAccount = new FaMasAccount();
					cashAccountId = box.getInt("accountId"+ i);
					faMasAccount.setId(cashAccountId);
					faVoucherDetails.setAccount(faMasAccount);
				}

				if (box.getInt(SUB_LEDGER_CODE+ i) != 0) {
					FaMasSubLed faMasSubLed = new FaMasSubLed();
					faMasSubLed.setId(box.getInt(SUB_LEDGER_CODE+ i));
					faVoucherDetails.setSubLed(faMasSubLed);
				}
				
				
				if (!box.getString(ACCOUNT_NARRATION + i).equals("")) {
					faVoucherDetails.setNarration(box.getString(ACCOUNT_NARRATION + i));
				}
				faVoucherDetails.setReconcile("n");
				hbt.save(faVoucherDetails);
				}

				}
		}
			vhId=faVoucherHeader.getId();
					tx.commit();
					saved = true;
					
				} catch (RuntimeException e) {
					if (tx != null)
						tx.rollback();
					e.printStackTrace();
				}

				Object[] selectedId = {1,2};
				accList = session.createCriteria(FaMasAccount.class).add(Restrictions.eq("ParentStatus", "n"))
						.add(Restrictions.eq("FYear.Id", box.getInt("fYear"))).createAlias("AccountSubGroup", "subGroup").add(Restrictions.in("subGroup.Id", selectedId)).list();
				
				costCenterList = session.createCriteria(MasCostCenter.class).add(Restrictions.eq("Status", "y")).list();
				
				map.put("costCenterList", costCenterList);
				
				map.put("mainAccountId", box.getInt(ACCOUNT_ID));
				map.put("accList", accList);
				paramMap.put("locationId", box.getInt("locationId"));
				paramMap.put("suffix", box.getString("fYearDesc"));
				paramMap.put("flag", "display");
				paramMap.put("prefix", "SV");
				paramMap.put("voucherType", "Sales");
				/*int voucherNo = generateVoucherNo(paramMap);*/
				map.put("voucherNo", voucherNo);
				map.put("vhId", vhId);
				map.put("saved", saved);
				map.put("voucherNo1",voucherNo);
				return map;
		}


	@SuppressWarnings("unchecked")
	public Map<String, Object> showPaymentVoucherJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<FaMasAccount> accList = new ArrayList<FaMasAccount>();
		List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
		Session session = (Session)getSession();
		
		Object[] bankAccountId = {40,41,42,78,79,80,38,39,145,113};
		
		paramMap.put("locationId", box.getInt("locationId"));
		paramMap.put("suffix", box.getString("fYearDesc"));
		paramMap.put("flag", "display");
		paramMap.put("prefix", "PV");
		paramMap.put("voucherType", "Payment");
		/*int voucherNo = generateVoucherNo(paramMap);*/
		/*map.put("voucherNo", voucherNo);*/
		accList = session.createCriteria(FaMasAccount.class)
					.add(Restrictions.in("Id", bankAccountId))
					.add(Restrictions.eq("Status", "y"))
					.list();
		
		costCenterList = session.createCriteria(MasCostCenter.class).add(Restrictions.eq("Status", "y")).list();
		/*map.put("voucherNo", voucherNo);*/
		map.put("costCenterList", costCenterList);
		map.put("accList", accList);
		map.put("locationId", box.getInt("locationId"));
		return map;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> submitPaymentVoucher(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		List<FaMasAccount> accList = new ArrayList<FaMasAccount>();
		List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session)getSession();
		Transaction tx = null;
		boolean saved = false;
		int vhId=0;
		String voucherNo=null;
		int accountListLength = box.getInt("hiddenValueCharge");
		int locationId = box.getInt("locationId");
		try {
			tx = session.beginTransaction();
			FaVoucherHeader faVoucherHeader = new FaVoucherHeader();
			MasHospital masHospital = new MasHospital();
			masHospital.setId(box.getInt("locationId"));
			faVoucherHeader.setHospital(masHospital);
			
		
			faVoucherHeader.setVoucherDate(HMSUtil.convertStringTypeDateToDateType(box.getString(VOUCHER_DATE)));
			faVoucherHeader.setVoucherTime(box.getString(CHANGED_TIME));
			faVoucherHeader.setNarration(box.getString(NARRATION));
			Users users = new Users();
			users.setId(box.getInt("changedBy"));
			faVoucherHeader.setLastChgBy(users);
			faVoucherHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			faVoucherHeader.setLastChgTime(box.getString(CHANGED_TIME));
			faVoucherHeader.setVoucherType("PV");
			faVoucherHeader.setStatus("y");
			
			
			BigDecimal totalAmountCr = new BigDecimal(0.0);
			if (!box.getString(TOTAL_AMOUNT).equals("")) {
				totalAmountCr = new BigDecimal(box.getString(TOTAL_AMOUNT));
			}
			faVoucherHeader.setDrAmount(totalAmountCr);
			faVoucherHeader.setCrAmount(totalAmountCr);

			MasStoreFinancial masStoreFinancial = new MasStoreFinancial();
			System.out.println("box.getInt()"+box.getInt("fYear"));
			masStoreFinancial.setId(box.getInt("fYear"));
			faVoucherHeader.setFYear(masStoreFinancial);
			
			if (!box.getString("transferHo").equals("") && !box.getString("transferHo").isEmpty()) {
				MasHospital centreId = new MasHospital();
				centreId.setId(locationId);
				faVoucherHeader.setCentre(centreId);
			}
			
			if (!box.getString(CHEQUE_DATE).equals("")) {
				faVoucherHeader.setIssueDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHEQUE_DATE)));
			}
			if (!box.getString(CHEQUE_NO).equals("")) {
				faVoucherHeader.setChequeNo(box.getString(CHEQUE_NO));
			}
			if (box.getInt(COST_CENTER_ID) != 0) {
				MasCostCenter masCostCenter = new MasCostCenter();
				masCostCenter.setId(box.getInt(COST_CENTER_ID));
				faVoucherHeader.setCostCenter(masCostCenter);
			}
			faVoucherHeader.setChequeNo(box.getString("checkNo"));
			paramMap.put("locationId", box.getInt("locationId"));
			paramMap.put("suffix", box.getString("fYearDesc"));
			paramMap.put("flag", "save");
			paramMap.put("prefix", "PV");
			paramMap.put("voucherType", "Payment");
			paramMap.put("financialYearId", box.getInt("fyear"));
			/*int voucherNo = generateVoucherNo(paramMap);*/
			String locationCode="";
			String yearDesc="";
			/*List<MasStoreFinancial>financialList=new ArrayList<MasStoreFinancial>();*/
			List<MasHospital>hospitalList=new ArrayList<MasHospital>();
			hospitalList=session.createCriteria(MasHospital.class).add(Restrictions.idEq(box.getInt("locationId"))).list();
			for(MasHospital mg:hospitalList){
				locationCode=mg.getHospitalCode();
			}
			/*int fYearId=0;
			financialList=session.createCriteria(MasStoreFinancial.class).add(Restrictions.idEq(box.getInt("fyear"))).list();
			for(MasStoreFinancial msf1:financialList){
				yearDesc=msf1.getYearDescription();
				fYearId=msf1.getId();
			}*/
			
			int subLedId=0;
			if(box.getInt("subLedId")!=0 ){
				subLedId= box.getInt("subLedId");
			}
			
			map.put("tableObjectName", "FaVoucherHeader");			
			map.put("isHospitalWise", "y");
			map.put("hospitalId", box.getInt("locationId")); 
			/*map.put("isDivisionWise", "n");
			map.put("divisionId", box.getInt("divisionId"));*/
			map.put("isYearly", "y");			
			/*map.put("isMonthly", "n");*/
			map.put("isPrefix", "y");
			map.put("transactionPrefixProperty", "transactionPrefixForPV");
			
			
			try {
				voucherNo = HMSUtil.generateTransactionSequence(map, session, hbt);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			faVoucherHeader.setVoucherNo(voucherNo);
		
			int transferedAccountId=0;
			if (box.getInt("accountId1") != 0) {
				FaMasAccount faMasAccount = new FaMasAccount();
				transferedAccountId = box.getInt("accountId1");
				faMasAccount.setId(transferedAccountId);
				faVoucherHeader.setTransferedAccount(faMasAccount);
			}

			if (box.getInt(SUB_LEDGER_CODE+"1") != 0) {
				FaMasSubLed faMasSubLed = new FaMasSubLed();
				faMasSubLed.setId(box.getInt(SUB_LEDGER_CODE+ "1"));
				faVoucherHeader.setTransferedAccountSubled(faMasSubLed);
			}
			
			hbt.save(faVoucherHeader);
			map.put("voucherType", faVoucherHeader.getVoucherType());
			map.put("voucherNo1", voucherNo);
			int count =box.getInt("hiddenValueCharge");
			
			FaVoucherDetails voucherDetails = new FaVoucherDetails();
				FaMasAccount masAccount = new FaMasAccount();
				masAccount.setId(box.getInt(ACCOUNT_ID));
				voucherDetails.setAccount(masAccount);
				voucherDetails.setCrAmount(totalAmountCr);
				voucherDetails.setVoucherHeader(faVoucherHeader);
				voucherDetails.setNarration(box.getString(NARRATION));
				if(subLedId!=0){
					FaMasSubLed masSubled = new FaMasSubLed();
					masSubled.setId(subLedId);
					voucherDetails.setSubLed(masSubled);	
				}
				//------------------------------code for account id report--------------------------------------
				if(accountListLength > 0){
					if (box.getInt("accountId1") != 0) {
						FaMasAccount account = new FaMasAccount();
						account.setId(box.getInt("accountId1") );
						voucherDetails.setAccountIdForReport(account);
					}
					
					if (box.getInt(SUB_LEDGER_CODE+"1") != 0) {
						FaMasSubLed subLed = new FaMasSubLed();
						subLed.setId(box.getInt(SUB_LEDGER_CODE+"1"));
						voucherDetails.setSubLedIdForReport(subLed);
					}
				}
			
				hbt.save(voucherDetails);

		//--------------------------------------------------------------
		if(accountListLength > 0){
			for (int i = 1; i <= accountListLength; i++) {
				FaVoucherDetails faVoucherDetails = new FaVoucherDetails();
					if(!box.getString(AMOUNT+i).equals("") ){
						faVoucherDetails.setVoucherHeader(faVoucherHeader);
					BigDecimal amountDr = new BigDecimal(box.getString(AMOUNT+ i));
					faVoucherDetails.setDrAmount(amountDr);
					int cashAccountId = 0;
					if (box.getInt("accountId"+ i) != 0) {
						FaMasAccount faMasAccount = new FaMasAccount();
						cashAccountId = box.getInt("accountId"+ i);
						faMasAccount.setId(cashAccountId);
						faVoucherDetails.setAccount(faMasAccount);
					}

					if (box.getInt(SUB_LEDGER_CODE+ i) != 0) {
						FaMasSubLed faMasSubLed = new FaMasSubLed();
						faMasSubLed.setId(box.getInt(SUB_LEDGER_CODE+ i));
						faVoucherDetails.setSubLed(faMasSubLed);
					}
					
					
					if (!box.getString(ACCOUNT_NARRATION + i).equals("")) {
						faVoucherDetails.setNarration(box.getString(ACCOUNT_NARRATION + i));
					}
					faVoucherDetails.setReconcile("n");
					hbt.save(faVoucherDetails);
					}

				}
		}
		
					vhId=faVoucherHeader.getId();
					tx.commit();
					saved = true;
				} catch (RuntimeException e) {
					if (tx != null)
						tx.rollback();
					e.printStackTrace();
				}
		Object[] selectedId = {1,2};
		accList = session.createCriteria(FaMasAccount.class).add(Restrictions.eq("ParentStatus", "n"))
						.add(Restrictions.eq("FYear.Id", box.getInt("fyear"))).createAlias("AccountSubGroup", "subGroup").add(Restrictions.in("subGroup.Id", selectedId)).list();
		costCenterList = session.createCriteria(MasCostCenter.class).add(Restrictions.eq("Status", "y")).list();
		map.put("costCenterList", costCenterList);
		map.put("accList", accList);
		paramMap.put("locationId", box.getInt("locationId"));
	 	paramMap.put("suffix", box.getString("fYearDesc"));
		paramMap.put("flag", "display");
		paramMap.put("prefix", "PV");
		paramMap.put("voucherType", "Payment");
/*		int voucherNo = generateVoucherNo(paramMap);*/
		map.put("voucherNo", voucherNo);
		map.put("saved", saved);
		map.put("vhId", vhId);
		map.put("mainAccountId", box.getInt(ACCOUNT_ID));
		return map;
	}
	
	/* commented by rahul
	@SuppressWarnings("unchecked")
	public Map<String, Object> submitPaymentVoucher(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		List<FaMasAccount> accList = new ArrayList<FaMasAccount>();
		List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session)getSession();
		Transaction tx = null;
		boolean saved = false;
		int vhId=0;
		int accountListLength = box.getInt("hiddenValueCharge");
		//int accountListLengthForBank = box.getInt("hiddenValueChargeForBank");

		try {
			tx = session.beginTransaction();
			FaVoucherHeader faVoucherHeader = new FaVoucherHeader();
			MasHospital masHospital = new MasHospital();
			masHospital.setId(box.getInt("locationId"));
			faVoucherHeader.setHospital(masHospital);

			faVoucherHeader.setVoucherDate(HMSUtil.convertStringTypeDateToDateType(box.getString(VOUCHER_DATE)));
			faVoucherHeader.setVoucherTime(box.getString(CHANGED_TIME));
			faVoucherHeader.setNarration(box.getString(NARRATION));
			Users users = new Users();
			users.setId(box.getInt("changedBy"));
			faVoucherHeader.setLastChgBy(users);
			faVoucherHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			faVoucherHeader.setLastChgTime(box.getString(CHANGED_TIME));
			faVoucherHeader.setVoucherType("PV");
			faVoucherHeader.setStatus("y");
			
			BigDecimal totalAmountCr = new BigDecimal(0.0);
			if (!box.getString(TOTAL_AMOUNT).equals("")) {
				totalAmountCr = new BigDecimal(box.getString(TOTAL_AMOUNT));
			}
			faVoucherHeader.setDrAmount(totalAmountCr);
			faVoucherHeader.setCrAmount(totalAmountCr);

			MasStoreFinancial masStoreFinancial = new MasStoreFinancial();
			masStoreFinancial.setId(box.getInt("fyear"));
			faVoucherHeader.setFYear(masStoreFinancial);
			
			if (!box.getString(CHEQUE_DATE).equals("")) {
				faVoucherHeader.setIssueDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHEQUE_DATE)));
			}
			if (!box.getString(CHEQUE_NO).equals("")) {
				faVoucherHeader.setChequeNo(box.getString(CHEQUE_NO));
			}
			if (box.getInt(COST_CENTER_ID) != 0) {
				MasCostCenter masCostCenter = new MasCostCenter();
				masCostCenter.setId(box.getInt(COST_CENTER_ID));
				faVoucherHeader.setCostCenter(masCostCenter);
			}
			faVoucherHeader.setChequeNo(box.getString("checkNo"));
			paramMap.put("locationId", box.getInt("locationId"));
			paramMap.put("suffix", box.getString("fYearDesc"));
			paramMap.put("flag", "save");
			paramMap.put("prefix", "PV");
			paramMap.put("voucherType", "Payment");
			paramMap.put("financialYearId", box.getInt("fyear"));
			int voucherNo = generateVoucherNo(paramMap);
			String locationCode="";
			String yearDesc="";
			List<MasStoreFinancial>financialList=new ArrayList<MasStoreFinancial>();
			List<MasHospital>hospitalList=new ArrayList<MasHospital>();
			hospitalList=session.createCriteria(MasHospital.class).add(Restrictions.idEq(box.getInt("locationId"))).list();
			for(MasHospital mg:hospitalList){
				locationCode=mg.getHospitalCode();
			}
			int fYearId=0;
			financialList=session.createCriteria(MasStoreFinancial.class).add(Restrictions.idEq(box.getInt("fyear"))).list();
			for(MasStoreFinancial msf1:financialList){
				yearDesc=msf1.getYearDescription();
				fYearId=msf1.getId();
			}
			
			int subLedId=0;
			if(box.getInt("subLedId")!=0 ){
				subLedId= box.getInt("subLedId");
			}
			faVoucherHeader.setVoucherNo("PV/"+locationCode+"/"+yearDesc+"/"+voucherNo);
		
			
			hbt.save(faVoucherHeader);
			map.put("voucherType", faVoucherHeader.getVoucherType());
			map.put("voucherNo1", "PV/"+locationCode+"/"+yearDesc+"/"+voucherNo);
			int count =box.getInt("hiddenValueCharge");
			System.out.println("count------>>"+count);
			FaVoucherDetails voucherDetails = new FaVoucherDetails();
				FaMasAccount masAccount = new FaMasAccount();
				masAccount.setId(box.getInt(ACCOUNT_ID));
				voucherDetails.setAccount(masAccount);
				voucherDetails.setCrAmount(totalAmountCr);
				voucherDetails.setVoucherHeader(faVoucherHeader);
				voucherDetails.setNarration(box.getString(NARRATION));
				if(subLedId!=0){
					FaMasSubLed masSubled = new FaMasSubLed();
					masSubled.setId(subLedId);
					voucherDetails.setSubLed(masSubled);	
				}
				//------------------------------code for account id report--------------------------------------
				if(accountListLength > 0){
					if (box.getInt("accountId1") != 0) {
						FaMasAccount account = new FaMasAccount();
						account.setId(box.getInt("accountId1") );
						voucherDetails.setAccountIdForReport(account);
					}
					System.out.println("subledger=="+box.getInt(SUB_LEDGER_CODE+"1"));
					if (box.getInt(SUB_LEDGER_CODE+"1") != 0) {
						FaMasSubLed subLed = new FaMasSubLed();
						subLed.setId(box.getInt(SUB_LEDGER_CODE+"1"));
						voucherDetails.setSubLedIdForReport(subLed);
					}
				}
			
				hbt.save(voucherDetails);
				
				int centreId=0;
				centreId = getLocationIdForSubLedger(subLedId);
				updateTransactionForPayment(subLedId, box.getInt(ACCOUNT_ID), fYearId, box.getInt("locationId"), ""+totalAmountCr, "0.00",centreId);
				
				

		//--------------------------------------------------------------
		if(accountListLength > 0){
			for (int i = 1; i <= accountListLength; i++) {
				FaVoucherDetails faVoucherDetails = new FaVoucherDetails();
					if(!box.getString(AMOUNT+i).equals("") ){
						faVoucherDetails.setVoucherHeader(faVoucherHeader);
					BigDecimal amountDr = new BigDecimal(box.getString(AMOUNT+ i));
					faVoucherDetails.setDrAmount(amountDr);
					int cashAccountId = 0;
					if (box.getInt("accountId"+ i) != 0) {
						FaMasAccount faMasAccount = new FaMasAccount();
						cashAccountId = box.getInt("accountId"+ i);
						faMasAccount.setId(cashAccountId);
						faVoucherDetails.setAccount(faMasAccount);
					}

					if (box.getInt(SUB_LEDGER_CODE+ i) != 0) {
						FaMasSubLed faMasSubLed = new FaMasSubLed();
						faMasSubLed.setId(box.getInt(SUB_LEDGER_CODE+ i));
						faVoucherDetails.setSubLed(faMasSubLed);
					}
					
					
					if (!box.getString(ACCOUNT_NARRATION + i).equals("")) {
						faVoucherDetails.setNarration(box.getString(ACCOUNT_NARRATION + i));
					}
					faVoucherDetails.setReconcile("n");
					
					int centreIdGrid=0;
					centreIdGrid = getLocationIdForSubLedger(box.getInt(SUB_LEDGER_CODE+ i));

					hbt.save(faVoucherDetails);
					updateTransactionForPayment(box.getInt(SUB_LEDGER_CODE+ i), box.getInt("accountId"+ i), fYearId, box.getInt("locationId"),"0.00", ""+amountDr,centreIdGrid);
	 
					}

				}
		}
		
					vhId=faVoucherHeader.getId();
					tx.commit();
					saved = true;
				} catch (RuntimeException e) {
					if (tx != null)
						tx.rollback();
					e.printStackTrace();
				}
		Object[] selectedId = {1,2};
		accList = session.createCriteria(FaMasAccount.class).add(Restrictions.eq("ParentStatus", "n"))
						.add(Restrictions.eq("FYear.Id", box.getInt("fyear"))).createAlias("AccountSubGroup", "subGroup").add(Restrictions.in("subGroup.Id", selectedId)).list();
		costCenterList = session.createCriteria(MasCostCenter.class).add(Restrictions.eq("Status", "y")).list();
		map.put("costCenterList", costCenterList);
		map.put("accList", accList);
		paramMap.put("locationId", box.getInt("locationId"));
	 	paramMap.put("suffix", box.getString("fYearDesc"));
		paramMap.put("flag", "display");
		paramMap.put("prefix", "PV");
		paramMap.put("voucherType", "Payment");
		int voucherNo = generateVoucherNo(paramMap);
		map.put("voucherNo", voucherNo);
		map.put("saved", saved);
		map.put("vhId", vhId);
		System.out.println(vhId);
		map.put("mainAccountId", box.getInt(ACCOUNT_ID));
		return map;
	
	}
	commented by rahul */
	
	/*@SuppressWarnings("unchecked")
	public Map<String, Object> getFinancialYearForPaymentVoucher(String voucherDate) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<FaMasAccount> accList = new ArrayList<FaMasAccount>();
		List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
		List<HrMasFinancialYear> financialYearList = new ArrayList<HrMasFinancialYear>();
		List<MasBranch> branchList = new ArrayList<MasBranch>();
		Session session = (Session)getSession();
		Object[] selectedId = {"Bank A/C","Cash In Hand"};
		
		financialYearList = session.createCriteria(HrMasFinancialYear.class).add(Restrictions.le("YearFromDate", HMSUtil.dateFormatterDDMMYYYY(voucherDate)))
		.add(Restrictions.ge("YearToDate", HMSUtil.dateFormatterDDMMYYYY(voucherDate)))
			.add(Restrictions.eq("Status", "y"))
				.list();

		int financialYearId = 0;
		String fYearDesc = "";
		if(financialYearList.size()>0){
			for(HrMasFinancialYear financialYear : financialYearList){
				financialYearId = financialYear.getId();
				fYearDesc = financialYear.getYearDescription();
			}
		}
		paramMap.put("suffix", fYearDesc);
		paramMap.put("flag", "display");
		paramMap.put("prefix", "PV");
		paramMap.put("voucherType", "Payment");
		int voucherNo = generateVoucherNo(paramMap);
		map.put("voucherNo", voucherNo);
		accList = session.createCriteria(FaMasAccount.class).add(Restrictions.eq("ParentStatus", "n"))
					.add(Restrictions.eq("FYear.Id", financialYearId)).createAlias("AccountSubGroup", "subGroup")
					.add(Restrictions.or(Restrictions.eq("subGroup.AccountSubGroupName", "Bank A/C"),
						Restrictions.eq("subGroup.AccountSubGroupName", "Cash In Hand"))).list();
		costCenterList = session.createCriteria(MasCostCenter.class).add(Restrictions.eq("Status", "y")).list();
		branchList = session.createCriteria(MasBranch.class).add(Restrictions.eq("Status", "y")).list();
		map.put("voucherNo", voucherNo);
		map.put("branchList", branchList);
		map.put("costCenterList", costCenterList);
		map.put("accList", accList);
		map.put("financialYearId", financialYearId);
		map.put("fYearDesc", fYearDesc);
		return map;
	}*/
	
	@SuppressWarnings("unchecked")
	public int getLocationIdForSubLedger(int subLedId) {
		// TODO Auto-generated method stub
		int centreId=0;
		List<FaMasSubLed>subLedList=new ArrayList<FaMasSubLed>();
		Session session=(Session)getSession();
		subLedList = session.createCriteria(FaMasSubLed.class).add(Restrictions.idEq(subLedId)).list();
		if(subLedList.size()>0){
			for(FaMasSubLed  subLed:subLedList){
				centreId = subLed.getHospital().getId();
			}
			return centreId;
		}
		return centreId;
	}

	

	@SuppressWarnings("unchecked")
	public synchronized Map<String,Object> updateTransactionForPayment(int subLedId,int accountId,int fYearId,int locationId,String crAmount,String drAmount, int centreId) {
		// TODO Auto-generated method stub
	Map<String,Object>map=new HashMap<String,Object>();
	Session session=(Session)getSession();
	HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	boolean flag=false;
	Transaction tx = null;		
	try{
		tx=session.beginTransaction();
		// transaction for Account
		List<AccountMainTransac>amtList=new ArrayList<AccountMainTransac>();
		List<AccountMainTransac>amtListUpdateFromHo=new ArrayList<AccountMainTransac>();

		
		
		
		if(centreId!=0){
			amtList=session.createCriteria(AccountMainTransac.class)
				    .add(Restrictions.eq("Account.Id",accountId))
				    .add(Restrictions.eq("FinancialYear.Id",fYearId))
				    .add(Restrictions.eq("Location.Id",centreId))
			.list();	
			}
			else{
				amtList=session.createCriteria(AccountMainTransac.class)
					    .add(Restrictions.eq("Account.Id",accountId))
					    .add(Restrictions.eq("FinancialYear.Id",fYearId))
					    .add(Restrictions.eq("Location.Id",locationId))
				.list();			
}

		
		
		if(amtList.size()==0){
			AccountMainTransac agt=new AccountMainTransac();
			FaMasAccount fmasg=new FaMasAccount();					
			fmasg.setId(accountId);
			agt.setAccount(fmasg);
				agt.setOpBalanceCr(new BigDecimal(0));
				agt.setClBalanceCr(new BigDecimal(crAmount));
				agt.setOpBalanceDr(new BigDecimal(0));
				agt.setClBalanceDr(new BigDecimal(drAmount));
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			String date = (String) utilMap.get("currentDate");
			String time = (String) utilMap.get("currentTime");
			agt.setTransactionDate(HMSUtil.convertStringTypeDateToDateType(date));
			agt.setTransactionTime(time);
			agt.setYtdAmountCr(new BigDecimal(crAmount));
			agt.setYtdAmountDr(new BigDecimal(drAmount));
			MasStoreFinancial msf=new MasStoreFinancial();
			msf.setId(fYearId);
			agt.setFinancialYear(msf);
			
			MasHospital mh =new MasHospital();
			if(centreId!=0){
				mh.setId(centreId);
				agt.setLocation(mh);
				agt.setCentre(mh);
				}else{
				mh.setId(locationId);
				agt.setLocation(mh);
				}
			
			hbt.save(agt);
		}else if(amtList.size()>0){
			for(AccountMainTransac acgt:amtList){
				Map<String, Object> utilMap = new HashMap<String, Object>();
				utilMap = (Map) HMSUtil.getCurrentDateAndTime();
				String date = (String) utilMap.get("currentDate");
				String time = (String) utilMap.get("currentTime");
				acgt.setTransactionDate(HMSUtil.convertStringTypeDateToDateType(date));
				acgt.setTransactionTime(time);
				if(!crAmount.equals("")){
			
					 
					BigDecimal crAmountSubLedger1=new BigDecimal(0);
					BigDecimal drAmountSubLedger1=new BigDecimal(0);
						crAmountSubLedger1 = acgt.getOpBalanceCr().add(acgt.getYtdAmountCr()).add(new BigDecimal(crAmount));
						drAmountSubLedger1 = acgt.getOpBalanceDr().add(acgt.getYtdAmountDr());
						
						if(drAmountSubLedger1.compareTo(crAmountSubLedger1)>0){
							acgt.setClBalanceDr(drAmountSubLedger1.subtract(crAmountSubLedger1));
							acgt.setClBalanceCr(new BigDecimal(0.00));
						}else if(crAmountSubLedger1.compareTo(drAmountSubLedger1)>0){
							acgt.setClBalanceCr(crAmountSubLedger1.subtract(drAmountSubLedger1));
							acgt.setClBalanceDr(new BigDecimal(0.00));
						}else if(crAmountSubLedger1.compareTo(drAmountSubLedger1)==0){
							acgt.setClBalanceCr(new BigDecimal(0.00));
							acgt.setClBalanceDr(new BigDecimal(0.00));
						}
						
						
						
						
					acgt.setYtdAmountCr(acgt.getYtdAmountCr().add(new BigDecimal(crAmount)));
				}
				if(!drAmount.equals("") ){
					BigDecimal crAmountSubLedger11=new BigDecimal(0);
					BigDecimal drAmountSubLedger11=new BigDecimal(0);
						crAmountSubLedger11 = acgt.getOpBalanceCr().add(acgt.getYtdAmountCr());
						drAmountSubLedger11 = acgt.getOpBalanceDr().add(acgt.getYtdAmountDr()).add(new BigDecimal(drAmount));
						
						if(drAmountSubLedger11.compareTo(crAmountSubLedger11)>0){
							acgt.setClBalanceDr(drAmountSubLedger11.subtract(crAmountSubLedger11));
							acgt.setClBalanceCr(new BigDecimal(0.00));
						}else if(crAmountSubLedger11.compareTo(drAmountSubLedger11)>0){
							acgt.setClBalanceCr(crAmountSubLedger11.subtract(drAmountSubLedger11));
							acgt.setClBalanceDr(new BigDecimal(0.00));
						}else if(crAmountSubLedger11.compareTo(drAmountSubLedger11)==0){
							acgt.setClBalanceCr(new BigDecimal(0.00));
							acgt.setClBalanceDr(new BigDecimal(0.00));
						}
						
					
					acgt.setYtdAmountDr(acgt.getYtdAmountDr().add(new BigDecimal(drAmount)));
				}
				
				hbt.update(acgt);
			}

	}
		
		
		List<AccountMainTransac>amtListDelete=new ArrayList<AccountMainTransac>();
		amtListDelete=session.createCriteria(AccountMainTransac.class).add(Restrictions.eq("ClBalanceDr",new BigDecimal(0.00)))
				.add(Restrictions.eq("ClBalanceCr",new BigDecimal(0.00)))
				.add(Restrictions.eq("YtdAmountCr",new BigDecimal(0.00)))
				.add(Restrictions.eq("YtdAmountDr",new BigDecimal(0.00)))
				.add(Restrictions.eq("OpBalanceCr",new BigDecimal(0.00)))
				.add(Restrictions.eq("OpBalanceDr",new BigDecimal(0.00)))
				.list();
		for(AccountMainTransac amt1:amtListDelete){
			session.delete(amt1);
		}
		// transaction for Subgroup
		int groupId=0;
		int subGroupId=0;
		List<FaMasAccount>accList=new ArrayList<FaMasAccount>();
		accList=session.createCriteria(FaMasAccount.class).add(Restrictions.eq("Id", accountId)).list();
		for(FaMasAccount acc:accList){
			groupId=acc.getAccountSubGroup().getAccountGroup().getId();
			subGroupId=acc.getAccountSubGroup().getId();
		}
		
		
		
		List<AccountSubGroupTransac>subGroupTransacList=new ArrayList<AccountSubGroupTransac>();
		
		
		if(centreId!=0){
			subGroupTransacList=session.createCriteria(AccountSubGroupTransac.class)
				    .add(Restrictions.eq("SubGroup.Id",subGroupId))
				    .add(Restrictions.eq("FYear.Id",fYearId))
				    .add(Restrictions.eq("Location.Id",centreId))
			.list();
				}
					else{
						subGroupTransacList=session.createCriteria(AccountSubGroupTransac.class)
							    .add(Restrictions.eq("SubGroup.Id",subGroupId))
							    .add(Restrictions.eq("FYear.Id",fYearId))
							    .add(Restrictions.eq("Location.Id",locationId))
			.list();	
		}
		
		

		
		if(subGroupTransacList.size()==0){
			AccountSubGroupTransac accountSubGroupTransac=new AccountSubGroupTransac();
			FaMasAccountSubGroup fmasg=new FaMasAccountSubGroup();					
			fmasg.setId(subGroupId);
			accountSubGroupTransac.setSubGroup(fmasg);
			accountSubGroupTransac.setOpBalanceCr(new BigDecimal(0));
			accountSubGroupTransac.setClBalanceCr(new BigDecimal(crAmount));
			accountSubGroupTransac.setOpBalanceDr(new BigDecimal(0));
			accountSubGroupTransac.setClBalanceDr(new BigDecimal(drAmount));
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			String date = (String) utilMap.get("currentDate");
			String time = (String) utilMap.get("currentTime");
			accountSubGroupTransac.setTransactionDate(HMSUtil.convertStringTypeDateToDateType(date));
			accountSubGroupTransac.setTransactionTime(time);
			accountSubGroupTransac.setYtdAmountCr(new BigDecimal(crAmount));
			accountSubGroupTransac.setYtdAmountDr(new BigDecimal(drAmount));
			MasStoreFinancial msf=new MasStoreFinancial();
			msf.setId(fYearId);
			accountSubGroupTransac.setFYear(msf);
			MasHospital mh =new MasHospital();
			if(centreId!=0){
				mh.setId(centreId);
			}else{
				mh.setId(locationId);
			}
			
			accountSubGroupTransac.setLocation(mh);	
			hbt.save(accountSubGroupTransac);
		}else if(subGroupTransacList.size()>0){
			for(AccountSubGroupTransac acgt:subGroupTransacList){
				Map<String, Object> utilMap = new HashMap<String, Object>();
				utilMap = (Map) HMSUtil.getCurrentDateAndTime();
				String date = (String) utilMap.get("currentDate");
				String time = (String) utilMap.get("currentTime");
				acgt.setTransactionDate(HMSUtil.convertStringTypeDateToDateType(date));
				acgt.setTransactionTime(time);
				if(!crAmount.equals("")){
					 
					BigDecimal crAmountSubLedger1=new BigDecimal(0);
					BigDecimal drAmountSubLedger1=new BigDecimal(0);
						crAmountSubLedger1 = acgt.getOpBalanceCr().add(acgt.getYtdAmountCr()).add(new BigDecimal(crAmount));
						drAmountSubLedger1 = acgt.getOpBalanceDr().add(acgt.getYtdAmountDr());
						
						if(drAmountSubLedger1.compareTo(crAmountSubLedger1)>0){
							acgt.setClBalanceDr(drAmountSubLedger1.subtract(crAmountSubLedger1));
							acgt.setClBalanceCr(new BigDecimal(0.00));
						}else if(crAmountSubLedger1.compareTo(drAmountSubLedger1)>0){
							acgt.setClBalanceCr(crAmountSubLedger1.subtract(drAmountSubLedger1));
							acgt.setClBalanceDr(new BigDecimal(0.00));
						}else if(crAmountSubLedger1.compareTo(drAmountSubLedger1)==0){
							acgt.setClBalanceCr(new BigDecimal(0.00));
							acgt.setClBalanceDr(new BigDecimal(0.00));
						}
						
						
						
						
					acgt.setYtdAmountCr(acgt.getYtdAmountCr().add(new BigDecimal(crAmount)));
				}
				if(!drAmount.equals("") ){
					BigDecimal crAmountSubLedger11=new BigDecimal(0);
					BigDecimal drAmountSubLedger11=new BigDecimal(0);
						crAmountSubLedger11 = acgt.getOpBalanceCr().add(acgt.getYtdAmountCr());
						drAmountSubLedger11 = acgt.getOpBalanceDr().add(acgt.getYtdAmountDr()).add(new BigDecimal(drAmount));
						
						if(drAmountSubLedger11.compareTo(crAmountSubLedger11)>0){
							acgt.setClBalanceDr(drAmountSubLedger11.subtract(crAmountSubLedger11));
							acgt.setClBalanceCr(new BigDecimal(0.00));
						}else if(crAmountSubLedger11.compareTo(drAmountSubLedger11)>0){
							acgt.setClBalanceCr(crAmountSubLedger11.subtract(drAmountSubLedger11));
							acgt.setClBalanceDr(new BigDecimal(0.00));
						}else if(crAmountSubLedger11.compareTo(drAmountSubLedger11)==0){
							acgt.setClBalanceCr(new BigDecimal(0.00));
							acgt.setClBalanceDr(new BigDecimal(0.00));
						}
						
						
					
					
					
					acgt.setYtdAmountDr(acgt.getYtdAmountDr().add(new BigDecimal(drAmount)));
				}
				
				hbt.update(acgt);
			}

	
		}
		List<AccountSubGroupTransac>asgtListDelete=new ArrayList<AccountSubGroupTransac>();
		asgtListDelete=session.createCriteria(AccountSubGroupTransac.class).add(Restrictions.eq("ClBalanceDr",new BigDecimal(0.00)))
				.add(Restrictions.eq("ClBalanceCr",new BigDecimal(0.00)))
				.add(Restrictions.eq("YtdAmountCr",new BigDecimal(0.00)))
				.add(Restrictions.eq("YtdAmountDr",new BigDecimal(0.00)))
				.add(Restrictions.eq("OpBalanceCr",new BigDecimal(0.00)))
				.add(Restrictions.eq("OpBalanceDr",new BigDecimal(0.00)))
				.list();
		for(AccountSubGroupTransac asgt1:asgtListDelete){
			session.delete(asgt1);
		}
		
		// transaction for group
		List<AccountGroupTransac>groupTransacList=new ArrayList<AccountGroupTransac>();
		
		
		if(centreId!=0){
			groupTransacList=session.createCriteria(AccountGroupTransac.class)
				    .add(Restrictions.eq("AccountGroup.Id",groupId))
				    .add(Restrictions.eq("FinancialYear.Id",fYearId))
				    .add(Restrictions.eq("Centre.Id",centreId))
			.list();
				}
					else{
						groupTransacList=session.createCriteria(AccountGroupTransac.class)
							    .add(Restrictions.eq("AccountGroup.Id",groupId))
							    .add(Restrictions.eq("FinancialYear.Id",fYearId))
							    .add(Restrictions.eq("Centre.Id",locationId))
			.list();	
		}
		
		
		
		if(groupTransacList.size()==0){
			AccountGroupTransac accountGroupTransac=new AccountGroupTransac();
			
			FaMasAccountGroup fmag=new FaMasAccountGroup();					
			fmag.setId(groupId);
			accountGroupTransac.setAccountGroup(fmag);
			
			accountGroupTransac.setOpBalanceCr(new BigDecimal(0));
			accountGroupTransac.setClBalanceCr(new BigDecimal(crAmount));
			
		
		
			accountGroupTransac.setOpBalanceDr(new BigDecimal(0));
			accountGroupTransac.setClBalanceDr(new BigDecimal(drAmount));
			
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			String date = (String) utilMap.get("currentDate");
			String time = (String) utilMap.get("currentTime");

			
			accountGroupTransac.setTransactionDate(HMSUtil.convertStringTypeDateToDateType(date));
			accountGroupTransac.setTransactionTime(time);
			accountGroupTransac.setYtdAmountCr(new BigDecimal(crAmount));
			accountGroupTransac.setYtdAmountDr(new BigDecimal(drAmount));
			MasStoreFinancial msf=new MasStoreFinancial();
			msf.setId(fYearId);
			accountGroupTransac.setFinancialYear(msf);
			
			MasHospital mh =new MasHospital();
			if(centreId!=0){
				mh.setId(centreId);
			}else{
				mh.setId(locationId);
			}
			accountGroupTransac.setCentre(mh);	
			hbt.save(accountGroupTransac);
			
		}else if(groupTransacList.size()>0){
			for(AccountGroupTransac agt:groupTransacList){
				Map<String, Object> utilMap = new HashMap<String, Object>();
				utilMap = (Map) HMSUtil.getCurrentDateAndTime();
				String date = (String) utilMap.get("currentDate");
				String time = (String) utilMap.get("currentTime");
				agt.setTransactionDate(HMSUtil.convertStringTypeDateToDateType(date));
				agt.setTransactionTime(time);
				if(!crAmount.equals("") ){
					 
					BigDecimal crAmountSubLedger1=new BigDecimal(0);
					BigDecimal drAmountSubLedger1=new BigDecimal(0);
						crAmountSubLedger1 = agt.getOpBalanceCr().add(agt.getYtdAmountCr()).add(new BigDecimal(crAmount));
						drAmountSubLedger1 = agt.getOpBalanceDr().add(agt.getYtdAmountDr());
						
						if(drAmountSubLedger1.compareTo(crAmountSubLedger1)>0){
							agt.setClBalanceDr(drAmountSubLedger1.subtract(crAmountSubLedger1));
							agt.setClBalanceCr(new BigDecimal(0.00));
						}else if(crAmountSubLedger1.compareTo(drAmountSubLedger1)>0){
							agt.setClBalanceCr(crAmountSubLedger1.subtract(drAmountSubLedger1));
							agt.setClBalanceDr(new BigDecimal(0.00));
						}else if(crAmountSubLedger1.compareTo(drAmountSubLedger1)==0){
							agt.setClBalanceCr(new BigDecimal(0.00));
							agt.setClBalanceDr(new BigDecimal(0.00));
						}
						
						
						
						
						agt.setYtdAmountCr(agt.getYtdAmountCr().add(new BigDecimal(crAmount)));
					}
				if(!drAmount.equals("")){
					BigDecimal crAmountSubLedger11=new BigDecimal(0);
					BigDecimal drAmountSubLedger11=new BigDecimal(0);
						crAmountSubLedger11 = agt.getOpBalanceCr().add(agt.getYtdAmountCr());
						drAmountSubLedger11 = agt.getOpBalanceDr().add(agt.getYtdAmountDr()).add(new BigDecimal(drAmount));
						
						if(drAmountSubLedger11.compareTo(crAmountSubLedger11)>0){
							agt.setClBalanceDr(drAmountSubLedger11.subtract(crAmountSubLedger11));
							agt.setClBalanceCr(new BigDecimal(0.00));
						}else if(crAmountSubLedger11.compareTo(drAmountSubLedger11)>0){
							agt.setClBalanceCr(crAmountSubLedger11.subtract(drAmountSubLedger11));
							agt.setClBalanceDr(new BigDecimal(0.00));
						}else if(crAmountSubLedger11.compareTo(drAmountSubLedger11)==0){
							agt.setClBalanceCr(new BigDecimal(0.00));
							agt.setClBalanceDr(new BigDecimal(0.00));
						}
						
						
					
							agt.setYtdAmountDr(agt.getYtdAmountDr().add(new BigDecimal(drAmount)));
				}
				
				hbt.update(agt);
			}
		}
			List<AccountGroupTransac>agtListDelete=new ArrayList<AccountGroupTransac>();
			asgtListDelete=session.createCriteria(AccountGroupTransac.class).add(Restrictions.eq("ClBalanceDr",new BigDecimal(0.00)))
					.add(Restrictions.eq("ClBalanceCr",new BigDecimal(0.00)))
					.add(Restrictions.eq("YtdAmountCr",new BigDecimal(0.00)))
					.add(Restrictions.eq("YtdAmountDr",new BigDecimal(0.00)))
					.add(Restrictions.eq("OpBalanceCr",new BigDecimal(0.00)))
					.add(Restrictions.eq("OpBalanceDr",new BigDecimal(0.00)))
					.list();
			for(AccountGroupTransac agt1:agtListDelete){
				session.delete(agt1);
			}
			
			if(subLedId!=0){
				List<AccountSubLedTransac>asltList=new ArrayList<AccountSubLedTransac>();
				
				if(centreId!=0){
					asltList=session.createCriteria(AccountSubLedTransac.class)
						    .add(Restrictions.eq("SubLed.Id",subLedId))
						    .add(Restrictions.eq("Location.Id",centreId))
						    .add(Restrictions.eq("FYear.Id", fYearId))
					.list();
				}
				else{
					asltList=session.createCriteria(AccountSubLedTransac.class)
						    .add(Restrictions.eq("SubLed.Id",subLedId))
						    .add(Restrictions.eq("Location.Id",locationId))
						    .add(Restrictions.eq("FYear.Id", fYearId))
					.list();	
				}

				
				if(asltList.size()==0){
					AccountSubLedTransac agt=new AccountSubLedTransac();
					
					FaMasSubLed fmasg=new FaMasSubLed();					
					fmasg.setId(subLedId);
					agt.setSubLed(fmasg);//(fmasg);
					
					MasHospital location = new MasHospital();
					if(centreId!=0){
						location.setId(centreId);
					}else{
						location.setId(locationId);
					}
					agt.setLocation(location);
					agt.setOpBalanceCr(new BigDecimal(0));
					agt.setOpBalanceDr(new BigDecimal(0));
					agt.setClBalanceCr(new BigDecimal(crAmount));
					agt.setClBalanceDr(new BigDecimal(drAmount));
					agt.setYtdAmountCr(new BigDecimal(crAmount));
					agt.setYtdAmountDr(new BigDecimal(drAmount));					
					
					
					Map<String, Object> utilMap = new HashMap<String, Object>();
					utilMap = (Map) HMSUtil.getCurrentDateAndTime();
					String date = (String) utilMap.get("currentDate");
					String time = (String) utilMap.get("currentTime");

					
					agt.setTransactionDate(HMSUtil.convertStringTypeDateToDateType(date));
					agt.setTransactionTime(time);
					
					MasStoreFinancial msf=new MasStoreFinancial();
					msf.setId(fYearId);
					agt.setFYear(msf);
					
					hbt.save(agt);
					
				}else if(asltList.size()>0){
					for(AccountSubLedTransac agt:asltList){
						Map<String, Object> utilMap = new HashMap<String, Object>();
						utilMap = (Map) HMSUtil.getCurrentDateAndTime();
						String date = (String) utilMap.get("currentDate");
						String time = (String) utilMap.get("currentTime");
						agt.setTransactionDate(HMSUtil.convertStringTypeDateToDateType(date));
						agt.setTransactionTime(time);
						if(!crAmount.equals("") ){
						
							 
							BigDecimal crAmountSubLedger1=new BigDecimal(0);
							BigDecimal drAmountSubLedger1=new BigDecimal(0);
								crAmountSubLedger1 = agt.getOpBalanceCr().add(agt.getYtdAmountCr()).add(new BigDecimal(crAmount));
								drAmountSubLedger1 = agt.getOpBalanceDr().add(agt.getYtdAmountDr());
								
								if(drAmountSubLedger1.compareTo(crAmountSubLedger1)>0){
									agt.setClBalanceDr(drAmountSubLedger1.subtract(crAmountSubLedger1));
									agt.setClBalanceCr(new BigDecimal(0.00));
								}else if(crAmountSubLedger1.compareTo(drAmountSubLedger1)>0){
									agt.setClBalanceCr(crAmountSubLedger1.subtract(drAmountSubLedger1));
									agt.setClBalanceDr(new BigDecimal(0.00));
								}else if(crAmountSubLedger1.compareTo(drAmountSubLedger1)==0){
									agt.setClBalanceCr(new BigDecimal(0.00));
									agt.setClBalanceDr(new BigDecimal(0.00));
								}
								
								
								
								
								agt.setYtdAmountCr(agt.getYtdAmountCr().add(new BigDecimal(crAmount)));
							}
						if(!drAmount.equals("")){
							BigDecimal crAmountSubLedger11=new BigDecimal(0);
							BigDecimal drAmountSubLedger11=new BigDecimal(0);
								crAmountSubLedger11 = agt.getOpBalanceCr().add(agt.getYtdAmountCr());
								drAmountSubLedger11 = agt.getOpBalanceDr().add(agt.getYtdAmountDr()).add(new BigDecimal(drAmount));
								
								if(drAmountSubLedger11.compareTo(crAmountSubLedger11)>0){
									agt.setClBalanceDr(drAmountSubLedger11.subtract(crAmountSubLedger11));
									agt.setClBalanceCr(new BigDecimal(0.00));
								}else if(crAmountSubLedger11.compareTo(drAmountSubLedger11)>0){
									agt.setClBalanceCr(crAmountSubLedger11.subtract(drAmountSubLedger11));
									agt.setClBalanceDr(new BigDecimal(0.00));
								}else if(crAmountSubLedger11.compareTo(drAmountSubLedger11)==0){
									agt.setClBalanceCr(new BigDecimal(0.00));
									agt.setClBalanceDr(new BigDecimal(0.00));
								}		
								
							
									agt.setYtdAmountDr(agt.getYtdAmountDr().add(new BigDecimal(drAmount)));
						}
						
						hbt.update(agt);
					}
					
				}				
				
			}
	
	}catch(Exception e){
		if(tx != null){
			tx.rollback();
		}
		e.printStackTrace();
	}
	return map;	
	}

	//--------------------------------------------Sales Voucher----------------------------------------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> showSalesVoucherJsp(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
		List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
		Session session = (Session)getSession();
		String fYearDesc = "";
		if(generalMap.get("fYearDesc")!= null){
			fYearDesc = (String)generalMap.get("fYearDesc");
		}
		int locationId = 0;
		if(generalMap.get("locationId")!= null){
			locationId = (Integer)generalMap.get("locationId");
		}
		costCenterList = session.createCriteria(MasCostCenter.class).add(Restrictions.eq("Status", "y")).list();
		
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int agencyTypeId = 0;
		int subGroupId=0;
		List<FaMasAccount>accountList=new ArrayList<FaMasAccount>();
		
		agencyTypeId = Integer.parseInt(properties.getProperty("agencyTypeIdForDealer"));
		subGroupId = Integer.parseInt(properties.getProperty("subGroupIdForSales"));	
		String unitType="";
		accountList=session.createCriteria(FaMasAccount.class).add(Restrictions.eq("AccountSubGroup.Id", subGroupId)).list();
		
		if(generalMap.get("unitType")!= null){
			unitType = (String)generalMap.get("unitType");
		}
		if(unitType.equalsIgnoreCase("HO"))
		{
			supplierList = session.createCriteria(MasStoreSupplier.class)
					.createAlias("AgencyType", "agencyType").add(Restrictions.eq("agencyType.Id", agencyTypeId))					
					.add(Restrictions.eq("Status", "y")).list();
		}
		if(!unitType.equalsIgnoreCase("HO")) // login with centre
		{
			supplierList = session.createCriteria(MasStoreSupplier.class)
					.createAlias("AgencyType", "agencyType").add(Restrictions.eq("agencyType.Id", agencyTypeId))
					.createAlias("Hospital", "location").add(Restrictions.eq("location.Id", locationId))
					.add(Restrictions.eq("Status", "y")).list();
		}
		
		
		paramMap.put("locationId", locationId);
		paramMap.put("suffix", fYearDesc);
		paramMap.put("flag", "display");
		paramMap.put("prefix", "SV");
		paramMap.put("voucherType", "Sales");
		int voucherNo = generateVoucherNo(paramMap);
		map.put("voucherNo", voucherNo);
		map.put("costCenterList", costCenterList);
		map.put("supplierList", supplierList);
		map.put("subGroupId",subGroupId);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> submitSalesVoucher(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
		List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
		String voucherNo1="";
		int vhId=0;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session)getSession();
		Transaction tx = null;
		boolean saved = false;
		try {
			tx = session.beginTransaction();
			FaVoucherHeader voucherHeader = new FaVoucherHeader();
			MasStoreFinancial masStoreFinancial = new MasStoreFinancial();
			masStoreFinancial.setId(box.getInt("fYear"));
			voucherHeader.setFYear(masStoreFinancial);
			MasHospital hospital = new MasHospital();
			hospital.setId(box.getInt("locationId"));
			voucherHeader.setHospital(hospital);
			voucherHeader.setVoucherType("SV");
			voucherHeader.setVoucherDate(HMSUtil.convertStringTypeDateToDateType(box.getString(VOUCHER_DATE)));
			voucherHeader.setVoucherTime(box.getString(CHANGED_TIME));
			voucherHeader.setStatus("y");
			voucherHeader.setNarration(box.getString(NARRATION));
			if(!box.getString(TOTAL_DR_AMOUNT).equals("")){
				voucherHeader.setDrAmount(new BigDecimal(box.getString(TOTAL_DR_AMOUNT)));
			}
			if(!box.getString(TOTAL_CR_AMOUNT).equals("")){
				voucherHeader.setCrAmount(new BigDecimal(box.getString(TOTAL_CR_AMOUNT)));
			}
			if(box.getInt("supplierId")!= 0){
				MasStoreSupplier masStoreSupplier = new MasStoreSupplier();
				masStoreSupplier.setId(box.getInt("supplierId"));
				voucherHeader.setSupplier(masStoreSupplier);
			}
			if(!box.getString("poNo").equals("")){
				voucherHeader.setPoNo(box.getString("poNo"))	;
			}
			if(!box.getString("poDate").equals("")){
				voucherHeader.setPoDate(HMSUtil.convertStringTypeDateToDateType(box.getString("poDate")));
			}
			if(!box.getString("poAmount").equals("")){
				voucherHeader.setPoAmount(new BigDecimal(box.getString("poAmount")));
			}
			if(!box.getString("invoiceNo").equals("")){
				voucherHeader.setInvoiceNo(box.getString("invoiceNo"))	;
			}
			if(!box.getString("invoiceDate").equals("")){
				voucherHeader.setInvoiceDate(HMSUtil.convertStringTypeDateToDateType(box.getString("invoiceDate")));
			}
			if(!box.getString("invoiceAmount").equals("")){
				voucherHeader.setInvoiceAmount(new BigDecimal(box.getString("invoiceAmount")));
			}
			Users user = new Users();
			user.setId(box.getInt("changedBy"));
			voucherHeader.setLastChgBy(user);

			voucherHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			voucherHeader.setLastChgTime(box.getString(CHANGED_TIME));
			
			paramMap.put("locationId", box.getInt("locationId"));
			paramMap.put("suffix", box.getString("fYearDesc"));
			paramMap.put("flag", "save");
			paramMap.put("prefix", "SV");
			paramMap.put("voucherType", "Sales");
			paramMap.put("financialYearId", box.getInt("fYear"));
			int voucherNo = generateVoucherNo(paramMap);
			String locationCode="";
			String yearDesc="";
			List<MasStoreFinancial>financialList=new ArrayList<MasStoreFinancial>();
			List<MasHospital>hospitalList=new ArrayList<MasHospital>();
			hospitalList=session.createCriteria(MasHospital.class).add(Restrictions.idEq(box.getInt("locationId"))).list();
			for(MasHospital mg:hospitalList){
				locationCode=mg.getHospitalCode();
			}
			financialList=session.createCriteria(MasStoreFinancial.class).add(Restrictions.idEq(box.getInt("fYear"))).list();
			for(MasStoreFinancial msf1:financialList){
				yearDesc=msf1.getYearDescription();
			}
			voucherHeader.setVoucherNo("SV/"+locationCode+"/"+yearDesc+"/"+voucherNo);
			voucherNo1=locationCode+"/"+yearDesc+"/"+voucherNo;
			hbt.save(voucherHeader);
			map.put("voucherType", voucherHeader.getVoucherType());
			int counter = box.getInt("hiddenValueCharge");
			for (int i = 1; i <= counter; i++) {
				int accountId = 0;
				BigDecimal crAmt = new BigDecimal(0.00);
				BigDecimal drAmt = new BigDecimal(0.00);
				FaVoucherDetails voucherDetails = new FaVoucherDetails();
				voucherDetails.setVoucherHeader(voucherHeader);
				FaMasAccount account = new FaMasAccount();
				accountId = box.getInt("accountId"+i);
				account.setId(accountId);
				voucherDetails.setAccount(account);
				if(box.getInt(SUB_LEDGER_CODE+i) != 0){
					FaMasSubLed subLed= new FaMasSubLed();
					subLed.setId(box.getInt(SUB_LEDGER_CODE+i));
					voucherDetails.setSubLed(subLed);
				}
				if(box.getInt(COST_CENTER_ID+i) != 0){
					MasCostCenter costCenter = new MasCostCenter();
					costCenter.setId(box.getInt(COST_CENTER_ID+i));
					voucherDetails.setCostCenter(costCenter);
				}
				voucherDetails.setNarration(box.getString(ACCOUNT_NARRATION+i));
				voucherDetails.setReconcile("n");
				if(!box.getString(CR_AMOUNT+i).equals("")){
					crAmt = new BigDecimal(box.getString(CR_AMOUNT+i));
					voucherDetails.setCrAmount(crAmt);
				}
				if(!box.getString(DR_AMOUNT+i).equals("")){
					drAmt = new BigDecimal(box.getString(DR_AMOUNT+i));
					voucherDetails.setDrAmount(drAmt);
				}
				hbt.save(voucherDetails);
				
			}
			vhId=voucherHeader.getId();
			tx.commit();
			saved = true;
		} catch (Exception e) {
			if(tx != null){
				tx.rollback();
			}
			e.printStackTrace();
		}

		costCenterList = session.createCriteria(MasCostCenter.class).add(Restrictions.eq("Status", "y")).list();
		supplierList = session.createCriteria(MasStoreSupplier.class).add(Restrictions.eq("Status", "y")).list();
		paramMap.put("locationId", box.getInt("locationId"));
		paramMap.put("suffix", box.getString("fYearDesc"));
		paramMap.put("flag", "display");
		paramMap.put("prefix", "SV");
		paramMap.put("voucherType", "Sales");
		int voucherNo = generateVoucherNo(paramMap);
		map.put("voucherNo", voucherNo);
		map.put("vhId", vhId);
		map.put("saved", saved);
		map.put("costCenterList", costCenterList);
		map.put("supplierList", supplierList);
		map.put("voucherNo1",voucherNo1);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> submitSalesReturnVoucher(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
		List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
		String voucherNo1="";
		int vhId=0;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session)getSession();
		Transaction tx = null;
		boolean saved = false;
		try {
			tx = session.beginTransaction();
			FaVoucherHeader voucherHeader = new FaVoucherHeader();
			MasStoreFinancial masStoreFinancial = new MasStoreFinancial();
			masStoreFinancial.setId(box.getInt("fYear"));
			voucherHeader.setFYear(masStoreFinancial);
			MasHospital hospital = new MasHospital();
			hospital.setId(box.getInt("locationId"));
			voucherHeader.setHospital(hospital);
			voucherHeader.setVoucherType("SR");
			voucherHeader.setVoucherDate(HMSUtil.convertStringTypeDateToDateType(box.getString(VOUCHER_DATE)));
			voucherHeader.setVoucherTime(box.getString(CHANGED_TIME));
			voucherHeader.setStatus("y");
			voucherHeader.setNarration(box.getString(NARRATION));
			if(!box.getString(TOTAL_DR_AMOUNT).equals("")){
				voucherHeader.setDrAmount(new BigDecimal(box.getString(TOTAL_DR_AMOUNT)));
			}
			if(!box.getString(TOTAL_CR_AMOUNT).equals("")){
				voucherHeader.setCrAmount(new BigDecimal(box.getString(TOTAL_CR_AMOUNT)));
			}
			if(box.getInt("supplierId")!= 0){
				MasStoreSupplier masStoreSupplier = new MasStoreSupplier();
				masStoreSupplier.setId(box.getInt("supplierId"));
				voucherHeader.setSupplier(masStoreSupplier);
			}
			if(!box.getString("poNo").equals("")){
				voucherHeader.setPoNo(box.getString("poNo"))	;
			}
			if(!box.getString("poDate").equals("")){
				voucherHeader.setPoDate(HMSUtil.convertStringTypeDateToDateType(box.getString("poDate")));
			}
			if(!box.getString("poAmount").equals("")){
				voucherHeader.setPoAmount(new BigDecimal(box.getString("poAmount")));
			}
			if(!box.getString("invoiceNo").equals("")){
				voucherHeader.setInvoiceNo(box.getString("invoiceNo"))	;
			}
			if(!box.getString("invoiceDate").equals("")){
				voucherHeader.setInvoiceDate(HMSUtil.convertStringTypeDateToDateType(box.getString("invoiceDate")));
			}
			if(!box.getString("invoiceAmount").equals("")){
				voucherHeader.setInvoiceAmount(new BigDecimal(box.getString("invoiceAmount")));
			}
			Users user = new Users();
			user.setId(box.getInt("changedBy"));
			voucherHeader.setLastChgBy(user);

			voucherHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			voucherHeader.setLastChgTime(box.getString(CHANGED_TIME));
			
			paramMap.put("locationId", box.getInt("locationId"));
			paramMap.put("suffix", box.getString("fYearDesc"));
			paramMap.put("flag", "save");
			paramMap.put("prefix", "SR");
			paramMap.put("voucherType", "SalesReturn");
			paramMap.put("financialYearId", box.getInt("fYear"));
			int voucherNo = generateVoucherNo(paramMap);
			String locationCode="";
			String yearDesc="";
			List<MasStoreFinancial>financialList=new ArrayList<MasStoreFinancial>();
			List<MasHospital>hospitalList=new ArrayList<MasHospital>();
			hospitalList=session.createCriteria(MasHospital.class).add(Restrictions.idEq(box.getInt("locationId"))).list();
			for(MasHospital mg:hospitalList){
				locationCode=mg.getHospitalCode();
			}
			financialList=session.createCriteria(MasStoreFinancial.class).add(Restrictions.idEq(box.getInt("fYear"))).list();
			for(MasStoreFinancial msf1:financialList){
				yearDesc=msf1.getYearDescription();
			}
			voucherHeader.setVoucherNo("SR/"+locationCode+"/"+yearDesc+"/"+voucherNo);
			voucherNo1=locationCode+"/"+yearDesc+"/"+voucherNo;
			
			hbt.save(voucherHeader);
			map.put("voucherType", voucherHeader.getVoucherType());
			int counter = box.getInt("hiddenValueCharge");
			for (int i = 1; i <= counter; i++) {

				int accountId = 0;
				BigDecimal crAmt = new BigDecimal(0.00);
				BigDecimal drAmt = new BigDecimal(0.00);
				FaVoucherDetails voucherDetails = new FaVoucherDetails();
				voucherDetails.setVoucherHeader(voucherHeader);
				FaMasAccount account = new FaMasAccount();
				accountId = box.getInt("accountId"+i);
				account.setId(accountId);
				voucherDetails.setAccount(account);
				if(box.getInt(SUB_LEDGER_CODE+i) != 0){
					FaMasSubLed subLed= new FaMasSubLed();
					subLed.setId(box.getInt(SUB_LEDGER_CODE+i));
					voucherDetails.setSubLed(subLed);
				}
				
				voucherDetails.setNarration(box.getString(ACCOUNT_NARRATION+i));
				voucherDetails.setReconcile("n");
				if(!box.getString(CR_AMOUNT+i).equals("")){
					crAmt = new BigDecimal(box.getString(CR_AMOUNT+i));
					voucherDetails.setCrAmount(crAmt);
				}
				if(!box.getString(DR_AMOUNT+i).equals("")){
					drAmt = new BigDecimal(box.getString(DR_AMOUNT+i));
					voucherDetails.setDrAmount(drAmt);
				}
				hbt.save(voucherDetails);
				
			
			}
			vhId=voucherHeader.getId();
			tx.commit();
			saved = true;
		} catch (Exception e) {
			if(tx != null){
				tx.rollback();
			}
			e.printStackTrace();
		}

		costCenterList = session.createCriteria(MasCostCenter.class).add(Restrictions.eq("Status", "y")).list();
		supplierList = session.createCriteria(MasStoreSupplier.class).add(Restrictions.eq("Status", "y")).list();
		paramMap.put("locationId", box.getInt("locationId"));
		paramMap.put("suffix", box.getString("fYearDesc"));
		paramMap.put("flag", "display");
		paramMap.put("prefix", "SR");
		paramMap.put("voucherType", "SalesReturn");
		int voucherNo = generateVoucherNo(paramMap);
		map.put("voucherNo", voucherNo);
		map.put("vhId", vhId);
		map.put("saved", saved);
		map.put("costCenterList", costCenterList);
		map.put("supplierList", supplierList);
		map.put("voucherNo1",voucherNo1);
		return map;
	}
		
	@SuppressWarnings("unchecked")
	public Map<String, Object> showSalesReturnVoucherJsp(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
		List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
		Session session = (Session)getSession();
		String fYearDesc = "";
		if(generalMap.get("fYearDesc")!= null){
			fYearDesc = (String)generalMap.get("fYearDesc");
		}
		int locationId = 0;
		if(generalMap.get("locationId")!= null){
			locationId = (Integer)generalMap.get("locationId");
		}
		costCenterList = session.createCriteria(MasCostCenter.class).add(Restrictions.eq("Status", "y")).list();
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int agencyTypeId = 0;
		
		
		agencyTypeId = Integer.parseInt(properties.getProperty("agencyTypeIdForDealer"));
			
		String unitType="";
		if(generalMap.get("unitType")!= null){
			unitType = (String)generalMap.get("unitType");
		}
		if(unitType.equalsIgnoreCase("HO"))
		{
			supplierList = session.createCriteria(MasStoreSupplier.class)
					.createAlias("AgencyType", "agencyType").add(Restrictions.eq("agencyType.Id", agencyTypeId))					
					.add(Restrictions.eq("Status", "y")).list();
		}
		if(!unitType.equalsIgnoreCase("HO")) // login with centre
		{
			supplierList = session.createCriteria(MasStoreSupplier.class)
					.createAlias("AgencyType", "agencyType").add(Restrictions.eq("agencyType.Id", agencyTypeId))
					.createAlias("Hospital", "location").add(Restrictions.eq("location.Id", locationId))
					.add(Restrictions.eq("Status", "y")).list();
		}
		paramMap.put("locationId", locationId);
		paramMap.put("suffix", fYearDesc);
		paramMap.put("flag", "display");
		paramMap.put("prefix", "SR");
		paramMap.put("voucherType", "SalesReturn");
		int voucherNo = generateVoucherNo(paramMap);
		map.put("voucherNo", voucherNo);
		map.put("costCenterList", costCenterList);
		map.put("supplierList", supplierList);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> showPurchaseVoucherJsp(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
		List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
		Session session = (Session)getSession();
		String fYearDesc = "";
		int locationId = 0;
		if(generalMap.get("locationId")!= null){
			locationId = (Integer)generalMap.get("locationId");
		}
		if(generalMap.get("fYearDesc")!= null){
			fYearDesc = (String)generalMap.get("fYearDesc");
		}
		costCenterList = session.createCriteria(MasCostCenter.class).add(Restrictions.eq("Status", "y")).list();
		
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int agencyTypeId = 0;
		int subGroupId =0;
		List<FaMasAccount>accountList=new ArrayList<FaMasAccount>();
		Object[] bankAccountIdId = {40,41,42,78,79,80,38,39,145};
		/*agencyTypeId = Integer.parseInt(properties.getProperty("agencyTypeIdForVendor"));*/
		subGroupId = Integer.parseInt(properties.getProperty("subGroupIdForSales"));	
		String unitType="";
		//accountList=session.createCriteria(FaMasAccount.class).add(Restrictions.eq("AccountSubGroup.Id", subGroupId)).list();
		accountList=session.createCriteria(FaMasAccount.class).add(Restrictions.in("Id", bankAccountIdId))
				.add(Restrictions.eq("Status", "y")).list();

		if(generalMap.get("unitType")!= null){
			unitType = (String)generalMap.get("unitType");
		}
		if(unitType.equalsIgnoreCase("HO"))
		{
			supplierList = session.createCriteria(MasStoreSupplier.class)										
					.add(Restrictions.eq("Status", "y")).list();
		}
		if(!unitType.equalsIgnoreCase("HO")) // login with centre
		{
			supplierList = session.createCriteria(MasStoreSupplier.class)				
					.createAlias("Hospital", "location").add(Restrictions.eq("location.Id", locationId))
					.add(Restrictions.eq("Status", "y")).list();
		}
		
		paramMap.put("locationId", locationId);
		paramMap.put("suffix", fYearDesc);
		paramMap.put("flag", "display");
		paramMap.put("prefix", "PV");
		paramMap.put("voucherType", "Purchase");
		/*int voucherNo = generateVoucherNo(paramMap);*/
		/*map.put("voucherNo", voucherNo);*/
		map.put("costCenterList", costCenterList);
		map.put("supplierList", supplierList);
		map.put("accountList", accountList);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> submitPurchaseVoucher(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
		List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
		String voucherNo="";
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session)getSession();
		int counter = box.getInt("hiddenValueCharge");
		Transaction tx = null;
		int vhId=0;
		boolean saved = false;
		try {
			tx = session.beginTransaction();
			FaVoucherHeader voucherHeader = new FaVoucherHeader();
			MasStoreFinancial masStoreFinancial = new MasStoreFinancial();
			masStoreFinancial.setId(box.getInt("fYear"));
			voucherHeader.setFYear(masStoreFinancial);
			MasHospital hospital = new MasHospital();
			hospital.setId(box.getInt("locationId"));
			voucherHeader.setHospital(hospital);
			voucherHeader.setVoucherType("PRV");
			voucherHeader.setVoucherDate(HMSUtil.convertStringTypeDateToDateType(box.getString(VOUCHER_DATE)));
			voucherHeader.setVoucherTime(box.getString(CHANGED_TIME));
			voucherHeader.setStatus("y");
			voucherHeader.setNarration(box.getString(NARRATION));
			
			BigDecimal totalAmountCr = new BigDecimal(0.0);
			if (!box.getString(TOTAL_AMOUNT).equals("")) {
				totalAmountCr = new BigDecimal(box.getString(TOTAL_AMOUNT));
			}
			voucherHeader.setDrAmount(totalAmountCr);
			voucherHeader.setCrAmount(totalAmountCr);
			
			if(box.getInt("supplierId")!= 0){
				MasStoreSupplier masStoreSupplier = new MasStoreSupplier();
				masStoreSupplier.setId(box.getInt("supplierId"));
				voucherHeader.setSupplier(masStoreSupplier);
			}
			if(!box.getString("poNo").equals("")){
				voucherHeader.setPoNo(box.getString("poNo"))	;
			}
			if(!box.getString("poDate").equals("")){
				voucherHeader.setPoDate(HMSUtil.convertStringTypeDateToDateType(box.getString("poDate")));
			}
			if(!box.getString("poAmount").equals("")){
				voucherHeader.setPoAmount(new BigDecimal(box.getString("poAmount")));
			}
			if(!box.getString("invoiceNo").equals("")){
				voucherHeader.setInvoiceNo(box.getString("invoiceNo"))	;
			}
			if(!box.getString("invoiceDate").equals("")){
				voucherHeader.setInvoiceDate(HMSUtil.convertStringTypeDateToDateType(box.getString("invoiceDate")));
			}
			if(!box.getString("invoiceAmount").equals("")){
				voucherHeader.setInvoiceAmount(new BigDecimal(box.getString("invoiceAmount")));
			}
			Users user = new Users();
			user.setId(box.getInt("changedBy"));
			voucherHeader.setLastChgBy(user);

			voucherHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			voucherHeader.setLastChgTime(box.getString(CHANGED_TIME));
			
			map.put("tableObjectName", "FaVoucherHeader");			
			map.put("isHospitalWise", "y");
			map.put("hospitalId", box.getInt("locationId")); 
			/*map.put("isDivisionWise", "n");
			map.put("divisionId", box.getInt("divisionId"));*/
			map.put("isYearly", "y");			
			/*map.put("isMonthly", "n");*/
			map.put("isPrefix", "y");
			map.put("transactionPrefixProperty", "transactionPrefixForPRV");
			
			
			try {
				voucherNo = HMSUtil.generateTransactionSequence(map, session, hbt);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			voucherHeader.setVoucherNo(voucherNo);
			
			hbt.save(voucherHeader);
			
			
			int subLedId=0;
			if(box.getInt("subLedId")!=0 ){
				subLedId= box.getInt("subLedId");
			}
				
				FaVoucherDetails voucherDetails = new FaVoucherDetails();
				FaMasAccount masAccount = new FaMasAccount();
				masAccount.setId(box.getInt(ACCOUNT_ID));
				voucherDetails.setAccount(masAccount);
				voucherDetails.setCrAmount(totalAmountCr);
				voucherDetails.setVoucherHeader(voucherHeader);
				voucherDetails.setNarration(box.getString(NARRATION));
				if(subLedId!=0){
					FaMasSubLed masSubled = new FaMasSubLed();
					masSubled.setId(subLedId);
					voucherDetails.setSubLed(masSubled);	
				}
		
			//------------------------------code for account id report--------------------------------------
			
				if (box.getInt(ACCOUNT_ID) != 0) {
					FaMasAccount account = new FaMasAccount();
					account.setId(box.getInt(ACCOUNT_ID) );
					voucherDetails.setAccountIdForReport(account);
				
					if (box.getInt(SUB_LEDGER_CODE) != 0) {
						FaMasSubLed faMasSubLed = new FaMasSubLed();
						faMasSubLed.setId(box.getInt(SUB_LEDGER_CODE));
						voucherDetails.setSubLed(faMasSubLed);
					}
			}
	
			hbt.save(voucherDetails);
			
			//updateTransaction(subLedId, box.getInt("accName"), box.getInt("fYear"), box.getInt("locationId"), ""+totalAmountCr, "0.00");

			if(counter > 0){
			for (int i = 1; i <= counter; i++) {
				FaVoucherDetails faVoucherDetails = new FaVoucherDetails();
				if(!box.getString(AMOUNT+i).equals("") ){
					faVoucherDetails.setVoucherHeader(voucherHeader);
				BigDecimal amountDr = new BigDecimal(box.getString(AMOUNT+ i));
				faVoucherDetails.setDrAmount(amountDr);
				int cashAccountId = 0;
				if (box.getInt("accountId"+ i) != 0) {
					FaMasAccount faMasAccount = new FaMasAccount();
					cashAccountId = box.getInt("accountId"+ i);
					faMasAccount.setId(cashAccountId);
					faVoucherDetails.setAccount(faMasAccount);
				}

				if (box.getInt(SUB_LEDGER_CODE+ i) != 0) {
					FaMasSubLed faMasSubLed = new FaMasSubLed();
					faMasSubLed.setId(box.getInt(SUB_LEDGER_CODE+ i));
					faVoucherDetails.setSubLed(faMasSubLed);
				}
				
				
				if (!box.getString(ACCOUNT_NARRATION + i).equals("")) {
					faVoucherDetails.setNarration(box.getString(ACCOUNT_NARRATION + i));
				}
				faVoucherDetails.setReconcile("n");
				hbt.save(faVoucherDetails);
				
				//updateTransaction(box.getInt(SUB_LEDGER_CODE+i), accountId, box.getInt("fYear"), box.getInt("locationId"), ""+crAmt, ""+drAmt);
				}
			  }
			}
			vhId=voucherHeader.getId();
			tx.commit();
			saved = true;
		} catch (Exception e) {
			if(tx != null){
				tx.rollback();
			}
			e.printStackTrace();
		}

		costCenterList = session.createCriteria(MasCostCenter.class).add(Restrictions.eq("Status", "y")).list();
		supplierList = session.createCriteria(MasStoreSupplier.class).add(Restrictions.eq("Status", "y")).list();
		paramMap.put("locationId", box.getInt("locationId"));
		paramMap.put("suffix", box.getString("fYearDesc"));
		paramMap.put("flag", "display");
		paramMap.put("prefix", "PRV");
		paramMap.put("voucherType", "Purchase");
		/*int voucherNo = generateVoucherNo(paramMap);*/
		map.put("voucherNo", voucherNo);
		map.put("vhId", vhId);
		map.put("saved", saved);
		map.put("supplierList", supplierList);
		map.put("costCenterList", costCenterList);
		map.put("voucherNo1",voucherNo);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> showPurchaseReturnVoucherJsp(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
		List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
		Session session = (Session)getSession();
		String fYearDesc = "";
		if(generalMap.get("fYearDesc")!= null){
			fYearDesc = (String)generalMap.get("fYearDesc");
		}
		int locationId = 0;
		if(generalMap.get("locationId")!= null){
			locationId = (Integer)generalMap.get("locationId");
		}
		costCenterList = session.createCriteria(MasCostCenter.class).add(Restrictions.eq("Status", "y")).list();
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int agencyTypeId = 0;
		
		
		agencyTypeId = Integer.parseInt(properties.getProperty("agencyTypeIdForVendor"));
			
		String unitType="";
		if(generalMap.get("unitType")!= null){
			unitType = (String)generalMap.get("unitType");
		}
		if(unitType.equalsIgnoreCase("HO"))
		{
			supplierList = session.createCriteria(MasStoreSupplier.class)
					/*.createAlias("AgencyType", "agencyType").add(Restrictions.eq("agencyType.Id", agencyTypeId))*/					
					.add(Restrictions.eq("Status", "y")).list();
		}
		if(!unitType.equalsIgnoreCase("HO")) // login with centre
		{
			supplierList = session.createCriteria(MasStoreSupplier.class)
					/*.createAlias("AgencyType", "agencyType").add(Restrictions.eq("agencyType.Id", agencyTypeId))*/
					.createAlias("Hospital", "location").add(Restrictions.eq("location.Id", locationId))
					.add(Restrictions.eq("Status", "y")).list();
		}

		
		paramMap.put("locationId", locationId);
		paramMap.put("suffix", fYearDesc);
		paramMap.put("flag", "display");
		paramMap.put("prefix", "PR");
		paramMap.put("voucherType", "PurchaseReturn");
		/*int voucherNo = generateVoucherNo(paramMap);*/
		/*map.put("voucherNo", voucherNo);*/
		map.put("costCenterList", costCenterList);
		map.put("supplierList", supplierList);
		return map;
	}


	@SuppressWarnings("unchecked")
	public Map<String, Object> showAccountSubGroup(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasFinancialYear> financialYearList = new ArrayList<HrMasFinancialYear>();
		List<FaMasAccountSubGroup> accountSubGrpList = new ArrayList<FaMasAccountSubGroup>();
		List<FaMasAccountGroup> accountGroupList = new ArrayList<FaMasAccountGroup>();
		List<Integer> lastSubGroupCodeList = new ArrayList<Integer>();
		int accountGroupId = 0;
		int fYear = 0;
		if(generalMap.get("accountGroupId")!= null){
			accountGroupId = (Integer)generalMap.get("accountGroupId");
		}
		if(generalMap.get("fYear")!= null){
			fYear = (Integer)generalMap.get("fYear");
		}
		int locationId = 0;
		if(generalMap.get("locationId")!= null){
			locationId = (Integer)generalMap.get("locationId");
		}
		Session session = (Session)getSession();
		lastSubGroupCodeList = session.createCriteria(FaMasAccountSubGroup.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Hospital.Id", locationId))
		.setProjection(Projections.projectionList().add(
				Projections.max("AccountSubGroupCode"))).list();
		
		if(lastSubGroupCodeList.size()>0){
			int lastSubGroupCode = 0;
			if(lastSubGroupCodeList.get(0) != null){
			 lastSubGroupCode = (lastSubGroupCodeList.get(0));
			}
			map.put("lastSubGroupCode", lastSubGroupCode);
		}
		Criteria crit = null;

		crit = session.createCriteria(FaMasAccountSubGroup.class).createAlias("FYear", "fy")
									.add(Restrictions.eq("fy.Id", fYear)).add(Restrictions.eq("Hospital.Id", locationId));
								
		if(accountGroupId != 0){
			crit = crit.createAlias("AccountGroup", "group").add(Restrictions.eq("group.Id", accountGroupId));
		}
		accountSubGrpList = crit.list();
		accountGroupList = session.createCriteria(FaMasAccountGroup.class).add(Restrictions.eq("Status", "y")).list();
		map.put("accountGroupList", accountGroupList);
		map.put("accountSubGrpList", accountSubGrpList);
		return map;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> addAccountSubGroup(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccountSubGroup> existingAccountSubGroupList = new ArrayList<FaMasAccountSubGroup>();
		//List<HrMasFinancialYear> financialYearList = new ArrayList<HrMasFinancialYear>();
		List<Integer> lastSubGroupCodeList = new ArrayList<Integer>();
		List<FaMasAccountSubGroup> accountSubGrpList = new ArrayList<FaMasAccountSubGroup>();
		List<FaMasAccountGroup> accountGroupList = new ArrayList<FaMasAccountGroup>();
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		int  fYear = 0;
		String message = "";
		int locationId = 0;
		try {
			FaMasAccountSubGroup faMasAccountSubGroup = new FaMasAccountSubGroup();
			if(generalMap.get("faMasAccountSubGroup")!= null){
				faMasAccountSubGroup = (FaMasAccountSubGroup)generalMap.get("faMasAccountSubGroup");
			}
			if(generalMap.get("fYear")!= null){
				fYear = (Integer)generalMap.get("fYear");
			}
			if(generalMap.get("locationId")!= null){
				locationId = (Integer)generalMap.get("locationId");
			}
			Integer accountSubGroupCode = faMasAccountSubGroup.getAccountSubGroupCode();
			//String accountSubGroupName = faMasAccountSubGroup.getAccountSubGroupName();
			
			/*int groupId =0;
			if(generalMap.get("accountgroupId")!= null){
				groupId = (Integer)generalMap.get("accountgroupId");
			}*/
			
			existingAccountSubGroupList = session.createCriteria(FaMasAccountSubGroup.class).add(Restrictions.eq("AccountSubGroupCode", accountSubGroupCode))
											.add(Restrictions.eq("FYear.Id", fYear)).add(Restrictions.eq("Hospital.Id", locationId)).list();
			if (existingAccountSubGroupList.size() > 0) {
				message = "Record already Exist";
			} else {
				
				hbt.save(faMasAccountSubGroup);
				message = "Record saved successfully!";

			}
			lastSubGroupCodeList = session.createCriteria(FaMasAccountSubGroup.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("FYear.Id", fYear))
									.add(Restrictions.eq("Hospital.Id", locationId))
											.setProjection(Projections.projectionList().add(
														Projections.max("AccountSubGroupCode"))).list();

			if(lastSubGroupCodeList.size()>0){
			int lastSubGroupCode = lastSubGroupCodeList.get(0);
			map.put("lastSubGroupCode", lastSubGroupCode);
			}
			accountSubGrpList = session.createCriteria(FaMasAccountSubGroup.class).createAlias("FYear", "fy")
								.add(Restrictions.eq("fy.Id", fYear)).add(Restrictions.eq("Hospital.Id", locationId)).list();
			accountGroupList = session.createCriteria(FaMasAccountGroup.class).add(Restrictions.eq("Status", "y"))
									.add(Restrictions.eq("FYear.Id", fYear)).add(Restrictions.eq("Hospital.Id", locationId)).list();
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		map.put("message", message);
		map.put("accountGroupList", accountGroupList);
		map.put("accountSubGrpList", accountSubGrpList);
		return map;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> updateAccountSubGroup(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccountSubGroup> existingAccountSubGroupList = new ArrayList<FaMasAccountSubGroup>();
		//List<HrMasFinancialYear> financialYearList = new ArrayList<HrMasFinancialYear>();
		List<FaMasAccountSubGroup> accountSubGrpList = new ArrayList<FaMasAccountSubGroup>();
		List<FaMasAccountGroup> accountGroupList = new ArrayList<FaMasAccountGroup>();
		List<Integer> lastSubGroupCodeList = new ArrayList<Integer>();
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		//int  financialYearId = 0;
		String message = "";
		try {
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			String date = (String) utilMap.get("currentDate");
			String time = (String) utilMap.get("currentTime");
			int subGroupId = 0;
			if(generalMap.get("subGroupId") != null){
				subGroupId = (Integer)generalMap.get("subGroupId");
			}
			int accountSubGroupCode = 0;
			if(generalMap.get("accountSubGroupCode") != null){
				accountSubGroupCode = (Integer)generalMap.get("accountSubGroupCode");
			}
			String accounSubGroupName = "";
			if(generalMap.get("accounSubGroupName") != null){
				accounSubGroupName = (String)generalMap.get("accounSubGroupName");
			}
			
			int groupId =0;
			if(generalMap.get("accountgroupId")!= null){
				groupId = (Integer)generalMap.get("accountgroupId");
			}
			int changedBy = 0;
			if(generalMap.get("changedBy")!= null){
				changedBy = (Integer)generalMap.get("changedBy");
			}
			int fYear = 0; 
			if(generalMap.get("fYear") != null){
				fYear = (Integer)generalMap.get("fYear");
			}
			int locationId = 0;
			if(generalMap.get("locationId") != null){
				locationId = (Integer)generalMap.get("locationId");
			}
			lastSubGroupCodeList = session.createCriteria(FaMasAccountSubGroup.class).add(Restrictions.eq("Status", "y"))
									.add(Restrictions.eq("FYear.Id", fYear)).add(Restrictions.eq("Hospital.Id", locationId))
			.setProjection(Projections.projectionList().add(
					Projections.max("AccountSubGroupCode"))).list();
			
			if(lastSubGroupCodeList.size()>0){
				int lastSubGroupCode = lastSubGroupCodeList.get(0);
				map.put("lastSubGroupCode", lastSubGroupCode);
			}
			existingAccountSubGroupList = session.createCriteria(FaMasAccountSubGroup.class).add(Restrictions.eq("AccountSubGroupName", accounSubGroupName))
											.add(Restrictions.eq("FYear.Id", fYear)).add(Restrictions.eq("Hospital.Id", locationId)).list();
			
			if (existingAccountSubGroupList.size() > 0) {
				message = "Record already Exist";
			} else {
				FaMasAccountSubGroup faMasAccountSubGroup =(FaMasAccountSubGroup)hbt.load(FaMasAccountSubGroup.class, subGroupId);
				faMasAccountSubGroup.setAccountSubGroupCode(accountSubGroupCode);
				faMasAccountSubGroup.setAccountSubGroupName(accounSubGroupName);
				FaMasAccountGroup accountGroup = new FaMasAccountGroup();
				accountGroup.setId(groupId);
				faMasAccountSubGroup.setAccountGroup(accountGroup);
				 Users user = new Users();
				 user.setId(changedBy);
				 faMasAccountSubGroup.setLastChgBy(user);
				 faMasAccountSubGroup.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
				 faMasAccountSubGroup.setLastChgTime(time);
				 faMasAccountSubGroup.setStatus("y");
				 hbt.update(faMasAccountSubGroup);
				message = "Record update successfully!";

			}
			accountSubGrpList = session.createCriteria(FaMasAccountSubGroup.class).createAlias("FYear", "fy")
			.add(Restrictions.eq("fy.Id", fYear)).add(Restrictions.eq("Hospital.Id", locationId)).list();
			accountGroupList = session.createCriteria(FaMasAccountGroup.class).add(Restrictions.eq("Status", "y"))
							.add(Restrictions.eq("FYear.Id", fYear)).add(Restrictions.eq("Hospital.Id", locationId)).list();
			
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("message", message);
		map.put("accountGroupList", accountGroupList);
		map.put("accountSubGrpList", accountSubGrpList);
		return map;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> editAccountSubGroup(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccountSubGroup> accountSubGrpList = new ArrayList<FaMasAccountSubGroup>();
		List<FaMasAccountGroup> accountGroupList = new ArrayList<FaMasAccountGroup>();
		Session session = (Session)getSession();
		int fYear = 0; 
		if(generalMap.get("fYear") != null){
			fYear = (Integer)generalMap.get("fYear");
		}
		int accountSubGroupId = 0;
		if(generalMap.get("accountSubGroupId") != null){
			accountSubGroupId = (Integer)generalMap.get("accountSubGroupId");
		}
		int locationId = 0;
		if(generalMap.get("locationId") != null){
			locationId = (Integer)generalMap.get("locationId");
		}
		List<FaMasAccountSubGroup> accountSubGroupIdList = session.createCriteria(FaMasAccountSubGroup.class).add(Restrictions.idEq(accountSubGroupId)).list();
		accountSubGrpList = session.createCriteria(FaMasAccountSubGroup.class).createAlias("FYear", "fy")
									.add(Restrictions.eq("fy.Id", fYear)).add(Restrictions.eq("Hospital.Id",locationId)).list();
		accountGroupList = session.createCriteria(FaMasAccountGroup.class).add(Restrictions.eq("Status", "y"))
								.add(Restrictions.eq("FYear.Id", fYear)).add(Restrictions.eq("Hospital.Id",locationId)).list();
		map.put("accountGroupList", accountGroupList);
		map.put("accountSubGrpList", accountSubGrpList);
		map.put("accountSubGroupIdList", accountSubGroupIdList);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> showAccountSubGroupBalance(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasFinancialYear> financialYearList = new ArrayList<HrMasFinancialYear>();
		List<Object[]> accountSubGrpList = new ArrayList<Object[]>();
		
		int branchId = 0;
		if(generalMap.get("branchId")!= null){
			branchId = (Integer)generalMap.get("branchId");
		}
		Session session = (Session)getSession();
		String currentDate = HMSUtil.convertDateToStringTypeDate(new Date());
		financialYearList = session.createCriteria(HrMasFinancialYear.class).add(Restrictions.le("YearFromDate", HMSUtil.dateFormatterDDMMYYYY(currentDate)))
							.add(Restrictions.ge("YearToDate", HMSUtil.dateFormatterDDMMYYYY(currentDate)))
								.add(Restrictions.eq("Status", "y"))
									.list();
		int fYear = 0;
		if(financialYearList.size()>0){
			for(HrMasFinancialYear financialYear : financialYearList){
				fYear = financialYear.getId();
			}
		}
		String qry = "select ma.account_sub_group_id,ma.account_sub_group_code,ma.account_sub_group_name," +
						" sum(isnull(v.dr_amount,0))as dr_amount ,sum(isnull(v.cr_amount,0))as cr_amount, " +
						" sum(isnull(v.opening_amt_cr,0))as opening_amt_cr,sum(isnull(v.opening_amt_dr,0))as opening_amt_dr," +
						" (sum(isnull(v.dr_amount,0))+ sum(isnull(v.opening_amt_dr,0)))as TotalDr," +
						" (sum(isnull(v.cr_amount,0)) +  sum(isnull(v.opening_amt_cr,0))) as TotalCR, " +
						" DrBalance=case  when (sum(isnull(v.dr_amount,0))+ sum(isnull(v.opening_amt_dr,0))) " +
						" > (sum(isnull(v.cr_amount,0)) +  sum(isnull(v.opening_amt_cr,0)))  then (sum(isnull(v.dr_amount,0))+ sum(isnull(v.opening_amt_dr,0))) " +
						" - (sum(isnull(v.cr_amount,0)) +  sum(isnull(v.opening_amt_cr,0))) end, " +
						" CrBalance=case when (sum(isnull(v.cr_amount,0)) +  sum(isnull(v.opening_amt_cr,0))) > " +
						" (sum(isnull(v.dr_amount,0))+ sum(isnull(v.opening_amt_dr,0))) then (sum(isnull(v.cr_amount,0)) +  sum(isnull(v.opening_amt_cr,0))) " +
						" - (sum(isnull(v.dr_amount,0))+ sum(isnull(v.opening_amt_dr,0))) " +
						" else 0 end, v.branch_id,v.f_year_id  from vwFinalAccountsBalance v " +
						" right outer join fa_mas_account_sub_group ma on v.account_sub_group_id= ma.account_sub_group_id  " +
						" where v.branch_id = "+branchId+" and v.f_year_id = "+fYear+" group by ma.account_sub_group_id,ma.account_sub_group_code,ma.account_sub_group_name " +
						" ,v.branch_id,v.f_year_id";
		accountSubGrpList =session.createSQLQuery(qry).list();
		
		/*Criteria crit = null;

		crit = session.createCriteria(FaMasAccountSubGroup.class);
								
		if(accountId != 0){
			crit = crit.createAlias("AccountGroup", "group").add(Restrictions.eq("group.Id", accountId));
		}
		accountSubGrpList = crit.list();*/
		map.put("accountSubGrpList", accountSubGrpList);
		return map;
	}

	

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchAccountSubGroup(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccountSubGroup> accountSubGrpList = new ArrayList<FaMasAccountSubGroup>();
		//List<HrMasFinancialYear> financialYearList = new ArrayList<HrMasFinancialYear>();
		Session session = getSession();
		int searchRadio = 0;
		String searchField = "";
		Criteria crit = null;
		searchField = box.getString(SEARCH_FIELD);
		searchRadio = box.getInt(SELECTED_RADIO);
		
		/*int fYear = 0;
		if(generalMap.get("fYear")!= null){
			fYear = (Integer)generalMap.get("fYear");
		}*/
		/*String currentDate = HMSUtil.convertDateToStringTypeDate(new Date());
		String currentYear = currentDate.substring(6, 10);
		financialYearList = session.createCriteria(HrMasFinancialYear.class).add(Restrictions.eq("YearDescription", currentYear))
						.add(Restrictions.eq("Status", "y"))
						.list();*/
		/*int fYear = 0;
		if(financialYearList.size()>0){
			for(HrMasFinancialYear financialYear : financialYearList){
				fYear = financialYear.getId();
			}
		}*/
		crit = session.createCriteria(FaMasAccountSubGroup.class);
					
		if (searchRadio == 1) {
			crit = crit.add(Restrictions.eq("AccountSubGroupCode", Integer.parseInt(searchField)));

		} else {
			crit = crit.add(Restrictions.like("AccountSubGroupName", searchField+"%"));
		}

		accountSubGrpList = crit.list();
		map.put("accountSubGrpList", accountSubGrpList);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> showAccountSubLedgerBalance(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> subLedgerBalanceList = new ArrayList<Object[]>();
		List<HrMasFinancialYear> financialYearList = new ArrayList<HrMasFinancialYear>();
		Session session = (Session)getSession();
		int branchId = 0;
		if(generalMap.get("branchId")!= null){
			branchId = (Integer)generalMap.get("branchId");
		}
		String currentDate = HMSUtil.convertDateToStringTypeDate(new Date());
		financialYearList = session.createCriteria(HrMasFinancialYear.class).add(Restrictions.le("YearFromDate", HMSUtil.dateFormatterDDMMYYYY(currentDate)))
							.add(Restrictions.ge("YearToDate", HMSUtil.dateFormatterDDMMYYYY(currentDate)))
								.add(Restrictions.eq("Status", "y"))
									.list();
		int fYear = 0;
		if(financialYearList.size()>0){
			for(HrMasFinancialYear financialYear : financialYearList){
				fYear = financialYear.getId();
			}
		}
		String qry = "select ma.sub_led_id,ma.sub_led_code,ma.sub_led_desc," +
				" sum(isnull(v.dr_amount,0))as dr_amount ,sum(isnull(v.cr_amount,0))as cr_amount, " +
				" sum(isnull(v.opening_amt_cr,0))as opening_amt_cr,sum(isnull(v.opening_amt_dr,0))as opening_amt_dr," +
				" (sum(isnull(v.dr_amount,0))+ sum(isnull(v.opening_amt_dr,0)))as TotalDr, " +
				" (sum(isnull(v.cr_amount,0)) +  sum(isnull(v.opening_amt_cr,0))) as TotalCR," +
				" DrBalance=case when (sum(isnull(v.dr_amount,0))+ sum(isnull(v.opening_amt_dr,0))) " +
				" > (sum(isnull(v.cr_amount,0)) +  sum(isnull(v.opening_amt_cr,0))) " +
				" then (sum(isnull(v.dr_amount,0))+ sum(isnull(v.opening_amt_dr,0))) " +
				" - (sum(isnull(v.cr_amount,0)) +  sum(isnull(v.opening_amt_cr,0))) " +
				" end, CrBalance=case when (sum(isnull(v.cr_amount,0)) +  sum(isnull(v.opening_amt_cr,0))) " +
				" > (sum(isnull(v.dr_amount,0))+ sum(isnull(v.opening_amt_dr,0))) " +
				" then (sum(isnull(v.cr_amount,0)) +  sum(isnull(v.opening_amt_cr,0))) - " +
				" (sum(isnull(v.dr_amount,0))+ sum(isnull(v.opening_amt_dr,0))) else 0 " +
				" end, v.branch_id,v.f_year_id from vwFinalAccountsBalance v right outer join fa_mas_sub_led ma on " +
				" v.sub_led_id= ma.sub_led_id where v.branch_id = "+branchId+" and v.f_year_id = "+fYear+"  group by ma.sub_led_id,ma.sub_led_code,ma.sub_led_desc " +
				" ,v.branch_id,v.f_year_id";
		subLedgerBalanceList =session.createSQLQuery(qry).list();
		map.put("subLedgerBalanceList", subLedgerBalanceList);
		return map;
	}


	@SuppressWarnings("unchecked")
	public Map<String, Object> showAccountSubLedgerJsp(Map<String, Object> detailsMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasSubLed> subLedList = new ArrayList<FaMasSubLed>();
		List<FaMasAccountGroup> accGrpList = new ArrayList<FaMasAccountGroup>();
		List<FaMasAccountGroup> gridAccGrpList = new ArrayList<FaMasAccountGroup>();
		List<FaMasAccountSubGroup> subAccGrpList = new ArrayList<FaMasAccountSubGroup>();
		List<FaMasAccountSubGroup> gridSubAccGrpList = new ArrayList<FaMasAccountSubGroup>();
		List<FaMasAccount> accList = new ArrayList<FaMasAccount>();
		List<FaMasAccount> gridaccList = new ArrayList<FaMasAccount>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		/*List<MasRsk> masRskList = new ArrayList<MasRsk>();*/
		Session session = (Session)getSession();
		int fYear = 0;
		if(detailsMap.get("fYear") != null){
			fYear = (Integer)detailsMap.get("fYear");
		}
		int locationId = 0;
		if(detailsMap.get("locationId") != null){
			locationId = (Integer)detailsMap.get("locationId");
		}
		Criteria cr = null;
		try{
			if(locationId==1){
				 cr = session.createCriteria(FaMasSubLed.class)
//						.add(Restrictions.eq("Status", "y"))
						;
			}else{
				 cr = session.createCriteria(FaMasSubLed.class)
						.add(Restrictions.eq("Hospital.Id", locationId));
			}
			
		/*	if(detailsMap.get("flag") != null && detailsMap.get("flag").toString().equals("grower")){
			
				cr = cr.createAlias("Grower", "g");
				cr = cr.add(Restrictions.isNotNull("g.Id"));
			}
			
			else if(detailsMap.get("flag") != null && detailsMap.get("flag").toString().equals("rsk")){
            	
				
				cr = cr.createAlias("Rsk", "r");
				cr = cr.add(Restrictions.isNotNull("r.Id"));
			}
			else 
			{
			
				cr = cr.add(Restrictions.and(Restrictions.isNull("Grower.Id"), Restrictions.isNull("Rsk.Id")));
			}*/
			subLedList= cr.list();

			accGrpList =session.createCriteria(FaMasAccountGroup.class).createAlias("FYear", "fy")
							.add(Restrictions.eq("fy.Id", fYear))/*.add(Restrictions.eq("Hospital.Id", locationId))*/.list();
			gridAccGrpList=session.createCriteria(FaMasAccountGroup.class).createAlias("FYear", "fy")
					.add(Restrictions.eq("fy.Id", fYear))/*.add(Restrictions.eq("Hospital.Id", locationId))*/.list();

			subAccGrpList =session.createCriteria(FaMasAccountSubGroup.class).createAlias("FYear", "fy")
							.add(Restrictions.eq("fy.Id", fYear))/*.add(Restrictions.eq("Hospital.Id", locationId))*/.list();
			gridSubAccGrpList=session.createCriteria(FaMasAccountSubGroup.class).createAlias("FYear", "fy")
					.add(Restrictions.eq("fy.Id", fYear))/*.add(Restrictions.eq("Hospital.Id", locationId))*/.list();
			accList =session.createCriteria(FaMasAccount.class).createAlias("FYear", "fy").addOrder(Order.asc("AccDesc"))
							/*.add(Restrictions.eq("fy.Id", fYear))*//*.add(Restrictions.eq("Hospital.Id", locationId))*/
							.add(Restrictions.eq("SubLedger", "y")).list();
			gridaccList=session.createCriteria(FaMasAccount.class).createAlias("FYear", "fy")
					.add(Restrictions.eq("fy.Id", fYear))/*.add(Restrictions.eq("Hospital.Id", locationId))*/
					.add(Restrictions.eq("SubLedger", "y")).list();
			hospitalList=session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
			
			/*masRskList=session.createCriteria(MasRsk.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();*/
			
			map.put("subLedList", subLedList);
			map.put("accGrpList", accGrpList);
			map.put("subAccGrpList", subAccGrpList);
			map.put("gridAccGrpList",gridAccGrpList);
			map.put("gridSubAccGrpList",gridSubAccGrpList);
			map.put("gridaccList",gridaccList);
			map.put("accList", accList);
			map.put("hospitalList", hospitalList);
			/*map.put("masRskList", masRskList);*/
		}catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> addAccountSubLedger(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccountGroup> accGrpList = new ArrayList<FaMasAccountGroup>();
		List<FaMasAccountSubGroup> subAccGrpList = new ArrayList<FaMasAccountSubGroup>();
		List<FaMasSubLed> subLedList = new ArrayList<FaMasSubLed>();
		List<FaMasAccount> accList = new ArrayList<FaMasAccount>();
		List<FaMasAccount> gridaccList = new ArrayList<FaMasAccount>();		
		List<FaMasSubLed> existingAccountList = new ArrayList<FaMasSubLed>();
		List<Integer> subCodeList = new ArrayList<Integer>();
		List<FaMasSubLed> maxIdList = new ArrayList<FaMasSubLed>();
		Session session = (Session) getSession();
		FaMasSubLed faMasSubLed = new FaMasSubLed();
		if(generalMap.get("faMasSubLed")!= null){
			faMasSubLed = (FaMasSubLed)generalMap.get("faMasSubLed");
		}
		int locationId = 0;
		if(generalMap.get("locationId")!= null){
			locationId = (Integer)generalMap.get("locationId");
		}
		String message = "";
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		int fYear = 0;
		try {
			Box box =null;
			if(generalMap.get("box")!= null){
				box = (Box)generalMap.get("box");
			}
			String subLedgerName = faMasSubLed.getSubLedDesc();
			int accountMasterId = (Integer)generalMap.get("accountMasterId");
			fYear = faMasSubLed.getFYear().getId();
			existingAccountList = session.createCriteria(FaMasSubLed.class).add(Restrictions.eq("Account.Id", accountMasterId)).add(Restrictions.eq("SubLedDesc", subLedgerName))
										.add(Restrictions.eq("Hospital.Id", locationId)).add(Restrictions.eq("FYear.Id",fYear)).list();
			if (existingAccountList.size() > 0) {
				message = "Record already Exist";
			} else {
				
				
				
				
				/*
			String subLedgerCode = "";
			String subledgerletter = subLedgerName.substring(0, 1);
			subCodeList = session.createCriteria(FaMasSubLed.class).add(Restrictions.like("SubLedDesc", subledgerletter+"%")).setProjection(Projections.max("Id")).list();
			if(subCodeList.size() > 0 && subCodeList.get(0)!= null){
				int maxSubLedId = subCodeList.get(0);
					maxIdList = session.createCriteria(FaMasSubLed.class).add(Restrictions.idEq(maxSubLedId)).list();
				}
			if(maxIdList.size()>0){
				FaMasSubLed masSubLed =  maxIdList.get(0);
				String maxSubCode = masSubLed.getSubLedCode();
				String maxSubledgerCode = maxSubCode.substring(1);
				Integer intSubCode = Integer.parseInt(maxSubledgerCode)+1;
				 subLedgerCode = subledgerletter+""+(intSubCode).toString();
			}else{
				subLedgerCode = subledgerletter+""+1;
			}
			//faMasSubLed.setSubLedCode(subLedgerCode);
			
			int groupId = (Integer)generalMap.get("accountgroupId");
			int subGroupId = (Integer)generalMap.get("accountSubGroupId");
			

//-----------------------For Branch Account master------------------------------------------
			//-----------commented by anamika on 10/08/2014
			int count = 0;
			if(box.getInt("totalBranchId")!= 0){
				count = box.getInt("totalBranchId");
			}
			for (int i = 1; i <= count; i++) {
				FaBranchAccountMaster branchAccountMaster = new FaBranchAccountMaster();
				if(box.getInt("branchId"+i)!=0 ){
					MasBranch masBranch = new MasBranch();
					masBranch.setId(box.getInt("branchId"+i));
					branchAccountMaster.setBranch(masBranch);
					FaMasAccount faMasAccount = new FaMasAccount();
					faMasAccount.setId(accountMasterId);
					branchAccountMaster.setAccount(faMasAccount);
					branchAccountMaster.setSubLedger(faMasSubLed);

					if(!box.getString("opBalanceDr"+i).equals("") ){
						branchAccountMaster.setOpBalanceDr(new BigDecimal(box.getString("opBalanceDr"+i)));
						branchAccountMaster.setClBalanceDr(new BigDecimal(box.getString("opBalanceDr"+i)));
					}else if(!box.getString("opBalanceCr"+i).equals("")){
						branchAccountMaster.setOpBalanceCr(new BigDecimal(box.getString("opBalanceCr"+i)));
						branchAccountMaster.setClBalanceCr(new BigDecimal(box.getString("opBalanceCr"+i)));
					}
					hbt.save(branchAccountMaster);

				}
			}

			BigDecimal openingBalanceDr = new BigDecimal(0.0);
			BigDecimal openingBalanceCr = new BigDecimal(0.0);
			if(generalMap.get("opDrBalance")!= null){
				openingBalanceDr =(BigDecimal)generalMap.get("opDrBalance");
			}else if(generalMap.get("opCrBalance")!= null){
				openingBalanceCr =(BigDecimal)generalMap.get("opCrBalance");
			}
			
//----------------update account group--------------
			BigDecimal groupClBalanceDr = new BigDecimal(0.0);
			BigDecimal groupClBalanceCr = new BigDecimal(0.0);
			FaMasAccountGroup faMasAccountGroup = (FaMasAccountGroup)hbt.load(FaMasAccountGroup.class, groupId);
			if( faMasAccountGroup.getClBalanceDr() != null)
				groupClBalanceDr =  faMasAccountGroup.getClBalanceDr();
			if(faMasAccountGroup.getClBalanceCr() != null)
				groupClBalanceCr = faMasAccountGroup.getClBalanceCr();

				 if(openingBalanceDr.compareTo(new BigDecimal(0))>0){
					 if(groupClBalanceCr.compareTo(new BigDecimal(0)) > 0){
					 	 if(groupClBalanceCr.compareTo(openingBalanceDr) > 0 ){
							  groupClBalanceCr = groupClBalanceCr.subtract(openingBalanceDr);
							  faMasAccountGroup.setClBalanceCr(groupClBalanceCr);
							  faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
					 	 }else if(openingBalanceDr.compareTo(groupClBalanceCr) > 0 ){
					 		 groupClBalanceDr =openingBalanceDr.subtract(groupClBalanceCr);
					 		 faMasAccountGroup.setClBalanceDr(groupClBalanceDr);
					 		 faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
					 	 }else if(openingBalanceDr.compareTo(groupClBalanceCr)== 0 ){
					 		 faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
					 		 faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
					 	 }
					 }else {
							  groupClBalanceDr = groupClBalanceDr.add(openingBalanceDr);
							  faMasAccountGroup.setClBalanceDr(groupClBalanceDr);
						  }

				}else if(openingBalanceCr.compareTo(new BigDecimal(0))>0){
					if(groupClBalanceDr.compareTo(new BigDecimal(0)) > 0){
					  if(groupClBalanceDr.compareTo(openingBalanceCr) > 0){
						  groupClBalanceDr =groupClBalanceDr.subtract(openingBalanceCr);
						  faMasAccountGroup.setClBalanceDr(groupClBalanceDr);
						  faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
					  }else if(openingBalanceCr.compareTo(groupClBalanceDr) > 0 ){
					 		 groupClBalanceCr =openingBalanceCr.subtract(groupClBalanceDr);
					 		 faMasAccountGroup.setClBalanceCr(groupClBalanceCr);
					 		 faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
					 	 }else if(openingBalanceCr.compareTo(groupClBalanceDr) == 0 ){
					 		 faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
					 		 faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
					 	 }
					}else{
						  groupClBalanceCr = groupClBalanceCr.add(openingBalanceCr);
						  faMasAccountGroup.setClBalanceCr(groupClBalanceCr);
					  }
				}
//---------------------------------------update opening Balance------------------------------------------------//
				 BigDecimal groupOpBalanceDr = new BigDecimal(0.0);
					BigDecimal groupOpBalanceCr = new BigDecimal(0.0);
					if( faMasAccountGroup.getOpBalanceDr() != null)
						groupOpBalanceDr =  faMasAccountGroup.getOpBalanceDr();
					if(faMasAccountGroup.getOpBalanceCr() != null)
						groupOpBalanceCr = faMasAccountGroup.getOpBalanceCr();

						 if(openingBalanceDr.compareTo(new BigDecimal(0))>0){
							 if(groupOpBalanceCr.compareTo(new BigDecimal(0)) > 0){
							 	 if(groupOpBalanceCr.compareTo(openingBalanceDr) > 0 ){
							 		groupOpBalanceCr = groupOpBalanceCr.subtract(openingBalanceDr);
									  faMasAccountGroup.setOpBalanceCr(groupOpBalanceCr);
									  faMasAccountGroup.setOpBalanceDr(new BigDecimal(0.00));
							 	 }else if(openingBalanceDr.compareTo(groupOpBalanceCr) > 0 ){
							 		groupOpBalanceDr =openingBalanceDr.subtract(groupOpBalanceCr);
							 		 faMasAccountGroup.setOpBalanceDr(groupOpBalanceDr);
							 		 faMasAccountGroup.setOpBalanceCr(new BigDecimal(0.00));
							 	 }else if(openingBalanceDr.compareTo(groupOpBalanceCr) == 0 ){
								 		 faMasAccountGroup.setOpBalanceDr(new BigDecimal(0.00));
								 		 faMasAccountGroup.setOpBalanceCr(new BigDecimal(0.00));
								 	 }
							 }else {
								 groupOpBalanceDr = groupOpBalanceDr.add(openingBalanceDr);
									  faMasAccountGroup.setOpBalanceDr(groupOpBalanceDr);
								  }

						}else if(openingBalanceCr.compareTo(new BigDecimal(0))>0){
							if(groupOpBalanceDr.compareTo(new BigDecimal(0)) > 0){
							  if(groupOpBalanceDr.compareTo(openingBalanceCr) > 0){
								  groupOpBalanceDr =groupOpBalanceDr.subtract(openingBalanceCr);
								  faMasAccountGroup.setOpBalanceDr(groupOpBalanceDr);
								  faMasAccountGroup.setOpBalanceCr(new BigDecimal(0.00));
							  }else if(openingBalanceCr.compareTo(groupOpBalanceDr) > 0 ){
								  groupOpBalanceCr =openingBalanceCr.subtract(groupOpBalanceDr);
							 		 faMasAccountGroup.setOpBalanceCr(groupOpBalanceCr);
							 		 faMasAccountGroup.setOpBalanceDr(new BigDecimal(0.00));
							 	 }else if(openingBalanceCr.compareTo(groupOpBalanceDr) == 0 ){
								 		 faMasAccountGroup.setOpBalanceCr(new BigDecimal(0.00));
								 		 faMasAccountGroup.setOpBalanceDr(new BigDecimal(0.00));
								 	 }
							}else{
								groupOpBalanceCr = groupOpBalanceCr.add(openingBalanceCr);
								  faMasAccountGroup.setOpBalanceCr(groupOpBalanceCr);
							  }
						}
				 
				hbt.update(faMasAccountGroup);

//--------------------------------------------update subGroup group--------------
				BigDecimal subGroupClBalanceDr = new BigDecimal(0.0);
				BigDecimal subGroupClBalanceCr = new BigDecimal(0.0);
				FaMasAccountSubGroup faMasAccountSubGroup = (FaMasAccountSubGroup)hbt.load(FaMasAccountSubGroup.class, subGroupId);
				if(faMasAccountSubGroup.getClBalanceDr() != null)
					subGroupClBalanceDr =  faMasAccountSubGroup.getClBalanceDr();

				if(faMasAccountSubGroup.getClBalanceCr() != null)
					subGroupClBalanceCr = faMasAccountSubGroup.getClBalanceCr();

				if(openingBalanceDr.compareTo(new BigDecimal(0))>0){
					 if(subGroupClBalanceCr.compareTo(new BigDecimal(0)) > 0){
						 if(subGroupClBalanceCr.compareTo(openingBalanceDr) > 0){
					 		 subGroupClBalanceDr = subGroupClBalanceCr.subtract(openingBalanceDr);
					 		 faMasAccountSubGroup.setClBalanceCr(subGroupClBalanceDr);
					 		 faMasAccountSubGroup.setClBalanceDr(new BigDecimal(0.00));
					 	 }else if(openingBalanceDr.compareTo(subGroupClBalanceCr) > 0 ){
					 		subGroupClBalanceDr =openingBalanceDr.subtract(subGroupClBalanceCr);
					 		faMasAccountSubGroup.setClBalanceDr(subGroupClBalanceDr);
					 		faMasAccountSubGroup.setClBalanceCr(new BigDecimal(0.00));
					 	 }else if(openingBalanceDr.compareTo(subGroupClBalanceCr)== 0 ){
						 		faMasAccountSubGroup.setClBalanceDr(new BigDecimal(0.00));
						 		faMasAccountSubGroup.setClBalanceCr(new BigDecimal(0.00));
						 	 }
					 }else{

						  subGroupClBalanceDr = subGroupClBalanceDr.add(openingBalanceDr);
						  faMasAccountSubGroup.setClBalanceDr(subGroupClBalanceDr);
					  }
				}else if(openingBalanceCr.compareTo(new BigDecimal(0))>0){
					 if(subGroupClBalanceDr.compareTo(new BigDecimal(0)) > 0){
						 if(subGroupClBalanceDr.compareTo(openingBalanceCr) > 0){

							  subGroupClBalanceCr = subGroupClBalanceDr.subtract(openingBalanceCr);
							  faMasAccountSubGroup.setClBalanceDr(subGroupClBalanceCr);
							  faMasAccountSubGroup.setClBalanceCr(new BigDecimal(0.00));
						  }else if(openingBalanceCr.compareTo(subGroupClBalanceDr) > 0 ){
							  	subGroupClBalanceCr =openingBalanceCr.subtract(subGroupClBalanceDr);
							  	faMasAccountSubGroup.setClBalanceCr(subGroupClBalanceCr);
							  	faMasAccountSubGroup.setClBalanceDr(new BigDecimal(0.00));
						 	 }else if(openingBalanceCr.compareTo(subGroupClBalanceDr) == 0 ){
								  	faMasAccountSubGroup.setClBalanceCr(new BigDecimal(0.00));
								  	faMasAccountSubGroup.setClBalanceDr(new BigDecimal(0.00));
							 	 }
					 }
					 else{
						  subGroupClBalanceCr = subGroupClBalanceCr.add(openingBalanceCr);
						  faMasAccountSubGroup.setClBalanceCr(subGroupClBalanceCr);
					  }
				}
//-------------------------------------------update sub group opening Balance------------------------------------//
				BigDecimal subGroupOpBalanceDr = new BigDecimal(0.0);
				BigDecimal subGroupOpBalanceCr = new BigDecimal(0.0);
				if(faMasAccountSubGroup.getOpBalanceDr() != null)
					subGroupOpBalanceDr =  faMasAccountSubGroup.getOpBalanceDr();

				if(faMasAccountSubGroup.getOpBalanceCr() != null)
					subGroupOpBalanceCr = faMasAccountSubGroup.getOpBalanceCr();

				if(openingBalanceDr.compareTo(new BigDecimal(0))>0){
					 if(subGroupOpBalanceCr.compareTo(new BigDecimal(0)) > 0){
						 if(subGroupOpBalanceCr.compareTo(openingBalanceDr) > 0){
							 subGroupOpBalanceDr = subGroupOpBalanceCr.subtract(openingBalanceDr);
					 		 faMasAccountSubGroup.setOpBalanceCr(subGroupOpBalanceDr);
					 		 faMasAccountSubGroup.setOpBalanceDr(new BigDecimal(0.00));
					 	 }else if(openingBalanceDr.compareTo(subGroupOpBalanceCr) > 0 ){
					 		subGroupOpBalanceDr =openingBalanceDr.subtract(subGroupOpBalanceCr);
					 		faMasAccountSubGroup.setOpBalanceDr(subGroupOpBalanceDr);
					 		faMasAccountSubGroup.setOpBalanceCr(new BigDecimal(0.00));
					 	 }else if(openingBalanceDr.compareTo(subGroupOpBalanceCr) == 0 ){
						 		faMasAccountSubGroup.setOpBalanceDr(new BigDecimal(0.00));
						 		faMasAccountSubGroup.setOpBalanceCr(new BigDecimal(0.00));
						 	 }
					 }else{

						 subGroupOpBalanceDr = subGroupOpBalanceDr.add(openingBalanceDr);
						  faMasAccountSubGroup.setOpBalanceDr(subGroupOpBalanceDr);
					  }
				}else if(openingBalanceCr.compareTo(new BigDecimal(0))>0){
					 if(subGroupOpBalanceDr.compareTo(new BigDecimal(0)) > 0){
						 if(subGroupOpBalanceDr.compareTo(openingBalanceCr) > 0){

							 subGroupOpBalanceCr = subGroupOpBalanceDr.subtract(openingBalanceCr);
							  faMasAccountSubGroup.setOpBalanceDr(subGroupOpBalanceCr);
							  faMasAccountSubGroup.setOpBalanceCr(new BigDecimal(0.00));
						  }else if(openingBalanceCr.compareTo(subGroupOpBalanceDr) > 0 ){
							  subGroupOpBalanceCr =openingBalanceCr.subtract(subGroupOpBalanceDr);
							  	faMasAccountSubGroup.setOpBalanceCr(subGroupOpBalanceCr);
							  	faMasAccountSubGroup.setOpBalanceDr(new BigDecimal(0.00));
						 	 }else if(openingBalanceCr.compareTo(subGroupOpBalanceDr)== 0 ){
								  	faMasAccountSubGroup.setOpBalanceCr(new BigDecimal(0.00));
								  	faMasAccountSubGroup.setOpBalanceDr(new BigDecimal(0.00));
							 	 }
					 }
					 else{
						 subGroupOpBalanceCr = subGroupOpBalanceCr.add(openingBalanceCr);
						  faMasAccountSubGroup.setOpBalanceCr(subGroupOpBalanceCr);
					  }
				}
				hbt.update(faMasAccountSubGroup);


//--------------------------------------------update accountMaster--------------
				BigDecimal accountClBalanceDr = new BigDecimal(0.0);
				BigDecimal accountBalanceCr = new BigDecimal(0.0);

				FaMasAccount faMasAccount = (FaMasAccount)hbt.load(FaMasAccount.class, accountMasterId);
				if(faMasAccount.getClBalanceDr() != null)
					accountClBalanceDr =  faMasAccount.getClBalanceDr();
				if(faMasAccount.getClBalanceCr() != null)
					accountBalanceCr = faMasAccount.getClBalanceCr();

				if(openingBalanceDr.compareTo(new BigDecimal(0))>0){
					 if(accountBalanceCr.compareTo(new BigDecimal(0)) > 0){
						 if(accountBalanceCr.compareTo(openingBalanceDr) > 0){
					 		 accountClBalanceDr = accountBalanceCr.subtract(openingBalanceDr);
					 		 faMasAccount.setClBalanceCr(accountClBalanceDr);
					 		 faMasAccount.setClBalanceDr(new BigDecimal(0.00));
					 	 }else if(openingBalanceDr.compareTo(accountBalanceCr) > 0 ){
					 		accountClBalanceDr =openingBalanceDr.subtract(accountBalanceCr);
					 		faMasAccount.setClBalanceDr(accountClBalanceDr);
					 		faMasAccount.setClBalanceCr(new BigDecimal(0.00));
					 	 }else if(openingBalanceDr.compareTo(accountBalanceCr) == 0 ){
						 		faMasAccount.setClBalanceDr(new BigDecimal(0.00));
						 		faMasAccount.setClBalanceCr(new BigDecimal(0.00));
						 	 }
					 }else{

						  accountClBalanceDr = accountClBalanceDr.add(openingBalanceDr);
						  faMasAccount.setClBalanceDr(accountClBalanceDr);
					  }
				}else if(openingBalanceCr.compareTo(new BigDecimal(0))>0){
					 if(accountClBalanceDr.compareTo(new BigDecimal(0)) > 0){
						 if(accountClBalanceDr.compareTo(openingBalanceCr) > 0){

							  accountBalanceCr = accountClBalanceDr.subtract(openingBalanceCr);
							  faMasAccount.setClBalanceDr(accountBalanceCr);
							  faMasAccount.setClBalanceCr(new BigDecimal(0.00));
						  }else if(openingBalanceCr.compareTo(accountClBalanceDr) > 0 ){
							  	accountBalanceCr =openingBalanceCr.subtract(accountClBalanceDr);
							  	faMasAccount.setClBalanceCr(accountBalanceCr);
							  	faMasAccount.setClBalanceDr(new BigDecimal(0.00));
						 	 }else if(openingBalanceCr.compareTo(accountClBalanceDr) == 0 ){
								  	faMasAccount.setClBalanceCr(new BigDecimal(0.00));
								  	faMasAccount.setClBalanceDr(new BigDecimal(0.00));
							 	 }
					 }
					 else{
						  accountBalanceCr = accountBalanceCr.add(openingBalanceCr);
						  faMasAccount.setClBalanceCr(accountBalanceCr);
					  }
				}
//-------------------------------update account opening Balance-----------------------------------------------//
				BigDecimal accountOpBalanceDr = new BigDecimal(0.0);
				BigDecimal accountOpBalanceCr = new BigDecimal(0.0);

				if(faMasAccount.getOpBalanceDr() != null)
					accountOpBalanceDr =  faMasAccount.getOpBalanceDr();
				if(faMasAccount.getOpBalanceCr() != null)
					accountOpBalanceCr = faMasAccount.getOpBalanceCr();

				if(openingBalanceDr.compareTo(new BigDecimal(0))>0){
					 if(accountOpBalanceCr.compareTo(new BigDecimal(0)) > 0){
						 if(accountOpBalanceCr.compareTo(openingBalanceDr) > 0){
							 accountOpBalanceDr = accountOpBalanceCr.subtract(openingBalanceDr);
					 		 faMasAccount.setOpBalanceCr(accountOpBalanceDr);
					 		 faMasAccount.setOpBalanceDr(new BigDecimal(0.00));
					 	 }else if(openingBalanceDr.compareTo(accountOpBalanceCr) > 0 ){
					 		accountOpBalanceDr =openingBalanceDr.subtract(accountOpBalanceCr);
					 		faMasAccount.setOpBalanceDr(accountOpBalanceDr);
					 		faMasAccount.setOpBalanceCr(new BigDecimal(0.00));
					 	 }else if(openingBalanceDr.compareTo(accountOpBalanceCr) == 0 ){
						 		faMasAccount.setOpBalanceDr(new BigDecimal(0.00));
						 		faMasAccount.setOpBalanceCr(new BigDecimal(0.00));
						 	 }
					 }else{

						 accountOpBalanceDr = accountOpBalanceDr.add(openingBalanceDr);
						  faMasAccount.setOpBalanceDr(accountOpBalanceDr);
					  }
				}else if(openingBalanceCr.compareTo(new BigDecimal(0))>0){
					 if(accountOpBalanceDr.compareTo(new BigDecimal(0)) > 0){
						 if(accountOpBalanceDr.compareTo(openingBalanceCr) > 0){

							 accountOpBalanceCr = accountOpBalanceDr.subtract(openingBalanceCr);
							  faMasAccount.setOpBalanceDr(accountOpBalanceCr);
							  faMasAccount.setOpBalanceCr(new BigDecimal(0.00));
						  }else if(openingBalanceCr.compareTo(accountOpBalanceDr) > 0 ){
							  accountOpBalanceCr =openingBalanceCr.subtract(accountOpBalanceDr);
							  	faMasAccount.setOpBalanceCr(accountOpBalanceCr);
							  	faMasAccount.setOpBalanceDr(new BigDecimal(0.00));
						 	 }else if(openingBalanceCr.compareTo(accountOpBalanceDr) == 0 ){
								  	faMasAccount.setOpBalanceCr(new BigDecimal(0.00));
								  	faMasAccount.setOpBalanceDr(new BigDecimal(0.00));
							 	 }
					 }
					 else{
						 accountOpBalanceCr = accountOpBalanceCr.add(openingBalanceCr);
						  faMasAccount.setOpBalanceCr(accountOpBalanceCr);
					  }
				}
			 	hbt.update(faMasAccount);
			*/			
				hbt.save(faMasSubLed);
				hbt.refresh(faMasSubLed);
				message = "Record saved successfully!";
}
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//--------------------------------------------------------------------------		 	
		 	
	 	accGrpList =session.createCriteria(FaMasAccountGroup.class).list();

	 	subAccGrpList =session.createCriteria(FaMasAccountSubGroup.class).list();
		subLedList = session.createCriteria(FaMasSubLed.class)
							
							.add(Restrictions.eq("Hospital.Id", locationId))
							.list();
		accList =session.createCriteria(FaMasAccount.class).add(Restrictions.eq("Hospital.Id", locationId)).list();						
						
		gridaccList=session.createCriteria(FaMasAccount.class)				
				.list();
		map.put("subLedList", subLedList);		
		map.put("accGrpList", accGrpList);
		map.put("subAccGrpList", subAccGrpList);
		map.put("accList", accList);
		map.put("gridaccList",gridaccList);
		map.put("message", message);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> searchAccountSubLedger(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasSubLed> searchSubLedList = new ArrayList<FaMasSubLed>();
		List<FaMasAccountGroup> accGrpList = new ArrayList<FaMasAccountGroup>();
		List<FaMasAccountSubGroup> subAccGrpList = new ArrayList<FaMasAccountSubGroup>();
		List<FaMasSubLed> subLedList = new ArrayList<FaMasSubLed>();
		List<FaMasAccount> accList = new ArrayList<FaMasAccount>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		/*List<MasRsk> masRskList = new ArrayList<MasRsk>();*/
		Session session = getSession();
		int searchRadio = 0;
		String searchField = "";
		Criteria crit = null;
		searchField = box.getString(SEARCH_FIELD);
		searchRadio = box.getInt(SELECTED_RADIO);
		int fYear = box.getInt("fYear");
		crit = session.createCriteria(FaMasSubLed.class); 
					//.createAlias("FYear", "fy")
				//	.add(Restrictions.eq("fy.Id",box.getInt("fYear"))).add(Restrictions.eq("Hospital.Id", box.getInt("locationId")));
		if (searchRadio == 1) {
			crit = crit.add(Restrictions.eq("SubLedCode", searchField));

		} else {
			crit = crit.add(Restrictions.like("SubLedDesc", searchField+"%"));
		}
		
		
/*		if(box.get("flag") != null && box.getString("flag").trim().equals("grower")){
			
			crit = crit.createAlias("Grower", "g");
			crit = crit.add(Restrictions.isNotNull("g.Id"));
		}
		
		else if(box.get("flag") != null && box.getString("flag").trim().equals("rsk")){
        	
			
			crit = crit.createAlias("Rsk", "r");
			crit = crit.add(Restrictions.isNotNull("r.Id"));
		}
		else 
		{
			
					 crit = crit.add(Restrictions.and(Restrictions.isNull("Grower.Id"), Restrictions.isNull("Rsk.Id")));
		}
		*/

		subLedList = crit.list();
		
		accGrpList =session.createCriteria(FaMasAccountGroup.class).createAlias("FYear", "fy")
			.add(Restrictions.eq("fy.Id", fYear)).add(Restrictions.eq("Hospital.Id", box.getInt("locationId"))).list();

		subAccGrpList =session.createCriteria(FaMasAccountSubGroup.class).createAlias("FYear", "fy")
					.add(Restrictions.eq("fy.Id", fYear)).add(Restrictions.eq("Hospital.Id", box.getInt("locationId"))).list();
		//subLedList = session.createCriteria(FaMasSubLed.class).createAlias("FYear", "fy")
			//.add(Restrictions.eq("fy.Id", financialYearId)).list();
		/*accList =session.createCriteria(FaMasAccount.class).createAlias("FYear", "fy")
		.add(Restrictions.eq("fy.Id", fYear)).add(Restrictions.eq("Hospital.Id", box.getInt("locationId")))
			.list();
		*/
		accList =session.createCriteria(FaMasAccount.class).createAlias("FYear", "fy")
				/*.add(Restrictions.eq("fy.Id", fYear))*//*.add(Restrictions.eq("Hospital.Id", locationId))*/
				.add(Restrictions.eq("SubLedger", "y")).list();
		map.put("subLedList", subLedList);
		map.put("accGrpList", accGrpList);
		map.put("subAccGrpList", subAccGrpList);
		map.put("accList", accList);
		map.put("searchSubLedList", searchSubLedList);
		map.put("searchCreteria", "searchCreteria");
		List<FaMasAccount>faMasAccountList=new ArrayList<FaMasAccount>();
		faMasAccountList=session.createCriteria(FaMasAccount.class).add(Restrictions.eq("Status", "y"))
				/*.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", 1))*/
				.list();
		List<FaMasAccountGroup>faMasAccountGroupList=new ArrayList<FaMasAccountGroup>();
		faMasAccountGroupList = session.createCriteria(FaMasAccountGroup.class).add(Restrictions.eq("Status", "y"))
								/*.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", 1))*/
								.list();
		
		List<FaMasAccountGroup>gridMasAccountGroupList=new ArrayList<FaMasAccountGroup>();
			gridMasAccountGroupList=session.createCriteria(FaMasAccountGroup.class).add(Restrictions.eq("Status", "y"))
				/*.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", 1))*/
				.list();
			List<FaMasAccountSubGroup>faMasAccountSubGroupList=new ArrayList<FaMasAccountSubGroup>();

		faMasAccountSubGroupList=session.createCriteria(FaMasAccountSubGroup.class).add(Restrictions.eq("Status", "y"))
				/*.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", 1))*/
				.list();
		List<FaMasAccountSubGroup>gridMasAccountSubGroupList=new ArrayList<FaMasAccountSubGroup>();
		gridMasAccountSubGroupList=session.createCriteria(FaMasAccountSubGroup.class).add(Restrictions.eq("Status", "y"))
				/*.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", 1))*/
				.list();
		
		hospitalList=session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		
		/*masRskList=session.createCriteria(MasRsk.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();*/
		
		System.out.println("faMasAccountGroupList=====>>"+faMasAccountGroupList.size());
		map.put("faMasAccountGroupList", faMasAccountGroupList);
		map.put("faMasAccountSubGroupList",faMasAccountSubGroupList);
		map.put("gridMasAccountGroupList",gridMasAccountGroupList);
		map.put("faMasAccountList",faMasAccountList);
		map.put("gridMasAccountSubGroupList",gridMasAccountSubGroupList);
		map.put("searchField",searchField);
		map.put("hospitalList",hospitalList);
		/*map.put("masRskList",masRskList);*/
		
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> editAccountSubLedger(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccount> accList = new ArrayList<FaMasAccount>();
		List<FaMasSubLed> subLedList = new ArrayList<FaMasSubLed>();
		List<FaMasSubLed> subLedIdList = new ArrayList<FaMasSubLed>();
		List<FaMasAccountGroup> accGrpList = new ArrayList<FaMasAccountGroup>();
		List<FaMasAccountSubGroup> subAccGrpList = new ArrayList<FaMasAccountSubGroup>();
		Session session = (Session)getSession();
		subAccGrpList = session.createCriteria(FaMasAccountSubGroup.class).createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", box.getInt("fYear")))
								.add(Restrictions.eq("Hospital.Id", box.getInt("locationId"))).add(Restrictions.eq("Status", "y")).list();
		subLedList = session.createCriteria(FaMasSubLed.class).createAlias("FYear", "fy").add(Restrictions.eq("fy.Id",  box.getInt("fYear")))
								.add(Restrictions.eq("Hospital.Id", box.getInt("locationId"))).list();
		accGrpList = session.createCriteria(FaMasAccountGroup.class).createAlias("FYear", "fy").add(Restrictions.eq("fy.Id",  box.getInt("fYear")))
							.add(Restrictions.eq("Hospital.Id", box.getInt("locationId"))).add(Restrictions.eq("Status", "y")).list();
		accList =session.createCriteria(FaMasAccount.class).createAlias("FYear", "fy").add(Restrictions.eq("fy.Id",  box.getInt("fYear")))
								.add(Restrictions.eq("Hospital.Id", box.getInt("locationId"))).list();
		subLedIdList = session.createCriteria(FaMasSubLed.class).add(Restrictions.idEq(box.getInt("accountSubledgerId"))).list();
		map.put("subLedIdList", subLedIdList);
		map.put("subLedList", subLedList);
		map.put("subAccGrpList", subAccGrpList);
		map.put("accGrpList", accGrpList);
		map.put("accList", accList);
		
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> updateAccountSubLedger(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccount> accList = new ArrayList<FaMasAccount>();
		List<FaMasSubLed> subLedList = new ArrayList<FaMasSubLed>();
		List<FaMasAccountGroup> accGrpList = new ArrayList<FaMasAccountGroup>();
		List<FaMasSubLed> existingAccountList = new ArrayList<FaMasSubLed>();
		List<FaMasAccountSubGroup> subAccGrpList = new ArrayList<FaMasAccountSubGroup>();
		Session session = (Session)getSession();
		String message = "";
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		try {
			
			existingAccountList = session.createCriteria(FaMasSubLed.class).add(Restrictions.eq("Account.Id", box.getInt(ACCOUNT_ID))).add(Restrictions.eq("SubLedDesc", box.getString(SUB_LDEGER_NAME)))
									.add(Restrictions.ne("Id", box.getInt("accountSubLedgerId"))).add(Restrictions.eq("FYear.Id", box.getInt("fYear")))
										.add(Restrictions.eq("Hospital.Id", box.getInt("locationId"))).list();
			if (existingAccountList.size() > 0) {
				message = "Record already Exist";
			} else {
			FaMasSubLed faMasSubLed = (FaMasSubLed) hbt.load(FaMasSubLed.class,box.getInt("accountSubLedgerId"));
			faMasSubLed.setSubLedDesc(box.getString(SUB_LDEGER_NAME));
			MasStoreFinancial masStoreFinancial = new MasStoreFinancial();
			masStoreFinancial.setId(box.getInt("fYear"));
			
			FaMasAccount masAccount = new FaMasAccount();
			masAccount.setId(box.getInt(ACCOUNT_ID));
			faMasSubLed.setAccount(masAccount);
			BigDecimal opBalanceDr = new BigDecimal(0.0);
			BigDecimal opBalanceCr = new BigDecimal(0.0);
			if(box.getString("accountTypeA").equals("Dr")){
				if(!box.getString("openingBalance").equals("")){
					faMasSubLed.setOpBalanceDr(new BigDecimal(box.getString("openingBalance")));
					opBalanceDr = new BigDecimal(box.getString("openingBalance"));
				}
				faMasSubLed.setOpBalanceCr(new BigDecimal(0.0));
				if(!box.getString("openingBalance").equals("")){
					faMasSubLed.setClBalanceDr(new BigDecimal(box.getString("openingBalance")));
				}
				faMasSubLed.setClBalanceCr(new BigDecimal(0.0));
			}else if(box.getString("accountTypeA").equals("Cr")){
				if(!box.getString("openingBalance").equals("")){
					faMasSubLed.setOpBalanceCr(new BigDecimal(box.getString("openingBalance")));
					opBalanceCr = new BigDecimal(box.getString("openingBalance"));
				}
				if(!box.getString("openingBalance").equals("")){
					faMasSubLed.setClBalanceCr(new BigDecimal(box.getString("openingBalance")));
				}
				faMasSubLed.setOpBalanceDr(new BigDecimal(0.0));
				faMasSubLed.setClBalanceDr(new BigDecimal(0.0));
				
			}
			Users users = new Users();
			users.setId(box.getInt("changedBy"));
			faMasSubLed.setLastChgBy(users);
			
			MasHospital masHospital = new MasHospital();
			masHospital.setId(box.getInt("locationId"));
			faMasSubLed.setHospital(masHospital);
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			String date = (String) utilMap.get("currentDate");
			String time = (String) utilMap.get("currentTime");
			faMasSubLed.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
			faMasSubLed.setLastChgTime(time);
			hbt.update(faMasSubLed);
			message = "Record update successfully!";
			
//----------------------------------------------calculation for last Balance---------------------------------
			BigDecimal lastOpeningDrBalance = new BigDecimal(0.0);
			BigDecimal lastOpeningCrBalance = new BigDecimal(0.0);
			BigDecimal openingBalanceDr = new BigDecimal(0.0);
			BigDecimal openingBalanceCr = new BigDecimal(0.0);
			
			if(!box.getString("lastOpeningBalanceDr").equals("") ){
				lastOpeningDrBalance = new BigDecimal(box.getString("lastOpeningBalanceDr"));
			}else if(!box.getString("lastOpeningBalanceCr").equals("")){
				lastOpeningCrBalance = new BigDecimal(box.getString("lastOpeningBalanceCr"));
			}
			 if(opBalanceDr.compareTo(new BigDecimal(0))>0){
				 if(lastOpeningCrBalance.compareTo(new BigDecimal(0)) > 0){
				 	 if(lastOpeningCrBalance.compareTo(opBalanceDr) > 0 ){
				 		openingBalanceCr = lastOpeningCrBalance.subtract(opBalanceDr);
				 	 	}else if(opBalanceDr.compareTo(lastOpeningCrBalance) > 0 ){
				 	 		openingBalanceDr =opBalanceDr.subtract(lastOpeningCrBalance);
				 	 	}
				 	 }else if(lastOpeningDrBalance.compareTo(new BigDecimal(0)) > 0) {
				 		 if(opBalanceDr.compareTo(lastOpeningDrBalance)>0){
				 			 openingBalanceDr = opBalanceDr.subtract(lastOpeningDrBalance);
				 		 }else if(lastOpeningDrBalance.compareTo(opBalanceDr)>0){
				 			openingBalanceCr = lastOpeningDrBalance.subtract(opBalanceDr);
				 		 }
					  }
				
			 }else if(opBalanceCr.compareTo(new BigDecimal(0))>0){
					if(lastOpeningDrBalance.compareTo(new BigDecimal(0)) > 0){
					  if(lastOpeningDrBalance.compareTo(opBalanceCr) > 0){
						  openingBalanceDr =lastOpeningDrBalance.subtract(opBalanceCr);
					  	}else if(opBalanceCr.compareTo(lastOpeningDrBalance) > 0 ){
						  	openingBalanceCr =opBalanceCr.subtract(lastOpeningDrBalance);
					 	 }
					}else{
						  
						openingBalanceCr = lastOpeningCrBalance.subtract(opBalanceCr);
						if(opBalanceCr.compareTo(lastOpeningCrBalance)>0){
							openingBalanceCr = opBalanceCr.subtract(lastOpeningCrBalance);
				 		 }else if(lastOpeningCrBalance.compareTo(opBalanceCr)>0){
				 			openingBalanceDr = lastOpeningCrBalance.subtract(opBalanceCr);
				 		 }
						
				  }
			 }
			//----------------update account group--------------
				BigDecimal groupClBalanceDr = new BigDecimal(0.0);
				BigDecimal groupClBalanceCr = new BigDecimal(0.0);
				FaMasAccountGroup faMasAccountGroup = (FaMasAccountGroup)hbt.load(FaMasAccountGroup.class, box.getInt(ACCOUNT_GROUP_ID));
				if( faMasAccountGroup.getClBalanceDr() != null)
					groupClBalanceDr =  faMasAccountGroup.getClBalanceDr();
				if(faMasAccountGroup.getClBalanceCr() != null)
					groupClBalanceCr = faMasAccountGroup.getClBalanceCr();

					 if(openingBalanceDr.compareTo(new BigDecimal(0))>0){
						 if(groupClBalanceCr.compareTo(new BigDecimal(0)) > 0){
						 	 if(groupClBalanceCr.compareTo(openingBalanceDr) > 0 ){
								  groupClBalanceCr = groupClBalanceCr.subtract(openingBalanceDr);
								  faMasAccountGroup.setClBalanceCr(groupClBalanceCr);
								  faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
						 	 }else if(openingBalanceDr.compareTo(groupClBalanceCr) > 0 ){
						 		 groupClBalanceDr =openingBalanceDr.subtract(groupClBalanceCr);
						 		 faMasAccountGroup.setClBalanceDr(groupClBalanceDr);
						 		 faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
						 	 }
						 }else {
								  groupClBalanceDr = groupClBalanceDr.add(openingBalanceDr);
								  faMasAccountGroup.setClBalanceDr(groupClBalanceDr);
							  }

					}else if(openingBalanceCr.compareTo(new BigDecimal(0))>0){
						if(groupClBalanceDr.compareTo(new BigDecimal(0)) > 0){
						  if(groupClBalanceDr.compareTo(openingBalanceCr) > 0){
							  groupClBalanceDr =groupClBalanceDr.subtract(openingBalanceCr);
							  faMasAccountGroup.setClBalanceDr(groupClBalanceDr);
							  faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
						  }else if(openingBalanceCr.compareTo(groupClBalanceDr) > 0 ){
						 		 groupClBalanceCr =openingBalanceCr.subtract(groupClBalanceDr);
						 		 faMasAccountGroup.setClBalanceCr(groupClBalanceCr);
						 		 faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
						 	 }
						}else{
							  groupClBalanceCr = groupClBalanceCr.add(openingBalanceCr);
							  faMasAccountGroup.setClBalanceCr(groupClBalanceCr);
						  }
					}
	//---------------------------------------update opening Balance------------------------------------------------//
					 BigDecimal groupOpBalanceDr = new BigDecimal(0.0);
						BigDecimal groupOpBalanceCr = new BigDecimal(0.0);
						if( faMasAccountGroup.getOpBalanceDr() != null)
							groupOpBalanceDr =  faMasAccountGroup.getOpBalanceDr();
						if(faMasAccountGroup.getOpBalanceCr() != null)
							groupOpBalanceCr = faMasAccountGroup.getOpBalanceCr();

							 if(openingBalanceDr.compareTo(new BigDecimal(0))>0){
								 if(groupOpBalanceCr.compareTo(new BigDecimal(0)) > 0){
								 	 if(groupOpBalanceCr.compareTo(openingBalanceDr) > 0 ){
								 		groupOpBalanceCr = groupOpBalanceCr.subtract(openingBalanceDr);
										  faMasAccountGroup.setOpBalanceCr(groupOpBalanceCr);
										  faMasAccountGroup.setOpBalanceDr(new BigDecimal(0.00));
								 	 }else if(openingBalanceDr.compareTo(groupOpBalanceCr) > 0 ){
								 		groupOpBalanceDr =openingBalanceDr.subtract(groupOpBalanceCr);
								 		 faMasAccountGroup.setOpBalanceDr(groupOpBalanceDr);
								 		 faMasAccountGroup.setOpBalanceCr(new BigDecimal(0.00));
								 	 }
								 }else {
									 groupOpBalanceDr = groupOpBalanceDr.add(openingBalanceDr);
										  faMasAccountGroup.setOpBalanceDr(groupOpBalanceDr);
									  }

							}else if(openingBalanceCr.compareTo(new BigDecimal(0))>0){
								if(groupOpBalanceDr.compareTo(new BigDecimal(0)) > 0){
								  if(groupOpBalanceDr.compareTo(openingBalanceCr) > 0){
									  groupOpBalanceDr =groupOpBalanceDr.subtract(openingBalanceCr);
									  faMasAccountGroup.setOpBalanceDr(groupOpBalanceDr);
									  faMasAccountGroup.setOpBalanceCr(new BigDecimal(0.00));
								  }else if(openingBalanceCr.compareTo(groupOpBalanceDr) > 0 ){
									  groupOpBalanceCr =openingBalanceCr.subtract(groupOpBalanceDr);
								 		 faMasAccountGroup.setOpBalanceCr(groupOpBalanceCr);
								 		 faMasAccountGroup.setOpBalanceDr(new BigDecimal(0.00));
								 	 }
								}else{
									groupOpBalanceCr = groupOpBalanceCr.add(openingBalanceCr);
									  faMasAccountGroup.setOpBalanceCr(groupOpBalanceCr);
								  }
							}
					 
					hbt.update(faMasAccountGroup);

	//--------------------------------------------update subGroup group--------------
					BigDecimal subGroupClBalanceDr = new BigDecimal(0.0);
					BigDecimal subGroupClBalanceCr = new BigDecimal(0.0);
					FaMasAccountSubGroup faMasAccountSubGroup = (FaMasAccountSubGroup)hbt.load(FaMasAccountSubGroup.class, box.getInt(ACCOUNT_SUB_GROUP_ID));
					if(faMasAccountSubGroup.getClBalanceDr() != null)
						subGroupClBalanceDr =  faMasAccountSubGroup.getClBalanceDr();

					if(faMasAccountSubGroup.getClBalanceCr() != null)
						subGroupClBalanceCr = faMasAccountSubGroup.getClBalanceCr();

					if(openingBalanceDr.compareTo(new BigDecimal(0))>0){
						 if(subGroupClBalanceCr.compareTo(new BigDecimal(0)) > 0){
							 if(subGroupClBalanceCr.compareTo(openingBalanceDr) > 0){
						 		 subGroupClBalanceDr = subGroupClBalanceCr.subtract(openingBalanceDr);
						 		 faMasAccountSubGroup.setClBalanceCr(subGroupClBalanceDr);
						 		 faMasAccountSubGroup.setClBalanceDr(new BigDecimal(0.00));
						 	 }else if(openingBalanceDr.compareTo(subGroupClBalanceCr) > 0 ){
						 		subGroupClBalanceDr =openingBalanceDr.subtract(subGroupClBalanceCr);
						 		faMasAccountSubGroup.setClBalanceDr(subGroupClBalanceDr);
						 		faMasAccountSubGroup.setClBalanceCr(new BigDecimal(0.00));
						 	 }
						 }else{

							  subGroupClBalanceDr = subGroupClBalanceDr.add(openingBalanceDr);
							  faMasAccountSubGroup.setClBalanceDr(subGroupClBalanceDr);
						  }
					}else if(openingBalanceCr.compareTo(new BigDecimal(0))>0){
						 if(subGroupClBalanceDr.compareTo(new BigDecimal(0)) > 0){
							 if(subGroupClBalanceDr.compareTo(openingBalanceCr) > 0){

								  subGroupClBalanceCr = subGroupClBalanceDr.subtract(openingBalanceCr);
								  faMasAccountSubGroup.setClBalanceDr(subGroupClBalanceCr);
								  faMasAccountSubGroup.setClBalanceCr(new BigDecimal(0.00));
							  }else if(openingBalanceCr.compareTo(subGroupClBalanceDr) > 0 ){
								  	subGroupClBalanceCr =openingBalanceCr.subtract(subGroupClBalanceDr);
								  	faMasAccountSubGroup.setClBalanceCr(subGroupClBalanceCr);
								  	faMasAccountSubGroup.setClBalanceDr(new BigDecimal(0.00));
							 	 }
						 }
						 else{
							  subGroupClBalanceCr = subGroupClBalanceCr.add(openingBalanceCr);
							  faMasAccountSubGroup.setClBalanceCr(subGroupClBalanceCr);
						  }
					}
	//-------------------------------------------update sub group opening Balance------------------------------------//
					BigDecimal subGroupOpBalanceDr = new BigDecimal(0.0);
					BigDecimal subGroupOpBalanceCr = new BigDecimal(0.0);
					if(faMasAccountSubGroup.getOpBalanceDr() != null)
						subGroupOpBalanceDr =  faMasAccountSubGroup.getOpBalanceDr();

					if(faMasAccountSubGroup.getOpBalanceCr() != null)
						subGroupOpBalanceCr = faMasAccountSubGroup.getOpBalanceCr();

					if(openingBalanceDr.compareTo(new BigDecimal(0))>0){
						 if(subGroupOpBalanceCr.compareTo(new BigDecimal(0)) > 0){
							 if(subGroupOpBalanceCr.compareTo(openingBalanceDr) > 0){
								 subGroupOpBalanceDr = subGroupOpBalanceCr.subtract(openingBalanceDr);
						 		 faMasAccountSubGroup.setOpBalanceCr(subGroupOpBalanceDr);
						 		 faMasAccountSubGroup.setOpBalanceDr(new BigDecimal(0.00));
						 	 }else if(openingBalanceDr.compareTo(subGroupOpBalanceCr) > 0 ){
						 		subGroupOpBalanceDr =openingBalanceDr.subtract(subGroupOpBalanceCr);
						 		faMasAccountSubGroup.setOpBalanceDr(subGroupOpBalanceDr);
						 		faMasAccountSubGroup.setOpBalanceCr(new BigDecimal(0.00));
						 	 }
						 }else{

							 subGroupOpBalanceDr = subGroupOpBalanceDr.add(openingBalanceDr);
							  faMasAccountSubGroup.setOpBalanceDr(subGroupOpBalanceDr);
						  }
					}else if(openingBalanceCr.compareTo(new BigDecimal(0))>0){
						 if(subGroupOpBalanceDr.compareTo(new BigDecimal(0)) > 0){
							 if(subGroupOpBalanceDr.compareTo(openingBalanceCr) > 0){

								 subGroupOpBalanceCr = subGroupOpBalanceDr.subtract(openingBalanceCr);
								  faMasAccountSubGroup.setOpBalanceDr(subGroupOpBalanceCr);
								  faMasAccountSubGroup.setOpBalanceCr(new BigDecimal(0.00));
							  }else if(openingBalanceCr.compareTo(subGroupOpBalanceDr) > 0 ){
								  subGroupOpBalanceCr =openingBalanceCr.subtract(subGroupOpBalanceDr);
								  	faMasAccountSubGroup.setOpBalanceCr(subGroupOpBalanceCr);
								  	faMasAccountSubGroup.setOpBalanceDr(new BigDecimal(0.00));
							 	 }
						 }
						 else{
							 subGroupOpBalanceCr = subGroupOpBalanceCr.add(openingBalanceCr);
							  faMasAccountSubGroup.setOpBalanceCr(subGroupOpBalanceCr);
						  }
					}
					hbt.update(faMasAccountSubGroup);


	//--------------------------------------------update accountMaster--------------
					BigDecimal accountClBalanceDr = new BigDecimal(0.0);
					BigDecimal accountBalanceCr = new BigDecimal(0.0);

					FaMasAccount faMasAccount = (FaMasAccount)hbt.load(FaMasAccount.class, box.getInt(ACCOUNT_ID));
					if(faMasAccount.getClBalanceDr() != null)
						accountClBalanceDr =  faMasAccount.getClBalanceDr();
					if(faMasAccount.getClBalanceCr() != null)
						accountBalanceCr = faMasAccount.getClBalanceCr();

					if(openingBalanceDr.compareTo(new BigDecimal(0))>0){
						 if(accountBalanceCr.compareTo(new BigDecimal(0)) > 0){
							 if(accountBalanceCr.compareTo(openingBalanceDr) > 0){
						 		 accountClBalanceDr = accountBalanceCr.subtract(openingBalanceDr);
						 		 faMasAccount.setClBalanceCr(accountClBalanceDr);
						 		 faMasAccount.setClBalanceDr(new BigDecimal(0.00));
						 	 }else if(openingBalanceDr.compareTo(accountBalanceCr) > 0 ){
						 		accountClBalanceDr =openingBalanceDr.subtract(accountBalanceCr);
						 		faMasAccount.setClBalanceDr(accountClBalanceDr);
						 		faMasAccount.setClBalanceCr(new BigDecimal(0.00));
						 	 }
						 }else{

							  accountClBalanceDr = accountClBalanceDr.add(openingBalanceDr);
							  faMasAccount.setClBalanceDr(accountClBalanceDr);
						  }
					}else if(openingBalanceCr.compareTo(new BigDecimal(0))>0){
						 if(accountClBalanceDr.compareTo(new BigDecimal(0)) > 0){
							 if(accountClBalanceDr.compareTo(openingBalanceCr) > 0){

								  accountBalanceCr = accountClBalanceDr.subtract(openingBalanceCr);
								  faMasAccount.setClBalanceDr(accountBalanceCr);
								  faMasAccount.setClBalanceCr(new BigDecimal(0.00));
							  }else if(openingBalanceCr.compareTo(accountClBalanceDr) > 0 ){
								  	accountBalanceCr =openingBalanceCr.subtract(accountClBalanceDr);
								  	faMasAccount.setClBalanceCr(accountBalanceCr);
								  	faMasAccount.setClBalanceDr(new BigDecimal(0.00));
							 	 }
						 }
						 else{
							  accountBalanceCr = accountBalanceCr.add(openingBalanceCr);
							  faMasAccount.setClBalanceCr(accountBalanceCr);
						  }
					}
	//-------------------------------update account opening Balance-----------------------------------------------//
					BigDecimal accountOpBalanceDr = new BigDecimal(0.0);
					BigDecimal accountOpBalanceCr = new BigDecimal(0.0);

					if(faMasAccount.getOpBalanceDr() != null)
						accountOpBalanceDr =  faMasAccount.getOpBalanceDr();
					if(faMasAccount.getOpBalanceCr() != null)
						accountOpBalanceCr = faMasAccount.getOpBalanceCr();

					if(openingBalanceDr.compareTo(new BigDecimal(0))>0){
						 if(accountOpBalanceCr.compareTo(new BigDecimal(0)) > 0){
							 if(accountOpBalanceCr.compareTo(openingBalanceDr) > 0){
								 accountOpBalanceDr = accountOpBalanceCr.subtract(openingBalanceDr);
						 		 faMasAccount.setOpBalanceCr(accountOpBalanceDr);
						 		 faMasAccount.setOpBalanceDr(new BigDecimal(0.00));
						 	 }else if(openingBalanceDr.compareTo(accountOpBalanceCr) > 0 ){
						 		accountOpBalanceDr =openingBalanceDr.subtract(accountOpBalanceCr);
						 		faMasAccount.setOpBalanceDr(accountOpBalanceDr);
						 		faMasAccount.setOpBalanceCr(new BigDecimal(0.00));
						 	 }
						 }else{

							 accountOpBalanceDr = accountOpBalanceDr.add(openingBalanceDr);
							  faMasAccount.setOpBalanceDr(accountOpBalanceDr);
						  }
					}else if(openingBalanceCr.compareTo(new BigDecimal(0))>0){
						 if(accountOpBalanceDr.compareTo(new BigDecimal(0)) > 0){
							 if(accountOpBalanceDr.compareTo(openingBalanceCr) > 0){

								 accountOpBalanceCr = accountOpBalanceDr.subtract(openingBalanceCr);
								  faMasAccount.setOpBalanceDr(accountOpBalanceCr);
								  faMasAccount.setOpBalanceCr(new BigDecimal(0.00));
							  }else if(openingBalanceCr.compareTo(accountOpBalanceDr) > 0 ){
								  accountOpBalanceCr =openingBalanceCr.subtract(accountOpBalanceDr);
								  	faMasAccount.setOpBalanceCr(accountOpBalanceCr);
								  	faMasAccount.setOpBalanceDr(new BigDecimal(0.00));
							 	 }
						 }
						 else{
							 accountOpBalanceCr = accountOpBalanceCr.add(openingBalanceCr);
							  faMasAccount.setOpBalanceCr(accountOpBalanceCr);
						  }
					}
				 	hbt.update(faMasAccount);
			}
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//--------------------------------------------------------------------------		 	
	 	
	 	accGrpList =session.createCriteria(FaMasAccountGroup.class).createAlias("FYear", "fy")
		 						.add(Restrictions.eq("fy.Id", box.getInt("fYear"))).add(Restrictions.eq("Hospital.Id", box.getInt("locationId"))).list();

	 	subAccGrpList =session.createCriteria(FaMasAccountSubGroup.class).createAlias("FYear", "fy")
		 						.add(Restrictions.eq("fy.Id", box.getInt("fYear"))).add(Restrictions.eq("Hospital.Id", box.getInt("locationId"))).list();
		subLedList = session.createCriteria(FaMasSubLed.class).createAlias("FYear", "fy")
							.add(Restrictions.eq("fy.Id", box.getInt("fYear"))).add(Restrictions.eq("Hospital.Id", box.getInt("locationId"))).list();
		accList =session.createCriteria(FaMasAccount.class).createAlias("FYear", "fy")
					.add(Restrictions.eq("fy.Id",  box.getInt("fYear"))).add(Restrictions.eq("Hospital.Id", box.getInt("locationId")))
							.list();
		map.put("subLedList", subLedList);
		map.put("accGrpList", accGrpList);
		map.put("subAccGrpList", subAccGrpList);
		map.put("accList", accList);
		map.put("message", message);
		return map;
	}
	


/**
 *  Code By Ritu For Bank Reconciliation
 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> showBankReconciliationJsp(int fYear) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		Session session = getSession();

		try {
			accountList = session.createCriteria(FaMasAccount.class)
								.createAlias("AccountSubGroup", "sg").add(Restrictions.eq("sg.Id", 5))
								/*.add(Restrictions.eq("ParentStatus", "n"))*/.list();
			map.put("accountList", accountList);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getBankAccountDetailsForReconciliation(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccount> accountBalanceList1 = new ArrayList<FaMasAccount>();
		List<AccountMainTransac> accountBalanceList = new ArrayList<AccountMainTransac>();
		List<FaVoucherDetails> vrDtAccountList = new ArrayList<FaVoucherDetails>();
		List<FaVoucherDetails> voucherDtList = new ArrayList<FaVoucherDetails>();
		Session session = getSession();
		int fYear = box.getInt("fYear");
		Object voucherType[] = {"PV","RV","PRV"};
		try {
			accountBalanceList1 = session.createCriteria(FaMasAccount.class)
									/*.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", fYear))*/
									.add(Restrictions.eq("Id", box.getInt(BANK_ACCOUNT)))
									.list();
			
			accountBalanceList = session.createCriteria(AccountMainTransac.class)
					.createAlias("FinancialYear", "fy").add(Restrictions.eq("fy.Id", fYear))
					.createAlias("Location", "location").add(Restrictions.eq("location.Id", box.getInt("locationId")))
					.createAlias("Account", "acc").add(Restrictions.eq("acc.Id", box.getInt(BANK_ACCOUNT)))					
					.list();
			
			
			FaMasAccount masAccount = new FaMasAccount();
			if(accountBalanceList1.size() > 0){
				masAccount = accountBalanceList1.get(0);
			}
			Set<FaVoucherDetails> voucherDetailsSet =  new HashSet<FaVoucherDetails>();
			if(masAccount.getFaVoucherDetails() != null){
				voucherDetailsSet = masAccount.getFaVoucherDetails();
				for (FaVoucherDetails faVoucherDetails : voucherDetailsSet) {
					int vrHdId = faVoucherDetails.getVoucherHeader().getId();
					vrDtAccountList = session.createCriteria(FaVoucherDetails.class)
									.createAlias("VoucherHeader", "vh").add(Restrictions.eq("vh.Id", vrHdId)).add(Restrictions.in("vh.VoucherType", voucherType))
									.createAlias("Account", "acc").add(Restrictions.ne("acc.Id", box.getInt(BANK_ACCOUNT)))
									.add(Restrictions.eq("Reconcile", "n")).list();
					voucherDtList.addAll(vrDtAccountList);
				}
			}
			map.put("voucherDtList", voucherDtList);
			map.put("accountBalanceList", accountBalanceList);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;
	}

	public boolean saveBankReconciliationDetails(Box box) {
		boolean saved = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Transaction tx= null;
		Session session =getSession();
		try {
			tx= session.beginTransaction();
			FaBankReconciliationHeader reconciliationHeader = new FaBankReconciliationHeader();
			reconciliationHeader.setReconciliationDate(HMSUtil.convertStringTypeDateToDateType(box.getString(AS_ON_DATE)));
			FaMasAccount account = new FaMasAccount();
			account.setId(box.getInt(BANK_ACCOUNT));
			reconciliationHeader.setAccount(account);
			MasHospital hospital = new MasHospital();
			hospital.setId(box.getInt("locationId"));
			reconciliationHeader.setHospital(hospital);
			if(box.getString(BALANCE_TYPE).equalsIgnoreCase("dr")){
				reconciliationHeader.setDrBlncAsPerCompany(new BigDecimal(box.getString(COMPANY_BALANCE)));
			}else if(box.getString(BALANCE_TYPE).equalsIgnoreCase("cr")){
				reconciliationHeader.setCrBlncAsPerCompany(new BigDecimal(box.getString(COMPANY_BALANCE)));
			}
			if(box.getString("bankBlncType").equalsIgnoreCase("dr")){
				reconciliationHeader.setDrBlncAsPerBank(new BigDecimal(box.getString("bankBlnc")));
			}else if(box.getString(BALANCE_TYPE).equalsIgnoreCase("cr")){
				reconciliationHeader.setCrBlncAsPerBank(new BigDecimal(box.getString("bankBlnc")));
			}
			if(!box.getString("difference").equals("")){
				reconciliationHeader.setDiffAmt(new BigDecimal(box.getString("difference")));
			}
			Users users = new Users();
			users.setId(box.getInt("userId"));
			reconciliationHeader.setLastChgBy(users);
			reconciliationHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			reconciliationHeader.setLastChgTime(box.getString(CHANGED_TIME));
			hbt.save(reconciliationHeader);

			int counter = box.getInt("counter");
			for (int i = 1; i < counter; i++) {
				if(!box.getString(CHEQUE_STATUS+i).equals("") && !box.getString(CHEQUE_STATUS+i).equals("cleared")){
					FaBankReconciliationDetails reconciliationDetails = new FaBankReconciliationDetails();
					reconciliationDetails.setBankReconciliationHeader(reconciliationHeader);
					reconciliationDetails.setChequeAmt(new BigDecimal(box.getString(AMOUNT+i)));
					reconciliationDetails.setChequeStatus(box.getString(CHEQUE_STATUS+i));
					reconciliationDetails.setChequeDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHEQUE_DATE+i)));
					reconciliationDetails.setChequeNo(box.getString(CHEQUE_NO+i));
					reconciliationDetails.setVoucherType(box.getString(VOUCHER_TYPE+i));
					FaVoucherHeader voucherHeader = new FaVoucherHeader();
					voucherHeader.setId(box.getInt(VOUCHER_HD_ID+i));
					reconciliationDetails.setVoucherHeader(voucherHeader);
					hbt.save(reconciliationDetails);
				}else{
					if(!box.getString("clearingDate"+i).equals("")){
					FaBankReconciliationDetails reconciliationDetails = new FaBankReconciliationDetails();
					reconciliationDetails.setBankReconciliationHeader(reconciliationHeader);
					reconciliationDetails.setChequeAmt(new BigDecimal(box.getString(AMOUNT+i)));
					reconciliationDetails.setChequeStatus(box.getString(CHEQUE_STATUS+i));
					reconciliationDetails.setChequeDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHEQUE_DATE+i)));
					reconciliationDetails.setChequeNo(box.getString(CHEQUE_NO+i));
					reconciliationDetails.setVoucherType(box.getString(VOUCHER_TYPE+i));
					FaVoucherHeader voucherHeader = new FaVoucherHeader();
					voucherHeader.setId(box.getInt(VOUCHER_HD_ID+i));
					reconciliationDetails.setVoucherHeader(voucherHeader);
					reconciliationDetails.setClearingDate(HMSUtil.convertStringTypeDateToDateType(box.getString("clearingDate"+i)));
					hbt.save(reconciliationDetails);
					}
					
				}
				if(!box.getString(CHEQUE_STATUS+i).equals("")){
					int voucherDtId  = box.getInt(VOUCHER_DT_ID+i);
					FaVoucherDetails voucherDetails = (FaVoucherDetails)hbt.load(FaVoucherDetails.class, voucherDtId);
					voucherDetails.setReconcile("y");
					hbt.update(voucherDetails);
				}
			}
			saved = true;
			tx.commit();
		} catch (DataAccessException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}

		return saved;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> showJournalVoucherJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
		Session session = (Session)getSession();
		costCenterList = session.createCriteria(MasCostCenter.class).add(Restrictions.eq("Status", "y")).list();
		paramMap.put("suffix", box.getString("fYearDesc"));
		paramMap.put("locationId", box.getInt("locationId"));
		paramMap.put("flag", "display");
		paramMap.put("prefix", "JV");
		paramMap.put("voucherType", "Journal");
		/*int voucherNo = generateVoucherNo(paramMap);*/
		/*map.put("voucherNo", voucherNo);*/
		map.put("costCenterList", costCenterList);
		return map;
	}
	@SuppressWarnings("unchecked")
	private synchronized int  generateVoucherNo(Map<String, Object> paramMap) {
		int voucherNo = 0;
		int tsn = 0;
		int id= 0;
		String suffix = "";
		String prefix = "";
		String voucherType = "";
		String flag = "";
		int locationId = 0;
		if(paramMap.get("suffix") != null){
			suffix = (String)paramMap.get("suffix");
		}
		if(paramMap.get("prefix") != null){
			prefix = (String)paramMap.get("prefix");
		}
		if(paramMap.get("voucherType") != null){
			voucherType = (String)paramMap.get("voucherType");
		}
		if(paramMap.get("flag") != null){
			flag = (String)paramMap.get("flag");
		}
		if(paramMap.get("locationId") != null){
			locationId = (Integer)paramMap.get("locationId");
		}
//		paramMap.put("financialYearId", box.getInt("fYear"));
		int financialYearId=0;
		if(paramMap.get("financialYearId")!=null){
			financialYearId=(Integer)paramMap.get("financialYearId");
		}
		Session session = getSession();
		List<TransactionSequence> seqNoList = new ArrayList<TransactionSequence>();
		List<MasStoreFinancial> MasStoreFinancialList = new ArrayList<MasStoreFinancial>();
		MasStoreFinancialList=session.createCriteria(MasStoreFinancial.class).add(Restrictions.idEq(financialYearId)).list();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		seqNoList = session.createCriteria(TransactionSequence.class)
						/*.add(Restrictions.eq("TransactionPrefix", prefix))
						.add(Restrictions.eq("TransactionSuffix", suffix))*/
						.add(Restrictions.eq("VoucherType", voucherType)).add(Restrictions.eq("Hospital.Id", locationId))
						.add(Restrictions.eq("FinancialYear.Id", financialYearId))
						.list();
		System.out.println("----seqNoList------>"+seqNoList.size());
		if(seqNoList.size() > 0){
				for (TransactionSequence transactionSequence : seqNoList) {
					tsn = Integer.parseInt("" + transactionSequence.getTransactionSequenceNumber());
					id = transactionSequence.getId();
				}
				if(flag.equals("save")){
					TransactionSequence transactionSequenceObj = (TransactionSequence) hbt.load(TransactionSequence.class, id);
					transactionSequenceObj.setTransactionSequenceNumber(tsn + 1);
					hbt.update(transactionSequenceObj);
				}
				voucherNo = tsn+1;
		}else{
			if(flag.equals("save")){
				TransactionSequence tsObj = new TransactionSequence();
				tsObj.setStatus("y");
				tsObj.setTablename("FaVoucherHeader");
				tsObj.setTransactionPrefix(prefix);
				tsObj.setTransactionSequenceName(voucherType+" Voucher No");
				for(MasStoreFinancial MSF:MasStoreFinancialList){
					suffix=MSF.getYearDescription();
				}
				tsObj.setTransactionSuffix(suffix);
				tsObj.setVoucherType(voucherType);
				tsObj.setTransactionSequenceNumber(1);
				MasHospital masHospital = new MasHospital();
				masHospital.setId(locationId);
				tsObj.setHospital(masHospital);
				MasStoreFinancial mf=new MasStoreFinancial();
				mf.setId(financialYearId);
				tsObj.setFinancialYear(mf);

				//tsObj.setCreatedby("admin");
				tsObj.setStatus("y");
				hbt.save(tsObj);
				voucherNo = tsObj.getTransactionSequenceNumber();
			}else{
				voucherNo = 1;
			}

		}

		return voucherNo;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> submitJournalVoucher(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		int vhId=0;
		String voucherNo="";
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session)getSession();
		Transaction tx = null;
		boolean saved = false;
		try {
			tx = session.beginTransaction();
			FaVoucherHeader voucherHeader = new FaVoucherHeader();
			MasStoreFinancial masStoreFinancial =new MasStoreFinancial();
			masStoreFinancial.setId(box.getInt("fYear"));
			voucherHeader.setFYear(masStoreFinancial);
			MasHospital hospital = new MasHospital();
			hospital.setId(box.getInt("locationId"));
			voucherHeader.setHospital(hospital);
			voucherHeader.setVoucherType("JV");
			voucherHeader.setVoucherDate(HMSUtil.convertStringTypeDateToDateType(box.getString(VOUCHER_DATE)));
			voucherHeader.setVoucherTime(box.getString(CHANGED_TIME));
			voucherHeader.setStatus("y");
			voucherHeader.setNarration(box.getString(NARRATION));
			if(!box.getString(TOTAL_DR_AMOUNT).equals("")){
				voucherHeader.setDrAmount(new BigDecimal(box.getString(TOTAL_DR_AMOUNT)));
			}
			if(!box.getString(TOTAL_CR_AMOUNT).equals("")){
				voucherHeader.setCrAmount(new BigDecimal(box.getString(TOTAL_CR_AMOUNT)));
			}
			Users user = new Users();
			user.setId(box.getInt("changedBy"));
			voucherHeader.setLastChgBy(user);

			voucherHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			voucherHeader.setLastChgTime(box.getString(CHANGED_TIME));
			paramMap.put("locationId", box.getInt("locationId"));
			paramMap.put("suffix", box.getString("fYearDesc"));
			paramMap.put("flag", "save");
			paramMap.put("prefix", "");
			paramMap.put("voucherType", "Journal");
			paramMap.put("financialYearId", box.getInt("fYear"));
			/*int voucherNo = generateVoucherNo(paramMap);*/
			String locationCode="";
			String yearDesc="";
			/*List<MasStoreFinancial>financialList=new ArrayList<MasStoreFinancial>();*/
			List<MasHospital>hospitalList=new ArrayList<MasHospital>();
			hospitalList=session.createCriteria(MasHospital.class).add(Restrictions.idEq(box.getInt("locationId"))).list();
			for(MasHospital mg:hospitalList){
				locationCode=mg.getHospitalCode();
			}
			/*financialList=session.createCriteria(MasStoreFinancial.class).add(Restrictions.idEq(box.getInt("fYear"))).list();
			for(MasStoreFinancial msf1:financialList){
				yearDesc=msf1.getYearDescription();
			}*/
			
			
			
			map.put("tableObjectName", "FaVoucherHeader");			
			map.put("isHospitalWise", "y");
			map.put("hospitalId", box.getInt("locationId")); 
			/*map.put("isDivisionWise", "n");
			map.put("divisionId", box.getInt("divisionId"));*/
			map.put("isYearly", "y");			
			/*map.put("isMonthly", "n");*/
			map.put("isPrefix", "y");
			map.put("transactionPrefixProperty", "transactionPrefixForJV");
			
			voucherNo = HMSUtil.generateTransactionSequence(map, session, hbt);
			
			voucherHeader.setVoucherNo(voucherNo);
			
			
			hbt.save(voucherHeader);
			map.put("voucherType", voucherHeader.getVoucherType());
			int counter = box.getInt("hiddenValueCharge");
			for (int i = 1; i <= counter; i++) {
				int accountId = 0;
				BigDecimal crAmt = new BigDecimal(0.00);
				BigDecimal drAmt = new BigDecimal(0.00);

				FaVoucherDetails voucherDetails = new FaVoucherDetails();
				FaMasAccount account = new FaMasAccount();
				accountId = box.getInt("accountId"+i);
				System.out.println("accountId"+accountId);
				account.setId(accountId);
				voucherDetails.setAccount(account);
				voucherDetails.setVoucherHeader(voucherHeader);
				if(box.getInt(SUB_LEDGER_CODE+i) != 0){
					FaMasSubLed subLed= new FaMasSubLed();
					subLed.setId(box.getInt(SUB_LEDGER_CODE+i));
					voucherDetails.setSubLed(subLed);
					
				}
				if(box.getInt(COST_CENTER_ID+i) != 0){
					MasCostCenter costCenter = new MasCostCenter();
					costCenter.setId(box.getInt(COST_CENTER_ID+i));
					voucherDetails.setCostCenter(costCenter);
				}
				voucherDetails.setNarration(box.getString(ACCOUNT_NARRATION+i));
				voucherDetails.setReconcile("n");
				if(!box.getString(CR_AMOUNT+i).equals("")){
					crAmt = new BigDecimal(box.getString(CR_AMOUNT+i));
					voucherDetails.setCrAmount(crAmt);
				}
				if(!box.getString(DR_AMOUNT+i).equals("")){
					drAmt = new BigDecimal(box.getString(DR_AMOUNT+i));
					voucherDetails.setDrAmount(drAmt);
				}
				
				hbt.save(voucherDetails);
				
			}
			vhId=voucherHeader.getId();
			tx.commit();
			saved = true;
		} catch (Exception e) {
			if(tx != null){
				tx.rollback();
			}
			e.printStackTrace();
		}

		map = showJournalVoucherJsp(box);
		map.put("saved", saved);
		map.put("vhId", vhId);
		map.put("voucherNo1",voucherNo);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> submitPurchaseReturnVoucher(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
		List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
		String voucherNo="";
		int vhId=0;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session)getSession();
		Transaction tx = null;
		boolean saved = false;
		try {
			tx = session.beginTransaction();
			FaVoucherHeader voucherHeader = new FaVoucherHeader();
			MasStoreFinancial masStoreFinancial = new MasStoreFinancial();
			masStoreFinancial.setId(box.getInt("fYear"));
			voucherHeader.setFYear(masStoreFinancial);
			MasHospital hospital = new MasHospital();
			hospital.setId(box.getInt("locationId"));
			voucherHeader.setHospital(hospital);
			voucherHeader.setVoucherType("PR");
			voucherHeader.setVoucherDate(HMSUtil.convertStringTypeDateToDateType(box.getString(VOUCHER_DATE)));
			voucherHeader.setVoucherTime(box.getString(CHANGED_TIME));
			voucherHeader.setStatus("y");
			voucherHeader.setNarration(box.getString(NARRATION));
			if(!box.getString(TOTAL_DR_AMOUNT).equals("")){
				voucherHeader.setDrAmount(new BigDecimal(box.getString(TOTAL_DR_AMOUNT)));
			}
			if(!box.getString(TOTAL_CR_AMOUNT).equals("")){
				voucherHeader.setCrAmount(new BigDecimal(box.getString(TOTAL_CR_AMOUNT)));
			}
			if(box.getInt("supplierId")!= 0){
				MasStoreSupplier masStoreSupplier = new MasStoreSupplier();
				masStoreSupplier.setId(box.getInt("supplierId"));
				voucherHeader.setSupplier(masStoreSupplier);
			}
			if(!box.getString("poNo").equals("")){
				voucherHeader.setPoNo(box.getString("poNo"))	;
			}
			if(!box.getString("poDate").equals("")){
				voucherHeader.setPoDate(HMSUtil.convertStringTypeDateToDateType(box.getString("poDate")));
			}
			if(!box.getString("poAmount").equals("")){
				voucherHeader.setPoAmount(new BigDecimal(box.getString("poAmount")));
			}
			if(!box.getString("invoiceNo").equals("")){
				voucherHeader.setInvoiceNo(box.getString("invoiceNo"))	;
			}
			if(!box.getString("invoiceDate").equals("")){
				voucherHeader.setInvoiceDate(HMSUtil.convertStringTypeDateToDateType(box.getString("invoiceDate")));
			}
			if(!box.getString("invoiceAmount").equals("")){
				voucherHeader.setInvoiceAmount(new BigDecimal(box.getString("invoiceAmount")));
			}
			Users user = new Users();
			user.setId(box.getInt("changedBy"));
			voucherHeader.setLastChgBy(user);

			voucherHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			voucherHeader.setLastChgTime(box.getString(CHANGED_TIME));
		/*	paramMap.put("locationId", box.getInt("locationId"));
			paramMap.put("suffix", box.getString("fYearDesc"));
			paramMap.put("flag", "save");
			paramMap.put("prefix", "PR");
			paramMap.put("voucherType", "PurchaseReturn");
			paramMap.put("financialYearId", box.getInt("fYear"));
			int voucherNo = generateVoucherNo(paramMap);
			String locationCode="";
			String yearDesc="";
			List<MasStoreFinancial>financialList=new ArrayList<MasStoreFinancial>();
			List<MasHospital>hospitalList=new ArrayList<MasHospital>();
			hospitalList=session.createCriteria(MasHospital.class).add(Restrictions.idEq(box.getInt("locationId"))).list();
			for(MasHospital mg:hospitalList){
				locationCode=mg.getHospitalCode();
			}
			financialList=session.createCriteria(MasStoreFinancial.class).add(Restrictions.idEq(box.getInt("fYear"))).list();
			for(MasStoreFinancial msf1:financialList){
				yearDesc=msf1.getYearDescription();
			}*/
			
			map.put("tableObjectName", "FaVoucherHeader");			
			map.put("isHospitalWise", "y");
			map.put("hospitalId", box.getInt("locationId")); 
			/*map.put("isDivisionWise", "n");
			map.put("divisionId", box.getInt("divisionId"));*/
			map.put("isYearly", "y");			
			/*map.put("isMonthly", "n");*/
			map.put("isPrefix", "y");
			map.put("transactionPrefixProperty", "transactionPrefixForPR");
			
			
			try {
				voucherNo = HMSUtil.generateTransactionSequence(map, session, hbt);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			voucherHeader.setVoucherNo(voucherNo);
			
			/*voucherHeader.setVoucherNo("PR/"+locationCode+"/"+yearDesc+"/"+voucherNo);
			voucherNo1=locationCode+"/"+yearDesc+"/"+voucherNo;*/
			
			hbt.save(voucherHeader);
			map.put("voucherType", voucherHeader.getVoucherType());
			
			int counter = box.getInt("hiddenValueCharge");
			for (int i = 1; i <= counter; i++) {

				int accountId = 0;
				BigDecimal crAmt = new BigDecimal(0.00);
				BigDecimal drAmt = new BigDecimal(0.00);
				FaVoucherDetails voucherDetails = new FaVoucherDetails();
				voucherDetails.setVoucherHeader(voucherHeader);
				FaMasAccount account = new FaMasAccount();
				accountId = box.getInt("accountId"+i);
				account.setId(accountId);
				voucherDetails.setAccount(account);
				if(box.getInt(SUB_LEDGER_CODE+i) != 0){
					FaMasSubLed subLed= new FaMasSubLed();
					subLed.setId(box.getInt(SUB_LEDGER_CODE+i));
					voucherDetails.setSubLed(subLed);
				}
				
				voucherDetails.setNarration(box.getString(ACCOUNT_NARRATION+i));
				voucherDetails.setReconcile("n");
				if(!box.getString(CR_AMOUNT+i).equals("")){
					crAmt = new BigDecimal(box.getString(CR_AMOUNT+i));
					voucherDetails.setCrAmount(crAmt);
				}
				if(!box.getString(DR_AMOUNT+i).equals("")){
					drAmt = new BigDecimal(box.getString(DR_AMOUNT+i));
					voucherDetails.setDrAmount(drAmt);
				}
				hbt.save(voucherDetails);
			}
			vhId=voucherHeader.getId();
			tx.commit();
			saved = true;
		} catch (Exception e) {
			if(tx != null){
				tx.rollback();
			}
			e.printStackTrace();
		}

		costCenterList = session.createCriteria(MasCostCenter.class).add(Restrictions.eq("Status", "y")).list();
		supplierList = session.createCriteria(MasStoreSupplier.class).add(Restrictions.eq("Status", "y")).list();
		
		paramMap.put("locationId", box.getInt("locationId"));
		paramMap.put("suffix", box.getString("fYearDesc"));
		paramMap.put("flag", "display");
		paramMap.put("prefix", "SR");
		paramMap.put("voucherType", "SalesReturn");
		/*int voucherNo = generateVoucherNo(paramMap);*/
		map.put("vhId", vhId);
		map.put("voucherNo", voucherNo);
		map.put("saved", saved);
		map.put("costCenterList", costCenterList);
		map.put("supplierList", supplierList);
		map.put("voucherNo1",voucherNo);
		return map;
	}
	@Override
	public Map<String, Object> showAccountOpeningJsp(int branchId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		/*List<MasBranch> branchList = new ArrayList<MasBranch>();*/
		List<FaMasSubLed> subLedList = new ArrayList<FaMasSubLed>();
		List<HrMasFinancialYear> financialYearList = new ArrayList<HrMasFinancialYear>();
		List<Integer> maxAccOpeningList = new ArrayList<Integer>();
		List<String> accountOpeningList = new ArrayList<String>();
		List<FaAccountOpening> faAccountOpeningList = new ArrayList<FaAccountOpening>();
		Session session = (Session)getSession();
		accountList = session.createCriteria(FaMasAccount.class).list();
		subLedList = session.createCriteria(FaMasSubLed.class).list();
		String currentDate = HMSUtil.convertDateToStringTypeDate(new Date());
		financialYearList = session.createCriteria(HrMasFinancialYear.class).add(Restrictions.le("YearFromDate", HMSUtil.dateFormatterDDMMYYYY(currentDate)))
		.add(Restrictions.ge("YearToDate", HMSUtil.dateFormatterDDMMYYYY(currentDate)))
			.add(Restrictions.eq("Status", "y"))
				.list();
		String financialYear = "";
		String branchCode = "";
		if(financialYearList.size()>0){
			for(HrMasFinancialYear fYear : financialYearList){
				financialYear = fYear.getFinancialYear();
			}
		}
		branchList = session.createCriteria(MasBranch.class).add(Restrictions.idEq(branchId)).add(Restrictions.eq("Status", "y")).list();
		if(branchList.size()>0){
			for(MasBranch masBranch :branchList){
				branchCode = masBranch.getBranchCode();
			}
		} 
		maxAccOpeningList = session.createCriteria(FaAccountOpening.class).setProjection(Projections.max("Id")).list();
		int maxAccOpeningId = 0;
		
		String openingNo = "";
		if(maxAccOpeningList.size() > 0 && maxAccOpeningList.get(0)!= null){
			maxAccOpeningId = maxAccOpeningList.get(0);
		
			accountOpeningList = session.createCriteria(FaAccountOpening.class)
					.add(Restrictions.idEq(maxAccOpeningId))
					.setProjection(Projections.property("OpeningNo")).list();
		if(accountOpeningList.size() > 0){
			String opNo =accountOpeningList.get(0);
			String autoNo = opNo.substring(opNo.lastIndexOf("/")+1);
			int accOpNo = Integer.parseInt(autoNo);
			Integer aNo = accOpNo+1;
			openingNo =  financialYear+"/"+branchCode+"/"+ aNo.toString();
		//accCode = Integer.parseInt(accountOpeningList.get(0).toString())+1;
		}
		
		}else{
		
		 openingNo = financialYear+"/"+branchCode+"/"+ 1;
		}
		//String openingNo = financialYear+"/"+branchCode+"/"+ 1;
		faAccountOpeningList = session.createCriteria(FaAccountOpening.class).add(Restrictions.eq("Branch.Id", branchId)).list();
		map.put("accountList", accountList);
		map.put("subLedList", subLedList);
		map.put("openingNo", openingNo);
		map.put("faAccountOpeningList", faAccountOpeningList);
		return map;
	}
	@Override
	public Map<String, Object> saveAccountOpening(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		/*List<MasBranch> branchList = new ArrayList<MasBranch>();*/
		List<Integer> maxAccOpeningList = new ArrayList<Integer>();
		List<String> accountOpeningList = new ArrayList<String>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		List<FaMasSubLed> subLedList = new ArrayList<FaMasSubLed>();
		List<FaAccountOpening> faAccountOpeningList = new ArrayList<FaAccountOpening>();
		List<FaAccountOpening> existingAccountOpeningList = new ArrayList<FaAccountOpening>();
		Session session = (Session)getSession();
		List<HrMasFinancialYear> financialYearList = new ArrayList<HrMasFinancialYear>();
		HibernateTemplate hbt = getHibernateTemplate();
		boolean saved = false;
		String openingNo = "";
		String message = "";
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			String openingDate = (box.getString(OPENING_DATE));
			financialYearList = session.createCriteria(HrMasFinancialYear.class).add(Restrictions.le("YearFromDate", HMSUtil.dateFormatterDDMMYYYY(openingDate)))
									.add(Restrictions.ge("YearToDate", HMSUtil.dateFormatterDDMMYYYY(openingDate)))
										.add(Restrictions.eq("Status", "y")).list();
			String financialYear = "";
			String branchCode = "";
			int financialYearId = 0;
			if(financialYearList.size()>0){
				for(HrMasFinancialYear fYear : financialYearList){
					financialYear = fYear.getFinancialYear();
					financialYearId = fYear.getId();
				}
			}
			branchList = session.createCriteria(MasBranch.class).add(Restrictions.idEq(1)).add(Restrictions.eq("Status", "y")).list();
			if(branchList.size()>0){
				for(MasBranch masBranch :branchList){
					branchCode = masBranch.getBranchCode();
				}
			}
			maxAccOpeningList = session.createCriteria(FaAccountOpening.class).setProjection(Projections.max("Id")).list();
				int maxAccOpeningId = 0;
				if(maxAccOpeningList.size() > 0 && maxAccOpeningList.get(0)!= null){
					maxAccOpeningId = maxAccOpeningList.get(0);
				
					accountOpeningList = session.createCriteria(FaAccountOpening.class)
							.add(Restrictions.idEq(maxAccOpeningId))
							.setProjection(Projections.property("OpeningNo")).list();
				if(accountOpeningList.size() > 0){
					String opNo =accountOpeningList.get(0);
					String autoNo = opNo.substring(opNo.lastIndexOf("/")+1);
					int accOpNo = Integer.parseInt(autoNo);
					Integer aNo = accOpNo+1;
					openingNo =  financialYear+"/"+branchCode+"/"+ aNo.toString();
				//accCode = Integer.parseInt(accountOpeningList.get(0).toString())+1;
				}
				
				}else{
				
				 openingNo = financialYear+"/"+branchCode+"/"+ 1;
				}
				FaAccountOpening accountOpening = new FaAccountOpening();
				if(box.getInt(ACCOUNT_ID)!= 0){
					FaMasAccount masAccount = new FaMasAccount();
					masAccount.setId(box.getInt(ACCOUNT_ID));
					accountOpening.setAccount(masAccount);
				}
				if(box.getInt(SUBLEDGER_ID)!= 0){
					FaMasSubLed masSubLed = new FaMasSubLed();
					masSubLed.setId(box.getInt(SUBLEDGER_ID));
					accountOpening.setSubLedger(masSubLed);
				}
				if(!box.getString(OPENING_DATE).equals("")){
					accountOpening.setOpeningDate(HMSUtil.convertStringTypeDateToDateType(box.getString(OPENING_DATE)));
				}
				String accountType = "";
				if(!box.getString("accountType").equals("")){
					accountType = box.getString("accountType");
				}
				BigDecimal opBalanceCr = new BigDecimal(0.0);
				BigDecimal opBalanceDr = new BigDecimal(0.0);
				if(accountType.equals("Dr")){
				if (!box.getString(OPENING_BALANCE).equals("")) {
					opBalanceDr = new BigDecimal(box.getString(OPENING_BALANCE));
					accountOpening.setOpeningAmtDr(opBalanceDr);
				}
				}else{
					opBalanceCr = new BigDecimal(box.getString(OPENING_BALANCE));
					accountOpening.setOpeningAmtCr(opBalanceCr);
				}
				
				if(box.getInt("hospitalId")!= 0){
					MasHospital masHospital = new MasHospital();
					masHospital.setId(box.getInt("hospitalId"));
					accountOpening.setHospital(masHospital);
				}
				accountOpening.setOpeningNo(openingNo);
				Users users = new Users();
				users.setId(box.getInt("changedBy"));
				accountOpening.setLastChgBy(users);
				accountOpening.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
				accountOpening.setLastChgTime(box.getString(CHANGED_TIME));
				accountOpening.setStatus("y");
				HrMasFinancialYear masFinancialYear = new HrMasFinancialYear();
				masFinancialYear.setId(financialYearId);
				accountOpening.setFYear(masFinancialYear);
				MasBranch masBranch = new MasBranch();
				masBranch.setId(1);
				accountOpening.setBranch(masBranch);
				existingAccountOpeningList =session.createCriteria(FaAccountOpening.class).add(Restrictions.eq("Branch.Id", box.getInt("branchId")))
											.add(Restrictions.eq("SubLedger.Id",box.getInt(SUBLEDGER_ID))).list();
											
				if(existingAccountOpeningList.size()>0){
					message = "Data already exist.";
				}else{
					hbt.save(accountOpening);
					message = "Data saved Successfully!";
				}
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map = showAccountOpeningJsp(box.getInt("branchId"));
		map.put("message", message);
			/*faAccountOpeningList = session.createCriteria(FaAccountOpening.class).add(Restrictions.eq("Status", "y")).list();
			map.put("faAccountOpeningList", faAccountOpeningList);
			accountList = session.createCriteria(FaMasAccount.class).list();
			subLedList = session.createCriteria(FaMasSubLed.class).list();
			map.put("accountList", accountList);
			map.put("subLedList", subLedList);
			map.put("openingNo", openingNo);*/
			return map;
		}
	@SuppressWarnings("unchecked")
	public Map<String, Object> updateAccountOpening(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasBranch> branchList = new ArrayList<MasBranch>();
		//List<Integer> maxAccOpeningList = new ArrayList<Integer>();
		//List<String> accountOpeningList = new ArrayList<String>();
		//List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		//List<FaMasSubLed> subLedList = new ArrayList<FaMasSubLed>();
		//List<FaAccountOpening> faAccountOpeningList = new ArrayList<FaAccountOpening>();
		List<FaAccountOpening> existingAccountOpeningList = new ArrayList<FaAccountOpening>();
		Session session = (Session)getSession();
		List<HrMasFinancialYear> financialYearList = new ArrayList<HrMasFinancialYear>();
		HibernateTemplate hbt = getHibernateTemplate();
		//String openingNo = "";
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		String message = "";
		//boolean updated = false;
		try {
			String openingDate = (box.getString(OPENING_DATE));
			financialYearList = session.createCriteria(HrMasFinancialYear.class).add(Restrictions.le("YearFromDate", HMSUtil.dateFormatterDDMMYYYY(openingDate)))
									.add(Restrictions.ge("YearToDate", HMSUtil.dateFormatterDDMMYYYY(openingDate)))
										.add(Restrictions.eq("Status", "y")).list();
			//String financialYear = "";
			String branchCode = "";
			int financialYearId = 0;
			if(financialYearList.size()>0){
				for(HrMasFinancialYear fYear : financialYearList){
					//financialYear = fYear.getFinancialYear();
					financialYearId = fYear.getId();
				}
			}
			/*branchList = session.createCriteria(MasBranch.class).add(Restrictions.idEq(box.getInt("branchId"))).add(Restrictions.eq("Status", "y")).list();
			if(branchList.size()>0){
				for(MasBranch masBranch :branchList){
					branchCode = masBranch.getBranchCode();
				}
			}*/
			
				FaAccountOpening accountOpening = (FaAccountOpening) hbt.load(FaAccountOpening.class,box.getInt(COMMON_ID));

				if(box.getInt(ACCOUNT_ID)!= 0){
					FaMasAccount masAccount = new FaMasAccount();
					masAccount.setId(box.getInt(ACCOUNT_ID));
					accountOpening.setAccount(masAccount);
				}
				if(box.getInt(SUBLEDGER_ID)!= 0){
					FaMasSubLed masSubLed = new FaMasSubLed();
					masSubLed.setId(box.getInt(SUBLEDGER_ID));
					accountOpening.setSubLedger(masSubLed);
				}
				if(!box.getString(OPENING_DATE).equals("")){
					accountOpening.setOpeningDate(HMSUtil.convertStringTypeDateToDateType(box.getString(OPENING_DATE)));
				}
				String accountType = "";
				if(!box.getString("accountType").equals("")){
					accountType = box.getString("accountType");
				}
				BigDecimal opBalanceCr = new BigDecimal(0.0);
				BigDecimal opBalanceDr = new BigDecimal(0.0);
				if(accountType.equals("Dr")){
				if (!box.getString(OPENING_BALANCE).equals("")) {
					opBalanceDr = new BigDecimal(box.getString(OPENING_BALANCE));
					accountOpening.setOpeningAmtDr(opBalanceDr);
					accountOpening.setOpeningAmtCr(new BigDecimal(0.0));
				}
				}else if(accountType.equals("Cr")){
					opBalanceCr = new BigDecimal(box.getString(OPENING_BALANCE));
					accountOpening.setOpeningAmtCr(opBalanceCr);
					accountOpening.setOpeningAmtDr(new BigDecimal(0.0));
				}
				
				if(box.getInt("hospitalId")!= 0){
					MasHospital masHospital = new MasHospital();
					masHospital.setId(box.getInt("hospitalId"));
					accountOpening.setHospital(masHospital);
				}
				
				Users users = new Users();
				users.setId(box.getInt("changedBy"));
				accountOpening.setLastChgBy(users);
				accountOpening.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
				accountOpening.setLastChgTime(box.getString(CHANGED_TIME));
				accountOpening.setStatus("y");
				HrMasFinancialYear masFinancialYear = new HrMasFinancialYear();
				masFinancialYear.setId(financialYearId);
				accountOpening.setFYear(masFinancialYear);
				MasBranch masBranch = new MasBranch();
				masBranch.setId(box.getInt("branchId"));
				accountOpening.setBranch(masBranch);
				 existingAccountOpeningList =session.createCriteria(FaAccountOpening.class).add(Restrictions.eq("Branch.Id", box.getInt("branchId")))
					.add(Restrictions.eq("SubLedger.Id",box.getInt(SUBLEDGER_ID))).list();
				if(existingAccountOpeningList.size()>0){
					message = "Data already exist.";
				}else{
					hbt.update(accountOpening);
					message = "Data updated Successfully!";
				}
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map = showAccountOpeningJsp(box.getInt("branchId"));
		map.put("message", message);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> deleteAccountOpening(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasBranch> branchList = new ArrayList<MasBranch>();
		List<String> accountOpeningList = new ArrayList<String>();
		List<HrMasFinancialYear> financialYearList = new ArrayList<HrMasFinancialYear>();
		Session session = (Session)getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		String openingDate = (box.getString(OPENING_DATE));
		financialYearList = session.createCriteria(HrMasFinancialYear.class).add(Restrictions.le("YearFromDate", HMSUtil.dateFormatterDDMMYYYY(openingDate)))
								.add(Restrictions.ge("YearToDate", HMSUtil.dateFormatterDDMMYYYY(openingDate)))
									.add(Restrictions.eq("Status", "y")).list();
		String financialYear = "";
		String branchCode = "";
		int financialYearId = 0;
		if(financialYearList.size()>0){
			for(HrMasFinancialYear fYear : financialYearList){
				financialYear = fYear.getFinancialYear();
				financialYearId = fYear.getId();
			}
		}
		branchList = session.createCriteria(MasBranch.class).add(Restrictions.idEq(box.getInt("branchId"))).add(Restrictions.eq("Status", "y")).list();
		if(branchList.size()>0){
			for(MasBranch masBranch :branchList){
				branchCode = masBranch.getBranchCode();
			}
		}
		FaAccountOpening accountOpening = (FaAccountOpening) hbt.load(FaAccountOpening.class,box.getInt(COMMON_ID));
		boolean dataDeleted = false;
		if (box.getString("flag") != null) {
			String flag = (String) box.getString("flag");
			if (flag.equals("InActivate")) {
				accountOpening.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				accountOpening.setStatus("y");
				dataDeleted = false;
			}
		}
		hbt.update(accountOpening);
		String message = "";
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		map = showAccountOpeningJsp(box.getInt("branchId"));
		map.put("message", message);
		return map;
	}

	
	
	
	@SuppressWarnings("unchecked")
	/*public Map<String, Object> showAccountParameterJsp(int fYear) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		List<FaMasAccount> accountListForCash = new ArrayList<FaMasAccount>();
		List<FaMasAccount> accountListForBank = new ArrayList<FaMasAccount>();
		List<FaMasSubLed> subLedList = new ArrayList<FaMasSubLed>();
		List<MasMainChargecode> mainChargeCodeList = new ArrayList<MasMainChargecode>();
		List<MasCompany> companyList = new ArrayList<MasCompany>();
		List<MasPatientType> patientTypeList = new ArrayList<MasPatientType>();
		List<FaAccountsParameter> accountParameterList = new ArrayList<FaAccountsParameter>();
		Session session = (Session)getSession();
		Object[] selectedCode = {"COM","PRJ"};
		accountList = session.createCriteria(FaMasAccount.class).add(Restrictions.eq("FYear.Id", fYear)).list();
		accountListForCash = session.createCriteria(FaMasAccount.class).add(Restrictions.eq("FYear.Id", fYear))
								.add(Restrictions.eq("AccountSubGroup.Id", 2)).list();
		accountListForBank = session.createCriteria(FaMasAccount.class).add(Restrictions.eq("FYear.Id", fYear))
		.add(Restrictions.eq("AccountSubGroup.Id", 1)).list();
		subLedList = session.createCriteria(FaMasSubLed.class).add(Restrictions.eq("FYear.Id", fYear)).list();
		mainChargeCodeList = session.createCriteria(MasMainChargecode.class).add(Restrictions.eq("Status", "y")).list();
		companyList = session.createCriteria(MasCompany.class).add(Restrictions.eq("Status", "y")).list();
		patientTypeList = session.createCriteria(MasPatientType.class).add(Restrictions.eq("Status", "y"))
							.add(Restrictions.not(Restrictions.in("PatientTypeCode", selectedCode))).list();
		accountParameterList = session.createCriteria(FaAccountsParameter.class).list();
		map.put("accountList", accountList);
		map.put("accountListForCash", accountListForCash);
		map.put("accountListForBank", accountListForBank);
		map.put("subLedList", subLedList);
		map.put("mainChargeCodeList", mainChargeCodeList);
		map.put("companyList", companyList);
		map.put("patientTypeList", patientTypeList);
		map.put("accountParameterList", accountParameterList);
		return map;
	}

	public Map<String, Object> submitAccountsParameter(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();

	HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);

	try {
		Vector accId = box.getVector("acc_id");
		Vector subLedId = box.getVector("sub_led_id");
		Vector accountType = box.getVector("accountType");
		if(accountType.size()>0){
		for (int i = 0; i < accountType.size(); i++) {
			FaAccountsParameter faAccountsParameter = new FaAccountsParameter();
			if (accountType.get(i) != null && !accountType.get(i).equals("")) {
				faAccountsParameter.setAccountType((String) accountType.get(i));

				if (accId.size() > 0) {
					if (accId.get(i) != null && !accId.get(i).equals("0")) {
						FaMasAccount masAccount = new FaMasAccount();
						masAccount.setId(Integer.parseInt(accId.get(i).toString()));
						faAccountsParameter.setAccount(masAccount);
					}
				}
				if (subLedId.size() > 0) {
					if (subLedId.get(i) != null && !subLedId.get(i).equals("0")) {
						FaMasSubLed masSubLed = new FaMasSubLed();
						masSubLed.setId(Integer.parseInt(subLedId.get(i).toString()));
						faAccountsParameter.setSubLed(masSubLed);
					}
				}
				if(box.getInt("hospitalId")!= 0){
					MasHospital masHospital = new MasHospital();
					masHospital.setId(box.getInt("userId"));
					faAccountsParameter.setHospital(masHospital);
				}
				if(box.getInt("userId")!= 0){
					Users users = new Users();
					users.setId(box.getInt("userId"));
					faAccountsParameter.setLastChgBy(users);
				}
				if(!box.getString(CHANGED_DATE).equals("")){
					faAccountsParameter.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
				}
				if(!box.getString(CHANGED_TIME).equals("")){
					faAccountsParameter.setLastChgTime(box.getString(CHANGED_TIME));
				}
				faAccountsParameter.setStatus("y");
				hbt.save(faAccountsParameter);
			}

		}
		}
		int chargeListLength = box.getInt("hiddenValueForAccounts");


		if(chargeListLength > 0){
				for(int i=0; i<= chargeListLength; i++){
					int mainchargeId  = 0;
					if (box.getInt(MAIN_CHARGECODE_ID+ i) != 0) {
						MasMainChargecode mainChargecode = new MasMainChargecode();
						 mainchargeId = box.getInt(MAIN_CHARGECODE_ID+ i);
					}
					if( box.getInt(MAIN_CHARGECODE_ID+ i)!= 0){
					MasMainChargecode masMainChargecode = (MasMainChargecode)hbt.load(MasMainChargecode.class, mainchargeId);
					if (box.getString(BILL_TYPE+ i) != "") {
						masMainChargecode.setBillType(box.getString(BILL_TYPE+ i));
					}
					if (box.getInt(ACCOUNT_ID+ i) != 0) {
						FaMasAccount faMasAccount = new FaMasAccount();
						faMasAccount.setId(box.getInt(ACCOUNT_ID+ i));
						masMainChargecode.setAccount(faMasAccount);
					}
					if (box.getInt(SUB_LEDGER_CODE+ i) != 0) {
						FaMasSubLed faMasSubLed = new FaMasSubLed();
						faMasSubLed.setId(box.getInt(SUB_LEDGER_CODE+ i));
						masMainChargecode.setSubLed(faMasSubLed);
					}

					hbt.update(masMainChargecode);

					}
					}
				}

		int count = 0;
		if(box.getInt("counter")!= 0){
			count = box.getInt("counter");
		}
		for (int i = 1; i <= count; i++) {
			int companyId  = 0;
			if (box.getInt("companyCheckBoxId"+ i) != 0) {
				MasCompany masCompany = new MasCompany();
				companyId = box.getInt("companyCheckBoxId"+ i);
			}
			if( box.getInt("companyCheckBoxId"+ i)!= 0){
			MasCompany masCompany = (MasCompany)hbt.load(MasCompany.class, companyId);
			if (box.getInt("acc_id"+ i) != 0) {
				FaMasAccount faMasAccount = new FaMasAccount();
				faMasAccount.setId(box.getInt("acc_id"+ i));
				masCompany.setAccount(faMasAccount);
			}

			if (box.getInt(SUB_LEDGER_ID+ i) != 0) {
				FaMasSubLed faMasSubLed = new FaMasSubLed();
				faMasSubLed.setId(box.getInt(SUB_LEDGER_ID+ i));
				masCompany.setSubLed(faMasSubLed);
			}

				hbt.update(masCompany);
			}

			}
//=================================================================================================
		int cnt = 0;
		if(box.getInt("cnt")!= 0){
			cnt = box.getInt("cnt");
		}
		for (int j= 1; j <= cnt; j++) {
			int patientTypeId  = 0;
			if (box.getInt("patientTypeCheckBoxId"+ j) != 0) {
				MasPatientType masPatientType = new MasPatientType();
				patientTypeId = box.getInt("patientTypeCheckBoxId"+ j);
			}
			if(box.getInt("patientTypeCheckBoxId"+ j)!= 0){
			MasPatientType masPatientType= (MasPatientType)hbt.load(MasPatientType.class, patientTypeId);
			if (box.getInt("accPatienType_id"+ j) != 0) {
				FaMasAccount faMasAccount = new FaMasAccount();
				faMasAccount.setId(box.getInt("accPatienType_id"+ j));
				masPatientType.setAcc(faMasAccount);
			}

			if (box.getInt("subLedId"+ j) != 0) {
				FaMasSubLed faMasSubLed = new FaMasSubLed();
				faMasSubLed.setId(box.getInt("subLedId"+ j));
				masPatientType.setSubLed(faMasSubLed);
			}

				hbt.update(masPatientType);

			}
		}

	} catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (DataAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	map = showAccountParameterJsp(box.getInt("fYear"));
		return map;
	}*/
	public Map<String, Object> getBillingAmountForAccounts() {
		Map<String, Object> map = new HashMap<String, Object>();

		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> showBranchBalancePopupJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasBranch> branchList = new ArrayList<MasBranch>();
		Session session = (Session)getSession();
		branchList = session.createCriteria(MasBranch.class).add(Restrictions.eq("Status", "y")).list();
		map.put("branchList", branchList);
		return map;
	}
	public Map<String, Object> showBranchSubLedBalancePopupJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasBranch> branchList = new ArrayList<MasBranch>();
		Session session = (Session)getSession();
		branchList = session.createCriteria(MasBranch.class).add(Restrictions.eq("Status", "y")).list();
		map.put("branchList", branchList);
		return map;
	}
	public Map<String, Object> showVoucherMappingJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> dispalySalesBillingAmount(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasSubLed> subLedCollectionAcList  = new ArrayList<FaMasSubLed>();
		List<FaMasSubLed> subLedSaleAcList  = new ArrayList<FaMasSubLed>();
		List<FaMasSubLed> subLedImprestAcList  = new ArrayList<FaMasSubLed>();
		List<FaMasSubLed> subLedSubsidyAcList  = new ArrayList<FaMasSubLed>();
		List<BigDecimal> subsidyAmountList  = new ArrayList<BigDecimal>();
		List<BigDecimal> salesAmountList  = new ArrayList<BigDecimal>();
		List<BigDecimal>imprestAccountList=new ArrayList<BigDecimal>();
		List<BigDecimal>cashAccountList=new ArrayList<BigDecimal>();
		Session session = (Session)getSession();
		int locationId = box.getInt("locationId");
		BigDecimal salval=new BigDecimal(0);
		BigDecimal imprestVal=new BigDecimal(0);
		BigDecimal subsidyVal=new BigDecimal(0);
		BigDecimal cashVal=new BigDecimal(0);
		try {
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			String fromDate4MySQL = "";
			String toDate4MySQL = "";
			try {
				fromDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(FROM_DATE)));
				 toDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(TO_DATE)));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String dispensingQueryString = "select sum(ifnull(bill_amt,0))"
											+ " FROM bl_dispensing_header disphd " +
											"where bill_invoice_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and location_id="+locationId+" and action_type = 'CashBill' AND voucher_no is null" ;
			
			salesAmountList= session.createSQLQuery(dispensingQueryString).list();
			salval=salesAmountList.get(0);
			
			
			String imprestAcQuery = "SELECT sum(grand_totaL) FROM bl_service_charges b  "+
										"	LEFT OUTER JOIN bl_dispensing_header disphd ON disphd.dispensing_header_id=b.dispensing_header_id  "+
										"	where disphd.bill_invoice_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and disphd.location_id="+locationId+" and disphd.action_type = 'CashBill' AND disphd.voucher_no is null and disphd.plan_grower_details_id is not null";
			imprestAccountList=session.createSQLQuery(imprestAcQuery).list();
			imprestVal=imprestAccountList.get(0);
			
			String subsidyQueryString = "select sum(ifnull(total_subsidy_amt,0))"
											+ " FROM bl_dispensing_header disphd " +
											"where bill_invoice_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and location_id="+locationId+" and action_type = 'CashBill' AND voucher_no is null" ;
			subsidyAmountList=session.createSQLQuery(subsidyQueryString).list();
			subsidyVal=subsidyAmountList.get(0);
			
			String 	cashAccountQuery="select sum(ifnull(net_amt,0))"
									+ " FROM bl_dispensing_header disphd " +
									"where bill_invoice_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and location_id="+locationId+" and action_type = 'CashBill' AND voucher_no is null" ;

			cashAccountList=session.createSQLQuery(cashAccountQuery).list();
			cashVal=cashAccountList.get(0);
			
		
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("salesAmountList", salesAmountList);
		if(imprestVal != null)
		{
			map.put("salval",salval.add(imprestVal));
		}
		else
		{
			map.put("salval",salval);
		}
		
		int cashAccountId = 0;
		cashAccountId =  Integer.parseInt(HMSUtil.getProperties("adt.properties", "cashAccountId"));
		
		subLedCollectionAcList = getSubLedListForAccountId(cashAccountId,locationId);
		
		
		
		int salesAccountId = 0;
		salesAccountId = Integer.parseInt(HMSUtil.getProperties("adt.properties", "salesAccountId"));
		subLedSaleAcList =  getSubLedListForAccountId(salesAccountId,locationId);

		int imprestAccountId = 0;
		imprestAccountId = Integer.parseInt(HMSUtil.getProperties("adt.properties", "imprestAccountId"));
		subLedImprestAcList = getSubLedListForAccountId(imprestAccountId,locationId);
		
		
		
		int subsidyAccountId = 0;
		subsidyAccountId = Integer.parseInt(HMSUtil.getProperties("adt.properties", "subsidyAccountId"));
		subLedSubsidyAcList	= getSubLedListForAccountId(subsidyAccountId,locationId);
				
	
	
		map.put("salesAccountId",salesAccountId);
		map.put("imprestAccountId",imprestAccountId);
		map.put("CashAccountId",cashAccountId);
		map.put("imprestVal",imprestVal);
		map.put("subsidyVal",subsidyVal);
		map.put("cashVal",cashVal);
		map.put("subSidyAccountId",subsidyAccountId);
		map.put("subLedCollectionAcList",subLedCollectionAcList);
		map.put("subLedSaleAcList",subLedSaleAcList);
		map.put("subLedImprestAcList",subLedImprestAcList);
		map.put("subLedSubsidyAcList",subLedSubsidyAcList);
		
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> postSalesVoucherMapping(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<BlDispensingHeader> dispensingHeaderList = new ArrayList<BlDispensingHeader>();
		List<BlReceiptHeader> receiptHeaderList = new ArrayList<BlReceiptHeader>();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session)getSession();
		Transaction tx = null;
		boolean saved = false;


		try {
			tx = session.beginTransaction();
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			String fromDate4MySQL = "";
			String toDate4MySQL = "";
			int voucherNo = 0;
			
			int approvalStatus = Integer.parseInt(HMSUtil.getProperties("adt.properties", "approvedId"));
			
			try {
				fromDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(FROM_DATE)));
				 toDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(TO_DATE)));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dispensingHeaderList = session.createCriteria(BlDispensingHeader.class)
					.add(Restrictions.between("BillInvoiceDate", java.sql.Date.valueOf(fromDate4MySQL), java.sql.Date.valueOf(toDate4MySQL)))
					.createAlias("Location", "location").add(Restrictions.eq("location.Id", box.getInt("locationId")))
					.add(Restrictions.isNull("VoucherNo")).add(Restrictions.eq("ActionType", "CashBill").ignoreCase()).list();
			receiptHeaderList = session.createCriteria(BlReceiptHeader.class).add(Restrictions.between("ReceiptDate", java.sql.Date.valueOf(fromDate4MySQL), java.sql.Date.valueOf(toDate4MySQL)))
													.add(Restrictions.isNull("VoucherNo")).list();


			FaVoucherHeader faVoucherHeader = new FaVoucherHeader();
			MasHospital masHospital = new MasHospital();
			masHospital.setId(box.getInt("locationId"));
			faVoucherHeader.setHospital(masHospital);
			faVoucherHeader.setVoucherDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			faVoucherHeader.setVoucherTime(box.getString(CHANGED_TIME));
			faVoucherHeader.setNarration("Posting-cash-billing Voucher");
			Users users = new Users();
			users.setId( box.getInt("changedBy"));
			faVoucherHeader.setLastChgBy(users);
			faVoucherHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			faVoucherHeader.setLastChgTime(box.getString(CHANGED_TIME));
			faVoucherHeader.setVoucherType("CV");
			faVoucherHeader.setStatus("y");
			BigDecimal totalAmountDr = new BigDecimal(0.0);
			BigDecimal totalAmountCr = new BigDecimal(0.0);
			if (!box.getString("totalAmountDr").equals("")) {
				totalAmountDr = new BigDecimal(box.getString("totalAmountDr"));
				faVoucherHeader.setDrAmount(totalAmountDr);
			}
			if (!box.getString("totalAmountCr").equals("")) {
				totalAmountCr = new BigDecimal(box.getString("totalAmountCr"));
				faVoucherHeader.setCrAmount(totalAmountCr);
			}
			MasStoreFinancial masStoreFinancial = new MasStoreFinancial();
			masStoreFinancial.setId(box.getInt("fYear"));
			faVoucherHeader.setFYear(masStoreFinancial);
			
			MasApprovalStatus masApprovalStatus = new MasApprovalStatus();
			masApprovalStatus.setId(approvalStatus);
			faVoucherHeader.setApprovalStatus(masApprovalStatus);
			faVoucherHeader.setAcknowedgeStatus(masApprovalStatus);
			
			paramMap.put("suffix", box.getString("fYearDesc"));
			paramMap.put("flag", "save");
			paramMap.put("prefix", "CV");
			paramMap.put("voucherType", "Collection");
			paramMap.put("locationId", box.getInt("locationId"));
			paramMap.put("financialYearId",box.getInt("fYear"));
			 voucherNo = generateVoucherNo(paramMap);
			 String locationCode="";
				String yearDesc="";
				List<MasStoreFinancial>financialList=new ArrayList<MasStoreFinancial>();
				List<MasHospital>hospitalList=new ArrayList<MasHospital>();
				hospitalList=session.createCriteria(MasHospital.class).add(Restrictions.idEq(box.getInt("locationId"))).list();
				for(MasHospital mg:hospitalList){
					locationCode=mg.getHospitalCode();
				}
				financialList=session.createCriteria(MasStoreFinancial.class).add(Restrictions.idEq(box.getInt("fYear"))).list();
				for(MasStoreFinancial msf1:financialList){
					yearDesc=msf1.getYearDescription();
				}
				
			faVoucherHeader.setVoucherNo("CV/"+locationCode+"/"+yearDesc+"/"+voucherNo);
			hbt.save(faVoucherHeader);
			map.put("voucherType", faVoucherHeader.getVoucherType());
					
			if(dispensingHeaderList.size()>0){
				for(BlDispensingHeader dispensingHeader: dispensingHeaderList){
					int dispensingId = dispensingHeader.getId();
					BlDispensingHeader dispHeader = (BlDispensingHeader)hbt.load(BlDispensingHeader.class, dispensingId);
					dispHeader.setVoucherNo(""+"CV/"+locationCode+"/"+yearDesc+"/"+voucherNo);
					hbt.update(dispHeader);
				}
			}
			
			//inserting data for sales A/C in fa_voucher_details
			BigDecimal crAmt = new BigDecimal(0.00);
			BigDecimal drAmt = new BigDecimal(0.00);
			int salesAccountId =0;
			String salesNarration="";
			FaVoucherDetails voucherDetails = new FaVoucherDetails();
			FaMasAccount account = new FaMasAccount();
			salesAccountId = box.getInt("salesAccountId");
			
			account.setId(salesAccountId);
			voucherDetails.setAccount(account);
			voucherDetails.setVoucherHeader(faVoucherHeader);
			voucherDetails.setReconcile("n");
			voucherDetails.setDrAmount(new BigDecimal(0.00));
		
			if(!box.getString("salesVal").equals("")){
				crAmt = new BigDecimal(box.getString("salesVal"));
				voucherDetails.setCrAmount(crAmt);
			}
			if(!box.getString("salesAcNarration").equals("")){
				salesNarration = box.getString("salesAcNarration");
				voucherDetails.setNarration(salesNarration);
			}
			
			int subLedSale=0;
			if(box.getInt("subLedSale")!=0){
				subLedSale = box.getInt("subLedSale");
				FaMasSubLed subLedS = new FaMasSubLed();
				subLedS.setId(subLedSale);
				voucherDetails.setSubLed(subLedS);
			}
		
			hbt.save(voucherDetails);
			
			 
			updateTransactionForPayment(subLedSale, box.getInt("salesAccountId"), box.getInt("fYear"), box.getInt("locationId"), ""+crAmt, ""+drAmt, 0);
			//updateTransaction(subLedId2,box.getInt("salesAccountId"), box.getInt("fYear"),  box.getInt("locationId"), ""+crAmt, ""+drAmt);
			
			//inserting data for Imprest A/C in fa_voucher_details
			BigDecimal crAmtImprest = new BigDecimal(0.00);
			BigDecimal drAmtImprest = new BigDecimal(0.00);
			int accountIdImprest =0;
			String imprestNarration="";
			FaVoucherDetails voucherDetailsImprest = new FaVoucherDetails();
			FaMasAccount accountImprest = new FaMasAccount();
			accountIdImprest = box.getInt("imprestAccount");

			accountImprest.setId(accountIdImprest);
			voucherDetailsImprest.setAccount(accountImprest);
			voucherDetailsImprest.setVoucherHeader(faVoucherHeader);
			voucherDetailsImprest.setReconcile("n");
			voucherDetailsImprest.setCrAmount(new BigDecimal(0.00));

			if(!box.getString("imprestVal").equals("")){
				drAmtImprest = new BigDecimal(box.getString("imprestVal"));
				voucherDetailsImprest.setDrAmount(drAmtImprest);
			}
			
			if(!box.getString("imprestAcNarration").equals("")){
				imprestNarration = box.getString("imprestAcNarration");
				voucherDetailsImprest.setNarration(imprestNarration);
			}
			int subLedImp=0;
			if(box.getInt("subLedImp")!=0){
				subLedImp = box.getInt("subLedImp");
				FaMasSubLed subLedIm = new FaMasSubLed();
				subLedIm.setId(subLedImp);
				voucherDetailsImprest.setSubLed(subLedIm);
			}
			
			hbt.save(voucherDetailsImprest);
			
			updateTransactionForPayment(subLedImp,box.getInt("imprestAccount"), box.getInt("fYear"),  box.getInt("locationId"), ""+crAmtImprest, ""+drAmtImprest,0);
			//updateTransaction(subLedImp,box.getInt("imprestAccount"), box.getInt("fYear"),  box.getInt("locationId"), ""+crAmtImprest, ""+drAmtImprest);
			
			//inserting data for Subsidy A/C in fa_voucher_details
			BigDecimal crAmtSubsidy = new BigDecimal(0.00);
			BigDecimal drAmtSubsidy = new BigDecimal(0.00);
			int accountIdSubsidy =0;
			String subsidyAcNarration="";
			FaVoucherDetails voucherDetailsSubsidy = new FaVoucherDetails();
			FaMasAccount accountSubsidy = new FaMasAccount();
			accountIdSubsidy = box.getInt("subSidyAccountId");
			accountSubsidy.setId(accountIdSubsidy);
			voucherDetailsSubsidy.setAccount(accountSubsidy);
			voucherDetailsSubsidy.setVoucherHeader(faVoucherHeader);
			voucherDetailsSubsidy.setReconcile("n");
			voucherDetailsSubsidy.setDrAmount(new BigDecimal(0.00));
			
			if(!box.getString("subsidyVal").equals("")){
				crAmtSubsidy = new BigDecimal(box.getString("subsidyVal"));
				voucherDetailsSubsidy.setCrAmount(crAmtSubsidy);
			}

			if(!box.getString("subSidyAcNarration").equals("")){
				subsidyAcNarration = box.getString("subSidyAcNarration");
				voucherDetailsSubsidy.setNarration(subsidyAcNarration);
			}
			int subLedsubsidy=0;
			if(box.getInt("subLedsubsidy")!=0){
				subLedsubsidy = box.getInt("subLedsubsidy");
				FaMasSubLed subLedSubs = new FaMasSubLed();
				subLedSubs.setId(subLedsubsidy);
				voucherDetailsSubsidy.setSubLed(subLedSubs);
			}
			hbt.save(voucherDetailsSubsidy);
			
			
			//updateTransaction(subLedsubsidy,box.getInt("subSidyAccountId"), box.getInt("fYear"),  box.getInt("locationId"), ""+crAmtSubsidy, ""+drAmtSubsidy);
			updateTransactionForPayment(subLedsubsidy,box.getInt("subSidyAccountId"), box.getInt("fYear"),  box.getInt("locationId"), ""+crAmtSubsidy, ""+drAmtSubsidy,0);
			
			//inserting data for Collection A/C in fa_voucher_details
			BigDecimal crAmtCash = new BigDecimal(0.00);
			BigDecimal drAmtCash = new BigDecimal(0.00);
			int accountIdCash =0;
			String collectionAcNarration="";
			FaVoucherDetails voucherDetailsCash = new FaVoucherDetails();
			FaMasAccount accountCash = new FaMasAccount();
			accountIdCash = box.getInt("CashAccountId");
			accountCash.setId(accountIdCash);
			voucherDetailsCash.setAccount(accountCash);
			voucherDetailsCash.setVoucherHeader(faVoucherHeader);
			voucherDetailsCash.setReconcile("n");
			voucherDetailsCash.setCrAmount(new BigDecimal(0.00));
			if(!box.getString("cashVal").equals("")){
				drAmtCash = new BigDecimal(box.getString("cashVal"));
				voucherDetailsCash.setDrAmount(drAmtCash);
				
			}
			if(!box.getString("collectionAcNarration").equals("")){
				collectionAcNarration = box.getString("collectionAcNarration");
				voucherDetailsCash.setNarration(collectionAcNarration);
			}
			int subLedCollection=0;
			if(box.getInt("subLedCollection")!=0){
				subLedCollection = box.getInt("subLedCollection");
				FaMasSubLed subLedCol = new FaMasSubLed();
				subLedCol.setId(subLedCollection);
				voucherDetailsCash.setSubLed(subLedCol);
			}
			hbt.save(voucherDetailsCash);
			
			//updateTransaction(subLedId,box.getInt("CashAccountId"), box.getInt("fYear"),  box.getInt("locationId"), ""+crAmtCash, ""+drAmtCash);
			updateTransactionForPayment(subLedCollection,box.getInt("CashAccountId"), box.getInt("fYear"),  box.getInt("locationId"), ""+crAmtCash, ""+drAmtCash,0);
			
			tx.commit();
			saved = true;

			} catch (RuntimeException e) {
					if (tx != null)
						tx.rollback();
					e.printStackTrace();
				}

				paramMap.put("suffix", box.getString("fYearDesc"));
				paramMap.put("flag", "display");
				paramMap.put("prefix", "SV");
				paramMap.put("voucherType", "Sales");
				int voucherNo = generateVoucherNo(paramMap);
				map.put("voucherNo", voucherNo);
				map.put("saved", saved);
				
		return map;
	}



	public synchronized Map<String,Object> updateTransaction(int subLedId,int accountId,int fYearId,int locationId,String crAmount,String drAmount){
		System.out.println("accountId=---------------->>"+accountId);
		System.out.println("crAmount=---------------->>"+crAmount);
		System.out.println("drAmount=---------------->>"+drAmount);
		System.out.println("fYearId=---------------->>"+fYearId);
		Map<String,Object>map=new HashMap<String,Object>();
		Session session=(Session)getSession();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		boolean flag=false;
		Transaction tx = null;		
		try{
			tx=session.beginTransaction();
			// transaction for Account
			List<AccountMainTransac>amtList=new ArrayList<AccountMainTransac>();
			amtList=session.createCriteria(AccountMainTransac.class)
						    .add(Restrictions.eq("Account.Id",accountId))
						    .add(Restrictions.eq("FinancialYear.Id",fYearId))
						    .add(Restrictions.eq("Location.Id",locationId))
					.list();
			if(amtList.size()==0){
				AccountMainTransac agt=new AccountMainTransac();
				FaMasAccount fmasg=new FaMasAccount();					
				fmasg.setId(accountId);
				agt.setAccount(fmasg);
					//crAmt = new BigDecimal(box.getString(CR_AMOUNT+i));
					agt.setOpBalanceCr(new BigDecimal(0));
					agt.setClBalanceCr(new BigDecimal(crAmount));
//					drAmt = new BigDecimal(box.getString(DR_AMOUNT+i));
					agt.setOpBalanceDr(new BigDecimal(0));
					agt.setClBalanceDr(new BigDecimal(drAmount));
				Map<String, Object> utilMap = new HashMap<String, Object>();
				utilMap = (Map) HMSUtil.getCurrentDateAndTime();
				String date = (String) utilMap.get("currentDate");
				String time = (String) utilMap.get("currentTime");
				agt.setTransactionDate(HMSUtil.convertStringTypeDateToDateType(date));
				agt.setTransactionTime(time);
				agt.setYtdAmountCr(new BigDecimal(crAmount));
				agt.setYtdAmountDr(new BigDecimal(drAmount));
				MasStoreFinancial msf=new MasStoreFinancial();
				msf.setId(fYearId);
				agt.setFinancialYear(msf);
				MasHospital mh =new MasHospital();
				mh.setId(locationId);
				agt.setLocation(mh);
				hbt.save(agt);
			}else if(amtList.size()>0){
				for(AccountMainTransac acgt:amtList){
					Map<String, Object> utilMap = new HashMap<String, Object>();
					utilMap = (Map) HMSUtil.getCurrentDateAndTime();
					String date = (String) utilMap.get("currentDate");
					String time = (String) utilMap.get("currentTime");
					acgt.setTransactionDate(HMSUtil.convertStringTypeDateToDateType(date));
					acgt.setTransactionTime(time);
					if(!crAmount.equals("")){
					//	crAmt = new BigDecimal(box.getString(CR_AMOUNT+i));
						 
						BigDecimal crAmountSubLedger1=new BigDecimal(0);
						BigDecimal drAmountSubLedger1=new BigDecimal(0);
							crAmountSubLedger1 = acgt.getOpBalanceCr().add(acgt.getYtdAmountCr()).add(new BigDecimal(crAmount));
							drAmountSubLedger1 = acgt.getOpBalanceDr().add(acgt.getYtdAmountDr());
							
							if(drAmountSubLedger1.compareTo(crAmountSubLedger1)>0){
								acgt.setClBalanceDr(drAmountSubLedger1.subtract(crAmountSubLedger1));
								acgt.setClBalanceCr(new BigDecimal(0.00));
							}else if(crAmountSubLedger1.compareTo(drAmountSubLedger1)>0){
								acgt.setClBalanceCr(crAmountSubLedger1.subtract(drAmountSubLedger1));
								acgt.setClBalanceDr(new BigDecimal(0.00));
							}else if(crAmountSubLedger1.compareTo(drAmountSubLedger1)==0){
								acgt.setClBalanceCr(new BigDecimal(0.00));
								acgt.setClBalanceDr(new BigDecimal(0.00));
							}
							
						acgt.setYtdAmountCr(acgt.getYtdAmountCr().add(new BigDecimal(crAmount)));
						//acgt.setClBalanceCr(acgt.getClBalanceCr().add(new BigDecimal(crAmount)));
					}
					if(!drAmount.equals("") ){
					//	drAmt = new BigDecimal(box.getString(DR_AMOUNT+i));
						BigDecimal crAmountSubLedger11=new BigDecimal(0);
						BigDecimal drAmountSubLedger11=new BigDecimal(0);
							crAmountSubLedger11 = acgt.getOpBalanceCr().add(acgt.getYtdAmountCr());
							drAmountSubLedger11 = acgt.getOpBalanceDr().add(acgt.getYtdAmountDr()).add(new BigDecimal(drAmount));
							
							if(drAmountSubLedger11.compareTo(crAmountSubLedger11)>0){
								acgt.setClBalanceDr(drAmountSubLedger11.subtract(crAmountSubLedger11));
								acgt.setClBalanceCr(new BigDecimal(0.00));
							}else if(crAmountSubLedger11.compareTo(drAmountSubLedger11)>0){
								acgt.setClBalanceCr(crAmountSubLedger11.subtract(drAmountSubLedger11));
								acgt.setClBalanceDr(new BigDecimal(0.00));
							}else if(crAmountSubLedger11.compareTo(drAmountSubLedger11)==0){
								acgt.setClBalanceCr(new BigDecimal(0.00));
								acgt.setClBalanceDr(new BigDecimal(0.00));
							}
							
							
						
						
						
/*						acgt.setClBalanceDr(acgt.getClBalanceDr().add(new BigDecimal(drAmount)));
*/						acgt.setYtdAmountDr(acgt.getYtdAmountDr().add(new BigDecimal(drAmount)));
					}
					
					hbt.update(acgt);
				}

		}
			List<AccountMainTransac>amtListDelete=new ArrayList<AccountMainTransac>();
			amtListDelete=session.createCriteria(AccountMainTransac.class).add(Restrictions.eq("ClBalanceDr",new BigDecimal(0.00)))
					.add(Restrictions.eq("ClBalanceCr",new BigDecimal(0.00)))
					.add(Restrictions.eq("YtdAmountCr",new BigDecimal(0.00)))
					.add(Restrictions.eq("YtdAmountDr",new BigDecimal(0.00)))
					.add(Restrictions.eq("OpBalanceCr",new BigDecimal(0.00)))
					.add(Restrictions.eq("OpBalanceDr",new BigDecimal(0.00)))
					.list();
			for(AccountMainTransac amt1:amtListDelete){
				session.delete(amt1);
			}
			// transaction for Subgroup
			int groupId=0;
			int subGroupId=0;
			List<FaMasAccount>accList=new ArrayList<FaMasAccount>();
			accList=session.createCriteria(FaMasAccount.class).add(Restrictions.eq("Id", accountId)).list();
			for(FaMasAccount acc:accList){
				groupId=acc.getAccountSubGroup().getAccountGroup().getId();
				subGroupId=acc.getAccountSubGroup().getId();
			}
			List<AccountSubGroupTransac>subGroupTransacList=new ArrayList<AccountSubGroupTransac>();
			subGroupTransacList=session.createCriteria(AccountSubGroupTransac.class)
				    .add(Restrictions.eq("SubGroup.Id",subGroupId))
				    .add(Restrictions.eq("FYear.Id",fYearId))
				    .add(Restrictions.eq("Location.Id",locationId))
			.list();
			
			if(subGroupTransacList.size()==0){
				AccountSubGroupTransac accountSubGroupTransac=new AccountSubGroupTransac();
				FaMasAccountSubGroup fmasg=new FaMasAccountSubGroup();					
				fmasg.setId(subGroupId);
				accountSubGroupTransac.setSubGroup(fmasg);
				accountSubGroupTransac.setOpBalanceCr(new BigDecimal(0));
				accountSubGroupTransac.setClBalanceCr(new BigDecimal(crAmount));
//				drAmt = new BigDecimal(box.getString(DR_AMOUNT+i));
				accountSubGroupTransac.setOpBalanceDr(new BigDecimal(0));
				accountSubGroupTransac.setClBalanceDr(new BigDecimal(drAmount));
				Map<String, Object> utilMap = new HashMap<String, Object>();
				utilMap = (Map) HMSUtil.getCurrentDateAndTime();
				String date = (String) utilMap.get("currentDate");
				String time = (String) utilMap.get("currentTime");
				accountSubGroupTransac.setTransactionDate(HMSUtil.convertStringTypeDateToDateType(date));
				accountSubGroupTransac.setTransactionTime(time);
				accountSubGroupTransac.setYtdAmountCr(new BigDecimal(crAmount));
				accountSubGroupTransac.setYtdAmountDr(new BigDecimal(drAmount));
				MasStoreFinancial msf=new MasStoreFinancial();
				msf.setId(fYearId);
				accountSubGroupTransac.setFYear(msf);
				MasHospital mh =new MasHospital();
				mh.setId(locationId);
				accountSubGroupTransac.setLocation(mh);	
				hbt.save(accountSubGroupTransac);
			}else if(subGroupTransacList.size()>0){
				for(AccountSubGroupTransac acgt:subGroupTransacList){
					Map<String, Object> utilMap = new HashMap<String, Object>();
					utilMap = (Map) HMSUtil.getCurrentDateAndTime();
					String date = (String) utilMap.get("currentDate");
					String time = (String) utilMap.get("currentTime");
					acgt.setTransactionDate(HMSUtil.convertStringTypeDateToDateType(date));
					acgt.setTransactionTime(time);
					if(!crAmount.equals("")){
					//	crAmt = new BigDecimal(box.getString(CR_AMOUNT+i));
						 
						BigDecimal crAmountSubLedger1=new BigDecimal(0);
						BigDecimal drAmountSubLedger1=new BigDecimal(0);
							crAmountSubLedger1 = acgt.getOpBalanceCr().add(acgt.getYtdAmountCr()).add(new BigDecimal(crAmount));
							drAmountSubLedger1 = acgt.getOpBalanceDr().add(acgt.getYtdAmountDr());
							
							if(drAmountSubLedger1.compareTo(crAmountSubLedger1)>0){
								acgt.setClBalanceDr(drAmountSubLedger1.subtract(crAmountSubLedger1));
								acgt.setClBalanceCr(new BigDecimal(0.00));
							}else if(crAmountSubLedger1.compareTo(drAmountSubLedger1)>0){
								acgt.setClBalanceCr(crAmountSubLedger1.subtract(drAmountSubLedger1));
								acgt.setClBalanceDr(new BigDecimal(0.00));
							}else if(crAmountSubLedger1.compareTo(drAmountSubLedger1)==0){
								acgt.setClBalanceCr(new BigDecimal(0.00));
								acgt.setClBalanceDr(new BigDecimal(0.00));
							}
							
							
							
							
						acgt.setYtdAmountCr(acgt.getYtdAmountCr().add(new BigDecimal(crAmount)));
						/*acgt.setClBalanceCr(acgt.getClBalanceCr().add(new BigDecimal(crAmount)));*/
					}
					if(!drAmount.equals("") ){
					//	drAmt = new BigDecimal(box.getString(DR_AMOUNT+i));
						BigDecimal crAmountSubLedger11=new BigDecimal(0);
						BigDecimal drAmountSubLedger11=new BigDecimal(0);
							crAmountSubLedger11 = acgt.getOpBalanceCr().add(acgt.getYtdAmountCr());
							drAmountSubLedger11 = acgt.getOpBalanceDr().add(acgt.getYtdAmountDr()).add(new BigDecimal(drAmount));
							
							if(drAmountSubLedger11.compareTo(crAmountSubLedger11)>0){
								acgt.setClBalanceDr(drAmountSubLedger11.subtract(crAmountSubLedger11));
								acgt.setClBalanceCr(new BigDecimal(0.00));
							}else if(crAmountSubLedger11.compareTo(drAmountSubLedger11)>0){
								acgt.setClBalanceCr(crAmountSubLedger11.subtract(drAmountSubLedger11));
								acgt.setClBalanceDr(new BigDecimal(0.00));
							}else if(crAmountSubLedger11.compareTo(drAmountSubLedger11)==0){
								acgt.setClBalanceCr(new BigDecimal(0.00));
								acgt.setClBalanceDr(new BigDecimal(0.00));
							}
							
							
						
						
						
								/*acgt.setClBalanceDr(acgt.getClBalanceDr().add(new BigDecimal(drAmount)));*/
						acgt.setYtdAmountDr(acgt.getYtdAmountDr().add(new BigDecimal(drAmount)));
					}
					
					hbt.update(acgt);
				}

		
			}
			List<AccountSubGroupTransac>asgtListDelete=new ArrayList<AccountSubGroupTransac>();
			asgtListDelete=session.createCriteria(AccountSubGroupTransac.class).add(Restrictions.eq("ClBalanceDr",new BigDecimal(0.00)))
					.add(Restrictions.eq("ClBalanceCr",new BigDecimal(0.00)))
					.add(Restrictions.eq("YtdAmountCr",new BigDecimal(0.00)))
					.add(Restrictions.eq("YtdAmountDr",new BigDecimal(0.00)))
					.add(Restrictions.eq("OpBalanceCr",new BigDecimal(0.00)))
					.add(Restrictions.eq("OpBalanceDr",new BigDecimal(0.00)))
					.list();
			for(AccountSubGroupTransac asgt1:asgtListDelete){
				session.delete(asgt1);
			}
			
			// transaction for group
			List<AccountGroupTransac>groupTransacList=new ArrayList<AccountGroupTransac>();
			groupTransacList=session.createCriteria(AccountGroupTransac.class)
				    .add(Restrictions.eq("AccountGroup.Id",groupId))
				    .add(Restrictions.eq("FinancialYear.Id",fYearId))
				    .add(Restrictions.eq("Centre.Id",locationId))
			.list();
			
			if(groupTransacList.size()==0){
				AccountGroupTransac accountGroupTransac=new AccountGroupTransac();
				
				FaMasAccountGroup fmag=new FaMasAccountGroup();					
				fmag.setId(groupId);
				accountGroupTransac.setAccountGroup(fmag);
				
				accountGroupTransac.setOpBalanceCr(new BigDecimal(0));
				accountGroupTransac.setClBalanceCr(new BigDecimal(crAmount));
				
			
			
//				drAmt = new BigDecimal(box.getString(DR_AMOUNT+i));
				accountGroupTransac.setOpBalanceDr(new BigDecimal(0));
				
				accountGroupTransac.setClBalanceDr(new BigDecimal(drAmount));
				
				Map<String, Object> utilMap = new HashMap<String, Object>();
				utilMap = (Map) HMSUtil.getCurrentDateAndTime();
				String date = (String) utilMap.get("currentDate");
				String time = (String) utilMap.get("currentTime");

				
				accountGroupTransac.setTransactionDate(HMSUtil.convertStringTypeDateToDateType(date));
				accountGroupTransac.setTransactionTime(time);
				accountGroupTransac.setYtdAmountCr(new BigDecimal(crAmount));
				accountGroupTransac.setYtdAmountDr(new BigDecimal(drAmount));
				MasStoreFinancial msf=new MasStoreFinancial();
				msf.setId(fYearId);
				accountGroupTransac.setFinancialYear(msf);
				
				MasHospital mh =new MasHospital();
				mh.setId(locationId);
				accountGroupTransac.setCentre(mh);	
				hbt.save(accountGroupTransac);
				
			}else if(groupTransacList.size()>0){
				for(AccountGroupTransac agt:groupTransacList){
					Map<String, Object> utilMap = new HashMap<String, Object>();
					utilMap = (Map) HMSUtil.getCurrentDateAndTime();
					String date = (String) utilMap.get("currentDate");
					String time = (String) utilMap.get("currentTime");
					agt.setTransactionDate(HMSUtil.convertStringTypeDateToDateType(date));
					agt.setTransactionTime(time);
					if(!crAmount.equals("") ){
					//	crAmt = new BigDecimal(box.getString(CR_AMOUNT+i));
						 
						BigDecimal crAmountSubLedger1=new BigDecimal(0);
						BigDecimal drAmountSubLedger1=new BigDecimal(0);
							crAmountSubLedger1 = agt.getOpBalanceCr().add(agt.getYtdAmountCr()).add(new BigDecimal(crAmount));
							drAmountSubLedger1 = agt.getOpBalanceDr().add(agt.getYtdAmountDr());
							
							if(drAmountSubLedger1.compareTo(crAmountSubLedger1)>0){
								agt.setClBalanceDr(drAmountSubLedger1.subtract(crAmountSubLedger1));
								agt.setClBalanceCr(new BigDecimal(0.00));
							}else if(crAmountSubLedger1.compareTo(drAmountSubLedger1)>0){
								agt.setClBalanceCr(crAmountSubLedger1.subtract(drAmountSubLedger1));
								agt.setClBalanceDr(new BigDecimal(0.00));
							}else if(crAmountSubLedger1.compareTo(drAmountSubLedger1)==0){
								agt.setClBalanceCr(new BigDecimal(0.00));
								agt.setClBalanceDr(new BigDecimal(0.00));
							}
							
							
							
							
							agt.setYtdAmountCr(agt.getYtdAmountCr().add(new BigDecimal(crAmount)));
/*							agt.setClBalanceCr(agt.getClBalanceCr().add(new BigDecimal(crAmount)));
*/					}
					if(!drAmount.equals("")){
					//	drAmt = new BigDecimal(box.getString(DR_AMOUNT+i));
						BigDecimal crAmountSubLedger11=new BigDecimal(0);
						BigDecimal drAmountSubLedger11=new BigDecimal(0);
							crAmountSubLedger11 = agt.getOpBalanceCr().add(agt.getYtdAmountCr());
							drAmountSubLedger11 = agt.getOpBalanceDr().add(agt.getYtdAmountDr()).add(new BigDecimal(drAmount));
							
							if(drAmountSubLedger11.compareTo(crAmountSubLedger11)>0){
								agt.setClBalanceDr(drAmountSubLedger11.subtract(crAmountSubLedger11));
								agt.setClBalanceCr(new BigDecimal(0.00));
							}else if(crAmountSubLedger11.compareTo(drAmountSubLedger11)>0){
								agt.setClBalanceCr(crAmountSubLedger11.subtract(drAmountSubLedger11));
								agt.setClBalanceDr(new BigDecimal(0.00));
							}else if(crAmountSubLedger11.compareTo(drAmountSubLedger11)==0){
								agt.setClBalanceCr(new BigDecimal(0.00));
								agt.setClBalanceDr(new BigDecimal(0.00));
							}
							
							
						
						
						
/*							agt.setClBalanceDr(agt.getClBalanceDr().add(new BigDecimal(drAmount)));
*/							agt.setYtdAmountDr(agt.getYtdAmountDr().add(new BigDecimal(drAmount)));
					}
					
					hbt.update(agt);
				}
			}
				List<AccountGroupTransac>agtListDelete=new ArrayList<AccountGroupTransac>();
				asgtListDelete=session.createCriteria(AccountGroupTransac.class).add(Restrictions.eq("ClBalanceDr",new BigDecimal(0.00)))
						.add(Restrictions.eq("ClBalanceCr",new BigDecimal(0.00)))
						.add(Restrictions.eq("YtdAmountCr",new BigDecimal(0.00)))
						.add(Restrictions.eq("YtdAmountDr",new BigDecimal(0.00)))
						.add(Restrictions.eq("OpBalanceCr",new BigDecimal(0.00)))
						.add(Restrictions.eq("OpBalanceDr",new BigDecimal(0.00)))
						.list();
				for(AccountGroupTransac agt1:agtListDelete){
					session.delete(agt1);
				}
				
				if(subLedId!=0){

					List<AccountSubLedTransac>asltList=new ArrayList<AccountSubLedTransac>();
					asltList=session.createCriteria(AccountSubLedTransac.class)
								    .add(Restrictions.eq("SubLed.Id",subLedId))
								    .add(Restrictions.eq("Location.Id",locationId))
								    .add(Restrictions.eq("FYear.Id", fYearId))
							.list();
					
	System.out.println("actList SIZE FOR SUB LEDGER-------------->>"+asltList.size());
					if(asltList.size()==0){
						AccountSubLedTransac aslt=new AccountSubLedTransac();
						
						FaMasSubLed fmasg=new FaMasSubLed();					
						fmasg.setId(subLedId);
						aslt.setSubLed(fmasg);//(fmasg);
						
						MasHospital location = new MasHospital();
						location.setId(locationId);
						aslt.setLocation(location);
						
						aslt.setOpBalanceCr(new BigDecimal(0));
						aslt.setOpBalanceDr(new BigDecimal(0));
						aslt.setClBalanceCr(new BigDecimal(crAmount));
						aslt.setClBalanceDr(new BigDecimal(drAmount));
						aslt.setYtdAmountCr(new BigDecimal(crAmount));
						aslt.setYtdAmountDr(new BigDecimal(drAmount));					
						
						
						Map<String, Object> utilMap = new HashMap<String, Object>();
						utilMap = (Map) HMSUtil.getCurrentDateAndTime();
						String date = (String) utilMap.get("currentDate");
						String time = (String) utilMap.get("currentTime");

						
						aslt.setTransactionDate(HMSUtil.convertStringTypeDateToDateType(date));
						aslt.setTransactionTime(time);
						
						MasStoreFinancial msf=new MasStoreFinancial();
						msf.setId(fYearId);
						aslt.setFYear(msf);
						
						/*MasHospital mh =new MasHospital();
						mh.setId(box.getInt("locationId"));
						agt.set(mh);*/
					
						
						hbt.save(aslt);
						
					}else if(asltList.size()>0){
						for(AccountSubLedTransac aslt:asltList){
							Map<String, Object> utilMap = new HashMap<String, Object>();
							utilMap = (Map) HMSUtil.getCurrentDateAndTime();
							String date = (String) utilMap.get("currentDate");
							String time = (String) utilMap.get("currentTime");
							aslt.setTransactionDate(HMSUtil.convertStringTypeDateToDateType(date));
							aslt.setTransactionTime(time);
							if(!crAmount.equals("") ){
							//	crAmt = new BigDecimal(box.getString(CR_AMOUNT+i));
								 
								BigDecimal crAmountSubLedger1=new BigDecimal(0);
								BigDecimal drAmountSubLedger1=new BigDecimal(0);
									crAmountSubLedger1 = aslt.getOpBalanceCr().add(aslt.getYtdAmountCr()).add(new BigDecimal(crAmount));
									drAmountSubLedger1 = aslt.getOpBalanceDr().add(aslt.getYtdAmountDr());
									
									if(drAmountSubLedger1.compareTo(crAmountSubLedger1)>0){
										aslt.setClBalanceDr(drAmountSubLedger1.subtract(crAmountSubLedger1));
										aslt.setClBalanceCr(new BigDecimal(0.00));
									}else if(crAmountSubLedger1.compareTo(drAmountSubLedger1)>0){
										aslt.setClBalanceCr(crAmountSubLedger1.subtract(drAmountSubLedger1));
										aslt.setClBalanceDr(new BigDecimal(0.00));
									}else if(crAmountSubLedger1.compareTo(drAmountSubLedger1)==0){
										aslt.setClBalanceCr(new BigDecimal(0.00));
										aslt.setClBalanceDr(new BigDecimal(0.00));
									}
									
									
									
									
									aslt.setYtdAmountCr(aslt.getYtdAmountCr().add(new BigDecimal(crAmount)));
/*									aslt.setClBalanceCr(aslt.getClBalanceCr().add(new BigDecimal(crAmount)));
*/							}
							if(!drAmount.equals("")){
							//	drAmt = new BigDecimal(box.getString(DR_AMOUNT+i));
								BigDecimal crAmountSubLedger11=new BigDecimal(0);
								BigDecimal drAmountSubLedger11=new BigDecimal(0);
									crAmountSubLedger11 = aslt.getOpBalanceCr().add(aslt.getYtdAmountCr());
									drAmountSubLedger11 = aslt.getOpBalanceDr().add(aslt.getYtdAmountDr()).add(new BigDecimal(drAmount));
									
									if(drAmountSubLedger11.compareTo(crAmountSubLedger11)>0){
										aslt.setClBalanceDr(drAmountSubLedger11.subtract(crAmountSubLedger11));
										aslt.setClBalanceCr(new BigDecimal(0.00));
									}else if(crAmountSubLedger11.compareTo(drAmountSubLedger11)>0){
										aslt.setClBalanceCr(crAmountSubLedger11.subtract(drAmountSubLedger11));
										aslt.setClBalanceDr(new BigDecimal(0.00));
									}else if(crAmountSubLedger11.compareTo(drAmountSubLedger11)==0){
										aslt.setClBalanceCr(new BigDecimal(0.00));
										aslt.setClBalanceDr(new BigDecimal(0.00));
									}		
									
								
								
								
/*									aslt.setClBalanceDr(aslt.getClBalanceDr().add(new BigDecimal(drAmount)));
*/									aslt.setYtdAmountDr(aslt.getYtdAmountDr().add(new BigDecimal(drAmount)));
							}
							
							hbt.update(aslt);
						}
						
					}				
					
				}
		}catch(Exception e){
			if(tx != null){
				tx.rollback();
			}
			e.printStackTrace();
		}
		return map;	
	}

	public Map<String, Object> showIpSalesVoucherMappingJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		return map;
	}
	public Map<String, Object> dispalyIpSalesBillingAmount(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> mainChargeAmountList = new ArrayList<Object[]>();
		List<Object[]> companyAmountList = new ArrayList<Object[]>();
		List<Object[]> cashAmountList  = new ArrayList<Object[]>();
		List<Object[]> bankAmountList  = new ArrayList<Object[]>();
		List<Object[]> creditCardAmountList  = new ArrayList<Object[]>();
		List<Object[]> discountAmountList  = new ArrayList<Object[]>();
		List<Object[]> charityAmountList  = new ArrayList<Object[]>();
		List<Object[]> stdAmountList  = new ArrayList<Object[]>();
		List<Object[]> roundOffAmountList  = new ArrayList<Object[]>();
		List<Object[]> patientTypeAmountList  = new ArrayList<Object[]>();
		List<Object[]> salesMedicineAmountList  = new ArrayList<Object[]>();
		Session session = (Session)getSession();

		try {
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			String fromDate4MySQL = "";
			String toDate4MySQL = "";
			try {
				fromDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(FROM_DATE)));
				 toDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(TO_DATE)));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			//-----------------------For Total Billing--------------------------------------
			String mainChargeQueryString = "select acc.acc_desc,subled.sub_led_desc,mcc.account_id,mcc.sub_led_id, main_chargecode_name, mc.main_chargecode_id,subgrp.account_sub_group_id,grp.account_group_id,sum(ifnull(rate,0)*ifnull(quantity,0)) as bill_amt " +
					" from bl_final_bill_details finaldetail left join bl_charge_slip_main main on main.final_bill_id =finaldetail.final_bill_details_id left join bl_charge_slip_detail  chargedetail on chargedetail.charge_slip_main_id = main.charge_slip_main_id " +
					" left join mas_charge_code mc on chargedetail.charge_code_id=mc.charge_code_id left join mas_main_chargecode mcc on mc.main_chargecode_id = mcc.main_chargecode_id left join fa_mas_account acc on acc.acc_id = mcc.account_id left join fa_mas_sub_led subled " +
					" on subled.sub_led_id = mcc.sub_led_id left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where finaldetail.final_bill_date " +
					" between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and mcc.account_id is not null group by mc.main_chargecode_id " +
					" union " +
					" select (select acc_desc from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Mis.Account') as acnt, (select sub_led_desc from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
					" where account_type='Mis.Account') as subled, (select acc_id from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Mis.Account') as account_id, (select sub_led_id from fa_accounts_parameter fp left join  fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Mis.Account') " +
					" as sub_led_id,main_chargecode_name, mc.main_chargecode_id, (select subgrp.account_sub_group_id from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where account_type='Mis.Account') as account_sub_group, (select grp.account_group_id from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where account_type='Mis.Account') as account_group, " +
					" sum(ifnull(rate,0)*ifnull(quantity,0)) as bill_amt from bl_final_bill_details finaldetail left join bl_charge_slip_main main on main.final_bill_id =finaldetail.final_bill_details_id left join bl_charge_slip_detail  chargedetail on chargedetail.charge_slip_main_id = main.charge_slip_main_id " +
					" left join mas_charge_code mc on chargedetail.charge_code_id=mc.charge_code_id left join mas_main_chargecode mcc on mc.main_chargecode_id = mcc.main_chargecode_id " +
					" left join fa_mas_account acc on acc.acc_id = mcc.account_id left join fa_mas_sub_led subled on subled.sub_led_id = mcc.sub_led_id where finaldetail.final_bill_date  between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and mcc.account_id is null group by mc.main_chargecode_id" ;
			mainChargeAmountList = session.createSQLQuery(mainChargeQueryString).list();

			String dispensingQueryString = "select sum(ifnull(bill_amt,0)),accountqry.* from (select acc_desc,acc_id,sub_led_desc,subled.sub_led_id, grp.account_group_id,subgrp.account_sub_group_id " +
					" from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
					" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where account_type='Sales Medicine')as accountqry, bl_dispensing_header disphd where bill_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and inpatient_id is  not null";

			salesMedicineAmountList= session.createSQLQuery(dispensingQueryString).list();

			String companyQueryString = " select com.company_name, acc.acc_desc as acnt, subled.sub_led_desc as subled, acc.acc_id , subled.sub_led_id,subgrp.account_sub_group_id,grp.account_group_id, " +
					" (select ifnull(sum(ifnull(os_amt,0.0)),0.0) as ip_amt from bl_final_bill_details finaldetail left join bl_charge_slip_main main on main.final_bill_id =finaldetail.final_bill_details_id " +
					" where main.patient_type_id =1 and main.company_id is not null and main.status='y' and main.company_id=com.company_id and finaldetail.final_bill_date  between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' )+  " +
					" (select  ifnull(sum(ifnull(outstanding,0.0)),0) as ip_amt from bl_final_bill_details finaldetail left join  bl_dispensing_header as obh on obh.ip_final_bill_id =finaldetail.final_bill_details_id " +
					" where obh.patient_type_id =1 and obh.company_id is not null and obh.inpatient_id is  not null and obh.status='y' and obh.company_id=com.company_id and finaldetail.final_bill_date " +
					" between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"') as com_acc from mas_company com left join fa_mas_account acc on acc.acc_id = com.account_id left join fa_mas_sub_led subled on subled.sub_led_id = com.sub_led_id " +
					" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where com.account_id is not null " +
					" union " +
					" select com.company_name, (select acc_desc from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Mis.Account') as acnt, (select sub_led_desc from fa_accounts_parameter fp " +
					" left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Mis.Account') as subled, " +
					" (select acc.acc_id  from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" where account_type='Mis.Account') as acc_id, (select subled.sub_led_id from fa_accounts_parameter fp " +
					" left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Mis.Account') as sub_led_id, " +
					" (select subgrp.account_sub_group_id from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp " +
					" on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where account_type='Mis.Account') as account_sub_group, (select grp.account_group_id from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where account_type='Mis.Account') as account_group, " +
					" (select ifnull(sum(ifnull(os_amt,0.0)),0.0) as ip_amt from bl_final_bill_details finaldetail left join bl_charge_slip_main main " +
					" on main.final_bill_id =finaldetail.final_bill_details_id where main.patient_type_id =1 and main.company_id is not null and main.status='y' " +
					" and main.company_id=com.company_id and finaldetail.final_bill_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"')+ " +
					" (select  ifnull(sum(ifnull(outstanding,0.0)),0) as ip_amt from bl_final_bill_details finaldetail left join  bl_dispensing_header as obh on obh.ip_final_bill_id =finaldetail.final_bill_details_id where obh.patient_type_id =1 " +
					" and obh.company_id is not null and obh.inpatient_id is not null and obh.status='y' and obh.company_id=com.company_id and finaldetail.final_bill_date " +
					" between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"') as com_acc from  mas_company com where  com.account_id is null ";

			companyAmountList = session.createSQLQuery(companyQueryString).list();

			String cashQueryString = "select sum(ifnull(rd.amount,0)), (select acc_desc from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Cash') as acnt, " +
					" (select sub_led_desc from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Cash') as subled," +
					" (select acc.acc_id from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Cash') as acc_id, " +
					" (select subled.sub_led_id from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Cash') as sub_led_id, " +
					" (select subgrp.account_sub_group_id from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp " +
					" on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where account_type='Cash') as account_sub_group, (select grp.account_group_id from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where account_type='Cash') as account_group from bl_final_bill_details finaldetail " +
					" left join bl_charge_slip_main main on main.final_bill_id =finaldetail.final_bill_details_id left join bl_charge_slip_detail  chargedetail on chargedetail.charge_slip_main_id = main.charge_slip_main_id " +
					" left join bl_receipt_header rh on rh.charge_slip_main_id = main.charge_slip_main_id left join bl_receipt_details rd on rh.receipt_header_id=rd.receipt_header_id " +
					" where finaldetail.final_bill_date between  '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and  receipt_type in ('chs','bld' ) and rh.inpatient_id is  not null and payment_mode='c'";

			cashAmountList = session.createSQLQuery(cashQueryString).list();

			String bankQueryString = "select sum(ifnull(rd.amount,0)), (select acc_desc from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Bank') as acnt, " +
					" (select sub_led_desc from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Bank') as subled," +
					" (select acc.acc_id from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Bank') as acc_id, " +
					" (select subled.sub_led_id from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Bank') as sub_led_id, " +
					" (select subgrp.account_sub_group_id from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp " +
					" on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where account_type='Bank') as account_sub_group, (select grp.account_group_id from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where account_type='Bank') as account_group from bl_final_bill_details finaldetail " +
					" left join bl_charge_slip_main main on main.final_bill_id =finaldetail.final_bill_details_id left join bl_charge_slip_detail  chargedetail on chargedetail.charge_slip_main_id = main.charge_slip_main_id " +
					" left join bl_receipt_header rh on rh.charge_slip_main_id = main.charge_slip_main_id left join bl_receipt_details rd on rh.receipt_header_id=rd.receipt_header_id " +
					" where finaldetail.final_bill_date between  '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and  receipt_type in ('chs','bld' ) and rh.inpatient_id is  not null and payment_mode='Q'";
			bankAmountList = session.createSQLQuery(bankQueryString).list();

			String creditCardQueryString = "select sum(ifnull(rd.amount,0)), (select acc_desc from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Credit Card') as acnt, " +
					" (select sub_led_desc from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Credit Card') as subled," +
					" (select acc.acc_id from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Credit Card') as acc_id, " +
					" (select subled.sub_led_id from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Credit Card') as sub_led_id, " +
					" (select subgrp.account_sub_group_id from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp " +
					" on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where account_type='Credit Card') as account_sub_group, (select grp.account_group_id from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where account_type='Credit Card') as account_group from bl_final_bill_details finaldetail " +
					" left join bl_charge_slip_main main on main.final_bill_id =finaldetail.final_bill_details_id left join bl_charge_slip_detail  chargedetail on chargedetail.charge_slip_main_id = main.charge_slip_main_id " +
					" left join bl_receipt_header rh on rh.charge_slip_main_id = main.charge_slip_main_id left join bl_receipt_details rd on rh.receipt_header_id=rd.receipt_header_id " +
					" where finaldetail.final_bill_date between  '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and  receipt_type in ('chs','bld' ) and rh.inpatient_id is  not null and payment_mode='R'";
			creditCardAmountList = session.createSQLQuery(creditCardQueryString).list();

			String discountString = " select (select ifnull(sum(ifnull(chargedetail.discount_amt,0.0)),0.0) as ip_amt from bl_final_bill_details finaldetail left join bl_charge_slip_main main on main.final_bill_id =finaldetail.final_bill_details_id " +
					" left join bl_charge_slip_detail  chargedetail on chargedetail.charge_slip_main_id = main.charge_slip_main_id where finaldetail.final_bill_date  between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' ) " +
					" + (select  ifnull(sum(ifnull(main.discount_amt,0.0)),0) as ip_amt from  bl_final_bill_details finaldetail left join bl_dispensing_header main on main.ip_final_bill_id =finaldetail.final_bill_details_id " +
					" where main.inpatient_id is not null and finaldetail.final_bill_date  between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' )as dis, " +
					" (select acc_desc from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Discount') as disAcc, (select acc.acc_id from fa_accounts_parameter fp left join " +
					" fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Discount') as disAccId, (select sub_led_desc from fa_accounts_parameter fp " +
					" left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Discount') as disSubled, " +
					"(select subled.sub_led_id from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
					" where account_type='Discount') as disSubledId, (select subgrp.account_sub_group_id from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp on " +
					" acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where account_type='Discount') as account_sub_group, (select grp.account_group_id from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where account_type='Discount') as account_group";

				discountAmountList = session.createSQLQuery(discountString).list();

				String sdString = "select (select sum(ifnull(std_deduction_gen,0)+ifnull(std_deduction_spl,0))as sd from bl_final_bill_details finaldetail " +
						" left join bl_charge_slip_main main on main.final_bill_id =finaldetail.final_bill_details_id left join bl_charge_slip_detail  chargedetail on chargedetail.charge_slip_main_id = main.charge_slip_main_id " +
						" where finaldetail.final_bill_date  between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' ) stde , (select acc_desc from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Std Deduction') as stdeAcc, (select acc.acc_id from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Std Deduction') as stdeAccId, " +
						" (select sub_led_desc from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Std Deduction') as stdeSubled, " +
						" (select subled.sub_led_id from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Std Deduction') as stdeSubledId, " +
						" (select subgrp.account_sub_group_id from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp on " +
						" acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where account_type='Std Deduction') as account_sub_group, " +
						" (select grp.account_group_id from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
						" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on " +
						" subgrp.account_group_id = grp.account_group_id where account_type='Std Deduction') as account_group ";
			 stdAmountList = session.createSQLQuery(sdString).list();

			 String roundOffString = " select (select  sum((ifnull(chg_slp_amt,0)-ifnull(main.discount_amt,0))-round(ifnull(chg_slp_amt,0)-ifnull(main.discount_amt,0)))  as ip_amt " +
			 		" from bl_final_bill_details finaldetail left join bl_charge_slip_main main on main.final_bill_id =finaldetail.final_bill_details_id " +
			 		" left join bl_charge_slip_detail  chargedetail on chargedetail.charge_slip_main_id = main.charge_slip_main_id where finaldetail.final_bill_date  between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' ) + " +
			 		" (select  sum((ifnull(bill_amt,0)-ifnull(main.discount_amt,0))-round(ifnull(bill_amt,0)-ifnull(main.discount_amt,0))) as ip_amt " +
			 		" from  bl_final_bill_details finaldetail left join bl_dispensing_header main on main.ip_final_bill_id =finaldetail.final_bill_details_id " +
			 		" where main.inpatient_id is not null and finaldetail.final_bill_date  between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' )as roundoff, " +
			 		" (select acc_desc from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
			 		" where account_type='Round Off') as roundOffAcc, (select acc.acc_id from fa_accounts_parameter fp left join " +
			 		" fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Round Off') as roundOffId, " +
			 		" (select sub_led_desc from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
			 		" where account_type='Round Off') as roundOffSubled, (select subled.sub_led_id from fa_accounts_parameter fp " +
			 		" left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Round Off') as roundOffSubledId, " +
			 		" (select subgrp.account_sub_group_id from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
			 		" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
			 		" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where account_type='Round Off') as account_sub_group, " +
			 		" (select grp.account_group_id from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
			 		" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
			 		" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where account_type='Round Off') as account_group;";
		roundOffAmountList = session.createSQLQuery(roundOffString).list();



				String charityString = "select (select ifnull(sum(ifnull(proportional_discount_amount,0.0)),0.0) " +
						" as op_amt from bl_final_bill_details finaldetail left join bl_charge_slip_main main " +
						" on main.final_bill_id =finaldetail.final_bill_details_id left join bl_charge_slip_detail  chargedetail " +
						" on chargedetail.charge_slip_main_id = main.charge_slip_main_id where final_bill_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' )+ " +
						"(select  ifnull(sum(ifnull(proportional_dis_amt,0.0)),0) as op_amt from bl_final_bill_details finaldetail " +
						" left join bl_dispensing_header main on main.ip_final_bill_id =finaldetail.final_bill_details_id " +
						" left join bl_dispensing_details as dd on main.dispensing_header_id = dd.dispensing_header_id where main.inpatient_id " +
						" is  not null and final_bill_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' ) + (select  ifnull(sum(ifnull(final_bill_charity,0.0)),0) as op_amt " +
						" from bl_final_bill_details finaldetail where final_bill_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' ) as charity, " +
						" (select acc_desc from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
						" where account_type='Charity') as disAcc, (select acc.acc_id from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Charity') as disAccId, " +
						" (select sub_led_desc from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
						" where account_type='Charity') as disSubled, " +
						" (select subled.sub_led_id from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
						" where account_type='Charity') as disSubledId, (select subgrp.account_sub_group_id from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp on " +
						" acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
						" where account_type='Discount') as account_sub_group, (select grp.account_group_id from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp on " +
						" acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on " +
						" subgrp.account_group_id = grp.account_group_id where account_type='Charity') as account_group;";
			 charityAmountList = session.createSQLQuery(charityString).list();

			 String patientTypeString = " select ptmain.patient_type_name, acc.acc_desc as acnt, subled.sub_led_desc as subled, acc.acc_id , " +
			 		" subled.sub_led_id,subgrp.account_sub_group_id,grp.account_group_id, (select ifnull(sum(ifnull(os_amt,0.0)),0.0) as ip_amt " +
			 		" from bl_final_bill_details finaldetail left join bl_charge_slip_main main on main.final_bill_id =finaldetail.final_bill_details_id left join mas_patient_type pt " +
			 		" on pt.patient_type_id = main.patient_type_id where pt.patient_type_code not in('COM','PRJ') and pt.acc_id is not null and " +
			 		" final_bill_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and pt.status='y' and ptmain.patient_type_id=main.patient_type_id )+ " +
			 		" (select  ifnull(sum(ifnull(outstanding,0.0)),0) as ip_amt from bl_final_bill_details finaldetail left join bl_dispensing_header main on " +
			 		" main.ip_final_bill_id =finaldetail.final_bill_details_id left join mas_patient_type pt on pt.patient_type_id = main.patient_type_id where " +
			 		" pt.patient_type_code not in('COM','PRJ') and pt.acc_id is not null  and main.inpatient_id is not null and final_bill_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' " +
			 		"  and pt.status='y'and ptmain.patient_type_id=main.patient_type_id ) as onacc from " +
			 		" mas_patient_type ptmain left join fa_mas_account acc on acc.acc_id = ptmain.acc_id left join fa_mas_sub_led subled on subled.sub_led_id = ptmain.sub_led_id " +
			 		" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
			 		" where  ptmain.patient_type_code not in('COM','PRJ') and ptmain.acc_id is not null and ptmain.status='y' " +
			 		" union " +
			 		" select ptmain.patient_type_name, (select acc_desc from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id where " +
			 		" account_type='Mis.Account') as acnt, (select sub_led_desc from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
			 		" where account_type='Mis.Account') as subled, (select acc.acc_id  from fa_accounts_parameter fp " +
			 		" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Mis.Account') as acc_id, (select subled.sub_led_id from fa_accounts_parameter fp left join fa_mas_sub_led subled " +
			 		" on subled.sub_led_id = fp.sub_led_id where account_type='Mis.Account') as sub_led_id, (select subgrp.account_sub_group_id from " +
			 		" fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
			 		" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id  where account_type='Mis.Account') as account_sub_group," +
			 		" (select grp.account_group_id from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
			 		" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
			 		" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where account_type='Mis.Account') as account_group, " +
			 		" (select ifnull(sum(ifnull(os_amt,0.0)),0.0) as ip_amt from bl_final_bill_details finaldetail " +
			 		" left join bl_charge_slip_main main on main.final_bill_id =finaldetail.final_bill_details_id left join mas_patient_type pt " +
			 		" on pt.patient_type_id = main.patient_type_id where  pt.patient_type_code not in('COM','PRJ') and pt.acc_id is null and final_bill_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and pt.status='y' " +
			 		" and ptmain.patient_type_id=main.patient_type_id )+ (select  ifnull(sum(ifnull(outstanding,0.0)),0) as ip_amt from bl_final_bill_details finaldetail " +
			 		" left join  bl_dispensing_header as obh on obh.ip_final_bill_id =finaldetail.final_bill_details_id " +
			 		" left join mas_patient_type pt on pt.patient_type_id = obh.patient_type_id where  pt.patient_type_code " +
			 		" not in('COM','PRJ') and obh.inpatient_id is not null and pt.acc_id is null and  final_bill_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and pt.status='y' " +
			 		" and ptmain.patient_type_id=obh.patient_type_id ) as onacc from mas_patient_type ptmain where  ptmain.patient_type_code not in('COM','PRJ') " +
			 		" and ptmain.acc_id is null and status='y';";
			 patientTypeAmountList = session.createSQLQuery(patientTypeString).list();


		} catch (HibernateException e) {
			// TODO Auto-gen0erated catch block
			e.printStackTrace();
		}
		map.put("mainChargeAmountList", mainChargeAmountList);
		map.put("salesMedicineAmountList", salesMedicineAmountList);
		map.put("companyAmountList", companyAmountList);
		map.put("cashAmountList", cashAmountList);
		map.put("bankAmountList", bankAmountList);
		map.put("creditCardAmountList", creditCardAmountList);
		map.put("stdAmountList", stdAmountList);
		map.put("discountAmountList", discountAmountList);
		map.put("charityAmountList", charityAmountList);
		map.put("roundOffAmountList", roundOffAmountList);
		map.put("patientTypeAmountList", patientTypeAmountList);
		return map;
	}
	public Map<String, Object> postSalesIpVoucherMapping(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<FaMasAccount> accList = new ArrayList<FaMasAccount>();
		List<FaMasAccount> maxAccountIdList = new ArrayList<FaMasAccount>();
		List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
		List<BlOpBillHeader> opBilHeaderList = new ArrayList<BlOpBillHeader>();
		List<BlReceiptHeader> receiptHeaderList = new ArrayList<BlReceiptHeader>();
		List<FaBranchAccountMaster> branchAccountMasterList = new ArrayList<FaBranchAccountMaster>();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session)getSession();
		Transaction tx = null;
		boolean saved = false;


		try {
			tx = session.beginTransaction();
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			String fromDate4MySQL = "";
			String toDate4MySQL = "";
			int voucherNo = 0;
			try {
				fromDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(FROM_DATE)));
				 toDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(TO_DATE)));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			opBilHeaderList = session.createCriteria(BlOpBillHeader.class).add(Restrictions.between("BillDate", java.sql.Date.valueOf(fromDate4MySQL), java.sql.Date.valueOf(toDate4MySQL))).list();
			receiptHeaderList = session.createCriteria(BlReceiptHeader.class).add(Restrictions.between("ReceiptDate", java.sql.Date.valueOf(fromDate4MySQL), java.sql.Date.valueOf(toDate4MySQL))).list();


			FaVoucherHeader faVoucherHeader = new FaVoucherHeader();
			MasHospital masHospital = new MasHospital();
			masHospital.setId( box.getInt("hospitalId"));
			faVoucherHeader.setHospital(masHospital);
			faVoucherHeader.setVoucherDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			faVoucherHeader.setNarration(box.getString(NARRATION));
			Users users = new Users();
			users.setId( box.getInt("changedBy"));
			faVoucherHeader.setLastChgBy(users);
			faVoucherHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			faVoucherHeader.setLastChgTime(box.getString(CHANGED_TIME));
			faVoucherHeader.setVoucherType("SV");
			faVoucherHeader.setStatus("y");
			BigDecimal totalAmountDr = new BigDecimal(0.0);
			BigDecimal totalAmountCr = new BigDecimal(0.0);
			if (!box.getString(TOTAL_DR_AMOUNT).equals("")) {
				totalAmountDr = new BigDecimal(box.getString(TOTAL_DR_AMOUNT));
				faVoucherHeader.setDrAmount(totalAmountDr);
			}
			if (!box.getString(TOTAL_CR_AMOUNT).equals("")) {
				totalAmountCr = new BigDecimal(box.getString(TOTAL_CR_AMOUNT));
				faVoucherHeader.setCrAmount(totalAmountCr);
			}
			MasStoreFinancial masStoreFinancial = new MasStoreFinancial();
			masStoreFinancial.setId(box.getInt("fYear"));
			faVoucherHeader.setFYear(masStoreFinancial);
			paramMap.put("suffix", box.getString("fYearDesc"));
			paramMap.put("flag", "save");
			paramMap.put("prefix", "SV");
			paramMap.put("voucherType", "Sales");
			 voucherNo = generateVoucherNo(paramMap);
			 String locationCode="";
				String yearDesc="";
				List<MasStoreFinancial>financialList=new ArrayList<MasStoreFinancial>();
				List<MasHospital>hospitalList=new ArrayList<MasHospital>();
				hospitalList=session.createCriteria(MasHospital.class).add(Restrictions.idEq(box.getInt("locationId"))).list();
				for(MasHospital mg:hospitalList){
					locationCode=mg.getHospitalCode();
				}
				financialList=session.createCriteria(MasStoreFinancial.class).add(Restrictions.idEq(box.getInt("fYear"))).list();
				for(MasStoreFinancial msf1:financialList){
					yearDesc=msf1.getYearDescription();
				}
				faVoucherHeader.setVoucherNo("SV/"+locationCode+"/"+yearDesc+"/"+voucherNo);

			hbt.save(faVoucherHeader);
			map.put("voucherType", faVoucherHeader.getVoucherType());
//======================================
			/*if(opBilHeaderList.size()>0){
				for(BlOpBillHeader opBillHeader : opBilHeaderList){
					int opBilingId = opBillHeader.getId();
					BlOpBillHeader opBillHeader2= (BlOpBillHeader)hbt.load(BlOpBillHeader.class, opBilingId);
					opBillHeader2.setVoucherNo(voucherNo);
					hbt.update(opBillHeader2);
				}
			}
			if(receiptHeaderList.size()>0){
				for(BlReceiptHeader receiptHeader : receiptHeaderList){
					int receiptHeaderId = receiptHeader.getId();
					BlReceiptHeader receiptHeader2= (BlReceiptHeader)hbt.load(BlReceiptHeader.class, receiptHeaderId);
					receiptHeader2.setVoucherNo(voucherNo);
					hbt.update(receiptHeader2);
				}
			}*/

			int counter = box.getInt("counter");
			for (int i = 1; i < counter; i++) {
				int accountId = 0;
				BigDecimal crAmt = new BigDecimal(0.00);
				BigDecimal drAmt = new BigDecimal(0.00);

				FaVoucherDetails voucherDetails = new FaVoucherDetails();
				FaMasAccount account = new FaMasAccount();
				accountId = box.getInt("accId"+i);
				account.setId(accountId);
				voucherDetails.setAccount(account);
				voucherDetails.setVoucherHeader(faVoucherHeader);
				if(box.getInt("subLedId"+i) != 0){
					FaMasSubLed subLed= new FaMasSubLed();
					subLed.setId(box.getInt("subLedId"+i));
					voucherDetails.setSubLed(subLed);
				}
				voucherDetails.setReconcile("n");
				if(!box.getString("crAmtId"+i).equals("")){
					crAmt = new BigDecimal(box.getString("crAmtId"+i));
					voucherDetails.setCrAmount(crAmt);
				}

				if(!box.getString("drAmtId"+i).equals("")){
					drAmt = new BigDecimal(box.getString("drAmtId"+i));
					voucherDetails.setDrAmount(drAmt);
				}


				hbt.save(voucherDetails);

				//-------------------------update account group-------------------------------------------------

				BigDecimal groupOpBalanceDr = new BigDecimal(0.0);
				BigDecimal groupOpBalanceCr = new BigDecimal(0.0);
				BigDecimal groupYtdBalanceDr = new BigDecimal(0.0);
				BigDecimal groupYtdBalanceCr = new BigDecimal(0.0);
				BigDecimal drGroupAmount = new BigDecimal(0.0);
				BigDecimal crGroupAmount = new BigDecimal(0.0);

				int groupId = box.getInt("grpId"+i);
				int subGroupId = box.getInt("subGroupId"+i);
				FaMasAccountGroup faMasAccountGroup = (FaMasAccountGroup)hbt.load(FaMasAccountGroup.class, groupId);
				if(faMasAccountGroup.getOpBalanceCr()!= null){
					groupOpBalanceCr =  faMasAccountGroup.getOpBalanceCr();
				}
				if(faMasAccountGroup.getOpBalanceDr()!= null){
					groupOpBalanceDr =  faMasAccountGroup.getOpBalanceDr();
				}
				if(faMasAccountGroup.getYtdAmountDr()!= null){
					groupYtdBalanceDr =  faMasAccountGroup.getYtdAmountDr();
				}
				if(faMasAccountGroup.getYtdAmountCr()!= null){
					groupYtdBalanceCr =  faMasAccountGroup.getYtdAmountCr();
				}
				if(drAmt.compareTo(new BigDecimal(0))>0){
					 groupYtdBalanceDr = groupYtdBalanceDr.add(drAmt);
					 faMasAccountGroup.setYtdAmountDr(groupYtdBalanceDr);
				 }
				if(crAmt.compareTo(new BigDecimal(0))>0){
					 groupYtdBalanceCr = groupYtdBalanceCr.add(crAmt);
					 faMasAccountGroup.setYtdAmountCr(groupYtdBalanceCr);
				 }
				drGroupAmount = groupOpBalanceDr.add(groupYtdBalanceDr);
				crGroupAmount = groupOpBalanceCr.add(groupYtdBalanceCr);
				if(drGroupAmount.compareTo(crGroupAmount)>0){
					faMasAccountGroup.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
				    faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
				}else if(crGroupAmount.compareTo(drGroupAmount)>0){
					faMasAccountGroup.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
				    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
				}else if(crGroupAmount.compareTo(drGroupAmount)==0){
					faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
				    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
				}

			 	hbt.update(faMasAccountGroup);

	//-------------------------update account Sub group-------------------------------------------------

			 	BigDecimal subGroupOPBalanceDr = new BigDecimal(0);
				BigDecimal subGroupOPBalanceCr = new BigDecimal(0);
				BigDecimal subGroupYtdBalanceDr = new BigDecimal(0);
				BigDecimal subGroupYtdBalanceCr = new BigDecimal(0);
				BigDecimal drSubGroupAmount = new BigDecimal(0.0);
				BigDecimal crSubGroupAmount = new BigDecimal(0.0);

				FaMasAccountSubGroup accountSubGroup = (FaMasAccountSubGroup)hbt.load(FaMasAccountSubGroup.class, subGroupId);
				 if(accountSubGroup.getOpBalanceDr()!= null){
					 subGroupOPBalanceDr =  accountSubGroup.getOpBalanceDr();
				 }
				 if(accountSubGroup.getOpBalanceCr()!= null){
					 subGroupOPBalanceCr = accountSubGroup.getOpBalanceCr();
				 }
				 if(accountSubGroup.getYtdAmountDr()!= null){
					 subGroupYtdBalanceDr = accountSubGroup.getYtdAmountDr();
				 }
				 if(accountSubGroup.getYtdAmountCr()!= null){
					 subGroupYtdBalanceCr = accountSubGroup.getYtdAmountCr();
				 }
				 if(drAmt.compareTo(new BigDecimal(0))>0){
					 subGroupYtdBalanceDr = subGroupYtdBalanceDr.add(drAmt);
					 accountSubGroup.setYtdAmountDr(subGroupYtdBalanceDr);
				 }
				 if(crAmt.compareTo(new BigDecimal(0))>0){
					 subGroupYtdBalanceCr = subGroupYtdBalanceCr.add(crAmt);
					 accountSubGroup.setYtdAmountCr(subGroupYtdBalanceCr);
				 }
				 drSubGroupAmount = subGroupOPBalanceDr.add(subGroupYtdBalanceDr);
				 crSubGroupAmount = subGroupOPBalanceCr.add(subGroupYtdBalanceCr);
					if(drGroupAmount.compareTo(crGroupAmount)>0){
						faMasAccountGroup.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
					    faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
					}else if(crGroupAmount.compareTo(drGroupAmount)>0){
						faMasAccountGroup.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
					    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
					}else if(crGroupAmount.compareTo(drGroupAmount)==0){
						faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
					    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
					}

			 	hbt.update(accountSubGroup);

	//-------------------------update account master-------------------------------------------------

				BigDecimal accountOpBalanceDr = new  BigDecimal(0.0);
		 		BigDecimal accountOpBalanceCr = new  BigDecimal(0.0);
		 		BigDecimal accountYtdBalanceDr = new BigDecimal(0.0);
		 		BigDecimal accountYtdBalanceCr = new  BigDecimal(0.0);
		 		BigDecimal drAccountAmount = new BigDecimal(0.0);
		 		BigDecimal crAccountAmount = new  BigDecimal(0.0);
		 		FaMasAccount masAccount = (FaMasAccount)hbt.load(FaMasAccount.class,accountId);
		 		if(masAccount.getOpBalanceDr()!= null){
		 			accountOpBalanceDr =  masAccount.getOpBalanceDr();
		 		}
		 		if(masAccount.getOpBalanceCr()!= null){
		 			accountOpBalanceCr = masAccount.getOpBalanceCr();
		 		}

		 		 if(masAccount.getYtdAmountDr() != null){
		 			 accountYtdBalanceDr = masAccount.getYtdAmountDr();
		 		 }
		 		 if(masAccount.getYtdAmountCr() != null){
		 			accountYtdBalanceCr = masAccount.getYtdAmountCr();
		 		 }
		 		if(drAmt.compareTo(new BigDecimal(0))>0){
					 accountYtdBalanceDr = accountYtdBalanceDr.add(drAmt);
					 masAccount.setYtdAmountDr(accountYtdBalanceDr);
				 }
				 if(crAmt.compareTo(new BigDecimal(0))>0){
					 accountYtdBalanceCr = accountYtdBalanceCr.add(crAmt);
					 masAccount.setYtdAmountCr(accountYtdBalanceCr);
				 }
				 drAccountAmount = accountOpBalanceDr.add(accountYtdBalanceDr);
				 crAccountAmount = accountOpBalanceCr.add(accountYtdBalanceCr);
					if(drAccountAmount.compareTo(crAccountAmount)>0){
						masAccount.setClBalanceDr(drAccountAmount.subtract(crAccountAmount));
						masAccount.setClBalanceCr(new BigDecimal(0.00));
					}else if(crAccountAmount.compareTo(drAccountAmount)>0){
						masAccount.setClBalanceCr(crAccountAmount.subtract(drAccountAmount));
						masAccount.setClBalanceDr(new BigDecimal(0.00));
					}else if(crAccountAmount.compareTo(drAccountAmount)==0){
						masAccount.setClBalanceCr(new BigDecimal(0.00));
						masAccount.setClBalanceDr(new BigDecimal(0.00));
					}


				 hbt.update(masAccount);
//------------------------------------------
				//-------------------------update Branch account master-------------------------------------------------
				 int branchAccountId = 0;
				 int branchSubLedId = 0;
				 branchAccountMasterList = session.createCriteria(FaBranchAccountMaster.class).add(Restrictions.eq("Account.Id", accountId)).list();
				 	if(branchAccountMasterList.size()>0){
				 		for(FaBranchAccountMaster faBranchAccountMaster :branchAccountMasterList){
				 			 branchAccountId = faBranchAccountMaster.getId();
				 		}
				 	}
			 	if(branchAccountId != 0){
					BigDecimal accountBranchOpBalanceDr = new  BigDecimal(0.0);
			 		BigDecimal accountBranchOpBalanceCr = new  BigDecimal(0.0);
			 		BigDecimal accountBranchYtdBalanceDr = new BigDecimal(0.0);
			 		BigDecimal accountBranchYtdBalanceCr = new  BigDecimal(0.0);
			 		BigDecimal drAccountBranchAmount = new BigDecimal(0.0);
			 		BigDecimal crAccountBranchAmount = new  BigDecimal(0.0);
			 		FaBranchAccountMaster faBranchAccountMaster = (FaBranchAccountMaster)hbt.load(FaBranchAccountMaster.class,branchAccountId);
			 		if(faBranchAccountMaster.getOpBalanceDr()!= null){
			 			accountBranchOpBalanceDr =  faBranchAccountMaster.getOpBalanceDr();
			 		}
			 		if(faBranchAccountMaster.getOpBalanceCr()!= null){
			 			accountBranchOpBalanceCr = faBranchAccountMaster.getOpBalanceCr();
			 		}

			 		 if(faBranchAccountMaster.getYtdBalanceDr() != null){
			 			accountBranchYtdBalanceDr = faBranchAccountMaster.getYtdBalanceDr();
			 		 }
			 		 if(faBranchAccountMaster.getYtdBalanceCr() != null){
			 			accountBranchYtdBalanceCr = faBranchAccountMaster.getYtdBalanceCr();
			 		 }
			 		if(drAmt.compareTo(new BigDecimal(0))>0){
			 			accountBranchYtdBalanceDr = accountYtdBalanceDr.add(drAmt);
						 masAccount.setYtdAmountDr(accountYtdBalanceDr);
					 }
					 if(crAmt.compareTo(new BigDecimal(0))>0){
						 accountBranchYtdBalanceCr = accountYtdBalanceCr.add(crAmt);
						 masAccount.setYtdAmountCr(accountYtdBalanceCr);
					 }
					 drAccountBranchAmount = accountBranchOpBalanceDr.add(accountBranchYtdBalanceDr);
					 crAccountBranchAmount = accountBranchOpBalanceCr.add(accountBranchYtdBalanceCr);
						if(drAccountAmount.compareTo(crAccountAmount)>0){
							faBranchAccountMaster.setClBalanceDr(drAccountAmount.subtract(crAccountAmount));
							faBranchAccountMaster.setClBalanceCr(new BigDecimal(0.00));
						}else if(crAccountAmount.compareTo(drAccountAmount)>0){
							faBranchAccountMaster.setClBalanceCr(crAccountAmount.subtract(drAccountAmount));
							faBranchAccountMaster.setClBalanceDr(new BigDecimal(0.00));
						}else if(crAccountAmount.compareTo(drAccountAmount)==0){
							faBranchAccountMaster.setClBalanceCr(new BigDecimal(0.00));
							faBranchAccountMaster.setClBalanceDr(new BigDecimal(0.00));
						}


					 hbt.update(faBranchAccountMaster);

			 	}


				//-----------------------update account sub ledger==================================

				 if(box.getInt("subLedId"+i)!=0){
					 BigDecimal subLedgerOPBalanceCr = new BigDecimal(0.0);
					 BigDecimal subLedgerOPBalanceDr = new BigDecimal(0.0);
					 BigDecimal subLedgerYTDBalanceDr = new BigDecimal(0.0);
					 BigDecimal subLedgerYTDBalanceCr = new BigDecimal(0.0);
					 BigDecimal drAmountSubLedger = new BigDecimal(0.0);
					 BigDecimal crAmountSubLedger = new BigDecimal(0.0);

					 FaMasSubLed subLed= (FaMasSubLed)hbt.load(FaMasSubLed.class, box.getInt("subLedId"+i));
					 if(subLed.getOpBalanceCr()!= null){
						 subLedgerOPBalanceCr =  subLed.getOpBalanceCr();
					 }
					 if(subLed.getOpBalanceDr()!= null){
						 subLedgerOPBalanceDr = subLed.getOpBalanceDr();
					 }

					if(subLed.getYtdAmountCr()!= null){
						subLedgerYTDBalanceCr = subLed.getYtdAmountCr();
					}
					if(subLed.getYtdAmountDr()!= null){
						subLedgerYTDBalanceDr = subLed.getYtdAmountDr();
					}
					if(drAmt.compareTo(new BigDecimal(0))>0){
						subLedgerYTDBalanceDr = subLedgerYTDBalanceDr.add(drAmt);
						subLed.setYtdAmountDr(subLedgerYTDBalanceDr);
					 }
					 if(crAmt.compareTo(new BigDecimal(0))>0){
						 subLedgerYTDBalanceCr = subLedgerYTDBalanceCr.add(crAmt);
						 subLed.setYtdAmountCr(subLedgerYTDBalanceCr);
					 }


					 crAmountSubLedger = subLedgerOPBalanceCr.add(subLedgerYTDBalanceCr);
					drAmountSubLedger = subLedgerOPBalanceDr.add(subLedgerYTDBalanceDr);

					if(drAmountSubLedger.compareTo(crAmountSubLedger)>0){
						subLed.setClBalanceDr(drAmountSubLedger.subtract(crAmountSubLedger));
						subLed.setClBalanceCr(new BigDecimal(0.00));
					}else if(crAmountSubLedger.compareTo(drAmountSubLedger)>0){
						subLed.setClBalanceCr(crAmountSubLedger.subtract(drAmountSubLedger));
						subLed.setClBalanceDr(new BigDecimal(0.00));
					}else if(crAmountSubLedger.compareTo(drAmountSubLedger)==0){
						subLed.setClBalanceCr(new BigDecimal(0.00));
						subLed.setClBalanceDr(new BigDecimal(0.00));
					}
						 hbt.update(subLed);

//=============================================For update Sub Led Branch ===================

						/* BigDecimal subBranchLedgerOPBalanceCr = new BigDecimal(0.0);
						 BigDecimal subBranchLedgerOPBalanceDr = new BigDecimal(0.0);
						 BigDecimal subBranchLedgerYTDBalanceDr = new BigDecimal(0.0);
						 BigDecimal subBranchLedgerYTDBalanceCr = new BigDecimal(0.0);
						 BigDecimal drBranchAmountSubLedger = new BigDecimal(0.0);
						 BigDecimal crBranchAmountSubLedger = new BigDecimal(0.0);
							//-------------------------update Branch account master-------------------------------------------------

						 branchAccountMasterList = session.createCriteria(FaBranchAccountMaster.class).add(Restrictions.eq("Account.Id", accountId)).list();
						 	if(branchAccountMasterList.size()>0){
						 		for(FaBranchAccountMaster faBranchAccountMaster :branchAccountMasterList){
						 			 branchAccountId = faBranchAccountMaster.getId();
						 		}
						 	}

						 FaMasSubLed subLed1 = (FaMasSubLed)hbt.load(FaMasSubLed.class, box.getInt("subLedId"+i));
						 if(subLed1.getOpBalanceCr()!= null){
							 subBranchLedgerOPBalanceCr =  subLed1.getOpBalanceCr();
						 }
						 if(subLed1.getOpBalanceDr()!= null){
							 subBranchLedgerOPBalanceDr = subLed1.getOpBalanceDr();
						 }

						if(subLed1.getYtdAmountCr()!= null){
							subBranchLedgerYTDBalanceCr = subLed1.getYtdAmountCr();
						}
						if(subLed1.getYtdAmountDr()!= null){
							subBranchLedgerYTDBalanceDr = subLed1.getYtdAmountDr();
						}
						if(drAmt.compareTo(new BigDecimal(0))>0){
							subBranchLedgerYTDBalanceDr = subBranchLedgerYTDBalanceDr.add(drAmt);
							subLed.setYtdAmountDr(subBranchLedgerYTDBalanceDr);
						 }
						 if(crAmt.compareTo(new BigDecimal(0))>0){
							 subBranchLedgerYTDBalanceCr = subBranchLedgerYTDBalanceCr.add(crAmt);
							 subLed.setYtdAmountCr(subBranchLedgerYTDBalanceCr);
						 }


						 crAmountSubLedger = subBranchLedgerOPBalanceCr.add(subBranchLedgerYTDBalanceCr);
						drAmountSubLedger = subBranchLedgerOPBalanceDr.add(subBranchLedgerYTDBalanceDr);

						if(drAmountSubLedger.compareTo(crAmountSubLedger)>0){
							subLed1.setClBalanceDr(drAmountSubLedger.subtract(crAmountSubLedger));
							subLed1.setClBalanceCr(new BigDecimal(0.00));
						}else if(crAmountSubLedger.compareTo(drAmountSubLedger)>0){
							subLed1.setClBalanceCr(crAmountSubLedger.subtract(drAmountSubLedger));
							subLed1.setClBalanceDr(new BigDecimal(0.00));
						}else if(crAmountSubLedger.compareTo(drAmountSubLedger)==0){
							subLed1.setClBalanceCr(new BigDecimal(0.00));
							subLed1.setClBalanceDr(new BigDecimal(0.00));
						}
							 hbt.update(subLed1);*/

				 }
			}
			tx.commit();
			saved = true;

			} catch (RuntimeException e) {
					if (tx != null)
						tx.rollback();
					e.printStackTrace();
				}

				paramMap.put("suffix", box.getString("fYearDesc"));
				paramMap.put("flag", "display");
				paramMap.put("prefix", "SV");
				paramMap.put("voucherType", "Sales");
				int voucherNo = generateVoucherNo(paramMap);
				map.put("voucherNo", voucherNo);
				map.put("saved", saved);
		return map;
	}
	public Map<String, Object> dispalyRefundBillingAmount(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> mainChargeAmountList = new ArrayList<Object[]>();
		List<Object[]> companyAmountList = new ArrayList<Object[]>();
		List<Object[]> cashAmountList  = new ArrayList<Object[]>();
		List<Object[]> bankAmountList  = new ArrayList<Object[]>();
		List<Object[]> creditCardAmountList  = new ArrayList<Object[]>();
		List<Object[]> discountAmountList  = new ArrayList<Object[]>();
		List<Object[]> charityAmountList  = new ArrayList<Object[]>();
		List<Object[]> stdAmountList  = new ArrayList<Object[]>();
		List<Object[]> roundOffAmountList  = new ArrayList<Object[]>();
		List<Object[]> patientTypeAmountList  = new ArrayList<Object[]>();
		List<Object[]> salesMedicineAmountList  = new ArrayList<Object[]>();
		Session session = (Session)getSession();

		try {
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			String fromDate4MySQL = "";
			String toDate4MySQL = "";
			try {
				fromDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(FROM_DATE)));
				 toDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(TO_DATE)));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			//-----------------------For Total Billing--------------------------------------
			String mainChargeQueryString = "select acc.acc_desc,subled.sub_led_desc,mcc.account_id,mcc.sub_led_id, " +
					" main_chargecode_name,mc.main_chargecode_id,subgrp.account_sub_group_id, grp.account_group_id, detail.advice_amt as bill_amt from bl_payment_advice_header header" +
					" inner join bl_payment_advice_details detail on header.payment_advice_header_id=detail.payment_advice_header_id " +
					" left join mas_charge_code mc on detail.charge_id=mc.charge_code_id left join mas_main_chargecode mcc on mc.main_chargecode_id = mcc.main_chargecode_id " +
					" left join fa_mas_account acc on acc.acc_id = mcc.account_id left join fa_mas_sub_led subled on subled.sub_led_id = mcc.sub_led_id " +
					" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where header.payment_advice_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and mcc.account_id " +
					" is not null group by mc.main_chargecode_id " +
					" union " +
					" select (select acc_desc from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" where account_type='Mis.Account') as acnt, " +
					" (select sub_led_desc from fa_accounts_parameter fp " +
					" left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Mis.Account') as subled, " +
					" (select acc_id from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" where account_type='Mis.Account') as account_id, (select sub_led_id from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Mis.Account') as sub_led_id,main_chargecode_name, " +
					"  mc.main_chargecode_id,(select subgrp.account_sub_group_id from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where account_type='Mis.Account') as account_sub_group, " +
					" (select grp.account_group_id from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where account_type='Mis.Account') as account_group, detail.advice_amt as bill_amt " +
					" from bl_payment_advice_header header inner join bl_payment_advice_details detail on " +
					" header.payment_advice_header_id=detail.payment_advice_header_id " +
					" left join mas_charge_code mc on detail.charge_id=mc.charge_code_id " +
					" left join mas_main_chargecode mcc on mc.main_chargecode_id = mcc.main_chargecode_id " +
					" left join fa_mas_account acc on acc.acc_id = mcc.account_id " +
					" left join fa_mas_sub_led subled on subled.sub_led_id = mcc.sub_led_id " +
					" where header.payment_advice_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and mcc.account_id is null group by mc.main_chargecode_id" ;
			mainChargeAmountList = session.createSQLQuery(mainChargeQueryString).list();

			String dispensingQueryString = " select sum(ifnull(total_advice_amt,0)),accountqry.* from " +
					" (select acc_desc,acc_id,sub_led_desc,subled.sub_led_id, grp.account_group_id," +
					" subgrp.account_sub_group_id from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id" +
					" left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
					" left join fa_mas_account_sub_group subgrp on " +
					" acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where account_type='Sales Medicine')as accountqry, " +
					" bl_pymnt_advice_disp_header header where payment_advice_date between " +
					" '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and inpatient_id is null " ;
			salesMedicineAmountList= session.createSQLQuery(dispensingQueryString).list();
			String companyQueryString = "select com.company_name, acc.acc_desc as acnt," +
					" subled.sub_led_desc as subled, acc.acc_id ,subled.sub_led_id," +
					" subgrp.account_sub_group_id,grp.account_group_id, " +
					" (select ifnull(sum(ifnull(on_account_amt,0.0)),0.0) as op_amt " +
					" from bl_payment_advice_header  pah left join " +
					" bl_op_bill_header  obh  on pah.bill_id = obh.op_bill_header_id where patient_type_id =1 " +
					" and obh.company_id is not null and obh.status='y' and obh.company_id=com.company_id " +
					" and payment_advice_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"')+  " +
					" (select  ifnull(sum(ifnull(on_account_amt,0.0)),0) as op_amt " +
					" from bl_pymnt_advice_disp_header adh left join bl_dispensing_header  obh " +
					" on adh.bill_dispensing_id =obh.dispensing_header_id  where patient_type_id =1 " +
					" and obh.company_id is not null and adh.inpatient_id is null and obh.status='y' " +
					" and obh.company_id=com.company_id and payment_advice_date " +
					" between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"') as com_acc " +
					" from mas_company com left join fa_mas_account acc on acc.acc_id = com.account_id " +
					" left join fa_mas_sub_led subled on subled.sub_led_id = com.sub_led_id " +
					" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp " +
					" on subgrp.account_group_id = grp.account_group_id where com.account_id is not null " +
					" union " +
					" select com.company_name, (select acc_desc from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" where account_type='Mis.Account') as acnt, (select sub_led_desc from fa_accounts_parameter fp " +
					" left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
					" where account_type='Mis.Account') as subled, (select acc.acc_id  from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Mis.Account') as acc_id, " +
					" (select subled.sub_led_id from fa_accounts_parameter fp " +
					" left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
					" where account_type='Mis.Account') as sub_led_id, " +
					" (select subgrp.account_sub_group_id from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where account_type='Mis.Account') as account_sub_group, " +
					" (select grp.account_group_id from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" left join fa_mas_account_sub_group subgrp " +
					" on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where account_type='Mis.Account') as account_group, " +
					"(select ifnull(on_account_amt,0.0) as op_amt from bl_payment_advice_header as pah " +
					" left join bl_op_bill_header obh on pah.bill_id = obh.op_bill_header_id " +
					" where patient_type_id =1 and obh.company_id is not null and obh.status='y' " +
					" and obh.company_id=com.company_id and bill_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"')+  " +
					" (select  ifnull(on_account_amt,0.0) as op_amt from bl_pymnt_advice_disp_header adh " +
					" left join bl_dispensing_header  obh on adh.bill_dispensing_id =obh.dispensing_header_id " +
					" where patient_type_id =1 and obh.company_id is not null and adh.inpatient_id is null " +
					" and obh.status='y' and obh.company_id=com.company_id and bill_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"') as com_acc " +
					" from  mas_company com where  com.account_id is null";

				companyAmountList = session.createSQLQuery(companyQueryString).list();

				String cashQueryString = "select sum(ifnull(rd.refund_amount,0))as refundAmt, (select acc_desc from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Cash') as acnt, " +
						" (select sub_led_desc from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
						" where account_type='Cash') as subled, (select acc.acc_id  from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Cash') as acc_id, " +
						" (select subled.sub_led_id from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
						" where account_type='Cash') as sub_led_id, (select subgrp.account_sub_group_id from " +
						" fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
						" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
						" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
						" where account_type='Cash') as account_sub_group, (select grp.account_group_id from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp on " +
						" acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
						" where account_type='Cash') as account_group from  bl_refund_header rh left join bl_refund_details rd on rh.refund_header_id = rd.refund_header_id " +
						" where rh.refund_date  between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and rh.inpatient_id is null and payment_mode='C'";

				cashAmountList = session.createSQLQuery(cashQueryString).list();

				String bankQueryString = "select sum(ifnull(rd.refund_amount,0))as refundAmt, (select acc_desc from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Bank') as acnt, " +
						" (select sub_led_desc from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
						" where account_type='Bank') as subled, (select acc.acc_id  from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Bank') as acc_id, " +
						" (select subled.sub_led_id from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
						" where account_type='Bank') as sub_led_id, (select subgrp.account_sub_group_id from " +
						" fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
						" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
						" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
						" where account_type='Bank') as account_sub_group, (select grp.account_group_id from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp on " +
						" acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
						" where account_type='Bank') as account_group from  bl_refund_header rh left join bl_refund_details rd on rh.refund_header_id = rd.refund_header_id " +
						" where rh.refund_date  between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and rh.inpatient_id is null and payment_mode='Q'";
				bankAmountList = session.createSQLQuery(bankQueryString).list();

			String creditCardQueryString = "select sum(ifnull(rd.refund_amount,0))as refundAmt, (select acc_desc from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Credit Card') as acnt, " +
						" (select sub_led_desc from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
						" where account_type='Credit Card') as subled, (select acc.acc_id  from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Credit Card') as acc_id, " +
						" (select subled.sub_led_id from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
						" where account_type='Credit Card') as sub_led_id, (select subgrp.account_sub_group_id from " +
						" fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
						" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
						" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
						" where account_type='Credit Card') as account_sub_group, (select grp.account_group_id from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp on " +
						" acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
						" where account_type='Credit Card') as account_group from  bl_refund_header rh left join bl_refund_details rd on rh.refund_header_id = rd.refund_header_id " +
						" where rh.refund_date  between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and rh.inpatient_id is null and payment_mode='R'";
				creditCardAmountList = session.createSQLQuery(creditCardQueryString).list();

				String discountString = "select (select ifnull(sum(ifnull(obd.discount_amt,0.0)),0.0) as op_amt " +
						" from bl_payment_advice_header pah left join bl_op_bill_header obh on obh.op_bill_header_id = pah.bill_id " +
						" left join bl_op_bill_details obd on obh.op_bill_header_id = obd.op_bill_header_id " +
						" where payment_advice_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' )+ (select  ifnull(sum(ifnull(dd.discount_amt,0.0)),0) as op_amt " +
						" from bl_pymnt_advice_disp_header adh left join bl_dispensing_header dh on adh.bill_dispensing_id = dh.dispensing_header_id " +
						" left join bl_dispensing_details  dd on dd.dispensing_header_id=dh.dispensing_header_id where adh.inpatient_id is null " +
						" and payment_advice_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' )as dis, " +
						" (select acc_desc from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
						" where account_type='Discount') as disAcc, (select acc.acc_id from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Discount') as disAccId, " +
						" (select sub_led_desc from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
						" where account_type='Discount') as disSubled, (select subled.sub_led_id from fa_accounts_parameter fp " +
						" left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Discount') as disSubledId, " +
						" (select subgrp.account_sub_group_id from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
						" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
						" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where account_type='Discount') as account_sub_group, " +
						" (select grp.account_group_id from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
						" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
						" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where account_type='Discount') as account_group;";

			discountAmountList = session.createSQLQuery(discountString).list();

			String sdString = " select sum(ifnull(std_deduction_gen,0)+ifnull(std_deduction_spl,0))as sd," +
					" (select acc_desc from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" where account_type='Std Deduction') as sdAcc, (select acc.acc_id from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Std Deduction') as sdAccId, " +
					" (select sub_led_desc from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
					" where account_type='Std Deduction') as sdSubled,(select subled.sub_led_id from fa_accounts_parameter fp " +
					" left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Std Deduction') as sdSubledId , " +
					" (select subgrp.account_sub_group_id from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where account_type='Std Deduction') as account_sub_group, (select grp.account_group_id from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp " +
					" on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp " +
					" on subgrp.account_group_id = grp.account_group_id where account_type='Std Deduction') from  bl_payment_advice_header pah " +
					" left join bl_op_bill_header obh on obh.op_bill_header_id = pah.bill_id left join bl_op_bill_details obd on obh.op_bill_header_id = obd.op_bill_header_id " +
					" where payment_advice_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"'";
		 stdAmountList = session.createSQLQuery(sdString).list();

		 String charityString = "select (select ifnull(sum(ifnull(total_advice_charity_amt,0.0)),0.0) as op_amt " +
		 		" from bl_payment_advice_header pah where inpatient_id is null and payment_advice_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' )+ " +
		 		" (select  ifnull(sum(ifnull(total_advice_charity_amt,0.0)),0.0) as op_amt from bl_payment_advice_header pah " +
		 		" where inpatient_id is null and payment_advice_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"')as dis, " +
		 		" (select acc_desc from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
		 		" where account_type='Charity') as disAcc, (select acc.acc_id from fa_accounts_parameter fp " +
		 		" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Charity') as disAccId, " +
		 		" (select sub_led_desc from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
		 		" where account_type='Charity') as disSubled, (select subled.sub_led_id from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
		 		" where account_type='Charity') as disSubledId,(select subgrp.account_sub_group_id from fa_accounts_parameter fp " +
		 		" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp " +
		 		" on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
		 		" where account_type='Charity') as account_sub_group, (select grp.account_group_id from fa_accounts_parameter fp " +
		 		" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp on " +
		 		" acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp " +
		 		" on subgrp.account_group_id = grp.account_group_id where account_type='Charity') as account_group";
		charityAmountList = session.createSQLQuery(charityString).list();

		String roundOffString = "select (select  sum((ifnull(total_refund_amt,0)-round(ifnull(total_refund_amt,0)))) " +
				" as op_amt from bl_refund_header as rh where pymnt_adv_disp_id is null  and refund_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' )+ " +
				" (select sum((ifnull(total_refund_amt,0)-round(ifnull(total_refund_amt,0)))) as op_amt from bl_refund_header as rh " +
				" where inpatient_id is null and pymnt_adv_serv_id is null and refund_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' )as dis, " +
				" (select acc_desc from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
				" where account_type='Round Off') as disAcc, (select acc.acc_id from fa_accounts_parameter fp " +
				" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Round Off') as disAccId, " +
				" (select sub_led_desc from fa_accounts_parameter fp " +
				" left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Round Off') as disSubled, " +
				"(select subled.sub_led_id from fa_accounts_parameter fp " +
				" left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
				" where account_type='Round Off') as disSubledId, (select subgrp.account_sub_group_id from fa_accounts_parameter fp " +
				" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
				" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
				" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
				" where account_type='Round Off') as account_sub_group, (select grp.account_group_id from fa_accounts_parameter fp " +
				" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
				" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
				" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
				" where account_type='Round Off') as account_group;";
	roundOffAmountList = session.createSQLQuery(roundOffString).list();
	String patientTypeString = " select ptmain.patient_type_name, acc.acc_desc as acnt, subled.sub_led_desc as subled, acc.acc_id , " +
			" subled.sub_led_id,subgrp.account_sub_group_id,grp.account_group_id, " +
			" (select ifnull(sum(ifnull(on_account_amt,0.0)),0.0) as op_amt from bl_payment_advice_header as pah " +
			" inner join bl_op_bill_header obh on pah.bill_id=obh.op_bill_header_id left join mas_patient_type pt " +
			" on pt.patient_type_id = obh.patient_type_id where  pt.patient_type_code not in('COM','PRJ') " +
			" and pt.acc_id is not null and  payment_advice_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and pt.status='y' " +
			" and ptmain.patient_type_id=obh.patient_type_id )+ (select  ifnull(sum(ifnull(on_account_amt,0.0)),0) as op_amt " +
			" from bl_pymnt_advice_disp_header as pah inner join bl_dispensing_header as obh " +
			" on pah.bill_dispensing_id=obh.dispensing_header_id left join mas_patient_type pt on pt.patient_type_id = obh.patient_type_id " +
			" where  pt.patient_type_code not in('COM','PRJ') and pah.inpatient_id is null  and pt.acc_id is not null " +
			" and  payment_advice_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and pt.status='y'and ptmain.patient_type_id=obh.patient_type_id ) as onacc " +
			" from mas_patient_type ptmain left join fa_mas_account acc on acc.acc_id = ptmain.acc_id " +
			" left join fa_mas_sub_led subled on subled.sub_led_id = ptmain.sub_led_id " +
			" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
			" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where  ptmain.patient_type_code not in('COM','PRJ') " +
			" and ptmain.acc_id is not null and ptmain.status='y' " +
			" union " +
			" select ptmain.patient_type_name, (select acc_desc from fa_accounts_parameter fp " +
			" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
			" where account_type='Mis.Account') as acnt, (select sub_led_desc from fa_accounts_parameter fp " +
			" left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
			" where account_type='Mis.Account') as subled, " +
			" (select acc.acc_id  from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
			" where account_type='Mis.Account') as acc_id, (select subled.sub_led_id from fa_accounts_parameter fp " +
			" left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
			" where account_type='Mis.Account') as sub_led_id, (select subgrp.account_sub_group_id from fa_accounts_parameter fp " +
			" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
			" left join fa_mas_account_sub_group subgrp " +
			" on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on " +
			" subgrp.account_group_id = grp.account_group_id where account_type='Mis.Account') as account_sub_group, " +
			" (select grp.account_group_id from fa_accounts_parameter fp " +
			" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
			" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
			" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
			" where account_type='Mis.Account') as account_group, " +
			" (select ifnull(sum(ifnull(on_account_amt,0.0)),0.0) as op_amt " +
			" from bl_payment_advice_header as pah inner join bl_op_bill_header obh on pah.bill_id=obh.op_bill_header_id " +
			" left join mas_patient_type pt on pt.patient_type_id = obh.patient_type_id " +
			"  where  pt.patient_type_code not in('COM','PRJ') and pt.acc_id is null and  payment_advice_date " +
			" between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and pt.status='y' and ptmain.patient_type_id=obh.patient_type_id )+ " +
			" (select  ifnull(sum(ifnull(outstanding,0.0)),0) as op_amt from bl_pymnt_advice_disp_header as pah " +
			" inner join bl_dispensing_header as obh on pah.bill_dispensing_id=obh.dispensing_header_id " +
			" left join mas_patient_type pt on pt.patient_type_id = obh.patient_type_id " +
			" where  pt.patient_type_code not in('COM','PRJ') and pah.inpatient_id is null and pt.acc_id is null " +
			" and  payment_advice_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"'  and pt.status='y' and ptmain.patient_type_id=obh.patient_type_id ) as onacc " +
			" from  mas_patient_type ptmain where ptmain.patient_type_code not in('COM','PRJ') and ptmain.acc_id is null and status='y'";
		patientTypeAmountList = session.createSQLQuery(patientTypeString).list();

		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("mainChargeAmountList", mainChargeAmountList);
		map.put("salesMedicineAmountList", salesMedicineAmountList);
		map.put("companyAmountList", companyAmountList);
		map.put("cashAmountList", cashAmountList);
		map.put("bankAmountList", bankAmountList);
		map.put("creditCardAmountList", creditCardAmountList);
		map.put("stdAmountList", stdAmountList);
		map.put("discountAmountList", discountAmountList);
		map.put("charityAmountList", charityAmountList);
		map.put("roundOffAmountList", roundOffAmountList);
		map.put("patientTypeAmountList", patientTypeAmountList);
		return map;
	}
	public Map<String, Object> postRefundVoucherMapping(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<FaMasAccount> accList = new ArrayList<FaMasAccount>();
		List<FaMasAccount> maxAccountIdList = new ArrayList<FaMasAccount>();
		List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
		List<BlPaymentAdviceHeader> paymentAdviceHeaderList = new ArrayList<BlPaymentAdviceHeader>();
		List<BlPymntAdviceDispHeader> paymentAdviceDispensingHeaderList = new ArrayList<BlPymntAdviceDispHeader>();
		List<BlRefundHeader> refundHeaderList = new ArrayList<BlRefundHeader>();
		List<FaBranchAccountMaster> branchAccountMasterList = new ArrayList<FaBranchAccountMaster>();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session)getSession();
		Transaction tx = null;
		boolean saved = false;


		try {
			tx = session.beginTransaction();
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			String fromDate4MySQL = "";
			String toDate4MySQL = "";
			int voucherNo = 0;
			try {
				fromDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(FROM_DATE)));
				 toDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(TO_DATE)));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			paymentAdviceHeaderList = session.createCriteria(BlPaymentAdviceHeader.class).add(Restrictions.between("payment_advice_date", java.sql.Date.valueOf(fromDate4MySQL), java.sql.Date.valueOf(toDate4MySQL))).list();
			paymentAdviceDispensingHeaderList = session.createCriteria(BlPymntAdviceDispHeader.class).add(Restrictions.between("payment_advice_date", java.sql.Date.valueOf(fromDate4MySQL), java.sql.Date.valueOf(toDate4MySQL))).list();
			refundHeaderList = session.createCriteria(BlPymntAdviceDispHeader.class).add(Restrictions.between("payment_advice_date", java.sql.Date.valueOf(fromDate4MySQL), java.sql.Date.valueOf(toDate4MySQL))).list();


			FaVoucherHeader faVoucherHeader = new FaVoucherHeader();
			MasHospital masHospital = new MasHospital();
			masHospital.setId( box.getInt("locationId"));
			faVoucherHeader.setHospital(masHospital);
			faVoucherHeader.setVoucherDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			faVoucherHeader.setNarration(box.getString(NARRATION));
			Users users = new Users();
			users.setId( box.getInt("changedBy"));
			faVoucherHeader.setLastChgBy(users);
			faVoucherHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			faVoucherHeader.setLastChgTime(box.getString(CHANGED_TIME));
			faVoucherHeader.setVoucherType("RE");
			faVoucherHeader.setStatus("y");
			BigDecimal totalAmountDr = new BigDecimal(0.0);
			BigDecimal totalAmountCr = new BigDecimal(0.0);
			if (!box.getString(TOTAL_DR_AMOUNT).equals("")) {
				totalAmountDr = new BigDecimal(box.getString(TOTAL_DR_AMOUNT));
				faVoucherHeader.setDrAmount(totalAmountDr);
			}
			if (!box.getString(TOTAL_CR_AMOUNT).equals("")) {
				totalAmountCr = new BigDecimal(box.getString(TOTAL_CR_AMOUNT));
				faVoucherHeader.setCrAmount(totalAmountCr);
			}
			MasStoreFinancial masStoreFinancial = new MasStoreFinancial();
			masStoreFinancial.setId(box.getInt("fYear"));
			faVoucherHeader.setFYear(masStoreFinancial);
			paramMap.put("suffix", box.getString("fYearDesc"));
			paramMap.put("flag", "save");
			paramMap.put("prefix", "RE");
			paramMap.put("voucherType", "Refund");
			 voucherNo = generateVoucherNo(paramMap);
			 String locationCode="";
				String yearDesc="";
				List<MasStoreFinancial>financialList=new ArrayList<MasStoreFinancial>();
				List<MasHospital>hospitalList=new ArrayList<MasHospital>();
				hospitalList=session.createCriteria(MasHospital.class).add(Restrictions.idEq(box.getInt("locationId"))).list();
				for(MasHospital mg:hospitalList){
					locationCode=mg.getHospitalCode();
				}
				financialList=session.createCriteria(MasStoreFinancial.class).add(Restrictions.idEq(box.getInt("fYear"))).list();
				for(MasStoreFinancial msf1:financialList){
					yearDesc=msf1.getYearDescription();
				}
				faVoucherHeader.setVoucherNo("RE/"+locationCode+"/"+yearDesc+"/"+voucherNo);

			hbt.save(faVoucherHeader);
			map.put("voucherType", faVoucherHeader.getVoucherType());
//======================================
			/*if(paymentAdviceHeaderList.size()>0){
				for(BlPaymentAdviceHeader paymentAdviceHeader : paymentAdviceHeaderList){
					int paymentAdviceHeaderId = paymentAdviceHeader.getId();
					BlPaymentAdviceHeader paymentAdviceHeader2= (BlPaymentAdviceHeader)hbt.load(BlPaymentAdviceHeader.class, paymentAdviceHeaderId);
					paymentAdviceHeader2.setVoucherNo(voucherNo);
					hbt.update(paymentAdviceHeader2);
				}
			}
			if(paymentAdviceDispensingHeaderList.size()>0){
				for(BlPymntAdviceDispHeader pymntAdviceDispHeader: paymentAdviceDispensingHeaderList){
					int pymentAdviceDispensingId = pymntAdviceDispHeader.getId();
					BlPymntAdviceDispHeader pymntAdviceDispHeader2= (BlPymntAdviceDispHeader)hbt.load(BlPymntAdviceDispHeader.class, pymentAdviceDispensingId);
					pymntAdviceDispHeader2.setVoucherNo(voucherNo);
					hbt.update(pymntAdviceDispHeader2);
				}
			}

			if(refundHeaderList.size()>0){
				for(BlRefundHeader refundHeader: refundHeaderList){
					int refundHeaderId  = refundHeader.getId();
					BlRefundHeader refundHeader2= (BlRefundHeader)hbt.load(BlRefundHeader.class, refundHeaderId);
					refundHeader2.setVoucherNo(voucherNo);
					hbt.update(refundHeader2);
				}
			}
*/
			int counter = box.getInt("counter");
			for (int i = 1; i < counter; i++) {
				int accountId = 0;
				BigDecimal crAmt = new BigDecimal(0.00);
				BigDecimal drAmt = new BigDecimal(0.00);

				FaVoucherDetails voucherDetails = new FaVoucherDetails();
				FaMasAccount account = new FaMasAccount();
				accountId = box.getInt("accId"+i);
				account.setId(accountId);
				voucherDetails.setAccount(account);
				voucherDetails.setVoucherHeader(faVoucherHeader);
				if(box.getInt("subLedId"+i) != 0){
					FaMasSubLed subLed= new FaMasSubLed();
					subLed.setId(box.getInt("subLedId"+i));
					voucherDetails.setSubLed(subLed);
				}
				voucherDetails.setReconcile("n");
				if(!box.getString("crAmtId"+i).equals("")){
					crAmt = new BigDecimal(box.getString("crAmtId"+i));
					voucherDetails.setCrAmount(crAmt);
				}

				if(!box.getString("drAmtId"+i).equals("")){
					drAmt = new BigDecimal(box.getString("drAmtId"+i));
					voucherDetails.setDrAmount(drAmt);
				}


				hbt.save(voucherDetails);

				//-------------------------update account group-------------------------------------------------

				BigDecimal groupOpBalanceDr = new BigDecimal(0.0);
				BigDecimal groupOpBalanceCr = new BigDecimal(0.0);
				BigDecimal groupYtdBalanceDr = new BigDecimal(0.0);
				BigDecimal groupYtdBalanceCr = new BigDecimal(0.0);
				BigDecimal drGroupAmount = new BigDecimal(0.0);
				BigDecimal crGroupAmount = new BigDecimal(0.0);

				int groupId = box.getInt("grpId"+i);
				int subGroupId = box.getInt("subGroupId"+i);
				FaMasAccountGroup faMasAccountGroup = (FaMasAccountGroup)hbt.load(FaMasAccountGroup.class, groupId);
				if(faMasAccountGroup.getOpBalanceCr()!= null){
					groupOpBalanceCr =  faMasAccountGroup.getOpBalanceCr();
				}
				if(faMasAccountGroup.getOpBalanceDr()!= null){
					groupOpBalanceDr =  faMasAccountGroup.getOpBalanceDr();
				}
				if(faMasAccountGroup.getYtdAmountDr()!= null){
					groupYtdBalanceDr =  faMasAccountGroup.getYtdAmountDr();
				}
				if(faMasAccountGroup.getYtdAmountCr()!= null){
					groupYtdBalanceCr =  faMasAccountGroup.getYtdAmountCr();
				}
				if(drAmt.compareTo(new BigDecimal(0))>0){
					 groupYtdBalanceDr = groupYtdBalanceDr.add(drAmt);
					 faMasAccountGroup.setYtdAmountDr(groupYtdBalanceDr);
				 }
				if(crAmt.compareTo(new BigDecimal(0))>0){
					 groupYtdBalanceCr = groupYtdBalanceCr.add(crAmt);
					 faMasAccountGroup.setYtdAmountCr(groupYtdBalanceCr);
				 }
				drGroupAmount = groupOpBalanceDr.add(groupYtdBalanceDr);
				crGroupAmount = groupOpBalanceCr.add(groupYtdBalanceCr);
				if(drGroupAmount.compareTo(crGroupAmount)>0){
					faMasAccountGroup.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
				    faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
				}else if(crGroupAmount.compareTo(drGroupAmount)>0){
					faMasAccountGroup.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
				    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
				}else if(crGroupAmount.compareTo(drGroupAmount)==0){
					faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
				    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
				}

			 	hbt.update(faMasAccountGroup);

	//-------------------------update account Sub group-------------------------------------------------

			 	BigDecimal subGroupOPBalanceDr = new BigDecimal(0);
				BigDecimal subGroupOPBalanceCr = new BigDecimal(0);
				BigDecimal subGroupYtdBalanceDr = new BigDecimal(0);
				BigDecimal subGroupYtdBalanceCr = new BigDecimal(0);
				BigDecimal drSubGroupAmount = new BigDecimal(0.0);
				BigDecimal crSubGroupAmount = new BigDecimal(0.0);

				FaMasAccountSubGroup accountSubGroup = (FaMasAccountSubGroup)hbt.load(FaMasAccountSubGroup.class, subGroupId);
				 if(accountSubGroup.getOpBalanceDr()!= null){
					 subGroupOPBalanceDr =  accountSubGroup.getOpBalanceDr();
				 }
				 if(accountSubGroup.getOpBalanceCr()!= null){
					 subGroupOPBalanceCr = accountSubGroup.getOpBalanceCr();
				 }
				 if(accountSubGroup.getYtdAmountDr()!= null){
					 subGroupYtdBalanceDr = accountSubGroup.getYtdAmountDr();
				 }
				 if(accountSubGroup.getYtdAmountCr()!= null){
					 subGroupYtdBalanceCr = accountSubGroup.getYtdAmountCr();
				 }
				 if(drAmt.compareTo(new BigDecimal(0))>0){
					 subGroupYtdBalanceDr = subGroupYtdBalanceDr.add(drAmt);
					 accountSubGroup.setYtdAmountDr(subGroupYtdBalanceDr);
				 }
				 if(crAmt.compareTo(new BigDecimal(0))>0){
					 subGroupYtdBalanceCr = subGroupYtdBalanceCr.add(crAmt);
					 accountSubGroup.setYtdAmountCr(subGroupYtdBalanceCr);
				 }
				 drSubGroupAmount = subGroupOPBalanceDr.add(subGroupYtdBalanceDr);
				 crSubGroupAmount = subGroupOPBalanceCr.add(subGroupYtdBalanceCr);
					if(drGroupAmount.compareTo(crGroupAmount)>0){
						faMasAccountGroup.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
					    faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
					}else if(crGroupAmount.compareTo(drGroupAmount)>0){
						faMasAccountGroup.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
					    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
					}else if(crGroupAmount.compareTo(drGroupAmount)==0){
						faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
					    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
					}

			 	hbt.update(accountSubGroup);

	//-------------------------update account master-------------------------------------------------

				BigDecimal accountOpBalanceDr = new  BigDecimal(0.0);
		 		BigDecimal accountOpBalanceCr = new  BigDecimal(0.0);
		 		BigDecimal accountYtdBalanceDr = new BigDecimal(0.0);
		 		BigDecimal accountYtdBalanceCr = new  BigDecimal(0.0);
		 		BigDecimal drAccountAmount = new BigDecimal(0.0);
		 		BigDecimal crAccountAmount = new  BigDecimal(0.0);
		 		FaMasAccount masAccount = (FaMasAccount)hbt.load(FaMasAccount.class,accountId);
		 		if(masAccount.getOpBalanceDr()!= null){
		 			accountOpBalanceDr =  masAccount.getOpBalanceDr();
		 		}
		 		if(masAccount.getOpBalanceCr()!= null){
		 			accountOpBalanceCr = masAccount.getOpBalanceCr();
		 		}

		 		 if(masAccount.getYtdAmountDr() != null){
		 			 accountYtdBalanceDr = masAccount.getYtdAmountDr();
		 		 }
		 		 if(masAccount.getYtdAmountCr() != null){
		 			accountYtdBalanceCr = masAccount.getYtdAmountCr();
		 		 }
		 		if(drAmt.compareTo(new BigDecimal(0))>0){
					 accountYtdBalanceDr = accountYtdBalanceDr.add(drAmt);
					 masAccount.setYtdAmountDr(accountYtdBalanceDr);
				 }
				 if(crAmt.compareTo(new BigDecimal(0))>0){
					 accountYtdBalanceCr = accountYtdBalanceCr.add(crAmt);
					 masAccount.setYtdAmountCr(accountYtdBalanceCr);
				 }
				 drAccountAmount = accountOpBalanceDr.add(accountYtdBalanceDr);
				 crAccountAmount = accountOpBalanceCr.add(accountYtdBalanceCr);
					if(drAccountAmount.compareTo(crAccountAmount)>0){
						masAccount.setClBalanceDr(drAccountAmount.subtract(crAccountAmount));
						masAccount.setClBalanceCr(new BigDecimal(0.00));
					}else if(crAccountAmount.compareTo(drAccountAmount)>0){
						masAccount.setClBalanceCr(crAccountAmount.subtract(drAccountAmount));
						masAccount.setClBalanceDr(new BigDecimal(0.00));
					}else if(crAccountAmount.compareTo(drAccountAmount)==0){
						masAccount.setClBalanceCr(new BigDecimal(0.00));
						masAccount.setClBalanceDr(new BigDecimal(0.00));
					}


				 hbt.update(masAccount);
//------------------------------------------
				//-------------------------update Branch account master-------------------------------------------------
				 int branchAccountId = 0;
				 int branchSubLedId = 0;
				 branchAccountMasterList = session.createCriteria(FaBranchAccountMaster.class).add(Restrictions.eq("Account.Id", accountId)).list();
				 	if(branchAccountMasterList.size()>0){
				 		for(FaBranchAccountMaster faBranchAccountMaster :branchAccountMasterList){
				 			 branchAccountId = faBranchAccountMaster.getId();
				 		}
				 	}
			 	if(branchAccountId != 0){
					BigDecimal accountBranchOpBalanceDr = new  BigDecimal(0.0);
			 		BigDecimal accountBranchOpBalanceCr = new  BigDecimal(0.0);
			 		BigDecimal accountBranchYtdBalanceDr = new BigDecimal(0.0);
			 		BigDecimal accountBranchYtdBalanceCr = new  BigDecimal(0.0);
			 		BigDecimal drAccountBranchAmount = new BigDecimal(0.0);
			 		BigDecimal crAccountBranchAmount = new  BigDecimal(0.0);
			 		FaBranchAccountMaster faBranchAccountMaster = (FaBranchAccountMaster)hbt.load(FaBranchAccountMaster.class,branchAccountId);
			 		if(faBranchAccountMaster.getOpBalanceDr()!= null){
			 			accountBranchOpBalanceDr =  faBranchAccountMaster.getOpBalanceDr();
			 		}
			 		if(faBranchAccountMaster.getOpBalanceCr()!= null){
			 			accountBranchOpBalanceCr = faBranchAccountMaster.getOpBalanceCr();
			 		}

			 		 if(faBranchAccountMaster.getYtdBalanceDr() != null){
			 			accountBranchYtdBalanceDr = faBranchAccountMaster.getYtdBalanceDr();
			 		 }
			 		 if(faBranchAccountMaster.getYtdBalanceCr() != null){
			 			accountBranchYtdBalanceCr = faBranchAccountMaster.getYtdBalanceCr();
			 		 }
			 		if(drAmt.compareTo(new BigDecimal(0))>0){
			 			accountBranchYtdBalanceDr = accountYtdBalanceDr.add(drAmt);
						 masAccount.setYtdAmountDr(accountYtdBalanceDr);
					 }
					 if(crAmt.compareTo(new BigDecimal(0))>0){
						 accountBranchYtdBalanceCr = accountYtdBalanceCr.add(crAmt);
						 masAccount.setYtdAmountCr(accountYtdBalanceCr);
					 }
					 drAccountBranchAmount = accountBranchOpBalanceDr.add(accountBranchYtdBalanceDr);
					 crAccountBranchAmount = accountBranchOpBalanceCr.add(accountBranchYtdBalanceCr);
						if(drAccountAmount.compareTo(crAccountAmount)>0){
							faBranchAccountMaster.setClBalanceDr(drAccountAmount.subtract(crAccountAmount));
							faBranchAccountMaster.setClBalanceCr(new BigDecimal(0.00));
						}else if(crAccountAmount.compareTo(drAccountAmount)>0){
							faBranchAccountMaster.setClBalanceCr(crAccountAmount.subtract(drAccountAmount));
							faBranchAccountMaster.setClBalanceDr(new BigDecimal(0.00));
						}else if(crAccountAmount.compareTo(drAccountAmount)==0){
							faBranchAccountMaster.setClBalanceCr(new BigDecimal(0.00));
							faBranchAccountMaster.setClBalanceDr(new BigDecimal(0.00));
						}


					 hbt.update(faBranchAccountMaster);

			 	}


				//-----------------------update account sub ledger==================================

				 if(box.getInt("subLedId"+i)!=0){
					 BigDecimal subLedgerOPBalanceCr = new BigDecimal(0.0);
					 BigDecimal subLedgerOPBalanceDr = new BigDecimal(0.0);
					 BigDecimal subLedgerYTDBalanceDr = new BigDecimal(0.0);
					 BigDecimal subLedgerYTDBalanceCr = new BigDecimal(0.0);
					 BigDecimal drAmountSubLedger = new BigDecimal(0.0);
					 BigDecimal crAmountSubLedger = new BigDecimal(0.0);

					 FaMasSubLed subLed= (FaMasSubLed)hbt.load(FaMasSubLed.class, box.getInt("subLedId"+i));
					 if(subLed.getOpBalanceCr()!= null){
						 subLedgerOPBalanceCr =  subLed.getOpBalanceCr();
					 }
					 if(subLed.getOpBalanceDr()!= null){
						 subLedgerOPBalanceDr = subLed.getOpBalanceDr();
					 }

					if(subLed.getYtdAmountCr()!= null){
						subLedgerYTDBalanceCr = subLed.getYtdAmountCr();
					}
					if(subLed.getYtdAmountDr()!= null){
						subLedgerYTDBalanceDr = subLed.getYtdAmountDr();
					}
					if(drAmt.compareTo(new BigDecimal(0))>0){
						subLedgerYTDBalanceDr = subLedgerYTDBalanceDr.add(drAmt);
						subLed.setYtdAmountDr(subLedgerYTDBalanceDr);
					 }
					 if(crAmt.compareTo(new BigDecimal(0))>0){
						 subLedgerYTDBalanceCr = subLedgerYTDBalanceCr.add(crAmt);
						 subLed.setYtdAmountCr(subLedgerYTDBalanceCr);
					 }


					 crAmountSubLedger = subLedgerOPBalanceCr.add(subLedgerYTDBalanceCr);
					drAmountSubLedger = subLedgerOPBalanceDr.add(subLedgerYTDBalanceDr);

					if(drAmountSubLedger.compareTo(crAmountSubLedger)>0){
						subLed.setClBalanceDr(drAmountSubLedger.subtract(crAmountSubLedger));
						subLed.setClBalanceCr(new BigDecimal(0.00));
					}else if(crAmountSubLedger.compareTo(drAmountSubLedger)>0){
						subLed.setClBalanceCr(crAmountSubLedger.subtract(drAmountSubLedger));
						subLed.setClBalanceDr(new BigDecimal(0.00));
					}else if(crAmountSubLedger.compareTo(drAmountSubLedger)==0){
						subLed.setClBalanceCr(new BigDecimal(0.00));
						subLed.setClBalanceDr(new BigDecimal(0.00));
					}
						 hbt.update(subLed);

//=============================================For update Sub Led Branch ===================

						/* BigDecimal subBranchLedgerOPBalanceCr = new BigDecimal(0.0);
						 BigDecimal subBranchLedgerOPBalanceDr = new BigDecimal(0.0);
						 BigDecimal subBranchLedgerYTDBalanceDr = new BigDecimal(0.0);
						 BigDecimal subBranchLedgerYTDBalanceCr = new BigDecimal(0.0);
						 BigDecimal drBranchAmountSubLedger = new BigDecimal(0.0);
						 BigDecimal crBranchAmountSubLedger = new BigDecimal(0.0);
							//-------------------------update Branch account master-------------------------------------------------

						 branchAccountMasterList = session.createCriteria(FaBranchAccountMaster.class).add(Restrictions.eq("Account.Id", accountId)).list();
						 	if(branchAccountMasterList.size()>0){
						 		for(FaBranchAccountMaster faBranchAccountMaster :branchAccountMasterList){
						 			 branchAccountId = faBranchAccountMaster.getId();
						 		}
						 	}

						 FaMasSubLed subLed1 = (FaMasSubLed)hbt.load(FaMasSubLed.class, box.getInt("subLedId"+i));
						 if(subLed1.getOpBalanceCr()!= null){
							 subBranchLedgerOPBalanceCr =  subLed1.getOpBalanceCr();
						 }
						 if(subLed1.getOpBalanceDr()!= null){
							 subBranchLedgerOPBalanceDr = subLed1.getOpBalanceDr();
						 }

						if(subLed1.getYtdAmountCr()!= null){
							subBranchLedgerYTDBalanceCr = subLed1.getYtdAmountCr();
						}
						if(subLed1.getYtdAmountDr()!= null){
							subBranchLedgerYTDBalanceDr = subLed1.getYtdAmountDr();
						}
						if(drAmt.compareTo(new BigDecimal(0))>0){
							subBranchLedgerYTDBalanceDr = subBranchLedgerYTDBalanceDr.add(drAmt);
							subLed.setYtdAmountDr(subBranchLedgerYTDBalanceDr);
						 }
						 if(crAmt.compareTo(new BigDecimal(0))>0){
							 subBranchLedgerYTDBalanceCr = subBranchLedgerYTDBalanceCr.add(crAmt);
							 subLed.setYtdAmountCr(subBranchLedgerYTDBalanceCr);
						 }


						 crAmountSubLedger = subBranchLedgerOPBalanceCr.add(subBranchLedgerYTDBalanceCr);
						drAmountSubLedger = subBranchLedgerOPBalanceDr.add(subBranchLedgerYTDBalanceDr);

						if(drAmountSubLedger.compareTo(crAmountSubLedger)>0){
							subLed1.setClBalanceDr(drAmountSubLedger.subtract(crAmountSubLedger));
							subLed1.setClBalanceCr(new BigDecimal(0.00));
						}else if(crAmountSubLedger.compareTo(drAmountSubLedger)>0){
							subLed1.setClBalanceCr(crAmountSubLedger.subtract(drAmountSubLedger));
							subLed1.setClBalanceDr(new BigDecimal(0.00));
						}else if(crAmountSubLedger.compareTo(drAmountSubLedger)==0){
							subLed1.setClBalanceCr(new BigDecimal(0.00));
							subLed1.setClBalanceDr(new BigDecimal(0.00));
						}
							 hbt.update(subLed1);*/

				 }
			}
			tx.commit();
			saved = true;

			} catch (RuntimeException e) {
					if (tx != null)
						tx.rollback();
					e.printStackTrace();
				}

				paramMap.put("suffix", box.getString("fYearDesc"));
				paramMap.put("flag", "display");
				paramMap.put("prefix", "RE");
				paramMap.put("voucherType", "Refund");
				int voucherNo = generateVoucherNo(paramMap);
				map.put("voucherNo", voucherNo);
				map.put("saved", saved);
		return map;
	}
	public Map<String, Object> displayAdvanceVoucherBillingAmount(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<Object[]> companyAmountList = new ArrayList<Object[]>();
		List<Object[]> cashAmountList  = new ArrayList<Object[]>();
		List<Object[]> bankAmountList  = new ArrayList<Object[]>();
		List<Object[]> creditCardAmountList  = new ArrayList<Object[]>();
		List<Object[]> patientTypeAmountList  = new ArrayList<Object[]>();

		Session session = (Session)getSession();

		try {
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			String fromDate4MySQL = "";
			String toDate4MySQL = "";
			try {
				fromDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(FROM_DATE)));
				 toDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(TO_DATE)));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//-----------------------For Total Billing--------------------------------------
			String companyQueryString = " select com.company_name, acc.acc_desc as acnt, subled.sub_led_desc as subled, " +
					" acc.acc_id , subled.sub_led_id,subgrp.account_sub_group_id,grp.account_group_id, " +
					" (select ifnull(sum(ifnull(rd.amount,0.0)),0.0) as adv_amt from  bl_receipt_details  rd " +
					" left join bl_receipt_header header  on header.receipt_header_id = rd.receipt_header_id " +
					" left join mas_company com on com.company_id = header.company_id " +
					" where header.company_id =1 and header.company_id is not null " +
					" and com.status='y' and header.company_id=com.company_id and header.receipt_date " +
					" between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' ) as com_acc from mas_company com " +
					" left join fa_mas_account acc on acc.acc_id = com.account_id " +
					" left join fa_mas_sub_led subled on subled.sub_led_id = com.sub_led_id " +
					" left join fa_mas_account_sub_group subgrp " +
					" on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where com.account_id is not null " +
					" union " +
					" select com.company_name,(select acc_desc from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" where account_type='Mis.Account') as acnt, (select sub_led_desc from fa_accounts_parameter fp " +
					" left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
					" where account_type='Mis.Account') as subled, " +
					" (select acc.acc_id  from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" where account_type='Mis.Account') as acc_id, " +
					" (select subled.sub_led_id from fa_accounts_parameter fp " +
					" left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
					" where account_type='Mis.Account') as sub_led_id, " +
					" (select subgrp.account_sub_group_id from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" left join fa_mas_account_sub_group subgrp " +
					" on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where account_type='Mis.Account') as account_sub_group, " +
					" (select grp.account_group_id from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" left join fa_mas_account_sub_group subgrp " +
					" on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where account_type='Mis.Account') as account_group," +
					" (select ifnull(sum(ifnull(rd.amount,0.0)),0.0) as adv_amt " +
					" from bl_receipt_details  rd " +
					" left join bl_receipt_header header  on header.receipt_header_id = rd.receipt_header_id left join mas_company com " +
					" on com.company_id = header.company_id where header.company_id =1 " +
					" and header.company_id is not null and com.status='y' " +
					" and header.company_id=com.company_id and header.receipt_date " +
					"  between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' ) as com_acc " +
					" from  mas_company com where  com.account_id is null";

			companyAmountList = session.createSQLQuery(companyQueryString).list();

			String cashQueryString = "select sum(ifnull(rd.amount,0))as advanAmt,(select acc_desc from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Cash') as acnt, " +
					" (select sub_led_desc from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
					" where account_type='Cash') as subled, (select acc.acc_id  from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Cash') as acc_id, " +
					" (select subled.sub_led_id from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
					" where account_type='Cash') as sub_led_id, (select subgrp.account_sub_group_id from fa_accounts_parameter fp" +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp " +
					" on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where account_type='Cash') as account_sub_group, (select grp.account_group_id from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where account_type='Cash') as account_group " +
					" from  bl_receipt_header rh inner join bl_receipt_details rd on rh.receipt_header_id = rd.receipt_header_id " +
					" where rh.receipt_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and  rh.receipt_type ='adv' and  payment_mode='C' ";
			cashAmountList = session.createSQLQuery(cashQueryString).list();
			String bankQueryString = "select sum(ifnull(rd.amount,0))as advanAmt,(select acc_desc from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Bank') as acnt, " +
					" (select sub_led_desc from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
					" where account_type='Bank') as subled, (select acc.acc_id  from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Bank') as acc_id, " +
					" (select subled.sub_led_id from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
					" where account_type='Bank') as sub_led_id, (select subgrp.account_sub_group_id from fa_accounts_parameter fp" +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp " +
					" on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where account_type='Bank') as account_sub_group, (select grp.account_group_id from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where account_type='Bank') as account_group " +
					" from  bl_receipt_header rh inner join bl_receipt_details rd on rh.receipt_header_id = rd.receipt_header_id " +
					" where rh.receipt_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and  rh.receipt_type ='adv' and  payment_mode='Q'";
			bankAmountList = session.createSQLQuery(bankQueryString).list();
			String creditCardQueryString = "select sum(ifnull(rd.amount,0))as advanAmt,(select acc_desc from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Credit Card') as acnt, " +
					" (select sub_led_desc from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
					" where account_type='Credit Card') as subled, (select acc.acc_id  from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Credit Card') as acc_id, " +
					" (select subled.sub_led_id from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
					" where account_type='Credit Card') as sub_led_id, (select subgrp.account_sub_group_id from fa_accounts_parameter fp" +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp " +
					" on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where account_type='Credit Card') as account_sub_group, (select grp.account_group_id from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where account_type='Credit Card') as account_group " +
					" from  bl_receipt_header rh inner join bl_receipt_details rd on rh.receipt_header_id = rd.receipt_header_id " +
					" where rh.receipt_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and  rh.receipt_type ='adv' and  payment_mode='R'";
			creditCardAmountList = session.createSQLQuery(creditCardQueryString).list();

			String patientTypeString = " select ptmain.patient_type_name, acc.acc_desc as acnt, subled.sub_led_desc as subled, " +
					" acc.acc_id ,subled.sub_led_id,subgrp.account_sub_group_id,grp.account_group_id, " +
					" (select ifnull(sum(ifnull(rd.amount,0.0)),0.0) as adv_amt from bl_receipt_details  rd " +
					" left join bl_receipt_header header  on header.receipt_header_id = rd.receipt_header_id " +
					" left join mas_patient_type pt on pt.patient_type_id = header.patient_type_id " +
					" where pt.patient_type_code not in('COM','PRJ') and pt.acc_id is not null and " +
					" header.receipt_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and pt.status='y' and receipt_type='adv' " +
					" and ptmain.patient_type_id=header.patient_type_id )as advAcc from mas_patient_type ptmain " +
					" left join fa_mas_account acc on acc.acc_id = ptmain.acc_id " +
					" left join fa_mas_sub_led subled on subled.sub_led_id = ptmain.sub_led_id " +
					" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where  ptmain.patient_type_code not in('COM','PRJ') and ptmain.acc_id is not null and ptmain.status='y' " +
					" union " +
					" select ptmain.patient_type_name, (select acc_desc from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Mis.Account') as acnt," +
					" (select sub_led_desc from fa_accounts_parameter fp left join fa_mas_sub_led subled " +
					" on subled.sub_led_id = fp.sub_led_id where account_type='Mis.Account') as subled, " +
					" (select acc.acc_id  from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" where account_type='Mis.Account') as acc_id, (select subled.sub_led_id from fa_accounts_parameter fp " +
					" left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Mis.Account') as sub_led_id, " +
					" (select subgrp.account_sub_group_id from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where account_type='Mis.Account') as account_sub_group, (select grp.account_group_id from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where account_type='Mis.Account') as account_group, (select ifnull(sum(ifnull(rd.amount,0.0)),0.0) as adv_amt " +
					" from bl_receipt_details  rd left join bl_receipt_header header  on header.receipt_header_id = rd.receipt_header_id left join mas_patient_type pt on pt.patient_type_id = header.patient_type_id " +
					" where  pt.patient_type_code not in('COM','PRJ') and pt.acc_id is null and header.receipt_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' " +
					" and pt.status='y' and ptmain.patient_type_id=header.patient_type_id )as adv_acc " +
					" from mas_patient_type ptmain where  ptmain.patient_type_code not in('COM','PRJ') and ptmain.acc_id is null and status='y'";
		patientTypeAmountList = session.createSQLQuery(patientTypeString).list();



		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("cashAmountList", cashAmountList);
		map.put("bankAmountList", bankAmountList);
		map.put("creditCardAmountList", creditCardAmountList);
		map.put("patientTypeAmountList", patientTypeAmountList);
		map.put("companyAmountList", companyAmountList);

		return map;
	}
	public Map<String, Object> postAdvanceVoucherMapping(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<BlReceiptHeader> receiptHeaderList = new ArrayList<BlReceiptHeader>();

		List<FaBranchAccountMaster> branchAccountMasterList = new ArrayList<FaBranchAccountMaster>();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session)getSession();
		Transaction tx = null;
		boolean saved = false;


		try {
			tx = session.beginTransaction();
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			String fromDate4MySQL = "";
			String toDate4MySQL = "";
			int voucherNo = 0;
			try {
				fromDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(FROM_DATE)));
				 toDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(TO_DATE)));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			receiptHeaderList = session.createCriteria(BlReceiptHeader.class).add(Restrictions.between("ReceiptDate", java.sql.Date.valueOf(fromDate4MySQL), java.sql.Date.valueOf(toDate4MySQL))).list();


			FaVoucherHeader faVoucherHeader = new FaVoucherHeader();
			MasHospital masHospital = new MasHospital();
			masHospital.setId( box.getInt("locationId"));
			faVoucherHeader.setHospital(masHospital);
			faVoucherHeader.setVoucherDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			faVoucherHeader.setNarration(box.getString(NARRATION));
			Users users = new Users();
			users.setId( box.getInt("changedBy"));
			faVoucherHeader.setLastChgBy(users);
			faVoucherHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			faVoucherHeader.setLastChgTime(box.getString(CHANGED_TIME));
			faVoucherHeader.setVoucherType("RE");
			faVoucherHeader.setStatus("y");
			BigDecimal totalAmountDr = new BigDecimal(0.0);
			BigDecimal totalAmountCr = new BigDecimal(0.0);
			if (!box.getString(TOTAL_DR_AMOUNT).equals("")) {
				totalAmountDr = new BigDecimal(box.getString(TOTAL_DR_AMOUNT));
				faVoucherHeader.setDrAmount(totalAmountDr);
			}
			if (!box.getString(TOTAL_CR_AMOUNT).equals("")) {
				totalAmountCr = new BigDecimal(box.getString(TOTAL_CR_AMOUNT));
				faVoucherHeader.setCrAmount(totalAmountCr);
			}
			MasStoreFinancial masStoreFinancial = new MasStoreFinancial();
			masStoreFinancial.setId(box.getInt("fYear"));
			faVoucherHeader.setFYear(masStoreFinancial);
			paramMap.put("suffix", box.getString("fYearDesc"));
			paramMap.put("flag", "save");
			paramMap.put("prefix", "AD");
			paramMap.put("voucherType", "Advance");
			 voucherNo = generateVoucherNo(paramMap);
			 String locationCode="";
				String yearDesc="";
				List<MasStoreFinancial>financialList=new ArrayList<MasStoreFinancial>();
				List<MasHospital>hospitalList=new ArrayList<MasHospital>();
				hospitalList=session.createCriteria(MasHospital.class).add(Restrictions.idEq(box.getInt("locationId"))).list();
				for(MasHospital mg:hospitalList){
					locationCode=mg.getHospitalCode();
				}
				financialList=session.createCriteria(MasStoreFinancial.class).add(Restrictions.idEq(box.getInt("fYear"))).list();
				for(MasStoreFinancial msf1:financialList){
					yearDesc=msf1.getYearDescription();
				}
				faVoucherHeader.setVoucherNo("ADV/"+locationCode+"/"+yearDesc+"/"+voucherNo);

			hbt.save(faVoucherHeader);
			map.put("voucherType", faVoucherHeader.getVoucherType());
//======================================
			/*if(receiptHeaderList.size()>0){
				for(BlReceiptHeader receiptHeader : receiptHeaderList){
					int receiptHeaderId = receiptHeader.getId();
					BlReceiptHeader receiptHeader2= (BlReceiptHeader)hbt.load(BlReceiptHeader.class, receiptHeaderId);
					receiptHeader2.setVoucherNo(voucherNo);
					hbt.update(receiptHeader2);
				}
			}*/

			int counter = box.getInt("counter");
			for (int i = 1; i < counter; i++) {
				int accountId = 0;
				BigDecimal crAmt = new BigDecimal(0.00);
				BigDecimal drAmt = new BigDecimal(0.00);

				FaVoucherDetails voucherDetails = new FaVoucherDetails();
				FaMasAccount account = new FaMasAccount();
				accountId = box.getInt("accId"+i);
				account.setId(accountId);
				voucherDetails.setAccount(account);
				voucherDetails.setVoucherHeader(faVoucherHeader);
				if(box.getInt("subLedId"+i) != 0){
					FaMasSubLed subLed= new FaMasSubLed();
					subLed.setId(box.getInt("subLedId"+i));
					voucherDetails.setSubLed(subLed);
				}
				voucherDetails.setReconcile("n");
				if(!box.getString("crAmtId"+i).equals("")){
					crAmt = new BigDecimal(box.getString("crAmtId"+i));
					voucherDetails.setCrAmount(crAmt);
				}

				if(!box.getString("drAmtId"+i).equals("")){
					drAmt = new BigDecimal(box.getString("drAmtId"+i));
					voucherDetails.setDrAmount(drAmt);
				}


				hbt.save(voucherDetails);

				//-------------------------update account group-------------------------------------------------

				BigDecimal groupOpBalanceDr = new BigDecimal(0.0);
				BigDecimal groupOpBalanceCr = new BigDecimal(0.0);
				BigDecimal groupYtdBalanceDr = new BigDecimal(0.0);
				BigDecimal groupYtdBalanceCr = new BigDecimal(0.0);
				BigDecimal drGroupAmount = new BigDecimal(0.0);
				BigDecimal crGroupAmount = new BigDecimal(0.0);

				int groupId = box.getInt("grpId"+i);
				int subGroupId = box.getInt("subGroupId"+i);
				FaMasAccountGroup faMasAccountGroup = (FaMasAccountGroup)hbt.load(FaMasAccountGroup.class, groupId);
				if(faMasAccountGroup.getOpBalanceCr()!= null){
					groupOpBalanceCr =  faMasAccountGroup.getOpBalanceCr();
				}
				if(faMasAccountGroup.getOpBalanceDr()!= null){
					groupOpBalanceDr =  faMasAccountGroup.getOpBalanceDr();
				}
				if(faMasAccountGroup.getYtdAmountDr()!= null){
					groupYtdBalanceDr =  faMasAccountGroup.getYtdAmountDr();
				}
				if(faMasAccountGroup.getYtdAmountCr()!= null){
					groupYtdBalanceCr =  faMasAccountGroup.getYtdAmountCr();
				}
				if(drAmt.compareTo(new BigDecimal(0))>0){
					 groupYtdBalanceDr = groupYtdBalanceDr.add(drAmt);
					 faMasAccountGroup.setYtdAmountDr(groupYtdBalanceDr);
				 }
				if(crAmt.compareTo(new BigDecimal(0))>0){
					 groupYtdBalanceCr = groupYtdBalanceCr.add(crAmt);
					 faMasAccountGroup.setYtdAmountCr(groupYtdBalanceCr);
				 }
				drGroupAmount = groupOpBalanceDr.add(groupYtdBalanceDr);
				crGroupAmount = groupOpBalanceCr.add(groupYtdBalanceCr);
				if(drGroupAmount.compareTo(crGroupAmount)>0){
					faMasAccountGroup.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
				    faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
				}else if(crGroupAmount.compareTo(drGroupAmount)>0){
					faMasAccountGroup.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
				    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
				}else if(crGroupAmount.compareTo(drGroupAmount)==0){
					faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
				    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
				}

			 	hbt.update(faMasAccountGroup);

	//-------------------------update account Sub group-------------------------------------------------

			 	BigDecimal subGroupOPBalanceDr = new BigDecimal(0);
				BigDecimal subGroupOPBalanceCr = new BigDecimal(0);
				BigDecimal subGroupYtdBalanceDr = new BigDecimal(0);
				BigDecimal subGroupYtdBalanceCr = new BigDecimal(0);
				BigDecimal drSubGroupAmount = new BigDecimal(0.0);
				BigDecimal crSubGroupAmount = new BigDecimal(0.0);

				FaMasAccountSubGroup accountSubGroup = (FaMasAccountSubGroup)hbt.load(FaMasAccountSubGroup.class, subGroupId);
				 if(accountSubGroup.getOpBalanceDr()!= null){
					 subGroupOPBalanceDr =  accountSubGroup.getOpBalanceDr();
				 }
				 if(accountSubGroup.getOpBalanceCr()!= null){
					 subGroupOPBalanceCr = accountSubGroup.getOpBalanceCr();
				 }
				 if(accountSubGroup.getYtdAmountDr()!= null){
					 subGroupYtdBalanceDr = accountSubGroup.getYtdAmountDr();
				 }
				 if(accountSubGroup.getYtdAmountCr()!= null){
					 subGroupYtdBalanceCr = accountSubGroup.getYtdAmountCr();
				 }
				 if(drAmt.compareTo(new BigDecimal(0))>0){
					 subGroupYtdBalanceDr = subGroupYtdBalanceDr.add(drAmt);
					 accountSubGroup.setYtdAmountDr(subGroupYtdBalanceDr);
				 }
				 if(crAmt.compareTo(new BigDecimal(0))>0){
					 subGroupYtdBalanceCr = subGroupYtdBalanceCr.add(crAmt);
					 accountSubGroup.setYtdAmountCr(subGroupYtdBalanceCr);
				 }
				 drSubGroupAmount = subGroupOPBalanceDr.add(subGroupYtdBalanceDr);
				 crSubGroupAmount = subGroupOPBalanceCr.add(subGroupYtdBalanceCr);
					if(drGroupAmount.compareTo(crGroupAmount)>0){
						faMasAccountGroup.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
					    faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
					}else if(crGroupAmount.compareTo(drGroupAmount)>0){
						faMasAccountGroup.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
					    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
					}else if(crGroupAmount.compareTo(drGroupAmount)==0){
						faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
					    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
					}

			 	hbt.update(accountSubGroup);

	//-------------------------update account master-------------------------------------------------

				BigDecimal accountOpBalanceDr = new  BigDecimal(0.0);
		 		BigDecimal accountOpBalanceCr = new  BigDecimal(0.0);
		 		BigDecimal accountYtdBalanceDr = new BigDecimal(0.0);
		 		BigDecimal accountYtdBalanceCr = new  BigDecimal(0.0);
		 		BigDecimal drAccountAmount = new BigDecimal(0.0);
		 		BigDecimal crAccountAmount = new  BigDecimal(0.0);
		 		FaMasAccount masAccount = (FaMasAccount)hbt.load(FaMasAccount.class,accountId);
		 		if(masAccount.getOpBalanceDr()!= null){
		 			accountOpBalanceDr =  masAccount.getOpBalanceDr();
		 		}
		 		if(masAccount.getOpBalanceCr()!= null){
		 			accountOpBalanceCr = masAccount.getOpBalanceCr();
		 		}

		 		 if(masAccount.getYtdAmountDr() != null){
		 			 accountYtdBalanceDr = masAccount.getYtdAmountDr();
		 		 }
		 		 if(masAccount.getYtdAmountCr() != null){
		 			accountYtdBalanceCr = masAccount.getYtdAmountCr();
		 		 }
		 		if(drAmt.compareTo(new BigDecimal(0))>0){
					 accountYtdBalanceDr = accountYtdBalanceDr.add(drAmt);
					 masAccount.setYtdAmountDr(accountYtdBalanceDr);
				 }
				 if(crAmt.compareTo(new BigDecimal(0))>0){
					 accountYtdBalanceCr = accountYtdBalanceCr.add(crAmt);
					 masAccount.setYtdAmountCr(accountYtdBalanceCr);
				 }
				 drAccountAmount = accountOpBalanceDr.add(accountYtdBalanceDr);
				 crAccountAmount = accountOpBalanceCr.add(accountYtdBalanceCr);
					if(drAccountAmount.compareTo(crAccountAmount)>0){
						masAccount.setClBalanceDr(drAccountAmount.subtract(crAccountAmount));
						masAccount.setClBalanceCr(new BigDecimal(0.00));
					}else if(crAccountAmount.compareTo(drAccountAmount)>0){
						masAccount.setClBalanceCr(crAccountAmount.subtract(drAccountAmount));
						masAccount.setClBalanceDr(new BigDecimal(0.00));
					}else if(crAccountAmount.compareTo(drAccountAmount)==0){
						masAccount.setClBalanceCr(new BigDecimal(0.00));
						masAccount.setClBalanceDr(new BigDecimal(0.00));
					}


				 hbt.update(masAccount);
//------------------------------------------
				//-------------------------update Branch account master-------------------------------------------------
				 int branchAccountId = 0;
				 int branchSubLedId = 0;
				 branchAccountMasterList = session.createCriteria(FaBranchAccountMaster.class).add(Restrictions.eq("Account.Id", accountId)).list();
				 	if(branchAccountMasterList.size()>0){
				 		for(FaBranchAccountMaster faBranchAccountMaster :branchAccountMasterList){
				 			 branchAccountId = faBranchAccountMaster.getId();
				 		}
				 	}
			 	if(branchAccountId != 0){
					BigDecimal accountBranchOpBalanceDr = new  BigDecimal(0.0);
			 		BigDecimal accountBranchOpBalanceCr = new  BigDecimal(0.0);
			 		BigDecimal accountBranchYtdBalanceDr = new BigDecimal(0.0);
			 		BigDecimal accountBranchYtdBalanceCr = new  BigDecimal(0.0);
			 		BigDecimal drAccountBranchAmount = new BigDecimal(0.0);
			 		BigDecimal crAccountBranchAmount = new  BigDecimal(0.0);
			 		FaBranchAccountMaster faBranchAccountMaster = (FaBranchAccountMaster)hbt.load(FaBranchAccountMaster.class,branchAccountId);
			 		if(faBranchAccountMaster.getOpBalanceDr()!= null){
			 			accountBranchOpBalanceDr =  faBranchAccountMaster.getOpBalanceDr();
			 		}
			 		if(faBranchAccountMaster.getOpBalanceCr()!= null){
			 			accountBranchOpBalanceCr = faBranchAccountMaster.getOpBalanceCr();
			 		}

			 		 if(faBranchAccountMaster.getYtdBalanceDr() != null){
			 			accountBranchYtdBalanceDr = faBranchAccountMaster.getYtdBalanceDr();
			 		 }
			 		 if(faBranchAccountMaster.getYtdBalanceCr() != null){
			 			accountBranchYtdBalanceCr = faBranchAccountMaster.getYtdBalanceCr();
			 		 }
			 		if(drAmt.compareTo(new BigDecimal(0))>0){
			 			accountBranchYtdBalanceDr = accountYtdBalanceDr.add(drAmt);
						 masAccount.setYtdAmountDr(accountYtdBalanceDr);
					 }
					 if(crAmt.compareTo(new BigDecimal(0))>0){
						 accountBranchYtdBalanceCr = accountYtdBalanceCr.add(crAmt);
						 masAccount.setYtdAmountCr(accountYtdBalanceCr);
					 }
					 drAccountBranchAmount = accountBranchOpBalanceDr.add(accountBranchYtdBalanceDr);
					 crAccountBranchAmount = accountBranchOpBalanceCr.add(accountBranchYtdBalanceCr);
						if(drAccountAmount.compareTo(crAccountAmount)>0){
							faBranchAccountMaster.setClBalanceDr(drAccountAmount.subtract(crAccountAmount));
							faBranchAccountMaster.setClBalanceCr(new BigDecimal(0.00));
						}else if(crAccountAmount.compareTo(drAccountAmount)>0){
							faBranchAccountMaster.setClBalanceCr(crAccountAmount.subtract(drAccountAmount));
							faBranchAccountMaster.setClBalanceDr(new BigDecimal(0.00));
						}else if(crAccountAmount.compareTo(drAccountAmount)==0){
							faBranchAccountMaster.setClBalanceCr(new BigDecimal(0.00));
							faBranchAccountMaster.setClBalanceDr(new BigDecimal(0.00));
						}


					 hbt.update(faBranchAccountMaster);

			 	}


				//-----------------------update account sub ledger==================================

				 if(box.getInt("subLedId"+i)!=0){
					 BigDecimal subLedgerOPBalanceCr = new BigDecimal(0.0);
					 BigDecimal subLedgerOPBalanceDr = new BigDecimal(0.0);
					 BigDecimal subLedgerYTDBalanceDr = new BigDecimal(0.0);
					 BigDecimal subLedgerYTDBalanceCr = new BigDecimal(0.0);
					 BigDecimal drAmountSubLedger = new BigDecimal(0.0);
					 BigDecimal crAmountSubLedger = new BigDecimal(0.0);

					 FaMasSubLed subLed= (FaMasSubLed)hbt.load(FaMasSubLed.class, box.getInt("subLedId"+i));
					 if(subLed.getOpBalanceCr()!= null){
						 subLedgerOPBalanceCr =  subLed.getOpBalanceCr();
					 }
					 if(subLed.getOpBalanceDr()!= null){
						 subLedgerOPBalanceDr = subLed.getOpBalanceDr();
					 }

					if(subLed.getYtdAmountCr()!= null){
						subLedgerYTDBalanceCr = subLed.getYtdAmountCr();
					}
					if(subLed.getYtdAmountDr()!= null){
						subLedgerYTDBalanceDr = subLed.getYtdAmountDr();
					}
					if(drAmt.compareTo(new BigDecimal(0))>0){
						subLedgerYTDBalanceDr = subLedgerYTDBalanceDr.add(drAmt);
						subLed.setYtdAmountDr(subLedgerYTDBalanceDr);
					 }
					 if(crAmt.compareTo(new BigDecimal(0))>0){
						 subLedgerYTDBalanceCr = subLedgerYTDBalanceCr.add(crAmt);
						 subLed.setYtdAmountCr(subLedgerYTDBalanceCr);
					 }


					 crAmountSubLedger = subLedgerOPBalanceCr.add(subLedgerYTDBalanceCr);
					drAmountSubLedger = subLedgerOPBalanceDr.add(subLedgerYTDBalanceDr);

					if(drAmountSubLedger.compareTo(crAmountSubLedger)>0){
						subLed.setClBalanceDr(drAmountSubLedger.subtract(crAmountSubLedger));
						subLed.setClBalanceCr(new BigDecimal(0.00));
					}else if(crAmountSubLedger.compareTo(drAmountSubLedger)>0){
						subLed.setClBalanceCr(crAmountSubLedger.subtract(drAmountSubLedger));
						subLed.setClBalanceDr(new BigDecimal(0.00));
					}else if(crAmountSubLedger.compareTo(drAmountSubLedger)==0){
						subLed.setClBalanceCr(new BigDecimal(0.00));
						subLed.setClBalanceDr(new BigDecimal(0.00));
					}
						 hbt.update(subLed);

//=============================================For update Sub Led Branch ===================

						/* BigDecimal subBranchLedgerOPBalanceCr = new BigDecimal(0.0);
						 BigDecimal subBranchLedgerOPBalanceDr = new BigDecimal(0.0);
						 BigDecimal subBranchLedgerYTDBalanceDr = new BigDecimal(0.0);
						 BigDecimal subBranchLedgerYTDBalanceCr = new BigDecimal(0.0);
						 BigDecimal drBranchAmountSubLedger = new BigDecimal(0.0);
						 BigDecimal crBranchAmountSubLedger = new BigDecimal(0.0);
							//-------------------------update Branch account master-------------------------------------------------

						 branchAccountMasterList = session.createCriteria(FaBranchAccountMaster.class).add(Restrictions.eq("Account.Id", accountId)).list();
						 	if(branchAccountMasterList.size()>0){
						 		for(FaBranchAccountMaster faBranchAccountMaster :branchAccountMasterList){
						 			 branchAccountId = faBranchAccountMaster.getId();
						 		}
						 	}

						 FaMasSubLed subLed1 = (FaMasSubLed)hbt.load(FaMasSubLed.class, box.getInt("subLedId"+i));
						 if(subLed1.getOpBalanceCr()!= null){
							 subBranchLedgerOPBalanceCr =  subLed1.getOpBalanceCr();
						 }
						 if(subLed1.getOpBalanceDr()!= null){
							 subBranchLedgerOPBalanceDr = subLed1.getOpBalanceDr();
						 }

						if(subLed1.getYtdAmountCr()!= null){
							subBranchLedgerYTDBalanceCr = subLed1.getYtdAmountCr();
						}
						if(subLed1.getYtdAmountDr()!= null){
							subBranchLedgerYTDBalanceDr = subLed1.getYtdAmountDr();
						}
						if(drAmt.compareTo(new BigDecimal(0))>0){
							subBranchLedgerYTDBalanceDr = subBranchLedgerYTDBalanceDr.add(drAmt);
							subLed.setYtdAmountDr(subBranchLedgerYTDBalanceDr);
						 }
						 if(crAmt.compareTo(new BigDecimal(0))>0){
							 subBranchLedgerYTDBalanceCr = subBranchLedgerYTDBalanceCr.add(crAmt);
							 subLed.setYtdAmountCr(subBranchLedgerYTDBalanceCr);
						 }


						 crAmountSubLedger = subBranchLedgerOPBalanceCr.add(subBranchLedgerYTDBalanceCr);
						drAmountSubLedger = subBranchLedgerOPBalanceDr.add(subBranchLedgerYTDBalanceDr);

						if(drAmountSubLedger.compareTo(crAmountSubLedger)>0){
							subLed1.setClBalanceDr(drAmountSubLedger.subtract(crAmountSubLedger));
							subLed1.setClBalanceCr(new BigDecimal(0.00));
						}else if(crAmountSubLedger.compareTo(drAmountSubLedger)>0){
							subLed1.setClBalanceCr(crAmountSubLedger.subtract(drAmountSubLedger));
							subLed1.setClBalanceDr(new BigDecimal(0.00));
						}else if(crAmountSubLedger.compareTo(drAmountSubLedger)==0){
							subLed1.setClBalanceCr(new BigDecimal(0.00));
							subLed1.setClBalanceDr(new BigDecimal(0.00));
						}
							 hbt.update(subLed1);*/

				 }
			}
			tx.commit();
			saved = true;

			} catch (RuntimeException e) {
					if (tx != null)
						tx.rollback();
					e.printStackTrace();
				}

			paramMap.put("suffix", box.getString("fYearDesc"));
			paramMap.put("flag", "display");
			paramMap.put("prefix", "AD");
			paramMap.put("voucherType", "Advance");
			int voucherNo = generateVoucherNo(paramMap);
			map.put("voucherNo", voucherNo);
			map.put("saved", saved);
		return map;
	}
	public Map<String, Object> dispalyFinalSettlementVoucherAmount(Box box) {
		  Map<String, Object> map = new HashMap<String, Object>();
		  List<Object[]> mainChargeAmountList = new ArrayList<Object[]>();
			List<Object[]> companyRefundAmountList = new ArrayList<Object[]>();
			List<Object[]> companyReceiptAmountList = new ArrayList<Object[]>();
			List<Object[]> cashReceiptAmountList  = new ArrayList<Object[]>();
			List<Object[]> cashRefundAmountList  = new ArrayList<Object[]>();
			List<Object[]> bankReceiptAmountList  = new ArrayList<Object[]>();
			List<Object[]> bankRefundAmountList  = new ArrayList<Object[]>();
			List<Object[]> creditCardReceiptAmountList  = new ArrayList<Object[]>();
			List<Object[]> creditCardRefundAmountList  = new ArrayList<Object[]>();
			List<Object[]> patientTypeReceiptAmountList  = new ArrayList<Object[]>();
			List<Object[]> patientTypeRefundAmountList  = new ArrayList<Object[]>();
			Session session = (Session)getSession();

			try {
				SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
				String fromDate4MySQL = "";
				String toDate4MySQL = "";
				try {
					fromDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(FROM_DATE)));
					 toDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(TO_DATE)));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


				//-----------------------For Total Billing--------------------------------------


				String companyReceiptQueryString = "select com.company_name, acc.acc_desc as acnt, subled.sub_led_desc as subled, " +
						" acc.acc_id , subled.sub_led_id,subgrp.account_sub_group_id,grp.account_group_id, " +
						" (select ifnull(sum(ifnull(detail.amount,0.0)),0.0) as adv_amt from  bl_final_bill_details finalDetail inner join " +
						" bl_receipt_header header on header.ip_final_bill_id = finalDetail.final_bill_details_id " +
						" inner join bl_receipt_details detail on detail.receipt_header_id = header.receipt_header_id " +
						" inner join mas_company com on com.company_id = header.company_id " +
						" where header.company_id =1 and header.company_id is not null and com.status='y' " +
						" and header.company_id=com.company_id and header.receipt_date between '2010-10-01' and '2010-11-15' ) as com_acc from mas_company com " +
						" left join fa_mas_account acc on acc.acc_id = com.account_id left join fa_mas_sub_led subled on subled.sub_led_id = com.sub_led_id " +
						" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
						" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where com.account_id is not null " +
						" union " +
						" select com.company_name,(select acc_desc from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
						" where account_type='Mis.Account') as acnt,(select sub_led_desc from fa_accounts_parameter fp " +
						" left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
						" where account_type='Mis.Account') as subled, (select acc.acc_id  from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Mis.Account') as acc_id, " +
						" (select subled.sub_led_id from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
						" where account_type='Mis.Account') as sub_led_id,(select subgrp.account_sub_group_id from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp " +
						" on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp " +
						" on subgrp.account_group_id = grp.account_group_id where account_type='Mis.Account') as account_sub_group, " +
						" (select grp.account_group_id from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
						" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
						" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where account_type='Mis.Account') as account_group," +
						" (select ifnull(sum(ifnull(detail.amount,0.0)),0.0) as adv_amt from bl_final_bill_details finalDetail inner join " +
						" bl_receipt_header header on header.ip_final_bill_id = finalDetail.final_bill_details_id " +
						" inner join bl_receipt_details detail on detail.receipt_header_id = header.receipt_header_id " +
						" left join mas_company com on com.company_id = header.company_id " +
						" where header.company_id =1 and header.company_id is not null and com.status='y' " +
						" and header.company_id=com.company_id and header.receipt_date between '2010-10-01' and '2010-11-12' ) as com_acc from  mas_company com where  com.account_id is null ";

				companyReceiptAmountList = session.createSQLQuery(companyReceiptQueryString).list();

				String companyRefundQueryString = " select com.company_name, acc.acc_desc as acnt, subled.sub_led_desc as subled, " +
						" acc.acc_id , subled.sub_led_id,subgrp.account_sub_group_id,grp.account_group_id, " +
						" (select ifnull(sum(ifnull(rfDetail.refund_amount,0.0)),0.0) as adv_amt from  bl_refund_details rfDetail inner join " +
						" bl_refund_header header on header.refund_header_id = rfDetail.refund_header_id " +
						" inner join bl_final_bill_details detail on detail.final_bill_details_id = header.final_bill_id " +
						" inner join mas_company com on com.company_id = detail.company_id where detail.company_id =1 and detail.company_id is not null " +
						" and com.status='y' and detail.company_id=com.company_id and header.refund_date between '2010-10-01' and '2010-11-15' ) as com_acc from mas_company com " +
						" left join fa_mas_account acc on acc.acc_id = com.account_id left join fa_mas_sub_led subled on subled.sub_led_id = com.sub_led_id " +
						" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
						" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
						" where com.account_id is not null " +
						" union " +
						" select com.company_name,(select acc_desc from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Mis.Account') as acnt," +
						" (select sub_led_desc from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
						" where account_type='Mis.Account') as subled, (select acc.acc_id  from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Mis.Account') as acc_id, " +
						" (select subled.sub_led_id from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
						" where account_type='Mis.Account') as sub_led_id,(select subgrp.account_sub_group_id from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp " +
						" on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp " +
						" on subgrp.account_group_id = grp.account_group_id where account_type='Mis.Account') as account_sub_group, " +
						" (select grp.account_group_id from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
						" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
						" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id  where account_type='Mis.Account') as account_group," +
						" (select ifnull(sum(ifnull(rfDetail.refund_amount,0.0)),0.0) as adv_amt from  bl_refund_details rfDetail inner join " +
						" bl_refund_header header on header.refund_header_id = rfDetail.refund_header_id inner join bl_final_bill_details detail " +
						" on detail.final_bill_details_id = header.final_bill_id left join mas_company com on com.company_id = detail.company_id " +
						" where detail.company_id =1 and detail.company_id is not null and com.status='y'" +
						" and detail.company_id=com.company_id and header.refund_date between '2010-10-01' and '2010-11-12' ) as com_acc" +
						" from  mas_company com where  com.account_id is null";

		companyRefundAmountList = session.createSQLQuery(companyRefundQueryString).list();


				String cashReceiptQueryString = "select sum(ifnull(rcDetail.amount,0)), (select acc_desc from fa_accounts_parameter fp" +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Cash') as acnt, " +
						" (select sub_led_desc from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
						" where account_type='Cash') as subled, (select acc.acc_id  from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Cash') as acc_id, " +
						" (select subled.sub_led_id from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
						" where account_type='Cash') as sub_led_id, (select subgrp.account_sub_group_id from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp on " +
						" acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
						" where account_type='Cash') as account_sub_group,(select grp.account_group_id from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp " +
						" on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
						" where account_type='Cash') as account_group from bl_final_bill_details blDetail left join bl_receipt_header rh " +
						" on rh.ip_final_bill_id=blDetail.final_bill_details_id inner join bl_receipt_details rcDetail on rcDetail.receipt_header_id = rh.receipt_header_id " +
						" where rh.receipt_date between '2010-10-01' and '2010-11-15' and payment_mode='c' and receipt_type ='fs' ";

				cashReceiptAmountList = session.createSQLQuery(cashReceiptQueryString).list();

				String cashRefundQueryString = "select sum(ifnull(rfDetail.refund_amount,0)),(select acc_desc from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Cash') as acnt, " +
						" (select sub_led_desc from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
						" where account_type='Cash') as subled, " +
						" (select acc.acc_id  from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
						" where account_type='Cash') as acc_id, " +
						" (select subled.sub_led_id from fa_accounts_parameter fp " +
						" left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
						"  where account_type='Cash') as sub_led_id,(select subgrp.account_sub_group_id from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
						" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
						" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
						" where account_type='Cash') as account_sub_group, (select grp.account_group_id from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp" +
						" on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
						" where account_type='Cash') as account_group from bl_final_bill_details blDetail left join bl_refund_header rh " +
						" on rh.final_bill_id=blDetail.final_bill_details_id inner join bl_refund_details rfDetail on rfDetail.refund_header_id = rh.refund_header_id " +
						" where rh.refund_date between '2010-10-01' and '2010-11-15' and payment_mode='c'";

				cashRefundAmountList = session.createSQLQuery(cashRefundQueryString).list();

				String bankQueryReceiptString = "select sum(ifnull(rcDetail.amount,0)), (select acc_desc from fa_accounts_parameter fp" +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Bank') as acnt, " +
						" (select sub_led_desc from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
						" where account_type='Bank') as subled, (select acc.acc_id  from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Bank') as acc_id, " +
						" (select subled.sub_led_id from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
						" where account_type='Bank') as sub_led_id, (select subgrp.account_sub_group_id from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp on " +
						" acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
						" where account_type='Bank') as account_sub_group,(select grp.account_group_id from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp " +
						" on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
						" where account_type='Bank') as account_group from bl_final_bill_details blDetail left join bl_receipt_header rh " +
						" on rh.ip_final_bill_id=blDetail.final_bill_details_id inner join bl_receipt_details rcDetail on rcDetail.receipt_header_id = rh.receipt_header_id " +
						" where rh.receipt_date between '2010-10-01' and '2010-11-15' and payment_mode='Q' and receipt_type ='fs' ";
				bankReceiptAmountList = session.createSQLQuery(bankQueryReceiptString).list();

				String bankQueryRefundString = "select sum(ifnull(rfDetail.refund_amount,0)),(select acc_desc from fa_accounts_parameter fp " +
				" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Bank') as acnt, " +
				" (select sub_led_desc from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
				" where account_type='Bank') as subled, " +
				" (select acc.acc_id  from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
				" where account_type='Bank') as acc_id, " +
				" (select subled.sub_led_id from fa_accounts_parameter fp " +
				" left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
				"  where account_type='Bank') as sub_led_id,(select subgrp.account_sub_group_id from fa_accounts_parameter fp " +
				" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
				" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
				" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
				" where account_type='Bank') as account_sub_group, (select grp.account_group_id from fa_accounts_parameter fp " +
				" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp" +
				" on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
				" where account_type='Bank') as account_group from bl_final_bill_details blDetail left join bl_refund_header rh " +
				" on rh.final_bill_id=blDetail.final_bill_details_id inner join bl_refund_details rfDetail on rfDetail.refund_header_id = rh.refund_header_id " +
				" where rh.refund_date between '2010-10-01' and '2010-11-15' and payment_mode='Q'";
				bankReceiptAmountList = session.createSQLQuery(bankQueryRefundString).list();

				String creditCardReceiptQueryString = "select sum(ifnull(rcDetail.amount,0)), (select acc_desc from fa_accounts_parameter fp" +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Credit Card') as acnt, " +
						" (select sub_led_desc from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
						" where account_type='Credit Card') as subled, (select acc.acc_id  from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Credit Card') as acc_id, " +
						" (select subled.sub_led_id from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
						" where account_type='Credit Card') as sub_led_id, (select subgrp.account_sub_group_id from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp on " +
						" acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
						" where account_type='Credit Card') as account_sub_group,(select grp.account_group_id from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp " +
						" on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
						" where account_type='Credit Card') as account_group from bl_final_bill_details blDetail left join bl_receipt_header rh " +
						" on rh.ip_final_bill_id=blDetail.final_bill_details_id inner join bl_receipt_details rcDetail on rcDetail.receipt_header_id = rh.receipt_header_id " +
						" where rh.receipt_date between '2010-10-01' and '2010-11-15' and payment_mode='R' and receipt_type ='fs'";
				creditCardReceiptAmountList = session.createSQLQuery(creditCardReceiptQueryString).list();

				String creditCardRefundQueryString = "select sum(ifnull(rfDetail.refund_amount,0)),(select acc_desc from fa_accounts_parameter fp " +
				" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Credit Card') as acnt, " +
				" (select sub_led_desc from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
				" where account_type='Credit Card') as subled, " +
				" (select acc.acc_id  from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
				" where account_type='Credit Card') as acc_id, " +
				" (select subled.sub_led_id from fa_accounts_parameter fp " +
				" left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
				"  where account_type='Credit Card') as sub_led_id,(select subgrp.account_sub_group_id from fa_accounts_parameter fp " +
				" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
				" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
				" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
				" where account_type='Credit Card') as account_sub_group, (select grp.account_group_id from fa_accounts_parameter fp " +
				" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp" +
				" on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
				" where account_type='Credit Card') as account_group from bl_final_bill_details blDetail left join bl_refund_header rh " +
				" on rh.final_bill_id=blDetail.final_bill_details_id inner join bl_refund_details rfDetail on rfDetail.refund_header_id = rh.refund_header_id " +
				" where rh.refund_date between '2010-10-01' and '2010-11-15' and payment_mode='R'";
				creditCardRefundAmountList = session.createSQLQuery(creditCardRefundQueryString).list();

				 String patientTypeReceiptString = "select ptmain.patient_type_name, acc.acc_desc as acnt, subled.sub_led_desc as subled," +
				 		" acc.acc_id ,subled.sub_led_id,subgrp.account_sub_group_id,grp.account_group_id, " +
				 		" (select ifnull(sum(ifnull(detail.amount,0.0)),0.0) as adv_amt from bl_receipt_details detail inner join " +
				 		" bl_receipt_header header on header.receipt_header_id = detail.receipt_header_id " +
				 		" inner join bl_final_bill_details finaldetail on finaldetail.final_bill_details_id = header.ip_final_bill_id " +
				 		" left join mas_patient_type pt on pt.patient_type_id = header.patient_type_id where pt.patient_type_code not in('COM','PRJ') " +
				 		" and pt.acc_id is not null and header.receipt_date between '2010-10-01' and '2010-11-15' and pt.status='y' " +
				 		" and receipt_type='fs' and ptmain.patient_type_id=header.patient_type_id )as advAcc " +
				 		" from mas_patient_type ptmain left join fa_mas_account acc on acc.acc_id = ptmain.acc_id " +
				 		" left join fa_mas_sub_led subled on subled.sub_led_id = ptmain.sub_led_id left join fa_mas_account_sub_group subgrp " +
				 		" on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp " +
				 		" on subgrp.account_group_id = grp.account_group_id where  ptmain.patient_type_code not in('COM','PRJ') " +
				 		" and ptmain.acc_id is not null and ptmain.status='y' " +
				 		" union " +
				 		" select ptmain.patient_type_name, (select acc_desc from fa_accounts_parameter fp " +
				 		" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Mis.Account') as acnt," +
				 		" (select sub_led_desc from fa_accounts_parameter fp left join fa_mas_sub_led subled " +
				 		" on subled.sub_led_id = fp.sub_led_id where account_type='Mis.Account') as subled, " +
				 		" (select acc.acc_id  from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
				 		" where account_type='Mis.Account') as acc_id, (select subled.sub_led_id from fa_accounts_parameter fp " +
				 		" left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Mis.Account') as sub_led_id, " +
				 		" (select subgrp.account_sub_group_id from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
				 		" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
				 		" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
				 		" where account_type='Mis.Account') as account_sub_group,(select grp.account_group_id from fa_accounts_parameter fp " +
				 		" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp " +
				 		" on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
				 		" where account_type='Mis.Account') as account_group, (select ifnull(sum(ifnull(detail.amount,0.0)),0.0) as adv_amt " +
				 		" from bl_receipt_details detail inner join bl_receipt_header header on header.receipt_header_id = detail.receipt_header_id " +
				 		" inner join bl_final_bill_details finaldetail on finaldetail.final_bill_details_id = header.ip_final_bill_id " +
				 		" left join mas_patient_type pt on pt.patient_type_id = header.patient_type_id where  pt.patient_type_code not in('COM','PRJ') " +
				 		" and pt.acc_id is null and header.receipt_date between '2010-10-01' and '2010-11-15' and pt.status='y' " +
				 		" and ptmain.patient_type_id=header.patient_type_id )as adv_acc from mas_patient_type ptmain " +
				 		" where  ptmain.patient_type_code not in('COM','PRJ') and ptmain.acc_id is null and status='y'";
				 patientTypeReceiptAmountList = session.createSQLQuery(patientTypeReceiptString).list();

				 String patientTypeRefundString = "select ptmain.patient_type_name, acc.acc_desc as acnt, subled.sub_led_desc as subled, " +
				 		" acc.acc_id ,subled.sub_led_id,subgrp.account_sub_group_id,grp.account_group_id, " +
				 		" (select ifnull(sum(ifnull(detail.refund_amount,0.0)),0.0) as adv_amt from bl_refund_details detail inner join " +
				 		" bl_refund_header header on header.refund_header_id = detail.refund_header_id " +
				 		" inner join bl_final_bill_details finaldetail on finaldetail.final_bill_details_id = header.final_bill_id " +
				 		" left join mas_patient_type pt on pt.patient_type_id = finaldetail.patient_type_id " +
				 		" where pt.patient_type_code not in('COM','PRJ') and pt.acc_id is not null and " +
				 		" header.refund_date between '2010-10-01' and '2010-11-15' and pt.status='y' and header.final_bill_id is not null " +
				 		" and ptmain.patient_type_id=finaldetail.patient_type_id )as advAcc from mas_patient_type ptmain " +
				 		" left join fa_mas_account acc on acc.acc_id = ptmain.acc_id " +
				 		" left join fa_mas_sub_led subled on subled.sub_led_id = ptmain.sub_led_id left join fa_mas_account_sub_group subgrp " +
				 		" on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp " +
				 		" on subgrp.account_group_id = grp.account_group_id where  ptmain.patient_type_code not in('COM','PRJ') " +
				 		" and ptmain.acc_id is not null and ptmain.status='y' " +
				 		" union " +
				 		" select ptmain.patient_type_name, (select acc_desc from fa_accounts_parameter fp " +
				 		" left join fa_mas_account acc on acc.acc_id = fp.account_id where " +
				 		" account_type='Mis.Account') as acnt," +
				 		" (select sub_led_desc from fa_accounts_parameter fp left join fa_mas_sub_led subled " +
				 		" on subled.sub_led_id = fp.sub_led_id " +
				 		" where account_type='Mis.Account') as subled, " +
				 		" (select acc.acc_id  from fa_accounts_parameter fp " +
				 		" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
				 		" where account_type='Mis.Account') as acc_id, " +
				 		" (select subled.sub_led_id from fa_accounts_parameter fp " +
				 		" left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Mis.Account') as sub_led_id, " +
				 		" (select subgrp.account_sub_group_id from fa_accounts_parameter fp " +
				 		" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
				 		" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
				 		" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
				 		" where account_type='Mis.Account') as account_sub_group, " +
				 		" (select grp.account_group_id from fa_accounts_parameter fp " +
				 		" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
				 		" left join fa_mas_account_sub_group subgrp " +
				 		" on acc.account_sub_group_id = subgrp.account_sub_group_id " +
				 		" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
				 		" where account_type='Mis.Account') as account_group, " +
				 		" (select ifnull(sum(ifnull(detail.refund_amount,0.0)),0.0) as adv_amt " +
				 		" from bl_refund_details detail inner join bl_refund_header header " +
				 		"on header.refund_header_id = detail.refund_header_id inner join bl_final_bill_details finaldetail " +
				 		" on finaldetail.final_bill_details_id = header.final_bill_id left join mas_patient_type pt " +
				 		" on pt.patient_type_id = finaldetail.patient_type_id where  pt.patient_type_code not in('COM','PRJ') " +
				 		" and pt.acc_id is null and header.final_bill_id is not null and header.refund_date between '2010-10-01' and '2010-11-15' " +
				 		"and pt.status='y' and ptmain.patient_type_id=finaldetail.patient_type_id )as adv_acc " +
				 		" from mas_patient_type ptmain where  ptmain.patient_type_code not in('COM','PRJ') " +
				 		" and ptmain.acc_id is null and status='y'";
			 patientTypeReceiptAmountList = session.createSQLQuery(patientTypeRefundString).list();

			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			map.put("companyReceiptAmountList", companyReceiptAmountList);
			map.put("companyRefundAmountList", companyRefundAmountList);
			map.put("cashReceiptAmountList", cashReceiptAmountList);
			map.put("cashRefundAmountList", cashRefundAmountList);
			map.put("bankReceiptAmountList", bankReceiptAmountList);
			map.put("bankRefundAmountList", bankRefundAmountList);
			map.put("creditCardReceiptAmountList", creditCardReceiptAmountList);
			map.put("creditCardRefundAmountList", creditCardRefundAmountList);
			map.put("patientTypeReceiptAmountList", patientTypeReceiptAmountList);
			map.put("patientTypeRefundAmountList", patientTypeRefundAmountList);
		return map;
	}
	public Map<String, Object> postFinalSettlementVoucherMapping(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<BlReceiptHeader> receiptHeaderList = new ArrayList<BlReceiptHeader>();

		List<FaBranchAccountMaster> branchAccountMasterList = new ArrayList<FaBranchAccountMaster>();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session)getSession();
		Transaction tx = null;
		boolean saved = false;

		try {
			tx = session.beginTransaction();
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			String fromDate4MySQL = "";
			String toDate4MySQL = "";
			int voucherNo = 0;
			try {
				fromDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(FROM_DATE)));
				 toDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(TO_DATE)));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			receiptHeaderList = session.createCriteria(BlReceiptHeader.class).add(Restrictions.between("ReceiptDate", java.sql.Date.valueOf(fromDate4MySQL), java.sql.Date.valueOf(toDate4MySQL))).list();


			FaVoucherHeader faVoucherHeader = new FaVoucherHeader();
			MasHospital masHospital = new MasHospital();
			masHospital.setId( box.getInt("locationId"));
			faVoucherHeader.setHospital(masHospital);
			faVoucherHeader.setVoucherDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			faVoucherHeader.setNarration(box.getString(NARRATION));
			Users users = new Users();
			users.setId( box.getInt("changedBy"));
			faVoucherHeader.setLastChgBy(users);
			faVoucherHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			faVoucherHeader.setLastChgTime(box.getString(CHANGED_TIME));
			faVoucherHeader.setVoucherType("FS");
			faVoucherHeader.setStatus("y");
			BigDecimal totalAmountDr = new BigDecimal(0.0);
			BigDecimal totalAmountCr = new BigDecimal(0.0);
			if (!box.getString(TOTAL_DR_AMOUNT).equals("")) {
				totalAmountDr = new BigDecimal(box.getString(TOTAL_DR_AMOUNT));
				faVoucherHeader.setDrAmount(totalAmountDr);
			}
			if (!box.getString(TOTAL_CR_AMOUNT).equals("")) {
				totalAmountCr = new BigDecimal(box.getString(TOTAL_CR_AMOUNT));
				faVoucherHeader.setCrAmount(totalAmountCr);
			}
			MasStoreFinancial masStoreFinancial = new MasStoreFinancial();
			masStoreFinancial.setId(box.getInt("fYear"));
			faVoucherHeader.setFYear(masStoreFinancial);
			paramMap.put("suffix", box.getString("fYearDesc"));
			paramMap.put("flag", "save");
			paramMap.put("prefix", "FS");
			paramMap.put("voucherType", "FinalSettlement");
			 voucherNo = generateVoucherNo(paramMap);
			 String locationCode="";
				String yearDesc="";
				List<MasStoreFinancial>financialList=new ArrayList<MasStoreFinancial>();
				List<MasHospital>hospitalList=new ArrayList<MasHospital>();
				hospitalList=session.createCriteria(MasHospital.class).add(Restrictions.idEq(box.getInt("locationId"))).list();
				for(MasHospital mg:hospitalList){
					locationCode=mg.getHospitalCode();
				}
				financialList=session.createCriteria(MasStoreFinancial.class).add(Restrictions.idEq(box.getInt("fYear"))).list();
				for(MasStoreFinancial msf1:financialList){
					yearDesc=msf1.getYearDescription();
				}
				faVoucherHeader.setVoucherNo(locationCode+"/"+yearDesc+"/"+voucherNo);

			hbt.save(faVoucherHeader);
			map.put("voucherType", faVoucherHeader.getVoucherType());
//======================================
			/*if(receiptHeaderList.size()>0){
				for(BlReceiptHeader receiptHeader : receiptHeaderList){
					int receiptHeaderId = receiptHeader.getId();
					BlReceiptHeader receiptHeader2= (BlReceiptHeader)hbt.load(BlReceiptHeader.class, receiptHeaderId);
					receiptHeader2.setVoucherNo(voucherNo);
					hbt.update(receiptHeader2);
				}
			}*/

			int counter = box.getInt("counter");
			for (int i = 1; i < counter; i++) {
				int accountId = 0;
				BigDecimal crAmt = new BigDecimal(0.00);
				BigDecimal drAmt = new BigDecimal(0.00);

				FaVoucherDetails voucherDetails = new FaVoucherDetails();
				FaMasAccount account = new FaMasAccount();
				accountId = box.getInt("accId"+i);
				account.setId(accountId);
				voucherDetails.setAccount(account);
				voucherDetails.setVoucherHeader(faVoucherHeader);
				if(box.getInt("subLedId"+i) != 0){
					FaMasSubLed subLed= new FaMasSubLed();
					subLed.setId(box.getInt("subLedId"+i));
					voucherDetails.setSubLed(subLed);
				}
				voucherDetails.setReconcile("n");
				if(!box.getString("crAmtId"+i).equals("")){
					crAmt = new BigDecimal(box.getString("crAmtId"+i));
					voucherDetails.setCrAmount(crAmt);
				}

				if(!box.getString("drAmtId"+i).equals("")){
					drAmt = new BigDecimal(box.getString("drAmtId"+i));
					voucherDetails.setDrAmount(drAmt);
				}


				hbt.save(voucherDetails);

				//-------------------------update account group-------------------------------------------------

				BigDecimal groupOpBalanceDr = new BigDecimal(0.0);
				BigDecimal groupOpBalanceCr = new BigDecimal(0.0);
				BigDecimal groupYtdBalanceDr = new BigDecimal(0.0);
				BigDecimal groupYtdBalanceCr = new BigDecimal(0.0);
				BigDecimal drGroupAmount = new BigDecimal(0.0);
				BigDecimal crGroupAmount = new BigDecimal(0.0);

				int groupId = box.getInt("grpId"+i);
				int subGroupId = box.getInt("subGroupId"+i);
				FaMasAccountGroup faMasAccountGroup = (FaMasAccountGroup)hbt.load(FaMasAccountGroup.class, groupId);
				if(faMasAccountGroup.getOpBalanceCr()!= null){
					groupOpBalanceCr =  faMasAccountGroup.getOpBalanceCr();
				}
				if(faMasAccountGroup.getOpBalanceDr()!= null){
					groupOpBalanceDr =  faMasAccountGroup.getOpBalanceDr();
				}
				if(faMasAccountGroup.getYtdAmountDr()!= null){
					groupYtdBalanceDr =  faMasAccountGroup.getYtdAmountDr();
				}
				if(faMasAccountGroup.getYtdAmountCr()!= null){
					groupYtdBalanceCr =  faMasAccountGroup.getYtdAmountCr();
				}
				if(drAmt.compareTo(new BigDecimal(0))>0){
					 groupYtdBalanceDr = groupYtdBalanceDr.add(drAmt);
					 faMasAccountGroup.setYtdAmountDr(groupYtdBalanceDr);
				 }
				if(crAmt.compareTo(new BigDecimal(0))>0){
					 groupYtdBalanceCr = groupYtdBalanceCr.add(crAmt);
					 faMasAccountGroup.setYtdAmountCr(groupYtdBalanceCr);
				 }
				drGroupAmount = groupOpBalanceDr.add(groupYtdBalanceDr);
				crGroupAmount = groupOpBalanceCr.add(groupYtdBalanceCr);
				if(drGroupAmount.compareTo(crGroupAmount)>0){
					faMasAccountGroup.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
				    faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
				}else if(crGroupAmount.compareTo(drGroupAmount)>0){
					faMasAccountGroup.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
				    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
				}else if(crGroupAmount.compareTo(drGroupAmount)==0){
					faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
				    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
				}

			 	hbt.update(faMasAccountGroup);

	//-------------------------update account Sub group-------------------------------------------------

			 	BigDecimal subGroupOPBalanceDr = new BigDecimal(0);
				BigDecimal subGroupOPBalanceCr = new BigDecimal(0);
				BigDecimal subGroupYtdBalanceDr = new BigDecimal(0);
				BigDecimal subGroupYtdBalanceCr = new BigDecimal(0);
				BigDecimal drSubGroupAmount = new BigDecimal(0.0);
				BigDecimal crSubGroupAmount = new BigDecimal(0.0);

				FaMasAccountSubGroup accountSubGroup = (FaMasAccountSubGroup)hbt.load(FaMasAccountSubGroup.class, subGroupId);
				 if(accountSubGroup.getOpBalanceDr()!= null){
					 subGroupOPBalanceDr =  accountSubGroup.getOpBalanceDr();
				 }
				 if(accountSubGroup.getOpBalanceCr()!= null){
					 subGroupOPBalanceCr = accountSubGroup.getOpBalanceCr();
				 }
				 if(accountSubGroup.getYtdAmountDr()!= null){
					 subGroupYtdBalanceDr = accountSubGroup.getYtdAmountDr();
				 }
				 if(accountSubGroup.getYtdAmountCr()!= null){
					 subGroupYtdBalanceCr = accountSubGroup.getYtdAmountCr();
				 }
				 if(drAmt.compareTo(new BigDecimal(0))>0){
					 subGroupYtdBalanceDr = subGroupYtdBalanceDr.add(drAmt);
					 accountSubGroup.setYtdAmountDr(subGroupYtdBalanceDr);
				 }
				 if(crAmt.compareTo(new BigDecimal(0))>0){
					 subGroupYtdBalanceCr = subGroupYtdBalanceCr.add(crAmt);
					 accountSubGroup.setYtdAmountCr(subGroupYtdBalanceCr);
				 }
				 drSubGroupAmount = subGroupOPBalanceDr.add(subGroupYtdBalanceDr);
				 crSubGroupAmount = subGroupOPBalanceCr.add(subGroupYtdBalanceCr);
					if(drGroupAmount.compareTo(crGroupAmount)>0){
						faMasAccountGroup.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
					    faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
					}else if(crGroupAmount.compareTo(drGroupAmount)>0){
						faMasAccountGroup.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
					    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
					}else if(crGroupAmount.compareTo(drGroupAmount)==0){
						faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
					    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
					}

			 	hbt.update(accountSubGroup);

	//-------------------------update account master-------------------------------------------------

				BigDecimal accountOpBalanceDr = new  BigDecimal(0.0);
		 		BigDecimal accountOpBalanceCr = new  BigDecimal(0.0);
		 		BigDecimal accountYtdBalanceDr = new BigDecimal(0.0);
		 		BigDecimal accountYtdBalanceCr = new  BigDecimal(0.0);
		 		BigDecimal drAccountAmount = new BigDecimal(0.0);
		 		BigDecimal crAccountAmount = new  BigDecimal(0.0);
		 		FaMasAccount masAccount = (FaMasAccount)hbt.load(FaMasAccount.class,accountId);
		 		if(masAccount.getOpBalanceDr()!= null){
		 			accountOpBalanceDr =  masAccount.getOpBalanceDr();
		 		}
		 		if(masAccount.getOpBalanceCr()!= null){
		 			accountOpBalanceCr = masAccount.getOpBalanceCr();
		 		}

		 		 if(masAccount.getYtdAmountDr() != null){
		 			 accountYtdBalanceDr = masAccount.getYtdAmountDr();
		 		 }
		 		 if(masAccount.getYtdAmountCr() != null){
		 			accountYtdBalanceCr = masAccount.getYtdAmountCr();
		 		 }
		 		if(drAmt.compareTo(new BigDecimal(0))>0){
					 accountYtdBalanceDr = accountYtdBalanceDr.add(drAmt);
					 masAccount.setYtdAmountDr(accountYtdBalanceDr);
				 }
				 if(crAmt.compareTo(new BigDecimal(0))>0){
					 accountYtdBalanceCr = accountYtdBalanceCr.add(crAmt);
					 masAccount.setYtdAmountCr(accountYtdBalanceCr);
				 }
				 drAccountAmount = accountOpBalanceDr.add(accountYtdBalanceDr);
				 crAccountAmount = accountOpBalanceCr.add(accountYtdBalanceCr);
					if(drAccountAmount.compareTo(crAccountAmount)>0){
						masAccount.setClBalanceDr(drAccountAmount.subtract(crAccountAmount));
						masAccount.setClBalanceCr(new BigDecimal(0.00));
					}else if(crAccountAmount.compareTo(drAccountAmount)>0){
						masAccount.setClBalanceCr(crAccountAmount.subtract(drAccountAmount));
						masAccount.setClBalanceDr(new BigDecimal(0.00));
					}else if(crAccountAmount.compareTo(drAccountAmount)==0){
						masAccount.setClBalanceCr(new BigDecimal(0.00));
						masAccount.setClBalanceDr(new BigDecimal(0.00));
					}


				 hbt.update(masAccount);
//------------------------------------------
				//-------------------------update Branch account master-------------------------------------------------
				 int branchAccountId = 0;
				 int branchSubLedId = 0;
				 branchAccountMasterList = session.createCriteria(FaBranchAccountMaster.class).add(Restrictions.eq("Account.Id", accountId)).list();
				 	if(branchAccountMasterList.size()>0){
				 		for(FaBranchAccountMaster faBranchAccountMaster :branchAccountMasterList){
				 			 branchAccountId = faBranchAccountMaster.getId();
				 		}
				 	}
			 	if(branchAccountId != 0){
					BigDecimal accountBranchOpBalanceDr = new  BigDecimal(0.0);
			 		BigDecimal accountBranchOpBalanceCr = new  BigDecimal(0.0);
			 		BigDecimal accountBranchYtdBalanceDr = new BigDecimal(0.0);
			 		BigDecimal accountBranchYtdBalanceCr = new  BigDecimal(0.0);
			 		BigDecimal drAccountBranchAmount = new BigDecimal(0.0);
			 		BigDecimal crAccountBranchAmount = new  BigDecimal(0.0);
			 		FaBranchAccountMaster faBranchAccountMaster = (FaBranchAccountMaster)hbt.load(FaBranchAccountMaster.class,branchAccountId);
			 		if(faBranchAccountMaster.getOpBalanceDr()!= null){
			 			accountBranchOpBalanceDr =  faBranchAccountMaster.getOpBalanceDr();
			 		}
			 		if(faBranchAccountMaster.getOpBalanceCr()!= null){
			 			accountBranchOpBalanceCr = faBranchAccountMaster.getOpBalanceCr();
			 		}

			 		 if(faBranchAccountMaster.getYtdBalanceDr() != null){
			 			accountBranchYtdBalanceDr = faBranchAccountMaster.getYtdBalanceDr();
			 		 }
			 		 if(faBranchAccountMaster.getYtdBalanceCr() != null){
			 			accountBranchYtdBalanceCr = faBranchAccountMaster.getYtdBalanceCr();
			 		 }
			 		if(drAmt.compareTo(new BigDecimal(0))>0){
			 			accountBranchYtdBalanceDr = accountYtdBalanceDr.add(drAmt);
						 masAccount.setYtdAmountDr(accountYtdBalanceDr);
					 }
					 if(crAmt.compareTo(new BigDecimal(0))>0){
						 accountBranchYtdBalanceCr = accountYtdBalanceCr.add(crAmt);
						 masAccount.setYtdAmountCr(accountYtdBalanceCr);
					 }
					 drAccountBranchAmount = accountBranchOpBalanceDr.add(accountBranchYtdBalanceDr);
					 crAccountBranchAmount = accountBranchOpBalanceCr.add(accountBranchYtdBalanceCr);
						if(drAccountAmount.compareTo(crAccountAmount)>0){
							faBranchAccountMaster.setClBalanceDr(drAccountAmount.subtract(crAccountAmount));
							faBranchAccountMaster.setClBalanceCr(new BigDecimal(0.00));
						}else if(crAccountAmount.compareTo(drAccountAmount)>0){
							faBranchAccountMaster.setClBalanceCr(crAccountAmount.subtract(drAccountAmount));
							faBranchAccountMaster.setClBalanceDr(new BigDecimal(0.00));
						}else if(crAccountAmount.compareTo(drAccountAmount)==0){
							faBranchAccountMaster.setClBalanceCr(new BigDecimal(0.00));
							faBranchAccountMaster.setClBalanceDr(new BigDecimal(0.00));
						}


					 hbt.update(faBranchAccountMaster);

			 	}


				//-----------------------update account sub ledger==================================

				 if(box.getInt("subLedId"+i)!=0){
					 BigDecimal subLedgerOPBalanceCr = new BigDecimal(0.0);
					 BigDecimal subLedgerOPBalanceDr = new BigDecimal(0.0);
					 BigDecimal subLedgerYTDBalanceDr = new BigDecimal(0.0);
					 BigDecimal subLedgerYTDBalanceCr = new BigDecimal(0.0);
					 BigDecimal drAmountSubLedger = new BigDecimal(0.0);
					 BigDecimal crAmountSubLedger = new BigDecimal(0.0);

					 FaMasSubLed subLed= (FaMasSubLed)hbt.load(FaMasSubLed.class, box.getInt("subLedId"+i));
					 if(subLed.getOpBalanceCr()!= null){
						 subLedgerOPBalanceCr =  subLed.getOpBalanceCr();
					 }
					 if(subLed.getOpBalanceDr()!= null){
						 subLedgerOPBalanceDr = subLed.getOpBalanceDr();
					 }

					if(subLed.getYtdAmountCr()!= null){
						subLedgerYTDBalanceCr = subLed.getYtdAmountCr();
					}
					if(subLed.getYtdAmountDr()!= null){
						subLedgerYTDBalanceDr = subLed.getYtdAmountDr();
					}
					if(drAmt.compareTo(new BigDecimal(0))>0){
						subLedgerYTDBalanceDr = subLedgerYTDBalanceDr.add(drAmt);
						subLed.setYtdAmountDr(subLedgerYTDBalanceDr);
					 }
					 if(crAmt.compareTo(new BigDecimal(0))>0){
						 subLedgerYTDBalanceCr = subLedgerYTDBalanceCr.add(crAmt);
						 subLed.setYtdAmountCr(subLedgerYTDBalanceCr);
					 }


					 crAmountSubLedger = subLedgerOPBalanceCr.add(subLedgerYTDBalanceCr);
					drAmountSubLedger = subLedgerOPBalanceDr.add(subLedgerYTDBalanceDr);

					if(drAmountSubLedger.compareTo(crAmountSubLedger)>0){
						subLed.setClBalanceDr(drAmountSubLedger.subtract(crAmountSubLedger));
						subLed.setClBalanceCr(new BigDecimal(0.00));
					}else if(crAmountSubLedger.compareTo(drAmountSubLedger)>0){
						subLed.setClBalanceCr(crAmountSubLedger.subtract(drAmountSubLedger));
						subLed.setClBalanceDr(new BigDecimal(0.00));
					}else if(crAmountSubLedger.compareTo(drAmountSubLedger)==0){
						subLed.setClBalanceCr(new BigDecimal(0.00));
						subLed.setClBalanceDr(new BigDecimal(0.00));
					}
						 hbt.update(subLed);

//=============================================For update Sub Led Branch ===================

						/* BigDecimal subBranchLedgerOPBalanceCr = new BigDecimal(0.0);
						 BigDecimal subBranchLedgerOPBalanceDr = new BigDecimal(0.0);
						 BigDecimal subBranchLedgerYTDBalanceDr = new BigDecimal(0.0);
						 BigDecimal subBranchLedgerYTDBalanceCr = new BigDecimal(0.0);
						 BigDecimal drBranchAmountSubLedger = new BigDecimal(0.0);
						 BigDecimal crBranchAmountSubLedger = new BigDecimal(0.0);
							//-------------------------update Branch account master-------------------------------------------------

						 branchAccountMasterList = session.createCriteria(FaBranchAccountMaster.class).add(Restrictions.eq("Account.Id", accountId)).list();
						 	if(branchAccountMasterList.size()>0){
						 		for(FaBranchAccountMaster faBranchAccountMaster :branchAccountMasterList){
						 			 branchAccountId = faBranchAccountMaster.getId();
						 		}
						 	}

						 FaMasSubLed subLed1 = (FaMasSubLed)hbt.load(FaMasSubLed.class, box.getInt("subLedId"+i));
						 if(subLed1.getOpBalanceCr()!= null){
							 subBranchLedgerOPBalanceCr =  subLed1.getOpBalanceCr();
						 }
						 if(subLed1.getOpBalanceDr()!= null){
							 subBranchLedgerOPBalanceDr = subLed1.getOpBalanceDr();
						 }

						if(subLed1.getYtdAmountCr()!= null){
							subBranchLedgerYTDBalanceCr = subLed1.getYtdAmountCr();
						}
						if(subLed1.getYtdAmountDr()!= null){
							subBranchLedgerYTDBalanceDr = subLed1.getYtdAmountDr();
						}
						if(drAmt.compareTo(new BigDecimal(0))>0){
							subBranchLedgerYTDBalanceDr = subBranchLedgerYTDBalanceDr.add(drAmt);
							subLed.setYtdAmountDr(subBranchLedgerYTDBalanceDr);
						 }
						 if(crAmt.compareTo(new BigDecimal(0))>0){
							 subBranchLedgerYTDBalanceCr = subBranchLedgerYTDBalanceCr.add(crAmt);
							 subLed.setYtdAmountCr(subBranchLedgerYTDBalanceCr);
						 }


						 crAmountSubLedger = subBranchLedgerOPBalanceCr.add(subBranchLedgerYTDBalanceCr);
						drAmountSubLedger = subBranchLedgerOPBalanceDr.add(subBranchLedgerYTDBalanceDr);

						if(drAmountSubLedger.compareTo(crAmountSubLedger)>0){
							subLed1.setClBalanceDr(drAmountSubLedger.subtract(crAmountSubLedger));
							subLed1.setClBalanceCr(new BigDecimal(0.00));
						}else if(crAmountSubLedger.compareTo(drAmountSubLedger)>0){
							subLed1.setClBalanceCr(crAmountSubLedger.subtract(drAmountSubLedger));
							subLed1.setClBalanceDr(new BigDecimal(0.00));
						}else if(crAmountSubLedger.compareTo(drAmountSubLedger)==0){
							subLed1.setClBalanceCr(new BigDecimal(0.00));
							subLed1.setClBalanceDr(new BigDecimal(0.00));
						}
							 hbt.update(subLed1);*/

				 }
			}
			tx.commit();
			saved = true;

			} catch (RuntimeException e) {
					if (tx != null)
						tx.rollback();
					e.printStackTrace();
				}

			paramMap.put("suffix", box.getString("fYearDesc"));
			paramMap.put("flag", "display");
			paramMap.put("prefix", "FS");
			paramMap.put("voucherType", "FinalSettlement");
			int voucherNo = generateVoucherNo(paramMap);
			map.put("voucherNo", voucherNo);
			map.put("saved", saved);
		return map;
	}
	public Map<String, Object> closingFinancialYear(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasFinancialYear> prevFinancialYearList = new ArrayList<HrMasFinancialYear>();
		List<FaMasAccount> currentYearAccountList = new ArrayList<FaMasAccount>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		List<FaMasSubLed> sudLedList = new ArrayList<FaMasSubLed>();
		List<FaMasAccountGroup> accountGroupList = new ArrayList<FaMasAccountGroup>();
		List<FaMasAccountSubGroup> accountSubGroupList = new ArrayList<FaMasAccountSubGroup>();
		String finYear = box.getString("finYear");
		int finYearId = box.getInt("fYear");

		String firstYear = finYear.substring(0, 4);
		String lastYear = finYear.substring(2, 4);
		String previousyear = Integer.parseInt(firstYear)-(1)+"-"+lastYear;
		Session session = (Session)getSession();

		prevFinancialYearList = session.createCriteria(HrMasFinancialYear.class).add(Restrictions.eq("FinancialYear", previousyear)).list();
		int fYearId = prevFinancialYearList.get(0).getId();
		currentYearAccountList = session.createCriteria(FaMasAccount.class).add(Restrictions.eq("FYear.Id", finYearId)).list();
		accountList = session.createCriteria(FaMasAccount.class).add(Restrictions.eq("FYear.Id", fYearId)).list();
		int currentYearAccountId = 0;
		int prevYearAccountId = 0;
		
		if(currentYearAccountList.size()>0){
		for(FaMasAccount faMasAccount :currentYearAccountList ){
			 currentYearAccountId = faMasAccount.getId();
		 }
		}
		if(accountList.size()>0){
			for(FaMasAccount acc :accountList){
				prevYearAccountId = acc.getId();
			}
		}
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		int accountId = 0;
		if(currentYearAccountId == prevYearAccountId ){
			if(accountList.size()>0){
				for(FaMasAccount masAccount : accountList){
					int hospitalId = masAccount.getHospital().getId();
					int accCode = masAccount.getAccCode();
					String accDesc = masAccount.getAccDesc();
					int accounSubGroupId = masAccount.getAccountSubGroup().getId();
					String status = masAccount.getStatus();
					int lastChgBy = masAccount.getLastChgBy().getId();
					Date lastChgDate = masAccount.getLastChgDate();
					String lastChgTime = masAccount.getLastChgTime();
					BigDecimal clBalanceCr = masAccount.getClBalanceCr();
					BigDecimal  clBalanceDr = masAccount.getClBalanceDr();
					//String schedule = masAccount.getSchedule();
					int parentId = 0;
					//----------code commented  by anamika on 07/08/2014-----------
					/*if(masAccount.getParent() != null){
						 parentId = masAccount.getParent().getId();
					}*/
					String parentStatus = masAccount.getParentStatus();
					String subLedger = masAccount.getSubLedger();
					FaMasAccount account = (FaMasAccount) hbt.load(FaMasAccount.class,currentYearAccountId);
					MasHospital masHospital = new MasHospital();
					masHospital.setId(hospitalId);
					account.setHospital(masHospital);
					account.setAccCode(accCode);
					account.setAccDesc(accDesc);
					account.setStatus(status);
					//account.setSchedule(schedule);
					account.setOpBalanceCr(clBalanceCr);
					account.setOpBalanceDr(clBalanceDr);
					account.setYtdAmountCr(new BigDecimal(0.00));
					account.setYtdAmountDr(new BigDecimal(0.00));
					account.setClBalanceCr(clBalanceCr);
					account.setClBalanceDr(clBalanceDr);
					account.setParentStatus(parentStatus);
					account.setSubLedger(subLedger);
					account.setLastChgDate(lastChgDate);
					account.setLastChgTime(lastChgTime);
					//----------code commented  by anamika on 07/08/2014-----------
					if(lastChgBy != 0){
						MasEmployee masEmployee = new MasEmployee();
						masEmployee.setId(lastChgBy);
						//account.setLastChgBy(masEmployee);
					}
					if(parentId !=0){
						FaMasAccount acc = new FaMasAccount();
						acc.setId(parentId);
						//account.setParent(acc);
					}
					FaMasAccountSubGroup faMasAccountSubGroup = new FaMasAccountSubGroup();
					faMasAccountSubGroup.setId(accounSubGroupId);
					account.setAccountSubGroup(faMasAccountSubGroup);

					/*HrMasFinancialYear hrMasFinancialYear = new HrMasFinancialYear();
					hrMasFinancialYear.setId(finYearId);
					account.setFYear(hrMasFinancialYear);
*/
					hbt.update(account);


				}
			}

		}else{

		//if(prevFinancialYearList.size()>0){
			if(accountList.size()>0){
				for(FaMasAccount masAccount : accountList){
					int hospitalId = masAccount.getHospital().getId();
					int accCode = masAccount.getAccCode();
					String accDesc = masAccount.getAccDesc();
					int accounSubGroupId = masAccount.getAccountSubGroup().getId();
					String status = masAccount.getStatus();
					int lastChgBy = masAccount.getLastChgBy().getId();
					Date lastChgDate = masAccount.getLastChgDate();
					String lastChgTime = masAccount.getLastChgTime();
					BigDecimal clBalanceCr = masAccount.getClBalanceCr();
					BigDecimal  clBalanceDr = masAccount.getClBalanceDr();
					//String schedule = masAccount.getSchedule();
					int parentId = 0;
					//----------code commented  by anamika on 07/08/2014-----------
					/*if(masAccount.getParent() != null){
						 parentId = masAccount.getParent().getId();
					}*/
					String parentStatus = masAccount.getParentStatus();
					String subLedger = masAccount.getSubLedger();

					FaMasAccount account = new FaMasAccount();
					MasHospital masHospital = new MasHospital();
					masHospital.setId(hospitalId);
					account.setHospital(masHospital);
					account.setAccCode(accCode);
					account.setAccDesc(accDesc);
					account.setStatus(status);
					//account.setSchedule(schedule);
					account.setOpBalanceCr(clBalanceCr);
					account.setOpBalanceDr(clBalanceDr);
					account.setYtdAmountCr(new BigDecimal(0.00));
					account.setYtdAmountDr(new BigDecimal(0.00));
					account.setClBalanceCr(clBalanceCr);
					account.setClBalanceDr(clBalanceDr);
					account.setParentStatus(parentStatus);
					account.setSubLedger(subLedger);
					account.setLastChgDate(lastChgDate);
					account.setLastChgTime(lastChgTime);
					//----------code commented  by anamika on 07/08/2014-----------
					if(lastChgBy != 0){
						MasEmployee masEmployee = new MasEmployee();
						masEmployee.setId(lastChgBy);
						//account.setLastChgBy(masEmployee);
					}
					if(parentId !=0){
						FaMasAccount acc = new FaMasAccount();
						acc.setId(parentId);
						//account.setParent(acc);
					}
					FaMasAccountSubGroup faMasAccountSubGroup = new FaMasAccountSubGroup();
					faMasAccountSubGroup.setId(accounSubGroupId);
					account.setAccountSubGroup(faMasAccountSubGroup);

					/*HrMasFinancialYear hrMasFinancialYear = new HrMasFinancialYear();
					hrMasFinancialYear.setId(finYearId);
					account.setFYear(hrMasFinancialYear);*/

					hbt.save(account);


				}
			}
		}

//=============================For SubLedger==============================================
					Map<String, Object> utilMap = new HashMap<String, Object>();
					utilMap = (Map) HMSUtil.getCurrentDateAndTime();
					String date = (String) utilMap.get("currentDate");
					String time = (String) utilMap.get("currentTime");

					sudLedList = session.createCriteria(FaMasSubLed.class).add(Restrictions.eq("FYear.Id", fYearId)).list();
					if(sudLedList.size()>0){
						for(FaMasSubLed faMasSubLed :sudLedList){

						FaMasSubLed subLed = new FaMasSubLed();

						//MasHospital hospital = new MasHospital();
						//hospital.setId(faMasSubLed.getHospital().getId());
						//subLed.setHospital(hospital);
						subLed.setSubLedCode(faMasSubLed.getSubLedCode());
						subLed.setSubLedDesc(faMasSubLed.getSubLedDesc());

						FaMasAccount account2 = new FaMasAccount();
						subLed.setId(faMasSubLed.getAccount().getId());
						subLed.setAccount(account2);

						subLed.setStatus(faMasSubLed.getStatus());
						subLed.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
						subLed.setLastChgTime(time);
						//HrMasFinancialYear hrMasFinancialYear2 = new HrMasFinancialYear();
						//hrMasFinancialYear2.setId(finYearId);
						//subLed.setFYear(hrMasFinancialYear2);

						Users users = new Users();
						users.setId(faMasSubLed.getLastChgBy().getId());
						subLed.setLastChgBy(users);
						subLed.setOpBalanceCr(faMasSubLed.getClBalanceCr());
						subLed.setOpBalanceDr(faMasSubLed.getClBalanceDr());
						subLed.setYtdAmountCr(new BigDecimal(0.00));
						subLed.setYtdAmountDr(new BigDecimal(0.00));
						subLed.setClBalanceCr(faMasSubLed.getClBalanceCr());
						subLed.setClBalanceDr(faMasSubLed.getClBalanceDr());
						hbt.save(subLed);
					}
				}
				accountGroupList = session.createCriteria(FaMasAccountGroup.class).add(Restrictions.eq("FYear.Id", fYearId)).list();
			if(accountGroupList.size()>0){
			  for(FaMasAccountGroup faMasAccountGroup :accountGroupList){

				FaMasAccountGroup masAccountGroup = new FaMasAccountGroup();
				masAccountGroup.setAccountGroupCode(faMasAccountGroup.getAccountGroupCode());
				masAccountGroup.setAccountGroupDesc(faMasAccountGroup.getAccountGroupDesc());
				masAccountGroup.setStatus(faMasAccountGroup.getStatus());
				masAccountGroup.setLastChgBy(faMasAccountGroup.getLastChgBy());
				masAccountGroup.setLastChgDate(faMasAccountGroup.getLastChgDate());
				masAccountGroup.setLastChgTime(faMasAccountGroup.getLastChgTime());
				MasHospital masHospital2 = new MasHospital();
				masHospital2.setId(faMasAccountGroup.getHospital().getId());
				masAccountGroup.setHospital(masHospital2);

				//HrMasFinancialYear masFinancialYear = new HrMasFinancialYear();
				//masFinancialYear.setId(finYearId);
				//masAccountGroup.setFYear(masFinancialYear);
				masAccountGroup.setOpBalanceCr(faMasAccountGroup.getClBalanceCr());
				masAccountGroup.setOpBalanceDr(faMasAccountGroup.getClBalanceDr());
				masAccountGroup.setYtdAmountCr(new BigDecimal(0.00));
				masAccountGroup.setYtdAmountDr(new BigDecimal(0.00));
				masAccountGroup.setClBalanceCr(faMasAccountGroup.getClBalanceCr());
				masAccountGroup.setClBalanceDr(faMasAccountGroup.getClBalanceDr());
				hbt.save(masAccountGroup);
			}
		}
				accountSubGroupList = session.createCriteria(FaMasAccountSubGroup.class).add(Restrictions.eq("FYear.Id", fYearId)).list();
				if(accountSubGroupList.size()>0){
					for(FaMasAccountSubGroup faMasAccountSubGroup: accountSubGroupList){
						FaMasAccountSubGroup masAccountSubGroup = new FaMasAccountSubGroup();
						masAccountSubGroup.setAccountSubGroupCode(faMasAccountSubGroup.getAccountSubGroupCode());
						masAccountSubGroup.setAccountSubGroupName(faMasAccountSubGroup.getAccountSubGroupName());
						masAccountSubGroup.setStatus(faMasAccountSubGroup.getStatus());
						masAccountSubGroup.setLastChgBy(faMasAccountSubGroup.getLastChgBy());
						masAccountSubGroup.setLastChgDate(faMasAccountSubGroup.getLastChgDate());
						masAccountSubGroup.setLastChgTime(faMasAccountSubGroup.getLastChgTime());
						MasHospital masHospital = new MasHospital();
						masHospital.setId(faMasAccountSubGroup.getHospital().getId());
						masAccountSubGroup.setHospital(masHospital);

						//HrMasFinancialYear hrMasFinancialYear = new HrMasFinancialYear();
						//hrMasFinancialYear.setId(finYearId);
						//masAccountSubGroup.setFYear(hrMasFinancialYear);

						FaMasAccountGroup masAccountGroup = new FaMasAccountGroup();
						masAccountGroup.setId(faMasAccountSubGroup.getAccountGroup().getId());
						masAccountSubGroup.setAccountGroup(masAccountGroup);

						masAccountSubGroup.setOpBalanceCr(faMasAccountSubGroup.getClBalanceCr());
						masAccountSubGroup.setOpBalanceDr(faMasAccountSubGroup.getClBalanceDr());
						masAccountSubGroup.setYtdAmountCr(new BigDecimal(0.00));
						masAccountSubGroup.setYtdAmountDr(new BigDecimal(0.00));
						masAccountSubGroup.setClBalanceCr(faMasAccountSubGroup.getClBalanceCr());
						masAccountSubGroup.setClBalanceDr(faMasAccountSubGroup.getClBalanceDr());
						hbt.save(masAccountSubGroup);

					}
				}

			//}
		//}

		return map;
	}


//===================================================Report's Code=================================================
	public Map<String, Object> showTrialBalanceReportJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasFinancialYear> fYearList = new ArrayList<HrMasFinancialYear>();
		Session session = (Session)getSession();
		fYearList = session.createCriteria(HrMasFinancialYear.class).add(Restrictions.eq("Status", "y")).list();
		map.put("fYearList", fYearList);
		return map;
	}
	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		map.put("conn", con);
		return map;
	}
//--------------------- Sub Led Report By Mansi

	@SuppressWarnings("unchecked")
	public Map<String, Object> showSubLedJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		List<HrMasFinancialYear> fYearList = new ArrayList<HrMasFinancialYear>();
		Session session = (Session)getSession();
		accountList=session.createCriteria(FaMasAccount.class).add(Restrictions.eq("Status", "y")).list();
		fYearList = session.createCriteria(HrMasFinancialYear.class).add(Restrictions.eq("Status", "y")).list();
		map.put("accountList", accountList);
		map.put("fYearList", fYearList);
		return map;
	}
	@SuppressWarnings("unchecked")
	public List<HrMasFinancialYear> getFinancialYearDate(int fYearId) {
		List<HrMasFinancialYear> financialYearList = new ArrayList<HrMasFinancialYear>();
		Session session = (Session)getSession();
		financialYearList = session.createCriteria(HrMasFinancialYear.class).add(Restrictions.idEq(fYearId)).list();
		return financialYearList;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> getOpeningBalance(Map<String, Object>generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaVoucherDetails> voucherDetailList = new ArrayList<FaVoucherDetails>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		List<FaVoucherDetails> VoucherDtListList = new ArrayList<FaVoucherDetails>();

		String prevdate=null;
		String finFromDate=null;
		Date fromDate=null;
		Date fDate = null;
		Date to_date=null;
		if(generalMap.get("prevdate")!= null){
			prevdate = (String)generalMap.get("prevdate");
		}
		if(generalMap.get("finFromDate")!= null){
			finFromDate = (String)generalMap.get("finFromDate");
		}
		if(generalMap.get("from_date")!= null){
			fromDate = (Date)generalMap.get("from_date");
		}
		if(generalMap.get("to_date")!= null){
			to_date = (Date)generalMap.get("to_date");
		}
		if(generalMap.get("fDate")!= null){
			fDate = (Date)generalMap.get("fDate");
		}
		int accountId = 0;
		if(generalMap.get("accountId")!= null){
			accountId = (Integer)generalMap.get("accountId");
		}
		SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
		String prevdate1 = "";
		String finFromDate1= "";
		try {
			 prevdate1 = formatterOut.format(formatterIn.parse(prevdate));
			 finFromDate1 = formatterOut.format(formatterIn.parse(finFromDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BigDecimal accountDrOpBalance = new BigDecimal(0.0);
		BigDecimal accountCrOpBalance = new BigDecimal(0.0);
		Session session =(Session)getSession();
		accountList = session.createCriteria(FaMasAccount.class).add(Restrictions.idEq(accountId)).list();
		if(accountList.size()>0){
			for(FaMasAccount faMasAccount :accountList){
				if(faMasAccount.getOpBalanceCr()!= null){
					accountCrOpBalance = faMasAccount.getOpBalanceCr();
				}
				if(faMasAccount.getOpBalanceDr()!= null){
					accountDrOpBalance = faMasAccount.getOpBalanceDr();
				}
			}
		}
		BigDecimal ytdDrAmount = new BigDecimal(0.0);
		BigDecimal ytdCrAmount = new BigDecimal(0.0);
		BigDecimal drAccountAmount = new BigDecimal(0.0);
		BigDecimal crAccountAmount = new BigDecimal(0.0);
		BigDecimal crAccountClBalance = new BigDecimal(0.0);
		BigDecimal drAccountClBalance = new BigDecimal(0.0);
		BigDecimal totalYtdCrAmount = new BigDecimal(0.0);
		BigDecimal totalYtdDrAmount = new BigDecimal(0.0);


		if(HMSUtil.convertDateToStringWithoutTime(fDate).equals(HMSUtil.convertDateToStringWithoutTime(fromDate))){

			voucherDetailList = session.createCriteria(FaVoucherDetails.class).add(Restrictions.eq("Account.Id", accountId))
			.createAlias("VoucherHeader", "header")
			.add(Restrictions.between("header.VoucherDate",  (fDate),  (fromDate)))
			.add(Restrictions.eq("header.AccountSubGroup.Id", 2)).list();
			if(voucherDetailList.size()>0){
				for(FaVoucherDetails faVoucherDetails :voucherDetailList){
					if(faVoucherDetails.getCrAmount()!= null){
					 ytdCrAmount = faVoucherDetails.getCrAmount();
					 totalYtdCrAmount = totalYtdCrAmount.add(ytdCrAmount);


					}
					if(faVoucherDetails.getDrAmount()!= null){
					 ytdDrAmount = faVoucherDetails.getDrAmount();
					 totalYtdDrAmount = totalYtdDrAmount.add(ytdDrAmount);

				}
				}
			}
		}else{
			voucherDetailList = session.createCriteria(FaVoucherDetails.class).add(Restrictions.eq("Account.Id", accountId))
			.createAlias("VoucherHeader", "header")
			.add(Restrictions.between("header.VoucherDate",  java.sql.Date.valueOf(finFromDate1),  java.sql.Date.valueOf(prevdate1)))
			.add(Restrictions.eq("header.AccountSubGroup.Id", 2)).list();
			if(voucherDetailList.size()>0){
				for(FaVoucherDetails faVoucherDetails :voucherDetailList){
					if(faVoucherDetails.getCrAmount()!= null){
					 ytdCrAmount = faVoucherDetails.getCrAmount();
					 totalYtdCrAmount = totalYtdCrAmount.add(ytdCrAmount);


					}
					if(faVoucherDetails.getDrAmount()!= null){
					 ytdDrAmount = faVoucherDetails.getDrAmount();
					 totalYtdDrAmount = totalYtdDrAmount.add(ytdDrAmount);

				}
				}
			}


		//String sqlStr = "select detail.dr_amount,detail.cr_amount,account.op_balance_cr,account.op_balance_dr from fa_voucher_details detail left join  fa_voucher_header header on detail.voucher_header_id=header.voucher_header_id left join fa_mas_account account on detail.account_id =account.acc_id left join fa_mas_account_sub_group  subgroup on subgroup.account_sub_group_id = header.account_sub_group_id  where header.voucher_date between '"+finFromDate1+"' and '"+prevdate1+"' and subgroup.account_sub_group_id = 2 and account.acc_id = "+accountId+" ";




	}
			crAccountAmount = accountCrOpBalance.add(totalYtdCrAmount);
			drAccountAmount = 	accountDrOpBalance.add(totalYtdDrAmount);

			if(drAccountAmount.compareTo(crAccountAmount)>0){
				drAccountClBalance = drAccountAmount.subtract(crAccountAmount);
			}else if(crAccountAmount.compareTo(drAccountAmount)>0){
				crAccountClBalance = crAccountAmount.subtract(drAccountAmount);
			}else if(crAccountAmount.compareTo(drAccountAmount)==0){
				crAccountClBalance = new BigDecimal(0.00);
				drAccountClBalance= new BigDecimal(0.00);

			}
			map.put("voucherDetailList", voucherDetailList);
			map.put("drAccountClBalance", drAccountClBalance);
			map.put("crAccountClBalance", crAccountClBalance);

		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> showCashRegisterJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		Session session =(Session)getSession();
		accountList = session.createCriteria(FaMasAccount.class).add(Restrictions.eq("Parent.Id", 38))
								.createAlias("AccountSubGroup", "subGroup").add(Restrictions.eq("subGroup.Id", 5)).list();
		map.put("accountList", accountList);
		
		List<MasHospital> centreHList=new ArrayList<MasHospital>();
		centreHList=session.createCriteria(MasHospital.class).list();
		map.put("centreHList", centreHList);
		return map;
	}
	@Override
	public Map<String, Object> displayCashBook(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaVoucherDetails> voucherDetailList = new ArrayList<FaVoucherDetails>();
		List<FaVoucherDetails> cashVoucherDetailList= new ArrayList<FaVoucherDetails>();
		List<FaMasAccount> cashAccountList = new ArrayList<FaMasAccount>();
		Session session = (Session)getSession();
		voucherDetailList = session.createCriteria(FaVoucherDetails.class).createAlias("VoucherHeader", "header").add(Restrictions.eq("header.FYear.Id", box.getInt("fYear")))
							.add(Restrictions.eq("header.Hospital.Id", box.getInt("locationId")))
							.add(Restrictions.between("header.VoucherDate",HMSUtil.dateFormatterDDMMYYYY(box.getString(FROM_DATE)),HMSUtil.dateFormatterDDMMYYYY(box.getString(TO_DATE))))
							.list();
		cashVoucherDetailList = session.createCriteria(FaVoucherDetails.class).createAlias("VoucherHeader", "header")
									.add(Restrictions.eq("header.FYear.Id", box.getInt("fYear"))).add(Restrictions.eq("Account.Id", box.getInt(ACCOUNT_ID)))
								.add(Restrictions.eq("header.Hospital.Id", box.getInt("locationId")))
							.add(Restrictions.between("header.VoucherDate",HMSUtil.dateFormatterDDMMYYYY(box.getString(FROM_DATE)),HMSUtil.dateFormatterDDMMYYYY(box.getString(TO_DATE))))

								.list();
		cashAccountList = session.createCriteria(FaMasAccount.class).add(Restrictions.idEq(box.getInt(ACCOUNT_ID))).list();
		
		System.out.println("cashVoucherDetailList="+cashVoucherDetailList.size());
		System.out.println("voucherDetailList="+voucherDetailList.size());
		map.put("cashAccountList", cashAccountList);
		map.put("voucherDetailList", voucherDetailList);
		map.put("cashVoucherDetailList", cashVoucherDetailList);
		return map;
	}
	
	public Map<String, Object> showLedgerBookJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		List<FaMasSubLed> subledgerList = new ArrayList<FaMasSubLed>();
		Object[] selectedId = {1,2};
		Session session =(Session)getSession();
		accountList = session.createCriteria(FaMasAccount.class)
		//.add(Restrictions.eq("FYear.Id", fYearId))
		.createAlias("AccountSubGroup", "subGroup").add(Restrictions.not(Restrictions.in("subGroup.Id", selectedId))).list();
			map.put("accountList", accountList);
		subledgerList = session.createCriteria(FaMasSubLed.class).list();
			map.put("subledgerList", subledgerList);
		return map;
	}

	//-----------------------fa_voucherJsp By Ujjwal------------------------------------------------

	public Map<String, Object> showfavoucherJsp(int fYearId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaVoucherHeader> voucherlist = new ArrayList<FaVoucherHeader>();
		Session session =(Session)getSession();
		voucherlist = session.createCriteria(FaVoucherHeader.class)
		.add(Restrictions.eq("FYear.Id", fYearId)).list();
		map.put("voucherlist", voucherlist);
		return map;
	}
	@SuppressWarnings("unchecked")




	public Map<String, Object> getVoucherList(Map<String, Object> generalMap) {
		Map<String, Object> map=new HashMap<String, Object>();
		List<FaVoucherDetails> voucherDetailList = new ArrayList<FaVoucherDetails>();
		Date todate=null;

		Date fromDate=null;
		//Date toDate = null;
		if(generalMap.get("to_date")!= null){
			todate = (Date)generalMap.get("to_date");
		}

		if(generalMap.get("from_date")!= null){
			fromDate = (Date)generalMap.get("from_date");
		}

		int accountId = 0;
		if(generalMap.get("accountId")!= null){
			accountId = (Integer)generalMap.get("accountId");
		}
		int subLedgerId = 0;
		if(generalMap.get("subLedgerId")!= null){
			subLedgerId = (Integer)generalMap.get("subLedgerId");
		}
		
		
		Session session =(Session)getSession();
		Criteria criteria =  session.createCriteria(FaVoucherDetails.class).add(Restrictions.eq("Account.Id", accountId))
								.createAlias("VoucherHeader", "header")
									.add(Restrictions.between("header.VoucherDate",(fromDate),(todate)));
		if(subLedgerId != 0){
		criteria = criteria.add(Restrictions.eq("SubLed.Id", subLedgerId));
		}
		voucherDetailList = criteria.list();

		map.put("voucherDetailList", voucherDetailList);

		return map;
	}

	public Map<String, Object> showBankRegisterJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		Session session =(Session)getSession();
		accountList = session.createCriteria(FaMasAccount.class).add(Restrictions.eq("Parent.Id",40))
							.createAlias("AccountSubGroup", "subGroup").add(Restrictions.eq("subGroup.Id", 5)).list();
		map.put("accountList", accountList);
		List<MasHospital> centreHList=new ArrayList<MasHospital>();
		centreHList=session.createCriteria(MasHospital.class).list();
		map.put("centreHList", centreHList);
		return map;
	}
	
	@Override
	public Map<String, Object> displayBankBook(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaVoucherDetails> voucherDetailList = new ArrayList<FaVoucherDetails>();
		List<FaVoucherDetails> bankVoucherDetailList= new ArrayList<FaVoucherDetails>();
		List<FaMasAccount> bankAccountList = new ArrayList<FaMasAccount>();
		Session session = (Session)getSession();
		voucherDetailList = session.createCriteria(FaVoucherDetails.class).createAlias("VoucherHeader", "header").add(Restrictions.eq("header.FYear.Id", box.getInt("fYear")))
							.add(Restrictions.eq("header.Hospital.Id", box.getInt("locationId")))
							.add(Restrictions.between("header.VoucherDate",HMSUtil.dateFormatterDDMMYYYY(box.getString(FROM_DATE)),HMSUtil.dateFormatterDDMMYYYY(box.getString(TO_DATE))))
							.list();
		bankVoucherDetailList = session.createCriteria(FaVoucherDetails.class).createAlias("VoucherHeader", "header")
									.add(Restrictions.eq("header.FYear.Id", box.getInt("fYear"))).add(Restrictions.eq("Account.Id", box.getInt(ACCOUNT_ID)))
								.add(Restrictions.eq("header.Hospital.Id", box.getInt("locationId")))
							.add(Restrictions.between("header.VoucherDate",HMSUtil.dateFormatterDDMMYYYY(box.getString(FROM_DATE)),HMSUtil.dateFormatterDDMMYYYY(box.getString(TO_DATE))))
	
								.list();
		bankAccountList = session.createCriteria(FaMasAccount.class).add(Restrictions.idEq(box.getInt(ACCOUNT_ID))).list();
		
		map.put("bankAccountList", bankAccountList);
		map.put("voucherDetailList", voucherDetailList);
		map.put("bankVoucherDetailList", bankVoucherDetailList);
	return map;
	}
	

	public Map<String, Object> showLedgerAnalysisJsp()
	{
	  Map<String, Object> map = new HashMap<String, Object>();
	  List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
	  List<FaMasSubLed> subledgerList = new ArrayList<FaMasSubLed>();
		Session session =(Session)getSession();
		accountList = session.createCriteria(FaMasAccount.class).list();
		map.put("accountList", accountList);
		subledgerList = session.createCriteria(FaMasSubLed.class).list();
		map.put("subledgerList", subledgerList);
		return map;

	}
	public Map<String, Object> showVoucherReportJsp()
	{
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasFinancialYear>  fYearList = new ArrayList<HrMasFinancialYear>();
		Session session =(Session)getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		fYearList = getHibernateTemplate().find("from jkt.hms.masters.business.HrMasFinancialYear " );
		map.put("fYearList", fYearList);
		return map;
		
	}
	
	public int getFinancialYearList(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasFinancialYear> fromFinancialYearList = new ArrayList<HrMasFinancialYear>();
		List<HrMasFinancialYear> toFinancialYearList = new ArrayList<HrMasFinancialYear>();
		Date fromDate = null;
		Date toDate = null;
		Session session = (Session)getSession();
		if(generalMap.get("from_date") != null){
			fromDate = (Date)generalMap.get("from_date");
		}
		if(generalMap.get("to_date") != null){
			toDate = (Date)generalMap.get("from_date");
		}
		fromFinancialYearList = session.createCriteria(HrMasFinancialYear.class).add(Restrictions.le("YearFromDate", fromDate))
							.add(Restrictions.ge("YearToDate", fromDate))
						.add(Restrictions.eq("Status", "y"))
						.list();
	
		toFinancialYearList = session.createCriteria(HrMasFinancialYear.class).add(Restrictions.le("YearFromDate", toDate))
								.add(Restrictions.ge("YearToDate", toDate))
										.add(Restrictions.eq("Status", "y")).list();
		int fromFinancialYearId = 0;
		int toFinancialYearId = 0;
		int financialYearId = 0;
		if(fromFinancialYearList.size()>0){
			for(HrMasFinancialYear financialYear : fromFinancialYearList){
				fromFinancialYearId = financialYear.getId();
			}
		}
		if(toFinancialYearList.size()>0){
			for(HrMasFinancialYear financialYear : toFinancialYearList){
				toFinancialYearId = financialYear.getId();
			}
		}
		if(fromFinancialYearId == toFinancialYearId){
			financialYearId = fromFinancialYearId;
		}
		return financialYearId;
	}
	@SuppressWarnings("unchecked")
/*	public Map<String, Object> getOpeningBalance(Map<String, Object>generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaVoucherDetails> voucherDetailList = new ArrayList<FaVoucherDetails>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		List<FaVoucherDetails> VoucherDtListList = new ArrayList<FaVoucherDetails>();

		String prevdate=null;
		String finFromDate=null;
		Date fromDate=null;
		Date fDate = null;
		Date to_date=null;
		if(generalMap.get("prevdate")!= null){
			prevdate = (String)generalMap.get("prevdate");
		}
		if(generalMap.get("finFromDate")!= null){
			finFromDate = (String)generalMap.get("finFromDate");
		}
		if(generalMap.get("fromDate")!= null){
			fromDate = (Date)generalMap.get("fromDate");
		}
		if(generalMap.get("to_date")!= null){
			to_date = (Date)generalMap.get("to_date");
		}
		if(generalMap.get("fDate")!= null){
			fDate = (Date)generalMap.get("fDate");
		}
		int accountId = 0;
		if(generalMap.get("accountId")!= null){
			accountId = (Integer)generalMap.get("accountId");
		}
		SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
		String prevdate1 = "";
		String finFromDate1= "";
		try {
			 prevdate1 = formatterOut.format(formatterIn.parse(prevdate));
			 finFromDate1 = formatterOut.format(formatterIn.parse(finFromDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BigDecimal accountDrOpBalance = new BigDecimal(0.0);
		BigDecimal accountCrOpBalance = new BigDecimal(0.0);
		Session session =(Session)getSession();
		accountList = session.createCriteria(FaMasAccount.class).add(Restrictions.idEq(accountId)).list();
		if(accountList.size()>0){
			for(FaMasAccount faMasAccount :accountList){
				if(faMasAccount.getOpBalanceCr()!= null){
					accountCrOpBalance = faMasAccount.getOpBalanceCr();
				}
				if(faMasAccount.getOpBalanceDr()!= null){
					accountDrOpBalance = faMasAccount.getOpBalanceDr();
				}
			}
		}
		BigDecimal ytdDrAmount = new BigDecimal(0.0);
		BigDecimal ytdCrAmount = new BigDecimal(0.0);
		BigDecimal drAccountAmount = new BigDecimal(0.0);
		BigDecimal crAccountAmount = new BigDecimal(0.0);
		BigDecimal crAccountClBalance = new BigDecimal(0.0);
		BigDecimal drAccountClBalance = new BigDecimal(0.0);
		BigDecimal totalYtdCrAmount = new BigDecimal(0.0);
		BigDecimal totalYtdDrAmount = new BigDecimal(0.0);


		if(HMSUtil.convertDateToStringWithoutTime(fDate).equals(HMSUtil.convertDateToStringWithoutTime(fromDate))){

			voucherDetailList = session.createCriteria(FaVoucherDetails.class).add(Restrictions.eq("Account.Id", accountId))
			.createAlias("VoucherHeader", "header")
			.add(Restrictions.between("header.VoucherDate",  (fDate),  (fromDate)))
			.add(Restrictions.eq("header.AccountSubGroup.Id", 2)).list();
			if(voucherDetailList.size()>0){
				for(FaVoucherDetails faVoucherDetails :voucherDetailList){
					if(faVoucherDetails.getCrAmount()!= null){
					 ytdCrAmount = faVoucherDetails.getCrAmount();
					 totalYtdCrAmount = totalYtdCrAmount.add(ytdCrAmount);


					}
					if(faVoucherDetails.getDrAmount()!= null){
					 ytdDrAmount = faVoucherDetails.getDrAmount();
					 totalYtdDrAmount = totalYtdDrAmount.add(ytdDrAmount);

				}
				}
			}
		}else{
			voucherDetailList = session.createCriteria(FaVoucherDetails.class).add(Restrictions.eq("Account.Id", accountId))
			.createAlias("VoucherHeader", "header")
			.add(Restrictions.between("header.VoucherDate",  java.sql.Date.valueOf(finFromDate1),  java.sql.Date.valueOf(prevdate1)))
			.add(Restrictions.eq("header.AccountSubGroup.Id", 2)).list();
			if(voucherDetailList.size()>0){
				for(FaVoucherDetails faVoucherDetails :voucherDetailList){
					if(faVoucherDetails.getCrAmount()!= null){
					 ytdCrAmount = faVoucherDetails.getCrAmount();
					 totalYtdCrAmount = totalYtdCrAmount.add(ytdCrAmount);


					}
					if(faVoucherDetails.getDrAmount()!= null){
					 ytdDrAmount = faVoucherDetails.getDrAmount();
					 totalYtdDrAmount = totalYtdDrAmount.add(ytdDrAmount);

				}
				}
			}


		//String sqlStr = "select detail.dr_amount,detail.cr_amount,account.op_balance_cr,account.op_balance_dr from fa_voucher_details detail left join  fa_voucher_header header on detail.voucher_header_id=header.voucher_header_id left join fa_mas_account account on detail.account_id =account.acc_id left join fa_mas_account_sub_group  subgroup on subgroup.account_sub_group_id = header.account_sub_group_id  where header.voucher_date between '"+finFromDate1+"' and '"+prevdate1+"' and subgroup.account_sub_group_id = 2 and account.acc_id = "+accountId+" ";




	}
			crAccountAmount = accountCrOpBalance.add(totalYtdCrAmount);
			drAccountAmount = 	accountDrOpBalance.add(totalYtdDrAmount);

			if(drAccountAmount.compareTo(crAccountAmount)>0){
				drAccountClBalance = drAccountAmount.subtract(crAccountAmount);
			}else if(crAccountAmount.compareTo(drAccountAmount)>0){
				crAccountClBalance = crAccountAmount.subtract(drAccountAmount);
			}else if(crAccountAmount.compareTo(drAccountAmount)==0){
				crAccountClBalance = new BigDecimal(0.00);
				drAccountClBalance= new BigDecimal(0.00);

			}
			map.put("voucherDetailList", voucherDetailList);
			map.put("drAccountClBalance", drAccountClBalance);
			map.put("crAccountClBalance", crAccountClBalance);

		return map;
	}
	*/
	
	public Map<String, Object> getOpeningBalanceFromOpeningEntry(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaAccountOpening> accountOpeningList = new ArrayList<FaAccountOpening>();
		List<Object[]> voucherDetailList = new ArrayList<Object[]>();
		Session session = (Session)getSession();
		int accountId=0;
		int financialYearId = 0;
		int branchId = 0;
		String prevdate = "";
		Date fromDate = null;
		Date toDate = null;
		String fDate = null;
		String tDate = null;
		String qry=null;
		if(generalMap.get("prevdate")!= null){
			prevdate = (String)generalMap.get("prevdate");
		}
		if(generalMap.get("from_date")!= null){
			fromDate = (Date)generalMap.get("from_date");
		}
		if(generalMap.get("to_date")!= null){
			toDate = (Date)generalMap.get("to_date");
		}
		if(generalMap.get("accountId")!= null){
			accountId = (Integer)generalMap.get("accountId");
		}
		if(generalMap.get("branchId")!= null){
			branchId = (Integer)generalMap.get("branchId");
		}
		if(generalMap.get("financialYearId")!= null){
			financialYearId = (Integer)generalMap.get("financialYearId");
		}
		int subLedgerId = 0;
		if(generalMap.get("subLedgerId")!= null){
			subLedgerId = (Integer)generalMap.get("subLedgerId");
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		fDate=sdf.format(fromDate);
		tDate=sdf.format(toDate);
		
		try {
			Connection con = session.connection();
			/*if(accountId==1 ||accountId==4 || accountId==6 )*/
			if(subLedgerId == 0){
			 qry = "{call get_opening_amount ('" + accountId + "','" + subLedgerId + "'," +
					"'" + branchId + "','" + fDate + "','" + tDate + "')}";
			}
			else{
			 qry = "{call get_opening_amount_sub ('" + accountId + "','" + subLedgerId + "'," +
				"'" + branchId + "','" + fDate + "','" + tDate + "')}";
						
			}
			CallableStatement cals = con.prepareCall(qry);
			cals.execute();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*Date openingDate = null;
		BigDecimal accountOpBalanceDr = new BigDecimal(0.00);
		BigDecimal accountOpBalanceCr = new BigDecimal(0.00);
		Criteria criteria = session.createCriteria(FaAccountOpening.class).add(Restrictions.eq("FYear.Id", financialYearId))
							.add(Restrictions.eq("Branch.Id", branchId)).add(Restrictions.eq("Account.Id", accountId));
		if(subLedgerId != 0){
		criteria = criteria.add(Restrictions.eq("SubLedger.Id", subLedgerId));
		}
		accountOpeningList = criteria.list();
		if(accountOpeningList.size()>0){
			for(FaAccountOpening accountOpening : accountOpeningList){
				if(accountOpening.getOpeningDate()!= null && !(accountOpening.getOpeningDate().equals("null"))){
					openingDate = accountOpening.getOpeningDate();
				}
				if(accountOpening.getOpeningAmtCr() != null && accountOpening.getOpeningAmtCr().compareTo(new BigDecimal(0.00))>0){
					accountOpBalanceCr = accountOpening.getOpeningAmtCr();
				}else if(accountOpening.getOpeningAmtDr() != null && accountOpening.getOpeningAmtDr().compareTo(new BigDecimal(0.00))>0){
					accountOpBalanceDr = accountOpening.getOpeningAmtDr();
				}
			}
		}
		BigDecimal voucherBalanceDr = new BigDecimal(0.0);
		BigDecimal voucherBalanceCr = new BigDecimal(0.0);
		BigDecimal totalYtdCrAmount = new BigDecimal(0.0);
		BigDecimal totalYtdDrAmount = new BigDecimal(0.0);
		if(openingDate != null){
		if(HMSUtil.convertDateToStringWithoutTime(fromDate).equals(HMSUtil.convertDateToStringWithoutTime(openingDate))){
			Criteria crit =session.createCriteria(FaVoucherDetails.class).add(Restrictions.eq("Account.Id", accountId))
							.createAlias("VoucherHeader", "header").add(Restrictions.between("header.VoucherDate", openingDate, HMSUtil.convertStringTypeDateToDateType(prevdate)))
					.setProjection(Projections.projectionList().add(Projections.sum("CrAmount")).add(Projections.sum("DrAmount")))
						.setProjection(Projections.sum("CrAmount")).setProjection(Projections.sum("DrAmount"));
			if(subLedgerId != 0){
			crit = crit.add(Restrictions.eq("SubLed.Id", subLedgerId));
			}
			voucherDetailList = crit.list();
				
			if(voucherDetailList.size()>0 && voucherDetailList != null){
				for(Object[] voucherDetails :voucherDetailList){
					if(voucherDetails != null){
					if(voucherDetails[0]!= null && (((BigDecimal)voucherDetails[0]).compareTo(new BigDecimal(0.00)))>0){
						voucherBalanceCr = (BigDecimal)voucherDetails[0];
					}
					if(voucherDetails[1]!= null && ((BigDecimal)voucherDetails[1]).compareTo(new BigDecimal(0.00))>0){
						voucherBalanceDr = (BigDecimal)voucherDetails[1];

					}
				}
				}
			}
		}else{
			Criteria crit =session.createCriteria(FaVoucherDetails.class).add(Restrictions.eq("Account.Id", accountId))
						.createAlias("VoucherHeader", "header").add(Restrictions.between("header.VoucherDate", openingDate, HMSUtil.convertStringTypeDateToDateType(prevdate)))
						.setProjection(Projections.projectionList().add(Projections.sum("CrAmount")).add(Projections.sum("DrAmount")))
							.setProjection(Projections.sum("CrAmount")).setProjection(Projections.sum("DrAmount"));
			if(subLedgerId != 0){
			crit = crit.add(Restrictions.eq("SubLed.Id", subLedgerId));
			}
			voucherDetailList = crit.list();
			if(voucherDetailList.size()>0 && voucherDetailList.get(0)!= null){
				for(Object[] voucherDetails :voucherDetailList){
					if(voucherDetails != null){
					if(voucherDetails[0]!= null && ((BigDecimal)voucherDetails[0]).compareTo(new BigDecimal(0.00))>0){
						voucherBalanceCr = (BigDecimal)voucherDetails[0];
					}
					if(voucherDetails[1]!= null && ((BigDecimal)voucherDetails[1]).compareTo(new BigDecimal(0.00))>0){
						voucherBalanceDr = (BigDecimal)voucherDetails[1];

					}
				}
				}
			}
			}
		}
		   BigDecimal crAccountAmount = accountOpBalanceCr.add(voucherBalanceCr);
	       BigDecimal  drAccountAmount = 	accountOpBalanceDr.add(voucherBalanceDr);
	       BigDecimal drAccountClBalance = new BigDecimal(0.00);
	       BigDecimal crAccountClBalance = new BigDecimal(0.00);
			if(drAccountAmount.compareTo(crAccountAmount)>0){
				drAccountClBalance = drAccountAmount.subtract(crAccountAmount);
			}else if(crAccountAmount.compareTo(drAccountAmount)>0){
				crAccountClBalance = crAccountAmount.subtract(drAccountAmount);
			}else if(crAccountAmount.compareTo(drAccountAmount)==0){
				crAccountClBalance = new BigDecimal(0.00);
				drAccountClBalance= new BigDecimal(0.00);
	
			}
			map.put("drAccountClBalance", drAccountClBalance);
			map.put("crAccountClBalance", crAccountClBalance);
			map.put("voucherDetailList", voucherDetailList);*/
		return map;
		
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> showAccountParameterJsp(int fYear) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		List<FaMasAccount> accountListForCash = new ArrayList<FaMasAccount>();
		List<FaMasAccount> accountListForBank = new ArrayList<FaMasAccount>();
		List<FaMasAccount> accountListForSales = new ArrayList<FaMasAccount>();
		
		List<FaMasSubLed> subLedList = new ArrayList<FaMasSubLed>();
		//List<MasMainChargecode> mainChargeCodeList = new ArrayList<MasMainChargecode>();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		//List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		List<MasStoreSupplier> vendorList = new ArrayList<MasStoreSupplier>();
		Session session = (Session)getSession();
		
		accountList = session.createCriteria(FaMasAccount.class).add(Restrictions.eq("FYear.Id", fYear)).list();
		accountListForCash = session.createCriteria(FaMasAccount.class).add(Restrictions.eq("FYear.Id", fYear))
								.add(Restrictions.eq("AccountSubGroup.Id", 2)).list();
		accountListForBank = session.createCriteria(FaMasAccount.class).add(Restrictions.eq("FYear.Id", fYear))
							.add(Restrictions.eq("AccountSubGroup.Id", 1)).list();
		accountListForSales = session.createCriteria(FaMasAccount.class).add(Restrictions.eq("FYear.Id", fYear))
			.add(Restrictions.eq("AccountSubGroup.Id", 20)).list();
		subLedList = session.createCriteria(FaMasSubLed.class).add(Restrictions.eq("FYear.Id", fYear)).list();
		//mainChargeCodeList = session.createCriteria(MasMainChargecode.class).add(Restrictions.eq("Status", "y")).list();
		vendorList = session.createCriteria(MasStoreSupplier.class).add(Restrictions.eq("Status", "y")).list();
		map.put("accountList", accountList);
		map.put("accountListForCash", accountListForCash);
		map.put("accountListForBank", accountListForBank);
		map.put("accountListForSales", accountListForSales);
		map.put("subLedList", subLedList);
		//map.put("mainChargeCodeList", mainChargeCodeList);
		map.put("vendorList", vendorList);
		return map;
	}
	
	public Map<String, Object> submitAccountsParameter(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	
	HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	
	try {
		Vector accId = box.getVector("acc_id");
		Vector subLedId = box.getVector("sub_led_id");
		Vector accountType = box.getVector("accountType");
		System.out.println("accId==="+accId.size());
	
		for (int i = 0; i < accId.size(); i++) {
			FaAccountParameter faAccountsParameter = new FaAccountParameter();
			if (accId.size()>0) {
				if (accId.get(i) != null && !accId.get(i).equals("0")) {
					FaMasAccount masAccount = new FaMasAccount();
					masAccount.setId(Integer.parseInt(accId.get(i).toString()));
					faAccountsParameter.setAccount(masAccount);
				
			
			if (accountType.get(i) != null && !accountType.get(i).equals("")) {
				faAccountsParameter.setAccountType((String) accountType.get(i));
			}
				
				if (subLedId.size() > 0) {
					if (subLedId.get(i) != null && !subLedId.get(i).equals("0")) {
						FaMasSubLed masSubLed = new FaMasSubLed();
						masSubLed.setId(Integer.parseInt(subLedId.get(i).toString()));
						faAccountsParameter.setSubLed(masSubLed);
					}
				}
				if(box.getInt("hospitalId")!= 0){
					MasHospital masHospital = new MasHospital();
					masHospital.setId(box.getInt("userId"));
					faAccountsParameter.setHospital(masHospital);
				}
				if(box.getInt("userId")!= 0){
					Users users = new Users();
					users.setId(box.getInt("userId"));
					faAccountsParameter.setLastChgBy(users);
				}
				if(!box.getString(CHANGED_DATE).equals("")){
					faAccountsParameter.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
				}
				if(!box.getString(CHANGED_TIME).equals("")){
					faAccountsParameter.setLastChgTime(box.getString(CHANGED_TIME));
				}
				faAccountsParameter.setStatus("y");
				hbt.save(faAccountsParameter);
			}	
			}	
		}
		/*int chargeListLength = box.getInt("hiddenValueForAccounts");
		if(chargeListLength > 0){
				for(int i=0; i<= chargeListLength; i++){
					int mainchargeId  = 0;
					if (box.getInt(MAIN_CHARGECODE_ID+ i) != 0) {
						MasMainChargecode mainChargecode = new MasMainChargecode();
						 mainchargeId = box.getInt(MAIN_CHARGECODE_ID+ i);
					}
					MasMainChargecode masMainChargecode = (MasMainChargecode)hbt.load(MasMainChargecode.class, mainchargeId);
					if (box.getString(BILL_TYPE+ i) != "") {
						//masMainChargecode.setBillType(box.getString(BILL_TYPE+ i));
					}
					if (box.getInt(ACCOUNT_ID+ i) != 0) {
						FaMasAccount faMasAccount = new FaMasAccount();
						faMasAccount.setId(box.getInt(ACCOUNT_ID+ i));
						//masMainChargecode.setAccount(faMasAccount);
					}
					if (box.getInt(SUB_LEDGER_CODE+ i) != 0) {
						FaMasSubLed faMasSubLed = new FaMasSubLed();
						faMasSubLed.setId(box.getInt(SUB_LEDGER_CODE+ i));
						//masMainChargecode.setSubLed(faMasSubLed);
					}

					hbt.update(masMainChargecode);

					}
				}
*/
		int count = 0;
		if(box.getInt("counter")!= 0){
			count = box.getInt("counter");
		}
		System.out.println("count==="+count);
		for (int i = 1; i <= count; i++) {
			int vendorId  = 0;
			if (box.getInt("vendorCheckBoxId"+ i) != 0) {
				MasStoreSupplier masStoreSupplier = new MasStoreSupplier();
				vendorId = box.getInt("vendorCheckBoxId"+ i);
			
			MasStoreSupplier supplier = (MasStoreSupplier)hbt.load(MasStoreSupplier.class, vendorId);

			if (box.getInt("acc_id"+ i) != 0) {
				FaMasAccount faMasAccount = new FaMasAccount();
				faMasAccount.setId(box.getInt("acc_id"+ i));
				supplier.setAcc(faMasAccount);
			}

			if (box.getInt(SUB_LEDGER_ID+ i) != 0) {
				FaMasSubLed faMasSubLed = new FaMasSubLed();
				faMasSubLed.setId(box.getInt(SUB_LEDGER_ID+ i));
				supplier.setSubLed(faMasSubLed);
			}

				hbt.update(supplier);

			}
		}
	} catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (DataAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	map = showAccountParameterJsp(box.getInt("fYear"));
		return map;
	}

	public int getFinancialYearId(Date voucherDate) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasFinancialYear> fromFinancialYearList = new ArrayList<HrMasFinancialYear>();
		List<HrMasFinancialYear> toFinancialYearList = new ArrayList<HrMasFinancialYear>();
		Session session = (Session)getSession();
		int financialId=0;
		String fDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		fDate=sdf.format(voucherDate);
		String qury="";
		qury="select hmfy from jkt.hms.masters.business.HrMasFinancialYear as hmfy where '"+fDate+"' between " +
		"hmfy.YearFromDate and hmfy.YearToDate";
		fromFinancialYearList =session.createQuery(qury).list();			
		if(fromFinancialYearList.size()>0){
			for(HrMasFinancialYear financialYear : fromFinancialYearList){
				financialId = financialYear.getId();
			}
		}
		return financialId;
	}
	@Override
	public Map<String, Object> getAccountId(Map<String, Object> remap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<FaMasAccount> accountL= new ArrayList<FaMasAccount>();
		String accountNameId1="";
		String accountCode="";
		String accountNameId2="";
		String accountCode2="";
		if(remap.get("accountNameId1")!= null){
			accountNameId1 = (String)(remap.get("accountNameId1"));
			accountNameId2 =""+accountNameId1.trim()+" %";
		}
		if(remap.get("accountCode")!= null){
			accountCode = (String)(remap.get("accountCode"));
			accountCode2=""+accountCode.trim();
		}
		try{
			accountL=session.createQuery("select fma from jkt.hms.masters.business.FaMasAccount as fma where " +
					"fma.AccCode like '"+accountCode2+"' and fma.AccDesc like '"+accountNameId2+"'").list();
			map.put("accountL", accountL);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	@Override
	public Map<String, Object> showAccountBalanceall(Map<String, Object> remap) {
			Map<String, Object> map = new HashMap<String, Object>();
			List<ViewData> accountList = new ArrayList<ViewData>();
			String qry="";
			int resrate=0;
			int accountId=0;
			int financialId=0;
			int branchId=0;
			Session session = (Session)getSession();
			
			try {
				Connection con = session.connection();
				qry="{ call get_data_from_view }";
				CallableStatement cals = con.prepareCall(qry);
				cals.execute();
			}
				catch (HibernateException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try{
					if(remap.get("financialId")!=null && remap.get("financialId")!=""){
						financialId=(Integer)remap.get("financialId");
					}
					if(remap.get("branchId")!=null && remap.get("branchId")!=""){
						branchId=(Integer)remap.get("branchId");
					}
					if(remap.get("accountId")!=null && remap.get("accountId")!=""){
						accountId=(Integer)remap.get("accountId");
					}
					if(remap.get("resrate")!=null && remap.get("resrate")!=""){
						resrate=(Integer)remap.get("resrate");
					}
					if(resrate==0){
					accountList=session.createQuery("select fao from jkt.hms.masters.business.ViewData as fao where fao.AccountId=" +
							""+accountId+"and fao.BranchId="+branchId+" and fao.FYearId="+financialId).list();
					}
					else if(resrate>0)
					{
						accountList=session.createQuery("select fao from jkt.hms.masters.business.ViewData as fao where fao.AccountId" +
								"="+accountId+"and fao.SubLedId="+resrate+"and fao.BranchId="+branchId+" and fao.FYearId="+financialId).list();
					}
			} catch (HibernateException e) {
				e.printStackTrace();
			}
			map.put("accountList", accountList);
			return map;
		}
	@Override
	public Map<String, Object> showLedgerJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		Session session = (Session)getSession();
		accountList = session.createCriteria(FaMasAccount.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AccDesc")).list();
		map.put("accountList", accountList);
		return map;
	}
	@Override
	public Map<String, Object> displayLedgerBook(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaVoucherDetails> voucherDetailList = new ArrayList<FaVoucherDetails>();
		List<FaVoucherDetails> ledgerVoucherDetailList= new ArrayList<FaVoucherDetails>();
		List<FaMasAccount> ledgerAccountList = new ArrayList<FaMasAccount>();
		Session session = (Session)getSession();
		System.out.println("box.getInt(\"locationId\")"+box.getInt("locationId"));
		if(box.getInt("locationId")!=0){
			voucherDetailList = session.createCriteria(FaVoucherDetails.class).createAlias("VoucherHeader", "header").add(Restrictions.eq("header.FYear.Id", box.getInt("fYear")))
					.add(Restrictions.eq("header.Hospital.Id", box.getInt("locationId")))
					.add(Restrictions.between("header.VoucherDate",HMSUtil.dateFormatterDDMMYYYY(box.getString(FROM_DATE)),HMSUtil.dateFormatterDDMMYYYY(box.getString(TO_DATE))))
					.list();
			
			ledgerVoucherDetailList = session.createCriteria(FaVoucherDetails.class).createAlias("VoucherHeader", "header")
					.add(Restrictions.eq("header.FYear.Id", box.getInt("fYear"))).add(Restrictions.eq("Account.Id", box.getInt(ACCOUNT_ID)))
				.add(Restrictions.eq("header.Hospital.Id", box.getInt("locationId")))
			.add(Restrictions.between("header.VoucherDate",HMSUtil.dateFormatterDDMMYYYY(box.getString(FROM_DATE)),HMSUtil.dateFormatterDDMMYYYY(box.getString(TO_DATE))))

				.list();
		}else{
			voucherDetailList = session.createCriteria(FaVoucherDetails.class).createAlias("VoucherHeader", "header").add(Restrictions.eq("header.FYear.Id", box.getInt("fYear")))
					.add(Restrictions.between("header.VoucherDate",HMSUtil.dateFormatterDDMMYYYY(box.getString(FROM_DATE)),HMSUtil.dateFormatterDDMMYYYY(box.getString(TO_DATE))))
					.list();
			
			ledgerVoucherDetailList = session.createCriteria(FaVoucherDetails.class).createAlias("VoucherHeader", "header")
					.add(Restrictions.eq("header.FYear.Id", box.getInt("fYear"))).add(Restrictions.eq("Account.Id", box.getInt(ACCOUNT_ID)))
			.add(Restrictions.between("header.VoucherDate",HMSUtil.dateFormatterDDMMYYYY(box.getString(FROM_DATE)),HMSUtil.dateFormatterDDMMYYYY(box.getString(TO_DATE))))

				.list();
		}
	
		
		ledgerAccountList = session.createCriteria(FaMasAccount.class).add(Restrictions.idEq(box.getInt(ACCOUNT_ID))).list();
		
		System.out.println("ledgerAccountList="+ledgerAccountList.size());
		System.out.println("voucherDetailList="+voucherDetailList.size());
		System.out.println("ledgerVoucherDetailList="+ledgerVoucherDetailList.size());
		map.put("ledgerAccountList", ledgerAccountList);
		map.put("voucherDetailList", voucherDetailList);
		map.put("ledgerVoucherDetailList", ledgerVoucherDetailList);
		return map;
	}
	@Override
	public Map<String, Object> showSubLedgerPopupJsp(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<AccountSubLedTransac> subLedList = new ArrayList<AccountSubLedTransac>();
		Session session = (Session)getSession();
		int accountId = 0;
		int locationId =0;
		
		if(generalMap.get("accountId")!= null){
			accountId = (Integer)generalMap.get("accountId");
		}
		if(generalMap.get("locationId")!= null){
			locationId = (Integer)generalMap.get("locationId");
		}
		subLedList = session.createCriteria(AccountSubLedTransac.class)
		.createAlias("SubLed", "masSubLed").createAlias("masSubLed.Account", "masAccount")
		.createAlias("Location", "location").add(Restrictions.eq("location.Id", locationId))
		.add(Restrictions.eq("masAccount.Id", accountId)).list();
		map.put("subLedList", subLedList);
		return map;
	}
	/*@Override
	public Map<String, Object> showTrialBalanceJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccountGroup> accountGroupList = new ArrayList<FaMasAccountGroup>();
		List<FaMasAccountSubGroup> accountSubGroupList = new ArrayList<FaMasAccountSubGroup>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		Session session = (Session)getSession();
		accountGroupList = session.createCriteria(FaMasAccountGroup.class).add(Restrictions.eq("FYear.Id", box.getInt("fYear"))).list();
		accountSubGroupList = session.createCriteria(FaMasAccountSubGroup.class).add(Restrictions.eq("FYear.Id", box.getInt("fYear"))).list();
		accountList = session.createCriteria(FaMasAccount.class).add(Restrictions.eq("FYear.Id", box.getInt("fYear"))).list();
		map.put("accountGroupList", accountGroupList);
		map.put("accountSubGroupList", accountSubGroupList);
		map.put("accountList", accountList);
		return map;
	}*/
	@Override
	public Map<String, Object> getTrialBalance(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> voucherDetailList = new ArrayList<Object[]>();
		Session session = (Session)getSession();
		int approvedId= Integer.parseInt(HMSUtil.getProperties("adt.properties", "approvedId"));
		if(box.getString("accountType").equalsIgnoreCase("group")){
		voucherDetailList = session.createCriteria(FaVoucherDetails.class)
								.createAlias("VoucherHeader", "header")
								.createAlias("Account", "account")
								.createAlias("account.AccountSubGroup", "subGroup")
								.createAlias("subGroup.AccountGroup", "group")
								/*.add(Restrictions.eq("header.FYear.Id", box.getInt("fYear")))*/
								.add(Restrictions.eq("header.Hospital.Id", box.getInt("locationId")))
								.add(Restrictions.eq("header.ApprovalStatus.Id",approvedId ))
								.add(Restrictions.between("header.VoucherDate",HMSUtil.dateFormatterDDMMYYYY(box.getString(FROM_DATE)),HMSUtil.dateFormatterDDMMYYYY(box.getString(TO_DATE))))
								.setProjection(Projections.projectionList()
								.add(Projections.sum("DrAmount")).add(Projections.sum("CrAmount")).add(Projections.property("group.AccountGroupDesc"))
								.add(Projections.groupProperty("group.Id")).add(Projections.groupProperty("group.AccountGroupDesc"))).list();
		
		}else if(box.getString("accountType").equalsIgnoreCase("subgroup")){
			voucherDetailList = session.createCriteria(FaVoucherDetails.class).createAlias("VoucherHeader", "header").createAlias("Account", "account")
									.createAlias("account.AccountSubGroup", "subGroup")
										/*.add(Restrictions.eq("header.FYear.Id", box.getInt("fYear")))*/
											.add(Restrictions.eq("header.Hospital.Id", box.getInt("locationId")))
											.add(Restrictions.eq("header.ApprovalStatus.Id",approvedId ))
												.add(Restrictions.between("header.VoucherDate",HMSUtil.dateFormatterDDMMYYYY(box.getString(FROM_DATE)),HMSUtil.dateFormatterDDMMYYYY(box.getString(TO_DATE))))
												.setProjection(Projections.projectionList().add(
														Projections.sum("DrAmount")).add(Projections.sum("CrAmount")).add(Projections.property("subGroup.AccountSubGroupName"))
																.add(Projections.groupProperty("subGroup.Id")).add(Projections.groupProperty("subGroup.AccountSubGroupName"))).list();
			
		}else if(box.getString("accountType").equalsIgnoreCase("account")){
			voucherDetailList = session.createCriteria(FaVoucherDetails.class)
					.createAlias("VoucherHeader", "header")
					.createAlias("Account", "account")
					.add(Restrictions.eq("header.Hospital.Id", box.getInt("locationId")))
					.add(Restrictions.eq("header.ApprovalStatus.Id",approvedId ))
					.add(Restrictions.between("header.VoucherDate",HMSUtil.dateFormatterDDMMYYYY(box.getString(FROM_DATE)),HMSUtil.dateFormatterDDMMYYYY(box.getString(TO_DATE))))
					.setProjection(Projections.projectionList()
							.add(Projections.sum("DrAmount"))
							.add(Projections.sum("CrAmount"))
							.add(Projections.property("account.AccDesc"))
							.add(Projections.groupProperty("account.Id"))
							.add(Projections.groupProperty("account.AccDesc"))).list();
		}
		map.put("voucherDetailList", voucherDetailList);
		return map;
	}
	
	public Map<String, Object> getSubGroupWiseTrialBalance(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> voucherDetailList = new ArrayList<Object[]>();
		Session session = (Session)getSession();
		voucherDetailList = session.createCriteria(FaVoucherDetails.class).createAlias("VoucherHeader", "header").createAlias("Account", "account")
								.createAlias("account.AccountSubGroup", "subGroup").createAlias("subGroup.AccountGroup", "group").add(Restrictions.eq("group.Id", box.getInt("groupId")))
								.add(Restrictions.eq("header.FYear.Id", box.getInt("fYear"))).add(Restrictions.eq("header.Hospital.Id", box.getInt("locationId")))
									.setProjection(Projections.projectionList().add(Projections.sum("DrAmount")).add(Projections.sum("CrAmount")).add(
										Projections.groupProperty("subGroup.Id")).add(Projections.property("subGroup.AccountSubGroupName"))).list();
		map.put("voucherDetailList", voucherDetailList);
		return map;
	}
	@Override
	public Map<String, Object> getAccountWiseTrialBalance(Box box) {
			Map<String, Object> map = new HashMap<String, Object>();
			List<Object[]> voucherDetailList = new ArrayList<Object[]>();
			Session session = (Session)getSession();
			voucherDetailList = session.createCriteria(FaVoucherDetails.class).createAlias("VoucherHeader", "header").createAlias("Account", "account")
									.add(Restrictions.eq("header.FYear.Id", box.getInt("fYear"))).createAlias("account.AccountSubGroup", "subGroup")
									.add(Restrictions.eq("subGroup.Id", box.getInt("subGroupId")))
										.add(Restrictions.eq("header.Hospital.Id", box.getInt("locationId")))
										.setProjection(Projections.projectionList().add(
											Projections.sum("DrAmount")).add(Projections.sum("CrAmount")).add(
											Projections.groupProperty("account.Id")).add(Projections.property("account.AccDesc"))).list();
			map.put("voucherDetailList", voucherDetailList);
			return map;
		}
	@Override
	public Map<String, Object> getVoucherWiseWiseTrialBalance(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> voucherDetailList = new ArrayList<Object[]>();
		Session session = (Session)getSession();
		voucherDetailList = session.createCriteria(FaVoucherDetails.class).createAlias("VoucherHeader", "header").createAlias("Account", "account")
								.add(Restrictions.eq("header.FYear.Id", box.getInt("fYear"))).add(Restrictions.eq("account.Id", box.getInt("accountId")))
									.add(Restrictions.eq("header.Hospital.Id", box.getInt("locationId")))
									.setProjection(Projections.projectionList().add(
										Projections.sum("header.DrAmount")).add(Projections.sum("header.CrAmount"))
										.add(Projections.groupProperty("header.Id"))
										.add(Projections.property("header.VoucherType"))).list();
		map.put("voucherDetailList", voucherDetailList);
		return map;
	}
	@Override
	public Map<String, Object> showDayBookJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		Session session = (Session)getSession();
		accountList = session.createCriteria(FaMasAccount.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AccDesc")).list();
		map.put("accountList", accountList);
		return map;
	}
	@Override
	public Map<String, Object> displayDayBook(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaVoucherDetails> voucherDetailList = new ArrayList<FaVoucherDetails>();
		List<FaVoucherDetails> dayVoucherDetailList= new ArrayList<FaVoucherDetails>();
		List<FaMasAccount> dayBookAccountList = new ArrayList<FaMasAccount>();
		Session session = (Session)getSession();
		voucherDetailList = session.createCriteria(FaVoucherDetails.class).createAlias("VoucherHeader", "header").add(Restrictions.eq("header.FYear.Id", box.getInt("fYear")))
							.add(Restrictions.eq("header.Hospital.Id", box.getInt("locationId")))
							.add(Restrictions.eq("Account.Id", box.getInt(ACCOUNT_ID)))
							//.add(Restrictions.between("header.VoucherDate",HMSUtil.dateFormatterDDMMYYYY(box.getString(FROM_DATE)),HMSUtil.dateFormatterDDMMYYYY(box.getString(TO_DATE))))
							.list();
		dayVoucherDetailList = session.createCriteria(FaVoucherDetails.class).createAlias("VoucherHeader", "header")
									.add(Restrictions.eq("header.FYear.Id", box.getInt("fYear"))).add(Restrictions.eq("Account.Id", box.getInt(ACCOUNT_ID)))
								.add(Restrictions.eq("header.Hospital.Id", box.getInt("locationId")))
							//.add(Restrictions.between("header.VoucherDate",HMSUtil.dateFormatterDDMMYYYY(box.getString(FROM_DATE)),HMSUtil.dateFormatterDDMMYYYY(box.getString(TO_DATE))))

								.list();
		dayBookAccountList = session.createCriteria(FaMasAccount.class).add(Restrictions.idEq(box.getInt(ACCOUNT_ID))).list();
		System.out.println("locationId="+box.getInt("locationId"));
		System.out.println("AccountId="+box.getInt(ACCOUNT_ID));
		System.out.println("voucherDetailList="+voucherDetailList.size());
		map.put("dayBookAccountList", dayBookAccountList);
		map.put("voucherDetailList", voucherDetailList);
		map.put("dayVoucherDetailList", dayVoucherDetailList);
		return map;
	}
	@Override
	public Map<String, Object> showChequeDetailJsp(Box box) {
		Map<String, Object>  map = new HashMap<String, Object>();
		List<MasBankMaster> bankList = new ArrayList<MasBankMaster>();
		Session session = (Session)getSession();
		bankList = session.createCriteria(MasBankMaster.class).add(Restrictions.eq("Status", "y")).list();
		map.put("bankList", bankList);
		return map;
	}
	@Override
	public Map<String, Object> submitChequeDetail(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasBankMaster> bankList = new ArrayList<MasBankMaster>();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session)getSession();
		boolean saved = false;
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String date = (String)utilMap.get("currentDate");	 
		String time = (String)utilMap.get("currentTime");
		try{
			FaChequeDetails chequeDetails = new FaChequeDetails();
			if(!box.getString("chequeBookNo").equals("")){
				chequeDetails.setChequeBookNo(box.getString("chequeBookNo"));
			}
			if(!box.getString("issueDate").equals("")){
				chequeDetails.setIssueDate(HMSUtil.convertStringTypeDateToDateType(box.getString("issueDate")));
			}
			if(!box.getString("fromChequeNo").equals("")){
				chequeDetails.setChequeNoFrom(box.getString("fromChequeNo"));
			}
			if(!box.getString("toChequeNo").equals("")){
				chequeDetails.setChequeNoTo(box.getString("toChequeNo"));
			}
			if(box.getInt("bankId") != 0){
				MasBankMaster masBank  = new MasBankMaster();
				masBank.setId(box.getInt("bankId"));
				chequeDetails.setBank(masBank);
			}
			if(box.getInt("noOfLeaf") != 0){
				chequeDetails.setNoOfCheque(box.getInt("noOfLeaf"));
			}
			if(box.getInt("userId") != 0){
				Users user = new Users();
				user.setId(box.getInt("userId"));
				chequeDetails.setLastChgBy(user);
			}
			if(box.getInt("locationId") != 0){
				MasHospital masHospital = new MasHospital();
				masHospital.setId(box.getInt("locationId"));
				chequeDetails.setLocation(masHospital);
			}
			chequeDetails.setStatus("y");
			chequeDetails.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
			chequeDetails.setLastChgTime(time);
			hbt.save(chequeDetails);
		saved = true;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		bankList = session.createCriteria(MasBankMaster.class).add(Restrictions.eq("Status", "y")).list();
		map.put("bankList", bankList);
		map.put("saved", saved);
		return map;
	}
	@Override
	public Map<String, Object> showChequePrintingJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaVoucherHeader> voucherHeaderList = new ArrayList<FaVoucherHeader>();
		Session session = (Session)getSession();
		voucherHeaderList = session.createCriteria(FaVoucherHeader.class).add(Restrictions.eq("VoucherType", "PV")).list();
		map.put("voucherHeaderList", voucherHeaderList);
		return map;
	}
	@Override
	public Map<String, Object> cancelCheque(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasBankMaster> bankList = new ArrayList<MasBankMaster>();
		List<FaVoucherHeader> voucherHeaderList = new ArrayList<FaVoucherHeader>();
		List<FaChequeDetails> chequeDetailList = new ArrayList<FaChequeDetails>();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session)getSession();
		boolean saved = false;
		int counter = box.getInt("hiddenValueCharge");
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String date = (String)utilMap.get("currentDate");	 
		String time = (String)utilMap.get("currentTime");
		try{
			FaChequeCancel chequePrinting = new FaChequeCancel();
			if(box.getInt("voucherNoId")!= 0){
				FaVoucherHeader voucherHeader = new FaVoucherHeader();
				voucherHeader.setId(box.getInt("voucherNoId"));
				chequePrinting.setVoucherHeader(voucherHeader);
			}
			if(box.getInt("bankId") != 0){
				MasBankMaster masBank  = new MasBankMaster();
				masBank.setId(box.getInt("bankId"));
				chequePrinting.setBank(masBank);
			}
			if(box.getInt("userId") != 0){
				Users user = new Users();
				user.setId(box.getInt("userId"));
				chequePrinting.setLastChgBy(user);
			}
			if(box.getInt("locationId") != 0){
				MasHospital masHospital = new MasHospital();
				masHospital.setId(box.getInt("locationId"));
				chequePrinting.setLocation(masHospital);
			}
			chequePrinting.setReasonForCancle(box.getString("reason"));
			chequePrinting.setStatus("c");
			chequePrinting.setCancelDate(HMSUtil.convertStringTypeDateToDateType(box.getString("cancelDate")));
			chequePrinting.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
			chequePrinting.setLastChgTime(time);
			hbt.save(chequePrinting);
		
			saved = true;
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		chequeDetailList = session.createCriteria(FaChequeDetails.class).add(Restrictions.eq("Status", "y")).list();
		voucherHeaderList = session.createCriteria(FaVoucherHeader.class).add(Restrictions.eq("VoucherType", "PV")).list();
		map.put("voucherHeaderList", voucherHeaderList);
		map.put("bankList", bankList);
		map.put("chequeDetailList", chequeDetailList);
		map.put("saved", saved);
		return map;
	}
	@Override
	public Map<String, Object> getChequeDetail(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaVoucherDetails> voucherDetailsList = new ArrayList<FaVoucherDetails>();
		Session session = (Session)getSession();
		voucherDetailsList = session.createCriteria(FaVoucherDetails.class).createAlias("VoucherHeader", "header").add(Restrictions.eq("header.Id", box.getInt("voucherNoId"))).add(Restrictions.eq("header.VoucherType", "PV")).list();
		map.put("voucherDetailsList", voucherDetailsList);
		return map;
	}
	@Override
	public Map<String, Object> showFixedDepositRegisterJsp(Box box) {
		Map<String, Object> map  = new HashMap<String, Object>();
		List<MasBankMaster> bankList = new ArrayList<MasBankMaster>();
		List<FaMasFdRegister> fdRegisterList = new ArrayList<FaMasFdRegister>();
		Session session = (Session)getSession();
		bankList = session.createCriteria(MasBankMaster.class).add(Restrictions.eq("Status", "y")).list();
		fdRegisterList = session.createCriteria(FaMasFdRegister.class).add(Restrictions.eq("Status", "y"))
				.createAlias("Location","Location").add(Restrictions.eq("Location.Id", box.getInt("locationId")))
				.list();
		map.put("bankList", bankList);
		map.put("fdRegisterList", fdRegisterList);
		return map;
	}
	@Override
	public Map<String, Object> submitFixedDepositRegister(Box box) {
		Map<String, Object> map  = new HashMap<String, Object>();
		List<MasBankMaster> bankList = new ArrayList<MasBankMaster>();
		List<FaMasFdRegister> fdRegisterList = new ArrayList<FaMasFdRegister>();
		Session session = (Session)getSession();
		boolean saved = false;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String date = (String)utilMap.get("currentDate");	 
		String time = (String)utilMap.get("currentTime");
	try{
		FaMasFdRegister  masFdRegister = new FaMasFdRegister();
		if(box.getInt("bankId") != 0){
			MasBankMaster masBankMaster = new MasBankMaster();
			masBankMaster.setId(box.getInt("bankId"));
			masFdRegister.setBank(masBankMaster);
		}
		if(!box.getString("fdrNo").equals("")){
			masFdRegister.setFdrNo(box.getString("fdrNo"));
		}
		if(!box.getString("issueDate").equals("")){
			masFdRegister.setDateOfIssue(HMSUtil.convertStringTypeDateToDateType(box.getString("issueDate")));
		}
		if(!box.getString("dateOfMaturity").equals("")){
			masFdRegister.setDateOfMaturity(HMSUtil.convertStringTypeDateToDateType(box.getString("dateOfMaturity")));
		}
		if(!box.getString("amount").equals("")){
			masFdRegister.setAmount(new BigDecimal(box.getString("amount")));
		}
		if(!box.getString("rateOfInterst").equals("")){
			masFdRegister.setRateOfInterest(new BigDecimal(box.getString("rateOfInterst")));
		}
		if(box.getInt("noOfDays")!= 0){
			masFdRegister.setNoOfDays(box.getInt("noOfDays"));
		}
		if(!box.getString("remarks").equals("")){
			masFdRegister.setRemarks(box.getString("remarks"));
		}
		masFdRegister.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
		masFdRegister.setLastChgTime(time);
		masFdRegister.setStatus("y");
		if(box.getInt("userId") != 0){
			Users user = new Users();
			user.setId(box.getInt("userId"));
			masFdRegister.setLastChgBy(user);
		}
		if(box.getInt("locationId") != 0){
			MasHospital masHospital = new MasHospital();
			masHospital.setId(box.getInt("locationId"));
			masFdRegister.setLocation(masHospital);
		}
		hbt.save(masFdRegister);
		saved = true;
		} catch (Exception e) {
		e.printStackTrace();
	}
		bankList = session.createCriteria(MasBankMaster.class).add(Restrictions.eq("Status", "y")).list();
		fdRegisterList = session.createCriteria(FaMasFdRegister.class).add(Restrictions.eq("Status", "y"))
				.createAlias("Location","Location").add(Restrictions.eq("Location.Id", box.getInt("locationId"))).list();
		map.put("saved", saved);
		map.put("fdRegisterList", fdRegisterList);
		map.put("bankList", bankList);
		return map;
	}
	@Override
	public Map<String, Object> editFixedDepositRegister(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasFdRegister> fdRegisterList = new ArrayList<FaMasFdRegister>();
		List<FaMasFdRegister> fdRegisterIdList = new ArrayList<FaMasFdRegister>();
		List<MasBankMaster> bankList = new ArrayList<MasBankMaster>();
		Session session = (Session)getSession();
		fdRegisterIdList = session.createCriteria(FaMasFdRegister.class).add(Restrictions.idEq(box.getInt("fdRegisterId"))).add(Restrictions.eq("Status", "y")).list();
		fdRegisterList = session.createCriteria(FaMasFdRegister.class).add(Restrictions.eq("Status", "y")).list();
		bankList = session.createCriteria(MasBankMaster.class).add(Restrictions.eq("Status", "y")).list();
		map.put("bankList", bankList);
		map.put("fdRegisterList", fdRegisterList);
		map.put("fdRegisterIdList", fdRegisterIdList);
		return map;
	}
	@Override
	public Map<String, Object> updateFixedDepositRegister(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasFdRegister> fdRegisterList = new ArrayList<FaMasFdRegister>();
		List<MasBankMaster> bankList = new ArrayList<MasBankMaster>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		List<FaMasFdRegister> existingFdRegisterList = new ArrayList<FaMasFdRegister>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Session session = (Session)getSession();
		String message = "";
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		try {
			//existingFdRegisterList = session.createCriteria(FaMasFdRegister.class).add(Restrictions.eq("FdrNo", box.getString("fdrNo"))).list();
			//System.out.println("existingFdRegisterList=="+existingFdRegisterList.size());
			//if (existingFdRegisterList.size() > 0) {
				message = "Record already Exist";
			//} else {
			FaMasFdRegister fdRegister = (FaMasFdRegister) hbt.load(FaMasFdRegister.class,box.getInt("fdId"));
			fdRegister.setFdrNo(box.getString("fdrNo"));
			if(box.getInt("bankId") !=0){
				MasBankMaster masBank = new  MasBankMaster();
				masBank.setId(box.getInt("bankId"));
				fdRegister.setBank(masBank);
			}
			if(!box.getString("issueDate").equals("")){
				fdRegister.setDateOfIssue(HMSUtil.convertStringTypeDateToDateType(box.getString("issueDate")));
			}
			if(!box.getString("dateOfMaturity").equals("")){
				fdRegister.setDateOfMaturity(HMSUtil.convertStringTypeDateToDateType(box.getString("dateOfMaturity")));
			}
			if(!box.getString("amount").equals("")){
				fdRegister.setAmount(new BigDecimal(box.getString("amount")));
			}
			if(!box.getString("rateOfInterst").equals("")){
				fdRegister.setRateOfInterest(new BigDecimal(box.getString("rateOfInterst")));
			}
			if(box.getInt("noOfDays")!= 0){
				fdRegister.setNoOfDays(box.getInt("noOfDays"));
			}
			if(!box.getString("remarks").equals("")){
				fdRegister.setRemarks(box.getString("remarks"));
			}
			Users user = new Users();
			user.setId(box.getInt("changedBy"));
			fdRegister.setLastChgBy(user);
			MasHospital masHospital = new MasHospital();
			masHospital.setId(box.getInt("locationId"));
			fdRegister.setLocation(masHospital);
			
			fdRegister.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
			fdRegister.setLastChgTime(time);
			hbt.update(fdRegister);
			message = "Record update successfully!";
			//}
			
			} catch (DataAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fdRegisterList = session.createCriteria(FaMasFdRegister.class).add(Restrictions.eq("Status", "y")).list();
			bankList = session.createCriteria(MasBankMaster.class).add(Restrictions.eq("Status", "y")).list();
			map.put("bankList", bankList);
			map.put("fdRegisterList", fdRegisterList);
			map.put("message", message);
		return map;
	}
	@Override
	public Map<String, Object> showProfitAndLossAccountJsp(Box box) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<AccountMainTransac> currentFinancialYearAccountList = new ArrayList<AccountMainTransac>();
		List<AccountMainTransac> lastFinancialYearAccountList = new ArrayList<AccountMainTransac>();
		List<MasStoreFinancial> financialYearList = new ArrayList<MasStoreFinancial>();
		List<MasStoreFinancial> lastFinancialYearList = new ArrayList<MasStoreFinancial>();
		Session session = (Session)getSession();
		Criteria cr = null;
		String BalanceSheetType= "";
		BalanceSheetType= box.getString("BalanceSheetType");
		 
		cr = session.createCriteria(AccountMainTransac.class);
		if(!BalanceSheetType.equalsIgnoreCase("ALL"))
		{
			cr= cr.add(Restrictions.eq("Location.Id", box.getInt("locationId")));
		}
		
		cr=cr.add(Restrictions.eq("FinancialYear.Id", box.getInt("fYear")));		
		currentFinancialYearAccountList = cr.list();
		
		financialYearList = session.createCriteria(MasStoreFinancial.class).add(Restrictions.idEq(box.getInt("fYear"))).list();
		int lastFinancialYearId = 0;
		String lastYearDesc = "";
		String currentYearDesc = "";
		if(financialYearList.size()>0){
			currentYearDesc = financialYearList.get(0).getYearDescription();
			lastYearDesc = ""+(Integer.parseInt(currentYearDesc)-1);
			lastFinancialYearList = session.createCriteria(MasStoreFinancial.class).add(Restrictions.eq("YearDescription", lastYearDesc)).list();
			lastFinancialYearId = lastFinancialYearList.get(0).getId();
		}
		
		cr = session.createCriteria(AccountMainTransac.class);
		if(!BalanceSheetType.equalsIgnoreCase("ALL"))
		{
			cr= cr.add(Restrictions.eq("Location.Id", box.getInt("locationId")));
		}
		
		cr=cr.add(Restrictions.eq("FinancialYear.Id", lastFinancialYearId));		
		lastFinancialYearAccountList = cr.list();
		
		
		
		
		map.put("currentFinancialYearAccountList", currentFinancialYearAccountList);
		map.put("lastFinancialYearAccountList", lastFinancialYearAccountList);
		map.put("currentYearDesc", Integer.parseInt(currentYearDesc)+1);
		map.put("lastYearDesc", Integer.parseInt(lastYearDesc)+1);
		return map;
	}
	@Override
	public Map<String, Object> displayScheduleDetail(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<AccountMainTransac> currentScheduleAccountList = new ArrayList<AccountMainTransac>();
		List<AccountMainTransac> lastScheduleAccountList = new ArrayList<AccountMainTransac>();
		List<MasStoreFinancial> lastFinancialIdList = new ArrayList<MasStoreFinancial>();
		List<MasStoreFinancial> currentFinancialIdList = new ArrayList<MasStoreFinancial>();
		Session session = (Session)getSession();
		Criteria cr = null;
		String BalanceSheetType= "";
		 BalanceSheetType= box.getString("BalanceSheetType");
		 System.out.println("BalanceSheetType="+BalanceSheetType);
		cr = session.createCriteria(AccountMainTransac.class);
		if(!BalanceSheetType.equalsIgnoreCase("ALL"))
		{
			System.out.println("1");
			cr= cr.add(Restrictions.eq("Location.Id", box.getInt("locationId")));
			cr = cr.createAlias("Account", "masAccount").add(Restrictions.eq("masAccount.Schedule", box.getInt("schedule")));
			cr=cr.add(Restrictions.eq("FinancialYear.Id", box.getInt("fYear")));
			//cr= cr.setProjection(Projections.groupProperty("masAccount.Id"));
			currentScheduleAccountList= cr.list();
		}else{
			System.out.println("2");
			cr = cr.createAlias("Account", "masAccount").add(Restrictions.eq("masAccount.Schedule", box.getInt("schedule")));
			cr=cr.add(Restrictions.eq("FinancialYear.Id", box.getInt("fYear")));
			currentScheduleAccountList= cr.list();
			System.out.println("schedule currentScheduleAccountList::"+ currentScheduleAccountList);
		}
		
		
		int lastYearDesc = 0;
		if(box.getString("lastYearDesc") != "")
		{
			lastYearDesc = Integer.parseInt(box.getString("lastYearDesc"));
			lastYearDesc = lastYearDesc-1;
			
		}
		lastFinancialIdList = session.createCriteria(MasStoreFinancial.class).add(Restrictions.eq("YearDescription", String.valueOf(lastYearDesc))).list();
		int lastFinancialId = 0;
		Date fromDate = null;
		Date toDate = null;
		if(lastFinancialIdList.size()>0){
			lastFinancialId = lastFinancialIdList.get(0).getId();
		}
		
		int currentYearDesc = 0;
		if(box.getString("currentYearDesc") != "")
		{
			currentYearDesc = Integer.parseInt(box.getString("currentYearDesc"));
			currentYearDesc = currentYearDesc-1;
			
		}
		currentFinancialIdList = session.createCriteria(MasStoreFinancial.class).add(Restrictions.eq("YearDescription", String.valueOf(currentYearDesc))).list();
		if(currentFinancialIdList.size()>0){
			fromDate = currentFinancialIdList.get(0).getStartDate(); 
			toDate = currentFinancialIdList.get(0).getEndDate();
		}
		
		
		cr = session.createCriteria(AccountMainTransac.class);
		if(!BalanceSheetType.equalsIgnoreCase("ALL"))
		{
			System.out.println("3");
			cr= cr.add(Restrictions.eq("Location.Id", box.getInt("locationId")));
			cr = cr.createAlias("Account", "masAccount").add(Restrictions.eq("masAccount.Schedule", box.getInt("schedule")));
			cr=cr.add(Restrictions.eq("FinancialYear.Id", lastFinancialId));
			cr= cr.setProjection(Projections.groupProperty("masAccount.Id"));
			lastScheduleAccountList= cr.list();
		}else{
			System.out.println("4");
			cr = cr.createAlias("Account", "masAccount").add(Restrictions.eq("masAccount.Schedule", box.getInt("schedule")));
			cr=cr.add(Restrictions.eq("FinancialYear.Id", lastFinancialId));
			cr= cr.setProjection(Projections.groupProperty("masAccount.Id"));
			lastScheduleAccountList= cr.list();
			System.out.println("schedule lastScheduleAccountList::"+ lastScheduleAccountList);
		}
		
		
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		map.put("currentScheduleAccountList", currentScheduleAccountList);
		map.put("lastScheduleAccountList", lastScheduleAccountList);
		map.put("BalanceSheetType", BalanceSheetType);
		return map;
	}
	@Override
	public Map<String, Object> displayScheduleDetailForProfitAndLoss(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasScheduleMaster> scheduleList = new ArrayList<MasScheduleMaster>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		List<AccountMainTransac> transactionList = new ArrayList<AccountMainTransac>();
		List<AccountMainTransac> transactionListForPreviousYear = new ArrayList<AccountMainTransac>();
		List<MasStoreFinancial> currentFinancialIdList = new ArrayList<MasStoreFinancial>();
		List<MasStoreFinancial> previousYearFinancialIdList = new ArrayList<MasStoreFinancial>();
		Session session = (Session)getSession();
		
		int locationId =0;
		int scheduleCode = 0;
		int yearDesc = 0;
		int currentYearDesc = 0;
		int previousYearDesc = 0;
		int financialYearId =0;
		Date fromDate = null;
		Date toDate = null;
		
		/*For current financial year*/
		if(box.getInt("yearDesc")!=0){
			yearDesc = box.getInt("yearDesc");
			currentYearDesc =  yearDesc + 1;
		}
		
		/*For previous financial year*/
		if(box.getInt("yearDesc")!=0){
			yearDesc = box.getInt("yearDesc");
			previousYearDesc =  yearDesc - 1;
		}
		
		
		
		if(box.getInt("fYear")!=0){
			financialYearId = box.getInt("fYear");
		}
		
		if(box.getInt("locationId")!=0){
			locationId = box.getInt("locationId");
		}
		
				
		if(box.getInt("scheduleCode") != 0)
		{
			scheduleCode = box.getInt("scheduleCode");
			accountList = session.createCriteria(FaMasAccount.class).add(Restrictions.eq("Schedule", scheduleCode))
					.setProjection(Projections.projectionList().add(Projections.groupProperty("Id"))).list();
			
		}
		
		
		currentFinancialIdList = session.createCriteria(MasStoreFinancial.class).add(Restrictions.eq("YearDescription", String.valueOf(yearDesc))).list();
		if(currentFinancialIdList.size()>0){
			fromDate = currentFinancialIdList.get(0).getStartDate(); 
			toDate = currentFinancialIdList.get(0).getEndDate();
			map.put("fromDate", fromDate);
			map.put("toDate", toDate);
		}
		
		
		previousYearFinancialIdList = session.createCriteria(MasStoreFinancial.class).add(Restrictions.eq("YearDescription", String.valueOf(previousYearDesc))).list();
		if(previousYearFinancialIdList.size()>0){
			fromDate = previousYearFinancialIdList.get(0).getStartDate(); 
			toDate = previousYearFinancialIdList.get(0).getEndDate();
			//map.put("fromDate", fromDate);
			//map.put("toDate", toDate);
		}
		
		
		if(accountList.size()>0){
			transactionList = session.createCriteria(AccountMainTransac.class).add(Restrictions.in("Account.Id", accountList))
					.add(Restrictions.eq("FinancialYear.Id", financialYearId))
					.add(Restrictions.eq("Location.Id", locationId)).list();	
			
			transactionListForPreviousYear = session.createCriteria(AccountMainTransac.class)
					.add(Restrictions.in("Account.Id", accountList))
					.add(Restrictions.eq("FinancialYear.Id", previousYearFinancialIdList.get(0).getId()))
					.add(Restrictions.eq("Location.Id", locationId)).list();
	
		}
		
		
		map.put("yearDesc", yearDesc);
		map.put("currentYearDesc", currentYearDesc);
		map.put("transactionList", transactionList);
		map.put("transactionListForPreviousYear", transactionListForPreviousYear);
		map.put("currentFinancialIdList", currentFinancialIdList);
		map.put("previousYearFinancialIdList", previousYearFinancialIdList);
		return map;
	}
	
	
	
	
	
	@Override
	public Map<String, Object> showBalanceSheet(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<AccountMainTransac> currentFinancialYearAccountList = new ArrayList<AccountMainTransac>();
		List<AccountMainTransac> lastFinancialYearAccountList = new ArrayList<AccountMainTransac>();
		List<MasStoreFinancial> financialYearList = new ArrayList<MasStoreFinancial>();
		List<MasStoreFinancial> lastFinancialYearList = new ArrayList<MasStoreFinancial>();
		Session session = (Session)getSession();
		Criteria cr = null;
		String BalanceSheetType= "";
		BalanceSheetType= box.getString("BalanceSheetType");
		 
		cr = session.createCriteria(AccountMainTransac.class);
		if(!BalanceSheetType.equalsIgnoreCase("ALL")){
			cr= cr.add(Restrictions.eq("Location.Id", box.getInt("locationId")));
			cr=cr.add(Restrictions.eq("FinancialYear.Id", box.getInt("fYear")));		
			currentFinancialYearAccountList = cr.list();
		}
		else{
			currentFinancialYearAccountList = session.createCriteria(AccountMainTransac.class).add(Restrictions.eq("FinancialYear.Id", box.getInt("fYear"))).list();
		}
		
		
		financialYearList = session.createCriteria(MasStoreFinancial.class).add(Restrictions.idEq(box.getInt("fYear"))).list();
		int lastFinancialYearId = 0;
		String lastYearDesc = "";
		String currentYearDesc = "";
		if(financialYearList.size()>0){
			currentYearDesc = financialYearList.get(0).getYearDescription();
			lastYearDesc = ""+(Integer.parseInt(currentYearDesc)-1);
			lastFinancialYearList = session.createCriteria(MasStoreFinancial.class).add(Restrictions.eq("YearDescription", lastYearDesc)).list();
			lastFinancialYearId = lastFinancialYearList.get(0).getId();
		}
		
		cr = session.createCriteria(AccountMainTransac.class);
		if(!BalanceSheetType.equalsIgnoreCase("ALL"))
		{
			cr= cr.add(Restrictions.eq("Location.Id", box.getInt("locationId")));
			cr=cr.add(Restrictions.eq("FinancialYear.Id", lastFinancialYearId));		
			lastFinancialYearAccountList = cr.list();
		}else{
			lastFinancialYearAccountList = session.createCriteria(AccountMainTransac.class).add(Restrictions.eq("FinancialYear.Id", lastFinancialYearId)).list();
		}
		
		
		
		
		
		
		map.put("currentFinancialYearAccountList", currentFinancialYearAccountList);
		map.put("lastFinancialYearAccountList", lastFinancialYearAccountList);
		map.put("currentYearDesc", Integer.parseInt(currentYearDesc)+1);
		map.put("lastYearDesc", Integer.parseInt(lastYearDesc)+1);
		return map;
	}
	
	
	@Override
	public Map<String, Object> showEMDRegisterJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasBankMaster> bankList = new ArrayList<MasBankMaster>();
		List<FaEmdRegister> emdRegisterList = new ArrayList<FaEmdRegister>();
		Session session = (Session)getSession();
		bankList = session.createCriteria(MasBankMaster.class).add(Restrictions.eq("Status", "y")).list();
		emdRegisterList = session.createCriteria(FaEmdRegister.class).add(Restrictions.eq("Status", "y")).list();
		map.put("emdRegisterList", emdRegisterList);
		map.put("bankList", bankList);
		return map;
	}
	/*@Override
	public Map<String, Object> submitEMDRegister(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasBankMaster> bankList = new ArrayList<MasBankMaster>();
		List<FaEmdRegister> emdRegisterList = new ArrayList<FaEmdRegister>();
		Session session = (Session)getSession();
		boolean saved = false;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String date = (String)utilMap.get("currentDate");	 
		String time = (String)utilMap.get("currentTime");
		int emdRegId=0;
	try{
		FaEmdRegister  emdRegister = new FaEmdRegister();
		if(box.getInt("bankId") != 0){
			MasBankMaster masBankMaster = new MasBankMaster();
			masBankMaster.setId(box.getInt("bankId"));
			emdRegister.setBank(masBankMaster);
		}
		if(!box.getString("tenderNo").equals("")){
			emdRegister.setTenderNo(box.getString("tenderNo"));
		}
		if(!box.getString("soNo").equals("")){
			emdRegister.setSoNo(box.getString("soNo"));
		}
		if(!box.getString("organisation").equals("")){
			emdRegister.setOrganization(box.getString("organisation"));
		}
		if(!box.getString("date").equals("")){
			emdRegister.setDate(HMSUtil.convertStringTypeDateToDateType(box.getString("date")));
		}
		if(!box.getString("fromDate").equals("")){
			emdRegister.setFromDate(HMSUtil.convertStringTypeDateToDateType(box.getString("fromDate")));
		}
		if(!box.getString("amount").equals("")){
			emdRegister.setEmdAmount(new BigDecimal(box.getString("amount")));
		}
		if(!box.getString("toDate").equals("")){
			emdRegister.setToDate(HMSUtil.convertStringTypeDateToDateType(box.getString("toDate")));
		}
		if(!box.getString("remarks").equals("")){
			emdRegister.setRemarks(box.getString("remarks"));
		}
		if(!box.getString("remarks").equals("")){
			emdRegister.setRemarks(box.getString("remarks"));
		}
	
		emdRegister.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
		emdRegister.setLastChgTime(time);
		emdRegister.setStatus("y");
		if(box.getInt("userId") != 0){
			Users user = new Users();
			user.setId(box.getInt("userId"));
			emdRegister.setLastChgBy(user);
		}
		if(box.getInt("locationId") != 0){
			MasHospital masHospital = new MasHospital();
			masHospital.setId(box.getInt("locationId"));
			emdRegister.setLocation(masHospital);
		}

		hbt.save(emdRegister);
		session.refresh(emdRegister);
		emdRegId=emdRegister.getId();
		saved = true;
		} catch (Exception e) {
			emdRegId=0;
		e.printStackTrace();
	}
		bankList = session.createCriteria(MasBankMaster.class).add(Restrictions.eq("Status", "y")).list();
		emdRegisterList = session.createCriteria(FaEmdRegister.class).add(Restrictions.eq("Status", "y")).list();
		map.put("saved", saved);
		map.put("emdRegisterList", emdRegisterList);
		map.put("bankList", bankList);
		map.put("emdRegId", emdRegId);
		return map;
	}*/
	
	@Override
	public Map<String, Object> submitEMDRegister(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasBankMaster> bankList = new ArrayList<MasBankMaster>();
		List<FaEmdRegister> emdRegisterList = new ArrayList<FaEmdRegister>();
		Session session = (Session)getSession();
		boolean saved = false;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String date = (String)utilMap.get("currentDate");	 
		String time = (String)utilMap.get("currentTime");
		int emdRegId=0;
	try{
		FaEmdRegister  emdRegister = new FaEmdRegister();
		if(box.getInt("bankId") != 0){
			MasBankMaster masBankMaster = new MasBankMaster();
			masBankMaster.setId(box.getInt("bankId"));
			emdRegister.setBank(masBankMaster);
		}
		if(!box.getString("tenderNo").equals("")){
			emdRegister.setTenderNo(box.getString("tenderNo"));
		}
		if(!box.getString("soNo").equals("")){
			emdRegister.setSoNo(box.getString("soNo"));
		}
		if(!box.getString("organisation").equals("")){
			emdRegister.setOrganization(box.getString("organisation"));
		}
		if(!box.getString("date").equals("")){
			emdRegister.setDate(HMSUtil.convertStringTypeDateToDateType(box.getString("date")));
		}
		if(!box.getString("fromDate").equals("")){
			emdRegister.setFromDate(HMSUtil.convertStringTypeDateToDateType(box.getString("fromDate")));
		}
		if(!box.getString("amount").equals("")){
			emdRegister.setEmdAmount(new BigDecimal(box.getString("amount")));
		}
		if(!box.getString("toDate").equals("")){
			emdRegister.setToDate(HMSUtil.convertStringTypeDateToDateType(box.getString("toDate")));
		}
		if(!box.getString("remarks").equals("")){
			emdRegister.setRemarks(box.getString("remarks"));
		}
	
		if(!box.getString("voucherType").equals("") && !box.getString("voucherType").isEmpty()){
			emdRegister.setVoucherType(box.getString("voucherType"));
		}
		emdRegister.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
		emdRegister.setLastChgTime(time);
		emdRegister.setStatus("y");
		if(box.getInt("userId") != 0){
			Users user = new Users();
			user.setId(box.getInt("userId"));
			emdRegister.setLastChgBy(user);
		}
		if(box.getInt("locationId") != 0){
			MasHospital masHospital = new MasHospital();
			masHospital.setId(box.getInt("locationId"));
			emdRegister.setLocation(masHospital);
		}

		hbt.save(emdRegister);
		session.refresh(emdRegister);
		emdRegId=emdRegister.getId();
		saved = true;
		} catch (Exception e) {
			emdRegId=0;
		e.printStackTrace();
	}
		bankList = session.createCriteria(MasBankMaster.class).add(Restrictions.eq("Status", "y")).list();
		emdRegisterList = session.createCriteria(FaEmdRegister.class).add(Restrictions.eq("Status", "y"))
				.add(Restrictions.eq("Location.Id", box.getInt("locationId"))).list();
		map.put("saved", saved);
		map.put("emdRegisterList", emdRegisterList);
		map.put("bankList", bankList);
		map.put("emdRegId", emdRegId);
		return map;
	}
	
	@Override
	public Map<String, Object> editEMDRegister(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaEmdRegister> emdRegisterList = new ArrayList<FaEmdRegister>();
		List<FaEmdRegister> emdRegisterIdList = new ArrayList<FaEmdRegister>();
		List<MasBankMaster> bankList = new ArrayList<MasBankMaster>();
		Session session = (Session)getSession();
		emdRegisterIdList = session.createCriteria(FaEmdRegister.class).add(Restrictions.idEq(box.getInt("emdRegisterId"))).add(Restrictions.eq("Status", "y")).list();
		emdRegisterList = session.createCriteria(FaEmdRegister.class).add(Restrictions.eq("Status", "y")).list();
		bankList = session.createCriteria(MasBankMaster.class).add(Restrictions.eq("Status", "y")).list();
		map.put("bankList", bankList);
		map.put("emdRegisterList", emdRegisterList);
		map.put("emdRegisterIdList", emdRegisterIdList);
		return map;
	}
	public Map<String, Object> updateEmdDepositRegister(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaEmdRegister> emdRegisterList = new ArrayList<FaEmdRegister>();
		List<MasBankMaster> bankList = new ArrayList<MasBankMaster>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		List<FaEmdRegister> existingEmdRegisterList = new ArrayList<FaEmdRegister>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Session session = (Session)getSession();
		String message = "";
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			FaEmdRegister emdRegister = (FaEmdRegister) hbt.load(FaEmdRegister.class,box.getInt("emdRegisterId"));
			if(box.getInt("bankId") != 0){
				MasBankMaster masBankMaster = new MasBankMaster();
				masBankMaster.setId(box.getInt("bankId"));
				emdRegister.setBank(masBankMaster);
			}
			if(!box.getString("tenderNo").equals("")){
				emdRegister.setTenderNo(box.getString("tenderNo"));
			}
			if(!box.getString("soNo").equals("")){
				emdRegister.setSoNo(box.getString("soNo"));
			}
			if(!box.getString("organisation").equals("")){
				emdRegister.setOrganization(box.getString("organisation"));
			}
			if(!box.getString("date").equals("")){
				emdRegister.setDate(HMSUtil.convertStringTypeDateToDateType(box.getString("date")));
			}
			if(!box.getString("fromDate").equals("")){
				emdRegister.setFromDate(HMSUtil.convertStringTypeDateToDateType(box.getString("fromDate")));
			}
			if(!box.getString("amount").equals("")){
				emdRegister.setEmdAmount(new BigDecimal(box.getString("amount")));
			}
			if(!box.getString("toDate").equals("")){
				emdRegister.setToDate(HMSUtil.convertStringTypeDateToDateType(box.getString("toDate")));
			}
			if(!box.getString("remarks").equals("")){
				emdRegister.setRemarks(box.getString("remarks"));
			}
			if(!box.getString("voucherType").equals("") && !box.getString("voucherType").isEmpty()){
				emdRegister.setVoucherType(box.getString("voucherType"));
			}
		
			emdRegister.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
			emdRegister.setLastChgTime(time);
			emdRegister.setStatus("y");
			if(box.getInt("userId") != 0){
				Users user = new Users();
				user.setId(box.getInt("userId"));
				emdRegister.setLastChgBy(user);
			}
			if(box.getInt("locationId") != 0){
				MasHospital masHospital = new MasHospital();
				masHospital.setId(box.getInt("locationId"));
				emdRegister.setLocation(masHospital);
			}
			hbt.update(emdRegister);
			session.refresh(emdRegister);
			message = "Record update successfully!!";
			
			
			} catch (DataAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		emdRegisterList = session.createCriteria(FaEmdRegister.class).add(Restrictions.eq("Status", "y")).list();
		map.put("emdRegisterList", emdRegisterList);
		map.put("message",message);
		return map;
	}
	@Override
	public Map<String, Object> showAgingAnalysisJsp(Box box) {
		Map<String,Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).list();
		map.put("hospitalList", hospitalList);
		return map;
	}
	@Override
	public Map<String, Object> displayAgingAnalysis(Box box) {
		Map<String,Object> map = new HashMap<String, Object>();
		List<BlDispensingHeader> dispensingHeaderList = new ArrayList<BlDispensingHeader>();
		Session session = (Session)getSession();
		if(box.getInt("center")!= 0){
		    dispensingHeaderList = session.createCriteria(BlDispensingHeader.class).add(Restrictions.eq("BillStatus", "outstanding"))
		    							.add(Restrictions.eq("Location.Id", box.getInt("center")))
									.list();
		}else{
		    dispensingHeaderList = session.createCriteria(BlDispensingHeader.class).add(Restrictions.eq("BillStatus", "outstanding"))
									.list();
		}
		map.put("dispensingHeaderList", dispensingHeaderList);
		return map;
	}
	@Override
	public Map<String, Object> getCenterList(Box box) {
		Map<String,Object> map = new HashMap<String, Object>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		Session session = (Session)getSession();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).list();
		map.put("hospitalList", hospitalList);
		return map;
	}
	@Override
	public Map<String, Object> dispalyInvoiceBillingAmount(Box box) {
		Map<String,Object> map = new HashMap<String, Object>();
		List<Object[]> invoiceMappingList = new ArrayList<Object[]>();
		List<FaMasSubLed> subLedListOfSaleAc = new ArrayList<FaMasSubLed>();
		Session session = (Session)getSession();
		SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
		String fromDate4MySQL = "";
		String toDate4MySQL = "";
		String fromDate = "";
		String toDate = "";
		int salesAccountId=0;
		int locationId = box.getInt("locationId");
		
		 salesAccountId	= Integer.parseInt(HMSUtil.getProperties("adt.properties","SALE_ACCOUNT"));
		 
		try {
			fromDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(FROM_DATE)));
			 toDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(TO_DATE)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String invoiceQueryString ="select bdh.dispensing_header_id,a.account_id,a.sub_led_id,a.sub_led_desc,mr.rsk_name,bdh.outstanding,bdh.billing_type,bdh.action_type,bdh.bill_invoice_no "+
				" from bl_dispensing_header bdh "+
				" left outer join fa_mas_sub_led a on a.rsk_id = bdh.rsk_id "+
				" left outer join mas_rsk mr on mr.id = bdh.rsk_id "+
				" where action_type='Invoice' " +
				" and bdh.voucher_no is null "+
				" and a.hospital_id="+locationId+""+
				" and bdh.location_id="+locationId+""+
				" and bdh.bill_invoice_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"'";
			
		invoiceMappingList = session.createSQLQuery(invoiceQueryString).list();

		subLedListOfSaleAc =session.createCriteria(FaMasSubLed.class)
				.createAlias("Account", "acc")
				.createAlias("Hospital", "location")
				.add(Restrictions.eq("acc.Id", salesAccountId))
				.add(Restrictions.eq("location.Id", locationId)).list();

		map.put("invoiceMappingList", invoiceMappingList);
		map.put("subLedListOfSaleAc",subLedListOfSaleAc);
		map.put("fromDate",HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE)));
		map.put("toDate",HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE)));
		return map;
	}
	@Override
	public Map<String, Object> postInvoiceVoucherMapping(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session)getSession();
		Transaction tx = null;
		boolean saved = false;
		int voucherNo = 0;
		int count=1;
		if(box.getInt("count") != 0){
			count = (Integer)box.getInt("count");
		}
		
		try {
			tx = session.beginTransaction();
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			String fromDate4MySQL = "";
			String toDate4MySQL = "";
			int approvalStatus = Integer.parseInt(HMSUtil.getProperties("adt.properties", "approvedId"));
			try {
				fromDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(FROM_DATE)));
				 toDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(TO_DATE)));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		for (int j = 1; j < count; j++) {
			if(box.getString("voucherCnt"+j).equals("y")){
				FaVoucherHeader faVoucherHeader = new FaVoucherHeader();
				MasHospital masHospital = new MasHospital();
				masHospital.setId(box.getInt("locationId"));
				faVoucherHeader.setHospital(masHospital);
				faVoucherHeader.setVoucherDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
				faVoucherHeader.setVoucherTime(box.getString(CHANGED_TIME));
				
				
				Users users = new Users();
				users.setId( box.getInt("changedBy"));
				faVoucherHeader.setLastChgBy(users);
				faVoucherHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
				faVoucherHeader.setLastChgTime(box.getString(CHANGED_TIME));
				if(box.getInt("blDispensingHeaderId"+j) != 0){
					faVoucherHeader.setVoucherType("SV");
				}else if(box.getInt("rskPaymentVoucherMappingId"+j) != 0){
					faVoucherHeader.setVoucherType("PV");
				}
				else if(box.getInt("rskSalesReturnVoucherId"+j) != 0){
					faVoucherHeader.setVoucherType("SR");
				}
				faVoucherHeader.setNarration(box.getString("voucherNarrationId"+j));
				faVoucherHeader.setStatus("y");
				
	
				BigDecimal totalAmountDr = new BigDecimal(0.0);
				BigDecimal totalAmountCr = new BigDecimal(0.0);
			
			if (!box.getString("amountId"+j).equals("")) {
				totalAmountDr = new BigDecimal(box.getString("amountId"+j));
				faVoucherHeader.setDrAmount(totalAmountDr);
			}
			if (!box.getString("amountId"+j).equals("")) {
				totalAmountCr = new BigDecimal(box.getString("amountId"+j));
				faVoucherHeader.setCrAmount(totalAmountCr);
			}
			MasStoreFinancial masStoreFinancial = new MasStoreFinancial();
			masStoreFinancial.setId(box.getInt("fYear"));
			faVoucherHeader.setFYear(masStoreFinancial);
			
			paramMap.put("suffix", box.getString("fYearDesc"));
			paramMap.put("flag", "save");
			if(box.getInt("blDispensingHeaderId"+j) != 0){
				paramMap.put("prefix", "SV");
				paramMap.put("voucherType", "Sales");
			}else if(box.getInt("rskPaymentVoucherMappingId"+j) != 0){
				paramMap.put("prefix", "PV");
				paramMap.put("voucherType", "Payment");
			}else if(box.getInt("rskSalesReturnVoucherId"+j) != 0){
				paramMap.put("prefix", "SR");
				paramMap.put("voucherType", "Sales Return");
			}
			
			paramMap.put("locationId", box.getInt("locationId"));
			paramMap.put("financialYearId", box.getInt("fYear"));
			
			voucherNo = generateVoucherNo(paramMap);
			
			
				String locationCode="";
				String yearDesc="";
				List<MasStoreFinancial>financialList=new ArrayList<MasStoreFinancial>();
				List<MasHospital>hospitalList=new ArrayList<MasHospital>();
				hospitalList=session.createCriteria(MasHospital.class).add(Restrictions.idEq(box.getInt("locationId"))).list();
				for(MasHospital mg:hospitalList){
					locationCode=mg.getHospitalCode();
				}
				financialList=session.createCriteria(MasStoreFinancial.class).add(Restrictions.idEq(box.getInt("fYear"))).list();
				for(MasStoreFinancial msf1:financialList){
					yearDesc=msf1.getYearDescription();
				}
				
				
				if(box.getInt("blDispensingHeaderId"+j) != 0){
					faVoucherHeader.setVoucherNo("SV/"+locationCode+"/"+yearDesc+"/"+voucherNo);
				}else if(box.getInt("rskPaymentVoucherMappingId"+j) != 0){
					faVoucherHeader.setVoucherNo("PV/"+locationCode+"/"+yearDesc+"/"+voucherNo);
				}
				else if(box.getInt("rskSalesReturnVoucherId"+j) != 0){
					faVoucherHeader.setVoucherNo("SR/"+locationCode+"/"+yearDesc+"/"+voucherNo);
				}
				
				MasApprovalStatus masApprovalStatus = new MasApprovalStatus();
				masApprovalStatus.setId(approvalStatus);
				faVoucherHeader.setApprovalStatus(masApprovalStatus);
				faVoucherHeader.setAcknowedgeStatus(masApprovalStatus);
				
				hbt.save(faVoucherHeader);
				map.put("voucherType", faVoucherHeader.getVoucherType());
				
			
			if(box.getInt("AccountNameCr"+j)!=0){
				BigDecimal crAmt = new BigDecimal(0.00);
				BigDecimal drAmt = new BigDecimal(0.00);
				FaVoucherDetails voucherDetails = new FaVoucherDetails();
				FaMasAccount masAccount = new FaMasAccount();
				masAccount.setId(box.getInt("AccountNameCr"+j));
				voucherDetails.setAccount(masAccount);
				voucherDetails.setVoucherHeader(faVoucherHeader);
				if(box.getInt("crSubLedId"+j) != 0){
					FaMasSubLed subLed= new FaMasSubLed();
					subLed.setId(box.getInt("crSubLedId"+j));
					voucherDetails.setSubLed(subLed);
				}
				
				crAmt = new BigDecimal(box.getString("amountId"+j));
				voucherDetails.setCrAmount(crAmt);
				voucherDetails.setDrAmount(new BigDecimal(0));
				hbt.save(voucherDetails);
				
				updateTransactionForPayment(box.getInt("crSubLedId"+j),box.getInt("AccountNameCr"+j), box.getInt("fYear"), box.getInt("locationId"), ""+crAmt, ""+drAmt,box.getInt("locationId") );
			}
				
				
			if(box.getInt("AccountNameDr"+j)!=0){
				BigDecimal crAmt = new BigDecimal(0.00);
				BigDecimal drAmt = new BigDecimal(0.00);
				FaVoucherDetails voucherDetails = new FaVoucherDetails();
				FaMasAccount masAccount = new FaMasAccount();
				masAccount.setId(box.getInt("AccountNameDr"+j));
				voucherDetails.setAccount(masAccount);
				voucherDetails.setVoucherHeader(faVoucherHeader);
				if(box.getInt("drSubLedId"+j) != 0){
					FaMasSubLed subLed= new FaMasSubLed();
					subLed.setId(box.getInt("drSubLedId"+j));
					voucherDetails.setSubLed(subLed);
				}
				
				drAmt = new BigDecimal(box.getString("amountId"+j));
				voucherDetails.setDrAmount(drAmt);
				voucherDetails.setCrAmount(new BigDecimal(0));
				hbt.save(voucherDetails);
				
				updateTransactionForPayment(box.getInt("drSubLedId"+j),box.getInt("AccountNameDr"+j), box.getInt("fYear"), box.getInt("locationId"), ""+crAmt, ""+drAmt,box.getInt("locationId") );
			}
			
			
			int dispensingId =0;
			if(box.getInt("blDispensingHeaderId"+j) != 0){
				BlDispensingHeader blDispensinhHeader = (BlDispensingHeader)hbt.load(BlDispensingHeader.class, box.getInt("blDispensingHeaderId"+j));
				blDispensinhHeader.setVoucherNo(""+faVoucherHeader.getId());
				dispensingId = blDispensinhHeader.getId();
				hbt.update(blDispensinhHeader);
				map.put("dispensingId", dispensingId);
			}
			
			int rskPaymentId =0;
			if(box.getInt("rskPaymentVoucherMappingId"+j) != 0){
				RskPaymentDetails rskPaymentDetails = (RskPaymentDetails)hbt.load(RskPaymentDetails.class, box.getInt("rskPaymentVoucherMappingId"+j));
				rskPaymentDetails.setVoucherNo(faVoucherHeader.getId());
				rskPaymentId = rskPaymentDetails.getId();
				hbt.update(rskPaymentDetails);
				map.put("rskPaymentId", rskPaymentId);
			}
			
			int rskSalesReturnId=0;
			if(box.getInt("rskSalesReturnVoucherId"+j) != 0){
				RskReturn rskSalesReturn = (RskReturn)hbt.load(RskReturn.class, box.getInt("rskSalesReturnVoucherId"+j));
				rskSalesReturn.setVoucherNo(faVoucherHeader.getId());
				rskSalesReturnId = rskSalesReturn.getId();
				hbt.update(rskSalesReturn);
				map.put("rskSalesReturnId", rskSalesReturnId);
			}
		}
		}
			tx.commit();
			saved = true;
		
		} catch (RuntimeException e) {
					if (tx != null)
						tx.rollback();
					e.printStackTrace();
				}
		
				map.put("voucherNo", voucherNo);
				map.put("saved", saved);
				
		return map;
	}
	
	
	@Override
	public Map<String, Object> displayInvoiceSettlement(Box box) {
		Map<String,Object> map = new HashMap<String, Object>();
		List<Object[]> rskReturnVoucherList = new ArrayList<Object[]>();
		List<FaMasSubLed> subLedListOfSaleAc = new ArrayList<FaMasSubLed>();
		Session session = (Session)getSession();
		SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
		String fromDate4MySQL = "";
		String toDate4MySQL = "";
		String fromDate = "";
		String toDate = "";
		int salesAccountId=0;
		int locationId = box.getInt("locationId");
		
		 salesAccountId	= Integer.parseInt(HMSUtil.getProperties("adt.properties","SALE_ACCOUNT"));
		 
		try {
			fromDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(FROM_DATE)));
			 toDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(TO_DATE)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String invoiceQueryString ="select rt.id,a.account_id,fma.acc_desc,a.sub_led_id,a.sub_led_desc,rt.return_value,msi.nomenclature,msiv.item_variety_name,msic.item_class_name,msf.year_description,rt.lot_no "+
				" from rsk_return rt "+
				" left outer join fa_mas_sub_led a on a.rsk_id = rt.rsk_id "+
				" left outer join fa_mas_account fma on fma.acc_id = a.account_id "+
				" left outer join mas_hospital mh on mh.hospital_id = a.hospital_id "+
				"  left outer join mas_store_item msi on msi.item_id = rt.item_id "+
				" left outer join mas_store_item_variety msiv on msiv.item_variety_id = rt.variety_id "+
				" left outer join mas_store_item_class msic on msic.item_class_id = rt.class_id "+
				" left outer join mas_store_financial msf on msf.financial_id = rt.year_id "+
				" where rt.voucher_no is null "+
				" and a.hospital_id="+locationId+""+
				" and rt.last_chg_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"'";
		
		rskReturnVoucherList = session.createSQLQuery(invoiceQueryString).list();

		subLedListOfSaleAc =session.createCriteria(FaMasSubLed.class)
				.createAlias("Account", "acc")
				.createAlias("Hospital", "location")
				.add(Restrictions.eq("acc.Id", salesAccountId))
				.add(Restrictions.eq("location.Id", locationId)).list();

		map.put("rskReturnVoucherList", rskReturnVoucherList);
		map.put("subLedListOfSaleAc",subLedListOfSaleAc);
		map.put("fromDate",HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE)));
		map.put("toDate",HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE)));
		
		return map;
	}
	
	/*@Override
	public Map<String, Object> displayInvoiceSettlement(Box box) {
		Map<String,Object> map = new HashMap<String, Object>();
		List<Object[]> invoiceSettlementList = new ArrayList<Object[]>();
		Session session = (Session)getSession();
		SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
		String fromDate4MySQL = "";
		String toDate4MySQL = "";
		String fromDate = "";
		String toDate = "";
		try {
			fromDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(FROM_DATE)));
			 toDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(TO_DATE)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String invoiceSettlementQueryString = "SELECT mss.supplier_name,ifnull(cash_q.amt,0) as cash," +
				" ifnull(chq_q.amt,0) as cheque,ifnull(cc_q.amt,0) as credit,(ifnull(cash_q.amt,0)+ifnull(chq_q.amt,0)+ifnull(cc_q.amt,0)) as outstanding," +
				" bdh.dispensing_header_id,brh.receipt_header_id " +
				" FROM bl_dispensing_details bdd left join bl_dispensing_header bdh on bdh.dispensing_header_id = bdd.dispensing_header_id " +
				" left join bl_receipt_header brh on bdh.dispensing_header_id = brh.dispensing_header_id left join " +
				" (select sum(ifnull(rd.amount,0))as amt,dh.purchaser_name as supp  from bl_receipt_details rd left outer join " +
				" bl_receipt_header rh on rd.receipt_header_id=rh.receipt_header_id left outer join bl_dispensing_header dh on " +
				"  rh.dispensing_header_id=dh.dispensing_header_id where rd.payment_mode='C' and  dh.action_type='Invoice'" +
				" and rh.status = 'FS Invoice' group by purchaser_name) as cash_q on cash_q.supp=bdh.purchaser_name left join " +
				" (select sum(ifnull(rd.amount,0))as amt,dh.purchaser_name as supp  from bl_receipt_details rd left outer join " +
				" bl_receipt_header rh on rd.receipt_header_id=rh.receipt_header_id left outer join bl_dispensing_header dh on " +
				" rh.dispensing_header_id=dh.dispensing_header_id where rd.payment_mode='Q' and  dh.action_type='Invoice' " +
				"  and rh.status = 'FS Invoice' group by purchaser_name) as chq_q on chq_q.supp=bdh.purchaser_name left join " +
				" (select sum(ifnull(rd.amount,0))as amt,dh.purchaser_name as supp  from bl_receipt_details rd left outer join " +
				"  bl_receipt_header rh on rd.receipt_header_id=rh.receipt_header_id left outer join bl_dispensing_header dh on " +
				" rh.dispensing_header_id=dh.dispensing_header_id where rd.payment_mode='R' and  dh.action_type='Invoice' " +
				" and rh.status = 'FS Invoice'  group by purchaser_name) as cc_q on cc_q.supp=bdh.purchaser_name left outer join" +
				" mas_store_supplier mss on bdh.purchaser_name=mss.supplier_id left join mas_external_agency_type at on mss.agency_type_id=at.agency_type_id " +
				"where action_type='Invoice' and bill_status = 'settled' and bdh.voucher_no is null and brh.receipt_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' group by purchaser_name";
		invoiceSettlementList = session.createSQLQuery(invoiceSettlementQueryString).list();
		map.put("invoiceSettlementList", invoiceSettlementList);
		map.put("fromDate",HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE)));
		map.put("toDate",HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE)));
		return map;
	}*/
	@Override
	public Map<String, Object> postInvoiceSettlementVoucherMapping(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> paramMap = new HashMap<String, Object>();
	List<BlDispensingHeader> dispensingHeaderList = new ArrayList<BlDispensingHeader>();
	List<BlReceiptHeader> receiptHeaderList = new ArrayList<BlReceiptHeader>();
	List<FaAccountParameter> accountParameterList = new ArrayList<FaAccountParameter>();
	
	HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	Session session = (Session)getSession();
	Transaction tx = null;
	boolean saved = false;


	try {
		tx = session.beginTransaction();
		SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
		String fromDate4MySQL = "";
		String toDate4MySQL = "";
		int voucherNo = 0;
		try {
			fromDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(FROM_DATE)));
			 toDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(TO_DATE)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int cashAccountId = 0;int cashSubLedId = 0; int cashSubGroupId = 0; int cashGroupId = 0; 
		int bankAccountId = 0; int bankSubLedId = 0; int bankSubGroupId = 0; int bankGroupId = 0;
		int creditCardAccountId = 0;int creditCardSubLedId = 0; int creditCardSubGroupId = 0; int creditCardGroupId = 0;
		int osAccountId = 0;int osSubLedId = 0;int osSubGroupId = 0; int osGroupId = 0;
		
		accountParameterList = session.createCriteria(FaAccountParameter.class).add(Restrictions.eq("Status", "y")).list();
		if(accountParameterList.size()>0){
			for(FaAccountParameter accountParameter :accountParameterList){
				if(accountParameter.getAccountType().equals("Cash")){
					if(accountParameter.getAccount() != null){
						cashAccountId = accountParameter.getAccount().getId();
						cashSubGroupId = accountParameter.getAccount().getAccountSubGroup().getId();
						cashGroupId = accountParameter.getAccount().getAccountSubGroup().getAccountGroup().getId();
					}
					if(accountParameter.getSubLed()!= null){
						cashSubLedId = accountParameter.getSubLed().getId();
					}
				}
				if(accountParameter.getAccountType().equals("Bank")){
					if(accountParameter.getAccount() != null){
						bankAccountId = accountParameter.getAccount().getId();
						bankSubGroupId = accountParameter.getAccount().getAccountSubGroup().getId();
						bankGroupId = accountParameter.getAccount().getAccountSubGroup().getAccountGroup().getId();
					}
					if(accountParameter.getSubLed()!= null){
						bankSubLedId = accountParameter.getSubLed().getId();
					}
				}
				if(accountParameter.getAccountType().equals("Credit Card")){
					if(accountParameter.getAccount() != null){
						creditCardAccountId = accountParameter.getAccount().getId();
						creditCardSubGroupId = accountParameter.getAccount().getAccountSubGroup().getId();
						creditCardGroupId = accountParameter.getAccount().getAccountSubGroup().getAccountGroup().getId();
					}
					if(accountParameter.getSubLed()!= null){
						creditCardSubLedId = accountParameter.getSubLed().getId();
					}
				}
			
				if(accountParameter.getAccountType().equals("Outstanding")){
					if(accountParameter.getAccount() != null){
						osAccountId = accountParameter.getAccount().getId();
						osSubGroupId = accountParameter.getAccount().getAccountSubGroup().getId();
						osGroupId = accountParameter.getAccount().getAccountSubGroup().getAccountGroup().getId();
					}
					if(accountParameter.getSubLed()!= null){
						osSubLedId = accountParameter.getSubLed().getId();
					}
				}
			}
		}
	
				
		/*dispensingHeaderList = session.createCriteria(BlDispensingHeader.class).add(Restrictions.between("BillInvoiceDate", java.sql.Date.valueOf(fromDate4MySQL), java.sql.Date.valueOf(toDate4MySQL)))
													.add(Restrictions.isNull("VoucherNo")).list();
		System.out.println("dispensingHeaderList==="+dispensingHeaderList.size());
		receiptHeaderList = session.createCriteria(BlReceiptHeader.class).add(Restrictions.between("ReceiptDate", java.sql.Date.valueOf(fromDate4MySQL), java.sql.Date.valueOf(toDate4MySQL)))
													.add(Restrictions.isNull("VoucherNo")).list();
		System.out.println("receiptHeaderList==="+receiptHeaderList.size());*/
		int count =1;
			if(box.getInt("count") != 0){
				count = (Integer)box.getInt("count");
			}
			System.out.println("count=="+count);
		
 for (int j = 1; j < count; j++) {
	if(box.getString("voucherCnt"+j).equals("y")){
		FaVoucherHeader faVoucherHeader = new FaVoucherHeader();
		MasHospital masHospital = new MasHospital();
		masHospital.setId(box.getInt("locationId"));
		faVoucherHeader.setHospital(masHospital);
		faVoucherHeader.setVoucherDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
		faVoucherHeader.setVoucherTime(box.getString(CHANGED_TIME));
		faVoucherHeader.setNarration(box.getString(NARRATION));
		Users users = new Users();
		users.setId( box.getInt("changedBy"));
		faVoucherHeader.setLastChgBy(users);
		faVoucherHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
		faVoucherHeader.setLastChgTime(box.getString(CHANGED_TIME));
		faVoucherHeader.setVoucherType("SV");
		faVoucherHeader.setStatus("y");
		BigDecimal totalAmountDr = new BigDecimal(0.0);
		BigDecimal totalAmountCr = new BigDecimal(0.0);
		
		if (!box.getString("drAmount"+j).equals("")) {
			totalAmountDr = new BigDecimal(box.getString("drAmount"+j));
			faVoucherHeader.setDrAmount(totalAmountDr);
		}
		if (!box.getString("crAmount"+j).equals("")) {
			totalAmountCr = new BigDecimal(box.getString("crAmount"+j));
			faVoucherHeader.setCrAmount(totalAmountCr);
		}
		MasStoreFinancial masStoreFinancial = new MasStoreFinancial();
		masStoreFinancial.setId(box.getInt("fYear"));
		faVoucherHeader.setFYear(masStoreFinancial);
		paramMap.put("suffix", box.getString("fYearDesc"));
		paramMap.put("flag", "save");
		paramMap.put("prefix", "SV");
		paramMap.put("voucherType", "Sales");
		paramMap.put("locationId", box.getInt("locationId"));
		 voucherNo = generateVoucherNo(paramMap);
		 String locationCode="";
			String yearDesc="";
			List<MasStoreFinancial>financialList=new ArrayList<MasStoreFinancial>();
			List<MasHospital>hospitalList=new ArrayList<MasHospital>();
			hospitalList=session.createCriteria(MasHospital.class).add(Restrictions.idEq(box.getInt("locationId"))).list();
			for(MasHospital mg:hospitalList){
				locationCode=mg.getHospitalCode();
			}
			financialList=session.createCriteria(MasStoreFinancial.class).add(Restrictions.idEq(box.getInt("fYear"))).list();
			for(MasStoreFinancial msf1:financialList){
				yearDesc=msf1.getYearDescription();
			}
			faVoucherHeader.setVoucherNo(locationCode+"/"+yearDesc+"/"+voucherNo);

		hbt.save(faVoucherHeader);
		map.put("voucherType", faVoucherHeader.getVoucherType());
//======================================
				if(box.getInt("dispensingHeaderId"+j) != 0){
				BlDispensingHeader dispHeader = (BlDispensingHeader)hbt.load(BlDispensingHeader.class, box.getInt("dispensingHeaderId"+j));
				dispHeader.setVoucherNo(""+voucherNo);
				hbt.update(dispHeader);
			}
			if(box.getInt("receiptHeaderId"+j) != 0){
				BlReceiptHeader receiptHeader2= (BlReceiptHeader)hbt.load(BlReceiptHeader.class, box.getInt("receiptHeaderId"+j));
				receiptHeader2.setVoucherNo(""+voucherNo);
				hbt.update(receiptHeader2);
			}
		
		BigDecimal crAmt = new BigDecimal(0.00);
		BigDecimal drAmt = new BigDecimal(0.00);
		
		int accountId = 0;
		if(box.getString("cashAccountType"+j).equals("Cash")  ){
			if(!box.getString("cash"+j).equals(0.00)){
				FaVoucherDetails voucherDetails = new FaVoucherDetails();
				FaMasAccount masAccount = new FaMasAccount();
				masAccount.setId(cashAccountId);
				voucherDetails.setAccount(masAccount);
				voucherDetails.setVoucherHeader(faVoucherHeader);
				if(cashSubLedId != 0){
					FaMasSubLed subLed= new FaMasSubLed();
					subLed.setId(cashSubLedId);
					voucherDetails.setSubLed(subLed);
				}
				System.out.println("drAmt==="+new BigDecimal(box.getString("cash"+j)));
				drAmt = new BigDecimal(box.getString("cash"+j));
				voucherDetails.setDrAmount(drAmt);
				voucherDetails.setCrAmount(new BigDecimal(0));
				hbt.save(voucherDetails);

				//-------------------------update account group-------------------------------------------------

				BigDecimal groupOpBalanceDr = new BigDecimal(0.0);
				BigDecimal groupOpBalanceCr = new BigDecimal(0.0);
				BigDecimal groupYtdBalanceDr = new BigDecimal(0.0);
				BigDecimal groupYtdBalanceCr = new BigDecimal(0.0);
				BigDecimal drGroupAmount = new BigDecimal(0.0);
				BigDecimal crGroupAmount = new BigDecimal(0.0);
				System.out.println("cashGroupId=="+cashGroupId);
				FaMasAccountGroup faMasAccountGroup = (FaMasAccountGroup)hbt.load(FaMasAccountGroup.class, cashGroupId);
				//System.out.println("opBalancecr===="+faMasAccountGroup.getOpBalanceCr());
				if(!faMasAccountGroup.getOpBalanceCr().equals(new BigDecimal(0.00)) && faMasAccountGroup.getOpBalanceCr()!= null){
					groupOpBalanceCr =  faMasAccountGroup.getOpBalanceCr();
				}
				System.out.println("groupOpBalanceCr=="+groupOpBalanceCr);
				if(!faMasAccountGroup.getOpBalanceDr().equals(new BigDecimal(0.00))&& faMasAccountGroup.getOpBalanceDr()!= null){
					groupOpBalanceDr =  faMasAccountGroup.getOpBalanceDr();
				}
				System.out.println("groupOpBalanceDr=="+groupOpBalanceDr);
				if(faMasAccountGroup.getYtdAmountDr().equals(new BigDecimal(0.00)) && faMasAccountGroup.getYtdAmountDr()!= null){
					groupYtdBalanceDr =  faMasAccountGroup.getYtdAmountDr();
				}
				System.out.println("groupYtdBalanceDr=="+groupYtdBalanceDr);
				if(faMasAccountGroup.getYtdAmountCr().equals(new BigDecimal(0.00)) &&faMasAccountGroup.getYtdAmountCr()!= null){
					groupYtdBalanceCr =  faMasAccountGroup.getYtdAmountCr();
				}
				System.out.println("groupYtdBalanceCr=="+groupYtdBalanceCr);
				if(drAmt.compareTo(new BigDecimal(0))>0){
					 groupYtdBalanceDr = groupYtdBalanceDr.add(drAmt);
					 faMasAccountGroup.setYtdAmountDr(groupYtdBalanceDr);
				 }
				System.out.println("groupYtdBalanceDr=="+groupYtdBalanceDr);
				if(crAmt.compareTo(new BigDecimal(0))>0){
					 groupYtdBalanceCr = groupYtdBalanceCr.add(crAmt);
					 faMasAccountGroup.setYtdAmountCr(groupYtdBalanceCr);
				 }
				System.out.println("groupYtdBalanceCr=="+groupYtdBalanceCr);
				drGroupAmount = groupOpBalanceDr.add(groupYtdBalanceDr);
				crGroupAmount = groupOpBalanceCr.add(groupYtdBalanceCr);
				System.out.println("drGroupAmount=="+drGroupAmount);
				System.out.println("crGroupAmount=="+crGroupAmount);
				
				if(drGroupAmount.compareTo(crGroupAmount)>0){
					System.out.println("11in if"+drGroupAmount.subtract(crGroupAmount));
					faMasAccountGroup.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
				    faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
				}else if(crGroupAmount.compareTo(drGroupAmount)>0){
					System.out.println("22in else  if");
					faMasAccountGroup.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
				    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
				}else if(crGroupAmount.compareTo(drGroupAmount)==0){
					System.out.println("33in else  if");
					faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
				    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
				}

			 	hbt.update(faMasAccountGroup);

	//-------------------------update account Sub group-------------------------------------------------

			 	BigDecimal subGroupOPBalanceDr = new BigDecimal(0);
				BigDecimal subGroupOPBalanceCr = new BigDecimal(0);
				BigDecimal subGroupYtdBalanceDr = new BigDecimal(0);
				BigDecimal subGroupYtdBalanceCr = new BigDecimal(0);
				BigDecimal drSubGroupAmount = new BigDecimal(0.0);
				BigDecimal crSubGroupAmount = new BigDecimal(0.0);

				FaMasAccountSubGroup accountSubGroup = (FaMasAccountSubGroup)hbt.load(FaMasAccountSubGroup.class, cashSubGroupId);
				 if(accountSubGroup.getOpBalanceDr()!= null){
					 subGroupOPBalanceDr =  accountSubGroup.getOpBalanceDr();
				 }
				 if(accountSubGroup.getOpBalanceCr()!= null){
					 subGroupOPBalanceCr = accountSubGroup.getOpBalanceCr();
				 }
				 if(accountSubGroup.getYtdAmountDr()!= null){
					 subGroupYtdBalanceDr = accountSubGroup.getYtdAmountDr();
				 }
				 if(accountSubGroup.getYtdAmountCr()!= null){
					 subGroupYtdBalanceCr = accountSubGroup.getYtdAmountCr();
				 }
				 if(drAmt.compareTo(new BigDecimal(0))>0){
					 subGroupYtdBalanceDr = subGroupYtdBalanceDr.add(drAmt);
					 accountSubGroup.setYtdAmountDr(subGroupYtdBalanceDr);
				 }
				 if(crAmt.compareTo(new BigDecimal(0))>0){
					 subGroupYtdBalanceCr = subGroupYtdBalanceCr.add(crAmt);
					 accountSubGroup.setYtdAmountCr(subGroupYtdBalanceCr);
				 }
				 drSubGroupAmount = subGroupOPBalanceDr.add(subGroupYtdBalanceDr);
				 crSubGroupAmount = subGroupOPBalanceCr.add(subGroupYtdBalanceCr);
					if(drGroupAmount.compareTo(crGroupAmount)>0){
						accountSubGroup.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
						accountSubGroup.setClBalanceCr(new BigDecimal(0.00));
					}else if(crGroupAmount.compareTo(drGroupAmount)>0){
						accountSubGroup.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
						accountSubGroup.setClBalanceDr(new BigDecimal(0.00));
					}else if(crGroupAmount.compareTo(drGroupAmount)==0){
						accountSubGroup.setClBalanceCr(new BigDecimal(0.00));
						accountSubGroup.setClBalanceDr(new BigDecimal(0.00));
					}

			 	hbt.update(accountSubGroup);

	//-------------------------update account master-------------------------------------------------

				BigDecimal accountOpBalanceDr = new  BigDecimal(0.0);
		 		BigDecimal accountOpBalanceCr = new  BigDecimal(0.0);
		 		BigDecimal accountYtdBalanceDr = new BigDecimal(0.0);
		 		BigDecimal accountYtdBalanceCr = new  BigDecimal(0.0);
		 		BigDecimal drAccountAmount = new BigDecimal(0.0);
		 		BigDecimal crAccountAmount = new  BigDecimal(0.0);
		 		 masAccount = (FaMasAccount)hbt.load(FaMasAccount.class,cashAccountId);
		 		if(masAccount.getOpBalanceDr()!= null){
		 			accountOpBalanceDr =  masAccount.getOpBalanceDr();
		 		}
		 		if(masAccount.getOpBalanceCr()!= null){
		 			accountOpBalanceCr = masAccount.getOpBalanceCr();
		 		}

		 		 if(masAccount.getYtdAmountDr() != null){
		 			 accountYtdBalanceDr = masAccount.getYtdAmountDr();
		 		 }
		 		 if(masAccount.getYtdAmountCr() != null){
		 			accountYtdBalanceCr = masAccount.getYtdAmountCr();
		 		 }
		 		if(drAmt.compareTo(new BigDecimal(0))>0){
					 accountYtdBalanceDr = accountYtdBalanceDr.add(drAmt);
					 masAccount.setYtdAmountDr(accountYtdBalanceDr);
				 }
				 if(crAmt.compareTo(new BigDecimal(0))>0){
					 accountYtdBalanceCr = accountYtdBalanceCr.add(crAmt);
					 masAccount.setYtdAmountCr(accountYtdBalanceCr);
				 }
				 drAccountAmount = accountOpBalanceDr.add(accountYtdBalanceDr);
				 crAccountAmount = accountOpBalanceCr.add(accountYtdBalanceCr);
					if(drAccountAmount.compareTo(crAccountAmount)>0){
						masAccount.setClBalanceDr(drAccountAmount.subtract(crAccountAmount));
						masAccount.setClBalanceCr(new BigDecimal(0.00));
					}else if(crAccountAmount.compareTo(drAccountAmount)>0){
						masAccount.setClBalanceCr(crAccountAmount.subtract(drAccountAmount));
						masAccount.setClBalanceDr(new BigDecimal(0.00));
					}else if(crAccountAmount.compareTo(drAccountAmount)==0){
						masAccount.setClBalanceCr(new BigDecimal(0.00));
						masAccount.setClBalanceDr(new BigDecimal(0.00));
					}


				 hbt.update(masAccount);
//------------------------------------------
				

				//-----------------------update account sub ledger==================================

				 if(cashSubLedId !=0){
					 BigDecimal subLedgerOPBalanceCr = new BigDecimal(0.0);
					 BigDecimal subLedgerOPBalanceDr = new BigDecimal(0.0);
					 BigDecimal subLedgerYTDBalanceDr = new BigDecimal(0.0);
					 BigDecimal subLedgerYTDBalanceCr = new BigDecimal(0.0);
					 BigDecimal drAmountSubLedger = new BigDecimal(0.0);
					 BigDecimal crAmountSubLedger = new BigDecimal(0.0);

					 FaMasSubLed subLed= (FaMasSubLed)hbt.load(FaMasSubLed.class, cashSubLedId);
					 if(subLed.getOpBalanceCr()!= null){
						 subLedgerOPBalanceCr =  subLed.getOpBalanceCr();
					 }
					 if(subLed.getOpBalanceDr()!= null){
						 subLedgerOPBalanceDr = subLed.getOpBalanceDr();
					 }

					if(subLed.getYtdAmountCr()!= null){
						subLedgerYTDBalanceCr = subLed.getYtdAmountCr();
					}
					if(subLed.getYtdAmountDr()!= null){
						subLedgerYTDBalanceDr = subLed.getYtdAmountDr();
					}
					if(drAmt.compareTo(new BigDecimal(0))>0){
						subLedgerYTDBalanceDr = subLedgerYTDBalanceDr.add(drAmt);
						subLed.setYtdAmountDr(subLedgerYTDBalanceDr);
					 }
					 if(crAmt.compareTo(new BigDecimal(0))>0){
						 subLedgerYTDBalanceCr = subLedgerYTDBalanceCr.add(crAmt);
						 subLed.setYtdAmountCr(subLedgerYTDBalanceCr);
					 }
					 crAmountSubLedger = subLedgerOPBalanceCr.add(subLedgerYTDBalanceCr);
					drAmountSubLedger = subLedgerOPBalanceDr.add(subLedgerYTDBalanceDr);

					if(drAmountSubLedger.compareTo(crAmountSubLedger)>0){
						subLed.setClBalanceDr(drAmountSubLedger.subtract(crAmountSubLedger));
						subLed.setClBalanceCr(new BigDecimal(0.00));
					}else if(crAmountSubLedger.compareTo(drAmountSubLedger)>0){
						subLed.setClBalanceCr(crAmountSubLedger.subtract(drAmountSubLedger));
						subLed.setClBalanceDr(new BigDecimal(0.00));
					}else if(crAmountSubLedger.compareTo(drAmountSubLedger)==0){
						subLed.setClBalanceCr(new BigDecimal(0.00));
						subLed.setClBalanceDr(new BigDecimal(0.00));
					}
						 hbt.update(subLed);


				 }
			}
		}
		if(box.getString("bankAccountType"+j).equals("Bank")  ){
			if(!box.getString("bank"+j).equals(0.00)){
				FaVoucherDetails voucherDetails = new FaVoucherDetails();
				FaMasAccount masAccount = new FaMasAccount();
				masAccount.setId(bankAccountId);
				voucherDetails.setAccount(masAccount);
				voucherDetails.setVoucherHeader(faVoucherHeader);
				if(cashSubLedId != 0){
					FaMasSubLed subLed= new FaMasSubLed();
					subLed.setId(bankSubLedId);
					voucherDetails.setSubLed(subLed);
				}
				drAmt = new BigDecimal(box.getString("bank"+j));
				voucherDetails.setDrAmount(drAmt);
				voucherDetails.setCrAmount(new BigDecimal(0));
				//-------------------------update account group-------------------------------------------------

				BigDecimal groupOpBalanceDr = new BigDecimal(0.0);
				BigDecimal groupOpBalanceCr = new BigDecimal(0.0);
				BigDecimal groupYtdBalanceDr = new BigDecimal(0.0);
				BigDecimal groupYtdBalanceCr = new BigDecimal(0.0);
				BigDecimal drGroupAmount = new BigDecimal(0.0);
				BigDecimal crGroupAmount = new BigDecimal(0.0);

				FaMasAccountGroup faMasAccountGroup = (FaMasAccountGroup)hbt.load(FaMasAccountGroup.class, bankGroupId);
				//System.out.println("opBalancecr===="+faMasAccountGroup.getOpBalanceCr());
				if(!faMasAccountGroup.getOpBalanceCr().equals(new BigDecimal(0.0)) && faMasAccountGroup.getOpBalanceCr()!= null){
					groupOpBalanceCr =  faMasAccountGroup.getOpBalanceCr();
				}
				if(!faMasAccountGroup.getOpBalanceDr().equals(new BigDecimal(0.0))&& faMasAccountGroup.getOpBalanceDr()!= null){
					groupOpBalanceDr =  faMasAccountGroup.getOpBalanceDr();
				}
				if(faMasAccountGroup.getYtdAmountDr().equals(new BigDecimal(0.0)) && faMasAccountGroup.getYtdAmountDr()!= null){
					groupYtdBalanceDr =  faMasAccountGroup.getYtdAmountDr();
				}
				if(faMasAccountGroup.getYtdAmountCr().equals(new BigDecimal(0.0)) &&faMasAccountGroup.getYtdAmountCr()!= null){
					groupYtdBalanceCr =  faMasAccountGroup.getYtdAmountCr();
				}
				if(drAmt.compareTo(new BigDecimal(0))>0){
					 groupYtdBalanceDr = groupYtdBalanceDr.add(drAmt);
					 faMasAccountGroup.setYtdAmountDr(groupYtdBalanceDr);
				 }
				if(crAmt.compareTo(new BigDecimal(0))>0){
					 groupYtdBalanceCr = groupYtdBalanceCr.add(crAmt);
					 faMasAccountGroup.setYtdAmountCr(groupYtdBalanceCr);
				 }
				drGroupAmount = groupOpBalanceDr.add(groupYtdBalanceDr);
				crGroupAmount = groupOpBalanceCr.add(groupYtdBalanceCr);
				if(drGroupAmount.compareTo(crGroupAmount)>0){
					faMasAccountGroup.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
				    faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
				}else if(crGroupAmount.compareTo(drGroupAmount)>0){
					faMasAccountGroup.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
				    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
				}else if(crGroupAmount.compareTo(drGroupAmount)==0){
					faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
				    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
				}

			 	hbt.update(faMasAccountGroup);

	//-------------------------update account Sub group-------------------------------------------------

			 	BigDecimal subGroupOPBalanceDr = new BigDecimal(0);
				BigDecimal subGroupOPBalanceCr = new BigDecimal(0);
				BigDecimal subGroupYtdBalanceDr = new BigDecimal(0);
				BigDecimal subGroupYtdBalanceCr = new BigDecimal(0);
				BigDecimal drSubGroupAmount = new BigDecimal(0.0);
				BigDecimal crSubGroupAmount = new BigDecimal(0.0);

				FaMasAccountSubGroup accountSubGroup = (FaMasAccountSubGroup)hbt.load(FaMasAccountSubGroup.class, bankSubGroupId);
				 if(accountSubGroup.getOpBalanceDr()!= null){
					 subGroupOPBalanceDr =  accountSubGroup.getOpBalanceDr();
				 }
				 if(accountSubGroup.getOpBalanceCr()!= null){
					 subGroupOPBalanceCr = accountSubGroup.getOpBalanceCr();
				 }
				 if(accountSubGroup.getYtdAmountDr()!= null){
					 subGroupYtdBalanceDr = accountSubGroup.getYtdAmountDr();
				 }
				 if(accountSubGroup.getYtdAmountCr()!= null){
					 subGroupYtdBalanceCr = accountSubGroup.getYtdAmountCr();
				 }
				 if(drAmt.compareTo(new BigDecimal(0))>0){
					 subGroupYtdBalanceDr = subGroupYtdBalanceDr.add(drAmt);
					 accountSubGroup.setYtdAmountDr(subGroupYtdBalanceDr);
				 }
				 if(crAmt.compareTo(new BigDecimal(0))>0){
					 subGroupYtdBalanceCr = subGroupYtdBalanceCr.add(crAmt);
					 accountSubGroup.setYtdAmountCr(subGroupYtdBalanceCr);
				 }
				 drSubGroupAmount = subGroupOPBalanceDr.add(subGroupYtdBalanceDr);
				 crSubGroupAmount = subGroupOPBalanceCr.add(subGroupYtdBalanceCr);
					if(drGroupAmount.compareTo(crGroupAmount)>0){
						accountSubGroup.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
						accountSubGroup.setClBalanceCr(new BigDecimal(0.00));
					}else if(crGroupAmount.compareTo(drGroupAmount)>0){
						accountSubGroup.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
						accountSubGroup.setClBalanceDr(new BigDecimal(0.00));
					}else if(crGroupAmount.compareTo(drGroupAmount)==0){
						accountSubGroup.setClBalanceCr(new BigDecimal(0.00));
						accountSubGroup.setClBalanceDr(new BigDecimal(0.00));
					}

			 	hbt.update(accountSubGroup);

	//-------------------------update account master-------------------------------------------------

				BigDecimal accountOpBalanceDr = new  BigDecimal(0.0);
		 		BigDecimal accountOpBalanceCr = new  BigDecimal(0.0);
		 		BigDecimal accountYtdBalanceDr = new BigDecimal(0.0);
		 		BigDecimal accountYtdBalanceCr = new  BigDecimal(0.0);
		 		BigDecimal drAccountAmount = new BigDecimal(0.0);
		 		BigDecimal crAccountAmount = new  BigDecimal(0.0);
		 		masAccount = (FaMasAccount)hbt.load(FaMasAccount.class,bankAccountId);
		 		if(masAccount.getOpBalanceDr()!= null){
		 			accountOpBalanceDr =  masAccount.getOpBalanceDr();
		 		}
		 		if(masAccount.getOpBalanceCr()!= null){
		 			accountOpBalanceCr = masAccount.getOpBalanceCr();
		 		}

		 		 if(masAccount.getYtdAmountDr() != null){
		 			 accountYtdBalanceDr = masAccount.getYtdAmountDr();
		 		 }
		 		 if(masAccount.getYtdAmountCr() != null){
		 			accountYtdBalanceCr = masAccount.getYtdAmountCr();
		 		 }
		 		if(drAmt.compareTo(new BigDecimal(0))>0){
					 accountYtdBalanceDr = accountYtdBalanceDr.add(drAmt);
					 masAccount.setYtdAmountDr(accountYtdBalanceDr);
				 }
				 if(crAmt.compareTo(new BigDecimal(0))>0){
					 accountYtdBalanceCr = accountYtdBalanceCr.add(crAmt);
					 masAccount.setYtdAmountCr(accountYtdBalanceCr);
				 }
				 drAccountAmount = accountOpBalanceDr.add(accountYtdBalanceDr);
				 crAccountAmount = accountOpBalanceCr.add(accountYtdBalanceCr);
					if(drAccountAmount.compareTo(crAccountAmount)>0){
						masAccount.setClBalanceDr(drAccountAmount.subtract(crAccountAmount));
						masAccount.setClBalanceCr(new BigDecimal(0.00));
					}else if(crAccountAmount.compareTo(drAccountAmount)>0){
						masAccount.setClBalanceCr(crAccountAmount.subtract(drAccountAmount));
						masAccount.setClBalanceDr(new BigDecimal(0.00));
					}else if(crAccountAmount.compareTo(drAccountAmount)==0){
						masAccount.setClBalanceCr(new BigDecimal(0.00));
						masAccount.setClBalanceDr(new BigDecimal(0.00));
					}


				 hbt.update(masAccount);
//------------------------------------------
				

				//-----------------------update account sub ledger==================================

				 if(bankSubLedId !=0){
					 BigDecimal subLedgerOPBalanceCr = new BigDecimal(0.0);
					 BigDecimal subLedgerOPBalanceDr = new BigDecimal(0.0);
					 BigDecimal subLedgerYTDBalanceDr = new BigDecimal(0.0);
					 BigDecimal subLedgerYTDBalanceCr = new BigDecimal(0.0);
					 BigDecimal drAmountSubLedger = new BigDecimal(0.0);
					 BigDecimal crAmountSubLedger = new BigDecimal(0.0);

					 FaMasSubLed subLed= (FaMasSubLed)hbt.load(FaMasSubLed.class, bankSubLedId);
					 if(subLed.getOpBalanceCr()!= null){
						 subLedgerOPBalanceCr =  subLed.getOpBalanceCr();
					 }
					 if(subLed.getOpBalanceDr()!= null){
						 subLedgerOPBalanceDr = subLed.getOpBalanceDr();
					 }

					if(subLed.getYtdAmountCr()!= null){
						subLedgerYTDBalanceCr = subLed.getYtdAmountCr();
					}
					if(subLed.getYtdAmountDr()!= null){
						subLedgerYTDBalanceDr = subLed.getYtdAmountDr();
					}
					if(drAmt.compareTo(new BigDecimal(0))>0){
						subLedgerYTDBalanceDr = subLedgerYTDBalanceDr.add(drAmt);
						subLed.setYtdAmountDr(subLedgerYTDBalanceDr);
					 }
					 if(crAmt.compareTo(new BigDecimal(0))>0){
						 subLedgerYTDBalanceCr = subLedgerYTDBalanceCr.add(crAmt);
						 subLed.setYtdAmountCr(subLedgerYTDBalanceCr);
					 }
					 crAmountSubLedger = subLedgerOPBalanceCr.add(subLedgerYTDBalanceCr);
					drAmountSubLedger = subLedgerOPBalanceDr.add(subLedgerYTDBalanceDr);

					if(drAmountSubLedger.compareTo(crAmountSubLedger)>0){
						subLed.setClBalanceDr(drAmountSubLedger.subtract(crAmountSubLedger));
						subLed.setClBalanceCr(new BigDecimal(0.00));
					}else if(crAmountSubLedger.compareTo(drAmountSubLedger)>0){
						subLed.setClBalanceCr(crAmountSubLedger.subtract(drAmountSubLedger));
						subLed.setClBalanceDr(new BigDecimal(0.00));
					}else if(crAmountSubLedger.compareTo(drAmountSubLedger)==0){
						subLed.setClBalanceCr(new BigDecimal(0.00));
						subLed.setClBalanceDr(new BigDecimal(0.00));
					}
						 hbt.update(subLed);
				 }		
			}
		}
		if(box.getString("cCAccountType"+j).equals("Credit Card")){
			if(!box.getString("creditCard"+j).equals(0.00)){
				FaVoucherDetails voucherDetails = new FaVoucherDetails();
				FaMasAccount masAccount = new FaMasAccount();
				masAccount.setId(creditCardAccountId);
				voucherDetails.setAccount(masAccount);
				voucherDetails.setVoucherHeader(faVoucherHeader);
				if(creditCardSubLedId != 0){
					FaMasSubLed subLed= new FaMasSubLed();
					subLed.setId(creditCardSubLedId);
					voucherDetails.setSubLed(subLed);
				}
				drAmt = new BigDecimal(box.getString("creditCard"+j));
				voucherDetails.setDrAmount(drAmt);
				voucherDetails.setCrAmount(new BigDecimal(0));
				//-------------------------update account group-------------------------------------------------

				BigDecimal groupOpBalanceDr = new BigDecimal(0.0);
				BigDecimal groupOpBalanceCr = new BigDecimal(0.0);
				BigDecimal groupYtdBalanceDr = new BigDecimal(0.0);
				BigDecimal groupYtdBalanceCr = new BigDecimal(0.0);
				BigDecimal drGroupAmount = new BigDecimal(0.0);
				BigDecimal crGroupAmount = new BigDecimal(0.0);

				FaMasAccountGroup faMasAccountGroup = (FaMasAccountGroup)hbt.load(FaMasAccountGroup.class, creditCardGroupId);
				//System.out.println("opBalancecr===="+faMasAccountGroup.getOpBalanceCr());
				if(!faMasAccountGroup.getOpBalanceCr().equals(new BigDecimal(0.0)) && faMasAccountGroup.getOpBalanceCr()!= null){
					groupOpBalanceCr =  faMasAccountGroup.getOpBalanceCr();
				}
				if(!faMasAccountGroup.getOpBalanceDr().equals(new BigDecimal(0.0))&& faMasAccountGroup.getOpBalanceDr()!= null){
					groupOpBalanceDr =  faMasAccountGroup.getOpBalanceDr();
				}
				if(faMasAccountGroup.getYtdAmountDr().equals(new BigDecimal(0.0)) && faMasAccountGroup.getYtdAmountDr()!= null){
					groupYtdBalanceDr =  faMasAccountGroup.getYtdAmountDr();
				}
				if(faMasAccountGroup.getYtdAmountCr().equals(new BigDecimal(0.0)) &&faMasAccountGroup.getYtdAmountCr()!= null){
					groupYtdBalanceCr =  faMasAccountGroup.getYtdAmountCr();
				}
				if(drAmt.compareTo(new BigDecimal(0))>0){
					 groupYtdBalanceDr = groupYtdBalanceDr.add(drAmt);
					 faMasAccountGroup.setYtdAmountDr(groupYtdBalanceDr);
				 }
				if(crAmt.compareTo(new BigDecimal(0))>0){
					 groupYtdBalanceCr = groupYtdBalanceCr.add(crAmt);
					 faMasAccountGroup.setYtdAmountCr(groupYtdBalanceCr);
				 }
				drGroupAmount = groupOpBalanceDr.add(groupYtdBalanceDr);
				crGroupAmount = groupOpBalanceCr.add(groupYtdBalanceCr);
				if(drGroupAmount.compareTo(crGroupAmount)>0){
					faMasAccountGroup.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
				    faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
				}else if(crGroupAmount.compareTo(drGroupAmount)>0){
					faMasAccountGroup.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
				    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
				}else if(crGroupAmount.compareTo(drGroupAmount)==0){
					faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
				    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
				}

			 	hbt.update(faMasAccountGroup);

	//-------------------------update account Sub group-------------------------------------------------

			 	BigDecimal subGroupOPBalanceDr = new BigDecimal(0);
				BigDecimal subGroupOPBalanceCr = new BigDecimal(0);
				BigDecimal subGroupYtdBalanceDr = new BigDecimal(0);
				BigDecimal subGroupYtdBalanceCr = new BigDecimal(0);
				BigDecimal drSubGroupAmount = new BigDecimal(0.0);
				BigDecimal crSubGroupAmount = new BigDecimal(0.0);

				FaMasAccountSubGroup accountSubGroup = (FaMasAccountSubGroup)hbt.load(FaMasAccountSubGroup.class, creditCardSubGroupId);
				 if(accountSubGroup.getOpBalanceDr()!= null){
					 subGroupOPBalanceDr =  accountSubGroup.getOpBalanceDr();
				 }
				 if(accountSubGroup.getOpBalanceCr()!= null){
					 subGroupOPBalanceCr = accountSubGroup.getOpBalanceCr();
				 }
				 if(accountSubGroup.getYtdAmountDr()!= null){
					 subGroupYtdBalanceDr = accountSubGroup.getYtdAmountDr();
				 }
				 if(accountSubGroup.getYtdAmountCr()!= null){
					 subGroupYtdBalanceCr = accountSubGroup.getYtdAmountCr();
				 }
				 if(drAmt.compareTo(new BigDecimal(0))>0){
					 subGroupYtdBalanceDr = subGroupYtdBalanceDr.add(drAmt);
					 accountSubGroup.setYtdAmountDr(subGroupYtdBalanceDr);
				 }
				 if(crAmt.compareTo(new BigDecimal(0))>0){
					 subGroupYtdBalanceCr = subGroupYtdBalanceCr.add(crAmt);
					 accountSubGroup.setYtdAmountCr(subGroupYtdBalanceCr);
				 }
				 drSubGroupAmount = subGroupOPBalanceDr.add(subGroupYtdBalanceDr);
				 crSubGroupAmount = subGroupOPBalanceCr.add(subGroupYtdBalanceCr);
					if(drGroupAmount.compareTo(crGroupAmount)>0){
						accountSubGroup.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
						accountSubGroup.setClBalanceCr(new BigDecimal(0.00));
					}else if(crGroupAmount.compareTo(drGroupAmount)>0){
						accountSubGroup.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
						accountSubGroup.setClBalanceDr(new BigDecimal(0.00));
					}else if(crGroupAmount.compareTo(drGroupAmount)==0){
						accountSubGroup.setClBalanceCr(new BigDecimal(0.00));
						accountSubGroup.setClBalanceDr(new BigDecimal(0.00));
					}

			 	hbt.update(accountSubGroup);

	//-------------------------update account master-------------------------------------------------

				BigDecimal accountOpBalanceDr = new  BigDecimal(0.0);
		 		BigDecimal accountOpBalanceCr = new  BigDecimal(0.0);
		 		BigDecimal accountYtdBalanceDr = new BigDecimal(0.0);
		 		BigDecimal accountYtdBalanceCr = new  BigDecimal(0.0);
		 		BigDecimal drAccountAmount = new BigDecimal(0.0);
		 		BigDecimal crAccountAmount = new  BigDecimal(0.0);
		 		masAccount = (FaMasAccount)hbt.load(FaMasAccount.class,creditCardAccountId);
		 		if(masAccount.getOpBalanceDr()!= null){
		 			accountOpBalanceDr =  masAccount.getOpBalanceDr();
		 		}
		 		if(masAccount.getOpBalanceCr()!= null){
		 			accountOpBalanceCr = masAccount.getOpBalanceCr();
		 		}

		 		 if(masAccount.getYtdAmountDr() != null){
		 			 accountYtdBalanceDr = masAccount.getYtdAmountDr();
		 		 }
		 		 if(masAccount.getYtdAmountCr() != null){
		 			accountYtdBalanceCr = masAccount.getYtdAmountCr();
		 		 }
		 		if(drAmt.compareTo(new BigDecimal(0))>0){
					 accountYtdBalanceDr = accountYtdBalanceDr.add(drAmt);
					 masAccount.setYtdAmountDr(accountYtdBalanceDr);
				 }
				 if(crAmt.compareTo(new BigDecimal(0))>0){
					 accountYtdBalanceCr = accountYtdBalanceCr.add(crAmt);
					 masAccount.setYtdAmountCr(accountYtdBalanceCr);
				 }
				 drAccountAmount = accountOpBalanceDr.add(accountYtdBalanceDr);
				 crAccountAmount = accountOpBalanceCr.add(accountYtdBalanceCr);
					if(drAccountAmount.compareTo(crAccountAmount)>0){
						masAccount.setClBalanceDr(drAccountAmount.subtract(crAccountAmount));
						masAccount.setClBalanceCr(new BigDecimal(0.00));
					}else if(crAccountAmount.compareTo(drAccountAmount)>0){
						masAccount.setClBalanceCr(crAccountAmount.subtract(drAccountAmount));
						masAccount.setClBalanceDr(new BigDecimal(0.00));
					}else if(crAccountAmount.compareTo(drAccountAmount)==0){
						masAccount.setClBalanceCr(new BigDecimal(0.00));
						masAccount.setClBalanceDr(new BigDecimal(0.00));
					}


				 hbt.update(masAccount);
//------------------------------------------
				

				//-----------------------update account sub ledger==================================

				 if(creditCardSubLedId !=0){
					 BigDecimal subLedgerOPBalanceCr = new BigDecimal(0.0);
					 BigDecimal subLedgerOPBalanceDr = new BigDecimal(0.0);
					 BigDecimal subLedgerYTDBalanceDr = new BigDecimal(0.0);
					 BigDecimal subLedgerYTDBalanceCr = new BigDecimal(0.0);
					 BigDecimal drAmountSubLedger = new BigDecimal(0.0);
					 BigDecimal crAmountSubLedger = new BigDecimal(0.0);

					 FaMasSubLed subLed= (FaMasSubLed)hbt.load(FaMasSubLed.class, creditCardSubLedId);
					 if(subLed.getOpBalanceCr()!= null){
						 subLedgerOPBalanceCr =  subLed.getOpBalanceCr();
					 }
					 if(subLed.getOpBalanceDr()!= null){
						 subLedgerOPBalanceDr = subLed.getOpBalanceDr();
					 }

					if(subLed.getYtdAmountCr()!= null){
						subLedgerYTDBalanceCr = subLed.getYtdAmountCr();
					}
					if(subLed.getYtdAmountDr()!= null){
						subLedgerYTDBalanceDr = subLed.getYtdAmountDr();
					}
					if(drAmt.compareTo(new BigDecimal(0))>0){
						subLedgerYTDBalanceDr = subLedgerYTDBalanceDr.add(drAmt);
						subLed.setYtdAmountDr(subLedgerYTDBalanceDr);
					 }
					 if(crAmt.compareTo(new BigDecimal(0))>0){
						 subLedgerYTDBalanceCr = subLedgerYTDBalanceCr.add(crAmt);
						 subLed.setYtdAmountCr(subLedgerYTDBalanceCr);
					 }
					 crAmountSubLedger = subLedgerOPBalanceCr.add(subLedgerYTDBalanceCr);
					drAmountSubLedger = subLedgerOPBalanceDr.add(subLedgerYTDBalanceDr);

					if(drAmountSubLedger.compareTo(crAmountSubLedger)>0){
						subLed.setClBalanceDr(drAmountSubLedger.subtract(crAmountSubLedger));
						subLed.setClBalanceCr(new BigDecimal(0.00));
					}else if(crAmountSubLedger.compareTo(drAmountSubLedger)>0){
						subLed.setClBalanceCr(crAmountSubLedger.subtract(drAmountSubLedger));
						subLed.setClBalanceDr(new BigDecimal(0.00));
					}else if(crAmountSubLedger.compareTo(drAmountSubLedger)==0){
						subLed.setClBalanceCr(new BigDecimal(0.00));
						subLed.setClBalanceDr(new BigDecimal(0.00));
					}
						 hbt.update(subLed);
				 }	
			}
		}
		
		
		if(box.getString("oSAccountType"+j).equals("Outstanding")){
			if(!box.getString("outstanding"+j).equals(0.00)){
				FaVoucherDetails voucherDetails = new FaVoucherDetails();
				FaMasAccount masAccount = new FaMasAccount();
				masAccount.setId(osAccountId);
				voucherDetails.setAccount(masAccount);
				voucherDetails.setVoucherHeader(faVoucherHeader);
				if(osSubLedId != 0){
					FaMasSubLed subLed= new FaMasSubLed();
					subLed.setId(osSubLedId);
					voucherDetails.setSubLed(subLed);
				}
					crAmt = new BigDecimal(box.getString("outstanding"+j));
					voucherDetails.setCrAmount(crAmt);
					voucherDetails.setDrAmount(new BigDecimal(0));
					hbt.save(voucherDetails);
					//-------------------------update account group-------------------------------------------------

					BigDecimal groupOpBalanceDr = new BigDecimal(0.0);
					BigDecimal groupOpBalanceCr = new BigDecimal(0.0);
					BigDecimal groupYtdBalanceDr = new BigDecimal(0.0);
					BigDecimal groupYtdBalanceCr = new BigDecimal(0.0);
					BigDecimal drGroupAmount = new BigDecimal(0.0);
					BigDecimal crGroupAmount = new BigDecimal(0.0);

					FaMasAccountGroup faMasAccountGroup = (FaMasAccountGroup)hbt.load(FaMasAccountGroup.class, osGroupId);
					//System.out.println("opBalancecr===="+faMasAccountGroup.getOpBalanceCr());
					if(!faMasAccountGroup.getOpBalanceCr().equals(new BigDecimal(0.0)) && faMasAccountGroup.getOpBalanceCr()!= null){
						groupOpBalanceCr =  faMasAccountGroup.getOpBalanceCr();
					}
					if(!faMasAccountGroup.getOpBalanceDr().equals(new BigDecimal(0.0))&& faMasAccountGroup.getOpBalanceDr()!= null){
						groupOpBalanceDr =  faMasAccountGroup.getOpBalanceDr();
					}
					if(faMasAccountGroup.getYtdAmountDr().equals(new BigDecimal(0.0)) && faMasAccountGroup.getYtdAmountDr()!= null){
						groupYtdBalanceDr =  faMasAccountGroup.getYtdAmountDr();
					}
					if(faMasAccountGroup.getYtdAmountCr().equals(new BigDecimal(0.0)) &&faMasAccountGroup.getYtdAmountCr()!= null){
						groupYtdBalanceCr =  faMasAccountGroup.getYtdAmountCr();
					}
					if(drAmt.compareTo(new BigDecimal(0))>0){
						 groupYtdBalanceDr = groupYtdBalanceDr.add(drAmt);
						 faMasAccountGroup.setYtdAmountDr(groupYtdBalanceDr);
					 }
					if(crAmt.compareTo(new BigDecimal(0))>0){
						 groupYtdBalanceCr = groupYtdBalanceCr.add(crAmt);
						 faMasAccountGroup.setYtdAmountCr(groupYtdBalanceCr);
					 }
					drGroupAmount = groupOpBalanceDr.add(groupYtdBalanceDr);
					crGroupAmount = groupOpBalanceCr.add(groupYtdBalanceCr);
					if(drGroupAmount.compareTo(crGroupAmount)>0){
						faMasAccountGroup.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
					    faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
					}else if(crGroupAmount.compareTo(drGroupAmount)>0){
						faMasAccountGroup.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
					    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
					}else if(crGroupAmount.compareTo(drGroupAmount)==0){
						faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
					    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
					}

				 	hbt.update(faMasAccountGroup);

		//-------------------------update account Sub group-------------------------------------------------

				 	BigDecimal subGroupOPBalanceDr = new BigDecimal(0);
					BigDecimal subGroupOPBalanceCr = new BigDecimal(0);
					BigDecimal subGroupYtdBalanceDr = new BigDecimal(0);
					BigDecimal subGroupYtdBalanceCr = new BigDecimal(0);
					BigDecimal drSubGroupAmount = new BigDecimal(0.0);
					BigDecimal crSubGroupAmount = new BigDecimal(0.0);

					FaMasAccountSubGroup accountSubGroup = (FaMasAccountSubGroup)hbt.load(FaMasAccountSubGroup.class, osSubGroupId);
					 if(accountSubGroup.getOpBalanceDr()!= null){
						 subGroupOPBalanceDr =  accountSubGroup.getOpBalanceDr();
					 }
					 if(accountSubGroup.getOpBalanceCr()!= null){
						 subGroupOPBalanceCr = accountSubGroup.getOpBalanceCr();
					 }
					 if(accountSubGroup.getYtdAmountDr()!= null){
						 subGroupYtdBalanceDr = accountSubGroup.getYtdAmountDr();
					 }
					 if(accountSubGroup.getYtdAmountCr()!= null){
						 subGroupYtdBalanceCr = accountSubGroup.getYtdAmountCr();
					 }
					 if(drAmt.compareTo(new BigDecimal(0))>0){
						 subGroupYtdBalanceDr = subGroupYtdBalanceDr.add(drAmt);
						 accountSubGroup.setYtdAmountDr(subGroupYtdBalanceDr);
					 }
					 if(crAmt.compareTo(new BigDecimal(0))>0){
						 subGroupYtdBalanceCr = subGroupYtdBalanceCr.add(crAmt);
						 accountSubGroup.setYtdAmountCr(subGroupYtdBalanceCr);
					 }
					 drSubGroupAmount = subGroupOPBalanceDr.add(subGroupYtdBalanceDr);
					 crSubGroupAmount = subGroupOPBalanceCr.add(subGroupYtdBalanceCr);
						if(drGroupAmount.compareTo(crGroupAmount)>0){
							accountSubGroup.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
							accountSubGroup.setClBalanceCr(new BigDecimal(0.00));
						}else if(crGroupAmount.compareTo(drGroupAmount)>0){
							accountSubGroup.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
							accountSubGroup.setClBalanceDr(new BigDecimal(0.00));
						}else if(crGroupAmount.compareTo(drGroupAmount)==0){
							accountSubGroup.setClBalanceCr(new BigDecimal(0.00));
							accountSubGroup.setClBalanceDr(new BigDecimal(0.00));
						}

				 	hbt.update(accountSubGroup);

		//-------------------------update account master-------------------------------------------------

					BigDecimal accountOpBalanceDr = new  BigDecimal(0.0);
			 		BigDecimal accountOpBalanceCr = new  BigDecimal(0.0);
			 		BigDecimal accountYtdBalanceDr = new BigDecimal(0.0);
			 		BigDecimal accountYtdBalanceCr = new  BigDecimal(0.0);
			 		BigDecimal drAccountAmount = new BigDecimal(0.0);
			 		BigDecimal crAccountAmount = new  BigDecimal(0.0);
			 		masAccount = (FaMasAccount)hbt.load(FaMasAccount.class,osAccountId);
			 		if(masAccount.getOpBalanceDr()!= null){
			 			accountOpBalanceDr =  masAccount.getOpBalanceDr();
			 		}
			 		if(masAccount.getOpBalanceCr()!= null){
			 			accountOpBalanceCr = masAccount.getOpBalanceCr();
			 		}

			 		 if(masAccount.getYtdAmountDr() != null){
			 			 accountYtdBalanceDr = masAccount.getYtdAmountDr();
			 		 }
			 		 if(masAccount.getYtdAmountCr() != null){
			 			accountYtdBalanceCr = masAccount.getYtdAmountCr();
			 		 }
			 		if(drAmt.compareTo(new BigDecimal(0))>0){
						 accountYtdBalanceDr = accountYtdBalanceDr.add(drAmt);
						 masAccount.setYtdAmountDr(accountYtdBalanceDr);
					 }
					 if(crAmt.compareTo(new BigDecimal(0))>0){
						 accountYtdBalanceCr = accountYtdBalanceCr.add(crAmt);
						 masAccount.setYtdAmountCr(accountYtdBalanceCr);
					 }
					 drAccountAmount = accountOpBalanceDr.add(accountYtdBalanceDr);
					 crAccountAmount = accountOpBalanceCr.add(accountYtdBalanceCr);
						if(drAccountAmount.compareTo(crAccountAmount)>0){
							masAccount.setClBalanceDr(drAccountAmount.subtract(crAccountAmount));
							masAccount.setClBalanceCr(new BigDecimal(0.00));
						}else if(crAccountAmount.compareTo(drAccountAmount)>0){
							masAccount.setClBalanceCr(crAccountAmount.subtract(drAccountAmount));
							masAccount.setClBalanceDr(new BigDecimal(0.00));
						}else if(crAccountAmount.compareTo(drAccountAmount)==0){
							masAccount.setClBalanceCr(new BigDecimal(0.00));
							masAccount.setClBalanceDr(new BigDecimal(0.00));
						}


					 hbt.update(masAccount);
	//------------------------------------------
					

					//-----------------------update account sub ledger==================================

					 if(osSubLedId !=0){
						 BigDecimal subLedgerOPBalanceCr = new BigDecimal(0.0);
						 BigDecimal subLedgerOPBalanceDr = new BigDecimal(0.0);
						 BigDecimal subLedgerYTDBalanceDr = new BigDecimal(0.0);
						 BigDecimal subLedgerYTDBalanceCr = new BigDecimal(0.0);
						 BigDecimal drAmountSubLedger = new BigDecimal(0.0);
						 BigDecimal crAmountSubLedger = new BigDecimal(0.0);

						 FaMasSubLed subLed= (FaMasSubLed)hbt.load(FaMasSubLed.class, osSubLedId);
						 if(subLed.getOpBalanceCr()!= null){
							 subLedgerOPBalanceCr =  subLed.getOpBalanceCr();
						 }
						 if(subLed.getOpBalanceDr()!= null){
							 subLedgerOPBalanceDr = subLed.getOpBalanceDr();
						 }

						if(subLed.getYtdAmountCr()!= null){
							subLedgerYTDBalanceCr = subLed.getYtdAmountCr();
						}
						if(subLed.getYtdAmountDr()!= null){
							subLedgerYTDBalanceDr = subLed.getYtdAmountDr();
						}
						if(drAmt.compareTo(new BigDecimal(0))>0){
							subLedgerYTDBalanceDr = subLedgerYTDBalanceDr.add(drAmt);
							subLed.setYtdAmountDr(subLedgerYTDBalanceDr);
						 }
						 if(crAmt.compareTo(new BigDecimal(0))>0){
							 subLedgerYTDBalanceCr = subLedgerYTDBalanceCr.add(crAmt);
							 subLed.setYtdAmountCr(subLedgerYTDBalanceCr);
						 }
						 crAmountSubLedger = subLedgerOPBalanceCr.add(subLedgerYTDBalanceCr);
						drAmountSubLedger = subLedgerOPBalanceDr.add(subLedgerYTDBalanceDr);

						if(drAmountSubLedger.compareTo(crAmountSubLedger)>0){
							subLed.setClBalanceDr(drAmountSubLedger.subtract(crAmountSubLedger));
							subLed.setClBalanceCr(new BigDecimal(0.00));
						}else if(crAmountSubLedger.compareTo(drAmountSubLedger)>0){
							subLed.setClBalanceCr(crAmountSubLedger.subtract(drAmountSubLedger));
							subLed.setClBalanceDr(new BigDecimal(0.00));
						}else if(crAmountSubLedger.compareTo(drAmountSubLedger)==0){
							subLed.setClBalanceCr(new BigDecimal(0.00));
							subLed.setClBalanceDr(new BigDecimal(0.00));
						}
							 hbt.update(subLed);
					 }	
				}
			}
	
	}
	}
		
//	}
		tx.commit();
		saved = true;

		} catch (RuntimeException e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			}

			paramMap.put("suffix", box.getString("fYearDesc"));
			paramMap.put("flag", "display");
			paramMap.put("prefix", "SV");
			paramMap.put("voucherType", "Sales");
			int voucherNo = generateVoucherNo(paramMap);
			map.put("voucherNo", voucherNo);
			map.put("saved", saved);
		return map;
	}
	@Override
	public Map<String, Object> displayCashSettlement(Box box) {
		Map<String,Object> map = new HashMap<String, Object>();
		List<Object[]> cashSettlementList = new ArrayList<Object[]>();
		Session session = (Session)getSession();
		SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
		String fromDate4MySQL = "";
		String toDate4MySQL = "";
		String fromDate = "";
		String toDate = "";
		try {
			fromDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(FROM_DATE)));
			 toDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(TO_DATE)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String cashSettlementQueryString = "SELECT bdh.bill_invoice_no, ifnull(cash_q.amt,0) as cash,ifnull(chq_q.amt,0) as cheque," +
				" ifnull(cc_q.amt,0) as credit ,(ifnull(cash_q.amt,0)+ifnull(chq_q.amt,0)+ifnull(cc_q.amt,0)) as outstanding, " +
				" bdh.dispensing_header_id,brh.receipt_header_id " +
				" FROM bl_dispensing_details bdd left join bl_dispensing_header bdh on bdh.dispensing_header_id = bdd.dispensing_header_id left join " +
				" bl_receipt_header brh on bdh.dispensing_header_id = brh.dispensing_header_id left join " +
				"(select (ifnull(rd.amount,0))as amt,dh.dispensing_header_id as disp_id from bl_receipt_details rd left outer join " +
				"  bl_receipt_header rh on rd.receipt_header_id=rh.receipt_header_id left outer join bl_dispensing_header dh" +
				"  on rh.dispensing_header_id=dh.dispensing_header_id where rd.payment_mode='C' and  dh.action_type='CashBill' " +
				" and rh.status = 'FS Cash')as cash_q on cash_q.disp_id=bdh.dispensing_header_id left join " +
				" (select (ifnull(rd.amount,0))as amt,dh.dispensing_header_id as disp_id from bl_receipt_details rd left outer join " +
				"  bl_receipt_header rh on rd.receipt_header_id=rh.receipt_header_id left outer join bl_dispensing_header dh on  " +
				" rh.dispensing_header_id=dh.dispensing_header_id where rd.payment_mode='Q' and  dh.action_type='CashBill'" +
				" and rh.status = 'FS Cash') as chq_q on chq_q.disp_id=bdh.dispensing_header_id left join (select (ifnull(rd.amount,0))as amt," +
				" dh.dispensing_header_id as disp_id from bl_receipt_details rd left outer join bl_receipt_header rh on " +
				" rd.receipt_header_id=rh.receipt_header_id left outer join bl_dispensing_header dh on rh.dispensing_header_id=dh.dispensing_header_id " +
				" where rd.payment_mode='R' and  dh.action_type='CashBill' and rh.status = 'FS Cash') as cc_q on cc_q.disp_id=bdh.dispensing_header_id " +
				" where bdh.action_type='CashBill' and brh.receipt_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' " +
				" and bdh.bill_status = 'settled' and bdh.voucher_no is null";
		cashSettlementList = session.createSQLQuery(cashSettlementQueryString).list();
		map.put("cashSettlementList", cashSettlementList);
		map.put("fromDate",HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE)));
		map.put("toDate",HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE)));
		return map;
	}

	
	@Override
	public Map<String, Object> displaySRNMapping(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> srnMappingList = new ArrayList<Object[]>();
		Session session = (Session)getSession();
		SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
		String fromDate4MySQL = "";
		String toDate4MySQL = "";
		try {
			fromDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(FROM_DATE)));
			 toDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(TO_DATE)));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		//-----------------------For Total SRN--------------------------------------
		try {
			String srnQueryString = "(Select (supp.supplier_name) as supplier ,sum(actual_cost)," +
								"sum(tax_percentage),sum(discount_percentage),sum(grnT.amount) from store_grn_t grnT " +
								" left join store_grn_m grnM on grnT.grn_master_id = grnM.grn_master_id " +
								" join mas_store_supplier supp on grnM.supplier_id = supp.supplier_id " +
								" left join store_po_header poHeader on grnM.po_id = poHeader.po_id " +
								" where grnM.date between  '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' " +
								" and grnT.status = 'received' and grnM.status = 'submitted'" +
								"  group by supplier_name) " +
								" union " +
								"(select hospital.hospital_name as hospital, sum(actual_cost)," +
								" sum(tax_percentage),sum(discount_percentage),sum(grnT.amount) from  store_grn_t grnT " +
								" left join store_grn_m grnM on grnT.grn_master_id = grnM.grn_master_id " +
								" left join store_stock_transfer_header transfer on grnM.transfer_id = transfer.transfer_header_id " +
								" join mas_hospital hospital on hospital.hospital_id = transfer.to_centre" +
								"  where grnM.date between  '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' " +
								" and grnT.status = 'received' and grnM.status = 'submitted' group by hospital) " +
								" union " +
								" (select masGrower.grower_name as growerName,sum(actual_cost)," +
								" sum(tax_percentage),sum(discount_percentage),sum(grnT.amount) from  store_grn_t grnT " +
								" left join store_grn_m grnM on grnT.grn_master_id = grnM.grn_master_id " +
								" left join prod_plan_grower_details grower on grnM.grower_details_id = grower.grower_details_id " +
								" inner join mas_grower masGrower on grower.grower_details_id = masGrower.grower_id " +
								" where grnM.date between  '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' " +
								" and grnT.status = 'received' and grnM.status = 'submitted' group by grower_name) " +
								" union " +
								" (Select hospital.hospital_name as hospital,sum(actual_cost),sum(tax_percentage)," +
								" sum(discount_percentage), sum(grnT.amount) from store_grn_t grnT " +
								" left join store_grn_m grnM on grnT.grn_master_id = grnM.grn_master_id " +
								" left join prod_plan_centre_details center on grnM.centre_details_id = center.plan_details_id " +
								" join mas_hospital hospital on hospital.hospital_id = center.center_id " +
								" where grnM.date between  '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' " +
								" and grnT.status = 'received' and grnM.status = 'submitted'  group by hospital)";
			srnMappingList = session.createSQLQuery(srnQueryString).list();
		} catch (HibernateException e) {
			
			e.printStackTrace();
		}
		map.put("srnMappingList", srnMappingList);
		map.put("fromDate",HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE)));
		map.put("toDate",HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE)));
		return map;
	}
	@Override
	public Map<String, Object> showPayrollMappingJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreFinancial> financialYearList = new ArrayList<MasStoreFinancial>();
		Session session = (Session)getSession();
		financialYearList = session.createCriteria(MasStoreFinancial.class).list();
		map.put("financialYearList", financialYearList);
		return map;
	}
	
	@Override
	public Map<String, Object> displayPayrollMapping(Box box) {
		Map<String,Object> map = new HashMap<String, Object>();
		List<Object[]> payrollMappingList = new ArrayList<Object[]>();
		List<MasStoreFinancial> financialYearList = new ArrayList<MasStoreFinancial>();
		Session session = (Session)getSession();
		/*SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
		String fromDate4MySQL = "";
		String toDate4MySQL = "";
		try {
			fromDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(FROM_DATE)));
			 toDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(TO_DATE)));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}*/
		String month = "";
		if(!box.getString("month").equals("")){
			month  = (String)box.getString("month");
		}
		String year = "";
		if(!box.getString("year").equals("")){
			year  = (String)box.getString("year");
		}
		financialYearList = session.createCriteria(MasStoreFinancial.class).list();
		//-----------------------For Total Payroll--------------------------------------
		try {
			String payrollQueryString = "select sum(header.net_salary)," +
					" (select sum(header.net_salary) from hr_payroll_process_header header " +
					" left join mas_employee emp on header.employee_id = emp.employee_id " +
					" inner join hr_employee_pay_structure payStructure on emp.employee_id = payStructure.employee_id " +
					" where month = '"+month+"' and payStructure.payment_mode = 'Cash' and year = '"+year+"') as cash," +
					" (select sum(header.net_salary) from hr_payroll_process_header header " +
					" left join mas_employee emp on header.employee_id = emp.employee_id " +
					" inner join hr_employee_pay_structure payStructure on emp.employee_id = payStructure.employee_id " +
					" where month = '"+month+"' and payStructure.payment_mode in ('Cheque','DD') and year ='"+year+"') as bank " +
					" from hr_payroll_process_header header " +
					"left join mas_employee emp on header.employee_id = emp.employee_id " +
					" left join hr_employee_pay_structure payStructure on emp.employee_id = payStructure.employee_id " +
					" where month = '"+month+"' and payStructure.payment_mode in ('Cheque','DD','Cash') and year = '"+year+"' ";
			payrollMappingList = session.createSQLQuery(payrollQueryString).list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("month", month);
		map.put("year", year);
		map.put("payrollMappingList", payrollMappingList);
		map.put("financialYearList", financialYearList);
		return map;
	}
	@Override
	public Map<String, Object> showEmployeePayrollPopupJsp(Box box) {
		Map<String,Object> map = new HashMap<String, Object>();
		List<MasStoreFinancial> financialYearList = new ArrayList<MasStoreFinancial>();
		List<HrPayrollProcessHeader> payrollHeaderList = new ArrayList<HrPayrollProcessHeader>();
		Session session = (Session)getSession();
		int month = 0;
		if(box.getInt("month")!= 0){
			month  = (Integer)box.getInt("month");
		}
		int year =0;
		if(box.getInt("year")!= 0){
			year  = (Integer)box.getInt("year");
		}
		System.out.println("month==11--"+month);
		System.out.println("year==22--"+year);
		financialYearList = session.createCriteria(MasStoreFinancial.class).list();
		payrollHeaderList = session.createCriteria(HrPayrollProcessHeader.class)
								.add(Restrictions.eq("Month", month)).add(Restrictions.eq("Year", year))
									.list();
		map.put("payrollHeaderList", payrollHeaderList);
		return map;
	}

//-------------------------- Report Method By Mansi on 31 July 2013

	@Override
	public Map<String, Object> getConnection() {
		Session session = (Session) getSession();
		Connection con = (Connection) session.connection();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("conn", con);
		return map;
	}
	@Override
	public Map<String, Object> getHospitalName(Map<String, Object> mapForDs) {
		Map<String, Object> mapResponse = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Integer storeId = 0;
		if (mapForDs.get("storeId") != null) {
			storeId = (Integer) mapForDs.get("storeId");
		}
		try {
			List<MasHospital> masHospitaList = new ArrayList<MasHospital>();
			masHospitaList = session.createCriteria(MasHospital.class)
					.add(Restrictions.eq("Id", storeId)).list();
			mapResponse.put("masHospitaList", masHospitaList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapResponse;
	}
	
	@Override
	public Map<String, Object> displayLegalApplicationMapping(Box box) {
		Map<String,Object> map = new HashMap<String, Object>();
		List<BigDecimal> legalApplicationMappingList = new ArrayList<BigDecimal>();
		Session session = (Session)getSession();
		SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
		String fromDate4MySQL = "";
		String toDate4MySQL = "";
		try {
			fromDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(FROM_DATE)));
			 toDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(TO_DATE)));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		String legalAppllicationQueryString = "SELECT sum(application_amount) FROM lgl_share_application " +
								" where date_of_application between   '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"'";
		
		legalApplicationMappingList = session.createSQLQuery(legalAppllicationQueryString).list();
		map.put("legalApplicationMappingList",legalApplicationMappingList);
		map.put("fromDate",HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE)));
		map.put("toDate",HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE)));
		return map;
	}
	@Override
	public Map<String, Object> postCashSettlementVoucherMapping(Box box) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<BlDispensingHeader> dispensingHeaderList = new ArrayList<BlDispensingHeader>();
		List<BlReceiptHeader> receiptHeaderList = new ArrayList<BlReceiptHeader>();
		List<FaAccountParameter> accountParameterList = new ArrayList<FaAccountParameter>();
		
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session)getSession();
		Transaction tx = null;
		boolean saved = false;


		try {
			tx = session.beginTransaction();
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			String fromDate4MySQL = "";
			String toDate4MySQL = "";
			int voucherNo = 0;
			try {
				fromDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(FROM_DATE)));
				 toDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(TO_DATE)));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int cashAccountId = 0;int cashSubLedId = 0; int cashSubGroupId = 0; int cashGroupId = 0; 
			int bankAccountId = 0; int bankSubLedId = 0; int bankSubGroupId = 0; int bankGroupId = 0;
			int creditCardAccountId = 0;int creditCardSubLedId = 0; int creditCardSubGroupId = 0; int creditCardGroupId = 0;
			int osAccountId = 0;int osSubLedId = 0;int osSubGroupId = 0; int osGroupId = 0;
			
			accountParameterList = session.createCriteria(FaAccountParameter.class).add(Restrictions.eq("Status", "y")).list();
			if(accountParameterList.size()>0){
				for(FaAccountParameter accountParameter :accountParameterList){
					if(accountParameter.getAccountType().equals("Cash")){
						if(accountParameter.getAccount() != null){
							cashAccountId = accountParameter.getAccount().getId();
							cashSubGroupId = accountParameter.getAccount().getAccountSubGroup().getId();
							cashGroupId = accountParameter.getAccount().getAccountSubGroup().getAccountGroup().getId();
						}
						if(accountParameter.getSubLed()!= null){
							cashSubLedId = accountParameter.getSubLed().getId();
						}
					}
					if(accountParameter.getAccountType().equals("Bank")){
						if(accountParameter.getAccount() != null){
							bankAccountId = accountParameter.getAccount().getId();
							bankSubGroupId = accountParameter.getAccount().getAccountSubGroup().getId();
							bankGroupId = accountParameter.getAccount().getAccountSubGroup().getAccountGroup().getId();
						}
						if(accountParameter.getSubLed()!= null){
							bankSubLedId = accountParameter.getSubLed().getId();
						}
					}
					if(accountParameter.getAccountType().equals("Credit Card")){
						if(accountParameter.getAccount() != null){
							creditCardAccountId = accountParameter.getAccount().getId();
							creditCardSubGroupId = accountParameter.getAccount().getAccountSubGroup().getId();
							creditCardGroupId = accountParameter.getAccount().getAccountSubGroup().getAccountGroup().getId();
						}
						if(accountParameter.getSubLed()!= null){
							creditCardSubLedId = accountParameter.getSubLed().getId();
						}
					}
				
					if(accountParameter.getAccountType().equals("Outstanding")){
						if(accountParameter.getAccount() != null){
							osAccountId = accountParameter.getAccount().getId();
							osSubGroupId = accountParameter.getAccount().getAccountSubGroup().getId();
							osGroupId = accountParameter.getAccount().getAccountSubGroup().getAccountGroup().getId();
						}
						if(accountParameter.getSubLed()!= null){
							osSubLedId = accountParameter.getSubLed().getId();
						}
					}
				}
			}
		
					
			/*dispensingHeaderList = session.createCriteria(BlDispensingHeader.class).add(Restrictions.between("BillInvoiceDate", java.sql.Date.valueOf(fromDate4MySQL), java.sql.Date.valueOf(toDate4MySQL)))
														.add(Restrictions.isNull("VoucherNo")).list();
			System.out.println("dispensingHeaderList==="+dispensingHeaderList.size());
			receiptHeaderList = session.createCriteria(BlReceiptHeader.class).add(Restrictions.between("ReceiptDate", java.sql.Date.valueOf(fromDate4MySQL), java.sql.Date.valueOf(toDate4MySQL)))
														.add(Restrictions.isNull("VoucherNo")).list();
			System.out.println("receiptHeaderList==="+receiptHeaderList.size());*/
			int count =1;
				if(box.getInt("count") != 0){
					count = (Integer)box.getInt("count");
				}
				System.out.println("count=="+count);
			
	 for (int j = 1; j < count; j++) {
		if(box.getString("voucherCnt"+j).equals("y")){
			FaVoucherHeader faVoucherHeader = new FaVoucherHeader();
			MasHospital masHospital = new MasHospital();
			masHospital.setId(box.getInt("locationId"));
			faVoucherHeader.setHospital(masHospital);
			faVoucherHeader.setVoucherDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			faVoucherHeader.setVoucherTime(box.getString(CHANGED_TIME));
			faVoucherHeader.setNarration(box.getString(NARRATION));
			Users users = new Users();
			users.setId( box.getInt("changedBy"));
			faVoucherHeader.setLastChgBy(users);
			faVoucherHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			faVoucherHeader.setLastChgTime(box.getString(CHANGED_TIME));
			faVoucherHeader.setVoucherType("SV");
			faVoucherHeader.setStatus("y");
			BigDecimal totalAmountDr = new BigDecimal(0.0);
			BigDecimal totalAmountCr = new BigDecimal(0.0);
			
			if (!box.getString("drAmount"+j).equals("")) {
				totalAmountDr = new BigDecimal(box.getString("drAmount"+j));
				faVoucherHeader.setDrAmount(totalAmountDr);
			}
			if (!box.getString("crAmount"+j).equals("")) {
				totalAmountCr = new BigDecimal(box.getString("crAmount"+j));
				faVoucherHeader.setCrAmount(totalAmountCr);
			}
			MasStoreFinancial masStoreFinancial = new MasStoreFinancial();
			masStoreFinancial.setId(box.getInt("fYear"));
			faVoucherHeader.setFYear(masStoreFinancial);
			paramMap.put("suffix", box.getString("fYearDesc"));
			paramMap.put("flag", "save");
			paramMap.put("prefix", "RV");
			paramMap.put("voucherType", "Receipt");
			paramMap.put("locationId", box.getInt("locationId"));
			 voucherNo = generateVoucherNo(paramMap);
			 String locationCode="";
				String yearDesc="";
				List<MasStoreFinancial>financialList=new ArrayList<MasStoreFinancial>();
				List<MasHospital>hospitalList=new ArrayList<MasHospital>();
				hospitalList=session.createCriteria(MasHospital.class).add(Restrictions.idEq(box.getInt("locationId"))).list();
				for(MasHospital mg:hospitalList){
					locationCode=mg.getHospitalCode();
				}
				financialList=session.createCriteria(MasStoreFinancial.class).add(Restrictions.idEq(box.getInt("fYear"))).list();
				for(MasStoreFinancial msf1:financialList){
					yearDesc=msf1.getYearDescription();
				}
				faVoucherHeader.setVoucherNo(locationCode+"/"+yearDesc+"/"+voucherNo);

			hbt.save(faVoucherHeader);
			map.put("voucherType", faVoucherHeader.getVoucherType());
	//======================================
					if(box.getInt("dispensingHeaderId"+j) != 0){
					BlDispensingHeader dispHeader = (BlDispensingHeader)hbt.load(BlDispensingHeader.class, box.getInt("dispensingHeaderId"+j));
					dispHeader.setVoucherNo(""+voucherNo);
					hbt.update(dispHeader);
				}
				if(box.getInt("receiptHeaderId"+j) != 0){
					BlReceiptHeader receiptHeader2= (BlReceiptHeader)hbt.load(BlReceiptHeader.class, box.getInt("receiptHeaderId"+j));
					receiptHeader2.setVoucherNo(""+voucherNo);
					hbt.update(receiptHeader2);
				}
			
			BigDecimal crAmt = new BigDecimal(0.00);
			BigDecimal drAmt = new BigDecimal(0.00);
			
			int accountId = 0;
			if(box.getString("cashAccountType"+j).equals("Cash")  ){
				if(!box.getString("cash"+j).equals(0.00)){
					FaVoucherDetails voucherDetails = new FaVoucherDetails();
					FaMasAccount masAccount = new FaMasAccount();
					masAccount.setId(cashAccountId);
					voucherDetails.setAccount(masAccount);
					voucherDetails.setVoucherHeader(faVoucherHeader);
					if(cashSubLedId != 0){
						FaMasSubLed subLed= new FaMasSubLed();
						subLed.setId(cashSubLedId);
						voucherDetails.setSubLed(subLed);
					}
					System.out.println("drAmt==="+new BigDecimal(box.getString("cash"+j)));
					drAmt = new BigDecimal(box.getString("cash"+j));
					voucherDetails.setDrAmount(drAmt);
					voucherDetails.setCrAmount(new BigDecimal(0));
					hbt.save(voucherDetails);

					//-------------------------update account group-------------------------------------------------

					BigDecimal groupOpBalanceDr = new BigDecimal(0.0);
					BigDecimal groupOpBalanceCr = new BigDecimal(0.0);
					BigDecimal groupYtdBalanceDr = new BigDecimal(0.0);
					BigDecimal groupYtdBalanceCr = new BigDecimal(0.0);
					BigDecimal drGroupAmount = new BigDecimal(0.0);
					BigDecimal crGroupAmount = new BigDecimal(0.0);
					System.out.println("cashGroupId=="+cashGroupId);
					FaMasAccountGroup faMasAccountGroup = (FaMasAccountGroup)hbt.load(FaMasAccountGroup.class, cashGroupId);
					//System.out.println("opBalancecr===="+faMasAccountGroup.getOpBalanceCr());
					if(!faMasAccountGroup.getOpBalanceCr().equals(new BigDecimal(0.00)) && faMasAccountGroup.getOpBalanceCr()!= null){
						groupOpBalanceCr =  faMasAccountGroup.getOpBalanceCr();
					}
					System.out.println("groupOpBalanceCr=="+groupOpBalanceCr);
					if(!faMasAccountGroup.getOpBalanceDr().equals(new BigDecimal(0.00))&& faMasAccountGroup.getOpBalanceDr()!= null){
						groupOpBalanceDr =  faMasAccountGroup.getOpBalanceDr();
					}
					System.out.println("groupOpBalanceDr=="+groupOpBalanceDr);
					if(faMasAccountGroup.getYtdAmountDr().equals(new BigDecimal(0.00)) && faMasAccountGroup.getYtdAmountDr()!= null){
						groupYtdBalanceDr =  faMasAccountGroup.getYtdAmountDr();
					}
					System.out.println("groupYtdBalanceDr=="+groupYtdBalanceDr);
					if(faMasAccountGroup.getYtdAmountCr().equals(new BigDecimal(0.00)) &&faMasAccountGroup.getYtdAmountCr()!= null){
						groupYtdBalanceCr =  faMasAccountGroup.getYtdAmountCr();
					}
					System.out.println("groupYtdBalanceCr=="+groupYtdBalanceCr);
					if(drAmt.compareTo(new BigDecimal(0))>0){
						 groupYtdBalanceDr = groupYtdBalanceDr.add(drAmt);
						 faMasAccountGroup.setYtdAmountDr(groupYtdBalanceDr);
					 }
					if(crAmt.compareTo(new BigDecimal(0))>0){
						 groupYtdBalanceCr = groupYtdBalanceCr.add(crAmt);
						 faMasAccountGroup.setYtdAmountCr(groupYtdBalanceCr);
					 }
					drGroupAmount = groupOpBalanceDr.add(groupYtdBalanceDr);
					crGroupAmount = groupOpBalanceCr.add(groupYtdBalanceCr);
					System.out.println("drGroupAmount=="+drGroupAmount);
					System.out.println("crGroupAmount=="+crGroupAmount);
					
					if(drGroupAmount.compareTo(crGroupAmount)>0){
						System.out.println("11in ifdr==="+drGroupAmount.subtract(crGroupAmount));
						faMasAccountGroup.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
						System.out.println("11cr=="+new BigDecimal(0.00));
					    faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
					}else if(crGroupAmount.compareTo(drGroupAmount)>0){
						System.out.println("22in else  if");
						faMasAccountGroup.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
					    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
					}else if(crGroupAmount.compareTo(drGroupAmount)==0){
						System.out.println("33in else  if");
						faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
					    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
					}

				 	hbt.update(faMasAccountGroup);

		//-------------------------update account Sub group-------------------------------------------------

				 	BigDecimal subGroupOPBalanceDr = new BigDecimal(0);
					BigDecimal subGroupOPBalanceCr = new BigDecimal(0);
					BigDecimal subGroupYtdBalanceDr = new BigDecimal(0);
					BigDecimal subGroupYtdBalanceCr = new BigDecimal(0);
					BigDecimal drSubGroupAmount = new BigDecimal(0.0);
					BigDecimal crSubGroupAmount = new BigDecimal(0.0);

					FaMasAccountSubGroup accountSubGroup = (FaMasAccountSubGroup)hbt.load(FaMasAccountSubGroup.class, cashSubGroupId);
					 if(accountSubGroup.getOpBalanceDr()!= null){
						 subGroupOPBalanceDr =  accountSubGroup.getOpBalanceDr();
					 }
					 if(accountSubGroup.getOpBalanceCr()!= null){
						 subGroupOPBalanceCr = accountSubGroup.getOpBalanceCr();
					 }
					 if(accountSubGroup.getYtdAmountDr()!= null){
						 subGroupYtdBalanceDr = accountSubGroup.getYtdAmountDr();
					 }
					 if(accountSubGroup.getYtdAmountCr()!= null){
						 subGroupYtdBalanceCr = accountSubGroup.getYtdAmountCr();
					 }
					 if(drAmt.compareTo(new BigDecimal(0))>0){
						 subGroupYtdBalanceDr = subGroupYtdBalanceDr.add(drAmt);
						 accountSubGroup.setYtdAmountDr(subGroupYtdBalanceDr);
					 }
					 if(crAmt.compareTo(new BigDecimal(0))>0){
						 subGroupYtdBalanceCr = subGroupYtdBalanceCr.add(crAmt);
						 accountSubGroup.setYtdAmountCr(subGroupYtdBalanceCr);
					 }
					 drSubGroupAmount = subGroupOPBalanceDr.add(subGroupYtdBalanceDr);
					 crSubGroupAmount = subGroupOPBalanceCr.add(subGroupYtdBalanceCr);
						if(drGroupAmount.compareTo(crGroupAmount)>0){
							accountSubGroup.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
							accountSubGroup.setClBalanceCr(new BigDecimal(0.00));
						}else if(crGroupAmount.compareTo(drGroupAmount)>0){
							accountSubGroup.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
							accountSubGroup.setClBalanceDr(new BigDecimal(0.00));
						}else if(crGroupAmount.compareTo(drGroupAmount)==0){
							accountSubGroup.setClBalanceCr(new BigDecimal(0.00));
							accountSubGroup.setClBalanceDr(new BigDecimal(0.00));
						}

				 	hbt.update(accountSubGroup);

		//-------------------------update account master-------------------------------------------------

					BigDecimal accountOpBalanceDr = new  BigDecimal(0.0);
			 		BigDecimal accountOpBalanceCr = new  BigDecimal(0.0);
			 		BigDecimal accountYtdBalanceDr = new BigDecimal(0.0);
			 		BigDecimal accountYtdBalanceCr = new  BigDecimal(0.0);
			 		BigDecimal drAccountAmount = new BigDecimal(0.0);
			 		BigDecimal crAccountAmount = new  BigDecimal(0.0);
			 		 masAccount = (FaMasAccount)hbt.load(FaMasAccount.class,cashAccountId);
			 		if(masAccount.getOpBalanceDr()!= null){
			 			accountOpBalanceDr =  masAccount.getOpBalanceDr();
			 		}
			 		if(masAccount.getOpBalanceCr()!= null){
			 			accountOpBalanceCr = masAccount.getOpBalanceCr();
			 		}

			 		 if(masAccount.getYtdAmountDr() != null){
			 			 accountYtdBalanceDr = masAccount.getYtdAmountDr();
			 		 }
			 		 if(masAccount.getYtdAmountCr() != null){
			 			accountYtdBalanceCr = masAccount.getYtdAmountCr();
			 		 }
			 		if(drAmt.compareTo(new BigDecimal(0))>0){
						 accountYtdBalanceDr = accountYtdBalanceDr.add(drAmt);
						 masAccount.setYtdAmountDr(accountYtdBalanceDr);
					 }
					 if(crAmt.compareTo(new BigDecimal(0))>0){
						 accountYtdBalanceCr = accountYtdBalanceCr.add(crAmt);
						 masAccount.setYtdAmountCr(accountYtdBalanceCr);
					 }
					 drAccountAmount = accountOpBalanceDr.add(accountYtdBalanceDr);
					 crAccountAmount = accountOpBalanceCr.add(accountYtdBalanceCr);
						if(drAccountAmount.compareTo(crAccountAmount)>0){
							masAccount.setClBalanceDr(drAccountAmount.subtract(crAccountAmount));
							masAccount.setClBalanceCr(new BigDecimal(0.00));
						}else if(crAccountAmount.compareTo(drAccountAmount)>0){
							masAccount.setClBalanceCr(crAccountAmount.subtract(drAccountAmount));
							masAccount.setClBalanceDr(new BigDecimal(0.00));
						}else if(crAccountAmount.compareTo(drAccountAmount)==0){
							masAccount.setClBalanceCr(new BigDecimal(0.00));
							masAccount.setClBalanceDr(new BigDecimal(0.00));
						}


					 hbt.update(masAccount);
	//------------------------------------------
					

					//-----------------------update account sub ledger==================================

					 if(cashSubLedId !=0){
						 BigDecimal subLedgerOPBalanceCr = new BigDecimal(0.0);
						 BigDecimal subLedgerOPBalanceDr = new BigDecimal(0.0);
						 BigDecimal subLedgerYTDBalanceDr = new BigDecimal(0.0);
						 BigDecimal subLedgerYTDBalanceCr = new BigDecimal(0.0);
						 BigDecimal drAmountSubLedger = new BigDecimal(0.0);
						 BigDecimal crAmountSubLedger = new BigDecimal(0.0);

						 FaMasSubLed subLed= (FaMasSubLed)hbt.load(FaMasSubLed.class, cashSubLedId);
						 if(subLed.getOpBalanceCr()!= null){
							 subLedgerOPBalanceCr =  subLed.getOpBalanceCr();
						 }
						 if(subLed.getOpBalanceDr()!= null){
							 subLedgerOPBalanceDr = subLed.getOpBalanceDr();
						 }

						if(subLed.getYtdAmountCr()!= null){
							subLedgerYTDBalanceCr = subLed.getYtdAmountCr();
						}
						if(subLed.getYtdAmountDr()!= null){
							subLedgerYTDBalanceDr = subLed.getYtdAmountDr();
						}
						if(drAmt.compareTo(new BigDecimal(0))>0){
							subLedgerYTDBalanceDr = subLedgerYTDBalanceDr.add(drAmt);
							subLed.setYtdAmountDr(subLedgerYTDBalanceDr);
						 }
						 if(crAmt.compareTo(new BigDecimal(0))>0){
							 subLedgerYTDBalanceCr = subLedgerYTDBalanceCr.add(crAmt);
							 subLed.setYtdAmountCr(subLedgerYTDBalanceCr);
						 }
						 crAmountSubLedger = subLedgerOPBalanceCr.add(subLedgerYTDBalanceCr);
						drAmountSubLedger = subLedgerOPBalanceDr.add(subLedgerYTDBalanceDr);

						if(drAmountSubLedger.compareTo(crAmountSubLedger)>0){
							subLed.setClBalanceDr(drAmountSubLedger.subtract(crAmountSubLedger));
							subLed.setClBalanceCr(new BigDecimal(0.00));
						}else if(crAmountSubLedger.compareTo(drAmountSubLedger)>0){
							subLed.setClBalanceCr(crAmountSubLedger.subtract(drAmountSubLedger));
							subLed.setClBalanceDr(new BigDecimal(0.00));
						}else if(crAmountSubLedger.compareTo(drAmountSubLedger)==0){
							subLed.setClBalanceCr(new BigDecimal(0.00));
							subLed.setClBalanceDr(new BigDecimal(0.00));
						}
							 hbt.update(subLed);


					 }
				}
			}
			if(box.getString("bankAccountType"+j).equals("Bank")  ){
				if(!box.getString("bank"+j).equals(0.00)){
					FaVoucherDetails voucherDetails = new FaVoucherDetails();
					FaMasAccount masAccount = new FaMasAccount();
					masAccount.setId(bankAccountId);
					voucherDetails.setAccount(masAccount);
					voucherDetails.setVoucherHeader(faVoucherHeader);
					if(cashSubLedId != 0){
						FaMasSubLed subLed= new FaMasSubLed();
						subLed.setId(bankSubLedId);
						voucherDetails.setSubLed(subLed);
					}
					drAmt = new BigDecimal(box.getString("bank"+j));
					voucherDetails.setDrAmount(drAmt);
					voucherDetails.setCrAmount(new BigDecimal(0));
					//-------------------------update account group-------------------------------------------------

					BigDecimal groupOpBalanceDr = new BigDecimal(0.0);
					BigDecimal groupOpBalanceCr = new BigDecimal(0.0);
					BigDecimal groupYtdBalanceDr = new BigDecimal(0.0);
					BigDecimal groupYtdBalanceCr = new BigDecimal(0.0);
					BigDecimal drGroupAmount = new BigDecimal(0.0);
					BigDecimal crGroupAmount = new BigDecimal(0.0);

					FaMasAccountGroup faMasAccountGroup = (FaMasAccountGroup)hbt.load(FaMasAccountGroup.class, bankGroupId);
					//System.out.println("opBalancecr===="+faMasAccountGroup.getOpBalanceCr());
					if(!faMasAccountGroup.getOpBalanceCr().equals(new BigDecimal(0.0)) && faMasAccountGroup.getOpBalanceCr()!= null){
						groupOpBalanceCr =  faMasAccountGroup.getOpBalanceCr();
					}
					if(!faMasAccountGroup.getOpBalanceDr().equals(new BigDecimal(0.0))&& faMasAccountGroup.getOpBalanceDr()!= null){
						groupOpBalanceDr =  faMasAccountGroup.getOpBalanceDr();
					}
					if(faMasAccountGroup.getYtdAmountDr().equals(new BigDecimal(0.0)) && faMasAccountGroup.getYtdAmountDr()!= null){
						groupYtdBalanceDr =  faMasAccountGroup.getYtdAmountDr();
					}
					if(faMasAccountGroup.getYtdAmountCr().equals(new BigDecimal(0.0)) &&faMasAccountGroup.getYtdAmountCr()!= null){
						groupYtdBalanceCr =  faMasAccountGroup.getYtdAmountCr();
					}
					if(drAmt.compareTo(new BigDecimal(0))>0){
						 groupYtdBalanceDr = groupYtdBalanceDr.add(drAmt);
						 faMasAccountGroup.setYtdAmountDr(groupYtdBalanceDr);
					 }
					if(crAmt.compareTo(new BigDecimal(0))>0){
						 groupYtdBalanceCr = groupYtdBalanceCr.add(crAmt);
						 faMasAccountGroup.setYtdAmountCr(groupYtdBalanceCr);
					 }
					drGroupAmount = groupOpBalanceDr.add(groupYtdBalanceDr);
					crGroupAmount = groupOpBalanceCr.add(groupYtdBalanceCr);
					if(drGroupAmount.compareTo(crGroupAmount)>0){
						faMasAccountGroup.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
					    faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
					}else if(crGroupAmount.compareTo(drGroupAmount)>0){
						faMasAccountGroup.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
					    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
					}else if(crGroupAmount.compareTo(drGroupAmount)==0){
						faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
					    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
					}

				 	hbt.update(faMasAccountGroup);

		//-------------------------update account Sub group-------------------------------------------------

				 	BigDecimal subGroupOPBalanceDr = new BigDecimal(0);
					BigDecimal subGroupOPBalanceCr = new BigDecimal(0);
					BigDecimal subGroupYtdBalanceDr = new BigDecimal(0);
					BigDecimal subGroupYtdBalanceCr = new BigDecimal(0);
					BigDecimal drSubGroupAmount = new BigDecimal(0.0);
					BigDecimal crSubGroupAmount = new BigDecimal(0.0);

					FaMasAccountSubGroup accountSubGroup = (FaMasAccountSubGroup)hbt.load(FaMasAccountSubGroup.class, bankSubGroupId);
					 if(accountSubGroup.getOpBalanceDr()!= null){
						 subGroupOPBalanceDr =  accountSubGroup.getOpBalanceDr();
					 }
					 if(accountSubGroup.getOpBalanceCr()!= null){
						 subGroupOPBalanceCr = accountSubGroup.getOpBalanceCr();
					 }
					 if(accountSubGroup.getYtdAmountDr()!= null){
						 subGroupYtdBalanceDr = accountSubGroup.getYtdAmountDr();
					 }
					 if(accountSubGroup.getYtdAmountCr()!= null){
						 subGroupYtdBalanceCr = accountSubGroup.getYtdAmountCr();
					 }
					 if(drAmt.compareTo(new BigDecimal(0))>0){
						 subGroupYtdBalanceDr = subGroupYtdBalanceDr.add(drAmt);
						 accountSubGroup.setYtdAmountDr(subGroupYtdBalanceDr);
					 }
					 if(crAmt.compareTo(new BigDecimal(0))>0){
						 subGroupYtdBalanceCr = subGroupYtdBalanceCr.add(crAmt);
						 accountSubGroup.setYtdAmountCr(subGroupYtdBalanceCr);
					 }
					 drSubGroupAmount = subGroupOPBalanceDr.add(subGroupYtdBalanceDr);
					 crSubGroupAmount = subGroupOPBalanceCr.add(subGroupYtdBalanceCr);
						if(drGroupAmount.compareTo(crGroupAmount)>0){
							accountSubGroup.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
							accountSubGroup.setClBalanceCr(new BigDecimal(0.00));
						}else if(crGroupAmount.compareTo(drGroupAmount)>0){
							accountSubGroup.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
							accountSubGroup.setClBalanceDr(new BigDecimal(0.00));
						}else if(crGroupAmount.compareTo(drGroupAmount)==0){
							accountSubGroup.setClBalanceCr(new BigDecimal(0.00));
							accountSubGroup.setClBalanceDr(new BigDecimal(0.00));
						}

				 	hbt.update(accountSubGroup);

		//-------------------------update account master-------------------------------------------------

					BigDecimal accountOpBalanceDr = new  BigDecimal(0.0);
			 		BigDecimal accountOpBalanceCr = new  BigDecimal(0.0);
			 		BigDecimal accountYtdBalanceDr = new BigDecimal(0.0);
			 		BigDecimal accountYtdBalanceCr = new  BigDecimal(0.0);
			 		BigDecimal drAccountAmount = new BigDecimal(0.0);
			 		BigDecimal crAccountAmount = new  BigDecimal(0.0);
			 		masAccount = (FaMasAccount)hbt.load(FaMasAccount.class,bankAccountId);
			 		if(masAccount.getOpBalanceDr()!= null){
			 			accountOpBalanceDr =  masAccount.getOpBalanceDr();
			 		}
			 		if(masAccount.getOpBalanceCr()!= null){
			 			accountOpBalanceCr = masAccount.getOpBalanceCr();
			 		}

			 		 if(masAccount.getYtdAmountDr() != null){
			 			 accountYtdBalanceDr = masAccount.getYtdAmountDr();
			 		 }
			 		 if(masAccount.getYtdAmountCr() != null){
			 			accountYtdBalanceCr = masAccount.getYtdAmountCr();
			 		 }
			 		if(drAmt.compareTo(new BigDecimal(0))>0){
						 accountYtdBalanceDr = accountYtdBalanceDr.add(drAmt);
						 masAccount.setYtdAmountDr(accountYtdBalanceDr);
					 }
					 if(crAmt.compareTo(new BigDecimal(0))>0){
						 accountYtdBalanceCr = accountYtdBalanceCr.add(crAmt);
						 masAccount.setYtdAmountCr(accountYtdBalanceCr);
					 }
					 drAccountAmount = accountOpBalanceDr.add(accountYtdBalanceDr);
					 crAccountAmount = accountOpBalanceCr.add(accountYtdBalanceCr);
						if(drAccountAmount.compareTo(crAccountAmount)>0){
							masAccount.setClBalanceDr(drAccountAmount.subtract(crAccountAmount));
							masAccount.setClBalanceCr(new BigDecimal(0.00));
						}else if(crAccountAmount.compareTo(drAccountAmount)>0){
							masAccount.setClBalanceCr(crAccountAmount.subtract(drAccountAmount));
							masAccount.setClBalanceDr(new BigDecimal(0.00));
						}else if(crAccountAmount.compareTo(drAccountAmount)==0){
							masAccount.setClBalanceCr(new BigDecimal(0.00));
							masAccount.setClBalanceDr(new BigDecimal(0.00));
						}


					 hbt.update(masAccount);
	//------------------------------------------
					

					//-----------------------update account sub ledger==================================

					 if(bankSubLedId !=0){
						 BigDecimal subLedgerOPBalanceCr = new BigDecimal(0.0);
						 BigDecimal subLedgerOPBalanceDr = new BigDecimal(0.0);
						 BigDecimal subLedgerYTDBalanceDr = new BigDecimal(0.0);
						 BigDecimal subLedgerYTDBalanceCr = new BigDecimal(0.0);
						 BigDecimal drAmountSubLedger = new BigDecimal(0.0);
						 BigDecimal crAmountSubLedger = new BigDecimal(0.0);

						 FaMasSubLed subLed= (FaMasSubLed)hbt.load(FaMasSubLed.class, bankSubLedId);
						 if(subLed.getOpBalanceCr()!= null){
							 subLedgerOPBalanceCr =  subLed.getOpBalanceCr();
						 }
						 if(subLed.getOpBalanceDr()!= null){
							 subLedgerOPBalanceDr = subLed.getOpBalanceDr();
						 }

						if(subLed.getYtdAmountCr()!= null){
							subLedgerYTDBalanceCr = subLed.getYtdAmountCr();
						}
						if(subLed.getYtdAmountDr()!= null){
							subLedgerYTDBalanceDr = subLed.getYtdAmountDr();
						}
						if(drAmt.compareTo(new BigDecimal(0))>0){
							subLedgerYTDBalanceDr = subLedgerYTDBalanceDr.add(drAmt);
							subLed.setYtdAmountDr(subLedgerYTDBalanceDr);
						 }
						 if(crAmt.compareTo(new BigDecimal(0))>0){
							 subLedgerYTDBalanceCr = subLedgerYTDBalanceCr.add(crAmt);
							 subLed.setYtdAmountCr(subLedgerYTDBalanceCr);
						 }
						 crAmountSubLedger = subLedgerOPBalanceCr.add(subLedgerYTDBalanceCr);
						drAmountSubLedger = subLedgerOPBalanceDr.add(subLedgerYTDBalanceDr);

						if(drAmountSubLedger.compareTo(crAmountSubLedger)>0){
							subLed.setClBalanceDr(drAmountSubLedger.subtract(crAmountSubLedger));
							subLed.setClBalanceCr(new BigDecimal(0.00));
						}else if(crAmountSubLedger.compareTo(drAmountSubLedger)>0){
							subLed.setClBalanceCr(crAmountSubLedger.subtract(drAmountSubLedger));
							subLed.setClBalanceDr(new BigDecimal(0.00));
						}else if(crAmountSubLedger.compareTo(drAmountSubLedger)==0){
							subLed.setClBalanceCr(new BigDecimal(0.00));
							subLed.setClBalanceDr(new BigDecimal(0.00));
						}
							 hbt.update(subLed);
					 }		
				}
			}
			if(box.getString("cCAccountType"+j).equals("Credit Card")){
				if(!box.getString("creditCard"+j).equals(0.00)){
					FaVoucherDetails voucherDetails = new FaVoucherDetails();
					FaMasAccount masAccount = new FaMasAccount();
					masAccount.setId(creditCardAccountId);
					voucherDetails.setAccount(masAccount);
					voucherDetails.setVoucherHeader(faVoucherHeader);
					if(creditCardSubLedId != 0){
						FaMasSubLed subLed= new FaMasSubLed();
						subLed.setId(creditCardSubLedId);
						voucherDetails.setSubLed(subLed);
					}
					drAmt = new BigDecimal(box.getString("creditCard"+j));
					voucherDetails.setDrAmount(drAmt);
					voucherDetails.setCrAmount(new BigDecimal(0));
					//-------------------------update account group-------------------------------------------------

					BigDecimal groupOpBalanceDr = new BigDecimal(0.0);
					BigDecimal groupOpBalanceCr = new BigDecimal(0.0);
					BigDecimal groupYtdBalanceDr = new BigDecimal(0.0);
					BigDecimal groupYtdBalanceCr = new BigDecimal(0.0);
					BigDecimal drGroupAmount = new BigDecimal(0.0);
					BigDecimal crGroupAmount = new BigDecimal(0.0);

					FaMasAccountGroup faMasAccountGroup = (FaMasAccountGroup)hbt.load(FaMasAccountGroup.class, creditCardGroupId);
					//System.out.println("opBalancecr===="+faMasAccountGroup.getOpBalanceCr());
					if(!faMasAccountGroup.getOpBalanceCr().equals(new BigDecimal(0.0)) && faMasAccountGroup.getOpBalanceCr()!= null){
						groupOpBalanceCr =  faMasAccountGroup.getOpBalanceCr();
					}
					if(!faMasAccountGroup.getOpBalanceDr().equals(new BigDecimal(0.0))&& faMasAccountGroup.getOpBalanceDr()!= null){
						groupOpBalanceDr =  faMasAccountGroup.getOpBalanceDr();
					}
					if(faMasAccountGroup.getYtdAmountDr().equals(new BigDecimal(0.0)) && faMasAccountGroup.getYtdAmountDr()!= null){
						groupYtdBalanceDr =  faMasAccountGroup.getYtdAmountDr();
					}
					if(faMasAccountGroup.getYtdAmountCr().equals(new BigDecimal(0.0)) &&faMasAccountGroup.getYtdAmountCr()!= null){
						groupYtdBalanceCr =  faMasAccountGroup.getYtdAmountCr();
					}
					if(drAmt.compareTo(new BigDecimal(0))>0){
						 groupYtdBalanceDr = groupYtdBalanceDr.add(drAmt);
						 faMasAccountGroup.setYtdAmountDr(groupYtdBalanceDr);
					 }
					if(crAmt.compareTo(new BigDecimal(0))>0){
						 groupYtdBalanceCr = groupYtdBalanceCr.add(crAmt);
						 faMasAccountGroup.setYtdAmountCr(groupYtdBalanceCr);
					 }
					drGroupAmount = groupOpBalanceDr.add(groupYtdBalanceDr);
					crGroupAmount = groupOpBalanceCr.add(groupYtdBalanceCr);
					if(drGroupAmount.compareTo(crGroupAmount)>0){
						faMasAccountGroup.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
					    faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
					}else if(crGroupAmount.compareTo(drGroupAmount)>0){
						faMasAccountGroup.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
					    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
					}else if(crGroupAmount.compareTo(drGroupAmount)==0){
						faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
					    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
					}

				 	hbt.update(faMasAccountGroup);

		//-------------------------update account Sub group-------------------------------------------------

				 	BigDecimal subGroupOPBalanceDr = new BigDecimal(0);
					BigDecimal subGroupOPBalanceCr = new BigDecimal(0);
					BigDecimal subGroupYtdBalanceDr = new BigDecimal(0);
					BigDecimal subGroupYtdBalanceCr = new BigDecimal(0);
					BigDecimal drSubGroupAmount = new BigDecimal(0.0);
					BigDecimal crSubGroupAmount = new BigDecimal(0.0);

					FaMasAccountSubGroup accountSubGroup = (FaMasAccountSubGroup)hbt.load(FaMasAccountSubGroup.class, creditCardSubGroupId);
					 if(accountSubGroup.getOpBalanceDr()!= null){
						 subGroupOPBalanceDr =  accountSubGroup.getOpBalanceDr();
					 }
					 if(accountSubGroup.getOpBalanceCr()!= null){
						 subGroupOPBalanceCr = accountSubGroup.getOpBalanceCr();
					 }
					 if(accountSubGroup.getYtdAmountDr()!= null){
						 subGroupYtdBalanceDr = accountSubGroup.getYtdAmountDr();
					 }
					 if(accountSubGroup.getYtdAmountCr()!= null){
						 subGroupYtdBalanceCr = accountSubGroup.getYtdAmountCr();
					 }
					 if(drAmt.compareTo(new BigDecimal(0))>0){
						 subGroupYtdBalanceDr = subGroupYtdBalanceDr.add(drAmt);
						 accountSubGroup.setYtdAmountDr(subGroupYtdBalanceDr);
					 }
					 if(crAmt.compareTo(new BigDecimal(0))>0){
						 subGroupYtdBalanceCr = subGroupYtdBalanceCr.add(crAmt);
						 accountSubGroup.setYtdAmountCr(subGroupYtdBalanceCr);
					 }
					 drSubGroupAmount = subGroupOPBalanceDr.add(subGroupYtdBalanceDr);
					 crSubGroupAmount = subGroupOPBalanceCr.add(subGroupYtdBalanceCr);
						if(drGroupAmount.compareTo(crGroupAmount)>0){
							accountSubGroup.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
							accountSubGroup.setClBalanceCr(new BigDecimal(0.00));
						}else if(crGroupAmount.compareTo(drGroupAmount)>0){
							accountSubGroup.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
							accountSubGroup.setClBalanceDr(new BigDecimal(0.00));
						}else if(crGroupAmount.compareTo(drGroupAmount)==0){
							accountSubGroup.setClBalanceCr(new BigDecimal(0.00));
							accountSubGroup.setClBalanceDr(new BigDecimal(0.00));
						}

				 	hbt.update(accountSubGroup);

		//-------------------------update account master-------------------------------------------------

					BigDecimal accountOpBalanceDr = new  BigDecimal(0.0);
			 		BigDecimal accountOpBalanceCr = new  BigDecimal(0.0);
			 		BigDecimal accountYtdBalanceDr = new BigDecimal(0.0);
			 		BigDecimal accountYtdBalanceCr = new  BigDecimal(0.0);
			 		BigDecimal drAccountAmount = new BigDecimal(0.0);
			 		BigDecimal crAccountAmount = new  BigDecimal(0.0);
			 		masAccount = (FaMasAccount)hbt.load(FaMasAccount.class,creditCardAccountId);
			 		if(masAccount.getOpBalanceDr()!= null){
			 			accountOpBalanceDr =  masAccount.getOpBalanceDr();
			 		}
			 		if(masAccount.getOpBalanceCr()!= null){
			 			accountOpBalanceCr = masAccount.getOpBalanceCr();
			 		}

			 		 if(masAccount.getYtdAmountDr() != null){
			 			 accountYtdBalanceDr = masAccount.getYtdAmountDr();
			 		 }
			 		 if(masAccount.getYtdAmountCr() != null){
			 			accountYtdBalanceCr = masAccount.getYtdAmountCr();
			 		 }
			 		if(drAmt.compareTo(new BigDecimal(0))>0){
						 accountYtdBalanceDr = accountYtdBalanceDr.add(drAmt);
						 masAccount.setYtdAmountDr(accountYtdBalanceDr);
					 }
					 if(crAmt.compareTo(new BigDecimal(0))>0){
						 accountYtdBalanceCr = accountYtdBalanceCr.add(crAmt);
						 masAccount.setYtdAmountCr(accountYtdBalanceCr);
					 }
					 drAccountAmount = accountOpBalanceDr.add(accountYtdBalanceDr);
					 crAccountAmount = accountOpBalanceCr.add(accountYtdBalanceCr);
						if(drAccountAmount.compareTo(crAccountAmount)>0){
							masAccount.setClBalanceDr(drAccountAmount.subtract(crAccountAmount));
							masAccount.setClBalanceCr(new BigDecimal(0.00));
						}else if(crAccountAmount.compareTo(drAccountAmount)>0){
							masAccount.setClBalanceCr(crAccountAmount.subtract(drAccountAmount));
							masAccount.setClBalanceDr(new BigDecimal(0.00));
						}else if(crAccountAmount.compareTo(drAccountAmount)==0){
							masAccount.setClBalanceCr(new BigDecimal(0.00));
							masAccount.setClBalanceDr(new BigDecimal(0.00));
						}


					 hbt.update(masAccount);
	//------------------------------------------
					

					//-----------------------update account sub ledger==================================

					 if(creditCardSubLedId !=0){
						 BigDecimal subLedgerOPBalanceCr = new BigDecimal(0.0);
						 BigDecimal subLedgerOPBalanceDr = new BigDecimal(0.0);
						 BigDecimal subLedgerYTDBalanceDr = new BigDecimal(0.0);
						 BigDecimal subLedgerYTDBalanceCr = new BigDecimal(0.0);
						 BigDecimal drAmountSubLedger = new BigDecimal(0.0);
						 BigDecimal crAmountSubLedger = new BigDecimal(0.0);

						 FaMasSubLed subLed= (FaMasSubLed)hbt.load(FaMasSubLed.class, creditCardSubLedId);
						 if(subLed.getOpBalanceCr()!= null){
							 subLedgerOPBalanceCr =  subLed.getOpBalanceCr();
						 }
						 if(subLed.getOpBalanceDr()!= null){
							 subLedgerOPBalanceDr = subLed.getOpBalanceDr();
						 }

						if(subLed.getYtdAmountCr()!= null){
							subLedgerYTDBalanceCr = subLed.getYtdAmountCr();
						}
						if(subLed.getYtdAmountDr()!= null){
							subLedgerYTDBalanceDr = subLed.getYtdAmountDr();
						}
						if(drAmt.compareTo(new BigDecimal(0))>0){
							subLedgerYTDBalanceDr = subLedgerYTDBalanceDr.add(drAmt);
							subLed.setYtdAmountDr(subLedgerYTDBalanceDr);
						 }
						 if(crAmt.compareTo(new BigDecimal(0))>0){
							 subLedgerYTDBalanceCr = subLedgerYTDBalanceCr.add(crAmt);
							 subLed.setYtdAmountCr(subLedgerYTDBalanceCr);
						 }
						 crAmountSubLedger = subLedgerOPBalanceCr.add(subLedgerYTDBalanceCr);
						drAmountSubLedger = subLedgerOPBalanceDr.add(subLedgerYTDBalanceDr);

						if(drAmountSubLedger.compareTo(crAmountSubLedger)>0){
							subLed.setClBalanceDr(drAmountSubLedger.subtract(crAmountSubLedger));
							subLed.setClBalanceCr(new BigDecimal(0.00));
						}else if(crAmountSubLedger.compareTo(drAmountSubLedger)>0){
							subLed.setClBalanceCr(crAmountSubLedger.subtract(drAmountSubLedger));
							subLed.setClBalanceDr(new BigDecimal(0.00));
						}else if(crAmountSubLedger.compareTo(drAmountSubLedger)==0){
							subLed.setClBalanceCr(new BigDecimal(0.00));
							subLed.setClBalanceDr(new BigDecimal(0.00));
						}
							 hbt.update(subLed);
					 }	
				}
			}
			
			
			if(box.getString("oSAccountType"+j).equals("Outstanding")){
				if(!box.getString("outstanding"+j).equals(0.00)){
					FaVoucherDetails voucherDetails = new FaVoucherDetails();
					FaMasAccount masAccount = new FaMasAccount();
					masAccount.setId(osAccountId);
					voucherDetails.setAccount(masAccount);
					voucherDetails.setVoucherHeader(faVoucherHeader);
					if(osSubLedId != 0){
						FaMasSubLed subLed= new FaMasSubLed();
						subLed.setId(osSubLedId);
						voucherDetails.setSubLed(subLed);
					}
						crAmt = new BigDecimal(box.getString("outstanding"+j));
						voucherDetails.setCrAmount(crAmt);
						voucherDetails.setDrAmount(new BigDecimal(0));
						hbt.save(voucherDetails);
						//-------------------------update account group-------------------------------------------------

						BigDecimal groupOpBalanceDr = new BigDecimal(0.0);
						BigDecimal groupOpBalanceCr = new BigDecimal(0.0);
						BigDecimal groupYtdBalanceDr = new BigDecimal(0.0);
						BigDecimal groupYtdBalanceCr = new BigDecimal(0.0);
						BigDecimal drGroupAmount = new BigDecimal(0.0);
						BigDecimal crGroupAmount = new BigDecimal(0.0);

						FaMasAccountGroup faMasAccountGroup = (FaMasAccountGroup)hbt.load(FaMasAccountGroup.class, osGroupId);
						//System.out.println("opBalancecr===="+faMasAccountGroup.getOpBalanceCr());
						if(!faMasAccountGroup.getOpBalanceCr().equals(new BigDecimal(0.0)) && faMasAccountGroup.getOpBalanceCr()!= null){
							groupOpBalanceCr =  faMasAccountGroup.getOpBalanceCr();
						}
						if(!faMasAccountGroup.getOpBalanceDr().equals(new BigDecimal(0.0))&& faMasAccountGroup.getOpBalanceDr()!= null){
							groupOpBalanceDr =  faMasAccountGroup.getOpBalanceDr();
						}
						if(faMasAccountGroup.getYtdAmountDr().equals(new BigDecimal(0.0)) && faMasAccountGroup.getYtdAmountDr()!= null){
							groupYtdBalanceDr =  faMasAccountGroup.getYtdAmountDr();
						}
						if(faMasAccountGroup.getYtdAmountCr().equals(new BigDecimal(0.0)) &&faMasAccountGroup.getYtdAmountCr()!= null){
							groupYtdBalanceCr =  faMasAccountGroup.getYtdAmountCr();
						}
						if(drAmt.compareTo(new BigDecimal(0))>0){
							 groupYtdBalanceDr = groupYtdBalanceDr.add(drAmt);
							 faMasAccountGroup.setYtdAmountDr(groupYtdBalanceDr);
						 }
						if(crAmt.compareTo(new BigDecimal(0))>0){
							 groupYtdBalanceCr = groupYtdBalanceCr.add(crAmt);
							 faMasAccountGroup.setYtdAmountCr(groupYtdBalanceCr);
						 }
						drGroupAmount = groupOpBalanceDr.add(groupYtdBalanceDr);
						crGroupAmount = groupOpBalanceCr.add(groupYtdBalanceCr);
						if(drGroupAmount.compareTo(crGroupAmount)>0){
							faMasAccountGroup.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
						    faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
						}else if(crGroupAmount.compareTo(drGroupAmount)>0){
							faMasAccountGroup.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
						    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
						}else if(crGroupAmount.compareTo(drGroupAmount)==0){
							faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
						    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
						}

					 	hbt.update(faMasAccountGroup);

			//-------------------------update account Sub group-------------------------------------------------

					 	BigDecimal subGroupOPBalanceDr = new BigDecimal(0);
						BigDecimal subGroupOPBalanceCr = new BigDecimal(0);
						BigDecimal subGroupYtdBalanceDr = new BigDecimal(0);
						BigDecimal subGroupYtdBalanceCr = new BigDecimal(0);
						BigDecimal drSubGroupAmount = new BigDecimal(0.0);
						BigDecimal crSubGroupAmount = new BigDecimal(0.0);

						FaMasAccountSubGroup accountSubGroup = (FaMasAccountSubGroup)hbt.load(FaMasAccountSubGroup.class, osSubGroupId);
						 if(accountSubGroup.getOpBalanceDr()!= null){
							 subGroupOPBalanceDr =  accountSubGroup.getOpBalanceDr();
						 }
						 if(accountSubGroup.getOpBalanceCr()!= null){
							 subGroupOPBalanceCr = accountSubGroup.getOpBalanceCr();
						 }
						 if(accountSubGroup.getYtdAmountDr()!= null){
							 subGroupYtdBalanceDr = accountSubGroup.getYtdAmountDr();
						 }
						 if(accountSubGroup.getYtdAmountCr()!= null){
							 subGroupYtdBalanceCr = accountSubGroup.getYtdAmountCr();
						 }
						 if(drAmt.compareTo(new BigDecimal(0))>0){
							 subGroupYtdBalanceDr = subGroupYtdBalanceDr.add(drAmt);
							 accountSubGroup.setYtdAmountDr(subGroupYtdBalanceDr);
						 }
						 if(crAmt.compareTo(new BigDecimal(0))>0){
							 subGroupYtdBalanceCr = subGroupYtdBalanceCr.add(crAmt);
							 accountSubGroup.setYtdAmountCr(subGroupYtdBalanceCr);
						 }
						 drSubGroupAmount = subGroupOPBalanceDr.add(subGroupYtdBalanceDr);
						 crSubGroupAmount = subGroupOPBalanceCr.add(subGroupYtdBalanceCr);
							if(drGroupAmount.compareTo(crGroupAmount)>0){
								accountSubGroup.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
								accountSubGroup.setClBalanceCr(new BigDecimal(0.00));
							}else if(crGroupAmount.compareTo(drGroupAmount)>0){
								accountSubGroup.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
								accountSubGroup.setClBalanceDr(new BigDecimal(0.00));
							}else if(crGroupAmount.compareTo(drGroupAmount)==0){
								accountSubGroup.setClBalanceCr(new BigDecimal(0.00));
								accountSubGroup.setClBalanceDr(new BigDecimal(0.00));
							}

					 	hbt.update(accountSubGroup);

			//-------------------------update account master-------------------------------------------------

						BigDecimal accountOpBalanceDr = new  BigDecimal(0.0);
				 		BigDecimal accountOpBalanceCr = new  BigDecimal(0.0);
				 		BigDecimal accountYtdBalanceDr = new BigDecimal(0.0);
				 		BigDecimal accountYtdBalanceCr = new  BigDecimal(0.0);
				 		BigDecimal drAccountAmount = new BigDecimal(0.0);
				 		BigDecimal crAccountAmount = new  BigDecimal(0.0);
				 		masAccount = (FaMasAccount)hbt.load(FaMasAccount.class,osAccountId);
				 		if(masAccount.getOpBalanceDr()!= null){
				 			accountOpBalanceDr =  masAccount.getOpBalanceDr();
				 		}
				 		if(masAccount.getOpBalanceCr()!= null){
				 			accountOpBalanceCr = masAccount.getOpBalanceCr();
				 		}

				 		 if(masAccount.getYtdAmountDr() != null){
				 			 accountYtdBalanceDr = masAccount.getYtdAmountDr();
				 		 }
				 		 if(masAccount.getYtdAmountCr() != null){
				 			accountYtdBalanceCr = masAccount.getYtdAmountCr();
				 		 }
				 		if(drAmt.compareTo(new BigDecimal(0))>0){
							 accountYtdBalanceDr = accountYtdBalanceDr.add(drAmt);
							 masAccount.setYtdAmountDr(accountYtdBalanceDr);
						 }
						 if(crAmt.compareTo(new BigDecimal(0))>0){
							 accountYtdBalanceCr = accountYtdBalanceCr.add(crAmt);
							 masAccount.setYtdAmountCr(accountYtdBalanceCr);
						 }
						 drAccountAmount = accountOpBalanceDr.add(accountYtdBalanceDr);
						 crAccountAmount = accountOpBalanceCr.add(accountYtdBalanceCr);
							if(drAccountAmount.compareTo(crAccountAmount)>0){
								masAccount.setClBalanceDr(drAccountAmount.subtract(crAccountAmount));
								masAccount.setClBalanceCr(new BigDecimal(0.00));
							}else if(crAccountAmount.compareTo(drAccountAmount)>0){
								masAccount.setClBalanceCr(crAccountAmount.subtract(drAccountAmount));
								masAccount.setClBalanceDr(new BigDecimal(0.00));
							}else if(crAccountAmount.compareTo(drAccountAmount)==0){
								masAccount.setClBalanceCr(new BigDecimal(0.00));
								masAccount.setClBalanceDr(new BigDecimal(0.00));
							}


						 hbt.update(masAccount);
		//------------------------------------------
						

						//-----------------------update account sub ledger==================================

						 if(osSubLedId !=0){
							 BigDecimal subLedgerOPBalanceCr = new BigDecimal(0.0);
							 BigDecimal subLedgerOPBalanceDr = new BigDecimal(0.0);
							 BigDecimal subLedgerYTDBalanceDr = new BigDecimal(0.0);
							 BigDecimal subLedgerYTDBalanceCr = new BigDecimal(0.0);
							 BigDecimal drAmountSubLedger = new BigDecimal(0.0);
							 BigDecimal crAmountSubLedger = new BigDecimal(0.0);

							 FaMasSubLed subLed= (FaMasSubLed)hbt.load(FaMasSubLed.class, osSubLedId);
							 if(subLed.getOpBalanceCr()!= null){
								 subLedgerOPBalanceCr =  subLed.getOpBalanceCr();
							 }
							 if(subLed.getOpBalanceDr()!= null){
								 subLedgerOPBalanceDr = subLed.getOpBalanceDr();
							 }

							if(subLed.getYtdAmountCr()!= null){
								subLedgerYTDBalanceCr = subLed.getYtdAmountCr();
							}
							if(subLed.getYtdAmountDr()!= null){
								subLedgerYTDBalanceDr = subLed.getYtdAmountDr();
							}
							if(drAmt.compareTo(new BigDecimal(0))>0){
								subLedgerYTDBalanceDr = subLedgerYTDBalanceDr.add(drAmt);
								subLed.setYtdAmountDr(subLedgerYTDBalanceDr);
							 }
							 if(crAmt.compareTo(new BigDecimal(0))>0){
								 subLedgerYTDBalanceCr = subLedgerYTDBalanceCr.add(crAmt);
								 subLed.setYtdAmountCr(subLedgerYTDBalanceCr);
							 }
							 crAmountSubLedger = subLedgerOPBalanceCr.add(subLedgerYTDBalanceCr);
							drAmountSubLedger = subLedgerOPBalanceDr.add(subLedgerYTDBalanceDr);

							if(drAmountSubLedger.compareTo(crAmountSubLedger)>0){
								subLed.setClBalanceDr(drAmountSubLedger.subtract(crAmountSubLedger));
								subLed.setClBalanceCr(new BigDecimal(0.00));
							}else if(crAmountSubLedger.compareTo(drAmountSubLedger)>0){
								subLed.setClBalanceCr(crAmountSubLedger.subtract(drAmountSubLedger));
								subLed.setClBalanceDr(new BigDecimal(0.00));
							}else if(crAmountSubLedger.compareTo(drAmountSubLedger)==0){
								subLed.setClBalanceCr(new BigDecimal(0.00));
								subLed.setClBalanceDr(new BigDecimal(0.00));
							}
								 hbt.update(subLed);
						 }	
					}
				}
		
		}
		}
			
//		}
			tx.commit();
			saved = true;

			} catch (RuntimeException e) {
					if (tx != null)
						tx.rollback();
					e.printStackTrace();
				}

				paramMap.put("suffix", box.getString("fYearDesc"));
				paramMap.put("flag", "display");
				paramMap.put("prefix", "RV");
				paramMap.put("voucherType", "Receipt");
				int voucherNo = generateVoucherNo(paramMap);
				map.put("voucherNo", voucherNo);
				map.put("saved", saved);
			return map;
	}
	@Override
	public Map<String, Object> postSrnMapping(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> paramMap = new HashMap<String, Object>();
	List<BlDispensingHeader> dispensingHeaderList = new ArrayList<BlDispensingHeader>();
	List<BlReceiptHeader> receiptHeaderList = new ArrayList<BlReceiptHeader>();
	List<FaAccountParameter> accountParameterList = new ArrayList<FaAccountParameter>();
	
	HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	Session session = (Session)getSession();
	Transaction tx = null;
	boolean saved = false;


	try {
		tx = session.beginTransaction();
		SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
		String fromDate4MySQL = "";
		String toDate4MySQL = "";
		int voucherNo = 0;
		try {
			fromDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(FROM_DATE)));
			 toDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(TO_DATE)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int purchaseAccountId = 0;int purchaseSubLedId = 0; int purchaseSubGroupId = 0; int purchaseGroupId = 0; 
		int disAccountId = 0; int disSubLedId = 0; int disSubGroupId = 0; int disGroupId = 0;
		int taxAccountId = 0; int taxSubLedId = 0; int taxSubGroupId = 0; int taxGroupId = 0;
		int salesAccountId = 0; int salesSubLedId = 0; int salesSubGroupId = 0; int salesGroupId = 0;
		
		
		accountParameterList = session.createCriteria(FaAccountParameter.class).add(Restrictions.eq("Status", "y")).list();
		if(accountParameterList.size()>0){
			for(FaAccountParameter accountParameter :accountParameterList){
				if(accountParameter.getAccountType().equals("Purchase")){
					if(accountParameter.getAccount() != null){
						purchaseAccountId = accountParameter.getAccount().getId();
						purchaseSubGroupId = accountParameter.getAccount().getAccountSubGroup().getId();
						purchaseGroupId = accountParameter.getAccount().getAccountSubGroup().getAccountGroup().getId();
					}
					if(accountParameter.getSubLed()!= null){
						purchaseSubLedId = accountParameter.getSubLed().getId();
					}
				}
				if(accountParameter.getAccountType().equals("Discount")){
					if(accountParameter.getAccount() != null){
						disAccountId = accountParameter.getAccount().getId();
						disSubGroupId = accountParameter.getAccount().getAccountSubGroup().getId();
						disGroupId = accountParameter.getAccount().getAccountSubGroup().getAccountGroup().getId();
					}
					if(accountParameter.getSubLed()!= null){
						disSubLedId = accountParameter.getSubLed().getId();
					}
				}
				if(accountParameter.getAccountType().equals("Credit Card")){
					if(accountParameter.getAccount() != null){
						taxAccountId = accountParameter.getAccount().getId();
						taxSubGroupId = accountParameter.getAccount().getAccountSubGroup().getId();
						taxGroupId = accountParameter.getAccount().getAccountSubGroup().getAccountGroup().getId();
					}
					if(accountParameter.getSubLed()!= null){
						taxSubLedId = accountParameter.getSubLed().getId();
					}
				}
			
				if(accountParameter.getAccountType().equals("Sales")){
					if(accountParameter.getAccount() != null){
						salesAccountId = accountParameter.getAccount().getId();
						salesSubGroupId = accountParameter.getAccount().getAccountSubGroup().getId();
						salesGroupId = accountParameter.getAccount().getAccountSubGroup().getAccountGroup().getId();
					}
					if(accountParameter.getSubLed()!= null){
						salesSubLedId = accountParameter.getSubLed().getId();
					}
				}
			}
		}
	
				
		
		int count =1;
			if(box.getInt("count") != 0){
				count = (Integer)box.getInt("count");
			}
			System.out.println("count=="+count);
		
 for (int j = 1; j < count; j++) {
	if(box.getString("voucherCnt"+j).equals("y")){
		FaVoucherHeader faVoucherHeader = new FaVoucherHeader();
		MasHospital masHospital = new MasHospital();
		masHospital.setId(box.getInt("locationId"));
		faVoucherHeader.setHospital(masHospital);
		faVoucherHeader.setVoucherDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
		faVoucherHeader.setVoucherTime(box.getString(CHANGED_TIME));
		faVoucherHeader.setNarration(box.getString(NARRATION));
		Users users = new Users();
		users.setId( box.getInt("changedBy"));
		faVoucherHeader.setLastChgBy(users);
		faVoucherHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
		faVoucherHeader.setLastChgTime(box.getString(CHANGED_TIME));
		faVoucherHeader.setVoucherType("PRV");
		faVoucherHeader.setStatus("y");
		BigDecimal totalAmountDr = new BigDecimal(0.0);
		BigDecimal totalAmountCr = new BigDecimal(0.0);
		
		if (!box.getString("drAmount"+j).equals("")) {
			totalAmountDr = new BigDecimal(box.getString("drAmount"+j));
			faVoucherHeader.setDrAmount(totalAmountDr);
		}
		if (!box.getString("crAmount"+j).equals("")) {
			totalAmountCr = new BigDecimal(box.getString("crAmount"+j));
			faVoucherHeader.setCrAmount(totalAmountCr);
		}
		MasStoreFinancial masStoreFinancial = new MasStoreFinancial();
		masStoreFinancial.setId(box.getInt("fYear"));
		faVoucherHeader.setFYear(masStoreFinancial);
		paramMap.put("suffix", box.getString("fYearDesc"));
		paramMap.put("flag", "save");
		paramMap.put("prefix", "PRV");
		paramMap.put("voucherType", "Purchase");
		paramMap.put("locationId", box.getInt("locationId"));
		 voucherNo = generateVoucherNo(paramMap);
		 String locationCode="";
			String yearDesc="";
			List<MasStoreFinancial>financialList=new ArrayList<MasStoreFinancial>();
			List<MasHospital>hospitalList=new ArrayList<MasHospital>();
			hospitalList=session.createCriteria(MasHospital.class).add(Restrictions.idEq(box.getInt("locationId"))).list();
			for(MasHospital mg:hospitalList){
				locationCode=mg.getHospitalCode();
			}
			financialList=session.createCriteria(MasStoreFinancial.class).add(Restrictions.idEq(box.getInt("fYear"))).list();
			for(MasStoreFinancial msf1:financialList){
				yearDesc=msf1.getYearDescription();
			}
			faVoucherHeader.setVoucherNo(locationCode+"/"+yearDesc+"/"+voucherNo);

		hbt.save(faVoucherHeader);
		map.put("voucherType", faVoucherHeader.getVoucherType());
//======================================
			/*	if(box.getInt("dispensingHeaderId"+j) != 0){
				BlDispensingHeader dispHeader = (BlDispensingHeader)hbt.load(BlDispensingHeader.class, box.getInt("dispensingHeaderId"+j));
				dispHeader.setVoucherNo(""+voucherNo);
				hbt.update(dispHeader);
			}
			if(box.getInt("receiptHeaderId"+j) != 0){
				BlReceiptHeader receiptHeader2= (BlReceiptHeader)hbt.load(BlReceiptHeader.class, box.getInt("receiptHeaderId"+j));
				receiptHeader2.setVoucherNo(""+voucherNo);
				hbt.update(receiptHeader2);
			}
		*/
	
		BigDecimal crAmt = new BigDecimal(0.00);
		BigDecimal drAmt = new BigDecimal(0.00);
 
	if(box.getString("purchaseAccountType"+j).equals("Purchase")  ){
		if(!box.getString("actualCost"+j).equals(0.00)){
			FaVoucherDetails voucherDetails = new FaVoucherDetails();
			FaMasAccount masAccount = new FaMasAccount();
			masAccount.setId(purchaseAccountId);
			voucherDetails.setAccount(masAccount);
			voucherDetails.setVoucherHeader(faVoucherHeader);
			if(purchaseSubLedId != 0){
				FaMasSubLed subLed= new FaMasSubLed();
				subLed.setId(purchaseSubLedId);
				voucherDetails.setSubLed(subLed);
			}
			System.out.println("drAmt==="+new BigDecimal(box.getString("actualCost"+j)));
			drAmt = new BigDecimal(box.getString("actualCost"+j));
			voucherDetails.setDrAmount(drAmt);
			voucherDetails.setCrAmount(new BigDecimal(0));
			hbt.save(voucherDetails);
			}
		}
	
	if(box.getString("taxAccountType"+j).equals("Tax")  ){
		if(!box.getString("tax"+j).equals(0.00)){
			FaVoucherDetails voucherDetails = new FaVoucherDetails();
			FaMasAccount masAccount = new FaMasAccount();
			masAccount.setId(taxAccountId);
			voucherDetails.setAccount(masAccount);
			voucherDetails.setVoucherHeader(faVoucherHeader);
			if(purchaseSubLedId != 0){
				FaMasSubLed subLed= new FaMasSubLed();
				subLed.setId(purchaseSubLedId);
				voucherDetails.setSubLed(subLed);
			}
			System.out.println("drAmt==="+new BigDecimal(box.getString("tax"+j)));
			drAmt = new BigDecimal(box.getString("tax"+j));
			voucherDetails.setDrAmount(drAmt);
			voucherDetails.setCrAmount(new BigDecimal(0));
			hbt.save(voucherDetails);
			}
		}
	if(box.getString("discountAccountType"+j).equals("Discount")  ){
		if(!box.getString("discount"+j).equals(0.00)){
			FaVoucherDetails voucherDetails = new FaVoucherDetails();
			FaMasAccount masAccount = new FaMasAccount();
			masAccount.setId(disAccountId);
			voucherDetails.setAccount(masAccount);
			voucherDetails.setVoucherHeader(faVoucherHeader);
			if(purchaseSubLedId != 0){
				FaMasSubLed subLed= new FaMasSubLed();
				subLed.setId(purchaseSubLedId);
				voucherDetails.setSubLed(subLed);
			}
			System.out.println("crAmt==="+new BigDecimal(box.getString("discount"+j)));
			crAmt = new BigDecimal(box.getString("discount"+j));
			voucherDetails.setCrAmount(crAmt);
			voucherDetails.setDrAmount(new BigDecimal(0));
			hbt.save(voucherDetails);
			}
		}
	
	if(box.getString("salesAccountType"+j).equals("Sales")  ){
		if(!box.getString("total_amt"+j).equals(0.00)){
			FaVoucherDetails voucherDetails = new FaVoucherDetails();
			FaMasAccount masAccount = new FaMasAccount();
			masAccount.setId(disAccountId);
			voucherDetails.setAccount(masAccount);
			voucherDetails.setVoucherHeader(faVoucherHeader);
			if(purchaseSubLedId != 0){
				FaMasSubLed subLed= new FaMasSubLed();
				subLed.setId(purchaseSubLedId);
				voucherDetails.setSubLed(subLed);
			}
			System.out.println("crAmt==="+new BigDecimal(box.getString("total_amt"+j)));
			crAmt = new BigDecimal(box.getString("total_amt"+j));
			voucherDetails.setCrAmount(crAmt);
			voucherDetails.setDrAmount(new BigDecimal(0));
			hbt.save(voucherDetails);
			}
		}
	}
		
	}
		tx.commit();
		saved = true;

		} catch (RuntimeException e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			}

			paramMap.put("suffix", box.getString("fYearDesc"));
			paramMap.put("flag", "display");
			paramMap.put("prefix", "PRV");
			paramMap.put("voucherType", "Purchase");
			int voucherNo = generateVoucherNo(paramMap);
			map.put("voucherNo", voucherNo);
			map.put("saved", saved);
		return map;
	}
	@Override
	public Map<String, Object> postPayrollVoucherMapping(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> paramMap = new HashMap<String, Object>();
	List<BlDispensingHeader> dispensingHeaderList = new ArrayList<BlDispensingHeader>();
	List<BlReceiptHeader> receiptHeaderList = new ArrayList<BlReceiptHeader>();
	List<FaAccountParameter> accountParameterList = new ArrayList<FaAccountParameter>();
	
	HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	Session session = (Session)getSession();
	Transaction tx = null;
	boolean saved = false;
	try {
		tx = session.beginTransaction();
		int voucherNo = 0;
		/*SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
		String fromDate4MySQL = "";
		String toDate4MySQL = "";
		try {
			fromDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(FROM_DATE)));
			 toDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(TO_DATE)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		int purchaseAccountId = 0;int purchaseSubLedId = 0; int purchaseSubGroupId = 0; int purchaseGroupId = 0; 
		int cashAccountId = 0; int cashSubLedId = 0; int cashSubGroupId = 0; int cashGroupId = 0;
		int bankAccountId = 0; int bankSubLedId = 0; int bankSubGroupId = 0; int bankGroupId = 0;
		accountParameterList = session.createCriteria(FaAccountParameter.class).add(Restrictions.eq("Status", "y")).list();
		if(accountParameterList.size()>0){
			for(FaAccountParameter accountParameter :accountParameterList){
				if(accountParameter.getAccountType().equals("Purchase")){
					if(accountParameter.getAccount() != null){
						purchaseAccountId = accountParameter.getAccount().getId();
						purchaseSubGroupId = accountParameter.getAccount().getAccountSubGroup().getId();
						purchaseGroupId = accountParameter.getAccount().getAccountSubGroup().getAccountGroup().getId();
					}
					if(accountParameter.getSubLed()!= null){
						purchaseSubLedId = accountParameter.getSubLed().getId();
					}
				}
				if(accountParameter.getAccountType().equals("Bank")){
					if(accountParameter.getAccount() != null){
						bankAccountId = accountParameter.getAccount().getId();
						bankSubGroupId = accountParameter.getAccount().getAccountSubGroup().getId();
						bankGroupId = accountParameter.getAccount().getAccountSubGroup().getAccountGroup().getId();
					}
					if(accountParameter.getSubLed()!= null){
						bankSubLedId = accountParameter.getSubLed().getId();
					}
				}
				if(accountParameter.getAccountType().equals("Cash")){
					if(accountParameter.getAccount() != null){
						cashAccountId = accountParameter.getAccount().getId();
						cashSubGroupId = accountParameter.getAccount().getAccountSubGroup().getId();
						cashGroupId = accountParameter.getAccount().getAccountSubGroup().getAccountGroup().getId();
					}
					if(accountParameter.getSubLed()!= null){
						cashSubLedId = accountParameter.getSubLed().getId();
					}
				}
			}
		}
		FaVoucherHeader faVoucherHeader = new FaVoucherHeader();
		MasHospital masHospital = new MasHospital();
		masHospital.setId(box.getInt("locationId"));
		faVoucherHeader.setHospital(masHospital);
		faVoucherHeader.setVoucherDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
		faVoucherHeader.setVoucherTime(box.getString(CHANGED_TIME));
		faVoucherHeader.setNarration(box.getString(NARRATION));
		Users users = new Users();
		users.setId( box.getInt("changedBy"));
		faVoucherHeader.setLastChgBy(users);
		faVoucherHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
		faVoucherHeader.setLastChgTime(box.getString(CHANGED_TIME));
		faVoucherHeader.setVoucherType("PRV");
		faVoucherHeader.setStatus("y");
		BigDecimal totalAmountDr = new BigDecimal(0.0);
		BigDecimal totalAmountCr = new BigDecimal(0.0);
		
		if (!box.getString("drAmount").equals("")) {
			totalAmountDr = new BigDecimal(box.getString("drAmount"));
			faVoucherHeader.setDrAmount(totalAmountDr);
		}
		if (!box.getString("crAmount").equals("")) {
			totalAmountCr = new BigDecimal(box.getString("crAmount"));
			faVoucherHeader.setCrAmount(totalAmountCr);
		}
		MasStoreFinancial masStoreFinancial = new MasStoreFinancial();
		masStoreFinancial.setId(box.getInt("fYear"));
		faVoucherHeader.setFYear(masStoreFinancial);
		paramMap.put("suffix", box.getString("fYearDesc"));
		paramMap.put("flag", "save");
		paramMap.put("prefix", "PRV");
		paramMap.put("voucherType", "Purchase");
		paramMap.put("locationId", box.getInt("locationId"));
		 voucherNo = generateVoucherNo(paramMap);
		 String locationCode="";
			String yearDesc="";
			List<MasStoreFinancial>financialList=new ArrayList<MasStoreFinancial>();
			List<MasHospital>hospitalList=new ArrayList<MasHospital>();
			hospitalList=session.createCriteria(MasHospital.class).add(Restrictions.idEq(box.getInt("locationId"))).list();
			for(MasHospital mg:hospitalList){
				locationCode=mg.getHospitalCode();
			}
			financialList=session.createCriteria(MasStoreFinancial.class).add(Restrictions.idEq(box.getInt("fYear"))).list();
			for(MasStoreFinancial msf1:financialList){
				yearDesc=msf1.getYearDescription();
			}
			faVoucherHeader.setVoucherNo(locationCode+"/"+yearDesc+"/"+voucherNo);

		hbt.save(faVoucherHeader);
		map.put("voucherType", faVoucherHeader.getVoucherType());
//======================================
			/*	if(box.getInt("dispensingHeaderId"+j) != 0){
				BlDispensingHeader dispHeader = (BlDispensingHeader)hbt.load(BlDispensingHeader.class, box.getInt("dispensingHeaderId"+j));
				dispHeader.setVoucherNo(""+voucherNo);
				hbt.update(dispHeader);
			}
			if(box.getInt("receiptHeaderId"+j) != 0){
				BlReceiptHeader receiptHeader2= (BlReceiptHeader)hbt.load(BlReceiptHeader.class, box.getInt("receiptHeaderId"+j));
				receiptHeader2.setVoucherNo(""+voucherNo);
				hbt.update(receiptHeader2);
			}
		*/
	
		BigDecimal crAmt = new BigDecimal(0.00);
		BigDecimal drAmt = new BigDecimal(0.00);
 
	if(box.getString("purchaseAccountType").equals("Purchase")  ){
		if(!box.getString("netSalary").equals(0.00)){
			FaVoucherDetails voucherDetails = new FaVoucherDetails();
			FaMasAccount masAccount = new FaMasAccount();
			masAccount.setId(purchaseAccountId);
			voucherDetails.setAccount(masAccount);
			voucherDetails.setVoucherHeader(faVoucherHeader);
			if(purchaseSubLedId != 0){
				FaMasSubLed subLed= new FaMasSubLed();
				subLed.setId(purchaseSubLedId);
				voucherDetails.setSubLed(subLed);
			}
			System.out.println("drAmt==="+new BigDecimal(box.getString("netSalary")));
			drAmt = new BigDecimal(box.getString("netSalary"));
			voucherDetails.setDrAmount(drAmt);
			voucherDetails.setCrAmount(new BigDecimal(0));
			hbt.save(voucherDetails);
			}
		}
	
	if(box.getString("cashAccountType").equals("Cash")  ){
		if(!box.getString("cash").equals(0.00)){
			FaVoucherDetails voucherDetails = new FaVoucherDetails();
			FaMasAccount masAccount = new FaMasAccount();
			masAccount.setId(cashAccountId);
			voucherDetails.setAccount(masAccount);
			voucherDetails.setVoucherHeader(faVoucherHeader);
			if(purchaseSubLedId != 0){
				FaMasSubLed subLed= new FaMasSubLed();
				subLed.setId(purchaseSubLedId);
				voucherDetails.setSubLed(subLed);
			}
			System.out.println("drAmt==="+new BigDecimal(box.getString("cash")));
			crAmt = new BigDecimal(box.getString("cash"));
			voucherDetails.setCrAmount(crAmt);
			voucherDetails.setDrAmount(new BigDecimal(0));
			hbt.save(voucherDetails);
			}
		}
	if(box.getString("bankAccountType").equals("Bank")  ){
		if(!box.getString("bank").equals(0.00)){
			FaVoucherDetails voucherDetails = new FaVoucherDetails();
			FaMasAccount masAccount = new FaMasAccount();
			masAccount.setId(bankAccountId);
			voucherDetails.setAccount(masAccount);
			voucherDetails.setVoucherHeader(faVoucherHeader);
			if(purchaseSubLedId != 0){
				FaMasSubLed subLed= new FaMasSubLed();
				subLed.setId(purchaseSubLedId);
				voucherDetails.setSubLed(subLed);
			}
			System.out.println("crAmt==="+new BigDecimal(box.getString("bank")));
			crAmt = new BigDecimal(box.getString("bank"));
			voucherDetails.setCrAmount(crAmt);
			voucherDetails.setDrAmount(new BigDecimal(0));
			hbt.save(voucherDetails);
			}
		}
		tx.commit();
		saved = true;

		} catch (RuntimeException e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			}

			paramMap.put("suffix", box.getString("fYearDesc"));
			paramMap.put("flag", "display");
			paramMap.put("prefix", "PV");
			paramMap.put("voucherType", "Purchase");
			int voucherNo = generateVoucherNo(paramMap);
			map.put("voucherNo", voucherNo);
			map.put("saved", saved);
		return map;
	}
	@Override
	public Map<String, Object> showHrInsuranceDetailsJsp(
			Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasInsurance> hrMasInsuranceList = new ArrayList<HrMasInsurance>();
		List<HrInsuranceDetails> searchHrInsuranceDetailsList = new ArrayList<HrInsuranceDetails>();
		Session session = (Session)getSession();
		int locationId = 0;
		if(generalMap.get("locationId") != null){
			locationId = (Integer)generalMap.get("locationId");
		}
		searchHrInsuranceDetailsList = session.createCriteria(HrInsuranceDetails.class).add(Restrictions.eq("Location.Id", locationId))
				//.add(Restrictions.eq("Status", "y"))
									.list();
		
		hrMasInsuranceList = session.createCriteria(HrMasInsurance.class).add(Restrictions.eq("Status", "y"))
									//.add(Restrictions.eq("Company.Id", locationId))
				.list();
		
		map.put("hrMasInsuranceList", hrMasInsuranceList);
		map.put("searchHrInsuranceDetailsList", searchHrInsuranceDetailsList);
		return map;
	}

	@Override
	public Map<String, Object> searchHrInsuranceDetailsJsp(
			String insuranceDetailsName) {
		List<HrInsuranceDetails> searchHrInsuranceDetailsList = new ArrayList<HrInsuranceDetails>();
		Map<String, Object> insuranceFieldsMap = new HashMap<String, Object>();
		
		Session session  = (Session)getSession();
		try {
			if ((insuranceDetailsName != null)) {
				searchHrInsuranceDetailsList = session.createCriteria(HrInsuranceDetails.class).add(Restrictions.like("InsuranceName", "%"+insuranceDetailsName+"%").ignoreCase()).addOrder(Order.asc("InsuranceName")).list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<HrMasInsurance> hrMasInsuranceList = new ArrayList<HrMasInsurance>();
		hrMasInsuranceList = session.createCriteria(HrMasInsurance.class).add(Restrictions.eq("Status", "y"))
									//.add(Restrictions.eq("Company.Id", locationId))
									.list();
		insuranceFieldsMap.put("hrMasInsuranceList", hrMasInsuranceList);
		insuranceFieldsMap.put("searchHrInsuranceDetailsList", searchHrInsuranceDetailsList);
		return insuranceFieldsMap;
	}
	
	
	public boolean addHrInsuranceDetails(HrInsuranceDetails hrInsuranceDetails) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(hrInsuranceDetails);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteHrInsuranceDetails(int insuranceDetailsId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int userId = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		HrInsuranceDetails hrInsuranceDetails = new HrInsuranceDetails();
		hrInsuranceDetails = (HrInsuranceDetails) getHibernateTemplate().load(HrInsuranceDetails.class, insuranceDetailsId);
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				hrInsuranceDetails.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				hrInsuranceDetails.setStatus("y");
				dataDeleted = false;
			}
		}
		Users user = new Users();
		user.setId(userId);
		hrInsuranceDetails.setLastChgBy(user);
		hrInsuranceDetails.setLastChgDate(currentDate);
		//hrInsuranceDetails.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(hrInsuranceDetails);
		return dataDeleted;
	}

	public boolean editHrInsuranceDetailsToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String insuranceDetailsName = "";
		String discription = "";
		int insuranceDetailsId = 0;
		String cover = "";
		Date detailsDate=null;
		Date nextPremiumDate=null;
		int userId = 0;
		BigDecimal amount = new BigDecimal(0.0);
		BigDecimal premium = new BigDecimal(0.0);
		insuranceDetailsId = (Integer) generalMap.get("id");
		discription = (String) generalMap.get("discription");
		premium = (BigDecimal) generalMap.get("premium");
		amount = (BigDecimal) generalMap.get("amount");
		insuranceDetailsName = (String) generalMap.get("name");
		cover = (String) generalMap.get("cover");
		detailsDate = (Date) generalMap.get("detailsDate");
		nextPremiumDate = (Date) generalMap.get("nextPremiumDate");
		
		userId = (Integer) generalMap.get("userId");
		int insuranceTypeId=0;
		insuranceTypeId = (Integer) generalMap.get("insuranceTypeId");
		
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		HrInsuranceDetails hrInsuranceDetails = (HrInsuranceDetails) getHibernateTemplate().load(HrInsuranceDetails.class,insuranceDetailsId);

		hrInsuranceDetails.setId(insuranceDetailsId);
		hrInsuranceDetails.setDiscription(discription);
		hrInsuranceDetails.setCover(cover);
		hrInsuranceDetails.setInsuranceName(insuranceDetailsName);
		hrInsuranceDetails.setDate(detailsDate);
		hrInsuranceDetails.setNextPremiumDate(nextPremiumDate);
		hrInsuranceDetails.setAmount(amount);
		hrInsuranceDetails.setPremium(premium);
		
		
		HrMasInsurance insuranceType = new HrMasInsurance();
		insuranceType.setId(insuranceTypeId);
		hrInsuranceDetails.setInsuranceType(insuranceType);
		
		Users user = new Users();
		user.setId(userId);
		hrInsuranceDetails.setLastChgBy(user);
		hrInsuranceDetails.setLastChgDate(currentDate);
		//hrInsuranceDetails.setStatus("y");
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(hrInsuranceDetails);
		dataUpdated = true;
		return dataUpdated;
	}
	@Override
	public Map<String, Object> displayProductionJournalVoucherMapping(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<ProdGrowerPayment> growerPaymentList = new ArrayList<ProdGrowerPayment>();
	List<MasStoreRate> rateList = new ArrayList<MasStoreRate>();
	List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
	List<FaMasSubLed> subLedList = new ArrayList<FaMasSubLed>();
	List<FaMasSubLed> growerSubLedList = new ArrayList<FaMasSubLed>();
	Session session = (Session)getSession();
	
	String fromDate4MySQL = box.getString(FROM_DATE);
	String toDate4MySQL = box.getString(TO_DATE);
		
	int locationId = box.getInt("locationId");	
	 Criteria cr = null;

	cr = session.createCriteria(ProdGrowerPayment.class).add(Restrictions.isNull("VoucherNo"))
			.createAlias("SeedQuality", "dg")			
			.createAlias("dg.Location", "location").add(Restrictions.eq("location.Id", locationId));
	
	if ((fromDate4MySQL != null) && (toDate4MySQL != null) && (!toDate4MySQL.equals("")) && (!fromDate4MySQL.equals(""))) {
	      cr = cr.add(Restrictions.between("ReceiptDate", HMSUtil.convertStringTypeDateToDateType(fromDate4MySQL), HMSUtil.convertStringTypeDateToDateType(toDate4MySQL)));
	    }
	
	growerPaymentList = cr.list();
	
	
	
	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader()
			.getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	 int purAdvGrowerId=0;
	 int growerAccId=0;
	 int subGroupId = 0;
	 int purchaseAccountId = 0;
	 
	 purAdvGrowerId = Integer.parseInt(properties.getProperty("PUR_ADV_GROWER_ID").trim());
	 growerAccId	= Integer.parseInt(properties.getProperty("GROWER_ACCOUNT_ID").trim());
	 purchaseAccountId	= Integer.parseInt(properties.getProperty("PURCHASE_ACCOUNT_ID").trim());
	 subGroupId = Integer.parseInt(properties.getProperty("subGroupId"));
	 
	
	
	accountList=session.createCriteria(FaMasAccount.class)
			.createAlias("AccountSubGroup", "asg")
			.add(Restrictions.eq("asg.Id", subGroupId)).list();
	
	subLedList=session.createCriteria(FaMasSubLed.class)
			.createAlias("Account", "acc")
			.createAlias("Hospital", "location")
			.add(Restrictions.eq("acc.Id", purchaseAccountId))
			.add(Restrictions.eq("location.Id", locationId)).list();
	
	
	map.put("growerPaymentList",growerPaymentList);
	map.put("accountList",accountList);
	map.put("subLedList",subLedList);
	map.put("growerAccId",growerAccId);
	map.put("purAdvGrowerId",purAdvGrowerId);
	
	return map;
	}
	
	@Override
	public Map<String, Object> displayMarketingMapping(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BigDecimal> marketingMappingList = new ArrayList<BigDecimal>();
		Session session = (Session)getSession();
		SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
		int locationId = box.getInt("locationId");
		/*String fromDate4MySQL = "";
		String toDate4MySQL = "";
		try {
			fromDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(FROM_DATE)));
			 toDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(TO_DATE)));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}*/
		marketingMappingList = session.createCriteria(SalesPromotionActivityDetails.class)
				                    .createAlias("Details", "spd").createAlias("spd.Header", "sph")
									.add(Restrictions.eq("sph.Location.Id", locationId))
									.add(Restrictions.between("Date", HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE)), HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE))))
									.add(Restrictions.isNull("VoucherNo"))
									.setProjection(Projections.projectionList().add(Projections.sum("Amount"))
											).list();
		
		map.put("marketingMappingList", marketingMappingList);
		map.put("fromDate",HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE)));
		map.put("toDate",HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE)));
		return map;
		}
	@Override
	public Map<String, Object> showMarketingSubLedgerPopupJsp(
			Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<SalesPromotionActivityDetails> activitiesList = new ArrayList<SalesPromotionActivityDetails>();
		Session session = (Session)getSession();
		Date fromDate = null;
		Date toDate = null;
		if(generalMap.get("fromDate")!= null){
			fromDate = (Date)generalMap.get("fromDate");
		}
		if(generalMap.get("toDate")!= null){
			toDate = (Date)generalMap.get("toDate");
		}
		
		activitiesList = session.createCriteria(SalesPromotionActivityDetails.class)
							.add(Restrictions.between("Date", fromDate, toDate))
							.list();
		map.put("activitiesList", activitiesList);
		return map;
	}

	
	@Override
	public Map<String, Object> generateExcelProfitAndLossAccountJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<AccountMainTransac> currentFinancialYearAccountList = new ArrayList<AccountMainTransac>();
		List<AccountMainTransac> lastFinancialYearAccountList = new ArrayList<AccountMainTransac>();
		List<MasStoreFinancial> financialYearList = new ArrayList<MasStoreFinancial>();
		List<MasStoreFinancial> lastFinancialYearList = new ArrayList<MasStoreFinancial>();
		Session session = (Session)getSession();
		Criteria cr = null;
		
		 String BalanceSheetType= "";
		 BalanceSheetType= box.getString("BalanceSheetType");
		 
		cr = session.createCriteria(AccountMainTransac.class);
		if(!BalanceSheetType.equalsIgnoreCase("ALL"))
		{
			cr= cr.add(Restrictions.eq("Location.Id", box.getInt("locationId")));
		}
		
		cr= cr.add(Restrictions.eq("FinancialYear.Id", box.getInt("fYear")));
		currentFinancialYearAccountList = cr.list();
		
		
		financialYearList = session.createCriteria(MasStoreFinancial.class).add(Restrictions.idEq(box.getInt("fYear"))).list();
		int lastFinancialYearId = 0;
		String lastYearDesc = "";
		String currentYearDesc = "";
		if(financialYearList.size()>0){
			currentYearDesc = financialYearList.get(0).getYearDescription();
			lastYearDesc = ""+(Integer.parseInt(currentYearDesc)-1);
			lastFinancialYearList = session.createCriteria(MasStoreFinancial.class).add(Restrictions.eq("YearDescription", lastYearDesc)).list();
			lastFinancialYearId = lastFinancialYearList.get(0).getId();
		}
		
		cr = session.createCriteria(AccountMainTransac.class);
		if(!BalanceSheetType.equalsIgnoreCase("ALL"))
		{
			cr= cr.add(Restrictions.eq("Location.Id", box.getInt("locationId")));
		}
		
		cr= cr.add(Restrictions.eq("FinancialYear.Id", lastFinancialYearId));
		lastFinancialYearAccountList = cr.list();
		
		
		
		
		map.put("currentFinancialYearAccountList", currentFinancialYearAccountList);
		map.put("lastFinancialYearAccountList", lastFinancialYearAccountList);
		map.put("currentYearDesc", Integer.parseInt(currentYearDesc)+1);
		map.put("lastYearDesc", Integer.parseInt(lastYearDesc)+1);
		
		if (currentFinancialYearAccountList.size() > 0)
			map.put("sucFlag", true);
		else
			map.put("sucFlag", false);
	
		
		return map;
	}
	
	@Override
	public Map<String, Object> generateBalanceSheetJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<AccountMainTransac> currentFinancialYearAccountList = new ArrayList<AccountMainTransac>();
		List<AccountMainTransac> lastFinancialYearAccountList = new ArrayList<AccountMainTransac>();
		List<MasStoreFinancial> financialYearList = new ArrayList<MasStoreFinancial>();
		List<MasStoreFinancial> lastFinancialYearList = new ArrayList<MasStoreFinancial>();
		Session session = (Session)getSession();
		Criteria cr = null;
		
		String BalanceSheetType= "";
		 BalanceSheetType= box.getString("BalanceSheetType");
		 
		cr = session.createCriteria(AccountMainTransac.class);
		if(!BalanceSheetType.equalsIgnoreCase("ALL"))
		{
			cr= cr.add(Restrictions.eq("Location.Id", box.getInt("locationId")));
		}
		
		cr= cr.add(Restrictions.eq("FinancialYear.Id", box.getInt("fYear")));
		currentFinancialYearAccountList= cr.list();
		
		financialYearList = session.createCriteria(MasStoreFinancial.class).add(Restrictions.idEq(box.getInt("fYear"))).list();
		int lastFinancialYearId = 0;
		String lastYearDesc = "";
		String currentYearDesc = "";
		if(financialYearList.size()>0){
			currentYearDesc = financialYearList.get(0).getYearDescription();
			lastYearDesc = ""+(Integer.parseInt(currentYearDesc)-1);
			lastFinancialYearList = session.createCriteria(MasStoreFinancial.class).add(Restrictions.eq("YearDescription", lastYearDesc)).list();
			lastFinancialYearId = lastFinancialYearList.get(0).getId();
		}
		
		cr = session.createCriteria(AccountMainTransac.class);
		if(!BalanceSheetType.equalsIgnoreCase("ALL"))
		{
			cr= cr.add(Restrictions.eq("Location.Id", box.getInt("locationId")));
		}
		
		cr= cr.add(Restrictions.eq("FinancialYear.Id", lastFinancialYearId));
		lastFinancialYearAccountList= cr.list();
		
		
		
		map.put("currentFinancialYearAccountList", currentFinancialYearAccountList);
		map.put("lastFinancialYearAccountList", lastFinancialYearAccountList);
		map.put("currentYearDesc", Integer.parseInt(currentYearDesc)+1);
		map.put("lastYearDesc", Integer.parseInt(lastYearDesc)+1);
		
		if (currentFinancialYearAccountList.size() > 0)
			map.put("sucFlag", true);
		else
			map.put("sucFlag", false);
	
		return map;
	}
	@Override
	public Map<String, Object> displayShareAllotmentMapping(Box box) {
		Map<String,Object> map = new HashMap<String, Object>();
		List<BigDecimal> shareAllotmentMappingList = new ArrayList<BigDecimal>();
		Session session = (Session)getSession();
		SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
		String fromDate4MySQL = "";
		String toDate4MySQL = "";
		try {
			fromDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(FROM_DATE)));
			 toDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(TO_DATE)));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		String shareAllotmentQueryString = "SELECT sum(application_value) FROM lgl_share_allotment " +
								" where date_of_allotment between   '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and voucher_no is null";
		
		shareAllotmentMappingList = session.createSQLQuery(shareAllotmentQueryString).list();
		map.put("shareAllotmentMappingList",shareAllotmentMappingList);
		map.put("fromDate",HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE)));
		map.put("toDate",HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE)));
		return map;
	}
	@Override
	public Map<String, Object> displayShareAllotmentAdjustment(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<Object[]> shareAllotmentAdjustmentMappingList = new ArrayList<Object[]>();
	Session session = (Session)getSession();
	SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
	String fromDate4MySQL = "";
	String toDate4MySQL = "";
	try {
		fromDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(FROM_DATE)));
		 toDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(TO_DATE)));
	} catch (ParseException e) {
		
		e.printStackTrace();
	}
	String shareAllotmentQueryString = "SELECT sum(allotment.allotment_value),sum(application.application_value) " +
											" FROM lgl_share_allotment allotment left join lgl_share_application application " +
											" on application.application_id = allotment.application_id where date_of_allotment  between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"'";
	
	shareAllotmentAdjustmentMappingList = session.createSQLQuery(shareAllotmentQueryString).list();
	map.put("shareAllotmentAdjustmentMappingList",shareAllotmentAdjustmentMappingList);
		return map;
	}
	@Override
	public Map<String, Object> displayAllotmentReceiptVoucher(Box box) {
		Map<String,Object> map = new HashMap<String, Object>();
		List<BigDecimal> shareAllotmentMappingList = new ArrayList<BigDecimal>();
		Session session = (Session)getSession();
		SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
		String fromDate4MySQL = "";
		String toDate4MySQL = "";
		try {
			fromDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(FROM_DATE)));
			 toDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(TO_DATE)));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		String shareAllotmentQueryString = "SELECT sum(allotment_value) FROM lgl_share_allotment " +
								" where date_of_allotment between   '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"'";
		
		shareAllotmentMappingList = session.createSQLQuery(shareAllotmentQueryString).list();
		map.put("shareAllotmentMappingList",shareAllotmentMappingList);
		return map;
	}
	@Override
	public Map<String, Object> postMarketingMapping(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<FaAccountParameter> accountParameterList = new ArrayList<FaAccountParameter>();
		List<SalesPromotionActivityDetails> activiitesList = new ArrayList<SalesPromotionActivityDetails>();
		
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session)getSession();
		Transaction tx = null;
		boolean saved = false;
		try {
			tx = session.beginTransaction();
			int voucherNo = 0;
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			String fromDate4MySQL = "";
			String toDate4MySQL = "";
			try {
				fromDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(FROM_DATE)));
				 toDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(TO_DATE)));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int sundryDebitorsAccountId = 0;int sundryDebitorsSubLedId = 0; int sundryDebitorsSubGroupId = 0; int sundryDebitorsGroupId = 0; 
			int cashAccountId = 0; int cashSubLedId = 0; int cashSubGroupId = 0; int cashGroupId = 0;
			//int bankAccountId = 0; int bankSubLedId = 0; int bankSubGroupId = 0; int bankGroupId = 0;
			accountParameterList = session.createCriteria(FaAccountParameter.class).add(Restrictions.eq("Status", "y")).list();
			if(accountParameterList.size()>0){
				for(FaAccountParameter accountParameter :accountParameterList){
					if(accountParameter.getAccountType().equals("Promotional Activities")){
						if(accountParameter.getAccount() != null){
							sundryDebitorsAccountId = accountParameter.getAccount().getId();
							sundryDebitorsSubGroupId = accountParameter.getAccount().getAccountSubGroup().getId();
							sundryDebitorsGroupId = accountParameter.getAccount().getAccountSubGroup().getAccountGroup().getId();
						}
						if(accountParameter.getSubLed()!= null){
							sundryDebitorsSubLedId = accountParameter.getSubLed().getId();
						}
					}
					/*if(accountParameter.getAccountType().equals("Bank")){
						if(accountParameter.getAccount() != null){
							bankAccountId = accountParameter.getAccount().getId();
							bankSubGroupId = accountParameter.getAccount().getAccountSubGroup().getId();
							bankGroupId = accountParameter.getAccount().getAccountSubGroup().getAccountGroup().getId();
						}
						if(accountParameter.getSubLed()!= null){
							bankSubLedId = accountParameter.getSubLed().getId();
						}
					}*/
					if(accountParameter.getAccountType().equals("Cash")){
						if(accountParameter.getAccount() != null){
							cashAccountId = accountParameter.getAccount().getId();
							cashSubGroupId = accountParameter.getAccount().getAccountSubGroup().getId();
							cashGroupId = accountParameter.getAccount().getAccountSubGroup().getAccountGroup().getId();
						}
						if(accountParameter.getSubLed()!= null){
							cashSubLedId = accountParameter.getSubLed().getId();
						}
					}
				}
			}
			FaVoucherHeader faVoucherHeader = new FaVoucherHeader();
			MasHospital masHospital = new MasHospital();
			masHospital.setId(box.getInt("locationId"));
			faVoucherHeader.setHospital(masHospital);
			faVoucherHeader.setVoucherDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			faVoucherHeader.setVoucherTime(box.getString(CHANGED_TIME));
			faVoucherHeader.setNarration(box.getString(NARRATION));
			Users users = new Users();
			users.setId( box.getInt("changedBy"));
			faVoucherHeader.setLastChgBy(users);
			faVoucherHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			faVoucherHeader.setLastChgTime(box.getString(CHANGED_TIME));
			faVoucherHeader.setVoucherType("PV");
			faVoucherHeader.setStatus("y");
			BigDecimal totalAmountDr = new BigDecimal(0.0);
			BigDecimal totalAmountCr = new BigDecimal(0.0);
			
			if (!box.getString("drAmount").equals("")) {
				totalAmountDr = new BigDecimal(box.getString("drAmount"));
				faVoucherHeader.setDrAmount(totalAmountDr);
			}
			if (!box.getString("crAmount").equals("")) {
				totalAmountCr = new BigDecimal(box.getString("crAmount"));
				faVoucherHeader.setCrAmount(totalAmountCr);
			}
			MasStoreFinancial masStoreFinancial = new MasStoreFinancial();
			masStoreFinancial.setId(box.getInt("fYear"));
			faVoucherHeader.setFYear(masStoreFinancial);
			paramMap.put("suffix", box.getString("fYearDesc"));
			paramMap.put("flag", "save");
			paramMap.put("prefix", "PV");
			paramMap.put("voucherType", "Payment");
			paramMap.put("locationId", box.getInt("locationId"));
			 voucherNo = generateVoucherNo(paramMap);
			 String locationCode="";
				String yearDesc="";
				List<MasStoreFinancial>financialList=new ArrayList<MasStoreFinancial>();
				List<MasHospital>hospitalList=new ArrayList<MasHospital>();
				hospitalList=session.createCriteria(MasHospital.class).add(Restrictions.idEq(box.getInt("locationId"))).list();
				for(MasHospital mg:hospitalList){
					locationCode=mg.getHospitalCode();
				}
				financialList=session.createCriteria(MasStoreFinancial.class).add(Restrictions.idEq(box.getInt("fYear"))).list();
				for(MasStoreFinancial msf1:financialList){
					yearDesc=msf1.getYearDescription();
				}
				faVoucherHeader.setVoucherNo(locationCode+"/"+yearDesc+"/"+voucherNo);

			hbt.save(faVoucherHeader);
			map.put("voucherType", faVoucherHeader.getVoucherType());
	//======================================
			activiitesList = session.createCriteria(SalesPromotionActivityDetails.class).add(Restrictions.between("ActualCompletionDate", java.sql.Date.valueOf(fromDate4MySQL), java.sql.Date.valueOf(toDate4MySQL)))
								.add(Restrictions.isNull("VoucherNo")).list();
			if(activiitesList.size()>0){
				for(SalesPromotionActivityDetails promotionActivityDetails: activiitesList){
					int activityId = promotionActivityDetails.getId();
					SalesPromotionActivityDetails activityDetails = (SalesPromotionActivityDetails)hbt.load(SalesPromotionActivityDetails.class, activityId);
					activityDetails.setVoucherNo(""+voucherNo);
					hbt.update(activityDetails);
				}
			}
				
			
		
			BigDecimal crAmt = new BigDecimal(0.00);
			BigDecimal drAmt = new BigDecimal(0.00);
	 
		if(box.getString("activitiesAccountType").equals("Promotional Activities")  ){
			if(!box.getString("activitiesAmount").equals(0.00)){
				FaVoucherDetails voucherDetails = new FaVoucherDetails();
				FaMasAccount masAccount = new FaMasAccount();
				masAccount.setId(sundryDebitorsAccountId);
				voucherDetails.setAccount(masAccount);
				voucherDetails.setVoucherHeader(faVoucherHeader);
				if(sundryDebitorsSubLedId != 0){
					FaMasSubLed subLed= new FaMasSubLed();
					subLed.setId(sundryDebitorsSubLedId);
					voucherDetails.setSubLed(subLed);
				}
				System.out.println("drAmt==="+new BigDecimal(box.getString("activitiesAmount")));
				drAmt = new BigDecimal(box.getString("activitiesAmount"));
				voucherDetails.setDrAmount(drAmt);
				voucherDetails.setCrAmount(new BigDecimal(0));
				hbt.save(voucherDetails);
				}
			}
		
		if(box.getString("cashAccountType").equals("Cash")  ){
			if(!box.getString("cash").equals(0.00)){
				FaVoucherDetails voucherDetails = new FaVoucherDetails();
				FaMasAccount masAccount = new FaMasAccount();
				masAccount.setId(cashAccountId);
				voucherDetails.setAccount(masAccount);
				voucherDetails.setVoucherHeader(faVoucherHeader);
				if(cashSubLedId != 0){
					FaMasSubLed subLed= new FaMasSubLed();
					subLed.setId(cashSubLedId);
					voucherDetails.setSubLed(subLed);
				}
				System.out.println("drAmt==="+new BigDecimal(box.getString("cash")));
				crAmt = new BigDecimal(box.getString("cash"));
				voucherDetails.setCrAmount(crAmt);
				voucherDetails.setDrAmount(new BigDecimal(0));
				hbt.save(voucherDetails);
				}
			}
		
			tx.commit();
			saved = true;

			} catch (RuntimeException e) {
					if (tx != null)
						tx.rollback();
					e.printStackTrace();
				}

				paramMap.put("suffix", box.getString("fYearDesc"));
				paramMap.put("flag", "display");
				paramMap.put("prefix", "PV");
				paramMap.put("voucherType", "Payment");
				int voucherNo = generateVoucherNo(paramMap);
				map.put("voucherNo", voucherNo);
				map.put("saved", saved);
			return map;
		}
	@Override
	public Map<String, Object> postLegalApplicationMapping(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<FaAccountParameter> accountParameterList = new ArrayList<FaAccountParameter>();
		List<LglShareApplication> applicationList = new ArrayList<LglShareApplication>();
		
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session)getSession();
		Transaction tx = null;
		boolean saved = false;
		try {
			tx = session.beginTransaction();
			int voucherNo = 0;
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			String fromDate4MySQL = "";
			String toDate4MySQL = "";
			try {
				fromDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(FROM_DATE)));
				 toDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(TO_DATE)));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int applicationAccountId = 0;int applicationSubLedId = 0; int applicationSubGroupId = 0; int applicationGroupId = 0; 
			int cashAccountId = 0; int cashSubLedId = 0; int cashSubGroupId = 0; int cashGroupId = 0;
			//int bankAccountId = 0; int bankSubLedId = 0; int bankSubGroupId = 0; int bankGroupId = 0;
			accountParameterList = session.createCriteria(FaAccountParameter.class).add(Restrictions.eq("Status", "y")).list();
			if(accountParameterList.size()>0){
				for(FaAccountParameter accountParameter :accountParameterList){
					if(accountParameter.getAccountType().equals("Share Application")){
						if(accountParameter.getAccount() != null){
							applicationAccountId = accountParameter.getAccount().getId();
							applicationSubGroupId = accountParameter.getAccount().getAccountSubGroup().getId();
							applicationGroupId = accountParameter.getAccount().getAccountSubGroup().getAccountGroup().getId();
						}
						if(accountParameter.getSubLed()!= null){
							applicationSubLedId = accountParameter.getSubLed().getId();
						}
					}
					/*if(accountParameter.getAccountType().equals("Bank")){
						if(accountParameter.getAccount() != null){
							bankAccountId = accountParameter.getAccount().getId();
							bankSubGroupId = accountParameter.getAccount().getAccountSubGroup().getId();
							bankGroupId = accountParameter.getAccount().getAccountSubGroup().getAccountGroup().getId();
						}
						if(accountParameter.getSubLed()!= null){
							bankSubLedId = accountParameter.getSubLed().getId();
						}
					}*/
					if(accountParameter.getAccountType().equals("Cash")){
						if(accountParameter.getAccount() != null){
							cashAccountId = accountParameter.getAccount().getId();
							cashSubGroupId = accountParameter.getAccount().getAccountSubGroup().getId();
							cashGroupId = accountParameter.getAccount().getAccountSubGroup().getAccountGroup().getId();
						}
						if(accountParameter.getSubLed()!= null){
							cashSubLedId = accountParameter.getSubLed().getId();
						}
					}
				}
			}
			FaVoucherHeader faVoucherHeader = new FaVoucherHeader();
			MasHospital masHospital = new MasHospital();
			masHospital.setId(box.getInt("locationId"));
			faVoucherHeader.setHospital(masHospital);
			faVoucherHeader.setVoucherDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			faVoucherHeader.setVoucherTime(box.getString(CHANGED_TIME));
			faVoucherHeader.setNarration(box.getString(NARRATION));
			Users users = new Users();
			users.setId( box.getInt("changedBy"));
			faVoucherHeader.setLastChgBy(users);
			faVoucherHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			faVoucherHeader.setLastChgTime(box.getString(CHANGED_TIME));
			faVoucherHeader.setVoucherType("RV");
			faVoucherHeader.setStatus("y");
			BigDecimal totalAmountDr = new BigDecimal(0.0);
			BigDecimal totalAmountCr = new BigDecimal(0.0);
			
			if (!box.getString("drAmount").equals("")) {
				totalAmountDr = new BigDecimal(box.getString("drAmount"));
				faVoucherHeader.setDrAmount(totalAmountDr);
			}
			if (!box.getString("crAmount").equals("")) {
				totalAmountCr = new BigDecimal(box.getString("crAmount"));
				faVoucherHeader.setCrAmount(totalAmountCr);
			}
			MasStoreFinancial masStoreFinancial = new MasStoreFinancial();
			masStoreFinancial.setId(box.getInt("fYear"));
			faVoucherHeader.setFYear(masStoreFinancial);
			paramMap.put("suffix", box.getString("fYearDesc"));
			paramMap.put("flag", "save");
			paramMap.put("prefix", "RV");
			paramMap.put("voucherType", "Receipt");
			paramMap.put("locationId", box.getInt("locationId"));
			 voucherNo = generateVoucherNo(paramMap);
			 String locationCode="";
				String yearDesc="";
				List<MasStoreFinancial>financialList=new ArrayList<MasStoreFinancial>();
				List<MasHospital>hospitalList=new ArrayList<MasHospital>();
				hospitalList=session.createCriteria(MasHospital.class).add(Restrictions.idEq(box.getInt("locationId"))).list();
				for(MasHospital mg:hospitalList){
					locationCode=mg.getHospitalCode();
				}
				financialList=session.createCriteria(MasStoreFinancial.class).add(Restrictions.idEq(box.getInt("fYear"))).list();
				for(MasStoreFinancial msf1:financialList){
					yearDesc=msf1.getYearDescription();
				}
				faVoucherHeader.setVoucherNo(locationCode+"/"+yearDesc+"/"+voucherNo);

			hbt.save(faVoucherHeader);
			map.put("voucherType", faVoucherHeader.getVoucherType());
	//======================================
			applicationList = session.createCriteria(LglShareApplication.class).add(Restrictions.between("DateOfApplication", java.sql.Date.valueOf(fromDate4MySQL), java.sql.Date.valueOf(toDate4MySQL)))
								.add(Restrictions.isNull("VoucherNo")).list();
			if(applicationList.size()>0){
				for(LglShareApplication shareApplication: applicationList){
					int applicationId = shareApplication.getId();
					LglShareApplication lglShareApplication = (LglShareApplication)hbt.load(LglShareApplication.class, applicationId);
					lglShareApplication.setVoucherNo(""+voucherNo);
					hbt.update(lglShareApplication);
				}
			}
				
			
		
			BigDecimal crAmt = new BigDecimal(0.00);
			BigDecimal drAmt = new BigDecimal(0.00);
	 
		if(box.getString("applicationAccountType").equals("Share Application")  ){
			if(!box.getString("applicationAmount").equals(0.00)){
				FaVoucherDetails voucherDetails = new FaVoucherDetails();
				FaMasAccount masAccount = new FaMasAccount();
				masAccount.setId(applicationAccountId);
				voucherDetails.setAccount(masAccount);
				voucherDetails.setVoucherHeader(faVoucherHeader);
				if(applicationSubLedId != 0){
					FaMasSubLed subLed= new FaMasSubLed();
					subLed.setId(applicationSubLedId);
					voucherDetails.setSubLed(subLed);
				}
				crAmt = new BigDecimal(box.getString("applicationAmount"));
				voucherDetails.setCrAmount(crAmt);
				voucherDetails.setDrAmount(new BigDecimal(0));
				hbt.save(voucherDetails);
				}                                                                                                                                                                                                                                          
			}
		
		if(box.getString("cashAccountType").equals("Cash")  ){
			if(!box.getString("cash").equals(0.00)){
				FaVoucherDetails voucherDetails = new FaVoucherDetails();
				FaMasAccount masAccount = new FaMasAccount();
				masAccount.setId(cashAccountId);
				voucherDetails.setAccount(masAccount);
				voucherDetails.setVoucherHeader(faVoucherHeader);
				if(cashSubLedId != 0){
					FaMasSubLed subLed= new FaMasSubLed();
					subLed.setId(cashSubLedId);
					voucherDetails.setSubLed(subLed);
				}
				System.out.println("drAmt==="+new BigDecimal(box.getString("cash")));
				drAmt = new BigDecimal(box.getString("cash"));
				voucherDetails.setDrAmount(drAmt);
				voucherDetails.setCrAmount(new BigDecimal(0));
				hbt.save(voucherDetails);
				}
			}
		
			tx.commit();
			saved = true;

			} catch (RuntimeException e) {
					if (tx != null)
						tx.rollback();
					e.printStackTrace();
				}

				paramMap.put("suffix", box.getString("fYearDesc"));
				paramMap.put("flag", "display");
				paramMap.put("prefix", "RV");
				paramMap.put("voucherType", "Receipt");
				int voucherNo = generateVoucherNo(paramMap);
				map.put("voucherNo", voucherNo);
				map.put("saved", saved);
			return map;
	}
	@Override
	public Map<String, Object> postShareAllotmentMapping(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<FaAccountParameter> accountParameterList = new ArrayList<FaAccountParameter>();
		List<LglShareAllotment> allotmentList = new ArrayList<LglShareAllotment>();
		
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session)getSession();
		Transaction tx = null;
		boolean saved = false;
		try {
			tx = session.beginTransaction();
			int voucherNo = 0;
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			String fromDate4MySQL = "";
			String toDate4MySQL = "";
			try {
				fromDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(FROM_DATE)));
				 toDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(TO_DATE)));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int applicationAccountId = 0;int applicationSubLedId = 0; int applicationSubGroupId = 0; int applicationGroupId = 0; 
			int capitalAccountId = 0; int capitalSubLedId = 0; int capitalSubGroupId = 0; int capitalGroupId = 0;
			//int bankAccountId = 0; int bankSubLedId = 0; int bankSubGroupId = 0; int bankGroupId = 0;
			accountParameterList = session.createCriteria(FaAccountParameter.class).add(Restrictions.eq("Status", "y")).list();
			if(accountParameterList.size()>0){
				for(FaAccountParameter accountParameter :accountParameterList){
					if(accountParameter.getAccountType().equals("Share Application")){
						if(accountParameter.getAccount() != null){
							applicationAccountId = accountParameter.getAccount().getId();
							applicationSubGroupId = accountParameter.getAccount().getAccountSubGroup().getId();
							applicationGroupId = accountParameter.getAccount().getAccountSubGroup().getAccountGroup().getId();
						}
						if(accountParameter.getSubLed()!= null){
							applicationSubLedId = accountParameter.getSubLed().getId();
						}
					}
					/*if(accountParameter.getAccountType().equals("Bank")){
						if(accountParameter.getAccount() != null){
							bankAccountId = accountParameter.getAccount().getId();
							bankSubGroupId = accountParameter.getAccount().getAccountSubGroup().getId();
							bankGroupId = accountParameter.getAccount().getAccountSubGroup().getAccountGroup().getId();
						}
						if(accountParameter.getSubLed()!= null){
							bankSubLedId = accountParameter.getSubLed().getId();
						}
					}*/
					if(accountParameter.getAccountType().equals("Share Capital")){
						if(accountParameter.getAccount() != null){
							capitalAccountId = accountParameter.getAccount().getId();
							capitalSubGroupId = accountParameter.getAccount().getAccountSubGroup().getId();
							capitalGroupId = accountParameter.getAccount().getAccountSubGroup().getAccountGroup().getId();
						}
						if(accountParameter.getSubLed()!= null){
							capitalSubLedId = accountParameter.getSubLed().getId();
						}
					}
				}
			}
			FaVoucherHeader faVoucherHeader = new FaVoucherHeader();
			MasHospital masHospital = new MasHospital();
			masHospital.setId(box.getInt("locationId"));
			faVoucherHeader.setHospital(masHospital);
			faVoucherHeader.setVoucherDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			faVoucherHeader.setVoucherTime(box.getString(CHANGED_TIME));
			faVoucherHeader.setNarration(box.getString(NARRATION));
			Users users = new Users();
			users.setId( box.getInt("changedBy"));
			faVoucherHeader.setLastChgBy(users);
			faVoucherHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			faVoucherHeader.setLastChgTime(box.getString(CHANGED_TIME));
			faVoucherHeader.setVoucherType("RV");
			faVoucherHeader.setStatus("y");
			BigDecimal totalAmountDr = new BigDecimal(0.0);
			BigDecimal totalAmountCr = new BigDecimal(0.0);
			
			if (!box.getString("drAmount").equals("")) {
				totalAmountDr = new BigDecimal(box.getString("drAmount"));
				faVoucherHeader.setDrAmount(totalAmountDr);
			}
			if (!box.getString("crAmount").equals("")) {
				totalAmountCr = new BigDecimal(box.getString("crAmount"));
				faVoucherHeader.setCrAmount(totalAmountCr);
			}
			MasStoreFinancial masStoreFinancial = new MasStoreFinancial();
			masStoreFinancial.setId(box.getInt("fYear"));
			faVoucherHeader.setFYear(masStoreFinancial);
			paramMap.put("suffix", box.getString("fYearDesc"));
			paramMap.put("flag", "save");
			paramMap.put("prefix", "JV");
			paramMap.put("voucherType", "Journal");
			paramMap.put("locationId", box.getInt("locationId"));
			 voucherNo = generateVoucherNo(paramMap);
			 String locationCode="";
				String yearDesc="";
				List<MasStoreFinancial>financialList=new ArrayList<MasStoreFinancial>();
				List<MasHospital>hospitalList=new ArrayList<MasHospital>();
				hospitalList=session.createCriteria(MasHospital.class).add(Restrictions.idEq(box.getInt("locationId"))).list();
				for(MasHospital mg:hospitalList){
					locationCode=mg.getHospitalCode();
				}
				financialList=session.createCriteria(MasStoreFinancial.class).add(Restrictions.idEq(box.getInt("fYear"))).list();
				for(MasStoreFinancial msf1:financialList){
					yearDesc=msf1.getYearDescription();
				}
				faVoucherHeader.setVoucherNo(locationCode+"/"+yearDesc+"/"+voucherNo);

			hbt.save(faVoucherHeader);
			map.put("voucherType", faVoucherHeader.getVoucherType());
	//======================================
			allotmentList = session.createCriteria(LglShareAllotment.class).add(Restrictions.between("DateOfAllotment", java.sql.Date.valueOf(fromDate4MySQL), java.sql.Date.valueOf(toDate4MySQL)))
								.add(Restrictions.isNull("VoucherNo")).list();
			if(allotmentList.size()>0){
				for(LglShareAllotment shareAllotment: allotmentList){
					int allotmentId = shareAllotment.getId();
					LglShareAllotment lglShareAllotment = (LglShareAllotment)hbt.load(LglShareAllotment.class, allotmentId);
					lglShareAllotment.setVoucherNo(""+voucherNo);
					hbt.update(lglShareAllotment);
				}
			}
				
			
		
			BigDecimal crAmt = new BigDecimal(0.00);
			BigDecimal drAmt = new BigDecimal(0.00);
	 
		if(box.getString("applicationAccountType").equals("Share Application")  ){
			if(!box.getString("applicationAmount").equals(0.00)){
				FaVoucherDetails voucherDetails = new FaVoucherDetails();
				FaMasAccount masAccount = new FaMasAccount();
				masAccount.setId(applicationAccountId);
				voucherDetails.setAccount(masAccount);
				voucherDetails.setVoucherHeader(faVoucherHeader);
				if(applicationSubLedId != 0){
					FaMasSubLed subLed= new FaMasSubLed();
					subLed.setId(applicationSubLedId);
					voucherDetails.setSubLed(subLed);
				}
				drAmt = new BigDecimal(box.getString("applicationAmount"));
				voucherDetails.setDrAmount(drAmt);
				voucherDetails.setCrAmount(new BigDecimal(0));
				hbt.save(voucherDetails);
				}                                                                                                                                                                                                                                          
			}
		
		if(box.getString("capitalAccountType").equals("Share Capital")  ){
			if(!box.getString("capitalAmount").equals(0.00)){
				FaVoucherDetails voucherDetails = new FaVoucherDetails();
				FaMasAccount masAccount = new FaMasAccount();
				masAccount.setId(capitalAccountId);
				voucherDetails.setAccount(masAccount);
				voucherDetails.setVoucherHeader(faVoucherHeader);
				if(capitalSubLedId != 0){
					FaMasSubLed subLed= new FaMasSubLed();
					subLed.setId(capitalSubLedId);
					voucherDetails.setSubLed(subLed);
				}
				crAmt = new BigDecimal(box.getString("capitalAmount"));
				voucherDetails.setCrAmount(crAmt);
				voucherDetails.setDrAmount(new BigDecimal(0));
				hbt.save(voucherDetails);
				}
			}
		
			tx.commit();
			saved = true;

			} catch (RuntimeException e) {
					if (tx != null)
						tx.rollback();
					e.printStackTrace();
				}

				paramMap.put("suffix", box.getString("fYearDesc"));
				paramMap.put("flag", "display");
				paramMap.put("prefix", "JV");
				paramMap.put("voucherType", "Journal");
				int voucherNo = generateVoucherNo(paramMap);
				map.put("voucherNo", voucherNo);
				map.put("saved", saved);
			return map;
	}
	@Override
	public Map<String, Object> displayShareCallMapping(Box box) {
		Map<String,Object> map = new HashMap<String, Object>();
		List<BigDecimal> shareCallMappingList = new ArrayList<BigDecimal>();
		Session session = (Session)getSession();
		SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
		String fromDate4MySQL = "";
		String toDate4MySQL = "";
		try {
			fromDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(FROM_DATE)));
			 toDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(TO_DATE)));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		String shareCallQueryString = "SELECT sum(call_amt) FROM lgl_share_call_details " +
								" where payment_date between   '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and voucher_no is null";
		
		shareCallMappingList = session.createSQLQuery(shareCallQueryString).list();
		map.put("shareCallMappingList",shareCallMappingList);
		map.put("fromDate",HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE)));
		map.put("toDate",HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE)));
		return map;
	}
	@Override
	public Map<String, Object> showCashFlowStatementJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccount> currentFinancialYearAccountList = new ArrayList<FaMasAccount>();
		List<FaMasAccount> lastFinancialYearAccountList = new ArrayList<FaMasAccount>();
		List<MasStoreFinancial> financialYearList = new ArrayList<MasStoreFinancial>();
		List<MasStoreFinancial> lastFinancialYearList = new ArrayList<MasStoreFinancial>();
		Session session = (Session)getSession();
		currentFinancialYearAccountList = session.createCriteria(FaMasAccount.class)
										.add(Restrictions.eq("Hospital.Id", box.getInt("locationId")))
												.add(Restrictions.eq("FYear.Id", box.getInt("fYear"))).list();
		financialYearList = session.createCriteria(MasStoreFinancial.class).add(Restrictions.idEq(box.getInt("fYear"))).list();
		int lastFinancialYearId = 0;
		String lastYearDesc = "";
		String currentYearDesc = "";
		if(financialYearList.size()>0){
			currentYearDesc = financialYearList.get(0).getYearDescription();
			System.out.println("currentYearDesc :::::" + currentYearDesc);
			lastYearDesc = ""+(Integer.parseInt(currentYearDesc)-1);
			lastFinancialYearList = session.createCriteria(MasStoreFinancial.class).add(Restrictions.eq("YearDescription", lastYearDesc)).list();
			lastFinancialYearId = lastFinancialYearList.get(0).getId();
		}
		lastFinancialYearAccountList = session.createCriteria(FaMasAccount.class)
										.add(Restrictions.eq("Hospital.Id", box.getInt("locationId")))
											.add(Restrictions.eq("FYear.Id", lastFinancialYearId)).list();
		map.put("currentFinancialYearAccountList", currentFinancialYearAccountList);
		map.put("lastFinancialYearAccountList", lastFinancialYearAccountList);
		map.put("currentYearDesc", Integer.parseInt(currentYearDesc)+1);
		map.put("lastYearDesc", Integer.parseInt(lastYearDesc)+1);
		return map;
	}
	@Override
	public Map<String, Object> postShareCallMapping(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<FaAccountParameter> accountParameterList = new ArrayList<FaAccountParameter>();
		List<LglShareCallDetails> callList = new ArrayList<LglShareCallDetails>();
		
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session)getSession();
		Transaction tx = null;
		boolean saved = false;
		try {
			tx = session.beginTransaction();
			int voucherNo = 0;
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			String fromDate4MySQL = "";
			String toDate4MySQL = "";
			try {
				fromDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(FROM_DATE)));
				 toDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(TO_DATE)));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int callAccountId = 0;int callSubLedId = 0; int callSubGroupId = 0; int callGroupId = 0; 
			int capitalAccountId = 0; int capitalSubLedId = 0; int capitalSubGroupId = 0; int capitalGroupId = 0;
			//int bankAccountId = 0; int bankSubLedId = 0; int bankSubGroupId = 0; int bankGroupId = 0;
			accountParameterList = session.createCriteria(FaAccountParameter.class).add(Restrictions.eq("Status", "y")).list();
			if(accountParameterList.size()>0){
				for(FaAccountParameter accountParameter :accountParameterList){
					if(accountParameter.getAccountType().equals("Share Call")){
						if(accountParameter.getAccount() != null){
							callAccountId = accountParameter.getAccount().getId();
							callSubGroupId = accountParameter.getAccount().getAccountSubGroup().getId();
							callGroupId = accountParameter.getAccount().getAccountSubGroup().getAccountGroup().getId();
						}
						if(accountParameter.getSubLed()!= null){
							callSubLedId = accountParameter.getSubLed().getId();
						}
					}
					/*if(accountParameter.getAccountType().equals("Bank")){
						if(accountParameter.getAccount() != null){
							bankAccountId = accountParameter.getAccount().getId();
							bankSubGroupId = accountParameter.getAccount().getAccountSubGroup().getId();
							bankGroupId = accountParameter.getAccount().getAccountSubGroup().getAccountGroup().getId();
						}
						if(accountParameter.getSubLed()!= null){
							bankSubLedId = accountParameter.getSubLed().getId();
						}
					}*/
					if(accountParameter.getAccountType().equals("Share Capital")){
						if(accountParameter.getAccount() != null){
							capitalAccountId = accountParameter.getAccount().getId();
							capitalSubGroupId = accountParameter.getAccount().getAccountSubGroup().getId();
							capitalGroupId = accountParameter.getAccount().getAccountSubGroup().getAccountGroup().getId();
						}
						if(accountParameter.getSubLed()!= null){
							capitalSubLedId = accountParameter.getSubLed().getId();
						}
					}
				}
			}
			BigDecimal totalDr=new BigDecimal(0);
			BigDecimal totalCr=new BigDecimal(0);
			if(box.getString(TOTAL_DR_AMOUNT)!=null){
				totalDr=new BigDecimal(box.getString(TOTAL_DR_AMOUNT));
			}
			if(box.getString(TOTAL_CR_AMOUNT)!=null){
				totalCr=new BigDecimal(box.getString(TOTAL_CR_AMOUNT));
				
			}
	/*		for(int j=1;j<=2;j++){
				
			}*/
			FaVoucherHeader faVoucherHeader = new FaVoucherHeader();
			MasHospital masHospital = new MasHospital();
			masHospital.setId(box.getInt("locationId"));
			faVoucherHeader.setHospital(masHospital);
			faVoucherHeader.setVoucherDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			faVoucherHeader.setVoucherTime(box.getString(CHANGED_TIME));
			faVoucherHeader.setNarration(box.getString(NARRATION));
			Users users = new Users();
			users.setId( box.getInt("changedBy"));
			faVoucherHeader.setLastChgBy(users);
			faVoucherHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			faVoucherHeader.setLastChgTime(box.getString(CHANGED_TIME));
			faVoucherHeader.setVoucherType("JV");
			faVoucherHeader.setStatus("y");
			BigDecimal totalAmountDr = new BigDecimal(0.0);
			BigDecimal totalAmountCr = new BigDecimal(0.0);
			
			if (!box.getString("drAmount").equals("")) {
				totalAmountDr = new BigDecimal(box.getString("drAmount"));
				faVoucherHeader.setDrAmount(totalAmountDr);
			}
			if (!box.getString("crAmount").equals("")) {
				totalAmountCr = new BigDecimal(box.getString("crAmount"));
				faVoucherHeader.setCrAmount(totalAmountCr);
			}
			MasStoreFinancial masStoreFinancial = new MasStoreFinancial();
			masStoreFinancial.setId(box.getInt("fYear"));
			faVoucherHeader.setFYear(masStoreFinancial);
			paramMap.put("suffix", box.getString("fYearDesc"));
			paramMap.put("flag", "save");
			paramMap.put("prefix", "JV");
			paramMap.put("voucherType", "Journal");
			paramMap.put("locationId", box.getInt("locationId"));
			 voucherNo = generateVoucherNo(paramMap);
			 String locationCode="";
				String yearDesc="";
				List<MasStoreFinancial>financialList=new ArrayList<MasStoreFinancial>();
				List<MasHospital>hospitalList=new ArrayList<MasHospital>();
				hospitalList=session.createCriteria(MasHospital.class).add(Restrictions.idEq(box.getInt("locationId"))).list();
				for(MasHospital mg:hospitalList){
					locationCode=mg.getHospitalCode();
				}
				financialList=session.createCriteria(MasStoreFinancial.class).add(Restrictions.idEq(box.getInt("fYear"))).list();
				for(MasStoreFinancial msf1:financialList){
					yearDesc=msf1.getYearDescription();
				}
				faVoucherHeader.setVoucherNo(locationCode+"/"+yearDesc+"/"+voucherNo);

			hbt.save(faVoucherHeader);
			map.put("voucherType", faVoucherHeader.getVoucherType());
	//======================================
			callList = session.createCriteria(LglShareCallDetails.class).add(Restrictions.between("DateOfAllotment", java.sql.Date.valueOf(fromDate4MySQL), java.sql.Date.valueOf(toDate4MySQL)))
								.add(Restrictions.isNull("VoucherNo")).list();
			if(callList.size()>0){
				for(LglShareCallDetails shareAllotment: callList){
					int allotmentId = shareAllotment.getId();
					LglShareAllotment lglShareAllotment = (LglShareAllotment)hbt.load(LglShareAllotment.class, allotmentId);
					lglShareAllotment.setVoucherNo(""+voucherNo);
					hbt.update(lglShareAllotment);
				}
			}
				
			
		
			BigDecimal crAmt = new BigDecimal(0.00);
			BigDecimal drAmt = new BigDecimal(0.00);
	 
		if(box.getString("callAccountType").equals("Share Call")){
			if(!box.getString("callAmount").equals(0.00)){
				FaVoucherDetails voucherDetails = new FaVoucherDetails();
				FaMasAccount masAccount = new FaMasAccount();
				masAccount.setId(callAccountId);
				voucherDetails.setAccount(masAccount);
				voucherDetails.setVoucherHeader(faVoucherHeader);
				if(callSubLedId != 0){
					FaMasSubLed subLed= new FaMasSubLed();
					subLed.setId(callSubLedId);
					voucherDetails.setSubLed(subLed);
				}
				drAmt = new BigDecimal(box.getString("callAmount"));
				voucherDetails.setDrAmount(drAmt);
				voucherDetails.setCrAmount(new BigDecimal(0));
				hbt.save(voucherDetails);
				}                                                                                                                                                                                                                                          
			}
		
		if(box.getString("capitalAccountType").equals("Share Capital")){
			if(!box.getString("capitalAmount").equals(0.00)){
				FaVoucherDetails voucherDetails = new FaVoucherDetails();
				FaMasAccount masAccount = new FaMasAccount();
				masAccount.setId(capitalAccountId);
				voucherDetails.setAccount(masAccount);
				voucherDetails.setVoucherHeader(faVoucherHeader);
				if(capitalSubLedId != 0){
					FaMasSubLed subLed= new FaMasSubLed();
					subLed.setId(capitalSubLedId);
					voucherDetails.setSubLed(subLed);
				}
				crAmt = new BigDecimal(box.getString("capitalAmount"));
				voucherDetails.setCrAmount(crAmt);
				voucherDetails.setDrAmount(new BigDecimal(0));
				hbt.save(voucherDetails);
				}
			}
		
			tx.commit();
			saved = true;

			} catch (RuntimeException e) {
					if (tx != null)
						tx.rollback();
					e.printStackTrace();
				}

				paramMap.put("suffix", box.getString("fYearDesc"));
				paramMap.put("flag", "display");
				paramMap.put("prefix", "JV");
				paramMap.put("voucherType", "Journal");
				int voucherNo = generateVoucherNo(paramMap);
				map.put("voucherNo", voucherNo);
				map.put("saved", saved);
			return map;
	}
	@Override
	public Map<String, Object> postProductionMapping(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<FaAccountParameter> accountParameterList = new ArrayList<FaAccountParameter>();
		
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session)getSession();
		Transaction tx = null;
		boolean saved = false;


		try {
			tx = session.beginTransaction();
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			String fromDate4MySQL = "";
			String toDate4MySQL = "";
			int voucherNo = 0;
			int approvalStatus = Integer.parseInt(HMSUtil.getProperties("adt.properties", "approvedId"));
			try {
				fromDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(FROM_DATE)));
				 toDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(TO_DATE)));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int seedsAccountId = 0;int seedsSubLedId = 0; int seedsSubGroupId = 0; int seedsGroupId = 0; 
			int growerAccountId = 0; int growerSubLedId = 0; int growerSubGroupId = 0; int growerGroupId = 0;
			
			
			accountParameterList = session.createCriteria(FaAccountParameter.class).add(Restrictions.eq("Status", "y")).list();
			/*if(accountParameterList.size()>0){
				for(FaAccountParameter accountParameter :accountParameterList){
					if(accountParameter.getAccountType().equals("Seeds")){
						if(accountParameter.getAccount() != null){
							seedsAccountId = accountParameter.getAccount().getId();
							seedsSubGroupId = accountParameter.getAccount().getAccountSubGroup().getId();
							seedsGroupId = accountParameter.getAccount().getAccountSubGroup().getAccountGroup().getId();
						}
						if(accountParameter.getSubLed()!= null){
							seedsSubLedId = accountParameter.getSubLed().getId();
						}
					}
					if(accountParameter.getAccountType().equals("Grower")){
						if(accountParameter.getAccount() != null){
							growerAccountId = accountParameter.getAccount().getId();
							growerSubGroupId = accountParameter.getAccount().getAccountSubGroup().getId();
							growerGroupId = accountParameter.getAccount().getAccountSubGroup().getAccountGroup().getId();
						}
						if(accountParameter.getSubLed()!= null){
							growerSubLedId = accountParameter.getSubLed().getId();
						}
					}
					
				}
			}*/
		
					
			
			int count =1;
				if(box.getInt("count") != 0){
					count = (Integer)box.getInt("count");
				}
				System.out.println("count=="+count);
			
	 for (int j = 1; j < count; j++) {
		 System.out.println("j-->"+j);
		if(box.getString("voucherCnt"+j).equals("y")){
			System.out.println("in if");
			FaVoucherHeader faVoucherHeader = new FaVoucherHeader();
			MasHospital masHospital = new MasHospital();
			masHospital.setId(box.getInt("locationId"));
			faVoucherHeader.setHospital(masHospital);
			faVoucherHeader.setVoucherDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			faVoucherHeader.setVoucherTime(box.getString(CHANGED_TIME));
			
			
			Users users = new Users();
			users.setId( box.getInt("changedBy"));
			faVoucherHeader.setLastChgBy(users);
			faVoucherHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			faVoucherHeader.setLastChgTime(box.getString(CHANGED_TIME));
			faVoucherHeader.setVoucherType("PRV");
			faVoucherHeader.setStatus("y");
			faVoucherHeader.setPaymentType(box.getString("pmtType"+j));
			faVoucherHeader.setChequeNo(box.getString("checkNo"+j));
			double totalAmountDr = box.getDouble("drAmount"+j);
			double totalAmountCr = box.getDouble("crAmount"+j);
			
			faVoucherHeader.setDrAmount(new BigDecimal(totalAmountDr));
			
			faVoucherHeader.setCrAmount(new BigDecimal(totalAmountCr  ));
			
			MasStoreFinancial masStoreFinancial = new MasStoreFinancial();
			masStoreFinancial.setId(box.getInt("fYear"));
			faVoucherHeader.setFYear(masStoreFinancial);
			
			// Create Naration dynamic for each Grower
			
			int growerPaymentId = box.getInt("growerPaymentId"+j);
			String ChequeNo = box.getString("checkNo"+j);
			String ChequeDate = "";
			String crop ="";
			String variety = "";
			String seedclass ="";
			String paymentstatus="";
			String Narration ="";
			double qty= 0.0;
			double rate =0.0;
			String LotNo= "";
			ProdGrowerPayment growerPayment = new  ProdGrowerPayment();
			growerPayment = (ProdGrowerPayment) hbt.get(ProdGrowerPayment.class, growerPaymentId);
			if(growerPayment != null)
			{
				crop = growerPayment.getSeedQuality().getCrop().getNomenclature();
				variety = growerPayment.getSeedQuality().getSeedVariety().getItemVarietyName();
				seedclass = growerPayment.getSeedQuality().getSeedClass().getItemClassName();
				qty = growerPayment.getQuantity().doubleValue();
				rate = growerPayment.getRate().doubleValue();
				LotNo = growerPayment.getSeedQuality().getTempLotNo();
				ChequeDate= HMSUtil.convertDateTypeToStringWithoutTime(growerPayment.getReceiptDate());
				paymentstatus= growerPayment.getPaymentType();
				
			}
			if(paymentstatus.equalsIgnoreCase("Advance")){
				Narration = "Cheque No: "+ChequeNo+"/"+ChequeDate+" Purchase Advance Paid towards "+crop+" "+variety+ " "+ seedclass+" for Qtls"+qty+"@Rs"+rate+"Per Qtl "+LotNo;
				faVoucherHeader.setNarration(Narration);
			}else{
				 Narration = "Cheque No: "+ChequeNo+"/"+ChequeDate+" Final payment Paid towards "+crop+" "+variety+ " "+ seedclass+" for Qtls"+qty+"@Rs"+rate+"Per Qtl "+LotNo;
				faVoucherHeader.setNarration(Narration);
			}
		
			MasApprovalStatus masApprovalStatus = new MasApprovalStatus();
			masApprovalStatus.setId(approvalStatus);
			faVoucherHeader.setApprovalStatus(masApprovalStatus);
			faVoucherHeader.setAcknowedgeStatus(masApprovalStatus);
						
			System.out.println("Narration="+Narration);		
			paramMap.put("suffix", box.getString("fYearDesc"));
			paramMap.put("flag", "save");
			paramMap.put("prefix", "JV");
			paramMap.put("voucherType", "Journal");
			paramMap.put("locationId", box.getInt("locationId"));
			paramMap.put("financialYearId", box.getInt("fYear"));
			 voucherNo = generateVoucherNo(paramMap);
			 String locationCode="";
				String yearDesc="";
				List<MasStoreFinancial>financialList=new ArrayList<MasStoreFinancial>();
				List<MasHospital>hospitalList=new ArrayList<MasHospital>();
				hospitalList=session.createCriteria(MasHospital.class).add(Restrictions.idEq(box.getInt("locationId"))).list();
				for(MasHospital mg:hospitalList){
					locationCode=mg.getHospitalCode();
				}
				financialList=session.createCriteria(MasStoreFinancial.class).add(Restrictions.idEq(box.getInt("fYear"))).list();
				for(MasStoreFinancial msf1:financialList){
					yearDesc=msf1.getYearDescription();
				}
				faVoucherHeader.setVoucherNo("PRV/"+locationCode+"/"+yearDesc+"/"+voucherNo);

			hbt.save(faVoucherHeader);
			map.put("voucherType", faVoucherHeader.getVoucherType());
			//======================================
			System.out.println("processing=Id=="+box.getInt("processingId"+j));
			System.out.println("growerPaymentId=Id=="+box.getInt("growerPaymentId"+j));
			
			int growerId =0;
			if(box.getInt("growerPaymentId"+j) != 0){
				ProdGrowerPayment growerPayment1 = (ProdGrowerPayment)hbt.load(ProdGrowerPayment.class, box.getInt("growerPaymentId"+j));
				FaVoucherHeader fvh=new FaVoucherHeader();
				fvh.setId(faVoucherHeader.getId());
				growerPayment1.setVoucherNo(fvh);
				growerId=growerPayment1.getSeedQuality().getGrower().getGrower().getId();
				
				hbt.update(growerPayment1);
			}
			
		
			BigDecimal crAmt = new BigDecimal(0.00);
			BigDecimal drAmt = new BigDecimal(0.00);
	 System.out.println("accountId-------------->>"+box.getInt("AccountName"+j));
	 
	 // Caculate SubledgerId based on GrowerId from MasSubLedger
	 
	 int subLedId =0;
	 
	 List<FaMasSubLed> subLedger = new ArrayList<FaMasSubLed>();
	 Criteria cr=null;
	 cr = session.createCriteria(FaMasSubLed.class).createAlias("Hospital", "location").add(Restrictions.eq("location.Id", box.getInt("locationId")));
	 cr= cr.createAlias("Grower", "gr").add(Restrictions.eq("gr.Id", growerId));
	 cr = cr.createAlias("Account", "acc").add(Restrictions.eq("acc.Id", box.getInt("AccountName"+j)));
	 subLedger = cr.list();
	 if(subLedger.size()>0)
	 {
		 for(FaMasSubLed list: subLedger)
		 {
			 subLedId =  list.getId();
			
		 }
		
	 }
	 
	 
	 
	 
		if(box.getString("seedsAccountType"+j).equals("Seeds")  ){
			if(!box.getString("seedsAmt"+j).equals(0.00)){
				FaVoucherDetails voucherDetails = new FaVoucherDetails();
				FaMasAccount masAccount = new FaMasAccount();
				masAccount.setId(box.getInt("AccountName"+j));
				voucherDetails.setAccount(masAccount);
				voucherDetails.setVoucherHeader(faVoucherHeader);
	
				System.out.println("drAmt==="+new BigDecimal(box.getString("seedsAmt"+j)));
				drAmt = new BigDecimal(box.getString("seedsAmt"+j));
				voucherDetails.setDrAmount(drAmt);
				voucherDetails.setCrAmount(new BigDecimal(0));
				voucherDetails.setReconcile("n");
				if(subLedId != 0){
					FaMasSubLed subLed= new FaMasSubLed();
					subLed.setId(subLedId);
					voucherDetails.setSubLed(subLed);
				}
				hbt.save(voucherDetails);
				BigDecimal crAmount=new BigDecimal(0);
				BigDecimal drAmount=new BigDecimal(0);
				drAmount=new BigDecimal(box.getString("seedsAmt"+j));
				
				updateTransaction(subLedId,box.getInt("AccountName"+j), box.getInt("fYear"), box.getInt("locationId"), ""+crAmount, ""+drAmt);
				}
			}
		
		if(box.getString("growerAccountType"+j).equals("Grower")  ){
			if(!box.getString("growerAmt"+j).equals(0.00)){
				FaVoucherDetails voucherDetails = new FaVoucherDetails();
				FaMasAccount masAccount = new FaMasAccount();
				Properties properties = new Properties();
				URL resourcePath = Thread.currentThread().getContextClassLoader()
						.getResource("adt.properties");
				try {
					properties.load(resourcePath.openStream());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int growerAccountId2 = 0;
				
				
				growerAccountId2 = Integer.parseInt(properties.getProperty("purchaseAdvanceAccount"));
				masAccount.setId(growerAccountId2);
				voucherDetails.setAccount(masAccount);
				voucherDetails.setVoucherHeader(faVoucherHeader);
				
				System.out.println("drAmt==="+new BigDecimal(box.getString("growerAmt"+j)));
				drAmt = new BigDecimal(box.getString("growerAmt"+j));
				voucherDetails.setDrAmount(new BigDecimal(0));
				voucherDetails.setCrAmount(drAmt);
				
				hbt.save(voucherDetails);
				BigDecimal crAmount=new BigDecimal(0);
				BigDecimal drAmount=new BigDecimal(0);
				crAmount=new BigDecimal(box.getString("growerAmt"+j));
				
				int crSubLedId=0;
				if(box.getString("crSubLedId"+j)!="" && !box.getString("crSubLedId"+j).isEmpty() ){
					crSubLedId = Integer.parseInt((box.getString("crSubLedId"+j)));
					FaMasSubLed subLed= new FaMasSubLed();
					subLed.setId(crSubLedId);
					voucherDetails.setSubLed(subLed);
					
				}
				updateTransaction(crSubLedId,growerAccountId2, box.getInt("fYear"), box.getInt("locationId"), ""+crAmount, ""+drAmount);
				}
			}
		}
			
		}
		
		
		tx.commit();
			saved = true;

			} catch (RuntimeException e) {
					if (tx != null)
						tx.rollback();
					e.printStackTrace();
				}

				paramMap.put("suffix", box.getString("fYearDesc"));
				paramMap.put("flag", "display");
				paramMap.put("prefix", "JV");
				paramMap.put("voucherType", "Journal");
				int voucherNo = generateVoucherNo(paramMap);
				map.put("voucherNo", voucherNo);
				map.put("saved", saved);
			return map;
	}
	/*@Override
	public Map<String, Object> showGrowerPaymentJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreFinancial> financialYearList = new ArrayList<MasStoreFinancial>();
		List<Object[]> seedCategoryList = new ArrayList<Object[]>();
		List<Object[]> cropList = new ArrayList<Object[]>();
		List<Object[]>pendingAdvancePaymentList = new ArrayList<Object[]>();
		//List<ProdSeedProcessingDetails> seedProcessingsList = new ArrayList<ProdSeedProcessingDetails>();
		List<Object[]>pendingFinalPaymentList = new ArrayList<Object[]>();
		Session session = (Session)getSession();
		financialYearList = session.createCriteria(MasStoreFinancial.class).add(Restrictions.eq("Status", "y")).list();
		map.put("financialYearList", financialYearList);
		Criteria cr = session.createCriteria(MasStoreItemCategory.class).add(Restrictions.eq("Status", "Y").ignoreCase());
		cr = cr.addOrder(Order.asc("ItemCategoryName"));
		
		cr = cr.createAlias("ItemGroup", "itemGroup");
		cr = cr.add(Restrictions.eq("itemGroup.GroupCode", "S").ignoreCase());
		cr = cr.setProjection(Projections.projectionList()
				.add(Projections.property("Id"))
				.add(Projections.property("ItemCategoryName")));
		seedCategoryList = cr.list();
		
		Criteria criteria = session.createCriteria(MasStoreItem.class).add(Restrictions.eq("Status", "y").ignoreCase());
		criteria = criteria.createAlias("Group", "grp",CriteriaSpecification.LEFT_JOIN);
		criteria = criteria.createAlias("ItemCategory", "itemCategory",CriteriaSpecification.LEFT_JOIN);
		criteria = criteria.add(Restrictions.eq("grp.Id", 1));
		cropList= criteria.setProjection(Projections.projectionList()
				.add(Projections.groupProperty("itemCategory.Id"))
				.add(Projections.sqlProjection("cast(group_concat(distinct item_id order by nomenclature) as char) as item_id", new String[]{"item_id"}, new Type[]{new StringType()}))
				.add(Projections.sqlProjection("group_concat(distinct nomenclature order by nomenclature) as nomenclature", new String[]{"nomenclature"}, new Type[]{new StringType()})))
				.list();
		pendingAdvancePaymentList = session.createCriteria(ProdSeedProcessingDetails.class).createAlias("Header", "header")
		.createAlias("header.SeedQuality", "seedQuality").createAlias("seedQuality.Grower", "growerDetail")
		.createAlias("growerDetail.Grower", "grower").createAlias("seedQuality.Season", "season").createAlias("seedQuality.Crop", "crop")
						.createAlias("seedQuality.SeedClass", "class").createAlias("seedQuality.ProdYear", "fYear")
						.add(Restrictions.isNull("header.AdvancePayment"))
						//.add(Restrictions.eq("season.Id", box.getInt("txtSeason")))
						//.add(Restrictions.eq("crop.Id", box.getInt("ddlCropList"))).add(Restrictions.eq("fYear.Id", box.getInt("fYearId")))
							.add(Restrictions.eq("header.Location.Id", box.getInt("locationId")))
							.createAlias("seedQuality.SeedVariety", "variety").setProjection(Projections.projectionList()
							.add(Projections.property("grower.GrowerName"))
							.add(Projections.property("season.ItemCategoryName"))
							.add(Projections.property("crop.Nomenclature"))
							.add(Projections.property("variety.ItemVarietyName"))
							.add(Projections.property("class.ItemClassName"))
							.add(Projections.property("GoodSeed")).add(Projections.property("LotNo"))
							.add(Projections.property("fYear.Id")).add(Projections.property("grower.Id"))
							.add(Projections.property("season.Id")).add(Projections.property("crop.Id"))
							.add(Projections.property("variety.Id")).add(Projections.property("class.Id"))
							.add(Projections.property("fYear.FinancialYear")).add(Projections.property("header.Id")))
							.list();
			pendingFinalPaymentList = session.createCriteria(QaSampleResult.class).createAlias("Season", "season").createAlias("Crop", "crop")
							.createAlias("Variety", "variety").createAlias("SeedClass", "class").createAlias("SampleCollection", "sampleCollectionHeader")
							.createAlias("sampleCollectionHeader.Processing", "seedProcessingDetail").createAlias("seedProcessingDetail.Header", "seedProcessinHeader")
							.createAlias("seedProcessinHeader.SeedQuality", "seedQuality").createAlias("seedQuality.Grower", "growerDetail")
							.createAlias("ProdYear", "fYear")
							.createAlias("growerDetail.Grower", "grower")
							//.add(Restrictions.eq("season.Id", box.getInt("txtSeason")))
							//.add(Restrictions.eq("crop.Id", box.getInt("ddlCropList"))).add(Restrictions.eq("fYear.Id", box.getInt("fYearId")))
							.add(Restrictions.eq("Location.Id", box.getInt("locationId")))
							.add(Restrictions.eq("FinalPayment", "n"))
							.setProjection(Projections.projectionList()
								.add(Projections.property("grower.GrowerName"))
								.add(Projections.property("season.ItemCategoryName"))
								.add(Projections.property("crop.Nomenclature"))
								.add(Projections.property("variety.ItemVarietyName"))
								.add(Projections.property("class.ItemClassName"))
								.add(Projections.property("LotQuantity")).add(Projections.property("LotNo"))
								.add(Projections.property("fYear.Id")).add(Projections.property("grower.Id"))
								.add(Projections.property("season.Id")).add(Projections.property("crop.Id"))
								.add(Projections.property("variety.Id")).add(Projections.property("class.Id"))
								.add(Projections.property("fYear.FinancialYear")).add(Projections.property("Id"))
								.add(Projections.property("seedProcessinHeader.Id")))
								.list();
		//seedProcessingsList = session.createCriteria(ProdSeedProcessingDetails.class).createAlias("Header", "header").add(Restrictions.isNull("AdvancePayment")).list();
		map.put("financialYearList", financialYearList);
		map.put("seedCategoryList", seedCategoryList);
		//map.put("seedProcessingsList", seedProcessingsList);
		map.put("pendingAdvancePaymentList", pendingAdvancePaymentList);
		map.put("pendingFinalPaymentList", pendingFinalPaymentList);
		map.put("cropList", cropList);
		return map;
	}*/
	@Override
	public Map<String, Object> getPendingPaymentList(Box box) {
		Map<String, Object> datamap = new HashMap();
		List<DgSeedQualityInspection> pendingListForGrowerPayment = new ArrayList<DgSeedQualityInspection>();
		  
		  Session session = getSession();
		  int pagingSize = 10;
		  int pageNo = 1;
		  int ddlSeason = 0;
		  int ddlYear = 0;
		  int ddlCropList = 0;
		  int ddlVarietyList = 0;
		  
		  int locationId = 0;
		  
		 
		  if (box.getString("PN") != null) {
		    pageNo = Integer.parseInt(box.getString("PN"));
		  }
		  if (box.getInt("ddlSeason") != 0) {
		    ddlSeason = box.getInt("ddlSeason");
		  }
		  if (box.getInt("ddlYear") != 0) {
		    ddlYear = box.getInt("ddlYear");
		  }
		  if (box.getInt("ddlCropList") != 0) {
		    ddlCropList = box.getInt("ddlCropList");
		  }
		  if (box.getInt("ddlVarietyList") != 0) {
		    ddlVarietyList = box.getInt("ddlVarietyList");
		  }
		
		  
		  locationId = box.getInt("locationId");
		  
		  
		  Criteria cr = null;
		  cr = session.createCriteria(DgSeedQualityInspection.class);
		  cr= cr.add(Restrictions.or(Restrictions.eq("PaymentStatus", "Advance").ignoreCase(), Restrictions.eq("PaymentStatus", "Final").ignoreCase()));
		  cr= cr.add(Restrictions.eq("SeedQualityFlag", "Y").ignoreCase());
		
		  if (ddlSeason != 0)
		  {
		    cr = cr.createAlias("Season", "season");
		    cr = cr.add(Restrictions.eq("season.Id", Integer.valueOf(ddlSeason)));
		  }
		  if (ddlYear != 0)
		  {
		    cr = cr.createAlias("ProdYear", "yr");
		    cr = cr.add(Restrictions.eq("yr.Id", Integer.valueOf(ddlYear)));
		  }
		  if (ddlCropList != 0)
		  {
		    cr = cr.createAlias("Crop", "cr");
		    cr = cr.add(Restrictions.eq("cr.Id", Integer.valueOf(ddlCropList)));
		  }
		  if (ddlVarietyList != 0)
		  {
		    cr = cr.createAlias("SeedVariety", "vr");
		    cr = cr.add(Restrictions.eq("vr.Id", Integer.valueOf(ddlVarietyList)));
		  }
		
		  if (locationId != 0)
		  {
		    cr = cr.createAlias("Location", "centre");
		    cr = cr.add(Restrictions.eq("centre.Id", Integer.valueOf(locationId)));
		  }
		  cr = cr.addOrder(Order.desc("LastChgDate"));
		  List totalMatches = cr.list();
		  cr = cr.setFirstResult(pagingSize * (pageNo - 1));
		  cr = cr.setMaxResults(pagingSize);
		  pendingListForGrowerPayment = cr.list();
		  
		  int totalRecords = totalMatches.size();
		  totalMatches.clear();
		  

		  datamap.put("pendingListForGrowerPayment", pendingListForGrowerPayment);
		  datamap.put("totalRecords", Integer.valueOf(totalRecords));
		  
		  return datamap;
	}
	@Override
	public Map<String, Object> displayProductionPaymentJsp(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasStoreRate> rateList = new ArrayList<MasStoreRate>();
	List<ProdGrowerPayment> pastHistoryOfPayment  = new ArrayList<ProdGrowerPayment>();
	List<DgSeedQualityInspection> growerDetails = new ArrayList<DgSeedQualityInspection>();
	List<ProdGrowerDeductionDetails> growerDeductionDetails = new ArrayList<ProdGrowerDeductionDetails>();
	
	
	int locationId = box.getInt("locationId");
	
	int seedQualityid = box.getInt("Id");
	System.out.println("seedQualityid="+seedQualityid);
	
	
	Session session = (Session)getSession();
	Criteria cr = null;
	
	growerDetails = session.createCriteria(DgSeedQualityInspection.class).add(Restrictions.eq("Id", seedQualityid)).list();	
	pastHistoryOfPayment = session.createCriteria(ProdGrowerPayment.class).createAlias("SeedQuality", "dg").add(Restrictions.eq("dg.Id", seedQualityid)).list();
	
	int year = 0;
	int season= 0;
	int crop = 0;
	int variety = 0;
	int seed_class = 0;
	for(DgSeedQualityInspection list: growerDetails)
	{
		year = list.getProdYear().getId();
		 season= list.getSeason().getId();
		 crop = list.getCrop().getId();
		 variety = list.getSeedVariety().getId();
		 seed_class = list.getSeedClass().getId();
		 int firHeaderId =0;
			firHeaderId = list.getFirHeader().getId();
			
			List<ProdGrowerDeductionDetails> gd = new ArrayList<ProdGrowerDeductionDetails>();			
			cr = session.createCriteria(ProdGrowerDeductionDetails.class)
					      .createAlias("Fir", "firDetails").add(Restrictions.eq("firDetails.Id", firHeaderId));
			growerDeductionDetails=cr.list();
	}
	rateList = session.createCriteria(MasStoreRate.class).add(Restrictions.eq("Season.Id", season))
						.add(Restrictions.eq("Crop.Id", crop)).add(Restrictions.eq("Variety.Id", variety))
						.add(Restrictions.eq("ItemClass.Id", seed_class))
						.add(Restrictions.eq("Year.Id", year))
						.list();
	
	
	double purchase_rate = 0.0;
	for(MasStoreRate list : rateList)
	{
		purchase_rate = list.getBuyingRate().doubleValue();
	}
	
	
	rateList.clear();
	
	List<MasCropDuration> cropDuration = new ArrayList<MasCropDuration>();
	 
	 cropDuration = session.createCriteria(MasCropDuration.class)/*.add(Restrictions.eq("Season.Id", season))*/
				.add(Restrictions.eq("Crop.Id", crop)).add(Restrictions.eq("Variety.Id", variety))					
				.list();
	 
	 double SupervisionCharges = 0.0;
	 for(MasCropDuration listA : cropDuration)
		{
		 SupervisionCharges = listA.getSupervisionCharges().doubleValue();
		}
	 cropDuration.clear();
	 
	 
	map.put("purchase_rate", purchase_rate);
	map.put("growerDetails", growerDetails);
	map.put("pastHistoryOfPayment", pastHistoryOfPayment);
	map.put("growerDeductionDetails", growerDeductionDetails);
	map.put("SupervisionCharges", SupervisionCharges);
	
	
	
	return map;
	
	}
	@Override
	public Map<String, Object> submitProductionPaymentJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		boolean saved = false;
		
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			String date = (String) utilMap.get("currentDate");
			ProdGrowerPayment growerPayment = new ProdGrowerPayment();
			
			System.out.println("Id="+box.getInt("seedQualityId"));
			int seedQualityId =  box.getInt("seedQualityId");
			if(box.getInt("seedQualityId") != 0)
			{
				DgSeedQualityInspection dg= new DgSeedQualityInspection();
				dg.setId(box.getInt("seedQualityId"));
				growerPayment.setSeedQuality(dg);
				
			}
			growerPayment.setReceiptNo(box.getInt("receiptNo"));
			growerPayment.setPaymentType(box.getString("PaymentType"));
			growerPayment.setSeedPercentage(new BigDecimal(box.getDouble("AdvancePercentage")));
			growerPayment.setQuantity(new BigDecimal(box.getDouble("PaymentSeedQty")));
			
			System.out.println("rdRate="+box.getString("rdRate"));
			
			if(box.getString("rdRate").equalsIgnoreCase("MasterRate"))
			{				
				growerPayment.setRate(new BigDecimal(box.getDouble("rateMaster")));
			}
			
			if(box.getString("rdRate").equalsIgnoreCase("APMCRate"))
			{				
				growerPayment.setRate(new BigDecimal(box.getDouble("rateAPMC")));
			}		
			
			
			String PaymentType="";
			
			PaymentType = box.getString("PaymentType");
			if(PaymentType.equalsIgnoreCase("Advance"))
			{
				growerPayment.setAmount(new BigDecimal(box.getString("TotalAdvanceAmount")));
			}
			if(PaymentType.equalsIgnoreCase("Final"))
			{
				growerPayment.setAmount(new BigDecimal(box.getString("TotalFinalAmount")));
			}
			if(PaymentType.equalsIgnoreCase("Final"))
			{
				DgSeedQualityInspection dg = new DgSeedQualityInspection();
				dg = (DgSeedQualityInspection) hbt.get(DgSeedQualityInspection.class,seedQualityId);
				
				if(dg != null)
				{
					dg.setPaymentStatus("Settled");
					hbt.update(dg);
					hbt.refresh(dg);
				}
			}
			
			
			
			if(PaymentType.equalsIgnoreCase("Final"))
			{
				growerPayment.setRate(new BigDecimal(box.getDouble("ProcurementRate")));
			}
			
			
			
			growerPayment.setReceiptDate(HMSUtil.convertStringTypeDateToDateType(date));
			Users users = new Users();
			users.setId(box.getInt("CHANGED_BY"));
			growerPayment.setLastChgBy(users);
			growerPayment.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
			hbt.save(growerPayment);
			hbt.refresh(growerPayment);
			tx.commit();
			saved = true;
			
			}
		catch(Exception e)
		{
			System.out.print("e====="+e);
			if (tx != null) {
				tx.rollback();
			}
			
		}	
		
		
		map.put("saved", saved);
		return map;
		
			
			
		
		
	}
	
	@Override
	public Map<String, Object> addAccountGroupNew(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccountGroup> accountGroupList = new ArrayList<FaMasAccountGroup>();
		List<FaMasAccountGroup>faMasAccountGroupList=new ArrayList<FaMasAccountGroup>();
		List<FaMasAccountGroup> existingAccountGroupList = new ArrayList<FaMasAccountGroup>();
		
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		int  financialYearId = 0;
	
		String message = "";
		try {
			FaMasAccountGroup faMasAccountGroup = new FaMasAccountGroup();
			if(generalMap.get("fag")!= null){
				faMasAccountGroup = (FaMasAccountGroup)generalMap.get("fag");
			}
			Box box =null;
			if(generalMap.get("box")!= null){
				box = (Box)generalMap.get("box");
			}
			Integer groupCode = faMasAccountGroup.getAccountGroupCode();
			String groupDesc = faMasAccountGroup.getAccountGroupDesc();
			
			if(generalMap.get("fYear")!= null){
				financialYearId =(Integer)generalMap.get("fYear");
			}
			
			int groupId =0;
			if(generalMap.get("accountgroupId")!= null){
				groupId = (Integer)generalMap.get("accountgroupId");
			}
			int subGroupId =0;
			if(generalMap.get("accountSubGroupId")!= null){
				subGroupId = (Integer)generalMap.get("accountSubGroupId");
			}
			
			BigDecimal openingBalanceDr = new BigDecimal(0);
			BigDecimal openingBalanceCr = new BigDecimal(0);
			if(generalMap.get("opDrBalance")!= null){
				openingBalanceDr =(BigDecimal)generalMap.get("opDrBalance");
			}else if(generalMap.get("opCrBalance")!= null){
				openingBalanceCr =(BigDecimal)generalMap.get("opCrBalance");
			}
			
			existingAccountGroupList = session.createCriteria(FaMasAccountGroup.class)
					.add(Restrictions.eq("AccountGroupCode", groupCode))
									/*.add(Restrictions.eq("FYear.Id", 1))*/
									.list();
			if (existingAccountGroupList.size() > 0) {
				message = "Record already Exist";
			} else {
				hbt.save(faMasAccountGroup);
				message = "Record saved successfully!";

//-----------------------For Branch Account master------------------------------------------
		//---------commented by anamika on 10/08/2014----------------
				/*int count = 0;
				if(box.getInt("totalBranchId")!= 0){
					count = box.getInt("totalBranchId");
				}
				for (int i = 1; i <= count; i++) {
					FaBranchAccountMaster branchAccountMaster = new FaBranchAccountMaster();
					if(box.getInt("branchId"+i)!=0 ){
						MasBranch masBranch = new MasBranch();
						masBranch.setId(box.getInt("branchId"+i));
						branchAccountMaster.setBranch(masBranch);
						branchAccountMaster.setAccount(faMasAccount);

						if(!box.getString("opBalanceDr"+i).equals("") ){
							branchAccountMaster.setOpBalanceDr(new BigDecimal(box.getString("opBalanceDr"+i)));
							branchAccountMaster.setClBalanceDr(new BigDecimal(box.getString("opBalanceDr"+i)));
						}else if(!box.getString("opBalanceCr"+i).equals("")){
							branchAccountMaster.setOpBalanceCr(new BigDecimal(box.getString("opBalanceCr"+i)));
							branchAccountMaster.setClBalanceCr(new BigDecimal(box.getString("opBalanceCr"+i)));
						}
						hbt.save(branchAccountMaster);

					}
				}*/

			//----------------update account group--------------
			}
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//--------------------------------------------------------------
		faMasAccountGroupList = session.createCriteria(FaMasAccountGroup.class).add(Restrictions.eq("Status", "y"))
				.list();
		map.put("faMasAccountGroupList", faMasAccountGroupList);
		map.put("message", message);
		return map;
	}
	
	
	@Override
	public MasStoreFinancial getFinancialYear() {
		Date dt = new Date();
		List<MasStoreFinancial> finacialList = new ArrayList<MasStoreFinancial>();
		Session session = (Session)getSession();
		finacialList = session.createCriteria(MasStoreFinancial.class)
		        .add(Restrictions.eq("Status", "y").ignoreCase())
		        .add(Restrictions.le("StartDate", dt))
		        .add(Restrictions.ge("EndDate", dt)).list();
		return finacialList.get(0);
	}
	
	@Override
	public Map<String, Object> showGrowerPaymentJsp(Box box) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Map<String, Object> updateAccountGroupNew(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccountGroup> faMasAccountGroupList = new ArrayList<FaMasAccountGroup>();
		List<FaMasAccountGroup> existingAccountList = new ArrayList<FaMasAccountGroup>();
		Session session = (Session)getSession();
		String message = "";
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		try {
			existingAccountList = session.createCriteria(FaMasAccountGroup.class)
					.add(Restrictions.eq("AccountGroupCode", box.getInt(SEARCH_NAME)))
					.add(Restrictions.ne("Id", box.getInt("accountId")))
					.list();
			System.out.println("existingAccountList.size()=====>>"+existingAccountList.size());
			/*if (existingAccountList.size() > 0) {
				message = "Record already Exist";
			}*/// else {
System.out.println("box.getInt(accountId)============>>"+box.getInt("accountId"));
System.out.println("code====>>>"+box.getString(SEARCH_NAME));

				for(FaMasAccountGroup faMasAccountGroup:existingAccountList){// = (FaMasAccountGroup) hbt.load(FaMasAccount.class,box.getInt("accountId"));
				faMasAccountGroup.setAccountGroupDesc(box.getString("discription"));
			
			
			MasStoreFinancial masStoreFinancial = new MasStoreFinancial();
			masStoreFinancial.setId(box.getInt("fYear"));
			faMasAccountGroup.setFYear(masStoreFinancial);
			
			Users user = new Users();
			user.setId(box.getInt("changedBy"));
			faMasAccountGroup.setLastChgBy(user);
			
			
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			String date = (String) utilMap.get("currentDate");
			String time = (String) utilMap.get("currentTime");

			faMasAccountGroup.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(date));
			faMasAccountGroup.setLastChgTime(time);
			hbt.update(faMasAccountGroup);
			message = "Record updated successfully!";
//----------------------------------------------calculation for last Balance---------------------------------
			
			}
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		faMasAccountGroupList = session.createCriteria(FaMasAccountGroup.class).add(Restrictions.eq("Status", "y"))
				.createAlias("FYear", "fy")
				//.add(Restrictions.eq("fy.Id", box.getInt("fYear")))
				
				.list();
		map.put("faMasAccountGroupList", faMasAccountGroupList);
		map.put("message",message);
		return map;
	}
	@Override
	public Map<String, Object> deleteAccountGroupNew(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccountGroup> faMasAccountGroupList = new ArrayList<FaMasAccountGroup>();
	
		List<FaMasAccountGroup> existingAccountList = new ArrayList<FaMasAccountGroup>();
		Session session = (Session)getSession();
		String message = "";
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		try {
			existingAccountList = session.createCriteria(FaMasAccountGroup.class)
					.add(Restrictions.eq("AccountGroupCode", box.getInt(SEARCH_NAME)))
					.add(Restrictions.ne("Id", box.getInt("accountId")))
					.list();
			System.out.println("existingAccountList.size()=====>>"+existingAccountList.size());
			/*if (existingAccountList.size() > 0) {
				message = "Record already Exist";
			}*/// else {
System.out.println("box.getInt(accountId)============>>"+box.getInt("accountId"));
System.out.println("code====>>>"+box.getString(SEARCH_NAME));

				for(FaMasAccountGroup faMasAccountGroup:existingAccountList){// = (FaMasAccountGroup) hbt.load(FaMasAccount.class,box.getInt("accountId"));

					if(box.getString("flag").equals("InActivate")){
						faMasAccountGroup.setStatus("n");
					}else if(box.getString("flag").equals("Activate")){
						faMasAccountGroup.setStatus("y");
					}
			MasStoreFinancial masStoreFinancial = new MasStoreFinancial();
			masStoreFinancial.setId(box.getInt("fYear"));
			faMasAccountGroup.setFYear(masStoreFinancial);
			
			Users user = new Users();
			user.setId(box.getInt("changedBy"));
			faMasAccountGroup.setLastChgBy(user);
			
			
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			String date = (String) utilMap.get("currentDate");
			String time = (String) utilMap.get("currentTime");

			faMasAccountGroup.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(date));
			faMasAccountGroup.setLastChgTime(time);
			hbt.update(faMasAccountGroup);
			message = "Record update successfully!";
//----------------------------------------------calculation for last Balance---------------------------------
			
			}
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		faMasAccountGroupList = session.createCriteria(FaMasAccountGroup.class)//.add(Restrictions.eq("Status", "y"))
				//.createAlias("FYear", "fy")
				//.add(Restrictions.eq("fy.Id", box.getInt("fYear")))
				.list();
		map.put("faMasAccountGroupList", faMasAccountGroupList);
		map.put("message",message);
		return map;
	}
	@Override
	public Map<String, Object> showAccountSubGroupNew(Map<String, Object> generalMap) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccountSubGroup> faMasAccountSubGroupList = new ArrayList<FaMasAccountSubGroup>();
		List<FaMasAccountGroup> faMasAccountGroupList = new ArrayList<FaMasAccountGroup>();
		List<FaMasAccountGroup> gridMasAccountGroupList = new ArrayList<FaMasAccountGroup>();
		Session session = (Session)getSession();
		int fYear = 0;
		int locationId = 0;
		if(generalMap.get("fYear")!= null){
			fYear = (Integer)generalMap.get("fYear");
		}
		if(generalMap.get("locationId")!= null){
			locationId = (Integer)generalMap.get("locationId");
		}
		faMasAccountGroupList = session.createCriteria(FaMasAccountGroup.class).add(Restrictions.eq("Status", "y"))
								/*.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", 1))*/
								.list();
		gridMasAccountGroupList=session.createCriteria(FaMasAccountGroup.class).add(Restrictions.eq("Status", "y"))
				/*.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", 1))*/
				.list();
		faMasAccountSubGroupList=session.createCriteria(FaMasAccountSubGroup.class)//.add(Restrictions.eq("Status", "y"))
				/*.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", 1))*/
				.list();
		System.out.println("faMasAccountGroupList=====>>"+faMasAccountGroupList.size());
		map.put("faMasAccountGroupList", faMasAccountGroupList);
		map.put("faMasAccountSubGroupList",faMasAccountSubGroupList);
		map.put("gridMasAccountGroupList",gridMasAccountGroupList);
		return map;
	}
	@Override
	public Map<String, Object> addAccountSubGroupNew(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccountSubGroup> faMasAccountSubGroupList = new ArrayList<FaMasAccountSubGroup>();
		List<FaMasAccountGroup> faMasAccountGroupList = new ArrayList<FaMasAccountGroup>();
		List<FaMasAccountGroup> gridMasAccountGroupList = new ArrayList<FaMasAccountGroup>();
		List<FaMasAccountSubGroup> existingAccountSubGroupList = new ArrayList<FaMasAccountSubGroup>();
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		int  financialYearId = 0;
	
		String message = "";
		try {
			FaMasAccountSubGroup faMasAccountGroup = new FaMasAccountSubGroup();
			if(generalMap.get("fasg")!= null){
				faMasAccountGroup = (FaMasAccountSubGroup)generalMap.get("fasg");
			}
			Box box =null;
			if(generalMap.get("box")!= null){
				box = (Box)generalMap.get("box");
			}
			Integer groupCode = faMasAccountGroup.getAccountSubGroupCode();
			String groupDesc = faMasAccountGroup.getAccountSubGroupName();
			
			if(generalMap.get("fYear")!= null){
				financialYearId =(Integer)generalMap.get("fYear");
			}
			
			int groupId =0;
			if(generalMap.get("accountgroupId")!= null){
				groupId = (Integer)generalMap.get("accountgroupId");
			}
			int subGroupId =0;
			if(generalMap.get("accountSubGroupId")!= null){
				subGroupId = (Integer)generalMap.get("accountSubGroupId");
			}
			
			BigDecimal openingBalanceDr = new BigDecimal(0);
			BigDecimal openingBalanceCr = new BigDecimal(0);
			if(generalMap.get("opDrBalance")!= null){
				openingBalanceDr =(BigDecimal)generalMap.get("opDrBalance");
			}else if(generalMap.get("opCrBalance")!= null){
				openingBalanceCr =(BigDecimal)generalMap.get("opCrBalance");
			}
		
			existingAccountSubGroupList = session.createCriteria(FaMasAccountSubGroup.class)
					.add(Restrictions.eq("AccountSubGroupCode", groupCode))
									/*.add(Restrictions.eq("FYear.Id", 1))*/
									.list();
			if (existingAccountSubGroupList.size() > 0) {
				message = "Record already Exist";
			} else {
				hbt.save(faMasAccountGroup);
				message = "Record saved successfully!";

//-----------------------For Branch Account master------------------------------------------
		//---------commented by anamika on 10/08/2014----------------
				/*int count = 0;
				if(box.getInt("totalBranchId")!= 0){
					count = box.getInt("totalBranchId");
				}
				for (int i = 1; i <= count; i++) {
					FaBranchAccountMaster branchAccountMaster = new FaBranchAccountMaster();
					if(box.getInt("branchId"+i)!=0 ){
						MasBranch masBranch = new MasBranch();
						masBranch.setId(box.getInt("branchId"+i));
						branchAccountMaster.setBranch(masBranch);
						branchAccountMaster.setAccount(faMasAccount);

						if(!box.getString("opBalanceDr"+i).equals("") ){
							branchAccountMaster.setOpBalanceDr(new BigDecimal(box.getString("opBalanceDr"+i)));
							branchAccountMaster.setClBalanceDr(new BigDecimal(box.getString("opBalanceDr"+i)));
						}else if(!box.getString("opBalanceCr"+i).equals("")){
							branchAccountMaster.setOpBalanceCr(new BigDecimal(box.getString("opBalanceCr"+i)));
							branchAccountMaster.setClBalanceCr(new BigDecimal(box.getString("opBalanceCr"+i)));
						}
						hbt.save(branchAccountMaster);

					}
				}*/

			//----------------update account group--------------
			}
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//--------------------------------------------------------------
		faMasAccountGroupList = session.createCriteria(FaMasAccountGroup.class).add(Restrictions.eq("Status", "y"))
				/*.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", 1))*/
				.list();
gridMasAccountGroupList=session.createCriteria(FaMasAccountGroup.class).add(Restrictions.eq("Status", "y"))
/*.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", 1))*/
.list();
faMasAccountSubGroupList=session.createCriteria(FaMasAccountSubGroup.class).add(Restrictions.eq("Status", "y"))
/*.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", 1))*/

.list();
System.out.println("faMasAccountGroupList=====>>"+faMasAccountGroupList.size());
map.put("faMasAccountGroupList", faMasAccountGroupList);
map.put("faMasAccountSubGroupList",faMasAccountSubGroupList);
map.put("gridMasAccountGroupList",gridMasAccountGroupList);
		map.put("message", message);
		return map;
	}
	@Override
	public boolean updateAccountSubGroupNew(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int districtId = 0;
		String blockName = "";
		@SuppressWarnings("unused")
		String blockCode = "";
		int blockId = 0;
		Integer userId= 0;
		blockId = (Integer) generalMap.get("id");
		blockCode = (String) generalMap.get("blockCode");
		blockName = (String) generalMap.get("name");
		districtId = (Integer) generalMap.get("districtId");
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		FaMasAccountSubGroup masBlock = (FaMasAccountSubGroup) getHibernateTemplate().get(
				FaMasAccountSubGroup.class, blockId);

		masBlock.setId(blockId);
		masBlock.setAccountSubGroupName(blockName);

		   if(districtId != 0){
			   FaMasAccountGroup district = new FaMasAccountGroup();
			   district.setId(districtId);
			   masBlock.setAccountGroup(district);
			   }

		Users user = new Users();
		user.setId(userId);
		masBlock.setLastChgBy(user);
		
		masBlock.setLastChgDate(currentDate);
		masBlock.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masBlock);
		dataUpdated = true;
		return dataUpdated;
	}
	@Override
	public boolean deleteAccountSubGroupNew(int accountGroupId,Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		Session session = (Session)getSession();
		int userId = 0;
		
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
			FaMasAccountSubGroup masBlock = new FaMasAccountSubGroup();
			masBlock = (FaMasAccountSubGroup) getHibernateTemplate().get(
					FaMasAccountSubGroup.class, accountGroupId);
			@SuppressWarnings("unused")
			Integer districtId = masBlock.getAccountGroup().getId();
			userId = (Integer) generalMap.get("userId");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			
			List disrictList = session.createCriteria(FaMasAccountSubGroup.class).add(Restrictions.eq("Id", districtId))
					//.add(Restrictions.eq("Status", "y"))
					.list();
			
			if (flag.equals("InActivate")) {
				masBlock.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masBlock.setStatus("y");
				dataDeleted = false;
			}
		}
		Users user = new Users();
		user.setId(userId);
		masBlock.setLastChgBy(user);
		
		masBlock.setLastChgDate(currentDate);
		masBlock.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masBlock);
		return dataDeleted;
	}
	@Override
	public Map<String, Object> searchAccountGroupNew(Map<String, Object> generalMap) {
		Map<String, Object>map=new HashMap<String,Object>();
		String accountGroupName="";
		if(generalMap.get("accountGroupName")!=null && !generalMap.get("accountGroupName").equals("")){
			accountGroupName=(String)generalMap.get("accountGroupName");
		}
		Session session=(Session)getSession();
		List<FaMasAccountGroup>faMasAccountGroupList=new ArrayList<FaMasAccountGroup>();
		
		faMasAccountGroupList = session.createCriteria(FaMasAccountGroup.class)//.add(Restrictions.eq("Status", "y"))
		.add(Restrictions.like("AccountGroupDesc", "%"+accountGroupName+"%")).list();
		
		map.put("faMasAccountGroupList",faMasAccountGroupList);
		return map;
		
	}
	@Override
	public Map<String, Object> searchAccountSubGroup(
			Map<String, Object> generalMap) {
		Map<String, Object>map=new HashMap<String,Object>();
		String accountGroupName="";
		if(generalMap.get("accountGroupName")!=null && !generalMap.get("accountGroupName").equals("")){
			accountGroupName=(String)generalMap.get("accountGroupName");
		}
		int radioValue=0;
		if(generalMap.get("radioValue")!=null && !generalMap.get("radioValue").equals("0")){
			radioValue=(Integer)generalMap.get("radioValue");
		}
		Session session=(Session)getSession();
		
		List<FaMasAccountSubGroup>faMasAccountSubGroupList=new ArrayList<FaMasAccountSubGroup>();
		List<FaMasAccountGroup>gridMasAccountGroupList=new ArrayList<FaMasAccountGroup>();
		gridMasAccountGroupList=session.createCriteria(FaMasAccountGroup.class).add(Restrictions.eq("Status", "y")).list();
		System.out.println("generalMap dataservice===>"+generalMap);
		if(radioValue==1){
			faMasAccountSubGroupList = session.createCriteria(FaMasAccountSubGroup.class)//.add(Restrictions.eq("Status", "y"))
		.add(Restrictions.like("AccountSubGroupCode", Integer.parseInt(accountGroupName))).list();
		}else if(radioValue==2){
			faMasAccountSubGroupList = session.createCriteria(FaMasAccountSubGroup.class)//.add(Restrictions.eq("Status", "y"))
		.add(Restrictions.like("AccountSubGroupName","%"+accountGroupName+"%")).list();
		}
		
		map.put("faMasAccountSubGroupList",faMasAccountSubGroupList);
		map.put("gridMasAccountGroupList",gridMasAccountGroupList);
		return map;
		
	}
	@Override
	public Map<String, Object> showAccountMasterNew(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccount> faMasAccountList = new ArrayList<FaMasAccount>();
		List<FaMasAccount> mainAccountList = new ArrayList<FaMasAccount>();
		List<FaMasAccountSubGroup> faMasAccountSubGroupList = new ArrayList<FaMasAccountSubGroup>();
		List<FaMasAccountSubGroup> gridMasAccountSubGroupList = new ArrayList<FaMasAccountSubGroup>();
		List<FaMasAccountGroup> faMasAccountGroupList = new ArrayList<FaMasAccountGroup>();
		List<FaMasAccountGroup> gridMasAccountGroupList = new ArrayList<FaMasAccountGroup>();
		List<MasScheduleMaster> existingScheduleList = new ArrayList<MasScheduleMaster>();
		Session session = (Session)getSession();
		int fYear = 0;
		int locationId = 0;
		if(generalMap.get("fYear")!= null){
			fYear = (Integer)generalMap.get("fYear");
		}
		if(generalMap.get("locationId")!= null){
			locationId = (Integer)generalMap.get("locationId");
		}
		faMasAccountList=session.createCriteria(FaMasAccount.class)
				//.add(Restrictions.eq("Status", "y"))
				/*.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", 1))*/
				.list();
		mainAccountList=session.createCriteria(FaMasAccount.class)
				.add(Restrictions.eq("Status", "y"))
				/*.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", 1))*/
				.list();
		faMasAccountGroupList = session.createCriteria(FaMasAccountGroup.class).add(Restrictions.eq("Status", "y"))
								/*.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", 1))*/
								.list();
		gridMasAccountGroupList=session.createCriteria(FaMasAccountGroup.class).add(Restrictions.eq("Status", "y"))
				/*.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", 1))*/
				.list();
		faMasAccountSubGroupList=session.createCriteria(FaMasAccountSubGroup.class).add(Restrictions.eq("Status", "y"))
				/*.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", 1))*/
				.list();
		gridMasAccountSubGroupList=session.createCriteria(FaMasAccountSubGroup.class).add(Restrictions.eq("Status", "y"))
				/*.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", 1))*/
				.list();
		
		existingScheduleList = session.createCriteria(MasScheduleMaster.class).add(Restrictions.eq("Status", "y")).list();
		map.put("faMasAccountGroupList", faMasAccountGroupList);
		map.put("faMasAccountSubGroupList",faMasAccountSubGroupList);
		map.put("gridMasAccountGroupList",gridMasAccountGroupList);
		map.put("existingScheduleList",existingScheduleList);
		map.put("faMasAccountList",faMasAccountList);
		map.put("mainAccountList",mainAccountList);
		map.put("gridMasAccountSubGroupList",gridMasAccountSubGroupList);
		return map;
	}
	@Override
	public boolean editAccountMasterNew(Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean editAccountMaster(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int accountgroupId = 0;
		String accDesc = "";
		@SuppressWarnings("unused")
		int accountCode = 0;
		int faMasAccountId = 0;
		Integer userId= 0;
		int accountId=0;
		int fYear=0;
		String subLedgerStatus="";
		String parentStatus="";
		String accountRight="";
		int bankId=0;
		int schedule=0;
		int accountSubGroupId=0;
		fYear = (Integer) generalMap.get("fYear");
		faMasAccountId = (Integer) generalMap.get("id");
		accountCode = (Integer) generalMap.get("accountCode");
		accDesc = (String) generalMap.get("name");
		Session session = (Session)getSession();
		accountgroupId= (Integer) generalMap.get("accountgroupId");
		accountSubGroupId= (Integer) generalMap.get("accountSubGroupId");
		accountId = (Integer) generalMap.get("accountId");
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		accountRight= (String) generalMap.get("accountRight");
		bankId= (Integer) generalMap.get("bankId");
		parentStatus = (String) generalMap.get("parentStatus");
		subLedgerStatus = (String) generalMap.get("subLedgerStatus");
		
		schedule= (Integer) generalMap.get("schedule");

		FaMasAccount faMasAccount = (FaMasAccount) getHibernateTemplate().get(
				FaMasAccount.class, faMasAccountId);

		FaMasAccountSubGroup faMasAccountSubGroup = new FaMasAccountSubGroup();
		faMasAccountSubGroup.setId(accountSubGroupId);
		faMasAccount.setAccountSubGroup(faMasAccountSubGroup);
		
		MasStoreFinancial masStoreFinancial = new MasStoreFinancial();
		masStoreFinancial.setId(fYear);
		faMasAccount.setFYear(masStoreFinancial);
		
		if(!parentStatus.equals("")){
			faMasAccount.setParentStatus(parentStatus);
		}
		if(!subLedgerStatus.equals("")){
			faMasAccount.setSubLedger(subLedgerStatus);
		}
		
		faMasAccount.setSchedule(schedule);
		
		faMasAccount.setId(faMasAccountId);
		faMasAccount.setAccDesc(accDesc);
		if(!accountRight.equals("")){
			faMasAccount.setAccountRight(accountRight);
		}
		if(bankId!=0){
		MasBankMaster masBankMaster = new MasBankMaster();
		masBankMaster.setId(bankId);
		faMasAccount.setBank(masBankMaster);
		}
		if(accountId!=0){
		FaMasAccount famasAccount2 = new FaMasAccount();
		famasAccount2.setId(accountId);
		faMasAccount.setParent(famasAccount2);
		}
		
		faMasAccount.setStatus("y");
		faMasAccount.setOpBalanceCr(new BigDecimal(0));
		faMasAccount.setOpBalanceDr(new BigDecimal(0));
		faMasAccount.setYtdAmountCr(new BigDecimal(0));
		faMasAccount.setYtdAmountDr(new BigDecimal(0));
		faMasAccount.setClBalanceCr(new BigDecimal(0));
		faMasAccount.setClBalanceDr(new BigDecimal(0));
		Users user = new Users();
		user.setId(userId);
		faMasAccount.setLastChgBy(user);
		
		faMasAccount.setLastChgDate(currentDate);
		faMasAccount.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(faMasAccount);
		session.refresh(faMasAccount);
		dataUpdated = true;
		return dataUpdated;
	}
	
	
	@Override
	public Map<String, Object> submitOpeningBalance(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		String voucherNo="";
		int vhId=0;
		int approvalStatus = Integer.parseInt(HMSUtil.getProperties("adt.properties", "approvedId"));
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session)getSession();
		Transaction tx = null;
		boolean saved = false;
		try {
			tx = session.beginTransaction();
			FaVoucherHeader voucherHeader = new FaVoucherHeader();
			MasStoreFinancial masStoreFinancial =new MasStoreFinancial();
			masStoreFinancial.setId(box.getInt("fYear"));
			voucherHeader.setFYear(masStoreFinancial);
			MasHospital hospital = new MasHospital();
			hospital.setId(box.getInt("locationId"));
			voucherHeader.setHospital(hospital);
			voucherHeader.setVoucherType("OP");
			voucherHeader.setVoucherDate(HMSUtil.convertStringTypeDateToDateType(box.getString(VOUCHER_DATE)));
			voucherHeader.setVoucherTime(box.getString(CHANGED_TIME));
			voucherHeader.setStatus("y");
			voucherHeader.setNarration(box.getString(NARRATION));
			if(!box.getString(TOTAL_DR_AMOUNT).equals("")){
				voucherHeader.setDrAmount(new BigDecimal(box.getString(TOTAL_DR_AMOUNT)));
			}
			if(!box.getString(TOTAL_CR_AMOUNT).equals("")){
				voucherHeader.setCrAmount(new BigDecimal(box.getString(TOTAL_CR_AMOUNT)));
			}
			Users user = new Users();
			user.setId(box.getInt("changedBy"));
			voucherHeader.setLastChgBy(user);
			
			MasApprovalStatus masApprovalStatus = new MasApprovalStatus();
			masApprovalStatus.setId(approvalStatus);
			voucherHeader.setApprovalStatus(masApprovalStatus);
			voucherHeader.setAcknowedgeStatus(masApprovalStatus);

			voucherHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			voucherHeader.setLastChgTime(box.getString(CHANGED_TIME));
			paramMap.put("locationId", box.getInt("locationId"));
			paramMap.put("suffix", box.getString("fYearDesc"));
			paramMap.put("flag", "save");
			paramMap.put("prefix", "OP");
			paramMap.put("voucherType", "Opening");
			paramMap.put("financialYearId", box.getInt("fYear"));
			
			map.put("tableObjectName", "FaVoucherHeader");			
			map.put("isHospitalWise", "y");
			map.put("hospitalId", box.getInt("locationId")); 
			/*map.put("isDivisionWise", "n");
			map.put("divisionId", box.getInt("divisionId"));*/
			map.put("isYearly", "y");			
			/*map.put("isMonthly", "n");*/
			map.put("isPrefix", "y");
			map.put("transactionPrefixProperty", "transactionPrefixForOpeningBalance");		
			voucherNo = HMSUtil.generateTransactionSequence(map, session, hbt);
			
			/*int voucherNo = generateVoucherNo(paramMap);*/
			String locationCode="";
			String yearDesc="";
			List<MasStoreFinancial>financialList=new ArrayList<MasStoreFinancial>();
			List<MasHospital>hospitalList=new ArrayList<MasHospital>();
			hospitalList=session.createCriteria(MasHospital.class).add(Restrictions.idEq(box.getInt("locationId"))).list();
			for(MasHospital mg:hospitalList){
				locationCode=mg.getHospitalCode();
			}
			financialList=session.createCriteria(MasStoreFinancial.class).add(Restrictions.idEq(box.getInt("fYear"))).list();
			
			voucherHeader.setVoucherNo(voucherNo);
		
			hbt.save(voucherHeader);

			int counter = box.getInt("hiddenValueCharge");
			for (int i = 1; i <= counter; i++) {
				int accountId = 0;
				BigDecimal crAmt = new BigDecimal(0.00);
				BigDecimal drAmt = new BigDecimal(0.00);

				FaVoucherDetails voucherDetails = new FaVoucherDetails();
				FaMasAccount account = new FaMasAccount();
				accountId = box.getInt("accountId"+i);
				account.setId(accountId);
				voucherDetails.setAccount(account);
				voucherDetails.setVoucherHeader(voucherHeader);
				if(box.getInt(SUB_LEDGER_CODE+i) != 0){					
					FaMasSubLed subLed= new FaMasSubLed();
					subLed.setId(box.getInt(SUB_LEDGER_CODE+i));
					voucherDetails.setSubLed(subLed);
					
				}
				if(box.getInt(COST_CENTER_ID+i) != 0){
					MasCostCenter costCenter = new MasCostCenter();
					costCenter.setId(box.getInt(COST_CENTER_ID+i));
					voucherDetails.setCostCenter(costCenter);
				}
				voucherDetails.setNarration(box.getString(ACCOUNT_NARRATION+i));
				voucherDetails.setReconcile("n");
				if(!box.getString(CR_AMOUNT+i).equals("")){
					crAmt = new BigDecimal(box.getString(CR_AMOUNT+i));
					voucherDetails.setCrAmount(crAmt);
				}
				if(!box.getString(DR_AMOUNT+i).equals("")){
					drAmt = new BigDecimal(box.getString(DR_AMOUNT+i));
					voucherDetails.setDrAmount(drAmt);
				}
				
				hbt.save(voucherDetails);

				List<AccountGroupTransac>actList=new ArrayList<AccountGroupTransac>();
				actList=session.createCriteria(AccountGroupTransac.class)
							    .add(Restrictions.eq("AccountGroup.Id", box.getInt("groupId"+i)))
							    .add(Restrictions.eq("Centre.Id",box.getInt("locationId")))
							    .add(Restrictions.eq("FinancialYear.Id", box.getInt("fYear")))
						.list();
				if(actList.size()==0){
					AccountGroupTransac agt=new AccountGroupTransac();
					
					FaMasAccountGroup fmag=new FaMasAccountGroup();					
					fmag.setId(box.getInt("groupId"+i));
					agt.setAccountGroup(fmag);
					
					if(!box.getString(CR_AMOUNT+i).equals("")){
						crAmt = new BigDecimal(box.getString(CR_AMOUNT+i));
						agt.setOpBalanceCr(crAmt);
						agt.setClBalanceCr(crAmt);
						agt.setOpBalanceDr(new BigDecimal(0));
						agt.setClBalanceDr(new BigDecimal(0));
					}
					if(!box.getString(DR_AMOUNT+i).equals("")){
						drAmt = new BigDecimal(box.getString(DR_AMOUNT+i));
						agt.setOpBalanceDr(drAmt);
						agt.setOpBalanceCr(new BigDecimal(0));
						agt.setClBalanceDr(drAmt);
						agt.setOpBalanceCr(new BigDecimal(0));
						agt.setOpBalanceCr(new BigDecimal(0));
						agt.setClBalanceCr(new BigDecimal(0));
					}
					
					Map<String, Object> utilMap = new HashMap<String, Object>();
					utilMap = (Map) HMSUtil.getCurrentDateAndTime();
					String date = (String) utilMap.get("currentDate");
					String time = (String) utilMap.get("currentTime");

					
					agt.setTransactionDate(HMSUtil.convertStringTypeDateToDateType(date));
					agt.setTransactionTime(time);
					agt.setYtdAmountCr(new BigDecimal(0));
					agt.setYtdAmountDr(new BigDecimal(0));
					MasStoreFinancial msf=new MasStoreFinancial();
					msf.setId(box.getInt("fYear"));
					agt.setFinancialYear(msf);
					
					MasHospital mh =new MasHospital();
					mh.setId(box.getInt("locationId"));
					agt.setCentre(mh);
					
					
					hbt.save(agt);
					
				}else if(actList.size()>0){
					for(AccountGroupTransac acgt:actList){
						Map<String, Object> utilMap = new HashMap<String, Object>();
						utilMap = (Map) HMSUtil.getCurrentDateAndTime();
						String date = (String) utilMap.get("currentDate");
						String time = (String) utilMap.get("currentTime");
						acgt.setTransactionDate(HMSUtil.convertStringTypeDateToDateType(date));
						acgt.setTransactionTime(time);
						if(!box.getString(CR_AMOUNT+i).equals("")){
							crAmt = new BigDecimal(box.getString(CR_AMOUNT+i));
							 
							BigDecimal crAmountSubLedger1=new BigDecimal(0);
							BigDecimal drAmountSubLedger1=new BigDecimal(0);
								crAmountSubLedger1 = acgt.getOpBalanceCr().add(acgt.getYtdAmountCr()).add(crAmt);
								drAmountSubLedger1 = acgt.getOpBalanceDr().add(acgt.getYtdAmountDr());
								
								if(drAmountSubLedger1.compareTo(crAmountSubLedger1)>0){
									acgt.setClBalanceDr(drAmountSubLedger1.subtract(crAmountSubLedger1));
									acgt.setClBalanceCr(new BigDecimal(0.00));
								}else if(crAmountSubLedger1.compareTo(drAmountSubLedger1)>0){
									acgt.setClBalanceCr(crAmountSubLedger1.subtract(drAmountSubLedger1));
									acgt.setClBalanceDr(new BigDecimal(0.00));
								}else if(crAmountSubLedger1.compareTo(drAmountSubLedger1)==0){
									acgt.setClBalanceCr(new BigDecimal(0.00));
									acgt.setClBalanceDr(new BigDecimal(0.00));
								}
								
								
								
								
							acgt.setOpBalanceCr(acgt.getOpBalanceCr().add(crAmt));
						/*	acgt.setClBalanceCr(acgt.getClBalanceCr().add(crAmt));*/
						}
						if(!box.getString(DR_AMOUNT+i).equals("")){
							drAmt = new BigDecimal(box.getString(DR_AMOUNT+i));
							BigDecimal crAmountSubLedger11=new BigDecimal(0);
							BigDecimal drAmountSubLedger11=new BigDecimal(0);
								crAmountSubLedger11 = acgt.getOpBalanceCr().add(acgt.getYtdAmountCr());
								drAmountSubLedger11 = acgt.getOpBalanceDr().add(acgt.getYtdAmountDr()).add(drAmt);
								
								if(drAmountSubLedger11.compareTo(crAmountSubLedger11)>0){
									acgt.setClBalanceDr(drAmountSubLedger11.subtract(crAmountSubLedger11));
									acgt.setClBalanceCr(new BigDecimal(0.00));
								}else if(crAmountSubLedger11.compareTo(drAmountSubLedger11)>0){
									acgt.setClBalanceCr(crAmountSubLedger11.subtract(drAmountSubLedger11));
									acgt.setClBalanceDr(new BigDecimal(0.00));
								}else if(crAmountSubLedger11.compareTo(drAmountSubLedger11)==0){
									acgt.setClBalanceCr(new BigDecimal(0.00));
									acgt.setClBalanceDr(new BigDecimal(0.00));
								}
								
								
							
							
							
/*							acgt.setClBalanceDr(acgt.getClBalanceDr().add(drAmt));*/
							acgt.setOpBalanceDr(acgt.getOpBalanceDr().add(drAmt));
						}
						hbt.update(acgt);
						
					}
					
				}
				List<AccountSubGroupTransac>acstList=new ArrayList<AccountSubGroupTransac>();
				acstList=session.createCriteria(AccountSubGroupTransac.class)
							    .add(Restrictions.eq("SubGroup.Id",box.getInt("subGroupId"+i)))
							    .add(Restrictions.eq("Location.Id",box.getInt("locationId")))
							    .add(Restrictions.eq("FYear.Id", box.getInt("fYear")))
						.list();
				if(actList.size()==0){
					AccountSubGroupTransac agt=new AccountSubGroupTransac();
					
					FaMasAccountSubGroup fmasg=new FaMasAccountSubGroup();					
					fmasg.setId(box.getInt("subGroupId"+i));
					agt.setSubGroup(fmasg);
					
					if(!box.getString(CR_AMOUNT+i).equals("")){
						crAmt = new BigDecimal(box.getString(CR_AMOUNT+i));
						agt.setOpBalanceCr(crAmt);
						agt.setClBalanceCr(crAmt);
						agt.setOpBalanceDr(new BigDecimal(0));
						agt.setClBalanceDr(new BigDecimal(0));
					}
					if(!box.getString(DR_AMOUNT+i).equals("")){
						drAmt = new BigDecimal(box.getString(DR_AMOUNT+i));
						agt.setOpBalanceDr(drAmt);
						agt.setOpBalanceCr(new BigDecimal(0));
						agt.setClBalanceDr(drAmt);
						agt.setOpBalanceCr(new BigDecimal(0));
						agt.setOpBalanceCr(new BigDecimal(0));
						agt.setClBalanceCr(new BigDecimal(0));
					}
					
					Map<String, Object> utilMap = new HashMap<String, Object>();
					utilMap = (Map) HMSUtil.getCurrentDateAndTime();
					String date = (String) utilMap.get("currentDate");
					String time = (String) utilMap.get("currentTime");

					
					agt.setTransactionDate(HMSUtil.convertStringTypeDateToDateType(date));
					agt.setTransactionTime(time);
					agt.setYtdAmountCr(new BigDecimal(0));
					agt.setYtdAmountDr(new BigDecimal(0));
					MasStoreFinancial msf=new MasStoreFinancial();
					msf.setId(box.getInt("fYear"));
					agt.setFYear(msf);
					
					MasHospital mh =new MasHospital();
					mh.setId(box.getInt("locationId"));
					agt.setLocation(mh);
					
					
					hbt.save(agt);
					
				}else if(actList.size()>0){
					for(AccountSubGroupTransac acgt:acstList){
						Map<String, Object> utilMap = new HashMap<String, Object>();
						utilMap = (Map) HMSUtil.getCurrentDateAndTime();
						String date = (String) utilMap.get("currentDate");
						String time = (String) utilMap.get("currentTime");
						acgt.setTransactionDate(HMSUtil.convertStringTypeDateToDateType(date));
						acgt.setTransactionTime(time);
						if(!box.getString(CR_AMOUNT+i).equals("")){
							crAmt = new BigDecimal(box.getString(CR_AMOUNT+i));
							 
							BigDecimal crAmountSubLedger1=new BigDecimal(0);
							BigDecimal drAmountSubLedger1=new BigDecimal(0);
								crAmountSubLedger1 = acgt.getOpBalanceCr().add(acgt.getYtdAmountCr()).add(crAmt);
								drAmountSubLedger1 = acgt.getOpBalanceDr().add(acgt.getYtdAmountDr());
								
								if(drAmountSubLedger1.compareTo(crAmountSubLedger1)>0){
									acgt.setClBalanceDr(drAmountSubLedger1.subtract(crAmountSubLedger1));
									acgt.setClBalanceCr(new BigDecimal(0.00));
								}else if(crAmountSubLedger1.compareTo(drAmountSubLedger1)>0){
									acgt.setClBalanceCr(crAmountSubLedger1.subtract(drAmountSubLedger1));
									acgt.setClBalanceDr(new BigDecimal(0.00));
								}else if(crAmountSubLedger1.compareTo(drAmountSubLedger1)==0){
									acgt.setClBalanceCr(new BigDecimal(0.00));
									acgt.setClBalanceDr(new BigDecimal(0.00));
								}
								
								
								
								
								acgt.setOpBalanceCr(acgt.getOpBalanceCr().add(crAmt));
						/*	acgt.setClBalanceCr(acgt.getClBalanceCr().add(crAmt));*/
						}
						if(!box.getString(DR_AMOUNT+i).equals("")){
							drAmt = new BigDecimal(box.getString(DR_AMOUNT+i));
							BigDecimal crAmountSubLedger11=new BigDecimal(0);
							BigDecimal drAmountSubLedger11=new BigDecimal(0);
								crAmountSubLedger11 = acgt.getOpBalanceCr().add(acgt.getYtdAmountCr());
								drAmountSubLedger11 = acgt.getOpBalanceDr().add(acgt.getYtdAmountDr()).add(drAmt);
								
								if(drAmountSubLedger11.compareTo(crAmountSubLedger11)>0){
									acgt.setClBalanceDr(drAmountSubLedger11.subtract(crAmountSubLedger11));
									acgt.setClBalanceCr(new BigDecimal(0.00));
								}else if(crAmountSubLedger11.compareTo(drAmountSubLedger11)>0){
									acgt.setClBalanceCr(crAmountSubLedger11.subtract(drAmountSubLedger11));
									acgt.setClBalanceDr(new BigDecimal(0.00));
								}else if(crAmountSubLedger11.compareTo(drAmountSubLedger11)==0){
									acgt.setClBalanceCr(new BigDecimal(0.00));
									acgt.setClBalanceDr(new BigDecimal(0.00));
								}

								acgt.setOpBalanceDr(acgt.getOpBalanceDr().add(drAmt));
						}
						
						hbt.update(acgt);
						
					}
					
				}				
			// below code by Rahul srivastava
				if(box.getInt(SUB_LEDGER_CODE+i) != 0){
					List<AccountSubLedTransac>asltList=new ArrayList<AccountSubLedTransac>();
					asltList=session.createCriteria(AccountSubLedTransac.class)
								    .add(Restrictions.eq("SubLed.Id",box.getInt(SUB_LEDGER_CODE+i)))
								    .add(Restrictions.eq("Location.Id",box.getInt("locationId")))
								    .add(Restrictions.eq("FYear.Id",  box.getInt("fYear")))
							.list();
					
					if(asltList.size()==0){
						AccountSubLedTransac aslt=new AccountSubLedTransac();
						
						FaMasSubLed fmasg=new FaMasSubLed();					
						fmasg.setId(box.getInt(SUB_LEDGER_CODE+i));
						aslt.setSubLed(fmasg);
						MasHospital location = new MasHospital();
						location.setId(box.getInt("locationId"));
						aslt.setLocation(location);
						
						
						if(!box.getString(CR_AMOUNT+i).equals("")){
							aslt.setOpBalanceCr(new BigDecimal(box.getString(CR_AMOUNT+i)));
							aslt.setClBalanceCr(new BigDecimal(box.getString(CR_AMOUNT+i)));
							
						}else{
							aslt.setClBalanceCr(new BigDecimal(0.0));
							aslt.setOpBalanceCr(new BigDecimal(0.0));
						}
						if(!box.getString(DR_AMOUNT+i).equals("")){
							aslt.setOpBalanceDr(new BigDecimal(box.getString(DR_AMOUNT+i)));
							aslt.setClBalanceDr(new BigDecimal(box.getString(DR_AMOUNT+i)));
						}else{
							aslt.setClBalanceDr(new BigDecimal(0.0));
							aslt.setOpBalanceDr(new BigDecimal(0.0));
						}
						aslt.setYtdAmountCr(new BigDecimal(0));
						aslt.setYtdAmountDr(new BigDecimal(0));
						Map<String, Object> utilMap = new HashMap<String, Object>();
						utilMap = (Map) HMSUtil.getCurrentDateAndTime();
						String date = (String) utilMap.get("currentDate");
						String time = (String) utilMap.get("currentTime");

						
						aslt.setTransactionDate(HMSUtil.convertStringTypeDateToDateType(date));
						aslt.setTransactionTime(time);
						
						MasStoreFinancial msf=new MasStoreFinancial();
						msf.setId(box.getInt("fYear"));
						aslt.setFYear(msf);
						
						hbt.save(aslt);
						
					}else if(asltList.size()>0){
						for(AccountSubLedTransac aslt:asltList){
							Map<String, Object> utilMap = new HashMap<String, Object>();
							utilMap = (Map) HMSUtil.getCurrentDateAndTime();
							String date = (String) utilMap.get("currentDate");
							String time = (String) utilMap.get("currentTime");
							aslt.setTransactionDate(HMSUtil.convertStringTypeDateToDateType(date));
							aslt.setTransactionTime(time);
							if(!box.getString(CR_AMOUNT+i).equals("") ){
								 
								BigDecimal crAmountSubLedger1=new BigDecimal(0);
								BigDecimal drAmountSubLedger1=new BigDecimal(0);
									crAmountSubLedger1 = aslt.getOpBalanceCr().add(aslt.getYtdAmountCr()).add(new BigDecimal(box.getString(CR_AMOUNT+i)));
									drAmountSubLedger1 = aslt.getOpBalanceDr().add(aslt.getYtdAmountDr());
									
									if(drAmountSubLedger1.compareTo(crAmountSubLedger1)>0){
										aslt.setClBalanceDr(drAmountSubLedger1.subtract(crAmountSubLedger1));
										aslt.setClBalanceCr(new BigDecimal(0.00));
									}else if(crAmountSubLedger1.compareTo(drAmountSubLedger1)>0){
										aslt.setClBalanceCr(crAmountSubLedger1.subtract(drAmountSubLedger1));
										aslt.setClBalanceDr(new BigDecimal(0.00));
									}else if(crAmountSubLedger1.compareTo(drAmountSubLedger1)==0){
										aslt.setClBalanceCr(new BigDecimal(0.00));
										aslt.setClBalanceDr(new BigDecimal(0.00));
									}
									
									aslt.setYtdAmountCr(aslt.getYtdAmountCr().add(new BigDecimal(box.getString(CR_AMOUNT+i))));
							}
							if(!box.getString(DR_AMOUNT+i).equals("")){
								BigDecimal crAmountSubLedger11=new BigDecimal(0);
								BigDecimal drAmountSubLedger11=new BigDecimal(0);
									crAmountSubLedger11 = aslt.getOpBalanceCr().add(aslt.getYtdAmountCr());
									drAmountSubLedger11 = aslt.getOpBalanceDr().add(aslt.getYtdAmountDr()).add(new BigDecimal(box.getString(DR_AMOUNT+i)));
									
									if(drAmountSubLedger11.compareTo(crAmountSubLedger11)>0){
										aslt.setClBalanceDr(drAmountSubLedger11.subtract(crAmountSubLedger11));
										aslt.setClBalanceCr(new BigDecimal(0.00));
									}else if(crAmountSubLedger11.compareTo(drAmountSubLedger11)>0){
										aslt.setClBalanceCr(crAmountSubLedger11.subtract(drAmountSubLedger11));
										aslt.setClBalanceDr(new BigDecimal(0.00));
									}else if(crAmountSubLedger11.compareTo(drAmountSubLedger11)==0){
										aslt.setClBalanceCr(new BigDecimal(0.00));
										aslt.setClBalanceDr(new BigDecimal(0.00));
									}		
								
									aslt.setYtdAmountDr(aslt.getYtdAmountDr().add(new BigDecimal(box.getString(DR_AMOUNT+i))));
							}
							
							hbt.update(aslt);
						}
					}				
				}
				
				// Above code by Rahul srivastava
				
				List<AccountMainTransac>amtList=new ArrayList<AccountMainTransac>();
				amtList=session.createCriteria(AccountMainTransac.class)
							    .add(Restrictions.eq("Account.Id",box.getInt("accountId"+i)))
   							    .add(Restrictions.eq("Location.Id",box.getInt("locationId")))
							    .add(Restrictions.eq("FinancialYear.Id", box.getInt("fYear")))
						.list();
				if(amtList.size()==0){
					AccountMainTransac agt=new AccountMainTransac();
					
					FaMasAccount fmasg=new FaMasAccount();					
					fmasg.setId(box.getInt("accountId"+i));
					agt.setAccount(fmasg);
					
					if(!box.getString(CR_AMOUNT+i).equals("")){
						crAmt = new BigDecimal(box.getString(CR_AMOUNT+i));
						agt.setOpBalanceCr(crAmt);
						agt.setClBalanceCr(crAmt);
						agt.setOpBalanceDr(new BigDecimal(0));
						agt.setClBalanceDr(new BigDecimal(0));
					}
					if(!box.getString(DR_AMOUNT+i).equals("")){
						drAmt = new BigDecimal(box.getString(DR_AMOUNT+i));
						agt.setOpBalanceDr(drAmt);
						agt.setOpBalanceCr(new BigDecimal(0));
						agt.setClBalanceDr(drAmt);
						agt.setOpBalanceCr(new BigDecimal(0));
						agt.setOpBalanceCr(new BigDecimal(0));
						agt.setClBalanceCr(new BigDecimal(0));
					}
					
					Map<String, Object> utilMap = new HashMap<String, Object>();
					utilMap = (Map) HMSUtil.getCurrentDateAndTime();
					String date = (String) utilMap.get("currentDate");
					String time = (String) utilMap.get("currentTime");

					
					agt.setTransactionDate(HMSUtil.convertStringTypeDateToDateType(date));
					agt.setTransactionTime(time);
					agt.setYtdAmountCr(new BigDecimal(0));
					agt.setYtdAmountDr(new BigDecimal(0));
					MasStoreFinancial msf=new MasStoreFinancial();
					msf.setId(box.getInt("fYear"));
					agt.setFinancialYear(msf);
					
					MasHospital mh =new MasHospital();
					mh.setId(box.getInt("locationId"));
					agt.setLocation(mh);
					
					
					hbt.save(agt);
					
				}else if(amtList.size()>0){
					for(AccountMainTransac acgt:amtList){
						Map<String, Object> utilMap = new HashMap<String, Object>();
						utilMap = (Map) HMSUtil.getCurrentDateAndTime();
						String date = (String) utilMap.get("currentDate");
						String time = (String) utilMap.get("currentTime");
						acgt.setTransactionDate(HMSUtil.convertStringTypeDateToDateType(date));
						acgt.setTransactionTime(time);
						if(!box.getString(CR_AMOUNT+i).equals("")){
							crAmt = new BigDecimal(box.getString(CR_AMOUNT+i));
							 
							BigDecimal crAmountSubLedger1=new BigDecimal(0);
							BigDecimal drAmountSubLedger1=new BigDecimal(0);
								crAmountSubLedger1 = acgt.getOpBalanceCr().add(acgt.getYtdAmountCr()).add(crAmt);
								drAmountSubLedger1 = acgt.getOpBalanceDr().add(acgt.getYtdAmountDr());
								
								if(drAmountSubLedger1.compareTo(crAmountSubLedger1)>0){
									acgt.setClBalanceDr(drAmountSubLedger1.subtract(crAmountSubLedger1));
									acgt.setClBalanceCr(new BigDecimal(0.00));
								}else if(crAmountSubLedger1.compareTo(drAmountSubLedger1)>0){
									acgt.setClBalanceCr(crAmountSubLedger1.subtract(drAmountSubLedger1));
									acgt.setClBalanceDr(new BigDecimal(0.00));
								}else if(crAmountSubLedger1.compareTo(drAmountSubLedger1)==0){
									acgt.setClBalanceCr(new BigDecimal(0.00));
									acgt.setClBalanceDr(new BigDecimal(0.00));
								}
								
								
								
								
								acgt.setOpBalanceCr(acgt.getOpBalanceCr().add(crAmt));
						/*	acgt.setClBalanceCr(acgt.getClBalanceCr().add(crAmt));*/
						}
						if(!box.getString(DR_AMOUNT+i).equals("")){
							drAmt = new BigDecimal(box.getString(DR_AMOUNT+i));
							BigDecimal crAmountSubLedger11=new BigDecimal(0);
							BigDecimal drAmountSubLedger11=new BigDecimal(0);
								crAmountSubLedger11 = acgt.getOpBalanceCr().add(acgt.getYtdAmountCr());
								drAmountSubLedger11 = acgt.getOpBalanceDr().add(acgt.getYtdAmountDr()).add(drAmt);
								
								if(drAmountSubLedger11.compareTo(crAmountSubLedger11)>0){
									acgt.setClBalanceDr(drAmountSubLedger11.subtract(crAmountSubLedger11));
									acgt.setClBalanceCr(new BigDecimal(0.00));
								}else if(crAmountSubLedger11.compareTo(drAmountSubLedger11)>0){
									acgt.setClBalanceCr(crAmountSubLedger11.subtract(drAmountSubLedger11));
									acgt.setClBalanceDr(new BigDecimal(0.00));
								}else if(crAmountSubLedger11.compareTo(drAmountSubLedger11)==0){
									acgt.setClBalanceCr(new BigDecimal(0.00));
									acgt.setClBalanceDr(new BigDecimal(0.00));
								}
								
								
							
							
							
/*							acgt.setClBalanceDr(acgt.getClBalanceDr().add(drAmt));*/
								acgt.setOpBalanceDr(acgt.getOpBalanceDr().add(drAmt));
						}
						
						hbt.update(acgt);
						
					}
					
				}								
				
				
				

//-------------------------update account group-------------------------------------------------

				BigDecimal groupOpBalanceDr = new BigDecimal(0.0);
				BigDecimal groupOpBalanceCr = new BigDecimal(0.0);
				BigDecimal groupYtdBalanceDr = new BigDecimal(0.0);
				BigDecimal groupYtdBalanceCr = new BigDecimal(0.0);
				BigDecimal drGroupAmount = new BigDecimal(0.0);
				BigDecimal crGroupAmount = new BigDecimal(0.0);
				
				int groupId = box.getInt("groupId"+i);
				int subGroupId = box.getInt("subGroupId"+i);

				FaMasAccountGroup faMasAccountGroup = (FaMasAccountGroup)hbt.load(FaMasAccountGroup.class, groupId);
				if(faMasAccountGroup.getOpBalanceCr()!= null){
					groupOpBalanceCr =  faMasAccountGroup.getOpBalanceCr();
				}
				if(faMasAccountGroup.getOpBalanceDr()!= null){
					groupOpBalanceDr =  faMasAccountGroup.getOpBalanceDr();
				}
				if(faMasAccountGroup.getYtdAmountDr()!= null){
					groupYtdBalanceDr =  faMasAccountGroup.getYtdAmountDr();
				}
				if(faMasAccountGroup.getYtdAmountCr()!= null){
					groupYtdBalanceCr =  faMasAccountGroup.getYtdAmountCr();
				}
				if(drAmt.compareTo(new BigDecimal(0))>0){
					 groupYtdBalanceDr = groupYtdBalanceDr.add(drAmt);
					 faMasAccountGroup.setYtdAmountDr(groupYtdBalanceDr);
				 }
				if(crAmt.compareTo(new BigDecimal(0))>0){
					 groupYtdBalanceCr = groupYtdBalanceCr.add(crAmt);
					 faMasAccountGroup.setYtdAmountCr(groupYtdBalanceCr);
				 }
				drGroupAmount = groupOpBalanceDr.add(groupYtdBalanceDr);
				crGroupAmount = groupOpBalanceCr.add(groupYtdBalanceCr);
				if(drGroupAmount.compareTo(crGroupAmount)>0){
					faMasAccountGroup.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
				    faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
				}else if(crGroupAmount.compareTo(drGroupAmount)>0){
					faMasAccountGroup.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
				    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
				}else if(crGroupAmount.compareTo(drGroupAmount)==0){
					faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
				    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
				}

			 	hbt.update(faMasAccountGroup);

	//-------------------------update account Sub group-------------------------------------------------

			 	BigDecimal subGroupOPBalanceDr = new BigDecimal(0);
				BigDecimal subGroupOPBalanceCr = new BigDecimal(0);
				BigDecimal subGroupYtdBalanceDr = new BigDecimal(0);
				BigDecimal subGroupYtdBalanceCr = new BigDecimal(0);
				BigDecimal drSubGroupAmount = new BigDecimal(0.0);
				BigDecimal crSubGroupAmount = new BigDecimal(0.0);

				FaMasAccountSubGroup accountSubGroup = (FaMasAccountSubGroup)hbt.load(FaMasAccountSubGroup.class, subGroupId);
				 if(accountSubGroup.getOpBalanceDr()!= null){
					 subGroupOPBalanceDr =  accountSubGroup.getOpBalanceDr();
				 }
				 if(accountSubGroup.getOpBalanceCr()!= null){
					 subGroupOPBalanceCr = accountSubGroup.getOpBalanceCr();
				 }
				 if(accountSubGroup.getYtdAmountDr()!= null){
					 subGroupYtdBalanceDr = accountSubGroup.getYtdAmountDr();
				 }
				 if(accountSubGroup.getYtdAmountCr()!= null){
					 subGroupYtdBalanceCr = accountSubGroup.getYtdAmountCr();
				 }
				 if(drAmt.compareTo(new BigDecimal(0))>0){
					 subGroupYtdBalanceDr = subGroupYtdBalanceDr.add(drAmt);
					 accountSubGroup.setYtdAmountDr(subGroupYtdBalanceDr);
				 }
				 if(crAmt.compareTo(new BigDecimal(0))>0){
					 subGroupYtdBalanceCr = subGroupYtdBalanceCr.add(crAmt);
					 accountSubGroup.setYtdAmountCr(subGroupYtdBalanceCr);
				 }
				 drSubGroupAmount = subGroupOPBalanceDr.add(subGroupYtdBalanceDr);
				 crSubGroupAmount = subGroupOPBalanceCr.add(subGroupYtdBalanceCr);
					if(drGroupAmount.compareTo(crGroupAmount)>0){
						faMasAccountGroup.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
					    faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
					}else if(crGroupAmount.compareTo(drGroupAmount)>0){
						faMasAccountGroup.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
					    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
					}else if(crGroupAmount.compareTo(drGroupAmount)==0){
						faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
					    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
					}

			 	hbt.update(accountSubGroup);

	//-------------------------update account master-------------------------------------------------

	//-------------------------update account master-------------------------------------------------

				BigDecimal accountOpBalanceDr = new  BigDecimal(0.0);
		 		BigDecimal accountOpBalanceCr = new  BigDecimal(0.0);
		 		BigDecimal accountYtdBalanceDr = new BigDecimal(0.0);
		 		BigDecimal accountYtdBalanceCr = new  BigDecimal(0.0);
		 		BigDecimal drAccountAmount = new BigDecimal(0.0);
		 		BigDecimal crAccountAmount = new  BigDecimal(0.0);
		 		FaMasAccount masAccount = (FaMasAccount)hbt.load(FaMasAccount.class,accountId);
		 		if(masAccount.getOpBalanceDr()!= null){
		 			accountOpBalanceDr =  masAccount.getOpBalanceDr();
		 		}
		 		if(masAccount.getOpBalanceCr()!= null){
		 			accountOpBalanceCr = masAccount.getOpBalanceCr();
		 		}

		 		 if(masAccount.getYtdAmountDr() != null){
		 			 accountYtdBalanceDr = masAccount.getYtdAmountDr();
		 		 }
		 		 if(masAccount.getYtdAmountCr() != null){
		 			accountYtdBalanceCr = masAccount.getYtdAmountCr();
		 		 }
		 		if(drAmt.compareTo(new BigDecimal(0))>0){
					 accountYtdBalanceDr = accountYtdBalanceDr.add(drAmt);
					 masAccount.setYtdAmountDr(accountYtdBalanceDr);
				 }
				 if(crAmt.compareTo(new BigDecimal(0))>0){
					 accountYtdBalanceCr = accountYtdBalanceCr.add(crAmt);
					 masAccount.setYtdAmountCr(accountYtdBalanceCr);
				 }
				 drAccountAmount = accountOpBalanceDr.add(accountYtdBalanceDr);
				 crAccountAmount = accountOpBalanceCr.add(accountYtdBalanceCr);
					if(drAccountAmount.compareTo(crAccountAmount)>0){
						masAccount.setClBalanceDr(drAccountAmount.subtract(crAccountAmount));
						masAccount.setClBalanceCr(new BigDecimal(0.00));
					}else if(crAccountAmount.compareTo(drAccountAmount)>0){
						masAccount.setClBalanceCr(crAccountAmount.subtract(drAccountAmount));
						masAccount.setClBalanceDr(new BigDecimal(0.00));
					}else if(crAccountAmount.compareTo(drAccountAmount)==0){
						masAccount.setClBalanceCr(new BigDecimal(0.00));
						masAccount.setClBalanceDr(new BigDecimal(0.00));
					}

		 		/*if(drAmt.compareTo(new BigDecimal(0))>0){
					 if(accountClosingBalanceCr.compareTo(new BigDecimal(0)) > 0){
					 	 if(accountClosingBalanceCr.compareTo(drAmt) > 0 ){
					 		accountClosingBalanceCr = accountClosingBalanceCr.subtract(drAmt);
					 		masAccount.setClBalanceCr(accountClosingBalanceCr);
					 		masAccount.setClBalanceDr(new BigDecimal(0.00));
					 	 }else if(drAmt.compareTo(accountClosingBalanceCr) > 0 ){
					 		accountClosingBalanceDr =drAmt.subtract(accountClosingBalanceCr);
					 		masAccount.setClBalanceDr(accountClosingBalanceDr);
					 		masAccount.setClBalanceCr(new BigDecimal(0.00));
					 	 }
					 }else {
					 		  accountClosingBalanceDr = accountClosingBalanceDr.add(drAmt);
					 		 masAccount.setClBalanceDr(accountClosingBalanceDr);
						  }

				}else if(crAmt.compareTo(new BigDecimal(0))>0){
					if(accountClosingBalanceDr.compareTo(new BigDecimal(0)) > 0){
					  if(accountClosingBalanceDr.compareTo(crAmt) > 0){
						  accountClosingBalanceDr =accountClosingBalanceDr.subtract(crAmt);
						  masAccount.setClBalanceDr(accountClosingBalanceDr);
						  masAccount.setClBalanceCr(new BigDecimal(0.00));
					  }else if(crAmt.compareTo(accountClosingBalanceDr) > 0 ){
						  accountClosingBalanceCr =crAmt.subtract(accountClosingBalanceDr);
						  masAccount.setClBalanceCr(accountClosingBalanceCr);
						  masAccount.setClBalanceDr(new BigDecimal(0.00));
					 	 }
					}else{
						accountClosingBalanceCr = accountClosingBalanceCr.add(crAmt);
						masAccount.setClBalanceCr(accountClosingBalanceCr);
					  }
				}*/
				 
				 hbt.update(masAccount);
				//-----------------------update account sub ledger==================================
				 if(box.getInt(SUB_LEDGER_CODE+ i)!=0){
					 BigDecimal subLedgerOPBalanceCr = new BigDecimal(0.0);
					 BigDecimal subLedgerOPBalanceDr = new BigDecimal(0.0);
					 BigDecimal subLedgerYTDBalanceDr = new BigDecimal(0.0);
					 BigDecimal subLedgerYTDBalanceCr = new BigDecimal(0.0);
					 BigDecimal drAmountSubLedger = new BigDecimal(0.0);
					 BigDecimal crAmountSubLedger = new BigDecimal(0.0);
					 
					 FaMasSubLed subLed= (FaMasSubLed)hbt.load(FaMasSubLed.class, box.getInt(SUB_LEDGER_CODE+ i));
					 if(subLed.getOpBalanceCr()!= null){
						 subLedgerOPBalanceCr =  subLed.getOpBalanceCr();
					 }
					 if(subLed.getOpBalanceDr()!= null){
						 subLedgerOPBalanceDr = subLed.getOpBalanceDr();
					 }

					if(subLed.getYtdAmountCr()!= null){
						subLedgerYTDBalanceCr = subLed.getYtdAmountCr();
					}
					if(subLed.getYtdAmountDr()!= null){
						subLedgerYTDBalanceDr = subLed.getYtdAmountDr();
					}
					if(drAmt.compareTo(new BigDecimal(0))>0){
						subLedgerYTDBalanceDr = subLedgerYTDBalanceDr.add(drAmt);
						subLed.setYtdAmountDr(subLedgerYTDBalanceDr);
					 }
					 if(crAmt.compareTo(new BigDecimal(0))>0){
						 subLedgerYTDBalanceCr = subLedgerYTDBalanceCr.add(crAmt);
						 subLed.setYtdAmountCr(subLedgerYTDBalanceCr);
					 }
					
					
					 crAmountSubLedger = subLedgerOPBalanceCr.add(subLedgerYTDBalanceCr);
					drAmountSubLedger = subLedgerOPBalanceDr.add(subLedgerYTDBalanceDr);
					
					if(drAmountSubLedger.compareTo(crAmountSubLedger)>0){
						subLed.setClBalanceDr(drAmountSubLedger.subtract(crAmountSubLedger));
						subLed.setClBalanceCr(new BigDecimal(0.00));
					}else if(crAmountSubLedger.compareTo(drAmountSubLedger)>0){
						subLed.setClBalanceCr(crAmountSubLedger.subtract(drAmountSubLedger));
						subLed.setClBalanceDr(new BigDecimal(0.00));
					}else if(crAmountSubLedger.compareTo(drAmountSubLedger)==0){
						subLed.setClBalanceCr(new BigDecimal(0.00));
						subLed.setClBalanceDr(new BigDecimal(0.00));
					}
						 hbt.update(subLed);
				 }
				 
				 
			}
			vhId=voucherHeader.getId();
			tx.commit();
			saved = true;
		} catch (Exception e) {
			if(tx != null){
				tx.rollback();
			}
			e.printStackTrace();
		}

		map = showJournalVoucherJsp(box);
		map.put("saved", saved);
		map.put("vhId", vhId);
		map.put("voucherNo1",voucherNo);
		return map;
	}
	
	@Override
	public Map<String, Object> getConsolidatedTransactionDetails(Box box) {
		Map<String,Object> datamap = new HashMap<String,Object>();
		
		List<AccountMainTransac> accountList = new ArrayList<AccountMainTransac>();
		List<AccountSubLedTransac> subledgerList = new ArrayList<AccountSubLedTransac>();
		
		Session session = (Session) getSession();
		int pagingSize = 10;
		int pageNo = 1;		
		int ddlAccountList = 0;	
		int ddlSubledgerList = 0;
		int ddlYear = 0;
		int locationId = 0;		 
		String TransactionType = "" ; // Awaiting/Saved/Approved
		
		
		pageNo = Integer.parseInt(box.getString("PN"));		
		ddlAccountList = box.getInt("ddlAccountList");
		ddlSubledgerList =  box.getInt("ddlSubledgerList");		
		ddlYear = box.getInt("ddlYear");
		
		locationId = box.getInt("locationId");		
		TransactionType = box.getString("TransactionType");
		
		Criteria cr = null;
		if(TransactionType.equalsIgnoreCase("Account"))
		{
			cr = session.createCriteria(AccountMainTransac.class);
			if(locationId != 0){
					cr= cr.createAlias("Location", "location").add(Restrictions.eq("location.Id", locationId));
			}
			if(ddlAccountList != 0)
			{
				cr= cr.createAlias("Account", "account").add(Restrictions.eq("account.Id", ddlAccountList));
			}
			List totalMatches = cr.list();
			cr = cr.setFirstResult(pagingSize * (pageNo - 1));
			cr = cr.setMaxResults(pagingSize);
			accountList = cr.list();
			
			int totalRecords = totalMatches.size();
			totalMatches.clear();		

			datamap.put("accountList", accountList);
			datamap.put("totalRecords", totalRecords);
		}
		if(TransactionType.equalsIgnoreCase("Subledger"))
		{
			cr = session.createCriteria(AccountSubLedTransac.class).createAlias("SubLed", "masSubLed");
			if(ddlSubledgerList != 0)
			{
				cr= cr.add(Restrictions.eq("masSubLed.Id", ddlSubledgerList));
			}
			if(locationId != 0)
			{
				cr = cr.createAlias("masSubLed.Hospital", "location").add(Restrictions.eq("location.Id", locationId));
			}
			
			List totalMatches = cr.list();
			cr = cr.setFirstResult(pagingSize * (pageNo - 1));
			cr = cr.setMaxResults(pagingSize);
			subledgerList = cr.list();
			
			int totalRecords = totalMatches.size();
			totalMatches.clear();		

			datamap.put("subledgerList", subledgerList);
			datamap.put("totalRecords", totalRecords);
		}
		
		

		return datamap;

	}
	@Override
	public List<Object[]> getAccountList(Box box) {
		List<Object[]> accountList = new ArrayList<Object[]>();		
		Session session = getSession();
		Criteria cr = null;
		cr = session.createCriteria(FaMasAccount.class).add(Restrictions.eq("Status", "y").ignoreCase());
		
		cr = cr.add(Restrictions.eq("AccountRight", "Al").ignoreCase());
		
		cr = cr.setProjection(Projections.projectionList()
				.add(Projections.property("Id"))
				.add(Projections.property("AccDesc")));
		accountList = cr.list();		
		
		return accountList;
		
	}
	/*@Override
	public List<Object[]> getSubledgerList(Box box) {
		List<Object[]> subledgerList = new ArrayList<Object[]>();		
		Session session = getSession();
		Criteria cr = null;
		cr = session.createCriteria(FaMasSubLed.class).add(Restrictions.eq("Status", "y").ignoreCase());	
		cr = cr.createAlias("Hospital", "location",CriteriaSpecification.LEFT_JOIN);
		cr = cr.createAlias("Account", "account",CriteriaSpecification.LEFT_JOIN);
		cr = cr.add(Restrictions.eq("location.Id", box.getInt("locationId")));
		
		subledgerList= cr.setProjection(Projections.projectionList()
				.add(Projections.groupProperty("account.Id"))
				.add(Projections.sqlProjection("cast(group_concat(distinct sub_led_id order by sub_led_desc) as char) as sub_led_id", new String[]{"sub_led_id"}, new Type[]{new StringType()}))
				.add(Projections.sqlProjection("group_concat(distinct sub_led_desc order by sub_led_desc) as sub_led_desc", new String[]{"sub_led_desc"}, new Type[]{new StringType()})))
				.list();	
		
		subledgerList= cr.list();	
		
		System.out.println("subledgerList="+subledgerList.size());
		
		return subledgerList;
	}*/
	
	@Override
	public List<Object[]> getSubledgerList(Box box) {
		List<Object[]> subledgerList = new ArrayList<Object[]>();		
		Session session = getSession();
		Criteria cr = null;
		cr = session.createCriteria(FaMasSubLed.class).add(Restrictions.eq("Status", "y").ignoreCase());	
		cr = cr.createAlias("Hospital", "location",CriteriaSpecification.LEFT_JOIN);
		cr = cr.createAlias("Account", "account",CriteriaSpecification.LEFT_JOIN);
		cr = cr.add(Restrictions.eq("location.Id", box.getInt("locationId")));
		
		subledgerList= cr.setProjection(Projections.projectionList()
				.add(Projections.groupProperty("account.Id"))
				.add(Projections.sqlProjection("cast(group_concat(distinct sub_led_id order by sub_led_desc) as char) as sub_led_id", new String[]{"sub_led_id"}, new Type[]{new StringType()}))
				.add(Projections.sqlProjection("group_concat(distinct sub_led_desc order by sub_led_desc) as sub_led_desc", new String[]{"sub_led_desc"}, new Type[]{new StringType()})))
				.list();	
		System.out.println("subledgerList="+subledgerList.size());
		
		return subledgerList;
	}
	
	@Override
	public Map<String, Object> getTransactionHistory(Box box) {
		Map<String,Object> datamap = new HashMap<String,Object>();
		List<FaVoucherDetails> voucherDetails = new ArrayList<FaVoucherDetails>();
		
		Session session = (Session) getSession();
		int pagingSize = 10;
		int pageNo = 1;
	
		int Id = 0;		
		String TransactionType = "";
		int locationId = 0;
		
		String ProjectionType = "";
		if (box.getString("PN") != null)
		{
			pageNo = Integer.parseInt(box.getString("PN"));	
		}
		
		
			Id = box.getInt("Id");		
		    locationId = box.getInt("locationId");		
			TransactionType = box.getString("TransactionType");
	
		int approvedId= Integer.parseInt(HMSUtil.getProperties("adt.properties", "approvedId"));
		
		Criteria cr = null;
		cr = session.createCriteria(FaVoucherDetails.class);
		cr = cr.createAlias("VoucherHeader", "header").add(Restrictions.or(Restrictions.eq("header.ApprovalStatus.Id", approvedId), Restrictions.eq("header.VoucherType", "OP")));
			
		
		if(TransactionType.equalsIgnoreCase("S"))
		{
			if (Id != 0 ) {
				cr = cr.createAlias("SubLed", "subledger");
				cr = cr.add(Restrictions.eq("subledger.Id", Id));
			}
		}
		
		if(TransactionType.equalsIgnoreCase("A"))
		{
			if (Id != 0 ) {
				cr = cr.createAlias("Account", "account");
				cr = cr.add(Restrictions.eq("account.Id", Id));
			}
		}		
		
		if (locationId != 0 ) {
			cr = cr.createAlias("header.Hospital", "location");
			cr = cr.add(Restrictions.eq("location.Id", locationId));
		}
		
		
		 cr = cr.addOrder(Order.desc("header.VoucherDate"));
		
		
		List totalMatches = cr.list();
		cr = cr.setFirstResult(pagingSize * (pageNo - 1));
		cr = cr.setMaxResults(pagingSize);
		voucherDetails = cr.list();

		System.out.println("Total records=" + totalMatches.size());
		int totalRecords = totalMatches.size();
		totalMatches.clear();

		System.out.println("Size of voucherDetails in dataservice="
				+ voucherDetails.size());

		datamap.put("voucherDetails", voucherDetails);
		datamap.put("totalRecords", totalRecords);
		

		return datamap;
	}
	@Override
	public Map<String, Object> getConsolidatedBudgetOfDivision(Box box) {
		List<Object[]> consolidateBudgetAmountForDivision = new ArrayList<Object[]>();
		
		Map<String,Object> datamap = new HashMap<String,Object>();
		
		boolean bHOConsolidatedBudgetExist = false;
		int year = 0;
		int season = 0;
		int dept = 0;
		
		year = box.getInt("ddlBudgetYear");
		season = box.getInt("ddlSeason");
		
		
		System.out.println("year="+year+"season="+season);
		
		Session session = (Session) getSession();
		Criteria cr = null;
		Criteria cr1 = null;
		
			
		cr = session.createCriteria(MktBudgetHeader.class).add(Restrictions.eq("BudgetType", "HO"));
		if(season != 0)
		{
			cr = cr.createAlias("Season", "s");
		}		
		cr = cr.createAlias("Year", "y");
		cr = cr.createAlias("Status", "st");
		cr = cr.createAlias("Department", "d");
		cr= cr.add(Restrictions.ne("d.Id", 5));
		
		cr= cr.add(Restrictions.eq("y.Id", year)).add(Restrictions.eq("st.Id", 1));
		if(season != 0)
		{
			cr= cr.add(Restrictions.eq("s.Id", season));
		}
		cr = cr.setProjection(Projections.projectionList()
				.add(Projections.property("d.Id"))
				.add(Projections.property("d.DepartmentName"))
				.add(Projections.sum("Total"))
				.add(Projections.groupProperty("d.Id")));
		
		consolidateBudgetAmountForDivision = cr.list();
		
		
		System.out.println("size of consolidateBudgetAmount="+consolidateBudgetAmountForDivision.size());
		
		datamap.put("consolidateBudgetAmountForDivision", consolidateBudgetAmountForDivision);
		
		return datamap;
	}
	@Override
	public List<Object[]> GetBudgetAmountForEachCentre(Box box) {
		List<Object[]> budgetAmount = new ArrayList<Object[]>();
		
		
		int year = box.getInt("year");
		int season = box.getInt("season");
		int departmentId = box.getInt("departmentId");
		
		
		Session session = (Session) getSession();
		Criteria cr = null;
		
		cr = session.createCriteria(MktBudgetHeader.class);
		cr = cr.createAlias("Year", "y");
		if(season != 0)
		{
			cr = cr.createAlias("Season", "s");
		}	
		
		cr = cr.createAlias("Department", "dept");
		cr = cr.createAlias("Centre", "location");
		cr = cr.createAlias("Status", "st");
		if(season != 0)
		{
			cr = cr.add(Restrictions.eq("s.Id", season));
		}	
		
		cr = cr.add(Restrictions.eq("y.Id", year)).add(Restrictions.eq("dept.Id", departmentId)).add(Restrictions.eq("st.Id", 1))
				.add(Restrictions.or(Restrictions.eq("BudgetType", "CENTRE").ignoreCase(), Restrictions.eq("BudgetType", "DISTRICT").ignoreCase()));
		
		cr = cr.setProjection(Projections.projectionList()
				.add(Projections.property("location.Id"))
				.add(Projections.property("dept.DepartmentName"))
				.add(Projections.property("location.HospitalName"))
				.add(Projections.sum("Total"))
				.add(Projections.groupProperty("location.Id")));
		budgetAmount = cr.list();
		
		
		
		return budgetAmount;
	}
	@Override
	public Map<String, Object> GetBudgetComponentAmount(Box box) {
		List<Object[]> componentAmount = new ArrayList<Object[]>();
		Map<String,Object> datamap = new HashMap<String,Object>();
		
		int year = box.getInt("year");
		int season = box.getInt("season");
		int departmentId = box.getInt("departmentId");
		int locationId = box.getInt("locationId");
		
		
		Session session = (Session) getSession();
		Criteria cr = null;
		
		cr = session.createCriteria(MktBudgetDetails.class);
		
		cr = cr.createAlias("header.Year", "y");
		if(season != 0)
		{
			cr = cr.createAlias("header.Season", "s");
		}	
		
		cr = cr.createAlias("BudgetHeader", "header");
		cr = cr.createAlias("header.Department", "dept");
		cr = cr.createAlias("header.Centre", "location");
		cr = cr.createAlias("header.Status", "st");
		cr = cr.createAlias("BudgetComponent", "bc");
		
		if(season != 0)
		{
			cr = cr.add(Restrictions.eq("s.Id", season));
		}	
		
		cr = cr.add(Restrictions.eq("location.Id", locationId)).add(Restrictions.eq("y.Id", year)).add(Restrictions.eq("dept.Id", departmentId)).add(Restrictions.eq("st.Id", 1))
				.add(Restrictions.or(Restrictions.eq("header.BudgetType", "CENTRE").ignoreCase(), Restrictions.eq("header.BudgetType", "DISTRICT").ignoreCase()));
		
		cr = cr.setProjection(Projections.projectionList()
				.add(Projections.property("bc.Id"))
				.add(Projections.property("bc.BudgetComponentName"))
				
				.add(Projections.sum("Amount"))
				.add(Projections.groupProperty("bc.Id")));
		componentAmount = cr.list();
		
		datamap.put("componentAmount",componentAmount);
		return datamap;
		
		
	}
	@Override
	public Map<String, Object> updateBudgetComponentAmount(Box box) {
		List<Object[]> componentAmount = new ArrayList<Object[]>();
		Map<String,Object> datamap = new HashMap<String,Object>();
	    List<MktBudgetDetails> budgetDetails = new ArrayList<MktBudgetDetails>();
	    List<MktBudgetHeader> centreBudgetHeader = new ArrayList<MktBudgetHeader>();
	    List<MktBudgetHeader> hoBudgetHeader = new ArrayList<MktBudgetHeader>();
	    List<MktBudgetHeader> hoFinalBudgetHeader = new ArrayList<MktBudgetHeader>();
		
		int year = box.getInt("year");
		int season = box.getInt("season");
		int departmentId = box.getInt("departmentId");
		int locationId = box.getInt("locationId");
		int cId = box.getInt("cId");
		double newBudgetComponentAmount = box.getDouble("txtBudgetComponentAmount");
		
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session) getSession();
		Criteria cr = null;
		Transaction tx = null;
		boolean bUpdate = false;
		String updateRemarks = "";
		
		try
		{
			
		tx = session.beginTransaction();
		// we have to update the amount for three 1) budget component in details table  2) total Budget Amount at centre level  3) total budget amount at ho level
		// update Budget Amount for Component
		cr = session.createCriteria(MktBudgetDetails.class);
		cr = cr.createAlias("header.Year", "y");
		if(season != 0)
		{
			cr = cr.createAlias("header.Season", "s");
		}	
		
		cr = cr.createAlias("BudgetHeader", "header");
		cr = cr.createAlias("header.Department", "dept");
		cr = cr.createAlias("header.Centre", "location");
		cr = cr.createAlias("header.Status", "st");
		cr = cr.createAlias("BudgetComponent", "bc");
		
		if(season != 0)
		{
			cr = cr.add(Restrictions.eq("s.Id", season));
		}	
		
		cr = cr.add(Restrictions.eq("bc.Id", cId)).add(Restrictions.eq("location.Id", locationId)).add(Restrictions.eq("y.Id", year)).add(Restrictions.eq("dept.Id", departmentId)).add(Restrictions.eq("st.Id", 1))
				.add(Restrictions.or(Restrictions.eq("header.BudgetType", "CENTRE").ignoreCase(), Restrictions.eq("header.BudgetType", "DISTRICT").ignoreCase()));
		
		budgetDetails = cr.list();
		
		double oldBudgetComponentValue = 0.0;
		int tableId = 0;
		
		for(MktBudgetDetails list: budgetDetails)
		{
		   tableId = list.getId();
		   oldBudgetComponentValue = list.getAmount().doubleValue();		   
		}
		double changedValue = oldBudgetComponentValue - newBudgetComponentAmount;
		budgetDetails.clear();
		
		MktBudgetDetails budgetDetailsList = new MktBudgetDetails();
		budgetDetailsList = (MktBudgetDetails)hbt.get(MktBudgetDetails.class, tableId);
		if(budgetDetailsList != null)
		{
			budgetDetailsList.setAmount(new BigDecimal(newBudgetComponentAmount));
			updateRemarks = budgetDetailsList.getRemarks()+"\n HO Accounts update the Budget Amount \n Old Value:"+oldBudgetComponentValue +  "\n New Value:"+newBudgetComponentAmount;
			budgetDetailsList.setRemarks(updateRemarks);
			hbt.update(budgetDetailsList);
			hbt.refresh(budgetDetailsList);
		}
		
		
		// update total Amount at centre level
		cr = session.createCriteria(MktBudgetHeader.class);
		cr = cr.createAlias("Year", "y");
		if(season != 0)
		{
			cr = cr.createAlias("Season", "s");
		}	
		
		cr = cr.createAlias("Department", "dept");
		cr = cr.createAlias("Centre", "location");
		cr = cr.createAlias("Status", "st");
		
		if(season != 0)
		{
			cr = cr.add(Restrictions.eq("s.Id", season));
		}	
		
		cr = cr.add(Restrictions.eq("location.Id", locationId)).add(Restrictions.eq("y.Id", year)).add(Restrictions.eq("dept.Id", departmentId)).add(Restrictions.eq("st.Id", 1))
				.add(Restrictions.or(Restrictions.eq("BudgetType", "CENTRE").ignoreCase(), Restrictions.eq("BudgetType", "DISTRICT").ignoreCase()));
		
		centreBudgetHeader = cr.list();
		
		double oldBudgetAmountAtCentre = 0.0;
		int tableIdAtCentre = 0;
		System.out.println("changedValue="+changedValue);
		
		for(MktBudgetHeader list: centreBudgetHeader)
		{
			tableIdAtCentre = list.getId();
		   oldBudgetAmountAtCentre = list.getTotal().doubleValue();		   
		}
		double changedValueAtCentre = oldBudgetAmountAtCentre - changedValue;
		centreBudgetHeader.clear();
		
		MktBudgetHeader centreBudgetHeaderList = new MktBudgetHeader();
		centreBudgetHeaderList = (MktBudgetHeader)hbt.get(MktBudgetHeader.class, tableIdAtCentre);
		if(centreBudgetHeaderList != null)
		{
			centreBudgetHeaderList.setTotal(new BigDecimal(changedValueAtCentre));
			//updateRemarks = centreBudgetHeaderList.getRemarks()+"\n HO Accounts update the Budget Amount \n Old Value:"+oldBudgetComponentValue +  "\n New Value:"+newBudgetComponentAmount;
			//budgetDetailsList.setRemarks(updateRemarks);
			hbt.update(centreBudgetHeaderList);
			hbt.refresh(centreBudgetHeaderList);
		}
		
		
		      // update total Amount at HO level
				cr = session.createCriteria(MktBudgetHeader.class);
				cr = cr.createAlias("Year", "y");
				if(season != 0)
				{
					cr = cr.createAlias("Season", "s");
				}	
				
				cr = cr.createAlias("Department", "dept");
				cr = cr.createAlias("Centre", "location");
				cr = cr.createAlias("Status", "st");
				
				if(season != 0)
				{
					cr = cr.add(Restrictions.eq("s.Id", season));
				}	
				
				cr = cr.add(Restrictions.eq("y.Id", year)).add(Restrictions.eq("dept.Id", departmentId)).add(Restrictions.eq("st.Id", 1))
						.add(Restrictions.eq("BudgetType", "HO").ignoreCase());
				
				hoBudgetHeader = cr.list();
				
				double oldBudgetAmountAtHO = 0.0;
				int tableIdAtHO = 0;
				
				for(MktBudgetHeader list: hoBudgetHeader)
				{
					tableIdAtHO = list.getId();
				    oldBudgetAmountAtHO = list.getTotal().doubleValue();		   
				}
				double changedValueAtHO = oldBudgetAmountAtHO - changedValue;
				hoBudgetHeader.clear();
				
				MktBudgetHeader hoBudgetHeaderList = new MktBudgetHeader();
				hoBudgetHeaderList = (MktBudgetHeader)hbt.get(MktBudgetHeader.class, tableIdAtHO);
				if(hoBudgetHeaderList != null)
				{
					hoBudgetHeaderList.setTotal(new BigDecimal(changedValueAtHO));
					hbt.update(hoBudgetHeaderList);
					hbt.refresh(hoBudgetHeaderList);
				}
				
				// update total Amount at HO level Accounts Department this is for accounts ddept
				cr = session.createCriteria(MktBudgetHeader.class);
				cr = cr.createAlias("Year", "y");
				
				
				cr = cr.createAlias("Department", "dept");
				//cr = cr.createAlias("Centre", "location");
				cr = cr.createAlias("Status", "st");
				
				
				// this is for 
				cr = cr.add(Restrictions.eq("y.Id", year)).add(Restrictions.eq("dept.Id", 5)).add(Restrictions.eq("st.Id", 3))
						.add(Restrictions.eq("BudgetType", "HO").ignoreCase());
				
				hoFinalBudgetHeader = cr.list();
				
				double oldFinalBudgetAmountAtHO = 0.0;
				int finaltableIdAtHO = 0;
				System.out.println("hoFinalBudgetHeader="+hoFinalBudgetHeader.size());
				if(hoFinalBudgetHeader.size()>0)
				{
					for(MktBudgetHeader list: hoFinalBudgetHeader)
					{
						finaltableIdAtHO = list.getId();
						oldFinalBudgetAmountAtHO = list.getTotal().doubleValue();		   
					}
				}
				
				double changedValueAtFinalHO = oldFinalBudgetAmountAtHO - changedValue;
				System.out.println("changedValueAtFinalHO="+changedValueAtFinalHO);
				hoFinalBudgetHeader.clear();
				
				MktBudgetHeader hoFinalBudgetHeaderList = new MktBudgetHeader();
				hoFinalBudgetHeaderList = (MktBudgetHeader)hbt.get(MktBudgetHeader.class, finaltableIdAtHO);
				if(hoFinalBudgetHeaderList != null)
				{
					hoFinalBudgetHeaderList.setTotal(new BigDecimal(changedValueAtFinalHO));
					hbt.update(hoFinalBudgetHeaderList);
					hbt.refresh(hoFinalBudgetHeaderList);
				}
				bUpdate=true;
				
		
		tx.commit();
				
		}
		catch(Exception e)
		{
			System.out.println("update Budget component in Account="+e);
			bUpdate = false;
			if(tx != null)
			{
				tx.rollback();
			}
			
		}
		
		datamap.put("bUpdate",bUpdate);
		return datamap;
	}
	
	
	public synchronized Map<String, Object> submitFinalBudget(Box box) {
		Map<String,Object> map = new HashMap<String,Object>();
		List<MktBudgetHeader> MktBudgetHeaderIdList = new ArrayList<MktBudgetHeader>();
		List<MktBudgetHeader> budgetHeaderList = new ArrayList<MktBudgetHeader>();
		
		Session session = (Session) getSession();
		Transaction tx = null;
		boolean bSuccessfullyAdded = false;
		boolean bRecordExist = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		String txtRequestType = box.getString("txtRequestType"); // for save/submit(forward) to centre HEAD
		String fromdatepick = box.getString("fromdate-pick");
		int ddlBudgetYear = box.getInt("ddlBudgetYear");
		String BudgetType = "HO";
		
		MasStoreFinancial financialYear = new MasStoreFinancial();
		financialYear.setId(ddlBudgetYear);		
		 
		String financialYearStringVal = box.getString("txtStringValueOfYear");
		int ddlSeason = box.getInt("ddlSeason");
		double TotalFinalBudgetAmount = box.getDouble("TotalFinalBudgetAmount");
												   
		
		System.out.println("TotalFinalBudgetAmount="+TotalFinalBudgetAmount);
				
		int locationId = 0;
		int departmentId =0;
		locationId = box.getInt("LOCATION_ID");
		departmentId = box.getInt("DEPT_ID");
		
		MasHospital location = new MasHospital();
		location.setId(locationId);
		
		MasDepartment department = new MasDepartment();
		department.setId(departmentId);
		
		int UserId = box.getInt("CHANGED_BY");
		Users user = new Users();
		user.setId(UserId);
		
		Date changedDate = new Date();
		String changedTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
			
		String BudgetSystemGeneratedHeaderId = "";
		
		
		// check if HO Budget is submitted again based on (same financial Year and another criteria would be added later)
		  Criteria cr = session.createCriteria(MktBudgetHeader.class);
				 cr= cr.createAlias("Year", "financialYear");				  
				  cr= cr.createAlias("Department", "dept");				  
				 
				  cr= cr.add(Restrictions.eq("financialYear.Id", ddlBudgetYear))						 
						 .add(Restrictions.eq("dept.Id", departmentId))
						 .add(Restrictions.eq("BudgetType", "HO").ignoreCase());							 
						  
				
		budgetHeaderList = cr.list();
       
		int sizeOfBudgetHeaderList = budgetHeaderList.size();
			
		budgetHeaderList.clear();
		if (sizeOfBudgetHeaderList > 0) {
			bRecordExist = true;
		}
		if(!bRecordExist)
		{
			
			Map<String,Object>transactionSequenceMap = new HashMap<String,Object>();
            transactionSequenceMap = generateSystemId("MktBudgetHeader","HO",ddlBudgetYear,0,locationId,departmentId);
            
            if(transactionSequenceMap != null)
            {
           	 if(transactionSequenceMap.get("bTransactionSequenceInsertion") != null)
           	 {
           		boolean bInsertion =  (Boolean) transactionSequenceMap.get("bTransactionSequenceInsertion");
           		if(bInsertion)  // Insert transaction sequence record
           		{
           			TransactionSequence tsObj = new TransactionSequence();
       				tsObj.setStatus("y");
       				tsObj.setTablename("MktBudgetHeader");
       				tsObj.setTransactionPrefix(transactionSequenceMap.get("prefix").toString());
       				tsObj.setTransactionSequenceName("MktBudgetHeaderNo");
       				tsObj.setTransactionSuffix(transactionSequenceMap.get("suffix").toString());            				
       				tsObj.setTransactionSequenceNumber(1);            				
       				tsObj.setHospital(location);
       				tsObj.setDepartment(department);
       				tsObj.setFinancialYear(financialYear);
       				tsObj.setStatus("y");
       				hbt.save(tsObj);
           		}
           		else  // update transaction sequence record
           		{
           			int TransactionSequenceId = (Integer) transactionSequenceMap.get("TransactionSequenceId");
           			int sequenceNumber = (Integer) transactionSequenceMap.get("sequenceNumber");
           			TransactionSequence transactionSequenceObj = (TransactionSequence) hbt.load(TransactionSequence.class, TransactionSequenceId);
   					transactionSequenceObj.setTransactionSequenceNumber(sequenceNumber);
   					transactionSequenceObj.setTransactionPrefix(transactionSequenceMap.get("prefix").toString());        					
   					transactionSequenceObj.setTransactionSuffix(transactionSequenceMap.get("suffix").toString());           				            				           				
       				transactionSequenceObj.setFinancialYear(financialYear);
   					hbt.update(transactionSequenceObj);
           		}
           	 }
            }
            	BudgetSystemGeneratedHeaderId = transactionSequenceMap.get("SystemGenerateId").toString();
				MktBudgetHeader budgetHeader = new MktBudgetHeader();
				
				budgetHeader.setBudgetId(BudgetSystemGeneratedHeaderId);
				budgetHeader.setDate(HMSUtil.convertStringTypeDateToDateType(fromdatepick));
				budgetHeader.setYear(financialYear);
				budgetHeader.setBudgetType(BudgetType);  // Value is inserted based on if Budget is centre level / District Level
				budgetHeader.setCentre(location);
				
				if(ddlSeason != 0)
				{
					MasStoreItemCategory itemCategory = new MasStoreItemCategory();
					itemCategory.setId(ddlSeason);
					budgetHeader.setSeason(itemCategory);
				}
				
				budgetHeader.setTotal(new BigDecimal(TotalFinalBudgetAmount));
				
				MasApprovalStatus status = new MasApprovalStatus();
				int statusId = 0;
				if(txtRequestType.equalsIgnoreCase("SAVE"))
				{
					statusId = 4;
				}
				if(txtRequestType.equalsIgnoreCase("SUBMIT"))
				{
					statusId = 3;
				}
				status.setId(statusId);
				budgetHeader.setStatus(status);
				
				budgetHeader.setPreparedBy(user);		
				budgetHeader.setLastChgBy(user);
				budgetHeader.setLastChgDate(changedDate);
				budgetHeader.setLastChgTime(changedTime);
				budgetHeader.setLocation(location);
				budgetHeader.setDepartment(department);
				System.out.println("BudgetSystemGeneratedHeaderId13="+BudgetSystemGeneratedHeaderId);
				
				try{
					
					tx = session.beginTransaction();
		
					hbt.save(budgetHeader);
					hbt.refresh(budgetHeader);
					
						
					
					tx.commit();
					bSuccessfullyAdded = true;
				}
				
				catch(Exception e)
				{
					System.out.println("dd="+e);
					if (tx != null) {
						tx.rollback();
						e.printStackTrace();
						System.out.print(e);
					}
				}
		}//close if where bRecordExist is checked
		
		String message="";
		if (bRecordExist) {
			message = "Final Budget already submitted for this financial year.";
		} else {
			if (bSuccessfullyAdded) {
				if(txtRequestType.equalsIgnoreCase("SAVE"))
				{
					message = "Budget saved Successfully and Your Budget Reference Id is: "
							+ BudgetSystemGeneratedHeaderId;
				}
				if(txtRequestType.equalsIgnoreCase("SUBMIT"))
				{
					message = "Final Budget submitted Successfully and Your Budget Reference Id is: "
							+ BudgetSystemGeneratedHeaderId;
				}
				
			} else {

				message = "Try Again!";
			}
		}
		map.put("message", message);
		map.put("bSuccessfullyAdded", bSuccessfullyAdded);
		map.put("BudgetSystemGeneratedHeaderId", BudgetSystemGeneratedHeaderId);

		return map;		

				
		
	}
	
	private Map<String, Object> generateSystemId(String ObjectName, String LocationType ,int year,int season,  int locationId, int departmentId) 
	{
		
		 Map<String,Object>transactionSequenceMap = new HashMap<String,Object>();
		 Session session = getSession();
			
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
			boolean bTransactionSequenceInsertion = true;
			int sequenceNumber =0;
			String prefix = loadProperties().getProperty(ObjectName+".prefix");
			String suffix = "";
			String locationCode = "";
			
			List<MasStoreFinancial> financialyear = new ArrayList<MasStoreFinancial>();
			financialyear = session.createCriteria(MasStoreFinancial.class)
					.add(Restrictions.eq("Id", year))
					.list();
			for (MasStoreFinancial yearList : financialyear) 
			{
				String yearName = yearList.getYearDescription();
				suffix = yearName;
				
			}
			
			List<MasHospital> location = new ArrayList<MasHospital>();
			location = session.createCriteria(MasHospital.class).add(Restrictions.eq("Id", locationId)).list();
			for (MasHospital locationList : location) 
			{
				locationCode = locationList.getHospitalCode();			
				
			}
			
			List<TransactionSequence> seqNoList = new ArrayList<TransactionSequence>();
			seqNoList = session.createCriteria(TransactionSequence.class)
							/*.add(Restrictions.eq("TransactionPrefix", prefix))
							.add(Restrictions.eq("TransactionSuffix", suffix))*/
							.add(Restrictions.eq("Tablename", ObjectName))
							.add(Restrictions.eq("Department.Id", departmentId)).add(Restrictions.eq("Hospital.Id", locationId)).list();
			int TransactionSequenceId =0;

			if(seqNoList.size() > 0)
			{
					for (TransactionSequence transactionSequence : seqNoList) 
					{
						sequenceNumber = transactionSequence.getTransactionSequenceNumber();
						TransactionSequenceId = transactionSequence.getId();
						sequenceNumber++;
					}
					bTransactionSequenceInsertion = false;
					
			}
			else
			{
				sequenceNumber++;
			}
			String SystemGenerateId ="";
			String seasonCode = "";
			if(season == 1)
			{
				seasonCode = "/RB";
			}
			if(season == 2)
			{
				seasonCode = "/KH";
			}
			if(season == 0)
			{
				seasonCode = "";
			}
			
			if(LocationType.equalsIgnoreCase("HO"))
			{
				if(seasonCode.length()>0)
				{
					SystemGenerateId = "HO"+prefix+seasonCode+"-"+sequenceNumber+"-"+suffix+"/"+locationCode;
				}
				else
				{
					SystemGenerateId = "HO"+prefix+"-"+sequenceNumber+"-"+suffix+"/"+locationCode;
				}
				
			}
			else
			{
				if(seasonCode.length()>0)
				{
					SystemGenerateId = prefix+seasonCode+"-"+sequenceNumber+"-"+suffix+"/"+locationCode;
				}
				else
				{
					SystemGenerateId = prefix+"-"+sequenceNumber+"-"+suffix+"/"+locationCode;
				}
			}
			
			
			transactionSequenceMap.put("SystemGenerateId", SystemGenerateId);
			transactionSequenceMap.put("bTransactionSequenceInsertion", bTransactionSequenceInsertion);
			transactionSequenceMap.put("prefix", prefix);
			transactionSequenceMap.put("suffix", suffix);
			transactionSequenceMap.put("TransactionSequenceId", TransactionSequenceId);
			transactionSequenceMap.put("sequenceNumber", sequenceNumber);
			
			seqNoList.clear();
			location.clear();
			financialyear.clear();
			return transactionSequenceMap;
	}
	
	private Properties loadProperties(){
		
		
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return properties;
		
		
	}
	
	
	public  boolean approveFinalAccountsBudget(Box box) {
		Map<String,Object> map = new HashMap<String,Object>();
		List<MktBudgetHeader> MktBudgetHeaderIdList = new ArrayList<MktBudgetHeader>();
		List<MktBudgetHeader> budgetHeaderList = new ArrayList<MktBudgetHeader>();
		
		Session session = (Session) getSession();
		Transaction tx = null;
		boolean bSuccessfullyAdded = false;
		boolean bRecordExist = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		
		int txtBudgetHeaderId = box.getInt("txtBudgetHeaderId");
		
		int ddlApprovalStatus = box.getInt("ddlApprovalStatus");
		String txtApprovalRemarks = box.getString("txtApprovalRemarks");
		double TotalFinalBudgetAmount = box.getDouble("TotalFinalBudgetAmount");
												   
		
				
		int UserId = box.getInt("CHANGED_BY");
		Users user = new Users();
		user.setId(UserId);
		
		
		
		
					Map<String,Object>transactionSequenceMap = new HashMap<String,Object>();
           
            
            	
				MktBudgetHeader budgetHeader = new MktBudgetHeader();
				budgetHeader = (MktBudgetHeader)hbt.get(MktBudgetHeader.class, txtBudgetHeaderId);
				
				if(budgetHeader != null)
				{
					budgetHeader.setTotal(new BigDecimal(TotalFinalBudgetAmount));
					
					
					int statusId = 0;
					if(ddlApprovalStatus != 0)
					{
						MasApprovalStatus status = new MasApprovalStatus();
						status.setId(ddlApprovalStatus);
						budgetHeader.setStatus(status);
					}	
					
					
					budgetHeader.setApprovedBy(user);		
					budgetHeader.setApprovalRemarks(txtApprovalRemarks);
					
				}
				
						
				try{
					
					tx = session.beginTransaction();	
					hbt.save(budgetHeader);
					hbt.refresh(budgetHeader);
					
						
					
					tx.commit();
					bSuccessfullyAdded = true;
				}
				
				catch(Exception e)
				{
					System.out.println("dd="+e);
					if (tx != null) {
						tx.rollback();
						e.printStackTrace();
						System.out.print(e);
					}
				}
		
		
		

		return bSuccessfullyAdded;		

				
		
	}
	@Override
	public int getAccountSubGroup(int accountId) {
		int accountSubGroupId=0;
		Session session=(Session)getSession();
		List<FaMasAccount>accList=new ArrayList<FaMasAccount>();
		System.out.println("accountId data service-------->>"+accountId);
		accList=session.createCriteria(FaMasAccount.class).add(Restrictions.idEq(accountId)).list();
		for(FaMasAccount FaMasAccount:accList){
			accountSubGroupId=FaMasAccount.getAccountSubGroup().getId();
		}
		System.out.println("accountSubGroupId in data------>>"+accountSubGroupId);
		return accountSubGroupId;
	}
	
	@Override
	public Map<String, Object> getGrowerPurchasePaymentHistory(Box box) {
		Map<String, Object> datamap = new HashMap();
		 List<ProdGrowerPayment> growerPurchasePaymentHistory = new ArrayList<ProdGrowerPayment>();
		 List<FaMasSubLed> masSubLedger = new ArrayList<FaMasSubLed>();
		 List<FaVoucherHeader> vendorPurchasePaymentHistory = new ArrayList<FaVoucherHeader>();
		  
		  Session session = getSession();
		  int pagingSize = 10;
		  int pageNo = 1;
		  int ddlSeason = 0;
		  int ddlYear = 0;
		  int ddlCropList = 0;
		  int ddlVarietyList = 0;
		  
		  int locationId = 0;
		  
		  String purchaseType="NA";
		  purchaseType = box.getString("purchaseType");
		  
		 if(purchaseType.equalsIgnoreCase("Grower"))
		 {
			 if (box.getString("PN") != null) {
				    pageNo = Integer.parseInt(box.getString("PN"));
				  }
				  if (box.getInt("ddlSeason") != 0) {
				    ddlSeason = box.getInt("ddlSeason");
				  }
				  if (box.getInt("ddlYear") != 0) {
				    ddlYear = box.getInt("ddlYear");
				  }
				  if (box.getInt("ddlCropList") != 0) {
				    ddlCropList = box.getInt("ddlCropList");
				  }
				  if (box.getInt("ddlVarietyList") != 0) {
				    ddlVarietyList = box.getInt("ddlVarietyList");
				  }
				
				  
				  locationId = box.getInt("locationId");
				  
				  
				  Criteria cr = null;
				  cr = session.createCriteria(ProdGrowerPayment.class);
				  cr = cr.createAlias("SeedQuality", "qc");
				 // cr= cr.add(Restrictions.or(Restrictions.eq("PaymentStatus", "Advance").ignoreCase(), Restrictions.eq("PaymentStatus", "Final").ignoreCase()));
				
				  if (ddlSeason != 0)
				  {
				    cr = cr.createAlias("qc.Season", "season");
				    cr = cr.add(Restrictions.eq("season.Id", Integer.valueOf(ddlSeason)));
				  }
				  if (ddlYear != 0)
				  {
				    cr = cr.createAlias("qc.ProdYear", "yr");
				    cr = cr.add(Restrictions.eq("yr.Id", Integer.valueOf(ddlYear)));
				  }
				  if (ddlCropList != 0)
				  {
				    cr = cr.createAlias("qc.Crop", "cr");
				    cr = cr.add(Restrictions.eq("cr.Id", Integer.valueOf(ddlCropList)));
				  }
				  if (ddlVarietyList != 0)
				  {
				    cr = cr.createAlias("qc.SeedVariety", "vr");
				    cr = cr.add(Restrictions.eq("vr.Id", Integer.valueOf(ddlVarietyList)));
				  }
				
				  cr = cr.add(Restrictions.isNotNull("VoucherNo"));
				  if (locationId != 0)
				  {
				    cr = cr.createAlias("qc.Location", "centre");
				    cr = cr.add(Restrictions.eq("centre.Id", locationId));
				  }
				  cr = cr.addOrder(Order.desc("LastChgDate"));
				  List totalMatches = cr.list();
				  cr = cr.setFirstResult(pagingSize * (pageNo - 1));
				  cr = cr.setMaxResults(pagingSize);
				  growerPurchasePaymentHistory = cr.list();
				  
				  int totalRecords = totalMatches.size();
				  totalMatches.clear();
				  
				  masSubLedger = session.createCriteria(FaMasSubLed.class)
						  .createAlias("Hospital", "location").add(Restrictions.eq("location.Id", locationId))
						  .add(Restrictions.isNotNull("Grower"))
						  .list();
				  
                  
				  datamap.put("masSubLedger", masSubLedger);
				  datamap.put("growerPurchasePaymentHistory", growerPurchasePaymentHistory);
				  datamap.put("totalRecords", Integer.valueOf(totalRecords)); 
			 
		 }
		 
		 
		 if(purchaseType.equalsIgnoreCase("Vendor"))
		 {
			 if (box.getString("PN") != null) {
				    pageNo = Integer.parseInt(box.getString("PN"));
				  }
				  if (box.getInt("ddlSeason") != 0) {
				    ddlSeason = box.getInt("ddlSeason");
				  }
				  if (box.getInt("ddlYear") != 0) {
				    ddlYear = box.getInt("ddlYear");
				  }
				  if (box.getInt("ddlCropList") != 0) {
				    ddlCropList = box.getInt("ddlCropList");
				  }
				  if (box.getInt("ddlVarietyList") != 0) {
				    ddlVarietyList = box.getInt("ddlVarietyList");
				  }
				
				  
				  locationId = box.getInt("locationId");
				  
				  
				  Criteria cr = null;
				  cr = session.createCriteria(FaVoucherHeader.class);
				 // cr = cr.createAlias("MasStoreSupplier", "sp");
				  cr = cr.add(Restrictions.isNotNull("Supplier"));
				 // cr= cr.add(Restrictions.or(Restrictions.eq("PaymentStatus", "Advance").ignoreCase(), Restrictions.eq("PaymentStatus", "Final").ignoreCase()));
				
				  
				  if (locationId != 0)
				  {
				    cr = cr.createAlias("Hospital", "centre");
				    cr = cr.add(Restrictions.eq("centre.Id", Integer.valueOf(locationId)));
				  }
				  cr = cr.addOrder(Order.desc("LastChgDate"));
				  List totalMatches = cr.list();
				  cr = cr.setFirstResult(pagingSize * (pageNo - 1));
				  cr = cr.setMaxResults(pagingSize);
				  vendorPurchasePaymentHistory = cr.list();
				  
				  int totalRecords = totalMatches.size();
				  totalMatches.clear();
				  

				  datamap.put("vendorPurchasePaymentHistory", vendorPurchasePaymentHistory);
				  datamap.put("totalRecords", Integer.valueOf(totalRecords)); 
			 
		 }
		  
		 
		  
		  
		  return datamap;
	}

	
	@Override
	public Map<String, Object> getBilingTransactionHistory(Box box) {
		Map<String,Object> datamap = new HashMap<String,Object>();
		List<BlDispensingHeader> billDetails = new ArrayList<BlDispensingHeader>();
		
		
		Session session = (Session) getSession();
		int pagingSize = 10;
		int pageNo = 1;
	
		int Id = 0;		
		String TransactionType = "";
		int locationId = 0;
		
		
		if (box.getString("PN") != null)
		{
			pageNo = Integer.parseInt(box.getString("PN"));	
		}
		
		
			Id = box.getInt("Id");		
		    locationId = box.getInt("locationId");		
			TransactionType = box.getString("TransactionType");
		
		
		Criteria cr = null;
		cr = session.createCriteria(BlDispensingHeader.class);
		cr = cr.add(Restrictions.isNull("VoucherNo"));
		cr = cr.add(Restrictions.eq("ActionType", "CashBill").ignoreCase());
	
			
		
		
		if (locationId != 0 ) {
			cr = cr.createAlias("Location", "location");
			cr = cr.add(Restrictions.eq("location.Id", locationId));
		}		
		
		 cr = cr.addOrder(Order.desc("BillInvoiceDate"));		
		
		List totalMatches = cr.list();
		cr = cr.setFirstResult(pagingSize * (pageNo - 1));
		cr = cr.setMaxResults(pagingSize);
		billDetails = cr.list();

		System.out.println("Total records=" + totalMatches.size());
		int totalRecords = totalMatches.size();
		totalMatches.clear();

		datamap.put("billDetails", billDetails);
		datamap.put("totalRecords", totalRecords);
		

		return datamap;
	}
	@Override
	public Map<String, Object> getSalesTransactionHistory(Box box) {
		
		Map<String, Object> datamap = new HashMap();		
		List<Object[]> salesTransaction = new ArrayList<Object[]>();
		List<BlDispensingDetails> salesTransaction1 = new ArrayList<BlDispensingDetails>();
		
		Session session = (Session)getSession();
		Criteria cr = null;
		
		  int pagingSize = 10;
		  int pageNo = 1;		  
		  int locationId = 0;		  
		  String txtFromDate = "";		    
		  String txtToDate = "";
		   
		  pageNo = box.getInt("PN");
		  txtFromDate = box.getString("txtFromDate");		   
		  txtToDate = box.getString("txtToDate");		  
		  locationId = box.getInt("locationId");
		  
		cr = session.createCriteria(BlDispensingDetails.class);
		cr= cr.createAlias("DispensingHeader", "header",CriteriaSpecification.LEFT_JOIN);
		cr= cr.createAlias("header.Location", "location");
		cr= cr.createAlias("Item", "item",CriteriaSpecification.LEFT_JOIN);
		cr= cr.createAlias("ItemVariety", "variety",CriteriaSpecification.LEFT_JOIN);
		cr= cr.createAlias("ItemClass", "itemClass",CriteriaSpecification.LEFT_JOIN);
		if(locationId != 0)
		{
			cr= cr.add(Restrictions.eq("location.Id", locationId));	
		}
		    // cr= cr.add(Restrictions.eq("itemClass.Id", 1));	
		     
		String TransactionType = box.getString("TransactionType");
		if(TransactionType.equalsIgnoreCase("RSK"))
		{
			cr= cr.add(Restrictions.eq("header.BillingType", "RSK").ignoreCase());	
		}
		if(TransactionType.equalsIgnoreCase("Farmers"))
		{
			//cr= cr.add(Restrictions.eq("header.BillingType", "Farmers").ignoreCase());
			cr= cr.add(Restrictions.or(Restrictions.eq("header.BillingType", "Farmers").ignoreCase(), Restrictions.eq("header.BillingType", "").ignoreCase()));
		}
		if(TransactionType.equalsIgnoreCase("ShareHolder"))
		{
			cr= cr.add(Restrictions.eq("header.BillingType", "ShareHolder").ignoreCase());	
		}
		if ((txtFromDate != null) && (txtToDate != null) && (!txtToDate.equals("")) && (!txtFromDate.equals("")))
		{
		  cr = cr.add(Restrictions.between("header.BillInvoiceDate", HMSUtil.convertStringTypeDateToDateType(txtFromDate), HMSUtil.convertStringTypeDateToDateType(txtToDate)));
		 }
		cr = cr.addOrder(Order.asc("Item"));
		cr=cr.setProjection(Projections.projectionList()
				.add(Projections.property("header.BillingType"))
				.add(Projections.property("location.HospitalName"))
				.add(Projections.property("item.Nomenclature"))
				.add(Projections.property("variety.ItemVarietyName"))				
				.add(Projections.sum("Qty"))
				.add(Projections.property("Rate"))
				.add(Projections.sum("Amount"))	
				.add(Projections.property("itemClass.ItemClassCode"))
				.add(Projections.groupProperty("itemClass.Id"))
				.add(Projections.groupProperty("header.Location.Id"))
				.add(Projections.groupProperty("variety.Id")));
				
		
			List totalMatches = cr.list();
			cr = cr.setFirstResult(pagingSize * (pageNo - 1));
			cr = cr.setMaxResults(pagingSize);
			salesTransaction = cr.list();
		
		
		
		  
	    int totalRecords = totalMatches.size();
		totalMatches.clear();
		  System.out.println("salesTransaction"+salesTransaction.size());

		  datamap.put("salesTransaction", salesTransaction);
		  datamap.put("totalRecords", Integer.valueOf(totalRecords));
				
		
		return datamap;
	}
	@Override
	public String getLocationName(int locationId) {
		List<MasHospital> locationList = new ArrayList<MasHospital>();
		Session session = (Session)getSession();
		String locationName="";
		locationList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Id", locationId)).list();
		
		for(MasHospital list: locationList)
		{
			locationName = list.getHospitalName().toString();
		}
	return locationName;
	}
	
	@Override
	public Map<String, Object> showStatementProfitAndLossAcJsp(Map<String, Object> datamap) 
	{
		Session session = (Session)getSession();
		List<MasStoreFinancial> masStoreFinancialList = new ArrayList<MasStoreFinancial>();
		List<MasStoreFinancial> financialYearList = new ArrayList<MasStoreFinancial>();
		List<MasStoreFinancial> nextFinancialYearList = new ArrayList<MasStoreFinancial>();
		List<AccountMainTransac> currentFinancialYearAccountList = new ArrayList<AccountMainTransac>();
		List<MasScheduleMaster> scheduleListForPnL = new ArrayList<MasScheduleMaster>();
		Map<String, Object> map = new HashMap<String, Object>();
		int fYearId = 0;
		int locationId = 0;
		
		if(datamap.get("fYearId")!= null){
			fYearId = (Integer)datamap.get("fYearId");
		}
		if(datamap.get("locationId")!= null){
			locationId = (Integer)datamap.get("locationId");
		}
		
		scheduleListForPnL = session.createCriteria(MasScheduleMaster.class).add(Restrictions.or(Restrictions.eq("ScheduleGroup.Id", 3) , Restrictions.eq("ScheduleGroup.Id", 4))).list();
		
		
		currentFinancialYearAccountList = session.createCriteria(AccountMainTransac.class)
											.add(Restrictions.eq("Location.Id",locationId))
											.add(Restrictions.eq("FinancialYear.Id", fYearId)).list();
		
		financialYearList = session.createCriteria(MasStoreFinancial.class).add(Restrictions.idEq(fYearId)).list();

		String currentYearDesc = "";
		String currentFinancialYear="";
		if(financialYearList.size()>0){
			currentYearDesc = financialYearList.get(0).getYearDescription();
			currentFinancialYear= financialYearList.get(0).getFinancialYear();
		}
		int nextFinancialYearId = 0;
		String nextFinancialYear="";
		String nextYearDesc = "";
		String currentYearDesc1 = "";
		if(financialYearList.size()>0){
			currentYearDesc1 = financialYearList.get(0).getYearDescription();
		/*	nextYearDesc = ""+(Integer.parseInt(currentYearDesc1)1);
			nextFinancialYearList = session.createCriteria(MasStoreFinancial.class).add(Restrictions.eq("YearDescription", nextYearDesc)).list();
			nextFinancialYearId = nextFinancialYearList.get(0).getId();
			nextFinancialYear = nextFinancialYearList.get(0).getFinancialYear();*/
			map.put("nextFinancialYear", currentYearDesc1+1);
		}
		masStoreFinancialList = session.createCriteria(MasStoreFinancial.class).addOrder(Order.asc("FinancialYear")).add(Restrictions.between("YearDescription",  ""+(Integer.parseInt(currentYearDesc)-3),""+(Integer.parseInt(currentYearDesc)+1))).list();
		
		map.put("currentFinancialYearAccountList", currentFinancialYearAccountList);
		map.put("currentFinancialYear", currentFinancialYear);
		map.put("masStoreFinancialList", masStoreFinancialList);
		map.put("currentYearDesc", currentYearDesc);
		map.put("scheduleListForPnL", scheduleListForPnL);
		
		return map;
		
		
	}
			
	@Override
	public Map<String, Object> showStatementPLACJsp(
			Map<String, Object> datamap) {
		Session session = (Session)getSession();
		List<MasScheduleMaster> scheduleListForPnL = new ArrayList<MasScheduleMaster>();
		List<AccountMainTransac> selectedFinancialYearAccountList = new ArrayList<AccountMainTransac>();
		List<MasStoreFinancial> financialYearList = new ArrayList<MasStoreFinancial>();
		List<MasStoreFinancial> lastFinancialYearList = new ArrayList<MasStoreFinancial>();
		List<MasStoreFinancial> last2FinancialYearList = new ArrayList<MasStoreFinancial>();
		List<MasStoreFinancial> nextFinancialYearList = new ArrayList<MasStoreFinancial>();
		
		Map<String, Object> map = new HashMap<String, Object>();
		int fYearId = 0;
		int locationId = 0;
		if(datamap.get("yearId")!= null){
			fYearId = (Integer)datamap.get("yearId");
		}
		

		if(datamap.get("locationId")!= null){
			locationId = (Integer)datamap.get("locationId");
		}
		
		financialYearList = session.createCriteria(MasStoreFinancial.class).add(Restrictions.idEq(fYearId)).list();
		scheduleListForPnL = session.createCriteria(MasScheduleMaster.class).add(Restrictions.or(Restrictions.eq("ScheduleGroup.Id", 3) , Restrictions.eq("ScheduleGroup.Id", 4))).list();
		selectedFinancialYearAccountList = session.createCriteria(AccountMainTransac.class).add(Restrictions.eq("Location.Id",locationId)).add(Restrictions.eq("FinancialYear.Id", fYearId)).list();
		
		int lastFinancialYearId = 0;
		String lastFinancialYear="";
		String lastYearDesc = "";
		String currentYearDesc = "";
		String currentFinancialYear = "";
	/*	if(financialYearList.size()>0){
			currentYearDesc = financialYearList.get(0).getYearDescription();
			currentFinancialYear= financialYearList.get(0).getFinancialYear();
			lastYearDesc = ""+(Integer.parseInt(currentYearDesc)-1);
			lastFinancialYearList = session.createCriteria(MasStoreFinancial.class).add(Restrictions.eq("YearDescription", lastYearDesc)).list();
			lastFinancialYearId = lastFinancialYearList.get(0).getId();
			lastFinancialYear = lastFinancialYearList.get(0).getFinancialYear();
			map.put("lastFinancialYear", lastFinancialYear);
		}*/
		
		int nextFinancialYearId = 0;
		String nextFinancialYear="";
		String nextYearDesc = "";
		String currentYearDesc1 = "";
	/*	if(financialYearList.size()>0){
			currentYearDesc1 = financialYearList.get(0).getYearDescription();
			nextYearDesc = ""+(Integer.parseInt(currentYearDesc1)+1);
			nextFinancialYearList = session.createCriteria(MasStoreFinancial.class).add(Restrictions.eq("YearDescription", nextYearDesc)).list();
			nextFinancialYearId = nextFinancialYearList.get(0).getId();
			nextFinancialYear = nextFinancialYearList.get(0).getFinancialYear();
			map.put("nextFinancialYear", nextFinancialYear);
		}*/
		int last2FinancialYearId = 0;
		String last2FinancialYear="";
		String last2YearDesc = "";
		String current2YearDesc = "";
	/*	if(lastFinancialYearList.size()>0){
			current2YearDesc = lastFinancialYearList.get(0).getYearDescription();
			last2YearDesc = ""+(Integer.parseInt(current2YearDesc)-1);
			last2FinancialYearList = session.createCriteria(MasStoreFinancial.class).add(Restrictions.eq("YearDescription", last2YearDesc)).list();
			last2FinancialYearId = last2FinancialYearList.get(0).getId();
			last2FinancialYear = last2FinancialYearList.get(0).getFinancialYear();
			
			map.put("last2FinancialYear", last2FinancialYear);
		}*/
		
		map.put("scheduleListForPnL", scheduleListForPnL);
		map.put("currentFinancialYear", currentFinancialYear);
		map.put("financialYearList", financialYearList);
		map.put("selectedFinancialYearAccountList",selectedFinancialYearAccountList);
		return map;
		
		
	}
	
	@Override
	public boolean deleteAccount(int accountId,Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		Session session = (Session)getSession();
		int userId = 0;
		
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
			FaMasAccount faMasAccount = new FaMasAccount();
			faMasAccount = (FaMasAccount) getHibernateTemplate().get(
					FaMasAccount.class, accountId);
			
			userId = (Integer) generalMap.get("userId");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			
			
			if (flag.equals("InActivate")) {
				faMasAccount.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				faMasAccount.setStatus("y");
				dataDeleted = false;
			}
		}
		Users user = new Users();
		user.setId(userId);
		faMasAccount.setLastChgBy(user);
		
		faMasAccount.setLastChgDate(currentDate);
		faMasAccount.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(faMasAccount);
		return dataDeleted;
	}

	@Override
	public Map<String, Object> showScheduleMasterJsp(Map<String, Object> generalMap) {
		 Map<String, Object> map = new HashMap<String, Object>(); 
		  List<FaMasAccountGroup> accountGroupList = new ArrayList<FaMasAccountGroup>();
		  List<MasScheduleMaster> existingScheduleList = new ArrayList<MasScheduleMaster>();
		 Session session = (Session)getSession();
		
		 int fYear = 0;
			if(generalMap.get("fYear") != null){
				fYear = (Integer)generalMap.get("fYear");
			}
		
		   accountGroupList = session.createCriteria(FaMasAccountGroup.class).add(Restrictions.eq("Status", "y")).list();
		   existingScheduleList = session.createCriteria(MasScheduleMaster.class).list();
		   map.put("existingScheduleList", existingScheduleList);
		   map.put("accountGroupList", accountGroupList);
		return map;
	}

	@Override
	public Map<String, Object> addScheduleMaster(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasScheduleMaster> existingAccountList = new ArrayList<MasScheduleMaster>();
		List<MasScheduleMaster> existingScheduleList = new ArrayList<MasScheduleMaster>();
		List<FaMasAccountGroup> accountGroupList = new ArrayList<FaMasAccountGroup>();	
		
	
		Session session =(Session)getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		MasScheduleMaster masScheduleMaster = new MasScheduleMaster();
		String message = "";
		try{
			int groupId =0;
			if(generalMap.get("accountgroupId")!= null){
				groupId = (Integer)generalMap.get("accountgroupId");
				
				
				
			}
			int scheduleCode =0;
			if(generalMap.get("scheduleCode")!= null){
				scheduleCode = (Integer)generalMap.get("scheduleCode");
				
			}
			
			
			String scheduleDescription ="";
			if(generalMap.get("scheduleDescription")!= null){
				scheduleDescription = (String)generalMap.get("scheduleDescription");
			}
			
			FaMasAccountGroup faMasAccountGroup = new FaMasAccountGroup();
			faMasAccountGroup.setId(groupId);
			
			
			masScheduleMaster.setScheduleCode(scheduleCode);
			masScheduleMaster.setScheduleGroup(faMasAccountGroup);
			masScheduleMaster.setScheduleDescription(scheduleDescription);
			masScheduleMaster.setStatus("y");
			
			existingAccountList = session.createCriteria(MasScheduleMaster.class).add(Restrictions.eq("ScheduleCode", scheduleCode)).list();
			
			if (existingAccountList.size() > 0) {
				message = "Record already Exist";
				System.out.println(message);
			} else {
				hbt.save(masScheduleMaster);
				session.refresh(masScheduleMaster);
				message = "Record saved successfully!";
				
		}
			
		}
		catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		existingScheduleList = session.createCriteria(MasScheduleMaster.class).list();
		accountGroupList = session.createCriteria(FaMasAccountGroup.class).add(Restrictions.eq("Status", "y")).list();
	  
		map.put("existingScheduleList", existingScheduleList);
		map.put("accountGroupList", accountGroupList);
		map.put("message", message);
		
		return map;
	}

	@Override
	public Map<String, Object> updateScheduleMaster(Map<String, Object> generalMap) {
		List<MasScheduleMaster> existingScheduleList = new ArrayList<MasScheduleMaster>();
		List<MasScheduleMaster> existingAccountList = new ArrayList<MasScheduleMaster>();
		List<FaMasAccountGroup> accountGroupList = new ArrayList<FaMasAccountGroup>();	
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		try{
			String message = "";
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
			
			
			int scheduleCode =0;
			if(generalMap.get("scheduleCode")!= null){
				scheduleCode = (Integer)generalMap.get("scheduleCode");
				
			}
			
			String scheduleDescription ="";
			if(generalMap.get("scheduleDescription")!= null){
				scheduleDescription = (String)generalMap.get("scheduleDescription");
			}
			int groupId =0;
			if(generalMap.get("accountgroupId")!= null){
				groupId = (Integer)generalMap.get("accountgroupId");
			}
			List<MasScheduleMaster> masScheduleMasterList = session.createCriteria(MasScheduleMaster.class).add(Restrictions.eq("ScheduleCode", scheduleCode)).list();		
			existingAccountList = session.createCriteria(MasScheduleMaster.class).add(Restrictions.eq("ScheduleDescription", scheduleDescription)).add(Restrictions.eq("ScheduleGroup.Id", groupId)).list();
			
			
			if (existingAccountList.size() > 0) {
				message = "Record Already exists!";
				System.out.println(message);
				
				
			} else {
				MasScheduleMaster masScheduleMaster = masScheduleMasterList.get(0);
				FaMasAccountGroup faMasAccountGroup = new FaMasAccountGroup();
				faMasAccountGroup.setId(groupId);
				
				masScheduleMaster.setScheduleCode(scheduleCode);
				masScheduleMaster.setScheduleGroup(faMasAccountGroup);
				masScheduleMaster.setScheduleDescription(scheduleDescription);
				masScheduleMaster.setStatus("y");	
				hbt.update(masScheduleMaster);
				session.refresh(masScheduleMaster);
				message = "Record updated successfully!";
				System.out.println(message);
		}
			
		}catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			accountGroupList = session.createCriteria(FaMasAccountGroup.class).add(Restrictions.eq("Status", "y")).list();
			existingScheduleList = session.createCriteria(MasScheduleMaster.class).list();
			map.put("existingScheduleList",existingScheduleList);
			map.put("accountGroupList", accountGroupList);
			return map;
	}

	@Override
	public Map<String, Object> getScheduleList(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasScheduleMaster> scheduleList = new ArrayList<MasScheduleMaster>();
		Session session = (Session) getSession();
		int accountGroup = 0;
		try {
			
			if(dataMap.get("accountGroup") != null ){
				accountGroup = (Integer)dataMap.get("accountGroup");
			}
			scheduleList = session.createCriteria(MasScheduleMaster.class).add(Restrictions.eq("ScheduleGroup.Id", accountGroup)).add(Restrictions.eq("Status", "y")).list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("scheduleList", scheduleList);
		return map;
	}

	@Override
	public Map<String, Object> deleteScheduleMaster(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasScheduleMaster> existingScheduleList = new ArrayList<MasScheduleMaster>();
		List<FaMasAccountGroup> accountGroupList = new ArrayList<FaMasAccountGroup>();
		Session session = (Session)getSession();
		
		String message = "";
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		int scheduleCode =0;
		if(generalMap.get("scheduleCode")!= null){
			scheduleCode = (Integer)generalMap.get("scheduleCode");
			
		}
		String flag="";
		if (generalMap.get("flag") != null) {
			flag = (String) generalMap.get("flag");
			
		}
			
			List<MasScheduleMaster> masScheduleMasterList = session.createCriteria(MasScheduleMaster.class).add(Restrictions.eq("ScheduleCode", scheduleCode)).list();				
			MasScheduleMaster masScheduleMaster = masScheduleMasterList.get(0);		
		
			if (flag.equals("InActivate")) {
				masScheduleMaster.setStatus("n");
				message = "Record InActivated successfully  !!";
				
			} else if (flag.equals("Activate")) {
				masScheduleMaster.setStatus("y");
				message = "Record Activated successfully  !!";
				
			}
			
			hbt.update(masScheduleMaster);
			session.refresh(masScheduleMaster);
			
			
			accountGroupList = session.createCriteria(FaMasAccountGroup.class).add(Restrictions.eq("Status", "y")).list();
			existingScheduleList = session.createCriteria(MasScheduleMaster.class).list();
			map.put("message", message);
			map.put("existingScheduleList", existingScheduleList);
			map.put("accountGroupList", accountGroupList);
			return map;
	}

	@Override
	public Map<String, Object> getSubGroupList(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccountSubGroup> subGroupList = new ArrayList<FaMasAccountSubGroup>();
		Session session = (Session) getSession();
		int accountGroup = 0;
		try {
			
			if(dataMap.get("accountGroup") != null ){
				accountGroup = (Integer)dataMap.get("accountGroup");
			}
			subGroupList = session.createCriteria(FaMasAccountSubGroup.class).add(Restrictions.eq("AccountGroup.Id", accountGroup)).add(Restrictions.eq("Status", "y")).list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("subGroupList", subGroupList);
		return map;
	}

	@Override
	public boolean editAccountSubLedger(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int subLedgerId = 0;
		String subLedgerName = "";
		String subLedgerCode = "";
		Integer userId= 0;
		int accountId=0;
		int locationId=0;
		int rskId=0;
		subLedgerId = (Integer) generalMap.get("id");
		subLedgerCode = (String) generalMap.get("subLedgerCode");
		subLedgerName = (String) generalMap.get("name");
		locationId = (Integer) generalMap.get("locationId");
		rskId = (Integer) generalMap.get("rskId");
		
		accountId = (Integer) generalMap.get("accountId");
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		
		

		FaMasSubLed faMasSubLed = (FaMasSubLed) getHibernateTemplate().get(
				FaMasSubLed.class, subLedgerId);

			
		MasHospital l=new MasHospital();
		l.setId(locationId);
		faMasSubLed.setHospital(l);
		
	/*	if(rskId!=0)
		{
			MasRsk rsk =new MasRsk();
			rsk.setId(rskId);
			faMasSubLed.setRsk(rsk);
		}*/
	
		
			faMasSubLed.setSubLedDesc(subLedgerName);
			if(accountId!=0){
				
				FaMasAccount faMasAccount = new FaMasAccount();
				faMasAccount.setId(accountId);
				faMasSubLed.setAccount(faMasAccount);
}
		faMasSubLed.setStatus("y");
		Users user = new Users();
		user.setId(userId);
		faMasSubLed.setLastChgBy(user);
		
		
		
		faMasSubLed.setLastChgDate(currentDate);
		faMasSubLed.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(faMasSubLed);
		dataUpdated = true;
		return dataUpdated;
	}
	
	
	@Override
	public boolean deleteAccountSubLedger(int subLedgerId,Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		Session session = (Session)getSession();
		int userId = 0;
		
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		FaMasSubLed faMasSubLed = (FaMasSubLed) getHibernateTemplate().get(
				FaMasSubLed.class, subLedgerId);
			
			userId = (Integer) generalMap.get("userId");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			
			
			if (flag.equals("InActivate")) {
				faMasSubLed.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				faMasSubLed.setStatus("y");
				dataDeleted = false;
			}
		}
		Users user = new Users();
		user.setId(userId);
		faMasSubLed.setLastChgBy(user);
		
		faMasSubLed.setLastChgDate(currentDate);
		faMasSubLed.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(faMasSubLed);
		return dataDeleted;
	}

	@Override
	public Map<String, Object> searchScheduleMaster(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		 List<MasScheduleMaster> existingScheduleList = new ArrayList<MasScheduleMaster>();	Session session = getSession();
		  List<FaMasAccountGroup> accountGroupList = new ArrayList<FaMasAccountGroup>();
			 
			
		int searchRadio = 0;
		String searchField = "";
		Criteria crit = null;
		searchField = box.getString(SEARCH_FIELD);
		searchRadio = box.getInt(SELECTED_RADIO);
		
	
		crit = session.createCriteria(MasScheduleMaster.class);
		crit = crit.add(Restrictions.like("ScheduleDescription", searchField+"%"));
		existingScheduleList = crit.list();
		
		accountGroupList = session.createCriteria(FaMasAccountGroup.class).add(Restrictions.eq("Status", "y")).list();
		
		map.put("existingScheduleList", existingScheduleList);
		map.put("accountGroupList", accountGroupList);
		map.put("searchField", searchField); 
		return map;
		
	}

	@Override
	public Map<String, Object> showBankJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasBankMaster> searchBankList = new ArrayList<MasBankMaster>();
		searchBankList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasBankMaster "); 
		map.put("searchBankList", searchBankList);
		return map;
	}

	@Override
	public Map<String, Object> searchBank(String bankCode, String bankName) {
		// TODO Auto-generated method stub
		List<MasBankMaster> searchBankList = new ArrayList<MasBankMaster>();
		Map<String, Object> bankFieldsMap = new HashMap<String, Object>();
		try {
			if ((bankName != null) || (bankCode == null)) {
				searchBankList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasBankMaster bm where bm.BankName like '"
								+ bankName + "%' order by bm.BankName");
			} else {
				searchBankList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasBankMaster bm where bm.BankCode like '"
								+ bankCode + "%' order by bm.BankCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		bankFieldsMap.put("searchBankList", searchBankList);
		return bankFieldsMap;
	}

	@Override
	public boolean addBank(MasBankMaster masBank) {
		// TODO Auto-generated method stub
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masBank);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editBankToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String bankName = "";
		String bankAddress = "";
		@SuppressWarnings("unused")
		String bankCode = "";
		int bankId = 0;
		int changedBy = 0;

		bankId = (Integer) generalMap.get("id");
		bankCode = (String) generalMap.get("bankCode");
		bankAddress = (String) generalMap.get("bankAddress");
		bankName = (String) generalMap.get("name");
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasBankMaster masBank = (MasBankMaster) getHibernateTemplate().load(
				MasBankMaster.class, bankId);

		masBank.setId(bankId);
		masBank.setBankName(bankName);
		masBank.setBankAddress(bankAddress);
		
		Users users=new Users();
		users.setId(changedBy);
		masBank.setLastChgBy(users);
		
		masBank.setLastChgDate(currentDate);
		masBank.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masBank);
		dataUpdated = true;
		return dataUpdated;
	}

	@Override
	public boolean deleteBank(int bankId, Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		boolean dataDeleted = false;
		int changedBy = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasBankMaster masBank = new MasBankMaster();
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		masBank = (MasBankMaster) getHibernateTemplate().load(
				MasBankMaster.class, bankId);
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masBank.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masBank.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users=new Users();
		users.setId(changedBy);
		masBank.setLastChgBy(users);
		
		masBank.setLastChgDate(currentDate);
		masBank.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masBank);
		return dataDeleted;
	}
	private Integer[] convertIntArray(String[] strings) {
		 Integer[] intarray=new Integer[strings.length];
		    int i=0;
		    for(String str:strings){
		        intarray[i]=Integer.parseInt(str.trim());
		        i++;
		    }
		    return intarray;
	}

	@Override
	public String getAccountCode(int accountId) {
		int accountName=0;
		List<FaMasAccount>accountList=new ArrayList<FaMasAccount>();
		Session session=(Session)getSession();
		accountList = session.createCriteria(FaMasAccount.class).add(Restrictions.idEq(accountId)).list();
		if(accountList.size()>0){
			for(FaMasAccount  accList:accountList){
				accountName = accList.getAccCode();
			}
			return ""+accountName;
		}
		return ""+accountName;
		
	}

	@Override
	public Map<String, Object> pendingListForVoucherApproval(Box box) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaVoucherHeader> headerList = new ArrayList<FaVoucherHeader>();
		List<FaVoucherDetails> detailsList = new ArrayList<FaVoucherDetails>();
		Session session = (Session)getSession();
		Criteria cr=null;
		int pagingSize = 10;
		int pageNo = 1;
		
		SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
		String fromDate4MySQL = "";
		String toDate4MySQL = "";
		
		try {
			if(!box.getString(FROM_DATE).equalsIgnoreCase("0") && !box.getString(TO_DATE).equalsIgnoreCase("0")){
				fromDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(FROM_DATE)));
				 toDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(TO_DATE)));
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cr = session.createCriteria(FaVoucherHeader.class);
		
		if(box.getString("voucherType")!=null && !box.getString("voucherType").isEmpty()){
			cr = cr.add(Restrictions.eq("VoucherType", box.getString("voucherType")));
		}
		
		if(fromDate4MySQL!="" && toDate4MySQL!=""){
			cr = cr.add(Restrictions.between("VoucherDate", java.sql.Date.valueOf(fromDate4MySQL), java.sql.Date.valueOf(toDate4MySQL)));
		}
			cr =cr.add(Restrictions.isNull("ApprovalStatus"))
					.add(Restrictions.ne("VoucherType", "OP"))
					.add(Restrictions.eq("Hospital.Id",box.getInt("locationId")));
			
			headerList = cr.list();
		
		List totalMatches = cr.list();
		cr = cr.setFirstResult(pagingSize * (pageNo - 1));
		cr = cr.setMaxResults(pagingSize);

		int totalRecords = totalMatches.size();
		totalMatches.clear();
		
		map.put("totalRecords", totalRecords);
		map.put("headerList", headerList);
		return map;
	}

	@Override
	public Map<String, Object> getDataForVoucherApproval(Map<String, Object> map) {
		//This method is used for getting data of JV/PV/SV/RV types voucher
		
		List<FaVoucherDetails> voucherDetailList = new ArrayList<FaVoucherDetails>();
		List<FaVoucherHeader> voucherHeader = new ArrayList<FaVoucherHeader>();
		List<FaMasAccount> accList = new ArrayList<FaMasAccount>();
		Map<String,Object> vocherDetailsmap = new HashMap<String,Object>();
		Session session = (Session)getSession();
		Object[] bankAccountId = {40,41,42,78,79,80,38,39,145,113};
		
		int headerId = (Integer) map.get("headerId");
		voucherDetailList = session.createCriteria(FaVoucherDetails.class).add(Restrictions.eq("VoucherHeader.Id", headerId)).list();
		voucherHeader = session.createCriteria(FaVoucherHeader.class).add(Restrictions.eq("Id", headerId)).list();
		
		if(voucherHeader.size()>0){
			
			for(FaVoucherHeader header :voucherHeader ){
				vocherDetailsmap.put("voucherType", header.getVoucherType());
			}
		}
		accList = session.createCriteria(FaMasAccount.class)
				.add(Restrictions.in("Id", bankAccountId))
				.add(Restrictions.eq("Status", "y"))
				.list();
		vocherDetailsmap.put("voucherDetailList",voucherDetailList);
		vocherDetailsmap.put("voucherHeader",voucherHeader);
		vocherDetailsmap.put("accList",accList);
		return vocherDetailsmap;
	}

	@Override
	public Map<String, Object> displayRskPaymentVoucherDetails(Box box) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String, Object>();
		List<Object[]> rskPaymentVoucherList = new ArrayList<Object[]>();
		List<FaMasSubLed> subLedListOfCollectionAc = new ArrayList<FaMasSubLed>();
		Session session = (Session)getSession();
		SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
		String fromDate4MySQL = "";
		String toDate4MySQL = "";
		String fromDate = "";
		String toDate = "";
		int collectionAcId=0;
		int locationId = box.getInt("locationId");
		
		collectionAcId	= Integer.parseInt(HMSUtil.getProperties("adt.properties","COLLECTION_ACCOUNT_ID"));
		 
		try {
			fromDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(FROM_DATE)));
			 toDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(TO_DATE)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String invoiceQueryString ="select rpd.id,fma.acc_desc,a.account_id,a.sub_led_id,a.sub_led_desc,rpd.amount,rpd.payment_option,rpd.ref_no,rpd.ref_date,rpd.payment_remarks "+
				" from rsk_payment_details rpd "+
				" left outer join fa_mas_sub_led a on a.rsk_id = rpd.rsk_id "+
				" left outer join fa_mas_account fma on fma.acc_id = a.account_id "+
				" left outer join mas_hospital mh on mh.hospital_id = a.hospital_id "+
				" where rpd.voucher_no is null "+
				" and a.hospital_id="+locationId+""+
				" and rpd.ref_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"'";
		
		rskPaymentVoucherList = session.createSQLQuery(invoiceQueryString).list();

		subLedListOfCollectionAc =session.createCriteria(FaMasSubLed.class)
				.createAlias("Account", "acc")
				.createAlias("Hospital", "location")
				.add(Restrictions.eq("acc.Id", collectionAcId))
				.add(Restrictions.eq("location.Id", locationId)).list();

		map.put("rskPaymentVoucherList", rskPaymentVoucherList);
		map.put("subLedListOfCollectionAc",subLedListOfCollectionAc);
		map.put("fromDate",HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE)));
		map.put("toDate",HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE)));
		return map;
	}

	@Override
	public List<FaMasSubLed> getSubLedListForAccountId(int accountId,
			int locationId) {
		
		List<FaMasSubLed> subLedListForAccountId = new ArrayList<FaMasSubLed>();
		Session session = (Session)getSession();
		subLedListForAccountId =session.createCriteria(FaMasSubLed.class)
				.createAlias("Account", "acc")
				.createAlias("Hospital", "location")
				.add(Restrictions.eq("acc.Id", accountId))
				.add(Restrictions.eq("location.Id", locationId)).list();
		
		return subLedListForAccountId;
	}

	@Override
	public Map<String, Object> getSubledgerTransactionDetails(Box box) {
		// TODO Auto-generated method stub
		Map<String,Object> datamap = new HashMap<String,Object>();
		List<FaVoucherDetails> voucherDetails = new ArrayList<FaVoucherDetails>();
		
		Session session = (Session) getSession();
		int pagingSize = 10;
		int pageNo = 1;
	
		int Id = 0;		
		String TransactionType = "";
		int locationId = 0;
		
		String ProjectionType = "";
		if (box.getString("PN") != null)
		{
			pageNo = Integer.parseInt(box.getString("PN"));	
		}
		
			Id = box.getInt("ddlSubledgerId");		
		    locationId = box.getInt("locationId");		
			TransactionType = box.getString("TransactionType");
			
	
		
		Criteria cr = null;
		cr = session.createCriteria(FaVoucherDetails.class);
		cr = cr.createAlias("VoucherHeader", "header");
			
		
		if(TransactionType.equalsIgnoreCase("S"))
		{
			if (Id != 0 ) {
				cr = cr.createAlias("SubLed", "subledger");
				cr = cr.add(Restrictions.eq("subledger.Id", Id));
			}
		}
			
		
		if (locationId != 0 ) {
			cr = cr.createAlias("header.Hospital", "location");
			cr = cr.add(Restrictions.eq("location.Id", locationId));
		}
		
		
		 cr = cr.addOrder(Order.desc("header.VoucherDate"));
		
		
		List totalMatches = cr.list();
		cr = cr.setFirstResult(pagingSize * (pageNo - 1));
		cr = cr.setMaxResults(pagingSize);
		voucherDetails = cr.list();

	
		int totalRecords = totalMatches.size();
		totalMatches.clear();

	

		datamap.put("voucherDetails", voucherDetails);
		datamap.put("totalRecords", totalRecords);
		

		return datamap;
	}

	@Override
	public List<FaMasSubLed> getSubledgerDetails(Box box) {
		// TODO Auto-generated method stub
		List<FaMasSubLed> subledDetailsList = new ArrayList<FaMasSubLed>();
		Session session = (Session)getSession();
		subledDetailsList = session.createCriteria(FaMasSubLed.class).add(Restrictions.eq("Hospital.Id", box.getInt("locationId")))
		.add(Restrictions.eq("Id", box.getInt("subledId"))).list();
		return subledDetailsList;
	}

	@Override
	public List<MasApprovalStatus> getApprovalStatus() {
		// TODO Auto-generated method stub
		List<MasApprovalStatus> approvalStatus = new ArrayList<MasApprovalStatus>();
		Session session = (Session)getSession();
		approvalStatus  = session.createCriteria(MasApprovalStatus.class).add(Restrictions.eq("Status", "y")).list();
		
		return approvalStatus;
	}

	
	@Override
	public Map<String, Object> submitPaymentVoucherApproval(Box box) {
		// TODO Auto-generated method stub
		Map<String,Object>map = new HashMap<String, Object>();
		List<FaVoucherDetails> voucherDetails = new ArrayList<FaVoucherDetails>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Transaction tx =null;
		Session session = (Session)getSession();
		String voucherNo="";
		int voucherHeaderId= box.getInt("voucherHeaderId");
		boolean saved = false;	
		String approvalStatus="";
		BigDecimal totalAmountCr = new BigDecimal(0.0);
		if (!box.getString(TOTAL_AMOUNT).equals("")) {
			totalAmountCr = new BigDecimal(box.getString(TOTAL_AMOUNT));
		}
		
		int approvedId= Integer.parseInt(HMSUtil.getProperties("adt.properties", "approvedId"));
		
		try{
			tx = session.beginTransaction();
			FaVoucherHeader  voucherHeader = new FaVoucherHeader();
			if(box.getInt("ApprovalStatusId")==approvedId){
				
			
			FaVoucherDetails faVoucherDetail = new FaVoucherDetails();
			voucherDetails = session.createCriteria(FaVoucherDetails.class).createAlias("VoucherHeader", "header").add(Restrictions.eq("header.Id", voucherHeaderId)).list();
			if(voucherDetails.size()>0){
			for(FaVoucherDetails faDetails : voucherDetails){
				if(faDetails.getCrAmount()!=null){
					faVoucherDetail= (FaVoucherDetails)hbt.load(FaVoucherDetails.class,faDetails.getId());
					faVoucherDetail.setCrAmount(totalAmountCr);
					
					int centreId = getLocationIdForSubLedger(faDetails.getSubLed()!=null?faDetails.getSubLed().getId():0);
					int crAccountId = faDetails.getAccount().getId();
					int subLedId = faDetails.getSubLed()!=null?faDetails.getSubLed().getId():0;
					int fYearId = faDetails.getVoucherHeader().getFYear().getId();
					int locationId = faDetails.getVoucherHeader().getHospital().getId();
					hbt.update(faVoucherDetail);
					updateTransactionForPayment(subLedId, crAccountId, fYearId, locationId, ""+totalAmountCr, "0.00",centreId);
				}  else if(faDetails.getDrAmount()!=null){
					
					faVoucherDetail= (FaVoucherDetails)hbt.load(FaVoucherDetails.class,faDetails.getId());
					faVoucherDetail.setDrAmount(totalAmountCr);
					
					int centreId = getLocationIdForSubLedger(faDetails.getSubLed()!=null?faDetails.getSubLed().getId():0);
					int drAccountId = faDetails.getAccount().getId();
					int subLedId = faDetails.getSubLed()!=null?faDetails.getSubLed().getId():0;
					int fYearId = faDetails.getVoucherHeader().getFYear().getId();
					int locationId = faDetails.getVoucherHeader().getHospital().getId();
					hbt.update(faVoucherDetail);
					updateTransactionForPayment(subLedId, drAccountId, fYearId, locationId,"0.00", ""+totalAmountCr, centreId);
				}
			  }
			}
			
			voucherHeader= (FaVoucherHeader)hbt.load(FaVoucherHeader.class, voucherHeaderId);
			voucherHeader.setDrAmount(totalAmountCr);
			voucherHeader.setCrAmount(totalAmountCr);
			
			MasApprovalStatus mStatus = new MasApprovalStatus();
			mStatus.setId(box.getInt("ApprovalStatusId"));
			voucherHeader.setApprovalStatus(mStatus);  
			voucherHeader.setAcknowedgeStatus(mStatus);
			
			hbt.update(voucherHeader);
			hbt.refresh(voucherHeader);
			
			
			
			}else{
				MasApprovalStatus mStatus = new MasApprovalStatus();
				mStatus.setId(box.getInt("ApprovalStatusId"));
				voucherHeader.setApprovalStatus(mStatus);
			}
		
			voucherNo =voucherHeader.getVoucherNo();
			approvalStatus = voucherHeader.getApprovalStatus().getDescription();
			tx.commit();
			saved = true;
			
		}catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
	
		map.put("voucherNo", voucherNo);
		map.put("approvalStatus", approvalStatus);
		map.put("saved", saved);
		return map;
	}
	
	/*@Override
	public Map<String, Object> submitPaymentVoucherApproval(Box box) {
		// TODO Auto-generated method stub
		Map<String,Object>map = new HashMap<String, Object>();
		List<FaVoucherDetails> voucherDetails = new ArrayList<FaVoucherDetails>();
		
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Transaction tx =null;
		Session session = (Session)getSession();
		
		Vector tableRow = box.getVector("tableRowId");
		int voucherHeaderId= box.getInt("voucherHeaderId");
		boolean saved = false;	
		String voucherNo="";
		String approvalStatus="";
		BigDecimal totalAmountCr = new BigDecimal(0.0);
		if (!box.getString(TOTAL_AMOUNT).equals("")) {
			totalAmountCr = new BigDecimal(box.getString(TOTAL_AMOUNT));
		}
		
		int approvedId= Integer.parseInt(HMSUtil.getProperties("adt.properties", "approvedId"));
		
		try{
			tx = session.beginTransaction();
				if(box.getInt("ApprovalStatusId")==approvedId){
					FaVoucherDetails faVoucherDetail = new FaVoucherDetails();
					voucherDetails = session.createCriteria(FaVoucherDetails.class).createAlias("VoucherHeader", "header").add(Restrictions.eq("header.Id", voucherHeaderId)).list();
					if(voucherDetails.size()>0){
					for(FaVoucherDetails faDetails : voucherDetails){
						if(faDetails.getCrAmount()!=null){
							faVoucherDetail= (FaVoucherDetails)hbt.load(FaVoucherDetails.class,faDetails.getId());
							faVoucherDetail.setCrAmount(totalAmountCr);
							
							int centreId = getLocationIdForSubLedger(faDetails.getSubLed()!=null?faDetails.getSubLed().getId():0);
							int crAccountId = faDetails.getAccount().getId();
							int subLedId = faDetails.getSubLed()!=null?faDetails.getSubLed().getId():0;
							int fYearId = faDetails.getVoucherHeader().getFYear().getId();
							int locationId = faDetails.getVoucherHeader().getHospital().getId();
							hbt.update(faVoucherDetail);
							updateTransactionForPayment(subLedId, crAccountId, fYearId, locationId, ""+totalAmountCr, "0.00",centreId);
						}else if(faDetails.getDrAmount()!=null){
							String tableRowId = "";
							tableRowId = box.getString("tableRowId");
							String array_RowId [];
							array_RowId = tableRowId.split(",");
							
							if (tableRowId != "") 
							{
								System.out.println("array_RowId.length"+array_RowId.length);
								
								for (int i = 0; i < array_RowId.length; i++)
								{
									System.out.println("array_RowId[i]"+array_RowId[i]);
									faVoucherDetail= (FaVoucherDetails)hbt.load(FaVoucherDetails.class, Integer.parseInt(array_RowId[i]));
									if(faVoucherDetail.getDrAmount()!=null){
										faVoucherDetail.setDrAmount(new BigDecimal(box.getString(AMOUNT+array_RowId[i])));
										hbt.update(faVoucherDetail);
									}
									
								}
							}
						}
					  }
					}
				}
			FaVoucherHeader voucherHeader = new FaVoucherHeader();
			voucherHeader= (FaVoucherHeader)hbt.load(FaVoucherHeader.class,voucherHeaderId);
			if(voucherHeader!=null){
				if(box.getInt("ApprovalStatusId")==approvedId){
					voucherHeader.setDrAmount(totalAmountCr);
					voucherHeader.setCrAmount(totalAmountCr);
					
					MasApprovalStatus mStatus = new MasApprovalStatus();
					mStatus.setId(box.getInt("ApprovalStatusId"));
					voucherHeader.setApprovalStatus(mStatus);
					
				}else{
					MasApprovalStatus mStatus = new MasApprovalStatus();
					mStatus.setId(box.getInt("ApprovalStatusId"));
					voucherHeader.setApprovalStatus(mStatus);
				}
				hbt.update(voucherHeader);
				hbt.refresh(voucherHeader);
			}
			voucherNo = voucherHeader.getVoucherNo();
			approvalStatus = voucherHeader.getApprovalStatus().getDescription();
		
			tx.commit();
			saved = true;
			
		}catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
	
		map.put("voucherNo", voucherNo);
		map.put("approvalStatus", approvalStatus);
		map.put("saved", saved);
		return map;
	}*/

	@Override
	public Map<String, Object> getpendingListForReceiptVoucherAcceptance(Box box) {
		// TODO Auto-generated method stub
		//hsdhfsdu
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaVoucherHeader> headerList = new ArrayList<FaVoucherHeader>();
		List<FaVoucherDetails> detailsList = new ArrayList<FaVoucherDetails>();
		Session session = (Session)getSession();
		Criteria cr=null;
		int pagingSize = 10;
		int pageNo = 1;
		String unitType = "";
		
		
		
		int approvedId = Integer.parseInt(HMSUtil.getProperties("adt.properties", "approvedId"));
		
		cr = session.createCriteria(FaVoucherHeader.class);
		cr = cr.createAlias("ApprovalStatus", "status")
				.add(Restrictions.eq("status.Id",approvedId ))
				.add(Restrictions.isNull("AcknowedgeStatus"));
		
		if(!box.getString("unitType").isEmpty()){
			cr=  cr.add(Restrictions.or(Restrictions.eq("Hospital.Id",box.getInt("locationId")),Restrictions.eq("Centre.Id", box.getInt("locationId"))));
		}else{
			
			cr=  cr.add(Restrictions.eq("Hospital.Id",box.getInt("locationId"))).add(Restrictions.isNull("Centre"));
		}
		
		headerList = cr.list();
		
		List totalMatches = cr.list();
		cr = cr.setFirstResult(pagingSize * (pageNo - 1));
		cr = cr.setMaxResults(pagingSize);

		int totalRecords = totalMatches.size();
		totalMatches.clear();
		
		map.put("totalRecords", totalRecords);
		map.put("headerList", headerList);
		return map;
	}

	@Override
	public Map<String, Object> getDataForReceiptVoucherAcceptance(
			Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		List<FaVoucherDetails> voucherDetailList = new ArrayList<FaVoucherDetails>();
		List<FaVoucherHeader> voucherHeader = new ArrayList<FaVoucherHeader>();
		Map<String,Object> vocherDetailsmap = new HashMap<String,Object>();
		Session session = (Session)getSession();
		int headerId = (Integer) generalMap.get("headerId");
		
		voucherDetailList = session.createCriteria(FaVoucherDetails.class).add(Restrictions.eq("VoucherHeader.Id", headerId))
				.add(Restrictions.isNull("CrAmount")).list();
		
		vocherDetailsmap.put("voucherDetailList",voucherDetailList);
		return vocherDetailsmap;
	}

	@Override
	public Map<String, Object> submitReceiptVoucherAcceptance(Box box) {
		// TODO Auto-generated method stub
		Map<String,Object>map = new HashMap<String, Object>();
		List<FaVoucherDetails> voucherDetails = new ArrayList<FaVoucherDetails>();
		
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Transaction tx =null;
		Session session = (Session)getSession();
		
		int voucherHeaderId= box.getInt("voucherHeaderId");
		
		boolean saved = false;	
		String voucherNo="";
		String approvalStatus="";
	
		
		int approvedId= Integer.parseInt(HMSUtil.getProperties("adt.properties", "approvedId"));
		
		try{
			tx = session.beginTransaction();
				
							String tableRowId = "";
							tableRowId = box.getString("tableRowId");
							String array_RowId [];
							array_RowId = tableRowId.split(",");
							
							if (tableRowId != "") 
							{
								for (int i = 0; i < array_RowId.length; i++)
								{
									System.out.println(array_RowId[i]);
									FaVoucherDetails faVoucherDetails = new FaVoucherDetails();
									faVoucherDetails= (FaVoucherDetails)hbt.load(FaVoucherDetails.class, Integer.parseInt(array_RowId[i]));
									
									int centreIdGrid = getLocationIdForSubLedger(faVoucherDetails.getSubLed()!=null?faVoucherDetails.getSubLed().getId():0);
									int drAccountId = faVoucherDetails.getAccount().getId();
									int subLedId = faVoucherDetails.getSubLed()!=null?faVoucherDetails.getSubLed().getId():0;
									int fYearId = faVoucherDetails.getVoucherHeader().getFYear().getId();
									int locationId = faVoucherDetails.getVoucherHeader().getHospital().getId();
									BigDecimal amountDr = new BigDecimal(0.0);
									amountDr = faVoucherDetails.getDrAmount();
									
									updateTransactionForPayment(subLedId, drAccountId, fYearId,locationId,"0.00", ""+amountDr,centreIdGrid);
									}
								}
							
			FaVoucherHeader voucherHeader = new FaVoucherHeader();
			voucherHeader= (FaVoucherHeader)hbt.load(FaVoucherHeader.class,voucherHeaderId);
			if(voucherHeader!=null){
					MasApprovalStatus acStatus = new MasApprovalStatus();
					acStatus.setId(approvedId);
					voucherHeader.setAcknowedgeStatus(acStatus);
					
				hbt.update(voucherHeader);
				hbt.refresh(voucherHeader);
			}
			voucherNo = voucherHeader.getVoucherNo();
			approvalStatus = voucherHeader.getAcknowedgeStatus().getDescription();
		
			tx.commit();
			saved = true;
			
		}catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
	
		map.put("voucherNo", voucherNo);
		map.put("approvalStatus", approvalStatus);
		map.put("saved", saved);
		return map;
	}

	@Override
	public Map<String, Object> submitJournalVoucherApproval(Box box) {
		// TODO Auto-generated method stub
		Map<String,Object>map = new HashMap<String, Object>();
		List<FaVoucherDetails> voucherDetails = new ArrayList<FaVoucherDetails>();
		
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Transaction tx =null;
		Session session = (Session)getSession();
		
		int voucherHeaderId= box.getInt("voucherHeaderId");
		boolean saved = false;	
		String voucherNo="";
		String approvalStatus="";
		BigDecimal totalAmountCr = new BigDecimal(0.0);
		BigDecimal totalAmountDr = new BigDecimal(0.0);
		if (!box.getString(TOTAL_CR_AMOUNT).equals("")) {
			totalAmountCr = new BigDecimal(box.getString(TOTAL_CR_AMOUNT));
		}
		if (!box.getString(TOTAL_DR_AMOUNT).equals("")) {
			totalAmountDr = new BigDecimal(box.getString(TOTAL_DR_AMOUNT));
		}
		
		int approvedId= Integer.parseInt(HMSUtil.getProperties("adt.properties", "approvedId"));
		
		try{
			tx = session.beginTransaction();
				if(box.getInt("ApprovalStatusId")==approvedId){
					
				
					String tableRowId = "";
					tableRowId = box.getString("tableRowId");
					String array_RowId [];
					array_RowId = tableRowId.split(",");
					
					if (tableRowId != "") 
					{
						for (int i = 0; i < array_RowId.length; i++)
						{
							
							FaVoucherDetails faVoucherDetails = new FaVoucherDetails();
							faVoucherDetails= (FaVoucherDetails)hbt.load(FaVoucherDetails.class, Integer.parseInt(array_RowId[i]));
							if(faVoucherDetails.getCrAmount()!=null){
								BigDecimal crAmount = new BigDecimal(box.getString(CR_AMOUNT+array_RowId[i]));
								faVoucherDetails.setCrAmount(crAmount);
								
								int centreId = getLocationIdForSubLedger(faVoucherDetails.getSubLed()!=null?faVoucherDetails.getSubLed().getId():0);
								int crAccountId = faVoucherDetails.getAccount().getId();
								int subLedId = faVoucherDetails.getSubLed()!=null?faVoucherDetails.getSubLed().getId():0;
								int fYearId = faVoucherDetails.getVoucherHeader().getFYear().getId();
								int locationId = faVoucherDetails.getVoucherHeader().getHospital().getId();
								hbt.update(faVoucherDetails);
								
								updateTransactionForPayment(subLedId, crAccountId, fYearId, locationId, ""+crAmount, "0.00",centreId);
							}else if(faVoucherDetails.getDrAmount()!=null){
								BigDecimal drAmount = new BigDecimal(box.getString(DR_AMOUNT+array_RowId[i]));
								faVoucherDetails.setDrAmount(drAmount);
								//update dr amount here 
								int centreId = getLocationIdForSubLedger(faVoucherDetails.getSubLed()!=null?faVoucherDetails.getSubLed().getId():0);
								int drAccountId = faVoucherDetails.getAccount().getId();
								int subLedId = faVoucherDetails.getSubLed()!=null?faVoucherDetails.getSubLed().getId():0;
								int fYearId = faVoucherDetails.getVoucherHeader().getFYear().getId();
								int locationId = faVoucherDetails.getVoucherHeader().getHospital().getId();
								hbt.update(faVoucherDetails);
								updateTransactionForPayment(subLedId, drAccountId, fYearId, locationId,"0.00", ""+drAmount, centreId);
								
								
							}
							
						}
					}
					
					
				}
			FaVoucherHeader voucherHeader = new FaVoucherHeader();
			voucherHeader= (FaVoucherHeader)hbt.load(FaVoucherHeader.class,voucherHeaderId);
			if(voucherHeader!=null){
				if(box.getInt("ApprovalStatusId")==approvedId){
					voucherHeader.setDrAmount(totalAmountDr);
					voucherHeader.setCrAmount(totalAmountCr);
					
					MasApprovalStatus mStatus = new MasApprovalStatus();
					mStatus.setId(box.getInt("ApprovalStatusId"));
					voucherHeader.setApprovalStatus(mStatus);
					voucherHeader.setAcknowedgeStatus(mStatus);
					
				}else{
					MasApprovalStatus mStatus = new MasApprovalStatus();
					mStatus.setId(box.getInt("ApprovalStatusId"));
					voucherHeader.setApprovalStatus(mStatus);
				}
				hbt.update(voucherHeader);
				hbt.refresh(voucherHeader);
			}
			voucherNo = voucherHeader.getVoucherNo();
			approvalStatus = voucherHeader.getApprovalStatus().getDescription();
		
			tx.commit();
			saved = true;
			
		}catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
	
		map.put("voucherNo", voucherNo);
		map.put("approvalStatus", approvalStatus);
		map.put("saved", saved);
		return map;
	}

	@Override
	public List<MasStoreSupplier> getsupplierList(String unitType,int locationId) {
		List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
		Session session = (Session)getSession();
	/*	int agencyTypeIdForDealer = 0;
		int agencyTypeIdForVendor = 0;
		
		agencyTypeIdForDealer = Integer.parseInt(HMSUtil.getProperties("adt.properties","agencyTypeIdForDealer" ));
		agencyTypeIdForVendor = Integer.parseInt(HMSUtil.getProperties("adt.properties","agencyTypeIdForVendor" ));*/
		
		/*if(unitType.equalsIgnoreCase("HO"))
		{
			supplierList = session.createCriteria(MasStoreSupplier.class)
					.createAlias("AgencyType", "agencyType").add(Restrictions.or(Restrictions.eq("agencyType.Id", agencyTypeIdForDealer), Restrictions.eq("agencyType.Id", agencyTypeIdForVendor)))					
					.add(Restrictions.eq("Status", "y")).list();
		}
		if(!unitType.equalsIgnoreCase("HO")) // login with centre
		{
			supplierList = session.createCriteria(MasStoreSupplier.class)
					.createAlias("AgencyType", "agencyType").add(Restrictions.or(Restrictions.eq("agencyType.Id", agencyTypeIdForDealer), Restrictions.eq("agencyType.Id", agencyTypeIdForVendor)))	
					.createAlias("Hospital", "location").add(Restrictions.eq("location.Id", locationId))
					.add(Restrictions.eq("Status", "y")).list();
		}*/
		
		supplierList = session.createCriteria(MasStoreSupplier.class)
				/*.createAlias("AgencyType", "agencyType").add(Restrictions.or(Restrictions.eq("agencyType.Id", agencyTypeIdForDealer), Restrictions.eq("agencyType.Id", agencyTypeIdForVendor)))*/	
				.createAlias("Hospital", "location").add(Restrictions.eq("location.Id", locationId))
				.add(Restrictions.eq("Status", "y")).list();
		
		return supplierList;
	}

	@Override
	public Map<String, Object> submitSalesVoucherApproval(Box box) {
		// TODO Auto-generated method stub
		Map<String,Object>map = new HashMap<String, Object>();
		List<FaVoucherDetails> voucherDetails = new ArrayList<FaVoucherDetails>();
		
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Transaction tx =null;
		Session session = (Session)getSession();
		
		int voucherHeaderId= box.getInt("voucherHeaderId");
		boolean saved = false;	
		String voucherNo="";
		String approvalStatus="";
		BigDecimal totalAmountCr = new BigDecimal(0.0);
		BigDecimal totalAmountDr = new BigDecimal(0.0);
		if (!box.getString(TOTAL_CR_AMOUNT).equals("")) {
			totalAmountCr = new BigDecimal(box.getString(TOTAL_CR_AMOUNT));
		}
		if (!box.getString(TOTAL_DR_AMOUNT).equals("")) {
			totalAmountDr = new BigDecimal(box.getString(TOTAL_DR_AMOUNT));
		}
		
		int approvedId= Integer.parseInt(HMSUtil.getProperties("adt.properties", "approvedId"));
		
		try{
			tx = session.beginTransaction();
				if(box.getInt("ApprovalStatusId")==approvedId){
					
				
					String tableRowId = "";
					tableRowId = box.getString("tableRowId");
					String array_RowId [];
					array_RowId = tableRowId.split(",");
					
					if (tableRowId != "") 
					{
						for (int i = 0; i < array_RowId.length; i++)
						{
							System.out.println("array_RowId[i]>"+array_RowId[i]);
							FaVoucherDetails faVoucherDetails = new FaVoucherDetails();
							faVoucherDetails= (FaVoucherDetails)hbt.load(FaVoucherDetails.class, Integer.parseInt(array_RowId[i]));
							if(faVoucherDetails.getCrAmount()!=null){
								BigDecimal crAmount = new BigDecimal(box.getString(CR_AMOUNT+array_RowId[i]));
								faVoucherDetails.setCrAmount(crAmount);
								
								int centreId = getLocationIdForSubLedger(faVoucherDetails.getSubLed()!=null?faVoucherDetails.getSubLed().getId():0);
								int crAccountId = faVoucherDetails.getAccount().getId();
								int subLedId = faVoucherDetails.getSubLed()!=null?faVoucherDetails.getSubLed().getId():0;
								int fYearId = faVoucherDetails.getVoucherHeader().getFYear().getId();
								int locationId = faVoucherDetails.getVoucherHeader().getHospital().getId();
								hbt.update(faVoucherDetails);
								
								updateTransactionForPayment(subLedId, crAccountId, fYearId, locationId, ""+crAmount, "0.00",centreId);
							}else if(faVoucherDetails.getDrAmount()!=null){
								faVoucherDetails.setDrAmount(new BigDecimal(box.getString(DR_AMOUNT+array_RowId[i])));
								hbt.update(faVoucherDetails);
							}
							
						}
					}
					
					
				}
			FaVoucherHeader voucherHeader = new FaVoucherHeader();
			voucherHeader= (FaVoucherHeader)hbt.load(FaVoucherHeader.class,voucherHeaderId);
			if(voucherHeader!=null){
				if(box.getInt("ApprovalStatusId")==approvedId){
					voucherHeader.setDrAmount(totalAmountDr);
					voucherHeader.setCrAmount(totalAmountCr);
					
					MasApprovalStatus mStatus = new MasApprovalStatus();
					mStatus.setId(box.getInt("ApprovalStatusId"));
					voucherHeader.setApprovalStatus(mStatus);
					
				}else{
					MasApprovalStatus mStatus = new MasApprovalStatus();
					mStatus.setId(box.getInt("ApprovalStatusId"));
					voucherHeader.setApprovalStatus(mStatus);
				}
				hbt.update(voucherHeader);
				hbt.refresh(voucherHeader);
			}
			voucherNo = voucherHeader.getVoucherNo();
			approvalStatus = voucherHeader.getApprovalStatus().getDescription();
		
			tx.commit();
			saved = true;
			
		}catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
	
		map.put("voucherNo", voucherNo);
		map.put("approvalStatus", approvalStatus);
		map.put("saved", saved);
		return map;
	}

	@Override
	public Map<String, Object> submitPurchaseReturnVoucherApproval(Box box) {
		// TODO Auto-generated method stub
		Map<String,Object>map = new HashMap<String, Object>();
		List<FaVoucherDetails> voucherDetails = new ArrayList<FaVoucherDetails>();
		
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Transaction tx =null;
		Session session = (Session)getSession();
		
		int voucherHeaderId= box.getInt("voucherHeaderId");
		boolean saved = false;	
		String voucherNo="";
		String approvalStatus="";
		BigDecimal totalAmountCr = new BigDecimal(0.0);
		BigDecimal totalAmountDr = new BigDecimal(0.0);
		if (!box.getString(TOTAL_CR_AMOUNT).equals("")) {
			totalAmountCr = new BigDecimal(box.getString(TOTAL_CR_AMOUNT));
		}
		if (!box.getString(TOTAL_DR_AMOUNT).equals("")) {
			totalAmountDr = new BigDecimal(box.getString(TOTAL_DR_AMOUNT));
		}
		
		int approvedId= Integer.parseInt(HMSUtil.getProperties("adt.properties", "approvedId"));
		
		try{
			tx = session.beginTransaction();
				if(box.getInt("ApprovalStatusId")==approvedId){
					
				
					String tableRowId = "";
					tableRowId = box.getString("tableRowId");
					String array_RowId [];
					array_RowId = tableRowId.split(",");
					
					if (tableRowId != "") 
					{
						for (int i = 0; i < array_RowId.length; i++)
						{
							System.out.println("array_RowId[i]>"+array_RowId[i]);
							FaVoucherDetails faVoucherDetails = new FaVoucherDetails();
							faVoucherDetails= (FaVoucherDetails)hbt.load(FaVoucherDetails.class, Integer.parseInt(array_RowId[i]));
							if(faVoucherDetails.getCrAmount()!=null){
								BigDecimal crAmount = new BigDecimal(box.getString(CR_AMOUNT+array_RowId[i]));
								faVoucherDetails.setCrAmount(crAmount);
								
								int centreId = getLocationIdForSubLedger(faVoucherDetails.getSubLed()!=null?faVoucherDetails.getSubLed().getId():0);
								int crAccountId = faVoucherDetails.getAccount().getId();
								int subLedId = faVoucherDetails.getSubLed()!=null?faVoucherDetails.getSubLed().getId():0;
								int fYearId = faVoucherDetails.getVoucherHeader().getFYear().getId();
								int locationId = faVoucherDetails.getVoucherHeader().getHospital().getId();
								hbt.update(faVoucherDetails);
								
								updateTransactionForPayment(subLedId, crAccountId, fYearId, locationId, ""+crAmount, "0.00",centreId);
							}else if(faVoucherDetails.getDrAmount()!=null){
								faVoucherDetails.setDrAmount(new BigDecimal(box.getString(DR_AMOUNT+array_RowId[i])));
								hbt.update(faVoucherDetails);
							}
							
						}
					}
					
					
				}
			FaVoucherHeader voucherHeader = new FaVoucherHeader();
			voucherHeader= (FaVoucherHeader)hbt.load(FaVoucherHeader.class,voucherHeaderId);
			if(voucherHeader!=null){
				if(box.getInt("ApprovalStatusId")==approvedId){
					voucherHeader.setDrAmount(totalAmountDr);
					voucherHeader.setCrAmount(totalAmountCr);
					
					MasApprovalStatus mStatus = new MasApprovalStatus();
					mStatus.setId(box.getInt("ApprovalStatusId"));
					voucherHeader.setApprovalStatus(mStatus);
					
				}else{
					MasApprovalStatus mStatus = new MasApprovalStatus();
					mStatus.setId(box.getInt("ApprovalStatusId"));
					voucherHeader.setApprovalStatus(mStatus);
				}
				hbt.update(voucherHeader);
				hbt.refresh(voucherHeader);
			}
			voucherNo = voucherHeader.getVoucherNo();
			approvalStatus = voucherHeader.getApprovalStatus().getDescription();
		
			tx.commit();
			saved = true;
			
		}catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
	
		map.put("voucherNo", voucherNo);
		map.put("approvalStatus", approvalStatus);
		map.put("saved", saved);
		return map;
	}

	@Override
	public Map<String, Object> submitReceiptVoucherApproval(Box box) {
		// TODO Auto-generated method stub
		Map<String,Object>map = new HashMap<String, Object>();
		List<FaVoucherDetails> voucherDetails = new ArrayList<FaVoucherDetails>();
		
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Transaction tx =null;
		Session session = (Session)getSession();
		
		Vector tableRow = box.getVector("tableRowId");
		int voucherHeaderId= box.getInt("voucherHeaderId");
		boolean saved = false;	
		String voucherNo="";
		String approvalStatus="";
		BigDecimal totalAmountCr = new BigDecimal(0.0);
		if (!box.getString(TOTAL_AMOUNT).equals("")) {
			totalAmountCr = new BigDecimal(box.getString(TOTAL_AMOUNT));
		}
		
		int approvedId= Integer.parseInt(HMSUtil.getProperties("adt.properties", "approvedId"));
		
		try{
			tx = session.beginTransaction();
				if(box.getInt("ApprovalStatusId")==approvedId){
					FaVoucherDetails faVoucherDetail = new FaVoucherDetails();
					voucherDetails = session.createCriteria(FaVoucherDetails.class).createAlias("VoucherHeader", "header").add(Restrictions.eq("header.Id", voucherHeaderId)).list();
					if(voucherDetails.size()>0){
					for(FaVoucherDetails faDetails : voucherDetails){
						if(faDetails.getCrAmount()!=null){
							faVoucherDetail= (FaVoucherDetails)hbt.load(FaVoucherDetails.class,faDetails.getId());
							faVoucherDetail.setCrAmount(totalAmountCr);
							
							int centreId = getLocationIdForSubLedger(faDetails.getSubLed()!=null?faDetails.getSubLed().getId():0);
							int crAccountId = faDetails.getAccount().getId();
							int subLedId = faDetails.getSubLed()!=null?faDetails.getSubLed().getId():0;
							int fYearId = faDetails.getVoucherHeader().getFYear().getId();
							int locationId = faDetails.getVoucherHeader().getHospital().getId();
							hbt.update(faVoucherDetail);
							updateTransactionForPayment(subLedId, crAccountId, fYearId, locationId, ""+totalAmountCr, "0.00",centreId);
						}else if(faDetails.getDrAmount()!=null){
							String tableRowId = "";
							tableRowId = box.getString("tableRowId");
							String array_RowId [];
							array_RowId = tableRowId.split(",");
							
							if (tableRowId != "") 
							{
								for (int i = 0; i < array_RowId.length; i++)
								{
									faVoucherDetail= (FaVoucherDetails)hbt.load(FaVoucherDetails.class, Integer.parseInt(array_RowId[i]));
									
									if(faVoucherDetail.getDrAmount()!=null){
										faVoucherDetail.setDrAmount(new BigDecimal(box.getString(AMOUNT+array_RowId[i])));
										
										int centreIdGrid = getLocationIdForSubLedger(faVoucherDetail.getSubLed()!=null?faVoucherDetail.getSubLed().getId():0);
										int drAccountId = faVoucherDetail.getAccount().getId();
										int subLedId = faVoucherDetail.getSubLed()!=null?faVoucherDetail.getSubLed().getId():0;
										int fYearId = faVoucherDetail.getVoucherHeader().getFYear().getId();
										int locationId = faVoucherDetail.getVoucherHeader().getHospital().getId();
										
										
										hbt.update(faVoucherDetail);
										
										updateTransactionForPayment(subLedId, drAccountId, fYearId,locationId,"0.00", ""+box.getString(AMOUNT+array_RowId[i]),centreIdGrid);
									}
									
								}
							}
							
						}
					  }
					}
					
					
					
				}
			FaVoucherHeader voucherHeader = new FaVoucherHeader();
			voucherHeader= (FaVoucherHeader)hbt.load(FaVoucherHeader.class,voucherHeaderId);
			if(voucherHeader!=null){
				if(box.getInt("ApprovalStatusId")==approvedId){
					voucherHeader.setDrAmount(totalAmountCr);
					voucherHeader.setCrAmount(totalAmountCr);
					
					MasApprovalStatus mStatus = new MasApprovalStatus();
					mStatus.setId(box.getInt("ApprovalStatusId"));
					voucherHeader.setApprovalStatus(mStatus);
					voucherHeader.setAcknowedgeStatus(mStatus);
					
				}else{
					MasApprovalStatus mStatus = new MasApprovalStatus();
					mStatus.setId(box.getInt("ApprovalStatusId"));
					voucherHeader.setApprovalStatus(mStatus);
				}
				hbt.update(voucherHeader);
				hbt.refresh(voucherHeader);
			}
			voucherNo = voucherHeader.getVoucherNo();
			approvalStatus = voucherHeader.getApprovalStatus().getDescription();
		
			tx.commit();
			saved = true;
			
		}catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
	
		map.put("voucherNo", voucherNo);
		map.put("approvalStatus", approvalStatus);
		map.put("saved", saved);
		return map;
	}
	
}
	
