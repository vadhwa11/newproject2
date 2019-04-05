package jkt.hms.masters.handler;

import java.util.Map;

import jkt.hms.masters.business.MasAnesthesia;
import jkt.hms.masters.business.MasOpInstruction;
import jkt.hms.masters.business.MasOt;
import jkt.hms.masters.business.MasOtDistribution;
import jkt.hms.masters.business.OtMasChargeDetails;
import jkt.hms.masters.dataservice.OTMasterDataService;

public class OTMasterHandlerServiceImpl implements OTMasterHandlerService {
	OTMasterDataService otMasterDataService = null;

	// --------------------------------------Anesthesia-----------------------------------------
	public Map<String, Object> showAnesthesiaJsp() {
		return otMasterDataService.showAnesthesiaJsp();
	}

	public Map<String, Object> searchAnesthesia(String anesthesiaCode,
			String anesthesiaName) {
		return otMasterDataService.searchAnesthesia(anesthesiaCode,
				anesthesiaName);
	}

	public boolean addAnesthesia(MasAnesthesia anesthesiaMaster) {
		return otMasterDataService.addAnesthesia(anesthesiaMaster);
	}

	public boolean deleteAnesthesia(int anesthesiaId,
			Map<String, Object> generalMap) {
		return otMasterDataService.deleteAnesthesia(anesthesiaId, generalMap);
	}

	public boolean editAnesthesiaToDatabase(Map<String, Object> generalMap) {
		return otMasterDataService.editAnesthesiaToDatabase(generalMap);
	}

	// --------------------------------------Master
	// OT-----------------------------------------
	public Map<String, Object> showOtJsp() {
		return otMasterDataService.showOtJsp();
	}

	public Map<String, Object> searchOt(String otCode, String otName) {
		return otMasterDataService.searchOt(otCode, otName);
	}

	public boolean addOt(MasOt masOt) {
		return otMasterDataService.addOt(masOt);
	}

	public boolean deleteOt(int otId, Map<String, Object> generalMap) {
		return otMasterDataService.deleteOt(otId, generalMap);
	}

	public boolean editOtToDatabase(Map<String, Object> generalMap) {
		return otMasterDataService.editOtToDatabase(generalMap);
	}

	// --------------------------------------- Master OT bDistribution
	// -------------------------

	public Map<String, Object> showOtDistributionJsp() {
		return otMasterDataService.showOtDistributionJsp();
	}

	public boolean addOtDistribution(MasOtDistribution masOtDistribution) {
		return otMasterDataService.addOtDistribution(masOtDistribution);
	}

	public Map<String, Object> checkForExistingDaysOt(
			Map<String, Object> generalMap) {
		return otMasterDataService.checkForExistingDaysOt(generalMap);
	}

	public Map<String, Object> searchOtDistribution(String oTName, String days) {
		return otMasterDataService.searchOtDistribution(oTName, days);
	}

	public boolean deleteOtDistribution(int otDistributionId,
			Map<String, Object> generalMap) {
		return otMasterDataService.deleteOtDistribution(otDistributionId,
				generalMap);
	}

	public boolean editOtDistribution(Map<String, Object> generalMap) {
		return otMasterDataService.editOtDistribution(generalMap);
	}

	// --------------------------------------- Master OT Charge Details
	// -------------------------

	public boolean addOtMasChargeDetails(OtMasChargeDetails masChargeDetails) {
		return otMasterDataService.addOtMasChargeDetails(masChargeDetails);
	}

	public boolean deleteOtMasChargeDetails(int otMasChargeDetailsId,
			Map<String, Object> generalMap) {
		return otMasterDataService.deleteOtMasChargeDetails(
				otMasChargeDetailsId, generalMap);
	}

	public Map<String, Object> searchOtMasChargeDetails(String chargeCodeName) {
		return otMasterDataService.searchOtMasChargeDetails(chargeCodeName);
	}

	public Map<String, Object> showOtMasChargeDetailsJsp() {
		return otMasterDataService.showOtMasChargeDetailsJsp();
	}

	public boolean editOtMasChargeDetails(Map<String, Object> generalMap) {
		return otMasterDataService.editOtMasChargeDetails(generalMap);
	}

	public Map<String, Object> getChageCodeByAutocomplete(
			Map<String, Object> dataMap) {
		return otMasterDataService.getChageCodeByAutocomplete(dataMap);
	}

	public Map<String, Object> fillChargeCodeNameInGrid(
			Map<String, Object> dataMap) {
		return otMasterDataService.fillChargeCodeNameInGrid(dataMap);
	}

	public Map<String, Object> checkForExistingChargeCodeId(
			Map<String, Object> generalMap) {
		return otMasterDataService.checkForExistingChargeCodeId(generalMap);
	}

	public Map<String, Object> checkForExistingChargeCodeName(
			Map<String, Object> generalMap) {
		return otMasterDataService.checkForExistingChargeCodeName(generalMap);
	}

	// -----------------------------------------------------------------------------------------------------

	public void setOtMasterDataService(OTMasterDataService otMasterDataService) {
		this.otMasterDataService = otMasterDataService;
	}

	public OTMasterDataService getOtMasterDataService() {
		return otMasterDataService;
	}

	@Override
	public Map<String, Object> showOpInstructionJsp() {
		return otMasterDataService.showOpInstructionJsp();
	}

	@Override
	public boolean addOpInstructionJsp(MasOpInstruction masOpInstruction) {
		return otMasterDataService.addOpInstructionJsp(masOpInstruction);
	}

	@Override
	public Map<String, Object> checkForExistingOpInstruction(
			Map<String, Object> generalMap) {
		return otMasterDataService.checkForExistingOpInstruction(generalMap);
	}

	@Override
	public boolean editOpInstruction(Map<String, Object> generalMap) {
		return otMasterDataService.editOpInstruction(generalMap);
	}

	@Override
	public boolean deleteOpInstruction(int opInstructionId,
			Map<String, Object> generalMap) {
		return otMasterDataService.deleteOpInstruction(opInstructionId, generalMap);
	}

	@Override
	public Map<String, Object> searchOpInstruction(int instructionSearch) {
		return otMasterDataService.searchOpInstruction(instructionSearch);
	}

}
