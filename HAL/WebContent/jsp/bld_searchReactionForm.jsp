<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<script type="text/javascript">
function checkBlankSearch(){
	var errorMsg =""
	errorMsg=document.getElementById("hinNo").value;
	errorMsg=errorMsg+document.getElementById("serviceNo").value;
	errorMsg=errorMsg+document.getElementById("pFName").value;
	errorMsg=errorMsg+document.getElementById("pLName").value;
	errorMsg=errorMsg+document.getElementById("adNo").value;
	if(document.getElementById("departmentId").value !=0)
	 errorMsg=errorMsg+document.getElementById("departmentId").value;
	if(errorMsg==""){
		alert("Please fill any one of value...!");
		return false
	}else{
		return true
	}
}
</script>


<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<MasDepartment> wardList = new ArrayList<MasDepartment>();
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		if(patientMap.get("inpatientList") != null){
			inpatientList= (List<Inpatient>)patientMap.get("inpatientList");
		}
		if(map.get("wardList") != null){
			wardList=(List<MasDepartment>)map.get("wardList");
		}
		
		String serviceNoOrHinNo ="";
		String message = "";
		String deptType = "";
		int hinId=0;
		if(map.get("message") != null){
			message= (String)map.get("message");
		}
		if (map.get("deptType") != null) {
			deptType = (String) map.get("deptType");
		}

	if (map.get("message") != null) {
	             message = (String) map.get("message");
	      }
	if(!message.equalsIgnoreCase("")){
	%>
<h2><%=message %></h2>
<%} %>
<div id="contentHolder">
<form name="bloodEntry" action="" method="post">
<h6>Blood Reaction Form Entry</h6>
<div class="Clear"></div>
<div class="blockTitle">Patient Search</div>
<div class="blockTitleCurve"></div>

<div class="blockFrame"><label>HIN No.</label> <input type="text"
	name="<%=HIN_NO %>" value="" class="textbox_size20" MAXLENGTH="50"
	id="hinNo" /> <label>Service No.</label> <input type="text"
	name="<%=SERVICE_NO %>" value="" class="textbox_size20" MAXLENGTH="20"
	id="serviceNo" /> <label>A&D No.</label> <input type="text"
	name="<%=AD_NO %>" value="" class="textbox_size20" MAXLENGTH="20"
	id="adNo" />

<div class="Clear"></div>
<label>Patient First Name</label> <input type="text"
	name="<%=P_FIRST_NAME %>" value="" class="textbox_size20"
	MAXLENGTH="15" id="pFName" /> <label>Patient Last Name</label> <input
	type="text" name="<%=P_LAST_NAME%>" value="" class="textbox_size20"
	MAXLENGTH="15" id="pLName" /> <label>Ward</label> <select
	id="departmentId" name="<%=DEPARTMENT_ID %>" id="departmentId">
	<option value="0">Select Department</option>
	<% 
			for(MasDepartment masDepartment : wardList){
			%>
	<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>
	<%	}	%>
</select>
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<input type="button" name="search" id="addbutton"
	onclick="if(checkBlankSearch()){submitForm('bloodEntry','/hms/hms/bloodBank?method=searchPatientForBloodReaction');}"
	value="Search" class="cmnButton" accesskey="a" /></form>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<form name="searchReactionEntry" method="post" action=""><script
	type="text/javascript">
	formFields = [
			[0, "inpatientId", "id"], [1,"servNo"], [2,"hin"], [3,"patName"], [4,"adNo"]];
	 statusTd = 4;
	</script></form>
</div>
<div class="Clear"></div>
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
	data_header[3][0] = "A&D No"
	data_header[3][1] = "data";
	data_header[3][2] = "10%";
	data_header[3][3] = "adNo"

	data_arr = new Array();	
	<%
		
	    int  counter=0;
	if (inpatientList != null && inpatientList.size() > 0) { %>
	<% 	for(Inpatient inpatient : inpatientList){
		 if(inpatient.getAdStatus().equalsIgnoreCase("A") || inpatient.getAdStatus().equalsIgnoreCase("R"))
   	  {
		
	%>
			data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= inpatient.getId()%>
			data_arr[<%= counter%>][1] = "<%=inpatient.getHin().getServiceNo()%>"
			data_arr[<%= counter%>][2] = "<%=inpatient.getHin().getHinNo()%>"
			<%try{%>
			data_arr[<%= counter%>][3] = "<%=inpatient.getHin().getPFirstName()%> <%=inpatient.getHin().getPLastName()%> "
			data_arr[<%= counter%>][4] = "<%=inpatient.getAdNo()%>"
		<%
			}catch(Exception e){
				e.printStackTrace();
			}
   	  }
				     counter++;
			}
			}
		%>
		 formName = "searchReactionEntry"
	
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	
	makeTable(start,end);
</script>