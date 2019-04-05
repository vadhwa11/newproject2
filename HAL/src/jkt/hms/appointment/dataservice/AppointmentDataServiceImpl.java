package jkt.hms.appointment.dataservice;

import static jkt.hms.util.RequestConstants.AGE;
import static jkt.hms.util.RequestConstants.AGEUNIT;
import static jkt.hms.util.RequestConstants.AGE_UNIT;
import static jkt.hms.util.RequestConstants.APMT_DATE;
import static jkt.hms.util.RequestConstants.APPOINTMENT_DATE;
import static jkt.hms.util.RequestConstants.APPOINTMENT_ID;
import static jkt.hms.util.RequestConstants.APPOINTMENT_NO;
import static jkt.hms.util.RequestConstants.BEFORETIME;
import static jkt.hms.util.RequestConstants.BREAKFROMTIME;
import static jkt.hms.util.RequestConstants.BREAKTOTIME;
import static jkt.hms.util.RequestConstants.DAYS;
import static jkt.hms.util.RequestConstants.DEPARTMENT_ID;
import static jkt.hms.util.RequestConstants.DEPT_ID;
import static jkt.hms.util.RequestConstants.DR;
import static jkt.hms.util.RequestConstants.EMPLOYEE_ID;
import static jkt.hms.util.RequestConstants.SESSION_ID;
import static jkt.hms.util.RequestConstants.EQUIPMENT_ID;
import static jkt.hms.util.RequestConstants.EQUIP_ID;
import static jkt.hms.util.RequestConstants.FROMTIME;
import static jkt.hms.util.RequestConstants.FROMTIMESLOT;
import static jkt.hms.util.RequestConstants.HIN_ID;
import static jkt.hms.util.RequestConstants.HIN_NO;
import static jkt.hms.util.RequestConstants.INVESTIGATION_ID;
import static jkt.hms.util.RequestConstants.MAXDAYS;
import static jkt.hms.util.RequestConstants.MINDAYS;
import static jkt.hms.util.RequestConstants.MOBILE_NO;
import static jkt.hms.util.RequestConstants.PATIENT_NAME;
import static jkt.hms.util.RequestConstants.PATIENT_TYPE;
import static jkt.hms.util.RequestConstants.PERCENTAGE;
import static jkt.hms.util.RequestConstants.RELATION_ID;
import static jkt.hms.util.RequestConstants.SERVICE_NO;
import static jkt.hms.util.RequestConstants.SEX;
import static jkt.hms.util.RequestConstants.SLOTTIME;
import static jkt.hms.util.RequestConstants.TOTIME;
import static jkt.hms.util.RequestConstants.TOTIMESLOT;
import static jkt.hms.util.RequestConstants.VALID_FROM;
import static jkt.hms.util.RequestConstants.WARD_ID;

import java.net.URL;
import java.sql.Connection;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;

import jkt.hms.masters.business.AppBlock;
import jkt.hms.masters.business.AppEquipmentMaster;
import jkt.hms.masters.business.AppInvestigationAppointments;
import jkt.hms.masters.business.AppInvestigationSetup;
import jkt.hms.masters.business.AppPatientAppointments;
import jkt.hms.masters.business.AppSetup;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasEmployeeDepartment;
import jkt.hms.masters.business.MasEmployeeDependent;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasRelation;
import jkt.hms.masters.business.MasSession;
import jkt.hms.masters.business.OpdHoliday;
import jkt.hms.masters.business.OpdQaMaster;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.base.AppSetupComparator;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @ author: Priyanka Garg Made on: 9th July 2008
 */

public class AppointmentDataServiceImpl extends HibernateDaoSupport implements
		AppointmentDataService {

	@SuppressWarnings("unchecked")
	public Map<String, Object> showAppSetupJsp() {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		String departmentTypeCode = null;

		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");

		try {
			properties.load(resourcePath.openStream());
			departmentTypeCode = properties.getProperty("departmentTypeCodeForOpd");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		try {
		/*	departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).createAlias(
					"DepartmentType", "dt").add(
					Restrictions
							.in("dt.DepartmentTypeCode", departmentTypeCode))
					.list();*/
			departmentList=session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status","y").ignoreCase())
					.createAlias("DepartmentType", "dt")
					.add(Restrictions.eq("dt.DepartmentTypeCode",departmentTypeCode))
					.addOrder(Order.asc("DepartmentName"))
					.list();
		
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("departmentList", departmentList);

		return map;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getRecords(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<AppSetup> appSetupList = new ArrayList<AppSetup>();
		List<Object[]> doctorList = new ArrayList<Object[]>();
		List<MasEmployeeDependent> empDeptList = new ArrayList<MasEmployeeDependent>();
		String queryString = null;
		String departmentTypeCode = null;
		
	/*	List<String> departmentTypeCode = new ArrayList<String>();
		departmentTypeCode.add("CR");
		departmentTypeCode.add("OPD1");
		departmentTypeCode.add("SpltOPD");*/
		int hospitalId = box.getInt("hospitalId");
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
			departmentTypeCode = properties.getProperty("departmentTypeCodeForOpd");
		
		} catch (Exception e) {
			e.printStackTrace();
		}

		int departmentId = box.getInt(DEPARTMENT_ID);
		try {
	/*		departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).createAlias(
					"DepartmentType", "dt").add(
					Restrictions
							.in("dt.DepartmentTypeCode", departmentTypeCode))
					.list();*/
		
			departmentList=session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status","y").ignoreCase())
					.createAlias("DepartmentType", "dt")
					.add(Restrictions.eq("dt.DepartmentTypeCode",departmentTypeCode))
					.addOrder(Order.asc("DepartmentName"))
					.list();
			           
			// queryString="from AppSetup where Dept="+departmentId+" and validTo="+null;
               
          /*     String QueryForEmp = " select * from dbo.mas_employee as emp inner join dbo.mas_employee_department dt"+ 
" on emp.employee_id= dt.employee_id where dt.department_id='"+departmentId+"' and emp.emp_category_id = '1' and emp.hospital_id='"
   					+ hospitalId +  "' and grade_id is not null";*/
   		//	doctorList = session.createSQLQuery(QueryForEmp).list();

   			/*doctorList=session.createCriteria(MasEmployee.class)
					.createAlias("MasEmployeeDependent", "edept")
					.add(Restrictions.eq("edept.department_id","23"))
					//.addOrder(Order.asc("DepartmentName"))
					.list();*/
		
			
			empDeptList=session.createCriteria(MasEmployeeDepartment.class).createAlias("Department", "dept")
					.add(Restrictions.eq("dept.Id",departmentId))
					.list();
			
   		   
			/*Criteria appCr = session.createCriteria(AppSetup.class).add(
					Restrictions.eq("Dept.Id", departmentId)).add(
					Restrictions.isNull("validTo"));
			appSetupList = appCr.list();*/
			//System.out.println("Query:---------------" + appCr.toString());
			//System.out.println("TotalRecords:" + appSetupList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// sorting Appointment object day wise for displaying on jsp.
		sort(appSetupList);
		
		map.put("departmentList", departmentList);
		map.put("doctorList", doctorList);
		map.put("appSetupList", appSetupList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDoctorList(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		List<MasSession> sessionList = new ArrayList<MasSession>();
		List<MasEmployeeDepartment> empDeptList = new ArrayList<MasEmployeeDepartment>();
		List empList= new ArrayList();
		int hospitalId = box.getInt("hospitalId");
		
		String empCategoryCodeForDoctor = "";
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
			empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
     
		int departmentId = box.getInt(DEPARTMENT_ID);

		try {
	
			empDeptList=session.createCriteria(MasEmployeeDepartment.class)
					.createAlias("Department", "dept")
					.add(Restrictions.eq("dept.Id",departmentId))
					.add(Restrictions.eq("Status","y").ignoreCase())
					.list();
			
			for(MasEmployeeDepartment empDept :empDeptList)
			{ 
				empList.add(empDept.getEmployee().getId());
			}
			if(empDeptList.size() >0)
			{
			   doctorList = session.createCriteria(MasEmployee.class)
					 .add(Restrictions.eq("Status","y").ignoreCase())  
					 .add(Restrictions.eq("Hospital.Id",hospitalId))
					.createAlias("EmpCategory", "ec")					
					.add(Restrictions.eq("ec.EmpCategoryCode", empCategoryCodeForDoctor))
					.add(Restrictions.in("Id", empList))
					.list();
			
			   sessionList = session.createCriteria(MasSession.class)
					   .add(Restrictions.eq("Hospital.Id",hospitalId))
					   .add(Restrictions.eq("Status","y").ignoreCase()).list();
			   
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("doctorList", doctorList);
		map.put("sessionList", sessionList);
		return map;
	}
	
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> getQuestionnaireList(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<OpdQaMaster> questionnaireList = new ArrayList<OpdQaMaster>();
		
		int hospitalId = box.getInt("hospitalId");

	    int questionHeaderId = box.getInt("questionHeaderId");

		try {
	
			questionnaireList=session.createCriteria(OpdQaMaster.class)
					.add(Restrictions.eq("QuestionHeading.Id",box.getInt("questionId")))
					.add(Restrictions.eq("Status","y").ignoreCase())
					.list();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("questionnaireList", questionnaireList);
		
		return map;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> getDoctorAndSessionDetails(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		List<MasSession> sessionList = new ArrayList<MasSession>();
		List<MasEmployeeDepartment> empDeptList = new ArrayList<MasEmployeeDepartment>();
		List empList= new ArrayList();
		int hospitalId = box.getInt("hospitalId");
		
		String empCategoryCodeForDoctor = "";
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
			empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int divcount  = box.getInt("divcount");
		int departmentId = box.getInt(DEPARTMENT_ID+divcount);

		try {
	
			empDeptList=session.createCriteria(MasEmployeeDepartment.class)
					.createAlias("Department", "dept")
					.add(Restrictions.eq("dept.Id",departmentId))
					.add(Restrictions.eq("Status","y").ignoreCase())
					.list();
			
			for(MasEmployeeDepartment empDept :empDeptList)
			{ 
				empList.add(empDept.getEmployee().getId());
			}
			if(empDeptList.size() >0)
			{
			   doctorList = session.createCriteria(MasEmployee.class)
					 .add(Restrictions.eq("Status","y").ignoreCase())  
					 .add(Restrictions.eq("Hospital.Id",hospitalId))
					.createAlias("EmpCategory", "ec")					
					.add(Restrictions.eq("ec.EmpCategoryCode", empCategoryCodeForDoctor))
					.add(Restrictions.in("Id", empList))
					.addOrder(Order.asc("FirstName"))
					.list();
			
			   sessionList = session.createCriteria(MasSession.class)
					   .add(Restrictions.eq("Hospital.Id",hospitalId))
					   .add(Restrictions.eq("Status","y").ignoreCase()).list();
			   
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("doctorList", doctorList);
		map.put("sessionList", sessionList);
		map.put("divcount", divcount);
		return map;
	}
	
	public Map<String, Object> getAppDetails(Box box) {
		Map<String,Object>map=new HashMap<String,Object>();
		Session session=(Session)getSession();
		List<AppSetup>setupList=new ArrayList<AppSetup>();
		int deptId = box.getInt("deptId");
		int sessionId = box.getInt("sesId");
		int doctorId = box.getInt("docId");
		int hospitalId = box.getInt("hospitalId");
		
		if(deptId>0){
		setupList=session.createCriteria(AppSetup.class).add(Restrictions.eq("Dept.Id", deptId))
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.eq("Doctor.Id", doctorId))
				.add(Restrictions.eq("Session.Id", sessionId))
				.list();
		}
		
	
		map.put("setupList",setupList);
		return map;
	}
	
	/**
	 * function for sorting AppSetup list day wise
	 * 
	 * @param tempAppSetupList
	 * @return
	 */
	public static void sort(List<AppSetup> tempAppSetupList) {
		Iterator<AppSetup> appIt = tempAppSetupList.iterator();
		// set integer value for day of week in appsetup object
		while (appIt.hasNext()) {
			AppSetup tempApp = appIt.next();
			tempApp.setDayOfWeek(HMSUtil.getDayOfWeek(tempApp.getDays()));
		}
		Collections.sort(tempAppSetupList, new AppSetupComparator());
	}

	public boolean submitAppointmentSetup(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();
		boolean dataSaved = false;

		Vector days = box.getVector(DAYS);
		Vector dr = box.getVector(DR);
		/*Vector fromTime = box.getVector(FROMTIME);
		Vector toTime = box.getVector(TOTIME);
		Vector slotTime = box.getVector(SLOTTIME);
		Vector percentage = box.getVector(PERCENTAGE);
		Vector breakFromTime = box.getVector(BREAKFROMTIME);
		Vector breakToTime = box.getVector(BREAKTOTIME);*/
		
		Vector breakFromTime2 = box.getVector("TokenStart");
		
		Vector breakToTime2 = box.getVector("TokenInterval");
		
		Vector breakFromTime3 = box.getVector("TotalToken");
		

		Vector TotalOnlineToken  = box.getVector("TotalOnlineToken");
		
		/*Vector breakToTime3 = box.getVector(BREAKTOTIME3);*/
		Vector maxDays = box.getVector(MAXDAYS);
		Vector minDays = box.getVector(MINDAYS);
		//Vector timeTaken = box.getVector("timeTaken");
		int timeTaken =box.getInt("timeTaken");
		String startTime = box.getString("startTime");
		String endTime = box.getString("endTime");
		/*Vector beforeTime = box.getVector(BEFORETIME);*/
		int departmentId = box.getInt(DEPARTMENT_ID);
		int sessionId = box.getInt("sessionId");
		int doctorId = box.getInt(EMPLOYEE_ID);
		int hospitalId = box.getInt("hospitalId");
		String userName = box.getString("userName");

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		
		departmentList = session.createCriteria(MasDepartment.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.createAlias("DepartmentType", "dt")
				.add(Restrictions.eq("dt.Id", 1)).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		for (int i = 0; i <= 6; i++) {
			try {
				
				if(null !=breakFromTime3.get(i) && !breakFromTime3.get(i).equals("") && null !=breakToTime2.get(i) && !breakToTime2.get(i).equals("") && null !=breakFromTime2.get(i) && !breakFromTime2.get(i).equals("") && 0!=timeTaken && !startTime.isEmpty() && !endTime.isEmpty())
				{
				AppSetup appSetup = new AppSetup();
				appSetup.setDays((String) days.get(i));
				
				if(null !=breakFromTime3.get(i) && !breakFromTime3.get(i).equals(""))
				appSetup.setTotalToken(Integer.parseInt((String)breakFromTime3.get(i)));
				
				
				if(null !=TotalOnlineToken.get(i) && !TotalOnlineToken.get(i).equals(""))
					appSetup.setTotalOnlineToken(Integer.parseInt((String)TotalOnlineToken.get(i)));
				
				if(null !=breakToTime2.get(i) && !breakToTime2.get(i).equals(""))
				appSetup.setTotalInterval(Integer.parseInt((String) breakToTime2.get(i)));
				
				if(null !=breakFromTime2.get(i) && !breakFromTime2.get(i).equals(""))
				appSetup.setStartToken(Integer.parseInt((String) breakFromTime2.get(i)));
				//appSetup.setBreakToTime3((String) breakToTime3.get(i));
				if (!maxDays.get(i).equals("") && maxDays.get(i) != null) {
					appSetup.setMaxNoOfDays(Integer.parseInt((String) maxDays
							.get(i)));
				} else {
					appSetup.setMaxNoOfDays(0);
				}

				if (!minDays.get(i).equals("") && minDays.get(i) != null) {
					appSetup.setMinNoOfDays(Integer.parseInt((String) minDays
							.get(i)));
				} else {
					appSetup.setMinNoOfDays(0);
				}
				/*if (!timeTaken.get(i).equals("") && timeTaken.get(i) != null) {
					appSetup.setTimeTaken(Integer.parseInt((String) timeTaken
							.get(i)));
				} */
				appSetup.setTimeTaken(timeTaken);
				appSetup.setStartTime(startTime);
				appSetup.setEndTime(endTime);
				
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(departmentId);
				appSetup.setDept(masDepartment);
				
		
				if (doctorId !=0 ) {
					MasEmployee masEmployee=new MasEmployee();
					masEmployee.setId(doctorId);
					appSetup.setDoctor(masEmployee);

				}
				
				if (sessionId !=0 ) {
					MasSession MasSession=new MasSession();
					MasSession.setId(sessionId);
					appSetup.setSession(MasSession);

				}

			
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				appSetup.setHospital(masHospital);
				
				Users user = new Users();
				
				user.setId(Integer.parseInt(box.get("userId")));
				
				appSetup.setLastChgBy(user);
				
				appSetup.setLastChgDate(date);
				appSetup.setLastChgTime(time);
				hbt.save(appSetup);
				
				dataSaved = true;
				
			  }
				
			} catch (Exception e) {
				dataSaved = false;
				e.printStackTrace();
			}
		}

		return dataSaved;
	}

	public boolean updateAppointmentSetup(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();
		boolean dataSaved = false;

		Vector days = box.getVector(DAYS);
		Vector dr = box.getVector(DR);
		/*Vector fromTime = box.getVector(FROMTIME);
		Vector toTime = box.getVector(TOTIME);
		Vector slotTime = box.getVector(SLOTTIME);
		Vector percentage = box.getVector(PERCENTAGE);
		Vector breakFromTime = box.getVector(BREAKFROMTIME);
		Vector breakToTime = box.getVector(BREAKTOTIME);*/
		Vector breakFromTime2 = box.getVector("TokenStart");
		
		Vector breakToTime2 = box.getVector("TokenInterval");
		
		Vector breakFromTime3 = box.getVector("TotalToken");
		
		
		Vector TotalOnlineToken  = box.getVector("TotalOnlineToken");
		
		/*Vector breakFromTime2 = box.getVector(BREAKFROMTIME2);
		Vector breakToTime2 = box.getVector(BREAKTOTIME2);
		Vector breakFromTime3 = box.getVector(BREAKFROMTIME3);
		Vector breakToTime3 = box.getVector(BREAKTOTIME3);*/
		
		
		Vector maxDays = box.getVector(MAXDAYS);
		Vector minDays = box.getVector(MINDAYS);
		Vector beforeTime = box.getVector(BEFORETIME);
		Vector departmentId = box.getVector(DEPARTMENT_ID);
		Vector appointmentId = box.getVector(APPOINTMENT_ID);
		//Vector timeTaken = box.getVector("timeTaken");
		int timeTaken =box.getInt("timeTaken");
		String startTime = box.getString("startTime");
		String endTime = box.getString("endTime");
		//int departmentId = box.getInt(DEPARTMENT_ID);
		
		int sessionId = box.getInt("sessionId");
		int doctorId = box.getInt(EMPLOYEE_ID);
		int hospitalId = box.getInt("hospitalId");
		int i = 0;

		String userName = box.getString("userName");

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		departmentList = session.createCriteria(MasDepartment.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.createAlias("DepartmentType", "dt")
				.add(Restrictions.eq("dt.Id", 1)).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		for (i = 0; i <= appointmentId.size() - 1; i++) {
			try {
				if(null !=breakFromTime3.get(i) && !breakFromTime3.get(i).equals("") && null !=breakToTime2.get(i) && !breakToTime2.get(i).equals("") && null !=breakFromTime2.get(i) && !breakFromTime2.get(i).equals("")  && 0 !=timeTaken)
				{
					AppSetup appSetup =null;
					if(appointmentId.get(i)=="")
					{
						appSetup	= new AppSetup();
					}
					else
					{
						 appSetup = (AppSetup) hbt.load(AppSetup.class,
								Integer.parseInt((String) appointmentId.get(i)));
					}
			
				appSetup.setDays((String) days.get(i));
			//	appSetup.setNoOfDoctor(1);
				/*if (!dr.get(i).equals("") && dr.get(i) != null) {
					appSetup.setNoOfDoctor(Integer.parseInt((String) dr.get(i)));
				} else {
					appSetup.setNoOfDoctor(0);
				}*/

				/*appSetup.setFromTime((String) fromTime.get(i));
				appSetup.setToTime((String) toTime.get(i));
				appSetup.setSlotDuration((String) slotTime.get(i));*/

				/*if (!percentage.get(i).equals("") && percentage.get(i) != null) {
					appSetup.setPercentageForSlots(Integer
							.parseInt((String) percentage.get(i)));
				} else {
					appSetup.setPercentageForSlots(0);
				}*/
				//appSetup.setBreakFromTime((String) breakFromTime.get(i));
				//appSetup.setBreakToTime((String) breakToTime.get(i));
				//appSetup.setBreakFromTime2((String) breakFromTime2.get(i));
				//appSetup.setBreakToTime2((String) breakToTime2.get(i));
				//appSetup.setBreakFromTime3((String) breakFromTime3.get(i));
				//appSetup.setBreakToTime3((String) breakToTime3.get(i));
				
				if(null !=breakFromTime3.get(i) && !breakFromTime3.get(i).equals(""))
					appSetup.setTotalToken(Integer.parseInt((String)breakFromTime3.get(i)));
					
				if(null !=TotalOnlineToken.get(i) && !TotalOnlineToken.get(i).equals(""))
					appSetup.setTotalOnlineToken(Integer.parseInt((String)TotalOnlineToken.get(i)));
				
					if(null !=breakToTime2.get(i) && !breakToTime2.get(i).equals(""))
					appSetup.setTotalInterval(Integer.parseInt((String) breakToTime2.get(i)));
					
					if(null !=breakFromTime2.get(i) && !breakFromTime2.get(i).equals(""))
					appSetup.setStartToken(Integer.parseInt((String) breakFromTime2.get(i)));


				if (!maxDays.get(i).equals("") && maxDays.get(i) != null) {
					appSetup.setMaxNoOfDays(Integer.parseInt((String) maxDays
							.get(i)));
				} else {
					appSetup.setMaxNoOfDays(0);
				}
				if (!minDays.get(i).equals("") && minDays.get(i) != null) {
					appSetup.setMinNoOfDays(Integer.parseInt((String) minDays
							.get(i)));
				} else {
					appSetup.setMinNoOfDays(0);
				}

				
					appSetup.setTimeTaken(timeTaken);
					appSetup.setStartTime(startTime);
					appSetup.setEndTime(endTime);
							
				

				
				Users user = new Users();
				user.setId(Integer.parseInt(box.get("userId")));
			
				if (doctorId !=0 ) {
					MasEmployee masEmployee=new MasEmployee();
					masEmployee.setId(doctorId);
					appSetup.setDoctor(masEmployee);

				}
				
				
				if (sessionId !=0 ) {
					MasSession MasSession=new MasSession();
					MasSession.setId(sessionId);
					appSetup.setSession(MasSession);

				}
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(Integer.parseInt((String) departmentId
						.get(0)));
				appSetup.setDept(masDepartment);

				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				appSetup.setHospital(masHospital);
			
				
				appSetup.setLastChgBy(user);
				
				appSetup.setLastChgDate(date);
				appSetup.setLastChgTime(time);

				hbt.saveOrUpdate(appSetup);
				
			}
				
				dataSaved = true;
			} catch (Exception e) {
				dataSaved = false;
				e.printStackTrace();
			}

		}

		while (i <= 6) {
			try {
				
				if(null !=breakFromTime3.get(i) && !breakFromTime3.get(i).equals("") && null !=breakToTime2.get(i) && !breakToTime2.get(i).equals("") && null !=breakFromTime2.get(i) && !breakFromTime2.get(i).equals("")  && 0!=timeTaken && !startTime.isEmpty() && !endTime.isEmpty())
				{
				AppSetup appSetup = new AppSetup();
				appSetup.setDays((String) days.get(i));
				if (!dr.get(i).equals("") && dr.get(i) != null) {
				//	appSetup.setNoOfDoctor(Integer.parseInt((String) dr.get(i)));
				}
				/*appSetup.setFromTime((String) fromTime.get(i));
				appSetup.setToTime((String) toTime.get(i));
				appSetup.setSlotDuration((String) slotTime.get(i));
*/
				/*if (!percentage.get(i).equals("") && percentage.get(i) != null) {
					appSetup.setPercentageForSlots(Integer
							.parseInt((String) percentage.get(i)));
				} else {
					appSetup.setPercentageForSlots(0);
				}*/
				if(null !=breakFromTime3.get(i) && !breakFromTime3.get(i).equals(""))
					appSetup.setTotalToken(Integer.parseInt((String)breakFromTime3.get(i)));
					
				if(null !=TotalOnlineToken.get(i) && !TotalOnlineToken.get(i).equals(""))
					appSetup.setTotalOnlineToken(Integer.parseInt((String)TotalOnlineToken.get(i)));
				
				
					if(null !=breakToTime2.get(i) && !breakToTime2.get(i).equals(""))
					appSetup.setTotalInterval(Integer.parseInt((String) breakToTime2.get(i)));
					
					if(null !=breakFromTime2.get(i) && !breakFromTime2.get(i).equals(""))
					appSetup.setStartToken(Integer.parseInt((String) breakFromTime2.get(i)));
					
					

				if (!maxDays.get(i).equals("") && maxDays.get(i) != null) {
					appSetup.setMaxNoOfDays(Integer.parseInt((String) maxDays
							.get(i)));
				} else {
					appSetup.setMaxNoOfDays(0);
				}
				if (!minDays.get(i).equals("") && minDays.get(i) != null) {
					appSetup.setMinNoOfDays(Integer.parseInt((String) minDays
							.get(i)));
				} else {
					appSetup.setMinNoOfDays(0);
				}


					appSetup.setTimeTaken(timeTaken);
					appSetup.setStartTime(startTime);
					appSetup.setEndTime(endTime);

				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(Integer.parseInt((String) departmentId
						.get(0)));
				appSetup.setDept(masDepartment);

				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				appSetup.setHospital(masHospital);

				Users user = new Users();
				user.setId(Integer.parseInt(box.get("usersId")));
				appSetup.setLastChgBy(user);
				
				appSetup.setLastChgDate(date);
				appSetup.setLastChgTime(time);

				hbt.save(appSetup);
				
			}
				
				dataSaved = true;
			} catch (Exception e) {
				dataSaved = false;
				e.printStackTrace();
			}
			i++;
		}

		return dataSaved;
	}
	/**
	 * ---------------------------- PATIENT APPOINTMENTS --------------------
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> showAppointmentPatientJsp(
			Map<String, Object> mapForDs) {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<AppSetup> appSetupList = new ArrayList<AppSetup>();
		List<OpdHoliday> holidayList = new ArrayList<OpdHoliday>();
		int departmentId = 0;
		if (mapForDs.get("departmentId") != null) {
			departmentId = (Integer) mapForDs.get("departmentId");
		}

		List<String> departmentTypeCode = new ArrayList<String>();
		departmentTypeCode.add("CR");
		departmentTypeCode.add("OPD1");
		departmentTypeCode.add("SpltOPD");
		try {
			departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).createAlias(
					"DepartmentType", "dt").add(
					Restrictions
							.in("dt.DepartmentTypeCode", departmentTypeCode))
					.list();

			holidayList = session.createCriteria(OpdHoliday.class).add(
					Restrictions.eq("Status", "y")).list();

			appSetupList = session.createCriteria(AppSetup.class).add(
					Restrictions.eq("Dept.Id", departmentId)).add(
					Restrictions.ne("NoOfDoctor", 0)).add(Restrictions.isNull("validTo")).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("departmentList", departmentList);
		map.put("holidayList", holidayList);
		map.put("appSetupList", appSetupList);

		return map;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showPatientAppointmentSelectedDepartmentJsp(
			Box box) {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		int departmentId = box.getInt(DEPARTMENT_ID);
		List<AppSetup> appSetupList = new ArrayList<AppSetup>();
		List<String> departmentTypeCode = new ArrayList<String>();
		departmentTypeCode.add("CR");
		departmentTypeCode.add("OPD1");
		departmentTypeCode.add("SpltOPD");
		try {
			Criteria cr = session.createCriteria(AppSetup.class).add(
					Restrictions.eq("Dept.Id", departmentId)).add(
					Restrictions.ne("NoOfDoctor", 0)).add(
					Restrictions.isNull("validTo"));

			appSetupList = cr.list();
			sort(appSetupList);

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("appSetupList", appSetupList);

		return map;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showInvestigationAppointmentSelectedDeptEquipment(
			Box box) {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		int departmentId = box.getInt(DEPARTMENT_ID);
		int equipmentId = box.getInt(EQUIPMENT_ID);

		List<AppInvestigationSetup> appInvestigationSetupList = new ArrayList<AppInvestigationSetup>();

		try {
			appInvestigationSetupList = session.createCriteria(
					AppInvestigationSetup.class).add(
					Restrictions.eq("Department.Id", departmentId)).add(
					Restrictions.eq("Equipment.Id", equipmentId)).add(
					Restrictions.ne("FromTime", "")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("appInvestigationSetupList", appInvestigationSetupList);

		return map;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showAppointmentPatientDepartmentWise(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		// List<AppPatientAppointments> patientAppointmentList = new
		// ArrayList<AppPatientAppointments>();
		List<AppSetup> appSetupList = new ArrayList<AppSetup>();
		List<AppSetup> appSetupForAppointmentDaysList = new ArrayList<AppSetup>();

		List<AppPatientAppointments> patientAppointmentsList = new ArrayList<AppPatientAppointments>();
		List<MasRelation> relationList = new ArrayList<MasRelation>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<AppPatientAppointments> slotAvailableList = new ArrayList<AppPatientAppointments>();
		List<Patient> registeredPatientList = new ArrayList<Patient>();
		String slotList[][] = null;
		List<OpdHoliday> holidayList = new ArrayList<OpdHoliday>();
	 	holidayList=session.createCriteria(OpdHoliday.class).add(Restrictions.eq("Status", "y")).list();
        map.put("holidayList", holidayList);

		int departmentId = box.getInt(DEPARTMENT_ID);
		int noOfDoctors = 0;
		int counter = 1;
		int noOfSlots = 0;
		int percentageForSlots = 0;

		Integer[] noOfDoctorsList = new Integer[100];
		String queryString = null;
		String days[] = new String[8];
		Time d_fromTime = Time.valueOf("00:00:00");
		Time d_toTime = Time.valueOf("00:00:00");
		Time d_slotDuration = Time.valueOf("00:00:00");
		Time d_breakFromTime = Time.valueOf("00:00:00");
		Time d_breakToTime = Time.valueOf("00:00:00");

		int totalAppointments = 0;
		long maxNoOfDays = 0;
		long minNoOfDays = 0;
		Date maxDate = new Date();
		Date minDate = new Date();
		Date sysDate = new Date();
		Date apmtDate = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c_appointmentDate = Calendar.getInstance();
		if (box.get(APPOINTMENT_DATE) != null
				&& !box.get(APPOINTMENT_DATE).equals("")) {
			c_appointmentDate
					.setTime(HMSUtil.convertStringTypeDateToDateType(box
							.get(APPOINTMENT_DATE)));
			apmtDate = HMSUtil.convertStringTypeDateToDateType(box
					.get(APPOINTMENT_DATE));
		}
		String formattedDate = sdf.format(c_appointmentDate.getTime());
		days[1] = "Sunday";
		days[2] = "Monday";
		days[3] = "Tuesday";
		days[4] = "Wednesday";
		days[5] = "Thursday";
		days[6] = "Friday";
		days[7] = "Saturday";
		List<String> departmentTypeCode = new ArrayList<String>();
		departmentTypeCode.add("CR");
		departmentTypeCode.add("OPD1");
		departmentTypeCode.add("SpltOPD");

		try {
			departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).createAlias(
					"DepartmentType", "dt").add(
					Restrictions
							.in("dt.DepartmentTypeCode", departmentTypeCode))
					.list();
			employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).addOrder(
					Order.asc("FirstName")).list();
			getHibernateTemplate().setMaxResults(1);

			queryString = "from AppSetup where Dept=" + departmentId + " "
					+ "and Days='"
					+ days[c_appointmentDate.get(Calendar.DAY_OF_WEEK)] + "'"
					+ "and validFrom <= '" + formattedDate
					+ "' order by validFrom desc";

			appSetupList = getHibernateTemplate().find(queryString);

			Criteria cr = session.createCriteria(AppPatientAppointments.class)
					.add(
							Restrictions.eq("Department.Id", box
									.getInt(DEPARTMENT_ID))).add(
							Restrictions.eq("AppointmentDate",
									c_appointmentDate.getTime())).add(
							Restrictions.ne("AppointmentStatus", "c"));

			patientAppointmentsList = cr.list();
			// get Appointments if blocked for this department on this date
			String blockQry = "from AppBlock where Department.Id="
					+ box.getInt(DEPARTMENT_ID) + " and BlockFromDate <='"
					+ formattedDate + "'" + " and BlockToDate>='"
					+ formattedDate + "'";
			List blockedAppointmentList = getHibernateTemplate().find(blockQry);

			if (blockedAppointmentList.size() > 0)// check if appointments are
													// blocked
			{
				String message = "Appointments are blocked for this Department on this Date!!";
				map.put("blockMessage", message);
			} else {
				map.remove("blockMessage");
				if (appSetupList != null) {
					Iterator ite = appSetupList.iterator();
					while (ite.hasNext()) {
						AppSetup appSetup = (AppSetup) ite.next();
						if (appSetup.getFromTime() != null
								&& !appSetup.getFromTime().equals("")) {
							d_fromTime = Time.valueOf(appSetup.getFromTime());
						} else {
							d_fromTime = Time.valueOf("00:00:00");
						}
						if (appSetup.getToTime() != null
								&& !appSetup.getToTime().equals("")) {
							d_toTime = Time.valueOf(appSetup.getToTime());
						} else {
							d_toTime = Time.valueOf("00:00:00");
						}
						if (appSetup.getSlotDuration() != null
								&& !appSetup.getSlotDuration().equals("")) {
							d_slotDuration = Time.valueOf(appSetup
									.getSlotDuration());
						} else {
							d_slotDuration = Time.valueOf("00:00:00");
						}
						if (appSetup.getBreakFromTime() != null
								&& !appSetup.getBreakFromTime().equals("")) {
							d_breakFromTime = Time.valueOf(appSetup
									.getBreakFromTime());
						} else {
							d_breakFromTime = Time.valueOf("00:00:00");
						}
						if (appSetup.getBreakToTime() != null
								&& !appSetup.getBreakToTime().equals("")) {
							d_breakToTime = Time.valueOf(appSetup
									.getBreakToTime());
						} else {
							d_breakToTime = Time.valueOf("00:00:00");
						}
						if (appSetup.getNoOfDoctor() != null
								&& !(appSetup.getNoOfDoctor() == 0)) {
							noOfDoctors = appSetup.getNoOfDoctor();
						} else {
							noOfDoctors = 0;
						}
						if (appSetup.getMaxNoOfDays() != null
								&& !(appSetup.getMaxNoOfDays() == 0)) {
							maxNoOfDays = appSetup.getMaxNoOfDays();
						} else {
							maxNoOfDays = 0;
						}
						if (appSetup.getMinNoOfDays() != null
								&& !(appSetup.getMinNoOfDays() == 0)) {
							minNoOfDays = appSetup.getMinNoOfDays();
						} else {
							minNoOfDays = 0;
						}
						if (appSetup.getPercentageForSlots() != null
								&& !(appSetup.getPercentageForSlots() == 0)) {
							percentageForSlots = appSetup
									.getPercentageForSlots();
						} else {
							percentageForSlots = 0;
						}
						DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
						Date valid_from_date = appSetup.getValidFrom();
						Calendar cal1 = Calendar.getInstance();
						//cal1.setTime(valid_from_date);
						Date startDate = new Date((cal1.getTimeInMillis())+ (minNoOfDays * 24 * 60 * 60 * 1000));
						Date endDate1 = null;
						
						if(maxNoOfDays !=0){
						endDate1 = new Date((cal1.getTimeInMillis())+ (maxNoOfDays * 24 * 60 * 60 * 1000));
						}else{
							endDate1 =new Date(c_appointmentDate.getTimeInMillis())	;
						}
						
						//System.out.println("::startDate::"+format.format(startDate)+"::endDate::"+format.format(endDate1)+"::maxNoOfDays:"+maxNoOfDays);
												
						maxDate = new Date(c_appointmentDate.getTimeInMillis()
								- maxNoOfDays * 24 * 60 * 60 * 1000);
						minDate = new Date(c_appointmentDate.getTimeInMillis()
								- minNoOfDays * 24 * 60 * 60 * 1000);
						/*//System.out.println("c_appointmentDate.getTimeInMillis()::---"+c_appointmentDate.getTimeInMillis());
						//System.out.println("maxNoOfDays * 24 * 60 * 60 * 1000::--"+(maxNoOfDays * 24 * 60 * 60 * 1000)+":::maxNoOfDays::"+maxNoOfDays);
						//System.out.println("minNoOfDays * 24 * 60 * 60 * 1000::--"+(minNoOfDays * 24 * 60 * 60 * 1000)+":::minNoOfDays::"+minNoOfDays);
						*/
						Date minParsedDate = null;
						Date sysParsedDate = null;
						Date startDateWithoutTime = null ;
						Date endDateWithoutTime = null ;
						try {
							
							startDateWithoutTime = (Date) format.parse(HMSUtil
									.convertDateToStringWithoutTime(startDate));
							
							endDateWithoutTime = (Date) format.parse(HMSUtil
									.convertDateToStringWithoutTime(endDate1));
							
							minParsedDate = (Date) format.parse(HMSUtil
									.convertDateToStringWithoutTime(minDate));
							sysParsedDate = (Date) format.parse(HMSUtil
									.convertDateToStringWithoutTime(sysDate));
							/*//System.out.println("::sysDate::"+sysDate);
							//System.out.println("::maxDate::"+maxDate);
							//System.out.println("::sysDate::"+sysDate);
							//System.out.println("::minDate::"+minDate);
							//System.out.println("::sysParsedDate::"+sysParsedDate);
							//System.out.println("::minParsedDate::"+minParsedDate);
							//System.out.println("::sysDate::"+sysDate);*/
							//System.out.println("::apmtDate::"+apmtDate);
							//System.out.println("::startDateWithoutTime::"+startDateWithoutTime);
							//System.out.println("::endDateWithoutTime::"+endDateWithoutTime);
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
                        
						/*if (sysDate.compareTo(maxDate) >= 0
								&& (sysDate.compareTo(minDate) < 0 || sysParsedDate
										.equals(minParsedDate))
								&& apmtDate.compareTo(sysDate) >= 0) {*/
						if(apmtDate.compareTo(startDateWithoutTime)>=0 && apmtDate.compareTo(endDateWithoutTime)<=0 ){
							map = calculateSlots(d_fromTime, d_toTime,
									d_slotDuration, d_breakFromTime,
									d_breakToTime);
							slotList = (String[][]) map.get("slotList");
							counter = (Integer) map.get("counter");

							// **********************************************************
							// for counting no. of slots calculated done on 22
							// Aug 2008.
							// calculation for restricting appointments
							// according to the percentage for slots
							// **********************************************************

							for (int i = 0; i < counter; i++) {
								if (slotList[i][1] != null)
									noOfSlots++;
							}
							if (percentageForSlots > 0) {
								totalAppointments = (noOfDoctors * noOfSlots)
										* percentageForSlots / 100;
							}
							int actualAvailableAppointments = totalAppointments
									- patientAppointmentsList.size();
							// **********************************************************

							if (actualAvailableAppointments > 0) {
								map.put("actualAvailableAppointments",
										actualAvailableAppointments);
								try {
									for (int i = 0; i < counter; i++) {
										// String
										// slotDuration=slotList[i][0]+" - "+slotList[i][1];
										Criteria appCr = session
												.createCriteria(
														AppPatientAppointments.class)
												.add(
														Restrictions
																.eq(
																		"Department.Id",
																		box
																				.getInt(DEPARTMENT_ID)))
												.add(
														Restrictions
																.and(
																		Restrictions
																				.ge(
																						"FromTimeSlot",
																						slotList[i][0]),
																		Restrictions
																				.le(
																						"ToTimeSlot",
																						slotList[i][1])))
												.add(
														Restrictions
																.eq(
																		"AppointmentDate",
																		c_appointmentDate
																				.getTime()))
												.add(
														Restrictions
																.ne(
																		"AppointmentStatus",
																		"c"));
										slotAvailableList = appCr.list();
										// //System.out.println("Query:"+appCr.toString());
										int temp = noOfDoctors
												- slotAvailableList.size();
										noOfDoctorsList[i] = temp;

									}
								} catch (DataAccessException e) {
									e.printStackTrace();
								}
							} else {
								String message = null;
								if (noOfSlots == 0) {
									message = "Appointment for this date is not available!!";
								} else {
									message = "Appointments are full!!";
								}
								map.put("message", message);
							}
							if (box.get("parent") != null
									&& !box.get("parent").equals("")) {
								registeredPatientList = showExistingPatientDetail(Integer
										.parseInt((String) box.get("parent")));
								map.put("registeredPatientList",
										registeredPatientList);
							}

						} else if ((minNoOfDays == 0 && maxNoOfDays == 0)||( maxNoOfDays == 0 && apmtDate.compareTo(startDateWithoutTime)>=0)) {
							map = calculateSlots(d_fromTime, d_toTime,
									d_slotDuration, d_breakFromTime,
									d_breakToTime);
							slotList = (String[][]) map.get("slotList");
							counter = (Integer) map.get("counter");
							// **********************************************************
							// for counting no. of slots calculated done on 22
							// Aug 2008.
							// calculation for restricting appointments
							// according to the percentage for slots
							// **********************************************************

							for (int i = 0; i < counter; i++) {
								if (slotList[i][1] != null)
									noOfSlots++;
							}
							if (percentageForSlots > 0) {
								totalAppointments = (noOfDoctors * noOfSlots)
										* percentageForSlots / 100;
							}
							int actualAvailableAppointments = totalAppointments
									- patientAppointmentsList.size();
							// **********************************************************

							if (actualAvailableAppointments > 0) {
								map.put("actualAvailableAppointments",
										actualAvailableAppointments);
								try {
									for (int i = 0; i < counter; i++) {
										String slotDuration = slotList[i][0]
												+ " - " + slotList[i][1];
										Criteria appCr = session
												.createCriteria(
														AppPatientAppointments.class)
												.add(
														Restrictions
																.eq(
																		"Department.Id",
																		box
																				.getInt(DEPARTMENT_ID)))
												.add(
														Restrictions
																.and(
																		Restrictions
																				.ge(
																						"FromTimeSlot",
																						slotList[i][0]),
																		Restrictions
																				.le(
																						"ToTimeSlot",
																						slotList[i][1])))
												.add(
														Restrictions
																.eq(
																		"AppointmentDate",
																		c_appointmentDate
																				.getTime()))
												.add(
														Restrictions
																.ne(
																		"AppointmentStatus",
																		"c"));
										slotAvailableList = appCr.list();
										int temp = noOfDoctors
												- slotAvailableList.size();
										noOfDoctorsList[i] = temp;

									}
								} catch (DataAccessException e) {
									e.printStackTrace();
								}
							}

							else {
								String message = null;
								if (noOfSlots == 0) {
									message = "Appointment for this date is not available!!";
								} else {
									message = "Appointments are full!!";
								}
								map.put("message", message);
							}
							if (box.get("parent") != null
									&& !box.get("parent").equals("")) {
								registeredPatientList = showExistingPatientDetail(Integer
										.parseInt((String) box.get("parent")));
								map.put("registeredPatientList",
										registeredPatientList);
							}

						}else {
							String message = "Date Is Beyond Min. Max. Days !!";
							map.put("message", message);
						}
					}
				}
			}// end of check for block appointments

			Criteria appCr = session.createCriteria(AppSetup.class).add(
					Restrictions.eq("Dept.Id", departmentId)).add(
					Restrictions.ne("NoOfDoctor", 0)).add(
					Restrictions.isNull("validTo"));
			appSetupForAppointmentDaysList = appCr.list();

			relationList = session.createCriteria(MasRelation.class).add(
					Restrictions.eq("Status", "y")).list();

		} catch (HibernateException e) {

			e.printStackTrace();
		}
		map.put("employeeList", employeeList);
		map.put("relationList", relationList);
		map.put("appSetupList", appSetupForAppointmentDaysList);
		map.put("noOfDoctorsList", noOfDoctorsList);
		map.put("departmentList", departmentList);
		map.put("apmtDate", apmtDate);
		// map.put("patientAppointmentsList", patientAppointmentsList);

		return map;

	}

	/**
	 * ------------------------------------------------------------------------
	 * ------ common method for calculation of slots in both patient appointment
	 * screen and in investigation appointment screen.
	 * 
	 * @param fromTime
	 * @param toTime
	 * @param slot
	 * @param breakFromTime
	 * @param breakToTime
	 * @return 
	 *         ------------------------------------------------------------------
	 *         ------------
	 */
	public Map<String, Object> calculateSlots(Time fromTime, Time toTime,
			Time slot, Time breakFromTime, Time breakToTime) {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		String slotList[][] = new String[100][2];

		Calendar c_fromTime = Calendar.getInstance();
		c_fromTime.setTime(fromTime);

		Calendar c_breakFromTime = Calendar.getInstance();
		c_breakFromTime.setTime(breakFromTime);

		Calendar c_breakToTime = Calendar.getInstance();
		c_breakToTime.setTime(breakToTime);

		Calendar c_toTime = Calendar.getInstance();
		c_toTime.setTime(toTime);

		Calendar c_slot = Calendar.getInstance();
		c_slot.setTime(slot);

		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String date = sdf.format(c_fromTime.getTime());

		int counter = 0;

		while (c_fromTime.before(c_toTime)) {
			if ((c_fromTime.before(c_breakFromTime))
					|| (c_fromTime.after(c_breakToTime))) {
				slotList[counter][0] = sdf.format(fromTime);
				c_fromTime.add(Calendar.MINUTE, c_slot.get(Calendar.MINUTE));
				c_fromTime.add(Calendar.HOUR_OF_DAY, c_slot
						.get(Calendar.HOUR_OF_DAY));
				date = sdf.format(c_fromTime.getTime());
				slotList[counter][1] = date;
				fromTime = java.sql.Time.valueOf(date);
			} else {
				c_breakToTime.add(Calendar.HOUR_OF_DAY, -c_breakFromTime
						.get(Calendar.HOUR_OF_DAY));
				c_breakToTime.add(Calendar.MINUTE, -c_breakFromTime
						.get(Calendar.MINUTE));
				c_fromTime.add(Calendar.HOUR_OF_DAY, c_breakToTime
						.get(Calendar.HOUR_OF_DAY));
				c_fromTime.add(Calendar.MINUTE, c_breakToTime
						.get(Calendar.MINUTE));
				date = sdf.format(c_fromTime.getTime());
				fromTime = java.sql.Time.valueOf(date);
			}
			counter++;
		}
		slotList[counter][0] = sdf.format(fromTime);
		map.put("slotList", slotList);
		map.put("counter", counter);
		return map;

	}

	public Map<String, Object> showExistingPatients(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> registeredPatientList = new ArrayList<Patient>();
		boolean recordExists = true;

		try {
			registeredPatientList = session.createCriteria(Patient.class).add(
					Restrictions.eq("ServiceNo", box.getString(SERVICE_NO)))
			// .add(Restrictions.eq("PatientStatus","Out Patient"))
					.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("registeredPatientList", registeredPatientList);
		if (registeredPatientList.size() > 0) {
			recordExists = true;
		} else {
			recordExists = false;
		}
		map.put("recordExists", recordExists);
		map.put("box", box);
		return map;
	}

	public Map<String, Object> showExistingPatientsForDoctors(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> registeredPatientList = new ArrayList<Patient>();
		boolean recordExists = true;

		try {
			registeredPatientList = session.createCriteria(Patient.class).add(
					Restrictions.eq("ServiceNo", box.getString(SERVICE_NO)))
					.add(Restrictions.eq("PatientStatus", "Out Patient"))
					.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("registeredPatientList", registeredPatientList);
		if (registeredPatientList.size() > 0) {
			recordExists = true;
		} else {
			recordExists = false;
		}
		map.put("recordExists", recordExists);
		map.put("box", box);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showListBasedonHinNo(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> listBasedonHinNo = new ArrayList<Patient>();
		List<MasRelation> relationList = new ArrayList<MasRelation>();
		boolean hinNoExist = true;
		try {
			listBasedonHinNo = session.createCriteria(Patient.class).add(
					Restrictions.eq("HinNo", box.getString(HIN_NO))).list();
			relationList = session.createCriteria(MasRelation.class).add(
					Restrictions.eq("Status", "y")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("relationList", relationList);
		map.put("listBasedonHinNo", listBasedonHinNo);
		if (listBasedonHinNo.size() > 0) {
			hinNoExist = true;
		} else {
			hinNoExist = false;
		}
		//System.out.println("listBasedonHinNo==" + listBasedonHinNo.size());
		map.put("hinNoExist", hinNoExist);
		map.put("listBasedonHinNo", listBasedonHinNo);
		map.put("box", box);
		return map;
	}

	public Map<String, Object> checkForHinNo(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<AppPatientAppointments> hinList = new ArrayList<AppPatientAppointments>();
		Date apmtDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString(APMT_DATE));
		boolean patientNameExist = false;
		Criteria criteria = null;
		try {
			criteria = session.createCriteria(AppPatientAppointments.class)
					.add(Restrictions.eq("AppointmentStatus", "y")).add(
							Restrictions.eq("AppointmentDate", apmtDate))
					.createAlias("Department", "md").add(
							Restrictions.eq("md.Id", box.getInt(WARD_ID)));

			if (!box.getString(HIN_ID).equals("")) {
				criteria = criteria.createAlias("Hin", "pt").add(
						Restrictions.eq("pt.Id", Integer.parseInt(box
								.getString(HIN_ID))));
			}
			if (!box.getString(PATIENT_NAME).equals("")) {
				criteria = criteria.add(Restrictions.eq("PatientName", box
						.getString(PATIENT_NAME)));
			}
			if (!box.getString(AGE).equals("")) {
				criteria = criteria.add(Restrictions.eq("Age", box
						.getString(AGE)
						+ " " + box.getString(AGEUNIT)));
			}
			if (!box.getString(MOBILE_NO).equals("")) {
				criteria = criteria.add(Restrictions.eq("MobileNo", box
						.getString(MOBILE_NO)));
			}
			if (!box.getString(SEX).equals("")) {
				criteria = criteria.add(Restrictions.eq("Sex", box
						.getString(SEX)));
			}
			hinList = criteria.list();

			if (box.getString(HIN_ID).equals("")
					&& !box.getString(PATIENT_NAME).equals("")
					&& hinList.size() > 0) {
				patientNameExist = true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("hinList", hinList);
		map.put("patientNameExist", patientNameExist);
		return map;
	}

	public Map<String, Object> checkForApmtInDiffDept(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<AppPatientAppointments> hinList = new ArrayList<AppPatientAppointments>();
		Date apmtDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString(APMT_DATE));
		boolean recordExists = false;
		Criteria criteria = null;
		try {
			criteria = session.createCriteria(AppPatientAppointments.class)
					.add(Restrictions.eq("AppointmentStatus", "y")).add(
							Restrictions.eq("AppointmentDate", apmtDate));

			if (!box.getString(HIN_ID).equals("")) {
				criteria = criteria.createAlias("Hin", "pt").add(
						Restrictions.eq("pt.Id", Integer.parseInt(box
								.getString(HIN_ID))));
			}
			if (!box.getString(PATIENT_NAME).equals("")) {
				criteria = criteria.add(Restrictions.eq("PatientName", box
						.getString(PATIENT_NAME)));
			}
			if (!box.getString(AGE).equals("")) {
				criteria = criteria.add(Restrictions.eq("Age", box
						.getString(AGE)
						+ " " + box.getString(AGE_UNIT)));
			}
			if (!box.getString(MOBILE_NO).equals("")) {
				criteria = criteria.add(Restrictions.eq("MobileNo", box
						.getString(MOBILE_NO)));
			}
			if (!box.getString(SEX).equals("")) {
				criteria = criteria.add(Restrictions.eq("Sex", box
						.getString(SEX)));
			}

			hinList = criteria.list();
			if (hinList != null && hinList.size() > 0) {

				Iterator ite = hinList.iterator();
				while (ite.hasNext()) {
					AppPatientAppointments appPatientAppointments = (AppPatientAppointments) ite
							.next();
					if (!appPatientAppointments.getDepartment().getId().equals(
							box.getInt(WARD_ID))) {
						recordExists = true;
						map.put("existingDept", appPatientAppointments
								.getDepartment().getDepartmentName());
						map.put("existingStartTime", appPatientAppointments
								.getFromTimeSlot());
						map.put("existingEndTime", appPatientAppointments
								.getToTimeSlot());
					}

				}

			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("recordExists", recordExists);
		map.put("hinList", hinList);
		return map;
	}

	public List<Patient> showExistingPatientDetail(Integer hinId) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> registeredPatientList = new ArrayList<Patient>();

		try {
			registeredPatientList = session.createCriteria(Patient.class).add(
					Restrictions.eq("Id", hinId)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return registeredPatientList;
	}

	public String generateAppointmentNo(Date appointmentDate, int departmentId,
			int appointmentId, String var_prefix) {
		String appointmentNo = null;
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
		String date = sdf.format(appointmentDate);
		/**
		 * format of appointment no. AP as prefix - Appointment date in ddmmyyyy
		 * format - departmentId - appointmentId
		 */
		appointmentNo = var_prefix + "-" + date + "-" + departmentId + "-"
				+ appointmentId;
		return appointmentNo;
	}

	public Map<String, Object> submitPatientAppointment(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<AppPatientAppointments> hinList = new ArrayList<AppPatientAppointments>();
		Session session = (Session) getSession();
		boolean dataSaved = false;
		boolean duplicateRecord = false;
		String appointmentNo = null;

		String fromTimeSlot = box.getString(FROMTIMESLOT);
		String toTimeSlot = box.getString(TOTIMESLOT);

		int departmentId = box.getInt(WARD_ID);
		Date appointmentDate = HMSUtil.convertStringTypeDateToDateType(box
				.get(APMT_DATE));
		String serviceNo = box.getString(SERVICE_NO);
		String servicePerson = box.getString("servicePerson");
		String hinId = box.getString(HIN_ID);
		String patientName = box.getString(PATIENT_NAME);
		String sex = box.getString(SEX);
		int relationId = box.getInt(RELATION_ID);
		String age = box.getString(AGE);
		String ageUnit = box.getString(AGE_UNIT);
		String rank = box.getString("rank");
		String mobileNo = box.getString(MOBILE_NO);
		int doctorId = box.getInt(EMPLOYEE_ID);

		int hospitalId = box.getInt("hospitalId");
		String userName = box.getString("userName");

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		boolean patientNameExist = false;
		boolean recordExists = false;

		map = checkForApmtInDiffDept(box);
		String existingDept = (String) map.get("existingDept");
		String existingStartTime = (String) map.get("existingStartTime");
		String existingEndTime = (String) map.get("existingEndTime");
		if (map.get("recordExists") != null)
			recordExists = (Boolean) map.get("recordExists");
		map = checkForHinNo(box);
		if (hinList != null)
			hinList = (List) map.get("hinList");

		patientNameExist = (Boolean) map.get("patientNameExist");

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			AppPatientAppointments appPatientAppointments = new AppPatientAppointments();
			appPatientAppointments.setFromTimeSlot((String) fromTimeSlot);
			appPatientAppointments.setToTimeSlot((String) toTimeSlot);

			appPatientAppointments.setAppointmentDate(appointmentDate);

			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			appPatientAppointments.setDepartment(masDepartment);

			Patient patient = new Patient();
			if (hinId != null && !hinId.equals("")) {
				patient.setId(Integer.parseInt(hinId));
				appPatientAppointments.setHin(patient);
				appPatientAppointments.setRegisteredStatus("y");
				appPatientAppointments.setAge(age);

			} else {
				appPatientAppointments.setRegisteredStatus("n");
				if (ageUnit != null) {
					appPatientAppointments.setAge((String) age + " "
							+ (String) ageUnit);
				} else {
					appPatientAppointments.setAge((String) age);
				}
			}
			if (serviceNo != null && !serviceNo.equals("")) {
				appPatientAppointments.setServiceNo((String) serviceNo);
			}
			if (servicePerson != null && !servicePerson.equals("")) {
				appPatientAppointments
						.setServicePersonName((String) servicePerson);
			}
			if (rank != null && !rank.equals("")) {
				appPatientAppointments.setRank((String) rank);
			}
			if (doctorId != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(doctorId);
				appPatientAppointments.setEmployee(masEmployee);
			}

			appPatientAppointments.setPatientName((String) patientName);
			appPatientAppointments.setMobileNo(mobileNo);
			MasRelation relation = new MasRelation();
			relation.setId(relationId);
			appPatientAppointments.setRelation(relation);

			appPatientAppointments.setSex((String) sex);

			appPatientAppointments.setAppointmentStatus("y");

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			appPatientAppointments.setHospital(masHospital);

			Users user = new Users();
			appPatientAppointments.setLastChgBy(userName);
			appPatientAppointments.setLastChgDate(date);
			appPatientAppointments.setLastChgTime(time);
			if (hinList != null) {
				if (hinList.size() == 0 && recordExists == false
						&& patientNameExist == false) {
					hbt.save(appPatientAppointments);
					int appointmentId = appPatientAppointments.getId();
					appointmentNo = generateAppointmentNo(appointmentDate,
							departmentId, appointmentId, "AP");
					AppPatientAppointments appPatientAppointments1 = (AppPatientAppointments) hbt
							.load(AppPatientAppointments.class, appointmentId);
					appPatientAppointments1.setAppointmentNo(appointmentNo);
					hbt.saveOrUpdate(appPatientAppointments1);
					dataSaved = true;
					duplicateRecord = false;
					map.put("appointmentNo", appointmentNo);
				} else if (hinList.size() > 0 && patientNameExist == false
						&& recordExists == false) {
					map
							.put(
									"message",
									patientName
											+ " already taken Appointment for this Department!!");
					dataSaved = false;
					duplicateRecord = true;
				} else if (recordExists == true) {
					map.put("existingDept", existingDept);
					map.put("existingStartTime", existingStartTime);
					map.put("existingEndTime", existingEndTime);
				}

			}
			map.put("recordExists", recordExists);
			map.put("patientNameExist", patientNameExist);

			map.put("patientName", patientName);
			map.put("duplicateRecord", duplicateRecord);

			map.put("age", age);
			map.put("sex", sex);

		} catch (Exception e) {
			dataSaved = false;
			e.printStackTrace();
		}
		map.put("dataSaved", dataSaved);
		return map;
	}
	public Map<String, Object> submitDulicatePatientNameAppointment(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();
		boolean dataSaved = false;
		String appointmentNo = null;

		String fromTimeSlot = box.getString("returnStartTime");
		String toTimeSlot = box.getString("returnEndTime");
		int departmentId = box.getInt("returnDeptId");
		Date appointmentDate = HMSUtil.convertStringTypeDateToDateType(box
				.get("returnAppointmentDate"));
		String patientName = box.getString("returnPatientName");
		String sex = box.getString("returnSex");
		String age = box.getString("returnAge");
		String ageUnit = box.getString("returnAgeUnit");
		String serviceNo = box.getString("returnServiceNo");
		String servicePerson = box.getString("returnServicePerson");
		String hinId = box.getString("returnHinId");
		String mobileNo = box.getString("returnMobileNo");
		int doctorId = box.getInt("returnDoctorId");
		int hospitalId = box.getInt("hospitalId");
		String userName = box.getString("userName");

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		departmentList = session.createCriteria(MasDepartment.class).add(
				Restrictions.eq("Status", "y")).createAlias("DepartmentType",
				"dt").add(Restrictions.eq("dt.Id", 1)).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			AppPatientAppointments appPatientAppointments = new AppPatientAppointments();
			appPatientAppointments.setFromTimeSlot((String) fromTimeSlot);
			appPatientAppointments.setToTimeSlot((String) toTimeSlot);

			appPatientAppointments.setAppointmentDate(appointmentDate);

			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			appPatientAppointments.setDepartment(masDepartment);

			Patient patient = new Patient();
			if (hinId != null && !hinId.equals("")) {
				patient.setId(Integer.parseInt(hinId));
				appPatientAppointments.setHin(patient);
				appPatientAppointments.setRegisteredStatus("y");
				appPatientAppointments.setAge(age);

			} else {
				appPatientAppointments.setRegisteredStatus("n");
				if (ageUnit != null) {
					appPatientAppointments.setAge((String) age + " "
							+ (String) ageUnit);
				} else {
					appPatientAppointments.setAge((String) age);
				}
			}
			if (serviceNo != null && !serviceNo.equals("")) {
				appPatientAppointments.setServiceNo((String) serviceNo);
			}
			if (servicePerson != null && !servicePerson.equals("")) {
				appPatientAppointments
						.setServicePersonName((String) servicePerson);
			}
			if (doctorId != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(doctorId);
				appPatientAppointments.setEmployee(masEmployee);
			}

			appPatientAppointments.setPatientName((String) patientName);
			appPatientAppointments.setMobileNo(mobileNo);
			appPatientAppointments.setSex((String) sex);

			appPatientAppointments.setAppointmentStatus("y");

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			appPatientAppointments.setHospital(masHospital);

			appPatientAppointments.setLastChgBy(userName);
			appPatientAppointments.setLastChgDate(date);
			appPatientAppointments.setLastChgTime(time);
			hbt.save(appPatientAppointments);

			int appointmentId = appPatientAppointments.getId();
			appointmentNo = generateAppointmentNo(appointmentDate,
					departmentId, appointmentId, "AP");
			AppPatientAppointments appPatientAppointments1 = (AppPatientAppointments) hbt
					.load(AppPatientAppointments.class, appointmentId);
			appPatientAppointments1.setAppointmentNo(appointmentNo);
			hbt.saveOrUpdate(appPatientAppointments1);
			dataSaved = true;
			map.put("appointmentNo", appointmentNo);
			map.put("dataSaved", dataSaved);
			map.put("departmentList", departmentList);

		} catch (Exception e) {
			dataSaved = false;
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * --------------- INVESTIGATION SETUP -------------------------
	 */

	public Map<String, Object> showAppointmentInvestigationSetupJsp() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<AppEquipmentMaster> equipmentList = new ArrayList<AppEquipmentMaster>();
		boolean recordExists = true;
		Integer dept[] = new Integer[3];
		dept[0] = 1;
		dept[1] = 4;
		dept[2] = 19;

		try {
			departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).createAlias(
					"DepartmentType", "dt").add(Restrictions.in("dt.Id", dept))
					.list();
			equipmentList = session.createCriteria(AppEquipmentMaster.class)
					.add(Restrictions.eq("EquipmentStatus", "y")).add(
							Restrictions.gt("NoOfEquipments", 0)).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("departmentList", departmentList);
		map.put("equipmentList", equipmentList);

		return map;
	}

	public Map<String, Object> showAppointmentInvestigationSetupDetails(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<AppEquipmentMaster> equipmentList = new ArrayList<AppEquipmentMaster>();
		List<AppInvestigationSetup> investigationList = new ArrayList<AppInvestigationSetup>();
		boolean recordExists = true;
		Integer dept[] = new Integer[3];
		dept[0] = 1;
		dept[1] = 4;
		dept[2] = 19;
		try {
			departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).createAlias(
					"DepartmentType", "dt").add(Restrictions.in("dt.Id", dept))
					.list();
			equipmentList = session.createCriteria(AppEquipmentMaster.class)
					.add(Restrictions.eq("EquipmentStatus", "y")).add(
							Restrictions.gt("NoOfEquipments", 0)).list();
			investigationList = session.createCriteria(
					AppInvestigationSetup.class)
					.createAlias("Department", "md")
					.add(Restrictions.eq("md.Id", box.getInt(DEPARTMENT_ID)))
					.createAlias("Equipment", "em").add(
							Restrictions.eq("em.Id", box.getInt(EQUIPMENT_ID)))
					.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("departmentList", departmentList);
		map.put("equipmentList", equipmentList);
		map.put("investigationList", investigationList);
		map.put("box", box);
		return map;
	}

	public boolean submitAppointmentInvestigationSetup(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<AppEquipmentMaster> equipmentList = new ArrayList<AppEquipmentMaster>();

		Session session = (Session) getSession();
		boolean dataSaved = false;

		Vector days = box.getVector(DAYS);
		int noOfEquipments = 0;
		Vector fromTime = box.getVector(FROMTIME);
		Vector toTime = box.getVector(TOTIME);
		Vector slotTime = box.getVector(SLOTTIME);
		Vector percentage = box.getVector(PERCENTAGE);
		Vector breakFromTime = box.getVector(BREAKFROMTIME);
		Vector breakToTime = box.getVector(BREAKTOTIME);
		Vector maxDays = box.getVector(MAXDAYS);
		Vector minDays = box.getVector(MINDAYS);
		int departmentId = box.getInt(WARD_ID);
		int equipmentId = box.getInt(EQUIP_ID);
		int hospitalId = box.getInt("hospitalId");
		String userName = box.getString("userName");
		Integer dept[] = new Integer[3];
		dept[0] = 1;
		dept[1] = 4;
		dept[2] = 19;

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		departmentList = session.createCriteria(MasDepartment.class).add(
				Restrictions.eq("Status", "y")).createAlias("DepartmentType",
				"dt").add(Restrictions.in("dt.Id", dept)).list();
		equipmentList = session.createCriteria(AppEquipmentMaster.class).add(
				Restrictions.eq("Id", equipmentId)).add(
				Restrictions.eq("EquipmentStatus", "y")).add(
				Restrictions.gt("NoOfEquipments", 0)).list();
		noOfEquipments = (Integer) equipmentList.get(0).getNoOfEquipments();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		for (int i = 0; i <= 6; i++) {
			try {
				AppInvestigationSetup appInvestigationSetup = new AppInvestigationSetup();
				appInvestigationSetup.setDays((String) days.get(i));
				appInvestigationSetup.setNoOfEquipments(noOfEquipments);
				appInvestigationSetup.setFromTime((String) fromTime.get(i));
				appInvestigationSetup.setToTime((String) toTime.get(i));
				appInvestigationSetup.setSlotDuration((String) slotTime.get(i));

				if (!percentage.get(i).equals("") && percentage.get(i) != null) {
					appInvestigationSetup.setPercentageForSlots(Integer
							.parseInt((String) percentage.get(i)));
				} else {
					appInvestigationSetup.setPercentageForSlots(0);
				}
				appInvestigationSetup.setBreakFromTime((String) breakFromTime
						.get(i));
				appInvestigationSetup.setBreakToTime((String) breakToTime
						.get(i));
				if (!maxDays.get(i).equals("") && maxDays.get(i) != null) {
					appInvestigationSetup.setMaxNoOfDays(Integer
							.parseInt((String) maxDays.get(i)));
				} else if (maxDays.get(i).equals("") || maxDays.get(i) == null) {
					appInvestigationSetup.setMaxNoOfDays(0);
				}
				if (!minDays.get(i).equals("") && minDays.get(i) != null) {
					appInvestigationSetup.setMinNoOfDays(Integer
							.parseInt((String) minDays.get(i)));
				} else if (minDays.get(i).equals("") || minDays.get(i) == null) {
					appInvestigationSetup.setMinNoOfDays(0);
				}

				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(departmentId);
				appInvestigationSetup.setDepartment(masDepartment);

				AppEquipmentMaster appEquipmentMaster = new AppEquipmentMaster();
				appEquipmentMaster.setId(equipmentId);
				appInvestigationSetup.setEquipment(appEquipmentMaster);

				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				appInvestigationSetup.setHospital(masHospital);

				appInvestigationSetup.setLastChgBy(userName);
				appInvestigationSetup.setLastChgDate(date);
				appInvestigationSetup.setLastChgTime(time);

				hbt.save(appInvestigationSetup);
				dataSaved = true;
			} catch (Exception e) {
				dataSaved = false;
				e.printStackTrace();
			}
		}

		return dataSaved;
	}

	public boolean updateAppointmentInvestigationSetup(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<AppEquipmentMaster> equipmentList = new ArrayList<AppEquipmentMaster>();
		Session session = (Session) getSession();
		boolean dataSaved = false;

		Vector days = box.getVector(DAYS);
		Vector fromTime = box.getVector(FROMTIME);
		Vector toTime = box.getVector(TOTIME);
		Vector slotTime = box.getVector(SLOTTIME);
		Vector percentage = box.getVector(PERCENTAGE);
		Vector breakFromTime = box.getVector(BREAKFROMTIME);
		Vector breakToTime = box.getVector(BREAKTOTIME);
		Vector maxDays = box.getVector(MAXDAYS);
		Vector minDays = box.getVector(MINDAYS);
		int departmentId = box.getInt(WARD_ID);
		int equipmentId = box.getInt(EQUIP_ID);
		// Vector departmentId=box.getVector(DEPT_ID);
		int hospitalId = box.getInt("hospitalId");
		Vector investigationId = box.getVector(INVESTIGATION_ID);
		int i = 0;
		int noOfEquipments = 0;
		Integer dept[] = new Integer[3];
		dept[0] = 1;
		dept[1] = 4;
		dept[2] = 19;

		String userName = box.getString("userName");

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		departmentList = session.createCriteria(MasDepartment.class).add(
				Restrictions.eq("Status", "y")).createAlias("DepartmentType",
				"dt").add(Restrictions.in("dt.Id", dept)).list();

		equipmentList = session.createCriteria(AppEquipmentMaster.class).add(
				Restrictions.eq("Id", equipmentId)).add(
				Restrictions.eq("EquipmentStatus", "y")).add(
				Restrictions.gt("NoOfEquipments", 0)).list();
		noOfEquipments = (Integer) equipmentList.get(0).getNoOfEquipments();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		for (i = 0; i <= investigationId.size() - 1; i++) {
			try {
				AppInvestigationSetup appInvestigationSetup = (AppInvestigationSetup) hbt
						.load(AppInvestigationSetup.class, Integer
								.parseInt((String) investigationId.get(i)));
				appInvestigationSetup.setDays((String) days.get(i));
				appInvestigationSetup.setNoOfEquipments(noOfEquipments);
				appInvestigationSetup.setFromTime((String) fromTime.get(i));
				appInvestigationSetup.setToTime((String) toTime.get(i));
				appInvestigationSetup.setSlotDuration((String) slotTime.get(i));

				if (!percentage.get(i).equals("") && percentage.get(i) != null) {
					appInvestigationSetup.setPercentageForSlots(Integer
							.parseInt((String) percentage.get(i)));
				} else {
					appInvestigationSetup.setPercentageForSlots(0);
				}
				appInvestigationSetup.setBreakFromTime((String) breakFromTime
						.get(i));
				appInvestigationSetup.setBreakToTime((String) breakToTime
						.get(i));
				if (!maxDays.get(i).equals("") && maxDays.get(i) != null) {
					appInvestigationSetup.setMaxNoOfDays(Integer
							.parseInt((String) maxDays.get(i)));
				} else if (maxDays.get(i).equals("") || maxDays.get(i) == null) {
					appInvestigationSetup.setMaxNoOfDays(0);
				}
				if (!minDays.get(i).equals("") && minDays.get(i) != null) {
					appInvestigationSetup.setMinNoOfDays(Integer
							.parseInt((String) minDays.get(i)));
				} else if (minDays.get(i).equals("") || minDays.get(i) == null) {
					appInvestigationSetup.setMinNoOfDays(0);
				}
				appInvestigationSetup.setLastChgBy(userName);
				appInvestigationSetup.setLastChgDate(date);
				appInvestigationSetup.setLastChgTime(time);

				hbt.saveOrUpdate(appInvestigationSetup);
				dataSaved = true;
			} catch (Exception e) {
				dataSaved = false;
				e.printStackTrace();
			}

		}

		while (i <= 6) {
			try {
				AppInvestigationSetup appInvestigationSetup = new AppInvestigationSetup();
				appInvestigationSetup.setDays((String) days.get(i));
				appInvestigationSetup.setNoOfEquipments(noOfEquipments);
				appInvestigationSetup.setFromTime((String) fromTime.get(i));
				appInvestigationSetup.setToTime((String) toTime.get(i));
				appInvestigationSetup.setSlotDuration((String) slotTime.get(i));

				if (!percentage.get(i).equals("") && percentage.get(i) != null) {
					appInvestigationSetup.setPercentageForSlots(Integer
							.parseInt((String) percentage.get(i)));
				} else {
					appInvestigationSetup.setPercentageForSlots(0);
				}
				appInvestigationSetup.setBreakFromTime((String) breakFromTime
						.get(i));
				appInvestigationSetup.setBreakToTime((String) breakToTime
						.get(i));
				if (!maxDays.get(i).equals("") && maxDays.get(i) != null) {
					appInvestigationSetup.setMaxNoOfDays(Integer
							.parseInt((String) maxDays.get(i)));
				} else if (maxDays.get(i).equals("") || maxDays.get(i) == null) {
					appInvestigationSetup.setMaxNoOfDays(0);
				}
				if (!minDays.get(i).equals("") && minDays.get(i) != null) {
					appInvestigationSetup.setMinNoOfDays(Integer
							.parseInt((String) minDays.get(i)));
				} else if (minDays.get(i).equals("") || minDays.get(i) == null) {
					appInvestigationSetup.setMinNoOfDays(0);
				}

				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(departmentId);
				appInvestigationSetup.setDepartment(masDepartment);

				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				appInvestigationSetup.setHospital(masHospital);

				appInvestigationSetup.setLastChgBy(userName);
				appInvestigationSetup.setLastChgDate(date);
				appInvestigationSetup.setLastChgTime(time);

				hbt.save(appInvestigationSetup);
				dataSaved = true;
			} catch (Exception e) {
				dataSaved = false;
				e.printStackTrace();
			}
			i++;
		}

		return dataSaved;
	}

	/**
	 * ------------------------ INVESTIGATION APPOINTMENT
	 * -------------------------- STARTTED ON 26 TH AUG 2008 AUTHOR: PRIYANKA
	 * GARG
	 */
	public Map<String, Object> showAppointmentInvestigationJsp() {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<AppEquipmentMaster> equipmentList = new ArrayList<AppEquipmentMaster>();
		List<OpdHoliday> holidayList = new ArrayList<OpdHoliday>();
		Integer dept[] = new Integer[3];
		dept[0] = 1;
		dept[1] = 4;
		dept[2] = 19;
		try {
			departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).createAlias(
					"DepartmentType", "dt").add(Restrictions.in("dt.Id", dept))
					.list();
			equipmentList = session.createCriteria(AppEquipmentMaster.class)
					.add(Restrictions.eq("EquipmentStatus", "y")).add(
							Restrictions.gt("NoOfEquipments", 0)).list();
			holidayList = session.createCriteria(OpdHoliday.class).add(
					Restrictions.eq("Status", "y")).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("departmentList", departmentList);
		map.put("equipmentList", equipmentList);
		map.put("holidayList", holidayList);

		return map;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showAppointmentInvestigationWise(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		// List<AppPatientAppointments> patientAppointmentList = new
		// ArrayList<AppPatientAppointments>();
		List<AppInvestigationSetup> appInvestigationSetupList = new ArrayList<AppInvestigationSetup>();
		List<AppInvestigationAppointments> patientAppointmentsList = new ArrayList<AppInvestigationAppointments>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<AppEquipmentMaster> equipmentList = new ArrayList<AppEquipmentMaster>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<AppInvestigationAppointments> slotAvailableList = new ArrayList<AppInvestigationAppointments>();
		List<Patient> registeredPatientList = new ArrayList<Patient>();
		List<AppInvestigationSetup> appInvestigationSetupDetailsList = new ArrayList<AppInvestigationSetup>();

		String slotList[][] = null;

		int departmentId = box.getInt(DEPARTMENT_ID);
		int equipmentId = box.getInt(EQUIPMENT_ID);
		int noOfEquipments = 0;
		int counter = 1;
		int noOfSlots = 0;
		int percentageForSlots = 0;

		Integer[] noOfEquipmentsList = new Integer[50];
		String queryString = null;
		String breakFromTime = "00:00:00";
		String breakToTime = "00:00:00";
		String days[] = new String[8];
		Time d_fromTime = Time.valueOf("00:00:00");
		Time d_toTime = Time.valueOf("00:00:00");
		Time d_slotDuration = Time.valueOf("00:00:00");
		Time d_breakFromTime = Time.valueOf("00:00:00");
		Time d_breakToTime = Time.valueOf("00:00:00");

		int totalAppointments = 0;
		int maxNoOfDays = 0;
		int minNoOfDays = 0;
		Date maxDate = new Date();
		Date minDate = new Date();
		Date sysDate = new Date();
		Date apmtDate = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c_appointmentDate = Calendar.getInstance();
		if (box.get(APPOINTMENT_DATE) != null
				&& !box.get(APPOINTMENT_DATE).equals("")) {
			c_appointmentDate
					.setTime(HMSUtil.convertStringTypeDateToDateType(box
							.get(APPOINTMENT_DATE)));
			apmtDate = HMSUtil.convertStringTypeDateToDateType(box
					.get(APPOINTMENT_DATE));
		}
		String formattedDate = sdf.format(c_appointmentDate.getTime());
		days[1] = "Sunday";
		days[2] = "Monday";
		days[3] = "Tuesday";
		days[4] = "Wednesday";
		days[5] = "Thursday";
		days[6] = "Friday";
		days[7] = "Saturday";

		Integer dept[] = new Integer[3];
		dept[0] = 1;
		dept[1] = 4;
		dept[2] = 19;

		queryString = "from AppInvestigationSetup where Department="
				+ departmentId + " and Equipment=" + equipmentId
				+ " and Days='"
				+ days[c_appointmentDate.get(Calendar.DAY_OF_WEEK)] + "'";
		try {
			departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).createAlias(
					"DepartmentType", "dt").add(Restrictions.in("dt.Id", dept))
					.list();
			equipmentList = session.createCriteria(AppEquipmentMaster.class)
					.add(Restrictions.eq("EquipmentStatus", "y")).add(
							Restrictions.gt("NoOfEquipments", 0)).list();
			employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).addOrder(
					Order.asc("FirstName")).list();
			appInvestigationSetupList = getHibernateTemplate()
					.find(queryString);
			patientAppointmentsList = getHibernateTemplate().find(
					"from AppInvestigationAppointments apmt where Department="
							+ box.getInt(DEPARTMENT_ID) + " and Equipment="
							+ box.getInt(EQUIPMENT_ID)
							+ " and InvestigationDate='" + formattedDate + "'");

			if (appInvestigationSetupList != null) {
				Iterator ite = appInvestigationSetupList.iterator();
				while (ite.hasNext()) {
					AppInvestigationSetup appInvestigationSetup = (AppInvestigationSetup) ite
							.next();
					if (appInvestigationSetup.getFromTime() != null
							&& !appInvestigationSetup.getFromTime().equals("")) {
						d_fromTime = Time.valueOf(appInvestigationSetup
								.getFromTime());
					} else {
						d_fromTime = Time.valueOf("00:00:00");
					}
					if (appInvestigationSetup.getToTime() != null
							&& !appInvestigationSetup.getToTime().equals("")) {
						d_toTime = Time.valueOf(appInvestigationSetup
								.getToTime());
					} else {
						d_toTime = Time.valueOf("00:00:00");
					}
					if (appInvestigationSetup.getSlotDuration() != null
							&& !appInvestigationSetup.getSlotDuration().equals(
									"")) {
						d_slotDuration = Time.valueOf(appInvestigationSetup
								.getSlotDuration());
					} else {
						d_slotDuration = Time.valueOf("00:00:00");
					}
					if (appInvestigationSetup.getBreakFromTime() != null
							&& !appInvestigationSetup.getBreakFromTime()
									.equals("")) {
						d_breakFromTime = Time.valueOf(appInvestigationSetup
								.getBreakFromTime());
					} else {
						d_breakFromTime = Time.valueOf("00:00:00");
					}
					if (appInvestigationSetup.getBreakToTime() != null
							&& !appInvestigationSetup.getBreakToTime().equals(
									"")) {
						d_breakToTime = Time.valueOf(appInvestigationSetup
								.getBreakToTime());
					} else {
						d_breakToTime = Time.valueOf("00:00:00");
					}

					if (appInvestigationSetup.getMaxNoOfDays() != null
							&& !(appInvestigationSetup.getMaxNoOfDays() == 0)) {
						maxNoOfDays = appInvestigationSetup.getMaxNoOfDays();
					} else {
						maxNoOfDays = 0;
					}
					if (appInvestigationSetup.getMinNoOfDays() != null
							&& !(appInvestigationSetup.getMinNoOfDays() == 0)) {
						minNoOfDays = appInvestigationSetup.getMinNoOfDays();
					} else {
						minNoOfDays = 0;
					}
					if (appInvestigationSetup.getPercentageForSlots() != null
							&& !(appInvestigationSetup.getPercentageForSlots() == 0)) {
						percentageForSlots = appInvestigationSetup
								.getPercentageForSlots();
					} else {
						percentageForSlots = 0;
					}
					if (appInvestigationSetup.getNoOfEquipments() != null
							&& !(appInvestigationSetup.getNoOfEquipments() == 0)) {
						noOfEquipments = appInvestigationSetup
								.getNoOfEquipments();
					} else {
						noOfEquipments = 0;
					}
					maxDate = new Date(c_appointmentDate.getTimeInMillis()
							- maxNoOfDays * 24 * 60 * 60 * 1000);
					minDate = new Date(c_appointmentDate.getTimeInMillis()
							- minNoOfDays * 24 * 60 * 60 * 1000);
					Date minParsedDate = null;
					Date sysParsedDate = null;
					DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					try {
						minParsedDate = (Date) format.parse(HMSUtil
								.convertDateToStringWithoutTime(minDate));
						sysParsedDate = (Date) format.parse(HMSUtil
								.convertDateToStringWithoutTime(sysDate));
					} catch (ParseException e1) {
						e1.printStackTrace();
					}

					/*
					 * //System.out.println("sysDate==== "+sysDate);
					 * //System.out.println("maxDate ==== "+maxDate);
					 * //System.out.println("min date==== "+minParsedDate);
					 * System.
					 * out.println("sysDate.compareTo(maxDate)=="+sysDate.
					 * compareTo(maxDate));
					 * //System.out.println("sysDate.compareTo(minDate)=="
					 * +sysDate.compareTo(minDate));
					 * //System.out.println("apmtDate.compareTo(sysDate)=="
					 * +apmtDate.compareTo(sysDate));
					 * //System.out.println("sysDate.equals(minDate)==="
					 * +sysParsedDate.equals(minParsedDate));
					 */
					if (sysDate.compareTo(maxDate) >= 0
							&& (sysDate.compareTo(minDate) < 0 || sysParsedDate
									.equals(minParsedDate))
							&& apmtDate.compareTo(sysDate) >= 0) {
						map = calculateSlots(d_fromTime, d_toTime,
								d_slotDuration, d_breakFromTime, d_breakToTime);
						slotList = (String[][]) map.get("slotList");
						counter = (Integer) map.get("counter");

						// **********************************************************
						// for counting no. of slots calculated done on 22 Aug
						// 2008.
						// calculation for restricting appointments according to
						// the percentage for slots
						// **********************************************************

						for (int i = 0; i < counter; i++) {
							if (slotList[i][1] != null)
								noOfSlots++;
						}
						if (percentageForSlots > 0) {
							totalAppointments = (noOfEquipments * noOfSlots)
									* percentageForSlots / 100;
						}
						int actualAvailableAppointments = totalAppointments
								- patientAppointmentsList.size();
						// **********************************************************

						if (actualAvailableAppointments > 0) {
							map.put("actualAvailableAppointments",
									actualAvailableAppointments);
							try {
								for (int i = 0; i < counter; i++) {
									/*
									 * String
									 * slotDuration=slotList[i][0]+" - "+slotList
									 * [i][1];
									 */

									slotAvailableList = session
											.createCriteria(
													AppInvestigationAppointments.class)
											.add(
													Restrictions.eq(
															"Department.Id",
															departmentId))
											.add(
													Restrictions
															.and(
																	Restrictions
																			.ge(
																					"FromTimeSlot",
																					slotList[i][0]),
																	Restrictions
																			.le(
																					"ToTimeSlot",
																					slotList[i][1])))
											.add(
													Restrictions
															.eq(
																	"InvestigationDate",
																	c_appointmentDate
																			.getTime()))
											.add(
													Restrictions.eq(
															"Equipment.Id",
															equipmentId))
											.add(
													Restrictions
															.ne(
																	"InvestigationStatus",
																	"c"))
											.list();

									/*
									 * slotAvailableList=getHibernateTemplate().find
									 * (
									 * "from AppInvestigationAppointments where FromTimeSlot>='"
									 * +
									 * slotList[i][0]+"' and ToTimeSlot<='"+slotList
									 * [i][1]+"' and Department="+departmentId+
									 * " and InvestigationDate='"
									 * +formattedDate+
									 * "' and Equipment="+equipmentId);
									 */
									int temp = noOfEquipments
											- slotAvailableList.size();
									noOfEquipmentsList[i] = temp;

								}
							} catch (DataAccessException e) {
								e.printStackTrace();
							}
						} else {
							String message = null;
							if (noOfSlots == 0) {
								message = "Appointment for this date is not available!!";
							} else {
								message = "Appointments are full!!";
							}
							map.put("message", message);
						}
						if (box.get("parent") != null
								&& !box.get("parent").equals("")) {
							registeredPatientList = showExistingPatientDetail(Integer
									.parseInt((String) box.get("parent")));
							map.put("registeredPatientList",
									registeredPatientList);
						}

					} else if (minNoOfDays == 0 || maxNoOfDays == 0) {
						map = calculateSlots(d_fromTime, d_toTime,
								d_slotDuration, d_breakFromTime, d_breakToTime);
						slotList = (String[][]) map.get("slotList");
						counter = (Integer) map.get("counter");

						// **********************************************************
						// for counting no. of slots calculated done on 22 Aug
						// 2008.
						// calculation for restricting appointments according to
						// the
						// percentage for slots
						// **********************************************************

						for (int i = 0; i < counter; i++) {
							if (slotList[i][1] != null)
								noOfSlots++;
						}
						if (percentageForSlots > 0) {
							totalAppointments = (noOfEquipments * noOfSlots)
									* percentageForSlots / 100;
						}
						int actualAvailableAppointments = totalAppointments
								- patientAppointmentsList.size();
						// **********************************************************

						if (actualAvailableAppointments > 0) {
							map.put("actualAvailableAppointments",
									actualAvailableAppointments);
							try {
								for (int i = 0; i < counter; i++) {
									/*
									 * String
									 * slotDuration=slotList[i][0]+" - "+slotList
									 * [i][1];
									 */

									slotAvailableList = session
											.createCriteria(
													AppInvestigationAppointments.class)
											.add(
													Restrictions.eq(
															"Department.Id",
															departmentId))
											.add(
													Restrictions
															.and(
																	Restrictions
																			.ge(
																					"FromTimeSlot",
																					slotList[i][0]),
																	Restrictions
																			.le(
																					"ToTimeSlot",
																					slotList[i][1])))
											.add(
													Restrictions
															.eq(
																	"InvestigationDate",
																	c_appointmentDate
																			.getTime()))
											// .add(Restrictions.eq("Equipment.Id",
											// equipmentId))
											.add(
													Restrictions
															.ne(
																	"InvestigationStatus",
																	"c"))
											.list();

									/*
									 * slotAvailableList=getHibernateTemplate().find
									 * (
									 * "from AppInvestigationAppointments where FromTimeSlot>='"
									 * +
									 * slotList[i][0]+"' and ToTimeSlot<='"+slotList
									 * [i][1]+"' and Department="+departmentId+
									 * " and InvestigationDate='"
									 * +formattedDate+"'");
									 */
									int temp = noOfEquipments
											- slotAvailableList.size();
									noOfEquipmentsList[i] = temp;

								}
							} catch (DataAccessException e) {
								e.printStackTrace();
							}
						}

						else {
							String message = null;
							if (noOfSlots == 0) {
								message = "Appointment for this date is not available!!";
							} else {
								message = "Appointments are full!!";
							}
							map.put("message", message);
						}
						if (box.get("parent") != null
								&& !box.get("parent").equals("")) {
							registeredPatientList = showExistingPatientDetail(Integer
									.parseInt((String) box.get("parent")));
							map.put("registeredPatientList",
									registeredPatientList);
						}

					} else {
						String message = "Wrong Appointment Date!!";
						map.put("message", message);
					}
				}

			}
			appInvestigationSetupDetailsList = session.createCriteria(
					AppInvestigationSetup.class).add(
					Restrictions.eq("Department.Id", departmentId)).add(
					Restrictions.eq("Equipment.Id", equipmentId)).add(
					Restrictions.ne("FromTime", "")).list();

		} catch (HibernateException e) {

			e.printStackTrace();
		}
		map.put("employeeList", employeeList);
		map.put("appInvestigationSetupList", appInvestigationSetupDetailsList);
		map.put("noOfEquipmentsList", noOfEquipmentsList);
		map.put("departmentList", departmentList);
		map.put("equipmentList", equipmentList);
		map.put("apmtDate", apmtDate);
		// map.put("patientAppointmentsList", patientAppointmentsList);

		return map;

	}

	public Map<String, Object> checkForHinNoInvApmt(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<AppInvestigationAppointments> hinList = new ArrayList<AppInvestigationAppointments>();
		Date apmtDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString(APMT_DATE));
		boolean patientNameExist = false;
		Criteria criteria = null;
		try {
			criteria = session.createCriteria(
					AppInvestigationAppointments.class).add(
					Restrictions.eq("InvestigationStatus", "y")).add(
					Restrictions.eq("InvestigationDate", apmtDate))
					.createAlias("Department", "md").add(
							Restrictions.eq("md.Id", box.getInt(WARD_ID)))
					.createAlias("Equipment", "equip").add(
							Restrictions.eq("equip.Id", box.getInt(EQUIP_ID)));

			if (!box.getString(HIN_ID).equals("")) {
				criteria = criteria.createAlias("Hin", "pt").add(
						Restrictions.eq("pt.Id", Integer.parseInt(box
								.getString(HIN_ID))));
			}
			if (!box.getString(PATIENT_NAME).equals("")) {
				criteria = criteria.add(Restrictions.eq("PatientName", box
						.getString(PATIENT_NAME)));
			}
			if (!box.getString(AGE).equals("")) {
				criteria = criteria.add(Restrictions.eq("Age", box
						.getString(AGE)
						+ " " + box.getString(AGEUNIT)));
			}
			if (!box.getString(MOBILE_NO).equals("")) {
				criteria = criteria.add(Restrictions.eq("MobileNo", box
						.getString(MOBILE_NO)));
			}
			if (!box.getString(SEX).equals("")) {
				criteria = criteria.add(Restrictions.eq("Sex", box
						.getString(SEX)));
			}
			hinList = criteria.list();

			if (box.getString(HIN_ID).equals("")
					&& !box.getString(PATIENT_NAME).equals("")
					&& hinList.size() > 0) {
				patientNameExist = true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("hinList", hinList);
		map.put("patientNameExist", patientNameExist);
		return map;
	}

	public Map<String, Object> checkForInvApmtInDiffDept(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<AppInvestigationAppointments> hinList = new ArrayList<AppInvestigationAppointments>();
		Date apmtDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString(APMT_DATE));
		boolean recordExists = false;
		Criteria criteria = null;
		try {
			criteria = session.createCriteria(
					AppInvestigationAppointments.class).add(
					Restrictions.eq("InvestigationStatus", "y")).add(
					Restrictions.eq("InvestigationDate", apmtDate))
					.createAlias("Equipment", "equip").add(
							Restrictions.eq("equip.Id", box.getInt(EQUIP_ID)));

			if (!box.getString(HIN_ID).equals("")) {
				criteria = criteria.createAlias("Hin", "pt").add(
						Restrictions.eq("pt.Id", Integer.parseInt(box
								.getString(HIN_ID))));
			}
			if (!box.getString(PATIENT_NAME).equals("")) {
				criteria = criteria.add(Restrictions.eq("PatientName", box
						.getString(PATIENT_NAME)));
			}
			if (!box.getString(AGE).equals("")) {
				criteria = criteria.add(Restrictions.eq("Age", box
						.getString(AGE)
						+ " " + box.getString(AGE_UNIT)));
			}
			if (!box.getString(MOBILE_NO).equals("")) {
				criteria = criteria.add(Restrictions.eq("MobileNo", box
						.getString(MOBILE_NO)));
			}
			if (!box.getString(SEX).equals("")) {
				criteria = criteria.add(Restrictions.eq("Sex", box
						.getString(SEX)));
			}

			hinList = criteria.list();
			if (hinList != null && hinList.size() > 0) {

				Iterator ite = hinList.iterator();
				while (ite.hasNext()) {
					AppInvestigationAppointments appInvestigationAppointments = (AppInvestigationAppointments) ite
							.next();
					if (!appInvestigationAppointments.getDepartment().getId()
							.equals(box.getInt(WARD_ID))) {
						recordExists = true;
						map.put("existingDept", appInvestigationAppointments
								.getDepartment().getDepartmentName());
						map.put("existingStartTime",
								appInvestigationAppointments.getFromTimeSlot());
						map.put("existingEndTime", appInvestigationAppointments
								.getToTimeSlot());
					}

				}

			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("recordExists", recordExists);
		map.put("hinList", hinList);
		return map;
	}

	public Map<String, Object> submitInvestigationAppointment(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<AppEquipmentMaster> equipmentList = new ArrayList<AppEquipmentMaster>();
		List<AppInvestigationAppointments> hinList = new ArrayList<AppInvestigationAppointments>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();

		Session session = (Session) getSession();
		boolean dataSaved = false;
		boolean duplicateRecord = false;
		String appointmentNo = null;
		Integer dept[] = new Integer[3];
		dept[0] = 1;
		dept[1] = 4;
		dept[2] = 19;

		String fromTimeSlot = box.getString(FROMTIMESLOT);
		String toTimeSlot = box.getString(TOTIMESLOT);
		int departmentId = box.getInt(WARD_ID);
		int equipmentId = box.getInt(EQUIP_ID);
		Date appointmentDate = HMSUtil.convertStringTypeDateToDateType(box
				.get(APMT_DATE));
		String serviceNo = box.getString(SERVICE_NO);
		String servicePerson = box.getString("servicePerson");
		int hinId = box.getInt(HIN_ID);
		String patientName = box.getString(PATIENT_NAME);
		String patientType = box.getString(PATIENT_TYPE);
		String mobileNo = box.getString(MOBILE_NO);

		String sex = box.getString(SEX);
		String age = box.getString(AGE);
		String ageUnit = box.getString(AGEUNIT);
		int doctorId = box.getInt(EMPLOYEE_ID);

		int hospitalId = box.getInt("hospitalId");
		String userName = box.getString("userName");

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		boolean patientNameExist = false;
		boolean recordExists = false;

		map = checkForInvApmtInDiffDept(box);
		String existingDept = (String) map.get("existingDept");
		String existingStartTime = (String) map.get("existingStartTime");
		String existingEndTime = (String) map.get("existingEndTime");
		if (map.get("recordExists") != null)
			recordExists = (Boolean) map.get("recordExists");
		map = checkForHinNoInvApmt(box);
		if (hinList != null)
			hinList = (List) map.get("hinList");

		patientNameExist = (Boolean) map.get("patientNameExist");

		departmentList = session.createCriteria(MasDepartment.class).add(
				Restrictions.eq("Status", "y")).createAlias("DepartmentType",
				"dt").add(Restrictions.in("dt.Id", dept)).list();

		equipmentList = session.createCriteria(AppEquipmentMaster.class).add(
				Restrictions.eq("EquipmentStatus", "y")).add(
				Restrictions.gt("NoOfEquipments", 0)).list();

		if (patientType.equalsIgnoreCase("In Patient")) {
			inpatientList = session.createCriteria(Inpatient.class)
			// .createAlias("Hin", "pt")
					.add(Restrictions.eq("Hin.Id", hinId)).add(
							Restrictions.eq("AdStatus", "A")).list();
		}

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			int i = 0;
			AppInvestigationAppointments appInvestigationAppointments = new AppInvestigationAppointments();
			appInvestigationAppointments.setFromTimeSlot((String) fromTimeSlot);
			appInvestigationAppointments.setToTimeSlot((String) toTimeSlot);

			appInvestigationAppointments.setInvestigationDate(appointmentDate);

			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			appInvestigationAppointments.setDepartment(masDepartment);

			AppEquipmentMaster appEquipmentMaster = new AppEquipmentMaster();
			appEquipmentMaster.setId(equipmentId);
			appInvestigationAppointments.setEquipment(appEquipmentMaster);

			Patient patient = new Patient();
			if (hinId != 0) {
				patient.setId(hinId);
				appInvestigationAppointments.setHin(patient);
				appInvestigationAppointments.setRegisteredStatus("y");
				appInvestigationAppointments.setAge(age);

			} else {
				appInvestigationAppointments.setRegisteredStatus("n");
				if (ageUnit != null) {
					appInvestigationAppointments.setAge((String) age + " "
							+ (String) ageUnit);
				} else {
					appInvestigationAppointments.setAge((String) age);
				}
			}
			if (serviceNo != null && !serviceNo.equals("")) {
				appInvestigationAppointments.setServiceNo((String) serviceNo);
			}
			if (servicePerson != null && !servicePerson.equals("")) {
				appInvestigationAppointments
						.setServicePersonName((String) servicePerson);
			}
			appInvestigationAppointments.setInvestigationStatus("y");

			if (doctorId != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(doctorId);
				appInvestigationAppointments.setEmployee(masEmployee);
			}
			if (inpatientList.size() > 0) {
				Inpatient inpatient = inpatientList.get(0);
				appInvestigationAppointments.setInpatient(inpatient);
			}
			appInvestigationAppointments.setPatientName((String) patientName);
			appInvestigationAppointments.setMobileNo(mobileNo);
			appInvestigationAppointments.setSex((String) sex);

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			appInvestigationAppointments.setHospital(masHospital);

			appInvestigationAppointments.setLastChgBy(userName);
			appInvestigationAppointments.setLastChgDate(date);
			appInvestigationAppointments.setLastChgTime(time);

			if (hinList != null) {
				if (hinList.size() == 0 && recordExists == false
						&& patientNameExist == false) {

					hbt.save(appInvestigationAppointments);
					int appointmentId = appInvestigationAppointments.getId();
					appointmentNo = generateAppointmentNo(appointmentDate,
							departmentId, appointmentId, "IV");
					appInvestigationAppointments = (AppInvestigationAppointments) hbt
							.load(AppInvestigationAppointments.class,
									appointmentId);

					appInvestigationAppointments
							.setInvestigationAppointmentNo(appointmentNo);
					hbt.saveOrUpdate(appInvestigationAppointments);

					dataSaved = true;
					duplicateRecord = false;
					map.put("appointmentNo", appointmentNo);

				} else if (hinList.size() > 0 && patientNameExist == false
						&& recordExists == false) {
					map
							.put(
									"message",
									patientName
											+ " already taken Appointment for this Department!!");
					dataSaved = false;
					duplicateRecord = true;
				} else if (recordExists == true) {
					map.put("existingDept", existingDept);
					map.put("existingStartTime", existingStartTime);
					map.put("existingEndTime", existingEndTime);
				}

			}
			// //System.out.println("hinlist=="+hinList.size());
			map.put("recordExists", recordExists);
			map.put("patientNameExist", patientNameExist);

			map.put("dataSaved", dataSaved);

			map.put("patientName", patientName);
			map.put("duplicateRecord", duplicateRecord);

			map.put("age", age);
			map.put("sex", sex);

		} catch (Exception e) {
			dataSaved = false;
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> submitDulicatePatientNameInvAppointment(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();
		boolean dataSaved = false;
		String appointmentNo = null;

		String fromTimeSlot = box.getString("returnStartTime");
		String toTimeSlot = box.getString("returnEndTime");
		int departmentId = box.getInt("returnDeptId");
		int equipId = box.getInt("returnEquipId");
		Date appointmentDate = HMSUtil.convertStringTypeDateToDateType(box
				.get("returnAppointmentDate"));
		String patientName = box.getString("returnPatientName");
		String sex = box.getString("returnSex");
		String age = box.getString("returnAge");
		String ageUnit = box.getString("returnAgeUnit");
		String serviceNo = box.getString("returnServiceNo");
		String servicePerson = box.getString("returnServicePerson");
		int hinId = box.getInt("returnHinId");
		String mobileNo = box.getString("returnMobileNo");
		int doctorId = box.getInt("returnDoctorId");
		int hospitalId = box.getInt("hospitalId");
		String userName = box.getString("userName");
		Integer dept[] = new Integer[3];
		dept[0] = 1;
		dept[1] = 4;
		dept[2] = 19;

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		departmentList = session.createCriteria(MasDepartment.class).add(
				Restrictions.eq("Status", "y")).createAlias("DepartmentType",
				"dt").add(Restrictions.in("dt.Id", dept)).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			AppInvestigationAppointments appInvestigationAppointments = new AppInvestigationAppointments();
			appInvestigationAppointments.setFromTimeSlot((String) fromTimeSlot);
			appInvestigationAppointments.setToTimeSlot((String) toTimeSlot);

			appInvestigationAppointments.setInvestigationDate(appointmentDate);

			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			appInvestigationAppointments.setDepartment(masDepartment);

			AppEquipmentMaster appEquipmentMaster = new AppEquipmentMaster();
			appEquipmentMaster.setId(equipId);
			appInvestigationAppointments.setEquipment(appEquipmentMaster);

			Patient patient = new Patient();
			if (hinId != 0) {
				patient.setId(hinId);
				appInvestigationAppointments.setHin(patient);
				appInvestigationAppointments.setRegisteredStatus("y");
				appInvestigationAppointments.setAge(age);

			} else {
				appInvestigationAppointments.setRegisteredStatus("n");
				if (ageUnit != null) {
					appInvestigationAppointments.setAge((String) age + " "
							+ (String) ageUnit);
				} else {
					appInvestigationAppointments.setAge((String) age);
				}
			}
			if (serviceNo != null && !serviceNo.equals("")) {
				appInvestigationAppointments.setServiceNo((String) serviceNo);
			}
			if (servicePerson != null && !servicePerson.equals("")) {
				appInvestigationAppointments
						.setServicePersonName((String) servicePerson);
			}
			appInvestigationAppointments.setInvestigationStatus("y");
			if (doctorId != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(doctorId);
				appInvestigationAppointments.setEmployee(masEmployee);
			}

			appInvestigationAppointments.setPatientName((String) patientName);
			appInvestigationAppointments.setMobileNo(mobileNo);
			appInvestigationAppointments.setSex((String) sex);

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			appInvestigationAppointments.setHospital(masHospital);

			appInvestigationAppointments.setLastChgBy(userName);
			appInvestigationAppointments.setLastChgDate(date);
			appInvestigationAppointments.setLastChgTime(time);
			hbt.save(appInvestigationAppointments);

			hbt.save(appInvestigationAppointments);
			int appointmentId = appInvestigationAppointments.getId();
			appointmentNo = generateAppointmentNo(appointmentDate,
					departmentId, appointmentId, "IV");
			appInvestigationAppointments = (AppInvestigationAppointments) hbt
					.load(AppInvestigationAppointments.class, appointmentId);

			appInvestigationAppointments
					.setInvestigationAppointmentNo(appointmentNo);
			hbt.saveOrUpdate(appInvestigationAppointments);

			dataSaved = true;
			map.put("appointmentNo", appointmentNo);
			map.put("dataSaved", dataSaved);
			map.put("departmentList", departmentList);

		} catch (Exception e) {
			dataSaved = false;
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * ------------------------ CANCELLATION FOR PATIENT APPOINTMENTS
	 * ----------------------- STARTED ON 1ST SEPT 2008 AUTHOR: PRIYANKA GARG
	 */
	public Map<String, Object> showAppointmentPatientCancellationJsp() {
		Session session = (Session) getSession();
		List<String> departmentTypeCode = new ArrayList<String>();
		departmentTypeCode.add("CR");
		departmentTypeCode.add("OPD1");
		departmentTypeCode.add("SpltOPD");
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		try {
			departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).createAlias(
					"DepartmentType", "dt").add(
					Restrictions
							.in("dt.DepartmentTypeCode", departmentTypeCode))
					.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("departmentList", departmentList);
		return map;
	}

	public Map<String, Object> patientAppointmentList(Box box) {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<AppPatientAppointments> patientList = new ArrayList<AppPatientAppointments>();

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");

		String serviceNo = box.getString(SERVICE_NO);
		String hinNo = box.getString(HIN_NO);
		String patientName = box.getString(PATIENT_NAME);
		String age = box.getString(AGE);
		String appointmentNo = box.getString(APPOINTMENT_NO);
		String appointmentDate = box.get(APPOINTMENT_DATE);
		int departmentId = box.getInt(DEPARTMENT_ID);

		Criteria criteria = null;
		criteria = session.createCriteria(AppPatientAppointments.class).add(
				Restrictions.eq("AppointmentStatus", "y"));

		try {
			if (!serviceNo.equals("")) {
				criteria = criteria
						.add(Restrictions.eq("ServiceNo", serviceNo));
			}
			if (!hinNo.equals("")) {
				criteria = criteria.createAlias("Hin", "pt").add(
						Restrictions.eq("pt.HinNo", hinNo));
			}
			if (!patientName.equals("")) {
				criteria = criteria.add(Restrictions.like("PatientName", "%"
						+ patientName + "%"));
			}
			if (!age.equals("")) {
				criteria = criteria.add(Restrictions.eq("Age", age));
			}
			if (departmentId != 0) {
				criteria = criteria.add(Restrictions.eq("Department.Id",
						departmentId));
			}
			if (!appointmentNo.equals("")) {
				criteria = criteria.add(Restrictions.eq("AppointmentNo",
						appointmentNo));
			}
			if (!appointmentDate.equals("")) {
				criteria = criteria
						.add(Restrictions
								.eq(
										"AppointmentDate",
										HMSUtil
												.convertStringTypeDateToDateType(appointmentDate)));
			} else {
				criteria = criteria.add(Restrictions.ge("AppointmentDate",
						HMSUtil.convertStringTypeDateToDateType(currentDate)));
			}

			patientList = criteria.list();
			List<String> departmentTypeCode = new ArrayList<String>();
			departmentTypeCode.add("CR");
			departmentTypeCode.add("OPD1");
			departmentTypeCode.add("SpltOPD");
			departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).createAlias(
					"DepartmentType", "dt").add(
					Restrictions
							.in("dt.DepartmentTypeCode", departmentTypeCode))
					.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		if (patientList.size() <= 0) {
			map.put("message", "No Record Found !!");
		}
		map.put("patientList", patientList);
		map.put("departmentList", departmentList);

		return map;

	}

	public boolean submitCancelPatientAppointment(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();
		boolean dataSaved = false;

		Vector appointmentId = box.getVector(APPOINTMENT_ID);
		int hospitalId = box.getInt("hospitalId");
		String userName = box.getString("userName");

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		departmentList = session.createCriteria(MasDepartment.class).add(
				Restrictions.eq("Status", "y")).createAlias("DepartmentType",
				"dt").add(Restrictions.eq("dt.Id", 1)).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		for (int i = 0; i < appointmentId.size(); i++) {
			try {
				AppPatientAppointments appPatientAppointments = new AppPatientAppointments();

				if (!appointmentId.get(i).equals("")
						&& appointmentId.get(i) != null) {
					appPatientAppointments = (AppPatientAppointments) hbt.load(
							AppPatientAppointments.class, Integer
									.parseInt((String) appointmentId.get(i)));
					appPatientAppointments.setAppointmentStatus("c");
					appPatientAppointments.setAppointmentCancelDate(date);

				}

				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				appPatientAppointments.setHospital(masHospital);

				appPatientAppointments.setLastChgBy(userName);
				appPatientAppointments.setLastChgDate(date);
				appPatientAppointments.setLastChgTime(time);

				hbt.saveOrUpdate(appPatientAppointments);
				dataSaved = true;
			} catch (Exception e) {
				dataSaved = false;
				e.printStackTrace();
			}
		}

		return dataSaved;
	}

	/**
	 * --------------------------- CANCELLATION FOR APPOINTMENT INVESTIGATION
	 * -------------------- STARTED ON 4 TH SEPT 2008 AUTHOR: PRIYANKA GARG
	 */

	public Map<String, Object> showAppointmentInvestigationCancellationJsp() {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<AppEquipmentMaster> equipmentList = new ArrayList<AppEquipmentMaster>();
		Integer dept[] = new Integer[3];
		dept[0] = 1;
		dept[1] = 4;
		dept[2] = 19;
		try {
			departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).createAlias(
					"DepartmentType", "dt").add(Restrictions.in("dt.Id", dept))
					.list();

			equipmentList = session.createCriteria(AppEquipmentMaster.class)
					.add(Restrictions.eq("EquipmentStatus", "y")).add(
							Restrictions.gt("NoOfEquipments", 0)).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("departmentList", departmentList);
		map.put("equipmentList", equipmentList);

		return map;

	}

	public Map<String, Object> investigationAppointmentList(Box box) {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<AppEquipmentMaster> equipmentList = new ArrayList<AppEquipmentMaster>();
		List<AppInvestigationAppointments> patientList = new ArrayList<AppInvestigationAppointments>();

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");

		String serviceNo = box.getString(SERVICE_NO);
		String hinNo = box.getString(HIN_NO);
		String patientName = box.getString(PATIENT_NAME);
		String age = box.getString(AGE);
		String appointmentNo = box.getString(APPOINTMENT_NO);
		String appointmentDate = box.get(APPOINTMENT_DATE);
		int departmentId = box.getInt(DEPARTMENT_ID);
		Integer dept[] = new Integer[3];
		dept[0] = 1;
		dept[1] = 4;
		dept[2] = 19;

		Criteria criteria = null;

		try {
			departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).createAlias(
					"DepartmentType", "dt").add(Restrictions.in("dt.Id", dept))
					.list();

			equipmentList = session.createCriteria(AppEquipmentMaster.class)
					.add(Restrictions.eq("EquipmentStatus", "y")).add(
							Restrictions.gt("NoOfEquipments", 0)).list();

			criteria = session.createCriteria(
					AppInvestigationAppointments.class).add(
					Restrictions.eq("InvestigationStatus", "y"));
			if (!serviceNo.equals("")) {
				criteria = criteria
						.add(Restrictions.eq("ServiceNo", serviceNo));
			}
			if (!hinNo.equals("")) {
				criteria = criteria.createAlias("Patient", "pt").add(
						Restrictions.eq("pt.HinNo", hinNo));
			}
			if (!patientName.equals("")) {
				criteria = criteria.add(Restrictions.like("PatientName", "%"
						+ patientName + "%"));
			}
			if (!age.equals("")) {
				criteria = criteria.add(Restrictions.eq("Age", age));
			}
			if (!appointmentNo.equals("")) {
				criteria = criteria.add(Restrictions.eq("InvestigationNo",
						appointmentNo));
			}
			if (!appointmentDate.equals("")) {
				criteria = criteria
						.add(Restrictions
								.eq(
										"InvestigationDate",
										HMSUtil
												.convertStringTypeDateToDateType(appointmentDate)));
			} else {
				criteria = criteria.add(Restrictions.ge("InvestigationDate",
						HMSUtil.convertStringTypeDateToDateType(currentDate)));
			}

			patientList = criteria.list();
			departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).createAlias(
					"DepartmentType", "dt").add(Restrictions.in("dt.Id", dept))
					.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		if (patientList.size() <= 0) {
			map.put("message", "No Record Found !!");
		}
		map.put("patientList", patientList);
		map.put("departmentList", departmentList);
		map.put("equipmentList", equipmentList);

		return map;

	}

	public boolean submitCancelInvestigationAppointment(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();
		boolean dataSaved = false;
		Integer dept[] = new Integer[3];
		dept[0] = 1;
		dept[1] = 4;
		dept[2] = 19;

		Vector appointmentId = box.getVector(APPOINTMENT_ID);
		int hospitalId = box.getInt("hospitalId");
		String userName = box.getString("userName");

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		departmentList = session.createCriteria(MasDepartment.class).add(
				Restrictions.eq("Status", "y")).createAlias("DepartmentType",
				"dt").add(Restrictions.in("dt.Id", dept)).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		for (int i = 0; i < appointmentId.size(); i++) {
			try {
				AppInvestigationAppointments appInvestigationAppointments = new AppInvestigationAppointments();

				if (!appointmentId.get(i).equals("")
						&& appointmentId.get(i) != null) {
					appInvestigationAppointments = (AppInvestigationAppointments) hbt
							.load(AppInvestigationAppointments.class, Integer
									.parseInt((String) appointmentId.get(i)));
					appInvestigationAppointments.setInvestigationStatus("c");
					appInvestigationAppointments
							.setInvestigationCancelDate(date);

				}

				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				appInvestigationAppointments.setHospital(masHospital);

				appInvestigationAppointments.setLastChgBy(userName);
				appInvestigationAppointments.setLastChgDate(date);
				appInvestigationAppointments.setLastChgTime(time);

				hbt.saveOrUpdate(appInvestigationAppointments);
				dataSaved = true;
			} catch (Exception e) {
				dataSaved = false;
				e.printStackTrace();
			}
		}

		return dataSaved;
	}

	// ***************************For Report by
	// Vishal****************************************
	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> connectionMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		connectionMap.put("con", con);
		return connectionMap;
	}

	@SuppressWarnings("unchecked")
	// ---------------------for Appointment List---------------------------
	public Map<String, Object> getEmployeeDepartmentCategory() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<String> departmentTypeCode = new ArrayList<String>();
		departmentTypeCode.add("CR");
		departmentTypeCode.add("OPD1");
		departmentTypeCode.add("SpltOPD");
		try {
			String departmentTypeName = "Consultation Room";
			departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).createAlias(
					"DepartmentType", "deptType").add(
					Restrictions.in("deptType.DepartmentTypeCode",
							departmentTypeCode)).list();
			employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("departmentList", departmentList);
		map.put("employeeList", employeeList);
		return map;
	}

	// ---------------------for Investigation List---------------------------

	public Map<String, Object> getEquipmentDepartmentCategory() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<AppEquipmentMaster> equipmentList = new ArrayList<AppEquipmentMaster>();
		List<MasDepartment> wardList = new ArrayList<MasDepartment>();

		Integer dept[] = new Integer[3];
		dept[0] = 1;
		dept[1] = 4;
		dept[2] = 19;
		try {
			String departmentTypeName = "Consultation Room";
			departmentList = session.createCriteria(MasDepartment.class)
					.createAlias("DepartmentType", "deptType").add(
							Restrictions.eq("Status", "y")).add(
							Restrictions.in("deptType.Id", dept)).list();
			wardList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).createAlias(
					"DepartmentType", "dt").add(
					Restrictions.eq("dt.DepartmentTypeName", "Ward")).list();

			equipmentList = session.createCriteria(AppEquipmentMaster.class)
					.add(Restrictions.eq("EquipmentStatus", "y")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("departmentList", departmentList);
		map.put("wardList", wardList);
		map.put("equipmentList", equipmentList);
		//System.out.println("equipmentList" + equipmentList.size());

		return map;
	}

	public Map<String, Object> submitUploadDocuments(Box box) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Object> viewUploadDocuments(Box box) {
		// TODO Auto-generated method stub
		return null;
	}

	// ------Appointment Block by Dipali
	public Map<String, Object> showAppBlockJsp() {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<AppBlock> searchAppBlockList = new ArrayList<AppBlock>();

		List<String> departmentTypeCode = new ArrayList<String>();
		departmentTypeCode.add("CR");
		departmentTypeCode.add("OPD1");
		departmentTypeCode.add("SpltOPD");

		try {
			departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).createAlias(
					"DepartmentType", "dt").add(
					Restrictions
							.in("dt.DepartmentTypeCode", departmentTypeCode))
					.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		searchAppBlockList = session.createCriteria(AppBlock.class).list();
		map.put("departmentList", departmentList);
		map.put("searchAppBlockList", searchAppBlockList);

		return map;

	}

	public boolean submitAppointmentBlock(AppBlock appBlock) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(appBlock);
		hbt.refresh(appBlock);
		successfullyAdded = true;
		return successfullyAdded;
	}
	
	public boolean updateAppointmentBlock(AppBlock appBlock) {
		boolean successfullyUpdated = false;
	try{	
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(appBlock);
		hbt.refresh(appBlock);
		successfullyUpdated = true;
		}catch(Exception ee){
			ee.printStackTrace();
		}
		return successfullyUpdated;
	}

	public boolean deleteAppointmentBlock(AppBlock appBlock) {
		boolean successfullyDeleted = false;
	try{	
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.delete(appBlock);
		successfullyDeleted = true;
		}catch(Exception ee){
			ee.printStackTrace();
		}
		return successfullyDeleted;
	}
	
	public Map<String, Object> getBlockAppointment() {
		return null;
		/*
		 * Session session = (Session) getSession();
		 * 
		 * Map<String, Object> map = new HashMap<String, Object>();
		 * List<AppBlock> appBlockList=new ArrayList<AppBlock>(); try {
		 * appBlockList = session.createCriteria(AppBlock.class)
		 * .add(Restrictions.eq("Status", "y")) .createAlias("DepartmentType",
		 * "dt") .add(Restrictions.in("dt.DepartmentTypeCode",
		 * departmentTypeCode)) . list(); } catch (HibernateException e) {
		 * e.printStackTrace(); }
		 */
	}

	/**
	 * --------------------------- END OF CLASS
	 * ---------------------------------
	 */

	public List getPatientAppointments(String departmentId,
			String blockDateFrom, String blockDateTo) {
		Session session = (Session) getSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String fromDate = sdf.format(HMSUtil
				.convertStringTypeDateToDateType(blockDateFrom));
		String toDate = sdf.format(HMSUtil
				.convertStringTypeDateToDateType(blockDateTo));
		String queryString = "from AppPatientAppointments where Department.Id="
				+ departmentId + " and AppointmentDate between '" + fromDate
				+ "' and '" + toDate + "'  " + " and AppointmentStatus <> 'c'";

		List appointmentList = getHibernateTemplate().find(queryString);

		return appointmentList;
	}

	public boolean cancelAppointmentBlock(List appointments) {
		Iterator appIt = appointments.iterator();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			while (appIt.hasNext()) {
				AppPatientAppointments appointment = (AppPatientAppointments) appIt
						.next();
				//System.out.println("inside while:" + appointment.getId());

				appointment.setAppointmentStatus("c");
				appointment.setBlocked("y");
				hbt.saveOrUpdate(appointment);
			}
		} catch (Exception ee) {
			ee.printStackTrace();
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getLoginDoctorDetailsByDepartment(Map<String, Object> mapForDs) {
		Session session = (Session) getSession();
		Box box = (Box)mapForDs.get("box");
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		List<MasSession> sessionList = new ArrayList<MasSession>();
		List<MasEmployeeDepartment> empDeptList = new ArrayList<MasEmployeeDepartment>();
		//List empList= new ArrayList();
		int hospitalId = box.getInt("hospitalId");
		
		//String empCategoryCodeForDoctor = "";
	/*	Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
			empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
     
		int departmentId = box.getInt(DEPARTMENT_ID);
	int docId = box.getInt("docId");
		try {
	String empCategoryCodeForDoctor = HMSUtil.getProperties("adt.properties", "empCategoryCodeForDoctor");
			empDeptList=session.createCriteria(MasEmployeeDepartment.class)
					.createAlias("Department", "dept")
					.add(Restrictions.eq("dept.Id",departmentId))
					.createAlias("Employee", "emp")
					.add(Restrictions.eq("emp.Id",docId))
						.createAlias("emp.EmpCategory", "cat")
					.add(Restrictions.eq("cat.EmpCategoryCode",empCategoryCodeForDoctor))
					.add(Restrictions.eq("Status","y").ignoreCase())
					.list();
			
			/*for(MasEmployeeDepartment empDept :empDeptList)
			{ 
				empList.add(empDept.getEmployee().getId());
			}*/
			if(empDeptList.size() >0)
			{
				for(MasEmployeeDepartment me:empDeptList){
					doctorList.add(me.getEmployee());
				}
				
		/*	   doctorList = session.createCriteria(MasEmployee.class)
					 .add(Restrictions.eq("Status","y").ignoreCase())  
					 .add(Restrictions.eq("Hospital.Id",hospitalId))
					.createAlias("EmpCategory", "ec")					
					.add(Restrictions.eq("ec.EmpCategoryCode", empCategoryCodeForDoctor))
					.add(Restrictions.in("Id", empList))
					.list();*/
			
			   sessionList = session.createCriteria(MasSession.class)
					   .add(Restrictions.eq("Hospital.Id",hospitalId))
					   .add(Restrictions.eq("Status","y").ignoreCase()).list();
			   
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("doctorList", doctorList);
		map.put("sessionList", sessionList);
		return map;
	}

}
