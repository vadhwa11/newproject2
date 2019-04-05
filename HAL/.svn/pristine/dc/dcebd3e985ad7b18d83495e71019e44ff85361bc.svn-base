<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : DMARegister.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 18.03.2011    Name: Ritu
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasAircraftType"%>
<%@page import="jkt.hms.masters.business.MasStation"%>

<%@page import="jkt.hms.masters.business.MasLocation"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.StoreFyDocumentNo"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
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
<form name="dmaRegister" action="" method="post">
<%
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");  
		String time = (String)utilMap.get("currentTime");
 
 		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
		if(map.get("frequencyList") != null){
			frequencyList= (List<MasFrequency>)map.get("frequencyList");
		}
		String message = "";
		if(map.get("message") != null){
			message = (String)map.get("message");
		}
	
		 StoreFyDocumentNo storeFyDocumentNo=(StoreFyDocumentNo)map.get("storeFyDocumentNo");
		
		String opdIssuenoIncremented=(String)map.get("opdIssuenoIncremented");
	
	%>
	<h4><%=message %></h4>
<div class="titleBg"><h2>DMA Register</h2></div>
<div class="Clear"></div>

<div class="Clear"></div>
<div class="Block">
<label><span>*</span> Service No.</label> 
<input type="text" name="<%= SERVICE_NO %>" value="" onblur="submitProtoAjax('dmaRegister','/hms/hms/registration?method=getHinNoForDMA');" validate="Service No,stirng,yes">
<label><span>*</span>HIN No</label> 
<div id="testDiv">
<input type="text" name="<%= HIN_NO %>" value="" />
</div>
<input type="hidden" name="visitId" id="visitId" value=""/>
<label>Service Type</label>
<input type="text" id="servType" name="<%= SERVICE_TYPE_NAME %>" value="" readonly="readonly">

<div class="Clear"></div>
<label>Service Status</label>
<input type="text" id="servStatus" name="" value="" readonly="readonly">
 
 
<label>Rank</label> 
<input type="text" id="rank" name="" value="" readonly="readonly">

<label>Patient Name</label> 
<input type="text" id="patientName" name="" value="" readonly="readonly">

 <div class="Clear"></div>

<label>Sex</label> 
<input type="text" id="sex" name="" value="" readonly="readonly">

<label>DOB</label> 
<input type="text" id="dob" name="" value="" readonly="readonly">

<label>Age</label> 
<input type="text" id="age" name="" value="" readonly="readonly">

<div class="Clear"></div>
<label>Marital Status</label> 
<input type="text" id="mrstatus" name="" value="" readonly="readonly">

<label>Relation</label> 
<input type="text" id="relation" name="" value="" readonly="readonly">

<label>Blood Group</label> 
<input type="text" id="bldGrp" name="" value="" readonly="readonly">

<div class="Clear"></div>

<label>Contact No</label> 
<input type="text" id="phoneNo" name="" value="" readonly="readonly">

<label>Command</label> 
<input type="text" id="command" name="" value="" readonly="readonly">

<label>Station</label> 
<input type="text" id="station" name="" value="" readonly="readonly">

<div class="Clear"></div>

<label>Unit</label> 
<input type="text" id="unit" name="" value="" readonly="readonly">

<label>Trade/Branch</label> 
<input type="text" id="trade" name="" value="" readonly="readonly">

<label>Complaints</label>
<textarea name="<%= COMPLAINT_DESC %>" rows="" cols=""></textarea>
<div class="Clear"></div>
</div>
<input type="hidden" id="opdIssueno" name="opdIssueno" value="<%= opdIssuenoIncremented%>" />	
<input type="hidden" id="storeFyDocumentNoId" name="storeFyDocumentNoId" value="<%= storeFyDocumentNo.getId()%>"  />

<div class="Clear"></div>
<div class="Clear"></div>
<script type="text/javascript">
var icdArray=new Array();
</script>
<div class="cmntable">
	<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">

	<tr>
		<th scope="col">Nomenclature</th>
		<th scope="col">PVMS No.</th>
		<th scope="col">Batch No</th>
		<th scope="col">Dosage</th>
		<th scope="col">Frequency</th>
		<th scope="col">Issue Qty</th>
		<th scope="col">Remarks</th>
		<th>Add</th>
		<th>Delete</th>
	</tr>
	<tr>
		<td>
	    <input type="text" value="" tabindex="1" id="nomenclature1" size="50"  name="nomenclature1" onblur="if(this.value!=''){populatePVMS(this.value,'1');checkForNomenclature(this.value,1);}"  />
	        <div id="ac2update1" style=" display:none; " class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			
			  new Ajax.Autocompleter('nomenclature1','ac2update1','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature1'});
			</script>
		</td>
		<td><input type="text" name="pvmsNo1" tabindex="1" id="pvmsNo1"	size="10" readonly="readonly" /></td>
			
		<td id="batchDiv1">
		<select name="batchId1" id="batchId1">
		<option value="">Select</option>
		</select>
		<input type="hidden" name="<%= ITEM_ID %>1" value="">
		</td>
		<td><input type="text" name="dosage1" tabindex="1" id="dosage1"	size="5" maxlength="5" /></td>
		<td><select name="frequency1" id="frequency1" tabindex="1"onclick="fillValueFromFrequency(this.value,'1');">
			<option value="0">Select</option>
			<%

		      for(MasFrequency masFrequency : frequencyList){
		       int id = masFrequency.getId();
		       String name = masFrequency.getFrequencyName();
          %>
			<option value="<%=id %>"><%=name%></option>
			<%} %>
		</select> 
		<%
	    		MasFrequency  masFrequency = new MasFrequency();

			     for (int i = 0; i < frequencyList.size(); i++) {
			        	 masFrequency = (MasFrequency) frequencyList.get(i);
     			 %> <script>

	          icdArray[<%=i%>]= new Array();
	          icdArray[<%=i%>][0] = "<%=masFrequency.getId()%>";
	          icdArray[<%=i%>][1] = "<%=masFrequency.getFrequencyName()%>";
            </script> <% }%>
		</td>

		<td><input type="text" name="issueQty1" tabindex="1"id="issueQty1" size="10"	maxlength="3" validate="No Of Days,num,no" /></td>

		
		<td><input type="text" name="remarks1" tabindex="1" id="remarks1" size="15" maxlength="40"/></td>
			<td>
			<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" /> 
			</td>
			<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow();" tabindex="1" />
			</td>
		
	</tr>
</table>
	<input type="hidden" name="hdb" value="1" id="hdb" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<input type="button" name="Submit11" id="addbutton"
	onclick="submitForm('dmaRegister','/hms/hms/registration?method=saveDmaRegisterDetails');"
	value="Submit" class="button" accesskey="a" />
<input type="reset" name ="Reset" value ="Reset" class="button" tabindex="1" accesskey="r" />

<div class="Clear"></div>
<div class="division"></div>
 <div class="bottom">
<label>Changed By:</label>   
<label class="value"><%=userName%></label>
        
<label>Changed Date:</label>   
<label class="value"><%=currentDate%></label>
 
<label>Changed Time:</label>   
<label class="value"><%=time%></label>
 
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=LAST_CHANGED_DATE %>" value="<%=currentDate%>"  />
<input type="hidden" name="<%=LAST_CHANGED_TIME %>"  value="<%=time%>" />
<div class="Clear"></div>

</div>
</form>
<script>

function populatePVMS(val,inc){
	if(val != "")
	{
	    var index1 = val.lastIndexOf("[");
	    var indexForBrandName=index1;
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvmsNo = val.substring(index1,index2);
	    
	    var indexForBrandName=indexForBrandName--;
	    var brandName=val.substring(0,indexForBrandName);



		  if(pvmsNo == "")
		  {
		   	document.getElementById('nomenclature'+inc).value="";
		    document.getElementById('pvmsNo'+inc).value="";
		   return;
		   }
		   else
		      document.getElementById('pvmsNo'+inc).value=pvmsNo
		
		
		 }
}



function addRow(){
	
	  var tbl = document.getElementById('grid');
	  var lastRow = tbl.rows.length;

	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;

	  
	  var cell1 = row.insertCell(0);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.size = '50';
	  e1.name='nomenclature'+iteration;
	  e1.id='nomenclature'+iteration
	  e1.onblur=function(){if(this.value!=''){populatePVMS(this.value,iteration);checkForNomenclature(this.value,iteration)	}}
	  cell1.appendChild(e1);
	  new Ajax.Autocompleter('nomenclature'+iteration,'ac2update1','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature'+iteration});

	  var cell11 = row.insertCell(1);
	  var e21 = document.createElement('input');
	  e21.type = 'text';
	  e21.name='pvmsNo'+iteration;
	  e21.id='pvmsNo'+iteration
	  e21.size = '10';
	  e21.setAttribute('tabindex','1');
	  cell11.appendChild(e21);

	  var cell5 = row.insertCell(2);
	  cell5.id='batchDiv'+(iteration);
	  var e5 = document.createElement('select');
	  e5.name='batchNo'+iteration;
	  e5.id='batchNo'+iteration;
	  e5.options[0] = new Option('Select', '0');
	  e5.setAttribute('tabindex','1');
	  e5.setAttribute('validate','Batch No,string,no');
	  cell5.appendChild(e5);
	  
	  var cell3 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name='dosage'+iteration;
	  e3.id='dosage'+iteration
	  e3.size='5';
	  e3.setAttribute('maxlength', 5); 
	  e3.setAttribute('tabindex','1');
	  cell3.appendChild(e3);

	  var cell4 = row.insertCell(4);
	  var e4 = document.createElement('Select');

	  e4.name='frequency'+iteration;
	  e4.id='frequency'+iteration;
	  e4.classname='smalllabel';
	  e4.setAttribute('tabindex','1');
	  e4.options[0] = new Option('Select', '0');
	  e4.onclick=function(){
	  					var val=e5.value
	  					var freq=e4.value
	  					document.getElementById('issueQty'+iteration).value=val*freq
	  		}
	  for(var i = 0;i<icdArray.length;i++ ){
	      e4.options[i+1] = new Option(icdArray[i][1],icdArray[i][0]);
	      }
	   cell4.appendChild(e4);



	  var cell6 = row.insertCell(5);
	  var e51 = document.createElement('input');
	  e51.type = 'text';
	  e51.name='issueQty'+iteration;
	  e51.id='issueQty'+iteration;
	  e51.size='10';
	  e51.setAttribute('tabindex','1');
	  cell6.appendChild(e51);

	  var cell7 = row.insertCell(6);
	  var e6 = document.createElement('input');
	  e6.type = 'text';
	  e6.name='remarks'+iteration;
	  e6.id='remarks'+iteration
	  e6.size='15';
	  e6.setAttribute('maxlength', 5); 
	  e6.setAttribute('tabindex','1');
	  cell7.appendChild(e6);
	  
	  var cellRight8 = row.insertCell(7);
	  var e8 = document.createElement('input');
	  e8.type = 'button';
	  e8.className = 'buttonAdd';
	  e8.name='remarks'+iteration;
	  e8.setAttribute('onClick', 'addRow();'); 
	  e8.setAttribute('tabindex','1');
	  cellRight8.appendChild(e8);

	  var cellRight9 = row.insertCell(8);
	  var e9 = document.createElement('input');
	  e9.type = 'button';
	  e9.className = 'buttonDel';
	  e9.name='remarks'+iteration;
	  e9.setAttribute('onClick', 'removeRow();'); 
	  e9.setAttribute('tabindex','1');
	  cellRight9.appendChild(e9);
	  
}

function removeRow()
{
  var tbl = document.getElementById('grid');
  var lastRow = tbl.rows.length;
  if (lastRow > 2){
  	tbl.deleteRow(lastRow - 1);
  	var tbl = document.getElementById('grid');
  	var lastRow = tbl.rows.length;
	  // if there's no header row in the table, then iteration = lastRow + 1
 	var iteration = lastRow - 1;
  	var hdb = document.getElementById('hdb');
  	hdb.value=iteration
  }
}

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
	     // 	document.getElementById('clinicalNotes'+inc).value="";
	 	 // 	document.getElementById('qty'+inc).value="";
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
		submitProtoAjaxWithDivName('dmaRegister','/hms/hms/registration?method=getItemBatch&counter='+inc,'batchDiv'+inc);
	}
		
}
}
function  fillValueFromFrequency(value,inc){

	  //alert(value)
	  var noOfDays=document.getElementById('noOfDays'+inc).value
	  document.getElementById('issueQty'+inc).value=noOfDays*value
	 }

function  fillValue(value,inc){

	  //alert(value)
	  var freq=document.getElementById('frequency'+inc).value
	  document.getElementById('issueQty'+inc).value=freq*value
	 }

var batchArray = new Array();
function setOtherDetails(val,inc){
	for(i=0;i<batchArray.length;i++){
		if(batchArray[i][0]==val){
			document.getElementById('expDate'+inc).value=batchArray[i][1];
			document.getElementById('batchNo'+inc).value=batchArray[i][2];			
		}
	}
	
}

</script>