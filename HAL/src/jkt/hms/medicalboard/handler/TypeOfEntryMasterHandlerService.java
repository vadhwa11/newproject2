package jkt.hms.medicalboard.handler;

import java.util.Map;

import jkt.hms.masters.business.MbTypeOfEntryMaster;

public interface TypeOfEntryMasterHandlerService {

	Map<String, Object> showTypeOfEntryMasterJsp();

	boolean addTypeOfEntryMaster(MbTypeOfEntryMaster mbTypeOfEntryMasterMaster);

	Map<String, Object> searchTypeOfEntryMaster(String mbTypeOfEntryMasterName);

	boolean editTypeOfEntryMasterToDatabase(Map<String, Object> generalMap);

	boolean deleteTypeOfEntryMaster(int mbTypeOfEntryMasterId,
			Map<String, Object> generalMap);
}
