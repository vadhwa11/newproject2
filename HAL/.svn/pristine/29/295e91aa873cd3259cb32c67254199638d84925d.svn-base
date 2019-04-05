<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * searchQuotationRequest.jsp  
 * Purpose of the JSP -  This is for Search Quotation Request.
 * @author  Deepali
 * @author  Mansi
 * Create Date: 30th Jan,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.3
--%>

<%@ page import="jkt.hms.util.RequestConstants"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.StoreQuotationReceiptM"%>

<%@page import="jkt.hms.masters.business.StoreQuotationRequestM"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

<script type="text/javascript">
		<!--
		var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
		var IMGDIR_MISC = "images/misc";
		var vb_disable_ajax = parseInt("0", 10);
		// -->
		</script>
<%
List<StoreQuotationRequestM> searchQuotationRequestList= new ArrayList<StoreQuotationRequestM>();
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
		String includedJsp="";
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
			
		}
		List<StoreQuotationReceiptM> gridQuotationHeaderList= new ArrayList<StoreQuotationReceiptM>();
		
		try{
			gridQuotationHeaderList=(List)map.get("gridQuotationRequestHeaderList");
			System.out.println("gridQuotationRequestHeaderList  in JSP "+gridQuotationHeaderList.size());
			searchQuotationRequestList=(List)map.get("searchQuotationRequestList");
		}catch(Exception e){
			System.out.println("In Deatail Jsp!!!!!!!!!!!1"+e);
		}
		
				
		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
	
	%>

<div id="contentspace"><br />


<form name="searchQuotation" method="post" action="">


<table class="tborder" width="100%" align="center">
	<tr>
		<td width="20%" nowrap="nowrap" class="vbmenu_control"
			id="threadsearch"><a href="">Search</a> <script
			type="text/javascript"> vbmenu_register("threadsearch"); </script></td>
		<td width="80%"><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label>


		<table width="20%" align="right" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="5%"><IMG SRC="/hms/jsp/images/toolBar_01.gif"
					WIDTH=24 HEIGHT=28 ALT=""></td>
				<td width="7%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Add" type="submit" value="Add"
					class="toolbutton"
					onClick="submitForm('searchQuotation','stores?method=quotationRequestJsp');"></td>
				<td width="1%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="10%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Modify" type="submit" value="Modify"
					class="toolbutton"
					onClick="submitForm('searchQuotation','stores?method=quotationRequestModify');"></td>
				<td width="2%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Reset" type="submit" value="Reset"
					class="toolbutton"></td>
				<td width="2%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Delete" type="submit" value="Delete"
					class="toolbutton"></td>
				<td width="4%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="print" type="submit" class="toolbutton"
					value=" " onClick=""></td>
				<td width="39%"><IMG SRC="/hms/jsp/images/closeButton.gif"
					WIDTH=24 HEIGHT=28 ALT=""></td>
			</tr>
		</table>
		</td>
	</tr>
</table>



<div align="center">
<div style="padding: 0px 25px 0px 25px"><!-- thread search menu -->
<div class="vbmenu_popup" id="threadsearch_menu" style="display: none">

<form action="searchPanel" method="post">
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
			name="searchthreadid" value="85875" /> <label class="bodytextB_blue">From
		Date :</label> <input type="text" name="<%= RequestConstants.FROM_DATE %>"
			class="textbox_date" MAXLENGTH="30" / tabindex=1 /> <img
			id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
			border="0" validate="Pick a date"
			onClick="setdate('<%=currentDate%>',document.poMain.<%= RequestConstants.FROM_DATE%>,true);"
			class="calender" /> <label class="bodytextB_blue">To Date :</label>

		<input type="text" name="<%= RequestConstants.TO_DATE %>"
			class="textbox_date" MAXLENGTH="30" / tabindex=1 /> <img
			id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
			border="0" validate="Pick a date"
			onClick="setdate('<%=currentDate%>',document.poMain.<%= RequestConstants.TO_DATE%>,true);"
			class="calender" /> <br />
		<label class="bodytextB_blue">Quotation Request No:</label> <select
			name="<%= RequestConstants.REQUEST_NO%>">
			<option value="0">Select</option>
			<%
					for (StoreQuotationRequestM storeQuotationRequestM :searchQuotationRequestList ) {
				%>

			<option value=<%=storeQuotationRequestM.getRequestNo()%>><%=storeQuotationRequestM.getRequestNo()%></option>

			<%
					}
				%>
		</select> <input type="button" class="smbutton" value="Go!"
			onClick="submitForm('searchQuotation','stores?method=searchQuotationRequest');" />
		</td>
	</tr>

</table>
</form>
</div>
</div>
</div>
<jsp:include page="searchResultPO.jsp" />

<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>



</div>
<div id="edited"></div>
<label>&nbsp;</label>
<div id="statusMessage" class="messagelabel"><br />
</div>
</div>
<script type="text/javascript" language="javascript">
	
	formFields = [
			[0, "<%= RequestConstants.MASTER_ID%>", "id"],[1, "<%= RequestConstants.REQUEST_TYPE%>"], [2,"<%= RequestConstants.REQUEST_NO%>"], [3,"<%= RequestConstants.QUOTATION_DATE %>"], [4,"<%= RequestConstants.VALIDITY_END_DATE %>"],[5,"<%=RequestConstants.STATUS%>"] ];
	 statusTd =5;

</script>
<script type="text/javascript" language="javascript">
		
		data_header = new Array();
		
		data_header[0] = new Array;
		data_header[0][0] = "Radio"
		data_header[0][1] = "radio";
		data_header[0][2] = "15%";
		data_header[0][3] = "<%= RequestConstants.RADIO_FOR_TABLE%>"
		
		data_header[1] = new Array;
		data_header[1][0] = "Request Type"
		data_header[1][1] = "data";
		data_header[1][2] = "15%";
		data_header[1][3] = "<%= RequestConstants.REQUEST_TYPE%>"
		
		data_header[2] = new Array;
		data_header[2][0] = "QUOTATION Request No "
		data_header[2][1] = "data";
		data_header[2][2] = "15%";
		data_header[2][3] = "<%= RequestConstants.REQUEST_NO %>";
		
		data_header[3] = new Array;
		data_header[3][0] = "Validity end date"
		data_header[3][1] = "data";
		data_header[3][2] = "15%";
		data_header[3][3] = "<%=RequestConstants.VALIDITY_END_DATE %>";
		
		
	
		
		data_header[4] = new Array;
		data_header[4][0] = "Status"
		data_header[4][1] = "data";
		data_header[4][2] = "15%";
		data_header[4][3] = "<%=RequestConstants.STATUS %>";
		
		data_arr = new Array();
		
		<%String st="";
		Iterator itrrr=gridQuotationHeaderList.iterator();
		          int  counter=0;
		          while(itrrr.hasNext())
		           {           
		        	  StoreQuotationRequestM  storeQuotationRequestM = (StoreQuotationRequestM)itrrr.next(); 
		             %>
		
			data_arr[<%= counter%>] = new Array();
			
			data_arr[<%= counter%>][0] = <%= storeQuotationRequestM.getId()%>
			data_arr[<%= counter%>][1] = '<input type="radio"  name="parent" value="<%= storeQuotationRequestM.getId()%>" id="radio" />'
			<%if(storeQuotationRequestM.getRequestType().equals("R")){%>
						data_arr[<%= counter%>][2]="Regular"
						<%}else{%>
						data_arr[<%= counter%>][2]="Annual"
						<%}%>
	
			data_arr[<%= counter%>][3]="<%= storeQuotationRequestM.getRequestNo()%>"
			 data_arr[<%= counter%>][4]="<%= storeQuotationRequestM.getRequestDate()%>"
			<%if(storeQuotationRequestM.getStatus().equals("y")){%>
						data_arr[<%= counter%>][5]="Active"
						<%}else{%>
						data_arr[<%= counter%>][5]="InActive"
						<%}%>
		<% counter++;
			}
		%>
		 
		formName = "searchQuotation"
		
		
		start = 0
		if(data_arr.length < rowsPerPage)
			end = data_arr.length;
		else
			end = rowsPerPage;
		makeTable(start,end);
		
		intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
</form>