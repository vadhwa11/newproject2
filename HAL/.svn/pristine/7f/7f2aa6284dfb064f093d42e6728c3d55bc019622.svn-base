<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.CssdAutoclaveRequestM"%>
<%@page import="jkt.hms.masters.business.CssdAutoclaveReceiptM"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />

<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/acnik.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>

<%
	Map<String ,Object> map = new HashMap<String ,Object>();
	String receiptNo = "";
	if(request.getAttribute("map") != null)
	{
		map = (Map<String ,Object>) request.getAttribute("map");
	}
	
	if (map.get("receiptNo")!=null)
	    receiptNo = map.get("receiptNo").toString();
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");
	ArrayList<MasEmployee> masEmployeeList = (ArrayList<MasEmployee>)map.get("masEmployeeList");
	List<CssdAutoclaveRequestM> cssdAutoclaveRequestMList = (ArrayList<CssdAutoclaveRequestM>)map.get("cssdAutoclaveRequestMList");
	List<CssdAutoclaveReceiptM> cssdAutoclaveReceiptMList = (ArrayList<CssdAutoclaveReceiptM>)map.get("cssdAutoclaveReceiptMList");
	
	String userName = "";
	String nameItem = "nameItem";
	if(session.getAttribute("userName") != null)
	{
		userName = (String)session.getAttribute("userName");
	}
%>


<script>
<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
	month="0"+month;
	}
	if(dateCal.length()<2){
	dateCal="0"+dateCal;
	}
%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script>



<script language="javascript">

function addAndRefreshAutoclaveReceiptGrid()
{
var receiptNo = document.getElementById('receiptNo').value;
var receiptDate = document.getElementById('receiptDate').value;
var receivedBy = document.getElementById('receivedBy').value;
var orderNo = document.getElementById('orderNo').value;

if (receiptNo =="" || receiptDate=="" || receivedBy==0 || orderNo ==0 )
{
	alert("Pl. Check your Inputs!...");
	return;
}
document.getElementById('goButton').disabled = true;
submitProtoAjax('autoclaveReceiptForm','/hms/hms/cssd?method=addAndRefreshAutoclaveReceiptGrid');
}

function getAutoclaveReceiptStockGridData()
{
	var receiptNo = document.getElementById('receiptNo').value;
	if (receiptNo == "<%=receiptNo%>")
	{
		autoclaveReceiptForm.method="post"; 
		submitForm('autoclaveReceiptForm','cssd?method=showAutoclaveReceiptJsp');
	}
	submitProtoAjax('autoclaveReceiptForm','/hms/hms/cssd?method=getAutoclaveReceiptStockGridData&pageno=1');
}


function updateAutoclaveReceiptGridData()
{
submitProtoAjax('autoclaveReceiptForm','/hms/hms/cssd?method=updateAutoclaveReceiptGridData');
}

function GoPage() 
{	
	var pgno = parseInt(autoclaveReceiptForm.gopage.value);
	var totalPages = parseInt(autoclaveReceiptForm.totalPages.value);
	
	if (pgno < 1 || pgno > totalPages)
	{
	alert('Invalid Page No!.....');
	return;
	}
	  
	autoclaveReceiptForm.pageno.value = pgno;
	submitProtoAjax('autoclaveReceiptForm','/hms/hms/cssd?method=getAutoclaveReceiptStockGridData'); 
}


function goNext()
{
 var pgno = parseInt(autoclaveReceiptForm.pageno.value)+1;
 
 if (pgno > autoclaveReceiptForm.totalPages.value)
 {
 alert('End of the File Reached!... ');
 return;
 }
 
 autoclaveReceiptForm.pageno.value = pgno;
 submitProtoAjax('autoclaveReceiptForm','/hms/hms/cssd?method=getAutoclaveReceiptStockGridData');
}


function goPrevious()
{
 var pgno = parseInt(autoclaveReceiptForm.pageno.value)-1;
 
 if (pgno < 1)
 {
 alert('Beginning of the File Reached!... ');
 return;
 }
 
 autoclaveReceiptForm.pageno.value = pgno;
 submitProtoAjax('autoclaveReceiptForm','/hms/hms/cssd?method=getAutoclaveReceiptStockGridData');
}


function disableResultCombo(i)
{
var integrator = document.getElementById('integrator'+i).value;
if (integrator=="N")
	document.getElementById('result'+i).disabled=true;
else
{
	document.getElementById('result'+i).disabled=false;
}

}

</script>


<!--main content placeholder starts here-->
<div id="contentHolder">
<form name="autoclaveReceiptForm">
<h6>Autoclave Material/Container Receipt Entry</h6>
<div class="Clear"></div>

<!--Block One Starts-->
<div class="blockFrame"><label class="common"><span>*</span>
Receipt No.</label> <select name="receiptNo" id="receiptNo"
	onChange="getAutoclaveReceiptStockGridData();">
	<option value="<%=receiptNo%>"><%=receiptNo%></option>
	<% for(CssdAutoclaveReceiptM  cssdAutoclaveReceiptM : cssdAutoclaveReceiptMList) {  %>
	<option value="<%=cssdAutoclaveReceiptM.getReceiptNo()%>"><%=cssdAutoclaveReceiptM.getReceiptNo()%></option>
	<% } %>
</select> <label class="common"><span>*</span>Receipt Date</label> <input
	type="text" class="calDate" id="receiptDate" name="receiptDate"
	value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30" /> <!-- <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('<%=currentDate %>',document.autoclaveReceiptForm.receiptDate,event)"/>
 --> <label>Received By </label> <select name="receivedBy"
	id="receivedBy">
	<option value="0">Select Employee</option>
	<%
for(MasEmployee masEmployee : masEmployeeList)
{
	StringBuffer empName = new StringBuffer();
	empName.append(masEmployee.getFirstName()==null?"":masEmployee.getFirstName());
	empName.append(" ");
	empName.append(masEmployee.getMiddleName()==null?"":masEmployee.getMiddleName());
	empName.append(" ");
	empName.append(masEmployee.getLastName()==null?"":masEmployee.getLastName());
%>
	<option value="<%=masEmployee.getId()%>"><%=empName%></option>
	<%
}
%>
</select>
<div class="Clear"></div>


<label>Order No.</label> <select name="orderNo" id="orderNo">
	<option value="0">Select Order No</option>
	<%
for(CssdAutoclaveRequestM cssdAutoclaveRequestM : cssdAutoclaveRequestMList)
{%>
	<option value="<%=cssdAutoclaveRequestM.getId()%>"><%=cssdAutoclaveRequestM.getOrderNo()%></option>
	<%
}
%>
</select> <input name="Button" id="goButton" type="button" class="smbutton"
	value="Go" onClick="addAndRefreshAutoclaveReceiptGrid()" />
<div class="Clear"></div>

</div>

<!--Block one Ends--> <!--Block Two Starts-->
<div id="testDiv">
<div class="division"></div>
<div class="blockTitle">Autoclave Material/Container Receipt
Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div class="blockFrame">
<div class="Height10"></div>
<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th>S.No.</th>
		<th>Material/Container Name</th>
		<th>Instrument Name</th>
		<th>Quantity</th>
		<th>Itegrator/Non-Integrator</th>
		<th>Result</th>
	</tr>
	<tr>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
	</tr>

</table>
</div>
</div>
</div>



<div class="division"></div>
<!--Bottom labels starts-->
<div class="bottom">
<div class="division"></div>
<input type="hidden" name="lastChgBy" value="<%=userName%>" /> <input
	type="hidden" name="lastChgDate" value="<%=currentDate%>" /> <input
	type="hidden" name="lastChgTime" value="<%=time%>" /> <label>Changed
By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=currentDate%></label> <label>Changed
Time</label> <label class="value"><%=time %></label>
<div class="Clear"></div>


</div>
<!--Bottom labels ends--> <!--main content placeholder ends here--></form>
</div>


