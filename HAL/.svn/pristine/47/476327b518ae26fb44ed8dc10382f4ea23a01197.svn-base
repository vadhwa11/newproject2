<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : orderStatusForWardManagment.jsp 
	 * Tables Used         : 
	 * Description         : For Viewing All Order No For IPD .
	 * @author Name        : Naresh Kumar
	 * Revision Date	   : Revision By: 
	 * @version 1.0  
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetailSen"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<%@page import="jkt.hms.masters.business.Patient"%><script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/phase2/wysiwyg.js"></script>
<script type="text/javascript" src="/hms/jsp/js/phase2/wysiwyg-color.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/wysiwyg-settings.js"></script>


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
			
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script>
<%
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> orderDetailMap = new HashMap<String,Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();

		List<DgOrderdt> orderdtList = new ArrayList<DgOrderdt>();
		List<DgMasInvestigation> dgMasInvestigationList = new ArrayList<DgMasInvestigation>();
		
		List<Patient> patientList = new ArrayList<Patient>();
			
		DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();
		DgOrderdt dgOrderdt = new DgOrderdt();
		
		String userName = "";
		if (request.getAttribute("map") != null) {
			map = (Map<String,Object>) request.getAttribute("map");
		}

		int deptId=0;
		if(session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}

		String deptName="";
		if (map.get("deptName") != null) {
			deptName = (String) map.get("deptName");
		}
		if(session.getAttribute("userName") != null){
			 userName = (String)session.getAttribute("userName");
		}
		
		if (map.get("orderDetailMap") != null){
			orderDetailMap =(Map)map.get("orderDetailMap");
		}
		if (orderDetailMap.get("dgOrderdtList") != null){
			orderdtList =(List)orderDetailMap.get("dgOrderdtList");
		}
		if (orderDetailMap.get("dgMasInvestigationList") != null){
			dgMasInvestigationList = (List)orderDetailMap.get("dgMasInvestigationList");
		}
		
		if (orderDetailMap.get("patientList") != null){
			patientList =(List)orderDetailMap.get("patientList");
		}
		String deptType ="";
		Integer totalSize = 0;
		Integer initHieght = 60;
		
		if(session.getAttribute("deptType") != null){
			deptType = (String)session.getAttribute("deptType");
		}
		if(orderdtList!=null ){
			totalSize = totalSize + orderdtList.size();
		}

		
		for(int i=1 ;i<=totalSize-1 ;i++){
			initHieght = initHieght + 20;
		}
		
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	 	String currentDate = (String) utilMap.get("currentDate");
	 	String time = (String) utilMap.get("currentTime");
	 	Patient patient = new Patient();
	 	System.out.println("orderdtList==="+orderdtList.size());
	 	if(patientList.size()>0){
	 		patient = patientList.get(0);
		 	
	 	}
	 	

	%>
<div class="clear"></div>
	<h4>Patient Details</h4>
	<div class="clear"></div>
<div class="Block">
<label>Service No.</label>
 <%
 	if (patient.getServiceNo() != null) {
 %>
<label class="value"><%=patient.getServiceNo()%></label>
 <%
 	} else {
 %>
<label class="value">&nbsp;</label><%
	}
%>
<label>Patient Name</label>
 <%
 	if (patient.getPFirstName() != null) {
 			String mname = "";
 			String lname = "";
 			String fname = patient.getPFirstName();
 			if (patient.getPMiddleName() != null)
 				mname = patient.getPMiddleName();
 			if (patient.getPLastName() != null)
 				lname = patient.getPLastName();
 %>
<label class="value"><%=fname + mname + lname%></label>
 <%
 	} else {
 %>
<label class="value">&nbsp;</label><%
	}
%>
<label>Relation</label>
 <%
 	if (patient.getRelation() != null) {
 %>
<label class="value"><%=patient.getRelation().getRelationName()%></label>
 <%
 	} else {
 %>
<label class="value">&nbsp;</label><%
	}
%>


<div class="clear"></div>
<label >Rank</label>
<%
	if (patient.getRank() != null) {
%>
<label class="value"><%=patient.getRank().getRankName()%></label>
<%
	} else {
%> <label class="value">&nbsp;</label><%
 	}
 %>
<label>Name</label> 
<%
 	if (patient != null) {
 			
 			if (patient.getSFirstName() != null
 					&& !(patient.getSFirstName().equals(""))) {

 				String sMiddleName = "";
 				String sLastName = "";
 				if (patient.getSMiddleName() != null) {
 					sMiddleName = patient.getSMiddleName();
 				}
 				if (patient.getSLastName() != null) {
 					sLastName = patient.getSLastName();
 				}
 %> <label
	class="value"><%=patient.getSFirstName() + " " + sMiddleName
								+ " " + sLastName%></label> <%
 	}
 		} else {
 %> <label class="value"></label>
<%
	}
%>
<label>Unit</label>
 <%
 	if (patient.getUnit() != null) {
 %>
<label class="value"><%=patient.getUnit().getUnitName()%></label>
<%
	} else {
%> <label class="value">&nbsp;</label><%
 	}
 %>
<div class="clear"></div>
<label >Age</label> 
<%
 	if (patient.getAge() != null) {
 %>
<label class="value"><%=patient.getAge()%></label> 
<%
 	} else {
 %>
<label class="value">&nbsp;</label><%
	}
%>


 <label>Gender</label>
 <%
 	if (patient.getSex() != null) {
 %>
<label class="value"><%=patient.getSex()
							.getAdministrativeSexName()%></label>
<%
	} else {
%> <label class="value">&nbsp;</label><%
 	}
 %>

<table width="100%" border="0" cellpadding="2" cellspacing="2"	class="grid_header">

	<thead>
		<tr>
			<th>Investigation Name</th>
			<th>Result</th>
			<th>UOM</th>
			<th>Normal Range</th>
			<th>Investigation Status</th>
		</tr>
	</thead>
	<tbody>
		<%
			boolean orderDtEmpty = true;
 			boolean dgSampleCollectionDtEmpty = true;
 			boolean dgResultDtEmpty = true;
 			boolean dgResultDtEmptyLab = true;
 			boolean dgSampleCollectionDtLabEmpty = true;
		if (orderdtList != null && orderdtList.size() > 0 
				&& dgMasInvestigationList!=null && dgMasInvestigationList.size()>0)
		{ %>

		<%
  			orderDtEmpty = false;
		Iterator<DgOrderdt> dgOrderdtIt = orderdtList.iterator();
		Iterator<DgMasInvestigation> dgMasInvestigationIt = dgMasInvestigationList.iterator();
		while(dgMasInvestigationIt.hasNext() && dgOrderdtIt.hasNext()){
			dgMasInvestigation = dgMasInvestigationIt.next();
			dgOrderdt = dgOrderdtIt.next();

			%>

			<tr>
			<td><%= dgMasInvestigation.getInvestigationName()%></td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<% if(dgOrderdt.getOrderStatus().equalsIgnoreCase("P")){ %>
			<td>Pending</td>
			<%}else if(dgOrderdt.getOrderStatus().equalsIgnoreCase("C")){%>
			<td>Sample Collected</td>
			<%}else if(dgOrderdt.getOrderStatus().equalsIgnoreCase("A")){%>
			<td>Sample Accepted</td>
			<%}else if(dgOrderdt.getOrderStatus().equalsIgnoreCase("X")){%>
			<td>Test Cancelled</td>
			<%} %>
		</tr>

		<%} %>

		<%}else{ %>
		<tr>
								<td>No Data Exist</td>
							</tr>
							<%} %>
						
	</tbody>
</table>

</div>






