<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * doctorRaster.jsp  
 * Purpose of the JSP -  This is for doctor raster Setup Screen.
 * @author  Priyanka
 * Create Date: 10th july,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.2  
--%>

<%@page import="jkt.hms.masters.business.DoctorRoaster"%>
<%@ page import = "static jkt.hms.util.RequestConstants.*" %>
<%@page import="java.text.ParseException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@ page import="jkt.hms.util.Box" %>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.AppSetup"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<!--main content placeholder starts here-->
<div id="contentHolder">
<!-- <form name="appSetup" method="post" action="" id="appSetup"> -->
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
<h2>Doctor Roaster</h2>
</div>

<div class="Clear"></div>

	 <%
			 	String userName = "";
	 int doctorId = 0;
			 	if (session.getAttribute("userName") != null) {
			 		userName = (String) session.getAttribute("userName");
			 	}
			 	Map<String, Object> utilMap = new HashMap<String, Object>();
			 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			 	//String currentDate = (String) utilMap.get("currentDate");
			 	//String time = (String) utilMap.get("currentTime");
			 	int deptIdinMap = 0;
		
			 	Box box=HMSUtil.getBox(request);
			 	
			 	String currentDate = (String) utilMap.get("currentDate");
			 	String currentTime = (String) utilMap.get("currentTime");
			 	
	

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
				
			//	System.out.println("hh "+departmentList.size()+" hhj"+map.get("departmentList")); 
				
				if (map.get("departmentList") != null) {
					departmentList = (List<MasDepartment>) map.get("departmentList");
							
			 	}
			 	if(map.get("message") != null){
					String message = (String)map.get("message");
					%>
				<label><span><%=message %></span></label>					
					<%    
					   
					  }		
			 	
			 	String fromDate=null;
			 	if(map.get("fromDate") != null){
					 fromDate = (String)map.get("fromDate");
					  }	
			 	
		int deptId=0;
		if(map.get("deptId") != null){
			 deptId = (Integer)map.get("deptId");
			}	
		boolean view=true;
		if(map.get("view") != null){
			view = (Boolean)map.get("view");
			}	
		view = false;
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
	     if (map.get("doctorList") != null) {
	 		doctorList = (List<MasEmployee>) map.get("doctorList");
    	 	}
	     List<DoctorRoaster> docRoasterList = new ArrayList<DoctorRoaster>();
	     if (map.get("docRoasterList") != null) {
	    	 docRoasterList = (List<DoctorRoaster>) map.get("docRoasterList");
    	 	}
	     
	     Map<Integer, List<DoctorRoaster>> RoasterMap = new HashMap<Integer, List<DoctorRoaster>>();
	     if (map.get("RoasterMap") != null) {
	    	 RoasterMap = (Map<Integer, List<DoctorRoaster>>) map.get("RoasterMap");
    	 	}
			List<MasEmployee> doctorListDeptWise = new ArrayList<MasEmployee>();
	     if (map.get("doctorListDeptWise") != null) {
	    	  doctorListDeptWise = (List<MasEmployee>)map.get("doctorListDeptWise");
    	 	}
	     
	     if (map.get("doctorId") != null) {
	    	 doctorId = (Integer)map.get("doctorId");
   	 	}
	     
			 %>	

<div class="Block">
<form name="roasterSetup" method="post" action="" id="roasterSetup">
  <label>Department <span>*</span></label>

	<%-- <select id="diagnosisId" name="<%=DEPARTMENT_ID%>" validate="Department,number,no"> --%>
<%-- <select id="diagnosisId" name="<%=DEPARTMENT_ID%>" onchange="getDetails(this.value);" validate="Department,number,no" > --%>
<%-- <select id="deptId" name="<%=DEPARTMENT_ID%>" onchange="submitProtoAjaxWithDivName('appSetup','/hms/hms/appointment?method=getDoctorDetails','doctorNSessionList');"> --%>
		<select id="<%=DEPARTMENT_ID %>" name="<%=DEPARTMENT_ID %>"
						onchange="fnGetDoctorDepartment(this.value,'refereddoctor','y');" validate="Department,number,yes">>
			<option value="">Select</option>
			<%
				//System.out.println("d"+departmentList.size());
				for (MasDepartment masDepartment : departmentList) {
					 if(deptId==masDepartment.getId()){
			%>
		<option value="<%=masDepartment.getId()%>" selected="selected"><%=masDepartment.getDepartmentName()%></option>
	      <%}else{ %>	
			<option value="<%=masDepartment.getId()%>" ><%=masDepartment.getDepartmentName()%></option>
			<%}}
				
			%>
		</select>
		
		
		<label>Doctor </label> <select id="refereddoctor"
						name="refereddoctor">
						<option value="0">Select</option>
						
		<%				for(MasEmployee doctor: doctorListDeptWise)
	 {
			if(doctor.getId()==doctorId){
		%>
		    <option value="<%=doctor.getId() %>" selected="selected"> <%= doctor.getFirstName()+" "+(doctor.getMiddleName()!=null?doctor.getMiddleName():"")+" "+(doctor.getLastName()!=null?doctor.getLastName():"") %> </option>
		<%}else{ %>
		<option value="<%=doctor.getId() %>"> <%= doctor.getFirstName()+" "+(doctor.getMiddleName()!=null?doctor.getMiddleName():"")+" "+(doctor.getLastName()!=null?doctor.getLastName():"") %> </option>             
	 <%}}
     %>
						
					</select>
		<div class="Clear"></div>
	 <label>From Date</label>
<input type="text" name='fromDate' readonly="readonly" id="fromDate"  value="<%=fromDate!=null?fromDate:"" %>" validate="from date,string,yes"/>
 <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0"  class="calender" tabindex="1"	onClick="setdate('<%=currentDate%>',document.getElementById('fromDate'),event)" /></td>
   
<input name="Print" type="button" value="Search" target="_blank" class="button"   onclick="getDetails();" />

<!-- <input type="button" name="Search" value="Search" class="button"
	onClick="submitForm('search','/hms/hms/user?method=showDoctorRoasterJsp');" /> -->
 
 <!-- 	<input type="button" name="Reset" value="Reset" class="button"
		onClick="submitForm('search','/hms/hms/ot?method=showPreOperativeCheckList');" /> -->
			
	<div class="Clear"></div><div class="Clear"></div>	
    <!-- <input name="Print" type="button" value="Generate Report" target="_blank" class="cmnButton" onClick="showReport('appSetup');"> -->
  <!--   <input name="Print" type="button" value="Show Setup" target="_blank" class="button" onClick="getDetails();"> -->
     <!-- <input name="Print" type="button" value="Show Setup" target="_blank" class="cmnButton"   onclick="if(validateDatefield()){ getDetails();}" /> -->
    
 
  </form>
</div>
<!--Block one Ends-->
<div class="Clear"></div>

<!--Block Three Starts-->
<div class="colsHolder">


<div class="clear"></div></div>
<div id="deptDiv"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<form name="roaster" method="post" action="" id="roaster">

<%

int inc=1;
int i=0;
String dt = fromDate;
//String dt = "06/03/2017";
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

Calendar c = Calendar.getInstance();
//System.out.println("view "+view);
view =false;
if(view)
{ 
	
	
	if(RoasterMap.size()>0){


	try {
		c.setTime(sdf.parse(dt));
	} catch (ParseException e) {
		e.printStackTrace();
	}
%>
<table border="0" cellspacing="0" cellpadding="0">
	<tr><th>Doctor</th>
	<%
	for( i=0;i<=6;i++){
	%>
	<th><input type="hidden" name="roasterDate<%=i%>" value="<%=HMSUtil.convertDateToStringFormat(c.getTime(), "dd/MM/yyyy")%>">
	<%=HMSUtil.convertDateToStringFormat(c.getTime(), "dd/MM/yyyy")%></th>
	<%
	c.add(Calendar.DATE, 1);inc++;  
	} %>

</tr>
<%
for (Map.Entry<Integer, List<DoctorRoaster>> EmpList : RoasterMap.entrySet()) 
{
%>
<tr>	
<td><%=EmpList.getValue().get(0).getDoctor().getFirstName() %></td>
<%	List<DoctorRoaster> values = EmpList.getValue();
try {
	c.setTime(sdf.parse(dt));
} catch (ParseException e) {
	e.printStackTrace();
}
	 for(DoctorRoaster dr :values)
	 {

%>			 
		  <th style="background-color: #aaff80;">	  <input type="hidden" value="<%=dr.getId()%>" name="mrng<%=i%>roaster<%=EmpList.getKey()%>">
		  <%if(dr.getRoasterValue().substring(0, 1).equals("y")){ %>
		  <input tabindex="1" type="checkbox" name="mrng<%=i%>doc<%=EmpList.getKey()%>" id="mrng<%=i%>doc<%=EmpList.getKey()%>" value="y" onclick="fillCheckBoxValue(this.id);" checked="checked"  disabled="disabled"/>
		  <%}
		  else{
		  %>
		  <input tabindex="1" type="checkbox" name="mrng<%=i%>doc<%=EmpList.getKey()%>" id="mrng<%=i%>doc<%=EmpList.getKey()%>" value="n" onclick="fillCheckBoxValue(this.id);" disabled="disabled"/>
		  <%} %>
		  
		  	  <%if(dr.getRoasterValue().substring(1, 2).equals("y")){ %>
		  <input tabindex="1" type="checkbox" name="evn<%=i%>doc<%=EmpList.getKey()%>" id="evn<%=i%>doc<%=EmpList.getKey()%>" value="y" onclick="fillCheckBoxValue(this.id);" checked="checked" disabled="disabled"/>
		  <%}
		  else{
		  %>
		  <input tabindex="1" type="checkbox" name="evn<%=i%>doc<%=EmpList.getKey()%>" id="evn<%=i%>doc<%=EmpList.getKey()%>" value="n" onclick="fillCheckBoxValue(this.id);" disabled="disabled"/>
		  <%} %>
		<br/>&nbsp; M&nbsp;&nbsp;&nbsp;&nbsp;1
<%		 
		 i++;c.add(Calendar.DATE, 1);
%>
</th>
<%	 }
%>

</tr>	
<%inc++;}

%>
	</table>
<%	
  }
else
{
%>
No Records found.
<%	
}
}
else{

if(fromDate!=null){
	try {
		c.setTime(sdf.parse(dt));
	} catch (ParseException e) {
		e.printStackTrace();
	}
	
	String fieldDisable="";
	 Date currentDate1 = new Date();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		try {
			currentDate1 = df.parse(df.format(currentDate1));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
%>
<table border="0" cellspacing="0" cellpadding="0">
<tr><th>Doctor</th>
<%
for( i=0;i<=6;i++){
%>
<th><input type="hidden" name="roasterDate<%=i%>" value="<%=HMSUtil.convertDateToStringFormat(c.getTime(), "dd/MM/yyyy")%>">
<%=HMSUtil.convertDateToStringFormat(c.getTime(), "dd/MM/yyyy")%></th>
<%
c.add(Calendar.DATE, 1);inc++;  
} %>

<tr>


 <%
 inc=1;
 
int runOnce = 0;
//for(MasEmployee doctor: doctorList)
	 for (Map.Entry<Integer, List<DoctorRoaster>> EmpList : RoasterMap.entrySet()) 
{
		 
		 i=0;
		 runOnce = 0;
	try {
		c.setTime(sdf.parse(dt));
	} catch (ParseException e) {
		e.printStackTrace();
	}
%>
<tr>
  <td><input type="hidden" name="doctorId<%=inc%>" value="<%=EmpList.getKey()%>"> <%=EmpList.getValue().get(0).getDoctor().getFirstName() %></td>
 <%

 //for(int i=0;i<7;i++){
	// iterationDate =c.getTime();
	 //System.out.println("iterationDate "+iterationDate);
	 
	// ArrayList<DoctorRoaster> ls=(ArrayList)RoasterMap.get(2104);
	 
	List<DoctorRoaster> values = EmpList.getValue();
	 System.out.println("values "+values.size());
	 for(DoctorRoaster dr :values)
	 {
		 runOnce++;
		 if(runOnce==1)
		 {
			 if(dr.getRoasterDate().compareTo(HMSUtil.convertStringTypeDateToDateType(fromDate))==1)
			 {
				 Date d1 = HMSUtil.convertStringTypeDateToDateType(fromDate);
				 Date d2 = dr.getRoasterDate();
				 //Date curentDate2 = new Date();
				 int diffInDays = (int) ((d2.getTime()-d1.getTime()) / (1000 * 60 * 60 * 24));
				 //int diffInDays = (int) ((d1-d2);
				 if(diffInDays >0)
				 {
					 try {
							c.setTime(sdf.parse(dt));
						} catch (ParseException e) {
							e.printStackTrace();
						}
					 for(int j=0;j<diffInDays;j++)
					 {
						 if(currentDate1.compareTo(c.getTime())==1)
						 {
					%>		
					 <th>-</th>  
					<%	 }else{
				%>		
				 <th><input tabindex="1" type="checkbox" name="mrng<%=i%>doc<%=EmpList.getKey()%>" id="mrng<%=i%>doc<%=EmpList.getKey()%>" value="y" onclick="fillCheckBoxValue(this.id);" checked="checked"/><input tabindex="1" type="checkbox" name="evn<%=i%>doc<%=EmpList.getKey()%>" id="evn<%=i%>doc<%=EmpList.getKey()%>" value="y" onclick="fillCheckBoxValue(this.id);" checked="checked"/><br/>&nbsp; M&nbsp;&nbsp;&nbsp;&nbsp;E</th>
					<% }i++;
					c.add(Calendar.DATE, 1);  }
				 }
			 }
			 System.out.println(EmpList.getKey() +" inside loop"+i);
		 }
		// System.out.println(dr.getRoasterDate()+"c"+currentDate1);
		//System.out.println(dr.getRoasterDate().compareTo(HMSUtil.convertStringTypeDateToDateType(fromDate))+" here");	
		 
			if(dr.getRoasterDate().compareTo(currentDate1)<0)
				fieldDisable = "disabled=disabled";
			else
				fieldDisable="";
						//System.out.println(dr.getRoasterDate().compareTo(currentDate1));
%>			 
		  <th style="background-color: #aaff80;">	  <input type="hidden" value="<%=dr.getId()%>" name="mrng<%=i%>roaster<%=EmpList.getKey()%>">
		  <%if(dr.getRoasterValue().substring(0, 1).equals("y")){ %>
		  <input tabindex="1" type="checkbox" name="mrng<%=i%>doc<%=EmpList.getKey()%>" id="mrng<%=i%>doc<%=EmpList.getKey()%>" value="y" onclick="fillCheckBoxValue(this.id);" checked="checked" <%=fieldDisable%>/>
		  <%}
		  else{
		  %>
		  <input tabindex="1" type="checkbox" name="mrng<%=i%>doc<%=EmpList.getKey()%>" id="mrng<%=i%>doc<%=EmpList.getKey()%>" value="n" onclick="fillCheckBoxValue(this.id);" <%=fieldDisable%>/>
		  <%} %>
		  
		  	  <%if(dr.getRoasterValue().substring(1, 2).equals("y")){ %>
		  <input tabindex="1" type="checkbox" name="evn<%=i%>doc<%=EmpList.getKey()%>" id="evn<%=i%>doc<%=EmpList.getKey()%>" value="y" onclick="fillCheckBoxValue(this.id);" checked="checked" <%=fieldDisable%>/>
		  <%}
		  else{
		  %>
		  <input tabindex="1" type="checkbox" name="evn<%=i%>doc<%=EmpList.getKey()%>" id="evn<%=i%>doc<%=EmpList.getKey()%>" value="n" onclick="fillCheckBoxValue(this.id);"<%=fieldDisable%> />
		  <%} %>
		<br/>&nbsp; M&nbsp;&nbsp;&nbsp;&nbsp;E
<%		 
		 i++;
		
	 }
System.out.println(values.get(0).getDoctor().getId()+" i value "+i);
	if(i!=7)
	{
		for(int m=i; m<=6;m++)
		{
			 if(currentDate1.compareTo(c.getTime())==1)
			 {
%>
</th><th>-</th>
<%}else{ %>
      			<th><input tabindex="1" type="checkbox" name="mrng<%=i%>doc<%=EmpList.getKey()%>" id="mrng<%=i%>doc<%=EmpList.getKey()%>" value="y" onclick="fillCheckBoxValue(this.id);" checked="checked"/><input tabindex="1" type="checkbox" name="evn<%=i%>doc<%=EmpList.getKey()%>" id="evn<%=i%>doc<%=EmpList.getKey()%>" value="y" onclick="fillCheckBoxValue(this.id);" checked="checked"/><br/>&nbsp; M&nbsp;&nbsp;&nbsp;&nbsp;E</th> 
<%	}}
	}

c.add(Calendar.DATE, 1);  
//} %>
</tr>
<% inc++;}
/* if(doctorList.size()>0)
{
	try {
		c.setTime(sdf.parse(dt));
	} catch (ParseException e) {
		e.printStackTrace();
	}
} */
	 for(MasEmployee doctor: doctorList)
	 {
		 System.out.println("doctorList"+doctorList.size());
		 try {
				c.setTime(sdf.parse(dt));
			} catch (ParseException e) {
				e.printStackTrace();
			}
     %>
     <tr> 
     <td><input type="hidden" name="doctorId<%=inc%>" value="<%=doctor.getId()%>"><%=doctor.getFirstName() %></td>
	<%	  	for(i=0;i<7;i++){
		//System.out.println(doctor.getId()+" docid "+c.getTime() +" "+currentDate1 +" "+c.getTime().compareTo(currentDate1));
		if(c.getTime().compareTo(currentDate1)<0)
		{
		%>
		<th>-</th>	
	<%	}
		else{	%>
			 <th><input tabindex="1" type="checkbox" name="mrng<%=i%>doc<%=doctor.getId()%>" id="mrng<%=i%>doc<%=doctor.getId()%>" value="y" onclick="fillCheckBoxValue(this.id);" checked="checked"/><input tabindex="1" type="checkbox" name="evn<%=i%>doc<%=doctor.getId()%>" id="evn<%=i%>doc<%=doctor.getId()%>" value="y" onclick="fillCheckBoxValue(this.id);" checked="checked"/><br/>&nbsp; M&nbsp;&nbsp;&nbsp;&nbsp;E</th>
			 <%
		}
			 c.add(Calendar.DATE, 1);  
			 } 
	%>
	</tr>
	<%	inc++;	  
	 }
%> 


</table>
<input type="hidden" name="hiddenValue" value="<%=inc%>"/>
<input type="hidden" name="totalColumn" value="6"/>
<input type="hidden" name="deptId" value="<%=deptId%>"/>
<input type="hidden" name="currentDate" value="<%=currentDate %>"/>
<input type="hidden" name="currentTime" value="<%=currentTime%>"/>
<%
try {
	c.setTime(sdf.parse(dt));
} catch (ParseException e) {
	e.printStackTrace();
}
c.add(Calendar.DATE, 6);  
System.out.println(c.getTime());;
System.out.println(currentDate1.compareTo(c.getTime()));
if(currentDate1.compareTo(c.getTime())==1)
{
	view =true;
}
if(!view){ %>
<input type="button" name="Submit" class="button" value="Submit"
	onclick="submitForm ('roaster','user?method=submitDoctorRoasterJsp');" />
	<%} %>
</form>

<%} 
}%>
<div class="clear"></div>
<div class="clear"></div>

<%-- <div id="addId">
<input name="" type="button" class="button" value="Submit"
	onclick="if(validateDatefield()){<%=url%>}" /> 
	</div> --%>
	<div id="updateId" style="display: none">
<input name="" type="button" class="button" value="Update"
	onclick="if(validateDatefield()){ submitForm('appSetup','appointment?method=updateAppointmentSetup');}" /> 
	</div>
<!-- <input name="" type="reset" class="button" value="Reset" /> --> <!--Bottom labels starts-->
<div class="clear"></div>
<div class="division"></div>
<input class="signPriority3" style="background-color: #aaff80;width: 14px; height: 14px; margin-top: 7px;" readonly="readonly" type="text">
<label class="value"style="margin-top: 3px;">Marked Attendance</label>
<div class="clear"></div>
<div class="bottom"><label>Changed By </label> <label
	class="value"><%=userName %></label> <label>Changed Date </label> <label
	class="value"><%=currentDate %></label> <label>Changed Time </label> <label
	class="value"><%=currentTime%></label></div>
<!--Bottom labels ends-->
<div class="clear"></div>

</div>
<!--main content placeholder ends here-->
<script type="text/javascript">

 function getDetails(){	
	
	submitForm('roasterSetup','/hms/hms/user?method=showDoctorRoasterJsp');	
} 
</script>