<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : responseForOpdHinNo.jsp 
	 * Tables Used         : inpatient ,patient
	 * Description         : This JSP is called thru AJAX to populate Hin Number Combo in patientPrescriptionReport.jsp
	 * @author  Create Date: 25.08.2008    Name: Mansi  
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.*"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />



<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>



<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date1.length()<2){
			date1="0"+date1;
		}
	%>
	serverdate = '<%=date1+"/"+month+"/"+year%>'
	</script>


<%	
		Map map = new HashMap();
		List<Object> yearlySerialNoList = new ArrayList<Object>();
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		
		if (map.get("yearlySerialNoList") != null)
			yearlySerialNoList =(List)map.get("yearlySerialNoList");
		
		List<OtProcedureNotesEntryHeader> patientDetailList = new ArrayList<OtProcedureNotesEntryHeader>();
		
		patientDetailList=(List)map.get("patientDetailList");
		
		if(patientDetailList!=null && patientDetailList.size()>0)
		{	OtProcedureNotesEntryHeader otProcedureNotesEntryHeader1=(OtProcedureNotesEntryHeader)patientDetailList.get(0);
			
			String patientName="";
			if(otProcedureNotesEntryHeader1.getHin().getPFirstName()!= null){
				patientName=otProcedureNotesEntryHeader1.getHin().getPFirstName();
			}
			if(otProcedureNotesEntryHeader1.getHin().getPMiddleName()!= null){
				patientName=patientName+" "+otProcedureNotesEntryHeader1.getHin().getPMiddleName();
			}
			if(otProcedureNotesEntryHeader1.getHin().getPLastName()!= null){
				patientName=patientName+" "+otProcedureNotesEntryHeader1.getHin().getPLastName();
			}
			String servicePersonName="";
			if(otProcedureNotesEntryHeader1.getHin().getSFirstName()!= null){
				servicePersonName=otProcedureNotesEntryHeader1.getHin().getSFirstName();
			}
			if(otProcedureNotesEntryHeader1.getHin().getSMiddleName()!= null){
				servicePersonName=servicePersonName+" "+otProcedureNotesEntryHeader1.getHin().getSMiddleName();
			}
			if(otProcedureNotesEntryHeader1.getHin().getSLastName()!= null){
				servicePersonName=servicePersonName+" "+otProcedureNotesEntryHeader1.getHin().getSLastName();
			}
		
%>
<div id="detailDiv">
<%for(OtProcedureNotesEntryHeader otProcedureNotesEntryHeader:patientDetailList){ %>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="header"><label>Yearly Serial No. </label> <label
	class="value"><%=otProcedureNotesEntryHeader.getYearlySerialNo()%></label>
<label>Monthly Serial No. </label> <label class="value"><%=otProcedureNotesEntryHeader.getMonthlySerialNo()%></label>
</div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<!--Block One Starts-->

<div class="blockTitle">Patient Particulars</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>
<label class="medium">Service Type</label> <%if(otProcedureNotesEntryHeader.getHin().getServiceType()!= null){ %>
<label class="valuemedium"><%=otProcedureNotesEntryHeader.getHin().getServiceType().getServiceTypeName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Service No.</label> <%if(otProcedureNotesEntryHeader.getHin().getServiceNo()!= null){ %>
<label class="valuemedium"><%=otProcedureNotesEntryHeader.getHin().getServiceNo() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium"> Serv. Status </label> <%if(otProcedureNotesEntryHeader.getHin().getServiceStatus()!= null){ %>
<label class="valuemedium"><%=otProcedureNotesEntryHeader.getHin().getServiceStatus().getServiceStatusName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Name</label> <%if(servicePersonName != null){ %> <label
	class="valuemedium"><%=servicePersonName %></label> <%}else{ %> <label
	class="valuemedium">-</label> <%} %>
<div class="Clear"></div>

<label class="medium">Relation</label> <%if(otProcedureNotesEntryHeader.getHin().getRelation() != null){ %>
<label class="valuemedium"><%=otProcedureNotesEntryHeader.getHin().getRelation().getRelationName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Rank</label> <%if(otProcedureNotesEntryHeader.getHin().getRank()!= null){ %>
<label class="valuemedium"><%=otProcedureNotesEntryHeader.getHin().getRank().getRankName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Unit</label> <%if(otProcedureNotesEntryHeader.getHin().getUnit()!= null){ %>
<label class="valuemedium"><%=otProcedureNotesEntryHeader.getHin().getUnit().getUnitName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Unit Address</label> <% if(otProcedureNotesEntryHeader.getHin().getUnit()!= null){%>
<label class="medium"><%=otProcedureNotesEntryHeader.getHin().getUnit().getUnitAddress() %></label>
<%}else{ %> <label class="medium">-</label> <%} %>
<div class="division"></div>
<div class="blockTitle">Patient Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<label class="medium">HIN No.</label> <%if(otProcedureNotesEntryHeader.getHin().getHinNo()!= null){ %>
<label class="valuemedium"><%=otProcedureNotesEntryHeader.getHin().getHinNo() %></label>
<input type="hidden" name="hinId" id="hinId"
	value="<%=otProcedureNotesEntryHeader.getHin().getId()%>" /> <%}else{ %>
<label class="valuemedium">-</label> <%} %> <label class="medium">Patient
Name. </label> <%if(patientName!= null){ %> <label class="valuemedium"><%=patientName %>
</label> <%}else{ %> <label class="valuemedium">- </label> <%} %> <label
	class="medium">Age</label> <%if(otProcedureNotesEntryHeader.getHin().getAge()!= null){ %>
<label class="valuemedium"><%=otProcedureNotesEntryHeader.getHin().getAge() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Patient Status </label> <%if(otProcedureNotesEntryHeader.getHin().getPatientStatus() != null){ %>
<label class="valuemedium"><%=otProcedureNotesEntryHeader.getHin().getPatientStatus() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %>
<div class="Clear"></div>

<label class="medium">Reg.Date </label> <%if(otProcedureNotesEntryHeader.getHin().getRegDate()!= null){ %>
<label class="valuemedium"><%=otProcedureNotesEntryHeader.getHin().getRegDate() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} 
				}
			}%>
</div>