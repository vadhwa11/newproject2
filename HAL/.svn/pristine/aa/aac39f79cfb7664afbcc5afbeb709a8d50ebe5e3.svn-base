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
<%@page import="jkt.hms.masters.business.StoreFyDocumentNo"%>

<%@page import="jkt.hms.masters.business.MasDisposal"%>

<%@page import="jkt.hms.masters.business.Patient"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
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
		String time = (String)utilMap.get("currentTimeWithoutSc");
 
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
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		if(map.get("doctorList") != null){
			doctorList= (List<MasEmployee>)map.get("doctorList");
		}
		
		List<MasDisposal> disposalList = new ArrayList<MasDisposal>();
		if(map.get("disposalList") != null){
			disposalList= (List<MasDisposal>)map.get("disposalList");
		}
		
		List<Patient> patientList = new ArrayList<Patient>();
		if(map.get("patientList")!=null){
			patientList = (List<Patient>)map.get("patientList");
		}
		
	%>
	<h4><%=message %></h4>
<div class="titleBg"><h2>DMA Register</h2></div>


<!--<label>Reported Date</label>
--><input	type="hidden" name="<%=REPORTED_DATE %>" value="<%= currentDate %>" id="reportedDate" validate="Reported Date,string,no" class="date" readonly="readonly"/>
<!--<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" 
class="calender"	onClick="setdate('<%=currentDate %>',document.dmaRegister.reportedDate,event)" /> 
--><!--<label>Reported Time</label>
--><input	type="hidden" name="<%=REPORTED_TIME %>" value="<%= time %>" id="reportedTime" validate="Reported Time,string,no" class="date" readonly="readonly"/>

<div class="Clear"></div>
<h4>Patient Details</h4>
<div class="Clear"></div>
<div id="pageNavPosition"></div>
<div class="Block">
<label>Service No. <span>*</span> </label> 
<input type="text" id="serviceNo" name="<%= SERVICE_NO %>" value="" onblur="if(this.value!=''){submitProtoAjax('dmaRegister','/hms/hms/registration?method=getHinNoForDMA');}" validate="Service No,metachar,yes">
<label>HIN <span>*</span></label> 
<div id="testDiv">
<input type="text" id="hinNo" name="<%= HIN_NO %>" value="" />
<input type="hidden" id="hinId" name="hinId" value="0"/>
</div>
<label>Patient Name</label> 
<input type="text" id="patientName" name="" value="" readonly="readonly">
<input type="hidden" name="visitId" id="visitId" value=""/>


 <div class="Clear"></div>
<label>Relation</label> 
<input type="text" id="relation" name="" value="" readonly="readonly"> 
 
<label>Rank</label> 
<input type="text" id="rank" name="" value="" readonly="readonly">

<label>Name</label> 
<input type="text" id="serPersName" name="" value="" readonly="readonly">
<div class="Clear"></div>

<label>Command</label> 
<input type="text" id="command" name="" value="" readonly="readonly">

<label>Station</label> 
<input type="text" id="station" name="" value="" readonly="readonly">


<label>Unit</label> 
<input type="text" id="unit" name="" value="" readonly="readonly">

<div class="Clear"></div>

<label>Branch/Trade</label> 
<input type="text" id="trade" name="" value="" readonly="readonly">

<label>Age</label> 
<input type="text" id="age" name="age" value="" readonly="readonly">

<label>Gender</label> 
<input type="text" id="sex" name="" value="" readonly="readonly">

<div class="Clear"></div>
<label>Blood Group</label> 
<input type="text" id="bldGrp" name="" value="" readonly="readonly">

<label>Contact No.</label> 
<input type="text" id="mobileNo" name="" value="" readonly="readonly">
<label>Marital Status</label> 
<input type="text" id="mrstatus" name="" value="" readonly="readonly">

<div class="Clear"></div>
</div>
<div class="Clear"></div>
<h4>DMA Details</h4>
<div class="Clear"></div>
<div id="pageNavPosition"></div>
<div class="Block">
<label>Complaints</label>
<input type="text" id="complaints" name="<%= COMPLAINT_DESC %>" value="" maxlength="200">
<!--<textarea name="<%= COMPLAINT_DESC %>" rows="" cols=""></textarea>
--><label>Working Diagnosis</label>
<input type="text" id="workingDiagnosis" name="workingDiagnosis" value="" maxlength="50">
<div class="Clear"></div>

<label>DMO Called</label>
<select name="dmoCalled" onchange="displayDmoDiv(this.value)">
<option value="">Select</option>
<option value="y">Yes</option>
<option value="n" selected="selected">No</option>
</select>
<div id="dmoDiv" style="display: none;">
<label> Call Sent <span>*</span> </label> 
<input type="text" id="timeCalled" name="<%=CALL_SENT_TIME %>" value=""  maxlength="5" validate="Time Called ,string,no" onKeyUp="mask(this.value,this,'2',':');" onBlur="IsValidTime(this.value,this.id);">
<label> DMO <span>*</span></label> 
<select id="mo" name="<%=MEDICAL_OFFICER_ID %>" validate="DMO,string,no" onchange="setDepartmentValue(this.value)">
	<option value="0">Select</option>
	<% 
			for(MasEmployee employee : doctorList)
			{
				String doctorName = employee.getFirstName();
				if(employee.getMiddleName()!= null){
					doctorName += " "+employee.getMiddleName();
				}
				if(employee.getLastName()!= null){
					doctorName += " "+employee.getLastName();
				}
			%>
	<option value="<%=employee.getId()%>"><%=(employee.getRank().getRankName())+" "+doctorName %></option>
	<%
			}
			%>
</select>
<input type="hidden" name="<%=DEPARTMENT_ID %>" id="deptId" value="0"/>
<div class="Clear"></div>

<label>DMO Tpt/Amb</label>
<input type="text" id="dmoTransAmbu" name="dmoTransAmbu" value="" maxlength="50">

<label>Tpt/Amb Sent  </label> 
<input type="text" id="tptAmbSentTime" name="tptAmbSentTime" maxlength="5" validate="Tpt/Amb Sent,string,no"  value="" onKeyUp="mask(this.value,this,'2',':');" onBlur="IsValidTime(this.value,this.id);">

<label>DMO Arrived  </label> 
<input type="text" id="dmoArrivedTime" name="dmoArrivedTime" maxlength="5" validate="DMO Arrived ,string,no"  value="" onKeyUp="mask(this.value,this,'2',':');" onBlur="IsValidTime(this.value,this.id);">

<div class="Clear"></div>
<label>Time Attended <span>*</span> </label> 
<input type="text" id="callAttndTime" name="<%=CALL_ATTND_TIME %>" maxlength="5" validate="Time Attended,string,no"  value="<%= time %>" onKeyUp="mask(this.value,this,'2',':');" onBlur="IsValidTime(this.value,this.id);">
<div class="Clear"></div>
</div>

<div class="Clear"></div>
</div>
<input type="hidden" id="opdIssueno" name="opdIssueno" value="<%= opdIssuenoIncremented%>" />	
<input type="hidden" id="storeFyDocumentNoId" name="storeFyDocumentNoId" value="<%= storeFyDocumentNo.getId()%>"  />
<div id="dmaDetailsDiv">
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<h4>Medicine Details</h4>
<a href="javascript:show('med')"><img src="/hms/jsp/images/plusIcon.gif" alt="Open" name="Open" /></a> <a href="javascript:hide('med')"><img src="/hms/jsp/images/minusIcon.gif" alt="Close" name="Close" /></a>
<div id="med" style="display: none;">
<div class="Clear"></div>
<div id="pageNavPosition"></div>
<script type="text/javascript">
var icdArray=new Array();
</script>

	<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">

	<tr>
	  	<th scope="col">PVMS/NIV Nomenclature</th>
	  	<th scope="col">Batch No.</th>
	  	<th scope="col">AU</th>
		<th scope="col">Dosage</th>
		<th scope="col">Frequency</th>
		<th scope="col">Days</th>
		<th scope="col">Route</th>
		<th scope="col">Qty</th>
		<th scope="col">Remarks</th><!--
		<th>Issue</th>
		--><th>Add</th>
		<th>Delete</th>
	</tr>
	<tr>
		<td>
	    <input type="text" value="" tabindex="1" id="nomenclature1" size="30"  name="nomenclature1" onblur="if(this.value!=''){callFunctions(this,1)}"  />
	        <div id="ac2update1" style=" display:none; " class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			
			  new Ajax.Autocompleter('nomenclature1','ac2update1','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature1'});
			</script>
		<input type="hidden" name="pvmsNo1" tabindex="1" id="pvmsNo1"	size="5" readonly="readonly" />
		</td>
			<td id="batchDiv1">
			<select name="batchNo1" ><option value="">Select</option></select>
		<input type="hidden" id="itemId1" name="<%= ITEM_ID %>1" value="">
		<input type="hidden" id="itemCategoryId1" name="<%= ITEM_CATEGORY_ID %>1" value="">
		</td>	
		<td><input type="text" name="au1" tabindex="1" value="" id="au1"  size="3"  validate="AU,string,no" />
		<input type="hidden" name="actualDispensingQty1" tabindex="1" id="actualDispensingQty1" value=""  size="6"  validate="AU,string,no" /></td>
		<td><input type="text" name="dosage1" tabindex="1" id="dosage1"	size="2" maxlength="5" onblur="populateInjDt(this.id,1);"/></td>
		<td><select name="frequency1" id="frequency1" tabindex="1" onchange="if(this.value!=''){getFrequencyValue(this.value,'1');fillValueFromFrequency(this.value,'1');populateInjDt(this.id,1);}">
			<option value="0">Select</option>
			<%

		      for(MasFrequency masFrequency : frequencyList){
		       int id = masFrequency.getId();
		       String name = masFrequency.getFrequencyName();
          %>
			<option value="<%=id %>"><%=name%></option>
			<%} %>
		</select> 
		<script>
		<%
     			 	MasFrequency  masFrequency = new MasFrequency();

			     for (int i = 0; i < frequencyList.size(); i++) {
			        	 masFrequency = (MasFrequency) frequencyList.get(i);
			        	 %>

	          icdArray[<%=i%>]= new Array();
	          icdArray[<%=i%>][0] = "<%=masFrequency.getId()%>";
	          icdArray[<%=i%>][1] = "<%=masFrequency.getFrequencyName()%>";
    <% }%>        </script> 
		 <input type="hidden" name="frequencyValue1" id="frequencyValue1" value="">
		</td>

	<td><input type="text" name="noOfDays1" tabindex="1"id="noOfDays1" onblur="if(this.value!=''){fillValue(this.value,'1')}" size="7"	maxlength="3" validate="No. of Days,num,no" />
	</td>
	<td><input type="text" name="route1" tabindex="1" id="route1"	size="5" maxlength="3" value="PO"  onblur="populateInjDt(this.id,1);"/></td>
		
		
		<td><input type="text" name="total1" tabindex="1"id="total1" size="4" readonly="readonly"	maxlength="3" validate="Issue Qty,num,no" />
		<!--<input type="hidden" name="total1" id="total1" />
		--></td>
		<td><input type="text" name="remarks1" tabindex="1" id="remarks1" size="15" maxlength="40"/></td>
		<!--<td><input type="button" id="issue1" name="issue1" value=""	class="buttonIssue" onclick="openPopupForIssue(1);" /></td>

		--><td>
			<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" /> 
			</td>
			<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('grid','hdb',this);"  />
			</td>
	
	</tr>
</table>
	<input type="hidden" name="hdb" value="1" id="hdb" />
	</div>
<div class="clear"></div>
<div class="division"></div>
<h4>Procedure Details</h4>
<a href="javascript:show('pro')"><img src="/hms/jsp/images/plusIcon.gif" alt="Open" name="Open" /></a> <a href="javascript:hide('pro')"><img src="/hms/jsp/images/minusIcon.gif" alt="Close" name="Close" /></a>
<div id="pro"  style="display: none;">
<div class="Clear"></div>
<div id="pageNavPosition"></div>
<div class="Clear"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0" id="proceduregrid">

	<tr>
		<th scope="col">Procedure Name</th>
		<th scope="col">Remarks</th>
		<th>Add</th>
		<th>Delete</th>
	</tr>
	<tr>
		<td><input type="text" name="procedure1" id="procedure1" value="" size="70" onblur="if(this.value!=''){getProcedureId(this.value,1);}"/>
		   <div id="ac2update2" style=" display:none; " class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('procedure1','ac2update2','registration?method=getProcedureForAutoComplete',{parameters:'requiredField=procedure1'});
			</script>
		</td>
		<td><input type="hidden" name="procedureId1" id="procedureId1" value=""/>
		<input type="text" name="proremarks1" tabindex="1" id="proremarks1" size="70" maxlength="40"/></td>
			<td>
			<input name="Button" type="button" class="buttonAdd" value="" onclick="addProcedureRow();" tabindex="1" /> 
			</td>
			<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('proceduregrid','procCount',this);" tabindex="1" />
			</td>
		
	</tr>
</table>
	<input type="hidden" name="procCount" value="1" id="procCount" />
	</div>
<div class="clear"></div>
<div id="injDiv" style="display: none;">
<div class="division"></div>
<h4>Injection Details</h4>
<div class="Clear"></div>
<div id="pageNavPosition"></div>
<div class="Clear"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0" id="injection" >

	<tr>
		<th scope="col">Injection Name</th>
		<th scope="col">Dosage</th>
		<th scope="col">Route</th>
		<th scope="col">Frequency</th>
		<th scope="col">Allergic Testing</th> 
		<th scope="col">Adverse Reaction</th> 
		<!--<th>Add</th>
		<th>Delete</th>
	--></tr>
	<tr>
		<!--<td><input type="text" name="injectionName1" id="injectionName1" value="" validate="Injection Name,string,yes" size="60"/>
<div id="ac2update1" style=" display:none; " class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
  new Ajax.Autocompleter('injectionName1','ac2update1','registration?method=getInjectionListForAutoComplete',{parameters:'requiredField=injectionName1'});
</script></td>
	
		<td>
		<input type="hidden" name="injectionId1" id="injectionId1" value=""/>
		<input type="text" id="dosageInj1" name="dosageInj1" value="" class="small" maxlength="4" validate=""/></td>
		<td><input type="text" id="routeInj1" name="routeInj1" value="" class="small"/></td>
		<td>
		<input type="text" id="injFrequencyId1" name="injFrequencyId1" value="" class="small"/>
<%--<select name="frequencyId1">
<option value="0"> Select</option>
<%
	if(frequencyList.size() > 0){
		for(MasFrequency frequency : frequencyList){
%>
<option value="<%= frequency.getId() %>"><%= frequency.getFrequencyName() %></option>
<%}
		}%>
</select> --%>

</td>
--><%--			<td>
			<input name="Button" type="button" class="buttonAdd" value="" onclick="addInjectionRow();" tabindex="1" /> 
			</td>
			<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('injection');" tabindex="1" />
			</td>--%>
		
	</tr>
</table>
	<input type="hidden" name="injCount" value="0" id="injCount" />
<div class="clear"></div>
<div class="Block">

<div class="clear"></div>
<label> Injection Given At</label> 
<input	type="text" name="injtime" id="injtime" validate="Injection Given At,string,no" value="" MAXLENGTH="5" onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);" onBlur="IsValidTimeWithBlankCheck(this.value,this.id);" 	 />

<label> On</label> 
<input	type="text" name="injDate" id="injdate" validate="Injection Given On,string,no" value="" class="date" readonly="readonly" MAXLENGTH="50"  />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" 
class="calender"	onClick="setdate('<%=currentDate %>',document.dmaRegister.injDate,event)" />
<div class="clear"></div> 
</div>
</div>
<div class="clear"></div>
<div class="division"></div>
<h4>Patient Detention Details</h4>
<a href="javascript:show('det')"><img src="/hms/jsp/images/plusIcon.gif" alt="Open" name="Open" /></a> <a href="javascript:hide('det')"><img src="/hms/jsp/images/minusIcon.gif" alt="Close" name="Close" /></a>
<div id="det"  style="display: none;">
<div class="Clear"></div>
<div class="Block">

<label> Additional Advice</label> 
<textarea rows="" cols=""  name="treatment" onblur="displayDateTime(this.value)" maxlength="50" onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>

<div class="Clear"></div>

<label> From Date</label> 
<input	type="text" name="detentionFromDate" id="detentionFromDate" validate="Detained From,string,no" value="" class="date" readonly="readonly" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" 
class="calender"	onClick="setdate('<%=currentDate %>',document.dmaRegister.detentionFromDate,event)" />

 <label> Time</label> 
 <input	type="text" name="fromTime" id="fromTime" validate="From Time,string,no" value=""  MAXLENGTH="5"onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);" onBlur="IsValidTimeWithBlankCheck(this.value,this.id);" 	 />
 
 
<div class="Clear"></div>
<label> To Date</label> 
<input	type="text" name="detentionToDate" id="detentionToDate" validate="To Date,string,no" value="" readonly="readonly" class="date"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" 
class="calender"	onClick="setdate('<%=currentDate %>',document.dmaRegister.detentionToDate,event)" /> 

<label> Time</label> 
<input	type="text" name="toTime" id="toTime" validate="To Time,string,no" value="" MAXLENGTH="5"  onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);" onBlur="IsValidTimeWithBlankCheck(this.value,this.id);" 	/>
</div>

<div class="clear"></div>
</div>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="Block">
<%--<label> Final Disposal </label> 
<select name="<%= DISPOSAL %>">
<option value="">Select</option>
<%
if(disposalList.size() > 0){
	for(MasDisposal disposal : disposalList){
	%>
	<option value="<%=disposal.getId() %>"><%=disposal.getDisposalName() %></option>
<%}
}
%>
</select> --%>
<label>Remarks</label>
<textarea name="<%= REMARKS %>" rows="" cols="" class="" maxlength="50" onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>
<input type="hidden" name="dmaHeaderId" id="dmaHeaderId" value=""/>
</div>
<div class="clear"></div>
<div class="division"></div>
<input type="button" name="Submit11" id="addbutton"
	onclick="submitForm('dmaRegister','/hms/hms/registration?method=saveDmaRegisterDetails','checkTreatmentDetails');"
	value="Submit" class="button" accesskey="a" />
<input type="button" name="Submit11"
	onclick="submitFormForButton('dmaRegister','/hms/hms/registration?method=showRegistrationJsp');"
	value="Registration" class="button" accesskey="a" />
<input type="reset" name ="Reset" value ="Reset" class="button" tabindex="1" accesskey="r" />

<div class="Clear"></div>
<div class="division"></div>
<div class="clear"></div>
<jsp:include page="currentUserDetails.jsp"></jsp:include>
<div class="Clear"></div>

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
	  e1.size = '30';
	  e1.tabIndex="1";
	  e1.name='nomenclature'+iteration;
	  e1.id='nomenclature'+iteration
	  e1.onblur=function(){if(this.value!=''){callFunctions(this,iteration)}}
	  cell1.appendChild(e1);
	  new Ajax.Autocompleter('nomenclature'+iteration,'ac2update1','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature'+iteration});

	  var e12 = document.createElement('input');
	  e12.type = 'hidden';
	  e12.name='pvmsNo'+iteration;
	  e12.id='pvmsNo'+iteration
	  cell1.appendChild(e12);
	  
	 
	  var cell2 = row.insertCell(1);
	  cell2.id='batchDiv'+(iteration);
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
	  cell2.appendChild(e21);
	  var e22 = document.createElement('input');
	  e22.type = 'hidden';
	  e22.name='itemCategoryId'+iteration;
	  e22.id='itemCategoryId'+iteration;
	  cell2.appendChild(e22);
	  cell2.appendChild(e2);

	  var cell3 = row.insertCell(2);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name='au'+iteration;
	  e3.id='au'+iteration;
	  e3.size = '3';
	  e3.tabIndex="1";
	  cell3.appendChild(e3);

	  var e32 = document.createElement('input');
	  e32.type = 'hidden';
	  e32.name='actualDispensingQty'+iteration;
	  e32.id='actualDispensingQty'+iteration
	  e32.size='6';
	  e32.setAttribute('tabindex','1');
	  cell3.appendChild(e32);
	  
	  
	  var cell4 = row.insertCell(3);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name='dosage'+iteration;
	  e4.id='dosage'+iteration
	  e4.tabIndex="1";
	  e4.size='2';
	  e4.onblur=function(){populateInjDt(this.id,iteration)};
	  e4.maxLength= '5'; 
	  e4.setAttribute('tabindex','1');
	  cell4.appendChild(e4);

	
	  var cell5 = row.insertCell(4);
	  var e5 = document.createElement('select');

	  e5.name='frequency'+iteration;
	  e5.id='frequency'+iteration;
	  e5.tabIndex="1";
	  e5.onblur=function(){if(this.value!='0'){getFrequencyValue(this.value,iteration);fillValueFromFrequency(this.value,iteration);populateInjDt(this.id,iteration);}}
	  e5.options[0] = new Option('Select', '0');
	  for(var i = 0;i<icdArray.length;i++ ){
	      e5.options[i+1] = new Option(icdArray[i][1],icdArray[i][0]);
	     }
	 
	   cell5.appendChild(e5);

	  var e51 = document.createElement('input');
	  e51.type = 'hidden';
	  e51.name='frequencyValue'+iteration;
	  e51.id='frequencyValue'+iteration;
	  e51.size='5';
	  e51.tabIndex="1";
	  cell5.appendChild(e51);
	  
	  var cell6 = row.insertCell(5);
	  var e6 = document.createElement('input');
	  e6.type = 'text';
	  e6.name='noOfDays'+iteration;
	  e6.id='noOfDays'+iteration;
	  e6.size='7';
	  e6.maxLength='3'; 
	  e6.setAttribute('tabindex','1');
	  e6.onblur=function(){if(this.value!=''){
		  fillValue(this.value,iteration);}
		}
	cell6.appendChild(e6);


	  var cell7 = row.insertCell(6);
	  var e7 = document.createElement('input');
	  e7.type = 'text';
	  e7.name='route'+iteration;
	  e7.id='route'+iteration
	  e7.size='7';
	  e7.value='PO';
	  e7.tabIndex="1";
	  e7.onblur=function(){populateInjDt(this.id,iteration)};
	  e7.setAttribute('maxlength', 5); 
	  cell7.appendChild(e7);

	  var cell8 = row.insertCell(7);
	  var e8 = document.createElement('input');
	  e8.type = 'text';
	  e8.name='total'+iteration;
	  e8.id='total'+iteration;
	  e8.size='4';
	  e8.tabIndex="1";
	 /* var e81 = document.createElement('input');
	  e81.type = 'hidden';
	  e81.name='total'+iteration;
	  e81.id='total'+iteration;
	  cell8.appendChild(e81);*/
	  cell8.appendChild(e8);

	  var cell9 = row.insertCell(8);
	  var e9 = document.createElement('input');
	  e9.type = 'text';
	  e9.name='remarks'+iteration;
	  e9.id='remarks'+iteration
	  e9.size='15';
	  e9.setAttribute('maxlength', 5); 
	  e9.tabIndex="1";
	  cell9.appendChild(e9);

	  var cell10 = row.insertCell(9);
	  var e10 = document.createElement('input');
	  cell10.style.display="none"
	  e10.type = 'button';
	  e10.className = 'buttonIssue';
	  e10.name='issue'+iteration;
	  e10.tabIndex="1";
	  e10.setAttribute('onClick', 'openPopupForIssue('+iteration+');'); 
	  cell10.appendChild(e10);
	  
	  var cell11 = row.insertCell(10);
	  var e11 = document.createElement('input');
	  e11.type = 'button';
	  e11.className = 'buttonAdd';
	  e11.name='remarks'+iteration;
	  e11.setAttribute('onClick', 'addRow();'); 
	  e11.setAttribute('tabindex','1');
	  cell11.appendChild(e11);

	  var cell12 = row.insertCell(11);
	  var e12= document.createElement('input');
	  e12.type = 'button';
	  e12.className = 'buttonDel';
	  e12.name='remarks'+iteration;
	  e12.setAttribute('onClick', 'removeRow("grid","hdb",this);'); 
	  cell12.appendChild(e12);
	  
}

function removeRow(idName,countId,obj)
{
  var tbl = document.getElementById(idName);
  var lastRow = tbl.rows.length;
  if (lastRow > 2){
  //	tbl.deleteRow(lastRow - 1);
    var i=obj.parentNode.parentNode.rowIndex;
    tbl.deleteRow(i);
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
		submitProtoAjaxWithDivName('dmaRegister','/hms/hms/registration?method=getItemBatch&counter='+inc+'&pvmsNo='+chargeId,'batchDiv'+inc);
	}
}
}

var batchArray = new Array();
function setOtherDetails(val,inc){
	for(i=0;i<batchArray.length;i++){
		if(batchArray[i][0]==val){
			document.getElementById('expDate'+inc).value=batchArray[i][1];
			document.getElementById('batchId'+inc).value=batchArray[i][2];			
		}
	}
	
}

function displayDmoDiv(val){
	if(val=='y'){
		document.getElementById('dmoDiv').style.display='block';
		document.getElementById('timeCalled').value = '<%=time%>';
		document.getElementById('tptAmbSentTime').value = '<%=time%>';
		document.getElementById('dmoArrivedTime').value = '<%=time%>';
		document.getElementById('callAttndTime').value = '<%=time%>';
		document.getElementById('dmaDetailsDiv').style.display = 'none';
	
	}else{
		document.getElementById('dmoDiv').style.display='none';
		document.getElementById('timeCalled').value = '';
		document.getElementById('tptAmbSentTime').value = '';
		document.getElementById('dmoArrivedTime').value = '';
		document.getElementById('callAttndTime').value = '';
		document.getElementById('dmaDetailsDiv').style.display = 'block';
	}
}

function addProcedureRow(){
		
		  var tbl = document.getElementById('proceduregrid');
		  var lastRow = tbl.rows.length;

		  var iteration = lastRow;
		  var row = tbl.insertRow(lastRow);
		  var hdb = document.getElementById('procCount');
		  var iteration = parseInt(hdb.value)+1;
		  hdb.value = iteration;

		  
		  var cell1 = row.insertCell(0);
		  var e1 = document.createElement('input');
		  e1.type = 'text';
		  e1.size = '70';
		  e1.name='procedure'+iteration;
		  e1.id='procedure'+iteration
		  e1.onblur=function() {getProcedureId(this.value,iteration);}
		  cell1.appendChild(e1);
		  new Ajax.Autocompleter('procedure'+iteration,'ac2update2','registration?method=getProcedureForAutoComplete',{parameters:'requiredField=procedure'+iteration});

		  var e11 = document.createElement('input');
		  e11.type = 'hidden';
		  e11.name='procedureId'+iteration;
		  e11.id='procedureId'+iteration
		  cell1.appendChild(e11);
		  
		  var cell11 = row.insertCell(1);
		  var e21 = document.createElement('input');
		  e21.type = 'text';
		  e21.name='proremarks'+iteration;
		  e21.id='proremarks'+iteration
		  e21.size = '70';
		  e21.setAttribute('maxlength', 40); 
		  e21.setAttribute('tabindex','1');
		  cell11.appendChild(e21);
		  
		  var cell12 = row.insertCell(2);
		  var e31 = document.createElement('input');
		  e31.type = 'button';
		  e31.className = 'buttonAdd';
		  e31.name='Button'+iteration;
		  e31.setAttribute('onClick', 'addProcedureRow();'); 
		  e31.setAttribute('tabindex','1');
		  cell12.appendChild(e31);

		  var cell13 = row.insertCell(3);
		  var e4 = document.createElement('input');
		  e4.type = 'button';
		  e4.className = 'buttonDel';
		  e4.name='delete'+iteration;
		  e4.setAttribute('onClick', 'removeRow("proceduregrid","procCount",this);'); 
		  e4.setAttribute('tabindex','1');
		  cell13.appendChild(e4);
}

function addInjectionRow(){
	
	  var tbl = document.getElementById('injection');
	  var lastRow = tbl.rows.length;

	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('injCount');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;

	  var cell1 = row.insertCell(0);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.size = '60';
	  e1.name='injectionName'+iteration;
	  e1.id='injectionName'+iteration
	  //e1.onblur=function(){getItemId(this.value,iteration);}
	  cell1.appendChild(e1);
	  new Ajax.Autocompleter('injectionName'+iteration,'ac2update1','registration?method=getInjectionListForAutoComplete',{parameters:'requiredField=injectionName'+iteration});

	<%--  var cell12 = row.insertCell(1);
	  cell12.id='batchInjDiv'+(iteration);
	  var e12 = document.createElement('select');
	  e12.name='batchId'+iteration;
	  e12.id='batchId'+iteration
	  e12.options[0] = new Option('Select', '0');
	  e12.setAttribute('tabindex','1');
	  cell12.appendChild(e12); --%>
	  
	 

	  var cell2 = row.insertCell(1);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.name='dosageInj'+iteration;
	  e2.id='dosageInj'+iteration
	  e2.setAttribute('tabindex','1');
	  var e11 = document.createElement('input');
	  e11.type = 'hidden';
	  e11.size = '60';
	  e11.name='injectionId'+iteration;
	  e11.id='injectionId'+iteration
	  cell2.appendChild(e11);
	  cell2.appendChild(e2);

	  var cell3 = row.insertCell(2);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name='routeInj'+iteration;
	  e3.id='routeInj'+iteration
	//  e3.size = '70';
	  e3.setAttribute('tabindex','1');
	  cell3.appendChild(e3);

	  var cell4 = row.insertCell(3);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name='injFrequency'+iteration;
	  e4.id='injFrequency'+iteration;
	  var e41 = document.createElement('input');
	  e41.type = 'hidden';
	  e41.name='injFrequencyId'+iteration;
	  e41.id='injFrequencyId'+iteration;
	  cell4.appendChild(e4);
	  cell4.appendChild(e41);

	  var cell5 = row.insertCell(4);
	  var e5 = document.createElement('select');
	  
	  e5.name='allergicTesting'+iteration;
	  e5.id='allergicTesting'+iteration
	//  e3.size = '70';
	  e5.setAttribute('tabindex','1');
	  e5.options[0] = new Option('Select', '');
	  e5.options[1] = new Option('Yes', 'yes');
	  e5.options[2] = new Option('No', 'no');
	  cell5.appendChild(e5);

	  var cell6 = row.insertCell(5);
	  var e6 = document.createElement('input');
	  e6.type = 'text';
	  e6.name='adverseReaction'+iteration;
	  e6.id='adverseReaction'+iteration
	//  e3.size = '70';
	  e6.setAttribute('tabindex','1');
	  cell6.appendChild(e6);
	<%--  var cell5 = row.insertCell(4);
	  var e5 = document.createElement('input');
	  e5.type = 'button';
	  e5.className = 'buttonAdd';
	  e5.name='remarks'+iteration;
	  e5.setAttribute('onClick', 'addInjectionRow();'); 
	  e5.setAttribute('tabindex','1');
	  cell5.appendChild(e5);

	  var cell6 = row.insertCell(5);
	  var e6 = document.createElement('input');
	  e6.type = 'button';
	  e6.className = 'buttonDel';
	  e6.name='remarks'+iteration;
	  e6.setAttribute('onClick', 'removeRow("injection");'); 
	  e6.setAttribute('tabindex','1');
	  cell6.appendChild(e6); --%>
}


function getProcedureId(val,inc){
	var index1 = val.lastIndexOf("[");
	var index2 = val.lastIndexOf("]");
	index1++;
	var procId = val.substring(index1,index2);
	document.getElementById('procedureId'+inc).value = procId;
	
}
<%--
function getItemId(val,inc){
	var index1 = val.lastIndexOf("[");
	var index2 = val.lastIndexOf("]");
	index1++;
	var pvmsNo = val.substring(index1,index2);
	 
	if(pvmsNo == "" ) {
      	document.getElementById('injectionName'+inc).value="";
       	return;
	}

	for(i=1;i<inc;i++){
        
		if(inc != 1){
			 
				if(document.getElementById('injectionName'+i).value==val) {
				alert("Injection Name already selected...!")
				document.getElementById('injectionName'+inc).value=""
				var e=eval(document.getElementById('injectionName'+inc));
				e.focus();
				return false;
			}
		}
	}
if(pvmsNo!=""){
	submitProtoAjaxWithDivName('dmaRegister','/hms/hms/registration?method=getItemBatch&counter='+inc+'&flag=injection&pvmsNo='+pvmsNo,'batchInjDiv'+inc);
}
	
} --%>

function populateInjDt(obj,i){
	var cnt = document.getElementById('hdb').value;
	var item = obj.substring(0,12);
	
	if(item=='nomenclature'){
		var injectCount = document.getElementById('injCount').value;
		if(injectCount>0){
			for(var j = document.getElementById("injection").rows.length; j > 1;j--){
			   var tbl = document.getElementById('injection');
			   tbl.deleteRow(j-1);
			   document.getElementById('injCount').value = parseInt(injectCount)-1;
			}
		}
	}
	var index1 = document.getElementById('nomenclature'+i).value.lastIndexOf("[");
	var index2 = document.getElementById('nomenclature'+i).value.lastIndexOf("]");
	index1++;
	var itemId = document.getElementById('nomenclature'+i).value.substring(index1,index2);
	
	if(itemId!=""){
	for(var inc=1;inc<=cnt;inc++){
			if(document.getElementById('itemCategoryId'+inc).value == '9'){ // for injections
				if(item=='nomenclature'){
					document.getElementById('injDiv').style.display='block';
					addInjectionRow();
				}
			var injcnt = document.getElementById('injCount').value;
			
			
			if(document.getElementById('nomenclature'+inc) && document.getElementById('nomenclature'+inc).value !=""){
					document.getElementById('injectionName'+injcnt).value = document.getElementById('nomenclature'+inc).value
			}
			if(document.getElementById('itemId'+inc) && document.getElementById('itemId'+inc).value !=""){
				document.getElementById('injectionId'+injcnt).value = document.getElementById('itemId'+inc).value
			}
			if(document.getElementById('dosage'+inc) && document.getElementById('dosage'+inc).value !=""){
				document.getElementById('dosageInj'+injcnt).value = document.getElementById('dosage'+inc).value
			}
			if(document.getElementById('route'+inc) && document.getElementById('route'+inc).value !=""){
				document.getElementById('routeInj'+injcnt).value = document.getElementById('route'+inc).value
			}
			if(document.getElementById('frequency'+inc) && document.getElementById('frequency'+inc).value !="0"){
				var e = document.getElementById('frequency'+inc);
				var textVal = e.options[e.selectedIndex].text;
				document.getElementById('injFrequency'+injcnt).value = textVal;
				document.getElementById('injFrequencyId'+injcnt).value = document.getElementById('frequency'+inc).value ;
			}
		}
	}
	}
}

function callFunctions(obj,inc){
	
populatePVMS(obj.value,inc);
checkForNomenclature(obj.value,inc);
displayAu(obj.value,inc);
setTimeout('populateInjDt("'+obj.id+'",'+inc+')',2000);
	
}


function openPopupForIssue(rowVal)
{
	if(document.getElementById('serviceNo').value!=""){
		var itemId = document.getElementById('itemId'+rowVal).value;
		var deptId = '<%=session.getAttribute("deptId")%>'
				
   		var url="/hms/hms/registration?method=getItemBatch&itemId="+itemId+"&deptId="+deptId+"&rowVal="+rowVal+"&"+getNameAndData('dmaRegister');
		newwindow=window.open(url,'name',"height=500,width=1010,status=1,left=0, top=0, scrollbars=1,resizable=0, channelmode=no");
	}else{
		alert("Please enter Service No and HIN.")
		return false;
	}
 }
<%
if(patientList.size() > 0){
	Patient patient = patientList.get(0);
%>
document.getElementById('serviceNo').value='<%=patient.getServiceNo()!=null?patient.getServiceNo():""%>'
document.getElementById('hinId').value='<%=patient.getId()%>'
document.getElementById('hinNo').value='<%=patient.getHinNo()%>'
document.getElementById('patientName').value='<%=patient.getPFirstName()+" "+(patient.getPMiddleName()!=null?patient.getPMiddleName():"")+" "+(patient.getPLastName()!=null?patient.getPLastName():"")%>'
document.getElementById('relation').value='<%=patient.getRelation().getRelationName()%>'
document.getElementById('rank').value='<%=patient.getRank().getRankName()%>'
document.getElementById('serPersName').value='<%=patient.getSFirstName()+" "+(patient.getSMiddleName()!=null?patient.getSMiddleName():"")+" "+(patient.getSLastName()!=null?patient.getSLastName():"")%>'
document.getElementById('command').value='<%=(patient.getCommand()!=null?patient.getCommand().getCommandName():"")%>'
document.getElementById('station').value='<%=(patient.getStation()!=null?patient.getStation():"")%>'
document.getElementById('unit').value='<%=patient.getUnit().getUnitName()%>'
document.getElementById('trade').value='<%=(patient.getTrade()!=null?patient.getTrade().getTradeName():"")%>'
document.getElementById('age').value='<%=patient.getAge()%>'
document.getElementById('sex').value='<%=patient.getSex().getAdministrativeSexName()%>'
document.getElementById('bldGrp').value='<%=(patient.getBloodGroup()!=null?patient.getBloodGroup().getBloodGroupName():"")%>'
document.getElementById('mobileNo').value='<%=(patient.getPhoneNumber()!=null?patient.getPhoneNumber():"")%>'
document.getElementById('mrstatus').value='<%=(patient.getMaritalStatus()!=null?patient.getMaritalStatus().getMaritalStatusName():"")%>'
		
<%}%>

function setDepartmentValue(doctorId){
	var dcId;
	var deptId = 0;
	
	<%
		for(MasEmployee emp : doctorList){
	%>			
		dcId = '<%=emp.getId()%>';
		if(doctorId == dcId){
			<%
				if(emp.getDepartment()!= null){
			%>
			deptId = '<%=emp.getDepartment().getId()%>';
			<%}%>
		}	
	<%}%>
	
	document.getElementById('deptId').value=deptId;
}

function displayDateTime(val){
	if(val!=''){
		document.getElementById('detentionFromDate').value = '<%=currentDate%>'
		document.getElementById('detentionToDate').value = '<%=currentDate%>'
		document.getElementById('fromTime').value = '<%=time%>'
		document.getElementById('toTime').value = '<%=time%>'
	}else{
		document.getElementById('detentionFromDate').value = ''
		document.getElementById('detentionToDate').value = ''
		document.getElementById('fromTime').value = ''
		document.getElementById('toTime').value = ''
	}
}

function show(divId){
	document.getElementById(divId).style.display='inline';
}
function hide(divId){
	document.getElementById(divId).style.display='none';
}
function getFrequencyValue(feqValue,inc){
	var feqQty;
<%
if(frequencyList.size()>0){	
	for(MasFrequency frequency :frequencyList){
%>
 if(feqValue == '<%=frequency.getId()%>'){
	 feqQty = '<%=frequency.getFeq()%>'
  }
<%}
}%>
 document.getElementById('frequencyValue'+inc).value = feqQty;
}


function checkTreatmentDetails(){
	var cnt = document.getElementById('hdb').value;
	for(var inc=1;inc<=cnt;inc++){
		if(document.getElementById('nomenclature'+inc) && document.getElementById('nomenclature'+inc).value !=""){
			if(document.getElementById('batchId'+inc) && document.getElementById('batchId'+inc).value =="0"){
				alert("Please select batch no.");
				return false;
			}

		}

	}
	return true;
}

</script>