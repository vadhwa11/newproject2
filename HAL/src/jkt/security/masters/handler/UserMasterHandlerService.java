package jkt.security.masters.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.AnswerFaq;
import jkt.hms.masters.business.Complain;
import jkt.hms.masters.business.EmpGroups;
import jkt.hms.masters.business.MasApplication;
import jkt.hms.masters.business.MasApplicationgroup;
import jkt.hms.masters.business.MasButtonForm;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasTemplate;
import jkt.hms.masters.business.QuestionFaq;
import jkt.hms.masters.business.UserApplications;
import jkt.hms.masters.business.UserGroups;
import jkt.hms.masters.business.UserTemplate;
import jkt.hms.masters.business.UserUsergroupHospital;
import jkt.hms.masters.business.UsergroupHospital;
import jkt.hms.masters.business.Users;
import jkt.hms.util.Box;

@SuppressWarnings("unchecked")
public interface UserMasterHandlerService {

	
	public List getHospitalList();

	public List getEmployeeList();

	public List getUserList();

	public List getLoginList(String loginName);

	public List getSelected(String loginName);

	public boolean updateUser(Users users);

	public List getGroupHospitalId(int groupId, int hospitalId);

	public boolean addUserHosp(UserUsergroupHospital userUsergroupHospital);

	public List checkExistOfUserHospMapping(int loginId, int groupHospitalId);

	public List getListWithUserId(int loginId);

	public List getUserGroupHospList();

	public List getUserName(int userId);

	public List getUserUserGroupHospList(int userId, int userUserGroupHospId);

	public boolean updateUserUsergroupHospital(
			UserUsergroupHospital userUsergroupHospital);

	public List getUserUserGroupHospListWithID(int userUserGroupHospId);

	public List getUserUserGroupHospListWithGHID(int id);

	Map<String, Object> getGroupHospitalIdFromUsergroupHospital(int groupId,
			int hospitalId);

	// ********************************************************************************************//
	// ************************************Start Modules of
	// Mansi******************************//
	// *******************************************************************************************//

	// ----------------------------- Users ----------------------------//

	public Map<String, Object> searchUser(String loginName, int hospitalId);

	public boolean addUser(Users users, Map<String, Object> map);

	public Map<String, Object> showUserJsp(int hosp);

	public boolean editUserToDatabase(Map<String, Object> generalMap);

	public boolean deleteUser(int userId, Map<String, Object> generalMap);

	// ------------------- User Group---------------

	public Map<String, Object> searchUserGroups(String userGroupsCode,
			String userGroupsName);

	public Map<String, Object> showUserGroupsJsp();

	public boolean addUserGroups(UserGroups masUserGroup);

	public boolean editUserGroupsToDatabase(Map<String, Object> generalMap);

	public boolean deleteUserGroups(int userGroupId, Map<String, Object> userMap);

	// ------------------- User Group Hospital ---------------

	public Map<String, Object> showUsergroupHospitalJsp();

	public boolean addUsergroupHospital(UsergroupHospital masUsergroupHospital);

	public boolean editUsergroupHospital(Map<String, Object> generalMap);

	public boolean deleteUsergroupHospital(int usergroupHospitalId,
			Map<String, Object> generalMap);

	public Map<String, Object> searchUsergroupHospital(String groupName,
			String hospitalName);

	public Map<String, Object> checkForExistingGroupHospital(
			Map<String, Object> generalMap);

	// ------------------- Hospital Master ---------------

	public Map<String, Object> searchHospital(String hospitalCode,
			String hospitalName);

	public Map<String, Object> showHospitalJsp();

	public boolean addHospital(Map<String, Object> dataForSaveMap);

	public boolean editHospitalToDatabase(Map<String, Object> generalMap);

	public boolean deleteHospital(int hospitalId, Map<String, Object> generalMap);

	// --------------------------- User Hospital Maintenance ---------------

	public Map<String, Object> showUserHospitalMaintenanceJsp(
			Map<String, Object> generalMap);

	public boolean addUserHospitalMaintenance(Map<String, Object> generalMap);

	public boolean editUserHospitalMaintenance(Map<String, Object> generalMap);

	public boolean deleteUserHospitalMaintenance(int userHospitalMaintenanceId,
			Map<String, Object> generalMap);

	public Map<String, Object> searchUserHospitalMaintenance(String userName);

	public List<Object> getUserGroupForHospital(int hospitalId);

	public Map<String, Object> checkForExistingHospital(
			Map<String, Object> generalMap);

	// ********************************************************************************************//
	// ************************************End Modules of
	// Mansi******************************//
	// *******************************************************************************************//

	// =================== start of modules by abha
	public List getApplicationList();

	public List getGroupList();

	public boolean addApplication(Map<String, Object> infoMap);

	Map checkForExistingApplication(int groupId, String applicationName);

	public Map<String, Object> getGroupList(Box box);

	Map<String, Object> getApplicationListByAutocomplete(
			Map<String, Object> dataMap);

	public Map<String, Object> searchApplication(String applicationId);

	public boolean updateApplication(Map<String, Object> map);

	public List getHospitallistList();

	public List getApplicationIdList();

	// ---------------- user department ------------
	public Map<String, Object> showUserDepartmentJsp();

	public boolean addUserDepartment(Map<String, Object> generalMap);

	public Map<String, Object> checkForExistingUserDepartment(
			Map<String, Object> generalMap);

	public Map<String, Object> searchUserDepartment(String userName,
			String departmentName);

	public boolean deleteUserDepartment(int userDepartmentId,
			Map<String, Object> generalMap);

	public boolean editUserDepartment(Map<String, Object> generalMap);

	// ADDED by kalyan
	public Map<String, Object> getEmpName(Map<String, Object> dataMap);

	public Map<String, Object> getSubParentApplication(Map<String, Object> map);

	// End kalyan
	public Map<String, Object> searchUserDepartment(Box box);

	public Map<String, Object> getApplication(Map<String, Object> map);

	public Map<String, Object> getUrl(Map<String, Object> map);

	public Map<String, Object> getParentApplication(Map<String, Object> map);

	// ===================== Methods Written by Vivek
	// =========================Start========================
	public Map<String, Object> getApplicationForAutoComplete(
			Map<String, Object> map);

	public Map showUserApplicationJsp();

	public Map<String, Object> searchUserApplication(String applicationName);

	public boolean addUserApplication(UserApplications userApplications);

	public boolean editUserApplication(Map<String, Object> generalMap);

	public boolean deleteUserApplication(int userApplicationId,
			Map<String, Object> generalMap);

	public Map<String, Object> showUserList();

	// ===================== Methods Written by Vivek
	// =========================End==========================
	// -----------------------methods for aading emp
	// groups----------------------------

	public Map<String, Object> showGroupsJsp();

	public boolean addEmpGroups(EmpGroups masUserGroup);

	public boolean editEmpGroupsToDatabase(Map<String, Object> generalMap);

	public boolean deleteEmpGroups(int empGroupId, Map<String, Object> userMap);

	public boolean addUser(Users users, String[] empGroupIdArray, Map generalMap);

	Map<String, Object> searchEmpGroups(String empGroupsCode,
			String empGroupsName);

	// -----------------------------end of methods for adding emp
	// groups----------------------

	// ==========================methods added by vikas for buton rights on
	// 29/04/09===================================================

	Map<String, Object> showButtonMasterJsp();

	boolean addButtonDetails(MasButtonForm masButtonForm);

	boolean editButtonDetails(Map<String, Object> generalMap);

	boolean deleteButtonDetails(int buttonId, Map<String, Object> generalMap);

	// ==========================methods End by vikas for button
	// rights========================================================

	Map<String, Object> getUerGroupDetails(Box box);

	public boolean addUser(Users users, String[] empGroupIdArray,
			String[] appGroupIdArray, Map generalMap, int hospitalId);

	// public boolean encryptAllUserPassword();

	public List<MasApplication> getModuleListForTemplate();

	public Map<String, Object> populateApplications(String parentId,
			String templateId);

	public Map<String, Object> showTemplateJsp();

	public boolean addTemplate(MasTemplate masTemplate);

	public boolean editTemplate(Map<String, Object> generalMap);

	public Map<String, Object> searchTemplate(String templateCode,
			String templateName);

	public boolean deleteTemplate(int templateId, Map<String, Object> generalMap);

	public List<MasTemplate> getTemplateList();

	public Map<String, Object> getGroupApplicationArray(String applicationId,
			int templateId);

	public boolean submitTemplateWiseApplication(Map<String, Object> map);

	public List<EmpGroups> getEmpGroupForTemplate();

	public Map<String, Object> getUserList(int empGroup);

	public Map<String, Object> getTemplateApplicationList(int templateId,
			int hospitalId);

	public boolean addUserWiseTemplate(Map<String, Object> dataMap);

	public List<UserTemplate> getUsersListFromUserTemplate(int templateId,
			int empGroupId);

	public boolean editUserWiseTemplate(Map<String, Object> dataMap);

	public Map<String, Object> checkUserListFromUserTemplate(int templateId,
			int userId);

	public Map<String, Object> getTemplateModuleList(String templateId);
	public List<MasButtonForm> getFormList();
	public Map<String, Object> getButtonList(String formName);
	public boolean addApplicationGroup(MasApplicationgroup masApplicationgroup);
	public boolean editAppGroup(Map<String, Object> generalMap);
	public boolean deleteApplicationGroup(int appGroupId, Map<String, Object> generalMap);
	public Map<String, Object> searchAppGroup(String appGroupCode,
			String appGroupName);
	public Map<String,Object> getParentList();
	public boolean submitParentAndGroup(Map<String, Object> map);
	public Map<String, Object> showAppGroup();
	
	public Map<String, Object> populateDepartment(String templateId);

	public boolean submitTemplateWiseDepartment(Map<String, Object> datamap);

	public Map getDepartmentTemplateList(int templateId, int hospitalId);
	//--merge by Dipali 1/jul/2010---
	public Map<String, Object> getAssignParentList(Map<String, Object> parameterMap);

	public Map<String, Object> showUserAssignedTemplet(
			Map<String, Object> mapDetails);

	public Map<String, Object> addUserWiseTemplateOnly(
			Map<String, Object> dataMap);

	public Map<String, Object> getTemplateAsPerEmpCatList(Map<String, Object> mapDetails);

	public Map removeTemplateApplicationList(
			Map<String, Object> removeTemplateMap);
	/**
     * @author Mukesh.narayan
     * This method is used for Load Service Person Details
     * @return map with Service Person Details
     * @date 25 july 2012 
     */
	public Map<String, Object> getServiceNoDetails(Box box);
	
	public Map<String, Object> getAdminDetailsForHospital(Box box);
	
	//---Methods for Complain by Kiran..

	public Map<String, Object> showComplainA(Map<String, Object> map);
	
	public boolean submitComplainA(Complain comp);
	
	public Map<String, Object> showComplainB(Map<String, Object> map);
	
	public Map<String, Object> showComplainC(Map<String, Object> map);
	
	public Map<String, Object> getComplainData(Box box);

	public boolean updateComplainA(Map<String, Object> map);

	public Map<String, Object> getComplainBData(Box box);
	
	public boolean updateComplainB(Map<String, Object> map);

	public Map<String, Object> getComplainCData(Box box);
	
	public boolean updateComplainC(Map<String, Object> map);

	public Map<String, Object> searchComplainA(Map<String, Object> map);
	
	public Map<String, Object> searchComplainB(Map<String, Object> map);
	
	public Map<String, Object> searchComplainC(Map<String, Object> map);
	
	//---Methods of Discussion Board by Kiran..
	
	public Map<String, Object> questionFaqJsp(Map<String, Object> map);
	
	public Map<String, Object> answerFaqJsp(Map<String, Object> map);
	
	public Map<String, Object> askQuestionJsp(Map<String, Object> map);
	
	public boolean submitAskQuestion(QuestionFaq q);
	
	public boolean submitPostAnswer(AnswerFaq a);
	
	public Map<String, Object> searchDiscussionBoard(Map<String, Object> map);

	public Map<String, Object> doResetPassword(Map<String, Object> dataMap);

	public Map<String, Object> getListOfPasswordReset(Box box);

	public Map<String, Object> submitResetDetails(Box box);
	
	public Map<String, Object> getDoctorRoasterDetails(Map<String, Object> map);
	
	public Map<String, Object> submitDoctorRoasterDetails(Map<String, Object> map);  
}
