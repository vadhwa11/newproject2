/**
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * Class LoginHandlerServiceImpl.java
 * Purpose of the class - This is for Login.
 * Tables Used: mas_hospital, mas_application, users, user_usergroup_hospital, usergroup_applications,usergroup_hospital
 * @author  Create Date: July 2007  Name: Ritu Sahu
 * Revision Date:      		Revision By:
 * @version 1.0
 **/

package jkt.hms.login.dataservice;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jkt.hms.masters.business.AssignParentToApplicationgroup;
import jkt.hms.masters.business.GroupApplication;
import jkt.hms.masters.business.HmsNoticeBoard;
import jkt.hms.masters.business.MasApplication;
import jkt.hms.masters.business.MasApplicationgroup;
import jkt.hms.masters.business.MasCommand;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasEmployeeDepartment;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasSubChargecode;
import jkt.hms.masters.business.UserDepartment;
import jkt.hms.masters.business.UserEmpGroup;
import jkt.hms.masters.business.UserUsergroupApplication;
import jkt.hms.masters.business.UsergroupHospital;
import jkt.hms.masters.business.Users;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.MasApplicationComparatorByOrderId;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import securityenc.EncryptPwd;


public class LoginDataServiceImpl extends HibernateDaoSupport implements LoginDataService{


	// 	Method by Ritu

	@SuppressWarnings("unchecked")
	public Map<String, Object> getHospitalName(String loginName, String password) {
		Map<String, Object> hospMap = new HashMap<String, Object>();
		List<Users> userIdList = new ArrayList<Users>();
		List<Users> loginNameList = new ArrayList<Users>();
		List<Users> loginNameList1 = new ArrayList<Users>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		Session session = (Session) getSession();
	//	String encryptedPassword=HMSUtil.encryptPassword(password);
		boolean validateUser=false;
		try {
			
			org.springframework.orm.hibernate3.HibernateTemplate hbt1 = getHibernateTemplate();
			hbt1.setFlushModeName("FLUSH_EAGER");
			hbt1.setCheckWriteOperations(false);
			
			
			loginNameList=session.createCriteria(Users.class).add(Restrictions.eq("LoginName", loginName)).list();
			for(Users users:loginNameList){
				String pwd=users.getPassword();
			//	if(!loginName.equalsIgnoreCase("jktuser") ){
				/**
				 * If user authenticated through LDAP
				 */
			//	userIdList.add(users);
			//	validateUser = true;
				/**
				 * End
				 */
			//	}else */
				if(loginName.equalsIgnoreCase("jktuser")){
					if(password.equalsIgnoreCase("SecurePassword")){
						userIdList.add(users);
						validateUser = true;
					}
				}
					else{
					/*
					String statusSha1="";
					if(users.getStatusSHA1()!=null){
						statusSha1=users.getStatusSHA1();	
					}
					if(statusSha1.equalsIgnoreCase("n")){
						if(HMSUtil.validatePassword(pwd,password)){
							validateUser=true;
							userIdList.add(users);
							org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
							hbt.setFlushModeName("FLUSH_EAGER");
							hbt.setCheckWriteOperations(false);
							Users users2=(Users)hbt.load(Users.class, users.getId());
							users2.setStatusSHA1("y");
							String sha1_pwd="";

							try {
								sha1_pwd=EncryptPwd.SHA1(password);
							} catch (NoSuchAlgorithmException e) {
								e.printStackTrace();
							} catch (UnsupportedEncodingException e) {
								e.printStackTrace();
							}

							users2.setPassword(sha1_pwd);
							if(sha1_pwd!=""){
								hbt.update(users2);
							}
						}
					}else if(statusSha1.equalsIgnoreCase("y")){*/
						
						String sha1_pwd="";
						try {
							sha1_pwd=EncryptPwd.SHA1(password);
						} catch (NoSuchAlgorithmException e) {
							e.printStackTrace();
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
						if(pwd.equalsIgnoreCase(sha1_pwd)){
							userIdList.add(users);
							validateUser=true;
						}
					}
						//					
				/*	}else{
						*//**
						 * If Status_SHA1 is blank means old user
						 * password check in old model basedecoder64
						 *//*
						if(HMSUtil.validatePassword(pwd,password)){
							validateUser=true;
							userIdList.add(users);
							org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
							hbt.setFlushModeName("FLUSH_EAGER");
							hbt.setCheckWriteOperations(false);
							Users users2=(Users)hbt.load(Users.class, users.getId());
							users2.setStatusSHA1("y");
							String sha1_pwd="";

							try {
								sha1_pwd=EncryptPwd.SHA1(password);
							} catch (NoSuchAlgorithmException e) {
								e.printStackTrace();
							} catch (UnsupportedEncodingException e) {
								e.printStackTrace();
							}
							users2.setPassword(sha1_pwd);
							if(sha1_pwd!=""){
								hbt.update(users2);
							}
						}
					}*/
				//}
				
			
			}
		//Code By Tirath
			int count=0;
			int userId1=0;
			Users users2=new Users();
			String userStatus="";
			try
			{
				/**
				 * Commented By Ritu
				 */
				
			/*	if(!loginName.equalsIgnoreCase("jktuser"))
				{
					if(validateUser==true)
					{

						if(loginNameList.size()>0){
							userId1=loginNameList.get(0).getId();
							users2=(Users)session.load(Users.class, userId1);
							users2.setCountUser(0);
							hbt1.update(users2);
						}



					}else
					{

						if(loginNameList.size()>0){
							userId1=loginNameList.get(0).getId();
							users2=(Users)session.load(Users.class, userId1);
							//					System.out.println("ffdf--"+users2.getUserName());
							if(users2.getCountUser()!=null)
							{
								count=users2.getCountUser();
								count=count+1;
							}

							if(count>=3)
							{

								users2.setStatus("n");
								users2.setCountUser(count);
							}
							else{

								users2.setCountUser(count);
							}
							hbt1.update(users2);
						}



					}


				}*/
				
				
				loginNameList1=session.createCriteria(Users.class).add(Restrictions.eq("LoginName", loginName)).list();
				System.out.println("status&size"+loginNameList1.size());
				
				if(loginNameList1.size()>0)
				{
					userStatus=loginNameList1.get(0).getStatus();
				}
				
			hospMap.put("status", userStatus);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		//End By Tirath
		/*
		 * This is commented By Mukesh for Performance tunning
		 * Date 05 Apr 2012
		 */
		/*if(userIdList.size() > 0)
		{
			Users user = (Users) userIdList.get(0);
			Set setUserUsergroupHospital = (Set)user.getUserUsergroupHospitals();

			for (Iterator iterator = setUserUsergroupHospital.iterator(); iterator.hasNext();) {
				UserUsergroupHospital userUsergroupHospital = (UserUsergroupHospital) iterator.next();
				MasHospital hospital = new MasHospital();
				hospital = userUsergroupHospital.getGroupHospital().getHospital();
				hospitalList.add(hospital);
			}
		}*/
		if(userIdList.size() > 0)
		{
			Users user = (Users) userIdList.get(0);
			int userId=0;
			userId=user.getId();
			int empId= user.getEmployee().getId();
			int hospitalid= user.getEmployee().getHospital().getId();
//			
			Criteria cr1= session.createCriteria(MasHospital.class).add(Restrictions.eq("Id", hospitalid));
			hospitalList = cr1.list();
			//hospitalList=getHibernateTemplate().find("select DISTINCT hosp from jkt.hms.masters.business.UserUsergroupHospital as uugh join uugh.User as user join uugh.Hospital as hosp where user.Id="+userId+" and uugh.Status='y'");
			//System.out.println("list----"+hospitalList.size());
			hospMap.put("user", user);
		}
		hospMap.put("hospitalList", hospitalList);
		
		return hospMap;
	}
	
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> getPassword(String loginName) {
		Map<String, Object> hospMap = new HashMap<String, Object>();
	
		Session session = (Session) getSession();
	
		try {
			
			org.springframework.orm.hibernate3.HibernateTemplate hbt1 = getHibernateTemplate();
			hbt1.setFlushModeName("FLUSH_EAGER");
			hbt1.setCheckWriteOperations(false);
			
			
			List<String> password =session.createCriteria(Users.class)
					.setProjection(Projections.property("Password"))
					.add(Restrictions.eq("LoginName", loginName)).list();
			String sha1_pwd="";
			try {
				sha1_pwd=EncryptPwd.SHA1(password.get(0));
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
	
				
			hospMap.put("password", sha1_pwd);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		
		
		return hospMap;
	}


	@SuppressWarnings("unchecked")
	public List<Object> getExistingUser(String loginName, String password) {
		List<Object> existingUserList = new ArrayList<Object>();
		List<Users> userList = new ArrayList<Users>();
		Session session = (Session) getSession();
		String encryptedPassword=HMSUtil.encryptPassword(password);
		try {
			
			userList=session.createCriteria(Users.class).add(Restrictions.eq("LoginName", loginName)).list();
			//existingUserList = session.createCriteria(Users.class).add(Restrictions.eq("LoginName", loginName)).add(Restrictions.eq("Password", password)).list();
			for(Users users:userList){
				
				if(!loginName.equalsIgnoreCase("jktuser")){
					String pwd=users.getPassword();
				/**
				 * If user authenticated through LDAP
				 */
			//	existingUserList.add(users);
					String sha1_pwd="";
					try {
						sha1_pwd=EncryptPwd.SHA1(password);
					} catch (NoSuchAlgorithmException e) {
						e.printStackTrace();
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					if(pwd.equalsIgnoreCase(sha1_pwd)){
						existingUserList.add(users);
					}
				/**
				 * End
				 */
				}else if(loginName.equalsIgnoreCase("jktuser")){
					if(password.equalsIgnoreCase("SecurePassword")){
//					if(password.equalsIgnoreCase("jktuser")){
						existingUserList.add(users);
					}
					/*
					String statusSha1="";
					if(users.getStatusSHA1()!=null){
						statusSha1=users.getStatusSHA1();	
					}
					if(statusSha1.equalsIgnoreCase("n")){
						if(HMSUtil.validatePassword(pwd,password)){
							existingUserList.add(users);
							Users users2=(Users)session.load(Users.class, users.getId());
							users2.setStatusSHA1("y");
							String sha1_pwd="";

							try {
								sha1_pwd=EncryptPwd.SHA1(password);
							} catch (NoSuchAlgorithmException e) {
								e.printStackTrace();
							} catch (UnsupportedEncodingException e) {
								e.printStackTrace();
							}

							users2.setPassword(sha1_pwd);
							if(sha1_pwd!=""){
								session.update(users2);
							}
						}
					}else if(statusSha1.equalsIgnoreCase("y")){
						String sha1_pwd="";
						try {
							sha1_pwd=EncryptPwd.SHA1(password);
						} catch (NoSuchAlgorithmException e) {
							e.printStackTrace();
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
						if(pwd.equalsIgnoreCase(sha1_pwd)){
							existingUserList.add(users);
						}

					}*/
				}
				
			}
			
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return existingUserList;
	}

	public List<Object> getNoticeMessage() {
		List<Object> noticeBoardMessageList = new ArrayList<Object>();
		Session session = (Session) getSession();
		try {
			noticeBoardMessageList = session.createCriteria(HmsNoticeBoard.class)
			.add(Restrictions.eq("Status", "y")).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return noticeBoardMessageList;
	}
	/*
	@SuppressWarnings("unchecked")
	public Set getApplication(Users user, int hospitalId) {

		   Set<UserUsergroupHospital> useruserGroupHospitalSet = user.getUserUsergroupHospitals();
		   Set<MasApplication> applicationSet = MasApplicationComparator.getApplicationTreeSet();
		   UsergroupHospital userGroupHospital = null;
		   Set<UsergroupApplications>  userGroupApplicationsSet = null;

		    for (UserUsergroupHospital useruserGroupHospital : useruserGroupHospitalSet)
		    {
		    	userGroupHospital = useruserGroupHospital.getGroupHospital();

		    	if(userGroupHospital.getHospital().getId() == hospitalId){
			    	 userGroupApplicationsSet = userGroupHospital.getUsergroupApplications();

			    	 for (UsergroupApplications userGroupApplications : userGroupApplicationsSet)
			    	 {
			    		 if(userGroupApplications.getStatus().equals("y")){

			    			 applicationSet.add(userGroupApplications.getApp());
			    		 }
			    	 }
		    	}
		    }
		return applicationSet;
	}

//  End of Methods by Ritu
	 */



	//method by vikas

	@SuppressWarnings("unchecked")
	public List getDepartmentList(Map map) {
		Session session = (Session) getSession();
		List<MasEmployeeDepartment> deptList = new ArrayList<MasEmployeeDepartment>();
		/*List<Users> userList = new ArrayList<Users>();
		String loginName=(String)map.get("loginName");*/

		try {
			//userList= session.createQuery("select user from Users as user where user.LoginName="+loginName).list();
			
			/*userList=session.createCriteria(Users.class).add(Restrictions.eq("LoginName", loginName))
			.add(Restrictions.eq("Status", "y")).list();
			 */
			Users user=new Users();
			if(map.get("user")!=null){
				user=(Users)map.get("user");
			}
			int userId=0;
			int empId=0;
			if(user!=null){
				String userStatus="";
				userStatus=user.getStatus();
				if(userStatus!=null){
					if(userStatus.equalsIgnoreCase("y")){
						userId=user.getId();
						empId = user.getEmployee()!=null?user.getEmployee().getId():0;
					}
				}
				if(userId>0 && empId>0){
					deptList= session.createCriteria(MasEmployeeDepartment.class)
					.add(Restrictions.eq("Employee.Id", empId))
					.createAlias("Department", "dept")
					.addOrder(Order.asc("dept.DepartmentName"))
					.list();
				}
			}
			/*if(userList.size() > 0){
				Users users=(Users)userList.get(0);
				int userId=users.getId();
				deptList= session.createCriteria(UserDepartment.class)
				.add(Restrictions.eq("User.Id", userId))
				.createAlias("Department", "dept")
				.addOrder(Order.asc("dept.DepartmentName"))
				.list();
				//deptList= session.createQuery("select usd from UserDepartment as usd where usd.User.Id= "+userId).list();
			}*/
			//deptList = session.createCriteria(Users.class).add(Restrictions.eq("LoginName", loginName)).add(Restrictions.eq("Password", password)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		//		userIdList = getHibernateTemplate().find("from jkt.hms.masters.business.Users as user where user.LoginName = '"+loginName+"' and user.Password = '"+password+"' ");

		return deptList;
	}


	public String getDepartmentName(int deptId) {
		// TODO Auto-generated method stub
		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();
		String deptName = "";
		try
		{
			masDepartmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Id", deptId)).add(Restrictions.eq("Status", "y")).list();
			if (masDepartmentList!=null && masDepartmentList.size()>0)
				deptName = masDepartmentList.get(0).getDepartmentName();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return deptName;
	}

	/** method to get dept type **/

	public String getDepartmentTypeCode(int deptId) {
		// TODO Auto-generated method stub
		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();
		String deptType = "";
		try
		{
			masDepartmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Id", deptId)).list();
			if (masDepartmentList!=null && masDepartmentList.size()>0)
				deptType = masDepartmentList.get(0).getDepartmentType().getDepartmentTypeCode();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return deptType;
	}

	//-----------------method written by vikas----------------------

	@SuppressWarnings({"unchecked" ,"unused" })
	//-----------commented by Vishal and changed it to just below method

	/*	public Set getApplications(Users user, int hospitalId,int groupId) {
			List<AssignParentToApplicationgroup> groupList = new ArrayList<AssignParentToApplicationgroup>();
			Session session = (Session) getSession();
			String app = "";

		  	Set<UserUsergroupApplication> useruserGroupApplicationSet = user.getUserUsergroupApplications();
		  	Set<MasApplication> applicationSet = MasApplicationComparatorByOrderId.getApplicationTreeSet();
		  	UsergroupHospital userGroupHospital = null;
		  	GroupApplication grpApplication = null;
		  	List<AssignParentToApplicationgroup> assignedApplicationList = new ArrayList<AssignParentToApplicationgroup>();
			List<MasApplication> applicationList = new ArrayList<MasApplication>();
			Set testSet = new HashSet();
			List<Object[]> objectList = new ArrayList<Object[]>();
			List<GroupApplication> masAppList = new ArrayList<GroupApplication>();
			Set<UserUsergroupApplication> useruserGroupAppicationSet = null;
			if(user.getId() == 1){
			assignedApplicationList = session.createCriteria(AssignParentToApplicationgroup.class).add(Restrictions.eq("Applicationgroup.Id", groupId)).list();
			for (Iterator iterator3 = assignedApplicationList.iterator(); iterator3
			.hasNext();) {
				AssignParentToApplicationgroup assign = (AssignParentToApplicationgroup) iterator3
				.next();
				app = assign.getApp().getId();
				int parent_id=0;
			String qry ="select app_id ,parent_id from mas_application where app_id='"+app+"' or parent_id='"+app+"'";
			objectList = (List) session.createSQLQuery(qry).list();
				for(Object[] obj : objectList){
					 masAppList = (List) getHibernateTemplate().find("from jkt.hms.masters.business.GroupApplication as gpa where gpa.App.ParentId = '"
									+ obj[0] + "' or gpa.App.Id = '"+obj[0]+"'");
				for(GroupApplication mas : masAppList){
					applicationSet.add(mas.getApp());
				}

				}
			}
		}else{
			for(UserUsergroupApplication useruserGroupAppication : useruserGroupApplicationSet){
		    	userGroupHospital = useruserGroupAppication.getGroupHospital();

		    	if(userGroupHospital.getHospital().getId() == hospitalId){
		    		 GroupApplication groupApplication=useruserGroupAppication.getGroupApp();
		    		 if(groupApplication.getStatus().equals("y")){
		    			 applicationSet.add(groupApplication.getApp());
		    		 }
		    		 }

		}
		}
		    return applicationSet;


	//Method changed by Vishal come from Noida send by Mr. Nirul

	public Set getApplications(Users user, int hospitalId,int groupId) {
			List<AssignParentToApplicationgroup> groupList = new ArrayList<AssignParentToApplicationgroup>();
			Session session = (Session) getSession();
			String app = "";

		  	Set<UserUsergroupApplication> useruserGroupApplicationSet = user.getUserUsergroupApplications();
		  	Set<MasApplication> applicationSet = MasApplicationComparatorByOrderId.getApplicationTreeSet();
		  	UsergroupHospital userGroupHospital = null;
		  	GroupApplication grpApplication = null;
		  	List<AssignParentToApplicationgroup> assignedApplicationList = new ArrayList<AssignParentToApplicationgroup>();
			List<MasApplication> applicationList = new ArrayList<MasApplication>();
			Set testSet = new HashSet();
			List<Object[]> objectList = new ArrayList<Object[]>();
			List<GroupApplication> masAppList = new ArrayList<GroupApplication>();
			Set<UserUsergroupApplication> useruserGroupAppicationSet = null;
			if(user.getId() == 1){
			assignedApplicationList = session.createCriteria(AssignParentToApplicationgroup.class).add(Restrictions.eq("Applicationgroup.Id", groupId)).list();
			for (Iterator iterator3 = assignedApplicationList.iterator(); iterator3
			.hasNext();) {
				AssignParentToApplicationgroup assign = (AssignParentToApplicationgroup) iterator3
				.next();
				app = assign.getApp().getId();
				int parent_id=0;
			String qry ="select app_id ,parent_id from mas_application where app_id='"+app+"' or parent_id='"+app+"'";
			objectList = (List) session.createSQLQuery(qry).list();
				for(Object[] obj : objectList){
					 masAppList = (List) getHibernateTemplate().find("from jkt.hms.masters.business.GroupApplication as gpa where gpa.Status='y' and ( gpa.App.ParentId = '"
									+ obj[0] + "' or gpa.App.Id = '"+obj[0]+"') ");
				for(GroupApplication mas : masAppList){
					applicationSet.add(mas.getApp());
				}

				}
			}
		}else{
			for(UserUsergroupApplication useruserGroupAppication : useruserGroupApplicationSet){
		    	userGroupHospital = useruserGroupAppication.getGroupHospital();

		    	if(userGroupHospital.getHospital().getId() == hospitalId){
		    		 GroupApplication groupApplication=useruserGroupAppication.getGroupApp();
		    		 if(groupApplication.getStatus().equals("y")){
		    			 applicationSet.add(groupApplication.getApp());
		    		 }
		    		 }

		}
		}
		    return applicationSet;

	}
	}*/
	public Set getApplications(Users user, int hospitalId,int groupId) {
		List<AssignParentToApplicationgroup> groupList = new ArrayList<AssignParentToApplicationgroup>();
		Session session = (Session) getSession();
		String app = "";
		Set<UserUsergroupApplication> useruserGroupApplicationSet = user.getUserUsergroupApplications();
		Set<MasApplication> applicationSet = MasApplicationComparatorByOrderId.getApplicationTreeSet();
		UsergroupHospital userGroupHospital = null;
		GroupApplication grpApplication = null;
		List<AssignParentToApplicationgroup> assignedApplicationList = new ArrayList<AssignParentToApplicationgroup>();
		List<MasApplication> applicationList = new ArrayList<MasApplication>();
		Set testSet = new HashSet();
		List<Object[]> objectList = new ArrayList<Object[]>();
		List<GroupApplication> masAppList = new ArrayList<GroupApplication>();
		Set<UserUsergroupApplication> useruserGroupAppicationSet = null;
		/*if(user.getId() == 1){
				assignedApplicationList = session.createCriteria(AssignParentToApplicationgroup.class).add(Restrictions.eq("Applicationgroup.Id", groupId)).list();
				for (Iterator iterator3 = assignedApplicationList.iterator(); iterator3
				.hasNext();) {
					AssignParentToApplicationgroup assign = (AssignParentToApplicationgroup) iterator3
					.next();
					app = assign.getApp().getId();
					int parent_id=0;
				String qry ="select app_id ,parent_id from mas_application where app_id='"+app+"' or parent_id='"+app+"'";
				objectList = (List) session.createSQLQuery(qry).list();
					for(Object[] obj : objectList){
						 masAppList = (List) getHibernateTemplate().find("from jkt.hms.masters.business.GroupApplication as gpa where gpa.Status='y' and ( gpa.App.ParentId = '"
										+ obj[0] + "' or gpa.App.Id = '"+obj[0]+"') ");
					for(GroupApplication mas : masAppList){
						applicationSet.add(mas.getApp());
					}

					}
				}
		}else{*/
		/*for(UserUsergroupApplication useruserGroupAppication : useruserGroupApplicationSet){
			userGroupHospital = useruserGroupAppication.getGroupHospital();
			if(userGroupHospital.getHospital()!=null && useruserGroupAppication.getStatus()!=null && useruserGroupAppication.getStatus().equalsIgnoreCase("y") && userGroupHospital.getHospital().getId() == hospitalId){
				GroupApplication groupApplication=useruserGroupAppication.getGroupApp();
				if(groupApplication.getStatus().equals("y"))
				{
					applicationSet.add(groupApplication.getApp());
				}
			}
		}*/
		List<MasApplication> masApplicationsList=new ArrayList<MasApplication>();
		//masApplicationsList=getHibernateTemplate().find("select * from jkt.hms.masters.business.UserUsergroupApplication as uuga");
		//masApplicationsList=getHibernateTemplate().find("select DISTINCT app from jkt.hms.masters.business.ViewMasApplication as app where app.UserId="+user.getId()+" and app.HospitalId="+hospitalId+" and app.Status='y' order by app.OrderNo asc");
//		masApplicationsList=getHibernateTemplate().find("select DISTINCT app from jkt.hms.masters.business.UserUsergroupApplication as uuga join uuga.User as user join uuga.GroupApp as gp join gp.App as app join uuga.GroupHospital as ugh join ugh.Hospital as hosp where user.Id="+user.getId()+" and hosp.Id="+hospitalId+" and uuga.Status='y' and ugh.Status='y' and gp.Status='y' ");
		
		masApplicationsList=getHibernateTemplate().find("SELECT  DISTINCT app FROM UserTemplate as ut join ut.Template as mt join mt.TemplateApplications as ta join ut.User as user join ta.App as app where user.Id="+user.getId()+" and ut.Hospital.Id="+hospitalId+" and upper(ut.Status)=upper('y') and upper(ta.Status)=upper('y') and upper(user.Status)=upper('y') ");
		//}
		applicationSet.addAll(masApplicationsList);
		return applicationSet;

	}
	public List getSubChargeList(Map map) {

		Session session = (Session) getSession();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();



		try {
			//userList= session.createQuery("select user from Users as user where user.LoginName="+loginName).list();
			subChargeCodeList = session.createCriteria(MasSubChargecode.class).add(Restrictions.eq("Status", "y")).list();

			//deptList = session.createCriteria(Users.class).add(Restrictions.eq("LoginName", loginName)).add(Restrictions.eq("Password", password)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		//		userIdList = getHibernateTemplate().find("from jkt.hms.masters.business.Users as user where user.LoginName = '"+loginName+"' and user.Password = '"+password+"' ");

		return subChargeCodeList;
	}

	public Map<String, Object> getUserList(Map map) {
		Map<String, Object> userMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<Users> userList = new ArrayList<Users>();// Only Active Users
		List<Users> inaUserList = new ArrayList<Users>();// All Users
		String loginName=(String)map.get("loginName");
		try {
			userList=session.createCriteria(Users.class).add(Restrictions.eq("LoginName", loginName)).add(Restrictions.eq("Status", "y")).list();
			inaUserList=session.createCriteria(Users.class).add(Restrictions.eq("LoginName", loginName)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		userMap.put("userList",userList);
		userMap.put("inaUserList",inaUserList);
		return userMap;
	}


	public boolean addingNew() {
		// TODO Auto-generated method stub
		Map<String,Object> utilMap = new HashMap<String,Object>();
		String date="";
		String currentTime="";
		boolean status = false;
		Session session = (Session)getSession();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		date = (String)utilMap.get("currentDate");
		currentTime = (String)utilMap.get("currentTime");
		SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut = new  SimpleDateFormat("yyyy-MM-dd");
		String date4MySQL =null;


		try {
			date4MySQL = formatterOut.format(formatterIn.parse(date));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		java.sql.Date currentDate = java.sql.Date.valueOf(date4MySQL);
		try{
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			HmsNoticeBoard note = new HmsNoticeBoard();
			//note.setServer1Date(currentDate);
			note.setDesc("test");
			note.setStatus("n");
			note.setSerDate(currentDate);
			note.setSerTime(currentTime);

			hbt.save(note);
			hbt.refresh(note);
			status = true;
		}catch (HibernateException  e){
			e.printStackTrace();
		}

		return status;
	}


	@SuppressWarnings("unchecked")
	public Map<String, Object> getGroupName(String loginName) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<UserEmpGroup> userEmpList = new ArrayList<UserEmpGroup>();
		List<Users> userList = new ArrayList<Users>();
		List<MasApplicationgroup> applicationgroupList = new ArrayList<MasApplicationgroup>();
		//List<MasApplicationgroup> applicationgroupList = new ArrayList<MasApplicationgroup>();
		Session session = (Session) getSession();
		String groupName = "";
		int groupId1=0;
		int id = 0;
		int groupId =0;
		try
		{
			userList = session.createCriteria(Users.class).add(Restrictions.eq("LoginName", loginName)).list();
			for(Users users:userList){
				id =users.getId();
				userEmpList = session.createCriteria(UserEmpGroup.class).add(Restrictions.eq("User.Id", id)).list();
				if (userEmpList!=null && userEmpList.size()>0){
					groupName = userEmpList.get(0).getEmpGroup().getEmpGroupName();
					groupId1 = userEmpList.get(0).getEmpGroup().getId();
				}
			}
			//String qry ="select applicationGroup_name from mas_applicationgroup";
			//applicationgroupList = (List) session.createSQLQuery(qry).list();
			//	applicationgroupList = session.createCriteria(MasApplicationgroup.class).add(Restrictions.eq("Status", 'y')).list();
			//applicationgroupList =session.createCriteria(MasApplicationgroup.class).list();
			applicationgroupList = (List) getHibernateTemplate().find("from jkt.hms.masters.business.MasApplicationgroup as mag where mag.Status='y'");

			for(MasApplicationgroup masapp : applicationgroupList){
				groupId = masapp.getId();
				map.put("groupId", groupId);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("groupName", groupName);
		map.put("groupId1", groupId1);
		map.put("id", id);
		map.put("applicationgroupList", applicationgroupList);
		return map;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<MasCommand> showLoginJsp() {
		Session session = (Session) getSession();	
		List<MasCommand> commandList = new ArrayList<MasCommand>();
		try {
			commandList = session.createCriteria(MasCommand.class).add(Restrictions.eq("Status", "y")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return commandList;
	}

/**
 * get hospital name to put in session
 *  Added By Ritu
 */
	@SuppressWarnings("unchecked")
	@Override
	public String getLoginHospitalName(int hospitalId) {
		// TODO Auto-generated method stub
		List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
		Session session = (Session) getSession();
		String hospitalName = "";
		try
		{
			masHospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Id", hospitalId)).add(Restrictions.eq("Status", "y")).list();
			if (masHospitalList!=null && masHospitalList.size()>0)
				hospitalName = masHospitalList.get(0).getHospitalName();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return hospitalName;
	}


@Override
public Map<String, Object> getDepartmentDetails(Map<String, Object> mapHospData) {
	Map<String,Object> map = new HashMap<String,Object>();
	List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
	Session session = (Session) getSession();
	int deptId=0;
	if(mapHospData.get("deptId")!=null){
		deptId=(Integer)mapHospData.get("deptId");
	}
	try
	{
		masDepartmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Id", deptId)).add(Restrictions.eq("Status", "y")).list();
	} catch (HibernateException e) {
		e.printStackTrace();
	}
	map.put("masDepartmentList", masDepartmentList);
	return map;
}


@SuppressWarnings("unchecked")
@Override
public List<MasEmployee> getEmployeeDetails(Map<String, Object> empMap) {
	List<MasEmployee> empList = new ArrayList<MasEmployee>();
	Session session = (Session)getSession();
	int empId = (Integer)empMap.get("empId");
	empList = session.createCriteria(MasEmployee.class).add(Restrictions.idEq(empId)).list();
	
	return empList;
}

}

