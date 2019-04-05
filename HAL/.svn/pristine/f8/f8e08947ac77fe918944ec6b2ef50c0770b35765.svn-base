<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.MasEcgType"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>

<%@page import="jkt.hms.masters.business.MasFrequency"%>

<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.InjectionRegisterDetails"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionHeader"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.InjAppointmentDetails"%>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
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
	
		String message = "";
		if(map.get("message") != null){
			message = (String)map.get("message");
		}
		List<InjAppointmentDetails> injectionList = new ArrayList<InjAppointmentDetails>();
		if(map.get("injectionList") != null){
			injectionList= (List<InjAppointmentDetails>)map.get("injectionList");
		}
		PatientPrescriptionHeader prescriptionHeader = new PatientPrescriptionHeader();
		if(injectionList.size() > 0){
			prescriptionHeader = injectionList.get(0).getInjAppointmentHeader().getPrescription();
		}
	/*	List<InjectionRegister> injectionList = new ArrayList<InjectionRegister>();
		if(map.get("injectionList") != null){
			injectionList= (List<InjectionRegister>)map.get("injectionList");
		}
		InjectionRegister injectionRegister = new InjectionRegister();
		if(injectionList.size() > 0){
			injectionRegister = injectionList.get(0);
		}*/
		
		List<MasFrequency> freqList = new ArrayList<MasFrequency>();
		
		if(map.get("freqList") != null){
			freqList = (List<MasFrequency>)map.get("freqList");
		}
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		int item_category_id=0;
		try {
			properties.load(resourcePath.openStream());
			String item_category_code = properties.getProperty("item_category_id");
			item_category_id=Integer.parseInt(item_category_code);
		} catch (Exception e) {
			e.printStackTrace();
		}
	%>
	<h4><%=message %></h4>
	<div class="clear"></div>
	<div class="titleBg"><h2>Injection Appointment</h2></div>
	<div class="clear"></div>
<h4>Patient Details</h4>
<div class="clear"></div>
<form name="injectionAppointment" action="" method="post">
<div class="Block">
<label>Service No.</label>
<label class="value"><%=prescriptionHeader.getHin().getServiceNo() !=null?prescriptionHeader.getHin().getServiceNo() :""%></label>
<input type="hidden" name="serviceNo" value="<%=prescriptionHeader.getHin().getServiceNo()!=null?prescriptionHeader.getHin().getServiceNo() :"" %>" id="serviceNo"/>
<input type="hidden" name="hinId" value="<%=prescriptionHeader.getHin().getId() %>" id="hinId"/>
<input type="hidden" name="visitId" value="<%=prescriptionHeader.getVisit().getId() %>" id="visitId"/>
<input type="hidden" name="presHdId" value="<%=prescriptionHeader.getId() %>" id="presHdId"/>
<label>Patient Name</label> 
<%
String middleName = "";
String lastName = "";
if(prescriptionHeader.getHin().getPMiddleName() != null){
	middleName = prescriptionHeader.getHin().getPMiddleName();
}
if(prescriptionHeader.getHin().getPLastName() != null){
	lastName = prescriptionHeader.getHin().getPLastName();
}

%>
<label class="value"><%=prescriptionHeader.getHin().getPFirstName()+" "+middleName+" "+lastName %></label>
<input type="hidden" name="patientName" value="<%=prescriptionHeader.getHin().getPFirstName()+" "+middleName+" "+lastName %>" id="patientName"/>
<div class="Clear"></div>
<label>Relation</label> 
<label class="value"><%=prescriptionHeader.getHin().getRelation().getRelationName()%></label>
<input type="hidden" name="relation" value="<%=prescriptionHeader.getHin().getRelation().getRelationName() %>" id="relation"/>

<label>Rank</label>
<label class="value"><%=prescriptionHeader.getHin().getRank().getRankName()%></label> 
<input type="hidden" name="rank" value="<%=prescriptionHeader.getHin().getRank().getRankName() %>" id="rank"/>
<label>Name</label> 
<%
String sMiddleName = "";
String sLastName = "";

	if(prescriptionHeader.getHin().getSMiddleName() != null){
		sMiddleName = prescriptionHeader.getHin().getSMiddleName();
	}
	if(prescriptionHeader.getHin().getSLastName() != null){
		sLastName = prescriptionHeader.getHin().getSLastName();
	}
%>
<label class="value"><%=prescriptionHeader.getHin().getSFirstName()+" "+sMiddleName+" "+sLastName %></label> 
<input type="hidden" name="name" value="<%=prescriptionHeader.getHin().getSFirstName()+" "+sMiddleName+" "+sLastName  %>" id="name"/>
<div class="Clear"></div>
 
<label>Unit</label> 
<label class="value"><%=prescriptionHeader.getHin().getUnit().getUnitName()%></label>

<label>Branch/Trade</label> 
<label class="value"><%=(prescriptionHeader.getHin().getTrade()!=null?prescriptionHeader.getHin().getTrade().getTradeName():"")%></label>

<label> Age</label> 
<label class="value"><%=(prescriptionHeader.getHin().getAge()!=null ? prescriptionHeader.getHin().getAge(): "")%></label>

<div class="Clear"></div>

<label> Gender</label> 
<label class="value"><%=(prescriptionHeader.getHin().getSex()!=null ? prescriptionHeader.getHin().getSex().getAdministrativeSexName(): "")%></label>


<label> Diagnosis</label> 
<%
Visit visit = new Visit();
String diagnosis = "";
Set<OpdPatientDetails> patientDetails = new HashSet<OpdPatientDetails>();
Set<DischargeIcdCode> icdSet = new HashSet<DischargeIcdCode>();

	if(prescriptionHeader.getVisit()!=null){
		visit = prescriptionHeader.getVisit();
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
<label class="value"><%=diagnosis %></label>

<label> Medical Officer</label> 
<%
String doctorName = prescriptionHeader.getEmp().getRank().getRankName()+" "+prescriptionHeader.getEmp().getFirstName();
if(prescriptionHeader.getEmp().getMiddleName()!= null){
	doctorName += " "+prescriptionHeader.getEmp().getMiddleName();
}
if(prescriptionHeader.getEmp().getLastName()!= null){
	doctorName += " "+prescriptionHeader.getEmp().getLastName();
}
%>
<label class="value"><%=doctorName %></label>
<input type="hidden" name="moId" value="<%=prescriptionHeader.getEmp().getId() %>" id="moId"/>
<div class="clear"></div>
</div>
<div class="clear"></div>
<h4>Injection Details</h4>
<div class="Clear"></div>
<div id="pageNavPosition"></div>
<div class="Clear"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0" id="injection">

	<tr>
	<th scope="col"></th>
		<th scope="col">Injection Name</th>
		<th scope="col">Dose</th>
		<th scope="col">Route</th>
		<th scope="col">Frequency</th>
		<th scope="col">No. of Days</th>
		<th scope="col">A/U</th>
		<th scope="col">Quantity Issued</th>
	</tr>
	<% int i=1;
		for(InjAppointmentDetails injAppointmentDetails : injectionList){
			
		if(injAppointmentDetails.getItem().getItemCategory()!=null && injAppointmentDetails.getItem().getItemCategory().getId()==item_category_id){
		
	%>
	<tr>	<td><input type="checkbox" name="presDtId<%=i %>" id="presDtId<%=i %>" value="<%=  injAppointmentDetails.getPatientPrescriptionDetails().getId()%>" onclick="addRow(this,<%=i %>);"/></td>
		<td><input type="text" name="injectionName<%=i %>" id="injectionName<%=i %>" value="<%= injAppointmentDetails.getItem().getNomenclature() %>" validate="Injection Name,string,yes" onblur="if(this.value!=''){getItemId(this.value,1);}" size="60"/>
</td>
		<td>
		<input type="hidden" name="injectionId<%=i %>" id="injectionId<%=i %>" value="<%=  injAppointmentDetails.getItem().getId()%>"/>
		<input type="text" name="dose<%=i %>" id="dose<%=i %>" value="<%= injAppointmentDetails.getDose()!=null?injAppointmentDetails.getDose():"" %>"size="2" maxlength="4" validate="" /></td>
		<td><input type="text" name="route<%=i %>" id="route<%=i %>" value="<%= injAppointmentDetails.getRoute()!=null? injAppointmentDetails.getRoute():"" %>" class="small"/></td>
		<td><input type="text" name="freq<%=i %>" id="freq<%=i %>" value="<%= injAppointmentDetails.getFrequency()!=null?injAppointmentDetails.getFrequency().getFrequencyName():"" %>" size="5"/>
		<input type="hidden" name="frequencyId<%=i %>" id="frequencyId<%=i %>" value="<%=injAppointmentDetails.getFrequency()!=null? injAppointmentDetails.getFrequency().getId():0 %>" class="small"/>
		</td>
		<td><input type="text" name="noOfDays<%=i %>" id="noOfDays<%=i %>" value="<%= (injAppointmentDetails.getNoOfDays()!=null?injAppointmentDetails.getNoOfDays():"") %>"size="3"/></td>
		<td><input type="text" name="au<%=i %>" value="<%= (injAppointmentDetails.getItem().getItemConversion()!=null?injAppointmentDetails.getItem().getItemConversion().getItemUnitName():"") %>" class="small"/></td>
		
		<td><input type="text" name="qtyIssued<%=i %>" value="<%= (injAppointmentDetails.getPatientPrescriptionDetails().getQtyIssued()!=null?injAppointmentDetails.getPatientPrescriptionDetails().getQtyIssued():"") %>" class="small"/></td>
			
		
	</tr>
	<%i++;
		}
		}%>
</table>
	<input type="hidden" name="injCount" value="<%=i %>" id="injCount" />

<div class="clear"></div>
<input type="hidden" name="injectionRegisterId" value="<%=prescriptionHeader.getId() %>"/>
<div class="clear"></div>
<h4>Appointment List</h4>
<div class="Clear"></div>
<div class="Block">

<label> Date <span>*</span></label> 
<input	type="text" name="injAppDate" id="injAppDate" validate="Injection Given On,string,yes" value="" class="date" readonly="readonly" MAXLENGTH="8" onblur="checkDate(this.value);"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" 
class="calender"	onClick="setdate('<%=currentDate %>',document.injectionAppointment.injAppDate,event)" /> 
<input type="button" name="go" value="Go" class="buttonSm" onclick="submitProtoAjax('injectionAppointment','/hms/hms/registration?method=getInjectionAppointmentDetails');">
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<div id="testDiv">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="injectionApp">

	<tr>
		<th scope="col">Time</th>
		<th scope="col">Injection Name</th>
		<th scope="col">Service No.</th>
		<th scope="col">Patient Name</th>
		<th scope="col">Relation</th>
		<th scope="col">Rank</th>
		<th scope="col">Name</th><!--
		<th scope="col"></th>-->
		<th scope="col"></th>
	</tr>
	<% int j=0;
	%>
	
<%--	<tr>	
		<td><input type="text" name="appTime<%=j %>" id="appTime<%=j %>" value="" size="10"/>
		<input type="hidden" name="appPresDtId<%=j %>" id="appPresDtId<%=j %>" value=""/></td>
		<td><input type="text" name="appInjectionName<%=j %>" id="appInjectionName<%=j %>" value="" validate="Injection Name,string,yes" onblur="if(this.value!=''){getItemId(this.value,1);}" size="30"/>
		<input type="hidden" name="appInjectionId<%=i %>" id="appInjectionId<%=i %>" value=""/></td>
		<td><input type="text" name="appServiceNo<%=j %>" id="appServiceNo<%=j %>" value="" size="15"/></td>
		<td><input type="text" name="appPatientName<%=j %>" id="appPatientName<%=j %>" value="" size="20" maxlength="4" validate="" /></td>
		<td><input type="text" name="appRelation<%=i %>" id="appRelation<%=i %>" value="" size="10"/></td>
		<td><input type="text" name="appRank<%=j %>" id="appRank<%=j %>" value="" size="15"/></td>
		<td><input type="text" name="appName<%=j %>" id="appName<%=j %>" value="" size="20"/></td>
		<!--<td><input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" /></td>
		<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('');"  /></td>
		
	--></tr> --%>
	
</table>
	<input type="hidden" name="hdb" value="<%=j %>" id="hdb" />
	</div>
<div class="division"></div>
<input type="button" name="Submit11" id="addbutton"
	onclick="submitForm('injectionAppointment','/hms/hms/registration?method=saveInjectionAppointment');"
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
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>"  />
<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />
<div class="Clear"></div>

</div>
</form>

<script>
function getItemId(val){
	var index1 = val.lastIndexOf("[");
    var indexForNomenclature=index1;
    var index2 = val.lastIndexOf("]");
    index1++;
    var pvmsNo = val.substring(index1,index2);
    ajaxFunctionForAutoCompletePVMS('minorSuregery','opdMaster?method=fillItemsInGrid&pvmsNo='+pvmsNo);
}

function addRow(obj,inc){
	var tbl = document.getElementById('injectionApp');
	var appCnt = document.getElementById('hdb').value;

	
		if(obj.checked){

		 if(document.getElementById('injAppDate').value!=""){
			
		  var lastRow = tbl.rows.length;

		  var iteration = lastRow;
		  var row = tbl.insertRow(lastRow);
		  var hdb = document.getElementById('hdb');
		  var iteration = parseInt(hdb.value)+1;
		  hdb.value = iteration;
						
		  var cell1 = row.insertCell(0);
		  var e1 = document.createElement('input');
		  e1.type = 'text';
		  e1.size = '10';
		  e1.name='appTime'+iteration;
		  e1.id='appTime'+iteration
		  e1.maxLength='5';
		  e1.onkeyup=function(){if(this.value!=''){mask(this.value,this,'2',':')}}
		  e1.onblur=function(){if(this.value!=''){IsValidTime(this.value,this.id)}}
	
		  var e11 = document.createElement('input');
		  e11.type = 'hidden';
		  e11.name='appPresDtId'+iteration;
		  e11.id='appPresDtId'+iteration
		  e11.value = document.getElementById('presDtId'+inc).value;
		  cell1.appendChild(e1);
		  cell1.appendChild(e11);
	
		  var cell2 = row.insertCell(1);
		  var e2 = document.createElement('input');
		  e2.type = 'text';
		  e2.size = '30';
		  e2.name='appInjectionName'+iteration;
		  e2.id='appInjectionName'+iteration
		  e2.value = document.getElementById('injectionName'+inc).value;
	
		  var e21 = document.createElement('input');
		  e21.type = 'hidden';
		  e21.name='appInjectionId'+iteration;
		  e21.id='appInjectionId'+iteration
		  e21.value = document.getElementById('injectionId'+inc).value;
		  cell2.appendChild(e21);
		  cell2.appendChild(e2);
	
		  var cell3 = row.insertCell(2);
		  var e3 = document.createElement('input');
		  e3.type = 'text';
		  e3.size = '15';
		  e3.name='appServiceNo'+iteration;
		  e3.id='appServiceNo'+iteration
		  e3.value = document.getElementById('serviceNo').value;
		  cell3.appendChild(e3);
	
		  var cell4 = row.insertCell(3);
		  var e4 = document.createElement('input');
		  e4.type = 'text';
		  e4.size = '20';
		  e4.name='appPatientName'+iteration;
		  e4.id='appPatientName'+iteration;
		  e4.value = document.getElementById('patientName').value;
		  cell4.appendChild(e4);
	
		  var cell5 = row.insertCell(4);
		  var e5 = document.createElement('input');
		  e5.type = 'text';
		  e5.size = '10';
		  e5.name='appRelation'+iteration;
		  e5.id='appRelation'+iteration;
		  e5.value = document.getElementById('relation').value;
		  cell5.appendChild(e5);
	
		  var cell6 = row.insertCell(5);
		  var e6 = document.createElement('input');
		  e6.type = 'text';
		  e6.size = '15';
		  e6.name='appRank'+iteration;
		  e6.id='appRank'+iteration;
		  e6.value = document.getElementById('rank').value;
		  cell6.appendChild(e6);
	
		  var cell7 = row.insertCell(6);
		  var e7 = document.createElement('input');
		  e7.type = 'text';
		  e7.size = '20';
		  e7.name='appName'+iteration;
		  e7.id='appName'+iteration;
		  e7.value = document.getElementById('name').value;

		  var e71 = document.createElement('input');
		  e71.type = 'hidden';
		  e71.name='appDose'+iteration;
		  e71.id='appDose'+iteration;
		  e71.value = document.getElementById('dose'+inc).value;

		  var e72 = document.createElement('input');
		  e72.type = 'hidden';
		  e72.name='appFrequencyId'+iteration;
		  e72.id='appFrequencyId'+iteration;
		  e72.value = document.getElementById('frequencyId'+inc).value;

		  var e73 = document.createElement('input');
		  e73.type = 'hidden';
		  e73.name='appRoute'+iteration;
		  e73.id='appRoute'+iteration;
		  e73.value = document.getElementById('route'+inc).value;

		  var e74 = document.createElement('input');
		  e74.type = 'hidden';
		  e74.name='appInjectionId'+iteration;
		  e74.id='appInjectionId'+iteration;
		  e74.value = document.getElementById('injectionId'+inc).value;
		  
		  var e75 = document.createElement('input');
		  e75.type = 'hidden';
		  e75.name='appNoOfDays'+iteration;
		  e75.id='appNoOfDays'+iteration;
		  e75.value = document.getElementById('noOfDays'+inc).value;

	
		  cell7.appendChild(e7);
		  cell7.appendChild(e71);
		  cell7.appendChild(e72);
		  cell7.appendChild(e73);
		  cell7.appendChild(e74);
		  cell7.appendChild(e75);
		  
/*		  var cell8 = row.insertCell(7);
		  var e8 = document.createElement('input');
		  e8.type = 'button';
		  e8.className = 'buttonAdd';
		  e8.name='remarks'+iteration;
		  e8.setAttribute('onClick', 'addRow();'); 
		  e8.setAttribute('tabindex','1');
		  cell8.appendChild(e8); */
	
		  var cell9 = row.insertCell(7);
		  var e9 = document.createElement('input');
		  e9.type = 'button';
		  e9.className = 'buttonDel';
		  e9.name='remarks'+iteration;
		  e9.setAttribute('onClick', 'removeRow('+document.getElementById('presDtId'+inc).value+',this);'); 
		  e9.setAttribute('tabindex','1');
		  cell9.appendChild(e9);
		}else{
			alert("Please select Appointment Date.");
			document.getElementById('presDtId'+inc).checked = false;
		}
		}
	//}
}

function removeRow(presDt,obj)
{
	var cnt = document.getElementById('injCount').value;
	for(var i=1;i<cnt;i++){
		if(document.getElementById('presDtId'+i) && document.getElementById('presDtId'+i).value == presDt){
			document.getElementById('presDtId'+i).disabled = false;
			document.getElementById('presDtId'+i).checked =false;
		}
	}
	  var i=obj.parentNode.parentNode.rowIndex;
	  document.getElementById('injectionApp').deleteRow(i);
	  	
	  /*	var tbl = document.getElementById('injectionApp');
	  	var lastRow = tbl.rows.length;
	 	var iteration = lastRow - 1;
	  	var hdb = document.getElementById('hdb');
	  	hdb.value=iteration*/
 
}


function checkDate(appDate){
	currentDate = new Date();
	 var month = currentDate.getMonth() + 1
	 var day = currentDate.getDate()
	 var year = currentDate.getFullYear()
	 var seperator = "/"
	 currentDate = new Date(month + seperator + day + seperator + year);
	var appointmentDate = new Date(appDate.substring(6),(appDate.substring(3,5) - 1) ,appDate.substring(0,2));
	
	if(currentDate > appointmentDate){
		alert("Appointment Date can not be less than current date.");
		document.getElementById('injAppDate').value = "";
		return false;
	}
	return true;	
}

</script>