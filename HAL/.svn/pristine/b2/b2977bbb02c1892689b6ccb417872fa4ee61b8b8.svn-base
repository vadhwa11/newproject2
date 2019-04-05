package jkt.hms.masters.handler;

import java.util.Map;

import jkt.hms.masters.business.MasAccountType;
import jkt.hms.masters.business.MasBankMaster;
import jkt.hms.masters.business.MasBillType;
import jkt.hms.masters.business.MasChargeType;
import jkt.hms.masters.dataservice.BillingMasterDataService;

public class BillingMasterHandlerServiceImpl implements
		BillingMasterHandlerService {
	BillingMasterDataService billingMasterDataService = null;

	// ------------------------------------------AccountType
	// -----------------------------------

	public boolean addAccountType(MasAccountType masAccountType) {
		return billingMasterDataService.addAccountType(masAccountType);
	}

	public boolean editAccountTypeToDatabase(Map<String, Object> generalMap) {
		return billingMasterDataService.editAccountTypeToDatabase(generalMap);
	}

	public Map<String, Object> searchAccountType(String accountTypeCode,
			String accountTypeName) {
		return billingMasterDataService.searchAccountType(accountTypeCode,
				accountTypeName);
	}

	public Map<String, Object> showAccountTypeJsp() {
		return billingMasterDataService.showAccountTypeJsp();
	}

	public boolean deleteAccountType(int accountTypeId,
			Map<String, Object> generalMap) {
		return billingMasterDataService.deleteAccountType(accountTypeId,
				generalMap);
	}

	// -------------------------------------------- Charge
	// Type-----------------------------------

	public boolean addChargeType(MasChargeType masChargeType) {
		return billingMasterDataService.addChargeType(masChargeType);
	}

	public boolean editChargeTypeToDatabase(Map<String, Object> generalMap) {
		return billingMasterDataService.editChargeTypeToDatabase(generalMap);
	}

	public Map<String, Object> searchChargeType(String chargeTypeCode,
			String chargeTypeName) {
		return billingMasterDataService.searchChargeType(chargeTypeCode,
				chargeTypeName);
	}

	public Map<String, Object> showChargeTypeJsp() {
		return billingMasterDataService.showChargeTypeJsp();
	}

	public boolean deleteChargeType(int chargeTypeId,
			Map<String, Object> generalMap) {
		return billingMasterDataService.deleteChargeType(chargeTypeId,
				generalMap);
	}

	// --------------------------------------------Bill
	// Type------------------------------------------------------

	public Map<String, Object> showBillTypeJsp() {
		return billingMasterDataService.showBillTypeJsp();
	}

	public Map<String, Object> searchBillType(String billTypeCode,
			String billTypeName) {
		return billingMasterDataService.searchBillType(billTypeCode,
				billTypeName);
	}

	public boolean addBillType(MasBillType masBillType) {
		return billingMasterDataService.addBillType(masBillType);
	}

	public boolean deleteBillType(int billTypeId, Map<String, Object> generalMap) {
		return billingMasterDataService.deleteBillType(billTypeId, generalMap);
	}

	public boolean editBillTypeToDatabase(Map<String, Object> generalMap) {
		return billingMasterDataService.editBillTypeToDatabase(generalMap);
	}

	// -------------------------- Bank Master----------------------------------

	public Map<String, Object> searchBank(String bankCode, String bankName) {
		return billingMasterDataService.searchBank(bankCode, bankName);
	}

	public Map<String, Object> showBankJsp() {
		return billingMasterDataService.showBankJsp();
	}

	public boolean addBank(MasBankMaster masBank) {
		return billingMasterDataService.addBank(masBank);
	}

	public boolean editBankToDatabase(Map<String, Object> generalMap) {
		return billingMasterDataService.editBankToDatabase(generalMap);
	}

	public boolean deleteBank(int bankId, Map<String, Object> generalMap) {
		return billingMasterDataService.deleteBank(bankId, generalMap);
	}

	// ---------------------------------------------------------------------
	public BillingMasterDataService getBillingMasterDataService() {
		return billingMasterDataService;
	}

	public void setBillingMasterDataService(
			BillingMasterDataService billingMasterDataService) {
		this.billingMasterDataService = billingMasterDataService;
	}

}
