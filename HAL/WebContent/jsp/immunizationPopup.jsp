<%@page import="java.util.Calendar"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.PatientImmunizationDetails"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasImmunization"%>

<%@page import="jkt.hms.masters.business.InjAppointmentDetails"%>
<%@page import="jkt.hms.masters.business.StoreOpPatientIssueT"%>
<%@page import="jkt.hms.masters.business.InjAppointmentHeader"%><link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<!--[if lt IE 9]>
        <link href="/hms/jsp/css/ie.css" rel="stylesheet" type="text/css" />
<![endif]-->
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
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
	<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<PatientImmunizationDetails> immunizationList = new ArrayList<PatientImmunizationDetails>();
	
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if(map.get("immunizationList") != null){
		immunizationList = (List<PatientImmunizationDetails>)map.get("immunizationList");
	}
	List<MasImmunization> masImmunizationList = new ArrayList<MasImmunization>();
	if(map.get("masImmunizationList") != null){
		masImmunizationList = (List<MasImmunization>)map.get("masImmunizationList");
	}
	List<StoreOpPatientIssueT> storeOpPatientIssueTList = new ArrayList<StoreOpPatientIssueT>();
	if(map.get("storeOpPatientIssueTList") != null){
		storeOpPatientIssueTList = (List<StoreOpPatientIssueT>)map.get("storeOpPatientIssueTList");
	}
	List<InjAppointmentDetails> injAppointmentDetailList = new ArrayList<InjAppointmentDetails>();
	if(map.get("injAppointmentDetailList") != null){
		injAppointmentDetailList = (List<InjAppointmentDetails>)map.get("injAppointmentDetailList");
	}
	
	String flag="";
	if(map.get("flag") != null){
		flag = (String)map.get("flag");
	}
	int hinId=0;
	if(map.get("hinId") != null){
		hinId = (Integer)map.get("hinId");
	}
	String message="";
	if(map.get("message") != null){
		message = (String)map.get("message");
	}
	%>
<form name="immunizationPopup" action="" method="post">
<h4><%=message %></h4>
<h4>Immunization Details</h4>
<div class="Clear"></div>
<div id="pageNavPosition"></div>
<div class="Clear"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0" id="immunizationgrid">

<tr>
		<th scope="col">Vaccine</th>
		<th scope="col">Dose</th>
		<th scope="col">Route</th>
		<th scope="col">Given on</th>
		<th scope="col">Batch No.</th>
		<th scope="col">DOM</th>
		<th scope="col">DOE</th>
		<th>Add</th>
		<th>Delete</th>
	</tr>
	<%int i=0;
	String immName = "";
		if(immunizationList.size() > 0){
			for(PatientImmunizationDetails patientImmunizationDetails : immunizationList){
				i++;
			
	%>
	<tr>
		<td>
		<%--<input type="hidden" name="immunizationDetailsId<%=i %>" id="immunizationDetailsId<%=i %>" value="<%=patientImmunizationDetails.getImmunization().getId()  %>" />--%><!--
		 <input type="hidden" name="immunizationId<%=i %>" id="immunizationId<%=i %>" value="<%//=patientImmunizationDetails.getImmunization().getId()  %>" />
		--><input type="hidden" name="immunId<%=i %>" id="immunId<%=i %>" value="<%=patientImmunizationDetails.getId()  %>" />
		<input type="text" name="immunizationName<%=i %>" id="immunizationName<%=i %>" value="<%=patientImmunizationDetails.getImmunizationDetail()!=null?patientImmunizationDetails.getImmunizationDetail():"" %>" size="40" maxlength="80"/>
	   <input type="hidden" name="immunizationId<%=i %>" id="immunizationId<%=i %>" value="0" />
		
		<!--<input type="text" name="immunizationName<%=i %>" id="immunizationName<%=i %>" value="<%=immName!=null?immName:"" %>" size="40" onblur="if(this.value!=''){getImmunizationId(this.value,1);}"/>-->
	   <div id="ac2update1" style=" display:none; " class="autocomplete"></div>
		</td>
		<td><input	type="text" name="dose<%=i %>" value="<%= (patientImmunizationDetails.getDose()!=null?patientImmunizationDetails.getDose():"") %>" id="dose<%=i %>" size="5" maxlength="5"/></td>
		<td><input	type="text" name="route<%=i %>" value="<%= (patientImmunizationDetails.getRoute()!=null?patientImmunizationDetails.getRoute():"") %>" id="route<%=i %>" size="10" maxlength="20"/></td>
		<td>	
			<input	type="text" name="date<%=i %>" value="<%= (patientImmunizationDetails.getImmunizationDate()!=null?HMSUtil.convertDateToStringWithoutTime(patientImmunizationDetails.getImmunizationDate()):"") %>" id="date<%=i %>" size="10" readonly="readonly">
			<img id="calender" src="/hms/jsp/images/cal.gif" validate="Pick a date" class="calender"
		onClick="setdate('',document.immunizationPopup.date<%=i %>,event)" /> 
			
			</td>
			<td><input	type="text" name="batchNo<%=i %>" value="<%= (patientImmunizationDetails.getBatchNo()!=null?patientImmunizationDetails.getBatchNo():"") %>" id="batchNo<%=i %>" size="10" maxlength="10"/></td>
		<td>	
			<input	type="text" name="dom<%=i %>" value="<%= (patientImmunizationDetails.getDom()!=null?HMSUtil.convertDateToStringWithoutTime(patientImmunizationDetails.getDom()):"") %>" id="dom<%=i %>" size="10" readonly="readonly"/>
			<img id="calender" src="/hms/jsp/images/cal.gif" validate="Pick a date" class="calender"
			onClick="setdate('',document.immunizationPopup.dom<%=i %>,event)" /> 
			</td>
			<td>	
			<input	type="text" name="doe<%=i %>" value="<%= (patientImmunizationDetails.getDoe()!=null?HMSUtil.convertDateToStringWithoutTime(patientImmunizationDetails.getDoe()):"") %>" id="doe<%=i %>" size="10"  readonly="readonly"/>
			<img id="calender" src="/hms/jsp/images/cal.gif" validate="Pick a date" class="calender"
			onClick="setdate('',document.immunizationPopup.doe<%=i %>,event)" /> 
			</td>
		<td><input name="Button" type="button" class="buttonAdd" value=""
			onclick="addRow();" tabindex="1" /></td>
			<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow(this,<%=i %>);" tabindex="1" />
			</td>
	</tr>
	<%}} %>
	<%int j=0;
	String immNameInj = "";
	String dose = "";
	String route = "";
	int noOfDays = 0;
	
		if(storeOpPatientIssueTList.size() > 0){
			for(StoreOpPatientIssueT storeOpIssueT : storeOpPatientIssueTList){
				i++;
			if(injAppointmentDetailList.size()>0){
			for(InjAppointmentDetails injAppointmentDetails :injAppointmentDetailList){
			if(storeOpIssueT.getOpIssue().getPatientPrescriptionHeader().getId().equals(injAppointmentDetails.getInjAppointmentHeader().getPrescription().getId()) &&
					storeOpIssueT.getItemIdIssue().getId().equals(injAppointmentDetails.getItem().getId())){
				dose = injAppointmentDetails.getDose();
				route = injAppointmentDetails.getRoute();
				noOfDays = injAppointmentDetails.getNoOfDays();
				break;
			  }
			 }
			}
	%>
	<tr>
		<td>
		<%--<input type="hidden" name="immunizationDetailsId<%=i %>" id="immunizationDetailsId<%=i %>" value="<%=patientImmunizationDetails.getImmunization().getId()  %>" />--%><%--
		 <input type="hidden" name="immunizationId<%=i %>" id="immunizationId<%=i %>" value="<%//=patientImmunizationDetails.getImmunization().getId()  %>" /> --%>
		<input type="hidden" name="storeOpIssueTId<%=i %>" id="storeOpIssueTId<%=i %>" value="<%=storeOpIssueT.getId()  %>" />
		<input type="text" name="" id="" value="<%=storeOpIssueT.getItemIdIssue()!=null?storeOpIssueT.getItemIdIssue().getNomenclature():"" %>" size="40" maxlength="80"/>
	   <input type="hidden" name="immunizationId<%=i %>" id="immunizationId<%=i %>" value="0" />
		
		<%--<input type="text" name="immunizationName<%=i %>" id="immunizationName<%=i %>" value="<%=immName!=null?immName:"" %>" size="40" onblur="if(this.value!=''){getImmunizationId(this.value,1);}"/>--%>
	   <div id="ac2update1" style=" display:none; " class="autocomplete"></div>
		</td>
		
		<td><input	type="text" name="dose<%=i %>" value="<%= (dose!=null?dose:"") %>" id="dose<%=i %>" size="5" maxlength="5"/></td>
		<td><input	type="text" name="route<%=i %>" value="<%= (route!=null?route:"") %>" id="route<%=i %>" size="10" maxlength="20"/></td>
		<td>	
			<input	type="text" name="date<%=i %>" value="<%= (storeOpIssueT.getOpIssue().getIssueDate()!=null?HMSUtil.convertDateToStringWithoutTime(storeOpIssueT.getOpIssue().getIssueDate()):"") %>" id="date<%=i %>" size="10" readonly="readonly">
			<img id="calender" src="/hms/jsp/images/cal.gif" validate="Pick a date" class="calender"
		onClick="setdate('',document.immunizationPopup.date<%=i %>,event)" /> 
			
			</td>
			<td><input	type="text" name="batchNo<%=i %>" value="<%= (storeOpIssueT.getBatchNo()!=null?storeOpIssueT.getBatchNo():"") %>" id="batchNo<%=i %>" size="10" maxlength="10"/></td>
		<td>	
			<input	type="text" name="dom<%=i %>" value="" id="dom<%=i %>" size="10" readonly="readonly"/>
			<img id="calender" src="/hms/jsp/images/cal.gif" validate="Pick a date" class="calender"
			onClick="setdate('',document.immunizationPopup.dom<%=i %>,event)" /> 
			</td>
			<td>	
			<input	type="text" name="doe<%=i %>" value="<%= (storeOpIssueT.getExpiryDate()!=null?HMSUtil.convertDateToStringWithoutTime(storeOpIssueT.getExpiryDate()):"") %>" id="doe<%=i %>" size="10"  readonly="readonly"/>
			<img id="calender" src="/hms/jsp/images/cal.gif" validate="Pick a date" class="calender"
			onClick="setdate('',document.immunizationPopup.doe<%=i %>,event)" /> 
			</td>
		<td><input name="Button" type="button" class="buttonAdd" value=""
			onclick="addRow();" tabindex="1" /></td>
			<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow(this,<%=i %>);" tabindex="1" />
			</td>
	</tr>
	<%} %>
	<% 
	}

		if(immunizationList.size() == 0 && storeOpPatientIssueTList.size()==0){i++;%>
	<tr>
		<td>
		<input type="hidden" name="immunId<%=i %>" id="immunId<%=i %>" value="0" />
		
		<input type="text" name="immunizationName<%=i %>" id="immunizationName<%=i %>" value="" size="40"  maxlength="80"/>
		<%--<input type="hidden" name="immunizationDetailsId<%=i %>" id="immunizationDetailsId<%=i %>" value="0" />--%>
		<!--<input type="text" name="immunizationName<%=i %>" id="immunizationName<%=i %>" value="" size="40" onblur="if(this.value!=''){getImmunizationId(this.value,1);}"/>
		--><input type="hidden" name="immunizationId<%=i %>" id="immunizationId<%=i %>" value=""/>
		     <div id="ac2update1" style=" display:none; " class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
		//	  new Ajax.Autocompleter('immunizationName<%=i %>','ac2update1','registration?method=getImmunizationForAutoComplete',{parameters:'requiredField=immunizationName<%=i %>'});
			</script>
		</td>
		<td><input	type="text" name="dose<%=i %>" value="" id="dose<%=i %>" size="5" maxlength="5"/></td>
		<td><input	type="text" name="route<%=i %>" value="" id="route<%=i %>" size="10" maxlength="20"/></td>
		<td>	
			<input	type="text" name="date<%=i %>" value="" id="date<%=i %>" size="10" readonly="readonly">
			<img id="calender" src="/hms/jsp/images/cal.gif" validate="Pick a date" class="calender"
			onClick="setdate('',document.immunizationPopup.date1,event)" /> 
			
			</td>
			<td><input	type="text" name="batchNo<%=i %>" value="" id="batchNo<%=i %>" size="10" maxlength="10"/></td>
		<td>	
			<input	type="text" name="dom<%=i %>" value="" id="dom<%=i %>" size="10" readonly="readonly"/>
			<img id="calender" src="/hms/jsp/images/cal.gif" validate="Pick a date" class="calender"
			onClick="setdate('',document.immunizationPopup.dom1,event)" /> 
			</td>
			<td>	
			<input	type="text" name="doe<%=i %>" value="" id="doe<%=i %>" size="10"  readonly="readonly"/>
			<img id="calender" src="/hms/jsp/images/cal.gif" validate="Pick a date" class="calender"
			onClick="setdate('',document.immunizationPopup.doe1,event)" /> 
			</td>
		<td><input name="Button" type="button" class="buttonAdd" value=""
			onclick="addRow();" tabindex="1" /></td>
			<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow(this,<%=i %>);" tabindex="1" />
			</td>
	</tr>
	<%} %>
	</table>
	<div class="clear"></div>
	<input type="hidden" name="count" value="<%=i %>" id="count" />
	<input type="hidden" name="hinId" value="<%=hinId %>" id="hinId" />
	<input type="hidden" id="deleteVal" name="deleteVal" value="" id="deleteId" />
	<% 
	if(flag.equalsIgnoreCase("medicalExam") || flag.equalsIgnoreCase("fwc") || flag.equalsIgnoreCase("sho"))
	 {
	 %>
	<input type="button" name="Ok" value="Ok" class="button" onclick="submitForm('immunizationPopup','registration?method=saveImmunizationDetails');" tabindex="1" />
	<input type="button" name="Close" value="Close" class="button" onclick="window.close()" tabindex="1" />
	
	<%}else{ %>
	<input type="button" name="Ok" value="Ok" class="button" onclick="setValuesInParent();" tabindex="1" />
	<input type="button" name="Close" value="Close" class="button" onclick="window.close()" tabindex="1" />

	<%} %>		
</form>

<script>
function getImmunizationId(immu,rowval){
	 var xmlHttp;
	  try {
	    // Firefox, Opera 8.0+, Safari
	    xmlHttp=new XMLHttpRequest();
	  }catch (e){
	    // Internet Explorer
	    try{
	      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
	    }catch (e){
	    	alert(e)
	      try{
	        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	      }catch (e){
	        alert("Your browser does not support AJAX!");
	        return false;
	      }
	     }
	   }
	 
	    xmlHttp.onreadystatechange=function()
	    {
	      if(xmlHttp.readyState==4){
	      
	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	      
	      	for (loop = 0; loop < items.childNodes.length; loop++) {
		   	    var item = items.childNodes[loop];
		       
		        var immunizationId  = item.getElementsByTagName("immunizationId")[0];
		        document.getElementById('immunizationId'+rowval).value = immunizationId.childNodes[0].nodeValue;
		               
	      	} 
	      }
	    }

	    var index1 = immu.lastIndexOf("[");
	    var index2 = immu.lastIndexOf("]");
	    index1++;
	    var immunization = immu.substring(index1,index2);
	  if(immunization!=''){
	  	 var url="/hms/hms/registration?method=getImmunizationId&immunizationCode="+immunization+"&rowval="+rowval;
	  
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);

	  }
}



function addRow(){
		
		  var tbl = document.getElementById('immunizationgrid');
		  var lastRow = tbl.rows.length;

		  var iteration = lastRow;
		  var row = tbl.insertRow(lastRow);
		  var hdb = document.getElementById('count');
		  var iteration = parseInt(hdb.value)+1;
		  hdb.value = iteration;

		  
		  var cell1 = row.insertCell(0);
		  var e1 = document.createElement('input');
		  e1.type = 'text';
		  e1.size = '40';
		  e1.maxlength = '80';
		  e1.name='immunizationName'+iteration;
		  e1.id='immunizationName'+iteration
		//  e1.onblur=function() {if(this.value!=""){getImmunizationId(this.value,iteration);}}
		  cell1.appendChild(e1);
		 // new Ajax.Autocompleter('immunizationName'+iteration,'ac2update1','registration?method=getImmunizationForAutoComplete',{parameters:'requiredField=immunizationName'+iteration});
		  var e11 = document.createElement('input');
	 	  e11.type = 'hidden';
		  e11.name='immunizationId'+iteration;
		  e11.id='immunizationId'+iteration
		  cell1.appendChild(e11);

		  var e12 = document.createElement('input');
		  e12.type = 'hidden';
		  e12.name='immunId'+(iteration);
		  e12.id='immunId'+(iteration);
		  e12.value='0';
		  cell1.appendChild(e12);

		  var cell2 = row.insertCell(1);
		  var e2 = document.createElement('input');
		  e2.type = 'text';
		  e2.name='dose'+iteration;
		  e2.id='dose'+iteration
		  e2.size = '5';
		  e2.maxLength = '5';
		  e2.tabindex='1';
		  cell2.appendChild(e2);


		  var cell3 = row.insertCell(2);
		  var e3 = document.createElement('input');
		  e3.type = 'text';
		  e3.name='route'+iteration;
		  e3.id='route'+iteration
		  e3.maxLength = '5';
		  e3.size = '10';
		  e3.tabindex='1';
		  cell3.appendChild(e3);
		  
		  var cell4 = row.insertCell(3);
		  var e4 = document.createElement('input');
		  e4.type = 'text';
		  e4.name='date'+iteration;
		  e4.id='date'+iteration
		  e4.size = '10';
		  e4.tabindex='1';
		  e4.readOnly='true';
		  var e4Img = document.createElement('img');
		  e4Img.src = '/hms/jsp/images/cal.gif';
		  e4Img.className = 'calender';
		  e4Img.id = 'calender'+iteration;
		  e4Img.onclick = function(event){
						setdate('',document.getElementById('date'+iteration),event) };
		  cell4.appendChild(e4);
		  cell4.appendChild(e4Img);
		  
		  var cell5 = row.insertCell(4);
		  var e5 = document.createElement('input');
		  e5.type = 'text';
		  e5.name='batchNo'+iteration;
		  e5.id='batchNo'+iteration
		  e5.size = '10';
		  e2.maxLength = '10';
		  e5.tabindex='1';
		  cell5.appendChild(e5);

		  var cell6 = row.insertCell(5);
		  var e6 = document.createElement('input');
		  e6.type = 'text';
		  e6.name='dom'+iteration;
		  e6.id='dom'+iteration
		  e6.size = '10';
		  e6.tabindex='1';
		  e6.readOnly='true';	
		  var e6Img = document.createElement('img');
		  e6Img.src = '/hms/jsp/images/cal.gif';
		  e6Img.className = 'calender';
		  e6Img.id = 'calender'+iteration;
		  e6Img.onclick = function(event){
						setdate('',document.getElementById('dom'+iteration),event) };
		  cell6.appendChild(e6);
		  cell6.appendChild(e6Img);


		  var cell7 = row.insertCell(6);
		  var e7 = document.createElement('input');
		  e7.type = 'text';
		  e7.name='doe'+iteration;
		  e7.id='doe'+iteration
		  e7.size = '10';
		  e7.readOnly='true';
		  e7.tabindex='1';
		  var e7Img = document.createElement('img');
		  e7Img.src = '/hms/jsp/images/cal.gif';
		  e7Img.className = 'calender';
		  e7Img.id = 'calender'+iteration;
		  e7Img.onclick = function(event){
						setdate('',document.getElementById('doe'+iteration),event) };
		  cell7.appendChild(e7);
		  cell7.appendChild(e7Img);
		  
		  var cell8 = row.insertCell(7);
		  var e8 = document.createElement('input');
		  e8.type = 'button';
		  e8.className = 'buttonAdd';
		  e8.name='Button'+iteration;
		  e8.onclick = function(){addRow();}; 
		  e8.tabindex='1';
		  cell8.appendChild(e8);

		  var cell9 = row.insertCell(8);
		  var e9 = document.createElement('input');
		  e9.type = 'button';
		  e9.className = 'buttonDel';
		  e9.name='delete'+iteration;
		  e9.onclick = function(){removeRow(this,iteration);}; 
		  e9.tabindex='1';
		  cell9.appendChild(e9);
}


function setValuesInParent(){
	var count = document.getElementById('count').value;
	  var tbl = window.opener.document.getElementById('immuGrid');
	  var flag = '';
	  for(var i=1;i<=count;i++){
		  if(document.getElementById('immunizationName'+i) && document.getElementById('immunizationName'+i).value!=''){
				  flag = 'filled';
			  break;
		  }else{
			flag='';
		  }
	  }
	  /*if(flag == ''){
		alert("Please fill data.");
		return false;
	  }*/

	  for(var i = tbl.rows.length - 1; i > 0; i--)
	  {
	      tbl.deleteRow(i);
	  }
	  
	for(var i=1;i<=count;i++){
	  var immCount = window.opener.document.getElementById('immCount').value
	 	if(document.getElementById('immunizationName'+i) ){
		var lastRow = tbl.rows.length;
		var row = tbl.insertRow(lastRow);

		var iteration = parseInt(immCount);
		var cell0 = row.insertCell(0);
		var e0 = window.opener.document.createElement('input');
	    e0.type = 'text';
	    e0.name='immunizationName'+(iteration+1);
	    e0.id='immunizationName'+(iteration+1);
	    e0.value = document.getElementById('immunizationName'+i).value;
	    cell0.appendChild(e0);

		var e1 = window.opener.document.createElement('input');
	    e1.type = 'text';
	    e1.name='vdate'+(iteration+1);
	    e1.id='vdate'+(iteration+1);
	    e1.value = document.getElementById('date'+i).value;
	    cell0.appendChild(e1);

	    var e2 = window.opener.document.createElement('input');
	    e2.type = 'text';
	    e2.name='dose'+(iteration+1);
	    e2.id='dose'+(iteration+1);
	    e2.value = document.getElementById('dose'+i).value;
	    cell0.appendChild(e2);

	    var e3 = window.opener.document.createElement('input');
	    e3.type = 'text';
	    e3.name='route'+(iteration+1);
	    e3.id='route'+(iteration+1);
	    e3.value = document.getElementById('route'+i).value;
	    cell0.appendChild(e3);


	    var e4 = window.opener.document.createElement('input');
	    e4.type = 'text';
	    e4.name='batchNo'+(iteration+1);
	    e4.id='batchNo'+(iteration+1);
	    e4.value = document.getElementById('batchNo'+i).value;
	    cell0.appendChild(e4);


	    var e5 = window.opener.document.createElement('input');
	    e5.type = 'text';
	    e5.name='dom'+(iteration+1);
	    e5.id='dom'+(iteration+1);
	    e5.value = document.getElementById('dom'+i).value;
	    cell0.appendChild(e5);


	    var e6 = window.opener.document.createElement('input');
	    e6.type = 'text';
	    e6.name='doe'+(iteration+1);
	    e6.id='doe'+(iteration+1);
	    e6.value = document.getElementById('doe'+i).value;
	    cell0.appendChild(e6);

	    var e7 = window.opener.document.createElement('input');
	   e7.type = 'text';
	    e7.name='immunId'+(iteration+1);
	    e7.id='immunId'+(iteration+1);
	    if(document.getElementById('immunId'+i))
	  	  e7.value = document.getElementById('immunId'+i).value;
	    cell0.appendChild(e7);

	 
	 /*   var e8 = window.opener.document.createElement('input');
	    e8.type = 'text';
	    e8.name='immunizationId'+(iteration+1);
	    e8.id='immunizationId'+(iteration+1);
	    e8.value = document.getElementById('immunizationId'+i).value;
	    cell0.appendChild(e8);*/
	    
	    window.opener.document.getElementById('immCount').value = (iteration+1);
	 	}
	}
	window.close();
}
function removeRow(obj,inc)
{
	 // First reset values
	 document.getElementById('immunizationName'+(inc)).value='';
	 document.getElementById('immunizationId'+(inc)).value='';
	 document.getElementById('immunId'+(inc)).value='';
	 document.getElementById('dose'+(inc)).value='';
	 document.getElementById('route'+(inc)).value='';
	 document.getElementById('date'+(inc)).value='';
	 document.getElementById('batchNo'+(inc)).value='';
	 document.getElementById('dom'+(inc)).value='';
	 document.getElementById('doe'+(inc)).value='';
	  
  var tbl = document.getElementById('immunizationgrid');
  var lastRow = tbl.rows.length;

   var i=obj.parentNode.parentNode.rowIndex;
  if(document.getElementById('immunId'+(inc)))
  {	  
    var immuniId=document.getElementById('immunId'+(inc)).value;
    var val=document.getElementById('deleteVal').value;
    var finalVal=val+","+immuniId;
  }  
 
  document.getElementById('deleteVal').value=finalVal;
  if (lastRow > 2)
  {
	 
     tbl.deleteRow(i);
  
  }
}
</script>