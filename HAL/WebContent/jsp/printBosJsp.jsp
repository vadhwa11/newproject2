<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * showboardofsurvey.jsp  
 * Purpose of the JSP -  This is for boardofsurvey.
 * @author  HITESH
 * Create Date: 21st May,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.StoreBosM"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"	id="vbulletin_css" />
<link rel="stylesheet" href="/hms/jsp/css/acnik.css" type="text/css" />
<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>

<%
	StringBuffer orderDateOnly = new StringBuffer();
	GregorianCalendar gregorianCalendar1 = new GregorianCalendar();

	int dateOfMonth = gregorianCalendar1.get(Calendar.DAY_OF_MONTH);
	if (dateOfMonth < 10) {
		orderDateOnly.append("0");
		orderDateOnly.append(dateOfMonth);
	} else {
		orderDateOnly.append(dateOfMonth);
	}

	orderDateOnly.append("/");

	int month = gregorianCalendar1.get(Calendar.MONTH) + 1;
	if (month < 10) {
		orderDateOnly.append("0");
		orderDateOnly.append(month);
	} else {
		orderDateOnly.append(month);
	}

	orderDateOnly.append("/");
	int year = gregorianCalendar1.get(Calendar.YEAR);
	orderDateOnly.append(year);
	String currentDate = new String(orderDateOnly);
%>
<%
	Map map = new HashMap();
    HashMap[] gridData =null;
	String previousPage="no";
	List<StoreBosM> storeBosMlist = new ArrayList<StoreBosM>();
	int pageNo=1;
	String bosNo="";
	int hospitalId = 0;
	 int deptId = 0;
	 String userName="";
	 String lastchangedby="";
	 String lastchangeTime="";
	 String time ="";
	if (request.getAttribute("map") != null)
	{
		map = (Map) request.getAttribute("map");
	
		
		if(map.get("storeBosMList")!=null){
			storeBosMlist=(List) map.get("storeBosMList");
		}
		
		
		if (session.getAttribute("userName") != null){
			userName = (String) session.getAttribute("userName");
		}
		if (session.getAttribute("hospitalId") != null){
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));}
		if (session.getAttribute("deptId") != null){
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			}
		
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
		String date = (String)utilMap.get("currentDate");
		 time = (String)utilMap.get("currentTime");
	}
%>


<!-- <input	type="button" id="addbutton" name="Add" type="submit" value="Add" class="button" onClick="submitForm('createGrn','neStores?method=showWorkOrderJsp');">
<input	type="button" name="Modify" type="submit" value="Modify" class="button">
<input	type="button" name="Reset" type="submit" value="Reset"	class="button">
<input	type="button" name="Delete" type="submit" value="Delete"class="button">
<input	type="button" name="print" type="submit" class="button"	value="Print" onClick="showReport('createGrn');">
 -->

<form name="searchBlock" method="post">
<div class="titleBg">
<h2 >Board Of Survey Print</h2>
</div>
<div class="clear"></div>
<div class="Block">
	<label>Bos No:</label>
	 <select name="<%=BOS_ID%>" class="bigselect">
	<option value="">Select</option>
	<%
	     for (StoreBosM storeBosM:storeBosMlist ){
			  	
	%>
			<option value="<%=storeBosM.getBosNo()%>"><%=storeBosM.getBosNo()%></option>
			<% } %>
		</select> 

</div>
<div class="clear"></div>
<!-- <input type="button" class="button" value="Search"	onClick="search()" />-->
<input type="button" name="add" id="addbutton" value="Print" class="button"
	onClick="submitForm('searchBlock','neStores?method=generatePrintBOSJsp');"	accesskey="g" tabindex=1 />
<div class="clear"></div>
</form>





