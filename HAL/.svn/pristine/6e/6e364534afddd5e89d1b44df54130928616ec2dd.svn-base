package jkt.security.masters.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.GroupApplication;
import jkt.hms.masters.business.MasApplication;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.UserEmpGroup;
import jkt.hms.masters.business.UserUsergroupApplication;
import jkt.hms.masters.business.UserUsergroupHospital;
import jkt.hms.masters.business.UsergroupHospital;
import jkt.hms.masters.business.Users;
import jkt.hms.util.Box;
import jkt.security.masters.dataservice.SuperAdminMasterDataService;

public class SuperAdminMasterHandlerServiceImpl implements
		SuperAdminMasterHandlerService {

	SuperAdminMasterDataService superAdminMasterDataService = null;

	public Map<String, Object> searchHospital(String hospitalCode,
			String hospitalName) {
		return superAdminMasterDataService.searchHospital(hospitalCode,
				hospitalName);
	}

	public Map<String, Object> showHospitalMasterJsp() {
		return superAdminMasterDataService.showHospitalMasterJsp();
	}

	public boolean addHospital(MasHospital masHospital) {
		return superAdminMasterDataService.addHospital(masHospital);
	}

	public boolean deleteHospital(int hospitalId) {
		return superAdminMasterDataService.deleteHospital(hospitalId);
	}

	public boolean editHospitalToDatabase(Map<String, Object> generalMap) {
		return superAdminMasterDataService.editHospitalToDatabase(generalMap);
	}

	// ------------------------------------------------------------------------------
	public SuperAdminMasterDataService getSuperAdminMasterDataService() {
		return superAdminMasterDataService;
	}

	public void setSuperAdminMasterDataService(
			SuperAdminMasterDataService superAdminMasterDataService) {
		this.superAdminMasterDataService = superAdminMasterDataService;
	}

	public List<MasHospital> checkExistingHospitalForEdit(int hospitalId,
			String hospitalName) {
		// TODO Auto-generated method stub
		return superAdminMasterDataService.checkExistingHospitalForEdit(
				hospitalId, hospitalName);
	}

	public Map checkForExistingHospital(String hospitalCode, String hospitalName) {
		// TODO Auto-generated method stub
		return superAdminMasterDataService.checkForExistingHospital(
				hospitalCode, hospitalName);
	}

	public List<MasHospital> getHospitalMasterList(int hospitalId) {
		// TODO Auto-generated method stub
		return superAdminMasterDataService.getHospitalMasterList(hospitalId);
	}

	public List<MasHospital> getHospitalNameList(String hospitalCode,
			String hospitalName) {
		// TODO Auto-generated method stub
		return superAdminMasterDataService.getHospitalNameList(hospitalCode,
				hospitalName);
	}

	public List getTableRecords(Map<String, Object> mapForDs) {
		// TODO Auto-generated method stub
		return superAdminMasterDataService.getTableRecords(mapForDs);
	}

	public boolean updateHospital(MasHospital hospitalMaster) {
		// TODO Auto-generated method stub
		return superAdminMasterDataService.updateHospital(hospitalMaster);
	}

	public Map<String, Object> showModuleManagementJsp(Box box) {
		// TODO Auto-generated method stub
		return superAdminMasterDataService.showModuleManagementJsp(box);
	}

	public Map<String, Object> showUserManagementJsp(int userId) {
		// TODO Auto-generated method stub
		return superAdminMasterDataService.showUserManagementJsp(userId);
	}

	public Map<String, Object> getGroupList(int hospitalId) {
		// TODO Auto-generated method stub
		return superAdminMasterDataService.getGroupList(hospitalId);
	}

	public Map<String, Object> getApplicationGroupWise(int groupId) {
		// TODO Auto-generated method stub
		return superAdminMasterDataService.getApplicationGroupWise(groupId);
	}

	public Map<String, Object> getMasterApplicationList(int userId) {
		// TODO Auto-generated method stub
		return superAdminMasterDataService.getMasterApplicationList(userId);
	}

	public int getGroupIdFromGroupHospitalId(int groupHospitalId) {
		// TODO Auto-generated method stub
		return superAdminMasterDataService
				.getGroupIdFromGroupHospitalId(groupHospitalId);
	}

	public boolean submitUserWiseApplication(Map map) {
		// TODO Auto-generated method stub
		return superAdminMasterDataService.submitUserWiseApplication(map);
	}

	public Map<String, Object> getUserUsergroupApplicationList(int userId,
			int groupHospitalId,String parentAppId) {
		// TODO Auto-generated method stub
		return superAdminMasterDataService.getUserUsergroupApplicationList(
				userId, groupHospitalId,parentAppId);
	}

	public Map<String, Object> getDepartmentList() {
		// TODO Auto-generated method stub
		return superAdminMasterDataService.getDepartmentList();
	}

	// Added by kalyan
	public Map<String, Object> updateNewPassowd(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return superAdminMasterDataService.updateNewPassowd(dataMap);
	}

	public String getDepartmentTypeCode(int deptId) {
		return superAdminMasterDataService.getDepartmentTypeCode(deptId);
	}

	// ---------------------methods added by vikas for security -------------

	public Map<String, Object> getApplicationListForAutoComplete(Map mapForDS) {
		// TODO Auto-generated method stub
		return superAdminMasterDataService
				.getApplicationListForAutoComplete(mapForDS);
	}

	public List<GroupApplication> getGroupForApplication(String applicationId) {
		// TODO Auto-generated method stub
		return superAdminMasterDataService
				.getGroupForApplication(applicationId);
	}

	public Map<String, Object> getGroupApplicationArray(String applicationId) {
		// TODO Auto-generated method stub
		return superAdminMasterDataService
				.getGroupApplicationArray(applicationId);
	}

	public List<UsergroupHospital> getHospitalList(int groupId, int hospitalId) {
		// TODO Auto-generated method stub
		return superAdminMasterDataService.getHospitalList(groupId, hospitalId);
	}

	public List<UserEmpGroup> getAllUsersListFromUserEmpGroup(int hospitalId) {
		// TODO Auto-generated method stub
		return superAdminMasterDataService
				.getAllUsersListFromUserEmpGroup(hospitalId);
	}

	public List<UserUsergroupApplication> getUserListFromUserUGApp(
			int groupHospitalId, int groupAppId) {
		// TODO Auto-generated method stub
		return superAdminMasterDataService.getUserListFromUserUGApp(
				groupHospitalId, groupAppId);
	}

	public boolean addUserWiseApplication(Map dataMap) {
		// TODO Auto-generated method stub
		return superAdminMasterDataService.addUserWiseApplication(dataMap);
	}

	public Map<String, Object> getEmpGroupList() {
		// TODO Auto-generated method stub
		return superAdminMasterDataService.getEmpGroupList();
	}

	public List<UserEmpGroup> getUsersListFromUserEmpGroup(int empGroupId,
			int groupHospitalId) {
		// TODO Auto-generated method stub
		return superAdminMasterDataService.getUsersListFromUserEmpGroup(
				empGroupId, groupHospitalId);
	}

	// ----------------------methods added by vikas for
	// security-------------------

	// -----------------------methods added for Assign module-------------

	public Map<String, Object> showAssignModuleToEmpGroupJsp() {
		// TODO Auto-generated method stub
		return superAdminMasterDataService.showAssignModuleToEmpGroupJsp();
	}

	public Map<String, Object> populateEmpGroupAndAppGroupJsp(int hospitalId) {
		// TODO Auto-generated method stub
		return superAdminMasterDataService
				.populateEmpGroupAndAppGroupJsp(hospitalId);
	}

	public List<MasApplication> getApplicationList(int groupId) {
		// TODO Auto-generated method stub
		return superAdminMasterDataService.getApplicationList(groupId);
	}

	public List<UserUsergroupHospital> getUserListFromUserUserGroupHospitalForGroupHospitalId(
			int groupHospitalId) {
		// TODO Auto-generated method stub
		return superAdminMasterDataService
				.getUserListFromUserUserGroupHospitalForGroupHospitalId(groupHospitalId);
	}

	public List<UserEmpGroup> getUserListFromUserEmpGroup(int empGroupId) {
		// TODO Auto-generated method stub
		return superAdminMasterDataService
				.getUserListFromUserEmpGroup(empGroupId);
	}

	public boolean assignModuleToEmpGroup(Map dataMap) {
		// TODO Auto-generated method stub
		return superAdminMasterDataService.assignModuleToEmpGroup(dataMap);
	}

	public List<UserUsergroupApplication> getUserListFromUUGAppForGroupHospital(
			int groupHospitalId) {
		// TODO Auto-generated method stub
		return superAdminMasterDataService
				.getUserListFromUUGAppForGroupHospital(groupHospitalId);
	}

	// ----------------------End of methods for assign module-------------------

	public List<UserEmpGroup> getUserListFromUserEmpGroup(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return superAdminMasterDataService.getUserListFromUserEmpGroup(dataMap);
	}

	// ----------------------------method added by vikas on
	// 30/04/09-------------------

	public Map<String, Object> showAssignButtonRightsToEmpGroupJsp() {
		// TODO Auto-generated method stub
		return superAdminMasterDataService
				.showAssignButtonRightsToEmpGroupJsp();
	}

	public Map<String, Object> getButtonList(String formName) {
		// TODO Auto-generated method stub
		return superAdminMasterDataService.getButtonList(formName);
	}

	public boolean assignButtonRightsToEmpGroup(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return superAdminMasterDataService
				.assignButtonRightsToEmpGroup(dataMap);
	}

	public Map<String, Object> getEmpNameByLoginName(String loginName) {
		// TODO Auto-generated method stub
		return superAdminMasterDataService.getEmpNameByLoginName(loginName);
	}

	// ----------------------------method added by vikas on
	// 30/04/09-------------------

	// ------------methods added for removing button rights on
	// 12-06-09----------------
	public Map<String, Object> showRemoveButtonRights(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return superAdminMasterDataService.showRemoveButtonRights(dataMap);
	}

	public Map<String, Object> getButtonRightsAvailableList(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return superAdminMasterDataService
				.getButtonRightsAvailableList(dataMap);
	}

	public boolean removeButtonRights(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return superAdminMasterDataService.removeButtonRights(dataMap);
	}

	public Map<String, Object> viewUserRights(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return superAdminMasterDataService.viewUserRights(dataMap);
	}

	public boolean removeUserRights(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return superAdminMasterDataService.removeUserRights(dataMap);
	}

	public Map<String, Object> showOrderApplicationJsp() {
		// TODO Auto-generated method stub
		return superAdminMasterDataService.showOrderApplicationJsp();
	}

	public Map<String, Object> populateEmpGroup(int hospitalid) {
		// TODO Auto-generated method stub
		return superAdminMasterDataService.populateEmpGroup(hospitalid);
	}

	public boolean submitSwapApplication(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return superAdminMasterDataService.submitSwapApplication(dataMap);
	}

	public boolean addOrderInApplication() {
		// TODO Auto-generated method stub
		return superAdminMasterDataService.addOrderInApplication();
	}

	public List<UserUsergroupApplication> getUserApplicationList(int user,
			int group) {
		// TODO Auto-generated method stub
		return superAdminMasterDataService.getUserApplicationList(user, group);
	}

	public Map<String, Object> showSubMenuForOrdering(
			Map<String, Object> mapForDs) {
		return superAdminMasterDataService.showSubMenuForOrdering(mapForDs);
	}

	public Map<String, Object> getDepartmentUserList() {
		return superAdminMasterDataService.getDepartmentUserList();
	}

	public Map<String, Object> getConnectionForReport() {
		return superAdminMasterDataService.getConnectionForReport();
	}
}
