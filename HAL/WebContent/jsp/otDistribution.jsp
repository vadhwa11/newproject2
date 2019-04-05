<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * otDistribution.jsp  
 * Purpose of the JSP -  This is for All OtDistribution Master.
 * @author  Mansi
 * Create Date: 25 June,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.5
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasOt"%>
<%@page import="jkt.hms.masters.business.MasOtDistribution"%>
<script type="text/javascript">
function check()
{
	var SDate = document.otDistribution.<%= START_DATE%>.value;
	var vDate =  new Date();
	var mth;
	var dt;
	var da = vDate.getDate();
	var m = vDate.getMonth()+1;
	if(vDate.getDate() < 10)
	{
		dt = "0"+da;
	}
	else
	{
		dt = da;
	}
	if(vDate.getMonth()+1 < 10)
	{
		mth = "0"+m
	}
	else
	{
		mth = m
	}
	var finalToday=dt+"/"+mth+"/"+vDate.getFullYear();
	if(SDate != "")
	{
		if(SDate < finalToday )
		{
			alert("Please ensure that the Today Date is greater than or equal to the Start Date.");
			document.otDistribution.<%= START_DATE%>.value="";
			return false;
		}
		return false;
	}
}
</script>


<%
Map<String,Object> map = new HashMap<String,Object>();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");

ArrayList searchMasOtDistributionList = (ArrayList)map.get("searchMasOtDistributionList");

List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
departmentList = (List<MasDepartment>)map.get("departmentList");

List<MasOt> otList = new ArrayList<MasOt>();
otList = (List<MasOt>)map.get("otList");

List<MasOt> graidOtList = new ArrayList<MasOt>();
graidOtList = (List<MasOt>)map.get("graidOtList");





String userName = "";
if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
}

int hospitalId = 0;
if (session.getAttribute("hospitalId") != null) {
	Integer temp =  (Integer)session.getAttribute("hospitalId");
	hospitalId = temp.intValue();
}

%>
<% 
if(map.get("message") != null){
	   String message = (String)map.get("message");
	   %>
	   <h4><%=message%></h4>
	   <% 
                   	  }
%>
<div class="titleBg">
<h2>OT Distribution</h2>
</div>
<div id="searcharea">
<form name="search" method="post" action="">
<div class="Block">
     <label>OT Name </label>
     <input type="radio" class="radioAuto" name="<%=SELECTED_RADIO  %>"   value="1" checked="checked"  />
					<label>Days</label>
					<input type="radio" class="radioAuto" name="<%=SELECTED_RADIO %>" value="2"  />
					 <input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""  validate="Days,string,no"   MAXLENGTH="8" tabindex=1   onkeypress="return submitenter(this,event,'otMaster?method=searchUsergroupHospital')"/>
        			<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','?method=searchOtDistribution','checkSearch')" tabindex=1/>
        				<input type="button" name="Report" value="Generate Report Based on Search" class="buttonBig3" onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1 />
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="mas_ot_distribution">
   </div>  
       </form>
<div class="Clear"></div>
 </div>
 <div class="Clear"></div>
 <jsp:include page="searchResultBlock.jsp" />
 <div class="Clear"></div>
 <div id="searchresults" tabindex=2 >
 <div id="searchtable" tabindex=2 ></div>
 <% 
  if(searchMasOtDistributionList.size()>0)
   {
   String strForGroupName = (String)map.get("oTName");
   String strForHospitalName = (String)map.get("days");
   if(strForGroupName!= null && strForGroupName!= "" || strForHospitalName!= null && strForHospitalName!= "")
   {
 %> 
	<h4> <a href="otMaster?method=showOtDistributionJsp">Show All Records</a></h4>
	<%
		
		  }
	   }
	 if(searchMasOtDistributionList.size()==0 && map.get("search") != null)
	  {
	 %>
				<h4><a href="otMaster?method=showOtDistributionJsp">Show All Records</a></h4>

	 <%
    }
	%>
	
 <script type="text/javascript">
 
 formFields = [
   [0, "<%= COMMON_ID%>", "id"], [1,"<%= DAYS%>"], [2,"<%= OT_ID %>"],[3,"<%= DEPARTMENT_ID%>"],[4,"<%= START_DATE%>"],[5,"<%= CHANGED_BY%>"], [6,"<%= CHANGED_DATE %>"],[7,"<%= CHANGED_TIME %>"],[8,"<%=STATUS%>"] ];
  statusTd =8;
 </script>
 </div>
 
<div class="Clear"></div>
  <form name="otDistribution" method="post" action="">
<div class="Block">


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

	  	<label><span>*</span>  Days </label>
		<select name="<%=DAYS%>" validate="Days,string,yes" tabindex=1>
		<option value="0">Select</option>
		<option value="Monday">Monday</option>
		<option value="Tuesday">Tuesday</option>
		<option value="Wednesday">Wednesday</option>
		<option value="Thursday">Thursday</option>
		<option value="Friday">Friday</option>
		<option value="Saturday">Saturday</option>
		<option value="Sunday">Sunday</option>
		</select>
		<label><span>*</span> OT Name </label>
		<select name="<%= OT_ID %>" validate="OT Name,string,yes" tabindex=1 >
					<option value="0">Select</option>
					<%
								  	for (MasOt masOt : otList) {
					  %>
				    
					  <option value="<%=masOt.getId ()%>"><%=masOt.getOtName()%></option>
					  		  
					  <%
					  		  				  	}
					  		  				  %>
					  </select>
			
		<label><span>*</span> Department </label>
		<select name="<%= DEPARTMENT_ID %>" id="depId" validate="Department Name,string,yes" tabindex=1 >
					<option value="0">Select</option>
					<%
								  	for (MasDepartment masDepartment : departmentList) {
					  %>
				    
					  <option value="<%=masDepartment.getId ()%>"><%=masDepartment.getDepartmentName()%></option>
					  		  
					  <%
					  		  				  	}
					  		  				  %>
					  </select>
		<div class="Clear"></div>
		<label><span>*</span> Validity Start Date </label>
		 <input type="text" tabindex=1 id="holidayDateId" name="<%=START_DATE%>" value="" class="calDate" readonly="readonly" validate="Start Date,date,yes"  MAXLENGTH="30" onblur="check();"/>
	     <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.otDistribution.<%=START_DATE%>,event);" /> 
		</div>
<div class="Clear"></div>
	<div id="edited"></div>
	<div class="division"></div>
	<div class="Clear"></div>
			<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('otDistribution','otMaster?method=addOtDistribution','check()');" accesskey="a" tabindex=1/>
		   <input type="button" name="edit" id="editbutton" value="Update" class="button" onClick="submitForm('otDistribution','otMaster?method=editOtDistribution')" accesskey="u" tabindex=1 />

		   <input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('otDistribution','otMaster?method=deleteOtDistribution&flag='+this.value)" accesskey="d" tabindex=1/>  

		
			<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />

			<input type="hidden" name="<%=STATUS %>" value="" />
			<input type="hidden" name="<%= COMMON_ID%>" value="" />
			<div class="Clear"></div>
				<div class="division"></div>
	<div class="Clear"></div>
			
			<div class="bottom">
			
			<label>Changed By:</label>   
		<label class="value"><%=userName %></label>
			        
			<label>Changed Date:</label>   
			<label class="value"><%=date%></label>
			 
			<label>Changed Time:</label>   
			<label class="value"><%=time%></label>
			 
			<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
			<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
			<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />  	
			<input type="hidden" name="<%=HOSPITAL_ID %>"  value="<%=hospitalId%>" /> 	
			
			<div class="Clear"></div>				
			
			
			</div>	
	</form>
<div class="Clear"></div>
	</div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Days"
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "<%= DAYS%>"

data_header[1] = new Array;
data_header[1][0] = "OT Name"
data_header[1][1] = "data";
data_header[1][2] = "30%";
data_header[1][3] = "<%= OT_ID %>";


data_header[2] = new Array;
data_header[2][0] = "Department Name"
data_header[2][1] = "data";
data_header[2][2] = "20%";
data_header[2][3] = "<%= DEPARTMENT_ID%>"

data_header[3] = new Array;
data_header[3][0] = "Validity Start Date"
data_header[3][1] = "data";
data_header[3][2] = "30%";
data_header[3][3] = "<%= START_DATE %>";

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= CHANGED_BY%>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= CHANGED_DATE%>"

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = "15%";
data_header[6][3] = "<%=CHANGED_TIME %>";


data_header[7] = new Array;
data_header[7][0] = "Status"
data_header[7][1] = "data";
data_header[7][2] = "10%";
data_header[7][3] = "<%=STATUS %>";

data_arr = new Array();
<%
Iterator itr=searchMasOtDistributionList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {            
        	  MasOtDistribution  masOtDistribution = (MasOtDistribution)itr.next();       
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masOtDistribution.getId()%>


data_arr[<%= counter%>][1] = "<%= masOtDistribution.getDays() %>"
<%
Iterator itroTList=graidOtList.iterator();
while(itroTList.hasNext())
      {
	MasOt  masOt = (MasOt)itroTList.next(); 
	 if(masOtDistribution.getOt().getId().equals(masOt.getId()) && masOt.getStatus().equals("y")){%>
		data_arr[<%= counter%>][2] = "<%=masOt.getOtName()%>"
	<%}else if(masOtDistribution.getOt().getId().equals(masOt.getId()) && masOt.getStatus().equals("n")){%>
		data_arr[<%= counter%>][2] = "<font id='error'>*</font>Parent InActivated--<%=masOt.getOtName()%>";
	<%}
}%>



<%
Iterator itrDepartmentList=departmentList.iterator();
while(itrDepartmentList.hasNext())
      {
	MasDepartment  masDepartment = (MasDepartment)itrDepartmentList.next(); 
	 if(masOtDistribution.getDepartment().getId().equals(masDepartment.getId()) && masDepartment.getStatus().equals("y")){%>
		data_arr[<%= counter%>][3] = "<%=masDepartment.getDepartmentName()%>"
	<%}else if(masOtDistribution.getDepartment().getId().equals(masDepartment.getId()) && masDepartment.getStatus().equals("n")){%>
		data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=masDepartment.getDepartmentName()%>";
	<%}
}%>
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(masOtDistribution.getValidityStartDate()) %>"
data_arr[<%= counter%>][5] = "<%= masOtDistribution.getLastChgBy() %>"
data_arr[<%= counter%>][6] = "<%= HMSUtil.convertDateToStringWithoutTime(masOtDistribution.getLastChgDate()) %>"
data_arr[<%= counter%>][7] = "<%= masOtDistribution.getLastChgTime() %>"
<% if(masOtDistribution.getStatus().equals("y")){ %>
data_arr[<%= counter%>][8] = "Active"
<%}else{%>
data_arr[<%= counter%>][8] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "otDistribution"

start = 0
if(data_arr.length < rowsPerPage)
 end = data_arr.length;
else
 end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');  
</script>