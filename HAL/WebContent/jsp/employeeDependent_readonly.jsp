<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * employeeDependent.jsp  
 * Purpose of the JSP -  This is for Dependent Employee.
 * @author  Dipali
 * @author  Mansi  
 * Create Date: 07th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.14
--%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmployeeDependent"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>

<script
	type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/switchcontent.js"></script>
<script type="text/javascript" src="/hms/jsp/js/switchicon.js"></script>


<script type="text/javascript" src="/hms/jsp/js/autocomplete.js"></script>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/actb.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<!-- <script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script> -->
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script>
	<%

		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String dateCal=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(dateCal.length()<2){
			dateCal="0"+dateCal;
		}
		
	%>
		serverdate = '<%=dateCal+"/"+month+"/"+year%>'
	</script>
	<script>
	function validateEmployeeDependent(){
		
		  
		var fname = document.getElementById('fileNameId').value;
		var ind1 = fname.lastIndexOf("\\");
		var filename = fname.substring(ind1+1);
		document.getElementById("fileName").value=filename;
		document.getElementById("flag").value="y";
		document.employeeDependent.method="post";
		  return true;
	    
	  
	    

	}
	</script>
<%
	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");

/* 	List<MasEmployee> employeeCodeList = new ArrayList<MasEmployee>();
	employeeCodeList = (ArrayList) map.get("employeeCodeList"); */
	List<MasRelation> relationCodeList = new ArrayList<MasRelation>();
	relationCodeList = (ArrayList) map.get("relationCodeList");
	List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
	List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
	if(map.get("sexList") != null)
	{
		sexList = (List<MasAdministrativeSex>)map.get("sexList");
	
	}
	if(map.get("bloodGroupList") != null)
	{
		bloodGroupList = (List<MasBloodGroup>)map.get("bloodGroupList");
	
	}
	
	ArrayList searchEmployeeDependentList = (ArrayList) map.get("searchEmployeeDependentList");
	/* ArrayList gridEmployeeList = (ArrayList) map.get("gridEmployeeList"); */
	ArrayList gridRelationList = (ArrayList) map.get("gridRelationList");

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	int hospitalId = 0;
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	String message ="";
	if (map.get("message") != null) {
		message = (String) map.get("message");
		
	}
%>
<h4><%=message %></h4>
<div class="titleBg">
<h2>Employee Dependent Master</h2>
</div>
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<div class="Block">
<%-- <%-- <input type="radio"	class="radioAuto" name="<%=SELECTED_RADIO  %>" value="1" checked="checked" /> 
<label>Dependent Code</label> 
<input type="radio"	class="radioAuto" name="<%=SELECTED_RADIO %>" value="2" /> --%> 
 
<label>Employee No.</label>
<input type="radio" class="radioAuto" name="<%=SELECTED_RADIO %>" value="1"  />
 <label>First Name</label> 
<input type="radio" class="radioAuto" name="<%=SELECTED_RADIO  %>"   value="2" checked="checked" />

<input type="text" id="searchField" name="<%= SEARCH_FIELD%>"	value="" 	tabindex=1	onkeypress="return submitenter(this,event,'personnel?method=searchEmployeeDependent')" />
 <input type="hidden" name="colName" value="employee_dependent_code">
<input type="hidden" name="colName" value="EMPLOYEE_DEPENDENT_f_NAME">

<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','personnel?method=searchEmployeeDependent','checkSearch')" tabindex=1 /> 
<%--- Report Button   --%> 
<input type="button" name="Report" value="Generate Report Based on Search" class="buttonBig3" onClick="submitForm('search','hospital?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 /> 
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_employee_dependent">
</div>
</form>
</div>
</div>
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<% 
		if(searchEmployeeDependentList.size()>0 )
		 {
			//String strForCode = (String) map.get("employeeDependentCode");
			String strForCodeDescription = (String) map.get("employeeDependentName");
			if(strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> <br />

<h4><a href="personnel?method=showEmployeeDependentJsp">Show All Records</a></h4>
<%
			}
		 }
	if(searchEmployeeDependentList.size()==0 && map.get("search") != null)
	{
	%> 
<h4><a href="personnel?method=showEmployeeDependentJsp">Show All Records</a></h4> <%
	}
	%> <script type="text/javascript">
		
		formFields = [
				[0, "<%= COMMON_ID%>", "id"], [1,"<%= SEARCH_NAME%>"], [2,"employeeDependentMName"], [3,"employeeDependentLName"], [4,"<%= EMPLOYEE_DEPENDENT_DOB %>"],[5,"sexId"],[6,"<%= EMPLOYEE_DEPENDENT_ADDRESS %>"],[7,"<%= EMPLOYEE_NAME %>"],[8,"<%= RELATION_ID%>"],[9,"<%= CHANGED_BY%>"],[10,"<%= CHANGED_DATE %>"],[11,"<%= CHANGED_TIME %>"],[12,"<%=STATUS%>"],[13,"contactNo"], [14,"<%= BLOOD_GROUP_ID %>"],[15,"<%= EMPLOYEE_ID %>"]];
	 statusTd = 12;
		</script></div>
<form name="employeeDependent" method="post" action="" enctype="multipart/form-data">
<div class="Block">

<%-- <label> Dependent Code <span>*</span></label> 
<input id="codeId" type="text" name="<%= CODE%>" value="" validate="Employee Dependent Code,string,yes" class="textbox_size20"	MAXLENGTH="8" / tabindex=1> 
 --%>
 <label >First Name <span>*</span></label> 
<input type="text"	name="<%= SEARCH_NAME %>" value=""	validate="First Name,string,yes"	class="textbox_size20" MAXLENGTH="30"  tabindex=1> 
<script>
			document.employeeDependent.<%=SEARCH_NAME%>.focus();
</script>

 <label >Middle Name </label> 
<input type="text"	name="employeeDependentMName" value=""	validate="Middle Name  Name,string,no"	class="textbox_size20" MAXLENGTH="30"  tabindex=1> 


 <label >Last Name</label> 
<input type="text"	name="employeeDependentLName" value=""	validate="Last Name,string,no"	class="textbox_size20" MAXLENGTH="30"  tabindex=1> 

 <div class="clear"></div>
 
<label>Employee No/Name  <span>*</span> </label> 


<%-- <input type="text" value=""  size="50" name="<%=EMPLOYEE_NAME%>" id="<%=EMPLOYEE_NAME%>"  /> --%>
  <input type="text" value=""  size="50" name="<%=EMPLOYEE_NAME%>" id="<%=EMPLOYEE_NAME%>"  onblur="fillEmployee(this.value, '<%=EMPLOYEE_NAME%>');"/>  
			<div id="ac2update"	style="display: none;"  class="autocomplete"></div>
			 <script type="text/javascript" language="javascript" charset="utf-8">
			new Ajax.Autocompleter('<%=EMPLOYEE_NAME%>','ac2update','personnel?method=getEmployeeList',{parameters:'requiredField=<%=EMPLOYEE_NAME%>'});
			</script> 

<input type="hidden"	name="<%=EMPLOYEE_ID %>" id="<%=EMPLOYEE_ID %>" 	class="textbox_size20" MAXLENGTH="30"  tabindex=1> 


<%-- <select name="<%= EMPLOYEE_ID%>"  id="<%= EMPLOYEE_ID%>" validate="Employee,string,yes" tabindex=1>
	<option value="0">Select</option>
	<%if(employeeCodeList.size()>0){
		for (MasEmployee masEmployeecode : employeeCodeList) {
			String empName="";
		
			if(masEmployeecode.getFirstName()!=null)
			{
				empName=empName+" "+masEmployeecode.getFirstName().trim();
			}
			if(masEmployeecode.getLastName()!=null)
			{
				empName=empName+" "+masEmployeecode.getLastName().trim();
			}
	%>

	<option value="<%=masEmployeecode.getId()%>"><%=masEmployeecode.getServiceNo().trim()%>(<%=empName.trim()%>)</option>

	<%
		}}
	%>
</select> 
 --%>
<label>Relation Name <span>*</span> </label> 
<select name="<%= RELATION_ID %>" validate="Relation,string,yes" tabindex=1>
	<option value="0">Select</option>
	<%
		for (MasRelation masRelationcode : relationCodeList) {
	%>

	<option value="<%=masRelationcode.getId ()%>"><%=masRelationcode.getNewRelationName()%></option>

	<%
		}
		%>
</select> 
<label> Date of Birth <span>*</span> </label> 
<input type="text" class="auto" size="21" id="dobId" name="<%=EMPLOYEE_DEPENDENT_DOB%>" value="" class="textbox_date" readonly="readonly" validate="DOB,date,yes" MAXLENGTH="30" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"  onClick="setdate('',document.employeeDependent.<%=EMPLOYEE_DEPENDENT_DOB%>,event)" />

<label> Gender <span>*</span></label>
 <select name="sexId" id="sexId"	validate="Gender,string,yes" tabindex="1">
			<option value="0">Select</option>
			<%
		   	 		for(MasAdministrativeSex masAdministrativeSex : sexList){
			%>
			<option value="<%=masAdministrativeSex.getId() %>"><%=masAdministrativeSex.getAdministrativeSexName() %></option>
			<%
		   	 	} %>
		</select> 


<label > Address </label>
<input type="text" name="<%= EMPLOYEE_DEPENDENT_ADDRESS %>" value="" validate="Address,string,no" class="textbox_size20" MAXLENGTH="30" tabindex=1	onkeypress="return submitenter(this,event,'personnel?method=addEmployeeDependent')">

<label > Mobile No.</label>
<input type="text" name="contactNo" value="" id="contactNo" validate="Mobile No,phone,no" class="textbox_size20" MAXLENGTH="10" tabindex=1>



<label>	Blood Group </label> 
			<select id="bldGrpId" name=<%=BLOOD_GROUP_ID %> validate="Blood Group,string,no">
			<option value="0">Select</option>	

			<%
				         		if(bloodGroupList != null){ 	
				         			for (Iterator iter = bloodGroupList.iterator(); iter.hasNext();) {
				         				MasBloodGroup bloodGroup = (MasBloodGroup) iter.next();
				         %>
			<option value="<%=bloodGroup.getId() %>"><%=bloodGroup.getBloodGroupName() %></option>
			<%		
				        			}
				        		 } 
				        %>
		</select>

<div class="Clear"></div>
		
		<label>Photo</label>
		
 <input type="file" name="<%=UPLOAD_FILENAME %>" id="fileNameId" class="browse" validate="photo,string,no">
  <input type="hidden" name="flag" id="flag" value="n">
  <input type="hidden" id="fileName" name="fileName" vale="" />

	<img id="imageIDD" align="right" src=""  width="100px"	height="90px" style="display: none;">  

</div>
<div class="clear"></div>
<div class="division"></div>
<div id="edited"></div>
<div class="clear"></div>
 <%-- <input type="button" name="add" id="addbutton"
	value="Add" class="button" onClick="if(validateEmployeeDependent()){submitForm('employeeDependent','personnel?method=addEmployeeDependent')}"
	accesskey="a" tabindex=1 /> 
	<input type="button" name="edit" id="editbutton" value="Update" class="button"	onClick="if(validateEmployeeDependent()){submitForm('employeeDependent','personnel?method=editEmployeeDependent')}" accesskey="u" tabindex=1 />
	<input type="button" name="Delete"	id="deletebutton" value="Activate" class="button"	onClick="if(validateEmployeeDependent()){submitForm('employeeDependent','personnel?method=deleteEmployeeDependent&flag='+this.value)}"	accesskey="d" tabindex=1 /> 
	<input type="reset" name="Reset"	id="reset" value="Reset" class="button" onClick="submitFormForButton('employeeDependent','personnel?method=showEmployeeDependentJsp')"
	accesskey="r" /> <input type="hidden" name="<%=STATUS %>" value="" />
 --%><input type="hidden" name="<%= COMMON_ID%>" value="" /> <br />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="<%=HOSPITAL_ID %>"  value="<%=hospitalId%>" />
</form>
<div class="bottom">
<label >Changed By: </label>   
			<label class="value"><%=userName%></label>
			        
			<label >Changed Date: </label>   
			<label class="value"><%=date%></label>
			 
			<label >Changed Time:</label>   
			<label class="value"><%=time%></label>
			 
			<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
			<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
			<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />
			<input type="hidden" name="<%=HOSPITAL_ID %>"  value="<%=hospitalId%>" />
			</div> 
			
			
<script type="text/javascript">
	data_header = new Array();
	
	
	
	data_header[0] = new Array;
	data_header[0][0] = "First Name"
	data_header[0][1] = "data";
	data_header[0][2] = "25%";
	data_header[0][3] = "<%= SEARCH_NAME %>";
	
	
	data_header[1] = new Array;
	data_header[1][0] = "Middle Name"
	data_header[1][1] = "hide";
	data_header[1][2] = "10%";
	data_header[1][3] = "employeeDependentMName"
	
		data_header[2] = new Array;
	data_header[2][0] = "Last Name"
	data_header[2][1] = "data";
	data_header[2][2] = "10%";
	data_header[2][3] = "employeeDependentLName"
	
	
	data_header[3] = new Array;
	data_header[3][0] = "Date of Birth"
	data_header[3][1] = "hide";
	data_header[3][2] = "15%";
	data_header[3][3] = "<%= EMPLOYEE_DEPENDENT_DOB %>";
	
	data_header[4] = new Array;
	data_header[4][0] = "Gender"
	data_header[4][1] = "hide";
	data_header[4][2] = "10%";
	data_header[4][3] = "sexId";
	
	data_header[5] = new Array;
	data_header[5][0] = "Address"
	data_header[5][1] = "hide";
	data_header[5][2] = "30%";
	data_header[5][3] = "<%= EMPLOYEE_DEPENDENT_ADDRESS%>";
	
	data_header[6] = new Array;
	data_header[6][0] = "Employee Name"
	data_header[6][1] = "data";
	data_header[6][2] = "40%";
	data_header[6][3] = "<%= EMPLOYEE_NAME %>";
	
	data_header[7] = new Array;
	data_header[7][0] = "Relation"
	data_header[7][1] = "data";
	data_header[7][2] = "40%";
	data_header[7][3] = "<%=RELATION_ID %>";
	
	data_header[8] = new Array;
	data_header[8][0] = ""
	data_header[8][1] = "hide";
	data_header[8][2] = 0;
	data_header[8][3] = "<%=CHANGED_BY %>"
	
	data_header[9] = new Array;
	data_header[9][0] = "Admin"
	data_header[9][1] = "hide";
	data_header[9][2] = 0;
	data_header[9][3] = "<%=CHANGED_DATE %>"
	
	data_header[10] = new Array;
	data_header[10][0] = ""
	data_header[10][1] = "hide";
	data_header[10][2] = "0";
	data_header[10][3] = "<%=CHANGED_TIME %>";
	
	data_header[11] = new Array;
	data_header[11][0] = "Status"
	data_header[11][1] = "data";
	data_header[11][2] = "15%";
	data_header[11][3] = "<%=STATUS %>";
	
	
	
	data_header[12] = new Array;
	data_header[12][0] = "Contact No."
	data_header[12][1] = "hide";
	data_header[12][2] = "15%";
	data_header[12][3] = "contactNo";
	
	

	data_header[13] = new Array;
	data_header[13][0] = "Blood Group"
	data_header[13][1] = "hide";
	data_header[13][2] = 0;
	data_header[13][3] = "<%=BLOOD_GROUP_ID%>"
	
	
		data_header[14] = new Array;
	data_header[14][0] = "Employee"
	data_header[14][1] = "data";
	data_header[14][2] = "40%";
	data_header[14][3] = "<%= EMPLOYEE_ID %>";
	
	data_arr = new Array();
	
	<%
		Iterator itr=searchEmployeeDependentList.iterator();
	    int  counter=0;
	    while(itr.hasNext())
	    {																																																											
	         MasEmployeeDependent  masEmployeeDependent= (MasEmployeeDependent)itr.next(); 
	%>
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= masEmployeeDependent.getId()%>
			data_arr[<%= counter%>][1] = "<%= masEmployeeDependent.getEmployeeDependentFName()%>"
			data_arr[<%= counter%>][2] = "<%=masEmployeeDependent.getEmployeeDependentMName()!=null? masEmployeeDependent.getEmployeeDependentMName() :""%>"
			data_arr[<%= counter%>][3] = "<%=masEmployeeDependent.getEmployeeDependentLName()!=null? masEmployeeDependent.getEmployeeDependentLName() :""%>"
			data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(masEmployeeDependent.getDateOfBirth()) %>"
			
			<%
			if(masEmployeeDependent.getGender() != null){
					for(MasAdministrativeSex administrativeSex : sexList){
			            if(masEmployeeDependent.getGender() != null){
						if(masEmployeeDependent.getGender().getId().equals(administrativeSex.getId()) && administrativeSex.getStatus().equals("y")){
						 %>
							data_arr[<%= counter%>][5] = "<%=administrativeSex.getAdministrativeSexName()%>"
						<%}else if(masEmployeeDependent.getGender().getId().equals(administrativeSex.getId()) && administrativeSex.getStatus().equals("n")){%>
							data_arr[<%= counter%>][5] = "<font id='error'>*</font>Parent InActivated--<%=administrativeSex.getAdministrativeSexName()%>";
							
						<%}
			            }
					}
			} else {%>
			data_arr[<%= counter%>][5] = "";
			<%}		if( masEmployeeDependent.getAddress() !=null){%>
			data_arr[<%= counter%>][6] = "<%= masEmployeeDependent.getAddress()%>";
			
			<%}else{%>
			data_arr[<%= counter%>][6] = "";
			<%}%>
			
			
			data_arr[<%= counter%>][7] = "<%=masEmployeeDependent.getEmployee().getFirstName()!=null?masEmployeeDependent.getEmployee().getFirstName().trim():""%>[<%=masEmployeeDependent.getEmployee().getServiceNo()!=null?masEmployeeDependent.getEmployee().getServiceNo().trim():""%>]";
			data_arr[<%= counter%>][15] = "<%=masEmployeeDependent.getEmployee()!=null?masEmployeeDependent.getEmployee().getId():"0"%>";
			
			<%-- <%Iterator itrGridEmployeeList=gridEmployeeList.iterator();
			while(itrGridEmployeeList.hasNext())
	       {
	       		MasEmployee  employeeGrid = (MasEmployee)itrGridEmployeeList.next(); 
	    		String empName="";
				if(employeeGrid.getFirstName()!=null)
				{
					empName=empName+" "+employeeGrid.getFirstName().trim();
				}
			
				if(employeeGrid.getLastName()!=null)
				{
					empName=empName+" "+employeeGrid.getLastName().trim();
				}
	       		
				if(masEmployeeDependent.getEmployee().getId().equals(employeeGrid.getId()) && employeeGrid.getStatus().equalsIgnoreCase("y")){%>
					data_arr[<%= counter%>][7] = "<%=empName.trim()%>[<%=employeeGrid.getServiceNo().trim()%>]"
						data_arr[<%= counter%>][15] = "<%=employeeGrid.getId()%>"
				<%}else if(masEmployeeDependent.getEmployee().getId().equals(employeeGrid.getId()) && employeeGrid.getStatus().equalsIgnoreCase("n")){%>
					data_arr[<%= counter%>][7] = "<font id='error'>*</font>Parent InActivated--<%=employeeGrid.getEmployeeCode()%>(<%=employeeGrid.getServiceNo().trim()%>)";
					data_arr[<%= counter%>][15] = "<%=employeeGrid.getId()%>"
					
				<%}
			}%> --%>
		<%	Iterator itrGridRelationList=gridRelationList.iterator();
			while(itrGridRelationList.hasNext())
	       {
	       		MasRelation  relationGrid = (MasRelation)itrGridRelationList.next(); 
				if(masEmployeeDependent.getRelation().getId().equals(relationGrid.getId()) && relationGrid.getStatus().equals("y")){%>
					data_arr[<%= counter%>][8] = "<%=relationGrid.getNewRelationName()%>"
				<%}else if(masEmployeeDependent.getId().equals(relationGrid.getId()) && relationGrid.getStatus().equals("n")){%>
					data_arr[<%= counter%>][8] = "<font id='error'>*</font>Parent InActivated--<%=relationGrid.getNewRelationName()%>";
					
				<%}
			}
			if( masEmployeeDependent.getLastChgBy() !=null){
			%>
			data_arr[<%= counter%>][9] = "<%= masEmployeeDependent.getLastChgBy() %>"
			<%}else{%>
			data_arr[<%= counter%>][9] = "";
			<%}
			if( masEmployeeDependent.getLastChgDate() !=null){%>
			data_arr[<%= counter%>][10] = "<%= HMSUtil.convertDateToStringWithoutTime(masEmployeeDependent.getLastChgDate()) %>"
			<%}
			else{%>
			data_arr[<%= counter%>][10] = "";
			<%}
			if( masEmployeeDependent.getLastChgTime() !=null){%>
			data_arr[<%= counter%>][11] = "<%= masEmployeeDependent.getLastChgTime() %>"
			<%}else{%>
				data_arr[<%= counter%>][11] = "";
			<%}
			if(masEmployeeDependent.getStatus().equalsIgnoreCase("y")){ %>
					data_arr[<%= counter%>][12] = "Active"
			<%}else{%>
					data_arr[<%= counter%>][12] = "InActive"
			<%}
			if( masEmployeeDependent.getContactNo() !=null){%>
			data_arr[<%= counter%>][13] = "<%= masEmployeeDependent.getContactNo() %>"
			<%}else{%>
			data_arr[<%= counter%>][13] = "";
			<%} 
			if(masEmployeeDependent.getBloodGroup() != null){
			%>
			<%
					for(MasBloodGroup masBloodGroup : bloodGroupList){
			            if(masEmployeeDependent.getBloodGroup() != null){
						if(masEmployeeDependent.getBloodGroup().getId().equals(masBloodGroup.getId()) && masBloodGroup.getStatus().equals("y")){
						 %>
							data_arr[<%= counter%>][14] = "<%=masBloodGroup.getBloodGroupName()%>"
						<%}else if(masEmployeeDependent.getBloodGroup().getId().equals(masBloodGroup.getId()) && masBloodGroup.getStatus().equals("n")){%>
							data_arr[<%= counter%>][14] = "<font id='error'>*</font>Parent InActivated--<%=masBloodGroup.getBloodGroupName()%>";
							
						<%}
			            }
					}
			} else {%>
			data_arr[<%= counter%>][14] = ""
			<%}
			     counter++;
		}
	%>
	 formName = "employeeDependent"
	
		
	start = 0
	if(data_arr.length < rowsPerPage)
		end = data_arr.length;
	else
		end = rowsPerPage;
	makeTable(start,end);
	
	intializeHover('searchresulttable', 'TR', ' tableover');
	
	</script>
<script>


function fillEmployee(val,a)
{
	
		//var pageNo =parseInt(document.getElementById('pageNo').value) 
		//var start=((pageNo-1)*8)+1;
    	//var end=((pageNo-1)*8)+8;
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
		   
	   // alert("checkForDefectiveDrugs"+pvms);
	  
	    ajaxFunctionForAutoComplete('employeeDependent','personnel?method=fillEmployee&employeeNo=' + pvms );
	  
		
}

function ajaxFunctionForAutoComplete(formName,action) {
	
	   var xmlHttp;
	    
	   try {
	     // Firefox, Opera 8.0+, Safari
	     xmlHttp=new XMLHttpRequest();
	   }catch (e){
	     // Internet Explorer
	     try{
	       xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
	     }catch (e){
	     	alert(e)
	       try{
	         xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	       }catch (e){
	         alert("Your browser does not support AJAX!");
	         return false;
	       }
	      }
	    }
	     xmlHttp.onreadystatechange=function()
	     {
	       if(xmlHttp.readyState==4){
	       
	       	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	       
	       	      
	 				
	       	for (loop = 0; loop < items.childNodes.length; loop++) {
	 	   	    var item = items.childNodes[loop];
	 	   	    var empName = item.getElementsByTagName("empName")[0];
	 	        var id  = item.getElementsByTagName("id")[0];
	 	        var empNo  = item.getElementsByTagName("empNo")[0];
	 	        document.getElementById('<%=EMPLOYEE_ID%>').value = id.childNodes[0].nodeValue
	         	document.getElementById('empNo').value = empNo.childNodes[0].nodeValue
	         	document.getElementById('empName').value = empName.childNodes[0].nodeValue+"["+empNo.childNodes[0].nodeValue+"]"
	         	
	
	         
	         		
	       	} 
	       }
	     }
	     var url=action+"&"+getNameAndData(formName)
	      
	     xmlHttp.open("GET",url,true);
	     xmlHttp.setRequestHeader("Content-Type", "text/xml");
	     xmlHttp.send(null);
	     
	     
	   }
</script>