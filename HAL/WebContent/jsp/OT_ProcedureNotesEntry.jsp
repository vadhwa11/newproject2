<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.*"%>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />



<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>



<script type="text/javascript" language="javascript">
	<%
	
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String getDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(getDate.length()<2){
			getDate="0"+getDate;
		}
			
	%>
		serverdate = '<%=getDate+"/"+month+"/"+year%>'
	</script>
<%
	
	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}

	String userName = "";
	String yearlySerialNo="";
	String monthlySerialNo="";
	 List patientDetailList = new ArrayList();
	 List otList = new ArrayList();
	 List<OtProcedureNotesEntryDetail> otDetailList = new ArrayList<OtProcedureNotesEntryDetail>();
	 List<MasAnesthesia> anaesthesiaList = new ArrayList<MasAnesthesia>();
	 List<OtPreAnesthesiaDetails> otPreAnaesthesiaDetailsList=new ArrayList<OtPreAnesthesiaDetails>();
	 List<OtBookSurgeon>otBookSurgeaonList=new ArrayList<OtBookSurgeon>();
	 
	 if(map.get("otPreAnaesthesiaDetailsList")!=null)
		{
		 otPreAnaesthesiaDetailsList=(List)map.get("otPreAnaesthesiaDetailsList");
		}
	 if(map.get("monthSerialNo")!=null)
	{
		monthlySerialNo=(String)map.get("monthSerialNo");
	}
	if(map.get("yearlySerialNo")!=null)
	{
		yearlySerialNo=(String)map.get("yearlySerialNo");
	}		
	if(map.get("patientDetailList") != null){
		
		patientDetailList=(List)map.get("patientDetailList");
		
	}
	if(map.get("otBookSurgeaonList") != null){
		
		otBookSurgeaonList=(List)map.get("otBookSurgeaonList");
		
	}
	
	if(map.get("otList") != null){
		
		otList=(List)map.get("otList");
	}
	if(map.get("otDetailList") != null){
		
		otDetailList=(List)map.get("otDetailList");
	}
	if(map.get("anaesthesiaList") != null){
			
		anaesthesiaList=(List)map.get("anaesthesiaList");
			
		}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	
	int hospitalId=0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	int prescribedDepartmentId=0;
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	System.out.println("patientDetailList2");
	if(patientDetailList!=null && patientDetailList.size()>0)
	{	OtBooking otBooking=(OtBooking)patientDetailList.get(0);
		
		String patientName="";
		if(otBooking.getHin().getPFirstName()!= null){
			patientName=otBooking.getHin().getPFirstName();
		}
		if(otBooking.getHin().getPMiddleName()!= null){
			patientName=patientName+" "+otBooking.getHin().getPMiddleName();
		}
		if(otBooking.getHin().getPLastName()!= null){
			patientName=patientName+" "+otBooking.getHin().getPLastName();
		}
		String servicePersonName="";
		if(otBooking.getHin().getSFirstName()!= null){
			servicePersonName=otBooking.getHin().getSFirstName();
		}
		if(otBooking.getHin().getSMiddleName()!= null){
			servicePersonName=servicePersonName+" "+otBooking.getHin().getSMiddleName();
		}
		if(otBooking.getHin().getSLastName()!= null){
			servicePersonName=servicePersonName+" "+otBooking.getHin().getSLastName();
		}
		System.out.println("patientDetailList3");
%>

<!--main content placeholder starts here-->

<div id="contentHolder">
<form name="otBooking" method="post" action="">
<h6>Post OP Notes (Surgery)</h6>
<div class="Clear"></div>
<div class="header"><label>Yearly Serial No. </label> <label
	class="value"><%=yearlySerialNo %></label> <input type="hidden"
	id="yearlySerialNo" name="yearlySerialNo" value="<%=yearlySerialNo %>" />
<label>Monthly Serial No. </label> <label class="value"><%=monthlySerialNo%></label>
<input type="hidden" id="monthlySerialNo" name="monthlySerialNo"
	value="<%=monthlySerialNo %>" /></div>
<div class="Clear"></div>
<!--Block One Starts-->

<div class="blockTitle">Patient Particulars</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>
<label class="medium">Service Type</label> <%if(otBooking.getHin().getServiceType()!= null){ %>
<label class="valuemedium"><%=otBooking.getHin().getServiceType().getServiceTypeName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Service No.</label> <%if(otBooking.getHin().getServiceNo()!= null){ %>
<label class="valuemedium"><%=otBooking.getHin().getServiceNo() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium"> Serv. Status </label> <%if(otBooking.getHin().getServiceStatus()!= null){ %>
<label class="valuemedium"><%=otBooking.getHin().getServiceStatus().getServiceStatusName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Name</label> <%if(servicePersonName != null){ %> <label
	class="valuemedium" style="width: auto;"><%=servicePersonName %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %>
<div class="Clear"></div>

<label class="medium">Relation</label> <%if(otBooking.getHin().getRelation() != null){ %>
<label class="valuemedium"><%=otBooking.getHin().getRelation().getRelationName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Rank</label> <%if(otBooking.getHin().getRank()!= null){ %>
<label class="valuemedium"><%=otBooking.getHin().getRank().getRankName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Unit</label> <%if(otBooking.getHin().getUnit()!= null){ %>
<label class="valuemedium"><%=otBooking.getHin().getUnit().getUnitName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Unit Address</label> <% if(otBooking.getHin().getUnit()!= null){%>
<label class="valuemedium"><%=otBooking.getHin().getUnit().getUnitAddress() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %>
<div class="division"></div>
<div class="blockTitle">Patient Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<label class="medium">HIN No.</label> <%if(otBooking.getHin().getHinNo()!= null){ %>
<label class="valuemedium"><%=otBooking.getHin().getHinNo() %></label> <input
	type="hidden" name="hinId" id="hinId"
	value="<%=otBooking.getHin().getId()%>" /> <%}else{ %> <label
	class="valuemedium">-</label> <%} %> <label class="medium">Patient
Name. </label> <%if(patientName!= null){ %> <label class="valuemedium"
	style="width: auto;"><%=patientName %> </label> <%}else{ %> <label
	class="valuemedium">- </label> <%} %> <label class="medium">Age</label> <%if(otBooking.getHin().getAge()!= null){ %>
<label class="valuemedium"><%=otBooking.getHin().getAge() %></label> <%}else{ %>
<label class="valuemedium">-</label> <%} %> <label class="medium">Patient
Status </label> <%if(otBooking.getHin().getPatientStatus() != null){ %> <label
	class="valuemedium"><%=otBooking.getHin().getPatientStatus() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %>
<div class="Clear"></div>

<label class="medium">Reg.Date </label> <%if(otBooking.getHin().getRegDate()!= null){ %>
<label class="valuemedium"><%= HMSUtil.convertDateToStringWithoutTime(otBooking.getHin().getRegDate()) %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Order No: </label> <%if(otBooking.getOrderNo() !=0){ %> <label
	class="valuemedium"><%=otBooking.getOrderNo() %></label> <input
	type="hidden" name="orderNo" id="orderNo"
	value="<%=otBooking.getOrderNo()%>" /> <%}else{ %> <label
	class="valuemedium">-</label> <%}%>
<div class="Clear"></div>
<input type="hidden" name="otBookingId" id="otBookingId"
	value="<%=otBooking.getId()%>" /></div>
<label>Date:</label> <input type="text" id="date" name="<%=DATE %>"
	value="<%=HMSUtil.convertDateToStringWithoutTime(otBooking.getSurgeryDate())%>"
	MAXLENGTH="30" readonly="readonly" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onchange="isApptGrCurrentDate1();"
	onClick="setdate('<%=date %>',document.otBooking.<%=DATE%>,event);" />
<div class="division"></div>

<div class="Clear"></div>
<label class="common">Surgeons Name</label> <input name="Add"
	type="button" class="cmnButton" value="Add"
	onclick="addRowForSurgery()" /> <input name="Delete" type="button"
	class="cmnButton" value="Delete" onclick="removeRow()" />
<div class="Clear"></div>
<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="investigationGrid">
	<tr>
		<th scope="col">Sr. No.</th>
		<th scope="col">Surgeon Name</th>
		<th scope="col"></th>
	</tr>
	<%if(otBookSurgeaonList!=null && otBookSurgeaonList.size()>0){
	  int count=1;
	  for(OtBookSurgeon otBookSurgeon:otBookSurgeaonList)
	  {	  
		   	 String fullName = otBookSurgeon.getEmployee().getFirstName();
	    	 if(otBookSurgeon.getEmployee().getMiddleName() != null){
	    		 fullName = fullName + " " + otBookSurgeon.getEmployee().getMiddleName();
	    	 }
	    	 if(otBookSurgeon.getEmployee().getLastName() != null){
	    		 fullName = fullName + " " + otBookSurgeon.getEmployee().getLastName();
	    	 }
	  
	  
	  %>

	<tr>
		<td><input type="text" name="textfield" size=2 value="<%=count%>" /></td>
		<td id="nomenclaturetd1"><input type="text"
			name="empName<%=count%>" id="empName<%=count %>" size=43
			value="<%=fullName%>[<%=otBookSurgeon.getEmployee().getId()%>]" />

		<div id="ac2update2"
			style="display: none; font-weight: normal; border: 1px solid black; padding-right: 10px; background-color: white;"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('empName1','ac2update2','ot?method=getEmpNameForAutoComplete',{parameters:'requiredField=empName<%=count%>'});
			</script> </script></td>

		<input type="hidden" value="<%=count %>" name="hiddenValue"
			id="hiddenValue" />

	</tr>
	<%  count++;}
  } %>
	<tr>
		<%int inc=otBookSurgeaonList.size()+1; %>
		<td><input type="text" name="textfield" size=2 value="<%=inc%>" /></td>
		<td id="nomenclaturetd1"><input type="text"
			name="empName<%=inc%>" id="empName<%=inc%>" size=43 value="" />
		<div id="ac2update2"
			style="display: none; font-weight: normal; height: 150px; overflow: scroll; border: 1px solid black; padding-right: 10px; background-color: white;"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('empName<%=inc%>','ac2update2','ot?method=getEmpNameForAutoComplete',{parameters:'requiredField=empName<%=inc%>'});
			</script></td>

		<input type="hidden" value="<%=inc%>" name="hiddenValue"
			id="hiddenValue" />

	</tr>
</table>

<label>Surgery Time:</label> <label>From:</label> <input type="text"
	name="surgeryFromTime" id="surgeryFromTime" maxlength="5"
	style="padding-right: 0px; margin-right: 0px;"
	<% if(otBooking.getSurgeryTime() != null){ %>
	value="<%=otBooking.getSurgeryTime() %>" <% }else{ %> value="" <% } %>
	onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);"
	onblur="IsValidTimeWithBlankCheck(this.value,surgeryFromTime)" /> <label
	style="padding-left: 0px; margin-left: 4px; float: left; text-align: left;">(HH:MM)</label>

<label>To:</label> <input type="text" name="surgeryToTime"
	id="surgeryToTime" value=""
	onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);"
	maxlength="5"
	onblur="IsValidTimeWithBlankCheck(this.value,surgeryFromTime)" /> <label
	style="padding-left: 0px; margin-left: 4px; float: left; text-align: left;">(HH:MM)</label>
<div class="Clear"></div>
<label>Anaesthesia:</label> <select name="anaesthesiaId"
	id="anaesthesiaId">
	<option value="0">Select</option>
	<option value="GA">GA</option>
	<option value="SA">SA</option>
	<option value="EA">EA</option>
	<option value="LA">LA</option>
	<option value="RA">RA</option>
	<option value="DA">DA</option>
</select> <%
	if(patientDetailList.size() > 0 && otBooking.getOtPreAnesthesiaDetails()!=null){
		
	 
	  
	%> <script type="text/javascript">
		document.getElementById('anaesthesiaId').value = '<%=otBooking.getOtPreAnesthesiaDetails().getAnesthticTechnique()%>';
	</script> <% } %>
</div>
<div class="Clear"></div>
<div class="blockFrame"><label>Pre OP Orders</label> <textarea
	name="preOpOrders" id="remarks" cols="0" maxlength="400"
	onkeyup="return ismaxlength(this)" rows="0" class="large"></textarea></div>

<div class="division"></div>
<div class="Clear"></div>
<div class="blockFrame"><label>Finding & Procedure</label> <textarea
	name="findings" cols="0" rows="0" maxlength="400"
	onkeyup="return ismaxlength(this)" class="large" id="findings"></textarea>

</div>

<div class="division"></div>
<div class="Clear"></div>
<div class="blockFrame"><label>Post OP Orders</label> <textarea
	name="postOpOrders" cols="0" rows="0" maxlength="400"
	onkeyup="return ismaxlength(this)" class="large" id="postOpOrders"></textarea>

</div>
<%}
	if(otList!=null && otList.size()>0)
	{
		OtProcedureNotesEntryHeader otProcedureNotesEntryHeader=(OtProcedureNotesEntryHeader)otList.get(0);
	
	String patientName="";
	if(otProcedureNotesEntryHeader.getHin().getPFirstName()!= null){
		patientName=otProcedureNotesEntryHeader.getHin().getPFirstName();
	}
	if(otProcedureNotesEntryHeader.getHin().getPMiddleName()!= null){
		patientName=patientName+" "+otProcedureNotesEntryHeader.getHin().getPMiddleName();
	}
	if(otProcedureNotesEntryHeader.getHin().getPLastName()!= null){
		patientName=patientName+" "+otProcedureNotesEntryHeader.getHin().getPLastName();
	}
	String servicePersonName="";
	if(otProcedureNotesEntryHeader.getHin().getSFirstName()!= null){
		servicePersonName=otProcedureNotesEntryHeader.getHin().getSFirstName();
	}
	if(otProcedureNotesEntryHeader.getHin().getSMiddleName()!= null){
		servicePersonName=servicePersonName+" "+otProcedureNotesEntryHeader.getHin().getSMiddleName();
	}
	if(otProcedureNotesEntryHeader.getHin().getSLastName()!= null){
		servicePersonName=servicePersonName+" "+otProcedureNotesEntryHeader.getHin().getSLastName();
	}
	System.out.println("patientDetailList3");
%> <!--main content placeholder starts here-->

<div id="contentHolder">
<form name="otBooking" method="post" action="">
<h6>Post OP Notes (Surgery) Entry</h6>
<div class="Clear"></div>
<div class="header"><label>Yearly Serial No. </label> <label
	class="value"><%=otProcedureNotesEntryHeader.getYearlySerialNo()%></label>
<input type="hidden" id="yearlySerialNo" name="yearlySerialNo"
	value="<%=otProcedureNotesEntryHeader.getYearlySerialNo() %>" /> <label>Monthly
Serial No. </label> <label class="value"><%=otProcedureNotesEntryHeader.getMonthlySerialNo()%></label>
<input type="hidden" id="monthlySerialNo" name="monthlySerialNo"
	value="<%=otProcedureNotesEntryHeader.getMonthlySerialNo()%>" /></div>
<div class="Clear"></div>
<!--Block One Starts-->

<div class="blockTitle">Patient Particulars</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>
<label class="medium">Service Type</label> <%if(otProcedureNotesEntryHeader.getHin().getServiceType()!= null){ %>
<label class="valuemedium"><%=otProcedureNotesEntryHeader.getHin().getServiceType().getServiceTypeName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Service No.</label> <%if(otProcedureNotesEntryHeader.getHin().getServiceNo()!= null){ %>
<label class="valuemedium"><%=otProcedureNotesEntryHeader.getHin().getServiceNo() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium"> Serv. Status </label> <%if(otProcedureNotesEntryHeader.getHin().getServiceStatus()!= null){ %>
<label class="valuemedium"><%=otProcedureNotesEntryHeader.getHin().getServiceStatus().getServiceStatusName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Name</label> <%if(servicePersonName != null){ %> <label
	class="valuemedium"><%=servicePersonName %></label> <%}else{ %> <label
	class="valuemedium">-</label> <%} %>
<div class="Clear"></div>

<label class="medium">Relation</label> <%if(otProcedureNotesEntryHeader.getHin().getRelation() != null){ %>
<label class="valuemedium"><%=otProcedureNotesEntryHeader.getHin().getRelation().getRelationName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Rank</label> <%if(otProcedureNotesEntryHeader.getHin().getRank()!= null){ %>
<label class="valuemedium"><%=otProcedureNotesEntryHeader.getHin().getRank().getRankName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Unit</label> <%if(otProcedureNotesEntryHeader.getHin().getUnit()!= null){ %>
<label class="valuemedium"><%=otProcedureNotesEntryHeader.getHin().getUnit().getUnitName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Unit Address</label> <% if(otProcedureNotesEntryHeader.getHin().getUnit()!= null){%>
<label class="medium"><%=otProcedureNotesEntryHeader.getHin().getUnit().getUnitAddress() %></label>
<%}else{ %> <label class="medium">-</label> <%} %>
<div class="division"></div>
<div class="blockTitle">Patient Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<label class="medium">HIN No.</label> <%if(otProcedureNotesEntryHeader.getHin().getHinNo()!= null){ %>
<label class="valuemedium"><%=otProcedureNotesEntryHeader.getHin().getHinNo() %></label>
<input type="hidden" name="hinId" id="hinId"
	value="<%=otProcedureNotesEntryHeader.getHin().getId()%>" /> <%}else{ %>
<label class="valuemedium">-</label> <%} %> <label class="medium">Patient
Name. </label> <%if(patientName!= null){ %> <label class="valuemedium"
	style="width: auto;"><%=patientName %> </label> <%}else{ %> <label
	class="valuemedium">- </label> <%} %> <label class="medium">Age</label> <%if(otProcedureNotesEntryHeader.getHin().getAge()!= null){ %>
<label class="valuemedium"><%=otProcedureNotesEntryHeader.getHin().getAge() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Patient Status </label> <%if(otProcedureNotesEntryHeader.getHin().getPatientStatus() != null){ %>
<label class="valuemedium"><%=otProcedureNotesEntryHeader.getHin().getPatientStatus() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %>
<div class="Clear"></div>

<label class="medium">Reg.Date </label> <%if(otProcedureNotesEntryHeader.getHin().getRegDate()!= null){ %>
<label class="valuemedium"><%=otProcedureNotesEntryHeader.getHin().getRegDate() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} 



%>

<div class="Clear"></div>
</div>
<label>Date:</label> <input type="text" id="date" name="<%=DATE %>"
	value="<%=HMSUtil.convertDateToStringWithoutTime(otProcedureNotesEntryHeader.getDate())%>"
	MAXLENGTH="30" readonly="readonly" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onchange="isApptGrCurrentDate1();"
	onClick="setdate('<%=otProcedureNotesEntryHeader.getDate()%>',document.otBooking.<%=DATE%>,event);" />
<div class="division"></div>

<div class="Clear"></div>
<label class="common">Surgeons Name</label> <input name="Add"
	type="button" class="cmnButton" value="Add"
	onclick="addRowForSurgery()" /> <input name="Delete" type="button"
	class="cmnButton" value="Delete" onclick="removeRow()" />
<div class="Clear"></div>
<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="investigationGrid">
	<tr>
		<th scope="col">Sr. No.</th>
		<th scope="col">Surgeon Name</th>
		<th scope="col"></th>
	</tr>
	<%int inc=1;
     for(OtProcedureNotesEntryDetail otProcedureNotesEntryDetail:otDetailList){
    	 String fullName = otProcedureNotesEntryDetail.getEmployee().getFirstName();
    	 if(otProcedureNotesEntryDetail.getEmployee().getMiddleName() != null){
    		 fullName = fullName + " " + otProcedureNotesEntryDetail.getEmployee().getMiddleName();
    	 }
    	 if(otProcedureNotesEntryDetail.getEmployee().getLastName() != null){
    		 fullName = fullName + " " + otProcedureNotesEntryDetail.getEmployee().getLastName();
    	 }
    	 
     %>
	<tr>
		<td><input type="text" name="textfield" size=2 value="<%=inc%>" /></td>
		<td id="nomenclaturetd<%=inc%>"><input type="text"
			name="empName<%=inc%>" id="empName1" size=43
			value="<%=fullName%>[<%=otProcedureNotesEntryDetail.getEmployee().getId()%>]" />

		<div id="ac2update2"
			style="display: none; font-weight: normal; border: 1px solid black; padding-right: 10px; background-color: white;"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('empName1','ac2update2','ot?method=getEmpNameForAutoComplete',{parameters:'requiredField=empName<%=inc%>'});
			</script></td>

		<input type="hidden" value="<%=inc%>" name="hiddenValue"
			id="hiddenValue" />

	</tr>
	<%inc++;} %>
</table>

<label>Surgery Time:</label> <label>From:</label> <input type="text"
	name="surgeryFromTime" maxlength="5" id="surgeryFromTime"
	value="<%=otProcedureNotesEntryHeader.getSurgeryFromTime() %>"
	onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);"
	onblur="IsValidTimeWithBlankCheck(this.value,surgeryFromTime)" /> <label
	style="padding-left: 0px; margin-left: 4px; float: left; text-align: left;">(HH:MM)</label>

<label>To:</label> <input type="text" name="surgeryToTime" maxlength="5"
	id="surgeryToTime"
	onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);"
	value="<%=otProcedureNotesEntryHeader.getSurgeryToTime() %>"
	onblur="IsValidTimeWithBlankCheck(this.value,surgeryFromTime)" /> <label
	style="padding-left: 0px; margin-left: 4px; float: left; text-align: left;">(HH:MM)</label>

<div class="Clear"></div>
<label>Anaesthesia:</label> <select name="anaesthesiaId"
	id="anaesthesiaId">
	<option value="0">Select</option>
	<option value="GA">GA</option>
	<option value="SA">SA</option>
	<option value="EA">EA</option>
	<option value="LA">LA</option>
	<option value="RA">RA</option>
	<option value="DA">DA</option>
</select> <script type="text/javascript">
		document.getElementById('anaesthesiaId').value = '<%=otProcedureNotesEntryHeader.getAnaesthesiaValue()%>'; 
	</script></div>
<div class="Clear"></div>
<div class="blockFrame"><label>Pre OP Orders</label> <textarea
	name="preOpOrders" id="remarks" cols="0" rows="0" maxlength="400"
	onkeyup="return ismaxlength(this)" class="large"><%=otProcedureNotesEntryHeader.getPreOpOrders()%></textarea>

</div>

<div class="division"></div>
<div class="Clear"></div>
<div class="blockFrame"><label>Finding & Procedure</label> <textarea
	name="findings" cols="0" rows="0" maxlength="400"
	onkeyup="return ismaxlength(this)" class="large" id="findings"><%=otProcedureNotesEntryHeader.getFindingsNProcedures()%></textarea>

</div>

<div class="division"></div>
<div class="Clear"></div>
<div class="blockFrame"><label>Post OP Orders</label> <textarea
	name="postOpOrders" cols="0" rows="0" maxlength="400"
	onkeyup="return ismaxlength(this)" class="large" id="postOpOrders"><%=otProcedureNotesEntryHeader.getPostOpOrders()%></textarea>

</div>
<%} %>
<div class="division"></div>
<div class="division"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName %></label>

<label>Changed Date</label> <label class="value"><%=date %></label> <label>Changed
Time</label> <label class="value"><%=time %></label>
<div class="Clear"></div>
<div class="Height10"></div>
<%if(patientDetailList!=null && patientDetailList.size()>0)
	{ %> <input type="button" name="Submit" class="button" value="Submit"
	onclick="submitForm ('otBooking','ot?method=submitOtProcedureNotesEntryJsp&otProcedure=yes')" />
<%}else if(otList!=null && otList.size()>0){ %> <input type="button"
	name="Update" class="button" value="Update"
	onclick="submitForm ('otBooking','ot?method=updateOtProcedureNotesEntryJsp')" />
<%} %> <input name="hinId" type="hidden" value="" /> <input
	name="patientStatus" type="hidden" value="" /> <input name="orderNo"
	type="hidden" value="" /> <input name="hospitalId" type="hidden"
	value="" /> <input name="changedBy" type="hidden"
	value="<%=userName %>" /> <input name="changedDate" type="hidden"
	value="<%=date %>" /> <input name="changedTime" type="hidden"
	value="<%=time %>" /> <input name="back" type="button" class="button"
	value="Back"
	onclick="submitForm ('otBooking','ot?method=showOtPatientDetails&otProcedure=yes')" />

</div>
</form>
</div>

<script type="text/javascript">

function validateEmpForAutoComplete( strValue,inc ) {
 			 
 			var index1 = strValue.lastIndexOf("[");
		    var index2 = strValue.lastIndexOf("]");
		    index1++;
		    var id = strValue.substring(index1,index2);
		    if(id =="")
		    {
		    		document.getElementById('empName'+inc).value="";
 					return ;
 			}
 			return true;
		}	
  
	function removeRow()
	{
	  var tbl = document.getElementById('investigationGrid');
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2){
	   tbl.deleteRow(lastRow - 1);
	   document.getElementById('hiddenValue').value= (document.getElementById('hiddenValue').value-1);
	  }
	}
 function addRowForSurgery(){
		
	  var tbl = document.getElementById('investigationGrid');
	  var lastRow = tbl.rows.length;
	 
	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hiddenValue');
	  hdb.value=iteration
	 
	  var cellRightSel = row.insertCell(0);
	  var sel = document.createElement('input');
	  sel.value=hdb.value;
	  sel.size='2'
	  cellRightSel.appendChild(sel);
	 
	  var cellRight1 = row.insertCell(1);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	   e0.name = 'empName' + iteration;
	  e0.id = 'empName' + iteration;
	  e0.size = '43'
	  cellRight1.appendChild(e0);
	   new Ajax.Autocompleter('empName'+iteration,'ac2update2','ot?method=getEmpNameForAutoComplete',{parameters:'requiredField=empName'+iteration});
	 
	  var cellRightSel = row.insertCell(2);
	  cellRightSel.id='nomenclaturetd'+iteration;
	}

function ismaxlength(obj){
	var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
	
	if (obj.getAttribute && obj.value.length>mlength)
	obj.value=obj.value.substring(0,mlength)
}
	
</script>