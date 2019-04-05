package jkt.hms.medicalboard.handler;

import java.util.Map;

import jkt.hms.masters.business.MbTypeOfEntryMaster;
import jkt.hms.medicalboard.dataservice.TypeOfEntryMasterDataService;

public class TypeOfEntryMasterHandlerServiceImpl implements
		TypeOfEntryMasterHandlerService {
	TypeOfEntryMasterDataService typeOfEntryMasterDataService = null;

	// ---------------------------------- Work Category
	// ------------------------------------

	public Map<String, Object> showTypeOfEntryMasterJsp() {
		return typeOfEntryMasterDataService.showTypeOfEntryMasterJsp();
	}

	public boolean addTypeOfEntryMaster(MbTypeOfEntryMaster masTypeOfEntryMaster) {
		return typeOfEntryMasterDataService
				.addTypeOfEntryMaster(masTypeOfEntryMaster);
	}

	public Map<String, Object> searchTypeOfEntryMaster(
			String typeOfEntryMasterName) {
		return typeOfEntryMasterDataService
				.searchTypeOfEntryMaster(typeOfEntryMasterName);
	}

	public boolean editTypeOfEntryMasterToDatabase(
			Map<String, Object> generalMap) {
		return typeOfEntryMasterDataService
				.editTypeOfEntryMasterToDatabase(generalMap);
	}

	public boolean deleteTypeOfEntryMaster(int typeOfEntryMasterId,
			Map<String, Object> generalMap) {
		return typeOfEntryMasterDataService.deleteTypeOfEntryMaster(
				typeOfEntryMasterId, generalMap);
	}

	// ------------------------------------------------------------

	public TypeOfEntryMasterDataService getTypeOfEntryMasterDataService() {
		return typeOfEntryMasterDataService;
	}

	public void setTypeOfEntryMasterDataService(
			TypeOfEntryMasterDataService typeOfEntryMasterDataService) {
		this.typeOfEntryMasterDataService = typeOfEntryMasterDataService;
	}

}
