<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.PatientRemarks"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%
Map<String, Object> map = new HashMap<String, Object>();
List<PatientRemarks> patientRemarksList = new ArrayList<PatientRemarks>();
String patientRemarks ="";
if(request.getAttribute("map") !=null){
	map=(Map<String, Object>)request.getAttribute("map");
}
if(map.get("patientRemarksList") !=null){
	patientRemarksList =(List<PatientRemarks>)map.get("patientRemarksList");
}
int i=1;
if(patientRemarksList.size() >0){
	for(PatientRemarks remarks :patientRemarksList){
		if(remarks.getRemarks() != null && remarks.getRemarks().trim() != ""){
		 patientRemarks =patientRemarks+"   \n "+i+") Remarks : "+remarks.getRemarks();	
		}
		if(remarks.getTreatment() != null && remarks.getTreatment().trim() != ""){
		 patientRemarks = patientRemarks+" ,  Treatment: "+remarks.getTreatment(); 	
		}
		
		i++;
	}
}
%>
<label class="noWidth"><%=patientRemarks%></label>