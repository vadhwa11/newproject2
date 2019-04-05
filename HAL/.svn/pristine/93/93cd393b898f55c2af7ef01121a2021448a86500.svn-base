package jkt.hms.masters.dataservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasAccountType;
import jkt.hms.masters.business.MasBankMaster;
import jkt.hms.masters.business.MasBillType;
import jkt.hms.masters.business.MasChargeType;
import jkt.hms.util.HMSUtil;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BillingMasterDataServiceImpl extends HibernateDaoSupport implements
		BillingMasterDataService {

	Map<String, Object> map = new HashMap<String, Object>();

	// ----------------------------------Bill
	// Type----------------------------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> showBillTypeJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasBillType> searchBillTypeList = new ArrayList<MasBillType>();
		searchBillTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasBillType ");
		map.put("searchBillTypeList", searchBillTypeList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchBillType(String billTypeCode,
			String billTypeName) {
		List<MasBillType> searchBillTypeList = new ArrayList<MasBillType>();
		Map billTypeFieldsMap = new HashMap();
		try {
			if ((billTypeName != null) || (billTypeCode == null)) {
				searchBillTypeList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasBillType mbt where mbt.BillTypeName like '"
										+ billTypeName
										+ "%' order by mbt.BillTypeName");
			} else {
				searchBillTypeList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasBillType mbt where mbt.BillTypeCode like '"
										+ billTypeCode
										+ "%' order by mbt.BillTypeCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		billTypeFieldsMap.put("searchBillTypeList", searchBillTypeList);
		return billTypeFieldsMap;
	}

	public boolean addBillType(MasBillType masBillType) {
		boolean dataSaved = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masBillType);
		dataSaved = true;
		return dataSaved;
	}

	public boolean deleteBillType(int billTypeId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasBillType masBillType = new MasBillType();
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		masBillType = (MasBillType) getHibernateTemplate().load(
				MasBillType.class, billTypeId);
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masBillType.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masBillType.setStatus("y");
				dataDeleted = false;
			}
		}
		masBillType.setLastChgBy(changedBy);
		masBillType.setLastChgDate(currentDate);
		masBillType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masBillType);
		return dataDeleted;
	}

	public boolean editBillTypeToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		String changedBy = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String billTypeName = "";
		@SuppressWarnings("unused")
		String billTypeCode = "";
		int billTypeId = 0;

		billTypeId = (Integer) generalMap.get("id");
		billTypeCode = (String) generalMap.get("billTypeCode");
		billTypeName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasBillType masBillType = (MasBillType) getHibernateTemplate().load(
				MasBillType.class, billTypeId);

		masBillType.setId(billTypeId);
		masBillType.setBillTypeName(billTypeName);
		masBillType.setLastChgBy(changedBy);
		masBillType.setLastChgDate(currentDate);
		masBillType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masBillType);
		dataUpdated = true;
		return dataUpdated;
	}

	// ---------------------------------------Account Type
	// ----------------------

	public boolean addAccountType(MasAccountType masAccountType) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masAccountType);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editAccountTypeToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String accountTypeName = "";
		@SuppressWarnings("unused")
		String accountTypeCode = "";
		int accountTypeId = 0;
		String changedBy = "";
		accountTypeId = (Integer) generalMap.get("id");
		accountTypeCode = (String) generalMap.get("accountTypeCode");
		accountTypeName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasAccountType masAccountType = (MasAccountType) getHibernateTemplate()
				.load(MasAccountType.class, accountTypeId);

		masAccountType.setId(accountTypeId);
		masAccountType.setAccountTypeName(accountTypeName);
		masAccountType.setLastChgBy(changedBy);
		masAccountType.setLastChgDate(currentDate);
		masAccountType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masAccountType);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchAccountType(String accountTypeCode,
			String accountTypeName) {
		List<MasAccountType> searchAccountTypeList = new ArrayList<MasAccountType>();
		Map<String, Object> accountTypeFieldsMap = new HashMap<String, Object>();
		try {
			if ((accountTypeName != null) || (accountTypeCode == null)) {
				searchAccountTypeList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasAccountType imc where imc.AccountTypeName like '"
										+ accountTypeName
										+ "%' order by imc.AccountTypeName");
			} else {
				searchAccountTypeList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasAccountType imc where imc.AccountTypeCode like '"
										+ accountTypeCode
										+ "%' order by imc.AccountTypeCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		accountTypeFieldsMap
				.put("searchAccountTypeList", searchAccountTypeList);
		return accountTypeFieldsMap;
	}

	public Map<String, Object> showAccountTypeJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasAccountType> searchAccountTypeList = new ArrayList<MasAccountType>();
		searchAccountTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasAccountType ");
		map.put("searchAccountTypeList", searchAccountTypeList);
		return map;
	}

	public boolean deleteAccountType(int accountTypeId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasAccountType masAccountType = new MasAccountType();
		masAccountType = (MasAccountType) getHibernateTemplate().load(
				MasAccountType.class, accountTypeId);
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masAccountType.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masAccountType.setStatus("y");
				dataDeleted = false;
			}
		}
		masAccountType.setLastChgBy(changedBy);
		masAccountType.setLastChgDate(currentDate);
		masAccountType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masAccountType);
		return dataDeleted;
	}

	// ----------------------------------------------Charge
	// Type-----------------------------------

	public boolean addChargeType(MasChargeType masChargeType) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masChargeType);
		// getHibernateTemplate().save(masChargeType);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editChargeTypeToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String chargeTypeName = "";
		@SuppressWarnings("unused")
		String chargeTypeCode = "";
		int chargeTypeId = 0;
		String changedBy = "";

		chargeTypeId = (Integer) generalMap.get("id");
		chargeTypeCode = (String) generalMap.get("chargeTypeCode");
		chargeTypeName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasChargeType masChargeType = (MasChargeType) getHibernateTemplate()
				.load(MasChargeType.class, chargeTypeId);

		masChargeType.setId(chargeTypeId);
		masChargeType.setChargeTypeName(chargeTypeName);
		masChargeType.setLastChgBy(changedBy);
		masChargeType.setLastChgDate(currentDate);
		masChargeType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masChargeType);
		// getHibernateTemplate().update(masChargeType);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchChargeType(String chargeTypeCode,
			String chargeTypeName) {
		List<MasChargeType> searchChargeTypeList = new ArrayList<MasChargeType>();
		Map<String, Object> chargeTypeFieldsMap = new HashMap<String, Object>();
		try {
			if ((chargeTypeName != null) || (chargeTypeCode == null)) {
				searchChargeTypeList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasChargeType imc where imc.ChargeTypeName like '"
										+ chargeTypeName
										+ "%' order by imc.ChargeTypeName");
			} else {
				searchChargeTypeList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasChargeType imc where imc.ChargeTypeCode like '"
										+ chargeTypeCode
										+ "%' order by imc.ChargeTypeCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		chargeTypeFieldsMap.put("searchChargeTypeList", searchChargeTypeList);
		return chargeTypeFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showChargeTypeJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasChargeType> searchChargeTypeList = new ArrayList<MasChargeType>();
		searchChargeTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasChargeType ");
		map.put("searchChargeTypeList", searchChargeTypeList);
		return map;
	}

	public boolean deleteChargeType(int chargeTypeId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasChargeType masChargeType = new MasChargeType();
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		masChargeType = (MasChargeType) getHibernateTemplate().load(
				MasChargeType.class, chargeTypeId);
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masChargeType.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masChargeType.setStatus("y");
				dataDeleted = false;
			}
		}
		masChargeType.setLastChgBy(changedBy);
		masChargeType.setLastChgDate(currentDate);
		masChargeType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masChargeType);
		return dataDeleted;
	}

	// -------------------------------------Bank Master-------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchBank(String bankCode, String bankName) {
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

	@SuppressWarnings("unchecked")
	public Map<String, Object> showBankJsp() {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasBankMaster> searchBankList = new ArrayList<MasBankMaster>();
		searchBankList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasBankMaster ");
		map.put("searchBankList", searchBankList);
		return map;
	}

	public boolean addBank(MasBankMaster masBank) {
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
		@SuppressWarnings("unused")
		String bankCode = "";
		int bankId = 0;
		String changedBy = "";

		bankId = (Integer) generalMap.get("id");
		bankCode = (String) generalMap.get("bankCode");
		bankName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasBankMaster masBank = (MasBankMaster) getHibernateTemplate().load(
				MasBankMaster.class, bankId);

		masBank.setId(bankId);
		masBank.setBankName(bankName);
		masBank.setLastChgBy(changedBy);
		masBank.setLastChgDate(currentDate);
		masBank.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masBank);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean deleteBank(int bankId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasBankMaster masBank = new MasBankMaster();
		changedBy = (String) generalMap.get("changedBy");
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
		masBank.setLastChgBy(changedBy);
		masBank.setLastChgDate(currentDate);
		masBank.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masBank);
		return dataDeleted;
	}

}
