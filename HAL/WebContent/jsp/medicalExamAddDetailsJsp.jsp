
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasCommand"%>
<%@page import="jkt.hms.masters.business.Category"%>
<%@page import="jkt.hms.masters.business.PatientFamilyHistory"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationDetail"%>

<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasUnit"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript">
	<%	Calendar calendar=Calendar.getInstance();
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
			<script type="text/javascript" language="javascript">
		function checkFamilyHistory()
		{
		  var selObj = document.getElementById('FamilyHistory');
		  var i;
		  for (i=0; i<selObj.options.length; i++)
		  {
		    if (selObj.options[i].selected)
		    {
		      if(selObj.options[i].value==8)
		      {
		    	  document.getElementById("familyHistoryOther").style.display='inline';
		       }
		     }

		   }
		}
		 function openOtherField(familyHistoryId){
				if(familyHistoryId == '8'){
					document.getElementById('otherFamilyHistoryDiv').style.display = 'block';
				}
			}
		 function checkForWiegth(val,id){
			 var index=val.indexOf(".");
			 if(index!=-1){
			 	var arr= val.split(".");
			 	if(arr[1].length>3){
			 	alert("pls check the decimal fractions");
			 	document.getElementById(id).value="";
			 	document.getElementById(id).focus();
			 	return false;
			 	}
			 	}
			 	else{
			 	if(val.length>3){
			 	alert("pls give the decimal point after three digit");
			 	document.getElementById(id).value="";
			 	document.getElementById(id).focus();
			 	return false;
			 	}
			  }
			  }
		 function addRowForDisability()
		 {
			  var tbl = document.getElementById('gridDisability');
			  var lastRow = tbl.rows.length;
			  var iteration = lastRow;
			  var row = tbl.insertRow(lastRow);
			  var hdb = document.getElementById('hdbDisability');
			  hdb.value=iteration

			  var cellRight0 = row.insertCell(0);
			  var e0 = document.createElement('input');
			  e0.type = 'text';
			  e0.setAttribute('tabindex','1');
			  var newdiv1 = document.createElement('div');
			  newdiv1.setAttribute('id', 'ac2update'+iteration);
			  newdiv1.setAttribute('class', 'autocomplete');
			  newdiv1.style.display = 'none';

			
			  e0.name = 'systemDiagnosis' + iteration;
			  e0.id = 'systemDiagnosis' + iteration;
			  e0.setAttribute('tabindex','1');
			  //alert("name--"+e0.name)
			  e0.size = '50'
			  cellRight0.appendChild(newdiv1);

			  cellRight0.appendChild(e0);

			  //new Ajax.Autocompleter('systemDiagnosis'+iteration,'ac2update'+iteration,'opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName'+iteration});	  var sel = document.createElement('input');
			  new Ajax.Autocompleter('systemDiagnosis'+iteration,'ac2update'+iteration,'opd?method=autoCompleteForSystemDiagnosis',{parameters:'requiredField=systemDiagnosis'+iteration});
	
			  /* 
				e0.name = 'icdDisability' + iteration;
				e0.id = 'icdDisability' + iteration;
				e0.setAttribute('tabindex','1');
				//alert("name--"+e0.name)
				e0.size = '50'
				cellRight0.appendChild(newdiv1);
				
				cellRight0.appendChild(e0);
				
				new Ajax.Autocompleter('icdDisability'+iteration,'ac2update'+iteration,'opd?method=getICDForIdList',{parameters:'requiredField=icdDisability'+iteration});
				*/
			  var cellRight1 = row.insertCell(1);
			  var e3 = document.createElement('input');
			  e3.type = 'button';
			  e3.className = 'buttonAdd';
			  e3.name='Button';
			  e3.setAttribute('tabindex','1');
			  e3.setAttribute('onClick','addRowForDisability();');
			  cellRight1.appendChild(e3);

			  var cellRight2 = row.insertCell(2);
			  var e4 = document.createElement('input');
			  e4.type = 'button';
			  e4.className = 'buttonDel';
			  e4.name='delete';
			  e4.setAttribute('tabindex','1');
			  e4.setAttribute('onClick','removeRowDisability();');
			  cellRight2.appendChild(e4);


			}
		function removeRowDisability()
		{
		  var tbl = document.getElementById('gridDisability');
		  var lastRow = tbl.rows.length;
		  if (lastRow > 2){
		  	tbl.deleteRow(lastRow - 1);
		  	var tbl = document.getElementById('gridDisability');
		  	var lastRow = tbl.rows.length;
			  // if there's no header row in the table, then iteration = lastRow + 1
		 	var iteration = lastRow - 1;
		  	var hdb = document.getElementById('hdbDisability');
		  	hdb.value=iteration
		  }
		}
		function calculateIdealWeight(){
			
			 var height = document.getElementById('height').value;
			 var age = document.getElementById('ageId').value;
			 var genderId = document.getElementById('genderId').value;
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
						   	  
						        var weight  = item.getElementsByTagName("weight")[0];
						       document.getElementById('idealWeightId').value = weight.childNodes[0].nodeValue;
					      	} 
					      }
					      }
					    var url="/hms/hms/opd?method=calculateIdealWeight&height="+height+"&age='"+age+"'&genderId="+genderId;
					    xmlHttp.open("GET",url,true);
					    xmlHttp.setRequestHeader("Content-Type", "text/xml");
					    xmlHttp.send(null);


					}

							
	</script>


<%
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");
	String userName="";
	if(session.getAttribute("userName")!=null)
	 userName=(String)session.getAttribute("userName");

	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<Patient> patientList=new ArrayList<Patient>();
	if (map.get("patientList") != null) 
	{
		patientList = (List<Patient>) map.get("patientList");
	}
	Patient patient=null;
    if(patientList.size()>0)
    {
        patient=(Patient)patientList.get(0);	
    }
    List<Category> categoryList = new ArrayList<Category>();
    if (map.get("categoryList") != null) 
	{
    	categoryList = (List<Category>) map.get("categoryList");
	}
    List<MasCommand> commandList=new ArrayList<MasCommand>();
   if (map.get("commandList") != null) 
	{
	   commandList = (List<MasCommand>)map.get("commandList");
	}
   List<MasRank> rankList=new ArrayList<MasRank>();
   if (map.get("rankList") != null) 
	{
	   rankList = (List<MasRank>)map.get("rankList");
	}
   List<MasUnit> unitList=new ArrayList<MasUnit>();
   if (map.get("unitList") != null) 
	{
	   unitList = (List<MasUnit>)map.get("unitList");
	}
   List<PatientFamilyHistory> patientFamilyHistoryList=new ArrayList<PatientFamilyHistory>();
   if (map.get("patientFamilyHistoryList") != null) 
	{
	   patientFamilyHistoryList = (List<PatientFamilyHistory>)map.get("patientFamilyHistoryList");
	}
   String message ="";
   if (map.get("message") != null) 
	{
	   message =(String) map.get("message");
	}
	%>
	
 <h4><%=message %></h4>
<form name="addMedicalExamDetails" method="post" action="">
<%if(patient!= null)
  { %>

<div class="titleBg"><h2>Current Details of Service Personnel</h2>
</div>
<div class="Block">
<label>Service No.</label>
 <%if(patient.getRank()!= null)
          { %>
<input name="<%=SERVICE_NO %>" readonly="readonly" value="<%=patient.getServiceNo() %>" type="text" tabindex="1" maxlength="30" />
<input name="hinId"  value="<%=patient.getId() %>" type="hidden" tabindex="1" maxlength="30" />
          <%}
         	 else
          		{ %>
<input name="<%=SERVICE_NO %>"  value="" type="text" tabindex="1" maxlength="30" />
<%}%>

 <% 
 if(patient.getSex()!=null){
            %>
<input type="hidden" name="genderId" id="genderId" 	value="<%=patient.getSex().getId() %>">
<%} %>
<label>Rank</label>
          <%if(patient.getRank()!= null)
          { %>
<input name="rankName" readonly="readonly" value="<%=patient.getRank().getRankName() %>" type="text" tabindex="1" maxlength="40" />
<input name="rankId" readonly="readonly" value="<%=patient.getRank().getId() %>" type="hidden" maxlength="40" />

          <%}
         	 else
          		{ %>
<input name="rankName"  type="text" tabindex="1" maxlength="40" />
            <%} %>
 <label>Name</label>
           <%
           String patientName="";
           if(patient.getPFirstName()!= null)
            { 
        	   patientName=patientName+patient.getPFirstName();
            }
           if(patient.getPMiddleName()!= null)
           { 
       	   patientName=patientName+patient.getPMiddleName();
           }
           if(patient.getPLastName()!= null)
           { 
       	   patientName=patientName+patient.getPLastName();
           }
            %>
<input name="patientName"  readonly="readonly" value="<%=patientName %>" type="text" tabindex="1" maxlength="50" />

             		 <div class="clear"></div>
<label>Unit/Ship </label> <input readonly="readonly" type="text"
	value="<%= patient.getUnit().getUnitName() %>" name="<%=UNIT%>"
	tabindex="2" maxlength="100" /> 
	<input  type="hidden" value="<%= patient.getUnit().getId() %>" name="unitId"
	tabindex="2" maxlength="20" />

<label>Trade/Branch</label>
            <%if(patient.getTrade()!= null)
            { %>
<input name="tradeName"  readonly="readonly" value="<%=patient.getTrade().getTradeName() %>" type="text" tabindex="1" maxlength="50" />
<input name="tradeId"  value="<%=patient.getTrade().getId() %>" type="hidden" tabindex="1" maxlength="50" />

         		  <%}else
          			 { %>
<input name="tradeName"  readonly="readonly" value="" type="text" tabindex="1" maxlength="50" />
<%} %>

<label class="medium">Gender</label>
        <%if(patient.getSex() != null){  %>
<input type="text" size="6" class="autoArial" readonly="readonly" name="gender" id="gender" value="<%=patient.getSex().getAdministrativeSexName() %>"> 
<input type="hidden" readonly="readonly" name="genderId" id="genderId" value="<%=patient.getSex().getId() %>"> 

<%}else{ %>				 
<input type="text" size="6" class="autoArial" readonly="readonly" name="genderId" id="genderId" > 
      
 <%} %> 
 
 <label class="medium">Age</label>
 <%if(patient.getAge()!=null){%>
<input type="text" size="6" class="autoArial" value="<%=patient.getAge() %>" id="age" name="age" readonly="readonly">  

 <%}else{ %>
 <input type="text" size="6" class="autoArial" value="" id="age" name="age" readonly="readonly">  
 
 <%} %>
 <div class="clear"></div>
 
 <label>DOE/DOC </label> <%if(patient.getCommissionDate()!=null)
 { %> <input tabindex="1" readonly="readonly"
	name="<%=DATE_COMMENCEMENT %>" class=""
	value="<%= HMSUtil.convertDateToStringWithoutTime(patient.getCommissionDate()) %>"
	validate="Entry Date,date,no" maxlength="10"	onKeyUp="mask(this.value,this,'2,5','/');" /> 
	<% }else{%> 
	<input 	tabindex="1" name="<%=DATE_COMMENCEMENT %>" class="date" readonly="readonly"
	value="" validate="Entry Date,date,no" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');" />
 <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('',addMedicalExamDetails.<%=DATE_COMMENCEMENT%>,event);" />
 
 <%} %>
 
<label>Present Med Cat</label>

   <select	name="<%= PRESENT_MEDICAL_CATEGORY %>" validate="Signed By,string,no"	tabindex=1>
   	 	<option value="0">Select</option>
	<%
	if(patient.getCategory()!=null)
	{
			for (Category category : categoryList) {
				if(category.getCategories().equalsIgnoreCase("A1G1")||category.getCategories().equalsIgnoreCase("A4G1"))
				{
					if(patient.getCategory().getCategoryid().equals(category.getCategoryid()))
					{
				%>
	<option value="<%=category.getCategoryid()%>" selected="selected" ><%=category.getCategories()%> </option>
	<%}} }
				}else{
		for (Category category : categoryList) {
			if(category.getCategories().equalsIgnoreCase("A1G1")||category.getCategories().equalsIgnoreCase("A4G1"))
			{
		%>
	<option value="<%=category.getCategoryid()%>" ><%=category.getCategories()%> </option>
	<%	}
		}
				}	%>
</select></div>
<%-- <label>Period </label>
 <input type="text" maxlength="10" value="1 Year" class=""	name="period" tabindex="1" />
  <div class="clear"></div>
			 <label>Date of Medical Exam </label>
			 <label>Place</label> --%>
<%--			 <% if(medExamObj.getLastame()!=null){%>
<input type="text" maxlength="100" value="<%=medExamObj.getLastame() %>"
	name="<%=LAST_AME%>" tabindex="1" />
	 <% }else{%> --%>
	<%-- <input type="text"	maxlength="100" value="" name="<%=LAST_AME%>" tabindex="1" /> 
	 <label> Date </label>--%>
<%-- 
 <%if(medExamObj.getDateMedicalBoardSubsequent()!=null &&(!medExamObj.getDateMedicalBoardSubsequent().equals("")) )
 { %> <input tabindex="1" name="<%=DATE_OF_AME %>" class="date"
	value="<%= HMSUtil.convertDateToStringWithoutTime(medExamObj.getDateMedicalBoardSubsequent()) %>"
	validate="Entry Date,date,no" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');"  /> <% }else{%>
	
	--%>
	<%--  <input
	tabindex="1" name="<%=DATE_OF_AME %>" class="date" value=""
	validate="Entry Date,date,no" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 
	--%>
	<%-- }--%> <%-- <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('',addMedicalExamDetails.<%=DATE_OF_AME%>,event);" />
	 <label class="auto">Command </label>
<select id="commandId" name="commandId"	tabindex="1" class="smaller">

<%for(MasCommand masCommand:commandList){ %>
	<option value="<%=masCommand.getId() %>"><%=masCommand.getCommandName() %></option>
	
 <%} %>
 </select>  --%> 
	 <%-- }--%>
<div class="clear"></div>
 <h4>Add Pers Med Details</h4>
 <div id="slide2">
<div class="Block">
<label>Medical Exam Type <span>*</span></label> 
<select id="medExamType" name="medExamType"	tabindex="1">
	<option value="">Select</option>
	<option value="Annual Medical Exam(AFMSF-3B)">Annual Medical Exam(AFMSF-3B)</option>
	<option value="Med. Exam On Release/Discharge(AFMSF-18)">Med. Exam On Release/Discharge(AFMSF-18)</option>
	<option value="Primary/Extension Med. Exam(AFMSF-2A)">Primary/Extension	Med. Exam(AFMSF-2A)</option>
</select> 

<label>Medical Exam Date</label>
<input tabindex="1" type="text" name="<%=REPORTED_DATE %>" 	class="calDate" maxlength="10" class="auto"
	onKeyUp="mask(this.value,this,'2,5','/');" value=""
	validate="Reported Date,date,no" />
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',addMedicalExamDetails.<%=REPORTED_DATE%>,event);" />

<label> Rank</label> 
<select	id="presentRank" name="presentRank" validate="Rank,string,yes" tabindex="1" onchange="">
	<%	for(MasRank rank:rankList)
      	{   %>
<option value="<%=rank.getId() %>" ><%=rank.getRankName() %></option>
<%		   } %>
</select> 

<div class="clear"></div>

<label>Unit/Ship</label> 
<select	id="presentUnit" name="presentUnit" validate="unit" tabindex="1" onchange="">
	<%	for(MasUnit unit:unitList)
      	{   %>
<option value="<%=unit.getId() %>" ><%=unit.getUnitName() %></option>
<%		   } %>

</select> 

<label>Age</label> 
<input type="text" name="ageId" id="ageId" tabindex="1" value="" validate="Age,String,no">

<label>Height</label> 
<input tabindex="1" type="text" id="height" class="auto" size="16"	name="<%=HEIGHT_WITHOUT_SHOOSE %>" onkeyup="isNumber1(this)" value="" maxlength="5"	onblur="calculateIdealWeight();checkForWiegth(this.value,id);" />
<label class="unit">cm</label>
	
<div class="clear"></div>	
	
<label>Weight</label> 
<input tabindex="1" type="text" id="weight" class="auto" size="17"	name="<%=ACTUAL_WEIGHT %>" maxlength="5" value="" onKeyUp="limitText(this,6);"	onblur="checkForWiegth(this.value,id);calculateOverWeight();" />
<label class="unit2">kg</label>

	<label>Ideal Weight</label> 
<input tabindex="1" type="text" id="idealWeightId" 
	name="<%=IDEAL_WEIGHT %>" class="auto" size="17" maxlength="5"
	value="" onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);calculateOverWeight();" /><label
	class="unit2">kg</label>
	
		<label>Over Weight</label>
	<input tabindex="1" type="text" id="<%=OVER_WEIGHT %>" readonly="readonly"
	name="<%=OVER_WEIGHT %>" class="auto" size="16" maxlength="5"
	value="" onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" /><label class="unit2">%</label>

<div class="clear"></div>

	<label>Waist</label>	
	<input tabindex="1" type="text" id="waist" class="auto" size="17"	name="waist" maxlength="5" value="" onKeyUp="limitText(this,6);"	 />
    <label class="unit2">cm</label>
	
	<label>Hip</label>	
	<input tabindex="1" type="text" id="hip" class="auto" size="17"	name="hip" maxlength="5" value="" onKeyUp="limitText(this,6);"	 />
    <label class="unit2">cm</label>
	
	<label>WHR</label>	
	<input type="text" maxlength="30" value="" name="whr" tabindex="1" onKeyUp="limitText(this,6);"/>
	
	<div class="clear"></div>
		
	<label>Pulse</label>	

<input type="text" class="autoArial" size="4" maxlength="30" value="" onKeyUp="limitText(this,6);" name="pulse" tabindex="1">
<label class="unit2">/min</label>
		<label class="medium4">BP</label>	

<input type="text" class="autoArial" size="4" maxlength="30" value="" onKeyUp="limitText(this,6);" name="bp" tabindex="1">
<label class="unit2">mm hg</label>
<div class="smallest floatRight">

<table border="0" align="center" cellpadding="0" cellspacing="0" id="gridDisability">
	<tr>
<th scope="col">Disability</th>
<th>Add</th>
<th>Delete</th>
</tr>
   	<tr>
<td>

<!-- <input name="disability" id="Disability" type="text"  value="" tabindex="1" class="auto" size="50"/> -->

<input  type="text"	name="systemDiagnosis1" value=""	id="systemDiagnosis1" tabindex="1" class="auto" size="50" onblur="" />
<div id="ac2update"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('systemDiagnosis1','ac2update','opd?method=autoCompleteForSystemDiagnosis',{parameters:'requiredField=systemDiagnosis1'});
		</script>
	<%--
		 <input type="text" tabindex="1"	value="<%=disabilityStr%>" id="icdDisability<%=incDisability %>"  name="icdDisability<%=incDisability %>"	class="auto"  size="50" />
<div id="ac2updatex1"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('icdDisability<%=incDisability%>','ac2updatex1','opd?method=getICDForIdList',{parameters:'requiredField=icdDisability'});
		   //document.getElementById('slide0').style.display="hide"
</script>		 --%>	   
		   

</td>


<td>

<input name="Button" type="button" class="buttonAdd" value="" onclick="addRowForDisability();" tabindex="1" />
</td>
<td>
<input type="button" name="delete" value="" class="buttonDel" onclick="removeRowDisability();" tabindex="1" />
</td>
<input type="hidden" name="hdbDisability" value="1" id="hdbDisability" />

</tr>
</table>
</div>


	<div class="clear"></div>
	
	
	
<%
String smokerMore10="";
String smokerLess10="";
if(patient.getSmokerMore10() !=null)
{
smokerMore10=patient.getSmokerMore10();
}
if(patient.getSmokerLess10() !=null){
	smokerLess10=patient.getSmokerLess10();
	}
%>
<%--
<label>Smoker</label>
<label class="auto"><10</label>
<%if(smokerLess10.equalsIgnoreCase("y")){ %>
<input type="checkbox" name="smokerLess10" value="" class="radioAuto" checked="checked"/>
<%}else{ %>
<input type="checkbox" name="smokerLess10" value="" class="radioAuto" />
<%} %>
<label class="auto">>10</label>
<%if(smokerMore10.equalsIgnoreCase("y")){ %>
 <input type="checkbox" name="smokerMore10" class="radioAuto" checked="checked"/>
 <%}else{ %>
 <input type="checkbox" name="smokerMore10" class="radioAuto" />
 <%} %>
 <input tabindex="1" type="hidden"	name="<%=REPORTED_DATE %>" class="calDate" maxlength="10"  class="Auto"
		onKeyUp="mask(this.value,this,'2,5','/');" value="<%=currentDate %>"
		validate="Reported Date,date,no" />
		<div class="clear"></div>
<label>Alcohol</label>
 <select name="alcohol" id="<%=COVER_TEST %>" tabindex="1" class="small">
	<option value="">Select</option>

	<%
    String alcohal="";
	if(patient!=null)
	{
		if(patient.getAlcohol()!=null)
		{
			alcohal=patient.getAlcohol();
		}
	}


if(alcohal.equalsIgnoreCase("Non-drinker")){ 
%>
	<option value="Non-drinker" selected="selected">Non-drinker</option>
	<%}else if(alcohal.equalsIgnoreCase("Occasional")){ %>
	<option value="Occasional" selected="selected">Occasional</option>
	<%}else if(alcohal.equalsIgnoreCase("Moderate")){ %>
	<option value="Moderate" selected="selected">Moderate</option>
	<%}else if(alcohal.equalsIgnoreCase("Heavy")){ %>
	<option value="Heavy" selected="selected">Heavy</option>
	<%} else{ %>
	<option value="Non-drinker">Non-drinker</option>
	<option value="Occasional">Occasional</option>
	<option value="Moderate">Moderate</option>
	<option value="Heavy">Heavy</option>
	<%} %>
</select> 
<input class="transparent" size="1">
<label>Allergy</label>
<%if(patient.getDrugAllergies() != null)
{ %>
<input name="allergies" type="text" tabindex="1" class="" value="<%=patient.getDrugAllergies() %>" maxlength="60" id="allergies" size="78"  />
<%}else{ %>
<input name="allergies" type="text" tabindex="1" class="" value="" maxlength="60" id="allergies" size="78" />
<%} %>			 

	<label>Family History</label>
<select name="<%=FM_DM %>" multiple
	size="6" class="list"  tabindex=2 id="FamilyHistory" maxlength="50" onclick="openOtherField(this.value);">

	<option value="0" >Select</option>
	<%
       		
       			for(PatientFamilyHistory patientFamilyHistory:patientFamilyHistoryList )
       			{   %>
<option value="<%=patientFamilyHistory.getId() %>" ><%=patientFamilyHistory.getPatientHistoryName() %></option>
<%		   } %>
</select>
<div id="otherFamilyHistoryDiv" style="display: none;">

<label>Other</label>
<input type="text" tabindex="2" name="otherFamilyHistory" id="otherFamilyHistory" value=""
	maxlength="50"/>
</div>	 --%>
  <div class="clear"></div>	
   
       	</div>
       	</div>
    <div class="clear"></div>


       	

<div class="clear paddingTop15"></div>
<div class="division"></div>
<input tabindex="1" name="Button" type="button" class="button"
	value="Add" onClick="submitForm('addMedicalExamDetails','medicalExam?method=addOldMedicalExamData');" />

</form>
<%}else{ %>
<div class="clear"></div>
<center><h4>Pers Med Details Not Found</h4></center>
 <%} %>
<div class="clear paddingTop15"></div>
<div class="clear"></div>
<div class="division"></div>

<div class="bottom">
<label>Changed By</label>
<label class="value"><%=userName%></label>
<label>Changed Date</label>
<label class="value"><%=currentDate%></label>
<label>Changed Time</label>
<label class="value"><%=time%></label>
<div class="clear"></div>
<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />
<INPUT	type=hidden value="<%=userName%>" name="<%=LAST_CHANGED_BY%>">
<INPUT type=hidden value="<%=currentDate%>" name="<%=LAST_CHANGED_DATE%>">
<INPUT type=hidden value="<%=time%>" name="<%=LAST_CHANGED_TIME%>">
</div>
