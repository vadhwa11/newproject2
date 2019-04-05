package jkt.hms.laundry.handler;

import java.util.Date;
import java.util.Map;

import jkt.hms.laundry.dataservice.LaundryDataService;
import jkt.hms.masters.business.CarDiaryEntry;
import jkt.hms.masters.business.MachineActivity;
import jkt.hms.masters.business.MasLaundryMachine;
import jkt.hms.masters.business.MasLinenWeight;
import jkt.hms.util.Box;

public class LaundryHandlerServiceImpl implements LaundryHandlerService {
	// ---------------------------------------------------------------------------------------------
	LaundryDataService laundryDataService = null;

	public LaundryDataService getLaundryDataService() {
		return laundryDataService;
	}

	public void setLaundryDataService(LaundryDataService laundryDataService) {
		this.laundryDataService = laundryDataService;
	}

	// ---------------------------------------------------------------------------------------------

	public Map<String, Object> showLaundryJsp() {
		return laundryDataService.showLaundryJsp();
	}

	public boolean addLaundry(MasLaundryMachine masLaundryMachine) {
		return laundryDataService.addLaundry(masLaundryMachine);
	}

	public boolean editLaundry(Map<String, Object> generalMap) {
		return laundryDataService.editLaundry(generalMap);
	}

	public boolean deleteLaundry(int laundryId, Map<String, Object> generalMap) {
		return laundryDataService.deleteLaundry(laundryId, generalMap);
	}

	public Map<String, Object> searchLaundry(String machineName) {
		return laundryDataService.searchLaundry(machineName);
	}

	public Map<String, Object> showLinenWeightJsp() {
		return laundryDataService.showLinenWeightJsp();
	}

	public boolean addLinenWeight(MasLinenWeight masLinen) {
		return laundryDataService.addLinenWeight(masLinen);
	}

	public boolean editLinenWeight(Map<String, Object> generalMap) {
		return laundryDataService.editLinenWeight(generalMap);
	}

	public boolean deleteLinenWeight(int linenId, Map<String, Object> generalMap) {
		return laundryDataService.deleteLinenWeight(linenId, generalMap);

	}

	public Map<String, Object> searchLinenWeight(String linenCode,
			String linenName) {
		return laundryDataService.searchLinenWeight(linenCode, linenName);
	}

	public String generateEntryNumber(Map<String, Object> diagMap) {
		return laundryDataService.generateEntryNumber(diagMap);
	}

	public Map<String, Object> showMachineActivityEntry() {
		return laundryDataService.showMachineActivityEntry();
	}

	public boolean addMachineActivityEntry(MachineActivity machineActivity) {
		return laundryDataService.addMachineActivityEntry(machineActivity);
	}

	public boolean editMachineActivity(Map<String, Object> generalMap) {
		return laundryDataService.editMachineActivity(generalMap);
	}

	public boolean deleteMachineActivity(int machineActivityId,
			Map<String, Object> generalMap) {
		return laundryDataService.deleteMachineActivity(machineActivityId,
				generalMap);
	}

	public Map<String, Object> searchMachineActivity(String entryId,
			Date entryDate) {
		return laundryDataService.searchMachineActivity(entryId, entryDate);
	}

	public String generateEntryNumberForDiaryEntry(Map<String, Object> diagMap) {
		return laundryDataService.generateEntryNumberForDiaryEntry(diagMap);
	}

	public Map<String, Object> showCarDiaryEntry() {
		return laundryDataService.showCarDiaryEntry();
	}

	public boolean addCarDiaryEntry(CarDiaryEntry carDiaryEntry) {
		return laundryDataService.addCarDiaryEntry(carDiaryEntry);
	}

	public boolean deleteCarDiaryEntry(int carEntryId,
			Map<String, Object> generalMap) {
		return laundryDataService.deleteCarDiaryEntry(carEntryId, generalMap);
	}

	public boolean editCarDiaryEntry(Map<String, Object> generalMap) {
		return laundryDataService.editCarDiaryEntry(generalMap);
	}

	public Map<String, Object> searchCarDiaryEntry(String entryNo,
			Date entryDate) {
		return laundryDataService.searchCarDiaryEntry(entryNo, entryDate);
	}

	public Map<String, Object> showDailyWorkLoad() {
		return laundryDataService.showDailyWorkLoad();
	}

	public Map<String, Object> getItemListByAutocomplete(
			Map<String, Object> dataMap) {
		return laundryDataService.getItemListByAutocomplete(dataMap);
	}

	public Map<String, Object> addDailyWorkLoadEntry(Box box,
			Map<String, Object> dataMap) {
		return laundryDataService.addDailyWorkLoadEntry(box, dataMap);
	}

	public Map<String, Object> fillItems(Map<String, Object> dataMap) {
		return laundryDataService.fillItems(dataMap);
	}

	public Map<String, Object> getDailyWorkLoad(String entryNo, Date entryDate) {
		return laundryDataService.getDailyWorkLoad(entryNo, entryDate);
	}

	public Map<String, Object> editDailyWorkLoadEntry(Box box,
			Map<String, Object> dataMap) {
		return laundryDataService.editDailyWorkLoadEntry(box, dataMap);
	}

	public Map<String, Object> checkForExistingMasters(
			Map<String, Object> generalMap) {
		return laundryDataService.checkForExistingMasters(generalMap);
	}

	public Map<String, Object> getConnectionForReport() {
		return laundryDataService.getConnectionForReport();
	}

	public String getEntryNumber(String string) {
		return laundryDataService.getEntryNumber(string);
	}

	public String getEntryNumberForDiaryEntry(String string) {
		return laundryDataService.getEntryNumberForDiaryEntry(string);
	}

	public String getEntryNumberForWorkLoad(String string) {
		return laundryDataService.getEntryNumberForWorkLoad(string);
	}

	public String generateEntryNumberForDailyWorkLoad(
			Map<String, Object> diagMap) {
		return laundryDataService.generateEntryNumberForDailyWorkLoad(diagMap);
	}

		
}
