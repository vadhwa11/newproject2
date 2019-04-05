package jkt.hms.masters.handler;

import java.util.Map;


import jkt.hms.masters.business.MasDepartment;

import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasEmpCategory;
import jkt.hms.masters.business.MasEmpStatus;

import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasMaritalStatus;

import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasRankCategory;
import jkt.hms.masters.business.MasRelation;
import jkt.hms.masters.business.MasReligion;

import jkt.hms.masters.business.MasServiceStatus;
import jkt.hms.masters.business.MasServiceType;
import jkt.hms.masters.business.MasState;
import jkt.hms.masters.business.MasStoreFinancial;
import jkt.hms.masters.business.MasStoreSupplier;
import jkt.hms.masters.business.MasTitle;
import jkt.hms.masters.business.MasTrade;

import jkt.hms.masters.business.MasUnit;

import jkt.hms.util.Box;

public interface MastersHandlerService {

	Map<String, Object> showHospitalJsp();

	boolean addHospital(MasHospital masHospital, Map<String, Object> generalMap);

	boolean editHospitalToDatabase(Map<String, Object> generalMap);

	boolean deleteHospital(int storeId, Map<String, Object> generalMap);

	Map<String, Object> checkForExistingMasters(Map<String, Object> generalMap);

	Map<String, Object> searchHospital(String hospitalCode, String hospitalName);

	Map showDepartmentJsp();

	boolean addDepartment(MasDepartment masDepartment);

	Map<String, Object> searchDepartment(String departmentCode,
			String departmentName);

	boolean editDepartmentToDatabase(Map<String, Object> generalMap);

	boolean deleteDepartment(int departmentId, Map<String, Object> generalMap);

	Map<String, Object> showRankJsp();

	boolean addRank(MasRank masRank);

	Map<String, Object> searchRank(String rankCode, String rankName);

	boolean editRankToDatabase(Map<String, Object> generalMap);

	boolean deleteRank(int rankId, Map<String, Object> generalMap);

	Map<String, Object> showRankCategoryJsp();

	boolean deleteRankCategory(int rankCategoryId,
			Map<String, Object> generalMap);

	boolean editRankCategoryToDatabase(Map<String, Object> generalMap);

	boolean addRankCategory(MasRankCategory masRankCategory);

	Map<String, Object> searchRankCategory(String rankCategoryCode,
			String rankCategoryName);

	Map<String, Object> showUnitJsp();

	boolean deleteUnit(int unitId, Map<String, Object> generalMap);

	boolean editUnitToDatabase(Map<String, Object> generalMap);

	boolean addUnit(MasUnit masUnit);

	Map<String, Object> searchUnit(String unitName);

	Map showServiceTypeJsp();

	Map<String, Object> searchServiceType(String serviceTypeCode,
			String serviceTypeName);

	boolean addServiceType(MasServiceType masServiceType);

	boolean deleteServiceType(int serviceTypeId, Map<String, Object> generalMap);

	boolean editServiceTypeToDatabase(Map<String, Object> generalMap);

	Map showServiceStatusJsp();

	Map<String, Object> searchServiceStatus(String serviceStatusCode,
			String serviceStatusName);

	boolean addServiceStatus(MasServiceStatus masServiceStatus);

	boolean editServiceStatusToDatabase(Map<String, Object> generalMap);

	boolean deleteServiceStatus(int serviceStatusId,
			Map<String, Object> generalMap);

	Map showEmpCategoryJsp();

	boolean addEmpCategory(MasEmpCategory masEmpCategory);

	boolean editEmpCategoryToDatabase(Map<String, Object> generalMap);

	boolean deleteEmpCategory(int empcategoryId, Map<String, Object> generalMap);

	Map<String, Object> searchEmpCategory(String empCategoryCode,String empCategoryName);

	Map showDepotJsp();

	/*boolean addDepot(MasDepot masDepot);*/

	boolean editDepotToDatabase(Map<String, Object> generalMap);

	boolean deleteDepot(int depotId, Map<String, Object> generalMap);

	Map<String, Object> searchDepot(String depotCode, String depotName);

	Map<String, Object> showStateJsp();

	boolean addState(MasState masState);

	boolean editState(Map<String, Object> generalMap);

	Map<String, Object> searchState(String stateCode, String stateName);

	boolean deleteState(int stateId, Map<String, Object> generalMap);

	Map<String, Object> showDistrict();

	boolean addDistrict(MasDistrict masDistrict);

	boolean editDistrict(Map<String, Object> generalMap);

	Map<String, Object> searchDistrict(String districtCode, String districtName);

	boolean deleteDistrict(int districtId, Map<String, Object> generalMap);

	//-------------------------- Start of Report Method By Mansi on 31 July 2013
	
	Map<String, Object> getHospitalName(Map<String, Object> mapForDs);

	Map<String, Object> getConnection();
	
	//------------------ ** Employee Master -------------------

	Map<String, Object> showEmployeeJsp(int storeId);
	
	Map<String, Object> searchEmployee(String serviceNo, String firstName,String lastName, int storeId);

	boolean addEmployee(Map<String, Object> userMap);
	
	boolean editEmployeeToDatabase(Map<String, Object> generalMap);
	
	boolean deleteEmployee(int employeeId, Map<String, Object> generalMap);
	
	//-------------------- ** Title Master ** -------------------------------

	Map<String, Object> showTitleJsp();

	boolean addTitle(MasTitle masTitle);

	boolean editTitleToDatabase(Map<String, Object> generalMap);

	boolean deleteTitle(int titleId, Map<String, Object> generalMap);
	
	Map<String, Object> searchTitle(String titleCode, String titleName);
	
	//-------------------- ** Trade Master ** -------------------------------
	
	Map<String, Object> showTradeJsp();

	Map<String, Object> searchTrade(String tradeCode, String tradeName);

	boolean addTrade(MasTrade masTrade);

	boolean editTradeToDatabase(Map<String, Object> generalMap);

	boolean deleteTrade(int tradeId, Map<String, Object> generalMap);

	//-------------------- ** Employee Status Master ** -------------------------------
	
	Map<String, Object> searchEmpStatus(String empStatusCode,String empStatusName);
	
	Map<String, Object> showEmpStatusJsp();

	boolean addEmpStatus(MasEmpStatus masEmpStatus);

	boolean editEmpStatusToDatabase(Map<String, Object> generalMap);

	boolean deleteEmpStatus(int empStatusId, Map<String, Object> generalMap);

	//-------------------------- End of Report Method By Mansi on 31 July 2013

	Map<String, Object> showDepotUnitJsp();

	Map<String, Object> addDepotUnit(Box box);

	Map<String, Object> updateDepotUnit(Box box);

	boolean deleteDepotUnit(Box box);

	Map<String, Object> searchDepotUnit(Box box);
	
//-------------------------- NRS
	
	Map<String, Object> showNrsJsp();

	Map<String, Object> searchNrs(String nrsCode, String nrsName);

	/*boolean addNrs(MasNrs masNrs);*/

	boolean editNrsToDatabase(Map<String, Object> generalMap);

	boolean deleteNrs(int nrsId, Map<String, Object> generalMap);

//-------------------------- Traffic Destination
	
	Map<String, Object> showTrafficDestinationJsp();

	Map<String, Object> searchTrafficDestination(String trafficDestinationCode,	String trafficDestinationName);

	boolean editTrafficDestinationToDatabase(Map<String, Object> generalMap);

	boolean deleteTrafficDestination(int trafficDestinationId,Map<String, Object> generalMap);

	/*boolean addTrafficDestination(MasTrafficDestination masTrafficDestination);*/

//-------------------------- Nrs And Traffic Destination
	
	Map<String, Object> showNrsTrafficDestinationJsp();

	Map<String, Object> addNrsTrafficDestination(Box box);

	Map<String, Object> updateNrsTrafficDestination(Box box);

	boolean deleteNrsTrafficDestination(Box box);

	Map<String, Object> searchNrsTrafficDestination(Box box);
	
	//-------------------------- Agency Type
	
	Map<String, Object> showAgencyTypeJsp();

	Map<String, Object> searchAgencyType(String agencyTypeCode,	String agencyTypeName);

	/*boolean addAgencyType(MasExternalAgencyType masAgencyType);*/
	
	boolean deleteAgencyType(int agencyTypeId, Map<String, Object> generalMap);

	boolean editAgencyTypeToDatabase(Map<String, Object> generalMap);
	
	//-------------------------- Agency

	Map<String, Object> showAgencyJsp();

	boolean deleteAgency(int agencyId, Map<String, Object> generalMap);

	Map<String, Object> searchAgency(String agencyCode, String agencyName);

	boolean editAgency(Map<String, Object> generalMap);

	boolean addAgency(MasStoreSupplier masAgency);
	
	//-------------------------- BudgetComponent

	Map<String, Object> showBudgetComponentJsp();

	Map<String, Object> searchBudgetComponent(String budgetComponentCode,String budgetComponentName);

	boolean editBudgetComponentToDatabase(Map<String, Object> generalMap);

	/*boolean addBudgetComponent(MasBudgetComponent masBudgetComponent);*/
	
	boolean deleteBudgetComponent(int budgetComponentId,Map<String, Object> generalMap);

		
	//-------------------------- Activity
	
	Map showActivityJsp();

	boolean editActivity(Map<String, Object> generalMap);

	Map<String, Object> searchActivity(String activityCode, String activityName);
	
	boolean deleteActivity(int activityId, Map<String, Object> generalMap);

	/*boolean addActivity(MasPromotionalActivity masActivity);*/
	
	
	//-------------------------- Grower
	

	Map showGrowerJsp(int locationId);

	boolean editGrower(Map<String, Object> generalMap);

	Map<String, Object> searchGrower(int centreId, String growerName, int locationId);

	boolean deleteGrower(int growerId, Map<String, Object> generalMap);
	
	/*boolean addGrower(MasGrower masGrower, Map<String, Object> generalMap);*/

	Map<String, Object> getDistrictList(Map<String, Object> dataMap);

	Map<String, Object> getTalukList(Map<String, Object> dataMap);

	Map<String, Object> getVillageList(Map<String, Object> dataMap);

	Map<String, Object> getGrowerDetail(Map<String, Object> dataMap);

	Map<String, Object> getGrowerLandDetail(Map<String, Object> dataMap);

	/*boolean addGrowerDetail(MasGrowerDetails masGrowerDetails);*/
	

	boolean updateGrowerLandDetail(Map<String, Object> generalMap);

	Map<String, Object> displayPhoto(String code);
	


	Map<String, Object> searchFinancialYearMaster(String year,String financialYear);

	boolean addFinancialYearMaster(MasStoreFinancial hrMasFinancialYear);

	Map<String, Object> showFinancialJsp();

	boolean editFinancialYearMaster(Map<String, Object> generalMap);

	boolean deleteFinancialYearMaster(int financialYrId, Map<String, Object> generalMap);
	
	
	//----------------- Caste------------------

	Map<String, Object> showCasteJsp();

	Map<String, Object> searchCaste(String casteCode, String casteName);

	/*boolean addCaste(MasEmployeeCaste masCaste);*/

	boolean editCasteToDatabase(Map<String, Object> generalMap);

	boolean deleteCaste(int casteId, Map<String, Object> generalMap);

	//----------------- Sub Caste------------------
	
	Map<String, Object> showSubCasteJsp();

	Map<String, Object> searchSubCaste(String subCasteCode, String subCasteName);

	/*boolean addSubCaste(MasEmployeeSubCaste masSubCaste);*/

	boolean editSubCasteToDatabase(Map<String, Object> generalMap);

	boolean deleteSubCaste(int subCasteId, Map<String, Object> generalMap);


	//--------------- Category----------
	Map showCategoryJsp();

	/*boolean addCategory(MasCategory masCategory);*/

	boolean deleteCategory(int categoryId, Map<String, Object> generalMap);

	boolean editCategoryToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchCategory(String CategoryCode,String CategoryName);
	
	//------------ Asset Category------------------

	Map showAssetCategoryJsp();

	/*boolean addAssetCategory(MasAssetCategory masAssetCategory);*/
	
	boolean editAssetCategory(Map<String, Object> generalMap);

	Map<String, Object> searchAssetCategory(String assetCategoryCode,
			String assetCategoryName);

	boolean deleteAssetCategory(int assetCategoryId,Map<String, Object> generalMap);

	
	//---------- Asset Details --------------
	
	Map showAssetDetailsJsp(int locationId);

	Map<String, Object> getAssetDetail(Map<String, Object> dataMap);

	Map<String, Object> checkForExistingAssetDetail(Map<String, Object> generalMap);

	/*boolean addAssetDetails(ProjAssetDetails proj,
			Map<String, Object> generalMap);*/

	boolean editAssetDetails(int assetDetailsId, Map<String, Object> generalMap);

	Map<String, Object> checkForExistingAssetDetailId(Map<String, Object> generalMap);

	Map<String, Object> checkForExistingMastersId(Map<String, Object> generalMap);

	Map<String, Object> getSupplierList(Map<String, Object> dataMap);

	Map showBlock();

	/*boolean addBlock(MasBlock masBlock);*/

	boolean editBlock(Map<String, Object> generalMap);

	Map<String, Object> searchBlock(String blockCode, String blockName);

	boolean deleteBlock(int blockId, Map<String, Object> generalMap);

	Map showVillage(Box box);

	/*boolean addVillage(MasVillage masVillage);*/

	boolean editVillage(Map<String, Object> generalMap);

	Map<String, Object> searchVillage(String villageCode, String villageName,Box box);

	boolean deleteVillage(int villageId, Map<String, Object> generalMap);

	Map<String, Object> getAssetCat(Map<String, Object> dataMap);

	Map<String, Object> searchAssetDetail(Box box);

	Map<String, Object> getSurveyNo(Map<String, Object> dataMap);

	Map<String, Object> openGrowerHistoryPopUp(Box box);


	Map<String, Object> showMaritalStatusJsp();

	Map<String, Object> searchMaritalStatus(String maritalStatusCode,
			String maritalStatusName);

	
	boolean addMaritalStatus(MasMaritalStatus masMaritalStatus);

	boolean editMaritalStatusToDatabase(Map<String, Object> generalMap);

	boolean deleteMaritalStatus(int maritalStatusId,
			Map<String, Object> generalMap);

	Map<String, Object> showReligionJsp();

	Map<String, Object> searchReligion(String religionCode, String religionName);

	boolean editReligionToDatabase(Map<String, Object> generalMap);

	boolean deleteReligion(int religionId, Map<String, Object> generalMap);

	boolean addReligion(MasReligion masReligion);

	Map<String, Object> showRelationJsp();

	boolean addRelation(MasRelation masRelation);

	Map<String, Object> searchRelation(String relationCode, String relationName);

	boolean editRelationToDatabase(Map<String, Object> generalMap);

	boolean deleteRelation(int relationId, Map<String, Object> generalMap);

	/*boolean addRsk(MasRsk masRsk);*/

	Map<String, Object> showRskJsp();

	boolean editRskToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchRsk(String rskName);

	boolean deleteRsk(int rskId, Map<String, Object> generalMap);

	Map<String, Object> showUserLocationMappingJsp(Box box);

	Map<String, Object> addUserLocationMapping(Map<String, Object> mapForDs);

	Map<String, Object> deleteUserLocationMapping(Map<String, Object> mapForDs);

	Map<String, Object> editUserLocationMapping(Map<String, Object> mapForDs);

	Map<String, Object> getUsersList(Map<String, Object> dataMap);

	Map<String, Object> searchUserLocationMapping(int usersSearchId);

	Map<String, Object> getMasScheme(Map<String, Object> dataMap);	
}
