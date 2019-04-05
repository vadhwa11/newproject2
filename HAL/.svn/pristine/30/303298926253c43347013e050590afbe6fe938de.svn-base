<%@ page import="jkt.hms.util.RequestConstants"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasNursingCare"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.NursingcareSetup"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="jkt.hms.masters.business.SilDilStatus"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.UserEmpGroup"%>

<%@page import="jkt.hms.masters.business.AllergyDetail"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationDetail"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script type="text/javascript">
var icdArray = new Array();

</script>
<script>
<%

	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(date.length()<2){
		date="0"+date;
	}
%>
	serverdate = '<%=date+"/"+month+"/"+year%>'
</script>

<script type="text/javascript">
function openPopupWindow()
{
 var url="/hms/hms/adt?method=showICDSearchJsp";
 newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
}

function jsSetIcdData(icd_no)
{
document.getElementById("icdCode").value=icd_no;
document.getElementById("icdCode").focus();
}
function changePrint(){
 document.getElementById('printId').style.display = "inline";
} 
</script>


<%	String adt ="";
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTimeWithoutSc");
	String timeInHHmm="";
	String [] temp = null;
	temp = currentTime.split(":");
	for (int i = 0 ; i < temp.length-1 ; i++) {
		
		timeInHHmm=timeInHHmm+(String)temp[i];
    	 if(i==0)
    	 {
    		 timeInHHmm=timeInHHmm+":";
    	 }
    	 
	}
	Map map = new HashMap();
		String includedJsp="";
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
			
		}
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<Users> userList = new ArrayList<Users>();
		List inPatientDetailList = new ArrayList();
		List<MasIcd> icdNoList = new ArrayList<MasIcd>();
		if(map.get("icdNoList") != null){
			icdNoList = (List<MasIcd>)map.get("icdNoList");
		}
		if(map.get("employeeList") != null){
			employeeList = (List<MasEmployee>)map.get("employeeList");
		}
		if(map.get("userList") != null){
			userList = (List<Users>)map.get("userList");
		}
		if(inPatientDetailList != null)
		{
			inPatientDetailList=(List)map.get("inPatientDetailList");
		}
				
		String userName = "";
		String deptName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
		if(map.get("deptName") != null) {
			deptName = (String) map.get("deptName");
		}
		
		if(map.get("adt") != null) {
			adt = (String) map.get("adt");
		}
		int deptId=0;
		if(map.get("deptId") != null) {
			deptId = (Integer) map.get("deptId");
		}
		 String right = "n";
	       List<UserEmpGroup> userRights = new ArrayList<UserEmpGroup>();
	       if(map.get("userRights") != null){
	   		userRights = (List<UserEmpGroup>) map.get("userRights"); 
	   	}
	   	if(userRights.size() > 0){
	   		right = "y";
	   	}
	   String admissionNumber=null;
	   int hinId=0;
	   int inpatientId=0;
	   String patientName= "";
	   String status="";
	   String currentAge = "";
	   Inpatient inpatient = null;
		Patient patient = null;
		String hinNo="";
		String andNo ="";
		String consultantName = "";
		
	   if(inPatientDetailList != null)
	   {
		   
		   inpatient=(Inpatient)inPatientDetailList.get(0);
		   inpatientId = inpatient.getId();
		   patient = (Patient) inpatient.getHin();
		    hinId=inpatient.getHin().getId();
		    hinNo=inpatient.getHinNo();
		    andNo=inpatient.getAdNo();
		    status = inpatient.getConditionStatus()!=null?inpatient.getConditionStatus():"";
		    String age = "";
		    if(patient.getAge()!=null)
				age = patient.getAge();
			try{
				if(!age.equals(""))
				currentAge = HMSUtil.calculateAgeForADT(age,patient.getRegDate());
			}catch(Exception ex){
				ex.printStackTrace();
			}
			try
			{
				
				admissionNumber=inpatient.getAdNo();
			    session.setAttribute("admissionNumber",admissionNumber);
				
						try 
						{
							patientName = inpatient.getHin().getPFirstName() ;
							  
							   if(inpatient.getHin().getPMiddleName()!= null){
								   patientName=patientName+" "+inpatient.getHin().getPMiddleName();
							   }
							   if(inpatient.getHin().getPLastName()!= null){
								   patientName=patientName+" "+inpatient.getHin().getPLastName();
							   }
							
						} 
						catch (Exception e) 
						{
							patientName = "";
						}
						
						
						try 
						{
							/* consultantName=inpatient.getDoctor().getRank().getRankName(); */
							consultantName +=" "+ inpatient.getDoctor().getFirstName();
							if(inpatient.getDoctor().getMiddleName() != null){
								consultantName += " "+inpatient.getDoctor().getMiddleName();
							}
							if(inpatient.getDoctor().getLastName() != null){
								consultantName += " "+inpatient.getDoctor().getLastName();
							}
						} 
						catch (Exception e){ 

							consultantName = "";
						}
						
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	   }
	      
	%>
<div class="titleBg"><h2>SIL/DIL</h2></div>
<div class="Clear"></div>
<form name="silDilStatus" method="post" action="">

<h4>Patient Details</h4>
<div class="Clear"></div>
<div class="Block">

<label>A&D No.</label> <%if(inpatient.getAdNo() != null){ %>
<label class="value"><%=inpatient.getAdNo() %></label> <%}else{ %>
<label class="value">-</label>
<%} %>
<label>Employee No.</label> 
<label class="value"> <%=patient.getServiceNo()!=null?patient.getServiceNo():"" %></label>

<label>Ward </label> <%if(inpatient.getDepartment() != null){ %>
<label class="value"> <%=inpatient.getDepartment().getDepartmentName() %></label>
<%}else{ %>
<label class="value">-</label>
<%} %>

<div class="Clear"></div>
<label>Patient Name</label>
<label	class="value"> <%= patientName %></label>

<label>Relation</label> <%
	if(patient.getRelation() != null){
	%> 
<label class="value"><%= patient.getRelation().getRelationName()%></label>
<%} else{ %> <label
	class="value">-</label> 
	<% }%> 

<label>Designation</label>
<label class="value"><%=patient.getRank()!=null?patient.getRank().getRankName():"" %></label>
<div class="Clear"></div>
<label>Employee Name</label> <%
		String sMiddleName = "";
		String sLastName = "";
		if(patient.getSFirstName() != null  && !(patient.getSFirstName().equals(""))){
		
			if(patient.getSMiddleName() != null){
				sMiddleName = patient.getSMiddleName();
			}
			if(patient.getSLastName() != null){
				sLastName = patient.getSLastName();
			}
	 %> 
<label class="value"><%= patient.getSFirstName()+" "+sMiddleName+" "+sLastName%></label>
<%}else{ %> 
<label class="value">-</label> 
<% }%>
<%-- 
<label>Branch/Trade</label>
<%
if(patient.getTrade() != null){
%> 
<label class="value"><%=  patient.getTrade().getTradeName()%></label>
<%} else{ %> 
<label class="value">-</label> 
<% }%>
 --%>
<%-- 
<label>Unit</label> <%
if(patient.getUnit() != null){
%> <label class="value"><%= patient.getUnit().getUnitName()%></label>
<%} else{ %> 
<label class="value">-</label> 
<% }%> --%>
<!-- <div class="Clear"></div> -->
<label>Age</label> <%if(!currentAge.equals("")){ %>
<label class="value"> <%=currentAge %></label> <%}else{ %>
<label	class="value">-</label> <%} %>
<label>Gender</label> <%if(patient.getSex() != null){ %>
<label class="value"> <%=patient.getSex().getAdministrativeSexName() %></label>
<%}else{ %>
<label class="value">-</label> <%} %>

<%-- <label>Med Cat</label>
<label class="value"><%=patient.getCategory()!=null?patient.getCategory().getCategories():"-" %></label>
 --%>
<div class="Clear"></div>

<label>Admitting Doctor</label>
<label class="value"><%=consultantName %></label>
<%-- 
<label>Allergies</label>
<%

String allergies = "";
	if(patient.getDrugAllergies()!=null){
/*	for(AllergyDetail allergyDetail : patient.getAllergyDetails()){
		if(!allergies.equals("")){
			allergies += ",";
		}
		allergies += allergyDetail.getDescription();
	}*/
		allergies = patient.getDrugAllergies();
}%>
<%
	if(!allergies.equals("")){
%>
<label class="valueAuto"><%=allergies %></label>
<%}else{ %>
<label class="value"></label>
<%} %> --%>
<!-- <div class="Clear"></div> -->

<label> Diagnosis</label> 
<%
List<DischargeIcdCode> diagnosisList = new ArrayList<DischargeIcdCode>();
if(map.get("diagnosisList")!=null){
	diagnosisList = (List<DischargeIcdCode>)map.get("diagnosisList");
	
}
if(diagnosisList != null && diagnosisList.size() > 0 && diagnosisList.get(0).getIcd()!=null)
{
%> <label class="valueFixedWidth"><%=diagnosisList.get(0).getIcd().getIcdName()%></label>
<%
		}else{
		%> <label class="value"></label> <%	
		}
		%> 
		<%-- 
<label>Disability</label>
<%
	List<MasMedicalExaminationDetail> disabilityList = new ArrayList<MasMedicalExaminationDetail>();
	if(map.get("disabilityList")!=null){
		disabilityList = (List<MasMedicalExaminationDetail>)map.get("disabilityList");
	}
	
	if(disabilityList != null && disabilityList.size() > 0)
	{
	%> <label class="valueFixedWidth"><%=disabilityList.get(0).getMasIcd()!=null?disabilityList.get(0).getMasIcd().getIcdName():"" %></label>
<%
	}else{
	%> <label class="value"></label> <%	
	}
%> 
 --%>
<div class="Clear"></div>

</div>
<div class="Clear"></div>
<div class="clear paddingTop15"></div>
<h4>SIL/DIL</h4>
<div class="Clear"></div>
<table width="100%" colspan="7" id="tblSample" cellpadding="0"	cellspacing="0">
	<tbody>
		<tr>
			<th scope="col">Date</th>
			<th scope="col">Time</th>
			<th scope="col">SIL</th>
			<th scope="col">DIL</th>
			<th scope="col">NORMAL</th>
			<th scope="col">Condition</th>
			<th scope="col">Placed By</th>
			<th scope="col">NOK Informed</th>
			<th scope="col">Remarks</th>
			<!--<th colspan="3">Diagnosis</th>
			<th scope="col"></th>
			<th width="10%">Treatment</th>
		--></tr>
		<tr>
			<td>
			<input type="text" id="mlcDateId" name="date"	value="<%=currentDate %>" readonly="readonly"
				validate="Date,date,no" MAXLENGTH="30" size="10" onblur="dateCheck();"/>
				
			<img id="calendar" src="/hms/jsp/images/cal.gif" validate="Pick a date" class="calender"	onClick="setdate('',document.silDilStatus.date,event)" /></td>

			<td><input type="text" align="right"
				name="silDilTime" maxlength="5" value="<%=currentTime %>"
				size="10" /></td>
			<td>
			<% if(status.equals("SIL")){ %> <input type="radio" align="right"
				name="parent" checked="checked"  value="sil" id="parent1" /> <%}else{ %>
			<input type="radio" " align="right" name="parent" value="sil"
				id="parent1" /> <%} %>
			</td>
			<td>
			<% if(status.equals("DIL")){ %> <input type="radio" align="right"
				name="parent" checked="checked" value="dil" id="parent1" /> <%}else{ %>
			<input type="radio" align="right" name="parent" value="dil"
				id="parent1" /> <%} %>
			</td>
			<td>
			<% if(status.equals("Normal")){ %> <input type="radio" align="right"
				name="parent" value="normal" checked="checked" id="parent" /> <%}else{ %>
			<input type="radio" align="right" name="parent" value="normal"
				id="parent" /> <%} %>
			</td>
			<td><select name="condition" id="conditionId">
				<option value="">Select</option>
				<option value="Critical">Critical</option><!--
				<option value="Critical But Stable">Critical But Stable</option>
				--><option value="Improved">Improved</option>
				<option value="Stable">Stable</option>
			</select></td>
			<td><select id="placedBy" name="placedBy"
				validate="Placed By,num,Yes" class="auto">
				<option value="">Select</option>
				<% 
		for (MasEmployee  obj : employeeList){
			if(obj.getEmpCategory() != null) {
			if(obj.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor)){
			
				String doctorMiddleName = "";
				String doctorLastName = "";
				String rankName ="";
					doctorMiddleName = obj.getMiddleName()!=null?obj.getMiddleName():"";
					doctorLastName = obj.getLastName()!=null?obj.getLastName():"";
					if(obj.getRank() != null){
						rankName = obj.getRank().getRankName();
					}
				
	%>
				<option value="<%=obj.getId()%>"><%=obj.getFirstName()+" "+doctorMiddleName+" "+doctorLastName%>
				</option>
				<%  }}
	}%>
	
	<%-- <% 
		for (Users  obj : userList){
			if(obj.getEmployee().getEmpCategory() != null) {
			if(obj.getEmployee().getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor)){
			
				String doctorMiddleName = "";
				String doctorLastName = "";
				String rankName ="";
					doctorMiddleName = obj.getEmployee().getMiddleName()!=null?obj.getEmployee().getMiddleName():"";
					doctorLastName = obj.getEmployee().getLastName()!=null?obj.getEmployee().getLastName():"";
					if(obj.getEmployee().getRank() != null){
						rankName = obj.getEmployee().getRank().getRankName();
					}
				
	%>
				<option value="<%=obj.getId()%>"><%=obj.getEmployee().getFirstName()+" "+doctorMiddleName+" "+doctorLastName%>
				</option>
				<%  }}
	}%> --%>
			</select></td>
			<td><select name="nokType" id="nokType">
				<option value="yes">Yes</option>
				<option value="no">NO</option>
			</select></td>
			
			<td>
			<input type="text" name="remarks" id="remarks" value="" maxlength="150" tabindex="1" size="28"/>
		</td>
			<%--
			<td width="10%"><input type="text" align="right" name="icdCode"
				id="icdCode"
				onblur="if(getIcdStringSilDil()){fillDiagnosisCombo();}"
				tabindex="1" size="8" /></td>
			<td width="10%"><img src="/hms/jsp/images/s_search.gif"
				width="26" height="26" style="cursor: pointer;"
				onclick="javascript:openPopupWindow();" /></td>
			<td width="10%"><input type="text" value=""
				id="icd" name="icd" onblur="fillDiagnosisCombo();" tabindex="1" />
			<div id="ac2update"
				style="height: 150px; overflow: scroll; display: none; border: 1px solid #000"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('icd','ac2update','ipd?method=getICDList',{parameters:'requiredField=icd'});
			</script></td>
			<td width="10%"><select name="<%=DIAGNOSIS_ID%>" size="3"
				multiple="3" class="autoList" id="diagnosisId">
				<option value="0">Select</option>
			</select></td>
			
			<td width="10%"><input type="text" align="right"
				name="treatment" maxlength="250" /></td>
			
		--%></tr>
	</tbody>
</table>


<div class="Clear"></div>
<div class="clear paddingTop15"></div>

<h4>SIL/DIL History</h4>
<div class="Clear"></div>
<div class="">
<table width="100%" colspan="7" id="tblSample" cellpadding="0"	cellspacing="0">
	<tbody>
		<tr>
		<!--  	<th width="1%"></th>-->
			<th scope="col">Sl No.</th>
			<th scope="col">DATE</th>
			<!--  <th width="20%" class="rowheader">Diagnosis</th>-->
			<th scope="col">Time</th>
			<th scope="col">List Status</th>
			<!--<th width="1%" class="rowheaderSm">Patient Condition</th>-->
			<th scope="col">Condition</th>
			<!--<th width="5%" class="rowheader">Treatment</th>-->
			<th scope="col">NOK Informed</th>
			<th scope="col">Remarks</th>

		</tr>

		<%
			int i=1;
			if(map.get("siList") != null)
			{
				List siList=(List)map.get("siList");
				Iterator itr=siList.iterator();
				while(itr.hasNext())
				{
				  SilDilStatus silDilStatus=(SilDilStatus)itr.next();
				  String nomenclature = "";
				  if(silDilStatus.getIcd() !=null){
				   nomenclature=silDilStatus.getIcd().getIcdSubCategory().getIcdSubCategoryName()+":"+silDilStatus.getIcd().getIcdName()+"["+silDilStatus.getIcd().getIcdCode()+"]";
				  }
				  String patientCondition=silDilStatus.getConditionStatus()!=null?silDilStatus.getConditionStatus():"";
				  String remarks=silDilStatus.getRemarks()!=null?silDilStatus.getRemarks():"";
				  String remarks1 ="";
				  remarks1 =silDilStatus.getSil_dil_Remarks()!=null?silDilStatus.getSil_dil_Remarks():"" ;
				  String treatment=silDilStatus.getTreatment()!=null?silDilStatus.getTreatment():"";
				  String dateOfDiagnosis =HMSUtil.changeDateToddMMyyyy(silDilStatus.getLastChgDate());
				  String nok=silDilStatus.getNok()!=null?silDilStatus.getNok():"";
				  String silDilTime=silDilStatus.getLastChgTime();
				  if(nok==null)
				  {
					  nok="-";
				  }
		%>


		<tr>
			<!--  <td width="1%"><input type="radio" align="right"
				name="historyId" value="sil" id="historyId" onclick="changePrint();" />
			</td>-->
			<td><%=i %></td>

			<td><label><%=dateOfDiagnosis %></label>
			</td>
			<td><label><%=silDilTime %></label>
			</td>
			
		<%-- 	<td width="20%"><input readonly="readonly"
				value="<%= nomenclature %>" class="bigcaption"></td>--%>
				

			<td><label><%=patientCondition %></label></td>

			<td><label><%=remarks %></label></td>
			<%-- <td width="5%"><label><%=treatment %></label></td>--%>
			<td><label><%=nok %></label></td>
			<%if(remarks1 != null){ %>
			<td><%= remarks1 %></td>
			<%}else{ %>
			<td>--</td>
			<%} %>
		</tr>
		<%	
		   		i++;
				}
				
			}
		%>

	</tbody>
</table>
</div>

<input type="hidden" name="hdb" value="1" id="hdb" />
<input type="hidden" name="inpatientId" value="<%=inpatientId %>" id="inpatientId" />
 <input type="hidden" name="hinId" value="<%=hinId %>" id="hinId" />
<input type="hidden" name="serviceNo" value="<%=patient.getServiceNo() %>" id="serviceNo" />
<input type="hidden" name="adNo" value="<%=inpatient.getAdNo() %>" id="adNo" />
<input type="hidden" name="hinNo" value="<%=hinNo%>" id="hinNo" /> 
 <input type="hidden" name="date2" value="<%=currentDate %>" id="currentDate"> 
 <input type="hidden" name="time"	value="<%=timeInHHmm%>">
  <input type="hidden" name="deptName" value="<%=deptName%>"> 
  <input type="hidden" name="deptId" value="<%=deptId%>">
   <input type="hidden" name="userName"	value="<%=userName%>">
	<input type="hidden" name="rights" id="rights" value="<%=right%>">
<div class="Clear"></div>
<div class="Clear"></div>



<input type="button" name="Submit" value="Save" align="right"
	class="button"
	onClick="if(checkForICD()){submitForm('silDilStatus','/hms/hms/ipd?method=submitSilDilStatus');}" />

<input type="button" name="Submit" value="Print" align="right"
	class="button"
	onClick="submitForm('silDilStatus','/hms/hms/ipd?method=showSilDilReport');" />


<input type="button" class="button" value="Back" align="right"
	onClick="submitForm('silDilStatus','ipd?method=showPatientListJsp');" />

</form>





<script type="text/javascript">
 


	function checkICDCode()
	{
		var icdCode=document.getElementById("icdId").value
		
	  if(icdCode == 0)
	  {
	   alert("Please Select the ICD Code to submit.")
	   return false;
	  }
	  	  return true;
	}


	function checkForICD(){
	
	// var diagnosisLength=parseInt(document.getElementById("diagnosisId").length)
	//if(diagnosisLength == 1){
	  //  var icd=document.getElementById("icd").value
	//	if(icd != "")
	//	{
	//	    var index1 = icd.lastIndexOf("[");
	//	    var indexForBrandName=index1;
	//	    var index2 = icd.lastIndexOf("]");
	//	    index1++;
	//	    var brandId = icd.substring(index1,index2);
	//	    var indexForBrandName=indexForBrandName--;
	//	    var brandName=icd.substring(0,indexForBrandName);
		   
	//   	 if(brandId =="")
	 //    {
	 //      alert("Please select the correct value for ICD.")
	  //    return false;
	   //  }
	    
	  //}else{
	  	// alert("Please Select the ICD Code to submit.")
	    // return false;
	  //}
	  
	 // }
	var msg ="";
	 if(document.getElementById("conditionId").value =="0"){
	  msg ="Please select Condition \n"
	    
	  }
	  if(document.getElementById("placedBy").value ==""){
	   msg = msg + "Please select Placed By"
	     
	  }
	  if(msg ==""){
	   return true;
	   }else{
	   	alert(msg);
	   	return false
	   }
	}
	
	function fillDiagnosisCombo() {
	var val =document.getElementById("icd").value
  	  var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var id = val.substring(index1,index2);
	    if(id !=""){
		obj =document.getElementById('diagnosisId'); 
		obj.length = document.getElementById('diagnosisId').length;
		
	        	obj.length++;
				obj.options[obj.length-1].value=id
				obj.options[obj.length-1].text=val
				obj.options[obj.length-1].selected=true
				document.getElementById('icd').value =""
				}
    
  }
  function checkRadio(){
  alert(document.getElementsByName('historyId').checked)
  if(document.getElementsByName('historyId').checked == true){ 
  return true;
  }else{
  	alert("Please Select radio")
  	return false
  }
  }


function dateCheck(){
    var disDate = document.getElementById('mlcDateId')
    var curDate = document.getElementById('currentDate')
    var right   = document.getElementById('rights').value
    var disDate1   = new Date(disDate.value.substring(6),(disDate.value.substring(3,5) - 1) ,disDate.value.substring(0,2));
	var currdate = new Date(curDate.value.substring(6),(curDate.value.substring(3,5) - 1) ,curDate.value.substring(0,2));
	currdate.setDate(currdate.getDate() - 2);
	if(right == "n"){
	if(disDate1.value != "" && currdate.value != ""){
	 if(disDate1 < currdate){
	  alert("Date should not be less than 2 day before today's date !");
	   document.getElementById('mlcDateId').value ="";
	   return false;
	  }
	}else{
	 return false;
	}
	}else{
	return true;
	}
}

</script>




