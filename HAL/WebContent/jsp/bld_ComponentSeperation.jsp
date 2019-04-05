
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.BloodStockDetail"%>
<%@page import="jkt.hms.masters.business.BloodMasComponent"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<form name="bloodSeperation" method="post" action="">
<%
    int pageNo=1;
	Map map = new HashMap();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	
	List<BloodStockDetail> stockList = new ArrayList<BloodStockDetail>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	Box box = HMSUtil.getBox(request);
	String userName = "";
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if(map.get("stockList") != null){
		stockList=(List)map.get("stockList");
	}
	if(map.get("pageNo") != null){
		pageNo=(Integer)map.get("pageNo");
	}
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
	}
	List<BloodMasComponent> componentList = new ArrayList<BloodMasComponent>();
	if(map.get("componentList") != null){
		componentList=(List)map.get("componentList");
	}
%> <!--main content placeholder starts here-->
<div id="contentHolder">
<h6>Blood Component Separation</h6>
<div class="Clear"></div>

<!--Block One Starts-->
<div class="blockTitle">Blood Current Stock Details</div>
<div class="blockTitleCurve"></div>
<div class="division"></div>
<div class="tableHolderAuto">

<table width="100%" colspan="7" id="componentDetails1" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<th width="3%">SR No</th>
			<th width="7%">Blood Bag No</th>
			<th width="7%">Component Code</th>
			<th width="10%">Component Name</th>
			<th width="7%">Qty(ml)</th>
		</tr>
	</thead>
	<tbody>

		<tr>

			<td width="5%"><input type="text" size="2" value="<%=1 %>"
				name="<%=SR_NO1%>" readonly="readonly" /></td>


			<td width="10%"><input tyubpe="text" value=""
				name="<%=BLOOD_BAG_NO1%>" id="bloodBagNo1"
				onblur="fillComponentDetail(this.value);" /></td>
			<script type="text/javascript">
			function fillComponentDetail(obj){	
				
		<%		
		if(stockList != null && stockList.size() > 0){
				for (BloodStockDetail bloodStockDetail : stockList) {
				System.out.println("bloodStockDetail.getBloodBagNo() :"+bloodStockDetail.getBloodBagNo().toString());%>
				
								if(obj == "<%= bloodStockDetail.getBloodBagNo().toString()%>"){
	 							document.getElementById('componentNameId').value="<%=bloodStockDetail.getComponent().getComponentName()%>"
	 							document.getElementById('componentCodeId').value="<%=bloodStockDetail.getComponent().getComponentCode()%>"
	 							document.getElementById('qty1').value="<%=bloodStockDetail.getQty()%>"
	 							document.getElementById('stockDetailId').value="<%=bloodStockDetail.getId()%>"
	 							document.getElementById('stockMainId').value="<%=bloodStockDetail.getStockMain().getId()%>"
 							}
 							
 					<%} } %>
 					}
 			</script>
			<td width="10%">
			<input type="hidden" align="right" name="<%=BLOOD_STOCK_DT_ID%>" id="stockDetailId" value="" />
			<input	type="hidden" align="right" name="<%=BLOOD_STOCK_MAIN_ID%>"	id="stockMainId" value="" />
		    <input type="text" align="right"	name="<%=BLOOD_COMPONENT_CODE%>" id="componentCodeId" value=""
				readonly="readonly" /></td>
			<td><input type="text" id="componentNameId"
				name="<%=BLOOD_COMPONENT_NAME1%>" value="" readonly="readonly" /></td>
			<td><input type="text" id="qty1" name="<%=QUANTITY1 %>" value=""
				validate="Qty,int,no" MAXLENGTH="3" readonly="readonly" /></td>
		</tr>

	</tbody>
</table>
</div>

<div class="Clear"></div>
<input type="hidden" size="2" value="" name="noOfRecords"
	id="noOfRecords" /> <input type="hidden" name="pageNo" id="pageNo"
	value="<%=pageNo%>" />
<div class="blockTitle">Blood Component Separation Details</div>
<div class="blockTitleCurve"></div>
<div class="division"></div>
<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<thead>
		<tr>
			<th scope="col">Sr. No.</th>
			<th scope="col">Component Name</th>
			<th scope="col">Blood Bag No.</th>
			<th scope="col">Component Code</th>
			
			<th scope="col">Quantity (ml)</th>
		</tr>
	</thead>
	<tbody>
		<%

	int inc=0;
	for(inc=1;inc<=8;inc++){
 %>

		<tr>
			<td width="5%"><input type="text" size="2" value="<%=inc%>"
				name="<%=SR_NO%>" readonly="readonly" /> <input type="hidden"
				align="right" name="smainId" id="stockMainId1<%=inc%>" value="" /></td>
<td><input type="text" id="componentName<%=inc%>"
				name="bloodComponentName"
				onblur="if(fillSrNo('<%=inc %>')){checkForComponentCode(this.value, '<%=inc %>');}" />

			<div id="ac2update"
				style="display: none; font-weight: normal; border: 1px solid black; padding-right: 10px; background-color: white;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
	  new Ajax.Autocompleter(document.getElementById('componentName<%=inc%>'),'ac2update','bloodBank?method=getComponentNameSeparationForAutoComplete',{parameters:'requiredField=bloodComponentName'});
			</script></td>
			<td><input id="bloodBagId<%=inc%>" type="text"
				name="<%=BLOOD_BAG_NO%>" value="" size="20" MAXLENGTH="45"
				tabindex=1 readonly="readonly" /></td>
			<td><input type="hidden" value="" name="<%=BLOOD_COMPONENT_ID%>"
				id="componentId<%=inc %>" /> <input type="text" align="right"
				name="componentCode" id="componentCode<%=inc%>" value=""
				readonly="readonly" /></td>

			
			<td><input type="text" id="quantity<%=inc%>"
				name="<%=QUANTITY %>" value="" validate="Qty,int,no" MAXLENGTH="3" />
			</td>
		</tr>
		<%} %>
		<input type="hidden" name="counter" id="counter" value="<%=inc %>" />
	</tbody>
</table>
</div>
<div class="Height10"></div>
<!--Bottom labels starts-->
<div class="bottom">
<div class="division"></div>
<input type="button" class="button" value="Submit"
	onclick="if(checkFilledRow1() && checkFilledRow())submitFormDetails();"
	align="right" /> <input type="reset" class="button" name="Reset"
	id="reset" value="Reset" onclick="resetClicked('bloodSeperation');"
	accesskey="r" />
<div class="division"></div>

<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label></div>
<div class="Clear"></div>

</div>
<!--Bottom labels starts--> <!--main content placeholder ends here--></form>
<script type="text/javascript">
   //history.forward();
</script>
<script type="text/javascript">

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
<script type="text/javascript">
function fillSrNo(rowVal){

	if(document.getElementById('componentName'+rowVal).value != ""){
		var pageNo=parseInt(document.getElementById('noOfRecords').value);
  			rowVal=rowVal%8
  		if(rowVal==0){
  			rowVal=8
  	 	}
  		if(!(parseInt(document.getElementById('noOfRecords').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRecords').value=rowVal
			}
	}else if(document.getElementById('componentName'+rowVal).value == "" ){
		if(document.getElementById('noOfRecords').value > 0){
			document.getElementById('noOfRecords').value = parseInt(document.getElementById('noOfRecords').value)-1;
		}
	}
		return true;
}
function submitFormDetails(){
var stockDtId=document.getElementById("stockDetailId").value
submitForm('bloodSeperation','bloodBank?method=submitBloodComponentSeperation&stockDtId='+stockDtId+'');
}
function checkForComponentCode(val,inc){
		if(val != "")
		{
			var pageNo =parseInt(document.getElementById('pageNo').value) 
			var start=((pageNo-1)*8)+1;
			var end=((pageNo-1)*8)+8;
			
			var index1 = val.lastIndexOf("[");
			var indexForComponentName= index1;
			var index2 = val.lastIndexOf("]");
			index1++;
			var componentId = val.substring(index1,index2);
			var indexForComponentName = indexForComponentName--;
			var componentName = val.substring(0,indexForComponentName);
		
		if(componentId =="")
		{
		
	     document.getElementById('componentCode'+inc).value="";
	  	 document.getElementById('quantity'+inc).value="";
	  	 document.getElementById('bloodBagId'+inc).value= document.getElementById('bloodBagNo1').value;
	  	document.getElementById('stockMainId1'+inc).value= document.getElementById('stockMainId').value;
	     return;
		}
		for(i=1;i<inc;i++){
		
		if(inc != 1){
		if(document.getElementById('componentName'+i).value==val)
		{
			alert("Component Name already selected...!")
			document.getElementById('componentName'+inc).value=""
			document.getElementById('bloodBagId'+inc).value=""
			document.getElementById('stockMainId1'+inc).value=""
			var e=eval(document.getElementById('componentName'+inc)); 
			e.focus();
			return false;
		} }  }
		
		ajaxFunctionForAutoCompleteComponentNameForSeparition('bloodSeperation','bloodBank?method=fillItemsForComponentnameSeperation&componentName=' +  componentName , inc);
		
		}else{
			document.getElementById('componentCode'+inc).value = "";
			document.getElementById('quantity'+inc).value = "";
			document.getElementById('bloodBagId'+inc).value= document.getElementById('bloodBagNo').value;
			document.getElementById('stockMainId1'+inc).value= document.getElementById('stockMainId').value;
		}
}

function checkFilledRow(){
	var msg ="";
	if(document.getElementById('noOfRecords').value==0 || document.getElementById('noOfRecords').value ==""){
	  	alert("Please fill atleast one row to submit in Blood Component Separation Details.");
	  	return false;
	  }else{
	  var msg ="";
	  	var count = document.getElementById('noOfRecords').value;
	  	for(var i=1;i<=count;i++){
	  	 	if(document.getElementById('componentName'+i).value != ""){
	  			if(document.getElementById('bloodBagId'+i).value == ""){
	  				msg += "BloodBag No. can not be blank.\n";
	  			}
	  			if(document.getElementById('quantity'+i).value == ""){
	  				msg += "Quantity can not be blank.\n";
	  			}
	  			if(msg != ""){
	  				break;
	  			}
	  		}
	  	}
	  		if(msg != ""){
	  			alert(msg)
	  			return false;
	  		}else
	  			return true;
	  }
	 }
function checkFilledRow1(){
	var msg ="";
	  			if(document.getElementById('bloodBagNo1').value == ""){
	  				msg += "Blood Current Stock Details can not be blank.\n";
	  			}
	  			
	  		if(msg != ""){
	  			alert(msg)
	  			return false;
	  		}else
	  			return true;
	  }

</script>
