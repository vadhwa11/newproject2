
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MdSpecialInvestigationHd"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>

<script type="text/javascript">
function checkBlankSearch(){
	var errorMsg =""
	errorMsg=document.getElementById("hinNo").value;
	errorMsg=errorMsg+document.getElementById("serviceNo").value;
	errorMsg=errorMsg+document.getElementById("pFName").value;
	errorMsg=errorMsg+document.getElementById("pLName").value;
	//errorMsg=errorMsg+document.getElementById("sPerFName").value;
	//errorMsg=errorMsg+document.getElementById("sPerLName").value;
	//if(document.getElementById("pType").value !=0)
	//errorMsg=errorMsg+document.getElementById("pType").value;
	if(document.getElementById("rankId").value !=0)
	errorMsg=errorMsg+document.getElementById("rankId").value;
	if(errorMsg==""){
		alert("Please fill any one of value...!");
		return false
	}else{
		return true
	}
}
</script>
<script>
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

<form name="patientSearch" action="" method="post">
<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MdSpecialInvestigationHd> patientList = new ArrayList<MdSpecialInvestigationHd>();
		
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");  
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		if(map.get("rankList") != null){
			rankList= (List<MasRank>)map.get("rankList");
		}
		if(patientMap.get("patientList") != null){
			patientList= (List<MdSpecialInvestigationHd>)patientMap.get("patientList");
		}
		String message="";
		if (map.get("message") != null) {
	             message = (String) map.get("message");
	      }
			if(!message.equalsIgnoreCase("")){
				%>
<h4><%=message %></h4>
<div class="Clear"></div>
<%} %>

<div class="titleBg">
<h2>Update Request for Special Investigation Entry</h2>
</div>
<div class="Block">
<h4>Patient Search</h4>
<div class="Clear"></div>
<label>Service No.</label> 
<input	id="serviceNo" type="text" name="<%=SERVICE_NO %>" value=""	MAXLENGTH="20" /> 
	
<label>Hin</label> 
<input id="hinNo" type="text"	name="<%=HIN_NO %>" value="" MAXLENGTH="15" /> 

<label>First Name</label>
<input id="pFName" type="text" name="<%=P_FIRST_NAME %>" value="" MAXLENGTH="30" />

<div class="Clear"></div>

<label>Last Name</label> 
<input id="pLName" type="text" name="<%=P_LAST_NAME%>" value="" MAXLENGTH="30" /> 

<%--
<label>Ser. First Name</label> 
<input id="sPerFName" type="text" name="<%=S_FIRST_NAME %>" value="" MAXLENGTH="30" />

<label>Ser. Last Name</label> 
<input	id="sPerLName" type="text" name="<%=S_LAST_NAME%>" value="" MAXLENGTH="30" />
 --%>
 


<label>Rank</label> <select id="rankId" name="<%=RANK_ID %>">
	<option value="0">Select Rank</option>
	<% for(MasRank masRank : rankList){%>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%}	%>
</select>
</div>
<%--
 <label>Patient Status</label> <select id="pType"
	name="<%=PATIENT_STATUS %>">
	<option value="0">Select</option>
	<option value="In Patient">IP</option>
	<option value="Out Patient">OP</option>
</select> 
 --%>

<div class="clear paddingTop10"></div>
<div class="division"></div>
<div class="clear paddingTop10"></div>

<input type="button" name="Submit" onclick="if(checkBlankSearch()){submitForm('patientSearch','/hms/hms/mediClaim?method=showPatientUpdateSpecialInv');}"	
value="Search" class="button" accesskey="a" />


</form>


<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<form name="searchUpdateSpecialInvestigation" method="post" action="">
<script type="text/javascript">
	formFields = [
			[0, "specInvHdId", "id"], [1,"servNo"], [2,"hin"], [3,"patName"], [4,"rank"], [5,"sPersonName"]];
	 statusTd = 5;
</script></form>

</div>
<script type="text/javascript" language="javascript">
	
	data_header = new Array();
	
	
	data_header[0] = new Array;
	data_header[0][0] = "Service No."
	data_header[0][1] = "data";
	data_header[0][2] = "7%";
	data_header[0][3] = "servNo"
	
	data_header[1] = new Array;
	data_header[1][0] = "HIN"
	data_header[1][1] = "hide";
	data_header[1][2] = "15%";
	data_header[1][3] = "hin";
	
	data_header[2] = new Array;
	data_header[2][0] = "Patient Name"
	data_header[2][1] = "data";
	data_header[2][2] = "20%";
	data_header[2][3] = "patName";
	
	data_header[3] = new Array;
	data_header[3][0] = "Rank"
	data_header[3][1] = "data";
	data_header[3][2] = "10%";
	data_header[3][3] = "rank"
	
	data_header[4] = new Array;
	data_header[4][0] = "Name"
	data_header[4][1] = "data";
	data_header[4][2] = "15%";
	data_header[4][3] = "sPersonName";
	
	data_arr = new Array();
	<%
		
	    int  counter=0;
		if (patientList != null && patientList.size() > 0) { 
			 
		%>
	
	<% 	for(MdSpecialInvestigationHd specialInvestigationHd : patientList){
	%>
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%=specialInvestigationHd.getId()%>
			data_arr[<%= counter%>][1] = "<%=specialInvestigationHd.getHin().getServiceNo()%>"
			data_arr[<%= counter%>][2] = "<%=specialInvestigationHd.getHin().getHinNo()%>"
			<%
					String middleName = "";
					String lastName = "";
					if(specialInvestigationHd.getHin().getPMiddleName() != null){
						middleName = specialInvestigationHd.getHin().getPMiddleName();
					}
					if(specialInvestigationHd.getHin().getPLastName() != null){
						lastName = specialInvestigationHd.getHin().getPLastName();
					}
					
					%>
			data_arr[<%= counter%>][3] = "<%=specialInvestigationHd.getHin().getPFirstName()%> <%=middleName%> <%=lastName%>"
			data_arr[<%= counter%>][4] = "<%=specialInvestigationHd.getHin().getRank().getRankName()%> "
			<%
			if(specialInvestigationHd.getHin().getSFirstName() != null  && !(specialInvestigationHd.getHin().getSFirstName().equals(""))){
				
				String sMiddleName = "";
				String sLastName = "";
				if(specialInvestigationHd.getHin().getSMiddleName() != null){
					sMiddleName = specialInvestigationHd.getHin().getSMiddleName();
				}
				if(specialInvestigationHd.getHin().getSLastName() != null){
					sLastName = specialInvestigationHd.getHin().getSLastName();
				}
				String sName = specialInvestigationHd.getHin().getSFirstName()+" "+sMiddleName+" "+sLastName;
			%>
				data_arr[<%= counter%>][5] = "<%=sName%>"
				<%}else{%>
				data_arr[<%= counter%>][5] = ""
				<%}%>
		<%
				
				     counter++;
	}
		    	}
		%>
		
    formName = "searchUpdateSpecialInvestigation"
	
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	
	makeTable(start,end);
	
		
	</script>
