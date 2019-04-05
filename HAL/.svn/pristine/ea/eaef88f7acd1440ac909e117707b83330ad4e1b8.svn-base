<%@page import="jkt.hms.masters.business.MasBudgetCode"%>
<%@page import="java.util.*"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasStoreFinancial"%>
<%@page import="jkt.hms.masters.business.MasStoreBudget"%>
<%@page import="java.math.BigDecimal"%>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->

function submitBudgetDetails(amt1,amt2,amt3,totamt)
{
	if (amt2 > 0 && amt3>0)
	{
		alert('Either Allotted or Additional Alotted Amount should be entered!..');
		return;
	}
	else if (amt2 <= 0 && amt3 <= 0)
	{
		alert('Either Allotted or Additional Alotted Amount should be entered!..');
		return;
	}
	else
	{
		if (amt2 > 0)
		{
			var temp = parseFloat(totamt) + parseFloat(amt2);
			if (temp  > 999999999999)
			{
			alert('Total Allocated Amount Exceeds the limit!.... Kindly Check the Allotted Amt...');
			return;
			}
		}
		else
		{
			var temp = parseFloat(totamt) + parseFloat(amt3);
			if (temp  > 999999999999)
			{
			alert('Total Allocated Amount Exceeds the limit!.... Kindly Check the Allotted Amt...');
			return;
			}
		}
		submitForm('budgetEntryGrid','pharmacy?method=addBudgetDetails')
	}
}

</script>
<script language="javascript" type="text/javascript">
function shut1()
{
 alert("Bye");
 }
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

<%
	Map<String,Object> map = new HashMap<String,Object>();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	String userName = "";

	int pageNo=1;
	if (map.get("pageNo") != null) {
		pageNo = Integer.parseInt(""+map.get("pageNo"));
	}

	int budgetId=0;
	if(map.get("budgetId")!=null){
		budgetId=Integer.parseInt(""+map.get("budgetId"));
	}

	int expStoreCode = 0;
	if (map.get("ExpStoreCode")!=null)
	{
		expStoreCode = (Integer) map.get("ExpStoreCode");
	}

	int financialId =0;
	if(map.get("financialId")!=null){
		financialId =Integer.parseInt(""+map.get("financialId"));
	}

	String budgetCode="";
	if(map.get("budgetCode")!=null){
		budgetCode=map.get("budgetCode").toString();
	}
	int curFinancialId=0;
	if(map.get("maxFina")!=null){
		curFinancialId=Integer.parseInt(map.get("maxFina").toString());
	}

	List<MasStoreBudget> searchBudgetList = new ArrayList<MasStoreBudget>();
	//List budgetDetailsList = new ArrayList();
	if(map.get("searchMasStoreBudgetList")!=null)
		searchBudgetList = (List) map.get("searchBudgetList");

	//if(map.get("budgetDetailsList")!=null){
		//budgetDetailsList = (List) map.get("budgetDetailsList");
	//}
     List<MasBudgetCode> codes=new ArrayList<MasBudgetCode>();
     if(map.get("budgetCodes")!=null)
     {
    	 codes=(List)map.get("budgetCodes");
     }
    //System.out.println("===="+codes.size());
	String previousPage="no";
	if(map.get("previousPage")!=null){
		previousPage=(""+map.get("previousPage"));

	}

	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}

	List<MasStoreFinancial> financialList = new ArrayList<MasStoreFinancial>();
	financialList = (ArrayList)map.get("financialList");

	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	int hospitalId = 0;
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	int deptId = 0;
	if(session.getAttribute("deptId") != null){
		deptId = (Integer)session.getAttribute("deptId");
	}
%>
<%
if(map.get("message") != null)
{
	   String message = (String)map.get("message");
	    	   %>
	   <label class="auto"><span><%=message %></span></label>
	   <%
	  }
%>
<div class="titleBg">
<h2>Budget Master</h2>
</div>
<div class="clear"></div>
<body onload="getFinancialYearInfo()"  >
<form name="budgetEntryGrid" method="post">

<div id="testDiv">
		<div class="Block">
		<input type="hidden" name="deptId" value="<%=deptId%>" >
  		<label> Budget Code </label>
  		<select id = "budgetCode" name="budgetCode" onchange="getFinancialYearInfo()">
  		<%-- <% if (deptId == expStoreCode) {  %>
  		<option value="LCH749/01" <%=HMSUtil.isSelected("LCH749/01",budgetCode)%>>LCH749/01 (Exp.Store) </option>
  		<% } else { %>
  		<option value="LCH363/01" <%=HMSUtil.isSelected("LCH363/01",budgetCode)%>>LCH363/01 (ECHS Store) </option>
  		<% } %> --%>
  		<option value="0">Select</option>
		  <%for (MasBudgetCode  masBudgetCode : codes){

		  %>
		  <option value="<%=masBudgetCode.getId ()%>"><%=masBudgetCode.getBudgetCodeName()%></option>
		  <%}%>
  		</select>

		<label>Financial Year<span>*</span></label>
		<select id="financialId" name="<%= FINANCIAL_ID %>" validate="Financial Year,string,yes" onchange="getFinancialYearInfo()" tabindex=1>
		<option value="0">Select</option>
		  <%for (MasStoreFinancial  masStoreFinancial : financialList){

		  %>
		  <option value="<%=masStoreFinancial.getId ()%>" <%=HMSUtil.isSelected(masStoreFinancial.getId (),financialId)%> ><%=HMSUtil.changeDateToddMMyyyy(masStoreFinancial.getStartDate()) %> - <%=HMSUtil.changeDateToddMMyyyy(masStoreFinancial.getEndDate()) %></option>
		  <%}%>
		</select>
		</div>
		</div>
<div class="clear"></div>
<h4><U>BUDGET Allotment ENTRY</U></h4>
<div class="clear"></div>
<div class="Block">

<label  > Authority Letter No.<span>*</span></label>
<textarea name="<%= AUTHORITY_LETTER_NO%>" value=""  MAXLENGTH="100" tabindex=1  rows="5" cols="5"></textarea>
<!--<input type="text" name="<%= AUTHORITY_LETTER_NO%>" value=""  MAXLENGTH="100" tabindex=1 />

--><label>Projected Amount</label>
<input type="text" name="<%= PROJECT_AMOUNT%>" value=""  MAXLENGTH="12" tabindex=1 />
<div class="clear"></div>
<label >Allotted Amount</label>
<input type="text" name="<%= BUDGETED_AMOUNT%>" value=""  MAXLENGTH="12" tabindex=1 />

<label >Additional Allocation</label>
<input type="text" name="<%= ADDITIONAL_ALLOCATED_AMOUNT%>" value=""   MAXLENGTH="12" tabindex=1 />
</div>
<div class="clear"></div>
<input type="button" name="sss" class="button" value="ADD" onclick="submitForm('budgetEntryGrid','pharmacy?method=addBudgetDetails')"/>
<input type="button" name="sss" class="button" value="Search" onclick=""/>
<!--<input type="button" name="sss" class="button" value="Search" onclick="getFinancialYearInfo()"/>
<div class="clear"></div>-->
<div class="clear"></div>

<div class="Block">
<div class="clear"></div>
<div id="financial" style="display: none;"></div>

<div id="test" style="display: block;">
<label >Total Amount Allocated </label>
<input id="totalAmt" type="text" name="<%=TOTAL_ALLOCATED_AMOUNT %>" value="" readonly="readonly"  MAXLENGTH="15" tabindex=1 />

<label >Total Amount Booked </label>
<input type="text" id="crvAmt" name="<%=CRV_COMMITTED_AMOUNT %>" value="" readonly="readonly"  MAXLENGTH="15" tabindex=1 />



<label >Total Amount Spent </label>
<input type="text" id="soAmt"  name="<%=PO_COMMITTED_AMOUNT %>" value="" readonly="readonly"  MAXLENGTH="15" tabindex=1 />
	<div class="clear"></div>
<label >Amount Spent% </label>
<input type="text" id="prevSpendAmt" name="<%=PREVIOUS_SPEND_AMOUNT %>" value="" readonly="readonly"   MAXLENGTH="15" tabindex=1 />
<div class="clear"></div>
<label >Total Amount Balance </label>
		<input type="text" id="balance" name="<%= BALANCE_AMOUNT%>" value="" readonly="readonly"  MAXLENGTH="15" tabindex=1 />

		<div style="display:none;">
		<label >Spent Amount</label>
		<input type="text" id="spendAmt" name="<%= SPEND_AMOUNT%>" value=""  onblur="calulateBalanceAmount(this.value)" MAXLENGTH="15" tabindex=1 />
		</div>
		<!--<label >Balance Amount</label>
		<input type="text" id="balance" name="<%= BALANCE_AMOUNT%>" value="" readonly="readonly"  MAXLENGTH="15" tabindex=1 />
		-->
        <input type="text" id="maxFina" name="maxFinaNo" value="<%=curFinancialId%>"  tabindex=1 />

		</div>
		</div>
		<div class="clear"></div>


<div class="clear"></div>
<div class="division"></div>
		<%--- Report Button   --%>
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_store_budjet">
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<label>Changed By</label>
		<!--  <input type="text" name="<%= CHANGED_BY%>" value=""  readonly="readonly" MAXLENGTH="15" tabindex=3 />-->
<label class="value" ><%=userName%></label>
<label>Changed Date</label>
		<!-- <input type="text" name="<%= CHANGED_DATE %>" value="<%=date%>"   readonly="readonly" tabindex=3 />-->
			<label class="value" ><%=date%></label>
<label>Changed Time</label>
		<!-- <input type="text" name="<%=CHANGED_TIME %>"  value="<%=time%>"  readonly="readonly" tabindex=3 />-->
<label class="value" ><%=time%></label>

	<input type="hidden" name="<%=HOSPITAL_ID %>"  value="<%=hospitalId%>" />
</div>

<div class="clear"></div>

</form>
</body>
	<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script>
	<input type="hidden" name="rows" id="rr" value="1"/>



<script>
<% if (financialId!=0 && budgetCode!="") { %>
getFinancialYearInfo();
<% } %>
</script>

