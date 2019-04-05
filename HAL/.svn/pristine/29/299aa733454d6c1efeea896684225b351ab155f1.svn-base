<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.KitIssueMasterTemplateM"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>

<%@page import="jkt.hms.util.Box"%><link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>

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

<form name="showKitIssue" action="" method="post">
<%
Map map = new HashMap();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
 String userName = "";
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");  
String currentTime = (String)utilMap.get("currentTime");

 if(session.getAttribute("userName") != null){
	 userName = (String)session.getAttribute("userName");
 }
 String message = "";
 if(map.get("message")!=null){
	 message = (String)map.get("message");
 }
List<KitIssueMasterTemplateM> kitIssueList = new ArrayList<KitIssueMasterTemplateM>();
if(map.get("kitIssueList")!=null){
	kitIssueList = (List<KitIssueMasterTemplateM>)map.get("kitIssueList");
}
Box box = HMSUtil.getBox(request);	

%>

<h4><%=message %></h4>
<div class="Clear"></div>
<div class="titleBg">
<h2>Kit Issue Master</h2></div>
<div class="Clear"></div>

<div id="testDiv">

<div class="Clear"></div>
<div class="Block">
<label >Template Name <span>*</span></label><input type="text" name="templateName" value="" id="templateName" validate="Template,string,yes" maxlength="30" />
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<div id="pageNavPosition"></div>
<div class="Clear"></div>

<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
	<tr>
	
		<th width="15%">Nomenclature</th>
		<th width="3%">Auth. Qty</th>
		<th>Add</th>
		<th>Delete</th>
	</tr>
	<tr>
	
		<td><input type="text" value="" tabindex="1" id="nomenclature1"		size="100" name="nomenclature1"
			onblur="if(this.value!=''){checkForNomenclature(this.value,1);}" />
		<div id="ac2update1" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			
		//	  new Ajax.Autocompleter('nomenclature1','ac2update1','inPatientMaster?method=getItemListForAutoComplete',{parameters:'requiredField=nomenclature1'});
			</script>
			
			</td>
			<td id="batchDiv1" style="display: none;">
		<input type="hidden" id="itemId1" name="<%= ITEM_ID %>1" value="">
		</td>	
		<td> <input type="text" value="" tabindex="1" id="authQuantity1" size="60"	name="authQuantity1"></td>
		<td><input name="Button" type="button" class="buttonAdd" value=""
			onclick="addRow();" tabindex="1" /></td>
		<td><input type="button" name="delete" value="" class="buttonDel"
			onclick="removeRow('grid','hdb',this);" tabindex="1" /></td>
	</tr>
</table>
<input type="hidden" name="hdb" value="1" id="hdb" />

<div class="clear"></div>
<div class="division"></div>
<input type="button" name="Submit1" value="Submit" class="button"
	tabindex="1" onclick="submitForm('showKitIssue','/hms/hms/inPatientMaster?method=submitKitIssueMasterDetails','validateGridRows')" />
<input type="reset" name="Reset" value="Reset" class="button"
	tabindex="1" onClick="submitFormForButton('showKitIssue','/hms/hms/inPatientMaster?method=showKitIssueJsp')" accesskey="r" />

</div>
<div class="clear"></div>
<div class="division"></div>
<%
	if(kitIssueList.size() > 0){
%>
<div id="reg">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Sl.No.</th>
		<th scope="col">Template</th>
	</tr>
	<%	int i=1;
		for(KitIssueMasterTemplateM kitIssueMasterTemplateM : kitIssueList){
	%>
<tr  onclick="submitProtoAjax('showKitIssue','/hms/hms/inPatientMaster?method=showKitIssueTemplateDetails&kitIssueMasterId=<%=kitIssueMasterTemplateM.getId() %>');">
	<td><%=i %></td>
	<td><%= kitIssueMasterTemplateM.getTemplateName()%></td>

</tr>
<%i++;} %>

</table>
</div>
<%} %>
<input type="hidden" name="flag" value="<%=box.getString("flag") %>">
<input type="hidden" name="inpatientId" value="<%=box.getString("inpatientId") %>">
<div class="Clear"></div>
<div class="bottom"> <input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input type="hidden"	name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> 
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=currentTime%>" /></div>
<div class="clear"></div>
</form>
<script>
function setIdForDelete(kitId){
if(document.getElementById('deleteKitId').value!=''){	
	document.getElementById('deleteKitId').value=document.getElementById('deleteKitId').value+","+kitId;
}else{
	document.getElementById('deleteKitId').value=kitId
}
}
 function validateGridRows(){
	var count = document.getElementById('hdb').value;
	var flag = "";
	if(count > 0){
		for(var i=1;i<=count;i++){
			if(document.getElementById('nomenclature'+i) && document.getElementById('nomenclature'+i).value != ''){
				flag = "filled";
				break;
			}
		}
		if(flag==''){
			alert("Please fill a row.");
			return false;
		}
	}
	return true;
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
	  e1.type = 'radio';
	  e1.tabIndex="1";
	  e1.name='radio'+iteration;
	  e1.id='radio'+iteration
	  e1.onblur=function(){getRadioId(this.value,iteration)};
	  cell1.style.display = 'none';
	  cell1.appendChild(e1);
	 
	  var cell2 = row.insertCell(1);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.size = '100';
	  e2.tabIndex="1";
	  e2.name='nomenclature'+iteration;
	  e2.id='nomenclature'+iteration
	  e2.onblur=function(){if(this.value!=''){checkForNomenclature(this.value,iteration);}}
	  cell2.appendChild(e2);
	//  new Ajax.Autocompleter('nomenclature'+iteration,'ac2update1','inPatientMaster?method=getItemListForAutoComplete',{parameters:'requiredField=nomenclature'+iteration});

	  var cell3 = row.insertCell(2);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.size = '60';
	  e3.tabIndex="1";
	  e3.name='authQuantity'+iteration;
	  e3.id='authQuantity'+iteration
	  e3.setAttribute('tabindex','1');
	  cell3.appendChild(e3);

	  var cellRight4 = row.insertCell(3);
	  var e4 = document.createElement('input');
	  e4.type = 'button';
	  e4.className = 'buttonAdd';
	  e4.name='Button'+iteration;
	  e4.setAttribute('onClick', 'addRow();'); 
	  e4.setAttribute('tabindex','1');
	  cellRight4.appendChild(e4);

	  var cellRight5 = row.insertCell(4);
	  var e5 = document.createElement('input');
	  e5.type = 'button';
	  e5.className = 'buttonDel';
	  e5.name='delete'+iteration;
	  e5.setAttribute('onClick', 'removeRow("grid","hdb",this);'); 
	  e5.setAttribute('tabindex','1');
	  cellRight5.appendChild(e5);

	  var cell6 = row.insertCell(5);
	  cell6.id='batchDiv'+(iteration);
	  cell6.style.display="none"
	  var e51 = document.createElement('input');
	  e51.type = 'hidden';
	  e51.name='itemId'+iteration;
	  e51.id='itemId'+iteration;
	  cell6.appendChild(e51);
}

function removeRow(idName,countId,obj)
{
  var tbl = document.getElementById(idName);
  var lastRow = tbl.rows.length;
  if (lastRow > 2){
	 	   
	    var i=obj.parentNode.parentNode.rowIndex;
	    tbl.deleteRow(i);
  }
}

function getRadioId(val,inc){
	var index1 = val.lastIndexOf("[");
	var index2 = val.lastIndexOf("]");
	index1++;
	var radioId = val.substring(index1,index2);
	document.getElementById('radioId'+inc).value = radioId;
	
}

function checkForNomenclature(val,inc)
{
    
	if(val != ""){
		
		/*var index1 = val.lastIndexOf("[");
		var index2 = val.lastIndexOf("]");
		index1++;
		var pvms = val.substring(index1,index2);

		if(pvms == "" ) {
	      	document.getElementById('nomenclature'+inc).value="";
	       	return;
		}*/

		for(i=1;i<inc;i++){
            
			if(inc != 1){
				 
 				if(document.getElementById('nomenclature'+i).value==val) {
					alert("Nomenclature already selected...!")
					document.getElementById('nomenclature'+inc).value=""
					var e=eval(document.getElementById('nomenclature'+inc));
					e.focus();
					return false;
				}
			}
		}
		
	/*if(pvms!=""){
		submitProtoAjaxWithDivName('showKitIssue','/hms/hms/registration?method=getItemId&counter='+inc+'&pvmsNo='+pvms,'batchDiv'+inc);
	}*/
}
}

</script>



