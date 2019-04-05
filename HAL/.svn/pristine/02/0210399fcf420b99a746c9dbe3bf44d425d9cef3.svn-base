<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : patientTransferSearch.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 07.03.2008    Name: Ritu
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>


<%@ page import="static jkt.hms.util.RequestConstants.REFERRAL_DATE"%>
<%@ page import="static jkt.hms.util.RequestConstants.SERVICE_NO"%>
<%@ page import="static jkt.hms.util.RequestConstants.HIN_NO"%>
<%@ page import="static jkt.hms.util.RequestConstants.HIN_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.PATIENT_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.RELATION_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.RANK_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.RELATION_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.RANK_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.LAST_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.SERVICE_PERSON_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.SEX"%>
<%@ page import="static jkt.hms.util.RequestConstants.AGE"%>
<%@ page import="static jkt.hms.util.RequestConstants.SEX_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.BLOOD_GROUP_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.BLOOD_GROUP_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.DIAGNOSIS"%>
<%@ page import="static jkt.hms.util.RequestConstants.REFER_TO"%>
<%@ page import="static jkt.hms.util.RequestConstants.REFERRED_FOR"%>
<%@ page import="static jkt.hms.util.RequestConstants.REFERRED_BY"%>
<%@ page import="static jkt.hms.util.RequestConstants.NAME_OF_MH"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_BY"%>
<%@ page import="static jkt.hms.util.RequestConstants.LAST_CHANGED_DATE"%>
<%@ page import="static jkt.hms.util.RequestConstants.LAST_CHANGED_TIME"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasAircraftType"%>
<%@page import="jkt.hms.masters.business.MasStation"%>
<%@page import="jkt.hms.masters.business.MasLocation"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDisposal"%>
<%@page import="jkt.hms.masters.business.MasDisposedTo"%>
<%@page import="jkt.hms.masters.business.MhReferral"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>

<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Calendar"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>


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
<script>
var moArray=new Array();
</script>
<%
		Map<String, Object> map = new HashMap<String, Object>();
	//	List<MasDisposedTo> disposalList = new ArrayList<MasDisposedTo>();
		//List<MhReferral> referralList = new ArrayList<MhReferral>();
		List<OpdPatientDetails> referralList = new ArrayList<OpdPatientDetails>();
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasRelation> relationList = new ArrayList<MasRelation>();
		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
		
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
	/*	if(map.get("disposalList") != null){
			disposalList= (List<MasDisposedTo>)map.get("disposalList");
		}*/
		if(map.get("referralList") != null){
			referralList= (List<OpdPatientDetails>)map.get("referralList");
		}
		if(map.get("doctorList") != null){
			doctorList= (List<MasEmployee>)map.get("doctorList");
		}
		String message = "";
		if(map.get("message") != null){
			message = (String)map.get("message");
		}
		List<Patient> patientList = new ArrayList<Patient>();
		if(map.get("patientList") != null){
			patientList = (List<Patient>)map.get("patientList");
		}
		if(map.get("rankList") != null){
			rankList= (List<MasRank>)map.get("rankList");
		}
		if(map.get("relationList") != null){
			relationList = (List<MasRelation>)map.get("relationList");
		}
		if(map.get("sexList") != null){
			sexList = (List<MasAdministrativeSex>)map.get("sexList");
		}
	%>
	<h4><%=message %></h4>
<h2>MH Run Register</h2>
<div class="clear"></div>
<form name="mhReferralSearch" action="" method="post">
<div id="searchId" style="display: none;">
<div class="Block">
<div id="testDiv">
<label> Date Referred<span>*</span></label> 
<input	type="text" name="<%=REFERRAL_DATE %>" value="" MAXLENGTH="30" id="referralDate" validate="Date Referred,string,yes" class="date"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" 
class="calender"	onClick="setdate('<%=currentDate %>',document.mhReferralSearch.referralDate,event)" /> 
<label> Service No.</label>
<input type="text" name="<%=SERVICE_NO %>" validate="Service No,metachar,no" value=""  MAXLENGTH="30" tabindex="1"/>
<label>HIN <span>*</span></label>
<input type="text" name="<%=HIN_NO %>" id="hinNo" value=""  validate="Hin No,metachar,no" MAXLENGTH="90" tabindex="1"/> 
<input type="hidden" name="<%=HIN_ID %>" id="hinId" value="" /> 

 <div class="Clear"></div>
<label>Patient Name</label> 
<input type="text" name="<%=PATIENT_NAME %>" id="pNameId" tabindex="1" value="" validate="Patient Name,metachar,no" MAXLENGTH="90"/>

<label>Relation</label> 
<select	name="<%=RELATION_ID %>" validate="Relation,String,no" tabindex="1"	id="relId">
	<option value="0">Select</option>

	<% 
	for (MasRelation  obj : relationList){
	%>
	<option value="<%=obj.getId()%>"><%=obj.getRelationName()%></option>
	<% 				
	}%>
</select>
<label>Rank</label> 
<select	id="rankId" name="<%=RANK_ID%>" validate="Rank,string,no" tabindex="1">
	<option value="0">Select</option>
	<%
			 	for (MasRank masRank : rankList) 
				{
			 		//if(masRank.getServiceType().getId() == 2){
			%>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%
			 		//}
			 		}%>
</select> 
<div class="Clear"></div>
<label>Name</label> 
<input type="text" 	name="<%=SERVICE_PERSON_NAME %>" id="sNameId" tabindex="1" value="" validate="Name,metachar,no" MAXLENGTH="50" /> 
 
<label>Gender</label> 
<select	name="<%=SEX_ID %>" id="gender" validate="Gender,string,no"	tabindex="1" tabindex="1">
	<option value="0">Select</option>
<%
		   	 		for(MasAdministrativeSex masAdministrativeSex : sexList){
			%>

	<option value="<%=masAdministrativeSex.getId() %>"><%=masAdministrativeSex.getAdministrativeSexName().trim() %></option>
	<%
		   	 	} %>
</select>
<label> Age</label> 
<input	type="text" name="<%=AGE%>" id="ageId" validate="Age,metachar,no" tabindex="1" value="" MAXLENGTH="50"  />



<div class="Clear"></div>
<label>Diagnosis </label> 
<input	type="text" name="<%=DIAGNOSIS%>" validate="Diagnosis,metachar,no" value="" MAXLENGTH="70"  tabindex="1"/>

<label>  Referred To </label> 
<input	type="text" name="<%=REFER_TO%>" value="" validate="Refer To,metachar,no"  MAXLENGTH="20" tabindex="1"/>

<!--<label> Referred For </label> 
<input	type="text" name="<%=REFERRED_FOR%>" value="" validate="Referred For,string,no"  MAXLENGTH="100"tabindex="1" />
-->
<label> MO </label> 
<select name="<%= REFERRED_BY %>" validate="Referred By,string,no" tabindex="1">
<option value="0">Select</option>
<%
	for(MasEmployee employee : doctorList){
%>
<option value="<%= employee.getId() %>"><%=employee.getRank().getRankName()+" "+employee.getFirstName()+" "+(employee.getMiddleName()!=null?employee.getMiddleName():"")+" "+(employee.getLastName()!=null?employee.getLastName():"" )%></option>
<%} %>
</select>
<%
MasEmployee  employee = new MasEmployee();

			     for (int i = 0; i < doctorList.size(); i++) {
			    	 employee = (MasEmployee) doctorList.get(i);
     			 %> <script>

	          moArray[<%=i%>]= new Array();
	          moArray[<%=i%>][0] = "<%=employee.getId()%>";
	          moArray[<%=i%>][1] = "<%=employee.getRank().getRankName()+" "+employee.getFirstName()+" "+(employee.getMiddleName()!=null?employee.getMiddleName():"")+" "+(employee.getLastName()!=null?employee.getLastName():"" )%>";
            </script> <% }%>
<div class="Clear"></div>
</div>
</div>

<div class="Clear"></div>
<input type="button" name="Submit11" id="addbutton" tabindex="1"
	onclick="submitForm('mhReferralSearch','/hms/hms/registration?method=showMHReferralRegisterJsp');"
	value="Search" class="button" accesskey="a" />
<div class="Clear"></div>
</div>
</form>
<form name="mhReferral" action="" method="post">
<div class="Block">
<label> MH Run Date<span>*</span></label> 
<input	type="text" name="runDate" value="" tabindex="1" MAXLENGTH="30" id="runDate" validate="MH Run Date,string,yes" class="date" readonly="readonly"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" 
class="calender"	onClick="setdate('<%=currentDate %>',document.mhReferral.runDate,event)" /> 
</div>
<div class="Clear"></div>


<div class="Clear"></div>
<div class="paddingTop15"></div>

<h4>Patients Referred</h4>			<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" /> 

<div id="pageNavPosition"></div>
<div class="Clear"></div>
<div class="cmntable">
<table width="100%" colspan="7" cellpadding="0" cellspacing="0" id="mhgrid">
	<thead>
		<tr>
		<th></th>
		<th>Date</th>
		<th>Service No.</th>
		<th>Patient Name</th>
		<th>Relation</th>
		<th>Rank</th>
		<th>Name</th>
		<th>Age</th>
		<th>Mobile No</th>
		<th>Diagnosis</th>
		<th>MO</th>
		<th>MH</th>
		<th>Department</th>
		<!--<th>Referred For</th>
		
		--></tr>
	</thead>
	<tbody id="tableData">
	<%int i=1;
if(referralList.size() > 0){
%>
			<% 
				
					for(OpdPatientDetails opdPatientDetails : referralList){
					
			%><!--
		<tr onclick="submitProtoAjax('mhReferral','/hms/hms/registration?method=getMhReferralDetailsForEdit&referralId=<%//=referral.getId() %>')">
		
-->
	<!--<tr onclick="submitProtoAjax('mhReferral','/hms/hms/registration?method=getMhReferralDetailsForEdit&opdId=<%=opdPatientDetails.getId() %>')">
	
-->
<tr>
<td>
<input type="checkbox" name="rowval<%=i %>" id="rowval<%=i %>" value="y"/>
<input type="hidden" name="opdId<%=i %>" id="opdId<%=i %>" value="<%=opdPatientDetails.getId() %>"/></td>
<%
if(opdPatientDetails.getOpdDate() != null){
%>
<td><input type="text" readonly="readonly" name="referredDate<%=i %>" size="8" value="<%=HMSUtil.convertDateToStringWithoutTime(opdPatientDetails.getOpdDate())%>" /></td>
<%}else{%>
<td><input type="text" readonly="readonly" name="referredDate<%=i %>" size="8" value=""/></td>
<%}%>
<td><input type="text" readonly="readonly" name="serviceNo<%=i %>" size="6" value="<%=opdPatientDetails.getVisit().getHin().getServiceNo()!=null? opdPatientDetails.getVisit().getHin().getServiceNo():""  %>"/></td>
<%
	String pName = "";
	pName =  opdPatientDetails.getVisit().getHin().getPFirstName();
	if(opdPatientDetails.getVisit().getHin().getPMiddleName()!= null)
		pName +=" "+opdPatientDetails.getVisit().getHin().getPMiddleName();
	if(opdPatientDetails.getVisit().getHin().getPLastName()!= null)
		pName +=" "+opdPatientDetails.getVisit().getHin().getPLastName();
%>
<td><input type="text" readonly="readonly" name="pName<%=i %>" size="25" value="<%= pName%>"/>
<input type="hidden" name="hinId<%=i %>" value="<%= opdPatientDetails.getVisit().getHin().getId()%>"/></td>

<%
	if(relationList.size() > 0){
		for(MasRelation relation : relationList){
			if(relation.getId().equals(opdPatientDetails.getVisit().getHin().getRelation().getId())){
%>
<td><input type="text" readonly="readonly" name="relation<%=i %>" size="5"  value="<%= relation.getRelationName() %>"/>
<input type="hidden" name="relationId<%=i %>"   value="<%= opdPatientDetails.getVisit().getHin().getRelation().getId() %>"/>
</td>	
<%}
			}
			}else{%>
			<td><input type="text" readonly="readonly" name="relationId<%=i %>" size="6"  value="" /></td>
<%} %>
<%
	if(rankList.size() > 0){
		for(MasRank rank : rankList){
			if(opdPatientDetails.getVisit().getHin().getRank()!=null && rank.getId().equals(opdPatientDetails.getVisit().getHin().getRank().getId())){
%>
<td><input type="text" readonly="readonly" name="rank<%=i %>" size="5"  value="<%= rank.getRankName() %>"/>
<input type="hidden" name="rankId<%=i %>" value="<%= rank.getId() %>"/>
</td>
<%}
		}
}else{ %>
<td><input type="text" readonly="readonly" name="rank<%=i %>" size="7"  value=""/></td>
<%} %>
<%
String sName = "";
sName =  opdPatientDetails.getVisit().getHin().getSFirstName()!=null? opdPatientDetails.getVisit().getHin().getSFirstName():"";
if(opdPatientDetails.getVisit().getHin().getSMiddleName()!= null)
	sName +=" "+opdPatientDetails.getVisit().getHin().getSMiddleName();
if(opdPatientDetails.getVisit().getHin().getSLastName()!= null)
	sName +=" "+opdPatientDetails.getVisit().getHin().getSLastName();

%>
<td><input type="text" readonly="readonly" name="sName<%=i %>" size="25" value="<%= sName %>" /></td>



<td><input type="text" readonly="readonly" name="age<%=i %>" size="5" value="<%= opdPatientDetails.getVisit().getAge() %>" /></td>
<td><input type="text" readonly="readonly" name="mobileNo<%=i %>" size="5" value="mo" /></td>



<%
	if(opdPatientDetails.getInitialDiagnosis()!=null){
%>
<td><input type="text" readonly="readonly" name="diagnosis<%=i %>" size="25" tabindex="1" value="<%= opdPatientDetails.getInitialDiagnosis() %>"/></td>
<%}else{ %>
<td><input type="text" name="diagnosis<%=i %>" size="25" tabindex="1" value=""/></td>
<%} %>
<td><input type="hidden" name="<%=REFERRED_BY%><%=i %>"  tabindex="1" value="<%= opdPatientDetails.getEmployee().getId()%>" />
<input type="text" name="mo<%=i %>"  readonly="readonly" size="25" value="<%=opdPatientDetails.getEmployee().getRank().getRankName()+" "+ opdPatientDetails.getEmployee().getFirstName()+" "+(opdPatientDetails.getEmployee().getMiddleName()!=null?opdPatientDetails.getEmployee().getMiddleName():"" )+(opdPatientDetails.getEmployee().getLastName()!=null?opdPatientDetails.getEmployee().getLastName():"" ) %>" /></td>
<td><input type="text" name="mhName<%=i %>" tabindex="1" size="20" value="<%= opdPatientDetails.getMh()!=null?opdPatientDetails.getMh():"" %>"/></td>		
<td><input type="text" name="<%= REFER_TO %><%=i %>" tabindex="1" size="20" value="<%=opdPatientDetails.getMhDepartment()!=null?opdPatientDetails.getMhDepartment():"" %>"/>
</td>

<!--<td><input type="text" name="<%= REFERRED_FOR%><%=i %>" tabindex="1" size="10" value=""/>
</td>

		--></tr>
		
		<%i++;} 
		%>
		<%}else{
		
			%>
		<tr>
<td>
<input type="checkbox" name="rowval<%=i %>" id="rowval<%=i %>" value="y"/>
<input type="hidden" name="opdId<%=i %>" id="opdId<%=i %>" value="0"/></td>

<td><input type="text"  name="referredDate<%=i %>" size="8" value="" maxlength="10" onkeyup= "mask(this.value,this,'2,5','/')"
	onblur="validateExpDate(this,'referredDate<%=i %>');"/></td>

<td><input type="text" name="serviceNo<%=i %>" size="6" value="" validate="Service No.,metachar,no" onblur="if(this.value!=''){submitProtoAjaxWithDivName('mhReferral','/hms/hms/adt?method=getPatientNamesForApp&serviceNo='+this.value+'&counter=<%=i %>','testDiv<%=i %>')}"/></td>
<td id="testDiv<%=i %>"><input type="text" name="patientNameHin<%=i %>" size="25" value=""/>
</td>

<td><input type="text" readonly="readonly" name="relation<%=i %>" id="relation<%=i %>" size="5"  value=""/>
<input type="hidden" name="relationId<%=i %>" id="relationId<%=i %>"  value=""/>
<input type="hidden" name="hinId<%=i %>" id="hinId<%=i %>" value=""/>
<input type="hidden" name="pName<%=i %>" id="patientName<%=i %>" value=""/>
</td>	

<td><input type="text" readonly="readonly" name="rank<%=i %>" id="rank<%=i %>" size="5"  value=""/>
<input type="hidden" name="rankId<%=i %>" id="rankId<%=i %>" value=""/>
</td>

<td><input type="text" readonly="readonly" name="sName<%=i %>" id="servPersName<%=i %>" size="25" value="" /></td>

<td><input type="text" readonly="readonly" name="age<%=i %>" id="age<%=i %>" size="5" value="" /></td>
<td><input type="text" name="mobileNo<%=i %>" id="mobileNo<%=i %>" size="10" value="" /></td>

<td><input type="text"  name="diagnosis<%=i %>" id="diagnosis<%=i %>" size="25" tabindex="1" value="" maxlength="200"/></td>

<td>
<select name="<%= REFERRED_BY %><%=i %>" validate="Referred By,string,no" tabindex="1">
<option value="0">Select</option>
<%
	for(MasEmployee emp : doctorList){
%>
<option value="<%= emp.getId() %>"><%=emp.getRank().getRankName()+" "+emp.getFirstName()+" "+(emp.getMiddleName()!=null?employee.getMiddleName():"")+" "+(employee.getLastName()!=null?employee.getLastName():"" )%></option>
<%} %>
</select></td>
<td><input type="text" name="mhName<%=i %>" tabindex="1" size="20" value="" maxlength="200"/></td>		
<td><input type="text" name="<%= REFER_TO %><%=i %>" tabindex="1" size="20" value="" maxlength="50"/>
</td>
</tr>
		
		
		<%i++;} %>
	</tbody>
</table>
</div>
<input type="hidden" name="counter" id="counter" value="<%=i-1 %>"/>
<script>
		var pager = new Pager('tableData',10);
		pager.init();
		pager.showPageNav('pager', 'pageNavPosition');
		pager.showPage(1);
	  </script>
	  
	  
	
<input type="button" name="Submit11" id="addbutton" tabindex="1"
	onclick="submitForm('mhReferral','/hms/hms/registration?method=saveMHReferralRegisterDetails','validateCheckBox');"
	value="Submit" class="button" accesskey="a" />

<input type="reset" name ="Reset" value ="Reset" class="button" tabindex="1" accesskey="r" onclick="showDetails('mhReferral','/hms/hms/registration?method=showMHReferralRegisterJsp')"/>


<input type="button" name="sear" value="Search" class="button" onclick="displaySearchBlock();"/>

<div class="Clear"></div>
 <div class="paddingTop40"></div>
 
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


<script type="text/javascript">
function displaySearchBlock(){
	document.getElementById('searchId').style.display='block';
		
	}


function openPopUpForPatient(serviceNo){
	window.open('/hms/hms/registration?method=showPatientDetailsForServiceNo&serviceNo='+serviceNo,'name',"left=100,top=100,height=700,width=1000,status=1,scrollbars=1,resizable=0");

}

function validateCheckBox(){
	var injCount = document.getElementById('counter').value;
	for(var i=1;i<=injCount;i++){
		if(document.getElementById('rowval'+i).checked){
			return true;

		}
	}
	alert("Please select a record.")
	return false;
}


function addRow(){
	
	  var tbl = document.getElementById('mhgrid');
	  var lastRow = tbl.rows.length;

	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('counter');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;

	  var cell1 = row.insertCell(0);
	  var e1 = document.createElement('input');
	  e1.type = 'checkbox';
	  e1.tabIndex="1";
	  e1.name='rowval'+iteration;
	  e1.id='rowval'+iteration
	  e1.value='y';
	  cell1.appendChild(e1);
	  var e11 = document.createElement('input');
	  e11.type = 'hidden';
	  e11.name='opdId'+iteration;
	  e11.id='opdId'+iteration
	  e11.value='y';
	  cell1.appendChild(e11);

	  
	  var cell2 = row.insertCell(1);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.name='referredDate'+iteration;
	  e2.id='referredDate'+iteration;
	  e2.onkeyup= function(){mask(this.value,this,'2,5','/');};
	  e2.onblur=function(){validateExpDate(this,'referredDate'+iteration)};
	  e2.maxLength='10';
	  e2.tabIndex='1';
	  e2.size='8';
	  cell2.appendChild(e2);

	  var cell3 = row.insertCell(2);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name='serviceNo'+iteration;
	  e3.id='serviceNo'+iteration;
	  e3.onblur=function(){submitProtoAjaxWithDivName('mhReferral','/hms/hms/adt?method=getPatientNamesForApp&serviceNo='+this.value+'&counter='+iteration,'testDiv'+iteration)};
	  e3.tabIndex='1';
	  e3.size='6';
	  cell3.appendChild(e3);

	  var cell4 = row.insertCell(3);
	  cell4.id="testDiv"+iteration;
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name='patientNameHin'+iteration;
	  e4.id='patientNameHin'+iteration;
	  e4.size='25';
	  e4.tabIndex='1';
	  cell4.appendChild(e4);
	  

	  var cell5 = row.insertCell(4);
	  var e5 = document.createElement('input');
	  e5.type = 'text';
	  e5.name='relation'+iteration;
	  e5.id='relation'+iteration;
	  e5.size='5';
	  cell5.appendChild(e5);

	  var e51 = document.createElement('input');
	  e51.type = 'hidden';
	  e51.name='pName'+iteration;
	  e51.id='patientName'+iteration;
	  cell5.appendChild(e51);

	  var e52 = document.createElement('input');
	  e52.type = 'hidden';
	  e52.name='hinId'+iteration;
	  e52.id='hinId'+iteration;
	  cell5.appendChild(e52);

	  var e51 = document.createElement('input');
	  e51.type = 'hidden';
	  e51.name='relationId'+iteration;
	  e51.id='relationId'+iteration;
	  cell5.appendChild(e51);

	  var cell6 = row.insertCell(5);
	  var e6 = document.createElement('input');
	  e6.type = 'text';
	  e6.name='rank'+iteration;
	  e6.id='rank'+iteration;
	  e6.size='5';
	  cell6.appendChild(e6);

	  var e61 = document.createElement('input');
	  e61.type = 'hidden';
	  e61.name='rankId'+iteration;
	  e61.id='rankId'+iteration;
	  cell6.appendChild(e61);

	  var cell7 = row.insertCell(6);
	  var e7 = document.createElement('input');
	  e7.type = 'text';
	  e7.name='sName'+iteration;
	  e7.id='servPersName'+iteration;
	  e7.size='25';
	  cell7.appendChild(e7);

	  var cell8 = row.insertCell(7);
	  var e8 = document.createElement('input');
	  e8.type = 'text';
	  e8.name='age'+iteration;
	  e8.id='age'+iteration;
	  e8.size='5';
	  cell8.appendChild(e8);
	  
	  var cell81 = row.insertCell(8);
	  var e81 = document.createElement('input');
	  e81.type = 'text';
	  e81.name='mobileNo'+iteration;
	  e81.id='mobileNo'+iteration;
	  e81.size='10';
	  cell81.appendChild(e81);

	  var cell9 = row.insertCell(9);
	  var e9 = document.createElement('input');
	  e9.type = 'text';
	  e9.name='diagnosis'+iteration;
	  e9.tabIndex='1';
	  e9.id='diagnosis'+iteration;
	  e9.size='25';
	  e9.maxLength="200";
	  cell9.appendChild(e9);

	  var cell10 = row.insertCell(10);
	  var e10 = document.createElement('select');
	  e10.name='referredBy'+iteration;
	  e10.id='referredBy'+iteration;
	  e10.options[0]=new Option('Select','0');
	
	  for(var i = 0;i<moArray.length;i++ ){
	      e10.options[i+1] = new Option(moArray[i][1],moArray[i][0]);
	      }
      e10.tabIndex='1';
	  cell10.appendChild(e10);

	  var cell11 = row.insertCell(11);
	  var e11 = document.createElement('input');
	  e11.type = 'text';
	  e11.name='mhName'+iteration;
	  e11.id='mhName'+iteration;
	  e11.tabIndex='1';
	  e11.size='20';
	  e11.maxLength="200";
	  cell11.appendChild(e11);

	  var cell12 = row.insertCell(12);
	  var e12 = document.createElement('input');
	  e12.type = 'text';
	  e12.name='referTo'+iteration;
	  e12.tabIndex='1';
	  e12.id='referTo'+iteration;
	  e12.size='20';
	  e12.maxLength="50";
	  cell12.appendChild(e12);
}
</script>
