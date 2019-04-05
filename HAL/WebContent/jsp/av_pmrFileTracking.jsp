<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.util.Box"%>

<%@page import="jkt.hms.masters.business.MasEmployee"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/divideprototype.js"></script>
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
<script type="text/javascript">
	var receivArray=new Array();
	var dispatchArray=new Array();
</script>
<form name="pmrFileTracking" action="" method="post">
<%
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Object[]> unitList = null;		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");  
	
		Map<String, Object> dtmap = new HashMap<String, Object>();
		String message = "";
		if(map.get("message")!= null){
			message = (String)map.get("message");
		}
		if(map.get("dtmap") != null){
			dtmap = (Map<String, Object>)map.get("dtmap");
		}		
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		if(map.get("employeeList") !=null){
			employeeList=(List<MasEmployee>)map.get("employeeList");
			
		}
		Box box = HMSUtil.getBox(request);
	%>

<h4><%=message %></h4>
<div class="Clear"></div>
<div class="titleBg">
<h2>PMR File Tracking</h2>
</div>
<div class="Clear"></div>
<div id="valueDiv">
<div class="cmntable">
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="appTable">
	<tr>

		<th scope="col">Licence No.</th>
		<th scope="col">Name</th>
		<th scope="col">Appointment Date</th>
		<th scope="col">PMR Received Date</th>
		<th scope="col">Received By</th>
		<th scope="col">Exam Date</th>
		<th scope="col">PMR Dispatch Date</th>
		<th scope="col">Dispatch By</th>
		<th scope="col">Remarks</th>
		<th scope="col">Add</th>
		<th scope="col">Delete</th>

	</tr>
	<%int i=1;	%>

	<tr>
		<td><input type="text" name="<%=LICENCE_NO %>>"
			id="licenceNo<%=i %>" onblur="checkForLicenceNo(this.value,<%=i %>);"
			validate="Licence No.,metachar,yes" /> <input name="avic34Id"
			id="avic34Id<%=i %>" type="hidden" /></td>


		<td><input type="text" name="<%=NAME %>" id="<%=NAME %><%=i %>" validate="Name,metachar,no"
			readonly="readonly" /></td>


		<td><input type="text" name="<%=APPOINTMENT_DATE %>"
			id="appointmentDate<%=i %>" value="" class="date" readonly="readonly" validate="Name,frdate,no" />
		</td>

		<td><input type="text" name="<%=RECEIVED_DATE %>" id="<%=RECEIVED_DATE %><%=i %>"
			value="" MAXLENGTH="20" size="8" validate="PMR Received Date,date,yes" /> 
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"
			 onClick="setdate('',document.pmrFileTracking.<%=RECEIVED_DATE %>,event)" /></td>

		<td><select name="<%=RECEIVED_BY %>" id="<%=RECEIVED_BY %><%=i %>">
			<option value="0">Select</option>
			<%for(MasEmployee masEmployee:employeeList){
			String lastName="";
			if(masEmployee.getLastName() !=null){
				lastName=masEmployee.getLastName();
			}
			%>
			<option value="<%=masEmployee.getId() %>"><%=masEmployee.getRank().getRankName()+" "+masEmployee.getFirstName()+" "+lastName %></option>
			<%} %>
		</select> <%
        int i1=0;
for (MasEmployee recEmployee : employeeList)
    {
     			 %> <script>

     			receivArray[<%=i1%>]= new Array();
     			receivArray[<%=i1%>][0] = "<%=recEmployee.getId()%>";
     			<%String lastName="";
     			if(recEmployee.getLastName() !=null){
     				lastName=recEmployee.getLastName();
     			}%>
     			receivArray[<%=i1%>][1] = "<%=recEmployee.getRank().getRankName()+" "+recEmployee.getFirstName()+" "+lastName %>";
            </script> <%
++i1;
}%>
		</td>


		<td><input type="text" name="<%=EXAMINATION_DATE %>"
			id="medExamDate<%=i %>" value="" MAXLENGTH="20" class="date" readonly="readonly" /></td>


		<td><input type="text" name="<%=DISPATCH_DATE %>"
			id="<%=DISPATCH_DATE %><%=i %>" value="" MAXLENGTH="20"
			size="8" validate="Dispatch Date,date,no" /> <img
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onClick="setdate('',document.pmrFileTracking.<%=DISPATCH_DATE %>,event)" /></td>


		<td><select name="<%=DISPATCHED_BY%>" id="<%=DISPATCHED_BY %><%=i %>">
			<option value="0">Select</option>
			<%   for(MasEmployee masEmployee:employeeList){
		String lastName="";
		if(masEmployee.getLastName() !=null){
			lastName=masEmployee.getLastName();
		}%>
			<option value="<%=masEmployee.getId() %>"><%=masEmployee.getRank().getRankName()+" "+masEmployee.getFirstName()+" "+lastName %></option>
			<%} %>
		</select> <%
int i2=0;
for (MasEmployee disEmployee : employeeList)
{
     			 %> <script>

     			dispatchArray[<%=i2%>]= new Array();
     			dispatchArray[<%=i2%>][0] = "<%=disEmployee.getId()%>";
     			<%String lastName="";
     			if(disEmployee.getLastName() !=null){
     				lastName=disEmployee.getLastName();
     			}%>
     			dispatchArray[<%=i2%>][1] = "<%=disEmployee.getRank().getRankName()+" "+disEmployee.getFirstName()+" "+lastName%>";
            </script> <%
++i2;
}%>
		</td>


		<td><input type="text" name="<%=REMARKS%>"
			id="<%=REMARKS %><%=i %>" maxlength="49" validate="Remarks,metachar,no" /></td>


		<td><input name="Button" type="button" class="buttonAdd" value=""
			onclick="generateRow('appTable');" tabindex="1" /></td>


		<td><input type="button" name="delete" value="" class="buttonDel"
			onclick="removeRow('appTable','cnt',this);" tabindex="1" /></td>
	</tr>


</table>
<input type="hidden" id="cnt" name="cnt" value="<%=i %>" /></div>

<div class="clear paddingTop15"></div>
<input type="button" name="save" value="Submit" class="button"
	accesskey="a"
	onclick="submitForm('pmrFileTracking','/hms/hms/aviationMedicine?method=submitPMRFileTracking');" />
<input type="reset" name="Reset" value="Reset" class="button"
	tabindex="1" accesskey="r" /></div>
<div class="clear paddingTop15"></div>
<div class="clear"></div>
<div class="Block"><label>Licence No. </label> <input type="text"
	value="" name="searchLicenceNo" tabindex="2" maxlength="15"
	id="searchLicenceNo" /> <label>Name </label> <input type="text"
	value="" name="searchName" id="searchName" tabindex="2" maxlength="32" />

<label>Exam Due Date </label> <input type="text" name="searchExamDate"
	value="" MAXLENGTH="7" class="date" validate="Exam Due Date,date,no"
	id="searchExamDate" /> <img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onClick="setdate('',document.pmrFileTracking.searchExamDate,event)" />

<label>Appointment Date </label> <input type="text"
	name="searchAppointDate" value="" MAXLENGTH="7" class="date"
	id="searchAppointDate" validate="Appointment Date,date,no" /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.pmrFileTracking.searchAppointDate,event)" />
</div>

<div class="Clear"></div>
<div class="clear paddingTop15"></div>
<input type="button" name="search" onclick="searchTable();"
	value="Search" class="button" /> <input type="reset" name="Reset"
	value="Reset" class="button" tabindex="1" accesskey="r" />
<div class="Clear"></div>
<div class="clear paddingTop15"></div>
</form>
<script type="text/javascript">

function generateRow(idName) {
    	
	  var tbl = document.getElementById(idName);
	  var lastRow = tbl.rows.length;

	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('cnt');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;

	  var cell0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.size='20';
	  e0.name='<%=LICENCE_NO%>';
	  e0.id='<%=LICENCE_NO%>'+iteration
	  e0.onblur= function(){
	     checkForLicenceNo(this.value,iteration);
	  };

	  var e110 = document.createElement('input');
	  e110.type = 'hidden';
	  e110.size='20';
	  e110.name='avic34Id';
	  e110.id='avic34Id'+iteration
	  cell0.appendChild(e110);
	  cell0.appendChild(e0);

	  var cell1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.size='20';
	  e1.name='<%=NAME%>';
	  e1.id='<%=NAME%>'+iteration
	  cell1.appendChild(e1);


	  var cell2 = row.insertCell(2);
	  	 var e2 = document.createElement('input');
	  	 e2.type = 'text';
	  	 e2.readOnly = true;
	  	 e2.name='appointmentDate';
	  	 e2.id='appointmentDate'+iteration;
	  	 cell2.appendChild(e2); 

	  var cell3 = row.insertCell(3);
	  	 var e3 = document.createElement('input');
	  	 e3.type = 'text';
	  	 e3.readOnly = true;
	  	 e3.name='<%=RECEIVED_DATE%>';
	  	 e3.id='<%=RECEIVED_DATE%>'+iteration;
	  	 e3.size="8"
	  	 cell3.appendChild(e3); 
	
	  	 var eImg = document.createElement('img');
	  	 eImg.src = '/hms/jsp/images/cal.gif';
	  	 eImg.id = 'calId1'+iteration;
	  	 eImg.onclick = function(event){
	  	     setdate('',document.getElementById('date'+iteration),event) };
	  	
	  	  cell3.appendChild(eImg);

	  	 var cell4 = row.insertCell(4);
	  	  var e4 = document.createElement('Select');
	  	 	e4.name='<%=RECEIVED_BY%>';
		  	e4.id='<%=RECEIVED_BY%>'+iteration
		  	e4.setAttribute('tabindex','1');
		  	e4.options[0] = new Option('Select', '0');
		   for(var i= 0;i<receivArray.length;i++ ){
		      e4.options[i+1] = new Option(receivArray[i][1],receivArray[i][0]);
		      }
		   cell4.appendChild(e4);

	 	 var cell5 = row.insertCell(5);
	  	 var e5 = document.createElement('input');
	  	 e5.type = 'text';
	  	 e5.readOnly = true;
	  	 e5.name='examinationDate';
	  	 e5.id='examinationDate'+iteration;
	  	 cell5.appendChild(e5); 


		  var cell6 = row.insertCell(6);
	  	 var e6 = document.createElement('input');
	  	 e6.type = 'text';
	  	 e6.readOnly = true;
	  	 e6.name='dispatchDate';
	  	 e6.id='dispatchDate'+iteration;
	  	 e6.size="8";
	  	 cell6.appendChild(e6); 

	  	 var eImg = document.createElement('img');
	  	 eImg.src = '/hms/jsp/images/cal.gif';
	  	 eImg.id = 'calId1'+iteration;
	  	 eImg.onclick = function(event){
	  	     setdate('',document.getElementById('dispatchDate'+iteration),event) };
	  	
	  	 cell6.appendChild(eImg);
  

		  var cell7 = row.insertCell(7);
		  var e7 = document.createElement('Select');
		  e7.name='<%=DISPATCHED_BY%>';
		  e7.id='<%=DISPATCHED_BY%>'+iteration
		  e7.setAttribute('tabindex','1');
		  e7.options[0] = new Option('Select', '0');
		   for(var ii = 0;ii<dispatchArray.length;ii++ ){
			   e7.options[ii+1] = new Option(dispatchArray[ii][1],dispatchArray[ii][0]);
		      }
		   cell7.appendChild(e7);

		   var cell8 = row.insertCell(8);
		   var e8 = document.createElement('input');
		   e8.type = 'text';
		   e8.name = '<%=REMARKS%>' ;
		   e8.id = '<%=REMARKS%>' + iteration;
		//   e8.size = '5';
		   e8.setAttribute('maxlength', 49);
		   e8.setAttribute('tabindex','1');
		   cell8.appendChild(e8);
	   
		  var cellRight9 = row.insertCell(9);
		  var e9 = document.createElement('input');
		  e9.type = 'button';
		  e9.className = 'buttonAdd';
		  e9.setAttribute('onClick', 'generateRow("appTable");'); 
		  e9.setAttribute('tabindex','1');
		  cellRight9.appendChild(e9);

	  var cellRight10 = row.insertCell(10);
	  var e10 = document.createElement('input');
	  e10.type = 'button';
	  e10.className = 'buttonDel';
	  e10.setAttribute('onClick', 'removeRow("appTable","hdb",this);'); 
	  e10.setAttribute('tabindex','1');
	  cellRight10.appendChild(e10);
	  
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


function checkForLicenceNo(val,inc){
	if(val != "")
	{
	for(i=1;i<inc;i++){
	
	if(inc != 1){
	if(document.getElementById('licenceNo'+i).value==val)
	{
		alert("Licence No already selected...!")
		document.getElementById('licenceNo'+inc).value=""
		var e=eval(document.getElementById('licenceNo'+inc)); 
		e.focus();
		return false;
	} }  }
		
	
	ajaxFunctionForLicenceNo('pmrFileTracking','aviationMedicine?method=fillItemsForLicenceNo&licenceNo='+val , inc);
	
	}else{
		document.getElementById('name'+inc).value = "";
		document.getElementById('appointmentDate'+inc).value = "";
		document.getElementById('avic34Id'+inc).value = "";
	}
}

function searchTable(){
	var errorMsg =""
		errorMsg=document.getElementById("searchLicenceNo").value;
		errorMsg=errorMsg+document.getElementById("searchName").value;
		errorMsg=errorMsg+document.getElementById("searchExamDate").value;
		errorMsg=errorMsg+document.getElementById("searchAppointDate").value;
		if(errorMsg==""){
			alert("Please fill any one of value...!");
			return false
		}else{
			
	  	//document.getElementById("searchTableDiv").style.display='none';
	  	submitProtoAjaxWithDivName('pmrFileTracking','aviationMedicine?method=getDetailAfterSearch','valueDiv');
	  	return true;
		}

}

</script>
