<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>


<div class="Clear"></div>
<div class="titleBg"><h2>Expendable Non Drug Consumption</h2></div>

<script>
	<%
	
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
			
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
</script>
<%
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");  
String time = (String)utilMap.get("currentTimeWithoutSc");

%>
<div class="Clear"></div>
<form name="drugConsumption" method="post">
<div class="Block">
<label>Date</label>
<input	type="text" name="consumptionDate" id="consumptionDate" readonly="readonly"	value="<%=currentDate %>"	class="calDate" tabindex="1" MAXLENGTH="30" />
<img	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"	onClick="setdate('<%=date %>',document.drugConsumption.consumptionDate,event)" />
<!--
<label>Time</label>-->
<input	type="hidden" name="consumptionTime" value="<%= time %>" id="consumptionTime" validate="Time,string,no" class="date" MAXLENGTH="5"onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);" onBlur="IsValidTimeWithBlankCheck(this.value,this.id);" 	/>

<div class="Clear"></div>


</div>
<div class="Clear"></div>
<div class="paddingTop15"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0" id="consumptionDetails">
  <thead>
    <tr>
      <th width="5%">Nomenclature</th>
      <th width="10%">Batch No.</th>
      <th width="13%">Expiry Date</th>
      <th width="13%">Qty in Stock</th>
      <th width="13%">Qty Consumed</th>
      <th width="13%">Add</th>
      <th width="13%">Delete</th>
    </tr>
  </thead>
  <tbody>
  	<tr>
		<td>
	    <input type="text" value="" tabindex="1" id="nomenclature1" size="35"  name="nomenclature1" onblur="checkForNomenclature(this.value,1);"  />
	        <div id="ac2update1" style=" display:none; " class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			
			  new Ajax.Autocompleter('nomenclature1','ac2update1','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature1'});
			</script>
		</td>
		<td id="batchDiv1">
		<input type="hidden" name="pvmsNo1" tabindex="1" id="pvmsNo1"	size="5" readonly="readonly" />
		<input type="hidden" id="itemId1" name="itemId1" value="">
		<select id="batchNo1" name="batchNo1" >
		<option value="0">Select</option>
		</select>
		</td>
		<td><input type="text" id="expiryDate1" name="expiryDate1" value="" /></td>
		<td><input type="text" id="stockQty1" name="stockQty1" value="" /></td>
		<td><input type="text" id="consumedQty1" name="consumedQty1" value="" /></td>
		<td>
			<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" /> 
			</td>
			<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('consumptionDetails','hdb',this);"  />
			</td>
	</tr>
  </tbody>
</table>
<input type="hidden" name="hdb" value="1" id="hdb" />

<input type="button" name="Submit11" id="addbutton"	onclick="submitForm('drugConsumption','/hms/hms/ipd?method=saveDrugConsumptionDetails','validateRows');"	value="Submit" class="button" accesskey="a" />
<input type="reset" name ="Reset" value ="Reset" class="button" tabindex="1" accesskey="r" />
</form>
<script>

function checkForNomenclature(val,inc)
{
    
	if(val != ""){
		
		var index1 = val.lastIndexOf("[");
		var indexForChargeCode = index1;
		var index2 = val.lastIndexOf("]");
		index1++;
		var chargeId = val.substring(index1,index2);
		var indexForChargeCode = indexForChargeCode--;
		var chargeCode = val.substring(0,indexForChargeCode);

		 
		if(chargeId == "" ) {
	      	document.getElementById('nomenclature'+inc).value="";
	      	document.getElementById('pvmsNo'+inc).value="";
	       	return;
		}

		for(i=1;i<inc;i++){
            
			if(inc != 1){
				 
 				if(document.getElementById('nomenclature'+i).value==val) {
					alert("Nomenclature already selected...!")
					document.getElementById('nomenclature'+inc).value=""
					document.getElementById('pvmsNo'+inc).value="";
					var e=eval(document.getElementById('nomenclature'+inc));
					e.focus();
					return false;
				}
			}
		}
		
	if(chargeId!=""){
		submitProtoAjaxWithDivName('drugConsumption','/hms/hms/ipd?method=getItemBatchNo&counter='+inc+'&pvmsNo='+chargeId,'batchDiv'+inc);
	}
}
}


function addRow(){
	
	  var tbl = document.getElementById('consumptionDetails');
	  var lastRow = tbl.rows.length;

	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;

	  
	  var cell0 = row.insertCell(0);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.size = '35';
	  e1.tabIndex="1";
	  e1.name='nomenclature'+iteration;
	  e1.id='nomenclature'+iteration
	  e1.onblur=function(){checkForNomenclature(this.value,iteration)}
	  cell0.appendChild(e1);
	  new Ajax.Autocompleter('nomenclature'+iteration,'ac2update1','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature'+iteration});

	  var e12 = document.createElement('input');
	  e12.type = 'hidden';
	  e12.name='pvmsNo'+iteration;
	  e12.id='pvmsNo'+iteration
	  cell0.appendChild(e12);
	  

	  var cell1 = row.insertCell(1);
	  cell1.id='batchDiv'+(iteration);
	  var e2 = document.createElement('select');
	  e2.name='batchId'+iteration;
	  e2.id='batchId'+iteration;
	  e2.options[0] = new Option('Select', '0');
	  e2.setAttribute('tabindex','1');
	  e2.setAttribute('validate','Batch No,string,no');
	  var e21 = document.createElement('input');
	  e21.type = 'hidden';
	  e21.name='itemId'+iteration;
	  e21.id='itemId'+iteration;
	  cell1.appendChild(e21);
	  cell1.appendChild(e2);
	  
	  var cell2 = row.insertCell(2);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name='expiryDate'+iteration;
	  e3.id='expiryDate'+iteration
	  e3.tabIndex="1";
	  cell2.appendChild(e3);

	  var cell3 = row.insertCell(3);
	   var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name='stockQty'+iteration;
	  e4.id='stockQty'+iteration;
	 // e4.size='9';
	  e4.setAttribute('tabindex','1');
	  cell3.appendChild(e4);

	  var cell4 = row.insertCell(4);
	   var e5 = document.createElement('input');
	  e5.type = 'text';
	  e5.name='consumedQty'+iteration;
	  e5.id='consumedQty'+iteration;
	 // e5.size='9';
	  e5.setAttribute('tabindex','1');
	  cell4.appendChild(e5);

	  var cell5 = row.insertCell(5);
	  var e6 = document.createElement('input');
	  e6.type = 'button';
	  e6.className = 'buttonAdd';
	  e6.name='remarks'+iteration;
	  e6.setAttribute('onClick', 'addRow();'); 
	  e6.setAttribute('tabindex','1');
	  cell5.appendChild(e6);

	  var cell6 = row.insertCell(6);
	  var e7= document.createElement('input');
	  e7.type = 'button';
	  e7.className = 'buttonDel';
	  e7.name='remarks'+iteration;
	  e7.setAttribute('onClick', 'removeRow("consumptionDetails",this);'); 
	  cell6.appendChild(e7);
	  
}

function removeRow(idName,obj)
{
  var tbl = document.getElementById(idName);
  var lastRow = tbl.rows.length;
  if (lastRow > 2){
    var i=obj.parentNode.parentNode.rowIndex;
    tbl.deleteRow(i);
  }
}

function validateRows(){
	var count = document.getElementById('hdb').value;
	var flag = false;
	for(var i=1;i<=count;i++){
		if(document.getElementById('itemId'+i).value != ''){
			flag=true;
			break;
		}

	}
	if(flag==false){
		alert("Please enter value in atleast one row.");
		return false;
		
	}
	return true;
}
</script>