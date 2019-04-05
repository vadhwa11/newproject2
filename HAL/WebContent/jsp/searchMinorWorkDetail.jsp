<%-- 
    * Copyright 2008 JK Technosoft Ltd. All rights reserved.
    * Use is subject to license terms.
    * File Name           : searchMinorWorkDetail.jsp 
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
<%@page import="jkt.hms.masters.business.MasMinorWorkDetail"%>
<script src="/hms/jsp/js/common.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<form name="popBloodIssue" method="post" action="">
<%
   Map map = new HashMap();
   Map<String,Object> utilMap = new HashMap<String,Object>();
   List<MasMinorWorkDetail> proposalList = new ArrayList<MasMinorWorkDetail>();
   utilMap = (Map)HMSUtil.getCurrentDateAndTime();
   if(request.getAttribute("map") != null){
      map = (Map) request.getAttribute("map");
   }   
   if(map.get("minorWorkProposalList") != null){
      proposalList=(List<MasMinorWorkDetail>)map.get("minorWorkProposalList");
    
   }   
  
%>
<div id="contentHolder">
<div class="blockFrame">
<div class="tableHolderPopup">
<div
	style="overflow: scroll; overflow-x: scroll; width: 100%; height: 100%; BORDER: #202020 1px solid;">

<table width="100%" colspan="7" id="componentDetails" cellpadding="0"
	cellspacing="0">

	<thead>
		<tr>
			<th scope="col">Proposal No.</th>
			<th scope="col">Minor Work Date</th>
			<th scope="col">Minor Work No.</th>
			<th scope="col">Select</th>
		</tr>
	</thead>
	<tbody>
		<%
  int i=1;
   for(MasMinorWorkDetail stockDetail :proposalList){
 %>
		<%
        String proposalNo="";
  int proposalNoId =0;
           Date proposalDate=new Date();
           String workType="";   
           proposalNoId = stockDetail.getId();
           proposalNo=stockDetail.getProposalNo();
           proposalDate=stockDetail.getMinorWorkDetailDate();
           workType=stockDetail.getMinorWorkDetailNo();
 %>
		<tr>
			<td><input type="text" id="proposalNo<%=i %>"
				name="<%=MINOR_WORK_PROPOSAL_NO%>" value="<%=proposalNo %>"
				readonly="readonly" /></td>
			<input type="hidden" id="proposalNoId<%=i %>" name="proposalNoId"
				value="<%=proposalNoId %>" readonly="readonly" />
			</td>

			<td><input type="text" id="proposalDate<%=i %>"
				name="<%=MINOR_WORK_DATE%>"
				value="<%= HMSUtil.convertDateToStringWithoutTime( proposalDate)%>"
				readonly="readonly" /></td>
			<td><input type="text" id="workCategory<%=i %>"
				name="<%=MINOR_WORK_NO%>" value="<%=workType %>" readonly="readonly" /></td>
			<td><input type="radio" class="radio" value=""
				name="<%=SELECTED_RADIO %>"
				onclick="setBloodBagInParent(<%=i %>);   window.close();" /></td>
		</tr>
		<%i++;
     %>
		<%} %>
	</tbody>
</table>
<input type="hidden" size="2" value="" name="noOfRecords"
	id="noOfRecords" /></div>
</div>
</div>
</form>
<script>
 function cancelForm(){
         window.close();
  }
   
   function setBloodBagInParent(i){
         window.opener.document.getElementById('proposalNo').value = 
            document.getElementById('workCategory'+i).value;           
window.opener.document.getElementById('proposalNoId').value = 
            document.getElementById('proposalNoId'+i).value;     
          window.opener.document.getElementById('proposalNo').focus();
      return true;
   }
  
</script>