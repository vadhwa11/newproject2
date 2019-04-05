<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseForDischarge.jsp  
 * Purpose of the JSP -  This is for Response Discharge.
 * @author  shailesh
* Create Date: 13 march 2009 
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>


<%@page import="jkt.hms.masters.business.StoreGrnM"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.util.RequestConstants"%>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/addRow.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar2.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

<script>
 var flag;
 </script>


<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	
	List<StoreGrnM> storeGrnMList = new ArrayList<StoreGrnM>();
	if(map.get("storeGrnMList")!=null){
		storeGrnMList=(List<StoreGrnM>)map.get("storeGrnMList");
	}
	
	
	%>
<div id="RRDiv">
<label >RR No.  </label> 
 <select id="grnId" 	name="grnId" validate="RR No.,string,yes" >
<%
				         		if(storeGrnMList.size()>0){ 	
				         			for (Iterator iter = storeGrnMList.iterator(); iter.hasNext();) {
				         				StoreGrnM storeGrnM = (StoreGrnM) iter.next();
				         %>
			<option value="<%=storeGrnM.getId() %>"><%=storeGrnM.getChallanNo() %></option>
			<%		
				        			}
				        		 } else
				        %>
				        
		</select> </div>
