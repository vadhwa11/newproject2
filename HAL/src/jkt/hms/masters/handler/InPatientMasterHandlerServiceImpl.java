package jkt.hms.masters.handler;

import java.util.Map;

import jkt.hms.masters.business.DischargeItems;
import jkt.hms.masters.business.DischargeItemsCategory;
import jkt.hms.masters.business.MasBabyStatus;
import jkt.hms.masters.business.MasBedStatus;
import jkt.hms.masters.business.MasBodyPart;
import jkt.hms.masters.business.MasCareType;
import jkt.hms.masters.business.MasDelivery;
import jkt.hms.masters.business.MasDischargeStatus;
import jkt.hms.masters.business.MasDisposedTo;
import jkt.hms.masters.business.MasInjuryNature;
import jkt.hms.masters.dataservice.InPatientMasterDataService;
import jkt.hms.util.Box;

public class InPatientMasterHandlerServiceImpl implements
		InPatientMasterHandlerService {

	InPatientMasterDataService inPatientMasterDataService = null;

	// ----------------------------------------------Bed
	// Status-------------------------------------------------

	public boolean addBedStatus(MasBedStatus masBedStatus) {
		return inPatientMasterDataService.addBedStatus(masBedStatus);
	}

	public boolean deleteBedStatus(int bedStatusId,
			Map<String, Object> generalMap) {
		return inPatientMasterDataService.deleteBedStatus(bedStatusId,
				generalMap);
	}

	public boolean editBedStatusToDatabase(Map<String, Object> generalMap) {
		return inPatientMasterDataService.editBedStatusToDatabase(generalMap);
	}

	public Map<String, Object> searchBedStatus(String bedStatusCode,
			String bedStatusName) {
		return inPatientMasterDataService.searchBedStatus(bedStatusCode,
				bedStatusName);
	}

	public Map<String, Object> showBedStatusJsp() {
		return inPatientMasterDataService.showBedStatusJsp();
	}

	// -------------------------- Injury Nature
	// ---------------------------------------

	public boolean addInjuryNature(MasInjuryNature masInjuryNature) {
		return inPatientMasterDataService.addInjuryNature(masInjuryNature);
	}

	public boolean editInjuryNatureToDatabase(Map<String, Object> generalMap) {
		return inPatientMasterDataService
				.editInjuryNatureToDatabase(generalMap);
	}

	public Map<String, Object> searchInjuryNature(String injuryNatureCode,
			String injuryNatureName) {
		return inPatientMasterDataService.searchInjuryNature(injuryNatureCode,
				injuryNatureName);
	}

	public Map<String, Object> showInjuryNatureJsp() {
		return inPatientMasterDataService.showInjuryNatureJsp();
	}

	public boolean deleteInjuryNature(int injuryNatureId,
			Map<String, Object> generalMap) {
		return inPatientMasterDataService.deleteInjuryNature(injuryNatureId,
				generalMap);
	}

	// ------------------------------- Baby
	// Status-----------------------------------
	public boolean addBabyStatus(MasBabyStatus masBabyStatus) {
		return inPatientMasterDataService.addBabyStatus(masBabyStatus);
	}

	public boolean editBabyStatusToDatabase(Map<String, Object> generalMap) {
		return inPatientMasterDataService.editBabyStatusToDatabase(generalMap);
	}

	public Map<String, Object> searchBabyStatus(String babyStatusCode,
			String babyStatusName) {
		return inPatientMasterDataService.searchBabyStatus(babyStatusCode,
				babyStatusName);
	}

	public Map<String, Object> showBabyStatusJsp() {
		return inPatientMasterDataService.showBabyStatusJsp();
	}

	public boolean deleteBabyStatus(int babyStatusId,
			Map<String, Object> generalMap) {
		return inPatientMasterDataService.deleteBabyStatus(babyStatusId,
				generalMap);
	}

	// ------------------------------------delivery------------------------------------------------------
	public boolean addDelivery(MasDelivery masDelivery) {
		return inPatientMasterDataService.addDelivery(masDelivery);
	}

	public boolean deleteDelivery(int deliveryId, Map<String, Object> generalMap) {
		return inPatientMasterDataService
				.deleteDelivery(deliveryId, generalMap);
	}

	public boolean editDeliveryToDatabase(Map<String, Object> generalMap) {
		return inPatientMasterDataService.editDeliveryToDatabase(generalMap);
	}

	public Map<String, Object> searchDelivery(String deliveryCode,
			String deliveryName) {
		return inPatientMasterDataService.searchDelivery(deliveryCode,
				deliveryName);
	}

	public Map<String, Object> showDeliveryJsp() {
		return inPatientMasterDataService.showDeliveryJsp();
	}

	// ----------------------------Care Type--------------------------------
	public Map<String, Object> showCareTypeJsp() {
		return inPatientMasterDataService.showCareTypeJsp();
	}

	public Map<String, Object> searchCareType(String careTypeCode,
			String careTypeName) {
		return inPatientMasterDataService.searchCareType(careTypeCode,
				careTypeName);
	}

	public boolean addCareType(MasCareType masCareType) {
		return inPatientMasterDataService.addCareType(masCareType);
	}

	public boolean deleteCareType(int careTypeId, Map<String, Object> generalMap) {
		return inPatientMasterDataService
				.deleteCareType(careTypeId, generalMap);
	}

	public boolean editCareTypeToDatabase(Map<String, Object> generalMap) {
		return inPatientMasterDataService.editCareTypeToDatabase(generalMap);
	}

	// -------------------------------Body Part----------------------------
	public Map<String, Object> showBodyPartJsp() {
		return inPatientMasterDataService.showBodyPartJsp();
	}

	public Map<String, Object> searchBodyPart(String bodyPartCode,
			String bodyPartName) {
		return inPatientMasterDataService.searchBodyPart(bodyPartCode,
				bodyPartName);
	}

	public boolean addBodyPart(MasBodyPart masBodyPart) {
		return inPatientMasterDataService.addBodyPart(masBodyPart);
	}

	public boolean deleteBodyPart(int bodyPartId, Map<String, Object> generalMap) {
		return inPatientMasterDataService
				.deleteBodyPart(bodyPartId, generalMap);
	}

	public boolean editBodyPartToDatabase(Map<String, Object> generalMap) {
		return inPatientMasterDataService.editBodyPartToDatabase(generalMap);
	}

	// ----------------------------Disposed
	// To------------------------------------
	public Map<String, Object> showDisposedToJsp() {
		return inPatientMasterDataService.showDisposedToJsp();
	}

	public Map<String, Object> searchDisposedTo(String disposedToCode,
			String disposedToName) {
		return inPatientMasterDataService.searchDisposedTo(disposedToCode,
				disposedToName);
	}

	public boolean addDisposedTo(MasDisposedTo masDisposedTo) {
		return inPatientMasterDataService.addDisposedTo(masDisposedTo);
	}

	public boolean deleteDisposedTo(int disposedToId,
			Map<String, Object> generalMap) {
		return inPatientMasterDataService.deleteDisposedTo(disposedToId,
				generalMap);
	}

	public boolean editDisposedToToDatabase(Map<String, Object> generalMap) {
		return inPatientMasterDataService.editDisposedToToDatabase(generalMap);
	}

	// ------------------------------------Discharge
	// Status---------------------------------------

	public boolean addDischargeStatus(MasDischargeStatus masDischargeStatus) {
		return inPatientMasterDataService
				.addDischargeStatus(masDischargeStatus);
	}

	public boolean deleteDischargeStatus(int dischargeStatusId,
			Map<String, Object> generalMap) {
		return inPatientMasterDataService.deleteDischargeStatus(
				dischargeStatusId, generalMap);
	}

	public boolean editDischargeStatusToDatabase(Map<String, Object> generalMap) {
		return inPatientMasterDataService
				.editDischargeStatusToDatabase(generalMap);
	}

	public Map<String, Object> searchDischargeStatus(
			String dischargeStatusCode, String dischargeStatusName) {
		return inPatientMasterDataService.searchDischargeStatus(
				dischargeStatusCode, dischargeStatusName);
	}

	public Map<String, Object> showDischargeStatusJsp() {
		return inPatientMasterDataService.showDischargeStatusJsp();
	}

	// -----------------------------DischargeItems-----------------------------------

	public boolean addDischargeItems(DischargeItems dischargeItems) {
		return inPatientMasterDataService.addDischargeItems(dischargeItems);
	}

	public boolean deleteDischargeItems(int dischargeItemsId,
			Map<String, Object> generalMap) {
		return inPatientMasterDataService.deleteDischargeItems(
				dischargeItemsId, generalMap);
	}

	public boolean editDischargeItemsToDatabase(Map<String, Object> generalMap) {
		return inPatientMasterDataService
				.editDischargeItemsToDatabase(generalMap);
	}

	public Map<String, Object> searchDischargeItems(String itemCode,
			String itemDescription) {
		return inPatientMasterDataService.searchDischargeItems(itemCode,
				itemDescription);
	}

	public Map<String, Object> showDischargeItemsJsp() {
		return inPatientMasterDataService.showDischargeItemsJsp();
	}

	// -----------------------------DischargeItemsCategory-----------------------------------
	public Map<String, Object> showDischargeCategoryJsp() {
		return inPatientMasterDataService.showDischargeCategoryJsp();
	}

	public boolean addDischargeItemsCategory(
			DischargeItemsCategory dischargeItemsCategory) {
		return inPatientMasterDataService
				.addDischargeItemsCategory(dischargeItemsCategory);
	}

	public boolean editDischargeItemsCategory(Map<String, Object> generalMap) {
		return inPatientMasterDataService
				.editDischargeItemsCategory(generalMap);
	}

	public boolean deleteDischargeItemsCategory(int dischargeCateogryId,
			Map<String, Object> generalMap) {
		return inPatientMasterDataService.deleteDischargeItemsCategory(
				dischargeCateogryId, generalMap);
	}

	public Map<String, Object> searchDischargeItemsCategory(String dischargeItem) {
		return inPatientMasterDataService
				.searchDischargeItemsCategory(dischargeItem);
	}

	// ---------------------------------------------------------------------------------------------
	public InPatientMasterDataService getInPatientMasterDataService() {
		return inPatientMasterDataService;
	}

	public void setInPatientMasterDataService(
			InPatientMasterDataService inPatientMasterDataService) {
		this.inPatientMasterDataService = inPatientMasterDataService;
	}

	@Override
	public Map<String, Object> getItemListForAutoComplete(Map<String, Object> map) {
		return inPatientMasterDataService.getItemListForAutoComplete(map);
	}

	@Override
	public Map<String, Object> submitKitIssueMasterDetails(Box box) {
		return inPatientMasterDataService.submitKitIssueMasterDetails(box);
	}

	@Override
	public Map<String, Object> getKitTemplateList(int hospitalId) {
		return inPatientMasterDataService.getKitTemplateList(hospitalId);
	}

	@Override
	public Map<String, Object> showKitIssueTemplateDetails(Box box) {
		return inPatientMasterDataService.showKitIssueTemplateDetails(box);
	}

	@Override
	public Map<String, Object> updateKitIssueMasterDetails(Box box) {
		return inPatientMasterDataService.updateKitIssueMasterDetails(box);
	}

	@Override
	public Map<String, Object> deleteKitIssueTemplate(Box box) {
		return inPatientMasterDataService.deleteKitIssueTemplate(box);
	}

	@Override
	public Map<String, Object> getPatientDetailsForKitIssue(Box box) {
		// TODO Auto-generated method stub
		return inPatientMasterDataService.getPatientDetailsForKitIssue(box);
	}
}
