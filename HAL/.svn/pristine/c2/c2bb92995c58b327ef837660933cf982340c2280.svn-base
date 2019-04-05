package jkt.hms.masters.dataservice;
import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.COMMON_ID;
import static jkt.hms.util.RequestConstants.DEPOT_ID;
import static jkt.hms.util.RequestConstants.UNIT_ID;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.MasLocation;
import jkt.hms.masters.business.FaMasAccount;
import jkt.hms.masters.business.FaMasSubLed;
import jkt.hms.masters.business.MasAdministrativeSex;

import jkt.hms.masters.business.MasBankMaster;
import jkt.hms.masters.business.MasBlock;

import jkt.hms.masters.business.MasCountry;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDepartmentType;

import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasEmpCategory;
import jkt.hms.masters.business.MasEmpStatus;
import jkt.hms.masters.business.MasEmployee;

import jkt.hms.masters.business.MasGrade;

import jkt.hms.masters.business.MasHospital;

import jkt.hms.masters.business.MasMaritalStatus;

import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasRankCategory;
import jkt.hms.masters.business.MasRelation;
import jkt.hms.masters.business.MasReligion;

import jkt.hms.masters.business.MasServiceStatus;
import jkt.hms.masters.business.MasServiceType;
import jkt.hms.masters.business.MasState;
import jkt.hms.masters.business.MasStoreFinancial;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasStoreSupplier;
import jkt.hms.masters.business.MasTemplate;
import jkt.hms.masters.business.MasTitle;
import jkt.hms.masters.business.MasTrade;

import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.MasUnitOfMeasurement;

import jkt.hms.masters.business.UploadDocuments;

import jkt.hms.masters.business.UserTemplate;
import jkt.hms.masters.business.Users;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.jfree.chart.plot.FastScatterPlot;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class MastersDataServiceImpl extends HibernateDaoSupport implements MastersDataService {

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showHospitalJsp() {
			Map<String, Object> map = new HashMap<String, Object>();
			List<MasHospital> searchHospitalList = new ArrayList<MasHospital>();
			//List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
			//List<MasNrs> nrsList = new ArrayList<MasNrs>();
			Session session = (Session)getSession();
			searchHospitalList = session.createCriteria(MasHospital.class).list();
			//serviceTypeList = session.createCriteria(MasServiceType.class).add(Restrictions.eq("Status", "y"))  .list();
			//nrsList= session.createCriteria(MasNrs.class).add(Restrictions.eq("Status", "y")) .list();
			map.put("searchHospitalList", searchHospitalList);
			//map.put("serviceTypeList", serviceTypeList);
			//map.put("nrsList", nrsList);
			
			
			List<MasUnitOfMeasurement> uomList = new ArrayList<MasUnitOfMeasurement>();
			uomList = session.createCriteria(MasUnitOfMeasurement.class).addOrder(Order.desc("UnitOfMeasurementName")).list();
			map.put("uomList", uomList);
			
			
			List<MasDistrict> districtList = new ArrayList<MasDistrict>();
			//districtList = session.createCriteria(MasDistrict.class)
			
			districtList = session.createCriteria(MasDistrict.class).createAlias("State", "st").add(Restrictions.eq("st.Id", 17)).addOrder(Order.asc("DistrictName")).add(Restrictions.eq("Status", "y")).list();
			System.out.println("districtList===="+districtList.size());
			map.put("districtList", districtList);
			

			
			List<MasHospitalDetails> masHospitalDetailsList = new ArrayList<MasHospitalDetails>();
			masHospitalDetailsList = session.createCriteria(MasHospitalDetails.class).list();
			
			map.put("masHospitalDetailsList", masHospitalDetailsList);
			
			return map;
		}
	public boolean addHospital(MasHospital masHospital , Map<String, Object> generalMap) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			hbt.save(masHospital);
			
					
			int hospitalId = masHospital.getId();
			String districtStr = "";
			System.out.println(generalMap.get("districtStr"));
			if (generalMap.get("districtStr") != null) {
				districtStr = (String) generalMap.get("districtStr");
			}
				
			
			StringTokenizer str = new StringTokenizer(districtStr, ",");
			
			while (str.hasMoreTokens()) {
				MasHospitalDetails masHospitalDetails = new MasHospitalDetails();

				int distrinctId = Integer.parseInt(str.nextToken());
				MasDistrict masDistrict = new MasDistrict();
				masDistrict.setId(distrinctId);
				masHospitalDetails.setDistrict(masDistrict);

				MasHospital h = new MasHospital();
				h.setId(hospitalId);
				masHospitalDetails.setHospital(h);
	
				
				hbt.save(masHospitalDetails);
				

			}


		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		successfullyAdded = true;
		return successfullyAdded;
	}
	@SuppressWarnings("unused")
	public boolean editHospitalToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Session session = (Session) getSession();

		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String hospitalName = "";
		String hospitalNameKann = "";
		String hospitalCode = "";
		String hospitalAddress = "";
		String contactNumber = "";
		int storeId = 0;
		int percentageforHRA=0;
		String changedBy = "";
		int command = 0;
		String unitType = "";
		int userId = 0;
		BigDecimal storageCapacity=null;
		BigDecimal goDown=null;
		if(generalMap.get("userId")!=null){
			userId = (Integer)generalMap.get("userId");
		}
		int capacityUom=0;
		
		String districtStr = "";
		if (generalMap.get("districtStr") != null) {
			districtStr = (String) generalMap.get("districtStr");
		}
		StringTokenizer str = new StringTokenizer(districtStr, ",");

		/*int serviceType=0;
		int nrs=0;*/
		try {
			

		
			storeId = (Integer) generalMap.get("id");
			hospitalCode = (String) generalMap.get("hospitalCode");
			hospitalName = (String) generalMap.get("name");
			hospitalNameKann = (String) generalMap.get("hospitalNameKann");
			hospitalAddress = (String) generalMap.get("hospitalAddress");
			contactNumber = (String) generalMap.get("contactNumber");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			unitType = (String) generalMap.get("unitType");
			percentageforHRA = (Integer)generalMap.get("percentageforHRA"); 
		/*	serviceType = (Integer) generalMap.get("serviceType");
			nrs = (Integer) generalMap.get("nrs");*/
			capacityUom = (Integer) generalMap.get("capacityUom");
			goDown = (BigDecimal) generalMap.get("goDown");
			storageCapacity = (BigDecimal) generalMap.get("storageCapacity");
			if(generalMap.get("command")!=null)
				command = (Integer)generalMap.get("command");
		} catch (Exception e) {
			e.printStackTrace();
		}

		MasHospital masHospital = (MasHospital) getHibernateTemplate().get(
				MasHospital.class, storeId);

		masHospital.setId(storeId);
		masHospital.setHospitalName(hospitalName);
		masHospital.setHospitalNameKann(hospitalNameKann);
		masHospital.setAddress(hospitalAddress);
		masHospital.setContactNumber(contactNumber);
		masHospital.setUnitType(unitType);
		masHospital.setPercentageforHRA(percentageforHRA);
		
		Users user = new Users();
		user.setId(userId);
		masHospital.setLastChgBy(user);
		
		/*if(unitType.equalsIgnoreCase("unit"))
		{
			MasServiceType mst = new MasServiceType(serviceType);
			masHospital.setServiceType(mst);
		}
		
		MasNrs masNrs = new MasNrs(nrs);
		masHospital.setNrs(masNrs);*/
		
		masHospital.setStorageCapacity(storageCapacity);
		
		
		if(capacityUom !=0)
		  {
			MasUnitOfMeasurement l =new MasUnitOfMeasurement();
			l.setId(capacityUom);
			masHospital.setCapacityUom(l);
		  }
		  
		masHospital.setGoDown(goDown);
		
		
		
		
	
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(masHospital);
			dataUpdated = true;
					
			
			
			List<MasHospitalDetails> mhd = session.createCriteria(MasHospitalDetails.class).add(Restrictions.eq("Hospital.Id", storeId)).list();

			for (MasHospitalDetails m : mhd) {
				
				int id = m.getId();
				System.out.println(id);
				String hql = "delete from jkt.hms.masters.business.MasHospitalDetails as a where a.Id = "+ id;
				Query query = session.createQuery(hql);
				int row = query.executeUpdate();
			}

			while (str.hasMoreTokens()) {
				MasHospitalDetails masHospitalDetails = new MasHospitalDetails();

				int disrinctId = Integer.parseInt(str.nextToken());

				MasDistrict masDistrict = new MasDistrict();
				masDistrict.setId(disrinctId);
				masHospitalDetails.setDistrict(masDistrict);

				MasHospital h = new MasHospital();
				h.setId(storeId);
				masHospitalDetails.setHospital(h);

				
				hbt.save(masHospitalDetails);
			}

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	public boolean deleteHospital(int storeId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		int userId = 0;
		if(generalMap.get("userId")!=null){
			userId = (Integer)generalMap.get("userId");
		}
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasHospital masHospital = new MasHospital();
		masHospital = (MasHospital) getHibernateTemplate().get(
				MasHospital.class, storeId);
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
		//masHospital.setLastChgBy(changedBy);
		masHospital.setLastChgDate(currentDate);
		masHospital.setLastChgTime(currentTime);
		Users user = new Users();
		user.setId(userId);
		masHospital.setLastChgBy(user);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(masHospital);
		return dataDeleted;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchHospital(String hospitalCode,
			String hospitalName) {
		List<MasHospital> searchHospitalList = new ArrayList<MasHospital>();
		Map<String, Object> userGroupsFieldsMap = new HashMap<String, Object>();
		Session session = (Session)getSession();
		try {
			if ((hospitalName != null) || (hospitalCode == null)) {
				searchHospitalList = session.createCriteria(MasHospital.class).add(Restrictions.like("HospitalName", "%"+hospitalName+"%").ignoreCase()).addOrder(Order.asc("HospitalName")).list();

			} else {
				searchHospitalList = session.createCriteria(MasHospital.class).add(Restrictions.like("HospitalCode", "%"+hospitalCode+"%").ignoreCase()).addOrder(Order.asc("HospitalCode")).list();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<MasUnitOfMeasurement> uomList = new ArrayList<MasUnitOfMeasurement>();
		uomList = session.createCriteria(MasUnitOfMeasurement.class).addOrder(Order.desc("UnitOfMeasurementName")).list();
		userGroupsFieldsMap.put("uomList", uomList);
		
		List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		districtList = session.createCriteria(MasDistrict.class).addOrder(Order.desc("DistrictName")).list();
		userGroupsFieldsMap.put("districtList", districtList);
		
		
		List<MasHospitalDetails> masHospitalDetailsList = new ArrayList<MasHospitalDetails>();
		masHospitalDetailsList = session.createCriteria(MasHospitalDetails.class).list();
		
		userGroupsFieldsMap.put("masHospitalDetailsList", masHospitalDetailsList);
		userGroupsFieldsMap.put("searchHospitalList", searchHospitalList);
		return userGroupsFieldsMap;
	}
	
	public boolean addDepartment(MasDepartment masDepartment) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masDepartment);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteDepartment(int departmentId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int userId = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasDepartment masDepartment = new MasDepartment();
		masDepartment = (MasDepartment) getHibernateTemplate().load(
				MasDepartment.class, departmentId);
		/*@SuppressWarnings("unused")
		Integer departmentTypeId = masDepartment.getDepartmentType().getId();*/
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masDepartment.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masDepartment.setStatus("y");
				dataDeleted = false;
			}
		}
		Users user = new Users();
		user.setId(userId);
		masDepartment.setLastChgBy(user);
		masDepartment.setLastChgDate(currentDate);
		masDepartment.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDepartment);
		return dataDeleted;

	}

	public boolean editDepartmentToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int departmentTypeId = 0;
		String departmentName = "";
		@SuppressWarnings("unused")
		String departmentCode = "";
		int departmentId = 0;
	
		departmentId = (Integer) generalMap.get("id");
		departmentCode = (String) generalMap.get("departmentCode");
		departmentName = (String) generalMap.get("name");
		/*departmentTypeId = (Integer) generalMap.get("departmentTypeId");*/

int userId=0;
userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasDepartment masDepartment = (MasDepartment) getHibernateTemplate()
				.load(MasDepartment.class, departmentId);

		masDepartment.setId(departmentId);
		masDepartment.setDepartmentName(departmentName);

		/*MasDepartmentType masDepartmentType = new MasDepartmentType();
		masDepartmentType.setId(departmentTypeId);
		masDepartment.setDepartmentType(masDepartmentType);*/
		Users user = new Users();
		user.setId(userId);
		masDepartment.setLastChgBy(user);
		masDepartment.setLastChgDate(currentDate);
		masDepartment.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDepartment);
		dataUpdated = true;
		return dataUpdated;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchDepartment(String departmentCode,
			String departmentName) {
		List<MasDepartment> searchDepartmentList = new ArrayList<MasDepartment>();
		List departmentTypeList = null;
		List costCenterList = null;
		Map<String, Object> departmentFieldsMap = new HashMap<String, Object>();
		List gridCostCenterList = null;
		Session session = (Session)getSession();
		try {
			if ((departmentName != null) || (departmentCode == null)) {

				searchDepartmentList = session.createCriteria(MasDepartment.class).add(Restrictions.like("DepartmentName", "%"+departmentName+"%").ignoreCase()).addOrder(Order.asc("DepartmentName")).list();
				
			} else {
				searchDepartmentList = session.createCriteria(MasDepartment.class).add(Restrictions.like("DepartmentCode", "%"+departmentCode+"%").ignoreCase()).addOrder(Order.asc("DepartmentCode")).list();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		departmentTypeList = session.createCriteria(MasDepartmentType.class).add(Restrictions.eq("Status", "y")).list();
		departmentFieldsMap.put("gridCostCenterList", gridCostCenterList);
		departmentFieldsMap.put("searchDepartmentList", searchDepartmentList);
		departmentFieldsMap.put("departmentTypeList", departmentTypeList);
		departmentFieldsMap.put("costCenterList", costCenterList);
		return departmentFieldsMap;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showDepartmentJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> searchDepartmentList = new ArrayList<MasDepartment>();
		//List<MasDepartmentType> departmentTypeList = new ArrayList<MasDepartmentType>();
		List<MasDepartmentType> gridDepartmentTypeList = new ArrayList<MasDepartmentType>();
		Session session = (Session)getSession();
		searchDepartmentList = session.createCriteria(MasDepartment.class).addOrder(Order.asc("DepartmentName")).list();
		//departmentTypeList =  session.createCriteria(MasDepartmentType.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("DepartmentTypeName")).list();
		//gridDepartmentTypeList =  session.createCriteria(MasDepartmentType.class).list();
		map.put("searchDepartmentList", searchDepartmentList);
		//map.put("gridDepartmentTypeList", gridDepartmentTypeList);
		//map.put("departmentTypeList", departmentTypeList);

		return map;
	}
	
	// ---------------------------------- Rank -------------------------
	public boolean addRank(MasRank masRank) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masRank);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteRank(int rankId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasRank masRank = new MasRank();
		masRank = (MasRank) getHibernateTemplate().load(MasRank.class, rankId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		
		int userId=0;
		userId = (Integer) generalMap.get("userId");
		
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masRank.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masRank.setStatus("y");
				dataDeleted = false;
			}
		}

		Users user = new Users();
		user.setId(userId);
		masRank.setLastChgBy(user);
		
		masRank.setLastChgDate(currentDate);
		masRank.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masRank);
		return dataDeleted;
	}

	public boolean editRankToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int gradeId = 0;
		int departmentId = 0;
		int rankId = 0;
		String rankName = "";
		@SuppressWarnings("unused")
		String rankCode = "";
		int designationOrder=0;
		int otherAllownace=0;
		BigDecimal allowanceAmount = new BigDecimal(0);
		
		
		
		designationOrder=(Integer) generalMap.get("designationOrder");
		rankId = (Integer) generalMap.get("id");
		rankCode = (String) generalMap.get("rankCode");
		rankName = (String) generalMap.get("name");
		departmentId = (Integer) generalMap.get("departmentId");
		gradeId = (Integer) generalMap.get("gradeId");
		otherAllownace = (Integer)generalMap.get("otherAllownace");
		allowanceAmount =  (BigDecimal)generalMap.get("allowanceAmount");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		int approvePost=0;
		String payScale="";
		String modeDirect="";
		String modePromotion="";
		String modeDeputation="";
		String modeContract="";
		BigDecimal directPercent=null;
		BigDecimal promotionPercent=null;
		BigDecimal contractPercent=null;
		int minAge=0;
		int maxAge=0;
		String qualification="";
		
		
		qualification = (String) generalMap.get("qualification");
		payScale = (String) generalMap.get("payScale");
		modeDirect = (String) generalMap.get("modeDirect");
		modePromotion = (String) generalMap.get("modePromotion");
		modeContract = (String) generalMap.get("modeContract");
		modeDeputation = (String) generalMap.get("modeDeputation");
		
		minAge = (Integer) generalMap.get("minAge");
		maxAge = (Integer) generalMap.get("maxAge");
		approvePost = (Integer) generalMap.get("approvePost");

		directPercent = (BigDecimal) generalMap.get("directPercent");
		promotionPercent = (BigDecimal) generalMap.get("promotionPercent");
		contractPercent = (BigDecimal) generalMap.get("contractPercent");
		
		int userId=0;
		userId = (Integer) generalMap.get("userId");
		
		MasRank masRank = (MasRank) getHibernateTemplate().load(MasRank.class,
				rankId);

		masRank.setId(rankId);
		masRank.setRankName(rankName);
		masRank.setRankCode(rankCode);

		MasDepartment d = new MasDepartment();
		d.setId(departmentId);
		masRank.setDepartment(d);

		MasGrade g = new MasGrade();
		g.setId(gradeId);
		masRank.setGrade(g);

		masRank.setPostApproved(approvePost);
		masRank.setPayScale(payScale);
		masRank.setOtherAllowance(otherAllownace);
		masRank.setAllowanceAmount(allowanceAmount);
		masRank.setModeDirect(modeDirect);
		masRank.setModePromotion(modePromotion);
		masRank.setModeDeputation(modeDeputation);
		masRank.setModeContract(modeContract);
		masRank.setDirectPercent(directPercent);
		masRank.setPromotionPercent(promotionPercent);
		masRank.setContractPercent(contractPercent);
		masRank.setMinAge(minAge);
		masRank.setMaxAge(maxAge);
		masRank.setQualification(qualification);
		masRank.setDesignationOrder(designationOrder);
		Users user = new Users();
		user.setId(userId);
		masRank.setLastChgBy(user);
		masRank.setLastChgDate(currentDate);
		masRank.setLastChgTime(currentTime);

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masRank);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchRank(String rankCode, String rankName) {
		List<MasRank> searchRankList = new ArrayList<MasRank>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasGrade> gradeList = new ArrayList<MasGrade>();
		Session session = (Session)getSession();
		List gridGradeList =null;
		List gridDepartmentList =null;
		Map<String, Object> rankFieldsMap = new HashMap<String, Object>();
		try {
			if ((rankName != null) || (rankCode == null)) {
				searchRankList = session.createCriteria(MasRank.class).add(Restrictions.like("RankName", "%"+rankName+"%").ignoreCase()).addOrder(Order.asc("RankName")).list();
			} else {
				searchRankList = session.createCriteria(MasRank.class).add(Restrictions.like("RankCode", "%"+rankCode+"%").ignoreCase()).addOrder(Order.asc("RankCode")).list();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("DepartmentName")).list();
		gradeList = session.createCriteria(MasGrade.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("GradeName")).list();
		gridGradeList = session.createCriteria(MasGrade.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("GradeName")).list();
		gridDepartmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("DepartmentName")).list();
		rankFieldsMap.put("searchRankList", searchRankList);
		rankFieldsMap.put("departmentList", departmentList);
		rankFieldsMap.put("gradeList", gradeList);
		rankFieldsMap.put("gridDepartmentList", gridDepartmentList);
		rankFieldsMap.put("gridGradeList", gridGradeList);
		return rankFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showRankJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List gridGradeList =null;
		List gridDepartmentList =null;
		List<MasRank> searchRankList = new ArrayList<MasRank>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasGrade> gradeList = new ArrayList<MasGrade>();
		Session session = (Session)getSession();
		searchRankList = session.createCriteria(MasRank.class).list();
		departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("DepartmentName")).list();
		gradeList = session.createCriteria(MasGrade.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("GradeName")).list();
		gridGradeList = session.createCriteria(MasGrade.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("GradeName")).list();
		gridDepartmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("DepartmentName")).list();
		
		map.put("searchRankList", searchRankList);
		map.put("departmentList", departmentList);
		map.put("gradeList", gradeList);
		map.put("gridDepartmentList", gridDepartmentList);
		map.put("gridGradeList", gridGradeList);
		return map;
	}
	
	// ------------------------------- Rank Category
	// -------------------------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> showRankCategoryJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRankCategory> searchRankCategoryList = new ArrayList<MasRankCategory>();
		Session session = (Session)getSession();
		searchRankCategoryList = session.createCriteria(MasRankCategory.class).list();
		map.put("searchRankCategoryList", searchRankCategoryList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchRankCategory(String rankCategoryCode,
			String rankCategoryName) {
		List<MasRankCategory> searchRankCategoryList = new ArrayList<MasRankCategory>();
		Session session = (Session)getSession();
		Map rankCategoryFieldsMap = new HashMap();
		try {
			if ((rankCategoryName != null) || (rankCategoryCode == null)) {
				searchRankCategoryList = session.createCriteria(MasRankCategory.class).add(Restrictions.like("RankCategoryName", "%"+rankCategoryName+"%").ignoreCase()).addOrder(Order.asc("RankCategoryName")).list();
			} else {
				searchRankCategoryList = session.createCriteria(MasRankCategory.class).add(Restrictions.like("RankCategoryCode", "%"+rankCategoryCode+"%").ignoreCase()).addOrder(Order.asc("RankCategoryCode")).list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rankCategoryFieldsMap.put("searchRankCategoryList",
				searchRankCategoryList);
		return rankCategoryFieldsMap;
	}

	public boolean editRankCategoryToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String rankCategoryName = "";
		@SuppressWarnings("unused")
		String rankCategoryCode = "";
		int rankCategoryId = 0;
		String changedBy = "";
		rankCategoryId = (Integer) generalMap.get("id");
		rankCategoryCode = (String) generalMap.get("rankCategoryCode");
		rankCategoryName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasRankCategory masRankCategory = (MasRankCategory) getHibernateTemplate()
				.get(MasRankCategory.class, rankCategoryId);

		masRankCategory.setId(rankCategoryId);
		masRankCategory.setRankCategoryName(rankCategoryName);
		masRankCategory.setLastChgBy(changedBy);
		masRankCategory.setLastChgDate(currentDate);
		masRankCategory.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masRankCategory);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean addRankCategory(MasRankCategory masRankCategory) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masRankCategory);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteRankCategory(int rankCategoryId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasRankCategory masRankCategory = new MasRankCategory();
		masRankCategory = (MasRankCategory) getHibernateTemplate().get(
				MasRankCategory.class, rankCategoryId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (masRankCategory.getStatus().equals("y")) {
			masRankCategory.setStatus("n");
			dataDeleted = true;
		} else {
			masRankCategory.setStatus("y");
			dataDeleted = false;
		}
		masRankCategory.setLastChgBy(changedBy);
		masRankCategory.setLastChgDate(currentDate);
		masRankCategory.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masRankCategory);
		return dataDeleted;
	}
	
	public boolean addUnit(MasUnit masUnit) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masUnit);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteUnit(int unitId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		MasUnit masUnit = new MasUnit();
		masUnit = (MasUnit) getHibernateTemplate().load(MasUnit.class, unitId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masUnit.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masUnit.setStatus("y");
				dataDeleted = false;
			}
		}
		masUnit.setLastChgBy(changedBy);
		masUnit.setLastChgDate(currentDate);
		masUnit.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masUnit);
		return dataDeleted;
	}

	public boolean editUnitToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String unitName = "";
		String unitAddress = "";
		int unitId = 0;
		String local = "";
		String changedBy = "";
		unitId = (Integer) generalMap.get("id");
		unitAddress = (String) generalMap.get("unitAddress");
		unitName = (String) generalMap.get("name");
		local = (String) generalMap.get("local");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasUnit masUnit = (MasUnit) getHibernateTemplate().load(MasUnit.class,
				unitId);

		masUnit.setId(unitId);
		masUnit.setUnitName(unitName);
		masUnit.setUnitAddress(unitAddress);
		masUnit.setLocalUnit(local);
		masUnit.setLastChgBy(changedBy);
		masUnit.setLastChgDate(currentDate);
		masUnit.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masUnit);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchUnit(String unitName) {
		List<MasUnit> searchUnitList = new ArrayList<MasUnit>();
		Map<String, Object> unitFieldsMap = new HashMap<String, Object>();
		Session session  = (Session)getSession();
		try {
			if ((unitName != null)) {
				searchUnitList = session.createCriteria(MasUnit.class).add(Restrictions.like("UnitName", "%"+unitName+"%").ignoreCase()).addOrder(Order.asc("UnitName")).list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		unitFieldsMap.put("searchUnitList", searchUnitList);
		return unitFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showUnitJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasUnit> searchUnitList = new ArrayList<MasUnit>();
		Session session = (Session)getSession();
		searchUnitList =session.createCriteria(MasUnit.class).list();
		map.put("searchUnitList", searchUnitList);
		return map;
	}


	
	@SuppressWarnings("unchecked")
	public Map checkForExistingMasters(Map<String, Object> generalMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		List duplicateMastersList = new ArrayList();
		List duplicateGeneralNameList = new ArrayList();
		List duplicateGeneralCodeList = new ArrayList();
		List duplicateGeneralAddressList = new ArrayList();
		int id = 0;
		String pojoPropertyCode = "";
		String pojoPropertyAddress = "";
		String pojoPropertyName = "";
		if (generalMap.get("id") != null) {
			id = (Integer) generalMap.get("id");
		}

		String name = (String) generalMap.get("name");
		String pojoName = (String) generalMap.get("pojoName");
		if (generalMap.get("pojoPropertyName") != null)
			pojoPropertyName = (String) generalMap.get("pojoPropertyName");

		if (generalMap.get("pojoPropertyCode") != null) {
			pojoPropertyCode = (String) generalMap.get("pojoPropertyCode");
		}
		if (generalMap.get("pojoPropertyAddress") != null) {
			pojoPropertyAddress = (String) generalMap
					.get("pojoPropertyAddress");
		}

		if (generalMap.get("flag") == null) {
			String code = (String) generalMap.get("code");
			String address = (String) generalMap.get("address");
			if (!pojoPropertyCode.equals("")) {
				duplicateGeneralCodeList = getHibernateTemplate().find(
						"from " + pojoName
								+ " as g where g." + pojoPropertyCode + " = '"
								+ code + "'");
			}
			if (!pojoPropertyName.equals("")) {
				duplicateGeneralNameList = getHibernateTemplate().find(
						"from " + pojoName
								+ " as g where g." + pojoPropertyName + " = '"
								+ name + "'");
			}
			if (!pojoPropertyAddress.equals("")) {
				duplicateGeneralAddressList = getHibernateTemplate().find(
						"from " + pojoName
								+ " as g where g." + pojoPropertyAddress
								+ " ='" + address + "'");
			}

		}else if (generalMap.get("flag") != null){
			boolean flag = (Boolean) generalMap.get("flag");
			duplicateMastersList = getHibernateTemplate().find(
					"from " + pojoName
							+ " as g where g." + pojoPropertyName + " = '"
							+ name + "' and g.Id != " + id);
			
		}
		map.put("duplicateGeneralNameList", duplicateGeneralNameList);
		map.put("duplicateGeneralCodeList", duplicateGeneralCodeList);
		map.put("duplicateGeneralAddressList", duplicateGeneralAddressList);
		map.put("duplicateMastersList", duplicateMastersList);

		return map;
	}
	
	// ------------------------------------------ Service Type
	// ---------------------------

	public boolean addServiceType(MasServiceType masServiceType) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masServiceType);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteServiceType(int serviceTypeId,Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasServiceType masServiceType = new MasServiceType();
		masServiceType = (MasServiceType) getHibernateTemplate().get(
				MasServiceType.class, serviceTypeId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masServiceType.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masServiceType.setStatus("y");
				dataDeleted = false;
			}
		}
		masServiceType.setLastChgBy(changedBy);
		masServiceType.setLastChgDate(currentDate);
		masServiceType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masServiceType);
		return dataDeleted;
	}

	public boolean editServiceTypeToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String serviceTypeName = "";
		@SuppressWarnings("unused")
		String serviceTypeCode = "";
		String shortDescription = "";
		int serviceTypeId = 0;
		String changedBy = "";
		serviceTypeId = (Integer) generalMap.get("id");
		serviceTypeCode = (String) generalMap.get("serviceTypeCode");
		serviceTypeName = (String) generalMap.get("name");
		shortDescription = (String) generalMap.get("shortDescription");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasServiceType masServiceType = (MasServiceType) getHibernateTemplate()
				.get(MasServiceType.class, serviceTypeId);

		masServiceType.setId(serviceTypeId);
		masServiceType.setServiceTypeName(serviceTypeName);
		masServiceType.setServiceNameShortDesc(shortDescription);
		masServiceType.setLastChgBy(changedBy);
		masServiceType.setLastChgDate(currentDate);
		masServiceType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masServiceType);
		dataUpdated = true;
		return dataUpdated;
	}

	public Map<String, Object> showServiceTypeJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasServiceType> searchServiceTypeList = new ArrayList<MasServiceType>();
		Session session = (Session)getSession();
		searchServiceTypeList = session.createCriteria(MasServiceType.class).list();
		map.put("searchServiceTypeList", searchServiceTypeList);
		return map;
	}

	public Map<String, Object> searchServiceType(String serviceTypeCode,
			String serviceTypeName) {
		List<MasServiceType> searchServiceTypeList = new ArrayList<MasServiceType>();
		Map<String, Object> serviceTypeFieldsMap = new HashMap<String, Object>();
		Session session = (Session)getSession();
		try {
			if ((serviceTypeName != null) || (serviceTypeCode == null)) {
				searchServiceTypeList = session.createCriteria(MasServiceType.class).add(Restrictions.like("ServiceTypeName", "%"+serviceTypeName+"%").ignoreCase()).addOrder(Order.asc("ServiceTypeName")).list();
			} else {
				searchServiceTypeList = session.createCriteria(MasServiceType.class).add(Restrictions.like("ServiceTypeCode", "%"+serviceTypeCode+"%").ignoreCase()).addOrder(Order.asc("ServiceTypeCode")).list();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		serviceTypeFieldsMap
				.put("searchServiceTypeList", searchServiceTypeList);
		return serviceTypeFieldsMap;
	}
	// --------------------------------------- Service Status-------
	// ---------------------------

	public boolean addServiceStatus(MasServiceStatus masServiceStatus) {

		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masServiceStatus);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteServiceStatus(int serviceStatusId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasServiceStatus masServiceStatus = new MasServiceStatus();
		masServiceStatus = (MasServiceStatus) getHibernateTemplate().get(
				MasServiceStatus.class, serviceStatusId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masServiceStatus.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masServiceStatus.setStatus("y");
				dataDeleted = false;
			}
		}
		masServiceStatus.setLastChgBy(changedBy);
		masServiceStatus.setLastChgDate(currentDate);
		masServiceStatus.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masServiceStatus);
		return dataDeleted;
	}

	public boolean editServiceStatusToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String serviceStatusName = "";
		@SuppressWarnings("unused")
		String serviceStatusCode = "";
		int serviceStatusId = 0;
		String changedBy = "";
		serviceStatusId = (Integer) generalMap.get("id");
		serviceStatusCode = (String) generalMap.get("serviceStatusCode");
		serviceStatusName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasServiceStatus masServiceStatus = (MasServiceStatus) getHibernateTemplate()
				.get(MasServiceStatus.class, serviceStatusId);

		masServiceStatus.setId(serviceStatusId);
		masServiceStatus.setServiceStatusName(serviceStatusName);
		masServiceStatus.setLastChgBy(changedBy);
		masServiceStatus.setLastChgDate(currentDate);
		masServiceStatus.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masServiceStatus);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchServiceStatus(String serviceStatusCode,
			String serviceStatusName) {
		List<MasServiceStatus> searchServiceStatusList = new ArrayList<MasServiceStatus>();
		Map<String, Object> serviceStatusFieldsMap = new HashMap<String, Object>();
		Session session = (Session)getSession();
		try {
			if ((serviceStatusName != null) || (serviceStatusCode == null)) {
				
				searchServiceStatusList = session.createCriteria(MasServiceStatus.class).add(Restrictions.like("ServiceStatusName", "%"+serviceStatusName+"%").ignoreCase()).addOrder(Order.asc("ServiceStatusName")).list();
			} else {
				searchServiceStatusList = session.createCriteria(MasServiceStatus.class).add(Restrictions.like("ServiceStatusCode", "%"+serviceStatusCode+"%").ignoreCase()).addOrder(Order.asc("ServiceStatusCode")).list();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		serviceStatusFieldsMap.put("searchServiceStatusList",
				searchServiceStatusList);
		return serviceStatusFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showServiceStatusJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasServiceStatus> searchServiceStatusList = new ArrayList<MasServiceStatus>();
		Session session = (Session)getSession();
		searchServiceStatusList = session.createCriteria(MasServiceStatus.class).list();
		map.put("searchServiceStatusList", searchServiceStatusList);
		return map;

	}
	// -------------------------------------- Emp Category ---------------------------------------------//
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> searchEmpCategory(String empCategoryCode,
			String empCategoryName) {
		List<MasEmpCategory> searchEmpCategoryList = new ArrayList<MasEmpCategory>();
		Map<String, Object> empCategoryFieldsMap = new HashMap<String, Object>();
		Session session = (Session)getSession();
		try {
			if ((empCategoryName != null) || (empCategoryCode == null)) {
				searchEmpCategoryList = session.createCriteria(MasEmpCategory.class).add(Restrictions.like("EmpCategoryName", "%"+empCategoryName+"%").ignoreCase()).addOrder(Order.asc("EmpCategoryName")).list();				
			} else {
				searchEmpCategoryList = session.createCriteria(MasEmpCategory.class).add(Restrictions.like("EmpCategoryCode", "%"+empCategoryCode+"%").ignoreCase()).addOrder(Order.asc("EmpCategoryCode")).list();				

			}
		} catch (Exception e) {
		}
		empCategoryFieldsMap.put("searchEmpCategoryList", searchEmpCategoryList);
		return empCategoryFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showEmpCategoryJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmpCategory> searchEmpCategoryList = new ArrayList<MasEmpCategory>();
		Session session = (Session)getSession();
		searchEmpCategoryList = session.createCriteria(MasEmpCategory.class).list();
		map.put("searchEmpCategoryList", searchEmpCategoryList);
		return map;
	}

	public boolean addEmpCategory(MasEmpCategory masEmpCategory) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masEmpCategory);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editEmpCategoryToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String empcategoryCode="";
		String empCategoryName="";
		int empCategoryId=0;
		String changedBy = "";
		empCategoryId = (Integer) generalMap.get("id");
		empcategoryCode = (String) generalMap.get("empcategoryCode");
		empCategoryName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		int userId=0;
		userId = (Integer) generalMap.get("userId");
		MasEmpCategory masEmpCategory = (MasEmpCategory) getHibernateTemplate().load(
				MasEmpCategory.class, empCategoryId);
		masEmpCategory.setId(empCategoryId);
		masEmpCategory.setEmpCategoryName(empCategoryName);
		if(userId !=0){
			Users users=new Users();
			users.setId(userId);
			masEmpCategory.setLastChgBy(users);
			}
		masEmpCategory.setLastChgDate(currentDate);
		masEmpCategory.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masEmpCategory);
		dataUpdated = true;
		return dataUpdated;

	}

	public boolean deleteEmpCategory(int empcategoryId,Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasEmpCategory masEmpCategory= new MasEmpCategory();
		masEmpCategory = (MasEmpCategory) getHibernateTemplate().load(
				MasEmpCategory.class, empcategoryId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		int userId=0;
		userId = (Integer) generalMap.get("userId");
		if (masEmpCategory.getStatus().equals("y")) {
			masEmpCategory.setStatus("n");
			dataDeleted = true;
		} else {
			masEmpCategory.setStatus("y");
			dataDeleted = false;
		}
		
		if(userId !=0){
			Users users=new Users();
			users.setId(userId);
			masEmpCategory.setLastChgBy(users);
			}
		masEmpCategory.setLastChgDate(currentDate);
		masEmpCategory.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masEmpCategory);
		return dataDeleted;
	}
	
	//---------------------------------Depot Master----------------------------------------//
/*	@Override
	public boolean addDepot(MasDepot masDepot) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masDepot);
		successfullyAdded = true;
		return successfullyAdded;
	}*/
	@Override
	public Map showDepotJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepot> searchDepotList = new ArrayList<MasDepot>();
		Session session = (Session)getSession();
		searchDepotList = session.createCriteria(MasDepot.class).list();
		map.put("searchDepotList", searchDepotList);
		return map;
	}
	@Override
	public boolean editDepotToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String depotCode="";
		String depotName="";
		int depotId=0;
		String changedBy = "";
		depotId = (Integer) generalMap.get("id");
		depotCode = (String) generalMap.get("depotCode");
		depotName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasDepot masDepot = (MasDepot) getHibernateTemplate().load(
				MasDepot.class, depotId);
		masDepot.setId(depotId);
		masDepot.setDepotName(depotName);
		masDepot.setLastChgBy(changedBy);
		masDepot.setLastChgDate(currentDate);
		masDepot.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDepot);
		dataUpdated = true;
		return dataUpdated;
	}
	@Override
	public boolean deleteDepot(int depotId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasDepot masDepot = new MasDepot();
		masDepot = (MasDepot) getHibernateTemplate().load(
				MasDepot.class, depotId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (masDepot.getStatus().equals("y")) {
			masDepot.setStatus("n");
			dataDeleted = true;
		} else {
			masDepot.setStatus("y");
			dataDeleted = false;
		}
		masDepot.setLastChgBy(changedBy);
		masDepot.setLastChgDate(currentDate);
		masDepot.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDepot);
		return dataDeleted;
	}
	@Override
	public Map<String, Object> searchDepot(String depotCode, String depotName) {
		List<MasDepot> searchDepotList = new ArrayList<MasDepot>();
		Map<String, Object> depotFieldsMap = new HashMap<String, Object>();
		Session session = (Session)getSession();
		try {
			if ((depotName != null) || (depotCode == null)) {
				searchDepotList = session.createCriteria(MasDepot.class).add(Restrictions.like("DepotName", "%"+depotName+"%").ignoreCase()).addOrder(Order.asc("DepotName")).list();				
			} else {
				searchDepotList = session.createCriteria(MasDepot.class).add(Restrictions.like("DepotCode", "%"+depotCode+"%").ignoreCase()).addOrder(Order.asc("DepotCode")).list();				

			}
		} catch (Exception e) {
		}
		depotFieldsMap.put("searchDepotList", searchDepotList);
		return depotFieldsMap;
		
	}
	
	// -----------------------------State ------------------------------------

	public boolean addState(MasState masState) {
		boolean saveFlag = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(masState);
			saveFlag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saveFlag;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteState(int stateId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int userId = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasState masState = new MasState();
		masState = (MasState) getHibernateTemplate().get(MasState.class,
				stateId);
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			
			if (flag.equals("InActivate")) {
				masState.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masState.setStatus("y");
				dataDeleted = false;
			}
		}
		Users user = new Users();
		user.setId(userId);
		masState.setLastChgBy(user);
		masState.setLastChgDate(currentDate);
		masState.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masState);
		return dataDeleted;
	}

	public boolean editState(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int countryId = 0;
		String stateName = "";
		String stateNameKann ="";
		@SuppressWarnings("unused")
		String stateCode = "";
		int stateId = 0;
		int userId=0;
		try {
			stateId = (Integer) generalMap.get("id");
			stateCode = (String) generalMap.get("stateCode");
			stateName = (String) generalMap.get("name");
			stateNameKann = (String) generalMap.get("stateNameKann");
			countryId = (Integer) generalMap.get("countryId");
			userId = (Integer) generalMap.get("userId");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			MasState masState = (MasState) getHibernateTemplate().get(
					MasState.class, stateId);
			masState.setId(stateId);
			masState.setStateName(stateName);
			masState.setStateNameKann(stateNameKann);
			Users user = new Users();
			user.setId(userId);
			MasCountry mCountry = new MasCountry();
			mCountry.setId(countryId);
			masState.setCountry(mCountry);
			masState.setLastChgBy(user);
			masState.setLastChgDate(currentDate);
			masState.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masState);
			dataUpdated = true;
		} catch (Exception e) {
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchState(String stateCode, String stateName) {

		List masStateList = new ArrayList();
		Map<String, Object> stateFieldMap = new HashMap<String, Object>();
		Session session = (Session)getSession();
		try {
			if ((stateName != null) || (stateCode == null)) {
				masStateList = session.createCriteria(MasState.class).add(Restrictions.like("StateName", "%"+stateName+"%").ignoreCase()).addOrder(Order.asc("StateName")).list();
			} else {
				masStateList = session.createCriteria(MasState.class).add(Restrictions.like("StateCode", "%"+stateCode+"%").ignoreCase()).addOrder(Order.asc("StateCode")).list();

			}
		} catch (Exception e) {
		}
		stateFieldMap.put("masStateList", masStateList);
		return stateFieldMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showStateJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasState> masStateList = new ArrayList<MasState>();
		Session session = (Session)getSession();
		masStateList = session.createCriteria(MasState.class).list();
		map.put("masStateList", masStateList);
		return map;
	}
	
	// -----------------------District-------------------------------------------
	public boolean addDistrict(MasDistrict masDistrict) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masDistrict);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editDistrict(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int stateId = 0;
		String districtName = "";
		@SuppressWarnings("unused")
		String districtCode = "";
		String districtNameKann="";
		int districtId = 0;
		Integer userId= 0;
		districtId = (Integer) generalMap.get("id");
		districtCode = (String) generalMap.get("districtCode");
		districtName = (String) generalMap.get("name");
		districtNameKann = (String) generalMap.get("districtNameKann");
		stateId = (Integer) generalMap.get("stateId");
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasDistrict masDistrict = (MasDistrict) getHibernateTemplate().get(
				MasDistrict.class, districtId);

		masDistrict.setId(districtId);
		masDistrict.setDistrictCode(districtCode);
		masDistrict.setDistrictName(districtName);
		masDistrict.setDistrictNameKann(districtNameKann);

		MasState masState = new MasState();
		masState.setId(stateId);
		masDistrict.setState(masState);

		Users user = new Users();
		user.setId(userId);
		masDistrict.setLastChgBy(user);
		
		masDistrict.setLastChgDate(currentDate);
		masDistrict.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDistrict);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchDistrict(String districtCode,
			String districtName) {
		List<MasDistrict> searchDistrictList = new ArrayList<MasDistrict>();
		List stateList = null;
		Map<String, Object> districtFieldsMap = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List gridStateList = null;
		try {
			if ((districtName != null) || (districtCode == null)) {
				searchDistrictList = session.createCriteria(MasDistrict.class).add(Restrictions.like("DistrictName", "%"+districtName+"%").ignoreCase()).addOrder(Order.asc("DistrictName")).list();
			} else {
				searchDistrictList = session.createCriteria(MasDistrict.class).add(Restrictions.like("DistrictCode", "%"+districtCode+"%").ignoreCase()).addOrder(Order.asc("DistrictCode")).list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		stateList = session.createCriteria(MasState.class).add(Restrictions.eq("Status", "y")).list();
		gridStateList = session.createCriteria(MasState.class).list();
		districtFieldsMap.put("gridStateList", gridStateList);
		districtFieldsMap.put("searchDistrictList", searchDistrictList);
		districtFieldsMap.put("stateList", stateList);
		return districtFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showDistrict() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDistrict> searchDistrictList = new ArrayList<MasDistrict>();
		List<MasState> stateList = new ArrayList<MasState>();
		List<MasState> gridStateList = new ArrayList<MasState>();
		Session session = (Session)getSession();
		
		searchDistrictList = session.createCriteria(MasDistrict.class).list();
		gridStateList = session.createCriteria(MasState.class).list();
		stateList = session.createCriteria(MasState.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("StateName")).list();
		map.put("searchDistrictList", searchDistrictList);
		map.put("stateList", stateList);
		map.put("gridStateList", gridStateList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteDistrict(int districtId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		Session session = (Session)getSession();
		int userId = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasDistrict masDistrict = new MasDistrict();
		masDistrict = (MasDistrict) getHibernateTemplate().get(
				MasDistrict.class, districtId);
		@SuppressWarnings("unused")
		Integer stateId = masDistrict.getState().getId();
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			
			List stateList = session.createCriteria(MasState.class).add(Restrictions.eq("Id", districtId)).add(Restrictions.eq("Status", "y")).list();
			
			if (flag.equals("InActivate")) {
				masDistrict.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masDistrict.setStatus("y");
				dataDeleted = false;
			}
		}
		Users user = new Users();
		user.setId(userId);
		masDistrict.setLastChgBy(user);
		
		masDistrict.setLastChgDate(currentDate);
		masDistrict.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDistrict);
		return dataDeleted;
	}
		
	
	//-------------------------- Report Method By Mansi on 31 July 2013
	
	@Override
	public Map<String, Object> getConnection() {
		Session session = (Session) getSession();
		Connection con = (Connection) session.connection();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("conn", con);
		return map;
	}
	@Override
	public Map<String, Object> getHospitalName(Map<String, Object> mapForDs) {
		Map<String, Object> mapResponse = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Integer storeId = 0;
		if (mapForDs.get("storeId") != null) {
			storeId = (Integer) mapForDs.get("storeId");
		}
		try {
			List<MasHospital> masHospitaList = new ArrayList<MasHospital>();
			masHospitaList = session.createCriteria(MasHospital.class)
					.add(Restrictions.eq("Id", storeId)).list();
			mapResponse.put("masHospitaList", masHospitaList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapResponse;
	}
	
	
	
	//--------------------- ** Employee Master **----------------------------
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> showEmployeeJsp(int storeId) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasTitle> titleList = new ArrayList<MasTitle>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasEmpStatus> empStatusList = new ArrayList<MasEmpStatus>();
		List<MasEmployee> searchEmployeeList = new ArrayList<MasEmployee>();
		List<MasEmpCategory> empCategoryList = new ArrayList<MasEmpCategory>();
		List<MasRank> rankList = new ArrayList<MasRank>();
	//	List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasTrade> tradeList = new ArrayList<MasTrade>();
	//	List<MasUnit> gridUnitList = new ArrayList<MasUnit>();
		List<MasHospital> unitList = new ArrayList<MasHospital>();

		//gridUnitList = session.createCriteria(MasUnit.class).list();
			
		titleList = session.createCriteria(MasTitle.class).add(Restrictions.eq("Status", "y")).list();
		
		departmentList = session.createCriteria(MasDepartment.class).list();
		empCategoryList = session.createCriteria(MasEmpCategory.class).add(Restrictions.eq("Status", "y")).list();
		empStatusList = session.createCriteria(MasEmpStatus.class).add(Restrictions.eq("Status", "y")).list();
		searchEmployeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Hospital.Id", storeId)).list();
			
			
		rankList 
			= session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).list();
			
//		unitList =  session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y")).list();
		unitList =  session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).list();
		tradeList = session.createCriteria(MasTrade.class).add(Restrictions.eq("Status", "y")).list();
		List<MasTemplate> masTemplateList = new ArrayList<MasTemplate>();
		masTemplateList=session.createCriteria(MasTemplate.class).add(Restrictions.isNull("TemplateParent.Id")).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("TemplateName")).list();
		map.put("masTemplateList",masTemplateList);
	//	map.put("gridUnitList", gridUnitList);
		map.put("titleList", titleList);
		map.put("departmentList", departmentList);
		map.put("empStatusList", empStatusList);
		map.put("empCategoryList", empCategoryList);
		map.put("searchEmployeeList", searchEmployeeList);
		map.put("rankList", rankList);
		map.put("unitList", unitList);
		map.put("tradeList", tradeList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean addEmployee(Map<String, Object> userMap) {

		MasRank masRank = null;
		Session session = (Session) getSession();

		MasEmployee masEmployee = new MasEmployee();
		masEmployee = (MasEmployee)userMap.get("masEmployee");
		
		Users users = new Users();
		if(userMap.get("users")!=null){
			users=(Users)userMap.get("users");
		}
		int hospitalId=0;
		if(userMap.get("hospitalId")!=null){
			hospitalId=(Integer)userMap.get("hospitalId");
		}
		List<Integer> templetIdList=new ArrayList<Integer>();
		if(userMap.get("templetIdList")!=null){
			templetIdList=(List<Integer>)userMap.get("templetIdList");
		}		
		boolean successfullyAdded = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			List<MasEmployee> masEmployeeList=new ArrayList<MasEmployee>();
			masEmployeeList= session.createCriteria(MasEmployee.class).add(Restrictions.eq("ServiceNo", masEmployee.getServiceNo())).list();
			
			if(masEmployeeList.size()==0){
			/*	if(masEmployee.getRank()!=null){
					masRank = (MasRank)hbt.load(MasRank.class, masEmployee.getRank().getId());
					masEmployee.setServiceType(masRank.getServiceType());
				}*/
				hbt.save(masEmployee);
								
				users.setEmployee(masEmployee);
				hbt.save(users);
				
				String changedBy = "";
				Date currentDate = new Date();
				String currentTime = "";
				currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
				
				changedBy = (String) userMap.get("changedBy");
				currentDate = (Date) userMap.get("currentDate");
			
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

			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return successfullyAdded;
	}

	public boolean editEmployeeToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;

		String firstName = "";
		String lastName = "";
		String middleName = "";
		@SuppressWarnings("unused")
		String employeeCode = "";
		String serviceNo = "";
		int employeeId = 0;
		int titleId = 0;
		int departmentId = 0;
		int empStatusId = 0;
		int empCategoryId = 0;
		int tradeId = 0;
		//int unitId = 0;
		int rankId = 0;
		String emergencyCellNumber = "";
		String residenceTellNumber = "";
		String officeTellNumber = "";
		Date appointmentDate = new Date();
		Date joinDate = new Date();
		String email = "";
		Date changedDate = new Date();
		String changedBy = "";
		String currentTime = "";
		Date currentDate = new Date();
		int storeId = 0;
		employeeId = (Integer) generalMap.get("id");
		storeId = (Integer) generalMap.get("storeId");
		employeeCode = (String) generalMap.get("employeeCode");
		serviceNo = (String) generalMap.get("serviceNo");
		firstName = (String) generalMap.get("firstName");
		lastName = (String) generalMap.get("lastName");
		middleName = (String) generalMap.get("middleName");
		
		appointmentDate = (Date) generalMap.get("appointmentDate");
		joinDate = (Date) generalMap.get("joinDate");
		titleId = (Integer) generalMap.get("titleId");
		departmentId = (Integer) generalMap.get("departmentId");
		
		empStatusId = (Integer) generalMap.get("empStatusId");
		empCategoryId = (Integer) generalMap.get("empCategoryId");
		rankId = (Integer) generalMap.get("rankId");
		tradeId = (Integer) generalMap.get("tradeId");
		//unitId = (Integer) generalMap.get("unitId");
		
		emergencyCellNumber = (String) generalMap.get("emergencyCellNumber");
		residenceTellNumber = (String) generalMap.get("residenceTellNumber");
		officeTellNumber = (String) generalMap.get("officeTellNumber");
		email = (String) generalMap.get("email");
		
		
		changedBy = (String) generalMap.get("changedBy");
		currentTime = (String) generalMap.get("currentTime");
		MasEmployee masEmployee = (MasEmployee) getHibernateTemplate().load(
				MasEmployee.class, employeeId);

		masEmployee.setId(employeeId);
		masEmployee.setEmployeeCode(employeeCode);
		masEmployee.setServiceNo(serviceNo);
		masEmployee.setFirstName(firstName);
		masEmployee.setLastName(lastName);
		masEmployee.setMiddleName(middleName);


		MasHospital hospital = new MasHospital();
		hospital.setId(storeId);
		masEmployee.setHospital(hospital);

		if (titleId != 0) {
			MasTitle masTitle = new MasTitle();
			masTitle.setId(titleId);
			masEmployee.setTitle(masTitle);
		}
		if (departmentId != 0) {
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			masEmployee.setDepartment(masDepartment);
		}
		/*if (empStatusId != 0) {
			MasEmpStatus masEmpStatus = new MasEmpStatus();
			masEmpStatus.setId(empStatusId);
			masEmployee.setEmpStatus(masEmpStatus);
		}*/
		if (departmentId != 0) {
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			masEmployee.setDepartment(masDepartment);
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
		/*if (unitId != 0) {
			MasUnit masUnit = new MasUnit();
			masUnit.setId(unitId);
			masEmployee.setUnit(masUnit);
		}*/
		
		masEmployee.setAppointmentDate(appointmentDate);
		masEmployee.setEmail(email);
		masEmployee.setCellNoEmergency(emergencyCellNumber);
		masEmployee.setTelNoResidence(residenceTellNumber);
		masEmployee.setTelNoOffice(officeTellNumber);
		masEmployee.setJoinDate(joinDate);
		masEmployee.setStatus("y");
		masEmployee.setLastChgBy(changedBy);
		masEmployee.setLastChgDate(currentDate);
		masEmployee.setLastChgTime(currentTime);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			MasRank masRank = null;
		/*	if(masEmployee.getRank()!=null){
				masRank = (MasRank)hbt.load(MasRank.class, masEmployee.getRank().getId());
				masEmployee.setServiceType(masRank.getServiceType());
				
			}*/
			hbt.update(masEmployee);
			hbt.refresh(masEmployee);
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	public boolean deleteEmployee(int employeeId, Map<String, Object> generalMap) {

		Session session = (Session) getSession();
		boolean dataUpdated = false;

		String firstName = "";
		String lastName = "";
		String middleName = "";
		@SuppressWarnings("unused")
		String employeeCode = "";
		String serviceNo = "";
		int titleId = 0;
		int departmentId = 0;
		
		int empStatusId = 0;
		int empCategoryId = 0;
		
		int tradeId = 0;
		//int unitId = 0;
		int rankId = 0;
		String emergencyCellNumber = "";
		String residenceTellNumber = "";
		String officeTellNumber = "";
		Date appointmentDate = new Date();
		Date joinDate = new Date();
		Date changedDate = new Date();
		String changedBy = "";
		String currentTime = "";
		Date currentDate = new Date();
		int storeId = 0;
		String email="";
		boolean dataDeleted = false;
		employeeId = (Integer) generalMap.get("id");
		storeId = (Integer) generalMap.get("storeId");
		employeeCode = (String) generalMap.get("employeeCode");
		serviceNo = (String) generalMap.get("serviceNo");
		firstName = (String) generalMap.get("firstName");
		lastName = (String) generalMap.get("lastName");
		middleName = (String) generalMap.get("middleName");
		
		appointmentDate = (Date) generalMap.get("appointmentDate");
		joinDate = (Date) generalMap.get("joinDate");
		titleId = (Integer) generalMap.get("titleId");
		
		departmentId = (Integer) generalMap.get("departmentId");
		empStatusId = (Integer) generalMap.get("empStatusId");
		empCategoryId = (Integer) generalMap.get("empCategoryId");
		rankId = (Integer) generalMap.get("rankId");
		tradeId = (Integer) generalMap.get("tradeId");
		//unitId = (Integer) generalMap.get("unitId");
		
		emergencyCellNumber = (String) generalMap.get("emergencyCellNumber");
		residenceTellNumber = (String) generalMap.get("residenceTellNumber");
		officeTellNumber = (String) generalMap.get("officeTellNumber");
		email = (String) generalMap.get("email");
		
		changedBy = (String) generalMap.get("changedBy");
		currentTime = (String) generalMap.get("currentTime");
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			MasEmployee masEmployee = (MasEmployee) hbt.load(MasEmployee.class,
					employeeId);
			if (masEmployee.getStatus().equals("y")) {
				masEmployee.setStatus("n");
				dataDeleted = true;
				List<Users> userList = new ArrayList<Users>();
				userList = session.createCriteria(Users.class).createAlias(
						"Employee", "employee").add(
						Restrictions.eq("employee.Id", employeeId)).list();
				for (Users user : userList) {
					int userId = user.getId();
					Users userObj = (Users) hbt.load(Users.class, userId);
					userObj.setStatus("n");
					getHibernateTemplate().update(userObj);
				}
			} else {
				masEmployee.setStatus("y");
				dataDeleted = false;
			}
			masEmployee.setId(employeeId);
			masEmployee.setEmployeeCode(employeeCode);
			masEmployee.setServiceNo(serviceNo);
			masEmployee.setFirstName(firstName);
			masEmployee.setLastName(lastName);
			masEmployee.setMiddleName(middleName);
		
			MasHospital hospital = new MasHospital();
			hospital.setId(storeId);
			masEmployee.setHospital(hospital);

			if (titleId != 0) {
				MasTitle masTitle = new MasTitle();
				masTitle.setId(titleId);
				masEmployee.setTitle(masTitle);
			}
			if (departmentId != 0) {
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(departmentId);
				masEmployee.setDepartment(masDepartment);
			}
			/*if (empStatusId != 0) {
				MasEmpStatus masEmpStatus = new MasEmpStatus();
				masEmpStatus.setId(empStatusId);
				masEmployee.setEmpStatus(masEmpStatus);
			}*/
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
		/*	if (unitId != 0) {
				MasUnit masUnit = new MasUnit();
				masUnit.setId(unitId);
				masEmployee.setUnit(masUnit);
			}*/
		
			masEmployee.setAppointmentDate(appointmentDate);
			masEmployee.setEmail(email);
			masEmployee.setCellNoEmergency(emergencyCellNumber);
			masEmployee.setTelNoResidence(residenceTellNumber);
			masEmployee.setTelNoOffice(officeTellNumber);
			masEmployee.setJoinDate(joinDate);
			masEmployee.setLastChgBy(changedBy);
			masEmployee.setLastChgDate(currentDate);
			masEmployee.setLastChgTime(currentTime);

			hbt.update(masEmployee);
			hbt.refresh(masEmployee);
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchEmployee(String serviceNo,
			String firstName, String lastName,int storeId) {

		List<MasEmployee> searchEmployeeList = new ArrayList<MasEmployee>();
		Map<String, Object> employeeFieldsMap = new HashMap<String, Object>();
		List titleList = new ArrayList();
		List departmentList = new ArrayList();
		List empStatusList = new ArrayList();
		List empCategoryList = new ArrayList();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasTrade> tradeList = new ArrayList<MasTrade>();
		List gridUnitList = null;
		
		Session session= getSession();
		try {
			if ((serviceNo != null) && (firstName == null)
					&& (lastName == null)) {
		
				searchEmployeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Hospital.Id", storeId)).add(Restrictions.like("ServiceNo", "%"+serviceNo+"%").ignoreCase()).addOrder(Order.asc("ServiceNo")).list();

			} else if ((serviceNo == null) && (firstName != null)
					&& (lastName == null)) {
				
					searchEmployeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Hospital.Id", storeId)).add(Restrictions.like("FirstName", "%"+firstName+"%").ignoreCase()).addOrder(Order.asc("LastName")).list();

				
			} else if ((serviceNo == null) && (firstName == null)
					&& (lastName != null)) {
		
				searchEmployeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Hospital.Id", storeId)).add(Restrictions.like("LastName", "%"+lastName+"%").ignoreCase()).addOrder(Order.asc("LastName")).list();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		gridUnitList = session.createCriteria(MasUnit.class).list();
		
		titleList = session.createCriteria(MasTitle.class).add(Restrictions.eq("Status", "y")).list();
		
		departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
		empCategoryList = session.createCriteria(MasEmpCategory.class).add(Restrictions.eq("Status", "y")).list();
		empStatusList = session.createCriteria(MasEmpStatus.class).add(Restrictions.eq("Status", "y")).list();
		rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).list();
		unitList =  session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y")).list();
		tradeList = session.createCriteria(MasTrade.class).add(Restrictions.eq("Status", "y")).list();
		
		employeeFieldsMap.put("gridUnitList", gridUnitList);
		employeeFieldsMap.put("searchEmployeeList", searchEmployeeList);
		employeeFieldsMap.put("titleList", titleList);
		employeeFieldsMap.put("departmentList", departmentList);
		employeeFieldsMap.put("empStatusList", empStatusList);
		employeeFieldsMap.put("empCategoryList", empCategoryList);
		employeeFieldsMap.put("rankList", rankList);
		employeeFieldsMap.put("unitList", unitList);
		employeeFieldsMap.put("tradeList", tradeList);
		return employeeFieldsMap;
	}
	
	//-------------------- ** Title Master ** -------------------------------
	
	@Override
	public boolean addTitle(MasTitle masTitle) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masTitle);
		successfullyAdded = true;
		return successfullyAdded;
	}
	@Override
	public boolean deleteTitle(int titleId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int userId = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasTitle masTitle = new MasTitle();
		masTitle = (MasTitle) getHibernateTemplate().load(MasTitle.class, titleId);
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masTitle.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masTitle.setStatus("y");
				dataDeleted = false;
			}
		}
		Users user = new Users();
		user.setId(userId);
		masTitle.setLastChgBy(user);
		
		masTitle.setLastChgDate(currentDate);
		masTitle.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masTitle);
		return dataDeleted;
	}
	@Override
	public Map<String, Object> searchTitle(String titleCode, String titleName) {
		List<MasTitle> searchTitleList = new ArrayList<MasTitle>();
		Map<String, Object> titleFieldsMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {
			if ((titleName != null) || (titleCode == null)) {
				searchTitleList = session.createCriteria(MasTitle.class).add(Restrictions.like("TitleName","%"+titleName+"%").ignoreCase()).addOrder(Order.asc("TitleName")).list();
			} else {
				searchTitleList = session.createCriteria(MasTitle.class).add(Restrictions.like("TitleCode","%"+titleCode+"%").ignoreCase()).addOrder(Order.asc("TitleCode")).list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		titleFieldsMap.put("searchTitleList", searchTitleList);
		return titleFieldsMap;
	}
	@Override
	public Map<String, Object> showTitleJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasTitle> searchTitleList = new ArrayList<MasTitle>();
		Session session = (Session) getSession();
		
		searchTitleList =session.createCriteria(MasTitle.class).list(); 
			
		map.put("searchTitleList", searchTitleList);
		return map;
	}
	@Override
	public boolean editTitleToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
		String titleName = "";
		@SuppressWarnings("unused")
		String titleCode = "";
		int titleId = 0;
		int userId = 0;
		titleId = (Integer) generalMap.get("id");
		titleCode = (String) generalMap.get("titleCode");
		titleName = (String) generalMap.get("name");
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		
		MasTitle masTitle = (MasTitle) getHibernateTemplate().get(MasTitle.class, titleId);

		masTitle.setId(titleId);
		masTitle.setTitleName(titleName);
		Users user = new Users();
		user.setId(userId);
		masTitle.setLastChgBy(user);
		masTitle.setLastChgDate(currentDate);
		masTitle.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masTitle);
		dataUpdated = true;
		return dataUpdated;
	}
		
	//-------------------- ** Employee Status Master ** -------------------------------
		
	@Override
	public boolean addEmpStatus(MasEmpStatus masEmpStatus) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masEmpStatus);
		successfullyAdded = true;
		return successfullyAdded;
	}
	@Override
	public boolean deleteEmpStatus(int empStatusId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int userId = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasEmpStatus masEmpStatus = new MasEmpStatus();
		masEmpStatus = (MasEmpStatus) getHibernateTemplate().load(MasEmpStatus.class, empStatusId);
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masEmpStatus.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masEmpStatus.setStatus("y");
				dataDeleted = false;
			}
		}
		Users user = new Users();
		user.setId(userId);
		masEmpStatus.setLastChgBy(user);
		
		masEmpStatus.setLastChgDate(currentDate);
		masEmpStatus.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masEmpStatus);
		return dataDeleted;
	}
	@Override
	public Map<String, Object> searchEmpStatus(String empStatusCode,
			String empStatusName) {
		List<MasEmpStatus> searchEmpStatusList = new ArrayList<MasEmpStatus>();
		Map<String, Object> empStatusFieldsMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {
			if ((empStatusName != null) || (empStatusCode == null)) {
				searchEmpStatusList = session.createCriteria(MasEmpStatus.class).add(Restrictions.like("EmpStatusName","%"+empStatusName+"%").ignoreCase()).addOrder(Order.asc("EmpStatusName")).list();
			} else {
				searchEmpStatusList = session.createCriteria(MasEmpStatus.class).add(Restrictions.like("EmpStatusCode","%"+empStatusCode+"%").ignoreCase()).addOrder(Order.asc("EmpStatusCode")).list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		empStatusFieldsMap.put("searchEmpStatusList", searchEmpStatusList);
		return empStatusFieldsMap;
	}
	@Override
	public Map<String, Object> showEmpStatusJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmpStatus> searchEmpStatusList = new ArrayList<MasEmpStatus>();
		Session session = (Session) getSession();
		
		searchEmpStatusList =session.createCriteria(MasEmpStatus.class).list(); 
			
		map.put("searchEmpStatusList", searchEmpStatusList);
		return map;
	}

	@Override
	public boolean editEmpStatusToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
		String empStatusName = "";
		@SuppressWarnings("unused")
		String empStatusCode = "";
		int empStatusId = 0;
		int userId = 0;
		empStatusId = (Integer) generalMap.get("id");
		empStatusCode = (String) generalMap.get("empStatusCode");
		empStatusName = (String) generalMap.get("name");
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		
		MasEmpStatus masEmpStatus = (MasEmpStatus) getHibernateTemplate().get(MasEmpStatus.class, empStatusId);

		masEmpStatus.setId(empStatusId);
		masEmpStatus.setEmpStatusName(empStatusName);
		Users user = new Users();
		user.setId(userId);
		masEmpStatus.setLastChgBy(user);
		
		masEmpStatus.setLastChgDate(currentDate);
		masEmpStatus.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masEmpStatus);
		dataUpdated = true;
		return dataUpdated;
	}
	
	//-------------------- ** Trade Master ** -------------------------------
	
	@Override
	public boolean editTradeToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
		String tradeName = "";
		@SuppressWarnings("unused")
		String tradeCode = "";
		int tradeId = 0;
		int serviceTypeId=0;
		String changedBy = "";
		tradeId = (Integer) generalMap.get("id");
		serviceTypeId = (Integer) generalMap.get("serviceTypeId");
		tradeCode = (String) generalMap.get("tradeCode");
		tradeName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		
		MasTrade masTrade = (MasTrade) getHibernateTemplate().get(MasTrade.class, tradeId);

		masTrade.setId(tradeId);
		masTrade.setTradeName(tradeName);
		masTrade.setLastChgBy(changedBy);
		masTrade.setLastChgDate(currentDate);
		masTrade.setLastChgTime(currentTime);
		
		MasServiceType masServiceType = new MasServiceType();
		masServiceType.setId(serviceTypeId);
		masTrade.setServiceType(masServiceType);

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masTrade);
		dataUpdated = true;
		return dataUpdated;
	}
	@Override
	public boolean addTrade(MasTrade masTrade) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masTrade);
		successfullyAdded = true;
		return successfullyAdded;
	}
	
	
	@Override
	public boolean deleteTrade(int tradeId, Map<String, Object> generalMap) {boolean dataDeleted = false;
	String changedBy = "";
	Date currentDate = new Date();
	String currentTime = "";
	currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
			"currentTime");
	
	MasTrade masTrade = new MasTrade();
	masTrade = (MasTrade) getHibernateTemplate().load(MasTrade.class, tradeId);
	changedBy = (String) generalMap.get("changedBy");
	currentDate = (Date) generalMap.get("currentDate");
	currentTime = (String) generalMap.get("currentTime");
	if (generalMap.get("flag") != null) {
		String flag = (String) generalMap.get("flag");
		if (flag.equals("InActivate")) {
			masTrade.setStatus("n");
			dataDeleted = true;
		} else if (flag.equals("Activate")) {
			masTrade.setStatus("y");
			dataDeleted = false;
		}
	}
	masTrade.setLastChgBy(changedBy);
	masTrade.setLastChgDate(currentDate);
	masTrade.setLastChgTime(currentTime);
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	hbt.update(masTrade);
	return dataDeleted;
	}
	
	@Override
	public Map<String, Object> searchTrade(String tradeCode, String tradeName) {
		List<MasTrade> searchTradeList = new ArrayList<MasTrade>();
		Map<String, Object> tradeFieldsMap = new HashMap<String, Object>();
		List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		Session session = (Session) getSession();
		try {
			if ((tradeName != null) || (tradeCode == null)) {
				searchTradeList = session.createCriteria(MasTrade.class).add(Restrictions.like("TradeName","%"+tradeName+"%").ignoreCase()).addOrder(Order.asc("TradeName")).list();
			} else {
				searchTradeList = session.createCriteria(MasTrade.class).add(Restrictions.like("TradeCode","%"+tradeCode+"%").ignoreCase()).addOrder(Order.asc("TradeCode")).list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		serviceTypeList	 =session.createCriteria(MasServiceType.class).list();
		tradeFieldsMap.put("searchTradeList", searchTradeList);
		tradeFieldsMap.put("serviceTypeList", serviceTypeList);
		return tradeFieldsMap;
	}

	@Override
	public Map<String, Object> showTradeJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasTrade> searchTradeList = new ArrayList<MasTrade>();
		List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		Session session = (Session) getSession();
		
		searchTradeList =session.createCriteria(MasTrade.class).list(); 
		serviceTypeList	 =session.createCriteria(MasServiceType.class).list();
		map.put("searchTradeList", searchTradeList);
		map.put("serviceTypeList", serviceTypeList);
		return map;
	}
	//---------------------- End of Method By Mansi on 31 July 2013----------
	
	/**
	 * Methods By Ritu
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showDepotUnitJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<MasHospital> depotList = new ArrayList<MasHospital>();
		List<MasHospital> unitList = new ArrayList<MasHospital>();
		List<MasDepotUnit> depotUnitList = new ArrayList<MasDepotUnit>();
		depotList= session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("UnitType", "depot").ignoreCase()).list();
		unitList= session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("UnitType", "unit").ignoreCase()).list();
		depotUnitList = session.createCriteria(MasDepotUnit.class).list();
		map.put("depotList", depotList);
		map.put("unitList", unitList);
		map.put("depotUnitList", depotUnitList);
		return map;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> addDepotUnit(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = getSession();
		String message ="";
		try {
			List<MasDepotUnit> depotList = new ArrayList<MasDepotUnit>();
			//List<MasDepotUnit> unitList = new ArrayList<MasDepotUnit>();
			depotList = session.createCriteria(MasDepotUnit.class).add(Restrictions.eq("Depot.Id", box.getInt(DEPOT_ID))).add(Restrictions.eq("Unit.Id", box.getInt(UNIT_ID))).list();
			//unitList = session.createCriteria(MasDepotUnit.class).add(Restrictions.eq("Unit.Id", box.getInt(UNIT_ID))).list();
			
			
			if(depotList.size()  == 0){
				MasDepotUnit depotUnit = new MasDepotUnit();

				MasHospital depot = new MasHospital();
				depot.setId(box.getInt(DEPOT_ID));
				depotUnit.setDepot(depot);
				MasHospital unit = new MasHospital();
				unit.setId(box.getInt(UNIT_ID));
				depotUnit.setUnit(unit);
				depotUnit.setStatus("y");

				depotUnit.setLastChgBy(box.getString(CHANGED_BY));
				depotUnit.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
				depotUnit.setLastChgTime(box.getString(CHANGED_TIME));
				hbt.save(depotUnit);
				successfullyAdded = true;
			}
			else{
					message = "Depot and Unit already exist.";
				}
			
		 
		}catch (DataAccessException e) {
			e.printStackTrace();
		}
		map = showDepotUnitJsp();
		map.put("successfullyAdded", successfullyAdded);
		map.put("message", message);
		return map;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> updateDepotUnit(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = getSession();
		String message ="";
		try {
			List<MasDepotUnit> depotUnitList = new ArrayList<MasDepotUnit>();
			depotUnitList = session.createCriteria(MasDepotUnit.class).add(Restrictions.ne("Id", box.getInt(COMMON_ID))).add(Restrictions.eq("Unit.Id", box.getInt(UNIT_ID))).add(Restrictions.eq("Depot.Id", box.getInt(DEPOT_ID))).list();
			if(depotUnitList.size()  == 0){
				MasDepotUnit depotUnit = (MasDepotUnit) hbt.load(MasDepotUnit.class,box.getInt(COMMON_ID));

				MasHospital depot = new MasHospital();
				depot.setId(box.getInt(DEPOT_ID));
				depotUnit.setDepot(depot);
				MasHospital unit = new MasHospital();
				unit.setId(box.getInt(UNIT_ID));
				depotUnit.setUnit(unit);
				depotUnit.setStatus("y");

				depotUnit.setLastChgBy(box.getString(CHANGED_BY));
				depotUnit.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
				depotUnit.setLastChgTime(box.getString(CHANGED_TIME));
				hbt.update(depotUnit);
				successfullyAdded = true;
			}else{
				message = "Record already exists.";
				
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		map = showDepotUnitJsp();
		map.put("successfullyAdded", successfullyAdded);
		map.put("message", message);
		return map;
	}
	@Override
	public boolean deleteDepotUnit(Box box) {
		boolean dataDeleted = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		MasDepotUnit depotUnit = (MasDepotUnit) hbt.load(MasDepotUnit.class,box.getInt(COMMON_ID));

		if (!box.getString("flag").equals("")) {
			String flag = box.getString("flag");
			if (flag.equals("InActivate")) {
				depotUnit.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				depotUnit.setStatus("y");
				dataDeleted = true;
			}
		}
		depotUnit.setLastChgBy(box.getString("üserName"));
		depotUnit.setLastChgDate(currentDate);
		depotUnit.setLastChgTime(currentTime);
		hbt.update(depotUnit);
		return dataDeleted;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> searchDepotUnit(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepotUnit> depotUnitList = new ArrayList<MasDepotUnit>();
		List<MasDepot> depotList = new ArrayList<MasDepot>();
		List<MasHospital> unitList = new ArrayList<MasHospital>();
		Session session = getSession();
		Criteria crit = null;
		crit = session.createCriteria(MasDepotUnit.class);
		if(box.getInt(DEPOT_ID)!=0){
			crit = crit.add(Restrictions.eq("Depot.Id", box.getInt(DEPOT_ID)));
		}
		if(box.getInt(UNIT_ID)!=0){
			crit = crit.add(Restrictions.eq("Unit.Id", box.getInt(UNIT_ID)));
		}
		depotUnitList = crit.list();
		depotList= session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).list();
		unitList= session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).list();
		map.put("depotList", depotList);
		map.put("unitList", unitList);
		map.put("depotUnitList", depotUnitList);
		return map;
	}
	
	
	/**
	 * End
	 */
	

	// ------------------------------------------ Nrs
	// ---------------------------

/*	public boolean addNrs(MasNrs masNrs) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masNrs);
		successfullyAdded = true;
		return successfullyAdded;
	}
*/
	public boolean deleteNrs(int nrsId,Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasNrs masNrs = new MasNrs();
		masNrs = (MasNrs) getHibernateTemplate().get(MasNrs.class, nrsId);
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		int userId=0;
		userId = (Integer) generalMap.get("userId");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masNrs.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masNrs.setStatus("y");
				dataDeleted = false;
			}
		}
		if(userId !=0){
			Users users=new Users();
			users.setId(userId);
			masNrs.setLastChgBy(users);
			}
		masNrs.setLastChgDate(currentDate);
		masNrs.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masNrs);
		return dataDeleted;
	}

	public boolean editNrsToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String nrsName = "";
		@SuppressWarnings("unused")
		String nrsCode = "";
		int nrsId = 0;
		nrsId = (Integer) generalMap.get("id");
		nrsCode = (String) generalMap.get("nrsCode");
		nrsName = (String) generalMap.get("name");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		int userId=0;
		userId = (Integer) generalMap.get("userId");
		MasNrs masNrs = (MasNrs) getHibernateTemplate()
				.get(MasNrs.class, nrsId);

		masNrs.setId(nrsId);
		masNrs.setNrsName(nrsName);
		
		if(userId !=0){
			Users users=new Users();
			users.setId(userId);
			masNrs.setLastChgBy(users);
			}
		masNrs.setLastChgDate(currentDate);
		masNrs.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masNrs);
		dataUpdated = true;
		return dataUpdated;
	}

	public Map<String, Object> showNrsJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasNrs> searchNrsList = new ArrayList<MasNrs>();
		Session session = (Session)getSession();
		searchNrsList = session.createCriteria(MasNrs.class).list();
		map.put("searchNrsList", searchNrsList);
		return map;
	}

	public Map<String, Object> searchNrs(String nrsCode,
			String nrsName) {
		List<MasNrs> searchNrsList = new ArrayList<MasNrs>();
		Map<String, Object> nrsFieldsMap = new HashMap<String, Object>();
		Session session = (Session)getSession();
		try {
			if ((nrsName != null) || (nrsCode == null)) {
				searchNrsList = session.createCriteria(MasNrs.class).add(Restrictions.like("NrsName", "%"+nrsName+"%").ignoreCase()).addOrder(Order.asc("NrsName")).list();
			} else {
				searchNrsList = session.createCriteria(MasNrs.class).add(Restrictions.like("NrsCode", "%"+nrsCode+"%").ignoreCase()).addOrder(Order.asc("NrsCode")).list();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		nrsFieldsMap
				.put("searchNrsList", searchNrsList);
		return nrsFieldsMap;
	}
	
//-------------------- ** Traffic Destination Master ** -------------------------------
	
	@Override
	public boolean editTrafficDestinationToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
		String trafficDestinationName = "";
		@SuppressWarnings("unused")
		String trafficDestinationCode = "";
		int trafficDestinationId = 0;
		String changedBy = "";
		trafficDestinationId = (Integer) generalMap.get("id");
		trafficDestinationCode = (String) generalMap.get("trafficDestinationCode");
		trafficDestinationName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		int userId=0;
		userId = (Integer) generalMap.get("userId");
		MasTrafficDestination masTrafficDestination = (MasTrafficDestination) getHibernateTemplate().get(MasTrafficDestination.class, trafficDestinationId);

		masTrafficDestination.setId(trafficDestinationId);
		masTrafficDestination.setTrafficDestinationName(trafficDestinationName);
		if(userId !=0){
			Users users=new Users();
			users.setId(userId);
			masTrafficDestination.setLastChgBy(users);
			}
		masTrafficDestination.setLastChgDate(currentDate);
		masTrafficDestination.setLastChgTime(currentTime);


		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masTrafficDestination);
		dataUpdated = true;
		return dataUpdated;
	}
/*	@Override
	public boolean addTrafficDestination(MasTrafficDestination masTrafficDestination) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masTrafficDestination);
		successfullyAdded = true;
		return successfullyAdded;
	}*/
	
	
	@Override
	public boolean deleteTrafficDestination(int trafficDestinationId, Map<String, Object> generalMap) {boolean dataDeleted = false;
	String changedBy = "";
	Date currentDate = new Date();
	String currentTime = "";
	currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
			"currentTime");
	
	MasTrafficDestination masTrafficDestination = new MasTrafficDestination();
	masTrafficDestination = (MasTrafficDestination) getHibernateTemplate().load(MasTrafficDestination.class, trafficDestinationId);
	changedBy = (String) generalMap.get("changedBy");
	currentDate = (Date) generalMap.get("currentDate");
	currentTime = (String) generalMap.get("currentTime");
	int userId=0;
	userId = (Integer) generalMap.get("userId");
	if (generalMap.get("flag") != null) {
		String flag = (String) generalMap.get("flag");
		if (flag.equals("InActivate")) {
			masTrafficDestination.setStatus("n");
			dataDeleted = true;
		} else if (flag.equals("Activate")) {
			masTrafficDestination.setStatus("y");
			dataDeleted = false;
		}
	}
	if(userId !=0){
		Users users=new Users();
		users.setId(userId);
		masTrafficDestination.setLastChgBy(users);
		}
	masTrafficDestination.setLastChgDate(currentDate);
	masTrafficDestination.setLastChgTime(currentTime);
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	hbt.update(masTrafficDestination);
	return dataDeleted;
	}
	
	@Override
	public Map<String, Object> searchTrafficDestination(String trafficDestinationCode, String trafficDestinationName) {
		List<MasTrafficDestination> searchTrafficDestinationList = new ArrayList<MasTrafficDestination>();
		Map<String, Object> trafficDestinationFieldsMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {
			if ((trafficDestinationName != null) || (trafficDestinationCode == null)) {
				searchTrafficDestinationList = session.createCriteria(MasTrafficDestination.class).add(Restrictions.like("TrafficDestinationName","%"+trafficDestinationName+"%").ignoreCase()).addOrder(Order.asc("TrafficDestinationName")).list();
			} else {
				searchTrafficDestinationList = session.createCriteria(MasTrafficDestination.class).add(Restrictions.like("TrafficDestinationCode","%"+trafficDestinationCode+"%").ignoreCase()).addOrder(Order.asc("TrafficDestinationCode")).list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		trafficDestinationFieldsMap.put("searchTrafficDestinationList", searchTrafficDestinationList);

		return trafficDestinationFieldsMap;
	}

	@Override
	public Map<String, Object> showTrafficDestinationJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasTrafficDestination> searchTrafficDestinationList = new ArrayList<MasTrafficDestination>();
		Session session = (Session) getSession();
		searchTrafficDestinationList =session.createCriteria(MasTrafficDestination.class).list(); 
		map.put("searchTrafficDestinationList", searchTrafficDestinationList);
		return map;
	}
	
//---------------------- End of Method By Mansi on 31 July 2013----------
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showNrsTrafficDestinationJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<MasNrs> nrsList = new ArrayList<MasNrs>();
		List<MasTrafficDestination> trafficDestinationList = new ArrayList<MasTrafficDestination>();
		List<MasNrsTrafficDestination> nrsTrafficDestinationList = new ArrayList<MasNrsTrafficDestination>();
		nrsList= session.createCriteria(MasNrs.class).add(Restrictions.eq("Status", "y")).list();
		trafficDestinationList= session.createCriteria(MasTrafficDestination.class).add(Restrictions.eq("Status", "y")).list();
		nrsTrafficDestinationList = session.createCriteria(MasNrsTrafficDestination.class).list();
		map.put("nrsList", nrsList);
		map.put("trafficDestinationList", trafficDestinationList);
		map.put("nrsTrafficDestinationList", nrsTrafficDestinationList);
		return map;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> addNrsTrafficDestination(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = getSession();
		String message ="";
		try {
			List<MasNrsTrafficDestination> trafficDestinationList = new ArrayList<MasNrsTrafficDestination>();
			//List<MasNrsTrafficDestination> unitList = new ArrayList<MasNrsTrafficDestination>();
			trafficDestinationList = session.createCriteria(MasNrsTrafficDestination.class).add(Restrictions.eq("Nrs.Id", box.getInt(DEPOT_ID))).add(Restrictions.eq("TrafficDestination.Id", box.getInt(UNIT_ID))).list();
			//unitList = session.createCriteria(MasNrsTrafficDestination.class).add(Restrictions.eq("Unit.Id", box.getInt(UNIT_ID))).list();
			
			
			if(trafficDestinationList.size()  == 0){
				MasNrsTrafficDestination nrsTrafficDestination = new MasNrsTrafficDestination();

				MasNrs nrs = new MasNrs();
				nrs.setId(box.getInt(DEPOT_ID));
				nrsTrafficDestination.setNrs(nrs);
				
				MasTrafficDestination trafficeDestination = new MasTrafficDestination();
				trafficeDestination.setId(box.getInt(UNIT_ID));
				nrsTrafficDestination.setTrafficDestination(trafficeDestination);
				
				nrsTrafficDestination.setStatus("y");
				int userId=0;
				userId = (Integer) box.getInt("userId");
				if(userId !=0){
					Users users=new Users();
					users.setId(userId);
					nrsTrafficDestination.setLastChgBy(users);
					}
		
				nrsTrafficDestination.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
				nrsTrafficDestination.setLastChgTime(box.getString(CHANGED_TIME));
				hbt.save(nrsTrafficDestination);
				successfullyAdded = true;
			}
			else{
					message = "Depot and Unit already exist.";
				}
			
		 
		}catch (DataAccessException e) {
			e.printStackTrace();
		}
		map = showNrsTrafficDestinationJsp();
		map.put("successfullyAdded", successfullyAdded);
		map.put("message", message);
		return map;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> updateNrsTrafficDestination(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = getSession();
		String message ="";
		try {
			List<MasNrsTrafficDestination> nrsTrafficDestinationList = new ArrayList<MasNrsTrafficDestination>();
			nrsTrafficDestinationList = session.createCriteria(MasNrsTrafficDestination.class).add(Restrictions.ne("Id", box.getInt(COMMON_ID))).add(Restrictions.eq("TrafficDestination.Id", box.getInt(UNIT_ID))).add(Restrictions.eq("Nrs.Id", box.getInt(DEPOT_ID))).list();
			if(nrsTrafficDestinationList.size()  == 0){
				MasNrsTrafficDestination nrsTrafficDestination = (MasNrsTrafficDestination) hbt.load(MasNrsTrafficDestination.class,box.getInt(COMMON_ID));

				MasNrs nrs = new MasNrs();
				nrs.setId(box.getInt(DEPOT_ID));
				nrsTrafficDestination.setNrs(nrs);
				
				MasTrafficDestination trafficeDestination = new MasTrafficDestination();
				trafficeDestination.setId(box.getInt(UNIT_ID));
				nrsTrafficDestination.setTrafficDestination(trafficeDestination);
				
				nrsTrafficDestination.setStatus("y");
				int userId=0;
				userId = (Integer) box.getInt("userId");
				if(userId !=0){
					Users users=new Users();
					users.setId(userId);
					nrsTrafficDestination.setLastChgBy(users);
					}
		
				nrsTrafficDestination.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
				nrsTrafficDestination.setLastChgTime(box.getString(CHANGED_TIME));
				hbt.update(nrsTrafficDestination);
				successfullyAdded = true;
			}else{
				message = "Record already exists.";
				
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		map = showNrsTrafficDestinationJsp();
		map.put("successfullyAdded", successfullyAdded);
		map.put("message", message);
		return map;
	}
	@Override
	public boolean deleteNrsTrafficDestination(Box box) {
		boolean dataDeleted = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		MasNrsTrafficDestination nrsTrafficDestination = (MasNrsTrafficDestination) hbt.load(MasNrsTrafficDestination.class,box.getInt(COMMON_ID));

		if (!box.getString("flag").equals("")) {
			String flag = box.getString("flag");
			if (flag.equals("InActivate")) {
				nrsTrafficDestination.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				nrsTrafficDestination.setStatus("y");
				dataDeleted = true;
			}
		}
		int userId=0;
		userId = (Integer) box.getInt("userId");
		if(userId !=0){
			Users users=new Users();
			users.setId(userId);
			nrsTrafficDestination.setLastChgBy(users);
			}
		nrsTrafficDestination.setLastChgDate(currentDate);
		nrsTrafficDestination.setLastChgTime(currentTime);
		hbt.update(nrsTrafficDestination);
		return dataDeleted;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> searchNrsTrafficDestination(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasNrsTrafficDestination> nrsTrafficDestinationList = new ArrayList<MasNrsTrafficDestination>();
		List<MasNrs> nrsList = new ArrayList<MasNrs>();
		List<MasTrafficDestination> trafficDestinationList = new ArrayList<MasTrafficDestination>();
		Session session = getSession();
		Criteria crit = null;
		crit = session.createCriteria(MasNrsTrafficDestination.class);
		if(box.getInt(DEPOT_ID)!=0){
			crit = crit.add(Restrictions.eq("Nrs.Id", box.getInt(DEPOT_ID)));
		}
		if(box.getInt(UNIT_ID)!=0){
			crit = crit.add(Restrictions.eq("TrafficDestination.Id", box.getInt(UNIT_ID)));
		}
		nrsTrafficDestinationList = crit.list();
		nrsList= session.createCriteria(MasNrs.class).add(Restrictions.eq("Status", "y")).list();
		trafficDestinationList= session.createCriteria(MasTrafficDestination.class).add(Restrictions.eq("Status", "y")).list();
		map.put("nrsList", nrsList);
		map.put("trafficDestinationList", trafficDestinationList);
		map.put("nrsTrafficDestinationList", nrsTrafficDestinationList);
		return map;
	}
	
	
	/**
	 * End
	 */
	
		
	// ------------------------------------------ AgencyType
	// ---------------------------

	/*public boolean addAgencyType(MasExternalAgencyType masAgencyType) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masAgencyType);
		successfullyAdded = true;
		return successfullyAdded;
	}
*/
	public boolean deleteAgencyType(int agencyTypeId,Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasExternalAgencyType masAgencyType = new MasExternalAgencyType();
		masAgencyType = (MasExternalAgencyType) getHibernateTemplate().get(MasExternalAgencyType.class, agencyTypeId);
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		int userId=0;
		userId = (Integer) generalMap.get("userId");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masAgencyType.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masAgencyType.setStatus("y");
				dataDeleted = false;
			}
		}
		if(userId !=0){
			Users users=new Users();
			users.setId(userId);
			masAgencyType.setLastChgBy(users);
			}
		masAgencyType.setLastChgDate(currentDate);
		masAgencyType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masAgencyType);
		return dataDeleted;
	}

	public boolean editAgencyTypeToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String agencyTypeName = "";
		@SuppressWarnings("unused")
		String agencyTypeCode = "";
		int agencyTypeId = 0;
		agencyTypeId = (Integer) generalMap.get("id");
		agencyTypeCode = (String) generalMap.get("agencyTypeCode");
		agencyTypeName = (String) generalMap.get("name");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		int userId=0;
		userId = (Integer) generalMap.get("userId");
		MasExternalAgencyType masAgencyType = (MasExternalAgencyType) getHibernateTemplate()
				.get(MasExternalAgencyType.class, agencyTypeId);

		masAgencyType.setId(agencyTypeId);
		masAgencyType.setAgencyTypeName(agencyTypeName);
		
		if(userId !=0){
			Users users=new Users();
			users.setId(userId);
			masAgencyType.setLastChgBy(users);
			}
		masAgencyType.setLastChgDate(currentDate);
		masAgencyType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masAgencyType);
		dataUpdated = true;
		return dataUpdated;
	}

	public Map<String, Object> showAgencyTypeJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasExternalAgencyType> searchAgencyTypeList = new ArrayList<MasExternalAgencyType>();
		Session session = (Session)getSession();
		searchAgencyTypeList = session.createCriteria(MasExternalAgencyType.class).addOrder(Order.asc("AgencyTypeName")).list();
		map.put("searchAgencyTypeList", searchAgencyTypeList);
		return map;
	}

	public Map<String, Object> searchAgencyType(String agencyTypeCode,
			String agencyTypeName) {
		List<MasExternalAgencyType> searchAgencyTypeList = new ArrayList<MasExternalAgencyType>();
		Map<String, Object> agencyTypeFieldsMap = new HashMap<String, Object>();
		Session session = (Session)getSession();
		try {
			if ((agencyTypeName != null) || (agencyTypeCode == null)) {
				searchAgencyTypeList = session.createCriteria(MasExternalAgencyType.class).add(Restrictions.like("AgencyTypeName", "%"+agencyTypeName+"%").ignoreCase()).addOrder(Order.asc("AgencyTypeName")).list();
			} else {
				searchAgencyTypeList = session.createCriteria(MasExternalAgencyType.class).add(Restrictions.like("AgencyTypeCode", "%"+agencyTypeCode+"%").ignoreCase()).addOrder(Order.asc("AgencyTypeCode")).list();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		agencyTypeFieldsMap
				.put("searchAgencyTypeList", searchAgencyTypeList);
		return agencyTypeFieldsMap;
	}
	

	// -----------------------Agency-------------------------------------------
	public boolean addAgency(MasStoreSupplier masAgency) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masAgency);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editAgency(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int agencyTypeId = 0;
		String agencyName = "";
		@SuppressWarnings("unused")
		String agencyCode = "";
		int agencyId = 0;
		agencyId = (Integer) generalMap.get("id");
		agencyCode = (String) generalMap.get("agencyCode");
		agencyName = (String) generalMap.get("name");
		agencyTypeId = (Integer) generalMap.get("agencyTypeId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		
		int userId=0;
		userId = (Integer) generalMap.get("userId");
		
		MasStoreSupplier masAgency = (MasStoreSupplier) getHibernateTemplate().get(
				MasStoreSupplier.class, agencyId);

		masAgency.setId(agencyId);
		masAgency.setSupplierName(agencyName);

		   if(agencyTypeId != 0){
			   MasExternalAgencyType masAgencyType = new MasExternalAgencyType();
			   masAgencyType.setId(agencyTypeId);
			   masAgency.setAgencyType(masAgencyType);
			   }
			
			if(userId !=0){
				Users users=new Users();
				users.setId(userId);
				masAgency.setLastChgBy(users);
				}
		masAgency.setLastChgDate(currentDate);
		masAgency.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masAgency);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchAgency(String agencyCode,
			String agencyName) {
		List<MasStoreSupplier> searchAgencyList = new ArrayList<MasStoreSupplier>();
		List agencyTypeList = null;
		Map<String, Object> agencyFieldsMap = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List gridAgencyTypeList = null;
		try {
			if ((agencyName != null) || (agencyCode == null)) {
				searchAgencyList = session.createCriteria(MasStoreSupplier.class).add(Restrictions.like("SupplierName", "%"+agencyName+"%").ignoreCase()).addOrder(Order.asc("SupplierName")).list();
			} else {
				searchAgencyList = session.createCriteria(MasStoreSupplier.class).add(Restrictions.like("SupplierCode", "%"+agencyCode+"%").ignoreCase()).addOrder(Order.asc("SupplierCode")).list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		agencyTypeList = session.createCriteria(MasExternalAgencyType.class).add(Restrictions.eq("Status", "y")).list();
		gridAgencyTypeList = session.createCriteria(MasExternalAgencyType.class).list();
		agencyFieldsMap.put("gridAgencyTypeList", gridAgencyTypeList);
		agencyFieldsMap.put("searchAgencyList", searchAgencyList);
		agencyFieldsMap.put("agencyTypeList", agencyTypeList);
		return agencyFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showAgencyJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreSupplier> searchAgencyList = new ArrayList<MasStoreSupplier>();
		List<MasExternalAgencyType> agencyTypeList = new ArrayList<MasExternalAgencyType>();
		List<MasExternalAgencyType> gridAgencyTypeList = new ArrayList<MasExternalAgencyType>();
		Session session = (Session)getSession();
		
		searchAgencyList = session.createCriteria(MasStoreSupplier.class).list();
		gridAgencyTypeList = session.createCriteria(MasExternalAgencyType.class).list();
		agencyTypeList = session.createCriteria(MasExternalAgencyType.class).add(Restrictions.eq("Status", "y")).addOrder(Order.desc("AgencyTypeName")).list();
		map.put("searchAgencyList", searchAgencyList);
		map.put("agencyTypeList", agencyTypeList);
		map.put("gridAgencyTypeList", gridAgencyTypeList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteAgency(int agencyId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(	"currentTime");
		MasStoreSupplier masAgency = new MasStoreSupplier();
		masAgency = (MasStoreSupplier) getHibernateTemplate().get(MasStoreSupplier.class, agencyId);
		//Integer agencyTypeId = masAgency.getAgencyType().getId();
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		int userId=0;
		userId = (Integer) generalMap.get("userId");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			
			//List agencyTypeList = session.createCriteria(MasExternalAgencyType.class).add(Restrictions.eq("Id", agencyTypeId)).add(Restrictions.eq("Status", "y")).list();
			
			if (flag.equals("InActivate")) {
				masAgency.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masAgency.setStatus("y");
				dataDeleted = false;
			}
		}
		if(userId !=0){
			Users users=new Users();
			users.setId(userId);
			masAgency.setLastChgBy(users);
			}
		masAgency.setLastChgDate(currentDate);
		masAgency.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masAgency);
		return dataDeleted;
	}
	/*@Override
	public boolean addActivity(MasPromotionalActivity masActivity) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masActivity);
		successfullyAdded = true;
		return successfullyAdded;
	}
	@Override
	public boolean addBudgetComponent(MasBudgetComponent masBudgetComponent) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masBudgetComponent);
		successfullyAdded = true;
		return successfullyAdded;
	}*/
	@Override
	public boolean deleteActivity(int activityId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(	"currentTime");
		MasPromotionalActivity masActivity = new	MasPromotionalActivity();
		masActivity = (MasPromotionalActivity) getHibernateTemplate().get(MasPromotionalActivity.class, activityId);
	
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		int userId=0;
		userId = (Integer) generalMap.get("userId");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			
			
			if (flag.equals("InActivate")) {
				masActivity.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masActivity.setStatus("y");
				dataDeleted = false;
			}
		}
		if(userId !=0){
			Users users=new Users();
			users.setId(userId);
			masActivity.setLastChgBy(users);
			}
		masActivity.setLastChgDate(currentDate);
		masActivity.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masActivity);
		return dataDeleted;
	}
	@Override
	public boolean deleteBudgetComponent(int budgetComponentId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
		MasBudgetComponent masBudgetComponent = new MasBudgetComponent();
		masBudgetComponent = (MasBudgetComponent) getHibernateTemplate().get(MasBudgetComponent.class, budgetComponentId);
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		int userId=0;
		userId = (Integer) generalMap.get("userId");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masBudgetComponent.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masBudgetComponent.setStatus("y");
				dataDeleted = false;
			}
		}
		if(userId !=0){
			Users users=new Users();
			users.setId(userId);
			masBudgetComponent.setLastChgBy(users);
			}
		masBudgetComponent.setLastChgDate(currentDate);
		masBudgetComponent.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masBudgetComponent);
		return dataDeleted;
	}
	@Override
	public boolean editActivity(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int budgetComponentId = 0;
		String activityName = "";
		@SuppressWarnings("unused")
		String activityCode = "";
		int activityId = 0;
		activityId = (Integer) generalMap.get("id");
		activityCode = (String) generalMap.get("activityCode");
		activityName = (String) generalMap.get("name");
		budgetComponentId = (Integer) generalMap.get("budgetComponentId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		
		int userId=0;
		userId = (Integer) generalMap.get("userId");
		
		MasPromotionalActivity masActivity = (MasPromotionalActivity) getHibernateTemplate().get(
				MasPromotionalActivity.class, activityId);

		masActivity.setId(activityId);
		masActivity.setActivityName(activityName);

		   if(budgetComponentId != 0){
			   MasBudgetComponent masBudgetComponent = new MasBudgetComponent();
			   masBudgetComponent.setId(budgetComponentId);
			   masActivity.setBudgetComponent(masBudgetComponent);
			   }
			
			if(userId !=0){
				Users users=new Users();
				users.setId(userId);
				masActivity.setLastChgBy(users);
				}
			masActivity.setLastChgDate(currentDate);
			masActivity.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masActivity);
		dataUpdated = true;
		return dataUpdated;
	}
	@Override
	public boolean editBudgetComponentToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String budgetComponentName = "";
		@SuppressWarnings("unused")
		String budgetComponentCode = "";
		int budgetComponentId = 0;
		budgetComponentId = (Integer) generalMap.get("id");
		budgetComponentCode = (String) generalMap.get("budgetComponentCode");
		budgetComponentName = (String) generalMap.get("name");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		int departmentId=0;
		int userId=0;
		userId = (Integer) generalMap.get("userId");
		
		departmentId=(Integer) generalMap.get("departmentId");
		
		MasBudgetComponent masBudgetComponent = (MasBudgetComponent) getHibernateTemplate()
				.get(MasBudgetComponent.class, budgetComponentId);

		masBudgetComponent.setId(budgetComponentId);
		masBudgetComponent.setBudgetComponentName(budgetComponentName);
		
		if(departmentId !=0){
			MasDepartment department=new MasDepartment();
			department.setId(departmentId);
			masBudgetComponent.setDepartment(department);
			}
		
		if(userId !=0){
			Users users=new Users();
			users.setId(userId);
			masBudgetComponent.setLastChgBy(users);
			}
		masBudgetComponent.setLastChgDate(currentDate);
		masBudgetComponent.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masBudgetComponent);
		dataUpdated = true;
		return dataUpdated;
	}
	@Override
	public Map<String, Object> searchActivity(String activityCode,String activityName) {
		List<MasPromotionalActivity> searchActivityList = new ArrayList<MasPromotionalActivity>();
		List budgetComponentList = null;
		Map<String, Object> activityFieldsMap = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List gridBudgetComponentList = null;
		try {
			if ((activityName != null) || (activityCode == null)) {
				searchActivityList = session.createCriteria(MasPromotionalActivity.class).add(Restrictions.like("ActivityName", "%"+activityName+"%").ignoreCase()).addOrder(Order.asc("ActivityName")).list();
			} else {
				searchActivityList = session.createCriteria(MasPromotionalActivity.class).add(Restrictions.like("ActivityCode", "%"+activityCode+"%").ignoreCase()).addOrder(Order.asc("ActivityCode")).list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		budgetComponentList = session.createCriteria(MasBudgetComponent.class).add(Restrictions.eq("Status", "y")).list();
		gridBudgetComponentList = session.createCriteria(MasBudgetComponent.class).list();
		activityFieldsMap.put("gridBudgetComponentList", gridBudgetComponentList);
		activityFieldsMap.put("searchActivityList", searchActivityList);
		activityFieldsMap.put("budgetComponentList", budgetComponentList);
		return activityFieldsMap;
	}
	@Override
	public Map<String, Object> searchBudgetComponent(
			String budgetComponentCode, String budgetComponentName) {
		List<MasBudgetComponent> searchBudgetComponentList = new ArrayList<MasBudgetComponent>();
		Map<String, Object> budgetComponentFieldsMap = new HashMap<String, Object>();
		
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasDepartment> gridDepartmentList = new ArrayList<MasDepartment>();
		Session session = (Session)getSession();
		try {
			if ((budgetComponentName != null) || (budgetComponentCode == null)) {
				searchBudgetComponentList = session.createCriteria(MasBudgetComponent.class).add(Restrictions.like("BudgetComponentName", "%"+budgetComponentName+"%").ignoreCase()).addOrder(Order.asc("BudgetComponentName")).list();
			} else {
				searchBudgetComponentList = session.createCriteria(MasBudgetComponent.class).add(Restrictions.like("BudgetComponentCode", "%"+budgetComponentCode+"%").ignoreCase()).addOrder(Order.asc("BudgetComponentCode")).list();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).addOrder(Order.desc("DepartmentName")).list();
		budgetComponentFieldsMap.put("departmentList", departmentList);
		
		gridDepartmentList = session.createCriteria(MasDepartment.class).list();
		budgetComponentFieldsMap.put("gridDepartmentList", gridDepartmentList);
		budgetComponentFieldsMap.put("searchBudgetComponentList", searchBudgetComponentList);
		return budgetComponentFieldsMap;
	}
	@Override
	public Map showActivityJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasPromotionalActivity> searchActivityList = new ArrayList<MasPromotionalActivity>();
		List<MasBudgetComponent> budgetComponentList = new ArrayList<MasBudgetComponent>();
		List<MasBudgetComponent> gridBudgetComponentList = new ArrayList<MasBudgetComponent>();
		Session session = (Session)getSession();
		
		searchActivityList = session.createCriteria(MasPromotionalActivity.class).list();
		gridBudgetComponentList = session.createCriteria(MasBudgetComponent.class).list();
		budgetComponentList = session.createCriteria(MasBudgetComponent.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("BudgetComponentName")).list();
		map.put("searchActivityList", searchActivityList);
		map.put("budgetComponentList", budgetComponentList);
		map.put("gridBudgetComponentList", gridBudgetComponentList);
		return map;
	}
	@Override
	public Map<String, Object> showBudgetComponentJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasBudgetComponent> searchBudgetComponentList = new ArrayList<MasBudgetComponent>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasDepartment> gridDepartmentList = new ArrayList<MasDepartment>();
		
		Session session = (Session)getSession();
		searchBudgetComponentList = session.createCriteria(MasBudgetComponent.class).list();
		map.put("searchBudgetComponentList", searchBudgetComponentList);
		
		departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("DepartmentName")).list();
		map.put("departmentList", departmentList);
		
		gridDepartmentList = session.createCriteria(MasDepartment.class).list();
		map.put("gridDepartmentList", gridDepartmentList);
		
		return map;
	}
	/*@Override
	public boolean addGrower(MasGrower masGrower ,Map<String, Object> generalMap) {
		boolean successfullyAdded = false;
		Users users=new Users();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String time = (String) utilMap.get("currentTime");
		   
		String cStr = "";
		if (generalMap.get("cStr") != null) {
			cStr = (String) generalMap.get("cStr");
		}
		masGrower.setCategory(cStr);
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masGrower);
		
		int userId=0;
		userId = (Integer) generalMap.get("userId");
		users.setId(userId);
		
		
		FaMasSubLed faMasSubLed = new FaMasSubLed();
		FaMasSubLed subLedGrowerAccount = new FaMasSubLed();
		faMasSubLed.setSubLedCode("GSL");
		String subledName  = (String) generalMap.get("subledId");
		faMasSubLed.setSubLedDesc(subledName);
		
		subLedGrowerAccount.setSubLedCode("SLGA");
		String subLedGrwAccount =  (String) generalMap.get("subledgrowerAcId");
		subLedGrowerAccount.setSubLedDesc(subLedGrwAccount);
		
		MasGrower grower = new MasGrower();
		grower.setId(masGrower.getId());
		faMasSubLed.setGrower(grower);
		subLedGrowerAccount.setGrower(grower);
		
		MasHospital masHospital=new MasHospital();
		masHospital.setId(masGrower.getLocation().getId());
		faMasSubLed.setHospital(masHospital);
		subLedGrowerAccount.setHospital(masHospital);
		
		FaMasAccount masAccount = new FaMasAccount();
		int accId = (Integer) generalMap.get("accId");
		if(accId != 0)
		{
			masAccount.setId(accId);
			faMasSubLed.setAccount(masAccount);
		}
		
		FaMasAccount growerAccount = new FaMasAccount();
		int growerAccId = (Integer) generalMap.get("growerAccId");
		if(growerAccId != 0)
		{
			growerAccount.setId(growerAccId);
			subLedGrowerAccount.setAccount(growerAccount);
		}
		
		
		faMasSubLed.setLastChgTime(time);
		faMasSubLed.setLastChgDate(new Date());
		faMasSubLed.setStatus("y");
		faMasSubLed.setLastChgBy(users);
		
		subLedGrowerAccount.setLastChgTime(time);
		subLedGrowerAccount.setLastChgDate(new Date());
		subLedGrowerAccount.setStatus("y");
		subLedGrowerAccount.setLastChgBy(users);
		
		hbt.save(faMasSubLed);
		hbt.save(subLedGrowerAccount);
		
		
		String fileName="";
		if (generalMap.get("fileName") != null) {
			fileName = (String) generalMap.get("fileName");
		}
		String fileExtension="";
		if (generalMap.get("fileExtension") != null) {
			fileExtension = (String) generalMap.get("fileExtension");
		}
		String uploadURL="";
		if (generalMap.get("uploadURL") != null) {
			uploadURL = (String) generalMap.get("uploadURL");
		}
	
		
		if(!fileName.equals("")){
			UploadDocuments uploadDocuments = new UploadDocuments();
			StringTokenizer strToken = new StringTokenizer(fileName, ".");

			fileName = strToken.nextToken();
			fileExtension = strToken.nextToken();
			
			
			uploadDocuments.setFileExtension(fileExtension);
			uploadDocuments.setFileName(fileName);

			uploadDocuments.setLastChgTime(time);
			uploadDocuments.setLastChgDate(new Date());
			uploadDocuments.setStatus("y");
			uploadDocuments.setGrowerPhoto(masGrower);
			uploadDocuments.setUploadDate(new Date());
			uploadDocuments.setLastChgBy(users);
			uploadDocuments.setUploadDoument(uploadURL);
			//uploadDocuments.setHospital(masHospital);
			hbt.save(uploadDocuments);

			
		}
	
		successfullyAdded = true;
		return successfullyAdded;
	}*/
/*	public boolean addGrowerDetail(MasGrowerDetails masGrowerDetails) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masGrowerDetails);
		successfullyAdded = true;
		return successfullyAdded;
	}*/
	@Override
	public boolean deleteGrower(int growerId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(	"currentTime");
		MasGrower masGrower = new	MasGrower();
		masGrower = (MasGrower) getHibernateTemplate().get(MasGrower.class, growerId);
	
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		int userId=0;
		userId = (Integer) generalMap.get("userId");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			
			
			if (flag.equals("InActivate")) {
				masGrower.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masGrower.setStatus("y");
				dataDeleted = false;
			}
		}
		if(userId !=0){
			Users users=new Users();
			users.setId(userId);
			masGrower.setLastChgBy(users);
			}
		masGrower.setLastChgDate(currentDate);
		masGrower.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masGrower);
		return dataDeleted;
	}
	@Override
	public boolean editGrower(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");

		
		
		  int genderId=0;
		  String photoIdDesc="";
		  int age=0;
		  int stateId=0;
		  int districtId=0;
		  int pinCode=0;
		  String phoneNo="";
		  String fatherName="";
		  String fatherNameKann="";
		  String address="";
		  String addressKann="";
		  int  villageId=0;
		  int talukId=0;
		  int accId=0;
		  String remarks="";
		  String farmerType="";
		  String subledId ="";
		  int centreHId=0;
		String growerName = "";
		String growerNameKann = "";
		String email="";
		String bankAcNo="";
		int bankId=0;
		String ifscCode="";
		@SuppressWarnings("unused")
		
		String growerCode = "";
		int growerId = 0;
		growerId = (Integer) generalMap.get("id");
		accId = (Integer) generalMap.get("accId");
		growerCode = (String) generalMap.get("growerCode");
		remarks = (String) generalMap.get("remarks");
		farmerType = (String) generalMap.get("farmerType");
		growerName = (String) generalMap.get("name");
		growerNameKann = (String) generalMap.get("growerNameKann");
		genderId = (Integer) generalMap.get("genderId");
		photoIdDesc = (String) generalMap.get("photoIdDesc");
		email = (String) generalMap.get("email");
		age = (Integer) generalMap.get("age");
		districtId = (Integer) generalMap.get("districtId");
		pinCode = (Integer) generalMap.get("pinCode");
		stateId = (Integer) generalMap.get("stateId");
		talukId = (Integer) generalMap.get("talukId");
		
		phoneNo = (String) generalMap.get("phoneNo");
		centreHId = (Integer) generalMap.get("centreHId");
		fatherName = (String) generalMap.get("fatherName");
		fatherNameKann = (String) generalMap.get("fatherNameKann");
		 int locationId= (Integer) generalMap.get("locationId");
		address = (String) generalMap.get("address");
		addressKann = (String) generalMap.get("addressKann");
		villageId = (Integer) generalMap.get("villageId");
		
		bankAcNo = (String) generalMap.get("bankAcNo");
		bankId = (Integer) generalMap.get("bankId");
		subledId = (String) generalMap.get("subledId");
		
		
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		
		ifscCode = (String) generalMap.get("ifscCode");
		
		int userId=0;
		userId = (Integer) generalMap.get("userId");
		
		MasGrower masGrower = (MasGrower) getHibernateTemplate().get(
				MasGrower.class, growerId);

		masGrower.setId(growerId);
		masGrower.setGrowerName(growerName);
		masGrower.setGrowerNameKann(growerNameKann);

		  masGrower.setFatherName(fatherName);
		  masGrower.setFatherNameKann(fatherNameKann);
		  masGrower.setRemarks(remarks); 
		   if(accId!=0)
		   {
			FaMasAccount acc= new FaMasAccount();
			acc.setId(accId);
			masGrower.setAcc(acc);
		   }
		   if(villageId !=0){
				MasVillage village=new MasVillage();
				village.setId(villageId);
				  masGrower.setVillage(village);
				}
		   masGrower.setPhotoIdDesc(photoIdDesc);
		   masGrower.setAddress(address);
		   masGrower.setAddressKann(addressKann);
		   masGrower.setEmail(email);   
		   if(stateId !=0){
				MasState masState=new MasState();
				masState.setId(stateId);
				masGrower.setState(masState);
				}
		   if(talukId !=0){
				MasBlock masTaluk=new MasBlock();
				masTaluk.setId(talukId);
				masGrower.setBlock(masTaluk);
				}
		   
		   masGrower.setType(farmerType);
		   masGrower.setSubledgerName(subledId);
		   masGrower.setIfscCode(ifscCode);
		   
		  
		  
		   
		   if(locationId==1)
		   {
		   if(centreHId !=0){
				MasHospital l=new MasHospital();
				l.setId(centreHId);
				masGrower.setLocation(l);
				}
		   }
		   else{
			   MasHospital l=new MasHospital();
				l.setId(locationId);
				masGrower.setLocation(l);
		   }
		   
		   if(districtId !=0){
				MasDistrict masDistrict=new MasDistrict();
				masDistrict.setId(districtId);
				masGrower.setDistrict(masDistrict);
				}
		   if(genderId !=0){
				MasAdministrativeSex masAdministrativeSex=new MasAdministrativeSex();
				masAdministrativeSex.setId(genderId);
				masGrower.setGender(masAdministrativeSex);
				}
		   
	/*	   
			String cStr = "";
			if (generalMap.get("cStr") != null) {
				cStr = (String) generalMap.get("cStr");
			}
		
			masGrower.setCategory(cStr);*/
		
System.out.println("bankId----------"+bankId);
			   if(bankId !=0){
					MasBankMaster bank=new MasBankMaster();
					bank.setId(bankId);
					masGrower.setBank(bank);
					}
			   System.out.println(bankAcNo);
			   masGrower.setBankAcNo(bankAcNo);
			
		   masGrower.setPhoneNo(phoneNo);
		   masGrower.setPinCode(pinCode);
		   if(age !=0){
		   masGrower.setAge(age);
		   }
		   Users users=new Users();
			if(userId !=0){
				
				users.setId(userId);
				masGrower.setLastChgBy(users);
				}
			masGrower.setLastChgDate(currentDate);
			masGrower.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masGrower);
		
		
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String time = (String) utilMap.get("currentTime");
		
	
		userId = (Integer) generalMap.get("userId");
		users.setId(userId);
		
		String fileName="";
		if (generalMap.get("fileName") != null) {
			fileName = (String) generalMap.get("fileName");
		}
		String fileExtension="";
		if (generalMap.get("fileExtension") != null) {
			fileExtension = (String) generalMap.get("fileExtension");
		}
		String uploadURL="";
		if (generalMap.get("uploadURL") != null) {
			uploadURL = (String) generalMap.get("uploadURL");
		}
		int uploadId=0;
		if (generalMap.get("uploadId") != null) {
			uploadId = (Integer) generalMap.get("uploadId");
		}
		
		if(!fileName.equals("")){
			
			if(uploadId!=0){
				UploadDocuments uploadDocuments = (UploadDocuments)hbt.load(UploadDocuments.class, uploadId);
				hbt.delete(uploadDocuments);
			}
			UploadDocuments uploadDocuments = new UploadDocuments();
			StringTokenizer strToken = new StringTokenizer(fileName, ".");

		
	
			fileName = strToken.nextToken();
			fileExtension = strToken.nextToken();
			
			
			uploadDocuments.setFileExtension(fileExtension);
			uploadDocuments.setFileName(fileName);

			uploadDocuments.setLastChgTime(time);
			uploadDocuments.setLastChgDate(new Date());
			uploadDocuments.setStatus("y");
			uploadDocuments.setGrowerPhoto(masGrower);
			uploadDocuments.setUploadDate(new Date());
			uploadDocuments.setLastChgBy(users);
			uploadDocuments.setUploadDoument(uploadURL);
			//uploadDocuments.setHospital(masHospital);
			hbt.saveOrUpdate(uploadDocuments);

			
		}
		
		
		
		dataUpdated = true;
		return dataUpdated;
	}
	@Override
	public Map<String, Object> searchGrower(int centerId, String growerName,int locationId) {
		List<MasGrower> searchGrowerList = new ArrayList<MasGrower>();
	
		Map<String, Object> growerListFieldsMap = new HashMap<String, Object>();
		
		Session session = (Session)getSession();
		List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		List<MasDistrict> gridDistrictList = new ArrayList<MasDistrict>();
		
		List<MasState> stateList = new ArrayList<MasState>();
		List<MasState> gridStateList = new ArrayList<MasState>();
				
		
		List<MasAdministrativeSex> administrativeSexList = new ArrayList<MasAdministrativeSex>();
		List<MasAdministrativeSex> gridAdministrativeSexList = new ArrayList<MasAdministrativeSex>();
		
		
		List<FaMasAccount> faMasAccountList = new ArrayList<FaMasAccount>();
		List<FaMasAccount> gridFaMasAccountList = new ArrayList<FaMasAccount>();
		

		List<MasBlock> talukList = new ArrayList<MasBlock>();
		List<MasBlock> gridTalukList = new ArrayList<MasBlock>();
		

		List<MasVillage> villageList = new ArrayList<MasVillage>();
		List<MasVillage> gridVillageList = new ArrayList<MasVillage>();
		
		List<MasHospital> centreHList = new ArrayList<MasHospital>();
		List<MasHospital> gridCentreHList = new ArrayList<MasHospital>();

		List<MasBankMaster> masBankMasterList = new ArrayList<MasBankMaster>();
		List<MasBankMaster> gridMasBankMasterList = new ArrayList<MasBankMaster>();
		
		
		
		int purAdvGrowerId=0;
		int growerAccId =0;

		Properties properties = new Properties();
				URL resourcePath = Thread.currentThread().getContextClassLoader()
						.getResource("adt.properties");
				try {
					properties.load(resourcePath.openStream());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			purAdvGrowerId = Integer.parseInt(properties.getProperty("PUR_ADV_GROWER_ID").trim());
			growerAccId	= Integer.parseInt(properties.getProperty("GROWER_ACCOUNT_ID").trim());
			
		
		

		try {
			if ((growerName != null && centerId==0)) {
			if(locationId==1){
					searchGrowerList = session.createCriteria(MasGrower.class).add(Restrictions.like("GrowerName", "%"+growerName+"%").ignoreCase()).list();
			}else{
				searchGrowerList = session.createCriteria(MasGrower.class).add(Restrictions.like("GrowerName", "%"+growerName+"%").ignoreCase()).add(Restrictions.eq("Location.Id", locationId)).list();
			}
			} 
			else if ((growerName == null && centerId!=0)) {
				if(locationId==1){
				searchGrowerList = session.createCriteria(MasGrower.class).add(Restrictions.eq("Location.Id",centerId)).addOrder(Order.asc("GrowerName")).list();
				}else{
				searchGrowerList = session.createCriteria(MasGrower.class).add(Restrictions.eq("Location.Id",centerId)).add(Restrictions.eq("Location.Id", locationId)).list();
				}
			}
			else{
				{
					if(locationId==1){
					searchGrowerList = session.createCriteria(MasGrower.class).addOrder(Order.asc("GrowerName")).list();
					}else{
					searchGrowerList = session.createCriteria(MasGrower.class).add(Restrictions.eq("Location.Id", locationId)).list();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		gridDistrictList = session.createCriteria(MasDistrict.class).list();
		districtList = session.createCriteria(MasDistrict.class).add(Restrictions.eq("Status", "y")).addOrder(Order.desc("DistrictName")).list();
		
			
		gridStateList = session.createCriteria(MasState.class).list();
		stateList = session.createCriteria(MasState.class).add(Restrictions.eq("Status", "y")).addOrder(Order.desc("StateName")).list();
		
		
		
		gridAdministrativeSexList = session.createCriteria(MasAdministrativeSex.class).list();
		administrativeSexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).addOrder(Order.desc("AdministrativeSexName")).list();
		
		
		gridFaMasAccountList = session.createCriteria(FaMasAccount.class).list();
		faMasAccountList = session.createCriteria(FaMasAccount.class).add(Restrictions.eq("Status", "y")).addOrder(Order.desc("AccDesc")).list();
	

		gridTalukList = session.createCriteria(MasBlock.class).list();
		talukList = session.createCriteria(MasBlock.class).add(Restrictions.eq("Status", "y")).addOrder(Order.desc("BlockName")).list();
		
		
		gridVillageList = session.createCriteria(MasVillage.class).list();
		villageList = session.createCriteria(MasVillage.class).add(Restrictions.eq("Status", "y")).addOrder(Order.desc("VillageName")).list();
		
		gridCentreHList = session.createCriteria(MasHospital.class).list();
		centreHList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).addOrder(Order.desc("HospitalName")).list();
		
		
		gridMasBankMasterList = session.createCriteria(MasBankMaster.class).list();
		masBankMasterList = session.createCriteria(MasBankMaster.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("BankName")).list();
		
		growerListFieldsMap.put("searchGrowerList", searchGrowerList);
		
		
		growerListFieldsMap.put("gridFaMasAccountList", gridFaMasAccountList);
		
		growerListFieldsMap.put("faMasAccountList", faMasAccountList);
		
		growerListFieldsMap.put("districtList", districtList);
		growerListFieldsMap.put("gridDistrictList", gridDistrictList);
		growerListFieldsMap.put("stateList", stateList);
		growerListFieldsMap.put("gridStateList", gridStateList);
		growerListFieldsMap.put("administrativeSexList", administrativeSexList);
		growerListFieldsMap.put("gridAdministrativeSexList",gridAdministrativeSexList);
		growerListFieldsMap.put("villageList", villageList);
		growerListFieldsMap.put("gridVillageList", gridVillageList);
		growerListFieldsMap.put("talukList", talukList);
		growerListFieldsMap.put("gridTalukList", gridTalukList);
		
		growerListFieldsMap.put("centreHList", centreHList);
		growerListFieldsMap.put("gridCentreHList", gridCentreHList);
		growerListFieldsMap.put("purAdvGrowerId", purAdvGrowerId);
		growerListFieldsMap.put("growerAccId", growerAccId);
		
		
		growerListFieldsMap.put("gridMasBankMasterList", gridMasBankMasterList);
		growerListFieldsMap.put("masBankMasterList", masBankMasterList);
		
		return growerListFieldsMap;
	}
	@Override
	public Map showGrowerJsp(int locationId) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasGrower> searchGrowerList = new ArrayList<MasGrower>();
		
		List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		List<MasDistrict> gridDistrictList = new ArrayList<MasDistrict>();
		
		List<MasState> stateList = new ArrayList<MasState>();
		List<MasState> gridStateList = new ArrayList<MasState>();
				
		List<FaMasAccount> faMasAccountList = new ArrayList<FaMasAccount>();
		List<FaMasAccount> gridFaMasAccountList = new ArrayList<FaMasAccount>();
		
		List<MasAdministrativeSex> administrativeSexList = new ArrayList<MasAdministrativeSex>();
		List<MasAdministrativeSex> gridAdministrativeSexList = new ArrayList<MasAdministrativeSex>();
		

		List<MasBlock> talukList = new ArrayList<MasBlock>();
		List<MasBlock> gridTalukList = new ArrayList<MasBlock>();
		
		List<MasHospital> centreHList = new ArrayList<MasHospital>();
		List<MasHospital> gridCentreHList = new ArrayList<MasHospital>();

		List<MasVillage> villageList = new ArrayList<MasVillage>();
		List<MasVillage> gridVillageList = new ArrayList<MasVillage>();
		
		
		
		List<MasBankMaster> masBankMasterList = new ArrayList<MasBankMaster>();
		List<MasBankMaster> gridMasBankMasterList = new ArrayList<MasBankMaster>();

		
		List<UploadDocuments> documentList=new ArrayList<UploadDocuments>();
		
		Session session = (Session)getSession();
		
		int purAdvGrowerId=0;
		int growerAccId =0;

		Properties properties = new Properties();
				URL resourcePath = Thread.currentThread().getContextClassLoader()
						.getResource("adt.properties");
				try {
					properties.load(resourcePath.openStream());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			purAdvGrowerId = Integer.parseInt(properties.getProperty("PUR_ADV_GROWER_ID").trim());
			growerAccId	= Integer.parseInt(properties.getProperty("GROWER_ACCOUNT_ID").trim());
			
		
		if(locationId==1)
		{
		searchGrowerList = session.createCriteria(MasGrower.class).list();
		}else{
		searchGrowerList = session.createCriteria(MasGrower.class).add(Restrictions.eq("Location.Id", locationId)).list();
		}
		gridDistrictList = session.createCriteria(MasDistrict.class).list();
		districtList = session.createCriteria(MasDistrict.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("DistrictName")).list();
		
			
		gridStateList = session.createCriteria(MasState.class).list();
		stateList = session.createCriteria(MasState.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("StateName")).list();
		
		
		
		gridAdministrativeSexList = session.createCriteria(MasAdministrativeSex.class).list();
		administrativeSexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AdministrativeSexName")).list();
		
		
		gridFaMasAccountList = session.createCriteria(FaMasAccount.class).list();
		faMasAccountList = session.createCriteria(FaMasAccount.class).add(Restrictions.eq("Status", "y")).addOrder(Order.desc("AccDesc")).list();
	
		gridTalukList = session.createCriteria(MasBlock.class).list();
		talukList = session.createCriteria(MasBlock.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("BlockName")).list();


		gridVillageList = session.createCriteria(MasVillage.class).list();
		villageList = session.createCriteria(MasVillage.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("VillageName")).list();
		
		gridCentreHList = session.createCriteria(MasHospital.class).list();
		centreHList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("HospitalName")).list();
		
		
		gridMasBankMasterList = session.createCriteria(MasBankMaster.class).list();
		masBankMasterList = session.createCriteria(MasBankMaster.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("BankName")).list();
		
		
		documentList = session.createCriteria(UploadDocuments.class).list();
		map.put("growerAccId",growerAccId);
		map.put("purAdvGrowerId",purAdvGrowerId);
		map.put("searchGrowerList", searchGrowerList);
		map.put("districtList", districtList);
		map.put("documentList", documentList);
		map.put("gridDistrictList", gridDistrictList);
		map.put("stateList", stateList);
		map.put("gridStateList", gridStateList);
		map.put("administrativeSexList", administrativeSexList);
		map.put("gridAdministrativeSexList",gridAdministrativeSexList);
		map.put("villageList", villageList);
		map.put("gridVillageList", gridVillageList);
		map.put("talukList", talukList);
		map.put("gridTalukList", gridTalukList);
		map.put("gridFaMasAccountList", gridFaMasAccountList);
		
		map.put("gridMasBankMasterList", gridMasBankMasterList);
		map.put("masBankMasterList", masBankMasterList);
		
		map.put("faMasAccountList", faMasAccountList);
		map.put("centreHList", centreHList);
		map.put("gridCentreHList", gridCentreHList);
		
		return map;
	
	}
	
	@Override
	public Map<String, Object> getDistrictList(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		Session session = (Session) getSession();
		
		session = (Session) getSession();
		int state = 0;
		try {
			
			if(dataMap.get("state") != null ){
				state = (Integer)dataMap.get("state");
			}
			districtList = session.createCriteria(MasDistrict.class)
						.createAlias("State", "g")
						.add(Restrictions.eq("g.Id",state))
						.add(Restrictions.eq("Status", "y")).list();



			

		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("districtList", districtList);
		return map;

}
	@Override
	public Map<String, Object> getTalukList(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasBlock> talukList = new ArrayList<MasBlock>();
		Session session = (Session) getSession();
		
		session = (Session) getSession();
		int district = 0;
		try {
			
			if(dataMap.get("district") != null ){
				district = (Integer)dataMap.get("district");
			}
			talukList = session.createCriteria(MasBlock.class)
						.createAlias("District", "g")
						.add(Restrictions.eq("g.Id",district))
						.add(Restrictions.eq("Status", "y")).addOrder(Order.asc("BlockName")).list();



			

		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("talukList", talukList);
		return map;

}
	
	@Override
	public Map<String, Object> getVillageList(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasVillage> villageList = new ArrayList<MasVillage>();
		Session session = (Session) getSession();
		
		session = (Session) getSession();
		int block = 0;
		try {
			
			if(dataMap.get("block") != null ){
				block = (Integer)dataMap.get("block");
			}
			villageList = session.createCriteria(MasVillage.class)
						.createAlias("Block", "g")
						.add(Restrictions.eq("g.Id",block))
						.add(Restrictions.eq("Status", "y")).addOrder(Order.asc("VillageName")).list();



			

		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("villageList", villageList);
		return map;

}
		
	
	@Override
	public Map<String, Object> getGrowerDetail(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasGrowerDetails> growerDetailsList = new ArrayList<MasGrowerDetails>();
		
		List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		List<MasDistrict> gridDistrictList = new ArrayList<MasDistrict>();
		
		List<MasState> stateList = new ArrayList<MasState>();
		List<MasState> gridStateList = new ArrayList<MasState>();


		List<MasBlock> talukList = new ArrayList<MasBlock>();
		List<MasBlock> gridTalukList = new ArrayList<MasBlock>();
		
		

		List<MasVillage> villageList = new ArrayList<MasVillage>();
		List<MasVillage> gridVillageList = new ArrayList<MasVillage>();
		
		List<MasHospital> centreList = new ArrayList<MasHospital>();
		
		
		List<MasHospital> centreHList = new ArrayList<MasHospital>();
		List<MasHospital> gridCentreHList = new ArrayList<MasHospital>();
		
		
		List<MasBankMaster> masBankMasterList = new ArrayList<MasBankMaster>();
		List<MasBankMaster> gridMasBankMasterList = new ArrayList<MasBankMaster>();

		Session session = (Session) getSession();
		
		session = (Session) getSession();
		int growerId = 0;
		int locationId=0;

		try {
			
			if(dataMap.get("growerId") != null ){
				growerId = (Integer)dataMap.get("growerId");
			}
			if(dataMap.get("locationId") != null ){
				locationId = (Integer)dataMap.get("locationId");
			}
		
			if(locationId==1)
			{
			growerDetailsList = session.createCriteria(MasGrowerDetails.class).createAlias("Grower", "g").add(Restrictions.eq("g.Id",growerId)).createAlias("g.Location", "l").list();
			}else{
				growerDetailsList = session.createCriteria(MasGrowerDetails.class).createAlias("Grower", "g").add(Restrictions.eq("g.Id",growerId)).createAlias("g.Location", "l").add(Restrictions.eq("l.Id",locationId)).list();
			}


	
			
			gridDistrictList = session.createCriteria(MasDistrict.class).list();
			districtList = session.createCriteria(MasDistrict.class).add(Restrictions.eq("Status", "y")).addOrder(Order.desc("DistrictName")).list();
			
				
			gridStateList = session.createCriteria(MasState.class).list();
			stateList = session.createCriteria(MasState.class).add(Restrictions.eq("Status", "y")).addOrder(Order.desc("StateName")).list();
			
			


			gridTalukList = session.createCriteria(MasBlock.class).list();
			talukList = session.createCriteria(MasBlock.class).add(Restrictions.eq("Status", "y")).addOrder(Order.desc("BlockName")).list();


			gridVillageList = session.createCriteria(MasVillage.class).list();
			villageList = session.createCriteria(MasVillage.class).add(Restrictions.eq("Status", "y")).addOrder(Order.desc("VillageName")).list();
			
			centreList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).addOrder(Order.desc("HospitalName")).list();
			
			gridCentreHList = session.createCriteria(MasHospital.class).list();
			centreHList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).addOrder(Order.desc("HospitalName")).list();
			
			
			gridMasBankMasterList = session.createCriteria(MasBankMaster.class).list();
			masBankMasterList = session.createCriteria(MasBankMaster.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("BankName")).list();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("growerDetailsList",growerDetailsList);
		map.put("growerId",growerId);
		map.put("centreList",centreList);
		map.put("districtList", districtList);
		map.put("gridDistrictList", gridDistrictList);
		map.put("stateList", stateList);
		map.put("gridStateList", gridStateList);
		map.put("villageList", villageList);
		map.put("gridVillageList", gridVillageList);
		map.put("talukList", talukList);
		map.put("gridTalukList", gridTalukList);
		map.put("centreHList", centreHList);
		map.put("gridCentreHList", gridCentreHList);
		
		map.put("gridMasBankMasterList", gridMasBankMasterList);
		map.put("masBankMasterList", masBankMasterList);
		return map;

}
	

	@Override
	public Map<String, Object> getGrowerLandDetail(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasGrowerDetails> growerDetailsLandList = new ArrayList<MasGrowerDetails>();
		
		List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		List<MasDistrict> gridDistrictList = new ArrayList<MasDistrict>();
		
		List<MasState> stateList = new ArrayList<MasState>();
		List<MasState> gridStateList = new ArrayList<MasState>();


		List<MasBlock> talukList = new ArrayList<MasBlock>();
		List<MasBlock> gridTalukList = new ArrayList<MasBlock>();
		
		

		List<MasVillage> villageList = new ArrayList<MasVillage>();
		List<MasVillage> gridVillageList = new ArrayList<MasVillage>();
	
		List<MasHospital> centreList = new ArrayList<MasHospital>();
		
		
		List<MasHospital> centreHList = new ArrayList<MasHospital>();
		List<MasHospital> gridCentreHList = new ArrayList<MasHospital>();
		
		
		List<MasBankMaster> masBankMasterList = new ArrayList<MasBankMaster>();
		List<MasBankMaster> gridMasBankMasterList = new ArrayList<MasBankMaster>();

		Session session = (Session) getSession();
		
		session = (Session) getSession();
			int gLandId=0;
			int growerId=0;
			int locationId=0;
		try {
			
		
			if(dataMap.get("gLandId") != null ){
				gLandId = (Integer)dataMap.get("gLandId");
			}
			if(dataMap.get("growerId") != null ){
				growerId = (Integer)dataMap.get("growerId");
			}
			if(dataMap.get("locationId") != null ){
				locationId = (Integer)dataMap.get("locationId");
			}
			System.out.println(gLandId);
			if(locationId==1){
				growerDetailsLandList = session.createCriteria(MasGrowerDetails.class).add(Restrictions.eq("Id",gLandId)).createAlias("Grower", "g").createAlias("g.Location", "l").list();
			
			}else{
				growerDetailsLandList = session.createCriteria(MasGrowerDetails.class).add(Restrictions.eq("Id",gLandId)).createAlias("Grower", "g").createAlias("g.Location", "l").add(Restrictions.eq("l.Id",locationId)).list();
			}

			

			gridDistrictList = session.createCriteria(MasDistrict.class).list();
			districtList = session.createCriteria(MasDistrict.class).add(Restrictions.eq("Status", "y")).addOrder(Order.desc("DistrictName")).list();
			
				
			gridStateList = session.createCriteria(MasState.class).list();
			stateList = session.createCriteria(MasState.class).add(Restrictions.eq("Status", "y")).addOrder(Order.desc("StateName")).list();
			
			


			gridTalukList = session.createCriteria(MasBlock.class).list();
			talukList = session.createCriteria(MasBlock.class).add(Restrictions.eq("Status", "y")).addOrder(Order.desc("BlockName")).list();


			gridVillageList = session.createCriteria(MasVillage.class).list();
			villageList = session.createCriteria(MasVillage.class).add(Restrictions.eq("Status", "y")).addOrder(Order.desc("VillageName")).list();
			
			centreList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).addOrder(Order.desc("HospitalName")).list();
			

			gridCentreHList = session.createCriteria(MasHospital.class).list();
			centreHList= session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).addOrder(Order.desc("HospitalName")).list();
			
			gridMasBankMasterList = session.createCriteria(MasBankMaster.class).list();
			masBankMasterList = session.createCriteria(MasBankMaster.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("BankName")).list();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("growerDetailsLandList",growerDetailsLandList);
		map.put("centreList",centreList);
		map.put("gLandId",gLandId);
		map.put("growerId",growerId);
		map.put("districtList", districtList);
		map.put("gridDistrictList", gridDistrictList);
		map.put("stateList", stateList);
		map.put("gridStateList", gridStateList);
		map.put("villageList", villageList);
		map.put("gridVillageList", gridVillageList);
		map.put("talukList", talukList);
		map.put("gridTalukList", gridTalukList);
		
		map.put("gridCentreHList", gridCentreHList);
		map.put("centreHList", centreHList);
		
		map.put("gridMasBankMasterList", gridMasBankMasterList);
		map.put("masBankMasterList", masBankMasterList);
		return map;

}

	@Override
	public boolean updateGrowerLandDetail(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");

		
		  int villageLandId=0;
		  int talukLandId=0;
		  int stateLandId=0;
		  int districtLandId=0;
		  String surveyNo="";
		  BigDecimal farmArea=null;
		  BigDecimal distance=null;
		  String farmRoute="";
		  
		  //int centreId=0;
		
		String growerCode = "";
		int growerId = 0;
		int gLandId=0;
		String irrigationFacility="";
		gLandId = (Integer) generalMap.get("gLandId");
		System.out.println(gLandId);
		growerId = (Integer) generalMap.get("growerId");
		farmRoute = (String) generalMap.get("farmRoute");
		villageLandId = (Integer) generalMap.get("villageLandId");
		surveyNo = (String) generalMap.get("surveyNo");
		districtLandId = (Integer) generalMap.get("districtLandId");
		stateLandId = (Integer) generalMap.get("stateLandId");
		talukLandId = (Integer) generalMap.get("talukLandId");
		//centreId= (Integer) generalMap.get("centreId");
		farmArea = (BigDecimal) generalMap.get("farmArea");
		distance = (BigDecimal) generalMap.get("distance");
		String soilType="";		
		soilType = (String) generalMap.get("soilType");
		irrigationFacility = (String) generalMap.get("irrigationFacility");
		int userId=0;
		userId = (Integer) generalMap.get("userId");
		
		MasGrowerDetails masGrowerDetails = (MasGrowerDetails) getHibernateTemplate().get(
				MasGrowerDetails.class, gLandId);

		masGrowerDetails.setId(gLandId);
	
		
		 if(stateLandId !=0){
				MasState masState=new MasState();
				masState.setId(stateLandId);
				masGrowerDetails.setState(masState);
				}
		   
		   	   
		   if(districtLandId !=0){
				MasDistrict masDistrict=new MasDistrict();
				masDistrict.setId(districtLandId);
				masGrowerDetails.setDistrict(masDistrict);
				}
		     if(talukLandId !=0){
				MasBlock masTaluk=new MasBlock();
				masTaluk.setId(talukLandId);
				masGrowerDetails.setBlock(masTaluk);
				}

			   if(villageLandId !=0){
					MasVillage village=new MasVillage();
					village.setId(villageLandId);
					masGrowerDetails.setVillage(village);
					}
			  masGrowerDetails.setSurveyNo(surveyNo);
			  masGrowerDetails.setFarmArea(farmArea);
			  masGrowerDetails.setFarmRoute(farmRoute);
			  masGrowerDetails.setDistance(distance);
			  masGrowerDetails.setSoilType(soilType);
			  masGrowerDetails.setIrrigationFacility(irrigationFacility);
			 /*  if(centreId !=0){
					MasHospital masHospital=new MasHospital();
					masHospital.setId(centreId);
					masGrowerDetails.setCentre(masHospital);
					}*/
			   
			  if(growerId !=0){
					MasGrower m=new MasGrower();
					m.setId(growerId);
					masGrowerDetails.setGrower(m);
					}

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masGrowerDetails);
		dataUpdated = true;
		return dataUpdated;
	}
	@Override
	public Map<String, Object> displayPhoto(String code) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		session = (Session) getSession();
		
		List<UploadDocuments> documentList=new ArrayList<UploadDocuments>();
		documentList = session.createCriteria(UploadDocuments.class).add(Restrictions.eq("FileName",code)).list();
		
		map.put("documentList", documentList);
		return map;
	}
	
	
	@Override
	public boolean deleteFinancialYearMaster(int financialYrId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		Date currentDate = new Date();
		String currentTime = "";
		int userId=0;
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		try {
			MasStoreFinancial hrMasFinancialYear = new MasStoreFinancial();
			hrMasFinancialYear = (MasStoreFinancial) getHibernateTemplate().load(
					MasStoreFinancial.class, financialYrId);
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
		
			userId = (Integer) generalMap.get("userId");
			
			if (hrMasFinancialYear.getStatus().equals("y")) {
				hrMasFinancialYear.setStatus("n");
				dataDeleted = true;
			} else {
				hrMasFinancialYear.setStatus("y");
				dataDeleted = false;
			}

		
			if(userId !=0){
				Users users=new Users();
				users.setId(userId);
				hrMasFinancialYear.setLastChgBy(users);
				}
			hrMasFinancialYear.setLastChgDate(currentDate);
			hrMasFinancialYear.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrMasFinancialYear);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataDeleted;
	}

	public Map showFinancialJsp() {
		Map map = new HashMap();
		Session session = (Session) getSession();
		List<MasStoreFinancial> searchFinancialYearMasterList = session
				.createCriteria(MasStoreFinancial.class).addOrder(Order.asc("YearDescription")).list();

		if (searchFinancialYearMasterList != null) {
			map.put("searchFinancialYearMasterList",
					searchFinancialYearMasterList);
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map searchFinancialYearMaster(String year, String financialYear) {
		List<MasStoreFinancial> searchFinancialYearMasterList = new ArrayList<MasStoreFinancial>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Session session = (Session)getSession();
		try {
			if (year != null || financialYear == null) {

				searchFinancialYearMasterList = session.createCriteria(MasStoreFinancial.class).add(Restrictions.like("YearDescription", "%"+year+"%").ignoreCase()).addOrder(Order.asc("YearDescription")).list();
				
				
			} else {
			
				
				searchFinancialYearMasterList = session.createCriteria(MasStoreFinancial.class).add(Restrictions.like("FinancialYear", "%"+financialYear+"%").ignoreCase()).addOrder(Order.asc("FinancialYear")).list();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		generalMap.put("searchFinancialYearMasterList",
				searchFinancialYearMasterList);
		return generalMap;
	}

	public boolean addFinancialYearMaster(MasStoreFinancial hrMasFinancialYear) {
		boolean successfullyAdded = false;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(hrMasFinancialYear);
		hbt.refresh(hrMasFinancialYear);
		successfullyAdded = true;

		return successfullyAdded;
	}
	
	@Override
	public boolean editFinancialYearMaster(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String year = "";
		String financialyear = "";
		Date fromDate = null;
		Date toDate = null;
		int financialYrId = 0;
		int userId=0;
		String changedBy = "";

		try {
			financialYrId = (Integer) generalMap.get("id");
			fromDate = (Date) generalMap.get("fromDate");
			toDate = (Date) generalMap.get("toDate");
			year = (String) generalMap.get("code");
			financialyear = (String) generalMap.get("name");

			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			
			userId = (Integer) generalMap.get("userId");
			
			MasStoreFinancial hrMasFinancialYear = (MasStoreFinancial) getHibernateTemplate()
					.load(MasStoreFinancial.class, financialYrId);

			hrMasFinancialYear.setId(financialYrId);
			hrMasFinancialYear.setFinancialYear(financialyear);
			hrMasFinancialYear.setYearDescription(year);
			hrMasFinancialYear.setStartDate(fromDate);
			hrMasFinancialYear.setEndDate(toDate);
			if(userId !=0){
				Users users=new Users();
				users.setId(userId);
				hrMasFinancialYear.setLastChgBy(users);
				}
			hrMasFinancialYear.setLastChgDate(currentDate);
			hrMasFinancialYear.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrMasFinancialYear);
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}
	/*@Override
	public boolean addCategory(MasCategory masCategory) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masCategory);
		successfullyAdded = true;
		return successfullyAdded;
	}*/
	/*@Override
	public boolean addCaste(MasEmployeeCaste masCaste) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masCaste);
		successfullyAdded = true;
		return successfullyAdded;
	}
	@Override
	public boolean addSubCaste(MasEmployeeSubCaste masSubCaste) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masSubCaste);
		successfullyAdded = true;
		return successfullyAdded;
	}*/
	@Override
	public boolean deleteCategory(int categoryId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(	"currentTime");
		MasCategory masCategory = new	MasCategory();
		masCategory = (MasCategory) getHibernateTemplate().get(MasCategory.class, categoryId);
	
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		int userId=0;
		userId = (Integer) generalMap.get("userId");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			
			
			if (flag.equals("InActivate")) {
				masCategory.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masCategory.setStatus("y");
				dataDeleted = false;
			}
		}
		if(userId !=0){
			Users users=new Users();
			users.setId(userId);
			masCategory.setLastChgBy(users);
			}
		masCategory.setLastChgDate(currentDate);
		masCategory.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masCategory);
		return dataDeleted;
	}
	@Override
	public boolean deleteCaste(int casteId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(	"currentTime");
		MasEmployeeCaste masCaste = new	MasEmployeeCaste();
		masCaste = (MasEmployeeCaste) getHibernateTemplate().get(MasEmployeeCaste.class, casteId);
	
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		int userId=0;
		userId = (Integer) generalMap.get("userId");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			
			
			if (flag.equals("InActivate")) {
				masCaste.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masCaste.setStatus("y");
				dataDeleted = false;
			}
		}
		if(userId !=0){
			Users users=new Users();
			users.setId(userId);
			masCaste.setLastChgBy(users);
			}
		masCaste.setLastChgDate(currentDate);
		masCaste.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masCaste);
		return dataDeleted;
	}
	@Override
	public boolean deleteSubCaste(int subCasteId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(	"currentTime");
		MasEmployeeSubCaste masSubCaste = new	MasEmployeeSubCaste();
		masSubCaste = (MasEmployeeSubCaste) getHibernateTemplate().get(MasEmployeeSubCaste.class, subCasteId);
	
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		int userId=0;
		userId = (Integer) generalMap.get("userId");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			
			
			if (flag.equals("InActivate")) {
				masSubCaste.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masSubCaste.setStatus("y");
				dataDeleted = false;
			}
		}
		if(userId !=0){
			Users users=new Users();
			users.setId(userId);
			masSubCaste.setLastChgBy(users);
			}
		masSubCaste.setLastChgDate(currentDate);
		masSubCaste.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masSubCaste);
		return dataDeleted;
	}
	@Override
	public boolean editCategoryToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String categoryName = "";
		@SuppressWarnings("unused")
		String categoryCode = "";
		int categoryId = 0;
		categoryId = (Integer) generalMap.get("id");
		categoryCode = (String) generalMap.get("casteCode");
		categoryName = (String) generalMap.get("name");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		
		int userId=0;
		userId = (Integer) generalMap.get("userId");
		
		MasCategory masCategory = (MasCategory) getHibernateTemplate().get(
				MasCategory.class, categoryId);

		masCategory.setId(categoryId);
		masCategory.setCategoryName(categoryName);

	
			
			if(userId !=0){
				Users users=new Users();
				users.setId(userId);
				masCategory.setLastChgBy(users);
				}
			masCategory.setLastChgDate(currentDate);
			masCategory.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masCategory);
		dataUpdated = true;
		return dataUpdated;
	}
	@Override
	public boolean editCasteToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String casteName = "";
		@SuppressWarnings("unused")
		String casteCode = "";
		int casteId = 0;
		casteId = (Integer) generalMap.get("id");
		casteCode = (String) generalMap.get("casteCode");
		casteName = (String) generalMap.get("name");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		
		int userId=0;
		userId = (Integer) generalMap.get("userId");
		
		MasEmployeeCaste masCaste = (MasEmployeeCaste) getHibernateTemplate().get(
				MasEmployeeCaste.class, casteId);

		masCaste.setId(casteId);
		masCaste.setCasteName(casteName);

	
			
			if(userId !=0){
				Users users=new Users();
				users.setId(userId);
				masCaste.setLastChgBy(users);
				}
			masCaste.setLastChgDate(currentDate);
			masCaste.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masCaste);
		dataUpdated = true;
		return dataUpdated;
	}
	@Override
	public boolean editSubCasteToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
		String subCasteName = "";
		@SuppressWarnings("unused")
		String subCasteCode = "";
		int subCasteId = 0;
		subCasteId = (Integer) generalMap.get("id");
		subCasteCode = (String) generalMap.get("subCasteCode");
		subCasteName = (String) generalMap.get("name");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		
		int userId=0;
		userId = (Integer) generalMap.get("userId");
		
		MasEmployeeSubCaste masSubCaste = (MasEmployeeSubCaste) getHibernateTemplate().get(
				MasEmployeeSubCaste.class, subCasteId);

		masSubCaste.setId(subCasteId);
		masSubCaste.setSubCasteName(subCasteName);
		if(userId !=0){
				Users users=new Users();
				users.setId(userId);
				masSubCaste.setLastChgBy(users);
				}
			masSubCaste.setLastChgDate(currentDate);
			masSubCaste.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masSubCaste);
		dataUpdated = true;
		return dataUpdated;
	}
	@Override
	public Map<String, Object> searchCategory(String categoryCode, String categoryName) {
		List<MasCategory> searchCategoryList = new ArrayList<MasCategory>();
		Map<String, Object> categoryFieldsMap = new HashMap<String, Object>();
		Session session = (Session)getSession();
		try {
			if ((categoryName != null) || (categoryCode == null)) {
				searchCategoryList = session.createCriteria(MasCategory.class).add(Restrictions.like("CategoryName", "%"+categoryName+"%").ignoreCase()).addOrder(Order.asc("CategoryName")).list();
			} else {
				searchCategoryList = session.createCriteria(MasCategory.class).add(Restrictions.like("CategoryCode", "%"+categoryCode+"%").ignoreCase()).addOrder(Order.asc("CategoryCode")).list();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		categoryFieldsMap.put("searchCategoryList", searchCategoryList);
		return categoryFieldsMap;
	}
	@Override
	public Map<String, Object> searchCaste(String casteCode, String casteName) {
		List<MasEmployeeCaste> searchCasteList = new ArrayList<MasEmployeeCaste>();
		Map<String, Object> casteFieldsMap = new HashMap<String, Object>();
		Session session = (Session)getSession();
		try {
			if ((casteName != null) || (casteCode == null)) {
				searchCasteList = session.createCriteria(MasEmployeeCaste.class).add(Restrictions.like("CasteName", "%"+casteName+"%").ignoreCase()).addOrder(Order.asc("CasteName")).list();
			} else {
				searchCasteList = session.createCriteria(MasEmployeeCaste.class).add(Restrictions.like("CasteCode", "%"+casteCode+"%").ignoreCase()).addOrder(Order.asc("CasteCode")).list();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		casteFieldsMap.put("searchCasteList", searchCasteList);
		return casteFieldsMap;
	}
	@Override
	public Map<String, Object> searchSubCaste(String subCasteCode,
			String subCasteName) {
		List<MasEmployeeSubCaste> searchSubCasteList = new ArrayList<MasEmployeeSubCaste>();
		Map<String, Object> subCasteFieldsMap = new HashMap<String, Object>();
		Session session = (Session)getSession();
		try {
			if ((subCasteName != null) || (subCasteCode == null)) {
				searchSubCasteList = session.createCriteria(MasEmployeeSubCaste.class).add(Restrictions.like("SubCasteName", "%"+subCasteName+"%").ignoreCase()).addOrder(Order.asc("SubCasteName")).list();
			} else {
				searchSubCasteList = session.createCriteria(MasEmployeeSubCaste.class).add(Restrictions.like("SubCasteCode", "%"+subCasteCode+"%").ignoreCase()).addOrder(Order.asc("SubCasteCode")).list();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		subCasteFieldsMap.put("searchSubCasteList", searchSubCasteList);
		return subCasteFieldsMap;
	}
	@Override
	public Map<String, Object> showCategoryJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasCategory> searchCategoryList = new ArrayList<MasCategory>();
		Session session = (Session)getSession();
		searchCategoryList = session.createCriteria(MasCategory.class).addOrder(Order.asc("CategoryName")).list();
		map.put("searchCategoryList", searchCategoryList);
		return map;
	}
	@Override
	public Map<String, Object> showCasteJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployeeCaste> searchCasteList = new ArrayList<MasEmployeeCaste>();
		Session session = (Session)getSession();
		searchCasteList = session.createCriteria(MasEmployeeCaste.class).addOrder(Order.asc("CasteName")).list();
		map.put("searchCasteList", searchCasteList);
		return map;
	}
	@Override
	public Map<String, Object> showSubCasteJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployeeSubCaste> searchSubCasteList = new ArrayList<MasEmployeeSubCaste>();
		Session session = (Session)getSession();
		searchSubCasteList = session.createCriteria(MasEmployeeSubCaste.class).addOrder(Order.asc("SubCasteName")).list();
		map.put("searchSubCasteList", searchSubCasteList);
		return map;
	}

	


	// -----------------------------AssetCategory ------------------------------------

	/*public boolean addAssetCategory(MasAssetCategory masAssetCategory) {
		boolean saveFlag = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(masAssetCategory);
			saveFlag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saveFlag;
	}*/

	@SuppressWarnings("unchecked")
	public boolean deleteAssetCategory(int assetCategoryId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int userId = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasAssetCategory masAssetCategory = new MasAssetCategory();
		masAssetCategory = (MasAssetCategory) getHibernateTemplate().get(MasAssetCategory.class,
				assetCategoryId);
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			
			if (flag.equals("InActivate")) {
				masAssetCategory.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masAssetCategory.setStatus("y");
				dataDeleted = false;
			}
		}
		

	
		Users user = new Users();
		user.setId(userId);
		masAssetCategory.setLastChgBy(user);
		masAssetCategory.setLastChgDate(currentDate);
		masAssetCategory.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masAssetCategory);
		return dataDeleted;
	}

	public boolean editAssetCategory(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int countryId = 0;
		String assetCategoryName = "";
		@SuppressWarnings("unused")
		String assetCategoryCode = "";
		int assetCategoryId = 0;
		int userId=0;
		String remarks="";
		String assetCategoryType="";
		String assetDescription="";
		BigDecimal depreciation=null;
		try {
			assetCategoryId = (Integer) generalMap.get("id");
			assetCategoryCode = (String) generalMap.get("assetCategoryCode");
			assetCategoryName = (String) generalMap.get("name");
			remarks= (String) generalMap.get("remarks");
			assetCategoryType= (String) generalMap.get("assetCategoryType");
			assetDescription= (String) generalMap.get("assetDescription");
			depreciation=(BigDecimal) generalMap.get("depreciation");
			userId = (Integer) generalMap.get("userId");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			MasAssetCategory masAssetCategory = (MasAssetCategory) getHibernateTemplate().get(
					MasAssetCategory.class, assetCategoryId);
			masAssetCategory.setId(assetCategoryId);
			masAssetCategory.setAssetCategoryName(assetCategoryName);
			Users user = new Users();
			user.setId(userId);
			masAssetCategory.setLastChgBy(user);
			masAssetCategory.setAssetCategoryType(assetCategoryType);
			masAssetCategory.setAssetDescription(assetDescription);
			masAssetCategory.setRemarks(remarks);
			masAssetCategory.setDepreciation(depreciation);
			
			masAssetCategory.setLastChgDate(currentDate);
			masAssetCategory.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masAssetCategory);
			dataUpdated = true;
		} catch (Exception e) {
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchAssetCategory(String assetCategoryCode, String assetCategoryName) {

		List masAssetCategoryList = new ArrayList();
		Map<String, Object> assetCategoryFieldMap = new HashMap<String, Object>();
		Session session = (Session)getSession();
		try {
			if ((assetCategoryName != null) || (assetCategoryCode == null)) {
				masAssetCategoryList = session.createCriteria(MasAssetCategory.class).add(Restrictions.like("AssetCategoryName", "%"+assetCategoryName+"%").ignoreCase()).addOrder(Order.asc("AssetCategoryName")).list();
			} else {
				masAssetCategoryList = session.createCriteria(MasAssetCategory.class).add(Restrictions.like("AssetCategoryCode", "%"+assetCategoryCode+"%").ignoreCase()).addOrder(Order.asc("AssetCategoryCode")).list();

			}
		} catch (Exception e) {
		}
		assetCategoryFieldMap.put("masAssetCategoryList", masAssetCategoryList);
		return assetCategoryFieldMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showAssetCategoryJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasAssetCategory> masAssetCategoryList = new ArrayList<MasAssetCategory>();
		Session session = (Session)getSession();
		masAssetCategoryList = session.createCriteria(MasAssetCategory.class).list();
		map.put("masAssetCategoryList", masAssetCategoryList);
		return map;
	}

	public Map showAssetDetailsJsp(int locationId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<ProjAssetDetails> projAssetDetailsList = new ArrayList<ProjAssetDetails>();
		Session session = (Session)getSession();
		projAssetDetailsList = session.createCriteria(ProjAssetDetails.class).addOrder(Order.desc("AssetName")).list();

		
		Criteria cr = null;
	
			if(locationId==1){
				projAssetDetailsList = session.createCriteria(ProjAssetDetails.class).addOrder(Order.desc("AssetName")).list();
			}else{
				projAssetDetailsList = session.createCriteria(ProjAssetDetails.class)
						        .add(Restrictions.eq("Centre.Id", locationId))
						        .addOrder(Order.desc("AssetName")).list();
			}

		
			map.put("projAssetDetailsList", projAssetDetailsList);
		List<MasAssetCategory> assetCategoryList = new ArrayList<MasAssetCategory>();
		assetCategoryList = session.createCriteria(MasAssetCategory.class).addOrder(Order.desc("AssetCategoryName")).add(Restrictions.eq("Status", "y")).list();
		map.put("assetCategoryList", assetCategoryList);
		
		List<MasAssetStatus> assetStatusList = new ArrayList<MasAssetStatus>();
		assetStatusList = session.createCriteria(MasAssetStatus.class).addOrder(Order.desc("AssetStatusName")).list();
		map.put("assetStatusList", assetStatusList);
		
		
		List<MasUnitOfMeasurement> uomLandExtentList = new ArrayList<MasUnitOfMeasurement>();
		uomLandExtentList = session.createCriteria(MasUnitOfMeasurement.class).addOrder(Order.desc("UnitOfMeasurementName")).list();
		map.put("uomLandExtentList", uomLandExtentList);
		
		
		List<MasUnitOfMeasurement> uomLandMeasurementList = new ArrayList<MasUnitOfMeasurement>();
		uomLandMeasurementList = session.createCriteria(MasUnitOfMeasurement.class).addOrder(Order.desc("UnitOfMeasurementName")).list();
		map.put("uomLandMeasurementList", uomLandMeasurementList);
		
		
		List<MasUnitOfMeasurement> capacityUomList = new ArrayList<MasUnitOfMeasurement>();
		capacityUomList = session.createCriteria(MasUnitOfMeasurement.class).addOrder(Order.desc("UnitOfMeasurementName")).list();
		map.put("capacityUomList", capacityUomList);
		

		List<MasStoreSupplier> storeSupplierList = new ArrayList<MasStoreSupplier>();
		storeSupplierList = session.createCriteria(MasStoreSupplier.class).addOrder(Order.desc("SupplierName")).list();
		map.put("storeSupplierList", storeSupplierList);
		
		
		
		List<MasHospital> centreList = new ArrayList<MasHospital>();
		centreList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).addOrder(Order.desc("HospitalName")).list();
		map.put("centreList", centreList);
		
		List<MasHospital> gridCentreHList = new ArrayList<MasHospital>();
		gridCentreHList = session.createCriteria(MasHospital.class).list();
		map.put("gridCentreHList", gridCentreHList);
		map.put("assetCatMap",0);
		return map;
	}

	public Map<String, Object> getAssetDetail(Map<String, Object> dataMap) {
		int assetDeatilsId=0;
		if(dataMap.get("assetDeatilsId") != null ){
			assetDeatilsId = (Integer)dataMap.get("assetDeatilsId");
		}
	
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<ProjAssetDetails> projAssetDetailsList = new ArrayList<ProjAssetDetails>();
		Session session = (Session)getSession();
		projAssetDetailsList = session.createCriteria(ProjAssetDetails.class).add(Restrictions.eq("Id",assetDeatilsId)).addOrder(Order.desc("AssetName")).list();
		map.put("projAssetDetailsList", projAssetDetailsList);
		
		
		List<MasAssetCategory> assetCategoryList = new ArrayList<MasAssetCategory>();
		assetCategoryList = session.createCriteria(MasAssetCategory.class).addOrder(Order.desc("AssetCategoryName")).add(Restrictions.eq("Status", "y")).list();
		map.put("assetCategoryList", assetCategoryList);
		
		List<MasAssetStatus> assetStatusList = new ArrayList<MasAssetStatus>();
		assetStatusList = session.createCriteria(MasAssetStatus.class).addOrder(Order.desc("AssetStatusName")).list();
		map.put("assetStatusList", assetStatusList);
		
		
		List<MasUnitOfMeasurement> uomLandExtentList = new ArrayList<MasUnitOfMeasurement>();
		uomLandExtentList = session.createCriteria(MasUnitOfMeasurement.class).addOrder(Order.desc("UnitOfMeasurementName")).list();
		map.put("uomLandExtentList", uomLandExtentList);
		
		
		List<MasUnitOfMeasurement> uomLandMeasurementList = new ArrayList<MasUnitOfMeasurement>();
		uomLandMeasurementList = session.createCriteria(MasUnitOfMeasurement.class).addOrder(Order.desc("UnitOfMeasurementName")).list();
		map.put("uomLandMeasurementList", uomLandMeasurementList);
		
		
		List<MasHospital> centreList = new ArrayList<MasHospital>();
		centreList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).addOrder(Order.desc("HospitalName")).list();
		map.put("centreList", centreList);
		
		
		List<MasHospital> gridCentreHList = new ArrayList<MasHospital>();
		gridCentreHList = session.createCriteria(MasHospital.class).list();
		map.put("gridCentreHList", gridCentreHList);
		
		

		List<MasUnitOfMeasurement> capacityUomList = new ArrayList<MasUnitOfMeasurement>();
		capacityUomList = session.createCriteria(MasUnitOfMeasurement.class).addOrder(Order.desc("UnitOfMeasurementName")).list();
		map.put("capacityUomList", capacityUomList);
		

		List<MasStoreSupplier> storeSupplierList = new ArrayList<MasStoreSupplier>();
		storeSupplierList = session.createCriteria(MasStoreSupplier.class).addOrder(Order.desc("SupplierName")).list();
		map.put("storeSupplierList", storeSupplierList);
		
		List<UploadDocuments> documentList=new ArrayList<UploadDocuments>();
		documentList = session.createCriteria(UploadDocuments.class).createAlias("AssetDetails", "a").add(Restrictions.eq("a.Id",assetDeatilsId)).list();
		
		map.put("documentList", documentList);
		map.put("assetCatMap",0);
		return map;
	}
	/*@Override
	public boolean addAssetDetails(ProjAssetDetails proj,
			Map<String, Object> generalMap) {
		boolean successfullyAdded = false;
		Users users=new Users();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String time = (String) utilMap.get("currentTime");
		   
	
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(proj);
		
		int userId=0;
		userId = (Integer) generalMap.get("userId");
		users.setId(userId);
		
		Box box = (Box)generalMap.get("box");
		
		*//**
		 * Upload Documents
		 *//*
			String fileName = null;
			String fileExtension = null;
		
			try {
			 
						if(!box.getString("filename").equals("")){
						UploadDocuments uploadDocuments = new UploadDocuments();
						StringTokenizer strToken = new StringTokenizer(box
								.getString("filename"), ".");

						fileName = strToken.nextToken();
						fileExtension = strToken.nextToken();
						
						
						uploadDocuments.setFileExtension(fileExtension);
						uploadDocuments.setFileName(fileName);

				
						uploadDocuments.setLastChgTime(time);
						uploadDocuments.setLastChgBy(users);
						uploadDocuments.setLastChgDate(new Date());
						uploadDocuments.setStatus("y");
						uploadDocuments.setAssetDetails(proj);
						uploadDocuments.setUploadDate(new Date());
						uploadDocuments.setLastChgBy(users);
						hbt.save(uploadDocuments);

						
					}
		 
	            }
			catch (Exception e) {
				e.printStackTrace();
		
			}
	
		successfullyAdded = true;
		return successfullyAdded;
	}*/
	@Override
	public Map<String, Object> checkForExistingAssetDetail(
			Map<String, Object> generalMap) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List duplicateAssetNameList = new ArrayList();
		String assetName="";
		Criteria crit = null;

		if (generalMap.get("assetName") != null) {
			assetName = (String) generalMap.get("assetName");
		}
		
		System.out.println(assetName);
		crit = session.createCriteria(ProjAssetDetails.class)
				.add(Restrictions.eq("AssetName",assetName));
				

		
		duplicateAssetNameList = crit.list();
		map.put("duplicateAssetNameList", duplicateAssetNameList);
		System.out.println(duplicateAssetNameList.size());
		return map;
}
	@Override
	public Map<String, Object> checkForExistingAssetDetailId(
			Map<String, Object> generalMap) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List duplicateAssetNameList = new ArrayList();
		String assetName="";
		int assetDetailsId=0;
		Criteria crit = null;

		if (generalMap.get("assetName") != null) {
			assetName = (String) generalMap.get("assetName");
		}
		if (generalMap.get("assetDetailsId") != null) {
			assetDetailsId = (Integer) generalMap.get("assetDetailsId");
		}
		
		
		System.out.println(assetName);
		crit = session.createCriteria(ProjAssetDetails.class).add(Restrictions.ne("Id",assetDetailsId))
				.add(Restrictions.eq("AssetName",assetName));
				

		
		duplicateAssetNameList = crit.list();
		map.put("duplicateAssetNameList", duplicateAssetNameList);
		System.out.println(duplicateAssetNameList.size());
		return map;
}

	
	@Override
	public boolean editAssetDetails(int assetDetailsId,Map<String, Object> generalMap) {
		boolean successfullyAdded = false;
		Users users=new Users();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String time = (String) utilMap.get("currentTime");
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		
		  int centreId=0;
		  int assestCategoryId=0;
		  BigDecimal landMeasurementh=null;
		  BigDecimal landMeasurementw=null;
		  String assetName="";
		  String machineName="";
		  int uomLandMeasurementId=0;
		  BigDecimal landExtent=null;
		  String addressDescription="";
		  String surveyNo="";
		  int uomLandExtentId=0;
		  Date dateOfPossession=null;
		  Date completionDate=null;
		  Date dateOfRegistration=null;
		  String leasePeriodFreehold="";
		  int leasePeriod=0;
		  BigDecimal registrationAndOtherCharges=null;
		  BigDecimal totalCost=null;
		  BigDecimal presentBookValue=null;
		  BigDecimal cost=null;
		  int statusId=0;
		  String remarks="";
		String purchaserName="";
		  statusId = (Integer) generalMap.get("statusId");
		  remarks = (String) generalMap.get("remarks");
		  cost = (BigDecimal) generalMap.get("cost");
		  presentBookValue = (BigDecimal) generalMap.get("presentBookValue");
		  totalCost = (BigDecimal) generalMap.get("totalCost");
		  registrationAndOtherCharges = (BigDecimal) generalMap.get("registrationAndOtherCharges");
		  leasePeriodFreehold = (String) generalMap.get("leasePeriodFreehold");
			leasePeriod = (Integer) generalMap.get("leasePeriod");
			dateOfRegistration = (Date) generalMap.get("dateOfRegistration");
			completionDate = (Date) generalMap.get("completionDate");
			dateOfPossession = (Date) generalMap.get("dateOfPossession");
			uomLandExtentId = (Integer) generalMap.get("uomLandExtentId");
			
			uomLandMeasurementId = (Integer) generalMap.get("uomLandMeasurementId");
			landExtent = (BigDecimal) generalMap.get("landExtent");
			addressDescription = (String) generalMap.get("addressDescription");
			
			surveyNo = (String) generalMap.get("surveyNo");
			assetName = (String) generalMap.get("assetName");
			machineName = (String) generalMap.get("machineName");
			
			BigDecimal processingCapacity=null;
			processingCapacity= (BigDecimal) generalMap.get("processingCapacity");
			int capacityUom=0;
			capacityUom=(Integer) generalMap.get("capacityUom");
			
			
			int supplierId=0;
			supplierId=(Integer) generalMap.get("supplierId");
			
			String machineMake="";
			String machineModel="";
			machineMake=(String) generalMap.get("machineMake");
			machineModel=(String) generalMap.get("machineModel");
			
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			landMeasurementh=(BigDecimal) generalMap.get("landMeasurementh");
			landMeasurementw=(BigDecimal) generalMap.get("landMeasurementw");
			centreId=(Integer) generalMap.get("centreId");
			assestCategoryId=(Integer) generalMap.get("assestCategoryId");
			purchaserName=(String) generalMap.get("purchaserName");
			
			int userId=0;
			userId = (Integer) generalMap.get("userId");
		   
		ProjAssetDetails proj = (ProjAssetDetails) getHibernateTemplate().get(
				ProjAssetDetails.class, assetDetailsId);

		proj.setId(assetDetailsId);
		
		proj.setPurchaserName(purchaserName);
		if(centreId !=0){
			MasHospital l=new MasHospital();
			l.setId(centreId);
			proj.setCentre(l);
			}
	  
	  if(assestCategoryId !=0){
			MasAssetCategory asset=new MasAssetCategory();
			asset.setId(assestCategoryId);
			proj.setAsset(asset);
			}
	  
	  
	  proj.setProcessingCapacity(processingCapacity);
	  proj.setMachineMake(machineMake);
	  proj.setMachineModel(machineModel);
	  if(capacityUom !=0)
	  {
		 MasUnitOfMeasurement a =new MasUnitOfMeasurement();
	  a.setId(capacityUom);
	  proj.setCapacityUom(a);
	  }
	  
	  if(supplierId !=0)
	  {
		 MasStoreSupplier s =new MasStoreSupplier();
	  s.setId(supplierId);
	  proj.setSupplier(s);
	  }
	/*  if(machineName!="")
	  {
	  
	  }else{
		  
	  }*/
	  proj.setAssetName(machineName);
	  proj.setAssetName(assetName);
	  
	  proj.setAddress(addressDescription);
	  proj.setPlotSurveyNo(surveyNo);
	  proj.setLeaseFreshhold(leasePeriodFreehold);
	  proj.setLeasePeriod(leasePeriod);
	  proj.setCompletionDate(completionDate);
	  proj.setLandMeasurementh(landMeasurementh);
	  proj.setLandMeasurementw(landMeasurementw);
	  
	  if(uomLandMeasurementId !=0)
	  {MasUnitOfMeasurement l =new MasUnitOfMeasurement();
	  l.setId(uomLandMeasurementId);
	  proj.setUom(l);
	  }
	  proj.setLandExtend(landExtent); 
	  
	  if(uomLandExtentId !=0)
	  {MasUnitOfMeasurement l =new MasUnitOfMeasurement();
	  l.setId(uomLandExtentId);
	  proj.setUomA(l);
	  }
	  proj.setRegistrationDate(dateOfRegistration);
	  proj.setPresentBookValue(presentBookValue);
	  proj.setPossessionDate(dateOfPossession);
	  proj.setLandCost(cost);
	  proj.setLotalLandCost(totalCost);
	  proj.setRegistrationOtherCharges(registrationAndOtherCharges);
	  
   
 
   if(statusId !=0){
		MasAssetStatus a=new MasAssetStatus();
		a.setId(statusId);
		  proj.setStatus(a);
		}
   
   if(userId !=0){
		Users userss=new Users();
		userss.setId(userId);
		proj.setLastChgBy(userss);
   }
   proj.setRemarks(remarks);
   proj.setLastChgDate(currentDate);
   proj.setLastChgTime(currentTime);
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(proj);
		
		
		userId = (Integer) generalMap.get("userId");
		users.setId(userId);
		
Box box = (Box)generalMap.get("box");
		
		/**
		 * Upload Documents
		 */
			String fileName = null;
			String fileExtension = null;
		
			try {
			 
						if(!box.getString("filename").equals("")){
							
							if(box.getInt("uploadId")!=0){
								UploadDocuments uploadDocuments = (UploadDocuments)hbt.load(UploadDocuments.class, box.getInt("uploadId"));
								hbt.delete(uploadDocuments);
							}
						UploadDocuments uploadDocuments = new UploadDocuments();
						StringTokenizer strToken = new StringTokenizer(box
								.getString("filename"), ".");

						fileName = strToken.nextToken();
						fileExtension = strToken.nextToken();
						
						
						uploadDocuments.setFileExtension(fileExtension);
						uploadDocuments.setFileName(fileName);

				
						uploadDocuments.setLastChgTime(time);
						uploadDocuments.setLastChgBy(users);
						uploadDocuments.setLastChgDate(new Date());
						uploadDocuments.setStatus("y");
						uploadDocuments.setAssetDetails(proj);
						uploadDocuments.setUploadDate(new Date());
						uploadDocuments.setLastChgBy(users);
						hbt.save(uploadDocuments);

						
					}
		 
	            }
			catch (Exception e) {
				e.printStackTrace();
		
			}
	
		
		successfullyAdded = true;
		return successfullyAdded;
	}
	@Override
	public Map<String, Object> checkForExistingMastersId(
			Map<String, Object> generalMap) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List existingItemCodeList = new ArrayList();
		String pvms="";
		int id=0;
		Criteria crit = null;

		if (generalMap.get("pvms") != null) {
			pvms = (String) generalMap.get("pvms");
		}
		if (generalMap.get("id") != null) {
			id = (Integer) generalMap.get("id");
		}
		
		
	
		crit = session.createCriteria(MasStoreItem.class).add(Restrictions.eq("Id",id))
				.add(Restrictions.eq("PvmsNo",pvms));
				

		
		existingItemCodeList = crit.list();
		map.put("existingItemCodeList", existingItemCodeList);
		System.out.println(existingItemCodeList.size());
		return map;
}




	
	//---------------------- End of Method By Mansi on 31 July 2013----------
	

	public Map<String, Object> getSupplierList(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreSupplier> sList = new ArrayList<MasStoreSupplier>();
		Session session = (Session) getSession();
		
		session = (Session) getSession();
		int supplier = 0;
		try {
			
			if(dataMap.get("supplier") != null ){
				supplier = (Integer)dataMap.get("supplier");
			}
			sList = session.createCriteria(MasStoreSupplier.class)
						.add(Restrictions.eq("Id",supplier))
						.add(Restrictions.eq("Status", "y")).list();



			

		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("sList", sList);
		return map;
	}

	@Override
	public Map showBlock() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasBlock> searchBlockList = new ArrayList<MasBlock>();
		List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		List<MasDistrict> gridDistrictList = new ArrayList<MasDistrict>();
		Session session = (Session)getSession();
		
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int karnatkaStateId = 0;
		
		
		karnatkaStateId = Integer.parseInt(properties.getProperty("karnatkaStateId"));
			
		searchBlockList = session.createCriteria(MasBlock.class).addOrder(Order.desc("District")).list();
		gridDistrictList = session.createCriteria(MasDistrict.class).createAlias("State", "st").add(Restrictions.eq("st.Id", karnatkaStateId)).add(Restrictions.eq("Status", "y")).list();
		districtList = session.createCriteria(MasDistrict.class).createAlias("State", "st").add(Restrictions.eq("st.Id", karnatkaStateId)).add(Restrictions.eq("Status", "y")).addOrder(Order.desc("DistrictName")).list();
		map.put("searchBlockList", searchBlockList);
		map.put("districtList", districtList);
		map.put("gridDistrictList", gridDistrictList);
		return map;
	}
	@Override
	public boolean addBlock(MasBlock masBlock) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masBlock);
		successfullyAdded = true;
		return successfullyAdded;
	}
	@Override
	public boolean editBlock(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int districtId = 0;
		String blockName = "";
		String blockNameKann = ""; 
		@SuppressWarnings("unused")
		String blockCode = "";
		int blockId = 0;
		Integer userId= 0;
		blockId = (Integer) generalMap.get("id");
		blockCode = (String) generalMap.get("blockCode");
		blockName = (String) generalMap.get("name");
		blockNameKann = (String) generalMap.get("blockNameKann");
		districtId = (Integer) generalMap.get("districtId");
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasBlock masBlock = (MasBlock) getHibernateTemplate().get(
				MasBlock.class, blockId);

		masBlock.setId(blockId);
		masBlock.setBlockName(blockName);
		masBlock.setBlockNameKann(blockNameKann);

		   if(districtId != 0){
			   MasDistrict district = new MasDistrict();
			   district.setId(districtId);
			   masBlock.setDistrict(district);
			   }

		Users user = new Users();
		user.setId(userId);
		masBlock.setLastChgBy(user);
		
		masBlock.setLastChgDate(currentDate);
		masBlock.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masBlock);
		dataUpdated = true;
		return dataUpdated;
	}
	@Override
	public Map<String, Object> searchBlock(String blockCode, String blockName) {
		List<MasBlock> searchBlockList = new ArrayList<MasBlock>();
		List districtList = null;
		Map<String, Object> blockFieldsMap = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List gridDistrictList = null;
		try {
			if ((blockName != null) || (blockCode == null)) {
				searchBlockList = session.createCriteria(MasBlock.class).add(Restrictions.like("BlockName", "%"+blockName+"%").ignoreCase()).addOrder(Order.asc("BlockName")).list();
			} else {
				searchBlockList = session.createCriteria(MasBlock.class).add(Restrictions.like("BlockCode", "%"+blockCode+"%").ignoreCase()).addOrder(Order.asc("BlockCode")).list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		districtList = session.createCriteria(MasDistrict.class).add(Restrictions.eq("Status", "y")).list();
		gridDistrictList = session.createCriteria(MasDistrict.class).list();
		blockFieldsMap.put("gridDistrictList", gridDistrictList);
		blockFieldsMap.put("searchBlockList", searchBlockList);
		blockFieldsMap.put("districtList", districtList);
		return blockFieldsMap;
	}
	@Override
	public boolean deleteBlock(int blockId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		Session session = (Session)getSession();
		int userId = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasBlock masBlock = new MasBlock();
		masBlock = (MasBlock) getHibernateTemplate().get(
				MasBlock.class, blockId);
		@SuppressWarnings("unused")
		Integer districtId = masBlock.getDistrict().getId();
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			
			List disrictList = session.createCriteria(MasDistrict.class).add(Restrictions.eq("Id", districtId)).add(Restrictions.eq("Status", "y")).list();
			
			if (flag.equals("InActivate")) {
				masBlock.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masBlock.setStatus("y");
				dataDeleted = false;
			}
		}
		Users user = new Users();
		user.setId(userId);
		masBlock.setLastChgBy(user);
		
		masBlock.setLastChgDate(currentDate);
		masBlock.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masBlock);
		return dataDeleted;
	}
	@Override
	public Map showVillage(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasVillage> searchVillageList = new ArrayList<MasVillage>();
		List<MasBlock> blockList = new ArrayList<MasBlock>();
		List<MasHospitalDetails> hospList = new ArrayList<MasHospitalDetails>();
		List<MasBlock> gridBlockList = new ArrayList<MasBlock>();
		Session session = (Session)getSession();
		
		int locationId= box.getInt("locationId");
		String unitType = box.getString("unitType");
		Integer[] array_detailsId = new Integer[100];
		
		if(!unitType.equalsIgnoreCase("HO"))
		
		{
			
			hospList = session.createCriteria(MasHospitalDetails.class).add(Restrictions.eq("Hospital.Id", locationId)).list();
			
			int count=0;
			for(MasHospitalDetails list : hospList)
			{
				array_detailsId[count] = list.getDistrict().getId();
				count++;
			}
			
			gridBlockList = session.createCriteria(MasBlock.class).add(Restrictions.in("District.Id", array_detailsId)).add(Restrictions.eq("Status", "y")).list();
			blockList = session.createCriteria(MasBlock.class).add(Restrictions.in("District.Id", array_detailsId)).add(Restrictions.eq("Status", "y")).addOrder(Order.desc("BlockName")).list();
			
			
			
			searchVillageList = session.createCriteria(MasVillage.class).add(Restrictions.in("Block", blockList)).add(Restrictions.eq("Status", "y")).list();
		}
		else
		{
			gridBlockList = session.createCriteria(MasBlock.class).add(Restrictions.eq("Status", "y")).list();
			blockList = session.createCriteria(MasBlock.class).add(Restrictions.eq("Status", "y")).addOrder(Order.desc("BlockName")).list();
			searchVillageList = session.createCriteria(MasVillage.class).add(Restrictions.eq("Status", "y")).list();
		}
		
		map.put("searchVillageList", searchVillageList);
		map.put("blockList", blockList);
		map.put("gridBlockList", gridBlockList);
		return map;
	}
	/*@Override
	public boolean addVillage(MasVillage masVillage) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masVillage);
		successfullyAdded = true;
		return successfullyAdded;
	}*/
	@Override
	public boolean editVillage(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int blockId = 0;
		String villageName = "";
		String villageNameKann = "";
		@SuppressWarnings("unused")
		String villageCode = "";
		int villageId = 0;
		Integer userId= 0;
		villageId = (Integer) generalMap.get("id");
		villageCode = (String) generalMap.get("villageCode");
		villageName = (String) generalMap.get("name");
		villageNameKann = (String) generalMap.get("villageNameKann");
		blockId = (Integer) generalMap.get("blockId");
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasVillage masVillage = (MasVillage) getHibernateTemplate().get(
				MasVillage.class, villageId);

		masVillage.setId(villageId);
		masVillage.setVillageName(villageName);
		masVillage.setVillageNameKann(villageNameKann);

		   if(blockId != 0){
			   MasBlock block = new MasBlock();
			   block.setId(blockId);
			   masVillage.setBlock(block);
			   }

		Users user = new Users();
		user.setId(userId);
		masVillage.setLastChgBy(user);
		
		masVillage.setLastChgDate(currentDate);
		masVillage.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masVillage);
		dataUpdated = true;
		return dataUpdated;
	}
	@Override
	public Map<String, Object> searchVillage(String villageCode,
			String villageName,Box box) {
		List<MasVillage> searchVillageList = new ArrayList<MasVillage>();
		List<MasHospitalDetails> hospList = new ArrayList<MasHospitalDetails>();
		List blockList = null;
		List gridBlockList = null;
		Map<String, Object> villageFieldsMap = new HashMap<String, Object>();
		Session session = (Session)getSession();
	
		int locationId= box.getInt("locationId");
		String unitType = box.getString("unitType");
		Integer[] array_detailsId = new Integer[100];
		
		try {
			if ((villageName != null) || (villageCode == null)) {
				searchVillageList = session.createCriteria(MasVillage.class).add(Restrictions.like("VillageName", "%"+villageName+"%").ignoreCase()).addOrder(Order.asc("VillageName")).list();
			} else {
				searchVillageList = session.createCriteria(MasVillage.class).add(Restrictions.like("VillageCode", "%"+villageCode+"%").ignoreCase()).addOrder(Order.asc("VillageCode")).list();
			}
			
			if(!unitType.equalsIgnoreCase("HO")){
				
				hospList = session.createCriteria(MasHospitalDetails.class).add(Restrictions.eq("Hospital.Id", locationId)).list();
				
				int count=0;
				for(MasHospitalDetails list : hospList)
				{
					array_detailsId[count] = list.getDistrict().getId();
					count++;
				}
				
				gridBlockList = session.createCriteria(MasBlock.class).add(Restrictions.in("District.Id", array_detailsId)).add(Restrictions.eq("Status", "y")).list();
				blockList = session.createCriteria(MasBlock.class).add(Restrictions.in("District.Id", array_detailsId)).add(Restrictions.eq("Status", "y")).addOrder(Order.desc("BlockName")).list();
			}
			else
			{
				gridBlockList = session.createCriteria(MasBlock.class).add(Restrictions.eq("Status", "y")).list();
				blockList = session.createCriteria(MasBlock.class).add(Restrictions.eq("Status", "y")).addOrder(Order.desc("BlockName")).list();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		villageFieldsMap.put("gridBlockList", gridBlockList);
		villageFieldsMap.put("searchVillageList", searchVillageList);
		villageFieldsMap.put("blockList", blockList);
		return villageFieldsMap;
	}
	@Override
	public boolean deleteVillage(int villageId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		Session session = (Session)getSession();
		int userId = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasVillage masVillage = new MasVillage();
		masVillage = (MasVillage) getHibernateTemplate().get(
				MasVillage.class, villageId);
		@SuppressWarnings("unused")
		Integer blockId = masVillage.getBlock().getId();
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			
			List blockList = session.createCriteria(MasBlock.class).add(Restrictions.eq("Id", blockId)).add(Restrictions.eq("Status", "y")).list();
			
			if (flag.equals("InActivate")) {
				masVillage.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masVillage.setStatus("y");
				dataDeleted = false;
			}
		}
		Users user = new Users();
		user.setId(userId);
		masVillage.setLastChgBy(user);
		
		masVillage.setLastChgDate(currentDate);
		masVillage.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masVillage);
		return dataDeleted;
	}
	@Override
	public Map<String, Object> getAssetCat(Map<String, Object> dataMap) {	
	int assetCatId=0;
	if(dataMap.get("assetCatId") != null ){
		assetCatId = (Integer)dataMap.get("assetCatId");
	}

	
	Map<String, Object> map = new HashMap<String, Object>();
	List<ProjAssetDetails> projAssetDetailsList = new ArrayList<ProjAssetDetails>();
	Session session = (Session)getSession();
	projAssetDetailsList = session.createCriteria(ProjAssetDetails.class).createAlias("Asset", "a").add(Restrictions.eq("a.Id",assetCatId)).addOrder(Order.desc("AssetName")).list();
	map.put("projAssetDetailsList", projAssetDetailsList);
	return map;
	}
	@Override
	public Map<String, Object> searchAssetDetail(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<ProjAssetDetails> projAssetDetailsList = new ArrayList<ProjAssetDetails>();
		Session session = getSession();
		Criteria crit = null;
		crit = session.createCriteria(ProjAssetDetails.class);
		System.out.println(box.getString("nameId"));
		System.out.println(box.getInt("assetCat"));
		int locationId = box.getInt("locationId");
		if(box.getString("nameId").equals("") && box.getInt("assetCat")!=0){
			crit = crit.createAlias("Asset", "c").add(Restrictions.eq("c.Id", box.getInt("assetCat")));
		}
		else if(!box.getString("nameId").equals("")&& box.getInt("assetCat")==0 ){
			crit = crit.add(Restrictions.like("AssetName", "%"+box.getString("nameId")+"%").ignoreCase());
					}
		else if(!box.getString("nameId").equals("") && box.getInt("assetCat")!=0){
			crit = crit.add(Restrictions.like("AssetName", "%"+box.getString("nameId")+"%").ignoreCase()).createAlias("Asset", "c").add(Restrictions.eq("c.Id", box.getInt("assetCat")));
		}
		
		if(locationId!=1){
			crit = crit.add(Restrictions.eq("Centre.Id", locationId));
		}
		
		projAssetDetailsList = crit.list();
		
		map.put("projAssetDetailsList", projAssetDetailsList);
		List<MasAssetCategory> assetCategoryList = new ArrayList<MasAssetCategory>();
		assetCategoryList = session.createCriteria(MasAssetCategory.class).addOrder(Order.desc("AssetCategoryName")).add(Restrictions.eq("Status", "y")).list();
		map.put("assetCategoryList", assetCategoryList);
		
		List<MasAssetStatus> assetStatusList = new ArrayList<MasAssetStatus>();
		assetStatusList = session.createCriteria(MasAssetStatus.class).addOrder(Order.desc("AssetStatusName")).list();
		map.put("assetStatusList", assetStatusList);
		
		
		List<MasUnitOfMeasurement> uomLandExtentList = new ArrayList<MasUnitOfMeasurement>();
		uomLandExtentList = session.createCriteria(MasUnitOfMeasurement.class).addOrder(Order.desc("UnitOfMeasurementName")).list();
		map.put("uomLandExtentList", uomLandExtentList);
		
		
		List<MasUnitOfMeasurement> uomLandMeasurementList = new ArrayList<MasUnitOfMeasurement>();
		uomLandMeasurementList = session.createCriteria(MasUnitOfMeasurement.class).addOrder(Order.desc("UnitOfMeasurementName")).list();
		map.put("uomLandMeasurementList", uomLandMeasurementList);
		
		
		List<MasUnitOfMeasurement> capacityUomList = new ArrayList<MasUnitOfMeasurement>();
		capacityUomList = session.createCriteria(MasUnitOfMeasurement.class).addOrder(Order.desc("UnitOfMeasurementName")).list();
		map.put("capacityUomList", capacityUomList);
		

		List<MasStoreSupplier> storeSupplierList = new ArrayList<MasStoreSupplier>();
		storeSupplierList = session.createCriteria(MasStoreSupplier.class).addOrder(Order.desc("SupplierName")).list();
		map.put("storeSupplierList", storeSupplierList);
		
		
		
		List<MasHospital> centreList = new ArrayList<MasHospital>();
		centreList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).addOrder(Order.desc("HospitalName")).list();
		map.put("centreList", centreList);
		
		List<MasHospital> gridCentreHList = new ArrayList<MasHospital>();
		gridCentreHList = session.createCriteria(MasHospital.class).list();
		map.put("gridCentreHList", gridCentreHList);
		
		map.put("assetCatMap", box.getInt("assetCat"));
		return map;
}

	@Override
	public Map<String, Object> getSurveyNo(Map<String, Object> dataMap) {
		
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		session = (Session) getSession();
		String surveyNo = "";
		int item_id = 0;
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		int year = Integer.parseInt(date.substring(6));
		List objectList = new ArrayList();
		surveyNo = "" + dataMap.get("surveyNo");
		try {
			// String qry="select
			// mas.item_id,mas.pvms_no,mas.nomenclature,mas.strength,con.item_unit_name
			// from mas_store_item mas inner join mas_store_item_conversion con
			// on mas.item_conversion_id = con.item_conversion_id ";
			String qry = "select count(*) from mas_grower_details mas where mas.survey_no='"
				+ surveyNo + "'";
			//System.out.println(qry);
			objectList = (List) session.createSQLQuery(qry).list();
			int val =((BigInteger)objectList.get(0)).intValue();
			if(val>0)
				map.put("status", "yes");
			else 
				map.put("status", "no");
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		//map.put("objectList", objectList);
		return map;

	}

	@Override
	public Map<String, Object> openGrowerHistoryPopUp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<ProdPlanGrowerDetails> prodPlanGrowerDetailsList = new ArrayList<ProdPlanGrowerDetails>();
		Session session = (Session) getSession();
		
		prodPlanGrowerDetailsList = session.createCriteria(ProdPlanGrowerDetails.class).add(Restrictions.eq("Grower.Id", box.getInt("growerId"))).list();
		
		
		map.put("prodPlanGrowerDetailsList", prodPlanGrowerDetailsList);
		
		
		return map;
	}
	
	
	
	// ------------------------------------Religion---------------------------------------------------------------------

		@SuppressWarnings("unchecked")
		public Map<String, Object> showReligionJsp() {
			Map<String, Object> map = new HashMap<String, Object>();
			List<MasReligion> searchReligionList = new ArrayList<MasReligion>();
			searchReligionList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasReligion ");
			map.put("searchReligionList", searchReligionList);
			return map;
		}

		@SuppressWarnings("unchecked")
		public Map<String, Object> searchReligion(String religionCode,
				String religionName) {
			List<MasReligion> searchReligionList = new ArrayList<MasReligion>();
			Map<String, Object> religionFieldsMap = new HashMap<String, Object>();
			try {
				if ((religionName != null) || (religionCode == null)) {
					searchReligionList = getHibernateTemplate().find(
							"from jkt.hms.masters.business.MasReligion mr where mr.ReligionName like '"
									+ religionName + "%' order by mr.ReligionName");
				} else {
					searchReligionList = getHibernateTemplate().find(
							"from jkt.hms.masters.business.MasReligion mr where mr.ReligionCode like '"
									+ religionCode + "%' order by mr.ReligionCode");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			religionFieldsMap.put("searchReligionList", searchReligionList);
			return religionFieldsMap;
		}

		public boolean addReligion(MasReligion masReligion) {
			boolean successfullyAdded = false;
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(masReligion);
			hbt.flush();
			hbt.refresh
			(masReligion);
			successfullyAdded = true;
			return successfullyAdded;
		}

		public boolean deleteReligion(int religionId, Map<String, Object> generalMap) {
			boolean dataDeleted = false;
			String changedBy = "";
			Date currentDate = new Date();
			String currentTime = "";
			currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");
			MasReligion masReligion = new MasReligion();
			masReligion = (MasReligion) getHibernateTemplate().get(
					MasReligion.class, religionId);
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			if (generalMap.get("flag") != null) {
				String flag = (String) generalMap.get("flag");
				if (flag.equals("InActivate")) {
					masReligion.setStatus("N");
					dataDeleted = true;
				} else if (flag.equals("Activate")) {
					masReligion.setStatus("Y");
					dataDeleted = false;
				}
			}
		//	masReligion.setLastChgBy(changedBy);
			masReligion.setLastChgDate(currentDate);
			masReligion.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masReligion);
			return dataDeleted;
		}

		public boolean editReligionToDatabase(Map<String, Object> generalMap) {
			boolean dataUpdated = false;
			Date currentDate = new Date();
			String currentTime = "";
			currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");
			String religionName = "";
			@SuppressWarnings("unused")
			String religionCode = "";
			int religionId = 0;
			String changedBy = "";
			religionId = (Integer) generalMap.get("id");
			religionCode = (String) generalMap.get("religionCode");
			religionName = (String) generalMap.get("name");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			MasReligion masReligion = (MasReligion) getHibernateTemplate().get(
					MasReligion.class, religionId);
			masReligion.setId(religionId);
			masReligion.setReligionName(religionName);
			masReligion.setLastChgDate(currentDate);
			masReligion.setLastChgTime(currentTime);
			masReligion.setStatus("Y");
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masReligion);
			dataUpdated = true;
			return dataUpdated;
		}

		// ------------------------------------Marital Status
		// ---------------------------------------------------

		@SuppressWarnings("unchecked")
		public Map<String, Object> showMaritalStatusJsp() {
			Map<String, Object> map = new HashMap<String, Object>();
			List<MasMaritalStatus> searchMaritalStatusList = new ArrayList<MasMaritalStatus>();
			searchMaritalStatusList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasMaritalStatus");
			map.put("searchMaritalStatusList", searchMaritalStatusList);
			return map;
		}

		@SuppressWarnings("unchecked")
		public Map<String, Object> searchMaritalStatus(String maritalStatusCode,
				String maritalStatusName) {
			List<MasMaritalStatus> searchMaritalStatusList = new ArrayList<MasMaritalStatus>();
			Map<String, Object> maritalStatusFieldsMap = new HashMap<String, Object>();
			try {
				if ((maritalStatusName != null) || (maritalStatusCode == null)) {
					searchMaritalStatusList = getHibernateTemplate()
							.find("from jkt.hms.masters.business.MasMaritalStatus sc where sc.MaritalStatusName like '"
									+ maritalStatusName
									+ "%' order by sc.MaritalStatusName");
				} else {
					searchMaritalStatusList = getHibernateTemplate()
							.find("from jkt.hms.masters.business.MasMaritalStatus sc where sc.MaritalStatusCode like '"
									+ maritalStatusCode
									+ "%' order by sc.MaritalStatusCode");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			maritalStatusFieldsMap.put("searchMaritalStatusList",
					searchMaritalStatusList);
			return maritalStatusFieldsMap;
		}
	/*
	 * 
		public boolean addTitle(MasTitle masTitle) {

			boolean successfullyAdded = false;
			Transaction tnx=null;
			Session session=(Session) getSession();
			try{
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			tnx=session.beginTransaction();
			
			hbt.save(masTitle);
			tnx.commit();
			session.flush();
			successfullyAdded = true;
			}catch(Exception e){
				tnx.rollback();
				e.printStackTrace();
				
			}
			return successfullyAdded;
		}
	 * */
		public boolean addMaritalStatus(MasMaritalStatus masMaritalStatus) {
			boolean successfullyAdded = false;
			Transaction tnx=null;
			Session session=(Session) getSession();
			try{
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			tnx=session.beginTransaction();
			
			hbt.save(masMaritalStatus);
			tnx.commit();
			session.flush();
			successfullyAdded = true;
			}catch(Exception e){
				tnx.rollback();
				e.printStackTrace();
			}
			return successfullyAdded;
		}

		public boolean deleteMaritalStatus(int maritalStatusId,
				Map<String, Object> generalMap) {
			boolean dataDeleted = false;
			String changedBy = "";
			Date currentDate = new Date();
			String currentTime = "";
			currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");
			MasMaritalStatus masMaritalStatus = new MasMaritalStatus();
			masMaritalStatus = (MasMaritalStatus) getHibernateTemplate().get(
					MasMaritalStatus.class, maritalStatusId);
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			if (generalMap.get("flag") != null) {
				String flag = (String) generalMap.get("flag");
				if (flag.equals("InActivate")) {
					masMaritalStatus.setStatus("N");
					dataDeleted = true;
				} else if (flag.equals("Activate")) {
					masMaritalStatus.setStatus("Y");
					dataDeleted = false;
				}
			}
			//masMaritalStatus.setLastChgBy(changedBy);
			masMaritalStatus.setLastChgDate(currentDate);
			masMaritalStatus.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masMaritalStatus);
			return dataDeleted;
		}

		public boolean editMaritalStatusToDatabase(Map<String, Object> generalMap) {
			boolean dataUpdated = false;
			Date currentDate = new Date();
			String currentTime = "";
			currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");
			String maritalStatusName = "";
			@SuppressWarnings("unused")
			String maritalStatusCode = "";
			int maritalStatusId = 0;
			String changedBy = "";
			maritalStatusId = (Integer) generalMap.get("id");
			maritalStatusCode = (String) generalMap.get("maritalStatusCode");
			maritalStatusName = (String) generalMap.get("name");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			MasMaritalStatus masMaritalStatus = (MasMaritalStatus) getHibernateTemplate()
					.get(MasMaritalStatus.class, maritalStatusId);
			masMaritalStatus.setId(maritalStatusId);
			masMaritalStatus.setMaritalStatusName(maritalStatusName);
			//masMaritalStatus.setLastChgBy(changedBy);
			masMaritalStatus.setLastChgDate(currentDate);
			masMaritalStatus.setLastChgTime(currentTime);
			masMaritalStatus.setStatus("Y");
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masMaritalStatus);
			dataUpdated = true;
			return dataUpdated;
		}
		
		@SuppressWarnings("unchecked")
		public Map<String, Object> showRelationJsp() {
			Map<String, Object> map = new HashMap<String, Object>();
			List<MasRelation> searchRelationList = new ArrayList<MasRelation>();
			searchRelationList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasRelation ");
			map.put("searchRelationList", searchRelationList);
			return map;
		}
		@Override
		public boolean addReligion(MasRelation masRelation) {
			// TODO Auto-generated method stub
			boolean successfullyAdded = false;
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(masRelation);
			successfullyAdded = true;
			return successfullyAdded;
		}
		@Override
		public Map<String, Object> searchRelation(String relationCode,
				String relationName) {
			// TODO Auto-generated method stub
			List<MasRelation> searchRelationList = new ArrayList<MasRelation>();
			Map<String, Object> relationFieldsMap = new HashMap<String, Object>();
			try {
				if ((relationCode != null) || (relationName == null)) {
					searchRelationList = getHibernateTemplate().find(
							"from jkt.hms.masters.business.MasRelation mr where mr.RelationCode like '"
									+ relationCode + "%' order by mr.RelationName");
				} else {
					searchRelationList = getHibernateTemplate().find(
							"from jkt.hms.masters.business.MasRelation mr where mr.RelationName like '"
									+ relationName + "%' order by mr.RelationName");
				}
			} catch (Exception e) {
				//System.out.println("Ds excp in searchRelation  " + e);
			}
			relationFieldsMap.put("searchRelationList", searchRelationList);
			return relationFieldsMap;
		}
		
		
		public boolean editRelationToDatabase(Map<String, Object> generalMap) {
			boolean dataUpdated = false;
			Date currentDate = new Date();
			String currentTime = "";
			currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");
			String relationName = "";
			@SuppressWarnings("unused")
			String relationCode = "";
			int relationId = 0;
			String changedBy = "";
			
			relationId = (Integer) generalMap.get("id");
			relationCode = (String) generalMap.get("relationCode");
			relationName = (String) generalMap.get("name");
			
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			MasRelation masRelation = (MasRelation) getHibernateTemplate().get(
					MasRelation.class, relationId);

			masRelation.setId(relationId);
			masRelation.setRelationName(relationName);
			masRelation.setLastChgBy(changedBy);
			masRelation.setLastChgDate(currentDate);
			masRelation.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masRelation);
			dataUpdated = true;
			return dataUpdated;
		}
		@Override
		public boolean deleteRelation(int relationId,
				Map<String, Object> generalMap) {
			// TODO Auto-generated method stub
			boolean dataDeleted = false;
			String changedBy = "";
			Date currentDate = new Date();
			String currentTime = "";
			currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");
			MasRelation masRelation = new MasRelation();
			masRelation = (MasRelation) getHibernateTemplate().get(
					MasRelation.class, relationId);
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			if (generalMap.get("flag") != null) {
				String flag = (String) generalMap.get("flag");
				if (flag.equals("InActivate")) {
					masRelation.setStatus("n");
					dataDeleted = true;
				} else if (flag.equals("Activate")) {
					masRelation.setStatus("y");
					dataDeleted = false;
				}
			}
			masRelation.setLastChgBy(changedBy);
			masRelation.setLastChgDate(currentDate);
			masRelation.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masRelation);
			return dataDeleted;
		}

		//-------------------- ** Rsk Master ** -------------------------------
		
	/*	@Override
		public boolean addRsk(MasRsk masRsk) {
			boolean successfullyAdded = false;
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(masRsk);
			successfullyAdded = true;
			return successfullyAdded;
		}*/
		@Override
		public boolean deleteRsk(int rskId, Map<String, Object> generalMap) {
			boolean dataDeleted = false;
			int userId = 0;
			Date currentDate = new Date();
			String currentTime = "";
			currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");
			MasRsk masRsk = new MasRsk();
			masRsk = (MasRsk) getHibernateTemplate().load(MasRsk.class, rskId);
			userId = (Integer) generalMap.get("userId");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			if (generalMap.get("flag") != null) {
				String flag = (String) generalMap.get("flag");
				if (flag.equals("InActivate")) {
					masRsk.setStatus("n");
					dataDeleted = true;
				} else if (flag.equals("Activate")) {
					masRsk.setStatus("y");
					dataDeleted = false;
				}
			}
			Users user = new Users();
			user.setId(userId);
			masRsk.setLastChgBy(user);
			
			masRsk.setLastChgDate(currentDate);
			masRsk.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masRsk);
			return dataDeleted;
		}
		@Override
		public Map<String, Object> searchRsk(String rskName) {
			List<MasRsk> searchRskList = new ArrayList<MasRsk>();
			Map<String, Object> rskFieldsMap = new HashMap<String, Object>();
			List<MasDistrict> districtList = new ArrayList<MasDistrict>();
			List<MasDistrict> gridDistrictList = new ArrayList<MasDistrict>();	
			List<MasBlock> talukList = new ArrayList<MasBlock>();
			List<MasBlock> gridTalukList = new ArrayList<MasBlock>();
			
			Session session = (Session) getSession();
			Properties properties = new Properties();
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("adt.properties");
			try {
				properties.load(resourcePath.openStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int karnatkaStateId = 0;
			
			try {
				if ((rskName != null)) {
					searchRskList = session.createCriteria(MasRsk.class).add(Restrictions.like("RskName","%"+rskName+"%").ignoreCase()).addOrder(Order.asc("RskName")).list();
				}
			
		
			
					karnatkaStateId = Integer.parseInt(properties.getProperty("karnatkaStateId"));
		

				gridDistrictList  = session.createCriteria(MasDistrict.class)
						.createAlias("State", "g")
						.add(Restrictions.eq("g.Id",karnatkaStateId))
						.addOrder(Order.desc("DistrictName")).list();

				
				districtList = session.createCriteria(MasDistrict.class)
						.createAlias("State", "g")
						.add(Restrictions.eq("g.Id",karnatkaStateId))
						.add(Restrictions.eq("Status", "y")).addOrder(Order.desc("DistrictName")).list();

				gridTalukList = session.createCriteria(MasBlock.class).list();
				talukList = session.createCriteria(MasBlock.class).add(Restrictions.eq("Status", "y")).addOrder(Order.desc("BlockName")).list();

				

			} catch (Exception e) {
				e.printStackTrace();
			}

			
			rskFieldsMap.put("searchRskList", searchRskList);
			rskFieldsMap.put("districtList", districtList);
			rskFieldsMap.put("gridDistrictList", gridDistrictList);
			rskFieldsMap.put("talukList", talukList);
			rskFieldsMap.put("gridTalukList", gridTalukList);
			return rskFieldsMap;
		}
		@Override
		public Map<String, Object> showRskJsp() {
			Map<String, Object> map = new HashMap<String, Object>();
			List<MasRsk> searchRskList = new ArrayList<MasRsk>();
			Session session = (Session) getSession();
			List<MasDistrict> districtList = new ArrayList<MasDistrict>();
			List<MasDistrict> gridDistrictList = new ArrayList<MasDistrict>();	
			List<MasBlock> talukList = new ArrayList<MasBlock>();
			List<MasBlock> gridTalukList = new ArrayList<MasBlock>();
			
			
			Properties properties = new Properties();
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("adt.properties");
			try {
				properties.load(resourcePath.openStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int karnatkaStateId = 0;
			karnatkaStateId = Integer.parseInt(properties.getProperty("karnatkaStateId"));
			
			try {
				
		
				

				searchRskList =session.createCriteria(MasRsk.class).list(); 
				
				gridDistrictList  = session.createCriteria(MasDistrict.class)
						.createAlias("State", "g")
						.add(Restrictions.eq("g.Id",karnatkaStateId))
						.addOrder(Order.desc("DistrictName")).list();

				
				districtList = session.createCriteria(MasDistrict.class)
						.createAlias("State", "g")
						.add(Restrictions.eq("g.Id",karnatkaStateId))
						.add(Restrictions.eq("Status", "y")).addOrder(Order.desc("DistrictName")).list();

				gridTalukList = session.createCriteria(MasBlock.class).list();
				talukList = session.createCriteria(MasBlock.class).add(Restrictions.eq("Status", "y")).addOrder(Order.desc("BlockName")).list();

				

			} catch (Exception e) {
				e.printStackTrace();
			}

			map.put("districtList", districtList);
			map.put("searchRskList", searchRskList);
			map.put("districtList", districtList);
			map.put("gridDistrictList", gridDistrictList);
			map.put("talukList", talukList);
			map.put("gridTalukList", gridTalukList);

			return map;
		}
		@Override
		public boolean editRskToDatabase(Map<String, Object> generalMap) {
			boolean dataUpdated = false;
			Date currentDate = new Date();
			String currentTime = "";
			currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
			String rskName = "";
			@SuppressWarnings("unused")
			String rskCode = "";
			int rskId = 0;
			int userId = 0;
			int talukId=0;
			int districtId=0;
			rskId = (Integer) generalMap.get("id");
			rskName = (String) generalMap.get("name");
			userId = (Integer) generalMap.get("userId");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			talukId	= (Integer) generalMap.get("talukId");
			districtId= (Integer) generalMap.get("districtId");
			MasRsk masRsk = (MasRsk) getHibernateTemplate().get(MasRsk.class, rskId);

			masRsk.setId(rskId);
			masRsk.setRskName(rskName);
			Users user = new Users();
			user.setId(userId);
			
			   if(talukId !=0){
					MasBlock masTaluk=new MasBlock();
					masTaluk.setId(talukId);
					masRsk.setBlock(masTaluk);
					}
			   
			   
			   
			   if(districtId !=0){
					MasDistrict masDistrict=new MasDistrict();
					masDistrict.setId(districtId);
					masRsk.setDistrict(masDistrict);
					}
			
			masRsk.setLastChgBy(user);
			masRsk.setLastChgDate(currentDate);
			masRsk.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masRsk);
			dataUpdated = true;
			return dataUpdated;
		}

		@Override
		public Map<String, Object> showUserLocationMappingJsp(Box box) {
			Map<String, Object> map = new HashMap<String, Object>();
			Session session = (Session) getSession();
			List<Users> usersList=new ArrayList<Users>();
			List<MasHospital> locationList =new ArrayList<MasHospital>();
			List<UserLocationMapping> userLocationMappingList = new ArrayList<UserLocationMapping>();
			//List<Object[]> userLocationMappingList = new ArrayList<Object[]>();
			try {
				usersList = session.createCriteria(Users.class).add(Restrictions.eq("Status", "y".toLowerCase()).ignoreCase()).list();

				locationList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y".toLowerCase()).ignoreCase()).list();
				
				userLocationMappingList = session.createCriteria(UserLocationMapping.class).list();
				
				userLocationMappingList = session.createCriteria(UserLocationMapping.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
				
				/*		SQLQuery qry = 	session.createSQLQuery("SELECT u.user_location_mapping_id, u.user_id, uu.user_name,GROUP_CONCAT(CONVERT(hh.hospital_name, CHAR(50))), u.status"
				+ " FROM user_location_mapping u inner join users uu on uu.user_id=u.user_id "
				+ "inner join mas_hospital hh on hh.hospital_id=u.hospital_id GROUP BY uu.user_name");
					
				userLocationMappingList =	qry.list();	*/


				map.put("usersList", usersList);
				map.put("locationList", locationList);
				map.put("userLocationMappingList", userLocationMappingList);
			} catch (Exception e) {
				e.printStackTrace();
			}

			return map;
		}
		@Override
		public Map<String, Object> addUserLocationMapping(
				Map<String, Object> mapForDs) {

			Map<String, Object> map = new HashMap<String, Object>();
			Session session = (Session) getSession();
			
			List<MasHospital> masHospitalList = null;
			Integer hospitalId = (Integer) mapForDs.get("hospitalId");
			int usersId=0;
			ArrayList<Integer> locationIdList = null;
			UserLocationMapping userLocationMapping = new UserLocationMapping();
			Criteria criteria = null;
			int userSessionId = 0;
			Date currentDate = new Date();
			String currentTime = "";
			currentDate = (Date) mapForDs.get("currentDate");
			currentTime = (String) mapForDs.get("currentTime");
			userSessionId = (Integer) mapForDs.get("userSessionId");
			Transaction tx = null;
			try {
				if (mapForDs.get("usersId") != null) {
					
					usersId = (Integer) mapForDs.get("usersId");
					locationIdList = (ArrayList<Integer>) mapForDs.get("locationIdList");

					tx = session.beginTransaction();

					
					Users user = new Users();
					user.setId(usersId);
					Users userSession = new Users();
					userSession.setId(userSessionId);
					masHospitalList = session.createCriteria(MasHospital.class).add(Restrictions.in("Id", locationIdList)).list();
					for (MasHospital masHospital : masHospitalList) {
						userLocationMapping = new UserLocationMapping();
						userLocationMapping.setStatus("y");
						userLocationMapping.setUsers(user);
						userLocationMapping.setHospital(masHospital);
						 
						userLocationMapping.setLastChgBy(userSession);
						userLocationMapping.setLastChgDate(currentDate);
						userLocationMapping.setLastChgTime(currentTime);
						session.save(userLocationMapping);
						session.flush();
					}
					
				
					tx.commit();

					
				}
		

			} catch (Exception e) {
				map.put("message", "Error in adding, Please try again !");
				e.printStackTrace();
			}
		
			return map;
		}
		@Override
		public Map<String, Object> deleteUserLocationMapping(
				Map<String, Object> mapForDs) {
			
			Map<String, Object> map = new HashMap<String, Object>();
			Session session = (Session)getSession();
			
			
			int userLocationMappingId=Integer.parseInt((String)mapForDs.get("userLocationMappingId"));
			UserLocationMapping userLocationMapping = null;
			
			Criteria criteria = null;
			try{
				if(mapForDs.get("userLocationMappingId")!=null) {
				
					userLocationMapping = (UserLocationMapping)session.get(UserLocationMapping.class, userLocationMappingId);
				if(userLocationMapping!=null){
			
				
				session.clear();
				if (mapForDs.get("flag") != null) {
					String flag = (String) mapForDs.get("flag");
					if (flag.equals("InActivate")) {
						userLocationMapping.setStatus("n");
						
					} else if (flag.equals("Activate")) {
						userLocationMapping.setStatus("y");
						
					}
				}
				session.update(userLocationMapping);
				session.flush();
				session.clear();
				}
				
				}
				
				
			}catch(Exception e){
				e.printStackTrace();
				map.put("message", "Error in deleting, Please try again !");
			}
			
		return map;
		}
		@Override
		public Map<String, Object> editUserLocationMapping(Map<String, Object> mapForDs) {

			Map<String, Object> map = new HashMap<String, Object>();
			Session session = (Session) getSession();
			List<UserLocationMapping > userLocationMappingList=null;
			List<MasHospital> masHospitalList = null;
			Integer hospitalId = (Integer) mapForDs.get("hospitalId");
			int usersId=0;
			UserLocationMapping userLocationMapping  =null;
			ArrayList<Integer> locationIdList = null;
			Criteria criteria = null;
			int userLocationMappingId=Integer.parseInt((String)mapForDs.get("userLocationMappingId"));
			int userSessionId = 0;
			Date currentDate = new Date();
			String currentTime = "";
			currentDate = (Date) mapForDs.get("currentDate");
			currentTime = (String) mapForDs.get("currentTime");
			userSessionId = (Integer) mapForDs.get("userSessionId");
			Transaction tx = null;
			try {
				if(mapForDs.get("userLocationMappingId")!=null) {
					
					//UserLocationMapping userLocationMapping = (UserLocationMapping)session.get(UserLocationMapping.class, userLocationMappingId);
					
					try {
						if (mapForDs.get("usersId") != null) {
							
							usersId = (Integer) mapForDs.get("usersId");
							locationIdList = (ArrayList<Integer>) mapForDs.get("locationIdList");

							tx = session.beginTransaction();

						
							userLocationMappingList = session.createCriteria(UserLocationMapping.class).add(Restrictions.eq("Users.Id", usersId)).list();
							for(UserLocationMapping u : userLocationMappingList){
								session.delete(u);
							}
								
							Users user = new Users();
							user.setId(usersId);
							Users userSession = new Users();
							userSession.setId(userSessionId);
							masHospitalList = session.createCriteria(MasHospital.class).add(Restrictions.in("Id", locationIdList)).list();
							for (MasHospital masHospital : masHospitalList) {
								userLocationMapping = new UserLocationMapping();
								userLocationMapping.setStatus("y");
								userLocationMapping.setUsers(user);
								userLocationMapping.setHospital(masHospital);
								 
								userLocationMapping.setLastChgBy(userSession);
								userLocationMapping.setLastChgDate(currentDate);
								userLocationMapping.setLastChgTime(currentTime);
								session.save(userLocationMapping);
								session.flush();
							}
							
						
							tx.commit();

							
						}
				

					} catch (Exception e) {
						map.put("message", "Error in adding, Please try again !");
						e.printStackTrace();
					}
								
				}
			}	catch (Exception e) {
				map.put("message", "Error in adding, Please try again !");
				e.printStackTrace();
			}
				return map;
		
		
		}
		@Override
		public Map<String, Object> getUsersList(Map<String, Object> dataMap) {
			Map<String, Object> map = new HashMap<String, Object>();
			List<Users> usersGetList = new ArrayList<Users>();
			Session session = (Session) getSession();
			
			session = (Session) getSession();
			int usersGetId = 0;
			try {
				
				if(dataMap.get("usersGetId") != null ){
					usersGetId = (Integer)dataMap.get("usersGetId");
				}
				usersGetList = session.createCriteria(Users.class)
							.add(Restrictions.eq("Id",usersGetId))
							//.add(Restrictions.eq("Status", "y"))
							.list();

			} catch (Exception e) {
				e.printStackTrace();
			}

			map.put("usersGetList", usersGetList);
			return map;

	}
		
		
		@SuppressWarnings("unchecked")
		public Map<String, Object> searchUserLocationMapping(int usersSearchId) {
			List<UserLocationMapping> userLocationMappingList = new ArrayList<UserLocationMapping>();
			Map<String, Object> departmentFieldsMap = new HashMap<String, Object>();
			Session session = (Session)getSession();
			List<MasHospital> masHospitalList = null;
			List<Users> usersList=null;
			try {
				if (usersSearchId!=0) {

					userLocationMappingList = session.createCriteria(UserLocationMapping.class).add(Restrictions.eq("Users.Id", usersSearchId)).list();
							
					
				} 
			} catch (Exception e) {
				e.printStackTrace();
			}
			usersList = session
					.createCriteria(Users.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			
			masHospitalList = session
					.createCriteria(MasHospital.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			
			departmentFieldsMap.put("userLocationMappingList", userLocationMappingList);
			departmentFieldsMap.put("locationList", masHospitalList);
			departmentFieldsMap.put("usersList", usersList);
			return departmentFieldsMap;

		}
		@Override
		public Map<String, Object> getMasScheme(Map<String, Object> dataMap) {
			// TODO Auto-generated method stub
			List<MasScheme> masSchemeList = new ArrayList<MasScheme>();
			Map<String, Object> map = new HashMap<String, Object>();
			Session session = (Session)getSession();
			int subsidyId =0;
			
			if(dataMap.get("subsidyId") != null ){
				subsidyId = (Integer)dataMap.get("subsidyId");
				}
			
			masSchemeList = session.createCriteria(MasScheme.class).createAlias("Subsidy", "subsidy")
					.add(Restrictions.eq("subsidy.Id", subsidyId)).add(Restrictions.eq("Status", "y")).list();
			map.put("masSchemeList", masSchemeList);
			return map;
		}
}
