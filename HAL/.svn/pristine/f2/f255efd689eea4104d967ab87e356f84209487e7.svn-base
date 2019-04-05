<script type="text/javascript" language="javascript"	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<!-- <script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script> -->
<!-- <META HTTP-EQUIV="REFRESH" CONTENT="20"> -->
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>

<!--  <script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>-->

<script type="text/javascript" language="javascript"src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
<script type="text/javascript">
function ismaxlength(obj){
	var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""

	if (obj.getAttribute && obj.value.length>mlength)
	obj.value=obj.value.substring(0,mlength)
}
</script>
<script type="text/javascript" language="javascript">
<%
Calendar calendar=Calendar.getInstance();
String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
String getDate=String.valueOf(calendar.get(Calendar.DATE));
int year=calendar.get(calendar.YEAR);
if(month.length()<2){
month="0"+month;
}
if(getDate.length()<2){
getDate="0"+getDate;
}

%>
serverdate = '<%=getDate+"/"+month+"/"+year%>'
</script>

<%
	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");

	}

%>
<!--main content placeholder starts here-->
<form name="budgetAndExpense" action="" method="post">

<div class="titleBg">
<h2>Budget and Expense Entry</h2>
</div>

<div class="clear"></div>
<div class="Block">

<div class="clear paddingTop15"></div>
<h4>Budget Details</h4>
<div class="clear paddingTop15"></div>

<label>Budget for Year</label>
<input type="text" name="budgetForYear" />

<label>Major Code Head</label>
<input type="text" name="majorCodeHead" />

<label>Code Head</label>
<input type="text" name="codeHead" />

<div class="clear"></div>

<label>Budget Details</label>
<input type="text" name="budgetDetails" />

<label>Alloted Amount</label>
<input type="text" name="allotedAmount" />

<div class="clear paddingTop15"></div>
<h4>Expense Details</h4>
<div class="clear paddingTop15"></div>

<label>Date</label>
<input type="text" name="date" />

<label>Amount Alloted</label>
<input type="text" name="amountAlloted" />

<label>Expended Amount</label>
<input type="text" name="expendedAmount" />

<div class="clear"></div>

<label>Balance</label>
<input type="text" name="balance" />

<label>Remarks</label>
<input type="text" name="remarks" />

</div>

<div class="clear paddingTop15"></div>

<input type="button" class="button" value="Submit" />
<input type="button" class="button" value="Reset" />

</form>