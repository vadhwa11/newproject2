<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : procedureAdviceList.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 22.09.2011    Name: Mukesh Narayan Singh
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
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
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
		List<Object> visitProcedureList = new ArrayList<Object>();
		if(map.get("visitProcedureList")!=null){
			visitProcedureList = (List<Object>)map.get("visitProcedureList");
		}
		List<ProcedureDetails> procDtList = new ArrayList<ProcedureDetails>();
		if(map.get("procDtList")!=null){
			procDtList = (List<ProcedureDetails>)map.get("procDtList");
		}
		int visitId =0;
		int hinId=0;
		Box box= HMSUtil.getBox(request);
		String flag="";
		flag=box.getString("flag");
		System.out.println("flag-->"+flag);
	%>

<form name="procedureAdviceList" action="" method="post">
<h4>Procedure Details</h4>
<div class="Clear"></div>
<div id="pageNavPosition"></div>
<div class="Clear"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0" id="proceduregrid">
<input type="hidden" name="visitId" id="visitId" value="<%=box.getInt("visitId") %>" />
<input type="hidden" name="hinId" id="hinId" value="<%=box.getInt("hinId")%>" />
<input type="hidden" name="doctorId" id="doctorId" value="<%=box.getInt("doctorId")%>" />
	<tr>
		<th scope="col">Procedure Name</th>
		<th scope="col">Remarks</th>
		<th>Add</th>
		<th>Delete</th>
	</tr>
	<%
	int x=0;
	int visitProcedureId=0;
	if(visitProcedureList.size()>0){
	for (Iterator iterator = visitProcedureList.iterator(); iterator
	.hasNext();) {
Object[] object = (Object[]) iterator.next();
ProcedureDetails proDetails=new ProcedureDetails();
proDetails=(ProcedureDetails)object[1];
ProcedureHeader procedureHeader=new ProcedureHeader();
procedureHeader=(ProcedureHeader)object[0];
visitProcedureId=procedureHeader.getId();
%>
<tr>
		<td>
		<input type="text" name="procedurex<%=x %>"	id="procedurex<%=x %>" readonly="readonly"
			value="<%= proDetails.getNursingCare().getNursingName() %>" size="70" />
		<input type="hidden" name="proDtIdx<%=x %>" id="proDtIdx<%=x %>" value="<%=proDetails.getId() %>" />
		</td>
		<td> 
			<input	type="text" name="remarksx<%=x %>"
			value="<%=(proDetails.getRemarks()!=null? proDetails.getRemarks():"")%>"
			readonly="readonly" tabindex="1" id="remarksx<%=x %>" size="70" /></td>
		<%
		if(flag.equalsIgnoreCase("fwc")){
		%>
		<td>&nbsp;
		</td>
    	<td> 
		<input type="button" name="delete" value="" class="buttonDel" onclick="deleteProcedure(<%=proDetails.getId()%>,<%=procedureHeader.getVisit().getId() %>,<%=procedureHeader.getHin().getId() %>,<%=procedureHeader.getMedicalOfficer().getId() %>);" tabindex="1" />
		</td>
		<%
		}else{
		%>
		<td colspan="2"> &nbsp;</td>
		<%
		}
		%>
	</tr>
<%
	}
	}
	%>
	<%
	int i=1;
	if(flag.equalsIgnoreCase("fwc")){
	%>
	<tr>
		<td>
		<input type="hidden" name="visitProcedureId" id="visitProcedureId" value="<%=visitProcedureId%>" />
		<input type="hidden" name="proDtId<%=i %>" id="proDtId<%=i %>" value="" />
		<input type="text" name="procedure<%=i %>" id="procedure<%=i %>" value="" size="70" onblur="if(this.value!=''){getProcedureId(this.value,1);}"/>
		   <div id="ac2update1" style=" display:none; " class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('procedure1','ac2update1','registration?method=getProcedureForAutoComplete',{parameters:'requiredField=procedure1'});
			</script>
		<input type="hidden" name="procedureId<%=i %>" id="procedureId<%=i %>"	value="" /> 
		</td>
		<td>	
			<input	type="text" name="remarks<%=i %>" value="" id="remarks<%=i %>" size="70" />
			</td>
		<td><input name="Button" type="button" class="buttonAdd" value=""
			onclick="addProcedureRow();" tabindex="1" /></td>
			<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow();" tabindex="1" />
			</td>
	</tr>
	<%
	}
	%>
</table>
	<input type="hidden" name="procCount" value="<%=i %>" id="procCount" />
	
	
<div class="Clear"></div>
<%

if(flag.equalsIgnoreCase("fwc")){
%>
<div class="division"></div>
<input type="button" name="Submit11" id="addbutton" onclick="submitPopupForm();"
	value="Submit" class="button" accesskey="a" />
<input type="reset" name ="Reset" value ="Reset" class="button" tabindex="1" accesskey="r" />
<%}else{
	%>
	<input type="button" name="Close" id="Close"
	onclick="window.close();"
	value="Close" class="button" accesskey="a" />
	<%
}
%>
<div class="Clear"></div>
<div class="division"></div>
<%--
 <div class="bottom">
<label>Changed By:</label>   
<label class="value"><%=userName%></label>
        
<label>Changed Date:</label>   
<label class="value"><%=currentDate%></label>
 
<label>Changed Time:</label>   
<label class="value"><%=time%></label>
</div>
--%> 
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=LAST_CHANGED_DATE %>" value="<%=currentDate%>"  />
<input type="hidden" name="<%=LAST_CHANGED_TIME %>"  value="<%=time%>" />
<div class="Clear"></div>

</form>
<script>
function deleteProcedure(procDtId,visitId,hinId,doctorId){
  	var agree = confirm("Are you sure, You want to Delete this Procedure?");
  	if(agree){
  		document.procedureAdviceList.action = '/hms/hms/fwc?method=deleteProcedureDetails&procDtId='+procDtId+'&visitId='+visitId+'&hinId='+hinId+'&doctorId='+doctorId;
  		document.procedureAdviceList.submit();
  		return true;
  	}
  
  }
/*
function deleteProcedure(procDtId,visitId,hinId,doctorId)(
		var url='/hms/hms/fwc?method=deleteProcedureDetails&procDtId='+procDtId+'&visitId='+visitId+'&hinId='+hinId+'&doctorId='+doctorId;
		//document.procedureAdviceList.action=url;
		//document.procedureAdviceList.submit();
}
		*/
function submitPopupForm(){
	submitForm('procedureAdviceList','/hms/hms/fwc?method=saveProcedureDetails');
	window.close()
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
		  
		  var cell11 = row.insertCell(1);
		  var e21 = document.createElement('input');
		  e21.type = 'text';
		  e21.name='remarks'+iteration;
		  e21.id='remarks'+iteration
		  e21.size = '70';
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
		  var e41 = document.createElement('input');
		  e41.type = 'button';
		  e41.className = 'buttonDel';
		  e41.name='delete'+iteration;
		  e41.setAttribute('onClick', 'removeRow();'); 
		  e41.setAttribute('tabindex','1');
		  cell13.appendChild(e41);
}


function getProcedureId(val,inc){
	var index1 = val.lastIndexOf("[");
	var index2 = val.lastIndexOf("]");
	index1++;
	var procId = val.substring(index1,index2);
	document.getElementById('procedureId'+inc).value = procId;
	
}
function removeRow()
{
  var tbl = document.getElementById('proceduregrid');
  var lastRow = tbl.rows.length;
  if (lastRow > 2){
  	tbl.deleteRow(lastRow - 1);
  	var tbl = document.getElementById('proceduregrid');
  	var lastRow = tbl.rows.length;
	  // if there's no header row in the table, then iteration = lastRow + 1
 	var iteration = lastRow - 1;
  	var hdb = document.getElementById('hdb');
  	hdb.value=iteration
  }
}
</script>