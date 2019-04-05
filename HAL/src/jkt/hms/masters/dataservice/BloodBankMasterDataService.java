package jkt.hms.masters.dataservice;

import java.util.Map;

import jkt.hms.masters.business.MasBloodBankStatus;
import jkt.hms.masters.business.MasBloodDonationType;
import jkt.hms.masters.business.MasBloodGroup;

public interface BloodBankMasterDataService {

	// -----------------------------------Blood bank
	// Status-----------------------------------------

	boolean deleteBloodBankStatus(int bloodBankStatusId,
			Map<String, Object> generalMap);

	boolean addBloodBankStatus(MasBloodBankStatus masBloodBankStatus);

	boolean editBloodBankStatusToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchBloodBankStatus(String bloodBankStatusCode,
			String bloodBankStatusName);

	Map<String, Object> showBloodBankStatusJsp();

	// ------------------------------Blood donation type-----------------------

	boolean addBloodDonationType(MasBloodDonationType masBloodDonationType);

	boolean deleteBloodDonationType(int bloodDonationTypeId,
			Map<String, Object> generalMap);

	boolean editBloodDonationTypeToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchBloodDonationType(String bloodDonationTypeCode,
			String bloodDonationTypeName);

	Map<String, Object> showBloodDonationTypeJsp();

	// -----------------------------------Blood
	// Group---------------------------------------

	boolean addBloodGroup(MasBloodGroup masBloodGroup);

	boolean deleteBloodGroup(int bloodGroupId, Map<String, Object> generalMap);

	boolean editBloodGroupToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchBloodGroup(String bloodGroupCode,
			String bloodGroupName);

	Map<String, Object> showBloodGroupJsp();

}
