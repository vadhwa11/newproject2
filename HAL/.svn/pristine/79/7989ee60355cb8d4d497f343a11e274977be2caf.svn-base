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
<%@page import="jkt.hms.masters.business.Patient"%>

<%@page import="jkt.hms.masters.business.PhysioRequisitionHeader"%><script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
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
<script type="text/javascript">
		function clearTestDivDown(flag,id,resultType,resultStatus,confidential){
			document.getElementById('testDivDown').innerHTML = "";
			if(flag == 'rhLab'){
				window.open('lab?method=selectViewAccOrderStatus&dgResultEntryHeaderLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','name','left=35,top=160,height=320,width=950,status=1,scrollbars=1,resizable=1');
			}
			if(flag == 'rdRadio'){
				//window.showModalDialog('lab?method=printResultForRadiology&dgResultEntryDetailId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','dialogHeight=120,dialogWidth=120','dialogLeft=100,dialogTop=160,dialogHeight=120,dialogWidth=120,,status=2,scrollbars=1,resizable=0,center=1');
				window.open('lab?method=printResultForRadiology&dgResultEntryDetailId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','name','left=100,top=160,height=420,width=820,status=1,scrollbars=1,resizable=1');
			}
			if(flag == 'rhSenLab'){
				window.open('lab?method=selectViewAccOrderStatus&dgResultEntryHeaderSenLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','name','left=25,top=160,height=400,width=970,status=1,scrollbars=1,resizable=1');			
				//submitProtoAjaxWithDivName('orderNoListForOrderStatus','lab?method=selectViewAccOrderStatus&dgResultEntryHeaderSenLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'','testDivDown');
			}
			if(flag == 'rEntryDetailLab'){
				if(resultType == 's'){
					window.open('lab?method=selectViewAccOrderStatus&dgResultEntryDetailLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','name','left=30,top=160,height=280,width=950,status=1,scrollbars=1,resizable=1');				
				}else{
					window.open('lab?method=selectViewAccOrderStatus&dgResultEntryDetailLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','name','left=100,top=160,height=420,width=820,status=1,scrollbars=1,resizable=1');				
				}
			}
		}
	function validateRadioForOrderNo(){
			
		for(var i = 0; i < document.getElementsByName('parent').length; i++){
			if(document.getElementsByName('parent')[i].checked == true){
				return true;
			}		
  		}
  		alert("Please select one order");
		return false;
	}
	function submitResultPrintAfterValidation(){
		var flag = validateRadioForOrderNo();
		var orderNo = '';
		if(flag == false){
			return false;
		}else{
			var printId = document.getElementById('print');
			//printId.setAttribute("type","submit");
			submitForm('orderNoListForOrderStatus','/hms/hms/lab?method=printOrderStatusReport');
		}
		
	}
	function fillOrderNo(printValueObj){
		document.getElementById('orderNoIdForReport').value = printValueObj.value; 
	}
	</script>

<%
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();
		
		String userName = "";
		
		if (request.getAttribute("map") != null) {
			map = (Map<String,Object>) request.getAttribute("map");
		}

		int deptId=0;
		int inPatientId = 0;
		
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
		
		if (map.get("dgOrderhdList") != null){
			dgOrderhdList =(List)map.get("dgOrderhdList");
		}
		if (map.get("inPatientId") != null){
			inPatientId =(Integer)map.get("inPatientId");
		}
		
		String deptType ="";
		if(session.getAttribute("deptType") != null){
			deptType = (String)session.getAttribute("deptType");
		}

	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	 	String currentDate = (String) utilMap.get("currentDate");
	 	String time = (String) utilMap.get("currentTime");

	 	String dischargeSummaryFlag = "";
	 	if(map.get("flag")!=null){
	 		dischargeSummaryFlag = (String)map.get("flag");
	 	}
	 	List<PhysioRequisitionHeader> physioReqList = new ArrayList<PhysioRequisitionHeader>();
		if (map.get("physioReqList") != null){
			physioReqList =(List<PhysioRequisitionHeader>)map.get("physioReqList");
		}
	 	
	%>

<div class="Clear"></div>
<br />

<h6>Requisition Details</h6>
<div class="Clear"></div>
<h4>Investigation</h4>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div class="division"></div>
<div id="searchresults" tabindex="2">
<div id="searchtable" tabindex="2"></div></div>
<form name="orderNoListForOrderStatus" method="post" action="">
<script type="text/javascript">
	  formFields = [
			//[0, "orderId", "id"],[1,"orderIdForReport"],[2,"orderNo"],[3,"orderDate"],[4,"orderTime"], [5,"orderStatus"], [6,"patName"], [7,"hin"], [8,"servNo"], [9,"serviceType"], [10,"sPersonName"], [11,"age"], [12,"sex"], [13,"pType"]];
			[0, "orderId", "id"],[1,"orderIdForReport"],[2,"orderNo"],[3,"orderDate"],[4,"orderTime"], [5,"servNo"], [6,"rank"], [7,"sPersonName"], [8,"relation"],  [9,"patName"], [10,"hin"], [11,"sex"], [12,"pType"],[13,"dischargeSummaryFlag"]];
	  statusTd = 12;
	</script>
	

<div class="Clear"></div>	

<div id="testDiv"></div>

<!-- <div class="division"></div> 
<div class="Clear"></div>	-->
<%-- <h4>Physiotherapy</h4>
<%if(physioReqList.size()>0){ %>
<div id="reg">
<table width="100%" border="0" cellpadding="2" cellspacing="2"	class="grid_header">


	<thead>
		<tr>
			<th>Req. Date</th>
			<th>Req. Time</th>
			<th>Service No.</th>
			<th>Rank</th>
			<th>Name</th>
			<th>Relation</th>
			<th>Patient Name</th>
			
		</tr>
		<%
			
				for(PhysioRequisitionHeader physioRequisitionHeader :physioReqList){
		%>
		<tr onclick="submitProtoAjaxWithDivName('orderNoListForOrderStatus','/hms/hms/lab?method=getResponseForPhysiotherapyDetails&physioReqHeaderId=<%=physioRequisitionHeader.getId() %>','phyDiv');">
			<td><%=HMSUtil.convertDateToStringWithoutTime(physioRequisitionHeader.getReqDate()) %></td>
			<td><%=physioRequisitionHeader.getReqTime()+" "+physioRequisitionHeader.getId() %></td>
			<td><%=physioRequisitionHeader.getHin().getServiceNo()!=null?physioRequisitionHeader.getHin().getServiceNo():"" %></td>
			<td><%=physioRequisitionHeader.getHin().getRank()!=null?physioRequisitionHeader.getHin().getRank().getRankName():""%></td>
			<td><%=(physioRequisitionHeader.getHin().getSFirstName()!=null?physioRequisitionHeader.getHin().getSFirstName():"")+" "+(physioRequisitionHeader.getHin().getSMiddleName()!=null?physioRequisitionHeader.getHin().getSMiddleName():"")+" "+(physioRequisitionHeader.getHin().getSLastName()!=null?physioRequisitionHeader.getHin().getSLastName():"")%></td>
			<td><%=physioRequisitionHeader.getHin().getRelation()!=null?physioRequisitionHeader.getHin().getRelation().getRelationName():""%></td>
			<td><%=(physioRequisitionHeader.getHin().getPFirstName()!=null?physioRequisitionHeader.getHin().getPFirstName():"")+" "+(physioRequisitionHeader.getHin().getPMiddleName()!=null?physioRequisitionHeader.getHin().getPMiddleName():"")+" "+(physioRequisitionHeader.getHin().getPLastName()!=null?physioRequisitionHeader.getHin().getPLastName():"")%></td>
		</tr>	
		<%		}
			
		%>
	</thead>
	
	</table>
	<%}else{ %>
	<div class="division"></div>
	<h4>No Records Found</h4>
	<%} %>
</div> 
<div class="Clear"></div>--%>

<!-- <div class="division"></div> -->
<div id="phyDiv"></div>

<div class="Clear"></div>

<div class="division"></div>
 <input type="button" name="back" id="back"
	onclick="submitForm('orderNoListForOrderStatus','/hms/hms/ipd?method=showPatientListJsp');" value="back"
	class="button" accesskey="a" />

<div class="Clear"></div>
<input type="hidden" name="<%=INPATIENT_ID%>" id="<%=INPATIENT_ID%>"
	value="<%=inPatientId%>" /> <input type="hidden"
	name="orderNoIdForReport" id="orderNoIdForReport" value="" />
</form>



<script type="text/javascript" language="javascript">
	
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = " ";
data_header[0][1] = "data";
data_header[0][2] = "7%";
data_header[0][3] = "orderIdForReport"
	
data_header[1] = new Array;
data_header[1][0] = "Req. No."
data_header[1][1] = "data";
data_header[1][2] = "7%";
data_header[1][3] = "orderNo"

data_header[2] = new Array;
data_header[2][0] = "Req. Date"
data_header[2][1] = "data";
data_header[2][2] = "7%";
data_header[2][3] = "orderDate"

data_header[3] = new Array;
data_header[3][0] = "Req. Time"
data_header[3][1] = "data";
data_header[3][2] = "15%";
data_header[3][3] = "orderTime";

data_header[4] = new Array;
data_header[4][0] = "Service No."
data_header[4][1] = "data";
data_header[4][2] = "15%";
data_header[4][3] = "servNo";

data_header[5] = new Array;
data_header[5][0] = "Rank"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "rank";

data_header[6] = new Array;
data_header[6][0] = "Name"
data_header[6][1] = "data";
data_header[6][2] = "20%";
data_header[6][3] = "sPersonName";

data_header[7] = new Array;
data_header[7][0] = "Relation"
data_header[7][1] = "data";
data_header[7][2] = "10%";
data_header[7][3] = "relation"

data_header[8] = new Array;
data_header[8][0] = "Patient Name"
data_header[8][1] = "data";
data_header[8][2] = "15%";
data_header[8][3] = "patName";

data_header[9] = new Array;
data_header[9][0] = "hin"
data_header[9][1] = "hide";
data_header[9][2] = "10%";
data_header[9][3] = "hin";

data_header[10] = new Array;
data_header[10][0] = "Age"
data_header[10][1] = "hide";
data_header[10][2] = "10%";
data_header[10][3] = "age"

data_header[11] = new Array;
data_header[11][0] = "Sex"
data_header[11][1] = "hide";
data_header[11][2] = "10%";
data_header[11][3] = "sex"


data_header[12] = new Array;
data_header[12][0] = "dischargeSummaryFlag"
data_header[12][1] = "hide";
data_header[12][2] = "10%";
data_header[12][3] = "dischargeSummaryFlag"
data_arr = new Array();


	<%
	    int  counter=0;
		if (dgOrderhdList != null && dgOrderhdList.size() > 0)
		{ %>
	
	<% 	
		for(DgOrderhd dgOrderhd: dgOrderhdList){
			String flag = "";
			Set<DgOrderdt> set = new HashSet<DgOrderdt>();
			set = dgOrderhd.getDgOrderdts();
			//if(deptType.equalsIgnoreCase("DIAG")){ 
			//for(DgOrderdt orderDt : set){
			//	if(orderDt.getMainChargecode().getDepartment().getDepartmentType().getDepartmentTypeCode().equalsIgnoreCase("DIAG")){
			//		flag = "lab";
			//	}
			//}
			//if(flag.equals("lab")){
			     	Patient patient = dgOrderhd.getHin();
			%>
			  		data_arr[<%= counter%>] = new Array();
					data_arr[<%= counter%>][0] = <%= dgOrderhd.getId()%>
					data_arr[<%= counter%>][1] = '<input type="hidden" class="radiogrid" name="parent" value="<%=dgOrderhd.getId()%>" id="parent<%=counter%>" onclick="fillOrderNo(this)" />'
					data_arr[<%= counter%>][2] = "<%= dgOrderhd.getOrderNo()%>"
					data_arr[<%= counter%>][3] = "<%= HMSUtil.convertDateToStringWithoutTime(dgOrderhd.getOrderDate())%>"
					data_arr[<%= counter%>][4] = "<%= dgOrderhd.getOrderTime()%>"
					data_arr[<%= counter%>][5] = "<%=patient.getServiceNo()!=null?patient.getServiceNo():""%>"
					data_arr[<%= counter%>][6] = "<%=patient.getRank()!=null?patient.getRank().getRankName():""%>"
						<%   try{
							if(patient.getSFirstName() != null  && !(patient.getSFirstName().equals(""))){
								
								String sMiddleName = "";
								String sLastName = "";
								if(patient.getSMiddleName() != null){
									sMiddleName = patient.getSMiddleName();
								}
								if(patient.getSLastName() != null){
									sLastName = patient.getSLastName();
								}
								String sName = patient.getSFirstName()+" "+sMiddleName+" "+sLastName;
								
								%>
								data_arr[<%= counter%>][7] = "<%=sName%>"
								<%}else{%>
								data_arr[<%= counter%>][7] = ""
								<%}
						}catch(Exception e){
							e.printStackTrace();
						}
								%>
								
				   data_arr[<%= counter%>][8] = "<%=patient.getRelation().getRelationName()%> "
									 
									
					
					<% if(patient.getPLastName()!=null){%>
						data_arr[<%= counter%>][9] = "<%=patient.getPFirstName()%> <%=patient.getPLastName()%>"
					<% }else {%>
						data_arr[<%= counter%>][9] = "<%=patient.getPFirstName()%>"
					<%}%>	
					data_arr[<%= counter%>][10] = "<%=patient.getHinNo()%>"
					data_arr[<%= counter%>][11] = "<%=patient.getAge()%> "
					data_arr[<%= counter%>][12] = "<%=patient.getSex().getAdministrativeSexName() %> "

					data_arr[<%= counter%>][13] = "<%=dischargeSummaryFlag%>"
				
					<%
						     counter++;
					}
		    	}	
		
%>

    formName = "orderNoListForOrderStatus";
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	}
	
	makeTable(start,end);
	intializeHover('searchresulttable', 'TR', ' tableover'); 
</script>

