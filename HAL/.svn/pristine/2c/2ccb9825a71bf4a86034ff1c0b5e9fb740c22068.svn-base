package jkt.hms.hr.dataservice;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.Vector;

import jkt.hms.masters.business.HrClassMaster;
import jkt.hms.masters.business.HrDailyRoutineDutyEntry;
import jkt.hms.masters.business.HrDutyEntry;
import jkt.hms.masters.business.HrDutyExemptionEntry;
import jkt.hms.masters.business.HrDutyMaster;
import jkt.hms.masters.business.HrDutyTimeMaster;
import jkt.hms.masters.business.HrGuardDutyEntry;
import jkt.hms.masters.business.HrLeaveMaintenance;
import jkt.hms.masters.business.HrLeaveTypeMaster;
import jkt.hms.masters.business.HrOrderlyDutyEntry;
import jkt.hms.masters.business.HrRangeFiringDutyEntry;
import jkt.hms.masters.business.HrSpecialistMaster;
import jkt.hms.masters.business.HrUpdateArrival;
import jkt.hms.masters.business.HrWardDutyEntry;
import jkt.hms.masters.business.HrorderlyClassificationMaster;
import jkt.hms.masters.business.HrorderlyGuardDutyEntry;
import jkt.hms.masters.business.HrorderlyLeaveApplication;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDepartmentType;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasTrade;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.OpdHoliday;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.PagedArray;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class HrRelatedDataServiceImpl extends HibernateDaoSupport implements HrRelatedDataService {

public Map<String, Object> showLeaveMaintenanceSearchJsp() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		Session session = (Session) getSession();
		try {
			rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		map.put("rankList", rankList);
		return map;
	}
	
public Map<String, Object> searchEmployeeForLeaveMaintenance(Map<String, Object> map) {
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<MasRank> rankList = new ArrayList<MasRank>();
	String serviceNo = "";
	int rankId = 0;
	String firstName = "";
	String lastName = "";
	
	Session session = (Session)getSession();
	
	rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).list();
	
	if(map.get("serviceNo") != null){
		serviceNo = (String)map.get("serviceNo");
	}
	if(map.get("rankId") != null){
		rankId = (Integer)map.get("rankId");
	}
	if(map.get("firstName") != null){
		firstName = (String)map.get("firstName");
	}
	if(map.get("lastName") != null){
		lastName = (String)map.get("lastName");
	}

	try {
		Criteria crit = session.createCriteria(MasEmployee.class);
		
			if(!serviceNo.equals("") ){
				crit = crit.add(Restrictions.like("ServiceNo", serviceNo+"%"));
			}
			if(!firstName.equals("")){
				crit = crit.add(Restrictions.like("FirstName", firstName+"%"));
			}
			if(!lastName.equals("")){
				crit = crit.add(Restrictions.like("LastName", lastName+"%"));
			}
			if(rankId != 0 ){
				crit = crit.createAlias("Rank", "rank").add(Restrictions.eq("rank.Id", rankId));
			}
		
			employeeList = crit.list();
	 }catch (Exception e) {
		e.printStackTrace();
	}
	map.put("employeeList", employeeList);
	map.put("rankList", rankList);
	return map;
}

public Map<String, Object> showLeaveMaintenanceEntryJsp(int empId) {
	Map<String, Object> map = new HashMap<String, Object>();
	Session session=(Session) getSession();
	List<HrLeaveMaintenance> leaveMaintenanceList=new ArrayList<HrLeaveMaintenance>();
	List<HrLeaveTypeMaster>leaveTypeList=new ArrayList<HrLeaveTypeMaster>();
	List<MasEmployee>employeeList=new ArrayList<MasEmployee>();
	Date currentDate=new Date();
	int currentYear=currentDate.getYear();
	BigDecimal totalAL = new BigDecimal("0");
	BigDecimal totalCL= new BigDecimal("0");
	BigDecimal totalSL= new BigDecimal("0");
	BigDecimal availableAL = new BigDecimal("0");
	BigDecimal availableCL= new BigDecimal("0");
	BigDecimal availableSL= new BigDecimal("0");
	
	employeeList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Id", empId)).list();
	leaveTypeList=session.createCriteria(HrLeaveTypeMaster.class).add(Restrictions.eq("Status","y")).list();
	leaveMaintenanceList=session.createCriteria(HrLeaveMaintenance.class).createAlias("Employee", "emp")
							.add(Restrictions.eq("emp.Id", empId)).list();
	if(leaveMaintenanceList.size()>0)
	{
		for(HrLeaveTypeMaster hrLeaveTypeMaster:leaveTypeList)
		{
			if(hrLeaveTypeMaster.getLeaveType().equals("AL"))
			{
				availableAL=new BigDecimal(hrLeaveTypeMaster.getDays());
			}
			if(hrLeaveTypeMaster.getLeaveType().equals("CL"))
			{
				availableCL=new BigDecimal(hrLeaveTypeMaster.getDays());
			}
			if(hrLeaveTypeMaster.getLeaveType().equals("SL"))
			{
				availableSL=new BigDecimal(hrLeaveTypeMaster.getDays());
			}
		}
		for(HrLeaveMaintenance hrLeaveMaintenance:leaveMaintenanceList)
		{
			int fromLeaveYear=hrLeaveMaintenance.getLeaveFrom().getYear();
			if(fromLeaveYear==currentYear)
			{
				if(hrLeaveMaintenance.getLeaveType().getLeaveType().equals("AL"))
				{
					totalAL=totalAL.add(hrLeaveMaintenance.getTotalLeave());
					
				}
				if(hrLeaveMaintenance.getLeaveType().getLeaveType().equals("CL"))
				{
					totalCL=totalCL.add(hrLeaveMaintenance.getTotalLeave());
				}
				if(hrLeaveMaintenance.getLeaveType().getLeaveType().equals("SL"))
				{
					totalSL=totalSL.add(hrLeaveMaintenance.getTotalLeave());
				}
			}
		}
		totalAL=availableAL.add(totalAL.negate());
		totalCL=availableCL.add(totalCL.negate());
		totalSL=availableSL.add(totalSL.negate());
	}
	else
	{
		for(HrLeaveTypeMaster hrLeaveTypeMaster:leaveTypeList)
		{
			if(hrLeaveTypeMaster.getLeaveType().equals("AL"))
			{
				totalAL=new BigDecimal(hrLeaveTypeMaster.getDays());
			}
			if(hrLeaveTypeMaster.getLeaveType().equals("CL"))
			{
				totalCL=new BigDecimal(hrLeaveTypeMaster.getDays());
			}
			if(hrLeaveTypeMaster.getLeaveType().equals("SL"))
			{
				totalSL=new BigDecimal(hrLeaveTypeMaster.getDays());
			}
		}
	}
	map.put("totalAL",totalAL );
	map.put("totalCL",totalCL );
	map.put("totalSL",totalSL );
	map.put("leaveTypeList", leaveTypeList);
	map.put("employeeList", employeeList);
	return map;
}

	public boolean submitLeaveMaintenanceEntry(HrLeaveMaintenance hrLeaveMaintenance){
		boolean successfullyAdded=false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(hrLeaveMaintenance);
		successfullyAdded = true;
		return successfullyAdded;
	}
	
	/**
	 * -------------------------- Night Duty Entry -------------------
	 * Started on 19th May '09
	 */

	public Map<String, Object> getGridDataForEmployeeAdd(Box box) 
	{
		Session session = (Session)getSession();
		Map<String,Object>  map=new HashMap<String,Object>();
		Map<String,Object> utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		session = (Session)getSession();

		int id = 0;

		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;  
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;

		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<Object[]> employeeDetailList = new ArrayList<Object[]>();
		List<MasDepartment>departmentList=new ArrayList<MasDepartment>();
		List<MasRank>rankList=new ArrayList<MasRank>();
		List<HrDutyTimeMaster>dutyTimeMasterList=new ArrayList<HrDutyTimeMaster>();
		List<HrLeaveMaintenance>leaveMaintenanceList=new ArrayList<HrLeaveMaintenance>();
		List<HrDutyExemptionEntry>dutyExemptionList=new ArrayList<HrDutyExemptionEntry>();
		List<MasEmployee> myEmployeeList = new ArrayList<MasEmployee>();
		List<MasDepartmentType> masDepartmentTypeList = new ArrayList<MasDepartmentType>();
		MasDepartmentType masDepartmentType = new MasDepartmentType();
		
			rankList=session.createCriteria(MasRank.class).add(Restrictions.eq("RankName", "SGT")).list();
			employeeList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).createAlias("Rank", "mr").add(Restrictions.le("mr.Id",rankList.get(0).getId())).list();
			masDepartmentTypeList=session.createCriteria(MasDepartmentType.class).add(Restrictions.eq("DepartmentTypeName", "Night Duty Locations")).list();
			if(masDepartmentTypeList.size()!=0){
				masDepartmentType = masDepartmentTypeList.get(0);
			    departmentList=session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).createAlias("DepartmentType", "dt").add(Restrictions.eq("dt.Id",masDepartmentType.getId() )).list();
			}
			    dutyTimeMasterList=session.createCriteria(HrDutyTimeMaster.class).add(Restrictions.eq("Status", "y")).list();
			leaveMaintenanceList=session.createCriteria(HrLeaveMaintenance.class).list();
			dutyExemptionList=session.createCriteria(HrDutyExemptionEntry.class).createAlias("Duty", "d").add(Restrictions.eq("d.DutyName", "Night Duty")).list();
			map.put("dutyExemptionList", dutyExemptionList);
			map.put("leaveMaintenanceList", leaveMaintenanceList);
			map.put("employeeList", employeeList);
			map.put("departmentList", departmentList);
			map.put("dutyTimeMasterList", dutyTimeMasterList);

			int pageno = 1;
			int numOfRows = 10;
			try
			{
				if (box.get("pageno")!=null)
				{
					pageno = Integer.parseInt(box.getString("pageno"));
				}
			}
			catch(Exception e)
			{
				//e.printStackTrace();
				pageno=1;
			}
			
			try
			{
				if (box.get("numOfRows")!=null)
				{
					numOfRows = Integer.parseInt(box.getString("numOfRows"));
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			map.put("pageno", pageno);
			
			int first = (pageno - 1) * numOfRows;
			int totalRecords = 0;
			if(employeeList != null && employeeList.size() > 0)
			{
				
				String qry="SELECT count(*) FROM mas_employee";
				try
				{
					//totalRecords = Integer.parseInt(session.createSQLQuery(qry).list().get(0).toString());
					totalRecords = employeeList.size();
				}
				catch(Exception e)
				{
				totalRecords = 0;
				}
				map.put("totalRecords", totalRecords);

				double totalPages = 0.0;
				totalPages = (double)totalRecords/(double)numOfRows;
				Double d = new Double(Math.ceil(totalPages));
				map.put("totalPages", d.intValue());
				
				String myQry = "select result.employee_id, result.service_no, result.rankname, concat(result.first_name,' ',result.middle_name,' ',result.last_name) as name,result.department_id  ";
				       myQry = myQry + "from ( select main.*,submain.emp_id,submain.duty_date,submain.type_status,if(submain.type_status ='Stand By',1,2) as ordertype from ";
                       myQry = myQry + "(Select *,(select rank_name from mas_rank m where m.rank_id = me.rank_id) as rankname from mas_employee me where status = 'y' and rank_id <= (SELECT rank_id FROM mas_rank where rank_name = 'SGT')) as main";
                       myQry = myQry + "left join (SELECT * FROM hr_duty_entry order by duty_date desc) as submain on main.employee_id = submain.emp_id";
                       myQry = myQry + "order by submain.duty_date) as result order by result.ordertype,result.duty_date, result.first_name";
                Query query = session.createSQLQuery(myQry);
                       query.setFirstResult(first);
                       if (totalRecords < numOfRows)
                    	   query.setMaxResults(totalRecords);
       				   else
       				    	query.setMaxResults(numOfRows);
                     
                       
                    
			/*	Criteria c =session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).createAlias("Rank", "mr").add(Restrictions.le("mr.Id",rankList.get(0).getId()));
				
				c.setFirstResult(first);

				if (totalRecords < numOfRows)
					c.setMaxResults(totalRecords);
				else
					c.setMaxResults(numOfRows);
				*/
				employeeDetailList = query.list();
				//System.out.println("employeeDetailList=="+employeeDetailList.size());
                       
			}

			map.put("employeeDetailList",employeeDetailList);
			map.put("box", box);
		return map;
	}
	
	/*public Map<String, Object> getGridDataForEmployeeAdd(Box box) {
		Session session = (Session)getSession();
		Map<String,Object>  map=new HashMap<String,Object>();
		Map<String,Object> utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		session = (Session)getSession();

		int id = 0;

		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;  
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;

		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasEmployee> employeeDetailList = new ArrayList<MasEmployee>();
		List<MasDepartment>departmentList=new ArrayList<MasDepartment>();
		List<MasRank>rankList=new ArrayList<MasRank>();
		List<HrDutyTimeMaster>dutyTimeMasterList=new ArrayList<HrDutyTimeMaster>();
		List<HrLeaveMaintenance>leaveMaintenanceList=new ArrayList<HrLeaveMaintenance>();
		List<HrDutyExemptionEntry>dutyExemptionList=new ArrayList<HrDutyExemptionEntry>();
		
			rankList=session.createCriteria(MasRank.class).add(Restrictions.eq("RankName", "CPL")).list();
			employeeList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).createAlias("Rank", "mr").add(Restrictions.le("mr.Id",rankList.get(0).getId())).list();
			departmentList=session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
			dutyTimeMasterList=session.createCriteria(HrDutyTimeMaster.class).add(Restrictions.eq("Status", "y")).list();
			leaveMaintenanceList=session.createCriteria(HrLeaveMaintenance.class).list();
			dutyExemptionList=session.createCriteria(HrDutyExemptionEntry.class).createAlias("Duty", "d").add(Restrictions.eq("d.DutyName", "Night Duty")).list();
			map.put("dutyExemptionList", dutyExemptionList);
			map.put("leaveMaintenanceList", leaveMaintenanceList);
			map.put("employeeList", employeeList);
			map.put("departmentList", departmentList);
			map.put("dutyTimeMasterList", dutyTimeMasterList);

			int pageno = 1;
			int numOfRows = 10;
			try
			{
				if (box.get("pageno")!=null)
				{
					pageno = Integer.parseInt(box.getString("pageno"));
				}
			}
			catch(Exception e)
			{
				//e.printStackTrace();
				pageno=1;
			}
			
			try
			{
				if (box.get("numOfRows")!=null)
				{
					numOfRows = Integer.parseInt(box.getString("numOfRows"));
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			map.put("pageno", pageno);
			
			int first = (pageno - 1) * numOfRows;
			int totalRecords = 0;
			if(employeeList != null && employeeList.size() > 0)
			{
				
				String qry="SELECT count(*) FROM mas_employee";
				try
				{
					//totalRecords = Integer.parseInt(session.createSQLQuery(qry).list().get(0).toString());
					totalRecords = employeeList.size();
				}
				catch(Exception e)
				{
				totalRecords = 0;
				}
				map.put("totalRecords", totalRecords);

				
				double totalPages = 0.0;
				totalPages = (double)totalRecords/(double)numOfRows;
				Double d = new Double(Math.ceil(totalPages));
				map.put("totalPages", d.intValue());
				
				Criteria c =session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).createAlias("Rank", "mr").add(Restrictions.le("mr.Id",rankList.get(0).getId()));
				c.setFirstResult(first);

				if (totalRecords < numOfRows)
					c.setMaxResults(totalRecords);
				else
					c.setMaxResults(numOfRows);
				
				employeeDetailList = c.list();
				//System.out.println("employeeDetailList=="+employeeDetailList.size());
			}

			map.put("employeeDetailList",employeeDetailList);
			map.put("box", box);
		return map;
	}*/
	
	public Map<String, Object> getEmployeeDetailsForNightDuty(Box box) 
	{
		/*PagedArray pagedArray = null;
		Session session = (Session)getSession();
		List<MasEmployee> employeeList= new ArrayList<MasEmployee>();
		List<HrDutyEntry> dutyList = new ArrayList<HrDutyEntry>();
		Date fromDate=new Date();
		Date toDate=new Date();
		//System.out.println("fromDate=="+box.get("fromDate"));
		if(!box.get("fromDate").equals("")&& !box.get("toDate").equals(""))
		{
			fromDate=HMSUtil.convertStringTypeDateToDateType(box.get("fromDate"));
			toDate=HMSUtil.convertStringTypeDateToDateType(box.get("toDate"));
			session = (Session)getSession();

			try {
				dutyList=session.createCriteria(HrDutyEntry.class).add(Restrictions.between("DutyDate", fromDate, toDate)).add(Restrictions.eq("Status","y")).list();
			}
			catch (HibernateException e)
			{
				e.printStackTrace();
			}
		}*/
		Map<String,Object>  map=new HashMap<String,Object>();
		map = getGridDataForEmployee(box);
	/*	map.put("dutyList", dutyList);
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
	*/	return map;
	}
	
	

	public Map<String, Object> getGridDataForEmployee(Box box) {
		Session session = (Session)getSession();
		Map<String,Object>  map=new HashMap<String,Object>();
		Map<String,Object> utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		session = (Session)getSession();

		int id = 0;
		int deptId = 0;
		
		Date fromDate=new Date();
		Date toDate=new Date();
		if(!box.get("fromDate").equals(""))
			fromDate=HMSUtil.convertStringTypeDateToDateType(box.get("fromDate"));
		if(!box.get("toDate").equals(""))
			toDate=HMSUtil.convertStringTypeDateToDateType(box.get("toDate"));
		
		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;  
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;

		List<HrDutyEntry> employeeList = new ArrayList<HrDutyEntry>();
		List<HrDutyEntry> dutyEntryList = new ArrayList<HrDutyEntry>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<HrDutyTimeMaster> dutyMasterList = new ArrayList<HrDutyTimeMaster>();
		List<HrDutyEntry>nightDutyListForEntryNo=new ArrayList<HrDutyEntry>();
		List<MasDepartmentType> masDepartmentTypeList = new ArrayList<MasDepartmentType>();
		MasDepartmentType masDepartmentType = new MasDepartmentType();
			employeeList=session.createCriteria(HrDutyEntry.class).add(Restrictions.between("DutyDate", fromDate, toDate)).add(Restrictions.eq("Status","y")).list();
			masDepartmentTypeList=session.createCriteria(MasDepartmentType.class).add(Restrictions.eq("DepartmentTypeName", "Night Duty Locations")).list();
			if(masDepartmentTypeList.size()!=0){
				masDepartmentType = masDepartmentTypeList.get(0);
			    departmentList=session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).createAlias("DepartmentType", "dt").add(Restrictions.eq("dt.Id",masDepartmentType.getId() )).list();
			}
			dutyMasterList=session.createCriteria(HrDutyTimeMaster.class).add(Restrictions.eq("Status", "y")).list();
			nightDutyListForEntryNo=session.createCriteria(HrDutyEntry.class).add(Restrictions.eq("Status", "y")).list();
			Set<String> nightDutySetForEntryNoSet=new TreeSet<String>();
			for(HrDutyEntry hrDutyEntry:nightDutyListForEntryNo){
				nightDutySetForEntryNoSet.add(hrDutyEntry.getEntryNo());
			}

			map.put("employeeList", employeeList);
			map.put("departmentList", departmentList);
			map.put("dutyMasterList", dutyMasterList);
			map.put("nightDutySetForEntryNoSet",nightDutySetForEntryNoSet);

			int pageno = 1;
			int numOfRows = 10;
			try
			{
				if (box.get("pageno")!=null)
				{
					pageno = Integer.parseInt(box.getString("pageno"));
				}
			}
			catch(Exception e)
			{
				//e.printStackTrace();
				pageno=1;
			}
			
			try
			{
				if (box.get("numOfRows")!=null)
				{
					numOfRows = Integer.parseInt(box.getString("numOfRows"));
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			map.put("pageno", pageno);
			
			int first = (pageno - 1) * numOfRows;
			int totalRecords = 0;
			if(employeeList != null && employeeList.size() > 0)
			{
				
				try
				{
					totalRecords = employeeList.size();
				}
				catch(Exception e)
				{
				totalRecords = 0;
				}
				map.put("totalRecords", totalRecords);

				
				double totalPages = 0.0;
				totalPages = (double)totalRecords/(double)numOfRows;
				Double d = new Double(Math.ceil(totalPages));
				map.put("totalPages", d.intValue());
				
				Criteria c =session.createCriteria(HrDutyEntry.class).add(Restrictions.between("DutyDate", fromDate, toDate)).add(Restrictions.eq("Status","y")); 
				c.setFirstResult(first);

				if (totalRecords < numOfRows)
					c.setMaxResults(totalRecords);
				else
					c.setMaxResults(numOfRows);
				
				dutyEntryList = c.list();
			}
			List<HrDutyMaster> dutyList = new ArrayList<HrDutyMaster>();
			String entryNo="";
			try {
				dutyList = session.createCriteria(HrDutyMaster.class).add(Restrictions.eq("DutyName", "Night Duty")).add(Restrictions.eq("Status", "y")).list();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(dutyList!=null && dutyList.size()>0){
			map.put("dutyId", dutyList.get(0).getId());
			}
			entryNo=getEntrySeqForNightDutyDisplay();
			map.put("entryNo",entryNo);
			
			map.put("dutyEntryList",dutyEntryList);
			map.put("box", box);
		return map;
	}
	
	@SuppressWarnings("unchecked")
	public boolean AddNightDutyEntry(Box box){
		Session session=(Session)getSession();
		boolean successfullyAdded=false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		List<TransactionSequence>entryNoList=new ArrayList<TransactionSequence>();
		String tableNameForTransactionSequence="HrDutyEntry";
		String empName="";
		Vector empId=box.getVector("employeeId");
		Vector deptId=box.getVector("department");
		Vector dutyDate=box.getVector("nextDutyDate");
		Vector dutyTime=box.getVector("dutyTimeId");
		Vector remarks=box.getVector("remarks");
		Vector employeeAdded=box.getVector("employeeToBeAdded");
		Vector typeStatus=box.getVector("typeStatus");
		try {
		
			for(int i=0;i<empId.size();i++)
			{
				if(employeeAdded.contains(empId.get(i)))
				{
					HrDutyEntry hrDutyEntry=new HrDutyEntry();
					if(empId.get(i)!=null && !empId.get(i).equals(""))
					{
						MasEmployee masEmployee=new MasEmployee();
						masEmployee.setId(Integer.parseInt(empId.get(i).toString()));
						hrDutyEntry.setEmp(masEmployee);
					}
					
					if(deptId.get(i)!=null && !deptId.get(i).equals("0"))
					{
						MasDepartment masDepartment=new MasDepartment();
						masDepartment.setId(Integer.parseInt(deptId.get(i).toString()));
						hrDutyEntry.setDepartmentId(masDepartment);
					}
					
					if(dutyDate.get(i)!=null )
					{
						hrDutyEntry.setDutyDate(HMSUtil.convertStringTypeDateToDateType((dutyDate.get(i).toString())));
					}
					
					if(dutyTime.get(i)!=null && !dutyTime.get(i).equals(""))
					{
						HrDutyTimeMaster hrDutyTimeMaster=new HrDutyTimeMaster();
						hrDutyTimeMaster.setId(Integer.parseInt(dutyTime.get(i).toString()));
						hrDutyEntry.setDutyTime(hrDutyTimeMaster);
					}
					if(remarks.get(i)!=null )
					{
						hrDutyEntry.setRemarks(remarks.get(i).toString());
					}
					
					if(box.getString("changedBy")!=null && !box.getString("changedBy").equals(""))
					{
						hrDutyEntry.setLastChgBy(box.getString("changedBy"));
					}
					
					if(box.getString("changedDate")!=null && !box.getString("changedDate").equals(""))
					{
						hrDutyEntry.setLastChgDate(HMSUtil.convertStringTypeDateToDateType((box.getString("changedDate"))));
					}
					
					if(box.getString("changedTime")!=null && !box.getString("changedTime").equals(""))
					{
						hrDutyEntry.setLastChgTime(box.getString("changedTime"));
					}
					
					MasHospital masHospital=new MasHospital();
					masHospital.setId(box.getInt("hospitalId"));
					hrDutyEntry.setHospital(masHospital);
					
					hrDutyEntry.setEntryNo(box.getString("entryNo"));
					hrDutyEntry.setEntryDate(HMSUtil.convertStringTypeDateToDateType(box.getString("entryDate")));
					hrDutyEntry.setTypeStatus(typeStatus.get(i).toString());
					hrDutyEntry.setStatus("w");
					
					HrDutyMaster hrDutyMaster=new HrDutyMaster();
					hrDutyMaster.setId(box.getInt("dutyId"));
					hrDutyEntry.setDuty(hrDutyMaster);
					
						try {
							//System.out.println("enetered in the save method");
							hbt.save(hrDutyEntry);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			
				}
			
			}
			entryNoList=session.createCriteria(TransactionSequence.class).add(Restrictions.eq("Tablename", tableNameForTransactionSequence)).list();
			//System.out.println("entryNoList--size"+entryNoList.size());
			TransactionSequence transactionSequence=(TransactionSequence)entryNoList.get(0);
			int id=transactionSequence.getId();
			int entryNo=transactionSequence.getTransactionSequenceNumber();
			entryNo=entryNo+1;
			TransactionSequence transactionSequenceObj=(TransactionSequence)hbt.load(TransactionSequence.class, id);
			transactionSequenceObj.setTransactionSequenceNumber(entryNo);
			hbt.update(transactionSequenceObj);
			
		} catch (Exception e) {
			successfullyAdded = false;
			e.printStackTrace();
		} 
		
				
			successfullyAdded = true;
		
			return successfullyAdded;
	}
	
	public Map<String, Object> getEmployeeLastDutyDetails(Box box) 
	{
		Map<String,Object>  map=new HashMap<String,Object>();
		Session session = (Session)getSession();
		Date currentdate=new Date();
			List<HrDutyEntry>dutyEntryList=new ArrayList<HrDutyEntry>();
			List<HrDutyEntry>holidayEntryList=new ArrayList<HrDutyEntry>();
			List<HrLeaveMaintenance> employeeLeaveList=new ArrayList<HrLeaveMaintenance>();
			
			dutyEntryList=session.createCriteria(HrDutyEntry.class).createAlias("Emp", "me")
			.add(Restrictions.eq("me.Id",Integer.parseInt(box.getString("empData"))))
			.add(Restrictions.eq("Status","y")).add(Restrictions.ne("HolidayStatus","y")).list();
			
			holidayEntryList=session.createCriteria(HrDutyEntry.class).createAlias("Emp", "me")
			.add(Restrictions.eq("me.Id",Integer.parseInt(box.getString("empData"))))
			.add(Restrictions.eq("Status","y")).add(Restrictions.eq("HolidayStatus","y")).list();
			
			employeeLeaveList=session.createCriteria(HrorderlyLeaveApplication.class).createAlias("Employee", "me")
			.add(Restrictions.eq("me.Id",Integer.parseInt(box.getString("empData")))).add(Restrictions.gt("DateOfReporting",currentdate ))
			.add(Restrictions.ne("Status","n")).list();
			
			map.put("dutyEntryList", dutyEntryList);
			map.put("employeeLeaveList", employeeLeaveList);
			map.put("holidayEntryList", holidayEntryList);
			
		return map;
	}
	public Map<String, Object> getGridDataForLastDuty(Box box) {
		Session session = (Session)getSession();
		Map<String,Object>  map=new HashMap<String,Object>();
		Map<String,Object> utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		session = (Session)getSession();

		int id = 0;

		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;  
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;

		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasEmployee> employeeDetailList = new ArrayList<MasEmployee>();
		List<MasDepartment>departmentList=new ArrayList<MasDepartment>();
		List<HrDutyTimeMaster>dutyTimeMasterList=new ArrayList<HrDutyTimeMaster>();
		List<HrDutyEntry>dutyEntryList=new ArrayList<HrDutyEntry>();
		List<HrLeaveMaintenance>employeeLeaveList=new ArrayList<HrLeaveMaintenance>();
		List<OpdHoliday>holidayList=new ArrayList<OpdHoliday>();
		List<MasRank>rankList=new ArrayList<MasRank>();
		
			rankList=session.createCriteria(MasRank.class).add(Restrictions.eq("RankName", "CPL")).list();
			employeeList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).createAlias("Rank", "mr").add(Restrictions.le("mr.Id", rankList.get(0).getId())).list();
			departmentList=session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
			dutyTimeMasterList=session.createCriteria(HrDutyTimeMaster.class).add(Restrictions.eq("Status", "y")).list();
			dutyEntryList=session.createCriteria(HrDutyEntry.class).createAlias("Emp", "me").add(Restrictions.eq("me.Id",Integer.parseInt(box.getString("empData")))).list();
			employeeLeaveList=session.createCriteria(HrLeaveMaintenance.class).createAlias("Employee", "me").add(Restrictions.eq("me.Id",Integer.parseInt(box.getString("empData")))).list();
			holidayList=session.createCriteria(OpdHoliday.class).add(Restrictions.eq("Status", "y")).list();
			
			map.put("employeeList", employeeList);
			map.put("departmentList", departmentList);
			map.put("dutyTimeMasterList", dutyTimeMasterList);
			map.put("dutyEntryList", dutyEntryList);
			map.put("employeeLeaveList", employeeLeaveList);
			map.put("holidayList", holidayList);

			int pageno = 1;
			int numOfRows = 10;
			try
			{
				if (box.get("pageno")!=null)
				{
					pageno = Integer.parseInt(box.getString("pageno"));
				}
			}
			catch(Exception e)
			{
				//e.printStackTrace();
				pageno=1;
			}
			
			try
			{
				if (box.get("numOfRows")!=null)
				{
					numOfRows = Integer.parseInt(box.getString("numOfRows"));
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			map.put("pageno", pageno);
			
			int first = (pageno - 1) * numOfRows;
			int totalRecords = 0;
			if(employeeList != null && employeeList.size() > 0)
			{
				
				try
				{
					totalRecords = employeeList.size();
				}
				catch(Exception e)
				{
				totalRecords = 0;
				}
				map.put("totalRecords", totalRecords);

				
				double totalPages = 0.0;
				totalPages = (double)totalRecords/(double)numOfRows;
				Double d = new Double(Math.ceil(totalPages));
				map.put("totalPages", d.intValue());
				
				Criteria c =session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).createAlias("Rank", "mr").add(Restrictions.le("mr.Id", rankList.get(0).getId())); 
				c.setFirstResult(first);

				if (totalRecords < numOfRows)
					c.setMaxResults(totalRecords);
				else
					c.setMaxResults(numOfRows);
				
				employeeDetailList = c.list();
			}

			map.put("employeeDetailList",employeeDetailList);
			map.put("box", box);
		return map;
	}
	
	public boolean updateNightDutyEntry(Box box){
		boolean successfullyAdded=false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		String empName="";
		Vector dutyId=box.getVector("nightDutyId");
		Vector deptId=box.getVector("department");
		Vector dutyDate=box.getVector("nextDutyDate");
		Vector dutyTime=box.getVector("dutyTime");
		Vector remarks=box.getVector("remarks");
		Vector dutyToBeUpdated=box.getVector("dutyToBeUpdated");
		
		try {
		
		for(int i=0;i<dutyId.size();i++)
		{
			if(dutyToBeUpdated.contains(dutyId.get(i)))
			{
					HrDutyEntry hrDutyEntry=(HrDutyEntry) hbt.load(HrDutyEntry.class, Integer.parseInt(dutyId.get(i).toString()));
					
					if(deptId.get(i)!=null && !deptId.get(i).equals("0"))
					{
						MasDepartment masDepartment=new MasDepartment();
						masDepartment.setId(Integer.parseInt(deptId.get(i).toString()));
						hrDutyEntry.setDepartmentId(masDepartment);
					}
					
					if(dutyDate.get(i)!=null && !dutyDate.get(i).equals(""))
					{
						hrDutyEntry.setDutyDate(HMSUtil.convertStringTypeDateToDateType((dutyDate.get(i).toString())));
					}
					
					if(dutyTime.get(i)!=null && !dutyTime.get(i).equals(""))
					{
						HrDutyTimeMaster hrDutyTimeMaster=new HrDutyTimeMaster();
						hrDutyTimeMaster.setId(Integer.parseInt(dutyTime.get(i).toString()));
						hrDutyEntry.setDutyTime(hrDutyTimeMaster);
					}
					if(remarks.get(i)!=null && !remarks.get(i).equals(""))
					{
						hrDutyEntry.setRemarks(remarks.get(i).toString());
					}
						hbt.update(hrDutyEntry);
				}
			}
		} catch (Exception e) {
			successfullyAdded = false;
			e.printStackTrace();
		} 
		
				
			successfullyAdded = true;
		
			return successfullyAdded;
	}
	
	/**
	 * -------------------------- Guard Duty Entry -------------------
	 * Started on 27th May '09
	 */
	public Map<String,Object> showDutyPerformed()
	{
	 Map<String,Object> map = new HashMap<String,Object>();
	 List<HrDutyMaster> hrDutyMasterList = new ArrayList<HrDutyMaster>();
	 Session session =(Session)getSession();
	 Criteria ctr = session.createCriteria(HrDutyMaster.class).add(Restrictions.eq("Status","y"));
	 hrDutyMasterList =ctr.list();
	 map.put("hrDutyMasterList", hrDutyMasterList);
	 return map;
	}
	public  Map<String, Object> searchDutyPerformed(Map<String, Object> infomap)
	   {
		   Session session =(Session)getSession();
		   Map<String,Object> map = new HashMap<String,Object>();
		   List<HrDutyMaster> hrDutyMasterList = new ArrayList<HrDutyMaster>();
		   List<HrGuardDutyEntry> hrGuardDutyEntryList=new ArrayList<HrGuardDutyEntry>();
		   List<HrDutyEntry> hrDutyEntryList=new ArrayList<HrDutyEntry>();
		   Date dutyDate =null;
		   String dutyType="";
		   dutyDate=(Date)infomap.get("dutyDate");
		   dutyType=(String)infomap.get("dutyType");
		   //System.out.println("dutytype::uds"+dutyType);
		   hrDutyMasterList = session.createCriteria(HrDutyMaster.class).add(Restrictions.eq("Status","y")).list();
	      
		   Criteria criteria=null;
		   if(dutyType.equals("Guard Duty")){
			   criteria = session.createCriteria(HrGuardDutyEntry.class).add(Restrictions.eq("DutyDate", dutyDate)).add(Restrictions.eq("Status","w"));
			   hrGuardDutyEntryList=criteria.list();
			   map.put("hrDutyEntryList", hrGuardDutyEntryList);
		   }else if(dutyType.equals("Night Duty")){
			   criteria = session.createCriteria(HrDutyEntry.class).add(Restrictions.eq("DutyDate", dutyDate)).add(Restrictions.eq("Status","w")); 
			   hrDutyEntryList=criteria.list();
			   map.put("hrDutyEntryList", hrDutyEntryList);
			   
		   }else if(dutyType.equals("Ward Duty")){
			   criteria = session.createCriteria(HrWardDutyEntry.class).add(Restrictions.eq("DutyDate", dutyDate)).add(Restrictions.eq("Status","w")); 
			   hrDutyEntryList=criteria.list();
			   map.put("hrDutyEntryList", hrDutyEntryList);
			   
		   }else if(dutyType.equals("Orderly Duty")){
			   criteria = session.createCriteria(HrOrderlyDutyEntry.class).add(Restrictions.eq("DutyDate", dutyDate)).add(Restrictions.eq("Status","w")); 
			   hrDutyEntryList=criteria.list();
			   map.put("hrDutyEntryList", hrDutyEntryList);
			   
		   }
		  
		   map.put("hrDutyMasterList", hrDutyMasterList);
		   return map;
	   }
	   public boolean  updateDutyPerformed(Map<String, Object> generalMap)
	   {
		   boolean successfull=false;
		   String dutyType="";
		   List<HrGuardDutyEntry> hrGuardDutyEntryList=new ArrayList<HrGuardDutyEntry>();
		   List<HrDutyEntry> hrDutyEntryList=new ArrayList<HrDutyEntry>();
		   List<HrWardDutyEntry> hrWardDutyEntryList=new ArrayList<HrWardDutyEntry>();
		   List<HrOrderlyDutyEntry> hrOrderlyDutyEntryList=new ArrayList<HrOrderlyDutyEntry>();
		   Vector<String> hrGuardDutyIds=null;
		   Vector<String> DutyIds=null;
		   Date dutydate=null;
		   Map<String,Object> map= new HashMap<String,Object>();
		   Box box=(Box)generalMap.get("box");
		   dutydate=(Date)generalMap.get("dutydate");
		   hrGuardDutyIds=box.getVector("hrGuardDutyAdded");
		   DutyIds=box.getVector("dutyId");
		   if(box.getString("dutyTypename")!=null && !box.getString("dutyTypename").equals(""))
			{
				dutyType=(String)box.getString("dutyTypename");
			}
		   Session session =(Session)getSession();
		   org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		   hbt.setFlushModeName("FLUSH_EAGER");
		   hbt.setCheckWriteOperations(false);
		   if(dutyType.equals("Guard Duty")){
		   Criteria criteria = session.createCriteria(HrGuardDutyEntry.class).add(Restrictions.eq("DutyDate", dutydate)).add(Restrictions.eq("Status","w"));
		   hrGuardDutyEntryList=criteria.list();
		   //System.out.println("hrorderlyGuardDutyIds::"+hrGuardDutyIds.size()+"::DutyIds:;"+DutyIds.size()+";;hrorderlyGuardDutyEntryList;;"+hrGuardDutyEntryList.size());
		   HrGuardDutyEntry hrguardduty=null;
		   try{
		   for(int i=0;i<DutyIds.size();i++)
		   {   
			  	//System.out.println("i::"+i);	 
			   if(hrGuardDutyIds.contains(DutyIds.get(i))){
				   hrguardduty= (HrGuardDutyEntry)hrGuardDutyEntryList.get(i);
				   hrguardduty.setStatus("y");
				   hbt.save(hrguardduty);
				   hbt.refresh(hrguardduty);
				   
			   }else{
				   hrguardduty= (HrGuardDutyEntry)hrGuardDutyEntryList.get(i);
				   hrguardduty.setStatus("n");
				   hbt.save(hrguardduty);
				   hbt.refresh(hrguardduty);
			   }
		   }
		   successfull=true;
		   }catch(Exception exc)
		   {
			   successfull=false;
		   }
		   }else  if(dutyType.equals("Night Duty")){
			   Criteria criteria = session.createCriteria(HrDutyEntry.class).add(Restrictions.eq("DutyDate", dutydate)).add(Restrictions.eq("Status","w"));
			   hrDutyEntryList=criteria.list();
			   //System.out.println("hrDutyIds::"+hrGuardDutyIds.size()+"::DutyIds:;"+DutyIds.size()+";;hrDutyEntryList;;"+hrDutyEntryList.size());
			   HrDutyEntry hrdutyentry=null;
			   try{
			   for(int i=0;i<DutyIds.size();i++)
			   {   
				  	//System.out.println("i::"+i);	 
				   if(hrGuardDutyIds.contains(DutyIds.get(i))){
					   hrdutyentry= (HrDutyEntry)hrDutyEntryList.get(i);
					   hrdutyentry.setStatus("y");
					   hbt.save(hrdutyentry);
					   hbt.refresh(hrdutyentry);
					   
				   }else{
					   hrdutyentry= (HrDutyEntry)hrDutyEntryList.get(i);
					   hrdutyentry.setStatus("n");
					   hbt.save(hrdutyentry);
					   hbt.refresh(hrdutyentry);
				   }
			   }
			   successfull=true;
			   }catch(Exception exc)
			   {
				   successfull=false;
			   }
		   }else if(dutyType.equals("Ward Duty")){
			   Criteria criteria = session.createCriteria(HrWardDutyEntry.class).add(Restrictions.eq("DutyDate", dutydate)).add(Restrictions.eq("Status","w"));
			   hrWardDutyEntryList=criteria.list();
			   //System.out.println("hrorderlyGuardDutyIds::"+hrGuardDutyIds.size()+"::DutyIds:;"+DutyIds.size()+";;hrorderlyGuardDutyEntryList;;"+hrGuardDutyEntryList.size());
			   HrWardDutyEntry hrwardduty=null;
			   try{
			   for(int i=0;i<DutyIds.size();i++)
			   {   
				  	//System.out.println("i::"+i);	 
				   if(hrGuardDutyIds.contains(DutyIds.get(i))){
					   hrwardduty= (HrWardDutyEntry)hrWardDutyEntryList.get(i);
					   hrwardduty.setStatus("y");
					   hbt.save(hrwardduty);
					   hbt.refresh(hrwardduty);
					   
				   }else{
					   hrwardduty= (HrWardDutyEntry)hrWardDutyEntryList.get(i);
					   hrwardduty.setStatus("n");
					   hbt.save(hrwardduty);
					   hbt.refresh(hrwardduty);
				   }
			   }
			   successfull=true;
			   }catch(Exception exc)
			   {
				   successfull=false;
			   }
			   }else if(dutyType.equals("Orderly Duty")){
				   Criteria criteria = session.createCriteria(HrOrderlyDutyEntry.class).add(Restrictions.eq("DutyDate", dutydate)).add(Restrictions.eq("Status","w"));
				   hrOrderlyDutyEntryList=criteria.list();
				   //System.out.println("hrorderlyGuardDutyIds::"+hrGuardDutyIds.size()+"::DutyIds:;"+DutyIds.size()+";;hrorderlyGuardDutyEntryList;;"+hrGuardDutyEntryList.size());
				   HrOrderlyDutyEntry hrorderlyduty=null;
				   try{
				   for(int i=0;i<DutyIds.size();i++)
				   {   
					  	//System.out.println("i::"+i);	 
					   if(hrGuardDutyIds.contains(DutyIds.get(i))){
						   hrorderlyduty= (HrOrderlyDutyEntry)hrOrderlyDutyEntryList.get(i);
						   hrorderlyduty.setStatus("y");
						   hbt.save(hrorderlyduty);
						   hbt.refresh(hrorderlyduty);
						   
					   }else{
						   hrorderlyduty= (HrOrderlyDutyEntry)hrOrderlyDutyEntryList.get(i);
						   hrorderlyduty.setStatus("n");
						   hbt.save(hrorderlyduty);
						   hbt.refresh(hrorderlyduty);
					   }
				   }
				   successfull=true;
				   }catch(Exception exc)
				   {
					   successfull=false;
				   }
				   }
		   
		   return successfull;
	   }
	public Map<String, Object> getEmployeeDetailsForGuardDutyAdd(Box box) 
	{
		
		Map<String,Object>  map=new HashMap<String,Object>();
		
		
		map = getGridDataForGuardEmployeeAdd(box);
		
		return map;
	}
	
	public Map<String, Object> getGridDataForGuardEmployeeAdd(Box box) {
		Session session = (Session)getSession();
		Map<String,Object>  map=new HashMap<String,Object>();
		Map<String,Object> utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		session = (Session)getSession();

		int id = 0;

		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;  
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;
        List objectList = new ArrayList();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasEmployee> employeeDetailList = new ArrayList<MasEmployee>();
		List<MasDepartment>departmentList=new ArrayList<MasDepartment>();
		List<MasDepartmentType> masdepartmenttypeList = new ArrayList<MasDepartmentType>();
		MasDepartmentType masdepartmenttype = new MasDepartmentType();
		List<MasRank>rankList=new ArrayList<MasRank>();
		List<MasRank>rankList1=new ArrayList<MasRank>();
		List<HrDutyTimeMaster>dutyTimeMasterList=new ArrayList<HrDutyTimeMaster>();
		List<HrLeaveMaintenance>leaveMaintenanceList=new ArrayList<HrLeaveMaintenance>();
		List<HrDutyExemptionEntry>dutyExemptionList=new ArrayList<HrDutyExemptionEntry>();
		List<HrGuardDutyEntry> hrGuardDutyEntry=new ArrayList<HrGuardDutyEntry>();
		List<HrGuardDutyEntry> GuardDutyHoliDay=new ArrayList<HrGuardDutyEntry>();
		try 
		{
			rankList1=session.createSQLQuery("select rank_id from mas_rank as mr where mr.rank_code>26 and mr.service_type_id in(1,2,6) and mr.rank_category_id=3 and mr.service_status_id=1").list();
			Object rankArray []=rankList1.toArray();
			
		/*Criteria ctr=session.createCriteria(MasEmployee.class).add(Restrictions.ne("Status", "n"))
			.createAlias("Trade", "tr").add(Restrictions.or(Restrictions.eq("tr.Id", 7), Restrictions.eq("tr.Id", 2)))
			.createAlias("Rank", "mr").add(Restrictions.in("mr.Id",rankArray));
			employeeList=ctr.list(); 
		*/	
			String myQry = " select distinct result.employee_id, result.service_no, result.rankname, concat(result.first_name,' ',result.middle_name,' ',result.last_name) as name,result.department_id from ( select distinct main.*, submain.emp_id,submain.duty_date,submain.type_status,if(submain.type_status ='Stand By',1,2) as ordertype from ";
			myQry = myQry + " (select *,(select rank_name from mas_rank m where m.rank_id = me.rank_id) as rankname from mas_employee me where  status != 'n' and rank_id in(select rank_id from mas_rank as mr where mr.rank_code > 26 and mr.service_type_id in(1,2,6) "; 
			myQry = myQry + " and mr.rank_category_id=3 and mr.service_status_id=1) and trade_id in(7,2)) as main ";
			myQry = myQry + " left join (SELECT * FROM hr_guard_duty_entry order by duty_date desc) as submain on main.employee_id = submain.emp_id ";
			myQry = myQry + " order by submain.duty_date) as result order by result.ordertype,result.duty_date, result.first_name ";
			employeeList = session.createSQLQuery(myQry).list();
			
			dutyTimeMasterList = session.createCriteria(HrDutyTimeMaster.class).add(Restrictions.eq("Status", "y")).list();
			masdepartmenttypeList=session.createCriteria(MasDepartmentType.class).add(Restrictions.eq("DepartmentTypeName","Gaurd Duty Locations")).list();
			if(masdepartmenttypeList.size()!=0){
			masdepartmenttype=masdepartmenttypeList.get(0);
			departmentList=session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).createAlias("DepartmentType", "dt").add(Restrictions.eq("dt.Id", masdepartmenttype.getId())).list();
			}
			leaveMaintenanceList=session.createCriteria(HrLeaveMaintenance.class).add(Restrictions.ne("ApprovedStatus","n")).addOrder(Order.desc("LeaveFrom")).list();
			//System.out.println("leaveMaintenanceList.size()  in controller  :  "+leaveMaintenanceList.size());
			dutyExemptionList=session.createCriteria(HrDutyExemptionEntry.class).createAlias("Duty", "d").add(Restrictions.eq("d.DutyName", "Guard Duty")).list();
			hrGuardDutyEntry=session.createCriteria(HrGuardDutyEntry.class).add(Restrictions.eq("Status","y")).addOrder(Order.desc("DutyDate")).list();
			GuardDutyHoliDay=session.createCriteria(HrGuardDutyEntry.class).add(Restrictions.eq("Status","y")).createAlias("Emp", "emp").addOrder(Order.desc("emp.Id")).addOrder(Order.desc("DutyDate")).list();
			
			MasEmployee masemployee=null;
			
			
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
		}
			
			int pageno = 1;
			int numOfRows = 10;
			try
			{
				if (box.get("pageno")!=null)
				{
					pageno = Integer.parseInt(box.getString("pageno"));
				}
			}
			catch(Exception e)
			{
				//e.printStackTrace();
				pageno=1;
			}
			
			try
			{
				if (box.get("numOfRows")!=null)
				{
					numOfRows = Integer.parseInt(box.getString("numOfRows"));
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			map.put("pageno", pageno);
			
			int first = (pageno - 1) * numOfRows;
			int totalRecords = 0;
			if(employeeList != null && employeeList.size() > 0)
			{
				
				//String qry="SELECT count(*) FROM mas_employee";
				try
				{
					//totalRecords = Integer.parseInt(session.createSQLQuery(qry).list().get(0).toString());
					totalRecords = (Integer)employeeList.size();
				}
				catch(Exception e)
				{
				totalRecords = 0;
				}
				map.put("totalRecords", totalRecords);

				
				double totalPages = 0.0;
				totalPages = (double)totalRecords/(double)numOfRows;
				Double d = new Double(Math.ceil(totalPages));
				map.put("totalPages", d.intValue());
								
				if ((totalRecords-first) < numOfRows)
					employeeDetailList=employeeList.subList(first,totalRecords);
				else
					employeeDetailList=employeeList.subList(first,numOfRows+first);
				
				
			}
			map.put("employeeDetailList",employeeDetailList);
			map.put("dutyExemptionList", dutyExemptionList);
			map.put("leaveMaintenanceList", leaveMaintenanceList);
			map.put("employeeList", employeeList);
			map.put("departmentList", departmentList);
			map.put("dutyTimeMasterList", dutyTimeMasterList);
			map.put("hrorderlyGuardDutyEntry", hrGuardDutyEntry);
			map.put("GuardDutyHoliDay", GuardDutyHoliDay);
			
		return map;

	}
	
	public Map<String, Object> getEmployeeDetailsForGuardDuty(Box box) 
	{
		//System.out.println("first method called");
		PagedArray pagedArray = null;
		Session session = (Session)getSession();
		Map<String,Object>  map=new HashMap<String,Object>();
		List<MasEmployee> employeeList= new ArrayList<MasEmployee>();
		List<HrGuardDutyEntry> dutyList = new ArrayList<HrGuardDutyEntry>();
		Date fromDate=HMSUtil.convertStringTypeDateToDateType(box.get("fromDate"));
		Date toDate=HMSUtil.convertStringTypeDateToDateType(box.get("toDate"));
		
		session = (Session)getSession();
		try 
		{
			dutyList=session.createCriteria(HrGuardDutyEntry.class).add(Restrictions.between("DutyDate", fromDate, toDate)).add(Restrictions.eq("Status", "a")).list();
		//System.out.println("dutyList--- "+dutyList.size());
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
		}
		map = getGridDataForGuardEmployee(box);
		map.put("dutyEntryList", dutyList);
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		
		
		return map;
	}
	
	

	public Map<String, Object> getGridDataForGuardEmployee(Box box) {
		// TODO Auto-generated method stub
		Session session = (Session)getSession();
		Map<String,Object>  map=new HashMap<String,Object>();
		Map<String,Object> utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		session = (Session)getSession();

		int id = 0;
		int deptId = 0;
		Date fromDate=null;
		Date toDate=null;
		if(!box.get("fromDate").equals(""))
			fromDate=HMSUtil.convertStringTypeDateToDateType(box.get("fromDate"));
		if(!box.get("toDate").equals(""))
			toDate=HMSUtil.convertStringTypeDateToDateType(box.get("toDate"));

		List<HrGuardDutyEntry> employeeList = new ArrayList<HrGuardDutyEntry>();
		List<HrGuardDutyEntry> dutyEntryList = new ArrayList<HrGuardDutyEntry>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<HrDutyTimeMaster> dutyMasterList = new ArrayList<HrDutyTimeMaster>();
		List<HrGuardDutyEntry>guardDutyListForEntryNo=new ArrayList<HrGuardDutyEntry>();
		 MasDepartmentType masdepartmenttype = null;
		 List<MasDepartment> masdepartmentList=new ArrayList<MasDepartment>();
		if(fromDate!=null && toDate!=null)
			employeeList=session.createCriteria(HrGuardDutyEntry.class).add(Restrictions.between("DutyDate", fromDate, toDate)).add(Restrictions.eq("Status","y")).list();
		else
			employeeList=session.createCriteria(HrGuardDutyEntry.class).add(Restrictions.eq("Status","y")).list();
			departmentList=session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
			dutyMasterList=session.createCriteria(HrDutyTimeMaster.class).add(Restrictions.eq("Status", "y")).list();
			guardDutyListForEntryNo=session.createCriteria(HrGuardDutyEntry.class).add(Restrictions.eq("Status", "y")).list();
			List<MasDepartmentType> masDepartmentTypeList = new ArrayList<MasDepartmentType>();
			masDepartmentTypeList=(List<MasDepartmentType>)session.createCriteria(MasDepartmentType.class).add(Restrictions.eq("DepartmentTypeName","Gaurd Duty Locations")).list();
			if(masDepartmentTypeList.size()!=0)
			{
				masdepartmenttype=masDepartmentTypeList.get(0);
			}
			
				if(masdepartmenttype!=null)
				{
					masdepartmentList=session.createCriteria(MasDepartment.class).createAlias("DepartmentType","dt").add(Restrictions.eq("dt.Id", masdepartmenttype.getId())).list();
				}
		   //System.out.println("masDepartmentTypeList:::"+masDepartmentTypeList.size()+"::masdepartmentList::"+masdepartmentList.size());		
			Set<String> guardDutySetForEntryNoSet=new TreeSet<String>();
			for(HrGuardDutyEntry hrGuardDutyEntry:guardDutyListForEntryNo){
				guardDutySetForEntryNoSet.add(hrGuardDutyEntry.getEntryNo());
			}

			int pageno = 1;
			int numOfRows = 10;
			try
			{
				if (box.get("pageno")!=null && !box.get("pageno").equals(""))
				{
					pageno = Integer.parseInt(box.getString("pageno"));
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				pageno=1;
			}
			
			
			try
			{
				if (box.get("numOfRows")!=null)
				{
					numOfRows = Integer.parseInt(box.getString("numOfRows"));
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			map.put("pageno", pageno);
			
			int first = (pageno - 1) * numOfRows;
			int totalRecords = 0;
			if(employeeList != null && employeeList.size() > 0)
			{
				try
				{
					totalRecords = employeeList.size();
				}
				catch(Exception e)
				{
				totalRecords = 0;
				}
				map.put("totalRecords", totalRecords);

				double totalPages = 0.0;
				totalPages = (double)totalRecords/(double)numOfRows;
				Double d = new Double(Math.ceil(totalPages));
				map.put("totalPages", d.intValue());
				
				if ((totalRecords-first) < numOfRows)
					dutyEntryList = employeeList.subList(first, totalRecords);
				else
					dutyEntryList = employeeList.subList(first, numOfRows+first);
				
				
			}
			List<HrDutyMaster> dutyList = new ArrayList<HrDutyMaster>();
			String entryNo="";
			try {
				dutyList = session.createCriteria(HrDutyMaster.class).add(Restrictions.eq("DutyName", "Guard Duty")).add(Restrictions.eq("Status", "y")).list();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(dutyList.size()!=0)
			{
			map.put("dutyId", dutyList.get(0).getId());
			}
			entryNo=getEntrySeqForGuardDutyDisplay();
			map.put("entryNo",entryNo);
			map.put("dutyEntryList",dutyEntryList);
			map.put("box", box);
			map.put("guardDutySetForEntryNoSet",guardDutySetForEntryNoSet);
			map.put("employeeList", employeeList);
			map.put("departmentList", departmentList);
			map.put("dutyMasterList", dutyMasterList);
			map.put("masdepartmentList", masdepartmentList);
		return map;
	}
	
	public boolean AddGuardDutyEntry(Box box){
		boolean successfullyAdded=false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		Session session=(Session)getSession();
		
		List<TransactionSequence>entryNoList=new ArrayList<TransactionSequence>();
		String tableNameForTransactionSequence="HrGuardDutyEntry";
		
		String empName="";
		Vector empId=box.getVector("employeeId");
		Vector dutyDate=box.getVector("nextDutyDate");
		Vector dutyTime=box.getVector("dutyTimeId");
		Vector employeeAdded=box.getVector("employeeToBeAdded");
		Vector typeStatus=box.getVector("typeStatus");
	//	//System.out.println("typeStatus---"+typeStatus);
		Vector departmenttype=box.getVector("Location");
		try {
		
			for(int i=0;i<empId.size();i++)
			{
				if(employeeAdded.contains(empId.get(i)))
				{
					////System.out.println("entered in the method");
					HrGuardDutyEntry hrGuardDutyEntry=new HrGuardDutyEntry();
					
					hrGuardDutyEntry.setEntryNo(box.getString("entryNo"));
					hrGuardDutyEntry.setEntryDate(HMSUtil.convertStringTypeDateToDateType(box.getString("entryDate")));
				
					hrGuardDutyEntry.setTypeStatus(typeStatus.get(i).toString());
					hrGuardDutyEntry.setStatus("w");
					
					HrDutyMaster hrDutyMaster=new HrDutyMaster();
					hrDutyMaster.setId(box.getInt("dutyId"));
					hrGuardDutyEntry.setDuty(hrDutyMaster);
					
					if(empId.get(i)!=null && !empId.get(i).equals(""))
					{
						MasEmployee masEmployee=new MasEmployee();
						masEmployee.setId(Integer.parseInt(empId.get(i).toString()));
						hrGuardDutyEntry.setEmp(masEmployee);
					}
					if(departmenttype.get(i)!=null && !departmenttype.get(i).equals(""))
					{
						MasDepartment masdepartment=new MasDepartment();
						masdepartment.setId(Integer.parseInt(departmenttype.get(i).toString()));
						hrGuardDutyEntry.setDepartmentId(masdepartment);
					}
					
					if(dutyDate.get(i)!=null )
					{
						hrGuardDutyEntry.setDutyDate(HMSUtil.convertStringTypeDateToDateType((dutyDate.get(i).toString())));
						if((HMSUtil.convertStringTypeDateToDateType((dutyDate.get(i).toString())).getDay())==0){
							hrGuardDutyEntry.setHolidayStatus("y");
						}else{
							hrGuardDutyEntry.setHolidayStatus("n");
						}
						
					}
					if(dutyTime!=null){
					if(dutyTime.get(i)!=null && !dutyTime.get(i).equals(""))
					{
						HrDutyTimeMaster hrDutyTimeMaster=new HrDutyTimeMaster();
						hrDutyTimeMaster.setId(Integer.parseInt(dutyTime.get(i).toString()));
						hrGuardDutyEntry.setDutyTime(hrDutyTimeMaster);
					}
					}		
					if(box.getString("changedBy")!=null && !box.getString("changedBy").equals(""))
					{
						hrGuardDutyEntry.setLastChgBy(box.getString("changedBy"));
					}
					
					if(box.getString("changedDate")!=null && !box.getString("changedDate").equals(""))
					{
						hrGuardDutyEntry.setLastChgDate(HMSUtil.convertStringTypeDateToDateType((box.getString("changedDate"))));
					}
					
					if(box.getString("changedTime")!=null && !box.getString("changedTime").equals(""))
					{
						hrGuardDutyEntry.setLastChgTime(box.getString("changedTime"));
					}
					
					MasHospital masHospital=new MasHospital();
					masHospital.setId(box.getInt("hospitalId"));
					hrGuardDutyEntry.setHospital(masHospital);
					
						hbt.save(hrGuardDutyEntry);
						hbt.refresh(hrGuardDutyEntry);
			
				}
			
			}
			entryNoList=session.createCriteria(TransactionSequence.class).add(Restrictions.eq("Tablename", tableNameForTransactionSequence)).list();
			TransactionSequence transactionSequence=(TransactionSequence)entryNoList.get(0);
			int id=transactionSequence.getId();
			int entryNo=transactionSequence.getTransactionSequenceNumber();
			entryNo=entryNo+1;
			TransactionSequence transactionSequenceObj=(TransactionSequence)hbt.load(TransactionSequence.class, id);
			transactionSequenceObj.setTransactionSequenceNumber(entryNo);
			hbt.update(transactionSequenceObj);
			
		} catch (Exception e) {
			successfullyAdded = false;
			e.printStackTrace();
		} 
		
				
			successfullyAdded = true;
		
			return successfullyAdded;
	}
	
	public Map<String, Object> getGuardEmployeeLastDutyDetails(Box box) 
	{
		
		Map<String,Object>  map=new HashMap<String,Object>();
		Session session = (Session)getSession();
		Date currentdate=new Date();
			List<HrGuardDutyEntry>dutyEntryList=new ArrayList<HrGuardDutyEntry>();
			List<HrGuardDutyEntry>holidayEntryList=new ArrayList<HrGuardDutyEntry>();
			List<HrLeaveMaintenance> employeeLeaveList=new ArrayList<HrLeaveMaintenance>();
			
			//System.out.println("Integer.parseInt(box.)"+Integer.parseInt(box.getString("empData")));
			dutyEntryList=session.createCriteria(HrGuardDutyEntry.class).createAlias("Emp", "me")
			.add(Restrictions.eq("me.Id",Integer.parseInt(box.getString("empData"))))
			.add(Restrictions.eq("Status","y")).add(Restrictions.ne("HolidayStatus","y")).list();
			
			//System.out.println("dutyEntryList in getGuardEmployeeLastDutyDetails  "+dutyEntryList.size());
			holidayEntryList=session.createCriteria(HrGuardDutyEntry.class).createAlias("Emp", "me")
			.add(Restrictions.eq("me.Id",Integer.parseInt(box.getString("empData"))))
			.add(Restrictions.eq("Status","y")).add(Restrictions.eq("HolidayStatus","y")).list();
			
			//System.out.println("holidayEntryList in getGuardEmployeeLastDutyDetails  "+holidayEntryList.size());
			employeeLeaveList=session.createCriteria(HrorderlyLeaveApplication.class).createAlias("Employee", "me")
			.add(Restrictions.eq("me.Id",Integer.parseInt(box.getString("empData")))).add(Restrictions.gt("DateOfReporting",currentdate ))
			.add(Restrictions.ne("Status","n")).list();
			
			//System.out.println("employeeLeaveList in getGuardEmployeeLastDutyDetails  "+employeeLeaveList.size());
			map.put("dutyEntryList", dutyEntryList);
			map.put("employeeLeaveList", employeeLeaveList);
			map.put("holidayEntryList", holidayEntryList);
			
		return map;
		
	}
	public Map<String, Object> getGridDataForGuardLastDuty(Box box) {
		Session session = (Session)getSession();
		Map<String,Object>  map=new HashMap<String,Object>();
		Map<String,Object> utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		session = (Session)getSession();
        Date currentdate=new Date();
		int id = 0;

		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;  
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;

		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasEmployee> employeeDetailList = new ArrayList<MasEmployee>();
		List<MasDepartment>departmentList=new ArrayList<MasDepartment>();
		List<HrDutyTimeMaster>dutyTimeMasterList=new ArrayList<HrDutyTimeMaster>();
		List<HrGuardDutyEntry>dutyEntryList=new ArrayList<HrGuardDutyEntry>();
		List<HrGuardDutyEntry>holidayEntryList=new ArrayList<HrGuardDutyEntry>();
		List<HrLeaveMaintenance> employeeLeaveList=new ArrayList<HrLeaveMaintenance>();
		List<OpdHoliday>holidayList=new ArrayList<OpdHoliday>();
		List<MasRank>rankList=new ArrayList<MasRank>();
		 MasDepartmentType masdepartmenttype = null;
		 List<MasDepartment> masdepartmentList=new ArrayList<MasDepartment>();
		  masdepartmenttype=(MasDepartmentType)session.createCriteria(MasDepartmentType.class).add(Restrictions.eq("DepartmentTypeName","Gaurd Duty Locations")).list().get(0);
				if(masdepartmenttype!=null)
				{
					masdepartmentList=session.createCriteria(MasDepartment.class).createAlias("DepartmentType","dt").add(Restrictions.eq("dt.Id", masdepartmenttype.getId())).list();
				}		
		rankList=session.createSQLQuery("select rank_id from mas_rank as mr where mr.rank_code>26 and mr.service_type_id in(1,2,6) and mr.rank_category_id=3 and mr.service_status_id=1").list();
											
		Criteria ctr=session.createCriteria(MasEmployee.class).add(Restrictions.ne("Status", "n"))
		.createAlias("Trade", "tr").add(Restrictions.or(Restrictions.eq("tr.Id", 7), Restrictions.eq("tr.Id", 2)))
		.createAlias("Rank", "mr").add(Restrictions.in("mr.Id",rankList));
		employeeList=ctr.list();
		
			departmentList=session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
			dutyTimeMasterList=session.createCriteria(HrDutyTimeMaster.class).add(Restrictions.eq("Status", "y")).list();
			
			dutyEntryList=session.createCriteria(HrGuardDutyEntry.class).createAlias("Emp", "me")
			.add(Restrictions.eq("me.Id",Integer.parseInt(box.getString("empData"))))
			.add(Restrictions.eq("Status","y")).add(Restrictions.ne("HolidayStatus","y")).list();
			
			holidayEntryList=session.createCriteria(HrGuardDutyEntry.class).createAlias("Emp", "me")
			.add(Restrictions.eq("me.Id",Integer.parseInt(box.getString("empData"))))
			.add(Restrictions.eq("Status","y")).add(Restrictions.eq("HolidayStatus","y")).list();
			
			employeeLeaveList=session.createCriteria(HrLeaveMaintenance.class).createAlias("Employee", "me")
			.add(Restrictions.eq("me.Id",Integer.parseInt(box.getString("empData")))).add(Restrictions.gt("DateOfReporting",currentdate ))
			.add(Restrictions.ne("Status","n")).list();
			
			holidayList=session.createCriteria(OpdHoliday.class).add(Restrictions.eq("Status", "y")).list();
			
			int pageno = 1;
			int numOfRows = 10;
			try
			{
				if (box.get("pageno")!=null)
				{
					pageno = Integer.parseInt(box.getString("pageno"));
				}
			}
			catch(Exception e)
			{
				//e.printStackTrace();
				pageno=1;
			}
			
			try
			{
				if (box.get("numOfRows")!=null)
				{
					numOfRows = Integer.parseInt(box.getString("numOfRows"));
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			map.put("pageno", pageno);
			
			int first = (pageno - 1) * numOfRows;
			int totalRecords = 0;
			if(employeeList != null && employeeList.size() > 0)
			{
				try
				{
					totalRecords = employeeList.size();
				}
				catch(Exception e)
				{
				totalRecords = 0;
				}
				map.put("totalRecords", totalRecords);

				
				double totalPages = 0.0;
				totalPages = (double)totalRecords/(double)numOfRows;
				Double d = new Double(Math.ceil(totalPages));
				map.put("totalPages", d.intValue());
				if((totalRecords-first)<numOfRows)
				{
					employeeDetailList = employeeList.subList(first, totalRecords);	
				}
				else
				{
					employeeDetailList = employeeList.subList(first, numOfRows);
				}
				
				
				//System.out.println("employeeDetailList=="+employeeDetailList.size());
			}

			map.put("employeeDetailList",employeeDetailList);
			map.put("departmentList", departmentList);
			map.put("dutyTimeMasterList", dutyTimeMasterList);
			map.put("dutyEntryList", dutyEntryList);
			map.put("employeeLeaveList", employeeLeaveList);
			map.put("holidayEntryList", holidayEntryList);
			map.put("holidayList", holidayList);
			map.put("masdepartmenttype", masdepartmenttype);
			map.put("box", box);
		return map;
	}
	
	public boolean updateGuardDutyEntry(Box box){
		boolean successfullyAdded=false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		String empName="";
		Vector dutyId=box.getVector("guardDutyId");
		Vector deptId=box.getVector("department");
		Vector dutyDate=box.getVector("nextDutyDate");
		Vector dutyTime=box.getVector("dutyTime");
		Vector remarks=box.getVector("remarks");
		Vector dutyToBeUpdated=box.getVector("dutyToBeUpdated");
		
		try {
		
		for(int i=0;i<dutyId.size();i++)
		{
			if(dutyToBeUpdated.contains(dutyId.get(i)))
			{
				HrGuardDutyEntry hrGuardDutyEntry=(HrGuardDutyEntry) hbt.load(HrGuardDutyEntry.class, Integer.parseInt(dutyId.get(i).toString()));
					
					
					if(dutyDate.get(i)!=null && !dutyDate.get(i).equals(""))
					{
						hrGuardDutyEntry.setDutyDate(HMSUtil.convertStringTypeDateToDateType((dutyDate.get(i).toString())));
					}
					
					if(dutyTime.get(i)!=null && !dutyTime.get(i).equals(""))
					{
						HrDutyTimeMaster hrDutyTimeMaster=new HrDutyTimeMaster();
						hrDutyTimeMaster.setId(Integer.parseInt(dutyTime.get(i).toString()));
						hrGuardDutyEntry.setDutyTime(hrDutyTimeMaster);
					}
						hbt.update(hrGuardDutyEntry);
				}
			}
		} catch (Exception e) {
			successfullyAdded = false;
			e.printStackTrace();
		} 
		
				
			successfullyAdded = true;
		
			return successfullyAdded;
	}
	
	/**
	 * -------------------------- Ward Duty Entry -------------------
	 * Started on 1st June '09
	 */

	public Map<String, Object> getEmployeeDetailsForWardDutyAdd(Box box) 
	{
		/*PagedArray pagedArray = null;
		Session session = (Session)getSession();
		
		List<MasEmployee> employeeList= new ArrayList<MasEmployee>();
		List<MasDepartment>departmentList=new ArrayList<MasDepartment>();
		List<HrDutyTimeMaster>dutyTimeMasterList=new ArrayList<HrDutyTimeMaster>();
		List<MasRank>rankList=new ArrayList<MasRank>();
		List<MasDepartmentType> masdepartmenttypeList = new ArrayList<MasDepartmentType>();
		MasDepartmentType masdepartmenttype = null;
		session = (Session)getSession();

		try 
		{
			masdepartmenttypeList=session.createCriteria(MasDepartmentType.class).add(Restrictions.eq("DepartmentTypeName","Ward Duty Locations")).list();
			if(masdepartmenttypeList.size()!=0)
			{
				masdepartmenttype=(MasDepartmentType)masdepartmenttypeList.get(0);
				departmentList=session.createCriteria(MasDepartment.class).createAlias("DepartmentType","dt").add(Restrictions.eq("dt.Id", masdepartmenttype.getId())).list();
			}
			rankList=session.createCriteria(MasRank.class).add(Restrictions.eq("RankName", "SGT")).list();
			employeeList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).createAlias("Rank", "mr").add(Restrictions.le("mr.Id",rankList.get(0).getId())).list();
			//departmentList=session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
			dutyTimeMasterList=session.createCriteria(HrDutyTimeMaster.class).add(Restrictions.eq("Status", "y")).list();
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
		}
		map.put("employeeList", employeeList);
		map.put("departmentList", departmentList);
		map.put("dutyTimeMasterList", dutyTimeMasterList);*/
		Map<String,Object>  map=new HashMap<String,Object>();
		map = getGridDataForWardEmployeeAdd(box);
		
		return map;
	}
	
	public Map<String, Object> getGridDataForWardEmployeeAdd(Box box) {
		Session session = (Session)getSession();
		Map<String,Object>  map=new HashMap<String,Object>();
		Map<String,Object> utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		session = (Session)getSession();

		int id = 0;

		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;  
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;

		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasEmployee> employeeDetailList = new ArrayList<MasEmployee>();
		List<MasDepartment>departmentList=new ArrayList<MasDepartment>();
		List<MasRank>rankList=new ArrayList<MasRank>();
		List<HrDutyTimeMaster>dutyTimeMasterList=new ArrayList<HrDutyTimeMaster>();
		List<HrLeaveMaintenance>leaveMaintenanceList=new ArrayList<HrLeaveMaintenance>();
		List<HrDutyExemptionEntry>dutyExemptionList=new ArrayList<HrDutyExemptionEntry>();
		List<MasDepartmentType> masdepartmenttypeList = new ArrayList<MasDepartmentType>();
		MasDepartmentType masdepartmenttype = null;
		
			rankList=session.createCriteria(MasRank.class).add(Restrictions.eq("RankName", "SGT")).list();
			employeeList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).createAlias("Rank", "mr").add(Restrictions.le("mr.Id",rankList.get(0).getId())).list();
			//departmentList=session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
			dutyTimeMasterList=session.createCriteria(HrDutyTimeMaster.class).add(Restrictions.eq("Status", "y")).list();
			leaveMaintenanceList=session.createCriteria(HrLeaveMaintenance.class).list();
			dutyExemptionList=session.createCriteria(HrDutyExemptionEntry.class).createAlias("Duty", "d").add(Restrictions.eq("d.DutyName", "Ward Duty")).list();
			masdepartmenttypeList=session.createCriteria(MasDepartmentType.class).add(Restrictions.eq("DepartmentTypeName","Ward Duty Locations")).list();
			if(masdepartmenttypeList.size()!=0)
			{
				masdepartmenttype=(MasDepartmentType)masdepartmenttypeList.get(0);
				departmentList=session.createCriteria(MasDepartment.class).createAlias("DepartmentType","dt").add(Restrictions.eq("dt.Id", masdepartmenttype.getId())).list();
			}
			map.put("dutyExemptionList", dutyExemptionList);
			map.put("leaveMaintenanceList", leaveMaintenanceList);
			
			map.put("employeeList", employeeList);
			map.put("departmentList", departmentList);
			map.put("dutyTimeMasterList", dutyTimeMasterList);

			int pageno = 1;
			int numOfRows = 10;
			try
			{
				if (box.get("pageno")!=null)
				{
					pageno = Integer.parseInt(box.getString("pageno"));
				}
			}
			catch(Exception e)
			{
				//e.printStackTrace();
				pageno=1;
			}
			
			try
			{
				if (box.get("numOfRows")!=null)
				{
					numOfRows = Integer.parseInt(box.getString("numOfRows"));
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			map.put("pageno", pageno);
			
			int first = (pageno - 1) * numOfRows;
			int totalRecords = 0;
			if(employeeList != null && employeeList.size() > 0)
			{
				
				//String qry="SELECT count(*) FROM mas_employee";
				try
				{
					//totalRecords = Integer.parseInt(session.createSQLQuery(qry).list().get(0).toString());
					totalRecords = employeeList.size();
				}
				catch(Exception e)
				{
				totalRecords = 0;
				}
				map.put("totalRecords", totalRecords);

				
				double totalPages = 0.0;
				totalPages = (double)totalRecords/(double)numOfRows;
				Double d = new Double(Math.ceil(totalPages));
				map.put("totalPages", d.intValue());
				
			/*	Criteria c =session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).createAlias("Rank", "mr").add(Restrictions.le("mr.Id",rankList.get(0).getId()));
				c.setFirstResult(first);

				if (totalRecords < numOfRows)
					c.setMaxResults(totalRecords);
				else
					c.setMaxResults(numOfRows);
				
				employeeDetailList = c.list();
				*/
				String myQry = " select distinct result.employee_id, result.service_no, result.rankname, concat(result.first_name,' ',result.middle_name,' ',result.last_name) as name,result.department_id  ";
					myQry = myQry + "  from ( select distinct main.*,submain.emp_id,submain.duty_date,submain.type_status,if(submain.type_status ='Stand By',1,2) as ordertype from ";
					myQry = myQry + " (Select *,(select rank_name from mas_rank m where m.rank_id = me.rank_id) as rankname from mas_employee me where status = 'y' and rank_id <= (SELECT rank_id FROM mas_rank where rank_name = 'SGT')) as main";
					myQry = myQry + " left join (SELECT * FROM hr_duty_entry order by duty_date desc) as submain on main.employee_id = submain.emp_id";
					myQry = myQry + " order by submain.duty_date ) as result order by result.ordertype,result.duty_date, result.first_name";
					//System.out.println("myQry is : "+myQry);              
					Query query = session.createSQLQuery(myQry);
					                       query.setFirstResult(first);
					                       if (totalRecords < numOfRows)
					                    	   query.setMaxResults(totalRecords);
					       				   else
					       				    	query.setMaxResults(numOfRows);

					employeeDetailList = query.list();
					//System.out.println("employeeDetailList=="+employeeDetailList.size());
			}

			map.put("employeeDetailList",employeeDetailList);
			map.put("box", box);
		return map;
	}
	
	public Map<String, Object> getEmployeeDetailsForWardDuty(Box box) 
	{
		/*//System.out.println("first method called");
		PagedArray pagedArray = null;
		Session session = (Session)getSession();
		Map<String,Object>  map=new HashMap<String,Object>();
		List<MasEmployee> employeeList= new ArrayList<MasEmployee>();
		List<HrWardDutyEntry> dutyList = new ArrayList<HrWardDutyEntry>();
		Date fromDate=HMSUtil.convertStringTypeDateToDateType(box.get("fromDate"));
		Date toDate=HMSUtil.convertStringTypeDateToDateType(box.get("toDate"));
		
		session = (Session)getSession();
		//System.out.println("box ........." + box);

		try 
		{
			dutyList=session.createCriteria(HrWardDutyEntry.class).add(Restrictions.between("DutyDate", fromDate, toDate)).add(Restrictions.eq("Status", "y")).list();
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
		}
		map.put("dutyList", dutyList);
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);*/
		Map<String,Object>  map=new HashMap<String,Object>();
		map = getGridDataForWardEmployee(box);
		
		return map;
	}
	
	

	public Map<String, Object> getGridDataForWardEmployee(Box box) {
		// TODO Auto-generated method stub
		Session session = (Session)getSession();
		Map<String,Object>  map=new HashMap<String,Object>();
		Map<String,Object> utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		session = (Session)getSession();

		int id = 0;
		int deptId = 0;
		Date fromDate=new Date();
		Date toDate=new Date();
		if(!box.get("fromDate").equals(""))
			fromDate=HMSUtil.convertStringTypeDateToDateType(box.get("fromDate"));
		if(!box.get("toDate").equals(""))
			toDate=HMSUtil.convertStringTypeDateToDateType(box.get("toDate"));

		List<HrWardDutyEntry> employeeList = new ArrayList<HrWardDutyEntry>();
		List<HrWardDutyEntry> dutyEntryList = new ArrayList<HrWardDutyEntry>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<HrDutyTimeMaster> dutyMasterList = new ArrayList<HrDutyTimeMaster>();
		List<HrWardDutyEntry>wardDutyListForEntryNo=new ArrayList<HrWardDutyEntry>();
		List<MasDepartmentType> masdepartmenttypeList = new ArrayList<MasDepartmentType>();
		 MasDepartmentType masdepartmenttype = null;
		 masdepartmenttypeList=session.createCriteria(MasDepartmentType.class).add(Restrictions.eq("DepartmentTypeName","Ward Duty Locations")).list();
			if(masdepartmenttypeList.size()!=0)
			{
				masdepartmenttype=(MasDepartmentType)masdepartmenttypeList.get(0);
				departmentList=session.createCriteria(MasDepartment.class).createAlias("DepartmentType","dt").add(Restrictions.eq("dt.Id", masdepartmenttype.getId())).list();
			}
			employeeList=session.createCriteria(HrWardDutyEntry.class).add(Restrictions.between("DutyDate", fromDate, toDate)).add(Restrictions.eq("Status","y")).list();
			//departmentList=session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
			dutyMasterList=session.createCriteria(HrDutyTimeMaster.class).add(Restrictions.eq("Status", "y")).list();
			wardDutyListForEntryNo=session.createCriteria(HrWardDutyEntry.class).add(Restrictions.eq("Status", "y")).list();
			Set<String> wardDutySetForEntryNoSet=new TreeSet<String>();
			for(HrWardDutyEntry hrWardDutyEntry:wardDutyListForEntryNo){
				wardDutySetForEntryNoSet.add(hrWardDutyEntry.getEntryNo());
			}

			map.put("wardDutySetForEntryNoSet",wardDutySetForEntryNoSet);
			map.put("employeeList", employeeList);
			map.put("departmentList", departmentList);
			map.put("dutyMasterList", dutyMasterList);
			int pageno = 1;
			int numOfRows = 10;
			try
			{
				if (box.get("pageno")!=null && !box.get("pageno").equals(""))
				{
					pageno = Integer.parseInt(box.getString("pageno"));
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				pageno=1;
			}
			
			
			try
			{
				if (box.get("numOfRows")!=null)
				{
					numOfRows = Integer.parseInt(box.getString("numOfRows"));
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			map.put("pageno", pageno);
			
			int first = (pageno - 1) * numOfRows;
			int totalRecords = 0;
			if(employeeList != null && employeeList.size() > 0)
			{
				
				try
				{
					totalRecords = employeeList.size();
				}
				catch(Exception e)
				{
				totalRecords = 0;
				}
				map.put("totalRecords", totalRecords);

				
				double totalPages = 0.0;
				totalPages = (double)totalRecords/(double)numOfRows;
				Double d = new Double(Math.ceil(totalPages));
				map.put("totalPages", d.intValue());
				
				Criteria c =session.createCriteria(HrWardDutyEntry.class).add(Restrictions.between("DutyDate", fromDate, toDate)).add(Restrictions.eq("Status","y")); 
				c.setFirstResult(first);

				if (totalRecords < numOfRows)
					c.setMaxResults(totalRecords);
				else
					c.setMaxResults(numOfRows);
				
				dutyEntryList = c.list();
			}
			List<HrDutyMaster> dutyList = new ArrayList<HrDutyMaster>();
			String entryNo="";
			try {
				dutyList = session.createCriteria(HrDutyMaster.class).add(Restrictions.eq("DutyName", "Ward Duty")).add(Restrictions.eq("Status", "y")).list();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(dutyList.size()!=0)
			{
			map.put("dutyId", dutyList.get(0).getId());
			}
			entryNo=getEntrySeqForWardDutyDisplay();
			map.put("entryNo",entryNo);
			map.put("dutyEntryList",dutyEntryList);
			map.put("box", box);
		return map;
	}
	
	public boolean AddWardDutyEntry(Box box){
		boolean successfullyAdded=false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		Session session=(Session)getSession();
		
		String empName="";
		Vector empId=box.getVector("employeeId");
		Vector dutyDate=box.getVector("nextDutyDate");
		Vector dutyTime=box.getVector("dutyTimeId");
		Vector employeeAdded=box.getVector("employeeToBeAdded");
		Vector departmenttype=box.getVector("Location");
		List<TransactionSequence>entryNoList=new ArrayList<TransactionSequence>();
		String tableNameForTransactionSequence="HrWardDutyEntry";
		Vector typeStatus=box.getVector("typeStatus");

		try {
		
			for(int i=0;i<empId.size();i++)
			{
				if(employeeAdded.contains(empId.get(i)))
				{
					HrWardDutyEntry hrWardDutyEntry=new HrWardDutyEntry();
					
					hrWardDutyEntry.setEntryNo(box.getString("entryNo"));
					hrWardDutyEntry.setEntryDate(HMSUtil.convertStringTypeDateToDateType(box.getString("entryDate")));
					hrWardDutyEntry.setTypeStatus(typeStatus.get(i).toString());
					hrWardDutyEntry.setStatus("w");
					
					HrDutyMaster hrDutyMaster=new HrDutyMaster();
					hrDutyMaster.setId(box.getInt("dutyId"));
					hrWardDutyEntry.setDuty(hrDutyMaster);
					
					if(empId.get(i)!=null && !empId.get(i).equals(""))
					{
						MasEmployee masEmployee=new MasEmployee();
						masEmployee.setId(Integer.parseInt(empId.get(i).toString()));
						hrWardDutyEntry.setEmp(masEmployee);
					}
					if(departmenttype.get(i)!=null && !departmenttype.get(i).equals(""))
					{
						MasDepartment masdepartment=new MasDepartment();
						masdepartment.setId(Integer.parseInt(departmenttype.get(i).toString()));
						hrWardDutyEntry.setDepartmentId(masdepartment);
					}
					
					if(dutyDate.get(i)!=null )
					{
						hrWardDutyEntry.setDutyDate(HMSUtil.convertStringTypeDateToDateType((dutyDate.get(i).toString())));
					}
					if(dutyDate.get(i)!=null )
					{
						hrWardDutyEntry.setDutyDate(HMSUtil.convertStringTypeDateToDateType((dutyDate.get(i).toString())));
						if((HMSUtil.convertStringTypeDateToDateType((dutyDate.get(i).toString())).getDay())==0){
							hrWardDutyEntry.setHolidayStatus("y");
						}else{
							hrWardDutyEntry.setHolidayStatus("n");
						}
						
					}
					if(dutyTime.get(i)!=null && !dutyTime.get(i).equals(""))
					{
						HrDutyTimeMaster hrDutyTimeMaster=new HrDutyTimeMaster();
						hrDutyTimeMaster.setId(Integer.parseInt(dutyTime.get(i).toString()));
						hrWardDutyEntry.setDutyTime(hrDutyTimeMaster);
					}
							
					if(box.getString("changedBy")!=null && !box.getString("changedBy").equals(""))
					{
						hrWardDutyEntry.setLastChgBy(box.getString("changedBy"));
					}
					
					if(box.getString("changedDate")!=null && !box.getString("changedDate").equals(""))
					{
						hrWardDutyEntry.setLastChgDate(HMSUtil.convertStringTypeDateToDateType((box.getString("changedDate"))));
					}
					
					if(box.getString("changedTime")!=null && !box.getString("changedTime").equals(""))
					{
						hrWardDutyEntry.setLastChgTime(box.getString("changedTime"));
					}
					
					MasHospital masHospital=new MasHospital();
					masHospital.setId(box.getInt("hospitalId"));
					hrWardDutyEntry.setHospital(masHospital);
					
						hbt.save(hrWardDutyEntry);
			
				}
			
			}
			entryNoList=session.createCriteria(TransactionSequence.class).add(Restrictions.eq("Tablename", tableNameForTransactionSequence)).list();
			TransactionSequence transactionSequence=(TransactionSequence)entryNoList.get(0);
			int id=transactionSequence.getId();
			int entryNo=transactionSequence.getTransactionSequenceNumber();
			entryNo=entryNo+1;
			TransactionSequence transactionSequenceObj=(TransactionSequence)hbt.load(TransactionSequence.class, id);
			transactionSequenceObj.setTransactionSequenceNumber(entryNo);
			hbt.update(transactionSequenceObj);
			
		} catch (Exception e) {
			successfullyAdded = false;
			e.printStackTrace();
		} 
		
				
			successfullyAdded = true;
		
			return successfullyAdded;
	}
	
	public Map<String, Object> getWardEmployeeLastDutyDetails(Box box) 
	{
		PagedArray pagedArray = null;
		Session session = (Session)getSession();
		Map<String,Object>  map=new HashMap<String,Object>();
		List<MasEmployee> employeeList= new ArrayList<MasEmployee>();
		List<MasDepartment>departmentList=new ArrayList<MasDepartment>();
		List<HrDutyTimeMaster>dutyTimeMasterList=new ArrayList<HrDutyTimeMaster>();
		List<HrWardDutyEntry>dutyEntryList=new ArrayList<HrWardDutyEntry>();
		List<MasDepartmentType> masdepartmenttypeList = new ArrayList<MasDepartmentType>();
	    MasDepartmentType masdepartmenttype = null;
		session = (Session)getSession();
		try 
		{
			masdepartmenttypeList=session.createCriteria(MasDepartmentType.class).add(Restrictions.eq("DepartmentTypeName","Gaurd Duty Locations")).list();
			if(masdepartmenttypeList.size()!=0)
			{
				masdepartmenttype=(MasDepartmentType)masdepartmenttypeList.get(0);
				departmentList=session.createCriteria(MasDepartment.class).createAlias("DepartmentType","dt").add(Restrictions.eq("dt.Id", masdepartmenttype.getId())).list();
			}
			employeeList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
			//departmentList=session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
			dutyTimeMasterList=session.createCriteria(HrDutyTimeMaster.class).add(Restrictions.eq("Status", "y")).list();
			dutyEntryList=session.createCriteria(HrWardDutyEntry.class).createAlias("Emp", "me").add(Restrictions.eq("me.Id",Integer.parseInt(box.getString("empData")))).list();
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
		}
		map.put("employeeList", employeeList);
		map.put("departmentList", departmentList);
		map.put("dutyTimeMasterList", dutyTimeMasterList);
		map.put("dutyEntryList", dutyEntryList);
		map = getGridDataForWardLastDuty(box);
		
		return map;
	}
	public Map<String, Object> getGridDataForWardLastDuty(Box box) {
		Session session = (Session)getSession();
		Map<String,Object>  map=new HashMap<String,Object>();
		Map<String,Object> utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		session = (Session)getSession();

		int id = 0;

		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;  
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;

		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasEmployee> employeeDetailList = new ArrayList<MasEmployee>();
		List<MasDepartment>departmentList=new ArrayList<MasDepartment>();
		List<HrDutyTimeMaster>dutyTimeMasterList=new ArrayList<HrDutyTimeMaster>();
		List<HrWardDutyEntry>dutyEntryList=new ArrayList<HrWardDutyEntry>();
		List<HrLeaveMaintenance>employeeLeaveList=new ArrayList<HrLeaveMaintenance>();
		List<OpdHoliday>holidayList=new ArrayList<OpdHoliday>();		
		List<MasRank>rankList=new ArrayList<MasRank>();
		
			rankList=session.createCriteria(MasRank.class).add(Restrictions.eq("RankName", "SGT")).list();
			employeeList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).createAlias("Rank", "mr").add(Restrictions.le("mr.Id", rankList.get(0).getId())).list();
			departmentList=session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
			dutyTimeMasterList=session.createCriteria(HrDutyTimeMaster.class).add(Restrictions.eq("Status", "y")).list();
			dutyEntryList=session.createCriteria(HrWardDutyEntry.class).createAlias("Emp", "me").add(Restrictions.eq("me.Id",Integer.parseInt(box.getString("empData")))).list();
			employeeLeaveList=session.createCriteria(HrLeaveMaintenance.class).createAlias("Employee", "me").add(Restrictions.eq("me.Id",Integer.parseInt(box.getString("empData")))).list();
			//System.out.println("employeeLeaveList.size()employeeLeaveList.size() in controller "+employeeLeaveList.size());
			holidayList=session.createCriteria(OpdHoliday.class).add(Restrictions.eq("Status", "y")).list();
			
			map.put("employeeList", employeeList);
			map.put("departmentList", departmentList);
			map.put("dutyTimeMasterList", dutyTimeMasterList);
			map.put("dutyEntryList", dutyEntryList);
			map.put("employeeLeaveList", employeeLeaveList);
			map.put("holidayList", holidayList);

			int pageno = 1;
			int numOfRows = 10;
			try
			{
				if (box.get("pageno")!=null)
				{
					pageno = Integer.parseInt(box.getString("pageno"));
				}
			}
			catch(Exception e)
			{
				//e.printStackTrace();
				pageno=1;
			}
			
			try
			{
				if (box.get("numOfRows")!=null)
				{
					numOfRows = Integer.parseInt(box.getString("numOfRows"));
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			map.put("pageno", pageno);
			
			int first = (pageno - 1) * numOfRows;
			int totalRecords = 0;
			if(employeeList != null && employeeList.size() > 0)
			{
				
				String qry="SELECT count(*) FROM mas_employee";
				try
				{
					totalRecords = employeeList.size();
				}
				catch(Exception e)
				{
				totalRecords = 0;
				}
				map.put("totalRecords", totalRecords);

				
				double totalPages = 0.0;
				totalPages = (double)totalRecords/(double)numOfRows;
				Double d = new Double(Math.ceil(totalPages));
				map.put("totalPages", d.intValue());
				
				Criteria c =session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).createAlias("Rank", "mr").add(Restrictions.le("mr.Id", rankList.get(0).getId())); 
				c.setFirstResult(first);

				if (totalRecords < numOfRows)
					c.setMaxResults(totalRecords);
				else
					c.setMaxResults(numOfRows);
				
				employeeDetailList = c.list();
			}

			map.put("employeeDetailList",employeeDetailList);
			map.put("box", box);
		return map;
	}
	
	public boolean updateWardDutyEntry(Box box){
		boolean successfullyAdded=false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		String empName="";
		Vector dutyId=box.getVector("wardDutyId");
		Vector deptId=box.getVector("department");
		Vector dutyDate=box.getVector("nextDutyDate");
		Vector dutyTime=box.getVector("dutyTime");
		Vector remarks=box.getVector("remarks");
		Vector dutyToBeUpdated=box.getVector("dutyToBeUpdated");
		
		try {
		
		for(int i=0;i<dutyId.size();i++)
		{
			if(dutyToBeUpdated.contains(dutyId.get(i)))
			{
				HrWardDutyEntry hrWardDutyEntry=(HrWardDutyEntry) hbt.load(HrWardDutyEntry.class, Integer.parseInt(dutyId.get(i).toString()));
					
					
					if(dutyDate.get(i)!=null && !dutyDate.get(i).equals(""))
					{
						hrWardDutyEntry.setDutyDate(HMSUtil.convertStringTypeDateToDateType((dutyDate.get(i).toString())));
					}
					
					if(dutyTime.get(i)!=null && !dutyTime.get(i).equals(""))
					{
						HrDutyTimeMaster hrDutyTimeMaster=new HrDutyTimeMaster();
						hrDutyTimeMaster.setId(Integer.parseInt(dutyTime.get(i).toString()));
						hrWardDutyEntry.setDutyTime(hrDutyTimeMaster);
					}
						hbt.update(hrWardDutyEntry);
						hbt.refresh(hrWardDutyEntry);
				}
			}
		} catch (Exception e) {
			successfullyAdded = false;
			e.printStackTrace();
		} 
		
				
			successfullyAdded = true;
		
			return successfullyAdded;
	}

	/**
	 * -------------------------- Orderly Duty Entry -------------------
	 * Started on 1st June '09
	 */

	public Map<String, Object> getEmployeeDetailsForOrderlyDutyAdd(Box box) 
	{
		/*PagedArray pagedArray = null;
		Session session = (Session)getSession();
		Map<String,Object>  map=new HashMap<String,Object>();
		List<MasEmployee> employeeList= new ArrayList<MasEmployee>();
		List<MasDepartment>departmentList=new ArrayList<MasDepartment>();
		List<HrDutyTimeMaster>dutyTimeMasterList=new ArrayList<HrDutyTimeMaster>();
		List<MasRank>rankList=new ArrayList<MasRank>();
		session = (Session)getSession();

		try 
		{
			rankList=session.createCriteria(MasRank.class).add(Restrictions.eq("RankName", "SGT")).list();
			employeeList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).createAlias("Rank", "mr").add(Restrictions.eq("mr.Id",rankList.get(0).getId())).list();
			departmentList=session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
			dutyTimeMasterList=session.createCriteria(HrDutyTimeMaster.class).add(Restrictions.eq("Status", "y")).list();
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
		}
		map.put("employeeList", employeeList);
		map.put("departmentList", departmentList);
		map.put("dutyTimeMasterList", dutyTimeMasterList);*/
		Map<String,Object>  map=new HashMap<String,Object>();
		map = getGridDataForOrderlyEmployeeAdd(box);
		
		return map;
	}
	
	public Map<String, Object> getGridDataForOrderlyEmployeeAdd(Box box) {
		Session session = (Session)getSession();
		Map<String,Object>  map=new HashMap<String,Object>();
		Map<String,Object> utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		session = (Session)getSession();

		int id = 0;

		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;  
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;

		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasEmployee> employeeDetailList = new ArrayList<MasEmployee>();
		List<MasDepartment>departmentList=new ArrayList<MasDepartment>();
		List<MasRank>rankList=new ArrayList<MasRank>();
		List<HrDutyTimeMaster>dutyTimeMasterList=new ArrayList<HrDutyTimeMaster>();
		List<HrLeaveMaintenance>leaveMaintenanceList=new ArrayList<HrLeaveMaintenance>();
		List<HrDutyExemptionEntry>dutyExemptionList=new ArrayList<HrDutyExemptionEntry>();
		List<MasDepartmentType> masdepartmenttypeList = new ArrayList<MasDepartmentType>();
		MasDepartmentType masdepartmenttype = null;
		masdepartmenttypeList=session.createCriteria(MasDepartmentType.class).add(Restrictions.eq("DepartmentTypeName","Orderly Duty Locations")).list();
		if(masdepartmenttypeList.size()!=0)
		{
			masdepartmenttype=(MasDepartmentType)masdepartmenttypeList.get(0);
			departmentList=session.createCriteria(MasDepartment.class).createAlias("DepartmentType","dt").add(Restrictions.eq("dt.Id", masdepartmenttype.getId())).list();
		}
			rankList=session.createCriteria(MasRank.class).add(Restrictions.eq("RankName", "SGT")).list();
			employeeList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).createAlias("Rank", "mr").add(Restrictions.eq("mr.Id",rankList.get(0).getId())).list();
			//departmentList=session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
			dutyTimeMasterList=session.createCriteria(HrDutyTimeMaster.class).add(Restrictions.eq("Status", "y")).list();
			leaveMaintenanceList=session.createCriteria(HrLeaveMaintenance.class).list();
			dutyExemptionList=session.createCriteria(HrDutyExemptionEntry.class).createAlias("Duty", "d").add(Restrictions.eq("d.DutyName", "Orderly Duty")).list();
			
			map.put("dutyExemptionList", dutyExemptionList);
			map.put("leaveMaintenanceList", leaveMaintenanceList);
			map.put("employeeList", employeeList);
			map.put("departmentList", departmentList);
			map.put("dutyTimeMasterList", dutyTimeMasterList);

			int pageno = 1;
			int numOfRows = 10;
			try
			{
				if (box.get("pageno")!=null)
				{
					pageno = Integer.parseInt(box.getString("pageno"));
				}
			}
			catch(Exception e)
			{
				//e.printStackTrace();
				pageno=1;
			}
			
			try
			{
				if (box.get("numOfRows")!=null)
				{
					numOfRows = Integer.parseInt(box.getString("numOfRows"));
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			map.put("pageno", pageno);
			
			int first = (pageno - 1) * numOfRows;
			int totalRecords = 0;
			if(employeeList != null && employeeList.size() > 0)
			{
				
				//String qry="SELECT count(*) FROM mas_employee";
				try
				{
					//totalRecords = Integer.parseInt(session.createSQLQuery(qry).list().get(0).toString());
					totalRecords = employeeList.size();
				}
				catch(Exception e)
				{
				totalRecords = 0;
				}
				map.put("totalRecords", totalRecords);

				
				double totalPages = 0.0;
				totalPages = (double)totalRecords/(double)numOfRows;
				Double d = new Double(Math.ceil(totalPages));
				map.put("totalPages", d.intValue());
				
//				Criteria c =session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).createAlias("Rank", "mr").add(Restrictions.eq("mr.Id",rankList.get(0).getId()));
//				c.setFirstResult(first);
//
//				if (totalRecords < numOfRows)
//					c.setMaxResults(totalRecords);
//				else
//					c.setMaxResults(numOfRows);
//				
//				employeeDetailList = c.list();
				
				String myQry = " select distinct result.employee_id, result.service_no, result.rankname, concat(result.first_name,' ',result.middle_name,' ',result.last_name) as name,result.department_id  ";
				myQry = myQry + "  from (select distinct main.*,submain.emp_id,submain.duty_date,submain.type_status,if(submain.type_status ='Stand By',1,2) as ordertype from ";
				myQry = myQry + " (Select *,(select rank_name from mas_rank m where m.rank_id = me.rank_id) as rankname from mas_employee me where status = 'y' and rank_id <= (SELECT rank_id FROM mas_rank where rank_name = 'SGT')) as main";
				myQry = myQry + " left join (SELECT * FROM hr_duty_entry order by duty_date desc) as submain on main.employee_id = submain.emp_id";
				myQry = myQry + " order by submain.duty_date ) as result order by result.ordertype,result.duty_date, result.first_name";
				//System.out.println("myQry -- : "+myQry);              
				Query query = session.createSQLQuery(myQry);
				                       query.setFirstResult(first);
				                       if (totalRecords < numOfRows)
				                    	   query.setMaxResults(totalRecords);
				       				   else
				       				    	query.setMaxResults(numOfRows);

				employeeDetailList = query.list();
				//System.out.println("employeeDetailList in Ds-- "+employeeDetailList.size());
			}

			map.put("employeeDetailList",employeeDetailList);
			map.put("box", box);
		return map;
	}
	
	public Map<String, Object> getEmployeeDetailsForOrderlyDuty(Box box) 
	{
		//System.out.println("first method called");
		PagedArray pagedArray = null;
		Session session = (Session)getSession();
		Map<String,Object>  map=new HashMap<String,Object>();
		List<MasEmployee> employeeList= new ArrayList<MasEmployee>();
		List<MasDepartment>departmentList=new ArrayList<MasDepartment>();
		List<HrOrderlyDutyEntry> dutyList = new ArrayList<HrOrderlyDutyEntry>();
		Date fromDate=HMSUtil.convertStringTypeDateToDateType(box.get("fromDate"));
		Date toDate=HMSUtil.convertStringTypeDateToDateType(box.get("toDate"));
		
		session = (Session)getSession();

		try 
		{
			dutyList=session.createCriteria(HrOrderlyDutyEntry.class).add(Restrictions.between("DutyDate", fromDate, toDate)).add(Restrictions.eq("Status", "y")).list();
			departmentList=session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
		}
		map.put("dutyList", dutyList);
		map.put("departmentList", departmentList);
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		
		map = getGridDataForOrderlyEmployee(box);
		
		return map;
	}
	
	

	public Map<String, Object> getGridDataForOrderlyEmployee(Box box) {
		// TODO Auto-generated method stub
		Session session = (Session)getSession();
		Map<String,Object>  map=new HashMap<String,Object>();
		Map<String,Object> utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		session = (Session)getSession();

		int id = 0;
		int deptId = 0;
		Date fromDate=new Date();
		Date toDate=new Date();
		if(!box.get("fromDate").equals(""))
			fromDate=HMSUtil.convertStringTypeDateToDateType(box.get("fromDate"));
		if(!box.get("toDate").equals(""))
			toDate=HMSUtil.convertStringTypeDateToDateType(box.get("toDate"));

		List<HrOrderlyDutyEntry> employeeList = new ArrayList<HrOrderlyDutyEntry>();
		List<HrOrderlyDutyEntry> dutyEntryList = new ArrayList<HrOrderlyDutyEntry>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<HrDutyTimeMaster> dutyMasterList = new ArrayList<HrDutyTimeMaster>();
		List<HrOrderlyDutyEntry>orderlyDutyListForEntryNo=new ArrayList<HrOrderlyDutyEntry>();
			employeeList=session.createCriteria(HrOrderlyDutyEntry.class).add(Restrictions.between("DutyDate", fromDate, toDate)).add(Restrictions.eq("Status","y")).list();
			departmentList=session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
			dutyMasterList=session.createCriteria(HrDutyTimeMaster.class).add(Restrictions.eq("Status", "y")).list();
			orderlyDutyListForEntryNo=session.createCriteria(HrOrderlyDutyEntry.class).add(Restrictions.eq("Status", "y")).list();
			Set<String> orderlyDutySetForEntryNoSet=new TreeSet<String>();
			for(HrOrderlyDutyEntry hrOrderlyDutyEntry:orderlyDutyListForEntryNo){
				orderlyDutySetForEntryNoSet.add(hrOrderlyDutyEntry.getEntryNo());
			}

			map.put("employeeList", employeeList);
			map.put("departmentList", departmentList);
			map.put("dutyMasterList", dutyMasterList);
			map.put("orderlyDutySetForEntryNoSet",orderlyDutySetForEntryNoSet);
			int pageno = 1;
			int numOfRows = 10;
			try
			{
				if (box.get("pageno")!=null && !box.get("pageno").equals(""))
				{
					pageno = Integer.parseInt(box.getString("pageno"));
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				pageno=1;
			}
			
			
			try
			{
				if (box.get("numOfRows")!=null)
				{
					numOfRows = Integer.parseInt(box.getString("numOfRows"));
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			map.put("pageno", pageno);
			
			int first = (pageno - 1) * numOfRows;
			int totalRecords = 0;
			if(employeeList != null && employeeList.size() > 0)
			{
				
				try
				{
					totalRecords = employeeList.size();
				}
				catch(Exception e)
				{
				totalRecords = 0;
				}
				map.put("totalRecords", totalRecords);

				
				double totalPages = 0.0;
				totalPages = (double)totalRecords/(double)numOfRows;
				Double d = new Double(Math.ceil(totalPages));
				map.put("totalPages", d.intValue());
				
				Criteria c =session.createCriteria(HrOrderlyDutyEntry.class).add(Restrictions.between("DutyDate", fromDate, toDate)).add(Restrictions.eq("Status","y")); 
				c.setFirstResult(first);

				if (totalRecords < numOfRows)
					c.setMaxResults(totalRecords);
				else
					c.setMaxResults(numOfRows);
				
				dutyEntryList = c.list();
			}
			List<HrDutyMaster> dutyList = new ArrayList<HrDutyMaster>();
			String entryNo="";
			try {
				dutyList = session.createCriteria(HrDutyMaster.class).add(Restrictions.eq("DutyName", "Orderly Duty")).add(Restrictions.eq("Status", "y")).list();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(dutyList.size()!=0)
			{
			map.put("dutyId", dutyList.get(0).getId());
			}
			entryNo=getEntrySeqForOrderlyDutyDisplay();
			map.put("entryNo",entryNo);
			map.put("dutyEntryList",dutyEntryList);
			map.put("box", box);
		return map;
	}
	
	public boolean AddOrderlyDutyEntry(Box box){
		boolean successfullyAdded=false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		Session session=(Session)getSession();
		
		Vector empId=box.getVector("employeeId");
		//Vector deptId=box.getVector("department");
		Vector departmenttype=box.getVector("Location");
		Vector dutyDate=box.getVector("nextDutyDate");
		Vector dutyTime=box.getVector("dutyTimeId");
		Vector remarks=box.getVector("remarks");
		Vector employeeAdded=box.getVector("employeeToBeAdded");
		
		List<TransactionSequence>entryNoList=new ArrayList<TransactionSequence>();
		String tableNameForTransactionSequence="HrOrderlyDutyEntry";
		Vector typeStatus=box.getVector("typeStatus");
		
		try {
		
			for(int i=0;i<empId.size();i++)
			{
				if(employeeAdded.contains(empId.get(i)))
				{
					HrOrderlyDutyEntry hrOrderlyDutyEntry=new HrOrderlyDutyEntry();
					
					hrOrderlyDutyEntry.setEntryNo(box.getString("entryNo"));
					hrOrderlyDutyEntry.setEntryDate(HMSUtil.convertStringTypeDateToDateType(box.getString("entryDate")));
					hrOrderlyDutyEntry.setTypeStatus(typeStatus.get(i).toString());
					hrOrderlyDutyEntry.setStatus("w");
					
					HrDutyMaster hrDutyMaster=new HrDutyMaster();
					hrDutyMaster.setId(box.getInt("dutyId"));
					hrOrderlyDutyEntry.setDuty(hrDutyMaster);
					
					if(empId.get(i)!=null && !empId.get(i).equals(""))
					{
						MasEmployee masEmployee=new MasEmployee();
						masEmployee.setId(Integer.parseInt(empId.get(i).toString()));
						hrOrderlyDutyEntry.setEmp(masEmployee);
					}
					
					
					if(dutyDate.get(i)!=null )
					{
						hrOrderlyDutyEntry.setDutyDate(HMSUtil.convertStringTypeDateToDateType((dutyDate.get(i).toString())));
					}
					/*if(deptId.get(i)!=null && !deptId.get(i).equals("0"))
					{
						MasDepartment masDepartment=new MasDepartment();
						masDepartment.setId(Integer.parseInt(deptId.get(i).toString()));
						hrOrderlyDutyEntry.setDepartment(masDepartment);
					}*/
					if(departmenttype.get(i)!=null && !departmenttype.get(i).equals(""))
					{
						MasDepartment masdepartment=new MasDepartment();
						masdepartment.setId(Integer.parseInt(departmenttype.get(i).toString()));
						hrOrderlyDutyEntry.setDepartmentId(masdepartment);
					}

					if(dutyDate.get(i)!=null )
					{
						hrOrderlyDutyEntry.setDutyDate(HMSUtil.convertStringTypeDateToDateType((dutyDate.get(i).toString())));
						if((HMSUtil.convertStringTypeDateToDateType((dutyDate.get(i).toString())).getDay())==0){
							hrOrderlyDutyEntry.setHolidayStatus("y");
						}else{
							hrOrderlyDutyEntry.setHolidayStatus("n");
						}
						
					}
					if(remarks.get(i)!=null )
					{
						hrOrderlyDutyEntry.setRemarks(remarks.get(i).toString());
					}
					if(dutyTime.get(i)!=null && !dutyTime.get(i).equals(""))
					{
						HrDutyTimeMaster hrDutyTimeMaster=new HrDutyTimeMaster();
						hrDutyTimeMaster.setId(Integer.parseInt(dutyTime.get(i).toString()));
						hrOrderlyDutyEntry.setDutyTime(hrDutyTimeMaster);
					}
							
					if(box.getString("changedBy")!=null && !box.getString("changedBy").equals(""))
					{
						hrOrderlyDutyEntry.setLastChgBy(box.getString("changedBy"));
					}
					
					if(box.getString("changedDate")!=null && !box.getString("changedDate").equals(""))
					{
						hrOrderlyDutyEntry.setLastChgDate(HMSUtil.convertStringTypeDateToDateType((box.getString("changedDate"))));
					}
					
					if(box.getString("changedTime")!=null && !box.getString("changedTime").equals(""))
					{
						hrOrderlyDutyEntry.setLastChgTime(box.getString("changedTime"));
					}
					
					MasHospital masHospital=new MasHospital();
					masHospital.setId(box.getInt("hospitalId"));
					hrOrderlyDutyEntry.setHospital(masHospital);
					
						hbt.save(hrOrderlyDutyEntry);
			
				}
			
			}
			entryNoList=session.createCriteria(TransactionSequence.class).add(Restrictions.eq("Tablename", tableNameForTransactionSequence)).list();
			TransactionSequence transactionSequence=(TransactionSequence)entryNoList.get(0);
			int id=transactionSequence.getId();
			int entryNo=transactionSequence.getTransactionSequenceNumber();
			entryNo=entryNo+1;
			TransactionSequence transactionSequenceObj=(TransactionSequence)hbt.load(TransactionSequence.class, id);
			transactionSequenceObj.setTransactionSequenceNumber(entryNo);
			hbt.update(transactionSequenceObj);
			
		} catch (Exception e) {
			successfullyAdded = false;
			e.printStackTrace();
		} 
		
				
			successfullyAdded = true;
		
			return successfullyAdded;
	}
	
	public Map<String, Object> getOrderlyEmployeeLastDutyDetails(Box box) 
	{
		/*PagedArray pagedArray = null;
		Session session = (Session)getSession();
		Map<String,Object>  map=new HashMap<String,Object>();
		List<MasEmployee> employeeList= new ArrayList<MasEmployee>();
		List<MasDepartment>departmentList=new ArrayList<MasDepartment>();
		List<HrDutyTimeMaster>dutyTimeMasterList=new ArrayList<HrDutyTimeMaster>();
		List<HrOrderlyDutyEntry>dutyEntryList=new ArrayList<HrOrderlyDutyEntry>();
		
		session = (Session)getSession();
		try 
		{
			employeeList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
			departmentList=session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
			dutyTimeMasterList=session.createCriteria(HrDutyTimeMaster.class).add(Restrictions.eq("Status", "y")).list();
			dutyEntryList=session.createCriteria(HrOrderlyDutyEntry.class).createAlias("Emp", "me").add(Restrictions.eq("me.Id",Integer.parseInt(box.getString("empData")))).list();
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
		}
		map.put("employeeList", employeeList);
		map.put("departmentList", departmentList);
		map.put("dutyTimeMasterList", dutyTimeMasterList);
		map.put("dutyEntryList", dutyEntryList);*/
		Map<String,Object>  map=new HashMap<String,Object>();
		map = getGridDataForOrderlyLastDuty(box);
		
		return map;
	}
	public Map<String, Object> getGridDataForOrderlyLastDuty(Box box) {
		Session session = (Session)getSession();
		Map<String,Object>  map=new HashMap<String,Object>();
		Map<String,Object> utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		session = (Session)getSession();

		int id = 0;

		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;  
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;

		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasEmployee> employeeDetailList = new ArrayList<MasEmployee>();
		List<MasDepartment>departmentList=new ArrayList<MasDepartment>();
		List<HrDutyTimeMaster>dutyTimeMasterList=new ArrayList<HrDutyTimeMaster>();
		List<HrOrderlyDutyEntry>dutyEntryList=new ArrayList<HrOrderlyDutyEntry>();
		List<HrLeaveMaintenance>employeeLeaveList=new ArrayList<HrLeaveMaintenance>();
		List<OpdHoliday>holidayList=new ArrayList<OpdHoliday>();
		List<MasRank>rankList=new ArrayList<MasRank>();
		List<MasDepartmentType> masdepartmenttypeList = new ArrayList<MasDepartmentType>();
		MasDepartmentType masdepartmenttype = null;
		masdepartmenttypeList=session.createCriteria(MasDepartmentType.class).add(Restrictions.eq("DepartmentTypeName","Orderly Duty Locations")).list();
		if(masdepartmenttypeList.size()!=0)
		{
			masdepartmenttype=(MasDepartmentType)masdepartmenttypeList.get(0);
			departmentList=session.createCriteria(MasDepartment.class).createAlias("DepartmentType","dt").add(Restrictions.eq("dt.Id", masdepartmenttype.getId())).list();
		}
		
			rankList=session.createCriteria(MasRank.class).add(Restrictions.eq("RankName", "SGT")).list();
			employeeList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).createAlias("Rank", "mr").add(Restrictions.eq("mr.Id", rankList.get(0).getId())).list();
			//departmentList=session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
			dutyTimeMasterList=session.createCriteria(HrDutyTimeMaster.class).add(Restrictions.eq("Status", "y")).list();
			dutyEntryList=session.createCriteria(HrOrderlyDutyEntry.class).createAlias("Emp", "me").add(Restrictions.eq("me.Id",Integer.parseInt(box.getString("empData")))).list();
			employeeLeaveList=session.createCriteria(HrLeaveMaintenance.class).createAlias("Employee", "me").add(Restrictions.eq("me.Id",Integer.parseInt(box.getString("empData")))).list();
			holidayList=session.createCriteria(OpdHoliday.class).add(Restrictions.eq("Status", "y")).list();
			
			map.put("employeeList", employeeList);
			map.put("departmentList", departmentList);
			map.put("dutyTimeMasterList", dutyTimeMasterList);
			map.put("dutyEntryList", dutyEntryList);
			map.put("employeeLeaveList", employeeLeaveList);
			map.put("holidayList", holidayList);

			int pageno = 1;
			int numOfRows = 10;
			try
			{
				if (box.get("pageno")!=null)
				{
					pageno = Integer.parseInt(box.getString("pageno"));
				}
			}
			catch(Exception e)
			{
				//e.printStackTrace();
				pageno=1;
			}
			
			try
			{
				if (box.get("numOfRows")!=null)
				{
					numOfRows = Integer.parseInt(box.getString("numOfRows"));
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			map.put("pageno", pageno);
			
			int first = (pageno - 1) * numOfRows;
			int totalRecords = 0;
			if(employeeList != null && employeeList.size() > 0)
			{
				try
				{
					totalRecords = employeeList.size();
				}
				catch(Exception e)
				{
				totalRecords = 0;
				}
				map.put("totalRecords", totalRecords);

				
				double totalPages = 0.0;
				totalPages = (double)totalRecords/(double)numOfRows;
				Double d = new Double(Math.ceil(totalPages));
				map.put("totalPages", d.intValue());
				
				String myQry = " select distinct result.employee_id, result.service_no, result.rankname, concat(result.first_name,' ',result.middle_name,' ',result.last_name) as name,result.department_id  ";
			    myQry = myQry + "  from (select distinct main.*,submain.emp_id,submain.duty_date,submain.type_status,if(submain.type_status ='Stand By',1,2) as ordertype from ";
                myQry = myQry + " (Select *,(select rank_name from mas_rank m where m.rank_id = me.rank_id) as rankname from mas_employee me where status = 'y' and rank_id <= (SELECT rank_id FROM mas_rank where rank_name = 'SGT')) as main";
                myQry = myQry + " left join (SELECT * FROM hr_duty_entry order by duty_date desc) as submain on main.employee_id = submain.emp_id";
                myQry = myQry + " order by submain.duty_date ) as result order by result.ordertype,result.duty_date, result.first_name";
                
                Query query = session.createSQLQuery(myQry);
               
                query.setFirstResult(first);
               
                if (totalRecords < numOfRows)
             	   query.setMaxResults(totalRecords);
				   else
				    query.setMaxResults(numOfRows);
				/*Criteria c =session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).createAlias("Rank", "mr").add(Restrictions.eq("mr.Id", rankList.get(0).getId())); 
				c.setFirstResult(first);

				if (totalRecords < numOfRows)
					c.setMaxResults(totalRecords);
				else
					c.setMaxResults(numOfRows);
				*/
				employeeDetailList = query.list();
				//System.out.println("employeeDetailList=="+employeeDetailList.size());
			}

			map.put("employeeDetailList",employeeDetailList);
			map.put("box", box);
		return map;
	}
	
	public boolean updateOrderlyDutyEntry(Box box){
		boolean successfullyAdded=false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		String empName="";
		Vector dutyId=box.getVector("orderlyDutyId");
		Vector deptId=box.getVector("Location");
		Vector dutyDate=box.getVector("nextDutyDate");
		Vector dutyTime=box.getVector("dutyTime");
		Vector remarks=box.getVector("remarks");
		Vector dutyToBeUpdated=box.getVector("dutyToBeUpdated");
		
		try {
		
		for(int i=0;i<dutyId.size();i++)
		{
			if(dutyToBeUpdated.contains(dutyId.get(i)))
			{
					HrOrderlyDutyEntry hrOrderlyDutyEntry=(HrOrderlyDutyEntry) hbt.load(HrOrderlyDutyEntry.class, Integer.parseInt(dutyId.get(i).toString()));
					
					if(deptId.get(i)!=null && !deptId.get(i).equals("0"))
					{
						MasDepartment masDepartment=new MasDepartment();
						masDepartment.setId(Integer.parseInt(deptId.get(i).toString()));
						hrOrderlyDutyEntry.setDepartmentId(masDepartment);
					}
					
					if(dutyDate.get(i)!=null && !dutyDate.get(i).equals(""))
					{
						hrOrderlyDutyEntry.setDutyDate(HMSUtil.convertStringTypeDateToDateType((dutyDate.get(i).toString())));
					}
					
					if(dutyTime.get(i)!=null && !dutyTime.get(i).equals(""))
					{
						HrDutyTimeMaster hrDutyTimeMaster=new HrDutyTimeMaster();
						hrDutyTimeMaster.setId(Integer.parseInt(dutyTime.get(i).toString()));
						hrOrderlyDutyEntry.setDutyTime(hrDutyTimeMaster);
					}
					if(remarks.get(i)!=null && !remarks.get(i).equals(""))
					{
						hrOrderlyDutyEntry.setRemarks(remarks.get(i).toString());
					}
						hbt.update(hrOrderlyDutyEntry);
				}
			}
		} catch (Exception e) {
			successfullyAdded = false;
			e.printStackTrace();
		} 
		
				
			successfullyAdded = true;
		
			return successfullyAdded;
	}
	
	/**
	 * -------------------------- Range Firing Duty Entry -------------------
	 * Started on 9th June '09
	 */

	public Map<String, Object> getEmployeeDetailsForRangeFiringDutyAdd(Box box) 
	{
		PagedArray pagedArray = null;
		Session session = (Session)getSession();
		Map<String,Object>  map=new HashMap<String,Object>();
		List<MasEmployee> employeeList= new ArrayList<MasEmployee>();
		List<MasDepartment>departmentList=new ArrayList<MasDepartment>();
		List<HrDutyTimeMaster>dutyTimeMasterList=new ArrayList<HrDutyTimeMaster>();
		session = (Session)getSession();

		try 
		{
			employeeList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
			departmentList=session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
			dutyTimeMasterList=session.createCriteria(HrDutyTimeMaster.class).add(Restrictions.eq("Status", "y")).list();
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
		}
		map.put("employeeList", employeeList);
		map.put("departmentList", departmentList);
		map.put("dutyTimeMasterList", dutyTimeMasterList);
		
		map = getGridDataForRangeFiringEmployeeAdd(box);
		
		return map;
	}
	
	public Map<String, Object> getGridDataForRangeFiringEmployeeAdd(Box box) {
		Session session = (Session)getSession();
		Map<String,Object>  map=new HashMap<String,Object>();
		Map<String,Object> utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		session = (Session)getSession();

		int id = 0;

		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;  
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;

		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasEmployee> employeeDetailList = new ArrayList<MasEmployee>();
		List<MasDepartment>departmentList=new ArrayList<MasDepartment>();
		List<MasRank>rankList=new ArrayList<MasRank>();
		List<HrDutyTimeMaster>dutyTimeMasterList=new ArrayList<HrDutyTimeMaster>();

			rankList=session.createCriteria(MasRank.class).add(Restrictions.eq("RankName", "SGT")).list();
			employeeList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
			departmentList=session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
			dutyTimeMasterList=session.createCriteria(HrDutyTimeMaster.class).add(Restrictions.eq("Status", "y")).list();
			map.put("employeeList", employeeList);
			map.put("departmentList", departmentList);
			map.put("dutyTimeMasterList", dutyTimeMasterList);

			int pageno = 1;
			int numOfRows = 10;
			try
			{
				if (box.get("pageno")!=null)
				{
					pageno = Integer.parseInt(box.getString("pageno"));
				}
			}
			catch(Exception e)
			{
				//e.printStackTrace();
				pageno=1;
			}
			
			try
			{
				if (box.get("numOfRows")!=null)
				{
					numOfRows = Integer.parseInt(box.getString("numOfRows"));
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			map.put("pageno", pageno);
			
			int first = (pageno - 1) * numOfRows;
			int totalRecords = 0;
			if(employeeList != null && employeeList.size() > 0)
			{
				
				//String qry="SELECT count(*) FROM mas_employee";
				try
				{
					//totalRecords = Integer.parseInt(session.createSQLQuery(qry).list().get(0).toString());
					totalRecords = employeeList.size();
				}
				catch(Exception e)
				{
				totalRecords = 0;
				}
				map.put("totalRecords", totalRecords);

				
				double totalPages = 0.0;
				totalPages = (double)totalRecords/(double)numOfRows;
				Double d = new Double(Math.ceil(totalPages));
				map.put("totalPages", d.intValue());
				
				Criteria c =session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y"));
				c.setFirstResult(first);

				if (totalRecords < numOfRows)
					c.setMaxResults(totalRecords);
				else
					c.setMaxResults(numOfRows);
				
				employeeDetailList = c.list();
			}

			map.put("employeeDetailList",employeeDetailList);
			map.put("box", box);
		return map;
	}
	
	public Map<String, Object> getEmployeeDetailsForRangeFiringDuty(Box box) 
	{
		//System.out.println("first method called");
		PagedArray pagedArray = null;
		Session session = (Session)getSession();
		Map<String,Object>  map=new HashMap<String,Object>();
		List<MasEmployee> employeeList= new ArrayList<MasEmployee>();
		List<HrRangeFiringDutyEntry> dutyList = new ArrayList<HrRangeFiringDutyEntry>();
		String quarter=box.get("quarter");
		String year=box.get("year");
		
		session = (Session)getSession();
		//System.out.println("box ........." + box);

		try 
		{
			dutyList=session.createCriteria(HrRangeFiringDutyEntry.class).add(Restrictions.eq("Qaurter", quarter)).add(Restrictions.eq("Year",Integer.parseInt(year))).add(Restrictions.eq("Status","y")).list();
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
		}
		map.put("dutyList", dutyList);
		map.put("quarter", quarter);
		map.put("year", year);
		
		map = getGridDataForRangeFiringEmployee(box);
		
		return map;
	}
	
	

	public Map<String, Object> getGridDataForRangeFiringEmployee(Box box) {
		Session session = (Session)getSession();
		Map<String,Object>  map=new HashMap<String,Object>();
		Map<String,Object> utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		session = (Session)getSession();

		int id = 0;
		int deptId = 0;
		String quarter=box.get("quarter");
		String year=box.get("year");

		List<HrRangeFiringDutyEntry> employeeList = new ArrayList<HrRangeFiringDutyEntry>();
		List<HrRangeFiringDutyEntry> dutyEntryList = new ArrayList<HrRangeFiringDutyEntry>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<HrDutyTimeMaster> dutyMasterList = new ArrayList<HrDutyTimeMaster>();
		
			employeeList=session.createCriteria(HrRangeFiringDutyEntry.class).add(Restrictions.eq("Qaurter", quarter)).add(Restrictions.eq("Year",Integer.parseInt(year))).add(Restrictions.eq("Status","y")).list();
			departmentList=session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
			dutyMasterList=session.createCriteria(HrDutyTimeMaster.class).add(Restrictions.eq("Status", "y")).list();

			map.put("employeeList", employeeList);
			map.put("departmentList", departmentList);
			map.put("dutyMasterList", dutyMasterList);
			int pageno = 1;
			int numOfRows = 10;
			try
			{
				if (box.get("pageno")!=null)
				{
					pageno = Integer.parseInt(box.getString("pageno"));
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				pageno=1;
			}
			
			
			try
			{
				if (box.get("numOfRows")!=null)
				{
					numOfRows = Integer.parseInt(box.getString("numOfRows"));
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			map.put("pageno", pageno);
			
			int first = (pageno - 1) * numOfRows;
			int totalRecords = 0;
			if(employeeList != null && employeeList.size() > 0)
			{
				
				String qry="SELECT count(*) FROM hr_Range_firing_duty_entry";
				try
				{
					totalRecords = Integer.parseInt(session.createSQLQuery(qry).list().get(0).toString());
				}
				catch(Exception e)
				{
				totalRecords = 0;
				}
				map.put("totalRecords", totalRecords);

				
				double totalPages = 0.0;
				totalPages = (double)totalRecords/(double)numOfRows;
				Double d = new Double(Math.ceil(totalPages));
				map.put("totalPages", d.intValue());
				
				Criteria c =session.createCriteria(HrRangeFiringDutyEntry.class).add(Restrictions.eq("Qaurter", quarter)).add(Restrictions.eq("Year",Integer.parseInt(year))).add(Restrictions.eq("Status","y")); 
				c.setFirstResult(first);

				if (totalRecords < numOfRows)
					c.setMaxResults(totalRecords);
				else
					c.setMaxResults(numOfRows);
				
				dutyEntryList = c.list();
			}

			map.put("dutyEntryList",dutyEntryList);
			map.put("box", box);
		return map;
	}
	
	public boolean AddRangeFiringDutyEntry(Box box){
		boolean successfullyAdded=false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		
		Vector empId=box.getVector("employeeId");
		Vector employeeAdded=box.getVector("employeeToBeAdded");
		String quarter=box.get("quarter");
		String year=box.get("year");
		try {
		
			for(int i=0;i<empId.size();i++)
			{
				if(employeeAdded.contains(empId.get(i)))
				{
					HrRangeFiringDutyEntry hrRangeFiringDutyEntry=new HrRangeFiringDutyEntry();
					if(empId.get(i)!=null && !empId.get(i).equals(""))
					{
						MasEmployee masEmployee=new MasEmployee();
						masEmployee.setId(Integer.parseInt(empId.get(i).toString()));
						hrRangeFiringDutyEntry.setEmployee(masEmployee);
					}
					
					hrRangeFiringDutyEntry.setQaurter(quarter);
					hrRangeFiringDutyEntry.setYear(Integer.parseInt(year));
					hrRangeFiringDutyEntry.setStatus("y");
							
					if(box.getString("changedBy")!=null && !box.getString("changedBy").equals(""))
					{
						hrRangeFiringDutyEntry.setLastChgBy(box.getString("changedBy"));
					}
					
					if(box.getString("changedDate")!=null && !box.getString("changedDate").equals(""))
					{
						hrRangeFiringDutyEntry.setLastChgDate(HMSUtil.convertStringTypeDateToDateType((box.getString("changedDate"))));
					}
					
					if(box.getString("changedTime")!=null && !box.getString("changedTime").equals(""))
					{
						hrRangeFiringDutyEntry.setLastChgTime(box.getString("changedTime"));
					}
					
					MasHospital masHospital=new MasHospital();
					masHospital.setId(box.getInt("hospitalId"));
					hrRangeFiringDutyEntry.setHospital(masHospital);
					
						hbt.save(hrRangeFiringDutyEntry);
			
				}
			
			}
			
		} catch (Exception e) {
			successfullyAdded = false;
			e.printStackTrace();
		} 
		
				
			successfullyAdded = true;
		
			return successfullyAdded;
	}
	
	
	public boolean updateRangeFiringDutyEntry(Box box){
		boolean successfullyAdded=false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		String empName="";
		Vector dutyId=box.getVector("dutyId");
		Vector dutyToBeUpdated=box.getVector("dutyToBeUpdated");
		
		try {
		
		for(int i=0;i<dutyId.size();i++)
		{
			if(dutyToBeUpdated.contains(dutyId.get(i)))
			{
				HrRangeFiringDutyEntry hrRangeFiringDutyEntry=(HrRangeFiringDutyEntry) hbt.load(HrRangeFiringDutyEntry.class, Integer.parseInt(dutyId.get(i).toString()));
				hrRangeFiringDutyEntry.setStatus("n");
				hbt.update(hrRangeFiringDutyEntry);
			}
		}
		} catch (Exception e) {
			successfullyAdded = false;
			e.printStackTrace();
		} 
		
				
			successfullyAdded = true;
		
			return successfullyAdded;
	}

	
	public Map<String, Object> searchRangeFiringDutyEntry(Box box) 
	{
		PagedArray pagedArray = null;
		Session session = (Session)getSession();
		Map<String,Object>  map=new HashMap<String,Object>();
		List<MasEmployee> employeeList= new ArrayList<MasEmployee>();
		List<MasDepartment>departmentList=new ArrayList<MasDepartment>();
		List<HrDutyTimeMaster>dutyTimeMasterList=new ArrayList<HrDutyTimeMaster>();
		String serviceNo="";
		String empName="";
		
		if(!box.getString("searchServiceNo").equals(""))
		{	
			serviceNo=box.getString("searchServiceNo");
		}
		if(!box.getString("searchName").equals(""))
		{
			empName=box.getString("searchName");
		}
		session = (Session)getSession();
		if(!serviceNo.equals(""))
		{
			Criteria criteria=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y"));
			criteria=criteria.add(Restrictions.eq("ServiceNo",serviceNo));
			employeeList=criteria.list();
		}
		else if(!empName.equals(""))
		{
			Criteria crit1=null;
			crit1=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).add(Restrictions.like("FirstName", empName+"%"));
			if(crit1==null)
			{
				crit1=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).add(Restrictions.like("MiddleName", empName+"%"));
				if(crit1==null)
				{
					crit1=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).add(Restrictions.like("LastName", empName+"%"));
				}
			}
			employeeList=crit1.list();
		}
			
		try 
		{
			//employeeList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
			departmentList=session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
			dutyTimeMasterList=session.createCriteria(HrDutyTimeMaster.class).add(Restrictions.eq("Status", "y")).list();
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
		}
		map.put("employeeList", employeeList);
		map.put("departmentList", departmentList);
		map.put("dutyTimeMasterList", dutyTimeMasterList);
		
		map = getGridDataForRangeFiringEmployeeSearch(box);
		
		return map;
	}
	
	public Map<String, Object> getGridDataForRangeFiringEmployeeSearch(Box box) {
		Session session = (Session)getSession();
		Map<String,Object>  map=new HashMap<String,Object>();
		Map<String,Object> utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		session = (Session)getSession();

		int id = 0;

		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;  
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;

		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasEmployee> employeeDetailList = new ArrayList<MasEmployee>();
		List<MasDepartment>departmentList=new ArrayList<MasDepartment>();
		List<HrDutyTimeMaster>dutyTimeMasterList=new ArrayList<HrDutyTimeMaster>();
		String serviceNo="";
		String empName="";
		
		if(!box.getString("searchServiceNo").equals(""))
		{	
			serviceNo=box.getString("searchServiceNo");
		}
		if(!box.getString("searchName").equals(""))
		{
			empName=box.getString("searchName");
		}
		//System.out.println("service No="+serviceNo);
		//System.out.println("empName="+empName);
		session = (Session)getSession();
		if(!serviceNo.equals(""))
		{
			Criteria criteria=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y"));
			criteria=criteria.add(Restrictions.eq("ServiceNo",serviceNo));
			employeeList=criteria.list();
		}
		else if(!empName.equals(""))
		{
			Criteria crit1=null;
			crit1=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).add(Restrictions.like("FirstName", empName+"%"));
			if(crit1==null)
			{
				crit1=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).add(Restrictions.like("MiddleName", empName+"%"));
				if(crit1==null)
				{
					crit1=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).add(Restrictions.like("LastName", empName+"%"));
				}
			}
			employeeList=crit1.list();
		}
		//System.out.println("employeeList="+employeeList.size());	
			//employeeList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
			departmentList=session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
			dutyTimeMasterList=session.createCriteria(HrDutyTimeMaster.class).add(Restrictions.eq("Status", "y")).list();
			map.put("employeeList", employeeList);
			map.put("departmentList", departmentList);
			map.put("dutyTimeMasterList", dutyTimeMasterList);

			int pageno = 1;
			int numOfRows = 10;
			try
			{
				if (box.get("pageno")!=null)
				{
					pageno = Integer.parseInt(box.getString("pageno"));
				}
			}
			catch(Exception e)
			{
				//e.printStackTrace();
				pageno=1;
			}
			
			try
			{
				if (box.get("numOfRows")!=null)
				{
					numOfRows = Integer.parseInt(box.getString("numOfRows"));
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			map.put("pageno", pageno);
			
			int first = (pageno - 1) * numOfRows;
			int totalRecords = 0;
			if(employeeList != null && employeeList.size() > 0)
			{
				
				//String qry="SELECT count(*) FROM mas_employee";
				try
				{
					//totalRecords = Integer.parseInt(session.createSQLQuery(qry).list().get(0).toString());
					totalRecords = employeeList.size();
				}
				catch(Exception e)
				{
				totalRecords = 0;
				}
				map.put("totalRecords", totalRecords);

				
				double totalPages = 0.0;
				totalPages = (double)totalRecords/(double)numOfRows;
				Double d = new Double(Math.ceil(totalPages));
				map.put("totalPages", d.intValue());
				Criteria c =null;
				if(!serviceNo.equals(""))
				{
					c=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y"));
					c=c.add(Restrictions.eq("ServiceNo",serviceNo));
				}
				else if(!empName.equals(""))
				{
					c=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).add(Restrictions.like("FirstName", empName+"%"));
					if(c==null)
					{
						c=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).add(Restrictions.like("MiddleName", empName+"%"));
						if(c==null)
						{
							c=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).add(Restrictions.like("LastName", empName+"%"));
						}
					}
				}
				
				//Criteria c =session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y"));
				c.setFirstResult(first);

				if (totalRecords < numOfRows)
					c.setMaxResults(totalRecords);
				else
					c.setMaxResults(numOfRows);
				
				employeeDetailList = c.list();
			}
			//System.out.println("employeeDetailList="+employeeDetailList.size());
			map.put("employeeDetailList",employeeDetailList);
			map.put("box", box);
		return map;
	}

	/**
	 * ---------------------------------- DUTY DISPLAY --------------------------
	 */
	
	
	public Map<String, Object> searchDutyDisplay(Box box) {
		Session session = (Session)getSession();
		Map<String,Object>  map=new HashMap<String,Object>();
		Map<String,Object> utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		session = (Session)getSession();
		Date currentdate= new Date();

		int id = 0;

		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;  
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;

		List<HrDutyEntry> nightDutyList = new ArrayList<HrDutyEntry>();
		List<HrGuardDutyEntry> guardDutyList = new ArrayList<HrGuardDutyEntry>();
		List<HrWardDutyEntry> wardDutyList = new ArrayList<HrWardDutyEntry>();
		List<HrOrderlyDutyEntry> orderlyDutyList = new ArrayList<HrOrderlyDutyEntry>();
		List<HrRangeFiringDutyEntry> rangeFiringDutyList = new ArrayList<HrRangeFiringDutyEntry>();
		String serviceNo="";
		String empName="";
		
		if(!box.getString("searchServiceNo").equals(""))
		{	
			serviceNo=box.getString("searchServiceNo");
		}
		if(!box.getString("searchName").equals(""))
		{
			empName=box.getString("searchName");
		}
		//System.out.println("service No="+serviceNo);
		//System.out.println("empName="+empName);
		session = (Session)getSession();
		if(!serviceNo.equals(""))
		{
			Criteria criteria=session.createCriteria(HrDutyEntry.class).add(Restrictions.gt("DutyDate", currentdate)).createAlias("Emp", "me").add(Restrictions.eq("me.Status", "y"));
			criteria=criteria.add(Restrictions.like("me.ServiceNo",serviceNo+"%"));
			nightDutyList=criteria.list();
			
			criteria=session.createCriteria(HrGuardDutyEntry.class).add(Restrictions.gt("DutyDate", currentdate)).createAlias("Emp", "me").add(Restrictions.eq("me.Status", "y"));
			criteria=criteria.add(Restrictions.like("me.ServiceNo",serviceNo+"%"));
			guardDutyList=criteria.list();
			
			criteria=session.createCriteria(HrWardDutyEntry.class).add(Restrictions.gt("DutyDate", currentdate)).createAlias("Emp", "me").add(Restrictions.eq("me.Status", "y"));
			criteria=criteria.add(Restrictions.like("me.ServiceNo",serviceNo+"%"));
			wardDutyList=criteria.list();
			
			criteria=session.createCriteria(HrOrderlyDutyEntry.class).add(Restrictions.gt("DutyDate", currentdate)).createAlias("Emp", "me").add(Restrictions.eq("me.Status", "y"));
			criteria=criteria.add(Restrictions.like("me.ServiceNo",serviceNo+"%"));
			orderlyDutyList=criteria.list();
			
			criteria=session.createCriteria(HrRangeFiringDutyEntry.class).createAlias("Employee", "me").add(Restrictions.eq("me.Status", "y"));
			criteria=criteria.add(Restrictions.like("me.ServiceNo",serviceNo+"%"));
			rangeFiringDutyList=criteria.list();
		}
		else if(!empName.equals(""))
		{
			Criteria crit1=null;
			crit1=session.createCriteria(HrDutyEntry.class).add(Restrictions.gt("DutyDate", currentdate)).createAlias("Emp", "me").add(Restrictions.eq("me.Status", "y")).add(Restrictions.like("me.FirstName", empName+"%"));
			if(crit1==null)
			{
				crit1=session.createCriteria(HrDutyEntry.class).add(Restrictions.gt("DutyDate", currentdate)).createAlias("Emp", "me").add(Restrictions.eq("me.Status", "y")).add(Restrictions.like("me.MiddleName", empName+"%"));
				if(crit1==null)
				{
					crit1=session.createCriteria(HrDutyEntry.class).add(Restrictions.gt("DutyDate", currentdate)).createAlias("Emp", "me").add(Restrictions.eq("me.Status", "y")).add(Restrictions.like("me.LastName", empName+"%"));
				}
			}
			nightDutyList=crit1.list();
			
			
			crit1=session.createCriteria(HrGuardDutyEntry.class).add(Restrictions.gt("DutyDate", currentdate)).createAlias("Emp", "me").add(Restrictions.eq("me.Status", "y")).add(Restrictions.like("me.FirstName", empName+"%"));
			if(crit1==null)
			{
				crit1=session.createCriteria(HrGuardDutyEntry.class).add(Restrictions.gt("DutyDate", currentdate)).createAlias("Emp", "me").add(Restrictions.eq("me.Status", "y")).add(Restrictions.like("me.MiddleName", empName+"%"));
				if(crit1==null)
				{
					crit1=session.createCriteria(HrGuardDutyEntry.class).add(Restrictions.gt("DutyDate", currentdate)).createAlias("Emp", "me").add(Restrictions.eq("me.Status", "y")).add(Restrictions.like("me.LastName", empName+"%"));
				}
			}
			guardDutyList=crit1.list();
			
			
			crit1=session.createCriteria(HrWardDutyEntry.class).add(Restrictions.gt("DutyDate", currentdate)).createAlias("Emp", "me").add(Restrictions.eq("me.Status", "y")).add(Restrictions.like("me.FirstName", empName+"%"));
			if(crit1==null)
			{
				crit1=session.createCriteria(HrWardDutyEntry.class).add(Restrictions.gt("DutyDate", currentdate)).createAlias("Emp", "me").add(Restrictions.eq("me.Status", "y")).add(Restrictions.like("me.MiddleName", empName+"%"));
				if(crit1==null)
				{
					crit1=session.createCriteria(HrWardDutyEntry.class).add(Restrictions.gt("DutyDate", currentdate)).createAlias("Emp", "me").add(Restrictions.eq("me.Status", "y")).add(Restrictions.like("me.LastName", empName+"%"));
				}
			}
			wardDutyList=crit1.list();
			
			
			crit1=session.createCriteria(HrOrderlyDutyEntry.class).add(Restrictions.gt("DutyDate", currentdate)).createAlias("Emp", "me").add(Restrictions.eq("me.Status", "y")).add(Restrictions.like("me.FirstName", empName+"%"));
			if(crit1==null)
			{
				crit1=session.createCriteria(HrOrderlyDutyEntry.class).add(Restrictions.gt("DutyDate", currentdate)).createAlias("Emp", "me").add(Restrictions.eq("me.Status", "y")).add(Restrictions.like("me.MiddleName", empName+"%"));
				if(crit1==null)
				{
					crit1=session.createCriteria(HrOrderlyDutyEntry.class).add(Restrictions.gt("DutyDate", currentdate)).createAlias("Emp", "me").add(Restrictions.eq("me.Status", "y")).add(Restrictions.like("me.LastName", empName+"%"));
				}
			}
			orderlyDutyList=crit1.list();
			
			crit1=session.createCriteria(HrRangeFiringDutyEntry.class).createAlias("Employee", "me").add(Restrictions.eq("me.Status", "y")).add(Restrictions.like("me.FirstName", empName+"%"));
			if(crit1==null)
			{
				crit1=session.createCriteria(HrRangeFiringDutyEntry.class).createAlias("Employee", "me").add(Restrictions.eq("me.Status", "y")).add(Restrictions.like("me.MiddleName", empName+"%"));
				if(crit1==null)
				{
					crit1=session.createCriteria(HrRangeFiringDutyEntry.class).createAlias("Employee", "me").add(Restrictions.eq("me.Status", "y")).add(Restrictions.like("me.LastName", empName+"%"));
				}
			}
			rangeFiringDutyList=crit1.list();
			
		}

			map.put("nightDutyList",nightDutyList);
			map.put("guardDutyList",guardDutyList);
			map.put("wardDutyList",wardDutyList);
			map.put("orderlyDutyList",orderlyDutyList);
			map.put("rangeFiringDutyList",rangeFiringDutyList);
			map.put("box", box);
		return map;
	}
	
	/**
	 * ---------------------------- Duty Exemption Entry -------------------------
	 */
	
	public Map<String, Object> showDutyExemptionSearchJsp() {
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			List<MasRank> rankList = new ArrayList<MasRank>();
			Session session = (Session) getSession();
			try {
				rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).list();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			map.put("rankList", rankList);
			return map;
		}
		
	public Map<String, Object> searchEmployeeForDutyExemption(Map<String, Object> map) {
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		String serviceNo = "";
		int rankId = 0;
		String firstName = "";
		String lastName = "";
		
		Session session = (Session)getSession();
		
		rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).list();
		
		if(map.get("serviceNo") != null){
			serviceNo = (String)map.get("serviceNo");
		}
		if(map.get("rankId") != null){
			rankId = (Integer)map.get("rankId");
		}
		if(map.get("firstName") != null){
			firstName = (String)map.get("firstName");
		}
		if(map.get("lastName") != null){
			lastName = (String)map.get("lastName");
		}
	
		try {
			Criteria crit = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y"));
			
				if(!serviceNo.equals("") ){
					crit = crit.add(Restrictions.like("ServiceNo", serviceNo+"%"));
				}
				if(!firstName.equals("")){
					crit = crit.add(Restrictions.like("FirstName", firstName+"%"));
				}
				if(!lastName.equals("")){
					crit = crit.add(Restrictions.like("LastName", lastName+"%"));
				}
				if(rankId != 0 ){
					crit = crit.createAlias("Rank", "rank").add(Restrictions.eq("rank.Id", rankId));
				}
			
				employeeList = crit.list();
		 }catch (Exception e) {
			e.printStackTrace();
		}
		 ////System.out.println("employeeList="+employeeList.size());
		map.put("employeeList", employeeList);
		map.put("rankList", rankList);
		return map;
	}
	
	public Map<String, Object> showDutyExemptionEntryJsp(int empId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session=(Session) getSession();
		List<HrDutyMaster>dutyList=new ArrayList<HrDutyMaster>();
		List<MasEmployee>employeeList=new ArrayList<MasEmployee>();
		String entryNo="";
		entryNo=getEntrySeqForDisplay();
		employeeList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Id", empId)).list();
		dutyList=session.createCriteria(HrDutyMaster.class).add(Restrictions.eq("Status","y")).list();
		map.put("dutyList", dutyList);
		map.put("employeeList", employeeList);
		map.put("entryNo", entryNo);
		return map;
	}
	
		public boolean submitDutyExemptionEntry(Box box){
			boolean successfullyAdded=false;
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			Session session = (Session)getSession();

			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			int empId=0;
			int dutyId=0;
			int counter=box.getInt("hiddenValue");
			List<TransactionSequence>entryNoList=new ArrayList<TransactionSequence>();
			String tableNameForTransactionSequence="HrDutyExemptionEntry";
			for(int i=1;i<=counter;i++)
			{
				HrDutyExemptionEntry hrDutyExemption=new HrDutyExemptionEntry();
					empId=box.getInt("empId");
					MasEmployee masEmployee=new MasEmployee();
					masEmployee.setId(empId);
					hrDutyExemption.setEmployee(masEmployee);
					
					hrDutyExemption.setEntryNo(box.getString("entryNo"));
					hrDutyExemption.setEntryDate(HMSUtil.convertStringTypeDateToDateType(box.getString("entryDate")));
					
					dutyId=box.getInt("duty"+i);
					HrDutyMaster hrDutyMaster=new HrDutyMaster();
					hrDutyMaster.setId(dutyId);
					hrDutyExemption.setDuty(hrDutyMaster);
					if(!box.getString("fromDate"+i).equals(""))
						hrDutyExemption.setFromDate(HMSUtil.convertStringTypeDateToDateType((box.getString("fromDate"+i))));
				
					if(!box.getString("toDate"+i).equals(""))
						hrDutyExemption.setToDate(HMSUtil.convertStringTypeDateToDateType((box.getString("toDate"+i))));
					
					if(!box.getString("remarks"+i).equals(""))
						hrDutyExemption.setRemarks(box.getString("remarks"+i));
				
					hrDutyExemption.setLastChgBy(box.getString("changedBy"));
				
					hrDutyExemption.setLastChgDate(HMSUtil.convertStringTypeDateToDateType((box.getString("changedDate"))));
					hrDutyExemption.setLastChgTime(box.getString("changedTime"));
					hbt.save(hrDutyExemption);
			}
			entryNoList=session.createCriteria(TransactionSequence.class).add(Restrictions.eq("Tablename", tableNameForTransactionSequence)).list();
			 TransactionSequence transactionSequence=(TransactionSequence)entryNoList.get(0);
			 int id=transactionSequence.getId();
			 int entryNo=transactionSequence.getTransactionSequenceNumber();
			 entryNo=entryNo+1;
			TransactionSequence transactionSequenceObj=(TransactionSequence)hbt.load(TransactionSequence.class, id);
			transactionSequenceObj.setTransactionSequenceNumber(entryNo);
			hbt.update(transactionSequenceObj);
			successfullyAdded = true;
			return successfullyAdded;
		}

		public String getEntrySeqForDisplay()
		   {
		      List<TransactionSequence> orderSeqNoList = new ArrayList<TransactionSequence>();
		      List<HrDutyExemptionEntry> seqNoList = new ArrayList<HrDutyExemptionEntry>();
		      String entrySeqNo = "";
		      String lastSeqNo = "";
		      String lastSeqYear = "";

		      Map<String, Object> utilMap = new HashMap<String, Object>();
		      utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		      String date = (String) utilMap.get("currentDate");

		      String currentYear = date.substring(date.lastIndexOf("/") + 1);
		      Session session = (Session) getSession();
		      try
		      {
		         seqNoList = session.createCriteria(HrDutyExemptionEntry.class).list();
		         if (seqNoList.size() > 0)
		         {
		            for (HrDutyExemptionEntry hrDutyExemptionEntry : seqNoList)
		            {
		               lastSeqNo = hrDutyExemptionEntry.getEntryNo();
		            }
		            StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
		            while (str.hasMoreTokens())
		            {
		               lastSeqYear = str.nextToken();
		            }
		         } else
		         {
		            lastSeqYear = currentYear;
		         }

		         orderSeqNoList = session.createCriteria(TransactionSequence.class).add(
		               Restrictions.eq("TransactionPrefix", "ENY")).list();
		         if (orderSeqNoList.size() > 0)
		         {
		            for (TransactionSequence maxOrderNo : orderSeqNoList)
		            {
		               if (currentYear.equals(lastSeqYear))
		               {
		                  entrySeqNo = String.valueOf(maxOrderNo.getTransactionSequenceNumber() + 1);
		               } else
		               {
		                  entrySeqNo = String.valueOf(1);
		               }
		            }
		         } else
		         {
		            entrySeqNo = String.valueOf(1);
		            TransactionSequence transactionSeq = new TransactionSequence();
		            transactionSeq.setTransactionSequenceNumber(1);
		            transactionSeq.setTransactionSequenceName("Duty Exemptions Entry ");
		            transactionSeq.setTransactionPrefix("ENY");
		            transactionSeq.setTablename("HrDutyExemptionEntry");
		            transactionSeq.setStatus("y");
		            session.save(transactionSeq);
		            session.refresh(transactionSeq);
		         }
		         entrySeqNo = entrySeqNo.concat("/").concat(String.valueOf(lastSeqYear));
		      } catch (HibernateException e)
		      {
		         e.printStackTrace();
		      }
		      return entrySeqNo;
		   }

		/**
		 * -------------------------- Daily Routine Entry -------------------
		 * Started on 14th July '09
		 */

		public Map<String, Object> showDailyRoutineEntryJsp() 
		{
			PagedArray pagedArray = null;
			Session session = (Session)getSession();
			Map<String,Object>  map=new HashMap<String,Object>();
			List<HrDutyMaster> dutyNameList = new ArrayList<HrDutyMaster>();
			List<HrDailyRoutineDutyEntry>dailyRoutineDutyListForEntryNo=new ArrayList<HrDailyRoutineDutyEntry>();
			String entryNo="";
			
			session = (Session)getSession();

			try 
			{
				dutyNameList=session.createCriteria(HrDutyMaster.class).add(Restrictions.eq("Status", "y")).list();
				dailyRoutineDutyListForEntryNo=session.createCriteria(HrDailyRoutineDutyEntry.class).add(Restrictions.eq("Status", "y")).list();
				Set<String> dailyRoutineSetForEntryNoSet=new TreeSet<String>();
				for(HrDailyRoutineDutyEntry hrDailyRoutineDutyEntry:dailyRoutineDutyListForEntryNo){
					dailyRoutineSetForEntryNoSet.add(hrDailyRoutineDutyEntry.getEntryNo());
				}
			entryNo=getEntrySeqForDailyRoutineDisplay();
			map.put("dutyNameList", dutyNameList);
			map.put("entryNo",entryNo);
			map.put("dailyRoutineSetForEntryNoSet",dailyRoutineSetForEntryNoSet);
			}
			catch (HibernateException e)
			{
				e.printStackTrace();
			}
			return map;
		}
		
		public String getEntrySeqForDailyRoutineDisplay()
		   {
		      List<TransactionSequence> orderSeqNoList = new ArrayList<TransactionSequence>();
		      List<HrDailyRoutineDutyEntry> seqNoList = new ArrayList<HrDailyRoutineDutyEntry>();
		      String entrySeqNo = "";
		      String lastSeqNo = "";
		      String lastSeqYear = "";

		      Map<String, Object> utilMap = new HashMap<String, Object>();
		      utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		      String date = (String) utilMap.get("currentDate");

		      String currentYear = date.substring(date.lastIndexOf("/") + 1);
		      Session session = (Session) getSession();
		      try
		      {
		         seqNoList = session.createCriteria(HrDailyRoutineDutyEntry.class).list();
		         if (seqNoList.size() > 0)
		         {
		            for (HrDailyRoutineDutyEntry hrDailyRoutineDutyEntry : seqNoList)
		            {
		               lastSeqNo = hrDailyRoutineDutyEntry.getEntryNo();
		            }
		            StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
		            while (str.hasMoreTokens())
		            {
		               lastSeqYear = str.nextToken();
		            }
		         } else
		         {
		            lastSeqYear = currentYear;
		         }

		         orderSeqNoList = session.createCriteria(TransactionSequence.class).add(
		               Restrictions.eq("TransactionPrefix", "DEY")).list();
		         if (orderSeqNoList.size() > 0)
		         {
		            for (TransactionSequence maxOrderNo : orderSeqNoList)
		            {
		               if (currentYear.equals(lastSeqYear))
		               {
		                  entrySeqNo = String.valueOf(maxOrderNo.getTransactionSequenceNumber() + 1);
		               } else
		               {
		                  entrySeqNo = String.valueOf(1);
		                  maxOrderNo.setTransactionSequenceNumber(1);
		               }
		               session.saveOrUpdate(maxOrderNo);
		               session.refresh(maxOrderNo);
		            }
		         } else
		         {
		            entrySeqNo = String.valueOf(1);
		            TransactionSequence transactionSeq = new TransactionSequence();
		            transactionSeq.setTransactionSequenceNumber(1);
		            transactionSeq.setTransactionSequenceName("Daily Routine Duty Entry ");
		            transactionSeq.setTransactionPrefix("DEY");
		            transactionSeq.setTablename("HrDailyRoutineDutyEntry");
		            transactionSeq.setStatus("y");
		            session.save(transactionSeq);
		            session.refresh(transactionSeq);
		         }
		         entrySeqNo = entrySeqNo.concat("/").concat(String.valueOf(lastSeqYear));
		      } catch (HibernateException e)
		      {
		         e.printStackTrace();
		      }
		      return entrySeqNo;
		   }


		
		public Map<String, Object> getEmployeeDetailsForDailyRoutineAdd(Box box) 
		{
			PagedArray pagedArray = null;
			Session session = (Session)getSession();
			Map<String,Object>  map=new HashMap<String,Object>();
			List<MasEmployee> employeeList= new ArrayList<MasEmployee>();
			List<MasDepartment>departmentList=new ArrayList<MasDepartment>();
			List<HrDutyTimeMaster>dutyTimeMasterList=new ArrayList<HrDutyTimeMaster>();
			session = (Session)getSession();

			try 
			{
				employeeList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
				departmentList=session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
				dutyTimeMasterList=session.createCriteria(HrDutyTimeMaster.class).add(Restrictions.eq("Status", "y")).list();
			}
			catch (HibernateException e)
			{
				e.printStackTrace();
			}
			map.put("employeeList", employeeList);
			map.put("departmentList", departmentList);
			map.put("dutyTimeMasterList", dutyTimeMasterList);
			
			map = getGridDataForDailyRoutineEmployeeAdd(box);
			
			return map;
		}
		
		public Map<String, Object> getGridDataForDailyRoutineEmployeeAdd(Box box) {
			Session session = (Session)getSession();
			Map<String,Object>  map=new HashMap<String,Object>();
			Map<String,Object> utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
			session = (Session)getSession();

			int id = 0;

			PagedArray pagedArray = null;
			HashMap<String, Object> hData = null;  
			Vector<HashMap> vResult = new Vector<HashMap>();
			HashMap[] testPageData = null;

			List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
			List<MasEmployee> employeeDetailList = new ArrayList<MasEmployee>();
			List<MasDepartment>departmentList=new ArrayList<MasDepartment>();
			List<MasTrade>tradeList=new ArrayList<MasTrade>();
			List<HrDutyTimeMaster>dutyTimeMasterList=new ArrayList<HrDutyTimeMaster>();
			List<HrLeaveMaintenance>leaveMaintenanceList=new ArrayList<HrLeaveMaintenance>();
			List<HrDutyExemptionEntry>dutyExemptionList=new ArrayList<HrDutyExemptionEntry>();

				tradeList=session.createCriteria(MasTrade.class).add(Restrictions.eq("TradeName", "Med Asst")).list();
				employeeList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).createAlias("Trade", "mt").add(Restrictions.eq("mt.Id", tradeList.get(0).getId())).list();
				departmentList=session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
				dutyTimeMasterList=session.createCriteria(HrDutyTimeMaster.class).add(Restrictions.eq("Status", "y")).list();
				leaveMaintenanceList=session.createCriteria(HrLeaveMaintenance.class).list();
				dutyExemptionList=session.createCriteria(HrDutyExemptionEntry.class).createAlias("Duty", "d").add(Restrictions.eq("d.Id", box.getInt("dutyId"))).list();

				map.put("dutyExemptionList", dutyExemptionList);
				map.put("leaveMaintenanceList", leaveMaintenanceList);
				
				map.put("employeeList", employeeList);
				map.put("departmentList", departmentList);
				map.put("dutyTimeMasterList", dutyTimeMasterList);

				int pageno = 1;
				int numOfRows = 10;
				try
				{
					if (box.get("pageno")!=null)
					{
						pageno = Integer.parseInt(box.getString("pageno"));
					}
				}
				catch(Exception e)
				{
					//e.printStackTrace();
					pageno=1;
				}
				
				try
				{
					if (box.get("numOfRows")!=null)
					{
						numOfRows = Integer.parseInt(box.getString("numOfRows"));
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				map.put("pageno", pageno);
				
				int first = (pageno - 1) * numOfRows;
				int totalRecords = 0;
				if(employeeList != null && employeeList.size() > 0)
				{
					
					//String qry="SELECT count(*) FROM mas_employee";
					try
					{
						//totalRecords = Integer.parseInt(session.createSQLQuery(qry).list().get(0).toString());
						totalRecords = employeeList.size();
					}
					catch(Exception e)
					{
					totalRecords = 0;
					}
					map.put("totalRecords", totalRecords);

					
					double totalPages = 0.0;
					totalPages = (double)totalRecords/(double)numOfRows;
					Double d = new Double(Math.ceil(totalPages));
					map.put("totalPages", d.intValue());
					
					Criteria c =session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).createAlias("Trade", "mt").add(Restrictions.eq("mt.Id", tradeList.get(0).getId()));
					c.setFirstResult(first);

					if (totalRecords < numOfRows)
						c.setMaxResults(totalRecords);
					else
						c.setMaxResults(numOfRows);
					
					employeeDetailList = c.list();
				}

				map.put("employeeDetailList",employeeDetailList);
				map.put("box", box);
			return map;
		}
		
		public Map<String, Object> getEmployeeDetailsForDailyRoutine(Box box) 
		{
			PagedArray pagedArray = null;
			Session session = (Session)getSession();
			Map<String,Object>  map=new HashMap<String,Object>();
			
			map = getGridDataForDailyRoutineEmployee(box);
			
			return map;
		}
		
		

		public Map<String, Object> getGridDataForDailyRoutineEmployee(Box box) {
			Session session = (Session)getSession();
			Map<String,Object>  map=new HashMap<String,Object>();
			Map<String,Object> utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
			session = (Session)getSession();

			int id = 0;
			int deptId = 0;
			Date fromDate=new Date();
			Date toDate=new Date();
			int dutyId=0;
			if(!box.get("fromDate").equals(""))
				fromDate=HMSUtil.convertStringTypeDateToDateType(box.get("fromDate"));
			if(!box.get("toDate").equals(""))
				toDate=HMSUtil.convertStringTypeDateToDateType(box.get("toDate"));
			if(box.getInt("dutyId")!=0)
				dutyId=box.getInt("dutyId");
			//System.out.println("dutyId="+dutyId);
			List<HrDailyRoutineDutyEntry> employeeList = new ArrayList<HrDailyRoutineDutyEntry>();
			List<HrGuardDutyEntry> dutyEntryList = new ArrayList<HrGuardDutyEntry>();
			List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			List<HrDutyTimeMaster> dutyMasterList = new ArrayList<HrDutyTimeMaster>();
			List<HrDailyRoutineDutyEntry>dailyRoutineDutyListForEntryNo=new ArrayList<HrDailyRoutineDutyEntry>();
				employeeList=session.createCriteria(HrDailyRoutineDutyEntry.class).createAlias("Duty", "hdm").add(Restrictions.eq("hdm.Id",dutyId)).add(Restrictions.between("DutyDate", fromDate, toDate)).add(Restrictions.eq("Status", "y")).list();
				dutyMasterList=session.createCriteria(HrDutyTimeMaster.class).add(Restrictions.eq("Status", "y")).list();
				dailyRoutineDutyListForEntryNo=session.createCriteria(HrDailyRoutineDutyEntry.class).add(Restrictions.eq("Status", "y")).list();
				Set<String> dailyRoutineSetForEntryNoSet=new TreeSet<String>();
				for(HrDailyRoutineDutyEntry hrDailyRoutineDutyEntry:dailyRoutineDutyListForEntryNo){
					dailyRoutineSetForEntryNoSet.add(hrDailyRoutineDutyEntry.getEntryNo());
				}
				map.put("employeeList", employeeList);
				map.put("departmentList", departmentList);
				map.put("dutyMasterList", dutyMasterList);
				map.put("dailyRoutineSetForEntryNoSet",dailyRoutineSetForEntryNoSet);
				int pageno = 1;
				int numOfRows = 10;
				try
				{
					if (box.get("pageno")!=null && !box.get("pageno").equals(""))
					{
						pageno = Integer.parseInt(box.getString("pageno"));
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
					pageno=1;
				}
				
				
				try
				{
					if (box.get("numOfRows")!=null)
					{
						numOfRows = Integer.parseInt(box.getString("numOfRows"));
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				map.put("pageno", pageno);
				
				int first = (pageno - 1) * numOfRows;
				int totalRecords = 0;
				if(employeeList != null && employeeList.size() > 0)
				{
					
					
					try
					{
						totalRecords = employeeList.size();
					}
					catch(Exception e)
					{
					totalRecords = 0;
					}
					map.put("totalRecords", totalRecords);

					
					double totalPages = 0.0;
					totalPages = (double)totalRecords/(double)numOfRows;
					Double d = new Double(Math.ceil(totalPages));
					map.put("totalPages", d.intValue());
					
					Criteria c =session.createCriteria(HrDailyRoutineDutyEntry.class).add(Restrictions.between("DutyDate", fromDate, toDate)).add(Restrictions.eq("Status", "y")).createAlias("Duty", "hdm").add(Restrictions.eq("hdm.Id",dutyId)); 
					c.setFirstResult(first);

					if (totalRecords < numOfRows)
						c.setMaxResults(totalRecords);
					else
						c.setMaxResults(numOfRows);
					
					dutyEntryList = c.list();
				}
				
				List<HrDutyMaster> dutyNameList = new ArrayList<HrDutyMaster>();
				try 
				{
					dutyNameList=session.createCriteria(HrDutyMaster.class).add(Restrictions.eq("Status", "y")).list();
					
				}
				catch (HibernateException e)
				{
					e.printStackTrace();
				}
				map.put("dutyNameList", dutyNameList);
				
				String entryNo=getEntrySeqForDailyRoutineDisplay();
				map.put("entryNo", entryNo);
				map.put("dutyId", box.getInt("dutyId"));
				map.put("dutyEntryList",dutyEntryList);
				map.put("box", box);
			return map;
		}
		
		public boolean AddDailyRoutineEntry(Box box){
			Session session = (Session)getSession();
			boolean successfullyAdded=false;
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
			Vector empId=box.getVector("employeeId");
			Vector employeeAdded=box.getVector("employeeToBeAdded");
			Vector remarks=box.getVector("remarks");
			Vector dutyDate=box.getVector("nextDutyDate");
			Vector dutyTimeId=box.getVector("dutyTimeId");
			
			List<TransactionSequence>entryNoList=new ArrayList<TransactionSequence>();
			String tableNameForTransactionSequence="HrDailyRoutineDutyEntry";
			try {
			
				for(int i=0;i<empId.size();i++)
				{
					if(employeeAdded.contains(empId.get(i)))
					{
						HrDailyRoutineDutyEntry hrDailyRoutineDutyEntry=new HrDailyRoutineDutyEntry();
						if(empId.get(i)!=null && !empId.get(i).equals(""))
						{
							MasEmployee masEmployee=new MasEmployee();
							masEmployee.setId(Integer.parseInt(empId.get(i).toString()));
							hrDailyRoutineDutyEntry.setEmp(masEmployee);
						}
						
						hrDailyRoutineDutyEntry.setEntryNo(box.getString("entryNo"));
						hrDailyRoutineDutyEntry.setEntryDate(HMSUtil.convertStringTypeDateToDateType(box.getString("entryDate")));
						
						HrDutyMaster hrDutyMaster=new HrDutyMaster();
						hrDutyMaster.setId(box.getInt("dutyId"));
						hrDailyRoutineDutyEntry.setDuty(hrDutyMaster);
						
						HrDutyTimeMaster hrDutyTimeMaster=new HrDutyTimeMaster();
						hrDutyTimeMaster.setId(Integer.parseInt(dutyTimeId.get(i).toString()));
						hrDailyRoutineDutyEntry.setDutyTime(hrDutyTimeMaster);
					
						if(remarks.get(i)!=null)
							hrDailyRoutineDutyEntry.setRemarks(remarks.get(i).toString());
						
						if(dutyDate.get(i)!=null)
							hrDailyRoutineDutyEntry.setDutyDate(HMSUtil.convertStringTypeDateToDateType(dutyDate.get(i).toString()));
						
						hrDailyRoutineDutyEntry.setStatus("y");
								
						if(box.getString("changedBy")!=null && !box.getString("changedBy").equals(""))
						{
							hrDailyRoutineDutyEntry.setLastChgBy(box.getString("changedBy"));
						}
						
						if(box.getString("changedDate")!=null && !box.getString("changedDate").equals(""))
						{
							hrDailyRoutineDutyEntry.setLastChgDate(HMSUtil.convertStringTypeDateToDateType((box.getString("changedDate"))));
						}
						
						if(box.getString("changedTime")!=null && !box.getString("changedTime").equals(""))
						{
							hrDailyRoutineDutyEntry.setLastChgTime(box.getString("changedTime"));
						}
						
						MasHospital masHospital=new MasHospital();
						masHospital.setId(box.getInt("hospitalId"));
						hrDailyRoutineDutyEntry.setHospital(masHospital);
						
						hbt.save(hrDailyRoutineDutyEntry);
						
						
				
					}
					
				}
				entryNoList=session.createCriteria(TransactionSequence.class).add(Restrictions.eq("Tablename", tableNameForTransactionSequence)).list();
				TransactionSequence transactionSequence=(TransactionSequence)entryNoList.get(0);
				int id=transactionSequence.getId();
				int entryNo=transactionSequence.getTransactionSequenceNumber();
				entryNo=entryNo+1;
				TransactionSequence transactionSequenceObj=(TransactionSequence)hbt.load(TransactionSequence.class, id);
				transactionSequenceObj.setTransactionSequenceNumber(entryNo);
				hbt.update(transactionSequenceObj);
			
			} catch (Exception e) {
				successfullyAdded = false;
				e.printStackTrace();
			} 
			
					
				successfullyAdded = true;
			
				return successfullyAdded;
		}
		
		
		public boolean updateDailyRoutineEntry(Box box){
			boolean successfullyAdded=false;
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
			String empName="";
			Vector dutyId=box.getVector("dailyRoutineDutyId");
			Vector dutyToBeUpdated=box.getVector("dutyToBeUpdated");
			
			try {
			
			for(int i=0;i<dutyId.size();i++)
			{
				if(dutyToBeUpdated.contains(dutyId.get(i)))
				{
					HrDailyRoutineDutyEntry hrDailyRoutineDutyEntry=(HrDailyRoutineDutyEntry) hbt.load(HrDailyRoutineDutyEntry.class, Integer.parseInt(dutyId.get(i).toString()));
					hrDailyRoutineDutyEntry.setStatus("n");
					hbt.update(hrDailyRoutineDutyEntry);
				}
			}
			} catch (Exception e) {
				successfullyAdded = false;
				e.printStackTrace();
			} 
			
					
				successfullyAdded = true;
			
				return successfullyAdded;
		}

		
		
		public Map<String, Object> searchDailyRoutineEntry(Box box) {
			Session session = (Session)getSession();
			Map<String,Object>  map=new HashMap<String,Object>();
			Map<String,Object> utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
			session = (Session)getSession();

			int id = 0;

			PagedArray pagedArray = null;
			HashMap<String, Object> hData = null;  
			Vector<HashMap> vResult = new Vector<HashMap>();
			HashMap[] testPageData = null;

			List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
			List<MasEmployee> employeeDetailList = new ArrayList<MasEmployee>();
			List<MasDepartment>departmentList=new ArrayList<MasDepartment>();
			List<HrDutyTimeMaster>dutyTimeMasterList=new ArrayList<HrDutyTimeMaster>();
			List<HrDutyExemptionEntry>dutyExemptionList=new ArrayList<HrDutyExemptionEntry>();
			String serviceNo="";
			String empName="";
			
			if(!box.getString("searchServiceNo").equals(""))
			{	
				serviceNo=box.getString("searchServiceNo");
			}
			if(!box.getString("searchName").equals(""))
			{
				empName=box.getString("searchName");
			}
			session = (Session)getSession();
			if(!serviceNo.equals(""))
			{
				Criteria criteria=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).createAlias("Trade", "mt").add(Restrictions.eq("mt.TradeName", "Med Asst"));
				criteria=criteria.add(Restrictions.eq("ServiceNo",serviceNo));
				employeeList=criteria.list();
			}
			else if(!empName.equals(""))
			{
				Criteria crit1=null;
				crit1=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).add(Restrictions.like("FirstName", empName+"%")).createAlias("Trade", "mt").add(Restrictions.eq("mt.TradeName", "Med Asst"));
				if(crit1==null)
				{
					crit1=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).add(Restrictions.like("MiddleName", empName+"%")).createAlias("Trade", "mt").add(Restrictions.eq("mt.TradeName", "Med Asst"));
					if(crit1==null)
					{
						crit1=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).add(Restrictions.like("LastName", empName+"%")).createAlias("Trade", "mt").add(Restrictions.eq("mt.TradeName", "Med Asst"));
					}
				}
				employeeList=crit1.list();
			}
				departmentList=session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
				dutyTimeMasterList=session.createCriteria(HrDutyTimeMaster.class).add(Restrictions.eq("Status", "y")).list();
				dutyExemptionList=session.createCriteria(HrDutyExemptionEntry.class).list();
				map.put("dutyExemptionList", dutyExemptionList);
				map.put("employeeList", employeeList);
				map.put("departmentList", departmentList);
				map.put("dutyTimeMasterList", dutyTimeMasterList);

				int pageno = 1;
				int numOfRows = 10;
				
				
				try
				{
					if (box.get("numOfRows")!=null)
					{
						numOfRows = Integer.parseInt(box.getString("numOfRows"));
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				map.put("pageno", pageno);
				
				int first = (pageno - 1) * numOfRows;
				int totalRecords = 0;
				if(employeeList != null && employeeList.size() > 0)
				{
					
					//String qry="SELECT count(*) FROM mas_employee";
					try
					{
						//totalRecords = Integer.parseInt(session.createSQLQuery(qry).list().get(0).toString());
						totalRecords = employeeList.size();
					}
					catch(Exception e)
					{
					totalRecords = 0;
					}
					map.put("totalRecords", totalRecords);

					
					double totalPages = 0.0;
					totalPages = (double)totalRecords/(double)numOfRows;
					Double d = new Double(Math.ceil(totalPages));
					map.put("totalPages", d.intValue());
					Criteria c =null;
					if(!serviceNo.equals(""))
					{
						c=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).createAlias("Trade", "mt").add(Restrictions.eq("mt.TradeName", "Med Asst"));
						c=c.add(Restrictions.eq("ServiceNo",serviceNo));
					}
					else if(!empName.equals(""))
					{
						c=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).add(Restrictions.like("FirstName", empName+"%")).createAlias("Trade", "mt").add(Restrictions.eq("mt.TradeName", "Med Asst"));
						if(c==null)
						{
							c=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).add(Restrictions.like("MiddleName", empName+"%")).createAlias("Trade", "mt").add(Restrictions.eq("mt.TradeName", "Med Asst"));
							if(c==null)
							{
								c=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).add(Restrictions.like("LastName", empName+"%")).createAlias("Trade", "mt").add(Restrictions.eq("mt.TradeName", "Med Asst"));
							}
						}
					}
					
					//Criteria c =session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y"));
					c.setFirstResult(first);

					if (totalRecords < numOfRows)
						c.setMaxResults(totalRecords);
					else
						c.setMaxResults(numOfRows);
					
					employeeDetailList = c.list();
				}
				map.put("employeeDetailList",employeeDetailList);
				map.put("box", box);
			return map;
		}


		public Map<String, Object> searchDailyRoutineDutyDisplay(Box box) {
			// TODO Auto-generated method stub
			return null;
		}

		/**
		 * --------------------- UPDATE ARRIVAL ENTRY -----------------------------
		 */
		
		public Map<String, Object> showUpdateArrivalSearchJsp() {
				
				Map<String, Object> map = new HashMap<String, Object>();
				
				List<MasRank> rankList = new ArrayList<MasRank>();
				Session session = (Session) getSession();
				try {
					rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).list();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				map.put("rankList", rankList);
				return map;
			}
			
		public Map<String, Object> searchEmployeeForUpdateArrival(Map<String, Object> map) {
			List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
			List<MasRank> rankList = new ArrayList<MasRank>();
			String serviceNo = "";
			int rankId = 0;
			String firstName = "";
			String lastName = "";
			
			Session session = (Session)getSession();
			
			rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).list();
			
			if(map.get("serviceNo") != null){
				serviceNo = (String)map.get("serviceNo");
			}
			if(map.get("rankId") != null){
				rankId = (Integer)map.get("rankId");
			}
			if(map.get("firstName") != null){
				firstName = (String)map.get("firstName");
			}
			if(map.get("lastName") != null){
				lastName = (String)map.get("lastName");
			}
		
			try {
				Criteria crit = session.createCriteria(MasEmployee.class).createAlias("Trade", "tr")
				.add(Restrictions.or(Restrictions.eq("tr.Id",2 ),Restrictions.eq("tr.Id",7 )));
				
					if(!serviceNo.equals("") ){
						crit = crit.add(Restrictions.like("ServiceNo", serviceNo+"%"));
					}
					if(!firstName.equals("")){
						crit = crit.add(Restrictions.like("FirstName", firstName+"%"));
					}
					if(!lastName.equals("")){
						crit = crit.add(Restrictions.like("LastName", lastName+"%"));
					}
					if(rankId != 0 ){
						crit = crit.createAlias("Rank", "rank").add(Restrictions.eq("rank.Id", rankId));
					}
				
					employeeList = crit.list();
			 }catch (Exception e) {
				e.printStackTrace();
			}
			 ////System.out.println("employeeList="+employeeList.size());
			map.put("employeeList", employeeList);
			map.put("rankList", rankList);
			return map;
		}
		
		public Map<String, Object> showUpdateArrivalEntryJsp(int empId) {
			Map<String, Object> map = new HashMap<String, Object>();
			Session session=(Session) getSession();
			List<HrDutyMaster>dutyList=new ArrayList<HrDutyMaster>();
			List<MasEmployee>employeeList=new ArrayList<MasEmployee>();
			List<HrSpecialistMaster>specialityList=new ArrayList<HrSpecialistMaster>();
			List<HrClassMaster>classificationList=new ArrayList<HrClassMaster>();
			
			employeeList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Id", empId)).list();
			dutyList=session.createCriteria(HrDutyMaster.class).add(Restrictions.eq("Status","y")).list();
			specialityList=session.createCriteria(HrSpecialistMaster.class).add(Restrictions.eq("Status","y")).list();
			classificationList=session.createCriteria(HrClassMaster.class).add(Restrictions.eq("Status","y")).list();
			
			map.put("dutyList", dutyList);
			map.put("employeeList", employeeList);
			map.put("specialityList", specialityList);
			map.put("classificationList", classificationList);
			return map;
		}
		
			public boolean submitUpdateArrivalEntry(Box box){
				boolean successfullyAdded=false;
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				Session session = (Session)getSession();

				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				int empId=0;
				int specialityId=0;
				int classificationId=0;

				try {
					HrUpdateArrival hrUpdateArrival=new HrUpdateArrival();
					empId=box.getInt("empId");
					
					MasEmployee masEmployee=new MasEmployee();
					masEmployee.setId(empId);
					hrUpdateArrival.setEmployee(masEmployee);
							
					HrSpecialistMaster hrSpecialistMaster=new HrSpecialistMaster();
					hrSpecialistMaster.setId(box.getInt("specialityId"));
					hrUpdateArrival.setSpeciality(hrSpecialistMaster);
					
					HrClassMaster hrClassificationMaster=new HrClassMaster();
					hrClassificationMaster.setId(box.getInt("classificationId"));
					hrUpdateArrival.setClassification(hrClassificationMaster);
					
					hrUpdateArrival.setStatus("y");
							
					hrUpdateArrival.setLastChgBy(box.getString("changedBy"));
						
					hrUpdateArrival.setLastChgDate(HMSUtil.convertStringTypeDateToDateType((box.getString("changedDate"))));
					hrUpdateArrival.setLastChgTime(box.getString("changedTime"));
					
					MasHospital masHospital=new MasHospital();
					masHospital.setId(box.getInt("hospitalId"));
					hrUpdateArrival.setHospital(masHospital);
					
					hbt.save(hrUpdateArrival);
					successfullyAdded = true;
				} catch (DataAccessException e) {
					e.printStackTrace();
				}
				return successfullyAdded;
			}

/**
 * ------------------------ LEAVE APPLICATION PENDING FOR RECOMMENDATION ---------------------
 */
			public Map<String, Object> searchEmployeeForLeavePending(Map<String, Object> map) {
				List<HrorderlyLeaveApplication> employeeList = new ArrayList<HrorderlyLeaveApplication>();
				Session session = (Session)getSession();
				employeeList=session.createCriteria(HrorderlyLeaveApplication.class).add(Restrictions.eq("RecommendedStatus", "n")).list();
				//System.out.println("employeeList---"+employeeList.size());
				map.put("employeeList", employeeList);
				return map;
			}

			public Map<String, Object> showLeavePendingEntryJsp(int empId) {
				Map<String, Object> map = new HashMap<String, Object>();
				Session session=(Session) getSession();
				List<HrLeaveMaintenance> leaveMaintenanceList=new ArrayList<HrLeaveMaintenance>();
				List<HrLeaveTypeMaster>leaveTypeList=new ArrayList<HrLeaveTypeMaster>();
				List<MasEmployee>employeeList=new ArrayList<MasEmployee>();
				
				employeeList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
				leaveTypeList=session.createCriteria(HrLeaveTypeMaster.class).add(Restrictions.eq("Status","y")).list();
				leaveMaintenanceList=session.createCriteria(HrorderlyLeaveApplication.class).createAlias("Employee", "emp").add(Restrictions.eq("emp.Id", empId)).list();
				//System.out.println("employeeid::"+empId+"leaveMaintenanceList::"+leaveMaintenanceList.size());
				map.put("leaveMaintenanceList", leaveMaintenanceList);
				map.put("employeeList", employeeList);
				return map;
			}

			public boolean submitLeavePendingEntry(Box box){
				boolean successfullyAdded=false;
				int leaveId=0;
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				//System.out.println("leaveId:::"+ box.getInt("leaveId"));
				try {
					HrorderlyLeaveApplication hrLeaveMaintenance=(HrorderlyLeaveApplication) hbt.load(HrorderlyLeaveApplication.class, box.getInt("leaveId"));
					
					if(box.getString("approved")!=null && !box.getString("approved").equals(""))
					{
												
						if(box.getString("approved").equals("y"))
						{
							hrLeaveMaintenance.setRecommendedStatus("y");
						}
					}
					if(box.getInt("approvedBy")!=0 )
					{
						MasEmployee masEmployee=new MasEmployee();
						masEmployee.setId(box.getInt("approvedBy"));
						hrLeaveMaintenance.setApprovedBy(masEmployee);
					}
					
					if(box.getString("approvedDate")!=null && !box.getString("approvedDate").equals(""))
					{
						hrLeaveMaintenance.setApprovedDate(HMSUtil.convertStringTypeDateToDateType((box.getString("approvedDate"))));
					}
					
					if(box.getString("changedBy")!=null && !box.getString("changedBy").equals(""))
					{
						hrLeaveMaintenance.setLstChangedBy(box.getString("changedBy"));
					}
					
					if(box.getString("changedDate")!=null && !box.getString("changedDate").equals(""))
					{
						hrLeaveMaintenance.setLstChangedDate(HMSUtil.convertStringTypeDateToDateType((box.getString("changedDate"))));
					}
					
					if(box.getString("changedTime")!=null && !box.getString("changedTime").equals(""))
					{
						hrLeaveMaintenance.setLstChangedTime(box.getString("changedTime"));
					}

					hbt.update(hrLeaveMaintenance);

				} catch (DataAccessException e) {
					successfullyAdded = false;
					e.printStackTrace();
				}
				successfullyAdded = true;
				return successfullyAdded;
			}

			public Map<String, Object> showGuardDutyEntryJsp() {
				Map<String, Object> map = new HashMap<String, Object>();
				
				List<HrDutyMaster> dutyList = new ArrayList<HrDutyMaster>();
				List<HrDutyTimeMaster> dutyMasterList = new ArrayList<HrDutyTimeMaster>();
				List<HrGuardDutyEntry> guardDutyListForEntryNo=new ArrayList<HrGuardDutyEntry>();
				List<MasDepartmentType> masdepartmenttypeList = new ArrayList<MasDepartmentType>();
				 MasDepartmentType masdepartmenttype = null;
		        List<MasDepartment> masdepartmentList=new ArrayList<MasDepartment>();
		        
				Session session = (Session) getSession();
				String entryNo="";
				try {
					dutyList = session.createCriteria(HrDutyMaster.class).add(Restrictions.eq("DutyName", "Guard Duty")).add(Restrictions.eq("Status", "y")).list();
					guardDutyListForEntryNo=session.createCriteria(HrGuardDutyEntry.class).add(Restrictions.eq("Status", "a")).addOrder(Order.asc("DutyDate")).list();
					dutyMasterList=session.createCriteria(HrDutyTimeMaster.class).add(Restrictions.eq("Status", "y")).list();
					Set<String> guardDutySetForEntryNoSet=new TreeSet<String>();
					for(HrGuardDutyEntry hrGuardDutyEntry:guardDutyListForEntryNo){
						guardDutySetForEntryNoSet.add(hrGuardDutyEntry.getEntryNo());
					}
					masdepartmenttypeList=session.createCriteria(MasDepartmentType.class).add(Restrictions.eq("DepartmentTypeName","Gaurd Duty Locations")).list();
					if(masdepartmenttypeList.size()!=0)
					{
						masdepartmenttype=(MasDepartmentType)masdepartmenttypeList.get(0);
						masdepartmentList=session.createCriteria(MasDepartment.class).createAlias("DepartmentType","dt").add(Restrictions.eq("dt.Id", masdepartmenttype.getId())).list();
					}

				entryNo=getEntrySeqForGuardDutyDisplay();
				//System.out.println("guardDutySetForEntryNoSet"+guardDutySetForEntryNoSet.size()+"::masdepartmentList"+masdepartmentList.size());
				map.put("entryNo",entryNo);
				if(dutyList!=null){
				map.put("dutyId", dutyList.get(0).getId());
				}
				//map.put("dutyEntryList",guardDutyListForEntryNo);
				map.put("dutyMasterList", dutyMasterList);
				map.put("masdepartmentList", masdepartmentList);
					} catch (Exception e) {
						e.printStackTrace();
					}
				return map;
			}

			public Map<String, Object> showNightDutyEntryJsp() {
				Map<String, Object> map = new HashMap<String, Object>();
				
				List<HrDutyMaster> dutyList = new ArrayList<HrDutyMaster>();
				List<HrDutyEntry>nightDutyListForEntryNo=new ArrayList<HrDutyEntry>();
				Session session = (Session) getSession();
				String entryNo="";
				try {
					dutyList = session.createCriteria(HrDutyMaster.class).add(Restrictions.eq("DutyName", "Night Duty")).add(Restrictions.eq("Status", "y")).list();
					nightDutyListForEntryNo=session.createCriteria(HrDutyEntry.class).add(Restrictions.eq("Status", "y")).list();
					
					//System.out.println("nightDutyListForEntryNo ---  "+nightDutyListForEntryNo.size());
					Set<String> nightDutySetForEntryNoSet=new TreeSet<String>();
					for(HrDutyEntry hrDutyEntry:nightDutyListForEntryNo){
						nightDutySetForEntryNoSet.add(hrDutyEntry.getEntryNo());
					}
				entryNo=getEntrySeqForNightDutyDisplay();
				map.put("entryNo",entryNo);
				map.put("nightDutySetForEntryNoSet",nightDutySetForEntryNoSet);
				if(dutyList.size()!=0){
				map.put("dutyId", dutyList.get(0).getId());
				//System.out.println("+dutyList.get(0).getId()  "+dutyList.get(0).getId());
				}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return map;
			}

			public Map<String, Object> showOrderlyDutyEntryJsp() {
				Map<String, Object> map = new HashMap<String, Object>();
				
				List<HrDutyMaster> dutyList = new ArrayList<HrDutyMaster>();
				List<HrOrderlyDutyEntry>orderlyDutyListForEntryNo=new ArrayList<HrOrderlyDutyEntry>();
				Session session = (Session) getSession();
				String entryNo="";
				try {
					dutyList = session.createCriteria(HrDutyMaster.class).add(Restrictions.eq("DutyName", "Orderly Duty")).add(Restrictions.eq("Status", "y")).list();
					orderlyDutyListForEntryNo=session.createCriteria(HrOrderlyDutyEntry.class).add(Restrictions.eq("Status", "y")).list();
					Set<String> orderlyDutySetForEntryNoSet=new TreeSet<String>();
					for(HrOrderlyDutyEntry hrOrderlyDutyEntry:orderlyDutyListForEntryNo){
						orderlyDutySetForEntryNoSet.add(hrOrderlyDutyEntry.getEntryNo());
					}
				entryNo=getEntrySeqForOrderlyDutyDisplay();
				map.put("entryNo",entryNo);
				if(dutyList.size()!=0){
				map.put("dutyId", dutyList.get(0).getId());
				}
				map.put("orderlyDutySetForEntryNoSet",orderlyDutySetForEntryNoSet);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				return map;
			}

			public Map<String, Object> showWardDutyEntryJsp() {
				Map<String, Object> map = new HashMap<String, Object>();
				
				List<HrDutyMaster> dutyList = new ArrayList<HrDutyMaster>();
				List<HrWardDutyEntry>wardDutyListForEntryNo=new ArrayList<HrWardDutyEntry>();
				Session session = (Session) getSession();
				String entryNo="";
				try {
					dutyList = session.createCriteria(HrDutyMaster.class).add(Restrictions.eq("DutyName", "Ward Duty")).add(Restrictions.eq("Status", "y")).list();
					wardDutyListForEntryNo=session.createCriteria(HrWardDutyEntry.class).add(Restrictions.eq("Status", "y")).list();
					Set<String> wardDutySetForEntryNoSet=new TreeSet<String>();
					for(HrWardDutyEntry hrWardDutyEntry:wardDutyListForEntryNo){
						wardDutySetForEntryNoSet.add(hrWardDutyEntry.getEntryNo());
					}
				entryNo=getEntrySeqForWardDutyDisplay();
				map.put("entryNo",entryNo);
				if(dutyList!=null){
				map.put("dutyId", dutyList.get(0).getId());
				}
				map.put("wardDutySetForEntryNoSet",wardDutySetForEntryNoSet);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return map;
			}

			public String getEntrySeqForNightDutyDisplay()
			   {
			      List<TransactionSequence> orderSeqNoList = new ArrayList<TransactionSequence>();
			      TransactionSequence transactionSequence = new TransactionSequence();
			      List<HrDutyEntry> seqNoList = new ArrayList<HrDutyEntry>();
			      String entrySeqNo = "";
			      String lastSeqNo = "";
			      String lastSeqYear = "";

			      Map<String, Object> utilMap = new HashMap<String, Object>();
			      utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			      String date = (String) utilMap.get("currentDate");

			      String currentYear = date.substring(date.lastIndexOf("/") + 1);
			      Session session = (Session) getSession();
			      try
			      {
			         seqNoList = session.createCriteria(HrDutyEntry.class).list();
			         if (seqNoList.size() > 0)
			         {
			            for (HrDutyEntry hrDutyEntry : seqNoList)
			            {
			               lastSeqNo = hrDutyEntry.getEntryNo();
			            }
			            StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
			            while (str.hasMoreTokens())
			            {
			               lastSeqYear = str.nextToken();
			            }
			         } else
			         {
			            lastSeqYear = currentYear;
			         }

			         orderSeqNoList = session.createCriteria(TransactionSequence.class).add(
			               Restrictions.eq("TransactionPrefix", "NEY")).list();
			         //.setProjection(Projections.projectionList().add(Projections.max("TransactionSequenceNumber")))
			         if (orderSeqNoList.size() > 0)
			         {
			            for (TransactionSequence maxOrderNo : orderSeqNoList)
			            {
			               if (currentYear.equals(lastSeqYear))
			               {
			                  entrySeqNo = String.valueOf(maxOrderNo.getTransactionSequenceNumber() + 1);
			                  //maxOrderNo.setTransactionSequenceNumber(maxOrderNo.getTransactionSequenceNumber() + 1);
			               } else
			               {
			                  entrySeqNo = String.valueOf(1);
			                  maxOrderNo.setTransactionSequenceNumber(1);
			                 
			               }
			               session.saveOrUpdate(maxOrderNo);
			               session.refresh(maxOrderNo);
			            }
			            
			         } else
			         {
			            entrySeqNo = String.valueOf(1);
			            transactionSequence.setTransactionSequenceNumber(1);
			            transactionSequence.setTransactionSequenceName("NightDutyEntryNo");
			            transactionSequence.setTransactionPrefix("NEY");
			            transactionSequence.setTablename("HrDutyEntry");
			            transactionSequence.setStatus("y");
			            session.save(transactionSequence);
			            session.refresh(transactionSequence);
			            
			         }
			         entrySeqNo = entrySeqNo.concat("/").concat(String.valueOf(lastSeqYear));
			      } catch (HibernateException e)
			      {
			         e.printStackTrace();
			      }
			      return entrySeqNo;
			   }
			
			public String getEntrySeqForOrderlyDutyDisplay()
			   {
			      List<TransactionSequence> orderSeqNoList = new ArrayList<TransactionSequence>();
			      List<HrOrderlyDutyEntry> seqNoList = new ArrayList<HrOrderlyDutyEntry>();
			      String entrySeqNo = "";
			      String lastSeqNo = "";
			      String lastSeqYear = "";

			      Map<String, Object> utilMap = new HashMap<String, Object>();
			      utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			      String date = (String) utilMap.get("currentDate");

			      String currentYear = date.substring(date.lastIndexOf("/") + 1);
			      Session session = (Session) getSession();
			      try
			      {
			         seqNoList = session.createCriteria(HrOrderlyDutyEntry.class).list();
			         if (seqNoList.size() > 0)
			         {
			            for (HrOrderlyDutyEntry hrOrderlyDutyEntry : seqNoList)
			            {
			               lastSeqNo = hrOrderlyDutyEntry.getEntryNo();
			            }
			            StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
			            while (str.hasMoreTokens())
			            {
			               lastSeqYear = str.nextToken();
			            }
			         } else
			         {
			            lastSeqYear = currentYear;
			         }

			         orderSeqNoList = session.createCriteria(TransactionSequence.class).add(
			               Restrictions.eq("TransactionPrefix", "OEN")).list();
			         if (orderSeqNoList.size() > 0)
			         {
			            for (TransactionSequence maxOrderNo : orderSeqNoList)
			            {
			               if (currentYear.equals(lastSeqYear))
			               {
			                  entrySeqNo = String.valueOf(maxOrderNo.getTransactionSequenceNumber() + 1);
			               } else
			               {
			                  entrySeqNo = String.valueOf(1);
			                  maxOrderNo.setTransactionSequenceNumber(1);
			               }
			               session.saveOrUpdate(maxOrderNo);
			               session.refresh(maxOrderNo);
			            }
			         } else
			         {
			            entrySeqNo = String.valueOf(1);
			            TransactionSequence transactionSeq = new TransactionSequence();
			            transactionSeq.setTransactionSequenceNumber(1);
			            transactionSeq.setTransactionSequenceName("Orderly Duty Entry ");
			            transactionSeq.setTransactionPrefix("OEN");
			            transactionSeq.setTablename("HrOrderlyDutyEntry");
			            transactionSeq.setStatus("y");
			            session.save(transactionSeq);
			            session.refresh(transactionSeq);
			         }
			         entrySeqNo = entrySeqNo.concat("/").concat(String.valueOf(lastSeqYear));
			      } catch (HibernateException e)
			      {
			         e.printStackTrace();
			      }
			      return entrySeqNo;
			   }
			
			public String getEntrySeqForWardDutyDisplay()
			   {
			      List<TransactionSequence> orderSeqNoList = new ArrayList<TransactionSequence>();
			      List<HrWardDutyEntry> seqNoList = new ArrayList<HrWardDutyEntry>();
			      String entrySeqNo = "";
			      String lastSeqNo = "";
			      String lastSeqYear = "";

			      Map<String, Object> utilMap = new HashMap<String, Object>();
			      utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			      String date = (String) utilMap.get("currentDate");

			      String currentYear = date.substring(date.lastIndexOf("/") + 1);
			      Session session = (Session) getSession();
			      try
			      {
			         seqNoList = session.createCriteria(HrWardDutyEntry.class).list();
			         if (seqNoList.size() > 0)
			         {
			            for (HrWardDutyEntry hrWardDutyEntry : seqNoList)
			            {
			               lastSeqNo = hrWardDutyEntry.getEntryNo();
			            }
			            StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
			            while (str.hasMoreTokens())
			            {
			               lastSeqYear = str.nextToken();
			            }
			         } else
			         {
			            lastSeqYear = currentYear;
			         }

			         orderSeqNoList = session.createCriteria(TransactionSequence.class).add(
			               Restrictions.eq("TransactionPrefix", "WEN")).list();
			         if (orderSeqNoList.size() > 0)
			         {
			            for (TransactionSequence maxOrderNo : orderSeqNoList)
			            {
			               if (currentYear.equals(lastSeqYear))
			               {
			                  entrySeqNo = String.valueOf(maxOrderNo.getTransactionSequenceNumber() + 1);
			               } else
			               {
			                  entrySeqNo = String.valueOf(1);
			                  maxOrderNo.setTransactionSequenceNumber(1);
			               }
			               session.saveOrUpdate(maxOrderNo);
			               session.refresh(maxOrderNo);
			            }
			         } else
			         {
			            entrySeqNo = String.valueOf(1);
			            TransactionSequence transactionSeq = new TransactionSequence();
			            transactionSeq.setTransactionSequenceNumber(1);
			            transactionSeq.setTransactionSequenceName("Duty Exemptions Entry ");
			            transactionSeq.setTransactionPrefix("WEN");
			            transactionSeq.setTablename("HrWardDutyEntry");
			            transactionSeq.setStatus("y");
			            session.save(transactionSeq);
			            session.refresh(transactionSeq);
			         }
			         entrySeqNo = entrySeqNo.concat("/").concat(String.valueOf(lastSeqYear));
			      } catch (HibernateException e)
			      {
			         e.printStackTrace();
			      }
			      return entrySeqNo;
			   }
			
			public String getEntrySeqForGuardDutyDisplay()
			   {
			      List<TransactionSequence> orderSeqNoList = new ArrayList<TransactionSequence>();
			      List<HrGuardDutyEntry> seqNoList = new ArrayList<HrGuardDutyEntry>();
			      String entrySeqNo = "";
			      String lastSeqNo = "";
			      String lastSeqYear = "";

			      Map<String, Object> utilMap = new HashMap<String, Object>();
			      utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			      String date = (String) utilMap.get("currentDate");

			      String currentYear = date.substring(date.lastIndexOf("/") + 1);
			      Session session = (Session) getSession();
			      try
			      {
			         seqNoList = session.createCriteria(HrGuardDutyEntry.class).list();
			         if (seqNoList.size() > 0)
			         {
			            for (HrGuardDutyEntry hrGuardDutyEntry : seqNoList)
			            {
			               lastSeqNo = hrGuardDutyEntry.getEntryNo();
			            }
			            StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
			            while (str.hasMoreTokens())
			            {
			               lastSeqYear = str.nextToken();
			            }
			         } else
			         {
			            lastSeqYear = currentYear;
			         }

			         orderSeqNoList = session.createCriteria(TransactionSequence.class).add(
			               Restrictions.eq("TransactionPrefix", "GEN")).list();
			         //.setProjection(Projections.projectionList().add(Projections.max("TransactionSequenceNumber")))
			         //System.out.println("orderSeqNoList:::"+orderSeqNoList.size());
			         if (orderSeqNoList!=null && orderSeqNoList.size() > 0)
			         {
			            for (TransactionSequence maxOrderNo : orderSeqNoList)
			            {
			               if (currentYear.equals(lastSeqYear))
			               {
			                  entrySeqNo = String.valueOf(maxOrderNo.getTransactionSequenceNumber() + 1);
			               } else
			               {
			                  entrySeqNo = String.valueOf(1);
			                  
			               }
			            }
			         } else
			         {
			              entrySeqNo = String.valueOf(1);
			              TransactionSequence transactionSequence = new TransactionSequence();
		                  transactionSequence.setTransactionPrefix("GEN");
		                  transactionSequence.setTransactionSequenceName("Guard Duty Entry No.");
		                  transactionSequence.setTransactionSequenceNumber(1);
		                  transactionSequence.setTablename("HrGuardDutyEntry");
		                  transactionSequence.setStatus("y");
		                  session.save(transactionSequence);
		                  session.refresh(transactionSequence);
			         }
			         entrySeqNo = entrySeqNo.concat("/").concat(String.valueOf(lastSeqYear));
			      } catch (HibernateException e)
			      {
			         e.printStackTrace();
			      }
			      return entrySeqNo;
			   }

			/**
			 * --------------- DELETE METHODS -----------------------
			 */
			
			public boolean deleteNightDutyEntry(Box box){
				boolean successfullyAdded=false;
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				
				String empName="";
				Vector dutyId=box.getVector("nightDutyId");
				Vector dutyToBeUpdated=box.getVector("dutyToBeUpdated");
				
				try {
				
				for(int i=0;i<dutyId.size();i++)
				{
					if(dutyToBeUpdated.contains(dutyId.get(i)))
					{
							HrDutyEntry hrDutyEntry=(HrDutyEntry) hbt.load(HrDutyEntry.class, Integer.parseInt(dutyId.get(i).toString()));
							
							hrDutyEntry.setStatus("n");
							
								hbt.update(hrDutyEntry);
						}
					}
				} catch (Exception e) {
					successfullyAdded = false;
					e.printStackTrace();
				} 
				
						
					successfullyAdded = true;
				
					return successfullyAdded;
			}
			
			public boolean deleteGuardDutyEntry(Box box){
				boolean successfullyAdded=false;
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				
				String empName="";
				Vector dutyId=box.getVector("guardDutyId");
				Vector dutyToBeUpdated=box.getVector("dutyToBeUpdated");
				
				try {
				
				for(int i=0;i<dutyId.size();i++)
				{
					if(dutyToBeUpdated.contains(dutyId.get(i)))
					{
							HrGuardDutyEntry hrGuardDutyEntry=(HrGuardDutyEntry) hbt.load(HrGuardDutyEntry.class, Integer.parseInt(dutyId.get(i).toString()));
							
							hrGuardDutyEntry.setStatus("n");
							
								hbt.update(hrGuardDutyEntry);
						}
					}
				} catch (Exception e) {
					successfullyAdded = false;
					e.printStackTrace();
				} 
				
						
					successfullyAdded = true;
				
					return successfullyAdded;
			}
			
			public boolean deleteWardDutyEntry(Box box){
				boolean successfullyAdded=false;
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				
				String empName="";
				Vector dutyId=box.getVector("wardDutyId");
				Vector dutyToBeUpdated=box.getVector("dutyToBeUpdated");
				
				try {
				
				for(int i=0;i<dutyId.size();i++)
				{
					if(dutyToBeUpdated.contains(dutyId.get(i)))
					{
							HrWardDutyEntry hrWardDutyEntry=(HrWardDutyEntry) hbt.load(HrWardDutyEntry.class, Integer.parseInt(dutyId.get(i).toString()));
							
							hrWardDutyEntry.setStatus("n");
							
								hbt.update(hrWardDutyEntry);
						}
					}
				} catch (Exception e) {
					successfullyAdded = false;
					e.printStackTrace();
				} 
				
						
					successfullyAdded = true;
				
					return successfullyAdded;
			}
			
			public boolean deleteOrderlyDutyEntry(Box box){
				boolean successfullyAdded=false;
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				
				String empName="";
				Vector dutyId=box.getVector("orderlyDutyId");
				Vector dutyToBeUpdated=box.getVector("dutyToBeUpdated");
				
				try {
				
				for(int i=0;i<dutyId.size();i++)
				{
					if(dutyToBeUpdated.contains(dutyId.get(i)))
					{
							HrOrderlyDutyEntry hrOrderlyDutyEntry=(HrOrderlyDutyEntry) hbt.load(HrOrderlyDutyEntry.class, Integer.parseInt(dutyId.get(i).toString()));
							
							hrOrderlyDutyEntry.setStatus("n");
							
								hbt.update(hrOrderlyDutyEntry);
						}
					}
				} catch (Exception e) {
					successfullyAdded = false;
					e.printStackTrace();
				} 
				
						
					successfullyAdded = true;
				
					return successfullyAdded;
			}
			
			public boolean deleteDailyRoutineDutyEntry(Box box){
				boolean successfullyAdded=false;
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				
				String empName="";
				Vector dutyId=box.getVector("dailyRoutineDutyId");
				Vector dutyToBeUpdated=box.getVector("dutyToBeUpdated");
				
				try {
				
				for(int i=0;i<dutyId.size();i++)
				{
					if(dutyToBeUpdated.contains(dutyId.get(i)))
					{
							HrDailyRoutineDutyEntry hrDailyRoutineDutyEntry=(HrDailyRoutineDutyEntry) hbt.load(HrDailyRoutineDutyEntry.class, Integer.parseInt(dutyId.get(i).toString()));
							
							hrDailyRoutineDutyEntry.setStatus("n");
							
								hbt.update(hrDailyRoutineDutyEntry);
						}
					}
				} catch (Exception e) {
					successfullyAdded = false;
					e.printStackTrace();
				} 
				
						
					successfullyAdded = true;
				
					return successfullyAdded;
			}
			
			/**
			 * ----------------- SEARCH METHODS FOR THE MAIN DUTY SCREENS ---------------------
			 */
			public Map<String, Object> searchNightDutyData(Box box) {
				Map<String, Object> map = new HashMap<String, Object>();
				
				List<HrDutyEntry> searchNightDutyList = new ArrayList<HrDutyEntry>();
				List<HrDutyMaster> dutyList = new ArrayList<HrDutyMaster>();
				List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
				List<HrDutyTimeMaster> dutyMasterList = new ArrayList<HrDutyTimeMaster>();
				List<HrDutyEntry>nightDutyListForEntryNo=new ArrayList<HrDutyEntry>();
				Set<String> nightDutySetForEntryNoSet=new TreeSet<String>();
				
				String entryNo="";
				Session session = (Session) getSession();
				try {
				Criteria crit=session.createCriteria(HrDutyEntry.class).add(Restrictions.eq("Status", "w"));
				if(!box.getString("searchEntryNo").equals(""))
				{
					crit=crit.add(Restrictions.eq("EntryNo",box.getString("searchEntryNo")));
				}
				if(!box.getString("searchEntryDate").equals(""))
				{
					crit=crit.add(Restrictions.eq("EntryDate",HMSUtil.convertStringTypeDateToDateType(box.getString("searchEntryDate"))));
				}
				searchNightDutyList=crit.list();
				nightDutyListForEntryNo=session.createCriteria(HrDutyEntry.class).add(Restrictions.eq("Status", "y")).list();
				dutyList = session.createCriteria(HrDutyMaster.class).add(Restrictions.eq("DutyName", "Night Duty")).add(Restrictions.eq("Status", "y")).list();
				departmentList=session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
				dutyMasterList=session.createCriteria(HrDutyTimeMaster.class).add(Restrictions.eq("Status","y")).list();
				
				nightDutyListForEntryNo=session.createCriteria(HrDutyEntry.class).add(Restrictions.eq("Status", "y")).list();
				for(HrDutyEntry hrDutyEntry:nightDutyListForEntryNo){
					nightDutySetForEntryNoSet.add(hrDutyEntry.getEntryNo());
				}

				
				} catch (Exception e) {
					e.printStackTrace();
				}
				entryNo=getEntrySeqForNightDutyDisplay();
				map.put("entryNo",entryNo);
				map.put("searchNightDutyList",searchNightDutyList);
				map.put("nightDutyListForEntryNo",nightDutyListForEntryNo);
				map.put("dutyId", dutyList.get(0).getId());
				map.put("departmentList", departmentList);
				map.put("dutyMasterList", dutyMasterList);
				map.put("nightDutySetForEntryNoSet",nightDutySetForEntryNoSet);
				
				return map;
			}
			
			public Map<String, Object> searchGuardDutyData(Box box) {
				Map<String, Object> map = new HashMap<String, Object>();
				
				List<HrGuardDutyEntry> searchGuardDutyList = new ArrayList<HrGuardDutyEntry>();
				List<HrGuardDutyEntry>GuardDutyListForEntryNo=new ArrayList<HrGuardDutyEntry>();
				List<HrDutyMaster> dutyList = new ArrayList<HrDutyMaster>();
				List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
				List<MasDepartmentType> masDepartmentTypeList = new ArrayList<MasDepartmentType>();
				MasDepartmentType masDepartmentType =new MasDepartmentType();
				List<HrDutyTimeMaster> dutyMasterList = new ArrayList<HrDutyTimeMaster>();
				List<HrGuardDutyEntry>guardDutyListForEntryNo=new ArrayList<HrGuardDutyEntry>();
				Set<String> guardDutySetForEntryNoSet=new TreeSet<String>();
				
				String entryNo="";
				Session session = (Session) getSession();
				try {
				Criteria crit=session.createCriteria(HrGuardDutyEntry.class).add(Restrictions.eq("Status", "w")).addOrder(Order.desc("DutyDate"));
				if(!box.getString("searchEntryNo").equals(""))
				{
					crit=crit.add(Restrictions.eq("EntryNo",box.getString("searchEntryNo")));
				}
				if(!box.getString("searchEntryDate").equals(""))
				{
					crit=crit.add(Restrictions.eq("EntryDate",HMSUtil.convertStringTypeDateToDateType(box.getString("searchEntryDate"))));
				}
				searchGuardDutyList=crit.list();
				//System.out.println("searchGuardDutyList.size() in dssssss -----  "+searchGuardDutyList.size());
				GuardDutyListForEntryNo=session.createCriteria(HrGuardDutyEntry.class).add(Restrictions.eq("Status", "y")).list();
				dutyList = session.createCriteria(HrDutyMaster.class).add(Restrictions.eq("DutyName", "Guard Duty")).add(Restrictions.eq("Status", "y")).list();
				masDepartmentTypeList=session.createCriteria(MasDepartmentType.class).add(Restrictions.eq("DepartmentTypeName", "Ward Duty Locations")).list();
				if(masDepartmentTypeList.size()!=0){
					masDepartmentType=masDepartmentTypeList.get(0);
				departmentList=session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).createAlias("DepartmentType", "dt").add(Restrictions.eq("dt.Id",masDepartmentType.getId())).list();
				}
				dutyMasterList=session.createCriteria(HrDutyTimeMaster.class).add(Restrictions.eq("Status","y")).list();
				
				guardDutyListForEntryNo=session.createCriteria(HrorderlyGuardDutyEntry.class).add(Restrictions.eq("Status", "y")).list();
				for(HrGuardDutyEntry hrGuardDutyEntry:guardDutyListForEntryNo){
					guardDutySetForEntryNoSet.add(hrGuardDutyEntry.getEntryNo());
				}

				
				} catch (Exception e) {
					e.printStackTrace();
				}
				entryNo=getEntrySeqForGuardDutyDisplay();
				map.put("entryNo",entryNo);
				map.put("dutyEntryList",searchGuardDutyList);
				map.put("GuardDutyListForEntryNo",GuardDutyListForEntryNo);
				map.put("dutyId", dutyList.get(0).getId());
				map.put("masdepartmentList", departmentList);
				map.put("dutyMasterList", dutyMasterList);
				map.put("guardDutySetForEntryNoSet",guardDutySetForEntryNoSet);
				
				return map;
			}
			
			public Map<String, Object> searchWardDutyData(Box box) {
				Map<String, Object> map = new HashMap<String, Object>();
				
				List<HrWardDutyEntry> searchWardDutyList = new ArrayList<HrWardDutyEntry>();
				List<HrWardDutyEntry>WardDutyListForEntryNo=new ArrayList<HrWardDutyEntry>();
				List<HrDutyMaster> dutyList = new ArrayList<HrDutyMaster>();
				List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
				List<HrDutyTimeMaster> dutyMasterList = new ArrayList<HrDutyTimeMaster>();
				List<HrWardDutyEntry>wardDutyListForEntryNo=new ArrayList<HrWardDutyEntry>();
				List<MasDepartmentType> masdepartmenttypeList = new ArrayList<MasDepartmentType>();
				MasDepartmentType masdepartmenttype = null;
				Set<String> wardDutySetForEntryNoSet=new TreeSet<String>();
				
				String entryNo="";
				//System.out.println("entry no.::"+box.getString("searchEntryNo")+"::entrydate::"+box.getString("searchEntryDate"));
				Session session = (Session) getSession();
				try {
				Criteria crit=session.createCriteria(HrWardDutyEntry.class).add(Restrictions.eq("Status", "w"));
				if(!box.getString("searchEntryNo").equals(""))
				{
					crit=crit.add(Restrictions.eq("EntryNo",box.getString("searchEntryNo")));
				}
				if(!box.getString("searchEntryDate").equals(""))
				{
					crit=crit.add(Restrictions.eq("EntryDate",HMSUtil.convertStringTypeDateToDateType(box.getString("searchEntryDate"))));
				}
				searchWardDutyList=crit.list();
				masdepartmenttypeList=session.createCriteria(MasDepartmentType.class).add(Restrictions.eq("DepartmentTypeName","Ward Duty Locations")).list();
				if(masdepartmenttypeList.size()!=0)
				{
					masdepartmenttype=(MasDepartmentType)masdepartmenttypeList.get(0);
					departmentList=session.createCriteria(MasDepartment.class).createAlias("DepartmentType","dt").add(Restrictions.eq("dt.Id", masdepartmenttype.getId())).list();
				}
				WardDutyListForEntryNo=session.createCriteria(HrWardDutyEntry.class).add(Restrictions.eq("Status", "y")).list();
				dutyList = session.createCriteria(HrDutyMaster.class).add(Restrictions.eq("DutyName", "Ward Duty")).add(Restrictions.eq("Status", "y")).list();
				//departmentList=session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
				dutyMasterList=session.createCriteria(HrDutyTimeMaster.class).add(Restrictions.eq("Status","y")).list();
				
				wardDutyListForEntryNo=session.createCriteria(HrWardDutyEntry.class).add(Restrictions.eq("Status", "y")).list();
				for(HrWardDutyEntry hrWardDutyEntry:wardDutyListForEntryNo){
					wardDutySetForEntryNoSet.add(hrWardDutyEntry.getEntryNo());
				}

				
				} catch (Exception e) {
					e.printStackTrace();
				}
				entryNo=getEntrySeqForWardDutyDisplay();
				map.put("entryNo",entryNo);
				map.put("searchWardDutyList",searchWardDutyList);
				map.put("WardDutyListForEntryNo",WardDutyListForEntryNo);
				map.put("dutyId", dutyList.get(0).getId());
				map.put("departmentList", departmentList);
				map.put("dutyMasterList", dutyMasterList);
				map.put("wardDutySetForEntryNoSet",wardDutySetForEntryNoSet);
				
				return map;
			}
			
			public Map<String, Object> searchOrderlyDutyData(Box box) {
				Map<String, Object> map = new HashMap<String, Object>();
				
				List<HrOrderlyDutyEntry> searchOrderlyDutyList = new ArrayList<HrOrderlyDutyEntry>();
				List<HrOrderlyDutyEntry>OrderlyDutyListForEntryNo=new ArrayList<HrOrderlyDutyEntry>();
				List<HrDutyMaster> dutyList = new ArrayList<HrDutyMaster>();
				List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
				List<HrDutyTimeMaster> dutyMasterList = new ArrayList<HrDutyTimeMaster>();
				List<HrOrderlyDutyEntry>orderlyDutyListForEntryNo=new ArrayList<HrOrderlyDutyEntry>();
				Set<String> orderlyDutySetForEntryNoSet=new TreeSet<String>();
				List<MasDepartmentType> masdepartmenttypeList = new ArrayList<MasDepartmentType>();
			    MasDepartmentType masdepartmenttype = null;
				String entryNo="";
				Session session = (Session) getSession();
				try {
					masdepartmenttypeList=session.createCriteria(MasDepartmentType.class).add(Restrictions.eq("DepartmentTypeName","Orderly Duty Locations")).list();
					if(masdepartmenttypeList.size()!=0)
					{
						masdepartmenttype=(MasDepartmentType)masdepartmenttypeList.get(0);
						departmentList=session.createCriteria(MasDepartment.class).createAlias("DepartmentType","dt").add(Restrictions.eq("dt.Id", masdepartmenttype.getId())).list();
					}
				Criteria crit=session.createCriteria(HrOrderlyDutyEntry.class).add(Restrictions.eq("Status", "w"));
				if(!box.getString("searchEntryNo").equals(""))
				{
					crit=crit.add(Restrictions.eq("EntryNo",box.getString("searchEntryNo")));
				}
				if(!box.getString("searchEntryDate").equals(""))
				{
					crit=crit.add(Restrictions.eq("EntryDate",HMSUtil.convertStringTypeDateToDateType(box.getString("searchEntryDate"))));
				}
				searchOrderlyDutyList=crit.list();
				OrderlyDutyListForEntryNo=session.createCriteria(HrOrderlyDutyEntry.class).add(Restrictions.eq("Status", "y")).list();
				dutyList = session.createCriteria(HrDutyMaster.class).add(Restrictions.eq("DutyName", "Orderly Duty")).add(Restrictions.eq("Status", "y")).list();
				//departmentList=session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
				dutyMasterList=session.createCriteria(HrDutyTimeMaster.class).add(Restrictions.eq("Status","y")).list();
				
				orderlyDutyListForEntryNo=session.createCriteria(HrOrderlyDutyEntry.class).add(Restrictions.eq("Status", "y")).list();
				for(HrOrderlyDutyEntry hrOrderlyDutyEntry:orderlyDutyListForEntryNo){
					orderlyDutySetForEntryNoSet.add(hrOrderlyDutyEntry.getEntryNo());
				}

				
				} catch (Exception e) {
					e.printStackTrace();
				}
				entryNo=getEntrySeqForOrderlyDutyDisplay();
				map.put("entryNo",entryNo);
				map.put("searchOrderlyDutyList",searchOrderlyDutyList);
				map.put("OrderlyDutyListForEntryNo",OrderlyDutyListForEntryNo);
				map.put("dutyId", dutyList.get(0).getId());
				map.put("departmentList", departmentList);
				map.put("dutyMasterList", dutyMasterList);
				map.put("orderlyDutySetForEntryNoSet",orderlyDutySetForEntryNoSet);
				
				return map;
			}
			
			public Map<String, Object> searchDailyRoutineDutyData(Box box) {
				Map<String, Object> map = new HashMap<String, Object>();
				
				List<HrDailyRoutineDutyEntry> searchDailyRoutineDutyList = new ArrayList<HrDailyRoutineDutyEntry>();
				List<HrDailyRoutineDutyEntry>DailyRoutineDutyListForEntryNo=new ArrayList<HrDailyRoutineDutyEntry>();
				List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
				List<HrDutyTimeMaster> dutyMasterList = new ArrayList<HrDutyTimeMaster>();
				List<HrDutyMaster> dutyNameList = new ArrayList<HrDutyMaster>();
				List<HrDailyRoutineDutyEntry>dailyRoutineDutyListForEntryNo=new ArrayList<HrDailyRoutineDutyEntry>();
				
				String entryNo="";
				Session session = (Session) getSession();
				try {
				Criteria crit=session.createCriteria(HrDailyRoutineDutyEntry.class).add(Restrictions.eq("Status", "y"));
				if(!box.getString("searchEntryNo").equals(""))
				{
					crit=crit.add(Restrictions.eq("EntryNo",box.getString("searchEntryNo")));
				}
				if(!box.getString("searchEntryDate").equals(""))
				{
					crit=crit.add(Restrictions.eq("EntryDate",HMSUtil.convertStringTypeDateToDateType(box.getString("searchEntryDate"))));
				}
				searchDailyRoutineDutyList=crit.list();
				DailyRoutineDutyListForEntryNo=session.createCriteria(HrDailyRoutineDutyEntry.class).add(Restrictions.eq("Status", "y")).list();
				dutyNameList = session.createCriteria(HrDutyMaster.class).add(Restrictions.eq("Status", "y")).list();
				departmentList=session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
				dutyMasterList=session.createCriteria(HrDutyTimeMaster.class).add(Restrictions.eq("Status","y")).list();
				dailyRoutineDutyListForEntryNo=session.createCriteria(HrDailyRoutineDutyEntry.class).add(Restrictions.eq("Status", "y")).list();
				Set<String> dailyRoutineSetForEntryNoSet=new TreeSet<String>();
				for(HrDailyRoutineDutyEntry hrDailyRoutineDutyEntry:dailyRoutineDutyListForEntryNo){
					dailyRoutineSetForEntryNoSet.add(hrDailyRoutineDutyEntry.getEntryNo());
				}

				map.put("dailyRoutineSetForEntryNoSet",dailyRoutineSetForEntryNoSet);
				} catch (Exception e) {
					e.printStackTrace();
				}
				entryNo=getEntrySeqForDailyRoutineDisplay();
				map.put("entryNo",entryNo);
				map.put("searchDailyRoutineDutyList",searchDailyRoutineDutyList);
				map.put("DailyRoutineDutyListForEntryNo",DailyRoutineDutyListForEntryNo);
				map.put("departmentList", departmentList);
				map.put("dutyMasterList", dutyMasterList);
				map.put("dutyNameList", dutyNameList);
				
				return map;
			}
			public Map<String, Object> searchEmployeeForNightDutyAddition(Map<String, Object> map) {
				List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
				List<MasRank> rankList = new ArrayList<MasRank>();
				String serviceNo = "";
				int rankId = 0;
				String firstName = "";
				String lastName = "";
				
				Session session = (Session)getSession();
				
				rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).list();
				
				if(map.get("serviceNo") != null){
					serviceNo = (String)map.get("serviceNo");
				}
				if(map.get("rankId") != null){
					rankId = (Integer)map.get("rankId");
				}
				if(map.get("firstName") != null){
					firstName = (String)map.get("firstName");
				}
				if(map.get("lastName") != null){
					lastName = (String)map.get("lastName");
				}

				try {
					Criteria crit = session.createCriteria(MasEmployee.class);
					
						if(!serviceNo.equals("") ){
							crit = crit.add(Restrictions.like("ServiceNo", serviceNo+"%"));
						}
						if(!firstName.equals("")){
							crit = crit.add(Restrictions.like("FirstName", firstName+"%"));
						}
						if(!lastName.equals("")){
							crit = crit.add(Restrictions.like("LastName", lastName+"%"));
						}
						if(rankId != 0 ){
							crit = crit.createAlias("Rank", "rank").add(Restrictions.eq("rank.Id", rankId));
						}
					
						employeeList = crit.list();
				 }catch (Exception e) {
					e.printStackTrace();
				}
				map.put("employeeList", employeeList);
				map.put("rankList", rankList);
				return map;
			}
			
			public Map<String, Object> searchNightDutyEntry(Box box) {
				Session session = (Session)getSession();
				Map<String,Object>  map=new HashMap<String,Object>();
				Map<String,Object> utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
				session = (Session)getSession();

				int id = 0;

				PagedArray pagedArray = null;
				HashMap<String, Object> hData = null;  
				Vector<HashMap> vResult = new Vector<HashMap>();
				HashMap[] testPageData = null;

				List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
				List employeeDetailList = new ArrayList();
				List<MasDepartment>departmentList=new ArrayList<MasDepartment>();
				List<HrDutyTimeMaster>dutyTimeMasterList=new ArrayList<HrDutyTimeMaster>();
				List<HrDutyExemptionEntry>dutyExemptionList=new ArrayList<HrDutyExemptionEntry>();
				
				List<MasRank>rankList=new ArrayList<MasRank>();
				String serviceNo="";
				String empName="";
				
				if(!box.getString("searchServiceNo").equals(""))
				{	
					serviceNo=box.getString("searchServiceNo");
					//System.out.println("service no="+serviceNo);
				}
				if(!box.getString("searchName").equals(""))
				{
					empName=box.getString("searchName");
				}
				session = (Session)getSession();
				rankList=session.createCriteria(MasRank.class).add(Restrictions.eq("RankName", "SGT")).list();
				dutyExemptionList=session.createCriteria(HrDutyExemptionEntry.class).list();
				if(!serviceNo.equals(""))
				{					
					Criteria criteria=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).createAlias("Rank", "mr").add(Restrictions.le("mr.Id",rankList.get(0).getId()));
					criteria=criteria.add(Restrictions.eq("ServiceNo",serviceNo));
					employeeList=criteria.list();
				}
				else if(!empName.equals(""))
				{
					Criteria crit1=null;
					crit1=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).add(Restrictions.like("FirstName", empName+"%")).createAlias("Rank", "mr").add(Restrictions.le("mr.Id",rankList.get(0).getId()));
					if(crit1==null)
					{
						crit1=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).add(Restrictions.like("MiddleName", empName+"%")).createAlias("Rank", "mr").add(Restrictions.le("mr.Id",rankList.get(0).getId()));
						if(crit1==null)
						{
							crit1=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).add(Restrictions.like("LastName", empName+"%")).createAlias("Rank", "mr").add(Restrictions.le("mr.Id",rankList.get(0).getId()));
						}
					}
					employeeList=crit1.list();
				}
					departmentList=session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
					dutyTimeMasterList=session.createCriteria(HrDutyTimeMaster.class).add(Restrictions.eq("Status", "y")).list();
					map.put("employeeList", employeeList);
					map.put("departmentList", departmentList);
					map.put("dutyTimeMasterList", dutyTimeMasterList);

					int pageno = 1;
					int numOfRows = 10;
					try
					{
						if (box.get("numOfRows")!=null)
						{
							numOfRows = Integer.parseInt(box.getString("numOfRows"));
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
					map.put("pageno", pageno);
					
					int first = (pageno - 1) * numOfRows;
					int totalRecords = 0;
					if(employeeList != null && employeeList.size() > 0)
					{
						try
						{
							totalRecords = employeeList.size();
						}
						catch(Exception e)
						{
						totalRecords = 0;
						}
						map.put("totalRecords", totalRecords);

						
						double totalPages = 0.0;
						totalPages = (double)totalRecords/(double)numOfRows;
						Double d = new Double(Math.ceil(totalPages));
						map.put("totalPages", d.intValue());
						 String qry = "";
						int rankId = rankList.get(0).getId();
						if(!serviceNo.equals("")){
						qry = "select employee_id,service_no,mr.rank_name,concat(first_name,' ',middle_name,' ',last_name) as name,department_id from mas_employee me left join  mas_rank mr on me.rank_id=mr.rank_id where me.status ='y' and service_no='"+serviceNo+"' and me.rank_id='"+rankId+"'";
						}else if(!empName.equals("") ){
							
							qry = "select employee_id,service_no,mr.rank_name,concat(first_name,' ',middle_name,' ',last_name) as name,department_id from mas_employee me left join  mas_rank mr on me.rank_id = mr.rank_id where me.status ='y' and first_name like '"+empName+"%' or middle_name like '"+empName+"%' or last_name like '"+empName+"%' and me.rank_id='"+rankId+"'";	
						}
						 Query query = session.createSQLQuery(qry);
	                       query.setFirstResult(first);
	                       if (totalRecords < numOfRows)
	                    	   query.setMaxResults(totalRecords);
	       				   else
	       				    	query.setMaxResults(numOfRows);
						
						employeeDetailList =query.list();
					}
					map.put("employeeDetailList",employeeDetailList);
					map.put("box", box);
					map.put("dutyExemptionList", dutyExemptionList);
				return map;
			}
			
			public Map<String, Object> searchGuardDutyEntry(Box box) {
				Session session = (Session)getSession();
				Map<String,Object>  map=new HashMap<String,Object>();
				Map<String,Object> utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
				session = (Session)getSession();

				int id = 0;

				PagedArray pagedArray = null;
				HashMap<String, Object> hData = null;  
				Vector<HashMap> vResult = new Vector<HashMap>();
				HashMap[] testPageData = null;

				List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
				List<MasEmployee> employeeDetailList = new ArrayList<MasEmployee>();
				List<MasDepartment>departmentList=new ArrayList<MasDepartment>();
				List<HrDutyTimeMaster>dutyTimeMasterList=new ArrayList<HrDutyTimeMaster>();
				List<MasRank>rankList=new ArrayList<MasRank>();
				List<HrDutyExemptionEntry>dutyExemptionList=new ArrayList<HrDutyExemptionEntry>();
				String serviceNo="";
				String empName="";
				
				if(!box.getString("searchServiceNo").equals(""))
				{	
					serviceNo=box.getString("searchServiceNo");
				}
				if(!box.getString("searchName").equals(""))
				{
					empName=box.getString("searchName");
				}
				session = (Session)getSession();
				rankList=session.createCriteria(MasRank.class).add(Restrictions.eq("RankName", "CPL")).list();
				dutyExemptionList=session.createCriteria(HrDutyExemptionEntry.class).list();
				map.put("dutyExemptionList", dutyExemptionList);
				Criteria criteria=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).createAlias("Rank", "mr").add(Restrictions.le("mr.Id",rankList.get(0).getId()));
				if(!serviceNo.equals(""))
				{					
					criteria=criteria.add(Restrictions.like("ServiceNo",serviceNo+"%"));
					
				}
				else if(!empName.equals(""))
				{
					criteria=criteria.add(Restrictions.like("FirstName", empName+"%"));
				}
					employeeList=criteria.list();	
					departmentList=session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
					dutyTimeMasterList=session.createCriteria(HrDutyTimeMaster.class).add(Restrictions.eq("Status", "y")).list();
					map.put("employeeList", employeeList);
					map.put("departmentList", departmentList);
					map.put("dutyTimeMasterList", dutyTimeMasterList);

					int pageno = 1;
					int numOfRows = 10;
										
					try
					{
						if (box.get("numOfRows")!=null)
						{
							numOfRows = Integer.parseInt(box.getString("numOfRows"));
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
					map.put("pageno", pageno);
					
					int first = (pageno - 1) * numOfRows;
					int totalRecords = 0;
					if(employeeList != null && employeeList.size() > 0)
					{
						
						//String qry="SELECT count(*) FROM mas_employee";
						try
						{
							//totalRecords = Integer.parseInt(session.createSQLQuery(qry).list().get(0).toString());
							totalRecords = employeeList.size();
						}
						catch(Exception e)
						{
						totalRecords = 0;
						}
						map.put("totalRecords", totalRecords);

						
						double totalPages = 0.0;
						totalPages = (double)totalRecords/(double)numOfRows;
						Double d = new Double(Math.ceil(totalPages));
						map.put("totalPages", d.intValue());
						
						String qry ="";
						int rankId = rankList.get(0).getId();
						if(!serviceNo.equals("")){
							qry = "select employee_id,service_no,mr.rank_name,concat(first_name,' ',middle_name,' ',last_name) as name,department_id from mas_employee me left join  mas_rank mr on me.rank_id=mr.rank_id where me.status ='y' and service_no='"+serviceNo+"' and me.rank_id='"+rankId+"'";
							}else if(!empName.equals("") ){
							qry = "select employee_id,service_no,mr.rank_name,concat(first_name,' ',middle_name,' ',last_name) as name,department_id from mas_employee me left join  mas_rank mr on me.rank_id = mr.rank_id where me.status ='y' and first_name like '"+empName+"%' or middle_name like '"+empName+"%' or last_name like '"+empName+"%' and me.rank_id='"+rankId+"'";	
							}
						  Query query = session.createSQLQuery(qry);

	                       query.setFirstResult(first);
	                       if (totalRecords < numOfRows)
	                    	   query.setMaxResults(totalRecords);
	       				   else
	       				    	query.setMaxResults(numOfRows);
						
						employeeDetailList = query.list();
					}
					map.put("employeeDetailList",employeeDetailList);
					map.put("box", box);
				return map;
			}
			
			public Map<String, Object> searchWardDutyEntry(Box box) {
				Session session = (Session)getSession();
				Map<String,Object>  map=new HashMap<String,Object>();
				Map<String,Object> utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
				session = (Session)getSession();

				int id = 0;

				PagedArray pagedArray = null;
				HashMap<String, Object> hData = null;  
				Vector<HashMap> vResult = new Vector<HashMap>();
				HashMap[] testPageData = null;

				List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
				List<MasEmployee> employeeDetailList = new ArrayList<MasEmployee>();
				List<MasDepartment>departmentList=new ArrayList<MasDepartment>();
				List<HrDutyTimeMaster>dutyTimeMasterList=new ArrayList<HrDutyTimeMaster>();
				List<MasRank>rankList=new ArrayList<MasRank>();
				List<HrDutyExemptionEntry>dutyExemptionList=new ArrayList<HrDutyExemptionEntry>();
				List<MasDepartmentType> masdepartmenttypeList = new ArrayList<MasDepartmentType>();
				MasDepartmentType masdepartmenttype = null;
				masdepartmenttypeList=session.createCriteria(MasDepartmentType.class).add(Restrictions.eq("DepartmentTypeName","Ward Duty Locations")).list();
				if(masdepartmenttypeList.size()!=0)
				{
					masdepartmenttype=(MasDepartmentType)masdepartmenttypeList.get(0);
					departmentList=session.createCriteria(MasDepartment.class).createAlias("DepartmentType","dt").add(Restrictions.eq("dt.Id", masdepartmenttype.getId())).list();
				}
				String serviceNo="";
				String empName="";
				
				if(!box.getString("searchServiceNo").equals(""))
				{	
					serviceNo=box.getString("searchServiceNo");
				}
				if(!box.getString("searchName").equals(""))
				{
					empName=box.getString("searchName");
				}
				session = (Session)getSession();
				rankList=session.createCriteria(MasRank.class).add(Restrictions.eq("RankName", "SGT")).list();
				dutyExemptionList=session.createCriteria(HrDutyExemptionEntry.class).list();
				map.put("dutyExemptionList", dutyExemptionList);
				if(!serviceNo.equals(""))
				{					
					Criteria criteria=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).createAlias("Rank", "mr").add(Restrictions.le("mr.Id",rankList.get(0).getId()));
					criteria=criteria.add(Restrictions.eq("ServiceNo",serviceNo));
					employeeList=criteria.list();
				}
				else if(!empName.equals(""))
				{
					Criteria crit1=null;
					crit1=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).add(Restrictions.like("FirstName", empName+"%")).createAlias("Rank", "mr").add(Restrictions.le("mr.Id",rankList.get(0).getId()));
					if(crit1==null)
					{
						crit1=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).add(Restrictions.like("MiddleName", empName+"%")).createAlias("Rank", "mr").add(Restrictions.le("mr.Id",rankList.get(0).getId()));
						if(crit1==null)
						{
							crit1=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).add(Restrictions.like("LastName", empName+"%")).createAlias("Rank", "mr").add(Restrictions.le("mr.Id",rankList.get(0).getId()));
						}
					}
					employeeList=crit1.list();
				}
					//departmentList=session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
					dutyTimeMasterList=session.createCriteria(HrDutyTimeMaster.class).add(Restrictions.eq("Status", "y")).list();
					map.put("employeeList", employeeList);
					map.put("departmentList", departmentList);
					map.put("dutyTimeMasterList", dutyTimeMasterList);

					int pageno = 1;
					int numOfRows = 10;
										
					try
					{
						if (box.get("numOfRows")!=null)
						{
							numOfRows = Integer.parseInt(box.getString("numOfRows"));
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
					map.put("pageno", pageno);
					
					int first = (pageno - 1) * numOfRows;
					int totalRecords = 0;
					if(employeeList != null && employeeList.size() > 0)
					{
						
						//String qry="SELECT count(*) FROM mas_employee";
						try
						{
							//totalRecords = Integer.parseInt(session.createSQLQuery(qry).list().get(0).toString());
							totalRecords = employeeList.size();
						}
						catch(Exception e)
						{
						totalRecords = 0;
						}
						map.put("totalRecords", totalRecords);

						
						double totalPages = 0.0;
						totalPages = (double)totalRecords/(double)numOfRows;
						Double d = new Double(Math.ceil(totalPages));
						map.put("totalPages", d.intValue());
						Criteria c =null;
						String qry ="";
						int rankId = rankList.get(0).getId();
						if(!serviceNo.equals("")){
							qry = "select employee_id,service_no,mr.rank_name,concat(first_name,' ',middle_name,' ',last_name) as name,department_id from mas_employee me left join  mas_rank mr on me.rank_id=mr.rank_id where me.status ='y' and service_no='"+serviceNo+"' and me.rank_id='"+rankId+"'";
							}else if(!empName.equals("") ){
							qry = "select employee_id,service_no,mr.rank_name,concat(first_name,' ',middle_name,' ',last_name) as name,department_id from mas_employee me left join  mas_rank mr on me.rank_id = mr.rank_id where me.status ='y' and first_name like '"+empName+"%' or middle_name like '"+empName+"%' or last_name like '"+empName+"%' and me.rank_id='"+rankId+"'";	
							}
						  Query query = session.createSQLQuery(qry);

	                       query.setFirstResult(first);
	                       if (totalRecords < numOfRows)
	                    	   query.setMaxResults(totalRecords);
	       				   else
	       				    	query.setMaxResults(numOfRows);
						
						employeeDetailList = query.list();
					}
					map.put("employeeDetailList",employeeDetailList);
					map.put("box", box);
				return map;
			}
			
			public Map<String, Object> searchOrderlyDutyEntry(Box box) {
				Session session = (Session)getSession();
				Map<String,Object>  map=new HashMap<String,Object>();
				Map<String,Object> utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
				session = (Session)getSession();

				int id = 0;

				PagedArray pagedArray = null;
				HashMap<String, Object> hData = null;  
				Vector<HashMap> vResult = new Vector<HashMap>();
				HashMap[] testPageData = null;

				List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
				List<MasEmployee> employeeDetailList = new ArrayList<MasEmployee>();
				List<MasDepartment>departmentList=new ArrayList<MasDepartment>();
				List<HrDutyTimeMaster>dutyTimeMasterList=new ArrayList<HrDutyTimeMaster>();
				List<MasRank>rankList=new ArrayList<MasRank>();
				List<HrDutyExemptionEntry>dutyExemptionList=new ArrayList<HrDutyExemptionEntry>();
				List<MasDepartmentType> masdepartmenttypeList = new ArrayList<MasDepartmentType>();
				MasDepartmentType masdepartmenttype = null;
				masdepartmenttypeList=session.createCriteria(MasDepartmentType.class).add(Restrictions.eq("DepartmentTypeName","Orderly Duty Locations")).list();
				if(masdepartmenttypeList.size()!=0)
				{
					masdepartmenttype=(MasDepartmentType)masdepartmenttypeList.get(0);
					departmentList=session.createCriteria(MasDepartment.class).createAlias("DepartmentType","dt").add(Restrictions.eq("dt.Id", masdepartmenttype.getId())).list();
				}
				String serviceNo="";
				String empName="";
				
				if(!box.getString("searchServiceNo").equals(""))
				{	
					serviceNo=box.getString("searchServiceNo");
				}
				if(!box.getString("searchName").equals(""))
				{
					empName=box.getString("searchName");
				}
				session = (Session)getSession();
				rankList=session.createCriteria(MasRank.class).add(Restrictions.eq("RankName", "SGT")).list();
				dutyExemptionList=session.createCriteria(HrDutyExemptionEntry.class).list();
				map.put("dutyExemptionList", dutyExemptionList);
				if(!serviceNo.equals(""))
				{					
					Criteria criteria=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).createAlias("Rank", "mr").add(Restrictions.eq("mr.Id",rankList.get(0).getId()));
					criteria=criteria.add(Restrictions.eq("ServiceNo",serviceNo));
					employeeList=criteria.list();
				}
				else if(!empName.equals(""))
				{
					Criteria crit1=null;
					crit1=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).add(Restrictions.like("FirstName", empName+"%")).createAlias("Rank", "mr").add(Restrictions.eq("mr.Id",rankList.get(0).getId()));
					if(crit1==null)
					{
						crit1=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).add(Restrictions.like("MiddleName", empName+"%")).createAlias("Rank", "mr").add(Restrictions.eq("mr.Id",rankList.get(0).getId()));
						if(crit1==null)
						{
							crit1=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).add(Restrictions.like("LastName", empName+"%")).createAlias("Rank", "mr").add(Restrictions.eq("mr.Id",rankList.get(0).getId()));
						}
					}
					employeeList=crit1.list();
				}
					//departmentList=session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
					dutyTimeMasterList=session.createCriteria(HrDutyTimeMaster.class).add(Restrictions.eq("Status", "y")).list();
					map.put("employeeList", employeeList);
					map.put("departmentList", departmentList);
					map.put("dutyTimeMasterList", dutyTimeMasterList);

					int pageno = 1;
					int numOfRows = 10;
										
					try
					{
						if (box.get("numOfRows")!=null)
						{
							numOfRows = Integer.parseInt(box.getString("numOfRows"));
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
					map.put("pageno", pageno);
					
					int first = (pageno - 1) * numOfRows;
					int totalRecords = 0;
					if(employeeList != null && employeeList.size() > 0)
					{
						
						//String qry="SELECT count(*) FROM mas_employee";
						try
						{
							//totalRecords = Integer.parseInt(session.createSQLQuery(qry).list().get(0).toString());
							totalRecords = employeeList.size();
						}
						catch(Exception e)
						{
						totalRecords = 0;
						}
						map.put("totalRecords", totalRecords);

						
						double totalPages = 0.0;
						totalPages = (double)totalRecords/(double)numOfRows;
						Double d = new Double(Math.ceil(totalPages));
						map.put("totalPages", d.intValue());
						Criteria c =null;
						String qry ="";
						int rankId = rankList.get(0).getId();
						if(!serviceNo.equals("")){
							qry = "select employee_id,service_no,mr.rank_name,concat(first_name,' ',middle_name,' ',last_name) as name,department_id from mas_employee me left join  mas_rank mr on me.rank_id=mr.rank_id where me.status ='y' and service_no='"+serviceNo+"' and me.rank_id='"+rankId+"'";
							}else if(!empName.equals("") ){
							qry = "select employee_id,service_no,mr.rank_name,concat(first_name,' ',middle_name,' ',last_name) as name,department_id from mas_employee me left join  mas_rank mr on me.rank_id = mr.rank_id where me.status ='y' and first_name like '"+empName+"%' or middle_name like '"+empName+"%' or last_name like '"+empName+"%' and me.rank_id='"+rankId+"'";	
							}
						  Query query = session.createSQLQuery(qry);

	                       query.setFirstResult(first);
	                       if (totalRecords < numOfRows)
	                    	   query.setMaxResults(totalRecords);
	       				   else
	       				    	query.setMaxResults(numOfRows);
						
						employeeDetailList = query.list();
					}
					map.put("employeeDetailList",employeeDetailList);
					map.put("box", box);
				return map;
			}

			public Map<String, Object> getEmployeeDetailsForNightDutyAdd(Box box) {
				// TODO Auto-generated method stub
				return null;
			}

			/*public Map<String, Object> getGridDataForEmployeeAdd(Box box) {
				// TODO Auto-generated method stub
				return null;
			}*/
			
			/**
			 * ---------------------------------- REPORTS --------------------------
			 */
			
			
			public Map<String, Object> getConnectionForReport() {
				Map<String, Object> map = new HashMap<String, Object>();
				Session session = (Session)getSession();
				Connection con = session.connection();
				map.put("conn",con);
				return map;
			}
			
			//------------------------- ESTABLISHMENT STRENGTH REPORT -----------------------------------
			public Map<String, Object> showEstablishmentReportJsp() {
				Map<String, Object> map = new HashMap<String, Object>();
				
				List<MasUnit> unitList = new ArrayList<MasUnit>();
				Session session = (Session) getSession();
				try {
					unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y")).list();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				map.put("unitList", unitList);
				return map;
			}
			
			//------------------------- DEPARTMENT WISE REPORT -----------------------------------
			public Map<String, Object> showDepartmentWiseReportJsp() {
				Map<String, Object> map = new HashMap<String, Object>();
				
				List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
				Session session = (Session) getSession();
				try {
					departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				map.put("departmentList", departmentList);
				return map;
			}
			
			//------------------------- SPECIALITY WISE REPORT -----------------------------------
			public Map<String, Object> showSpecialistWiseReportJsp() {
				Map<String, Object> map = new HashMap<String, Object>();
				
				List<HrSpecialistMaster> specialistList = new ArrayList<HrSpecialistMaster>();
				Session session = (Session) getSession();
				try {
					specialistList = session.createCriteria(HrSpecialistMaster.class).add(Restrictions.eq("Status", "y")).list();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				map.put("specialistList", specialistList);
				return map;
			}
			
			//------------------------- RANK WISE REPORT -----------------------------------
			public Map<String, Object> showRankWiseReportJsp() {
				Map<String, Object> map = new HashMap<String, Object>();
				
				List<MasRank> rankList = new ArrayList<MasRank>();
				Session session = (Session) getSession();
				try {
					rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).list();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				map.put("rankList", rankList);
				return map;
			}
}
