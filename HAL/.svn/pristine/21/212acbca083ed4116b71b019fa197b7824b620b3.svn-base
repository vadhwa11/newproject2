<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * budget.jsp  
 * Purpose of the JSP -  This is for Budget Details
 * @author  Deepali
 * @author  Mansi
 * Create Date: 13th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.3  
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasStoreFinancial"%>
<%@page import="jkt.hms.masters.business.MasStoreBudget"%>
<%@page import="jkt.hms.masters.business.MasStoreBudgetT"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<br />
<div id="contentspace">
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	List<MasStoreFinancial> financialList = new ArrayList<MasStoreFinancial>();
	financialList = (ArrayList)map.get("financialList");
	
	ArrayList searchBudgetList = (ArrayList)map.get("searchBudgetList");
	ArrayList gridFinancialList = (ArrayList)map.get("gridFinancialList");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }


%>
<h2 align="left" class="style1">Budget Master</h2>

<div id="searcharea">

<div id="searchbar">

<form name="search" method="post" action=""><input type="radio"
	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" /> <font
	class="bodytextB_blue">Budget Code:</font> <input type="text"
	id="searchField" name="<%= CODE%>" value=""
	validate="Budget Code,string,no" MAXLENGTH="8" tabindex=1 /> <input
	type="button" name="search" value="Search" class="button"
	onclick="submitForm('search','pharmacy?method=searchBudget','checkSearch')"
	tabindex=1 /></form>

</div>

</div>

<br />
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<% 
		if(searchBudgetList.size() > 0)
		 {
			String strForCode = (String)map.get("budgetCode");
			if(strForCode!= null && strForCode!= "" )
			{
	%> <br />

<a href="pharmacy?method=showBudgetJsp">Show All Records</a> <%
			}
		 }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= FINANCIAL_ID %>"], [3,"<%= TOTAL_ALLOCATED_AMOUNT %>"], [4,"<%= CRV_COMMITTED_AMOUNT%>"], [5,"<%= UTILIZED_AMOUNT %>"],[6,"<%= PO_COMMITTED_AMOUNT %>"],[7,"<%= BALANCE_AMOUNT %>"],[8,"<%= AUTHORITY_LETTER_NO %>"],[9,"<%= PROJECT_AMOUNT %>"],[10,"<%= BUDGETED_AMOUNT %>"],[11,"<%= ADDITIONAL_ALLOCATED_AMOUNT %>"],[12,"<%=CHANGED_BY%>"],[13,"<%= CHANGED_DATE %>"],[14,"<%= CHANGED_TIME %>"],[15,"<%= STATUS %>"]];
	 statusTd = 15;
	</script></div>
<br />
<form name="budget" method="post" action=""><input type="hidden"
	name="<%= POJO_NAME %>" value="MasStoreBudget"> <input
	type="hidden" name="title" value="Budget"> <input type="hidden"
	name="<%=JSP_NAME %>" value="budgetEntry"> <input type="hidden"
	name="pojoPropertyCode" value="BudgetCode"> <br>


<div id=contentoperation><label class="bodytextB_blue"><font
	id="error">*</font>Budget Code</label> <input type="text" name="<%= CODE%>"
	value="" validate="Budget Code,string,yes" class="textbox_size20"
	MAXLENGTH="8" / tabindex=1> <script>
				document.budget.<%=CODE%>.focus();
			</script> <label class="bodytextB_blue"><font id="error">*</font>Financial
Year</label> <select name="<%= FINANCIAL_ID %>"
	validate="Financial Year,string,yes" tabindex=1>
	<option value="0">Select</option>
	<% 
			for (MasStoreFinancial  masStoreFinancial : financialList){
			%>
	<option value="<%=masStoreFinancial.getId ()%>"><%=HMSUtil.changeDateToddMMyyyy(masStoreFinancial.getStartDate()) %>
	- <%=HMSUtil.changeDateToddMMyyyy(masStoreFinancial.getEndDate()) %></option>
	<%}%>
</select> <label class="bodytextB_blue">Total Allocated Amt</label> <input
	type="text" name="<%= TOTAL_ALLOCATED_AMOUNT%>" value=""
	class="textbox_size20" MAXLENGTH="8" / tabindex=1> <br>
<br />

<label class="bodytextB_blue">CRV Comitted Amt</label> <input
	type="text" name="<%= CRV_COMMITTED_AMOUNT%>" value=""
	class="textbox_size20" MAXLENGTH="8" / tabindex=1> <label
	class="bodytextB_blue">Spend Amt</label> <input type="text"
	name="<%= UTILIZED_AMOUNT%>" value="" class="textbox_size20"
	MAXLENGTH="8" / tabindex=1> <label class="bodytextB_blue">SO
Commited Amt</label> <input type="text" name="<%= PO_COMMITTED_AMOUNT%>"
	value="" class="textbox_size20" MAXLENGTH="8" / tabindex=1> <br>
<br />

<label class="bodytextB_blue">Balance Amt</label> <input type="text"
	name="<%= BALANCE_AMOUNT%>" value="" class="textbox_size20"
	MAXLENGTH="8" / tabindex=1> <label class="bodytextB_blue">Authority
Letter No.</label> <input type="text" name="<%= AUTHORITY_LETTER_NO%>" value=""
	class="textbox_size20" MAXLENGTH="8" / tabindex=1> <label
	class="bodytextB_blue">Projected Amount</label> <input type="text"
	name="<%= PROJECT_AMOUNT%>" value="" class="textbox_size20"
	MAXLENGTH="8" / tabindex=1> <br>
<br />
<label class="bodytextB_blue">Budgeted Amount</label> <input type="text"
	name="<%= BUDGETED_AMOUNT%>" value="" class="textbox_size20"
	MAXLENGTH="8" / tabindex=1> <label class="bodytextB_blue">Additional
Allocated Amount</label> <input type="text"
	name="<%= ADDITIONAL_ALLOCATED_AMOUNT%>" value=""
	class="textbox_size20" MAXLENGTH="8" / tabindex=1> <br />
<br />
<label class="bodytextB_blue">Changed By:</label> <input type="text"
	name="<%= CHANGED_BY%>" value="<%=userName%>" class="textbox_size20"
	readonly="readonly" MAXLENGTH="8" / tabindex=3 /> <label id=biglabel
	class="bodytextB_blue">Changed Date:</label> <input type="text"
	name="<%= CHANGED_DATE %>" value="<%=date%>" class="textbox_size20"
	readonly="readonly" tabindex=3 /> <label class="bodytextB_blue">Changed
Time:</label> <input type="text" name="<%=CHANGED_TIME %>" value="<%=time%>"
	class="textbox_size20" readonly="readonly" tabindex=3 /></div>

<br />

<div id="edited"></div>
<label>&nbsp;</label> <input type="button" name="add" id="addbutton"
	value="Add" class="button"
	onClick="submitForm('budget','pharmacy?method=addBudget');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('budget','pharmacy?method=editBudget')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('budget','pharmacy?method=deleteBudget')"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset" id="reset"
	value="Reset" class="button" onclick="resetCheck();" accesskey="r" />

<input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= COMMON_ID%>" value="" /> <br />
</form>
</div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Budget Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "FinancialYear"
data_header[1][1] = "hide";
data_header[1][2] = 0;
data_header[1][3] = "<%= FINANCIAL_ID %>";

data_header[2] = new Array;
data_header[2][0] = "Total Allocated Amount"
data_header[2][1] = "data";
data_header[2][2] = "25%";
data_header[2][3] = "<%=TOTAL_ALLOCATED_AMOUNT %>";

data_header[3] = new Array;
data_header[3][0] = "CRV Comitted Amount"
data_header[3][1] = "data";
data_header[3][2] = "25%";
data_header[3][3] = "<%=CRV_COMMITTED_AMOUNT %>"


data_header[4] = new Array;
data_header[4][0] = "Spend Amount"
data_header[4][1] = "data";
data_header[4][2] = "25%";
data_header[4][3] = "<%=UTILIZED_AMOUNT %>"


data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%=PO_COMMITTED_AMOUNT %>"


data_header[6] = new Array;
data_header[6][0] = "Balance Amount"
data_header[6][1] = "hide";
data_header[6][2] = 0;
data_header[6][3] = "<%=BALANCE_AMOUNT %>"

data_header[7] = new Array;
data_header[7][0] = "Authority Letter No."
data_header[7][1] = "hide";
data_header[7][2] = 0;
data_header[7][3] = "<%= AUTHORITY_LETTER_NO %>";

data_header[8] = new Array;
data_header[8][0] = "Projected Amount"
data_header[8][1] = "data";
data_header[8][2] = "25%";
data_header[8][3] = "<%=PROJECT_AMOUNT %>";

data_header[9] = new Array;
data_header[9][0] = "Budgeted Amount"
data_header[9][1] = "data";
data_header[9][2] = "25%";
data_header[9][3] = "<%=BUDGETED_AMOUNT %>"

data_header[10] = new Array;
data_header[10][0] = "Additional Allocated Amount"
data_header[10][1] = "hide";
data_header[10][2] = 0;
data_header[10][3] = "<%=ADDITIONAL_ALLOCATED_AMOUNT %>"


data_header[11] = new Array;
data_header[11][0] = ""
data_header[11][1] = "hide";
data_header[11][2] = 0;
data_header[11][3] = "<%=CHANGED_BY %>"

data_header[12] = new Array;
data_header[12][0] = ""
data_header[12][1] = "hide";
data_header[12][2] = 0;
data_header[12][3] = "<%=CHANGED_DATE %>"

data_header[13] = new Array;
data_header[13][0] = ""
data_header[13][1] = "hide";
data_header[13][2] = 0;
data_header[13][3] = "<%=CHANGED_TIME %>"

data_header[14] = new Array;
data_header[14][0] = "Status"
data_header[14][1] = "data";
data_header[14][2] = 0;
data_header[14][3] = "<%=STATUS %>"

data_arr = new Array();

<%
Iterator itr=searchBudgetList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
        	  MasStoreBudget  masStoreBudget = (MasStoreBudget)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masStoreBudget.getId()%>

<% if(masStoreBudget.getBudgetCode() != null){%>
data_arr[<%= counter%>][1] = "<%=masStoreBudget.getBudgetCode()%>"
<%}%>

<% if(masStoreBudget.getFinancial() != null){%>
<%
		Iterator itrGridFinancialList=gridFinancialList.iterator();
		 while(itrGridFinancialList.hasNext())
            {try{
             MasStoreFinancial  financialGrid = (MasStoreFinancial)itrGridFinancialList.next(); 
			 if(masStoreBudget.getFinancial().getId().equals(financialGrid.getId()) && financialGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][2] = "<%=financialGrid.getStartDate()%>-<%=financialGrid.getEndDate()%>"
			<%}else if(masStoreBudget.getId().equals(financialGrid.getId()) && financialGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][2] = "<font id='error'>*</font>Parent InActivated--<%=financialGrid.getStartDate()%>-<%=financialGrid.getEndDate()%>";
				
			<%}
            }catch(Exception e){System.out.println("Exception----> "+e);}}%>
            <%}%>
<% if(masStoreBudget.getTotalAllocatedAmount() != null){%>           
data_arr[<%= counter%>][3] = <%= masStoreBudget.getTotalAllocatedAmount()%>
 <%}%>
<% if(masStoreBudget.getCrvComittedAmount() != null){%>
data_arr[<%= counter%>][4] = <%= masStoreBudget.getCrvComittedAmount()%>
 <%}%>
<% if(masStoreBudget.getUtilizedAmount() != null){%>
data_arr[<%= counter%>][5] = <%= masStoreBudget.getUtilizedAmount()%>
 <%}%>
<% if(masStoreBudget.getPoComittedAmount() != null){%>
data_arr[<%= counter%>][6] = <%= masStoreBudget.getPoComittedAmount()%>
 <%}%>
<% if(masStoreBudget.getBalanceAmount() != null){%>
data_arr[<%= counter%>][7] = <%= masStoreBudget.getBalanceAmount()%>
 <%}%> 
 
  
data_arr[<%= counter%>][7] = "<%= masStoreBudget.getLastChgBy() %>"
data_arr[<%= counter%>][8] = "<%= HMSUtil.convertDateToStringWithoutTime(masStoreBudget.getLastChgDate()) %>"
data_arr[<%= counter%>][9] = "<%= masStoreBudget.getLastChgTime() %>"
<% if(masStoreBudget.getStatus().equals("y")){ %>
data_arr[<%= counter%>][10] = "Active"
<%}else{%>
data_arr[<%= counter%>][10] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "budget"

nonEditable = ['<%=CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
