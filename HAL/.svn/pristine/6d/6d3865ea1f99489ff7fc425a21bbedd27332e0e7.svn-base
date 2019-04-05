<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : majorWorkDetail.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 07.05.2009    Name: Vineet Kumar
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%><%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="jkt.hms.masters.business.MasWorkType"%>
<%@ page import="jkt.hms.masters.business.MasWorkCategory"%>
<%@page import="jkt.hms.masters.business.MasDepartmentType"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<SCRIPT language=javascript src="/hms/jsp/js/common.js"
	type=text/javascript></SCRIPT>

<SCRIPT language=javascript src="/hms/jsp/js/hms.js"
	type=text/javascript></SCRIPT>

<SCRIPT language=javascript src="/hms/jsp/js/calendar.js"
	type=text/javascript></SCRIPT>


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


	
<%	String 	userName="";
	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	if(session.getAttribute("userName")!=null){
		userName=(String)session.getAttribute("userName");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	//String Session=(String) utilMap.get("session");
	String time = (String) utilMap.get("currentTime");
	List<MasWorkCategory> workCategoryList = new ArrayList<MasWorkCategory>();
		
	if(map.get("workCategoryList")!=null)
	{
		workCategoryList = (List) map.get("workCategoryList");
	}
	  String deptName="";
      if(session.getAttribute("deptName")!=null){
         deptName=(String)session.getAttribute("deptName");
         }
	 List<MasDepartment> departmentTypeList = new ArrayList<MasDepartment>();
     if (map.get("departmentTypeList") != null) {
        System.out.println("departmentTypeList");
        departmentTypeList = (List) map.get("departmentTypeList");
     }
	
	List<MasWorkType> worktypeList = new ArrayList<MasWorkType>();
	if(map.get("workTypeList")!=null)
	{
	worktypeList = (List) map.get("workTypeList");
	}
	List<MasEmployee>employee1List=new ArrayList<MasEmployee>();
	if(map.get("employeeList")!=null)
	{
		employee1List=(List)map.get("employeeList");
	}
	
	String majorWorkNo = "";
	if(map.get("majorWorkNo") != null){
		 majorWorkNo = (String)map.get("majorWorkNo");
		  	  
		  }
	String message ="";
	%>
	function chkLength(field,maxLimit)
   {
   if(field.value.length > maxLimit)
   {
    alert('Maximum Limit is '+maxLimit+' characters.');
    var val=field.value.substring(0,maxLimit);
    field.value=val;
   }
}
	</script>
<script type="text/javascript">

	serverdate = '<%=dateCal+"/"+month+"/"+year%>';
</script>

<% 
if (map.get("message") != null) {
		 message = (String) map.get("message");
		
	}
if(!message.equalsIgnoreCase("")){
%>
<h2><%=message %></h2>
<%} %>
<DIV class="Clear"></DIV>
<DIV id=contentHolder>

<h6>Major Work details</h6>
<div class="Clear"></div>
<FORM name="Major_workdetail" action="" method=post>

<DIV class="blockFrame"><LABEL><span>*</span> Major Work
No.</LABEL> <input tabindex="1" name="<%=MAJOR_WORK_NO%>"
	value="<%=majorWorkNo %>" maxlength="12" readonly="true"
	validate="Major Work No,String,yes" /> <LABEL>Major Work Date</LABEL> <INPUT
	tabindex="1" readonly="readonly" value="<%=date%>"
	name="<%=MAJOR_WORK_DATE %>" validate="Major Work Date,date,no" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',document.Major_workdetail.<%=MAJOR_WORK_DATE%>,event)" ; />

<INPUT type=hidden value="<%=userName%>" name="<%=LAST_CHANGED_BY%>" />
<INPUT type=hidden value="<%=date%>" name="<%=LAST_CHANGED_DATE%>" /> <INPUT
	type=hidden value="<%=time%>" name="<%=LAST_CHANGED_TIME%>" />


<div class="clear"></div>
<label>Proposed By</label> <select name="<%= MAJOR_WORK_CATEGORY_ID %>"
	tabindex="1">
	<option value="<%=deptName %>"><%=deptName %></option>
	<option value="0">Select</option>
	<%
for (MasDepartment masDepartment : departmentTypeList) {
   if(masDepartment.getStatus().equalsIgnoreCase("y"))
   {
%>
	<option value="<%=masDepartment.getDepartmentName()%>"><%=masDepartment.getDepartmentName()%></option>
	<%
}else
{
   continue;
}
}
%>
</select> <label>Department</label> <select id="searchField6"
	name="<%=MINOR_WORK_PROPOSAL_DEPARTMENT %>" tabindex="1"">
	<option value="0">Select</option>
	<%
for (MasDepartment masDepartment : departmentTypeList) {
   if(masDepartment.getStatus().equalsIgnoreCase("y"))
   {
%>
	<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>
	<%
}else
{
   continue;
}
}
%>
</select> <label><span>*</span> Work Type</label> <select
	name="<%= MAJOR_WORK_TYPE_ID %>" validate="Work Type,string,yes"
	tabindex="1">
	<option value="">Select</option>
	<%
		for (MasWorkType masWorkType :worktypeList) {
			if(masWorkType.getStatus().equalsIgnoreCase("y") && masWorkType.getWorkCategory().getWorkCategoryName().equalsIgnoreCase("Major Works"))
			{
	%>

	<option value="<%=masWorkType.getId()%>"><%=masWorkType.getWorkTypeName()%></option>

	<%
		}
			else
			{
				continue;
			}
		}
	%>
</select></DIV>



<div class="Clear"></div>
<DIV class="blockTitle">Work Details</DIV>
<DIV class="blockTitleCurve"></DIV>
<div class="Clear"></div>
<DIV class="blockFrame"><label><span>*</span> Details of
Work</Label> <textarea tabindex="1" class="large" onkeyup="chkLength(this,500);"
	name="<%= MAJOR_WORK_DETAIL %>" validate="Details of Work,string,yes"></textarea>

<div class="Clear"></div>


<label>Type<span>*</span></label> <input type="radio"
	name="<%=MAJOR_WORK_DETAIL_TYPE  %>" value="o" checked="checked"
	class="radio" /> <label class="unit">OTM</label> <label class="small">&nbsp;</label>
<input type="radio" name="<%=MAJOR_WORK_DETAIL_TYPE %>" value="m"
	class="radio" /> <label class="unit">Married Accommodation</label>

<div class="Clear"></div>

<label>Remarks </Label> <textarea tabindex="1"
	onkeyup="chkLength(this,500);" class="large"
	name="<%= MAJOR_WORK_REMARK %>"></textarea></div>
<div class="division"></div>
<div id="edited"></div>
<div class="bottom"><INPUT class=button id=savebutton accessKey=a
	onClick="submitForm('Major_workdetail','majorWorkDetail?method=addMajorWorkDetail');"
	tabIndex=1 type=button value=Save name=save> <INPUT
	tabindex="1" class=button id=reset accessKey=r onclick=resetCheck();
	type=reset value=Reset name=Reset> <INPUT tabindex="1"
	class=button id=back accessKey=b type=button
	onClick="javascript:history.back()" value=Back name=back> <INPUT
	type=hidden name="<%=STATUS %>"> <INPUT type=hidden
	name="<%= COMMON_ID%>">
<div class="division"></div>

<label>Changed By</LABEL> <label class="value"><%=userName%></label> <LABEL>Changed
Date</label> <label class="value"><%=date%></label> <LABEL>Changed Time</label>
<label class="value"><%=time%></label> <INPUT type=hidden
	value="<%=userName%>" name="<%=CHANGED_BY%>"> <INPUT
	type=hidden value="<%=date%>" name="<%=CHANGED_DATE %>"> <INPUT
	type=hidden value="<%=time%>" name="<%=CHANGED_TIME %>"> <input
	type="hidden" name="<%=STATUS %>" value="" /> <input type="hidden"
	name="<%= COMMON_ID%>" value="" /></DIV>
</form>

</DIV>



