<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.BloodDonationEntryHeader"%>
<script type="text/javascript">
function checkBlankSearch(){
	var errorMsg =""
	errorMsg=document.getElementById("hinNo").value;
	errorMsg=errorMsg+document.getElementById("serviceNo").value;
	errorMsg=errorMsg+document.getElementById("pFName").value;
	if(errorMsg==""){
		alert("Please fill any one of value...!");
		return false
	}else{
		return true
	}
}
</script>

<form name="bloodEntry" action="" method="post">
<div id="contentHolder">
<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		List<BloodDonationEntryHeader> donorList = new ArrayList<BloodDonationEntryHeader>();
		int bloodDonationId=0;
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		if(patientMap.get("donorList") != null){
			donorList= (List<BloodDonationEntryHeader>)patientMap.get("donorList");
		}
		if(map.get("bloodDonationId") != null){
			bloodDonationId=(Integer)map.get("bloodDonationId");
		}
		String message = "";
		String deptType = "";
		int hinId=0;
		if(map.get("message") != null){
			message= (String)map.get("message");
		}
		if (map.get("deptType") != null) {
			deptType = (String) map.get("deptType");
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
<h6>Donor Search</h6>
<div class="Clear"></div>
<div class="blockFrame"><label>Donation No.</label> <input
	type="text" name="<%=DONATION_NO %>" value="" MAXLENGTH="50" id="hinNo" />

<label>Service No.</label> <input type="text" name="<%=SERVICE_NO %>"
	value="" MAXLENGTH="20" id="serviceNo" /> <label>Donor Name</label> <input
	type="text" name="<%=DONER_NAME %>" value="" MAXLENGTH="15" id="pFName" />

</div>
<div class="Clear"></div>
<input type="button" name="search" id="addbutton"
	onclick="submitForm('bloodEntry','/hms/hms/bloodBank?method=searchPatientForUpdateDonation');"
	value="Search" class="cmnButton" accesskey="a" />
</form>

<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<form name="searchBloodDonor" method="post" action=""><script
	type="text/javascript">
	formFields = [
			[0, "bloodDonationId", "id"], [1,"donationNo"], [2,"serviceNo"], [3,"donorName"]];
	 statusTd = 3;
	</script></form>
</div>
<div class="Clear"></div>
</div>
<script type="text/javascript" language="javascript">
	
	data_header = new Array();
	
	
	data_header[0] = new Array;
	data_header[0][0] = "Doantion No"
	data_header[0][1] = "data";
	data_header[0][2] = "7%";
	data_header[0][3] = "donationNo"
	
	data_header[1] = new Array;
	data_header[1][0] = "Service No"
	data_header[1][1] = "data";
	data_header[1][2] = "15%";
	data_header[1][3] = "serviceNo";
	
	data_header[2] = new Array;
	data_header[2][0] = "Donor Name"
	data_header[2][1] = "data";
	data_header[2][2] = "20%";
	data_header[2][3] = "donorName";

	data_arr = new Array();	
	<%
		
	    int  counter=0;
		if (donorList != null && donorList.size() > 0) { %>
	
	<% 	for(BloodDonationEntryHeader bloodDonationEntryHeader : donorList){
		
	%>
data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= bloodDonationEntryHeader.getId()%>
			data_arr[<%= counter%>][1] = "<%=bloodDonationEntryHeader.getDonationNo()%>"
			<%if(bloodDonationEntryHeader.getHin() != null){%>
			data_arr[<%= counter%>][2] = "<%=bloodDonationEntryHeader.getHin().getServiceNo()%>"
			<%}else{%>
				data_arr[<%= counter%>][2] = "-"
			<%}%>
			<%try{%>
			data_arr[<%= counter%>][3] = "<%=bloodDonationEntryHeader.getDonerName()%> "
			
		<%
			}catch(Exception e){
				e.printStackTrace();
			}
				     counter++;
			}
		}
		%>
		 formName = "searchBloodDonor"
	
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	
	makeTable(start,end);
</script>