<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * modifyWorkOrder.jsp
 * Purpose of the JSP -  This is for work order view .
 * @author  Abha
  
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>

<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.StoreWorkOrderM"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.StoreWorkOrderT"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasRepairStation"%>

<%@page import="java.util.StringTokenizer"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="java.util.Iterator"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.masters.business.MasStoreAirForceDepot"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<link rel="stylesheet" href="/hms/jsp/css/acnik.css" type="text/css" />

<script type="text/javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>
<script language="javascript">
	

function fillSrNo(rowVal){

	var pageNo=parseInt(document.getElementById('noOfRows').value);
   		rowVal=rowVal%8
   		if(rowVal==0){
   			rowVal=8
   	 		}
   		if(!(parseInt(document.getElementById('noOfRows').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRows').value=rowVal
			}
	return true;
}

  function showReport(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/neStores?method=generateWorkOrderReport";
  obj.submit();
}

</script>

<script language="javascript">

function checkForWorkOrder(val,a,inc)
{
		//var pageNo =parseInt(document.getElementById('pageNo').value) 
		//var start=((pageNo-1)*10)+1;
    	//var end=((pageNo-1)*10)+10;
    	
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	    
	  
		ajaxFunctionForAutoCompleteInWorkOrder('grnGrid','neStores?method=fillItemsForWorkOrder&pvmsNo=' + pvms , inc);
		
}
  
 </script>
<%
Map map = new HashMap();
String includedJsp = null;
String previousPage="no";
int pageNo=1;
String noDetailRecords="no";
List<StoreWorkOrderM> workOrderList = new ArrayList<StoreWorkOrderM>();
List<StoreWorkOrderM> gridWorkOrderMList= new ArrayList<StoreWorkOrderM>();
List<StoreWorkOrderT> gridWorkOrderTList= new ArrayList<StoreWorkOrderT>();
List<MasStoreItem> itemList= new ArrayList<MasStoreItem>();
List<MasEmployee> issueByList = new ArrayList<MasEmployee>();
List<MasRepairStation>repairStationList=new ArrayList<MasRepairStation>();
String maxNo="";
String date="";
String time="";
String userName = "";
List objectList=new ArrayList();
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 date = (String)utilMap.get("currentDate");	 
 time = (String)utilMap.get("currentTime");
 if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
//--------Hearder Variables-------
String workOrderNo="";
int workOrderId=0;
String max="";
String option="";

//--------End -------- Hearder Variables-------

if (request.getAttribute("map") != null) 
	map = (Map) request.getAttribute("map");
if(map.get("workOrderNo")!=null)
	workOrderNo=""+map.get("workOrderNo");
if(map.get("workOrderId")!=null)
	workOrderId= Integer.parseInt(""+map.get("workOrderId")) ;
if(map.get("option")!=null)
	option=(""+map.get("option")) ;


if (map.get("pageNo") != null) {
	pageNo = Integer.parseInt(""+map.get("pageNo"));
}
if(map.get("max")!=null)
	max=(""+map.get("max"));

Box box=HMSUtil.getBox(request);
if(map.get("box")!=null){
	box=(Box)map.get("box");
}

if(map.get("objectList")!=null)
	objectList=(List) map.get("objectList");
if(map.get("workOrderList")!=null)
	workOrderList = (List) map.get("workOrderList");
System.out.println("====  workOrderList  inside jsp"+workOrderList.size());
if(map.get("itemList")!=null)
	itemList=(List) map.get("itemList");
if(map.get("gridWorkOrderMList")!=null)
	gridWorkOrderMList=(List) map.get("gridWorkOrderMList");
if(map.get("gridWorkOrderTList")!=null)
	gridWorkOrderTList=(List) map.get("gridWorkOrderTList");
if(map.get("noDetailRecords")!=null){
	noDetailRecords=(""+map.get("noDetailRecords"));
}

if(map.get("issueByList") != null){
	issueByList = (ArrayList) map.get("issueByList");
}
if(map.get("repairStationList") != null)
{
	repairStationList = (List)map.get("repairStationList");
}

String messageTOBeVisibleToTheUser="";
if(map.get("messageTOBeVisibleToTheUser") !=null){
	messageTOBeVisibleToTheUser=""+map.get("messageTOBeVisibleToTheUser");
}
StoreWorkOrderM storeWorkOrder=new StoreWorkOrderM();
if(gridWorkOrderMList.size()>0)
{
	storeWorkOrder=gridWorkOrderMList.get(0);
}


%>

<h2 align="left" class="style1">WORK ORDER </h2>


<!-- <input	type="button" id="addbutton" name="Add" type="submit" value="Add" class="button" onClick="submitForm('createGrn','neStores?method=showWorkOrderJsp');">
<input	type="button" name="Modify" type="submit" value="Modify" class="button">
<input	type="button" name="Reset" type="submit" value="Reset"	class="button">
<input	type="button" name="Delete" type="submit" value="Delete"class="button">
<input	type="button" name="print" type="submit" class="button"	value="Print" onClick="showReport('createGrn');">
 -->
<%---
<form name="searchPanel" method="post">
<div class="clear"></div>
<div class="search" id="threadsearch">
<a href=""></a>
<script	type="text/javascript"> vbmenu_register("threadsearch"); </script>
</div>
<div class="clear"></div>
<div class="searchBlock" id="threadsearch_menu" style="display: none;">--%>
<form name="searchWorkOrder" method="post">
<div class="Block">
<input type="hidden" name="s" value="cccfbaab0a70ed43fad9de8e3733112d" /> 
<input type="hidden" name="do" value="process" /> 
<input type="hidden" name="searchthread" value="1" /> 
<input type="hidden" name="showposts" value="1" /> 
<input type="hidden" name="searchthreadid" value="85875" />  
<label>From Date :</label> 
<input type="text" name="<%=FROM_DATE %>"  MAXLENGTH="12" tabindex=1 class="auto" size="15" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"
		class="calender" onclick="setdate('<%=date%>',document.searchWorkOrder.<%= FROM_DATE%>,event);" />
<label >To Date :</label> 
<input type="text" name="<%=TO_DATE %>" MAXLENGTH="12"  tabindex=1  class="auto" size="15" /> 

<img src="/hms/jsp/images/cal.gif"
		width="16" height="16" border="0" validate="Pick a date"
		class="calender" onclick="setdate('<%=date%>',document.searchWorkOrder.<%= TO_DATE%>,event);" />
<label >Work Order No.</label> 
<select	name="workOrder1" >
<option value="0">Select</option>
	<% for (StoreWorkOrderM storeWorkOrderM :workOrderList ) { %>
<option value=<%=storeWorkOrderM.getId()%>><%=storeWorkOrderM.getWorkOrderNo()%></option>
<% } %>

</select> <div class="clear"></div><input type="button" class="button" value="Search"
		
			onClick="submitForm('searchWorkOrder','neStores?method=searchWorkOrder');" />
	
		</div>
<div class="clear"></div>
</form>
<form name="grnGrid" method="post">
<h4 ><%=messageTOBeVisibleToTheUser %></h4>
<h4> WORK ORDER </h4>
<div class="Block">
<input type="hidden" name="pageNo" value="<%=pageNo%>" id="pageNo" /> 
<%if(storeWorkOrder.getDepartment() !=null){ %>
<input type="hidden" name="deptId" value="<%=storeWorkOrder.getDepartment().getId()%>" />
<%} %> 

<label ><span>*</span> Work Order No.</label> 
<%if(storeWorkOrder.getWorkOrderNo() !=null){ %>
<input type="text"  name="<%= WORK_ORDER_NO %>" value="<%=storeWorkOrder.getWorkOrderNo()%>" readonly="readonly" validate="Work Order No. ,String,yes" tabindex=1 /> <%}else{ %> 
<input type="text"  name="<%= WORK_ORDER_NO %>" value="<%=max %>" readonly="readonly" validate="GRN Number ,String,yes" tabindex=1 /> 
<%} %>
<label ><span>*</span>Work Order Date:</label> 
<%if(storeWorkOrder.getWorkOrderDate() !=null){ %>
<input type="text" name="<%=WORK_ORDER_DATE%>" value="<%=HMSUtil.changeDateToddMMyyyy(storeWorkOrder.getWorkOrderDate()) %>" 
	class="date" MAXLENGTH="30" />
<%}else{ %>
<input type="text" name="<%=WORK_ORDER_DATE%>" value="" class="date" MAXLENGTH="30" />
<%} %> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" 
tabindex="1" onClick="setdate('<%=date%>',document.grnGrid.<%=WORK_ORDER_DATE%>,event)" />

<label><span>*</span> Repair Station</label> 
<select name="<%=REPAIRING_CELL%>" id="sourceCombo" validate="Repairing Station,string,yes" tabindex=1>
<option value="0">Select</option>
<%for(MasRepairStation masRepairStation :repairStationList){ 
	if(storeWorkOrder.getRepairStation() !=null){
if(storeWorkOrder.getRepairStation().getId().equals(masRepairStation.getId())) {%>
<option value="<%=masRepairStation.getId()%>" selected="selected"><%=masRepairStation.getStationName()%></option>
<%}else{ %>
<option value="<%=masRepairStation.getId()%>"><%=masRepairStation.getStationName()%></option>
<%}}else{ %>
<option value="<%=masRepairStation.getId()%>"><%=masRepairStation.getStationName()%></option>
<%}} %>
	
	</select> 
<div class="clear"></div> 
<label ><span>*</span> Issued By</label> 
<select name="issueBy">
<option value="">Select</option>
<%
String empName="";
	for (MasEmployee masEmployee :issueByList ) {
		if(storeWorkOrder.getIssuedBy() !=null){
			if(storeWorkOrder.getIssuedBy().getId().equals(masEmployee.getId())){
			
		if(storeWorkOrder.getIssuedBy().getFirstName()!=null)
		{
			empName=storeWorkOrder.getIssuedBy().getFirstName();
		}
		if(storeWorkOrder.getIssuedBy().getLastName()!=null)
		{
			empName=empName+" "+storeWorkOrder.getIssuedBy().getLastName();
		}
		if(storeWorkOrder.getIssuedBy().getRank() !=null){
			empName=storeWorkOrder.getIssuedBy().getRank().getRankName()+" "+empName;
			
		}
	%> 
<option value="<%=masEmployee.getId()%>" selected="selected"><%=empName%></option>
<%}
			else{
				if(masEmployee.getFirstName()!=null)
				{
					empName=masEmployee.getFirstName();
				}
				if(masEmployee.getLastName()!=null)
				{
					empName=empName+" "+masEmployee.getLastName();
				}
				if(masEmployee.getRank() !=null){
					empName=masEmployee.getRank().getRankName()+" "+empName;
					
				}
	 %>
	 <option value="<%=masEmployee.getId()%>"><%=empName%></option>
	 <%}}else{ 
	 if(masEmployee.getFirstName()!=null)
		{
			empName=masEmployee.getFirstName();
		}
		if(masEmployee.getLastName()!=null)
		{
			empName=empName+" "+masEmployee.getLastName();
		}
		if(masEmployee.getRank() !=null){
			empName=masEmployee.getRank().getRankName()+" "+empName;
			
		}%>
	  <option value="<%=masEmployee.getId()%>"><%=empName%></option>
<%} }%>
</select>
			<div class="clear"></div>
			 
	<input type="hidden" name="<%=AUTHORITY%>" value="A">
</div>
<input type="hidden" Page No: <%=pageNo%> /> 
<input type="hidden" size="2" value="0" name="<%=NO_OF_ROWS %>" id="<%=NO_OF_ROWS %>" /> 
<input	type="hidden" name="<%=WORK_ORDER_ID %>" value="<%=workOrderId%>"id="hdb" />
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="cmntable">
<table width="200px" col="7" id="grid" class="grid_header" border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
		<th width="5%">Sl No.</th>
		<th width="8%">PVMS/NIV No.</th>
		<th width="15%">Nomenclature</th>
		<!-- <th width="9%">A/U</th> -->
		<th width="9%">Serial No.</th>
		<th width="9%">Qty</th>
		<th width="23%">Nature of Work </th>
		<th width="23%">Particulars of Eqpt/RW</th>
		<th width="23%">Remarks</th>
		<th scope="col"></th>
		<th scope="col"></th>
	</tr>
</thead>
<tbody>
	<%
	int inc=1;
	int detailCounter=10; 
	int temp=0;
	String idItem="idItem";
	String codeItem="codeItem";
	String nameItem="nameItem";
	String idAu="idAu";
	String quanRec="quanRec";
	String quanRecTemp="quanRecTemp";
	String incVar="incVar";
	String remarks ="remarks";
	String remarksTemp="remarksTemp";
	String natOfWrk ="natOfWrk";
	String natOfWrkTemp ="natOfWrkTemp";
	String batchNo="batchNo";
	
	
	String idItem2="idItem";
	String codeItem2="codeItem";
	String nameItem2="nameItem";
	String idAu2="idAu";
	String quanRec2="quanRec";
	String quanRecTemp2="quanRecTemp";
	String incVar2="incVar2";
	String natOfWrk2="natOfWrk";
	String natOfWrkTemp2="natOfWrkTemp";
	String remarks2="remarks";
	String remarksTemp2="remarksTemp";
	String batchNo2="batchNo";
	
	if(pageNo!=1){
	inc=((pageNo-1)*10)+1;
	}
 
 int incTemp2=inc+10;
if(gridWorkOrderTList.size() >0){
 for(StoreWorkOrderT storeWorkOrderT:gridWorkOrderTList){

 		idItem=idItem2+(""+inc);
 		codeItem=codeItem2+(""+inc);
 		nameItem=nameItem2+(""+inc);
 		idAu=idAu2+(""+inc);
 		quanRec=quanRec2+(""+inc);
 		quanRecTemp=quanRecTemp2+(""+inc);
 		incVar=incVar2+(""+inc);
 		remarks = remarks2+(""+inc);
 		remarksTemp =remarksTemp2+(""+inc);
 		natOfWrk = natOfWrk2+(""+inc);
 		natOfWrkTemp = natOfWrkTemp2+(""+inc);
 		batchNo =batchNo2+(""+inc);
 		incVar=incVar2+(""+inc);
	  %>
<tr>

<input type="hidden" name="gridSize" id="gridSize" value="1"/>
<td width="5%"><input type="text" size="2"	value="<%=storeWorkOrderT.getSrNo()%>" 
name="<%=SR_NO%><%=inc %>" readonly="readonly" />
<input type="hidden" name="<%=DETAIL_ID %><%=inc %>" value="<%=storeWorkOrderT.getId() %>"id="hdb" /></td>
<td width="10%">
<%if(storeWorkOrderT.getItem().getPvmsNo()!=null){ %> 
<input type="text" value="<%=storeWorkOrderT.getItem().getPvmsNo() %>"
name="<%=NEW_NIV %>" readonly="readonly" size="15"id="<%=codeItem%>" />
<%}else{ %> <input type="text" value=" " size="15" name="<%=ITEM_CODE %>" readonly="readonly"
id="<%=codeItem%>" /> <%} %> 
<%if(storeWorkOrderT.getItem() !=null){ %> 
 <input type="hidden" size="2" value="<%=storeWorkOrderT.getItem().getId() %>" name="<%=ITEM_ID%><%=inc %>" id="<%=idItem%>" />
	
	<%}else{ %>
<input type="hidden" size="2" value="0" name="<%=ITEM_ID%><%=inc %>" id="<%=idItem%>" />	
	<%} %>
</td>
<td width="10%"><input type="text" value="<%=storeWorkOrderT.getItem().getNomenclature() %>"
id="nameItem<%=inc%>"  name="<%=nameItem%>" readonly="readonly" size="50"/>
	<div id="ac2update" style="display:none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('<%=nameItem%>','ac2update','neStores?method=getItemListForWorkOrderByAutocomplete',{parameters:'requiredField=<%=nameItem%>'});
			</script>
</td>
<input type="hidden" value="<%=storeWorkOrderT.getItem().getItemConversion().getItemUnitName() %>"
 name="<%=AV%>" id="<%=idAu%>" /> 
<td width="10%"><%---<input type="text"	value="<%=storeWorkOrderT.getSerialNo() %>" size="10" maxlength="15"
readonly="readonly" name="<%=SERIAL_NO%><%=inc %>" tabindex="2" id="<%=batchNo%>" /> --%>
<select name="<%=SERIAL_NO%><%=inc %>"  id="batchId<%=inc%>" >
<option value="<%=storeWorkOrderT.getSerialNo() %>"><%=storeWorkOrderT.getSerialNo() %></option></select>
</td>

<td width="10%">
<input type="text" value="<%=storeWorkOrderT.getQuantity() %>" size="8" maxlength="10"
" name="<%=QUANTITY_RECEIVED%><%=inc %>" tabindex="2"id="<%=quanRec%>" /></td>
	
<td width="10%">
<input type="text" value="<%=storeWorkOrderT.getNatureOfWork() %>" size="20"  name="<%=NATURE_OF_WORK %><%=inc %>"
id="<%=natOfWrk%>" maxlength="149" tabindex="2"/>	</td>
<td width="23%">
<% String particularEqupRv="";
if(storeWorkOrderT.getParticularEqupRv() !=null){
	particularEqupRv=storeWorkOrderT.getParticularEqupRv();
}
%>
<input type="text" value="<%=particularEqupRv%>" size="25" id="particularEqp<%=inc%>" name="<%=PARTICULAR_EQPT %><%=inc %>"
 onblur="fillNatureOfWorkInWorkOrder(<%=inc%>);" tabindex="1" maxlength="100"/> </td>
<td width="10%"><input type="text"  name="<%=REMARKS %><%=inc %>" id="<%=remarks%>" size="50" maxlength="100"
value="<%=storeWorkOrderT.getRemarks() %>"  tabindex="2" /></td>
<td>
    <input name="Button" type="button" class="buttonAdd" value="" onclick="addRow('grid');" tabindex="1" />
</td>
<td>
<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('grid');" tabindex="1" />
</td>
</tr>
<% inc++;}
	}else{
        idItem=idItem2+(""+inc);
 		codeItem=codeItem2+(""+inc);
 		nameItem=nameItem2+(""+inc);
 		idAu=idAu2+(""+inc);
 		quanRec=quanRec2+(""+inc);
 		quanRecTemp=quanRecTemp2+(""+inc);
 		incVar=incVar2+(""+inc);
 		remarks = remarks2+(""+inc);
 		remarksTemp =remarksTemp2+(""+inc);
 		natOfWrk = natOfWrk2+(""+inc);
 		natOfWrkTemp = natOfWrkTemp2+(""+inc);
 		incVar=incVar2+(""+inc);
 		
%>
<tr>
			<input type="hidden" name="gridSize" id="gridSize" value="1"/>
			
			<td width="5%"><input type="text" size="2" value="<%=inc%>"
				 name="<%=SR_NO%><%=inc %>" readonly="readonly" /></td>
			<td width="10%"><input type="text" size="15"
				name="<%=ITEM_CODE %>" id="<%=codeItem%>" /> <input
				type="hidden" size="2" value="0" 
				name="<%=ITEM_ID%><%=inc %>" id="<%=idItem%>" />

			<td width="10%"><input type="text" value="" id="nameItem<%=inc%>" size="50"
				onblur="if(fillSrNo('<%=inc %>')){checkForWorkOrder(this.value, '<%=nameItem%>','<%=inc %>');}"
				name="<%=nameItem%>" tabindex="1" />
				<div id="ac2update" style="display:none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('<%=nameItem%>','ac2update','neStores?method=getItemListForWorkOrderByAutocomplete',{parameters:'requiredField=<%=nameItem%>'});
			</script></td>
		
			<input type="hidden" value="" readonly="readonly" name="<%=AV%><%=inc %>" id="<%=idAu%>" tabindex="1" />
			
			<td width="10%"><%--- 
			<input type="text" value="" name="<%=SERIAL_NO%><%=inc %>"  size="10"
				  id="batchId<%=inc%>" tabindex="1" maxlength="15" />--%>
				  <select name="<%=SERIAL_NO%><%=inc %>"  id="batchId<%=inc%>" >
				  <option value="">Select</option></select>
			</td>
			
			<td width="10%"><input type="text"  size="8"
				 id="quanRec<%=inc%>" name="<%=QUANTITY_RECEIVED%><%=inc %>" tabindex="1"  maxlength="10" />
				
				</td>


			<td width="23%"><input type="text" value="" size="20"
				 id="natOfWrk<%=inc%>" name="<%=NATURE_OF_WORK %><%=inc %>" tabindex="1" maxlength="149"
				onblur="fillNatureOfWorkInWorkOrder(<%=inc%>);" /></td>



				<td width="23%"><input type="text" value="" size="25"
				 id="particularEqp<%=inc%>" name="<%=PARTICULAR_EQPT %><%=inc %>" tabindex="1" maxlength="100"
				onblur="fillNatureOfWorkInWorkOrder(<%=inc%>);" /> 
				
				</td>
				
			<td width="23%"><input type="text" value="" size="50" 
			 id="remarks<%=inc%>" name="<%=REMARKS %><%=inc %>" tabindex="1" maxlength="100"
				onblur="fillRemarksInWorkOrder(<%=inc%>);" /> 
				</td>
			<td>
			    <input name="Button" type="button" class="buttonAdd" value="" onclick="addRow('grid');" tabindex="1" />
		   </td>
		   <td>
				<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('grid');" tabindex="1" />
	
		   </td>
		</tr>

<% }//}%>

	</tbody>
</table>
</div>
<div class="clear"></div>
<div class="division"></div>
<input type="button"
	name="sss" align="right" class="button" value="Submit"
	onclick="if(checkSave() && checkGridForSave()){submitForm('grnGrid','neStores?method=updateWorkOrder');}" /><div class="clear"></div>
	<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<label>Changed By</label>
<label class="value"><%=userName%></label>
<label>Changed Date</label>
<label class="value"><%=date%></label>
<label>Changed Time</label>
<label class="value"><%=time%></label>
<div class="clear"></div>
<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />
<INPUT	type=hidden value="<%=userName%>" name="<%=LAST_CHANGED_BY%>">
<INPUT type=hidden value="<%=date%>" name="<%=LAST_CHANGED_DATE%>">
<INPUT type=hidden value="<%=time%>" name="<%=LAST_CHANGED_TIME%>">
</div>
<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script> <input type="hidden" name="rows" id="rr" value="1" />
</form>


<script type="text/javascript">
function addRow(idName) {
	
	  var tbl =  document.getElementById(idName);
	  var lastRow = tbl.rows.length;
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('gridSize');
	  hdb.value=iteration
	  var el=0;

	  var cellRight0 = row.insertCell(el);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.size = '2';
	  e0.name='SRNo'+iteration;
	  e0.setAttribute('tabindex', 1); 
	  e0.readOnly=true;
	  e0.value=iteration;
	  cellRight0.appendChild(e0);

	  var ee5 = document.createElement('input');
	  ee5.type = 'hidden';
	  ee5.name='itemId'+iteration;
	  ee5.id = 'idItem'+iteration;
	  
	  var cellRight1 = row.insertCell(++el);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='<%=ITEM_CODE%>';
	  e1.id = 'codeItem'+iteration;
	  e1.size='15';
	  e1.setAttribute('tabindex', 1); 
	  cellRight1.appendChild(ee5);
	  cellRight1.appendChild(e1);
	 
	  var cellRight2 = row.insertCell(++el);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.name = 'nameItem';
	  e2.id = 'nameItem' + iteration;
	  e2.size = '50';
	  e2.setAttribute('tabindex', 1); 
	  e2.onblur = function(){if(fillSrNo(iteration)){checkForWorkOrder(this.value, 'nameItem',iteration)}};
	  
	  var newdiv = document.createElement('div');
	  newdiv.setAttribute('id', 'ac2update'+iteration);
	  newdiv.style.display = 'none';
	  newdiv.className = "autocomplete";
	  cellRight2.appendChild(e2);
	  cellRight2.appendChild(newdiv);
	  new Ajax.Autocompleter('nameItem'+iteration,'ac2update','neStores?method=getItemListForWorkOrderByAutocomplete',{parameters:'requiredField=nameItem'});
	 
	  var e3 = document.createElement('input');
	  e3.type = 'hidden';
	  e3.name='AV'+iteration;
	  e3.id = 'idAu'+iteration;
	  e3.size='10';
	  
	  var cellRight44 = row.insertCell(++el);
	  var e44 = document.createElement('select');
	  e44.name='serial_no'+iteration;
	  e44.id = 'batchId'+iteration;
	  e44.setAttribute('tabindex', 1); 
	  e44.options[0] = new Option('Select', '0');
	  cellRight44.appendChild(e3);
	  cellRight44.appendChild(e44);
	  
	  var cellRight4 = row.insertCell(++el);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name='quantityReceived'+iteration;
	  e4.setAttribute('tabindex', 1); 
	  e4.setAttribute('maxlength', 9); 
	  e4.id = 'quanRec'+iteration;
	  e4.size='8';
	  
	  cellRight4.appendChild(e4);

	  var cellRight7 = row.insertCell(++el);
	  var e7 = document.createElement('input');
	  e7.type = 'text';
	  e7.name='natureOfWork'+iteration;
	  e7.id = 'natOfWrk'+iteration;
	  e7.setAttribute('tabindex', 1); 
	  e7.setAttribute('maxlength', 149); 
	  e7.size='20';
	  cellRight7.appendChild(e7);

	  var cellRight8 = row.insertCell(++el);
	  var e8 = document.createElement('input');
	  e8.type = 'text';
	  e8.name='particularEqpt'+iteration;
	  e8.id = 'particularEqp'+iteration;
	  e8.setAttribute('tabindex', 1); 
	  e8.setAttribute('maxlength', 100); 
	  e8.size='25';
	  cellRight8.appendChild(e8);

	  var cellRight9 = row.insertCell(++el);
	  var e9 = document.createElement('input');
	  e9.type = 'text';
	  e9.name='remarks'+iteration;
	  e9.id = 'remarks'+iteration;
	  e9.setAttribute('tabindex', 1); 
	  e9.setAttribute('maxlength', 100); 
	  e9.size='50';
	  cellRight9.appendChild(e9);

	  

	  var cellRight5 = row.insertCell(++el);
	  var e5 = document.createElement('input');
	  e5.type = 'button';
	  e5.name='remarks'+iteration;
	  e5.className = 'buttonAdd';
	  e5.setAttribute('tabindex', 1); 
	  e5.onclick= function(){addRow('grid')};
	  cellRight5.appendChild(e5);

	  var cellRight6 = row.insertCell(++el);
	  var e6 = document.createElement('input');
	  e6.type = 'button';
	  e6.name='remarks'+iteration;
	  e6.setAttribute('tabindex', 1); 
	  e6.className = 'buttonDel';
	  e6.onclick= function(){removeRow('grid')};
	  cellRight6.appendChild(e6);
	  				 
}
function removeRow(idName)
{

    try {
        var table = document.getElementById(idName);
        var rowCount = table.rows.length;
        var gridSize=document.getElementById('gridSize').value;

    	for(var i=rowCount-1; i>0; i++) 
        {
        	var row = table.rows[i];
            if(i>1)
            {
            	table.deleteRow(i);
              	document.getElementById('gridSize').value=(parseInt(gridSize))-1;
              return true;
             }
            else
            {
            	alert("At Least One Row  Should Be There");
                return false;
             }
               rowCount--;
                i--;
          

       }
       }catch(e)
       	{
           alert(e);
       }
      
}

function checkGridForSave()
{
	
	var gridSize=document.getElementById('gridSize').value;
	var flag;
	for(var i=1;i<=gridSize;i++)
	{
	var nameItem=document.getElementById('nameItem'+i).value;
	var serialNo=document.getElementById('batchId'+i).value;
	var qty=document.getElementById('quanRec'+i).value;
	var natureOfQork=document.getElementById('natOfWrk'+i).value;
	var particular=document.getElementById('particularEqp'+i).value;
	var remarks=document.getElementById('remarks'+i).value;
	if(nameItem!="")
	{
		if(serialNo!="")
		{
			if(qty!="")
			{
				if(natureOfQork!="")
				{
					if(particular!="")
					{
						if(remarks!="")
						{
						flag1="true";
						}else
						{
							alert("Please Enter Remarks at Row"+i);
							document.getElementById('remarks'+i).focus();
							
							return false;
						}
					}
					else
					{
						alert("Please Enter Particulars of Eqpt/RW at Row"+i);
						document.getElementById('particularEqp'+i).focus();
						
						return false;
						
					}
				}else{
					alert("Please Enter Nature of Work  at Row"+i);
					document.getElementById('natOfWrk'+i).focus();
					return false;
						
					}
			}else{
				alert("Please Enter Qty. at Row"+i);
				document.getElementById('quanRec'+i).focus();
				return false;
					
				}
		}else{
			alert("Please Enter Serial No. at Row"+i);
			document.getElementById('batchId'+i).focus();
			return false;
				
			}
	}else{
		alert("Please Enter Nomenclature at Row"+i);
		document.getElementById('nameItem'+i).focus();
		return false;
			
		}

	}

	if(flag1=="true")
	{
		return true;
	}
		
}
</script>