<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@  page import="jkt.hms.masters.business.MasSection"%>

<%@page import="jkt.hms.masters.business.MasMedicalExaminationDetail"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%>

<%@page import="jkt.hms.util.Box"%><script	type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
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

		function checkYear()
		{
			var year=document.getElementById('yearId').value;
			if(year=='0')
			{	
				alert("Please Select the Year");
               return false;
		    }
			else
			{
				return true;
			}			
		}	
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
	List<MasMedicalExaminationReportOnEntry> medicalExamdetail = new ArrayList<MasMedicalExaminationReportOnEntry>();
	if (map.get("patientDetailList") != null) {
		medicalExamdetail = (List) map.get("patientDetailList");
	}
	String userName = "";
	String message = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	if (map.get("message") != null) {
		message = (String) map.get("message");
	}
	String searchtype=null;
	if (map.get("searchtype") != null) {
		searchtype = (String) map.get("searchtype");
		
	}
	Box box = HMSUtil.getBox(request);
	session.setAttribute("box",box);
	%>
	
	<div class="clear"></div>
<div class="division"></div>

<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<form name="medicalBoardStatistics" method="post" action="">
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<script type="text/javascript">
	formFields = [ [0,"medExamid","id"],[1,"dateOfComplete"],[2,"<%= SERVICE_NO%>"], [3,"<%= RANK%>"], [4,"<%= FULL_NAME %>"], [5,"<%= TRADE_ID %>"], [6,"<%= UNIT_ID %>"], [7,"medExamType"], [8,"age"], [9,"height"], [10,"weight"], [11,"ibw"], [12,"bmi"], [13,"waist"], [14,"hip"], [15,"whr"], [16,"pulse"], [17,"bp"], [18,"medCat"], [19,"<%= REPORTED_DATE %>"],  [20,"<%=VISIT_ID%>"], [21,"examId"],
	           		 [22,"<%=STATUS%>"], [23,"overWeight"],[24,"obesity"],[25,"disability"],[26,"rejectedBy"]];
	 statusTd = 26;
	</script></div>
	
	<div class="clear"></div>
<input type="button" name="print" value="Print" class="button" onClick="submitForm('medicalBoardStatistics','medicalBoard?method=showMbStaticsReport');" />
<input name="Back" type="button" value="Back" class="button" 
	onclick="submitForm('medicalBoardStatistics','/hms/hms/medicalBoard?method=showMisMedicalBoardReport');"/>
</form>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentTime%>" />
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=currentTime%>" />
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Date";
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "dateOfComplete";

data_header[1] = new Array;
data_header[1][0] = "Service No.";
data_header[1][1] = "data";
data_header[1][2] = "20%";
data_header[1][3] = "<%= SERVICE_NO %>";

data_header[2] = new Array;
data_header[2][0] = "Rank";
data_header[2][1] = "data";
data_header[2][2] = "15%";
data_header[2][3] = "<%=RANK%>";


data_header[3] = new Array;
data_header[3][0] = " Name "
data_header[3][1] = "data";
data_header[3][2] = "20%";
data_header[3][3] = "<%=FULL_NAME %>";


data_header[4] = new Array;
data_header[4][0] = "Trade"
data_header[4][1] = "data";
data_header[4][2] = "0%";
data_header[4][3] = "<%=TRADE_ID%>";

data_header[5] = new Array;
data_header[5][0] = "Unit"
data_header[5][1] = "data";
data_header[5][2] = "0%";
data_header[5][3] = "<%=UNIT_ID%>";

data_header[6] = new Array;
data_header[6][0] = "Med Ex Type"
data_header[6][1] = "data";
data_header[6][2] = "0%";
data_header[6][3] = "medExamType";

data_header[7] = new Array;
data_header[7][0] = "Age "
data_header[7][1] = "data";
data_header[7][2] = "0%";
data_header[7][3] = "age";

data_header[8] = new Array;
data_header[8][0] = "Height"
data_header[8][1] = "data";
data_header[8][2] = "0%";
data_header[8][3] = "height";

data_header[9] = new Array;
data_header[9][0] = "Weight"
data_header[9][1] = "data";
data_header[9][2] = "0%";
data_header[9][3] = "weight";

data_header[10] = new Array;
data_header[10][0] = "IBW"
data_header[10][1] = "data";
data_header[10][2] = "0%";
data_header[10][3] = "ibw";

data_header[11] = new Array;
data_header[11][0] = "BMI"
data_header[11][1] = "data";
data_header[11][2] = "0%";
data_header[1][3] = "bmi";

data_header[12] = new Array;
data_header[12][0] = "Waist"
data_header[12][1] = "data";
data_header[12][2] = "0%";
data_header[12][3] = "waist";

data_header[13] = new Array;
data_header[13][0] = "Hip"
data_header[13][1] = "data";
data_header[13][2] = "0%";
data_header[13][3] = "hip";


data_header[14] = new Array;
data_header[14][0] = "Whr";
data_header[14][1] = "data";
data_header[14][2] = "20%";
data_header[14][3] = "whr";

data_header[15] = new Array;
data_header[15][0] = "Pulse";
data_header[15][1] = "data";
data_header[15][2] = "20%";
data_header[15][3] = "pulse";

data_header[16] = new Array;
data_header[16][0] = "BP";
data_header[16][1] = "data";
data_header[16][2] = "15%";
data_header[16][3] = "bp";

data_header[17] = new Array;
data_header[17][0] = "Med Cat";
data_header[17][1] = "data";
data_header[17][2] = "15%";
data_header[17][3] = "medCat";

data_header[18] = new Array;
data_header[18][0] = "Date "
data_header[18][1] = "hide";
data_header[18][2] = "0%";
data_header[18][3] = "<%=REPORTED_DATE %>";


data_header[19] = new Array;
data_header[19][0] = "visitid"
data_header[19][1] = "hide";
data_header[19][2] = "0%";
data_header[19][3] = "<%=VISIT_ID%>";

data_header[20] = new Array;
data_header[20][0] = "medid"
data_header[20][1] = "hide";
data_header[20][2] = "0%";
data_header[20][3] = "examId";

data_header[21] = new Array;
data_header[21][0] = "Status"
data_header[21][1] = "hide";
data_header[21][2] = "0%";
data_header[21][3] = "<%=STATUS%>";

data_header[22] = new Array;
data_header[22][0] = "Over weight"
data_header[22][1] = "data";
data_header[22][2] = "0%";
data_header[22][3] = "overWeight";

data_header[23] = new Array;
data_header[23][0] = "Obesity"
data_header[23][1] = "data";
data_header[23][2] = "0%";
data_header[23][3] = "obesity";

data_header[24] = new Array;
data_header[24][0] = "Disability"
data_header[24][1] = "data";
data_header[24][2] = "0%";
data_header[24][3] = "disability";

data_header[25] = new Array;
data_header[25][0] = "Rejected By"
data_header[25][1] = "data";
data_header[25][2] = "0%";
data_header[25][3] = "rejectedBy";
<%
int  counter=0;
if (medicalExamdetail != null && medicalExamdetail.size() > 0) { 
for(MasMedicalExaminationReportOnEntry masexam : medicalExamdetail){
	Set<MasMedicalExaminationDetail> medBoardExamDetailSet = new HashSet<MasMedicalExaminationDetail>();
	medBoardExamDetailSet = masexam.getMasmedicaldetail();
	String icdDiag="";
	for(MasMedicalExaminationDetail medBoardExamDetail :medBoardExamDetailSet)
	{
	if(medBoardExamDetail.getMasIcd() !=null && medBoardExamDetail.getParticular().equalsIgnoreCase("Detail") ){
		icdDiag=medBoardExamDetail.getMasIcd().getIcdName();
	}
	}
%>
   data_arr[<%= counter%>] = new Array(); 
   data_arr[<%= counter%>][0] = <%= masexam.getId()%>
   <%if(masexam.getDateOfCompletion()!=null){%>
   data_arr[<%= counter%>][1] = "<%=HMSUtil.changeDateToddMMyyyy(masexam.getDateOfCompletion())%>"
	   <%}else{%>
   data_arr[<%= counter%>][1] = ""   
   <%}%>
       
	   <%if(masexam.getServiceNo()!=null){%>
	   data_arr[<%= counter%>][2] = "<%= masexam.getServiceNo()%>"
		   <%}else{%>
	   data_arr[<%= counter%>][2] = ""   
	   <%}%>
	   
	   <%if(masexam.getRank()!=null){%>
	   data_arr[<%= counter%>][3] = "<%=masexam.getRank().getRankName()%>"  
		   <%}else{%>
	   data_arr[<%= counter%>][3] = ""   
	   <%}%>
	   <%if(masexam.getNameInFull()!=null){%>
	   data_arr[<%= counter%>][4] = "<%=masexam.getNameInFull()%>"
		   <%}else{%>
	   data_arr[<%= counter%>][4] = ""   
	   <%}%>
	   <%if(masexam.getTrade()!=null){%>
	   data_arr[<%= counter%>][5] = "<%=masexam.getTrade().getTradeName()%>"
		   <%}else{%>
	   data_arr[<%= counter%>][5] = ""   
	   <%}%>
	   <%if(masexam.getUnit()!=null){%>
	   data_arr[<%= counter%>][6] = "<%=masexam.getUnit().getUnitName()%>"
		   <%}else{%>
	   data_arr[<%= counter%>][6] = ""   
	   <%}%>
	   <%if(masexam.getMedicalExamType()!=null){%>
	   data_arr[<%= counter%>][7] = "<%=masexam.getMedicalExamType()%>"
		   <%}else{%>
	   data_arr[<%= counter%>][7] = ""   
	   <%}%>

	   <%if(masexam.getHin()!=null){%>
	   data_arr[<%= counter%>][8] = "<%=masexam.getHin().getAge()%>"
		   <%}else{%>
	   data_arr[<%= counter%>][8] = ""   
	   <%}%>
	   <%if(masexam.getHeight()!=null){%>
	   data_arr[<%= counter%>][9] = "<%=masexam.getHeight()%>"
		   <%}else{%>
	   data_arr[<%= counter%>][9] = ""   
	   <%}%>
	   <%if(masexam.getWeight()!=null){%>
	   data_arr[<%= counter%>][10] = "<%=masexam.getWeight()%>"
		   <%}else{%>
	   data_arr[<%= counter%>][10] = ""   
	   <%}%>

	   <%if(masexam.getIdealweight()!=null){%>
	   data_arr[<%= counter%>][11] = "<%=masexam.getIdealweight()%>"
		   <%}else{%>
	   data_arr[<%= counter%>][11] = ""   
	   <%}%>
	   <%if(masexam.getBhi()!=null){%>
	   data_arr[<%= counter%>][12] = "<%=masexam.getBhi()%>"
		   <%}else{%>
	   data_arr[<%= counter%>][12] = ""   
	   <%}%>
	   <%if(masexam.getWaist()!=null){%>
	   data_arr[<%= counter%>][13] = "<%=masexam.getWaist()%>"
		   <%}else{%>
	   data_arr[<%= counter%>][13] = ""   
	   <%}%>

	   <%if(masexam.getHips()!=null){%>
	   data_arr[<%= counter%>][14] = "<%=masexam.getHips()%>"
		   <%}else{%>
	   data_arr[<%= counter%>][14] = ""   
	   <%}%>
	   <%if(masexam.getWhr()!=null){%>
	   data_arr[<%= counter%>][15] = "<%=masexam.getWhr()%>"
		   <%}else{%>
	   data_arr[<%= counter%>][15] = ""   
	   <%}%>
	   <%if(masexam.getPulseRates()!=null){%>
	   data_arr[<%= counter%>][16] = "<%=masexam.getPulseRates()%>"
		   <%}else{%>
	   data_arr[<%= counter%>][16] = ""   
	   <%}%>

	   <%if(masexam.getBp()!=null){%>
	   data_arr[<%= counter%>][17] = "<%=masexam.getBp()%>"
		   <%}else{%>
	   data_arr[<%= counter%>][17] = ""   
	   <%}%>

	   <%if(masexam.getPresentMedicalCategory()!=null){%>
	   data_arr[<%= counter%>][18] = "<%=masexam.getPresentMedicalCategory().getCategories()%>"
		   <%}else{%>
	   data_arr[<%= counter%>][18] = ""   
	   <%}%>

	   
	   <%if(masexam.getDateOfReporting()!=null){%>
	   data_arr[<%= counter%>][19] = "<%=HMSUtil.changeDateToddMMyyyy(masexam.getDateOfReporting())%>"
		   <%}else{%>
	   data_arr[<%= counter%>][19] = ""   
	   <%}%>
	  
	   <%if(masexam.getVisit()!=null){%>
	   data_arr[<%= counter%>][20] = "<%=masexam.getVisit().getId()%>"
		   <%}else{%>
	   data_arr[<%= counter%>][20] = ""   
	   <%}%>
	   <%if(masexam.getId()!=null){%>
	   data_arr[<%= counter%>][21] = "<%=masexam.getId()%>"
		   <%}else{%>
	   data_arr[<%= counter%>][21] = ""   
	   <%}%>
	   <% if(masexam.getStatus().equals("y")){ %>
	   data_arr[<%= counter%>][22] = "Active"
	   <%}else{%>
	   data_arr[<%= counter%>][22] = "InActive"
	   <%}%>

	   <%if(masexam.getOverweight()!=null){%>
	   data_arr[<%= counter%>][23] = "<%=masexam.getOverweight()%>"
		   <%}else{%>
	   data_arr[<%= counter%>][23] = ""   
	   <%}%>
	   <%if(masexam.getSD()!=null && masexam.getSD().equalsIgnoreCase("> + 3")){%>
	   data_arr[<%= counter%>][24] = "<%=masexam.getSD()%>"
		   <%}else{%>
	   data_arr[<%= counter%>][24] = ""   
	   <%}%>
	   data_arr[<%= counter%>][25] = "<%=icdDiag%>"
<%
String rejectedBy="";
if(masexam.getStatus().equalsIgnoreCase("fr") ){
	
	rejectedBy=masexam.getMedDetailPresident().getFirstName();
	if(masexam.getMedDetailPresident().getLastName() !=null ){
		rejectedBy=rejectedBy+" "+masexam.getMedDetailPresident().getLastName();
	}
}else if(masexam.getStatus().equalsIgnoreCase("vr")){
	
}%>
		data_arr[<%= counter%>][26] = "<%=rejectedBy%>"
<%
counter++;
}
}
%>
formName ="medicalBoardStatistics"
//formName = "medicalBoardMedicalOfficersearch"
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');
</script>