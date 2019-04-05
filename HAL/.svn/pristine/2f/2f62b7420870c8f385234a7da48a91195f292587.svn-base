package jkt.security.masters.handler;

import java.util.ArrayList;
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
import jkt.hms.masters.dataservice.CommonMasterDataService;
import jkt.hms.util.Box;
import jkt.security.masters.dataservice.UserMasterDataService;

@SuppressWarnings("unchecked")
public class UserMasterHandlerServiceImpl implements UserMasterHandlerService {

	List employeeList = null;
	List hospitalList = null;
	List userList = null;
	UserMasterDataService userMasterDataService = null;
	CommonMasterDataService commonMasterDataService = null;
	Map map;

	
	public List getUserUserGroupHospListWithGHID(int id) {

		return userMasterDataService.getUserUserGroupHospListWithGHID(id);
	}

	public List getUserUserGroupHospListWithID(int userUserGroupHospId) {
		return userMasterDataService
				.getUserUserGroupHospListWithID(userUserGroupHospId);
	}

	public boolean updateUserUsergroupHospital(
			UserUsergroupHospital userUsergroupHospital) {

		return userMasterDataService
				.updateUserUsergroupHospital(userUsergroupHospital);
	}

	public List getUserUserGroupHospList(int userId, int userUserGroupHospId) {

		return userMasterDataService.getUserUserGroupHospList(userId,
				userUserGroupHospId);
	}

	public List getUserName(int userId) {

		return userMasterDataService.getUserName(userId);
	}

	public List getUserGroupHospList() {

		return userMasterDataService.getUserGroupHospList();
	}

	public List getListWithUserId(int loginId) {

		return userMasterDataService.getListWithUserId(loginId);
	}

	public List checkExistOfUserHospMapping(int loginId, int groupHospitalId) {

		return userMasterDataService.checkExistOfUserHospMapping(loginId,
				groupHospitalId);
	}

	public List getGroupHospitalId(int groupId, int hospitalId) {

		return userMasterDataService.getGroupHospitalId(groupId, hospitalId);
	}

	public List getLoginList(String loginName) {
		List loginList = new ArrayList();
		loginList = (List) userMasterDataService.getLoginList(loginName);
		return loginList;
	}

	public List getUserList() {

		return userMasterDataService.getUserList();
	}

	public List getSelected(String loginName) {

		return (List) userMasterDataService.getSelected(loginName);
	}

	public List getEmployeeList() {
		employeeList = (List) userMasterDataService.getEmployeeList();
		//System.out.println("employeeList   ka size " + employeeList.size());
		return employeeList;
	}

	public List getHospitalList() {
		hospitalList = (List) userMasterDataService.getHospitalList();

		return hospitalList;
	}

	public UserMasterDataService getUserMasterDataService() {
		return userMasterDataService;
	}

	public void setUserMasterDataService(
			UserMasterDataService userMasterDataService) {
		this.userMasterDataService = userMasterDataService;
	}

	public boolean updateUser(Users users) {

		return userMasterDataService.updateUser(users);
	}

	public boolean addUserHosp(UserUsergroupHospital userUsergroupHospital) {
		return userMasterDataService.addUserHosp(userUsergroupHospital);
	}

	// ********************************************************************************************//
	// ************************************Start Modules of
	// Mansi******************************//
	// *******************************************************************************************//

	// --------------------------------Users-------------------------------------

	public boolean addUser(Users users,Map<String, Object> map) {
		return userMasterDataService.addUser(users,map);
	}

	public Map<String, Object> searchUser(String loginName, int hospitalId) {
		return userMasterDataService.searchUser(loginName, hospitalId);
	}

	public Map<String, Object> showUserJsp(int hosp) {
		return userMasterDataService.showUserJsp(hosp);
	}

	public boolean deleteUser(int userId, Map<String, Object> generalMap) {
		return userMasterDataService.deleteUser(userId, generalMap);
	}

	public boolean editUserToDatabase(Map<String, Object> generalMap) {
		return userMasterDataService.editUserToDatabase(generalMap);
	}

	// ---------------------------------- User Group ------------------

	public boolean addUserGroups(UserGroups masUserGroup) {
		return userMasterDataService.addUserGroups(masUserGroup);
	}

	public boolean deleteUserGroups(int userGroupId, Map<String, Object> userMap) {
		return userMasterDataService.deleteUserGroups(userGroupId, userMap);
	}

	public boolean editUserGroupsToDatabase(Map<String, Object> generalMap) {
		return userMasterDataService.editUserGroupsToDatabase(generalMap);
	}

	public Map<String, Object> searchUserGroups(String userGroupsCode,
			String userGroupsName) {
		return userMasterDataService.searchUserGroups(userGroupsCode,
				userGroupsName);
	}

	public Map<String, Object> showUserGroupsJsp() {
		return userMasterDataService.showUserGroupsJsp();
	}

	// ---------------------------------- User Group Hospital ------------------

	public boolean addUsergroupHospital(UsergroupHospital masUsergroupHospital) {
		return userMasterDataService.addUsergroupHospital(masUsergroupHospital);
	}

	public boolean deleteUsergroupHospital(int usergroupHospitalId,
			Map<String, Object> generalMap) {
		return userMasterDataService.deleteUsergroupHospital(
				usergroupHospitalId, generalMap);
	}

	public boolean editUsergroupHospital(Map<String, Object> generalMap) {
		return userMasterDataService.editUsergroupHospital(generalMap);
	}

	public Map<String, Object> searchUsergroupHospital(String groupName,
			String hospitalName) {
		return userMasterDataService.searchUsergroupHospital(groupName,
				hospitalName);
	}

	public Map<String, Object> showUsergroupHospitalJsp() {
		return userMasterDataService.showUsergroupHospitalJsp();
	}

	public Map<String, Object> checkForExistingGroupHospital(
			Map<String, Object> generalMap) {
		return userMasterDataService.checkForExistingGroupHospital(generalMap);
	}

	// ------------------------------- Hospital Master
	// --------------------------------

	public boolean addHospital(Map<String, Object> dataForSaveMap) {
		return userMasterDataService.addHospital(dataForSaveMap);
	}

	public boolean deleteHospital(int hospitalId, Map<String, Object> generalMap) {
		return userMasterDataService.deleteHospital(hospitalId, generalMap);
	}

	public boolean editHospitalToDatabase(Map<String, Object> generalMap) {
		return userMasterDataService.editHospitalToDatabase(generalMap);
	}

	public Map<String, Object> searchHospital(String hospitalCode,
			String hospitalName) {
		return userMasterDataService.searchHospital(hospitalCode, hospitalName);
	}

	public Map<String, Object> showHospitalJsp() {
		return userMasterDataService.showHospitalJsp();
	}

	public List getApplicationList() {

		return userMasterDataService.getApplicationList();
	}

	public boolean addApplication(Map<String, Object> infoMap) {

		return userMasterDataService.addApplication(infoMap);
	}

	// --------------------------- User Hospital Maintenance ---------------

	public Map<String, Object> showUserHospitalMaintenanceJsp(
			Map<String, Object> generalMap) {
		return userMasterDataService.showUserHospitalMaintenanceJsp(generalMap);
	}

	public boolean addUserHospitalMaintenance(Map<String, Object> generalMap) {
		return userMasterDataService.addUserHospitalMaintenance(generalMap);
	}

	public boolean deleteUserHospitalMaintenance(int userHospitalMaintenanceId,
			Map<String, Object> generalMap) {
		return userMasterDataService.deleteUserHospitalMaintenance(
				userHospitalMaintenanceId, generalMap);
	}

	public boolean editUserHospitalMaintenance(Map<String, Object> generalMap) {
		return userMasterDataService.editUserHospitalMaintenance(generalMap);
	}

	public Map<String, Object> searchUserHospitalMaintenance(String userName) {
		return userMasterDataService.searchUserHospitalMaintenance(userName);
	}

	public List<Object> getUserGroupForHospital(int hospitalId) {
		return userMasterDataService.getUserGroupForHospital(hospitalId);
	}

	public Map<String, Object> getGroupHospitalIdFromUsergroupHospital(
			int groupId, int hospitalId) {
		return userMasterDataService.getGroupHospitalIdFromUsergroupHospital(
				groupId, hospitalId);
	}

	public Map<String, Object> checkForExistingHospital(
			Map<String, Object> generalMap) {
		return userMasterDataService.checkForExistingHospital(generalMap);
	}

	public List getGroupList() {
		// TODO Auto-generated method stub
		return userMasterDataService.getGroupList();
	}

	public Map checkForExistingApplication(int groupId, String applicationName) {
		// TODO Auto-generated method stub
		return userMasterDataService.checkForExistingApplication(groupId,
				applicationName);
	}

	public Map<String, Object> getGroupList(Box box) {
		// TODO Auto-generated method stub
		return userMasterDataService.getGroupList(box);
	}

	public Map<String, Object> getApplicationListByAutocomplete(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return userMasterDataService.getApplicationListByAutocomplete(dataMap);
	}

	public Map<String, Object> searchApplication(String applicationId) {
		// TODO Auto-generated method stub
		return userMasterDataService.searchApplication(applicationId);
	}

	public boolean updateApplication(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userMasterDataService.updateApplication(map);
	}

	public CommonMasterDataService getCommonMasterDataService() {
		return commonMasterDataService;
	}

	public void setCommonMasterDataService(
			CommonMasterDataService commonMasterDataService) {
		this.commonMasterDataService = commonMasterDataService;
	}

	public List getHospitallistList() {
		// TODO Auto-generated method stub
		return userMasterDataService.getHospitallistList();
	}

	public List getApplicationIdList() {
		// TODO Auto-generated method stub
		return userMasterDataService.getApplicationIdList();
	}

	public Map<String, Object> showUserDepartmentJsp() {
		// TODO Auto-generated method stub
		return userMasterDataService.showUserDepartmentJsp();
	}

	public boolean addUserDepartment(Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return userMasterDataService.addUserDepartment(generalMap);
	}

	public Map<String, Object> checkForExistingUserDepartment(
			Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return userMasterDataService.checkForExistingUserDepartment(generalMap);
	}

	public Map<String, Object> searchUserDepartment(String userName,
			String departmentName) {
		// TODO Auto-generated method stub
		return userMasterDataService.searchUserDepartment(userName,
				departmentName);
	}

	public boolean deleteUserDepartment(int userDepartmentId,
			Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return userMasterDataService.deleteUserDepartment(userDepartmentId,
				generalMap);
	}

	public boolean editUserDepartment(Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return userMasterDataService.editUserDepartment(generalMap);
	}

	public Map<String, Object> getEmpName(Map<String, Object> dataMap) {
		return userMasterDataService.getEmpName(dataMap);
	}

	public Map<String, Object> searchUserDepartment(Box box) {
		// TODO Auto-generated method stub
		return userMasterDataService.searchUserDepartment(box);
	}

	public Map<String, Object> getApplication(Map<String, Object> map) {
		return userMasterDataService.searchUserDepartment(map);
	}

	public Map<String, Object> getUrl(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userMasterDataService.getUrl(map);
	}

	public Map<String, Object> getParentApplication(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userMasterDataService.getParentApplication(map);
	}

	// ********************************************************************************************//
	// ************************************End Modules of
	// Mansi******************************//
	// *******************************************************************************************//

	// ===================== Methods Written by Vivek
	// =========================End==========================

	public Map<String, Object> getApplicationForAutoComplete(
			Map<String, Object> map) {
		return userMasterDataService.getApplicationForAutoComplete(map);
	}

	// ----------------User Application-------------------------
	public boolean addUserApplication(UserApplications userApplications) {
		return userMasterDataService.addUserApplication(userApplications);
	}

	public boolean deleteUserApplication(int userApplicationId,
			Map<String, Object> generalMap) {
		return userMasterDataService.deleteUserApplication(userApplicationId,
				generalMap);
	}

	public boolean editUserApplication(Map<String, Object> generalMap) {
		return userMasterDataService.editUserApplication(generalMap);
	}

	public Map<String, Object> searchUserApplication(String applicationName) {
		return userMasterDataService.searchUserApplication(applicationName);
	}

	public Map showUserApplicationJsp() {
		return userMasterDataService.showUserApplicationJsp();
	}

	// /////////// ADDED BY KALYAN FOR ADD FORMS///////////////
	public Map<String, Object> getSubParentApplication(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userMasterDataService.getSubParentApplication(map);
	}

	public Map<String, Object> showUserList() {
		// TODO Auto-generated method stub
		return userMasterDataService.showUserList();
	}

	// ===================== Methods Written by Vivek
	// =========================Start========================

	// ===============================mthods writen by vikas for emp
	// groups=======================================================

	public Map<String, Object> showGroupsJsp() {
		// TODO Auto-generated method stub
		return userMasterDataService.showGroupsJsp();
	}

	public boolean addEmpGroups(EmpGroups masUserGroup) {
		// TODO Auto-generated method stub
		return userMasterDataService.addEmpGroups(masUserGroup);
	}

	public Map<String, Object> searchEmpGroups(String empGroupsCode,
			String empGroupsName) {
		// TODO Auto-generated method stub
		return userMasterDataService.searchEmpGroups(empGroupsCode,
				empGroupsName);
	}

	public boolean editEmpGroupsToDatabase(Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return userMasterDataService.editEmpGroupsToDatabase(generalMap);
	}

	public boolean deleteEmpGroups(int empGroupId, Map<String, Object> userMap) {
		// TODO Auto-generated method stub
		return userMasterDataService.deleteEmpGroups(empGroupId, userMap);
	}

	public boolean addUser(Users users, String[] empGroupIdArray, Map generalMap) {
		// TODO Auto-generated method stub
		return userMasterDataService
				.addUser(users, empGroupIdArray, generalMap);
	}

	// ---------------------------end of methods for emp
	// groups-------------------------
	// ===============================mthods added by vikas
	// 29/04/09==================================
	public Map<String, Object> showButtonMasterJsp() {
		// TODO Auto-generated method stub
		return userMasterDataService.showButtonMasterJsp();
	}

	public boolean addButtonDetails(MasButtonForm masButtonForm) {
		// TODO Auto-generated method stub
		return userMasterDataService.addButtonDetails(masButtonForm);
	}

	public boolean editButtonDetails(Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return userMasterDataService.editButtonDetails(generalMap);
	}

	public boolean deleteButtonDetails(int buttonId,
			Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return userMasterDataService.deleteButtonDetails(buttonId, generalMap);
	}

	public Map<String, Object> getUerGroupDetails(Box box) {
		// TODO Auto-generated method stub
		return userMasterDataService.getUerGroupDetails(box);
	}

	public boolean addUser(Users users, String[] empGroupIdArray,
			String[] appGroupIdArray, Map generalMap, int hospitalId) {
		// TODO Auto-generated method stub
		return userMasterDataService.addUser(users, empGroupIdArray,
				appGroupIdArray, generalMap, hospitalId);
	}

	public List<MasApplication> getModuleListForTemplate() {
		return userMasterDataService.getModuleListForTemplate();
	}

	public Map<String, Object> populateApplications(String parentId,
			String templateId) {
		return userMasterDataService.populateApplications(parentId, templateId);
	}

	public Map<String, Object> showTemplateJsp() {
		return userMasterDataService.showTemplateJsp();
	}

	public boolean addTemplate(MasTemplate masTemplate) {
		return userMasterDataService.addTemplate(masTemplate);
	}

	public boolean editTemplate(Map<String, Object> generalMap) {
		return userMasterDataService.editTemplate(generalMap);
	}

	public Map<String, Object> searchTemplate(String templateCode,
			String templateName) {
		return userMasterDataService.searchTemplate(templateCode, templateName);
	}

	public boolean deleteTemplate(int templateId, Map<String, Object> generalMap) {
		return userMasterDataService.deleteTemplate(templateId, generalMap);
	}

	public List<MasTemplate> getTemplateList() {
		return userMasterDataService.getTemplateList();
	}

	public Map<String, Object> getGroupApplicationArray(String applicationId,
			int templateId) {
		return userMasterDataService.getGroupApplicationArray(applicationId,
				templateId);
	}

	public boolean submitTemplateWiseApplication(Map<String, Object> map) {
		return userMasterDataService.submitTemplateWiseApplication(map);
	}

	public List<EmpGroups> getEmpGroupForTemplate() {
		return userMasterDataService.getEmpGroupForTemplate();
	}

	public Map<String, Object> getUserList(int empGroup) {
		return userMasterDataService.getUserList(empGroup);
	}

	public Map<String, Object> getTemplateApplicationList(int templateId,
			int hospitalId) {
		return userMasterDataService.getTemplateApplicationList(templateId,
				hospitalId);
	}

	public boolean addUserWiseTemplate(Map<String, Object> dataMap) {

		return userMasterDataService.addUserWiseTemplate(dataMap);
	}

	public List<UserTemplate> getUsersListFromUserTemplate(int templateId,
			int empGroupId) {
		return userMasterDataService.getUsersListFromUserTemplate(templateId,
				empGroupId);
	}

	public boolean editUserWiseTemplate(Map<String, Object> dataMap) {
		return userMasterDataService.editUserWiseTemplate(dataMap);
	}

	public Map<String, Object> checkUserListFromUserTemplate(int templateId,
			int userId) {
		return userMasterDataService.checkUserListFromUserTemplate(templateId,
				userId);
	}

	public Map<String, Object> getTemplateModuleList(String templateId) {
		// TODO Auto-generated method stub
		return userMasterDataService.getTemplateModuleList(templateId);
	}

	public List<MasButtonForm> getFormList() {
		return userMasterDataService.getFormList();
	}

	public Map<String, Object> getButtonList(String formName) {
		return userMasterDataService.getButtonList(formName);
	}

	public boolean addApplicationGroup(MasApplicationgroup masApplicationgroup) {
		return userMasterDataService.addApplicationGroup(masApplicationgroup);
	}

	public boolean editAppGroup(Map<String, Object> generalMap) {
		return userMasterDataService.editAppGroup(generalMap);
	}

	public boolean deleteApplicationGroup(int appGroupId,
			Map<String, Object> generalMap) {
		return userMasterDataService.deleteApplicationGroup(appGroupId, generalMap);
	}

	public Map<String, Object> searchAppGroup(String appGroupCode,
			String appGroupName) {
		return userMasterDataService.searchAppGroup(appGroupCode, appGroupName);
	}

	public Map<String, Object> getParentList() {
		return userMasterDataService.getParentList();
	}

	public boolean submitParentAndGroup(Map<String, Object> map) {
		return userMasterDataService.submitParentAndGroup(map);
	}

	public Map<String, Object> showAppGroup() {
		return userMasterDataService.showAppGroup();
	}
public Map<String, Object> populateDepartment(String templateId) {
		
		return  userMasterDataService.populateDepartment(templateId);
	}

public boolean submitTemplateWiseDepartment(Map<String, Object> datamap) {
		
		return   userMasterDataService.submitTemplateWiseDepartment(datamap);
	}

public Map getDepartmentTemplateList(int templateId, int hospitalId) {
		
		return userMasterDataService.getDepartmentTemplateList(templateId,hospitalId);
	}
//--merge by Dipali 1/jul/2010---
public Map<String, Object> getAssignParentList(Map<String, Object> parameterMap) {
	return userMasterDataService.getAssignParentList(parameterMap);
}

@Override
public Map<String, Object> showUserAssignedTemplet(Map<String, Object> mapDetails) {
	return userMasterDataService.showUserAssignedTemplet(mapDetails);
}

@Override
public Map<String, Object> addUserWiseTemplateOnly(Map<String, Object> dataMap) {
	return userMasterDataService.addUserWiseTemplateOnly(dataMap);
}

@Override
public Map<String, Object> getTemplateAsPerEmpCatList(Map<String, Object> mapDetails) {
	return userMasterDataService.getTemplateAsPerEmpCatList(mapDetails);
}

@Override
public Map removeTemplateApplicationList(Map<String, Object> removeTemplateMap) {
	return userMasterDataService.removeTemplateApplicationList(removeTemplateMap);
}

@Override
public Map<String, Object> getServiceNoDetails(Box box) {
	return userMasterDataService.getServiceNoDetails(box);
}

@Override
public Map<String, Object> getAdminDetailsForHospital(Box box) {
	return userMasterDataService.getAdminDetailsForHospital(box);
}

	/*
	 * public boolean encryptAllUserPassword() { // TODO Auto-generated method
	 * stub return userMasterDataService.encryptAllUserPassword(); }
	 */

	// ====================================methods End by
	// vikas================================================


//---Methods of Complain by Kiran...

public Map<String, Object> showComplainA(Map<String, Object> map) {
	return userMasterDataService.showComplainA(map);
}

public boolean submitComplainA(Complain comp) {
	return userMasterDataService.submitComplainA(comp);
}

@Override
public Map<String, Object> showComplainB(Map<String, Object> map) {
	return userMasterDataService.showComplainB(map);
}

@Override
public Map<String, Object> showComplainC(Map<String, Object> map) {
	return userMasterDataService.showComplainC(map);
}

@Override
public Map<String, Object> searchComplainA(Map<String, Object> map) {
	return userMasterDataService.searchComplainA(map);
}

@Override
public Map<String, Object> getComplainData(Box box) {
	return userMasterDataService.getComplainData(box);
}

@Override
public boolean updateComplainA(Map<String, Object> map) {
	return userMasterDataService.updateComplainA(map);
}

@Override
public Map<String, Object> getComplainBData(Box box) {
	return userMasterDataService.getComplainBData(box);
}

@Override
public boolean updateComplainB(Map<String, Object> map) {
	return userMasterDataService.updateComplainB(map);
}

@Override
public Map<String, Object> getComplainCData(Box box) {
	return userMasterDataService.getComplainCData(box);
}
	
@Override
public boolean updateComplainC(Map<String, Object> map) {
		return userMasterDataService.updateComplainC(map);
}

@Override
public Map<String, Object> searchComplainB(Map<String, Object> map) {
	return userMasterDataService.searchComplainB(map);
}

@Override
public Map<String, Object> searchComplainC(Map<String, Object> map) {
	return userMasterDataService.searchComplainC(map);
}

//---Methods of Discussion Board by Kiran...

@Override
public Map<String, Object> questionFaqJsp(Map<String, Object> map) {
	return userMasterDataService.questionFaqJsp(map);
}

@Override
public Map<String, Object> answerFaqJsp(Map<String, Object> map) {
	return userMasterDataService.answerFaqJsp(map);
}

@Override
public Map<String, Object> askQuestionJsp(Map<String, Object> map) {
	return userMasterDataService.askQuestionJsp(map);
}

@Override
public boolean submitAskQuestion(QuestionFaq q) {
	return userMasterDataService.submitAskQuestion(q);
	
}

@Override
public boolean submitPostAnswer(AnswerFaq a) {
	return userMasterDataService.submitPostAnswer(a);
	
}

@Override
public Map<String, Object> searchDiscussionBoard(Map<String, Object> map) {
	return userMasterDataService.searchDiscussionBoard(map);
}
@Override
public Map<String, Object> getDoctorRoasterDetails(Map<String, Object> map) {
	return userMasterDataService.getDoctorRoasterDetails(map);
}
@Override
public Map<String, Object> submitDoctorRoasterDetails(Map<String, Object> map) {
	return userMasterDataService.submitDoctorRoasterDetails(map);
}

@Override
public Map<String, Object> doResetPassword(Map<String, Object> dataMap) {
	return userMasterDataService.doResetPassword(dataMap);
}

@Override
public Map<String, Object> getListOfPasswordReset(Box box) {
	return userMasterDataService.getListOfPasswordReset(box);
}

@Override
public Map<String, Object> submitResetDetails(Box box) {
	return userMasterDataService.submitResetDetails(box);
}


}
