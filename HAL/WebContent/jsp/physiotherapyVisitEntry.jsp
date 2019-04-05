<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * visitByHin.jsp
 * Purpose of the JSP -  This is for Visit By HIN.
 * @author  Ritu
 * Create Date: 08th Feb,2008
 * Revision Date:
 * Revision By:
 * @version 1.22
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasComplaint"%>

<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.masters.business.MasCaseType"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.masters.business.MasDisposal"%>

<%@page import="java.util.Properties"%>
<%@page import="java.net.URL"%>



<%--For AutoComplete Through Ajax--%>

<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.MasTherapyType"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.PhysiotherapyDetails"%>

<%@page import="jkt.hms.masters.business.PhysioRequisitionDetail"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>

<%@page import="jkt.hms.masters.business.PhysioAppointmentHeader"%>
<%@page import="java.sql.Date"%>
<%@page import="jkt.hms.masters.business.PhysioAppointmentDetail"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
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

	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}

//	List<Visit> visitList = new ArrayList<Visit>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentTimeWithoutSecond();
	String currentDate = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
	List<PhysioAppointmentHeader> physioAppHeaderList = new ArrayList<PhysioAppointmentHeader>();
	List<PhysioAppointmentDetail> nextAppointmentList = new ArrayList<PhysioAppointmentDetail>();
	
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("frequencyList") != null){
		frequencyList = (List<MasFrequency>)map.get("frequencyList");
	}
	
	List<MasTherapyType> therapyTypeList = new ArrayList<MasTherapyType>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	if(map.get("therapyTypeList") != null){
		therapyTypeList = (List<MasTherapyType>)map.get("therapyTypeList");
	}
	if(map.get("employeeList") != null){
		employeeList = (List<MasEmployee>)map.get("employeeList");
	}
	if(map.get("nextAppointmentList") != null){
		nextAppointmentList = (List<PhysioAppointmentDetail>)map.get("nextAppointmentList");
	}
	
	List<PhysioRequisitionDetail> physiotherapyDetailList= new ArrayList<PhysioRequisitionDetail>();
	if(map.get("phyVisitList") != null){
		physiotherapyDetailList = (List<PhysioRequisitionDetail>)map.get("phyVisitList");
	}
	
	Visit visit = new Visit();
	Patient patient = new Patient();
	int physioRequisitionHeaderId = 0;
	PhysioRequisitionDetail physiotherapyDetails = new PhysioRequisitionDetail();
	Inpatient inpatient = new Inpatient();
	String doctorName = "";
	int doctorId = 0;
	int visitNo = 0;
	String rankName = "";
	String adNo = "";
	if(physiotherapyDetailList.size() > 0){
		physiotherapyDetails = physiotherapyDetailList.get(0);
		// visit = physiotherapyDetails.getPhysioRequisitionHeader().getVisit();
		// patient = physiotherapyDetails.getPhysioRequisitionHeader().getHin();
		 physioRequisitionHeaderId = physiotherapyDetails.getPhysioRequisitionHeader().getId();
		 if(physiotherapyDetails.getPhysioRequisitionHeader().getVisit()!=null){
			 visit= physiotherapyDetails.getPhysioRequisitionHeader().getVisit();
			 patient = visit.getHin();
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
				 visitNo =visit.getVisitNo(); 
			}else if(physiotherapyDetails.getPhysioRequisitionHeader().getInpatient()!=null){
				inpatient= physiotherapyDetails.getPhysioRequisitionHeader().getInpatient();
				 patient = inpatient.getHin();
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
				      adNo = inpatient.getAdNo();
			}
	}
	
	
%>



<form name="physiotherapyVisitEntry" method="post">
	<div class="titleBg">
	<h2>Physiotherapy Visit Entry</h2></div>
	<div class="clear"></div>

	<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">

<%
					String middleName = "";
					String lastName = "";
					if(patient.getPMiddleName() != null){
						middleName = patient.getPMiddleName();
					}
					if(patient.getPLastName() != null){
						lastName = patient.getPLastName();
					}

					%>
			<label>Service No.</label>
		  <%
				if(patient.getServiceNo() != null && !(patient.getServiceNo().equals(""))){
			%>
			<label class="value"><%= patient.getServiceNo()%></label>
			<%}else{ %>
			<label class="value">-</label>
			<%}%>
	<%-- 
		<label>HIN</label>
		<label class="value"><%=patient.getHinNo()+"-"+patient.getPFirstName()+" "+patient.getPMiddleName()+" "+patient.getPLastName()+"("+patient.getRelation() %></label>--%>
		<input name="hinNo" value="<%=patient.getHinNo() %>" type="hidden">
				
				
		<div class="clear"></div>

		



		<label>Patient Name</label>
		<label class="value"><%= patient.getPFirstName()+" "+middleName+" "+lastName%></label>

		<label>Relation</label>
		<%
			if(patient.getRelation() != null){
		%>
		<label class="value"><%= patient.getRelation().getRelationName()%></label>
			<%}else{ %>
		<label class="value">-</label>
			<% }%>

		
		<label> Rank </label>
		<%
		    if(patient.getRank() != null){
		%>

		<label class="value"><%= patient.getRank().getRankName()%></label>
		<%} else{ %>
		<label class="value">-</label>
		<% }%>
		<div class="clear"></div>

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
		<label>Name</label>
		<label class="value"><%= patient.getSFirstName()+" "+sMiddleName+" "+sLastName%></label>
		
	
		<label >Gender</label>
		<label class="value"><%=patient.getSex().getAdministrativeSexName()%></label>

	
		<%
		String currentAge = "";
		String age = patient.getAge();
		currentAge = HMSUtil.calculateAgeForADT(age, patient.getRegDate());

		%>
		<label>Age</label>
		<label class="value"><%=currentAge%></label>
			<div class="clear"></div>	
		<label>Unit</label>
		 <%
		if(patient.getUnit() != null){
		%> 
		<label class="value"><%= patient.getUnit().getUnitName()%></label>
		<%}else{ %>
		<label class="value">-</label>	
		<%} %>

		<label>Section</label>
		<%
			if(patient.getSection() != null){
		%>
		<label	class="value"><%= patient.getSection().getSectionName()%></label>
		<%}else{ %>
		<label class="value">-</label>	
		<%} %>
		
		
		<label>Trade/Branch</label>
		<%
			if(patient.getTrade() != null){
		%> 
		<label class="value"><%= patient.getTrade().getTradeName()%></label>
		<%}else{ %>
		<label class="value">-</label>	
		<%} %>
		<div class="clear"></div>
		<label >Mobile No.</label>
		<%
			if(patient.getMobileNumber() != null){
		%>
		<label class="value"><%=patient.getMobileNumber()  %></label>	
		<%} else{ %>
		<label class="value">-</label>	
		<%} %>
		
		<label >Telephone No.</label>
		<%
			if(patient.getPhoneNumber() != null){
		%>
		<label class="value"><%=patient.getPhoneNumber()  %></label>	
		<%} else{ %>
		<label class="value">-</label>	
		<%} %>
		<label>Medical Officer</label>

	
	<%if(doctorName != null){ %>
	<label class="value"><%=rankName+" "+doctorName %></label>
	<input type="hidden" name="<%=MEDICAL_OFFICER_ID %>" value="<%=doctorId %>">
	<%}else{ %>
	<label class="value">--</label>
	<%} %>
	<div class="clear"></div>
	<label>Visit/A&D No.</label>
	
	<%
		if(visitNo != 0){
	 %>
	<label class="value"><%=visitNo %></label>
	<%}else if(adNo!= null ){ 
	%>
	<label class="value"><%=adNo %></label>
	<%} %>
<label> Diagnosis</label>
		<%
			String diagnosis = "";
		
		Set<OpdPatientDetails> opdPatientDetails = new HashSet<OpdPatientDetails>();
			if(visit.getOpdPatientDetails() != null){
				  opdPatientDetails =visit.getOpdPatientDetails();
				  for(OpdPatientDetails patientDetails :opdPatientDetails){
					   
				  if(patientDetails.getInitialDiagnosis()!=null){
					  diagnosis = patientDetails.getInitialDiagnosis(); 
				  }else if(patientDetails.getSystemDiagnosis()!=null){
					  diagnosis = patientDetails.getSystemDiagnosis().getSystemDiagnosisName();
				  }else
				  {
					  
					 Set<DischargeIcdCode> dischargeIcdCodes =  new HashSet<DischargeIcdCode>();
					 if(visit.getDischargeIcdCodes() != null){
						 dischargeIcdCodes =visit.getDischargeIcdCodes();
						 
					  for(DischargeIcdCode dischargeCodes :dischargeIcdCodes){
						  if(dischargeCodes.getIcd()!=null){
							 
							  
							  if(!diagnosis.equals("")){
									diagnosis += ",";
								}
								diagnosis += dischargeCodes.getIcd().getIcdName();
							
							  }
					  	}
				  }
					 }
				  
				  }
				  
			     }else if(inpatient.getOpdPatientDetails() != null){
			    	 opdPatientDetails =inpatient.getOpdPatientDetails();
			    	 for(OpdPatientDetails patientDetails :opdPatientDetails){
						  if(patientDetails.getInitialDiagnosis()!=null){
							  diagnosis = patientDetails.getInitialDiagnosis(); 
						  }else if(patientDetails.getSystemDiagnosis()!=null){
							  diagnosis = patientDetails.getSystemDiagnosis().getSystemDiagnosisName();
						  }else
						  {
							 Set<DischargeIcdCode> dischargeIcdCodes =  new HashSet<DischargeIcdCode>();
							 if(visit.getDischargeIcdCodes() != null){
								 dischargeIcdCodes =visit.getDischargeIcdCodes();
							  for(DischargeIcdCode dischargeCodes :dischargeIcdCodes){
								  if(dischargeCodes.getIcd()!=null){
									  if(!diagnosis.equals("")){
											diagnosis += ",";
										}
										diagnosis += dischargeCodes.getIcd().getIcdName();
									
									  }
							  	}
						  }
							 }
					   }
			     }
				%>
		<%if(diagnosis != null){ %>
		<label class="valueAuto"><%=diagnosis %></label>
		<%}else{ %>
		<label></label>
		<%} %>
			
		<input type="hidden" name="<%=DIAGNOSIS%>" style="width: 190px" value="<%= diagnosis %>" validate="Diagnosis,metachar,yes" maxlength="100">
<%-- 	<label> Diagnosis</label>
		<%
			String diagnosis = "";
		Set<OpdPatientDetails> opdPatientDetails = new HashSet<OpdPatientDetails>();
			if(visit.getOpdPatientDetails() != null){
				  opdPatientDetails =visit.getOpdPatientDetails();
				  for(OpdPatientDetails patientDetails :opdPatientDetails){
					  diagnosis = patientDetails.getInitialDiagnosis();  
				   }
			     }else if(inpatient.getOpdPatientDetails() != null){
			    	 opdPatientDetails =inpatient.getOpdPatientDetails();
					  for(OpdPatientDetails patientDetails :opdPatientDetails){
						  diagnosis = patientDetails.getInitialDiagnosis();  
					   }
			     }
				%>
		<%if(diagnosis != null){ %>
		<label class="value"><%=diagnosis %></label>
		<%}else{ %>
		<label class="value">--</label>
		<%} %>
			
		<input type="hidden" name="<%=DIAGNOSIS%>" style="width: 190px" value="<%= diagnosis %>" validate="Diagnosis,string,yes" maxlength="100">--%>
	
  </div>
	<div class="clear"></div>
<div class="paddingTop15"></div>
<h4>Physiotherapy Details</h4>
<div class="clear"></div>

		<input id="hinId" type="hidden" name="<%=HIN_ID %>" value="<%=patient.getId() %>">
		<input type="hidden" name="<%=VISIT_ID %>" value="<%=visit.getId()%>">
		<input type="hidden" name="<%=INPATIENT_ID %>" value="<%=inpatient.getId()%>">
		<input type="hidden" name="physioRequisitionHeaderId" value="<%=physioRequisitionHeaderId%>">
		<input type="hidden" name="flag" value="OPD" id="flagId" />
	
<script type="text/javascript">var frequencyArray=new Array();</script>
   
        <div class="clear"></div>
               <div class="paddingTop15"></div>
        <div id="testDiv">
       
       
<div class="Clear"></div>
<table width="90%" colspan="7" cellpadding="0" cellspacing="0" id="tharapyGrid">
	<thead>
		<tr>
		<th></th>
		<th>Therapy name</th>
		<th colspan="2">Duration</th>
		<th>Frequency</th>
		<th>Days</th>
		<th>Time Begun</th>
		<th>Time Completed</th>
		<th>Sitting Time</th>
		<th>Next Appointment</th>
		<%-- <th>Next App. Time</th>--%>
		<th>Remarks</th>
		<th>Add</th>
		 <th>Delete</th> 
		</tr>
	</thead>
	<%--
	<%
	int i=1;
	if(phyVisitList.size() > 0){
		for(PhysiotherapyDetails phyDetails : phyVisitList){
	%>
	<tr>
	<td><%= phyDetails.getPhyVisitNo() %></td>
	<td><%= HMSUtil.convertDateToStringWithoutTime(phyDetails.getPhyVisitDate() )%></td>
	<td><%= phyDetails.getTimeBegin() %></td>
	<td><%= phyDetails.getTimeComplete() %></td>
	<td><%= phyDetails.getSittingTime() %></td>
	<%
		if(phyDetails.getNextAppointmentDate()!=null){
	%>
	<td><%= HMSUtil.convertDateToStringWithoutTime(phyDetails.getNextAppointmentDate()) %></td>
	<%}else{ %>
	<td>&nbsp;</td>
	<%} %>
	<%
		if( phyDetails.getNextAppointmentTime()!= null){
	%>
	<td><%= phyDetails.getNextAppointmentTime() %></td>
	<%}else{ %>
	<td>&nbsp;</td>
	<%} %>
	<%
		if(phyDetails.getRemarks()!=null){
	%>
	<td><%= phyDetails.getRemarks() %></td>
		<%}else{ %>
		<td>&nbsp;</td>
		<%} %>
	</tr>
	
	<%i++;} %>
	<%
	}%>
	<tr>
	<td><input type="text" name="visitNo" value="<%= i %>" size="4" maxlength="3" readonly="readonly"/></td>
	<td><input type="text" name="visitDate" value="<%= currentDate %>" size="13" readonly="readonly"/>
	<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" 
	class="calender"	onClick="setdate('<%=date %>',document.physiotherapyVisitEntry.visitDate,event)" /> 
	</td>
	<td><input type="text" id="timeOn" name="timeBegin" maxlength="5" value="<%= time %>" size="10" onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);" onBlur="IsValidTimeWithBlankCheck(this.value,this.id);" /></td>
	<td><input type="text" id="timeOff" name="timeCompleted" maxlength="5"   value="<%= time %>" size="10"onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);" onBlur="IsValidTimeWithBlankCheck(this.value,this.id);calculateTime();" /></td>
	<td><input type="text" id="totalHours" name="sittingTime" maxlength="5" value="" size="10" onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);" onBlur="IsValidTimeWithBlankCheck(this.value,this.id);" /></td>
	<td><input type="text" id="nextApptDate" name="nextApptDate" value="" size="13" readonly="readonly"/>
	<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" 
		class="calender"	onClick="setdate('<%=currentDate %>',document.physiotherapyVisitEntry.nextApptDate,event)" /> 
	</td>
	<td><input type="text" id="nextApptTime" name="nextApptTime" maxlength="5"  value="" size="10" onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);" onBlur="IsValidTimeWithBlankCheck(this.value,this.id);" /></td>
	<td><input type="text" name="<%=REMARKS %>" value="" validate="Remarks,String,no" maxlength="100"/></td>
	</tr> --%>
	<%
	    		MasFrequency  masFrequency = new MasFrequency();

			     for (int j = 0; j < frequencyList.size(); j++) {
			        	 masFrequency = (MasFrequency) frequencyList.get(j);
     			 %> <script>

     			frequencyArray[<%=j%>]= new Array();
     			frequencyArray[<%=j%>][0] = "<%=masFrequency.getId()%>";
     			frequencyArray[<%=j%>][1] = "<%=masFrequency.getFrequencyName()%>";
            </script> <% }%>
	<%
	int i=0;
	if(physiotherapyDetailList.size() > 0){
		for(PhysioRequisitionDetail phyDetails : physiotherapyDetailList){
			i++;
	%>
	<tr>
	<td><input type="radio" class="radiogrid" name="physioRequisitionHeaderId" value="" id="physioRequisitionHeaderId" /></td>
	<%
	if(phyDetails.getTharaphy()!= null){
	%>
	<td><%=phyDetails.getTharaphy().getTherapyTypeName() %>
		    <input type="hidden" value="<%=phyDetails.getTharaphy().getId() %>" tabindex="1" id="therapyTypeId" size="30"  name="therapyType" onblur="if(this.value!=''){getTheraphyId(this.value,<%=i %>);}"  />
	
	 <div id="ac2update1" style="display:none;"  class="autocomplete"></div>
			
			<div id="therapyDiv<%=i %>">
			<input type="hidden" name="therapyId<%=i %>" id="therapyId<%=i %>"	value="<%=phyDetails.getTharaphy().getId() %>" /> </div>
	</td>
	<%}else{ %>
	<td>--</td>
	<%} %>
	
	<%if(phyDetails.getDuration() != null){ %>
	<td><%=phyDetails.getDuration() %>
	<input type="hidden" name="duration<%=i %>" tabindex="1" id="durationId<%=i %>" value="<%=phyDetails.getDuration()%>"	size="10" maxlength="5" /></td>
	<%}else{ %>
	<td>--</td>
	<%} %>
	<td width="8%">Min.</td>
	
	<%if(phyDetails.getFrequency() != null){ %>
	<td><%=phyDetails.getFrequency().getFrequencyName() %>
	<input type="hidden" name="frequency<%=i %>" value="<%=phyDetails.getFrequency().getId() %>" tabindex="1" id="frequency<%=i %>"	size="5" maxlength="5" />
	
		</td>
	<%}else{ %>
	<td>--</td>
	<%} %>
	
	<%if(phyDetails.getNoOfDays() != null){ %>
	<td><%=phyDetails.getNoOfDays() %>
	<input type="hidden" name="noOfDays<%=i %>" value="<%=phyDetails.getNoOfDays() %>" tabindex="1" id="noOfDays<%=i %>"  size="3"	maxlength="3" /></td>
	<%}else{ %>
	<td>--</td>
	<%} %>
	<td><input type="text" name="timeBegin<%=i %>" value="" tabindex="1" id="timeBegin<%=i %>"  size="5" onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);" onBlur="IsValidTimeWithBlankCheck(this.value,this.id);"	maxlength="5"  /></td>
	<td><input type="text" name="timeComplete<%=i %>" value="" tabindex="1" id="timeComplete<%=i %>"  size="5" onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);" onBlur="IsValidTimeWithBlankCheck(this.value,this.id);calculateTime(<%=i %>);"	maxlength="5" /></td>
	<td><input type="text" name="sittingTime<%=i %>" value="" tabindex="1" id="sittingTime<%=i %>"  size="5"	onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);" onBlur="IsValidTimeWithBlankCheck(this.value,this.id);" maxlength="5"  /></td>
	<%if(nextAppointmentList.size()>0){
		for(PhysioAppointmentDetail physioAppointmentDetail :nextAppointmentList){
			
		%>
	<td><%=HMSUtil.convertDateToStringWithoutTime(physioAppointmentDetail.getAppointmentDate())+" "+physioAppointmentDetail.getAppointmentTime() %></td>
	<%}}else{ %>
	<td>--</td>
	<%} %>
	<%-- <td><input type="text" name="nextAppointmentDate<%=i %>" value="" tabindex="1" id="nextAppointmentDate<%=i %>"  size="8"	maxlength="3" />--%>
	<%-- <img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" class="calender"	onClick="setdate('nextAppointmentDate<%=i %>',document.physiotherapyVisitEntry.nextAppointmentDate<%=i %>,event)" /></td>--%>
	<%-- <td><input type="text" name="nextAppointmentTime<%=i %>" value="" tabindex="1" id="nextAppointmentTime<%=i %>"  size="3" onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);" onBlur="IsValidTimeWithBlankCheck(this.value,this.id);"	maxlength="5"  /></td>--%>
	<td><input type="text" name="remarks<%=i %>" tabindex="1" value="" id="remarks<%=i %>"  size="40"	maxlength="50"  /></td>
	<td><input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" /> </td>
<td></td>
	</tr>
	<%} %>
	<%
	}%>
	
	
</table>
<input type="hidden" name="tharapyCount" value="<%=i %>" id="tharapyCount" />
<div class="clear"></div>
<div class="division"></div>
<label class="auto">Physiotherapy Completed</label>
<input type="checkbox" name="phyCompleted" value="y">

     
        
        </div>
        
    <div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>



    <div id="edited"></div>
			<input type="button" name="submitForDisable" id="submitForDisable" value="Save" class="button" onClick="if(validatePhyFields()){submitForm('physiotherapyVisitEntry','/hms/hms/physiotherapy?method=savePhysiotherapyDetails')};" />
			<input type="reset" name ="Reset" value ="Reset" class="button" accesskey="r" />
			<input type="button" class="button"  value="Back" align="right" onClick="history.back();" />
			<input type="button" name="submitForDisable" id="submitForDisable" value="Appointment" class="button" onClick="submitForm('physiotherapyVisitEntry','/hms/hms/physiotherapy?method=showPhysiotherapyAppointmentJsp&physioRequisitionHeaderId=<%=physioRequisitionHeaderId %>','validateRadio');" />
			
<div class="clear"></div>
<div class="division"></div>
<div class="bottom">

		<label>Changed By</label>
		<label class="value"><%=userName%></label>

		<label>Changed Date</label>
		<label class="value"><%=currentDate%></label>

		<label>Changed Time</label>
		<label class="value"><%=time%></label>

		<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
		<input type="hidden" name="<%=LAST_CHANGED_DATE %>" value="<%=currentDate%>"  />
		<input type="hidden" name="<%=LAST_CHANGED_TIME %>"  value="<%=time%>" />

		</div>

		<div id="statusMessage" class="messagelabel">
			<div class="clear"></div>
			</div>
</form>
<script>
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
			submitProtoAjaxWithDivName('physiotherapyVisitEntry','/hms/hms/opd?method=getTheraphyId&counter='+inc+'&therapyId='+therapyId,'therapyDiv'+inc);
		}
	}
		
	}

function addRow(){
	
	  var tbl = document.getElementById('tharapyGrid');
	  var lastRow = tbl.rows.length;

	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('tharapyCount');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;

	  var cell0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'radio';
	  e0.name='parent'+iteration;
	  e0.id='parent'+iteration
	  e0.value=(iteration);
	  e0.size = '2'
	  cell0.appendChild(e0);
	  
	  var cell1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.size = '20';
	  e1.name='therapyType'+iteration;
	  e1.id='therapyTypeId'+iteration;
	  e1.onblur=function() {getTheraphyId(this.value,iteration);}
	  cell1.appendChild(e1);
	  new Ajax.Autocompleter('therapyTypeId'+iteration,'ac2update1','physiotherapy?method=getTherapyTypeListForAutoComplete',{parameters:'requiredField=therapyType'+iteration});

	  var e11 = document.createElement('input');
	  var ediv = document.createElement('div');
	  ediv.id='therapyDiv'+(iteration);
	  e11.type = 'hidden';
	  e11.name='therapyId'+iteration;
	  e11.id='therapyId'+iteration
	  e11.value='0'
	  cell1.appendChild(ediv);
	  ediv.appendChild(e11);
	  
	  var cell2 = row.insertCell(2);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.name='duration'+iteration;
	  e2.id='durationId'+iteration
	  e2.size = '3'
	  e2.setAttribute('maxlength', 3);
	  cell2.appendChild(e2);

	  var cell3 = row.insertCell(3);
	  cell3.innerHTML='Min.'

	  
	  var cell4 = row.insertCell(4);
	  var e3 = document.createElement('Select');
	  e3.name='frequency'+iteration;
	  e3.id='frequency'+iteration;
	  e3.size='smalllabel';
	  e3.setAttribute('tabindex','1');
	  e3.options[0] = new Option('Select', '0');
	   for(var k = 0;k<frequencyArray.length;k++ ){
	      e3.options[k+1] = new Option(frequencyArray[k][1],frequencyArray[k][0]);
	      }
	   cell4.appendChild(e3);

	  var cell5 = row.insertCell(5);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name='noOfDays'+iteration;
	  e4.id='noOfDays'+iteration;
	  e4.size='8';
	  e4.setAttribute('maxlength', 3); 
	  e4.setAttribute('tabindex','1');
	 
	  cell5.appendChild(e4);
	  
	  var cell6 = row.insertCell(6);
	  var e5 = document.createElement('input');
	  e5.type = 'text';
	  e5.name='timeBegin'+iteration;
	  e5.id='timeBegin'+iteration
	  e5.size = '10';
	  e5.onblur = function(){IsValidTimeWithBlankCheck(this.value,this.id);}
	  e5.onkeyup = function(){maskWithBackspaceCheck(this.value,this,'2',':',event);}
	  e5.tabindex='1';
	  e5.maxLength='5';
	  cell6.appendChild(e5);

	  
	  var cell7 = row.insertCell(7);
	  var e6 = document.createElement('input');
	  e6.type = 'text';
	  e6.name='timeComplete'+iteration;
	  e6.id='timeComplete'+iteration
	  e6.size = '10';
	  e6.onblur = function(){IsValidTimeWithBlankCheck(this.value,this.id);calculateTime(iteration);}
	  e6.onkeyup = function(){maskWithBackspaceCheck(this.value,this,'2',':',event);}
	  e6.tabindex='1';
	  e6.maxLength='5';
	  cell7.appendChild(e6);

	  var cell8 = row.insertCell(8);
	  var e7 = document.createElement('input');
	  e7.type = 'text';
	  e7.name='sittingTime'+iteration;
	  e7.id='sittingTime'+iteration
	  e7.size = '10';
	  e7.onblur = function(){IsValidTimeWithBlankCheck(this.value,this.id);}
	  e7.onkeyup = function(){maskWithBackspaceCheck(this.value,this,'2',':',event);}
	  e7.setAttribute('tabindex','1');
	  cell8.appendChild(e7);

	 /* var cell8 = row.insertCell(8);
	  var e8 = document.createElement('input');
	  e8.type = 'text';
	  e8.name='nextAppointmentDate'+iteration;
	  e8.id='nextAppointmentDate'+iteration
	  e8.size = '8';
	  e8.setAttribute('tabindex','1');
	  cell8.appendChild(e8);

	  var eImg = document.createElement('img');
	  eImg.src = '/hms/jsp/images/cal.gif';
      eImg.id = 'calId'+iteration;
	  eImg.onclick = function(event){
					setdate('',document.getElementById('nextAppointmentDate'+iteration),event) };
	   cell8.appendChild(e8);
	  cell8.appendChild(eImg);

	  var cell9 = row.insertCell(9);
	  var e9 = document.createElement('input');
	  e9.type = 'text';
	  e9.name='nextAppointmentTime'+iteration;
	  e9.id='nextAppointmentTime'+iteration
	  e9.size = '3';
	  e9.onblur = function(){IsValidTimeWithBlankCheck(this.value,this.id);}
	  e9.onkeyup = function(event){maskWithBackspaceCheck(this.value,this,'2',':',event);}
	  e9.setAttribute('tabindex','1');
	  cell9.appendChild(e9);*/
	  var cell9 = row.insertCell(9);
	  //var e8 = document.createElement('input');
	  //e8.type = 'text';
	  //e8.name='nextAppointmentDate'+iteration;
	  //e8.id='nextAppointmentDate'+iteration
	  //e8.size = '12';
	  cell9.innerHTML='--'
	 // e8.setAttribute('tabindex','1');
	  //cell8.appendChild(e8);

	 /* var eImg = document.createElement('img');
	  eImg.src = '/hms/jsp/images/cal.gif';
      eImg.id = 'calId'+iteration;
	  eImg.onclick = function(event){
					setdate('',document.getElementById('nextAppointmentDate'+iteration),event) };
	   cell8.appendChild(e8);
	  cell8.appendChild(eImg);*/

	  var cell10 = row.insertCell(10);
	  var e10 = document.createElement('input');
	  e10.type = 'text';
	  e10.name='remarks'+iteration;
	  e10.id='remarks'+iteration
	  e10.size = '5';
	  e10.maxLength='50';
	  e10.setAttribute('tabindex','1');
	  cell10.appendChild(e10);


	  var cell11 = row.insertCell(11);
	  var e11 = document.createElement('input');
	  e11.type = 'button';
	  e11.className = 'buttonAdd';
	  e11.name='Button'+iteration;
	  e11.onclick = function(){addRow();};
	  e11.setAttribute('tabindex','1');
	  cell11.appendChild(e11);

	  var cell12 = row.insertCell(12);
	  var e12 = document.createElement('input');
	  e12.type = 'button';
	  e12.className = 'buttonDel';
	  e12.name='delete'+iteration;
	 // e12.setAttribute('onclick', 'removeRow();');
	  e12.onclick = function(){removeRow();}; 
	  e12.setAttribute('tabindex','1');
	  cell12.appendChild(e12);
}
function removeRow()
{
  var tbl = document.getElementById('tharapyGrid');
  var lastRow = tbl.rows.length;
  if (lastRow > 2){
  	tbl.deleteRow(lastRow - 1);
  	var tbl = document.getElementById('tharapyGrid');
  	var lastRow = tbl.rows.length;
	  // if there's no header row in the table, then iteration = lastRow + 1
 	var iteration = lastRow - 1;
  	var hdb = document.getElementById('hdb');
  	hdb.value=iteration
  }
}

function validatePhyFields(){
	var count = document.getElementById('tharapyCount').value;
	var flag ='';
	 for(var i =1; i <= count; i++){
		 if(document.getElementById('therapyId'+i)){
		var theraphyId = document.getElementById('therapyId'+i).value;
		if(theraphyId!=='0')
	      	 {
	          flag = 'filled';
	          break;
			}
		 }
		}
	//alert("flag===="+flag);
	 var msg = "";
	 for(var j = 1;j <= count;j++){
		 if(document.getElementById('therapyId'+j)){
				var therapyId = document.getElementById('therapyId'+j).value;
				if( therapyId != '0'){
				if(document.getElementById('durationId'+j).value == 0 )
	            {
					msg += "Please select the Duration in row "+(j)+".\n";
					
				 }	
				if(document.getElementById('frequency'+j).value == 0 && document.getElementById('durationId'+j).value != 0)
	            {
					msg += "Please select the Frequency in row "+(j)+".\n";
					
				 }	
				if(document.getElementById('noOfDays'+j).value == 0 && document.getElementById('durationId'+j).value != 0)
	            {
					msg += "Please select the no of days in row "+(j)+".\n";
					
				 }
				if(document.getElementById('timeBegin'+j).value == 0 && document.getElementById('noOfDays'+j).value != 0 && document.getElementById('durationId'+j).value != 0 )
	            {
					msg += "Please select Time Begin in row "+(j)+".\n";
					
				 }
				if(document.getElementById('timeComplete'+j).value == 0  && document.getElementById('timeBegin'+j).value != 0 && document.getElementById('noOfDays'+j).value != 0 && document.getElementById('durationId'+j).value != 0 )
	            {
					msg += "Please select Time Complete in row "+(j)+".\n";
					
				 }
				if(document.getElementById('sittingTime'+j).value == 0  && document.getElementById('timeComplete'+j).value != 0  && document.getElementById('timeBegin'+j).value != 0 && document.getElementById('noOfDays'+j).value != 0 && document.getElementById('durationId'+j).value != 0 )
	            {
					msg += "Please select Sitting Time in row "+(j)+".\n";
					
				 }	
				}
		 	}
		}
		if(flag==''){
		 msg += "Please select Therapy Type.\n";;
					
		}
		if(msg!=''){
			alert(msg);
			return false;
		}
	return true;	
	 }
	


function HMStoSec1(T) { // h:m:s

	  var A = T.split(/\D+/) ;
	
	  return (A[0]*60 + +A[1])*60
	}
function calculateTime(inc){

	var time1 = HMStoSec1(document.getElementById('timeBegin'+inc).value);
	var time2 = HMStoSec1(document.getElementById('timeComplete'+inc).value);
	 var totalTime ;
	var diff = time2 - time1;
	if(document.getElementById('timeBegin'+inc).value == "00:00" && document.getElementById('timeComplete'+inc).value == "00:00"){
		alert("Time cannot be 00:00");
		document.getElementById('totalHours').value = "00:00";
		return false;
	}
	else if(document.getElementById('timeComplete'+inc).value >= document.getElementById('timeBegin'+inc).value){
		totalTime = (convertSecondsToHHMM(diff));
		document.getElementById('sittingTime'+inc).value = totalTime;
	return true;
	}else{
	alert("Time Begin should be less than Time Completed");
	return false;
	}

}

function validateRadio(){
	 for(var i = 0; i < document.getElementsByName('physioRequisitionHeaderId').length; i++){
	//alert("i-- "+i)
	//alert("document.getElementsByName('parent').length"+ document.getElementsByName('parent').length)
	  if(document.getElementsByName('physioRequisitionHeaderId')[i].checked == true)
    {
		
		return true;
	  }		
	}
	alert("Please select one record.")
	return false;
}

function convertSecondsToHHMM(intSecondsToConvert) {

	var hours = convertHours(intSecondsToConvert);
	hours = (hours<10)?"0"+hours : hours
	var minutes = getRemainingMinutes(intSecondsToConvert);
	minutes = (minutes == 60) ? "00" : minutes;
	minutes = (minutes<10)?"0"+minutes : minutes
//	var seconds = getRemainingSeconds(intSecondsToConvert);
	
 	var time = hours+":"+minutes;
	return time;

}

</script>
