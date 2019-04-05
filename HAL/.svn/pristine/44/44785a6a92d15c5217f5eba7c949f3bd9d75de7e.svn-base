package jkt.hms.masters.handler;

import java.util.Map;

import jkt.hms.masters.business.MasBloodBankStatus;
import jkt.hms.masters.business.MasBloodDonationType;
import jkt.hms.masters.business.MasBloodGroup;
import jkt.hms.masters.dataservice.BloodBankMasterDataService;

public class BloodBankMasterHandlerServiceImpl implements
		BloodBankMasterHandlerService {

	BloodBankMasterDataService bloodBankMasterDataService;

	// ----------------------------------------Blood Bank
	// Status---------------------------------

	public Map<String, Object> showBloodBankStatusJsp() {
		return bloodBankMasterDataService.showBloodBankStatusJsp();
	}

	public Map<String, Object> searchBloodBankStatus(
			String bloodBankStatusCode, String bloodBankStatusName) {
		return bloodBankMasterDataService.searchBloodBankStatus(
				bloodBankStatusCode, bloodBankStatusName);
	}

	public boolean addBloodBankStatus(MasBloodBankStatus masBloodBankStatus) {
		return bloodBankMasterDataService
				.addBloodBankStatus(masBloodBankStatus);
	}

	public boolean deleteBloodBankStatus(int bloodBankStatusId,
			Map<String, Object> generalMap) {
		return bloodBankMasterDataService.deleteBloodBankStatus(
				bloodBankStatusId, generalMap);
	}

	public boolean editBloodBankStatusToDatabase(Map<String, Object> generalMap) {
		return bloodBankMasterDataService
				.editBloodBankStatusToDatabase(generalMap);
	}

	// -----------------------------------------Blood Donation
	// Type------------------------------

	public Map<String, Object> showBloodDonationTypeJsp() {
		return bloodBankMasterDataService.showBloodDonationTypeJsp();
	}

	public Map<String, Object> searchBloodDonationType(
			String bloodDonationTypeCode, String bloodDonationTypeName) {
		return bloodBankMasterDataService.searchBloodDonationType(
				bloodDonationTypeCode, bloodDonationTypeName);
	}

	public boolean addBloodDonationType(
			MasBloodDonationType masBloodDonationType) {
		return bloodBankMasterDataService
				.addBloodDonationType(masBloodDonationType);
	}

	public boolean deleteBloodDonationType(int bloodDonationTypeId,
			Map<String, Object> generalMap) {
		return bloodBankMasterDataService.deleteBloodDonationType(
				bloodDonationTypeId, generalMap);
	}

	public boolean editBloodDonationTypeToDatabase(
			Map<String, Object> generalMap) {
		return bloodBankMasterDataService
				.editBloodDonationTypeToDatabase(generalMap);
	}

	// ------------------------------Blood
	// Group--------------------------------------------

	public Map<String, Object> showBloodGroupJsp() {
		return bloodBankMasterDataService.showBloodGroupJsp();
	}

	public Map<String, Object> searchBloodGroup(String bloodGroupCode,
			String bloodGroupName) {
		return bloodBankMasterDataService.searchBloodGroup(bloodGroupCode,
				bloodGroupName);
	}

	public boolean addBloodGroup(MasBloodGroup masBloodGroup) {
		return bloodBankMasterDataService.addBloodGroup(masBloodGroup);
	}

	public boolean deleteBloodGroup(int bloodGroupId,
			Map<String, Object> generalMap) {
		return bloodBankMasterDataService.deleteBloodGroup(bloodGroupId,
				generalMap);
	}

	public boolean editBloodGroupToDatabase(Map<String, Object> generalMap) {
		return bloodBankMasterDataService.editBloodGroupToDatabase(generalMap);
	}

	// --------------------------------------------------------------------------------------------

	public BloodBankMasterDataService getBloodBankMasterDataService() {
		return bloodBankMasterDataService;
	}

	public void setBloodBankMasterDataService(
			BloodBankMasterDataService bloodBankMasterDataService) {
		this.bloodBankMasterDataService = bloodBankMasterDataService;
	}

}
