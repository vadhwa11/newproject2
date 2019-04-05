

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.PagedArray"%>


<head> 
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css"	id="vbulletin_css" />
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/stores.js"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>

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
	int requestId=0;
	if(request.getParameter("requestId")!=null){
		requestId=Integer.parseInt((String)request.getParameter("requestId"));
	}
	if(requestId>0){
%>

<title>Accessory Detail</title>


</head>

<div id="mainIn">
<form name="accessoryDetail" action="" method="post">
<div class="titleBg">
<h2>Accessory Detail</h2>
</div>
<div class="clear"></div>

<div class="paddingTop15"></div>
<input name="" value="" id="temp" type="hidden" /> 
<input type="button"	class="button" value="Add Row" onclick="addRow();" align="right" /> 
<input	type="button" class="button" value="Delete Row" onclick="removeRow()"	align="right" />
<div class="clear"></div>
<input type="hidden" size="2" value="" name="noOfRecords"	id="noOfRecords" />
	
<div class="cmntable">
<table width="100%" colspan="7" id="itemDetails" border="0" 	cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th></th>
			<th>Accessory Name</th>
			<th>Serial No</th>
			<th>Model No</th>
			<th>Warranty Start Date</th>
			<th>Warranty End Date</th>
			<th>Details</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><input type="checkbox" name="Item" value=""	tabindex=1  readonly="readonly" id="Item" /></td>
			<td><input type="text" name="ItemName" value=""  onblur="checkForIndentToDepot(this.value, 'ItemName<%=requestId %>1', 'accessoryItemId<%=requestId %>1', 'accessoryItemName<%=requestId %>1')" maxlength="30"	tabindex=1   id="ItemName<%=requestId %>1" />
			<input type="hidden" name="accessoryItemId<%=requestId %>1" id="accessoryItemId<%=requestId %>1" value="" />
			<input type="hidden" name="accessoryItemName<%=requestId %>1" id="accessoryItemName<%=requestId %>1" value="" />
			<div id="autoconecpt1" style="display: none;" class="autocomplete"></div>
					 <script type="text/javascript" language="javascript" charset="utf-8">
						  new Ajax.Autocompleter('ItemName<%=requestId %>1','autoconecpt1','maintenance?method=getItemListAutoComplet',{minChars:1,parameters:'code=1'});
				  	 </script>
			</td>
			<td><input type="text" name="serialNo<%=requestId %>1" value="" maxlength="30"	tabindex=1   id="serialNo<%=requestId %>1" /></td>
			<td><input type="text" name="modelNo<%=requestId %>1" value="" maxlength="30"	tabindex=1   id="modelNo<%=requestId %>1" /></td>
			<td>
				<input type="text" name="warrantyStartDate<%=requestId %>1"  readonly="readonly" id="warrantyStartDate<%=requestId %>1"	value="<%=currentDate %>" class="date" maxlength="30"  />
				<img	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" onclick="setdate('<%=currentDate %>',document.accessoryDetail.warrantyStartDate<%=requestId %>1,event);" />
			</td>
			<td>
			<input type="text" name="warrantyEndDate<%=requestId %>1" readonly="readonly" id="warrantyEndDate<%=requestId %>1"	value="<%=currentDate %>" class="date" maxlength="30"  />
			<img	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" onclick="setdate('<%=currentDate %>',document.accessoryDetail.warrantyEndDate<%=requestId %>1,event);" />
			</td>
			<td><textarea name="details<%=requestId %>1" id="details<%=requestId %>1"></textarea></td>
		</tr>
	</tbody>
</table>
</div>
<div class="Block">
<input type="hidden" name="accessoryCount<%=requestId %>" id="accessoryCount<%=requestId %>" value="1" />
<input	type="button" name="Submit" onclick="accessoryData()" id="addbutton" value="Submit" class="button" accesskey="a" /> 
<!-- <input	type="Reset" name="Submit" id="addbutton"	value="Reset" class="button" accesskey="a" />  -->
<input type="button" class="button" onclick="funClose()" value="Close" />
<div class="clear"></div>
</div>
<%} %>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
<script>
	function funClose(){
		window.opener.document.getElementById("accessory<%=requestId%>").checked=false;
		window.opener.document.getElementById("accessoryData<%=requestId%>").innerHTML="";
		window.close();
	}
	function accessoryData(){
		var divId=window.opener.document.getElementById("accessoryData<%=requestId %>");
		var count=parseInt(document.getElementById("accessoryCount<%=requestId %>").value);
		divId.innerHTML="";
		
		if(count>0){
		for(var i=1;i<=count;i++){
			var e1 = document.createElement('input');
			  e1.type = 'hidden';
			  e1.name='accessoryItemId<%=requestId %>'+i;
			  e1.value=document.getElementById('accessoryItemId<%=requestId %>'+i).value;
			  divId.appendChild(e1);
			  
			  var e2 = document.createElement('input');
			  e2.type = 'hidden';
			  e2.name='accessoryItemName<%=requestId %>'+i;
			  e2.value=document.getElementById('accessoryItemName<%=requestId %>'+i).value;
			  divId.appendChild(e2);
			  
			  var e3 = document.createElement('input');
			  e3.type = 'hidden';
			  e3.name='serialNo<%=requestId %>'+i;
			  e3.value=document.getElementById('serialNo<%=requestId %>'+i).value;
			  divId.appendChild(e3);
			  
			  var e4 = document.createElement('input');
			  e4.type = 'hidden';
			  e4.name='modelNo<%=requestId %>'+i;
			  e4.value=document.getElementById('modelNo<%=requestId %>'+i).value;
			  divId.appendChild(e4);
			  
			  var e5 = document.createElement('input');
			  e5.type = 'hidden';
			  e5.name='warrantyStartDate<%=requestId %>'+i;
			  e5.value=document.getElementById('warrantyStartDate<%=requestId %>'+i).value;
			  divId.appendChild(e5);
			  
			  var e6 = document.createElement('input');
			  e6.type = 'hidden';
			  e6.name='warrantyEndDate<%=requestId %>'+i;
			  e6.value=document.getElementById('warrantyEndDate<%=requestId %>'+i).value;
			  divId.appendChild(e6);
			  
			  var e7 = document.createElement('input');
			  e7.type = 'hidden';
			  e7.name='details<%=requestId %>'+i;
			  e7.value=document.getElementById('details<%=requestId %>'+i).value;
			  divId.appendChild(e7);
		}
		var e8 = document.createElement('input');
		  e8.type = 'hidden';
		  e8.name='accessoryCount<%=requestId %>';
		  e8.value=count;
		  divId.appendChild(e8);
// 		  alert(count);
		  window.close();
		}
	}

	function checkForIndentToDepot(val, ItemId, accessoryId, accessoryName){
	  var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var requestId = val.substring(index1,index2);
	    var itemName = val.substring(0,index1-1);
// 	    alert(requestId+"====="+itemName+"====="+accessoryId+"====="+accessoryName);
	     if(requestId.length==0){
	     document.getElementById(ItemId).value="";
	     }else{
	    	 document.getElementById(accessoryId).value=requestId;
    		 document.getElementById(accessoryName).value=itemName;
	     }
	     }
	  
	function addRow(){
		var table=document.getElementById("itemDetails"); 
		var tableLength=table.rows.length;
		var iteration=tableLength;
		var row=table.insertRow(tableLength);
		var cell2 = row.insertCell(0);
		 var e2 = document.createElement('input');
		  e2.type = 'checkbox';
		  e2.name='Item';
		  e2.id='Item'+iteration;
		  cell2.appendChild(e2);
		  var e2 = document.createElement('input');
		  e2.type = 'hidden';
		  e2.name='ItemId';
		  e2.id='ItemId'+iteration;
		  cell2.appendChild(e2);
		  
		  var cell2 = row.insertCell(1);
		  var e2 = document.createElement('input');
		  e2.type = 'text';
		  e2.name='ItemName';
		  e2.value='';
		  e2.validate='Item Name,string,yes';
		  e2.onblur=function(){if(this.value!=''){checkForIndentToDepot(this.value, "ItemName<%=requestId %>"+iteration, "accessoryItemId<%=requestId %>"+iteration, "accessoryItemName<%=requestId %>"+iteration)}};
		  e2.id='ItemName<%=requestId %>'+iteration;
		  e2.autocomplete="off";
		  cell2.appendChild(e2);
		  var e3 = document.createElement('input');
		  e3.type = 'hidden';
		  e3.name='ItemName';
		  e3.value='';
		  e3.id='accessoryItemId<%=requestId %>'+iteration;
		  cell2.appendChild(e3);
		  var e4 = document.createElement('input');
		  e4.type = 'hidden';
		  e4.name='ItemName';
		  e4.value='';
		  e4.id='accessoryItemName<%=requestId %>'+iteration;
		  cell2.appendChild(e4);
		  
		  var div = document.createElement('div');
		  div.id='autoconecpt'+iteration;
		  div.style.display=' none';
		  div.className='autocomplete';
		  div.autocomplete="off";
		  cell2.appendChild(div);
		  var script = document.createElement( "script" );
		  script.type = "text/javascript";
		  script.charset = "utf-8";
		  script.innerHTML = "new Ajax.Autocompleter('ItemName<%=requestId %>"+iteration+"','autoconecpt"+iteration+"','maintenance?method=getItemListAutoComplet',{minChars:1,parameters:'code=1'})";
		  cell2.appendChild(script);
		  
		  var cell2 = row.insertCell(2);
		  var e2 = document.createElement('input');
		  e2.type = 'text';
		  e2.name='serialNo<%=requestId %>'+iteration;
// 		  e2.readOnly='readOnly';
		  e2.id='serialNo<%=requestId %>'+iteration;
		  cell2.appendChild(e2);
		  
		  var cell2 = row.insertCell(3);
		  var e2 = document.createElement('input');
		  e2.type = 'text';
		  e2.name='modelNo<%=requestId %>'+iteration;
	  	  e2.id ='modelNo<%=requestId %>'+iteration;
	  	  cell2.appendChild(e2);
		  
		  var cell2 = row.insertCell(4);
		  var e2 = document.createElement('input');
		  var str="<input type='text' name='warrantyStartDate<%=requestId %>"+iteration+"'  readonly='readonly' id='warrantyStartDate<%=requestId %>"+iteration+"'	value='<%=currentDate %>' class='date' maxlength='30'  />"+
			"<img	id='calendar' src='/hms/jsp/images/cal.gif' width='16' height='16'	border='0' validate='Pick a date' onclick=\"setdate('<%=currentDate %>',document.accessoryDetail.warrantyStartDate<%=requestId %>"+iteration+",event);\" />";
		  cell2.innerHTML=str;
		  
		  var cell2 = row.insertCell(5);
		  var str1="<input type='text' name='warrantyEndDate<%=requestId %>"+iteration+"'  readonly='readonly' id='warrantyEndDate<%=requestId %>"+iteration+"'	value='<%=currentDate %>' class='date' maxlength='30'  />"+
			"<img	id='calendar' src='/hms/jsp/images/cal.gif' width='16' height='16'	border='0' validate='Pick a date' onclick=\"setdate('<%=currentDate %>',document.accessoryDetail.warrantyEndDate<%=requestId %>"+iteration+",event);\" />";
		  cell2.innerHTML=str1;
		  
		  var cell2 = row.insertCell(6);
		  var e2 = document.createElement('textarea');
		  e2.type = 'text';
		  e2.name='details<%=requestId %>'+iteration;
		  e2.id ='details<%=requestId %>'+iteration;
		  cell2.appendChild(e2);
		  
		  //-------- counter Id-------
		  document.getElementById("accessoryCount<%=requestId %>").value=parseInt(document.getElementById("accessoryCount<%=requestId %>").value)+1;
		 
	}
	
	function removeRow(){
		var table=document.getElementById("itemDetails"); 
		var tableLength=table.rows.length;
		var item=document.getElementsByName("Item");
		var itemLength=0;
		for(var i=0;i<item.length;i++){
			if(item[i].checked==true){
				itemLength=itemLength+1;
			}
		}
		if((itemLength+2)<=tableLength){
			for(var i=0;i<item.length;i++){
				if(item[i].checked==true){
					table.deleteRow(i+1);
				}
		}
		}else{
			alert("You Con't Delete!");
		}
	}
</script>
