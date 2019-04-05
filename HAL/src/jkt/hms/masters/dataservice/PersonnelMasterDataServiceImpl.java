package jkt.hms.masters.dataservice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import jkt.hms.masters.business.EmpGroups;
import jkt.hms.masters.business.GroupApplication;
import jkt.hms.masters.business.HrEmployeePayElements;
import jkt.hms.masters.business.HrEmployeePayStructure;
import jkt.hms.masters.business.HrMasPayElement;
import jkt.hms.masters.business.HrMasPayroll;
import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasBloodGroup;
import jkt.hms.masters.business.MasCommand;
import jkt.hms.masters.business.MasCostCenter;
import jkt.hms.masters.business.MasCountry;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasDivision;
import jkt.hms.masters.business.MasEmpCategory;
import jkt.hms.masters.business.MasEmpStatus;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasEmployeeDepartment;
import jkt.hms.masters.business.MasEmployeeDependent;
import jkt.hms.masters.business.MasEmployeeType;
import jkt.hms.masters.business.MasFormation;
import jkt.hms.masters.business.MasGrade;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasManufacturer;
import jkt.hms.masters.business.MasMedicalCategory;
import jkt.hms.masters.business.MasOthersCategory;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasRankCategory;
import jkt.hms.masters.business.MasRecordOfficeAddress;
import jkt.hms.masters.business.MasReferralDoctor;
import jkt.hms.masters.business.MasRelation;
import jkt.hms.masters.business.MasServiceStatus;
import jkt.hms.masters.business.MasServiceType;
import jkt.hms.masters.business.MasState;
import jkt.hms.masters.business.MasStation;
import jkt.hms.masters.business.MasStoreBrand;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasTemplate;
import jkt.hms.masters.business.MasTitle;
import jkt.hms.masters.business.MasTrade;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.TemplateApplication;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.masters.business.UploadDocuments;
import jkt.hms.masters.business.UserDepartment;
import jkt.hms.masters.business.UserTemplate;
import jkt.hms.masters.business.UserUsergroupApplication;
import jkt.hms.masters.business.UserUsergroupHospital;
import jkt.hms.masters.business.UsergroupHospital;
import jkt.hms.masters.business.Users;
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

public class PersonnelMasterDataServiceImpl extends HibernateDaoSupport
		implements PersonnelMasterDataService {

	// ---------------------------- Employee Dependent
	// -----------------------------

	public boolean addEmployeeDependent(MasEmployeeDependent masEmployeeDependent,Map<String, Object> userMap) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		List<MasEmployeeDependent> inactiveMEDList = new ArrayList<MasEmployeeDependent>();
		
		//code starts to update inactive employee_dependent_id in referral table
		Session session = (Session) getSession();
		Transaction tx = null;
		 try { 	
			 tx = session.beginTransaction();
			 hbt.save(masEmployeeDependent);
		inactiveMEDList = session.createCriteria(MasEmployeeDependent.class)
				.add(Restrictions.eq("Employee.Id", masEmployeeDependent.getEmployee().getId()))
				.add(Restrictions.eq("Relation.Id", masEmployeeDependent.getRelation().getId()))
				.add(Restrictions.eq("Status","n").ignoreCase()).list();
		
		for(MasEmployeeDependent inactiveMED : inactiveMEDList)
		{
			System.out.println("masEmployeeDependent.getId()"+masEmployeeDependent.getId());
			System.out.println("inactiveMED.getId()"+inactiveMED.getId());
			session.createQuery("update ReferralPatientHeader rph set rph.EmployeeDependent.Id="+masEmployeeDependent.getId()+" where rph.EmployeeDependent.Id="+inactiveMED.getId()).executeUpdate();
		}
		
		//code ends to update inactive employee_dependent_id in referral table
		
		
		try
		{
		String filename = "";
		if(userMap.get("filename")!= null){
			filename =(String) userMap.get("filename");
		}
		String uploadURL = "";
		if(userMap.get("uploadURL")!= null){
			uploadURL =(String) userMap.get("uploadURL");
		}
	
		successfullyAdded = true;
			
			String fileExtension=null;
			 File file=null;
			
				
				 if (filename != null) {
					
					System.out.println(uploadURL+" -- "+filename);
					 file=new File(uploadURL + "/" + filename);
		    		 System.out.println("path>>"+file.getPath());
		    		
		    	     FileInputStream is = new FileInputStream(file);
		    	     long length = file.length();
		    	     ByteBuffer byteBuff=null;
		    	   //  int modLength=length/
		    	     if (length > Integer.MAX_VALUE) {
		            // File is too large
		    	     }
		    	     // Create the byte array to hold the data
		    	     byte[] bytes = new byte[(int)length];
		    	     int offset = 0;
		    	     int numRead = 0;
		    	     while (offset < bytes.length
		    	    		 && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
		    	    	 offset += numRead;
		    	    	
		    	     }
		    
		    	     if (offset < bytes.length) {
		    	    	 throw new IOException("Could not completely read file "+file.getName());
		    	         
		    	     }
		    	     is.close();     
		    	
		    	     
		    	     UploadDocuments document = new UploadDocuments();
		    	     document.setPatientDocument(bytes);
		    	     int indexNo = filename.lastIndexOf("."); 
		    	     String actualfileName = filename.substring(0, indexNo);
		    	     fileExtension = filename.substring(indexNo+1);
		    	     document.setFileName(actualfileName);
		    	     document.setFileExtension(fileExtension);
		    	     Date d= new Date();
		    	     document.setUploadDate(d);
		    	     if(masEmployeeDependent.getId()!=0)
		    	     {
		    	    	 
		    	    	 masEmployeeDependent.setId(masEmployeeDependent.getId());
		    	    	 document.setEmployeeDependent(masEmployeeDependent);
		    	     }
		    	     hbt.save(document);
		    	     hbt.flush();
		    	     hbt.refresh(document);	
			 	}
				    
	    		     successfullyAdded=true;
		    
		    }
		
		 catch (Exception e) {
		    	e.printStackTrace();
		    	
		   
			
		}	
		 hbt.flush();
	     tx.commit();
	     }
			 catch (Exception e) {
			    	e.printStackTrace();
			    	if (tx != null)
						tx.rollback();
			   
				
			}		
		
	
		return successfullyAdded;
		
		
		
	}

	@SuppressWarnings("unchecked")
	public boolean deleteEmployeeDependent(int employeeDependentId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		try {
			MasEmployeeDependent masEmployeeDependent = new MasEmployeeDependent();
			masEmployeeDependent = (MasEmployeeDependent) getHibernateTemplate()
					.load(MasEmployeeDependent.class, employeeDependentId);
			Integer employeecodeId = masEmployeeDependent.getEmployee().getId();
			Integer relationcodeId = masEmployeeDependent.getRelation().getId();
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			if (masEmployeeDependent.getStatus().equals("y")) {
				@SuppressWarnings("unused")
				List employeecodeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasEmployee as employee where employee.Id='"
								+ employeecodeId + "' and employee.Status='y'");
				@SuppressWarnings("unused")
				List relationcodeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasRelation as relation where relation.Id='"
								+ relationcodeId + "' and relation.Status='y'");
				masEmployeeDependent.setStatus("n");
				dataDeleted = true;
			} else {
				masEmployeeDependent.setStatus("y");
				dataDeleted = false;
			}
			masEmployeeDependent.setLastChgBy(changedBy);
			masEmployeeDependent.setLastChgDate(currentDate);
			masEmployeeDependent.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masEmployeeDependent);
		} catch (Exception e) {
			//System.out.println("exc in DS " + e);
		}
		return dataDeleted;
	}

	@SuppressWarnings("unused")
	public boolean editEmployeeDependent(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int employeecodeId = 0;
		int relationcodeId = 0;
		int oldRelationId = 0;
		String employeeDependentName = "";
		String employeeDependentMName = "";
		String employeeDependentLName = "";
		Date dob = new Date();
		String employeeDependentGender = "";
		String employeeDependentAddress = "";
		int employeeDependentcodeId = 0;
		String changedBy = "";
		int bloodGroupId=0;
		employeeDependentcodeId = (Integer) generalMap.get("id");
		relationcodeId = (Integer) generalMap.get("relationcodeId");
		employeeDependentName = (String) generalMap.get("name");
		employeeDependentMName = (String) generalMap.get("employeeDependentMName");
		employeeDependentLName = (String) generalMap.get("employeeDependentLName");
		bloodGroupId = (Integer) generalMap.get("bloodGroupId");
		employeeDependentGender = (String) generalMap
				.get("employeeDependentGender");
		employeeDependentAddress = (String) generalMap
				.get("employeeDependentAddress");
		employeecodeId = (Integer) generalMap.get("employeecodeId");
		int sexId=0;
		if(generalMap.get("sexId")!=null){
			sexId = (Integer) generalMap.get("sexId");
		}
	
		
		dob = (Date) generalMap.get("employeeDependentDOB");

		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		
		Session session = (Session) getSession();
		
		MasEmployeeDependent masEmployeeDependent = (MasEmployeeDependent) getHibernateTemplate()
				.get(MasEmployeeDependent.class, employeeDependentcodeId);

		/*masEmployeeDependent.setId(employeeDependentcodeId);*/
		masEmployeeDependent.setEmployeeDependentFName(employeeDependentName);
		masEmployeeDependent.setEmployeeDependentMName(employeeDependentMName);
		masEmployeeDependent.setEmployeeDependentLName(employeeDependentLName);
		masEmployeeDependent.setDateOfBirth(dob);
		if (sexId != 0) {
			MasAdministrativeSex sex = new MasAdministrativeSex();
			sex.setId(sexId);
			masEmployeeDependent.setGender(sex);
		}
		
		masEmployeeDependent.setAddress(employeeDependentAddress);

		MasEmployee oldMasEmployee = masEmployeeDependent.getEmployee();
		MasEmployee masEmployee = new MasEmployee();
		masEmployee.setId(employeecodeId);
		masEmployeeDependent.setEmployee(masEmployee);
		
		if(generalMap.get("contactNo")!=null){
			masEmployeeDependent.setContactNo((String)generalMap.get("contactNo"));
		}
		MasRelation masRelation = (MasRelation) getHibernateTemplate().get(MasRelation.class, relationcodeId);
	
		oldRelationId = masEmployeeDependent.getRelation().getId();
		MasRelation oldRelation = masEmployeeDependent.getRelation();
		masEmployeeDependent.setRelation(masRelation);
		if(bloodGroupId!=0){
		MasBloodGroup bloodGroup = new MasBloodGroup();
		bloodGroup.setId(bloodGroupId);
		masEmployeeDependent.setBloodGroup(bloodGroup);
		}
		
		
		masEmployeeDependent.setLastChgBy(changedBy);
		masEmployeeDependent.setLastChgDate(currentDate);
		masEmployeeDependent.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masEmployeeDependent);
		
		
		//code starts to update inactive employee_dependent_id in referral table
	    List<MasEmployeeDependent> inactiveMEDList = new ArrayList<MasEmployeeDependent>();
		inactiveMEDList = session.createCriteria(MasEmployeeDependent.class)
				.add(Restrictions.eq("Employee.Id", masEmployeeDependent.getEmployee().getId()))
				.add(Restrictions.eq("Relation.Id", masEmployeeDependent.getRelation().getId()))
				.add(Restrictions.eq("Status","n").ignoreCase()).list();
		
		for(MasEmployeeDependent inactiveMED : inactiveMEDList)
		{
			System.out.println("masEmployeeDependent.getId()"+masEmployeeDependent.getId());
			System.out.println("inactiveMED.getId()"+inactiveMED.getId());
			session.createQuery("update ReferralPatientHeader rph set rph.EmployeeDependent.Id="+masEmployeeDependent.getId()+" where rph.EmployeeDependent.Id="+inactiveMED.getId()).executeUpdate();
		}
		
		//code ends to update inactive employee_dependent_id in referral table
		
		
		
		
		  // code starts to update record in patient table
  	     
  	     List<Patient> patientList= new ArrayList<Patient>();
  	    
  	     patientList = session.createCriteria(Patient.class)
  	    		 .add(Restrictions.eq("ServiceNo", oldMasEmployee.getServiceNo()))
  	    		 .add(Restrictions.eq("Relation.Id",oldRelationId)).list();
  	     System.out.println("patientList"+patientList.size());
  	     if(patientList.size()>0)
  	     {
  	    	     System.out.println("masEmployeeDependent.getRelation().getId()"+masEmployeeDependent.getRelation().getId()+" "+oldRelationId);
  	    	         if(masEmployeeDependent.getRelation().getId()!=oldRelationId)
  	    	         {  	    	        	 
  	    	        	 String oldRelationCode = oldRelation.getNewRelationCode();  	  	    	      
  	  	    	         String newHinNo = patientList.get(0).getHinNo().substring(0, patientList.get(0).getHinNo().length()-oldRelationCode.length());
  	  	    	         newHinNo +=masRelation.getNewRelationCode();
  	  	    	         patientList.get(0).setHinNo(newHinNo);
  	  	    	       
  	    	         }
  	    	 
  	    	        
  	    	         patientList.get(0).setPFirstName(masEmployeeDependent.getEmployeeDependentFName());
  	    	         patientList.get(0).setPMiddleName(masEmployeeDependent.getEmployeeDependentMName());
  	    	         patientList.get(0).setPLastName(masEmployeeDependent.getEmployeeDependentLName());              		
  	    	         patientList.get(0).setDateOfBirth(masEmployeeDependent.getDateOfBirth());            		
  	             	 patientList.get(0).setBloodGroup(masEmployeeDependent.getBloodGroup());              		
  	                 patientList.get(0).setSex(masEmployeeDependent.getGender());
  	    	         patientList.get(0).setRelation(masRelation);
              	 
              	             	 
              	 hbt.update(patientList.get(0));
              	 hbt.flush();
               }
  	    	
  	     
  	        
  	     
  	     // code ends to update record in patient table
		
		
		dataUpdated = true;
		
		
		
		String filename = "";
		if(generalMap.get("filename")!= null){
			filename =(String) generalMap.get("filename");
		}
		String uploadURL = "";
		if(generalMap.get("uploadURL")!= null){
			uploadURL =(String) generalMap.get("uploadURL");
		}
		if (filename != null && !filename.equals("")) {
		System.out.println("employeeDependentcodeId"+employeeDependentcodeId);
		List<UploadDocuments> uploadDocumentsList = hbt.find("from jkt.hms.masters.business.UploadDocuments as inp where inp.EmployeeDependent.Id = "+ employeeDependentcodeId);
		System.out.println("uploadDocumentsList"+uploadDocumentsList.size());
		for (UploadDocuments empDept : uploadDocumentsList) {
			int id = empDept.getId();
			String hql = "delete from jkt.hms.masters.business.UploadDocuments as a where a.Id = "+ id;
			Query query = session.createQuery(hql);
			int row = query.executeUpdate();
		
		}
		String fileExtension=null;
		 File file=null;
		 try { 
			
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				System.out.println(uploadURL+" -- "+filename);
				 file=new File(uploadURL + "/" + filename);
	    		 System.out.println("path>>"+file.getPath());
	    		
	    	     FileInputStream is = new FileInputStream(file);
	    	     long length = file.length();
	    	     ByteBuffer byteBuff=null;
	    	   //  int modLength=length/
	    	     if (length > Integer.MAX_VALUE) {
	            // File is too large
	    	     }
	    	     // Create the byte array to hold the data
	    	     byte[] bytes = new byte[(int)length];
	    	     int offset = 0;
	    	     int numRead = 0;
	    	     while (offset < bytes.length
	    	    		 && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
	    	    	 offset += numRead;
	    	    	
	    	     }
	    
	    	     if (offset < bytes.length) {
	    	    	 throw new IOException("Could not completely read file "+file.getName());
	    	         
	    	     }
	    	     is.close();     
	    	
	    	     
	    	     UploadDocuments document = new UploadDocuments();
	    	     document.setPatientDocument(bytes);
	    	     int indexNo = filename.lastIndexOf("."); 
	    	     String actualfileName = filename.substring(0, indexNo);
	    	     fileExtension = filename.substring(indexNo+1);
	    	     document.setFileName(actualfileName);
	    	     document.setFileExtension(fileExtension);
	    	     Date d= new Date();
	    	     document.setUploadDate(d);
	    	     if(masEmployeeDependent.getId()!=0)
	    	     {
	    	    	 
	    	    	 masEmployeeDependent.setId(masEmployeeDependent.getId());
	    	    	 document.setEmployeeDependent(masEmployeeDependent);
	    	     }
	    	     hbt.save(document);
	    	     hbt.flush();
	    	     hbt.refresh(document);
			 
	    	     dataUpdated = true;
		 }	    
		catch (Exception e) {
	    	e.printStackTrace();
	      System.err.println("Error: " + e.getMessage());
	      e.printStackTrace();
	   
		
			}	
		
		 }
		return dataUpdated;

	}

	@SuppressWarnings( { "unchecked", "unchecked" })
	public Map<String, Object> searchEmployeeDependent(
			String employeeDependentCode, String employeeDependentName) {
		List<MasEmployeeDependent> searchEmployeeDependentList = new ArrayList<MasEmployeeDependent>();
		List hospitalCodeList = null;
		//List employeeCodeList = null;
		List relationCodeList = null;
		Map<String, Object> employeeDependentFieldsMap = new HashMap<String, Object>();
		List gridHospitalList = null;
	//	List gridEmployeeList = null;
		List gridRelationList = null;
		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
		List<MasAdministrativeSex> gridSexList = new ArrayList<MasAdministrativeSex>();
		Session session = (Session) getSession();
		try {
			if (employeeDependentName != null && employeeDependentCode==null) {
				searchEmployeeDependentList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasEmployeeDependent sc where sc.EmployeeDependentFName like '"
										+ employeeDependentName	+ "%' order by sc.EmployeeDependentFName");
			} else {
				searchEmployeeDependentList=session.createCriteria(MasEmployeeDependent.class).createAlias("Employee", "employee").add(Restrictions.eq("employee.ServiceNo", employeeDependentCode)).list();
			
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchEmployeeDependent  " + e);
		}
		hospitalCodeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasHospital as mc where mc.Status = 'y'");
		gridHospitalList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasHospital as HospitalCode");
	/*	employeeCodeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasEmployee as mc where mc.Status = 'y'");*/
		/*gridEmployeeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasEmployee as EmployeeCode");*/
		relationCodeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasRelation as mc where mc.Status = 'y'");
		gridRelationList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasRelation as RelationCode");
		sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AdministrativeSexName")).list();
		gridSexList = session.createCriteria(MasAdministrativeSex.class).addOrder(Order.asc("AdministrativeSexName")).list();
		List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
		bloodGroupList = session.createCriteria(MasBloodGroup.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("BloodGroupName")).list();
		employeeDependentFieldsMap.put("bloodGroupList", bloodGroupList);
		employeeDependentFieldsMap.put("gridHospitalList", gridHospitalList);
		//employeeDependentFieldsMap.put("gridEmployeeList", gridEmployeeList);
		employeeDependentFieldsMap.put("gridRelationList", gridRelationList);
		employeeDependentFieldsMap.put("searchEmployeeDependentList",
				searchEmployeeDependentList);
		employeeDependentFieldsMap.put("hospitalCodeList", hospitalCodeList);
	//	employeeDependentFieldsMap.put("employeeCodeList", employeeCodeList);
		employeeDependentFieldsMap.put("relationCodeList", relationCodeList);
		employeeDependentFieldsMap.put("sexList", sexList);
		employeeDependentFieldsMap.put("gridSexList", gridSexList);
		return employeeDependentFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showEmployeeDependentJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<MasEmployeeDependent> searchEmployeeDependentList = new ArrayList<MasEmployeeDependent>();
			List<MasHospital> hospitalCodeList = new ArrayList<MasHospital>();
			List<MasHospital> gridHospitalList = new ArrayList<MasHospital>();
			//List<MasEmployee> employeeCodeList = new ArrayList<MasEmployee>();
			//List<MasEmployee> gridEmployeeList = new ArrayList<MasEmployee>();
			List<MasRelation> relationCodeList = new ArrayList<MasRelation>();
			List<MasRelation> gridRelationList = new ArrayList<MasRelation>();
			List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
			List<MasAdministrativeSex> gridSexList = new ArrayList<MasAdministrativeSex>();
			Session session = (Session) getSession();
			
			/*searchEmployeeDependentList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasEmployeeDependent ");*/
			/*gridHospitalList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasHospital as id");
			hospitalCodeList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasHospital as mc where mc.Status = 'y'");*/
		/*	gridEmployeeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasEmployee as id");*/
			/*employeeCodeList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasEmployee as mc where mc.Status = 'y'  order by mc.FirstName asc");*/
			gridRelationList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasRelation as id");
			relationCodeList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasRelation as mc where mc.Status = 'y' and mc.NewRelationName!='Self' order by mc.RelationName asc");

			sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AdministrativeSexName")).list();
			gridSexList = session.createCriteria(MasAdministrativeSex.class).addOrder(Order.asc("AdministrativeSexName")).list();
			List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
			bloodGroupList = session.createCriteria(MasBloodGroup.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("BloodGroupName")).list();
			map.put("bloodGroupList", bloodGroupList);
			map.put("sexList", sexList);
			map.put("gridSexList", gridSexList);
			map.put("searchEmployeeDependentList", searchEmployeeDependentList);
			map.put("hospitalCodeList", hospitalCodeList);
			map.put("gridHospitalList", gridHospitalList);
			//map.put("employeeCodeList", employeeCodeList);
			//map.put("gridEmployeeList", gridEmployeeList);
			map.put("relationCodeList", relationCodeList);
			map.put("gridRelationList", gridRelationList);
		} catch (Exception e) {
			//System.out.println(" Exception --> " + e);
		}
		return map;
	}

	// -------------------------------------- Emp Status
	// ----------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> searchEmpStatus(String empStatusCode,
			String empStatusName) {
		List<MasEmpStatus> searchEmpStatusList = new ArrayList<MasEmpStatus>();
		Map<String, Object> empStatusFieldsMap = new HashMap<String, Object>();
		try {
			if ((empStatusName != null) || (empStatusCode == null)) {
				searchEmpStatusList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasEmpStatus es where es.EmpStatusName like '"
								+ empStatusName
								+ "%' order by es.EmpStatusName");
			} else {
				searchEmpStatusList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasEmpStatus es where es.EmpStatusCode like '"
								+ empStatusCode
								+ "%' order by es.EmpStatusCode");
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchEmpStatusList  " + e);
		}
		empStatusFieldsMap.put("searchEmpStatusList", searchEmpStatusList);
		return empStatusFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showEmpStatusJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmpStatus> searchEmpStatusList = new ArrayList<MasEmpStatus>();
		searchEmpStatusList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasEmpStatus ");
		map.put("searchEmpStatusList", searchEmpStatusList);
		return map;
	}

	public boolean addEmpStatus(MasEmpStatus masEmpStatus) {

		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masEmpStatus);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editEmpStatusToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String empStatusName = "";
		@SuppressWarnings("unused")
		String empStatusCode = "";
		int empStatusId = 0;
		String changedBy = "";
		empStatusId = (Integer) generalMap.get("id");
		empStatusCode = (String) generalMap.get("empStatusCode");
		empStatusName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasEmpStatus masEmpStatus = (MasEmpStatus) getHibernateTemplate().load(
				MasEmpStatus.class, empStatusId);
		masEmpStatus.setId(empStatusId);
		masEmpStatus.setEmpStatusName(empStatusName);
		masEmpStatus.setLastChgBy(changedBy);
		masEmpStatus.setLastChgDate(currentDate);
		masEmpStatus.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masEmpStatus);
		dataUpdated = true;
		return dataUpdated;

	}

	/*public boolean deleteEmployee(int employeeId,Map<String, Object> generalMap) {
		
		
		
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		System.out.println(employeeId+"employeeIdemployeeId");
		MasEmployee masEmployee = new MasEmployee();
		masEmployee=(MasEmployee) getHibernateTemplate().load(MasEmployee.class, employeeId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (masEmployee.getStatus().equalsIgnoreCase("y")) {
			masEmployee.setStatus("n");
			dataDeleted = true;
		} else {
			masEmployee.setStatus("y");
			dataDeleted = false;
		}
		masEmployee.setLastChgBy(changedBy);
		masEmployee.setLastChgDate(currentDate);
		masEmployee.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masEmployee);
		return dataDeleted;
	}*/

	public boolean deleteEmpStatus(int empStatusId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasEmpStatus masEmpStatus = new MasEmpStatus();
		masEmpStatus = (MasEmpStatus) getHibernateTemplate().load(
				MasEmpStatus.class, empStatusId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (masEmpStatus.getStatus().equals("y")) {
			masEmpStatus.setStatus("n");
			dataDeleted = true;
		} else {
			masEmpStatus.setStatus("y");
			dataDeleted = false;
		}
		masEmpStatus.setLastChgBy(changedBy);
		masEmpStatus.setLastChgDate(currentDate);
		masEmpStatus.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masEmpStatus);
		return dataDeleted;
	}

	// ------------------------------------------ Referral Doctor
	// --------------------------------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> showReferralDoctorJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasReferralDoctor> searchReferralDoctorList = new ArrayList<MasReferralDoctor>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasDepartment> gridDepartmentList = new ArrayList<MasDepartment>();
		searchReferralDoctorList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasReferralDoctor ");
		gridDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment as isc");
		departmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment as isc where isc.Status = 'y' order by isc.DepartmentName asc");
		map.put("searchReferralDoctorList", searchReferralDoctorList);
		map.put("gridDepartmentList", gridDepartmentList);
		map.put("departmentList", departmentList);

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchReferralDoctor(String referralDoctorName) {
		List<MasReferralDoctor> searchReferralDoctorList = new ArrayList<MasReferralDoctor>();
		List<MasDepartment> departmentList = null;
		Map<String, Object> referralDoctorMap = new HashMap<String, Object>();
		List<MasDepartment> gridDepartmentList = null;
		try {
			if (referralDoctorName != null) {
				searchReferralDoctorList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasReferralDoctor mrd where mrd.DoctorName like '"
										+ referralDoctorName
										+ "%' order by mrd.DoctorName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		departmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment as md where md.Status = 'y'");
		gridDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment as md");
		referralDoctorMap.put("searchReferralDoctorList",
				searchReferralDoctorList);
		referralDoctorMap.put("departmentList", departmentList);
		referralDoctorMap.put("gridDepartmentList", gridDepartmentList);

		return referralDoctorMap;
	}

	public boolean editReferralDoctorToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int departmentId = 0;
		String referralDoctorName = "";
		@SuppressWarnings("unused")
		int referralDoctorId = 0;
		String changedBy = "";
		@SuppressWarnings("unused")
		String address1 = "";
		String address2 = "";
		String phoneNo = "";
		String mobileNo = "";
		int referralType = 0;

		referralDoctorId = (Integer) generalMap.get("id");
		referralDoctorName = (String) generalMap.get("name");
		address1 = (String) generalMap.get("addressOne");
		address2 = (String) generalMap.get("addressTwo");
		phoneNo = (String) generalMap.get("phoneNo");
		mobileNo = (String) generalMap.get("mobileNo");
		referralType = (Integer) generalMap.get("referralType");
		departmentId = (Integer) generalMap.get("departmentId");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		MasReferralDoctor masReferralDoctor = (MasReferralDoctor) getHibernateTemplate()
				.load(MasReferralDoctor.class, referralDoctorId);

		masReferralDoctor.setId(referralDoctorId);
		masReferralDoctor.setDoctorName(referralDoctorName);
		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(departmentId);
		masReferralDoctor.setDepartment(masDepartment);
		masReferralDoctor.setAddress1(address1);
		masReferralDoctor.setAddress2(address2);
		masReferralDoctor.setPhoneNo(phoneNo);
		masReferralDoctor.setMobileNo(mobileNo);
		masReferralDoctor.setReferralType(referralType);
		masReferralDoctor.setLastChgBy(changedBy);
		masReferralDoctor.setLastChgDate(currentDate);
		masReferralDoctor.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masReferralDoctor);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings( { "unchecked", "unchecked" })
	public boolean addReferralDoctor(MasReferralDoctor masReferralDoctor) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masReferralDoctor);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteReferralDoctor(int referralDoctorId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasReferralDoctor masReferralDoctor = new MasReferralDoctor();
		masReferralDoctor = (MasReferralDoctor) getHibernateTemplate().load(
				MasReferralDoctor.class, referralDoctorId);
		@SuppressWarnings("unused")
		Integer departmentId = masReferralDoctor.getDepartment().getId();
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (masReferralDoctor.getStatus().equals("y")) {
			@SuppressWarnings("unused")
			List<MasDepartment> departmentList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasDepartment as isc where isc.Id='"
							+ referralDoctorId + "' and isc.Status='y'");
			masReferralDoctor.setStatus("n");
			dataDeleted = true;
		} else {
			masReferralDoctor.setStatus("y");
			dataDeleted = false;
		}
		masReferralDoctor.setLastChgBy(changedBy);
		masReferralDoctor.setLastChgDate(currentDate);
		masReferralDoctor.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masReferralDoctor);
		return dataDeleted;

	}

	// ---------------------------- Employee -----------------------------
	@SuppressWarnings("unchecked")
	public List<MasTitle> getTitleList() {
		List<MasTitle> titleList = new ArrayList<MasTitle>();
		titleList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasTitle as mt where mt.Status = 'y'");
		return titleList;
	}

	@SuppressWarnings("unchecked")
	public List<MasEmpStatus> getEmpStatusList() {
		List<MasEmpStatus> empStatusList = new ArrayList<MasEmpStatus>();
		empStatusList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasEmpStatus as mes where mes.Status = 'y'");
		return empStatusList;
	}

	@SuppressWarnings("unchecked")
	public List<MasDepartment> getDepartmentList() {
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		departmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment as md where md.Status = 'y'");
		return departmentList;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showEmployeeJsp(int hospitalId) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasTitle> titleList = new ArrayList<MasTitle>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
		List<MasEmpStatus> empStatusList = new ArrayList<MasEmpStatus>();
		List<MasEmployee> searchEmployeeList = new ArrayList<MasEmployee>();
		List<MasEmpCategory> empCategoryList = new ArrayList<MasEmpCategory>();
		List<MasGrade> gradeList = new ArrayList<MasGrade>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasRank> rankCategoryList = new ArrayList<MasRank>();
		List<MasDivision> divisionList = new ArrayList<MasDivision>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasTrade> tradeList = new ArrayList<MasTrade>();
		List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
		List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		List<MasState> stateList = new ArrayList<MasState>();
		List<MasCountry> countryList = new ArrayList<MasCountry>();
		List<MasEmployeeType> employeeTypeList = new ArrayList<MasEmployeeType>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		List<UploadDocuments> uploadDocuments = new ArrayList<UploadDocuments>();
//Session session=(Session)getSession();
		List<MasUnit> gridUnitList = new ArrayList<MasUnit>();
//		List<TransactionSequence> seqList = new ArrayList<TransactionSequence>();
/*
		gridUnitList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasUnit as isc ");*/
		gridUnitList=session.createCriteria(MasUnit.class).list();
		
/*		titleList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasTitle as tm where tm.Status = 'y' order by tm.TitleName asc");
*/		
		titleList=session.createCriteria(MasTitle.class).add(Restrictions.eq("Status", "y")).list();
		hospitalList=session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).list();
	/*	departmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment as md where md.Status = 'y'");*/
		
		departmentList=session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
		
		/*costCenterList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasCostCenter as mcc where mcc.Status = 'y'   order by mcc.CostCenterName asc");*/
		
		
		
		costCenterList=session.createCriteria(MasCostCenter.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("CostCenterName")).list();
		/*uploadDocuments=session.createCriteria(UploadDocuments.class).list();*/
		/*empCategoryList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasEmpCategory as mec where mec.Status = 'y' order by mec.EmpCategoryName asc");*/
		
		
		
		
		/*empStatusList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasEmpStatus as mes where mes.Status = 'y' order by mes.EmpStatusName asc");*/
		
		
		
		
		/*searchEmployeeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasEmployee as emp where emp.Hospital.Id="+hospitalId);*/
		
		
		
		/*gradeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasGrade as mg where mg.Status = 'y' order by mg.GradeName asc");*/
		
		/*rankList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasRank as mg where mg.Status = 'y' order by mg.RankName asc");*/
		
		
	/*	unitList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasUnit as mg where mg.Status = 'y' order by mg.UnitName asc");*/
		
		
		
		/*tradeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasTrade as mg where mg.Status = 'y' order by mg.TradeName asc");*/
		
		
	/*	seqList = session.createCriteria(TransactionSequence.class).add(
				Restrictions.eq("TransactionPrefix", "EMP")).list();
	*/	
		
		
		/*
		 *Code for User Login
		*/
		empCategoryList=session.createCriteria(MasEmpCategory.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("EmpCategoryName")).list();
		empStatusList=session.createCriteria(MasEmpStatus.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("EmpStatusName")).list();
		/*searchEmployeeList=session.createCriteria(MasEmployee.class)
				//.add(Restrictions.eq("Hospital.Id", hospitalId))
				.list();*/
		gradeList=session.createCriteria(MasGrade.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("GradeName")).list();
		rankList=session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankName")).list();
		unitList=session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("UnitName")).list();
		tradeList=session.createCriteria(MasTrade.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("TradeName")).list();
		bloodGroupList = session.createCriteria(MasBloodGroup.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("BloodGroupName")).list();
		sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AdministrativeSexName")).list();
		List<UsergroupHospital> usergroupHospitalList = new ArrayList<UsergroupHospital>();
		usergroupHospitalList = session.createCriteria(UsergroupHospital.class).add(Restrictions.eq("Hospital.Id", hospitalId)).add(Restrictions.eq("Status", "y")).list();
		rankCategoryList=session.createCriteria(MasRankCategory.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankCategoryName")).list();
		divisionList=session.createCriteria(MasDivision.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("DivisionName")).list();
		districtList=session.createCriteria(MasDistrict.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("DistrictName")).list();
		stateList=session.createCriteria(MasState.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("StateName")).list();
		countryList=session.createCriteria(MasCountry.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("CountryName")).list();
		employeeTypeList=session.createCriteria(MasEmployeeType.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("EmployeeTypeName")).list();
		
		List<EmpGroups> empGroupList = new ArrayList<EmpGroups>();
		List<Object[]> groupList = new ArrayList<Object[]>();

		/*empGroupList = getHibernateTemplate().find(
				"from EmpGroups as eg where eg.Status='y'");
		*/
		empGroupList=session.createCriteria(EmpGroups.class).add(Restrictions.eq("Status","y")).list();
/*		groupList = getHibernateTemplate()
		.find( "select mc.Group.Id,mc.Group.GroupName from jkt.hms.masters.business.UsergroupHospital as mc where mc.Status = 'y' and mc.Hospital.Id="
						+ hospitalId + " group by mc.Group.Id,mc.Group.GroupName");
*/		groupList =session.createCriteria(UsergroupHospital.class).add(Restrictions.eq("Hospital.Id", hospitalId)).list();
		map.put("empGroupList", empGroupList);
		map.put("groupList", groupList);
		/*
		 * End of Code for User Login
		*/
		/*
		 * Code for Module/Template
		 * Date 06 July 2012
		*/
		List<MasTemplate> masTemplateList = new ArrayList<MasTemplate>();
/*		masTemplateList = getHibernateTemplate().find(
		"from jkt.hms.masters.business.MasTemplate templet where  templet.Template.Id is null and templet.Status ='y'  order by TemplateName.TemplateName asc");
*/
		masTemplateList=session.createCriteria(MasTemplate.class).add(Restrictions.isNull("Template.Id")).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("TemplateName")).list();
		
		
		map.put("masTemplateList",masTemplateList);
		/*
		 * End of Code for Module/Template
		 * Date 06 July 2012
		*/
		map.put("usergroupHospitalList", usergroupHospitalList);
		map.put("gridUnitList", gridUnitList);
		map.put("titleList", titleList);
		map.put("hospitalList", hospitalList);
		map.put("departmentList", departmentList);
		map.put("costCenterList", costCenterList);
		map.put("uploadDocuments", uploadDocuments);
		map.put("empStatusList", empStatusList);
		map.put("empCategoryList", empCategoryList);
		map.put("gradeList", gradeList);
		map.put("searchEmployeeList", searchEmployeeList);
		map.put("rankList", rankList);
		map.put("unitList", unitList);
		map.put("tradeList", tradeList);
//		map.put("seqList", seqList);
		map.put("bloodGroupList", bloodGroupList);
		map.put("sexList",sexList);
		map.put("divisionList", divisionList);
		map.put("districtList", districtList);
		map.put("stateList", stateList);
		map.put("countryList", countryList);
		map.put("rankCategoryList", rankCategoryList);
		map.put("employeeTypeList", employeeTypeList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean addEmployee(MasEmployee masEmployee,Map<String, Object> userMap) {
		List<TransactionSequence> regList = new ArrayList<TransactionSequence>();
		MasRank masRank = null;
		Session session = (Session) getSession();

		boolean successfullyAdded = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			List<MasEmployee> masEmployeeList=new ArrayList<MasEmployee>();
			masEmployeeList=hbt.find("from jkt.hms.masters.business.MasEmployee as emp where emp.ServiceNo='"+masEmployee.getServiceNo()+"'");
			if(masEmployeeList.size()==0){
				if(masEmployee.getRank()!=null){
					masRank = (MasRank)hbt.load(MasRank.class, masEmployee.getRank().getId());
					masEmployee.setServiceType(masRank.getServiceType());
				}
				
				
				
				hbt.save(masEmployee);
				int departmentId=0;
				if (userMap.get("departmentId") != null) {
					departmentId = (Integer) userMap.get("departmentId");
				}
				if(departmentId!=0){
					MasEmployeeDepartment masEmployeeDepartment = new MasEmployeeDepartment();

					
					MasDepartment masDepartment = new MasDepartment();
					masDepartment.setId(departmentId);
					masEmployeeDepartment.setDepartment(masDepartment);
					masEmployeeDepartment.setEmployee(masEmployee);
					masEmployeeDepartment.setStatus("y");
					hbt.save(masEmployeeDepartment);
				

				}
				/*String departmentStr = "";
				if (userMap.get("departmentStr") != null) {
					departmentStr = (String) userMap.get("departmentStr");
				}
				StringTokenizer str = new StringTokenizer(departmentStr, ",");
				while (str.hasMoreTokens()) {
					MasEmployeeDepartment masEmployeeDepartment = new MasEmployeeDepartment();

					int departmentId = Integer.parseInt(str.nextToken());
					MasDepartment masDepartment = new MasDepartment();
					masDepartment.setId(departmentId);
					masEmployeeDepartment.setDepartment(masDepartment);
					masEmployeeDepartment.setEmployee(masEmployee);
					masEmployeeDepartment.setStatus("y");
					hbt.save(masEmployeeDepartment);
				

				}*/
				/*String loginRequired="";
				if(userMap.get("loginRequired")!=null){
					loginRequired=(String)userMap.get("loginRequired");
				}
				if(!loginRequired.equalsIgnoreCase("") && loginRequired.equalsIgnoreCase("on") ){
					Users users = new Users();
					if(userMap.get("users")!=null){
						users=(Users)userMap.get("users");
					}
					String[] appGroupIdArray = null;
					if(userMap.get("appGroupIdArray")!=null){
						appGroupIdArray=(String[])userMap.get("appGroupIdArray");
					}
					
					String[] userDepartmentIdArray = null;
					if(userMap.get("userDepartmentIdArray")!=null){
						userDepartmentIdArray=(String[])userMap.get("userDepartmentIdArray");
					}
					int hospitalId=0;
					if(userMap.get("hospitalId")!=null){
						hospitalId=(Integer)userMap.get("hospitalId");
					}
					System.out.println("----"+hospitalId);
					List<Integer> templetIdList=new ArrayList<Integer>();
					if(userMap.get("templetIdList")!=null){
						templetIdList=(List<Integer>)userMap.get("templetIdList");
					}
					int departmentId=0;
			if(userMap.get("departmentId")!=null){
				departmentId=(Integer)userMap.get("departmentId");
			}
					users.setEmployee(masEmployee);
					hbt.save(users);
					if(userDepartmentIdArray!=null){
						for (int i = 0; i < userDepartmentIdArray.length; i++) {
							int userDepartmentId=0;
							userDepartmentId=Integer.parseInt(""+userDepartmentIdArray[i]);
							if(userDepartmentId>0){
								UserDepartment userDepartment = new UserDepartment();
								MasDepartment masDepartment = new MasDepartment();
								masDepartment.setId(userDepartmentId);
								userDepartment.setDepartment(masDepartment);

								userDepartment.setUser(users);
								userDepartment.setStatus("y");
								hbt.save(userDepartment);
							}
						}
					}


					if (appGroupIdArray != null) {
						for (int i = 0; i < appGroupIdArray.length; i++) {

							List<UsergroupHospital> groupHospitalIdList = new ArrayList<UsergroupHospital>();
							groupHospitalIdList = getHibernateTemplate()
							.find(
									"from jkt.hms.masters.business.UsergroupHospital as ugh where  ugh.Status='y' and ugh.Hospital.Id ="
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
								MasHospital hospital=new MasHospital();
								hospital.setId(hospitalId);
								masUserUsergroupHospital.setHospital(hospital);
								masUserUsergroupHospital.setStatus("y");
								masUserUsergroupHospital.setLastChgBy(users.getLastChgBy());
								masUserUsergroupHospital.setLastChgDate(users.getLastChgDate());
								masUserUsergroupHospital.setLastChgTime(users.getLastChgTime());
								hbt.save(masUserUsergroupHospital);
								hbt.refresh(masUserUsergroupHospital);
							}
						}
					}else{
						System.out.println("***Else Condition ***");
						
						 * Default Case {Only One User Group Hospital Will Assigned to User}
						 * 
						 * Date 27 July 2012
						 
						List<UsergroupHospital> groupHospitalIdList = new ArrayList<UsergroupHospital>();
						groupHospitalIdList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.UsergroupHospital as ugh where ugh.Status='y' and ugh.Hospital.Id ="+ hospitalId);
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
							MasHospital hospital=new MasHospital();
							hospital.setId(hospitalId);
							masUserUsergroupHospital.setHospital(hospital);
							masUserUsergroupHospital.setStatus("y");
							masUserUsergroupHospital.setLastChgBy(users.getLastChgBy());
							masUserUsergroupHospital.setLastChgDate(users.getLastChgDate());
							masUserUsergroupHospital.setLastChgTime(users.getLastChgTime());
							hbt.save(masUserUsergroupHospital);
							hbt.refresh(masUserUsergroupHospital);
						}
					}

					
					 * Code for Module Application
					 * Date 06 July 2012
					 
					Map<String, Object> templateMap = new HashMap<String, Object>();
					Map<String, Object> inputMap = new HashMap<String, Object>();
					
					
					String changedBy = "";
					Date currentDate = new Date();
					String currentTime = "";
					currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
					
					changedBy = (String) userMap.get("changedBy");
					currentDate = (Date) userMap.get("currentDate");
					//currentTime = (String) userMap.get("currentTime");
					
					inputMap.put("changedBy",changedBy);
					inputMap.put("currentDate",currentDate);
					inputMap.put("currentTime",currentTime);
					inputMap.put("users", users);
					
					inputMap.put("templetIdList",templetIdList);
					inputMap.put("hospitalId",hospitalId);
					if(templetIdList.size()>0){
						templateMap=getTemplateApplicationList(inputMap);
					}
					
					 * End of Code for Module Application
					 * Date 06 July 2012
					 
				}else{
					System.out.println("On Employee ,Not Login Create");
				}
				*/
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
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		
		
		
	
		String filename = "";
		if(userMap.get("filename")!= null){
			filename =(String) userMap.get("filename");
		}
		String uploadURL = "";
		if(userMap.get("uploadURL")!= null){
			uploadURL =(String) userMap.get("uploadURL");
		}
	

			
			String fileExtension=null;
			 File file=null;
			 try { 		if (filename != null) {
					HibernateTemplate hbt=getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					System.out.println(uploadURL+" -- "+filename);
					 file=new File(uploadURL + "/" + filename);
		    		 System.out.println("path>>"+file.getPath());
		    		
		    	     FileInputStream is = new FileInputStream(file);
		    	     long length = file.length();
		    	     ByteBuffer byteBuff=null;
		    	   //  int modLength=length/
		    	     if (length > Integer.MAX_VALUE) {
		            // File is too large
		    	     }
		    	     // Create the byte array to hold the data
		    	     byte[] bytes = new byte[(int)length];
		    	     int offset = 0;
		    	     int numRead = 0;
		    	     while (offset < bytes.length
		    	    		 && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
		    	    	 offset += numRead;
		    	    	
		    	     }
		    
		    	     if (offset < bytes.length) {
		    	    	 throw new IOException("Could not completely read file "+file.getName());
		    	         
		    	     }
		    	     is.close();     
		    	
		    	     
		    	     UploadDocuments document = new UploadDocuments();
		    	     document.setPatientDocument(bytes);
		    	     int indexNo = filename.lastIndexOf("."); 
		    	     String actualfileName = filename.substring(0, indexNo);
		    	     fileExtension = filename.substring(indexNo+1);
		    	     document.setFileName(actualfileName);
		    	     document.setFileExtension(fileExtension);
		    	     Date d= new Date();
		    	     document.setUploadDate(d);
		    	     if(masEmployee.getId()!=0)
		    	     {
		    	    	 
		    	    	 masEmployee.setId(masEmployee.getId());
		    	    	 document.setEmployee(masEmployee);
		    	     }
		    	     hbt.save(document);
		    	     hbt.flush();
		    	     hbt.refresh(document);	
			 	}
	    		     successfullyAdded=true;
		    
		    }
			catch (Exception e) {
		    	e.printStackTrace();
		      System.err.println("Error: " + e.getMessage());
		      e.printStackTrace();
		   
			
		}		
		return successfullyAdded;
	}

	public boolean editEmployeeToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Session session = (Session) getSession();
		String firstName = "";
		String lastName = "";
		String middleName = "";
		@SuppressWarnings("unused")
		String employeeCode = "";
		String serviceNo = "";
		int employeeId = 0;
		int titleId = 0;
		int divisionId = 0;
		int costCenterId = 0;
		int empStatusId = 0;
		int empCategoryId = 0;
		int gradeId = 0;
		int tradeId = 0;
		int unitId = 0;
		int rankId = 0;
		int departmentId=0;
		String authorizedForHighValueMedicine="";
		String emergencyTellNumber = "";
		//String designation = "";
		String emergencyCellNumber = "";
		String residenceTellNumber = "";
		String officeTellNumber = "";
		Date appointmentDate = new Date();
		Date joinDate = new Date();
		Date currDivisionJoiningDate=new Date();
		Date dob=new Date();
		Date halJoiningDate=new Date();
		String jobCode = "";
		String email = "";
		String bankCode = "";
		String accounthead = "";
		String bankAccountNumber = "";
		String bankAccountCode = "";
		String employeePhoto = "";
		String employeeUrl = "";
		@SuppressWarnings("unused")
		String grade = "";
		Date changedDate = new Date();
		String changedBy = "";
		String currentTime = "";
		Date currentDate = new Date();
		int hospitalId = 0;
		int bloodGroupId = 0;
		int sexId = 0;
		int localCountry = 0;
		int localState = 0;
		int localDistrict = 0;
		int perCountry = 0;
		int perState = 0;
		int perDistrict = 0;	
		int oldDeptId = 0;
		String remarks="";
		Date contract=new Date();
		Date extension=new Date();
		String aadharCard="";
		String age ="";
		int rankCategoryId=0;
		employeeId = (Integer) generalMap.get("id");
		departmentId=(Integer) generalMap.get("departmentId");
		contract = (Date) generalMap.get("contract");
		remarks = (String) generalMap.get("remarks");
		extension= (Date) generalMap.get("extension");
		hospitalId = (Integer) generalMap.get("hospitalId");
		aadharCard = (String) generalMap.get("aadharCard");
		perCountry = (Integer) generalMap.get("perCountry");
		perState = (Integer) generalMap.get("perState");
		perDistrict = (Integer) generalMap.get("perDistrict");
		localCountry = (Integer) generalMap.get("localCountry");
		localState = (Integer) generalMap.get("localState");
		localDistrict = (Integer) generalMap.get("localDistrict");
		divisionId= (Integer) generalMap.get("divisionId");
		rankCategoryId= (Integer) generalMap.get("rankCategoryId");
		employeeCode = (String) generalMap.get("employeeCode");
		serviceNo = (String) generalMap.get("serviceNo");
		firstName = (String) generalMap.get("firstName");
		lastName = (String) generalMap.get("lastName");
		middleName = (String) generalMap.get("middleName");
		employeePhoto = (String) generalMap.get("employeePhoto");
		authorizedForHighValueMedicine = (String) generalMap.get("authorizedForHighValueMedicine");
		jobCode = (String) generalMap.get("jobCode");
		appointmentDate = (Date) generalMap.get("appointmentDate");
		
		currDivisionJoiningDate = (Date) generalMap.get("currDivisionJoiningDate");
		
		halJoiningDate = (Date) generalMap.get("halJoiningDate");
		
		dob = (Date) generalMap.get("dob");
		
		joinDate = (Date) generalMap.get("joinDate");
		titleId = (Integer) generalMap.get("titleId");
		gradeId = (Integer) generalMap.get("gradeId");
		//designation = (String) generalMap.get("designation");
		//departmentId = (Integer) generalMap.get("departmentId");
		costCenterId = (Integer) generalMap.get("costCenterId");
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
		if(generalMap.get("bloodGroupId")!=null){
			bloodGroupId = (Integer) generalMap.get("bloodGroupId");
		}
		if(generalMap.get("sexId")!=null){
			sexId = (Integer) generalMap.get("sexId");
		}
		if(generalMap.get("age")!=null){
			age = (String) generalMap.get("age");
		}
		String departmentStr = "";
		if (generalMap.get("departmentStr") != null) {
			departmentStr = (String) generalMap.get("departmentStr");
		}
		
		String deptNo = "";
		if (generalMap.get("deptNo") != null) {
			deptNo = (String) generalMap.get("deptNo");
		}
		int empTypeId = 0;
		if (generalMap.get("empTypeId") != null) {
			empTypeId = Integer.parseInt(generalMap.get("empTypeId").toString());
		}
		

	
		
		StringTokenizer str = new StringTokenizer(departmentStr, ",");
		changedBy = (String) generalMap.get("changedBy");
		currentTime = (String) generalMap.get("currentTime");
		MasEmployee masEmployee = (MasEmployee) getHibernateTemplate().load(
				MasEmployee.class, employeeId);
		oldDeptId = masEmployee.getDepartment() !=null?masEmployee.getDepartment().getId():0;
		masEmployee.setId(employeeId);
		masEmployee.setEmployeeCode(employeeCode);
		masEmployee.setServiceNo(serviceNo);
		masEmployee.setFirstName(firstName);
		masEmployee.setLastName(lastName);
		masEmployee.setMiddleName(middleName);
		masEmployee.setAccountHead(accounthead);
		masEmployee.setBankAccountNumber(bankAccountNumber);
		masEmployee.setAadharCard(aadharCard);
		masEmployee.setBankCode(bankCode);
		masEmployee.setEmployeePhoto(employeePhoto);
		masEmployee.setUrl(employeeUrl);
		
		masEmployee.setContractDate(contract);
		masEmployee.setExtensionDate(extension);
		masEmployee.setRemarks(remarks);
		
		if (empTypeId != 0) {
			MasEmployeeType empType = new MasEmployeeType();
			empType.setId(empTypeId);
			masEmployee.setEmployeeType(empType);
		}
		if (divisionId != 0) {
			MasDivision masDivision = new MasDivision();
			masDivision.setId(divisionId);
			masEmployee.setDivision(masDivision);
		}
		if (departmentId != 0) {
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			masEmployee.setDepartment(masDepartment);
		}
		if (rankCategoryId != 0) {
			MasRankCategory masRankCategory = new MasRankCategory();
			masRankCategory.setId(rankCategoryId);
			masEmployee.setRankCategory(masRankCategory);
		}
		masEmployee.setAuthorizedForHighValueMedicine(authorizedForHighValueMedicine);
		
		if (perCountry != 0) {
			MasCountry masCountry = new MasCountry();
			masCountry.setId(perCountry);
			masEmployee.setPerCountry(masCountry);
		}
		
		if (localCountry != 0) {
			MasCountry masCountry = new MasCountry();
			masCountry.setId(localCountry);
			masEmployee.setLocalCountry(masCountry);
		}
		
		if (perState != 0) {
			MasState masState = new MasState();
			masState.setId(perState);
			masEmployee.setPerState(masState);
		}
		if (localState != 0) {
			MasState masState = new MasState();
			masState.setId(localState);
			masEmployee.setLocalState(masState);
		}
		
		
		if (perDistrict != 0) {
			MasDistrict masDistrict = new MasDistrict();
			masDistrict.setId(perDistrict);
			masEmployee.setPerDistrict(masDistrict);
		}
		if (localDistrict != 0) {
			MasDistrict masDistrict = new MasDistrict();
			masDistrict.setId(localDistrict);
			masEmployee.setLocalDistrict(masDistrict);
		}
		
		MasHospital hospital = new MasHospital();
		hospital.setId(hospitalId);
		masEmployee.setHospital(hospital);

		if (titleId != 0) {
			MasTitle masTitle = new MasTitle();
			masTitle.setId(titleId);
			masEmployee.setTitle(masTitle);
		}
		/*if (departmentId != 0) {
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			masEmployee.setDepartment(masDepartment);
		}*/
		if (empStatusId != 0) {
			MasEmpStatus masEmpStatus = new MasEmpStatus();
			masEmpStatus.setId(empStatusId);
			masEmployee.setEmployeeStatus(masEmpStatus);
		}
		if (costCenterId != 0) {
			MasCostCenter masCostCenter = new MasCostCenter();
			masCostCenter.setId(costCenterId);
			masEmployee.setCostCenter(masCostCenter);
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
		if (bloodGroupId != 0) {
			MasBloodGroup masBloodGroup = new MasBloodGroup();
			masBloodGroup.setId(bloodGroupId);
			masEmployee.setBloodGroup(masBloodGroup);
		}
		System.out.println(sexId);
		if (sexId != 0) {
			MasAdministrativeSex sex = new MasAdministrativeSex();
			sex.setId(sexId);
			masEmployee.setGender(sex);
		}
		if(!age.equals("")){
			masEmployee.setAge(age);
		}
		if(generalMap.get("localAddress")!=null) {
			masEmployee.setLocalAddress((String)generalMap.get("localAddress"));
		}
		if(generalMap.get("perAddress")!=null) {
			masEmployee.setPerAddress((String)generalMap.get("perAddress"));
		}
		if(generalMap.get("roomNo")!=null) {
			masEmployee.setRoomNo((Integer)generalMap.get("roomNo"));
		}
		
		if(generalMap.get("pf_no")!=null) {
			masEmployee.setPFNo((String)generalMap.get("pf_no"));
		}
		if(generalMap.get("pan_no")!=null) {
			masEmployee.setPANNo((String)generalMap.get("pan_no"));
		}
		if(generalMap.get("account_no")!=null) {
			masEmployee.setAccountNo((String)generalMap.get("account_no"));
		}
		if(generalMap.get("bank_name")!=null) {
			masEmployee.setBankName((String)generalMap.get("bank_name"));
		}
		//masEmployee.setDesignation(designation);
		masEmployee.setJobCode(jobCode);
		masEmployee.setAppointmentDate(appointmentDate);
		masEmployee.setEmail(email);
		masEmployee.setCurrentDivisionJoinDate(currDivisionJoiningDate);
		masEmployee.setHalJoinDate(halJoiningDate);
		masEmployee.setDateOfBirth(dob);
		
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
		masEmployee.setDepartmentNo(deptNo);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			MasRank masRank = null;
			if(masEmployee.getRank()!=null){
				masRank = (MasRank)hbt.load(MasRank.class, masEmployee.getRank().getId());
				masEmployee.setServiceType(masRank.getServiceType());
				
			}
			hbt.update(masEmployee);
			hbt.refresh(masEmployee);
			dataUpdated = true;
			//code starts to update division id in referral patient header table
			hbt.bulkUpdate("update ReferralPatientHeader as rph set rph.Division.Id="+masEmployee.getDivision().getId()+", rph.DivisionName='"+masEmployee.getDivision().getDivisionName()+"' where rph.EmpNo ='"
							+ masEmployee.getServiceNo()+"'");
			
			
			//code ends to update division id in referral patient header table
			
			List<MasEmployeeDepartment> masEmployeeDepartmentList = hbt
					.find("from jkt.hms.masters.business.MasEmployeeDepartment as inp where inp.Employee.Id = "
							+ employeeId+ "and inp.Department.Id="+oldDeptId);

			for (MasEmployeeDepartment empDept : masEmployeeDepartmentList) {
				int id = empDept.getId();
				String hql = "delete from jkt.hms.masters.business.MasEmployeeDepartment as a where a.Id = "
						+ id;
				Query query = session.createQuery(hql);
				int row = query.executeUpdate();
				
				
				
			}
			
			if(departmentId!=0){
				MasEmployeeDepartment masEmployeeDepartment = new MasEmployeeDepartment();
				
				
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(departmentId);
				MasDivision masDivision = new MasDivision();
				masDivision.setId(divisionId);
				masEmployeeDepartment.setDepartment(masDepartment);
				masEmployeeDepartment.setDivision(masDivision);
				masEmployeeDepartment.setEmployee(masEmployee);
				masEmployeeDepartment.setStatus("y");
				hbt.save(masEmployeeDepartment);
			

			}
		
			
			/*while (str.hasMoreTokens()) {
				MasEmployeeDepartment masEmployeeDepartment = new MasEmployeeDepartment();
				int departmentId = Integer.parseInt(str.nextToken());
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(departmentId);
				masEmployeeDepartment.setDepartment(masDepartment);
				masEmployeeDepartment.setEmployee(masEmployee);
				masEmployeeDepartment.setStatus("y");
				hbt.save(masEmployeeDepartment);
				dataUpdated = true;
			}*/
			
			
			
			
			  // code starts to update record in patient table
   	     
   	     List<Patient> patientList= new ArrayList<Patient>();
   	     
   	     patientList = session.createCriteria(Patient.class)
   	    		 .add(Restrictions.eq("ServiceNo", masEmployee.getServiceNo())).list();
   	     System.out.println("patientList"+patientList.size());
   	     if(patientList.size()>0)
   	     {
   	    	 
   	    	 List selfRelationList = session.createQuery("select mr.Id from MasRelation mr where mr.RelationName ='"+HMSUtil.getProperties("adt.properties", "selfRelationName")+"'").list();
   	    	
                for(Patient patient : patientList)
                {
               	 if(Integer.parseInt(selfRelationList.get(0).toString()) == patient.getRelation().getId())
               	 {
               		 patient.setPFirstName(masEmployee.getFirstName());
               		 patient.setPMiddleName(masEmployee.getMiddleName());
               		 patient.setPLastName(masEmployee.getLastName());
               		 patient.setSFirstName(masEmployee.getFirstName());
               		 patient.setSMiddleName(masEmployee.getMiddleName());
               		 patient.setSLastName(masEmployee.getLastName());
               		 patient.setDateOfBirth(masEmployee.getDateOfBirth());
               		 patient.setSrDob(masEmployee.getDateOfBirth());
               		 patient.setPhoneNumber(masEmployee.getTelNoOffice());
               		 patient.setMobileNumber(masEmployee.getCellNoEmergency());
               		 patient.setAddress(masEmployee.getLocalAddress());
               		 patient.setPermanentAddress(masEmployee.getPerAddress());
               		 patient.setBloodGroup(masEmployee.getBloodGroup());
               		 patient.setSrBloodGroup(masEmployee.getBloodGroup());
               		 patient.setSrSex(masEmployee.getGender());
               		 patient.setSex(masEmployee.getGender());
               	    
               	 }
               	 else
               	 {
               		
               		 patient.setSFirstName(masEmployee.getFirstName());
               		 patient.setSMiddleName(masEmployee.getMiddleName());
               		 patient.setSLastName(masEmployee.getLastName());                    		
               		 patient.setSrDob(masEmployee.getDateOfBirth());
               		 patient.setPhoneNumber(masEmployee.getTelNoOffice());
               		 patient.setMobileNumber(masEmployee.getCellNoEmergency());
               		 patient.setAddress(masEmployee.getLocalAddress());
               		 patient.setPermanentAddress(masEmployee.getPerAddress());  
               		 patient.setSrSex(masEmployee.getGender());
               		 patient.setSrBloodGroup(masEmployee.getBloodGroup());
               		
               	 }
             	if (rankId != 0) {
             		patient.setRank(masEmployee.getRank());
        		}
               	 hbt.update(patient);
               	 hbt.flush();
                }
   	    	
   	     }
   	        
   	     
   	     // code ends to update record in patietn table
   	     
   	     
		} catch (Exception e) {
			e.printStackTrace();
		}
		HibernateTemplate hbt=getHibernateTemplate();
		
		String filename = "";
		if(generalMap.get("filename")!= null){
			filename =(String) generalMap.get("filename");
		}
		String uploadURL = "";
		if(generalMap.get("uploadURL")!= null){
			uploadURL =(String) generalMap.get("uploadURL");
		}
		if (filename != null && !filename.equals("")) {
		System.out.println("employeeId"+employeeId);
		List<UploadDocuments> uploadDocumentsList = hbt.find("from jkt.hms.masters.business.UploadDocuments as inp where inp.Employee.Id = "+ employeeId);
		System.out.println("uploadDocumentsList"+uploadDocumentsList.size());
		for (UploadDocuments empDept : uploadDocumentsList) {
			int id = empDept.getId();
			String hql = "delete from jkt.hms.masters.business.UploadDocuments as a where a.Id = "+ id;
			Query query = session.createQuery(hql);
			int row = query.executeUpdate();
		
		}
		String fileExtension=null;
		 File file=null;
		 try { 
			
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				System.out.println(uploadURL+" -- "+filename);
				 file=new File(uploadURL + "/" + filename);
	    		 System.out.println("path>>"+file.getPath());
	    		
	    	     FileInputStream is = new FileInputStream(file);
	    	     long length = file.length();
	    	     ByteBuffer byteBuff=null;
	    	   //  int modLength=length/
	    	     if (length > Integer.MAX_VALUE) {
	            // File is too large
	    	     }
	    	     // Create the byte array to hold the data
	    	     byte[] bytes = new byte[(int)length];
	    	     int offset = 0;
	    	     int numRead = 0;
	    	     while (offset < bytes.length
	    	    		 && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
	    	    	 offset += numRead;
	    	    	
	    	     }
	    
	    	     if (offset < bytes.length) {
	    	    	 throw new IOException("Could not completely read file "+file.getName());
	    	         
	    	     }
	    	     is.close();     
	    	
	    	     
	    	     UploadDocuments document = new UploadDocuments();
	    	     document.setPatientDocument(bytes);
	    	     int indexNo = filename.lastIndexOf("."); 
	    	     String actualfileName = filename.substring(0, indexNo);
	    	     fileExtension = filename.substring(indexNo+1);
	    	     document.setFileName(actualfileName);
	    	     document.setFileExtension(fileExtension);
	    	     Date d= new Date();
	    	     document.setUploadDate(d);
	    	     if(masEmployee.getId()!=0)
	    	     {
	    	    	 
	    	    	 masEmployee.setId(masEmployee.getId());
	    	    	 document.setEmployee(masEmployee);
	    	     }
	    	     hbt.save(document);
	    	     hbt.flush();
	    	     hbt.refresh(document);
	    	     
	    	     
	    	   
	    	     
			 
	    	     dataUpdated = true;
		 }	    
		catch (Exception e) {
	    	e.printStackTrace();
	      System.err.println("Error: " + e.getMessage());
	      e.printStackTrace();
	   
		
			}	
		 }
		return dataUpdated;
	}

	public boolean deleteEmployee(int employeeId, Map<String, Object> generalMap) {

		boolean dataDeleted = false;
		Session session = (Session) getSession();
		String firstName = "";
		String lastName = "";
		String middleName = "";
		@SuppressWarnings("unused")
		String employeeCode = "";
		String serviceNo = "";
		
		int titleId = 0;
		int divisionId = 0;
		int costCenterId = 0;
		int empStatusId = 0;
		int empCategoryId = 0;
		int gradeId = 0;
		int tradeId = 0;
		int unitId = 0;
		int rankId = 0;
		int rankCategoryId=0;
		String emergencyTellNumber = "";
		//String designation = "";
		String emergencyCellNumber = "";
		String residenceTellNumber = "";
		String officeTellNumber = "";
		Date appointmentDate = new Date();
		Date joinDate = new Date();
		Date currDivisionJoiningDate=new Date();
		Date dob=new Date();
		Date halJoiningDate=new Date();
		String jobCode = "";
		String email = "";
		String bankCode = "";
		String accounthead = "";
		String bankAccountNumber = "";
		String bankAccountCode = "";
		String employeePhoto = "";
		String employeeUrl = "";
		@SuppressWarnings("unused")
		String grade = "";
		int departmentId=0;
		Date changedDate = new Date();
		String changedBy = "";
		String currentTime = "";
		Date currentDate = new Date();
		int hospitalId = 0;
		int bloodGroupId = 0;
		int sexId = 0;
		int localCountry = 0;
		int localState = 0;
		int localDistrict = 0;
		int perCountry = 0;
		int perState = 0;
		int perDistrict = 0;	
		String remarks="";
		Date contract=new Date();
		Date extension =new Date();
		String aadharCard="";
		String authorizedForHighValueMedicine="";
		String age ="";
		employeeId = (Integer) generalMap.get("id");
		hospitalId = (Integer) generalMap.get("hospitalId");
		aadharCard = (String) generalMap.get("aadharCard");
		extension= (Date) generalMap.get("extension");
		authorizedForHighValueMedicine = (String) generalMap.get("authorizedForHighValueMedicine");
		perCountry = (Integer) generalMap.get("perCountry");
		perState = (Integer) generalMap.get("perState");
		perDistrict = (Integer) generalMap.get("perDistrict");
		localCountry = (Integer) generalMap.get("localCountry");
		localState = (Integer) generalMap.get("localState");
		localDistrict = (Integer) generalMap.get("localDistrict");
		divisionId= (Integer) generalMap.get("divisionId");
		rankCategoryId= (Integer) generalMap.get("rankCategoryId");
		employeeCode = (String) generalMap.get("employeeCode");
		serviceNo = (String) generalMap.get("serviceNo");
		firstName = (String) generalMap.get("firstName");
		lastName = (String) generalMap.get("lastName");
		middleName = (String) generalMap.get("middleName");
		employeePhoto = (String) generalMap.get("employeePhoto");
		jobCode = (String) generalMap.get("jobCode");
		appointmentDate = (Date) generalMap.get("appointmentDate");
		
		currDivisionJoiningDate = (Date) generalMap.get("currDivisionJoiningDate");
		
		halJoiningDate = (Date) generalMap.get("halJoiningDate");
		
		dob = (Date) generalMap.get("dob");
		
		joinDate = (Date) generalMap.get("joinDate");
		titleId = (Integer) generalMap.get("titleId");
		gradeId = (Integer) generalMap.get("gradeId");
		//designation = (String) generalMap.get("designation");
		departmentId = (Integer) generalMap.get("departmentId");
		costCenterId = (Integer) generalMap.get("costCenterId");
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
		if(generalMap.get("bloodGroupId")!=null){
			bloodGroupId = (Integer) generalMap.get("bloodGroupId");
		}
		if(generalMap.get("sexId")!=null){
			sexId = (Integer) generalMap.get("sexId");
		}
		if(generalMap.get("age")!=null){
			age = (String) generalMap.get("age");
		}
		String departmentStr = "";
		if (generalMap.get("departmentStr") != null) {
			departmentStr = (String) generalMap.get("departmentStr");
		}
		
		
		String filename = "";
		if(generalMap.get("filename")!= null){
			filename =(String) generalMap.get("filename");
		}
		String uploadURL = "";
		if(generalMap.get("uploadURL")!= null){
			uploadURL =(String) generalMap.get("uploadURL");
		}
	
		
		StringTokenizer str = new StringTokenizer(departmentStr, ",");
		changedBy = (String) generalMap.get("changedBy");
		currentTime = (String) generalMap.get("currentTime");
		

			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			MasEmployee masEmployee = (MasEmployee) hbt.load(MasEmployee.class,	employeeId);
			System.out.println(employeeId+"employeeIdemployeeId");
			System.out.println(masEmployee.getStatus()+"masEmployee.getStatus()masEmployee.getStatus()");
			if (masEmployee.getStatus().equalsIgnoreCase("y")) {
				masEmployee.setStatus("n");
				dataDeleted = true;
				
				
				List<Users> userList = new ArrayList<Users>();
				userList = session.createCriteria(Users.class).createAlias(	"Employee", "employee").add(Restrictions.eq("employee.Id", employeeId)).list();
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
			System.out.println(dataDeleted+"dataDeleted in db");
		masEmployee.setId(employeeId);
		masEmployee.setEmployeeCode(employeeCode);
		masEmployee.setServiceNo(serviceNo);
		masEmployee.setFirstName(firstName);
		masEmployee.setLastName(lastName);
		masEmployee.setMiddleName(middleName);
		masEmployee.setAccountHead(accounthead);
		masEmployee.setBankAccountNumber(bankAccountNumber);
		masEmployee.setAadharCard(aadharCard);
		masEmployee.setBankCode(bankCode);
		masEmployee.setEmployeePhoto(employeePhoto);
		masEmployee.setUrl(employeeUrl);
		
		masEmployee.setExtensionDate(extension);
		masEmployee.setContractDate(contract);
		masEmployee.setRemarks(remarks);
		if (rankCategoryId != 0) {
			MasRankCategory masRankCategory = new MasRankCategory();
			masRankCategory.setId(rankCategoryId);
			masEmployee.setRankCategory(masRankCategory);
		}
		if (divisionId != 0) {
			MasDivision masDivision = new MasDivision();
			masDivision.setId(divisionId);
			masEmployee.setDivision(masDivision);
		}
		masEmployee.setAuthorizedForHighValueMedicine(authorizedForHighValueMedicine);
		if (perCountry != 0) {
			MasCountry masCountry = new MasCountry();
			masCountry.setId(perCountry);
			masEmployee.setPerCountry(masCountry);
		}
		
		if (localCountry != 0) {
			MasCountry masCountry = new MasCountry();
			masCountry.setId(localCountry);
			masEmployee.setLocalCountry(masCountry);
		}
		
		if (perState != 0) {
			MasState masState = new MasState();
			masState.setId(perState);
			masEmployee.setPerState(masState);
		}
		if (localState != 0) {
			MasState masState = new MasState();
			masState.setId(localState);
			masEmployee.setLocalState(masState);
		}
		
		
		if (perDistrict != 0) {
			MasDistrict masDistrict = new MasDistrict();
			masDistrict.setId(perDistrict);
			masEmployee.setPerDistrict(masDistrict);
		}
		if (localDistrict != 0) {
			MasDistrict masDistrict = new MasDistrict();
			masDistrict.setId(localDistrict);
			masEmployee.setLocalDistrict(masDistrict);
		}
		
		MasHospital hospital = new MasHospital();
		hospital.setId(hospitalId);
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
		if (empStatusId != 0) {
			MasEmpStatus masEmpStatus = new MasEmpStatus();
			masEmpStatus.setId(empStatusId);
			masEmployee.setEmployeeStatus(masEmpStatus);
		}
		if (costCenterId != 0) {
			MasCostCenter masCostCenter = new MasCostCenter();
			masCostCenter.setId(costCenterId);
			masEmployee.setCostCenter(masCostCenter);
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
		if (bloodGroupId != 0) {
			MasBloodGroup masBloodGroup = new MasBloodGroup();
			masBloodGroup.setId(bloodGroupId);
			masEmployee.setBloodGroup(masBloodGroup);
		}
		System.out.println(sexId);
		if (sexId != 0) {
			MasAdministrativeSex sex = new MasAdministrativeSex();
			sex.setId(sexId);
			masEmployee.setGender(sex);
		}
		if(!age.equals("")){
			masEmployee.setAge(age);
		}
		if(generalMap.get("localAddress")!=null) {
			masEmployee.setLocalAddress((String)generalMap.get("localAddress"));
		}
		if(generalMap.get("perAddress")!=null) {
			masEmployee.setPerAddress((String)generalMap.get("perAddress"));
		}
		if(generalMap.get("roomNo")!=null) {
			masEmployee.setRoomNo((Integer)generalMap.get("roomNo"));
		}
		//masEmployee.setDesignation(designation);
		masEmployee.setJobCode(jobCode);
		masEmployee.setAppointmentDate(appointmentDate);
		masEmployee.setEmail(email);
		masEmployee.setCurrentDivisionJoinDate(currDivisionJoiningDate);
		masEmployee.setHalJoinDate(halJoiningDate);
		masEmployee.setDateOfBirth(dob);
		
		masEmployee.setTelNoEmergency(emergencyTellNumber);
		masEmployee.setCellNoEmergency(emergencyCellNumber);
		masEmployee.setTelNoResidence(residenceTellNumber);
		masEmployee.setTelNoOffice(officeTellNumber);
		masEmployee.setJoinDate(joinDate);
		masEmployee.setBankAccountCode(bankAccountCode);
		//masEmployee.setStatus("y");
		masEmployee.setLastChgBy(changedBy);
		masEmployee.setLastChgDate(currentDate);
		masEmployee.setLastChgTime(currentTime);
		try {
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			MasRank masRank = null;
			if(masEmployee.getRank()!=null){
				masRank = (MasRank)hbt.load(MasRank.class, masEmployee.getRank().getId());
				masEmployee.setServiceType(masRank.getServiceType());
				
			}
			hbt.update(masEmployee);
			hbt.refresh(masEmployee);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		 return dataDeleted;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchEmployee(String serviceNo,
			String firstName, String lastName,int hospitalId) {

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
		List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		List<UploadDocuments> uploadDocuments = new ArrayList<UploadDocuments>();
		Session session= getSession();
		try {
			if ((serviceNo != null) && (firstName == null)
					&& (lastName == null)) {
			/*	searchEmployeeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasEmployee as  me where me.Hospital.Id="+hospitalId+" and  me.ServiceNo like '%"
								+ serviceNo + "%' order by me.ServiceNo");*/
				
				searchEmployeeList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.like("ServiceNo","%" +serviceNo+"%")).addOrder(Order.asc("ServiceNo")).list();
				
				
			} else if ((serviceNo == null) && (firstName != null)
					&& (lastName == null)) {
				/*searchEmployeeList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasEmployee as me where  me.Hospital.Id="+hospitalId+" and  UPPER(me.FirstName) like '%"
										+ firstName.toUpperCase()
										+ "%' order by me.FirstName");*/
			
				
				searchEmployeeList=session.createCriteria(MasEmployee.class)./*add(Restrictions.eq("UPPER(FirstName)", firstName.toUpperCase()))*/
			
						add(Restrictions.like("FirstName","%"+ firstName+"%").ignoreCase()).addOrder(Order.asc("FirstName")).list();
				//uploadDocuments=session.createCriteria(UploadDocuments.class).list();
				// userIdList =
				// session.createCriteria(Users.class).add(Restrictions.eg("LoginName",
				// loginName)).add(Restrictions.eq("Password",
				// password)).list();
			} else if ((serviceNo == null) && (firstName == null)
					&& (lastName != null)) {
				/*searchEmployeeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasEmployee me where  me.Hospital.Id="+hospitalId+" and  UPPER(me.LastName) like '%"
								+ lastName.toUpperCase()
								+ "%' order by me.LastName");*/
				searchEmployeeList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("LastName", lastName).ignoreCase())
				.addOrder(Order.asc("LastName")).list();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		gridUnitList=session.createCriteria(MasUnit.class).list();
		titleList=session.createCriteria(MasTitle.class).add(Restrictions.eq("Status", "y")).list();
		departmentList=session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
		costCenterList=session.createCriteria(MasCostCenter.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("CostCenterName")).list();
		empStatusList=session.createCriteria(MasEmpStatus.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("EmpStatusName")).list();
		empCategoryList=session.createCriteria(MasEmpCategory.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("EmpCategoryName")).list();
		empStatusList=session.createCriteria(MasEmpStatus.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("EmpStatusName")).list();
		//searchEmployeeList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Hospital.Id", hospitalId)).list();
		gradeList=session.createCriteria(MasGrade.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("GradeName")).list();
		rankList=session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankName")).list();
		unitList=session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("UnitName")).list();
		tradeList=session.createCriteria(MasTrade.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("TradeName")).list();
		bloodGroupList = session.createCriteria(MasBloodGroup.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("BloodGroupName")).list();
		sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AdministrativeSexName")).list();
		hospitalList= session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("HospitalName")).list();
/*		
 * gridUnitList = getHibernateTemplate().find(
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
		
		bloodGroupList = session.createCriteria(MasBloodGroup.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("BloodGroupName")).list();
		
		sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AdministrativeSexName")).list();
		*/

		for(int e=0; e<searchEmployeeList.size(); e++)
		{
			
				searchEmployeeList.get(0).setPerAddress(searchEmployeeList.get(0).getPerAddress());
				searchEmployeeList.get(0).setLocalAddress(searchEmployeeList.get(0).getLocalAddress());
			
		
			/*try {
			
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
		}
		 
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
		employeeFieldsMap.put("bloodGroupList", bloodGroupList);
		employeeFieldsMap.put("sexList", sexList);
		employeeFieldsMap.put("hospitalList", hospitalList);
		employeeFieldsMap.put("uploadDocuments", uploadDocuments);
		return employeeFieldsMap;
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
		//Integer serviceTypeId = masRank.getServiceType().getId();
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			/*List serviceTypeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasServiceType as isc where isc.Id='"
							+ rankId + "' and isc.Status='y'");
			*/List rankCategoryList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasRankCategory as isc where isc.Id='"
							+ rankId + "' and isc.Status='y'");
			/*List serviceStatusList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasServiceStatus as isc where isc.Id='"
							+ rankId + "' and isc.Status='y'");
			*/if (flag.equals("InActivate")) {
				masRank.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masRank.setStatus("y");
				dataDeleted = false;
			}
		}
		masRank.setLastChgBy(changedBy);
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
		//int serviceTypeId = 0;
		int rankCategoryId = 0;
		//int serviceStatusId = 0;
		int rankId = 0;
		String rankName = "";
		@SuppressWarnings("unused")
		String rankCode = "";
		String changedBy = "";
		rankId = (Integer) generalMap.get("id");
		rankCode = (String) generalMap.get("rankCode");
		rankName = (String) generalMap.get("name");
		//serviceStatusId = (Integer) generalMap.get("serviceStatusId");
		//serviceTypeId = (Integer) generalMap.get("serviceTypeId");
		rankCategoryId = (Integer) generalMap.get("rankCategoryId");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasRank masRank = (MasRank) getHibernateTemplate().load(MasRank.class,
				rankId);

		masRank.setId(rankId);
		masRank.setRankName(rankName);
/*
		MasServiceStatus masServiceStatus = new MasServiceStatus();
		masServiceStatus.setId(serviceStatusId);
		masRank.setServiceStatus(masServiceStatus);

		MasServiceType masServiceType = new MasServiceType();
		masServiceType.setId(serviceTypeId);
		masRank.setServiceType(masServiceType);*/

		MasRankCategory masRankCategory = new MasRankCategory();
		masRankCategory.setId(rankCategoryId);
		masRank.setRankCategory(masRankCategory);

		masRank.setLastChgBy(changedBy);
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
		List serviceTypeList = null;
		List serviceStatusList = null;
		List rankCategoryList = null;
		Map<String, Object> rankFieldsMap = new HashMap<String, Object>();
		List gridServiceTypeList = null;
		try {
			if ((rankName != null) || (rankCode == null)) {
				searchRankList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasRank as i where i.RankName like '"
								+ rankName + "%' order by i.RankName");
			} else {
				searchRankList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasRank as i where i.RankCode like '"
								+ rankCode + "%' order by i.RankCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		serviceTypeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasServiceType as isc where isc.Status = 'y'");
		serviceStatusList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasServiceStatus as isc where isc.Status = 'y'");
		rankCategoryList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasRankCategory as isc where isc.Status = 'y'");
		gridServiceTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasServiceType as isc");
		rankFieldsMap.put("gridServiceTypeList", gridServiceTypeList);
		rankFieldsMap.put("searchRankList", searchRankList);
		rankFieldsMap.put("serviceTypeList", serviceTypeList);
		rankFieldsMap.put("serviceStatusList", serviceStatusList);
		rankFieldsMap.put("rankCategoryList", rankCategoryList);
		return rankFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showRankJsp() {
		Map<String, Object> map = new HashMap<String, Object>();

		List<MasRank> searchRankList = new ArrayList<MasRank>();
		List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		List<MasServiceType> gridServiceTypeList = new ArrayList<MasServiceType>();
		List<MasRankCategory> rankCategoryList = new ArrayList<MasRankCategory>();
		List<MasServiceStatus> serviceStatusList = new ArrayList<MasServiceStatus>();
		Session session= getSession();
		/*searchRankList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasRank ");*/
		searchRankList =session.createCriteria(MasRank.class).list();
		
		/*gridServiceTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasServiceType as isc");*/
		gridServiceTypeList =session.createCriteria(MasServiceType.class).list();
		
		serviceTypeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasServiceType as isc where isc.Status = 'y' order by isc.ServiceTypeName asc");
		
		//serviceTypeList =sess
		rankCategoryList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasRankCategory as isc where isc.Status = 'y' order by isc.RankCategoryName asc");
		serviceStatusList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasServiceStatus as isc where isc.Status = 'y' order by isc.ServiceStatusName asc");

		map.put("searchRankList", searchRankList);
		map.put("serviceTypeList", serviceTypeList);
		map.put("gridServiceTypeList", gridServiceTypeList);
		map.put("rankCategoryList", rankCategoryList);
		map.put("serviceStatusList", serviceStatusList);
		return map;
	}

	// ---------------------------------------- Formation
	// ---------------------------------
	public boolean addFormation(MasFormation masFormation) {

		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masFormation);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteFormation(int formationId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		MasFormation masFormation = new MasFormation();
		masFormation = (MasFormation) getHibernateTemplate().load(
				MasFormation.class, formationId);
		@SuppressWarnings("unused")
		Integer serviceTypeId = masFormation.getServiceType().getId();
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (masFormation.getStatus().equals("y")) {
			@SuppressWarnings("unused")
			List serviceTypeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasServiceType as isc where isc.Id='"
							+ formationId + "' and isc.Status='y'");
			masFormation.setStatus("n");
			dataDeleted = true;
		} else {
			masFormation.setStatus("y");
			dataDeleted = false;
		}
		masFormation.setLastChgBy(changedBy);
		masFormation.setLastChgDate(currentDate);
		masFormation.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masFormation);
		return dataDeleted;

	}

	public boolean editFormationToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int serviceTypeId = 0;
		String formationName = "";
		@SuppressWarnings("unused")
		String formationCode = "";
		int formationId = 0;
		String changedBy = "";
		formationId = (Integer) generalMap.get("id");
		formationCode = (String) generalMap.get("formationCode");
		formationName = (String) generalMap.get("name");
		serviceTypeId = (Integer) generalMap.get("serviceTypeId");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasFormation masFormation = (MasFormation) getHibernateTemplate().load(
				MasFormation.class, formationId);

		masFormation.setId(formationId);
		masFormation.setFormationName(formationName);
		MasServiceType masServiceType = new MasServiceType();
		masServiceType.setId(serviceTypeId);
		masFormation.setServiceType(masServiceType);
		masFormation.setLastChgBy(changedBy);
		masFormation.setLastChgDate(currentDate);
		masFormation.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masFormation);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchFormation(String formationCode,
			String formationName) {
		List<MasFormation> searchFormationList = new ArrayList<MasFormation>();
		List serviceTypeList = null;
		Map<String, Object> formationFieldsMap = new HashMap<String, Object>();
		List gridServiceTypeList = null;
		try {
			if ((formationName != null) || (formationCode == null)) {
				searchFormationList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasFormation as i where i.FormationName like '"
										+ formationName
										+ "%' order by i.FormationName");
			} else {
				searchFormationList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasFormation as i where i.FormationCode like '"
										+ formationCode
										+ "%' order by i.FormationCode");
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchFormationList  " + e);
		}
		serviceTypeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasServiceType as isc where isc.Status = 'y'");
		gridServiceTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasServiceType as isc");
		formationFieldsMap.put("gridServiceTypeList", gridServiceTypeList);
		formationFieldsMap.put("searchFormationList", searchFormationList);
		formationFieldsMap.put("serviceTypeList", serviceTypeList);
		return formationFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showFormationJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasFormation> searchFormationList = new ArrayList<MasFormation>();
		List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		List<MasServiceType> gridServiceTypeList = new ArrayList<MasServiceType>();
		searchFormationList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasFormation ");
		gridServiceTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasServiceType as isc");
		serviceTypeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasServiceType as isc where isc.Status = 'y'  order by isc.ServiceTypeName asc");
		map.put("searchFormationList", searchFormationList);
		map.put("serviceTypeList", serviceTypeList);
		map.put("gridServiceTypeList", gridServiceTypeList);
		return map;
	}

	// --------------------------------------------Trade------------------------------
	public boolean addTrade(MasTrade masTrade) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masTrade);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteTrade(int tradeId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasTrade masTrade = new MasTrade();
		masTrade = (MasTrade) getHibernateTemplate().load(MasTrade.class,
				tradeId);
		@SuppressWarnings("unused")
		Integer serviceTypeId = masTrade.getServiceType().getId();
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (masTrade.getStatus().equals("y")) {
			@SuppressWarnings("unused")
			List serviceTypeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasServiceType as isc where isc.Id='"
							+ tradeId + "' and isc.Status='y'");
			masTrade.setStatus("n");
			dataDeleted = true;
		} else {
			masTrade.setStatus("y");
			dataDeleted = false;
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

	public boolean editTradeToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int serviceTypeId = 0;
		String tradeName = "";
		@SuppressWarnings("unused")
		int tradeId = 0;
		String changedBy = "";
		tradeId = (Integer) generalMap.get("id");
		tradeName = (String) generalMap.get("name");
		serviceTypeId = (Integer) generalMap.get("serviceTypeId");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasTrade masTrade = (MasTrade) getHibernateTemplate().load(
				MasTrade.class, tradeId);
		masTrade.setId(tradeId);
		masTrade.setTradeName(tradeName);
		MasServiceType masServiceType = new MasServiceType();
		masServiceType.setId(serviceTypeId);
		masTrade.setServiceType(masServiceType);
		masTrade.setLastChgBy(changedBy);
		masTrade.setLastChgDate(currentDate);
		masTrade.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masTrade);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchTrade(String tradeName) {
		List<MasTrade> searchTradeList = new ArrayList<MasTrade>();
		List<MasServiceType> serviceTypeList = null;
		Map<String, Object> tradeFieldsMap = new HashMap<String, Object>();
		List<MasServiceType> gridServiceTypeList = null;
		try {
			if (tradeName != null) {
				searchTradeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasTrade as i where i.TradeName like '"
								+ tradeName + "%' order by i.TradeName");
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchTradeList  " + e);
		}

		serviceTypeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasServiceType as isc where isc.Status = 'y'");
		gridServiceTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasServiceType as isc");
		tradeFieldsMap.put("gridServiceTypeList", gridServiceTypeList);
		tradeFieldsMap.put("searchTradeList", searchTradeList);
		tradeFieldsMap.put("serviceTypeList", serviceTypeList);
		return tradeFieldsMap;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showTradeJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasTrade> searchTradeList = new ArrayList<MasTrade>();
		List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		List<MasServiceType> gridServiceTypeList = new ArrayList<MasServiceType>();

		searchTradeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasTrade ");
		gridServiceTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasServiceType as isc");
		serviceTypeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasServiceType as isc where isc.Status = 'y'  order by isc.ServiceTypeName asc");
		map.put("searchTradeList", searchTradeList);
		map.put("serviceTypeList", serviceTypeList);
		map.put("gridServiceTypeList", gridServiceTypeList);
		return map;
	}

	// ---------------------------------------------Unit
	// -------------------------------------------
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
		@SuppressWarnings("unused")
		String unitAddress = "";
		int unitId = 0;
		int stationId=0;
		String local = "";
		String changedBy = "";
		unitId = (Integer) generalMap.get("id");
		unitAddress = (String) generalMap.get("unitAddress");
		stationId = (Integer) generalMap.get("stationId");
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
		
		MasStation station = new MasStation();
		station.setId(stationId);
		masUnit.setStation(station);
		
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
		List<MasStation> stationList = new ArrayList<MasStation>();
		List<MasStation> gridStationList = new ArrayList<MasStation>();
		Map<String, Object> unitFieldsMap = new HashMap<String, Object>();
		try {
			if ((unitName != null)) {
				searchUnitList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasUnit imc where imc.UnitName like '"
								+ unitName + "%' order by imc.UnitName");
			}
			gridStationList = getHibernateTemplate().find("from jkt.hms.masters.business.MasStation as isc");
			stationList = getHibernateTemplate().find("from jkt.hms.masters.business.MasStation as isc where isc.Status = 'y'");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		unitFieldsMap.put("stationList", stationList);
		unitFieldsMap.put("gridStationList", gridStationList);
		unitFieldsMap.put("searchUnitList", searchUnitList);
		return unitFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showUnitJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasUnit> searchUnitList = new ArrayList<MasUnit>();
		
		List<MasStation> stationList = new ArrayList<MasStation>();
		List<MasStation> gridStationList = new ArrayList<MasStation>();
		searchUnitList = getHibernateTemplate().find("from jkt.hms.masters.business.MasUnit ");
		gridStationList = getHibernateTemplate().find("from jkt.hms.masters.business.MasStation as isc");
		stationList = getHibernateTemplate().find("from jkt.hms.masters.business.MasStation as isc where isc.Status = 'y'");
		map.put("stationList", stationList);
		map.put("gridStationList", gridStationList);
		map.put("searchUnitList", searchUnitList);
		return map;
	}

	// ----------------------------------RecordOfficeAddress------------------------------------------
	public Map<String, Object> showRecordOfficeAddressJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRecordOfficeAddress> searchRecordOfficeAddressList = new ArrayList<MasRecordOfficeAddress>();
		List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		List<MasServiceType> gridServiceTypeList = new ArrayList<MasServiceType>();

		searchRecordOfficeAddressList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasRecordOfficeAddress ");
		gridServiceTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasServiceType as isc");
		serviceTypeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasServiceType as isc where isc.Status = 'y'  order by isc.ServiceTypeName asc");
		map.put("searchRecordOfficeAddressList", searchRecordOfficeAddressList);
		map.put("serviceTypeList", serviceTypeList);
		map.put("gridServiceTypeList", gridServiceTypeList);
		return map;
	}

	public boolean addRecordOfficeAddress(
			MasRecordOfficeAddress masRecordOfficeAddress) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masRecordOfficeAddress);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteRecordOfficeAddress(int recordOfficeAddressId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasRecordOfficeAddress masRecordOfficeAddress = new MasRecordOfficeAddress();
		masRecordOfficeAddress = (MasRecordOfficeAddress) getHibernateTemplate()
				.load(MasRecordOfficeAddress.class, recordOfficeAddressId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		@SuppressWarnings("unused")
		Integer serviceTypeId = masRecordOfficeAddress.getServiceType().getId();
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (masRecordOfficeAddress.getStatus().equals("y")) {
			@SuppressWarnings("unused")
			List serviceTypeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasServiceType as isc where isc.Id='"
							+ recordOfficeAddressId + "' and isc.Status='y'");
			masRecordOfficeAddress.setStatus("n");
			dataDeleted = true;
		} else {
			masRecordOfficeAddress.setStatus("y");
			dataDeleted = false;
		}
		masRecordOfficeAddress.setLastChgBy(changedBy);
		masRecordOfficeAddress.setLastChgDate(currentDate);
		masRecordOfficeAddress.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masRecordOfficeAddress);
		return dataDeleted;
	}

	public boolean editRecordOfficeAddress(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int serviceTypeId = 0;
		String recordOfficeAddress = "";
		@SuppressWarnings("unused")
		int recordOfficeAddressId = 0;
		String changedBy = "";
		recordOfficeAddressId = (Integer) generalMap.get("id");
		recordOfficeAddress = (String) generalMap.get("name");
		serviceTypeId = (Integer) generalMap.get("serviceTypeId");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasRecordOfficeAddress masRecordOfficeAddress = (MasRecordOfficeAddress) getHibernateTemplate()
				.load(MasRecordOfficeAddress.class, recordOfficeAddressId);
		masRecordOfficeAddress.setId(recordOfficeAddressId);
		masRecordOfficeAddress.setAddress(recordOfficeAddress);
		MasServiceType masServiceType = new MasServiceType();
		masServiceType.setId(serviceTypeId);
		masRecordOfficeAddress.setServiceType(masServiceType);
		masRecordOfficeAddress.setLastChgBy(changedBy);
		masRecordOfficeAddress.setLastChgDate(currentDate);
		masRecordOfficeAddress.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masRecordOfficeAddress);
		dataUpdated = true;
		return dataUpdated;
	}

	public Map<String, Object> searchRecordOfficeAddress(
			String recordOfficeAddress) {
		List<MasUnit> searchRecordOfficeAddressList = new ArrayList<MasUnit>();
		Map<String, Object> recordOfficeAddressFieldsMap = new HashMap<String, Object>();
		List serviceTypeList = new ArrayList();
		List gridServiceTypeList = null;
		try {
			if ((recordOfficeAddress != null)) {
				searchRecordOfficeAddressList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasRecordOfficeAddress imc where imc.Address like '"
										+ recordOfficeAddress
										+ "%' order by imc.Address");
			}
		} catch (Exception e) {
			System.out
					.println("Ds excp in searchRecordOfficeAddressList  " + e);
		}
		serviceTypeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasServiceType as md where md.Status = 'y' ");
		gridServiceTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasServiceType as isc");
		recordOfficeAddressFieldsMap.put("searchRecordOfficeAddressList",
				searchRecordOfficeAddressList);
		recordOfficeAddressFieldsMap.put("serviceTypeList", serviceTypeList);
		recordOfficeAddressFieldsMap.put("gridServiceTypeList",
				gridServiceTypeList);
		return recordOfficeAddressFieldsMap;
	}

	// ------------------------------- Rank Category
	// -------------------------------------------

	public Map<String, Object> showRankCategoryJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRankCategory> searchRankCategoryList = new ArrayList<MasRankCategory>();
		Session session=(Session)getSession();
		/*searchRankCategoryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasRankCategory ");
		*/
		searchRankCategoryList=session.createCriteria(MasRankCategory.class).list();
		map.put("searchRankCategoryList", searchRankCategoryList);
		return map;
	}

	public Map<String, Object> searchRankCategory(String rankCategoryCode,
			String rankCategoryName) {
		List<MasRankCategory> searchRankCategoryList = new ArrayList<MasRankCategory>();
		Map rankCategoryFieldsMap = new HashMap();
		Session session=(Session)getSession();
		try {
			if ((rankCategoryName != null) || (rankCategoryCode == null)) {
				/*searchRankCategoryList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasRankCategory sc where sc.RankCategoryName like '"
										+ rankCategoryName
										+ "%' order by sc.RankCategoryName");
				
				
				*/
				searchRankCategoryList=session.createCriteria(MasRankCategory.class)
				.add(Restrictions.like("RankCategoryName","%"+ rankCategoryName+"%"))
				.addOrder(Order.asc("RankCategoryName")).list();
				
			} else {
				/*searchRankCategoryList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasRankCategory sc where sc.RankCategoryCode like '"
										+ rankCategoryCode
										+ "%' order by sc.RankCategoryCode");
				*/
				searchRankCategoryList=session.createCriteria(MasRankCategory.class).add(Restrictions.like("RankCategoryCode","%"+rankCategoryCode+"%"))
.addOrder(Order.asc("RankCategoryCode")).list();
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchMajorCategoryCode  " + e);
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

	// ------------------------Brand Master----------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> showBrandJspOld(Box box) {
		//System.out.println("Box  " + box);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = null;

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreBrand> searchBrandList = new ArrayList<MasStoreBrand>();
		List<MasStoreItem> masStoreItemList = new ArrayList<MasStoreItem>();

		// List<MasStoreItem> itemList=new ArrayList<MasStoreItem>();
		List<MasManufacturer> manufacturerList = new ArrayList<MasManufacturer>();

		session = (Session) getSession();
		String qry = "select substring(brand_code,2,10) as number1, brand_code from mas_store_brand order by number1";
		List objectList = (List) session.createSQLQuery(qry).list();
		if (objectList != null && objectList.size() > 0) {
			Object[] pair = (Object[]) objectList.get(objectList.size() - 1);
			int no = Integer.parseInt(pair[0].toString()) + 1;
			String brand_code = "B" + no;
			map.put("brand_code", brand_code);
		} else
			map.put("brand_code", "B1");

		if (box.getInt("itemId") != 0) {
			searchBrandList = hbt
					.find("from jkt.hms.masters.business.MasStoreBrand as m where m.Item.Id = "
							+ box.getInt("itemId"));
			// searchBrandList =
			// session.createCriteria(MasStoreBrand.class).add(Restrictions.eq("Item",box.getInt("itemId"))).list();
			masStoreItemList = hbt
					.find("from jkt.hms.masters.business.MasStoreItem as m where m.Id = "
							+ box.getInt("itemId"));
			// masStoreItemList =
			// session.createCriteria(MasStoreItem.class).add(Restrictions.eq("Id",box.getInt("itemId"))).list();
			String nomenclature = masStoreItemList.get(0).getNomenclature()
					+ "[" + masStoreItemList.get(0).getPvmsNo() + "]";
			//System.out.println("nomenwwww "+nomenclature);
			map.put("nomenclature", nomenclature);
			map.put("itemIdForManufaturer", box.getInt("itemId"));

		} else
			searchBrandList = hbt
					.find("from jkt.hms.masters.business.MasStoreBrand as m ");
		// itemList=getHibernateTemplate().find("from jkt.hms.masters.business.MasStoreItem as sc");
		manufacturerList = hbt
				.find("from jkt.hms.masters.business.MasManufacturer as mm order by mm.ManufacturerName");
		
		map.put("searchBrandList", searchBrandList);
		// map.put("itemList",itemList);
		map.put("manufacturerList", manufacturerList);
		//System.out.println("item ===99=="+box.getString("itemName"));
		map.put("nomenclature", box.getString("itemName"));
		return map;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> showBrandJsp(Box box) {
		//System.out.println("Box  " + box);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = null;

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreBrand> searchBrandList = new ArrayList<MasStoreBrand>();

		session = (Session) getSession();
			searchBrandList = hbt
					.find("from jkt.hms.masters.business.MasStoreBrand as m ");
		
		map.put("searchBrandList", searchBrandList);
		return map;
	}

	/*public Map<String, Object> searchBrandOld(String brandCode, String brandName) {
		List<MasStoreBrand> searchBrandList = new ArrayList<MasStoreBrand>();
		List<MasManufacturer> manufacturerList = new ArrayList<MasManufacturer>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		Map brandFieldsMap = new HashMap();
		try {
			if ((brandName != null) || (brandCode == null)) {
				searchBrandList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasStoreBrand as sc where sc.BrandName like '"
								+ brandName + "%' order by sc.BrandName");
			} else {
				searchBrandList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasStoreBrand as sc where sc.BrandCode like '"
								+ brandCode + "%' order by sc.BrandCode");
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchBrandList  " + e);
		}
		manufacturerList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasManufacturer as sc");
		itemList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasStoreItem as sc");

		brandFieldsMap.put("searchBrandList", searchBrandList);
		brandFieldsMap.put("manufacturerList", manufacturerList);
		brandFieldsMap.put("itemList", itemList);
		return brandFieldsMap;
	}*/
	public Map<String, Object> searchBrand(String brandCode, String brandName) {
		List<MasStoreBrand> searchBrandList = new ArrayList<MasStoreBrand>();
		Map brandFieldsMap = new HashMap();
		try {
			if ((brandName != null) || (brandCode == null)) {
				searchBrandList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasStoreBrand as sc where sc.BrandName like '"
								+ brandName + "%' order by sc.BrandName");
			} else {
				searchBrandList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasStoreBrand as sc where sc.BrandCode like '"
								+ brandCode + "%' order by sc.BrandCode");
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchBrandList  " + e);
		}
		brandFieldsMap.put("searchBrandList", searchBrandList);
		return brandFieldsMap;
	}
	/*public boolean editBrandToDatabaseOld(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		int itemGenericId = 0;
		int manufacturerId = 0;
		int itemId = 0;
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String brandName = "";
		@SuppressWarnings("unused")
		String brandCode = "";
		int brandId = 0;
		String changedBy = "";
		brandId = (Integer) generalMap.get("id");
		brandCode = (String) generalMap.get("brandCode");
		brandName = (String) generalMap.get("name");
		// itemGenericId=(Integer)generalMap.get("itemGenericId");
		manufacturerId = (Integer) generalMap.get("manufacturerId");
		itemId = (Integer) generalMap.get("itemId");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasStoreBrand masBrand = (MasStoreBrand) getHibernateTemplate().get(
				MasStoreBrand.class, brandId);

		masBrand.setId(brandId);
		masBrand.setBrandName(brandName);

		MasStoreItem masStoreItem = new MasStoreItem();
		masStoreItem.setId(itemId);
		masBrand.setItem(masStoreItem);

		MasManufacturer masManufacturer = new MasManufacturer();
		masManufacturer.setId(manufacturerId);
		masBrand.setManufacturer(masManufacturer);

		
		 * MasStoreItemGeneric masStoreItemGeneric= new MasStoreItemGeneric();
		 * masStoreItemGeneric.setId(itemGenericId);
		 * masBrand.setItemGeneric(masStoreItemGeneric);
		 

		masBrand.setLastChgBy(changedBy);
		masBrand.setLastChgDate(currentDate);
		masBrand.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();

		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masBrand);
		hbt.refresh(masBrand);
		dataUpdated = true;
		return dataUpdated;
	}*/
	public boolean editBrandToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String brandName = "";
		@SuppressWarnings("unused")
		String brandCode = "";
		int brandId = 0;
		String changedBy = "";
		brandId = (Integer) generalMap.get("id");
		brandCode = (String) generalMap.get("brandCode");
		brandName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasStoreBrand masBrand = (MasStoreBrand) getHibernateTemplate().get(
				MasStoreBrand.class, brandId);

		masBrand.setId(brandId);
		masBrand.setBrandName(brandName);
		masBrand.setLastChgBy(changedBy);
		masBrand.setLastChgDate(currentDate);
		masBrand.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();

		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masBrand);
		hbt.refresh(masBrand);
		dataUpdated = true;
		return dataUpdated;
	}
	public boolean addBrand(MasStoreBrand masBrand) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masBrand);
		hbt.refresh(masBrand);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteBrand(int brandId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasStoreBrand masBrand = new MasStoreBrand();
		masBrand = (MasStoreBrand) getHibernateTemplate().get(
				MasStoreBrand.class, brandId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		if (masBrand.getStatus().equals("y")) {
			masBrand.setStatus("n");
			dataDeleted = true;
		} else {
			masBrand.setStatus("y");
			dataDeleted = false;
		}
		masBrand.setLastChgBy(changedBy);
		masBrand.setLastChgDate(currentDate);
		masBrand.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masBrand);
		return dataDeleted;
	}

	public Map<String, Object> getConnection() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		map.put("conn", con);
		return map;
	}

	public int getItemId(String pvms) {
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		itemList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasStoreItem as sc where sc.PvmsNo ='"
						+ pvms + "'");
		MasStoreItem masStoreItem = (MasStoreItem) itemList.get(0);
		int itemId = masStoreItem.getId();
		return itemId;
	}

	// add by kalyan
	@SuppressWarnings("unchecked")
	public Map<String, Object> generateEmployeeLogin(int employeeDependentId,
			Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		String dataStatus = "";
		Session session = (Session) getSession();
		Transaction tx = null;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		String fname = "";
		String mname = "";
		String lname = "";
		String service = null;
		String status = null;
		int departmentId = 0;
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		fname = (String) generalMap.get("fname");
		mname = (String) generalMap.get("mname");
		lname = (String) generalMap.get("lname");
		service = (String) generalMap.get("service");
		if (generalMap.get("departmentId") != null)
			departmentId = Integer
					.parseInt("" + generalMap.get("departmentId"));
		try {
			tx = session.beginTransaction();
			List<Users> userList = new ArrayList<Users>();
			userList = session.createCriteria(Users.class).add(
					Restrictions.eq("LoginName", service)).list();

			if (userList.size() == 0) {
				Users user = new Users();

				HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);

				user.setLoginName(service);
				user.setUserName(fname + "" + mname + "" + lname);
				// user.setPassword(service);
				user.setPassword(HMSUtil.encryptPassword(service));
				user.setEmployee(new MasEmployee(employeeDependentId));
				user.setStatus("y");
				user.setLastChgBy(changedBy);
				user.setLastChgDate(currentDate);
				user.setLastChgTime(currentTime);
				hbt.save(user);

				// Block for adding record into user department
				if (departmentId != 0) {
					UserDepartment userDepartment = new UserDepartment();
					userDepartment.setUser(user);
					userDepartment
							.setDepartment(new MasDepartment(departmentId));
					userDepartment.setStatus("y");
					hbt.save(userDepartment);
				}

				// Block for adding User Hospital Maintenence

				UserUsergroupHospital masUserUsergroupHospital = new UserUsergroupHospital();

				masUserUsergroupHospital.setUser(user);
				masUserUsergroupHospital
						.setGroupHospital(new UsergroupHospital(4));
				// masUserUsergroupHospital.setValidUpto(validUpto);
				masUserUsergroupHospital.setStatus("y");
				masUserUsergroupHospital.setLastChgBy(changedBy);
				masUserUsergroupHospital.setLastChgDate(currentDate);
				masUserUsergroupHospital.setLastChgTime(currentTime);
				hbt.save(masUserUsergroupHospital);
				hbt.refresh(masUserUsergroupHospital);
				masUserUsergroupHospital = new UserUsergroupHospital();
				List<GroupApplication> groupApplicationList = hbt
						.find("from jkt.hms.masters.business.GroupApplication as mc where mc.Group.Id=12 or mc.Group.Id =1 and mc.App.Id ='A345' or mc.App.Id = 'A324'");
				for (Iterator iterator = groupApplicationList.iterator(); iterator
						.hasNext();) {
					GroupApplication groupApplication = (GroupApplication) iterator
							.next();
					UserUsergroupApplication userUsergroupApplication = new UserUsergroupApplication();
					userUsergroupApplication.setGroupApp(groupApplication);

					List<UsergroupHospital> usergroupHospList = new ArrayList<UsergroupHospital>();
					usergroupHospList = session.createCriteria(
							UsergroupHospital.class).add(
							Restrictions.eq("Group.Id", groupApplication
									.getGroup().getId())).list();

					int groupHosp = 4;
					if (usergroupHospList.size() > 0) {
						UsergroupHospital usergroupHSP = (UsergroupHospital) usergroupHospList
								.get(0);
						groupHosp = usergroupHSP.getId();
					}

					userUsergroupApplication
							.setGroupHospital(new UsergroupHospital(groupHosp));
					userUsergroupApplication.setUser(user);
					userUsergroupApplication.setStatus("y");
					hbt.save(userUsergroupApplication);
					hbt.refresh(userUsergroupApplication);
				}
				tx.commit();
				dataStatus = "login user has been created successfully for"
						+ service;
			} else if (userList.size() > 0) {
				dataStatus = "login user already Exist";
			}
			map.put("dataStatus", dataStatus);
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			//System.out.println("exc in DS " + e);
		}
		// return dataDeleted;
		return map;
	}

	// end kalyan
	
	public boolean addMedicalCategory(MasMedicalCategory masMedicalCategory) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masMedicalCategory);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public Map<String, Object> showMedicalCategoryJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasMedicalCategory> searchMedicalCategoryList = new ArrayList<MasMedicalCategory>();
		searchMedicalCategoryList = getHibernateTemplate().find("from jkt.hms.masters.business.MasMedicalCategory ");
		map.put("searchMedicalCategoryList", searchMedicalCategoryList);
		return map;
	
	}

	public boolean editMedicalCategory(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String rankCategoryName = "";
		@SuppressWarnings("unused")
		String medicalCategoryName = "";
		int medicalCategoryId = 0;
		String changedBy = "";
		medicalCategoryId = (Integer) generalMap.get("id");
		medicalCategoryName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasMedicalCategory masMedicalCategory= (MasMedicalCategory) getHibernateTemplate().get(MasMedicalCategory.class, medicalCategoryId);

		masMedicalCategory.setId(medicalCategoryId);
		masMedicalCategory.setMedicalCategoryName(medicalCategoryName);
		masMedicalCategory.setLastChgBy(changedBy);
		masMedicalCategory.setLastChgDate(currentDate);
		masMedicalCategory.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masMedicalCategory);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean deleteMedicalCategory(int medicalCategoryId,Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasMedicalCategory masMedicalCategory = new MasMedicalCategory();
		masMedicalCategory = (MasMedicalCategory) getHibernateTemplate().get(MasMedicalCategory.class, medicalCategoryId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (masMedicalCategory.getStatus().equals("y")) {
			masMedicalCategory.setStatus("n");
			dataDeleted = true;
		} else {
			masMedicalCategory.setStatus("y");
			dataDeleted = false;
		}
		masMedicalCategory.setLastChgBy(changedBy);
		masMedicalCategory.setLastChgDate(currentDate);
		masMedicalCategory.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masMedicalCategory);
		return dataDeleted;
	}

	public Map<String, Object> searchMedicalCategory(String medicalCategoryName) {
		List<MasRankCategory> searchMedicalCategoryList = new ArrayList<MasRankCategory>();
		Map medicalCategoryFieldsMap = new HashMap();
		try {
			if ((medicalCategoryName != null)) {
				searchMedicalCategoryList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasMedicalCategory sc where sc.MedicalCategoryName like '"
										+ medicalCategoryName
										+ "%' order by sc.MedicalCategoryName");
			} 
		} catch (Exception e) {
			//System.out.println("Ds excp in searchMajorCategoryCode  " + e);
		}
		medicalCategoryFieldsMap.put("searchMedicalCategoryList",searchMedicalCategoryList);
		medicalCategoryFieldsMap.put("medicalCategoryName",medicalCategoryName);
		return medicalCategoryFieldsMap;
	}
	/**
	 * getTemplateApplicationList
	 * @author Mukesh Narayan Singh 
	 * @param request Map<String, Object> dataMap
	 * @return TemplateApplication
	 */
	public Map<String, Object> getTemplateApplicationList(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId=0;
		List<Integer> templetIdList=new ArrayList<Integer>();
		if (dataMap.get("templetIdList") != null) {
			templetIdList = (List<Integer>) dataMap.get("templetIdList");
		}
		if (dataMap.get("hospitalId") != null) {
			hospitalId = (Integer) dataMap.get("hospitalId");
		}
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
					System.out.println("userGrpHospitalList-->"+userGrpHospitalList.size());
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

				}

				try {
					hbt.save(userUserGroupApp);
				} catch (Exception e) {
					e.printStackTrace();
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
	/*
	 * Code for Templete Assigned To User
	 * Code By Mukesh Narayan Singh
	 * Date 01-Jun-2012
	 */
	@Override
	public Map<String, Object> showEmployeeTemplate(
			Map<String, Object> mapDetails) {
		Map<String, Object> map = new HashMap<String, Object>();
		//List<Object> masEmployeeList = new ArrayList<Ob>();
		List<Object[]> masEmployeeList = new ArrayList<Object[]>();
		List<MasTemplate> masTemplateList = new ArrayList<MasTemplate>();
		int hospitalId=0;
		if (mapDetails.get("hospitalId") != null) {
			hospitalId = (Integer) mapDetails.get("hospitalId");
		}
		int empId=0;
		if (mapDetails.get("empId") != null) {
			empId = (Integer) mapDetails.get("empId");
		}
		/*masEmployeeList = getHibernateTemplate().find(
		"from jkt.hms.masters.business.MasEmployee emp where emp.Hospital.Id = "+hospitalId+" and emp.Status= 'y' order by emp.FirstName asc");
		*/
		//System.out.println("sql--->"+sql);
		masEmployeeList = getHibernateTemplate().find("select emp,user from jkt.hms.masters.business.Users user join user.Employee emp where emp.Hospital.Id = "+hospitalId+" and emp.Id="+empId+" and user.Status= 'y' and emp.Status= 'y' order by emp.FirstName asc");
		masTemplateList = getHibernateTemplate().find(
		"from jkt.hms.masters.business.MasTemplate templet where  templet.Template.Id is null and templet.Status ='y'  order by TemplateName.TemplateName asc");
		
		//System.out.println("masEmpCategoryList.size()--->"+masEmpCategoryList.size());
		List<UserTemplate> userTemplateList = new ArrayList<UserTemplate>();
		userTemplateList = getHibernateTemplate().find(
		"select ut from jkt.hms.masters.business.UserTemplate ut join ut.User as user join user.Employee as emp where  ut.Hospital.Id = "+hospitalId+" and emp.Id="+empId+" and ut.Status ='y'  order by ut.Template.Id asc");
		map.put("userTemplateList",userTemplateList);
		map.put("masEmployeeList",masEmployeeList);
		map.put("masTemplateList",masTemplateList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showEmpSMCTransferJsp(Map<String, Object> datamap) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = (Integer)datamap.get("hospitalId");
		List<Object[]> employeeList = new ArrayList<Object[]>();
		List<MasCommand> commandList = new ArrayList<MasCommand>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		Session session = getSession();
		String serviceNo = "";
		if(datamap.get("serviceNo")!=null){
			serviceNo=(String)datamap.get("serviceNo");
		}
		Criteria crit = null;
		
		crit = session.createCriteria(MasEmployee.class).createAlias("Hospital", "h").createAlias("h.Command", "c").createAlias("Rank", "r").add(Restrictions.eq("h.Id", hospitalId))
				.setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("ServiceNo"))
				.add(Projections.property("FirstName")).add(Projections.property("MiddleName")).add(Projections.property("LastName")).add(Projections.property("r.RankName"))
				.add(Projections.property("Status")).add(Projections.property("c.CommandName")).add(Projections.property("h.HospitalName")).add(Projections.property("h.Id")));
		
		if(!serviceNo.equals("")){
			crit= crit.add(Restrictions.eq("ServiceNo", serviceNo));
		}
		employeeList = crit.list();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("HospitalName")).list();
		commandList = session.createCriteria(MasCommand.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("CommandName")).list();
		
		map.put("employeeList", employeeList);
		map.put("hospitalList", hospitalList);
		map.put("commandList", commandList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> updateEmployeeSMC(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		int employeeId = box.getInt("employeeId");
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		boolean flag = false;
		Transaction tx = null;
		Session session = (Session)getSession();
		int oldSmcId  = box.getInt("oldSmcId");
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String date = (String)utilMap.get("currentDate");	 
		String time = (String)utilMap.get("currentTimeWithoutSc");
		String message = "";
		int userId = 0;
		try {
			tx= session.beginTransaction();
			MasEmployee masEmployee = (MasEmployee) hbt.load(MasEmployee.class, employeeId);
			MasHospital hospital = new MasHospital();
			hospital.setId(box.getInt("hospital"));
			masEmployee.setHospital(hospital);
			hbt.update(masEmployee);
			
			if(masEmployee.getUsers()!=null){
				for(Users users : masEmployee.getUsers()){
					if(users.getStatus().equals("y")){
						userId = users.getId();
					}
				}
			}
			List<UserUsergroupHospital> userGroupHospitalList = new ArrayList<UserUsergroupHospital>();
			userGroupHospitalList = session.createCriteria(UserUsergroupHospital.class).add(Restrictions.eq("Hospital.Id", oldSmcId))
					  .createAlias("User", "u").add(Restrictions.eq("u.Id",userId ))						
					.list();
			//System.out.println("==="+userGroupHospitalList.size());
			if(userId!=0)
			{
				if(userGroupHospitalList.size()>0){
					for(UserUsergroupHospital list : userGroupHospitalList){
						
						int Id = list.getId().intValue();
						UserUsergroupHospital userUsergroupHospital=(UserUsergroupHospital)hbt.load(UserUsergroupHospital.class, Id);
                         MasHospital masHospital=new MasHospital();
                         masHospital.setId( box.getInt("hospital"));
                         userUsergroupHospital.setHospital(masHospital);
						userUsergroupHospital.setStatus("y");
						userUsergroupHospital.setLastChgBy(box.getString("userName"));
						userUsergroupHospital.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
						userUsergroupHospital.setLastChgTime(time);
						hbt.update(userUsergroupHospital);
					}
				}
				//cde for delet entery in user template table for smc transfer
				Query query = session.createQuery("delete UserTemplate ut where ut.Hospital.Id="+oldSmcId+" and ut.User.Id="+userId);
				query.executeUpdate();
			//code comment by lokesh for smc transfer 
	/*		Query query = session.createQuery("delete UserUsergroupHospital uuh where uuh.GroupHospital.Id in ( select Id from UsergroupHospital uh" +
					"  where uh.Hospital.Id="+oldSmcId+") and uuh.User.Id="+userId);
			query.executeUpdate();
			
			
			List<Integer> userGroupHospitalList = new ArrayList<Integer>();
			userGroupHospitalList = session.createCriteria(UsergroupHospital.class).add(Restrictions.eq("Hospital.Id", box.getInt("hospital")))
								.setProjection(Projections.property("Id")).list();
			System.out.println("userId-- "+userId);
			if(userId!=0){
				if(userGroupHospitalList.size()>0){
					for(Integer id : userGroupHospitalList){
						UserUsergroupHospital userUsergroupHospital = new UserUsergroupHospital();
						Users user = new Users();
						user.setId(userId);
						userUsergroupHospital.setUser(user);
                         MasHospital masHospital=new MasHospital();
                         masHospital.setId( box.getInt("hospital"));
                         userUsergroupHospital.setHospital(masHospital);
						UsergroupHospital usergroupHospital = new UsergroupHospital();
						usergroupHospital.setId(id);
						userUsergroupHospital.setGroupHospital(usergroupHospital);
						userUsergroupHospital.setStatus("y");
						userUsergroupHospital.setLastChgBy(box.getString("userName"));
						userUsergroupHospital.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
						userUsergroupHospital.setLastChgTime(time);
						hbt.save(userUsergroupHospital);
					}
				}
*/
				/*List<String> appIdList = new ArrayList<String>();

				appIdList = session.createCriteria(UserUsergroupApplication.class).createAlias("GroupApp", "groupApp").createAlias("GroupHospital", "groupHospital")
				.add(Restrictions.eq("User.Id", userId))
				.add(Restrictions.eq("groupHospital.Hospital.Id", oldSmcId))
				.setProjection(Projections.property("groupApp.App.Id")).list();

				List<UsergroupHospital> userGrpHospitalList = new ArrayList<UsergroupHospital>();
				List<Object> grpAppList = new ArrayList<Object>();
				List<Object> grpIdList = new ArrayList<Object>();
				List<Object> usrGrpHospList = new ArrayList<Object>();

				Query query1 = session.createQuery("delete UserUsergroupApplication uuh where uuh.GroupHospital.Id in ( select Id from UsergroupHospital uh" +
						"  where uh.Hospital.Id="+oldSmcId+") and uuh.User.Id="+userId);
				query1.executeUpdate();
*/
			/*	if(appIdList.size() > 0){
					for(String applicationId : appIdList){
						List<GroupApplication> groupAppList = new ArrayList<GroupApplication>();

						groupAppList = session.createCriteria(GroupApplication.class).createAlias("App", "app").add(
								Restrictions.eq("app.Id", applicationId)).add(Restrictions.eq("Status","y")).list();

						for (GroupApplication grpApp : groupAppList) {
							int groupId = 0;
							int grpAppId = 0;
							userGrpHospitalList = session.createCriteria(UsergroupHospital.class).createAlias("Hospital", "hsp").add(Restrictions.eq("hsp.Id", box.getInt("hospital")))
							.createAlias("Group", "grp").add(Restrictions.eq("grp.Id", groupId)).addOrder(Order.desc("Id")).list();
							if(userGrpHospitalList.size() > 0){
								groupId = grpApp.getGroup().getId();
								grpAppId = grpApp.getId();
								grpAppList.add(grpAppId);
								grpIdList.add(groupId);
								usrGrpHospList.add(userGrpHospitalList.get(0).getId());
							}

						}
					}
					if(grpAppList.size() > 0){
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
								users.setId(userId);
								userUserGroupApp.setUser(users);
								userUserGroupApp.setStatus("y");

								try {
									hbt.save(userUserGroupApp);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}

						}
					}
				}*/
				message = "Record updated successfully.";
			}else{
				
				message = "User does not exist.";
			}
			
			flag=true;
			tx.commit();
		} catch (Exception e) {
			message = "Some Problem Occured.";
			if(tx !=null){
				tx.rollback();
			}
			e.printStackTrace();
		}
		map.put("message", message);
		return map;
	}	
	
	
	// ---------------------------Command Master By Mansi on 1st Aug 2013--------------------------------------

	public boolean addCommand(MasCommand masCommand) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masCommand);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editCommandToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
		String commandName = "";
		@SuppressWarnings("unused")
		String commandCode = "";
		int commandId = 0;
		String changedBy = "";
		commandId = (Integer) generalMap.get("id");
		commandCode = (String) generalMap.get("commandCode");
		commandName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		
		int userId =0;
		if (generalMap.get("userId") != null) {
			userId = (Integer) generalMap.get("userId");
		}
		MasCommand masCommand = (MasCommand) getHibernateTemplate().get(
				MasCommand.class, commandId);

		masCommand.setId(commandId);
		masCommand.setCommandName(commandName);
		Users users = new Users();
		users.setId(userId);
		masCommand.setLastChgBy(users);
		masCommand.setLastChgDate(currentDate);
		masCommand.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masCommand);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchCommand(String commandCode,
			String commandName) {
		List<MasCommand> searchCommandList = new ArrayList<MasCommand>();
		Map<String, Object> commandFieldsMap = new HashMap<String, Object>();
		try {
			if ((commandName != null) || (commandCode == null)) {
				searchCommandList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasCommand imc where imc.CommandName like '"
										+ commandName
										+ "%' order by imc.CommandName");
			} else {
				searchCommandList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasCommand imc where imc.CommandCode like '"
										+ commandCode
										+ "%' order by imc.CommandCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		commandFieldsMap.put("searchCommandList", searchCommandList);
		return commandFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showCommandJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasCommand> searchCommandList = new ArrayList<MasCommand>();
		searchCommandList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasCommand ");
		map.put("searchCommandList", searchCommandList);
		return map;
	}

	public boolean deleteCommand(int commandId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(	"currentTime");
		MasCommand masCommand = new MasCommand();
		masCommand = (MasCommand) getHibernateTemplate().get(
				MasCommand.class, commandId);
		int userId =0;
		if (generalMap.get("userId") != null) {
			userId = (Integer) generalMap.get("userId");
		}
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masCommand.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masCommand.setStatus("y");
				dataDeleted = false;
			}
		}
	
			Users users = new Users();
			users.setId(userId);
			masCommand.setLastChgBy(users);
			
		masCommand.setLastChgDate(currentDate);
		masCommand.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masCommand);
		return dataDeleted;
	}
	
	
	
	// ---------------------------Station Master By Mansi on 1st Aug 2013--------------------------------------

	public boolean addStation(MasStation masStation) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masStation);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteStation(int stationId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasStation masStation = new MasStation();
		masStation = (MasStation) getHibernateTemplate().get(MasStation.class,
				stationId);
		@SuppressWarnings("unused")
		int userId =0;
		if (generalMap.get("userId") != null) {
			userId = (Integer) generalMap.get("userId");
		}
		Integer commandId = masStation.getCommand().getId();
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masStation.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masStation.setStatus("y");
				dataDeleted = false;
			}
		}
		
		Users users = new Users();
		users.setId(userId);
		masStation.setLastChgBy(users);
		masStation.setLastChgDate(currentDate);
		masStation.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masStation);
		return dataDeleted;
	}

	public boolean editStationToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int commandId = 0;
		String stationName = "";
		@SuppressWarnings("unused")
		String stationCode = "";
		int stationId = 0;
		String changedBy = "";
		stationId = (Integer) generalMap.get("id");
		stationCode = (String) generalMap.get("stationCode");
		stationName = (String) generalMap.get("name");
		commandId = (Integer) generalMap.get("commandId");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		int userId =0;
		if (generalMap.get("userId") != null) {
			userId = (Integer) generalMap.get("userId");
		}
		MasStation masStation = (MasStation) getHibernateTemplate().get(
				MasStation.class, stationId);

		masStation.setId(stationId);
		masStation.setStationName(stationName);
		MasCommand masCommand = new MasCommand();
		masCommand.setId(commandId);
		masStation.setCommand(masCommand);
		
		Users users = new Users();
		users.setId(userId);
		masStation.setLastChgBy(users);
		
		masStation.setLastChgDate(currentDate);
		masStation.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masStation);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchStation(String stationCode,
			String stationName) {
		List<MasStation> searchStationList = new ArrayList<MasStation>();
		List commandList = null;
		Map<String, Object> stationFieldsMap = new HashMap<String, Object>();
		List gridCommandList = null;
		try {
			if ((stationName != null) || (stationCode == null)) {
				searchStationList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasStation as i where i.StationName like '"
								+ stationName + "%' order by i.StationName");
			} else {
				searchStationList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasStation as i where i.StationCode like '"
								+ stationCode + "%' order by i.StationCode");
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchStationList  " + e);
		}
		commandList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasCommand as isc where isc.Status = 'y'");
		gridCommandList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasCommand as isc");
		stationFieldsMap.put("gridCommandList", gridCommandList);
		stationFieldsMap.put("searchStationList", searchStationList);
		stationFieldsMap.put("commandList", commandList);
		return stationFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showStationJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStation> searchStationList = new ArrayList<MasStation>();
		List<MasCommand> commandList = new ArrayList<MasCommand>();
		List<MasCommand> gridCommandList = new ArrayList<MasCommand>();
		searchStationList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasStation ");
		gridCommandList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasCommand as isc");
		commandList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasCommand as isc where isc.Status = 'y'");
		map.put("searchStationList", searchStationList);
		map.put("commandList", commandList);
		map.put("gridCommandList", gridCommandList);
		return map;
	}

	@Override
	public Map<String, Object> getDepartmentList(Map<String, Object> dataMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		try {
			int divisionId = 0;
			 divisionId=(Integer) dataMap.get("divisionId");
			List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
			Session session = (Session) getSession();
			Criteria criteria = null;
			
			criteria = session.createCriteria(MasDepartment.class);
			if (divisionId != 0 ) {
				criteria.createAlias("Division", "d").add(Restrictions.eq("d.Id", divisionId)).add(Restrictions.eq("Status", "y").ignoreCase()).list();;
			}
			
		
			
			masDepartmentList = criteria.list();
			map.put("masDepartmentList", masDepartmentList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//
		return map;

	}
	
	@Override
	public Map<String, Object> getGradeList(Map<String, Object> dataMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		try {
			int rankCategoryId = 0;
			rankCategoryId=(Integer) dataMap.get("rankCategoryId");
			List<MasGrade> masGradeList = new ArrayList<MasGrade>();
			Session session = (Session) getSession();
			Criteria criteria = null;
			
			criteria = session.createCriteria(MasGrade.class);
			if (rankCategoryId != 0 ) {
				criteria.createAlias("RankCategory", "r").add(Restrictions.eq("r.Id", rankCategoryId)).add(Restrictions.eq("Status", "y").ignoreCase()).list();;
			}
			
		
			
			masGradeList = criteria.list();
			map.put("masGradeList", masGradeList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//
		return map;

	}

	@Override
	public Map<String, Object> checkForExisting(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		int employeecodeId = 0;
		employeecodeId=(Integer) generalMap.get("employeecodeId");
		int relationcodeId =0; 
		relationcodeId=(Integer) generalMap.get("relationcodeId");
		
		String name = "";
		String flag = "";
		name=(String) generalMap.get("name");
		Session session = (Session) getSession();
		flag=(String) generalMap.get("flag");
		List<MasEmployeeDependent> employeeDependentList = new ArrayList<MasEmployeeDependent>();
		if(!name.equals("") && employeecodeId!=0){
		if(flag.equals("update")){
			int id=0;
			id=(Integer) generalMap.get("id");
			employeeDependentList = session.createCriteria(MasEmployeeDependent.class).add(
					Restrictions.or(Restrictions.like("EmployeeDependentFName", name), Restrictions.eq("Relation.Id", relationcodeId))).
						createAlias("Employee", "e")
						.add(Restrictions.eq("e.Id", employeecodeId))
						.add(Restrictions.ne("Id", id))
						.add(Restrictions.eq("Status", "y").ignoreCase())
					.list();
		}else{
	
		employeeDependentList = session.createCriteria(MasEmployeeDependent.class).add(
				Restrictions.or(Restrictions.like("EmployeeDependentFName", name), Restrictions.eq("Relation.Id", relationcodeId))).				
					createAlias("Employee", "e")
					.add(Restrictions.eq("e.Id", employeecodeId))
					.add(Restrictions.eq("Status", "y").ignoreCase())
				.list();
		}}
		map.put("employeeDependentList", employeeDependentList);
		return map;
	
	}
	@Override
	public Map<String, Object> getLocalStateList(Map<String, Object> dataMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		try {
			int localCountry = 0;
			localCountry=(Integer) dataMap.get("localCountry");
			List<MasState> stateList = new ArrayList<MasState>();
			Session session = (Session) getSession();
			Criteria criteria = null;
			
			criteria = session.createCriteria(MasState.class);
			if (localCountry != 0 ) {
				criteria.createAlias("Country", "c").add(Restrictions.eq("c.Id", localCountry)).add(Restrictions.eq("Status", "y").ignoreCase()).list();;
			}
			
		
			
			stateList = criteria.list();
			map.put("stateList", stateList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//
		return map;

	}
	@Override
	public Map<String, Object> getPerStateList(Map<String, Object> dataMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		try {
			int perCountry = 0;
			perCountry=(Integer) dataMap.get("perCountry");
			List<MasState> stateList = new ArrayList<MasState>();
			Session session = (Session) getSession();
			Criteria criteria = null;
			
			criteria = session.createCriteria(MasState.class);
			if (perCountry != 0 ) {
				criteria.createAlias("Country", "c").add(Restrictions.eq("c.Id", perCountry)).add(Restrictions.eq("Status", "y").ignoreCase()).list();;
			}
			
		
			
			stateList = criteria.list();
			map.put("stateList", stateList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//
		return map;

	}
	@Override
	public Map<String, Object> getLocalDistrictList(Map<String, Object> dataMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		try {
			int localState = 0;
			localState=(Integer) dataMap.get("localState");
			List<MasDistrict> districtList = new ArrayList<MasDistrict>();
			Session session = (Session) getSession();
			Criteria criteria = null;
			
			criteria = session.createCriteria(MasDistrict.class);
			if (localState != 0 ) {
				criteria.createAlias("State", "s").add(Restrictions.eq("s.Id", localState)).add(Restrictions.eq("Status", "y").ignoreCase()).list();;
			}
			
		
			
			districtList = criteria.list();
			map.put("districtList", districtList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//
		return map;

	}

	@Override
	public Map<String, Object> getPerDistrictList(Map<String, Object> dataMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		try {
			int perState = 0;
			perState=(Integer) dataMap.get("perState");
			List<MasDistrict> districtList = new ArrayList<MasDistrict>();
			Session session = (Session) getSession();
			Criteria criteria = null;
			
			criteria = session.createCriteria(MasDistrict.class);
			if (perState != 0 ) {
				criteria.createAlias("State", "s").add(Restrictions.eq("s.Id", perState)).add(Restrictions.eq("Status", "y").ignoreCase()).list();;
			}
			
		
			
			districtList = criteria.list();
			map.put("districtList", districtList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//
		return map;

	}
	
	public Map<String, Object> getDepartmentForDisplay(int employeeId) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployeeDepartment> masEmployeeDepartmentList = new ArrayList<MasEmployeeDepartment>();
		System.out.println(employeeId+"employeeIdemployeeIdemployeeIdemployeeId");
		masEmployeeDepartmentList =session.createCriteria(MasEmployeeDepartment.class)
		.add(Restrictions.eq("Employee.Id", employeeId))
				.list();
		System.out.println("masEmployeeDepartmentList---"+masEmployeeDepartmentList.size());
		map.put("masEmployeeDepartmentList", masEmployeeDepartmentList);
		map.put("employeeId", employeeId);
		return map;
	}
	@Override
	public Map<String, Object> displayImage(int employeeId) {
		Map<String,Object> map=new HashMap<String,Object>();
	
		Session session =(Session) getSession();
		
		System.out.println(employeeId+"---------employeeId");
		Query query=null;
		
		
		 if(employeeId>0){
			 
			 query = session.createQuery("from UploadDocuments where Employee.Id= :employeeId");
				query.setInteger("employeeId", employeeId);
				UploadDocuments imageObj = (UploadDocuments) query.uniqueResult(); 
				System.out.println("imageObj "+imageObj);
				map.put("imageObj",imageObj);
				System.out.println(imageObj+"-------imageObj------");
		 }
		 
		 
		
		
		return map;
	}
	@Override
	public Map<String, Object> getDeptDivisionNameList(Map<String, Object> dataMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String divisionName = "";
			divisionName=(String) dataMap.get("divisionName");
			List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
			Session session = (Session) getSession();
			Criteria criteria = null;
			
			criteria = session.createCriteria(MasDepartment.class);
			if (!divisionName.equals("")) {
				criteria.createAlias("Division", "d").add(Restrictions.like("d.DivisionName", divisionName)).add(Restrictions.eq("Status", "y").ignoreCase()).list();;
			}
			
		
			
			masDepartmentList = criteria.list();
			map.put("masDepartmentList", masDepartmentList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//
		return map;

	}

	@Override
	public Map<String, Object> checkEmpPBNo(Map<String, Object> dataMap) {
		String empNo = "";
		String exists = "no";
		String type = "";
		List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
		Map<String, Object> map = new HashMap<String, Object>();
		if (dataMap.get("empNo") != null) {
			empNo = "" + dataMap.get("empNo");
		}
		
		Session session = (Session) getSession();
		
			masEmployeeList = session.createCriteria(MasEmployee.class)
			.add(Restrictions.eq("ServiceNo", empNo)).list();
			if (masEmployeeList.size() > 0) {
				exists = "yes";
			}
		
		map.put("exists", exists);
		return map;
	}

	@Override
	public Map<String, Object> displayImageEmployeeDependent(
			int employeeDependentId) {
		Map<String,Object> map=new HashMap<String,Object>();
	
		Session session =(Session) getSession();
		
		System.out.println(employeeDependentId+"---------employeeDependentId");
		Query query=null;
		
		
		 if(employeeDependentId>0){
			 
			 query = session.createQuery("from UploadDocuments where EmployeeDependent.Id= :employeeDependentId");
				query.setInteger("employeeDependentId", employeeDependentId);
				UploadDocuments imageObj = (UploadDocuments) query.uniqueResult(); 
				map.put("imageObj",imageObj);
				System.out.println(imageObj+"-------imageObj------");
		 }
		 
		 
		
		
		return map;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> showEmployeeDependentReport(int hospitalId) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();

		List<MasDivision> divisionList = new ArrayList<MasDivision>();
		
		List<MasEmployeeDependent> dependentList = new ArrayList<MasEmployeeDependent>();
	
		dependentList=session.createCriteria(MasEmployeeDependent.class).add(Restrictions.eq("Status", "y")).list();
		divisionList=session.createCriteria(MasDivision.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("DivisionName")).list();
	
		map.put("dependentList", dependentList);
		map.put("divisionList", divisionList);
		return map;
	}
	

	@Override
	public Map<String, Object> displayImageCommon(
			Box box) {
		Map<String,Object> map=new HashMap<String,Object>();
	
		Session session =(Session) getSession();
		UploadDocuments imageObj = new UploadDocuments();
				
		System.out.println("box.getInt(relationId)"+box.getInt("relationId"));
		System.out.println("box.getInt(employeeId)"+box.getInt("employeeId"));
       if (box.getInt("relationId") != 0 && box.getInt("employeeId") != 0) {
    	   MasEmployeeDependent employeeDependent = (MasEmployeeDependent)session.createCriteria(MasEmployeeDependent.class)
    			    .add(Restrictions.eq("Relation.Id",box.getInt("relationId")))
					.add(Restrictions.eq("Employee.Id",box.getInt("employeeId"))).uniqueResult();
    	 
    		   imageObj = (UploadDocuments)session.createCriteria(UploadDocuments.class)
   					.add(Restrictions.eq("EmployeeDependent.Id",employeeDependent.getId())).uniqueResult();   
    	   
    	   
    	   
		}else if (box.getInt("employeeId") != 0) {
			imageObj = (UploadDocuments)session.createCriteria(UploadDocuments.class)
					.add(Restrictions.eq("Employee.Id",box.getInt("employeeId"))).uniqueResult();
		}
        
	
		 
		 
		
		 map.put("imageObj",imageObj);
		return map;
	}
	


	// ------------------------------- Others Category
		// -------------------------------------------

		public Map<String, Object> showOthersCategoryJsp() {
			Map<String, Object> map = new HashMap<String, Object>();
			List<MasOthersCategory> searchOthersCategoryList = new ArrayList<MasOthersCategory>();
			Session session=(Session)getSession();
			/*searchOthersCategoryList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasOthersCategory ");
			*/
			searchOthersCategoryList=session.createCriteria(MasOthersCategory.class).list();
			map.put("searchOthersCategoryList", searchOthersCategoryList);
			return map;
		}

		public Map<String, Object> searchOthersCategory(String othersCategoryCode,
				String othersCategoryName) {
			List<MasOthersCategory> searchOthersCategoryList = new ArrayList<MasOthersCategory>();
			Map othersCategoryFieldsMap = new HashMap();
			Session session=(Session)getSession();
			try {
				if ((othersCategoryName != null) || (othersCategoryCode == null)) {
					/*searchOthersCategoryList = getHibernateTemplate()
							.find(
									"from jkt.hms.masters.business.MasOthersCategory sc where sc.OthersCategoryName like '"
											+ othersCategoryName
											+ "%' order by sc.OthersCategoryName");
					
					
					*/
					searchOthersCategoryList=session.createCriteria(MasOthersCategory.class)
					.add(Restrictions.like("CategoryName","%"+ othersCategoryName+"%"))
					.addOrder(Order.asc("CategoryName")).list();
					
				} else {
					/*searchOthersCategoryList = getHibernateTemplate()
							.find(
									"from jkt.hms.masters.business.MasOthersCategory sc where sc.OthersCategoryCode like '"
											+ othersCategoryCode
											+ "%' order by sc.OthersCategoryCode");
					*/
					searchOthersCategoryList=session.createCriteria(MasOthersCategory.class).add(Restrictions.like("CategoryCode","%"+othersCategoryCode+"%"))
	.addOrder(Order.asc("CategoryCode")).list();
				}
			} catch (Exception e) {
				//System.out.println("Ds excp in searchMajorCategoryCode  " + e);
			}
			othersCategoryFieldsMap.put("searchOthersCategoryList",
					searchOthersCategoryList);
			return othersCategoryFieldsMap;
		}

		public boolean editOthersCategoryToDatabase(Map<String, Object> generalMap) {
			boolean dataUpdated = false;
			Date currentDate = new Date();
			String currentTime = "";
			currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");
			String othersCategoryName = "";
			@SuppressWarnings("unused")
			String othersCategoryCode = "";
			int othersCategoryId = 0;
			int userId=0;
			String changedBy = "";
			othersCategoryId = (Integer) generalMap.get("id");
			othersCategoryCode = (String) generalMap.get("othersCategoryCode");
			othersCategoryName = (String) generalMap.get("name");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			userId = (Integer) generalMap.get("userId");
		
			MasOthersCategory masOthersCategory = (MasOthersCategory) getHibernateTemplate()
					.get(MasOthersCategory.class, othersCategoryId);

			masOthersCategory.setId(othersCategoryId);
			masOthersCategory.setCategoryName(othersCategoryName);
			
			masOthersCategory.setLastChgBy(userId);
			
			masOthersCategory.setLastChgDate(currentDate);
			masOthersCategory.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masOthersCategory);
			dataUpdated = true;
			return dataUpdated;
		}

		public boolean addOthersCategory(MasOthersCategory masOthersCategory) {
			boolean successfullyAdded = false;
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(masOthersCategory);
			successfullyAdded = true;
			return successfullyAdded;
		}

		public boolean deleteOthersCategory(int othersCategoryId,
				Map<String, Object> generalMap) {
			boolean dataDeleted = false;
			String changedBy = "";
			Date currentDate = new Date();
			int userId=0;
			userId = (Integer) generalMap.get("userId");
			String currentTime = "";
			currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");
			MasOthersCategory masOthersCategory = new MasOthersCategory();
			masOthersCategory = (MasOthersCategory) getHibernateTemplate().get(
					MasOthersCategory.class, othersCategoryId);
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			if (masOthersCategory.getStatus().equals("y")) {
				masOthersCategory.setStatus("n");
				dataDeleted = true;
			} else {
				masOthersCategory.setStatus("y");
				dataDeleted = false;
			}
			masOthersCategory.setLastChgBy(userId);
			masOthersCategory.setLastChgDate(currentDate);
			masOthersCategory.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masOthersCategory);
			return dataDeleted;
		}
		@Override
		public Map<String, Object> getDepartmentNoList(Map<String, Object> dataMap) {

			Map<String, Object> map = new HashMap<String, Object>();
			try {
				int departmentId = 0;
				departmentId=(Integer) dataMap.get("departmentId");
				List<MasDepartment> masDepartmentNoList = new ArrayList<MasDepartment>();
				Session session = (Session) getSession();
				Criteria criteria = null;
				
				criteria = session.createCriteria(MasDepartment.class);
				if (departmentId != 0 ) {
					criteria.add(Restrictions.eq("Id", departmentId)).add(Restrictions.eq("Status", "y").ignoreCase()).list();
				}
				
			
				
				masDepartmentNoList = criteria.list();
				map.put("masDepartmentNoList", masDepartmentNoList);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//
			return map;

		}


		public Map<String, Object> fillEmployee(Map<String, Object> dataMap) {
			Session session = (Session) getSession();
			Map<String, Object> map = new HashMap<String, Object>();
			List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
			session = (Session) getSession();
			String employeeNo = null;
			
			
			try {
				employeeNo = "" + dataMap.get("employeeNo");
				
					Criteria c = session.createCriteria(MasEmployee.class)
					.add(Restrictions.eq("ServiceNo", employeeNo))
					.add(Restrictions.eq("Status", "y").ignoreCase());
					employeeList = c.list();

			} catch (HibernateException e) {
				e.printStackTrace();
			}
			map.put("employeeList", employeeList);
			return map;

		}
		
		
		public Map<String, Object> getEmployeeList(Map<String, Object> dataMap) {

			Map<String, Object> map = new HashMap<String, Object>();
			List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
			Session session = (Session) getSession();
			String empNo = null;
			
			List objectList = new ArrayList();
			try {
				String str = "" + dataMap.get("autoHint") + "%";

			

				Criteria c= session.createCriteria(MasEmployee.class)
			.add(Restrictions.like("ServiceNo",str).ignoreCase())
						.setProjection(Projections.projectionList().add(Projections.property("FirstName"))
								.add(Projections.property("ServiceNo")).add( Projections.groupProperty("FirstName"))
								.add( Projections.groupProperty("ServiceNo"))).setMaxResults(10);
				employeeList = c.list();

			} catch (Exception e) {
				e.printStackTrace();
			}
			map.put("employeeList", employeeList);
			return map;
		}

		@Override
		public Map<String, Object> getBloodGroupId(String bloodGroupCode) {
			Map<String, Object> map = new HashMap<String, Object>();
			List<MasBloodGroup> masBloodGroupList = new ArrayList<MasBloodGroup>();
			Session session = (Session) getSession();
			int bloodGroupIdNA = 0;
			
			
			masBloodGroupList=session.createCriteria(MasBloodGroup.class).add(Restrictions.eq("BloodGroupCode",bloodGroupCode).ignoreCase()).list();
			
			if (masBloodGroupList != null	&& masBloodGroupList.size() > 0) {
				bloodGroupIdNA= masBloodGroupList.get(0).getId();
			}
			map.put("bloodGroupIdNA", bloodGroupIdNA);
			return map;
		}
		
		@SuppressWarnings("unused")
		public Map<String, Object> ReadImage(Box box) {

			Map<String,Object>dmap = new HashMap<String,Object>();
			Session session=(Session)getSession();
			try{  
				
				int FROMISN=box.getInt("FROMISN");
						int TOISN=box.getInt("TOISN");
				Class.forName("oracle.jdbc.driver.OracleDriver");  
				Connection con=DriverManager.getConnection(  
				"jdbc:oracle:thin:@172.129.45.222:1521:oradb","hal","it0604"); 

				System.out.println("conn="+con);
				      
				PreparedStatement ps=con.prepareStatement("select * from empphoto  where eph_isn>"+FROMISN+" and eph_isn<="+TOISN+" order by eph_isn");  
				ResultSet rs=ps.executeQuery();  
				while (rs.next())
				{
				        
				int isn = rs.getInt(1);	
				String ext = rs.getString(3);
				Blob b=rs.getBlob(2);//2 means 2nd column data  
				byte barr[]=b.getBytes(1,(int)b.length());//1 means first image  
				System.out.println("OracleISN="+isn);

                List<MasEmployee> emplist = new ArrayList<MasEmployee>();
                
                emplist = session.createCriteria(MasEmployee.class).add(Restrictions.eq("EphIsn", isn)).list();
               
                int empSize = emplist.size();
                System.out.println("emplist="+empSize);
                
                if(empSize>0)
                {
                	int empId = emplist.get(0).getId();
                	
                	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
    				hbt.setFlushModeName("FLUSH_EAGER");
    				hbt.setCheckWriteOperations(false);

    				UploadDocuments document = new UploadDocuments();
    				document.setPatientDocument(barr);
    				MasEmployee empObj = new MasEmployee();
    				empObj.setId(empId);
    				document.setEmployee(empObj);
    				Users userobj= new Users();
    				userobj.setId(1);
    				document.setFileExtension(ext);
    				document.setFileName(""+isn);
    				
    				document.setLastChgBy(userobj);
    				document.setLastChgDate(new Date());
    				document.setLastChgTime("10:42");
    				hbt.save(document);
    				hbt.flush();
    				hbt.refresh(document); 
    				emplist.clear();
    				              
                	
                }
                else
                {
                	List<MasEmployeeDependent> dependentlist = new ArrayList<MasEmployeeDependent>();
                    
                	dependentlist = session.createCriteria(MasEmployeeDependent.class).add(Restrictions.eq("EphIsn", isn)).list();
                	int dependentSize=dependentlist.size();
                    System.out.println("dependentlist="+dependentSize);
                    if(dependentSize>0)
                    {
                    	int dependentId = dependentlist.get(0).getId();
                    	
                    	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
        				hbt.setFlushModeName("FLUSH_EAGER");
        				hbt.setCheckWriteOperations(false);

        				UploadDocuments document = new UploadDocuments();
        				document.setPatientDocument(barr);
        				MasEmployeeDependent empdObj = new MasEmployeeDependent();
        				empdObj.setId(dependentId);
        				document.setEmployeeDependent(empdObj);
        				Users userobj= new Users();
        				userobj.setId(1);
        				document.setFileExtension(ext);
        				document.setFileName(""+isn);
        				
        				document.setLastChgBy(userobj);
        				document.setLastChgDate(new Date());
        				document.setLastChgTime("10:42");
        				
        				hbt.save(document);
        				hbt.flush();
        				hbt.refresh(document);  
        				
        				dependentlist.clear();
        				              
                    	
                    }
                	
                }
                
				}//end of if  
				
				System.out.println("ok");  
				              
				con.close();  
				}
			catch (Exception e) {
				e.printStackTrace(); 
				}  
			
			
			return dmap;

		}

		@Override
		public Map<String, Object> showEmployeePayStructureJsp(
				Map<String, Object> dataMap) {
			// TODO Auto-generated method stub


			Map<String, Object> map = new HashMap<String, Object>();
			List<MasEmployee>  employeeList = new ArrayList<MasEmployee>();
			List<MasEmployee>  employeeListForSearch = new ArrayList<MasEmployee>();
			List<HrMasPayroll> payRollList  = new ArrayList<HrMasPayroll>();
			int centreid = Integer.parseInt(""+dataMap.get("centreId"));
			int divisionIdForMedicalDivision = Integer.parseInt(HMSUtil.getProperties("adt.properties", "divisionIdForMedicalDivision"));
			List<HrEmployeePayStructure> searchEmployeePayStructureList = new ArrayList<HrEmployeePayStructure>();		
			employeeList=getHibernateTemplate().find( "from jkt.hms.masters.business.MasEmployee e where e.Status='y' and e.FirstName!=null and e.Division="+ divisionIdForMedicalDivision +" order by e.FirstName");
			employeeListForSearch =getHibernateTemplate().find( "from jkt.hms.masters.business.MasEmployee e where e.Status='y' and e.FirstName!=null and e.Division="+ divisionIdForMedicalDivision +" order by e.FirstName");
			searchEmployeePayStructureList=getHibernateTemplate().find( "from jkt.hms.masters.business.HrEmployeePayStructure");
			
			Session session = getSession();
			payRollList = session.createCriteria(HrMasPayroll.class).list();
			
			map.put("employeeList",employeeList);
			map.put("employeeListForSearch",employeeListForSearch);
			map.put("payRollList",payRollList);
			map.put("searchEmployeePayStructureList", searchEmployeePayStructureList);
			return map;
		
		}

		@Override
		public Map<String, Object> searchEmployeePayStructure(
				Map<String, Object> dataMap) {
			// TODO Auto-generated method stub

			Map<String, Object> map = new HashMap<String, Object>();
			List<MasEmployee>  employeeList = new ArrayList<MasEmployee>();
			List<MasEmployee>  employeeListForSearch = new ArrayList<MasEmployee>();
			List<HrMasPayroll> payRollList  = new ArrayList<HrMasPayroll>(); 
			
			int employeeId =Integer.parseInt(""+dataMap.get("employeeId"));
			int centreid = Integer.parseInt(""+dataMap.get("centreId"));
			int divisionIdForMedicalDivision = Integer.parseInt(HMSUtil.getProperties("adt.properties", "divisionIdForMedicalDivision"));
			String employeeCode="";
			List<HrEmployeePayStructure> searchEmployeePayStructureList = new ArrayList<HrEmployeePayStructure>();		
			employeeList=getHibernateTemplate().find( "from jkt.hms.masters.business.MasEmployee e where e.Status='y' and e.FirstName!=null and e.Division="+ divisionIdForMedicalDivision +" order by e.FirstName");
			employeeListForSearch =getHibernateTemplate().find( "from jkt.hms.masters.business.MasEmployee e where e.Status='y' and e.FirstName!=null and e.Division="+ divisionIdForMedicalDivision +" order by e.FirstName");
			Session session = getSession();
			Criteria criteria = session.createCriteria(HrMasPayroll.class);
			payRollList = criteria.list();
			
			
			searchEmployeePayStructureList=getHibernateTemplate().find( "from jkt.hms.masters.business.HrEmployeePayStructure eps where eps.Employee.Id =" + employeeId);
			if(searchEmployeePayStructureList.size()>0){
				employeeCode=searchEmployeePayStructureList.get(0).getEmployee().getEmployeeCode();
			}
			
			map.put("employeeList",employeeList);
			map.put("employeeListForSearch",employeeListForSearch);
			map.put("payRollList",payRollList);
			map.put("searchEmployeePayStructureList", searchEmployeePayStructureList);
			map.put("employeeCode",employeeCode);
			return map;
			
		
		}

		@Override
		public HrEmployeePayStructure getEmployeePayStructure(
				Integer employeePayStructureId) {
			// TODO Auto-generated method stub
			Session session = getSession();
			Criteria criteria = session.createCriteria(HrEmployeePayStructure.class);
			criteria = criteria.add(Restrictions.eq("Id", employeePayStructureId));
			List employeePayStructureList = criteria.list();
			HrEmployeePayStructure employeePayStructure = (HrEmployeePayStructure)employeePayStructureList.get(0);
			return employeePayStructure;
		}

		@Override
		public void addEmployeePayStructure(
				HrEmployeePayStructure employeePayStructure) {
			// TODO Auto-generated method stub
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(employeePayStructure);
			hbt.flush();
			hbt.refresh(employeePayStructure);
		}

		@Override
		public boolean deleteEmployeePayStructure(int employeePayStructureId,
				Map<String, Object> generalMap) {
			// TODO Auto-generated method stub

			boolean dataDeleted=false;
			
			  Date currentDate = new Date();
			  String currentTime = "";
			  currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
			try{
			HrEmployeePayStructure hrEmployeePayStructure = new HrEmployeePayStructure();
			hrEmployeePayStructure=(HrEmployeePayStructure)getHibernateTemplate().load(HrEmployeePayStructure.class,employeePayStructureId);
			Integer employeecodeId= hrEmployeePayStructure.getEmployee().getId();
			
			Users changedBy = (Users)generalMap.get("changedBy");
			  currentDate=(Date)generalMap.get("currentDate");
			  currentTime=(String)generalMap.get("currentTime");
			if (hrEmployeePayStructure.getStatus().equals("y")){
				@SuppressWarnings("unused")
				List employeecodeList=getHibernateTemplate().find("from jkt.hms.masters.business.MasEmployee as employee where employee.Id='"+employeecodeId+"' and employee.Status='y'");
				hrEmployeePayStructure.setStatus("n");
				dataDeleted=true;
			}else{
				hrEmployeePayStructure.setStatus("y");
				dataDeleted=false;
			}
			hrEmployeePayStructure.setLastChgBy(changedBy);
			hrEmployeePayStructure.setLastChgDate(currentDate);
			hrEmployeePayStructure.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrEmployeePayStructure);
			}catch (Exception e) {
				e.printStackTrace();
			}
			return dataDeleted;
		
		}

		@Override
		public Map<String, Object> showEmployeePayElementsJsp(
				Map<String, Object> dataMap) {
			// TODO Auto-generated method stub


			Map<String, Object> map = new HashMap<String, Object>();
			
			List<MasEmployee>  employeeList = new ArrayList<MasEmployee>();
			List<MasEmployee>  employeeListForSearch = new ArrayList<MasEmployee>();
			List<HrMasPayElement> payElementsList = new ArrayList<HrMasPayElement>();
			List<HrEmployeePayElements> searchEmployeePayElementsList = new ArrayList<HrEmployeePayElements>();		
			int centreid = Integer.parseInt(""+dataMap.get("centreId"));
			int divisionIdForMedicalDivision = Integer.parseInt(HMSUtil.getProperties("adt.properties", "divisionIdForMedicalDivision"));
			employeeList=getHibernateTemplate().find( "from jkt.hms.masters.business.MasEmployee e where e.Status='y'and e.FirstName!=null and e.Division="+ divisionIdForMedicalDivision +" order by e.FirstName ");
			employeeListForSearch = getHibernateTemplate().find( "from jkt.hms.masters.business.MasEmployee e where e.Status='y' and e.FirstName!=null and e.Division="+ divisionIdForMedicalDivision +"  order by e.FirstName ");
			payElementsList = getHibernateTemplate().find("from jkt.hms.masters.business.HrMasPayElement as pe where pe.PayElementStatus ='Active'");
			Session session = getSession();
			searchEmployeePayElementsList = session.createCriteria(HrEmployeePayElements.class).list();
			map.put("employeeList",employeeList);
			map.put("employeeListForSearch",employeeListForSearch);
			map.put("payElementsList",payElementsList);
			map.put("searchEmployeePayElementsList", searchEmployeePayElementsList);
			return map;
		
		}

		@Override
		public Map<String, Object> searchEmployeePayElement(
				Map<String, Object> dataMap) {
			// TODO Auto-generated method stub

			Map<String, Object> map = new HashMap<String, Object>();
			
			List<MasEmployee>  employeeList = new ArrayList<MasEmployee>();
			List<HrMasPayroll> payRollList  = new ArrayList<HrMasPayroll>(); 
			List<HrEmployeePayElements> searchEmployeePayElementsList = new ArrayList<HrEmployeePayElements>();		
			int employeeId =Integer.parseInt(""+dataMap.get("employeeId"));
			int centreid = Integer.parseInt(""+dataMap.get("centreId"));
			int divisionIdForMedicalDivision = Integer.parseInt(HMSUtil.getProperties("adt.properties", "divisionIdForMedicalDivision"));
			employeeList=getHibernateTemplate().find( "from jkt.hms.masters.business.MasEmployee as e where e.Status = 'y' and e.FirstName!=null and e.Division="+ divisionIdForMedicalDivision +"  order by e.FirstName ");
			searchEmployeePayElementsList = getHibernateTemplate().find( "from jkt.hms.masters.business.HrEmployeePayElements eps  where eps.Status='y' and eps.Employee.Id =" + employeeId);
			map = showEmployeePayElementsJsp(dataMap);
			map.put("searchEmployeePayElementsList", searchEmployeePayElementsList);

			return map;
			
		
		}

		@Override
		public HrEmployeePayElements getEmployeePayElement(Integer commonId) {
			// TODO Auto-generated method stub

			Session session = getSession();
			Criteria criteria = session.createCriteria(HrEmployeePayElements.class);
			criteria = criteria.add(Restrictions.eq("Id", commonId));
			List employeePayElementList = criteria.list();
			HrEmployeePayElements employeePayElement = (HrEmployeePayElements)employeePayElementList.get(0);
			return employeePayElement;
		
		}

		@Override
		public Map addEmployeePayElement(
				HrEmployeePayElements employeePayElement) {
			// TODO Auto-generated method stub

			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			
			 List existingEmpPayElementList= (List)getSession().createCriteria(HrEmployeePayElements.class).add(Restrictions.eq("Employee.Id", employeePayElement.getEmployee().getId()))
			 								 .add(Restrictions.eq("PayElement.Id", employeePayElement.getPayElement().getId())).add(Restrictions.eq("Status", "y")).list();
			 String message = null;	
			 if(employeePayElement.getId()==null && existingEmpPayElementList!=null && existingEmpPayElementList.size()>0)
			 {
				 message = "Pay Element already added ";
			 }
			 else
			 {
				 
				 hbt.setFlushModeName("FLUSH_EAGER");
				 hbt.setCheckWriteOperations(false);
			
				 hbt.saveOrUpdate(employeePayElement);
				
				 hbt.refresh(employeePayElement);
				 hbt.flush();
			 }
			 Map<String, Object> dataMap = new HashMap<String, Object>();
			
				dataMap.put("centreId",employeePayElement.getCompany().getId());
				 Map map = showEmployeePayElementsJsp(dataMap);
			map.put("messageForDuplicate",message);
			return map;
		
		}

		@Override
		public Map<String, Object> returnSingleEmployeePayElement(
				Integer employeeId) {
			// TODO Auto-generated method stub

			Map<String, Object> map = new HashMap<String, Object>();
			List<HrEmployeePayElements> searchEmployeePayElementsList  = new ArrayList<HrEmployeePayElements>();
			List<MasEmployee>  employeeList = new ArrayList<MasEmployee>();
			List<MasEmployee>  employeeListForSearch = new ArrayList<MasEmployee>();
			List<HrMasPayElement> payElementsList = new ArrayList<HrMasPayElement>();
			Session session = (Session)getSession();
			int divisionIdForMedicalDivision = Integer.parseInt(HMSUtil.getProperties("adt.properties", "divisionIdForMedicalDivision"));
			employeeList=getHibernateTemplate().find( "from jkt.hms.masters.business.MasEmployee e where e.Division="+ divisionIdForMedicalDivision +" and e.Status='y'");
			employeeListForSearch = getHibernateTemplate().find( "from jkt.hms.masters.business.MasEmployee e where e.Division="+ divisionIdForMedicalDivision +" and e.Status='y'");
			payElementsList = getHibernateTemplate().find("from jkt.hms.masters.business.HrMasPayElement as pe where pe.Status ='y' ");
			searchEmployeePayElementsList = session.createCriteria(HrEmployeePayElements.class).createAlias("Employee", "emp").add(Restrictions.eq("emp.Id", employeeId)).add(Restrictions.eq("Status", "y")).list();
			map.put("searchEmployeePayElementsList", searchEmployeePayElementsList);
			map.put("employeeList",employeeList);
			map.put("employeeListForSearch",employeeListForSearch);
			map.put("payElementsList",payElementsList);
			return map;
		
		}

		@Override
		public boolean deleteEmployeePayElement(int employeePayElementId,
				Map<String, Object> generalMap) {
			// TODO Auto-generated method stub

			boolean dataDeleted=false;
			 
			  Date currentDate = new Date();
			  String currentTime = "";
			  currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
			try{
			HrEmployeePayElements hrEmployeePayElements = new HrEmployeePayElements();
			hrEmployeePayElements=(HrEmployeePayElements)getHibernateTemplate().load(HrEmployeePayElements.class,employeePayElementId);
			Integer employeecodeId= hrEmployeePayElements.getEmployee().getId();
			
			Users changedBy = (Users)generalMap.get("changedBy");
			  currentDate=(Date)generalMap.get("currentDate");
			  currentTime=(String)generalMap.get("currentTime");
			if (hrEmployeePayElements.getStatus().equals("y")){
				@SuppressWarnings("unused")
				List employeecodeList=getHibernateTemplate().find("from jkt.hms.masters.business.MasEmployee as employee where employee.Id='"+employeecodeId+"' and employee.Status='y'");
				hrEmployeePayElements.setStatus("n");
				dataDeleted=true;
			}else{
				hrEmployeePayElements.setStatus("y");
				dataDeleted=false;
			}
			hrEmployeePayElements.setLastChgBy(changedBy);
			hrEmployeePayElements.setLastChgDate(currentDate);
			hrEmployeePayElements.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrEmployeePayElements);
			}catch (Exception e) {

				e.printStackTrace();
			}
			return dataDeleted;
		
		}
		
}