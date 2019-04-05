package jkt.security.masters.dataservice;

import java.io.UnsupportedEncodingException;

import org.hibernate.SQLQuery;

import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;

import static jkt.hms.util.RequestConstants.DEPARTMENT_ID;
import jkt.hms.masters.business.AssignParentToApplicationgroup;
import jkt.hms.masters.business.DoctorRoaster;
import jkt.hms.masters.business.EmpGroups;
import jkt.hms.masters.business.GroupApplication;
import jkt.hms.masters.business.MasApplication;
import jkt.hms.masters.business.MasApplicationgroup;
import jkt.hms.masters.business.MasBed;
import jkt.hms.masters.business.MasBedStatus;
import jkt.hms.masters.business.MasButtonForm;
import jkt.hms.masters.business.MasCommand;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDivision;
import jkt.hms.masters.business.MasEmpCategory;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasEmployeeDepartment;
import jkt.hms.masters.business.MasFrequency;
import jkt.hms.masters.business.MasGrade;
import jkt.hms.masters.business.AnswerFaq;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasRoom;
import jkt.hms.masters.business.MasRoomType;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasSession;
import jkt.hms.masters.business.MasTemplate;
import jkt.hms.masters.business.MasTitle;
import jkt.hms.masters.business.MasTrade;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.QuestionFaq;
import jkt.hms.masters.business.StoreGrnM;
import jkt.hms.masters.business.StoreGrnT;
import jkt.hms.masters.business.StoreInternalIndentT;
import jkt.hms.masters.business.StoreInternalReturnM;
import jkt.hms.masters.business.StoreItemBatchStock;
import jkt.hms.masters.business.StorePoDetail;
import jkt.hms.masters.business.TemplateApplication;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.masters.business.UserApplications;
import jkt.hms.masters.business.UserButtonRights;
import jkt.hms.masters.business.UserDepartment;
import jkt.hms.masters.business.UserEmpGroup;
import jkt.hms.masters.business.UserGroups;
import jkt.hms.masters.business.Complain;
import jkt.hms.masters.business.UserTemplate;
import jkt.hms.masters.business.UserUsergroupApplication;
import jkt.hms.masters.business.UserUsergroupHospital;
import jkt.hms.masters.business.UsergroupHospital;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.Visit;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import securityenc.EncryptPwd;

public class UserMasterDataServiceImpl extends HibernateDaoSupport implements
		UserMasterDataService {

	@SuppressWarnings("unchecked")
	List employeeList = null;
	@SuppressWarnings("unchecked")
	List hospitalList = null;
	@SuppressWarnings("unchecked")
	List userList = null;
	boolean dataSaved = false;

	
	@SuppressWarnings("unchecked")
	public List getUserUserGroupHospListWithGHID(int id) {
		List list = new ArrayList();
		list = (List) getHibernateTemplate().find(
				"from jkt.hms.masters.business.UserUsergroupHospital as uugh where uugh.Id = '"
						+ id + "' ");
		return list;
	}

	@SuppressWarnings("unchecked")
	public List getUserUserGroupHospListWithID(int userUserGroupHospId) {
		List list = new ArrayList();
		list = (List) getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.UserUsergroupHospital as uugh where uugh.GroupHospitalId = '"
								+ userUserGroupHospId + "' ");
		return list;
	}

	public boolean updateUserUsergroupHospital(
			UserUsergroupHospital userUsergroupHospital) {
		try {
			getHibernateTemplate().update(userUsergroupHospital);
			dataSaved = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dataSaved;
	}

	@SuppressWarnings("unchecked")
	public List getUserUserGroupHospList(int userId, int userUserGroupHospId) {
		List list = new ArrayList();
		list = (List) getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.UserUsergroupHospital as uugh where uugh.GroupHospitalId = '"
								+ userUserGroupHospId
								+ "' and uugh.UserId = '"
								+ userId + "'");
		return list;
	}

	@SuppressWarnings("unchecked")
	public List getListWithUserId(int loginId) {
		List list = new ArrayList();
		try {
			list = (List) getHibernateTemplate().find(
					"from jkt.hms.masters.business.UserUsergroupHospital as uugh where "
							+ "uugh.UserId = '" + loginId + "'  ");

		} catch (Exception e) {
			//System.out.println("In Ds Exp" + e);
		}
		return list;
	}

	@SuppressWarnings( { "unused", "unchecked" })
	public List checkExistOfUserHospMapping(int loginId, int groupHospitalId) {
		List list = new ArrayList();
		return list = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.UserUsergroupHospital as uugh where uugh.UserId = '"
								+ loginId
								+ "' and  uugh.GroupHospitalId='"
								+ groupHospitalId + "'  ");
	}

	public boolean addUserHosp(UserUsergroupHospital userUsergroupHospital) {
		try {
			getHibernateTemplate().save(userUsergroupHospital);
			dataSaved = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dataSaved;
	}

	@SuppressWarnings("unchecked")
	public List getLoginList(String loginName) {

		List<Users> loginList = null;
		loginList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.Users as us where us.LoginName like '"
						+ loginName + "%'");
		return loginList;
	}

	@SuppressWarnings("unchecked")
	public List getSelected(String loginName) {
		List<Users> loginList = null;
		loginList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.Users as us where us.LoginName = '"
						+ loginName + "'");
		return loginList;
	}

	// ********************************************************************************************//
	// ************************************Start Modules of
	// Mansi******************************//
	// *******************************************************************************************//

	// ---------------------------------------------- Users
	// ------------------------//

	@SuppressWarnings("unchecked")
	/*
	 * public Map<String, Object> showUserJsp() { Map<String,Object> map=new
	 * HashMap<String,Object>(); List<Users> searchUserList = new
	 * ArrayList<Users>(); List<Users> userList = new ArrayList<Users>();
	 * List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	 * List<EmpGroups> empGroupList=new ArrayList<EmpGroups>();
	 * List<UserEmpGroup> userEmpGroupList= new ArrayList<UserEmpGroup>();
	 * searchUserList = getHibernateTemplate().find(
	 * "from jkt.hms.masters.business.Users "); userList =
	 * getHibernateTemplate().find(
	 * "from jkt.hms.masters.business.Users as mc where mc.Status = 'y'");
	 * employeeList = getHibernateTemplate().find(
	 * "from jkt.hms.masters.business.MasEmployee as mc where mc.Status = 'y'");
	 * empGroupList
	 * =getHibernateTemplate().find("from EmpGroups as eg where eg.Status='y'");
	 * userEmpGroupList
	 * =getHibernateTemplate().find("from UserEmpGroup as ueg where ueg.Status='y'"
	 * );
	 * ////System.out.println("Size of user emp group list====="+userEmpGroupList
	 * .size()); map.put("searchUserList",searchUserList);
	 * map.put("userList",userList); map.put("employeeList",employeeList);
	 * map.put("empGroupList", empGroupList); map.put("userEmpGroupList",
	 * userEmpGroupList); return map; }
	 */
	public Map<String, Object> showUserJsp(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Users> searchUserList = new ArrayList<Users>();
		List<Users> userList = new ArrayList<Users>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<EmpGroups> empGroupList = new ArrayList<EmpGroups>();
		List<UserEmpGroup> userEmpGroupList = new ArrayList<UserEmpGroup>();
//		List<UsergroupHospital> groupList = new ArrayList<UsergroupHospital>();
		List<Object[]> groupList = new ArrayList<Object[]>();
		Session session = (Session) getSession();
		List<UserUsergroupHospital> useruserGroupHospList = new ArrayList<UserUsergroupHospital>();
		searchUserList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.Users ");
		userList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.Users as mc where mc.Status = 'y'");
		/*employeeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasEmployee as mc where mc.Status = 'y'");*/
		empGroupList = getHibernateTemplate().find(
				"from EmpGroups as eg where eg.Status='y'");
		userEmpGroupList = getHibernateTemplate().find(
				"from UserEmpGroup as ueg where ueg.Status='y'");
		groupList = getHibernateTemplate()
				.find( "select mc.Group.Id,mc.Group.GroupName from jkt.hms.masters.business.UsergroupHospital as mc where mc.Status = 'y' and mc.Hospital.Id="
								+ hospitalId + " group by mc.Group.Id,mc.Group.GroupName");
		useruserGroupHospList = getHibernateTemplate().find(
				"from UserUsergroupHospital as u where u.Status = 'y'");
		
		List<MasTemplate> masTemplateList = new ArrayList<MasTemplate>();
		masTemplateList = session.createCriteria(MasTemplate.class).add(Restrictions.eq("Status","y").ignoreCase())
				//.add(Restrictions.eq("Hospital.Id", hospitalId))
				.addOrder(Order.asc("TemplateName")).list();
		map.put("masTemplateList", masTemplateList);
		map.put("searchUserList", searchUserList);
		map.put("userList", userList);
		map.put("groupList", groupList);
		map.put("employeeList", employeeList);
		map.put("empGroupList", empGroupList);
		map.put("userEmpGroupList", userEmpGroupList);
		map.put("useruserGroupHospList", useruserGroupHospList);
		return map;
	}
	public boolean deleteUser(int userId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		Users users = new Users();
		users = (Users) getHibernateTemplate().get(Users.class, userId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				users.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				users.setStatus("y");
				dataDeleted = false;
			}
		}
		users.setLastChgBy(changedBy);
		users.setLastChgDate(currentDate);
		users.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(users);
		return dataDeleted;
	}

	public boolean editUserToDatabase(Map<String, Object> generalMap) {
		Session session = (Session) getSession();
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String userName = "";
		@SuppressWarnings("unused")
		String loginName = "";
		int userId = 0;
		Transaction tx = null;
		int employeeId = 0;
		String password = "";
		String changedBy = "";
		String lastName="";
		String firstName="";
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			userId = (Integer) generalMap.get("id");
			loginName = (String) generalMap.get("loginName");
			userName = (String) generalMap.get("name");
			employeeId = (Integer) generalMap.get("employeeId");
			password = (String) generalMap.get("password");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			
			firstName= (String) generalMap.get("firstName");
			lastName= (String) generalMap.get("lastName");
			Users users = (Users) getHibernateTemplate().get(Users.class,
					userId);
			users.setId(userId);
			users.setUserName(userName);
			users.setFirstName(firstName);
			users.setLastName(lastName);
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(employeeId);
			users.setEmployee(masEmployee);
			users.setLoginName(userName);
			users.setPassword(HMSUtil.encryptPassword(password));
			users.setLastChgBy(changedBy);
			users.setLastChgDate(currentDate);
			users.setLastChgTime(currentTime);
			hbt.saveOrUpdate(users);
			
			
			

			tx.commit();
			dataUpdated = true;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public boolean addUser(Users users,Map<String, Object> map) {

		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		hbt.save(users);

		
		int hospitalId=0;
		if(map.get("hospitalId")!=null){
			hospitalId=(Integer)map.get("hospitalId");
		}
		List<Integer> templetIdList=new ArrayList<Integer>();
		if(map.get("templetIdList")!=null){
			templetIdList=(List<Integer>)map.get("templetIdList");
		}
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
		
		changedBy = (String) map.get("changedBy");
		currentDate = (Date) map.get("currentDate");
		if(templetIdList.size()>0){
			for(Integer templateId1:templetIdList){
				UserTemplate userTemplate = new UserTemplate();
		
				userTemplate.setUser(users);
				
				MasTemplate masTemplate = new MasTemplate();
				masTemplate.setId(templateId1);
				userTemplate.setTemplate(masTemplate);
				
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				userTemplate.setHospital(masHospital);
			
				userTemplate.setStatus("y");
				userTemplate.setLastChgBy(changedBy);
				userTemplate.setLastChgDate(currentDate);
				userTemplate.setLastChgTime(currentTime);
				hbt.save(userTemplate);
			}
		}
		successfullyAdded = true;
		return successfullyAdded;
		/*
		 * try{ org.springframework.orm.hibernate3.HibernateTemplate hbt =
		 * getHibernateTemplate(); hbt.setFlushModeName("FLUSH_AUTO");
		 * hbt.setCheckWriteOperations(false); hbt.save(users); dataSaved =
		 * true;
		 * 
		 * }catch (Exception e) { e.printStackTrace(); }
		 * 
		 * return dataSaved;
		 */}

	@SuppressWarnings("unchecked")
	public List getUserList() {

		userList = new ArrayList();
		try {
			userList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.Users");
		} catch (Exception e) {
e.printStackTrace();		}
		return userList;
	}

	@SuppressWarnings("unchecked")
	public List getEmployeeList() {
		employeeList = new ArrayList();

		try {
			employeeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasEmployee");
		} catch (Exception e) {
e.printStackTrace();		}

		return employeeList;
	}

	@SuppressWarnings("unchecked")
	public List getHospitalList() {
		List hospitalList = new ArrayList();
		try {

			hospitalList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasHospital");
		} catch (Exception e) {
e.printStackTrace();		}
		return hospitalList;
	}

	public boolean updateUser(Users users) {

		try {

			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			/*
			 * int id=users.getId();
			 * 
			 * Users user = new Users(); user = (Users) hbt.load(Users.class,
			 * id); user.setLoginName(users.getLoginName());
			 * user.setUserName(users.getUserName());
			 * user.setEmployeeCode(users.getEmployeeCode());
			 * user.setPassword(users.getPassword());
			 * user.setStatus(users.getStatus());
			 * user.setLastChgBy(users.getLastChgBy());
			 * user.setLastChgDate(users.getLastChgDate());
			 * user.setLastChgTime(users.getLastChgTime());
			 */
			hbt.update(users);
			dataSaved = true;

		} catch (Exception e) {
			e.printStackTrace();
			dataSaved = false;
		}

		return dataSaved;
	}

	@SuppressWarnings("unchecked")
	public List getGroupHospitalId(int groupId, int hospitalId) {
		List list = new ArrayList();
		try {

			list = (List) getHibernateTemplate().find(
					"from jkt.hms.masters.business.UsergroupHospital as ugh where ugh.GroupId = '"
							+ groupId + "' and ugh.HospitalId = '" + hospitalId
							+ "' ");
		} catch (Exception e) {
e.printStackTrace();		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List getUserGroupHospList() {
		return getHibernateTemplate().find(
				"from jkt.hms.masters.business.UsergroupHospital ");
	}

	@SuppressWarnings("unchecked")
	public List getUserName(int userId) {
		List list = new ArrayList();
		list = (List) getHibernateTemplate().find(
				"from jkt.hms.masters.business.Users as users where users.Id = '"
						+ userId + "'");
		return list;
	}

	// ---------------------------------------User Groups
	// -------------------------

	public boolean addUserGroups(UserGroups masUserGroups) {

		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masUserGroups);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unused")
	public boolean editUserGroupsToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String userGroupsName = "";
		@SuppressWarnings("unused")
		String userGroupsCode = "";
		int userGroupsId = 0;
		String changedBy = "";
		try {
			userGroupsId = (Integer) generalMap.get("id");
			userGroupsCode = (String) generalMap.get("userGroupsCode");
			userGroupsName = (String) generalMap.get("name");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
		} catch (Exception e) {
e.printStackTrace();		}

		UserGroups masUserGroups = (UserGroups) getHibernateTemplate().get(
				UserGroups.class, userGroupsId);

		masUserGroups.setId(userGroupsId);
		masUserGroups.setGroupName(userGroupsName);
		/*
		 * masUserGroups.setLastChgBy(changedBy);
		 * masUserGroups.setLastChgDate(currentDate);
		 * masUserGroups.setLastChgTime(currentTime);
		 */
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(masUserGroups);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchUserGroups(String userGroupsCode,
			String userGroupsName) {
		List<UserGroups> searchUserGroupsList = new ArrayList<UserGroups>();
		Map<String, Object> userGroupsFieldsMap = new HashMap<String, Object>();
		try {
			if ((userGroupsName != null) || (userGroupsCode == null)) {

				searchUserGroupsList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.UserGroups imc where imc.GroupName like '"
								+ userGroupsName + "%' order by imc.GroupName");
			} else {
				searchUserGroupsList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.UserGroups imc where imc.Code like '"
								+ userGroupsCode + "%' order by imc.Code");
			}
		} catch (Exception e) {
e.printStackTrace();		}
		userGroupsFieldsMap.put("searchUserGroupsList", searchUserGroupsList);
		return userGroupsFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showUserGroupsJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<UserGroups> searchUserGroupsList = new ArrayList<UserGroups>();
		searchUserGroupsList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.UserGroups ");
		map.put("searchUserGroupsList", searchUserGroupsList);
		return map;
	}

	@SuppressWarnings("unused")
	public boolean deleteUserGroups(int userGroupsId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		UserGroups masUserGroups = new UserGroups();
		masUserGroups = (UserGroups) getHibernateTemplate().get(
				UserGroups.class, userGroupsId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masUserGroups.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masUserGroups.setStatus("y");
				dataDeleted = false;
			}
		}
		masUserGroups.setLastChgBy(changedBy);
		masUserGroups.setLastChgDate(currentDate);
		masUserGroups.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(masUserGroups);
		return dataDeleted;
	}

	// ----------------------------------User Group
	// Hospital--------------------------------------

	public boolean addUsergroupHospital(UsergroupHospital masUsergroupHospital) {

		boolean successfullyAdded = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(masUsergroupHospital);
			List<UserGroups> userGroupsList = new ArrayList<UserGroups>();
			userGroupsList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.UserGroups as mc where mc.Status = 'y'");
			//System.out.println("userGroupsList.size()--->"+userGroupsList.size());
			/*if(userGroupsList.size()>0){
				for (UserGroups userGroups : userGroupsList) {
					UsergroupHospital masUsergroupHospital = new UsergroupHospital();
					
					UserGroups masUserGroups = new UserGroups();
					masUserGroups.setId(userGroups.getId());
					masUsergroupHospital.setGroup(masUserGroups);
					
					MasHospital masHospital = new MasHospital();
					masHospital.setId(hospitalId);
					masUsergroupHospital.setHospital(masHospital);

					masUsergroupHospital.setStatus("y");
					masUsergroupHospital.setLastChgBy(changedBy);
					masUsergroupHospital.setLastChgDate(currentDate);
					masUsergroupHospital.setLastChgTime(currentTime);
					
				}
			}
	*/		successfullyAdded = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return successfullyAdded;
	}

	@SuppressWarnings( { "unused", "unchecked" })
	public boolean deleteUsergroupHospital(int usergroupHospitalId,
			Map<String, Object> generalMap) {

		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		UsergroupHospital masUsergroupHospital = new UsergroupHospital();
		masUsergroupHospital = (UsergroupHospital) getHibernateTemplate().get(
				UsergroupHospital.class, usergroupHospitalId);
		@SuppressWarnings("unused")
		Integer userGroupsId = masUsergroupHospital.getGroup().getId();
		Integer hospitalId = masUsergroupHospital.getHospital().getId();
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			List userGroupsList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.UserGroups as isc where isc.Id='"
							+ usergroupHospitalId + "' and isc.Status='y'");
			@SuppressWarnings("unused")
			List hospitalList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasHospital as isc where isc.Id='"
							+ usergroupHospitalId + "' and isc.Status='y'");
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masUsergroupHospital.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masUsergroupHospital.setStatus("y");
				dataDeleted = false;
			}
		}
		masUsergroupHospital.setLastChgBy(changedBy);
		masUsergroupHospital.setLastChgDate(currentDate);
		masUsergroupHospital.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masUsergroupHospital);
		return dataDeleted;
	}

	public boolean editUsergroupHospital(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		int usergroupHospitalId = 0;
		int userGroupId = 0;
		int hospitalId = 0;

		usergroupHospitalId = (Integer) generalMap.get("id");
		userGroupId = (Integer) generalMap.get("userGroupId");
		hospitalId = (Integer) generalMap.get("hospitalId");

		UsergroupHospital masUsergroupHospital = (UsergroupHospital) getHibernateTemplate()
				.get(UsergroupHospital.class, usergroupHospitalId);

		masUsergroupHospital.setId(usergroupHospitalId);

		UserGroups masUserGroups = new UserGroups();
		masUserGroups.setId(userGroupId);
		masUsergroupHospital.setGroup(masUserGroups);

		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		masUsergroupHospital.setHospital(masHospital);

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masUsergroupHospital);
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;

	}

	@SuppressWarnings( { "unused", "unchecked" })
	public Map<String, Object> searchUsergroupHospital(String groupName,
			String hospitalName) {
		List<UsergroupHospital> searchUsergroupHospitalList = new ArrayList<UsergroupHospital>();
		Map<String, Object> usergroupHospitalFieldsMap = new HashMap<String, Object>();
		List<UserGroups> userGroupsList = new ArrayList<UserGroups>();
		List<UserGroups> gridUserGroupsList = new ArrayList<UserGroups>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		List<MasHospital> gridMasHospitalList = new ArrayList<MasHospital>();
		try {
			if ((groupName != null) || (hospitalName == null)) {

				searchUsergroupHospitalList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.UsergroupHospital imc where imc.Group.GroupName like '"
										+ groupName
										+ "%' order by imc.Group.GroupName");
			} else {
				searchUsergroupHospitalList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.UsergroupHospital imc where imc.Hospital.HospitalName like '"
										+ hospitalName
										+ "%' order by imc.Hospital.HospitalName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		userGroupsList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.UserGroups as mc where mc.Status = 'y'");
		gridUserGroupsList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.UserGroups as mc where mc.Status = 'y'");
		hospitalList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasHospital as mc where mc.Status = 'y'");
		gridMasHospitalList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasHospital as mc where mc.Status = 'y'");

		usergroupHospitalFieldsMap.put("searchUsergroupHospitalList",
				searchUsergroupHospitalList);
		usergroupHospitalFieldsMap.put("hospitalList", hospitalList);
		usergroupHospitalFieldsMap.put("gridMasHospitalList",
				gridMasHospitalList);
		usergroupHospitalFieldsMap
				.put("gridUserGroupsList", gridUserGroupsList);
		usergroupHospitalFieldsMap.put("userGroupsList", userGroupsList);
		return usergroupHospitalFieldsMap;
	}

	@SuppressWarnings( { "unused", "unchecked" })
	public Map<String, Object> showUsergroupHospitalJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<UsergroupHospital> searchUsergroupHospitalList = new ArrayList<UsergroupHospital>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		List<UserGroups> userGroupsList = new ArrayList<UserGroups>();

		searchUsergroupHospitalList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.UsergroupHospital ");
		hospitalList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasHospital as mc where mc.Status = 'y' order by mc.HospitalName asc");
		userGroupsList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.UserGroups as mc where mc.Status = 'y' order by mc.GroupName asc");
		map.put("searchUsergroupHospitalList", searchUsergroupHospitalList);
		map.put("hospitalList", hospitalList);
		map.put("userGroupsList", userGroupsList);
		return map;
	}

	@SuppressWarnings( { "unused", "unchecked" })
	public Map<String, Object> checkForExistingGroupHospital(
			Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List duplicateGroupHospitalList = new ArrayList();
		int userGroupId = (Integer) generalMap.get("userGroupId");
		int hospitalId = (Integer) generalMap.get("hospitalId");

		duplicateGroupHospitalList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.UsergroupHospital ugh join ugh.Hospital as hospital join ugh.Group as grp where hospital.Id="
								+ hospitalId + " and grp.Id=" + userGroupId);
		map.put("duplicateGroupHospitalList", duplicateGroupHospitalList);

		return map;
	}

	public Map<String, Object> checkForExistingHospital(
			Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List duplicateHospitalList = new ArrayList();
		int usersId = (Integer) generalMap.get("usersId");
		 int hospitalId = (Integer)generalMap.get("hospitalId");
	//	int groupHospitalId = (Integer) generalMap.get("groupHospitalId");

		/*duplicateHospitalList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.UserUsergroupHospital ugh join ugh.User as user join ugh.GroupHospital as grp where user.Id="
								+ usersId + " and grp.Id=" + groupHospitalId);*/
		 
		 duplicateHospitalList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.UserUsergroupHospital ugh join ugh.User as user join ugh.Hospital as hos where user.Id="
									+ usersId + " and hos.Id=" + hospitalId);

		// duplicateHospitalList =
		// getHibernateTemplate().find("from jkt.security.masters.business.MasHospital as mh join mh.UsergroupHospitals as ugh join ugh.Group as grp where mh.Id = "+hospitalId
		// +" and grp.Id="+groupId);
		map.put("duplicateHospitalList", duplicateHospitalList);

		return map;
	}

	// -------------------------------------- Hospital Master
	// --------------------------------

	//public boolean addHospital(MasHospital masHospital) {
	public boolean addHospital(Map<String, Object> dataForSaveMap) {
		MasHospital masHospital=new MasHospital();
		if(dataForSaveMap.get("masHospital")!=null){
			masHospital=(MasHospital)dataForSaveMap.get("masHospital");
		}
		/*
		 * Code for Employee
		 */
		int employeeId=0;
		int loginId=0;
		String loginName="";
		String password="";
		String serviceNo="";
		int rankId=0;
		int titleId=0;
		String firstName="";
		String middleName="";
		String lastName="";
		int tradeId=0;
		int empCategoryId=0;
        int unitId=0;
        int departmentId=0;
        String offPhone="";
        if(dataForSaveMap.get("employeeId")!=null){
        	employeeId=(Integer)dataForSaveMap.get("employeeId");
		}
        if(dataForSaveMap.get("loginId")!=null){
        	loginId=(Integer)dataForSaveMap.get("loginId");
		}
        if(dataForSaveMap.get("loginName")!=null){
        	loginName=(String)dataForSaveMap.get("loginName");
		}
        if(dataForSaveMap.get("password")!=null){
        	password=(String)dataForSaveMap.get("password");
		}
        if(dataForSaveMap.get("serviceNo")!=null){
        	serviceNo=(String)dataForSaveMap.get("serviceNo");
		}
        
        if(dataForSaveMap.get("rankId")!=null){
        	rankId=(Integer)dataForSaveMap.get("rankId");
		}
        if(dataForSaveMap.get("titleId")!=null){
        	titleId=(Integer)dataForSaveMap.get("titleId");
		}
        if(dataForSaveMap.get("firstName")!=null){
        	firstName=(String)dataForSaveMap.get("firstName");
		}
        if(dataForSaveMap.get("middleName")!=null){
        	middleName=(String)dataForSaveMap.get("middleName");
		}
        if(dataForSaveMap.get("lastName")!=null){
        	lastName=(String)dataForSaveMap.get("lastName");
		}
        
        if(dataForSaveMap.get("tradeId")!=null){
        	tradeId=(Integer)dataForSaveMap.get("tradeId");
		}
        if(dataForSaveMap.get("empCategoryId")!=null){
        	empCategoryId=(Integer)dataForSaveMap.get("empCategoryId");
		}
        if(dataForSaveMap.get("unitId")!=null){
        	unitId=(Integer)dataForSaveMap.get("unitId");
		}
        if(dataForSaveMap.get("departmentId")!=null){
        	departmentId=(Integer)dataForSaveMap.get("departmentId");
		}
        if(dataForSaveMap.get("offPhone")!=null){
        	offPhone=(String)dataForSaveMap.get("offPhone");
		}
		String changedBy= "";
		Date currentDate=new Date();
		String currentTime= "";
		if(dataForSaveMap.get("changedBy")!=null){
			changedBy=(String)dataForSaveMap.get("changedBy");
		}
		if(dataForSaveMap.get("currentDate")!=null){
			currentDate=(Date)dataForSaveMap.get(currentDate);
		}
		if(dataForSaveMap.get("currentTime")!=null){
			currentTime=(String)dataForSaveMap.get("currentTime");
		}
		
		session= getSession();
		
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		try {
			hbt.save(masHospital);
			
			/**
			 * Add one room and 11 beds by default at the time of SMC creation
			 * Code by Ritu
			 * Date 26 Nov 2012
			 */
			List<MasRoom> roomList = new ArrayList<MasRoom>();
			roomList = session.createCriteria(MasRoom.class).add(Restrictions.eq("Hospital.Id", masHospital.getId())).list();
			MasRoom masRoom = new MasRoom();
			if(roomList.size() == 0){
				masRoom.setRoomCode("001");
				MasRoomType masRoomType = new MasRoomType();
				masRoomType.setId(1);
				masRoom.setRoomType(masRoomType);
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(36);
				masRoom.setDepartment(masDepartment);
				masRoom.setStatus("y");
				masRoom.setLastChgBy(changedBy);
				masRoom.setLastChgDate(currentDate);
				masRoom.setLastChgTime(currentTime);
				
				masRoom.setHospital(masHospital);
				 
				hbt.save(masRoom);
			}
			
			List<MasBed> bedList = new ArrayList<MasBed>();
			bedList = session.createCriteria(MasBed.class).add(Restrictions.eq("Hospital.Id", masHospital.getId())).list();
			if(bedList.size() == 0){
				for(int i=1;i<=11;i++){
					MasBed masBed = new MasBed();
					masBed.setBedNo(""+i);

					MasDepartment departmentObj = new MasDepartment();
					departmentObj.setId(36);
					masBed.setDepartment(departmentObj);

					if(roomList.size()>0){
						MasRoom roomObj = new MasRoom();
						roomObj.setId(roomList.get(0).getId());
						masBed.setRoom(roomObj);
					}else{
						masBed.setRoom(masRoom);
					}
					MasBedStatus bedStatusObj = new MasBedStatus();
					bedStatusObj.setId(6);
					masBed.setBedStatus(bedStatusObj);

					masBed.setHospital(masHospital);

					masBed.setStatus("y");
					masBed.setLastChgBy(changedBy);
					masBed.setLastChgDate(currentDate);
					masBed.setLastChgTime(currentTime);
					hbt.save(masBed);
				}
			}
			/*
			 * At the time of SMC Creation, User Group will assigned here
			 * All Active User Group
			 * Code by Mukesh
			 * Date 17 July 2012
			 */
			List<UserGroups> userGroupsList = new ArrayList<UserGroups>();
			userGroupsList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.UserGroups as mc where mc.Status = 'y'");
			UsergroupHospital masUsergroupHospital2 = new UsergroupHospital();
			if(userGroupsList.size()>0){
				for (UserGroups userGroups : userGroupsList) {
					UsergroupHospital masUsergroupHospital = new UsergroupHospital();
					
					UserGroups masUserGroups = new UserGroups();
					masUserGroups.setId(userGroups.getId());
					masUsergroupHospital.setGroup(masUserGroups);

					masUsergroupHospital.setHospital(masHospital);

					masUsergroupHospital.setStatus("y");
					masUsergroupHospital.setLastChgBy(masHospital.getLastChgBy());
					masUsergroupHospital.setLastChgDate(masHospital.getLastChgDate());
					masUsergroupHospital.setLastChgTime(masHospital.getLastChgTime());
					hbt.save(masUsergroupHospital);
					masUsergroupHospital2=masUsergroupHospital;
					
				}
			}
			/*
			 * At the time of SMC Creation, User Group will assigned here
			 * Code by Mukesh
			 * Date 17 July 2012
			 */
			/*
			 * Code for Check Employee And Users
			 */
			MasEmployee masEmployee=new MasEmployee();
			if(employeeId>0){
				/*
				 * Code for Update Employee Details
				 */
				masEmployee=(MasEmployee)hbt.load(MasEmployee.class, employeeId);
				masEmployee.setServiceNo(serviceNo);
				masEmployee.setFirstName(firstName);
				masEmployee.setLastName(lastName);
				masEmployee.setMiddleName(middleName);
				
				
				if(titleId != 0){
					MasTitle masTitle = new MasTitle();
					masTitle.setId(titleId);
					masEmployee.setTitle(masTitle);
				}

				if(departmentId != 0){
					MasDepartment masDepartment = new MasDepartment();
					masDepartment.setId(departmentId);
					masEmployee.setDepartment(masDepartment);
				}
				

				if(empCategoryId != 0){
					MasEmpCategory masEmpCategory = new MasEmpCategory();
					masEmpCategory.setId(empCategoryId);
					masEmployee.setEmpCategory(masEmpCategory);
				}
				
				if(rankId != 0){
					MasRank masRank = new MasRank();
					masRank.setId(rankId);
					masEmployee.setRank(masRank);
				}
				if(unitId != 0){
					MasUnit masUnit = new MasUnit();
					masUnit.setId(unitId);
					masEmployee.setUnit(masUnit);
				}
				if(tradeId != 0){
					MasTrade masTrade = new MasTrade();
					masTrade.setId(tradeId);
					masEmployee.setTrade(masTrade);
				}
				masEmployee.setTelNoOffice(offPhone);
				hbt.update(masEmployee);
			}else{
				/*
				 * Code for saved Employee Details
				 */
				
				masEmployee.setServiceNo(serviceNo);
				masEmployee.setFirstName(firstName);
				masEmployee.setLastName(lastName);
				masEmployee.setMiddleName(middleName);
				
				
				if(titleId != 0){
					MasTitle masTitle = new MasTitle();
					masTitle.setId(titleId);
					masEmployee.setTitle(masTitle);
				}

				if(departmentId != 0){
					MasDepartment masDepartment = new MasDepartment();
					masDepartment.setId(departmentId);
					masEmployee.setDepartment(masDepartment);
				}
				

				if(empCategoryId != 0){
					MasEmpCategory masEmpCategory = new MasEmpCategory();
					masEmpCategory.setId(empCategoryId);
					masEmployee.setEmpCategory(masEmpCategory);
				}
				
				if(rankId != 0){
					MasRank masRank = new MasRank();
					masRank.setId(rankId);
					masEmployee.setRank(masRank);
				}
				if(unitId != 0){
					MasUnit masUnit = new MasUnit();
					masUnit.setId(unitId);
					masEmployee.setUnit(masUnit);
				}
				if(tradeId != 0){
					MasTrade masTrade = new MasTrade();
					masTrade.setId(tradeId);
					masEmployee.setTrade(masTrade);
				}
				masEmployee.setTelNoOffice(offPhone);
				masEmployee.setHospital(masHospital);
				
				masEmployee.setStatus("y");
				masEmployee.setLastChgBy(masHospital.getLastChgBy());
				masEmployee.setLastChgDate(masHospital.getLastChgDate());
				masEmployee.setLastChgTime(masHospital.getLastChgTime());
				
				hbt.save(masEmployee);
			}
			Users users = new Users();
			if(loginId>0){
				users.setId(loginId);
				
				/*
				 * If login details is Existing in this case this block will execute
				 * Code By Mukesh 
				 * Date 27 July 2012
				 */
				UserUsergroupHospital masUserUsergroupHospital = new UserUsergroupHospital();
				/*masUserUsergroupHospital.setUser(users);
				int groupHospitalId = usergroupHospital.getId();*/
				masUserUsergroupHospital.setUser(users);
				masUserUsergroupHospital
				.setGroupHospital(masUsergroupHospital2);
				masUserUsergroupHospital.setStatus("y");
				masUserUsergroupHospital.setLastChgBy(users.getLastChgBy());
				masUserUsergroupHospital.setLastChgDate(users.getLastChgDate());
				masUserUsergroupHospital.setLastChgTime(users.getLastChgTime());
				hbt.save(masUserUsergroupHospital);
				hbt.refresh(masUserUsergroupHospital);
			}else{
				//Users users = new Users();
				users.setLoginName(serviceNo);
				users.setUserName(serviceNo);
				users.setStatus("y");
				users.setLastChgBy(masHospital.getLastChgBy());
				users.setLastChgDate(masHospital.getLastChgDate());
				users.setLastChgTime(masHospital.getLastChgTime());
				if(employeeId>0){
					MasEmployee masEmployee2=new MasEmployee();
					masEmployee2.setId(employeeId);
					users.setEmployee(masEmployee);
				}else{
					users.setEmployee(masEmployee);
				}
			/*
			 * Changes in password encrypt 
			 */
				try {
					users.setPassword(EncryptPwd.SHA1(password));
					System.out.println(EncryptPwd.SHA1(password)+"<--EncryptPwd.SHA1(password)--password-->"+password);
					users.setStatusSHA1("y");
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				hbt.save(users);
				hbt.refresh(users);
				UserUsergroupHospital masUserUsergroupHospital = new UserUsergroupHospital();
				/*masUserUsergroupHospital.setUser(users);
				int groupHospitalId = usergroupHospital.getId();*/
				masUserUsergroupHospital.setUser(users);
				masUserUsergroupHospital
				.setGroupHospital(masUsergroupHospital2);
				masUserUsergroupHospital.setStatus("y");
				masUserUsergroupHospital.setLastChgBy(users.getLastChgBy());
				masUserUsergroupHospital.setLastChgDate(users.getLastChgDate());
				masUserUsergroupHospital.setLastChgTime(users.getLastChgTime());
				hbt.save(masUserUsergroupHospital);
				hbt.refresh(masUserUsergroupHospital);
			}
			
			List<MasDepartment> masDepartmentList=new ArrayList<MasDepartment>();
			masDepartmentList = getHibernateTemplate()
			.find(
					"from jkt.hms.masters.business.MasDepartment as md where md.Status = 'y'");
			if(masDepartmentList.size()>0){
				for (MasDepartment masDepartment : masDepartmentList) {
					UserDepartment userDepartment = new UserDepartment();
					userDepartment.setDepartment(masDepartment);

					userDepartment.setUser(users);
					userDepartment.setStatus("y");
					hbt.save(userDepartment);
				}
			}
			
			/*
			 * Code for Module Application
			 * Date 25 July 2012
			 */
			List<MasHospital> masHospitalList=new ArrayList<MasHospital>();
			masHospitalList = getHibernateTemplate()
			.find(
					"from jkt.hms.masters.business.MasHospital as md where md.Status = 'y' order by md.Id asc");
			int hospitalId=0;
			if(masHospitalList.size()>0){
				for (MasHospital masHospital2 : masHospitalList) {
					hospitalId=	masHospital2.getId();
				}
			}
			List<Integer> templetIdList=new ArrayList<Integer>();
			templetIdList = getHibernateTemplate()
			.find("select md.Id from jkt.hms.masters.business.MasTemplate as md where md.Status = 'y' order by md.Id asc");
			Map<String, Object> templateMap = new HashMap<String, Object>();
			Map<String, Object> inputMap = new HashMap<String, Object>();
			
			
		/*	String changedBy = "";
			Date currentDate = new Date();
			String currentTime = "";*/
			currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
			
			changedBy = (String) masHospital.getLastChgBy();
			currentDate = (Date) masHospital.getLastChgDate();
			//currentTime = (String) userMap.get("currentTime");
			
			inputMap.put("changedBy",changedBy);
			inputMap.put("currentDate",currentDate);
			inputMap.put("currentTime",currentTime);
			inputMap.put("users", users);
			
			inputMap.put("templetIdList",templetIdList);
			inputMap.put("hospitalId",hospitalId);
			if(templetIdList.size()>0){
				templateMap=getTemplateApplicationListForSMC(inputMap);
			}
			/*
			 * End of Code for Module Application
			 * Date 06 July 2012
			 */
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteHospital(int hospitalId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasHospital masHospital = new MasHospital();
		masHospital = (MasHospital) getHibernateTemplate().get(
				MasHospital.class, hospitalId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masHospital.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masHospital.setStatus("y");
				dataDeleted = false;
			}
		}
		masHospital.setLastChgBy(changedBy);
		masHospital.setLastChgDate(currentDate);
		masHospital.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(masHospital);
		return dataDeleted;
	}

	@SuppressWarnings("unused")
	public boolean editHospitalToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String hospitalName = "";
		@SuppressWarnings("unused")
		String hospitalCode = "";
		String hospitalAddress = "";
		String contactNumber = "";
		int hospitalId = 0;
		String changedBy = "";
		int command = 0;
		try {
			hospitalId = (Integer) generalMap.get("id");
			hospitalCode = (String) generalMap.get("hospitalCode");
			hospitalName = (String) generalMap.get("name");
			hospitalAddress = (String) generalMap.get("hospitalAddress");
			contactNumber = (String) generalMap.get("contactNumber");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			if(generalMap.get("command")!=null)
				command = (Integer)generalMap.get("command");
		} catch (Exception e) {
			e.printStackTrace();
		}

		MasHospital masHospital = (MasHospital) getHibernateTemplate().get(
				MasHospital.class, hospitalId);

		masHospital.setId(hospitalId);
		masHospital.setHospitalName(hospitalName);
		masHospital.setAddress(hospitalAddress);
		masHospital.setContactNumber(contactNumber);
		if(command!=0){
			MasCommand masCommand = new MasCommand();
			masCommand.setId(command);
			masHospital.setCommand(masCommand);
		}
		/*
		 * masUserGroups.setLastChgBy(changedBy);
		 * masUserGroups.setLastChgDate(currentDate);
		 * masUserGroups.setLastChgTime(currentTime);
		 */
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(masHospital);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings( { "unused", "unchecked" })
	public Map<String, Object> searchHospital(String hospitalCode,
			String hospitalName) {
		List<MasHospital> searchHospitalList = new ArrayList<MasHospital>();
		Map<String, Object> userGroupsFieldsMap = new HashMap<String, Object>();
		try {
			if ((hospitalName != null) || (hospitalCode == null)) {

				searchHospitalList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasHospital imc where upper(imc.HospitalName) like upper('"
										+ hospitalName
										+ "%') order by imc.HospitalName");
			} else {
				searchHospitalList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasHospital imc where upper(imc.HospitalCode) like upper('"
										+ hospitalCode
										+ "%') order by imc.HospitalCode");
			}
			List<MasCommand>  commandList = new ArrayList<MasCommand>();
			commandList = getHibernateTemplate().find("from jkt.hms.masters.business.MasCommand as cd where cd.Status='y'");
			userGroupsFieldsMap.put("commandList", commandList);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		userGroupsFieldsMap.put("searchHospitalList", searchHospitalList);
		return userGroupsFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showHospitalJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasHospital> searchHospitalList = new ArrayList<MasHospital>();
		List<MasCommand>  commandList = new ArrayList<MasCommand>();
		searchHospitalList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasHospital ");
		commandList = getHibernateTemplate().find("from jkt.hms.masters.business.MasCommand as cd where cd.Status='y' order by cd.CommandName asc");
		map.put("searchHospitalList", searchHospitalList);
		map.put("commandList", commandList);
		
		/*
		 * Code for Employee
		 */
		List<MasTitle> titleList = new ArrayList<MasTitle>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasEmpCategory> empCategoryList = new ArrayList<MasEmpCategory>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasTrade> tradeList = new ArrayList<MasTrade>();

		List<TransactionSequence> seqList = new ArrayList<TransactionSequence>();
		
		titleList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasTitle as tm where tm.Status = 'y' order by tm.TitleName asc");
		departmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment as md where md.Status = 'y' order by md.DepartmentName asc");
		empCategoryList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasEmpCategory as mec where mec.Status = 'y' order by mec.EmpCategoryName asc");
		rankList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasRank as mg where mg.Status = 'y' order by mg.RankName asc");
		unitList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasUnit as mg where mg.Status = 'y' order by mg.UnitName asc");
		tradeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasTrade as mg where mg.Status = 'y' order by mg.TradeName asc");
		seqList = getHibernateTemplate().find("from jkt.hms.masters.business.TransactionSequence as ts where ts.TransactionPrefix= 'EMP'");
		
		map.put("titleList", titleList);
		map.put("departmentList", departmentList);
		map.put("empCategoryList", empCategoryList);
		map.put("rankList", rankList);
		map.put("unitList", unitList);
		map.put("tradeList", tradeList);
		map.put("seqList", seqList);
		
		
		
		return map;
	}

	@SuppressWarnings( { "unused", "unchecked" })
	public Map<String, Object> searchUser(String loginName, int hospitalId) {

		List<Users> searchUserList = new ArrayList<Users>();
		List employeeList = null;
		Map<String, Object> usersFieldsMap = new HashMap<String, Object>();
		List<EmpGroups> empGroupList = new ArrayList<EmpGroups>();
	//	List<UsergroupHospital> groupList = new ArrayList<UsergroupHospital>();
		List<Object[]> groupList = new ArrayList<Object[]>();
		List<UserEmpGroup> userEmpGroupList = new ArrayList<UserEmpGroup>();
		List<UserUsergroupHospital> useruserGroupHospList = new ArrayList<UserUsergroupHospital>();
		try {
			if (loginName != null) {
				searchUserList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.Users as i where i.LoginName like '"
								+ loginName + "%' order by i.LoginName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*employeeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasEmployee as isc where isc.Status = 'y'");*/
		empGroupList = getHibernateTemplate().find(
				"from EmpGroups as eg where eg.Status='y'");
		/*groupList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.UsergroupHospital as mc where mc.Status = 'y' and mc.Hospital.Id="
								+ hospitalId + "" 
										" group by Group"
								);*/
		groupList = getHibernateTemplate()
		.find( "select mc.Group.Id,mc.Group.GroupName from jkt.hms.masters.business.UsergroupHospital as mc where mc.Status = 'y' and mc.Hospital.Id="
						+ hospitalId + " group by mc.Group.Id,mc.Group.GroupName");
		userEmpGroupList = getHibernateTemplate().find(
				"from UserEmpGroup as ueg where ueg.Status='y'");
		useruserGroupHospList = getHibernateTemplate().find(
				"from UserUsergroupHospital as u where u.Status = 'y'");

		usersFieldsMap.put("useruserGroupHospList", useruserGroupHospList);
		usersFieldsMap.put("userEmpGroupList", userEmpGroupList);
		usersFieldsMap.put("employeeList", employeeList);
		usersFieldsMap.put("searchUserList", searchUserList);
		usersFieldsMap.put("empGroupList", empGroupList);
		usersFieldsMap.put("groupList", groupList);
		return usersFieldsMap;
	}

	public Map<String, Object> showUserHospitalMaintenanceJsp(
			Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<UserGroups> groupList = new ArrayList<UserGroups>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		List<Users> usersList = new ArrayList<Users>();

		List<Users> gridUsersList = new ArrayList<Users>();
		List<MasHospital> gridMasHospitalList = new ArrayList<MasHospital>();
		List<UserGroups> gridGroupList = new ArrayList<UserGroups>();
		int hospitalId = (Integer) generalMap.get("hospitalId");

		List<UserUsergroupHospital> searchUserUsergroupHospitalList = new ArrayList<UserUsergroupHospital>();
		searchUserUsergroupHospitalList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.UserUsergroupHospital ");
	/*	groupList = getHibernateTemplate()
				.find(
						"select distinct mc.Group from jkt.hms.masters.business.UsergroupHospital as mc where mc.Status = 'y' and mc.Hospital.Id="
								+ hospitalId);*/
		hospitalList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasHospital as mc where mc.Status = 'y' order by mc.HospitalName asc");
		usersList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.Users as mc where mc.Status = 'y' order by mc.UserName asc");

		/*gridUsersList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.Users as mc where mc.Status = 'y'");
		gridMasHospitalList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasHospital as mc where mc.Status = 'y'");*/
	/*	gridGroupList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.UserGroups as mc where mc.Status = 'y'");*/
System.out.println("searchUserUsergroupHospitalList--"+searchUserUsergroupHospitalList.size());
		map.put("searchUserUsergroupHospitalList",
				searchUserUsergroupHospitalList);
		map.put("hospitalList", hospitalList);
		map.put("usersList", usersList);
		map.put("groupList", groupList);
		map.put("gridMasHospitalList", hospitalList);
		map.put("gridGroupList", gridGroupList);
		map.put("gridUsersList", usersList);
		return map;

	}

	public boolean addUserHospitalMaintenance(Map<String, Object> generalMap) {
		UserUsergroupHospital masUserUsergroupHospital = (UserUsergroupHospital) generalMap
				.get("masUserUsergroupHospital");

		int group_id = (Integer) generalMap.get("groupId");
	//	int userGroupHospitalId = (Integer) generalMap.get("groupHospitalId");
		int usersId = (Integer) generalMap.get("usersId");

		boolean successfullyAdded = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			hbt.save(masUserUsergroupHospital);
			hbt.refresh(masUserUsergroupHospital);

			/*
			 * List<GroupApplication> groupApplicationList = hbt.find(
			 * "from jkt.hms.masters.business.GroupApplication as mc where mc.Group.Id="
			 * + group_id); for (Iterator iterator =
			 * groupApplicationList.iterator(); iterator.hasNext();) {
			 * GroupApplication groupApplication = (GroupApplication)
			 * iterator.next(); UserUsergroupApplication
			 * userUsergroupApplication = new UserUsergroupApplication();
			 * userUsergroupApplication.setGroupApp(groupApplication);
			 * userUsergroupApplication.setGroupHospital(new
			 * UsergroupHospital(userGroupHospitalId));
			 * userUsergroupApplication.setUser(new Users(usersId));
			 * userUsergroupApplication.setStatus("y");
			 * hbt.save(userUsergroupApplication); }
			 */
			successfullyAdded = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return successfullyAdded;
	}

	public boolean deleteUserHospitalMaintenance(int userHospitalMaintenanceId,
			Map<String, Object> generalMap) {

		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		UserUsergroupHospital masUsergroupHospital = new UserUsergroupHospital();
		masUsergroupHospital = (UserUsergroupHospital) getHibernateTemplate()
				.get(UserUsergroupHospital.class, userHospitalMaintenanceId);
		@SuppressWarnings("unused")
		Integer usersId = masUsergroupHospital.getUser().getId();
		/*Integer hospitalId = masUsergroupHospital.getGroupHospital()
				.getHospital().getId();*/
		Integer hospitalId = masUsergroupHospital.getHospital().getId();
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			List usersList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.Users as isc where isc.Id='"
							+ userHospitalMaintenanceId
							+ "' and isc.Status='y'");
			@SuppressWarnings("unused")
			List hospitalList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasHospital as isc where isc.Id='"
							+ userHospitalMaintenanceId
							+ "' and isc.Status='y'");
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masUsergroupHospital.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masUsergroupHospital.setStatus("y");
				dataDeleted = false;
			}
		}
		masUsergroupHospital.setLastChgBy(changedBy);
		masUsergroupHospital.setLastChgDate(currentDate);
		masUsergroupHospital.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masUsergroupHospital);
		return dataDeleted;
	}

	public boolean editUserHospitalMaintenance(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		int userHospitalMaintenanceId = 0;
		int usersId = 0;
		int groupHospitalId = 0;
		Date currentDate = new Date();
		Date validUpto = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String changedBy = "";
		userHospitalMaintenanceId = (Integer) generalMap.get("id");
		usersId = (Integer) generalMap.get("usersId");
	//	groupHospitalId = (Integer) generalMap.get("groupHospitalId");

		validUpto = (Date) generalMap.get("validUpto");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		int hospitalId = (Integer)generalMap.get("hospitalId");
		
		UserUsergroupHospital masUsergroupHospital = (UserUsergroupHospital) getHibernateTemplate()
				.get(UserUsergroupHospital.class, userHospitalMaintenanceId);

		masUsergroupHospital.setId(userHospitalMaintenanceId);

		Users masUserGroups = new Users();
		masUserGroups.setId(usersId);
		masUsergroupHospital.setUser(masUserGroups);

		/*UsergroupHospital usergroupHospital = new UsergroupHospital();
		usergroupHospital.setId(groupHospitalId);
		masUsergroupHospital.setGroupHospital(usergroupHospital);
*/
		
		MasHospital hospital = new MasHospital();
		hospital.setId(hospitalId);
		masUsergroupHospital.setHospital(hospital);
		
	//	masUsergroupHospital.setValidUpto(validUpto);
		masUsergroupHospital.setLastChgBy(changedBy);
		masUsergroupHospital.setLastChgDate(currentDate);
		masUsergroupHospital.setLastChgTime(currentTime);

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masUsergroupHospital);
			hbt.refresh(masUsergroupHospital);
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	public Map<String, Object> searchUserHospitalMaintenance(String userName) {
		List<UserUsergroupHospital> searchUserUsergroupHospitalList = new ArrayList<UserUsergroupHospital>();
		Map<String, Object> userUsergroupHospitalFieldsMap = new HashMap<String, Object>();
		List<Users> usersList = new ArrayList<Users>();
		List<Users> gridUsersList = new ArrayList<Users>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		List<MasHospital> gridMasHospitalList = new ArrayList<MasHospital>();
	/*	List<UserGroups> gridGroupList = new ArrayList<UserGroups>();
		List<UserGroups> groupList = new ArrayList<UserGroups>();*/
		try {
			if ((userName != null)) {

				searchUserUsergroupHospitalList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.UserUsergroupHospital as imc where imc.User.UserName like '"
										+ userName
										+ "%' order by imc.User.UserName");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		usersList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.Users as mc where mc.Status = 'y'");
		gridUsersList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.Users as mc where mc.Status = 'y'");
		hospitalList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasHospital as mc where mc.Status = 'y'");
		gridMasHospitalList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasHospital as mc where mc.Status = 'y'");
	/*	groupList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.UserGroups as mc where mc.Status = 'y'");
		gridGroupList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.UserGroups as mc where mc.Status = 'y'");
*/
		userUsergroupHospitalFieldsMap.put("searchUserUsergroupHospitalList",
				searchUserUsergroupHospitalList);
		userUsergroupHospitalFieldsMap.put("hospitalList", hospitalList);
		userUsergroupHospitalFieldsMap.put("gridMasHospitalList",
				gridMasHospitalList);
		userUsergroupHospitalFieldsMap.put("gridUsersList", gridUsersList);
		userUsergroupHospitalFieldsMap.put("usersList", usersList);
		/*userUsergroupHospitalFieldsMap.put("groupList", groupList);
		userUsergroupHospitalFieldsMap.put("gridGroupList", gridGroupList);*/
		userUsergroupHospitalFieldsMap.put("gridUsersList", gridUsersList);

		return userUsergroupHospitalFieldsMap;
	}/*
	 * public Map<String, Object> searchUserHospitalMaintenance(String userName,
	 * String hospitalName) { List<UserUsergroupHospital>
	 * searchUserUsergroupHospitalList=new ArrayList<UserUsergroupHospital>();
	 * Map<String,Object> userUsergroupHospitalFieldsMap = new
	 * HashMap<String,Object>(); List<Users> usersList = new ArrayList<Users>();
	 * List<Users> gridUsersList = new ArrayList<Users>();
	 * List<UsergroupHospital> hospitalList = new
	 * ArrayList<UsergroupHospital>(); List<UsergroupHospital>
	 * gridMasHospitalList = new ArrayList<UsergroupHospital>(); try{
	 * if((userName!=null) || (hospitalName==null)){
	 * 
	 * searchUserUsergroupHospitalList=getHibernateTemplate().find(
	 * "from jkt.security.masters.business.UserUsergroupHospital imc where imc.User.UserName like '"
	 * + userName+"%' order by imc.Group.UserName"); } else{
	 * searchUserUsergroupHospitalList=getHibernateTemplate().find(
	 * "from jkt.security.masters.business.UserUsergroupHospital imc where imc.GroupHospital.Hospital.HospitalName like '"
	 * + hospitalName+"%' order by imc.GroupHospital.Hospital.HospitalName");}
	 * }catch (Exception e) { e.printStackTrace(); }
	 * 
	 * usersList = getHibernateTemplate().find(
	 * "from jkt.security.masters.business.Users as mc where mc.Status = 'y'");
	 * gridUsersList = getHibernateTemplate().find(
	 * "from jkt.security.masters.business.Users as mc where mc.Status = 'y'");
	 * hospitalList = getHibernateTemplate().find(
	 * "from jkt.security.masters.business.UsergroupHospital as mc where mc.Status = 'y'"
	 * ); gridMasHospitalList = getHibernateTemplate().find(
	 * "from jkt.security.masters.business.UsergroupHospital as mc where mc.Status = 'y'"
	 * );
	 * 
	 * userUsergroupHospitalFieldsMap.put("searchUserUsergroupHospitalList",
	 * searchUserUsergroupHospitalList);
	 * userUsergroupHospitalFieldsMap.put("hospitalList",hospitalList);
	 * userUsergroupHospitalFieldsMap
	 * .put("gridMasHospitalList",gridMasHospitalList);
	 * userUsergroupHospitalFieldsMap.put("gridUsersList",gridUsersList);
	 * userUsergroupHospitalFieldsMap.put("usersList",usersList); return
	 * userUsergroupHospitalFieldsMap; }
	 */
	public List<Object> getUserGroupForHospital(int hospitalId) {

		List<Object> userGroupForHospitalList = new ArrayList<Object>();
		Session session = (Session) getSession();
//		String str = "%" + hospitalId + "%";
		
		/*userGroupForHospitalList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasHospital mh join mh.UsergroupHospitals as ugh join ugh.Group as grp where mh.Id = "
						+ hospitalId);*/
		/*userGroupForHospitalList=session.createCriteria(UsergroupHospital.class).createAlias("Group", "gp").createAlias("Hospital", "mh")
                              .add(Restrictions.eq("mh.Id",hospitalId))
                              .setProjection(Projections.distinct(Projections.projectionList().add(Projections.property("gp.GroupName")))).list();*/
String query ="from jkt.hms.masters.business.MasHospital mh join mh.UsergroupHospitals as ugh join ugh.Group as grp where  mh.Id =(:hospitalId)";
			Query q = session.createQuery(query);
			q.setParameter("hospitalId",hospitalId);
			q.setFirstResult(0);
			q.setMaxResults(10);
			userGroupForHospitalList = q.list();
		return userGroupForHospitalList;
	}

	public Map<String, Object> getGroupHospitalIdFromUsergroupHospital(
			int groupId, int hospitalId) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<UsergroupHospital> groupHospitalIdList = new ArrayList<UsergroupHospital>();

		try {

			groupHospitalIdList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.UsergroupHospital as ugh where ugh.Hospital.Id ="
									+ hospitalId
									+ "and ugh.Group.Id="
									+ groupId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("groupHospitalIdList", groupHospitalIdList);
		return map;
	}

	// ********************************************************************************************//
	// ************************************End Modules of
	// Mansi******************************//
	// *******************************************************************************************//

	// =====================================================================================================
	// ================== adding application by abha============
	// =====================================================================================================

	// method to get application list from masApplication
	@SuppressWarnings( { "unused", "unchecked" })
	public List<MasApplication> getApplicationList() {
		List<MasApplication> applicationList = new ArrayList<MasApplication>();
		String no = "";
		int temp = 0;
		MasApplication masApp1 = new MasApplication();
		String applicationId = "";

		List objectList = new ArrayList();
		session = (Session) getSession();
		applicationList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasApplication");

		return applicationList;
	}

	public List<MasApplication> getApplicationIdList() {
		List objectList = new ArrayList();
		String no = "";
		int temp = 0;
		session = (Session) getSession();

		// String
		// qry="SELECT substring(app_id,2) as number, app_id FROM mas_application ORDER BY CAST(number AS DECIMAL)";
//		String qry = "SELECT CAST(substring(app_id,2) as UNSIGNED) as number, app_id FROM mas_application order by number";
		String qry = "SELECT cast(substring(app_id,2,len(app_id)) as integer) as num, app_id FROM mas_application order by num";
		objectList = (List) session.createSQLQuery(qry).list();
		Object[] pair = (Object[]) objectList.get(objectList.size() - 1);
		// String lastNo = (String) pair[0];
		return objectList;
	}

	// method to get group list from userGroups
	@SuppressWarnings( { "unused", "unchecked" })
	public Map<String, Object> getGroupList(Box box) {
		Map map = new HashMap<String, Object>();
		List<UsergroupHospital> groupList = new ArrayList<UsergroupHospital>();
		groupList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.UsergroupHospital as mi where  mi.Hospital.Id = "
								+ 1 + "");
		map.put("second_combo", groupList);
		return map;
	}

	// method to add applications in masApplication and groupApplication
	public boolean addApplication(Map<String, Object> infoMap) {
		@SuppressWarnings("unused")
		Box box = null;
		List<Integer> maxOrderNoList = new ArrayList<Integer>();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		if (infoMap.get("box") != null) {
			box = (Box) infoMap.get("box");
		}
		String parentIdTemp = "";
		String subPrId = "";
		String parentId = "";
		if (infoMap.get("parentIdTemp") != null) {
			parentIdTemp = "" + infoMap.get("parentIdTemp");
		}
		if (box.get("subPrId") != null) {
			subPrId = "" + box.get("subPrId");
		}
		boolean successfullyAdded = false;
		try {
			parentIdTemp = "" + box.get("prId");
			try {
				if (parentIdTemp != "") {
					int index1 = parentIdTemp.lastIndexOf("[");
					int index2 = parentIdTemp.lastIndexOf("]");
					index1++;
					parentId = parentIdTemp.substring(index1, index2);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			String appIdTemp = "" + box.get("applicationName");
			String appName = "";
			int appId = 0;
			try {
				int index1 = appIdTemp.lastIndexOf("[");
				int index2 = appIdTemp.lastIndexOf("]");
				index1++;
				appName = appIdTemp.substring(0, index1 - 1);
				appId = Integer.parseInt(""
						+ appIdTemp.substring(index1, index2));
				;
			} catch (Exception e) {
				e.printStackTrace();
			}
			maxOrderNoList = hbt
					.find("select max(OrderNo) from jkt.hms.masters.business.MasApplication ");
			int orderNo = maxOrderNoList.get(0);
			orderNo = orderNo + 1;
			UserApplications userApplications = (UserApplications) getHibernateTemplate()
					.load(UserApplications.class, appId);
			userApplications.setStatus("n");
			hbt.update(userApplications);
			hbt.refresh(userApplications);
			if (!parentId.equals("") && subPrId.equals("")) {
				@SuppressWarnings("unused")
				MasApplication masApplication = new MasApplication();
				masApplication.setId("" + box.get("applicationId"));
				masApplication.setName(appName);
				masApplication.setParentId(parentId);
				masApplication.setUrl("" + box.get("url"));
				masApplication.setOrderNo(orderNo);
				hbt.save(masApplication);
				hbt.refresh(masApplication);

				

			} else if (parentId.equals("") && subPrId.equals("")) {
				// Adding parent Id
				MasApplication masApplication = new MasApplication();
				masApplication.setId("" + box.get("applicationId"));
				masApplication.setName("" + appName);
				masApplication.setParentId("0");
				masApplication.setUrl("#");
				masApplication.setOrderNo(orderNo);
				hbt.save(masApplication);
				hbt.refresh(masApplication);

				
			} else if (!parentId.equals("") && !subPrId.equals("")) {
				// Adding parent Id
				MasApplication masApplication = new MasApplication();
				masApplication.setId("" + box.get("applicationId"));
				masApplication.setName("" + appName);
				masApplication.setParentId(subPrId);
				masApplication.setUrl("" + box.get("url"));
				masApplication.setOrderNo(orderNo);
				hbt.save(masApplication);
				hbt.refresh(masApplication);

				
			}
			successfullyAdded = true;
		} catch (Exception e) {
			successfullyAdded = false;
			e.printStackTrace();
		}
		return successfullyAdded;
	}

	@SuppressWarnings( { "unused", "unchecked" })
	public Map<String, Object> checkForExistingApplication(int groupId,
			String applicationName) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<GroupApplication> groupList = new ArrayList<GroupApplication>();
		List<GroupApplication> applicationList = new ArrayList<GroupApplication>();
		groupList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.GroupApplication as hm where hm.GroupId = '"
						+ groupId + "' ");

		applicationList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasApplication as hm where hm.Name= '"
						+ applicationName + "'");
		map.put("groupList", groupList);
		map.put("applicationList", applicationList);

		return map;
	}

	@SuppressWarnings( { "unused", "unchecked" })
	public List<UsergroupHospital> getGroupList() {
		List<UsergroupHospital> groupList = new ArrayList<UsergroupHospital>();
		groupList = (List) getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.UsergroupHospital as uugh where uugh.Hospital.Id = '1'");
		return groupList;

	}

	public List<MasHospital> getHospitallistList() {
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		hospitalList = (List) getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasHospital as uugh ");
//						"from jkt.hms.masters.business.MasHospital as uugh where uugh.Id = '1' ");
		return hospitalList;

	}

	Session session;

	public Map<String, Object> getApplicationListByAutocomplete(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasApplication> applicationList = new ArrayList<MasApplication>();
		List<MasApplication> allApplicationList = new ArrayList<MasApplication>();
		session = (Session) getSession();
		List objectList = new ArrayList();
		try {
			String str = dataMap.get("autoHint") + "%";
			String qry = "SELECT name FROM mas_application";
			objectList = (List) session.createSQLQuery(qry).list();
			Criteria c = session.createCriteria(MasApplication.class).add(
					Restrictions.like("Name", str))
					/*.add(Restrictions.in("Name", objectList))*/
					;
			c.setFirstResult(0);
			c.setMaxResults(10);
			applicationList = c.list();
			allApplicationList = session.createCriteria(MasApplication.class)
					.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("applicationList", applicationList);
		map.put("allApplicationList", allApplicationList);
		return map;

	}

	@SuppressWarnings( { "unused", "unchecked" })
	public Map<String, Object> searchApplication(String applicationId) {
		List<MasApplication> searchApplicationList = new ArrayList<MasApplication>();
		List<GroupApplication> searchGroupList = new ArrayList<GroupApplication>();
		List<MasApplication> searchParentNameList = new ArrayList<MasApplication>();
		List<MasApplication> searchParentList = new ArrayList<MasApplication>();
		Map<String, Object> map = new HashMap<String, Object>();
		MasApplication masApp = new MasApplication();
		GroupApplication groupApplication = new GroupApplication();
		int groupApplicationId = 0;
		String parentId = "";

		String searchParentName = "";

		searchApplicationList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasApplication imc where imc.Id = '"
						+ applicationId + "' order by imc.Name");
		if (searchApplicationList.size() > 0) {
			masApp = (MasApplication) searchApplicationList.get(0);
			applicationId = masApp.getId();
			parentId = masApp.getParentId();
			if (!parentId.equals("0")) {
				searchParentName = masApp.getApplication().getName();
			}
		}

		searchGroupList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.GroupApplication ga where ga.App= '"
						+ applicationId + "'");
		if (searchGroupList.size() > 0) {
			groupApplication = (GroupApplication) searchGroupList.get(0);
			groupApplicationId = groupApplication.getId();
		}
		map.put("groupApplicationId", groupApplicationId);
		map.put("searchGroupList", searchGroupList);
		map.put("searchApplicationList", searchApplicationList);
		map.put("parentId", parentId);

		map.put("searchParentName", searchParentName);
		return map;
	}

	@SuppressWarnings("unused")
	public boolean updateApplication(Map<String, Object> map) {
		boolean dataUpdated = false;
		String applicationId = "";
		String applicationName = "";
		String url = "";
		int orderNo = 0;
		String parentId = "";
		int groupId = 0;
		String status = "";
		int groupAppId = 0;
		int groupAppl = 0;
		int groupApplicationId = 0;
		try {
			applicationId = (String) map.get("applicationId");
			applicationName = (String) map.get("applicationName");
			url = (String) map.get("url");
			parentId = (String) map.get("parentId");
			// orderNo=(Integer)map.get("orderNo");
			groupId = (Integer) map.get("groupId");
			status = (String) map.get("status");
			groupApplicationId = (Integer) map.get("groupApplicationId");
		} catch (Exception e) {
			e.printStackTrace();
		}

		MasApplication masApplication = (MasApplication) getHibernateTemplate()
				.get(MasApplication.class, applicationId);
		masApplication.setId(applicationId);
		masApplication.setName(applicationName);
		masApplication.setUrl(url);
		masApplication.setParentId(parentId);
		// masApplication.setOrderNo(orderNo);

		/*GroupApplication groupApplication = (GroupApplication) getHibernateTemplate()
				.get(GroupApplication.class, groupApplicationId);
		UserGroups userGroups = new UserGroups();
		userGroups.setId(groupId);
		groupApplication.setGroup(userGroups);
		groupApplication.setStatus(status);
		MasApplication masApp = new MasApplication();
		masApp.setId(applicationId);
		groupApplication.setApp(masApp);*/

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masApplication);
			//hbt.update(groupApplication);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	// ============================== USER DEPARMENT
	// ======================================
	@SuppressWarnings( { "unused", "unchecked" })
	public Map<String, Object> showUserDepartmentJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployeeDepartment> searchUserDepartmentList = new ArrayList<MasEmployeeDepartment>();
		List<MasEmployee> searchUsersList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasEmployee> userList = new ArrayList<MasEmployee>();
		List<Users> userList1 = new ArrayList<Users>();
		Session session = (Session) getSession();
		List<MasDivision> divisionList = new ArrayList<MasDivision>();
		List<MasDivision> gridDivisionList = new ArrayList<MasDivision>();
		searchUsersList = getHibernateTemplate()
				.find(
						"select distinct ud.Employee from jkt.hms.masters.business.MasEmployeeDepartment ud ");
		searchUserDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasEmployeeDepartment");
		departmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment as mc where mc.Status = 'y' order by mc.DepartmentName asc");
		
		String divisonIdforMedical =null;
		try {
		
			divisonIdforMedical = HMSUtil.getValuesFromPropertiesFile("adt.properties", "divisonIdforMedical");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		userList1 = session.createCriteria(Users.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		
		List<Integer>empId = new ArrayList<Integer>();
		
		for(Users listA : userList1)
		{
			if(listA.getEmployee() !=null)
			empId.add(listA.getEmployee().getId());
		}
		
		
		userList = session.createCriteria(MasEmployee.class)
				.add(Restrictions.in("Id", empId))
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();

	
		divisionList=session.createCriteria(MasDivision.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("DivisionName")).list();
		
		map.put("divisionList", divisionList);

		
		map.put("searchUserDepartmentList", searchUserDepartmentList);
		map.put("departmentList", departmentList);
		map.put("userList", userList);
		map.put("searchUsersList", searchUsersList);
		return map;
	}

	public Map<String, Object> checkForExistingUserDepartment(
			Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List duplicateUserDepartmentList = new ArrayList();
		int userId = (Integer) generalMap.get("userId");
		duplicateUserDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasEmployeeDepartment ugh where ugh.Employee.Id="
						+ userId);
		map.put("duplicateUserDepartmentList", duplicateUserDepartmentList);

		return map;
	}

	public boolean addUserDepartment(Map<String, Object> generalMap) {

		String deptStr = null;
		int userId = 0;
		int divisionId=0;
		if (generalMap.get("deptStr") != null) {
			deptStr = (String) generalMap.get("deptStr");
		}

		if (generalMap.get("userId") != null) {
			userId = (Integer) generalMap.get("userId");
		}
		if (generalMap.get("divisionId") != null) {
			divisionId = (Integer) generalMap.get("divisionId");
		}
		boolean successfullyAdded = false;
		StringTokenizer strForDept = new StringTokenizer(deptStr, ",");
		Transaction tx = null;
		Session session = getSession();
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			while (strForDept.hasMoreTokens()) {
				MasEmployeeDepartment userDepartment = new MasEmployeeDepartment();
				int deptId = Integer.parseInt(strForDept.nextToken());
				userDepartment.setDepartment(new MasDepartment(deptId));
				userDepartment.setEmployee(new MasEmployee(userId));
				userDepartment.setDivision(new MasDivision(divisionId));
				userDepartment.setStatus("y");
				hbt.save(userDepartment);
				hbt.refresh(userDepartment);
			}
			successfullyAdded = true;
			tx.commit();
		} catch (DataAccessException e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}

		return successfullyAdded;
	}

	@SuppressWarnings( { "unused", "unchecked" })
	public Map<String, Object> searchUserDepartment(String userName,
			String departmentName) {
		List<UserDepartment> searchUserDepartmentList = new ArrayList<UserDepartment>();
		Map<String, Object> usergroupHospitalFieldsMap = new HashMap<String, Object>();
		List<Users> userList = new ArrayList<Users>();
		List<Users> searchUsersList = new ArrayList<Users>();
		List<Users> gridUsersList = new ArrayList<Users>();
		Session session = (Session) getSession();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasDepartment> gridMasDepartmentList = new ArrayList<MasDepartment>();
		try {
			if ((userName != null)) {
				searchUserDepartmentList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.UserDepartment");
				searchUsersList = getHibernateTemplate()
						.find(
								"select distinct ud.User from jkt.hms.masters.business.UserDepartment ud where ud.User.UserName like '%"
										+ userName
										+ "%' order by ud.User.UserName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		userList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.Users as mc where mc.Status = 'y'");
		gridUsersList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.Users as mc where mc.Status = 'y'");
		departmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment as mc where mc.Status = 'y'");
		gridMasDepartmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment as mc where mc.Status = 'y'");
		
	
		
	
		usergroupHospitalFieldsMap.put("searchUserDepartmentList",
				searchUserDepartmentList);
		usergroupHospitalFieldsMap.put("departmentList", departmentList);
		usergroupHospitalFieldsMap.put("gridMasDepartmentList",
				gridMasDepartmentList);
		usergroupHospitalFieldsMap.put("gridUsersList", gridUsersList);
		usergroupHospitalFieldsMap.put("userList", userList);
		usergroupHospitalFieldsMap.put("searchUsersList", searchUsersList);
		
		return usergroupHospitalFieldsMap;
	}

	public boolean editUserDepartment(Map<String, Object> generalMap) {
		Session session = (Session) getSession();
		boolean dataUpdated = false;
		int userDepartmentId = 0;
		int userId = 0;
		int departmentId = 0;
		String departmentStr = null;
		int divisionId=0;
		userDepartmentId = (Integer) generalMap.get("id");
		userId = (Integer) generalMap.get("userId");
		if (generalMap.get("divisionId") != null) {
			divisionId = (Integer) generalMap.get("divisionId");
		}
		if (generalMap.get("departmentStr") != null) {
			departmentStr = (String) generalMap.get("departmentStr");
		}
		StringTokenizer str = new StringTokenizer(departmentStr, ",");
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			List<MasEmployeeDepartment> userDepartmentList = hbt
					.find("from jkt.hms.masters.business.MasEmployeeDepartment ud where ud.Employee.Id="
							+ userId);
			if(userDepartmentList.size() > 0)
				hbt.deleteAll(userDepartmentList);
			/*for (Iterator iterator = userDepartmentList.iterator(); iterator
					.hasNext();) {
				UserDepartment userDepartment = (UserDepartment) iterator
						.next();
				int id = userDepartment.getId();
				String hql = "delete from jkt.hms.masters.business.UserDepartment as a where a.Id = "
						+ id;
				Query query = session.createQuery(hql);
				int row = query.executeUpdate();
			}*/

			System.out.println("departmentStr"+departmentStr);
			System.out.println("departmentStr"+divisionId);
			while (str.hasMoreTokens()) {
				System.out.println("inloop");
				MasEmployeeDepartment userDepartment = new MasEmployeeDepartment();
				int deptId = Integer.parseInt(str.nextToken());
				userDepartment.setEmployee(new MasEmployee(userId));
				userDepartment.setDepartment(new MasDepartment(deptId));
				userDepartment.setStatus("y");
				userDepartment.setDivision(new MasDivision(divisionId));
				hbt.save(userDepartment);
				hbt.refresh(userDepartment);
			}
			dataUpdated = true;
			tx.commit();
		} catch (Exception e) {
			if(tx!=null)
				tx.commit();
			e.printStackTrace();
		}
		return dataUpdated;

	}

	public boolean deleteUserDepartment(int userDepartmentId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;

		int userId = 0;
		if (generalMap.get("userId") != null) {
			userId = (Integer) generalMap.get("userId");
		}
		Transaction tx = null;

		Session session = getSession();
		
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			if (generalMap.get("flag") != null) {
				List<MasEmployeeDepartment> userDepartmentList = hbt
						.find("from jkt.hms.masters.business.MasEmployeeDepartment as isc where isc.Employee.Id="
								+ userDepartmentId);
				String flag = (String) generalMap.get("flag");

				for (Iterator iterator = userDepartmentList.iterator(); iterator
						.hasNext();) {
					MasEmployeeDepartment userDepartment = (MasEmployeeDepartment) iterator
							.next();
					if (flag.equals("InActivate")) {
						userDepartment.setStatus("n");
						dataDeleted = true;
					} else if (flag.equals("Activate")) {
						userDepartment.setStatus("y");
						dataDeleted = false;
					}
					hbt.update(userDepartment);
					hbt.refresh(userDepartment);
				}
			}
			tx.commit();
		} catch (HibernateException he) {
			if(tx!=null){
				tx.rollback();
			}
			he.printStackTrace();
		}

		return dataDeleted;
	}

	public Map<String, Object> getEmpName(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = "";
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (dataMap.get("serviceNo") != null) {
			serviceNo = (String) dataMap.get("serviceNo");
		}
		Session session = (Session) getSession();
		List<MasEmployee> empList = new ArrayList<MasEmployee>();
		
		List<Users> checkUser = new ArrayList<Users>();
		
		empList = hbt
				.find("from jkt.hms.masters.business.MasEmployee where ServiceNo='"
						+ serviceNo + "' and Status='y'");
		
		checkUser = hbt
				.find("from jkt.hms.masters.business.Users where UserName='"
						+ serviceNo + "'");
		if(checkUser.size()>0)
		{
			map.put("existuser", true);
		}
		else
		{
			map.put("existuser", false);
		}
		
		map.put("empList", empList);
		return map;
	}

	public Map<String, Object> searchUserDepartment(Box box) {
		List<MasEmployeeDepartment> searchUserDepartmentList = new ArrayList<MasEmployeeDepartment>();
		Map<String, Object> usergroupHospitalFieldsMap = new HashMap<String, Object>();
		List<MasEmployee> userList = new ArrayList<MasEmployee>();
		List<Users> userList1 = new ArrayList<Users>();
		List<MasEmployee> searchUsersList = new ArrayList<MasEmployee>();
		List<MasEmployee> gridUsersList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasDepartment> gridMasDepartmentList = new ArrayList<MasDepartment>();
		
		
		org.hibernate.Criteria criteria = null;
		String userSearch = box.getString("userSearch").trim();
		String loginSearch = box.getString("loginSearch").trim();

		Session session = (Session) getSession();
		try {

			searchUserDepartmentList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasEmployeeDepartment");
			// searchUsersList =
			// getHibernateTemplate().find("select distinct ud.User from jkt.hms.masters.business.UserDepartment ud where ud.User.UserName like '%"+
			// userName+"%' order by ud.User.UserName");
			try {
				criteria = session.createCriteria(MasEmployee.class).add(
						Restrictions.eq("Status", "y"));

				if (userSearch != null & !userSearch.equals("")) {
					criteria = criteria.add(Restrictions.like("ServiceNo", "%"
							+ userSearch + "%"));
				}
			
				searchUsersList = criteria.list();

			} catch (HibernateException e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		
		List<Integer>empId = new ArrayList<Integer>();
		userList1 = session.createCriteria(Users.class)
		.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		
		for(Users listA : userList1)
		{
			if(listA.getEmployee() !=null)
			empId.add(listA.getEmployee().getId());
		}
		
		
		userList = session.createCriteria(MasEmployee.class).add(Restrictions.in("Id", empId)).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		System.out.println("userList="+userList.size());
		
		gridUsersList = session.createCriteria(MasEmployee.class)
				.add(Restrictions.in("Id", empId))
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		
		
		/*userList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasEmployee as mc where mc.Status = 'y'");
		gridUsersList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasEmployee as mc where mc.Status = 'y'");*/
		departmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment as mc where mc.Status = 'y' order by mc.DepartmentName asc");
		gridMasDepartmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment as mc where mc.Status = 'y' order by mc.DepartmentName asc");
		List<MasDivision> divisionList = new ArrayList<MasDivision>();
		List<MasDivision> gridDivisionList = new ArrayList<MasDivision>();
	
		divisionList=session.createCriteria(MasDivision.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("DivisionName")).list();
		gridDivisionList=session.createCriteria(MasDivision.class).list();
		
		usergroupHospitalFieldsMap.put("divisionList", divisionList);
		usergroupHospitalFieldsMap.put("gridDivisionList", gridDivisionList);
		usergroupHospitalFieldsMap.put("searchUserDepartmentList",
				searchUserDepartmentList);
		usergroupHospitalFieldsMap.put("departmentList", departmentList);
		usergroupHospitalFieldsMap.put("gridMasDepartmentList",
				gridMasDepartmentList);
		usergroupHospitalFieldsMap.put("gridUsersList", gridUsersList);
		usergroupHospitalFieldsMap.put("userList", userList);
		usergroupHospitalFieldsMap.put("searchUsersList", searchUsersList);
		return usergroupHospitalFieldsMap;

	}

	public Map<String, Object> searchUserDepartment(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	// ===================== Methods Written by Vivek
	// =========================Start========================

	@SuppressWarnings("unchecked")
	public Map<String, Object> getUrl(Map<String, Object> map) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int appId = 0;
		if (map.get("appId") != null) {
			appId = Integer.parseInt("" + map.get("appId"));
		}
		Session session = (Session) getSession();
		List<UserApplications> userApplicationsList = new ArrayList<UserApplications>();
		if (appId != 0) {
			Criteria c = session.createCriteria(UserApplications.class).add(
					Restrictions.eq("Id", appId));
			userApplicationsList = c.list();
		}
		dataMap.put("userApplicationsList", userApplicationsList);
		return dataMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getParentApplication(Map<String, Object> map) {
		@SuppressWarnings("unused")
		String prAppName = "";
		if (map.get("prAppName") != null) {
			prAppName = "" + map.get("prAppName");
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		String str = "%" + prAppName + "%";
		@SuppressWarnings("unused")
		List<MasApplication> masApplicationList = new ArrayList<MasApplication>();
		Criteria c = session.createCriteria(MasApplication.class)
		// .setFirstResult(0)
				// .setMaxResults(10)
				.add(Restrictions.like("Name", str)).addOrder(
						Order.desc("Name"));
		masApplicationList = c.list();
		dataMap.put("masApplicationList", masApplicationList);
		return dataMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getApplicationForAutoComplete(
			Map<String, Object> map) {
		@SuppressWarnings("unused")
		String appName = "";
		if (map.get("appName") != null) {
			appName = "" + map.get("appName");
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		String str = "%" + appName + "%";
		@SuppressWarnings("unused")
		List<UserApplications> userApplicationsList = new ArrayList<UserApplications>();
		Criteria c = session.createCriteria(UserApplications.class).add(
				Restrictions.eq("Status", "y")).add(
				Restrictions.like("AppName", str));
		userApplicationsList = c.list();
		dataMap.put("userApplicationsList", userApplicationsList);
		return dataMap;

	}

	public boolean addUserApplication(UserApplications userApplications) {
		boolean successfullyAdded = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(userApplications);
			successfullyAdded = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return successfullyAdded;
	}

	public boolean deleteUserApplication(int userApplicationId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		UserApplications userApplications = new UserApplications();
		userApplications = (UserApplications) getHibernateTemplate().get(
				UserApplications.class, userApplicationId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				userApplications.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				userApplications.setStatus("y");
				dataDeleted = false;
			}
		}
		userApplications.setLastChgBy(changedBy);
		userApplications.setLastChgDate(currentDate);
		userApplications.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(userApplications);
		return dataDeleted;
	}

	public boolean editUserApplication(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String applicationName = "";
		String url = "";
		@SuppressWarnings("unused")
		int userApplicationId = 0;
		String changedBy = "";
		userApplicationId = (Integer) generalMap.get("id");
		url = (String) generalMap.get("url");
		applicationName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		UserApplications userApplications = (UserApplications) getHibernateTemplate()
				.get(UserApplications.class, userApplicationId);

		userApplications.setId(userApplicationId);
		userApplications.setUrl(url);
		userApplications.setAppName(applicationName);
		userApplications.setLastChgBy(changedBy);
		userApplications.setLastChgDate(currentDate);
		userApplications.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(userApplications);
		dataUpdated = true;
		return dataUpdated;
	}

	public Map<String, Object> searchUserApplication(String applicationName) {
		List<UserApplications> searchUserApplicationList = new ArrayList<UserApplications>();
		Map<String, Object> userApplicationFieldsMap = new HashMap<String, Object>();
		try {
			if ((applicationName != null)) {
				searchUserApplicationList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.UserApplications mr where mr.AppName like '%"
								+ applicationName + "%' order by mr.AppName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		userApplicationFieldsMap.put("searchUserApplicationList",
				searchUserApplicationList);
		return userApplicationFieldsMap;
	}

	public Map<String, Object> showUserApplicationJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<UserApplications> searchUserApplicationList = new ArrayList<UserApplications>();
		searchUserApplicationList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.UserApplications ");
		map.put("searchUserApplicationList", searchUserApplicationList);
		return map;
	}

	// ADDED by Kalyan
	public Map<String, Object> getSubParentApplication(Map<String, Object> map) {
		@SuppressWarnings("unused")
		String parentId = "";
		if (map.get("parentId") != null) {
			parentId = "" + map.get("parentId");
		}

		Map<String, Object> dataMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<MasApplication> masApplicationList = new ArrayList<MasApplication>();
		Criteria c = session.createCriteria(MasApplication.class)
		// .setFirstResult(0)
				// .setMaxResults(10)
				.add(Restrictions.eq("ParentId", parentId)).addOrder(
						Order.asc("Name"));
		masApplicationList = c.list();
		dataMap.put("masApplicationList", masApplicationList);
		return dataMap;
	}

	// Added by kalyan for Getting user List
	public Map<String, Object> showUserList() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Users> users = new ArrayList<Users>();
		org.hibernate.Criteria criteria = null;
		try {
			criteria = session.createCriteria(Users.class).add(
					Restrictions.eq("Status", "y"));
			users = criteria.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("users", users);
		return map;
	}

	// ===================== Methods Written by Vivek
	// =========================End==========================

	// ==========================methods written by vikas for emp
	// groups================================
	@SuppressWarnings("unchecked")
	public Map<String, Object> showGroupsJsp() {

		Map<String, Object> map = new HashMap<String, Object>();
		List<UserGroups> searchUserGroupsList = new ArrayList<UserGroups>();
		searchUserGroupsList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.EmpGroups ");
		map.put("searchUserGroupsList", searchUserGroupsList);

		return map;
	}

	public Map<String, Object> searchEmpGroups(String empGroupsCode,
			String empGroupsName) {
		List<EmpGroups> searchUserGroupsList = new ArrayList<EmpGroups>();
		Map<String, Object> userGroupsFieldsMap = new HashMap<String, Object>();
		try {
			if ((empGroupsName != null) || (empGroupsCode == null)) {

				searchUserGroupsList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.EmpGroups imc where imc.EmpGroupName like '%"
								+ empGroupsName
								+ "%' order by imc.EmpGroupName");
			} else {
				searchUserGroupsList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.EmpGroups imc where imc.EmpGroupCode like '%"
								+ empGroupsCode
								+ "%' order by imc.EmpGroupCode");
			}
		} catch (Exception e) {
e.printStackTrace();		}
		userGroupsFieldsMap.put("searchUserGroupsList", searchUserGroupsList);
		return userGroupsFieldsMap;
	}

	public boolean addEmpGroups(EmpGroups masUserGroups) {

		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masUserGroups);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unused")
	public boolean editEmpGroupsToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String empGroupsName = "";
		@SuppressWarnings("unused")
		String empGroupsCode = "";
		int empGroupsId = 0;
		String changedBy = "";
		try {
			empGroupsId = (Integer) generalMap.get("id");
			empGroupsCode = (String) generalMap.get("empGroupsCode");
			empGroupsName = (String) generalMap.get("name");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
		} catch (Exception e) {
e.printStackTrace();		}

		EmpGroups masUserGroups = (EmpGroups) getHibernateTemplate().load(
				EmpGroups.class, empGroupsId);

		masUserGroups.setId(empGroupsId);
		masUserGroups.setEmpGroupName(empGroupsName);
		/*
		 * masUserGroups.setLastChgBy(changedBy);
		 * masUserGroups.setLastChgDate(currentDate);
		 * masUserGroups.setLastChgTime(currentTime);
		 */
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(masUserGroups);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unused")
	public boolean deleteEmpGroups(int empGroupId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		EmpGroups masUserGroups = new EmpGroups();
		masUserGroups = (EmpGroups) getHibernateTemplate().get(EmpGroups.class,
				empGroupId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masUserGroups.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masUserGroups.setStatus("y");
				dataDeleted = false;
			}
		}
		masUserGroups.setLastChgBy(changedBy);
		masUserGroups.setLastChgDate(currentDate);
		masUserGroups.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(masUserGroups);
		return dataDeleted;
	}

	// ============method added to add the employee groups for the
	// users========================
	@SuppressWarnings("unchecked")
	public boolean addUser(Users users, String[] empGroupIdArray, Map generalMap) {

		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(users);
		String changedBy = (String) generalMap.get("changedBy");
		Date currentDate = new Date();
		String currentTime = (String) generalMap.get("currentTime");
		int hospitalId = (Integer) generalMap.get("hospitalId");
		for (int i = 0; i < empGroupIdArray.length; i++) {
			UserEmpGroup userEmpGroup = new UserEmpGroup();
			userEmpGroup.setUser(users);
			EmpGroups empGroups = new EmpGroups();
			empGroups.setId(Integer.parseInt(empGroupIdArray[i]));
			userEmpGroup.setEmpGroup(empGroups);
			userEmpGroup.setStatus("y");
			userEmpGroup.setLastChgBy(changedBy);
			userEmpGroup.setLastChgDate(currentDate);
			userEmpGroup.setLastChgTime(currentTime);
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			userEmpGroup.setHospital(masHospital);
			hbt.save(userEmpGroup);
		}

		successfullyAdded = true;
		return successfullyAdded;
	}

	// -------------------end of methods for emp groups-------------------

	// ============method added by vikas 0n
	// 29/04/09===================================

	public Map<String, Object> showButtonMasterJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasHospital> searchButtonDetailsList = new ArrayList<MasHospital>();
		searchButtonDetailsList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasButtonForm ");
		map.put("searchButtonDetailsList", searchButtonDetailsList);
		return map;
	}

	public boolean addButtonDetails(MasButtonForm masButtonForm) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masButtonForm);
		successfullyAdded = true;
		return successfullyAdded;

	}

	public boolean editButtonDetails(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String formName = "";
		@SuppressWarnings("unused")
		String buttonName = "";
		int masButtonId = 0;
		String changedBy = "";
		String url = "";
		String cssClass = "";
		String formulaUsed = "";
		try {
			masButtonId = (Integer) generalMap.get("id");
			buttonName = (String) generalMap.get("buttonName");
			formName = (String) generalMap.get("name");
			url = (String) generalMap.get("url");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			cssClass = (String) generalMap.get("cssClass");
			formulaUsed = (String) generalMap.get("formulaUsed");
		} catch (Exception e) {
e.printStackTrace();		}

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			MasButtonForm masButtonForm = (MasButtonForm) hbt.load(
					MasButtonForm.class, masButtonId);

			// masButtonForm.setId(empGroupsId);
			masButtonForm.setButtonName(buttonName);
			masButtonForm.setFormName(formName);
			masButtonForm.setUrl(url);
			masButtonForm.setLastChgBy(changedBy);
			masButtonForm.setLastChgDate(currentDate);
			masButtonForm.setLastChgTime(currentTime);
			masButtonForm.setClassName(cssClass);
			masButtonForm.setFormulaUsed(formulaUsed);
			hbt.update(masButtonForm);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	public boolean deleteButtonDetails(int buttonId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasButtonForm masButtonForm = new MasButtonForm();
		masButtonForm = (MasButtonForm) getHibernateTemplate().get(
				MasButtonForm.class, buttonId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masButtonForm.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masButtonForm.setStatus("y");
				dataDeleted = false;
			}
		}
		masButtonForm.setLastChgBy(changedBy);
		masButtonForm.setLastChgDate(currentDate);
		masButtonForm.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(masButtonForm);
		return dataDeleted;
	}

	public Map<String, Object> getUerGroupDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Users> userList = new ArrayList<Users>();
		List<UserEmpGroup> userEmpList = new ArrayList<UserEmpGroup>();
		List<UserGroups> AlluserEmpList = new ArrayList<UserGroups>();
		String loginUser = box.getString("loginName");
		Session session = (Session) getSession();
		userList = session.createCriteria(Users.class).add(
				Restrictions.eq("LoginName", loginUser)).list();
		int userId = 0;
		for (Users user : userList) {
			userId = user.getId();
		}

		userEmpList = session.createCriteria(UserEmpGroup.class).add(
				Restrictions.eq("User.Id", userId)).list();
		AlluserEmpList = session.createCriteria(UserGroups.class).add(
				Restrictions.eq("Status", "y")).list();

		// map.put("searchButtonDetailsList",searchButtonDetailsList);
		map.put("userEmpList", userEmpList);
		map.put("AlluserEmpList", AlluserEmpList);
		map.put("userId", userId);
		return map;
	}

	public boolean addUser(Users users, String[] empGroupIdArray,
			String[] appGroupIdArray, Map generalMap, int hospitalId) {

		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(users);
		hbt.refresh(users);
		int userId = (Integer) users.getId();
		String changedBy = (String) generalMap.get("changedBy");
		int deptId = (Integer) generalMap.get("deptId");
		Date currentDate = new Date();
		String currentTime = (String) generalMap.get("currentTime");
		for (int i = 0; i < empGroupIdArray.length; i++) {
			UserEmpGroup userEmpGroup = new UserEmpGroup();
			userEmpGroup.setUser(users);
			EmpGroups empGroups = new EmpGroups();
			empGroups.setId(Integer.parseInt(empGroupIdArray[i]));
			userEmpGroup.setEmpGroup(empGroups);
			userEmpGroup.setStatus("y");
			userEmpGroup.setLastChgBy(changedBy);
			userEmpGroup.setLastChgDate(currentDate);
			userEmpGroup.setLastChgTime(currentTime);
			hbt.save(userEmpGroup);
		}
		Users usersObj = (Users) hbt.load(Users.class, userId);
		// int departmentId=usersObj.getEmployee().getDepartment().getId();
		UserDepartment userDepartment = new UserDepartment();
		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(deptId);
		userDepartment.setDepartment(masDepartment);
		Users userObject = new Users();
		userObject.setId(usersObj.getId());
		userDepartment.setUser(userObject);
		userDepartment.setStatus("y");
		hbt.save(userDepartment);

		if (appGroupIdArray != null) {
			for (int i = 0; i < appGroupIdArray.length; i++) {

				List<UsergroupHospital> groupHospitalIdList = new ArrayList<UsergroupHospital>();
				groupHospitalIdList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.UsergroupHospital as ugh where ugh.Hospital.Id ="
										+ hospitalId
										+ "and ugh.Group.Id="
										+ appGroupIdArray[i]);
				if (groupHospitalIdList != null
						&& groupHospitalIdList.size() > 0) {
					UsergroupHospital usergroupHospital = (UsergroupHospital) groupHospitalIdList
							.get(0);
					UserUsergroupHospital masUserUsergroupHospital = new UserUsergroupHospital();
					masUserUsergroupHospital.setUser(users);
					int groupHospitalId = usergroupHospital.getId();

					masUserUsergroupHospital
							.setGroupHospital(new UsergroupHospital(
									groupHospitalId));
					// masUserUsergroupHospital.setValidUpto(null);
					masUserUsergroupHospital.setStatus("y");
					masUserUsergroupHospital.setLastChgBy(changedBy);
					masUserUsergroupHospital.setLastChgDate(currentDate);
					masUserUsergroupHospital.setLastChgTime(currentTime);
					hbt.save(masUserUsergroupHospital);
					hbt.refresh(masUserUsergroupHospital);
				}
			}
		}
		successfullyAdded = true;
		return successfullyAdded;
	}


	/*
	 * public boolean encryptAllUserPassword() { boolean
	 * successfullyAdded=false;
	 * org.springframework.orm.hibernate3.HibernateTemplate hbt =
	 * getHibernateTemplate(); hbt.setFlushModeName("FLUSH_EAGER");
	 * hbt.setCheckWriteOperations(false); Session session =
	 * (Session)getSession(); String loginUser="1111"; List<Users> userList= new
	 * ArrayList<Users>(); userList=session.createCriteria(Users.class).list();
	 * System
	 * .out.println("size of user list in encryptAllUserPassword===="+userList
	 * .size()); for(Users user:userList){ int userId=user.getId();
	 * //System.out.println("user id value====="+userId); Users
	 * userObj=(Users)hbt.load(Users.class, userId); String
	 * encryptedPassword=HMSUtil.encryptPassword(userObj.getPassword());
	 * //System.out.println("encrypted pass====="+encryptedPassword);
	 * userObj.setPassword(encryptedPassword); hbt.update(userObj);
	 * successfullyAdded=true; }
	 * 
	 * 
	 * return successfullyAdded; }
	 */
	// ========================================methods written by
	// vikas=====================================
	// ///////////////////Security Template Issue///////////////////////////

	@SuppressWarnings("unchecked")
	public List<MasApplication> getModuleListForTemplate() {
		List<MasApplication> moduleList = new ArrayList<MasApplication>();
		session = (Session) getSession();
		moduleList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasApplication where ParentId='"
						+ 0 + "' order by name ASC");
		return moduleList;
	}

	@SuppressWarnings("unchecked")
	public List<MasTemplate> getTemplateList() {
		List<MasTemplate> templateList = new ArrayList<MasTemplate>();
		session = (Session) getSession();
		templateList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasTemplate where Status='y' order by TemplateName asc");
		return templateList;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> populateApplications(String parentId,
			String templateId) {
		Map<String ,Object> map= new HashMap<String, Object>();
		try{
			Session session = (Session)getSession();
		//	List<GroupApplication>appList = new ArrayList<GroupApplication>();
			List<Object[]> applicationNameList = new ArrayList<Object[]>();
			List<Object[]> existingNameList = new ArrayList<Object[]>();
			List<MasApplication> masApp = new ArrayList<MasApplication>();
		//	appList= session.createCriteria(GroupApplication.class).add(Restrictions.eq("Status", "y")).list();
			String qry = "select ma1.name,ma1.parent_id,ma1.app_id,ma1.url,ma2.name as aaaa from mas_application ma1" +
					" left join mas_application ma2 on ma1.parent_id=ma2.app_id" +
					" where ma1.parent_id='"+parentId+"'" +
					" union all " +
					" select ma1.name,ma1.parent_id,ma1.app_id,ma1.url,ma2.name as aaaa from mas_application ma1" +
					" left join mas_application ma2 on ma1.parent_id=ma2.app_id" +
					" where ma1.parent_id in ( select app_id from mas_application where parent_id='"+parentId+"' ) "
					+" union all " +
					" select ma1.name,ma1.parent_id,ma1.app_id,ma1.url,ma2.name as aaaa from mas_application ma1" +
					" left join mas_application ma2 on ma1.parent_id=ma2.app_id" +
					" where ma1.app_id ='"+parentId+"'";
			applicationNameList = (List) session.createSQLQuery(qry).list();
			
			masApp  = session.createCriteria(MasApplication.class)
			                     .add(Restrictions.eq("ParentId", parentId))
			                     .add(Restrictions.eq("Url", "#")).list();
			String par = "";
			
			if(parentId != null && !parentId.equals(""))
				par = par +"'"+ parentId+"'";
			for(MasApplication masAp : masApp){
				if(par.length() == 0)
				par = par + "'"+masAp.getId()+"'";
				else
					par = par + ",'" + masAp.getId()+"'";				
			}
			
			
			String existqry = " SELECT m.parent_id,t.app_id,t.template_id FROM template_application t,mas_application m where t.app_id = m.app_id" +
					          " and template_id = '"+templateId+"' and m.parent_id in ("+par+")";
			existingNameList = (List) session.createSQLQuery(existqry).list();
			//map.put("appList", appList);
			map.put("applicationNameList", applicationNameList);
			map.put("existingNameList", existingNameList);
		    
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showTemplateJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasTemplate> searchTemplateList = new ArrayList<MasTemplate>();
		List<MasEmpCategory> masEmpCategoryList = new ArrayList<MasEmpCategory>();
		List<MasTemplate> masTemplateList = new ArrayList<MasTemplate>();
		searchTemplateList = getHibernateTemplate().find("from jkt.hms.masters.business.MasTemplate ");
		masTemplateList= getHibernateTemplate().find("from jkt.hms.masters.business.MasTemplate tt order by tt.TemplateName asc");
		masEmpCategoryList = getHibernateTemplate().find(
		"from jkt.hms.masters.business.MasEmpCategory empCat where  empCat.Status ='y'  order by empCat.EmpCategoryName asc");
		
		map.put("searchTemplateList", searchTemplateList);
		map.put("masTemplateList", masTemplateList);
		map.put("masEmpCategoryList", masEmpCategoryList);
		return map;
	}

	public boolean addTemplate(MasTemplate masTemplate) {

		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masTemplate);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unused")
	public boolean editTemplate(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String templateName = "";
		@SuppressWarnings("unused")
		String templateCode = "";
		int deptId = 0;
		int hospitalId = 0;
		int templateId = 0;
		String changedBy = "";
		String status = "";

		int parentId=0;
		int employeeCategoryId=0;
		
		try {
			templateId = (Integer) generalMap.get("id");
			templateCode = (String) generalMap.get("templateCode");
			templateName = (String) generalMap.get("templateName");
			deptId = (Integer) generalMap.get("deptId");
			hospitalId = (Integer) generalMap.get("hospitalId");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			
			if(generalMap.get("parentId")!=null){
				parentId=(Integer) generalMap.get("parentId");
			}
			if(generalMap.get("employeeCategoryId")!=null){
				employeeCategoryId=(Integer) generalMap.get("employeeCategoryId");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		MasTemplate masTemplate = (MasTemplate) getHibernateTemplate().get(
				MasTemplate.class, templateId);

		masTemplate.setId(templateId);
		masTemplate.setTemplateCode(templateCode);
		masTemplate.setTemplateName(templateName);
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		masTemplate.setHospital(masHospital);
		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(deptId);
		masTemplate.setDept(masDepartment);
		masTemplate.setStatus("y");
		if(parentId>0){
			MasTemplate masTemplate2=new MasTemplate();
			masTemplate2.setId(parentId);
			masTemplate.setTemplate(masTemplate2);
		}
		if(employeeCategoryId>0){
			MasEmpCategory masEmpCategory=new MasEmpCategory();
			masEmpCategory.setId(employeeCategoryId);
			masTemplate.setEmpCategory(masEmpCategory);
		}
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(masTemplate);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings( { "unused", "unchecked" })
	public Map<String, Object> searchTemplate(String templateCode,
			String templateName) {
		List<MasTemplate> searchTemplateList = new ArrayList<MasTemplate>();
		Map<String, Object> userGroupsFieldsMap = new HashMap<String, Object>();
		try {
			if ((templateName != null) || (templateCode == null)) {

				searchTemplateList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasTemplate imc where imc.TemplateName like '"
										+ templateName
										+ "%' order by imc.TemplateName");
			} else {
				searchTemplateList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasTemplate imc where imc.TemplateCode like '"
										+ templateCode
										+ "%' order by imc.TemplateCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		userGroupsFieldsMap.put("searchTemplateList", searchTemplateList);
		return userGroupsFieldsMap;
	}

	public boolean deleteTemplate(int templateId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasTemplate masTemplate = new MasTemplate();
		masTemplate = (MasTemplate) getHibernateTemplate().get(
				MasTemplate.class, templateId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masTemplate.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masTemplate.setStatus("y");
				dataDeleted = false;
			}
		}
		masTemplate.setLastChgBy(changedBy);
		masTemplate.setLastChgDate(currentDate);
		masTemplate.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(masTemplate);
		return dataDeleted;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getGroupApplicationArray(String applicationId,
			int templateId) {
		Session session = (Session) getSession();
		@SuppressWarnings("unused")
		String[] applicationArray = null;
		List<MasApplication> appList = new ArrayList<MasApplication>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasApplication> groupAppArrayList = new ArrayList<MasApplication>();
		appList = session.createCriteria(MasApplication.class).add(
				Restrictions.eq("Id", applicationId)).list();
		MasApplication masApplication = appList.get(0);
		groupAppArrayList.add(masApplication);
		map.put("groupAppArrayList", groupAppArrayList);
		return map;
	}

	@SuppressWarnings({"unchecked","unused"})
	public boolean submitTemplateWiseApplication(Map<String, Object> map) {
		int templateId = (Integer) map.get("templateId");
		String parentId = (String) map.get("parentId");
		@SuppressWarnings("unused")
		String appId = (String) map.get("appId");
	//	Integer buttonId = (Integer)map.get("buttonId");
		List groupApplicationList = (List) map.get("groupApplicationList");
		List<TemplateApplication> application = new ArrayList<TemplateApplication>();
		List buttonList = (List) map.get("buttonList");
		List<TemplateApplication> buttonApp = new ArrayList<TemplateApplication>();
		Session session = (Session) getSession();
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
		String userName = (String) map.get("userName");
		TemplateApplication templateApp;
		boolean successfullyAdded = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			System.out.println("parentId-2961--ds---->"+parentId);
			
			List<Object[]> applicationNameList = new ArrayList<Object[]>();
			String qry = "select ma1.name,ma1.parent_id,ma1.app_id,ma1.url,ma2.name as aaaa from mas_application ma1" +
			" left join mas_application ma2 on ma1.parent_id=ma2.app_id" +
			" where ma1.parent_id='"+parentId+"'" +
			" union all " +
			" select ma1.name,ma1.parent_id,ma1.app_id,ma1.url,ma2.name as aaaa from mas_application ma1" +
			" left join mas_application ma2 on ma1.parent_id=ma2.app_id" +
			" where ma1.parent_id in ( select app_id from mas_application where parent_id='"+parentId+"' ) "
			+" union all " +
			" select ma1.name,ma1.parent_id,ma1.app_id,ma1.url,ma2.name as aaaa from mas_application ma1" +
			" left join mas_application ma2 on ma1.parent_id=ma2.app_id" +
			" where ma1.app_id ='"+parentId+"'";
	
			applicationNameList = (List) session.createSQLQuery(qry).list();
			int deleteCnt=0;
			if(groupApplicationList.size()>0){
				if(applicationNameList.size()>0){
					for(Object[] masApplication : applicationNameList){
						if(!(masApplication[2]).equals("0"))
						{
							++deleteCnt;
							String hql = "delete from TemplateApplication as uuga where uuga.App.Id = '"
								+ masApplication[2] + "' and uuga.Template.Id='"
								+ templateId + "'";
							Query query = session.createQuery(hql);
							@SuppressWarnings("unused")
							int row = query.executeUpdate();
						}
					}
				}
			}
			
			System.out.println("deleteCnt-->"+deleteCnt);
			/*if (groupApplicationList.size() > 0) {
				application = session.createCriteria(TemplateApplication.class)
								.createAlias("App", "App").add(
								Restrictions.eq("App.ParentId", parentId)).add(
								Restrictions.eq("Template.Id", templateId))
								.list();
				System.out.println("application-->"+application.size());
				for (TemplateApplication tempApp : application) {
					String hql = "delete from TemplateApplication as uuga where uuga.App.Id = '"
							+ tempApp.getApp().getId() + "'";
					Query query = session.createQuery(hql);
					@SuppressWarnings("unused")
					int row = query.executeUpdate();
				}
			}*/
			if(buttonList.size() > 0){
				Iterator iterator = buttonList.iterator();
				while (iterator.hasNext()) {
					int buttonId = (Integer) iterator.next();
				buttonApp = session.createCriteria(TemplateApplication.class).createAlias("ButtonForm", "ButtonForm").add(Restrictions.eq("ButtonForm.Id", buttonId)).add(
								Restrictions.eq("Template.Id", templateId))
						.list();
				for (TemplateApplication tempApp : buttonApp) {
					String hql = "delete from TemplateApplication as uuga where uuga.ButtonForm.Id = '"
						+ tempApp.getButtonForm().getId() + "'";
					Query query = session.createQuery(hql);
					int row = query.executeUpdate();
				}
				}
			}
			System.out.println("groupApplicationList.size()-->"+groupApplicationList.size());
			if (groupApplicationList != null && groupApplicationList.size() > 0) {
				Iterator iterator = groupApplicationList.iterator();
				while (iterator.hasNext()) {
					templateApp = new TemplateApplication();
					String applicationId = (String) iterator.next();
					applicationId.contains(parentId);
					MasTemplate masTemplate = new MasTemplate();
					masTemplate.setId(templateId);
					templateApp.setTemplate(masTemplate);
					MasApplication masApplication = new MasApplication();
					masApplication.setId(applicationId);
					templateApp.setApp(masApplication);
					templateApp.setLastChgBy(userName);
					templateApp.setLastChgDate(currentDate);
					templateApp.setLastChgTime(currentTime);
					templateApp.setStatus("y");
					hbt.save(templateApp);

					successfullyAdded = true;

				}
			}
			if (buttonList != null && buttonList.size() > 0) {
				Iterator iterator1 = buttonList.iterator();
				while (iterator1.hasNext()) {
					templateApp = new TemplateApplication();
					Integer buttonsId = (Integer)iterator1.next();
					MasTemplate masTemplate = new MasTemplate();
					masTemplate.setId(templateId);
					templateApp.setTemplate(masTemplate);
					MasButtonForm masButtonForm = new MasButtonForm();
					masButtonForm.setId(buttonsId);
					templateApp.setButtonForm(masButtonForm);
					templateApp.setLastChgBy(userName);
					templateApp.setLastChgDate(currentDate);
					templateApp.setLastChgTime(currentTime);
					templateApp.setStatus("y");
					hbt.save(templateApp);

					successfullyAdded = true;

				}
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return successfullyAdded;

	}

	@SuppressWarnings("unchecked")
	public List<EmpGroups> getEmpGroupForTemplate() {
		List<EmpGroups> empGroupList = new ArrayList<EmpGroups>();
		session = (Session) getSession();
		empGroupList = session.createCriteria(EmpGroups.class).add(
				Restrictions.eq("Status", "y")).addOrder(Order.asc("EmpGroupName")).list();
		return empGroupList;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getUserList(int empGroup) {

		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<Object[]> empGrpList = new ArrayList<Object[]>();
		try {
			String qry = "SELECT login_name,user_id FROM users where user_id in (select user_id from user_emp_group where emp_group_id ='"
					+ empGroup
					+ "' and user_id not in(SELECT user_id FROM user_template))";
			empGrpList = (List) session.createSQLQuery(qry).list();
			// empGrpList =
			// session.createQuery(" from UserEmpGroup as masApp where EmpGroup.Id = "+empGroup).list();
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("empGrpList", empGrpList);

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getTemplateApplicationList(int templateId,
			int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<TemplateApplication> tempAppList = new ArrayList<TemplateApplication>();
		List<GroupApplication> groupAppList = new ArrayList<GroupApplication>();
		@SuppressWarnings("unused")
		List<GroupApplication> grpApplicationList = new ArrayList<GroupApplication>();
		List<UsergroupHospital> userGrpHospitalList = new ArrayList<UsergroupHospital>();
		List<Object> grpAppList = new ArrayList<Object>();
		List<Object> grpIdList = new ArrayList<Object>();
		List<Object> usrGrpHospList = new ArrayList<Object>();
	//	List<Integer> buttonTemplateList = new ArrayList<Integer>();
		String applicationId = "";
		int groupId = 0;
		int grpAppId = 0;
		int usergrpHospId = 0;
		try {
			/**
			 * Commented by ritu on 20 aug 2015
			 */
			/*String query ="select distinct(button_id) from template_application where template_id='"+templateId+"' and button_id is not null";
			buttonTemplateList = (List) session.createSQLQuery(query).list();
		*/
			tempAppList = session.createQuery(
					" from TemplateApplication as tempApp where Template.Id = "
							+ templateId).list();

			for (Iterator iterator = tempAppList.iterator(); iterator.hasNext();) {
				TemplateApplication tempApp = (TemplateApplication) iterator
						.next();
				if(tempApp.getApp() != null){
					applicationId = tempApp.getApp().getId();
				}
				
				groupAppList = (List<GroupApplication>) session.createCriteria(
						GroupApplication.class).createAlias("App", "app").add(
						Restrictions.eq("app.Id", applicationId)).add(Restrictions.eq("Status","y")).list();

				for (Iterator iterator1 = groupAppList.iterator(); iterator1
						.hasNext();) {
					GroupApplication grpApp = (GroupApplication) iterator1
							.next();
					groupId = grpApp.getGroup().getId();
					grpAppId = grpApp.getId();
					grpAppList.add(grpAppId);
					grpIdList.add(groupId);
					/*grpApplicationList = (List<GroupApplication>) session
							.createCriteria(GroupApplication.class)
							.createAlias("App", "app").add(
									Restrictions.eq("app.Id", applicationId))
							.createAlias("Group", "grp").add(
									Restrictions.eq("grp.Id", groupId)).list();
					for (Iterator iterator2 = grpApplicationList.iterator(); iterator2
							.hasNext();) {
						GroupApplication grpApplication = (GroupApplication) iterator2
								.next();
						grpAppId = grpApplication.getId();
						grpAppList.add(grpAppId);
					}*/
					
					userGrpHospitalList = (List<UsergroupHospital>) session
					.createCriteria(UsergroupHospital.class)
					.createAlias("Hospital", "hsp").add(
							Restrictions.eq("hsp.Id", hospitalId))
					.createAlias("Group", "grp").add(
							Restrictions.eq("grp.Id", groupId)).addOrder(Order.desc("Id")).list();					
					//usrGrpHospList.add(userGrpHospitalList.get(0).getId());
					/*for (Iterator iterator3 = userGrpHospitalList.iterator(); iterator3
							.hasNext();) {
						UsergroupHospital usrgrpHosp = (UsergroupHospital) iterator3
								.next();
						usergrpHospId = usrgrpHosp.getId();
						usrGrpHospList.add(usergrpHospId);
					}*/
					

				}
			}
			
			

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		map.put("grpAppList", grpAppList);
		map.put("usrGrpHospList", usrGrpHospList);
		//map.put("tempAppList", tempAppList);
	//	map.put("groupAppList", groupAppList);
		//map.put("buttonTemplateList", buttonTemplateList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean addUserWiseTemplate(Map<String, Object> dataMap) {
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		boolean successfullyAdded = false;
		List<Object> usrGrpHospList = new ArrayList<Object>();
		List<Object> grpAppList = new ArrayList<Object>();
		List<Integer> userIdList = new ArrayList<Integer>();
		usrGrpHospList = (List<Object>) dataMap.get("usrGrpHospList");
		grpAppList = (List<Object>) dataMap.get("grpAppList");
		userIdList = (List<Integer>) dataMap.get("userIdList");
		int templateId = (Integer) dataMap.get("templateId");
		int hospitalId = (Integer) dataMap.get("hospitalId");
		int empGroupId = (Integer) dataMap.get("empGroupId");
		/*List<Integer> buttonTemplateList = new ArrayList<Integer>();
		buttonTemplateList = (List<Integer>) dataMap.get("buttonTemplateList");
		List<Integer> DepartmentTemplateList = new ArrayList<Integer>();
		DepartmentTemplateList = (List<Integer>) dataMap.get("DepartmentTemplateList");*/
		
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String userName = (String) dataMap.get("userName");

		if (userIdList.size() > 0) {
			for (int j = 0; j < userIdList.size(); j++) {
				for (int i = 0; i < grpAppList.size(); i++) {
					UserUsergroupApplication userUserGroupApp = new UserUsergroupApplication();
					if (grpAppList.get(i) != null && !grpAppList.get(i).equals("")) {
						GroupApplication grpApp = new GroupApplication();
						int grpAppId = Integer.parseInt(grpAppList.get(i).toString());
						grpApp.setId(grpAppId);
						userUserGroupApp.setGroupApp(grpApp);

						UsergroupHospital usergroupHospital = new UsergroupHospital();
						int userGrpHospId = Integer.parseInt(usrGrpHospList.get(i).toString());
						usergroupHospital.setId(userGrpHospId);
						userUserGroupApp.setGroupHospital(usergroupHospital);

						Users users = new Users();
						int userId = Integer.parseInt(userIdList.get(j).toString());
						users.setId(userId);
						userUserGroupApp.setUser(users);
						userUserGroupApp.setStatus("y");

					}

					try {
						hbt.save(userUserGroupApp);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				try {
					UserTemplate userTemplate = new UserTemplate();

					Users user = new Users();
					int userId = Integer.parseInt(userIdList.get(j).toString());
					user.setId(userId);
					userTemplate.setUser(user);

					MasTemplate masTemplate = new MasTemplate();
					masTemplate.setId(templateId);
					userTemplate.setTemplate(masTemplate);

					MasHospital masHospital = new MasHospital();
					masHospital.setId(hospitalId);
					userTemplate.setHospital(masHospital);

					EmpGroups empGroups = new EmpGroups();
					empGroups.setId(empGroupId);
					userTemplate.setEmpGroup(empGroups);

					userTemplate.setStatus("y");
					userTemplate.setLastChgBy(userName);
					userTemplate.setLastChgDate(currentDate);
					userTemplate.setLastChgTime(currentTime);
					hbt.save(userTemplate);
					successfullyAdded = true;
				} catch (NumberFormatException e) {
					successfullyAdded = false;
					e.printStackTrace();
				} catch (DataAccessException e) {
					successfullyAdded = false;
					e.printStackTrace();
				}
			

			/*
			 * code for giving button level rights
			 */
			/*	for (int k = 0; k < buttonTemplateList.size(); k++) {
					UserButtonRights userButtonRights = new UserButtonRights();
					if (buttonTemplateList.get(k) != null && !buttonTemplateList.get(k).equals("")) {
						MasButtonForm masButtonForm = new MasButtonForm();
						int buttonId = Integer.parseInt(buttonTemplateList.get(k).toString());
						masButtonForm.setId(buttonId);
						userButtonRights.setButton(masButtonForm);

						EmpGroups empGroups = new EmpGroups();
						empGroups.setId(empGroupId);
						userButtonRights.setEmpGroup(empGroups);


						Users users = new Users();
						int userId = Integer.parseInt(userIdList.get(j).toString());
						users.setId(userId);
						userButtonRights.setUser(users);
					}
					try {
						hbt.save(userButtonRights);
						successfullyAdded = true;
					} catch (DataAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						successfullyAdded = false;
					}
				}
				//code for department level 
				for (int k = 0; k < DepartmentTemplateList.size(); k++) {
					UserDepartment userDepartment = new UserDepartment();
					if (DepartmentTemplateList.get(k) != null && !DepartmentTemplateList.get(k).equals("")) {
						MasDepartment masDepartment = new MasDepartment();
						int deptId = Integer.parseInt(DepartmentTemplateList.get(k).toString());
						masDepartment.setId(deptId);
						userDepartment.setDepartment(masDepartment);
						Users users = new Users();
						int userId = Integer.parseInt(userIdList.get(j).toString());
						users.setId(userId);
						userDepartment.setUser(users);
						userDepartment.setStatus("y");
					}
					try {
						hbt.save(userDepartment);
						successfullyAdded = true;
					} catch (DataAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						successfullyAdded = false;
					}
				}*/
				
			}	
		}

		return successfullyAdded;
	}
	
	@SuppressWarnings("unchecked")
	public List<UserTemplate> getUsersListFromUserTemplate(int templateId,
			int empGroupId) {
		Session session = (Session) getSession();
		List<UserTemplate> userTemplateList = new ArrayList<UserTemplate>();
		userTemplateList = session.createCriteria(UserTemplate.class)
				.createAlias("Template", "template").add(
						Restrictions.eq("template.Id", templateId))
				.createAlias("EmpGroup", "empGroup").add(
						Restrictions.eq("empGroup.Id", empGroupId)).add(
						Restrictions.eq("Status", "y")).list();
		return userTemplateList;
	}

	@SuppressWarnings("unchecked")
	public boolean editUserWiseTemplate(Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		boolean successfullyAdded = false;
		List<Object> usrGrpHospList = new ArrayList<Object>();
		List<Object> grpAppList = new ArrayList<Object>();
		usrGrpHospList = (List<Object>) dataMap.get("usrGrpHospList");
		grpAppList = (List<Object>) dataMap.get("grpAppList");
		List<Integer>buttonTemplateList = new ArrayList<Integer>();
		buttonTemplateList = (List<Integer>)dataMap.get("buttonTemplateList");
		

		int templateId = (Integer) dataMap.get("templateId");
		int empGroupId = (Integer) dataMap.get("empGroupId");
		List<Integer> userTempUserid = (List<Integer>) dataMap.get("userTempUserid");

		int grpAppId = 0;
		int userGroupHospId = 0;
		int indexNo=0;
		try{
		for(Integer unSelectedUserId : userTempUserid ){
			for(Object grpApp : grpAppList){
				if(indexNo<usrGrpHospList.size()){
				String hql1 = "delete from UserUsergroupApplication as uuga where uuga.User.Id like :userTempUserid and uuga.GroupApp.Id like :grpAppId and uuga.GroupHospital.Id like :userGroupHospId";
				Query query1 = session.createQuery(hql1).setParameter(
						"userTempUserid", unSelectedUserId).setParameter(
						"grpAppId", Integer.parseInt(grpApp.toString())).setParameter("userGroupHospId",
								usrGrpHospList.get(indexNo));
				int row1 = query1.executeUpdate();
				indexNo++;	
				}
			}
			String hqlForUserTemplate ="delete from UserTemplate as ut where ut.User.Id = "+unSelectedUserId +" and ut.Template.Id = "
			                            +templateId +" and ut.EmpGroup.Id = "+empGroupId +" and  ut.Status = 'y' " ;
			Query query2 = session.createQuery(hqlForUserTemplate);
			int rowDeleted1 = query2.executeUpdate();
			
			for(Integer buttonId : buttonTemplateList){
			String hqlForButtonRight = " delete from UserButtonRights  as ubr where ubr.Button.Id = "+buttonId+
			                            " and ubr.EmpGroup.Id ="+empGroupId +" and ubr.User.Id = "+ unSelectedUserId ;
			Query query3 = session.createQuery(hqlForButtonRight);
			int rowDeleted2 = query2.executeUpdate();
			 
			}
				
		}
		successfullyAdded = true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			successfullyAdded = false;
			
		}
		/*for (int i = 0; i < grpAppList.size(); i++) {
			grpAppId = (Integer) grpAppList.get(i);

			for (int j = 0; j < usrGrpHospList.size(); j++) {
				userGroupHospId = (Integer) usrGrpHospList.get(j);

				String hql1 = "delete from UserUsergroupApplication as uuga where uuga.User.Id like :userTempUserid and uuga.GroupApp.Id like :grpAppId and uuga.GroupHospital.Id like :userGroupHospId";
				Query query1 = session.createQuery(hql1).setParameter(
						"userTempUserid", userTempUserid).setParameter(
						"grpAppId", grpAppId).setParameter("userGroupHospId",
						userGroupHospId);
				int row1 = query1.executeUpdate();
				if (row1 > 0) {
					successfullyAdded = true;
				}

			}

		}
		
		String hql = "delete from UserTemplate as uuga where uuga.User.Id like :userTempUserid and uuga.Template.Id like :templateId  and uuga.EmpGroup.Id like :empGroupId";
		Query query = session.createQuery(hql).setParameter("userTempUserid",
				userTempUserid).setParameter("templateId", templateId)
				.setParameter("empGroupId", empGroupId);
		int row = query.executeUpdate();
		if (row > 0) {
			successfullyAdded = true;
		}*/
		
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> checkUserListFromUserTemplate(int templateId,
			int userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<UserTemplate> checkExistingUserList = new ArrayList<UserTemplate>();
		checkExistingUserList = session.createCriteria(UserTemplate.class)
				.createAlias("Template", "template").add(
						Restrictions.eq("template.Id", templateId))
				.createAlias("User", "user").add(
						Restrictions.eq("user.Id", userId)).add(
						Restrictions.eq("Status", "y")).list();
		map.put("checkExistingUserList", checkExistingUserList);
		
		return map;
	}

	public Map<String, Object> getTemplateModuleList(String templateId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasTemplate> templateList = new ArrayList<MasTemplate>();
		List<Object[]> tempModuleList = new ArrayList<Object[]>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		session = (Session) getSession();
		String Query = "select t.template_id,m.app_id,m.name from template_application t,mas_application m"
				+ " where t.app_id = m.app_id and m.parent_id = '0' and t.template_id = '"
				+ templateId + "' group by t.template_id,m.app_id,m.name ";
		String Query2 = "select * from mas_department where status = 'y'";
		// templateList =
		// getHibernateTemplate().find("from jkt.hms.masters.business.TemplateApplication where Status='y'"
		// );
		tempModuleList = (List) session.createSQLQuery(Query).list();
		templateList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasTemplate where Status='y'");
		departmentList = (List) session.createSQLQuery(Query2).list();
		map.put("tempModuleList", tempModuleList);
		map.put("templateList", templateList);
		map.put("departmentList", departmentList);
		return map;
	}

	/**
	 * new code to add button level security
	 */
	@SuppressWarnings("unchecked")
	public List<MasButtonForm> getFormList() {
		
		List<MasButtonForm> formList = new ArrayList<MasButtonForm>();
		session = (Session) getSession();
		//formList = session.createSQLQuery("select Distinct(form_name) from  mas_button_form where status='y';").list();
		//formList =session.createCriteria(MasButtonForm.class)
		formList =getHibernateTemplate().find("select Distinct(mbf.ButtonName) from jkt.hms.masters.business.MasButtonForm as mbf where mbf.Status='y'");
		
		return formList;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> getButtonList(String formName) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Session session = (Session) getSession();
			String status = "y";
			List<MasButtonForm> buttonList = new ArrayList<MasButtonForm>();
			buttonList = session.createCriteria(MasButtonForm.class).add(
					Restrictions.eq("FormName", formName)).add(
					Restrictions.eq("Status", status)).list();
			map.put("buttonList", buttonList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	public boolean addApplicationGroup(MasApplicationgroup masApplicationgroup) {

		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masApplicationgroup);
		successfullyAdded = true;
		return successfullyAdded;
	}

	
	public boolean editAppGroup(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
			
		String appGroupName = "";
		@SuppressWarnings("unused")
		String appGroupCode = "";
		int appGroupId = 0;
		try {
			appGroupId = (Integer) generalMap.get("id");
			appGroupCode = (String) generalMap.get("appGroupCode");
			appGroupName = (String) generalMap.get("appGroupName");
		} catch (Exception e) {
			e.printStackTrace();
		}

		MasApplicationgroup masAppGroup = (MasApplicationgroup) getHibernateTemplate().get(
				MasApplicationgroup.class, appGroupId);

		masAppGroup.setId(appGroupId);
		masAppGroup.setApplicationgroupName(appGroupName);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(masAppGroup);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	public boolean deleteApplicationGroup(int appGroupId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasApplicationgroup masApplicationGroup = new MasApplicationgroup();
		masApplicationGroup = (MasApplicationgroup) getHibernateTemplate().get(
				MasApplicationgroup.class, appGroupId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masApplicationGroup.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masApplicationGroup.setStatus("y");
				dataDeleted = false;
			}
		}
		masApplicationGroup.setLastChgBy(changedBy);
		masApplicationGroup.setLastChgDate(currentDate);
		masApplicationGroup.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(masApplicationGroup);
		return dataDeleted;
	}
	
	@SuppressWarnings( { "unused", "unchecked" })
	public Map<String, Object> searchAppGroup(String appGroupCode,
			String appGroupName) {
		List<MasApplicationgroup> searchApplicationGroupList = new ArrayList<MasApplicationgroup>();
		Map<String, Object> userGroupsFieldsMap = new HashMap<String, Object>();
		try {
			if ((appGroupName != null) || (appGroupCode == null)) {

				searchApplicationGroupList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasApplicationgroup imc where imc.ApplicationgroupName like '"
										+ appGroupName
										+ "%' order by imc.ApplicationgroupName");
			} else {
				searchApplicationGroupList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasApplicationgroup imc where imc.ApplicationgroupCode like '"
										+ appGroupCode
										+ "%' order by imc.ApplicationgroupCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		userGroupsFieldsMap.put("searchApplicationGroupList", searchApplicationGroupList);
		return userGroupsFieldsMap;
	}

	
	/**
	 * method to get parentList from masApplication
	 */
	
	@SuppressWarnings( { "unused", "unchecked" })
	public Map<String,Object> getParentList() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<GroupApplication> parentList = new ArrayList<GroupApplication>();
		List<MasApplicationgroup> groupAppList = new ArrayList<MasApplicationgroup>();
		List<AssignParentToApplicationgroup> assignAppList = new ArrayList<AssignParentToApplicationgroup>();
		session = (Session) getSession();
		parentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.GroupApplication ma where ma.App.ParentId = '0' and ma.App.Url = '#'");
		groupAppList = getHibernateTemplate().find(
		"from jkt.hms.masters.business.MasApplicationgroup mag where mag.Status = 'y' order by mag.ApplicationgroupName asc");
		assignAppList = getHibernateTemplate().find(
		"from jkt.hms.masters.business.AssignParentToApplicationgroup ma where ma.App.ParentId = '0' and ma.App.Url = '#'");
		map.put("assignAppList",assignAppList);
		map.put("parentList", parentList);
		map.put("groupAppList", groupAppList);
		return map;
	}

	@SuppressWarnings({"unchecked","unused"})
	public boolean submitParentAndGroup(Map<String, Object> map) {
		int appGroupId = (Integer) map.get("appGroupId");
		List parentList = (List) map.get("parentList");
		List<AssignParentToApplicationgroup> application = new ArrayList<AssignParentToApplicationgroup>();
		Session session = (Session) getSession();
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
		String userName = (String) map.get("userName");
		AssignParentToApplicationgroup templateApp;
		boolean successfullyAdded = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			if (parentList.size() > 0) {
				application = session.createCriteria(AssignParentToApplicationgroup	.class)
								.createAlias("App", "App").add(
								Restrictions.eq("Applicationgroup.Id", appGroupId))
								.list();
				for (AssignParentToApplicationgroup tempApp : application) {
					String hql = "delete from AssignParentToApplicationgroup as uuga where uuga.Applicationgroup.Id = '"
							+ tempApp.getApplicationgroup().getId() + "'";
					Query query = session.createQuery(hql);
					@SuppressWarnings("unused")
					int row = query.executeUpdate();
				}
			}
			
			if (parentList != null && parentList.size() > 0) {
				Iterator iterator = parentList.iterator();
				while (iterator.hasNext()) {
					templateApp = new AssignParentToApplicationgroup();
					String appId = (String)iterator.next();
					MasApplicationgroup appGroup = new MasApplicationgroup();
					appGroup.setId(appGroupId);
					templateApp.setApplicationgroup(appGroup);
					
					MasApplication masApplication = new MasApplication();
					masApplication.setId(appId);
					templateApp.setApp(masApplication);
					hbt.save(templateApp);

					successfullyAdded = true;

				}
			}
					} catch (HibernateException e) {
			e.printStackTrace();
		}
		return successfullyAdded;

	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> showAppGroup() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasApplicationgroup> searchApplicationGroupList = new ArrayList<MasApplicationgroup>();
		searchApplicationGroupList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasApplicationgroup");
		map.put("searchApplicationGroupList", searchApplicationGroupList);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> populateDepartment(String templateId) {
		Map<String ,Object> map= new HashMap<String, Object>();
		
		try{
			Session session = (Session)getSession();
			List<Integer> existingNameList = new ArrayList<Integer>();
			List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			departmentList= session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
			String existqry = " SELECT t.department_id FROM template_application t where t.template_id = " +
	          templateId + " and t.status = 'Y' and t.department_id is not null";
			existingNameList = (List) session.createSQLQuery(existqry).list();
			map.put("departmentList", departmentList);
			map.put("existingNameList", existingNameList);
		    
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	@SuppressWarnings({"unchecked","unused"})
	public boolean submitTemplateWiseDepartment(Map<String, Object> map) {
		int templateId = (Integer) map.get("templateId");
		List depList = (List) map.get("depList");
		List<TemplateApplication> application = new ArrayList<TemplateApplication>();
		Session session = (Session) getSession();
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
		String userName = (String) map.get("userName");
		TemplateApplication templateApp;
		boolean successfullyAdded = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			if (depList.size() > 0) {
				Iterator iterator = depList.iterator();
				while (iterator.hasNext()) {
					int depId = (Integer) iterator.next();	
					String hql = "delete from TemplateApplication as tempap where tempap.Template.Id = "+templateId + " and tempap.Department.Id = "
						+ depId ;
					Query query = session.createQuery(hql);
					int row = query.executeUpdate();
				}
			}	
			if (depList != null && depList.size() >= 0) {
				Iterator iterator = depList.iterator();
				while (iterator.hasNext()) {
					templateApp = new TemplateApplication();
					int departmentId = (Integer)iterator.next();
					MasDepartment masDepartment = new MasDepartment();
					masDepartment.setId(departmentId);
					MasTemplate masTemplate = new MasTemplate();
					masTemplate.setId(templateId);
					templateApp.setTemplate(masTemplate);
					templateApp.setDepartment(masDepartment);
					templateApp.setLastChgBy(userName);
					templateApp.setLastChgDate(currentDate);
					templateApp.setLastChgTime(currentTime);
					templateApp.setStatus("y");
					hbt.save(templateApp);

					successfullyAdded = true;

				}
			}
		}catch (HibernateException e) {
			e.printStackTrace();
		} 
			
		return successfullyAdded;
				
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> getDepartmentTemplateList(int templateId,
			int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<TemplateApplication> tempAppList = new ArrayList<TemplateApplication>();
		List<Integer> DepartmentTemplateList = new ArrayList<Integer>();
		try {
			String query ="select distinct(department_id) from template_application where template_id='"+templateId+"' and department_id is not null ";
			DepartmentTemplateList = (List) session.createSQLQuery(query).list();
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		map.put("DepartmentTemplateList", DepartmentTemplateList);
		
		return map;
	}
	public Map<String, Object> getAssignParentList(Map<String, Object> parameterMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<GroupApplication> parentList = new ArrayList<GroupApplication>();
		List<AssignParentToApplicationgroup> assignAppList = new ArrayList<AssignParentToApplicationgroup>();
		List<MasApplicationgroup> groupAppList = new ArrayList<MasApplicationgroup>();
		int appGroupId=0;
		if (parameterMap.get("appGroupId") != null) {
			appGroupId = (Integer) parameterMap.get("appGroupId");
		}
		parentList = getHibernateTemplate().find(
		"from jkt.hms.masters.business.GroupApplication ma where ma.App.ParentId = '0' and ma.App.Url = '#'");

		assignAppList = getHibernateTemplate().find(
		"from jkt.hms.masters.business.AssignParentToApplicationgroup ma where ma.App.ParentId = '0' and ma.App.Url = '#' and ma.Applicationgroup.Id = " + appGroupId );

		map.put("groupAppList",groupAppList);
		map.put("parentList",parentList);
		map.put("assignAppList",assignAppList);
		return map;
	}
	/*
	 * Code for Templete Assigned To User
	 * Code By Mukesh Narayan Singh
	 * Date 01-Jun-2012
	 */
	@Override
	public Map<String, Object> showUserAssignedTemplet(
			Map<String, Object> mapDetails) {
		Map<String, Object> map = new HashMap<String, Object>();
		//List<Object> masEmployeeList = new ArrayList<Ob>();
		List<Object[]> masEmployeeList = new ArrayList<Object[]>();
		List<MasTemplate> masTemplateList = new ArrayList<MasTemplate>();
		
		int hospitalId=0;
		if (mapDetails.get("hospitalId") != null) {
			hospitalId = (Integer) mapDetails.get("hospitalId");
		}
		int employeeCategoryId=0;
		if (mapDetails.get("employeeCategoryId") != null) {
			employeeCategoryId = (Integer) mapDetails.get("employeeCategoryId");
		}
		/*masEmployeeList = getHibernateTemplate().find(
		"from jkt.hms.masters.business.MasEmployee emp where emp.Hospital.Id = "+hospitalId+" and emp.Status= 'y' order by emp.FirstName asc");
		*/
		String sql="";
		/*if(employeeCategoryId>0){
			sql=" and emp.EmpCategory.Id="+employeeCategoryId;
		}*/
		
		
		 if(mapDetails.get("firstName") != null)
		 {
			 sql = " and emp.FirstName like '%"+mapDetails.get("firstName")+"%'"; 
		 }
		else
		{
			sql = " and emp.ServiceNo = '"+mapDetails.get("serviceNo")+"'";
		}
		 
		System.out.println("sql--->"+sql);
		masEmployeeList = getHibernateTemplate().find("select distinct emp,user from jkt.hms.masters.business.Users user join user.Employee emp left join user.UserUsergroupHospitals uugh where( emp.Hospital.Id = "+hospitalId+" or uugh.Hospital.Id="+hospitalId+")"+sql+" and user.Status= 'y' and emp.Status= 'y' order by emp.FirstName asc");
		masTemplateList = getHibernateTemplate().find(
		"from jkt.hms.masters.business.MasTemplate templet where  templet.Template.Id is null and templet.Status ='y'  order by TemplateName.TemplateName asc");

		List<Object[]> masHospitalList = new ArrayList<Object[]>();
		hospitalList = getHibernateTemplate()
				.find(
						"select mc.Id,mc.HospitalName from jkt.hms.masters.business.MasHospital as mc where mc.Status = 'y' order by mc.HospitalName asc");
		
		/**
		 * Commented By ritu on 20 Aug 2015
		 */
		/*	
		 * List<MasEmpCategory> masEmpCategoryList = new ArrayList<MasEmpCategory>();
		 * 	masEmpCategoryList = getHibernateTemplate().find(
		"from jkt.hms.masters.business.MasEmpCategory empCat where  empCat.Status ='y'  order by empCat.EmpCategoryName asc");
		map.put("masEmpCategoryList",masEmpCategoryList);
*/		
		//System.out.println("masEmpCategoryList.size()--->"+masEmpCategoryList.size());
		List<UserTemplate> userTemplateList = new ArrayList<UserTemplate>();
		userTemplateList = getHibernateTemplate().find(
		"from jkt.hms.masters.business.UserTemplate ut where  ut.Hospital.Id = "+hospitalId+" and ut.Status ='y'  order by ut.Template.Id asc");
		map.put("userTemplateList",userTemplateList);
		map.put("masEmployeeList",masEmployeeList);
		map.put("masTemplateList",masTemplateList);
		map.put("hospitalList",hospitalList);
		return map;
	}

	@Override
	public Map<String, Object> addUserWiseTemplateOnly(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		boolean successfullyAdded = false;
		List<Object> usrGrpHospList = new ArrayList<Object>();
		List<Object> grpAppList = new ArrayList<Object>();
		//List<Integer> userIdList = new ArrayList<Integer>();
		usrGrpHospList = (List<Object>) dataMap.get("usrGrpHospList");
		grpAppList = (List<Object>) dataMap.get("grpAppList");
		//userIdList = (List<Integer>) dataMap.get("userIdList");
		int templateId = (Integer) dataMap.get("templateId");
		int hospitalId = (Integer) dataMap.get("hospitalId");
		int empGroupId = (Integer) dataMap.get("empGroupId");
		int userId=0;
		if(dataMap.get("userId")!=null){
			userId = (Integer) dataMap.get("userId");
		}
	
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String userName = (String) dataMap.get("userName");
		if (userId > 0) {
			/*
				UserUsergroupApplication userUserGroupApp = new UserUsergroupApplication();
				if (grpAppList.get(i) != null && !grpAppList.get(i).equals("")) {
					int grpAppId =0;
					if(grpAppList.get(i)!=null){
						grpAppId = Integer.parseInt(grpAppList.get(i).toString());
					}
					if(grpAppId>0){
						GroupApplication grpApp = new GroupApplication();
						grpApp.setId(grpAppId);
						userUserGroupApp.setGroupApp(grpApp);
					}
					int userGrpHospId =0;
					if(usrGrpHospList.get(i)!=null){
						userGrpHospId = Integer.parseInt(usrGrpHospList.get(i).toString());
						if(userGrpHospId>0){
							UsergroupHospital usergroupHospital = new UsergroupHospital();
							//System.out.println(grpAppId+"<-grpAppId--"+i+"-userGrpHospId--->"+userGrpHospId);
							usergroupHospital.setId(userGrpHospId);
							userUserGroupApp.setGroupHospital(usergroupHospital);
						}
					}
					Users users = new Users();
					users.setId(userId);
					userUserGroupApp.setUser(users);
					userUserGroupApp.setStatus("y");
				}
				try {
					hbt.save(userUserGroupApp);

				} catch (Exception e) {
					e.printStackTrace();
				}
			*/
				try {
					if(templateId>0){
						
						UserTemplate userTemplate = new UserTemplate();
						
						Users user = new Users();
						//int userId = Integer.parseInt(userIdList.get(j).toString());
						user.setId(userId);
						userTemplate.setUser(user);
						if(templateId>0){
							MasTemplate masTemplate = new MasTemplate();
							masTemplate.setId(templateId);
							userTemplate.setTemplate(masTemplate);
						}
						
						MasHospital masHospital = new MasHospital();
						masHospital.setId(hospitalId);
						userTemplate.setHospital(masHospital);
						if(empGroupId>0){
							EmpGroups empGroups = new EmpGroups();
							empGroups.setId(empGroupId);
							userTemplate.setEmpGroup(empGroups);
						}
						
						userTemplate.setStatus("y");
						userTemplate.setLastChgBy(userName);
						userTemplate.setLastChgDate(currentDate);
						userTemplate.setLastChgTime(currentTime);
						hbt.save(userTemplate);
						successfullyAdded = true;
					}
				} catch (NumberFormatException e) {
					successfullyAdded = false;
					e.printStackTrace();
				} catch (DataAccessException e) {
					successfullyAdded = false;
					e.printStackTrace();
				}
			

			/*
			 * code for giving button level rights
			 */
				
				/*for (int k = 0; k < buttonTemplateList.size(); k++) {
					UserButtonRights userButtonRights = new UserButtonRights();
					if (buttonTemplateList.get(k) != null && !buttonTemplateList.get(k).equals("")) {
						MasButtonForm masButtonForm = new MasButtonForm();
						int buttonId = Integer.parseInt(buttonTemplateList.get(k).toString());
						masButtonForm.setId(buttonId);
						userButtonRights.setButton(masButtonForm);

						if(empGroupId>0){
							EmpGroups empGroups = new EmpGroups();
							empGroups.setId(empGroupId);
							userButtonRights.setEmpGroup(empGroups);
						}


						Users users = new Users();
						//int userId = Integer.parseInt(userIdList.get(j).toString());
						users.setId(userId);
						userButtonRights.setUser(users);
					}
					try {
					 	hbt.save(userButtonRights);
						successfullyAdded = true;
					} catch (DataAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						successfullyAdded = false;
					}
				}*/
				
				//code for department level 
				/*for (int bigDecimal : departmentTemplateSet) {
					UserDepartment userDepartment = new UserDepartment();
					int deptId =bigDecimal;
					System.out.println("deptId--4453-->"+deptId);
					UserDepartment userDepartmentLoad = new UserDepartment();
					List<UserDepartment> userDeptList = new ArrayList<UserDepartment>();
					//userDeptList=session.createCriteria(UserDepartment.class).add(Restrictions.eq("User.Id", userId)).add(Restrictions.eq("Department.Id", deptId)).list();
					userDeptList=getHibernateTemplate().find("from jkt.hms.masters.business.UserDepartment as ud where ud.User.Id="+userId+" and ud.Department.Id="+deptId);
					if(userDeptList.size()>0){
					}else{
					if (deptId>0) {
						MasDepartment masDepartment = new MasDepartment();
						//int deptId = Integer.parseInt(""+departmentTemplateSet.get(k).toString());
						masDepartment.setId(deptId);
						userDepartment.setDepartment(masDepartment);
						Users users = new Users();
						//int userId = Integer.parseInt(userIdList.get(j).toString());
						users.setId(userId);
						userDepartment.setUser(users);
						userDepartment.setStatus("y");
					}
					
					try {
						hbt.save(userDepartment);
						successfullyAdded = true;
					} catch (DataAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						successfullyAdded = false;
					}
					}
				}*/
				
		//	}	
		}
		hbt.flush();
		map.put("successfullyAdded", successfullyAdded);
		return map;
	
	}

	@Override
	public Map<String, Object> getTemplateAsPerEmpCatList(
			Map<String, Object> mapDetails) {
		Map<String, Object> map = new HashMap<String, Object>();
		//List<Object> masEmployeeList = new ArrayList<Ob>();
		
		List<MasTemplate> masTemplateList = new ArrayList<MasTemplate>();
		
		
		int employeeCategoryId=0;
		if (mapDetails.get("employeeCategoryId") != null) {
			employeeCategoryId = (Integer) mapDetails.get("employeeCategoryId");
		}
		int templateId=0;
		if (mapDetails.get("templateId") != null) {
			templateId = (Integer) mapDetails.get("templateId");
		}
		int templateIdEmpCat=0;
		if(employeeCategoryId>0 && templateId!=0){
			masTemplateList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasTemplate templet where  templet.EmpCategory.Id="+employeeCategoryId+" and templet.Template.Id="+templateId+"  and templet.Status ='y'  order by TemplateName.TemplateName asc");
			if(masTemplateList.size()>0){
				for(MasTemplate masTemplate:masTemplateList){
					templateIdEmpCat=masTemplate.getId();
				}
			}else{
				templateIdEmpCat=templateId;
			}
		}else if(employeeCategoryId==0 && templateId!=0){
			masTemplateList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasTemplate templet where  templet.Template.Id="+templateId+"  and templet.Status ='y'  order by TemplateName.TemplateName asc");
			if(masTemplateList.size()>0){
				for(MasTemplate masTemplate:masTemplateList){
					templateIdEmpCat=masTemplate.getId();
				}
			}else{
				templateIdEmpCat=templateId;
			}
		}else{
			templateIdEmpCat=templateId;
		}
		
		
		//System.out.println(masTemplateList.size()+"<--masTemplateList.size()-templateIdEmpCat-->"+templateIdEmpCat);
		map.put("templateIdEmpCat",templateIdEmpCat);
		return map;
	}

	@Override
	public Map removeTemplateApplicationList(
			Map<String, Object> removeTemplateMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		//List<Object> masEmployeeList = new ArrayList<Ob>();
		List<Integer> preTempletIdList=new ArrayList<Integer>();
		List<Integer> preUserIdList=new ArrayList<Integer>();
		Session session = (Session) getSession();	
		
		int hospitalId=0;
		if (removeTemplateMap.get("hospitalId") != null) {
			hospitalId = (Integer) removeTemplateMap.get("hospitalId");
		}
		
		if (removeTemplateMap.get("preTempletIdList") != null) {
			preTempletIdList = (List) removeTemplateMap.get("preTempletIdList");
		}
		if (removeTemplateMap.get("preUserIdList") != null) {
			preUserIdList = (List) removeTemplateMap.get("preUserIdList");
		}
		try {
		if(preTempletIdList.size()>0){
				int index=0;
				for(Integer preTemplateId:preTempletIdList){
					System.out.println("preTemplateId=="+preTemplateId);
					
					int userId=0;
					int templateIdTemp=0;
					userId=preUserIdList.get(index);
					System.out.println("userId="+userId);
					System.out.println("hid="+hospitalId);
					/*List<UserTemplate> userTemplateList = new ArrayList<UserTemplate>();
					userTemplateList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.UserTemplate ut where ut.Template.Id="+preTemplateId+" and  ut.Hospital.Id = "+hospitalId+" and ut.User.Id="+userId+" and ut.Status ='y'  order by ut.Template.Id asc");
			
					if(userTemplateList.size()>0){
					for(UserTemplate userTemplate:userTemplateList){
						templateIdTemp=userTemplate.getTemplate().getId();
					}
					}else{*/
						templateIdTemp=preTemplateId;
				//	}
					//String templateAppSql="select app_id from TEMPLATE_APPLICATION where template_id="+templateId+" and app_id is not null";
					/*List<String> userTemplateListAppID = new ArrayList<String>();
					userTemplateListAppID = getHibernateTemplate().find(
					"select ta.App.Id from jkt.hms.masters.business.MasTemplate mt join mt.TemplateApplications as ta join mt.UserTemplates as ut where ut.User.Id = "+userId+" and ut.Hospital.Id = "+hospitalId+" and ut.Template.Id = "+templateIdTemp+" and ta.App.Id is not null");
							String hql ="";
							if(userTemplateListAppID.size()>0){
							List<GroupApplication> groupAppList = new ArrayList<GroupApplication>();
							groupAppList = (List<GroupApplication>) session.createCriteria(
									GroupApplication.class).createAlias("App", "app").add(
									Restrictions.in("app.Id", userTemplateListAppID)).add(Restrictions.eq("Status","y")).list();
							if(groupAppList.size()>0){
								for(GroupApplication groupApplication:groupAppList){
									hql = "delete from UserUsergroupApplication as uuga where uuga.User.Id = "+ userId+ " and uuga.GroupApp.Id ="+groupApplication.getId()+" ";
									Query query = session.createQuery(hql);
									@SuppressWarnings("unused")
									int row = query.executeUpdate();
								}
							}*/
						//}
						
						System.out.println("Execution start");
							String hqlUserTemplate = "delete from user_template where user_id = "+ userId+ " and template_id="+templateIdTemp+" and hospital_id="+hospitalId;
						Query queryUserTemplate = session.createSQLQuery(hqlUserTemplate);
						@SuppressWarnings("unused")
						int rowUserTemplate = queryUserTemplate.executeUpdate();
						System.out.println("rowUserTemplate=="+rowUserTemplate);
					//	System.out.println("userId-4592->"+userId);
//						String hqlUserDepartment = "delete from UserDepartment as ud where ud.User.Id = "+ userId;
//						Query queryUserDepartment = session.createQuery(hqlUserDepartment);
//						int rowUserDepartment = queryUserDepartment.executeUpdate();
				//}
					
					++index;
				}
				
				System.out.println("end for loop");
			}
			} catch (DataAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.flush();
		return map;
	}

	@Override
	public Map<String, Object> getServiceNoDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = box.getString("serviceNo");
		//int serviceTypeId = box.getInt(SERVICE_TYPE_ID);
		//System.out.println("serviceNo--ds->"+serviceNo);
		org.hibernate.Session session = getSession();
		List<MasEmployee> existingMasEmployeeList = new ArrayList<MasEmployee>();
		existingMasEmployeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("ServiceNo", serviceNo)).list();
		map.put("existingMasEmployeeList",existingMasEmployeeList);
		
		List<Users> usersList = new ArrayList<Users>();
		usersList = session.createCriteria(Users.class).add(Restrictions.eq("LoginName", serviceNo)).list();
		map.put("usersList",usersList);
		/*
		 * Code for Employee Creation
		 */
		List<MasTitle> titleList = new ArrayList<MasTitle>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasEmpCategory> empCategoryList = new ArrayList<MasEmpCategory>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasTrade> tradeList = new ArrayList<MasTrade>();

		List<TransactionSequence> seqList = new ArrayList<TransactionSequence>();
		
		titleList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasTitle as tm where tm.Status = 'y'");
		departmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment as md where md.Status = 'y'");
		empCategoryList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasEmpCategory as mec where mec.Status = 'y'");
		rankList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasRank as mg where mg.Status = 'y'");
		unitList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasUnit as mg where mg.Status = 'y'");
		tradeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasTrade as mg where mg.Status = 'y'");
		seqList = getHibernateTemplate().find("from jkt.hms.masters.business.TransactionSequence as ts where ts.TransactionPrefix= 'EMP'");
		
		map.put("titleList", titleList);
		map.put("departmentList", departmentList);
		map.put("empCategoryList", empCategoryList);
		map.put("rankList", rankList);
		map.put("unitList", unitList);
		map.put("tradeList", tradeList);
		map.put("seqList", seqList);
		map.put("serviceNo", serviceNo);
		
		return map;
	}
	/**
	 * getTemplateApplicationListForSMC
	 * @author Mukesh Narayan Singh 
	 * @param request Map<String, Object> dataMap
	 * @return TemplateApplication
	 */
	public Map<String, Object> getTemplateApplicationListForSMC(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId=0;
		List<Integer> templetIdList=new ArrayList<Integer>();
		if (dataMap.get("templetIdList") != null) {
			templetIdList = (List<Integer>) dataMap.get("templetIdList");
		}
		if (dataMap.get("hospitalId") != null) {
			hospitalId = (Integer) dataMap.get("hospitalId");
		}
	//	System.out.println("templetIdList-->"+templetIdList.size());
	//	System.out.println("hospitalId-->"+hospitalId);
		Users users=new Users();
		if (dataMap.get("users") != null) {
			users = (Users) dataMap.get("users");
		}
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
		changedBy = (String) dataMap.get("changedBy");
		currentDate = (Date) dataMap.get("currentDate");
		currentTime = (String) dataMap.get("currentTime");
		Session session = (Session) getSession();
		List<TemplateApplication> tempAppList = new ArrayList<TemplateApplication>();
		List<GroupApplication> groupAppList = new ArrayList<GroupApplication>();

		List<UsergroupHospital> userGrpHospitalList = new ArrayList<UsergroupHospital>();
		List<Object> grpAppList = new ArrayList<Object>();
		List<Object> grpIdList = new ArrayList<Object>();
		List<Object> usrGrpHospList = new ArrayList<Object>();
		String applicationId = "";
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		try {
			int cnt=0;
			String sqlId="";
			if(templetIdList.size()>0){
				for(Integer a1:templetIdList)
				{
				//	dignosisIdList.add(Integer.parseInt(a1));
					if(cnt==0){
							sqlId=""+a1;
					}else{
						sqlId=sqlId+","+a1;
					}
					++cnt;
					}
			}
			tempAppList = session.createQuery(
					" from TemplateApplication as tempApp where Template.Id in ("+sqlId+")").list();

			for (Iterator iterator = tempAppList.iterator(); iterator.hasNext();) {
				TemplateApplication tempApp = (TemplateApplication) iterator
						.next();
				if(tempApp.getApp() != null){
				applicationId = tempApp.getApp().getId();
				}
				
				groupAppList = (List<GroupApplication>) session.createCriteria(
						GroupApplication.class).createAlias("App", "app").add(
						Restrictions.eq("app.Id", applicationId)).add(Restrictions.eq("Status","y")).list();
				//System.out.println("groupAppList.size()-2684-->"+groupAppList.size());
				for (Iterator iterator1 = groupAppList.iterator(); iterator1
						.hasNext();) {
					GroupApplication grpApp = (GroupApplication) iterator1
							.next();
					int groupId = 0;
					int grpAppId = 0;
					groupId = grpApp.getGroup().getId();
					grpAppId = grpApp.getId();
					grpAppList.add(grpAppId);
					grpIdList.add(groupId);
					//System.out.println(groupId+"<-groupId---hospitalId--->"+hospitalId);
					userGrpHospitalList = (List<UsergroupHospital>) session
					.createCriteria(UsergroupHospital.class)
					.createAlias("Hospital", "hsp").add(
							Restrictions.eq("hsp.Id", hospitalId))
					.createAlias("Group", "grp").add(
							Restrictions.eq("grp.Id", groupId)).addOrder(Order.desc("Id")).list();
				//	System.out.println("userGrpHospitalList-->"+userGrpHospitalList.size());
					usrGrpHospList.add(userGrpHospitalList.get(0).getId());
					

				}
			}
			//System.out.println("grpAppList.size()-2684-->"+grpAppList.size());
			for (int i = 0; i < grpAppList.size(); i++) {
				UserUsergroupApplication userUserGroupApp = new UserUsergroupApplication();
				if (grpAppList.get(i) != null && !grpAppList.get(i).equals("")) {
					GroupApplication grpApp = new GroupApplication();
					int grpAppId = Integer.parseInt(grpAppList.get(i).toString());
					grpApp.setId(grpAppId);
					userUserGroupApp.setGroupApp(grpApp);

					UsergroupHospital usergroupHospital = new UsergroupHospital();
					int userGrpHospId = Integer.parseInt(usrGrpHospList.get(i).toString());
					//System.out.println(grpAppId+"<-grpAppId--"+i+"-userGrpHospId--->"+userGrpHospId);
					usergroupHospital.setId(userGrpHospId);
					userUserGroupApp.setGroupHospital(usergroupHospital);

					//Users users = new Users();
					//int userId = Integer.parseInt(userIdList.get(j).toString());
					//users.setId(userId);
					userUserGroupApp.setUser(users);
					userUserGroupApp.setStatus("y");

					try {
						hbt.save(userUserGroupApp);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			}
		//System.out.println("templetIdList.size()-2713-->"+templetIdList.size());
			if(templetIdList.size()>0){
				for(Integer templateId1:templetIdList){
					UserTemplate userTemplate = new UserTemplate();
					
					//Users user = new Users();
					//int userId = Integer.parseInt(userIdList.get(j).toString());
					//user.setId(userId);
					userTemplate.setUser(users);
					
					MasTemplate masTemplate = new MasTemplate();
					masTemplate.setId(templateId1);
					userTemplate.setTemplate(masTemplate);
					
					MasHospital masHospital = new MasHospital();
					masHospital.setId(hospitalId);
					userTemplate.setHospital(masHospital);
					/*if(empGroupId>0){
						EmpGroups empGroups = new EmpGroups();
						empGroups.setId(empGroupId);
						userTemplate.setEmpGroup(empGroups);
					}*/
					
					userTemplate.setStatus("y");
					userTemplate.setLastChgBy(changedBy);
					userTemplate.setLastChgDate(currentDate);
					userTemplate.setLastChgTime(currentTime);
					hbt.save(userTemplate);
					//successfullyAdded = true;
				
				}
				}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	@Override
	public Map<String, Object> getAdminDetailsForHospital(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = box.getInt("hospitalId");
		
		org.hibernate.Session session = getSession();
		
		List<Integer> userEmpIdList = new ArrayList<Integer>();
		
		userEmpIdList = session.createCriteria(UserTemplate.class).createAlias("User", "user").add(Restrictions.eq("Hospital.Id", hospitalId)).add(Restrictions.eq("Template.Id", 8)).add(Restrictions.eq("Status", "y"))
							.setProjection(Projections.property("user.Employee.Id")).list();
		
		
		if(userEmpIdList.size()>0){
			List<MasEmployee> existingMasEmployeeList = new ArrayList<MasEmployee>();
			existingMasEmployeeList = session.createCriteria(MasEmployee.class).add(Restrictions.in("Id", userEmpIdList)).list();
			map.put("existingMasEmployeeList",existingMasEmployeeList);

			List<Users> usersList = new ArrayList<Users>();
			usersList = session.createCriteria(Users.class).add(Restrictions.in("Employee.Id", userEmpIdList)).list();
			map.put("usersList",usersList);
		}
		
		List<MasTitle> titleList = new ArrayList<MasTitle>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasEmpCategory> empCategoryList = new ArrayList<MasEmpCategory>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasTrade> tradeList = new ArrayList<MasTrade>();

		List<TransactionSequence> seqList = new ArrayList<TransactionSequence>();
		
		titleList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasTitle as tm where tm.Status = 'y'");
		departmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment as md where md.Status = 'y'");
		empCategoryList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasEmpCategory as mec where mec.Status = 'y'");
		rankList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasRank as mg where mg.Status = 'y'");
		unitList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasUnit as mg where mg.Status = 'y'");
		tradeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasTrade as mg where mg.Status = 'y'");
		seqList = getHibernateTemplate().find("from jkt.hms.masters.business.TransactionSequence as ts where ts.TransactionPrefix= 'EMP'");
		
		map.put("titleList", titleList);
		map.put("departmentList", departmentList);
		map.put("empCategoryList", empCategoryList);
		map.put("rankList", rankList);
		map.put("unitList", unitList);
		map.put("tradeList", tradeList);
		map.put("seqList", seqList);
		return map;
	}
	

//------Methods of Complain By Kiran

	
	public Map<String, Object> showComplainA(Map<String, Object> map) {
		
		int userId=0;
		int hospitalId=0;
		int reqBy=0;
		List<Complain> searchComplainList = new ArrayList<Complain>();
		List<MasEmployee> gridEmployeeList = new ArrayList<MasEmployee>();
		List<Users> userList = new ArrayList<Users>();
		List<Users> userList1 = new ArrayList<Users>();
		
		Session session = (Session)getSession();
				
		 if(map.get("userId")!=null){
				 userId=(Integer)map.get("userId");
				 
		 }
			
		 if(map.get("hospitalId")!=null)
		 {
			 hospitalId=(Integer)map.get("hospitalId");
		 }
		 if(map.get("reqBy")!=null)
		 {
			 reqBy=(Integer)map.get("reqBy");
		 }
		
		 //Map<String, Object> dataMap = new HashMap<String, Object>();
		
		 userList=session.createCriteria(Users.class).add(Restrictions.eq("Employee.Id", userId)).add(Restrictions.eq("Status", "y")).list();
						
		 String quey="select e.employee_id, r.rank_name, e.first_name, e.last_name"+
		" from users u"+
		" left outer join mas_employee e on u.EMPLOYEE_ID= e.EMPLOYEE_ID"+
		" left outer join mas_rank r on e.rank_id=r.rank_id"+
		" where u.STATUS='y'";
		 

		userList1=session.createSQLQuery(quey).list();
		
		searchComplainList=session.createCriteria(Complain.class).add(Restrictions.eq("Hospital.Id", hospitalId)).list();
		
		if(userList.size()>0){
			map.put("userList", userList);
		}
		
		if(searchComplainList.size()>0){
			map.put("searchComplainList", searchComplainList);
		}
				
		gridEmployeeList=session.createCriteria(MasEmployee.class).list();
		
		if(gridEmployeeList.size()>0){
			map.put("gridEmployeeList", gridEmployeeList);
		}
			
		map.put("userList1", userList1);
		
	return map;


	}

		
	public boolean submitComplainA(Complain comp) {
		
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(comp);
		successfullyAdded = true;
		return successfullyAdded;
	
		
	}
	
	public Map<String, Object> showComplainB(Map<String, Object> map) {
		
		int userId=0;
		int hospitalId=0;
		
		List<Complain> searchComplainList = new ArrayList<Complain>();
		List<MasEmployee> gridEmployeeList = new ArrayList<MasEmployee>();
		List<Users> userList = new ArrayList<Users>();
		List<Users> userList1 = new ArrayList<Users>();
		
		Session session = (Session)getSession();
				
		 if(map.get("userId")!=null){
				 userId=(Integer)map.get("userId");
				 
		 }
			
		 if(map.get("hospitalId")!=null)
		 {
			 hospitalId=(Integer)map.get("hospitalId");
		 }
		 				
		 userList=session.createCriteria(Users.class).add(Restrictions.eq("Employee.Id", userId)).add(Restrictions.eq("Status", "y")).list();
		
		 String quey="select e.employee_id, r.rank_name, e.first_name, e.last_name"+
			" from users u"+
			" left outer join mas_employee e on u.EMPLOYEE_ID= e.EMPLOYEE_ID"+
			" left outer join mas_rank r on e.rank_id=r.rank_id"+
			" where u.STATUS='y'";
					
		 userList1=session.createSQLQuery(quey).list();
		
		searchComplainList=session.createCriteria(Complain.class).add(Restrictions.eq("Hospital.Id", hospitalId)).list();
		
		if(userList.size()>0){
			map.put("userList", userList);
		}
			
		if(searchComplainList.size()>0){
			map.put("searchComplainList", searchComplainList);
		}
				
		gridEmployeeList=session.createCriteria(MasEmployee.class).list();
		if(gridEmployeeList.size()>0){
			map.put("gridEmployeeList", gridEmployeeList);
		}
		
		map.put("userList1", userList1);
		
	return map;

}
	
	public Map<String, Object> showComplainC(Map<String, Object> map) {
		
		int userId=0;
		int hospitalId=0;
		
		List<Complain> searchComplainList = new ArrayList<Complain>();
		List<MasEmployee> gridEmployeeList = new ArrayList<MasEmployee>();
		List<Users> userList = new ArrayList<Users>();
		List<Users> userList1 = new ArrayList<Users>();
		
		Session session = (Session)getSession();
				
		 if(map.get("userId")!=null){
				 userId=(Integer)map.get("userId");
		 }
			
		 if(map.get("hospitalId")!=null)
		 {
			 hospitalId=(Integer)map.get("hospitalId");
		 }
		 		
		 userList=session.createCriteria(Users.class).add(Restrictions.eq("Employee.Id", userId)).add(Restrictions.eq("Status", "y")).list();
		
		 String quey="select e.employee_id, r.rank_name, e.first_name, e.last_name"+
			" from users u"+
			" left outer join mas_employee e on u.EMPLOYEE_ID= e.EMPLOYEE_ID"+
			" left outer join mas_rank r on e.rank_id=r.rank_id"+
			" where u.STATUS='y'";
			 
		 userList1=session.createSQLQuery(quey).list();
		
	searchComplainList=session.createCriteria(Complain.class).add(Restrictions.eq("Hospital.Id", hospitalId)).list();
		
	if(userList.size()>0){
			map.put("userList", userList);
		}
				
		if(searchComplainList.size()>0){
			map.put("searchComplainList", searchComplainList);
		}
				
		map.put("userList1", userList1);
		
		gridEmployeeList=session.createCriteria(MasEmployee.class).list();
		
		if(gridEmployeeList.size()>0){
			map.put("gridEmployeeList", gridEmployeeList);
		}
		
	return map;
	}
	
	@Override
	public Map<String, Object> searchComplainA(Map<String, Object> map) {
		
		Date fromDate = new Date();
		Date toDate = new Date();
		int userName =0;
		int hospitalId=0;
		String reqType ="";
		Criteria c = null;

		List<Complain> searchComplainList = new ArrayList<Complain>();
		
		
		Session session = (Session) getSession();
	
		 if(map.get("fromDate")!=null){
			 fromDate=(Date)map.get("fromDate");
		 }
		 
		 if(map.get("toDate")!=null){
			 toDate=(Date)map.get("toDate"); 
		 }
		 
		 if(map.get("userName")!=null){
			 userName=(Integer)map.get("userName");
		 }
		 
		 if(map.get("reqType")!=null){
			 reqType=(String)map.get("reqType");
		 }
		 
		 if(map.get("hospitalId")!=null)
		 {
			 hospitalId=(Integer)map.get("hospitalId");
		 }
		 
		 int userId=0;
		 	List<MasEmployee> gridEmployeeList = new ArrayList<MasEmployee>();
			List<Users> userList = new ArrayList<Users>();
			List<Users> userList1 = new ArrayList<Users>();
			
					
			 if(map.get("userId")!=null){
					 userId=(Integer)map.get("userId");
				 }
				
			 if(map.get("hospitalId")!=null)
			 {
				 hospitalId=(Integer)map.get("hospitalId");
			 }
			try {
					c = session.createCriteria(Complain.class).add(
						Restrictions.eq("Hospital.Id", hospitalId)).add(
						Restrictions.between("ComplainDate",fromDate,toDate));
				
					if (userName !=0) {
						
						c = c.add(Restrictions.eq("RequestBy.Id", userName));
					}
					
					if (!reqType.equals("")) {
						c = c.add(Restrictions.eq("RequestType", reqType));
					}
					searchComplainList = c.list();
				
				} 
			catch (HibernateException e) {
					e.printStackTrace();
				}
			//Map<String, Object> dataMap = new HashMap<String, Object>();
			 
			userList=session.createCriteria(Users.class).add(Restrictions.eq("Employee.Id", userId)).add(Restrictions.eq("Status", "y")).list();
				String quey="select e.employee_id, r.rank_name, e.first_name, e.last_name"+
				" from users u"+
				" left outer join mas_employee e on u.EMPLOYEE_ID= e.EMPLOYEE_ID"+
				" left outer join mas_rank r on e.rank_id=r.rank_id"+
				" where u.STATUS='y'";
												
				userList1=session.createSQLQuery(quey).list();
				
			 
			if(userList.size()>0){
				map.put("userList", userList);
			}
						
			if(searchComplainList.size()>0){
				map.put("searchComplainList", searchComplainList);
			}
			
			gridEmployeeList=session.createCriteria(MasEmployee.class).list();
			
			if(gridEmployeeList.size()>0){
				map.put("gridEmployeeList", gridEmployeeList);
			}
						
			map.put("userList1", userList1);
		 							
		
		return map;
		
	}

	@Override
	public Map<String, Object> getComplainData(Box box) {
		Map<String, Object>map = new HashMap<String, Object>();
		List<Complain> complainList = new ArrayList<Complain>();
		Session session = (Session)getSession();
		complainList = session.createCriteria(Complain.class).add(Restrictions.idEq(box.getInt("compainId"))).list();
		
		map.put("complainList", complainList);
		return map;
	}


	@Override
	public boolean updateComplainA(Map<String, Object> map) {
		
		boolean dataUpdated = false;
		int complainId=0;
		
		String complainTime="";
		String reqBy1="";
		int requestBy=0;
		String requestType="";
		String discription="";
		String status="";
		int hospitalId=0;
	
		try {
			complainId = (Integer) map.get("complainId");
			hospitalId = (Integer) map.get("hospitalId");
			requestBy = (Integer) map.get("reqBy");
			complainTime= (String) map.get("complainTime");
			discription=(String) map.get("descrip");
			requestType=(String) map.get("reqType");
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		Complain complain=(Complain)getHibernateTemplate().get(Complain.class,complainId);
		
		if (map.get("complainDate") != null) {
			Date complainDate = (Date) map.get("complainDate");
			complain.setComplainDate(complainDate);
		}
		complain.setComplainTime(complainTime);
		
		MasEmployee masEmployee = new MasEmployee();
		masEmployee.setId(requestBy);
		complain.setRequestBy(masEmployee);
		
		
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		complain.setHospital(masHospital);
		
		complain.setDiscription(discription);
		complain.setRequestType(requestType);
		
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(complain);
			
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
		
		}

	@Override
	public Map<String, Object> getComplainBData(Box box) {
		Map<String, Object>map = new HashMap<String, Object>();
		List<Complain> complainList = new ArrayList<Complain>();
		Session session = (Session)getSession();
		complainList = session.createCriteria(Complain.class).add(Restrictions.idEq(box.getInt("compainId"))).list();
		
		map.put("complainList", complainList);
		return map;
	}
	
	@Override
	public boolean updateComplainB(Map<String, Object> map) {
		
		boolean dataUpdated = false;
		int complainId=0;
		
		String complainTime="";
		String reqBy1="";
		int requestBy=0;
		String requestType="";
		String discription="";
		String status="";
		int hospitalId=0;
		String airHqRemarks="";
		List<Complain> searchComplainList = new ArrayList<Complain>();	
		try {
			complainId = (Integer) map.get("complainId");
			hospitalId = (Integer) map.get("hospitalId");
			requestBy = (Integer) map.get("reqBy");
			complainTime= (String) map.get("complainTime");
			discription=(String) map.get("descrip");
			requestType=(String) map.get("reqType");
			airHqRemarks=(String) map.get("airHqRemarks");
			status=(String) map.get("status");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Complain complain=(Complain)getHibernateTemplate().get(Complain.class,complainId);
		
		if (map.get("complainDate") != null) {
			Date complainDate = (Date) map.get("complainDate");
			complain.setComplainDate(complainDate);
		}
		complain.setComplainTime(complainTime);
		
		MasEmployee masEmployee = new MasEmployee();
		masEmployee.setId(requestBy);
		complain.setRequestBy(masEmployee);
		
		
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		complain.setHospital(masHospital);
		
		complain.setRequestType(requestType);
		complain.setDiscription(discription);
		complain.setStatus(status);
		complain.setAirHqRemarks(airHqRemarks);
		
		
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(complain);
			
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
		
		}

	@Override
	public Map<String, Object> getComplainCData(Box box) {
		Map<String, Object>map = new HashMap<String, Object>();
		List<Complain> complainList = new ArrayList<Complain>();
		Session session = (Session)getSession();
		complainList = session.createCriteria(Complain.class).add(Restrictions.idEq(box.getInt("compainId"))).list();
		
		map.put("complainList", complainList);
		return map;
	}
	
	@Override
	public boolean updateComplainC(Map<String, Object> map) {
		
		boolean dataUpdated = false;
		int complainId=0;
		
		String complainTime="";
		String reqBy1="";
		int requestBy=0;
		String requestType="";
		String discription="";
		String status="";
		int hospitalId=0;
		String airHqRemarks="";
		Date completionDate= new Date();
		String vendorRemarks="";
	
		List<Complain> searchComplainList = new ArrayList<Complain>();	
		try {
			complainId = (Integer) map.get("complainId");
			hospitalId = (Integer) map.get("hospitalId");
			requestBy = (Integer) map.get("reqBy");
			complainTime= (String) map.get("complainTime");
			discription=(String) map.get("descrip");
			requestType=(String) map.get("reqType");
			airHqRemarks=(String) map.get("airHqRemarks");
			status=(String)map.get("status");
			completionDate=(Date)map.get("completionDate");
			vendorRemarks=(String)map.get("vendorRemarks");
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Complain complain=(Complain)getHibernateTemplate().get(Complain.class,complainId);
		
		if (map.get("complainDate") != null) {
			Date complainDate = (Date) map.get("complainDate");
			complain.setComplainDate(complainDate);
		}
		complain.setComplainTime(complainTime);
		
		MasEmployee masEmployee = new MasEmployee();
		masEmployee.setId(requestBy);
		complain.setRequestBy(masEmployee);
		
		
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		complain.setHospital(masHospital);
		
		complain.setDiscription(discription);
		complain.setRequestType(requestType);
		complain.setAirHqRemarks(airHqRemarks);
		complain.setStatus(status);
		
		if (map.get("completionDate") != null) {
			complain.setCompletionDate(completionDate);
		}
		
		complain.setVendorRemarks(vendorRemarks);
		
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(complain);
			
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
		
		}

public Map<String, Object> searchComplainB(Map<String, Object> map) {
		
	Date fromDate = new Date();
	Date toDate = new Date();
	int userName =0;
	int hospitalId=0;
	String reqType ="";
	Criteria c = null;

	List<Complain> searchComplainList = new ArrayList<Complain>();
	
	Session session = (Session) getSession();

	 if(map.get("fromDate")!=null){
		 fromDate=(Date)map.get("fromDate");
	 }
	 
	 if(map.get("toDate")!=null){
		 toDate=(Date)map.get("toDate"); 
	 }
	 
	 if(map.get("userName")!=null){
		 userName=(Integer)map.get("userName");
	 }
	 
	 if(map.get("reqType")!=null){
		 reqType=(String)map.get("reqType");
	 }
	 
	 if(map.get("hospitalId")!=null)
	 {
		 hospitalId=(Integer)map.get("hospitalId");
	 }
	 
	 int userId=0;
	 	List<MasEmployee> gridEmployeeList = new ArrayList<MasEmployee>();
		List<Users> userList = new ArrayList<Users>();
		List<Users> userList1 = new ArrayList<Users>();
		
				
		 if(map.get("userId")!=null){
				 userId=(Integer)map.get("userId");
		 	 }
			
		 if(map.get("hospitalId")!=null)
		 {
			 hospitalId=(Integer)map.get("hospitalId");
		 }
		try {
				c = session.createCriteria(Complain.class).add(
					Restrictions.eq("Hospital.Id", hospitalId)).add(
					Restrictions.between("ComplainDate",fromDate,toDate));
			
				if (userName !=0) {
					c = c.add(Restrictions.eq("RequestBy.Id", userName));
				}
				
				if (!reqType.equals("")) {
					c = c.add(Restrictions.eq("RequestType", reqType));
				}
				searchComplainList = c.list();
			
			} catch (HibernateException e) {
				e.printStackTrace();
			}
				 
			userList=session.createCriteria(Users.class).add(Restrictions.eq("Employee.Id", userId)).add(Restrictions.eq("Status", "y")).list();
			
			String quey="select e.employee_id, r.rank_name, e.first_name, e.last_name"+
			" from users u"+
			" left outer join mas_employee e on u.EMPLOYEE_ID= e.EMPLOYEE_ID"+
			" left outer join mas_rank r on e.rank_id=r.rank_id"+
			" where u.STATUS='y'";
								
			userList1=session.createSQLQuery(quey).list();
					 
		if(userList.size()>0){
			map.put("userList", userList);
		}
				
		if(searchComplainList.size()>0){
			map.put("searchComplainList", searchComplainList);
		}
		
		gridEmployeeList=session.createCriteria(MasEmployee.class).list();
		
		if(gridEmployeeList.size()>0){
			map.put("gridEmployeeList", gridEmployeeList);
		}
					
		map.put("userList1", userList1);
	 							
	return map;
		
	}

public Map<String, Object> searchComplainC(Map<String, Object> map) {
	
	Date fromDate = new Date();
	Date toDate = new Date();
	int userName =0;
	int hospitalId=0;
	String reqType ="";
	Criteria c = null;

	List<Complain> searchComplainList = new ArrayList<Complain>();
	
	Session session = (Session) getSession();

	 if(map.get("fromDate")!=null){
		 fromDate=(Date)map.get("fromDate");
	 }
	 
	 if(map.get("toDate")!=null){
		 toDate=(Date)map.get("toDate"); 
	 }
	 
	 if(map.get("userName")!=null){
		 userName=(Integer)map.get("userName");
	 }
	 
	 if(map.get("reqType")!=null){
		 reqType=(String)map.get("reqType");
	 }
	 
	 if(map.get("hospitalId")!=null)
	 {
		 hospitalId=(Integer)map.get("hospitalId");
	 }
	 
	 int userId=0;
	 	List<MasEmployee> gridEmployeeList = new ArrayList<MasEmployee>();
		List<Users> userList = new ArrayList<Users>();
		List<Users> userList1 = new ArrayList<Users>();
		
				
		 if(map.get("userId")!=null){
				 userId=(Integer)map.get("userId");
		 }
			
		 if(map.get("hospitalId")!=null)
		 {
			 hospitalId=(Integer)map.get("hospitalId");
		 }
		try {
				c = session.createCriteria(Complain.class).add(
					Restrictions.eq("Hospital.Id", hospitalId)).add(
					Restrictions.between("ComplainDate",fromDate,toDate));
			
				if (userName !=0) {
					c = c.add(Restrictions.eq("RequestBy.Id", userName));
				}
				
				if (!reqType.equals("")) {
					c = c.add(Restrictions.eq("RequestType", reqType));
				}
				searchComplainList = c.list();
			} 
		catch (HibernateException e) {
				e.printStackTrace();
			}
		//Map<String, Object> dataMap = new HashMap<String, Object>();
		 userList=session.createCriteria(Users.class).add(Restrictions.eq("Employee.Id", userId)).add(Restrictions.eq("Status", "y")).list();
			
		 String quey="select e.employee_id, r.rank_name, e.first_name, e.last_name"+
			" from users u"+
			" left outer join mas_employee e on u.EMPLOYEE_ID= e.EMPLOYEE_ID"+
			" left outer join mas_rank r on e.rank_id=r.rank_id"+
			" where u.STATUS='y'";
		
		 userList1=session.createSQLQuery(quey).list();
					 
		if(userList.size()>0){
			map.put("userList", userList);
		}
		if(searchComplainList.size()>0){
			map.put("searchComplainList", searchComplainList);
		}
		
		//gridEmployeeList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Id", reqBy)).list();
		
		gridEmployeeList=session.createCriteria(MasEmployee.class).list();
		
		if(gridEmployeeList.size()>0){
			map.put("gridEmployeeList", gridEmployeeList);
		}
					
		map.put("userList1", userList1);
	 			
	return map;
	
}

//------Methods of Discussion Board By Kiran


@Override
public Map<String, Object> answerFaqJsp(Map<String, Object> map) {
	
	int hospitalId=0;
	int questionId=0;
	int groupId=0;
	
	List<QuestionFaq> QuestionList = new ArrayList<QuestionFaq>();
	List<AnswerFaq> AnswerList = new ArrayList<AnswerFaq>();
	
	Session session = (Session)getSession();
			
	 if(map.get("hospitalId")!=null)
	 {
		 hospitalId=(Integer)map.get("hospitalId");
	 }
	 
	 if(map.get("questionId")!=null)
	 {
		 questionId=(Integer)map.get("questionId");
	 }
	 
	 if(map.get("groupId")!=null)
	 {
		 groupId=(Integer)map.get("groupId");
	 }
	 
	QuestionList=session.createCriteria(QuestionFaq.class).add(Restrictions.eq("Hospital.Id", hospitalId)).add(
			Restrictions.eq("Id", questionId)).list();
	
	AnswerList=session.createCriteria(AnswerFaq.class).add(Restrictions.eq("Hospital.Id", hospitalId)).add(
			Restrictions.eq("GroupId.Id", questionId)).list();
	
	if(QuestionList.size()>0){
		map.put("QuestionList", QuestionList);
	}
		
	if(AnswerList.size()>0){
		map.put("AnswerList", AnswerList);
	}
		
	map.put("QuestionList", QuestionList);
	map.put("AnswerList", AnswerList);
	map.put("questionId", questionId);
return map;
}

@Override
public Map<String, Object> askQuestionJsp(Map<String, Object> map) {
	
	return map;
}

@Override
public Map<String, Object> questionFaqJsp(Map<String, Object> map) {
	
	int hospitalId=0;
	int questionId=0;
	
	List<Object[]> QuestionList = new ArrayList<Object[]>();
	List<Object[]> MaxList = new ArrayList<Object[]>();
	List<BigDecimal> ansFaqList = new ArrayList<BigDecimal>();
	BigDecimal AnsNumber=new BigDecimal(0);
	
	Session session = (Session)getSession();
	
	try{
		
	
	 if(map.get("hospitalId")!=null)
	 {
		 hospitalId=(Integer)map.get("hospitalId");
	 }
		
	 if(map.get("questionId")!=null)
	 {
		 questionId=(Integer)map.get("questionId");
	 }
		
	String qury="select a.group_id, a.question_name, count(b.answer_id), a.last_change_by, a.last_change_date, a.last_change_time, a.question  from question_faq a left outer join answer_faq b on a.group_id  = b.group_id group by a.group_id, a.question,a.last_change_by, a.last_change_date, a.last_change_time, a.question_name";
	QuestionList= session.createSQLQuery(qury).list();
	
		
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	
	if(QuestionList.size()>0){
		map.put("QuestionList", QuestionList);
	}
		
	map.put("QuestionList", QuestionList);
		
return map;
}

@Override
public boolean submitAskQuestion(QuestionFaq q) {
	
	boolean successfullyAdded = false;
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	hbt.save(q);
	successfullyAdded = true;
	return successfullyAdded;

	
}

@Override
public boolean submitPostAnswer(AnswerFaq a) {
	
	boolean successfullyAdded = false;
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	hbt.save(a);
	successfullyAdded = true;
	return successfullyAdded;

	
}


@Override
public Map<String, Object> searchDiscussionBoard(Map<String, Object> map) {
	
	int hospitalId=0;
	String searchText ="";
	String moduleName="";
	Criteria c = null;

	List<QuestionFaq> QuestionList = new ArrayList<QuestionFaq>();
	
	Session session = (Session) getSession();

	 if(map.get("searchText")!=null){
		 searchText=(String)map.get("searchText");
	 }
	 
	 if(map.get("moduleName")!=null){
		 moduleName=(String)map.get("moduleName");
	 }
	 
	 if(map.get("hospitalId")!=null)
	 {
		 hospitalId=(Integer)map.get("hospitalId");
	 }

	 String quey="select a.group_id, a.question_name, count(b.answer_id), a.last_change_by, a.last_change_date, a.question from question_faq a left outer join answer_faq b on a.group_id  = b.group_id where upper(a.question_name) like upper('%"+searchText+"%') ";
	
	 if(!moduleName.equals("")){
		 quey += " and a.module_name= '"+moduleName+"'";
	 }
	 quey += " group by a.group_id, a.question,a.last_change_by, a.last_change_date, a.question_name";
		
QuestionList=session.createSQLQuery(quey).list();
			
		if(QuestionList.size()>0){
			map.put("QuestionList", QuestionList);
		}
 							
return map;
}

@Override
public Map<String, Object> getDoctorRoasterDetails(Map<String, Object> map) {
	
	int hospitalId=0;
    int departmentId = 0;
    int doctorId =0;
    Date fromDate =null;
    Date toDate =null;
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();

	
	List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
	List<MasEmployeeDepartment> empDeptList = new ArrayList<MasEmployeeDepartment>();
	List<DoctorRoaster> docRoasterList = new ArrayList<DoctorRoaster>();
	Session session = (Session)getSession();
	List empList= new ArrayList();	
	Date currentDate = new Date();
	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	try {
		currentDate = df.parse(df.format(currentDate));
	} catch (ParseException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	Criteria crit =null;
	boolean view =true;
	 if(map.get("hospitalId")!=null)
	 {
		 hospitalId=(Integer)map.get("hospitalId");
	 }
	 if(map.get("doctorId")!=null)
	 {
		 doctorId=(Integer)map.get("doctorId");
	 }
	 if(map.get(DEPARTMENT_ID)!=null)
	 {
		 departmentId=(Integer)map.get(DEPARTMENT_ID);
	 }
	 if(map.get("fromDate")!=null)
     {
		 fromDate = HMSUtil.convertStringTypeDateToDateType((String)map.get("fromDate"));
			Calendar c = Calendar.getInstance();
			c.setTime(fromDate);
			c.add(Calendar.DATE, 6); 
			toDate = c.getTime();
     }
	 if(fromDate!=null){
		 
			//System.out.println("fromDate.compareTo(currentDate) "+fromDate.compareTo(currentDate) );
		
		// System.out.println("fromDate "+fromDate +"currentDate="+currentDate);
	 if(fromDate.compareTo(currentDate) >=0)
		 view =false;
	 }

	 String	empCategoryCodeForDoctor = HMSUtil.getValuesFromPropertiesFile("adt.properties", "empCategoryCodeForDoctor");
	 String	departmentTypeCode =HMSUtil.getValuesFromPropertiesFile("adt.properties", "departmentTypeCodeForOpd");
		
	   departmentList = session.createCriteria(MasDepartment.class)
				.add(Restrictions.eq("Status","y").ignoreCase())
				.createAlias("DepartmentType", "dt")
				.add(Restrictions.eq("dt.DepartmentTypeCode",departmentTypeCode))
				.addOrder(Order.asc("DepartmentName"))
				.list();
	   
	   crit =session.createCriteria(MasEmployeeDepartment.class)
				.createAlias("Department", "dept")
				.add(Restrictions.eq("dept.Id",departmentId))
				.add(Restrictions.eq("Status","y").ignoreCase());
				
	   if(doctorId!=0)
			crit.add(Restrictions.eq("Employee.Id",doctorId));
	   
	   empDeptList = crit.list();
		
		for(MasEmployeeDepartment empDept :empDeptList)
		{ 
			empList.add(empDept.getEmployee().getId());
		}
		if(empDeptList.size() >0)
		{
			crit = session.createCriteria(MasEmployee.class)
				 .add(Restrictions.eq("Status","y").ignoreCase())  
				 .add(Restrictions.eq("Hospital.Id",hospitalId))
				.createAlias("EmpCategory", "ec")					
				.add(Restrictions.eq("ec.EmpCategoryCode", empCategoryCodeForDoctor))
				.add(Restrictions.in("Id", empList));
			if(doctorId!=0)
				crit.add(Restrictions.eq("Id",doctorId));
			
			doctorList = crit.list();
				
		}
		
		Map<Integer, List<DoctorRoaster>> RoasterMap = new HashMap<Integer, List<DoctorRoaster>>();
		
		
		crit = session.createCriteria(DoctorRoaster.class)
				 .add(Restrictions.eq("Department.Id",departmentId))  
				// .add(Restrictions.eq("Hospital.Id",hospitalId))
				.add(Restrictions.between("RoasterDate", fromDate, toDate));
		if(doctorId!=0)
			crit.add(Restrictions.eq("Doctor.Id",doctorId));
		docRoasterList = crit.list();
		
		System.out.println("docRoasterList "+docRoasterList.size());
		
		Criteria c = session.createCriteria(DoctorRoaster.class) .add(Restrictions.eq("Department.Id",departmentId)).add(Restrictions.between("RoasterDate", fromDate, toDate))  ;
	    c.setProjection(Projections.projectionList().add(Projections.groupProperty("Doctor")));
	    List<MasEmployee> docIdList = c.list();
		
	    for(MasEmployee empId:docIdList)
	    {
	    	crit = session.createCriteria(DoctorRoaster.class)
					 .add(Restrictions.eq("Department.Id",departmentId))
					 .add(Restrictions.eq("Doctor.Id",empId.getId()))
					//.add(Restrictions.eq("Hospital.Id",hospitalId))
					.add(Restrictions.between("RoasterDate", fromDate, toDate));
	    	if(doctorId!=0)
				crit.add(Restrictions.eq("Doctor.Id",doctorId));
	    	docRoasterList = crit.list();
	    	if(docRoasterList.size()>0)
	    	RoasterMap.put(empId.getId(), docRoasterList);
	    	if(doctorList.contains(empId))
	    	{
	    		doctorList.remove(empId);
	    	}
	    }
	    
	   /* ArrayList<DoctorRoaster> ls=(ArrayList)RoasterMap.get(2104);
	    for(DoctorRoaster rm:ls)
	    {
	    	
	    }*/
	    
	    
	    
	    
	    
/*	    for (Map.Entry<Integer, List<DoctorRoaster>> pair : RoasterMap.entrySet()) {
	    	System.out.println(pair.getKey());
	    	for(List<DoctorRoaster> d: (List<DoctorRoaster>)pair.getValue())
	    	{
	    		
	    	}
	    }*/
		//System.out.println("docRoasterList "+docRoasterList.size() +departmentList.size() +docIdList.size());
	  map.put("doctorList", doctorList);
	  map.put("departmentList", departmentList);
	  map.put("docRoasterList", docRoasterList); //d
	  map.put("view", view);
	  map.put("RoasterMap", RoasterMap);
	  map.put("doctorList", doctorList);
	  return map;
   }


public Map<String, Object> submitDoctorRoasterDetails(Map<String, Object> mapForDS) {
	Session session = (Session) getSession();
	Map<String, Object> map = new HashMap<String, Object>();
	//Map<String, Object> mapForDS = new HashMap<String, Object>();
	// ------- variables declaration-------
	boolean dataSaved = false;
	 int hiddenValue = 0;
     int totalColumn1 = 0;
     int deptId = 0;
     String currentTime = null;
     int userId=0;
     Date currentDate = null;
     
     Date roasterDate= null;
  
     String roasterValue = null;
     List<Integer> doctorIdList = new ArrayList<Integer>();
     List<Date> roasterDateList = new ArrayList<Date>();
     List<String> roasterValueList = new ArrayList< String>();
     List<Integer> roasterIdList = new ArrayList<Integer>();
     List<String> ctList = (List) mapForDS.get("ctList");
     
     if(mapForDS.get("deptId")!=null)
     {
    	 deptId = (Integer)mapForDS.get("deptId");
     }
     
     if(mapForDS.get("doctorIdList")!=null)
     {
    	 doctorIdList = (List<Integer>)mapForDS.get("doctorIdList");
     }
     
     if(mapForDS.get("roasterDateList")!=null)
     {
    	 roasterDateList = (List<Date>)mapForDS.get("roasterDateList");
     }
     if(mapForDS.get("roasterValueList")!=null)
     {
    	 roasterValueList = (List< String>)mapForDS.get("roasterValueList");
     }
     if(mapForDS.get("roasterIdList")!=null)
     {
    	 roasterIdList = (List< Integer>)mapForDS.get("roasterIdList");
     }
    // System.out.println("roasterIdList data "+roasterIdList.size());
     if(mapForDS.get("totalColumn1")!=null)
     {
    	 totalColumn1 = (Integer)mapForDS.get("totalColumn1");
     }

     if(mapForDS.get("currentDate")!=null)
     {
    	 currentDate = HMSUtil.convertStringTypeDateToDateType((String)mapForDS.get("currentDate"));
     }
     if(mapForDS.get("currentTime")!=null)
     {
    	 currentTime = (String)mapForDS.get("currentTime");
     }
     
     if(mapForDS.get("userId")!=null)
     {
    	 userId = (Integer)mapForDS.get("userId");
     }
     
     org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			DoctorRoaster dc = new DoctorRoaster();
			MasDepartment md = new MasDepartment();
			md.setId(deptId);
			MasEmployee masEmp = null;
			Users user = new Users();
			user.setId(userId);
			int i=0;
			for(int docId:doctorIdList)
			{
				
				
				//for(int j=0;j<=totalColumn;j++)
				//System.out.println(roasterDateList.size());
				for(int j=0;j<totalColumn1;j++)
				{
					
					 roasterValue ="";
					 //roasterDate = HMSUtil.convertStringTypeDateToDateType(roasterDateList.get(j));
					 roasterDate = roasterDateList.get(j);
					 
					 if(roasterIdList.get(i)!=0)
						 dc = (DoctorRoaster)hbt.get(DoctorRoaster.class, roasterIdList.get(i));
					 else
					     dc = new DoctorRoaster();
					 masEmp =new MasEmployee();
					 masEmp.setId(docId);
					 dc.setDoctor(masEmp);
					 dc.setDepartment(md);
					 dc.setRoasterDate(roasterDate);
					 dc.setChgDate(currentDate);
					 dc.setChgTime(currentTime);
					 dc.setChgBy(user);
					 dc.setRoasterValue(roasterValueList.get(i));
					// System.out.println("j= "+j +"val="+roasterValueList.get(j));
					// System.out.println("i="+i+"j="+j+" docId "+docId);
					// System.out.println("doc "+masEmp.getId());
					 hbt.saveOrUpdate(dc);
					// System.out.println("i="+i+ " d= "+dc.getDoctor().getId());
					 i++;
				}
			
				hbt.flush();
			}
			
			tx.commit();
			dataSaved =true;
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
     map.put("dataSaved", dataSaved);
	return map;
	
   }




public Map<String, Object> doResetPassword(Map<String, Object> dataMap) {
	Map<String, Object> map = new HashMap<String, Object>();
	String empNo = "";
	HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);

	if (dataMap.get("empNo") != null) {
		empNo = (String) dataMap.get("empNo");
	}
	Session session = (Session) getSession();
	List<MasEmployee> empList = new ArrayList<MasEmployee>();
	
	List<Users> checkUser = new ArrayList<Users>();
	
	empList = hbt
			.find("from jkt.hms.masters.business.MasEmployee where ServiceNo='"
					+ empNo + "' and Status='y'");
	int employeeId = 0;
	int userId=0;
	String Msg = "";
	if(empList.size()>0)
	{
		 employeeId = empList.get(0).getId();
		 checkUser = hbt.find("from jkt.hms.masters.business.Users where Employee.Id="
					+ employeeId + "");
		if(checkUser.size()>0)
		{
				userId  = checkUser.get(0).getId();
				String ActiveStatus=checkUser.get(0).getStatus();
				if(ActiveStatus.equalsIgnoreCase("y"))
				{
					Users userObj = new Users();
					userObj = (Users) getHibernateTemplate().get(Users.class, userId);
						if(userObj != null)
						{                                                							                                                   						
							userObj.setResetFlag("y");   
							Date changedDate = new Date();						
							userObj.setResetReqOn(changedDate);	
						             
		                 
							HibernateTemplate hbt1 = getHibernateTemplate();
							hbt1.setFlushModeName("FLUSH_EAGER");
							hbt1.setCheckWriteOperations(false);
							hbt1.update(userObj);
							hbt1.refresh(userObj);
							Msg = "Reset Request submitted Sucessfully to IT Department. Please cordinate with them";
						}
				}
				else
				{
					Msg = "Users is not activated. Please contact with IT Department.";
				}
			
		}
		else
		{
			Msg = "Users does not exist to this Employee No.";
		}
	}
	else
	{
		Msg = "Employee No does not Exist.";
	}
	
	
	
	
	map.put("Msg", Msg);
	return map;
}

@Override
public Map<String, Object> getListOfPasswordReset(Box box) {
	Map<String,Object> datamap = new HashMap<String,Object>();
	List<Users> userList = new ArrayList<Users>();
	
	Session session = (Session) getSession();
	int pagingSize = 10;
	int pageNo = 1;		


	
	if (box.getString("PN") != null)
		pageNo = Integer.parseInt(box.getString("PN"));			
	
	
	
	
	Criteria cr = null;
	cr = session.createCriteria(Users.class);
	cr = cr.addOrder(Order.asc("ResetReqOn"));
	
	
	
	cr = cr.add(Restrictions.eq("ResetFlag", "y").ignoreCase());
	
	List totalMatches = cr.list();
	cr = cr.setFirstResult(pagingSize * (pageNo - 1));
	cr = cr.setMaxResults(pagingSize);
	userList = cr.list();

	System.out.println("Total records=" + totalMatches.size());
	int totalRecords = totalMatches.size();
	totalMatches.clear();

	System.out.println("Size of userList in dataservice="
			+ userList.size());

	datamap.put("userList", userList);
	datamap.put("totalRecords", totalRecords);

	return datamap;

}


@Override
public Map<String, Object> submitResetDetails(Box box) {
	
	Map<String,Object>datamap = new HashMap<String,Object>();
	
	String DiscrepancyFlag="N";
	Session session = (Session) getSession();
	Transaction tx = null;
	boolean bSuccessfullyAdded = false;
	
	String message= "";
	//String ProjectionSystemGeneratedHeaderId = "PRJ001";
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);	
	
	Date changedDate = new Date();
	
	
	
	Map<String, Object> adMap = new HashMap<String, Object>();
		  	   
			   
			   
				
				
				try{
					
					tx = session.beginTransaction();		

					
					String tableRowId = "";
					tableRowId = box.getString("tableRowId");
					
					System.out.println("tableRowId="+tableRowId);

					String array_RowId[];
					array_RowId = tableRowId.split(",");
					System.out.println("array_RowId="+array_RowId+"tableRowId="+tableRowId);

					double HashQty =0;
					double HashValue=0;
					if (tableRowId != "") 
					{
						for (int i = 0; i < array_RowId.length; i++)
						{
																
							int UserId= Integer.parseInt(array_RowId[i]);
							
							Users userObj = new Users();
							userObj = (Users) getHibernateTemplate().get(Users.class, UserId);
								if(userObj != null)
								{                                               							                                                   						
									userObj.setResetFlag("y"); 													
									userObj.setResetCompleteOn(changedDate);	
									int count = userObj.getResetCount()!=null?userObj.getResetCount():0;
									count = count+1;
									userObj.setResetCount(count);
									userObj.setResetFlag("n");
									String defaultPassword = HMSUtil.getProperties("adt.properties", "defaultPassword").trim();
									System.out.println("defaultPassword="+defaultPassword);
								             
									try {
										userObj.setStatusSHA1("y");
										userObj.setPassword(EncryptPwd.SHA1(defaultPassword));
									} catch (NoSuchAlgorithmException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (UnsupportedEncodingException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									HibernateTemplate hbt1 = getHibernateTemplate();
									hbt1.setFlushModeName("FLUSH_EAGER");
									hbt1.setCheckWriteOperations(false);
									hbt1.update(userObj);
									hbt1.refresh(userObj);									
								}
							
														
							
							
						}
					}	
							
							
							
						
					
					tx.commit();
					bSuccessfullyAdded = true;
				}
				
				catch(Exception e)
				{
					System.out.println("dd="+e);
					if (tx != null) {
						tx.rollback();
						e.printStackTrace();
						System.out.print(e);
					}
				}
			   
		  
	
	
	
			if (bSuccessfullyAdded) {
				
					message = "Details of Reset Password submitted sucessfully: ";
				
				
			} else {

				message = "Try Again!";
			}		

	datamap.put("message", message);
	datamap.put("bSuccessfullyAdded", bSuccessfullyAdded);

	
	
	return datamap;	
	
	
}

}
