<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * clinicalSetup.jsp  
 * Purpose of the JSP -  This is for Clinical Setup
 * @author  Deepali
 * @author  Mansi
 * Create Date: 21st Feb,2008 
 * Revision Date:      
 * Revision By: Purpose
 * @version 1.8  
--%>

<%@ page import="jkt.hms.util.RequestConstants"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasNursingCare"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.NursingcareSetup"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>

<%@page import="jkt.hms.masters.business.AllergyDetail"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationDetail"%><script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>


<%	

	
	Map map = new HashMap();
		String includedJsp="";
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
			
		}
		
		List inPatientDetailList = new ArrayList();
		List<MasNursingCare> nursingCareList = new ArrayList<MasNursingCare>();
		List nursingCareSetupList = new ArrayList();
		List<MasFrequency> frequencyList=new ArrayList<MasFrequency>();
		
		try{
		
			
			
					inPatientDetailList=(List)map.get("inPatientDetailList");
					nursingCareList=(List)map.get("nursingCareList");
					nursingCareSetupList=(List)map.get("nursingCareSetupList");
					frequencyList=(List)map.get("frequencyList");
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
				
		String userName = "";
		String deptName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
		if (map.get("deptName") != null) {
			deptName = (String) map.get("deptName");
		}
		Patient patient = new Patient();
	   String admissionNumber=null;
	   int hinId=0;
	   int inpatientId=0;
	   String consultantName= "";
	   if(inPatientDetailList != null)
	   {
		   String patientName= "";
		   
		   String serviceNo=null;
		   Inpatient inPatientDetail=(Inpatient)inPatientDetailList.get(0);
		   patient = inPatientDetail.getHin();
		    hinId=inPatientDetail.getHin().getId();
		    inpatientId=inPatientDetail.getId();
	     //  String patientName=inPatientDetail.getHin().getPFirstName()+inPatientDetail.getHin().getPMiddleName()+inPatientDetail.getHin().getPLastName();
	    	 if(inPatientDetail.getHin().getPFirstName() != null)
			   {
		       patientName=inPatientDetail.getHin().getPFirstName();
			   }
			if(inPatientDetail.getHin().getPMiddleName() != null)
				   {
				   patientName +=inPatientDetail.getHin().getPMiddleName();
				   }
			if(inPatientDetail.getHin().getPLastName() != null)
				   {
				   patientName +=inPatientDetail.getHin().getPLastName();
				   }
			if(inPatientDetail.getDoctor() !=null){
				/* consultantName=inPatientDetail.getDoctor().getRank().getRankName(); */
				if(inPatientDetail.getDoctor().getFirstName() != null)
				{
					consultantName+=" "+inPatientDetail.getDoctor().getFirstName();	
				}
				if(inPatientDetail.getDoctor().getMiddleName() != null)
				{
					consultantName+= " "+inPatientDetail.getDoctor().getMiddleName();
				}
				if(inPatientDetail.getDoctor().getLastName() != null)
				{
					consultantName+=" "+inPatientDetail.getDoctor().getLastName();
				}
			}
			if(inPatientDetail.getHin().getServiceNo() != null && inPatientDetail.getHin().getServiceNo() != "")
		     {
		    	 serviceNo= inPatientDetail.getHin().getServiceNo();
		    	 
		     }
			
	       MasIcd masIcd=(MasIcd)inPatientDetail.getDiagnosis();
	       admissionNumber=inPatientDetail.getAdNo();
	       String age = "";
		   String currentAge = "";
		   if(patient.getAge()!=null)
				age = patient.getAge();
			try{
				if(!age.equals(""))
				currentAge = HMSUtil.calculateAgeForADT(age,patient.getRegDate());
			}catch(Exception ex){
				ex.printStackTrace();
			}
	       
	       session.setAttribute("admissionNumber",admissionNumber);
	%>
<div class="titleBg"><h2>Nursing Care Setup</h2></div>
<div class="Clear"></div>
<!--<h4><%=deptName%></h4>
--><div class="Clear paddingTop15"></div>
<form name="clinicalSetup" method="post" action="">
<h4>Patient Details</h4>
<div class="Clear"></div>
<div class="Block">

<label>A&D No.</label> <%if(inPatientDetail.getAdNo() != null){ %>
<label class="value"><%=inPatientDetail.getAdNo() %></label> <%}else{ %>
<label class="value">-</label>
<%} %>
<label>Employee No.</label> <%if(serviceNo != null){ %>
<label class="value"> <%=serviceNo %></label>
<%}else{ %>
<label class="value">-</label> <%} %>
<label>Ward </label> <%if(inPatientDetail.getDepartment() != null){ %>
<label class="value"> <%=inPatientDetail.getDepartment().getDepartmentName() %></label>
<%}else{ %>
<label class="value">-</label>
<%} %>

<div class="Clear"></div>
<label>Patient Name</label>
<label	class="value"> <%= patientName %></label>

<label>Relation</label> <%
	if(patient.getRelation() != null){
	%> 
<label class="value"><%= patient.getRelation().getRelationName()%></label>
<%} else{ %> <label
	class="value">-</label> 
	<% }%> 

<label>Designation</label>
<label class="value"><%=patient.getRank()!=null?patient.getRank().getRankName():"" %></label>
<div class="Clear"></div>
<label>Employee Name</label> <%
		String sMiddleName = "";
		String sLastName = "";
		if(patient.getSFirstName() != null  && !(patient.getSFirstName().equals(""))){
		
			if(patient.getSMiddleName() != null){
				sMiddleName = patient.getSMiddleName();
			}
			if(patient.getSLastName() != null){
				sLastName = patient.getSLastName();
			}
	 %> 
<label class="value"><%= patient.getSFirstName()+" "+sMiddleName+" "+sLastName%></label>
<%}else{ %> 
<label class="value">-</label> 
<% }%>

<%-- <label>Branch/Trade</label>
<%
if(patient.getTrade() != null){
%> 
<label class="value"><%=  patient.getTrade().getTradeName()%></label>
<%} else{ %> 
<label class="value">-</label> 
<% }%> --%>


<%-- <label>Unit</label> <%
if(patient.getUnit() != null){
%> <label class="value"><%= patient.getUnit().getUnitName()%></label>
<%} else{ %> 
<label class="value">-</label> 
<% }%> --%>
<!-- <div class="Clear"></div> -->
<label>Age</label> <%if(!currentAge.equals("")){ %>
<label class="value"> <%=currentAge %></label> <%}else{ %>
<label	class="value">-</label> <%} %>
<label>Gender</label> <%if(inPatientDetail.getHin().getSex() != null){ %>
<label class="value"> <%=inPatientDetail.getHin().getSex().getAdministrativeSexName() %></label>
<%}else{ %>
<label class="value">-</label> <%} %>
<%-- 
<label>Med Cat</label>
<label class="value"><%=patient.getCategory()!=null?patient.getCategory().getCategories():"-" %></label> --%>
<div class="Clear"></div>

<label>Admitting Doctor</label>
<label class="value"><%=consultantName %></label>
<%-- 
<label>Allergies</label>
<%
String allergies = "";
	if(patient.getDrugAllergies()!=null){
/*	for(AllergyDetail allergyDetail : patient.getAllergyDetails()){
		if(!allergies.equals("")){
			allergies += ",";
		}
		allergies += allergyDetail.getDescription();
	}*/
		allergies = patient.getDrugAllergies();
}%>
<%
	if(!allergies.equals("")){
%>
<label class="valueAuto"><%=allergies %></label>
<%}else{ %>
<label class="value"></label>
<%} %> --%>
<!-- <div class="Clear"></div> -->

<label> Diagnosis</label> 
<%	List<DischargeIcdCode> diagnosisList = new ArrayList<DischargeIcdCode>();
if(map.get("diagnosisList")!=null){
	diagnosisList = (List<DischargeIcdCode>)map.get("diagnosisList");
	
}
if(diagnosisList != null && diagnosisList.size() > 0 && diagnosisList.get(0).getIcd()!=null)
{
%> <label class="valueFixedWidth"><%=diagnosisList.get(0).getIcd().getIcdName() %></label>
<%
		}else{
		%> <label class="value"></label> <%	
		}
		%> 
<%-- 		
<label>Disability</label>
<%
	List<MasMedicalExaminationDetail> disabilityList = new ArrayList<MasMedicalExaminationDetail>();
	if(map.get("disabilityList")!=null){
		disabilityList = (List<MasMedicalExaminationDetail>)map.get("disabilityList");
	}
	
	if(disabilityList != null && disabilityList.size() > 0)
	{
	%> <label class="valueFixedWidth"><%=disabilityList.get(0).getMasIcd()!=null?disabilityList.get(0).getMasIcd().getIcdName():"" %></label>
<%
	}else{
	%> <label class="value"></label> <%	
	}
%>  --%>

<div class="Clear"></div>
<%
			}
		%>
</div>


<div class="Clear"></div>
<%
	int j=0;
%>

<h4>Care Setup</h4>
<div class="cmntable">
<table cellpadding="0" cellspacing="0" width=100% id="nursingCare">
	<tr>
		<th>Nursing Care/Procedure </th>
		<th colspan="2">Duration</th>
		<th>Frequency</th>
		<th>No. of Days</th>
		<th>Remarks</th>
		<th>Add</th>
		<th>Delete</th>
	</tr>
<%

int nursingCareSetupId = 0;
	     if(nursingCareSetupList.size() >0)
		  {
			for(int i=0;i<nursingCareSetupList.size();i++)
			{
				++j;
				NursingcareSetup nursingcareSetup=(NursingcareSetup)nursingCareSetupList.get(i);
			
%>
<tr>
		<td class="rowcolor"><%=nursingcareSetup.getNursing().getNursingName() %>
		<input type="hidden" name="nursingCareSetupId" value="<%=nursingcareSetup.getId() %>" />
		<input type="hidden" name="cares" id="cares<%=j %>" value="<%=nursingcareSetup.getNursing().getId()  %>">
		</td>
		<td><%=nursingcareSetup.getDuration()!=null?nursingcareSetup.getDuration():"&nbsp;" %>
		<input type="hidden" name="duration" tabindex="1" id="durationId<%=j %>" value="<%=nursingcareSetup.getDuration()!=null?nursingcareSetup.getDuration():"" %>"	size="12" maxlength="3" /></td>
		<td width="8%">min</td>
	
	<td width="27%" class="rowcolor"><%=nursingcareSetup.getFrequency().getFrequencyName()%>
	<input type="hidden" name="<%=FREQUENCY%>" id="frequency<%=j %>" />
<%--<select name="<%=FREQUENCY%>" id="frequency<%=j %>"
			validate="Complaint,string,no">
			<option value="0">Select</option>
			<%
			 			for(MasFrequency masFrequency : frequencyList){
			 				
			 		%>
			<option value="<%=masFrequency.getId() %>"><%=masFrequency.getFrequencyName() %></option>
			<%} %>
		</select> --%>	
		<script>
			document.getElementById('frequency<%=j %>').value='<%=nursingcareSetup.getFrequency().getId()%>'
		</script>
		</td>
		<td>
		<%=nursingcareSetup.getNoOfDays()!=null?nursingcareSetup.getNoOfDays():"&nbsp;" %>
		<input type="hidden" name="noOfDays" tabindex="1" id="noOfDays<%=j %>"  size="3" value="<%=nursingcareSetup.getNoOfDays()!=null?nursingcareSetup.getNoOfDays():"" %>"	maxlength="3" validate="No Of Days,num,no" /></td>
	<td><%=nursingcareSetup.getRemarks()!=null?nursingcareSetup.getRemarks():"&nbsp;" %>
	<input type="hidden" name="remarks" id="remarks<%=j %>" value="<%=nursingcareSetup.getRemarks()!=null?nursingcareSetup.getRemarks():"" %>"/>
	</td>
		<td>
			<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" /> 
			</td>
			<td>&nbsp;</td>
			</tr>

<%}
				}else{ ++j; %>
	<tr>
		<td class="rowcolor">
		<select name="cares" id="cares<%=j %>"  tabindex="1">
		<option value="0">Select</option>
		<%
		if(nursingCareList.size() > 0)
   		{
			for(MasNursingCare masNursingCare : nursingCareList){
				 int id= masNursingCare.getId();
		%>
		<option value="<%=masNursingCare.getId() %>"><%=masNursingCare.getNursingName() %></option>
		
		<%} 
		}%>
		</select>
		</td>
			<td><input type="text" name="duration" tabindex="1" id="durationId<%=j %>" value=""	size="12" maxlength="3" /></td>
	<td width="8%">min</td>
	
	<td width="27%" class="rowcolor"><select name="<%=FREQUENCY%>"id="frequency<%=j %>"tabindex="1" 
			validate="Complaint,string,no">
			<option value="0">Select</option>
			<%
			 			for(MasFrequency masFrequency : frequencyList){
			 				
			 		%>
			<option value="<%=masFrequency.getId() %>"><%=masFrequency.getFrequencyName() %></option>
			<%} %>
		</select>
		<input type="hidden" name="nursingCareSetupId" value="0" />
		</td>
			<td><input type="text" name="noOfDays" tabindex="1" id="noOfDays<%=j %>"  size="3"	maxlength="3" validate="No Of Days,num,no" /></td>
	
		<td><input type="text" name="remarks" id="remarks<%=j %>" tabindex="1" maxlength="50" size="70"/>
	</td>
		<td>
			<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" /> 
			</td>
			<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('nursingCare',this);"  />
			</td>
			</tr>
			<%} %>
	<%--
	<% 
	   		if(nursingCareList!=null)
	   		{
	   			String bool="false";
	   			String frequencyName=null;
	   			int frequencyId=0;
	   			int j=0;
	       		Iterator listIterator=nursingCareList.iterator();
          			while (listIterator.hasNext()){
          				 MasNursingCare masNursingCare=(MasNursingCare) listIterator.next();
          				 int id= masNursingCare.getId();
           				 String careName= masNursingCare.getNursingName();
			             				
			           
			                %>
	<tr>
		<td class="rowcolor"><%= careName%> <input type="hidden"
			id="careName<%=j%>" value="<%= careName%>" /></td>
		<%
		int nursingCareSetupId = 0;
			     if(map.get("nursingCareSetupList")!=null)
				  {
					for(int i=0;i<nursingCareSetupList.size();i++)
					{
						NursingcareSetup nursingcareSetup=(NursingcareSetup)nursingCareSetupList.get(i);
						int nursingid=nursingcareSetup.getNursing().getId();
						MasFrequency masFrequencyObj=(MasFrequency)nursingcareSetup.getFrequency();
						
						if(id==nursingid)
					    {
							bool="true";
							nursingCareSetupId = nursingcareSetup.getId();
							frequencyName=masFrequencyObj.getFrequencyName();
							frequencyId=masFrequencyObj.getId();
							break;
							
					    }else
					    {
					    	bool="false";
					    	continue;
					    	
					    }
					}
				  }
			   if(bool.equals("true"))
			    {
			  %>
		<td class="rowcolor"><input type="checkbox" checked="true"
			name="cares" value="<%=id %>"></td>
		<td class="rowcolor"><select name="<%=FREQUENCY%>"
			validate="Complaint,string,no">
			<option value="0">Select</option>
			<%
			 			for(MasFrequency masFrequency : frequencyList){
			 				if(masFrequency.getId()==frequencyId){
			 		%>
			<option value="<%=frequencyId %>" selected><%=frequencyName %></option>
			<%}else{ %>
			<option value="<%=masFrequency.getId() %>"><%=masFrequency.getFrequencyName() %></option>
			<%}} %>
		</select>
		<input type="hidden" name="nursingCareSetupId" value="<%= nursingCareSetupId %>" />
		
		</td>
		<%
			     }else{
			  %>
		<td width="34%" class="rowcolor"><input type="checkbox"
			name="cares" value="<%=id %>"></td>
		<td width="27%" class="rowcolor"><select name="<%=FREQUENCY%>"
			validate="Complaint,string,no">
			<option value="0">Select</option>
			<%
			 			for(MasFrequency masFrequency : frequencyList){
			 				
			 		%>
			<option value="<%=masFrequency.getId() %>"><%=masFrequency.getFrequencyName() %></option>
			<%} %>
		</select>
		<input type="hidden" name="nursingCareSetupId" value="<%= nursingCareSetupId %>" />
		
		</td>
	</tr>
	<%
			     }
			        j++;
			     	}
			      }
               %>  --%>
               
</table>
<script>
var freqArray = new Array();
<%
	    		MasFrequency  masFrequency = new MasFrequency();

			     for (int i = 0; i < frequencyList.size(); i++) {
			        	 masFrequency = (MasFrequency) frequencyList.get(i);
     			 %> 

	          freqArray[<%=i%>]= new Array();
	          freqArray[<%=i%>][0] = "<%=masFrequency.getId()%>";
	          freqArray[<%=i%>][1] = "<%=masFrequency.getFrequencyName()%>";
           <% }%>
</script>
<script>
var nursingArray = new Array();
<%
int k=0;
	for (MasNursingCare masNursingCare : nursingCareList) {
%> 

nursingArray[<%=k%>]= new Array();
nursingArray[<%=k%>][0] = "<%=masNursingCare.getId()%>";
nursingArray[<%=k%>][1] = "<%=masNursingCare.getNursingName()%>";
           <% k++;}%>
</script>
<input type="hidden" name="counter" id="counter" value="<%=j %>">
</div>
<div class="Clear"></div>
<div class="division"></div>
<input type="button" class="button" value="Submit" align="left"
	onClick="submitForm('clinicalSetup','ipd?method=addNursingCare','validateCare');" />
<input type="button" class="button" value="Back" align="left"
	onClick="submitFormForButton('clinicalSetup','ipd?method=showPatientListJsp');" />
<input type="reset" name="reset" value="Reset"/>
<!--  <input type="button" name="GenerateMessage" value="Generate Message" class="button" onClick="submitForm('clinicalSetup','hl7?method=generateHL7MessageForADT');" /> -->
<input type="hidden" name="hinId" value="<%=hinId %>" /> <input
	type="hidden" name="inpatientId" value="<%=inpatientId %>" /> <input
	type="hidden" name="deptName" value="<%=deptName %>" /> 
<input type="hidden" name="consultantName" value="<%=consultantName %>" />
<input type="hidden" name="eventType" value="ADT01" /> <input
	type="hidden" name="userName" value="<%=userName %>" />
<div class="Clear"></div>
<div class="division"></div>
</form>
<script>

function validateCare(){
		var flag ='';
		 for(var i = 0; i < document.getElementById('counter').value; i++){
			
			if(document.getElementsByName('cares')[i]){
			var care = document.getElementsByName('cares')[i].value;
			if(care!=='0')
            {
	           flag = 'filled';
	           break;
			}
			}
		}
		 for(var i = 0; i < document.getElementById('counter').value; i++){
		 	if(document.getElementsByName('cares')[i]){
				var care = document.getElementsByName('cares')[i].value;
				if(document.getElementsByName('frequency')[i].value == 0 &&  care != '0')
	            {
					alert("Please select the Frequency in row "+(i+1))
					return false;
				 }	
				if(document.getElementsByName('frequency')[i].value != 0 &&  care == '0')
	            {
					alert("Please select the Nursing Care Type Care in row "+(i+1))
					return false;
				 }	
		 	}
		}
		if(flag==''){
			alert("Please select Nursing Care Type.")
			return false;			
		}
		return true;
			
	}
function addRow(){

	 var tbl = document.getElementById('nursingCare');
	  var lastRow = tbl.rows.length;

	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('counter');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;

	  var cell0 = row.insertCell(0);
 	  var e0 = document.createElement('select');
	  
	  e0.name='cares';
	  e0.id='cares'+iteration
	  e0.tabindex='1';
	  e0.options[0] = new Option('Select','0');
	  for(var i = 0;i<nursingArray.length;i++ ){
	      e0.options[i+1] = new Option(nursingArray[i][1],nursingArray[i][0]);
	   }
	  cell0.appendChild(e0);
	  e0.focus();

  	  var e01 = document.createElement('input');
	  e01.type='hidden';
	  e01.name='nursingCareSetupId';
	  e01.id='nursingCareSetupId'+iteration
	  e01.value = '0';
	  cell0.appendChild(e01);
	  
	  var cell1 = row.insertCell(1);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.name='duration';
	  e2.id='durationId'+iteration
	  e2.size = '12'
	  e2.tabindex='1';
	  e2.maxlength='3';
	  cell1.appendChild(e2);

	  var cell2 = row.insertCell(2);
	  cell2.innerHTML='min'
		  
	  var cell3 = row.insertCell(3);
 	  var e1 = document.createElement('select');
	  
	  e1.name='frequency';
	  e1.id='frequency'+iteration
	  e1.tabindex='1';
	  e1.options[0] = new Option('Select','0');
	  for(var i = 0;i<freqArray.length;i++ ){
	      e1.options[i+1] = new Option(freqArray[i][1],freqArray[i][0]);
	   }
	  e1.tabindex='1';
	  cell3.appendChild(e1);

	  var cell4 = row.insertCell(4);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name='noOfDays';
	  e4.id='noOfDays'+iteration;
	  e4.size='3';
	  e4.maxlength='3'; 
	  e4.tabindex='1';
	  e4.setAttribute('validate','noOfDays,int,no');
	  cell4.appendChild(e4);

	  var cell15 = row.insertCell(5);
	  var e21 = document.createElement('input');
	  e21.type = 'text';
	  e21.name = 'remarks';
	  e21.id = 'remarks'+iteration;
	  e21.maxLength='50';
	  e21.size='70';
	  e21.tabindex='1';
	  e21.tabindex='1';
	  cell15.appendChild(e21);

	  var cell16 = row.insertCell(6);
	  var e31 = document.createElement('input');
	  e31.type = 'button';
	  e31.className = 'buttonAdd';
	  e31.name='Button'+iteration;
	  e31.setAttribute('onClick', 'addRow();'); 
	  e31.tabindex='1';
	  cell16.appendChild(e31);

	  var cell17 = row.insertCell(7);
	  var e4 = document.createElement('input');
	  e4.type = 'button';
	  e4.className = 'buttonDel';
	  e4.name='delete'+iteration;
	  e4.setAttribute('onClick', 'removeRow("nursingCare",this);'); 
	  e4.tabindex='1';
	  cell17.appendChild(e4);
	 
}


function removeRow(idName,obj)
{
  var tbl = document.getElementById(idName);
  var lastRow = tbl.rows.length;
  if (lastRow > 2){
  //	tbl.deleteRow(lastRow - 1);
    var i=obj.parentNode.parentNode.rowIndex;
    tbl.deleteRow(i);
    document.getElementById('counter').value = (parseInt(document.getElementById('counter').value)-1);
    
  }
}
</script>

