<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseForDischarge.jsp  
 * Purpose of the JSP -  This is for Response Discharge.
 * @author  
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>


<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<%@page import="java.text.SimpleDateFormat"%>
<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/addRow.js"></script>

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css">

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	
	List<StorePoHeader> poList= new ArrayList<StorePoHeader>();
	if (map.get("storePoHeaderList")!=null)
		poList = (List)map.get("storePoHeaderList");
	SimpleDateFormat formatterIn = new SimpleDateFormat("yyyy-MM-dd");
	 SimpleDateFormat formatterOut = new  SimpleDateFormat("dd/MM/yyyy");
	 String date = formatterOut.format(formatterIn.parse(""+poList.get(0).getPoDate()));
	String poDate = formatterOut.format(formatterIn.parse(""+poList.get(0).getPoDate()));
%> <script>
<%
	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date1=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date.length()<2){
		date="0"+date;
	}
%>
	serverdate = '<%=date1+"/"+month1+"/"+year1%>'
</script>
<div id="atsoDateDiv"><label>Po Date</label> <input id="dateTest"
	type="text" name=<%=RequestConstants.AT_SO_DATE%> " id="atSoDate"
	value="<%=poDate%>" MAXLENGTH="30" readonly="readonly" tabindex=1 /></div>