<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * unit.jsp  
 * Purpose of the JSP -  This is for Unit.
 * @author  Dipali
 * @author  Mansi
 * Create Date: 07th Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.9
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hms.masters.business.PatientFamilyHistory"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%
Map map = new HashMap();
if(request.getAttribute("map") != null)
{
	map = (Map) request.getAttribute("map");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");
ArrayList searchPatientFamilyHistoryList = (ArrayList)map.get("searchPatientFamilyHistoryList");
String userName = "";
if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
}

String message="";
if(map.get("message") != null){
    message = (String)map.get("message");
  
  }	 	

List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
if (map.get("departmentList") != null) {
	departmentList = (List<MasDepartment>) map.get("departmentList");
			
	}
%>


<h4><span><%=message %></span></h4>
<div class="titleBg">

<h2>Present Complaint</h2>
</div>
<div id="searcharea">
<form name="search" method="post" action="">
	  <div class="Block">		    
			    	<label  class="auto">Present Complaint History Name</label>
<input type="hidden" name="<%=SELECTED_RADIO  %>" value="1"  class="radioCheckCol1" /> 
<input type="hidden" name="<%=SELECTED_RADIO %>" value="2" checked="checked"  class="radioCheckCol1" /> 
<input	type="hidden" name="colCode" value="patient_family_history_code"/>
<input	type="hidden" name="colName" value="patient_present_complaint_name"/>

<input	type="hidden" name="templateCode" value="CH"/>

<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="Sub Section Code,alphanumeric,no" MAXLENGTH="8" tabindex=1	onkeypress="return submitenter(this,event,'opdMaster?method=searchPresentComplaint')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','opdMaster?method=searchPresentComplaint','checkSearch')" tabindex=1  />
<input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','hospital?method=generateReportForGeneralMastersPatientFamilyHistory');"	accesskey="g" tabindex=1 /> 
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="presentComplaint"/>
</div>
</form>
                    </div>


			 	 
	<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
	<div id="searchresults" tabindex=2 >
	<div id="searchtable" tabindex=2 ></div>
	
	<% 
		if(searchPatientFamilyHistoryList.size()>0)
		 {
			String strForAddressDescription = (String)map.get("patientPresentComplaintName");
			if(strForAddressDescription!= null && strForAddressDescription!= "")
			{
	%> 
		
    
   <h4> <a href="opdMaster?method=showPresentComplaintJsp">Show All Records</a></h4>
	<%
			}
		 }
	 if(searchPatientFamilyHistoryList.size()==0 && map.get("search") != null)
	  {
	 %>
				<h4><a href="opdMaster?method=showPresentComplaintJsp">Show All Records</a></h4>

	 <%
     }
	%>
	<script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= SEARCH_NAME%>"], [2," <%=DEPARTMENT_ID %>"], [3,"<%= CHANGED_DATE %>"],[4,"<%= CHANGED_TIME %>"],[5,"<%=STATUS%>"] ];
	 statusTd = 5;
	</script>
	</div>
	
  <form name="unit" method="post" action="">
  <input type="hidden" name="<%= POJO_NAME %>" value = "PatientFamilyHistory">
  <input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="PatientPresentComplaintName">
  <input type="hidden" name="title" value = "presentComplaint">
  <input type="hidden" name="<%=JSP_NAME %>" value = "presentComplaint">
  <input type="hidden" name="pojoPropertyName" value = "PatientPresentComplaintName">
<div class="Clear"></div>	  		
 	<div class="Block">

	  	
  		<label class="auto" >Patient Present Complaint Name <span>*</span> </label>
			<%-- <input type="text" name="<%= SEARCH_NAME %>" validate="Patient Present Complaint Name ,string,yes"  MAXLENGTH="500" tabindex=1 /> --%>
			
			<textarea name="<%= SEARCH_NAME %>" cols="0" rows="0" maxlength="500"
				value="" tabindex="1" ></textarea>
			<script>
				document.unit.<%=SEARCH_NAME%>.focus();
			</script>
  <label>Department <span>*</span></label>

		<select id="<%=DEPARTMENT_ID %>" name="<%=DEPARTMENT_ID %>"
						 validate="Department,number,yes">
			<option value="">Select</option>
			<%
				//System.out.println("d"+departmentList.size());
				for (MasDepartment masDepartment : departmentList) {
			%>
			<option value="<%=masDepartment.getId()%>" ><%=masDepartment.getDepartmentName()%></option>
			<%}
				
			%>
		</select>
			</div>
<div class="Clear"></div>
			<div id="edited"></div>
			<div class="division"></div>
			<div class="Clear"></div>
			<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('unit','opdMaster?method=addPresentComplaint');" accesskey="a" tabindex=1/>
			<input type="button" name="edit" id="editbutton" value="Update" class="button" onClick="submitForm('unit','opdMaster?method=editPresentComplaint')" accesskey="u" tabindex=1 />
			<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('unit','opdMaster?method=deletePresentComplaint&flag='+this.value)" accesskey="d" tabindex=1/>		
			<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
			<input type="hidden" name="<%=STATUS %>" value="" />
			<input type="hidden" name="<%= COMMON_ID%>" value="" />
			<div class="Clear"></div>
			<div class="division"></div>
			<div class="Clear"></div>
<div class="bottom">
<label >Changed By:</label>   
			<label class="value"><%=userName%></label>
			        
			<label >Changed Date:</label>   
			<label class="value"><%=date%></label>
			 
			<label >Changed Time:</label>   
			<label class="value"><%=time%></label>
			 
			<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
			<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
			<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />	   			
   </div>
   </form>	
	

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Patient Present Complaint Name "
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= SEARCH_NAME%>"


data_header[1] = new Array;
data_header[1][0] = "Department"
data_header[1][1] = "data";
data_header[1][2] = 0;
data_header[1][3] = "<%=DEPARTMENT_ID %>"

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = "0";
data_header[2][3] = "<%= CHANGED_DATE %>";

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%=CHANGED_TIME %>";

data_header[4] = new Array;
data_header[4][0] = "Status"
data_header[4][1] = "data";
data_header[4][2] = "15%";
data_header[4][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=searchPatientFamilyHistoryList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             PatientFamilyHistory  patientFamilyHistory = (PatientFamilyHistory)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
<%if(patientFamilyHistory.getId() != null) {%>
     data_arr[<%= counter%>][0] = <%= patientFamilyHistory.getId()%>
<%}%>

<%

String history=patientFamilyHistory.getPatientPresentComplaintName()!=null ? patientFamilyHistory.getPatientPresentComplaintName().trim():"";
history = history.replace("\r", "$");
history = history.replace("\n", "^");

%>

var str_history = "<% out.print(history); %>";		
str_history = str_history.split('$').join("\r");
str_history = str_history.split('^').join("\n");	  
  
data_arr[<%= counter%>][1] = str_history;



 <%if(patientFamilyHistory.getDepartmentId() != null){
 		for(MasDepartment masDepartment: departmentList){
 			if(patientFamilyHistory.getDepartmentId().getId().equals(masDepartment.getId())){
 		
 %>
    data_arr[<%= counter%>][2] = "<%=masDepartment.getDepartmentName() %>"
    <%}}}else{%>
    data_arr[<%= counter%>][2] = "";
    <%}%>
<%-- <%}%> --%>
<%if(patientFamilyHistory.getLastChgDate() != null){%>
    data_arr[<%= counter%>][3] = "<%= HMSUtil.convertDateToStringWithoutTime(patientFamilyHistory.getLastChgDate()) %>"
<%}%>

<%if(patientFamilyHistory.getLastChgTime() != null){%>
    data_arr[<%= counter%>][4] = "<%= patientFamilyHistory.getLastChgTime() %>"
<%}%>

<%if(patientFamilyHistory.getStatus() != null){
if(patientFamilyHistory.getStatus().equals("y")){ %>
data_arr[<%= counter%>][5] = "Active"
<%}else{%>
data_arr[<%= counter%>][5] = "InActive"
<%}}%>
<%
		     counter++;
}
%>
 
formName = "unit"
//nonEditable = ['<%= SEARCH_NAME%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>	
	  