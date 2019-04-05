
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasCommand"%>
<%@page import="jkt.hms.masters.business.Category"%>
<%@page import="jkt.hms.masters.business.PatientFamilyHistory"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
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
			  new Ajax.Autocompleter('systemDiagnosis'+iteration,'ac2update'+iteration,'medicalBoard?method=autoCompleteForIcdDiagnosis',{parameters:'requiredField=systemDiagnosis'+iteration});
	
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
<form name="midData" method="post" action="">
<div class="titleBg"><h2>MID Data</h2></div>
     	
<div class="Block">

<label>Service No.</label>
<input type="text" name="serviceNo" />

<label>Name</label>
<input type="text" name="name" />

<label>Rank</label>
<select><option></option></select>

<div class="clear"></div>

<label>Unit</label>
<select><option></option></select>

<label>Command</label>
<select><option></option></select>

<label>Trade/ Branch</label>
<input type="text" name="tradeBranch" />

<div class="clear"></div>

<label>Age</label>
<input type="text" name="age" />

<label>Med Cat</label>
<select><option></option></select>

<label>Exam/ Board</label>
<select>
<option>Board</option>
<option>Exam</option>
</select>

<div class="clear"></div>

<label>Exam Category <span>*</span></label> 
<select id="medExamCategory" name="medExamCategory"	tabindex="1" class="">
	<option value="">Select</option>
	<option value="Annual Medical Exam(AFMSF-3B)">Annual Medical Exam(AFMSF-3B)</option>
	<option value="Med. Exam On Release/Discharge(AFMSF-18)">Med. Exam On Release/Discharge(AFMSF-18)</option>
	<option value="Primary/Extension Med. Exam(AFMSF-2A)">Primary/Extension	Med. Exam(AFMSF-2A)</option>
	<option value="Prior To Proceedings Abroad Med. Exam(AFMSF-3B)">Prior To Proceedings Abroad Med. Exam(AFMSF-3B)</option>
	<option value="High Altitude Med. Exam(AFMSF-3B)">High Altitude Med. Exam(AFMSF-3B)</option>
</select>


<label>Board Category <span>*</span></label> 
<select id="medBoardCategory" name="medBoardCategory" class=""	tabindex="1">
	<option value="">Select</option>
	<option value="Initial Medical Board AFMSF 15">Initial Medical Board AFMSF 15</option>
	<option value="Medical Board Review AFMSF 15">Medical Board	Review AFMSF 15</option>
	<option value="Medical Board AFMSF 16">Medical Board AFMSF 16</option>
</select>

<%--
<label> Reporting Date </label>
<input	tabindex="1" name="reportingDate"  class="date" value="" validate="DOB,date,yes" maxlength="10" onKeyUp="mask(this.value,this,'2,5','/');" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',midData.reportingDate,event);"/>
 --%>


<label> Date of Completion </label>
<input	tabindex="1" name="completionDate"  class="date" value="" validate="DOB,date,yes" maxlength="10" onKeyUp="mask(this.value,this,'2,5','/');" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',midData.reportingDate,event);"/>

<div class="clear"></div>

<label>Remarks</label>
<input type="text" name="remarks" />

</div>  
<div class="clear paddingTop15"></div>

<h4>Medical Details</h4>
<div class="Block">

<label>Height</label>
<input type="text" name="height" class="auto" size="17"/>
<label class="unit">cm</label>

<label>Weight</label>
<input type="text" name="weight" class="auto" size="17"/>
<label class="unit">kg</label>

<label>Ideal Weight</label>
<input type="text" name="idealWeight" class="auto" size="17"/>
<label class="unit">kg</label>

<div class="clear"></div>

<label>Over Weight</label>
<input type="text" name="overWeight" class="auto" size="17"/>
<label class="unit">kg</label>

<label>Waist</label>
<input type="text" name="waist" class="auto" size="17"/>

<input class="transparent" size="6" />

<label>Hip</label>
<input type="text" name="hip" />

<div class="clear"></div>

<label>WHR</label>
<input type="text" name="whr" />

<label>BP</label>
<input type="text" name="bp" class="auto" size="17"/>

</div>   	

<div class="clear paddingTop15"></div>
<h4>Disability</h4>
<table class="cmntable">

<tr>
<th>Disability</th>
<th>Add</th>
<th>Delete</th>
</tr>

<tr>
<td><input type="text" name="disability" /></td>
<td><input name="Button" type="button" class="buttonAdd" value="" onclick="addRowForDisability();" tabindex="1" /></td>
<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRowDisability();" tabindex="1" /></td>
</tr>

</table>

</form>
<div class="clear paddingTop15"></div>

<div class="division"></div>

<input tabindex="1" name="Button" type="button" class="Button" value="Submit" onClick="submitForm('addMedicalExamDetails','medicalBoard?method=addOldMedicalBoardData');" />
<input type="Button" name="reset" class="Button" value="Reset" />

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


<script type="text/javascript" language="javascript">

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
	  new Ajax.Autocompleter('systemDiagnosis'+iteration,'ac2update'+iteration,'medicalBoard?method=autoCompleteForIcdDiagnosis',{parameters:'requiredField=systemDiagnosis'+iteration});

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
</script>



