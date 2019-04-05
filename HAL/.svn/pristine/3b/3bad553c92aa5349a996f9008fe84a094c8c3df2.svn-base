<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>

<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%>
<%@page import="jkt.hms.masters.business.MasCommand"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.Disability"%>
<%@page import="jkt.hms.masters.business.Disabilitygroup"%>
<%@page import="jkt.hms.masters.business.Category"%>
<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>

<link href="/hms/jsp/css/test.css" rel="stylesheet" type="text/css" />
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

	if (map.get("patientDetailList") != null) {
		medicalExamdetail = (List) map.get("patientDetailList");
	}
	
	
	List<MasEmployee> patientList = new ArrayList<MasEmployee>();

	if (map.get("patientList") != null) {
		patientList = (List) map.get("patientList");
		System.out.println("patientList jsp--"+patientList.size());
	}
	List<MasCommand> commandList = null;
	List<Object[]> unitList = null;
	List<MasTrade> tradeList = null;
	List<Disability> DisabilityList = null;
	List<Disabilitygroup> DisabilitygroupList = null;
	List<Category> CategoryList = null;
	List<MasBloodGroup> bloodGroupList = null;
	if(map.get("commandList") != null){
					commandList = (List<MasCommand>)map.get("commandList");
				}
	if(map.get("unitList") != null){
					unitList= (List<Object[]>)map.get("unitList");
				}
	if(map.get("tradeList") != null){
					tradeList = (List<MasTrade>)map.get("tradeList");
				}
	if(map.get("DisabilityList") != null){
		DisabilityList = (List<Disability>)map.get("DisabilityList");
		System.out.println("DisabilityList----"+DisabilityList.size());
	}
	if(map.get("DisabilitygroupList") != null){
		DisabilitygroupList = (List<Disabilitygroup>)map.get("DisabilitygroupList");
	}
	if(map.get("CategoryList") != null){
		CategoryList = (List<Category>)map.get("CategoryList");
	}
	if(map.get("bloodGroupList") != null){
		bloodGroupList = (List<MasBloodGroup>)map.get("bloodGroupList");
	}
%>

<%
	if (map.get("message") != null) {
		message = (String) map.get("message");

	}
String searchtype=null;

        
	if (map.get("searchtype") != null) {
		searchtype = (String) map.get("searchtype");
		System.out.println("searchtype---"+searchtype);
	}
        %>
        <script	type="text/javascript" language="javascript">
function PrintGraph()
{
var url="/hms/hms/medicalBoard?method=medicalBoardReports&searchtype=graphInjsp";
newwindow=window.open(url,"left=2,top=100,height=700,width=1010,status=1,scrollbars=1,resizable=0");
}
function createSillyWindow()
{
	//window.open("about:blank", "mySillyWindow","left=2,top=100,height=700,width=1010,status=1,scrollbars=1,resizable=0");
}

function submitOne()
{
	var xmlHttp;
	alert("1 ");
  try {
    // Firefox, Opera 8.0+, Safari
    xmlHttp=new XMLHttpRequest();
  }catch (e){
    // Internet Explorer
    try{
      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
    }catch (e){
      try{
        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
      }catch (e){
        alert("Your browser does not support AJAX!");
        return false;
      }
     }
   }
  alert("2");
    xmlHttp.onreadystatechange=function()
    {
    if (xmlHttp.readyState>0 && xmlHttp.readyState<4){
     document.getElementById(tab).innerHTML='<font id="error">Loading...</font>'
      document.getElementById(tab).innerHTML=""
    }else
      if(xmlHttp.readyState==4){
         document.getElementById(tab).innerHTML = xmlHttp.responseText;
        
      }
    }
    alert("3-1");
    var so = new SWFObject("/hms/jsp/chart/amcolumn.swf", "amcolumn", "290", "230", "8", "#FFFFFF");
    alert("3-2");
	so.addVariable("path", "/hms/jsp/chart/");
	 alert("3-3");
	so.addVariable("settings_file", encodeURIComponent("/hms/jsp/chart/amcolumn_settings.xml"));
	 alert("3-4");
	so.addVariable("data_file",  encodeURIComponent("/hms/jsp/chart/amcolumn_data.xml"));
	so.addVariable("preloader_color", "#999999");
	so.write("flashcontent");
	alert("4");
	
	xmlHttp.open("GET","/hms/hms/medicalBoard?method=medicalBoardReports&searchtype=graphInjsp",true);
    
	xmlHttp.send(document.patientSearch);
	alert("5");
	
//	document.patientSearch.action = "/hms/hms/medicalExam?method=pendingMDWatingList&searchtype=graphInjsp";
//	document.patientSearch.submit();
//	createSillyWindow();
}

</script>
       <%
	
	if (!message.equalsIgnoreCase("")) {
%>
<h4><%=message%></h4>
<%
	}
%>
<script
	type="text/javascript" language="javascript">
function SetInterval()
		{
        var  curr1=new Date();
	     	
		var interval=document.getElementById("IntervalId").value;
		var serviceStartDate=document.getElementById('IntervalTo').value;
		var elem = serviceStartDate.split('/');
		var currDay1 = elem[0];
		var monthNow1 = elem[1];
		var yearNow1 = elem[2];
		
		
		if(interval=="12")
		{
			
			 yearNow1 = parseInt(yearNow1) - 1;
			
		}else if(interval=="4"){
			monthNow1=monthNow1-4;
			if(monthNow1<0)
			{
				monthNow1=0;
				 yearNow1 = parseInt(yearNow1)- 1;
				
			}
		}else{
			
			monthNow1 = parseInt(monthNow1)- 1;
			if(monthNow1>12)
			{
				monthNow1=0;
				yearNow1 = parseInt(yearNow1)+ 1;
			}
		}
		if(monthNow1.toString().length<2){
			monthNow1="0"+monthNow1;
		}
		if(currDay1.toString().length<2){
			currDay1="0"+currDay1;
		}
		  var   currDateStr   = currDay1 + "/" + monthNow1 + "/" + yearNow1;
	     document.getElementById("IntervalFrom").value=currDateStr;
	      
			
	  }

</script>

<h4>Search By Any Field Name</h4>
<form name="patientSearch" action="" method="post" target="_blank" >
<div class="Block">
 
<label>Choose Disability</label> 
<select name="typeOfCommunication" size="0" tabindex="1" id="typeOfCommunication">
<option value="0">select</option>
	<option value="PC">PC</option>
	<option value="SSC">SSC</option>
	
</select>
<div class="Clear"></div>
<label>Disabilities(%)</label> 
<select id="disabilityid" name="disabilityId" class="large" tabindex="1" validate="Unit,string,no"  >

<option value="0">Select</option>
		<%
			if(DisabilityList!=null && DisabilityList.size() > 0){
				for(Disability Disability : DisabilityList){
		%>
		<option value="<%= Disability.getDisabilityid() %>"><%=Disability.getDisability() %></option>
		<%
				}
				} %>
				</select>

<div class="Clear"></div>

<label>Disability Group (%)</label> 

<select id="disabilityid" name="disabilityGroupId" tabindex="1" validate="Unit,string,no"  >
<option value="0">Select</option>
		<%
			if(DisabilitygroupList!=null && DisabilitygroupList.size() > 0){
				for(Disabilitygroup Disabilitygroup : DisabilitygroupList){
		%>
		<option value="<%= Disabilitygroup.getGroupid() %>"><%=Disabilitygroup.getDiseaseGroups() %></option>
		<%
				}
				} %>
				</select>

<div class="clear"></div>
 
<label>Age</label>
<label class="auto">From</label> <input	name="AgeFrom" class="small" id="bp" type="text" tabindex="1" maxlength="7" />
<label  class="auto">To</label>
 <input	name="<%=TO %>" id="bp" type="text" class="small" tabindex="1"   maxlength="7" />
 
 <fieldset>
<legend>Weight Details</legend> 
<label>Ideal Wt.</label>
<select id="searchField2"	name="<%=WEIGHT %>" tabindex="1" class="small" >
	<option value="0">Select</option>
	<%
		for (int i=1;i<100 ;i++) {
	%>
	<option value="<%=i%>"><%=i%></option>
	<%
		}
	%>
	</select>
<label>Co-morbidity</label>
<select id="searchField2" 	name="<%=WEIGHT %>" tabindex="1" class="small">
	<option value="0">Select</option>
	<%
		for (int i=1;i<100 ;i++) {
	%>
	<option value="<%=i%>"><%=i%></option>
	<%
		}
	%>
	</select>

<label>Life Style Factors</label>
<select id="searchField2"	name="LifeStyleFactor" tabindex="1" class="small">
	<option value="0">Select</option>
	<%
		for (int i=1;i<4 ;i++) {
	%>
	<option value="<%=i%>"><%=i%></option>
	<%
		}
	%>
	</select>
<label>Blood Group</label>
<select id="searchField2"	name="<%=BLOOD_GROUP_ID %>" tabindex="1" class="small">
	<option value="0">Select</option>
	<%
		for (MasBloodGroup  MasBloodGr : bloodGroupList ) {
	%>
	<option value="<%=MasBloodGr.getId()%>"><%=MasBloodGr.getBloodGroupName()%></option>
	<%
		}
	%>
	</select>
	</fieldset>
<div class="clear"></div>
<label>Gender</label> 
<select name="Gender" size="0" tabindex="1" id="GenderId">
<option value="">select</option>
	<option value="Male">Male</option>
	<option value="Female">Female</option>
	
</select>

<!-- 
<label class="auto">Male</label>
<input  type="radio" name="group1" value="Male" class="radioAuto"/>
<label  class="auto">Female</label>
<input type="radio" name="group1" value="Female"  class="radioAuto"/> 
<label  class="auto">Both</label>
<input type="radio" name="group1" value="Both_Sex" checked class="radioAuto"/>
 
<label>Period</label>
<label class="auto">Permanent</label>
<input  type="radio" name="group2" value="Permanent" class="radioAuto"/>
<label class="auto">Temporary</label>
<input type="radio" name="group2" value="temporary"  class="radioAuto"/> 
<label class="auto">Both</label>
<input type="radio" name="group2" value="Both_Period" checked class="radioAuto"/>
 -->
<fieldset>
<input type="checkbox" name="SearchOverDue" class="radioAuto" value="Search Over Due" />
 <label> Search Over Due </label> 
 <div class="clear"></div>
<input type="checkbox" name="WithDisability"  class="radioAuto" value="With Disability" />
<label> With Disability </label>   
</fieldset>
<div class="clear"></div>

<fieldset class="small"><legend>Search Waiver</legend><label class="auto">Select Waiver </label> 
<select name="Waiver" size="0" tabindex="1" id="typeOfCommunication">
<option value="0">select</option>
	<option value="PC">PC</option>
	<option value="SSC">SSC</option>
	
</select>

<div class="clear"></div><label>&nbsp;<br></label><div class="clear"></div>
<label>&nbsp;<br></label><div class="clear"></div>
<input type="button" name="Search"	value="Print" tabindex="1" class="buttonGraph" accesskey="a" onclick="submitForm('patientSearch','medicalBoard?method=medicalBoardReports&searchtype=graph');"/>
<input type="button" name="Search"	value="PrintGraph" tabindex="1" class="buttonGraph" accesskey="a" onclick="submitForm('patientSearch','medicalBoard?method=medicalBoardReports&searchtype=graphInjsp');"/>

</fieldset>

<fieldset class="small">
<legend>Trend Analysis</legend>
<label class="auto">Trend Analysis</label>  
	<input type="checkbox" name="TrendAnalysis" value="Trend Analysis" class="radioAuto"/>
	<div class="Clear"></div>
	<label class="medium">From  </label> 
	<input tabindex="1" type="text"	name="IntervalFrom" class="calDate" maxlength="10"  id="IntervalFrom" value=<%=currentDate %>
		onKeyUp="mask(this.value,this,'2,5','/');" 	validate="Reported Date,date,no" /> 
<img src="/hms/jsp/images/cal.gif"
		width="16" height="16" border="0" validate="Pick a date"
		class="calender"
		onclick="setdate('',patientSearch.IntervalFrom,event);" />
		<div class="clear"></div>
	 <label class="medium">To  </label> 
	 <input tabindex="1" type="text" id="IntervalTo"	name="IntervalTo" class="calDate" maxlength="10"  value=<%=currentDate %>
		onKeyUp="mask(this.value,this,'2,5','/');" 	validate="Reported Date,date,no" /> 
<img src="/hms/jsp/images/cal.gif"
		width="16" height="16" border="0" validate="Pick a date"
		class="calender"
		onclick="setdate('',patientSearch.IntervalTo,event);" />
	<div class="clear"></div>
	<label class="medium">Interval </label> 
	<select name="Interval" size="0" tabindex="1" id="IntervalId" onchange="SetInterval()">
	<option value="0">select</option>
	<option value="12">Annualy</option>
	<option value="4">Quarterly</option>
	<option value="1">Monthly</option>
	</select>

</fieldset>
<div class="leftPlace">
<label>Category</label> 
<select id="disabilityid" name="CategoryId" tabindex="1" validate="Unit,string,no"  >
<option value="">Select</option>
		<%
			if(CategoryList.size() > 0){
				for(Category Category : CategoryList){
		%>
		<option value="<%=Category.getCategories() %>"><%=Category.getCategories() %></option>
		<%
				}
				} %>
				</select>
					<div class="clear"></div>
<label>Command</label>
<select id="commandId" name="<%=COMMAND %>"  validate="Command,string,no" tabindex="1" onchange="populateStation('registration');displayOtherCmd(this.value);">
		<option value="0">Select</option>
		<%
			if(commandList.size() > 0){
				for(MasCommand command : commandList){
		%>
		<option value="<%= command.getId() %>"><%=command.getCommandName() %></option>
		<%
				}
				} %>
<option value="other">Other</option>	
</select>
	<div class="clear"></div>
<label>Unit</label>
<select id="unitId" name="<%=UNIT_ID %>" tabindex="1" validate="Unit,string,no" onchange="displayOtherUnit(this.value)" >
<option value="0">Select</option>
			 <%
					 for(Object[] masUnit : unitList){
					
					 %>
						<option value="<%=masUnit[0]%>"><%=masUnit[1]%></option>
					 
					<%
					 }%>	
<option value="other">Other</option>
</select>
	<div class="clear"></div>
<label > Trade/Branch</label>
<select id="tradeId" name="<%=TRADE_ID%>"  validate="Trade,string,no" tabindex="1"  onchange="displayOtherTrade(this.value);">
			<option value="0">Select</option>
			<%for(MasTrade trade :tradeList){ %>
					<option value=<%=trade.getId()%>><%=trade.getTradeName() %></option>
			<%} %>
	<option value="other">Other</option>		
</select>
	<div class="clear"></div>
 <label>Rank </label> <select id="searchField2"
	name="<%=RANK_ID %>" tabindex="1" class="select_adt">
	<option value="0">Select</option>
	<%
		for (MasRank masRank : rankList) {
	%>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%
		}
	%>
	</select>
		<div class="clear"></div>
 <label>Date As On </label>
	<input tabindex="1" type="text"	name="DateAson" class="calDate" maxlength="10" 
		onKeyUp="mask(this.value,this,'2,5','/');" 	validate="Reported Date,date,no" /> 
<img src="/hms/jsp/images/cal.gif"
		width="16" height="16" border="0" validate="Pick a date"
		class="calender"
		onclick="setdate('',patientSearch.DateAson,event);" />
	</div>	
		
	<div class="clear"></div>




</div>
</form>

<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<form name="medicalBoardMedicalOfficersearch" method="post"	action="">
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<script type="text/javascript">
	formFields = [ [0,"medExamid","id"],[1,"<%= SERVICE_NO%>"], [2,"<%= RANK%>"], [3,"<%= FULL_NAME %>"], [4,"<%= UNIT %>"], [5,"<%=RANK_ID%>"], [6,"<%= STATUS %>"],  [7,"<%=STATUS%>"], [8,"<%=STATUS%>"], [9,"visitId"], [10,"medExamType"] ,[11,"medExamIdForUpdate"]];
	 statusTd = 11;
	</script>

</div>
</form>
<div class="clear"></div>
<div class="division"></div>
<input type="button" name="Search"	onclick="submitForm('patientSearch','medicalBoard?method=medicalBoardReports');"	value="Search" tabindex="1" class="button" accesskey="a" />

<input type="button" name="Refresh"	value="Refresh" tabindex="1" class="button" accesskey="a" />
<input type="button" name="Print"	value="Print" tabindex="1" class="button" accesskey="a" />
<div class="clear"></div>
<div class="division"></div>

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
data_header[1][0] = "Date oF Cat "
data_header[1][1] = "data";
data_header[1][2] = "0%";
data_header[1][3] = "<%=STATUS %>";

data_header[2] = new Array;
data_header[2][0] = "Rank";
data_header[2][1] = "data";
data_header[2][2] = "15%";
data_header[2][3] = "<%= RANK %>";

data_header[3] = new Array;
data_header[3][0] = "Name";
data_header[3][1] = "data";
data_header[3][2] = "15%";
data_header[3][3] = "<%=FULL_NAME%>";

data_header[4] = new Array;
data_header[4][0] = " Branch  "
data_header[4][1] = "data";
data_header[4][2] = "20%";
data_header[4][3] = "<%=UNIT %>";

data_header[5] = new Array;
data_header[5][0] = "Diseases Group";
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%= RANK_ID %>";

data_header[6] = new Array;
data_header[6][0] = "Cat"
data_header[6][1] = "data";
data_header[6][2] = "0%";
data_header[6][3] = "<%=STATUS %>";

data_header[7] = new Array;
data_header[7][0] = "Perm Temp"
data_header[7][1] = "data";
data_header[7][2] = "0%";
data_header[7][3] = "<%=STATUS %>";



data_header[8] = new Array;
data_header[8][0] = "medical Exam Type"
data_header[8][1] = "hide";
data_header[8][2] = "0%";
data_header[8][3] = "medExamType";

data_header[9] = new Array;
data_header[9][0] = "medical Exam Type"
data_header[9][1] = "hide";
data_header[9][2] = "0%";
data_header[9][3] = "medExamIdForUpdate";  
<%
int  counter=0;
if (medicalExamdetail != null && medicalExamdetail.size() > 0) { 
for(MasMedicalExaminationReportOnEntry masexam : medicalExamdetail){
%>
   data_arr[<%= counter%>] = new Array();
  
  
   
  
          data_arr[<%= counter%>][0] = <%= masexam.getId()%>
	   <%if(masexam.getServiceNo()!=null){%>
	   data_arr[<%= counter%>][1] = "<%= masexam.getYearlySerialNo()%>"
		   <%}else{%>
	   data_arr[<%= counter%>][1] = ""   
	   <%}%>
	   <%if(masexam.getDateOfReporting()!=null){%>
	   data_arr[<%= counter%>][2] = "<%=masexam.getDateOfReporting()%>"
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
		   <%if(masexam.getPastmedicalhistory()!=null){%>
	   data_arr[<%= counter%>][6] = "<%=masexam.getPastmedicalhistory()%>"
		   <%}else{%>
	   data_arr[<%= counter%>][6] = ""   
	   <%}%>
	   <%if(masexam.getPresentMedicalCategory()!=null){%>
	   data_arr[<%= counter%>][7] = "<%=masexam.getPresentMedicalCategory().getCategories()%>"
		   <%}else{%>
	   data_arr[<%= counter%>][7] = ""   
	   <%}%>
	   
	  
	   <%if(masexam.getVisit()!=null){%>
	   data_arr[<%= counter%>][8] = "<%=masexam.getVisit().getId()%>"
		   <%}else{%>
	   data_arr[<%= counter%>][8] = ""   
	   <%}%>
	   <%if(masexam.getMedicalExamType()!=null){%>
	   data_arr[<%= counter%>][9] = "<%=masexam.getMedicalExamType()%>"
		   <%}else{%>
	   data_arr[<%= counter%>][9] = ""   
	   <%}%>
	   data_arr[<%= counter%>][9] = "<%=masexam.getId()%>"   
<%
counter++;
}
}
%>
formName = "medicalBoardMedicalOfficersearch"
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
