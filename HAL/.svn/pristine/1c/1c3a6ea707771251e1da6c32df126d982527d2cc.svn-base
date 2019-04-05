
<%@page import="jkt.hms.masters.business.DifferentialDiagnosis"%><%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%Map map = new HashMap();
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		List<Object[]> symptomDiseaseMappingList = new ArrayList<Object[]>();
		if (map.get("symptomDiseaseMappingList") != null)
			symptomDiseaseMappingList =(List)map.get("symptomDiseaseMappingList");
			%>

<%@page import="java.util.Iterator"%>
<%@page import="java.math.BigDecimal"%>

<%@page import="jkt.hms.masters.business.OpdSymptomDiseaseMapping"%><div id="testDiv">

<div class="clear" ></div>
<div class="titleBg"><h4>Differential Diagnosis</h4></div>

<% 
	String disease = "";
int diseaseId = 0;
if(symptomDiseaseMappingList.size()>0)
{	
	for (Iterator iterator = symptomDiseaseMappingList.iterator(); iterator
	.hasNext();) {
Object[] objects = (Object[]) iterator.next();
	if(objects[1]!= null){
		disease =(String) objects[1];
	}
	if(objects[0] != null){
		diseaseId = Integer.parseInt(""+objects[0]);
	}
	
    
     
%>

<%if(disease != null){ %>
<label class="grid"><a href="javascript:showFeatures(<%=diseaseId%>);"><%=disease%>
<input	type="hidden" name="diffentialDisease" id="diffentialDisease" value="<%=diseaseId%>"></a>
</label>

<div class="clear" ></div>
<%}}}else{ %>
<div class="clear" ></div>
<div class="titleBg"><h4>No Record Found.</h4></div>
<%} %>
<div class="clear" ></div>
</div>
