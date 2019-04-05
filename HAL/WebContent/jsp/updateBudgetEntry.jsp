<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="java.util.List"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>

<%@page import="jkt.hms.masters.business.MasStoreBudget"%>
<%@page import="jkt.hms.masters.business.MasStoreFinancial"%>
<%@page import="jkt.hms.masters.business.MasStoreBudgetT"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />

<link rel="stylesheet" href="/hms/jsp/css/acnik.css" type="text/css" />
<script type="text/javascript" src="/hms/jsp/js/acnik.js"></script>
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

<script type="text/javascript" language="javascript">

var itemsArray1=new Array();
  function fillItemsMmf(idVal,rowVal){
  		var idItem="idItem";
    	var codeItem="codeItem";
    	var nameItem="nameItem";
    	var idAu="idAu";
    	
    	idItem=idItem+rowVal;
    	
    	codeItem=codeItem+rowVal;
    	nameItem=nameItem+rowVal;
    	
    	idAu=idAu+rowVal;
    	document.getElementById('noOfRecords').value=rowVal
		for(i=0;i<itemsArray1.length;i++){
		if(itemsArray1[i][0]==idVal){
			
		document.getElementById(idItem).value=itemsArray1[i][0]
		document.getElementById(nameItem).value=itemsArray1[i][2]
		document.getElementById(idAu).value=itemsArray1[i][3]
		}
		}
	
  }
  function fillValuesBudgetEntry(inc)
  {
    	var projectAmount="projectAmount";
    	var projectAmountTemp="projectAmountTemp";
    	
    	var authorityLetterNo="authorityLetterNo";
    	var authorityLetterNoTemp="authorityLetterNoTemp";
    	
    	var budgetedAmount="budgetedAmount";
    	var budgetedAmountTemp="budgetedAmountTemp";
    	
    	var additionalAllocatedAmount="additionalAllocatedAmount";
    	var additionalAllocatedAmountTemp="additionalAllocatedAmountTemp";
    	document.getElementById('noOfRecords').value=inc
    	document.getElementById(projectAmount+inc).value=document.getElementById(projectAmountTemp+inc).value
    	document.getElementById(authorityLetterNo+inc).value=document.getElementById(authorityLetterNoTemp+inc).value
    	document.getElementById(budgetedAmount+inc).value=document.getElementById(budgetedAmountTemp+inc).value
    	document.getElementById(additionalAllocatedAmount+inc).value=document.getElementById(additionalAllocatedAmountTemp+inc).value
  }



  function checkForNext(){
  if(document.getElementById('noOfRecords').value<10)
  {
  	alert("All rows are not filled.To continue press Submit ")
  	return false;
  }else{
  return true;
  }
  }
  
  function checkForSubmit(){
  if(document.getElementById('noOfRecords').value==0)
  {alert("There must be one detail row");
  return false;
  }else{
  return true;
  }
  }
   function removeRow(obj)
 		
	{
	   
		if(document.getElementById("budgetDetails").childNodes[1].childNodes.length>1)	
		{
			
			//tt = document.getElementById("budgetDetails");
		   // tt = document.getElementById("budgetDetails").childNodes[1].removeChild(obj.parentNode.parentNode);
			//tt.deleteRow(document.getElementById("budgetDetails").childNodes[1])
			
			document.getElementById('budgetDetails').deleteRow(2)
			
      		alert(" ifww")
      		
      		
		}
		else
		{
			
		 	alert("Bill should have atleast one row");
		}
		numLinesAdded--;
	}
 
	function generateRow() {
	
		var d=document.getElementById("budgetDetails").getElementsByTagName("tr");
		lastTr = d[d.length-1]		
		clone = lastTr.cloneNode(true);
		clone.id = parseInt(lastTr.id);
		numLinesAdded++;
		
		 
        lastTr.parentNode.insertBefore(clone,lastTr.nextSibling)
        
        obj1 = document.getElementById('SRNo');          
     	obj1.value=numLinesAdded;
        
        
       
       
	}
	


	
function get_value()
{
 var url="/hms/jsp/window.jsp";
   popwindow(url);
 }  

var newwindow;
function popwindow(url)
{

 newwindow=window.open(url,'name',"height=500,width=600,status=1");
 if (window.focus) 
 {
 newwindow.focus()
 }
newwindow.createPopup();

}

	
</script>
<%
	Map<String,Object> map = new HashMap<String,Object>();
	String includedJsp = null;
	String previousPage="no";
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	int pageNo=1;
	int budgetId=0;
		List<MasStoreBudget> searchBudgetList = new ArrayList<MasStoreBudget>();
		List<MasStoreFinancial> financialList= new ArrayList<MasStoreFinancial>();
		List<MasStoreBudget> previousMasStoreBudgetList=new ArrayList<MasStoreBudget>();
		List<MasStoreBudgetT> gridMasStoreBudgetTList=new ArrayList<MasStoreBudgetT>();
		List<MasStoreBudget> gridMasStoreBudgetList= new ArrayList<MasStoreBudget>();
		int bugdetCode=0;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}
	if(map.get("budgetId")!=null){
		budgetId=Integer.parseInt(""+map.get("budgetId"));
		System.out.print("  budgetId    "+budgetId);
	}
	
	if (map.get("pageNo") != null) {
		pageNo = Integer.parseInt(""+map.get("pageNo"));
		System.out.println("pageNo  -----------------------                  "+pageNo);
	}

	if(map.get("bugdetCode")!=null)
		bugdetCode=Integer.parseInt(""+map.get("bugdetCode"));
	
	if(map.get("financialList")!=null)
	financialList=(List) map.get("financialList");
	
	if(map.get("previousMasStoreBudgetList")!=null)
		previousMasStoreBudgetList=(List) map.get("previousMasStoreBudgetList");
	
	if(map.get("budgetTList")!=null){
		gridMasStoreBudgetTList=(List) map.get("budgetTList");
		System.out.println("333333333333333333333333333333 "+((List)map.get("budgetTList")).size());
		
	}
	if(map.get("budgetList")!=null)
		gridMasStoreBudgetList=(List) map.get("budgetList");
	
	
	if(map.get("searchBudgetList")!=null)
	searchBudgetList = (List) map.get("searchBudgetList");
	

%>


<div id="contentspace">

<form name="budgetEntry" method="post"><br />

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
					onClick="submitForm('poMain','purchaseOrder?method=poModifyJsp');"></td>
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

<form name="searchPanel" method="post">
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
			validate="Pick a date"
			onClick="setdate('<%=currentDate%>',document.budgetEntry.<%= FROM_DATE%>,true);"
			class="calender" /> <label class="bodytextB_blue">To Date :</label>

		<input type="text" name="<%= TO_DATE %>" class="textbox_date"
			MAXLENGTH="30" / tabindex=1 /> <img id="calendar"
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onClick="setdate('<%=currentDate%>',document.budgetEntry.<%= TO_DATE%>,true);"
			class="calender" /> <br />
		<label class="bodytextB_blue">Finance:</label> <select
			name="<%= SEARCH_FINANCIAL_ID %>">
			<option value="0">Select</option>
			<% 
			for (MasStoreFinancial  masStoreFinancial : financialList){
			%>
			<option value="<%=masStoreFinancial.getId ()%>"><%=HMSUtil.changeDateToddMMyyyy(masStoreFinancial.getStartDate()) %></option>
			<%}%>
		</select> <input type="button" class="smbutton" value="Go!"
			onClick="submitForm('budgetEntry','pharmacy?method=searchBudgetEntry');" />
		</td>
	</tr>

</table>
</form>
</div>
</div>
</div>
<jsp:include page="searchResultPO.jsp" /> <br />








</form>

<form name="budgetEntryGrid" method="post">


<div id="testDiv" size="height:500px;">
<%if(previousPage.equals("no")){ 
			for(MasStoreBudget grMasStoreBudget:gridMasStoreBudgetList){
			%> <input type="hidden" name="totalRecords"
	value="<%=gridMasStoreBudgetTList.size() %>" /> <input type="hidden"
	name="pageNo" value="<%=pageNo%>" /> <label class="bodytextB_blue"><font
	id="error"></font> Budget Code </label> <input type="text"
	name="<%=BUDGET_CODE %>" value="<%=grMasStoreBudget.getBudgetCode()%>"
	readonly="readonly" class="textbox_size20" MAXLENGTH="15"/  > <label
	class="bodytextB_blue"><font id="error">*</font>Financial Year:</label>
<select name="<%= FINANCIAL_ID %>" validate="Financial Year,string,yes"
	tabindex=1>
	<option value="0">Select</option>
	<%
				for (MasStoreFinancial masStoreFinancial :financialList ) {
					if(grMasStoreBudget.getFinancial().getId() == masStoreFinancial.getId()){
			%>

	<option value=<%=masStoreFinancial.getId()%> selected="selected"><%=HMSUtil.changeDateToddMMyyyy(masStoreFinancial.getStartDate())%></option>

	<%}else{ %>
	<option value="<%=masStoreFinancial.getId()%>"><%=HMSUtil.changeDateToddMMyyyy(masStoreFinancial.getStartDate())%></option>
	<%}
						}
					%>
</select> <label class="bodytextB_blue"><font id="error">*</font>Total
Allocated Amt</label> <input type="text" name="<%= TOTAL_ALLOCATED_AMOUNT%>"
	value="<%=grMasStoreBudget.getTotalAllocatedAmount()%>"
	validate="Total Allocated Amt,float,yes" class="textbox_size20"
	MAXLENGTH="8" / tabindex=1> <br>
<br />
<label class="bodytextB_blue"><font id="error">*</font>CRV
Comitted Amt</label> <input type="text" name="<%= CRV_COMMITTED_AMOUNT%>"
	value="<%=grMasStoreBudget.getCrvComittedAmount()%>"
	validate="CRV Comitted Amt,float,yes" class="textbox_size20"
	MAXLENGTH="8" / tabindex=1> <label class="bodytextB_blue">Utilized
Amt</label> <input type="text" name="<%= UTILIZED_AMOUNT%>"
	value="<%=grMasStoreBudget.getUtilizedAmount()%>"
	validate="Utilized Amt,float,no" class="textbox_size20" MAXLENGTH="8"
	/ tabindex=1> <label class="bodytextB_blue">PO
Commited Amt</label> <input type="text" name="<%= PO_COMMITTED_AMOUNT%>"
	value="<%=grMasStoreBudget.getPoComittedAmount()%>"
	validate="PO Commited Amt,float,no" class="textbox_size20"
	MAXLENGTH="8" / tabindex=1> <br />
<br />
<label class="bodytextB_blue">Changed By:</label> <input type="text"
	name="<%= CHANGED_BY%>" value="<%=userName%>" class="textbox_size20"
	readonly="readonly" MAXLENGTH="8" / tabindex=3 /> <label id=biglabel
	class="bodytextB_blue">Changed Date:</label> <input type="text"
	name="<%= CHANGED_DATE %>" value="<%=date%>" class="textbox_size20"
	readonly="readonly" tabindex=3 /> <label class="bodytextB_blue">Changed
Time:</label> <input type="text" name="<%=CHANGED_TIME %>" value="<%=time%>"
	class="textbox_size20" readonly="readonly" tabindex=3 /> <br>


<input type="hidden" name="<%=NO_OF_ROWS%>" id="rr" value="22" /> <%
			}	
			}else{ 
					for(MasStoreBudget masStoreBudget:previousMasStoreBudgetList){
						System.out.print("123421111111111111111111111 ");

				%> <input type="hidden" name="pageNo" value="<%=pageNo%>" /> <label
	class="bodytextB_blue"><font id="error"></font> Budget Code </label> <input
	type="text" name="<%=BUDGET_CODE %>" value="LCH794/01"
	readonly="readonly" class="textbox_size20" MAXLENGTH="15"/  > <label
	class="bodytextB_blue"><font id="error">*</font>Financial Year:</label>
<select name="<%= FINANCIAL_ID %>" validate="Financial Year,string,yes"
	tabindex=1>
	<option value="0">Select</option>
	<% 
			for (MasStoreFinancial  masStoreFinancial : financialList){
			%>
	<option value="<%=masStoreFinancial.getId ()%>"><%=HMSUtil.changeDateToddMMyyyy(masStoreFinancial.getStartDate()) %></option>
	<%}%>
</select> <label class="bodytextB_blue"><font id="error">*</font>Total
Allocated Amt</label> <input type="text" name="<%= TOTAL_ALLOCATED_AMOUNT%>"
	value="" validate="Total Allocated Amt,float,yes"
	class="textbox_size20" MAXLENGTH="8" / tabindex=1> <br>
<br />
<label class="bodytextB_blue"><font id="error">*</font>CRV
Comitted Amt</label> <input type="text" name="<%= CRV_COMMITTED_AMOUNT%>"
	value="" validate="CRV Comitted Amt,float,yes" class="textbox_size20"
	MAXLENGTH="8" / tabindex=1> <label class="bodytextB_blue">Utilized
Amt</label> <input type="text" name="<%= UTILIZED_AMOUNT%>" value=""
	validate="Utilized Amt,float,no" class="textbox_size20" MAXLENGTH="8"
	/ tabindex=1> <label class="bodytextB_blue">PO
Commited Amt</label> <input type="text" name="<%= PO_COMMITTED_AMOUNT%>"
	value="" validate="PO Commited Amt,float,no" class="textbox_size20"
	MAXLENGTH="8" / tabindex=1> <br />
<br />
<label class="bodytextB_blue">Changed By:</label> <input type="text"
	name="<%= CHANGED_BY%>" value="<%=userName%>" class="textbox_size20"
	readonly="readonly" MAXLENGTH="8" / tabindex=3 /> <label id=biglabel
	class="bodytextB_blue">Changed Date:</label> <input type="text"
	name="<%= CHANGED_DATE %>" value="<%=date%>" class="textbox_size20"
	readonly="readonly" tabindex=3 /> <label class="bodytextB_blue">Changed
Time:</label> <input type="text" name="<%=CHANGED_TIME %>" value="<%=time%>"
	class="textbox_size20" readonly="readonly" tabindex=3 /> <input
	type="hidden" name="<%=NO_OF_ROWS%>" id="rr" value="22" /> <%}} %> <br />
<input type="hidden" class="button" value="Add Row"
	onclick="generateRow();" align="right" /> <input type="hidden"
	class="button" value="Remove Row" onclick="removeRow(this)"
	align="right" /> <input type="button" class="button" value="Previous"
	d
	onclick="submitForm('budgetEntryGrid','pharmacy?method=previousMasStoreBudget');"
	align="right" /> <input type="button" class="button" value="Next"
	onclick="if(checkForNext()){submitForm('budgetEntryGrid','pharmacy?method=updateNextMasStoreBudget');}"
	align="right" /> <input type="button" name="sss" align="right"
	class="button" value="Submit"
	onclick="if(checkForSubmit()){submitForm('budgetEntryGrid','pharmacy?method=updateNextBudgetEntry');}" />
Page No:<%=pageNo%> <input type="text" size="2" value="10"
	name="noOfRecords" id="noOfRecords" /> <input type="text"
	name="<%=BUDGET_ID %>" value="<%=budgetId%>" id="hdb" /> <br />
<fieldset style="width: 99%; padding-left: 9px;"><legend>Budget
details</legend>


<div
	style="overflow: auto; width: 100%; height: 260px; padding-left: 9px;">
<table width="200px" colspan="7" id="budgetDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>

			<td width="5%"><label valign="left" class="smalllabel">SR
			No</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Authority
			Letter No.</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Project
			Amount</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Budgeted
			Amount</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Additional
			allocated Amount</label></td>


		</tr>

	</thead>
	<tbody>


		<%
    	int detailCounter=10; 
    	int temp=0;
       	String authorityLetterNo="authorityLetterNo";
    	String projectAmount="projectAmount";
    	String budgetedAmount="budgetedAmount";
    	String additionalAllocatedAmount="additionalAllocatedAmount";
    	
    	String authorityLetterNoTemp="authorityLetterNoTemp";
    	String projectAmountTemp="projectAmountTemp";
    	String budgetedAmountTemp="budgetedAmountTemp";
    	String additionalAllocatedAmountTemp="additionalAllocatedAmountTemp";
    	String incVar="incVar";
    	
    	
    	String authorityLetterNo2="authorityLetterNo";
    	String projectAmount2="projectAmount";
    	String budgetedAmount2="budgetedAmount";
    	String additionalAllocatedAmount2="additionalAllocatedAmount";

    	String authorityLetterNoTemp2="authorityLetterNoTemp";
    	String projectAmountTemp2="projectAmountTemp";
    	String budgetedAmountTemp2="budgetedAmountTemp";
    	String additionalAllocatedAmountTemp2="additionalAllocatedAmountTemp";
    	String incVar2="incVar2";
    	

		
		if(previousPage.equals("no")){ 
			System.out.println("000000000000000000000"+gridMasStoreBudgetTList.size());
			int inc=((pageNo-1)*10)+1;
	    	   System.out.println("--------------inc -----------   "+inc);
	    	   int incTemp2=inc+10;
	    	   for(MasStoreBudgetT masStoreBudgetT:gridMasStoreBudgetTList){
	    		 
	    		  if(inc<=incTemp2){
	    			   System.out.println("99999999999999999999999999999999999999999 ");
		
		%>
		<td width="10%">
		<%
    	
    	
    	authorityLetterNo=authorityLetterNo2+(""+inc);
 		projectAmount=projectAmount2+(""+inc);
 		budgetedAmount=budgetedAmount2+(""+inc);
 		additionalAllocatedAmount=additionalAllocatedAmount2+(""+inc);

 		authorityLetterNoTemp=authorityLetterNoTemp2+(""+inc);
 		projectAmountTemp=projectAmountTemp2+(""+inc);
 		budgetedAmountTemp=budgetedAmountTemp2+(""+inc);
 		additionalAllocatedAmountTemp=additionalAllocatedAmountTemp2+(""+inc);
 		incVar=incVar2+(""+inc);	
     	 

    	  %>
		<tr>

			<td width="5%"><input type="text" size="2"
				value="<%=masStoreBudgetT.getSrNo()%>" class="smcaption"
				name="<%=SR_NO%>" readonly="readonly" /></td>
			<input type="hidden" name="<%= BUDGET_T_ID%>"
				value="<%=masStoreBudgetT.getId()%>" />

			<td width="10%"><input type="text"
				value="<%=masStoreBudgetT.getAuthorityLetterNo() %>"
				class="medcaption" name="<%=AUTHORITY_LETTER_NO_BUDGET_ENTRY%>"
				tabindex="2" id="<%=authorityLetterNoTemp%>"
				onblur="fillValuesBudgetEntry(<%=inc%>);" /> <input type="hidden"
				value="0" class="medcaption" name="<%=AUTHORITY_LETTER_NO%>"
				tabindex="2" id="<%=authorityLetterNo%>" /></td>

			<td width="10%"><input type="text"
				value="<%=masStoreBudgetT.getProjectAmount() %>" class="medcaption"
				name="<%=PROJECT_AMOUNT_BUDGET_ENTRY%>" tabindex="2"
				id="<%=projectAmountTemp%>"
				onblur="fillValuesBudgetEntry(<%=inc%>);" /> <input type="hidden"
				value="0" class="medcaption" name="<%=PROJECT_AMOUNT%>" tabindex="2"
				id="<%=projectAmount%>" /></td>

			<td width="3%"><input type="text" class="medcaption"
				value="<%=masStoreBudgetT.getBudgetedAmount() %>"
				name="<%=BUDGETED_AMOUNT_BUDGET_ENTRY%>" tabindex="2"
				id="<%=budgetedAmountTemp%>"
				onblur="fillValuesBudgetEntry(<%=inc%>);" /> <input type="hidden"
				class="medcaption" value="0" name="<%=BUDGETED_AMOUNT%>"
				tabindex="2" id="<%=budgetedAmount%>" /></td>

			<td width="3%"><input type="text" class="medcaption"
				value="<%=masStoreBudgetT.getAdditionalAmount() %>"
				name="<%=ADDITIONAL_ALLOCATED_AMOUNT_BUDGET_ENTRY%>" tabindex="2"
				id="<%=additionalAllocatedAmountTemp%>"
				onblur="fillValuesBudgetEntry(<%=inc%>);" /> <input type="hidden"
				class="medcaption" value="0" name="<%=ADDITIONAL_ALLOCATED_AMOUNT%>"
				tabindex="2" id="<%=additionalAllocatedAmount%>" /></td>
		</tr>

		<% inc++;
     	 }
     	 }
	    	 %> <script>
	    	 document.budgetEntryGrid.noOfRecords.value=<%=inc%>
	    	 </script> <%
	    	   System.out.println("inc indc "+inc);
	    	   
	    		  if(inc<=10){
	    			  for(;inc<10;inc++){
	    			  %>
		<td width="5%"><input type="text" size="2" value="<%=temp+inc%>"
			class="smcaption" name="<%=SR_NO%>" readonly="readonly" /></td>


		<td width="10%"><input type="text" value="" class="medcaption"
			name="<%=AUTHORITY_LETTER_NO_BUDGET_ENTRY%>" tabindex="2"
			id="<%=authorityLetterNoTemp%>"
			onblur="fillValuesBudgetEntry(<%=inc%>);" /> <input type="hidden"
			value="0" class="medcaption" name="<%=AUTHORITY_LETTER_NO%>"
			tabindex="2" id="<%=authorityLetterNo%>" /></td>

		<td width="10%"><input type="text" value="" class="medcaption"
			name="<%=PROJECT_AMOUNT_BUDGET_ENTRY%>" tabindex="2"
			id="<%=projectAmountTemp%>" onblur="fillValuesBudgetEntry(<%=inc%>);" />
		<input type="hidden" value="0" class="medcaption"
			name="<%=PROJECT_AMOUNT%>" tabindex="2" id="<%=projectAmount%>" /></td>

		<td width="3%"><input type="text" class="medcaption" value=""
			name="<%=BUDGETED_AMOUNT_BUDGET_ENTRY%>" tabindex="2"
			id="<%=budgetedAmountTemp%>"
			onblur="fillValuesBudgetEntry(<%=inc%>);" /> <input type="hidden"
			class="medcaption" value="0" name="<%=BUDGETED_AMOUNT%>" tabindex="2"
			id="<%=budgetedAmount%>" /></td>

		<td width="3%"><input type="text" class="medcaption" value=""
			name="<%=ADDITIONAL_ALLOCATED_AMOUNT_BUDGET_ENTRY%>" tabindex="2"
			id="<%=additionalAllocatedAmountTemp%>"
			onblur="fillValuesBudgetEntry(<%=inc%>);" /> <input type="hidden"
			class="medcaption" value="0" name="<%=ADDITIONAL_ALLOCATED_AMOUNT%>"
			tabindex="2" id="<%=additionalAllocatedAmount%>" /></td>
		</tr>

		<% }  }
     	    %> <% } %>
		
	</tbody>

</table>
</fieldset>


</div>



</form>
<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script> <input type="hidden" name="rows" id="rr" value="1" />

</form>

</div>
