<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseForAge.jsp  
 * Purpose of the JSP -  This is for Response Age.
 * @author  Ritu
 * Create Date: 30th Jan,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>

<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.Visit"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script>
var alt='';
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	
	List<Visit> patientVisitList = new ArrayList<Visit>();
	

	String alertMsg = "";
	
	if(map.get("patientVisitList") != null){
		patientVisitList = (List<Visit>)map.get("patientVisitList");
		if(patientVisitList != null && patientVisitList.size() > 0){
			for(Visit visit :patientVisitList ){
			if(!alertMsg.equals("")){
				alertMsg += " , ";
			}
			alertMsg += visit.getDepartment().getDepartmentName();
			
			}
			%>
			
		alt = '<%=alertMsg%>';
		
			<%
			
			
		}
			
			}
			%>
			chkPatient(alt);
			
			function chkPatient(alt){
			
			if(alt != ""){
				if(confirm(" Patient Already Visited in Department : " + alt + " .\n Are You Sure,You want Save?")){
					submitFormToDisableSubmit('visitByHin','/hms/hms/registration?method=saveVisitInformation');
				}
			}else{
					submitFormToDisableSubmit('visitByHin','/hms/hms/registration?method=saveVisitInformation');
				}
			}
</script>