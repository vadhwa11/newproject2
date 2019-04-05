<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.ExpiryDetails"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.ExpiryDetails"%>

<%@page import="jkt.hms.masters.business.FatalDocumentHeader"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MisFatalTracking"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript">
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
	</script> <%
	 			
			 	String userName = "";
			 	if (session.getAttribute("userName") != null) {
			 		userName = (String) session.getAttribute("userName");
			 	}
			 	Map<String, Object> utilMap = new HashMap<String, Object>();
			 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			 			
			 	String currentDate = (String) utilMap.get("currentDate");
			 	String time = (String) utilMap.get("currentTime");
			 	String hinNo=null;

			 	Map<String, Object> map = new HashMap<String, Object>();
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
					 	
			 	List<Inpatient> inpatientList = new ArrayList<Inpatient>();
				//List<MisFatalTracking> misFatalTrackingList = new ArrayList<MisFatalTracking>();
				List<FatalDocumentHeader> misFatalTrackingList = new ArrayList<FatalDocumentHeader>();
			 	Date dateOfDeath=null;
			 	if (map.get("inpatientList") != null) {
			 		inpatientList = (List<Inpatient>) map.get("inpatientList");
			 	}
			 	List<MisFatalTracking> misFatalTrackList = new ArrayList<MisFatalTracking>();
			 	if (map.get("misFatalTrackList") != null) {
			 		misFatalTrackList = (List<MisFatalTracking>) map.get("misFatalTrackList");
			 	}
			 	if (map.get("misFatalTrackingList") != null) {
			 		misFatalTrackingList = (List<FatalDocumentHeader>) map.get("misFatalTrackingList");
			 	}
	
	int misFatalId  =0;
	String dod ="";
	%>
	
		<%--
			<% if(inpatientList.size() >0){
				for(Inpatient inpatient :inpatientList){
		%>
<div id="show1">

<div class="blockTitle">Personnel Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div class="blockFrame"><label>A&D No.:</label> <%if(inpatient.getAdNo()!=null){ %>
<label class="value"><%=inpatient.getAdNo()%></label> <% session.setAttribute("adNo",inpatient.getAdNo()); 
		}else{%> <label class="value">-</label> <%}%> <label>Patient
Name:</label> <%if(inpatient.getHin()!=null){ %> <label class="value"><%=inpatient.getHin().getPFirstName()%>
<%=inpatient.getHin().getPLastName()%></label> <%}else{ %> <label class="value">-</label>
<%}%> <label>Sex:</label> <%if(inpatient.getHin()!=null){ %> <label
	class="value"><%=inpatient.getHin().getSex().getAdministrativeSexName()%></label>
<%}else{ %> <label class="value">-</label> <%}%> <label>Sex:</label> <%if(inpatient.getHin()!=null){ %>
<label>Relation:</label> <%}else{ %> <label class="value">-</label> <%}%> <%if(inpatient.getHin().getRelation()!=null){ %>
<label class="value"><%=inpatient.getHin().getRelation().getRelationName()%></label>
<%} else{%> <label class="value">-</label> <%}%>

<div class="Clear"></div>

<label>Service No.</label> <%if(inpatient.getHin().getServiceNo()!=null){ %>
<label class="value"><%=inpatient.getHin().getServiceNo()%></label> <%} else { %>
<label class="value">-</label> <%} %> <label>Rank:</label> <%if(inpatient.getHin().getRank()!=null){ %>
<label class="value"><%= inpatient.getHin().getRank().getRankName()%></label>
<%}else {%> <label class="value">-</label> <%} %> <label>Service
Name:</label> <%if( inpatient.getHin().getSFirstName()!=null && inpatient.getHin().getSLastName()!=null){ %>
<label class="value"><%= inpatient.getHin().getSFirstName()%> <%= inpatient.getHin().getSLastName()%></label>
<%} else {%> <label class="value">-</label> <%}%>

<div class="Clear"></div>

<label>Unit</label> <%if(inpatient.getHin().getUnit()!=null){ %> <label
	class="value"><%= inpatient.getHin().getUnit().getUnitName()%></label>
<%} else{%> <label class="value">-</label> <%} %> <label>Service:</label> <%if(inpatient.getHin().getServiceType()!=null){ %>
<label class="value"><%=inpatient.getHin().getServiceType().getServiceTypeName()%></label>
<%} else{%> <label class="value">-</label> <%} %> <label>Branch
Trade:</label> <%
		if(inpatient.getHin().getTrade()!=null){%> <label class="value"><%=inpatient.getHin().getTrade().getTradeName()%></label>
<%} else{%> <label class="value">-</label> <%} %>

<div class="Clear"></div>

<label>Total service:</label> <%if(inpatient.getHin().getServiceYears()!=null){ %>
<label class="value"><%=inpatient.getHin().getServiceYears()%></label> <%} else{%>
<label class="value">-</label> <%} %> <label>Ward </label> <%if(inpatient.getDepartment()!=null){ %>
<label class="value"><%=inpatient.getDepartment().getDepartmentName()%></label>
<%}else{ %> <label class="value">-</label> <%}%> <label>Age:</label> <%if(inpatient.getHin()!=null){ %>
<label class="value"><%=HMSUtil.calculateAgeForADT(inpatient.getHin().getAge(),inpatient.getHin().getRegDate())%></label>
<%}else{ %> <label class="value">-</label> <%}%>

<div class="Clear"></div>

<label>DOB:</label> <%if(inpatient.getHin().getDateOfBirth()!=null){ %> <label
	class="value"><%=HMSUtil.convertDateToStringWithoutTime(inpatient.getHin().getDateOfBirth())%></label>
<%} else{ %> <label class="value">-</label> <%} %> <label>Date of
Death:</label> <%if(inpatient.getDischargeDate()!=null){ %> <label class="value"><%=HMSUtil.convertDateToStringWithoutTime(inpatient.getDischargeDate())%></label>
<%}else{ %> <label class="value">-</label> <%}%> <label>Diagnosis:</label>
<input type="hidden" name="hinId"
	value="<%=inpatient.getHin().getId()%>"> 
	
	<%}
				}else{ %> 
	<h4>No Records found </h4>
	<%}%>
<div class="Clear"></div>

</div>
--%>	
<%
	if(misFatalTrackingList.size() >0){
		for(FatalDocumentHeader fatalTracking :misFatalTrackingList){
			misFatalId  =fatalTracking.getId();
			if(fatalTracking.getDateOfDeath() !=null){
				dod=HMSUtil.convertDateToStringWithoutTime(fatalTracking.getDateOfDeath());
			}
		%>
<div id="show1">
<h4>Personnel Details</h4>
<div class="Clear"></div>

<div class="Block"><label>A&D No.:</label>
 <%if(fatalTracking.getAdNo()!=null){ %>
<label class="value"><%=fatalTracking.getAdNo()%></label> 
<% session.setAttribute("adNo",fatalTracking.getAdNo()); 
		}else{%> 
		<label class="value">-</label>
		 <%}%> 
	

<label>Service No.</label> 
<%if(fatalTracking.getServiceNo()!=null){ %>
<label class="value"><%=fatalTracking.getServiceNo()%></label> 
<%} else { %>
<label class="value">-</label> 
<%} %> <label>Rank</label> 
<%if(fatalTracking.getRankId()!=null){ %>
<label class="value"><%= fatalTracking.getRankId().getRankName()%></label>
<%}else {%> 
<label class="value">-</label> 
<%} %> 
<label> Name</label> 
<%if( fatalTracking.getSPersonName()!=null){ %>
<label class="value"><%= fatalTracking.getSPersonName()%> </label>
<%} else {%> 
<label class="value">-</label>
 <%}%>


<label>Unit</label> 
<%if(fatalTracking.getUnitId()!=null){ %> 
<label class="value"><%=fatalTracking.getUnitId().getUnitName()%></label>
<%} else{%> 
<label class="value">-</label>
 <%} %> 
 
<label>Branch/Trade</label>
 <%
		if(fatalTracking.getTradeId()!=null){%> <label class="value"><%=fatalTracking.getTradeId().getTradeName()%></label>
<%} else{%> 
<label class="value">-</label> <%} %>

<div class="Clear"></div>

<label>Total Service</label> 
<%if(fatalTracking.getTotalService()!=null){ %>
<label class="value"><%=fatalTracking.getTotalService()%></label> 
<%} else{%>
<label class="value">-</label> <%} %> 

<label>Age</label> 
<%if(fatalTracking.getAge()!=null){ %>
<label class="value"><%=fatalTracking.getAge()%></label>
<%}else{ %> 
<label class="value">-</label> <%}%>


<label>DOB</label> 
<%if(fatalTracking.getDateOfBirth()!=null){ %> 
<label	class="value"><%=HMSUtil.convertDateToStringWithoutTime(fatalTracking.getDateOfBirth())%></label>
<%} else{ %> 
<label class="value">-</label> 
<%} %> 

<div class="Clear"></div>
<label>Date of Death:</label> 
<%if(fatalTracking.getDateOfDeath()!=null){ %> 
<label class="value"><%=HMSUtil.convertDateToStringWithoutTime(fatalTracking.getDateOfDeath())%></label>
<%}else{ %> 
<label class="value">-</label> 
<%}%> 
<label>Diagnosis:</label>
<label class="value"><%=fatalTracking.getDiagnosis()!=null?fatalTracking.getDiagnosis():"" %></label>
<input type="hidden" name="hinId" value="<%=fatalTracking.getHinId()!=null?fatalTracking.getHinId().getId():0%>"> 
	
	<%}
				}else{ %> 
	<h4>No Records found </h4>
	<%}%>
<div class="Clear"></div>
</div>
</div>
<h4>Dispatch Details</h4>
<div class="Clear"></div>
<div class="tableHholderCmnLarge2">
<table width="98%" border="0" cellpadding="0" cellspacing="0" class="">
	<thead>
		<tr>
			<th width="28" class="">Sl No.</th>
			<th width="272" class="">Details of Dispatch</th>
			<th width="171" class="" colspan="2">Date</th>
			<th width="335" class="">Remarks</th>
		</tr>
<%
int trackId = 0;
	MisFatalTracking fatalTracking = new MisFatalTracking();
	if(misFatalTrackList.size() > 0){
		fatalTracking = misFatalTrackList.get(0);
		trackId = fatalTracking.getId();
	}
%>
	</thead>
	<tbody>
		<tr>
			<td height="22">1.</td>
			<td>Date of Death</td>
			<td><input type="text" id="dateOfExpiryId"
				name="<%=DATE_OF_DEATH%>" value="<%=dod%>" size="8"
				readonly="readonly" MAXLENGTH="30" /></td>
			<td><img src="/hms/jsp/images/cal.gif" width="16"
				height="16" border="0" validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_DEATH%>,event)" />
			</td>
			<td><input name="<%=DEATH_REMARK %>" type="text" size="55" maxlength="200"
				value="<%=(fatalTracking!=null && fatalTracking.getDateofDeathRem()!=null)?fatalTracking.getDateofDeathRem():"" %>"></td>
		</tr>
		<tr>
			<td height="22">2.</td>
			<td>Postmortem</td>
			<td><select id="postmortem" name="<%=POSTMORTEM %>" class="auto">
				<option value="y">Held</option>
				<option value="n" selected="selected">Not Held</option>
			</select></td>
			<td>&nbsp;</td>
			<script>
			document.getElementById('postmortem').value = '<%=(fatalTracking!=null && fatalTracking.getPostmortem()!=null)?fatalTracking.getPostmortem():"n"%>'
			</script>
			<td><input name="<%=POSTMORTEM_REMARK %>" type="text" size="55" maxlength="200"
				value="<%=(fatalTracking!=null && fatalTracking.getDateofDeathRem()!=null)?fatalTracking.getDateofDeathRem():"" %>"></td>
		</tr>
		<tr>
			<td height="22">3.</td>
			<td>Date of Postmortem Received</td>
			<td><input type="text" name="<%=DATE_OF_POSTMORTEM %>"
				value="<%= (fatalTracking!=null && fatalTracking.getDateofPostRec()!=null)?HMSUtil.convertDateToStringWithoutTime(fatalTracking.getDateofPostRec()):""%>" size="8" tabindex=3
				readonly="readonly" /></td>
			<td><img src="/hms/jsp/images/cal.gif" width="16"
				height="16" border="0" validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_POSTMORTEM%>,event)" />
			</td>
			<td><input name="<%=POSTMORTEM_DATE_REMARK %>" type="text" maxlength="200"
				size="55" value="<%=(fatalTracking!=null && fatalTracking.getDateofPostRecRem()!=null)?fatalTracking.getDateofPostRecRem():"" %>"></td>
		</tr>
		<tr>
			<td height="22">4.</td>
			<td>Documents H/O spl concerned Date</td>
			<td><input type="text" name="<%=DATE_OF_CONCERNED %>"
				value="<%= (fatalTracking!=null && fatalTracking.getHodPerusal()!=null)?HMSUtil.convertDateToStringWithoutTime(fatalTracking.getHodPerusal()):""%>" size="8" tabindex=3 readonly="readonly" />
			</td>
			<td><img src="/hms/jsp/images/cal.gif" width="16"
				height="16" border="0" validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_CONCERNED%>,event)" />
			</td>
			<td><input name="<%=CONCERNED_DATE_REMARK %>" type="text" maxlength="200"
				size="55" value="<%=(fatalTracking!=null && fatalTracking.getHoSplconceRem()!=null)?fatalTracking.getHoSplconceRem():"" %>"></td>
		</tr>
		<tr>
			<td height="22">5.</td>
			<td>Received from spl with opinion and Date</td>
			<td><input type="text" name="<%=DATE_OF_OPINION %>"
				value="<%= (fatalTracking!=null && fatalTracking.getRecSplOpDate()!=null)?HMSUtil.convertDateToStringWithoutTime(fatalTracking.getRecSplOpDate()):""%>" size="8" tabindex=3 readonly="readonly" />
			</td>
			<td><img src="/hms/jsp/images/cal.gif" width="16"
				height="16" border="0" validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_OPINION%>,event)" />
			</td>
			<td><input name="<%=OPINION_DATE_REMARK %>" type="text" maxlength="200"
				size="55" value="<%=(fatalTracking!=null && fatalTracking.getRecSplOpRem()!=null)?fatalTracking.getRecSplOpRem():"" %>"></td>
		</tr>
		<tr>
			<td height="22">6.</td>
			<td>Completion of documents by Ward and Date</td>
			<td><input type="text" name="<%=DATE_OF_WARD_MASTER %>"
				value="<%= (fatalTracking!=null && fatalTracking.getWardMaster()!=null)?HMSUtil.convertDateToStringWithoutTime(fatalTracking.getWardMaster()):""%>" size="8" tabindex=3 readonly="readonly" />
			</td>
			<td><img src="/hms/jsp/images/cal.gif" width="16"
				height="16" border="0" validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_WARD_MASTER%>,event)" />
			</td>
			<td><input name="<%=WARD_MASTER_DATE_REMARK %>" type="text" maxlength="200"
				size="55" value="<%=(fatalTracking!=null && fatalTracking.getWardMasterRem()!=null)?fatalTracking.getWardMasterRem():"" %>"></td>
		</tr>
		<tr>
			<td height="22">7.</td>
			<td>Signature of MO i/c Ward</td>
			<td><input type="text" name="<%=DATE_OF_MO_WARD %>"
				value="<%= (fatalTracking!=null && fatalTracking.getMoicWard()!=null)?HMSUtil.convertDateToStringWithoutTime(fatalTracking.getMoicWard()):""%>" size="8" tabindex=3 readonly="readonly" />
			</td>
			<td><img src="/hms/jsp/images/cal.gif" width="16"
				height="16" border="0" validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_MO_WARD%>,event)" />
			</td>
			<td><input name="<%=WARD_REMARK %>" type="text" size="55" maxlength="200"
				value="<%=(fatalTracking!=null && fatalTracking.getMoicWardRem()!=null)?fatalTracking.getMoicWardRem():"" %>"></td>
		</tr>
		<tr>
			<td height="22">8.</td>
			<td>HOD persual on (Date)</td>
			<td><input type="text" name="<%=DATE_OF_HOD %>"
				value="<%= (fatalTracking!=null && fatalTracking.getHodPerusal()!=null)?HMSUtil.convertDateToStringWithoutTime(fatalTracking.getHodPerusal()):""%>" size="8" tabindex=3 readonly="readonly" />
			</td>
			<td><img src="/hms/jsp/images/cal.gif" width="16"
				height="16" border="0" validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_HOD%>,event)" />
			</td>
			<td><input name="<%=HOD_DATE_REMARK %>" value="<%=(fatalTracking!=null && fatalTracking.getHodPerusalRem()!=null)?fatalTracking.getHodPerusalRem():"" %>"
				validate="Kin Address,string,Yes" id="nokAddr" size="55" maxlength="200"
				onpaste="return checkOnPaste(this)"
				oninput="return checkMaxLengthMoz(this)"
				onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
				maxlength="50" tabindex="1" /></td>
		</tr>
		<tr>
			<td height="22">9.</td>
			<td>Date of submission of Stats by Ward</td>
			<td><input type="text" name="<%=DATE_OF_STATS %>"
				value="<%= (fatalTracking!=null && fatalTracking.getStatasWard()!=null)?HMSUtil.convertDateToStringWithoutTime(fatalTracking.getStatasWard()):""%>" size="8" tabindex=3 readonly="readonly" /></td>
			<td><img src="/hms/jsp/images/cal.gif" width="16"
				height="16" border="0" validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_STATS%>,event)" />
			</td>
			<td><input name="<%=STATS_DATE_REMARK %>" type="text" size="55" maxlength="200"
				value="<%=(fatalTracking!=null && fatalTracking.getStatasWardRem()!=null)?fatalTracking.getStatasWardRem():"" %>"></td>
		</tr>
		<tr>
			<td height="22">10.</td>
			<td>Date of submission for remarks of SMO</td>
			<td><input type="text" name="<%=DATE_OF_COMMANDANT %>"
				value="<%= (fatalTracking!=null && fatalTracking.getCommanRemarks()!=null)?HMSUtil.convertDateToStringWithoutTime(fatalTracking.getCommanRemarks()):""%>" size="8" tabindex=3 readonly="readonly" /></td>
			<td><img src="/hms/jsp/images/cal.gif" width="16"
				height="16" border="0" validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_COMMANDANT%>,event)" />
			</td>
			<td><input name="<%=COMMANDANT_DATE_REMARK %>" value="<%=(fatalTracking!=null && fatalTracking.getCommanRemarksRem()!=null)?fatalTracking.getCommanRemarksRem():"" %>"
				validate="Kin Address,string,Yes" id="nokAddr" size="55"
				onpaste="return checkOnPaste(this)"
				oninput="return checkMaxLengthMoz(this)"
				onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
				maxlength="50" tabindex="1" maxlength="200"/></td>

		</tr>
		<tr>
			<td height="22">11.</td>
			<td>Date of Dispatch to Senior Advisor Pathology for Persual</td>
			<td><input type="text" name="<%=DATE_OF_PATHOLOGY %>"
				value="<%= (fatalTracking!=null && fatalTracking.getPatologyHead()!=null)?HMSUtil.convertDateToStringWithoutTime(fatalTracking.getPatologyHead()):""%>" size="8" tabindex=3 readonly="readonly" /></td>
			<td><img src="/hms/jsp/images/cal.gif" width="16"
				height="16" border="0" validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_PATHOLOGY%>,event)" />
			</td>
			<td><input name="<%=PATHOLOGY_DATE_REMARK %>" type="text" maxlength="200"
				size="55" value="<%=(fatalTracking!=null && fatalTracking.getPatologyHeadRem()!=null)?fatalTracking.getPatologyHeadRem():"" %>"></td>
		</tr>
		<tr>
			<td height="22">12.</td>
			<td>Date of Dispatch to Senior Advisor for Persual</td>
			<td><input type="text" name="<%=DATE_OF_SENIOR_ADVISOR_1 %>"
				value="<%= (fatalTracking!=null && fatalTracking.getSeniorAdvisor1()!=null)?HMSUtil.convertDateToStringWithoutTime(fatalTracking.getSeniorAdvisor1()):""%>" size="8" tabindex=3 readonly="readonly" /></td>
			<td><img src="/hms/jsp/images/cal.gif" width="16"
				height="16" border="0" validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_SENIOR_ADVISOR_1%>,event)" />
			</td>
			<td><input name="<%=SA1_DATE_REMARK %>" type="text" size="55" maxlength="200"
				value="<%=(fatalTracking!=null && fatalTracking.getSeniorAdvisor1Rem()!=null)?fatalTracking.getSeniorAdvisor1Rem():"" %>"></td>
		</tr>
		<tr>
			<td height="22">13.</td>
			<td>Date of Dispatch to Concerned Command for Persual</td>
			<td><input type="text" name="<%=DATE_OF_CONCERNED_COMMAND %>"
				value="<%= (fatalTracking!=null && fatalTracking.getDespatchCommandant()!=null)?HMSUtil.convertDateToStringWithoutTime(fatalTracking.getDespatchCommandant()):""%>" size="8" tabindex=3 readonly="readonly" /></td>
			<td><img src="/hms/jsp/images/cal.gif" width="16"
				height="16" border="0" validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_CONCERNED_COMMAND%>,event)" />
			</td>
			<td><input name="<%=CONCERNED_COMMAND_DATE_REMARK %>" maxlength="200"
				type="text" size="55" value="<%=(fatalTracking!=null && fatalTracking.getDespatchCommandantRem()!=null)?fatalTracking.getDespatchCommandantRem():"" %>"></td>
		</tr>
	</tbody>
</table>
</div>

<input type="hidden" name="<%=MIS_FATAL_ID%>" value="<%=misFatalId %>"  MAXLENGTH="10" />
<input type="text" name="trackId" value="<%=trackId %>"  MAXLENGTH="10" />
<div class="Clear"></div>

<input type="hidden" name="<%= CHANGED_BY%>" value="<%=userName%>" readonly="readonly" />
<input type="hidden" name="<%= CHANGED_DATE %>" value="<%=currentDate%>" readonly="readonly" tabindex=3 />
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" readonly="readonly" tabindex=3 />
	
	 <input
	type="button" name="edit" value="Submit" class="button"
	onClick="submitForm('fatalCase','mis?method=editFatalCase');" />
<div class="Clear"></div>