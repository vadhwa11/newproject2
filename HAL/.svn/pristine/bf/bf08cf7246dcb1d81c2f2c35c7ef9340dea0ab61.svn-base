<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasManufacturer"%>
<%@page import="jkt.hms.masters.business.HesEquipmentAmcDetailsEntry"%>
<%@page import="jkt.hms.masters.business.MmServiceRequest"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.masters.business.MasPriorityCodes"%>
<%@page import="jkt.hms.masters.business.HesEquipmentAssessories"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.HesEquipmentMaster"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.util.RequestConstants"%>

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

	Map<String ,Object> map = new HashMap<String ,Object>();
	String entryNo = "";
	String userName = "";
	String el="";
	String requestTypeP="";
	String requestTypeC="";
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	List<HesEquipmentMaster> hesEquipmentMaster = new ArrayList<HesEquipmentMaster>();
	List<HesEquipmentAmcDetailsEntry> hesEquipmentAmcDetailsEntry = new ArrayList<HesEquipmentAmcDetailsEntry>();
	List<MasPriorityCodes> priority = new ArrayList<MasPriorityCodes>();
	List<MmServiceRequest> mmServiceRequests=new ArrayList<MmServiceRequest>();
	List<MasManufacturer> masManufacturerList=new ArrayList<MasManufacturer>();
	MmServiceRequest reRequest=new MmServiceRequest();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<HesEquipmentMaster> hesEquipmentList = new ArrayList<HesEquipmentMaster>();
	List<Users> userList = new ArrayList<Users>();
	
	
	String prty="";
	String manufacture="";
	if(request.getAttribute("map")!=null)
	{
		map = (Map<String ,Object>) request.getAttribute("map");
	}
	if (map.get("num")!=null)
		entryNo = (String)map.get("num").toString();
	if (map.get("departmentList")!= null){
			departmentList = (List<MasDepartment>)map.get("departmentList");
	}if (map.get("priority")!= null){
		priority = (List<MasPriorityCodes>)map.get("priority");
	}if (map.get("masServiceRequests") !=null){
		mmServiceRequests = (List<MmServiceRequest>)map.get("masServiceRequests");
	}
	if (map.get("hesEquipmentMaster")!= null){
		hesEquipmentMaster = (List<HesEquipmentMaster>)map.get("hesEquipmentMaster");
	}
	if (map.get("hesEquipmentAmcDetailsEntry")!= null){
		hesEquipmentAmcDetailsEntry = (List<HesEquipmentAmcDetailsEntry>)map.get("hesEquipmentAmcDetailsEntry");
	}
	if(map.get("reRequest")!=null){
		reRequest=(MmServiceRequest)map.get("reRequest");
	}
	if(map.get("masManufacturerList")!=null){
		masManufacturerList=(List<MasManufacturer>)map.get("masManufacturerList");
	}
	if(map.get("hesEquipmentMaster")!=null){
		hesEquipmentMaster=(List<HesEquipmentMaster>)map.get("hesEquipmentMaster");
	}
	
	if(map.get("userList")!=null){
		userList=(List<Users>)map.get("userList");
	}
	
	if(request.getParameter("eL")!=null){
		el=request.getParameter("eL");
	}
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");

	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
	}
	if(request.getParameter("requestType")!=null)
		requestTypeP="selected='selected'";
	for(MasPriorityCodes mp:priority){
		if(reRequest.getPriority()!=null){
			if(reRequest.getPriority().getId()==mp.getId()){
				prty+="<option value='"+mp.getCodesCode()+"' selected='selected' >"+mp.getCodesName()+"</option>";
			}else{
				prty+="<option value='"+mp.getCodesCode()+"' >"+mp.getCodesName()+"</option>";	
			}
		}else{
				prty+="<option value='"+mp.getCodesCode()+"' >"+mp.getCodesName()+"</option>";	
		}
	}
	
	if(hesEquipmentMaster.size() >0 && hesEquipmentMaster.get(0).getManufacturer()!=null)
		manufacture = "<option value='"+hesEquipmentMaster.get(0).getManufacturer().getId()+"' selected='selected' >"+hesEquipmentMaster.get(0).getManufacturer().getManufacturerName()+"</option>";
	else if(hesEquipmentMaster.size() >0)
	{
		for(MasManufacturer mm: masManufacturerList){
			manufacture +="<option value='"+mm.getId()+"' >"+mm.getManufacturerName()+"</option>";	
		}
	}
		
//	System.out.println(hesEquipmentMaster.size() +" " +hesEquipmentMaster.get(0).getManufacturer().getManufacturerName());
	Calendar requiredDate1=Calendar.getInstance();
	String requiredDate=date+"/"+month+"/"+year;
	String problemDescription="";
	if(reRequest.getRequiredDate()!=null)
		requiredDate1.setTime(reRequest.getRequiredDate());
		String d1=String.valueOf(requiredDate1.get(Calendar.DAY_OF_MONTH));
		String m1=String.valueOf(requiredDate1.get(Calendar.MONTH)+1);
		if(d1.length()<2){
			d1="0"+d1;
		}
		if(m1.length()<2){
			m1="0"+m1;
		}
		requiredDate=d1+"/"+m1+"/"+requiredDate1.get(Calendar.YEAR);
	if(reRequest.getDescription()!=null)
		problemDescription=reRequest.getDescription();
	if(reRequest.getRequestType()!=null){
		if(reRequest.getRequestType().equalsIgnoreCase("Preventive")){
			requestTypeP="selected='selected'";
		}else{
			requestTypeC="selected='selected'";
		}
	}
	
%>

<form name="mSelectEquipment"  method="post">
<div class="titleBg">
<h2>Create Service Request</h2>
</div>

<div class="clear"></div>

<h4>Equipment Details</h4>
<div class="Block">
	<%@include file="mEquipmentDetail.jsp" %>
<!-- 	<div class="clear"></div> -->
		<label><a href="/hms/hms/fm?method=showEquipmentHistory&eqId=<%=hesEquipmentMaster.get(0).getId()%>">History</a></label>
		<%-- <label><a href="/hms/hms/fm?method=showEquipmentDashBoard&eqId=<%=hesEquipmentMaster.get(0).getId()%>">DashBoard</a></label> --%>
</div>
<div class="clear"></div>
<h4>Request Details</h4>
<div class="clear"></div>
<div class="Block">
		<label><span>* </span>Request Type</label>
		<select name="RequestType" validate="RequestType,string,yes"  ><option  value="">Select</option><option value="Preventive Maintenance" <%=requestTypeP %>>Preventive Maintenance</option><option value="BreakDown" <%=requestTypeC %>>BreakDown</option>
		<option value="Fault Reporting" <%=requestTypeC %>>Fault Reporting</option><option value="Performance Tuning" <%=requestTypeC %>>Performance Tuning</option>
		</select>
		<label><span>* </span>Priority</label>
		<select name="Priority" validate="Priority,string,yes"><option value="">Select</option><%=prty %></select>
		<label><span>* </span>Required Date</label>
		<input id="requiredDate"  class="date" type="text" maxlength="10" validate="RequiredDate,string,yes" readonly="readonly" value="<%=requiredDate%>" name="requiredDate">
		<img width="16" height="16" border="0" onclick="javascript:setdate('',document.mSelectEquipment.requiredDate,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif" />
		<div class="clear"></div>
			<label><span>* </span>Manufacturer</label>
            <select name="manufacture" validate="Manufacture,string,yes">
            <option value="">Select</option><%=manufacture %></select>
            
            <label><span>* </span>Approve by</label>
            <select name="approval" validate="Approval,string,yes">
            <option value="">Select</option>
            <%for(Users user: userList)
            {  if(user.getFirstName()!=null){%>
            	
            	 <option value="<%=user.getId()%>"><%=user.getFirstName()%></option>
            <%}}%>
            	
            </select>
            <div class="clear"></div>
		<label><span>* </span>Problem Description</label>
		<textarea id="Remarks" validate="Remarks,string,yes" name="description" class="large" size="40" MAXLENGTH="200" ><%=problemDescription %></textarea>
		<div class="clear"></div>
	<!-- 	<input type="checkbox" name="sms" value="y" style="margin: 0" />
		<label>Do You want SMS Alert.</label>
		<input type="checkbox" name="mail" value="y" style="margin: 0" />
		<label>Do You want Mail Alert.</label> -->
</div>

	<div class="clear"></div>
		<input type="button" name="Submit" align="right" class="button" value="Submit" onclick="dataSubmit()" />
		<input type="Reset" class="button"   id="Reset"  value="Reset" />
		<input type="button" onclick="javascript: history.go(-1);" class="button" value="Back" /> 
<!-- 		<input type="button" name="Submit" align="right" class="button" value="SMS" onclick="" /> -->
<!-- 		<input type="button" name="Submit" align="right" class="button" value="Mail" onclick="" /> -->
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
	<input type="hidden" name="eL" id="eL" value="<%=el %>" />
	<input type="hidden" name="serviceRequestId" id="serviceRequestId" value="<%=request.getParameter("serviceRequestId") %>" />
	</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<script type="text/javascript">
function dataSubmit(){
	var flag=true;
	var serviceRequest=parseInt(<%=mmServiceRequests.size()%>);
	var msg="Open Request \n---------------------------\n\nRequest No   \t\t Request Date \t\t Request status \t\t Request Description \t\t\n";
	if(serviceRequest>0){
		<%for(MmServiceRequest sr:mmServiceRequests){%>
		msg+="<%=sr.getServiceRequestNo()%> \t <%=sr.getRequestDate()%>\t\t\t <%=sr.getRequestStatus().getStatusName()%> \t\t\t<%=sr.getDescription()%> \n";
		<%}%>
		msg+="\nDo You Want Create New Request?";
		flag=confirm(msg);
	}
	if(flag)
	submitForm('mSelectEquipment','fm?method=submitCreateServiceRequest');
}
</script>

