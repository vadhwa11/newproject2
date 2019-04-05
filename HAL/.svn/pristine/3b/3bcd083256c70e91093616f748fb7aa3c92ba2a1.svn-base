<%-- 
    * Copyright 2008 JK Technosoft Ltd. All rights reserved.
    * Use is subject to license terms.
    * File Name           : userComments.jsp 
    * Tables Used         : 
    * Description         : 
    * @author  Create Date: 15.07.2009    Name: Vineet Kumar
    * Revision Date:      Revision By: 
    * @version 1.0  
    
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%><%@ page import="jkt.hms.util.HMSUtil"%>

<%@ page import="jkt.hms.masters.business.MasWorkType"%>
<%@ page import="jkt.hms.masters.business.MasWorkCategory"%>
<%@page import="jkt.hms.masters.business.MasMinorWorkProposal"%>
<%@page import="jkt.hms.masters.business.MasDepartmentType"%>

<%@page import="jkt.hms.masters.business.WorkNoDepartment"%>
<%@page import="jkt.hms.masters.business.MasMinorWorkDetail"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<SCRIPT language=javascript src="/hms/jsp/js/common.js"
	type=text/javascript></SCRIPT>

<SCRIPT language=javascript src="/hms/jsp/js/hms.js"
	type=text/javascript></SCRIPT>

<SCRIPT language=javascript src="/hms/jsp/js/calendar.js"
	type=text/javascript></SCRIPT>


<script language="javascript" type="text/javascript">

function isNumeric(elem, helperMsg){
   var numericExpression = /^[0-9]+$/;
   if(elem.value.match(numericExpression)){
      return true;
   }else{
      alert(helperMsg);
      elem.focus();
      return false;
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

function submitSearch(formName)
{
 var url;
 obj1 = eval('document.'+formName)  ;
 
      url = "/hms/hms/minorWorkProposal?method=searchMinorWorkDetailNewForCompletion";
   
   obj1.action = url;
    obj1.submit();


}
function get_bag_no()
{
var url;
url="/hms/hms/minorWorkDetail?method=showPopUpProposalJsp";
 popwindow(url);
 }  

var newwindow;
function popwindow(url)
{

 newwindow=window.open(url,'name',"left=100,top=100,height=500,width=950,status=1,scrollbars=1,resizable=0");
 if (window.focus) 
 {
 newwindow.focus()
 }
newwindow.createPopup();

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
<SCRIPT>
   serverdate = '<%=dateCal+"/"+month+"/"+year%>';
      </SCRIPT>
<% String   userName="";
   Map<String,Object> map = new HashMap<String,Object>();
   if (request.getAttribute("map") != null) {
      map = (Map) request.getAttribute("map");
   }
   if(session.getAttribute("userName")!=null){
      userName=(String)session.getAttribute("userName");
   }
   
   String deptName="";
      if(session.getAttribute("deptName")!=null){
         deptName=(String)session.getAttribute("deptName");
         }
   Map<String, Object> utilMap = new HashMap<String, Object>();
   utilMap = (Map) HMSUtil.getCurrentDateAndTime();
   String date = (String) utilMap.get("currentDate");
   //String Session=(String) utilMap.get("session");
   String time = (String) utilMap.get("currentTime");
   
   List<MasDepartment> departmentTypeList = new ArrayList<MasDepartment>();
   if (map.get("departmentTypeList") != null) {
      System.out.println("departmentTypeList");
      departmentTypeList = (List) map.get("departmentTypeList");
   }
   List<MasMinorWorkDetail> searchMinorWorkDetailSearchList = new ArrayList<MasMinorWorkDetail>();
    
      if(map.get("searchMinorWorkDetailSearchList")!=null)
      {
         searchMinorWorkDetailSearchList = (List) map.get("searchMinorWorkDetailSearchList");
      }
   
   
   String sessionPeriod="";
   if(map.get("session")!=null)
   {
      sessionPeriod=(String) map.get("session");
   }
   
   
   
   List<MasWorkCategory> workCategoryList = new ArrayList<MasWorkCategory>();
      
   if(map.get("workCategoryList")!=null)
   {
      workCategoryList = (List) map.get("workCategoryList");
   }
   
   List<MasWorkType> worktypeList = new ArrayList<MasWorkType>();
   if(map.get("workTypeList")!=null)
   {
   worktypeList = (List) map.get("workTypeList");
   }  
   List<WorkNoDepartment> gridTypeList = new ArrayList<WorkNoDepartment>();
   
   if (map.get("gridTypeList") != null) {
       System.out.println("gridTypeList");
       gridTypeList = (List) map.get("gridTypeList");
    }
   %>
<% String minorWorkNo ="";
   if(map.get("minorWorkNo") != null){
      minorWorkNo = (String)map.get("minorWorkNo");
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

<div class="Clear"></div>
<DIV id="contentHolder">
<DIV class="Clear"></DIV>
<FORM name="userComments" action="" method=post>
<h6>User Comments</h6>
<div class="Clear"></div>

<div class="blockFrame"><Label> Minor Work No </Label> <%if(searchMinorWorkDetailSearchList !=null && searchMinorWorkDetailSearchList.size()>0){ %>
<INPUT tabindex="1" validate="Minor Work No,string,yes"
	value="<%=searchMinorWorkDetailSearchList.get(0).getMinorWorkDetailNo() %>"
	id="proposalNo" name="<%=MINOR_WORK_PROPOSAL_NO_SEARCH %>"
	onchange="submitSearch('userComments');"
	onblur="submitSearch('userComments');" /> <%} else if(minorWorkNo != null) { %>
<input tabindex="1" name="<%=MINOR_WORK_PROPOSAL_NO_SEARCH%>"
	id="proposalNo" value="<%=minorWorkNo %>" readonly="true"
	validate="Minor Work No,string,yes"
	onchange="submitSearch('userComments');"
	onblur="submitSearch('userComments');" /> <%} else { %> <INPUT
	tabindex="1" validate="Minor Work No,string,yes" value=""
	name="<%=MINOR_WORK_PROPOSAL_NO_SEARCH %>" id="proposalNo"
	onchange="submitSearch('userComments');"
	onblur="submitSearch('userComments');" /> <%} %> <%if(searchMinorWorkDetailSearchList !=null && searchMinorWorkDetailSearchList.size()>0){ %>
<input tabindex="1" type="hidden" name="<%=MINOR_WORK_ID%>"
	id="proposalNoId"
	value="<%=searchMinorWorkDetailSearchList.get(0).getId() %>" /> <%} else { %>
<input type="hidden" tabindex="1" name="<%=MINOR_WORK_ID%>"
	id="proposalNoId" value="" /> <%} %> <INPUT class="cmnButton"
	id="search" accessKey=a onclick="get_bag_no();" tabIndex=1 type=button
	value="Proposal Help" name=search>
<div class="Clear"></div>

<Label> Financial Year<span>*</span> </Label> <select
	disabled="disabled" name="<%=MINOR_WORK_FINENTIAL_YEAR%>"
	validate="Financial year,string,yes" tabindex=1>

	<option value="<%=sessionPeriod%>"><%=sessionPeriod%></option>


</select>
<div class="Clear"></div>
<LABEL> Minor Work No.<span>*</span> </LABEL> <%if(searchMinorWorkDetailSearchList !=null && searchMinorWorkDetailSearchList.size()>0){ %>
<input tabindex="1" name="<%=MINOR_WORK_NO%>"
	value="<%=searchMinorWorkDetailSearchList.get(0).getMinorWorkDetailNo() %>"
	readonly="true" validate="Minor Work No,string,yes" /> <%} else { %> <input
	tabindex="1" name="<%=MINOR_WORK_NO%>" value="" readonly="true"
	validate="Minor Work No,string,yes" /> <%} %> <LABEL>Minor Work
Date<span>*</span> </LABEL> <INPUT tabindex="1" readonly="readonly"
	value="<%=date%>" name="<%=MINOR_WORK_DATE %>"
	validate="Minor Work Date,string,yes" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',document.userComments.<%=MINOR_WORK_DATE%>,event)" ; />


<div class="Clear"></div>
<label>Proposed By <span>*</span></label> <select
	name="<%= MINOR_WORK_CATEGORY_ID %>" tabindex="1" disabled="disabled">
	<option value="<%=deptName%>">Select</option>
	<%
      for (MasDepartment masWorkType :departmentTypeList) {
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
</select> <label>Work Type<span>*</span> </label> <select
	name="<%= MINOR_WORK_TYPE_ID %>" validate="Work Type,string,yes"
	tabindex=2 disabled="disabled">
	<% if(searchMinorWorkDetailSearchList != null && searchMinorWorkDetailSearchList.size()>0 ){%>
	<option
		value="<%=searchMinorWorkDetailSearchList.get(0).getWorkType().getId() %>"><%=searchMinorWorkDetailSearchList.get(0).getWorkType().getWorkTypeName() %></option>
	<%}else{ %>
	<option value="0">Select</option>

	<% }%>
	<%   for (MasWorkType masWorkType :worktypeList) {
         if(masWorkType.getStatus().equalsIgnoreCase("y"))
            {
      
   %>

	<option value="<%=masWorkType.getId()%>"><%=masWorkType.getWorkTypeName()%></option>

	<%
      }else
         {
            continue;
         }
      }
   %>
</select></div>
<DIV class="division"></DIV>
<DIV class="blockTitle">Work Details</DIV>
<DIV class="blockTitleCurve"></DIV>
<DIV class="blockFrame">
<DIV class=Clear></DIV>
<label> Details of Work<span>*</span> </Label> <% if(searchMinorWorkDetailSearchList != null && searchMinorWorkDetailSearchList.size()>0 ){%>

<textarea readonly="readonly" tabindex="1" maxlength="500"
	onkeyup="chkLength(this,500);" class="large"
	name="<%= MINOR_WORK_DETAIL %>" validate="Detail of Work,string,yes"><%=searchMinorWorkDetailSearchList.get(0).getMinorWorkDetail() %> </textarea>
<%}else{ %> <textarea readonly="readonly" tabindex="1" maxlength="500"
	onkeyup="chkLength(this,500);" class="large"
	name="<%= MINOR_WORK_DETAIL %>" validate="Detail of Work,string,yes"> </textarea>
<%} %> <Label> Estimated Cost<span>*</span></Label> <% if(searchMinorWorkDetailSearchList != null && searchMinorWorkDetailSearchList.size()>0 ){%>

<input readonly="readonly" type="text" " tabindex="1"
	name="<%= MINOR_WORK_ESTIMATED_COST%>"
	value="<%=searchMinorWorkDetailSearchList.get(0).getMinorWorkDetailEstimatedCost() %>"
	validate="Estimated Cost,float,yes" maxlength="12"> <%}else{ %> <input
	readonly="readonly" type="text" " tabindex="1"
	name="<%= MINOR_WORK_ESTIMATED_COST%>" value=""
	validate="Estimated Cost,float,yes" maxlength="12"> <%} %>
<DIV class=Clear></DIV>
<Label>Department<span>*</span></Label> <select disabled="disabled"
	name="<%= DEPARTMENT_TYPE_ID %>" id="dept_id" multiple class="list">

	<option value="0">Select</option>
	<%
         for (WorkNoDepartment masdepartmentType : gridTypeList) {
      %>

	<option value=<%=masdepartmentType.getDepartment().getId()%>><%=masdepartmentType.getDepartment().getDepartmentTypeName()%></option>

	<%
         }
      %>
</select>

<DIV class="Clear"></DIV>
<label>User Comments<span>*</span> </Label> <% if(searchMinorWorkDetailSearchList != null && searchMinorWorkDetailSearchList.size()>0 && searchMinorWorkDetailSearchList.get(0).getUserComments()!= null ){%>

<textarea maxlength="100" onkeyup="chkLength(this,100);" class="large"
	name="<%= USER_COMMENTS %>" tabindex="1"
	validate="User Comments,string,yes"><%=searchMinorWorkDetailSearchList.get(0).getUserComments() %></textarea>
<%}else{ %> <textarea maxlength="100" onkeyup="chkLength(this,100);"
	class="large" name="<%= USER_COMMENTS %>" tabindex="1"
	validate="User Comments,string,yes"></textarea> <%} %>
</div>



<div class="division"></div>
<!--Bottom labels starts-->
<div class="bottom"><INPUT class=button id=savebutton accessKey=a
	onClick="submitForm('userComments','minorWorkDetail?method=editUserComments');"
	tabIndex=1 type=button value=Save name=save> <INPUT
	class=button id=reset accessKey=r onclick=resetCheck(); type=reset
	value=Reset name=Reset tabindex="1"> <INPUT class=button
	id=back accessKey=b onClick="javascript:history.back()" tabindex="1"
	type=button value=Back name=back /> <INPUT type=hidden
	name="<%=STATUS %>"> <INPUT type=hidden name="<%= COMMON_ID%>">

<div class="division"></div>

<input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= COMMON_ID%>" value="" /> <label>Changed
By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>

</form>
</DIV>

