

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.OpdTemplate"%>
<%@page import="jkt.hms.masters.business.OpdInstructionTreatment"%>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/common.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css">
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>

<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<%--For AutoComplete Through Ajax--%>

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/opd.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<!-- <script type="text/javascript" src="/hms/jsp/js/phase2/ddaccordion.js">
/***********************************************
* Accordion Content script- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* Visit http://www.dynamicDrive.com for hundreds of DHTML scripts
* This notice must stay intact for legal use
***********************************************/
</script>-->

<script type="text/javascript">
animatedcollapse.addDiv('slide0', 'fade=0,speed=400,group=pets')
animatedcollapse.addDiv('slide1', 'fade=0,speed=400,group=pets')
animatedcollapse.addDiv('slide2', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide3', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.init()

</script>

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
String deptName="";
int deptId = 0;
if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
}
if(map.get("message") != null){
	   String message = (String)map.get("message");
	   out.println(message);
	  }
if(session.getAttribute("deptId") != null){
	deptId = (Integer)session.getAttribute("deptId");
}

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

<div class="titleBg"><h2>Opd Template</h2></div>
<div class="clear"></div>
<h4><%=deptName %></h4>
<div class="Clear"></div>
<script type="text/javascript">
	   var icdArray=new Array();
	     var icdArrayForInstruction=new Array();
	     var itemClassCodeArray = new Array();
	</script> 
	
	<script type="text/javascript" language="javascript">
	
	function getFrequencyValue(feqValue,inc){
		var feqQty;
	<%
	if(frequencyList.size()>0){	
		for(MasFrequency masFrequency :frequencyList){
	%>
	 if(feqValue == '<%=masFrequency.getId()%>'){
		 feqQty = '<%=masFrequency.getFeq()%>'
		
	  }

	<%}
	}%>
	 document.getElementById('frequencyValue'+inc).value = feqQty;
	}
	
	 function  fillValueFromFrequency(value,inc){
	   	  var dosage = document.getElementById('dosage'+inc).value
		  var noOfDays=document.getElementById('noOfDays'+inc).value
		  var freq=document.getElementById('frequencyValue'+inc).value
		  document.getElementById('total'+inc).value=noOfDays*freq*dosage
		  var dispenseQty = document.getElementById('actualDispensingQty'+inc).value;
	   	  var sosQty = document.getElementById('sosQty'+inc).value;
		  var total = freq*noOfDays*dosage;
		  var finalQty;
		  if(document.getElementById('frequency'+inc).value != 13 ){
		  if(document.getElementById('actualDispensingQty'+inc).value != 0){
			  var totalQty = (parseFloat(total)/parseFloat(dispenseQty)).toFixed(2)
			  if(totalQty != '0.00'){
				  finalQty = Math.ceil(totalQty);
			  }
			  document.getElementById('total'+inc).value=finalQty;
		
			 }else{
				 
				  document.getElementById('total'+inc).value=noOfDays*freq*dosage
			  }
		 // document.getElementById('noOfDays'+inc).readOnly = false;
		 // document.getElementById('sosQty'+inc).readOnly = true;
		  }else{
			  if(document.getElementById('actualDispensingQty'+inc).value != 0){
				  var totalQty = (parseFloat(freq*sosQty*dosage)/parseFloat(dispenseQty)).toFixed(2)
				  if(totalQty != '0.00'){
					  finalQty = Math.ceil(totalQty);
				  }
				  document.getElementById('total'+inc).value=finalQty;
			
				 }else{
					  document.getElementById('total'+inc).value=sosQty*freq*dosage
				  }
			//  alert(document.getElementById('noOfDays'+inc).readOnly);
			 // document.getElementById('noOfDays'+inc).readOnly = true;
			 // document.getElementById('sosQty'+inc).readOnly = false;
		  }
		 }
	
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
		var code=document.getElementById("code").value;
		var flag = true;
		flag = submitFormForOPD('prescriptionTemplate','opd?method=addPrescriptionTemplate&<%=CODE%>='+code+'');
		//alert("flag="+flag);
		// if(flag == true)
		//window.close();
		// if (window.opener.progressWindow)
		//	 {
		 //   	window.opener.progressWindow.close()
		//  	 } 
		//  window.close();
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
	 
		  var cellRight0 = row.insertCell(0);
		  var e0 = document.createElement('input');
		  e0.type = 'text';
		 // e0.innerHTML = iteration+':'
		  e0.onblur=function(){
		                       var val=e0.value
		                       if(val != "")
								{
						    	
							    var index1 = val.lastIndexOf("[");
							    var indexForPvms=index1;
							    var index2 = val.lastIndexOf("]");
							    index1++;
							    var pvmsNo = val.substring(index1,index2);
							    var indexForPvms=indexForPvms--;
							    var nomenclature=val.substring(0,indexForPvms);
							   	 if(pvmsNo =="")
							    {
							    		document.getElementById('nomenclature'+iteration).value="";
		   								document.getElementById('pvmsNo'+iteration).value="";
							     return;
							    }
							    else
		      						document.getElementById('pvmsNo'+iteration).value=pvmsNo
		      						
		      						
		      						populatePVMS(this.value,iteration);displayAu(this.value,iteration,'0');checkForPurchase(this.value,iteration);
		      						
		      						
		      						
							   }
		  					  };
		  e0.name = 'nomenclature' + iteration;
		  e0.id = 'nomenclature' + iteration;
		
		  e0.size = '43';
		  e0.setAttribute('validate','Nomenclature,String,yes');
		  cellRight0.appendChild(e0);
		  
			var e01 = document.createElement('input');
			  e01.type = 'hidden';
			  e01.name = 'itemId' + iteration;
			  e01.id = 'itemId' + iteration;
			  e0.focus();
			  cellRight0.appendChild(e01);
			  
		  new Ajax.Autocompleter('nomenclature'+iteration,'ac2update1','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature'+iteration});
		  
		  
		  var cellRightSel = row.insertCell(1);
		  var sel = document.createElement('input');
		  sel.type = 'text';
		  sel.name='pvmsNo'+iteration;
		  sel.id='pvmsNo'+iteration
		  sel.size = '10'
		  sel.setAttribute('validate','Material Code,String,yes');
		  cellRightSel.appendChild(sel);
		 
		  var e15 = document.createElement('input');
		  e15.type = 'hidden';
		  e15.name='highValueMedicine'+iteration;
		  e15.id='highValueMedicine'+iteration
		  e15.size='1';
		  e15.setAttribute('tabindex','1');
		  cellRightSel.appendChild(e15);
		  
		  
		  var e016 = document.createElement('input');
		  e016.type = 'hidden';
		  e016.name='itemClassCode'+iteration;
		  e016.id='itemClassCode'+iteration
		  e016.size='6';
		  e016.setAttribute('tabindex','1');
		  cellRightSel.appendChild(e016);
		  
		  var cellRight2 = row.insertCell(2);
		  var e2 = document.createElement('input');
		  e2.type = 'text';
		  e2.name='dosage'+iteration;
		  e2.id='dosage'+iteration
		  e2.size='5'
	      e2.setAttribute('maxlength', 5); 
		  e2.setAttribute('validate','Dosage,int,yes');
		  e2.onblur = function(){checkDosageValidation(this.value,iteration);fillValue(iteration)};
		  cellRight2.appendChild(e2); 
		  
		  var cellRight3 = row.insertCell(3);
		  var e3 = document.createElement('Select');
		  e3.name='frequency'+iteration;
		  e3.id='frequency'+iteration;
		  e3.classname='smalllabel'
		  e3.setAttribute('validate','Frequency,String,yes');
		  e3.onblur=function(){getFrequencyValue(this.value,iteration);fillValueFromFrequency(this.value,iteration);displaySOSQty(this.value,iteration);fillValue(iteration)};
	 
		   e3.options[0] = new Option('Select', '0');
		   for(var i = 0;i<icdArray.length;i++ ){
		      e3.options[i+1] = new Option(icdArray[i][1],icdArray[i][0]);
		   }
		  cellRight3.appendChild(e3); 
		  
		  var e31 = document.createElement('input');
		  e31.type = 'hidden';
		  e31.name='actualDispensingQty'+iteration;
		  e31.id='actualDispensingQty'+iteration
		  e31.size='6';
		  e31.setAttribute('tabindex','1');
		  cellRight3.appendChild(e31); 
		  
		  
		  var e32 = document.createElement('input');
		  e32.type = 'hidden';
		  e32.name='frequencyValue'+iteration;
		  e32.id='frequencyValue'+iteration;
		  e32.size='5';
		  e32.setAttribute('tabindex','1');
		  cellRight3.appendChild(e32);
		  
		  var e33 = document.createElement('input');
			e33.type = 'text';
			e33.name='sosQty'+iteration;
			e33.id='sosQty'+iteration;
			e33.tabIndex='1';
			e33.size='3';
			e33.style.display='none';
			e33.setAttribute('maxlength', 3); 
		    e33.onblur=function(){fillValue(iteration)};
			cellRight3.appendChild(e33);
		  
			 var e34 = document.createElement('input');
			  e34.type = 'hidden';
			  e34.name='frequencyValue'+iteration;
			  e34.id='frequencyValue'+iteration;
			  e34.size='5';
			  e34.setAttribute('tabindex','1');
			  cellRight3.appendChild(e34);
		  
		  
		   var cellRight4 = row.insertCell(4);
	/* 	  var e4 = document.createElement('Select');
		 
		  e4.name='instruction'+iteration;
		  e4.id='instruction'+iteration;
		 
		   e4.options[0] = new Option('Select', '0');
		   for(var i = 0;i<icdArrayForInstruction.length;i++ ){
		      e4.options[icdArrayForInstruction[i][0]] = new Option(icdArrayForInstruction[i][1],icdArrayForInstruction[i][0]);
		      }
		  cellRight4.appendChild(e4) */
		  
		  var e4 = document.createElement('input');
		  e4.type = 'text';
		  e4.name='instruction'+iteration;
		  e4.id='instruction'+iteration
		  e4.size='10';
		  e4.setAttribute('placeholder','1-1-1');
		  e4.setAttribute('maxlength', 15); 
		  e4.setAttribute('tabindex','1');
		  cellRight4.appendChild(e4);
		  
		  var cellRight5 = row.insertCell(5);
		  var e5 = document.createElement('input');
		  e5.type = 'text';
		  e5.name='noOfDays'+iteration;
		  e5.id='noOfDays'+iteration;
		  e5.size='7'
		  e5.setAttribute('maxlength', 3); 
		  e5.setAttribute('validate','No Of Days,int,yes');
		  
		  e5.onblur=function(){
		  							/* var val=e5.value
		  							var freq=e3.value
		  							document.getElementById('total'+iteration).value=val*freq */
		  							fillValue(iteration);
		  						}
		  cellRight5.appendChild(e5);
		  
		  var cellRight6 = row.insertCell(6);
		  var e7 = document.createElement('input');
		  e7.type = 'text';
		  e7.name='total'+iteration;
		  e7.id='total'+iteration;
		  e7.size='3'
		  e7.setAttribute('validate','Total,num,no');
		  cellRight6.appendChild(e7);
		  
		  
/* 		  var cellRight7 = row.insertCell(7);
		  var e6 = document.createElement('input');
		  e6.type = 'text';
		  e6.name='remark'+iteration;
		  e6.id='remark'+iteration;
		  e6.size='10'
		  e6.setAttribute('maxlength', 40); 
		  cellRight7.appendChild(e6); */
		  
	

		  var cellRight8 = row.insertCell(7);
		  var e8 = document.createElement('input');
		  e8.type = 'button';
		  e8.className = 'buttonAdd';
		  e8.value='',
		  //e8.name='remark';
		  //e8.id='';
		  //e8.size='10'
		  e8.setAttribute('tabindex', 1);
		  e8.setAttribute('onClick','addRow();'); 
		  cellRight8.appendChild(e8);

		  
		  var cellRight9 = row.insertCell(8);
		  var e9 = document.createElement('input');
		  e9.type = 'button';
		  e9.value='',
		  e9.className = 'buttonDel';
		  e9.setAttribute('tabindex', 1);
		  e9.setAttribute('onClick','removeRow();');
		
		  cellRight9.appendChild(e9); 
		  
	}
	/*  function  fillValue(value){
	  var freq=document.getElementById('frequency1').value
	  document.getElementById('total1').value=freq*value
	 } */
	/*  function  fillValueFromFrequency(value){
	  var noOfDays=document.getElementById('noOfDays1').value
	  document.getElementById('total1').value=noOfDays*value
	 }
	  */
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
	
	function createTemplateCode(){
	var templateName=document.getElementById("<%= SEARCH_NAME %>").value;
	
	if(templateName.length>5){
	
	var templateCode=templateName.substring(0,5);
	document.prescriptionTemplate.<%=CODE%>.value=templateCode;
	}
	else{
	document.prescriptionTemplate.<%=CODE%>.value=templateName;
	}
	}
	</script>


<form name="prescriptionTemplate" method="post" action="">
<input type="hidden" name="<%= POJO_NAME %>" value="OpdTemplate">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="TemplateName">
<input type="hidden" name="title" value="OpdTemplate">
<input type="hidden" name="<%=JSP_NAME %>" value="opdTemplate">
<input type="hidden" name="pojoPropertyCode" value="TemplateCode">
<div class="Block">
<label> Template Code </label>
 <input type="text"	name="<%= CODE%>" id="code" value="" disabled="true"	readonly="readonly" validate="Template Code,string,yes" MAXLENGTH="8"	tabindex=1 />
 <label><span>*</span> Template Name</label>
 <input type="text" name="<%= SEARCH_NAME %>" id="<%= SEARCH_NAME%>" value=""onblur="createTemplateCode();"  validate="Template Name,string,yes" MAXLENGTH="30" tabindex=1 />
   <script>
	document.prescriptionTemplate.<%=CODE%>.focus();
</script>
</div>
<div id="testDiv">

<div class="Clear"></div>

	<% 
		String []ItemClassCodeForLiquid = HMSUtil.getProperties("adt.properties", "ItemClassCodeForDrop").trim().split(",");
	for(int i=0;i<ItemClassCodeForLiquid.length;i++)
	{
	%>
	<script>

	itemClassCodeArray[<%=i%>]= new Array();
	itemClassCodeArray[<%=i%>][0] = "<%=ItemClassCodeForLiquid[i]%>";

     			
            </script>
<%	}%>
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
	<tr>
		<th scope="col">Nomenclature</th>
		<th scope="col">Material Code</th>
		<th scope="col">Dosage</th>
		<th scope="col">Frequency</th>
		<th scope="col">Instruction</th>
		<th scope="col">No. of Days</th>
			<th scope="col">Total</th>
		<!-- <th scope="col">Remark</th> -->
		<th>Add</th>
		<th>Delete</th>
	</tr>
	<tr>
	<td>
	 <input type="text" value="" tabindex="1" id="nomenclature1"size="43" validate="Nomenclature,string,yes" 
			name="nomenclature1" onblur="populatePVMS(this.value,'1');displayAu(this.value,'1','0');checkForPurchase(this.value,'1');" tabindex="1"/>
			<input type="hidden" name="itemId1" id="itemId1" value="" />
		<div id="ac2update1"	style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('nomenclature1','ac2update1','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature1'});
			</script></td>
			
		<td><input type="text" name="pvmsNo1" tabindex="1" id="pvmsNo1"	validate="MET No.,string,yes" size="10" readonly="readonly" />
		<input type="hidden"
						name="highValueMedicine1" tabindex="1"
						id="highValueMedicine1" value="" size="1"
						validate="High value Medicine,string,no" />
						
	<input type="hidden" tabindex="1" id="itemClassCode1" name="itemClassCode1" validate="itemClassCode,string,no" value="" />
							
							
		</td>
		<td><input type="text" name="dosage1" tabindex="1" id="dosage1"	validate="Dosage,string,yes" size="5" onblur="fillValue('1')" maxlength="5" /></td>
		<td><select name="frequency1" id="frequency1" validate="Frequency,string,yes"
			onchange="getFrequencyValue(this.value,'1');fillValueFromFrequency(this.value,'1');displaySOSQty(this.value,'1');fillValue('1')" tabindex="1">
			<option value="0">Select</option>
			<%
		      for(MasFrequency masFrequency : frequencyList){
		       int id = masFrequency.getId();
		       String name = masFrequency.getFrequencyName();
          %>
			<option value="<%=id %>"><%=name%></option>
			<%} %>
		</select> <% 
	    		MasFrequency  masFrequency = new MasFrequency();
	    		  
			         for (int i = 0; i < frequencyList.size(); i++) {
			        	 masFrequency = (MasFrequency) frequencyList.get(i);
    			 %> <script>
	    	  
	          icdArray[<%=i%>]= new Array();
	          icdArray[<%=i%>][0] = "<%=masFrequency.getId()%>";
	          icdArray[<%=i%>][1] = "<%=masFrequency.getFrequencyName()%>";
            </script> <% }%>
            <input type="hidden" name="frequencyValue1"
							id="frequencyValue1" value=""> <input type="text"
							name="sosQty1" tabindex="1" id="sosQty1" style="display: none;"
							size="3" onblur="fillValue('1')" maxlength="3"
							validate="Sos Qty,num,no" />
<input type="hidden"
							name="actualDispensingQty1" tabindex="1"
							id="actualDispensingQty1" value="" size="6"
							validate="AU,string,no" />							
		</td>
		<td>
			<input type="text" name="instruction1" tabindex="1" id="instruction1" size="10" maxlength="15" placeholder="1-1-1"/>
		<%-- <select name="instruction1" id="instruction1" tabindex="1">
			<option value="0">Select</option>
			<%
              
		      for(OpdInstructionTreatment opdInstructionTreatment : opdInstructionTreatmentList){
		       int id = opdInstructionTreatment.getId();
		       String instructionName = opdInstructionTreatment.getOpdInstructionTreatmentName();
		       String code=opdInstructionTreatment.getOpdInstructionTreatmentCode();
          %>
			<option value="<%=id %>">[<%=code %>]<%=instructionName%></option>
			<%} %>
		</select> <% 
	    		OpdInstructionTreatment  opdInstructionTreatment = new OpdInstructionTreatment();
	    		  
			         for (int i = 0; i < opdInstructionTreatmentList.size(); i++) {
			        	 opdInstructionTreatment = (OpdInstructionTreatment) opdInstructionTreatmentList.get(i);
			        	 String instruction=opdInstructionTreatment.getOpdInstructionTreatmentName()+opdInstructionTreatment.getOpdInstructionTreatmentCode();
     			 %> <script>
	    	 
	          icdArrayForInstruction[<%=i%>]= new Array();
	          icdArrayForInstruction[<%=i%>][0] = "<%=opdInstructionTreatment.getId()%>";
	          icdArrayForInstruction[<%=i%>][1] ="<%=instruction%>";
            </script> <% }%> --%>
		</td>

		<td><input type="text" name="noOfDays1" tabindex="1" id="noOfDays1" onblur="fillValue(1)" size="7" maxlength="3" validate="No Of Days,int,yes" /></td>
		<td><input type="text" name="total1" tabindex="1" id="total1" size="3" validate="total,num,no"/><input type="hidden" name="hdb" value="1" id="hdb" /></td>
		
		<!-- <td><input type="text" name="remarks1" tabindex="1" id="remarks1" size="10" maxlength="40"/>
		</td> -->
			<td><input type="button" tabindex="1" class="buttonAdd" alt="Add" onclick="addRow();" value="" align="right" /></td>
			<td><input type="button" tabindex="1"	class="buttonDel" alt="Delete" value="" onclick="removeRow();" /></td>
	</tr>
</table>
</div>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>

<input type="button" name="add" id="addbutton" value="Save"	class="button" onClick="submitWindow();" accesskey="a" tabindex=1 />
<input	type="reset" name="Reset" id="reset" value="Reset" class="button"	onclick="resetCheck();" accesskey="r" />
<input	type="reset" name="Reset" id="reset" value="Close" class="button"	onclick="closeWindow();" accesskey="r" />
<!--  <input type="button" name="close" id="addbutton" value="close" class="button"	onClick="closeWindow();" accesskey="a" tabindex=1 />
-->
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
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


<style>
.Block, .division{width:988px!important;}
.Block input {height:24px;}
</style>