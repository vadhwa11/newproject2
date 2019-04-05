<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * appSetup.jsp  
 * Purpose of the JSP -  This is for Appointment Setup Screen.
 * @author  Priyanka
 * Create Date: 10th july,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.2  
--%>

<%@ page import = "static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@ page import="jkt.hms.util.Box" %>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.AppSetup"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<!--main content placeholder starts here-->
<div id="contentHolder">
<form name="appSetup" method="post" action="" id="appSetup">
<script type="text/javascript" language="javascript">
var deptSelected=false;
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
	
	var noRecords=true;
	function validateMandatoryFields()
	{
		var inc=0;
		
		for(inc=0;inc<7;inc++)
		{	
		
		 if(document.getElementById("dr"+inc).value!='' )
		 {		
			 	noRecords=false;
				if(document.getElementById("fromTime"+inc).value=='')
				{
					alert("Please fill From Time");
					document.getElementById("fromTime"+inc).focus();
					return false; 
				}
				if(document.getElementById("toTime"+inc).value=='')
				{
					alert("Please fill To Time");
					document.getElementById("toTime"+inc).focus();
					return false; 
				}
				if(document.getElementById("slotDuration"+inc).value=='')
				{
					alert("Please fill Slot Duration");
					document.getElementById("slotDuration"+inc).focus();
					return false; 
				}
			
			
				if(document.getElementById('fromTime'+inc).value!='' && document.getElementById('toTime'+inc).value!='')
				{
					if(document.getElementById('fromTime'+inc).value >= document.getElementById('toTime'+inc).value)
					{
						alert("'From Time' should be less than 'To Time' for row "+ eval(inc+1));
						document.getElementById('fromTime'+inc).value="";
						document.getElementById('toTime'+inc).value="";
						return false;
					}
				}
				if(document.getElementById('breakFromTime'+inc).value!='' && document.getElementById('breakToTime'+inc).value!='')
				{
					if(document.getElementById('breakFromTime'+inc).value >= document.getElementById('breakToTime'+inc).value)
					{
						alert("'Break From Time' should be less than 'Break To Time' for row "+ eval(inc+1));
						document.getElementById('breakFromTime'+inc).value="";
						document.getElementById('breakToTime'+inc).value="";
						return false;
					}
				}

				if(document.getElementById("dr"+inc).value!='' && document.getElementById("validFrom"+inc).value=='' )
				{
					alert('Valid from Date cannot be blank');
					document.getElementById("validFrom"+inc).focus();
					return false; 
				}
		  }else{//eof No. Of Docs check
			  
	      }
		  	
		}

		if(noRecords){
		  	alert("No. Of Doctors cannot be blank");
		  	document.getElementById("dr"+inc).focus();
		  	return false;
		}
		return true;
	}


function compareTime()
{
	if(document.getElementById('fromTime').value >= document.getElementById('toTime').value)
	{
		alert("From Time should be less than To Time");
		return false;
	}
	return true;
		 
}
function checkDept()
{
	if(deptSelected==false){
		alert("Select department!!");
		return false;	
	}
	return true;
}

		
function showReport(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/appointment?method=printAppointmentSetupJsp";
  obj.submit();
}


function getDoctorList(deptId){

if(deptId!=''){
	//submitProtoAjaxWithDivName('appSetup','/hms/hms/appointment?method=getHospitalName&deptId=+this.value+,'doctorList');" validate="Department,number,no");
			submitProtoAjaxWithDivName('appSetup','/hms/hms/appointment?method=getDoctorList&deptId='+deptId,'defaultList');
}
}


	</script>
<div class="titleBg">
<h2>Appointment Setup</h2>
</div>

<div class="Clear"></div>

	 <%
			 	String userName = "";
			 	if (session.getAttribute("userName") != null) {
			 		userName = (String) session.getAttribute("userName");
			 	}
			 	Map<String, Object> utilMap = new HashMap<String, Object>();
			 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			 	String currentDate = (String) utilMap.get("currentDate");
			 	String time = (String) utilMap.get("currentTime");
			 	int deptIdinMap = 0;
		
			 	Box box=HMSUtil.getBox(request);
			 	
			 	String currenDate = (String) utilMap.get("currentDate");
			 	String currentTime = (String) utilMap.get("currentTime");
			 	
			 	String url=null;
			 	String[] day=new String[7];
			 	
			 	day[0]="Sunday";
			 	day[1]="Monday";
			 	day[2]="Tuesday";
			 	day[3]="Wednesday";
			 	day[4]="Thursday";
			 	day[5]="Friday";
			 	day[6]="Saturday";

			 	Map<String, Object> map = new HashMap<String, Object>();
			 	
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
					 	
			 		
			 	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			 	List<AppSetup> appSetupList = new ArrayList<AppSetup>();
			 	
				if (map.get("appSetupList") != null) {
					appSetupList = (List<AppSetup>) map.get("appSetupList");
				 	 deptIdinMap  = Integer.parseInt(map.get("deptIdinMap").toString());
			 		
			 	}
				if (map.get("departmentList") != null) {
					departmentList = (List<MasDepartment>) map.get("departmentList");
			 		
			 	}
			 	if(map.get("message") != null){
					String message = (String)map.get("message");
					%>
				<label class="noWidth"><span><%=message %></span></label>					
					<%    
					   
					  }		 	
			 %>	

<div class="Block">
  <label>Department <span>*</span></label>

	<%-- <select id="diagnosisId" name="<%=DEPARTMENT_ID%>" validate="Department,number,no"> --%>
<%-- <select id="diagnosisId" name="<%=DEPARTMENT_ID%>" onchange="getDetails(this.value);" validate="Department,number,no" > --%>
<select id="deptId" name="<%=DEPARTMENT_ID%>" onchange="submitProtoAjaxWithDivName('appSetup','/hms/hms/appointment?method=getDoctorDetails','doctorNSessionList');">
			<option value="0">Select</option>
			<%
				int deptId=(Integer)session.getAttribute("deptId");
				if(departmentList!= null){
				for (MasDepartment masDepartment : departmentList) {
			%>
	
							<option value="<%=masDepartment.getId()%>" ><%=masDepartment.getDepartmentName()%></option>
		
			<%}
				}
			%>
		</select>
		
		
		<div id="doctorNSessionList" >
		<label>Doctor List<span>*</span> </label>
		<select id="doctorId" name="doctorList">
		<option value="0"></option>
		</select>
		
		<label>Session<span>*</span> </label>
		<select id="sesId" name="sessionList">
		<option value="0"></option>
		</select>		
		</div>
			
	<div class="Clear"></div><div class="Clear"></div>	
    <!-- <input name="Print" type="button" value="Generate Report" target="_blank" class="cmnButton" onClick="showReport('appSetup');"> -->
    <input name="Print" type="button" value="Show Setup" target="_blank" class="button" onClick="getDetails();">
    <!-- <input name="Print" type="button" value="Show Setup" target="_blank" class="cmnButton"   onclick="if(validateDatefield()){ getDetails();}" /> -->
  
  
</div>
<!--Block one Ends-->
<div class="Clear"></div>

<!--Block Three Starts-->
<div class="colsHolder">

<%-- <% 
	int deptMap=0;
	if(box.getInt(DEPARTMENT_ID)==0){
		deptMap=(Integer)map.get("deptIdinMap");
	}
	else{
		deptMap=box.getInt(DEPARTMENT_ID);
	}
if (appSetupList!=null)
     {
    %>
    	 <label class="common">Selected Department:</label>
    	 <input type="hidden" id="departmentId" name="<%=WARD_ID%>" value="<%=deptMap%>"  />
    <%
    
    	 Iterator ite=departmentList.iterator();
    	 while ( ite.hasNext() ) {
     		MasDepartment masDepartment=(MasDepartment)ite.next();
     		if(masDepartment.getId()==deptMap)
     		{
     			
     			
     %>	<script type="text/javascript">deptSelected=true;</script>	
    	 <label class="value"> <%=masDepartment.getDepartmentName()%></label>
    <%		}
    	 }
     }
    %> --%>
<div class="clear"></div></div>
<div id="deptDiv"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<table border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Days</th>
		<!--<th scope="col">No. of Doctors</th>
		-->
		<!-- <th scope="col">From Time:</th>
		<th scope="col">To Time</th>
		<th scope="col">Slot Duration</th>
		<th scope="col">% for Slot</th>
		<th scope="col">Break From Time</th>
		<th scope="col">Break To Time</th>
		<th scope="col">Break From Time 2</th>
		<th scope="col">Break To Time 2</th>
		<th scope="col">Break From Time 3</th>
		<th scope="col">Break To Time 3</th> -->
		<th scope="col">Token Start No.</th>
		<th scope="col">Token Interval</th>
		<th scope="col">Total Token</th>
		<th scope="col">Total Online Token</th>
		<th scope="col">Max No. of Days</th>
		<th scope="col">Min No. of Days</th>
	</tr>
	<%

     	int inc = 0;
     if(appSetupList!=null && appSetupList.size()<=0)
     {
    	 
    	 url="submitForm('appSetup','appointment?method=submitAppointmentSetup');";
    	for(inc=0;inc<7;inc++){
    		System.out.println("inc"+inc);
    	%>

	<tr>
	<input type="hidden" name="<%=APPOINTMENT_ID%>" id="appointmentId<%=inc%>"
			value=""  />
		<input type="hidden" id="days<%=inc%>" name="<%=DAYS%>"
			value="<%=day[inc]%>" />
		<td><%=day[inc]%></td>
		
		<td><input type="text" size=8 id="TokenStart<%=inc%>" autocomplete="off"
			name="TokenStart" 
			 MAXLENGTH="8" validate='Days,int,no'
			id="breakToTime2" onkeyup="setOnlineToken('TokenStart<%=inc%>','TotalToken<%=inc%>','TokenInterval<%=inc%>','TotalOnlineToken<%=inc%>','1');"/></td>	
		<td><input type="text" size=8 id="TokenInterval<%=inc%>"
			name="TokenInterval" 
			 MAXLENGTH="8"
			id="breakFromTime3" autocomplete="off" onkeyup="setOnlineToken('TokenStart<%=inc%>','TotalToken<%=inc%>','TokenInterval<%=inc%>','TotalOnlineToken<%=inc%>','1');"/></td>
				
		<td><input type="text" size=8 id="TotalToken<%=inc%>"
			name="TotalToken" autocomplete="off" onkeyup="setOnlineToken('TokenStart<%=inc%>','TotalToken<%=inc%>','TokenInterval<%=inc%>','TotalOnlineToken<%=inc%>','1');"
			 MAXLENGTH="8"
			id="breakToTime3" /></td>	
			
			<td><input type="text"  size=8 id="TotalOnlineToken<%=inc%>"
			name="TotalOnlineToken" onkeyup="setOnlineToken('TokenStart<%=inc%>','TotalToken<%=inc%>','TokenInterval<%=inc%>','TotalOnlineToken<%=inc%>','2');"
			 MAXLENGTH="8"
			id="breakToTime3" /></td>		
				
		<td><input type="text" size=8 id="maxDays<%=inc%>"
			name="<%=MAXDAYS%>" MAXLENGTH="2" autocomplete="off" validate="Max. no. of Days,num,no" /></td>
		<td><input type="text" size=8 id="minDays<%=inc%>"
			name="<%=MINDAYS%>" MAXLENGTH="2" autocomplete="off" validate="Min no. of Days,num,no" /></td>
	</tr>

	<%	}
     }%>
    
   <input  type="hidden" value="<%=inc%>" name="totalRow" id="totalRowId"/>
   
</table>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<% System.out.println(" url "+url); %>
<div id="addId">
<%-- <input name="" type="button" class="button" value="Submit"
	onclick="if(validateDatefield()){<%=url%>}" />  --%>
	</div>
	<div id="updateId" style="display: none">
<!-- <input name="" type="button" class="button" value="Update"
	onclick="if(validateDatefield()){ submitForm('appSetup','appointment?method=updateAppointmentSetup');}" />  -->
	</div>
<!-- <input name="" type="reset" class="button" value="Reset" /> Bottom labels starts -->
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom"><label>Changed By </label> <label
	class="value"><%=userName %></label> <label>Changed Date </label> <label
	class="value"><%=currenDate %></label> <label>Changed Time </label> <label
	class="value"><%=currentTime%></label></div>
<!--Bottom labels ends-->
<div class="clear"></div>
</form>
</div>
<!--main content placeholder ends here-->
<script type="text/javascript">
function validateDatefield(){
	
	
	var deptId = document.getElementById("deptId").value;
	var docId = document.getElementById("doctorId").value;
	var sesId = document.getElementById("sesId").value;

	if(deptId==0 || docId==0 || sesId==0)
		{
         if(deptId==0)
	       {
		     alert("Please select Department");
		   }
		 else if(docId==0)
		   {
			alert("Please select Doctor");
		   }
		
		else if(sesId==0)
		   {
			alert("Please select Session");
		   }
	
	        return false;
		}
	
	var totalRow=document.getElementById('totalRowId').value;
	
	var errorMessage="";
	var flag = true;
	for(var k=0;k<totalRow;k++){
		
		if(document.getElementById('TokenStart'+k).value!="" && document.getElementById('TokenInterval'+k).value!="" 
			&& document.getElementById('TotalToken'+k).value!="" && document.getElementById('TotalOnlineToken'+k).value!=""
			    && document.getElementById('maxDays'+k).value!="" && document.getElementById('minDays'+k).value!=""){
        	flag = false;
        	break;
        	}
		/* else
			{
		flag = true;
		break;
			} */
		

	} 
	if(flag == false)
	{	
	return true;
	}
	else{
	alert("Please Fill atleast one row!!!!");
	return false;
} 
	} 


/* function getDetails(val){	
	alert(val)
	submitForm('appSetup','/hms/hms/appointment?method=getRecords&deptId='+val);	
} */
</script>