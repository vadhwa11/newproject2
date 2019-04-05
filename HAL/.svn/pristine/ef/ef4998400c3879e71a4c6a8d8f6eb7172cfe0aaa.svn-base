<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseForAge.jsp  
 * Purpose of the JSP -  This is for Response Diagnosis for Medical Report.
 * @author  Ritu
 * Create Date: 30th Jan,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>

<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%
	Map map = new HashMap();
	//List<Visit> diagnosisList = new ArrayList<Visit>();
	List<OpdPatientDetails> diagnosisList = new ArrayList<OpdPatientDetails>();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	
	if (map.get("diagnosisList") != null){
		diagnosisList =(List<OpdPatientDetails>)map.get("diagnosisList");
	}
	String diagnosis = "";
	if(diagnosisList.size() > 0){
		for(OpdPatientDetails opd : diagnosisList){ 
			if(opd.getInitialDiagnosis()!= null){
				diagnosis = opd.getInitialDiagnosis();
			}
		}
	}
%>


<div id="diagnosisDiv"><label>
Diagnosis:</label>

 <input type="text" name="<%=DIAGNOSIS_ID %>"	value="<%=diagnosis%>" maxlength="200"	validate="Diagnosis,alphanumeric,no"/></div>

	
	
	
	
	