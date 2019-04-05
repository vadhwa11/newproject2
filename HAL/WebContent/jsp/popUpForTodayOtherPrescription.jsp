<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>


<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" src="/hms/jsp/js/opd.js"></script>

<%
String hinIdparam = request.getParameter("hinId");

%>
<script type="text/javascript">
var icdArray=new Array();
var unitArray=new Array();
function stopMedicine(val){

	if(validateStop(val)){
		//submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=responseForDoctarsList&referredDepartmentId='+indexes+'','referredDoctarsIdDiv');
		
		submitForm('currentMedication','opd?method=stopCurrentMedication&hinId=<%out.print(hinIdparam);%>&bufferingFlag=y');
	}
	}

	function validateStop(val)
	{
		for(var i=1;i<=val;i++)
			{
			if(document.getElementById("stop"+i)!=null && document.getElementById("stop"+i).checked)
				return true;
			}
		   alert("Select atleast one medicine");
	   return false;
	}
	
	function setValuesInParentForPrescription(formname,val){
  		//formName=formname.name;
  		
		var validate=false;
			for(var i=1;i<=val;i++)
		{
		if(document.getElementById("repeatPrescription"+i)!=null && document.getElementById("repeatPrescription"+i).checked)
			validate= true;
		}
		 	if(validate==false){
	   alert("Select atleast one medicine");
	   return false;
			} 
		var grid = window.opener.document.getElementById("nomenclatureGrid").rows.length;

		 var tbl = window.opener.document.getElementById("nomenclatureGrid");
	
		   for(var i=1;i<grid;i++) 
		   tbl.deleteRow(1);
		
		//alert(grid);
 	/* 	var nomenclatureVal = window.opener.document.getElementById('nomenclature1').value;
 		var hdbVal = window.opener.document.getElementById('hdb').value;
		if(hdbVal == 1 && nomenclatureVal == ''){
			var len = window.opener.document.getElementById("grid").rows.length;
			var r1 = window.opener.document.getElementById("grid").deleteRow(len-1);
		} */
			
	for(var index = 1; index < parseInt(document.currentMedication.counter.value); index++ ){
			
			var toEval = "document.currentMedication.repeatPrescription" + index;
			var repeatIn = eval(toEval);
			if(repeatIn!=null&& repeatIn.checked == true){
			
				  var len = window.opener.document.getElementById("nomenclatureGrid").rows.length;
				  // var len = 1;
				  //var r1 = window.opener.document.getElementById("grid").deleteRow(len-1);
				  var r = window.opener.document.getElementById("nomenclatureGrid").insertRow(len);
				  
				  var c1 = r.insertCell(0);
				 // var c2= r.insertCell(1);
				 // var c3 = r.insertCell(2);
				//  var c4 = r.insertCell(3);
				  var c5 = r.insertCell(1);
				  var c6 = r.insertCell(2);
				  var c7 = r.insertCell(3);
				  var c8 = r.insertCell(4);
				  var c9 = r.insertCell(5);	
				//  var c10 = r.insertCell(9);
				  var c11 = r.insertCell(6);	
				  var c12 = r.insertCell(7);			
				  var c13 = r.insertCell(8);
				  var c14 = r.insertCell(9);
				  
				  var nomenclature=eval('document.'+formname+'.nomenclature' + index + '.value')
				  var pvmsNo=eval('document.'+formname+'.pvmsNo' + index + '.value')
				
				  var x1 = window.opener.document.createElement('input');
				  x1.type = 'text';
				  x1.name='nomenclature'+len;
				  x1.id='nomenclature'+len;
				  x1.size = '30';
	  			  x1.tabindex='1';	 				  
				  x1.value = nomenclature+"["+pvmsNo+"]";;
				  var x11 = window.opener.document.createElement('input');
				  x11.type = 'hidden';
				  x11.name='itemId'+len;
				  x11.id='itemId'+len
				  x11.value = eval('document.'+formname+'.itemId' + index + '.value');
				  x11.size='6';
				  x11.setAttribute('tabindex','1');
				  var x12 = window.opener.document.createElement('input');
				  x12.type = 'hidden';
				  x12.name='itemIdClassificationId'+len;
				  x12.id='itemIdClassificationId'+len
				  x12.value = eval('document.'+formname+'.itemIdClassificationId' + index + '.value');
				  x12.size='6';
				  x12.setAttribute('tabindex','1');
				  c1.appendChild(x12);
				  c1.appendChild(x11);
				  c1.appendChild(x1);
	  			  //new Ajax.Autocompleter('nomenclature'+len,'ac2update1','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature'+len});
                  
                    
				  var divElement = window.opener.document.createElement('div');
				  divElement.id = 'ac2update1';
				  divElement.style.display = 'none';
				  c1.appendChild(divElement);
                  
				/*   var x2 = window.opener.document.createElement('input');
				  x2.type = 'text';
				  x2.name='otherMedicine'+len;
				  x2.id='otherMedicine'+len
				  x2.size='20';
				  x2.setAttribute('tabindex','1');
				  c2.appendChild(x2); */

				  
		/* 		  var x3 = window.opener.document.createElement('Select');
				  x3.name='itemConversionId'+len;
				  x3.id='itemConversionId'+len;
				  x3.className='medium';
				  //e2.class = 'medium';
				  x3.setAttribute('tabindex','1');
				//  x3.options[0] = new Option('Select', '0');
				 var opt = window.opener.document.createElement("option");  
				 opt.value = '0';
		      	 opt.innerHTML = 'Select';
		      	 x3.appendChild(opt);
				   for(var i = 0;i<unitArray.length;i++ ){
					   var option1 = window.opener.document.createElement("option");  
		   		      	if(selectedFrequency == unitArray[i][0]){
		   		      	    option1.value = unitArray[i][0];
		   		      	    option1.innerHTML = unitArray[i][1];
		   		      		option1.selected='Selected';
		   		      	}else{
		   		      	 	option1.value = unitArray[i][0];
		   		      	    option1.innerHTML =unitArray[i][1];
		   		      	}
		   		     x3.appendChild(option1);
				     // e12.options[i+1] = new Option(unitArray[i][1],unitArray[i][0]);
				      }
				  c3.appendChild(x3); */
				  
			/* 	  var x4 = window.opener.document.createElement('Select');
				  x4.name='itemConversionId'+len;
				  x4.id='itemConversionId'+len;
				  x4.className='medium';
				  //e2.class = 'medium';
				  x4.setAttribute('tabindex','1');
				//  x3.options[0] = new Option('Select', '0');
				 var opt = window.opener.document.createElement("option");  
				 opt.value = '0';
		      	 opt.innerHTML = 'Select';
		      	 x4.appendChild(opt);
				   for(var i = 0;i<unitArray.length;i++ ){
					   var option1 = window.opener.document.createElement("option");  
		   		      	if(selectedFrequency == unitArray[i][0]){
		   		      	    option1.value = unitArray[i][0];
		   		      	    option1.innerHTML = unitArray[i][1];
		   		      		option1.selected='Selected';
		   		      	}else{
		   		      	 	option1.value = unitArray[i][0];
		   		      	    option1.innerHTML =unitArray[i][1];
		   		      	}
		   		     x4.appendChild(option1);
				     // e12.options[i+1] = new Option(unitArray[i][1],unitArray[i][0]);
				      }
				  c4.appendChild(x4); */

				  var x5 = window.opener.document.createElement('input');
				  x5.type = 'hidden';
				  x5.name='actualDispensingQty'+len;
				  x5.value = eval('document.'+formname+'.actualDispensingQty' + index + '.value');
				  x5.id='actualDispensingQty'+len
				  x5.size='6';
				  x5.setAttribute('tabindex','1');
				 
				  var x4 = window.opener.document.createElement('input');
				  x4.type = 'text';
				  x4.name='dispensingUnit'+len;
				  x4.id='dispensingUnit'+len;
				  x4.value = eval('document.'+formname+'.dispensingUnit' + index + '.value');
				  x4.size='6';
				  x4.setAttribute('tabindex','1');
				  //e12.onblur=function(){displayAU(this.value,iteration)};
				  c5.appendChild(x5);
				  c5.appendChild(x4);
				  
				  var x51 = window.opener.document.createElement('input');
				  x51.type = 'hidden';
				  x51.name='pvmsNo'+len;
				  x51.id='pvmsNo'+len;
				  x51.size = '10';
				  x51.setAttribute('tabindex','1');				  
				  x51.value = eval('document.'+formname+'.pvmsNo' + index + '.value');
				  x51.setAttribute("readonly","readonly");
				  c6.appendChild(x51);

				  var x6 = window.opener.document.createElement('input');
				  x6.type = 'text';
				  x6.name='dosage'+len;
				  x6.id='dosage'+len;
				  x6.size = '5';
	  			  x6.setAttribute('tabindex','1');				  
				  x6.value = eval('document.'+formname+'.dosage' + index + '.value');
				 // x6.onblur = function(){fillValue(len)};
				  x6.setAttribute('onblur',"fillValue("+len+")");	
		
				  //x3.setAttribute("readonly","readonly");
				  c6.appendChild(x6);

				  var x7 = window.opener.document.createElement('Select');
				  //x4.type = 'hidden';
				  x7.name='frequency'+len;
				  x7.id='frequency'+len;
				  x7.className='medium';
	  			  x7.tabindex = '1';	
				  selectedFrequency = eval('document.'+formname+'.frequency' + index + '.value');
				  var opt1 = window.opener.document.createElement("option");  
				  opt1.value = '0';
		      	  opt1.innerHTML = 'Select';
		      	  //x7.onblur=function(){fillValue(iteration)};
		      	// x7.setAttribute('onblur',"getFrequencyValue("+selectedFrequency+","+len+");fillValue("+len+")");
		      	 x7.setAttribute('onblur',"getFrequencyValue("+selectedFrequency+","+len+");fillValueFromFrequency("+selectedFrequency+","+len+");displaySOSQty("+selectedFrequency+","+len+");fillValue("+len+")");
		      	 //e2.onblur=function(){getFrequencyValue(this.value,iteration);fillValueFromFrequency(this.value,iteration);displaySOSQty(this.value,iteration);fillValue(iteration)};
		      	  x7.appendChild(opt1);
				  for(var i = 0;i<icdArray.length;i++ ){
					  var option = window.opener.document.createElement("option");  
		   		      	if(selectedFrequency == icdArray[i][0]){
		   		      	    option.value = icdArray[i][0];
		   		      	    option.innerHTML = icdArray[i][1];
		   		      		option.selected='Selected';
		   		      	}else{
		   		      	 	option.value = icdArray[i][0];
		   		      	    option.innerHTML = icdArray[i][1];
		   		      	}
		   		     x7.appendChild(option);
				  }

				/*  x4.options[0] = new Option('Select', '0');
	   		      for(var i = 0;i<icdArray.length;i++ ){
	   		      	if(selectedFrequency == icdArray[i][0]){
	   		      		x4.options[i+1] = new Option(icdArray[i][1],icdArray[i][0]);
	   		      		x4.options[i+1].selected='Selected';
	   		      	}else{
	      		  		x4.options[i+1] = new Option(icdArray[i][1],icdArray[i][0]);
	   		      	}
	      		  }*/
	      		  
	      		  
				  c7.appendChild(x7);

	      		  var e61 = window.opener.document.createElement('input');
	      		  e61.type = 'text';
	      		  e61.name='sosQty'+len;
	      		  e61.id='sosQty'+len;
	      		  e61.tabIndex='1';
	      		  e61.size='3';
	      		  e61.style.display='none';
	      		  e61.setAttribute('maxlength', 3); 
	      	      //e61.onblur=function(){fillValue(this.value,iteration)};
	      	       e61.setAttribute('onblur',"fillValue("+len+")");	
	      	      
	      		  c7.appendChild(e61);

	      		  var e62 = window.opener.document.createElement('input');
	      		  e62.type = 'hidden';
	      		  e62.name='frequency'+len;
	      		  e62.id='frequency'+len;
	      		  e62.size='5';
	      		  e62.setAttribute('tabindex','1');
	      		  c7.appendChild(e62);

				  var x8 = window.opener.document.createElement('input');
				  x8.type = 'text';
				  x8.name='noOfDays'+len;
				  x8.id='noOfDays'+len;
				  x8.size = '3';
	  			  x8.setAttribute('tabindex','1');				  
				  x8.value = eval('document.'+formname+'.noOfDays' + index + '.value');
				  //x5.setAttribute("readonly","readonly");
				  x8.setAttribute('onblur',"fillValue("+len+")");	
				  c8.appendChild(x8);
				  
				  var x81 = window.opener.document.createElement('input');
				  x81.type = 'hidden';
				  x81.name='frequencyValue'+len;
				  x81.id='frequencyValue'+len;
				  x81.value= eval('document.'+formname+'.frequencyValue' + index + '.value');;
				  x81.size='5';
				  x81.setAttribute('tabindex','1');
				  c8.appendChild(x81);
				  
				  
				  
				  var x82 = window.opener.document.createElement('input');
				  x82.type = 'hidden';
				  x82.name='itemClassCode'+len;
				  x82.id='itemClassCode'+len;
				  x82.value= eval('document.'+formname+'.itemClassCode' + index + '.value');;
				  x82.size='5';
				  x82.setAttribute('tabindex','1');
				  c8.appendChild(x82);
				  
				  var e71 = window.opener.document.createElement('input');
				  e71.type = 'text';
				  e71.name='total'+len;
				  e71.id='total'+len;
				  e71.size='5';
				  e71.value = eval('document.'+formname+'.total' + index + '.value');
				  e71.setAttribute('tabindex','1');
				  c9.appendChild(e71);

				/*   var x9 = window.opener.document.createElement('input');
				  x9.type = 'text';
				  x9.name='route'+len;
				  x9.id='route'+len
				  x9.size='5';
					//e6.value='route';
				  x9.setAttribute('maxlength', 20); 
				  x9.setAttribute('tabindex','1');
				  c10.appendChild(x9); */
				  /* 

				  var x7 = document.createElement('Select');
				  x7.name='instructionACPC'+len;
				  x7.id='instructionACPC'+len;
				  x7.options[0] = new Option('Select', '');
				  selectedInstructionACPC = eval('document.'+formName+'.instructionACPC' + index + '.value'); 
	   		      for(var i = 0;i<instructionACPCArray.length;i++ ){
	   		      	if(selectedInstructionACPC == instructionACPCArray[i][0]){
	   		      		x7.options[i+1] = new Option(instructionACPCArray[i][1],instructionACPCArray[i][0]);
	   		      		x7.options[i+1].setAttribute('Selected','Selected');
	   		      	}else{
	      		  		x7.options[i+1] = new Option(instructionACPCArray[i][1],instructionACPCArray[i][0]);
	   		      	}
	      		  }
				  
	  			  x7.setAttribute('tabindex','1');				  
				  c7.appendChild(x7);

				  var x8 = document.createElement('Select');
				  x8.name='typeLeftRight'+len;
				  x8.id='typeLeftRight'+len;
				  
				  x8.options[0] = new Option('Select', '');
				  selectedtypeLeftRight = eval('document.'+formName+'.typeLeftRight' + index + '.value'); 
	   		      for(var i = 0;i<typeLeftRightArray.length;i++ ){
	   		      	if(selectedtypeLeftRight == typeLeftRightArray[i][0]){
	   		      		x8.options[i+1] = new Option(typeLeftRightArray[i][1],typeLeftRightArray[i][0]);
	   		      		x8.options[i+1].setAttribute('Selected','Selected');
	   		      	}else{
	      		  		x8.options[i+1] = new Option(typeLeftRightArray[i][1],typeLeftRightArray[i][0]);
	   		      	}
	      		  }
				  
	  			  x8.setAttribute('tabindex','1');				  
				  c8.appendChild(x8);
				  */
				  //var cellRight6 = row.insertCell(6);
					
					
				  var x10 = window.opener.document.createElement('input');
				  x10.type = 'text';
				  x10.name='remarks'+len;
				  x10.id='remarks'+len;
				  x10.size = '10';
	  			  x10.setAttribute('tabindex','1');		
	  				x10.setAttribute('placeholder','1-1-1');
	  				x10.setAttribute('maxlength', 15); 
				  //x10.value = eval('document.'+formname+'.remarks' + index + '.value');
				  //x5.setAttribute("readonly","readonly");
				  c11.appendChild(x10);
				  
				/*   var x10 = window.opener.document.createElement('input');
				  x10.type = 'checkbox';
				  x10.name='ct'+len;
				  x10.id='ct'+len
				  x10.size='10';
				  x10.className='radio';
				  x10.value='y';
				  x10.setAttribute('tabindex','1');
				  c10.appendChild(x10); */

				  var x11 = window.opener.document.createElement('input');
				  x11.type = 'text';
				  x11.name='closingStock'+len;
				  x11.id='closingStock'+len
				  x11.size='3';
				  x11.setAttribute('tabindex','1');
				  c12.appendChild(x11);



				/*   var x12 = window.opener.document.getElementById('hdb');
				  x12.value=len; */
					
				 if(window.opener.document.getElementById('nomenclaturehdb')!=null)
				{
					  var x12 = window.opener.document.getElementById('nomenclaturehdb');
					  x12.value=len;
					}
				if(window.opener.document.getElementById('hdb')!=null)
				{
				  var x12 = window.opener.document.getElementById('hdb');
				  x12.value=len;
				}
				  
				  var x13 = window.opener.document.createElement('input');
				  x13.type = 'button';
				  x13.className = 'buttonAdd';
				  x13.setAttribute('onClick','addNomenclatureRow()');		  
				  c13.appendChild(x13);

				  var x14 = window.opener.document.createElement('input');
				  x14.type = 'button';
				  x14.className = 'buttonDel';
	  			  x14.tabindex='1';	
	  			  //x14.onclick=function(){removeRow();}; 
	  			  //x14.setAttribute('onClick','removeRow('nomenclatureGrid','nomenclaturehdb')');	
	  			if(window.opener.document.getElementById('nomenclaturehdb')!=null)
					{
	  			  x14.setAttribute('onClick',"removeRow('nomenclatureGrid',nomenclaturehdb,this)");	
						}
					if(window.opener.document.getElementById('hdb')!=null)
					{
						  x14.setAttribute('onClick',"removeRow('nomenclatureGrid',hdb,this)");	
					}
	  			 //e9.onclick = function(){removeRow("nomenclatureGrid","nomenclaturehdb",this);};  
				  c14.appendChild(x14);
				  
				 
			}
		}
		
	window.close();		
  	}
	</script>

<%
Map<String,Object>map=new HashMap<String,Object>();
if(request.getAttribute("map")!=null){
	map=(Map<String,Object>)request.getAttribute("map");
}
List<PatientPrescriptionDetails>ppdList=new ArrayList<PatientPrescriptionDetails>();
if(map.get("ppdList")!=null){
	ppdList=(List<PatientPrescriptionDetails>)map.get("ppdList");
}
int visitId=0;
int hinId =0;
if(map.get("visitId")!=null){
	visitId=(Integer)map.get("visitId");
}

if(map.get("hinId")!=null){
	hinId=(Integer)map.get("hinId");
}

List<MasFrequency> frequencyList= new ArrayList<MasFrequency>();	
if(map.get("frequencyList")!=null){
	frequencyList = (List)map.get("frequencyList");
}
List<Integer> currentPrescribedItemIdList = new ArrayList();

if(map.get("currentPrescriptionIdList")!=null){
	currentPrescribedItemIdList = (List)map.get("currentPrescriptionIdList");
}

List<Integer> currentNIPPrescriptionIdList = new ArrayList();
if(map.get("currentNIPPrescriptionIdList")!=null){
	currentNIPPrescriptionIdList = (List)map.get("currentNIPPrescriptionIdList");
}
%>

<% 
	    		MasFrequency  masFrequency = new MasFrequency();
	    		  
			     for (int i = 0; i < frequencyList.size(); i++) {
			        	 masFrequency = (MasFrequency) frequencyList.get(i);
     			 %> <script>
	    	  
	          icdArray[<%=i%>]= new Array();
	          icdArray[<%=i%>][0] = "<%=masFrequency.getId()%>";
	          icdArray[<%=i%>][1] = "<%=masFrequency.getFrequencyName()%>";
            </script> <% }%> 
<div class="popupbg">

<form name="currentMedication" method="post" action="">
<%int i=1;if(ppdList.size()>0){ String doctor = "";
/* List<Integer> currentPrescribedItemIdList = new ArrayList();
for(PatientPrescriptionDetails ppd:ppdList){
	if(HMSUtil.alreadyPrescribedMedicine(ppd))
	    currentPrescribedItemIdList.add(ppd.getItem().getId());
} */
%>

<table>
<tr>
<th>Sr. No.</th>
<th>Item Name</th>
<!-- <th>Route</th> -->
<th>Dosage</th>
<th>No. Of Days</th>
<th>Frequency</th>
<th>Total</th>
<th>Prescribed By</th>
<th>Department</th>
<th>Prescribed Date</th>
<!-- <th>Stop</th>
<th>repeat</th> -->
</tr>
<%
for(PatientPrescriptionDetails ppd:ppdList){ %>
<tr>
<td><%=i %></td>
<%if(ppd.getItem()!=null){ %>
<td>
<input type="hidden" name="pvmsNo<%=i %>" size="6" tabindex="1" readonly="readonly" value="<%=ppd.getItem().getPvmsNo()%>" />
			
<input type="hidden" name="nomenclature<%=i %>" tabindex="1" size="20" readonly="readonly" value="<%=ppd.getItem().getNomenclature()%>" id="nomenclature<%=i %>" />
<input name="itemId<%=i %>" id="itemId<%=i %>" value="<%=ppd.getItem().getId()%>" type="hidden">
<input name="itemIdClassificationId<%=i%>" id="itemIdClassificationId<%=i%>" value="<%=ppd.getItem().getItemClassification().getId()%>"type="hidden">

<input type="hidden" name="actualDispensingQty<%=i%>" id="actualDispensingQty<%=i%>" size="6" tabindex="1" readonly="readonly" value="<%=ppd.getItem().getADispQty() !=null ? ppd.getItem().getADispQty():""%>"/>
<%String dispensingUnit = "";
if(!ppd.getItem().getDispUnit().equals("0")){
if(ppd.getItem().getDispUnit().matches("[0-9]+"))
	dispensingUnit =  ppd.getItem().getItemConversion()!=null?ppd.getItem().getItemConversion().getItemUnitName():"";
else 
	dispensingUnit = ppd.getItem().getDispUnit();}

%>
<input type="hidden" name="dispensingUnit<%=i%>" id="dispensingUnit<%=i%>" size="6" tabindex="1" readonly="readonly" value="<%=dispensingUnit%>"/>
<input type="hidden" name="sosQty<%=i%>" id="sosQty<%=i%>" size="6" tabindex="1" readonly="readonly" value=""/>
<input type="hidden" tabindex="1" id="itemClassCode<%=i%>" name="itemClassCode<%=i%>" validate="itemClassCode,string,no" value="<%=ppd.getItem().getItemClass()!=null ? ppd.getItem().getItemClass().getItemClassCode():""%>"/>
			
			 <%=ppd.getItem().getNomenclature() %></td>
<%}else{ %>
<td>--</td>
<%} %>
<%-- <%if(ppd.getRoute()!=null){ %>
<td><%=ppd.getRoute() %></td>
<%}else{ %>
<td>--</td> --%>
<%/* } */if(ppd.getDosage()!=null){ %>
<td><input type="hidden" name="dosage<%=i%>" id="dosage<%=i%>" size="6" tabindex="1" readonly="readonly" value="<%=ppd.getDosage() %>" />
			  <%=ppd.getDosage() %></td>
<%}else{ %>
<td>--</td>
<%}if(ppd.getNoOfDays()!=null){ %>
<td>
<input type="hidden" name="noOfDays<%=i %>"  id="noOfDays<%=i %>" size="6" tabindex="1" readonly="readonly" value="<%=ppd.getNoOfDays() %>" />
<input type="hidden" name="total<%=i %>" id="total<%=i %>" tabindex="1"  readonly="readonly" value="<%=ppd.getTotal()%>" />	
			
<%=ppd.getNoOfDays() %></td>
<%}else{ %>
<td>--</td>
<%}if(ppd.getFrequency()!=null){%>
<td>
<input type="hidden" name="frequencyValue<%=i%>" id="frequencyValue<%=i%>" size="6" tabindex="1" readonly="readonly" value="<%=ppd.getFrequency().getFeq()%>"/>	
<input type="hidden" name="frequency<%=i %>" id="frequency<%=i%>" size="6" tabindex="1" readonly="readonly" value="<%=ppd.getFrequency().getId() %>" />
<%=ppd.getFrequency().getFrequencyName() %></td>
<%}else{ %>
<td>--</td>
<%} if(ppd.getTotal()!=null){%>
<td><%=ppd.getTotal() %></td>
<%}else{ %>
<td>--</td>
<%}if(ppd.getPrescription()!=null && ppd.getPrescription().getEmp()!=null){%>
<td>
<%
doctor = "";
if(ppd.getPrescription().getEmp().getFirstName()!=null)
doctor = ppd.getPrescription().getEmp().getFirstName();
if(ppd.getPrescription().getEmp().getMiddleName()!=null)
doctor += " "+ppd.getPrescription().getEmp().getMiddleName();
if(ppd.getPrescription().getEmp().getLastName()!=null)
doctor += " "+ppd.getPrescription().getEmp().getLastName();
%>

<%=doctor%></td>
<%}else{ %>
<td>--</td>
<%} 
if(ppd.getPrescription()!=null && ppd.getPrescription().getDepartment()!=null){%>
<td><%=ppd.getPrescription().getDepartment().getDepartmentName()%></td>
<%}else{ %>
<td>--</td>
<%} 
if(ppd.getPrescription()!=null && ppd.getPrescription().getPrescriptionDate()!=null){%>
<td><%=HMSUtil.changeDateToddMMyyyy(ppd.getPrescription().getPrescriptionDate())%></td>
<%}else{ %>
<td>--</td>
<%} %>
<%-- <td>
<%

if(ppd.getItemStopStatus() !=null && ppd.getItemStopStatus().equalsIgnoreCase("y")){
	doctor = "";
if(ppd.getItemStopBy().getFirstName()!=null)
	doctor = ppd.getItemStopBy().getFirstName();
if(ppd.getItemStopBy().getMiddleName()!=null)
	doctor += " "+ppd.getItemStopBy().getMiddleName();
if(ppd.getItemStopBy().getLastName()!=null)
	doctor += " "+ppd.getItemStopBy().getLastName();
%>
Medicine stopped on <%=ppd.getItemStopDate()!=null?HMSUtil.changeDateToddMMyyyy(ppd.getItemStopDate()):"-"%> by <%=ppd.getItemStopDate()!=null?doctor:"-"%>
  <%}else if(ppd.getPrescription().getStatus().equalsIgnoreCase("I")){ %>
  <input type="checkbox" name="stop<%=i%>" id="stop<%=i%>" value="<%=ppd.getId()%>"/>
  <%} %>
  </td> --%>
 <%--  <td>
  <%
//if(!HMSUtil.alreadyPrescribedMedicine(ppd))
	//System.out.println(currentPrescribedIdList.contains(ppd.getId()) +" id="+currentPrescribedIdList.get)
	
	if(currentNIPPrescriptionIdList.contains(ppd.getId()))
	{
		out.println("NIP");
	}
else if(!currentPrescribedItemIdList.contains(ppd.getItem().getId()))
{
%>	 <input type="checkbox" name="repeatPrescription<%=i%>" id="repeatPrescription<%=i%>" value="<%=ppd.getId()%>"/>
<%}
%>

 </td> --%>
</tr>

<%i++;} 

%>
<input type="hidden" name="hiddenValue" value="<%=i%>" readonly="readonly"/>
<input type="hidden" name="hinId" value="<%=hinId%>" readonly="readonly"/>
<input type="hidden" name="visitId" value="<%=visitId%>" readonly="readonly"/>
</table>
<%}else{%>
<h4>No Record Found</h4>
<%}%>

<div class="clear"></div>
<div class="clear"></div>
<!-- <input type="submit" value="Stop" onclick="stopMedicine(hiddenValue.value);"/>
<input id="save" type="button" tabindex="1" name="save"	value="Repeat" class="button"	onclick="setValuesInParentForPrescription('currentMedication',hiddenValue.value)" /> -->
<input	type="hidden" name="counter" id="counter" value="<%=i %>" />
<input type="button" value="Close" onclick="window.close();" />
</form>
<div class="clear"></div>
<div class="clear"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</div>


