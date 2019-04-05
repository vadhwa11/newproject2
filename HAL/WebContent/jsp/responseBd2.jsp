<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%Map map = new HashMap();
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		if (map.get("inPatientList") != null)
			inpatientList =(List)map.get("inPatientList");
			%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<form name="fatalDocumentPanchnamaReport" target="_blank" method="post"
	action=""><label class="">Admission No.: </label> <select
	name="<%=AD_NO%>" validate="Admission No,string,yes">
	<option value="">Select</option>
	<%for(Inpatient inpatient :inpatientList){ %>
	<option value="<%=inpatient.getId() %>"><%=inpatient.getAdNo() %></option>
	<%} %>
</select></form>
