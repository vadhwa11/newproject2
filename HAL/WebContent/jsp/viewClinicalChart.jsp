<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * modifyMmfDepartment.jsp  
 * Purpose of the JSP -  This is for modify MMF Department.
 * @author  Dipali
 * Create Date: 4th April,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.2
--%>

<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.IpdClinicalChart"%>
<%@page import="jkt.hms.masters.business.IpdTemperature"%>
<%@page import="jkt.hms.masters.business.IpdIntakeOutputChart"%>
<script type="text/javascript" src="/hms/jsp/js/acnik.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>

<%
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	List<IpdTemperature> ipdTemperatureList= new ArrayList<IpdTemperature>();
	List<IpdIntakeOutputChart> ipdIntakeOutputChartList= new ArrayList<IpdIntakeOutputChart>();
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	String adNo="";
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<Inpatient> inPatientDetailList = new ArrayList<Inpatient>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	
	}
	String deptName="";
	if (map.get("deptName") != null) {
		deptName = (String) map.get("deptName");
	}
	if(map.get("ipdTemperatureList") !=null){
		ipdTemperatureList=(List)map.get("ipdTemperatureList");
	}
	if(map.get("ipdIntakeOutputChartList") !=null){
		ipdIntakeOutputChartList=(List)map.get("ipdIntakeOutputChartList");
	}
	try{
		inPatientDetailList=(List)map.get("inPatientDetailList");
					
}catch(Exception e){
	e.printStackTrace();
}
	
	if(map.get("inpatientList")!=null)
		inpatientList = (List) map.get("inpatientList");
	
	List<IpdClinicalChart> ipdClinicalChartList= new ArrayList<IpdClinicalChart>();
	
	if(map.get("ipdClinicalChartList")!=null)
		ipdClinicalChartList=(List) map.get("ipdClinicalChartList");
%>

<div id="contentHolder">
<h6>Clinical Chart</h6>
<div class="Clear"></div>
<form name="viewClinicalChart" method="post" action="">
<h4><%=deptName%></h4>
<div class="Clear"></div>


<div class="blockTitle">Details</div>
<div class="blockTitleCurve"></div>
<input type="hidden" name="deptName" id="deptName"
	value="<%=deptName %>" />
<div class="Clear"></div>
<div class="blockFrame">
<%	for(Inpatient inpatient : inpatientList){
					%> <label>Admission No.:</label> <label class="value"> <%=inpatient.getAdNo() %></label>

<label>Pateint Name:</label> <label class="value"> <%= inpatient.getHin().getPFirstName()%></label>

<label>Service No.:</label> <label class="value"> <%=inpatient.getHin().getServiceNo() %></label>

<label>Age:</label> <label class="value"> <%=inpatient.getHin().getAge() %></label>

<label>Sex:</label> <label class="value"> <%=inpatient.getHin().getSex().getAdministrativeSexName() %></label>
<%	}%>
</div>


</form>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<script type="text/javascript">
 
 formFields = [
    [0, "<%= CLINICAL_CHART_ID%>", "id"], [1,"clinicalDate"], [2,"clinicalTime"], [3,"<%= TEMPERATURE %>"], [4,"<%= PULSE %>"],[5,"<%= RESPIRATION %>"],[6,"<%=BP%>"],[7,"<%=BOWEL%>"],[8,"<%=PAIN%>"],[9,"<%=FHR%>"],[10,"<%=REMARKS%>"],[11,"<%=CHANGED_BY%>"],[12,"<%=CHANGED_DATE%>"],[13,"<%=CHANGED_TIME%>"]];
  statusTd = 13;
 </script></div>
<div class="Clear"></div>
<input type="button" class="button" value="Back" align="center"
	onClick="submitForm('viewClinicalChart','ipd?method=showNursingClinicalChartJsp');" />
<div class="Clear"></div>
</div>
<script type="text/javascript">
data_header = new Array();
data_header[0] = new Array;
data_header[0][0] = "Date"
data_header[0][1] = "data";
data_header[0][2] = "15%";
data_header[0][3] = "clinicalDate"

data_header[1] = new Array;
data_header[1][0] = "Time"
data_header[1][1] = "data";
data_header[1][2] = "10%";
data_header[1][3] = "clinicalTime"

data_header[2] = new Array;
data_header[2][0] = "Temperature"
data_header[2][1] = "data";
data_header[2][2] = "10%";
data_header[2][3] = "<%= TEMPERATURE %>"

data_header[3] = new Array;
data_header[3][0] = "Pulse"
data_header[3][1] = "data";
data_header[3][2] = "10%";
data_header[3][3] = "<%= PULSE %>"

data_header[4] = new Array;
data_header[4][0] = "Respiration"
data_header[4][1] = "data";
data_header[4][2] = "10%";
data_header[4][3] = "<%= RESPIRATION%>"

data_header[5] = new Array;
data_header[5][0] = "BP"
data_header[5][1] = "data";
data_header[5][2] = "10%";
data_header[5][3] = "<%= BP%>"

data_header[6] = new Array;
data_header[6][0] = "Bowel"
data_header[6][1] = "data";
data_header[6][2] = "7%";
data_header[6][3] = "<%= BOWEL %>"

data_header[7] = new Array;
data_header[7][0] = "Pain"
data_header[7][1] = "data";
data_header[7][2] = "5%";
data_header[7][3] = "<%= PAIN %>"

data_header[8] = new Array;
data_header[8][0] = "FHR"
data_header[8][1] = "data";
data_header[8][2] = "7%";
data_header[8][3] = "<%= FHR %>"

data_header[9] = new Array;
data_header[9][0] = "Remarks"
data_header[9][1] = "data";
data_header[9][2] = "40%";
data_header[9][3] = "<%= REMARKS %>"

data_header[10] = new Array;
data_header[10][0] = ""
data_header[10][1] = "hide";
data_header[10][2] = "25%";
data_header[10][3] = "<%= CHANGED_BY %>"

data_header[11] = new Array;
data_header[11][0] = ""
data_header[11][1]="hide";
data_header[11][2] = "25%";
data_header[11][3] = "<%= CHANGED_DATE %>"

data_header[12] = new Array;
data_header[12][0] = ""
data_header[12][1] = "hide";
data_header[12][2] = 0;
data_header[12][3] = "<%= CHANGED_TIME%>"
data_arr = new Array();

<%
	int  counter=0;
	for (IpdTemperature temperature : ipdTemperatureList) {
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%=temperature.getId()%>
data_arr[<%= counter%>][1] = "<%=HMSUtil.changeDateToddMMyyyy(temperature.getIpdDate()) %>"
data_arr[<%= counter%>][2] = "<%= temperature.getTime()%>"
<% if(temperature.getTemperature() != 0.0){%>
data_arr[<%= counter%>][3] = "<%=temperature.getTemperature()%>"
<%}else {%>
data_arr[<%= counter%>][3] = ""
<%}%>
<% if(temperature.getPulse() != null){%>
data_arr[<%= counter%>][4] = "<%= temperature.getPulse()%>"
<%}else {%>
data_arr[<%= counter%>][4] = ""
<%}%>
<% if(temperature.getRespiration() != null){%>
data_arr[<%= counter%>][5] = "<%= temperature.getRespiration()%>"
<%}else {%>
data_arr[<%= counter%>][5] = ""
<%}%>
<% if(temperature.getBp() != null){%>
data_arr[<%= counter%>][6] = "<%= temperature.getBp()%>"
<%}else {%>
data_arr[<%= counter%>][6] = ""
<%}%>
<% if(temperature.getBowel() != null){%>
data_arr[<%= counter%>][7] = "<%= temperature.getBowel()%>"
<%}else {%>
data_arr[<%= counter%>][7] = ""
<%}%>
<% if(temperature.getPain() != null){%>
data_arr[<%= counter%>][8] = "<%= temperature.getPain()%>"
<%}else {%>
data_arr[<%= counter%>][8] = ""
<%}%>
<% if(temperature.getFhr() != null){%>
data_arr[<%= counter%>][9] = "<%= temperature.getFhr()%>"
<%}else {%>
data_arr[<%= counter%>][9] = ""
<%}%>
<% if(temperature.getRemarks() != null){%>
data_arr[<%= counter%>][10] = "<%= temperature.getRemarks()%>"
<%}else {%>
data_arr[<%= counter%>][10] = ""
<%}%>
data_arr[<%= counter%>][11] = "<%= temperature.getLastChgBy() %>"
data_arr[<%= counter%>][12] = "<%= HMSUtil.changeDateToddMMyyyy(temperature.getLastChgDate()) %>"
data_arr[<%= counter%>][13] = "<%= temperature.getLastChgTime() %>"
<%
		     counter++;
}
%>
formName = "viewClinicalChart"
 
start = 0

if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
	makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');
</script>

