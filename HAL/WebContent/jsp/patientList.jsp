<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * patientList.jsp  
 * Purpose of the JSP -  This is for Patient List.
 * @author  Deepti
 * @author  ritu
 * Create Date: 08th Jan,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>


<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.Inpatient"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>
<%
	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}

	Set inPatientSet = new HashSet();
	

	try {
			String bool=(String)map.get("bool");
			if(bool.equals("false"))
			{
				inPatientSet=(Set)map.get("inPatientSet");
				session.setAttribute("inPatientSet",inPatientSet);
			}	
			else if(session.getAttribute("inPatientSet")!= null)
			{
				inPatientSet=(Set)session.getAttribute("inPatientSet");
			}
		System.out.println("Size of set -------"+inPatientSet.size());

	} catch (Exception exp) {
			out.println("-------------------------------------------"+ exp);
		exp.printStackTrace();
	}
	
	
	

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
%>

<div id="contentspace">
<form name="patientList" method="post"><br />


<table class="tborder" width="100%" align="center">
	<tr>
		<td width="20%" nowrap="nowrap" class="vbmenu_control"
			id="threadsearch"><a href="">Search</a> <script
			type="text/javascript"> vbmenu_register("threadsearch"); </script></td>
		<td width="80%"><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label>

		</td>
	</tr>
</table>

<div align="center">
<div class="page" style="width: 100%; text-align: left">
<div style="padding: 0px 25px 0px 25px"><!-- thread search menu -->
<div class="vbmenu_popup" id="threadsearch_menu" style="display: none">

<form action="" method="post">
<table cellpadding="4" cellspacing="1" border="0">
	<tr>
		<td class="thead">Search Panel<a name="goto_threadsearch"></a></td>
	</tr>
	<tr>
		<td class="vbmenu_option" title="nohilite"><input type="hidden"
			name="s" value="cccfbaab0a70ed43fad9de8e3733112d" /> <input
			type="hidden" name="do" value="process" /> <input type="hidden"
			name="searchthread" value="1" /> <input type="hidden"
			name="showposts" value="1" /> <input type="hidden"
			name="searchthreadid" value="85875" /> <label class="bodytextB_blue">Service
		Number :</label> <input type="text"
			name="<%= RequestConstants.SERVICE_NUMBER %>" MAXLENGTH="30"
			/ tabindex=1 /> <label class="bodytextB_blue">Admission
		Number:</label> <select name="<%=RequestConstants.ADMISSION_NUMBER%>">
			<option value="0">Select</option>
			<%
				Iterator itr=inPatientSet.iterator();
			    while(itr.hasNext()){
			    	Inpatient inpatient= (Inpatient) itr.next();
			    	if(inpatient.getAdStatus().equalsIgnoreCase("A"))
			    	{
				//for (MasStoreSupplier masSupplier : supplierList) {
					
			%>

			<option value=<%=inpatient.getId()%>><%=inpatient.getAdNo()%></option>

			<%
				}
			  }	
			%>
		</select> <input type="button" class="smbutton" value="Go!"
			onClick="submitForm('patientList','ipd?method=searchPatient');" /> <br />
		</td>
	</tr>

</table>
</form>
</div>
<br>
</div>
</div>
</div>
<jsp:include page="searchResultBlock.jsp" /> <jsp:include
	page="patientDetail.jsp" />
</div>

<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>

</form>

