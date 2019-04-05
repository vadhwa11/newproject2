
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.OpdQaMaster"%>
<%@page import="java.util.*"%>
<%@page import="java.util.Iterator"%>

<%Map<String,Object> map = new HashMap<String,Object>();

if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");
}
List<OpdQaMaster> list= new ArrayList<OpdQaMaster>();
if(map.get("questionnaireList") != null){
	list = (List<OpdQaMaster>)map.get("questionnaireList");
}

%>
<select name ="questionnaireId"  class="large" id ="questionnaireId"  validate="Question,string,yes" tabindex=1>
<option value='0'>Select</option>
<%	if(list.size() !=0){
	
		for (OpdQaMaster questionnaire :list) {
		
%>				
<option value=<%=questionnaire.getId()%>><%=questionnaire.getQuestion()%></option>
<%} }%>
</select>

