package jkt.hms.masters.handler;

import jkt.hms.masters.business.MasReference;
import jkt.hms.masters.dataservice.RegistrationMasterDataService;

public class RegistrationMasterHandlerServiceImpl implements
		RegistrationMasterHandlerService {
	RegistrationMasterDataService registrationMasterDataService = null;

	public RegistrationMasterDataService getRegistrationMasterDataService() {
		return registrationMasterDataService;
	}

	public void setRegistrationMasterDataService(
			RegistrationMasterDataService registrationMasterDataService) {
		this.registrationMasterDataService = registrationMasterDataService;
	}

	// ---------------------------------ReferenceMaster by
	// Mansi-------------------------------------------

	public boolean addReference(MasReference masReference) {
		return registrationMasterDataService.addReference(masReference);
	}

	public boolean updateReference(MasReference masReference) {
		return registrationMasterDataService.updateReference(masReference);
	}

	public boolean deleteReference(int referenceId) {
		return registrationMasterDataService.deleteReference(referenceId);
	}

}
