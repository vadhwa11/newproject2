
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.PacsTemplate"%>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List templateList= new ArrayList();
if(map.get("templateList") != null){
	templateList = (List)map.get("templateList");
} 
%>


<%@page import="java.util.Iterator"%>
 
<ul>
	<%	if(templateList.size() !=0){
	
		for (Iterator iterator = templateList.iterator(); iterator.hasNext();) {
			
			//Object[] pair = (Object[]) iterator.next();
			PacsTemplate pacsTemplate=(PacsTemplate)iterator.next();
			
		    String templateName=pacsTemplate.getTemplateName(); 
		    int templateId=pacsTemplate.getId();
	
		
%>
	<li style="width: auto;"><%=templateName%>[<%=templateId%>]</li>



	<%}}else{%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul> 
