<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : patientDischargeSearch.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 07.03.2008    Name: Ritu
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MmServiceRequest"%>
<%@page import="jkt.hms.masters.business.MasPriorityCodes"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>

<script type="text/javascript" language="javascript">
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
		String userName = "";
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
			String currentDate = (String)utilMap.get("currentDate");  
			String currentTime = (String)utilMap.get("currentTime");
			if(session.getAttribute("userName") != null){
				userName = (String)session.getAttribute("userName");
			}
		Map<String, Object> map=new HashMap<String, Object>();
		List<MmServiceRequest> mmServiceRequest= new ArrayList<MmServiceRequest>();
		List<MasPriorityCodes> priority=new ArrayList<MasPriorityCodes>();
		if(request.getAttribute("map")!=null){
			map=(Map<String ,Object>)request.getAttribute("map");
		}if(map.get("mmServiceRequest")!=null){
			mmServiceRequest=(List<MmServiceRequest>)map.get("mmServiceRequest");
		}if (map.get("priority")!= null){
			priority = (List<MasPriorityCodes>)map.get("priority");
		}
		
		String CurrentDate=date+"/"+month+"/"+year;
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
		
	function checkData(){
			var start= new Date(document.getElementById("fromDate").value.split("/")[2], document.getElementById("fromDate").value.split("/")[1], document.getElementById("fromDate").value.split("/")[0]);
			 var end= new Date(document.getElementById("toDate").value.split("/")[2], document.getElementById("toDate").value.split("/")[1], document.getElementById("toDate").value.split("/")[0]);
			 if(start<=end){
				 return true;
			 }else{alert("Date is Incorrect.");return false;}
		}
</script>

<form name="search" action="" method="post">
<%  String message="";
	if(map.get("msg")!=null){
		message=(String)map.get("msg");
		out.print(message);
	} 
	%>
<div class="titleBg">
<h2>Pending List For Approval</h2>
</div>
<div class="Block">
 <label><span>* </span>From Date</label> 
 <input id="fromDate" class="date" type="text" maxlength="30" readonly="readonly" value="<%=CurrentDate %>" name="fromDate" validate="From Date,date,yes">
<img width="16" height="16" border="0" onclick="javascript:setdate('',document.search.fromDate,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif"> 
	<label><span>* </span>To Date</label>
	 <input id="toDate" class="date" type="text" maxlength="30" readonly="readonly" value="<%=CurrentDate %>" name="toDate" validate="To Date,date,yes">
<img width="16" height="16" border="0" onclick="javascript:setdate('',document.search.toDate,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif">
	 <label>Request No</label> <input type="text"	name="requestId" value="" MAXLENGTH="30" id="adNo" validate="Request No,alphanumeric,no"/>
<div class="clear"></div>
	<label>Item Code</label>
	 <input type="text"	name="itemCode" value="" MAXLENGTH="30" id="adNo" validate="Item code,alphanumeric,no" />
	 <label>Priority</label> <select name="priority">
	 <option value="">Select</option>
	 <%for(MasPriorityCodes pr:priority){ %>
	 <option value="<%=pr.getId()%>"><%=pr.getCodesName()%></option>
	 <%} %>
	 </select>
	 <label>Item Name</label>
	  <input type="text"	name="itemCode" value="" MAXLENGTH="30" id="adNo" validate="Item Name,alphanumeric,no"/>
<div class="clear"></div>
<input type="button" name="Search" id="addbutton"	onclick="if(checkData()){submitForm('search','fm?method=showPendingListForApprovalJsp');}"	value="Search" class="button"  />
<input type="button" name="Search" id="addbutton"	onclick="submitForm('search','fm?method=showAllPendingListForApprovalJsp')"	value="Show All" class="button"  />
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="Block">
<%if(mmServiceRequest.size()>0){ %>
<table>
	<tr><th>S.No</th><th>Request Date</th><th>Request No</th><th>Item Code</th><th>Item Name</th><th>Priority</th><th>Request By</th><th>Requested From</th></tr>

	<% 
		 int  counter=0;
		for(MmServiceRequest object:mmServiceRequest){
	%>
			<form name="servicRequest<%= counter+1%>" method="post"><input type="hidden" name="requestId" value="<%=object.getId() %>" />
			<tr onclick="submitForm('servicRequest<%= counter+1%>', 'fm?method=serviceRequest')" style="cursor: pointer;"><td><%= counter+1%></td>
			<td><%= HMSUtil.changeDateToddMMyyyy(object.getRequestDate())%></td>
			<td><%= object.getServiceRequestNo()%></td>
			<td><%= object.getEquipment().getItem().getPvmsNo()%></td>
		    <td><%= object.getEquipment().getItem().getNomenclature()%></td>
		    <td><%= object.getPriority().getCodesName()%></td>
		    <td><%= object.getLastChgBy().getEmployee().getFirstName()%></td>
		    <td><%= object.getEquipment().getDepartment().getDepartmentName()%></td></tr>
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		    </form>
<%		++counter;
				}
	%>
	</table>
	<%}else{ %>
	No Records Available.
	<%} %>
	</div>
 <div class="clear"></div>
	<div class="bottom">
		<label>Changed By:</label>
		<label class="value"><%=userName%></label>
		<label>Changed Date:</label>
		<label class="value"><%=currentDate%></label>
		<label>Changed Time:</label>
		<label class="value"><%=currentTime%></label>
	</div>
	<div class="clear"></div>
	<div class="bottom">
	<input type="hidden" name="lastChgBy" value="<%=userName%>" />
	<input type="hidden" name="lastChgDate" value="<%=currentDate%>" /> 
	<input type="hidden" name="lastChgTime" value="<%=currentTime%>" /> 
	</div>
	
	