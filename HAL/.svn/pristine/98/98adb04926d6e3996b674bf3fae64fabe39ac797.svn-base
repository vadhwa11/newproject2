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


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>

<div id="contentHolder"><script type="text/javascript">
function fillAtleastOne(){
	var serviceNo = document.getElementById('serviceNo').value;
	var adNo = document.getElementById('adNo').value;
	var hinNo = document.getElementById('hinNo').value;
	var wardId = document.getElementById('wardId').value;

	if(serviceNo == "" && adNo == "" && hinNo == "" && wardId == "0"){
		alert('Fill atleast one value.');
		return false;	
	}
	return true;
		
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
	function submitFormForOrderBookingReport(){
		var flag = validateRadioForOrderNo();
		var orderNo = '';
		if(flag == false){
			return false;
		}else{
			var printId = document.getElementById('print');
			printId.setAttribute("type","submit");
			submitForm('orderNoListForOrderBookingReport','/hms/hms/lab?method=printOrderBookingReportIpdOpd');
		}
		
	}
	function fillOrderNo(printValueObj){
		document.getElementById('orderNoIdForReport').value = printValueObj.value; 
	}
		
		function clearTestDivDown(flag,id,resultType,resultStatus,confidential){
			document.getElementById('testDivDown').innerHTML = "";
			document.getElementById('testDivDown').focus();
			if(flag == 'rhLab'){
				window.open('lab?method=selectViewAccOrderStatusForConfidential&dgResultEntryHeaderLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','name','left=35,top=160,height=320,width=950,status=1,scrollbars=1,resizable=1');
			}
			if(flag == 'rdRadio'){
				window.open('lab?method=printConfidentialResultForRadiology&dgResultEntryDetailId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','name','left=100,top=160,height=420,width=820,status=1,scrollbars=1,resizable=1');
			}
			if(flag == 'rhSenLab'){
				window.open('lab?method=selectViewAccOrderStatusForConfidential&dgResultEntryHeaderSenLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','name','left=25,top=160,height=400,width=970,status=1,scrollbars=1,resizable=1');			
				//submitProtoAjaxWithDivName('orderNoListForOrderStatus','lab?method=selectViewAccOrderStatus&dgResultEntryHeaderSenLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'','testDivDown');
			}
			if(flag == 'rEntryDetailLab'){
				if(resultType == 's'){
					window.open('lab?method=selectViewAccOrderStatusForConfidential&dgResultEntryDetailLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','name','left=30,top=160,height=280,width=950,status=1,scrollbars=1,resizable=1');				
				}else{
					window.open('lab?method=selectViewAccOrderStatusForConfidential&dgResultEntryDetailLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','name','left=100,top=160,height=420,width=820,status=1,scrollbars=1,resizable=1');				
				}
			}
			if(flag == 'orderdtForLab'){
				//window.showModalDialog();
				window.open('lab?method=selectViewAccOrderStatusForConfidential&dgMasInvestigationId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','name','left=35,top=160,height=320,width=950,status=1,scrollbars=1,resizable=1');
			}
			if(flag == 'sampleDtForLab'){
				window.open('lab?method=selectViewAccOrderStatusForConfidential&dgSampleCollectionDetailLabId=='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','name','left=35,top=160,height=320,width=950,status=1,scrollbars=1,resizable=1');			
			}
			if(flag == 'sampleCollectionDtRadio'){
				window.open('lab?method=printConfidentialResultForRadiology&dgSampleCollectionDetailId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','name','left=35,top=160,height=320,width=950,status=1,scrollbars=1,resizable=1');			
			}
		}

</script>
<form name="orderBookingSearch" action="" method="post">
<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		List<MasDepartment> wardList = new ArrayList<MasDepartment>();
		Map<String, Object> orderDetailMap = new HashMap<String, Object>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		
		if(map.get("orderDetailMap") != null){
			orderDetailMap= (Map<String, Object>)map.get("orderDetailMap");
		}
		if(orderDetailMap.get("dgOrderhdList") != null){
			dgOrderhdList = (List)orderDetailMap.get("dgOrderhdList");
		}
		if(map.get("wardList") != null){
			wardList= (List<MasDepartment>)map.get("wardList");
		}
		String message = "";
		if(map.get("message") != null){
			message= (String)map.get("message");
		}
	%> <script type="text/javascript">
	<%
		if(!message.equals("")){
			%>
			var msg = "<%=message%>";
			alert(msg);
			
		<%}
	%>
	</script>

<h6>Order Request Search</h6>
<div class="Clear"></div>
<div class="blockTitle">Order Request Search</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>

<label class="bodytextB1">Service No:</label> <input type="text"
	name="<%=SERVICE_NO%>" id="serviceNo" value="" class="textbox_size20"
	MAXLENGTH="20" /> <label class="bodytextB1">A&D No</label> <input
	type="text" name="<%=AD_NO%>" id="adNo" value="" class="textbox_size20"
	MAXLENGTH="30" /> <label class="bodytextB1">Hin No</label> <input
	type="text" name="<%=HIN_NO%>" id="hinNo" value=""
	class="textbox_size20" MAXLENGTH="50" /> <label class="bodytextB1">Ward
</label> <select name="<%=WARD_ID%>" class="NewSelectBox" id="wardId">
	<option value="0"><--Select Ward--></option>
	<%
				for(MasDepartment masDepartment : wardList)
				{
				%>
	<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>
	<%
				}
				%>
</select> <br />
</div>

</form>
<br />

<input type="button" name="Search" id="addbutton"
	onclick="submitForm('orderBookingSearch','/hms/hms/lab?method=searchOrdersDetail','fillAtleastOne');"
	value="Search" class="cmnButton" accesskey="a" /></div>
<br />
<br />
<div id="contentHolder"><jsp:include page="searchResultBlock.jsp" />
<div class="division"></div>
<div id="searchresults" tabindex="2">
<div id="searchtable" tabindex="2"></div>
<form name="orderNoListForOrderBookingReport" method="post" action=""
	target="_blank"><script type="text/javascript">
	  formFields = [
			[0, "orderId", "id"],[1,"orderIdForReport"],[2,"orderNo"],[3,"orderDate"],[4,"orderTime"], [5,"orderStatus"], [6,"patName"], [7,"hin"], [8,"servNo"], [9,"serviceType"], [10,"sPersonName"], [11,"age"], [12,"sex"], [13,"pType"]];
	  statusTd = 13;
	</script> <input type="button" name="submit" id="print"
	onclick="submitFormForOrderBookingReport();" value="print"
	class="cmnButton" accesskey="a" />
</div>
<input type="hidden" name="orderNoIdForReport" id="orderNoIdForReport"
	value="" />

<div id="testDiv"></div>

</form>
</div>
<script type="text/javascript" language="javascript">
	
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = " ";
data_header[0][1] = "radio";
data_header[0][2] = "7%";
data_header[0][3] = "orderIdForReport"
	
data_header[1] = new Array;
data_header[1][0] = "Order No"
data_header[1][1] = "data";
data_header[1][2] = "7%";
data_header[1][3] = "orderNo"

data_header[2] = new Array;
data_header[2][0] = "Order Date"
data_header[2][1] = "data";
data_header[2][2] = "7%";
data_header[2][3] = "orderDate"

data_header[3] = new Array;
data_header[3][0] = "Order Time"
data_header[3][1] = "data";
data_header[3][2] = "15%";
data_header[3][3] = "orderTime";

data_header[4] = new Array;
data_header[4][0] = "Order Status"
data_header[4][1] = "data";
data_header[4][2] = "10%";
data_header[4][3] = "orderStatus"

data_header[5] = new Array;
data_header[5][0] = "Patient Name"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "patName";

data_header[6] = new Array;
data_header[6][0] = "Hin"
data_header[6][1] = "hide";
data_header[6][2] = "15%";
data_header[6][3] = "hin";

data_header[7] = new Array;
data_header[7][0] = "Service No"
data_header[7][1] = "data";
data_header[7][2] = "20%";
data_header[7][3] = "servNo";

data_header[8] = new Array;
data_header[8][0] = "Service Type"
data_header[8][1] = "data";
data_header[8][2] = "10%";
data_header[8][3] = "serviceType"

data_header[9] = new Array;
data_header[9][0] = "ServicePerson Name"
data_header[9][1] = "data";
data_header[9][2] = "15%";
data_header[9][3] = "sPersonName";

data_header[10] = new Array;
data_header[10][0] = "Age"
data_header[10][1] = "hide";
data_header[10][2] = "10%";
data_header[10][3] = "age";

data_header[11] = new Array;
data_header[11][0] = "Sex"
data_header[11][1] = "hide";
data_header[11][2] = "10%";
data_header[11][3] = "sex"

data_header[12] = new Array;
data_header[12][0] = "P Type"
data_header[12][1] = "hide";
data_header[12][2] = "10%";
data_header[12][3] = "pType"

data_arr = new Array();


	<%
	    int  counter=0;
		if (dgOrderhdList != null && dgOrderhdList.size() > 0)
		{ %>
	
	<% 	
		for(DgOrderhd dgOrderhd: dgOrderhdList){
			String flag = "";
			//Set<DgOrderdt> set = new HashSet<DgOrderdt>();
			//set = dgOrderhd.getDgOrderdts();
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
					data_arr[<%= counter%>][1] = '<input type="radio" class="radiogrid" name="parent" value="<%=dgOrderhd.getId()%>" id="parent"  onclick="fillOrderNo(this)"/>'
					data_arr[<%= counter%>][2] = "<%= dgOrderhd.getOrderNo()%>"
					data_arr[<%= counter%>][3] = "<%= HMSUtil.convertDateToStringWithoutTime(dgOrderhd.getOrderDate())%>"
					data_arr[<%= counter%>][4] = "<%= dgOrderhd.getOrderTime()%>"
					<% if(dgOrderhd.getOrderStatus().equalsIgnoreCase("P")){ %>
							data_arr[<%= counter%>][5] = 'Pending';
					<%}else if(dgOrderhd.getOrderStatus().equalsIgnoreCase("C")){%>
							data_arr[<%= counter%>][5] = 'Collected';
					<%}else if(dgOrderhd.getOrderStatus().equalsIgnoreCase("A")){%>
							data_arr[<%= counter%>][5] = 'Accepted';
					<%}%>
					
					<% if(patient.getPLastName()!=null){%>
						data_arr[<%= counter%>][6] = "<%=patient.getPFirstName()%> <%=patient.getPLastName()%>"
					<% }else {%>
						data_arr[<%= counter%>][6] = "<%=patient.getPFirstName()%>"
					<%}%>	
					data_arr[<%= counter%>][7] = "<%=patient.getHinNo()%>"
					data_arr[<%= counter%>][8] = "<%=patient.getServiceNo()%>"
					data_arr[<%= counter%>][9] = "<%=patient.getServiceType().getServiceTypeName()%> "
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
						data_arr[<%= counter%>][10] = "<%=sName%>"
						<%}else{%>
						data_arr[<%= counter%>][10] = ""
						<%}%>
						data_arr[<%= counter%>][11] = "<%=patient.getAge()%> "
						data_arr[<%= counter%>][12] = "<%=patient.getSex().getAdministrativeSexName() %> "
						data_arr[<%= counter%>][13] = "<%=dgOrderhd.getPatientType()%> "
						
					<%
				
					}catch(Exception e){
						e.printStackTrace();
					}
						     counter++;
					}
		    	}	
			//} 
		//}
%>

    formName = "orderNoListForOrderBookingReport";
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
