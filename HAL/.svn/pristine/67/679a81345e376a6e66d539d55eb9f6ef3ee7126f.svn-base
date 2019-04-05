
<%@ page import="java.util.*"%>
<%
Map<String,Object> newmap = new HashMap<String,Object>();
if(request.getAttribute("map") != null){
	newmap=(Map<String, Object>)request.getAttribute("map");
}
String moduleName = ""; 
if(newmap.get("moduleName")!= null){
	moduleName = (String)newmap.get("moduleName");
}
String csrfToken="";
if(newmap.get("csrfToken")!= null){
	csrfToken = (String)newmap.get("csrfToken");
}
%>
<%@ page import="java.util.Map"%>
<%@ page import="jkt.hms.masters.business.MasApplication"%>

<%@ include file="header.jsp"%>

<%@ include file="navigation1.jsp"%>
<form name="moduleDefault" method="post">
<%
	if(moduleName.equalsIgnoreCase("MedicalExam")){
		moduleName = "Medical Exam";
	}
	if(moduleName.equalsIgnoreCase("MedicalBoard")){
		moduleName = "Medical Board";
	}
	if(moduleName.equalsIgnoreCase("AviationMedicine")){
		moduleName = "Aviation Medicine";
	}
	if(moduleName.equalsIgnoreCase("FamilyWelfareCenter")){
		moduleName = "Family Welfare Center";
	}
	if(moduleName.equalsIgnoreCase("EmergencyRoom")){
		moduleName = "Emergency Room";
	}
	if(moduleName.equalsIgnoreCase("ECGRoom")){
		moduleName = "ECG Room";
	}
	if(moduleName.equalsIgnoreCase("Statistics")){
		moduleName = "Station Health Statistics";
	}
%>

<p>Welcome to <%=moduleName %></p>
<div class="clear"></div>
</form>
<%@ include file="footer.jsp"%>