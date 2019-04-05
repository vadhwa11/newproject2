<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : pendingResultValidationOrderNo.jsp 
	 * Tables Used         : DgSampleCollectionHeader,DgSampleCollectionDetails,MasSample,Patient,MasSubChargecode
	 * Description         : 
	 * @author  Create Date: 21.07.2008    
	   Name				   :	 Abha
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>

<%@page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.masters.business.MasSample"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%
int loginDeptId = 0;
if(session.getAttribute("deptId") != null){
	loginDeptId = (Integer)session.getAttribute("deptId");
}

%>
<form name="patientSearch" action="" method="post">
<script	type="text/javascript" language="javascript">
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
	function validateRadioForOrderNo(){
			
		for(var i = 0; i < document.getElementsByName('parent').length; i++){
			if(document.getElementsByName('parent')[i].checked == true){
				return true;
			}		
  		}
  		alert("Please select one row");
		return false;
	}
	function submitResultPrintAfterValidationForReport(orderNo){
		
/* 		var flag = validateRadioForOrderNo();
		
		var orderNo = '';
		if(flag == false){
			
			return false;
		}else{
			 */
			/* var printId = document.getElementById('printout');
			//printId.setAttribute("type","submit");
			for(var i = 0; i < document.getElementsByName('parent').length; i++){
				if(document.getElementsByName('parent')[i].checked == true){
					orderNo=document.getElementsByName('parent')[i].value;
					break;
				}		
  			}
			 */
  		//	var printId = document.getElementById('validationReportLink');
  		//	printId.setAttribute("target","_blank");
 			//document.location.href = '/hms/hms/investigation?method=printResultValidation&parent='+orderNo;
 			
 			<% if(loginDeptId == 46 ){ %>
 			submitForm('resultPrinting','/hms/hms/investigation?method=printResultValidation&orderNo='+orderNo);
 					//submitForm('resultPrinting','/hms/hms/investigation?method=printResultPrintingReport&parent='+orderNo);
 			<% }else{ %>
 			submitForm('resultPrinting','/hms/hms/investigation?method=printResultValidationLab&orderNo='+orderNo);
			//submitForm('resultPrinting','/hms/hms/investigation?method=printResultPrintingReport&parent='+orderNo);
		
			<% } %>
		//}
		
	}
	
	function submitResultPrintAfterValidation(){
		var flag = validateRadioForOrderNo();
		var orderNo = '';
		if(flag == false){
			return false;
		}else{
			var printId = document.getElementById('print');
			printId.setAttribute("type","submit");
			//for(var i = 0; i < document.getElementsByName('parent').length; i++){
			//	if(document.getElementsByName('parent')[i].checked == true){
			//		orderNo=document.getElementsByName('parent')[i].value;
			//		alert(orderNo);
			//		break;
			//	}		
  			//}
  			//var printId = document.getElementById('validationReportLink');
  			//printId.setAttribute("target","_blank");
 			//document.location.href = '/hms/hms/investigation?method=printResultValidation&parent='+orderNo;
 			<% if(loginDeptId == 49 ){ %>
 					submitForm('resultPrinting','/hms/hms/investigation?method=printResultValidation');
 			<% }else{ %>
					submitForm('resultPrinting','/hms/hms/investigation?method=printResultValidationLab');
			<% } %>
		}
		
	}
	function check(){
		<%-- var SDate = document.patientSearch.<%= FROM_DATE %>.value;
		var EDate = document.patientSearch.<%= TO_DATE %>.value;


		var endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
		var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))


		if(startDate > endDate)
		{
			alert("Please ensure that the To Date is greater than or equal to the From Date.");
			document.calldate.next_day.focus();
			return false;
		}else{
			return true;
		} --%>
		
		//alert(document.patientSearch.serviceNo.value);
		if(document.patientSearch.serviceNo.value=="")
			{
				alert("Please enter Employee No");
				return false;
			}
		else
			{
				return true;
			}
		
	}
	
	</script> <%
		Box box = HMSUtil.getBox(request);
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<DgOrderhd>orderList = new ArrayList<DgOrderhd>();
		List<MasSample>sampleList = new ArrayList<MasSample>();
		List<DgOrderhd> patientList = new ArrayList<DgOrderhd>();
//List<DgResultEntryHeader> patientList = new ArrayList<DgResultEntryHeader>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	 	String currentDate = (String) utilMap.get("currentDate");
	 	String time = (String) utilMap.get("currentTime");
		 date = (String) utilMap.get("currentDate");
	 	Date toDate  = null;
		Date fromDate=null;
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		
		if(map.get("detailsMap") !=null){
			detailsMap=(Map<String, Object>)map.get("detailsMap");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		if(patientMap.get("patientList") != null){
			patientList= (List<DgOrderhd>)patientMap.get("patientList");
		}
		String message = "";
		if(map.get("message") != null){
			message= (String)map.get("message");
		}
		if (map.get("fromDate") != null) {
	 		fromDate = (Date) map.get("fromDate");
	 		session.setAttribute("fromDate", fromDate);
	 	}
		if (map.get("toDate") != null) {
	 		toDate = (Date) map.get("toDate");
	 		session.setAttribute("toDate", toDate);
	 	}
		String userName = "";
		if(session.getAttribute("userName") != null){
		 userName = (String)session.getAttribute("userName");
		}
		if(detailsMap.get("subChargeCodeList") != null){
			subChargeCodeList = (List<MasSubChargecode>)detailsMap.get("subChargeCodeList");
			}
		if(detailsMap.get("orderList") != null){
			orderList = (List<DgOrderhd>)detailsMap.get("orderList");
			}
		if(detailsMap.get("sampleList") != null){
			sampleList = (List<MasSample>)detailsMap.get("sampleList");
			}
		if(detailsMap.get("chargeCodeList") != null){
			chargeCodeList = (List<MasChargeCode>)detailsMap.get("chargeCodeList");
			}
		if(detailsMap.get("departmentList") != null){
			departmentList = (List<MasDepartment>)detailsMap.get("departmentList");
			}
		
		List<DgResultEntryHeader> ResultValidationList = new ArrayList<DgResultEntryHeader>();
		if(detailsMap.get("ResultValidationList") != null){
			ResultValidationList = (List<DgResultEntryHeader>)detailsMap.get("ResultValidationList");
			}
		int deptId=0;
		
		if (map.get("deptId") != null) {
			deptId = (Integer) map.get("deptId");
		}
		String deptName="";
		if (map.get("deptName") != null) {
			deptName = (String) map.get("deptName");
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

<%if(deptId == 49){ %>
<div class="titleBg"><h2>Report Printing</h2></div>
<%}else{ %>
<div class="titleBg"><h2>Result Printing</h2></div>
<%} %>

<div class="Clear"></div>
<h4>Patient Search</h4>
<div class="Block">
<%-- <label> From Date </label>
<input type="text"	class="calDate" id="fromDateId" name="<%=FROM_DATE %>"	 validate="From Date,date,no"
	 MAXLENGTH="30" /> 
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.patientSearch.<%=FROM_DATE%>,event)" />

<label> To Date </label> <input type="text" id="ToDateId"
	name="<%=TO_DATE %>"  class="calDate"
	 validate="To Date,date,no" MAXLENGTH="30" /> 
	<img	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.patientSearch.<%=TO_DATE%>,event)" /> --%>
	
	<!--

<label>Order No.</label> <input type="text" name="<%=ORDER_NO %>"
	value="" MAXLENGTH="30" />
	
--><div class="Clear"></div>

<!--<label>P Type</label> <select name="<%=PATIENT_TYPE%>"
	validate="P Type,string,no">
	<option value="">Select One</option>
	<option value="IP">IP</option>
	<option value="OP">OP</option>
</select>-->
 <label> Employee No.</label> 
 <input type="text" name="<%=SERVICE_NO %>"	value="" MAXLENGTH="20" />
<%-- <label>Department Name</label>
<select id="departmentId" name="<%=DEPARTMENT_ID %>">
	<option value="0">Select</option>
	<% for(MasDepartment masDepartment : departmentList){%>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
	<%}%>
</select> 

<div class="Clear"></div>
<label> Name</label> 
<input type="text"	name="<%=S_FIRST_NAME %>" value="" MAXLENGTH="30" />
<label>Patient Name</label> 
<input type="text" name="<%=P_FIRST_NAME %>"	value="" MAXLENGTH="30" /> 
 
 <label>Modality</label> 
 <select	id="subChargeCodeId" name="<%=SUB_CHARGECODE_ID %>">
	<option value="0">Select</option>
	<%
					for(MasSubChargecode subChargecode : subChargeCodeList){
				%>
	<option value="<%=subChargecode.getId() %>"><%=subChargecode.getSubChargecodeName() %></option>
	<%}%>
</select> --%>

<!--
 <label>Hin</label>
<input type="text" name="<%=HIN_NO %>" value="" MAXLENGTH="50" />
<label>A&D No.</label> <input type="text"
	name="<%=AD_NO %>" value="" MAXLENGTH="30" />-->
<div class="Clear"></div>
	</div>
</form>

<div class="clear"></div>
<input type="button" name="submit"	onclick="submitForm('patientSearch','/hms/hms/investigation?method=searchPatientForResultValidationOrderNo','check');"	value="Search" class="button" accesskey="a" />
<input type="button" name="submit"	onclick="submitForm('patientSearch','/hms/hms/investigation?method=showResultOrderNoJsp');"	value="Today Result" class="button" accesskey="a" />
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<form name="resultPrinting" method="post" target="_blank">
<div id="searchresults" tabindex="2">
<div id="searchtable" tabindex="2"></div>
<input type="hidden" name="counta" id="counta"
	value="<%=patientList.size()%>" /> <script type="text/javascript">
	formFields = [[0, "<%=RESULT_ID%>", "id"],[1,"<%=SAMPLE_NO%>"], [2,"serNo"],[3,"patName"], [4,"relation"], [5,"rank"], [6,"deptName"], [7,"age"],[8,"sex"],[9,"subCharge"],[10,"investigationName"],[11,"<%=PATIENT_TYPE%>"],[12,"orderno"]];
	 statusTd = 12;
	</script> <!-- 	<a  target="_blank" class="cmnButton" id="validationReportLink" onclick="submitResultPrintAfterValidation();" >Print Us4444</a> -->
</div>
<div class="clear"></div>
<!-- <input type="button" name="submit" id="print"	onclick="submitResultPrintAfterValidation();" value="print"	class="button" accesskey="a" />
 -->
<%--  <%
 	if(patientList.size() > 0){
 %>
<div class="division"></div>
 <input type="button" name="html" id="printout"	onclick="submitResultPrintAfterValidationForReport();" value="HTML"	class="button" accesskey="a" />
 <!--<input type="button" name="pdf" value="PDF" class="button" id="printpdfreport" onclick="submitForm('resultPrinting','/hms/hms/investigation?method=printviewResultEntryPrintOrderNoWiseLab')"  />-->
 
 <input type="button" name="pdf" value="PDF" class="button" id="printpdfreport" onclick="submitForm('resultPrinting','/hms/hms/investigation?method=printLabReport','validateRadioForOrderNo')"  />
 <%} %> --%>
<div class="clear"></div>
</form>
<script language=javascript>

checked=false;
function checkedAll () {
	if (document.getElementById('main').checked == true) { 	 
		for (var i =0; i < parseInt(document.getElementById('count').value); i++) 
		{
	   		document.getElementById('parent'+i).checked = true;
		}
      }
     if (document.getElementById('main').checked != true) { 	 
		for (var i =0; i < parseInt(document.getElementById('count').value); i++) 
		{
	   		document.getElementById('parent'+i).checked = false;
		}
      } 
  }     
</script>

<script type="text/javascript" language="javascript">
	
	data_header = new Array();
	
	data_header[0] = new Array;
	data_header[0][0] = "";
	data_header[0][1] = "hide";
	data_header[0][2] = "7%";
	data_header[0][3] = "<%=SAMPLE_NO%>";
	
	data_header[1] = new Array;
	data_header[1][0] = "Employee No."
	data_header[1][1] = "data";
	data_header[1][2] = "15%";
	data_header[1][3] = "serNo";
	
	data_header[2] = new Array;
	data_header[2][0] = "Patient Name"
	data_header[2][1] = "data";
	data_header[2][2] = "10%";
	data_header[2][3] = "patName";
	
	data_header[3] = new Array;
	data_header[3][0] = "Relation"
	data_header[3][1] = "data";
	data_header[3][2] = "20%";
	data_header[3][3] = "relation";
	
	data_header[4] = new Array;
	data_header[4][0] = "Designation"
	data_header[4][1] = "hide";
	data_header[4][2] = "10%";
	data_header[4][3] = "rank";
	
	data_header[5] = new Array;
	data_header[5][0] = "Departrment"
	data_header[5][1] = "data";
	data_header[5][2] = "10%";
	data_header[5][3] = "deptName";
		
	data_header[6] = new Array;
	data_header[6][0] = "Age"
	data_header[6][1] = "data";
	data_header[6][2] = "10%";
	data_header[6][3] = "age";
	
	data_header[7] = new Array;
	data_header[7][0] = "Gender"
	data_header[7][1] = "data";
	data_header[7][2] = "10%";
	data_header[7][3] = "sex";

	data_header[8] = new Array;
	data_header[8][0] = "Modality"
	data_header[8][1] = "hide";
	data_header[8][2] = "10%";
	data_header[8][3] = "subCharge";
	
	data_header[9] = new Array;
	data_header[9][0] = "Investigation Name"
	data_header[9][1] = "hide";
	data_header[9][2] = "10%";
	data_header[9][3] = "investigationName";
	
	data_header[10] = new Array;
	data_header[10][0] = "Patient Type"
	data_header[10][1] = "data";
	data_header[10][2] = "10%";
	data_header[10][3] = "<%=PATIENT_TYPE%>";
	
	data_header[11] = new Array;
	data_header[11][0] = "Order Date"
	data_header[11][1] = "data";
	data_header[11][2] = "10%";
	data_header[11][3] = "orderno";
	
	data_header[12] = new Array;
	data_header[12][0] = "Report"
	data_header[12][1] = "data";
	data_header[12][2] = "10%";
	data_header[12][3] = "Report";
	data_arr = new Array();
	
	    <% int counter=0;
	   	if (patientList != null && patientList.size() > 0) { %>
	
	<% 	for(int c= 0;c< patientList.size() ;c++){
		
	DgOrderhd dgOrderhd = ((DgOrderhd)patientList.get(c)); 
	Patient patient = dgOrderhd.getHin();
		//DgResultEntryHeader dgOrderhd = ((DgResultEntryHeader)patientList.get(c)); 
		//Patient patient = dgOrderhd.getPatient();
			
	%>
				
		  		data_arr[<%= counter%>] = new Array();
		  		data_arr[<%= counter%>][0] = "<%=dgOrderhd.getId()%>";
				data_arr[<%= counter%>][1] = '<input type="radio" class="radiogrid" name="parent" value="<%=dgOrderhd.getId()%>" id="parent<%=counter%>"  />';
				
				data_arr[<%= counter%>][2] = "<%=patient.getServiceNo()%>";
				
				<%
				if(patient.getPFirstName() != null  && !(patient.getPFirstName().equals(""))){
				
				String pMiddleName = "";
				String pLastName = "";
				if(patient.getPMiddleName() != null){
					pMiddleName = patient.getPMiddleName();
				}
				if(patient.getPLastName() != null){
					pLastName = patient.getPLastName();
				}
				String pName = patient.getPFirstName()+" "+pMiddleName+" "+pLastName;
				
				%>
				data_arr[<%= counter%>][3] = "<%=pName%>"
				<%}else{%>
				data_arr[<%= counter%>][3] = "";
				<%}%>

				data_arr[<%= counter%>][4] = "<%=patient.getRelation().getRelationName()%>";
				<%-- data_arr[<%= counter%>][5] = "<%=patient.getRank()!=null ? patient.getRank().getRankName():""%>"; --%>
					
				<%try{
					
					
				%>
			
				data_arr[<%= counter%>][6] = "<%=dgOrderhd.getDepartment()!=null ? dgOrderhd.getDepartment().getDepartmentName():""%>";
		      <%if(patient != null){
		    	  if(patient.getAge() != null){
		      %>
					data_arr[<%= counter%>][7] = "<%=patient.getAge()%> ";
			  <%}}%>
			 
					
			  <%if(patient != null){
				  if(patient.getSex() != null){
				    if(patient.getSex().getAdministrativeSexName() != null){ 
			  %>
			  	data_arr[<%= counter%>][8] = "<%=patient.getSex().getAdministrativeSexName()%> ";
			  <%}}}%>
			
			
		<%--	<%if(dgOrderhd.getSubChargecode() != null){
			%>
					data_arr[<%= counter%>][9] = "<%=dgOrderhd.getSubChargecode()%> "
			<%}%>
				
			<%if(dgOrderhd.getDgMasInvestigation().getInvestigationName() != null){
			%>
			     	    data_arr[<%= counter%>][10] = "<%=dgOrderhd.getDgMasInvestigation().getInvestigationName()%> "
			<%}%>
			
			
		<%
			if(dgOrderhd.getSampleCollectionHeader().getPatientType() != null){
		%>
						data_arr[<%= counter%>][11] = "<%=dgOrderhd.getSampleCollectionHeader().getPatientType()%> "
		<%}%> --%>
		data_arr[<%= counter%>][9] = "";
		data_arr[<%= counter%>][10] = "";
		data_arr[<%= counter%>][11] = "<%=dgOrderhd.getPatientType()%>";
					
		data_arr[<%= counter%>][12] = "<%=HMSUtil.convertDateToStringWithoutTime(dgOrderhd.getOrderDate())%>";
		
		<%-- data_arr[<%= counter%>][13] = "<input type='button' name='html' id='printout'	onclick='submitResultPrintAfterValidationForReport('<%=dgOrderhd.getId()%>');' value='HTML'	class='button' accesskey='a' />"; --%>
		
		data_arr[<%= counter%>][13] ="<input type='button'  onclick=\"submitResultPrintAfterValidationForReport('<%=dgOrderhd.getId()%>');\" value='HTML'	class='button' accesskey='a' />";
		
		
  		<%}catch(Exception e){
  		e.printStackTrace();
  		}	
  			counter++;	
  	}
  }
 %>
	

    formName = "resultPrinting"
	 start = 0
    if(data_arr.length < rowsPerPage)
     end = data_arr.length;
    else
     end = rowsPerPage;
    
    makeTable(start,end);
    
    intializeHover('searchresulttable', 'TR', ' tableover');  
	</script>
<input type="hidden" name="count" id="count" value="<%=counter%>" />
