
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>

<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<!-- <META HTTP-EQUIV="REFRESH" CONTENT="20"> -->
<script type="text/javascript">
	<!--
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
	// -->
	</script>
<%
	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	List<MasMedicalExaminationReportOnEntry> medicalExamdetail = new ArrayList<MasMedicalExaminationReportOnEntry>();
	if (map.get("patientDetailList") != null) {
		medicalExamdetail = (List) map.get("patientDetailList");
	}
	int totalPatient=0;
if(medicalExamdetail!=null && medicalExamdetail.size()>0)
{
	totalPatient=medicalExamdetail.size();
}
	String userName = "";
	if (session.getAttribute("userName") != null) {
	userName = (String) session.getAttribute("userName");
	}
	int deptId=0;
	if (map.get("deptId") != null) {
	deptId = (Integer) map.get("deptId");
	}
	String deptName="";
	if (map.get("deptName") != null) {
	deptName = (String) map.get("deptName");
	}
	%>

<div class="titleBg">
<h2>Current Med Board Status</h2>
</div>
<div class="clear"></div><!--

<div class="search" id="threadsearch"><a href=""></a> <script
	type="text/javascript"> vbmenu_register("threadsearch"); </script></div>
<div class="clear"></div>
 thread search menu 
<div class="searchBlock" id="threadsearch_menu" style="display: none;">
<div class="clear"></div>
<form name="search" action="" method="post">
<label>HIN Number </label>
<input type="text" name="<%= RequestConstants.HIN_NO %>" id="hinNo"	MAXLENGTH="30" tabindex=1 />
<input type="hidden" name="deptName" id="deptName" value="<%=deptName %>" />
<input type="hidden" name="date" id="date" value="<%=date %>" />
<div class="clear"></div>
<label>Patient First Name  </label>
<input type="text"	name="<%= RequestConstants.P_FIRST_NAME %>" id="patientFName"	MAXLENGTH="30" tabindex=1 />
<label>Patient Middle Name </label>
<input type="text"	name="<%= RequestConstants.P_MIDDLE_NAME %>" id="patientMName"	MAXLENGTH="30" tabindex=1 />
<div class="clear"></div>
<label>Patient Last Name </label>
<input	type="text" name="<%= RequestConstants.P_LAST_NAME %>"	id="pateintLName" MAXLENGTH="30" tabindex=1 />
<input type="button" onClick="submitForm('search','opd?method=searchWaitingPatientListJsp&filter=true');" class="button" /></form>
</div>

--><%
if(map.get("message") != null){
	String message = (String)map.get("message");%>
	<h4><span><%=message %></span></h4>
	<%} %>
<form name="pendingClwatingList123" method="post" action="">
<div class="clear"></div>

<div class="floatRight"><label class="auto">Total Waiting Patient : </label>
<label	class="valueAuto"><%=totalPatient%></label>
</div>
<div class="clear"></div>

</form>
<div class="clear"></div>

<div class="floatRight">
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="test">
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<script type="text/javascript" language="javascript">

	formFields = [
	[0, "<%= RequestConstants.HIN_ID%>", "id"],[1, "<%= RequestConstants.RADIO_FOR_TABLE%>"], [2,"<%= RequestConstants.VISIT_NUMBER %>"], [3,"<%= RequestConstants.VISIT_DATE %>"],[4,"<%= RequestConstants.VISIT_TIME %>"],[5,"<%= RequestConstants.HIN_NO %>"],[6,"<%=RequestConstants.SERVICE_NO%>"],[7,"<%= RequestConstants.RANK_NAME %>"],[8,"<%=RequestConstants.PATIENT_NAME%>"],[9,"<%=RequestConstants.UNIT%>"]];
	statusTd =12;

	</script></div>

<div id="edited"></div>
<label>&nbsp;</label>
<div id="statusMessage"></div>
</div>
</div>
<script type="text/javascript">
data_header = new Array();
data_header[0] = new Array;
data_header[0][0] = "Service No.";
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "<%= SERVICE_NO %>";

data_header[1] = new Array;
data_header[1][0] = "Rank";
data_header[1][1] = "data";
data_header[1][2] = "15%";
data_header[1][3] = "<%= RANK %>";

data_header[2] = new Array;
data_header[2][0] = "Name";
data_header[2][1] = "data";
data_header[2][2] = "15%";
data_header[2][3] = "<%=FULL_NAME%>";

data_header[3] = new Array;
data_header[3][0] = " Unit  "
data_header[3][1] = "data";
data_header[3][2] = "20%";
data_header[3][3] = "<%=UNIT %>";

data_header[4] = new Array;
data_header[4][0] = "Last Medical Exam";
data_header[4][1] = "hide";
data_header[4][2] = "15%";
data_header[4][3] = "<%= RANK_ID %>";

data_header[5] = new Array;
data_header[5][0] = "Medical Exam Type"
data_header[5][1] = "data";
data_header[5][2] = "0%";
data_header[5][3] = "<%=STATUS %>";
data_header[6] = new Array;
data_header[6][0] = "Date Repoted"
data_header[6][1] = "data";
data_header[6][2] = "0%";
data_header[6][3] = "<%=STATUS %>";
data_header[7] = new Array;
data_header[7][0] = "Contact No"
data_header[7][1] = "hide";
data_header[7][2] = "0%";
data_header[7][3] = "<%=STATUS %>";

data_header[8] = new Array;
data_header[8][0] = "visitId"
data_header[8][1] = "hide";
data_header[8][2] = "0%";
data_header[8][3] = "visitId";

data_header[9] = new Array;
data_header[9][0] = "medical Exam Type"
data_header[9][1] = "hide";
data_header[9][2] = "0%";
data_header[9][3] = "medExamType"; 

data_header[10] = new Array;
data_header[10][0] = "Investigated"
data_header[10][1] = "data";
data_header[10][2] = "0%";
data_header[10][3] = "medExamIdForUpdate";  

data_header[11] = new Array;
data_header[11][0] = "Mo Date"
data_header[11][1] = "hide";
data_header[11][2] = "0%";
data_header[11][3] = "medExamIdForUpdate";  

data_header[12] = new Array;
data_header[12][0] = "Completed By Med Asst"
data_header[12][1] = "data";
data_header[12][2] = "0%";
data_header[12][3] = "medExamIdForUpdate";  

data_header[13] = new Array;
data_header[13][0] = "Validated By MO"
data_header[13][1] = "data";
data_header[13][2] = "0%";
data_header[13][3] = "medExamIdForUpdate";  

data_header[14] = new Array;
data_header[14][0] = "validated Date"
data_header[14][1] = "hide";
data_header[14][2] = "0%";
data_header[14][3] = "medExamIdForUpdate";

data_header[15] = new Array;
data_header[15][0] = "Approved By"
data_header[15][1] = "hide";
data_header[15][2] = "0%";
data_header[15][3] = "medExamIdForUpdate";

data_header[16] = new Array;
data_header[16][0] = "Send To"
data_header[16][1] = "hide";
data_header[16][2] = "0%";
data_header[16][3] = "medExamIdForUpdate";

data_header[17] = new Array;
data_header[17][0] = "Approved At Command"
data_header[17][1] = "data";
data_header[17][2] = "0%";
data_header[17][3] = "medExamIdForUpdate";

data_header[18] = new Array;
data_header[18][0] = "Approved At AFRO"
data_header[18][1] = "data";
data_header[18][2] = "0%";
data_header[18][3] = "medExamIdForUpdate";

data_header[19] = new Array;
data_header[19][0] = "Approved At Air(HQ)"
data_header[19][1] = "data";
data_header[19][2] = "0%";
data_header[19][3] = "medExamIdForUpdate";

<%
int  counter=0;
if (medicalExamdetail != null && medicalExamdetail.size() > 0) { 
for(MasMedicalExaminationReportOnEntry masexam : medicalExamdetail){
%>
   data_arr[<%= counter%>] = new Array();
       data_arr[<%= counter%>][0] = <%= masexam.getId()%>
	   <%if(masexam.getServiceNo()!=null){%>
	   data_arr[<%= counter%>][1] = <%= masexam.getServiceNo()%>
		   <%}else{%>
	   data_arr[<%= counter%>][1] = ""   
	   <%}%>
	   <%if(masexam.getRank()!=null){%>
	   data_arr[<%= counter%>][2] = "<%=masexam.getRank().getRankName()%>"  
		   <%}else{%>
	   data_arr[<%= counter%>][2] = ""   
	   <%}%>
	   <%if(masexam.getNameInFull()!=null){%>
	   data_arr[<%= counter%>][3] = "<%=masexam.getNameInFull()%>"
		   <%}else{%>
	   data_arr[<%= counter%>][3] = ""   
	   <%}%>
	   <%if(masexam.getUnit()!=null){%>
	   data_arr[<%= counter%>][4] = "<%=masexam.getUnit().getUnitName()%>"
		   <%}else{%>
	   data_arr[<%= counter%>][4] = ""   
	   <%}%>
		   <%if(masexam.getPastmedicalhistory()!=null){%>
	   data_arr[<%= counter%>][5] = "<%=masexam.getPastmedicalhistory()%>"
		   <%}else{%>
	   data_arr[<%= counter%>][5] = ""   
	   <%}%>
	   <%if(masexam.getMedicalExamType()!=null){%>
	   data_arr[<%= counter%>][6] = "<%=masexam.getMedicalExamType()%>"
		   <%}else{%>
	   data_arr[<%= counter%>][6] = ""   
	   <%}%>
	   <% if(masexam.getDateOfReporting()!=null){
	   %>
	   data_arr[<%= counter%>][7] = "<%=masexam.getDateOfReporting()%>"
		   <%}else{%>
	   data_arr[<%= counter%>][7] = ""   
	   <%}%>
	   <%if(masexam.getVisit().getHin().getMobileNumber()!=null){%>
	   data_arr[<%= counter%>][8] = "<%=masexam.getVisit().getHin().getMobileNumber()%>"
		   <%}else{%>
	   data_arr[<%= counter%>][8] = ""   
	   <%}%>
	   <%if(masexam.getVisit()!=null){%>
	   data_arr[<%= counter%>][9] = "<%=masexam.getVisit().getId()%>"
		   <%}else{%>
	   data_arr[<%= counter%>][9] = ""   
	   <%}%>
	   <%if(masexam.getMedicalExamType()!=null){%>
	   data_arr[<%= counter%>][10] = "<%=masexam.getMedicalExamType()%>"
		   <%}else{%>
	   data_arr[<%= counter%>][10] = ""   
	   <%}%>
	 
	   <%if(masexam.getInvestigated()!=null){%>
	   data_arr[<%= counter%>][11] = "<%=masexam.getInvestigated()%>"
		   <%}else{%>
	   data_arr[<%= counter%>][11] = ""   
	   <%}%>
	   <%if(masexam.getModate()!=null){%>
	   data_arr[<%= counter%>][12] = "<%=masexam.getModate()%>"
		   <%}else{%>
	   data_arr[<%= counter%>][12] = ""   
	   <%}%>
	   <%if(masexam.getStatus()!=null && masexam.getStatus().equalsIgnoreCase("v")){%>
	   data_arr[<%= counter%>][13] = "YES"
		   <%}else{%>
	   data_arr[<%= counter%>][13] = "NO"   
	   <%}%>	
	   <%if(masexam.getDateValidated()!=null ){%>
	   data_arr[<%= counter%>][14] = "YES"
		   <%}else{%>
	   data_arr[<%= counter%>][14] = "NO"   
	   <%}%> 
	   <%if(masexam.getApprovedBy()!=null){%>
	   data_arr[<%= counter%>][15] = "YES"
		   <%}else{%>
	   data_arr[<%= counter%>][15] = "NO"   
	   <%}%>  
	   <%if(masexam.getSendTo()!=null){%>
	   data_arr[<%= counter%>][16] = "YES"
		   <%}else{%>
	   data_arr[<%= counter%>][16] = "NO"   
	   <%}%>  
	   <%if(masexam.getSendTo()!=null){%>
	   data_arr[<%= counter%>][17] = "YES"
		   <%}else{%>
	   data_arr[<%= counter%>][17] = "NO"   
	   <%}%>   
	   <%if(masexam.getCommanddate()!=null){%>
	   data_arr[<%= counter%>][18] = "YES"
		   <%}else{%>
	   data_arr[<%= counter%>][18] = "NO"   
	   <%}%>   
	   <%if(masexam.getAfrodate()!=null){%>
	   data_arr[<%= counter%>][19] = "YES"
		   <%}else{%>
	   data_arr[<%= counter%>][19] = "NO"   
	   <%}%>   
	   <%if(masexam.getAirdate()!=null){%>
	   data_arr[<%= counter%>][20] = "YES"
		   <%}else{%>
	   data_arr[<%= counter%>][20] = "NO"   
	   <%}
	counter++;
	}
	}
%>
	formName = "pendingClwatingList123"

	start = 0
	if(data_arr.length < rowsPerPage)
	end = data_arr.length;
	else
	end = rowsPerPage;
	makeTable(start,end);

	intializeHover('searchresulttable', 'TR', ' tableover');
	</script>

<div class="clear"></div>
<input type="hidden" name="counter" id="counter" value="<%=counter %>" /> <input
	type="hidden" name="deptId" id="deptId" value="<%=deptId %>" /> <input
	type="hidden" name="deptName" id="deptName" value="<%=deptName %>" />
<script type="text/javascript">
	<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
	//-->
	</script> <script type="text/javascript">

	function validateICard(){
	var counter=document.getElementById("counter")
	for(var i = 0; i < document.getElementsByName('parent').length; i++){

	if(document.getElementsByName('parent')[i].checked == true)
	{
	var index=start+i;
	var status=document.getElementById('iCardStatus'+index).value
	if(status=="n")
	{
	alert("I-Card is not available with the patient.")
	return true;
	}
	//alert("I -Card Status for patient----:"+status)
	return true;
	}
	}
	alert("Please select the patient")
	return false;
	}
	function openTokenDisplay()
	{
	 var url="/hms/hms/opd?method=showPopupTokenJsp";
	 newwindow=window.open(url,'opentoken','_blank',"left=100,top=100,height=700,width=850,location=0,toolbar=0,menubar=0,status=no,scrollbars=yes,resizable=0");
	}
	function closeTokenDisplay(){
		if(false == newwindow.closed)
		{
			newwindow.close();
		}
		else
		{
		alert('Window already closed!');
		}
	}
</script>