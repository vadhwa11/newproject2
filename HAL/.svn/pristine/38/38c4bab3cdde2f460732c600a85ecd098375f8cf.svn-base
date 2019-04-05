
<%@page import="jkt.hms.masters.business.HesEquipmentAmcDetailsEntry"%>
<%@page import="jkt.hms.masters.business.HesEquipmentMaster"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MmMasRequestStatus"%>
<%@page import="jkt.hms.masters.business.MmServiceRequest"%>
<%@page import="java.util.*"%>
<script>
function forword(val){
	if(val!=null){
		if(val==""){
			document.getElementById('forwardToDis').style.display="none";
			document.getElementById('RemarkDis').style.display="none";
			document.getElementById('forwardTo').setAttribute("validate","forwardTo,string,no");
		}
		if(val=="AP"){
			document.getElementById('forwardToDis').style.display="";
			document.getElementById('RemarkDis').style.display="";
			var aa=document.getElementById('RemarkDis').innerHTML;
			var str=aa.replace('<span>* </span>','');
			document.getElementById('RemarkDis').innerHTML=str;
			document.getElementById('forwardTo').setAttribute("validate","forwardTo,string,yes");
			document.getElementById('Remark').setAttribute("validate","Remark,string,no");
		}
		if(val=="RJ" || val=="CND"){
			document.getElementById('forwardTo').setAttribute("validate","forwardTo,string,no");
			document.getElementById('forwardToDis').style.display="";
			document.getElementById('RemarkDis').style.display="";
			var aa=document.getElementById('RemarkDis').innerHTML;
			document.getElementById('forwardToDis').style.display="none";
			if(aa.indexOf('<span>* </span>')!=9){
				document.getElementById('RemarkDis').innerHTML=aa.replace('<label>','<label><span>* </span>');
			}
			document.getElementById('Remark').setAttribute("validate","Remark,string,yes");
		}
	}
	
}
</script>

<%
	String userName = "";
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	Map<String, Object> map=new HashMap<String, Object>();
	List<MmServiceRequest> requestDetail=new ArrayList<MmServiceRequest>();
	List<MmMasRequestStatus> status1=new ArrayList<MmMasRequestStatus>();
	List<MasDepartment> departmentList=new ArrayList<MasDepartment>();

	List<HesEquipmentMaster> hesEquipmentMaster=new ArrayList<HesEquipmentMaster>();
	List<HesEquipmentAmcDetailsEntry> hesEquipmentAmcDetailsEntry=new ArrayList<HesEquipmentAmcDetailsEntry>();
	if(request.getAttribute("map")!=null){
		map=(Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("serviceDetail")!=null){
		requestDetail=(List<MmServiceRequest>)map.get("serviceDetail");
	}
	if(map.get("hesEquipmentMaster")!=null){
		hesEquipmentMaster=(List<HesEquipmentMaster>)map.get("hesEquipmentMaster");
	}
	if(map.get("status")!=null){
		status1=(List<MmMasRequestStatus>)map.get("status");
	}
	if(map.get("departmentList")!=null){
		departmentList=(List<MasDepartment>)map.get("departmentList");
	}
	if(map.get("hesEquipmentAmcDetailsEntry")!=null){
		hesEquipmentAmcDetailsEntry=(List<HesEquipmentAmcDetailsEntry>)map.get("hesEquipmentAmcDetailsEntry");
	}
%>

<div class="titleBg">
<h2>Service Request</h2>
</div>
<div class="clear"></div>
<h4>Request Details</h4>
<form name="mServiceRequest"  method="post" >
<%for(MmServiceRequest mmServiceRequest:requestDetail){ %>
<div class="Block">
	<%@include file="mEquipmentDetail.jsp" %>
	<div class="clear"></div>
	<label>Request Type</label>
	<label class="value"><%= mmServiceRequest.getRequestType()%></label>
	<label>Priority</label>
	<label class="value"><%= mmServiceRequest.getPriority().getCodesName()%></label>
	<label>Required By Date</label>
	<label class="value"><%= HMSUtil.changeDateToddMMyyyy(mmServiceRequest.getRequiredDate())%></label>
	<div class="clear"></div>
	<label>Requested By</label>
	<label class="value"><%= mmServiceRequest.getLastChgBy().getEmployee().getFirstName()%></label>
	<label>Requested From</label>
	<label class="value"><%= mmServiceRequest.getEquipment().getDepartment().getDepartmentName()%></label>
	<label>Description</label>
	<label class="value"><%= mmServiceRequest.getDescription()%></label>
	<div class="clear"></div>
	<label>Request No</label>
	<label class="value"><%= mmServiceRequest.getServiceRequestNo()%></label>
	<label><a href="/hms/hms/fm?method=showEquipmentHistory&eqId=<%=mmServiceRequest.getEquipment().getId()%>">History</a></label>
	<%-- <label><a href="/hms/hms/fm?method=showEquipmentDashBoard&eqId=<%=mmServiceRequest.getEquipment().getId()%>">DashBoard</a></label> --%>
	
	<input type="hidden" name="requestId" value="<%=mmServiceRequest.getId() %>" /> 
</div>
<%}%>
<h4>Service Details</h4>
<div class="Block">
	<label><span>* </span> Status</label>
	<select name="Status" validate="Status,string,yes" onchange="forword(this.value)">
	<option value="">Select</option>
	<%for(MmMasRequestStatus mmMasRequestStatus:status1){ %>
	<option value="<%= mmMasRequestStatus.getStatusCode()%>"><%=mmMasRequestStatus.getStatusName() %></option>
	<%} %>
	</select>
	
		<!-- <div  id="RemarkDis"> -->
	<label><span>* </span>Remark</label>
	<textarea id="Remark" name="Remark" class="large"  validate="Remarks,string,yes" MAXLENGTH="200"></textarea>
	<!-- </div> -->
	<div class="clear"></div>
	<div id="forwardToDis" style="display: none;">
	<label><span>* </span> Forward</label>
	<select name="forwardTo"  id="forwardTo" validate="forwardTo,string,no"><option value="">Select</option>
	<%for(MasDepartment department:departmentList){ %>
	<option value="<%= department.getId()%>"><%= department.getDepartmentName() %></option>
	<%} %>
	</select>
	</div>

	<div class="clear"></div>
	
</div>
<div class="clear"></div>
<input type="button" class="button" onclick="submitForm('mServiceRequest','/hms/hms/fm?method=submitServiceRequest');"  value="Submit" />
<input type="button" onclick="javascript: history.go(-1);" class="button" value="Back" /> 
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
<script>
  function serviceRequest(){
	  submitForm('mServiceRequest','/hms/hms/fm?method=submitServiceRequest');
  }
</script>
