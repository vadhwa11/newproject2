<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<script type="text/javascript">
function checkBlankSearch(){
	var errorMsg =""
	errorMsg=document.getElementById("hinNo").value;
	errorMsg=errorMsg+document.getElementById("serviceNo").value;
	errorMsg=errorMsg+document.getElementById("pFName").value;
	errorMsg=errorMsg+document.getElementById("pLName").value;
	errorMsg=errorMsg+document.getElementById("adNo").value;
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

<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		if(patientMap.get("inpatientList") != null){
			inpatientList= (List<Inpatient>)patientMap.get("inpatientList");
		}
		if(map.get("rankList") != null){
			rankList=(List<MasRank>)map.get("rankList");
		}
		String message = "";

		if (map.get("message") != null) {
		             message = (String) map.get("message");
		      }
		if(!message.equalsIgnoreCase("")){
		%>
<h2><%=message %></h2>
<%} %>

<div class="Clear"></div>
<div id="contentHolder">

<form name="patientSearch" action="" method="post">
<h6>Consent for Blood Transfusion Entry</h6>
<div class="Clear"></div>
<div class="blockTitle">Patient Search</div>
<div class="blockTitleCurve"></div>
<div class="blockFrame" id="testDiv">
<div class="Clear"></div>

<label class="bodytextB1">Service No</label> <input type="text"
	id="serviceNo" name="<%=SERVICE_NO %>" value="" class="textbox_size20"
	MAXLENGTH="20" /> <label>Rank</label> <select id="rankId"
	name=<%=RANK_ID %> validate="Rank,string,no">
	<option value="0">Select</option>

	<%
				         		if(rankList != null){ 	
				         			for (Iterator iter = rankList.iterator(); iter.hasNext();) {
				         				MasRank  masRank = (MasRank) iter.next();
				         %>
	<option value="<%=masRank.getId() %>"><%=masRank.getRankName()%></option>
	<%		} }%>
</select> <label class="bodytextB1">A&D No</label> <input type="text"
	name="<%=AD_NO %>" value="" class="textbox_size20" MAXLENGTH="20"
	id="adNo" />

<div class="Clear"></div>

<label class="bodytextB1">First Name</label> <input type="text"
	name="<%=P_FIRST_NAME %>" value="" class="textbox_size20"
	MAXLENGTH="15" id="pFName" /> <label class="bodytextB1">Last
Name</label> <input type="text" name="<%=P_LAST_NAME %>" value=""
	class="textbox_size20" MAXLENGTH="15" id="pLName" /> <label
	class="bodytextB1">Hin</label> <input type="text" name="<%=HIN_NO %>"
	value="" class="textbox_size20" MAXLENGTH="50" id="hinNo" />
<div class="Clear"></div>

</div>
<div class="Clear"></div>
<input type="button" name="search" id="addbutton"
	onclick="if(checkBlankSearch()){submitForm('patientSearch','/hms/hms/bloodBank?method=searchPatientForBloodTransfusion');}"
	value="Search" class="cmnButton" accesskey="a" />
<div class="Clear"></div>

</form>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<form name="searchBloodTransfusion" method="post" action=""><script
	type="text/javascript">
	formFields = [
			[0, "<%= INPATIENT_ID%>", "id"], [1,"servNo"], [2,"hin"], [3,"patName"], [4,"adNo"],[5,"rank"]];
	 statusTd = 5;
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
	data_header[1][1] = "hide";
	data_header[1][2] = "15%";
	data_header[1][3] = "hin";
	
	data_header[2] = new Array;
	data_header[2][0] = "Pateint Name"
	data_header[2][1] = "data";
	data_header[2][2] = "20%";
	data_header[2][3] = "patName";
	
	data_header[3] = new Array;
	data_header[3][0] = "AD No."
	data_header[3][1] = "data";
	data_header[3][2] = "10%";
	data_header[3][3] = "adNo"
	
	data_header[4] = new Array;
	data_header[4][0] = "Rank"
	data_header[4][1] = "data";
	data_header[4][2] = "10%";
	data_header[4][3] = "rank"

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
			<%if(inpatient.getHin().getRank() != null){%>
			data_arr[<%= counter%>][5] = "<%=inpatient.getHin().getRank().getRankName()%>"
			<%}else{%>
			data_arr[<%= counter%>][5] = "-"
			<%}%>
			
		<%
			}catch(Exception e){
				e.printStackTrace();
			}}
				     counter++;
	}
		}
		%>
		 formName = "searchBloodTransfusion"
	
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	
	makeTable(start,end);
</script>