<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.CssdAutoclaveRequestM"%>
<%@page import="jkt.hms.masters.business.CssdAutoclaveRequestT"%>
<%@page import="jkt.hms.masters.business.CssdInstrumentMaster"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />

<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/acnik.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/calendar.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

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
function onBlurMaterialName(val)
{
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var materialCode = val.substring(index1,index2);
	    document.getElementById('materialCode').value=materialCode;
}


function addAndRefreshAutoclaveRequestGrid()
{
var code = document.getElementById('materialCode').value;
var instrumentCode = document.getElementById('instrumentCode').value;
var qty = document.getElementById('qty').value;
var orderBy = document.getElementById('orderBy').value;
var orderTime = document.getElementById('orderTime').value;

if (code=="" || instrumentCode==0 || qty=="" || orderBy ==0 || orderTime=="")
{
	alert("Container Code, Instrument Name, Quantity, Order By & Order Time are Mandatory!...");
	return;
}

if (isNaN(document.getElementById('qty').value))
{
	alert("Quantity should be numeric!...");
	return;
}
submitProtoAjax('autoclaveRequestForm','/hms/hms/cssd?method=addAndRefreshAutoclaveRequestGrid');
}

function getAutoclaveRequestGridData()
{
	submitProtoAjax('autoclaveRequestForm','/hms/hms/cssd?method=getAutoclaveRequestStockGridData&pageno=1');
}

function GoPage() 
{	
	var pgno = parseInt(autoclaveRequestForm.gopage.value);
	var totalPages = parseInt(autoclaveRequestForm.totalPages.value);
	
	if (pgno < 1 || pgno > totalPages)
	{
	alert('Invalid Page No!.....');
	return;
	}
	  
	autoclaveRequestForm.pageno.value = pgno;
	submitProtoAjax('autoclaveRequestForm','/hms/hms/cssd?method=getAutoclaveRequestStockGridData'); 
}


function goNext()
{
 var pgno = parseInt(autoclaveRequestForm.pageno.value)+1;
 
 if (pgno > autoclaveRequestForm.totalPages.value)
 {
 alert('End of the File Reached!... ');
 return;
 }
 
 autoclaveRequestForm.pageno.value = pgno;
 submitProtoAjax('autoclaveRequestForm','/hms/hms/cssd?method=getAutoclaveRequestStockGridData');
}


function goPrevious()
{
 var pgno = parseInt(autoclaveRequestForm.pageno.value)-1;
 
 if (pgno < 1)
 {
 alert('Beginning of the File Reached!... ');
 return;
 }
 
 autoclaveRequestForm.pageno.value = pgno;
 submitProtoAjax('autoclaveRequestForm','/hms/hms/cssd?method=getAutoclaveRequestStockGridData');
}

</script>


<%
	Map<String ,Object> map = new HashMap<String ,Object>();
	String orderNo = "";
	if(request.getAttribute("map") != null)
	{
		map = (Map<String ,Object>) request.getAttribute("map");
	}
	
	if (map.get("orderNo")!=null)
		orderNo = map.get("orderNo").toString();
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");
	ArrayList<MasDepartment> masDepartmentList = (ArrayList<MasDepartment>)map.get("masDepartmentList");
	ArrayList<MasEmployee> masEmployeeList = (ArrayList<MasEmployee>)map.get("masEmployeeList");
	List<CssdAutoclaveRequestM> cssdAutoclaveRequestMList = (ArrayList<CssdAutoclaveRequestM>)map.get("cssdAutoclaveRequestMList");
	List<CssdInstrumentMaster> cssdInstrumentMasterList = (ArrayList<CssdInstrumentMaster>)map.get("cssdInstrumentMasterList");
	
	String userName = "";
	String nameItem = "nameItem";
	if(session.getAttribute("userName") != null)
	{
		userName = (String)session.getAttribute("userName");
	}
%>


<!--main content placeholder starts here-->
<div id="contentHolder">
<form name="autoclaveRequestForm">
<h6>Autoclave Request Entry</h6>
<div class="Clear"></div>


<!--Block One Starts-->
<div class="blockFrame"><label class="common"><span>*</span>Order
No.</label> <select name="orderNo" id="orderNo"
	onChange="getAutoclaveRequestGridData()">
	<option value="<%=orderNo%>"><%=orderNo%></option>
	<%
for(CssdAutoclaveRequestM cssdAutoclaveRequestM : cssdAutoclaveRequestMList)
{%>
	<option value="<%=cssdAutoclaveRequestM.getOrderNo()%>"><%=cssdAutoclaveRequestM.getOrderNo()%></option>
	<%
}
%>

</select> <label>Department</label> <input name="deptName" type="text"
	value="<%=masDepartmentList.get(0).getDepartmentName()%>"
	readonly="readonly" /> <label class="common"><span>*</span>Order
By</label> <select name="orderBy" id="orderBy">
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

<label class="common"><span>*</span>Order Date</label> <input
	type="text" class="calDate" id="orderDate" name="orderDate"
	value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30" /> <!--
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('<%=currentDate %>',document.autoclaveRequestForm.orderDate,event)"/> 
  --> <label class="common"><span>*</span>Order Time</label> <input
	type="text" id="orderTime" name="orderTime"
	value="<%=time.substring(0,5) %>" readonly="readonly" />


<div class="Clear"></div>
</div>
<!--Block one Ends-->

<div class="division"></div>
<div class="blockTitle">Autoclave Request Addition</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>




<!--Block Two Starts-->
<div id="testDiv">
<div class="blockFrame">
<div class="Height10"></div>
<div class="Clear"></div>
<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th>Container Code</th>
		<th>Container Name</th>
		<th>Instrument Name</th>
		<th>Quantity</th>
		<th>Remarks</th>
		<th></th>
	</tr>
	<tr>
		<td><input id="materialCode" name="materialCode" type="text"
			size="10" MAXLENGTH="10" readonly="readonly" /></td>

		<td><input type="text" id="materialName" name="materialName"
			size="25" MAXLENGTH="25" onblur="onBlurMaterialName(this.value)" />
		<div id="ac2update"
			style="display: none; border: 1px solid black; padding-right: 450px; background-color: white;"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
	new Ajax.Autocompleter('materialName','ac2update','cssd?method=getAutoclaveRequestMaterialNamesForAutocomplete',{parameters:'requiredField=materialName&orderNo='+document.getElementById('orderNo').value });
	</script></td>

		<td><select name="instrumentCode" id="instrumentCode">
			<option value="0">Select Instrument</option>
			<%for(CssdInstrumentMaster cssdInstrumentMaster : cssdInstrumentMasterList) { %>
			<option value="<%=cssdInstrumentMaster.getInstrumentCode()%>"><%=cssdInstrumentMaster.getInstrumentName()%></option>
			<%} %>
		</select></td>

		<td><input id="qty" name="qty" type="text" size="3" MAXLENGTH="3" /></td>
		<td><input id="remarks" name="remarks" type="text" size="25"
			MAXLENGTH="25" /></td>
		<td><input name="Button" type="button" class="button" value="Add"
			onClick="addAndRefreshAutoclaveRequestGrid()" /></td>
	</tr>
</table>
</div>

</div>
<!--Block Two Ends-->


<div class="division"></div>
<div class="blockTitle">Autoclave Request Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div class="blockFrame">
<div class="Height10"></div>
<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th>Sr.No.</th>
		<th>Container Code</th>
		<th>Container Name</th>
		<th>Instrument Name</th>
		<th>Quantity</th>
		<th>Remarks</th>
	</tr>
	<tr>
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


