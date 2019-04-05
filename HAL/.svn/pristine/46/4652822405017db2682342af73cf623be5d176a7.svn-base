<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasStoreBudget"%>

<%@page import="jkt.hms.masters.business.MasStoreFinancial"%>
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
<%		List<MasStoreBudget> searchBudgetList= new ArrayList<MasStoreBudget>();
				
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
	System.out.println("This is Detail JSP");
	Map map = new HashMap();
		String includedJsp="";
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
			
		}
		List<MasStoreBudget> gridIndentHeaderList= new ArrayList<MasStoreBudget>();
					
		try{
			gridIndentHeaderList=(List)map.get("gridIndentHeaderList");
			//financialList=(List)map.get("financialList");
			searchBudgetList=(List)map.get("searchBudgetList");
		}catch(Exception e){
			System.out.println("In Deatail Jsp");
		}
		List<MasStoreFinancial> financialList = (ArrayList)map.get("financialList");
				
		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
	
	%>

<div id="contentspace"><br />

<form name="searchBudgetEntry" method="post" action="">


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
					onClick="submitForm('searchBudgetEntry','pharmacy?method=showBudgetJsp');" /></td>
				<td width="1%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="10%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Modify" value="Modify" class="toolbutton"
					onClick="submitForm('searchBudgetEntry','pharmacy?method=modifyBudgetEntry');" /></td>
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
			name="searchthreadid" value="85875" /> <label class="bodytextB_blue">Finance:</label>
		<select name="<%= SEARCH_FINANCIAL_ID%>">
			<option value="0">Select</option>
			<% 
			for (MasStoreFinancial  masStoreFinancial : financialList){
			%>
			<option value="<%=masStoreFinancial.getId ()%>"><%=HMSUtil.changeDateToddMMyyyy(masStoreFinancial.getStartDate()) %></option>
			<%}%>
		</select> <input type="button" class="smbutton" value="Go!"
			onClick="submitForm('searchBudgetEntry','pharmacy?method=searchBudgetEntry');" />
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
			[0, "<%= BUDGET_ID%>", "id"],[1, "<%= BUDGET_CODE%>"], [2,"<%= FINANCIAL_ID%>"], [3,"<%= TOTAL_ALLOCATED_AMOUNT %>"], [4,"<%= CRV_COMMITTED_AMOUNT %>"],[5,"<%=UTILIZED_AMOUNT%>"],[6,"<%=PO_COMMITTED_AMOUNT%>"],[7,"<%= CHANGED_BY %>"], [8,"<%= CHANGED_DATE %>"],[9,"<%= CHANGED_TIME %>"] ];
	 statusTd =9;

</script>
<script type="text/javascript" language="javascript">
		
		data_header = new Array();
		
		data_header[0] = new Array;
		data_header[0][0] = "Radio"
		data_header[0][1] = "radio";
		data_header[0][2] = "15%";
		data_header[0][3] = "<%= RADIO_FOR_TABLE%>"
		
		data_header[1] = new Array;
		data_header[1][0] = "Budget Code"
		data_header[1][1] = "data";
		data_header[1][2] = "15%";
		data_header[1][3] = "<%= BUDGET_CODE%>"
		
		data_header[2] = new Array;
		data_header[2][0] = "Financial Year"
		data_header[2][1] = "data";
		data_header[2][2] = "15%";
		data_header[2][3] = "<%= FINANCIAL_ID %>";
		
		data_header[3] = new Array;
		data_header[3][0] = "Total Allocated Amount"
		data_header[3][1] = "data";
		data_header[3][2] = "15%";
		data_header[3][3] = "<%=TOTAL_ALLOCATED_AMOUNT %>";
		
		data_header[4] = new Array;
		data_header[4][0] = "Crv Committed Amount"
		data_header[4][1] = "data";
		data_header[4][2] = "15%";
		data_header[4][3] = "<%=CRV_COMMITTED_AMOUNT %>";
		
	
		
		
		data_header[5] = new Array;
		data_header[5][0] = "Utilized Amount"
		data_header[5][1] = "data";
		data_header[5][2] = "15%";
		data_header[5][3] = "<%=UTILIZED_AMOUNT %>";
		
		data_header[6] = new Array;
		data_header[6][0] = "Po Commited Amount"
		data_header[6][1] = "data";
		data_header[6][2] = "15%";
		data_header[6][3] = "<%=PO_COMMITTED_AMOUNT %>";
		
		
		
	data_header[7] = new Array;
	data_header[7][0] = " Changed By"
	data_header[7][1] = "data";
	data_header[7][2] = 0;
	data_header[7][3] = "<%= CHANGED_BY %>"

	data_header[8] = new Array;
	data_header[8][0] = "Changed Date"
	data_header[8][1] = "data";
	data_header[8][2] = 0;
	data_header[8][3] = "<%= CHANGED_DATE %>"


	data_header[9] = new Array;
	data_header[9][0] = "Changed Time "
	data_header[9][1] = "data";
	data_header[9][2] = "15%";
	data_header[9][3] = "<%= CHANGED_TIME %>";
		
		
		data_arr = new Array();
		
		<%String st="";
		Iterator itrrr=gridIndentHeaderList.iterator();
		          int  counter=0;
		          while(itrrr.hasNext())
		           {           
		        	  MasStoreBudget  masStoreBudget = (MasStoreBudget)itrrr.next(); 
		             %>
		
			data_arr[<%= counter%>] = new Array();
			
			data_arr[<%= counter%>][0] = <%= masStoreBudget.getId()%>
			data_arr[<%= counter%>][1] = '<input type="radio"  name="parent" value="<%= masStoreBudget.getId()%>" id="radio" />'
			data_arr[<%= counter%>][2] = "<%=masStoreBudget.getBudgetCode()%>"

<%
		Iterator itrGridFinancialList=financialList.iterator();
		 while(itrGridFinancialList.hasNext())
            {try{
             MasStoreFinancial  financialGrid = (MasStoreFinancial)itrGridFinancialList.next(); 
			 if(masStoreBudget.getFinancial().getId().equals(financialGrid.getId()) && financialGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][3] = "<%=HMSUtil.convertDateToStringWithoutTime(financialGrid.getStartDate())%>"
			<%}else if(masStoreBudget.getId().equals(financialGrid.getId()) && financialGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=HMSUtil.changeDateToddMMyyyy(financialGrid.getStartDate())%>";
				
			<%}
            }catch(Exception e){System.out.println("Exception----> "+e);}}%>
			data_arr[<%= counter%>][4]="<%= masStoreBudget.getTotalAllocatedAmount()%>"
			data_arr[<%= counter%>][5]="<%= masStoreBudget.getCrvComittedAmount()%>"
			data_arr[<%= counter%>][6]="<%= masStoreBudget.getUtilizedAmount()%>"
			data_arr[<%= counter%>][7]="<%= masStoreBudget.getPoComittedAmount()%>"
			data_arr[<%= counter%>][8] = "<%= masStoreBudget.getLastChgBy() %>"
			data_arr[<%= counter%>][9] = "<%= HMSUtil.convertDateToStringWithoutTime(masStoreBudget.getLastChgDate()) %>"
			data_arr[<%= counter%>][10] = "<%= masStoreBudget.getLastChgTime() %>"
		<% counter++;
			}
		%>
		 
		formName = "searchBudgetEntry"
		
		
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