package jkt.hms.laborroom.handler;

import java.util.Map;

import jkt.hms.laborroom.dataservice.LaborRoomDataService;


public class LaborRoomHandlerServiceImpl implements LaborRoomHandlerService {

	LaborRoomDataService laborRoomDataService = null;

	public LaborRoomDataService getLaborRoomDataService() {
		return laborRoomDataService;
	}

	public void setLaborRoomDataService(LaborRoomDataService laborRoomDataService) {
		this.laborRoomDataService = laborRoomDataService;
	}

	public Map<String, Object> getLRWaitingList(Map<String, Object> mapForDS) {
		return laborRoomDataService.getLRWaitingList(mapForDS);
	}
	
	public Map<String, Object> showLaborRoomSubmitJsp(Map<String, Object> mapForDS) {
		return laborRoomDataService.showLaborRoomSubmitJsp(mapForDS);
	}
	
	public Map<String, Object> addMotherDetails(Map<String, Object> mapForDs) {
		return laborRoomDataService.addMotherDetails(mapForDs);
	}

	public Map<String, Object> displayStockNBatch(Map<String, Object> mapForDs) {
		return laborRoomDataService.displayStockNBatch(mapForDs);
	}
	public Map<String, Object> getTransferPatientWaitingList(Map<String, Object> mapForDs) {
		return laborRoomDataService.getTransferPatientWaitingList(mapForDs);
	}
	
	public Map<String, Object> getTransferPatientDetails(Map<String, Object> mapForDs) {
		return laborRoomDataService.getTransferPatientDetails(mapForDs);
	}
	
	public Map<String, Object> submitPatientTransfer(Map<String, Object> mapForDs) {
		return laborRoomDataService.submitPatientTransfer(mapForDs);
	}
}
