<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.MasUnitOfMeasurement"%>
<%@page import="jkt.hms.masters.business.MasManufacturer"%>
<%@page import="jkt.hms.masters.business.StoreSupplyOrderEntry"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.masters.business.StoreWorkOrderM"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasStoreAirForceDepot"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.StoreDefectiveDrugM"%>
<%@page import="jkt.hms.masters.business.StoreCopyAddressList"%>
<%@page import="jkt.hms.masters.business.StoreGrnT"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasRepairStation;"%>



<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/addRow.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>


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
<style type="text/css" media="screen">
.selected {
	background-color: #888;
}
</style>

<% 
	Map map= new HashMap();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	int workOrderId=0;	
	if(map.get("workOrderId")!=null){
		workOrderId=Integer.parseInt(""+map.get("workOrderId"));
	}	
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	List<MasHospital> hospitalList = new ArrayList<MasHospital>();
	List<MasEmployee> issueByList = new ArrayList<MasEmployee>();
	List<MasRepairStation>repairStationList=new ArrayList<MasRepairStation>();
	String hospitalName="";
	int hospitalId=0;
	if(map.get("hospitalList") != null){
		hospitalList = (ArrayList) map.get("hospitalList");
	}
	
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		if(map.get("departmentList") != null){
			departmentList = (ArrayList) map.get("departmentList");
			session.setAttribute("departmentList",departmentList);
		}else if(session.getAttribute("departmentList") != null){
			departmentList = (ArrayList)session.getAttribute("departmentList");
			
		}
		if(map.get("issueByList") != null){
			issueByList = (ArrayList) map.get("issueByList");
		}
		if(map.get("repairStationList") != null)
		{
			repairStationList = (List)map.get("repairStationList");
	
		}
		
		List<StoreWorkOrderM> workOrderList= new ArrayList<StoreWorkOrderM>();
		if(map.get("searchWorkOrderList")!=null)
			workOrderList = (List) map.get("searchWorkOrderList");
		String message="";
		if(map.get("message") != null){
			message = (String)map.get("message"); 
		}
	
		String userName = "";
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		String departmentName = "";
		if (session.getAttribute("departmentName") != null) {
			departmentName = (String) session.getAttribute("departmentName");
		}
		
		List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
		if(map.get("supplierList")!=null)
			supplierList = (List) map.get("supplierList");
		
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
			
		}
		
			String time="";
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			 date = (String)utilMap.get("currentDate");	 
			 time = (String)utilMap.get("currentTime");
			int pageNo=1;
			if (map.get("pageNo") != null) {
				pageNo = Integer.parseInt(""+map.get("pageNo"));
			}
			String includedJsp = null;
			if (request.getAttribute("map") != null) {
				map = (Map) request.getAttribute("map");
			}
			includedJsp = (String) map.get("includedJsp");
			String max="";
			if(map.get("max") != null){
				max = (String) map.get("max");
			}
			StoreWorkOrderM  storeWorkOrderObj = null;
			
			Set<StoreItemBatchStock> set1 = new HashSet<StoreItemBatchStock>();
			if (request.getAttribute("set1") != null) {
				set1 = (Set) request.getAttribute("set1");
			}
			String messageTOBeVisibleToTheUser="";
			if(map.get("messageTOBeVisibleToTheUser") !=null){
				messageTOBeVisibleToTheUser=""+map.get("messageTOBeVisibleToTheUser");
			}
			%>
<script>
 var nameArray=new Array();
 var itemsArray1=new Array();
 var itemsArray2 = new Array();
 var manufacturerArray = new Array();
  var brandArray = new Array();
  
  function fillSrNo(rowVal){


	var pageNo=parseInt(document.getElementById('noOfRows').value);
   		rowVal=rowVal%10
   		if(rowVal==0){
   			rowVal=10
   	 		}
   		if(!(parseInt(document.getElementById('noOfRows').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRows').value=rowVal
			}
	return true;
}
  
  function checkForSubmit(){
  if(document.getElementById('noOfRows').value==0)
  {
	  alert("There must be one detail row");
  return false;
  }
  else{
	  
  return true;
  }
  }
  
  function showReport(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/neStores?method=generateWorkOrderReport";
  obj.submit();
}
</script>

<script language="javascript">


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
function checkForWorkOrder(val,a,inc)
{

		//var pageNo =parseInt(document.getElementById('pageNo').value) 
	//	var start=((pageNo-1)*10)+1;
    //	var end=((pageNo-1)*10)+10;
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
		ajaxFunctionForAutoCompleteInWorkOrder('grnGrid','neStores?method=fillItemsForWorkOrder&pvmsNo=' + pvms , inc);
		
}
	   
 </script>

<br />
<div class="titleBg">
<h2 >WORK ORDER ENTRY</h2>
</div>

<div id="searchBlock" style="display:none;">
<form name="departmentIssueNE" method="post">

<div class="clear"></div>
<h6>SEARCH</h6>
<div class="Block">
<input type="hidden" name="s" value="cccfbaab0a70ed43fad9de8e3733112d" /> 
<input type="hidden" name="do" value="process" /> 
<input type="hidden" name="searchthread" value="1" /> 
<input type="hidden" name="showposts" value="1" /> 
<input type="hidden" name="searchthreadid" value="85875" />  
<label>From Date :</label> 
<input type="text" name="<%=FROM_DATE %>"  MAXLENGTH="12" tabindex=1 class="auto" size="15" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"
		class="calender" onclick="setdate('<%=currentDate%>',document.departmentIssueNE.<%= FROM_DATE%>,event);" />
<label >To Date :</label> 
<input type="text" name="<%=TO_DATE %>" MAXLENGTH="12"  tabindex=1  class="auto" size="15" /> 

<img src="/hms/jsp/images/cal.gif"
		width="16" height="16" border="0" validate="Pick a date"
		class="calender" onclick="setdate('<%=currentDate%>',document.departmentIssueNE.<%= TO_DATE%>,event);" />
<label >Work Order No.</label> 
<select	name="workOrder1" >
<option value="0">Select</option>
	<% for (StoreWorkOrderM storeWorkOrderM :workOrderList ) { %>
	<option value=<%=storeWorkOrderM.getId()%>><%=storeWorkOrderM.getWorkOrderNo()%></option>
	<% } %>

</select> <div class="clear"></div><input type="button" class="button" value="Search"
		
			onClick="submitForm('departmentIssueNE','neStores?method=searchWorkOrder');" />
</div>
</form>
</div>
<div id="searchBlock1" style="display:inline;">

<form name="grnGrid" method="post">
<h4 ><%=messageTOBeVisibleToTheUser %></h4>

<div class="Block">
<input type="hidden" name="pageNo" value="<%=pageNo%>" id="pageNo" /> 
<input type="hidden" name="deptId" value="<%=deptId%>" /> 
<label >Work Order No.</label> 
<% if(storeWorkOrderObj != null && !storeWorkOrderObj.getWorkOrderNo().equals("") ){ %> 
<input type="text"  name="<%= WORK_ORDER_NO %>" value="<%=storeWorkOrderObj.getWorkOrderNo()%>" readonly="readonly" validate="GRN Number ,metachar,no" tabindex=1 />
 <%}else{%> 
<input type="text"  name="<%= WORK_ORDER_NO %>" value="<%=max %>" readonly="readonly" validate="Work Order No.,metachar,no" tabindex=1 /> 
<%} %>

<label >Work Order Date</label> 
<input type="text" name="<%=WORK_ORDER_DATE%>" value="<%=currentDate %>" class="date" MAXLENGTH="30" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.grnGrid.<%=WORK_ORDER_DATE%>,event)" />

<label>Repair Station</label> 
<input type="text" name="repairStation"  id="repairStation" maxlength="100" value="" />
<!-- <select name="<%=REPAIRING_CELL%>" id="sourceCombo" validate="Repairing Station,string,yes" tabindex=1>
<option value="0">Select</option>
<%for(MasRepairStation masRepairStation :repairStationList){
	if(masRepairStation.getStationName().equalsIgnoreCase("smc")){
	%>
	<option value="<%=masRepairStation.getId()%>" selected="selected"><%=masRepairStation.getStationName()%></option>
	
	<%}else{%>
		<option value="<%=masRepairStation.getId()%>"><%=masRepairStation.getStationName()%></option>
	
	
	<%} 
	}%>
	
	</select>  -->
<div class="clear"></div> 
<label >Issued By</label> 
<select name="issueBy" validate="Issued By,metachar,no" id="issuedId">
<option value="">Select</option>
<%
		String empName="";
			for (MasEmployee masEmployee :issueByList ) {
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
			<%} %>
</select>
			<div class="clear"></div>
			 
	<input type="hidden" name="<%=AUTHORITY%>" value="A">

</div>

<input type="hidden" Page No: <%=pageNo%> /> 
<input type="hidden" size="2" value="0" name="<%=NO_OF_ROWS %>" id="<%=NO_OF_ROWS %>" /> 

<input	type="hidden" name="<%=WORK_ORDER_ID %>" value="<%=workOrderId%>"id="hdb" />
<h4>Work Order Details</h4>
<div class="cmntable">
<table width="200px" col="7" id="grid" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
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
    	String particularEqp ="particularEqp";
    	String particularEqpTemp ="particularEqpTemp";
    	String batchNo="batchNo";
    	String batchNoTemp ="batchNoTemp";
    	String batchId="batchId";
    	
    	
    	String idItem2="idItem";
    	String codeItem2="codeItem";
    	String nameItem2="nameItem";
    	String idAu2="idAu";
    	String quanRec2="quanRec";
    	String quanRecTemp2="quanRecTemp";
    	String incVar2="incVar2";
    	String natOfWrk2="natOfWrk";
    	String natOfWrkTemp2="natOfWrkTemp";
    	String particularEqp2 ="particularEqp";
    	String particularEqpTemp2 ="particularEqpTemp";
    	String remarks2="remarks";
    	String remarksTemp2="remarksTemp";
    	String batchNo2="batchNo";
    	String batchNoTemp2 ="batchNoTemp";
    	String batchId2="batchId";
    	
    	if(pageNo!=1)
    	{
    		temp=detailCounter*(pageNo-1);
    	}
     	 for(int inc=1;inc<=1;inc++){
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
     		batchNoTemp =batchNoTemp2+(""+inc);
     		batchId = batchId2+(""+inc);
    	  %>
		<tr>
			<input type="hidden" name="gridSize" id="gridSize" value="1"/>
			
			<td width="5%"><input type="text" size="2" value="<%=inc%>"
				class="smcaption" name="<%=SR_NO%><%=inc %>" readonly="readonly" /></td>
			<td width="10%">
			<input type="text" size="15"
				name="<%=ITEM_CODE %>" id="<%=codeItem%>" /> 
				<input	type="hidden" size="2" value="0" class="smcaption"
				name="<%=ITEM_ID%><%=inc %>" id="<%=idItem%>" />

			<td width="10%">
			<input type="text" value="" id="nameItem<%=inc%>" size="50"
				onblur="if(fillSrNo('<%=inc %>')){checkForWorkOrder(this.value, '<%=nameItem%>','<%=inc %>');}"
				name="<%=nameItem%>" tabindex="1" />
				<div id="ac2update" style="display:none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('<%=nameItem%>','ac2update','neStores?method=getItemListForWorkOrderByAutocomplete',{parameters:'requiredField=<%=nameItem%>'});
			</script>
			</td>
		
			<input type="hidden" value="" class="smcaption"
				readonly="readonly" name="<%=AV%><%=inc %>" id="<%=idAu%>" tabindex="1" />
			
			<td width="10%">
			<%---
			<input type="text" value="" name="<%=SERIAL_NO%><%=inc %>"  size="10"
				  id="batchId<%=inc%>" tabindex="1" maxlength="15" /> --%><!--
				  <select name="<%=SERIAL_NO%><%=inc %>"  id="batchId<%=inc%>" >
				  <option value="">Select</option></select>
				  -->
				  <input type="text" size="8" name="<%=SERIAL_NO%><%=inc %>" tabindex="1" maxlength="10"  />
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
<%
     	 }   %>

	</tbody>
</table>
</div>
	
	<div style="float: left; padding-left: 15px;">
	<input type="button" name="sss" align="right" class="button" value="SAVE"
	onclick="if(validate() && checkSave()){submitForm('grnGrid','neStores?method=submitWorkOrder');}" />
	<input type="button" name="sss" class="button" value="PRINT" 
	onclick="submitForm('grnGrid','neStores?method=printWorkOrder');"	/>
	<input type="button" name="sss" class="button" value="SEARCH" onclick="getSearchBlock();" />
	
	</div>
	</form></div>
	<script
	type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script> <input type="hidden" name="rows" id="rr" value="1" /> <br />


<script type="text/javascript">
	function validate(){
		 var msg = "";
		if(document.getElementById('issuedId').value == '')
        {
			msg += "Please select the Issued By.";
			
		 }	
		if(msg!=''){
			alert(msg);
			return false;
		}
	return true;	
	 }
	
function checkSaveWorkOrder()
{
		if(confirm("Do you want to save Work Order ?"))
			return true;
		else
			return false;
}

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
	  //var e44 = document.createElement('select');
	  var e44 = document.createElement('input');
	  //e44.type = 'select';
        e44.type = 'text';
	  e44.name='serial_no'+iteration;
	  e44.id = 'batchId'+iteration;
	  e44.setAttribute('tabindex', 1); 
	  //e44.options[0] = new Option('Select', '0');
	  e44.size='8';
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

function getSearchBlock()
{

document.getElementById('searchBlock').style.display = 'inline';
document.getElementById('searchBlock1').style.display = 'none';
}


</script>
