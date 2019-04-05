<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%>

<%@page import="jkt.hms.masters.business.MasMedicalBoardExaminationDetail"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationDetail"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
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
	if (map.get("patientDetailList") != null) {
		medicalExamdetail = (List) map.get("patientDetailList");
	}
	MasMedicalExaminationReportOnEntry medExaminationReportOnEntry=new MasMedicalExaminationReportOnEntry();
	MasMedicalExaminationDetail medExaminationDetail=new MasMedicalExaminationDetail();
	if(medicalExamdetail != null && medicalExamdetail.size()>0) {
		medExaminationReportOnEntry = (MasMedicalExaminationReportOnEntry) medicalExamdetail.get(0);
	}
	Set<MasMedicalExaminationDetail> medExaminationDetailSet = new HashSet<MasMedicalExaminationDetail>();
	medExaminationDetailSet = medExaminationReportOnEntry.getMasmedicaldetail();
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
<h4 align="left"><%=message %></h4>
<%
	}
%>

<form name="medicalBoardSpecialist" method="post" 	action="">
<div class="clear"></div>
<div class="clear"></div>
 </form>
<div class="floatRight">
<div class="titleBg">
<h2>WAITING LIST</h2>
</div>
<div class="clear paddingTop15"></div>
<div class="floatRight">

<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2 class="cmntable"></div>
<script type="text/javascript">
	formFields = [ [0,"medExamid","id"],[1,"<%= RequestConstants.SERVICE_NO %>"], [2,"<%= RequestConstants.RANK_NAME %>"], [3,"<%=RANK_ID%>"], [4,"<%= RequestConstants.PATIENT_NAME %>"],[5,"medExamType"]];
	 statusTd = 5;
	</script>
   </div>

<div class="bottom">

<input type="hidden"	name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden"	name="<%=CHANGED_DATE %>" value="<%=currentTime%>"/>
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=currentTime%>" />
</div>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Service No.";
data_header[0][1] = "data";
data_header[0][2] = "5%";
data_header[0][3] = "<%=RequestConstants.SERVICE_NO%>";

data_header[1] = new Array;
data_header[1][0] = "Rank "
data_header[1][1] = "data";
data_header[1][2] = "5%";
data_header[1][3] = "<%=RequestConstants.RANK_NAME  %>";

data_header[2] = new Array;
data_header[2][0] = "Name";
data_header[2][1] = "data";
data_header[2][2] = "10%";
data_header[2][3] = "<%=RequestConstants.PATIENT_NAME %>";

data_header[3] = new Array;
data_header[3][0] = "Unit"
data_header[3][1] = "data";
data_header[3][2] = "10%";
data_header[3][3] = "<%=RequestConstants.UNIT %>";

data_header[4] = new Array;
data_header[4][0] = "Last MB Date"
data_header[4][1] = "data";
data_header[4][2] = "10%";
data_header[4][3] = "<%=RequestConstants.DATE_OF_MB%>";

data_header[5] = new Array;
data_header[5][0] = "Last MB Place"
data_header[5][1] = "data";
data_header[5][2] = "10%";
data_header[5][3] = "<%=RequestConstants.PLACE_OF_MB%>";

data_header[6] = new Array;
data_header[6][0] = "Medical Board Type"
data_header[6][1] = "data";
data_header[6][2] = "10%";
data_header[6][3] = "<%=RequestConstants.MEDICAL_TYPE%>";

data_header[7] = new Array;
data_header[7][0] = "Disability"
data_header[7][1] = "data";
data_header[7][2] = "10%";
data_header[7][3] = "<%=RequestConstants.DISABILITY%>";
data_header[8] = new Array;
data_header[8][0] = "Status"
data_header[8][1] = "hide";
data_header[8][2] = "10%";
data_header[8][3] = "<%=RequestConstants.STATUS%>";
<%
int  counter=0;

if (medicalExamdetail != null && medicalExamdetail.size() > 0) {
for(MasMedicalExaminationReportOnEntry masexam : medicalExamdetail){
	String rank="";
	String name="";
	String unit="";
	if(masexam.getHin()!=null){
		if(masexam.getHin().getRank()!=null){
			rank= masexam.getHin().getRank().getRankName();
		}
		
		if(masexam.getHin().getUnit()!=null){
			unit= masexam.getHin().getUnit().getUnitName();
		}
	}
%>
   data_arr[<%= counter%>] = new Array();

          data_arr[<%= counter%>][0] = <%= masexam.getVisit().getId()%>
          data_arr[<%= counter%>][1] = '<%= masexam.getHin().getServiceNo()%>'
	   data_arr[<%= counter%>][2] = "<%=rank%>"
	   <%if(masexam.getNameInFull() !=null){%>
	   data_arr[<%= counter%>][3] = "<%=masexam.getNameInFull()%>"
		   <%}else{%>
	   data_arr[<%= counter%>][3] = ""
	   <%}%>
	   data_arr[<%= counter%>][4] = "<%=unit%>"
	   data_arr[<%= counter%>][5] = "<%=(masexam.getLastBoardDate()!=null && !masexam.getLastBoardDate().equals(""))?HMSUtil.convertDateToStringWithoutTime(masexam.getLastBoardDate()):""%>"
	   data_arr[<%= counter%>][6] = "<%=masexam.getPlaceLastCatBoard()!=null?masexam.getPlaceLastCatBoard():""%>"
	   <%if(masexam.getMedicalExamType()!=null){%>
	   data_arr[<%= counter%>][7] = "<%=masexam.getMedicalExamType()%>"
		   <%}else{%>
	   data_arr[<%= counter%>][7] = ""
	   <%}%>
	   <%String disabilityString ="";
	   if(medExaminationDetailSet !=null && medExaminationDetailSet.size() >0){
	   for(MasMedicalExaminationDetail medicalExaminationDetail :medExaminationDetailSet)
		{
	   if((medicalExaminationDetail.getMasMedicalReport().getId().equals(masexam.getId()))
		   && (medicalExaminationDetail.getParticular()!=null &&   medicalExaminationDetail.getParticular().equalsIgnoreCase("detail"))){
		   disabilityString=disabilityString+medicalExaminationDetail.getPrincipal();  %>
	   data_arr[<%= counter%>][8] = "<%=disabilityString%>"
	   <%}else{%>
	   data_arr[<%= counter%>][8] = ""
		   <%}}}else{ %>
		   data_arr[<%= counter%>][8] = ""
		   <%}
		
	   String ma_status="";
		if(masexam.getVisit().getPriority()!=null){
			if(masexam.getVisit().getPriority()==4){
				ma_status="Investigation Pending";
			}else if(masexam.getVisit().getPriority()==5){
				ma_status="Investigation Pending";
			}else if(masexam.getVisit().getPriority()==6){
				ma_status="Investigation Pending";
			}else if(masexam.getVisit().getPriority()==7){
				ma_status="Rejected By MO";
			}else if(masexam.getVisit().getPriority()==8){
				ma_status="Rejected By MO";
			}else if(masexam.getVisit().getPriority()==9){
				ma_status="Rejected By MO";
			}else{
				ma_status="New";
			}
		}else{

			ma_status="New";
		}
		%>
		data_arr[<%= counter%>][9] = "<%=ma_status%>"

		data_arr[<%= counter%>][10] = "<%=masexam.getId()%>"
			data_arr[<%= counter%>][11] = '<%= masexam.getVisit().getMedExamType()%>'
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
}
%>
formName = "medicalBoardSpecialist"
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeGridForPatient(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');
</script>


<div class="floatRight"><label class="auto">Total : </label>
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
	</script>
</div>