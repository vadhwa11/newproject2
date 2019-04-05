<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * itemBrandWindow.jsp  
 * Purpose of the JSP -  This is for Item Brand Window.
 * @author  Vivek
 * @author  Deepti
 * Create Date: 21st Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.5
--%>


<%@page import="java.util.*,java.math.BigDecimal,jkt.hms.util.*"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.RequestConstants"%>


<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css"	/>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<%
	Map map = new HashMap();
	
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	}
	List<PatientPrescriptionDetails> patientPrescriptionList= new ArrayList<PatientPrescriptionDetails>();	
	if(map.get("patientPrescriptionList")!=null){
		patientPrescriptionList = (List)map.get("patientPrescriptionList");
	
	}
	List<MasFrequency> frequencyList= new ArrayList<MasFrequency>();	
	if(map.get("frequencyList")!=null){
		frequencyList = (List)map.get("frequencyList");
	}
		List<String> intakeList = new ArrayList<String>();
			intakeList.add("AC");
			intakeList.add("PC");
			
	   List<String> typeLeftRightList = new ArrayList<String>();
			typeLeftRightList.add("Left");
			typeLeftRightList.add("Right");
			

	%>
<script type="text/javascript">
	function cancelForm(){
  	 close();
   	}
	
	  
</script>
<script>
 var icdArray=new Array();
	   var instructionACPCArray=new Array();
	   var typeLeftRightArray=new Array();

	   </script>

<div class="clear"></div>
<div class="titleBg">
<h2>Patient Prescription Details</h2>
</div>
<div class="clear"></div>


<form name="patientPrescription" method="post">
<%if(patientPrescriptionList.size() > 0){
	PatientPrescriptionDetails patientPrescriptionDetails  = patientPrescriptionList.get(0);
	
	Visit visit = patientPrescriptionDetails.getPrescription().getVisit();
	
	%> 

<div class="Block">
<label>Employee No.</label>
 <%
 	if (visit.getHin().getServiceNo() != null) {
 %>
<label class="value"><%=visit.getHin().getServiceNo()%></label>
 <%
 	} else {
 %>
<label class="value">&nbsp;</label><%
	}
%>
<label>Patient Name</label>
 <%
 	if (visit.getHin().getPFirstName() != null) {
 			String mname = "";
 			String lname = "";
 			String fname = visit.getHin().getPFirstName();
 			if (visit.getHin().getPMiddleName() != null)
 				mname = visit.getHin().getPMiddleName();
 			if (visit.getHin().getPLastName() != null)
 				lname = visit.getHin().getPLastName();
 %>
<label class="value"><%=fname + mname + lname%></label>
 <%
 	} else {
 %>
<label class="value">&nbsp;</label><%
	}
%>
<label>Relation</label>
 <%
 	if (visit.getHin().getRelation() != null) {
 %>
<label class="value"><%=visit.getHin().getRelation().getRelationName()%></label>
 <%
 	} else {
 %>
<label class="value">&nbsp;</label><%
	}
%>


<div class="clear"></div>
<%-- <label >Rank</label>
<%
	if (visit.getHin().getRank() != null) {
%>
<label class="value"><%=visit.getHin().getRank().getRankName()%></label>
<%
	} else {
%> <label class="value">&nbsp;</label><%
 	}
 %> --%>
<label>Name</label> 
<%
 	if (visit.getHin() != null) {
 			Patient patient = visit.getHin();
 			if (patient.getSFirstName() != null
 					&& !(patient.getSFirstName().equals(""))) {

 				String sMiddleName = "";
 				String sLastName = "";
 				if (patient.getSMiddleName() != null) {
 					sMiddleName = patient.getSMiddleName();
 				}
 				if (patient.getSLastName() != null) {
 					sLastName = patient.getSLastName();
 				}
 %> <label
	class="value"><%=patient.getSFirstName() + " " + sMiddleName
								+ " " + sLastName%></label> <%
 	}
 		} else {
 %> <label class="value"></label>
<%
	}
%>
<%-- <label>Unit</label>
 <%
 	if (visit.getHin().getUnit() != null) {
 %>
<label class="value"><%=visit.getHin().getUnit().getUnitName()%></label>
<%
	} else {
%> <label class="value">&nbsp;</label><%
 	}
 %> --%>
<label >Age</label> 
<%
if(visit.getHin().getAge()!= null){
 %>
<label class="value"><%=visit.getHin().getAge() %></label>
<%
 	} else {
 %>
<label class="value">&nbsp;</label><%
	}
%>


 <label>Gender</label>
 <%
 	if (visit.getHin().getSex() != null) {
 %>
<label class="value"><%=visit.getHin().getSex()
							.getAdministrativeSexName()%></label>
<%
	} else {
%> <label class="value">&nbsp;</label><%
 	}
 %>
<%-- <label>Doctor</label>
 <%
 	if (visit.getHin().getServiceNo() != null) {
 %>
<label class="value"><%=visit.getHin().getServiceNo()%></label>
 <%
 	} else {
 %>
<label class="value">&nbsp;</label><%
	}
%> --%>
<div class="clear"></div>
<label>Visit Date</label>
 <%
 	if (visit.getVisitDate() != null) {
 %>
<label class="value"><%=visit.getVisitDate()%></label>
 <%
 	} else {
 %>
<label class="value">&nbsp;</label><%
	}
%>
<label>Visit No.</label>
 <%
 	if (visit.getVisitNo() != null) {
 %>
<label class="value"><%=visit.getVisitNo()%></label>
 <%
 	} else {
 %>
<label class="value">&nbsp;</label><%
	}
%>

<%-- <%
	String diagNo = "";
		Set<PatientPrescriptionHeader> patientPrescriptionHeaderSet = new HashSet<PatientPrescriptionHeader>();
		if (visit.getPatientPrescriptionHeaders()!= null) {
			patientPrescriptionHeaderSet = visit
					.getPatientPrescriptionHeaders();
		}
		if (patientPrescriptionHeaderSet.size() > 0) {
			for (PatientPrescriptionHeader patientPrescriptionHeader : patientPrescriptionHeaderSet) {
				Set<PatientPrescriptionDetails> patientPrescriptionDetailsSet = new HashSet<PatientPrescriptionDetails>();
				if (patientPrescriptionHeader
						.getPatientPrescriptionDetails() != null) {
					patientPrescriptionDetailsSet = patientPrescriptionHeader
							.getPatientPrescriptionDetails();
					diagNo = "" + patientPrescriptionDetailsSet.size();
				}
			}
		}
%>
<label>Diagnosis</label>
<label class="value"><%=diagNo%></label> --%>
</div>


<% 
	    		MasFrequency  masFrequency = new MasFrequency();
	    		  
			     for (int i = 0; i < frequencyList.size(); i++) {
			        	 masFrequency = (MasFrequency) frequencyList.get(i);
     			 %> <script>
	    	  
	          icdArray[<%=i%>]= new Array();
	          icdArray[<%=i%>][0] = "<%=masFrequency.getId()%>";
	          icdArray[<%=i%>][1] = "<%=masFrequency.getFrequencyName()%>";
            </script> <% }%> <% 
	    		String  instructionACPC1 = new String();
	    		  
			     for (int i = 0; i < intakeList.size(); i++) {
			    	 instructionACPC1 = (String) intakeList.get(i);
     			 %> <script>
	    	  
	          instructionACPCArray[<%=i%>]= new Array();
	          instructionACPCArray[<%=i%>][0] = "<%=instructionACPC1%>";
	          instructionACPCArray[<%=i%>][1] = "<%=instructionACPC1%>";
            </script> <% }%> <% 
	    		String  typeLeftRight1 = new String();
	    		  
			     for (int i = 0; i < typeLeftRightList.size(); i++) {
			    	 typeLeftRight1 = (String) typeLeftRightList.get(i);
     			 %> <script>
	    	  
	          typeLeftRightArray[<%=i%>]= new Array();
	          typeLeftRightArray[<%=i%>][0] = "<%=typeLeftRight1%>";
	          typeLeftRightArray[<%=i%>][1] = "<%=typeLeftRight1%>";
            </script> <% }%>
<div class="clear"></div>
<table width="70%" id="indentDetails" border="0" cellpadding="0"
	cellspacing="0">
	<tr>
		<th scope="col">S. No.</th>
		<th scope="col">Material Code</th>
		<th colspan="2">Nomenclature</th>
		<th scope="col">Dosage</th>
		<th scope="col">Frequency</th>
		<th scope="col">No. of Days</th>
		<!--  <th scope="col">Total</th> -->
		<!--<th scope="col">Intake</th>
		 <th scope="col">Type</th> -->
		<th scope="col">Remarks</th>
		<th scope="col">Repeat</th>

	</tr>


	<% 
			
 		 
  					int i=1;
   					System.out.println("patientprescriptionList====="+patientPrescriptionList.size());
  					Iterator itr= patientPrescriptionList.iterator();
  					while(itr.hasNext())
  					{
  						 String dateOfExpiryInString= null;
  						 PatientPrescriptionDetails patientPrescriptionDetail=(PatientPrescriptionDetails)itr.next();
  						 
  			         	 int itemId=patientPrescriptionDetail.getItem().getId();
  			         	 String pvmsNo=patientPrescriptionDetail.getItem().getPvmsNo();
  			       	System.out.println("pvmsNo====="+pvmsNo);
  			        	 String nomenclature=patientPrescriptionDetail.getItem().getNomenclature();
  			        	 String dosage=patientPrescriptionDetail.getDosage();
  			        	 String frequency=patientPrescriptionDetail.getFrequency().getFrequencyName();
  			        	 int frequencyId=patientPrescriptionDetail.getFrequency().getId();
  			        	 int total=patientPrescriptionDetail.getTotal();
  			        	 int noOfDays=patientPrescriptionDetail.getNoOfDays();
  			        	 String typeLeftRight=patientPrescriptionDetail.getType();
  			        	 String instructionACPC = patientPrescriptionDetail.getInstruction();
  			        	 String remarks = patientPrescriptionDetail.getRemarks();
  			        //	 System.out.println("value of pvms no==="+pvmsNo+"===Batch no==="+batchNumber+"==Brand Name==="+brandName);
  			        //	 System.out.println("value of Nomenclature ==="+nomenclature+"===Expiry date==="+dateOfExpiryInString+"====and Brand Id is=== "+brandId);
 			%>

	<tr>
		<td>
		<%=i %>
		</td>
	<td><input type="text" name="pvmsNo<%=i %>" size="6"
			tabindex="1" readonly="readonly" value="<%=pvmsNo %>" /></td>

		<td><input type="text" name="nomenclature<%=i %>" tabindex="1"
			size="20" readonly="readonly" value="<%=nomenclature %>"
			id="nomenclature<%=i %>" />
			</td>
		 <td></td>

		<input type="hidden" name="itemId<%=i %>" value="<%=itemId %>" /></td>





		
		<td><input type="text" name="dosage<%=i%>" size="6" tabindex="1"
			readonly="readonly" value="<%=dosage %>" /></td>

		<td><select name="frequencyId<%=i %>" id="frequencyId<%=i %>"
			tabindex="1" onclick="fillValueFromFrequency(this.value,'<%=i%>');">
			<option value="0">Select</option>
			<%
              
		      for(MasFrequency frequency2 : frequencyList){
		       int id = frequency2.getId();
		       String name = frequency2.getFrequencyName();
		       if(frequency.equals(name)){ %>
			<option value="<%=id %>" selected="selected"><%=name%></option>
			<% }else{ %>
			<option value="<%=id %>"><%=name%></option>
			<% }
          %>

			<%} %>
		</select>
</td>
		<td><input type="text" name="noOfDays<%=i %>" size="6"
			tabindex="1" readonly="readonly" value="<%=noOfDays %>" />
			<input type="hidden" name="total<%=i %>" tabindex="1"
			readonly="readonly" value="<%=total %>" />
			</td>
		
		<%--
		<td><select name="instructionACPC<%=i %>"
			id="instructionACPC<%=i %>" readonly="readonly" tabindex="1">
			<option value="">Select</option>
			<%
              
		      for(String inttakeString : intakeList){

		       if(inttakeString.equals(instructionACPC)){ %>
			<option value="<%=inttakeString %>" selected="selected"><%=inttakeString%></option>
			<% }else{ %>
			<option value="<%=inttakeString %>"><%=inttakeString%></option>
			<% }
          %>

			<%} %>
		</td>
 --%>
           <% if(patientPrescriptionDetails.getRemarks()!=null)
            { %>
        <td><input type="text" name="remarks<%=i %>" tabindex="1" id="remarks<%=i %>" value="<%=remarks%>" size="10" maxlength="40"/>
			</td>
			<% }else{%>
			<td><input type="text" name="remarks<%=i %>" tabindex="1" id="remarks<%=i %>" size="10" value="" maxlength="40"/>
			</td>
			<% }%>
			<td>
			<input type="checkbox" name="repeatPrescription<%=i %>" />
		</td>
	</tr>
	<%
  	 	i++;
  	   }
  	 %>

</table>



<div class="clear"></div>

<input id="save" type="button" tabindex="1" name="save"	value="Repeat" class="button"	onclick="setValuesInParentForPrescription('patientPrescription')" />
<!--<input type="button" name="cancel" id="addbutton" value="Cancel"	class="button" onClick="cancelForm();" accesskey="a" tabindex=1 />-->
<input	type="hidden" name="counter" id="counter" value="<%=i %>" />
</div>
<%}else{ %>
<h4>No Records Found!!</h4>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="cancel" id="addbutton" value="Cancel" class="button" onClick="cancelForm();" accesskey="a" tabindex=1 />
<%} %>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div id="edited"></div>
</form>

<script type="text/javascript">

	function setValuesInParentForPrescription(formname){
  	//	formName=formname.name;

		var grid = window.opener.document.getElementById("grid").rows.length;
	//	var investigationGrid = window.opener.document.getElementById("investigationGrid").rows.length;
		//if(investigationGrid>2){
		//	var rows=investigationGrid-2
		//  	alert("Please fill prescription before investigation for that Delete "+ rows+"  rows From Investigation .")
		//  	return;
		//}
		//if(grid>2){
		// 	var rows=grid-2
		//  	alert("Please Delete "+ rows+"  rows From Drugs .")
		//  	return;
		//}
		
		
		//alert("value of counter--"+document.patientPrescription.counter.value)
 		var hdbVal = window.opener.document.getElementById('hdb').value;
 		var nomenclatureVal = window.opener.document.getElementById('nomenclature1').value;

		if(hdbVal == 1 && nomenclatureVal == ''){
			var len = window.opener.document.getElementById("grid").rows.length;
			var r1 = window.opener.document.getElementById("grid").deleteRow(len-1);
		}
		
		for(var index = 1; index < parseInt(document.patientPrescription.counter.value); index++ ){
			var toEval = "document.patientPrescription.repeatPrescription" + index;
			var repeatIn = eval(toEval);
			if(repeatIn.checked == true){
			
				  var len = window.opener.document.getElementById("grid").rows.length;
				  //var r1 = window.opener.document.getElementById("grid").deleteRow(len-1);
				  //alert(r1);
				  var r = window.opener.document.getElementById("grid").insertRow(len);
				  
				  var c1 = r.insertCell(0);
				  var c_img = r.insertCell(1);
				  var c2 = r.insertCell(2);
				  var c3 = r.insertCell(3);
				  var c4 = r.insertCell(4);
				  var c5 = r.insertCell(5);
				 // var c6 = r.insertCell(6);
				  var c7 = r.insertCell(6);
				  var c8 = r.insertCell(7);	
				  var c9 = r.insertCell(8);
				  var c10 = r.insertCell(9);	
				 // var c11 = r.insertCell(10);			
				  	
				  var nomenclature=eval('document.'+formName+'.nomenclature' + index + '.value')
				  var pvmsNo=eval('document.'+formName+'.pvmsNo' + index + '.value')
				  
				  var divElement = document.createElement('div');
				  divElement.id = 'ac2update1';
				  divElement.style.display = 'none';
				  //divElement.style.fontWeight = 'normal;';
				  //divElement.style.border = '0px solid white;';
				  divElement.style.paddingRight = '10px;';
				 // divElement.style.backgroundColor = 'white;';

				  c1.appendChild(divElement);
				  
				  
				  var x1 = document.createElement('input');
				  x1.type = 'text';
				  x1.name='nomenclature'+len;
				  x1.id='nomenclature'+len;
				  x1.size = '50';
	  			  x1.setAttribute('tabindex','1');	 				  
				  x1.value = nomenclature+"["+pvmsNo+"]";;
				  
				  //x1.setAttribute("readonly","readonly");
				  c1.appendChild(x1);
	  			  //new Ajax.Autocompleter('nomenclature'+len,'ac2update1','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature'+len});
                  
				  
				  var eImg = document.createElement('img');
				  eImg.src = '/hms/jsp/images/search.gif';
				  eImg.name = 'search' + len;
				  eImg.id = 'search' + len;
				  eImg.WIDTH = '26';
				  eImg.HEIGHT = '26';
				  //eImg.id = 'billDateId'+iteration;
				  eImg.onclick = function(){
				   var url="/hms/hms/opd?method=showItemSearchJsp&count="+len;
				    newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0"); };
				    c_img.appendChild(eImg);
				  
				  var x2 = document.createElement('input');
				  x2.type = 'text';
				  x2.name='pvmsNo'+len;
				  x2.id='pvmsNo'+len;
				  x2.size = '10';
	  			  x2.setAttribute('tabindex','1');				  
				  x2.value = eval('document.'+formName+'.pvmsNo' + index + '.value');
				  x2.setAttribute("readonly","readonly");
				  c2.appendChild(x2);

				  var x3 = document.createElement('input');
				  x3.type = 'text';
				  x3.name='dosage'+len;
				  x3.id='dosage'+len;
				  x3.size = '5';
	  			  x3.setAttribute('tabindex','1');				  
				  x3.value = eval('document.'+formName+'.dosage' + index + '.value');
				  //x3.setAttribute("readonly","readonly");
				  c3.appendChild(x3);

				  var x4 = document.createElement('Select');
				  //x4.type = 'hidden';
				  x4.name='frequency'+len;
				  x4.id='frequency'+len;
				  x4.classname='smalllabel';
				  
				  x4.options[0] = new Option('Select', '0');
				  selectedFrequency = eval('document.'+formName+'.frequencyId' + index + '.value');
	   		      for(var i = 0;i<icdArray.length;i++ ){
	   		      	if(selectedFrequency == icdArray[i][0]){
	   		      		x4.options[i+1] = new Option(icdArray[i][1],icdArray[i][0]);
	   		      		x4.options[i+1].setAttribute('Selected','Selected');
	   		      	}else{
	      		  		x4.options[i+1] = new Option(icdArray[i][1],icdArray[i][0]);
	   		      	}
	      		  }
	      		  
	      		  
	  			  x4.setAttribute('tabindex','1');	
				  //x4.onclick=function(){
	  			  	//var val=x5.value;
	  			  	//var freq=x4.value;
	  						//alert("frequency-----");
	  			  // document.getElementById('total'+iteration).value=val*freq;
	  			  //}
	  			  			  
				  c4.appendChild(x4);

				  var x5 = document.createElement('input');
				  x5.type = 'text';
				  x5.name='noOfDays'+len;
				  x5.id='noOfDays'+len;
				  x5.size = '3';
	  			  x5.setAttribute('tabindex','1');				  
				  x5.value = eval('document.'+formName+'.noOfDays' + index + '.value');
				  //x5.setAttribute("readonly","readonly");
				  c5.appendChild(x5);

				  

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

				 /* var x8 = document.createElement('Select');
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
				  var x8 = document.createElement('input');
				  x8.type = 'text';
				  x8.name='remarks'+len;
				  x8.id='remarks'+len;
				  x8.size = '10';
	  			  x8.setAttribute('tabindex','1');				  
				  x8.value = eval('document.'+formName+'.remarks' + index + '.value');
				  //x5.setAttribute("readonly","readonly");
				  c8.appendChild(x8);
				  
				  var x9 = window.opener.document.getElementById('hdb');
				  x9.value=len;
				 
				  var x10 = document.createElement('input');
				  x10.type = 'button';
				  //x11.name='remarks'+len;
				 // x11.id='remarks'+len;
				  x10.className = 'buttonAdd';
	  			  x10.setAttribute('tabindex','1');	
	  			  x10.setAttribute('onClick', 'addRow();'); 			  
				  //x11.value = eval('document.'+formName+'.remarks' + index + '.value');
				  //x5.setAttribute("readonly","readonly");
				  c9.appendChild(x10);

				  var x11 = document.createElement('input');
				  x11.type = 'button';
				  //x11.name='remarks'+len;
				 // x11.id='remarks'+len;
				  x11.className = 'buttonDel';
	  			  x11.setAttribute('tabindex','1');	
	  			  x11.setAttribute('onClick', 'removeRow();'); 			  
				  //x11.value = eval('document.'+formName+'.remarks' + index + '.value');
				  //x5.setAttribute("readonly","readonly");
				  c10.appendChild(x11);
				  
				 
				  //alert("value of hdb----"+x8.value)
			}
		}
		
	window.close();		
  	}
		
	
		
	
		
</script>



