
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.MdContigentMedicalBillHd"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>

<script type="text/javascript">
function checkBlankSearch(){
	var errorMsg =""
	errorMsg=document.getElementById("hinNo").value;
	errorMsg=errorMsg+document.getElementById("serviceNo").value;
	errorMsg=errorMsg+document.getElementById("pFName").value;
	errorMsg=errorMsg+document.getElementById("pLName").value;
	//errorMsg=errorMsg+document.getElementById("sPerFName").value;
//	errorMsg=errorMsg+document.getElementById("sPerLName").value;
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

<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MdContigentMedicalBillHd> patientList = new ArrayList<MdContigentMedicalBillHd>();
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
		if(map.get("patientList") != null){
			patientList= (List<MdContigentMedicalBillHd>)map.get("patientList");
		}
		
		String message="";
		if (map.get("message") != null) {
	       message = (String) map.get("message");
	    }
			if(!message.equalsIgnoreCase("")){
				%>
<h2><%=message %></h2>
<%} %>

<form name="patientSearch" action="" method="post">

<div class="titleBg">
<h2>Contingent Bill for Reimbursement of Medical Bill Entry</h2>
</div>

<div class="Clear"></div>
<h4>Patient Search</h4>

<div class="Clear"></div>
<div class="Block">
<label>Service No.</label>
<input	id="serviceNo" type="text" name="<%=SERVICE_NO %>" value="" MAXLENGTH="20" /> 
<label>HIN</label>
<input id="hinNo" type="text" name="<%=HIN_NO %>" value="" MAXLENGTH="15" />
<label>First Name</label> 
<input id="pFName" type="text" name="<%=P_FIRST_NAME %>" value="" MAXLENGTH="30" />

<div class="Clear"></div>

<label>Last Name</label> 
<input id="pLName" type="text"	name="<%=P_LAST_NAME%>" value="" MAXLENGTH="30" />
<%--- 
<label>Ser.First Name</label> 
<input id="sPerFName" type="text" name="<%=S_FIRST_NAME %>" value="" MAXLENGTH="30" />
<label>Ser. Last Name</label>
<input id="sPerLName" type="text" name="<%=S_LAST_NAME%>" value="" MAXLENGTH="30" />--%>

<label>Rank</label> <select id="rankId" name="<%=RANK_ID %>">
	<option value="0">Select Rank</option>
	<% for(MasRank masRank : rankList){%>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%}	%>
</select> 
</div>
<div class="Clear"></div>
<input type="button" name="Submit" id="addbutton" value="Search" class="button" accesskey="a" 
	onclick="if(checkBlankSearch()){submitForm('patientSearch','/hms/hms/mediClaim?method=showApprovePatientContBill');}"/>
<div class="Clear"></div>
</form>

<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<form name="appSearchContingentBill" method="post" action=""><script
	type="text/javascript">
	formFields = [
			[0, "contHdId", "id"],[1,"dateOfRequest"], [2,"servNo"], [3,"hin"], [4,"patName"], [5,"rank"], [6,"sPersonName"]];
	 statusTd = 5;
</script></form>
</div></div>
<script type="text/javascript" language="javascript">
	
	data_header = new Array();
	
	data_header[0] = new Array;
	data_header[0][0] = "Date Of Entry"
	data_header[0][1] = "data";
	data_header[0][2] = "10%";
	data_header[0][3] = "dateOfRequest"
	
	data_header[1] = new Array;
	data_header[1][0] = "Service No"
	data_header[1][1] = "data";
	data_header[1][2] = "7%";
	data_header[1][3] = "servNo"
	
	data_header[2] = new Array;
	data_header[2][0] = "HIN"
	data_header[2][1] = "data";
	data_header[2][2] = "15%";
	data_header[2][3] = "hin";
	
	data_header[3] = new Array;
	data_header[3][0] = "Patient Name"
	data_header[3][1] = "data";
	data_header[3][2] = "20%";
	data_header[3][3] = "patName";
	
	data_header[4] = new Array;
	data_header[4][0] = "Rank"
	data_header[4][1] = "data";
	data_header[4][2] = "10%";
	data_header[4][3] = "rank"
	
	data_header[5] = new Array;
	data_header[5][0] = "Name"
	data_header[5][1] = "data";
	data_header[5][2] = "15%";
	data_header[5][3] = "sPersonName";
	
	data_arr = new Array();
	<%
	    int  counter=0;
		if (patientList != null && patientList.size() > 0) { %>

	<% 	for(MdContigentMedicalBillHd specialInvestigationHd : patientList){
		String invs_date=specialInvestigationHd.getEntryDate().toString();
		String sihdate=invs_date.substring(8)+"/"+invs_date.substring(5,7)+"/"+invs_date.substring(0,4);
		System.out.println("date---->"+sihdate);
	%>
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = "<%= specialInvestigationHd.getId()%>"
			data_arr[<%= counter%>][1] = "<%= sihdate%>"
			
			data_arr[<%= counter%>][2] = "<%=specialInvestigationHd.getHin().getServiceNo()%>"
			data_arr[<%= counter%>][3] = "<%=specialInvestigationHd.getHin().getHinNo()%>"
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
			data_arr[<%= counter%>][4] = "<%=specialInvestigationHd.getHin().getPFirstName()%> <%=middleName%> <%=lastName%>"
			data_arr[<%= counter%>][5] = "<%=specialInvestigationHd.getHin().getRank().getRankName()%> "
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
				data_arr[<%= counter%>][6] = "<%=sName%>"
				<%}else{%>
				data_arr[<%= counter%>][6] = ""
				<%}%>
		<%
			   counter++;
		    	}
		}
		%>		
    formName = "appSearchContingentBill"
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	}
	makeTable(start,end);

	</script>
