<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>

<%@page import="jkt.hms.masters.business.Category"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
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
	List<MasUnit> unitList=new ArrayList<MasUnit>();
	if (map.get("unitList") != null) 
	{
		unitList = (List<MasUnit>) map.get("unitList");
	}
	List<Category> categoryList=new ArrayList<Category>();
	if (map.get("categoryList") != null) 
	{
		categoryList = (List<Category>) map.get("categoryList");
	}
	Patient patient=null;
    if(patientList.size()>0)
    {
        patient=(Patient)patientList.get(0);	
    }
    %>
<form name="midData" method="post" action="">
<div class="titleBg"><h2>MID Data</h2></div>
<div class="clear"></div>
<div class="Block">
<label>Service No.</label>
<input	id="serviceNo" class="auto" size="8" type="text"	name="<%=SERVICE_NO %>"  value="" title="Enter Service No" tabindex="1" validate="Service No,metachar,yes" 
maxlength="20"	onblur="ajaxFunctionMBService('midData');submitProtoAjaxWithDivName('midData','/hms/hms/medicalBoard?method=getServiceNoDetailsMB&serviceNo='+this.value,'dispalyDiv');"/>
</div>
<div class="clear"></div>
<div class="block">
<div id="dispalyDiv"></div>
<div class="clear"></div>
</div>
<div class="clear paddingTop15"></div>

<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		
		<th>Date</th>
		<th>Disability</th>
		<th>Name</th>
		<th>Med Cat</th>
		<th>Height</th>
		<th>Weight</th>
		<th>Waist</th>
		<th>BP</th>
		<th>Unit</th>
		
		<th>Add</th>
	</tr>
	<tr>
		<td><input	tabindex="1" name="<%=REPORTED_DATE %>"  class="date" value="<%=currentDate %>" validate="Date,date,yes" maxlength="10" onKeyUp="mask(this.value,this,'2,5','/');" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('<%=currentDate %>',midData.<%=REPORTED_DATE %>,event);"/></td>

		<td><input  type="text"	name="systemDiagnosis" value=""	id="systemDiagnosis" tabindex="1" class="auto" size="15" onblur="" />
		<div id="ac2update"	style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('systemDiagnosis','ac2update','medicalBoard?method=autoCompleteForIcdDiagnosis',{parameters:'requiredField=systemDiagnosis'});
		</script></td>
		
		<td>
		<input type="text" name="patientName" id="name" maxlength="30" readonly="readonly"/>
		<input type="hidden" name="hinId" id="hinId" maxlength="30" />
		<input type="hidden" name="rankId" id="rankId" maxlength="30"/>
		<input type="hidden" name="sexId" id="sexId" maxlength="30"/>
		<input type="hidden" name="age" id="age" maxlength="30"/>
		<input type="hidden" name="commandId" id="commandId" maxlength="30"/>
		</td>
		<td>
		<select id="medcatId" name="medcatId" tabindex="1"	>
		<option value="0">Select</option>
	<%
		 for(Category category : categoryList){
		 %>
	<option value="<%=category.getCategories()%>"><%=category.getCategories()%></option>
	<%
	 }%>
	</select>
	</td>
		<td><input name="height" id="height" size="4" class="auto" maxlength="3"/></td>		
		<td><input size="4" class="auto" name="weight" id="weight" maxlength="3"/></td>
		<td><input size="4" class="auto" name="waist" id="waist" maxlength="2"/></td>
		<td><input size="4" class="auto" name="bp" id="bp" maxlength="6"/></td>
		<td>
		<select id="unitId" name="<%=UNIT_ID %>" tabindex="1"	validate="Unit,string,no" onchange="displayOtherUnit(this.value);populateStationForUnit(this.value);">
		<option value="0">Select</option>
	<%
		 for(MasUnit masUnit : unitList){
		 %>
	<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>
	<%
	 }%>
	</select>
		<%---
		<select id="" name="<%=UNIT_ID %>" tabindex="1"	validate="Unit,string,no" onchange="displayOtherUnit(this.value);populateStationForUnit(this.value);">
	<option value="0">Select</option>
	<%
		 for(MasUnit masUnit : unitList){
		 %>
	<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>
	<%
	 }%>
</select> --%></td>


		<td><input name="Button" type="button" class="buttonAdd" value="" onclick="submitMIDData();"/></td>
		<%--onclick="submitForm('midData','/hms/hms/medicalBoard?method=saveMIDData');" tabindex="1" />----%>
	</tr>
</table>
</div>
</form>

<script>
function submitMIDData()
{
	ajaxForSubmitMIDData();
	document.getElementById('systemDiagnosis').value="";
	document.getElementById('serviceNo').focus();
}
function ajaxForSubmitMIDData(){
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
	        var msg  = item.getElementsByTagName("msg")[0];
			//if(msg.childNodes[0]!='undefined'){
				alert(msg.childNodes[0].nodeValue);
		//	}

      	}
      }
    }
    var url="/hms/hms/medicalBoard?method=saveMIDData&"+getNameAndData('midData');   
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
}
function updateMIDData(rowVal)
{
	ajaxForUpdateMIDData(rowVal);
	document.getElementById('serviceNo').focus();
}
function ajaxForUpdateMIDData(rowVal){
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
	        var msg  = item.getElementsByTagName("msg")[0];
			//if(msg.childNodes[0]!='undefined'){
				alert(msg.childNodes[0].nodeValue);
		//	}

      	}
      }
    }
    var url="/hms/hms/medicalBoard?method=updateMIDData&rowVal="+rowVal+"&"+getNameAndData('midData');     
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
}
</script>