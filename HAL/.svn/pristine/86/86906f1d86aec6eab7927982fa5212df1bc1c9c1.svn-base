package jkt.hms.masters.handler;

import java.util.Map;

import jkt.hms.masters.business.MasBloodBankStatus;
import jkt.hms.masters.business.MasBloodDonationType;
import jkt.hms.masters.business.MasBloodGroup;

public interface BloodBankMasterHandlerService {

	// -------------------------- Blood Bank
	// Status-----------------------------------------------

	Map<String, Object> showBloodBankStatusJsp();

	Map<String, Object> searchBloodBankStatus(String bloodBankStatusCode,
			String bloodBankStatusName);

	boolean deleteBloodBankStatus(int bloodBankStatusId,
			Map<String, Object> generalMap);

	boolean addBloodBankStatus(MasBloodBankStatus masBloodBankStatus);

	boolean editBloodBankStatusToDatabase(Map<String, Object> generalMap);

	// ----------------------------------- Blood Donation Type------------------

	Map<String, Object> searchBloodDonationType(String bloodDonationTypeCode,
			String bloodDonationTypeName);

	Map<String, Object> showBloodDonationTypeJsp();

	boolean addBloodDonationType(MasBloodDonationType masBloodDonationType);

	boolean deleteBloodDonationType(int bloodDonationTypeId,
			Map<String, Object> generalMap);

	boolean editBloodDonationTypeToDatabase(Map<String, Object> generalMap);

	// ------------------------------------------- Blood
	// Group--------------------------------------------

	Map<String, Object> searchBloodGroup(String bloodGroupCode,
			String bloodGroupName);

	Map<String, Object> showBloodGroupJsp();

	boolean addBloodGroup(MasBloodGroup masBloodGroup);

	boolean deleteBloodGroup(int bloodGroupId, Map<String, Object> generalMap);

	boolean editBloodGroupToDatabase(Map<String, Object> generalMap);

}
