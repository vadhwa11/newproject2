/**  
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * Class LoginHandlerServiceImpl.java 
 * Purpose of the class - This is for Login. 
 * Tables Used: mas_hospital, mas_application, users 
 * @author  Create Date: July 2007  Name: Ritu Sahu 
 * Revision Date:      		Revision By: 
 * @version 1.0  
 **/

package jkt.hms.login.handler;

import java.util.List;
import java.util.Map;
import java.util.Set;

import jkt.hms.login.dataservice.LoginDataService;
import jkt.hms.masters.business.MasCommand;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.Users;

public class LoginHandlerServiceImpl implements LoginHandlerService {

	private LoginDataService loginDataService = null;

	// Methods by Ritu

	@SuppressWarnings("unchecked")
	/*public List getHospitalName(String loginName, String password) {
		return loginDataService.getHospitalName(loginName, password);
	}*/
	public Map<String, Object> getHospitalName(String loginName, String password) {
		return loginDataService.getHospitalName(loginName, password);
	}
	
	public Map<String, Object> getPassword(String loginName) {
		return loginDataService.getPassword(loginName);
	}
	
	public List<Object> getExistingUser(String loginName, String password) {
		return loginDataService.getExistingUser(loginName, password);
	}

	public List<Object> getNoticeMessage() {
		return loginDataService.getNoticeMessage();
	}

	/*
	 * @SuppressWarnings("unchecked") public Set getApplication(Users user, int
	 * hospitalId) { return loginDataService.getApplication(user, hospitalId); }
	 */
	// End of Methods by Ritu

	// method by vikas

	public List getDepartmentList(Map map) {
		return loginDataService.getDepartmentList(map);
	}

	public LoginDataService getLoginDataService() {
		return loginDataService;
	}

	public void setLoginDataService(LoginDataService loginDataService) {
		this.loginDataService = loginDataService;
	}

	public String getDepartmentName(int deptId) {
		// TODO Auto-generated method stub
		return loginDataService.getDepartmentName(deptId);
	}

	public Set getApplications(Users user, int hospitalId,int groupId) {
		// TODO Auto-generated method stub
		return loginDataService.getApplications(user, hospitalId,groupId);
	}

	public String getDepartmentTypeCode(int deptId) {
		// TODO Auto-generated method stub
		return loginDataService.getDepartmentTypeCode(deptId);
	}

	public Map<String, Object> getUserList(Map map) {
		// TODO Auto-generated method stub
		return loginDataService.getUserList(map);
	}

	public boolean addingNew() {
		// TODO Auto-generated method stub
		return loginDataService.addingNew();
	}

	public Map<String, Object> getGroupName(String loginName) {
		return loginDataService.getGroupName(loginName);
	}

	@Override
	public List<MasCommand> showLoginJsp() {
		return loginDataService.showLoginJsp();
	}

	@Override
	public String getLoginHospitalName(int hospitalId) {
		return loginDataService.getLoginHospitalName(hospitalId);
	}

	@Override
	public Map<String, Object> getDepartmentDetails(
			Map<String, Object> mapHospData) {
		return loginDataService.getDepartmentDetails(mapHospData);
	}

	@Override
	public List<MasEmployee> getEmployeeDetails(Map<String, Object> empMap) {
		// TODO Auto-generated method stub
		return loginDataService.getEmployeeDetails(empMap) ;
	}


}