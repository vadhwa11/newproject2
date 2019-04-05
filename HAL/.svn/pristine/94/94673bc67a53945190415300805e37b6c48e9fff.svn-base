<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.StoreQuotationReceiptM"%>

<%@page import="jkt.hms.masters.business.StoreGrnM"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
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
<script>
<%

	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date.length()<2){
		date="0"+date;
	}
%>
	serverdate = '<%=date+"/"+month1+"/"+year1%>'
</script>

<%
List<StoreGrnM> searchGrnList= new ArrayList<StoreGrnM>();
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
		List<StoreGrnM> gridGrnHeaderList= new ArrayList<StoreGrnM>();
		
		try{
			gridGrnHeaderList=(List)map.get("gridGrnHeaderList");
			System.out.println("gridGrnHeaderList  in JSP "+gridGrnHeaderList.size());
			searchGrnList=(List)map.get("searchGrnList");
		}catch(Exception e){
		}
		
				
		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
	
	%>

<div id="contentspace"><br />


<form name="searchGrn" method="post" action="">


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
					class="toolbutton"></td>
				<td width="1%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="10%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Modify" type="submit" value="Modify"
					class="toolbutton"
					onClick="submitForm('searchGrn','neStores?method=modifyGrn');"></td>
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
		Date :</label> <input type="text" name="<%= FROM_DATE %>" class="textbox_date"
			MAXLENGTH="30" / tabindex=1 /> <img id="calendar"
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date" class="calender" tabindex="1"
			onClick="setdate('<%=currentDate%>',document.searchGrn.<%= FROM_DATE%>,event)" />

		<label class="bodytextB_blue">To Date :</label> <input type="text"
			name="<%= TO_DATE %>" class="textbox_date" MAXLENGTH="30"
			/ tabindex=1 /> <img id="calendar" src="/hms/jsp/images/cal.gif"
			width="16" height="16" border="0" validate="Pick a date"
			class="calender" tabindex="1"
			onClick="setdate('<%=currentDate%>',document.searchGrn.<%= TO_DATE%>,event)" />
		<br />

		<label class="bodytextB_blue">GRN No:</label> <select
			name="<%=GRN_NO%>">
			<option value="0">Select</option>
			<%
					for (StoreGrnM storeGrnM :searchGrnList ) {
				%>

			<option value=<%=storeGrnM.getGrnNo()%>><%=storeGrnM.getGrnNo()%></option>

			<%
					}
				%>
		</select> <input type="button" class="smbutton" value="Go!"
			onClick="submitForm('searchGrn','neStores?method=searchGrn');" /></td>
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
			[0, "<%= GRN_ID%>", "id"],[1, "<%= GRN_NO%>"], [2,"<%= GRN_DATE%>"], [3,"<%= STORE_SUPPLIER_ID %>"], [4,"<%= PO_ID %>"],[5,"<%= INDENT_ID %>"],[6,"<%= SUPPLY_ORDER_NO %>"],[7,"<%= GRN_VALUE %>"][8,"<%=STATUS%>"] ];
	 statusTd =8;

</script>
<script type="text/javascript" language="javascript">
		
		data_header = new Array();
		
		data_header[0] = new Array;
		data_header[0][0] = "Radio"
		data_header[0][1] = "radio";
		data_header[0][2] = "15%";
		data_header[0][3] = "<%= RADIO_FOR_TABLE%>"
		
		data_header[1] = new Array;
		data_header[1][0] = "CRV No"
		data_header[1][1] = "data";
		data_header[1][2] = "15%";
		data_header[1][3] = "<%= GRN_NO%>"
		
		data_header[2] = new Array;
		data_header[2][0] = "CRV Date"
		data_header[2][1] = "data";
		data_header[2][2] = "15%";
		data_header[2][3] = "<%= GRN_DATE %>";
		
		data_header[3] = new Array;
		data_header[3][0] = "SUPPLIER"
		data_header[3][1] = "data";
		data_header[3][2] = "15%";
		data_header[3][3] = "<%=STORE_SUPPLIER_ID  %>";
		
		data_header[4] = new Array;
		data_header[4][0] = "PO NO"
		data_header[4][1] = "data";
		data_header[4][2] = "15%";
		data_header[4][3] = "<%=PO_ID %>";
		
	
		data_header[5] = new Array;
		data_header[5][0] = "Indent NO"
		data_header[5][1] = "data";
		data_header[5][2] = "15%";
		data_header[5][3] = "<%=INDENT_ID %>";
		
		data_header[6] = new Array;
		data_header[6][0] = "Supplier order NO"
		data_header[6][1] = "data";
		data_header[6][2] = "15%";
		data_header[6][3] = "<%=SUPPLY_ORDER_NO %>";
		
		data_header[7] = new Array;
		data_header[7][0] = "CRV Value"
		data_header[7][1] = "data";
		data_header[7][2] = "15%";
		data_header[7][3] = "<%=GRN_VALUE %>";
		
		data_header[8] = new Array;
		data_header[8][0] = "Status"
		data_header[8][1] = "data";
		data_header[8][2] = "15%";
		data_header[8][3] = "<%=STATUS %>";
		
		data_arr = new Array();
		
		<%String st="";
		Iterator itrrr=gridGrnHeaderList.iterator();
		          int  counter=0;
		          while(itrrr.hasNext())
		           {           
		        	  StoreGrnM  storeGrnM = (StoreGrnM)itrrr.next(); 
		             %>
		
			data_arr[<%= counter%>] = new Array();
			
			data_arr[<%= counter%>][0] = <%= storeGrnM.getId()%>
			data_arr[<%= counter%>][1] = '<input type="radio"  name="parent" value="<%= storeGrnM.getId()%>" id="radio" />'
			data_arr[<%= counter%>][2] = "<%=storeGrnM.getGrnNo()%>"
			data_arr[<%= counter%>][3]="<%= storeGrnM.getGrnDate()%>"
			<%if(storeGrnM.getSupplier()== null){%>
			 data_arr[<%= counter%>][4]="no value";
			 <%}else{%>
			 data_arr[<%= counter%>][4]="<%= storeGrnM.getSupplier().getSupplierName()%>"
			 <%}%>
			 
			 <%if ((storeGrnM.getPo()== null)&& (storeGrnM.getIndent()== null)){%>
			 data_arr[<%= counter%>][5]="No Value"
			data_arr[<%= counter%>][6]="No Value"
			
			<%}else if(storeGrnM.getIndent()==null){%>
			data_arr[<%= counter%>][5]="<%= storeGrnM.getPo().getPoNumber()%>"
			data_arr[<%= counter%>][6]="No Value"
			
			<%}else if(storeGrnM.getPo()==null){%>
			data_arr[<%= counter%>][5]="No Value"
			data_arr[<%= counter%>][6]="<%= storeGrnM.getIndent().getIndentNo()%>"
			
			<%}%>
			 		<%if((storeGrnM.getAtSoNo()==null)||(storeGrnM.getAtSoNo()== "")){%>
			 		data_arr[<%= counter%>][7]="no value"
			 		<%}else{%>
			 		data_arr[<%= counter%>][7]="<%= storeGrnM.getAtSoNo()%>"
			<%}%>
			
			 	data_arr[<%= counter%>][8]="<%= storeGrnM.getGrnValue()%>"
             	
				<%if(storeGrnM.getStatus().equals("o")){%>
						data_arr[<%= counter%>][9]="Active"
						<%}else{%>
						data_arr[<%= counter%>][9]="InActive"
						<%}%>
		<% counter++;
			}
		%>
		 
		formName = "searchGrn"
		
		
		start = 0
		if(data_arr.length < rowsPerPage)
			end = data_arr.length;
		else
			end = rowsPerPage;
		makeTable(start,end);
		
		intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>
</form>