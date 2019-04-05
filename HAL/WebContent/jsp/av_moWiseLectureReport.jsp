
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.AviAircrewMedicalLectures"%><link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
 function clearButton(formName)
  {
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/aviationMedicine?method=showMOWiseLectureDetailsReportJsp";
  obj.submit();
  }
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

<script type="text/javascript">
function check(){
var SDate = document.moWiseLectureDetailsReport.<%= FROM_DATE%>.value;
var EDate = document.moWiseLectureDetailsReport.<%= TO_DATE %>.value;
var endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))

if(startDate > endDate)
{
alert("Please ensure that the To Date is greater than or equal to the From Date.");
document.calldate.next_day.focus();
return false;
}
}
</script>
<%
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	int deptId = 0;
	if(session.getAttribute("deptId") != null){
		deptId = (Integer)session.getAttribute("deptId");
	}
	Users user = new Users();
	if(session.getAttribute("users")!=null){
		user = (Users)session.getAttribute("users");
	}
	List<MasEmployee> doctorList = null;
	List<AviAircrewMedicalLectures> medLectureList = new ArrayList<AviAircrewMedicalLectures>();

	if(map.get("doctorList") != null){
		doctorList=(List)map.get("doctorList");
		}
	if(map.get("medLectureList") != null){
		medLectureList=(List)map.get("medLectureList");
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
%>
<form name="moWiseLectureDetailsReport" method="post" action="" ><br />
<div class="titleBg"><h2>MO Wise Lecture Details</h2>
</div>
<div class="Block">
<label>From Date <span>*</span>  </label> 
<input type="text" name="<%=FROM_DATE%>" value="<%=currentDate %>" class="auto" size="20" MAXLENGTH="30" validate="From date,date,yes" readonly="readonly" id="fromDate"/>
<a	href="javascript:setdate('<%=currentDate%>',document.moWiseLectureDetailsReport.<%=FROM_DATE%>,true)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender" /> </a>
 
<label > To Date <span>*</span> </label> 
<input type="text" name="<%=TO_DATE%>" value="<%=currentDate %>" class="auto" size="20" MAXLENGTH="30"	validate="To date,date,yes" readonly="readonly" id="toDate" /> 
<a href="javascript:setdate('<%=currentDate%>',document.moWiseLectureDetailsReport.<%=TO_DATE%>,true)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" /> </a> 

<label class=""> MO Name </label> 

<select name="<%=MO_NAME %>"  id="<%=MO_NAME %>">
<option value="0">Select</option>
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
</select>
<div class="clear"></div>
</div>
<div class="clear"></div>

<div class="division"></div>

<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Search" class="button" onClick="submitForm('moWiseLectureDetailsReport','aviationMedicine?method=getLectureDetail','check()');"	accesskey="a" tabindex=1 />
<input type="button" name="clear" id="clearbutton" value="Cancel" class="button" onClick="clearButton('moWiseLectureDetailsReport');" accesskey="a" tabindex=1 />
<input type="button" name="add" id="addbutton" value="Print Summary" class="button" onClick="submitForm('moWiseLectureDetailsReport','aviationMedicine?method=generateMOLectureSummaryRpt','check()');"	accesskey="a" tabindex=1 />

<div class="clear"></div>

<div class="division"></div>

<div class="clear"></div>

</form>
<jsp:include page="searchResultBlock.jsp" />
<form name="resultPrinting" method="post" target="_blank">
<div id="searchresults" tabindex="2">
<div id="searchtable" tabindex="2"></div>
<input type="hidden" name="counta" id="counta" value="<%=medLectureList.size()%>" />
	 <script type="text/javascript">
	formFields = [[0, "lectureId", "id"],[1,"lectureNo"],[2,"<%=DATE%>"], [3,"subject"],[4,"unitId"], [5,"no_attendent"], [6,"remarks"]];
	 statusTd = 6;
	</script> 
</div>
<div class="clear"></div>
 <%
 	if(medLectureList.size() > 0){
 %>
<div class="division"></div>
<input type="button" name="add" id="addbutton" value="Print Detail" class="button" onClick="if(validateRadioForOrderNo())submitForm('resultPrinting','aviationMedicine?method=generateMOLectureDetailsRpt','check()');"	accesskey="a" tabindex=1 />
 <%} %>
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
	data_header[0][1] = "data";
	data_header[0][2] = "7%";
	data_header[0][3] = "lectureNo";
	
	data_header[1] = new Array;
	data_header[1][0] = "Date"
	data_header[1][1] = "data";
	data_header[1][2] = "15%";
	data_header[1][3] = "<%=DATE%>";
	
	data_header[2] = new Array;
	data_header[2][0] = "Subject"
	data_header[2][1] = "data";
	data_header[2][2] = "10%";
	data_header[2][3] = "subject";
	
	data_header[3] = new Array;
	data_header[3][0] = "Unit"
	data_header[3][1] = "data";
	data_header[3][2] = "20%";
	data_header[3][3] = "unitId";
	
	data_header[4] = new Array;
	data_header[4][0] = "No. attendent"
	data_header[4][1] = "data";
	data_header[4][2] = "10%";
	data_header[4][3] = "no_attendent";
	
	data_header[5] = new Array;
	data_header[5][0] = "Remarks"
	data_header[5][1] = "hide";
	data_header[5][2] = "10%";
	data_header[5][3] = "remarks";
		
	
	data_arr = new Array();
	
	    <%
	   	Iterator itr=medLectureList.iterator();
        int  counter=0;
        while(itr.hasNext())
         {          
        	AviAircrewMedicalLectures  medicalLectures = (AviAircrewMedicalLectures)itr.next(); 
	%>
				
		  		data_arr[<%= counter%>] = new Array();
		  		data_arr[<%= counter%>][0] = "<%=medicalLectures.getId()%>";
				data_arr[<%= counter%>][1] = '<input type="radio" class="radiogrid" name="parent" value="<%=medicalLectures.getId()%>" id="parent<%=counter%>"  />';
				
				data_arr[<%= counter%>][2] = "<%=HMSUtil.changeDateToddMMyyyy(medicalLectures.getAircrewDate())%>";
				<%if(medicalLectures.getLectureSubject() !=null){%>
				data_arr[<%= counter%>][3] = "<%=medicalLectures.getLectureSubject()%>"
				<%}else{%>
				data_arr[<%= counter%>][3] = "";
				<%}%>

				data_arr[<%= counter%>][4] = "<%=medicalLectures.getPlaceOfLecture()!=null ? medicalLectures.getPlaceOfLecture().getUnitName():""%>";
				<%if(medicalLectures.getNumberAttended() !=null){%>
				data_arr[<%= counter%>][5] = "<%=medicalLectures.getNumberAttended()%>";
				<%}else{%>
				data_arr[<%= counter%>][5] = "";
				<%}%>
				data_arr[<%= counter%>][6] = "";
				<%---
				<%if(medicalLectures.getRemarks() !=null){%>
				data_arr[<%= counter%>][6] = "<%=medicalLectures.getRemarks().trim()%>";
				<%}else{%>
				data_arr[<%= counter%>][6] = "";
				<%}%>--%>
		
  		<%
  			counter++;	
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

<script>

function validateRadioForOrderNo(){
	
	for(var i = 0; i < document.getElementsByName('parent').length; i++){
		if(document.getElementsByName('parent')[i].checked == true){
			return true;
		}		
		}
		alert("Please select one row");
	return false;
}

</script>
