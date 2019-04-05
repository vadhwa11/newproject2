package jkt.security.masters.dataservice;

import static jkt.hms.util.RequestConstants.CHARGE_CODE_ID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;

import jkt.hms.masters.business.EmpGroups;
import jkt.hms.masters.business.GroupApplication;
import jkt.hms.masters.business.MasApplication;
import jkt.hms.masters.business.MasButtonForm;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.OpdTemplate;
import jkt.hms.masters.business.UserButtonRights;
import jkt.hms.masters.business.UserDepartment;
import jkt.hms.masters.business.UserEmpGroup;
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
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import securityenc.EncryptPwd;

public class SuperAdminMasterDataServiceImpl extends HibernateDaoSupport
		implements SuperAdminMasterDataService {
	Map<String, Object> map = new HashMap<String, Object>();

	@SuppressWarnings( { "unchecked" })
	public Map checkForExistingHospital(String hospitalCode, String hospitalName) {

		List<MasHospital> codeList = new ArrayList<MasHospital>();
		List<MasHospital> nameList = new ArrayList<MasHospital>();

		codeList = getHibernateTemplate()
				.find(
						"from jkt.security.masters.business.MasHospital as hm where hm.HospitalCode = '"
								+ hospitalCode + "' ");
		nameList = getHibernateTemplate()
				.find(
						"from jkt.security.masters.business.MasHospital as hm where hm.HospitalName = '"
								+ hospitalName + "'");
		map.put("codeList", codeList);
		map.put("nameList", nameList);

		return map;
	}

	public boolean addHospital(MasHospital hospitalMaster) {
		boolean bool = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			hbt.save(hospitalMaster);
			bool = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bool;
	}

	@SuppressWarnings("unchecked")
	public List<MasHospital> getHospitalNameList(String hospitalCode,
			String hospitalName) {

		List<MasHospital> hospitalNameList = new ArrayList<MasHospital>();

		if ((hospitalCode.equals(""))
				&& !(hospitalName.equalsIgnoreCase(""))
				|| (!(hospitalCode.equals("")) && !(hospitalName
						.equalsIgnoreCase("")))) {
			hospitalNameList = getHibernateTemplate()
					.find(
							"from jkt.security.masters.business.MasHospital as hm where  hm.HospitalName like '"
									+ hospitalName + "%'");
		}
		return hospitalNameList;

	}

	@SuppressWarnings("unchecked")
	public List<MasHospital> getHospitalMasterList(int hospitalId) {
		List<MasHospital> hospitalMasterList = new ArrayList<MasHospital>();
		hospitalMasterList = getHibernateTemplate().find(
				"from jkt.security.masters.business.MasHospital as hm where hm.Id = "
						+ hospitalId);
		return hospitalMasterList;
	}

	@SuppressWarnings("unchecked")
	public List<MasHospital> checkExistingHospitalForEdit(int hospitalId,
			String hospitalName) {

		List<MasHospital> hospitalMasterNameList = new ArrayList<MasHospital>();
		hospitalMasterNameList = getHibernateTemplate()
				.find(
						"from jkt.security.masters.business.MasHospital as hm where hm.HospitalName = '"
								+ hospitalName + "' and hm.Id != " + hospitalId);

		return hospitalMasterNameList;

	}

	public boolean updateHospital(MasHospital hospitalMaster) {
		boolean dataFixed = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hospitalMaster);
			dataFixed = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataFixed;

	}

	public boolean deleteHospital(int hospitalId) {
		boolean dataDeleted = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			MasHospital hospitalMaster = new MasHospital();
			hospitalMaster = (MasHospital) hbt.load(MasHospital.class,
					hospitalId);

			String hospName = hospitalMaster.getHospitalName();
			hospitalMaster.setStatus("n");
			hbt.update(hospitalMaster);
			dataDeleted = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dataDeleted;

	}

	@SuppressWarnings("unchecked")
	public List getTableRecords(Map<String, Object> mapForDs) {

		List enquiryList = new ArrayList();
		String pojoName = (String) mapForDs.get("pojoName");
		String searchName = (String) mapForDs.get("searchName");
		String pojoPropertyName = (String) mapForDs.get("pojoPropertyName");
		try {
			enquiryList = getHibernateTemplate().find(
					"from jkt.security.masters.business." + pojoName
							+ " as master where master." + pojoPropertyName
							+ " like '" + searchName + "%'");
		} catch (Exception e) {
e.printStackTrace();		}

		return enquiryList;
	}

	public boolean editHospitalToDatabase(Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return false;
	}

	public Map<String, Object> searchHospital(String hospitalCode,
			String hospitalName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Object> showHospitalMasterJsp() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Object> showModuleManagementJsp(Box box) {
		Session session = (Session) getSession();

		List<Users> users = new ArrayList<Users>();
		// Set inPatientSet= new HashSet();
		// Map<String,Object>map= new HashMap<String, Object>();
		String userSearch = box.getString("userSearch").trim();
		String loginSearch = box.getString("loginSearch").trim();

		org.hibernate.Criteria criteria = null;
		try {
			criteria = session.createCriteria(Users.class).add(
					Restrictions.eq("Status", "y"));

			if (userSearch != null) {
				criteria = criteria.add(Restrictions.like("UserName", "%"
						+ userSearch + "%"));
			}
			if (loginSearch != null) {
				criteria = criteria.add(Restrictions.like("LoginName", "%"
						+ loginSearch + "%"));
			}
			users = criteria.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		// Iterator itr= users.iterator();
		// while(itr.hasNext())
		// {
		// Users userObj=(Users)itr.next();
		// String userName=userObj.getUserName();
		//			
		// }
		map.put("users", users);
		return map;
	}

	public Map<String, Object> showUserManagementJsp(int userId) {

		Session session = (Session) getSession();
		List<Object> userList = new ArrayList<Object>();
		try {

			userList = session.createCriteria(Users.class).add(
					Restrictions.eq("Id", userId)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("userList", userList);

		return map;
	}

	public Map<String, Object> getGroupList(int hospitalId) {
		Session session = (Session) getSession();
		List<Object> groupList = new ArrayList<Object>();
		try {

			groupList = session.createQuery(
					"select ugh from UsergroupHospital as ugh where ugh.Hospital.Id="
							+ hospitalId).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("groupList", groupList);

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getApplicationGroupWise(int groupId) {
		Session session = (Session) getSession();
		String parentAppId = "";
		List<Object> applicationListGroupWise = new ArrayList<Object>();
		try {
			// applicationListGroupWise =
			// session.createQuery("select gh from GroupApplication as gh where gh.Group.Id="+
			// groupId+).list();
			applicationListGroupWise = session.createCriteria(
					GroupApplication.class).createAlias("App", "app")
					.createAlias("Group", "group").add(
							Restrictions.eq("group.Id", groupId)).addOrder(
							Order.asc("app.OrderNo")).add(
							Restrictions.eq("Status", "y")).list();
			Iterator itr = applicationListGroupWise.iterator();
			while (itr.hasNext()) {
				GroupApplication groupApplication = (GroupApplication) itr
						.next();
				if (groupApplication.getApp().getParentId().equals("0")) {
					parentAppId = groupApplication.getApp().getId();
					break;
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("parentAppId", parentAppId);
		map.put("applicationListGroupWise", applicationListGroupWise);
		return map;
	}

	public Map<String, Object> getMasterApplicationList(int userId) {
		Session session = (Session) getSession();
		List<Object> masApplicationList = new ArrayList<Object>();
		List<Object> userList = new ArrayList<Object>();
		try {
			
			masApplicationList = session.createQuery(
					" from MasApplication as masApp ").list();
			userList = session.createCriteria(Users.class).add(
					Restrictions.eq("Id", userId)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("masApplicationList", masApplicationList);
		map.put("userList", userList);
		return map;
	}

	public int getGroupIdFromGroupHospitalId(int groupHospitalId) {
		Session session = (Session) getSession();
		List<Object> groupIdList = new ArrayList<Object>();
		try {

			groupIdList = session.createQuery(
					" from UsergroupHospital as ugh  where ugh.Id="
							+ groupHospitalId).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		UsergroupHospital usergroupHospital = (UsergroupHospital) groupIdList
				.get(0);
		int groupId = usergroupHospital.getGroup().getId();

		return groupId;
	}

	public boolean submitUserWiseApplication(Map map) {

		Session session = (Session) getSession();
		List<Object> groupIdList = new ArrayList<Object>();
		boolean successfullyAdded = false;
		UserUsergroupApplication userUsergroupApplication;
		int userId = (Integer) map.get("userId");
		int groupHospitalId = (Integer) map.get("groupHospitalId");
		Box box = null;
		if (map.get("box") != null) {
			box = (Box) map.get("box");
		}
		
		/*List orderApplicationList =(List) map.get("orderApplicationList");
System.out.println("orderApplicationList---DS----"+orderApplicationList);*/
		String parentAppId = (String) map.get("parentAppId");
		List groupApplicationList = (List) map.get("groupApplicationList");
		List<GroupApplication> groupAppArrayList = (List<GroupApplication>) map
				.get("groupAppArrayList");
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			String hql = "delete from UserUsergroupApplication as uuga where uuga.GroupHospital.Id like :groupHosId and uuga.User.Id like :userId";
			Query query = session.createQuery(hql).setParameter("groupHosId",
					groupHospitalId).setParameter("userId", userId);
			int row = query.executeUpdate();
			if (row > 0) {
				successfullyAdded = true;
			}

			if (groupApplicationList != null && groupApplicationList.size() > 0) {
				System.out.println("groupApplicationList--size--"+groupApplicationList.size());
				Iterator iterator = groupApplicationList.iterator();
				while (iterator.hasNext()) {
					userUsergroupApplication = new UserUsergroupApplication();
					int groupApplicationId = (Integer) iterator.next();

					GroupApplication groupApplication = new GroupApplication();
					groupApplication.setId(groupApplicationId);
					userUsergroupApplication.setGroupApp(groupApplication);
					UsergroupHospital usergroupHospital = new UsergroupHospital();
					usergroupHospital.setId(groupHospitalId);
					userUsergroupApplication
							.setGroupHospital(usergroupHospital);
					Users users = new Users();
					users.setId(userId);
					userUsergroupApplication.setUser(users);
					userUsergroupApplication.setStatus("y");

					hbt.save(userUsergroupApplication);

					successfullyAdded = true;

				}

				if (groupAppArrayList != null && groupAppArrayList.size() > 0) {
					for (GroupApplication groupApplication : groupAppArrayList) {
						String parentId = groupApplication.getApp()
						.getParentId();
						int groupAppId = groupApplication.getId();
						if (parentId.equals("0")) {

							List<UserUsergroupApplication> checkParentAppList = session
							.createCriteria(
									UserUsergroupApplication.class)
									.createAlias("GroupApp", "groupApp")
									.createAlias("GroupHospital",
									"groupHospital").createAlias(
											"User", "user").add(
													Restrictions.eq("groupApp.Id",
															groupAppId)).add(
																	Restrictions.eq("groupHospital.Id",
																			groupHospitalId)).add(
																					Restrictions.eq("user.Id", userId))
																					.list();
							if (checkParentAppList != null
									&& checkParentAppList.size() > 0) {
								userUsergroupApplication = checkParentAppList
								.get(0);
								String statusOfApp = userUsergroupApplication
								.getStatus();
								if (statusOfApp.equals("n")) {
									userUsergroupApplication.setStatus("y");
									hbt.update(userUsergroupApplication);
								}

							

							} else {
								userUsergroupApplication = new UserUsergroupApplication();
								GroupApplication groupApplication2 = new GroupApplication();
								groupApplication2.setId(groupAppId);
								userUsergroupApplication
								.setGroupApp(groupApplication2);
								UsergroupHospital usergroupHospital = new UsergroupHospital();
								usergroupHospital.setId(groupHospitalId);
								userUsergroupApplication
								.setGroupHospital(usergroupHospital);
								Users users = new Users();
								users.setId(userId);
								userUsergroupApplication.setUser(users);
								hbt.save(userUsergroupApplication);
							}
							//--Added By Dipali For update order no (2-may-2013)---	
							Vector order_no = box.getVector("order_no");
							Vector app_id = box.getVector("app_id");
							if (order_no != null && !order_no.equals("") && !order_no.equals("0")) {
								for (int i = 0; i < order_no.size(); i++) {
									MasApplication masApp = new MasApplication();
									masApp = (MasApplication) hbt.load(MasApplication.class,app_id.get(i).toString());
									masApp.setOrderNo(Integer.parseInt((String)order_no.get(i)));
									hbt.update(masApp);
									hbt.refresh(masApp);
								}}
						}


					}
				}
			
			}
		
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return successfullyAdded;
	}

	public Map<String, Object> getUserUsergroupApplicationList(int userId,
			int groupHospitalId, String parentAppId) {
		Session session = (Session) getSession();
		List<Object> userUsergroupApplicationList = new ArrayList<Object>();
		List<MasApplication> applicationList = new ArrayList<MasApplication>();
		List<Integer> maxOrderNoList = new ArrayList<Integer>();
		try {

			userUsergroupApplicationList = session.createQuery(
					"select uugh from UserUsergroupApplication as uugh join uugh.GroupHospital gh where uugh.User.Id="
							+ userId).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	/*	Iterator itr = userUsergroupApplicationList.iterator();
		while (itr.hasNext()) {
			UserUsergroupApplication usergroupApplication = (UserUsergroupApplication) itr
					.next();
			String appName = usergroupApplication.getGroupApp().getApp()
					.getName();
		}*/
		maxOrderNoList = session.createCriteria(MasApplication.class).setProjection(Projections.max("OrderNo")).list();
		applicationList=session.createCriteria(MasApplication.class).add(Restrictions.eq("ParentId",parentAppId)).list();
		map.put("userUsergroupApplicationList", userUsergroupApplicationList);
		map.put("applicationList", applicationList);
		map.put("maxOrderNoList", maxOrderNoList);
		return map;
	}

	public Map<String, Object> getDepartmentList() {
		// TODO Auto-generated method stub
		Session session = (Session) getSession();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<UserDepartment> searchUserDepartmentList = new ArrayList<UserDepartment>();
		try {
			departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).list();
			searchUserDepartmentList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.UserDepartment as ud order by ud.Department.DepartmentName asc ");
			// userDeptList = session.createCriter
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("deptList", departmentList);
		map.put("searchUserDepartmentList", searchUserDepartmentList);

		return map;

	}

	// Added by Kalyan
	public Map<String, Object> updateNewPassowd(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<Users> changeList = new ArrayList<Users>();
		List<Users> usersList = new ArrayList<Users>();

		String message = "";
		String loginUser = (String) dataMap.get("loginUser");
		String pwd = (String) dataMap.get("oldpwd");
		String action = (String) dataMap.get("action");
		String loginName = (String) dataMap.get("loginName");
		String newPwd = (String) dataMap.get("newpwd");
		int userId = (Integer) dataMap.get("userId");
		// code for encryption
		List<Users> userListByLoginName = new ArrayList<Users>();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		// usersList = getHibernateTemplate().find(
		// "from jkt.hms.masters.business.MasEmployee u order by u.FirstName");
		if (action.equals("update")) {
			if (!pwd.equals("")) {
				// changeList=getHibernateTemplate().find(
				// "from jkt.hms.masters.business.Users u where u.LoginName = '"+loginName+"' and u.Password = '"+pwd+"'");
				userListByLoginName = getHibernateTemplate().find(
						"from jkt.hms.masters.business.Users u where u.LoginName = '"
								+ loginUser + "'");
				for (Users users : userListByLoginName) {
					String pwdFromDB = users.getPassword();
					String statusSha1="";
					if(users.getStatusSHA1()!=null){
						statusSha1=users.getStatusSHA1();	
					}
					if(statusSha1.equalsIgnoreCase("n")){
						if (HMSUtil.validatePassword(pwdFromDB, pwd)) {
							changeList.add(users);
						}
					}else if(statusSha1.equalsIgnoreCase("y")){
						System.out.println("********SHA-1********");
						String sha1_pwd="";
						try {
							sha1_pwd=EncryptPwd.SHA1(pwd);
						} catch (NoSuchAlgorithmException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if(pwdFromDB.equalsIgnoreCase(sha1_pwd)){
							changeList.add(users);
						}

					}else{
						if (HMSUtil.validatePassword(pwdFromDB, pwd)) {
							changeList.add(users);
						}
					}
					/*boolean bool = HMSUtil.validatePassword(pwdFromDB, pwd);
					if (HMSUtil.validatePassword(pwdFromDB, pwd)) {
						changeList.add(users);
					}*/
				}
				if (changeList.size() == 0) {
					message = "Your entered wrong password ";
				}
				if (changeList.size() > 0) {
					Users user = (Users) changeList.get(0);
					Users usersObj = (Users) hbt
							.load(Users.class, user.getId());
					// usersObj.setPassword(newPwd);
					//usersObj.setPassword(HMSUtil.encryptPassword(newPwd));
					try {
						usersObj.setStatusSHA1("y");
						usersObj.setPassword(EncryptPwd.SHA1(newPwd));
					} catch (NoSuchAlgorithmException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					hbt.update(usersObj);
					message = "Your Password Updated";
				}
			}
		} else if (action.equals("reset")) {
			if (loginUser.equals("admin")) {
				Users usersObj = (Users) hbt.load(Users.class, userId);
				String userName = (String) usersObj.getLoginName();
				usersObj.setPassword(HMSUtil.encryptPassword(userName));
				try {
					usersObj.setStatusSHA1("y");
					usersObj.setPassword(EncryptPwd.SHA1(newPwd));
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				hbt.update(usersObj);
				message = "Password reseted";
			}
		}
		map.put("changeList", changeList);
		// map.put("usersList",usersList);
		map.put("message", message);
		return map;
	}

	/** method to get dept type **/

	public String getDepartmentTypeCode(int deptId) {
		// TODO Auto-generated method stub
		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();
		String deptType = "";
		try {
			masDepartmentList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Id", deptId)).list();
			if (masDepartmentList != null && masDepartmentList.size() > 0)
				deptType = masDepartmentList.get(0).getDepartmentType()
						.getDepartmentTypeCode();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return deptType;
	}

	// -------------------methods For enhancement of security module Assign
	// application to user-------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> getApplicationListForAutoComplete(Map mapForDS) {
		@SuppressWarnings("unused")
		String appName = "";
		if (mapForDS.get("appName") != null) {
			appName = (String) mapForDS.get("appName");
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		String str = "%" + appName + "%";
		List<MasApplication> applicationsList = new ArrayList<MasApplication>();
		Criteria c = session.createCriteria(MasApplication.class).add(
				Restrictions.like("Name", str));
		c.setFirstResult(0);
		c.setMaxResults(10);
		applicationsList = c.list();
		dataMap.put("applicationsList", applicationsList);
		return dataMap;
	}

	public List<GroupApplication> getGroupForApplication(String applicationId) {
		Session session = (Session) getSession();

		List<GroupApplication> groupList = new ArrayList<GroupApplication>();
		Criteria c = session.createCriteria(GroupApplication.class)
				.createAlias("App", "app").add(
						Restrictions.eq("app.Id", applicationId));
		groupList = c.list();
		return groupList;
	}

	// ------------------------method added for taking out application
	// array---------------
	public Map<String, Object> getGroupApplicationArray(String applicationId) {
		Session session = (Session) getSession();
		String[] applicationArray = null;
		List<MasApplication> appList = new ArrayList<MasApplication>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<GroupApplication> groupAppArrayList = new ArrayList<GroupApplication>();
		MasApplication masApplication = null;
		appList = session.createCriteria(MasApplication.class).add(
				Restrictions.eq("Id", applicationId)).list();
		masApplication = (MasApplication) appList.get(0);

		String parentId = masApplication.getParentId();

		List<GroupApplication> groupList = new ArrayList<GroupApplication>();
		groupList = session.createCriteria(GroupApplication.class).createAlias(
				"App", "app").add(Restrictions.eq("app.Id", applicationId))
				.list();
		GroupApplication groupApplication = groupList.get(0);
		groupAppArrayList.add(groupApplication);

		if (!parentId.equals("0")) {
			appList = session.createCriteria(MasApplication.class).add(
					Restrictions.eq("Id", parentId)).list();
			masApplication = appList.get(0);
			String parentApplicationId = masApplication.getId();
			String parentParentId = masApplication.getParentId();
			groupList = session.createCriteria(GroupApplication.class)
					.createAlias("App", "app").add(
							Restrictions.eq("app.Id", parentApplicationId))
					.list();
			GroupApplication groupApplicationObj = groupList.get(0);
			groupAppArrayList.add(groupApplicationObj);

			if (!parentParentId.equals("0")) {
				appList = session.createCriteria(MasApplication.class).add(
						Restrictions.eq("Id", parentParentId)).list();
				masApplication = appList.get(0);
				String parentParentApplicationId = masApplication.getId();
				groupList = session.createCriteria(GroupApplication.class)
						.createAlias("App", "app").add(
								Restrictions.eq("app.Id",
										parentParentApplicationId)).list();
				GroupApplication groupApplicationObject = groupList.get(0);
				groupAppArrayList.add(groupApplicationObject);
			}
		}
		map.put("groupAppArrayList", groupAppArrayList);
		return map;
	}

	// --------method incomplete adding for taking out application
	// array----------
	public List<UsergroupHospital> getHospitalList(int groupApplicationId,
			int hospitalId) {
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		List<UsergroupHospital> hospitalList = new ArrayList<UsergroupHospital>();

		GroupApplication groupAplication = (GroupApplication) hbt.load(
				GroupApplication.class, groupApplicationId);
		int groupId = groupAplication.getGroup().getId();
		Criteria c = session.createCriteria(UsergroupHospital.class)
				.createAlias("Group", "group").createAlias("Hospital",
						"hospital").add(
						Restrictions.eq("hospital.Id", hospitalId)).add(
						Restrictions.eq("group.Id", groupId));
		hospitalList = c.list();

		return hospitalList;
	}

	public List<UserEmpGroup> getAllUsersListFromUserEmpGroup(int hospitalId) {
		Session session = (Session) getSession();

		List<UserEmpGroup> usersList = new ArrayList<UserEmpGroup>();
		Criteria c = session.createCriteria(UserEmpGroup.class).createAlias(
				"Hospital", "hospital").add(
				Restrictions.eq("hospital.Id", hospitalId));
		usersList = c.list();

		return usersList;
	}

	@SuppressWarnings("unused")
	public List<UserUsergroupApplication> getUserListFromUserUGApp(
			int groupHospitalId, int groupAppId) {

		Session session = (Session) getSession();

		List<UserUsergroupApplication> userUGAppList = new ArrayList<UserUsergroupApplication>();

		userUGAppList = session.createCriteria(UserUsergroupApplication.class)
				.createAlias("GroupHospital", "groupHospital").createAlias(
						"GroupApp", "groupApp").add(
						Restrictions.eq("GroupApp.Id", groupAppId)).add(
						Restrictions.eq("GroupHospital.Id", groupHospitalId))
				.add(Restrictions.eq("Status", "y")).list();
		return userUGAppList;
	}

	public boolean addUserWiseApplication(Map dataMap) {
		Session session = (Session) getSession();
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Transaction tx = null;
		boolean dataSaved = false;
		List<Integer> userIdToBeAdded = (List) dataMap.get("userIdToBeAdded");
		List<Integer> userIdToBeRemoved = (List) dataMap
				.get("userIdToBeRemoved");
		List<GroupApplication> groupAppArrayList = (List) dataMap
				.get("groupAppArrayList");
		// int groupApplicationId=(Integer)dataMap.get("groupApplicationId");
		int groupHospitalId = (Integer) dataMap.get("groupHospitalId");
		try {
			tx = session.beginTransaction();
			for (Integer userId : userIdToBeRemoved) {
				for (GroupApplication groupApplication : groupAppArrayList) {
					int groupApplicationId = groupApplication.getId();
					List userUGAppList = session.createCriteria(
							UserUsergroupApplication.class).createAlias(
							"GroupHospital", "groupHosp").createAlias(
							"GroupApp", "groupApp").createAlias("User", "user")
							.add(
									Restrictions.eq("groupHosp.Id",
											groupHospitalId)).add(
									Restrictions.eq("groupApp.Id",
											groupApplicationId)).add(
									Restrictions.eq("user.Id", userId)).list();
					UserUsergroupApplication userUsergroupApplication = (UserUsergroupApplication) userUGAppList
							.get(0);
					int userUserGroupAppId = userUsergroupApplication.getId();
					UserUsergroupApplication userUsergroupApplicationObj = (UserUsergroupApplication) hbt
							.load(UserUsergroupApplication.class,
									userUserGroupAppId);
					userUsergroupApplicationObj.setStatus("n");
					hbt.update(userUsergroupApplicationObj);

				}
			}

			for (Integer userId : userIdToBeAdded) {
				for (GroupApplication groupApplication : groupAppArrayList) {
					int groupApplicationId = groupApplication.getId();
					List userUGAppList = session.createCriteria(
							UserUsergroupApplication.class).createAlias(
							"GroupHospital", "groupHosp").createAlias(
							"GroupApp", "groupApp").createAlias("User", "user")
							.add(
									Restrictions.eq("groupHosp.Id",
											groupHospitalId)).add(
									Restrictions.eq("groupApp.Id",
											groupApplicationId)).add(
									Restrictions.eq("user.Id", userId)).list();
					if (userUGAppList != null && userUGAppList.size() > 0) {
						UserUsergroupApplication userUsergroupApplication = (UserUsergroupApplication) userUGAppList
								.get(0);
						int userUserGroupAppId = userUsergroupApplication
								.getId();
						UserUsergroupApplication userUsergroupApplicationObj = (UserUsergroupApplication) hbt
								.load(UserUsergroupApplication.class,
										userUserGroupAppId);
						userUsergroupApplicationObj.setStatus("y");
						hbt.update(userUsergroupApplicationObj);
					} else {
						UserUsergroupApplication userUsergroupApplication = new UserUsergroupApplication();
						GroupApplication groupApplicationObj = new GroupApplication();
						groupApplicationObj.setId(groupApplicationId);
						userUsergroupApplication
								.setGroupApp(groupApplicationObj);
						UsergroupHospital usergroupHospital = new UsergroupHospital();
						usergroupHospital.setId(groupHospitalId);
						userUsergroupApplication
								.setGroupHospital(usergroupHospital);
						Users users = new Users();
						users.setId(userId);
						userUsergroupApplication.setUser(users);
						userUsergroupApplication.setAddStatus("y");
						userUsergroupApplication.setDeleteStatus("y");
						userUsergroupApplication.setUpdateStatus("y");
						userUsergroupApplication.setStatus("y");
						hbt.save(userUsergroupApplication);
					}
				}
			}

			dataSaved = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}

		return dataSaved;
	}

	public Map<String, Object> getEmpGroupList() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Session session = (Session) getSession();
			String status = "y";
			List<EmpGroups> empGroupList = new ArrayList<EmpGroups>();
			empGroupList = session.createCriteria(EmpGroups.class).add(
					Restrictions.eq("Status", status)).list();

			map.put("empGroupList", empGroupList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public List<UserEmpGroup> getUsersListFromUserEmpGroup(int empGroupId,
			int groupHospitalId) {
		Session session = (Session) getSession();

		List<UserUsergroupHospital> usersList = new ArrayList<UserUsergroupHospital>();
		List<UserEmpGroup> userEmpGroupList = new ArrayList<UserEmpGroup>();
		userEmpGroupList = session.createCriteria(UserEmpGroup.class)
				.createAlias("EmpGroup", "empGroup").add(
						Restrictions.eq("empGroup.Id", empGroupId)).list();
		/*
		 * for(Iterator itr=userEmpGroupList.iterator();itr.hasNext();){
		 * UserEmpGroup userEmpGroup=(UserEmpGroup)itr.next(); int
		 * userId=userEmpGroup.getUser().getId(); List<UserUsergroupHospital>
		 * userUserGroupHospitalList
		 * =session.createCriteria(UserUsergroupHospital
		 * .class).createAlias("User",
		 * "user").createAlias("GroupHospital","groupHospital"
		 * ).add(Restrictions.eq("user.Id",
		 * userId)).add(Restrictions.eq("groupHospital.Id",
		 * groupHospitalId)).list(); for(UserUsergroupHospital
		 * userUsergroupHospital:userUserGroupHospitalList){ int
		 * userUserGroupHospitalId=userUsergroupHospital.getId();
		 * UserUsergroupHospital user =
		 * (UserUsergroupHospital)getHibernateTemplate
		 * ().load(UserUsergroupHospital.class, userUserGroupHospitalId);
		 * usersList.add(user); }
		 * 
		 * }
		 */
		return userEmpGroupList;
	}

	// -----------------methods added for assign module---------------

	public Map<String, Object> showAssignModuleToEmpGroupJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Session session = (Session) getSession();
			String status = "y";
			List<MasHospital> hospitalList = new ArrayList<MasHospital>();
			hospitalList = session.createCriteria(MasHospital.class).add(
					Restrictions.eq("Status", status)).addOrder(Order.asc("HospitalName")).list();
			map.put("hospitalList", hospitalList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> populateEmpGroupAndAppGroupJsp(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Session session = (Session) getSession();
			String status = "y";

			List<EmpGroups> empGroupList = new ArrayList<EmpGroups>();
			List<UsergroupHospital> groupHospitalList = new ArrayList<UsergroupHospital>();
			if(hospitalId!=0){
			empGroupList = session.createCriteria(EmpGroups.class).add(
					Restrictions.eq("Status", status)).list();
			}
			groupHospitalList = session.createCriteria(UsergroupHospital.class)
					.createAlias("Hospital", "hospital").add(
							Restrictions.eq("Status", status)).add(
							Restrictions.eq("hospital.Id", hospitalId)).list();
			map.put("groupHospitalList", groupHospitalList);
			map.put("empGroupList", empGroupList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public List<MasApplication> getApplicationList(int groupId) {
		Session session = (Session) getSession();
		List<MasApplication> masApplicationList = new ArrayList<MasApplication>();
		try {

			masApplicationList = session.createQuery(
					" from MasApplication as masApp ").list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return masApplicationList;
	}

	public List<UserUsergroupHospital> getUserListFromUserUserGroupHospitalForGroupHospitalId(
			int groupHospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();

		List<UserUsergroupHospital> usersList = new ArrayList<UserUsergroupHospital>();
		Criteria c = session.createCriteria(UserUsergroupHospital.class)
				.createAlias("GroupHospital", "groupHospital").add(
						Restrictions.eq("groupHospital.Id", groupHospitalId))
				.add(Restrictions.eq("Status", "y"));
		usersList = c.list();

		return usersList;
	}

	public List<UserEmpGroup> getUserListFromUserEmpGroup(int empGroupId) {
		Session session = (Session) getSession();

		List<UserEmpGroup> userEmpGroupList = new ArrayList<UserEmpGroup>();
		Criteria c = session.createCriteria(UserEmpGroup.class).createAlias(
				"EmpGroup", "empGroup").add(
				Restrictions.eq("empGroup.Id", empGroupId));
		userEmpGroupList = c.list();

		return userEmpGroupList;
	}

	@SuppressWarnings("unchecked")
	public boolean assignModuleToEmpGroup(Map dataMap) {
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Transaction tx = null;
		boolean dataSaved = false;

		List<Object> applicationListGroupWise = (List) dataMap
				.get("applicationListGroupWise");
		String[] userIdArray = (String[]) dataMap.get("userIdArray");
		String[] appIdArray = (String[]) dataMap.get("appIdArray");
		int groupId = (Integer) dataMap.get("groupId");
		int groupHospitalId = (Integer) dataMap.get("groupHospitalId");
		try {
			tx = session.beginTransaction();

			for (int i = 0; i < userIdArray.length; i++) {

				for (int j = 0; j < appIdArray.length; j++) {
					for (Iterator itr = applicationListGroupWise.iterator(); itr
							.hasNext();) {
						GroupApplication groupApplication = (GroupApplication) itr
								.next();
						if (appIdArray[j].toString().equals(
								groupApplication.getApp().getId())) {
							int groupApplicationId = groupApplication.getId();
							int userId = Integer.parseInt(userIdArray[i]);

							List userUGAppList = session.createCriteria(
									UserUsergroupApplication.class)
									.createAlias("GroupHospital", "groupHosp")
									.createAlias("GroupApp", "groupApp")
									.createAlias("User", "user").add(
											Restrictions.eq("groupHosp.Id",
													groupHospitalId)).add(
											Restrictions.eq("groupApp.Id",
													groupApplicationId)).add(
											Restrictions.eq("user.Id", userId))
									.list();
							if (userUGAppList != null
									&& userUGAppList.size() > 0) {
								UserUsergroupApplication userUsergroupApplication = (UserUsergroupApplication) userUGAppList
										.get(0);
								int userUserGroupAppId = userUsergroupApplication
										.getId();
								UserUsergroupApplication userUsergroupApplicationObj = (UserUsergroupApplication) hbt
										.load(UserUsergroupApplication.class,
												userUserGroupAppId);
								userUsergroupApplicationObj.setStatus("y");
								userUsergroupApplicationObj.setAddStatus("n");
								userUsergroupApplicationObj
										.setDeleteStatus("n");
								userUsergroupApplicationObj
										.setUpdateStatus("n");
								hbt.update(userUsergroupApplicationObj);
							} else {

								UserUsergroupApplication userUsergroupApplication = new UserUsergroupApplication();
								Users user = new Users();
								user.setId(Integer.parseInt(userIdArray[i]));
								userUsergroupApplication.setUser(user);
								GroupApplication groupApplicationObj = new GroupApplication();
								groupApplicationObj.setId(groupApplication
										.getId());
								userUsergroupApplication
										.setGroupApp(groupApplicationObj);
								UsergroupHospital usergroupHospital = new UsergroupHospital();
								usergroupHospital.setId(groupHospitalId);
								userUsergroupApplication
										.setGroupHospital(usergroupHospital);

								userUsergroupApplication.setStatus("y");
								userUsergroupApplication.setAddStatus("n");
								userUsergroupApplication.setDeleteStatus("n");
								userUsergroupApplication.setUpdateStatus("n");
								hbt.save(userUsergroupApplication);
							}
						}
					}
				}
			}

			dataSaved = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}

		return dataSaved;
	}

	public List<UserUsergroupApplication> getUserListFromUUGAppForGroupHospital(
			int groupHospitalId) {
		Session session = (Session) getSession();

		List<UserUsergroupApplication> userUGAppList = new ArrayList<UserUsergroupApplication>();

		userUGAppList = session.createCriteria(UserUsergroupApplication.class)
				.createAlias("GroupHospital", "groupHospital").add(
						Restrictions.eq("GroupHospital.Id", groupHospitalId))
				.add(Restrictions.eq("Status", "y")).list();

		return userUGAppList;

	}

	// ------------------------End of methods for assign
	// module----------------------------------

	// --------------end of methods added for security screen Assign application
	// to user-------------------

	public List<UserEmpGroup> getUserListFromUserEmpGroup(
			Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		int empGroupId = (Integer) dataMap.get("empGroupId");
		int hospitalId = (Integer) dataMap.get("hospitalId");
		List<UserEmpGroup> userEmpGroupList = new ArrayList<UserEmpGroup>();
		Criteria c = session.createCriteria(UserEmpGroup.class).createAlias(
				"EmpGroup", "empGroup").createAlias("Hospital", "hospital")
				.add(Restrictions.eq("empGroup.Id", empGroupId)).add(
						Restrictions.eq("hospital.Id", hospitalId));
		userEmpGroupList = c.list();

		return userEmpGroupList;
	}

	// ----------------------------method added by vikas on
	// 29/04/09-----------------------------

	public Map<String, Object> showAssignButtonRightsToEmpGroupJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Session session = (Session) getSession();
			String status = "y";
			List<EmpGroups> empGroupList = new ArrayList<EmpGroups>();
			List<MasHospital> hospitalList = new ArrayList<MasHospital>();
			List<MasButtonForm> formList = new ArrayList<MasButtonForm>();
			hospitalList = session.createCriteria(MasHospital.class).add(
					Restrictions.eq("Status", status)).list();
			// formList=session.createCriteria(MasButtonForm.class).add(Restrictions.eq("Status",
			// status)).list();
			empGroupList = session.createCriteria(EmpGroups.class).add(
					Restrictions.eq("Status", status)).list();
			formList = session
					.createSQLQuery(
							"select Distinct(form_name) from  mas_button_form where status='y';")
					.list();
			map.put("empGroupList", empGroupList);
			map.put("hospitalList", hospitalList);
			map.put("formList", formList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

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

	public boolean assignButtonRightsToEmpGroup(Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Transaction tx = null;
		boolean dataSaved = false;

		String[] buttonNameArray = (String[]) dataMap.get("buttonNameArray");
		String[] userIdArray = (String[]) dataMap.get("userIdArray");
		int empGroupId = (Integer) dataMap.get("empGroupId");
		String formName = (String) dataMap.get("formName");
		try {
			tx = session.beginTransaction();

			for (int k = 0; k < userIdArray.length; k++) {
				int userId = Integer.parseInt(userIdArray[k]);
				List<UserButtonRights> userButtonRightsList = session
						.createCriteria(UserButtonRights.class).createAlias(
								"User", "user").createAlias("EmpGroup",
								"empGroup").createAlias("Button", "button")
						.add(Restrictions.eq("user.Id", userId)).add(
								Restrictions.eq("button.FormName", formName))
						.add(Restrictions.eq("empGroup.Id", empGroupId)).list();
				hbt.deleteAll(userButtonRightsList);

			}

			for (int i = 0; i < buttonNameArray.length; i++) {
				int buttonId = Integer.parseInt(buttonNameArray[i]);
				for (int j = 0; j < userIdArray.length; j++) {
					int userId = Integer.parseInt(userIdArray[j]);
					List<UserButtonRights> userButtonRightsList = session
							.createCriteria(UserButtonRights.class)
							.createAlias("User", "user").createAlias(
									"EmpGroup", "empGroup").createAlias(
									"Button", "button").add(
									Restrictions.eq("user.Id", userId)).add(
									Restrictions.eq("button.Id", buttonId))
							.add(Restrictions.eq("empGroup.Id", empGroupId))
							.list();
					if (userButtonRightsList == null
							|| userButtonRightsList.size() == 0) {
						UserButtonRights userButtonRights = new UserButtonRights();

						Users user = new Users();
						user.setId(userId);
						userButtonRights.setUser(user);

						MasButtonForm masButtonForm = new MasButtonForm();
						masButtonForm.setId(buttonId);
						userButtonRights.setButton(masButtonForm);

						EmpGroups empGroups = new EmpGroups();
						empGroups.setId(empGroupId);
						userButtonRights.setEmpGroup(empGroups);
						hbt.save(userButtonRights);
					}

				}
			}
			dataSaved = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}

		return dataSaved;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getEmpNameByLoginName(String loginName) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Users> userList = new ArrayList<Users>();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Session session = (Session) getSession();

			userList = session.createCriteria(Users.class).add(
					Restrictions.eq("LoginName", loginName)).add(
					Restrictions.eq("Status", "y")).list();

			/**
			 * check active users, if user department does not exists then the user becomes inactive
			 * Code By Ritu 
			 * Date 5 Apr 2012
			 */
			List<UserDepartment> userDepartmentList = new ArrayList<UserDepartment>();
			if(userList.size()>0){
				userDepartmentList = session.createCriteria(UserDepartment.class).createAlias("User", "u").add(Restrictions.eq("u.Id", userList.get(0).getId())).list();
				if(userDepartmentList.size()> 0){
					map.put("userDepartmentList", userDepartmentList);
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("userList", userList);
		return map;
	}

	public Map<String, Object> showRemoveButtonRights(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Users user = null;
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		List<MasButtonForm> formList = new ArrayList<MasButtonForm>();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Session session = (Session) getSession();

			int userId = (Integer) dataMap.get("userId");
			user = (Users) hbt.load(Users.class, userId);
			hospitalList = session.createCriteria(MasHospital.class).add(
					Restrictions.eq("Status", "y")).list();
			formList = session
					.createSQLQuery(
							"select Distinct(form_name) from  mas_button_form where status='y';")
					.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("user", user);
		map.put("hospitalList", hospitalList);
		map.put("formList", formList);

		return map;
	}

	public Map<String, Object> getButtonRightsAvailableList(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Session session = (Session) getSession();
			String formName = (String) dataMap.get("formName");
			int userId = (Integer) dataMap.get("userId");
			String status = "y";
			List<UserButtonRights> buttonList = new ArrayList<UserButtonRights>();
			buttonList = session.createCriteria(UserButtonRights.class)
					.createAlias("User", "user")
					.createAlias("Button", "button").add(
							Restrictions.eq("user.Id", userId)).add(
							Restrictions.eq("button.FormName", formName)).add(
							Restrictions.eq("button.Status", status)).list();
			map.put("buttonList", buttonList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;

	}

	public boolean removeButtonRights(Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Transaction tx = null;
		boolean dataSaved = false;

		String[] buttonNameArray = (String[]) dataMap.get("buttonNameArray");
		int userId = (Integer) dataMap.get("userId");

		String formName = (String) dataMap.get("formName");
		try {
			tx = session.beginTransaction();

			for (int i = 0; i < buttonNameArray.length; i++) {
				int buttonId = Integer.parseInt(buttonNameArray[i]);

				List<UserButtonRights> userButtonRightsList = session
						.createCriteria(UserButtonRights.class).createAlias(
								"User", "user").createAlias("Button", "button")
						.add(Restrictions.eq("user.Id", userId)).add(
								Restrictions.eq("button.Id", buttonId)).list();
				hbt.deleteAll(userButtonRightsList);
			}
			dataSaved = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}

		return dataSaved;
	}

	public Map<String, Object> viewUserRights(Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		int userId = (Integer) dataMap.get("userId");
		int hospitalId = (Integer) dataMap.get("hospitalId");
		List<Object> userUsergroupApplicationList = new ArrayList<Object>();
		List<Object> masApplicationList = new ArrayList<Object>();
		List<Object> userList = new ArrayList<Object>();
		try {

			// userUsergroupApplicationList =
			// session.createQuery(" from UserUsergroupApplication as uugh  where uugh.User.Id="+userId).list();
			userUsergroupApplicationList = session.createCriteria(
					UserUsergroupApplication.class).createAlias("User", "user")
					.createAlias("GroupHospital", "groupHospital").createAlias(
							"groupHospital.Hospital", "hospital").add(
							Restrictions.eq("hospital.Id", hospitalId)).add(
							Restrictions.eq("user.Id", userId)).list();
			masApplicationList = session.createQuery(
					" from MasApplication as masApp ").list();
			userList = session.createCriteria(Users.class).add(
					Restrictions.eq("Id", userId)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("userList", userList);
		map.put("userUsergroupApplicationList", userUsergroupApplicationList);
		map.put("masApplicationList", masApplicationList);

		return map;

	}

	public boolean removeUserRights(Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Transaction tx = null;
		boolean dataSaved = false;
		int userId = (Integer) dataMap.get("userId");
		int hospitalId = (Integer) dataMap.get("hospitalId");

		try {
			tx = session.beginTransaction();

			List<UserUsergroupApplication> userUsergroupApplicationList = session
					.createCriteria(UserUsergroupApplication.class)
					.createAlias("User", "user").createAlias("GroupHospital",
							"groupHospital").createAlias(
							"groupHospital.Hospital", "hospital").add(
							Restrictions.eq("hospital.Id", hospitalId)).add(
							Restrictions.eq("user.Id", userId)).list();

			hbt.deleteAll(userUsergroupApplicationList);

			dataSaved = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}

		return dataSaved;

	}

	public Map<String, Object> showOrderApplicationJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Session session = (Session) getSession();
			String status = "y";
			List<MasHospital> hospitalList = new ArrayList<MasHospital>();
			hospitalList = session.createCriteria(MasHospital.class).add(
					Restrictions.eq("Status", status)).list();

			map.put("hospitalList", hospitalList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> populateEmpGroup(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Session session = (Session) getSession();
			String status = "y";

			List<UsergroupHospital> groupHospitalList = new ArrayList<UsergroupHospital>();

			groupHospitalList = session.createCriteria(UsergroupHospital.class)
					.createAlias("Hospital", "hospital").add(
							Restrictions.eq("Status", status)).add(
							Restrictions.eq("hospital.Id", hospitalId)).list();
			map.put("groupHospitalList", groupHospitalList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public boolean submitSwapApplication(Map<String, Object> dataMap) {
		boolean success = false;
		try {

			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			// Session session = (Session)getSession();

			Vector appIdVector = (Vector) dataMap.get("appIdVector");
			Vector OrderNoVector = (Vector) dataMap.get("OrderNoVector");

			for (int i = 0; i < appIdVector.size(); i++) {
				String appId = (String) appIdVector.get(i);
				MasApplication masApplication = (MasApplication) hbt.load(
						MasApplication.class, appId);
				masApplication.setOrderNo(Integer
						.parseInt((String) OrderNoVector.get(i)));
				hbt.update(masApplication);
				hbt.refresh(masApplication);

			}
			success = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	public boolean addOrderInApplication() {
		boolean success = false;
		int orderNo = 1;
		try {

			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Session session = (Session) getSession();
			List<MasApplication> masApplicationList = new ArrayList<MasApplication>();

			masApplicationList = session.createCriteria(MasApplication.class)
					.list();
			for (MasApplication masApplication : masApplicationList) {
				String appId = masApplication.getId();
				MasApplication masApplication2 = (MasApplication) hbt.load(
						MasApplication.class, appId);
				masApplication2.setOrderNo(orderNo);
				hbt.update(masApplication2);
				orderNo++;
			}
			success = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	// ----------------------------method added by vikas on
	// 29/04/09-----------------------------
	public List<UserUsergroupApplication> getUserApplicationList(int user,
			int groupId) {
		Session session = (Session) getSession();
		List<UserUsergroupApplication> masApplicationList = new ArrayList<UserUsergroupApplication>();
		List<UsergroupHospital> groupHospList = new ArrayList<UsergroupHospital>();
		try {

			groupHospList = session.createCriteria(UsergroupHospital.class)
					.add(Restrictions.eq("Group.Id", groupId)).list();
			groupId = 0;
			if (groupHospList.size() > 0) {
				UsergroupHospital group = (UsergroupHospital) groupHospList
						.get(0);
				groupId = group.getId();
			}
			masApplicationList = session.createCriteria(
					UserUsergroupApplication.class).createAlias("GroupApp",
					"group").add(Restrictions.eq("User.Id", user)).add(
					Restrictions.eq("GroupHospital.Id", groupId)).add(
					Restrictions.eq("group.Status", "y")).addOrder(
					Order.asc("GroupApp.Id")).list();
			// masApplicationList =
			// session.createQuery(" from MasApplication as masApp ").list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return masApplicationList;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showSubMenuForOrdering(
			Map<String, Object> mapForDs) {

		Session session = (Session) getSession();
		int groupId = 0;
		String subParentAppId = "";
		if (mapForDs.get("groupId") != null) {
			groupId = (Integer) mapForDs.get("groupId");
		}
		if (mapForDs.get("subParentAppId") != null) {
			subParentAppId = (String) mapForDs.get("subParentAppId");
		}

		List<GroupApplication> applicationListGroupWise = new ArrayList<GroupApplication>();

		try {
			applicationListGroupWise = session.createCriteria(
					GroupApplication.class).createAlias("App", "app")
					.createAlias("Group", "group").createAlias(
							"app.application", "parentApp").add(
							Restrictions.eq("group.Id", groupId)).add(
							Restrictions.eq("parentApp.Id", subParentAppId))
					.addOrder(Order.asc("app.OrderNo")).add(
							Restrictions.eq("Status", "y")).list();

			/*
			 * Iterator itr=applicationListGroupWise.iterator(); while
			 * (itr.hasNext()) { GroupApplication
			 * groupApplication=(GroupApplication)itr.next();
			 * if(groupApplication.getApp().getParentId().equals("0")){
			 * parentAppId=groupApplication.getApp().getId(); } }
			 */
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		// map.put("parentAppId", parentAppId);
		map.put("subApplicationListGroupWise", applicationListGroupWise);

		return map;
	}

	/*
	 * code by anand
	 */
	public Map<String, Object> getDepartmentUserList() {
		Session session = (Session) getSession();
		List<MasDepartment> departmentlist = new ArrayList<MasDepartment>();		
		try {
			departmentlist = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("departmentlist", departmentlist);
			
		return map;

	}
	@SuppressWarnings("deprecation")
	public Map<String, Object> getConnectionForReport() 
	{
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Connection connection = session.connection();
		Connection conn = connection;
		map.put("conn", conn);
		return map;
		
	}
}
