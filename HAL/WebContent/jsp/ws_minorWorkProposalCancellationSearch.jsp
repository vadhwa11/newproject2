<%-- 
    * Copyright 2008 JK Technosoft Ltd. All rights reserved.
    * Use is subject to license terms.
    * File Name           : minorWorkProposalCancellationSearch.jsp 
    * Tables Used         : 
    * Description         : 
    * @author  Create Date: 08.07.2009    Name: Vineet Kumar
    * Revision Date:      Revision By: 
    * @version 1.0  
    
--%>
<%@page import="jkt.hms.masters.business.BloodStockDetail"%>
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasMinorWorkProposal"%>
<%@page import="jkt.hms.masters.business.MasDepartmentType"%>
<%@page import="jkt.hms.masters.business.MasWorkType"%>
<script src="/hms/jsp/js/common.js" type="text/javascript"></script>
<script src="/hms/jsp/js/calendar.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />

<%
   Map map = new HashMap();
   Map<String,Object> utilMap = new HashMap<String,Object>();
   List<MasMinorWorkProposal> proposalList = new ArrayList<MasMinorWorkProposal>();
   List<MasWorkType> masWorkTypelList = null;
   utilMap = (Map)HMSUtil.getCurrentDateAndTime();
   if(request.getAttribute("map") != null){
      map = (Map) request.getAttribute("map");
   }   
   if(map.get("minorWorkProposalList") != null){
      proposalList=(List<MasMinorWorkProposal>)map.get("minorWorkProposalList");
    
   }  
   if(map.get("masWorkTypelList") != null){
	   masWorkTypelList=(List<MasWorkType>)map.get("masWorkTypelList");
	    
	   }
  
%>
<script>
<%

	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(date.length()<2){
		date="0"+date;
	}
%>
	serverdate = '<%=date+"/"+month+"/"+year%>'
</script>
<div id="contentHolder">
<form name="popBloodIssue" method="post" action="">
<div class="blockTitle">Proposal Search</div><div class="blockTitleCurve"></div>
		<div class="Clear"></div>
		   <div class="blockFrameSm">
		   <label>From Date :-</label>
		   <INPUT tabindex="1" readonly="readonly" value="" name="<%=MINOR_WORK_FROM_DATE %>"  /> 
		   <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',document.popBloodIssue.<%=MINOR_WORK_FROM_DATE%>,event)" ; />
		   <label>To Date :-</label>
		   <INPUT tabindex="1" readonly="readonly" value="" name="<%=MINOR_WORK_TO_DATE %>"  /> 
		   <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',document.popBloodIssue.<%=MINOR_WORK_TO_DATE%>,event)" ; />   
		   <div class="Clear"></div>
		   <label>Work Type</label>
		   <select name="workType">
		   <option value="">Select</option>
		   <%for(MasWorkType masWorkType :masWorkTypelList){ %>
		   <option value="<%=masWorkType.getId()%>"><%=masWorkType.getWorkTypeName() %></option>
		   <%} %>
		   </select> 
		   <div class="Clear"></div>  
		<label>Detail Of Work </label> 
		<input type="text" name="detailDescribtion" value="" />
		<input type="button" name="Submit" id="addbutton" onClick="search();" value="Search" class="button" accesskey="a" />
		<input type="hidden" name="SearchFlag" value="true"/>
 </div>

<div class="tableHolderPopup" style="width:900px;">
<div
	style="overflow: scroll; overflow-x: scroll; width: 100%; height: 100%; BORDER: #202020 1px solid;">
<table width="100%" colspan="7" id="componentDetails" cellpadding="0"
	cellspacing="0">

	<thead>
		<tr>
			<th scope="col">Proposal No.</th>
			<th scope="col">Proposal Date</th>
			<th scope="col">Work Type</th>
			<th scope="col">Select</th>
		</tr>
	</thead>
	<tbody>
		<%
  int i=1;
   for(MasMinorWorkProposal stockDetail :proposalList){
	   if(stockDetail.getWorkType().getWorkCategory().getWorkCategoryName().equalsIgnoreCase("Minor Work"))
	   {
 %>
		<%
        String proposalNo="";
  int proposalNoId =0;
        Date proposalDate=new Date();
        String workType="";   
            proposalNoId = stockDetail.getId();
           proposalNo=stockDetail.getMinorWorkProposalNo();
           proposalDate=stockDetail.getMinorWorkProposalDate();
           workType=stockDetail.getWorkType().getWorkTypeName();
 %>
		<tr>
			<td><input type="text" id="proposalNo<%=i %>"
				name="<%=MINOR_WORK_PROPOSAL_NO%>" value="<%=proposalNo %>"
				readonly="readonly" /></td>
			<input type="hidden" id="proposalNoId<%=i %>" name="proposalNoId"
				value="<%=proposalNoId %>" readonly="readonly" />
			</td>

			<td><input type="text" id="proposalDate<%=i %>"
				name="<%=MINOR_WORK_PROPOSAL_DATE%>"
				value="<%= HMSUtil.convertDateToStringWithoutTime( proposalDate)%>"
				readonly="readonly" /></td>
			<td><input type="text" id="workCategory<%=i %>"
				name="<%=MINOR_WORK_CATEGORY_ID%>" value="<%=workType %>"
				readonly="readonly" /></td>
			<td><input type="radio" class="radio" value=""
				name="<%=SELECTED_RADIO %>"
				onclick="setBloodBagInParent(<%=i %>);   window.close();" /></td>
		</tr>
		<%i++;
     %>
		<%}} %>
	</tbody>
</table>
<input type="hidden" size="2" value="" name="noOfRecords"
	id="noOfRecords" /></div>
</div>

</form>
</div>

<script>
 function cancelForm(){
         window.close();
  }
   
   function setBloodBagInParent(i){
         window.opener.document.getElementById('proposalNo').value = 
            document.getElementById('proposalNo'+i).value;           
window.opener.document.getElementById('proposalNoId').value = 
            document.getElementById('proposalNoId'+i).value;     
          window.opener.document.getElementById('proposalNo').focus();
      return true;
   }
 function search()
	{
	if (popBloodIssue.minorWorkFromDate.value=="" && popBloodIssue.minorWorkToDate.value=="" && popBloodIssue.workType.value=="" && popBloodIssue.detailDescribtion.value=="" )
    {
    	alert("Pl. fill any field..... ");
    	return;
    }
    else
	{
		submitForm('popBloodIssue','minorWorkProposal?method=showPopUpProposalJsp');
	}
	}  
</script>