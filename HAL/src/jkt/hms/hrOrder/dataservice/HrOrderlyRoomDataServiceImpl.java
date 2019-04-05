package jkt.hms.hrOrder.dataservice;

import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.DEPARTMENT_ID;
import static jkt.hms.util.RequestConstants.EMPLOYEE_CATEGORY_ID;
import static jkt.hms.util.RequestConstants.EMPLOYEE_CODE;
import static jkt.hms.util.RequestConstants.EMPLOYEE_GRADE_ID;
import static jkt.hms.util.RequestConstants.EMP_STATUS_ID;
import static jkt.hms.util.RequestConstants.FIRST_NAME;
import static jkt.hms.util.RequestConstants.LAST_NAME;
import static jkt.hms.util.RequestConstants.MIDDLE_NAME;
import static jkt.hms.util.RequestConstants.PERSON_FROM_OTHER_UNIT;
import static jkt.hms.util.RequestConstants.POSTED_UNIT_ID;
import static jkt.hms.util.RequestConstants.PREFIX;
import static jkt.hms.util.RequestConstants.RANK_ID;
import static jkt.hms.util.RequestConstants.SERVICE_NO;
import static jkt.hms.util.RequestConstants.SERVICE_TYPE_ID;
import static jkt.hms.util.RequestConstants.SUFFIX;
import static jkt.hms.util.RequestConstants.TITLE_ID;
import static jkt.hms.util.RequestConstants.TRADE_ID;
import static jkt.hms.util.RequestConstants.UNIT_ID;
import static jkt.hms.util.RequestConstants.S_FIRST_NAME;
import static jkt.hms.util.RequestConstants.S_LAST_NAME;
import it.businesslogic.ireport.plugin.massivecompiler.FindThread;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jkt.hms.hrOrder.controller.LeaveApplicationDTO;
import jkt.hms.masters.business.EmpLeaveBalance;
import jkt.hms.masters.business.FamilyDetails;
import jkt.hms.masters.business.HrClassMaster;
import jkt.hms.masters.business.HrDutyExemptionEntry;
import jkt.hms.masters.business.HrDutyMaster;
import jkt.hms.masters.business.HrDutyTimeMaster;
import jkt.hms.masters.business.HrGuardDutyEntry;
import jkt.hms.masters.business.HrLeaveMaintenance;
import jkt.hms.masters.business.HrLeaveTypeMaster;
//import jkt.hms.masters.business.HrLivingInOutDetail;
import jkt.hms.masters.business.HrMonthlyRationAccounting;
import jkt.hms.masters.business.HrMonthlyRationAccountingInpatientDetail;
import jkt.hms.masters.business.HrMonthlyRationAccountingLeaveDetail;
import jkt.hms.masters.business.HrMonthlyRationAccountingMovementDetail;
import jkt.hms.masters.business.HrOrderlyDutyEntry;
import jkt.hms.masters.business.HrOrderlySgtDutyEntry;
import jkt.hms.masters.business.HrRangeFiringDutyEntry;
import jkt.hms.masters.business.HrRationSummaryDayWise;
import jkt.hms.masters.business.HrSpecialistMaster;
import jkt.hms.masters.business.HroEntry;
import jkt.hms.masters.business.HrorderlyClassificationMaster;
import jkt.hms.masters.business.HrorderlyGuardDutyEntry;
import jkt.hms.masters.business.HrorderlyLeaveAccount;
import jkt.hms.masters.business.HrorderlyLeaveApplication;
import jkt.hms.masters.business.HrorderlyLeavechoice;
import jkt.hms.masters.business.HrorderlyMessMaster;
import jkt.hms.masters.business.HrorderlyMonthlyRationAccounting;
//import jkt.hms.masters.business.HrorderlyMonthlyRationStrength;
import jkt.hms.masters.business.HrorderlyOfficerDutyEntry;
import jkt.hms.masters.business.HrorderlyRangeFiringDutyEntry;
import jkt.hms.masters.business.LeaveRestrictionEntry;
import jkt.hms.masters.business.MasCostCenter;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDepartmentType;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasEmpCategory;
import jkt.hms.masters.business.MasEmpStatus;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasEmployeeDependent;
import jkt.hms.masters.business.MasGrade;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasPool;
import jkt.hms.masters.business.MasPorProgram;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasRankCategory;
import jkt.hms.masters.business.MasRelation;
import jkt.hms.masters.business.MasServiceType;
import jkt.hms.masters.business.MasState;
import jkt.hms.masters.business.MasTitle;
import jkt.hms.masters.business.MasTrade;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.MovementInEntry;
import jkt.hms.masters.business.MovementInOtherPerson;
import jkt.hms.masters.business.MovementOutEntry;
import jkt.hms.masters.business.OpdHoliday;
import jkt.hms.masters.business.PendingHroProposal;
import jkt.hms.masters.business.PostedOutEntry;
import jkt.hms.masters.business.ProposalForHroEntry;
import jkt.hms.masters.business.TrainClassGroup;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.masters.business.UserDepartment;
import jkt.hms.masters.business.Users;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.PagedArray;
import java.sql.CallableStatement;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.web.servlet.ModelAndView;



public class HrOrderlyRoomDataServiceImpl extends HibernateDaoSupport implements
		HrOrderlyRoomDataService {

	/**
	 * -------------------------- method to show por Program master
	 * ------------------------------------------
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> showPorJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasPorProgram> searchPorProgramList = new ArrayList<MasPorProgram>();
		searchPorProgramList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasPorProgram ");
		map.put("searchPorProgramList", searchPorProgramList);
		return map;
	}

	// /////////////Arrival Employee///////////////////

	public Map<String, Object> searchEmployee(Map<String, Object> infoMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> searchEmployeeList = new ArrayList<MasEmployee>();
		List<MasTitle> titleList = new ArrayList<MasTitle>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasEmpCategory> empCategoryList = new ArrayList<MasEmpCategory>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();

		String serviceNo = "";
		int rankId = 0;
		String serPersonLName = "";
		String serPersonFName = "";

		Session session = (Session) getSession();
		Criteria crit = null;

		int deptId = 0;
		if (infoMap.get("deptId") != null)
			deptId = Integer.parseInt("" + infoMap.get("deptId"));

		if (infoMap.get("serPersonLName") != null) {
			serPersonLName = (String) infoMap.get("serPersonLName");
		}

		if (infoMap.get("serviceNo") != null) {
			serviceNo = (String) infoMap.get("serviceNo");
		}
		if (infoMap.get("rankId") != "0" && infoMap.get("rankId") != null) {
			rankId = Integer.parseInt("" + infoMap.get("rankId"));
		}

		if (infoMap.get("serPersonFName") != null) {
			serPersonFName = (String) infoMap.get("serPersonFName");
		}
		//System.out.println("fristNmae::::::data" + serPersonFName	+ "Last name ::::::::::date" + serPersonLName);
		try {
			crit = session.createCriteria(MasEmployee.class);

			if (!serviceNo.equals("")) {
				crit = crit
						.add(Restrictions.like("ServiceNo", serviceNo + "%"));
			}
			if (!serPersonFName.equals("")) {
				crit = crit.add(Restrictions.like("FirstName", serPersonFName
						+ "%"));
			}
			if (!serPersonLName.equals("")) {
				crit = crit.add(Restrictions.like("LastName", serPersonLName
						+ "%"));
			}

			if (rankId != 0) {
				crit = crit.createAlias("Rank", "rank").add(
						Restrictions.eq("rank.Id", rankId));
			}

			searchEmployeeList = crit.list();

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
			serviceTypeList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasServiceType as mg where mg.Status = 'y'");

			//System.out.println("search list " + searchEmployeeList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("searchEmployeeList", searchEmployeeList);
		map.put("titleList", titleList);
		map.put("departmentList", departmentList);
		map.put("empCategoryList", empCategoryList);
		map.put("rankList", rankList);
		map.put("unitList", unitList);
		map.put("serviceTypeList", serviceTypeList);

		return map;
	}

	public Map<String, Object> showEmployeeJsp() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasTitle> titleList = new ArrayList<MasTitle>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasEmpStatus> empStatusList = new ArrayList<MasEmpStatus>();
		List<MasEmpCategory> empCategoryList = new ArrayList<MasEmpCategory>();
		List<MasGrade> gradeList = new ArrayList<MasGrade>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasRank> rankForOfficerList = new ArrayList<MasRank>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<HrorderlyMessMaster> messList = new ArrayList<HrorderlyMessMaster>();
		List<MasTrade> tradeList = new ArrayList<MasTrade>();
		List<MasUnit> chafbUnitList = new ArrayList<MasUnit>();
		List<TransactionSequence> seqList = new ArrayList<TransactionSequence>();
		List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		List<HrLeaveTypeMaster> hrleavetypemasterlist = new ArrayList<HrLeaveTypeMaster>();
		List<MasRelation> masRelationList = new ArrayList<MasRelation>();
		

		messList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.HrorderlyMessMaster as isc");
		titleList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasTitle as tm where tm.Status = 'y'");
		departmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment as md where md.Status = 'y'");
		empCategoryList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasEmpCategory as mec where mec.Status = 'y'");
		empStatusList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasEmpStatus as mes where mes.Status = 'y'");
		gradeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasGrade as mg where mg.Status = 'y'");
		rankList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasRank as mg where mg.ServiceStatus=1 and mg.Status = 'y'");
		rankForOfficerList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasRank as mg where mg.ServiceStatus=1  and mg.RankCategory=1 and mg.Status = 'y'");
		unitList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasUnit as mg where mg.Status = 'y' order by mg.UnitName");
		chafbUnitList = session.createCriteria(MasUnit.class).add(
				Restrictions.eq("Status", "y")).add(
				Restrictions.eq("DependentUnit", "y")).list();
		/*tradeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasTrade as mg where mg.Status = 'y'");*/
		
		tradeList = getHibernateTemplate().find("from jkt.hms.masters.business.MasTrade	as mg where mg.Status = 'y' order by mg.TradeName  ");
		
		serviceTypeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasServiceType as mg where mg.Status = 'y'");

		seqList = session.createCriteria(TransactionSequence.class).add(
				Restrictions.eq("TransactionPrefix", "EMP")).list();
		hrleavetypemasterlist = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.HrLeaveTypeMaster as ml where ml.Status = 'y'");
		masRelationList=session.createCriteria(MasRelation.class)
		                .add(Restrictions.ne("RelationName", "Self"))
		                .add(Restrictions.ne("RelationName", "PSO"))
		                .add(Restrictions.eq("Status", "y")).list();

		//System.out.println("rankForOfficerList " + rankForOfficerList.size());

		map.put("hrleavetypemasterlist", hrleavetypemasterlist);

		map.put("messList", messList);

		map.put("chafbUnitList", chafbUnitList);
		map.put("titleList", titleList);
		map.put("departmentList", departmentList);
		map.put("empStatusList", empStatusList);
		map.put("empCategoryList", empCategoryList);
		map.put("gradeList", gradeList);
		map.put("rankList", rankList);
		map.put("rankForOfficerList", rankForOfficerList);
		map.put("unitList", unitList);
		map.put("tradeList", tradeList);
		map.put("seqList", seqList);
		map.put("serviceTypeList", serviceTypeList);
		map.put("masRelationList", masRelationList);

		return map;
	}

	public Map<String, Object> showEmployeeUpdateJsp(int id) {
		Session session = (Session) getSession();
		Criteria crit = null;
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasTitle> titleList = new ArrayList<MasTitle>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasEmpStatus> empStatusList = new ArrayList<MasEmpStatus>();
		List<MasEmployee> searchEmployeeList = new ArrayList<MasEmployee>();
		List<MasEmpCategory> empCategoryList = new ArrayList<MasEmpCategory>();
		List<MasGrade> gradeList = new ArrayList<MasGrade>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasUnit> chafbUnitList = new ArrayList<MasUnit>();
		List<HrorderlyMessMaster> messList = new ArrayList<HrorderlyMessMaster>();
		List<MasTrade> tradeList = new ArrayList<MasTrade>();
		List<TransactionSequence> seqList = new ArrayList<TransactionSequence>();
		List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		List<HrLeaveTypeMaster> hrleavetypemasterlist = new ArrayList<HrLeaveTypeMaster>();
		List<HrorderlyLeavechoice> hroderlyleavechoiceList = new ArrayList<HrorderlyLeavechoice>();
		List<HrorderlyLeaveAccount> hrorderlyleaveaccountList = new ArrayList<HrorderlyLeaveAccount>();
		List<MasEmployeeDependent> masEmployeeDependentList = new ArrayList<MasEmployeeDependent>();
		List<MasRelation> masRelationList = new ArrayList<MasRelation>();

		chafbUnitList = session.createCriteria(MasUnit.class).add(
				Restrictions.eq("Status", "y")).add(
				Restrictions.eq("DependentUnit", "y")).list();
		messList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.HrorderlyMessMaster as isc");
		titleList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasTitle as tm where tm.Status = 'y'");
		departmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment as md where md.Status = 'y'");
		empCategoryList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasEmpCategory as mec where mec.Status = 'y'");
		empStatusList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasEmpStatus as mes where mes.Status = 'y'");
		searchEmployeeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasEmployee as mase where mase.Id= "
						+ id);
		masRelationList = session.createCriteria(MasRelation.class)
						  .add(Restrictions.ne("RelationName", "Self"))
						  .add(Restrictions.ne("RelationName", "PSO"))
		                  .add(Restrictions.eq("Status","y")).list();
		//System.out.println("masRelationList::"+masRelationList.size());
		try {
			hroderlyleavechoiceList = session.createCriteria(
					HrorderlyLeavechoice.class)
					.createAlias("EmployeeId", "emp").add(
							Restrictions.eq("emp.Id", id)).list();
			hrorderlyleaveaccountList = session.createCriteria(
					HrorderlyLeaveAccount.class).add(
					Restrictions.eq("EmployeeId", id)).list();
			masEmployeeDependentList = session.createCriteria(MasEmployeeDependent.class)
			                            .createAlias("Employee", "emp")
										.add(Restrictions.eq("emp.Id", id))
										.add(Restrictions.eq("Status","y")).list();

		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
		gradeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasGrade as mg where mg.Status = 'y'");
		rankList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasRank as mg where mg.Status = 'y'");
		unitList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasUnit as mg where mg.Status = 'y' order by mg.UnitName" );
		tradeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasTrade as mg where mg.Status = 'y' order by mg.TradeName ");
		serviceTypeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasServiceType as mg where mg.Status = 'y'");

		seqList = session.createCriteria(TransactionSequence.class).add(
				Restrictions.eq("TransactionPrefix", "EMP")).list();
		hrleavetypemasterlist = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.HrLeaveTypeMaster as ml where ml.Status = 'y'");

		map.put("chafbUnitList", chafbUnitList);
		map.put("hrleavetypemasterlist", hrleavetypemasterlist);
		map.put("messList", messList);
		map.put("titleList", titleList);
		map.put("departmentList", departmentList);
		map.put("empStatusList", empStatusList);
		map.put("empCategoryList", empCategoryList);
		map.put("gradeList", gradeList);
		map.put("searchEmployeeList", searchEmployeeList);
		map.put("rankList", rankList);
		map.put("unitList", unitList);
		map.put("tradeList", tradeList);
		map.put("seqList", seqList);
		map.put("serviceTypeList", serviceTypeList);
		map.put("hroderlyleavechoiceList", hroderlyleavechoiceList);
		map.put("hrorderlyleaveaccountList", hrorderlyleaveaccountList);
		map.put("masEmployeeDependentList",masEmployeeDependentList);
		map.put("masRelationList", masRelationList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String , Object> EmployeeExist(String service_no, int service_type) {

		boolean flag = false;
		Map<String , Object> returnMap = new HashMap<String , Object>();
		Session session = (Session) getSession();
		List<MasEmployee> masemployeelist = new ArrayList<MasEmployee>();
		masemployeelist = session.createCriteria(MasEmployee.class).add(
				Restrictions.eq("ServiceNo", service_no)).add(
				Restrictions.eq("ServiceType.Id", service_type)).list();
		if (masemployeelist == null || masemployeelist.size() == 0) {
			flag = true;
		}
		returnMap.put("flag", flag);
		returnMap.put("masEmployeeList",masemployeelist);

		return returnMap;
	}

	public boolean EmployeeExistForOtherPersonnel(String service_no,
			int service_type) {

		boolean flag = false;
		Session session = (Session) getSession();
		List<MovementInOtherPerson> movementinotherpersonList = new ArrayList<MovementInOtherPerson>();
		movementinotherpersonList = session.createCriteria(
				MovementInOtherPerson.class).add(
				Restrictions.eq("ServiceNo", service_no)).add(
				Restrictions.eq("ServiceType.Id", service_type)).list();
		if (movementinotherpersonList == null
				|| movementinotherpersonList.size() == 0) {
			flag = true;
		}
		return flag;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> addEmployee(Map<String, Object> map) {
		List<TransactionSequence> regList = new ArrayList<TransactionSequence>();
		Session session = (Session) getSession();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		boolean successfullyAdded = false;
		MasEmployee masEmployee = new MasEmployee();
		HrorderlyLeavechoice hrorderlyleavechoice = new HrorderlyLeavechoice();
		List<MasEmployeeDependent> masEmployeeDependentList = new ArrayList<MasEmployeeDependent>();
		
		//HrLivingInOutDetail hrLivingInOutDetail = new HrLivingInOutDetail();
		List<HrorderlyLeaveAccount> hrorderlyleaveaccountList = new ArrayList<HrorderlyLeaveAccount>();
		List<HrLeaveTypeMaster> hrleavetypemasterList = new ArrayList<HrLeaveTypeMaster>();

		if (map.get("masEmployee") != null) {
			masEmployee = (MasEmployee) map.get("masEmployee");
		}
		if (map.get("masEmployeeDependentList") != null) {
			masEmployeeDependentList = (List<MasEmployeeDependent>) map.get("masEmployeeDependentList");
		}
		if (map.get("hrorderlyleaveaccountList") != null) {
			hrorderlyleaveaccountList = (List) map
					.get("hrorderlyleaveaccountList");
		}
		if (map.get("hrorderlyleavechoice") != null) {
			hrorderlyleavechoice = (HrorderlyLeavechoice) map
					.get("hrorderlyleavechoice");
		}
		/*if (map.get("hrLivingInOutDetail") != null) {
			hrLivingInOutDetail = (HrLivingInOutDetail) map
					.get("hrLivingInOutDetail");
		}*/
		//System.out.println("hrorderlyleaveaccountList"+ hrorderlyleaveaccountList.size());

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			//masEmployee.setLivingInOutDetail(hrLivingInOutDetail) ;
			//hrLivingInOutDetail.setEmployeeId(masEmployee);
			hbt.save(masEmployee);
			hbt.refresh(masEmployee);
			hrleavetypemasterList = session.createCriteria(
					HrLeaveTypeMaster.class)
					.add(Restrictions.eq("Status", "y")).list();
			if (hrorderlyleaveaccountList != null
					&& hrorderlyleaveaccountList.size() > 0) {
				for (HrorderlyLeaveAccount hrorderlyleaveaccount : hrorderlyleaveaccountList) {
					for (HrLeaveTypeMaster hrleavetypemaster : hrleavetypemasterList) {
						if (hrleavetypemaster.getId().equals(
								hrorderlyleaveaccount.getLeaveTypeId())) {

							hrorderlyleaveaccount.setEmployeeId(masEmployee
									.getId());
							hrorderlyleaveaccount
									.setEntitledLeave(hrleavetypemaster
											.getDays());
							hbt.save(hrorderlyleaveaccount);
							hbt.refresh(hrorderlyleaveaccount);
							//System.out.println("inside::::::::::::::"+ masEmployee.getId() + ":::::::::::::"+ hrleavetypemaster.getDays());
						}
						//System.out.println("hrleavetypemaster.getId() "+ hrleavetypemaster.getId()hrorderlyleaveaccount.getLeaveTypeId() "+ hrorderlyleaveaccount.getLeaveTypeId());
					}
				}
			}
			hrorderlyleavechoice.setEmployeeId(masEmployee);
			hbt.save(hrorderlyleavechoice);
			for(MasEmployeeDependent masEmployeeDependent :masEmployeeDependentList ){
				masEmployeeDependent.setEmployee(masEmployee);
				hbt.save(masEmployeeDependent);
			}
			/*hbt.save(hrLivingInOutDetail);
			hbt.refresh(hrLivingInOutDetail);*/
			//hbt.save(masEmployee);
			hbt.flush();
			dataMap.put("employee_id", masEmployee.getId());
			dataMap.put("rankCategoryId", masEmployee.getRank()
					.getRankCategory().getId());
			//System.out.println("employee_id::" + masEmployee.getId()+ "rankCategoryId"+ masEmployee.getRank().getRankCategory().getId());

			successfullyAdded = true;

			regList = session.createCriteria(TransactionSequence.class).add(
					Restrictions.eq("TransactionPrefix", "EMP")).list();
			int seq = 0;
			if (regList.size() > 0) {
				for (TransactionSequence transactionSequence : regList) {
					TransactionSequence obj = (TransactionSequence) regList
							.get(0);
					int id = obj.getId();
					seq = obj.getTransactionSequenceNumber();

					TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
							.load(TransactionSequence.class, id);
					transactionSequenceObj.setTransactionSequenceNumber(++seq);
					hbt.update(transactionSequenceObj);
				}
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		dataMap.put("successfullyAdded", successfullyAdded);
		return dataMap;
	}

	public boolean addPersonnelFromOtherUnitJsp(Map<String, Object> map) {
		List<TransactionSequence> regList = new ArrayList<TransactionSequence>();
		Session session = (Session) getSession();
		boolean successfullyAdded = false;
		MovementInOtherPerson movementinotherperson = new MovementInOtherPerson();

		if (map.get("movementinotherperson") != null) {
			movementinotherperson = (MovementInOtherPerson) map
					.get("movementinotherperson");
		}
		//System.out.println("name::::" + movementinotherperson.getFirstName());
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(movementinotherperson);
			hbt.refresh(movementinotherperson);

			successfullyAdded = true;

			regList = session.createCriteria(TransactionSequence.class).add(
					Restrictions.eq("TransactionPrefix", "PFOU")).list();
			//System.out.println("listsize::" + regList.size());
			int seq = 0;
			if (regList.size() > 0) {
				for (TransactionSequence transactionSequence : regList) {
					TransactionSequence obj = (TransactionSequence) regList
							.get(0);
					int id = obj.getId();
					seq = obj.getTransactionSequenceNumber();

					TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
							.load(TransactionSequence.class, id);
					transactionSequenceObj.setTransactionSequenceNumber(++seq);
					hbt.update(transactionSequenceObj);
				}
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			successfullyAdded = false;
		}
		return successfullyAdded;
	}

	public boolean UpdatePersonFroOtherUnit(Box box) {
		Session session = (Session) getSession();
		boolean successfull = true;
		MovementInOtherPerson movementinotherperson = null;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			//System.out.println("personelId::" + box.getString("personelId")+ ":::::::::::" + box.getString(FIRST_NAME));
			movementinotherperson = (MovementInOtherPerson) hbt.load(
					MovementInOtherPerson.class, Integer.parseInt(box
							.getString("personelId")));

			//System.out.println("list:::" + movementinotherperson.getId());
			if (box.getString(SUFFIX) != null
					&& !box.getString(SUFFIX).equals("")) {
				movementinotherperson.setSuffix(box.getString(SUFFIX));
			}
			if (box.getString(PREFIX) != null
					&& !box.getString(PREFIX).equals("")) {
				movementinotherperson.setPrefix(box.getString(PREFIX));
			}
			if (box.getString(FIRST_NAME) != null
					&& !box.getString(FIRST_NAME).equals("")) {
				movementinotherperson.setFirstName(box.getString(FIRST_NAME));
			}
			if (box.getString(MIDDLE_NAME) != null
					&& !box.getString(MIDDLE_NAME).equals("")) {
				movementinotherperson.setMiddleName(box.getString(MIDDLE_NAME));
			}
			if (box.getString(LAST_NAME) != null
					&& !box.getString(LAST_NAME).equals("")) {
				movementinotherperson.setLastName(box.getString(LAST_NAME));
			}
			if (!box.getString(TITLE_ID).equals("0")) {
				movementinotherperson.setTitle(new MasTitle(Integer
						.parseInt(box.getString(TITLE_ID))));
			}
			if (!box.getString(EMPLOYEE_GRADE_ID).equals("0")) {
				movementinotherperson.setGrade(new MasGrade(Integer
						.parseInt(box.getString(EMPLOYEE_GRADE_ID))));
			}

			if (!box.getString(RANK_ID).equals("0")) {
				movementinotherperson.setRank(new MasRank(Integer.parseInt(box
						.getString(RANK_ID))));
			}
			if (!box.getString(EMPLOYEE_CATEGORY_ID).equals("0")) {
				movementinotherperson.setCategory(new MasEmpCategory(Integer
						.parseInt(box.getString(EMPLOYEE_CATEGORY_ID))));
			}
			if (!box.getString(TRADE_ID).equals("0")) {
				movementinotherperson.setTrade(new MasTrade(Integer
						.parseInt(box.getString(TRADE_ID))));
			}
			if (!box.getString(DEPARTMENT_ID).equals("0")) {
				movementinotherperson.setDepartment(new MasDepartment(Integer
						.parseInt(box.getString(DEPARTMENT_ID))));
			}
			if (!box.getString(POSTED_UNIT_ID).equals("0")) {
				movementinotherperson.setPresentUnit(new MasUnit(Integer
						.parseInt(box.getString(POSTED_UNIT_ID))));
			}
			if (!box.getString(SERVICE_TYPE_ID).equals("0")) {
				movementinotherperson.setServiceType(new MasServiceType(Integer
						.parseInt(box.getString(SERVICE_TYPE_ID))));
			}
			if (box.getString(CHANGED_BY) != null
					&& !box.getString(CHANGED_BY).equals("")) {
				movementinotherperson.setLastChgBy(box.getString(CHANGED_BY));
			}
			if (box.getString(CHANGED_DATE) != null
					&& !box.getString(CHANGED_DATE).equals("")) {
				movementinotherperson.setLastChgDate(HMSUtil
						.dateFormatterDDMMYYYY(box.getString(CHANGED_DATE)));
			}
			if (box.getString(CHANGED_TIME) != null
					&& !box.getString(CHANGED_TIME).equals("")) {
				movementinotherperson.setLastChgTime(box
						.getString(CHANGED_TIME));
			}

			hbt.saveOrUpdate(movementinotherperson);
			hbt.refresh(movementinotherperson);
		} catch (Exception exc) {
			exc.printStackTrace();
			successfull = false;
		}

		return successfull;

	}

	@SuppressWarnings("unused")
	public boolean editEmployeeToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Session session = (Session) getSession();
		String firstName = "";
		String lastName = "";
		String middleName = "";

		String employeeCode = "";
		//String serviceNo = "";
		String suffix = "";
		String prefix = "";
		int employeeId = 0;
		int titleId = 0;
		int departmentId = 107;

		int empStatusId = 0;
		int empCategoryId = 0;
		int gradeId = 0;
		int tradeId = 0;
		int unitId = 0;
		int rankId = 0;
		int messId=0;
		String emergencyTellNumber = "";
		String emergencyCellNumber = "";
		String residenceTellNumber = "";
		String officeTellNumber = "";
		Date appointmentDate = new Date();
		Date birthDate = new Date();
		Date dateOfMarriage = new Date();
		
		Date joinDate = new Date();

		String leaveChoice1 = "0";
		String leaveChoice2 = "0";
		String discipline = "";
		String disciplineRemarks = "";

		String onPrc = "";

		String email = "";
		String bankCode = "";
		String accounthead = "";
		String bankAccountNumber = "";
		String bankAccountCode = "";
		String employeePhoto = "";
		String employeeUrl = "";

		String grade = "";
		Date changedDate = new Date();
		String changedBy = "";
		String currentTime = "";
		Date currentDate = new Date();
		Date livingInDate = new Date();
		Date livingOutDate = new Date();
		Date rationDrawnFrom = new Date();
		Date moneyDrawnFrom = new Date();
		Date ArrivalCompleted = new Date();
		int hospitalId = 0;

		Date postedDate = new Date();
		Date torsDate = new Date();
		String vide = "";
		String porSlNo = "";
		String living = "";
		String rationMoneyDrawn = "";
		int leavechoiceid1 = 0;
		String year = null;
		int postedUnitId = 0;
		//int serviceTypeId = 0;
		List<HrorderlyLeaveAccount> hrorderlyleaveaccountList = new ArrayList<HrorderlyLeaveAccount>();
		List<HrLeaveTypeMaster> hrleavetypemasterList = new ArrayList<HrLeaveTypeMaster>();
		HrorderlyLeavechoice hrorderlyleavechoice = new HrorderlyLeavechoice();
		List<MasEmployeeDependent> masEmployeeDependentList = new ArrayList<MasEmployeeDependent>();
		employeeId = (Integer) generalMap.get("id");
		hospitalId = (Integer) generalMap.get("hospitalId");
		employeeCode = (String) generalMap.get("employeeCode");
		//serviceNo = (String) generalMap.get("serviceNo");
		firstName = (String) generalMap.get("firstName");
		lastName = (String) generalMap.get("lastName");
		middleName = (String) generalMap.get("middleName");
		employeePhoto = (String) generalMap.get("employeePhoto");
		year = (String) generalMap.get("year");
        messId = Integer.parseInt(generalMap.get("messId").toString());
		appointmentDate = (Date) generalMap.get("appointmentDate");
		birthDate = (Date) generalMap.get("birthDate");
		dateOfMarriage = (Date) generalMap.get("dateOfMarriage");
		
		ArrivalCompleted = (Date) generalMap.get("ArrivalCompleted");
		joinDate = (Date) generalMap.get("joinDate");
		titleId = (Integer) generalMap.get("titleId");
		gradeId = (Integer) generalMap.get("gradeId");
		departmentId = (Integer) generalMap.get("departmentId");

		empStatusId = (Integer) generalMap.get("empStatusId");
		empCategoryId = (Integer) generalMap.get("empCategoryId");
		rankId = (Integer) generalMap.get("rankId");
		tradeId = (Integer) generalMap.get("tradeId");
		unitId = (Integer) generalMap.get("unitId");
		emergencyTellNumber = (String) generalMap.get("emergencyTellNumber");
		emergencyCellNumber = (String) generalMap.get("emergencyCellNumber");
		residenceTellNumber = (String) generalMap.get("residenceTellNumber");
		officeTellNumber = (String) generalMap.get("officeTellNumber");
		email = (String) generalMap.get("email");
		employeeUrl = (String) generalMap.get("employeeUrl");
		bankCode = (String) generalMap.get("bankCode");
		accounthead = (String) generalMap.get("accounthead");
		bankAccountCode = (String) generalMap.get("bankAccountCode");
		grade = (String) generalMap.get("grade");
		bankAccountNumber = (String) generalMap.get("bankAccountNumber");
		postedDate = (Date) generalMap.get("postedDate");
		torsDate = (Date) generalMap.get("torsDate");
		vide = (String) generalMap.get("vide");
		porSlNo = (String) generalMap.get("porSlNo");
		living = (String) generalMap.get("living");
		rationMoneyDrawn = (String) generalMap.get("RationMoneyDrawn");
		livingInDate = (Date) generalMap.get("LivingInDate");
		livingOutDate = (Date) generalMap.get("LivingOutDate");
		rationDrawnFrom = (Date) generalMap.get("RationDrawnDate");
		moneyDrawnFrom = (Date) generalMap.get("MoneyDrawnDate");
		postedUnitId = (Integer) generalMap.get("postedUnitId");
		discipline = (String) generalMap.get("discipline");
		disciplineRemarks = (String) generalMap.get("disciplineRemarks");
		onPrc = (String) generalMap.get("onPrc");
		//serviceTypeId = (Integer) generalMap.get("serviceTypeId");
		changedBy = (String) generalMap.get("changedBy");
		leaveChoice1 = (String) generalMap.get("leaveChoice1");
		leaveChoice2 = (String) generalMap.get("leaveChoice2");
		currentTime = (String) generalMap.get("currentTime");
		hrorderlyleaveaccountList = (List) generalMap
				.get("hrorderlyleaveaccountList");
		suffix = (String) generalMap.get("suffix");
		prefix = (String) generalMap.get("prefix");
		if (generalMap.get("leavechoiceid") != null) {
			leavechoiceid1 = Integer.parseInt((String) generalMap
					.get("leavechoiceid"));
		}
		//System.out.println("employeeid ====" + employeeId + "leavechoiceid1   "+ leavechoiceid1);
		String hsql = "delete from jkt.hms.masters.business.HrorderlyLeaveAccount as hla where hla.EmployeeId="
				+ employeeId;
		String hsqlForDependent = "delete from jkt.hms.masters.business.MasEmployeeDependent as med where med.Employee.Id="
			+ employeeId;
		
		try {
			Query query = session.createQuery(hsql);
			int row = query.executeUpdate();
			query = session.createQuery(hsqlForDependent);
			int row1= query.executeUpdate();
			//System.out.println("row deleted::"+row1);
			hrleavetypemasterList = session.createCriteria(
					HrLeaveTypeMaster.class)
					.add(Restrictions.eq("Status", "y")).list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		MasEmployee masEmployee = (MasEmployee) getHibernateTemplate().load(
				MasEmployee.class, employeeId);

		//masEmployee.setId(employeeId);
		masEmployee.setEmployeeCode(employeeCode);
		//masEmployee.setServiceNo(serviceNo);
		masEmployee.setFirstName(firstName);
		masEmployee.setLastName(lastName);
		masEmployee.setMiddleName(middleName);
		masEmployee.setAccountHead(accounthead);
		masEmployee.setBankAccountNumber(bankAccountNumber);
		masEmployee.setSuffix(suffix);
		if (!prefix.equals("")) {
			masEmployee.setPrefix(prefix);
		}

		masEmployee.setBankCode(bankCode);
		masEmployee.setEmployeePhoto(employeePhoto);
		masEmployee.setUrl(employeeUrl);

		MasHospital hospital = new MasHospital();
		hospital.setId(hospitalId);
		masEmployee.setHospital(hospital);

		if (titleId != 0) {
			MasTitle masTitle = new MasTitle();
			masTitle.setId(titleId);
			masEmployee.setTitle(masTitle);
		}
		if (messId != 0) {
			HrorderlyMessMaster mess = new HrorderlyMessMaster();
			mess.setId(messId);
			masEmployee.setMess(mess);
		}
		if (departmentId != 0) {
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			masEmployee.setDepartment(masDepartment);
		}
		if (empStatusId != 0) {
			MasEmpStatus masEmpStatus = new MasEmpStatus();
			masEmpStatus.setId(empStatusId);
			masEmployee.setEmployeeStatus(masEmpStatus);
		}

		if (empCategoryId != 0) {
			MasEmpCategory masEmpCategory = new MasEmpCategory();
			masEmpCategory.setId(empCategoryId);
			masEmployee.setEmpCategory(masEmpCategory);
		}
		if (tradeId != 0) {
			MasTrade masTrade = new MasTrade();
			masTrade.setId(tradeId);
			masEmployee.setTrade(masTrade);
		}
		if (rankId != 0) {
			MasRank masRank = new MasRank();
			masRank.setId(rankId);
			masEmployee.setRank(masRank);
		}
		if (unitId != 0) {
			MasUnit masUnit = new MasUnit();
			masUnit.setId(unitId);
			masEmployee.setUnit(masUnit);
		}
		if (gradeId != 0) {
			MasGrade masGrade = new MasGrade();
			masGrade.setId(gradeId);
			masEmployee.setGrade(masGrade);
		}
		/*if (serviceTypeId != 0) {
			MasServiceType masServiceType = new MasServiceType();
			masServiceType.setId(serviceTypeId);
			masEmployee.setServiceType(masServiceType);
		}*/

		masEmployee.setAppointmentDate(appointmentDate);
		
	
		masEmployee.setDateOfBirth(birthDate);
		masEmployee.setDateOfMarriage(dateOfMarriage);
		masEmployee.setEmail(email);
		masEmployee.setTelNoEmergency(emergencyTellNumber);
		masEmployee.setCellNoEmergency(emergencyCellNumber);
		masEmployee.setTelNoResidence(residenceTellNumber);
		masEmployee.setTelNoOffice(officeTellNumber);
		masEmployee.setJoinDate(joinDate);
		masEmployee.setBankAccountCode(bankAccountCode);
		masEmployee.setStatus("y");
		masEmployee.setLastChgBy(changedBy);
		masEmployee.setLastChgDate(currentDate);
		masEmployee.setLastChgTime(currentTime);
		masEmployee.setPorSlNo(porSlNo);
		masEmployee.setPostedDate(postedDate);
		masEmployee.setTors(torsDate);
		masEmployee.setVide(vide);
		masEmployee.setLivingInOut(living);
		masEmployee.setLivingInDate(livingInDate);
		masEmployee.setLivingOutDate(livingOutDate);
		masEmployee.setRationMoneyDrawn(rationMoneyDrawn);
		masEmployee.setMoneyDrawnFrom(moneyDrawnFrom);
		masEmployee.setRationDrawnFrom(rationDrawnFrom);
		masEmployee.setDisciplinePending(discipline);
		masEmployee.setArrivalCompleted(ArrivalCompleted);
		if (!disciplineRemarks.equals("")) {
			masEmployee.setDisciplineRemarks(disciplineRemarks);
		}
		masEmployee.setOnPrc(onPrc);

		if (postedUnitId != 0) {
			MasUnit masUnit1 = new MasUnit();
			masUnit1.setId(postedUnitId);
			masEmployee.setPostedUnit(masUnit1);
		}
		hrorderlyleavechoice.setLeaveChoice1(leaveChoice1);
		hrorderlyleavechoice.setLeaveChoice2(leaveChoice2);
		hrorderlyleavechoice.setStatus("y");
		hrorderlyleavechoice.setLastChgBy(changedBy);
		hrorderlyleavechoice.setLastChgDate(currentDate);
		hrorderlyleavechoice.setLastChgTime(currentTime);
		hrorderlyleavechoice.setYear(year);
		hrorderlyleavechoice.setEmployeeId(masEmployee);
		if (leavechoiceid1 != 0) {
			hrorderlyleavechoice.setId(leavechoiceid1);
		}
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masEmployee);
			hbt.refresh(masEmployee);
			hbt.saveOrUpdate(hrorderlyleavechoice);
			for (HrorderlyLeaveAccount hrorderlyleaveaccount : hrorderlyleaveaccountList) {
				for (HrLeaveTypeMaster hrleavetypemaster : hrleavetypemasterList) {
					System.out
							.println("hrorderlyleaveaccount.getLeaveTypeId():::::"
									+ hrorderlyleaveaccount.getLeaveTypeId()
									+ "hrleavetypemaster.getId()::::::"
									+ hrleavetypemaster.getId());
					if (hrorderlyleaveaccount.getLeaveTypeId().equals(
							hrleavetypemaster.getId())) {
						hrorderlyleaveaccount
								.setEntitledLeave(hrleavetypemaster.getDays());
						//System.out.println("hrleavetypemaster"+ hrleavetypemaster.getDays()+ "hrorderlyleaveaccount");
						hbt.save(hrorderlyleaveaccount);
						hbt.refresh(hrorderlyleaveaccount);
					}
				}
			}
			if (generalMap.get("masEmployeeDependentList") != null) {
				masEmployeeDependentList = (List<MasEmployeeDependent>) generalMap.get("masEmployeeDependentList");
			}
			for(MasEmployeeDependent masEmployeeDependent :masEmployeeDependentList ){
				masEmployeeDependent.setEmployee(masEmployee);
				hbt.save(masEmployeeDependent);
			}
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	public boolean deleteEmployee(int employeeId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		List<HrorderlyLeaveAccount> hrorderlyleaveaccountList = new ArrayList<HrorderlyLeaveAccount>();
		List<HrorderlyLeavechoice> hrorderlyleavechoiceList = new ArrayList<HrorderlyLeavechoice>();
		Session session = (Session) getSession();
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasEmployee masEmployee = new MasEmployee();

		masEmployee = (MasEmployee) getHibernateTemplate().load(
				MasEmployee.class, employeeId);
		try {
			hrorderlyleaveaccountList = session.createCriteria(
					HrorderlyLeaveAccount.class).add(
					Restrictions.eq("EmployeeId", employeeId)).list();
			hrorderlyleavechoiceList = session.createCriteria(
					HrorderlyLeavechoice.class).createAlias("EmployeeId",
					"EmpId").add(Restrictions.eq("EmpId.Id", employeeId))
					.list();
			//System.out.println("hrorderlyleavechoiceList::::::::::;"+ hrorderlyleavechoiceList.size());
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		if (masEmployee.getStatus().equals("n")) {
			masEmployee.setStatus("y");
			dataDeleted = true;
		} else {
			masEmployee.setStatus("n");
			dataDeleted = false;
		}
		masEmployee.setLastChgBy(changedBy);
		masEmployee.setLastChgDate(currentDate);
		masEmployee.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masEmployee);
		for (HrorderlyLeaveAccount hrorderlyleaveaccount : hrorderlyleaveaccountList) {
			if (hrorderlyleaveaccount.getStatus().equals("n")) {
				hrorderlyleaveaccount.setStatus("y");
			} else {
				hrorderlyleaveaccount.setStatus("n");
			}
			hrorderlyleaveaccount.setChgBy(changedBy);
			hrorderlyleaveaccount.setChgDate(currentDate);
			hrorderlyleaveaccount.setChgTime(currentTime);
			hbt.saveOrUpdate(hrorderlyleaveaccount);
			hbt.refresh(hrorderlyleaveaccount);
		}
		for (HrorderlyLeavechoice hrorderlyleavechoice : hrorderlyleavechoiceList) {
			//System.out.println("status::::::::"+ hrorderlyleavechoice.getStatus());
			if (hrorderlyleavechoice.getStatus().equals("n")) {
				hrorderlyleavechoice.setStatus("y");
			} else {
				hrorderlyleavechoice.setStatus("n");
			}
			hrorderlyleavechoice.setLastChgBy(changedBy);
			hrorderlyleavechoice.setLastChgDate(currentDate);
			hrorderlyleavechoice.setLastChgTime(currentTime);
			hbt.saveOrUpdate(hrorderlyleavechoice);
			hbt.refresh(hrorderlyleavechoice);
		}
		return dataDeleted;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchEmployee(String employeeCode,
			String firstName, String lastName) {

		List<MasEmployee> searchEmployeeList = new ArrayList<MasEmployee>();
		Map<String, Object> employeeFieldsMap = new HashMap<String, Object>();
		List titleList = new ArrayList();
		List departmentList = new ArrayList();
		List costCenterList = new ArrayList();
		List empStatusList = new ArrayList();
		List empCategoryList = new ArrayList();
		List gradeList = new ArrayList();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasTrade> tradeList = new ArrayList<MasTrade>();
		List gridUnitList = null;
		try {
			if ((employeeCode != null) && (firstName == null)
					&& (lastName == null)) {
				searchEmployeeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasEmployee as  me where me.EmployeeCode like '"
								+ employeeCode + "%' order by me.EmployeeCode");
			} else if ((employeeCode == null) && (firstName != null)
					&& (lastName == null)) {
				searchEmployeeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasEmployee as me where me.FirstName like '"
								+ firstName + "%' order by me.FirstName");
			} else if ((employeeCode == null) && (firstName == null)
					&& (lastName != null)) {
				searchEmployeeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasEmployee me where me.LastName like '"
								+ lastName + "%' order by me.LastName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		gridUnitList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasUnit as isc");
		titleList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasTitle as mt where mt.Status = 'y'");
		departmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment as md where md.Status = 'y'");
		costCenterList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasCostCenter as md where md.Status = 'y' ");
		empStatusList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasEmpStatus as md where md.Status = 'y'");
		empCategoryList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasEmpCategory as md where md.Status = 'y'");
		gradeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasGrade as mg where mg.Status = 'y'");
		rankList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasRank as mg where mg.Status = 'y'");
		unitList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasUnit as mg where mg.Status = 'y'");
		tradeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasTrade as mg where mg.Status = 'y'");

		employeeFieldsMap.put("gridUnitList", gridUnitList);
		employeeFieldsMap.put("searchEmployeeList", searchEmployeeList);
		employeeFieldsMap.put("titleList", titleList);
		employeeFieldsMap.put("departmentList", departmentList);
		employeeFieldsMap.put("costCenterList", costCenterList);
		employeeFieldsMap.put("empStatusList", empStatusList);
		employeeFieldsMap.put("empCategoryList", empCategoryList);
		employeeFieldsMap.put("gradeList", gradeList);
		employeeFieldsMap.put("rankList", rankList);
		employeeFieldsMap.put("unitList", unitList);
		employeeFieldsMap.put("tradeList", tradeList);
		return employeeFieldsMap;
	}

	/**
	 * -------------------------------------method to add por program master
	 * ----------------------------------
	 */

	public boolean addPorProgram(MasPorProgram masporProgram) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masporProgram);
		successfullyAdded = true;
		return successfullyAdded;
	}

	/**
	 * ----------------------------------------method to delete
	 * record----------------------------------------
	 */
	public boolean deletePorProgram(int porProgramId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasPorProgram masProgram = new MasPorProgram();
		masProgram = (MasPorProgram) getHibernateTemplate().get(
				MasPorProgram.class, porProgramId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masProgram.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masProgram.setStatus("y");
				dataDeleted = false;
			}
		}
		masProgram.setLastChgBy(changedBy);
		masProgram.setLastChgDate(currentDate);
		masProgram.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(masProgram);
		return dataDeleted;
	}

	/**
	 * ------------------------------------------- method to edit
	 * record--------------------------------------
	 */
	public boolean editPorProgram(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		Date fromDate = new Date();
		Date toDate = new Date();
		int porProgramId = 0;
		String porNumber = "";
		String remarks = "";
		String changedBy = "";

		try {
			porProgramId = (Integer) generalMap.get("id");
			fromDate = (Date) generalMap.get("fromDate");
			toDate = (Date) generalMap.get("toDate");
			remarks = (String) generalMap.get("remarks");
			porNumber = (String) generalMap.get("porNumber");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
		} catch (Exception e) {
			System.out
					.println("Exception before por program in dataserviceImpl "
							+ e);
		}

		MasPorProgram masporProgram = (MasPorProgram) getHibernateTemplate()
				.get(MasPorProgram.class, porProgramId);

		masporProgram.setId(porProgramId);
		masporProgram.setFromDate(fromDate);
		masporProgram.setToDate(toDate);
		masporProgram.setRemarks(remarks);
		masporProgram.setPorNumber(porNumber);
		masporProgram.setLastChgBy(changedBy);
		masporProgram.setLastChgDate(currentDate);
		masporProgram.setLastChgTime(currentTime);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(masporProgram);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	/**
	 * -------------------------------------- method to search por program
	 * master-----------------------------
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchPorProgram(String porNumber,
			Date fromDateField, Date toDateField) {
		List<MasPorProgram> searchPorProgramList = new ArrayList<MasPorProgram>();
		Map<String, Object> chargeCodeFieldsMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Criteria crit = null;
		try {
			crit = session.createCriteria(MasPorProgram.class).add(
					Restrictions.like("PorNumber", porNumber + "%")).add(
					Restrictions.eq("FromDate", fromDateField)).add(
					Restrictions.eq("ToDate", toDateField));
			searchPorProgramList = crit.list();

		} catch (Exception e) {
			//System.out.println("Ds excp in searchporList  " + e);
		}

		chargeCodeFieldsMap.put("searchPorProgramList", searchPorProgramList);
		return chargeCodeFieldsMap;

	}

	/* LEAVE RESTRICTION METHODS */

	// Leave Restriction Entry
	public Map<String, Object> showLeaveRestrictionEntryJsp() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrLeaveTypeMaster> leaveTypeList = new ArrayList<HrLeaveTypeMaster>();
		List<LeaveRestrictionEntry> leaverestrictionentryList = new ArrayList<LeaveRestrictionEntry>();

		leaveTypeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.HrLeaveTypeMaster ht where ht.Status='y'");
		leaverestrictionentryList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.LeaveRestrictionEntry lre where lre.Status='y' and lre.ToPeriod >current_date() ");
		map.put("leaveTypeList", leaveTypeList);
		map.put("leaverestrictionentryList", leaverestrictionentryList);
		return map;
	}

	public boolean addLeaveRestrictionEntry(
			LeaveRestrictionEntry leaveRestrictionEntry) {

		boolean successfullyAdded = false;
		List<TransactionSequence> transactionSequenceList = new ArrayList<TransactionSequence>();
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(leaveRestrictionEntry);
		transactionSequenceList = session.createCriteria(
				TransactionSequence.class).add(
				Restrictions.eq("TransactionPrefix", "LRE")).list();
		if (transactionSequenceList.size() > 0) {
			for (TransactionSequence transactionSequence : transactionSequenceList) {
				int seqno = transactionSequence.getTransactionSequenceNumber();
				transactionSequence.setTransactionSequenceNumber(++seqno);
				hbt.saveOrUpdate(transactionSequence);
			}
		}

		successfullyAdded = true;
		return successfullyAdded;

	}

	public String generateLeaveRestrictionEntryNumber(
			Map<String, Object> infoMap) {
		List<TransactionSequence> leaveApplicationList = new ArrayList<TransactionSequence>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		Session session = (Session) getSession();
		String entryNo = "";
		String date = "";
		date = (String) utilMap.get("currentDate");

		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		String[] currentDate = date.split("/");
		String currentMonth = currentDate[1];
		leaveApplicationList = session
				.createCriteria(TransactionSequence.class).add(
						Restrictions.eq("TransactionPrefix", "LRE")).list();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (leaveApplicationList.size() > 0) {
			for (TransactionSequence transactionSequence : leaveApplicationList) {
				TransactionSequence obj = transactionSequence;
				int id = obj.getId();
				int seqNo = obj.getTransactionSequenceNumber();

				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
						.load(TransactionSequence.class, id);
				transactionSequenceObj.setTransactionSequenceNumber(seqNo);
				if (currentMonth.equalsIgnoreCase("01")) {
					transactionSequenceObj.setTransactionSequenceNumber(1);
					seqNo = 1;
				}
				hbt.update(transactionSequenceObj);
				entryNo = entryNo.concat(String.valueOf(++seqNo));

			}
		} else if (leaveApplicationList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("LeaveRestrictionEntry");
			tsObj.setTransactionPrefix("LRE");
			tsObj.setTransactionSequenceName("Leave Entry No");
			tsObj.setTransactionSequenceNumber(0);
			hbt.save(tsObj);
		}
		return entryNo;
	}

	// method for search leave restriction

	public Map<String, Object> searchLeaveRestrictionEntry(String entryNo,
			Date entryDate) {
		Session session = (Session) getSession();
		List<LeaveRestrictionEntry> leaveRestrictionEntryList = new ArrayList<LeaveRestrictionEntry>();
		Map<String, Object> infoMap = new HashMap<String, Object>();

		try {
			if (entryNo != null && entryDate == null) {
				leaveRestrictionEntryList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.LeaveRestrictionEntry imc where imc.EntryNo like '"
										+ entryNo + "%'");
			} else if (entryDate != null && entryNo == null) {
				leaveRestrictionEntryList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.LeaveRestrictionEntry imc where imc.EntryDate ='"
										+ HMSUtil.getDateFormat(entryDate,
												"yyyy-MM-dd") + "'");
			} else if (entryNo != null && entryDate != null) {
				leaveRestrictionEntryList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.LeaveRestrictionEntry imc where imc.EntryNo ='"
								+ entryNo
								+ "' and imc.EntryDate ='"
								+ HMSUtil
										.getDateFormat(entryDate, "yyyy-MM-dd")
								+ "'");
			}

		} catch (Exception e) {
			//System.out.println("Ds excp in leaveRestrictionEntryList  " + e);
		}
		infoMap.put("leaveRestrictionEntryList", leaveRestrictionEntryList);
		return infoMap;

	}

	public Map<String, Object> showLeaveRestrictionUpdateJsp(int Id) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrLeaveTypeMaster> leaveTypeList = new ArrayList<HrLeaveTypeMaster>();
		List<LeaveRestrictionEntry> leaveRestrictionList = new ArrayList<LeaveRestrictionEntry>();
		leaveTypeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.HrLeaveTypeMaster ht where ht.Status='y'");
		leaveRestrictionList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.LeaveRestrictionEntry as lre where lre.Id ='"
						+ Id + "'");
		map.put("leaveTypeList", leaveTypeList);
		map.put("leaveRestrictionList", leaveRestrictionList);
		return map;
	}

	public boolean editLeaveRestrictionUpdateToDatabase(
			Map<String, Object> generalMap) {

		boolean dataUpdated = false;

		int leaveRestrictionId = 0;
		Date entryDate = null;
		Date fromPeriod = null;
		Date toPeriod = null;
		int leaveType = 0;
		String maxLeaveDays = "";
		String remarks = "";
		String lastChangedBy = "";
		String lastChangedDate = "";
		String lastChangedTime = "";
		Date currentDate = new Date();
		String currentTime = "";

		leaveRestrictionId = (Integer) generalMap.get("id");
		entryDate = (Date) generalMap.get("entryDate");
		fromPeriod = (Date) generalMap.get("fromPeriod");
		toPeriod = (Date) generalMap.get("toDate");
		leaveType = (Integer) generalMap.get("leaveType");
		maxLeaveDays = (String) generalMap.get("maxLeaveDays");
		remarks = (String) generalMap.get("remarks");
		lastChangedBy = (String) generalMap.get("lastChangedBy");
		lastChangedDate = (String) generalMap.get("lastChangedDate");
		lastChangedTime = (String) generalMap.get("lastChangedTime");
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		DateFormat myDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		LeaveRestrictionEntry leaveRestrictionUpdate = (LeaveRestrictionEntry) getHibernateTemplate()
				.load(LeaveRestrictionEntry.class, leaveRestrictionId);

		leaveRestrictionUpdate.setId(leaveRestrictionId);
		leaveRestrictionUpdate.setEntryDate(entryDate);

		leaveRestrictionUpdate.setFromPeriod(fromPeriod);

		leaveRestrictionUpdate.setToPeriod(toPeriod);
		leaveRestrictionUpdate.setMaxLeaveDays(Integer.parseInt(maxLeaveDays));

		leaveRestrictionUpdate.setRemarks(remarks);

		if (leaveType != 0) {
			HrLeaveTypeMaster hrLeaveTypeMaster = new HrLeaveTypeMaster();
			hrLeaveTypeMaster.setId(leaveType);
			leaveRestrictionUpdate.setLeave(hrLeaveTypeMaster);
		}

		leaveRestrictionUpdate.setLastChangedBy(lastChangedBy);
		leaveRestrictionUpdate.setLastChangedDate(currentDate);
		leaveRestrictionUpdate.setLastChangedTime(currentTime);

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(true);
		hbt.update(leaveRestrictionUpdate);
		dataUpdated = true;
		return dataUpdated;
	}

	/**
	 * -------------------------------------- method to search leave
	 * application------------------------
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDetailsForSearchForLeaveApplication(
			Map<String, Object> dataMap) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		List<MasPool> masPoolList = new ArrayList<MasPool>();
		Session session = (Session) getSession();
		serviceTypeList = session.createCriteria(MasServiceType.class).list();
		rankList = session.createCriteria(MasRank.class).add(
				Restrictions.eq("Status", "y")).list();
		if (rankList.size() > 0) {
			detailsMap.put("rankList", rankList);
		}
		if (serviceTypeList.size() > 0) {
			detailsMap.put("ServiceTypeList", serviceTypeList);
		}
		if (masPoolList.size() > 0) {
			detailsMap.put("masPoolList", masPoolList);
		}

		return detailsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getEmployeeDetailsGrid(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> searchEmployeeList = new ArrayList<MasEmployee>();
		String serviceNo = "";
		int rankId = 0;
		String serPersonLName = "";
		String serPersonFName = "";

		Session session = (Session) getSession();
		Criteria crit = null;

		int deptId = 0;
		if (mapForDs.get("deptId") != null)
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));

		if (mapForDs.get("serPersonLName") != null) {
			serPersonLName = (String) mapForDs.get("serPersonLName");
		}

		if (mapForDs.get("serviceNo") != null) {
			serviceNo = (String) mapForDs.get("serviceNo");
		}
		if (mapForDs.get("rankId") != "0" && mapForDs.get("rankId") != null) {
			rankId = Integer.parseInt("" + mapForDs.get("rankId"));
		}

		if (mapForDs.get("serPersonFName") != null) {
			serPersonFName = (String) mapForDs.get("serPersonFName");
		}

		try {
			crit = session.createCriteria(MasEmployee.class).add(
					Restrictions.ne("Status", "n")).add(
					Restrictions.ne("Status", "o"));

			if (!serviceNo.equals("")) {
				crit = crit.add(Restrictions.like("ServiceNo", "%" + serviceNo
						+ "%"));
			}
			if (!serPersonFName.equals("")) {
				crit = crit.add(Restrictions.like("FirstName", "%"
						+ serPersonFName + "%"));
			}
			if (!serPersonLName.equals("")) {
				crit = crit.add(Restrictions.like("LastName", "%"
						+ serPersonLName + "%"));
			}

			if (rankId != 0) {
				crit = crit.createAlias("Rank", "rank").add(
						Restrictions.eq("rank.Id", rankId));
			}

			searchEmployeeList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("searchEmployeeList", searchEmployeeList);
		return map;
	}

	public Map<String, Object> showLeaveApplicationJsp(int Id) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrLeaveTypeMaster> leaveTypeList = new ArrayList<HrLeaveTypeMaster>();
		List<MasDistrict> cityList = new ArrayList<MasDistrict>();
		List<MasState> stateList = new ArrayList<MasState>();
		List<LeaveRestrictionEntry> leaveRestrictionEntryList = new ArrayList<LeaveRestrictionEntry>();
		List<EmpLeaveBalance> empLeaveBalanceList = new ArrayList<EmpLeaveBalance>();
		List<HrorderlyLeaveApplication> leaveApplicationList = new ArrayList<HrorderlyLeaveApplication>();
		List<HrorderlyLeaveApplication> leaveApplicationRecordList = new ArrayList<HrorderlyLeaveApplication>();
		List<HrorderlyLeaveAccount> hrorderlyleaveaccountList = new ArrayList<HrorderlyLeaveAccount>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<TrainClassGroup> trainclassgroupList = new ArrayList<TrainClassGroup>();
		MasEmployee masemployee = null;
		Date currentDate = new Date();
		leaveTypeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.HrLeaveTypeMaster lt where lt.Status = 'y'");
		cityList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDistrict");
		stateList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasState");
		employeeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasEmployee where Id ='" + Id
						+ "'");
		leaveRestrictionEntryList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.LeaveRestrictionEntry where ToPeriod > current_date()");
		empLeaveBalanceList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.EmpLeaveBalance");
		hrorderlyleaveaccountList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.HrorderlyLeaveAccount as hla where hla.Status='y' and hla.EmployeeId='"
						+ Id + "'");
 
		trainclassgroupList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.TrainClassGroup as tc where tc.RankCategoryId='"
						+ masemployee.getRank().getRankCategory().getId()
						+ "' and tc.Status='y'");
		leaveApplicationList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.HrorderlyLeaveApplication as la where la.Status='y' and la.Employee=' "
								+ Id + "'  and la.ApprovedStatus='w'");
		leaveApplicationRecordList=getHibernateTemplate().find("from jkt.hms.masters.business.HrorderlyLeaveApplication as la where la.Status='y' and la.ApprovedStatus='y' and la.Employee=' "
								+ Id + "'  and la.DateOfReporting > current_date()");
		//System.out.println("trainclassgroupList" + trainclassgroupList.size()	+ "::leaveApplicationList::" + leaveApplicationList.size());

		map.put("Id", Id);
		map.put("leaveApplicationRecordList", leaveApplicationRecordList);
		map.put("leaveApplicationList", leaveApplicationList);
		map.put("leaveTypeList", leaveTypeList);
		map.put("cityList", cityList);
		map.put("stateList", stateList);
		map.put("leaveRestrictionEntryList", leaveRestrictionEntryList);
		map.put("hrorderlyleaveaccountList", hrorderlyleaveaccountList);
		map.put("empLeaveBalanceList", empLeaveBalanceList);
		map.put("employeeList", employeeList);
		map.put("trainclassgroupList", trainclassgroupList);
		return map;
	}

	public Map<String, Object> addLeaveApplication(
			HrorderlyLeaveApplication hrorderlyLeaveApplication,
			List<FamilyDetails> familyDetails, Map<String, Object> generalMap) {

		boolean successfullyAdded = false;
		HibernateTemplate hbt1 = getHibernateTemplate();
		Map<String, Object> map = new HashMap<String, Object>();
		int rankCategoryId = 0;
		hbt1.setFlushModeName("FLUSH_EAGER");
		hbt1.setCheckWriteOperations(false);
		boolean leaveApplication = false;
		int employeeId = (Integer) generalMap.get("id");
		MasEmployee masEmployee = (MasEmployee) getHibernateTemplate().load(
				MasEmployee.class, employeeId);
		// masEmployee.setStatus("o");
		rankCategoryId = masEmployee.getRank().getRankCategory().getId();
		if (masEmployee.getTrade().getId() == 2
				|| masEmployee.getTrade().getId() == 7) {
			hrorderlyLeaveApplication.setRecommendedStatus("w");
		} else {
			hrorderlyLeaveApplication.setRecommendedStatus("y");
		}
		try {

			hbt1.save(hrorderlyLeaveApplication);
			hbt1.refresh(hrorderlyLeaveApplication);
			leaveApplication = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		SessionFactory sessFactory = getSessionFactory();
		Session sess = sessFactory.openSession();
		String sqlQuery = "select max(id)from HrorderlyLeaveApplication";
		Query query = sess.createQuery(sqlQuery);
		List list = query.list();
		int id = Integer.parseInt(list.get(0).toString());
		sess.close();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		if (leaveApplication && familyDetails != null) {

			for (FamilyDetails familydetails : familyDetails) {
				familydetails.setLeaveApplication(id);
				hbt1.save(familydetails);
			}

			successfullyAdded = true;
		}
		map.put("rankCategoryId", rankCategoryId);
		map.put("successfullyAdded", successfullyAdded);
		return map;
	}

	public String generateLeaveApplicationEntryNumber(String userName) {
		List<TransactionSequence> leaveApplicationList = new ArrayList<TransactionSequence>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		Session session = (Session) getSession();
		String entryNo = "";
		String date = "";
		date = (String) utilMap.get("currentDate");

		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		String[] currentDate = date.split("/");
		String currentMonth = currentDate[1];
		leaveApplicationList = session
				.createCriteria(TransactionSequence.class).add(
						Restrictions.eq("TransactionPrefix", "MLA")).list();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (leaveApplicationList.size() > 0) {
			for (TransactionSequence transactionSequence : leaveApplicationList) {
				TransactionSequence obj = transactionSequence;
				int id = obj.getId();
				int seqNo = obj.getTransactionSequenceNumber();

				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
						.load(TransactionSequence.class, id);
				transactionSequenceObj.setTransactionSequenceNumber(++seqNo);
				if (currentMonth.equalsIgnoreCase("01")) {
					transactionSequenceObj.setTransactionSequenceNumber(1);
					seqNo = 1;
				}
				hbt.update(transactionSequenceObj);
				entryNo = entryNo.concat(String.valueOf(seqNo));
				entryNo = entryNo.concat("/").concat(currentMonth);
				entryNo = entryNo.concat("/").concat(currentYear);
			}
		} else if (leaveApplicationList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("HrorderlyLeaveApplication");
			tsObj.setTransactionPrefix("MLA");
			tsObj.setTransactionSequenceName("Leave Entry No");
			tsObj.setTransactionSequenceNumber(0);
			hbt.save(tsObj);
		}
		return entryNo;
	}

	public Map<String, Object> showProposalForHro() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> searchMasEmployeeList = new ArrayList<MasEmployee>();
		List<ProposalForHroEntry> proposalForHroEntry = new ArrayList<ProposalForHroEntry>();
		searchMasEmployeeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasEmployee me where me.Status='y' ");
		proposalForHroEntry = getHibernateTemplate().find(
				"from jkt.hms.masters.business.ProposalForHroEntry ");
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		departmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment");
		map.put("proposalForHroEntry", proposalForHroEntry);
		//System.out.println("employee" + searchMasEmployeeList.size());
		map.put("searchMasEmployeeList", searchMasEmployeeList);
		map.put("departmentList", departmentList);
		return map;
	}

	public boolean addProposalForHro(ProposalForHroEntry proposalForHroEntry) 
		{
			String date = "";
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
			List<TransactionSequence> transanctionList = new ArrayList<TransactionSequence>();
			Session session = (Session) getSession();
			date = (String) utilMap.get("currentDate");
			String currentYear = date.substring(date.lastIndexOf("/") + 1);
			String[] currentDate = date.split("/");
			String currentMonth = currentDate[1];
			boolean successfullyAdded = false;
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
			transanctionList = session.createCriteria(TransactionSequence.class).add(Restrictions.eq("TransactionPrefix", "PHRO")).list();
			String entryNoFromJsp=proposalForHroEntry.getEntryNo();
		    String []currentyear=entryNoFromJsp.split("/");
		    TransactionSequence tranSeq=transanctionList.get(0);
		    int numberT=tranSeq.getTransactionSequenceNumber()+1;
		    tranSeq.setTransactionSequenceNumber(numberT);
		    String entryNo = ""+numberT+"/"+currentyear[1];
		    proposalForHroEntry.setEntryNo(entryNo);
			
		    hbt.save(proposalForHroEntry);
		    hbt.refresh(proposalForHroEntry);
			successfullyAdded = true;
			if(successfullyAdded)
			{
				hbt.save(tranSeq);
				hbt.refresh(tranSeq);
				
			}
			return successfullyAdded;
		
	}

	public Map<String, Object> showDepartment(int deptId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		departmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment");
		map.put("departmentList", departmentList);
		return map;
	}

	public String generateProposalHroEntryNo(Map<String, Object> diagMap) {
		List<TransactionSequence> medicalWorkNoList = new ArrayList<TransactionSequence>();
		List<ProposalForHroEntry> proposalForHroEntryList = new ArrayList<ProposalForHroEntry>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		Session session = (Session) getSession();
		int lastId=0;
		String entryNo = "";
		String entryNo1 = "";
		String [] lastEntryNo=null;
		String date = "";
		date = (String) utilMap.get("currentDate");

		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		String[] currentDate = date.split("/");
		String currentMonth = currentDate[1];
		proposalForHroEntryList = session.createCriteria(ProposalForHroEntry.class).list();
		for(ProposalForHroEntry proposalforhro : proposalForHroEntryList)
		{
			entryNo1=proposalforhro.getEntryNo();
			
		}
		lastEntryNo=entryNo1.split("/");
		medicalWorkNoList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "PHRO")).list();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		int seqNo = 0;
		if (medicalWorkNoList.size() > 0) {
			for (TransactionSequence transactionSequence : medicalWorkNoList) {
				TransactionSequence obj = transactionSequence;
				int id = obj.getId();
			    seqNo = obj.getTransactionSequenceNumber();
			    
                if(lastEntryNo.length>1 && !currentYear.equals(lastEntryNo[1])){
                	seqNo=0;
                	TransactionSequence transq = (TransactionSequence)hbt.get(TransactionSequence.class ,id);
                	transq.setTransactionSequenceNumber(0);
                	hbt.saveOrUpdate(transq);
                	
                }
				//entryNo = entryNo.concat(String.valueOf(++seqNo));
				//entryNo = entryNo.concat("/").concat(currentMonth);
			   //entryNo = entryNo.concat("/").concat(currentYear);

			}
		} else if (medicalWorkNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("ProposalForHroEntry");
			tsObj.setTransactionPrefix("PHRO");
			tsObj.setTransactionSequenceName("EntryNo");
			tsObj.setTransactionSequenceNumber(0);
			hbt.save(tsObj);
		}
		entryNo = entryNo.concat(String.valueOf(++seqNo));
		//entryNo = entryNo.concat("/").concat(currentMonth);
		entryNo = entryNo.concat("/").concat(currentYear);
		return entryNo;
	}

	public Map<String, Object> showHroEntry() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
		Session session = (Session)getSession();
		masEmployeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y"))
		.createAlias("Rank","MR")
		.createAlias("MR.RankCategory","MRC").add(Restrictions.eq("MRC.Id", 1)).list();
		//System.out.println("masEmployeeList::"+masEmployeeList.size());
		map.put("masEmployeeList", masEmployeeList);
		return map;

	}
	public Map<String ,Object> getPendingProposalList()
	{
		Map<String,Object> map = new HashMap<String,Object>();
		List<PendingHroProposal> pendingHroProposalList = new ArrayList<PendingHroProposal>();
		Session session = (Session)getSession();
		pendingHroProposalList=session.createCriteria(PendingHroProposal.class).add(Restrictions.eq("Dispatch","p"))
		.add(Restrictions.eq("Status","y")).list();
		map.put("pendingHroProposalList", pendingHroProposalList);
		return map;
	}

	public Map<String, Object> addHroEntry(HroEntry hroEntry) {
		{
			Map<String, Object> resultMap = new HashMap<String,Object>();
			List<PendingHroProposal> pendingHroProposalList = new ArrayList<PendingHroProposal>();
			boolean successfullyAdded = false;
			Session session = getSession();
			TransactionSequence transSequence = new TransactionSequence();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(hroEntry);
			hbt.refresh(hroEntry);
			transSequence = (TransactionSequence)session.createCriteria(TransactionSequence.class).add(
					Restrictions.eq("TransactionPrefix", "PHE")).list().get(0);
			//System.out.println("transSequence::"+transSequence.getTransactionSequenceNumber());
			transSequence.setTransactionSequenceNumber(transSequence.getTransactionSequenceNumber()+1);
			hbt.saveOrUpdate(transSequence);
		    hbt.refresh(transSequence);
		    pendingHroProposalList = (List<PendingHroProposal>)session.createCriteria(PendingHroProposal.class).add(Restrictions.eq("Dispatch","p"))
            .add(Restrictions.eq("Status", "y")).list();
		    for(PendingHroProposal pendingHroProposal :pendingHroProposalList ){
		        pendingHroProposal.setDispatch("d");
		        hbt.saveOrUpdate(pendingHroProposal);
		        hbt.refresh(pendingHroProposal);
		    }
			successfullyAdded = true;
			resultMap.put("Id", ""+hroEntry.getId());
			resultMap.put("successfullyAdded", successfullyAdded);
			return resultMap;
		}
	}
	public Map<String, Object> printHroDetail(Box box)
	{
		Map<String, Object> utilMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		HroEntry hroEntry = null;
		hroEntry = (HroEntry)session.get(HroEntry.class,Integer.parseInt((box.get("hroEntryId")).toString()));
		utilMap.put("hroEntry", hroEntry);
		return utilMap;
	}
	public String generateHroEntryNo(Map<String, Object> diagMap) {
		List<TransactionSequence> transactionhroList = new ArrayList<TransactionSequence>();
		List<HroEntry> hroEntryList = new ArrayList<HroEntry>();
		
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		Session session = (Session) getSession();
		String entryNo = "";
		String date = "";
		date = (String) utilMap.get("currentDate");
        String lastEntryNo=""; 
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		String[] currentDate = date.split("/");
		String currentMonth = currentDate[1];
		transactionhroList = session.createCriteria(TransactionSequence.class).add(Restrictions.eq("TransactionPrefix", "PHE")).list();
		hroEntryList=(List<HroEntry>)session.createCriteria(HroEntry.class).list();
		for(HroEntry hroEntry : hroEntryList)
		{
			lastEntryNo=hroEntry.getEntryNo();
		}
		//System.out.println("lastEntryNo::"+lastEntryNo);
		String[] lastentryno=null;
		if(!lastEntryNo.equalsIgnoreCase(""))
		{
			lastentryno=lastEntryNo.split("/");
		}
		
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		int seqNo=0;
		if (transactionhroList.size() > 0) {
			for (TransactionSequence transactionSequence : transactionhroList) {
				TransactionSequence obj = transactionSequence;
				int id = obj.getId();
				seqNo = obj.getTransactionSequenceNumber()+1;
                 
				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
						.load(TransactionSequence.class, id);
				//transactionSequenceObj.setTransactionSequenceNumber(++seqNo);
				if (!lastEntryNo.equals("") && !currentYear.equalsIgnoreCase(lastentryno[2])) {
					transactionSequenceObj.setTransactionSequenceNumber(0);
					hbt.update(transactionSequenceObj);
				}
				
				
			}
		} else if (transactionhroList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("HroEntry");
			tsObj.setTransactionPrefix("PHE");
			tsObj.setTransactionSequenceName("Hro Entry");
			tsObj.setTransactionSequenceNumber(0);
			seqNo=1;
			hbt.save(tsObj);
		}
		entryNo = entryNo.concat(String.valueOf(seqNo));
		entryNo = entryNo.concat("/").concat(currentMonth);
		entryNo = entryNo.concat("/").concat(currentYear);
		return entryNo;
	}

	public Map<String, Object> getDetailsForSearchForMovementOut(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		Session session = (Session) getSession();
		rankList = session.createCriteria(MasRank.class).add(
				Restrictions.eq("Status", "y")).list();
		if (rankList.size() > 0) {
			map.put("rankList", rankList);
		}

		return map;
	}

	public Map<String, Object> showPersonnelFromOtherUnitJsp() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasTitle> titleList = new ArrayList<MasTitle>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasEmpStatus> empStatusList = new ArrayList<MasEmpStatus>();
		List<MasEmpCategory> empCategoryList = new ArrayList<MasEmpCategory>();
		List<MasGrade> gradeList = new ArrayList<MasGrade>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasTrade> tradeList = new ArrayList<MasTrade>();
		List<MasUnit> chafbUnitList = new ArrayList<MasUnit>();
		List<TransactionSequence> seqList = new ArrayList<TransactionSequence>();
		List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		String personnelCode = "P";
		TransactionSequence transactionsequence = null;

		titleList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasTitle as tm where tm.Status = 'y'");
		departmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment as md where md.Status = 'y'");
		empCategoryList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasEmpCategory as mec where mec.Status = 'y'");
		empStatusList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasEmpStatus as mes where mes.Status = 'y'");
		gradeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasGrade as mg where mg.Status = 'y'");
		rankList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasRank as mg where mg.ServiceStatus=1 and mg.Status = 'y'");

		unitList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasUnit as mg where mg.Status = 'y'");
		chafbUnitList = session.createCriteria(MasUnit.class).add(
				Restrictions.eq("Status", "y")).add(
				Restrictions.eq("DependentUnit", "y")).list();
		tradeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasTrade as mg where mg.Status = 'y'");
		serviceTypeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasServiceType as mg where mg.Status = 'y'");

		seqList = session.createCriteria(TransactionSequence.class).add(
				Restrictions.eq("TransactionPrefix", "PFOU")).list();
		if (seqList.size() > 0) {
			transactionsequence = (TransactionSequence) seqList.get(0);
			personnelCode += transactionsequence.getTransactionSequenceNumber();
		} else {
			transactionsequence = new TransactionSequence();
			transactionsequence.setTransactionSequenceNumber(1);
			transactionsequence.setTransactionPrefix("PFOU");
			transactionsequence
					.setTransactionSequenceName("Personnel From Other Unit");
			transactionsequence.setTablename("movement_in_other_person");
			transactionsequence.setStatus("y");
			session.save(transactionsequence);
			session.refresh(transactionsequence);
			personnelCode += 1;

		}

		map.put("chafbUnitList", chafbUnitList);
		map.put("titleList", titleList);
		map.put("departmentList", departmentList);
		map.put("empStatusList", empStatusList);
		map.put("empCategoryList", empCategoryList);
		map.put("gradeList", gradeList);
		map.put("rankList", rankList);
		map.put("unitList", unitList);
		map.put("tradeList", tradeList);
		map.put("seqList", seqList);
		map.put("serviceTypeList", serviceTypeList);
		map.put("personnelCode", personnelCode);

		return map;
	}

	public Map<String, Object> showUpdatePersonnelFromOtherUnitJsp(
			int personelId) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasTitle> titleList = new ArrayList<MasTitle>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasEmpStatus> empStatusList = new ArrayList<MasEmpStatus>();
		List<MasEmpCategory> empCategoryList = new ArrayList<MasEmpCategory>();
		List<MasGrade> gradeList = new ArrayList<MasGrade>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasTrade> tradeList = new ArrayList<MasTrade>();
		List<MasUnit> chafbUnitList = new ArrayList<MasUnit>();
		List<MovementInOtherPerson> movementinotherpersonList = new ArrayList<MovementInOtherPerson>();
		List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		movementinotherpersonList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MovementInOtherPerson as miop where miop.Id="
						+ personelId);
		titleList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasTitle as tm where tm.Status = 'y'");
		departmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment as md where md.Status = 'y'");
		empCategoryList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasEmpCategory as mec where mec.Status = 'y'");
		empStatusList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasEmpStatus as mes where mes.Status = 'y'");
		gradeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasGrade as mg where mg.Status = 'y'");
		rankList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasRank as mg where mg.ServiceStatus=1 and mg.Status = 'y'");

		unitList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasUnit as mg where mg.Status = 'y'");
		chafbUnitList = session.createCriteria(MasUnit.class).add(
				Restrictions.eq("Status", "y")).add(
				Restrictions.eq("DependentUnit", "y")).list();
		tradeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasTrade as mg where mg.Status = 'y'");
		serviceTypeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasServiceType as mg where mg.Status = 'y'");
		map.put("movementinotherpersonList", movementinotherpersonList);
		map.put("chafbUnitList", chafbUnitList);
		map.put("titleList", titleList);
		map.put("departmentList", departmentList);
		map.put("empStatusList", empStatusList);
		map.put("empCategoryList", empCategoryList);
		map.put("gradeList", gradeList);
		map.put("rankList", rankList);
		map.put("unitList", unitList);
		map.put("tradeList", tradeList);
		map.put("serviceTypeList", serviceTypeList);
		map.put("personelId", personelId);

		return map;
	}

	public Map<String, Object> getMovementInDetailsGrid(
			Map<String, Object> infoMap) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> searchEmployeeList = new ArrayList<MasEmployee>();
		List<MovementInOtherPerson> searchotherpersoList = new ArrayList<MovementInOtherPerson>();
		String serviceNo = "";
		int rankId = 0;
		String serPersonLName = "";
		String serPersonFName = "";

		Session session = (Session) getSession();
		Criteria crit = null;
		Criteria criteria = null;

		int deptId = 0;
		if (infoMap.get("deptId") != null)
			deptId = Integer.parseInt("" + infoMap.get("deptId"));

		if (infoMap.get("serPersonLName") != null) {
			serPersonLName = (String) infoMap.get("serPersonLName");
		}

		if (infoMap.get("serviceNo") != null) {
			serviceNo = (String) infoMap.get("serviceNo");
		}
		if (infoMap.get("rankId") != "0" && infoMap.get("rankId") != null) {
			rankId = Integer.parseInt("" + infoMap.get("rankId"));
		}

		if (infoMap.get("serPersonFName") != null) {
			serPersonFName = (String) infoMap.get("serPersonFName");
		}

		try {
			crit = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).add(
					Restrictions.eq("MovementOutStatus", "y"));

			if (!serviceNo.equals("")) {
				crit = crit
						.add(Restrictions.like("ServiceNo", serviceNo + "%"));
			}
			if (!serPersonFName.equals("")) {
				crit = crit.add(Restrictions.like("FirstName", serPersonFName
						+ "%"));
			}
			if (!serPersonLName.equals("")) {
				crit = crit.add(Restrictions.like("LastName", serPersonLName
						+ "%"));
			}

			if (rankId != 0) {
				crit = crit.createAlias("Rank", "rank").add(
						Restrictions.eq("rank.Id", rankId));
			}

			criteria = session.createCriteria(MovementInOtherPerson.class).add(
					Restrictions.eq("Status", "y")).add(
					Restrictions.eq("MovementOutStatus", "y"));

			if (!serviceNo.equals("")) {
				criteria = criteria.add(Restrictions.like("ServiceNo",
						serviceNo + "%"));
			}
			if (!serPersonFName.equals("")) {
				criteria = criteria.add(Restrictions.like("FirstName",
						serPersonFName + "%"));
			}
			if (!serPersonLName.equals("")) {
				criteria = criteria.add(Restrictions.like("LastName",
						serPersonLName + "%"));
			}

			if (rankId != 0) {
				criteria = criteria.createAlias("Rank", "rank").add(
						Restrictions.eq("rank.Id", rankId));
			}

			//System.out.println("MQuery1:" + crit.toString());
			//System.out.println("MQuery2:" + criteria.toString());
			searchEmployeeList = crit.list();
			searchotherpersoList = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("searchEmployeeList", searchEmployeeList);
		map.put("searchotherpersoList", searchotherpersoList);
		return map;
	}

	public Map<String, Object> getMovementOutDetailsGrid(
			Map<String, Object> infoMap) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> searchEmployeeList = new ArrayList<MasEmployee>();
		List<MovementInOtherPerson> searchotherpersoList = new ArrayList<MovementInOtherPerson>();
		String serviceNo = "";
		int rankId = 0;
		String serPersonLName = "";
		String serPersonFName = "";

		Session session = (Session) getSession();
		Criteria crit = null;
		Criteria criteria = null;
		List<MasRank> rankList = new ArrayList<MasRank>();

		int deptId = 0;
		if (infoMap.get("deptId") != null)
			deptId = Integer.parseInt("" + infoMap.get("deptId"));

		if (infoMap.get("serPersonLName") != null) {
			serPersonLName = (String) infoMap.get("serPersonLName");
		}

		if (infoMap.get("serviceNo") != null) {
			serviceNo = (String) infoMap.get("serviceNo");
		}
		if (infoMap.get("rankId") != "0" && infoMap.get("rankId") != null) {
			rankId = Integer.parseInt("" + infoMap.get("rankId"));
		}

		if (infoMap.get("serPersonFName") != null) {
			serPersonFName = (String) infoMap.get("serPersonFName");
		}

		try {
			crit = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).add(
					Restrictions.eq("MovementOutStatus", "n"));

			if (!serviceNo.equals("")) {
				crit = crit
						.add(Restrictions.like("ServiceNo", serviceNo + "%"));
			}
			if (!serPersonFName.equals("")) {
				crit = crit.add(Restrictions.like("FirstName", serPersonFName
						+ "%"));
			}
			if (!serPersonLName.equals("")) {
				crit = crit.add(Restrictions.like("LastName", serPersonLName
						+ "%"));
			}

			if (rankId != 0) {
				crit = crit.createAlias("Rank", "rank").add(
						Restrictions.eq("rank.Id", rankId));
			}
			searchEmployeeList = crit.list();
			criteria = session.createCriteria(MovementInOtherPerson.class).add(
					Restrictions.eq("Status", "y")).add(
					Restrictions.eq("MovementOutStatus", "n"));

			if (!serviceNo.equals("")) {
				criteria = criteria.add(Restrictions.like("ServiceNo",
						serviceNo + "%"));
			}
			if (!serPersonFName.equals("")) {
				criteria = criteria.add(Restrictions.like("FirstName",
						serPersonFName + "%"));
			}
			if (!serPersonLName.equals("")) {
				criteria = criteria.add(Restrictions.like("LastName",
						serPersonLName + "%"));
			}

			if (rankId != 0) {
				criteria = criteria.createAlias("Rank", "rank").add(
						Restrictions.eq("rank.Id", rankId));
			}

			searchEmployeeList = crit.list();
			searchotherpersoList = criteria.list();
			rankList = session.createCriteria(MasRank.class).add(
					Restrictions.eq("Status", "y")).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("searchEmployeeList", searchEmployeeList);
		map.put("searchotherpersoList", searchotherpersoList);
		map.put("rankList", rankList);
		return map;
	}

	public Map<String, Object> getDetailsForSearchPostedOut(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		Session session = (Session) getSession();
		rankList = session.createCriteria(MasRank.class).add(
				Restrictions.eq("Status", "y")).list();
		if (rankList.size() > 0) {
			map.put("rankList", rankList);
		}

		return map;
	}

	public Map<String, Object> getPostedOutDetailsGrid(
			Map<String, Object> infoMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> searchEmployeeList = new ArrayList<MasEmployee>();
		String serviceNo = "";
		int rankId = 0;
		String serPersonLName = "";
		String serPersonFName = "";

		Session session = (Session) getSession();
		Criteria crit = null;

		int deptId = 0;
		if (infoMap.get("deptId") != null)
			deptId = Integer.parseInt("" + infoMap.get("deptId"));

		if (infoMap.get("serPersonLName") != null) {
			serPersonLName = (String) infoMap.get("serPersonLName");
		}

		if (infoMap.get("serviceNo") != null) {
			serviceNo = (String) infoMap.get("serviceNo");
		}
		if (infoMap.get("rankId") != "0" && infoMap.get("rankId") != null) {
			rankId = Integer.parseInt("" + infoMap.get("rankId"));
		}

		if (infoMap.get("serPersonFName") != null) {
			serPersonFName = (String) infoMap.get("serPersonFName");
		}
		//System.out.println("fristNmae::::::data" + serPersonFName+ "Last name ::::::::::date" + serPersonLName);
		try {
			crit = session.createCriteria(MasEmployee.class).add(
					Restrictions.ne("Status", "n"));

			if (!serviceNo.equals("")) {
				crit = crit
						.add(Restrictions.like("ServiceNo", serviceNo + "%"));
			}
			if (!serPersonFName.equals("")) {
				crit = crit.add(Restrictions.like("FirstName", serPersonFName
						+ "%"));
			}
			if (!serPersonLName.equals("")) {
				crit = crit.add(Restrictions.like("LastName", serPersonLName
						+ "%"));
			}

			if (rankId != 0) {
				crit = crit.createAlias("Rank", "rank").add(
						Restrictions.eq("rank.Id", rankId));
			}

			searchEmployeeList = crit.list();

			//System.out.println("search list " + searchEmployeeList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("searchEmployeeList", searchEmployeeList);
		return map;
	}

	public Map<String, Object> showPostedOutJsp(int Id) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infomap = new HashMap<String, Object>();
		String entryNo = "";
		Session session = getSession();
		List<HrLeaveTypeMaster> leaveTypeList = null;
		List<MasUnit> unitList = null;
		List<MasEmployee> employeeList = null;
		List<PostedOutEntry> postedoutentryList = null;
		employeeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasEmployee where Id ='" + Id
						+ "'");
		postedoutentryList = session.createCriteria(PostedOutEntry.class).add(
				Restrictions.eq("Status", "n")).createAlias("Employee", "emp")
				.add(Restrictions.eq("emp.Id", Id)).list();
		leaveTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.HrLeaveTypeMaster");
		unitList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasUnit");
		//System.out.println("postedoutentryList:::" + postedoutentryList.size());
		if (postedoutentryList == null || postedoutentryList.size() == 0) {
			entryNo = generatePostedOutEntryNo(infomap);
			map.put("entryNo", entryNo);
		}
		map.put("leaveTypeList", leaveTypeList);
		map.put("unitList", unitList);
		map.put("postedoutentryList", postedoutentryList);
		map.put("employeeList", employeeList);
		map.put("Id", Id);
		return map;
	}

	public Map<String, Object> addPostedOutEntry(PostedOutEntry postedOutEntry) {
		boolean successfullyAdded = false;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Criteria ctr = null;
		MasEmployee masemployee = new MasEmployee();
		List<HrorderlyLeaveAccount> hrorderlyleaveaccountList = new ArrayList<HrorderlyLeaveAccount>();
		List<HrorderlyLeavechoice> hrorderlyleavechoiceList = new ArrayList<HrorderlyLeavechoice>();
		PostedOutEntry postedoutentry = null;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		//System.out.println("postedid:::" + postedOutEntry.getId()	+ "remarks:::" + postedOutEntry.getRemarks() + "authority::"+ postedOutEntry.getAuthority());
		try {
			if (postedOutEntry.getId() != null) {
				//System.out.println("::postedid:::" + postedOutEntry.getId()+ "::remarks:::" + postedOutEntry.getRemarks()	+ "::authority::" + postedOutEntry.getAuthority());
				hbt.update(postedOutEntry);
				hbt.refresh(postedOutEntry);
			} else {
				hbt.saveOrUpdate(postedOutEntry);
				hbt.refresh(postedOutEntry);
			}
			if (postedOutEntry.getStatus().equals("y")) {
				masemployee = (MasEmployee) getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasEmployee where Id ='"
								+ postedOutEntry.getEmployee().getId() + "' ")
						.get(0);
				masemployee.setStatus("n");
				masemployee.setPostedOut(postedOutEntry);
				hrorderlyleaveaccountList = session.createCriteria(
						HrorderlyLeaveAccount.class).add(
						Restrictions.eq("EmployeeId", postedOutEntry
								.getEmployee().getId())).list();
				if (hrorderlyleaveaccountList != null
						&& hrorderlyleaveaccountList.size() > 0) {
					for (HrorderlyLeaveAccount hrorderlyleaveaccount : hrorderlyleaveaccountList) {
						hrorderlyleaveaccount.setStatus("n");
						hbt.saveOrUpdate(hrorderlyleaveaccount);
					}
				}
				hrorderlyleavechoiceList = session.createCriteria(
						HrorderlyLeavechoice.class).createAlias("EmployeeId",
						"emp").add(
						Restrictions.eq("emp.Id", postedOutEntry.getEmployee()
								.getId())).list();
				if (hrorderlyleavechoiceList != null
						&& hrorderlyleavechoiceList.size() > 0) {
					for (HrorderlyLeavechoice hrorderlyleavechoice : hrorderlyleavechoiceList) {
						hrorderlyleavechoice.setStatus("n");
						hbt.saveOrUpdate(hrorderlyleavechoice);
					}
				}
				hbt.saveOrUpdate(masemployee);
				hbt.refresh(masemployee);
			}

			
		} catch (Exception exc) {
			//System.out.println("exception::" + exc.toString());
		}
		dataMap.put("postedOutEntry", postedOutEntry);
		successfullyAdded = true;
		dataMap.put("successfullyAdded", successfullyAdded);
		return dataMap;
	}

	public String generatePostedOutEntryNo(Map<String, Object> infoMap) {
		// TODO Auto-generated method stub
		List<TransactionSequence> postedOutList = new ArrayList<TransactionSequence>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		Session session = (Session) getSession();
		String entryNo = "";
		String date = "";
		date = (String) utilMap.get("currentDate");

		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		String[] currentDate = date.split("/");
		String currentMonth = currentDate[1];
		postedOutList = session.createCriteria(TransactionSequence.class).add(
				Restrictions.eq("TransactionPrefix", "POL")).list();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (postedOutList.size() > 0) {
			for (TransactionSequence transactionSequence : postedOutList) {
				TransactionSequence obj = transactionSequence;
				int id = obj.getId();
				int seqNo = obj.getTransactionSequenceNumber();

				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
						.load(TransactionSequence.class, id);
				transactionSequenceObj.setTransactionSequenceNumber(++seqNo);
				if (currentMonth.equalsIgnoreCase("01")) {
					transactionSequenceObj.setTransactionSequenceNumber(1);
					seqNo = 1;
				}
				hbt.update(transactionSequenceObj);
				entryNo = entryNo.concat(String.valueOf(seqNo));
				entryNo = entryNo.concat("/").concat(currentMonth);
				entryNo = entryNo.concat("/").concat(currentYear);
			}
		} else if (postedOutList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("PostedOutEntry");
			tsObj.setTransactionPrefix("POL");
			tsObj.setTransactionSequenceName("Posted Out Entry");
			tsObj.setTransactionSequenceNumber(0);
			hbt.save(tsObj);
		}
		return entryNo;
	}

	public Map<String, Object> showMovementOutJsp(int Id, String employeecode) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MovementInOtherPerson> movementinotherperson = new ArrayList<MovementInOtherPerson>();
		unitList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasUnit");
		if (employeecode.contains("E")) {
			employeeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasEmployee where Id ='"
							+ Id + "' ");
		} else if (employeecode.contains("P")) {
			movementinotherperson = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MovementInOtherPerson where Id ='"
							+ Id + "' ");
		}
		map.put("employeeList", employeeList);
		map.put("movementinotherperson", movementinotherperson);
		map.put("unitList", unitList);
		map.put("Id", Id);
		map.put("employeecode", employeecode);
		return map;
	}

	public Map<String, Object> pendingListForHro() {
		Map<String, Object> infoMap = new HashMap<String, Object>();
		List<ProposalForHroEntry> pendingList = new ArrayList<ProposalForHroEntry>();
		pendingList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.ProposalForHroEntry as ph where ph.Status = 'y' and ph.Dispatch='p' ");
		infoMap.put("pendingList", pendingList);
		return infoMap;
	}

	public boolean addMovementOutEntry(MovementOutEntry movementOutEntry,
			Map<String, Object> generalMap) {

		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		int employeeId = (Integer) generalMap.get("id");
		String employeecode = (String) generalMap.get("employeecode");
		if (employeecode.contains("E")) {
			MasEmployee masEmployee = (MasEmployee) getHibernateTemplate()
					.load(MasEmployee.class, employeeId);
			masEmployee.setMovementInStatus("n");
			masEmployee.setMovementOutStatus("y");
			hbt.saveOrUpdate(masEmployee);
			hbt.refresh(masEmployee);
		} else if (employeecode.contains("P")) {
			MovementInOtherPerson movementinotherperson = (MovementInOtherPerson) getHibernateTemplate()
					.load(MovementInOtherPerson.class, employeeId);
			movementinotherperson.setMovementInStatus("n");
			movementinotherperson.setMovementOutStatus("y");
			hbt.saveOrUpdate(movementinotherperson);
			hbt.refresh(movementinotherperson);
		}

		hbt.save(movementOutEntry);
		hbt.refresh(movementOutEntry);

		successfullyAdded = true;
		return successfullyAdded;

	}

	public Map<String, Object> showMovementInJsp(int Id, String employeecode) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = null;
		List<MovementInOtherPerson> personList = null;
		if (employeecode.contains("E")) {
			//System.out.println("employeecode::e:" + employeecode);
			employeeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasEmployee where Id ='"
							+ Id + "'");
		} else if (employeecode.contains("P")) {
			//System.out.println("employeecode::p:" + employeecode);
			personList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MovementInOtherPerson where Id ='"
							+ Id + "'");

		}
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		unitList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasUnit");
		map.put("employeeList", employeeList);
		map.put("personList", personList);
		map.put("unitList", unitList);
		map.put("employeecode", employeecode);
		map.put("Id", Id);
		return map;
	}

	public Map<String, Object> searchOtherPersonUpdate(Box box) {

		List<MovementInOtherPerson> searchOtherPersonList = new ArrayList<MovementInOtherPerson>();
		Map<String, Object> employeeFieldsMap = new HashMap<String, Object>();
		List<MasTitle> titleList = new ArrayList<MasTitle>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
		List<MasEmpStatus> empStatusList = new ArrayList<MasEmpStatus>();
		List<MasEmpCategory> empCategoryList = new ArrayList<MasEmpCategory>();
		List<MasGrade> gradeList = new ArrayList<MasGrade>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasTrade> tradeList = new ArrayList<MasTrade>();
		List gridUnitList = null;
		Session session = (Session) getSession();
		String serPersonFName = "";
		String serPersonLName = "";
		String serviceNo = "";
		int rankId = 0;
		if (box.getString(SERVICE_NO) != null
				&& !box.getString(SERVICE_NO).equals("")) {
			serviceNo = (String) box.getString(SERVICE_NO);
		}
		if (box.getString(S_FIRST_NAME) != null
				&& !box.getString(S_FIRST_NAME).equals("")) {
			serPersonFName = (String) box.getString(S_FIRST_NAME);
		}
		if (box.getString(S_LAST_NAME) != null
				&& !box.getString(S_LAST_NAME).equals("")) {
			serPersonLName = (String) box.getString(S_LAST_NAME);
		}
		if (box.getString(RANK_ID) != null
				&& !box.getString(RANK_ID).equals("0")) {
			rankId = box.getInt(RANK_ID);
		}
		try {
			Criteria ctr = session.createCriteria(MovementInOtherPerson.class)
					.add(Restrictions.eq("Status", "y"));
			if (serviceNo != "")
				ctr.add(Restrictions.like("ServiceNo", serviceNo + "%"));
			if (serPersonFName != "")
				ctr.add(Restrictions.like("FirstName", serPersonFName + "%"));
			if (serPersonLName != "")
				ctr.add(Restrictions.like("LastName", serPersonLName + "%"));
			if (rankId != 0)
				ctr.createAlias("Rank", "r").add(
						Restrictions.like("r.Id", rankId + "%"));
			searchOtherPersonList = ctr.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		// gridUnitList = getHibernateTemplate().find("from
		// jkt.hms.masters.business.MasUnit as isc");
		titleList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasTitle as mt where mt.Status = 'y'");
		departmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment as md where md.Status = 'y'");
		// costCenterList = getHibernateTemplate().find(
		// "from jkt.hms.masters.business.MasCostCenter as md where md.Status =
		// 'y' ");
		empStatusList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasEmpStatus as md where md.Status = 'y'");
		empCategoryList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasEmpCategory as md where md.Status = 'y'");
		// gradeList = getHibernateTemplate().find("from
		// jkt.hms.masters.business.MasGrade as mg where mg.Status = 'y'");
		rankList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasRank as mg where mg.Status = 'y'");
		unitList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasUnit as mg where mg.Status = 'y'");
		tradeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasTrade as mg where mg.Status = 'y'");

		// employeeFieldsMap.put("gridUnitList", gridUnitList);
		employeeFieldsMap.put("searchOtherPersonList", searchOtherPersonList);
		employeeFieldsMap.put("titleList", titleList);
		employeeFieldsMap.put("departmentList", departmentList);
		// employeeFieldsMap.put("costCenterList", costCenterList);
		employeeFieldsMap.put("empStatusList", empStatusList);
		employeeFieldsMap.put("empCategoryList", empCategoryList);
		// employeeFieldsMap.put("gradeList", gradeList);
		employeeFieldsMap.put("rankList", rankList);
		employeeFieldsMap.put("unitList", unitList);
		employeeFieldsMap.put("tradeList", tradeList);
		return employeeFieldsMap;
	}

	public Map<String, Object> getDetailsForSearchForMovementIn(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		Session session = (Session) getSession();
		rankList = session.createCriteria(MasRank.class).add(
				Restrictions.eq("Status", "y")).list();
		if (rankList.size() > 0) {
			map.put("rankList", rankList);
		}

		return map;
	}

	public boolean addMovementInEntry(MovementInEntry movementInEntry,
			Map<String, Object> generalMap) {

		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		int employeeId = (Integer) generalMap.get("id");
		String employeecode = (String) generalMap.get("employeecode");
		if (employeecode.contains("E")) {
			MasEmployee masEmployee = (MasEmployee) getHibernateTemplate()
					.load(MasEmployee.class, employeeId);
			masEmployee.setMovementInStatus("y");
			masEmployee.setMovementOutStatus("n");
			hbt.saveOrUpdate(masEmployee);
			hbt.refresh(masEmployee);
		} else if (employeecode.contains("P")) {
			MovementInOtherPerson otherperson = (MovementInOtherPerson) getHibernateTemplate()
					.load(MovementInOtherPerson.class, employeeId);
			otherperson.setMovementInStatus("y");
			otherperson.setMovementOutStatus("n");
			hbt.saveOrUpdate(otherperson);
			hbt.refresh(otherperson);
		}

		hbt.save(movementInEntry);
		hbt.refresh(movementInEntry);

		successfullyAdded = true;
		return successfullyAdded;

	}

	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		map.put("conn", con);
		return map;

	}

	public Map<String, Object> getEmployeeId(Map<String, Object> dataMap) {
		List<HrorderlyLeaveApplication> leaveApplicationList = new ArrayList<HrorderlyLeaveApplication>();
		return dataMap;

	}

	public Map<String, Object> searchProposalForHRO(String entryNo,
			Date proposalDate) {
		List<ProposalForHroEntry> searchProposalList = new ArrayList<ProposalForHroEntry>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			if (entryNo != null && proposalDate == null) {
				searchProposalList = hbt
						.find("from jkt.hms.masters.business.ProposalForHroEntry imc where imc.EntryNo like '"
								+ entryNo + "%'");
				//System.out.println("entryNooooooooo" + entryNo + "     "+ searchProposalList.size());

			} else if (proposalDate != null && entryNo == null) {
				searchProposalList = hbt
						.find("from jkt.hms.masters.business.ProposalForHroEntry imc where imc.PropsalDate ='"
								+ HMSUtil.getDateFormat(proposalDate,
										"yyyy-MM-dd") + "'");
				//System.out.println("datepro" + proposalDate);
			} else if (entryNo != null && proposalDate != null) {
				searchProposalList = hbt
						.find("from jkt.hms.masters.business.ProposalForHroEntry imc where imc.EntryNo ='"
								+ entryNo
								+ "' and imc.PropsalDate ='"
								+ HMSUtil.getDateFormat(proposalDate,
										"yyyy-MM-dd") + "'");
			}

		} catch (Exception e) {
			//System.out.println("Ds excp in leaveRestrictionEntryList  " + e);
		}
		infoMap.put("searchProposalList", searchProposalList);
		return infoMap;
	}

	public Map<String, Object> showLeaveApplicationPendingJsp() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrorderlyLeaveApplication> searchMasLeaveApplicationList = new ArrayList<HrorderlyLeaveApplication>();
		List<MasEmployee> searchMasEmployeeList = new ArrayList<MasEmployee>();
		List<EmpLeaveBalance> empLeaveBalanceList = new ArrayList<EmpLeaveBalance>();
		searchMasLeaveApplicationList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.HrorderlyLeaveApplication as ap where ap.Status = 'y' and (ap.ApprovedStatus ='w' or ap.ApprovedStatus is null)and ap.RecommendedStatus='y') order by ap.LeaveFromDate  ");
		searchMasEmployeeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasEmployee me where me.Status='y'");

		map.put("searchMasEmployeeList", searchMasEmployeeList);
		map.put("searchMasLeaveApplicationList", searchMasLeaveApplicationList);
		return map;
	}

	public Map<String, Object> showSearchLeaveApplicationJsp() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrorderlyLeaveApplication> masLeaveApplicationList = new ArrayList<HrorderlyLeaveApplication>();
		List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
		List<EmpLeaveBalance> empLeaveBalanceList = new ArrayList<EmpLeaveBalance>();
		masLeaveApplicationList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.HrorderlyLeaveApplication hla where hla.ApprovedStatus='w' or hla.ApprovedStatus is null");
		// masEmployeeList = getHibernateTemplate().find("from
		// jkt.hms.masters.business.MasEmployee");
		empLeaveBalanceList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.EmpLeaveBalance");
		//System.out.println("masEmployeeList in dsc" + masEmployeeList.size());
		//System.out.println("masLeaveApplicationList--"+ masLeaveApplicationList.size());
		map.put("masEmployeeList", masEmployeeList);
		map.put("masLeaveApplicationList", masLeaveApplicationList);
		map.put("empLeaveBalanceList", empLeaveBalanceList);

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchleaveApplication(String entryNo,
			String serviceNo) {
		//System.out.println("e........." + entryNo + "s........" + serviceNo);
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrorderlyLeaveApplication> masLeaveApplicationList = new ArrayList<HrorderlyLeaveApplication>();
		List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
		masEmployeeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasEmployee");
		Map<String, Object> infoMap = new HashMap<String, Object>();
		infoMap.put("masEmployeeList", masEmployeeList);
		try {
			Criteria c1 = session.createCriteria(
					HrorderlyLeaveApplication.class).add(
					Restrictions.eq("ApprovedStatus", "w"));
			if (entryNo != null && serviceNo == null) {
				c1.add(Restrictions.like("EntryNo", entryNo + "%"));

				//System.out.println("list in entry  "+ masLeaveApplicationList.size());
			} else if (entryNo == null && serviceNo != null) {
				c1.createAlias("Employee", "emp").add(
						Restrictions.like("emp.ServiceNo", serviceNo + "%"));

				//System.out.println("list in dsimpl  " + c1.list().size());

			} else if (entryNo != null && serviceNo != null) {
				c1.createAlias("Employee", "emp").add(
						Restrictions.and(Restrictions.like("EntryNo", entryNo
								+ "%"), Restrictions.like("emp.ServiceNo",
								serviceNo + "%")));

				//System.out.println("list in dsimpl  " + c1.list().size());
			}
			masLeaveApplicationList = c1.list();
		} catch (Exception e) {
			//System.out.println("Ds excp in masLeaveApplicationList  " + e);
		}
		infoMap.put("masLeaveApplicationList", masLeaveApplicationList);
		return infoMap;
	}

	public Map<String, Object> showLeaveApplicationUpdateJsp(int Id) {

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
		List<MasState> stateList = new ArrayList<MasState>();
		List<MasDistrict> cityList = new ArrayList<MasDistrict>();
		List<LeaveRestrictionEntry> leaveRestrictionEntryList = new ArrayList<LeaveRestrictionEntry>();
		List<EmpLeaveBalance> empLeaveBalanceList = new ArrayList<EmpLeaveBalance>();
		List<HrLeaveTypeMaster> leaveTypeList = new ArrayList<HrLeaveTypeMaster>();
		List<HrorderlyLeaveApplication> leaveApplicationList = new ArrayList<HrorderlyLeaveApplication>();
		List<FamilyDetails> familyDetailsList = new ArrayList<FamilyDetails>();
		List<HrorderlyLeaveAccount> hrorderlyleaveaccountList = new ArrayList<HrorderlyLeaveAccount>();
		cityList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDistrict");
		stateList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasState");
		leaveTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.HrLeaveTypeMaster");
		leaveRestrictionEntryList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.LeaveRestrictionEntry where ToPeriod > current_date()");
		empLeaveBalanceList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.EmpLeaveBalance");
		leaveApplicationList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.HrorderlyLeaveApplication as mla where mla.Id ='"
								+ Id + "'");
		familyDetailsList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.FamilyDetails mc where mc.LeaveApplication ='"
						+ Id + "'");
		MasEmployee masemployeeId = leaveApplicationList.get(0).getEmployee();
		masEmployeeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasEmployee as me where me.Id='"
						+ masemployeeId.getId() + "'");
		try {
			hrorderlyleaveaccountList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.HrorderlyLeaveAccount as hla where EmployeeId='"
							+ masemployeeId.getId() + "'");
		} catch (Exception exc) {
			//System.out.println("addleave  " + exc);
		}
		//System.out.println("size of familyDetailsList"+ familyDetailsList.size());
		map.put("leaveRestrictionEntryList", leaveRestrictionEntryList);
		map.put("empLeaveBalanceList", empLeaveBalanceList);
		map.put("cityList", cityList);
		map.put("stateList", stateList);
		map.put("leaveTypeList", leaveTypeList);
		map.put("hrorderlyleaveaccountList", hrorderlyleaveaccountList);
		map.put("masEmployeeList", masEmployeeList);
		map.put("leaveApplicationList", leaveApplicationList);
		map.put("familyDetailsList", familyDetailsList);
		return map;

	}

	public boolean editLeaveApplicationUpdateToDatabase(
			Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Session sess = (Session) getSession();
		// int leaveApplicationId = 0;
		List<FamilyDetails> familydetailsList = new ArrayList<FamilyDetails>();
		String entryDate = "";
		int leaveType = 0;
		String fromDate = "";
		String toDate = "";
		String totalDays = "";
		String aLeaveFromDate = "";
		String aLeaveToDate = "";
		String aLeaveTotalDays = "";
		String type = "";
		int requiredFrom = 0;
		int cityTo = 0;
		int rajdhaniUpto = 0;
		String availingLtc = "";
		String otherTrainUpto = "";
		String drawingTransportAllowance = "";
		int ltcYear = 0;
		int previousYearLtcDetails = 0;
		String underTr = "";
		String class1 = "";
		String ticketForside = "";
		String returnJourneyValidUpto = "";
		String fullName = "";
		String houseName = "";
		String village = "";
		String po = "";
		String telegraphOffice = "";
		int districtName = 0;
		int state = 0;
		String pin = "";
		String telNo = "";
		String leaveAvailed = "";
		String daysOfCl = "";
		String setOfCvs = "";
		String nrs = "";
		String lastChangedBy = "";
		String lastChangedDate = "";
		String lastChangedTime = "";
		Date currentDate = new Date();
		String currentTime = "";

		String selectFamily = "";
		String dob = "";
		String age = "";
		String dependentPorNo = "";

		int Id = 0;
		Id = (Integer) generalMap.get("Id");
		//System.out.println("Id in ctrl== " + Id);

		// leaveApplicationId = (Integer) generalMap.get("Id");
		entryDate = (String) generalMap.get("entryDate");
		leaveType = (Integer) generalMap.get("leaveType");
		fromDate = (String) generalMap.get("fromDate");
		toDate = (String) generalMap.get("toDate");
		totalDays = (String) generalMap.get("totalDays");
		aLeaveFromDate = (String) generalMap.get("aLeaveFromDate");
		aLeaveToDate = (String) generalMap.get("aLeaveToDate");
		aLeaveTotalDays = (String) generalMap.get("aLeaveTotalDays");
		type = (String) generalMap.get("type");
		requiredFrom = (Integer) generalMap.get("requiredFrom");
		cityTo = (Integer) generalMap.get("cityTo");
		rajdhaniUpto = (Integer) generalMap.get("rajdhaniUpto");
		availingLtc = (String) generalMap.get("availingLtc");
		otherTrainUpto = (String) generalMap.get("otherTrainUpto");
		drawingTransportAllowance = (String) generalMap
				.get("drawingTransportAllowance");
		ltcYear = (Integer) generalMap.get("ltcYear");
		previousYearLtcDetails = (Integer) generalMap
				.get("previousYearLtcDetails");
		underTr = (String) generalMap.get("underTr");
		class1 = (String) generalMap.get("class1");
		ticketForside = (String) generalMap.get("ticketForside");
		returnJourneyValidUpto = (String) generalMap
				.get("returnJourneyValidUpto");
		fullName = (String) generalMap.get("fullName");
		houseName = (String) generalMap.get("houseName");
		village = (String) generalMap.get("village");
		po = (String) generalMap.get("po");
		telegraphOffice = (String) generalMap.get("telegraphOffice");
		districtName = (Integer) generalMap.get("districtName");
		state = (Integer) generalMap.get("state");
		pin = (String) generalMap.get("pin");
		telNo = (String) generalMap.get("telNo");
		setOfCvs = (String) generalMap.get("setOfCvs");
		nrs = (String) generalMap.get("nrs");
		lastChangedBy = (String) generalMap.get("lastChangedBy");
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		lastChangedDate = (String) generalMap.get("lastChangedDate");
		lastChangedTime = (String) generalMap.get("lastChangedTime");
		familydetailsList = (List) generalMap.get("familyDetailsList");

		HrorderlyLeaveApplication masLeaveApplicationUpdate = (HrorderlyLeaveApplication) getHibernateTemplate()
				.load(HrorderlyLeaveApplication.class, Id);

		masLeaveApplicationUpdate.setId(Id);

		masLeaveApplicationUpdate.setEntryDate(HMSUtil
				.convertStringTypeDateToDateType(entryDate));
		masLeaveApplicationUpdate.setLeaveFromDate(HMSUtil
				.convertStringTypeDateToDateType(fromDate));
		masLeaveApplicationUpdate.setDateOfReporting(HMSUtil
				.convertStringTypeDateToDateType(toDate));
		masLeaveApplicationUpdate.setAddlLeaveFromDate(HMSUtil
				.convertStringTypeDateToDateType(aLeaveFromDate));
		masLeaveApplicationUpdate.setAddlLeaveToDate(HMSUtil
				.convertStringTypeDateToDateType(aLeaveToDate));

		if (leaveType != 0) {
			HrLeaveTypeMaster hrleavetypemaster = new HrLeaveTypeMaster();
			hrleavetypemaster.setId(leaveType);
			masLeaveApplicationUpdate.setLeave(hrleavetypemaster);
		}

		masLeaveApplicationUpdate.setLeaveTotalDays(totalDays);
		masLeaveApplicationUpdate.setAddlLeaveTotalDays(aLeaveTotalDays);

		if (requiredFrom != 0) {
			MasDistrict masDistrict = new MasDistrict();
			masDistrict.setId(requiredFrom);
			masLeaveApplicationUpdate.setRequiredFrom(masDistrict);
		}

		if (cityTo != 0) {
			MasDistrict masDistrict = new MasDistrict();
			masDistrict.setId(cityTo);
			masLeaveApplicationUpdate.setCityTo(masDistrict);
		}

		if (rajdhaniUpto != 0) {
			MasDistrict masDistrict = new MasDistrict();
			masDistrict.setId(rajdhaniUpto);
			masLeaveApplicationUpdate.setRajdhaniUpto(masDistrict);
		}

		// masLeaveApplicationUpdate.setRequiredFrom(new
		// MasDistrict(Integer.parseInt(requiredFrom)));
		// masLeaveApplicationUpdate.setCityTo(new
		// MasDistrict(Integer.parseInt(cityTo)));
		// masLeaveApplicationUpdate.setRajdhaniUpto(new
		// MasDistrict(Integer.parseInt(rajdhaniUpto)));

		masLeaveApplicationUpdate.setAvailingLtc(availingLtc);
		masLeaveApplicationUpdate.setOtherTrainsUpto(otherTrainUpto);
		masLeaveApplicationUpdate
				.setDrawingTransportAllowance(drawingTransportAllowance);
		masLeaveApplicationUpdate.setYear(ltcYear);
		masLeaveApplicationUpdate.setPreviousYear(previousYearLtcDetails);
		masLeaveApplicationUpdate.setUnderTr(underTr);

		masLeaveApplicationUpdate.setTicketForSide(ticketForside);
		masLeaveApplicationUpdate
				.setReturnJourneyValidUpto(returnJourneyValidUpto);
		masLeaveApplicationUpdate.setFullName(fullName);
		masLeaveApplicationUpdate.setHouseName(houseName);
		masLeaveApplicationUpdate.setVillage(village);
		masLeaveApplicationUpdate.setPo(po);
		masLeaveApplicationUpdate.setTelegraphOffice(telegraphOffice);

		if (districtName != 0) {
			MasDistrict masDistrict = new MasDistrict();
			masDistrict.setId(districtName);
			masLeaveApplicationUpdate.setDistrictName(masDistrict);
		}

		if (state != 0) {
			MasState masState = new MasState();
			masState.setId(state);
			masLeaveApplicationUpdate.setState(masState);
		}

		masLeaveApplicationUpdate.setPin(pin);
		masLeaveApplicationUpdate.setTelephoneNo(telNo);
		masLeaveApplicationUpdate.setSetOfCv(setOfCvs);
		masLeaveApplicationUpdate.setNrs(nrs);
		masLeaveApplicationUpdate.setTrainClass(class1);

		masLeaveApplicationUpdate.setLstChangedBy(lastChangedBy);
		masLeaveApplicationUpdate.setLstChangedDate(currentDate);
		masLeaveApplicationUpdate.setLstChangedTime(currentTime);

		Session session = getSession();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");

		hbt.setCheckWriteOperations(false);
		hbt.update(masLeaveApplicationUpdate);
		hbt.flush();
		dataUpdated = true;

		String hsql = "delete from jkt.hms.masters.business.FamilyDetails as hla where hla.LeaveApplication="
				+ Id;
		try {
			Query query = session.createQuery(hsql);
			int row = query.executeUpdate();
			//System.out.println("deted row::" + row);
		} catch (Exception exc) {

		}

		// getting the second updated entity
		List<LeaveApplicationDTO> fDList = (List<LeaveApplicationDTO>) generalMap
				.get("leaveApplicationDTOList");
		//System.out.println("F D List.size" + fDList.size());
		//System.out.println("F D List.size" + fDList);

		// getting entity from the table
		List<FamilyDetails> fDListFromDatabase = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.FamilyDetails as mc where mc.LeaveApplication ='"
								+ Id + "'");
		//System.out.println("mbiListFromDatabase.size---"+ fDListFromDatabase.size());
		//System.out.println("Id in dsimpl--" + Id);

		org.springframework.orm.hibernate3.HibernateTemplate hbt2 = getHibernateTemplate();
		hbt2.setFlushModeName("FLUSH_EAGER");
		hbt2.setCheckWriteOperations(false);
		org.hibernate.Transaction tx = null;

		for (FamilyDetails familydetail : familydetailsList) {
			hbt2.save(familydetail);
			hbt2.flush();
		}
		/*
		 * if (fDListFromDatabase != null && fDList.size() > 0) {
		 * 
		 * int counter; for (FamilyDetails familyDetails : fDListFromDatabase) {
		 * counter = 1; if (fDListFromDatabase != null &&
		 * fDListFromDatabase.size() > 0) { for (LeaveApplicationDTO leaveAppDTO :
		 * fDList) { if (!leaveAppDTO.getId().equals("") &&
		 * familyDetails.getId() == Integer.parseInt(leaveAppDTO.getId())) { try {
		 * 
		 * FamilyDetails familyDetailsUpdate = (FamilyDetails)
		 * getHibernateTemplate().get( FamilyDetails.class,
		 * familyDetails.getId());
		 * familyDetailsUpdate.setAge(Integer.parseInt(leaveAppDTO.getAge()));
		 * familyDetailsUpdate.setDependentPorNo(leaveAppDTO.getDependentPorNo());
		 * if (leaveAppDTO.getDob() != null &&
		 * !(leaveAppDTO.getDob().equals(""))) {
		 * familyDetailsUpdate.setDob(HMSUtil.convertStringTypeDateToDateType(leaveAppDTO.getDob())); }
		 * familyDetailsUpdate.setSelectFamily(leaveAppDTO.getSelectFamily());
		 * 
		 * hbt.update(familyDetailsUpdate); leaveAppDTO.setId("0"); counter++;
		 * break;
		 *  } catch (Exception e) { e.printStackTrace(); } } else if
		 * (leaveAppDTO.getId().equals("0") && fDList.size() > counter) {
		 * counter++; continue; } else if (!leaveAppDTO.getId().equals("")) {
		 * try { FamilyDetails familyDetailUpdate = (FamilyDetails)
		 * getHibernateTemplate().get( FamilyDetails.class,
		 * familyDetails.getId());
		 * 
		 * hbt2.delete(familyDetailUpdate); break; } catch (Exception e) {
		 * e.printStackTrace(); } break; } } } for (LeaveApplicationDTO
		 * leaveApplicationUpdate : fDList) {
		 * 
		 * if (leaveApplicationUpdate.getId() != null &&
		 * leaveApplicationUpdate.getId().equals("")) {
		 * 
		 * hbt2.setCheckWriteOperations(false); HrorderlyLeaveApplication
		 * masLeave = new HrorderlyLeaveApplication(); FamilyDetails
		 * familyDetailUpdate = new FamilyDetails();
		 * 
		 * familyDetailUpdate.setSelectFamily(leaveApplicationUpdate.getSelectFamily());
		 * familyDetailUpdate.setAge(Integer.parseInt(leaveApplicationUpdate.getAge()));
		 * familyDetailUpdate.setDob(HMSUtil.convertStringTypeDateToDateType(leaveApplicationUpdate.getDob()));
		 * familyDetailUpdate.setDependentPorNo(leaveApplicationUpdate.getDependentPorNo());
		 * 
		 * masLeave.setId(Id); familyDetailUpdate.setLeaveApplication(Id);
		 * hbt.saveOrUpdate(familyDetailUpdate); } }
		 * 
		 * dataUpdated = true; } }
		 */
		return dataUpdated;

	}

	public boolean addleaveAppPending(EmpLeaveBalance empLeaveBalance,
			Map<String, Object> generalMap) {

		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		int id = (Integer) generalMap.get("leaveId");
		//System.out.println("iddddddddddd" + id);
		HrorderlyLeaveApplication hrorderlyLeaveApplication = (HrorderlyLeaveApplication) getHibernateTemplate()
				.load(HrorderlyLeaveApplication.class, id);

		hrorderlyLeaveApplication.setStatus("y");
		//System.out.println("status" + hrorderlyLeaveApplication.getStatus());
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(empLeaveBalance);
		hbt.saveOrUpdate(hrorderlyLeaveApplication);
		successfullyAdded = true;
		return successfullyAdded;

	}

	public Map<String, Object> showUpdateProposalJsp(int proposalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<ProposalForHroEntry> proposalList = new ArrayList<ProposalForHroEntry>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		proposalList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.ProposalForHroEntry where Id ='"
						+ proposalId + "' ");
		employeeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasEmployee");
		//System.out.println("proposalid " + proposalId + "      "+ proposalList.size() + "       " + employeeList.size());
		map.put("proposalList", proposalList);
		map.put("proposalId", proposalId);
		map.put("employeeList", employeeList);
		return map;
	}

	public Map<String, Object> showProposalHroSearchJsp() {
		List<ProposalForHroEntry> proposalList = new ArrayList<ProposalForHroEntry>();
		Map<String, Object> infoMap = new HashMap<String, Object>();

		Session session = (Session) getSession();
		proposalList = session.createCriteria(ProposalForHroEntry.class).add(
				Restrictions.eq("Status", "y")).list();
		infoMap.put("proposalList", proposalList);
		return infoMap;
	}

	public Map<String, Object> getPostedOutSearchGrid(
			Map<String, Object> infoMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PostedOutEntry> postedOutList = new ArrayList<PostedOutEntry>();
		String entryNo = "";

		Session session = (Session) getSession();
		Criteria crit = null;

		int deptId = 0;
		if (infoMap.get("deptId") != null)
			deptId = Integer.parseInt("" + infoMap.get("deptId"));

		if (infoMap.get("entryNo") != null) {
			entryNo = (String) infoMap.get("entryNo");
		}

		try {
			crit = session.createCriteria(PostedOutEntry.class);

			if (!entryNo.equals("")) {
				crit = crit.add(Restrictions.like("EntryNo", entryNo + "%"));
			}

			postedOutList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("postedOutList", postedOutList);
		return map;
	}

	// // GUARD DUTY

	public Map<String, Object> getGridDataForGuardEmployeeSearch(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = (Map<String, Object>) HMSUtil
				.getCurrentDateAndTime();
		session = (Session) getSession();

		int id = 0;

		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;

		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasEmployee> employeeDetailList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<HrDutyTimeMaster> dutyTimeMasterList = new ArrayList<HrDutyTimeMaster>();
		String serviceNo = "";
		String empName = "";

		if (!box.getString("searchServiceNo").equals("")) {
			serviceNo = box.getString("searchServiceNo");
		}
		if (!box.getString("searchName").equals("")) {
			empName = box.getString("searchName");
		}
		//System.out.println("service No=" + serviceNo);
		//System.out.println("empName=" + empName);
		session = (Session) getSession();
		if (!serviceNo.equals("")) {
			Criteria criteria = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y"));
			criteria = criteria.add(Restrictions.eq("ServiceNo", serviceNo));
			employeeList = criteria.list();
		} else if (!empName.equals("")) {
			Criteria crit1 = null;
			crit1 = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).add(
					Restrictions.like("FirstName", empName + "%"));
			if (crit1 == null) {
				crit1 = session.createCriteria(MasEmployee.class).add(
						Restrictions.eq("Status", "y")).add(
						Restrictions.like("MiddleName", empName + "%"));
				if (crit1 == null) {
					crit1 = session.createCriteria(MasEmployee.class).add(
							Restrictions.eq("Status", "y")).add(
							Restrictions.like("LastName", empName + "%"));
				}
			}
			employeeList = crit1.list();
		}
		//System.out.println("employeeList=" + employeeList.size());
		// employeeList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status",
		// "y")).list();
		departmentList = session.createCriteria(MasDepartment.class).add(
				Restrictions.eq("Status", "y")).list();
		dutyTimeMasterList = session.createCriteria(HrDutyTimeMaster.class)
				.add(Restrictions.eq("Status", "y")).list();
		map.put("employeeList", employeeList);
		map.put("departmentList", departmentList);
		map.put("dutyTimeMasterList", dutyTimeMasterList);

		int pageno = 1;
		int numOfRows = 10;
		try {
			if (box.get("pageno") != null) {
				pageno = Integer.parseInt(box.getString("pageno"));
			}
		} catch (Exception e) {
			// e.printStackTrace();
			pageno = 1;
		}

		try {
			if (box.get("numOfRows") != null) {
				numOfRows = Integer.parseInt(box.getString("numOfRows"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("pageno", pageno);

		int first = (pageno - 1) * numOfRows;
		int totalRecords = 0;
		if (employeeList != null && employeeList.size() > 0) {

			// String qry="SELECT count(*) FROM mas_employee";
			try {
				// totalRecords =
				// Integer.parseInt(session.createSQLQuery(qry).list().get(0).toString());
				totalRecords = employeeList.size();
			} catch (Exception e) {
				totalRecords = 0;
			}
			map.put("totalRecords", totalRecords);

			double totalPages = 0.0;
			totalPages = (double) totalRecords / (double) numOfRows;
			Double d = new Double(Math.ceil(totalPages));
			map.put("totalPages", d.intValue());
			Criteria c = null;
			if (!serviceNo.equals("")) {
				c = session.createCriteria(MasEmployee.class).add(
						Restrictions.eq("Status", "y"));
				c = c.add(Restrictions.eq("ServiceNo", serviceNo));
			} else if (!empName.equals("")) {
				c = session.createCriteria(MasEmployee.class).add(
						Restrictions.eq("Status", "y")).add(
						Restrictions.like("FirstName", empName + "%"));
				if (c == null) {
					c = session.createCriteria(MasEmployee.class).add(
							Restrictions.eq("Status", "y")).add(
							Restrictions.like("MiddleName", empName + "%"));
					if (c == null) {
						c = session.createCriteria(MasEmployee.class).add(
								Restrictions.eq("Status", "y")).add(
								Restrictions.like("LastName", empName + "%"));
					}
				}
			}

			// Criteria c
			// =session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status",
			// "y"));
			c.setFirstResult(first);

			if (totalRecords < numOfRows)
				c.setMaxResults(totalRecords);
			else
				c.setMaxResults(numOfRows);

			employeeDetailList = c.list();
		}
		//System.out.println("employeeDetailList=" + employeeDetailList.size());
		map.put("employeeDetailList", employeeDetailList);
		map.put("box", box);
		return map;
	}

	public Map<String, Object> searchLeaveApplication(String serviceNo,
			String entryNo) {
		List<HrorderlyLeaveApplication> searchLeaveApplicationList = new ArrayList<HrorderlyLeaveApplication>();
		Map<String, Object> chargeCodeFieldsMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Criteria crit = null;
		try {
			crit = session.createCriteria(HrorderlyLeaveApplication.class).add(
					Restrictions.like("EntryNo", entryNo + "%"));
			searchLeaveApplicationList = crit.list();
			//System.out.println("searchLeaveApplicationList"+ searchLeaveApplicationList.size());

		} catch (Exception e) {
			//System.out.println("Ds excp in searchporList  " + e);
		}

		chargeCodeFieldsMap.put("searchLeaveApplicationList",
				searchLeaveApplicationList);
		return chargeCodeFieldsMap;
	}

	public Map<String, Object> searchLeaveJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrorderlyLeaveApplication> leaveList = new ArrayList<HrorderlyLeaveApplication>();
		leaveList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.HrorderlyLeaveApplication ");
		map.put("leaveList", leaveList);
		return map;
	}

	public Map<String, Object> getEmployeeDetailsForMonthlyRationAccountingAdd(
			Box box) {
		PagedArray pagedArray = null;
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<HrDutyTimeMaster> dutyTimeMasterList = new ArrayList<HrDutyTimeMaster>();
		session = (Session) getSession();

		try {
			employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).list();
			departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).list();
			dutyTimeMasterList = session.createCriteria(HrDutyTimeMaster.class)
					.add(Restrictions.eq("Status", "y")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("employeeList", employeeList);
		map.put("departmentList", departmentList);
		map.put("dutyTimeMasterList", dutyTimeMasterList);

		map = getGridDataForMonthlyRationAccountingEmployeeAdd(box);

		return map;
	}

	public Map<String, Object> getGridDataForMonthlyRationAccountingEmployeeAdd(
			Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = (Map<String, Object>) HMSUtil
				.getCurrentDateAndTime();
		session = (Session) getSession();

		int id = 0;

		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;

		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasEmployee> employeeDetailList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<HrDutyTimeMaster> dutyTimeMasterList = new ArrayList<HrDutyTimeMaster>();

		rankList = session.createCriteria(MasRank.class).add(
				Restrictions.eq("RankName", "SGT")).list();
		employeeList = session.createCriteria(MasEmployee.class).add(
				Restrictions.eq("Status", "y")).list();
		departmentList = session.createCriteria(MasDepartment.class).add(
				Restrictions.eq("Status", "y")).list();
		dutyTimeMasterList = session.createCriteria(HrDutyTimeMaster.class)
				.add(Restrictions.eq("Status", "y")).list();
		map.put("employeeList", employeeList);
		map.put("departmentList", departmentList);
		map.put("dutyTimeMasterList", dutyTimeMasterList);

		int pageno = 1;
		int numOfRows = 10;
		try {
			if (box.get("pageno") != null) {
				pageno = Integer.parseInt(box.getString("pageno"));
			}
		} catch (Exception e) {
			// e.printStackTrace();
			pageno = 1;
		}

		try {
			if (box.get("numOfRows") != null) {
				numOfRows = Integer.parseInt(box.getString("numOfRows"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("pageno", pageno);

		int first = (pageno - 1) * numOfRows;
		int totalRecords = 0;
		if (employeeList != null && employeeList.size() > 0) {

			// String qry="SELECT count(*) FROM mas_employee";
			try {
				// totalRecords =
				// Integer.parseInt(session.createSQLQuery(qry).list().get(0).toString());
				totalRecords = employeeList.size();
			} catch (Exception e) {
				totalRecords = 0;
			}
			map.put("totalRecords", totalRecords);

			double totalPages = 0.0;
			totalPages = (double) totalRecords / (double) numOfRows;
			Double d = new Double(Math.ceil(totalPages));
			map.put("totalPages", d.intValue());

			Criteria c = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y"));
			c.setFirstResult(first);

			if (totalRecords < numOfRows)
				c.setMaxResults(totalRecords);
			else
				c.setMaxResults(numOfRows);

			employeeDetailList = c.list();
		}

		map.put("employeeDetailList", employeeDetailList);
		map.put("box", box);
		return map;
	}

	public Map<String, Object> getEmployeeDetailsForMonthlyRationAccountingDuty(
			Box box) {
		PagedArray pagedArray = null;
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMonthlyRationAccounting> hrMonthlyRationAccountingList = new ArrayList<HrMonthlyRationAccounting>();
		
		List<Object> objectList = new ArrayList<Object>();
		List<HrorderlyLeaveApplication> employeeList1 = new ArrayList<HrorderlyLeaveApplication>();
		List<MasEmployee> rationList = new ArrayList<MasEmployee>();
		int month = box.getInt("month");
		int year = box.getInt("year");
		hrMonthlyRationAccountingList = session.createCriteria(HrMonthlyRationAccounting.class)
		.add(Restrictions.eq("Year",year)).add(Restrictions.eq("Month",month )).list();
		//System.out.println("ration ki list" + hrMonthlyRationAccountingList.size());
		if(hrMonthlyRationAccountingList.size()==0)
		{
			java.sql.Connection con = session.connection();
			String sqlQuery = "call proc_monthly_ration_strength ("+month+" , "+year+")" ;
			try{
				CallableStatement cals= con.prepareCall(sqlQuery);
				boolean value = cals.execute();
			}catch(SQLException exc){
				exc.printStackTrace();
			}
			hrMonthlyRationAccountingList = session.createCriteria(HrMonthlyRationAccounting.class)
			.add(Restrictions.eq("Year",year)).add(Restrictions.eq("Month",month )).list();
		}
		int pageno = 1;
		int numOfRows = 10;
		try {
			if (box.get("pageno") != null) {
				pageno = Integer.parseInt(box.getString("pageno"));
			}
		} catch (Exception e) {
			// e.printStackTrace();
			pageno = 1;
		}
	
		map.put("pageno", pageno);

		int first = (pageno - 1) * numOfRows;
		int totalRecords = 0;
		if (hrMonthlyRationAccountingList != null && hrMonthlyRationAccountingList.size() > 0) {

			// String qry="SELECT count(*) FROM mas_employee";
			try {
				totalRecords = hrMonthlyRationAccountingList.size();
			} catch (Exception e) {
				totalRecords = 0;
			}
			map.put("totalRecords", totalRecords);

			double totalPages = 0.0;
			totalPages = (double) totalRecords / (double) numOfRows;
			Double d = new Double(Math.ceil(totalPages));
			map.put("totalPages", d.intValue());

			if ((totalRecords - first) < numOfRows)
				hrMonthlyRationAccountingList = hrMonthlyRationAccountingList.subList(first, totalRecords);
			else
				hrMonthlyRationAccountingList = hrMonthlyRationAccountingList.subList(first, numOfRows);

		}
				
		map.put("hrMonthlyRationAccountingList", hrMonthlyRationAccountingList);
		map.put("month", month);
		map.put("year", year);
		return map;
	}
	public void printRationSummaryDaily(int month , int year )
	{
		Session session = (Session) getSession();
		List<HrRationSummaryDayWise> hrRationSummaryDayWiseList = new ArrayList<HrRationSummaryDayWise>();
		hrRationSummaryDayWiseList = session.createCriteria(HrRationSummaryDayWise.class)
		.add(Restrictions.eq("Years",year)).add(Restrictions.eq("Months",month )).list();
		//System.out.println("HrRationSummaryDayWise ::" + hrRationSummaryDayWiseList.size());
		if(hrRationSummaryDayWiseList.size()==0)
		{
			java.sql.Connection con = session.connection();
			String sqlQuery = "call proc_ration_summary_day_wise ("+month+" , "+year+")" ;
			try{
				CallableStatement cals= con.prepareCall(sqlQuery);
				boolean value = cals.execute();
			}catch(SQLException exc){
				exc.printStackTrace();
			}
		}
		
	}
	public Map<String , Object> getGridDataForMonthlyRationStrength(Box box )
	{
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMonthlyRationAccounting> hrMonthlyRationAccountingList = new ArrayList<HrMonthlyRationAccounting>();
		int month = box.getInt("monthFroPagenation");
		int year = box.getInt("yearFroPagenation");
		hrMonthlyRationAccountingList = session.createCriteria(HrMonthlyRationAccounting.class)
		.add(Restrictions.eq("Year",year)).add(Restrictions.eq("Month",month )).list();
		//System.out.println("ration ki list" + hrMonthlyRationAccountingList.size());
		int pageno = 1;
		int numOfRows = 10;
		try {
			if (box.get("pageno") != null) {
				pageno = Integer.parseInt(box.getString("pageno"));
			}
			if(box.get("gopage")!=null && ! box.get("gopage").equals("")){
				pageno= Integer.parseInt(box.getString("gopage"));
			}
		} catch (Exception e) {
			// e.printStackTrace();
			pageno = 1;
		}
	    
		map.put("pageno", pageno);

		int first = (pageno - 1) * numOfRows;
		int totalRecords = 0;
		if (hrMonthlyRationAccountingList != null && hrMonthlyRationAccountingList.size() > 0) {

			// String qry="SELECT count(*) FROM mas_employee";
			try {
				totalRecords = hrMonthlyRationAccountingList.size();
			} catch (Exception e) {
				totalRecords = 0;
			}
			map.put("totalRecords", totalRecords);

			double totalPages = 0.0;
			totalPages = (double) totalRecords / (double) numOfRows;
			Double d = new Double(Math.ceil(totalPages));
			map.put("totalPages", d.intValue());

			if ((totalRecords - first) < numOfRows)
				hrMonthlyRationAccountingList = hrMonthlyRationAccountingList.subList(first, totalRecords);
			else
				hrMonthlyRationAccountingList = hrMonthlyRationAccountingList.subList(first, numOfRows+first);

		}
		//System.out.println("pageno::"+pageno+"::totalRecords::"+totalRecords+"::totalPages::");		
		map.put("hrMonthlyRationAccountingList", hrMonthlyRationAccountingList);
		map.put("month", month);
		map.put("year", year);

		
		return map ;
		
	}
	public Map<String, Object> getDetailsForEmployeeAbsence(Box box)
	{
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMonthlyRationAccountingLeaveDetail> hrMonthlyRationAccountingLeaveDetailList = new ArrayList<HrMonthlyRationAccountingLeaveDetail>();
		List<HrMonthlyRationAccountingInpatientDetail> hrMonthlyRationAccountingInpatientDetailList = new ArrayList<HrMonthlyRationAccountingInpatientDetail>();
		List<HrMonthlyRationAccountingMovementDetail> hrMonthlyRationAccountingMovementTDDetailList = new ArrayList<HrMonthlyRationAccountingMovementDetail>();
		List<HrMonthlyRationAccountingMovementDetail> hrMonthlyRationAccountingMovementAWLDetailList = new ArrayList<HrMonthlyRationAccountingMovementDetail>();
		int months = box.getInt("month");
		int years = box.getInt("year");
		int rationId = box.getInt("rationId");
		
		hrMonthlyRationAccountingLeaveDetailList = session.createCriteria(HrMonthlyRationAccountingLeaveDetail.class).createAlias("RationId", "rationId")
								.add(Restrictions.eq("rationId.Id", rationId)).list();
		hrMonthlyRationAccountingInpatientDetailList = session.createCriteria(HrMonthlyRationAccountingInpatientDetail.class).createAlias("RationId", "rationId")
								.add(Restrictions.eq("rationId.Id", rationId)).list();
		hrMonthlyRationAccountingMovementTDDetailList = session.createCriteria(HrMonthlyRationAccountingMovementDetail.class).createAlias("RationId", "rationId")
								.add(Restrictions.eq("rationId.Id", rationId))
								.add(Restrictions.eq("MovementType","TD(Hosp Staff)" )).list();
		hrMonthlyRationAccountingMovementAWLDetailList = session.createCriteria(HrMonthlyRationAccountingMovementDetail.class).createAlias("RationId", "rationId")
		.add(Restrictions.eq("rationId.Id", rationId))
		.add(Restrictions.eq("MovementType","AWL" )).list();
		
		map.put("hrMonthlyRationAccountingLeaveDetailList", hrMonthlyRationAccountingLeaveDetailList);
		map.put("hrMonthlyRationAccountingInpatientDetailList", hrMonthlyRationAccountingInpatientDetailList);
		map.put("hrMonthlyRationAccountingMovementTDDetailList", hrMonthlyRationAccountingMovementTDDetailList);
		map.put("hrMonthlyRationAccountingMovementAWLDetailList", hrMonthlyRationAccountingMovementAWLDetailList);
				
		return map ;
	}

	public Map<String, Object> getGridDataForMonthlyRationAccountingEmployee(
			Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = (Map<String, Object>) HMSUtil
				.getCurrentDateAndTime();
		session = (Session) getSession();
		Calendar cal = Calendar.getInstance();
		int id = 0;
		int deptId = 0;
		String month = box.get("month");

		//System.out.println("month" + month);
		String year = box.get("year");
		// String dateStringStarting = 1 + "/" + month + "/" + year;
		// Date d1 =
		// HMSUtil.convertStringTypeDateToDateType(dateStringStarting);
		// Calendar c1 = Calendar.getInstance();
		// c1.setTime(d1);
		// int lastDate = c1.getActualMaximum(Calendar.DATE);
		// String joindateEnding = lastDate + "/" + month + "/" + year;
		// Date d2 = HMSUtil.convertStringTypeDateToDateType(joindateEnding);
		// //System.out.println("Last Date:---------- " + lastDate);
		//
		// //System.out.println("yearrrrrrrrrrr" + year);
		List<HrorderlyLeaveApplication> leaveAppList = new ArrayList<HrorderlyLeaveApplication>();
		List<MovementOutEntry> moveOutList = new ArrayList<MovementOutEntry>();
		List<Object> objectList = new ArrayList<Object>();
		List<HrorderlyMonthlyRationAccounting> rationEntryList = new ArrayList<HrorderlyMonthlyRationAccounting>();
		rationEntryList = session.createCriteria(
				HrorderlyMonthlyRationAccounting.class).list();

		objectList = session
				.createSQLQuery(
						"select * from (select sendsql.*,snd.* from"
								+ "(select * from"
								+ "(select * from"
								+ "(SELECT service_no as sv , rank_id , first_name, join_date , status ,employee_id as empid from mas_employee where"
								+

								" month(join_date) = "
								+ month
								+ " and year(join_date) = "
								+ year
								+ ") as frstsql"
								+ " inner join(select inp.discharge_date,inp.date_of_addmission,pa.service_no from inpatient as inp"
								+ " inner join patient as pa on inp.hin_id = pa.hin_id where inp.ad_status='a') as sndsql"
								+ " on frstsql.sv=sndsql.service_no) as firstsql left outer join(select e.employee_id ,leave_from_date, date_of_reporting,"
								+ " if(leave_total_days is null,0,leave_total_days) as leave_total_days from"
								+

								" hrorderly_leave_application l, mas_employee e where month(e.join_date) = "
								+ month
								+ " and year(e.join_date) = "
								+ year
								+ " and e.employee_id = l.employee_id) as secondsq"
								+ " on firstsql.empid = secondsq.employee_id) as sendsql"
								+ " left outer join(SELECT e.employee_id as emp,from_date, to_date"
								+ " FROM movement_out_entry m, mas_employee e where m.movement_type = 't'"
								+ " and month(e.join_date) = "
								+ month
								+ " and year(e.join_date) = "
								+ year
								+ " and e.employee_id = m.employee_id)"
								+ " as snd on sendsql.employee_id = snd.emp) as finalData"
								+ " left outer join(SELECT e.employee_id ,from_date, to_date FROM movement_out_entry m, mas_employee e"
								+ " where m.movement_type = 'a' and"
								+ " month(e.join_date) = "
								+ month
								+ " and year(e.join_date) = "
								+ year
								+ " and"
								+ " e.employee_id = m.employee_id ) as finaldata1"
								+ " on finalData.employee_id=finaldata1.employee_id;")
				.list();

		moveOutList = session.createCriteria(MovementOutEntry.class).add(
				Restrictions.eq("Status", "y")).list();
		leaveAppList = session.createCriteria(HrorderlyLeaveApplication.class)
				.add(Restrictions.eq("Status", "y")).list();
		//System.out.println("emppppppppplllllllll" + objectList.size());
		map.put("moveOutList", moveOutList);
		map.put("leaveAppList", leaveAppList);
		map.put("objectList", objectList);

		int pageno = 1;
		int numOfRows = 10;
		try {
			if (box.get("pageno") != null) {
				pageno = Integer.parseInt(box.getString("pageno"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			pageno = 1;
		}

		try {
			if (box.get("numOfRows") != null) {
				numOfRows = Integer.parseInt(box.getString("numOfRows"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("pageno", pageno);

		int first = (pageno - 1) * numOfRows;
		int totalRecords = 0;
		if (objectList != null && objectList.size() > 0) {

			// String qry = "SELECT count(*) FROM mas_employee";
			// //System.out.println("qery"+qry.);

			totalRecords = objectList.size();
			//System.out.println("totalllllll" + totalRecords);
			map.put("totalRecords", totalRecords);

			double totalPages = 0.0;
			totalPages = (double) totalRecords / (double) numOfRows;
			Double d = new Double(Math.ceil(totalPages));
			map.put("totalPages", d.intValue());

			Criteria c = session.createCriteria(MasEmployee.class);

			c.setFirstResult(first);
			//      
			if (totalRecords < numOfRows)
				c.setMaxResults(totalRecords);
			else
				c.setMaxResults(numOfRows);

			objectList = c.list();
			//System.out.println("listttttttt" + objectList.size());
		}

		map.put("objectList", objectList);
		map.put("rationEntryList", rationEntryList);
		map.put("box", box);
		//System.out.println("month1" + month);
		//System.out.println("year2" + year);
		//System.out.println("box" + box);
		return map;
	}

	public Map<String, Object> showUpdateHroEntryJsp(int hroId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HroEntry> hroEntryList = new ArrayList<HroEntry>();
		hroEntryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.HroEntry where Id ='" + hroId
						+ "' ");
		map.put("hroEntryList", hroEntryList);
		map.put("hroId", hroId);
		return map;
	}

	public Map<String, Object> searchHROEntry(String entryNo, Date proposalDate) {
		List<HroEntry> searchHROList = new ArrayList<HroEntry>();

		Map<String, Object> infoMap = new HashMap<String, Object>();

		try {
			if (entryNo != null && proposalDate == null) {
				searchHROList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.HroEntry imc where imc.EntryNo like '"
								+ entryNo + "%'");
			} else if (proposalDate != null && entryNo == null) {
				searchHROList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.HroEntry imc where imc.HroDate ='"
								+ HMSUtil.getDateFormat(proposalDate,
										"yyyy-MM-dd") + "'");
			} else if (entryNo != null && proposalDate != null) {
				searchHROList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.HroEntry imc where imc.EntryNo ='"
								+ entryNo
								+ "' and imc.HroDate ='"
								+ HMSUtil.getDateFormat(proposalDate,
										"yyyy-MM-dd") + "'");
			}

		} catch (Exception e) {

		}
		infoMap.put("searchHROList", searchHROList);
		return infoMap;
	}

	public Map<String, Object> showHroSearchEntry() {
		List<HroEntry> hroList = new ArrayList<HroEntry>();
		Map<String, Object> infoMap = new HashMap<String, Object>();

		Session session = (Session) getSession();
		hroList = session.createCriteria(ProposalForHroEntry.class).add(
				Restrictions.eq("Status", "y")).list();
		infoMap.put("hroList", hroList);
		return infoMap;
	}

	public Map<String, Object> showSearchPostedOutJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PostedOutEntry> searchPostedOut = new ArrayList<PostedOutEntry>();
		List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
		masEmployeeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasEmployee");
		searchPostedOut = getHibernateTemplate().find(
				"from jkt.hms.masters.business.PostedOutEntry");
		map.put("masEmployeeList", masEmployeeList);
		map.put("searchPostedOut", searchPostedOut);

		return map;
	}

	public Map<String, Object> searchPostedOutEntry(String entryNo,
			String serviceNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();

		List<PostedOutEntry> searchPostedOut = new ArrayList<PostedOutEntry>();
		List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
		masEmployeeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasEmployee");
		Session session = (Session) getSession();

		infoMap.put("masEmployeeList", masEmployeeList);
		try {
			if (entryNo != null && serviceNo == null) {
				searchPostedOut = getHibernateTemplate().find(
						"from jkt.hms.masters.business.PostedOutEntry imc where imc.EntryNo like '"
								+ entryNo + "%'");

			} else if (entryNo == null && serviceNo != null) {
				Criteria c1 = session.createCriteria(PostedOutEntry.class)
						.createAlias("Employee", "emp").add(
								Restrictions.eq("emp.ServiceNo", serviceNo));
				//System.out.println("serviceNo=============" + serviceNo);
				searchPostedOut = c1.list();

			} else if (entryNo != null && serviceNo != null) {
				Criteria c1 = session.createCriteria(PostedOutEntry.class)
						.createAlias("Employee", "emp").add(
								Restrictions.and(Restrictions.eq("EntryNo",
										entryNo), Restrictions.eq(
										"emp.ServiceNo", serviceNo)));
				searchPostedOut = c1.list();
			}

		} catch (Exception e) {

		}
		infoMap.put("searchPostedOut", searchPostedOut);
		return infoMap;

	}

	public Map<String, Object> showUpdatePostedOutJsp(int Id) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PostedOutEntry> postedOutList = new ArrayList<PostedOutEntry>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		postedOutList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.PostedOutEntry where Id ='" + Id
						+ "' ");
		unitList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasUnit");
		map.put("postedOutList", postedOutList);
		map.put("unitList", unitList);
		map.put("Id", Id);
		return map;
	}

	public boolean editPostedOutUpdateToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;

		int id = 0;
		String porSlno = "";
		String authority = "";
		String remarks = "";
		Date appraisalReport = new Date();
		String postedType = "";
		int unitPostedTo = 0;
		Date postedDate = new Date();
		Date sors = new Date();
		String changedBy = "";
		String lastChangedDate = "";
		String lastChangedTime = "";
		Date currentDate = new Date();
		String currentTime = "";

		id = (Integer) generalMap.get("id");
		postedDate = (Date) generalMap.get("postedDate");
		sors = (Date) generalMap.get("sors");
		postedType = (String) generalMap.get("postedType");
		unitPostedTo = (Integer) generalMap.get("unitPostedTo");
		authority = (String) generalMap.get("authority");
		porSlno = (String) generalMap.get("porSlno");
		appraisalReport = (Date) generalMap.get("appraisalReport");
		remarks = (String) generalMap.get("remarks");
		changedBy = (String) generalMap.get("changedBy");
		lastChangedDate = (String) generalMap.get("lastChangedDate");
		lastChangedTime = (String) generalMap.get("lastChangedTime");
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		PostedOutEntry postedOutUpdate = (PostedOutEntry) getHibernateTemplate()
				.load(PostedOutEntry.class, id);

		postedOutUpdate.setId(id);
		postedOutUpdate.setDate(postedDate);

		if (unitPostedTo != 0) {
			MasUnit masUnit = new MasUnit();
			masUnit.setId(unitPostedTo);
			postedOutUpdate.setUnitPostedTo(masUnit);
		}

		postedOutUpdate.setSors(sors);
		postedOutUpdate.setAuthority(authority);
		postedOutUpdate.setAppraisalReport(appraisalReport);
		postedOutUpdate.setPostedType(postedType);
		postedOutUpdate.setPorSlno(porSlno);
		postedOutUpdate.setRemarks(remarks);

		postedOutUpdate.setLstChangedBy(changedBy);
		postedOutUpdate.setLstChangedDate(currentDate);
		postedOutUpdate.setLstChangedTime(currentTime);

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(true);
		hbt.update(postedOutUpdate);
		dataUpdated = true;
		return dataUpdated;

	}

	public boolean editProposalHroUpdateToDatabase(
			Map<String, Object> generalMap) {
		boolean dataUpdated = false;

		String textContent = "";
		String subjectName = "";
		int proposalId = 0;
		int employeeName = 1;
		String message = "";
		Date entryDate = null;

		String changedBy = "";
		String lastChangedDate = "";
		String lastChangedTime = "";
		Date currentDate = new Date();
		String currentTime = "";

		proposalId = (Integer) generalMap.get("id");
		entryDate = (Date) generalMap.get("entryDate");
		textContent = (String) generalMap.get("textContent");
		subjectName = (String) generalMap.get("subjectName");
		changedBy = (String) generalMap.get("changedBy");
		lastChangedDate = (String) generalMap.get("lastChangedDate");
		lastChangedTime = (String) generalMap.get("lastChangedTime");
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		ProposalForHroEntry proposalUpdate = (ProposalForHroEntry) getHibernateTemplate()
				.load(ProposalForHroEntry.class, proposalId);

		proposalUpdate.setId(proposalId);
		proposalUpdate.setPropsalDate(entryDate);

		proposalUpdate.setSubject(subjectName);
		proposalUpdate.setTextContent(textContent);

		proposalUpdate.setLstChangedBy(changedBy);
		proposalUpdate.setLstChangedDate(currentDate);
		proposalUpdate.setLstChangedTime(currentTime);

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(true);
		hbt.update(proposalUpdate);
		dataUpdated = true;
		return dataUpdated;

	}

	public boolean editHroEntryToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;

		String textContent = "";

		String serialNo = "";
		int hroId = 0;
		String message = "";
		Date entryDate = null;

		String changedBy = "";
		String lastChangedDate = "";
		String lastChangedTime = "";
		Date currentDate = new Date();
		String currentTime = "";

		hroId = (Integer) generalMap.get("id");
		entryDate = (Date) generalMap.get("entryDate");
		serialNo = (String) generalMap.get("serialNo");
		textContent = (String) generalMap.get("textContent");
		changedBy = (String) generalMap.get("changedBy");
		lastChangedDate = (String) generalMap.get("lastChangedDate");
		lastChangedTime = (String) generalMap.get("lastChangedTime");
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		HroEntry hroUpdate = (HroEntry) getHibernateTemplate().load(
				HroEntry.class, hroId);

		hroUpdate.setId(hroId);
		hroUpdate.setHroDate(entryDate);
		hroUpdate.setSerialNo(serialNo);
		hroUpdate.setTextContent(textContent);

		hroUpdate.setLstChangedBy(changedBy);
		hroUpdate.setLstChangedDate(currentDate);
		hroUpdate.setLstChangedTime(currentTime);

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(true);
		hbt.update(hroUpdate);
		dataUpdated = true;
		return dataUpdated;

	}

	public boolean updateProposalForHro(Box box) {
		boolean successfullyAdded = false;
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		String empName = "";
		String entryNo = "";
		Vector proposalId = box.getVector("proposalId");
		Vector dutyDate = box.getVector("nextDutyDate");
		Vector departmentName = box.getVector("departmentName");
		Vector listAdded = box.getVector("pendingListAdded");
		String changedBy = box.getString("changedBy");
		String changedDate = box.getString("changedDate");
		String changedTime = box.getString("changedTime");
		String textContent = "";
		Date proposalDate = null;
		//System.out.println("proposalId::"+proposalId.size());
		try {

			for (int i = 0; i < proposalId.size(); i++) {
				    if(listAdded.contains(proposalId.get(i))){ 
				    ProposalForHroEntry proposalForHroEntry = (ProposalForHroEntry) hbt.load(ProposalForHroEntry.class, Integer.parseInt(proposalId.get(i).toString()));
					proposalForHroEntry.setDispatch("d");
					PendingHroProposal pendingHroProposal = new PendingHroProposal();
					pendingHroProposal.setProposalHroEntryId(proposalForHroEntry);
					pendingHroProposal.setStatus("y");
					pendingHroProposal.setDispatch("p");
					if (box.getString("changedBy") != null
							&& !box.getString("changedBy").equals("")) {
						pendingHroProposal.setLastChangedBy(box
								.getString("changedBy"));
					}

					if (box.getString("changedDate") != null
							&& !box.getString("changedDate").equals("")) {
						pendingHroProposal.setLastChangedDate(HMSUtil
								.convertStringTypeDateToDateType((box
										.getString("changedDate"))));
					}

					if (box.getString("changedTime") != null
							&& !box.getString("changedTime").equals("")) {
						pendingHroProposal.setLastChangedTime(box
								.getString("changedTime"));
					}
					hbt.saveOrUpdate(proposalForHroEntry);
					hbt.refresh(proposalForHroEntry);
					hbt.save(pendingHroProposal);
					hbt.refresh(pendingHroProposal);
					successfullyAdded = true;

				

			}}

		} catch (Exception e) {
			successfullyAdded = false;
			e.printStackTrace();
		}

		

		return successfullyAdded;

	}

	public Map<String, Object> showSearchLeaveRestrictionJsp() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<LeaveRestrictionEntry> leaveRestrictionEntryList = new ArrayList<LeaveRestrictionEntry>();
		leaveRestrictionEntryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.LeaveRestrictionEntry");
		map.put("leaveRestrictionEntryList", leaveRestrictionEntryList);
		return map;

	}

	/**
	 * -------------------------- Range Firing Duty Entry -------------------
	 * Started on 9th June '09
	 */

	public Map<String, Object> getEmployeeDetailsForRangeFiringDutyAdd(Box box) {
		PagedArray pagedArray = null;
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<HrDutyTimeMaster> dutyTimeMasterList = new ArrayList<HrDutyTimeMaster>();
		session = (Session) getSession();

		try {
			employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).list();
			departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).list();
			dutyTimeMasterList = session.createCriteria(HrDutyTimeMaster.class)
					.add(Restrictions.eq("Status", "y")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("employeeList", employeeList);
		map.put("departmentList", departmentList);
		map.put("dutyTimeMasterList", dutyTimeMasterList);

		map = getGridDataForRangeFiringEmployeeAdd(box);

		return map;
	}

	public Map<String, Object> getGridDataForRangeFiringEmployeeAdd(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = (Map<String, Object>) HMSUtil
				.getCurrentDateAndTime();
		session = (Session) getSession();

		int id = 0;

		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;

		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasEmployee> employeeDetailList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<HrDutyTimeMaster> dutyTimeMasterList = new ArrayList<HrDutyTimeMaster>();

		rankList = session.createCriteria(MasRank.class).add(
				Restrictions.eq("RankName", "SGT")).list();
		employeeList = session.createCriteria(MasEmployee.class).add(
				Restrictions.eq("Status", "y")).list();
		departmentList = session.createCriteria(MasDepartment.class).add(
				Restrictions.eq("Status", "y")).list();
		dutyTimeMasterList = session.createCriteria(HrDutyTimeMaster.class)
				.add(Restrictions.eq("Status", "y")).list();
		map.put("employeeList", employeeList);
		map.put("departmentList", departmentList);
		map.put("dutyTimeMasterList", dutyTimeMasterList);

		int pageno = 1;
		int numOfRows = 10;
		try {
			if (box.get("pageno") != null) {
				pageno = Integer.parseInt(box.getString("pageno"));
			}
		} catch (Exception e) {
			// e.printStackTrace();
			pageno = 1;
		}

		try {
			if (box.get("numOfRows") != null) {
				numOfRows = Integer.parseInt(box.getString("numOfRows"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("pageno", pageno);

		int first = (pageno - 1) * numOfRows;
		int totalRecords = 0;
		if (employeeList != null && employeeList.size() > 0) {

			// String qry="SELECT count(*) FROM mas_employee";
			try {
				// totalRecords =
				// Integer.parseInt(session.createSQLQuery(qry).list().get(0).toString());
				totalRecords = employeeList.size();
			} catch (Exception e) {
				totalRecords = 0;
			}
			map.put("totalRecords", totalRecords);

			double totalPages = 0.0;
			totalPages = (double) totalRecords / (double) numOfRows;
			Double d = new Double(Math.ceil(totalPages));
			map.put("totalPages", d.intValue());

			Criteria c = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y"));
			c.setFirstResult(first);

			if (totalRecords < numOfRows)
				c.setMaxResults(totalRecords);
			else
				c.setMaxResults(numOfRows);

			employeeDetailList = c.list();
		}

		map.put("employeeDetailList", employeeDetailList);
		map.put("box", box);
		return map;
	}

	public Map<String, Object> getEmployeeDetailsForRangeFiringDuty(Box box) {
		//System.out.println("first method called");
		PagedArray pagedArray = null;
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<HrorderlyRangeFiringDutyEntry> dutyList = new ArrayList<HrorderlyRangeFiringDutyEntry>();
		String quarter = box.get("quarter");
		String year = box.get("year");

		session = (Session) getSession();
		//System.out.println("box ........." + box);

		try {
			dutyList = session.createCriteria(HrRangeFiringDutyEntry.class)
					.add(Restrictions.eq("Qaurter", quarter)).add(
							Restrictions.eq("Year", Integer.parseInt(year)))
					.add(Restrictions.eq("Status", "y")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("dutyList", dutyList);
		map.put("quarter", quarter);
		map.put("year", year);

		map = getGridDataForRangeFiringEmployee(box);

		return map;
	}

	public Map<String, Object> getGridDataForRangeFiringEmployee(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = (Map<String, Object>) HMSUtil
				.getCurrentDateAndTime();
		session = (Session) getSession();

		int id = 0;
		int deptId = 0;
		String quarter = box.get("quarter");
		String year = box.get("year");

		List<HrorderlyRangeFiringDutyEntry> employeeList = new ArrayList<HrorderlyRangeFiringDutyEntry>();
		List<HrorderlyRangeFiringDutyEntry> dutyEntryList = new ArrayList<HrorderlyRangeFiringDutyEntry>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<HrDutyTimeMaster> dutyMasterList = new ArrayList<HrDutyTimeMaster>();

		employeeList = session.createCriteria(HrRangeFiringDutyEntry.class)
				.add(Restrictions.eq("Qaurter", quarter)).add(
						Restrictions.eq("Year", Integer.parseInt(year))).add(
						Restrictions.eq("Status", "y")).list();
		departmentList = session.createCriteria(MasDepartment.class).add(
				Restrictions.eq("Status", "y")).list();
		dutyMasterList = session.createCriteria(HrDutyTimeMaster.class).add(
				Restrictions.eq("Status", "y")).list();

		map.put("employeeList", employeeList);
		map.put("departmentList", departmentList);
		map.put("dutyMasterList", dutyMasterList);
		int pageno = 1;
		int numOfRows = 10;
		try {
			if (box.get("pageno") != null) {
				pageno = Integer.parseInt(box.getString("pageno"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			pageno = 1;
		}

		try {
			if (box.get("numOfRows") != null) {
				numOfRows = Integer.parseInt(box.getString("numOfRows"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("pageno", pageno);

		int first = (pageno - 1) * numOfRows;
		int totalRecords = 0;
		if (employeeList != null && employeeList.size() > 0) {

			String qry = "SELECT count(*) FROM hrorderly_Range_firing_duty_entry";
			try {
				totalRecords = Integer.parseInt(session.createSQLQuery(qry)
						.list().get(0).toString());
			} catch (Exception e) {
				totalRecords = 0;
			}
			map.put("totalRecords", totalRecords);

			double totalPages = 0.0;
			totalPages = (double) totalRecords / (double) numOfRows;
			Double d = new Double(Math.ceil(totalPages));
			map.put("totalPages", d.intValue());

			Criteria c = session.createCriteria(HrRangeFiringDutyEntry.class)
					.add(Restrictions.eq("Qaurter", quarter)).add(
							Restrictions.eq("Year", Integer.parseInt(year)))
					.add(Restrictions.eq("Status", "y"));
			c.setFirstResult(first);

			if (totalRecords < numOfRows)
				c.setMaxResults(totalRecords);
			else
				c.setMaxResults(numOfRows);

			dutyEntryList = c.list();
		}

		map.put("dutyEntryList", dutyEntryList);
		map.put("box", box);
		return map;
	}

	public boolean AddRangeFiringDutyEntry(Box box) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		Vector empId = box.getVector("employeeId");
		Vector employeeAdded = box.getVector("employeeToBeAdded");
		String quarter = box.get("quarter");
		String year = box.get("year");
		try {

			for (int i = 0; i < empId.size(); i++) {
				if (employeeAdded.contains(empId.get(i))) {
					HrorderlyRangeFiringDutyEntry hrRangeFiringDutyEntry = new HrorderlyRangeFiringDutyEntry();
					if (empId.get(i) != null && !empId.get(i).equals("")) {
						MasEmployee masEmployee = new MasEmployee();
						masEmployee.setId(Integer.parseInt(empId.get(i)
								.toString()));
						hrRangeFiringDutyEntry.setEmployee(masEmployee);
					}

					hrRangeFiringDutyEntry.setQaurter(quarter);
					hrRangeFiringDutyEntry.setYear(Integer.parseInt(year));
					hrRangeFiringDutyEntry.setStatus("y");

					if (box.getString("changedBy") != null
							&& !box.getString("changedBy").equals("")) {
						hrRangeFiringDutyEntry.setLastChgBy(box
								.getString("changedBy"));
					}

					if (box.getString("changedDate") != null
							&& !box.getString("changedDate").equals("")) {
						hrRangeFiringDutyEntry.setLastChgDate(HMSUtil
								.convertStringTypeDateToDateType((box
										.getString("changedDate"))));
					}

					if (box.getString("changedTime") != null
							&& !box.getString("changedTime").equals("")) {
						hrRangeFiringDutyEntry.setLastChgTime(box
								.getString("changedTime"));
					}

					MasHospital masHospital = new MasHospital();
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

	public boolean updateRangeFiringDutyEntry(Box box) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		String empName = "";
		Vector dutyId = box.getVector("dutyId");
		Vector dutyToBeUpdated = box.getVector("dutyToBeUpdated");

		try {

			for (int i = 0; i < dutyId.size(); i++) {
				if (dutyToBeUpdated.contains(dutyId.get(i))) {
					HrorderlyRangeFiringDutyEntry hrRangeFiringDutyEntry = (HrorderlyRangeFiringDutyEntry) hbt
							.load(HrorderlyRangeFiringDutyEntry.class, Integer
									.parseInt(dutyId.get(i).toString()));
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

	public Map<String, Object> searchRangeFiringDutyEntry(Box box) {
		PagedArray pagedArray = null;
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<HrDutyTimeMaster> dutyTimeMasterList = new ArrayList<HrDutyTimeMaster>();
		String serviceNo = "";
		String empName = "";

		if (!box.getString("searchServiceNo").equals("")) {
			serviceNo = box.getString("searchServiceNo");
		}
		if (!box.getString("searchName").equals("")) {
			empName = box.getString("searchName");
		}
		session = (Session) getSession();
		if (!serviceNo.equals("")) {
			Criteria criteria = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y"));
			criteria = criteria.add(Restrictions.eq("ServiceNo", serviceNo));
			employeeList = criteria.list();
		} else if (!empName.equals("")) {
			Criteria crit1 = null;
			crit1 = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).add(
					Restrictions.like("FirstName", empName + "%"));
			if (crit1 == null) {
				crit1 = session.createCriteria(MasEmployee.class).add(
						Restrictions.eq("Status", "y")).add(
						Restrictions.like("MiddleName", empName + "%"));
				if (crit1 == null) {
					crit1 = session.createCriteria(MasEmployee.class).add(
							Restrictions.eq("Status", "y")).add(
							Restrictions.like("LastName", empName + "%"));
				}
			}
			employeeList = crit1.list();
		}

		try {
			// employeeList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status",
			// "y")).list();
			departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).list();
			dutyTimeMasterList = session.createCriteria(HrDutyTimeMaster.class)
					.add(Restrictions.eq("Status", "y")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("employeeList", employeeList);
		map.put("departmentList", departmentList);
		map.put("dutyTimeMasterList", dutyTimeMasterList);

		map = getGridDataForRangeFiringEmployeeSearch(box);

		return map;
	}

	public Map<String, Object> getGridDataForRangeFiringEmployeeSearch(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = (Map<String, Object>) HMSUtil
				.getCurrentDateAndTime();
		session = (Session) getSession();

		int id = 0;

		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;

		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasEmployee> employeeDetailList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<HrDutyTimeMaster> dutyTimeMasterList = new ArrayList<HrDutyTimeMaster>();
		String serviceNo = "";
		String empName = "";

		if (!box.getString("searchServiceNo").equals("")) {
			serviceNo = box.getString("searchServiceNo");
		}
		if (!box.getString("searchName").equals("")) {
			empName = box.getString("searchName");
		}
		//System.out.println("service No=" + serviceNo);
		//System.out.println("empName=" + empName);
		session = (Session) getSession();
		if (!serviceNo.equals("")) {
			Criteria criteria = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y"));
			criteria = criteria.add(Restrictions.eq("ServiceNo", serviceNo));
			employeeList = criteria.list();
		} else if (!empName.equals("")) {
			Criteria crit1 = null;
			crit1 = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).add(
					Restrictions.like("FirstName", empName + "%"));
			if (crit1 == null) {
				crit1 = session.createCriteria(MasEmployee.class).add(
						Restrictions.eq("Status", "y")).add(
						Restrictions.like("MiddleName", empName + "%"));
				if (crit1 == null) {
					crit1 = session.createCriteria(MasEmployee.class).add(
							Restrictions.eq("Status", "y")).add(
							Restrictions.like("LastName", empName + "%"));
				}
			}
			employeeList = crit1.list();
		}
		//System.out.println("employeeList=" + employeeList.size());
		// employeeList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status",
		// "y")).list();
		departmentList = session.createCriteria(MasDepartment.class).add(
				Restrictions.eq("Status", "y")).list();
		dutyTimeMasterList = session.createCriteria(HrDutyTimeMaster.class)
				.add(Restrictions.eq("Status", "y")).list();
		map.put("employeeList", employeeList);
		map.put("departmentList", departmentList);
		map.put("dutyTimeMasterList", dutyTimeMasterList);

		int pageno = 1;
		int numOfRows = 10;
		try {
			if (box.get("pageno") != null) {
				pageno = Integer.parseInt(box.getString("pageno"));
			}
		} catch (Exception e) {
			// e.printStackTrace();
			pageno = 1;
		}

		try {
			if (box.get("numOfRows") != null) {
				numOfRows = Integer.parseInt(box.getString("numOfRows"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("pageno", pageno);

		int first = (pageno - 1) * numOfRows;
		int totalRecords = 0;
		if (employeeList != null && employeeList.size() > 0) {

			// String qry="SELECT count(*) FROM mas_employee";
			try {
				// totalRecords =
				// Integer.parseInt(session.createSQLQuery(qry).list().get(0).toString());
				totalRecords = employeeList.size();
			} catch (Exception e) {
				totalRecords = 0;
			}
			map.put("totalRecords", totalRecords);

			double totalPages = 0.0;
			totalPages = (double) totalRecords / (double) numOfRows;
			Double d = new Double(Math.ceil(totalPages));
			map.put("totalPages", d.intValue());
			Criteria c = null;
			if (!serviceNo.equals("")) {
				c = session.createCriteria(MasEmployee.class).add(
						Restrictions.eq("Status", "y"));
				c = c.add(Restrictions.eq("ServiceNo", serviceNo));
			} else if (!empName.equals("")) {
				c = session.createCriteria(MasEmployee.class).add(
						Restrictions.eq("Status", "y")).add(
						Restrictions.like("FirstName", empName + "%"));
				if (c == null) {
					c = session.createCriteria(MasEmployee.class).add(
							Restrictions.eq("Status", "y")).add(
							Restrictions.like("MiddleName", empName + "%"));
					if (c == null) {
						c = session.createCriteria(MasEmployee.class).add(
								Restrictions.eq("Status", "y")).add(
								Restrictions.like("LastName", empName + "%"));
					}
				}
			}

			// Criteria c
			// =session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status",
			// "y"));
			c.setFirstResult(first);

			if (totalRecords < numOfRows)
				c.setMaxResults(totalRecords);
			else
				c.setMaxResults(numOfRows);

			employeeDetailList = c.list();
		}
		//System.out.println("employeeDetailList=" + employeeDetailList.size());
		map.put("employeeDetailList", employeeDetailList);
		map.put("box", box);
		return map;
	}

	public boolean updateMonthlyRationAccounting(Box box) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		String empName = "";
		Vector monthlyRationId = box.getVector("monthlyRationId");
		Vector deptId = box.getVector("department");
		Vector dutyDate = box.getVector("nextDutyDate");
		Vector dutyTime = box.getVector("dutyTime");
		Vector porNo = box.getVector("porNo");
		Vector occurrenceNo = box.getVector("occurrenceNo");

		try {

			for (int i = 0; i < monthlyRationId.size(); i++) {

				HrorderlyMonthlyRationAccounting monthlyRation = (HrorderlyMonthlyRationAccounting) hbt
						.load(HrorderlyMonthlyRationAccounting.class, Integer
								.parseInt(monthlyRationId.get(i).toString()));

				if (porNo.get(i) != null && !porNo.get(i).equals("")) {
					monthlyRation.setPorNo(porNo.toString());
				}

				if (porNo.get(i) != null && !porNo.get(i).equals("")) {
					monthlyRation.setOccurenceNo(occurrenceNo.toString());
				}

				hbt.update(monthlyRation);

			}
		} catch (Exception e) {
			successfullyAdded = false;
			e.printStackTrace();
		}

		successfullyAdded = true;

		return successfullyAdded;
	}

	public boolean submitLeavePendingEntry(Box box) {
		boolean successfullyAdded = false;
		int leaveId = 0;
		String approvedstatus = "";
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			HrorderlyLeaveApplication hrorderlyLeave = (HrorderlyLeaveApplication) hbt
					.load(HrorderlyLeaveApplication.class, box
							.getInt("leaveId"));

			if (box.getString("approved") != null
					&& !box.getString("approved").equals("")) {
				hrorderlyLeave.setApprovedStatus(box.getString("approved"));
				approvedstatus = box.getString("approved");

			}
			if (box.getInt("approvedBy") != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(box.getInt("approvedBy"));
				hrorderlyLeave.setApprovedBy(masEmployee);
			}

			if (box.getString("approvedDate") != null
					&& !box.getString("approvedDate").equals("")) {
				hrorderlyLeave.setApprovedDate(HMSUtil
						.convertStringTypeDateToDateType((box
								.getString("approvedDate"))));
			}

			if (box.getString("remarks") != null
					&& !box.getString("remarks").equals("")) {
				hrorderlyLeave.setRemarks(box.getString("remarks"));
			}

			if (box.getString("changedBy") != null
					&& !box.getString("changedBy").equals("")) {
				hrorderlyLeave.setLstChangedBy(box.getString("changedBy"));
			}

			if (box.getString("changedDate") != null
					&& !box.getString("changedDate").equals("")) {
				hrorderlyLeave.setLstChangedDate(HMSUtil
						.convertStringTypeDateToDateType((box
								.getString("changedDate"))));
			}

			if (box.getString("changedTime") != null
					&& !box.getString("changedTime").equals("")) {
				hrorderlyLeave.setLstChangedTime(box.getString("changedTime"));
			}

			hbt.update(hrorderlyLeave);
			hbt.refresh(hrorderlyLeave);
			Criteria crt = session.createCriteria(MasEmployee.class)
					.add(
							Restrictions.eq("Id", hrorderlyLeave.getEmployee()
									.getId()));
			List<MasEmployee> masemployeeList = crt.list();
			MasEmployee masemployee = masemployeeList.get(0);
			masemployee.setStatus("y");
			session.saveOrUpdate(masemployee);
			if (approvedstatus.equals("y")) {
				if (box.getString("totalLeaveDays") != null
						&& !box.getString("totalLeaveDays").equals("")) {
					int leaveavailed = Integer.parseInt(box
							.getString("totalLeaveDays"));
					Criteria crt1 = session.createCriteria(
							HrorderlyLeaveAccount.class).add(
							Restrictions.eq("EmployeeId", hrorderlyLeave
									.getEmployee().getId())).add(
							Restrictions.eq("LeaveTypeId", hrorderlyLeave
									.getLeave().getId()));
					List<HrorderlyLeaveAccount> hrorderlyleaveaccountList = crt1
							.list();
					if (hrorderlyleaveaccountList.size() > 0) {
						HrorderlyLeaveAccount hrorderlyleaveaccount = (HrorderlyLeaveAccount) hrorderlyleaveaccountList
								.get(0);
						leaveavailed = leaveavailed
								+ hrorderlyleaveaccount.getLeaveAvailed();
						hrorderlyleaveaccount.setLeaveAvailed(leaveavailed);
						session.saveOrUpdate(hrorderlyleaveaccount);
					}
				}
			}

		} catch (DataAccessException e) {
			successfullyAdded = false;
			e.printStackTrace();
		}
		successfullyAdded = true;
		return successfullyAdded;
	}

	/**
	 * -------------------------- Guard Duty Entry ------------------- Started
	 * on 27th May '09
	 */

	public Map<String, Object> showGuardDutyEntryJsp() {
		Map<String, Object> map = new HashMap<String, Object>();

		List<HrDutyMaster> dutyList = new ArrayList<HrDutyMaster>();
		List<HrDutyTimeMaster> dutyMasterList = new ArrayList<HrDutyTimeMaster>();
		List<HrorderlyGuardDutyEntry> guardDutyListForEntryNo = new ArrayList<HrorderlyGuardDutyEntry>();
		MasDepartmentType masdepartmenttype = null;
		List<MasDepartment> masdepartmentList = new ArrayList<MasDepartment>();

		Session session = (Session) getSession();
		String entryNo = "";
		try {
			dutyList = session.createCriteria(HrDutyMaster.class).add(
					Restrictions.eq("DutyName", "Guard Duty")).add(
					Restrictions.eq("Status", "y")).list();
			guardDutyListForEntryNo = session.createCriteria(
					HrorderlyGuardDutyEntry.class).add(
					Restrictions.eq("Status", "y")).list();
			dutyMasterList = session.createCriteria(HrDutyTimeMaster.class)
					.add(Restrictions.eq("Status", "y")).list();
			Set<String> guardDutySetForEntryNoSet = new TreeSet<String>();
			for (HrorderlyGuardDutyEntry hrorderlyGuardDutyEntry : guardDutyListForEntryNo) {
				guardDutySetForEntryNoSet.add(hrorderlyGuardDutyEntry
						.getEntryNo());
			}
			masdepartmenttype = (MasDepartmentType) session.createCriteria(
					MasDepartmentType.class).add(
					Restrictions.eq("DepartmentTypeName",
							"Gaurd Duty Locations")).list().get(0);
			if (masdepartmenttype != null) {
				masdepartmentList = session.createCriteria(MasDepartment.class)
						.createAlias("DepartmentType", "dt").add(
								Restrictions.eq("dt.Id", masdepartmenttype
										.getId())).list();
			}
			//System.out.println("guardDutySetForEntryNoSet"+ guardDutySetForEntryNoSet.size());
			entryNo = getEntrySeqForGuardDutyDisplay();
			map.put("entryNo", entryNo);
			map.put("dutyId", dutyList.get(0).getId());
			map.put("dutyEntryList", guardDutyListForEntryNo);
			map.put("dutyMasterList", dutyMasterList);
			map.put("masdepartmentList", masdepartmentList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> searchGuardDutyPerformed(Date dutydate) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrorderlyGuardDutyEntry> hrorderlyGuardDutyEntryList = new ArrayList<HrorderlyGuardDutyEntry>();
		Criteria criteria = session.createCriteria(
				HrorderlyGuardDutyEntry.class).add(
				Restrictions.eq("DutyDate", dutydate)).add(
				Restrictions.eq("Status", "w"));
		hrorderlyGuardDutyEntryList = criteria.list();
		map.put("hrorderlyGuardDutyEntryList", hrorderlyGuardDutyEntryList);
		return map;
	}

	public boolean updateGuardDutyPerformed(Map<String, Object> generalMap) {
		boolean successfull = false;
		List<HrorderlyGuardDutyEntry> hrorderlyGuardDutyEntryList = new ArrayList<HrorderlyGuardDutyEntry>();
		Vector<String> hrorderlyGuardDutyIds = null;
		Vector<String> DutyIds = null;
		Date dutydate = null;
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = (Box) generalMap.get("box");
		dutydate = (Date) generalMap.get("dutydate");
		hrorderlyGuardDutyIds = box.getVector("hrorderlyGuardDutyAdded");
		DutyIds = box.getVector("dutyId");
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Criteria criteria = session.createCriteria(
				HrorderlyGuardDutyEntry.class).add(
				Restrictions.eq("DutyDate", dutydate)).add(
				Restrictions.eq("Status", "w"));
		hrorderlyGuardDutyEntryList = criteria.list();
		//System.out.println("hrorderlyGuardDutyIds::"+ hrorderlyGuardDutyIds.size() + "::DutyIds:;" + DutyIds.size()+ ";;hrorderlyGuardDutyEntryList;;"+ hrorderlyGuardDutyEntryList.size());
		HrorderlyGuardDutyEntry hrorderlyguardduty = null;
		try {
			for (int i = 0; i < DutyIds.size(); i++) {
				//System.out.println("i::" + i);
				if (hrorderlyGuardDutyIds.contains(DutyIds.get(i))) {
					hrorderlyguardduty = (HrorderlyGuardDutyEntry) hrorderlyGuardDutyEntryList
							.get(i);
					hrorderlyguardduty.setStatus("y");
					hbt.save(hrorderlyguardduty);
					hbt.refresh(hrorderlyguardduty);

				} else {
					hrorderlyguardduty = (HrorderlyGuardDutyEntry) hrorderlyGuardDutyEntryList
							.get(i);
					hrorderlyguardduty.setStatus("n");
					hbt.save(hrorderlyguardduty);
					hbt.refresh(hrorderlyguardduty);
				}
			}
			successfull = true;
		} catch (Exception exc) {
			successfull = false;
		}

		return successfull;
	}

	public Map<String, Object> getEmployeeDetailsForGuardDutyAdd(Box box) {
		PagedArray pagedArray = null;
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<HrDutyTimeMaster> dutyTimeMasterList = new ArrayList<HrDutyTimeMaster>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		session = (Session) getSession();

		map = getGridDataForGuardEmployeeAdd(box);
		map.put("employeeList", employeeList);
		map.put("departmentList", departmentList);
		map.put("dutyTimeMasterList", dutyTimeMasterList);
		return map;
	}

	public Map<String, Object> getGridDataForGuardEmployeeAdd(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = (Map<String, Object>) HMSUtil
				.getCurrentDateAndTime();
		session = (Session) getSession();

		int id = 0;

		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;
		List objectList = new ArrayList();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasEmployee> employeeDetailList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasRank> rankList1 = new ArrayList<MasRank>();
		List<HrDutyTimeMaster> dutyTimeMasterList = new ArrayList<HrDutyTimeMaster>();
		List<HrorderlyLeaveApplication> leaveMaintenanceList = new ArrayList<HrorderlyLeaveApplication>();
		List<HrDutyExemptionEntry> dutyExemptionList = new ArrayList<HrDutyExemptionEntry>();
		List<HrorderlyGuardDutyEntry> hrorderlyGuardDutyEntry = new ArrayList<HrorderlyGuardDutyEntry>();
		List<HrorderlyGuardDutyEntry> GuardDutyHoliDay = new ArrayList<HrorderlyGuardDutyEntry>();
		MasDepartmentType masdepartmenttype = null;
		List<MasDepartment> masdepartmentList = new ArrayList<MasDepartment>();

		try {
			rankList1 = session
					.createSQLQuery(
							"select rank_code from mas_rank as mr where mr.rank_code>26 and mr.service_type_id in(1,2,6) and mr.rank_category_id=3 and service_status_id=1")
					.list();
			Object rankArray[] = rankList1.toArray();

			Criteria ctr = session.createCriteria(MasEmployee.class).add(
					Restrictions.ne("Status", "n")).createAlias("Trade", "tr")
					.add(Restrictions.ne("tr.Id", 2)).add(
							Restrictions.ne("tr.Id", 7)).createAlias("Rank",
							"mr")
					.add(Restrictions.in("mr.RankCode", rankArray));
			employeeList = ctr.list();

			departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).list();
			dutyTimeMasterList = session.createCriteria(HrDutyTimeMaster.class)
					.add(Restrictions.eq("Status", "y")).list();
			leaveMaintenanceList = session.createCriteria(
					HrorderlyLeaveApplication.class).add(
					Restrictions.ne("Status", "n")).addOrder(
					Order.desc("LeaveFromDate")).list();
			dutyExemptionList = session.createCriteria(
					HrDutyExemptionEntry.class).createAlias("Duty", "d").add(
					Restrictions.eq("d.DutyName", "Guard Duty")).list();
			hrorderlyGuardDutyEntry = session.createCriteria(
					HrorderlyGuardDutyEntry.class).add(
					Restrictions.eq("Status", "y")).addOrder(
					Order.desc("DutyDate")).list();
			GuardDutyHoliDay = session.createCriteria(
					HrorderlyGuardDutyEntry.class).add(
					Restrictions.eq("Status", "y")).createAlias("Emp", "emp")
					.addOrder(Order.desc("emp.Id")).addOrder(
							Order.desc("DutyDate")).list();
			List<MasDepartmentType> masDepartmentTypeList = new ArrayList<MasDepartmentType>();
			masDepartmentTypeList = (List<MasDepartmentType>) session
					.createCriteria(MasDepartmentType.class).add(
							Restrictions.eq("DepartmentTypeName",
									"Gaurd Duty Locations")).list();
			if (masDepartmentTypeList.size() != 0) {
				masdepartmenttype = masDepartmentTypeList.get(0);
			}
			if (masdepartmenttype != null) {
				masdepartmentList = session.createCriteria(MasDepartment.class)
						.createAlias("DepartmentType", "dt").add(
								Restrictions.eq("dt.Id", masdepartmenttype
										.getId())).list();
			}
			MasEmployee masemployee = null;

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		int pageno = 1;
		int numOfRows = 10;
		try {
			if (box.get("pageno") != null) {
				pageno = Integer.parseInt(box.getString("pageno"));
			}
		} catch (Exception e) {
			// e.printStackTrace();
			pageno = 1;
		}

		try {
			if (box.get("numOfRows") != null) {
				numOfRows = Integer.parseInt(box.getString("numOfRows"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("pageno", pageno);

		int first = (pageno - 1) * numOfRows;
		int totalRecords = 0;
		if (employeeList != null && employeeList.size() > 0) {

			// String qry="SELECT count(*) FROM mas_employee";
			try {
				// totalRecords =
				// Integer.parseInt(session.createSQLQuery(qry).list().get(0).toString());
				totalRecords = employeeList.size();
			} catch (Exception e) {
				totalRecords = 0;
			}
			map.put("totalRecords", totalRecords);

			double totalPages = 0.0;
			totalPages = (double) totalRecords / (double) numOfRows;
			Double d = new Double(Math.ceil(totalPages));
			map.put("totalPages", d.intValue());

			if ((totalRecords - first) < numOfRows)
				employeeDetailList = employeeList.subList(first, totalRecords);
			else
				employeeDetailList = employeeList.subList(first, numOfRows);

		}
		//System.out.println("employeeList::::::::::" + employeeList.size()+ "employeeDetailList:::" + employeeDetailList.size());
		//System.out.println("first:::" + first + "numOfRows::" + numOfRows+ "totalRecords::" + totalRecords + "pageno::" + pageno);
		map.put("employeeDetailList", employeeDetailList);
		map.put("dutyExemptionList", dutyExemptionList);
		map.put("leaveMaintenanceList", leaveMaintenanceList);
		map.put("employeeList", employeeList);
		map.put("departmentList", departmentList);
		map.put("dutyTimeMasterList", dutyTimeMasterList);
		map.put("hrorderlyGuardDutyEntry", hrorderlyGuardDutyEntry);
		map.put("GuardDutyHoliDay", GuardDutyHoliDay);
		map.put("masdepartmentList", masdepartmentList);
		return map;
	}

	public Map<String, Object> searchGuardDutyData(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<HrorderlyGuardDutyEntry> searchGuardDutyList = new ArrayList<HrorderlyGuardDutyEntry>();
		List<HrorderlyGuardDutyEntry> GuardDutyListForEntryNo = new ArrayList<HrorderlyGuardDutyEntry>();
		List<HrDutyMaster> dutyList = new ArrayList<HrDutyMaster>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<HrDutyTimeMaster> dutyMasterList = new ArrayList<HrDutyTimeMaster>();
		List<HrorderlyGuardDutyEntry> guardDutyListForEntryNo = new ArrayList<HrorderlyGuardDutyEntry>();
		Set<String> guardDutySetForEntryNoSet = new TreeSet<String>();

		String entryNo = "";
		Session session = (Session) getSession();
		try {
			Criteria crit = session.createCriteria(
					HrorderlyGuardDutyEntry.class).add(
					Restrictions.eq("Status", "y"));
			if (!box.getString("searchEntryNo").equals("")) {
				crit = crit.add(Restrictions.eq("EntryNo", box
						.getString("searchEntryNo")));
			}
			if (!box.getString("searchEntryDate").equals("")) {
				crit = crit.add(Restrictions.eq("EntryDate", HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("searchEntryDate"))));
			}
			searchGuardDutyList = crit.list();
			GuardDutyListForEntryNo = session.createCriteria(
					HrorderlyGuardDutyEntry.class).add(
					Restrictions.eq("Status", "y")).list();
			dutyList = session.createCriteria(HrDutyMaster.class).add(
					Restrictions.eq("DutyName", "Guard Duty")).add(
					Restrictions.eq("Status", "y")).list();
			departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).list();
			dutyMasterList = session.createCriteria(HrDutyTimeMaster.class)
					.add(Restrictions.eq("Status", "y")).list();

			guardDutyListForEntryNo = session.createCriteria(
					HrorderlyGuardDutyEntry.class).add(
					Restrictions.eq("Status", "y")).list();
			for (HrorderlyGuardDutyEntry hrGuardDutyEntry : guardDutyListForEntryNo) {
				guardDutySetForEntryNoSet.add(hrGuardDutyEntry.getEntryNo());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		entryNo = getEntrySeqForGuardDutyDisplay();
		map.put("entryNo", entryNo);
		map.put("dutyEntryList", searchGuardDutyList);
		map.put("GuardDutyListForEntryNo", GuardDutyListForEntryNo);
		map.put("dutyId", dutyList.get(0).getId());
		map.put("departmentList", departmentList);
		map.put("dutyMasterList", dutyMasterList);
		map.put("guardDutySetForEntryNoSet", guardDutySetForEntryNoSet);

		return map;
	}

	public Map<String, Object> getEmployeeDetailsForGuardDuty(Box box) {

		Map<String, Object> map = new HashMap<String, Object>();

		map = getGridDataForGuardEmployee(box);

		return map;
	}

	public Map<String, Object> getGridDataForGuardEmployee(Box box) {
		// TODO Auto-generated method stub
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = (Map<String, Object>) HMSUtil
				.getCurrentDateAndTime();
		session = (Session) getSession();

		int id = 0;
		int deptId = 0;
		Date fromDate = null;
		Date toDate = null;
		if (!box.get("fromDate").equals(""))
			fromDate = HMSUtil.convertStringTypeDateToDateType(box
					.get("fromDate"));
		if (!box.get("toDate").equals(""))
			toDate = HMSUtil.convertStringTypeDateToDateType(box.get("toDate"));

		List<HrorderlyGuardDutyEntry> employeeList = new ArrayList<HrorderlyGuardDutyEntry>();
		List<HrorderlyGuardDutyEntry> dutyEntryList = new ArrayList<HrorderlyGuardDutyEntry>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<HrDutyTimeMaster> dutyMasterList = new ArrayList<HrDutyTimeMaster>();
		List<HrorderlyGuardDutyEntry> guardDutyListForEntryNo = new ArrayList<HrorderlyGuardDutyEntry>();
		MasDepartmentType masdepartmenttype = null;
		List<MasDepartment> masdepartmentList = new ArrayList<MasDepartment>();
		if (fromDate != null && toDate != null)
			employeeList = session
					.createCriteria(HrorderlyGuardDutyEntry.class).add(
							Restrictions.between("DutyDate", fromDate, toDate))
					.add(Restrictions.eq("Status", "y")).list();
		else
			employeeList = session
					.createCriteria(HrorderlyGuardDutyEntry.class).add(
							Restrictions.eq("Status", "y")).list();
		departmentList = session.createCriteria(MasDepartment.class).add(
				Restrictions.eq("Status", "y")).list();
		dutyMasterList = session.createCriteria(HrDutyTimeMaster.class).add(
				Restrictions.eq("Status", "y")).list();
		guardDutyListForEntryNo = session.createCriteria(
				HrorderlyGuardDutyEntry.class).add(
				Restrictions.eq("Status", "y")).list();
		List<MasDepartmentType> masDepartmentTypeList = new ArrayList<MasDepartmentType>();
		masDepartmentTypeList = (List<MasDepartmentType>) session
				.createCriteria(MasDepartmentType.class).add(
						Restrictions.eq("DepartmentTypeName",
								"Gaurd Duty Locations")).list();
		if (masDepartmentTypeList.size() != 0) {
			masdepartmenttype = masDepartmentTypeList.get(0);
		}
		if (masdepartmenttype != null) {
			masdepartmentList = session.createCriteria(MasDepartment.class)
					.createAlias("DepartmentType", "dt")
					.add(Restrictions.eq("dt.Id", masdepartmenttype.getId()))
					.list();
		}
		Set<String> guardDutySetForEntryNoSet = new TreeSet<String>();
		for (HrorderlyGuardDutyEntry hrGuardDutyEntry : guardDutyListForEntryNo) {
			guardDutySetForEntryNoSet.add(hrGuardDutyEntry.getEntryNo());
		}

		int pageno = 1;
		int numOfRows = 10;
		try {
			if (box.get("pageno") != null && !box.get("pageno").equals("")) {
				pageno = Integer.parseInt(box.getString("pageno"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			pageno = 1;
		}

		try {
			if (box.get("numOfRows") != null) {
				numOfRows = Integer.parseInt(box.getString("numOfRows"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("pageno", pageno);

		int first = (pageno - 1) * numOfRows;
		int totalRecords = 0;
		if (employeeList != null && employeeList.size() > 0) {

			try {
				totalRecords = employeeList.size();
			} catch (Exception e) {
				totalRecords = 0;
			}
			map.put("totalRecords", totalRecords);

			double totalPages = 0.0;
			totalPages = (double) totalRecords / (double) numOfRows;
			Double d = new Double(Math.ceil(totalPages));
			map.put("totalPages", d.intValue());

			if ((totalRecords - first) < numOfRows)
				dutyEntryList = employeeList.subList(first, totalRecords);
			else
				dutyEntryList = employeeList.subList(first, numOfRows);

		}
		List<HrDutyMaster> dutyList = new ArrayList<HrDutyMaster>();
		String entryNo = "";
		try {
			dutyList = session.createCriteria(HrDutyMaster.class).add(
					Restrictions.eq("DutyName", "Guard Duty")).add(
					Restrictions.eq("Status", "y")).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (dutyList.size() != 0) {
			map.put("dutyId", dutyList.get(0).getId());
		}
		entryNo = getEntrySeqForGuardDutyDisplay();
		map.put("entryNo", entryNo);
		map.put("dutyEntryList", dutyEntryList);
		map.put("box", box);
		map.put("guardDutySetForEntryNoSet", guardDutySetForEntryNoSet);
		map.put("employeeList", employeeList);
		map.put("departmentList", departmentList);
		map.put("dutyMasterList", dutyMasterList);
		map.put("masdepartmentList", masdepartmentList);
		return map;
	}

	public boolean AddGuardDutyEntry(Box box) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		Session session = (Session) getSession();

		List<TransactionSequence> entryNoList = new ArrayList<TransactionSequence>();
		String tableNameForTransactionSequence = "HrorderlyGuardDutyEntry";

		String empName = "";
		Vector empId = box.getVector("employeeId");
		Vector dutyDate = box.getVector("nextDutyDate");
		Vector dutyTime = box.getVector("dutyTimeId");
		Vector employeeAdded = box.getVector("employeeToBeAdded");
		Vector typeStatus = box.getVector("typeStatus");
		Vector departmenttype = box.getVector("Location");
		try {

			for (int i = 0; i < empId.size(); i++) {
				if (employeeAdded.contains(empId.get(i))) {
					//System.out.println("entered in the method");
					HrorderlyGuardDutyEntry hrorderlyGuardDutyEntry = new HrorderlyGuardDutyEntry();

					hrorderlyGuardDutyEntry
							.setEntryNo(box.getString("entryNo"));
					hrorderlyGuardDutyEntry.setEntryDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.getString("entryDate")));
					hrorderlyGuardDutyEntry.setTypeStatus(typeStatus.get(i)
							.toString());
					hrorderlyGuardDutyEntry.setStatus("w");

					HrDutyMaster hrDutyMaster = new HrDutyMaster();
					hrDutyMaster.setId(box.getInt("dutyId"));
					hrorderlyGuardDutyEntry.setDuty(hrDutyMaster);

					if (empId.get(i) != null && !empId.get(i).equals("")) {
						MasEmployee masEmployee = new MasEmployee();
						masEmployee.setId(Integer.parseInt(empId.get(i)
								.toString()));
						hrorderlyGuardDutyEntry.setEmp(masEmployee);
					}
					if (departmenttype.get(i) != null
							&& !departmenttype.get(i).equals("")) {
						MasDepartment masdepartment = new MasDepartment();
						masdepartment.setId(Integer.parseInt(departmenttype
								.get(i).toString()));
						hrorderlyGuardDutyEntry.setDepartmentId(masdepartment);
					}

					if (dutyDate.get(i) != null) {
						hrorderlyGuardDutyEntry.setDutyDate(HMSUtil
								.convertStringTypeDateToDateType((dutyDate
										.get(i).toString())));
						if ((HMSUtil.convertStringTypeDateToDateType((dutyDate
								.get(i).toString())).getDay()) == 0) {
							hrorderlyGuardDutyEntry.setHolidayStatus("y");
						} else {
							hrorderlyGuardDutyEntry.setHolidayStatus("n");
						}

					}
					if (dutyTime != null) {
						if (dutyTime.get(i) != null
								&& !dutyTime.get(i).equals("")) {
							HrDutyTimeMaster hrDutyTimeMaster = new HrDutyTimeMaster();
							hrDutyTimeMaster.setId(Integer.parseInt(dutyTime
									.get(i).toString()));
							hrorderlyGuardDutyEntry
									.setDutyTime(hrDutyTimeMaster);
						}
					}
					if (box.getString("changedBy") != null
							&& !box.getString("changedBy").equals("")) {
						hrorderlyGuardDutyEntry.setLastChgBy(box
								.getString("changedBy"));
					}

					if (box.getString("changedDate") != null
							&& !box.getString("changedDate").equals("")) {
						hrorderlyGuardDutyEntry.setLastChgDate(HMSUtil
								.convertStringTypeDateToDateType((box
										.getString("changedDate"))));
					}

					if (box.getString("changedTime") != null
							&& !box.getString("changedTime").equals("")) {
						hrorderlyGuardDutyEntry.setLastChgTime(box
								.getString("changedTime"));
					}

					MasHospital masHospital = new MasHospital();
					masHospital.setId(box.getInt("hospitalId"));
					hrorderlyGuardDutyEntry.setHospital(masHospital);

					hbt.save(hrorderlyGuardDutyEntry);
					hbt.refresh(hrorderlyGuardDutyEntry);

				}

			}
			entryNoList = session.createCriteria(TransactionSequence.class)
					.add(
							Restrictions.eq("Tablename",
									tableNameForTransactionSequence)).list();
			TransactionSequence transactionSequence = (TransactionSequence) entryNoList
					.get(0);
			int id = transactionSequence.getId();
			int entryNo = transactionSequence.getTransactionSequenceNumber();
			entryNo = entryNo + 1;
			TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
					.load(TransactionSequence.class, id);
			transactionSequenceObj.setTransactionSequenceNumber(entryNo);
			hbt.update(transactionSequenceObj);

		} catch (Exception e) {
			successfullyAdded = false;
			e.printStackTrace();
		}

		successfullyAdded = true;

		return successfullyAdded;
	}

	public Map<String, Object> getGuardEmployeeLastDutyDetails(Box box) {

		Map<String, Object> map = new HashMap<String, Object>();

		map = getGridDataForGuardLastDuty(box);

		return map;
	}

	public Map<String, Object> getGridDataForGuardLastDuty(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = (Map<String, Object>) HMSUtil
				.getCurrentDateAndTime();
		session = (Session) getSession();
		Date currentdate = new Date();
		int id = 0;

		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;

		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasEmployee> employeeDetailList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<HrDutyTimeMaster> dutyTimeMasterList = new ArrayList<HrDutyTimeMaster>();
		List<HrorderlyGuardDutyEntry> dutyEntryList = new ArrayList<HrorderlyGuardDutyEntry>();
		List<HrorderlyGuardDutyEntry> holidayEntryList = new ArrayList<HrorderlyGuardDutyEntry>();
		List<HrorderlyLeaveApplication> employeeLeaveList = new ArrayList<HrorderlyLeaveApplication>();
		List<OpdHoliday> holidayList = new ArrayList<OpdHoliday>();
		List<MasRank> rankList = new ArrayList<MasRank>();

		rankList = session
				.createSQLQuery(
						"select rank_code from mas_rank as mr where mr.rank_code>26 and mr.service_type_id in(1,2,6) and mr.rank_category_id=3 and service_status_id=1")
				.list();
		Object rankArray[] = rankList.toArray();

		Criteria ctr = session.createCriteria(MasEmployee.class).add(
				Restrictions.ne("Status", "n")).createAlias("Trade", "tr").add(
				Restrictions.ne("tr.Id", 2)).add(Restrictions.ne("tr.Id", 7))
				.createAlias("Rank", "mr").add(
						Restrictions.in("mr.RankCode", rankArray));
		employeeList = ctr.list();

		departmentList = session.createCriteria(MasDepartment.class).add(
				Restrictions.eq("Status", "y")).list();
		dutyTimeMasterList = session.createCriteria(HrDutyTimeMaster.class)
				.add(Restrictions.eq("Status", "y")).list();

		dutyEntryList = session.createCriteria(HrorderlyGuardDutyEntry.class)
				.createAlias("Emp", "me").add(
						Restrictions.eq("me.Id", Integer.parseInt(box
								.getString("empData")))).add(
						Restrictions.eq("Status", "y")).add(
						Restrictions.ne("HolidayStatus", "y")).list();

		holidayEntryList = session
				.createCriteria(HrorderlyGuardDutyEntry.class).createAlias(
						"Emp", "me").add(
						Restrictions.eq("me.Id", Integer.parseInt(box
								.getString("empData")))).add(
						Restrictions.eq("Status", "y")).add(
						Restrictions.eq("HolidayStatus", "y")).list();

		employeeLeaveList = session.createCriteria(
				HrorderlyLeaveApplication.class).createAlias("Employee", "me")
				.add(
						Restrictions.eq("me.Id", Integer.parseInt(box
								.getString("empData")))).add(
						Restrictions.gt("DateOfReporting", currentdate)).add(
						Restrictions.ne("Status", "n")).list();

		holidayList = session.createCriteria(OpdHoliday.class).add(
				Restrictions.eq("Status", "y")).list();

		int pageno = 1;
		int numOfRows = 10;
		try {
			if (box.get("pageno") != null) {
				pageno = Integer.parseInt(box.getString("pageno"));
			}
		} catch (Exception e) {
			// e.printStackTrace();
			pageno = 1;
		}

		try {
			if (box.get("numOfRows") != null) {
				numOfRows = Integer.parseInt(box.getString("numOfRows"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("pageno", pageno);

		int first = (pageno - 1) * numOfRows;
		int totalRecords = 0;
		if (employeeList != null && employeeList.size() > 0) {
			try {
				totalRecords = employeeList.size();
			} catch (Exception e) {
				totalRecords = 0;
			}
			map.put("totalRecords", totalRecords);

			double totalPages = 0.0;
			totalPages = (double) totalRecords / (double) numOfRows;
			Double d = new Double(Math.ceil(totalPages));
			map.put("totalPages", d.intValue());
			if ((totalRecords - first) < numOfRows) {
				employeeDetailList = employeeList.subList(first, totalRecords);
			} else {
				employeeDetailList = employeeList.subList(first, numOfRows);
			}

			//System.out.println("employeeDetailList=="+ employeeDetailList.size());
		}

		map.put("employeeDetailList", employeeDetailList);
		map.put("departmentList", departmentList);
		map.put("dutyTimeMasterList", dutyTimeMasterList);
		map.put("dutyEntryList", dutyEntryList);
		map.put("employeeLeaveList", employeeLeaveList);
		map.put("holidayEntryList", holidayEntryList);
		map.put("holidayList", holidayList);
		map.put("box", box);
		return map;
	}

	public boolean updateGuardDutyEntry(Box box) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		String empName = "";
		Vector dutyId = box.getVector("guardDutyId");
		Vector deptId = box.getVector("department");
		Vector dutyDate = box.getVector("nextDutyDate");
		Vector dutyTime = box.getVector("dutyTime");
		Vector remarks = box.getVector("remarks");
		Vector dutyToBeUpdated = box.getVector("dutyToBeUpdated");

		try {

			for (int i = 0; i < dutyId.size(); i++) {
				if (dutyToBeUpdated.contains(dutyId.get(i))) {
					HrorderlyGuardDutyEntry hrorderlyGuardDutyEntry = (HrorderlyGuardDutyEntry) hbt
							.load(HrorderlyGuardDutyEntry.class, Integer
									.parseInt(dutyId.get(i).toString()));

					if (dutyDate.get(i) != null && !dutyDate.get(i).equals("")) {
						hrorderlyGuardDutyEntry.setDutyDate(HMSUtil
								.convertStringTypeDateToDateType((dutyDate
										.get(i).toString())));
					}

					if (dutyTime.get(i) != null && !dutyTime.get(i).equals("")) {
						HrDutyTimeMaster hrDutyTimeMaster = new HrDutyTimeMaster();
						hrDutyTimeMaster.setId(Integer.parseInt(dutyTime.get(i)
								.toString()));
						hrorderlyGuardDutyEntry.setDutyTime(hrDutyTimeMaster);
					}
					hbt.update(hrorderlyGuardDutyEntry);
					hbt.refresh(hrorderlyGuardDutyEntry);
				}
			}
		} catch (Exception e) {
			successfullyAdded = false;
			e.printStackTrace();
		}

		successfullyAdded = true;

		return successfullyAdded;
	}

	public boolean deleteGuardDutyEntry(Box box) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		String empName = "";
		Vector dutyId = box.getVector("guardDutyId");
		Vector dutyToBeUpdated = box.getVector("dutyToBeUpdated");

		try {

			for (int i = 0; i < dutyId.size(); i++) {
				if (dutyToBeUpdated.contains(dutyId.get(i))) {
					HrorderlyGuardDutyEntry hrorderlyGuardDutyEntry = (HrorderlyGuardDutyEntry) hbt
							.load(HrorderlyGuardDutyEntry.class, Integer
									.parseInt(dutyId.get(i).toString()));

					hrorderlyGuardDutyEntry.setStatus("n");

					hbt.update(hrorderlyGuardDutyEntry);
				}
			}
		} catch (Exception e) {
			successfullyAdded = false;
			e.printStackTrace();
		}

		successfullyAdded = true;

		return successfullyAdded;
	}

	public Map<String, Object> searchGuardDutyEntry(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = (Map<String, Object>) HMSUtil
				.getCurrentDateAndTime();
		session = (Session) getSession();

		int id = 0;

		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;

		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasEmployee> employeeDetailList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<HrDutyTimeMaster> dutyTimeMasterList = new ArrayList<HrDutyTimeMaster>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<HrDutyExemptionEntry> dutyExemptionList = new ArrayList<HrDutyExemptionEntry>();
		String serviceNo = "";
		String empName = "";

		if (!box.getString("searchServiceNo").equals("")) {
			serviceNo = box.getString("searchServiceNo");
		}
		if (!box.getString("searchName").equals("")) {
			empName = box.getString("searchName");
		}
		session = (Session) getSession();

		rankList = session
				.createSQLQuery(
						"select rank_code from mas_rank as mr where mr.rank_code>26 and mr.service_type_id in(1,2,6) and mr.rank_category_id=3 and service_status_id=1")
				.list();
		Object rankArray[] = rankList.toArray();

		Criteria ctr = session.createCriteria(MasEmployee.class).add(
				Restrictions.ne("Status", "n")).createAlias("Trade", "tr").add(
				Restrictions.ne("tr.Id", 2)).add(Restrictions.ne("tr.Id", 7))
				.createAlias("Rank", "mr").add(
						Restrictions.in("mr.RankCode", rankArray));

		if (!serviceNo.equals("")) {
			ctr = ctr.add(Restrictions.like("ServiceNo", serviceNo + "%"));

		} else if (!empName.equals("")) {
			ctr = ctr.add(Restrictions.like("FirstName", empName + "%"));
		}
		employeeList = ctr.list();
		departmentList = session.createCriteria(MasDepartment.class).add(
				Restrictions.eq("Status", "y")).list();
		dutyTimeMasterList = session.createCriteria(HrDutyTimeMaster.class)
				.add(Restrictions.eq("Status", "y")).list();
		int pageno = 1;
		int numOfRows = 10;

		try {
			if (box.get("numOfRows") != null) {
				numOfRows = Integer.parseInt(box.getString("numOfRows"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("pageno", pageno);

		int first = (pageno - 1) * numOfRows;
		int totalRecords = 0;
		if (employeeList != null && employeeList.size() > 0) {

			// String qry="SELECT count(*) FROM mas_employee";
			try {
				// totalRecords =
				// Integer.parseInt(session.createSQLQuery(qry).list().get(0).toString());
				totalRecords = employeeList.size();
			} catch (Exception e) {
				totalRecords = 0;
			}
			map.put("totalRecords", totalRecords);

			double totalPages = 0.0;
			totalPages = (double) totalRecords / (double) numOfRows;
			Double d = new Double(Math.ceil(totalPages));
			map.put("totalPages", d.intValue());

			if ((totalRecords - first) < numOfRows)
				employeeDetailList = employeeList.subList(first, totalRecords);
			else
				employeeDetailList = employeeList.subList(first, numOfRows);

		}
		dutyExemptionList = session.createCriteria(HrDutyExemptionEntry.class)
				.list();
		map.put("dutyExemptionList", dutyExemptionList);
		map.put("employeeDetailList", employeeDetailList);
		map.put("employeeList", employeeList);
		map.put("departmentList", departmentList);
		map.put("dutyTimeMasterList", dutyTimeMasterList);
		map.put("box", box);
		return map;
	}

	public String getEntrySeqForGuardDutyDisplay() {
		List<TransactionSequence> orderSeqNoList = new ArrayList<TransactionSequence>();
		List<HrorderlyGuardDutyEntry> seqNoList = new ArrayList<HrorderlyGuardDutyEntry>();
		String entrySeqNo = "";
		String lastSeqNo = "";
		String lastSeqYear = "";

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");

		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		try {
			seqNoList = session.createCriteria(HrorderlyGuardDutyEntry.class)
					.list();
			if (seqNoList.size() > 0) {
				for (HrorderlyGuardDutyEntry hrGuardDutyEntry : seqNoList) {
					lastSeqNo = hrGuardDutyEntry.getEntryNo();
				}
				StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
				while (str.hasMoreTokens()) {
					lastSeqYear = str.nextToken();
				}
			} else {
				lastSeqYear = currentYear;
			}

			orderSeqNoList = session.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "GDEN")).list();
			// .setProjection(Projections.projectionList().add(Projections.max("TransactionSequenceNumber")))
			//System.out.println("orderSeqNoList:::" + orderSeqNoList.size());
			if (orderSeqNoList != null && orderSeqNoList.size() > 0) {
				for (TransactionSequence maxOrderNo : orderSeqNoList) {
					if (currentYear.equals(lastSeqYear)) {
						entrySeqNo = String.valueOf(maxOrderNo
								.getTransactionSequenceNumber() + 1);
					} else {
						entrySeqNo = String.valueOf(1);

					}
				}
			} else {
				entrySeqNo = String.valueOf(1);
				TransactionSequence transactionSequence = new TransactionSequence();
				transactionSequence.setTransactionPrefix("GDEN");
				transactionSequence
						.setTransactionSequenceName("Guard Duty Entry No.");
				transactionSequence.setTransactionSequenceNumber(1);
				transactionSequence.setTablename("HrorderlyGuardDutyEntry");
				transactionSequence.setStatus("y");
				session.save(transactionSequence);
			}
			entrySeqNo = entrySeqNo.concat("/").concat(
					String.valueOf(lastSeqYear));
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return entrySeqNo;
	}

	/**
	 * -------------------------- Orderly Sgt Duty Entry -------------------
	 * Started on 27th May '09
	 */

	public Map<String, Object> showOrderlyDutyEntryJsp() {
		Map<String, Object> map = new HashMap<String, Object>();

		List<HrDutyMaster> dutyList = new ArrayList<HrDutyMaster>();
		List<HrDutyTimeMaster> dutyMasterList = new ArrayList<HrDutyTimeMaster>();
		List<HrOrderlySgtDutyEntry> sgtDutyListForEntryNo = new ArrayList<HrOrderlySgtDutyEntry>();
		Session session = (Session) getSession();
		String entryNo = "";
		try {
			dutyList = session.createCriteria(HrDutyMaster.class).add(
					Restrictions.eq("DutyName", "SGT Duty")).add(
					Restrictions.eq("Status", "y")).list();
			sgtDutyListForEntryNo = session.createCriteria(
					HrOrderlySgtDutyEntry.class).add(
					Restrictions.eq("Status", "y")).list();
			dutyMasterList = session.createCriteria(HrDutyTimeMaster.class)
					.add(Restrictions.eq("Status", "y")).list();
			Set<String> sgtDutySetForEntryNoSet = new TreeSet<String>();
			for (HrOrderlySgtDutyEntry hrorderlySgtDutyEntry : sgtDutyListForEntryNo) {
				sgtDutySetForEntryNoSet.add(hrorderlySgtDutyEntry.getEntryNo());
			}
			//System.out.println("sgtDutySetForEntryNoSet"+ sgtDutySetForEntryNoSet.size());
			entryNo = getEntrySeqForOrderlyDutyDisplay();
			map.put("entryNo", entryNo);
			map.put("dutyId", dutyList.get(0).getId());
			map.put("dutyEntryList", sgtDutyListForEntryNo);
			map.put("dutyMasterList", dutyMasterList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> getEmployeeDetailsForOrderlyDutyAdd(Box box) {
		PagedArray pagedArray = null;
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<HrDutyTimeMaster> dutyTimeMasterList = new ArrayList<HrDutyTimeMaster>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		session = (Session) getSession();

		map = getGridDataForOrderlyEmployeeAdd(box);
		map.put("employeeList", employeeList);
		map.put("departmentList", departmentList);
		map.put("dutyTimeMasterList", dutyTimeMasterList);
		return map;
	}

	public Map<String, Object> getGridDataForOrderlyEmployeeAdd(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = (Map<String, Object>) HMSUtil
				.getCurrentDateAndTime();
		session = (Session) getSession();

		int id = 0;

		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;

		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasEmployee> employeeDetailList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<HrDutyTimeMaster> dutyTimeMasterList = new ArrayList<HrDutyTimeMaster>();
		List<HrorderlyLeaveApplication> leaveMaintenanceList = new ArrayList<HrorderlyLeaveApplication>();
		List<HrDutyExemptionEntry> dutyExemptionList = new ArrayList<HrDutyExemptionEntry>();
		List<HrOrderlySgtDutyEntry> SgtDutyHoliDay = new ArrayList<HrOrderlySgtDutyEntry>();
		Integer[] ServiceTypevalues = { 1, 2, 6 };
		Integer[] rankids;
		try {
			rankList = session.createCriteria(MasRank.class).createAlias(
					"ServiceType", "st").add(
					Restrictions.in("st.Id", ServiceTypevalues)).createAlias(
					"RankCategory", "rc").add(Restrictions.eq("rc.Id", 3))
					.createAlias("ServiceStatus", "ss").add(
							Restrictions.eq("ss.Id", 1)).list();
			//System.out.println("rankList:::" + rankList.size());

			Criteria ctr = session.createCriteria(MasEmployee.class).add(
					Restrictions.ne("Status", "n")).createAlias("Trade", "tr")
					.add(Restrictions.ne("tr.Id", 2)).add(
							Restrictions.ne("tr.Id", 7)).createAlias("Rank",
							"mr").add(Restrictions.eq("mr.RankCode", "26"))
					.createAlias("mr.ServiceType", "st").add(
							Restrictions.in("st.Id", ServiceTypevalues))
					.createAlias("mr.RankCategory", "rc").add(
							Restrictions.eq("rc.Id", 3)).createAlias(
							"mr.ServiceStatus", "ss").add(
							Restrictions.eq("ss.Id", 1));
			employeeList = ctr.list();

			departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).list();
			dutyTimeMasterList = session.createCriteria(HrDutyTimeMaster.class)
					.add(Restrictions.eq("Status", "y")).list();
			leaveMaintenanceList = session.createCriteria(
					HrorderlyLeaveApplication.class).add(
					Restrictions.ne("Status", "n")).addOrder(
					Order.desc("LeaveFromDate")).list();
			dutyExemptionList = session.createCriteria(
					HrDutyExemptionEntry.class).createAlias("Duty", "d").add(
					Restrictions.eq("d.DutyName", "Guard Duty")).list();
			SgtDutyHoliDay = session
					.createCriteria(HrOrderlySgtDutyEntry.class).add(
							Restrictions.eq("Status", "y")).createAlias("Emp",
							"emp").addOrder(Order.desc("emp.Id")).addOrder(
							Order.desc("DutyDate")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		int pageno = 1;
		int numOfRows = 10;
		try {
			if (box.get("pageno") != null) {
				pageno = Integer.parseInt(box.getString("pageno"));
			}
		} catch (Exception e) {
			// e.printStackTrace();
			pageno = 1;
		}

		try {
			if (box.get("numOfRows") != null) {
				numOfRows = Integer.parseInt(box.getString("numOfRows"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("pageno", pageno);

		int first = (pageno - 1) * numOfRows;
		int totalRecords = 0;
		if (employeeList != null && employeeList.size() > 0) {

			// String qry="SELECT count(*) FROM mas_employee";
			try {
				// totalRecords =
				// Integer.parseInt(session.createSQLQuery(qry).list().get(0).toString());
				totalRecords = employeeList.size();
			} catch (Exception e) {
				totalRecords = 0;
			}
			map.put("totalRecords", totalRecords);

			double totalPages = 0.0;
			totalPages = (double) totalRecords / (double) numOfRows;
			Double d = new Double(Math.ceil(totalPages));
			map.put("totalPages", d.intValue());

			if ((totalRecords - first) < numOfRows)
				employeeDetailList = employeeList.subList(first, totalRecords);
			else
				employeeDetailList = employeeList.subList(first, numOfRows);

		}
		map.put("employeeDetailList", employeeDetailList);
		map.put("dutyExemptionList", dutyExemptionList);
		map.put("leaveMaintenanceList", leaveMaintenanceList);
		map.put("employeeList", employeeList);
		map.put("departmentList", departmentList);
		map.put("dutyTimeMasterList", dutyTimeMasterList);
		map.put("SgtDutyHoliDay", SgtDutyHoliDay);
		map.put("box", box);
		return map;
	}

	public Map<String, Object> searchOrderlyDutyData(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<HrOrderlySgtDutyEntry> searchGuardDutyList = new ArrayList<HrOrderlySgtDutyEntry>();
		List<HrOrderlySgtDutyEntry> SgtDutyListForEntryNo = new ArrayList<HrOrderlySgtDutyEntry>();
		List<HrDutyMaster> dutyList = new ArrayList<HrDutyMaster>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<HrDutyTimeMaster> dutyMasterList = new ArrayList<HrDutyTimeMaster>();
		List<HrOrderlySgtDutyEntry> sgtDutyListForEntryNo = new ArrayList<HrOrderlySgtDutyEntry>();
		Set<String> sgtDutySetForEntryNoSet = new TreeSet<String>();

		String entryNo = "";
		Session session = (Session) getSession();
		try {
			Criteria crit = session.createCriteria(HrOrderlySgtDutyEntry.class)
					.add(Restrictions.eq("Status", "y"));
			if (!box.getString("searchEntryNo").equals("")) {
				crit = crit.add(Restrictions.eq("EntryNo", box
						.getString("searchEntryNo")));
			}
			if (!box.getString("searchEntryDate").equals("")) {
				crit = crit.add(Restrictions.eq("EntryDate", HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("searchEntryDate"))));
			}
			searchGuardDutyList = crit.list();
			SgtDutyListForEntryNo = session.createCriteria(
					HrOrderlySgtDutyEntry.class).add(
					Restrictions.eq("Status", "y")).list();
			dutyList = session.createCriteria(HrDutyMaster.class).add(
					Restrictions.eq("DutyName", "SGT Duty")).add(
					Restrictions.eq("Status", "y")).list();
			departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).list();
			dutyMasterList = session.createCriteria(HrDutyTimeMaster.class)
					.add(Restrictions.eq("Status", "y")).list();

			sgtDutyListForEntryNo = session.createCriteria(
					HrOrderlySgtDutyEntry.class).add(
					Restrictions.eq("Status", "y")).list();
			for (HrOrderlySgtDutyEntry hrGuardDutyEntry : sgtDutyListForEntryNo) {
				sgtDutySetForEntryNoSet.add(hrGuardDutyEntry.getEntryNo());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		entryNo = getEntrySeqForOrderlyDutyDisplay();
		map.put("entryNo", entryNo);
		map.put("dutyEntryList", searchGuardDutyList);
		map.put("GuardDutyListForEntryNo", SgtDutyListForEntryNo);
		map.put("dutyId", dutyList.get(0).getId());
		map.put("departmentList", departmentList);
		map.put("dutyMasterList", dutyMasterList);
		map.put("guardDutySetForEntryNoSet", sgtDutySetForEntryNoSet);

		return map;
	}

	public Map<String, Object> getEmployeeDetailsForOrderlyDuty(Box box) {

		Map<String, Object> map = new HashMap<String, Object>();

		map = getGridDataForOrderlyEmployee(box);

		return map;
	}

	public Map<String, Object> getGridDataForOrderlyEmployee(Box box) {
		// TODO Auto-generated method stub
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = (Map<String, Object>) HMSUtil
				.getCurrentDateAndTime();
		session = (Session) getSession();

		int id = 0;
		int deptId = 0;
		Date fromDate = null;
		Date toDate = null;
		if (!box.get("fromDate").equals(""))
			fromDate = HMSUtil.convertStringTypeDateToDateType(box
					.get("fromDate"));
		if (!box.get("toDate").equals(""))
			toDate = HMSUtil.convertStringTypeDateToDateType(box.get("toDate"));

		List<HrOrderlySgtDutyEntry> employeeList = new ArrayList<HrOrderlySgtDutyEntry>();
		List<HrOrderlySgtDutyEntry> dutyEntryList = new ArrayList<HrOrderlySgtDutyEntry>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<HrDutyTimeMaster> dutyMasterList = new ArrayList<HrDutyTimeMaster>();
		List<HrOrderlySgtDutyEntry> guardDutyListForEntryNo = new ArrayList<HrOrderlySgtDutyEntry>();
		if (fromDate != null && toDate != null)
			employeeList = session.createCriteria(HrOrderlySgtDutyEntry.class)
					.add(Restrictions.between("DutyDate", fromDate, toDate))
					.add(Restrictions.eq("Status", "y")).list();
		else
			employeeList = session.createCriteria(HrOrderlySgtDutyEntry.class)
					.add(Restrictions.eq("Status", "y")).list();
		departmentList = session.createCriteria(MasDepartment.class).add(
				Restrictions.eq("Status", "y")).list();
		dutyMasterList = session.createCriteria(HrDutyTimeMaster.class).add(
				Restrictions.eq("Status", "y")).list();
		guardDutyListForEntryNo = session.createCriteria(
				HrOrderlySgtDutyEntry.class)
				.add(Restrictions.eq("Status", "y")).list();
		Set<String> guardDutySetForEntryNoSet = new TreeSet<String>();
		for (HrOrderlySgtDutyEntry hrGuardDutyEntry : guardDutyListForEntryNo) {
			guardDutySetForEntryNoSet.add(hrGuardDutyEntry.getEntryNo());
		}

		int pageno = 1;
		int numOfRows = 10;
		try {
			if (box.get("pageno") != null && !box.get("pageno").equals("")) {
				pageno = Integer.parseInt(box.getString("pageno"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			pageno = 1;
		}

		try {
			if (box.get("numOfRows") != null) {
				numOfRows = Integer.parseInt(box.getString("numOfRows"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("pageno", pageno);

		int first = (pageno - 1) * numOfRows;
		int totalRecords = 0;
		if (employeeList != null && employeeList.size() > 0) {

			try {
				totalRecords = employeeList.size();
			} catch (Exception e) {
				totalRecords = 0;
			}
			map.put("totalRecords", totalRecords);

			double totalPages = 0.0;
			totalPages = (double) totalRecords / (double) numOfRows;
			Double d = new Double(Math.ceil(totalPages));
			map.put("totalPages", d.intValue());

			if ((totalRecords - first) < numOfRows)
				dutyEntryList = employeeList.subList(first, totalRecords);
			else
				dutyEntryList = employeeList.subList(first, numOfRows);

		}
		List<HrDutyMaster> dutyList = new ArrayList<HrDutyMaster>();
		String entryNo = "";
		try {
			dutyList = session.createCriteria(HrDutyMaster.class).add(
					Restrictions.eq("DutyName", "Guard Duty")).add(
					Restrictions.eq("Status", "y")).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (dutyList.size() != 0) {
			map.put("dutyId", dutyList.get(0).getId());
		}
		entryNo = getEntrySeqForGuardDutyDisplay();
		map.put("entryNo", entryNo);
		map.put("dutyEntryList", dutyEntryList);
		map.put("guardDutySetForEntryNoSet", guardDutySetForEntryNoSet);
		map.put("employeeList", employeeList);
		map.put("departmentList", departmentList);
		map.put("dutyMasterList", dutyMasterList);
		map.put("box", box);
		return map;
	}

	public boolean AddOrderlyDutyEntry(Box box) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		Session session = (Session) getSession();

		List<TransactionSequence> entryNoList = new ArrayList<TransactionSequence>();
		String tableNameForTransactionSequence = "HrorderlySGTDutyEntry";

		String empName = "";
		Vector empId = box.getVector("employeeId");
		Vector dutyDate = box.getVector("nextDutyDate");
		Vector dutyTime = box.getVector("dutyTimeId");
		Vector employeeAdded = box.getVector("employeeToBeAdded");
		Vector typeStatus = box.getVector("typeStatus");
		try {

			for (int i = 0; i < empId.size(); i++) {
				if (employeeAdded.contains(empId.get(i))) {
					//System.out.println("entered in the method");
					HrOrderlySgtDutyEntry hrorderlyGuardDutyEntry = new HrOrderlySgtDutyEntry();

					hrorderlyGuardDutyEntry
							.setEntryNo(box.getString("entryNo"));
					hrorderlyGuardDutyEntry.setEntryDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.getString("entryDate")));
					hrorderlyGuardDutyEntry.setTypeStatus(typeStatus.get(i)
							.toString());
					hrorderlyGuardDutyEntry.setStatus("y");

					HrDutyMaster hrDutyMaster = new HrDutyMaster();
					hrDutyMaster.setId(box.getInt("dutyId"));
					hrorderlyGuardDutyEntry.setDuty(hrDutyMaster);

					if (empId.get(i) != null && !empId.get(i).equals("")) {
						MasEmployee masEmployee = new MasEmployee();
						masEmployee.setId(Integer.parseInt(empId.get(i)
								.toString()));
						hrorderlyGuardDutyEntry.setEmp(masEmployee);
					}

					if (dutyDate.get(i) != null) {
						hrorderlyGuardDutyEntry.setDutyDate(HMSUtil
								.convertStringTypeDateToDateType((dutyDate
										.get(i).toString())));
						if ((HMSUtil.convertStringTypeDateToDateType((dutyDate
								.get(i).toString())).getDay()) == 0) {
							hrorderlyGuardDutyEntry.setHolidayStatus("y");
						} else {
							hrorderlyGuardDutyEntry.setHolidayStatus("n");
						}
					}
					if (dutyTime != null) {
						if (dutyTime.get(i) != null
								&& !dutyTime.get(i).equals("")) {
							HrDutyTimeMaster hrDutyTimeMaster = new HrDutyTimeMaster();
							hrDutyTimeMaster.setId(Integer.parseInt(dutyTime
									.get(i).toString()));
							hrorderlyGuardDutyEntry
									.setDutyTime(hrDutyTimeMaster);
						}
					}
					if (box.getString("changedBy") != null
							&& !box.getString("changedBy").equals("")) {
						hrorderlyGuardDutyEntry.setLastChgBy(box
								.getString("changedBy"));
					}

					if (box.getString("changedDate") != null
							&& !box.getString("changedDate").equals("")) {
						hrorderlyGuardDutyEntry.setLastChgDate(HMSUtil
								.convertStringTypeDateToDateType((box
										.getString("changedDate"))));
					}

					if (box.getString("changedTime") != null
							&& !box.getString("changedTime").equals("")) {
						hrorderlyGuardDutyEntry.setLastChgTime(box
								.getString("changedTime"));
					}

					MasHospital masHospital = new MasHospital();
					masHospital.setId(box.getInt("hospitalId"));
					hrorderlyGuardDutyEntry.setHospital(masHospital);

					hbt.save(hrorderlyGuardDutyEntry);
					hbt.refresh(hrorderlyGuardDutyEntry);

				}

			}
			entryNoList = session.createCriteria(TransactionSequence.class)
					.add(
							Restrictions.eq("Tablename",
									tableNameForTransactionSequence)).list();
			TransactionSequence transactionSequence = (TransactionSequence) entryNoList
					.get(0);
			int id = transactionSequence.getId();
			int entryNo = transactionSequence.getTransactionSequenceNumber();
			entryNo = entryNo + 1;
			TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
					.load(TransactionSequence.class, id);
			transactionSequenceObj.setTransactionSequenceNumber(entryNo);
			hbt.update(transactionSequenceObj);

		} catch (Exception e) {
			successfullyAdded = false;
			e.printStackTrace();
		}

		successfullyAdded = true;

		return successfullyAdded;
	}

	public Map<String, Object> getOrderlyEmployeeLastDutyDetails(Box box) {
		PagedArray pagedArray = null;
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<HrDutyTimeMaster> dutyTimeMasterList = new ArrayList<HrDutyTimeMaster>();
		List<HrOrderlySgtDutyEntry> dutyEntryList = new ArrayList<HrOrderlySgtDutyEntry>();

		session = (Session) getSession();
		try {
			employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).list();
			departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).list();
			dutyTimeMasterList = session.createCriteria(HrDutyTimeMaster.class)
					.add(Restrictions.eq("Status", "y")).list();
			dutyEntryList = session.createCriteria(HrOrderlySgtDutyEntry.class)
					.createAlias("Emp", "me").add(
							Restrictions.eq("me.Id", Integer.parseInt(box
									.getString("empData")))).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("employeeList", employeeList);
		map.put("departmentList", departmentList);
		map.put("dutyTimeMasterList", dutyTimeMasterList);
		map.put("dutyEntryList", dutyEntryList);
		map = getGridDataForOrderlyLastDuty(box);

		return map;
	}

	public Map<String, Object> getGridDataForOrderlyLastDuty(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = (Map<String, Object>) HMSUtil
				.getCurrentDateAndTime();
		session = (Session) getSession();
		Date currentdate = new Date();
		int id = 0;

		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;

		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasEmployee> employeeDetailList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<HrDutyTimeMaster> dutyTimeMasterList = new ArrayList<HrDutyTimeMaster>();
		List<HrOrderlySgtDutyEntry> dutyEntryList = new ArrayList<HrOrderlySgtDutyEntry>();
		List<HrorderlyLeaveApplication> employeeLeaveList = new ArrayList<HrorderlyLeaveApplication>();
		List<HrorderlyLeaveApplication> leaveMaintenanceList = new ArrayList<HrorderlyLeaveApplication>();
		List<OpdHoliday> holidayList = new ArrayList<OpdHoliday>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<HrOrderlySgtDutyEntry> holidayEntryList = new ArrayList<HrOrderlySgtDutyEntry>();
		Integer[] ServiceTypevalues = { 1, 2, 6 };

		Criteria ctr = session.createCriteria(MasEmployee.class).add(
				Restrictions.ne("Status", "n")).createAlias("Trade", "tr").add(
				Restrictions.ne("tr.Id", 2)).add(Restrictions.ne("tr.Id", 7))
				.createAlias("Rank", "mr").add(
						Restrictions.eq("mr.RankCode", "26")).createAlias(
						"mr.ServiceType", "st").add(
						Restrictions.in("st.Id", ServiceTypevalues))
				.createAlias("mr.RankCategory", "rc").add(
						Restrictions.eq("rc.Id", 3)).createAlias(
						"mr.ServiceStatus", "ss").add(
						Restrictions.eq("ss.Id", 1));
		employeeList = ctr.list();
		rankList = session.createCriteria(MasRank.class).add(
				Restrictions.eq("RankName", "CPL")).list();
		departmentList = session.createCriteria(MasDepartment.class).add(
				Restrictions.eq("Status", "y")).list();
		dutyTimeMasterList = session.createCriteria(HrDutyTimeMaster.class)
				.add(Restrictions.eq("Status", "y")).list();

		holidayList = session.createCriteria(OpdHoliday.class).add(
				Restrictions.eq("Status", "y")).list();

		dutyEntryList = session.createCriteria(HrOrderlySgtDutyEntry.class)
				.createAlias("Emp", "me").add(
						Restrictions.eq("me.Id", Integer.parseInt(box
								.getString("empData")))).add(
						Restrictions.eq("Status", "y")).add(
						Restrictions.ne("HolidayStatus", "y")).list();

		holidayEntryList = session.createCriteria(HrOrderlySgtDutyEntry.class)
				.createAlias("Emp", "me").add(
						Restrictions.eq("me.Id", Integer.parseInt(box
								.getString("empData")))).add(
						Restrictions.eq("Status", "y")).add(
						Restrictions.eq("HolidayStatus", "y")).list();

		employeeLeaveList = session.createCriteria(
				HrorderlyLeaveApplication.class).createAlias("Employee", "me")
				.add(
						Restrictions.eq("me.Id", Integer.parseInt(box
								.getString("empData")))).add(
						Restrictions.gt("DateOfReporting", currentdate)).add(
						Restrictions.ne("Status", "n")).list();

		int pageno = 1;
		int numOfRows = 10;
		try {
			if (box.get("pageno") != null) {
				pageno = Integer.parseInt(box.getString("pageno"));
			}
		} catch (Exception e) {
			// e.printStackTrace();
			pageno = 1;
		}

		try {
			if (box.get("numOfRows") != null) {
				numOfRows = Integer.parseInt(box.getString("numOfRows"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("pageno", pageno);

		int first = (pageno - 1) * numOfRows;
		int totalRecords = 0;
		if (employeeList != null && employeeList.size() > 0) {
			try {
				totalRecords = employeeList.size();
			} catch (Exception e) {
				totalRecords = 0;
			}
			map.put("totalRecords", totalRecords);

			double totalPages = 0.0;
			totalPages = (double) totalRecords / (double) numOfRows;
			Double d = new Double(Math.ceil(totalPages));
			map.put("totalPages", d.intValue());

			if (totalRecords < numOfRows)
				employeeDetailList = employeeList.subList(first, totalRecords);
			else
				employeeDetailList = employeeList.subList(first, numOfRows);

			//System.out.println("employeeDetailList=="	+ employeeDetailList.size());
		}

		map.put("employeeDetailList", employeeDetailList);
		map.put("box", box);
		map.put("employeeList", employeeList);
		map.put("departmentList", departmentList);
		map.put("dutyTimeMasterList", dutyTimeMasterList);
		map.put("dutyEntryList", dutyEntryList);
		map.put("employeeLeaveList", employeeLeaveList);
		map.put("holidayList", holidayList);
		map.put("holidayEntryList", holidayEntryList);
		return map;
	}

	public boolean updateOrderlyDutyEntry(Box box) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		String empName = "";
		Vector dutyId = box.getVector("guardDutyId");
		Vector deptId = box.getVector("department");
		Vector dutyDate = box.getVector("nextDutyDate");
		Vector dutyTime = box.getVector("dutyTime");
		Vector remarks = box.getVector("remarks");
		Vector dutyToBeUpdated = box.getVector("dutyToBeUpdated");

		try {

			for (int i = 0; i < dutyId.size(); i++) {
				if (dutyToBeUpdated.contains(dutyId.get(i))) {
					HrOrderlySgtDutyEntry hrorderlyGuardDutyEntry = (HrOrderlySgtDutyEntry) hbt
							.load(HrOrderlySgtDutyEntry.class, Integer
									.parseInt(dutyId.get(i).toString()));

					if (dutyDate.get(i) != null && !dutyDate.get(i).equals("")) {
						hrorderlyGuardDutyEntry.setDutyDate(HMSUtil
								.convertStringTypeDateToDateType((dutyDate
										.get(i).toString())));
					}

					if (dutyTime.get(i) != null && !dutyTime.get(i).equals("")) {
						HrDutyTimeMaster hrDutyTimeMaster = new HrDutyTimeMaster();
						hrDutyTimeMaster.setId(Integer.parseInt(dutyTime.get(i)
								.toString()));
						hrorderlyGuardDutyEntry.setDutyTime(hrDutyTimeMaster);
					}
					hbt.update(hrorderlyGuardDutyEntry);
					hbt.refresh(hrorderlyGuardDutyEntry);
				}
			}
		} catch (Exception e) {
			successfullyAdded = false;
			e.printStackTrace();
		}

		successfullyAdded = true;

		return successfullyAdded;
	}

	public boolean deleteOrderlyDutyEntry(Box box) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		String empName = "";
		Vector dutyId = box.getVector("guardDutyId");
		Vector dutyToBeUpdated = box.getVector("dutyToBeUpdated");

		try {

			for (int i = 0; i < dutyId.size(); i++) {
				if (dutyToBeUpdated.contains(dutyId.get(i))) {
					HrOrderlySgtDutyEntry hrorderlyGuardDutyEntry = (HrOrderlySgtDutyEntry) hbt
							.load(HrOrderlySgtDutyEntry.class, Integer
									.parseInt(dutyId.get(i).toString()));

					hrorderlyGuardDutyEntry.setStatus("n");

					hbt.update(hrorderlyGuardDutyEntry);
				}
			}
		} catch (Exception e) {
			successfullyAdded = false;
			e.printStackTrace();
		}

		successfullyAdded = true;

		return successfullyAdded;
	}

	public Map<String, Object> searchOrderlyDutyEntry(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = (Map<String, Object>) HMSUtil
				.getCurrentDateAndTime();
		session = (Session) getSession();

		int id = 0;

		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;

		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasEmployee> employeeDetailList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<HrDutyTimeMaster> dutyTimeMasterList = new ArrayList<HrDutyTimeMaster>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<HrDutyExemptionEntry> dutyExemptionList = new ArrayList<HrDutyExemptionEntry>();
		String serviceNo = "";
		String empName = "";

		if (!box.getString("searchServiceNo").equals("")) {
			serviceNo = box.getString("searchServiceNo");
		}
		if (!box.getString("searchName").equals("")) {
			empName = box.getString("searchName");
		}
		session = (Session) getSession();
		rankList = session.createCriteria(MasRank.class).add(
				Restrictions.eq("RankName", "CPL")).list();
		dutyExemptionList = session.createCriteria(HrDutyExemptionEntry.class)
				.list();
		Integer[] ServiceTypevalues = { 1, 2, 6 };
		Criteria ctr = session.createCriteria(MasEmployee.class).add(
				Restrictions.ne("Status", "n")).createAlias("Trade", "tr").add(
				Restrictions.ne("tr.Id", 2)).add(Restrictions.ne("tr.Id", 7))
				.createAlias("Rank", "mr").add(
						Restrictions.eq("mr.RankCode", "26")).createAlias(
						"mr.ServiceType", "st").add(
						Restrictions.in("st.Id", ServiceTypevalues))
				.createAlias("mr.RankCategory", "rc").add(
						Restrictions.eq("rc.Id", 3)).createAlias(
						"mr.ServiceStatus", "ss").add(
						Restrictions.eq("ss.Id", 1));

		if (!serviceNo.equals("")) {
			ctr = ctr.add(Restrictions.like("ServiceNo", serviceNo + "%"));

		} else if (!empName.equals("")) {
			ctr = ctr.add(Restrictions.like("FirstName", empName + "%"));
		}
		employeeList = ctr.list();

		employeeList = ctr.list();
		departmentList = session.createCriteria(MasDepartment.class).add(
				Restrictions.eq("Status", "y")).list();
		dutyTimeMasterList = session.createCriteria(HrDutyTimeMaster.class)
				.add(Restrictions.eq("Status", "y")).list();

		int pageno = 1;
		int numOfRows = 10;

		try {
			if (box.get("numOfRows") != null) {
				numOfRows = Integer.parseInt(box.getString("numOfRows"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("pageno", pageno);

		int first = (pageno - 1) * numOfRows;
		int totalRecords = 0;
		if (employeeList != null && employeeList.size() > 0) {

			// String qry="SELECT count(*) FROM mas_employee";
			try {
				// totalRecords =
				// Integer.parseInt(session.createSQLQuery(qry).list().get(0).toString());
				totalRecords = employeeList.size();
			} catch (Exception e) {
				totalRecords = 0;
			}
			map.put("totalRecords", totalRecords);

			double totalPages = 0.0;
			totalPages = (double) totalRecords / (double) numOfRows;
			Double d = new Double(Math.ceil(totalPages));
			map.put("totalPages", d.intValue());

			if ((totalRecords - first) < numOfRows)
				employeeDetailList = employeeList.subList(first, totalRecords);
			else
				employeeDetailList = employeeList.subList(first, numOfRows);

		}
		map.put("employeeDetailList", employeeDetailList);
		map.put("employeeList", employeeList);
		map.put("departmentList", departmentList);
		map.put("dutyTimeMasterList", dutyTimeMasterList);
		map.put("dutyExemptionList", dutyExemptionList);
		map.put("box", box);
		return map;
	}

	public String getEntrySeqForOrderlyDutyDisplay() {
		List<TransactionSequence> orderSeqNoList = new ArrayList<TransactionSequence>();
		List<HrOrderlySgtDutyEntry> seqNoList = new ArrayList<HrOrderlySgtDutyEntry>();
		String entrySeqNo = "";
		String lastSeqNo = "";
		String lastSeqYear = "";

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");

		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		try {
			seqNoList = session.createCriteria(HrOrderlySgtDutyEntry.class)
					.list();
			if (seqNoList.size() > 0) {
				for (HrOrderlySgtDutyEntry hrGuardDutyEntry : seqNoList) {
					lastSeqNo = hrGuardDutyEntry.getEntryNo();
				}
				StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
				while (str.hasMoreTokens()) {
					lastSeqYear = str.nextToken();
				}
			} else {
				lastSeqYear = currentYear;
			}

			orderSeqNoList = session.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "SDEN")).list();
			// .setProjection(Projections.projectionList().add(Projections.max("TransactionSequenceNumber")))
			//System.out.println("orderSeqNoList:::" + orderSeqNoList.size());
			if (orderSeqNoList != null && orderSeqNoList.size() > 0) {
				for (TransactionSequence maxOrderNo : orderSeqNoList) {
					if (currentYear.equals(lastSeqYear)) {
						entrySeqNo = String.valueOf(maxOrderNo
								.getTransactionSequenceNumber() + 1);
					} else {
						entrySeqNo = String.valueOf(1);

					}
				}
			} else {
				entrySeqNo = String.valueOf(1);
				TransactionSequence transactionSequence = new TransactionSequence();
				transactionSequence.setTransactionPrefix("SDEN");
				transactionSequence
						.setTransactionSequenceName("SGT Duty Entry No.");
				transactionSequence.setTransactionSequenceNumber(1);
				transactionSequence.setTablename("HrOrderlySgtDutyEntry");
				transactionSequence.setStatus("y");
				session.save(transactionSequence);
			}
			entrySeqNo = entrySeqNo.concat("/").concat(
					String.valueOf(lastSeqYear));
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return entrySeqNo;
	}

	// *************************
	/**
	 * -------------------------- Orderly officer Duty Entry -------------------
	 * Started on 27th May '09
	 */

	public Map<String, Object> showOfficerDutyEntryJsp() {
		Map<String, Object> map = new HashMap<String, Object>();

		List<HrDutyMaster> dutyList = new ArrayList<HrDutyMaster>();
		List<HrDutyTimeMaster> dutyMasterList = new ArrayList<HrDutyTimeMaster>();
		List<HrorderlyOfficerDutyEntry> sgtDutyListForEntryNo = new ArrayList<HrorderlyOfficerDutyEntry>();
		Session session = (Session) getSession();
		String entryNo = "";
		try {
			dutyList = session.createCriteria(HrDutyMaster.class).add(
					Restrictions.eq("DutyName", "Officer Duty")).add(
					Restrictions.eq("Status", "y")).list();
			sgtDutyListForEntryNo = session.createCriteria(
					HrorderlyOfficerDutyEntry.class).add(
					Restrictions.eq("Status", "y")).list();
			dutyMasterList = session.createCriteria(HrDutyTimeMaster.class)
					.add(Restrictions.eq("Status", "y")).list();
			Set<String> sgtDutySetForEntryNoSet = new TreeSet<String>();
			for (HrorderlyOfficerDutyEntry hrorderlySgtDutyEntry : sgtDutyListForEntryNo) {
				sgtDutySetForEntryNoSet.add(hrorderlySgtDutyEntry.getEntryNo());
			}
			//System.out.println("sgtDutySetForEntryNoSet"+ sgtDutySetForEntryNoSet.size());
			entryNo = getEntrySeqForOfficerDutyDisplay();
			map.put("entryNo", entryNo);
			map.put("dutyId", dutyList.get(0).getId());
			map.put("dutyMasterList", dutyMasterList);
			map.put("dutyEntryList", sgtDutyListForEntryNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> getEmployeeDetailsForOfficerDutyAdd(Box box) {

		Map<String, Object> map = new HashMap<String, Object>();

		map = getGridDataForOfficerEmployeeAdd(box);

		return map;
	}

	public Map<String, Object> getGridDataForOfficerEmployeeAdd(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = (Map<String, Object>) HMSUtil
				.getCurrentDateAndTime();
		session = (Session) getSession();

		int id = 0;

		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;

		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasEmployee> employeeDetailList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasRank> objectList = new ArrayList<MasRank>();
		List<HrDutyTimeMaster> dutyTimeMasterList = new ArrayList<HrDutyTimeMaster>();
		List<HrLeaveMaintenance> leaveMaintenanceList = new ArrayList<HrLeaveMaintenance>();
		List<HrDutyExemptionEntry> dutyExemptionList = new ArrayList<HrDutyExemptionEntry>();
		List<HrorderlyOfficerDutyEntry> officerDutyHoliDay = new ArrayList<HrorderlyOfficerDutyEntry>();
		Integer[] rankids;
		try {
			rankList = session
					.createSQLQuery(
							"select rank_code from mas_rank as mr where mr.rank_code<26 and mr.service_type_id in(1,2,6) and mr.rank_category_id=3 and service_status_id=1")
					.list();
			Object rankArray[] = rankList.toArray();

			Criteria ctr = session.createCriteria(MasEmployee.class).add(
					Restrictions.ne("Status", "n")).createAlias("Trade", "tr")
					.add(Restrictions.ne("tr.Id", 2)).add(
							Restrictions.ne("tr.Id", 7)).createAlias("Rank",
							"mr")
					.add(Restrictions.in("mr.RankCode", rankArray));
			employeeList = ctr.list();

			departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).list();
			dutyTimeMasterList = session.createCriteria(HrDutyTimeMaster.class)
					.add(Restrictions.eq("Status", "y")).list();
			dutyExemptionList = session.createCriteria(
					HrDutyExemptionEntry.class).createAlias("Duty", "d").add(
					Restrictions.eq("d.DutyName", "Guard Duty")).list();
			officerDutyHoliDay = session.createCriteria(
					HrorderlyOfficerDutyEntry.class).add(
					Restrictions.eq("Status", "y")).createAlias("Emp", "emp")
					.addOrder(Order.desc("emp.Id")).addOrder(
							Order.desc("DutyDate")).list();
			leaveMaintenanceList = session.createCriteria(
					HrorderlyLeaveApplication.class).add(
					Restrictions.ne("Status", "n")).addOrder(
					Order.desc("LeaveFromDate")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		int pageno = 1;
		int numOfRows = 10;
		try {
			if (box.get("pageno") != null) {
				pageno = Integer.parseInt(box.getString("pageno"));
			}
		} catch (Exception e) {
			// e.printStackTrace();
			pageno = 1;
		}

		try {
			if (box.get("numOfRows") != null) {
				numOfRows = Integer.parseInt(box.getString("numOfRows"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("pageno", pageno);

		int first = (pageno - 1) * numOfRows;
		int totalRecords = 0;
		if (employeeList != null && employeeList.size() > 0) {

			// String qry="SELECT count(*) FROM mas_employee";
			try {
				// totalRecords =
				// Integer.parseInt(session.createSQLQuery(qry).list().get(0).toString());
				totalRecords = employeeList.size();
			} catch (Exception e) {
				totalRecords = 0;
			}
			map.put("totalRecords", totalRecords);

			double totalPages = 0.0;
			totalPages = (double) totalRecords / (double) numOfRows;
			Double d = new Double(Math.ceil(totalPages));
			map.put("totalPages", d.intValue());

			if ((totalRecords - first) < numOfRows)
				employeeDetailList = employeeList.subList(first, totalRecords);
			else
				employeeDetailList = employeeList.subList(first, numOfRows);

		}
		//System.out.println("employeeList::::::::::" + employeeList.size()	+ "employeeDetailList:::" + employeeDetailList.size());
		//System.out.println("first:::" + first + "numOfRows::" + numOfRows+ "totalRecords::" + totalRecords + "pageno::" + pageno);
		map.put("employeeDetailList", employeeDetailList);
		map.put("dutyExemptionList", dutyExemptionList);
		map.put("leaveMaintenanceList", leaveMaintenanceList);
		map.put("officerDutyHoliDay", officerDutyHoliDay);
		map.put("employeeList", employeeList);
		map.put("departmentList", departmentList);
		map.put("dutyTimeMasterList", dutyTimeMasterList);
		map.put("box", box);
		return map;
	}

	public Map<String, Object> searchOfficerDutyData(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<HrorderlyOfficerDutyEntry> searchGuardDutyList = new ArrayList<HrorderlyOfficerDutyEntry>();
		List<HrorderlyOfficerDutyEntry> SgtDutyListForEntryNo = new ArrayList<HrorderlyOfficerDutyEntry>();
		List<HrDutyMaster> dutyList = new ArrayList<HrDutyMaster>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<HrDutyTimeMaster> dutyMasterList = new ArrayList<HrDutyTimeMaster>();
		List<HrorderlyOfficerDutyEntry> sgtDutyListForEntryNo = new ArrayList<HrorderlyOfficerDutyEntry>();
		Set<String> sgtDutySetForEntryNoSet = new TreeSet<String>();

		String entryNo = "";
		Session session = (Session) getSession();
		try {
			Criteria crit = session.createCriteria(
					HrorderlyOfficerDutyEntry.class).add(
					Restrictions.eq("Status", "y"));
			if (!box.getString("searchEntryNo").equals("")) {
				crit = crit.add(Restrictions.eq("EntryNo", box
						.getString("searchEntryNo")));
			}
			if (!box.getString("searchEntryDate").equals("")) {
				crit = crit.add(Restrictions.eq("EntryDate", HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("searchEntryDate"))));
			}
			searchGuardDutyList = crit.list();
			SgtDutyListForEntryNo = session.createCriteria(
					HrorderlyOfficerDutyEntry.class).add(
					Restrictions.eq("Status", "y")).list();
			dutyList = session.createCriteria(HrDutyMaster.class).add(
					Restrictions.eq("DutyName", "SGT Duty")).add(
					Restrictions.eq("Status", "y")).list();
			departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).list();
			dutyMasterList = session.createCriteria(HrDutyTimeMaster.class)
					.add(Restrictions.eq("Status", "y")).list();

			sgtDutyListForEntryNo = session.createCriteria(
					HrorderlyOfficerDutyEntry.class).add(
					Restrictions.eq("Status", "y")).list();
			for (HrorderlyOfficerDutyEntry hrGuardDutyEntry : sgtDutyListForEntryNo) {
				sgtDutySetForEntryNoSet.add(hrGuardDutyEntry.getEntryNo());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		entryNo = getEntrySeqForOfficerDutyDisplay();
		map.put("entryNo", entryNo);
		map.put("dutyEntryList", searchGuardDutyList);
		map.put("GuardDutyListForEntryNo", SgtDutyListForEntryNo);
		map.put("dutyId", dutyList.get(0).getId());
		map.put("departmentList", departmentList);
		map.put("dutyMasterList", dutyMasterList);
		map.put("guardDutySetForEntryNoSet", sgtDutySetForEntryNoSet);

		return map;
	}

	public Map<String, Object> getEmployeeDetailsForOfficerDuty(Box box) {

		Map<String, Object> map = new HashMap<String, Object>();

		map = getGridDataForOfficerEmployee(box);

		return map;
	}

	public Map<String, Object> getGridDataForOfficerEmployee(Box box) {
		// TODO Auto-generated method stub
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = (Map<String, Object>) HMSUtil
				.getCurrentDateAndTime();
		session = (Session) getSession();

		int id = 0;
		int deptId = 0;
		Date fromDate = null;
		Date toDate = null;
		if (!box.get("fromDate").equals(""))
			fromDate = HMSUtil.convertStringTypeDateToDateType(box
					.get("fromDate"));
		if (!box.get("toDate").equals(""))
			toDate = HMSUtil.convertStringTypeDateToDateType(box.get("toDate"));

		List<HrorderlyOfficerDutyEntry> employeeList = new ArrayList<HrorderlyOfficerDutyEntry>();
		List<HrorderlyOfficerDutyEntry> dutyEntryList = new ArrayList<HrorderlyOfficerDutyEntry>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<HrDutyTimeMaster> dutyMasterList = new ArrayList<HrDutyTimeMaster>();
		List<HrorderlyOfficerDutyEntry> guardDutyListForEntryNo = new ArrayList<HrorderlyOfficerDutyEntry>();
		if (fromDate != null && toDate != null)
			employeeList = session.createCriteria(
					HrorderlyOfficerDutyEntry.class).add(
					Restrictions.between("DutyDate", fromDate, toDate)).add(
					Restrictions.eq("Status", "y")).list();
		else
			employeeList = session.createCriteria(
					HrorderlyOfficerDutyEntry.class).add(
					Restrictions.eq("Status", "y")).list();
		departmentList = session.createCriteria(MasDepartment.class).add(
				Restrictions.eq("Status", "y")).list();
		dutyMasterList = session.createCriteria(HrDutyTimeMaster.class).add(
				Restrictions.eq("Status", "y")).list();
		guardDutyListForEntryNo = session.createCriteria(
				HrorderlyOfficerDutyEntry.class).add(
				Restrictions.eq("Status", "y")).list();
		Set<String> guardDutySetForEntryNoSet = new TreeSet<String>();
		for (HrorderlyOfficerDutyEntry hrGuardDutyEntry : guardDutyListForEntryNo) {
			guardDutySetForEntryNoSet.add(hrGuardDutyEntry.getEntryNo());
		}

		int pageno = 1;
		int numOfRows = 10;
		try {
			if (box.get("pageno") != null && !box.get("pageno").equals("")) {
				pageno = Integer.parseInt(box.getString("pageno"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			pageno = 1;
		}

		try {
			if (box.get("numOfRows") != null) {
				numOfRows = Integer.parseInt(box.getString("numOfRows"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("pageno", pageno);

		int first = (pageno - 1) * numOfRows;
		int totalRecords = 0;
		if (employeeList != null && employeeList.size() > 0) {

			try {
				totalRecords = employeeList.size();
			} catch (Exception e) {
				totalRecords = 0;
			}
			map.put("totalRecords", totalRecords);

			double totalPages = 0.0;
			totalPages = (double) totalRecords / (double) numOfRows;
			Double d = new Double(Math.ceil(totalPages));
			map.put("totalPages", d.intValue());
			if ((totalRecords - first) < numOfRows) {
				dutyEntryList = employeeList.subList(first, totalRecords);
			} else {
				dutyEntryList = employeeList.subList(first, totalRecords);
			}

		}
		List<HrDutyMaster> dutyList = new ArrayList<HrDutyMaster>();
		String entryNo = "";
		try {
			dutyList = session.createCriteria(HrDutyMaster.class).add(
					Restrictions.eq("DutyName", "Officer Duty")).add(
					Restrictions.eq("Status", "y")).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (dutyList.size() != 0) {
			map.put("dutyId", dutyList.get(0).getId());
		}
		entryNo = getEntrySeqForOfficerDutyDisplay();
		map.put("entryNo", entryNo);
		map.put("dutyEntryList", dutyEntryList);
		map.put("guardDutySetForEntryNoSet", guardDutySetForEntryNoSet);
		map.put("departmentList", departmentList);
		map.put("dutyMasterList", dutyMasterList);
		map.put("box", box);
		return map;
	}

	public boolean AddOfficerDutyEntry(Box box) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		Session session = (Session) getSession();

		List<TransactionSequence> entryNoList = new ArrayList<TransactionSequence>();
		String tableNameForTransactionSequence = "HrorderlyOfficerDutyEntry";

		String empName = "";
		Vector empId = box.getVector("employeeId");
		Vector dutyDate = box.getVector("nextDutyDate");
		Vector dutyTime = box.getVector("dutyTimeId");
		Vector employeeAdded = box.getVector("employeeToBeAdded");
		Vector typeStatus = box.getVector("typeStatus");
		try {

			for (int i = 0; i < empId.size(); i++) {
				if (employeeAdded.contains(empId.get(i))) {
					//System.out.println("entered in the method");
					HrorderlyOfficerDutyEntry hrorderlyGuardDutyEntry = new HrorderlyOfficerDutyEntry();

					hrorderlyGuardDutyEntry
							.setEntryNo(box.getString("entryNo"));
					hrorderlyGuardDutyEntry.setEntryDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.getString("entryDate")));
					hrorderlyGuardDutyEntry.setTypeStatus(typeStatus.get(i)
							.toString());
					hrorderlyGuardDutyEntry.setStatus("y");

					HrDutyMaster hrDutyMaster = new HrDutyMaster();
					hrDutyMaster.setId(box.getInt("dutyId"));
					hrorderlyGuardDutyEntry.setDuty(hrDutyMaster);

					if (empId.get(i) != null && !empId.get(i).equals("")) {
						MasEmployee masEmployee = new MasEmployee();
						masEmployee.setId(Integer.parseInt(empId.get(i)
								.toString()));
						hrorderlyGuardDutyEntry.setEmp(masEmployee);
					}

					if (dutyDate.get(i) != null) {
						hrorderlyGuardDutyEntry.setDutyDate(HMSUtil
								.convertStringTypeDateToDateType((dutyDate
										.get(i).toString())));
						if ((HMSUtil.convertStringTypeDateToDateType((dutyDate
								.get(i).toString())).getDay()) == 0) {
							hrorderlyGuardDutyEntry.setHolidayStatus("y");
						} else {
							hrorderlyGuardDutyEntry.setHolidayStatus("n");

						}
					}
					if (dutyTime != null) {
						if (dutyTime.get(i) != null
								&& !dutyTime.get(i).equals("")) {
							HrDutyTimeMaster hrDutyTimeMaster = new HrDutyTimeMaster();
							hrDutyTimeMaster.setId(Integer.parseInt(dutyTime
									.get(i).toString()));
							hrorderlyGuardDutyEntry
									.setDutyTime(hrDutyTimeMaster);
						}
					}
					if (box.getString("changedBy") != null
							&& !box.getString("changedBy").equals("")) {
						hrorderlyGuardDutyEntry.setLastChgBy(box
								.getString("changedBy"));
					}

					if (box.getString("changedDate") != null
							&& !box.getString("changedDate").equals("")) {
						hrorderlyGuardDutyEntry.setLastChgDate(HMSUtil
								.convertStringTypeDateToDateType((box
										.getString("changedDate"))));
					}

					if (box.getString("changedTime") != null
							&& !box.getString("changedTime").equals("")) {
						hrorderlyGuardDutyEntry.setLastChgTime(box
								.getString("changedTime"));
					}

					MasHospital masHospital = new MasHospital();
					masHospital.setId(box.getInt("hospitalId"));
					hrorderlyGuardDutyEntry.setHospital(masHospital);

					hbt.save(hrorderlyGuardDutyEntry);
					hbt.refresh(hrorderlyGuardDutyEntry);

				}

			}
			entryNoList = session.createCriteria(TransactionSequence.class)
					.add(
							Restrictions.eq("Tablename",
									tableNameForTransactionSequence)).list();
			TransactionSequence transactionSequence = (TransactionSequence) entryNoList
					.get(0);
			int id = transactionSequence.getId();
			int entryNo = transactionSequence.getTransactionSequenceNumber();
			entryNo = entryNo + 1;
			TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
					.load(TransactionSequence.class, id);
			transactionSequenceObj.setTransactionSequenceNumber(entryNo);
			hbt.update(transactionSequenceObj);

		} catch (Exception e) {
			successfullyAdded = false;
			e.printStackTrace();
		}

		successfullyAdded = true;

		return successfullyAdded;
	}

	public Map<String, Object> getOfficerEmployeeLastDutyDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = getGridDataForOfficerLastDuty(box);

		return map;
	}

	public Map<String, Object> getGridDataForOfficerLastDuty(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = (Map<String, Object>) HMSUtil
				.getCurrentDateAndTime();
		session = (Session) getSession();
		Date currentdate = new Date();
		int id = 0;

		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;

		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasEmployee> employeeDetailList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<HrDutyTimeMaster> dutyTimeMasterList = new ArrayList<HrDutyTimeMaster>();
		List<HrorderlyOfficerDutyEntry> dutyEntryList = new ArrayList<HrorderlyOfficerDutyEntry>();
		List<HrorderlyOfficerDutyEntry> holidayEntryList = new ArrayList<HrorderlyOfficerDutyEntry>();
		List<HrorderlyLeaveApplication> employeeLeaveList = new ArrayList<HrorderlyLeaveApplication>();
		List<OpdHoliday> holidayList = new ArrayList<OpdHoliday>();
		List<MasRank> rankList = new ArrayList<MasRank>();

		rankList = session
				.createSQLQuery(
						"select rank_code from mas_rank as mr where mr.rank_code<26 and mr.service_type_id in(1,2,6) and mr.rank_category_id=3 and service_status_id=1")
				.list();
		Object rankArray[] = rankList.toArray();

		Criteria ctr = session.createCriteria(MasEmployee.class).add(
				Restrictions.ne("Status", "n")).createAlias("Trade", "tr").add(
				Restrictions.ne("tr.Id", 2)).add(Restrictions.ne("tr.Id", 7))
				.createAlias("Rank", "mr").add(
						Restrictions.in("mr.RankCode", rankArray));
		employeeList = ctr.list();

		departmentList = session.createCriteria(MasDepartment.class).add(
				Restrictions.eq("Status", "y")).list();
		dutyTimeMasterList = session.createCriteria(HrDutyTimeMaster.class)
				.add(Restrictions.eq("Status", "y")).list();
		holidayList = session.createCriteria(OpdHoliday.class).add(
				Restrictions.eq("Status", "y")).list();

		dutyEntryList = session.createCriteria(HrorderlyOfficerDutyEntry.class)
				.createAlias("Emp", "me").add(
						Restrictions.eq("me.Id", Integer.parseInt(box
								.getString("empData")))).add(
						Restrictions.eq("Status", "y")).add(
						Restrictions.ne("HolidayStatus", "y")).list();

		holidayEntryList = session.createCriteria(
				HrorderlyOfficerDutyEntry.class).createAlias("Emp", "me").add(
				Restrictions.eq("me.Id", Integer.parseInt(box
						.getString("empData")))).add(
				Restrictions.eq("Status", "y")).add(
				Restrictions.eq("HolidayStatus", "y")).list();

		employeeLeaveList = session.createCriteria(
				HrorderlyLeaveApplication.class).createAlias("Employee", "me")
				.add(
						Restrictions.eq("me.Id", Integer.parseInt(box
								.getString("empData")))).add(
						Restrictions.gt("DateOfReporting", currentdate)).add(
						Restrictions.ne("Status", "n")).list();
		int pageno = 1;
		int numOfRows = 10;
		try {
			if (box.get("pageno") != null) {
				pageno = Integer.parseInt(box.getString("pageno"));
			}
		} catch (Exception e) {
			// e.printStackTrace();
			pageno = 1;
		}

		try {
			if (box.get("numOfRows") != null) {
				numOfRows = Integer.parseInt(box.getString("numOfRows"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("pageno", pageno);

		int first = (pageno - 1) * numOfRows;
		int totalRecords = 0;
		if (employeeList != null && employeeList.size() > 0) {
			try {
				totalRecords = employeeList.size();
			} catch (Exception e) {
				totalRecords = 0;
			}
			map.put("totalRecords", totalRecords);

			double totalPages = 0.0;
			totalPages = (double) totalRecords / (double) numOfRows;
			Double d = new Double(Math.ceil(totalPages));
			map.put("totalPages", d.intValue());

			if (totalRecords < numOfRows)
				employeeDetailList = employeeList.subList(first, totalRecords);
			else
				employeeDetailList = employeeList.subList(first, numOfRows);

			//System.out.println("employeeDetailList=="+ employeeDetailList.size());
		}

		map.put("employeeDetailList", employeeDetailList);
		map.put("box", box);
		map.put("employeeList", employeeList);
		map.put("departmentList", departmentList);
		map.put("dutyTimeMasterList", dutyTimeMasterList);
		map.put("dutyEntryList", dutyEntryList);
		map.put("employeeLeaveList", employeeLeaveList);
		map.put("holidayEntryList", holidayEntryList);
		map.put("holidayList", holidayList);
		return map;
	}

	public boolean updateOfficerDutyEntry(Box box) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		String empName = "";
		Vector dutyId = box.getVector("guardDutyId");
		Vector deptId = box.getVector("department");
		Vector dutyDate = box.getVector("nextDutyDate");
		Vector dutyTime = box.getVector("dutyTime");
		Vector remarks = box.getVector("remarks");
		Vector dutyToBeUpdated = box.getVector("dutyToBeUpdated");

		try {

			for (int i = 0; i < dutyId.size(); i++) {
				if (dutyToBeUpdated.contains(dutyId.get(i))) {
					HrorderlyOfficerDutyEntry hrorderlyGuardDutyEntry = (HrorderlyOfficerDutyEntry) hbt
							.load(HrorderlyOfficerDutyEntry.class, Integer
									.parseInt(dutyId.get(i).toString()));

					if (dutyDate.get(i) != null && !dutyDate.get(i).equals("")) {
						hrorderlyGuardDutyEntry.setDutyDate(HMSUtil
								.convertStringTypeDateToDateType((dutyDate
										.get(i).toString())));
					}

					if (dutyTime.get(i) != null && !dutyTime.get(i).equals("")) {
						HrDutyTimeMaster hrDutyTimeMaster = new HrDutyTimeMaster();
						hrDutyTimeMaster.setId(Integer.parseInt(dutyTime.get(i)
								.toString()));
						hrorderlyGuardDutyEntry.setDutyTime(hrDutyTimeMaster);
					}
					hbt.update(hrorderlyGuardDutyEntry);
					hbt.refresh(hrorderlyGuardDutyEntry);
				}
			}
		} catch (Exception e) {
			successfullyAdded = false;
			e.printStackTrace();
		}

		successfullyAdded = true;

		return successfullyAdded;
	}

	public boolean deleteOfficerDutyEntry(Box box) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		String empName = "";
		Vector dutyId = box.getVector("guardDutyId");
		Vector dutyToBeUpdated = box.getVector("dutyToBeUpdated");

		try {

			for (int i = 0; i < dutyId.size(); i++) {
				if (dutyToBeUpdated.contains(dutyId.get(i))) {
					HrorderlyOfficerDutyEntry hrorderlyGuardDutyEntry = (HrorderlyOfficerDutyEntry) hbt
							.load(HrorderlyOfficerDutyEntry.class, Integer
									.parseInt(dutyId.get(i).toString()));

					hrorderlyGuardDutyEntry.setStatus("n");

					hbt.update(hrorderlyGuardDutyEntry);
					hbt.refresh(hrorderlyGuardDutyEntry);
				}
			}

		} catch (Exception e) {
			successfullyAdded = false;
			e.printStackTrace();
		}

		successfullyAdded = true;

		return successfullyAdded;
	}

	public Map<String, Object> searchOfficerDutyEntry(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = (Map<String, Object>) HMSUtil
				.getCurrentDateAndTime();
		session = (Session) getSession();

		int id = 0;

		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;

		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasEmployee> employeeDetailList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<HrDutyTimeMaster> dutyTimeMasterList = new ArrayList<HrDutyTimeMaster>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<HrDutyExemptionEntry> dutyExemptionList = new ArrayList<HrDutyExemptionEntry>();
		String serviceNo = "";
		String empName = "";

		if (!box.getString("searchServiceNo").equals("")) {
			serviceNo = box.getString("searchServiceNo");
		}
		if (!box.getString("searchName").equals("")) {
			empName = box.getString("searchName");
		}
		session = (Session) getSession();
		rankList = session.createCriteria(MasRank.class).add(
				Restrictions.eq("RankName", "CPL")).list();
		dutyExemptionList = session.createCriteria(HrDutyExemptionEntry.class)
				.list();
		rankList = session
				.createSQLQuery(
						"select rank_code from mas_rank as mr where mr.rank_code<26 and mr.service_type_id in(1,2,6) and mr.rank_category_id=3 and service_status_id=1")
				.list();
		Object rankArray[] = rankList.toArray();

		Criteria ctr = session.createCriteria(MasEmployee.class).add(
				Restrictions.ne("Status", "n")).createAlias("Trade", "tr").add(
				Restrictions.ne("tr.Id", 2)).add(Restrictions.ne("tr.Id", 7))
				.createAlias("Rank", "mr").add(
						Restrictions.in("mr.RankCode", rankArray));

		if (!serviceNo.equals("")) {
			ctr = ctr.add(Restrictions.like("ServiceNo", serviceNo + "%"));

		} else if (!empName.equals("")) {
			ctr = ctr.add(Restrictions.like("FirstName", empName + "%"));
		}
		employeeList = ctr.list();
		departmentList = session.createCriteria(MasDepartment.class).add(
				Restrictions.eq("Status", "y")).list();
		dutyTimeMasterList = session.createCriteria(HrDutyTimeMaster.class)
				.add(Restrictions.eq("Status", "y")).list();

		int pageno = 1;
		int numOfRows = 10;

		try {
			if (box.get("numOfRows") != null) {
				numOfRows = Integer.parseInt(box.getString("numOfRows"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("pageno", pageno);

		int first = (pageno - 1) * numOfRows;
		int totalRecords = 0;
		if (employeeList != null && employeeList.size() > 0) {

			// String qry="SELECT count(*) FROM mas_employee";
			try {
				// totalRecords =
				// Integer.parseInt(session.createSQLQuery(qry).list().get(0).toString());
				totalRecords = employeeList.size();
			} catch (Exception e) {
				totalRecords = 0;
			}
			map.put("totalRecords", totalRecords);

			double totalPages = 0.0;
			totalPages = (double) totalRecords / (double) numOfRows;
			Double d = new Double(Math.ceil(totalPages));
			map.put("totalPages", d.intValue());

			if ((totalRecords - first) < numOfRows)
				employeeDetailList = employeeList.subList(first, totalRecords);
			else
				employeeDetailList = employeeList.subList(first, numOfRows);

		}
		map.put("employeeDetailList", employeeDetailList);
		map.put("employeeList", employeeList);
		map.put("departmentList", departmentList);
		map.put("dutyTimeMasterList", dutyTimeMasterList);
		map.put("dutyExemptionList", dutyExemptionList);
		map.put("box", box);
		return map;
	}

	public String getEntrySeqForOfficerDutyDisplay() {
		List<TransactionSequence> orderSeqNoList = new ArrayList<TransactionSequence>();
		List<HrOrderlySgtDutyEntry> seqNoList = new ArrayList<HrOrderlySgtDutyEntry>();
		String entrySeqNo = "";
		String lastSeqNo = "";
		String lastSeqYear = "";

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");

		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		try {
			seqNoList = session.createCriteria(HrOrderlySgtDutyEntry.class)
					.list();
			if (seqNoList.size() > 0) {
				for (HrOrderlySgtDutyEntry hrGuardDutyEntry : seqNoList) {
					lastSeqNo = hrGuardDutyEntry.getEntryNo();
				}
				StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
				while (str.hasMoreTokens()) {
					lastSeqYear = str.nextToken();
				}
			} else {
				lastSeqYear = currentYear;
			}

			orderSeqNoList = session.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "ODEN")).list();
			// .setProjection(Projections.projectionList().add(Projections.max("TransactionSequenceNumber")))
			//System.out.println("orderSeqNoList:::" + orderSeqNoList.size());
			if (orderSeqNoList != null && orderSeqNoList.size() > 0) {
				for (TransactionSequence maxOrderNo : orderSeqNoList) {
					if (currentYear.equals(lastSeqYear)) {
						entrySeqNo = String.valueOf(maxOrderNo
								.getTransactionSequenceNumber() + 1);
					} else {
						entrySeqNo = String.valueOf(1);

					}
				}
			} else {
				entrySeqNo = String.valueOf(1);
				TransactionSequence transactionSequence = new TransactionSequence();
				transactionSequence.setTransactionPrefix("ODEN");
				transactionSequence
						.setTransactionSequenceName("Officer Duty Entry No.");
				transactionSequence.setTransactionSequenceNumber(1);
				transactionSequence.setTablename("HrorderlyOfficerDutyEntry");
				transactionSequence.setStatus("y");
				session.save(transactionSequence);
			}
			entrySeqNo = entrySeqNo.concat("/").concat(
					String.valueOf(lastSeqYear));
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return entrySeqNo;
	}

	// *************************

	public String getEntrySeqForWardDutyDisplay() {
		List<Integer> orderSeqNoList = new ArrayList<Integer>();
		List<HrOrderlySgtDutyEntry> seqNoList = new ArrayList<HrOrderlySgtDutyEntry>();
		String entrySeqNo = "";
		String lastSeqNo = "";
		String lastSeqYear = "";

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");

		String currentYear = date.substring(date.lastIndexOf("/") + 1);

		Session session = (Session) getSession();
		try {
			seqNoList = session.createCriteria(HrOrderlySgtDutyEntry.class)
					.list();
			if (seqNoList.size() > 0) {
				for (HrOrderlySgtDutyEntry hrWardDutyEntry : seqNoList) {
					lastSeqNo = hrWardDutyEntry.getEntryNo();

				}
				StringTokenizer str = null;
				if (lastSeqNo != null) {
					str = new StringTokenizer(lastSeqNo, "/");

					while (str.hasMoreTokens()) {
						lastSeqYear = str.nextToken();
					}
				}
			} else {
				lastSeqYear = currentYear;
			}

			orderSeqNoList = session.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "SGT"))
					.setProjection(
							Projections.projectionList().add(
									Projections
											.max("TransactionSequenceNumber")))
					.list();
			if (orderSeqNoList.size() > 0) {
				for (Integer maxOrderNo : orderSeqNoList) {
					if (currentYear.equals(lastSeqYear)) {
						entrySeqNo = String.valueOf(maxOrderNo + 1);
					} else {
						entrySeqNo = String.valueOf(1);
					}
				}
			} else {
				entrySeqNo = String.valueOf(1);
			}
			entrySeqNo = entrySeqNo.concat("/").concat(
					String.valueOf(lastSeqYear));
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return entrySeqNo;
	}

	/* ORDERLY OFFICER */

	public Map<String, Object> getEmployeeDetailsForOrderlyOfficerDutyAdd(
			Box box) {
		PagedArray pagedArray = null;
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<HrDutyTimeMaster> dutyTimeMasterList = new ArrayList<HrDutyTimeMaster>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		session = (Session) getSession();

		try {
			/*
			 * rankList =
			 * session.createCriteria(MasRank.class).add(Restrictions.eq(
			 * "RankName", "MWO")).add( Restrictions.eq("RankName",
			 * "WO")).add(Restrictions.eq("RankName", "JWO")).list();
			 * 
			 * employeeList =
			 * session.createCriteria(MasEmployee.class).add(Restrictions
			 * .eq("Status", "y")).createAlias( "Rank",
			 * "rk").add(Restrictions.eq("rk.Id",
			 * rankList.get(0).getId())).list(); //System.out.println("emplyee
			 * with rank" + employeeList.size());
			 */

			departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).list();
			dutyTimeMasterList = session.createCriteria(HrDutyTimeMaster.class)
					.add(Restrictions.eq("Status", "y")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("employeeList", employeeList);
		map.put("departmentList", departmentList);
		map.put("dutyTimeMasterList", dutyTimeMasterList);

		map = getGridDataForOrderlyOfficerEmployeeAdd(box);

		return map;
	}

	public Map<String, Object> getGridDataForOrderlyOfficerEmployeeAdd(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = (Map<String, Object>) HMSUtil
				.getCurrentDateAndTime();
		session = (Session) getSession();

		int id = 0;

		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;

		List employeeList = new ArrayList();
		List employeeDetailList = new ArrayList();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<HrDutyTimeMaster> dutyTimeMasterList = new ArrayList<HrDutyTimeMaster>();
		List<HrorderlyLeaveApplication> leaveMaintenanceList = new ArrayList<HrorderlyLeaveApplication>();
		List<HrDutyExemptionEntry> dutyExemptionList = new ArrayList<HrDutyExemptionEntry>();

		/*
		 * rankList =
		 * session.createCriteria(MasRank.class).add(Restrictions.eq("RankName",
		 * "MWO")).add( Restrictions.eq("RankName",
		 * "WO")).add(Restrictions.eq("RankName", "JWO")).list();
		 * //System.out.println("rankkkkkkkkk" + rankList.size());
		 */

		String sqlQuery = "SELECT me.employee_id,me.service_no,me.first_name,me.department_id,hde.duty_date,mr.rank_name from"

				+ " mas_employee me"

				+ " LEFT JOIN hr_duty_entry hde ON me.employee_id=hde.emp_id"

				+ " LEFT JOIN mas_rank mr on me.employee_id=mr.rank_id"

				+ " ORDER  BY duty_date ASC";

		employeeList = session.createSQLQuery(sqlQuery).list();

		/*
		 * employeeList =
		 * session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status",
		 * "y")).createAlias("Rank", "rk").add(Restrictions.eq("rk.Id",
		 * rankList.get(0).getId())).list();
		 */
		departmentList = session.createCriteria(MasDepartment.class).add(
				Restrictions.eq("Status", "y")).list();
		dutyTimeMasterList = session.createCriteria(HrDutyTimeMaster.class)
				.add(Restrictions.eq("Status", "y")).list();
		leaveMaintenanceList = session.createCriteria(
				HrorderlyLeaveApplication.class).list();
		dutyExemptionList = session.createCriteria(HrDutyExemptionEntry.class)
				.createAlias("Duty", "d").add(
						Restrictions.eq("d.DutyName", "Orderly Duty")).list();

		map.put("dutyExemptionList", dutyExemptionList);
		map.put("leaveMaintenanceList", leaveMaintenanceList);
		map.put("employeeList", employeeList);
		map.put("departmentList", departmentList);
		map.put("dutyTimeMasterList", dutyTimeMasterList);

		int pageno = 1;
		int numOfRows = 10;
		try {
			if (box.get("pageno") != null) {
				pageno = Integer.parseInt(box.getString("pageno"));
			}
		} catch (Exception e) {
			// e.printStackTrace();
			pageno = 1;
		}

		try {
			if (box.get("numOfRows") != null) {
				numOfRows = Integer.parseInt(box.getString("numOfRows"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("pageno", pageno);

		int first = (pageno - 1) * numOfRows;
		int totalRecords = 0;
		if (employeeList != null && employeeList.size() > 0) {

			try {

				totalRecords = employeeList.size();
			} catch (Exception e) {
				totalRecords = 0;
			}
			map.put("totalRecords", totalRecords);

			double totalPages = 0.0;
			totalPages = (double) totalRecords / (double) numOfRows;
			Double d = new Double(Math.ceil(totalPages));
			map.put("totalPages", d.intValue());

			Query query = session.createSQLQuery(sqlQuery);
			query.setFirstResult(first);

			if (totalRecords < numOfRows) {
				query.setMaxResults(totalRecords);
			} else {
				query.setMaxResults(numOfRows);
			}
			employeeDetailList = query.list();
		}

		map.put("employeeDetailList", employeeDetailList);
		map.put("box", box);
		return map;
	}

	public Map<String, Object> getEmployeeDetailsForOrderlyOfficerDuty(Box box) {
		//System.out.println("first method called");
		PagedArray pagedArray = null;
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<HrorderlyOfficerDutyEntry> dutyList = new ArrayList<HrorderlyOfficerDutyEntry>();
		Date fromDate = HMSUtil.convertStringTypeDateToDateType(box
				.get("fromDate"));
		Date toDate = HMSUtil
				.convertStringTypeDateToDateType(box.get("toDate"));

		session = (Session) getSession();

		try {
			dutyList = session.createCriteria(HrorderlyOfficerDutyEntry.class)
					.add(Restrictions.between("DutyDate", fromDate, toDate))
					.add(Restrictions.eq("Status", "y")).list();
			//System.out.println("dutttttttttttttt" + dutyList.size());
			departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("dutyList", dutyList);
		map.put("departmentList", departmentList);
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);

		map = getGridDataForOrderlyOfficerEmployee(box);

		return map;
	}

	public Map<String, Object> getGridDataForOrderlyOfficerEmployee(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = (Map<String, Object>) HMSUtil
				.getCurrentDateAndTime();
		session = (Session) getSession();

		int id = 0;
		int deptId = 0;
		Date fromDate = new Date();
		Date toDate = new Date();
		if (!box.get("fromDate").equals(""))
			fromDate = HMSUtil.convertStringTypeDateToDateType(box
					.get("fromDate"));
		if (!box.get("toDate").equals(""))
			toDate = HMSUtil.convertStringTypeDateToDateType(box.get("toDate"));

		List<HrorderlyOfficerDutyEntry> employeeList = new ArrayList<HrorderlyOfficerDutyEntry>();
		List<HrorderlyOfficerDutyEntry> dutyEntryList = new ArrayList<HrorderlyOfficerDutyEntry>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<HrDutyTimeMaster> dutyMasterList = new ArrayList<HrDutyTimeMaster>();
		// List<HrorderlyOfficerDutyEntry> orderlyDutyListForEntryNo = new
		// ArrayList<HrorderlyOfficerDutyEntry>();
		employeeList = session.createCriteria(HrorderlyOfficerDutyEntry.class)
				.add(Restrictions.between("DutyDate", fromDate, toDate)).add(
						Restrictions.eq("Status", "y")).list();
		departmentList = session.createCriteria(MasDepartment.class).add(
				Restrictions.eq("Status", "y")).list();
		dutyMasterList = session.createCriteria(HrDutyTimeMaster.class).add(
				Restrictions.eq("Status", "y")).list();
		// orderlyDutyListForEntryNo =
		// session.createCriteria(HrOrderlyDutyEntry.class).add(Restrictions.eq("Status",
		// "y"))
		// .list();
		// Set<String> orderlyDutySetForEntryNoSet = new TreeSet<String>();
		// for (HrOrderlyDutyEntry hrOrderlyDutyEntry :
		// orderlyDutyListForEntryNo)
		// {
		// orderlyDutySetForEntryNoSet.add(hrOrderlyDutyEntry.getEntryNo());
		// }

		map.put("employeeList", employeeList);
		map.put("departmentList", departmentList);
		map.put("dutyMasterList", dutyMasterList);
		// map.put("orderlyDutySetForEntryNoSet", orderlyDutySetForEntryNoSet);
		int pageno = 1;
		int numOfRows = 10;
		try {
			if (box.get("pageno") != null && !box.get("pageno").equals("")) {
				pageno = Integer.parseInt(box.getString("pageno"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			pageno = 1;
		}

		try {
			if (box.get("numOfRows") != null) {
				numOfRows = Integer.parseInt(box.getString("numOfRows"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("pageno", pageno);

		int first = (pageno - 1) * numOfRows;
		int totalRecords = 0;
		if (employeeList != null && employeeList.size() > 0) {

			try {
				totalRecords = employeeList.size();
			} catch (Exception e) {
				totalRecords = 0;
			}
			map.put("totalRecords", totalRecords);

			double totalPages = 0.0;
			totalPages = (double) totalRecords / (double) numOfRows;
			Double d = new Double(Math.ceil(totalPages));
			map.put("totalPages", d.intValue());

			Criteria c = session
					.createCriteria(HrorderlyOfficerDutyEntry.class).add(
							Restrictions.between("DutyDate", fromDate, toDate))
					.add(Restrictions.eq("Status", "y"));
			c.setFirstResult(first);

			if (totalRecords < numOfRows)
				c.setMaxResults(totalRecords);
			else
				c.setMaxResults(numOfRows);

			dutyEntryList = c.list();
		}
		List<HrDutyMaster> dutyList = new ArrayList<HrDutyMaster>();
		// String entryNo = "";
		try {
			dutyList = session.createCriteria(HrDutyMaster.class).add(
					Restrictions.eq("DutyName", "Orderly Duty")).add(
					Restrictions.eq("Status", "y")).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("dutyId", dutyList.get(0).getId());
		// entryNo = getEntrySeqForOrderlyOfficerDutyDisplay();
		// map.put("entryNo", entryNo);
		map.put("dutyEntryList", dutyEntryList);
		map.put("box", box);
		return map;
	}

	public String getEntrySeqForOrderlyOfficerDutyDisplay() {
		List<Integer> orderSeqNoList = new ArrayList<Integer>();
		List<HrOrderlyDutyEntry> seqNoList = new ArrayList<HrOrderlyDutyEntry>();
		String entrySeqNo = "";
		String lastSeqNo = "";
		String lastSeqYear = "";

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");

		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		try {
			seqNoList = session.createCriteria(HrOrderlyDutyEntry.class).list();
			if (seqNoList.size() > 0) {
				for (HrOrderlyDutyEntry hrOrderlyDutyEntry : seqNoList) {
					lastSeqNo = hrOrderlyDutyEntry.getEntryNo();
				}
				StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
				while (str.hasMoreTokens()) {
					lastSeqYear = str.nextToken();
				}
			} else {
				lastSeqYear = currentYear;
			}

			orderSeqNoList = session.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "ABC"))
					.setProjection(
							Projections.projectionList().add(
									Projections
											.max("TransactionSequenceNumber")))
					.list();
			if (orderSeqNoList.size() > 0) {
				for (Integer maxOrderNo : orderSeqNoList) {
					if (currentYear.equals(lastSeqYear)) {
						entrySeqNo = String.valueOf(maxOrderNo + 1);
					} else {
						entrySeqNo = String.valueOf(1);
					}
				}
			} else {
				entrySeqNo = String.valueOf(1);
			}
			entrySeqNo = entrySeqNo.concat("/").concat(
					String.valueOf(lastSeqYear));
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return entrySeqNo;
	}

	public boolean AddOrderlyOfficerDutyEntry(Box box) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		Session session = (Session) getSession();

		Vector empId = box.getVector("employeeId");
		Vector deptId = box.getVector("department");
		Vector dutyDate = box.getVector("nextDutyDate");
		Vector dutyTime = box.getVector("dutyTimeId");
		Vector remarks = box.getVector("remarks");
		Vector employeeAdded = box.getVector("employeeToBeAdded");

		// List<TransactionSequence> entryNoList = new
		// ArrayList<TransactionSequence>();
		String tableNameForTransactionSequence = "HrDailyRoutineDutyEntry";
		Vector typeStatus = box.getVector("typeStatus");

		try {

			for (int i = 0; i < empId.size(); i++) {
				if (employeeAdded.contains(empId.get(i))) {
					HrorderlyOfficerDutyEntry hrOrderlyDutyEntry = new HrorderlyOfficerDutyEntry();

					// hrOrderlyDutyEntry.setEntryNo(box.getString("entryNo"));
					hrOrderlyDutyEntry.setEntryDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.getString("entryDate")));
					hrOrderlyDutyEntry.setTypeStatus(typeStatus.get(i)
							.toString());
					hrOrderlyDutyEntry.setStatus("y");

					HrDutyMaster hrDutyMaster = new HrDutyMaster();
					hrDutyMaster.setId(box.getInt("dutyId"));
					hrOrderlyDutyEntry.setDuty(hrDutyMaster);

					if (empId.get(i) != null && !empId.get(i).equals("")) {
						MasEmployee masEmployee = new MasEmployee();
						masEmployee.setId(Integer.parseInt(empId.get(i)
								.toString()));
						hrOrderlyDutyEntry.setEmp(masEmployee);
					}

					if (dutyDate.get(i) != null) {
						hrOrderlyDutyEntry.setDutyDate(HMSUtil
								.convertStringTypeDateToDateType((dutyDate
										.get(i).toString())));
					}
					if (deptId.get(i) != null && !deptId.get(i).equals("0")) {
						MasDepartment masDepartment = new MasDepartment();
						masDepartment.setId(Integer.parseInt(deptId.get(i)
								.toString()));
						hrOrderlyDutyEntry.setDepartmentId(masDepartment);
					}
					if (remarks.get(i) != null) {
						hrOrderlyDutyEntry
								.setRemarks(remarks.get(i).toString());
					}
					if (dutyTime.get(i) != null && !dutyTime.get(i).equals("")) {
						HrDutyTimeMaster hrDutyTimeMaster = new HrDutyTimeMaster();
						hrDutyTimeMaster.setId(Integer.parseInt(dutyTime.get(i)
								.toString()));
						hrOrderlyDutyEntry.setDutyTime(hrDutyTimeMaster);
					}

					if (box.getString("changedBy") != null
							&& !box.getString("changedBy").equals("")) {
						hrOrderlyDutyEntry.setLastChgBy(box
								.getString("changedBy"));
					}

					if (box.getString("changedDate") != null
							&& !box.getString("changedDate").equals("")) {
						hrOrderlyDutyEntry.setLastChgDate(HMSUtil
								.convertStringTypeDateToDateType((box
										.getString("changedDate"))));
					}

					if (box.getString("changedTime") != null
							&& !box.getString("changedTime").equals("")) {
						hrOrderlyDutyEntry.setLastChgTime(box
								.getString("changedTime"));
					}

					MasHospital masHospital = new MasHospital();
					masHospital.setId(box.getInt("hospitalId"));
					hrOrderlyDutyEntry.setHospital(masHospital);
					hrOrderlyDutyEntry.setStatus("y");
					hbt.save(hrOrderlyDutyEntry);

				}

			}
			// entryNoList =
			// session.createCriteria(TransactionSequence.class).add(
			// Restrictions.eq("Tablename",
			// tableNameForTransactionSequence)).list();
			// TransactionSequence transactionSequence = (TransactionSequence)
			// entryNoList.get(0);
			// int id = transactionSequence.getId();
			// int entryNo = transactionSequence.getTransactionSequenceNumber();
			// entryNo = entryNo + 1;
			// TransactionSequence transactionSequenceObj =
			// (TransactionSequence)
			// hbt.load(TransactionSequence.class, id);
			// transactionSequenceObj.setTransactionSequenceNumber(entryNo);
			// hbt.update(transactionSequenceObj);

		} catch (Exception e) {
			successfullyAdded = false;
			e.printStackTrace();
		}

		successfullyAdded = true;

		return successfullyAdded;
	}

	public Map<String, Object> getOrderlyOfficerEmployeeLastDutyDetails(Box box) {
		PagedArray pagedArray = null;
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<HrDutyTimeMaster> dutyTimeMasterList = new ArrayList<HrDutyTimeMaster>();
		List<HrorderlyOfficerDutyEntry> dutyEntryList = new ArrayList<HrorderlyOfficerDutyEntry>();

		session = (Session) getSession();
		try {
			employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).list();
			departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).list();
			dutyTimeMasterList = session.createCriteria(HrDutyTimeMaster.class)
					.add(Restrictions.eq("Status", "y")).list();
			dutyEntryList = session.createCriteria(
					HrorderlyOfficerDutyEntry.class).createAlias("Emp", "me")
					.add(
							Restrictions.eq("me.Id", Integer.parseInt(box
									.getString("empData")))).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("employeeList", employeeList);
		map.put("departmentList", departmentList);
		map.put("dutyTimeMasterList", dutyTimeMasterList);
		map.put("dutyEntryList", dutyEntryList);
		map = getGridDataForOrderlyOfficerLastDuty(box);

		return map;
	}

	public Map<String, Object> getGridDataForOrderlyOfficerLastDuty(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = (Map<String, Object>) HMSUtil
				.getCurrentDateAndTime();
		session = (Session) getSession();

		int id = 0;

		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;

		List employeeList = new ArrayList();
		List employeeDetailList = new ArrayList();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<HrDutyTimeMaster> dutyTimeMasterList = new ArrayList<HrDutyTimeMaster>();
		List<HrorderlyOfficerDutyEntry> dutyEntryList = new ArrayList<HrorderlyOfficerDutyEntry>();
		List<HrorderlyLeaveApplication> employeeLeaveList = new ArrayList<HrorderlyLeaveApplication>();
		List<OpdHoliday> holidayList = new ArrayList<OpdHoliday>();
		List<MasRank> rankList = new ArrayList<MasRank>();

		/*
		 * rankList =
		 * session.createCriteria(MasRank.class).add(Restrictions.eq("RankName",
		 * "SGT")).list(); employeeList =
		 * session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status",
		 * "y")).createAlias("Rank", "mr").add(Restrictions.eq("mr.Id",
		 * rankList.get(0).getId())).list();
		 */

		String sqlQuery = "SELECT me.employee_id,me.service_no,me.first_name,me.department_id,hde.duty_date,mr.rank_name from"

				+ " mas_employee me"

				+ " LEFT JOIN hr_duty_entry hde ON me.employee_id=hde.emp_id"

				+ " LEFT JOIN mas_rank mr on me.employee_id=mr.rank_id"

				+ " ORDER  BY duty_date ASC";

		employeeList = session.createSQLQuery(sqlQuery).list();

		departmentList = session.createCriteria(MasDepartment.class).add(
				Restrictions.eq("Status", "y")).list();
		dutyTimeMasterList = session.createCriteria(HrDutyTimeMaster.class)
				.add(Restrictions.eq("Status", "y")).list();
		dutyEntryList = session.createCriteria(HrorderlyOfficerDutyEntry.class)
				.createAlias("Emp", "me").add(
						Restrictions.eq("me.Id", Integer.parseInt(box
								.getString("empData")))).list();
		employeeLeaveList = session.createCriteria(
				HrorderlyLeaveApplication.class).createAlias("Employee", "me")
				.add(
						Restrictions.eq("me.Id", Integer.parseInt(box
								.getString("empData")))).list();
		holidayList = session.createCriteria(OpdHoliday.class).add(
				Restrictions.eq("Status", "y")).list();

		map.put("employeeList", employeeList);
		map.put("departmentList", departmentList);
		map.put("dutyTimeMasterList", dutyTimeMasterList);
		map.put("dutyEntryList", dutyEntryList);
		map.put("employeeLeaveList", employeeLeaveList);
		map.put("holidayList", holidayList);

		int pageno = 1;
		int numOfRows = 10;
		try {
			if (box.get("pageno") != null) {
				pageno = Integer.parseInt(box.getString("pageno"));
			}
		} catch (Exception e) {
			// e.printStackTrace();
			pageno = 1;
		}

		try {
			if (box.get("numOfRows") != null) {
				numOfRows = Integer.parseInt(box.getString("numOfRows"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("pageno", pageno);

		int first = (pageno - 1) * numOfRows;
		int totalRecords = 0;
		if (employeeList != null && employeeList.size() > 0) {
			try {
				totalRecords = employeeList.size();
			} catch (Exception e) {
				totalRecords = 0;
			}
			map.put("totalRecords", totalRecords);

			double totalPages = 0.0;
			totalPages = (double) totalRecords / (double) numOfRows;
			Double d = new Double(Math.ceil(totalPages));
			map.put("totalPages", d.intValue());

			Query query = session.createSQLQuery(sqlQuery);
			query.setFirstResult(first);

			if (totalRecords < numOfRows) {
				query.setMaxResults(totalRecords);
			} else {
				query.setMaxResults(numOfRows);
			}
			employeeDetailList = query.list();
		}

		map.put("employeeDetailList", employeeDetailList);
		map.put("box", box);
		return map;
	}

	public Map<String, Object> showOrderlyOfficerDutyEntryJsp() {
		Map<String, Object> map = new HashMap<String, Object>();

		List<HrDutyMaster> dutyList = new ArrayList<HrDutyMaster>();
		List<HrorderlyOfficerDutyEntry> orderlyDutyListForEntryNo = new ArrayList<HrorderlyOfficerDutyEntry>();
		Session session = (Session) getSession();
		String entryNo = "";
		try {
			// dutyList =
			// session.createCriteria(HrDutyMaster.class).add(Restrictions.eq("DutyName",
			// "SGT Duty")).add(
			// Restrictions.eq("Status", "y")).list();
			// orderlyDutyListForEntryNo =
			// session.createCriteria(HrOrderlySgtDutyEntry.class).add(
			// Restrictions.eq("Status", "y")).list();
			// Set<String> orderlyDutySetForEntryNoSet = new TreeSet<String>();
			// for (HrorderlyOfficerDutyEntry hrOrderlyDutyEntry :
			// orderlyDutyListForEntryNo)
			// {
			// orderlyDutySetForEntryNoSet.add(hrOrderlyDutyEntry.getEntryNo());
			// }
			// entryNo = getEntrySeqForWardDutyDisplay();
			// map.put("entryNo", entryNo);
			// map.put("dutyId", dutyList.get(0).getId());
			// map.put("orderlyDutySetForEntryNoSet",
			// orderlyDutySetForEntryNoSet);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	public boolean updateOrderlyOfficerDutyEntry(Box box) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		String empName = "";
		Vector dutyId = box.getVector("orderlyDutyId");
		Vector deptId = box.getVector("department");
		Vector dutyDate = box.getVector("nextDutyDate");
		Vector dutyTime = box.getVector("dutyTime");
		Vector remarks = box.getVector("remarks");
		Vector dutyToBeUpdated = box.getVector("dutyToBeUpdated");

		try {

			for (int i = 0; i < dutyId.size(); i++) {
				if (dutyToBeUpdated.contains(dutyId.get(i))) {
					HrorderlyOfficerDutyEntry hrOrderlyDutyEntry = (HrorderlyOfficerDutyEntry) hbt
							.load(HrorderlyOfficerDutyEntry.class, Integer
									.parseInt(dutyId.get(i).toString()));

					if (deptId.get(i) != null && !deptId.get(i).equals("0")) {
						MasDepartment masDepartment = new MasDepartment();
						masDepartment.setId(Integer.parseInt(deptId.get(i)
								.toString()));
						hrOrderlyDutyEntry.setDepartmentId(masDepartment);
					}

					if (dutyDate.get(i) != null && !dutyDate.get(i).equals("")) {
						hrOrderlyDutyEntry.setDutyDate(HMSUtil
								.convertStringTypeDateToDateType((dutyDate
										.get(i).toString())));
					}

					if (dutyTime.get(i) != null && !dutyTime.get(i).equals("")) {
						HrDutyTimeMaster hrDutyTimeMaster = new HrDutyTimeMaster();
						hrDutyTimeMaster.setId(Integer.parseInt(dutyTime.get(i)
								.toString()));
						hrOrderlyDutyEntry.setDutyTime(hrDutyTimeMaster);
					}
					if (remarks.get(i) != null && !remarks.get(i).equals("")) {
						hrOrderlyDutyEntry
								.setRemarks(remarks.get(i).toString());
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

	public boolean deleteOrderlyOfficerDutyEntry(Box box) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		String empName = "";
		Vector dutyId = box.getVector("orderlyDutyId");
		Vector dutyToBeUpdated = box.getVector("dutyToBeUpdated");

		try {

			for (int i = 0; i < dutyId.size(); i++) {
				if (dutyToBeUpdated.contains(dutyId.get(i))) {
					HrorderlyOfficerDutyEntry hrOrderlyDutyEntry = (HrorderlyOfficerDutyEntry) hbt
							.load(HrorderlyOfficerDutyEntry.class, Integer
									.parseInt(dutyId.get(i).toString()));

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

	// ::::::::::::::::::added by yogesh on 08/10/2009 for hr master
	/**
	 * ------- Speciality Master Added by Priyanka started on 29th April 2009
	 */
	public boolean addSpeciality(HrSpecialistMaster hrSpecialistMaster) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(hrSpecialistMaster);
		hbt.refresh(hrSpecialistMaster);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteSpeciality(int id, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		HrSpecialistMaster hrSpecialistMaster = new HrSpecialistMaster();
		hrSpecialistMaster = (HrSpecialistMaster) getHibernateTemplate().get(
				HrSpecialistMaster.class, id);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				hrSpecialistMaster.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				hrSpecialistMaster.setStatus("y");
				dataDeleted = false;
			}
		}
		hrSpecialistMaster.setLastChgBy(changedBy);
		hrSpecialistMaster.setLastChgDate(currentDate);
		hrSpecialistMaster.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(hrSpecialistMaster);
		hbt.refresh(hrSpecialistMaster);
		return dataDeleted;
	}

	public boolean editSpecialityToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String name = "";
		@SuppressWarnings("unused")
		String code = "";
		int id = 0;
		int tradeId = 0;
		String changedBy = "";
		id = (Integer) generalMap.get("id");
		tradeId = (Integer) generalMap.get("tradeId");
		code = (String) generalMap.get("code");
		name = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		HrSpecialistMaster hrSpecialistMaster = (HrSpecialistMaster) getHibernateTemplate()
				.get(HrSpecialistMaster.class, id);

		hrSpecialistMaster.setId(id);
		hrSpecialistMaster.setSpecialistName(name);
		hrSpecialistMaster.setLastChgBy(changedBy);
		hrSpecialistMaster.setLastChgDate(currentDate);
		hrSpecialistMaster.setLastChgTime(currentTime);
		if (tradeId != 0) {
			MasTrade masTrade = new MasTrade();
			masTrade.setId(tradeId);
			hrSpecialistMaster.setTradeId(masTrade);
			//System.out.println("tradeid" + tradeId);
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(hrSpecialistMaster);
		hbt.refresh(hrSpecialistMaster);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchSpeciality(String code, String name) {
		List<HrSpecialistMaster> searchSpecialityList = new ArrayList<HrSpecialistMaster>();
		Map<String, Object> specialityFieldsMap = new HashMap<String, Object>();
		List gridCurrencyList = null;
		try {
			if ((name != null) || (code == null)) {
				searchSpecialityList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.HrSpecialistMaster as i where i.SpecialistName like '"
										+ name + "%' order by i.SpecialistName");
			} else {
				searchSpecialityList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.HrSpecialistMaster as i where i.SpecialistCode like '"
										+ code + "%' order by i.SpecialistCode");
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchSpecialityList  " + e);
		}
		specialityFieldsMap.put("searchSpecialityList", searchSpecialityList);
		return specialityFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showSpecialityJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		List<HrSpecialistMaster> searchSpecialityList = new ArrayList<HrSpecialistMaster>();
		List<MasTrade> masTrade = new ArrayList<MasTrade>();
		searchSpecialityList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.HrSpecialistMaster ");
		masTrade = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasTrade  as mt where mt.Status='y' ");
		map.put("searchSpecialityList", searchSpecialityList);
		map.put("masTrade", masTrade);

		return map;
	}

	/**
	 * -------Mess Master Added by Yogesh started on 29th september 2009
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> showMessJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		List<HrorderlyMessMaster> messMasterList = new ArrayList<HrorderlyMessMaster>();
		List<MasUnit> masUnitList = new ArrayList<MasUnit>();
		messMasterList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.HrorderlyMessMaster ");
		masUnitList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasUnit  as mt where  mt.DependentUnit='y' ");
		map.put("messMasterList", messMasterList);
		map.put("masUnitList", masUnitList);

		return map;
	}

	public boolean addMess(HrorderlyMessMaster hrorderlyMessMaster) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(hrorderlyMessMaster);
		hbt.refresh(hrorderlyMessMaster);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteMess(int id, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		HrorderlyMessMaster hrorderlyMessMaster = new HrorderlyMessMaster();
		hrorderlyMessMaster = (HrorderlyMessMaster) getHibernateTemplate().get(
				HrorderlyMessMaster.class, id);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				hrorderlyMessMaster.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				hrorderlyMessMaster.setStatus("y");
				dataDeleted = false;
			}
		}
		hrorderlyMessMaster.setLstChangedBy(changedBy);
		hrorderlyMessMaster.setLstChangedDate(currentDate);
		hrorderlyMessMaster.setLstChangedTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(hrorderlyMessMaster);
		hbt.refresh(hrorderlyMessMaster);
		return dataDeleted;
	}

	public boolean editMessToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String name = "";
		@SuppressWarnings("unused")
		String code = "";
		int id = 0;
		int unitId = 0;
		String changedBy = "";
		id = (Integer) generalMap.get("id");
		unitId = (Integer) generalMap.get("unitId");
		code = (String) generalMap.get("code");
		name = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		HrorderlyMessMaster hrorderlyMessMaster = (HrorderlyMessMaster) getHibernateTemplate()
				.get(HrorderlyMessMaster.class, id);

		hrorderlyMessMaster.setId(id);
		hrorderlyMessMaster.setMessName(name);
		hrorderlyMessMaster.setLstChangedBy(changedBy);
		hrorderlyMessMaster.setLstChangedDate(currentDate);
		hrorderlyMessMaster.setLstChangedTime(currentTime);
		if (unitId != 0) {
			MasUnit masUnit = new MasUnit();
			masUnit.setId(unitId);
			hrorderlyMessMaster.setUnitId(masUnit);
			//System.out.println("tradeid" + unitId);
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(hrorderlyMessMaster);
		hbt.refresh(hrorderlyMessMaster);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchMess(String code, String name) {
		List<HrorderlyMessMaster> messMasterList = new ArrayList<HrorderlyMessMaster>();
		Map<String, Object> MessFieldsMap = new HashMap<String, Object>();
		List gridCurrencyList = null;
		try {
			if ((name != null) || (code == null)) {
				messMasterList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.HrorderlyMessMaster as i where i.MessName like '"
										+ name + "%' order by i.MessName");
			} else {
				messMasterList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.HrorderlyMessMaster as i where i.MessCode like '"
										+ code + "%' order by i.MessCode");
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchMessList  " + e);
		}
		MessFieldsMap.put("messMasterList", messMasterList);
		return MessFieldsMap;
	}

	/**
	 * -------Leave choice Master Added by Yogesh started on 29th september 2009
	 */
	public Map<String, Object> showTrainClassGroupJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		List<TrainClassGroup> trainclassgroupList = new ArrayList<TrainClassGroup>();
		List<MasRankCategory> masrankcategoryList = new ArrayList<MasRankCategory>();
		trainclassgroupList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.TrainClassGroup tc where tc.Status='y'");
		masrankcategoryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasRankCategory");
		map.put("trainclassgroupList", trainclassgroupList);
		map.put("masrankcategoryList", masrankcategoryList);
		map.put("searchmasrankcategoryList", masrankcategoryList);

		return map;

	}

	public Map<String, Object> searchTrainClassGroupJsp(String searchField) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		List<TrainClassGroup> trainclassgroupList = new ArrayList<TrainClassGroup>();
		List<MasRankCategory> masrankcategoryList = new ArrayList<MasRankCategory>();
		List<MasRankCategory> searchmasrankcategoryList = new ArrayList<MasRankCategory>();
		trainclassgroupList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.TrainClassGroup tc where tc.Status='y'");
		masrankcategoryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasRankCategory");
		searchmasrankcategoryList = session.createCriteria(
				MasRankCategory.class).add(
				Restrictions.like("RankCategoryName", searchField + "%"))
				.list();
		map.put("trainclassgroupList", trainclassgroupList);
		map.put("masrankcategoryList", masrankcategoryList);
		map.put("searchmasrankcategoryList", searchmasrankcategoryList);
		return map;

	}

	public boolean addTrainClassGroupJsp(Map<String, Object> generalMap) {

		String deptStr = null;
		int rankCategoryId = 0;
		if (generalMap.get("deptStr") != null) {
			deptStr = (String) generalMap.get("deptStr");
		}

		if (generalMap.get("rankCategoryId") != null) {
			rankCategoryId = (Integer) generalMap.get("rankCategoryId");
		}

		boolean successfullyAdded = false;
		StringTokenizer strForDept = new StringTokenizer(deptStr, ",");

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			while (strForDept.hasMoreTokens()) {
				TrainClassGroup trainclassgroup = new TrainClassGroup();
				String trainclass = strForDept.nextToken();
				trainclassgroup.setTrainClasses(trainclass);
				trainclassgroup.setRankCategoryId(new MasRankCategory(
						rankCategoryId));
				trainclassgroup.setStatus("y");
				hbt.save(trainclassgroup);
				hbt.refresh(trainclassgroup);
			}
			successfullyAdded = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return successfullyAdded;
	}

	public boolean updateTrainClassGroupJsp(Map<String, Object> generalMap) {
		String deptStr = null;
		List<TrainClassGroup> trainclassgroupList = new ArrayList<TrainClassGroup>();
		Session session = (Session) getSession();
		String trainclassarray[] = null;
		int rankCategoryId = 0;
		if (generalMap.get("deptStr") != null) {
			deptStr = (String) generalMap.get("deptStr");
		}

		if (generalMap.get("rankCategoryId") != null) {
			rankCategoryId = (Integer) generalMap.get("rankCategoryId");
		}
		if (generalMap.get("deptIdArray") != null) {
			trainclassarray = (String[]) generalMap.get("deptIdArray");
		}

		boolean successfullyAdded = false;

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			Criteria ctr = session.createCriteria(TrainClassGroup.class)
					.createAlias("RankCategoryId", "rc").add(
							Restrictions.eq("rc.Id", rankCategoryId));
			trainclassgroupList = ctr.list();
			int counter = 0;
			if (trainclassgroupList.size() >= trainclassarray.length) {

				for (TrainClassGroup trainclassgroup : trainclassgroupList) {

					if (counter >= trainclassarray.length) {
						trainclassgroup.setStatus("n");
					}
					if (counter < trainclassarray.length) {
						trainclassgroup
								.setTrainClasses(trainclassarray[counter]);
						trainclassgroup.setStatus("y");
						counter++;
					}
					session.saveOrUpdate(trainclassgroup);
				}
				//System.out.println("trainclassarray::" + trainclassarray.length+ "trainclassgroupList::" + trainclassgroupList.size()+ "counter::" + counter);
			} else {
				int diff = trainclassarray.length - trainclassgroupList.size();
				for (TrainClassGroup trainclassgroup : trainclassgroupList) {
					trainclassgroup.setTrainClasses(trainclassarray[counter]);
					counter++;
					session.saveOrUpdate(trainclassgroup);
				}
				for (int i = 0; i < diff; i++) {
					TrainClassGroup trainclassgroup = new TrainClassGroup();
					trainclassgroup.setTrainClasses(trainclassarray[counter]);
					trainclassgroup.setRankCategoryId(new MasRankCategory(
							rankCategoryId));
					trainclassgroup.setStatus("y");
					session.save(trainclassgroup);
					session.refresh(trainclassgroup);
					counter++;
				}
			}

			successfullyAdded = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return successfullyAdded;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showLeaveChoiceApprovalJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		List<HrorderlyLeavechoice> hrorderlyLeaveChoiceList = new ArrayList<HrorderlyLeavechoice>();
		List<MasUnit> masUnitList = new ArrayList<MasUnit>();
		List<MasServiceType> masservicetypeList = new ArrayList<MasServiceType>();
		List<MasEmployee> masemployeeList = new ArrayList<MasEmployee>();
		hrorderlyLeaveChoiceList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.HrorderlyLeavechoice where Status='y' ");
		masUnitList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasUnit  as mt where  mt.DependentUnit='y' ");
		masservicetypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasServiceType");
		masemployeeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasEmployee where Status='y' ");
		map.put("hrorderlyLeaveChoiceList", hrorderlyLeaveChoiceList);
		map.put("masemployeeList", masemployeeList);
		map.put("masUnitList", masUnitList);
		map.put("masservicetypeList", masservicetypeList);
		//System.out.println("hrorderlyLeaveChoiceList"	+ hrorderlyLeaveChoiceList.size());

		return map;
	}

	public boolean updateLeaveChoiceApprovalJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		List<HrorderlyLeavechoice> hrorderlyLeaveChoiceList = new ArrayList<HrorderlyLeavechoice>();
		HrorderlyLeavechoice hrorderlyleavechoice = null;
		int leavechoiceId = 0;
		boolean successfull = false;
		String approved = "";
		String Signature = "";
		String remarks = "";
		if (box.getString("Approved") != null
				&& !box.getString("Approved").equals("")) {
			approved = box.getString("Approved");
		}
		if (box.getString("Signature") != null
				&& !box.getString("Signature").equals("")) {
			Signature = box.getString("Signature");
		}
		if (box.getString("remarks") != null
				&& !box.getString("remarks").equals("")) {
			remarks = box.getString("remarks");
		}
		if (box.getString("commonId") != null
				&& !box.getString("commonId").equals("")) {
			leavechoiceId = Integer.parseInt(box.getString("commonId"));
		}
		//System.out.println("leavechoiceId::" + leavechoiceId);
		try {
			hrorderlyleavechoice = (HrorderlyLeavechoice) getHibernateTemplate()
					.get(HrorderlyLeavechoice.class, leavechoiceId);
			//System.out.println("hrorderlyleavechoice::"+ hrorderlyleavechoice.getEmployeeId().getId());
			hrorderlyleavechoice.setLcApprovedStatus(approved);
			hrorderlyleavechoice.setSignature(Signature);
			hrorderlyleavechoice.setLeaveChoiceRemarks(remarks);
			hbt.saveOrUpdate(hrorderlyleavechoice);
			hbt.refresh(hrorderlyleavechoice);
			successfull = true;
		} catch (Exception exc) {

		}
		return successfull;

	}

	public Map<String, Object> searchLeaveChoiceApprovalJsp(
			String selectedRadio, String searchfield) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrorderlyLeavechoice> hrorderlyLeaveChoiceList = new ArrayList<HrorderlyLeavechoice>();
		List<MasUnit> masUnitList = new ArrayList<MasUnit>();
		List<MasServiceType> masservicetypeList = new ArrayList<MasServiceType>();
		List<MasEmployee> masemployeeList = new ArrayList<MasEmployee>();
		masUnitList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasUnit  as mt where  mt.DependentUnit='y' ");
		masservicetypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasServiceType");
		masemployeeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasEmployee where Status='y' ");
		Criteria ctr = session.createCriteria(HrorderlyLeavechoice.class).add(
				Restrictions.eq("Status", "y"))
				.createAlias("EmployeeId", "emp");
		if (selectedRadio.equals("1")) {
			if (searchfield != null && !searchfield.equals("")) {
				ctr = ctr.add(Restrictions.like("emp.ServiceNo", Integer
						.parseInt(searchfield)
						+ "%"));
			}
		} else if (selectedRadio.equals("2")) {
			if (searchfield != null && !searchfield.equals("")) {
				ctr = ctr.add(Restrictions.like("emp.FirstName", searchfield
						+ "%"));
			}
		}
		hrorderlyLeaveChoiceList = ctr.list();
		map.put("hrorderlyLeaveChoiceList", hrorderlyLeaveChoiceList);
		map.put("masemployeeList", masemployeeList);
		map.put("masUnitList", masUnitList);
		map.put("masservicetypeList", masservicetypeList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showLeaveChoiceJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		List<HrorderlyLeavechoice> hrorderlyLeaveChoiceList = new ArrayList<HrorderlyLeavechoice>();
		List<MasUnit> masUnitList = new ArrayList<MasUnit>();
		List<MasServiceType> masservicetypeList = new ArrayList<MasServiceType>();
		hrorderlyLeaveChoiceList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.HrorderlyLeavechoice ");
		masUnitList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasUnit  as mt where  mt.DependentUnit='y' ");
		masservicetypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasServiceType");
		map.put("hrorderlyLeaveChoiceList", hrorderlyLeaveChoiceList);
		map.put("masUnitList", masUnitList);
		map.put("masservicetypeList", masservicetypeList);
		//System.out.println("hrorderlyLeaveChoiceList"+ hrorderlyLeaveChoiceList.size());

		return map;
	}

	public boolean addLeaveChoice(HrorderlyLeavechoice hrorderlyLeaveChoice) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(hrorderlyLeaveChoice);
		hbt.refresh(hrorderlyLeaveChoice);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public Map<String, Object> CheckEmployee(String serviceNo,
			String servicetype) {
		boolean flag = false;
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrorderlyLeavechoice> hrorderlyleavechoiceList = new ArrayList<HrorderlyLeavechoice>();
		List<MasEmployee> masemployeeList = new ArrayList<MasEmployee>();
		masemployeeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasEmployee as me where me.ServiceNo="
						+ serviceNo + "and me.ServiceType=" + servicetype);
		if (masemployeeList == null || masemployeeList.size() == 0) {
			flag = false;
		} else {
			flag = true;
			//System.out.println("flag   " + flag + "masemployeeList id  "+ masemployeeList.get(0).getId());
			hrorderlyleavechoiceList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.HrorderlyLeavechoice as hlc where hlc.EmployeeId="
									+ masemployeeList.get(0).getId());

		}

		map.put("flag", flag);
		map.put("hrorderlyleavechoiceList", hrorderlyleavechoiceList);
		map.put("masemployeeList", masemployeeList);

		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteLeaveChoice(int id, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		HrorderlyLeavechoice hrorderlyleavechoice = new HrorderlyLeavechoice();
		hrorderlyleavechoice = (HrorderlyLeavechoice) getHibernateTemplate()
				.get(HrorderlyLeavechoice.class, id);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				hrorderlyleavechoice.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				hrorderlyleavechoice.setStatus("y");
				dataDeleted = false;
			}
		}
		hrorderlyleavechoice.setLastChgBy(changedBy);
		hrorderlyleavechoice.setLastChgDate(currentDate);
		hrorderlyleavechoice.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(hrorderlyleavechoice);
		hbt.refresh(hrorderlyleavechoice);
		return dataDeleted;
	}

	public boolean editLeaveChoiceToDatabase(
			HrorderlyLeavechoice hrorderlyleavechoice) {
		boolean dataUpdated = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(hrorderlyleavechoice);
		hbt.refresh(hrorderlyleavechoice);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchLeaveChoice(String code, String name) {
		List<MasEmployee> masemployeeList = new ArrayList<MasEmployee>();
		List<HrorderlyLeavechoice> hrorderlyleavechoice1 = new ArrayList<HrorderlyLeavechoice>();
		List<HrorderlyLeavechoice> hrorderlyleavechoice = new ArrayList<HrorderlyLeavechoice>();
		Map<String, Object> MessFieldsMap = new HashMap<String, Object>();
		List gridCurrencyList = null;
		try {
			if ((name == null) || (code != null)) {
				masemployeeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasEmployee as i where i.ServiceNo like '"
								+ code + "%' order by i.ServiceNo");
			} else {
				masemployeeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasEmployee as i where i.EmployeeCode like '"
								+ name + "%' order by i.EmployeeCode");
			}
			if (masemployeeList != null && masemployeeList.size() > 0) {
				for (MasEmployee masemployee : masemployeeList) {
					hrorderlyleavechoice1 = getHibernateTemplate()
							.find(
									"from jkt.hms.masters.business.HrorderlyLeavechoice as hlc where hlc.EmployeeId="
											+ masemployee.getId());
					for (int i = 0; i < hrorderlyleavechoice1.size(); i++) {
						hrorderlyleavechoice.add(hrorderlyleavechoice1.get(i));
					}
				}
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchMessList  " + e);
		}

		MessFieldsMap.put("hrorderlyLeaveChoiceList", hrorderlyleavechoice);
		return MessFieldsMap;
	}

	/**
	 * ------- Leave Type Master Added by Priyanka started on 4th May 2009
	 */
	public boolean addLeaveType(HrLeaveTypeMaster hrLeaveTypeMaster) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(hrLeaveTypeMaster);
		hbt.refresh(hrLeaveTypeMaster);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteLeaveType(int id, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		HrLeaveTypeMaster hrLeaveTypeMaster = new HrLeaveTypeMaster();
		hrLeaveTypeMaster = (HrLeaveTypeMaster) getHibernateTemplate().get(
				HrLeaveTypeMaster.class, id);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				hrLeaveTypeMaster.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				hrLeaveTypeMaster.setStatus("y");
				dataDeleted = false;
			}
		}
		hrLeaveTypeMaster.setLastChgBy(changedBy);
		hrLeaveTypeMaster.setLastChgDate(currentDate);
		hrLeaveTypeMaster.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(hrLeaveTypeMaster);
		hbt.refresh(hrLeaveTypeMaster);
		return dataDeleted;
	}

	public boolean editLeaveTypeToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String details = "";
		@SuppressWarnings("unused")
		String leaveType = "";
		int id = 0;
		int days = 0;
		String changedBy = "";
		String status = "";
		id = (Integer) generalMap.get("id");
		leaveType = (String) generalMap.get("leaveType");
		details = (String) generalMap.get("details");
		days = (Integer) generalMap.get("days");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		status = (String) generalMap.get("status");
		HrLeaveTypeMaster hrLeaveTypeMaster = (HrLeaveTypeMaster) getHibernateTemplate()
				.get(HrLeaveTypeMaster.class, id);

		hrLeaveTypeMaster.setId(id);
		hrLeaveTypeMaster.setLeaveType(leaveType);
		hrLeaveTypeMaster.setDetails(details);
		hrLeaveTypeMaster.setDays(days);
		hrLeaveTypeMaster.setStatus(status);
		hrLeaveTypeMaster.setLastChgBy(changedBy);
		hrLeaveTypeMaster.setLastChgDate(currentDate);
		hrLeaveTypeMaster.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(hrLeaveTypeMaster);
		hbt.refresh(hrLeaveTypeMaster);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchLeaveType(String leaveType, String details) {
		List<HrLeaveTypeMaster> searchLeaveTypeList = new ArrayList<HrLeaveTypeMaster>();
		Map<String, Object> leaveFieldsMap = new HashMap<String, Object>();
		List gridCurrencyList = null;
		try {
			if ((leaveType != null) || (details == null)) {
				searchLeaveTypeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.HrLeaveTypeMaster as i where i.LeaveType like '"
								+ leaveType + "%' order by i.LeaveType");
			} else {
				searchLeaveTypeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.HrLeaveTypeMaster as i where i.Details like '"
								+ details + "%' order by i.Details");
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchLeaveTypeList  " + e);
		}
		leaveFieldsMap.put("searchLeaveTypeList", searchLeaveTypeList);
		return leaveFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showLeaveTypeJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrLeaveTypeMaster> searchLeaveTypeList = new ArrayList<HrLeaveTypeMaster>();
		searchLeaveTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.HrLeaveTypeMaster ");
		map.put("searchLeaveTypeList", searchLeaveTypeList);
		return map;
	}

	/**
	 * ------- Class Master Added by Priyanka started on 8th July 2009
	 */
	public boolean addClass(HrClassMaster hrClassMaster) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(hrClassMaster);
		hbt.refresh(hrClassMaster);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteClass(int id, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		HrClassMaster hrClassMaster = new HrClassMaster();
		hrClassMaster = (HrClassMaster) getHibernateTemplate().get(
				HrClassMaster.class, id);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				hrClassMaster.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				hrClassMaster.setStatus("y");
				dataDeleted = false;
			}
		}
		hrClassMaster.setLastChgBy(changedBy);
		hrClassMaster.setLastChgDate(currentDate);
		hrClassMaster.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(hrClassMaster);
		hbt.refresh(hrClassMaster);
		return dataDeleted;
	}

	public boolean editClassToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String name = "";
		@SuppressWarnings("unused")
		String code = "";
		int id = 0;
		int specialityId = 0;
		String changedBy = "";
		id = (Integer) generalMap.get("id");
		code = (String) generalMap.get("code");
		name = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		specialityId = (Integer) generalMap.get("specialityId");
		HrClassMaster hrClassMaster = (HrClassMaster) getHibernateTemplate()
				.get(HrClassMaster.class, id);

		hrClassMaster.setId(id);
		hrClassMaster.setClassName(name);
		if (specialityId != 0) {
			HrSpecialistMaster hrspeciality = new HrSpecialistMaster();
			hrspeciality.setId(specialityId);
			hrClassMaster.setSpeciality(hrspeciality);
		}

		hrClassMaster.setLastChgBy(changedBy);
		hrClassMaster.setLastChgDate(currentDate);
		hrClassMaster.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(hrClassMaster);
		hbt.refresh(hrClassMaster);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchClass(String code, String name) {
		List<HrClassMaster> searchClassList = new ArrayList<HrClassMaster>();
		Map<String, Object> specialityFieldsMap = new HashMap<String, Object>();
		List gridCurrencyList = null;
		try {
			if ((name != null) || (code == null)) {
				searchClassList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.HrClassMaster as i where i.ClassName like '"
								+ name + "%' order by i.ClassName");
			} else {
				searchClassList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.HrClassMaster as i where i.ClassCode like '"
								+ code + "%' order by i.ClassCode");
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchClassList  " + e);
		}
		specialityFieldsMap.put("searchClassList", searchClassList);
		return specialityFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showClassJsp() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrClassMaster> searchClassList = new ArrayList<HrClassMaster>();
		List<HrSpecialistMaster> searchSpecialistList = new ArrayList<HrSpecialistMaster>();
		searchSpecialistList = session.createCriteria(HrSpecialistMaster.class)
				.add(Restrictions.eq("Status", "y")).list();
		searchClassList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.HrClassMaster ");
		map.put("searchClassList", searchClassList);
		map.put("searchSpecialistList", searchSpecialistList);

		return map;
	}

	// ::::::::::::::::::End added by yogesh on 08/10/2009 for hr master
}
