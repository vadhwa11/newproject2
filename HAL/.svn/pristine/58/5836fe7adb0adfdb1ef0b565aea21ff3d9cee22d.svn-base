<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.MasEcgType"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>

<%@page import="jkt.hms.masters.business.MasFrequency"%>

<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionHeader"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="java.net.URL"%>

<%@page import="jkt.hms.masters.business.PhysioRequisitionDetail"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.PhysioVisitEntryDetail"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.PhysioAppointmentDetail"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasTherapyType"%>
<%@page import="jkt.hms.masters.business.PhysioVisitEntryHeader"%><script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
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
		List<PhysioRequisitionDetail> physioReqDetailList = new ArrayList<PhysioRequisitionDetail>();
		List<MasTherapyType> therapyTypeList = new ArrayList<MasTherapyType>();
		if(map.get("physioReqDetailList") != null){
			physioReqDetailList= (List<PhysioRequisitionDetail>)map.get("physioReqDetailList");
		}
		List<PhysioAppointmentDetail> physioAppDetailList = new ArrayList<PhysioAppointmentDetail>();
		if(map.get("physioAppDetailList") != null){
			physioAppDetailList= (List<PhysioAppointmentDetail>)map.get("physioAppDetailList");
		}
		List<PhysioVisitEntryDetail> physioDirectVisitDetailList = new ArrayList<PhysioVisitEntryDetail>();
		if(map.get("physioDirectVisitDetailList") != null){
			physioDirectVisitDetailList= (List<PhysioVisitEntryDetail>)map.get("physioDirectVisitDetailList");
		}
		List<MasFrequency> freqList = new ArrayList<MasFrequency>();
		
		if(map.get("freqList") != null){
			freqList = (List<MasFrequency>)map.get("freqList");
		}
		if(map.get("therapyTypeList") != null){
			therapyTypeList = (List<MasTherapyType>)map.get("therapyTypeList");
		}
		List<PhysioAppointmentDetail> appointmentList = new ArrayList<PhysioAppointmentDetail>();
		if(map.get("appointmentList") != null){
			appointmentList = (List<PhysioAppointmentDetail>)map.get("appointmentList");
		}
		Box box= HMSUtil.getBox(request);
		Visit visit = new Visit();
		Inpatient inpatient = new Inpatient();
		Patient patient = new Patient();
		int physioRequisitionHeaderId = 0;
		String doctorName = "";
		int doctorId = 0;
		String rankName = "";
		if(box.getString("flag").equals("OPD")){
		PhysioRequisitionDetail physioRequisitionDetail = new PhysioRequisitionDetail();
		if(physioReqDetailList.size() > 0){
				physioRequisitionDetail = physioReqDetailList.get(0);
				physioRequisitionHeaderId = physioRequisitionDetail.getPhysioRequisitionHeader().getId();
			if(physioRequisitionDetail.getPhysioRequisitionHeader().getVisit() != null){
				 visit = physioRequisitionDetail.getPhysioRequisitionHeader().getVisit();
				 patient = visit.getHin();
		    }else if(physioRequisitionDetail.getPhysioRequisitionHeader().getInpatient() != null){
		    	inpatient= physioRequisitionDetail.getPhysioRequisitionHeader().getInpatient();
				 patient = inpatient.getHin();
		     }
			if(visit.getDoctor() != null){
				if(visit.getDoctor().getFirstName() != null){
				doctorName = visit.getDoctor().getFirstName();
				}
				if(visit.getDoctor().getMiddleName()!=null){
					doctorName += " "+visit.getDoctor().getMiddleName();
				}
				if(visit.getDoctor().getLastName()!=null){
					doctorName += " "+visit.getDoctor().getLastName();
				}
				if( visit.getDoctor() != null){
					doctorId = visit.getDoctor().getId(); 
				}
				if(visit.getDoctor().getRank()!= null){
					rankName = visit.getDoctor().getRank().getRankName();
				}
			}
		 }
		}else if(box.getString("flag").equals("Appointment")){
			PhysioAppointmentDetail physioAppointmentDetail = new PhysioAppointmentDetail();
			if(physioAppDetailList.size() > 0){
				physioAppointmentDetail = physioAppDetailList.get(0);
				if(physioAppointmentDetail.getAppointmentHeader().getVisit() != null){
				 visit = physioAppointmentDetail.getAppointmentHeader().getVisit();
				 patient = physioAppointmentDetail.getAppointmentHeader().getHin();
				}else if(physioAppointmentDetail.getAppointmentHeader().getInpatient() != null){
			    	inpatient= physioAppointmentDetail.getAppointmentHeader().getInpatient();
					 patient = inpatient.getHin();
			     }
				 if(inpatient.getDoctor() != null){
					 if(inpatient.getDoctor().getFirstName() != null){
						doctorName = inpatient.getDoctor().getFirstName();
					 }
					if(inpatient.getDoctor().getMiddleName()!=null){
						doctorName += " "+inpatient.getDoctor().getMiddleName();
					}
					if(inpatient.getDoctor().getLastName()!=null){
						doctorName += " "+inpatient.getDoctor().getLastName();
					}
					if( inpatient.getDoctor() != null){
						doctorId = inpatient.getDoctor().getId(); 
					}
					if(inpatient.getDoctor().getRank()!= null){
						rankName = inpatient.getDoctor().getRank().getRankName();
					}
				 }
			}	
		}else{
			PhysioVisitEntryDetail physioVisitEntryDetail = new PhysioVisitEntryDetail();
			if(physioDirectVisitDetailList.size()>0){
				physioVisitEntryDetail = physioDirectVisitDetailList.get(0);
				if(physioVisitEntryDetail.getVisitEntryHeader() != null){
				if(physioVisitEntryDetail.getVisitEntryHeader().getVisit() != null){
					 visit = physioVisitEntryDetail.getVisitEntryHeader().getVisit();
					 patient = physioVisitEntryDetail.getVisitEntryHeader().getHin();
				 }else if(physioVisitEntryDetail.getVisitEntryHeader().getInpatient() != null){
				    	inpatient= physioVisitEntryDetail.getVisitEntryHeader().getInpatient();
						 patient = inpatient.getHin();
				     }
				}
				if(inpatient.getDoctor() != null){
					 if(inpatient.getDoctor().getFirstName() != null){
						doctorName = inpatient.getDoctor().getFirstName();
					 }
					if(inpatient.getDoctor().getMiddleName()!=null){
						doctorName += " "+inpatient.getDoctor().getMiddleName();
					}
					if(inpatient.getDoctor().getLastName()!=null){
						doctorName += " "+inpatient.getDoctor().getLastName();
					}
					if( inpatient.getDoctor() != null){
						doctorId = inpatient.getDoctor().getId(); 
					}
					if(inpatient.getDoctor().getRank()!= null){
						rankName = inpatient.getDoctor().getRank().getRankName();
					}
				 }
			}
		}
		
	%>
	<h4><%=message %></h4>
	<div class="clear"></div>
	<div class="titleBg"><h2>Therapy Appointment</h2></div>
	<div class="clear"></div>
<h4>Patient Details</h4>
<div class="clear"></div>
<form name="therapyAppointment" action="" method="post">
<div class="Block">
<label>Service No.</label>
<label class="value"><%=patient.getServiceNo()!=null?patient.getServiceNo():"" %></label>
<input type="hidden" name="serviceNo" value="<%=patient.getServiceNo()!=null?patient.getServiceNo():"" %>" id="serviceNo"/>
<input type="hidden" name="hinId" value="<%=patient.getId() %>" id="hinId"/>
<input type="hidden" name="visitId" value="<%=visit.getId() %>" id="visitId"/>
<input type="hidden" name="inpatientId" value="<%=inpatient.getId() %>" id="inpatientId"/>
 <input type="hidden" name="physioReqHeaderId" value="<%=physioRequisitionHeaderId %>" id="physioReqHeaderId"/>
<input type="hidden" name="physioRequisitionHeaderId" value="<%=box.getInt("physioRequisitionHeaderId") %>" id="physioReqHeaderId"/> 
<input type="hidden" name="flag" value="<%=box.getString("flag") %>" id="flag"/>
<label>Patient Name</label> 
<%
String middleName = "";
String lastName = "";
if(patient.getPMiddleName() != null){
	middleName =patient.getPMiddleName();
}
if(patient.getPLastName() != null){
	lastName = patient.getPLastName();
}

%>
<label class="value"><%=patient.getPFirstName()+" "+middleName+" "+lastName %></label>
<input type="hidden" name="patientName" value="<%=patient.getPFirstName()+" "+middleName+" "+lastName %>" id="patientName"/>
<div class="Clear"></div>
<label>Relation</label> 
<%if(patient.getRelation() != null){ %>
<label class="value"><%=patient.getRelation().getRelationName()%></label>
<input type="hidden" name="relation" value="<%=patient.getRelation().getRelationName() %>" id="relation"/>
<%}else{ %>
<label class="value">&nbsp;</label>
<%} %>
<label>Rank</label>
<%if(patient.getRank() != null){ %>
<label class="value"><%=patient.getRank().getRankName()%></label> 
<input type="hidden" name="rank" value="<%=patient.getRank().getRankName() %>" id="rank"/>
<%}else{ %>
<label class="value">&nbsp;</label>
<%} %>
<label>Name</label> 
<%
String sMiddleName = "";
String sLastName = "";

	if(patient.getSMiddleName() != null){
		sMiddleName = patient.getSMiddleName();
	}
	if(patient.getSLastName() != null){
		sLastName = patient.getSLastName();
	}
%>
<label class="value"><%=patient.getSFirstName()+" "+sMiddleName+" "+sLastName %></label> 
<input type="hidden" name="name" value="<%=patient.getSFirstName()+" "+sMiddleName+" "+sLastName  %>" id="name"/>
<div class="Clear"></div>
 
<label>Unit</label> 
<%if(patient.getUnit() != null){ %>
<label class="value"><%=patient.getUnit().getUnitName()%></label>
<%}else{ %>
<label class="value">&nbsp;</label>
<%} %>
<label>Branch/Trade</label> 
<%if(patient.getTrade()!= null){ %>
<label class="value"><%=patient.getTrade().getTradeName()%></label>
<%}else{ %>
<label class="value">&nbsp;</label>
<%} %>

<label> Age</label> 
<label class="value"><%=(patient.getAge()!=null ?patient.getAge(): "")%></label>

<div class="Clear"></div>

<label> Gender</label> 
<label class="value"><%=(patient.getSex()!=null ? patient.getSex().getAdministrativeSexName(): "")%></label>

<%-- 
<label> Diagnosis</label> 
<%

String diagnosis = "";
Set<OpdPatientDetails> patientDetails = new HashSet<OpdPatientDetails>();
Set<DischargeIcdCode> icdSet = new HashSet<DischargeIcdCode>();

	if(visit!=null){
		
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
--%>
<label> Medical Officer</label> 


<%if(doctorName != null){ %>
	<label class="value"><%=rankName+" "+doctorName %></label>
	<input type="hidden" name="moId" value="<%= doctorId %>" id="moId">
	<%}else{ %>
	<label class="value">--</label>
	<%} %>
<div class="clear"></div>
</div>
<div class="clear"></div>
<h4>PHYSIOTHERAPY DETAILS</h4>
<div class="Clear"></div>
<div id="pageNavPosition"></div>
<div class="Clear"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0" id="therapy">

	<tr>
	<th scope="col"></th>
		<th scope="col">Therapy Name</th>
		<th colspan="2">Duration</th>
		<th scope="col">Frequency</th>
		<th scope="col">No.of Days</th>
		<th scope="col">Remarks</th>
	</tr>
	<% int i=1;
	
	if(box.getString("flag").equals("OPD")){
		for(PhysioRequisitionDetail physioReqDetail: physioReqDetailList){
			
	//if(injAppointmentDetails.getItem().getItemCategory()!=null && injAppointmentDetails.getItem().getItemCategory().getId()==item_category_id){
		
	%>
	<tr>	<td><input type="checkbox" name="physioVisitDetailId<%=i %>" id="physioVisitDetailId<%=i %>" value="<%=physioReqDetail.getId()%>" onclick="addRow(this,<%=i %>);"/></td>
		<td><input type="text" name="therapyName<%=i %>" id="therapyName<%=i %>" value="<%=physioReqDetail.getTharaphy().getTherapyTypeName() %>" validate="Therapy Name,metachar,yes" onblur="if(this.value!=''){getItemId(this.value,1);}" size="80"/>
</td>
		<td>
		<input type="hidden" name="therapyId<%=i %>" id="therapyId<%=i %>" value="<%=physioReqDetail.getTharaphy().getId()%>"/>
		<input type="text" name="duration<%=i %>" id="duration<%=i %>" value="<%=physioReqDetail.getDuration() %>"size="5" maxlength="4" validate="" /></td>
		<td>Min.</td>
		<td><input type="text" name="freq<%=i %>" id="freq<%=i %>" value="<%=physioReqDetail.getFrequency().getFrequencyName() %>" size="20"/>
		<input type="hidden" name="frequencyId<%=i %>" id="frequencyId<%=i %>" value="<%=physioReqDetail.getFrequency().getId() %>" />
		</td>
		<td><input type="text" name="noOfDays<%=i %>" id="noOfDays<%=i %>" value="<%= (physioReqDetail.getNoOfDays()!=null?physioReqDetail.getNoOfDays():"") %>"size="3"/></td>
		<td><input type="text" name="remarks<%=i %>" value="<%= (physioReqDetail.getRemark()!=null?physioReqDetail.getRemark():"") %>" class="small" id="remarks<%=i %>"/></td>
		
			
		
	</tr>
	<%i++;
		
		}
	}else if(box.getString("flag").equals("Appointment")){
	for(PhysioAppointmentDetail physioAppDetail: physioAppDetailList){
			
		
	%>
	<tr>	<td><input type="checkbox" name="physioVisitDetailId<%=i %>" id="physioVisitDetailId<%=i %>" value="<%=physioAppDetail.getId()%>" onclick="addRow(this,<%=i %>);"/></td>
		<td><input type="text" name="therapyName<%=i %>" id="therapyName<%=i %>" value="<%=physioAppDetail.getTherapy().getTherapyTypeName() %>" validate="Therapy Name,metachar,yes" onblur="if(this.value!=''){getItemId(this.value,1);}" size="80"/>
</td>
		<td>
		<input type="hidden" name="therapyId<%=i %>" id="therapyId<%=i %>" value="<%=physioAppDetail.getTherapy().getId()%>"/>
		<input type="text" name="duration<%=i %>" id="duration<%=i %>" value="<%=physioAppDetail.getDuration() %>"size="5" maxlength="4" validate="" /></td>
		<td>Min.</td>
		<td><input type="text" name="freq<%=i %>" id="freq<%=i %>" value="<%=physioAppDetail.getFrequency().getFrequencyName() %>" size="20"/>
		<input type="hidden" name="frequencyId<%=i %>" id="frequencyId<%=i %>" value="<%=physioAppDetail.getFrequency().getId() %>" />
		</td>
		<td><input type="text" name="noOfDays<%=i %>" id="noOfDays<%=i %>" value="<%= (physioAppDetail.getNoOfDays()!=null?physioAppDetail.getNoOfDays():"") %>"size="3"/></td>
		<td><input type="text" name="remarks<%=i %>" value="<%= (physioAppDetail.getRemarks()!=null?physioAppDetail.getRemarks():"") %>" class="small" id="remarks<%=i %>"/></td>
		
			
		
	</tr>
	<%i++;
		
		}
	}else{
		for(PhysioVisitEntryDetail physioVisitEntryDetail: physioDirectVisitDetailList){
	%>
	<tr>	<td><input type="checkbox" name="physioVisitDetailId<%=i %>" id="physioVisitDetailId<%=i %>" value="<%=physioVisitEntryDetail.getId()%>" onclick="addRow(this,<%=i %>);"/></td>
		<td><input type="text" name="therapyName<%=i %>" id="therapyName<%=i %>" value="<%=physioVisitEntryDetail.getTharapy().getTherapyTypeName() %>" validate="Therapy Name,metachar,yes" onblur="if(this.value!=''){getItemId(this.value,1);}" size="80"/>
</td>
		<td>
		<input type="hidden" name="therapyId<%=i %>" id="therapyId<%=i %>" value="<%=physioVisitEntryDetail.getTharapy().getId()%>"/>
		<input type="text" name="duration<%=i %>" id="duration<%=i %>" value="<%=physioVisitEntryDetail.getDuration() %>"size="5" maxlength="4" validate="" /></td>
		<td>Min.</td>
		<td><input type="text" name="freq<%=i %>" id="freq<%=i %>" value="<%=physioVisitEntryDetail.getFrequency().getFrequencyName() %>" size="20"/>
		<input type="hidden" name="frequencyId<%=i %>" id="frequencyId<%=i %>" value="<%=physioVisitEntryDetail.getFrequency().getId() %>" />
		</td>
		<td><input type="text" name="noOfDays<%=i %>" id="noOfDays<%=i %>" value="<%= (physioVisitEntryDetail.getNoOfDays()!=null?physioVisitEntryDetail.getNoOfDays():"") %>"size="3"/></td>
		<td><input type="text" name="remarks<%=i %>" value="<%= (physioVisitEntryDetail.getRemarks()!=null?physioVisitEntryDetail.getRemarks():"") %>" class="small" id="remarks<%=i %>"/></td>
		
	</tr>
	<%i++;
		
		}
	} %>
</table>
	<input type="hidden" name="therapyCount" value="" id="therapyCount" />

<div class="clear"></div>

<h4>Appointment List</h4>
<div class="Clear"></div>
<table>
<tr>
<th>Therapy</th>
<th>Time</th>
<th>Date</th>
<th>Duration</th>
</tr>
<%if(appointmentList.size()>0){
	for(PhysioAppointmentDetail appointmentDetail :appointmentList){
	%>


<tr>
<%if(therapyTypeList.size()>0){
if(appointmentDetail.getTherapy() != null){
	for(MasTherapyType masTherapyType :therapyTypeList){
	if(masTherapyType.getId().equals(appointmentDetail.getTherapy().getId())){	
	%>
<td><%=masTherapyType.getTherapyTypeName()%></td>
<%}}}} %>
<td><%=appointmentDetail.getAppointmentTime() %></td>
<td><%=HMSUtil.convertDateToStringTypeDateOnly(appointmentDetail.getAppointmentDate()) %></td>
<td><%=appointmentDetail.getDuration()+" "+"Min." %></td>

</tr>
<%}} %>
</table>
<div class="Clear"></div>
<div class="Block">

<label> Date <span>*</span></label> 
<input	type="text" name="physioAppDate" id="physioAppDate" validate="Date,date,yes" value="" class="date" readonly="readonly" MAXLENGTH="8" onclick="checkDate(this.value);"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" 
class="calender" onClick="setdate('<%=currentDate %>',document.therapyAppointment.physioAppDate,event)" /> 
<input type="button" name="go" value="Go" class="buttonSm" onclick="submitProtoAjax('therapyAppointment','/hms/hms/physiotherapy?method=getPhysioAppointmentDetails');">
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<div id="testDiv">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="therapyApp">

	<tr>
		<th scope="col">Time</th>
		<th scope="col">Duration</th>
		<th scope="col">Therapy Name</th>
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
<%--	
	<tr>	
		<td><input type="text" name="appTime<%=j %>" id="appTime<%=j %>" value="" size="10"/>
		 <input type="hidden" name="appPresDtId<%=j %>" id="appPresDtId<%=j %>" value=""/></td>
		<td><input type="text" name="duration<%=i %>" id="duration<%=i %>" value=""/></td>
		<td><input type="text" name="appTherapyName<%=j %>" id="appTherapyName<%=j %>" value="" validate="Therapy Name,string,yes" onblur="if(this.value!=''){getItemId(this.value,1);}" size="30"/>
		<input type="hidden" name="appTherapyId<%=i %>" id="appTherapyId<%=i %>" value=""/></td>
		<td><input type="text" name="appServiceNo<%=j %>" id="appServiceNo<%=j %>" value="" size="15"/></td>
		<td><input type="text" name="appPatientName<%=j %>" id="appPatientName<%=j %>" value="" size="20" maxlength="4" validate="" /></td>
		<td><input type="text" name="appRelation<%=i %>" id="appRelation<%=i %>" value="" size="10"/></td>
		<td><input type="text" name="appRank<%=j %>" id="appRank<%=j %>" value="" size="15"/></td>
		<td><input type="text" name="appName<%=j %>" id="appName<%=j %>" value="" size="20"/></td>
		<!--<td><input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" /></td>
		--><td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('');"  /></td>
		
	</tr>
	--%>
</table>
	<input type="hidden" name="hdb" value="<%=j%>" id="hdb" />
	</div>
<div class="division"></div>
	<input type="button" name="save"  onclick="submitForm('therapyAppointment','/hms/hms/physiotherapy?method=savePhysioTheraphyAppointment&buttonName=save');"
	value="Save" class="button" accesskey="a" />
<input type="button" name="Submit11" id="addbutton" onclick="submitForm('therapyAppointment','/hms/hms/physiotherapy?method=savePhysioTheraphyAppointment&buttonName=submit');"
	value="Submit" class="button" accesskey="a" />
	<!--  <input type="button" name="Submit11" id="addbutton"
	onclick="submitForm('therapyAppointment','/hms/hms/physiotherapy?method=cancelPhysioTheraphyAppointment');"
	value="Cancel Appointment" class="button" accesskey="a" />-->

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
	var tbl = document.getElementById('therapyApp');
	var appCnt = document.getElementById('hdb').value;

	//alert("tbl====="+tbl);
		if(obj.checked){

		 if(document.getElementById('physioAppDate').value!=""){
			
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
		  e1.onkeyup=function(){mask(this.value,this,'2',':');}
		  e1.onblur=function(){IsValidTimeWithBlankCheck(this.value,this.id),checkValidTime(this.value,iteration);}
		  e1.setAttribute('tabindex','1');

		  var e11 = document.createElement('input');
		  e11.type = 'hidden';
		  e11.name='appPresDtId'+iteration;
		  e11.id='appPresDtId'+iteration
		  e11.value = document.getElementById('physioVisitDetailId'+inc).value;
		  cell1.appendChild(e1);
		  cell1.appendChild(e11);
		  
		  var cell11 = row.insertCell(1);
		  var e1 = document.createElement('input');
		  e1.type = 'text';
		  e1.size = '10';
		  e1.name='appDuration'+iteration;
		  e1.id='appDuration'+iteration
		  e1.value = document.getElementById('duration'+inc).value;
		  cell11.appendChild(e1);
	
		  var cell2 = row.insertCell(2);
		  var e2 = document.createElement('input');
		  e2.type = 'text';
		  e2.size = '30';
		  e2.name='appTherapyName'+iteration;
		  e2.id='appTherapyName'+iteration
		  e2.value = document.getElementById('therapyName'+inc).value;
	
		  var e21 = document.createElement('input');
		  e21.type = 'hidden';
		  e21.name='appTherapyId'+iteration;
		  e21.id='appTherapyId'+iteration
		  e21.value = document.getElementById('therapyId'+inc).value;
		  cell2.appendChild(e21);
		  cell2.appendChild(e2);
	
		  var cell3 = row.insertCell(3);
		  var e3 = document.createElement('input');
		  e3.type = 'text';
		  e3.size = '15';
		  e3.name='appServiceNo'+iteration;
		  e3.id='appServiceNo'+iteration
		  e3.value = document.getElementById('serviceNo').value;
		  cell3.appendChild(e3);
	
		  var cell4 = row.insertCell(4);
		  var e4 = document.createElement('input');
		  e4.type = 'text';
		  e4.size = '20';
		  e4.name='appPatientName'+iteration;
		  e4.id='appPatientName'+iteration;
		  e4.value = document.getElementById('patientName').value;
		  cell4.appendChild(e4);
	
		  var cell5 = row.insertCell(5);
		  var e5 = document.createElement('input');
		  e5.type = 'text';
		  e5.size = '10';
		  e5.name='appRelation'+iteration;
		  e5.id='appRelation'+iteration;
		  e5.value = document.getElementById('relation').value;
		  cell5.appendChild(e5);
	
		  var cell6 = row.insertCell(6);
		  var e6 = document.createElement('input');
		  e6.type = 'text';
		  e6.size = '15';
		  e6.name='appRank'+iteration;
		  e6.id='appRank'+iteration;
		  e6.value = document.getElementById('rank').value;
		  cell6.appendChild(e6);
	
		  var cell7 = row.insertCell(7);
		  var e7 = document.createElement('input');
		  e7.type = 'text';
		  e7.size = '20';
		  e7.name='appName'+iteration;
		  e7.id='appName'+iteration;
		  e7.value = document.getElementById('name').value;
		  cell7.appendChild(e7);
		  /* var e71 = document.createElement('input');
		  e71.type = 'hidden';
		  e71.name='appDose'+iteration;
		  e71.id='appDose'+iteration;
		  e71.value = document.getElementById('dose'+inc).value;*/

		 var e71 = document.createElement('input');
		  e71.type = 'hidden';
		  e71.name='appFrequencyId'+iteration;
		  e71.id='appFrequencyId'+iteration;
		  e71.value = document.getElementById('frequencyId'+inc).value;
		  cell7.appendChild(e71);
		  
		  var e72 = document.createElement('input');
		  e72.type = 'hidden';
		  e72.name='appNoOfDays'+iteration;
		  e72.id='appNoOfDays'+iteration;
		  e72.value = document.getElementById('noOfDays'+inc).value;
		  cell7.appendChild(e72);

			 var e73 = document.createElement('input');
		  e73.type = 'hidden';
		  e73.name='appRemarks'+iteration;
		  e73.id='appRemarks'+iteration;
		  e73.value = document.getElementById('remarks'+inc).value;
		  e73.maxLength = '90';
		  cell7.appendChild(e73);
		 
		
		 
		 
		  /*
		  var e74 = document.createElement('input');
		  e74.type = 'hidden';
		  e74.name='appInjectionId'+iteration;
		  e74.id='appInjectionId'+iteration;
		  e74.value = document.getElementById('injectionId'+inc).value;
		  
		

	
		  cell7.appendChild(e7);
		  cell7.appendChild(e71);
		  cell7.appendChild(e72);
		  cell7.appendChild(e73);
		  cell7.appendChild(e74);
		  cell7.appendChild(e75);*/
		  
/*		  var cell8 = row.insertCell(7);
		  var e8 = document.createElement('input');
		  e8.type = 'button';
		  e8.className = 'buttonAdd';
		  e8.name='remarks'+iteration;
		  e8.setAttribute('onClick', 'addRow();'); 
		  e8.setAttribute('tabindex','1');
		  cell8.appendChild(e8); */
	
		
		  var cell8 = row.insertCell(8);
		  var e8 = document.createElement('input');
		  e8.type = 'button';
		  e8.className = 'buttonDel';
		  e8.name='delete'+iteration;
		  e8.setAttribute('onClick', 'removeRow('+document.getElementById('physioVisitDetailId'+inc).value+',this);'); 
		  e8.setAttribute('tabindex','1');
		  cell8.appendChild(e8);
		}else{
			alert("Please select Appointment Date.");
			document.getElementById('physioVisitDetailId'+inc).checked = false;
		}
		}
	//}
}

function removeRow(presDt,obj)
{
	//alert(presDt);
	//alert(obj);
	//alert(document.getElementById('physioVisitDetailId'+i));
	//alert(document.getElementById('hdb').value);
	var cnt = document.getElementById('hdb').value;
	for(var i=1;i<cnt;i++){
		if(document.getElementById('physioVisitDetailId'+i) && document.getElementById('physioVisitDetailId'+i).value == presDt){
			document.getElementById('physioVisitDetailId'+i).disabled = false;
			document.getElementById('physioVisitDetailId'+i).checked =false;
		}
	}
	  var i=obj.parentNode.parentNode.rowIndex;
	  document.getElementById('therapyApp').deleteRow(i);
	  	
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
		document.getElementById('physioAppDate').value = "";
		return false;
	}
	return true;	
}

</script>