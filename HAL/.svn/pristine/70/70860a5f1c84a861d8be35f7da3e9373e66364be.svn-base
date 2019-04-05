<%-- 
    * Copyright 2008 JK Technosoft Ltd. All rights reserved.
    * Use is subject to license terms.
    * File Name           : minorWorkProposalCancellation.jsp 
    * Tables Used         : 
    * Description         : 
    * @author  Create Date: 08.07.2009    Name: Vineet Kumar
    * Revision Date:      Revision By: 
    * @version 1.0  
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%><%@ page import="jkt.hms.util.HMSUtil"%>

<%@ page import="jkt.hms.masters.business.MasWorkType"%>
<%@ page import="jkt.hms.masters.business.MasWorkCategory"%>
<%@ page import="jkt.hms.masters.business.MasMinorWorkDetail"%>
<%@ page import="jkt.hms.masters.business.MasWorkCategory"%>


<%@page import="jkt.hms.masters.business.MasMinorWorkProposal"%>
<%@page import="jkt.hms.masters.business.MasDepartmentType"%>
<%@page import="jkt.hms.masters.business.ProposalDepartment"%>
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
 
      url = "/hms/hms/minorWorkProposal?method=searchMinorWorkDetailSearch";
   
   obj1.action = url;
    obj1.submit();


}
 function checkSubmit(){

if(confirm('Are you sure want to cancle the proposal')){

	  return true;
	  	}else
	  	{
	  	  	return false;
	  	}
	  	
}          
function get_bag_no()
{
var url;
url="/hms/hms/minorWorkProposal?method=showPopUpProposalJsp";
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
<script language="javascript">  
   
   serverdate = '<%=dateCal+"/"+month+"/"+year%>';
   </script>
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
   
   List<ProposalDepartment> gridTypeList = new ArrayList<ProposalDepartment>();
   if (map.get("gridTypeList") != null) {
	      System.out.println("gridTypeList");
	      gridTypeList = (List) map.get("gridTypeList");
	   }
   
   List<MasDepartment> departmentTypeList = new ArrayList<MasDepartment>();
   if (map.get("departmentTypeList") != null) {
      System.out.println("departmentTypeList");
      departmentTypeList = (List) map.get("departmentTypeList");
   }
   List<ProposalDepartment> searchProposalDeptList = new ArrayList<ProposalDepartment>();
   if (map.get("searchProposalDeptList") != null) {
      System.out.println("searchProposalDeptList");
      searchProposalDeptList = (List) map.get("searchProposalDeptList");
   }
   List<MasMinorWorkProposal> searchMinorWorkDetailSearchList = new ArrayList<MasMinorWorkProposal>();
      
   if(map.get("searchMinorWorkDetailSearchList")!=null)
   {
	   searchMinorWorkDetailSearchList = (List) map.get("searchMinorWorkDetailSearchList");
   }
   
   List<MasWorkType> worktypeList = new ArrayList<MasWorkType>();
   if(map.get("workTypeList")!=null)
   {
   worktypeList = (List) map.get("workTypeList");
   }  
   %>


<% String minorWorkProposalNo ="";   
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
<FORM name="minorWorkProposalCancellation" action="" method=post>
<h6>Minor Work Proposal Cancellation</h6>
<div class="Clear"></div>

<div class="blockFrame"><Label class="large"><span>*</span>Minor
Work Proposal No Search</Label> <INPUT value="" id="proposalNo"
	name="<%=MINOR_WORK_PROPOSAL_NO_SEARCH %>"
	onchange="submitSearch('minorWorkProposalCancellation');"
	onblur="submitSearch('minorWorkProposalCancellation');" tabindex="1" />

<INPUT class=cmnButton id=search accessKey=b onclick="get_bag_no();"
	tabIndex="1" type=button value="Proposal Help" name=search />

<div class="Clear"></div>
<Label class="large"><span>*</span>Minor Work Proposal No </Label> <%if(searchMinorWorkDetailSearchList != null && searchMinorWorkDetailSearchList.size()>0 ){ %>
<INPUT
	value="<%=searchMinorWorkDetailSearchList.get(0).getMinorWorkProposalNo()%>"
	id="proposalNoId" name="<%=MINOR_WORK_PROPOSAL_NO %>" tabindex="1" /> <%}else{ %>
<INPUT tab value="" readonly="readonly" id="proposalNoId"
	name="<%=MINOR_WORK_PROPOSAL_NO %>" tabindex="1"
	validate="Minor Work Proposal No,string,yes" /> <%} %> <Label
	class="large"><span>*</span>Minor Work Proposal Date </Label> <%if(searchMinorWorkDetailSearchList != null && searchMinorWorkDetailSearchList.size()>0 ){ %>

<INPUT tabindex="1" readonly="readonly"
	value="<%=HMSUtil.convertDateToStringWithoutTime(searchMinorWorkDetailSearchList.get(0).getMinorWorkProposalDate())%>"
	name="<%=MINOR_WORK_PROPOSAL_DATE %>"
	validate="Minor Work Proposal Date,string,yes" /> <%}else{ %> <INPUT
	tabindex="1" validate="Minor Work Proposal Date,string,yes"
	readonly="readonly" /> <%} %> <INPUT type=hidden value="<%=userName%>"
	name="<%=LAST_CHANGED_BY%>"> <INPUT type=hidden
	value="<%=date%>" name="<%=LAST_CHANGED_DATE%>"> <INPUT
	type=hidden value="<%=time%>" name="<%=LAST_CHANGED_TIME%>"> <%if(searchMinorWorkDetailSearchList != null && searchMinorWorkDetailSearchList.size()>0 ){ %>
<INPUT type=hidden
	value="<%=searchMinorWorkDetailSearchList.get(0).getId()%>"
	name="<%=COMMON_ID%>"> <%}else{ %> <INPUT type=hidden value=""
	name="<%=LAST_CHANGED_TIME%>"> <%} %>

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
	name="<%= MINOR_WORK_TYPE_ID %>" tabindex="1" disabled="disabled">
	<%if(searchMinorWorkDetailSearchList != null && searchMinorWorkDetailSearchList.size()>0 ){ %>
	<option
		value="<%=searchMinorWorkDetailSearchList.get(0).getWorkType().getId()%>"><%=searchMinorWorkDetailSearchList.get(0).getWorkType().getWorkTypeName() %></option>
	<%}else{ %>
	<option value="0">Select</option>
	<%} %>
</select></div>
<DIV class="division"></DIV>
<DIV class="blockTitle">Minor Work Proposal</DIV>
<DIV class="blockTitleCurve"></DIV>
<DIV class="blockFrame">
<DIV class=Clear></DIV>
<label><span>*</span>Details of Work </Label> <%if(searchMinorWorkDetailSearchList != null && searchMinorWorkDetailSearchList.size()>0 ){ %>
<textarea tabindex="1" readonly="readonly" maxlength="500"
	onkeyup="chkLength(this,500);" class="large"
	name="<%= MINOR_WORK_DETAIL %>" validate="Detail of Work,string,yes"><%=searchMinorWorkDetailSearchList.get(0).getMinorWorkDetail() %></textarea>
<%}else{ %> <textarea tabindex="1" readonly="readonly" maxlength="500"
	onkeyup="chkLength(this,500);" class="large"
	name="<%= MINOR_WORK_DETAIL %>" validate="Detail of Work,string,yes"></textarea>
<%} %>
<DIV class=Clear></DIV>

<Label><span>*</span>Department</Label> <select tabindex="1"
	name="<%= MINOR_WORK_PROPOSAL_DEPARTMENT %>" id="dept_id"
	multiple="multiple" class="list">


	<%
         for (ProposalDepartment masdepartmentType : searchProposalDeptList) {
        	 System.out.println("proposal list"+masdepartmentType.getDepartment().getDepartmentName());
      %>

	<option value=<%=masdepartmentType.getDepartment().getId()%>><%=masdepartmentType.getDepartment().getDepartmentName()%></option>

	<%
         }
      %>
</select>




<DIV class="Clear"></DIV>
<label> Justification </Label> <% if(searchMinorWorkDetailSearchList != null &&searchMinorWorkDetailSearchList.size()>0 && searchMinorWorkDetailSearchList.get(0).getJustification() != null){%>
<textarea readonly="readonly" tabindex="1" maxlength="100"
	onkeyup="chkLength(this,100);" class="large"
	name="<%= MINOR_WORK_PROPOSAL_JUSTIFICATION %>"><%=searchMinorWorkDetailSearchList.get(0).getJustification() %></textarea>
<%}else{ %> <textarea readonly="readonly" tabindex="1" maxlength="100"
	onkeyup="chkLength(this,100);" class="large"
	name="<%= MINOR_WORK_PROPOSAL_JUSTIFICATION %>"></textarea> <%} %>

<DIV class="Clear"></DIV>
<label><span>*</span>Cancellation Reason </Label> <textarea tabindex="1"
	maxlength="100" onkeyup="chkLength(this,100);"
	validate="Cancellation Reason,String,yes" class="large"
	name="<%= MINOR_WORK_PROPOSAL_CANCELLATION_REASON %>"></textarea></div>
<div class="division"></div>
<!--Bottom labels starts-->
<div id="edited"></div>
<div class="bottom"><INPUT class=cmnButton id=savebutton
	accessKey=a
	onClick="if(checkSubmit()){submitForm('minorWorkProposalCancellation','minorWorkProposal?method=cancleMinorWorkProposal');}"
	tabIndex="1" type=button value="Cancle Proposal" name=save> <INPUT
	tabindex="1" class=cmnButton id=reset accessKey=r onclick=resetCheck();
	type=reset value=Reset name=Reset> <INPUT tabindex="1"
	class=cmnButton id=back accessKey=b onClick="javascript:history.back()"
	type=button value=Back name=back />
<div class="division"></div>
<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label> <input type="hidden"
	name="<%=LAST_CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=LAST_CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>

</form>
<DIV class="Clear"></DIV>
</DIV>

