
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.MasStoreMeScale"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.util.*"%>
<%
		Map<String,Object> map = new HashMap<String,Object>();	
		List<MasStoreMeScale>meScaleDescriptionList = null;
    	MasStoreMeScale masStoreMeScale = null;
    	String meScaleDesc= null;
	  	if(request.getAttribute("map") != null){
	 	map = (Map) request.getAttribute("map");
	  	}
	  	
	   List  meScaleDescription = null;
		meScaleDescription=(List)map.get("MeScaleDescriptionList");
		masStoreMeScale= (MasStoreMeScale)meScaleDescription.get(0);
		meScaleDesc= masStoreMeScale.getMeScaleDescription();
		%>

<div id="testDiv"><label class="bodytextB">MEScaleDescription:
</label> <input type="text" name="<%=RequestConstants.ME_SCALE_DESCRIPTION %>"
	value="<%=meScaleDesc%>" class="medcaption" readonly="readonly" /></div>
