package jkt.hms.masters.handler;

import java.util.Map;

import jkt.hms.masters.business.MasAccountType;
import jkt.hms.masters.business.MasBankMaster;
import jkt.hms.masters.business.MasBillType;
import jkt.hms.masters.business.MasChargeType;

public interface BillingMasterHandlerService {
	// ----------------------------------------------Bill
	// Type---------------------------------------------

	Map<String, Object> showBillTypeJsp();

	Map<String, Object> searchBillType(String billTypeCode, String billTypeName);

	boolean addBillType(MasBillType masBillType);

	boolean editBillTypeToDatabase(Map<String, Object> generalMap);

	boolean deleteBillType(int billTypeId, Map<String, Object> generalMap);

	// -------------------------------------------- Account Type
	// ---------------------------------

	Map<String, Object> searchAccountType(String accountTypeCode,
			String accountTypeName);

	Map<String, Object> showAccountTypeJsp();

	boolean addAccountType(MasAccountType masAccountType);

	boolean editAccountTypeToDatabase(Map<String, Object> generalMap);

	boolean deleteAccountType(int accountTypeId, Map<String, Object> generalMap);

	// ---------------------------------------------Charge
	// Type------------------------------------

	Map<String, Object> searchChargeType(String chargeTypeCode,
			String chargeTypeName);

	Map<String, Object> showChargeTypeJsp();

	boolean addChargeType(MasChargeType masChargeType);

	boolean editChargeTypeToDatabase(Map<String, Object> generalMap);

	boolean deleteChargeType(int chargeTypeId, Map<String, Object> generalMap);

	// ------------------------------------ Bank master
	// ------------------------------------

	Map<String, Object> searchBank(String bankCode, String bankName);

	Map<String, Object> showBankJsp();

	boolean addBank(MasBankMaster masBank);

	boolean editBankToDatabase(Map<String, Object> generalMap);

	boolean deleteBank(int bankId, Map<String, Object> generalMap);

}
