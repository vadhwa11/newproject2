
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%
	Map<String, Object> map = new HashMap<String, Object>();
	String formName = "";
	String url = "";
	String printUrl="";
	String flag="";
	String hinNo="";
	String serviceNo="";
	int avAccidentId=0;
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("formName") != null){
		formName = (String)map.get("formName");
	}
	if(map.get("url") != null){
		url = (String)map.get("url");
	}
	if(map.get("flag") != null){
		flag = (String)map.get("flag");
	}
	if(map.get("avAccidentId") != null){
		avAccidentId = (Integer)map.get("avAccidentId");
	}
	if(map.get("hinNo") != null){
		hinNo = (String)map.get("hinNo");
	}
	if(map.get("serviceNo") != null){
		serviceNo = (String)map.get("serviceNo");
	}
	
	//out.print("flag="+flag);
%>
<form name="msgAviation" method="post">
<% 
String message ="";
if (map.get("message") != null) {
             message = (String) map.get("message");
      }
if(!message.equalsIgnoreCase("")){
 %>
<h2><%=message %></h2>
<%} %>
<div id="contentHolder">
<input type="hidden" value="<%=flag %>" name="flag" id="flag"/>
<div class="Clear"></div>
<%if((flag.equalsIgnoreCase("accident")) || flag.equalsIgnoreCase("equipment") || 
	(flag.equalsIgnoreCase("external")) || flag.equalsIgnoreCase("postMortem")|| 
	(flag.equalsIgnoreCase("unassisted")) || (flag.equalsIgnoreCase("ejectionSeat")) || 
	(flag.equalsIgnoreCase("survival")) || (flag.equalsIgnoreCase("incident")) || 
	(flag.equalsIgnoreCase("airacc")) || (flag.equalsIgnoreCase("trainStatus")) || 
	(flag.equalsIgnoreCase("ration")) || (flag.equalsIgnoreCase("preFlight"))  
	) { %>
	
<input type="button" name="report" class="buttonBig" id="report"	
onclick="generateAviationMedReport();" value="Print Report"	accesskey="a" />
<input type="button" value="Back" class="button" onclick="submitForm('msgAviation','<%=url %>');"> 
<%} %>
<input name="serviceNo" type="hidden" value="<%=serviceNo %>" id="serviceNo" validate="ServiceNo,metachar,no"/>
<%if(flag.equalsIgnoreCase("preFlight")){ %>
<input name="hinNo" type="hidden" value="<%=hinNo %>" id="hinNo"/>
<input name="Send" type="button"  class="buttonBig" value="Attach Photo" onClick="javascript:openPopupWindow();" />
<%} %>
<div class="Clear"></div>
<%
if(formName != ""){
%> <input type="button" value="Close" class="button" onclick="window.close()"> <%} %>
</div>
</form>
<script type="text/javascript">
function generateAviationMedReport(){
	var url;
	var flag=document.getElementById("flag").value;
	if( flag == 'incident'){
	 url='/hms/hms/aviationMedicine?method=generateFlyingIncident&avAccidentId=<%=avAccidentId%>';
	}else if(flag == 'airacc'){
	 url='/hms/hms/aviationMedicine?method=generateAircraftAccident&avAccidentId=<%=avAccidentId%>';
	}else if(flag == 'trainStatus'){
	 url='/hms/hms/aviationMedicine?method=generateTrainingStatus&avAccidentId=<%=avAccidentId%>';
	}else if(flag == 'ration'){
	 url='/hms/hms/aviationMedicine?method=generateAircrewRation&avAccidentId=<%=avAccidentId%>';
	}else if(flag == 'preFlight'){
	 url='/hms/hms/aviationMedicine?method=generatePreFlight&avAccidentId=<%=avAccidentId%>';
	}else if((flag == 'accident') || (flag == 'equipment') || 
			(flag == 'external') || (flag == 'postMortem')|| 
			(flag == 'unassisted') || (flag == 'ejectionSeat') || 
			(flag == 'survival') || (flag == 'incident')){
	 url='/hms/hms/aviationMedicine?method=generateAviationMedReport&flag=<%=flag%>&avAccidentId=<%=avAccidentId%>';
	}
	 newwindow=window.open(url,'ar',"left=2,top=100,height=500,width=500,status=1,scrollbars=1,resizable=0");
}
</script>

<script type="text/javascript">
function openPopupWindow()
{
	var hinNo = document.getElementById('hinNo').value;
	var serviceNo = document.getElementById('serviceNo').value;
	var url="/hms/hms/aviationMedicine?method=displayPreFlightPhoto&hinNo=<%=hinNo%>&serviceNo="+serviceNo;
 	newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
}

</script>