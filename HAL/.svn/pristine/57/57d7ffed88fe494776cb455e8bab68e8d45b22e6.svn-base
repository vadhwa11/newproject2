<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseForHospital.jsp  
 * Purpose of the JSP   This is for Response for Hospital.
 * @author  Ritu
 * Create Date: 29th Nov,2007 
 * Revision Date:      
 * Revision By:  
 * @version 1.3
--%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<%@ page import="java.util.*"%>

<%@ page import = "static jkt.hms.util.RequestConstants.EMPLOYEE_ID" %>
<%@ page import = "static jkt.hms.util.RequestConstants.SESSION_ID" %>

<script type="text/javascript" language="javascript"	src="/hms/jsp/js/hms.js"></script>
<%

	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	List<StorePoHeader> poList = new ArrayList<StorePoHeader>();

	
 if(map.get("poList") != null){
	 
	 poList=(List<StorePoHeader>)map.get("poList");
 }
// out.print("enquiryList="+enquiryList.size());
 

 
%>


<label> Purchase Order No  <span>*</span></label>
	<select	class="" name="poNo" id="poNo" validate="Purchase Order No,String,yes" tabindex=1 onchange="submitProtoAjaxWithDivNameToShowStatus('nisDetails','/hms/hms/stores?method=getPOList','PODiv');">
		<option value="0">Select</option>
<%
	for (StorePoHeader list :poList ) 
	{
		
		%>		
		<option value=<%=list.getId()%>><%=list.getPoNumber()%></option>
		<%   
	}
%>

</select>


<div id="PODiv">
<label>RR No. <span>*</span></label>
<select name="grnId" validate="RR No." tabindex=1	validate="RR No.,string,yes" >
<option value="0">Select</option>
</select>
</div>