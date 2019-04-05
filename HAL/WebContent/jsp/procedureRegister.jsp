<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : minorSurgeryRegister.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 10.06.2011    Name: Ritu
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.ProcedureDetails"%>
<%@page import="jkt.hms.masters.business.ProcedureHeader"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
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

<%
		Map<String, Object> map = new HashMap<String, Object>();
		
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
	
	
		List<ProcedureDetails> procDtList = new ArrayList<ProcedureDetails>();
		if(map.get("procDtList")!=null){
			procDtList = (List<ProcedureDetails>)map.get("procDtList");
		}
		ProcedureHeader procHeader = new ProcedureHeader();
		if(procDtList.size() > 0){
			procHeader = procDtList.get(0).getProcedureHeader();
		}
		Box box= HMSUtil.getBox(request);
	%>

<h2>Procedure Register</h2>
<div class="clear"></div>
<form name="minorSurgery" action="" method="post">
<div class="Block">

<label>Service No.</label>
<label class="value"><%=procHeader.getHin().getServiceNo()!=null?procHeader.getHin().getServiceNo():"" %></label>


<label>Patient Name</label> 
<%
String middleName = "";
String lastName = "";
if(procHeader.getHin().getPMiddleName() != null){
	middleName = procHeader.getHin().getPMiddleName();
}
if(procHeader.getHin().getPLastName() != null){
	lastName = procHeader.getHin().getPLastName();
}

%>
<label class="value"><%=procHeader.getHin().getPFirstName()+" "+middleName+" "+lastName %></label>

<div class="Clear"></div>
<label>Relation</label> 
<label class="value"><%=procHeader.getHin().getRelation().getRelationName()%></label>
<label>Rank</label>
<label class="value"><%=procHeader.getHin().getRank().getRankName()%></label> 
<label>Name</label> 
<%
String sMiddleName = "";
String sLastName = "";

	if(procHeader.getHin().getSMiddleName() != null){
		sMiddleName = procHeader.getHin().getSMiddleName();
	}
	if(procHeader.getHin().getSLastName() != null){
		sLastName = procHeader.getHin().getSLastName();
	}
%>
<label class="value"><%=procHeader.getHin().getSFirstName()+" "+sMiddleName+" "+sLastName %></label> 
<div class="Clear"></div>
 
<label>Unit</label> 
<label class="value"><%=procHeader.getHin().getUnit().getUnitName()%></label>

<label>Branch/Trade</label> 
<label class="value"><%=(procHeader.getHin().getTrade()!=null?procHeader.getHin().getTrade().getTradeName():"")%></label>

<label> Age</label> 
<label class="value"><%=(procHeader.getHin().getAge()!=null ? procHeader.getHin().getAge(): "")%></label>

<div class="Clear"></div>

<label> Gender</label> 
<label class="value"><%=(procHeader.getHin().getSex()!=null ? procHeader.getHin().getSex().getAdministrativeSexName(): "")%></label>

<label> Medical Officer</label> 
<%
String doctorName = procHeader.getMedicalOfficer().getRank().getRankName()+" "+ procHeader.getMedicalOfficer().getFirstName();
if(procHeader.getMedicalOfficer().getMiddleName()!= null){
	doctorName += " "+procHeader.getMedicalOfficer().getMiddleName();
}
if(procHeader.getMedicalOfficer().getLastName()!= null){
	doctorName += " "+procHeader.getMedicalOfficer().getLastName();
}
%>
<label class="value"><%=doctorName %></label>

<label> Diagnosis</label> 
<%
Visit visit = new Visit();
String diagnosis = "";
Set<OpdPatientDetails> patientDetails = new HashSet<OpdPatientDetails>();
Set<DischargeIcdCode> icdSet = new HashSet<DischargeIcdCode>();

	if(procHeader.getVisit()!=null){
		visit = procHeader.getVisit();
		if(visit.getDischargeIcdCodes()!= null){
			icdSet = visit.getDischargeIcdCodes();
		}
		if(visit.getOpdPatientDetails()!= null){
			patientDetails = visit.getOpdPatientDetails();
			for(OpdPatientDetails opdPatientDetails : patientDetails){
				if(opdPatientDetails.getInitialDiagnosis()!= null){
					diagnosis = opdPatientDetails.getInitialDiagnosis();
				}else{
					if(icdSet.size() > 0){
						for(DischargeIcdCode icdCode : icdSet){
							if(!diagnosis.equals("")){
								diagnosis += ",";
							}
							diagnosis += icdCode.getIcd().getIcdName();
						}
					}
					
				}
			}
		}
		
	}
%>
<label class="valueFixedWidth"><%=diagnosis %></label>

<div class="clear"></div>
</div>
<input type="hidden" name="procHdId" value="<%=procHeader.getId() %>"/>
<div class="clear"></div>
<div class="division"></div>
<h4>Procedure Details</h4>
<div class="Clear"></div>
<div id="pageNavPosition"></div>
<div class="Clear"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0" id="proceduregrid">

	<tr>
		<th></th>
		<th scope="col">Procedure Name</th>
		<th scope="col">Remarks</th>
		<th>Add</th>
		
	</tr>
		<!--<td><input type="text" name="procedure1" id="procedure1" value="" size="70" onblur="if(this.value!=''){getProcedureId(this.value,1);}"/>
		   <div id="ac2update1" style=" display:none; " class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('procedure1','ac2update1','registration?method=getProcedureForAutoComplete',{parameters:'requiredField=procedure1'});
			</script>
		</td>
		<td><input type="hidden" name="procedureId1" id="procedureId1" value=""/>
		<input type="text" name="remarks1" tabindex="1" id="remarks1" size="70" maxlength="40"/></td>
			<td>
			<input name="Button" type="button" class="buttonAdd" value="" onclick="addProcedureRow();" tabindex="1" /> 
			</td>
			<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('proceduregrid');" tabindex="1" />
			</td>
		
	-->
	<%
		int i=1;
	if(box.getInt("procedureId")!=0){
		for(ProcedureDetails proDetails:procDtList){
			if(proDetails.getNursingCare()!=null && box.getInt("procedureId") == proDetails.getNursingCare().getId() && proDetails.getStatus().equalsIgnoreCase("p")){
	%>
	<tr>
		<td><input type="checkbox" name="checkProcedureDtId<%=i %>" id="checkProcedureDtId<%=i %>" value="<%=proDetails.getId() %>"/></td>
		<td><input type="text" name="procedure<%=i %>"	id="procedure<%=i %>" readonly="readonly"
			value="<%= proDetails.getNursingCare().getNursingName() %>" size="70" />
		<input type="hidden" name="proDtId<%=i %>" id="proDtId<%=i %>"			value="<%=proDetails.getId() %>" />
		<div id="ac2update1" style="display: none;" class="autocomplete"></div>
		</td>
		<td><input type="hidden" name="procedureId<%=i %>"			id="procedureId<%=i %>"
			value="<%=proDetails.getNursingCare().getId() %>" /> 
			<input	type="text" name="remarks<%=i %>"
			value="<%=(proDetails.getRemarks()!=null? proDetails.getRemarks():"")%>"
			readonly="readonly" tabindex="1" id="remarks<%=i %>" size="70" /></td>
		<td><input name="Button" type="button" class="buttonAdd" value=""
			onclick="addProcedureRow();" tabindex="1" /></td>
	</tr>
	<%i++;}
		}
		}else{
			for(ProcedureDetails proDetails:procDtList){
	%>
	<tr>
			<td><input type="checkbox" name="checkProcedureDtId<%=i %>" id="checkProcedureDtId<%=i %>" value="<%=proDetails.getId() %>"/></td>
		<td><input type="text" name="procedure<%=i %>"	id="procedure<%=i %>" readonly="readonly"
			value="<%= proDetails.getNursingCare()!=null?proDetails.getNursingCare().getNursingName():proDetails.getProcedureName() %>" size="70" />
		<input type="hidden" name="proDtId<%=i %>" id="proDtId<%=i %>"			value="<%=proDetails.getId() %>" />
		<div id="ac2update1" style="display: none;" class="autocomplete"></div>
		</td>
		<td><input type="hidden" name="procedureId<%=i %>"			id="procedureId<%=i %>"
			value="<%=proDetails.getNursingCare()!=null?proDetails.getNursingCare().getId():0 %>" /> 
			<input	type="text" name="remarks<%=i %>"
			value="<%=(proDetails.getRemarks()!=null? proDetails.getRemarks():"")%>"
			readonly="readonly" tabindex="1" id="remarks<%=i %>" size="70" /></td>
		<td><input name="Button" type="button" class="buttonAdd" value=""
			onclick="addProcedureRow();" tabindex="1" /></td>
	</tr>
		
		<%i++;}} %>
</table>
	<input type="hidden" name="procCount" value="<%=i-1 %>" id="procCount" />
<div class="Clear"></div>
<div class="Block">
<div class="Clear"></div>
<label class="auto"> Procedure Given on <span>*</span></label> 
<input	type="text" name="prcDate" id="prcDate" validate="Procedure Given on,string,yes" value="" class="date" MAXLENGTH="10"  onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'prcDate');checkDateLessThanEqualToCurrent(this.value,this);"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" 
class="calender"	onClick="setdate('<%=currentDate %>',document.minorSurgery.prcDate,event)" /> 

<label class="auto"> At <span>*</span></label> 
<input	type="text" name="prcTime" id="prctime" validate="Procedure Given At,string,yes" value="" MAXLENGTH="5" onKeyUp="if(this.value!=''){mask(this.value,this,'2',':');}" onBlur="if(this.value!=''){IsValidTime(this.value,this.id);}" />

<div class="Clear"></div>
</div>
<div class="division"></div>
<input type="button" name="Submit11" id="addbutton"
	onclick="submitForm('minorSurgery','/hms/hms/registration?method=saveProcedureDetails','validateCheckBox');"
	value="Submit" class="button" accesskey="a" />

<input type="reset" name ="Reset" value ="Reset" class="button" tabindex="1" accesskey="r" />
<div class="Clear"></div>
<div class="division"></div>
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
<script>

function addProcedureRow(){
		
		  var tbl = document.getElementById('proceduregrid');
		  var lastRow = tbl.rows.length;

		  var iteration = lastRow;
		  var row = tbl.insertRow(lastRow);
		  var hdb = document.getElementById('procCount');
		  var iteration = parseInt(hdb.value)+1;
		  hdb.value = iteration;

		  var cell0 = row.insertCell(0);
		  var e0 = document.createElement('input');
		  e0.type = 'checkbox';
		  e0.name = 'checkProcedureDtId'+iteration;
		  e0.id = 'checkProcedureDtId'+iteration;
		  cell0.appendChild(e0);
		  
		  var cell1 = row.insertCell(1);
		  var e1 = document.createElement('input');
		  e1.type = 'text';
		  e1.size = '70';
		  e1.name='procedure'+iteration;
		  e1.id='procedure'+iteration
		  e1.onblur=function() {getProcedureId(this.value,iteration);}
		  cell1.appendChild(e1);
		  new Ajax.Autocompleter('procedure'+iteration,'ac2update1','registration?method=getProcedureForAutoComplete',{parameters:'requiredField=procedure'+iteration});

		  var e11 = document.createElement('input');
		  e11.type = 'hidden';
		  e11.name='procedureId'+iteration;
		  e11.id='procedureId'+iteration
		  cell1.appendChild(e11);
		  
		  var e12 = document.createElement('input');
		  e12.type = 'hidden';
		  e12.name='proDtId'+iteration;
		  e12.id='proDtId'+iteration
		  cell1.appendChild(e12);
		  
		  var cell11 = row.insertCell(2);
		  var e21 = document.createElement('input');
		  e21.type = 'text';
		  e21.name='remarks'+iteration;
		  e21.id='remarks'+iteration
		  e21.size = '70';
		  e21.setAttribute('tabindex','1');
		  cell11.appendChild(e21);
		  
		  var cell12 = row.insertCell(3);
		  var e31 = document.createElement('input');
		  e31.type = 'button';
		  e31.className = 'buttonAdd';
		  e31.name='remarks'+iteration;
		  e31.setAttribute('onClick', 'addProcedureRow();'); 
		  e31.setAttribute('tabindex','1');
		  cell12.appendChild(e31);

}


function getProcedureId(val,inc){
	var index1 = val.lastIndexOf("[");
	var index2 = val.lastIndexOf("]");
	index1++;
	var procId = val.substring(index1,index2);
	document.getElementById('procedureId'+inc).value = procId;
	
}
function validateCheckBox(){
	var injCount = document.getElementById('procCount').value;
	for(var i=1;i<=injCount;i++){
		if(document.getElementById('checkProcedureDtId'+i) && document.getElementById('checkProcedureDtId'+i).checked){
			return true;
			

		}
	}
	alert("Please select one record.")
	return false;
}

</script>