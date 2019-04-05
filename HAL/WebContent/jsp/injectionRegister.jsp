<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.MasEcgType"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>

<%@page import="jkt.hms.masters.business.MasFrequency"%>

<%@page import="jkt.hms.masters.business.InjectionRegister"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.InjectionRegisterDetails"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionHeader"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.InjAppointmentHeader"%>
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
		String time = (String)utilMap.get("currentTimeWithoutSc");
 
 		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
	
		String message = "";
		if(map.get("message") != null){
			message = (String)map.get("message");
		}
		List<PatientPrescriptionHeader> injectionList = new ArrayList<PatientPrescriptionHeader>();
		if(map.get("injectionList") != null){
			injectionList= (List<PatientPrescriptionHeader>)map.get("injectionList");
		}
		
		PatientPrescriptionHeader prescriptionHeader = new PatientPrescriptionHeader();
		
		List<InjAppointmentDetails> injectionAppList = new ArrayList<InjAppointmentDetails>();
		if(map.get("injectionAppList") != null){
			injectionAppList= (List<InjAppointmentDetails>)map.get("injectionAppList");
		}
		System.out.println("injectionList---- "+injectionList.size());
		System.out.println("injectionAppList.size()---- "+injectionAppList.size());
		InjAppointmentHeader injAppointmentHeader = new InjAppointmentHeader();
		if(injectionList.size() > 0){
			prescriptionHeader = injectionList.get(0);
		System.out.println("prescriptionHeader--if-- "+prescriptionHeader);
		}else if(injectionAppList.size() > 0){
			for(InjAppointmentDetails obj : injectionAppList)
			injAppointmentHeader = obj.getInjAppointmentHeader();
			prescriptionHeader = injAppointmentHeader.getPrescription();
			System.out.println("prescriptionHeader-else--- "+prescriptionHeader);
			
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
	int hinId = prescriptionHeader.getHin().getId();
	String serviceNo = prescriptionHeader.getHin().getServiceNo()!=null?prescriptionHeader.getHin().getServiceNo() :"";
	%>
	<h4><%=message %></h4>
	<div class="clear"></div>
	<div class="titleBg"><h2>Injection Register</h2></div>
	<div class="clear"></div>
	
<form name="injectionAdministration" action="" method="post">
<%
//if(injectionList.size() > 0){
%>
<input type="hidden" name="prescriptionHeaderId" value="<%=prescriptionHeader.getId() %>"/>
<%//}
if(injectionAppList.size()>0){ %>
<input type="hidden" name="appointmentHeaderId" value="<%=injAppointmentHeader.getId() %>"/>
<%} %>
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<label>Service No.</label>
<label class="value"><%=prescriptionHeader.getHin().getServiceNo()!=null?prescriptionHeader.getHin().getServiceNo() :"" %></label>
<input type="hidden" name="hinId" value="<%=prescriptionHeader.getHin().getId() %>" id="hinId"/>
<input type="hidden" name="visitId" value="<%=prescriptionHeader.getVisit().getId() %>" id="visitId"/>

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

<div class="Clear"></div>
<label>Relation</label> 
<label class="value"><%=prescriptionHeader.getHin().getRelation().getRelationName()%></label>
<label>Rank</label>
<label class="value"><%=prescriptionHeader.getHin().getRank().getRankName()%></label> 
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

<div class="Clear"></div>

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
<label class="valueAuto"><%=diagnosis %></label>
<div class="clear"></div>
</div>
<div class="clear"></div>
<h4>Injection Details</h4>
<div class="Clear"></div>
<div id="pageNavPosition"></div>
<div class="Clear"></div>

<div class="cmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="injection">

	<tr>
	<th scope="col"></th>
		<th scope="col">Injection Name</th>
		<th scope="col">ml</th>
		<th scope="col">Route</th>
		<th scope="col">Frequency</th>
		<th scope="col">No. of Days</th>
		<th scope="col">A/U</th>
		<th scope="col">Quantity Issued</th>
		<th scope="col">Allergic Testing</th> 
		<th scope="col">Adverse Reaction</th> 
		<th scope="col"></th>
	</tr>
	<%int i=1; %>
	<%-- int i=1;
	if(injectionList.size() > 0){
		for(PatientPrescriptionDetails prescriptionDetails : prescriptionHeader.getPatientPrescriptionDetails()){
			
		if(prescriptionDetails.getItem().getItemCategory()!=null && prescriptionDetails.getItem().getItemCategory().getId()==item_category_id){
			if(prescriptionDetails.getInjectionStatus().equalsIgnoreCase("p")){
	%>
	<tr>
	<td><input type="checkbox" name="presDtId<%=i %>" id="presDtId<%=i %>" value="<%=  prescriptionDetails.getId()%>"/></td>
		<td><input type="text" name="injectionName<%=i %>" id="injectionName<%=i %>" value="<%= prescriptionDetails.getItem().getNomenclature() %>" validate="Injection Name,string,yes" onblur="if(this.value!=''){getItemId(this.value,1);}" size="60"/>
	</td>
		<td>
		<input type="hidden" name="injectionId<%=i %>" id="injectionId<%=i %>" value="<%=  prescriptionDetails.getItem().getId()%>"/>
		<input type="text" name="dose<%=i %>" value="<%= prescriptionDetails.getDosage() %>" size="2" maxlength="4" validate="" /></td>
		<td><input type="text" name="route<%=i %>" value="<%= prescriptionDetails.getRoute() %>" class="small"/></td>
		<td><input type="text" name="freq<%=i %>" value="<%= prescriptionDetails.getFrequency().getFrequencyName() %>" size="5"/>
		<input type="hidden" name="frequencyId<%=i %>" value="<%= prescriptionDetails.getFrequency().getId() %>" size="5"/>
		</td>
		<td><input type="text" name="noOfDays<%=i %>" value="<%= (prescriptionDetails.getNoOfDays()!=null?prescriptionDetails.getNoOfDays():"") %>" size="3"/></td>
		<td><input type="text" name="au<%=i %>" value="<%= (prescriptionDetails.getItem().getItemConversion()!=null?prescriptionDetails.getItem().getItemConversion().getItemUnitName():"") %>" class="small"/></td>
		
		<td><input type="text" name="qtyIssued<%=i %>" value="<%= (prescriptionDetails.getQtyIssued()!=null?prescriptionDetails.getQtyIssued():"") %>" class="small"/></td>
			
		
	</tr>
	<%i++;}
		}
		}}else --%>
		<%if(injectionAppList.size() > 0){
			for(InjAppointmentDetails appointmentDetails : injectionAppList){
				PatientPrescriptionDetails prescriptionDetails = appointmentDetails.getPatientPrescriptionDetails();
			if(appointmentDetails.getStatus().equalsIgnoreCase("p")){
		%>
			<tr>
	<td><input type="checkbox" name="appDtId<%=i %>" id="appDtId<%=i %>" value="<%=  appointmentDetails.getId()%>"/></td>
		<td><input type="text" name="injectionName<%=i %>"  readonly="readonly" id="injectionName<%=i %>" value="<%= prescriptionDetails.getItem().getNomenclature() %>" validate="Injection Name,string,yes" onblur="if(this.value!=''){getItemId(this.value,1);}" size="30"/>
	</td>
		<td>
		<input type="hidden" name="injectionId<%=i %>" id="injectionId<%=i %>" value="<%=  prescriptionDetails.getItem().getId()%>"/>
		<input type="text" name="dose<%=i %>" readonly="readonly"  value="<%= prescriptionDetails.getDosage()!=null?prescriptionDetails.getDosage():"" %>" size="2" maxlength="4" validate="" /></td>
		<td><input type="text" name="route<%=i %>" readonly="readonly"  value="<%= prescriptionDetails.getRoute()!=null? prescriptionDetails.getRoute():"" %>" size="5"/></td>
		<td><input type="text" name="freq<%=i %>" readonly="readonly"  value="<%= prescriptionDetails.getFrequency().getFrequencyName() %>" size="7"/>
		<input type="hidden" name="frequencyId<%=i %>" value="<%= prescriptionDetails.getFrequency().getId() %>" size="5"/>
		</td>
		<td><input type="text" name="noOfDays<%=i %>" readonly="readonly"  value="<%= (prescriptionDetails.getNoOfDays()!=null?prescriptionDetails.getNoOfDays():"") %>" size="8"/></td>
		<td><input type="text" name="au<%=i %>" value="<%= (prescriptionDetails.getItem().getItemConversion()!=null?prescriptionDetails.getItem().getItemConversion().getItemUnitName():"") %>" class="small" size="13"/></td>
		
		<td><input type="text" name="qtyIssued<%=i %>" id="qtyIssued<%=i %>" readonly="readonly" value="<%= (prescriptionDetails.getQtyIssued()!=null?prescriptionDetails.getQtyIssued():"") %>" size="6"/>
		<input type="hidden" name="total<%=i %>" id="total<%=i %>" readonly="readonly" value="<%= (prescriptionDetails.getTotal()!=null?prescriptionDetails.getTotal():"0") %>" size="4"/>
		</td>
		<td><select name="allergicTesting<%=i %>">
			<option value="">Select</option>
			<option value="yes">Yes</option>
			<option value="no">No</option>
			</select>
		</td>
		<td><input type="text" name="adverseReaction<%=i %>" value="" maxlength="50"/></td>		
		<td>
		<%
			if(prescriptionDetails.getQtyIssued()==null || prescriptionDetails.getQtyIssued()==0){
		%>
		<input type="button" id="issue" name="issue" value=""	class="buttonIssue" onclick="openPopupForIssue(<%=i %>);" />
		<%} %>
		</td>
	</tr>
		
		<%}
			i++;}
			}%>
</table>
</div>
	<input type="hidden" name="injCount" value="<%=i %>" id="injCount" />

<div class="clear"></div>
<div class="Clear"></div>
<div class="Block">

<div class="clear"></div>
<label> Injection Given At <span>*</span></label> 
<input	type="text" name="injTime" id="injtime" validate="Injection Given At,string,yes" value="" MAXLENGTH="5" onKeyUp="if(this.value!=''){mask(this.value,this,'2',':')};" onBlur="if(this.value!=''){IsValidTime(this.value,this.id);}" />

<label> On <span>*</span></label> 
<input	type="text" name="injDate" id="injdate" validate="Injection Given On,string,yes" value="" class="date" readonly="readonly" MAXLENGTH="50"  />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" 
class="calender"	onClick="setdate('<%=currentDate %>',document.injectionAdministration.injDate,event)" /> 

<div class="Clear"></div>
</div>
<div class="division"></div>
<input type="button" name="Submit11" id="addbutton"
	onclick="submitForm('injectionAdministration','/hms/hms/registration?method=saveInjectionRegisterDetails','validateCheckBox');"
	value="Submit" class="button" accesskey="a" />

<input type="reset" name ="Reset" value ="Reset" class="button" tabindex="1" accesskey="r" />
<input type="button" name="Submit11" id="addbutton"
	onclick="submitFormForButton('injectionAdministration','/hms/hms/registration?method=showInjectionAppointment&flag=beforeSave','validateCheckBox');"
	value="Injection Appointment" class="buttonBig" accesskey="a" />
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
function validateCheckBox(){
	var injCount = document.getElementById('injCount').value;
	for(var i=1;i<injCount;i++){
		if(document.getElementById('appDtId'+i).checked){
			return true;

		}
	}
	alert("Please select one record.")
	return false;
}

function openPopupForIssue(rowVal)
{

	var injectionId = document.getElementById('injectionId'+rowVal).value;
	var deptId = '<%=session.getAttribute("deptId")%>'
	var nomenclature = document.getElementById('injectionName'+rowVal).value;
	var total = document.getElementById('total'+rowVal).value;
	var url="/hms/hms/registration?method=openPopupForInjectionIssue&itemId="+injectionId+"&deptId="+deptId+"&rowVal="+rowVal+"&total="+total+"&nomenclature="+nomenclature+"&hinId=<%=hinId%>&serviceNo=<%=serviceNo%>&prescriptionHeaderId=<%=prescriptionHeader.getId()%>";
	newwindow=window.open(url,'name',"height=500,width=1010,status=1,left=0, top=0, scrollbars=1,resizable=0, channelmode=no");
	
 }
</script>