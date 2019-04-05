<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.BloodReactionEntry"%>

<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		List<BloodReactionEntry> reactionList = new ArrayList<BloodReactionEntry>();
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		if(patientMap.get("reactionList") != null){
			reactionList= (List<BloodReactionEntry>)patientMap.get("reactionList");
		}
		String message = "";
		String deptType = "";
		if(map.get("message") != null){
			message= (String)map.get("message");
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
<h6>Update Blood Reaction Form Entry</h6>
<div class="Clear"></div>
<div class="blockTitle">Search</div>
<div class="blockTitleCurve"></div>
<div class="blockFrame"><label>Enrty No.</label> <input
	type="text" name="<%=ENTRY_NO %>" value="" MAXLENGTH="50" id="hinNo" />

<label>Service No.</label> <input type="text" name="<%=SERVICE_NO %>"
	value="" MAXLENGTH="20" id="serviceNo" /> <label>Hin No.</label> <input
	type="text" name="<%=HIN_NO %>" value="" MAXLENGTH="20" id="hinNo" />
<div class="Clear"></div>

<label> Name</label> <input type="text" name="<%=PATIENT_NAME %>"
	value="" MAXLENGTH="15" id="pFName" /></div>
<div class="Clear"></div>
<input type="button" name="search" id="addbutton"
	onclick="submitForm('bloodEntry','/hms/hms/bloodBank?method=searchPatientForUpdateReaction');"
	value="Search" class="cmnButton" accesskey="a" /></form>

<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<form name="searchReaction" method="post" action=""><script
	type="text/javascript">
	formFields = [
			[0, "<%=BLOOD_REACTION_ID%>", "id"], [1,"entryNo"], [2,"serviceNo"], [3,"donorName"]];
	 statusTd = 3;
	</script></form>
</div>

</div>
<script type="text/javascript" language="javascript">
	
	data_header = new Array();
	
	
	data_header[0] = new Array;
	data_header[0][0] = "Entry No"
	data_header[0][1] = "data";
	data_header[0][2] = "7%";
	data_header[0][3] = "entryNo"
	
	data_header[1] = new Array;
	data_header[1][0] = "Service No"
	data_header[1][1] = "data";
	data_header[1][2] = "15%";
	data_header[1][3] = "serviceNo";
	
	data_header[2] = new Array;
	data_header[2][0] = "Patient Name"
	data_header[2][1] = "data";
	data_header[2][2] = "20%";
	data_header[2][3] = "donorName";

	data_arr = new Array();	
	<%
		
	    int  counter=0;
		if (reactionList != null && reactionList.size() > 0) { %>
	
	<% 	for(BloodReactionEntry reactionEntry : reactionList){
	
	%>
			data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= reactionEntry.getId()%>
			data_arr[<%= counter%>][1] = "<%=reactionEntry.getEntryNo()%>"
			<%if(reactionEntry.getHin() != null && reactionEntry.getHin().getServiceNo()!=null){%>
			data_arr[<%= counter%>][2] = "<%=reactionEntry.getHin().getServiceNo()%>"
			<%}else{%>
				data_arr[<%= counter%>][2] = "-"
			<%}%>
			<%try{%>
				<%if(reactionEntry.getHin() != null){%>
			data_arr[<%= counter%>][3] = "<%=reactionEntry.getHin().getPFirstName()%>"
			<%}else{%>
				data_arr[<%= counter%>][3] = "<%=reactionEntry.getDonorName()%>"
			<%}%>

			
		<%
			}catch(Exception e){
				e.printStackTrace();
			}
				     counter++;
			}
			}
		%>
		 formName = "searchReaction"
	
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	
	makeTable(start,end);
</script>