<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.Users"%>
<script	type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript">
	<!--
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
	// -->
</script>
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
	int totalPatient=0;
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}

	List<MasMedicalExaminationReportOnEntry> medicalExamdetail = new ArrayList<MasMedicalExaminationReportOnEntry>();
	List<MasEmployee> patientList = new ArrayList<MasEmployee>();
	List<MasRank> rankList = new ArrayList<MasRank>();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
	//String currentTime = (String) utilMap.get("currentTime");
	String currentTime = (String) utilMap.get("currentTimeWithoutSc");
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
	Users user = new Users();
	if(session.getAttribute("users")!=null){
		user = (Users)session.getAttribute("users");
	}

	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader()
	.getResource("adt.properties");
	try {
	properties.load(resourcePath.openStream());
	} catch (Exception e) {
	e.printStackTrace();
	}
	String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
	List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
	List<String> labResultStausList = new ArrayList<String>();
	if(map.get("labResultStausList") != null)
	{
		labResultStausList=(List<String>)map.get("labResultStausList");
	}
	if (map.get("patientDetailList") != null) {
		medicalExamdetail = (List) map.get("patientDetailList");
	}
	if (map.get("patientList") != null) {
		patientList = (List) map.get("patientList");
	}

	if (map.get("doctorList") != null) {
		doctorList = (List) map.get("doctorList");
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
<h4><%=message %></h4>
<%} %>
<form name="medicalBoardMedicalOfficerInitial" method="post" action="">
<div class="clear"></div>

<div class="Block">
<label>Medical Officer</label>
 <select name="consultingDoc">
	<option value="0">All</option>
	<%
int doctorId=0;
for(MasEmployee masEmployee : doctorList){
	doctorId = masEmployee.getId();
	if(masEmployee.getEmpCategory() != null){
		if(masEmployee.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor)){
			if(user.getEmployee().getId() == doctorId){
%>
	<option value="<%=masEmployee.getId() %>" selected="selected"><%=masEmployee.getRank().getRankName()+" "+masEmployee.getFirstName()+" "+masEmployee.getLastName() %></option>
	<%}else{ %>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getRank().getRankName()+" "+masEmployee.getFirstName()+" "+masEmployee.getLastName() %></option>
	<%				}
		}
	}
} %>
</select> <input type="button" name="Go" value="Go"
	onClick="submitForm('medicalBoardMedicalOfficerInitial','medicalBoard?method=showMedicalOfficerAppointmentInitial&filter=true')"
	class="buttonSm" /></div>
</form>
<div class="floatRight">

<div class="titleBg">

<h2>WAITING LIST</h2>
</div>
<div class="clear paddingTop15"></div>

<jsp:include page="searchResultBlockForIPD.jsp" /> <%--
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
<div class="bottom"><input type="hidden" name="<%=CHANGED_BY%>"
	value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=currentTime%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=currentTime%>" /></div>
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

<%--
data_header[7] = new Array;
data_header[7][0] = "Medical Board Type"
data_header[7][1] = "data";
data_header[7][2] = "10%";
data_header[7][3] = "<%=RequestConstants.MEDICAL_TYPE%>";
--%>

data_header[7] = new Array;
data_header[7][0] = "Med Cat"
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
int empId = user.getEmployee().getId();
int  counter=0;
if (medicalExamdetail != null && medicalExamdetail.size() > 0) {
for(MasMedicalExaminationReportOnEntry masexam : medicalExamdetail){
//if(masexam.getForwardMO()!=null && masexam.getForwardMO().getId() == empId){
%>
   data_arr[<%= counter%>] = new Array();

          data_arr[<%= counter%>][0] = <%= masexam.getVisit().getId()%>
          data_arr[<%= counter%>][1] = '<%= masexam.getVisit().getMedExamType()%>'
	   <%
	   if(masexam.getVisit().getVisitDate()!=null){%>
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
	   <%---
	   <%if(masexam.getMedicalExamType()!=null){%>
	   data_arr[<%= counter%>][8] = "<%=masexam.getMedicalExamType()%>"
		   <%}else{%>
	   data_arr[<%= counter%>][8] = ""
	   <%}%>--%>
	   <%if(masexam.getPresentMedicalCategory()!=null){%>
	   data_arr[<%= counter%>][8] = "<%=masexam.getPresentMedicalCategory().getCategories()%>"
		   <%}else{%>
	   data_arr[<%= counter%>][8] = ""
	   <%}%>
	   <%if(masexam.getVisit().getHin().getMobileNumber()!=null){%>
	   data_arr[<%= counter%>][9] = "<%=masexam.getVisit().getHin().getMobileNumber()%>"
		   <%}else{%>
	   data_arr[<%= counter%>][9] = ""
	   <%}
	   String ma_status="";
		Set<DgOrderhd> dgOrderhdSet=new HashSet<DgOrderhd>();
			boolean orderStatusFlag=true;
			Visit visit=masexam.getVisit();
		if(visit.getDgOrderhds()!=null)
		{
			dgOrderhdSet=visit.getDgOrderhds();
			if(dgOrderhdSet.size()>0){
			
				String labResultStatus=labResultStausList.get(counter);
				if(labResultStatus.equalsIgnoreCase("no"))
				{
					ma_status="New";
				}else if(labResultStatus.equalsIgnoreCase("pending"))
				{
					ma_status="Investigation Pending";
				}else if(labResultStatus.equalsIgnoreCase("validated"))
				{
					ma_status="Result Validated";
				}
				if(visit.getPriority()!=null)
				{
				 if(visit.getPriority()==8){
					ma_status="Rejected By MA";
				}
				}	
				
			}else{
				if(visit.getPriority()!=null){
					if(visit.getPriority()==4){
						ma_status="Investigation Pending";
					}else if(visit.getPriority()==5){
						ma_status="Investigation Pending";
					}else if(visit.getPriority()==6){
						ma_status="Investigation Pending";
					}else if(visit.getPriority()==8){
						ma_status="Rejected By MO";
				}else{
						ma_status="New";
					}
				}else{
					
					ma_status="New";
				}
			}
		}	%>
		data_arr[<%= counter%>][10] = "<%=ma_status%>"

		data_arr[<%= counter%>][11] = "<%=masexam.getId()%>"

			<%
			if(masexam.getPriority()!= null)
			{
			%>
			data_arr[<%= counter%>][12] = "<%=masexam.getPriority()%>"
			<%}else{
				%>
				data_arr[<%= counter%>][12] = "0"
					<%}
counter++;
totalPatient++;
}
//}
}
%>
formName = "medicalBoardMedicalOfficerInitial"
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeGridForPatient(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');
</script>
<div class="floatRight"><label class="auto">Total : </label> <label
	class="valueAuto"><%=totalPatient%></label></div>
<div class="clear"></div>
<input type="hidden" name="counter" id="counter" value="<%=counter %>" />
<input type="hidden" name="deptId" id="deptId" value="<%=deptId %>" />
<input type="hidden" name="deptName" id="deptName"
	value="<%=deptName %>" /> <script type="text/javascript">
	<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
	//-->
	</script></div>