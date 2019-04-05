package jkt.hms.masters.dataservice;

import java.util.Map;

import jkt.hms.masters.business.MasAccountType;
import jkt.hms.masters.business.MasBankMaster;
import jkt.hms.masters.business.MasBillType;
import jkt.hms.masters.business.MasChargeType;

public interface BillingMasterDataService {

	// ----------------------------------------Bill
	// Type------------------------------------------------

	Map<String, Object> showBillTypeJsp();

	Map<String, Object> searchBillType(String billTypeCode, String billTypeName);

	boolean addBillType(MasBillType masBillType);

	boolean deleteBillType(int billTypeId, Map<String, Object> generalMap);

	boolean editBillTypeToDatabase(Map<String, Object> generalMap);

	// ---------------------------------------Account
	// Type------------------------

	boolean addAccountType(MasAccountType masAccountType);

	boolean editAccountTypeToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchAccountType(String accountTypeCode,
			String accountTypeName);

	Map<String, Object> showAccountTypeJsp();

	boolean deleteAccountType(int accountTypeId, Map<String, Object> generalMap);

	// ----------------------------------------Charge
	// Type------------------------------------

	boolean addChargeType(MasChargeType masChargeType);

	boolean editChargeTypeToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchChargeType(String chargeTypeCode,
			String chargeTypeName);

	Map<String, Object> showChargeTypeJsp();

	boolean deleteChargeType(int chargeTypeId, Map<String, Object> generalMap);

	// ------------------------- Bank Master -----------------

	Map<String, Object> searchBank(String bankCode, String bankName);

	Map<String, Object> showBankJsp();

	boolean addBank(MasBankMaster masBank);

	boolean editBankToDatabase(Map<String, Object> generalMap);

	boolean deleteBank(int bankId, Map<String, Object> generalMap);

}
