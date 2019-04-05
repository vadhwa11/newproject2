<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.StoreGrnM"%>
<%@page import="jkt.hms.masters.business.StoreDefectiveDrugM"%>
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
<%
List<StoreDefectiveDrugM> searchDrugList= new ArrayList<StoreDefectiveDrugM>();
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
	Map map = new HashMap();
		String includedJsp="";
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
			
		}
		List<StoreDefectiveDrugM> gridDefectiveDrugHeaderList = new ArrayList<StoreDefectiveDrugM>();
		try{
			gridDefectiveDrugHeaderList=(List)map.get("gridDefectiveDrugHeaderList");
			System.out.println("gridDefectiveDrugHeaderList  in JSP "+gridDefectiveDrugHeaderList.size());
			searchDrugList=(List)map.get("searchDrugList");
		}catch(Exception e){
		}
		
				
		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
	
	%>



<form name="searchDefectiveDrug" method="post" action="">


<!--<table class="tborder" width="100%" align="center">-->
<!--	<tr>-->
<!--		<td width="20%" nowrap="nowrap" class="vbmenu_control"-->
<!--			id="threadsearch"><a href="">Search</a> <script-->
<!--			type="text/javascript"> vbmenu_register("threadsearch"); </script></td>-->
<!--		<td width="80%"><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label>-->
<!---->
<!---->
<!--		-->
<!--			-->
<!--		-->
<!--		</td>-->
<!--	</tr>-->
<!--</table>-->



<!--<div class="vbmenu_popup" id="threadsearch_menu" style="display: none">-->
<div id="searchBlock" style="display:none;">
<form name="createGrn" method="post">

<div class="clear"></div>
<h6>SEARCH</h6>
<div class="Block">

<input type="hidden" name="s" value="cccfbaab0a70ed43fad9de8e3733112d" /> 
<input type="hidden" name="do" value="process" /> 
<input type="hidden" name="searchthread" value="1" /> 
<input type="hidden" name="showposts" value="1" /> 
<input type="hidden" name="searchthreadid" value="85875" />  
<label>From Date  </label> 
<input type="text" name="<%= FROM_DATE %>" MAXLENGTH="30" class="date" tabindex=1 /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.createGrn.<%= FROM_DATE%>,event)" />
<label>To Date  </label> 
<input type="text" name="<%= TO_DATE %>" MAXLENGTH="30" class="date" tabindex=1 /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"
			onClick="setdate('<%=currentDate%>',document.createGrn.<%= TO_DATE%>,event)" />

<div class="clear"></div>
<label >Defective Drug No. </label> 
<select
			name="<%=ENTRY_NO%>">
			<%
					for (StoreDefectiveDrugM storeDefectiveDrugM :searchDrugList ) {
				%>

			<option value=<%=storeDefectiveDrugM.getEntryNo()%>><%=storeDefectiveDrugM.getEntryNo()%></option>

			<%
					}
				%>

</select> 

<input type="button" name="sss" class="button" value="SEARCH" onClick="submitForm('createGrn','stores?method=searchDefectiveDrug');" />

</div>
</form>
</div>

<jsp:include page="searchResultPO.jsp" />

<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>




</div>
<div id="edited"></div>
<label>&nbsp;</label>
<div id="statusMessage" class="messagelabel"><br />
</div>
<script type="text/javascript" language="javascript">
	
	formFields = [
			[0, "<%= ENTRY_ID%>", "id"],[1, "<%= ENTRY_NO%>"], [2,"<%= ENTRY_DATE%>"],[3,"<%=STATUS%>"] ];
	 statusTd =3;

</script>



<div class="Block">
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input
					type="hidden" name="Add" type="submit" value="Add"
					class="button">
				<input
					type="hidden" name="Modify" type="submit" value="Modify"
					class="button"
					onClick="submitForm('searchDefectiveDrug','stores?method=modifyDefectiveDrug');">
				<input
					type="hidden" name="Reset" type="submit" value="Reset"
					class="button">
				<input
					type="hidden" name="Delete" type="submit" value="Delete"
					class="button">
				<input
					type="hidden" name="print" type="submit" class="button"
					value="print " onClick="">
					
					<input type="button" name="sss1" class="button" value="BACK" onClick="submitForm('searchDefectiveDrug','stores?method=showDefectiveDrugJsp');" />
					</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
				
<script type="text/javascript" language="javascript">
		
		data_header = new Array();
		
		data_header[0] = new Array;
		data_header[0][0] = "Radio"
		data_header[0][1] = "hide";
		data_header[0][2] = "15%";
		data_header[0][3] = "<%= RADIO_FOR_TABLE%>"
		
		data_header[1] = new Array;
		data_header[1][0] = "Defective Drug No."
		data_header[1][1] = "data";
		data_header[1][2] = "15%";
		data_header[1][3] = "<%= ENTRY_NO%>"
		
		data_header[2] = new Array;
		data_header[2][0] = "Entry Date"
		data_header[2][1] = "data";
		data_header[2][2] = "15%";
		data_header[2][3] = "<%= ENTRY_DATE %>";
		
		data_header[3] = new Array;
		data_header[3][0] = "Status"
		data_header[3][1] = "data";
		data_header[3][2] = "15%";
		data_header[3][3] = "<%=STATUS %>";
		
		
	
		
		data_arr = new Array();
		
		<%String st="";
		Iterator itrrr=gridDefectiveDrugHeaderList.iterator();
		          int  counter=0;
		          while(itrrr.hasNext())
		           {           
		        	  StoreDefectiveDrugM  storeDefectiveDrugM = (StoreDefectiveDrugM)itrrr.next(); 
		             %>
		
			data_arr[<%= counter%>] = new Array();
			
			data_arr[<%= counter%>][0] = <%= storeDefectiveDrugM.getId()%>
			data_arr[<%= counter%>][1] = '<input type="radio"  name="parent" value="<%= storeDefectiveDrugM.getId()%>" id="radio" />'
			data_arr[<%= counter%>][2] = "<%=storeDefectiveDrugM.getEntryNo()%>"
			data_arr[<%= counter%>][3]="<%=HMSUtil.convertDateToStringWithoutTime(storeDefectiveDrugM.getEntryDate())%>"
			 
             	
				<%if(storeDefectiveDrugM.getStatus().equals("y")){%>
						data_arr[<%= counter%>][4]="Active"
						<%}else{%>
						data_arr[<%= counter%>][4]="InActive"
						<%}%>
		<% counter++;
			}
		%>
		 
		formName = "searchDefectiveDrug"
		
		
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