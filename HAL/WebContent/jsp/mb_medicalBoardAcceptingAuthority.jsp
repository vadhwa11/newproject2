<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript">
	<!--
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
	// -->
</script>
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

<%
	int totalPatient=0;
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}

	List<MasMedicalExaminationReportOnEntry> mbAcceptAuthWaitList = new ArrayList<MasMedicalExaminationReportOnEntry>();
	List<MasEmployee> patientList = new ArrayList<MasEmployee>();
	List<MasRank> rankList = new ArrayList<MasRank>();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
	String currentTime = (String) utilMap.get("currentTime");
	String userName = "";
	String message = "";
	String deptName="";
	int deptId=0;
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	if (map.get("rankList") != null) {
		rankList = (List) map.get("rankList");
	}
	if (map.get("mbAcceptAuthWaitList") != null) {
		mbAcceptAuthWaitList = (List) map.get("mbAcceptAuthWaitList");
	}

	if (map.get("patientList") != null) {
		patientList = (List) map.get("patientList");
	}

	if (map.get("deptId") != null) {
	deptId = (Integer) map.get("deptId");
	}
	if (map.get("deptName") != null) {
	deptName = (String) map.get("deptName");
	}
	if (map.get("message") != null) {
		message = (String) map.get("message");
	}
	if (!message.equalsIgnoreCase("")) {
%>
<h4><%=message%></h4>
<%
	}
%>

<h2>WAITING LIST</h2>
<div class="clear paddingTop15"></div>

<form name="medicalBoardAcceptingAuthority" method="post" action="">
<div class="clear"></div>

</form>
<div class="floatRight">
<jsp:include page="searchResultBlockForIPD.jsp" />
</div>
<%--
<jsp:include page="searchResultBlock.jsp" />
 --%>
<div class="clear"></div>

 <div id="test">
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex="2" class="cmntable noBg"></div>
<script type="text/javascript" language="javascript">
formFields = [ [0,"medExamid","id"],[1,"Med Exam Type"],[2,"<%= RequestConstants.VISIT_DATE%>"],[3,"<%= RequestConstants.VISIT_DATE%>"], [4,"<%= RequestConstants.VISIT_TIME%>"], [5,"<%= RequestConstants.SERVICE_NO %>"], [6,"<%= RequestConstants.RANK_NAME %>"], [7,"<%=RANK_ID%>"], [8,"<%= RequestConstants.PATIENT_NAME %>"], [9,"medExamType"],[10,"<%=RequestConstants.STATUS%>"]];
	 statusTd = 12;
		</script></div>

		<div id="edited"></div>

		<div id="statusMessage"></div>
		</div>



<div class="bottom">

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentTime%>"/>
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=currentTime%>" />
</div>
<script type="text/javascript">
data_header = new Array();
data_header[0] = new Array;
data_header[0][0] = " "
data_header[0][1] = "hide";
data_header[0][2] = "5%";
data_header[0][3] = "Med Exam Type"

data_header[1] = new Array;
data_header[1][0] = "Visit Date";
data_header[1][1] = "data";
data_header[1][2] = "10%";
data_header[1][3] = "<%=RequestConstants.VISIT_DATE %>";

data_header[2] = new Array;
data_header[2][0] = "Visit Time";
data_header[2][1] = "data";
data_header[2][2] = "5%";
data_header[2][3] = "<%= RequestConstants.VISIT_TIME %>";

data_header[3] = new Array;
data_header[3][0] = "Service No.";
data_header[3][1] = "data";
data_header[3][2] = "5%";
data_header[3][3] = "<%=RequestConstants.SERVICE_NO%>";

data_header[4] = new Array;
data_header[4][0] = "Rank "
data_header[4][1] = "data";
data_header[4][2] = "5%";
data_header[4][3] = "<%=RequestConstants.RANK_NAME  %>";

data_header[5] = new Array;
data_header[5][0] = "Name";
data_header[5][1] = "data";
data_header[5][2] = "10%";
data_header[5][3] = "<%=RequestConstants.PATIENT_NAME %>";

data_header[6] = new Array;
data_header[6][0] = "Unit"
data_header[6][1] = "data";
data_header[6][2] = "10%";
data_header[6][3] = "<%=RequestConstants.UNIT %>";
data_header[7] = new Array;
data_header[7][0] = "Medical Board Type"
data_header[7][1] = "data";
data_header[7][2] = "10%";
data_header[7][3] = "<%=RequestConstants.MEDICAL_TYPE%>";

data_header[8] = new Array;
data_header[8][0] = "Contact No."
data_header[8][1] = "data";
data_header[8][2] = "10%";
data_header[8][3] = "<%=RequestConstants.CONTACT_NUMBER %>";

data_header[9] = new Array;
data_header[9][0] = "Status"
data_header[9][1] = "data";
data_header[9][2] = "10%";
data_header[9][3] = "<%=RequestConstants.STATUS %>";

<%
int  counter=0;
if (mbAcceptAuthWaitList != null && mbAcceptAuthWaitList.size() > 0) {
for(MasMedicalExaminationReportOnEntry masexam : mbAcceptAuthWaitList){
%>
   data_arr[<%= counter%>] = new Array();

          data_arr[<%= counter%>][0] = <%= masexam.getVisit().getId()%>
          data_arr[<%= counter%>][1] = '<%= masexam.getVisit().getMedExamType()%>'
	   <%if(masexam.getVisit()!=null){%>
	   data_arr[<%= counter%>][2] = '<%= HMSUtil.changeDateToddMMyyyy(masexam.getVisit().getVisitDate())%>'
		   <%}else{%>
	   data_arr[<%= counter%>][2] = ""
	   <%}%>
	   <%if(masexam.getVisit()!=null){%>
	   data_arr[<%= counter%>][3] = "<%=masexam.getVisit().getVisitTime() %>"
		   <%}else{%>
	   data_arr[<%= counter%>][3] = ""
	   <%}%>
	   <%if(masexam.getServiceNo() !=null){%>
	   data_arr[<%= counter%>][4] = "<%=masexam.getServiceNo() %>"
		   <%}else{%>
	   data_arr[<%= counter%>][4] = ""
	   <%}%>
		   <%if(masexam.getRank() !=null){%>
	   data_arr[<%= counter%>][5] = "<%=masexam.getRank().getRankName() %>"
		   <%}else{%>
	   data_arr[<%= counter%>][5] = ""
	   <%}%>
	   <%if(masexam.getNameInFull() !=null){%>
	   data_arr[<%= counter%>][6] = "<%=masexam.getNameInFull()%>"
		   <%}else{%>
	   data_arr[<%= counter%>][6] = ""
	   <%}%>
	   <%if(masexam.getUnit() !=null){%>
	   data_arr[<%= counter%>][7] = "<%=masexam.getUnit().getUnitName() %>"
		   <%}else{%>
	   data_arr[<%= counter%>][7] = ""
	   <%}%>
	   <%if(masexam.getMedicalExamType()!=null){%>
	   data_arr[<%= counter%>][8] = "<%=masexam.getMedicalExamType()%>"
		   <%}else{%>
	   data_arr[<%= counter%>][8] = ""
	   <%}%>
	   <%if(masexam.getVisit().getHin().getMobileNumber()!=null){%>
	   data_arr[<%= counter%>][9] = "<%=masexam.getVisit().getHin().getMobileNumber()%>"
		   <%}else{%>
	   data_arr[<%= counter%>][9] = ""
	   <%}

	   String ma_status="";
		if(masexam.getVisit().getPriority()!=null){
			if(masexam.getVisit().getPriority()==4){
				ma_status="New";
			}else if(masexam.getVisit().getPriority()==5){
				ma_status="New";
			}else if(masexam.getVisit().getPriority()==6){
				ma_status="New";
			}else if(masexam.getVisit().getPriority()==7){
				ma_status="Rejected ";
			}else if(masexam.getVisit().getPriority()==8){
				ma_status="Rejected ";
			}else if(masexam.getVisit().getPriority()==9){
				ma_status="Rejected ";
			}else{
				ma_status="New";
			}
		}else{

			ma_status="New";
		}
		%>
		data_arr[<%= counter%>][10] = "<%=ma_status%>"
			data_arr[<%= counter%>][11] = "<%=masexam.getId()%>"
<%
counter++;
totalPatient++;
}
}
%>
formName = "medicalBoardAcceptingAuthority"
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeGridForPatient(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');
</script>

</div>

<%---
<input type="text" class="signPriority3" readonly="readonly" >
<label class="valueAutoPriority">Pending For Result</label>
<input type="text" class="signPriority1" readonly="readonly" >
<label class="valueAutoPriority">Rejected by Approving Authority</label>
<input type="text" class="signPriority1" readonly="readonly" >
<label class="valueAutoPriority">Priority-1</label>
<input type="text" class="signPriority2" readonly="readonly" >
<label class="valueAutoPriority">Priority-2</label>
<input type="text" class="signPriority3" readonly="readonly" >
<label class="valueAutoPriority">Priority-3</label>--%>
<div class="floatRight"><label class="auto">Total  : </label>
<label	class="valueAuto"><%=totalPatient%></label>
		</div>

<div class="clear"></div>
<input type="hidden" name="counter" id="counter" value="<%=counter %>" />
<input type="hidden" name="deptId" id="deptId" value="<%=deptId %>" />
<input type="hidden" name="deptName" id="deptName" value="<%=deptName %>" />
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
