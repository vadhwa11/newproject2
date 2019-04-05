<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.MasServiceType"%>

<%@page import="jkt.hms.masters.business.MasEmployee"%>

<%@page import="jkt.hms.masters.business.ProcedureHeader"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.MasNursingCare"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%><script type="text/javascript" language="javascript"src="/hms/jsp/js/calendar.js"></script>
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
	
	List<Visit> labWaitingList = new ArrayList<Visit>();
	
	if(map.get("labWaitingList") != null){
		labWaitingList= (List<Visit>)map.get("labWaitingList");
	}
	List<DgOrderhd> otherDgWaitList = new ArrayList<DgOrderhd>();
	if(map.get("otherDgWaitList") != null){
		otherDgWaitList= (List<DgOrderhd>)map.get("otherDgWaitList");
	}
	String message = "";
	if(map.get("message") != null){
		message = (String)map.get("message");
	}
	Box box= HMSUtil.getBox(request);
	%>
<div class="titleBg"><h2>Investigation Requisition Waiting List</h2></div>
<form name="investigationWaitList" method="post" action="">
	<h4><%=message %></h4>
<div class="Clear"></div>

<div class="Block">
<label>Service No. </label> 
<input type="text" id="serviceNo" name="<%= SERVICE_NO %>" value="" onblur="if(validateMetaCharacters(this.value)){if(this.value!=''){submitProtoAjax('investigationWaitList','/hms/hms/registration?method=getHinNoForDMA&flag=invRequisition');}}" validate="Service No,stirng,no">
<label>HIN <span>*</span></label> 
<div id="testDiv">
<input type="text" id="hinNo" name="<%= HIN_NO %>" value="" />
<input type="hidden" id="hinId" name="hinId" value="0"/>
</div>
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<%
	if(labWaitingList.size() > 0){
%>
<div id="reg">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Date</th>
		<th scope="col">Service No.</th>
		<th scope="col">Patient Name</th>
		<th scope="col">Relation</th>
		<th scope="col">Rank</th>
		<th scope="col">Name</th>
		<th scope="col">Age</th>
	</tr>
	<%
		for(Visit visit : labWaitingList){
	%>
	<tr onclick="submitForm('investigationWaitList','/hms/hms/lab?method=showInvestigationRequisitionJsp&visitId=<%=visit.getId() %>&hinId=<%=visit.getHin().getId() %>');">
	<td><%=HMSUtil.convertDateToStringWithoutTime(visit.getVisitDate()) %></td>
	<td><%=visit.getHin().getServiceNo()!=null?visit.getHin().getServiceNo():"" %></td>
	<%
	String middleName = "";
	String lastName = "";
	if(visit.getHin().getPMiddleName() != null){
		middleName = visit.getHin().getPMiddleName();
	}
	if(visit.getHin().getPLastName() != null){
		lastName = visit.getHin().getPLastName();
	}
	
	%>
	<td><%=visit.getHin().getPFirstName()+" "+middleName+" "+lastName %></td>
	<td><%=visit.getHin().getRelation().getRelationName() %></td>
	<td><%=visit.getHin().getRank()!=null?visit.getHin().getRank().getRankName():"" %></td>
	<%
	String sMiddleName = "";
	String sLastName = "";
	
		if(visit.getHin().getSMiddleName() != null){
			sMiddleName = visit.getHin().getSMiddleName();
		}
		if(visit.getHin().getSLastName() != null){
			sLastName = visit.getHin().getSLastName();
		}
	%>
	<td><%=(visit.getHin().getSFirstName()!=null?visit.getHin().getSFirstName():"")+" "+sMiddleName+" "+sLastName %></td>
	<td><%=visit.getHin().getAge() %></td>
	
	</tr>
	
	<%} %>
	</table>
</div>
<%}
if(otherDgWaitList.size() > 0){
	%>
	<div id="reg">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<th scope="col">Date</th>
			<th scope="col">Service No.</th>
			<th scope="col">Patient Name</th>
			<th scope="col">Relation</th>
			<th scope="col">Rank</th>
			<th scope="col">Name</th>
			<th scope="col">Age</th>
		</tr>
		<%
			for(DgOrderhd dgOrderhd : otherDgWaitList){
		%>
		<tr onclick="submitForm('investigationWaitList','/hms/hms/lab?method=showInvestigationRequisitionJsp&visitId=<%=dgOrderhd.getVisit().getId() %>&hinId=<%=dgOrderhd.getHin().getId() %>&dgOrderhdId=<%=dgOrderhd.getId() %>&patientInvId=<%=dgOrderhd.getInvestigationRequestionNo().getId() %>');">
		<td><%=HMSUtil.convertDateToStringWithoutTime(dgOrderhd.getOrderDate()) %></td>
		<td><%=dgOrderhd.getHin().getServiceNo()!=null?dgOrderhd.getHin().getServiceNo():"" %></td>
		<%
		String middleName = "";
		String lastName = "";
		if(dgOrderhd.getHin().getPMiddleName() != null){
			middleName = dgOrderhd.getHin().getPMiddleName();
		}
		if(dgOrderhd.getHin().getPLastName() != null){
			lastName = dgOrderhd.getHin().getPLastName();
		}
		
		%>
		<td><%=dgOrderhd.getHin().getPFirstName()+" "+middleName+" "+lastName %></td>
		<td><%=dgOrderhd.getHin().getRelation().getRelationName() %></td>
		<td><%=dgOrderhd.getHin().getRank()!=null?dgOrderhd.getHin().getRank().getRankName():"" %></td>
		<%
		String sMiddleName = "";
		String sLastName = "";
		
			if(dgOrderhd.getHin().getSMiddleName() != null){
				sMiddleName = dgOrderhd.getHin().getSMiddleName();
			}
			if(dgOrderhd.getHin().getSLastName() != null){
				sLastName = dgOrderhd.getHin().getSLastName();
			}
		%>
		<td><%=(dgOrderhd.getHin().getSFirstName()!=null?dgOrderhd.getHin().getSFirstName():"")+" "+sMiddleName+" "+sLastName %></td>
		<td><%=dgOrderhd.getHin().getAge() %></td>
		
		</tr>
		
		<%} %>
		</table>
	</div>
	<%}
	if(labWaitingList.size() == 0 && otherDgWaitList.size() == 0){ %>
<h4>No Record Found</h4>
<%} %>
</form>
