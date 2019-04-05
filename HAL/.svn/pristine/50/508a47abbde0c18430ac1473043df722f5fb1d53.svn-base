
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%-- <%@page import="jkt.hms.masters.business.HospitalDoctorUnitT"%> --%>
<%@page import="java.util.HashSet"%>
<%-- <%@page import="jkt.hms.masters.business.OtMasUnitDay"%> --%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Date"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%-- <%@page import="sun.reflect.ReflectionFactory.GetReflectionFactoryAction"%> --%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.OpdSurgeryHeader"%>
<%@page import="jkt.hms.masters.business.MasEmployeeDepartment"%>

<%!
public String getPatientName(Patient patient){
	String patientName = "-";
	try
	{
		patientName=patient.getPFirstName();
		if(patient.getPMiddleName()!=null){
			patientName += " "+patient.getPMiddleName();
		}
		if(patient.getPLastName()!=null){
			patientName += " "+patient.getPLastName();
	}
	}
	catch (Exception e)
	{
	patientName = "-";
	}
	return patientName;
}

/* public String getHinNo(Patient patient){
	
	String hinNo = "-";
	try
	{
		hinNo=patient.getHinNo();
	}
	catch (Exception e)
	{
		hinNo = "-";
	}
	return hinNo;
} */

public String getHALEmpId(Patient patient){
	
	String HalEmpId = "-";
	try
	{
		HalEmpId=patient.getServiceNo()!=null?patient.getServiceNo():"-";
	}
	catch (Exception e)
	{
		HalEmpId = "-";
	}
	return HalEmpId;
}

/* public String getAddress(Patient patient){
	String patientAddress="-";
	try
	{
		
	}
	catch(Exception exception)
	{
		
	}
	return patientAddress;
}
 */
public String getGender(Patient patient){
	String gender="-";
	try
	{
		gender = patient.getSex().getAdministrativeSexName();
	}
	catch(Exception exception)
	{
		gender="-";
	}
	return gender;
	
}

/* public String getMaritalStatus(Patient patient){
	String maritalStatus="-";
	try
	{
		maritalStatus=patient.getMaritalStatus().getMaritalStatusName();
	}
	catch(Exception exception)
	{
		maritalStatus="-";
	}
	return maritalStatus;
} */

public String getPatientAge(Patient patient){
	//String currentAge = "-";
/* 	try
	{ */
		
		int patientAge =0;
		String sPatientAge="-";
		String age =null;
		    if(patient.getDateOfBirth() != null)
		    {
		        Date date_of_birth= patient.getDateOfBirth();        
		        patientAge = HMSUtil.calculateAgeInYears(date_of_birth);
		        if(patientAge == 1 )
		            sPatientAge = patientAge +" Year";
		        else if(patientAge == 0 )
		        {
		        	sPatientAge= HMSUtil.getAgeFromDOB(patient.getDateOfBirth());
		        }
		        else
		            sPatientAge = patientAge +" Years";
		    }
		
			/* try{
				 
				  if(patient.getAge()!= null && !patient.getAge().equals("")){
					String age = patient.getAge();
					currentAge = HMSUtil.calculateAgeForADT(age,patient.getRegDate());
					System.out.println(" else currentAge="+currentAge);
				}
				  else if(patient.getDateOfBirth()!=null){
						currentAge = HMSUtil.calculateAge(patient.getDateOfBirth());
						System.out.println("currentAge="+currentAge +patient.getDateOfBirth());
					}
			}catch(Exception ex){
				ex.printStackTrace();
			} */
	/* }
	catch(Exception exception)
	{
		currentAge="-";
	} */
	return sPatientAge;
}

/* public String getPatientCategory(Patient patient){
	String pCategory="-";

	try
	{
		pCategory =patient.getPatientType()!= null?patient.getPatientType().getPatientTypeName():"";
	}
	catch(Exception exception)
	{
		 pCategory="-";
	}
	return  pCategory;
}
 */
public String getPatientDepartment(Visit visit){
	String departmentName="-";
	try
	{
		if(visit.getHin().getEmployee().getDepartment()!=null)
			//departmentName =((MasEmployeeDepartment)(visit.getHin().getEmployee().getMasEmployeeDepartments().toArray()[0])).getDepartment().getDepartmentName();
			departmentName = visit.getHin().getEmployee().getDepartment().getDepartmentName();
	}
	catch(Exception exception)
	{
		 departmentName="-";
	}
	return  departmentName;
}

/* public String getPatientUnit(Inpatient inpatient){
	String unit="-";
	try
	{
		unit = inpatient.getUnitM().getUnitCode(); 
	}
	catch(Exception exception)
	{
		unit="-";
	}
	return unit;
} */


/* public String getUnitHead(Inpatient inpatient){
	String unitHead="-";
	try
	{
		for(HospitalDoctorUnitT doctorUnitT : inpatient.getUnitM().getHospitalDoctorUnitTs()){
			if(doctorUnitT.getHeadFleg().equalsIgnoreCase("y")){
				unitHead = doctorUnitT.getEmployee().getEmployeeName(); 
				break;
			}
			
		}
	}
	catch(Exception exception)
	{
		unitHead="-";
	}
	return unitHead;
} */

public String getPatientReferringDoctor(Inpatient inpatient){
	String refferingDoctor="-";
	try
	{
		refferingDoctor=inpatient.getDoctor().getFirstName();
		if(inpatient.getDoctor().getMiddleName()!=null)
		{
			refferingDoctor +=" "+inpatient.getDoctor().getMiddleName();
		}
		
		if(inpatient.getDoctor().getLastName()!=null)
		{
			refferingDoctor+=" "+inpatient.getDoctor().getLastName();
		}
		
	}
	catch(Exception exception)
	{
		refferingDoctor="-";
	}
	
	return refferingDoctor;
	
}


public String getPatientAdmittingDoctor(Visit visit){
	String admittingDoctor="-";

	try
	{
		admittingDoctor = visit.getDoctor().getFirstName();
		if(visit.getDoctor().getMiddleName()!=null)
		{
			admittingDoctor +=" "+visit.getDoctor().getMiddleName();
		}
		
		if(visit.getDoctor().getLastName()!=null)
		{
			admittingDoctor+=" "+visit.getDoctor().getLastName();
		} 
		
	}
	catch(Exception exception)
	{
		admittingDoctor="-";
	}
	
	return admittingDoctor;
}

public String getPatientConsultingDoctor(Inpatient inpatient){
	String consultingDoctor="-";
	try
	{
		consultingDoctor=inpatient.getDoctor().getFirstName();
		if(inpatient.getDoctor().getMiddleName()!=null)
		{
			consultingDoctor +=" "+inpatient.getDoctor().getMiddleName();
		}
		
		if(inpatient.getDoctor().getLastName()!=null)
		{
			consultingDoctor+=" "+inpatient.getDoctor().getLastName();
		}
	}
	catch(Exception exception)
	{
		consultingDoctor="-";
	}
	
	return consultingDoctor;
}

/* //added by Babita
public String getIcdDaignosis(Inpatient inpatient)
{
	String icd = "";
	try
	{
		Visit visit = inpatient.getVisit();
		Set<DischargeIcdCode> dischageIcdSet = new HashSet<DischargeIcdCode>();
		dischageIcdSet = visit.getDischargeIcdCodes();
		
		int count =0;
			for(DischargeIcdCode orderdt : dischageIcdSet){
				
				if(count++>=1)
					icd = icd.concat(", ");
				
				icd = icd.concat(orderdt.getIcd().getIcdName());
				
			}
		
	}
	catch(Exception exception)
	{
		icd = "-";
	}
	
	return icd;
} */

public String getPatientAdmitionNo(Inpatient inpatient){
	String ipNo="-";
	try
	{
		if(inpatient.getAdNo()!=null)
		  ipNo=inpatient.getAdNo();
	}
	catch(Exception exception)
	{
		ipNo="-";
	}
	return ipNo;
}
Inpatient inpatient = new Inpatient();
Visit visit = new Visit();  // added by amit das on 20-09-2016
Patient patient = new Patient(); // added by amit das on 20-09-2016
%> 

<%-- <label>Surgery Requisition Date</label> 
<label class="value"><%=getHinNo(inpatient.getHin())%></label>  <!-- commented by amit das on 20-09-2016 -->
<label class="value"><%=inpatient.getOpdSurgeryHeaders().size()!=0?HMSUtil.convertDateToStringWithoutTime(((OpdSurgeryHeader)(inpatient.getOpdSurgeryHeaders().toArray()[0])).getRequisitionDate()):"-"%></label> --%>
<label>Employee No.</label> 
<%-- <label class="value"><%=getHinNo(inpatient.getHin())%></label> --%>  <!-- commented by amit das on 20-09-2016 -->
<label class="value"><%=getHALEmpId(patient)%></label> <!-- added by amit das on 20-09-2016 -->
<%-- <label>HIN No</label> 
<label class="value"><%=getHinNo(inpatient.getHin())%></label>  <!-- commented by amit das on 20-09-2016 -->
<label class="value"><%=getHinNo(patient)%></label> <!-- added by amit das on 20-09-2016 --> --%>
<label>Patient Name</label> 
<%-- <label class="value"><%=getPatientName(inpatient.getHin())%></label> --%> <!-- commented by amit das on 20-09-2016 -->
<label class="value"><%=getPatientName(patient)%></label> <!-- added by amit das on 20-09-2016 -->
<%-- <label>Address</label> 
<label class="value"><%=getAddress(inpatient.getHin()) %></label> <!-- commented by amit das on 20-09-2016 -->
<label class="value"><%=getAddress(patient)%></label> <!-- added by amit das on 20-09-2016 -->
<div class="clear"></div> --%>
<label>Gender</label> 
<%-- <label class="value"><%=getGender(inpatient.getHin()) %></label> --%> <!-- commented by amit das on 20-09-2016 -->
<label class="value"><%=getGender(patient)%></label> <!-- added by amit das on 20-09-2016 -->
<%-- <label>Marital Status</label> 
<label class="value"><%=getMaritalStatus(inpatient.getHin()) %></label> <!-- commented by amit das on 20-09-2016 -->
<label class="value"><%=getMaritalStatus(patient)%></label> <!-- added by amit das on 20-09-2016 --> --%>
<label>Age</label> 
<%-- <label class="value"><%=getPatientAge(inpatient.getHin()) %></label> --%> <!-- commented by amit das on 20-09-2016 -->
<label class="value"><%=getPatientAge(patient)%></label> <!-- added by amit das on 20-09-2016 -->
<%-- <label>Patient Category</label> 
<label class="value"><%=getPatientCategory(inpatient.getHin()) %></label> <!-- commented by amit das on 20-09-2016 -->
<label class="value"><%=getPatientCategory(patient)%></label> <!-- added by amit das on 20-09-2016 --> --%>
<label>Department</label> 
<label class="value"><%=(inpatient!=null)?getPatientDepartment(visit):"" %></label> 
<%-- <label>Unit</label> 
<label class="value"><%=(inpatient!=null)?getPatientUnit(inpatient):"" %></label>
<div class="clear"></div> --%>
<%-- <label>Unit Head</label> 
<label class="value"><%=getUnitHead(inpatient) %></label> --%>
<label>IP No.</label> 
<label class="value"><%=getPatientAdmitionNo(inpatient) %></label><div class="clear"></div>
<%-- <label>Diagnosis</label> 
<label class="value"><%=getIcdDaignosis(inpatient) %></label> --%>
<label>Referring Doctor</label> 
<label class="value"><%=getPatientReferringDoctor(inpatient) %></label>
<label>Admitting Doctor</label> 
<label class="value"><%=getPatientAdmittingDoctor(visit) %></label>
