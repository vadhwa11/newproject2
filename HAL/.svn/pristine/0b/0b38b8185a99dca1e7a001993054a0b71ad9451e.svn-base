package jkt.hms.masters.handler;

import java.util.Map;


import jkt.hms.masters.business.MasBlock;

import jkt.hms.masters.business.MasMaritalStatus;

import jkt.hms.masters.business.MasDepartment;

import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasEmpCategory;
import jkt.hms.masters.business.MasEmpStatus;

import jkt.hms.masters.business.MasHospital;

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

import jkt.hms.masters.dataservice.MastersDataService;
import jkt.hms.util.Box;

public class MastersHandlerServiceImpl implements MastersHandlerService {
	MastersDataService mastersDataService = null;

	public MastersDataService getMastersDataService() {
		return mastersDataService;
	}

	public void setMastersDataService(MastersDataService mastersDataService) {
		this.mastersDataService = mastersDataService;
	}

	@Override
	public Map<String, Object> showHospitalJsp() {
		
		return mastersDataService.showHospitalJsp();
	}

	@Override
	public boolean addHospital(MasHospital masHospital,Map<String, Object> generalMap) {
		
		return mastersDataService.addHospital(masHospital,generalMap);
	}

	@Override
	public boolean deleteHospital(int storeId, Map<String, Object> generalMap) {
		
		return mastersDataService.deleteHospital(storeId, generalMap);
	}

	@Override
	public boolean editHospitalToDatabase(Map<String, Object> generalMap) {
		
		return mastersDataService.editHospitalToDatabase(generalMap);
	}

	@Override
	public Map<String, Object> checkForExistingMasters(Map<String, Object> generalMap) {
		
		return mastersDataService.checkForExistingMasters(generalMap);
	}

	@Override
	public Map<String, Object> searchHospital(String hospitalCode,String hospitalName) {
		
		return mastersDataService.searchHospital(hospitalCode,hospitalName);
	}

	@Override
	public boolean addDepartment(MasDepartment masDepartment) {
	
		return mastersDataService.addDepartment(masDepartment);
	}

	@Override
	public boolean deleteDepartment(int departmentId,Map<String, Object> generalMap) {
	
		return mastersDataService.deleteDepartment(departmentId,generalMap);
	}

	@Override
	public boolean editDepartmentToDatabase(Map<String, Object> generalMap) {
		
		return mastersDataService.editDepartmentToDatabase(generalMap);
	}

	@Override
	public Map<String, Object> searchDepartment(String departmentCode,String departmentName) {
		
		return mastersDataService.searchDepartment(departmentCode,departmentName);
	}

	@Override
	public Map showDepartmentJsp() {
	
		return mastersDataService.showDepartmentJsp();
	}

	@Override
	public boolean addRank(MasRank masRank) {
		
		return mastersDataService.addRank(masRank);
	}

	@Override
	public boolean deleteRank(int rankId, Map<String, Object> generalMap) {
	
		return mastersDataService.deleteRank(rankId,generalMap);
	}

	@Override
	public boolean editRankToDatabase(Map<String, Object> generalMap) {
		
		return mastersDataService.editRankToDatabase(generalMap);
	}

	@Override
	public Map<String, Object> searchRank(String rankCode, String rankName) {
		
		return mastersDataService.searchRank(rankCode, rankName);
	}

	@Override
	public Map<String, Object> showRankJsp() {
		
		return mastersDataService.showRankJsp();
	}

	@Override
	public boolean addRankCategory(MasRankCategory masRankCategory) {
		
		return mastersDataService.addRankCategory(masRankCategory);
	}

	@Override
	public boolean deleteRankCategory(int rankCategoryId, Map<String, Object> generalMap) {
		
		return mastersDataService.deleteRankCategory(rankCategoryId,generalMap);
	}

	@Override
	public boolean editRankCategoryToDatabase(Map<String, Object> generalMap) {
		
		return mastersDataService.editRankCategoryToDatabase(generalMap);
	}

	@Override
	public Map<String, Object> searchRankCategory(String rankCategoryCode,String rankCategoryName) {
		
		return mastersDataService.searchRankCategory(rankCategoryCode,rankCategoryName);
	}

	@Override
	public Map<String, Object> showRankCategoryJsp() {
		
		return mastersDataService.showRankCategoryJsp();
	}

	@Override
	public boolean addUnit(MasUnit masUnit) {
	
		return mastersDataService.addUnit(masUnit);
	}

	@Override
	public boolean deleteUnit(int unitId, Map<String, Object> generalMap) {
		
		return mastersDataService.deleteUnit(unitId,generalMap);
	}

	@Override
	public boolean editUnitToDatabase(Map<String, Object> generalMap) {
	
		return mastersDataService.editUnitToDatabase(generalMap);
	}

	@Override
	public Map<String, Object> searchUnit(String unitName) {
		
		return mastersDataService.searchUnit(unitName);
	}

	@Override
	public Map<String, Object> showUnitJsp() {
	
		return mastersDataService.showUnitJsp();
	}

	@Override
	public boolean addServiceType(MasServiceType masServiceType) {
		
		return mastersDataService.addServiceType(masServiceType);
	}

	@Override
	public boolean deleteServiceType(int serviceTypeId,
			Map<String, Object> generalMap) {
		
		return mastersDataService.deleteServiceType(serviceTypeId,generalMap);
	}

	@Override
	public boolean editServiceTypeToDatabase(Map<String, Object> generalMap) {
		
		return mastersDataService.editServiceTypeToDatabase(generalMap);
	}

	@Override
	public Map<String, Object> searchServiceType(String serviceTypeCode,
			String serviceTypeName) {
		
		return mastersDataService.searchServiceType(serviceTypeCode,serviceTypeName);
	}

	@Override
	public Map showServiceTypeJsp() {
		
		return mastersDataService.showServiceTypeJsp();
	}

	@Override
	public boolean addServiceStatus(MasServiceStatus masServiceStatus) {
	
		return mastersDataService.addServiceStatus(masServiceStatus);
	}

	@Override
	public boolean deleteServiceStatus(int serviceStatusId,Map<String, Object> generalMap) {
		
		return mastersDataService.deleteServiceStatus(serviceStatusId,generalMap);
	}

	@Override
	public boolean editServiceStatusToDatabase(Map<String, Object> generalMap) {
		
		return mastersDataService.editServiceStatusToDatabase(generalMap);
	}

	@Override
	public Map<String, Object> searchServiceStatus(String serviceStatusCode,String serviceStatusName) {
		
		return mastersDataService.searchServiceStatus(serviceStatusCode,serviceStatusName);
	}

	@Override
	public Map showServiceStatusJsp() {
	
		return mastersDataService.showServiceStatusJsp();
	}

	@Override
	public Map showEmpCategoryJsp() {
		
		return mastersDataService.showEmpCategoryJsp();
	}

	@Override
	public boolean addEmpCategory(MasEmpCategory masEmpCategory) {
	
		return mastersDataService.addEmpCategory(masEmpCategory);
	}

	@Override
	public boolean deleteEmpCategory(int empcategoryId,Map<String, Object> generalMap) {
	
		return mastersDataService.deleteEmpCategory(empcategoryId,generalMap);
	}

	@Override
	public boolean editEmpCategoryToDatabase(Map<String, Object> generalMap) {
		
		return mastersDataService.editEmpCategoryToDatabase(generalMap);
	}

	@Override
	public Map<String, Object> searchEmpCategory(String empCategoryCode,String empCategoryName) {
	
		return mastersDataService.searchEmpCategory(empCategoryCode,empCategoryName);
	}

	/*@Override
	public boolean addDepot(MasDepot masDepot) {
	
		return mastersDataService.addDepot(masDepot);
	}*/

	@Override
	public Map showDepotJsp() {
		
		return mastersDataService.showDepotJsp();
	}

	@Override
	public boolean editDepotToDatabase(Map<String, Object> generalMap) {
		
		return mastersDataService.editDepotToDatabase(generalMap);
	}

	@Override
	public boolean deleteDepot(int depotId, Map<String, Object> generalMap) {
		
		return mastersDataService.deleteDepot(depotId,generalMap);
	}

	@Override
	public Map<String, Object> searchDepot(String depotCode, String depotName) {
		
		return mastersDataService.searchDepot(depotCode,depotName);
	}

	@Override
	public boolean addState(MasState masState) {
	
		return mastersDataService.addState(masState);
	}

	@Override
	public boolean deleteState(int stateId, Map<String, Object> generalMap) {
		
		return mastersDataService.deleteState(stateId,generalMap);
	}

	@Override
	public boolean editState(Map<String, Object> generalMap) {
		
		return mastersDataService.editState(generalMap);
	}

	@Override
	public Map<String, Object> searchState(String stateCode, String stateName) {
	
		return mastersDataService.searchState(stateCode,stateName);
	}

	@Override
	public Map<String, Object> showStateJsp() {
		
		return mastersDataService.showStateJsp();
	}

	@Override
	public boolean addDistrict(MasDistrict masDistrict) {
		
		return mastersDataService.addDistrict(masDistrict);
	}

	@Override
	public boolean deleteDistrict(int districtId, Map<String, Object> generalMap) {
		
		return mastersDataService.deleteDistrict(districtId,generalMap);
	}

	@Override
	public boolean editDistrict(Map<String, Object> generalMap) {
	
		return mastersDataService.editDistrict(generalMap);
	}

	@Override
	public Map<String, Object> searchDistrict(String districtCode,String districtName) {
		
		return mastersDataService.searchDistrict(districtCode,districtName);
	}

	@Override
	public Map<String, Object> showDistrict() {
		return mastersDataService.showDistrict();
	}
	//-------------------------- Start of Report Method By Mansi on 31 July 2013
	
	
	@Override
	public Map<String, Object> getConnection() {
		return mastersDataService.getConnection();
	}

	@Override
	public Map<String, Object> getHospitalName(Map<String, Object> mapForDs) {
		return mastersDataService.getHospitalName(mapForDs);
	}
	
//-------------------- ** Employee Status Master ** -------------------------------
	
	@Override
	public Map<String, Object> showEmpStatusJsp() {
		return mastersDataService.showEmpStatusJsp();
	}
	@Override
	public Map<String, Object> searchEmpStatus(String empStatusCode,
			String empStatusName) {
		return mastersDataService.searchEmpStatus(empStatusCode, empStatusName);
	}
	@Override
	public boolean editEmpStatusToDatabase(Map<String, Object> generalMap) {
		return mastersDataService.editEmpStatusToDatabase(generalMap);
	}

	@Override
	public boolean deleteEmpStatus(int empStatusId,
			Map<String, Object> generalMap) {
		return mastersDataService.deleteEmpStatus(empStatusId, generalMap);
	}

	@Override
	public boolean addEmpStatus(MasEmpStatus masEmpStatus) {
		return mastersDataService.addEmpStatus(masEmpStatus);
	}
	
	//------------------ ** Employee Master -------------------

	@Override
	public Map<String, Object> showEmployeeJsp(int storeId) {
		return mastersDataService.showEmployeeJsp(storeId);
	}
	@Override
	public Map<String, Object> searchEmployee(String serviceNo,
			String firstName, String lastName, int storeId) {
		return mastersDataService.searchEmployee(serviceNo, firstName, lastName, storeId);
	}
	@Override
	public boolean editEmployeeToDatabase(Map<String, Object> generalMap) {
		return mastersDataService.editEmployeeToDatabase(generalMap);
	}

	@Override
	public boolean deleteEmployee(int employeeId, Map<String, Object> generalMap) {
		return mastersDataService.deleteEmployee(employeeId, generalMap);
	}

	@Override
	public boolean addEmployee(Map<String, Object> userMap) {
		return mastersDataService.addEmployee(userMap);
	}
	//-------------------- ** Title Master ** -------------------------------
	
	@Override
	public Map<String, Object> showTitleJsp() {
		return mastersDataService.showTitleJsp();
	}
	@Override
	public Map<String, Object> searchTitle(String titleCode, String titleName) {
		return mastersDataService.searchTitle(titleCode, titleName);
	}
	@Override
	public boolean editTitleToDatabase(Map<String, Object> generalMap) {
		return mastersDataService.editTitleToDatabase(generalMap);
	}


	@Override
	public boolean deleteTitle(int titleId, Map<String, Object> generalMap) {
		return mastersDataService.deleteTitle(titleId, generalMap);
	}


	@Override
	public boolean addTitle(MasTitle masTitle) {
		return mastersDataService.addTitle(masTitle);
	}

	//-------------------- ** Trade Master ** -------------------------------

	@Override
	public Map<String, Object> showTradeJsp() {
		return mastersDataService.showTradeJsp();
	}
	
	@Override
	public Map<String, Object> searchTrade(String tradeCode, String tradeName) {
		return mastersDataService.searchTrade(tradeCode, tradeName);
	}
	@Override
	public boolean editTradeToDatabase(Map<String, Object> generalMap) {
		return mastersDataService.editTradeToDatabase(generalMap);
	}

	@Override
	public boolean deleteTrade(int tradeId, Map<String, Object> generalMap) {
		return mastersDataService.deleteTrade(tradeId, generalMap);
	}

	@Override
	public boolean addTrade(MasTrade masTrade) {
		return mastersDataService.addTrade(masTrade);
	}
	
	//-------------------------- End of Report Method By Mansi on 31 July 2013

	/**
	 * Methods By Ritu
	 */
	@Override
	public Map<String, Object> showDepotUnitJsp() {
		return mastersDataService.showDepotUnitJsp();
	}

	@Override
	public Map<String, Object> addDepotUnit(Box box) {
		return mastersDataService.addDepotUnit(box);
	}

	@Override
	public Map<String, Object> updateDepotUnit(Box box) {
		return mastersDataService.updateDepotUnit(box);
	}

	@Override
	public boolean deleteDepotUnit(Box box) {
		return mastersDataService.deleteDepotUnit(box);
	}

	@Override
	public Map<String, Object> searchDepotUnit(Box box) {
		return mastersDataService.searchDepotUnit(box);
	}
	
	
	/**
	 * End
	 */
	
	//--------------------------- NRS-------
	
	/*@Override
	public boolean addNrs(MasNrs masNrs) {
		
		return mastersDataService.addNrs(masNrs);
	}*/


	@Override
	public boolean deleteNrs(int nrsId, Map<String, Object> generalMap) {
		
		return mastersDataService.deleteNrs(nrsId, generalMap);
	}

	@Override
	public boolean editNrsToDatabase(Map<String, Object> generalMap) {
		
		return mastersDataService.editNrsToDatabase(generalMap);
	}

	@Override
	public Map<String, Object> searchNrs(String nrsCode, String nrsName) {
		
		return mastersDataService.searchNrs(nrsCode, nrsName);
	}

	@Override
	public Map<String, Object> showNrsJsp() {
		
		return mastersDataService.showNrsJsp();
	}

	//--------------------------- Traffic Destination -------
	
/*	@Override
	public boolean addTrafficDestination(
			MasTrafficDestination masTrafficDestination) {
		return mastersDataService.addTrafficDestination(masTrafficDestination);
		
	}*/

	@Override
	public boolean deleteTrafficDestination(int trafficDestinationId,
			Map<String, Object> generalMap) {
		return mastersDataService.deleteTrafficDestination(trafficDestinationId, generalMap);
		
	}

	@Override
	public boolean editTrafficDestinationToDatabase(
			Map<String, Object> generalMap) {
		return mastersDataService.editTrafficDestinationToDatabase(generalMap);
	}

	@Override
	public Map<String, Object> searchTrafficDestination(
			String trafficDestinationCode, String trafficDestinationName) {
		return mastersDataService.searchTrafficDestination(trafficDestinationCode, trafficDestinationName);
	}

	@Override
	public Map<String, Object> showTrafficDestinationJsp() {
		return mastersDataService.showTrafficDestinationJsp();
	}
	@Override
	public Map<String, Object> addNrsTrafficDestination(Box box) {
		return mastersDataService.addNrsTrafficDestination(box);
	}

	@Override
	public boolean deleteNrsTrafficDestination(Box box) {
		return mastersDataService.deleteNrsTrafficDestination(box);
	}

	
	@Override
	public Map<String, Object> showNrsTrafficDestinationJsp() {
		return mastersDataService.showNrsTrafficDestinationJsp();
	}

	@Override
	public Map<String, Object> updateNrsTrafficDestination(Box box) {
		return mastersDataService.updateNrsTrafficDestination(box);
	}


	@Override
	public Map<String, Object> searchNrsTrafficDestination(Box box) {
		return mastersDataService.searchNrsTrafficDestination(box);
	

	
	}
	/*@Override
	public boolean addAgencyType(MasExternalAgencyType masAgencyType) {
		// TODO Auto-generated method stub
		return mastersDataService.addAgencyType(masAgencyType);
	}*/


	@Override
	public boolean deleteAgencyType(int agencyTypeId,
			Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return mastersDataService.deleteAgencyType(agencyTypeId, generalMap);
	}

	@Override
	public boolean editAgencyTypeToDatabase(Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return mastersDataService.editAgencyTypeToDatabase(generalMap);
	}


	@Override
	public Map<String, Object> searchAgencyType(String agencyTypeCode,
			String agencyTypeName) {
		// TODO Auto-generated method stub
		return mastersDataService.searchAgencyType(agencyTypeCode, agencyTypeName);
	}

	@Override
	public Map<String, Object> showAgencyJsp() {
		// TODO Auto-generated method stub
		return mastersDataService.showAgencyJsp();
	}

	@Override
	public Map<String, Object> showAgencyTypeJsp() {
		// TODO Auto-generated method stub
		return mastersDataService.showAgencyTypeJsp();
	}

	@Override
	public boolean addAgency(MasStoreSupplier masAgency) {
		// TODO Auto-generated method stub
		return mastersDataService.addAgency(masAgency);
	}

	@Override
	public boolean deleteAgency(int agencyId, Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return mastersDataService.deleteAgency(agencyId, generalMap);
	}

	@Override
	public boolean editAgency(Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return mastersDataService.editAgency(generalMap);
	}

	@Override
	public Map<String, Object> searchAgency(String agencyCode, String agencyName) {
		// TODO Auto-generated method stub
		return mastersDataService.searchAgency(agencyCode, agencyName);
	}


	@Override
	public boolean deleteActivity(int activityId, Map<String, Object> generalMap) {
		return mastersDataService.deleteActivity(activityId, generalMap);
	}

	@Override
	public boolean deleteBudgetComponent(int budgetComponentId,
			Map<String, Object> generalMap) {
		return mastersDataService.deleteBudgetComponent(budgetComponentId, generalMap);
	}

	@Override
	public boolean editActivity(Map<String, Object> generalMap) {
		return mastersDataService.editActivity(generalMap);
	}

	@Override
	public boolean editBudgetComponentToDatabase(Map<String, Object> generalMap) {
		return mastersDataService.editBudgetComponentToDatabase(generalMap);
	}

	@Override
	public Map<String, Object> searchActivity(String activityCode,
			String activityName) {
		return mastersDataService.searchActivity(activityCode, activityName);
	}

	@Override
	public Map<String, Object> searchBudgetComponent(
			String budgetComponentCode, String budgetComponentName) {
		return mastersDataService.searchBudgetComponent(budgetComponentCode, budgetComponentName);
	}

	@Override
	public Map showActivityJsp() {
		return mastersDataService.showActivityJsp();
	}

	@Override
	public Map<String, Object> showBudgetComponentJsp() {
		return mastersDataService.showBudgetComponentJsp();
	}
	

	/*@Override
	public boolean addActivity(MasPromotionalActivity masActivity) {
		return mastersDataService.addActivity(masActivity);
	}

	@Override
	public boolean addBudgetComponent(MasBudgetComponent masBudgetComponent) {
		return mastersDataService.addBudgetComponent(masBudgetComponent);
	}*/

	

	@Override
	public boolean deleteGrower(int growerId, Map<String, Object> generalMap) {
		return mastersDataService.deleteGrower(growerId, generalMap);
	}

	@Override
	public boolean editGrower(Map<String, Object> generalMap) {
		return mastersDataService.editGrower(generalMap);
	}

	@Override
	public Map<String, Object> searchGrower(int growerCode, String growerName,int locationId) {
		return mastersDataService.searchGrower(growerCode, growerName,locationId);
	}

	@Override
	
	public Map showGrowerJsp(int locationId) {
		return mastersDataService.showGrowerJsp(locationId);
	}

	@Override
	public Map<String, Object> getDistrictList(Map<String, Object> dataMap) {
		return mastersDataService.getDistrictList(dataMap);
	}

	@Override
	public Map<String, Object> getTalukList(Map<String, Object> dataMap) {
		return mastersDataService.getTalukList(dataMap);
	}


	@Override
	public Map<String, Object> getVillageList(Map<String, Object> dataMap) {
		return mastersDataService.getVillageList(dataMap);
	}


	@Override
	public Map<String, Object> getGrowerDetail(Map<String, Object> dataMap) {
		return mastersDataService.getGrowerDetail(dataMap);
	}
	
	@Override
	public Map<String, Object> getGrowerLandDetail(Map<String, Object> dataMap) {
		return mastersDataService.getGrowerLandDetail(dataMap);
	}

	/*@Override
	public boolean addGrowerDetail(MasGrowerDetails masGrowerDetails) {
		return mastersDataService.addGrowerDetail(masGrowerDetails);
	}*/
		public boolean updateGrowerLandDetail(Map<String, Object> generalMap) {
		return mastersDataService.updateGrowerLandDetail(generalMap);
	}

	/*	@Override
		public boolean addGrower(MasGrower masGrower,
				Map<String, Object> generalMap) {
		
				return mastersDataService.addGrower(masGrower, generalMap);
			
		}*/

		@Override
		public Map<String, Object> displayPhoto(String code) {
			return mastersDataService.displayPhoto(code);
		}

		@Override
		public boolean addFinancialYearMaster(MasStoreFinancial hrMasFinancialYear) {
			return mastersDataService.addFinancialYearMaster(hrMasFinancialYear);
		}

		@Override
		public boolean deleteFinancialYearMaster(int financialYrId,Map<String, Object> generalMap) {
			return mastersDataService.deleteFinancialYearMaster(financialYrId, generalMap);
		}

		@Override
		public boolean editFinancialYearMaster(Map<String, Object> generalMap) {
			return mastersDataService.editFinancialYearMaster(generalMap);
		}

		@Override
		public Map<String, Object> searchFinancialYearMaster(String year,
				String financialYear) {
			return mastersDataService.searchFinancialYearMaster(year, financialYear);
		}

		@Override
		public Map<String, Object> showFinancialJsp() {
			return mastersDataService.showFinancialJsp();
		}

		
		
	/*	@Override
		public boolean addCaste(MasEmployeeCaste masCaste) {
			return mastersDataService.addCaste(masCaste);
		}

		@Override
		public boolean addSubCaste(MasEmployeeSubCaste masSubCaste) {
			return mastersDataService.addSubCaste(masSubCaste);
		}*/

		@Override
		public boolean deleteCaste(int casteId, Map<String, Object> generalMap) {
			return mastersDataService.deleteCaste(casteId, generalMap);
		}

		@Override
		public boolean deleteSubCaste(int subCasteId,
				Map<String, Object> generalMap) {
			return mastersDataService.deleteSubCaste(subCasteId, generalMap);
		}

		@Override
		public boolean editCasteToDatabase(Map<String, Object> generalMap) {
			return mastersDataService.editCasteToDatabase(generalMap);
		}

		@Override
		public boolean editSubCasteToDatabase(Map<String, Object> generalMap) {
			return mastersDataService.editSubCasteToDatabase(generalMap);
		}

		@Override
		public Map<String, Object> searchCaste(String casteCode,
				String casteName) {
			return mastersDataService.searchCaste(casteCode, casteName);
		}

		@Override
		public Map<String, Object> searchSubCaste(String subCasteCode,
				String subCasteName) {
			return mastersDataService.searchSubCaste(subCasteCode, subCasteName);
		}

		@Override
		public Map<String, Object> showCasteJsp() {
			return mastersDataService.showCasteJsp();
		}

		@Override
		public Map<String, Object> showSubCasteJsp() {
			return mastersDataService.showSubCasteJsp();
		}
		
		@Override
		public Map showCategoryJsp() {
			
			return mastersDataService.showCategoryJsp();
		}

		/*@Override
		public boolean addCategory(MasCategory masCategory) {
		
			return mastersDataService.addCategory(masCategory);
		}*/

		@Override
		public boolean deleteCategory(int categoryId,Map<String, Object> generalMap) {
		
			return mastersDataService.deleteCategory(categoryId,generalMap);
		}

		@Override
		public boolean editCategoryToDatabase(Map<String, Object> generalMap) {
			
			return mastersDataService.editCategoryToDatabase(generalMap);
		}

		@Override
		public Map<String, Object> searchCategory(String categoryCode,String categoryName) {
		
			return mastersDataService.searchCategory(categoryCode,categoryName);
		}

		/*@Override
		public boolean addAssetCategory(MasAssetCategory masAssetCategory) {
			return mastersDataService.addAssetCategory(masAssetCategory);
		}*/

		@Override
		public boolean deleteAssetCategory(int assetCategoryId,
				Map<String, Object> generalMap) {
			return mastersDataService.deleteAssetCategory(assetCategoryId, generalMap);
		}

		@Override
		public boolean editAssetCategory(Map<String, Object> generalMap) {
			return mastersDataService.editAssetCategory(generalMap);
		}

		@Override
		public Map<String, Object> searchAssetCategory(
				String assetCategoryCode, String assetCategoryName) {
			return mastersDataService.searchAssetCategory(assetCategoryCode, assetCategoryName);
		}

		@Override
		public Map showAssetCategoryJsp() {
			return mastersDataService.showAssetCategoryJsp();
		}

		@Override
		public Map showAssetDetailsJsp(int locationId) {
			return mastersDataService.showAssetDetailsJsp(locationId);
		}

		@Override
		public Map<String, Object> getAssetDetail(Map<String, Object> dataMap) {
			return mastersDataService.getAssetDetail(dataMap);
		}

	/*	@Override
		public boolean addAssetDetails(ProjAssetDetails proj,
				Map<String, Object> generalMap) {
			return mastersDataService.addAssetDetails(proj, generalMap);
		}*/

		@Override
		public Map<String, Object> checkForExistingAssetDetail(
				Map<String, Object> generalMap) {
			return mastersDataService.checkForExistingAssetDetail(generalMap);
		}

		@Override
		public boolean editAssetDetails(int assetDetailsId,Map<String, Object> generalMap) {
			return mastersDataService.editAssetDetails(assetDetailsId, generalMap);
		}
		@Override
		public Map<String, Object> checkForExistingAssetDetailId(
				Map<String, Object> generalMap) {
			return mastersDataService.checkForExistingAssetDetailId(generalMap);
		}

		@Override
		public Map<String, Object> checkForExistingMastersId(
				Map<String, Object> generalMap) {
			return mastersDataService.checkForExistingMastersId(generalMap);
		}

		@Override
		public Map<String, Object> getSupplierList(Map<String, Object> dataMap) {
			return mastersDataService.getSupplierList(dataMap);
		}

		@Override
		public Map showBlock() {
			// TODO Auto-generated method stub
			return mastersDataService.showBlock();
		}

	/*	@Override
		public boolean addBlock(MasBlock masBlock) {
			// TODO Auto-generated method stub
			return mastersDataService.addBlock(masBlock);
		}*/

		@Override
		public boolean editBlock(Map<String, Object> generalMap) {
			// TODO Auto-generated method stub
			return mastersDataService.editBlock(generalMap);
		}

		@Override
		public Map<String, Object> searchBlock(String blockCode,
				String blockName) {
			// TODO Auto-generated method stub
			return mastersDataService.searchBlock(blockCode, blockName);
		}

		@Override
		public boolean deleteBlock(int blockId, Map<String, Object> generalMap) {
			// TODO Auto-generated method stub
			return mastersDataService.deleteBlock(blockId, generalMap);
		}

		@Override
		public Map showVillage(Box box) {
			// TODO Auto-generated method stub
			return mastersDataService.showVillage(box);
		}

	/*	@Override
		public boolean addVillage(MasVillage masVillage) {
			// TODO Auto-generated method stub
			return mastersDataService.addVillage(masVillage);
		}*/

		@Override
		public boolean editVillage(Map<String, Object> generalMap) {
			// TODO Auto-generated method stub
			return mastersDataService.editVillage(generalMap);
		}

		@Override
		public Map<String, Object> searchVillage(String villageCode,
				String villageName,Box box) {
			// TODO Auto-generated method stub
			return mastersDataService.searchVillage(villageCode, villageName,box);
		}

		@Override
		public boolean deleteVillage(int villageId,
				Map<String, Object> generalMap) {
			// TODO Auto-generated method stub
			return mastersDataService.deleteVillage(villageId, generalMap);
		}

		@Override
		public Map<String, Object> getAssetCat(Map<String, Object> dataMap) {
			return mastersDataService.getAssetCat(dataMap);
		}

		@Override
		public Map<String, Object> searchAssetDetail(Box box) {
			return mastersDataService.searchAssetDetail(box);
		}

		@Override
		public Map<String, Object> getSurveyNo(Map<String, Object> dataMap) {
			return mastersDataService.getSurveyNo(dataMap);
		}

		@Override
		public Map<String, Object> openGrowerHistoryPopUp(Box box) {
			return mastersDataService.openGrowerHistoryPopUp(box);
		}

	

		@Override
		public Map<String, Object> showMaritalStatusJsp() {
			// TODO Auto-generated method stub
			return mastersDataService.showMaritalStatusJsp();
		}

		@Override
		public Map<String, Object> searchMaritalStatus(
				String maritalStatusCode, String maritalStatusName) {
			// TODO Auto-generated method stub
			return mastersDataService.searchMaritalStatus(maritalStatusCode, maritalStatusName);
		}



		@Override
		public boolean addMaritalStatus(MasMaritalStatus masMaritalStatus) {
			// TODO Auto-generated method stub
			return mastersDataService.addMaritalStatus(masMaritalStatus);
		}

		@Override
		public boolean editMaritalStatusToDatabase(
				Map<String, Object> generalMap) {
			// TODO Auto-generated method stub
			return mastersDataService.editMaritalStatusToDatabase(generalMap);
		}

		@Override
		public boolean deleteMaritalStatus(int maritalStatusId,
				Map<String, Object> generalMap) {
			// TODO Auto-generated method stub
			return mastersDataService.deleteMaritalStatus(maritalStatusId, generalMap);
		}

		@Override
		public Map<String, Object> showReligionJsp() {
			return mastersDataService.showReligionJsp();
		}

		@Override
		public Map<String, Object> searchReligion(String religionCode,
				String religionName) {
			return mastersDataService.searchReligion(religionCode,religionName);
		}

		@Override
		public boolean editReligionToDatabase(Map<String, Object> generalMap) {
			// TODO Auto-generated method stub
			return mastersDataService.editReligionToDatabase(generalMap);
		}

		@Override
		public boolean deleteReligion(int religionId,
				Map<String, Object> generalMap) {
			// TODO Auto-generated method stub
			return mastersDataService.deleteReligion(religionId,generalMap);
		}

		@Override
		public boolean addReligion(MasReligion masReligion) {
			// TODO Auto-generated method stub
			return mastersDataService.addReligion(masReligion);
		}

		@Override
		public Map<String, Object> showRelationJsp() {
			// TODO Auto-generated method stub
			return mastersDataService.showRelationJsp();
		}

		@Override
		public boolean addRelation(MasRelation masRelation) {
			// TODO Auto-generated method stub
			return mastersDataService.addReligion(masRelation);
		}

		@Override
		public Map<String, Object> searchRelation(String relationCode,
				String relationName) {
			// TODO Auto-generated method stub
			return mastersDataService.searchRelation(relationCode,relationName);
		}

		@Override
		public boolean editRelationToDatabase(Map<String, Object> generalMap) {
			// TODO Auto-generated method stub
			return mastersDataService.editRelationToDatabase(generalMap);
		}

		@Override
		public boolean deleteRelation(int relationId,
				Map<String, Object> generalMap) {
			// TODO Auto-generated method stub
			return mastersDataService.deleteRelation(relationId,generalMap);
		}


	/*	@Override
		public boolean addRsk(MasRsk masRsk) {
			return mastersDataService.addRsk(masRsk);
		}*/

		@Override
		public Map<String, Object> showRskJsp() {
			return mastersDataService.showRskJsp();
		}

		@Override
		public boolean editRskToDatabase(Map<String, Object> generalMap) {
			return mastersDataService.editRskToDatabase(generalMap);
		}

		@Override
		public Map<String, Object> searchRsk(String rskName) {
			return mastersDataService.searchRsk(rskName);
		}

		@Override
		public boolean deleteRsk(int rskId, Map<String, Object> generalMap) {
			return mastersDataService.deleteRsk(rskId, generalMap);
		}

		@Override
		public Map<String, Object> showUserLocationMappingJsp(Box box) {
			return mastersDataService.showUserLocationMappingJsp(box);
		}

		@Override
		public Map<String, Object> addUserLocationMapping(
				Map<String, Object> mapForDs) {
			return mastersDataService.addUserLocationMapping(mapForDs);
		}

		@Override
		public Map<String, Object> deleteUserLocationMapping(
				Map<String, Object> mapForDs) {
			return mastersDataService.deleteUserLocationMapping(mapForDs);
		}

		@Override
		public Map<String, Object> editUserLocationMapping(
				Map<String, Object> mapForDs) {
			return mastersDataService.editUserLocationMapping(mapForDs);
		}

		@Override
		public Map<String, Object> getUsersList(Map<String, Object> dataMap) {
			return mastersDataService.getUsersList(dataMap);
		}

		@Override
		public Map<String, Object> searchUserLocationMapping(int usersSearchId) {
			return mastersDataService.searchUserLocationMapping(usersSearchId);
		}

		@Override
		public Map<String, Object> getMasScheme(Map<String, Object> dataMap) {
			// TODO Auto-generated method stub
			return mastersDataService.getMasScheme(dataMap);
		}
		
	

}