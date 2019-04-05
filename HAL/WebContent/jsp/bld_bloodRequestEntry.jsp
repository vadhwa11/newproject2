<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<script type="text/javascript">
function checkBlankSearch(){
	var errorMsg =""
	errorMsg=document.getElementById("hinNo").value;
	errorMsg=errorMsg+document.getElementById("serviceNo").value;
	errorMsg=errorMsg+document.getElementById("pFName").value;
	errorMsg=errorMsg+document.getElementById("pLName").value;
	if(document.getElementById("rankId").value !=0)
	 errorMsg=errorMsg+document.getElementById("rankId").value;
	 if(document.getElementById("pType").value != null)
	 errorMsg=errorMsg+document.getElementById("pType").value;
	if(errorMsg==""){
		alert("Please fill any one of value...!");
		return false
	}else{
		return true
	}
}
</script>



<form name="bloodEntry" action="" method="post">
<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		if(patientMap.get("patientList") != null){
			patientList= (List<Patient>)patientMap.get("patientList");
		}
		if(map.get("rankList") != null){
			rankList=(List<MasRank>)map.get("rankList");
		}
		String message = "";
		if(map.get("message") != null){
			message= (String)map.get("message");
		}
	%> <script type="text/javascript">
	<%
		if(!message.equals("")){
			%>
			var msg = "<%=message%>";
			alert(msg);
			
		<%}
	%>
	</script>
<div id="contentHolder">
<h6>Blood Request Entry</h6>
<div class="Clear"></div>
<div class="blockTitle">Patient Search</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame"><label>HIN No.</label> <input type="text"
	name="<%=HIN_NO %>" value="" MAXLENGTH="15" id="hinNo" /> <label>Service
No.</label> <input type="text" name="<%=SERVICE_NO %>" value="" MAXLENGTH="20"
	id="serviceNo" /> <label>Patient Type</label> <select id="pType"
	name="<%=PATIENT_TYPE%>">
	<option value="">Select</option>
	<option value="In Patient">In Patient</option>
	<option value="Out Patient">Out Patient</option>
</select>
<div class="Clear"></div>

<label>Patient First Name</label> <input type="text"
	name="<%=P_FIRST_NAME %>" value="" MAXLENGTH="30" id="pFName" /> <label>Patient
Last Name</label> <input type="text" name="<%=P_LAST_NAME%>" value=""
	MAXLENGTH="30" id="pLName" /> <label>Rank</label> <select
	name="<%=RANK_ID %>" id="rankId">
	<option value="0">Select</option>
	<% 
			for(MasRank masRank : rankList){
			%>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%	}	%>
</select>
<div class="Clear"></div>


</div>
<div class="Clear"></div>
<input type="button" name="search" id="addbutton" value="Search"
	class="cmnButton"
	onclick="if(checkBlankSearch()){submitForm('bloodEntry','/hms/hms/bloodBank?method=searchPatientForBloodRequest');}"
	accesskey="a" />
</form>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<form name="bloodRequestEntry" method="post" action=""><script
	type="text/javascript">
	formFields = [
			[0, "hinId", "id"], [1,"servNo"], [2,"hin"], [3,"patName"], [4,"pType"],[5,"rank"]];
	 statusTd = 5;
	</script></form>
</div>

</div>
<script type="text/javascript" language="javascript">
	
	data_header = new Array();
	
	
	data_header[0] = new Array;
	data_header[0][0] = "Service No"
	data_header[0][1] = "data";
	data_header[0][2] = "7%";
	data_header[0][3] = "servNo"
	
	data_header[1] = new Array;
	data_header[1][0] = "Hin"
	data_header[1][1] = "data";
	data_header[1][2] = "15%";
	data_header[1][3] = "hin";
	
	data_header[2] = new Array;
	data_header[2][0] = "Patient Name"
	data_header[2][1] = "data";
	data_header[2][2] = "20%";
	data_header[2][3] = "patName";
	
	data_header[3] = new Array;
	data_header[3][0] = "P Type"
	data_header[3][1] = "data";
	data_header[3][2] = "10%";
	data_header[3][3] = "pType"

data_header[4] = new Array;
	data_header[4][0] = "Rank"
	data_header[4][1] = "data";
	data_header[4][2] = "10%";
	data_header[4][3] = "rank"
	data_arr = new Array();	
	<%
		
	    int  counter=0;
		if (patientList != null && patientList.size() > 0) { %>
	
	<% 	for(Patient patient : patientList){
	
	%>
data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= patient.getId()%>
			data_arr[<%= counter%>][1] = "<%=patient.getServiceNo()%>"
			data_arr[<%= counter%>][2] = "<%=patient.getHinNo()%>"
			<%try{%>
			data_arr[<%= counter%>][3] = "<%=patient.getPFirstName()%> <%=patient.getPLastName()%> "
			data_arr[<%= counter%>][4] = "<%=patient.getPatientStatus()%>"
			<%if(patient.getRank()!=null){%>
			data_arr[<%= counter%>][5] = "<%=patient.getRank().getRankName()%>"
			<%}else{%>
			data_arr[<%= counter%>][5] = "-"
			<%}%>
			
		<%
			}catch(Exception e){
				e.printStackTrace();
			}
				     counter++;
			}
			}
		%>
		 formName = "bloodRequestEntry"
	
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	
	makeTable(start,end);
</script>