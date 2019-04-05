<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.masters.business.PrqAssetDetails"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.MasManufacturer"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.StoreGrnT"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/pops_menu.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/ajax.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/prototype.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/scriptaculous.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/unittest.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/calendar.js"></script>
<script>
	 var nameArray=new Array();
	 var itemsArray1=new Array();
</script>
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



<%
	Map map= new HashMap();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	List<StoreItemBatchStock> batchStockList=new ArrayList<StoreItemBatchStock>();
	/* List<MasInstituteDepartment> masDepartments=new ArrayList<MasInstituteDepartment>(); */ /* commented by amit das on 02-09-2016 */
	List<MasDepartment> masDepartments=new ArrayList<MasDepartment>();
	List<MasManufacturer> masManufacturers=new ArrayList<MasManufacturer>();
	List<PrqAssetDetails> assetDetails=new ArrayList<PrqAssetDetails>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");
	String message="";
	if(map.get("message") != null){
		message = (String)map.get("message");
	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	int deptId = 0;
	if (session.getAttribute("deptId") != null) {
		deptId = (Integer) session.getAttribute("deptId");
	}
	int hospitalId = 0;
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	if(map.get("batchStockList")!=null){
		batchStockList=(List<StoreItemBatchStock>)map.get("batchStockList");
	}
	if(map.get("masManufacturers")!=null){
		masManufacturers=(List<MasManufacturer>)map.get("masManufacturers");
	}
	/* if(map.get("masDepartments")!=null){
		masDepartments=(List<MasInstituteDepartment>)map.get("masDepartments");
	} */
	/* commented by amit das on 02-09-2016 */
	if(map.get("masDepartments")!=null){
		masDepartments=(List<MasDepartment>)map.get("masDepartments");
	}
	/* added by amit das on 02-09-2016 */
	
	if(map.get("assetDetails")!=null){
		assetDetails=(List<PrqAssetDetails>)map.get("assetDetails");
	}
	String department="";
	String manufectrer="";
	String assetDetail="";
	if(masDepartments.size()>0){
		// loop changed by Amit Das on 29-03-2016 for selected department default selection
		for(MasDepartment dep:masDepartments){
			if((batchStockList!=null && batchStockList.size() > 0) && (batchStockList.get(0).getDepartment().getId()==dep.getId())){
				department+="<option value='"+dep.getId()+"' selected='selected'>"+dep.getDepartmentName()+"</option>";
			} else {
				department+="<option value='"+dep.getId()+"'>"+dep.getDepartmentName()+"</option>";
			}
		}
	}
	if(masManufacturers.size()>0){
		for(MasManufacturer menu:masManufacturers){
			manufectrer+="<option value='"+menu.getId()+"'>"+menu.getManufacturerName()+"</option>";
		}
	}
	if(assetDetails.size()>0){
		for(PrqAssetDetails asset:assetDetails){
			assetDetail+="<option value='"+asset.getId()+"'>"+asset.getAssetCode()+"</option>";
		}
	}
	%>
<body onclick="parent_disable()">
<div class="titleBg">
<h2>Equipment Detail</h2>
</div>
<div class="clear"></div>

<!-- thread search menu -->
<div class="Block">
<form name="itemDetails" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>
<%-- <label>GRN Date </label>
<label class="value"><%=HMSUtil.changeDateToddMMyyyy(storeGrnT.get(0).getGrnMaster().getGrnDate()) %></label>
<label>GRN No. </label>
<label class="value"><%=storeGrnT.get(0).getGrnMaster().getGrnNo() %></label> --%>
<label>Equipment Name </label>
<label class="value"><%=batchStockList.get(0).getItem().getNomenclature() %></label>

<%--
<label>Remaining Quantity </label>
 <%BigDecimal stEQDet=new BigDecimal(0);
%>
<%if(storeGrnT.get(0).getReceivedQty()!=null){ %>
	<%
		if(storeGrnT.get(0).getEqpDetailQty()!=null){
			stEQDet=storeGrnT.get(0).getReceivedQty().subtract(storeGrnT.get(0).getEqpDetailQty());
		}else{stEQDet=storeGrnT.get(0).getReceivedQty();}
	}else{ 
	stEQDet=storeGrnT.get(0).getReceivedQty(); 
	} %>

<label class="value"><%=stEQDet.intValue()%></label> --%>

<label>Equipment Detail Date </label>
<input type="text" name="equipmentDetailDate"	value="<%= currentDate %>" class="date" maxlength="30" tabindex=1 />
<img	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.itemDetails.equipmentDetailDate,event);" />
<div class="clear"></div>

<h4>Equipment Details</h4>

<div class="paddingTop15"></div>
<input name="" value="" id="temp" type="hidden" /> 
<!-- <input type="button"	class="button" value="Add Row" onclick="addRow();" align="right" /> 
<input	type="button" class="button" value="Delete Row" onclick="removeRow()"	align="right" />
<div class="clear"></div> -->
<input type="hidden" size="2" value="" name="noOfRecords"	id="noOfRecords" />
	
<div class="cmntable">
<table id="equiDetails">
	<thead>
		<tr>
			<th></th>
			<th>Department</th>
			<th>Model Number</th>
			<th>Serial Number</th>
			<th>Depreciation (%)</th>
			<th>Price</th>
			<th>Make</th>
			<th>Manufacturer</th>
			<th>Technical Specifications</th>
			<th>Warranty</th>
			<th>CAMC/CMC</th>
			<!-- <th>CMC</th> -->
			<th>AMC</th>
			<th>Accessory</th>
			<th>Installed</th>
			<th>Accept</th>
			<th>AssetId</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>
			<input type="checkbox" name="selectedEquipment" class="radioCheck"  value="" 	tabindex=1   id="selectedEquipment1" />
			</td>
			<td>
			<select name="department1" validate="Department,string,yes" id="department1">
				<option value="">-- Select --</option>
				<%=department %>
			</select>
			</td>
			
			<td>
			<input name="modelNumber1" id="modelNumber1" validate="Model Number,string,yes" value="" maxlength="30"  />
			</td>
			<td>
			<input type="text" name="serialNumber1" validate="Serial Number,string,yes" maxlength="30" value="<%=batchStockList .size()>0 && batchStockList.get(0).getBatchNo()!= null?batchStockList.get(0).getBatchNo():"" %>"	id="serialNumber1" />
			</td>
			
			<td>
			<input type="text" name="Depreciation1" value="" validate="Depreciation,int,yes" maxlength="2"  id="Depreciation1" />
			</td>
			
			<td>
			<input type="text" name="price1"   maxlength="2" value="<%=batchStockList .size()>0 && batchStockList.get(0).getCostPrice()!= null?batchStockList.get(0).getCostPrice():"0" %>" id="price1" readonly="readonly"/>
			</td>
			
			<td>
			<input type="text" name="make1" value="" validate="Make,string,yes"	validate="Make,string,yes" maxlength="30"  id="make" />
			</td>
			
			<td>
			<select name="manufacture1" validate="Manufacture,string,yes" validate="Manufacturer,string,yes" id="manufacture1">
				<option value="">-- Select --</option>
				<%=manufectrer %>
				</select>
			</td>
			
			<td>
			<textarea rows="4" cols="40" maxlength="200" validate="Technical Specification,string,yes" id="technicalSpecification1" name="technicalSpecification1"></textarea>
			</td>
			
			<td>
			<input type="radio" name="warranty1" class="radioCheck" id='warranty1' value="1,1"  onclick="warrantyDetail(this, this.value)"  />
<!-- 			<input type="radio" name="warranty" style="margin: 0 0px 0px 0px;" checked="checked" value="No" />No<br/> -->
<!-- 			<input type="radio" name="warranty" style="margin: 0 0px 0px 0px;" onclick="warrantyDetail(this.value,'1')"  value="Yes" />Yes -->
			
			<input type="hidden" id="warrantyStartDate1" name="warrantyStartDate1" value="" />
			<input type="hidden" id="warrantyEndDate1" name="warrantyEndDate1" value="" />
			<input type="hidden" id="warrantyDetails1" name="warrantyDetails1" value="" />
			<input type="hidden" id="preventive1" name="preventive1" value="" />
			<input type="hidden" id="totalPreventive1" name="totalPreventive1" value="" />
			<input type="hidden" id="checkList1" name="checkList1" value="" />
			<input type="hidden" id="checkListName1" name="checkListName1" value="" />
<!-- 			<select name="warranty" validate="Warranty,string,yes" id="warranty" onchange="warrantyDetail(this.value)"><option value="No">No</option><option value="Yes">Yes</option></select> -->
			</td>
			<td>
			<input type="radio" name="warranty1" class="radioCheck" id='camc1' value="1,2"  onclick="warrantyDetail(this, this.value)"  />
			</td>
			<!-- <td>
			<input type="radio" name="warranty1" class="radioCheck" id='cmc1' value="1,3"  onclick="warrantyDetail(this, this.value)"  />
 			</td> -->
			<td>
			<input type="radio" name="warranty1" class="radioCheck" id='amc1' value="1,4"  onclick="warrantyDetail(this, this.value)"  />
 			</td>
		
			<td>
			<input type="checkbox" name="accessory1" class="radioCheck" id='accessory1' value="1"  onclick="openPopupWindows(this, this.value)"  />
<!-- 			<input type="radio" name="accessory" style="margin: 0 0px 0px 0px;" checked="checked" value="No" />No<br/> -->
<!-- 			<input type="radio" name="accessory" style="margin: 0 0px 0px 0px;" onclick="openPopupWindows('1')"  value="Yes" />Yes -->
<!-- 			<a href="#" onclick="openPopupWindows('1')">Accessory</a> -->
				<div id="accessoryData1">
				</div>
			</td>
			
			<td>
			<input type="checkbox" name="equipmentStatus1" class="radioCheck" id='equipmentStatus1' value="1"  onclick="installationDetail(this, 'equiStatus1')"  />
			<div id="equiStatus1" style="display: none">
				<input type="text" name="installationDate1" validate="Installation Date,String,yes" id="installationDate1" readonly="readonly"	value="<%= currentDate %>" class="date" maxlength="30" tabindex=1 />
				<img	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.itemDetails.installationDate1,event);" />
			</div>
<!-- 			<input type="radio" name="equipmentStatus" style="margin: 0 0px 0px 0px;" checked="checked" value="UnInstalled" />UnInstalled<br/> -->
<!-- 			<input type="radio" name="equipmentStatus" style="margin: 0 0px 0px 0px;" onclick="openPopupWindows('1')"  value="Installed" />Installed -->
<!-- 			<select name="equipmentStatus" validate="Equipment Status,string,yes"> -->
<!-- 			<option  value="">Select </option> -->
<!-- 			<option  value="Installed">Installed </option> -->
<!-- 			<option  value="UnInstalled">UnInstalled </option> -->
<!-- 			</select> -->
			</td>
			
			<td>
			<input type="checkbox" name="userStatus1" class="radioCheck" id='userStatus1' checked="checked" value="1" onclick="resonDetail(this, 'reson1')"  />
			<textarea name="reson1" id="reson1"  style="display: none" rows="" cols=""></textarea>
<!-- 			<input type="radio" name="userStatus" style="margin: 0 0px 0px 0px;" checked="checked" value="Accept" />Accept<br/> -->
<!-- 			<input type="radio" name="userStatus" style="margin: 0 0px 0px 0px;" onclick="openPopupWindows('1')"  value="Reject" />Reject -->
<!-- 			<select name="userStatus" validate="User Status,string,yes"> -->
<!-- 			<option  value="">Select </option> -->
<!-- 			<option  value="Accept">Accept </option> -->
<!-- 			<option  value="Reject">Reject</option> -->
<!-- 			</select> -->
			</td>
			<td>
			<select name="assetId1" validate="assetId,string,yes" id="assetId1">
				<option value="">-- Select --</option>
				<%=assetDetail %>
			</select>
			</td>
		</tr>
	</tbody>
</table>
</div>
<%-- <%BigDecimal stQty=new BigDecimal(0); %>
<%if(storeGrnT.get(0).getReceivedQty()!=null){ %>
	<%
	if(storeGrnT.get(0).getEqpDetailQty()!=null)
		stQty=storeGrnT.get(0).getReceivedQty().subtract(storeGrnT.get(0).getEqpDetailQty());
	else
		stQty=storeGrnT.get(0).getReceivedQty();
	}else{  
		stQty=storeGrnT.get(0).getReceivedQty(); 
} %> 
<input type="hidden" id="remainingQty" value="<%=stQty.intValue()%>" />--%>
<input type="hidden" name="itemCount" id="itemCount" value="1" />
<%-- <input type="hidden" name="storeGrnId" id="storeGrnId" value="<%=storeGrnT.get(0).getId() %>" /> --%>
<input type="hidden" name="itemId" id="itemId" value="<%=batchStockList.get(0).getItem().getId() %>" />
<%-- <input type="hidden" name="grnId" id="grnId" value="<%=storeGrnT.get(0).getGrnMaster().getId() %>" /> --%>
<input type="hidden" name="batchStockId" id="batchStockId" value="<%=batchStockList.get(0).getId() %>" />
<input type="hidden" name="currentDate" id="currentDate" value="<%=currentDate %>" />
<input type="hidden" name="currentTime" id="currentTime" value="<%=currentTime %>" />
<input type="button" name="save" class="button" onclick="if( vali()){dataSubmit()}" value="Submit" />
</form>
</div>
</body>
<script type="text/javascript">
function dataSubmit(){
	submitForm('itemDetails', 'fm?method=submitEquipmentDetails')
}
function parent_disable() {
	if(newwindow && !newwindow.closed)
		newwindow.focus();
	}
function warrantyDetail(id, val){
	if(id.checked){
		var url="/hms/hms/fm?method=showWarrantyDetailJsp&requestId="+val;
		 newwindow=window.open(url,'name',"left=100,top=100,height=400,width=850,status=1,scrollbars=1,resizable=0");
	}
}
function openPopupWindow()
{
 var url="/hms/hms/fm?method=showManufactureDetailJsp";
 newwindow=window.open(url,'name',"left=100,top=100,height=400,width=850,status=1,scrollbars=1,resizable=0");
}

function openPopupWindows(id, val)
{
	document.getElementById("accessoryData"+val).innerHTML="";
	if(id.checked){
		 var url="/hms/hms/fm?method=showAccessoryDetailsJsp&requestId="+val;
		 newwindow=window.open(url,'name',"left=100,top=100,height=400,width=1200,status=1,scrollbars=1,resizable=0");
	}
}
function resonDetail(ch, id){
	document.getElementById(id).style.display="none";
	document.getElementById(id).setAttribute('validate', 'Reason,string,no');
	if(ch.checked==false){
		document.getElementById(id).style.display="";
		document.getElementById(id).setAttribute('validate', 'Reason,string,yes');
	}
}
function installationDetail(ch, id){
	document.getElementById(id).style.display="none";
	if(ch.checked){
		document.getElementById(id).style.display="";
	}
}

function addRow()
{
	var rQty=parseInt(document.getElementById("remainingQty").value);
	var tbl = document.getElementById('equiDetails');
	var lastRow = tbl.rows.length;
	if(lastRow-1<rQty){
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('itemCount');
	var iteration = parseInt(hdb.value)+1;
	hdb.value = iteration;
   	var cell0 = row.insertCell(0);
	var e0 = document.createElement('input');
	e0.type = 'checkbox';
	e0.name='selectedEquipment';
	//e0.id='selectedChrage'+(iteration);
	e0.className = 'radioCheck';
	e0.value=(iteration);
	cell0.appendChild(e0);
	
	var cell1 = row.insertCell(1);
	var e1 = document.createElement('select');
	e1.name = 'department'+(iteration);
	e1.id = 'department'+(iteration);
	e1.setAttribute('validate','Department,string,yes');
	var op1=cell1.appendChild(e1);
	op1.innerHTML="<option value=''>--Select--</option><%=department%>";
   
	var cell3 = row.insertCell(2);
	var e3 = document.createElement('input');
	e3.type = 'text';
	e3.name='modelNumber'+(iteration);
	e3.id = 'modelNumber'+(iteration);
	e3.setAttribute('validate','Model Number,string,yes');
	e3.maxLength="25";
	cell3.appendChild(e3);
	
	var cell4 = row.insertCell(3);
	var e4 = document.createElement('input');
	e4.type = 'text';
	e4.name='serialNumber'+(iteration);
	e4.id='serialNumber'+(iteration);
	e4.setAttribute('validate','Serial Number,string,yes');
	e4.maxLength="25";;
	cell4.appendChild(e4);
    
    var cell5= row.insertCell(4);
    var e5 = document.createElement('input');
    e5.type = 'text';
    e5.id='make'+(iteration);
    e5.name='make'+(iteration);
    e5.setAttribute('validate','Make,string,yes');
    e5.maxLength="25";;
    cell5.appendChild(e5);


    var cell6= row.insertCell(5);
    var e6 = document.createElement('select');
    e6.name='manufacture'+(iteration);
	e6.id='manufacture'+(iteration);
	e6.setAttribute('validate','Manufacture,string,yes');
    var m=cell6.appendChild(e6);
    m.innerHTML="<option value=''>--Select--</option><%=manufectrer%>";

    
    var cell6= row.insertCell(6);
    var e6 = document.createElement('textarea');
    e6.name='technicalSpecification'+iteration;
    e6.type = 'textarea'
    e6.setAttribute(e6.name,'technicalSpecification'+(iteration));
    e6.setAttribute('validate','Technical Specification,string,yes');
    e6.maxLength="200";
    cell6.appendChild(e6);
    
    var cell7= row.insertCell(7);
    var e7 = document.createElement('input');
    e7.type = 'radio';
    e7.name='warranty'+iteration;
    e7.id='warranty'+iteration;
    e7.className = 'radioCheck';
	e7.value=(iteration)+',1';
    e7.onclick=function(){warrantyDetail(this, this.value)};
    cell7.appendChild(e7);
 //------Warranty Hidden----Start   
    var e7 = document.createElement('input');
    e7.type = 'hidden';
    e7.name='warrantyStartDate'+iteration;
    e7.id='warrantyStartDate'+iteration;
	e7.value='';
    cell7.appendChild(e7);
    
    var e7 = document.createElement('input');
    e7.type = 'hidden';
    e7.name='warrantyEndDate'+iteration;
    e7.id='warrantyEndDate'+iteration;
	e7.value='';
    cell7.appendChild(e7);
    
    var e7 = document.createElement('input');
    e7.type = 'hidden';
    e7.name='warrantyDetails'+iteration;
    e7.id='warrantyDetails'+iteration;
	e7.value='';
    cell7.appendChild(e7);
    
    var e7 = document.createElement('input');
    e7.type = 'hidden';
    e7.name='preventive'+iteration;
    e7.id='preventive'+iteration;
	e7.value='';
    cell7.appendChild(e7);
    
    var e7 = document.createElement('input');
    e7.type = 'hidden';
    e7.name='totalPreventive'+iteration;
    e7.id='totalPreventive'+iteration;
	e7.value='';
    cell7.appendChild(e7);
    
    var e7 = document.createElement('input');
    e7.type = 'hidden';
    e7.name='checkList'+iteration;
    e7.id='checkList'+iteration;
	e7.value='';
    cell7.appendChild(e7);
    
    var e7 = document.createElement('input');
    e7.type = 'hidden';
    e7.name='checkListName'+iteration;
    e7.id='checkListName'+iteration;
	e7.value='';
    cell7.appendChild(e7); 
  //------Warranty Hidden----End
  
 	 var cell7= row.insertCell(8);
    var e7 = document.createElement('input');
    e7.type = 'radio';
    e7.name='warranty'+iteration;
    e7.id='camc'+iteration;
    e7.className = 'radioCheck';
	e7.value=(iteration)+',2';
    e7.onclick=function(){warrantyDetail(this, this.value)};
    cell7.appendChild(e7);
    
  /*   var cell7= row.insertCell(9);
    var e7 = document.createElement('input');
    e7.type = 'radio';
    e7.name='warranty'+iteration;
    e7.id='cmc'+iteration;
    e7.className = 'radioCheck';
	e7.value=(iteration)+',3';
    e7.onclick=function(){warrantyDetail(this, this.value)};
    cell7.appendChild(e7); */
    
    var cell7= row.insertCell(9);
    var e7 = document.createElement('input');
    e7.type = 'radio';
    e7.name='warranty'+iteration;
    e7.id='amc'+iteration;
    e7.className = 'radioCheck';
	e7.value=(iteration)+',4';
    e7.onclick=function(){warrantyDetail(this, this.value)};
    cell7.appendChild(e7);
  
    var cell7= row.insertCell(10);
    var e7 = document.createElement('input');
    e7.type = 'checkbox';
    e7.name='accessory'+iteration;
    e7.id='accessory'+iteration;
    e7.className = 'radioCheck';
	e7.value=(iteration);
    e7.onclick=function(){openPopupWindows(this, this.value)};
    cell7.appendChild(e7);
    var e7 = document.createElement('div');
    e7.id='accessoryData'+iteration;
    cell7.appendChild(e7);
    
    var cell7= row.insertCell(11);
    var e7 = document.createElement('input');
    e7.type = 'checkbox';
    e7.name='equipmentStatus'+iteration;
    e7.id='equipmentStatus'+iteration;
    e7.className = 'radioCheck';
	e7.value=(iteration);
    e7.onclick=function(){installationDetail(this, "equiStatus"+iteration)};
    cell7.appendChild(e7);
    var intallationDate="<input type='text' name='installationDate"+iteration+"' validate='Installation Date,String,yes' id='installationDate"+iteration+"' readonly='readonly'	value='<%= currentDate %>' class='date' maxlength='30'  />"+
						"<img	id='calendar' src='/hms/jsp/images/cal.gif' width='16' height='16'	border='0' validate='Pick a date' onclick=\"setdate('<%=currentDate%>',document.itemDetails.installationDate"+iteration+",event);\" />";
	var e7 = document.createElement('div');
	e7.id='equiStatus'+iteration;
	e7.style.cssText='display: none';
	e7.innerHTML=intallationDate;
	cell7.appendChild(e7);
	
						
    var cell7= row.insertCell(12);
    var e7 = document.createElement('input');
    e7.type = 'checkbox';
    e7.name='userStatus'+iteration;
    e7.id='userStatus'+iteration;
    e7.className = 'radioCheck';
    e7.checked=true;
	e7.value=(iteration);
    e7.onclick=function(){resonDetail(this, "reason"+iteration)};
    cell7.appendChild(e7);
    var e7 = document.createElement('textarea');
    e7.name='reason'+iteration;
    e7.id='reason'+iteration;
//     e6.validate='Reason,string,yes';
    e7.maxLength="200";
    e7.style.cssText='display: none';
    cell7.appendChild(e7);
    
    var cell8= row.insertCell(13);
	var e8= document.createElement('select');
	e8.name = 'assetId'+(iteration);
	e8.id = 'assetId'+(iteration);
	e8.setAttribute('validate','assetId,string,yes');
	var op8=cell8.appendChild(e8);
	op8.innerHTML="<option value=''>--Select--</option><%=assetDetail%>";
    
    document.getElementById('itemCount').value=iteration;
	}else{
		alert("No Remaining Quantity.");
	}
	
}

function removeRow()
{
	var tbl = document.getElementById('equiDetails');
	 var tblRows  = tbl.getElementsByTagName("tr");
	
  	if(tblRows.length-2==0){
         	alert("Can not delete all rows")
         	return false;
     }
	         
  	for(abc=0;abc<document.getElementsByName('selectedEquipment').length;abc++)
	{
		if (document.getElementsByName('selectedEquipment')[abc].checked == true)
		{
		  	tbl.deleteRow(abc+1);
		}
	}
}
function vali()
{
	var le=document.getElementById("itemCount").value;
	//alert(le);
	flag=false;
	flag1=false;
	for(i=1;i<=le;i++)
		{
		//alert(document.getElementById("warranty"+i));
		if(document.getElementById("warranty"+i)!=null && document.getElementById("warranty"+i).checked==true){ 
			flag=false;
		}
		else if(document.getElementById("camc"+i)!=null && document.getElementById("camc"+i).checked==true){  
			flag=false; 
		}/* else if(document.getElementById("cmc"+i)!=null && document.getElementById("cmc"+i).checked==true){ 
			flag=false; 
		} */else if(document.getElementById("amc"+i)!=null && document.getElementById("amc"+i).checked==true){ 
			flag=false;  
		}else{
			flag=true;
			break;
		}
		if(document.getElementById("equipmentStatus"+i)!=null){
		if(document.getElementById("equipmentStatus"+i).checked==false)
		 {
			flag1=true;
			break;
		 }}
		}
	   if(flag)
		   {
		   alert("Please Select Warranty Details ");
		   return false;
		   }
	   else
	   if(flag1)
	   {
	   alert("Please Select Installation date");
	   return false;
	   }
	   else{
	   return true;
	   }
	}

</script>
