<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * opdInvestigationTemplate.jsp  
 * Purpose of the JSP -  This is for All OpdTemplate Master.
 * @author  shailesh
 * Create Date: 2 april,2009
 * Revision Date:      
 * Revision By: 
 * @version 1.5
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.OpdTemplate"%>
<%@page import="jkt.hms.masters.business.OpdInstructionTreatment"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<!-- <script type="text/javascript" src="/hms/jsp/js/phase2/ddaccordion.js">
/***********************************************
* Accordion Content script- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* Visit http://www.dynamicDrive.com for hundreds of DHTML scripts
* This notice must stay intact for legal use
***********************************************/
</script>-->
<script type="text/javascript" language="javascript"src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/hms.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript"src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/opd.js"></script>
<%
	Map<String,Object> map = new HashMap<String,Object>();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
		
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	 String message="";
	if(map.get("message") != null){
		   message = (String)map.get("message");
		   //out.println(message);
	}
	System.out.println("message==in jsp ==="+message);
	
	int deptId = 0;
	if(session.getAttribute("deptId") != null){
		deptId = (Integer)session.getAttribute("deptId");
	}
	String deptName="";
	if(session.getAttribute("deptName") != null){
		deptName = (String)session.getAttribute("deptName");
	}
	List<MasFrequency> frequencyList= new ArrayList<MasFrequency>();
	if(map.get("masFrequencyList") != null){
	frequencyList=(List)map.get("masFrequencyList");
	
	}
	List<OpdInstructionTreatment>opdInstructionTreatmentList=new ArrayList<OpdInstructionTreatment>();
	if(map.get("opdInstructionTreatmentList")!=null){
		opdInstructionTreatmentList=(List<OpdInstructionTreatment>)map.get("opdInstructionTreatmentList");
	}
%>

<div class="popupbg">

<h4><%=message %></h4>
<div class="titleBg"><h2>Investigation Template</h2></div>
<h4><%=deptName %></h4>
<div class="Clear"></div>
<script type="text/javascript">
	   var icdArray=new Array();
	     var icdArrayForInstruction=new Array();
	   
	</script> 
<script type="text/javascript" language="javascript">
/* function removeRow(idName,countId,obj)
{
  var tbl = document.getElementById(idName);
  var lastRow = tbl.rows.length;
  alert(lastRow);
  if (lastRow > 1){
  //	tbl.deleteRow(lastRow - 1);
    var i=obj.parentNode.parentNode.rowIndex;
    tbl.deleteRow(i);
  }
} */

function removeRow()
{
  var tbl = document.getElementById('grid');
  var lastRow = tbl.rows.length;
  if (lastRow > 2) tbl.deleteRow(lastRow - 1);
}
function submitFormForOPD(formName,action,extraFunction,extraFunction2,extraFunction3){
errorMsg="";
	ob1 = true;
	ob2 = true;
	ob3 = true;
	obj = eval('document.'+formName)
	if(eval("window."+extraFunction))
    	ob1 =  eval(extraFunction+"()")
        
		if(eval("window."+extraFunction2))
        	ob2 = eval(extraFunction2+"()")
        
		if(eval("window."+extraFunction3))
        	ob3 = eval(extraFunction3+"()")        	
    	
		if(validateFields(formName)== true & ob1 & ob2 &ob3){
        if(formName=="admissionByHin"){
		
		obj.Submit11.disabled=true
		}
		
		
        	obj.action = action;
			obj.submit();
    		return true;
		}else{
    	   	
			if(errorMsg != ""){
				alert(errorMsg);
	       		return false;	
	       	}
	       	return true;
    	}
}


function submitWindow()
{
var code=document.getElementById('code').value;
var flag =true;
if(validateMetaCharacters(code)){
flag = submitFormForOPD('investigationTemplate','opd?method=addInvestigationTemplate&code='+code+'');
}
/* alert("flag="+flag);
if(flag == true){
 /* if (window.opener.progressWindow)
	 {
       
    	window.opener.progressWindow.close()
  	 } 
  	 
 setTimeout("window.close()"); 
} */
}

function closeWindow()
{
  window.close();
}
function addRow(){

  var tbl = document.getElementById('grid');
  var lastRow = tbl.rows.length;
 
  // if there's no header row in the table, then iteration = lastRow + 1
  var iteration = lastRow;
  var row = tbl.insertRow(lastRow);
  var hdb = document.getElementById('hdb');
  hdb.value=iteration


	  //var cellRightSel = row.insertCell(0);

  
  
  
  var cellRight1 = row.insertCell(0);
  var e1 = document.createElement('input');
  e1.type = 'text';
 // e0.innerHTML = iteration+':'
  e1.onblur=function(){
  						
                      // alert('event added--'+e0.value+"iteration--"+iteration);
                       var val=e1.value
                       if(val != "")
						{
				    	
					    var index1 = val.lastIndexOf("[");
					    var indexForchargeCodeCode=index1;
					    var index2 = val.lastIndexOf("]");
					    index1++;
					    var chargeCodeCode = val.substring(index1,index2);
					    var indexForchargeCodeCode=indexForchargeCodeCode--;
					    var chargeCodeName=val.substring(0,indexForchargeCodeCode);
					    	//alert("chargeCodeName---"+chargeCodeName)
					   	 if(chargeCodeCode =="")
					    {
					    		document.getElementById('chargeCodeCode'+iteration).value="";
   								document.getElementById('chargeCodeName'+iteration).value="";
   								//document.getElementById('qty'+iteration).value=1
					     return;
					    }
					    else
      						document.getElementById('chargeCodeCode'+iteration).value=chargeCodeCode
      						//document.getElementById('qty'+iteration).value=1
      						
					   }
  					  };
  e1.name = 'chargeCodeName' + iteration;
  e1.id = 'chargeCodeName' + iteration;
  
  e1.size = '45';
  cellRight1.appendChild(e1);
  e1.focus();
 
  new Ajax.Autocompleter('chargeCodeName'+iteration,'ac2update1','opd?method=getInvestigationListForAutoComplete',{callback: function(element, entry) { return entry + '&labradiologyCheck=' + document.getElementById('investigationCategory').value;},parameters:'requiredField=chargeCodeName'+iteration});
  var sel = document.createElement('input');
  sel.type = 'hidden';
  sel.name='chargeCodeCode'+iteration;
  sel.id='chargeCodeCode'+iteration
  sel.size = '20'
  cellRight1.appendChild(sel);
   //alert("name--"+e0.name)
	  
/*   var cellRight2 = row.insertCell(1);
var e2 = document.createElement('input');
e2.type = 'text';
e2.name='qty'+iteration;
e2.id='qty'+iteration
e2.size='20'
e2.setAttribute('maxlength', 3);  
cellRight2.appendChild(e2); 

var cellRight3 = row.insertCell(2);
var e3 = document.createElement('input');
e3.type = 'text';
e3.name="clinical"+iteration;
e3.id='clinical'+iteration;
e3.setAttribute('maxlength', 45);
e3.size='20'
cellRight3.appendChild(e3);*/ 

var cellRight2 = row.insertCell(1);
var e4 = document.createElement('input');
e4.type = 'button';
e4.value="Add";
e4.className = 'button';
e4.onclick = function(){addRow();};
 
cellRight2.appendChild(e4); 

var cellRight3 = row.insertCell(2);
var e5 = document.createElement('input');
e5.type = 'button';
e5.value="Delete";
e5.className = 'button';
e5.onclick = function(){removeRow();};
cellRight3.appendChild(e5); 

}
function populateChargeCode(val){
if(validateMetaCharacters(val)){
if(val != "")
{
    var index1 = val.lastIndexOf("[");
    var indexForChargeCode=index1;
    var index2 = val.lastIndexOf("]");
    index1++;
    var ChargeCode = val.substring(index1,index2);
    var indexForChargeCode=indexForChargeCode--;
     

if(ChargeCode == "")
{
	document.getElementById('chargeCodeName1').value="";
document.getElementById('chargeCodeCode1').value="";
return;
}
else
  document.getElementById('chargeCodeCode1').value=ChargeCode
}
}	
}

function createTemplateCode(){
var templateName=document.getElementById("<%= SEARCH_NAME %>").value;
if(validateMetaCharacters(templateName)){
if(templateName.length>5){

var templateCode=templateName.substring(0,5);
document.investigationTemplate.code.value=templateCode;
}
else{
document.investigationTemplate.code.value=templateName;
}
}
}
	</script>


<form name="investigationTemplate" method="post" action="">

<input	type="hidden" name="<%= POJO_NAME %>" value="OpdTemplate" />
<input	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="TemplateName" />
<input type="hidden" name="title" value="OpdTemplate" />
<input type="hidden" name="<%=JSP_NAME %>" value="opdTemplate" />
<input	type="hidden" name="pojoPropertyCode" value="TemplateCode"/>

<div class="Block">
<!--  <label>Template Code </label>-->

<input type="hidden" name="code"	id="code" value="" disabled="true" readonly="readonly"	validate="Template Code,metachar,yes" MAXLENGTH="8" tabindex=1 />

<label><span>*</span> Template Name</label>

<input type="text" name="<%= SEARCH_NAME %>"	id="<%= SEARCH_NAME%>" value="" onblur="createTemplateCode();"	validate="Template Name,metachar,yes" MAXLENGTH="30" tabindex=1 />

</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div id="testDiv">
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="grid">
	<tr>
	  	  <td colspan="3">
	  	  <div>
				<input type="radio" onchange="" checked="checked" name="labradiologyCheck" class="radioCheckCol2" value="Lab">LAB
				
				<input type="radio" onchange="" name="labradiologyCheck" class="radioCheckCol2" value="Radio">Radiology
					 <input type="hidden" id="investigationCategory" name="investigationCategory" value="Lab">
				<div class="clear"></div>
			</div>
	      <!-- 	<div>
				<input type="radio" value="Lab" class="radioCheckCol2"
					name="labradiologyCheck" checked="checked" onchange=""  /><div class="labRadiologyDivfixed">LAB	</div>	
				<input type="radio" value="Radio" class="radioCheckCol2"
					name="labradiologyCheck" onchange="" /><div class="labRadiologyDivfixed">Radiology</div>
					 <input
					type="hidden" name="investigationCategory"
					id="investigationCategory" />
				<div class="clear"></div>
			</div> -->
	  </td>
	</tr>
	<tr>

		<!--  <th scope="col">Test Code</th>-->
		<th>Investigation</th>
		<!--  <th scope="col">Quantity</th>-->
		<!--  <th scope="col">Clinical Notes</th>-->
		<th>Add</th>
		<th>Delete</th>

	</tr>
	<tr>
		<td> <input type="hidden" size="40" value="0" class="smcaption"	name="chargeCodeId1" id="chargeCodeId1" />
			 <input type="hidden"	 name="chargeCodeCode1" id="chargeCodeCode1"
			validate="Test Code And Description,metachar,yes" readonly />
		<input type="text" value=""	validate=" Test Description,string,no" size="45" tabindex="1"
			id="chargeCodeName1"  name="chargeCodeName1"
			onblur="populateChargeCode(this.value);" /> 
		<div id="ac2update1"
			style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			  //new Ajax.Autocompleter('chargeCodeName1','ac2update1','opdMaster?method=getChargeCodeList',{parameters:'requiredField=chargeCodeName1'});
			  
			  new Ajax.Autocompleter('chargeCodeName1','ac2update1','opd?method=getInvestigationListForAutoComplete',{
				  callback: function(element, entry) {
			            return entry + '&labradiologyCheck=' + document.getElementById('investigationCategory').value;
			        },
				  parameters:'requiredField=chargeCodeName1'});
			  
			</script>
</td>
		<%-- <td><input type="text" id="qty1" name="qty1" value=""
			validate="Qty,num,yes" class="textbox_size20" MAXLENGTH="3"
			tabindex=1 /></td>
		<td><input type="text" id="clinical1" name="clinical1" value="" validate="Clinical Notes,string,no"	MAXLENGTH="45" tabindex=1 />
		
		</td>--%>
		
		<td><input type="hidden" name="hdb" value="1" id="hdb" validate="hdb,metachar,yes" />
		<input	type="Button" tabindex="1" class="button" onclick="addRow();" value="Add"  />
</td>
<td>
<input type="button" name="delete" tabindex="1" class="button"  value="Delete" onclick="removeRow();" />

</td>
	</tr>
</table>
<div class="Clear"></div>
</div>


<div class="Clear"></div>
<div class="division"></div>

<input type="button" name="add" id="addbutton" value="Save"	class="button" onClick="submitWindow();" accesskey="a" tabindex=1 />
<input	type="reset" name="Reset" id="reset" value="Reset" class="button"	onclick="resetCheck();" accesskey="r" />
<input	type="reset" name="Reset" id="reset" value="Close" class="button"	onclick="closeWindow();" accesskey="r" />

 <%-- <input type="button" name="close" id="addbutton" value="close" class="button"	onClick="closeWindow();" accesskey="a" tabindex=1 />--%>
<div class="Clear"></div>
<div class="division"></div>
<div class="bottom">

<label>Changed By</label>
<label class="value"><%=userName %></label>
<label>Changed Date</label>
<label class="value"><%=date%></label>
<label>Changed Time</label>
<label class="value"><%=time%></label>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
<div class="Clear"></div>
<div id="edited"></div>

</div>
</form>

</div>

