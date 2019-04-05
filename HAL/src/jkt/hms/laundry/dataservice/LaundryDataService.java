package jkt.hms.laundry.dataservice;

import java.util.Date;
import java.util.Map;

import jkt.hms.masters.business.CarDiaryEntry;
import jkt.hms.masters.business.MachineActivity;
import jkt.hms.masters.business.MasLaundryMachine;
import jkt.hms.masters.business.MasLinenWeight;
import jkt.hms.util.Box;

public interface LaundryDataService {
	public Map<String, Object> showLaundryJsp();

	public boolean addLaundry(MasLaundryMachine masLaundryMachine);

	public boolean editLaundry(Map<String, Object> generalMap);

	public boolean deleteLaundry(int laundryId, Map<String, Object> generalMap);

	public Map<String, Object> searchLaundry(String machineName);

	public Map<String, Object> showLinenWeightJsp();

	public boolean addLinenWeight(MasLinenWeight masLinen);

	public boolean editLinenWeight(Map<String, Object> generalMap);

	public boolean deleteLinenWeight(int linenId, Map<String, Object> generalMap);

	public Map<String, Object> searchLinenWeight(String linenCode,
			String linenName);

	public String generateEntryNumber(Map<String, Object> diagMap);

	public Map<String, Object> showMachineActivityEntry();

	public boolean addMachineActivityEntry(MachineActivity machineActivity);

	public boolean editMachineActivity(Map<String, Object> generalMap);

	public boolean deleteMachineActivity(int machineActivityId,
			Map<String, Object> generalMap);

	public Map<String, Object> searchMachineActivity(String entryId,
			Date entryDate);

	public String generateEntryNumberForDiaryEntry(Map<String, Object> diagMap);

	public Map<String, Object> showCarDiaryEntry();

	public boolean addCarDiaryEntry(CarDiaryEntry carDiaryEntry);

	public boolean deleteCarDiaryEntry(int carEntryId,
			Map<String, Object> generalMap);

	public boolean editCarDiaryEntry(Map<String, Object> generalMap);

	public Map<String, Object> searchCarDiaryEntry(String entryNo,
			Date entryDate);

	public Map<String, Object> showDailyWorkLoad();

	public Map<String, Object> getItemListByAutocomplete(
			Map<String, Object> dataMap);

	public Map<String, Object> getDailyWorkLoad(String entryNo, Date entryDate);

	public Map<String, Object> addDailyWorkLoadEntry(Box box,
			Map<String, Object> dataMap);

	public Map<String, Object> fillItems(Map<String, Object> dataMap);

	public Map<String, Object> editDailyWorkLoadEntry(Box box,
			Map<String, Object> dataMap);

	public Map<String, Object> checkForExistingMasters(
			Map<String, Object> generalMap);

	public Map<String, Object> getConnectionForReport();

	public String getEntryNumber(String string);

	public String getEntryNumberForDiaryEntry(String string);

	public String getEntryNumberForWorkLoad(String string);

	public String generateEntryNumberForDailyWorkLoad(
			Map<String, Object> diagMap);
	

}
