package jkt.hms.masters.handler;

import java.util.Map;

import jkt.hms.masters.business.MasAnesthesia;
import jkt.hms.masters.business.MasOpInstruction;
import jkt.hms.masters.business.MasOt;
import jkt.hms.masters.business.MasOtDistribution;
import jkt.hms.masters.business.OtMasChargeDetails;

public interface OTMasterHandlerService {

	// --------------------------------------Anesthesia-----------------------------------------
	boolean addAnesthesia(MasAnesthesia anesthesiaMaster);

	boolean editAnesthesiaToDatabase(Map<String, Object> generalMap);

	boolean deleteAnesthesia(int anesthesiaId, Map<String, Object> generalMap);

	Map<String, Object> searchAnesthesia(String anesthesiaCode,
			String anesthesiaName);

	Map<String, Object> showAnesthesiaJsp();

	// --------------------------------------Master
	// OT-----------------------------------------

	boolean addOt(MasOt masOt);

	boolean editOtToDatabase(Map<String, Object> generalMap);

	boolean deleteOt(int otId, Map<String, Object> generalMap);

	Map<String, Object> searchOt(String otCode, String otName);

	Map<String, Object> showOtJsp();

	// --------------------------------------- Master OT Distribution
	// -------------------------

	Map<String, Object> showOtDistributionJsp();

	boolean addOtDistribution(MasOtDistribution masOtDistribution);

	Map<String, Object> checkForExistingDaysOt(Map<String, Object> generalMap);

	Map<String, Object> searchOtDistribution(String oTName, String days);

	boolean deleteOtDistribution(int otDistributionId,
			Map<String, Object> generalMap);

	boolean editOtDistribution(Map<String, Object> generalMap);

	// --------------------------------------- Master OT Charge Details
	// -------------------------

	Map<String, Object> showOtMasChargeDetailsJsp();

	boolean addOtMasChargeDetails(OtMasChargeDetails masChargeDetails);

	boolean deleteOtMasChargeDetails(int otMasChargeDetailsId,
			Map<String, Object> generalMap);

	Map<String, Object> searchOtMasChargeDetails(String chageName);

	boolean editOtMasChargeDetails(Map<String, Object> generalMap);

	Map<String, Object> getChageCodeByAutocomplete(Map<String, Object> dataMap);

	Map<String, Object> fillChargeCodeNameInGrid(Map<String, Object> dataMap);

	Map<String, Object> checkForExistingChargeCodeId(
			Map<String, Object> generalMap);

	Map<String, Object> checkForExistingChargeCodeName(
			Map<String, Object> generalMap);

	Map<String, Object> showOpInstructionJsp();

	boolean addOpInstructionJsp(MasOpInstruction masOpInstruction);

	Map<String, Object> checkForExistingOpInstruction(
			Map<String, Object> generalMap);

	boolean editOpInstruction(Map<String, Object> generalMap);

	boolean deleteOpInstruction(int opInstructionId,
			Map<String, Object> generalMap);

	Map<String, Object> searchOpInstruction(int instructionSearch);

}
