<%-- 
    * Copyright 2008 JK Technosoft Ltd. All rights reserved.
    * Use is subject to license terms.
    * File Name           : minorWorkProposal.jsp 
    * Tables Used         : 
    * Description         : 
    * @author  Create Date: 06.07.2009    Name: Vineet Kumar
    * @author  Create Date: 06.07.2009	  Name: Vishal	
    * Revision Date:      Revision By: 
    * @version 1.0  
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%><%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.MasWorkType"%>
<%@ page import="jkt.hms.masters.business.MasWorkCategory"%>
<%@ page import="jkt.hms.masters.business.MasMinorWorkDetail"%>
<%@ page import="jkt.hms.masters.business.MasWorkCategory"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<SCRIPT language=javascript src="/hms/jsp/js/common.js"	type=text/javascript></SCRIPT>
<SCRIPT language=javascript src="/hms/jsp/js/style.js"	type=text/javascript></SCRIPT>
<SCRIPT language=javascript src="/hms/jsp/js/calendar.js"	type=text/javascript></SCRIPT>
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


function submitFormNo(formName)
{
 obj = eval('document.'+formName)
 url = "/hms/hms/minorWorkProposal?method=showMinorWorkProposalJsp";
		  	obj.action = url;
   			obj.submit();

}

function submitFormProposal(formName)
{
 obj = eval('document.'+formName)
 url = "/hms/hms/minorWorkProposal?method=generatePerforma&id="+id.value;
		  	obj.action = url;
   			obj.submit();

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
</script>


<SCRIPT>
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
   serverdate = '<%=dateCal+"/"+month+"/"+year%>';
   
<% String   userName="";
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
   String deptName="";
   if(session.getAttribute("deptName")!=null){
      deptName=(String)session.getAttribute("deptName");
      }
   
   
   List<MasMinorWorkDetail>minorWorkDetailList=new ArrayList<MasMinorWorkDetail>();
   String sessionPeriod="";
   if(map.get("session")!=null)
   {
      sessionPeriod=(String) map.get("session");
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
   System.out.println("worktypeList in jsp :"+worktypeList.size());
   String printFlag = "";
   if(map.get("printFlag")!=null)
   {
   printFlag = (String) map.get("printFlag");
   } 
   %>
      
   </SCRIPT>

<% String minorWorkProposalNo ="";
   if(map.get("minorWorkProposalNo") != null){
	   minorWorkProposalNo = (String)map.get("minorWorkProposalNo");
     }
   String message ="";
   StringBuffer message1=new StringBuffer();
      %>
<% 
   if (map.get("message") != null) {
          message = (String) map.get("message");
          
      }
   String id="";
   if (map.get("id") != null) {
       id = map.get("id").toString();
       
   }
   if (map.get("displayMessage") != null) {      
      message1 =new StringBuffer(map.get("displayMessage").toString());
      if(message1.toString().equalsIgnoreCase("y"))
      {
    	  message1 = new StringBuffer("Do you Want to print Performa");
      }
   }
%>

<DIV id="contentHolder">
<%if(!message.equalsIgnoreCase("")){
	   %>
	<h2 style="color:#AC1400;width:350px;"><%=message %></h2>
	<DIV class="Clear"></DIV>
	<h2 style="color:#AC1400;width:350px;"><%=message1 %></h2>
<%} %>
<DIV class="Clear"></DIV>
<FORM name="minorWorkProposal" action="" method=post>
<%if(printFlag.equalsIgnoreCase("y")){%> 
<INPUT type="button" value="Yes" name="Yes" tabindex="1" id="yes" onClick="submitFormProposal('minorWorkProposal');" class="cmnButton"	/> 
<INPUT type="button" tabindex="1" value="No" name="No" id="no"	onclick="submitFormNo('minorWorkProposal');" class="cmnButton" /> 
<%}	%>
<h6>Minor Work Proposal</h6>
<div class="Clear"></div>

<div class="blockFrame">

<Label class="large"><span>*</span>Minor Work Proposal No. </Label> 
<INPUT tabindex="1" value="<%=minorWorkProposalNo%>" name="<%=MINOR_WORK_PROPOSAL_NO%>" validate="Minor Work Proposal No,string,yes" readonly = "readonly" disabled = false /> 
<INPUT type=hidden value="<%=minorWorkProposalNo%>" name="proposalNo">
<Label class="large"><span>*</span>MinorWork Proposal Date </Label> 
<INPUT tabindex="1" value="<%=date%>" name="<%=MINOR_WORK_PROPOSAL_DATE %>" validate="Minor Work Proposal Date,string,yes" /> 
<INPUT type=hidden value="<%=userName%>" name="<%=LAST_CHANGED_BY%>"> 
<INPUT type=hidden value="<%=date%>" name="<%=LAST_CHANGED_DATE%>"> 
<INPUT type=hidden value="<%=time%>" name="<%=LAST_CHANGED_TIME%>"> 
<INPUT type=hidden value="<%=id %>" id="id">
<div class="Clear"></div>

<label class="large"><span>*</span>Proposed By </label> 
<select	name="<%= MINOR_WORK_CATEGORY_ID %>" tabindex="1">
	<option value="<%=deptName%>"><%=deptName%></option>
	<%
      for (MasDepartment masWorkType :departmentTypeList) {
      
   %>

	<option value="<%=masWorkType.getDepartmentName()%>"><%=masWorkType.getDepartmentName()%></option>
	<%    }  %>
</select> 
<label class="large"><span>*</span>Work Type </label> <select
	name="<%= MINOR_WORK_TYPE_ID %>" validate="Work Type,string,yes"
	tabindex="1">
	<option value="">Select</option>
	<%
      for (MasWorkType masWorkType :worktypeList) {
         if(masWorkType.getWorkCategory().getId()==2)
            {
   %>

	<option value="<%=masWorkType.getId()%>"><%=masWorkType.getWorkTypeName()%></option>

	<%
      }
      }
   %>
</select></div>
<DIV class="division"></DIV>
<DIV class="blockTitle">Minor Work Proposal</DIV>
<DIV class="blockTitleCurve"></DIV>
<DIV class="blockFrame">
<DIV class=Clear></DIV>
<label><span>*</span>Details of Work </Label> <textarea tabindex="1"
	maxlength="500" onkeyup="chkLength(this,500);" class="large"
	name="<%= MINOR_WORK_DETAIL %>" validate="Detail of Work,string,yes"></textarea>

<Label><span>*</span>Department </Label> <select tabindex="1"
	style="width: 150px; height: 100px;" name="<%= DEPARTMENT_TYPE_ID %>"
	id="dept_id" multiple="multiple" class="list"
	validate="Department Name,string,yes">

	<option value="0">Select</option>
	<%
         for (MasDepartment masdepartmentType : departmentTypeList) {
      %>

	<option value=<%=masdepartmentType.getId()%>><%=masdepartmentType.getDepartmentName()%></option>

	<%
         }
      %>
</select>
<DIV class="Clear"></DIV>
<Label> Estimated Cost (In Rs.)</Label> <input type="text"
	" tabindex="1" name="<%= MINOR_WORK_ESTIMATED_COST%>" maxlength="12"
	onblur="checkValueOfCost(this);"> <Label><span>*</span>Authority/SOA</Label>
<input type="text" " tabindex="1" name="<%= MINOR_WORK_AUTHORITY%>"
	validate="Authority,string,yes" maxlength="100">
<DIV class="Clear"></DIV>

<label><span>*</span>Justification </Label> <textarea tabindex="1"
	maxlength="100" onkeyup="chkLength(this,100);"
	validate="Justification,string,yes" class="large"
	name="<%= MINOR_WORK_PROPOSAL_JUSTIFICATION %>"></textarea></div>
<div class="division"></div>
<!--Bottom labels starts-->
<div class="bottom"><INPUT class=button id=savebutton accessKey=a
	onClick="submitForm('minorWorkProposal','minorWorkProposal?method=addMinorWorkProposal&printFlag=y');"
	tabIndex=1 type=button value=Save name=save> <INPUT
	tabindex="1" class=button id=reset accessKey=r onclick=resetCheck();
	type=reset value=Reset name=Reset> <INPUT tabindex="1"
	class=button id=back accessKey=b onClick="javascript:history.back()"
	type=button value=Back name=back />
<div class="division"></div>
<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>

</form>
<DIV class="Clear"></DIV>
</DIV>

