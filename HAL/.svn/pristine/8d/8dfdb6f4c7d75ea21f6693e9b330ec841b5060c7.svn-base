<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.MasServiceType"%>

<%@page import="jkt.hms.masters.business.MasEmployee"%>

<%@page import="jkt.hms.masters.business.ProcedureHeader"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.MasNursingCare"%>
<%@page import="jkt.hms.masters.business.PatientDetentionRegister"%><script type="text/javascript" language="javascript"src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript"language="javascript">
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
		
	function datevalidation(){
	
	
	var fdate = document.getElementById('FromDateId');
	var tdate = document.getElementById('ToDateId');
	
	frdate  = new Date(fdate.value.substring(6),(fdate.value.substring(3,5) - 1) ,fdate.value.substring(0,2));
	todate  = new Date(tdate.value.substring(6),(tdate.value.substring(3,5) - 1) ,tdate.value.substring(0,2));
	
	
	if(fdate.value != "" && todate.value != ""){
	 if(frdate > todate){
	  alert("To Date should be greater than or equal to the From Date.");
	   return false;
	  }
	}else{
	 return false;
	}
	return true;	
		
		}
		
	
	</script>
	<%
	Map<String, Object> map = new HashMap<String, Object>();
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	
	List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
	if(map.get("doctorList") != null){
		doctorList= (List<MasEmployee>)map.get("doctorList");
	}
	List<PatientDetentionRegister> pendingDetentionList = new ArrayList<PatientDetentionRegister>();
	if(map.get("pendingDetentionList") != null){
		pendingDetentionList= (List<PatientDetentionRegister>)map.get("pendingDetentionList");
	}
	String message = "";
	if(map.get("message") != null){
		message = (String)map.get("message");
	}
	Box box= HMSUtil.getBox(request);
	%>

<form name="detentionWaitList" method="post" action="">
	<h4><%=message %></h4>
<div class="Clear"></div>
<div class="titleBg"><h2>Patient Detention</h2></div>

<div class="Clear"></div>
<div class="Block">
<div class="Clear"></div>
<label> From Date <span>*</span></label>
<input type="text" id="FromDateId" name="<%=FROM_DATE %>" value="<%=(!box.getString(FROM_DATE).equals("") ? box.getString(FROM_DATE) : currentDate) %>" class="calDate" readonly="readonly"MAXLENGTH="30" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate%>',document.detentionWaitList.<%=FROM_DATE%>,event)" />

<label>To Date <span>*</span></label>
 <input type="text" id="ToDateId"name="<%=TO_DATE %>" value="<%=(!box.getString(TO_DATE).equals("") ? box.getString(TO_DATE) : currentDate) %>" class="calDate"	readonly="readonly" MAXLENGTH="30" /> 
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"	onClick="setdate('<%=currentDate%>',document.detentionWaitList.<%=TO_DATE%>,event)" />
	
<label>Service No. </label>
<input type="text" name="<%=SERVICE_NO %>" id="serviceNo" value="<%=(!box.getString(SERVICE_NO).equals("") ? box.getString(SERVICE_NO) : "") %>" validate="Service No.,metachar,no" /> 
<div class="Clear"></div>
<label> Medical Officer</label> 
<select name="<%=MEDICAL_OFFICER %>" validate="Medical Officer,string,no">
	<option value="0">Select</option>
	<% 
			for(MasEmployee employee : doctorList)
			{
				String doctorName = employee.getRank().getRankName()+" "+employee.getFirstName();
				if(employee.getMiddleName()!= null){
					doctorName += " "+employee.getMiddleName();
				}
				if(employee.getLastName()!= null){
					doctorName += " "+employee.getLastName();
				}
			%>
	<option value="<%=employee.getId()%>" <%=HMSUtil.isSelected(employee.getId(),Integer.valueOf(box.getInt(MEDICAL_OFFICER)))%>><%=doctorName %></option>
	<%
			}
			%>
</select>
<div class="Clear"></div>	
</div>
<div class="Clear"></div>
<input type="button" name="search" value="Search" class="button"
	onClick="if(datevalidation()){submitForm('detentionWaitList','/hms/hms/registration?method=getPendingDetentionList');}" />

<div class="Clear"></div>

<div class="division"></div>
<%
	if(pendingDetentionList.size() > 0){
%>
<h4>Patient List For Detention</h4>
<div id="reg">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Date</th>
		<th scope="col">Service No.</th>
		<th scope="col">Name</th>
		<th scope="col">Relation</th>
		<th scope="col">Rank</th>
		<th scope="col">Name</th>
		<th scope="col">Age</th>
	</tr>
	<%
		for(PatientDetentionRegister detentionRegister : pendingDetentionList){
			String bgcolor = "";
			if(detentionRegister.getVisit().getPriority()==1){
				bgcolor="#B40404";
			}
			else if(detentionRegister.getVisit().getPriority()==2){
				bgcolor="#FFFF00";
			}
			else if(detentionRegister.getVisit().getPriority()==3){
				bgcolor="#A0E0AA";
			}
	%>
	<tr onclick="getDetails('<%=detentionRegister.getId() %>','<%=detentionRegister.getVisit().getId() %>');">
	<td style="background:<%=bgcolor %>;"><%=HMSUtil.convertDateToStringTypeDateOnly(detentionRegister.getRequisitionDate()) %></td>
	<td style="background:<%=bgcolor %>;"><%=detentionRegister.getHin().getServiceNo()!=null?detentionRegister.getHin().getServiceNo():"" %></td>
	<%
	String middleName = "";
	String lastName = "";
	if(detentionRegister.getHin().getPMiddleName() != null){
		middleName = detentionRegister.getHin().getPMiddleName();
	}
	if(detentionRegister.getHin().getPLastName() != null){
		lastName = detentionRegister.getHin().getPLastName();
	}

	%>
	<td style="background:<%=bgcolor %>;"><%=detentionRegister.getHin().getPFirstName()+" "+middleName+" "+lastName %></td>
	<td style="background:<%=bgcolor %>;"><%=detentionRegister.getHin().getRelation().getRelationName() %></td>
	<td style="background:<%=bgcolor %>;"><%=detentionRegister.getHin().getRank().getRankName() %></td>
	<%
	String sMiddleName = "";
	String sLastName = "";

	if(detentionRegister.getHin().getSMiddleName() != null){
		sMiddleName = detentionRegister.getHin().getSMiddleName();
	}
	if(detentionRegister.getHin().getSLastName() != null){
		sLastName = detentionRegister.getHin().getSLastName();
	}
%>
	<td style="background:<%=bgcolor %>;"><%=detentionRegister.getHin().getSFirstName()+" "+sMiddleName+" "+sLastName %></td>
	<td style="background:<%=bgcolor %>;"><%=detentionRegister.getHin().getAge() %></td>
	
	</tr>
	
	<%} %>
	</table>
	<div class="Clear"></div>	
	
<input type="text" class="signPriority1" readonly="readonly">
<label class="valueAutoPriority">Priority-1</label>
<input type="text" class="signPriority2" readonly="readonly">
<label class="valueAutoPriority">Priority-2</label>
<input type="text" class="signPriority3" readonly="readonly">
<label class="valueAutoPriority">Priority-3</label>
<div class="Clear"></div>
</div>
<%}else{ %>
<h4>No Record Found</h4>
<%} %>
</form>
<script>
function getDetails(detentionId,visitId){

	if(validateMetaCharacters(detentionId) && validateMetaCharacters(visitId)){
		submitForm('detentionWaitList','/hms/hms/registration?method=getPendingDetentionDetails&detentionId='+detentionId+'&visitId='+visitId);
	}
}
</script>