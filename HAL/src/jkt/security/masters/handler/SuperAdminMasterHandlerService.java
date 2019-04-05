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

public interface SuperAdminMasterHandlerService {

	Map<String, Object> showHospitalMasterJsp();

	Map<String, Object> searchHospital(String hospitalCode, String hospitalName);

	boolean addHospital(MasHospital masHospital);

	boolean editHospitalToDatabase(Map<String, Object> generalMap);

	boolean deleteHospital(int hospitalId);

	Map checkForExistingHospital(String hospitalCode, String hospitalName);

	List<MasHospital> getHospitalNameList(String hospitalCode,
			String hospitalName);

	List<MasHospital> getHospitalMasterList(int hospitalId);

	List<MasHospital> checkExistingHospitalForEdit(int hospitalId,
			String hospitalName);

	boolean updateHospital(MasHospital hospitalMaster);

	List getTableRecords(Map<String, Object> mapForDs);

	Map<String, Object> showModuleManagementJsp(Box box);

	Map<String, Object> showUserManagementJsp(int userId);

	Map<String, Object> getGroupList(int hospitalId);

	Map<String, Object> getApplicationGroupWise(int groupId);

	Map<String, Object> getMasterApplicationList(int userId);

	int getGroupIdFromGroupHospitalId(int groupHospitalId);

	boolean submitUserWiseApplication(Map map);

	Map<String, Object> getUserUsergroupApplicationList(int userId,
			int groupHospitalId, String parentAppId);

	Map<String, Object> getDepartmentList();

	// Added by kalyan

	Map<String, Object> updateNewPassowd(Map<String, Object> dataMap);

	String getDepartmentTypeCode(int deptId);

	// -------------------method added by vikas for security
	// module---------------

	Map<String, Object> getApplicationListForAutoComplete(Map mapForDS);

	List<GroupApplication> getGroupForApplication(String applicationId);

	List<UsergroupHospital> getHospitalList(int groupId, int hospitalId);

	List<UserEmpGroup> getAllUsersListFromUserEmpGroup(int hospitalId);

	List<UserUsergroupApplication> getUserListFromUserUGApp(
			int groupHospitalId, int groupAppId);

	boolean addUserWiseApplication(Map dataMap);

	Map<String, Object> getEmpGroupList();

	List<UserEmpGroup> getUsersListFromUserEmpGroup(int empGroupId,
			int groupHospitalId);

	Map<String, Object> getGroupApplicationArray(String applicationId);

	// -------------------End of method added by vikas for security
	// module---------------

	// -------------------methods added for assign module---------------

	Map<String, Object> showAssignModuleToEmpGroupJsp();

	Map<String, Object> populateEmpGroupAndAppGroupJsp(int hospitalId);

	List<MasApplication> getApplicationList(int groupId);

	List<UserUsergroupHospital> getUserListFromUserUserGroupHospitalForGroupHospitalId(
			int groupHospitalId);

	List<UserEmpGroup> getUserListFromUserEmpGroup(int empGroupId);

	boolean assignModuleToEmpGroup(Map dataMap);

	List<UserUsergroupApplication> getUserListFromUUGAppForGroupHospital(
			int groupHospitalId);

	// -------------------End of methods added for assign module---------------

	List<UserEmpGroup> getUserListFromUserEmpGroup(Map<String, Object> dataMap);

	// ------------------------method added by vikas on
	// 30/04/09----------------------

	Map<String, Object> showAssignButtonRightsToEmpGroupJsp();

	Map<String, Object> getButtonList(String formName);

	boolean assignButtonRightsToEmpGroup(Map<String, Object> dataMap);

	Map<String, Object> getEmpNameByLoginName(String loginName);

	// Added on 12-06-09 for removing button rights

	Map<String, Object> showRemoveButtonRights(Map<String, Object> dataMap);

	Map<String, Object> getButtonRightsAvailableList(Map<String, Object> dataMap);

	boolean removeButtonRights(Map<String, Object> dataMap);

	Map<String, Object> viewUserRights(Map<String, Object> dataMap);

	boolean removeUserRights(Map<String, Object> dataMap);

	Map<String, Object> showOrderApplicationJsp();

	Map<String, Object> populateEmpGroup(int hospitalid);

	boolean submitSwapApplication(Map<String, Object> dataMap);

	boolean addOrderInApplication();

	List<UserUsergroupApplication> getUserApplicationList(int user, int group);

	public Map<String, Object> showSubMenuForOrdering(
			Map<String, Object> mapForDs);
	Map<String, Object> getDepartmentUserList();
	public Map<String, Object> getConnectionForReport(); 
}
