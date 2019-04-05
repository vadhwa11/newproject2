<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : approvalOfMinorWorkDetail.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 05.05.2009    Name: Vineet Kumar
	 * Revision Date:      Revision By: 
	 * @version 1.0  
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%><%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasWorkType"%>
<%@page import="jkt.hms.masters.business.MasWorkCategory"%>
<%@page import="jkt.hms.masters.business.MasMinorWorkDetail"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>

<script language=javascript src="/hms/jsp/js/common.js"
	type=text/javascript></script>

<script language=javascript src="/hms/jsp/js/hms.js"
	type=text/javascript></script>

<script language=javascript src="/hms/jsp/js/calendar.js"
	type=text/javascript></script>

<%
	Calendar calendar = Calendar.getInstance();
	String month = String.valueOf((calendar.get(Calendar.MONTH)) + 1);
	String dateCal = String.valueOf(calendar.get(Calendar.DATE));
	int year = calendar.get(calendar.YEAR);
	if (month.length() < 2) {
		month = "0" + month;
	}
	if (dateCal.length() < 2) {
		dateCal = "0" + dateCal;
	}
%>
<%
	String userName = "";
   String approvalNo = "";
   String pdc = "";
   String adminApprovalDate = "";
	Map<String, Object> map = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");

	String deptName="";
    if(session.getAttribute("deptName")!=null){
       deptName=(String)session.getAttribute("deptName");
       }
	if (map.get("message") != null) {
		String message = (String) map.get("message");
		out.println(message);
	}
	int totalAllotmentAmount=0;
	   String printFlag = "";
	   if(map.get("printFlag")!=null)
	   {
	   printFlag = (String) map.get("printFlag");
	   } 
	if (map.get("totalAllotmentAmount") != null) {
	      totalAllotmentAmount = (Integer) map.get("totalAllotmentAmount");
	    }
	   String id="";
	   if (map.get("id") != null) {
	       id = map.get("id").toString();
	       System.out.println("id--------"+id);
	       
	   }
	
	int expenditureAmount=0;
    
	   if (map.get("expenditureAmount") != null) {
		   expenditureAmount = (Integer) map.get("expenditureAmount");
	       }
	
	List<MasEmployee> masEmployee = new ArrayList<MasEmployee>();
	if (map.get("masEmployee") != null) {
		masEmployee = (List) map.get("masEmployee");
	}
	List<MasMinorWorkDetail> minorWorkDetailUpdateList = new ArrayList<MasMinorWorkDetail>();
	if (map.get("minorWorkDetailUpdateList") != null) {
		minorWorkDetailUpdateList = (List) map
				.get("minorWorkDetailUpdateList");
	}
	
	if(minorWorkDetailUpdateList != null && minorWorkDetailUpdateList.size()>0)
	{
		if(minorWorkDetailUpdateList.get(0).getAdminApprovalDate() != null)
		{
			adminApprovalDate = minorWorkDetailUpdateList.get(0).getAdminApprovalDate().toString();
		}
		if(minorWorkDetailUpdateList.get(0).getAdminApprovalNo() != null)
	      {
	         approvalNo = minorWorkDetailUpdateList.get(0).getAdminApprovalNo();
	      }
		if(minorWorkDetailUpdateList.get(0).getPdc() != null)
	      {
	         pdc = minorWorkDetailUpdateList.get(0).getPdc().toString();
	      }
	}
%>
<script>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>';
	</script>


<script language="JavaScript" type="text/javascript">
function est()
{
var edStartDate = document.getElementById("adminApprovalDate").value
var edDate = new Date(edStartDate.substring(6),(edStartDate.substring(3,5) - 1) ,edStartDate.substring(0,2))
var pdc = document.getElementById("pdc").value;
var calculatedDate=new Date(edDate.getTime()+pdc*24*60*60*1000*7);
if(calculatedDate.getDate().toString().length == 1)
{
var part1="0"+calculatedDate.getDate();
}else
var part1=calculatedDate.getDate();

if((calculatedDate.getMonth()+1).toString().length == 1)
{
var part2="0"+(calculatedDate.getMonth()+1);
}else
{
var part2=calculatedDate.getMonth()+1;
}
var part3=calculatedDate.getFullYear();
document.getElementById("estimatedDate").value = part1+"/"+part2+"/"+part3;
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
 function checkSubmit(){

if(confirm('Are you sure want to approve ')){
	  return true;
	  	}else
	  	{
	  	  	return false;
	  	}
	  	
} 

function submitFormNo(formName)
{
 obj = eval('document.'+formName)
 url = "/hms/hms/minorWorkDetailsApproval?method=showMinorWorkDetailsApprovalJsp";
		  	obj.action = url;
   			obj.submit();

}

function submitFormProposal(formName)
{
var id=document.getElementById('id').value;
 obj = eval('document.'+formName)
 url = "/hms/hms/approvalOfMinorWorkDetail?method=generateAdminApp&id="+id;
 		  	obj.action = url;
   			obj.submit();

}

function checkAllotmentAmount()
{
var estimatedCost = document.getElementById("estimatedCost").value
if((parseInt(<%=totalAllotmentAmount %>)-parseInt(<%=expenditureAmount%>)-parseInt(estimatedCost))<0)
{
alert("Insufficent total balance. Please alolocate more funds for Minor Works for approval");
return false;
}
else
{
var total=(parseInt(<%=totalAllotmentAmount %>)-parseInt(<%=expenditureAmount%>));
document.getElementById("total").value=total;
return true;
}
}
</script>
<div id=contentHolder>
<%if(printFlag.equalsIgnoreCase("y"))
{%> <INPUT tabindex="1" id=yes
	onClick="submitFormProposal('approvalOfMinorWorkDetail');"
	class="cmnButton" type=button value=Yes name=Yes> <INPUT
	tabindex="1" id=no onclick="submitFormNo('approvalOfMinorWorkDetail');"
	class="cmnButton" type=button value=No name=No /> <%}
	%>

<h6>Minor Work Admin Approval</h6>
<div class="Clear"></div>



<form name="approvalOfMinorWorkDetail" action="" method=post><input
	type="hidden" name="<%=POJO_NAME%>" value="MasMinorWorkDetail" /> <input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="MinorWorkDetail" />
<input type="hidden" name="title" value="Minor Work Detail Update" /> <input
	type="hidden" name="<%=JSP_NAME %>" value="approvalOfMinorWorkDetail" />
<INPUT type=hidden value="<%=id %>" id="id" />

<div class="blockFrame"><label><span>*</span>Financial
Year</label> <label class="value"><%=minorWorkDetailUpdateList.get(0).getFinancialYear()%></label>

<label><span>*</span>Minor Work No.</label> <label class="value"><%=minorWorkDetailUpdateList.get(0).getMinorWorkDetailNo()%></label>

<label><span>*</span>Minor Work Date</label> <label class="value"><%=HMSUtil.convertDateToStringWithoutTime(minorWorkDetailUpdateList.get(0).getMinorWorkDetailDate())%></label>

<div class="Clear"></div>
<label><span>*</span>Proposed By</label> <label class="value"><%=minorWorkDetailUpdateList.get(0).getWorkCategoryId()%></label>

<label><span>*</span>Work Type</label> <label class="value"><%=minorWorkDetailUpdateList.get(0).getWorkType().getWorkTypeName()%>
</label>
<div class="Clear"></div>
</div>

<div class="division"></div>

<div class="blockTitle">Work Details</div>
<div class="blockTitleCurve"></div>

<div class="blockFrame"><label><span>*</span>Details of
Work</label> <label class="value"><%=minorWorkDetailUpdateList.get(0).getMinorWorkDetail()%></label>
<label><span>*</span>Est. Cost(In Rs.)</label> <label class="value"><%=minorWorkDetailUpdateList.get(0).getMinorWorkDetailEstimatedCost()%></label>
<input id="estimatedCost" type="hidden" name="<%=ESTIMATED_COST%>"
	value="<%=minorWorkDetailUpdateList.get(0).getMinorWorkDetailEstimatedCost()%>"
	tabindex="1" />

<div class="Clear"></div>
</div>

<div class="division"></div>
<div class="blockTitle">Approval Work Detail</div>
<div class="blockTitleCurve"></div>

<div class="blockFrame"><label class="large"><span>*</span>Admin
Approval No.</label> <input id="adminApprovalName"
	name="<%=ADMIN_APPROVAL_NAME%>" value="<%=approvalNo %>" tabindex="1"
	validate="Admin Approval No,string,yes" /> <label class="large"><span>*</span>Admin
Approval Date </label> <input id="adminApprovalDate"
	validate="Admin Approval Date,date,yes" type="text"
	name="<%= ADMIN_APPROVAL_DATE %>" value="<%=adminApprovalDate %>"
	class="calDate" tabindex="1" readonly="readonly" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',document.approvalOfMinorWorkDetail.<%=ADMIN_APPROVAL_DATE%>,event)" ; />

<div class="Clear"></div>
<label class="large"><span>*</span>PDC</label> <input type="text"
	value="<%=pdc %>" name="<%=PDC%>" id="pdc" validate="PDC,int,yes"
	onchange="est();" tabindex="1"> <label class="small">weeks</label>

<label>Estimated Date</label> <input tabindex="1" type="text"
	validate="Estimated Date,date,no" id="estimatedDate" value=""
	name="<%=ESTIMATED_DATE%>" readonly="true" /></div>


<div class="division"></div>
<div class="blockTitle">Budget Status</div>
<div class="blockTitleCurve"></div>
<div class="blockFrame"><label>Total Allotment Amount</label> <input
	tabindex="1" type="text" value="<%=totalAllotmentAmount%>"
	name="<%=TOTAL_ALLOTMENT_AMOUNT%>" readonly="readonly"> <label>Total
Expenditure Amount</label> <input tabindex="1" type="text"
	value="<%=expenditureAmount %>" name="<%=TOTAL_EXPENDITURE_AMOUNT%>"
	readonly="true"> <label>Total Balance</label> <input
	tabindex="1" type="text" id="total"
	value="<%=(totalAllotmentAmount- expenditureAmount)%>"
	name="<%=TOTAL_BALANCE%>" readonly="readonly"></div>
<div class="division"></div>
<div class="blockFrame"><label class="large"><span>*</span>Admin
Remarks </label> <textarea tabindex="1" class="large" value=""
	onkeyup="chkLength(this,100);" name="<%=MINOR_WORK_REMARK%>"
	validate="Remark,string,yes"><%=minorWorkDetailUpdateList.get(0).getMinorWorkDetailRemarks()%></textarea>
</div>
<div class="division"></div>
<div class="bottom"><input tabindex="1" type="button"
	class="button" id=Save accessKey=a value=Approve name=Save
	onClick="if(checkSubmit()){submitForm('approvalOfMinorWorkDetail','approvalOfMinorWorkDetail?method=editApprovalOfMinorWorkDetail&printFlag=y','checkAllotmentAmount');}" />
<input tabindex="1" type="reset" name="Reset" class="button" id=reset
	accessKey=r onclick=resetCheck(); value=Reset /> <input type="button"
	name="back" id="back" value="Back" class="button"
	onclick="javascript:history.back()" accesskey="b" tabindex="1" />
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


