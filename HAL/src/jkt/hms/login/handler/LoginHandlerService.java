package jkt.hms.login.handler;

import java.util.List;
import java.util.Map;
import java.util.Set;

import jkt.hms.masters.business.MasCommand;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.Users;

public interface LoginHandlerService {

	// Methods by Ritu

	@SuppressWarnings("unchecked")
	//List getHospitalName(String loginName, String password);
	Map<String, Object> getHospitalName(String loginName, String password);
	
	List<Object> getExistingUser(String loginName, String password);

	List<Object> getNoticeMessage();

	// Set getApplication(Users user, int hospitalId);

	// End of Methods by Ritu

	@SuppressWarnings("unchecked")
	List getDepartmentList(Map map);

	Map<String, Object> getUserList(Map map);

	String getDepartmentName(int deptId);

	// method written by vikas

	Set getApplications(Users user, int hospitalId,int groupId);

	String getDepartmentTypeCode(int deptId);

	boolean addingNew();
	public Map<String, Object> getGroupName(String loginName);

	List<MasCommand> showLoginJsp();

	String getLoginHospitalName(int hospitalId);

	Map<String, Object> getDepartmentDetails(Map<String, Object> mapHospData);

	List<MasEmployee> getEmployeeDetails(Map<String, Object> empMap);

	Map<String, Object> getPassword(String loginName);

}