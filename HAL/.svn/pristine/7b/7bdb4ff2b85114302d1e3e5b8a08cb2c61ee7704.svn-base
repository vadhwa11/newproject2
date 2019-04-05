<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : physiotherapyAdviceList.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 22.09.2011    Name: Anamika Verma
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>


<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.Visit"%>

<%@page import="jkt.hms.masters.business.MasTherapyType"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
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
		List<MasTherapyType> therapyTypeList  = new ArrayList<MasTherapyType>();
		if(map.get("therapyTypeList")!=null){
			therapyTypeList = (List<MasTherapyType>)map.get("therapyTypeList");
		}
		List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
		if(map.get("frequencyList")!=null){
			frequencyList = (List<MasFrequency>)map.get("frequencyList");
		}
		int visitId =0;
		int hinId=0;
		Box box= HMSUtil.getBox(request);
		String flag="";
		flag=box.getString("flag");
		System.out.println("flag-->"+flag);
		int physioRequisitionHeaderId = 0;
		if(map.get("physioRequisitionHeaderId")!=null){
			physioRequisitionHeaderId = (Integer)map.get("physioRequisitionHeaderId");
		}
	%>

<form name="physiotherapyAdviceList" action="" method="post">
<h4>Physiotherapy Details</h4>
<div class="Clear"></div>
<div id="pageNavPosition"></div>
<div class="Clear"></div>
<script>
var frequencyArray=new Array();</script>
<input type="hidden" name="visitId" id="visitId" value="<%=box.getInt("visitId") %>" />
<input type="hidden" name="hinId" id="hinId" value="<%=box.getInt("hinId")%>" />
<input type="hidden" name="doctorId" id="doctorId" value="<%=box.getInt("doctorId")%>" />
<table border="0" align="center" cellpadding="0" cellspacing="0" id="therapygrid">
	<tr>
		<th scope="col">Therapy Name</th>
		<th colspan="2">Duration</th>
		<th scope="col">Frequency</th>
		<th scope="col">No. of Days</th>
		<th scope="col">Remarks</th>
		<th>Add</th>
		<th>Delete</th>
	</tr>
	<%
	int i = 1;
	%>
<tr>
	<td>
	    <input type="text" value="" tabindex="1" id="therapyTypeId<%=i %>" size="30"  name="therapyType<%=i %>" onblur="if(this.value!=''){getTheraphyId(this.value,<%=i %>);}"  />
	    
	   
	     <div id="ac2update1" style="display:none;"  class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			
			  new Ajax.Autocompleter('therapyTypeId<%=i %>','ac2update1','opd?method=getTherapyTypeListForAutoComplete',{parameters:'requiredField=therapyType<%=i %>'});
			</script>
			<div id="therapyDiv<%=i %>" style="display: none">
			<input type="hidden" name="therapyId<%=i %>" id="therapyId<%=i %>"	value="" /> </div>
		</td>
		
	<td><input type="text" name="duration<%=i %>" tabindex="1" id="durationId<%=i %>"	size="12" maxlength="3" validate="Duration,int,yes"/></td>
	<td width="8%">min</td>
	
	
	<td><select name="frequency<%=i %>" id="frequencyId<%=i %>" tabindex="1"  >
			<option value="0">Select</option>
			<%

		      for(MasFrequency masFrequency : frequencyList){
		       
          %>
			<option value="<%=masFrequency.getId() %>"><%=masFrequency.getFrequencyName()%></option>
			<%} %>
		</select> <%
	    		MasFrequency  masFrequency = new MasFrequency();

			     for (int j = 0; j < frequencyList.size(); j++) {
			        	 masFrequency = (MasFrequency) frequencyList.get(j);
     			 %> <script>

     			frequencyArray[<%=j%>]= new Array();
     			frequencyArray[<%=j%>][0] = "<%=masFrequency.getId()%>";
     			frequencyArray[<%=j%>][1] = "<%=masFrequency.getFrequencyName()%>";
            </script> <% }%>
		</td>
	<td><input type="text" name="noOfDays<%=i %>" tabindex="1" id="noOfDays<%=i %>"  size="3"	maxlength="3" validate="No. of Days,num,no" /></td>
	<td><input type="text" name="remarks<%=i %>" tabindex="1" id="remarks<%=i %>" size="28" maxlength="40"/>
			</td>
			<td>
			<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" /> 
			</td>
			<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('therapygrid','therapyCount',this);" tabindex="1" />
			</td>
		
	</tr>

	
</table>
	<input type="hidden" name="therapyCount" value="<%=i %>" id="therapyCount" />
	
	
<div class="Clear"></div>
<%

if(flag.equalsIgnoreCase("opd") || flag.equalsIgnoreCase("fwc")|| flag.equalsIgnoreCase("fp")){
%>
<div class="division"></div>
<input type="button" name="Submit11" id="addbutton" onclick="submitPopupForm();" tabindex="1"
	value="Submit" class="button" accesskey="a" />
<input type="reset" name ="Reset" value ="Reset" class="button" tabindex="1" accesskey="r" />
	
<%}%>

<%-- 
<%else{
	%>
	<input type="button" name="Close" id="Close"
	onclick="setIdInParent();"
	value="Close" class="button" accesskey="a" />
	<%
}
%>--%>
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
<%
if(physioRequisitionHeaderId!=0){
%>
setIdInParent();
window.close();
<%}%>
function setIdInParent(){
	if(window.opener.document.getElementById('physioRequisitionHeaderId'))
window.opener.document.getElementById('physioRequisitionHeaderId').value = '<%=physioRequisitionHeaderId%>'
//	window.close();	
}

function getTheraphyId(val,inc){
if(val != ""){
		
		var index1 = val.lastIndexOf("[");
		var indexForTheraphyCode = index1;
		var index2 = val.lastIndexOf("]");
		index1++;
		var therapyId = val.substring(index1,index2);
		var indexForTheraphyCode = indexForTheraphyCode--;
		var theraphyCode = val.substring(0,indexForTheraphyCode);

		 
		if(therapyId == "" ) {
	      	document.getElementById('therapyTypeId'+inc).value="";
	      	//document.getElementById('pvmsNo'+inc).value="";
	     // 	document.getElementById('clinicalNotes'+inc).value="";
	 	 // 	document.getElementById('qty'+inc).value="";
	      	return;
		}
	if(therapyId!=""){
		submitProtoAjaxWithDivName('physiotherapyAdviceList','/hms/hms/opd?method=getTheraphyId&counter='+inc+'&therapyId='+therapyId,'therapyDiv'+inc);
	}
}
	
}
function submitPopupForm(){
	//alert("adasdasd");
	submitForm('physiotherapyAdviceList','/hms/hms/opd?method=savePhysiotherapyDetails&flag=<%=flag%>');
//	setTimeout("window.close()");
}

function addRow(){
		
		  var tbl = document.getElementById('therapygrid');
		  var lastRow = tbl.rows.length;

		  var iteration = lastRow;
		  var row = tbl.insertRow(lastRow);
		  var hdb = document.getElementById('therapyCount');
		  var iteration = parseInt(hdb.value)+1;
		  hdb.value = iteration;

		  
		  var cell1 = row.insertCell(0);
		  var e1 = document.createElement('input');
		  e1.type = 'text';
		  e1.size = '30';
		  e1.name='therapyType'+iteration;
		  e1.id='therapyTypeId'+iteration
		  e1.tabindex='1';
		  e1.onblur=function() {getTheraphyId(this.value,iteration);}
		  cell1.appendChild(e1);
		  e1.focus();
		  new Ajax.Autocompleter('therapyTypeId'+iteration,'ac2update1','opd?method=getTherapyTypeListForAutoComplete',{parameters:'requiredField=therapyType'+iteration});

		  var e11 = document.createElement('input');
		  var ediv = document.createElement('div');
		  ediv.id='therapyDiv'+(iteration);
		  ediv.style.display = 'none';
		  e11.type = 'hidden';
		  e11.name='therapyId'+iteration;
		  e11.id='therapyId'+iteration
		  cell1.appendChild(ediv);
		  cell1.appendChild(e11);
		  
		  var cell2 = row.insertCell(1);
		  var e2 = document.createElement('input');
		  e2.type = 'text';
		  e2.name='duration'+iteration;
		  e2.id='durationId'+iteration
		  e2.size = '12'
		  e2.tabindex='1';
		  e2.maxLength='3';
		  cell2.appendChild(e2);

		  
		  var cell3 = row.insertCell(2);
		  cell3.innerHTML='min'
		  //var e2 = document.createElement('input');
		//  e13.type = 'label';
		 // e13.name='min'+iteration;
		//  e13.size = '12'
	//	  cell3.appendChild(e22);
		  
		  var cell4 = row.insertCell(3);
		  var e3 = document.createElement('Select');
		  e3.name='frequency'+iteration;
		  e3.id='frequency'+iteration;
		  e3.classname='smalllabel';
		  e3.tabindex='1';
		  e3.options[0] = new Option('Select', '0');
		   for(var i = 0;i<frequencyArray.length;i++ ){
		      e3.options[i+1] = new Option(frequencyArray[i][1],frequencyArray[i][0]);
		      }
		   cell4.appendChild(e3);

		  var cell5 = row.insertCell(4);
		  var e4 = document.createElement('input');
		  e4.type = 'text';
		  e4.name='noOfDays'+iteration;
		  e4.id='noOfDays'+iteration;
		  e4.size='3';
		  e4.maxLength='3'; 
		  e4.tabindex='1';
		  e4.setAttribute('validate','No. of Days,int,yes');
		  cell5.appendChild(e4);
		  
		  var cell6 = row.insertCell(5);
		  var e5 = document.createElement('input');
		  e5.type = 'text';
		  e5.name='remarks'+iteration;
		  e5.id='remarks'+iteration
		  e5.size = '28';
		  e5.tabindex='1';
		  e5.maxLength='40';
		  cell6.appendChild(e5);
		  
		  var cell7 = row.insertCell(6);
		  var e6 = document.createElement('input');
		  e6.type = 'button';
		  e6.className = 'buttonAdd';
		  e6.name='Button'+iteration;
		  e6.onclick = function(){addRow();};
		  e6.tabindex='1';
		  cell7.appendChild(e6);

		  var cell8 = row.insertCell(7);
		  var e7 = document.createElement('input');
		  e7.type = 'button';
		  e7.className = 'buttonDel';
		  e7.name='delete'+iteration;
		  e7.onclick = function(){removeRow('therapygrid','therapyCount',this);}; 
		  e7.tabindex='1';
		  cell8.appendChild(e7);
}


function getProcedureId(val,inc){
	var index1 = val.lastIndexOf("[");
	var index2 = val.lastIndexOf("]");
	index1++;
	var procId = val.substring(index1,index2);
	document.getElementById('procedureId'+inc).value = procId;
	
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
</script>