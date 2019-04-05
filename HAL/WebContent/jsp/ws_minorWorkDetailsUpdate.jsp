<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name : minorWorkDetailUpdate.jsp 
	 * Tables Used    : 
	 * Description    : 
	 * @author  Create Date: 1.05.2009    Name: Vineet Kumar
	 * Revision Date: Revision By: 
	 * @version 1.0  
	 
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%><%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasWorkType"%>
<%@page import="jkt.hms.masters.business.MasWorkCategory"%>
<%@page import="jkt.hms.masters.business.MasMinorWorkDetail"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.ProposalDepartment"%>
<SCRIPT language=javascript src="/hms/jsp/js/common.js"
	type=text/javascript></SCRIPT>

<SCRIPT language=javascript src="/hms/jsp/js/hms.js"
	type=text/javascript></SCRIPT>

<SCRIPT language=javascript src="/hms/jsp/js/calendar.js"
	type=text/javascript></SCRIPT>


<script language="javascript" type="text/javascript">

function checknum()
{
var cost;

if(document.getElementById('cost'))
	cost = document.getElementById('cost');
	
	else if(hinNo.checked){
		if(!validateNumeric(trimAll(searchValue)))
		{
			alert("Hin No is not valid.");
			document.getElementById('searchField').value = "";
			return false;
		}
		}
		}
		
		
		function chkLength(field,maxLimit)
   {
   if(field.value.length > maxLimit)
   {
    alert('Maximum Limit is '+maxLimit+' characters.');
    var val=field.value.substring(0,maxLimit);
    field.value=val;
   }
}


function validateEstimatedCost()
      {
      cost = document.getElementById('cost').value;         
      if(cost>100000)
      {
      alert("Estimated Cost should be less than or equal to 100000 for Minor Work ");
      return false;
      }
      else
      {
         if(compareDateHere('minorWorkDetailDate','costingDate'))
         return true;
         else
         return false;
      }
      }
      
      function compareDateHere(date1, date2)
      {
	   var fromDateForm=document.getElementById("minorWorkDetailDate").value;
	   var toDateForm=document.getElementById("costingDate").value;
	   var fromDate=new Date(fromDateForm.substring(6),(fromDateForm.substring(3,5) - 1) ,fromDateForm.substring(0,2));
	   var toDate=new Date(toDateForm.substring(6),(toDateForm.substring(3,5) - 1) ,toDateForm.substring(0,2));
	      if((fromDate<toDate))
   {
       alert("Costing Received Date must be less than Minor Work Date!!");
       document.getElementById("costingDate").value="";
       document.getElementById("costingDate").focus();
       return;
   }  
   return true;
      
      }
</script>

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
<script>
serverdate = '<%=dateCal+"/"+month+"/"+year%>';
</script>


<%	String 	userName="";
Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}
String deptName="";
if(session.getAttribute("deptName")!=null){
   deptName=(String)session.getAttribute("deptName");
   }
if(session.getAttribute("userName")!=null){
	userName=(String)session.getAttribute("userName");
}
Map<String, Object> utilMap = new HashMap<String, Object>();
utilMap = (Map) HMSUtil.getCurrentDateAndTime();
String date = (String) utilMap.get("currentDate");
String time = (String) utilMap.get("currentTime");

List<MasWorkCategory> workCategoryList = new ArrayList<MasWorkCategory>();

if (map.get("workCategoryList") != null) {
	workCategoryList = (List) map.get("workCategoryList");
}
List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
if (map.get("masDepartmentList") != null) {
	   masDepartmentList = (List) map.get("masDepartmentList");
}
List<MasWorkType> worktypeList = new ArrayList<MasWorkType>();
if (map.get("workTypeList") != null) {
	worktypeList = (List) map.get("workTypeList");
}
List<MasMinorWorkDetail> minorWorkDetailUpdateList = new ArrayList<MasMinorWorkDetail>();
if (map.get("minorWorkDetailUpdateList") != null) {
	minorWorkDetailUpdateList = (List) map.get("minorWorkDetailUpdateList");
} List<ProposalDepartment> searchProposalDeptList = new ArrayList<ProposalDepartment>();

if(map.get("searchProposalDeptList")!=null)
	{
	 searchProposalDeptList = (List) map.get("searchProposalDeptList");
	}

	String message ="";
	%>


<% 
if (map.get("message") != null) {
		 message = (String) map.get("message");
		
	}
if(!message.equalsIgnoreCase("")){
%>
<h2><%=message %></h2>
<%} %>
<DIV class="Clear"></DIV>

<div id=contentHolder>

<h6>Minor Work Details Update</h6>
<DIV class="Clear"></DIV>
<form name="minorWorkDetailsUpdate" action="" method=post><input
	type="hidden" name="<%=POJO_NAME%>" value="MasMinorWorkDetail">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>"
	value="MinorWorkDetail"> <input type="hidden" name="title"
	value="Minor Work Detail Update"> <input type="hidden"
	name="<%=JSP_NAME %>" value="minorWorkDetailsUpdate">

<div class="blockFrame"><label>Financial Year</label> <select
	name="<%=MINOR_WORK_FINENTIAL_YEAR%>" tabindex="1">
	<option
		value="<%=minorWorkDetailUpdateList.get(0).getFinancialYear()%>"><%=minorWorkDetailUpdateList.get(0).getFinancialYear()%>
	</option>
</select>
<DIV class=Clear></DIV>
<label>Minor Work No.</label> <input tabindex="1" type="text"
	readonly="true"
	value="<%=minorWorkDetailUpdateList.get(0).getMinorWorkDetailNo()%>"
	name="<%=MINOR_WORK_NO%>"> <label>Minor Work Date</label> <input
	type="text" tabindex="1" readonly="true" id="minorWorkDetailDate"
	value="<%=HMSUtil.convertDateToStringWithoutTime(minorWorkDetailUpdateList.get(0).getMinorWorkDetailDate())%>"
	name="<%=MINOR_WORK_DATE%>"> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',document.minorWorkDetailsUpdate.<%=MINOR_WORK_DATE%>,event)" ; />


<!--<label> Work Category<span>*</span></label> 
 <select id="workCategory" name="<%=WORK_CATEGORY%>" tabindex="1" disabled="disabled">
<option value="<%=deptName%>"><%=deptName%></option>

</select> 

--><label>Proposed By</label> <select
	name="<%= MINOR_WORK_CATEGORY_ID %>" tabindex="1">
	<option value="<%=deptName%>"><%=deptName%></option>
	<%
      for (MasDepartment masWorkType :masDepartmentList) {
         if(masWorkType.getStatus().equalsIgnoreCase("y"))
            {
      
   %>

	<option value="<%=masWorkType.getId()%>"><%=masWorkType.getDepartmentName()%></option>

	<%
      }else
         {
            continue;
         }
      }
   %>
</select>


<div class="Clear"></div>

<label><span>*</span>Work Type</label> <select id="workType"
	name="<%=WORK_TYPE%>" tabindex="1">
	<option
		value="<%=minorWorkDetailUpdateList.get(0).getWorkType().getId()%>"><%=minorWorkDetailUpdateList.get(0).getWorkType().getWorkTypeName()%></option>
	<%
for (MasWorkType masWorkType : worktypeList) {
	if(masWorkType.getStatus().equalsIgnoreCase("y") && masWorkType.getWorkCategory().getWorkCategoryName().equalsIgnoreCase("Minor Work") )
    {
%>
	<option value="<%=masWorkType.getId()%>"><%=masWorkType.getWorkTypeName()%></option>
	<%
}
	else{
		continue;
	}
}
%>
</select></div>

<div class="division"></div>

<div class="blockTitle">Work Details</div>
<div class="blockTitleCurve"></div>
<br>
<div class=Clear></div>
<div class="blockFrame"><label><span>*</span>Details of
Work</label> <textarea class="large" value="" onkeyup="chkLength(this,500);"
	tabindex="1" name="<%=MINOR_WORK_DETAIL%>"
	validate="Details of Work,string,yes"><%=minorWorkDetailUpdateList.get(0).getMinorWorkDetail()%></textarea>
<Label><span>*</span>Department </Label> <select tabindex="1"
	name="<%= MINOR_WORK_PROPOSAL_DEPARTMENT %>" id="dept_id"
	multiple="multiple" class="list" style="width: 150px; height: 100px;"
	validate="Department Name,string,yes">

	<option value="0">Select</option>
	<%
      boolean flagSelected =false;
         for (MasDepartment masdepartmentType : masDepartmentList) {  
        	 flagSelected=false;
        	 for(ProposalDepartment proposalDepartment : searchProposalDeptList)
        	 {
        		 if(masdepartmentType.getId()==proposalDepartment.getDepartment().getId())
        		 {
        			 flagSelected=true; 
        			 break;
        		 }
        		 
        	 }
        	 if(flagSelected)
        	 {%>

	<option value=<%=masdepartmentType.getId()%> selected="selected"><%=masdepartmentType.getDepartmentName()%></option>

	<%
      }else
         {%>
	<option value=<%=masdepartmentType.getId()%>><%=masdepartmentType.getDepartmentName()%></option>

	continue;
	<%   }
      }
   %>
</select>
<div class="Clear"></div>

<label>Est. Cost(In Rs.)</label> <input tabindex="1" type="text"
	id="cost"
	value="<%=minorWorkDetailUpdateList.get(0).getMinorWorkDetailEstimatedCost()%>"
	name="<%=MINOR_WORK_ESTIMATED_COST%>"
	validate="Estimated Cost,float,yes" maxlength="6"> <label>Date
of Costing Received</label> <%if(minorWorkDetailUpdateList != null && minorWorkDetailUpdateList.get(0).getDateOfCostingReceived() != null){  %>
<input id="costingDate" type="text"
	name="<%= DATE_OF_COSTING_RECEIVED %>"
	value="<%=HMSUtil.convertDateToStringWithoutTime(minorWorkDetailUpdateList.get(0).getDateOfCostingReceived()) %>"
	class="calDate" tabindex=1
	onchange="compareDateHere('minorWorkDetailDate','costingDate');" /> <%}else{ %>
<input id="costingDate" type="text"
	name="<%= DATE_OF_COSTING_RECEIVED %>" ++"=]+ value="" class="calDate"
	tabindex=1
	onchange="compareDateHere('minorWorkDetailDate','costingDate');" /> <%} %>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',document.minorWorkDetailsUpdate.<%=DATE_OF_COSTING_RECEIVED%>,event)" ; />

<div class="Clear"></div>

<label><span>*</span> Admin Remarks</label> <textarea class="large"
	tabindex="1" name="<%=MINOR_WORK_REMARK%>"
	onkeyup="chkLength(this,100);" validate="Remarks,string,yes"> <%= minorWorkDetailUpdateList.get(0).getMinorWorkDetailRemarks()%></textarea>
</div>
<div class="division"></div>
<div class="bottom"><input type="button" class="button"
	tabindex="2" id=Update accessKey=a value=Update name=Update
	onClick="if(validateEstimatedCost()){submitForm('minorWorkDetailsUpdate','minorWorkDetailsUpdate?method=editMinorWorkDetailsUpdate')};">
<input type="button" name="Cancel" id="Cancel" tabindex="2" value=Cancel
	class="button" accesskey="c"
	onClick="submitForm('minorWorkDetailsUpdate','minorWorkDetailsUpdate?method=deleteMinorWorkDetailsUpdate');" />
<input type="reset" name="Reset" class="button" id=reset tabindex="2"
	accessKey=r onclick=resetCheck(); value=Reset> <input
	type="button" name="back" id="back" value="Back" class="button"
	onclick="javascript:history.back()" accesskey="b" tabindex="2" />
<div class="division"></div>
<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label> <input type="hidden"
	name="<%=STATUS %>" value="" /> <input type="hidden"
	name="<%= COMMON_ID%>" value="" /> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
</form>
</div>


