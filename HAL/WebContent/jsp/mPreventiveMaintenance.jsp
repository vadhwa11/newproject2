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
<%@page import="jkt.hms.masters.business.HesEquipmentAmcDetailsEntry"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.masters.business.HesEquipmentMaster"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>

<%@page import="java.util.*"%>
<script type="text/javascript" language="javascript">
	<%
		Map<String, Object> map=new HashMap<String, Object>();
		List<HesEquipmentMaster> hesEquipmentMasters=new ArrayList<HesEquipmentMaster>();
		List<HesEquipmentAmcDetailsEntry> hesEquipmentAmcDetailsEntry=new ArrayList<HesEquipmentAmcDetailsEntry>();
		if(request.getAttribute("map")!=null){
			map=(Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("hesEquipmentMasters")!=null){
			hesEquipmentMasters=(List<HesEquipmentMaster>)map.get("hesEquipmentMasters");
		}
		if(map.get("hesEquipmentAmcDetailsEntry")!=null){
			hesEquipmentAmcDetailsEntry=(List<HesEquipmentAmcDetailsEntry>)map.get("hesEquipmentAmcDetailsEntry");
		}
	
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
		
			function checkData(){
			var start= new Date(document.getElementById("fromDate").value);
			 var end= new Date(document.getElementById("toDate").value);
			 if(start<=end){
				 return true;
			 }else{alert("Date is Incorrect.");return false;}
	}
</script>
<form name="search" action="" method="post">

<div class="titleBg">
<h2>Pending List For Preventive Maintenance</h2>
</div>
<div class="Block">
<label>Item Code</label> <input type="text"	name="ItemCode" value="" MAXLENGTH="30" />
<label>Item Name</label> 
  <input type="text"	name="ItemName" value="" MAXLENGTH="30" />
	<label>Model No</label>
	 <input type="text"	name="ModelNo" value="" MAXLENGTH="30" />
<div class="clear"></div>
<input type="button" name="Search" id="addbutton"	onclick="submitForm('search', 'fm?method=showPreventiveMaintenanceJsp')"	value="Search" class="button" accesskey="a" />
<input type="button" name="Search" id="addbutton"	onclick="submitForm('search', 'fm?method=showPreventiveMaintenanceJsp&flag=all')"	value="Show All" class="button" accesskey="a" />
<div class="clear"></div>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="Block">
<%if(hesEquipmentMasters.size()>0 || hesEquipmentAmcDetailsEntry.size()>0){ 

%>
<table>
	<tr><th>S.No.</th>
	<th>Item Code</th>
	<th>Item Name</th>
	<th>Model No</th>
	<th>Serial No</th>
	<th>Manufacturer</th>
	<th>Supply Order No.</th>
	<th>Preventive Due Month</th>
	<th>Status</th>
	<th>Service Cycle</th></tr>
	<% int  counter=0; 	
	String[] monthName={"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	
	for(HesEquipmentMaster hesEquipmentMaster:hesEquipmentMasters){
			
		if(hesEquipmentMaster.getPreventiveCompletedCycle()<hesEquipmentMaster.getPreventiveCycle() ){
			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
			Date installationDate=hesEquipmentMaster.getDateOfInstallation();
			Integer preventiveCycleYearly=hesEquipmentMaster.getPreventiveCycle();
			Integer completedCycle=hesEquipmentMaster.getPreventiveCompletedCycle();
			Integer nextPreventive=12/(hesEquipmentMaster.getPreventiveCycle());
			
			int warrentyMonth = 0;
			if(hesEquipmentMaster.getWarrentyStartDate()!=null)
				warrentyMonth  = hesEquipmentMaster.getWarrentyStartDate().getMonth();
			
			
			
						String supplyOrderNo="";
			Integer month1=(Integer)installationDate.getMonth();
			nextPreventive = nextPreventive +warrentyMonth;
			Calendar now = Calendar.getInstance();
			now.setTime(installationDate);
			now.add(Calendar.MONTH, nextPreventive);
			//System.out.println("now--"+now);
			int mth = now.get(Calendar.MONTH);
			//System.out.println("mth--"+mth);
			String monthP=monthName[mth-1];
			//System.out.println(monthP);
			//System.out.println("conditions---  "+((mth-1)<=(calendar.get(Calendar.MONTH))));
			String warrantyType="Warranty";
			if("yes".equalsIgnoreCase(hesEquipmentMaster.getWarrentyStatus())){ 
			if("warranty".equalsIgnoreCase(hesEquipmentMaster.getWarrantyType())){
				warrantyType="Warranty";
			}else if("camc".equalsIgnoreCase(hesEquipmentMaster.getWarrantyType())){
				warrantyType="CAMC";
			}else if("cmc".equalsIgnoreCase(hesEquipmentMaster.getWarrantyType())){
				warrantyType="CMC";
			}else if("amc".equalsIgnoreCase(hesEquipmentMaster.getWarrantyType())){
				warrantyType="AMC";
			}
			}
			/* if((mth-1)<=(calendar.get(Calendar.MONTH))){ */
				
			/* 	if(hesEquipmentMaster.getGrnT().getGrnMaster().getPo()!=null){
				if(hesEquipmentMaster.getGrnT().getGrnMaster().getPo().getPoNumber()!=null)
					supplyOrderNo=hesEquipmentMaster.getGrnT().getGrnMaster().getPo().getPoNumber();
				} */
			//System.out.println("0000"+hesEquipmentMaster.getItem().getPvmsNo());
	%>
	<form name="mPreventiveMaintenance<%=counter %>" method="post">
	<input type="hidden" name="requestId" value="<%= hesEquipmentMaster.getId()%>" />
	<input type="hidden" name="requestType" value="Preventive" />
	<tr onclick="submitForm('mPreventiveMaintenance<%=counter %>', 'fm?method=showCreateServiceRequestDetails')" style="cursor: pointer;">
	  		<td><%= counter+1%></td>
			<td><%= hesEquipmentMaster.getItem().getPvmsNo()%></td>
			<td><%= hesEquipmentMaster.getItem().getNomenclature()%></td>
			<td><%= hesEquipmentMaster.getModelName()%></td>
			<td><%= hesEquipmentMaster.getSerialNo()%></td>
			<td><%= hesEquipmentMaster.getManufacturer()!=null?hesEquipmentMaster.getManufacturer().getManufacturerName():""%></td>
		    <td><%= supplyOrderNo%></td>
		    <td><%= monthP %></td>
		    <td><%=warrantyType %></td>
		    <td><%= hesEquipmentMaster.getPreventiveCompletedCycle()+"/"+hesEquipmentMaster.getPreventiveCycle()%></td>
	</tr>
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	
	</form>
<%		++counter;
				/* } */
		}
		}
	%>
	
	
	<%
	for(HesEquipmentAmcDetailsEntry hesEquipmentAMC:hesEquipmentAmcDetailsEntry){
		if(hesEquipmentAMC.getPreventiveCompletedCycle()<hesEquipmentAMC.getPreventiveCycle() ){
			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
			Date installationDate=hesEquipmentAMC.getAmcWarrentyStartDate();
			Integer preventiveCycleYearly=hesEquipmentAMC.getPreventiveCycle();
			Integer completedCycle=hesEquipmentAMC.getPreventiveCompletedCycle();
			Integer nextPreventive=12/(hesEquipmentAMC.getPreventiveCycle());
			String supplyOrderNo="";
			Integer month1=(Integer)installationDate.getMonth();
			String monthP=monthName[(month1+nextPreventive)-1];
			if((month1+nextPreventive-1)<=(calendar.get(Calendar.MONTH))){
			if(hesEquipmentAMC.getEpuipment().getGrnT().getGrnMaster().getPo()!=null){
			if(hesEquipmentAMC.getEpuipment().getGrnT().getGrnMaster().getPo().getPoNumber()!=null)
				supplyOrderNo=hesEquipmentAMC.getEpuipment().getGrnT().getGrnMaster().getPo().getPoNumber();
			}
	%>
	<form name="mPreventiveMaintenance<%=counter %>" method="post">
	<input type="hidden" name="requestId" value="<%= hesEquipmentAMC.getEpuipment().getId()%>" />
	<input type="hidden" name="requestType" value="Preventive" />
	<tr onclick="submitForm('mPreventiveMaintenance<%=counter %>', 'fm?method=showCreateServiceRequestDetails')">
	  		<td><%= counter+1%></td>
			<td><%= hesEquipmentAMC.getEpuipment().getItem().getPvmsNo()%></td>
			<td><%= hesEquipmentAMC.getEpuipment().getItem().getNomenclature()%></td>
			<td><%= hesEquipmentAMC.getEpuipment().getModelName()%></td>
			<td><%= hesEquipmentAMC.getEpuipment().getSerialNo()%></td>
			<td><%= hesEquipmentAMC.getEpuipment().getManufacturer().getManufacturerName()%></td>
		    <td><%= supplyOrderNo%></td>
		    <td><%= monthP %></td>
		    <td>AMC</td>
		    <td><%= hesEquipmentAMC.getPreventiveCompletedCycle()+"/"+hesEquipmentAMC.getPreventiveCycle()%></td>
	</tr>
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	
	</form>
<%		++counter;
				}
		}
		}
	%>
	
</table>
<%}else{ %>
No Records Available.
<%} %>
</div>
