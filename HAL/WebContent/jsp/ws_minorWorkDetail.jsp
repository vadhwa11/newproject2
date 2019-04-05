<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : minorWorkDetail.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 27.04.2009    Name: Vineet Kumar
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%><%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="jkt.hms.masters.business.MasRelation"%>
<%@ page import="jkt.hms.masters.business.MasWorkType"%>
<%@ page import="jkt.hms.masters.business.MasWorkCategory"%>
<%@ page import="jkt.hms.masters.business.MasMinorWorkDetail"%>
<%@ page import="jkt.hms.masters.business.MasWorkCategory"%>


<%@page import="jkt.hms.masters.business.MasMinorWorkProposal"%>
<%@page import="jkt.hms.masters.business.MasDepartmentType"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.ProposalDepartment"%>
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

function checkValueOfCost(estimatedCost)
	{	 
 		var val = estimatedCost.value;
 		obj1 = parseInt(val); 
        if(!validateInteger(val) && val !="")
        {
        alert("Please enter only integer value");
        estimatedCost.value ="";
        return false;
        }
        else 
        {
        true;
        }
}

function submitSearch(formName)
{
 var url;
 obj1 = eval('document.'+formName)  ;
 
      url = "/hms/hms/minorWorkProposal?method=searchMinorWorkDetailNew";
   
   obj1.action = url;
    obj1.submit();


}
function get_bag_no()
{
var url;
url="/hms/hms/minorWorkProposal?method=popUpForProposalJsp";
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
<script type="text/javascript">
function checkWorkTypeLimit(estimatedCost)
	{
 		var val = estimatedCost.value;
 		obj1 = parseInt(val);
 
     if(parseInt(val))
}

</script>



<%	String 	userName="";
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
	   
	   List<MasDepartment> departmentTypeList = new ArrayList<MasDepartment>();
	   if (map.get("departmentTypeList") != null) {
	      System.out.println("departmentTypeList");
	      departmentTypeList = (List) map.get("departmentTypeList");
	   }
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	//String Session=(String) utilMap.get("session");
	String time = (String) utilMap.get("currentTime");
	
	List<MasMinorWorkProposal> searchMinorWorkDetailSearchList = new ArrayList<MasMinorWorkProposal>();
    
	   if(map.get("searchMinorWorkDetailSearchList")!=null)
	   {
	      searchMinorWorkDetailSearchList = (List) map.get("searchMinorWorkDetailSearchList");
	   }
	
	
	String sessionPeriod="";
	if(map.get("session")!=null)
	{
		sessionPeriod=(String) map.get("session");
	}
	 List<ProposalDepartment> searchProposalDeptList = new ArrayList<ProposalDepartment>();
	
	 if(map.get("searchProposalDeptList")!=null)
		{
		 searchProposalDeptList = (List) map.get("searchProposalDeptList");
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
<FORM name="minorWorkDetails" action="" method=post>
<h6>Minor Work Details</h6>
<div class="Clear"></div>

<div class="blockFrame">
<Label class="large"><span>*</span>Minor Work Proposal No. </Label> <%if(searchMinorWorkDetailSearchList !=null && searchMinorWorkDetailSearchList.size()>0){ %>
<INPUT validate="Proposal No,string,yes"
	value="<%=searchMinorWorkDetailSearchList.get(0).getMinorWorkProposalNo() %>"
	id="proposalNo" name="<%=MINOR_WORK_PROPOSAL_NO %>"
	onchange="submitSearch('minorWorkDetails');"
	onblur="submitSearch('minorWorkDetails');" /> <%} else { %> <INPUT
	validate="Proposal No,string,yes" value="" id="proposalNo"
	name="<%=MINOR_WORK_PROPOSAL_NO %>"
	onchange="submitSearch('minorWorkDetails');"
	onblur="submitSearch('minorWorkDetails');" /> <%} %> <%if(searchMinorWorkDetailSearchList !=null && searchMinorWorkDetailSearchList.size()>0){ %>
<input type="hidden" name="<%=MINOR_WORK_PROPOSAL_NO_ID%>"
	id="proposalNoId"
	value="<%=searchMinorWorkDetailSearchList.get(0).getId() %>" /> <%} else { %>
<input type="hidden" name="<%=MINOR_WORK_PROPOSAL_NO_ID%>"
	id="proposalNoId" value="" /> <%} %> <INPUT class=cmnButton id=search
	accessKey=a onclick="get_bag_no();" tabIndex=1 type=button
	value="Proposal Help" name=search>
<div class="Clear"></div>

<Label class="large"><span>*</span>Financial Year </Label> <select
	name="<%=MINOR_WORK_FINENTIAL_YEAR%>"
	validate="Financial year,string,yes" tabindex=1>

	<option value="<%=sessionPeriod%>"><%=sessionPeriod%></option>


</select>
<div class="Clear"></div>
<LABEL class="large"><span>*</span>Minor Work No. </LABEL> 
<input tabindex="1" name="<%=MINOR_WORK_NO%>" value="<%=minorWorkNo %> " readonly="true" validate="Minor Work No,string,yes" /> 
<LABEL class="large"><span>*</span>Minor Work Date</LABEL> 
<INPUT tabindex="1" readonly="readonly" value="" name="<%=MINOR_WORK_DATE %>" validate="Minor Work Date,string,yes" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',document.minorWorkDetails.<%=MINOR_WORK_DATE%>,event)" ; />

<INPUT type=hidden value="<%=userName%>" name="<%=LAST_CHANGED_BY%>">
<INPUT type=hidden value="<%=date%>" name="<%=LAST_CHANGED_DATE%>">
<INPUT type=hidden value="<%=time%>" name="<%=LAST_CHANGED_TIME%>">
<div class="Clear"></div>

<label class="large"><span>*</span>Proposed By </label> <select
	name="<%= MINOR_WORK_CATEGORY_ID %>" tabindex="1">
	<option value="<%=deptName%>"><%=deptName%></option>
	<%
      for (MasDepartment masWorkType :departmentTypeList) {
         if(masWorkType.getStatus().equalsIgnoreCase("y"))
            {
      
   %>

	<option value="<%=masWorkType.getDepartmentName()%>"><%=masWorkType.getDepartmentName()%></option>

	<%
      }else
         {
            continue;
         }
      }
   %>
</select> <label class="large"><span>*</span>Work Type </label> <select
	name="<%= MINOR_WORK_TYPE_ID %>" validate="Work Type,string,yes"
	tabindex=1 onchange="setMaxAndMin();" onblur="setMaxAndMin();">
	<% if(searchMinorWorkDetailSearchList != null && searchMinorWorkDetailSearchList.size()>0 ){%>
	<option
		value="<%=searchMinorWorkDetailSearchList.get(0).getWorkType().getId() %>">
	<%=searchMinorWorkDetailSearchList.get(0).getWorkType().getWorkTypeName()%></option>

	<%}else{%>
	<option value="0">Select</option>

	<% }
		for (MasWorkType masWorkType :worktypeList) {
			if(masWorkType.getStatus().equalsIgnoreCase("y") && masWorkType.getWorkCategory().getWorkCategoryName().equalsIgnoreCase("Minor Works"))
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
<% if(searchMinorWorkDetailSearchList != null && searchMinorWorkDetailSearchList.size()>0 ){%>

<input type="hidden" " tabindex="1" name="<%= MINOR_WORK_AUTHORITY%>"
	value="<%=searchMinorWorkDetailSearchList.get(0).getAuthority() %>"
	maxlength="100"> <%}else{ %> <input type="hidden" " tabindex="1"
	name="<%= MINOR_WORK_AUTHORITY%>" value="" maxlength="100"> <%} %>
<label><span>*</span>Details of Work </Label> <% if(searchMinorWorkDetailSearchList != null && searchMinorWorkDetailSearchList.size()>0 ){%>

<textarea tabindex="1" maxlength="500" onkeyup="chkLength(this,500);"
	class="large" name="<%= MINOR_WORK_DETAIL %>"
	validate="Detail of Work,string,yes"><%=searchMinorWorkDetailSearchList.get(0).getMinorWorkDetail() %></textarea>
<%}else{ %> <textarea tabindex="1" maxlength="500"
	onkeyup="chkLength(this,500);" class="large"
	name="<%= MINOR_WORK_DETAIL %>" validate="Detail of Work,string,yes"></textarea>

<%} %> <Label class="large"> Estimated Cost (In Rs.)</Label> <% if(searchMinorWorkDetailSearchList != null && searchMinorWorkDetailSearchList.size()>0 ){%>
<input type="text" " tabindex="1" name="<%= MINOR_WORK_ESTIMATED_COST%>"
	value="<%=searchMinorWorkDetailSearchList.get(0).getEstimatedCost() %>"
	maxlength="12" onblur="checkValueOfCost(this);"> <%}else{ %> <input
	type="text" " tabindex="1" name="<%= MINOR_WORK_ESTIMATED_COST%>"
	value="" maxlength="12" onblur="checkValueOfCost(this);"> <%} %>
<DIV class=Clear></DIV>
<label><span>*</span>Justification </Label> <% if(searchMinorWorkDetailSearchList != null && searchMinorWorkDetailSearchList.size()>0 ){%>

<textarea tabindex="1" maxlength="100" onkeyup="chkLength(this,100);"
	validate="Justification,string,yes" class="large"
	name="<%= MINOR_WORK_PROPOSAL_JUSTIFICATION %>"><%=searchMinorWorkDetailSearchList.get(0).getJustification() %></textarea>
<%}else{ %> <textarea tabindex="1" maxlength="100"
	onkeyup="chkLength(this,100);" validate="Justification,string,yes"
	class="large" name="<%= MINOR_WORK_PROPOSAL_JUSTIFICATION %>"></textarea>
<%} %> <Label><span>*</span>Department </Label> <select tabindex="1"
	name="<%= MINOR_WORK_PROPOSAL_DEPARTMENT %>" id="dept_id"
	multiple="multiple" class="list" style="width: 150px; height: 100px;"
	validate="Department Name,string,yes">

	<option value="0">Select</option>
	<%
      boolean flagSelected =false;
         for (MasDepartment masdepartmentType : departmentTypeList) {  
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


<DIV class="Clear"></DIV>
<label>Admin Remarks </Label> <textarea tabindex="1" maxlength="100"
	onkeyup="chkLength(this,100);" class="large"
	name="<%= MINOR_WORK_REMARK %>"></textarea></div>



<div class="division"></div>
<!--Bottom labels starts-->
<div id="edited"></div>
<div class="bottom"><INPUT class=button id=savebutton accessKey=a
	onClick="submitForm('minorWorkDetails','minorWorkDetail?method=addMinorWorkDetail');"
	tabIndex="1" type=button value=Save name=save> <INPUT
	class=button id=reset accessKey=r onclick=resetCheck(); type=reset
	value=Reset name=Reset tabindex="1" /> <INPUT class=button id=back
	accessKey=b onClick="javascript:history.back()" type=button value=Back
	name=back tabindex="1" /> <INPUT type=hidden name="<%=STATUS %>">
<INPUT type=hidden name="<%= COMMON_ID%>">

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
<DIV class="Clear"></DIV>
</DIV>

