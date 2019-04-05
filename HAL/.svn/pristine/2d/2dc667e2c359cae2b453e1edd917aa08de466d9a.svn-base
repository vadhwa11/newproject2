<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>

<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>

<script
	type="text/javascript" language="javascript">
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
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
	String currentTime = (String) utilMap.get("currentTime");
	String userName = "";
	String message = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	List<MasRank> rankList = new ArrayList<MasRank>();
	if (map.get("rankList") != null) {
		rankList = (List) map.get("rankList");
	}
	List<MasMedicalExaminationReportOnEntry> medicalExamdetail = new ArrayList<MasMedicalExaminationReportOnEntry>();
	List<MasEmployee> patientList = new ArrayList<MasEmployee>();

	if (map.get("patientDetailList") != null) {
		medicalExamdetail = (List) map.get("patientDetailList");
	}
	if (map.get("patientList") != null) {
		patientList = (List) map.get("patientList");
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
<div class="titleBg">
<h2>Waiting List </h2>
</div>
<div class="Clear"></div>
<jsp:include page="searchResultBlockForIPD.jsp" />
<div class="Clear"></div>
<form name="medicalExamApprovingAuthourity" method="post"	action="">
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2 class="cmntable noBg"></div>
<script type="text/javascript">
	formFields = [ [0,"medExamid","id"],[1,"<%= SERVICE_NO%>"], [2,"<%= RANK%>"], [3,"<%= FULL_NAME %>"], [4,"<%= UNIT %>"], [5,"<%=RANK_ID%>"], [6,"<%= STATUS %>"],  [7,"<%=STATUS%>"], [8,"medCatRec"], [9,"visitId"], [10,"medExamType"] ,[11,"medExamIdForUpdate"],[12,"<%=MA_STATUS%>"]];
	 statusTd = 11;
	</script>
</div>
</form>
<div class="bottom">

<input type="hidden"	name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input type="hidden"	name="<%=CHANGED_DATE %>" value="<%=currentTime%>" />
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=currentTime%>" /></div>
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
data_header[4][0] = "Date of ME";
data_header[4][1] = "data";
data_header[4][2] = "15%";
data_header[4][3] = "dateOfMedicalExam";

data_header[5] = new Array;
data_header[5][0] = "Place of ME"
data_header[5][1] = "data";
data_header[5][2] = "0%";
data_header[5][3] = "placeOfME";

data_header[6] = new Array;
data_header[6][0] = "Medical Exam Type"
data_header[6][1] = "data";
data_header[6][2] = "0%";
data_header[6][3] = "medExamType"; 

data_header[7] = new Array;
data_header[7][0] = "Med Cat Rec"
data_header[7][1] = "data";
data_header[7][2] = "0%";
data_header[7][3] = "medCatRec";

data_header[8] = new Array;
data_header[8][0] = "visitId"
data_header[8][1] = "hide";
data_header[8][2] = "0%";
data_header[8][3] = "visitId";

data_header[9] = new Array;
data_header[9][0] = "medical Exam Type"
data_header[9][1] = "hide";
data_header[9][2] = "0%";
data_header[9][3] = "medExamIdForUpdate";  
data_header[10] = new Array;
data_header[10][0] = "medical Exam Id"
data_header[10][1] = "hide";
data_header[10][2] = "0%";
data_header[10][3] = "medExamIdForId"; 
data_header[11] = new Array;
data_header[11][0] = "Status"
data_header[11][1] = "data"
data_header[11][2] = "10%" 
data_header[11][3] = "<%=MA_STATUS %>";   
<%
int  counter=0;
if (medicalExamdetail != null && medicalExamdetail.size() > 0) { 
for(MasMedicalExaminationReportOnEntry masexam : medicalExamdetail){
	//System.out.println("PresentMedicalCategory=====*****>>>>>"+masexam.getPastMedicalCategory().getCategories() );
%>
   data_arr[<%= counter%>] = new Array();  
  
          data_arr[<%= counter%>][0] = <%= masexam.getId()%>
	   <%if(masexam.getServiceNo()!=null){%>
	   data_arr[<%= counter%>][1] = "<%= masexam.getYearlySerialNo()%>"
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
		   <%if(masexam.getMedicalExamType().equalsIgnoreCase("Annual Medical Exam(AFMSF-3B)")&&(masexam.getDateOfReporting()!=null))
		    {%>
	   data_arr[<%= counter%>][5] = "<%=HMSUtil.changeDateToddMMyyyy(masexam.getDateOfReporting())%>"
		   <%}else if(masexam.getMedicalExamType().equalsIgnoreCase("Med. Exam On Release/Discharge(AFMSF-18)")&&(masexam.getDateDischarge()!=null))
		    {%>
		    data_arr[<%= counter%>][5] = "<%=HMSUtil.changeDateToddMMyyyy(masexam.getDateDischarge())%>"
		   <%}else{%>
	   data_arr[<%= counter%>][5] = ""   
	   <%}%>
	   <%if(masexam.getMedicalExamType().equalsIgnoreCase("Annual Medical Exam(AFMSF-3B)"))
	    {%>
        data_arr[<%= counter%>][6] = "<%=(String)session.getAttribute("hospitalName")%>"
	   <%}else if(masexam.getMedicalExamType().equalsIgnoreCase("Med. Exam On Release/Discharge(AFMSF-18)")&&(masexam.getPlace()!=null))
	    {%>
	    data_arr[<%= counter%>][6] = "<%=masexam.getPlace()%>"
	   <%}else{%>
        data_arr[<%= counter%>][6] = ""   
      <%}%>
      <%if(masexam.getMedicalExamType()!=null){%>
	   data_arr[<%= counter%>][7] = "<%=masexam.getMedicalExamType()%>"
		   <%}else{%>
	   data_arr[<%= counter%>][7] = ""   
	   <%}%>
	   <%
	   if(masexam.getHin().getCategory()!=null){%>
	   data_arr[<%= counter%>][8] = "<%=masexam.getHin().getCategory().getCategories()%>"
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
	  
	   <%}
	  
		/*if(masexam.getVisit().getPriority()!=null){
			if(masexam.getVisit().getPriority()==4){
				ma_status="Pending For Result";
			}else if(masexam.getVisit().getPriority()==5){
				ma_status="Pending For Result";
			}else if(masexam.getVisit().getPriority()==6){
				ma_status="Pending For Result";
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
			
		}
		*/
		String ma_status="";
		if(masexam.getPriority()!=null)
		{
			if(masexam.getPriority()==8)
			{
				ma_status="Rejected By PA";
			}else
			{
				ma_status="New";
			}
		}else
		{	
			  ma_status="New";
		}
			
		%>
		 data_arr[<%= counter%>][11] = "<%=masexam.getId()%>"
		data_arr[<%=counter%>][12] = "<%=ma_status%>"
	  	      
	  <%if(masexam.getPriority()!=null){%>
	  data_arr[<%= counter%>][13] = "<%=masexam.getPriority()%>"
	  <%}else{%>
	  data_arr[<%= counter%>][13] = "0"   
	  <%}%>	   
<%
counter++;
}
}
%>
formName = "medicalExamApprovingAuthourity"
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeGridForPatient(start,end);
intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
<%-- 
<input type="text" class="signPriority1" readonly="readonly" >
<label class="valueAutoPriority">Priority-1</label>
<input type="text" class="signPriority2" readonly="readonly" >
<label class="valueAutoPriority">Priority-2</label>
<input type="text" class="signPriority3" readonly="readonly" >
<label class="valueAutoPriority">Priority-3</label> 
--%>
<%---
<input type="text" class="signPriority1" readonly="readonly" >
<label class="valueAutoPriority">Rejected By Perusing Authority</label> --%>
<div class="floatRight"><label class="auto">Total : </label>
		<label	class="valueAuto"><%=counter%></label>
		</div>
<div class="Clear"></div>		