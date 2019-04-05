<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.OpdTemplate"%>
<%@page import="java.text.SimpleDateFormat"%>
<%  
	String message ="";
   String userName = "";
	if (session.getAttribute("userName") != null) {
 		userName = (String) session.getAttribute("userName");
 	}
 	Map<String, Object> utilMap = new HashMap<String, Object>();
 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
 	Box box = HMSUtil.getBox(request);
 	Map<String, Object> map = new HashMap<String, Object>();
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");
	List<OpdTemplate>templateList=new ArrayList<OpdTemplate>();
	
	if (request.getAttribute("map") != null) {
 		map = (Map<String, Object>) request.getAttribute("map");
 	}
 	if (map.get("templateList") != null) {
 		templateList = (List<OpdTemplate>) map.get("templateList");
 	}
 	String flag="";
	if (map.get("flag") != null) {
		flag = (String) map.get("flag");
 	}
	System.out.println("flag==="+flag);
	//onfocus="getListForTreatment();"
 	%>
<% if(flag.equalsIgnoreCase("treatment")){%>
<select name="templateId" id="templateId" tabindex="1">
	<option value="0">Select</option>
	<%
	   Iterator itr=templateList.iterator();
	   while(itr.hasNext())
	   {
		   OpdTemplate opdTemplate=(OpdTemplate)itr.next();
		   String templateType=opdTemplate.getTemplateType();
		   if(templateType.equalsIgnoreCase("p"))
		   {
	%>
	<option value="<%=opdTemplate.getId()%>"><%=opdTemplate.getTemplateName()%></option>
	<%		   
		   }
	   }
	   
	%>
</select>
<% } if(flag.equalsIgnoreCase("investigation")){%>
<div id="investigationDiv">
<!-- <select name="investigationTemplateId" id="investigationTemplateId" multiple="multiple" class="list" tabindex="1" onchange="showHideInvestigationTemplateCombo(this.value);" validate="investigationTemplateId,metachar,no"> -->
<select name="investigationTemplateId" id="investigationTemplateId" tabindex="1" onchange="showHideInvestigationTemplateCombo(this.value);" validate="investigationTemplateId,metachar,no">
	<option value="0">Select</option>
	<%
			   Iterator itr1=templateList.iterator();
			   while(itr1.hasNext())
			   {
				   OpdTemplate opdTemplate=(OpdTemplate)itr1.next();
				   String templateType=opdTemplate.getTemplateType();
				   if(templateType.equalsIgnoreCase("I"))
				   {
			%>
	<option value="<%=opdTemplate.getId()%>"><%=opdTemplate.getTemplateName()%></option>
	<%		   
		   }
	      }
	   
		%>

</select>
</div>
<% }%>