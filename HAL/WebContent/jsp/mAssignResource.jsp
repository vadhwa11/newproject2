<%-- <%@page import="jkt.hms.masters.business.MasInstituteDepartment"%> --%>
<%@page import="jkt.hms.masters.business.MasPriorityCodes"%>
<%@page import="jkt.hms.masters.business.HesEquipmentAmcDetailsEntry"%>
<%@page import="jkt.hms.masters.business.HesEquipmentMaster"%>
<%@page import="jkt.hms.masters.business.MmServiceRequest"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.*"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<%
 	Map<String, Object> map=new HashMap<String, Object>();
    List<MasDepartment> masDepartments=new ArrayList<MasDepartment>();
    List<MmServiceRequest> mmServiceRequests=new ArrayList<MmServiceRequest>();
    List<HesEquipmentMaster> hesEquipmentMaster=new ArrayList<HesEquipmentMaster>();
	List<HesEquipmentAmcDetailsEntry> hesEquipmentAmcDetailsEntry=new ArrayList<HesEquipmentAmcDetailsEntry>();
	List<MasPriorityCodes> masPriorityCodesList=new ArrayList<MasPriorityCodes>();
/* 	List<MasInstituteDepartment> masInstituteDepartments=new ArrayList<MasInstituteDepartment>(); */

	if(request.getAttribute("map")!=null){
		map=(Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("masDepartment")!=null){
		masDepartments=(List<MasDepartment>)map.get("masDepartment");
	}
	if(map.get("mmServiceRequests")!=null){
		mmServiceRequests=(List<MmServiceRequest>)map.get("mmServiceRequests");
	}
	if(map.get("hesEquipmentMaster")!=null){
		hesEquipmentMaster=(List<HesEquipmentMaster>)map.get("hesEquipmentMaster");
	}
	if(map.get("hesEquipmentAmcDetailsEntry")!=null){
		hesEquipmentAmcDetailsEntry=(List<HesEquipmentAmcDetailsEntry>)map.get("hesEquipmentAmcDetailsEntry");
	}
	if(map.get("masPriorityCodes")!=null){
		masPriorityCodesList=(List<MasPriorityCodes>)map.get("masPriorityCodes");
	}
	/* if(map.get("masInstituteDepartments")!=null){
		masInstituteDepartments=(List<MasInstituteDepartment>)map.get("masInstituteDepartments");
	} */
	String userName = "";
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");  
		String currentTime = (String)utilMap.get("currentTime");
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
%>
<div class="titleBg">
<h2>Assign Resource</h2>
</div>
<div class="clear"></div>
<h4>Request Details</h4>
<form name="mAssignResorce"  method="post">
<%
String statusCode="";
for(MmServiceRequest mmServiceRequest:mmServiceRequests){ 
	statusCode=mmServiceRequest.getRequestStatus().getStatusCode();
	
%>
<div class="Block">

	<%@include file="mEquipmentDetail.jsp" %>
<label>Requested By</label>
	<label class="value"><%=mmServiceRequest.getLastChgBy().getEmployee().getFirstName()%></label>
	<label>Requested From</label>
	<label class="value"><%=mmServiceRequest.getEquipment().getDepartment().getDepartmentName()%></label>
	<label>Approved By</label>
	<label class="value"><%if(mmServiceRequest.getApprovedBy()!=null){%><%=mmServiceRequest.getApprovedBy().getEmployee().getFirstName()%><%} %></label>
	<label>Status</label>
	<label class="value"><%=mmServiceRequest.getRequestStatus().getStatusName() %></label>
		<div class="clear"></div>
		
	<%if(mmServiceRequest.getRequestStatus().getId()==16){ %>
	<label>Transfer Detail </label>
	<label class="value"> <%=mmServiceRequest.getTransferDetail() %></label>
	<%} %>
	
	<label>Request No</label>
	<label class="value"><%=mmServiceRequest.getServiceRequestNo() %></label>
	<label>Description</label>
	<input type="text" name="desciption" value="<%=mmServiceRequest.getDescription()%>" readonly="readonly"  size="920px"/>
	<div class="clear"></div>
	
	<label><a href="/hms/hms/fm?method=showEquipmentHistory&eqId=<%=mmServiceRequest.getEquipment().getId()%>">History</a></label>
	<%-- <label><a href="/hms/hms/fm?method=showEquipmentDashBoard&eqId=<%=mmServiceRequest.getEquipment().getId()%>">DashBoard</a></label> --%>
	
		
	
</div>
<input type="hidden" name="RequestNo" readonly="readonly" value="<%=mmServiceRequest.getId()%>"/>
<%} %>
<h4>Assign To</h4>
<div class="Block">
		<label><span>* </span>Service Department</label>
		<select name="department" validate="Department,string,yes" onchange="if(this.value!=''){submitProtoAjaxWithDivNameToShowStatus('mAssignResorce','/hms/hms/fm?method=getResourceList','mResource');}else{var x = document.getElementById('Resource');for(i=1;i<x.options.length;){x.options[i] = null;}}"><option value="">Select</option>
		<%for(MasDepartment masDepartment:masDepartments){ %>
		<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
		<%} %>
		</select>
	<label><span>* </span> Resource</label>
	<div id="mResource">
	<select name="Resource" validate="Resource,string,yes"><option value="">Select</option>
	</select>
	</div>
	<%if("RAS".equalsIgnoreCase(statusCode)){%> 
		<label>Priority</label> 
		<select name="priorityId">
		<option value="">Select</option>
		<%for(MasPriorityCodes masPriorityCodes:masPriorityCodesList){%>
			<option value="<%=masPriorityCodes.getId()%>"><%=masPriorityCodes.getCodesName()%></option>
		<%}%>
		</select> 
		<div class="clear"></div> 
	<%} 
	%> 
	<label>Remarks</label>
	<textarea rows="8" name="ResourceRemark" maxlength="200" cols="20"></textarea>
	<div class="clear"></div>
	<div class="clear"></div>
</div>

<input type="button" class="button" onclick="submitForm('mAssignResorce','/hms/hms/fm?method=submitAssignResorce');"  value="Submit" />
<input type="reset"  class="button" value="Reset" /> 
<input type="button" onclick="javascript: history.go(-1);" class="button" value="Back" /> 
 <div class="clear"></div>
 <div class="clear"></div>
	<div class="bottom">
		<label>Changed By:</label>
		<label class="value"><%=userName%></label>
		<label>Changed Date:</label>
		<label class="value"><%=currentDate%></label>
		<label>Changed Time:</label>
		<label class="value"><%=currentTime%></label>
	</div>
<!--Block Two Ends-->
	<div class="clear"></div>
	<div class="paddingTop15"></div>
	<div class="clear"></div>
	<!--Bottom labels starts-->
	<div class="bottom">
	<input type="hidden" name="lastChgBy" value="<%=userName%>" />
	<input type="hidden" name="lastChgDate" value="<%=currentDate%>" /> 
	<input type="hidden" name="lastChgTime" value="<%=currentTime%>" /> 
	</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	
</form>