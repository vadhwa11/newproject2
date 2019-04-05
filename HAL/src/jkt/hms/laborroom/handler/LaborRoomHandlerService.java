package jkt.hms.laborroom.handler;

import java.util.Map;

public interface LaborRoomHandlerService {

	Map<String, Object> getLRWaitingList(Map<String, Object> mapForDS);
	Map<String, Object> showLaborRoomSubmitJsp(Map<String, Object> mapForDS);
	Map<String, Object> addMotherDetails(Map<String, Object> mapForDs);
	Map<String, Object> displayStockNBatch(Map<String, Object> mapForDs);
	Map<String, Object> getTransferPatientWaitingList(Map<String, Object> mapForDs);
	Map<String, Object> getTransferPatientDetails(Map<String, Object> mapForDs);
	Map<String, Object> submitPatientTransfer(Map<String, Object> mapForDs);
	
	

}
