
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
<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
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
<h2>Current Medical Board Status</h2>
</div>
<div class="clear"></div><%

if(map.get("message") != null){
	String message = (String)map.get("message");
	%>
	<h4><span><%=message %></span></h4>
	<%} %>


<h2>WAITING LIST</h2>
<div class="clear paddingTop15"></div>
<form name="currentMedicalBoardStatus" method="post" action="">
<div class="clear"></div>
<div class="floatRight"><label class="auto">Total  : </label>
<label	class="valueAuto"><%=totalPatient%></label>
</div>
<div class="clear"></div>

</form>
<div class="clear"></div>

<div class="floatRight">
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="test">
<div id="searchresults" tabindex="2">
<div id="searchtable" tabindex="2"></div>

<script type="text/javascript" language="javascript">
	formFields = [
	[0, "<%= RequestConstants.HIN_ID%>", "id"],[1, "<%= RequestConstants.RADIO_FOR_TABLE%>"], [2,"<%= RequestConstants.VISIT_NUMBER %>"], [3,"<%= RequestConstants.VISIT_DATE %>"],[4,"<%= RequestConstants.VISIT_TIME %>"],[5,"<%= RequestConstants.HIN_NO %>"],[6,"<%=RequestConstants.SERVICE_NO%>"],[7,"<%= RequestConstants.RANK_NAME %>"],[8,"<%=RequestConstants.PATIENT_NAME%>"],[9,"<%=RequestConstants.UNIT%>"]];
	statusTd =12;

	</script></div>

<div id="edited"></div>

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
data_header[4][0] = "Medical Board Type"
data_header[4][1] = "data";
data_header[4][2] = "0%";
data_header[4][3] = "<%=STATUS %>";

data_header[5] = new Array;
data_header[5][0] = "Date Reported"
data_header[5][1] = "data";
data_header[5][2] = "0%";
data_header[5][3] = "<%=STATUS %>";

data_header[6] = new Array;
data_header[6][0] = "visitId"
data_header[6][1] = "hide";
data_header[6][2] = "0%";
data_header[6][3] = "visitId";


data_header[7] = new Array;
data_header[7][0] = "Med Asst"
data_header[7][1] = "data";
data_header[7][2] = "0%";
data_header[7][3] = "medExamIdForUpdate";

data_header[8] = new Array;
data_header[8][0] = "MO"
data_header[8][1] = "data";
data_header[8][2] = "0%";
data_header[8][3] = "medExamIdForUpdate";

data_header[9] = new Array;
data_header[9][0] = "App Authority"
data_header[9][1] = "data";
data_header[9][2] = "0%";
data_header[9][3] = "medExamIdForUpdate";

data_header[10] = new Array;
data_header[10][0] = "Per Authority"
data_header[10][1] = "data";
data_header[10][2] = "10%";
data_header[10][3] = "medExamIdForUpdate";

<%
int  counter=0;
if (medicalExamdetail != null && medicalExamdetail.size() > 0) {
for(MasMedicalExaminationReportOnEntry masexam : medicalExamdetail){
%>
   data_arr[<%= counter%>] = new Array();
          data_arr[<%= counter%>][0] = <%= masexam.getId()%>
	   <%if(masexam.getServiceNo()!=null){%>
	   data_arr[<%= counter%>][1] = "<%= masexam.getServiceNo()%>"
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

	   <%if(masexam.getMedicalExamType()!=null){%>
	   data_arr[<%= counter%>][5] = "<%=masexam.getMedicalExamType()%>"
		   <%}else{%>
	   data_arr[<%= counter%>][5] = ""
	   <%}%>
	   <%
	   if(masexam.getDateOfReporting()!=null){
	   %>
	   data_arr[<%= counter%>][6] = "<%=HMSUtil.changeDateToddMMyyyy(masexam.getDateOfReporting())%>"
		   <%}else{%>
	   data_arr[<%= counter%>][6] = ""
	   <%}%>
	    <%if(masexam.getVisit()!=null){%>
	   data_arr[<%= counter%>][7] = "<%=masexam.getVisit().getId()%>"
		   <%}else{%>
	   data_arr[<%= counter%>][7] = ""
	   <%}%>

		   <%
		/*
		*Code By Mukesh Narayan SIngh
		* Date 16 March 2012
		*/
		   String medStatusF="";
		   String medStatusV="";
		   String medStatusA="";
		   String medStatusP="";
		   if(masexam.getStatus()!=null && masexam.getStatus().equalsIgnoreCase("s")){
			   String maDateF="";
			   if(masexam.getDateMedicalBoardExam() !=null){
				   maDateF= HMSUtil.changeDateToddMMyyyy(masexam.getDateMedicalBoardExam());
			   }
			   medStatusF="Completed - "+maDateF;
			   medStatusV="Pending";
			   medStatusA="Pending";
			   medStatusP="Pending";
			}else if(masexam.getStatus()!=null && masexam.getStatus().equalsIgnoreCase("v")){
				String maDateF="";
				if(masexam.getModate() !=null){
					   maDateF= HMSUtil.changeDateToddMMyyyy(masexam.getModate());
				   }
				   String maDateV="";
				   if(masexam.getDateValidated() !=null){
					   maDateV= HMSUtil.changeDateToddMMyyyy(masexam.getDateValidated());
				   }
				   medStatusF="Completed - "+maDateF;
				   medStatusV="Completed - "+maDateV;
				   medStatusA="Pending";
				   medStatusP="Pending";
			}else if(masexam.getStatus()!=null && masexam.getStatus().equalsIgnoreCase("a")){
				 String maDateF="";
				   if(masexam.getModate() !=null){
					   maDateF= HMSUtil.changeDateToddMMyyyy(masexam.getModate());
				   }	
				   String maDateV="";
				   if(masexam.getDateValidated() !=null){
					   maDateV= HMSUtil.changeDateToddMMyyyy(masexam.getDateValidated());
				   }
					String maDateA="";
				   if(masexam.getAppAuthDate() !=null){
					   maDateA= HMSUtil.changeDateToddMMyyyy(masexam.getAppAuthDate());
				   }
				   medStatusF="Completed - "+maDateF;
				   medStatusV="Completed - "+maDateV;
				   medStatusA="Completed - "+maDateA;
				   medStatusP="Pending";
			}else if(masexam.getStatus()!=null && masexam.getStatus().equalsIgnoreCase("p")
					&& (masexam.getAcceptSignedBy() !=null || masexam.getPerApprovAuthSignedBy() !=null)){
				 String maDateF="";
				   if(masexam.getModate() !=null){
					   maDateF= HMSUtil.changeDateToddMMyyyy(masexam.getModate());
				   }	
				   String maDateV="";
				   if(masexam.getDateValidated() !=null){
					   maDateV= HMSUtil.changeDateToddMMyyyy(masexam.getDateValidated());
				   }
					String maDateA="";
				   if(masexam.getAppAuthDate() !=null){
					   maDateA= HMSUtil.changeDateToddMMyyyy(masexam.getAppAuthDate());
				   }
				   String maDateP="";
				   if(masexam.getPerAuthDate() !=null){
					   maDateP= HMSUtil.changeDateToddMMyyyy(masexam.getPerAuthDate());
				   }
				   medStatusF="Completed - "+maDateF;
				   medStatusV="Completed - "+maDateV;
				   medStatusA="Completed - "+maDateA;
				   medStatusP="Completed - "+maDateP;
			}else{
				   medStatusF="Pending";
				   medStatusV="Pending";
				   medStatusA="Pending";
				   medStatusP="Pending";
			}
%>
		   	   data_arr[<%= counter%>][8] = '<%=medStatusF%>'
			   data_arr[<%= counter%>][9] = '<%=medStatusV%>'
			   data_arr[<%= counter%>][10] = '<%=medStatusA%>'
			   data_arr[<%= counter%>][11] = '<%=medStatusP%>'   
<%
counter++;
}
}
%>
	formName = "currentMedicalBoardStatus"

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
