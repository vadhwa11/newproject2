<%@page import="jkt.hms.masters.business.InjAppointmentDetails"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.masters.business.ProcedureDetails"%>
<%@page import="jkt.hms.masters.business.OpdVaccinationPlan"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>


<%@page import="java.math.BigDecimal"%><script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js?n=1"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js?n=1"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js?n=1"></script>
<script type="text/javascript"> 
// var csrfTokenName='<csrf:tokenname />';
// var csrfTokenValue='<csrf:tokenvalue />';
	var csrfTokenName='${_csrf.parameterName}';
	var csrfTokenValue='${_csrf.token}';

</script>

 <script type="text/javascript" language="javascript"  src="/hms/jsp/js/jquery.min.js"></script>
<%
	Map map = new HashMap();
	Box box = HMSUtil.getBox(request);
	int itemId=0;
	int rowVal=0;
	List<ProcedureDetails> procedureDetails = new ArrayList<ProcedureDetails>();
	
	
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	}


	String message="";
	int dmaHeaderId=0;
    int qtyPrescription=0;

	if (map.get("dmaHeaderId")!=null)
		dmaHeaderId = (Integer)map.get("dmaHeaderId");
	else
		dmaHeaderId =box.getInt("dmaHeaderId");
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTimeWithoutSc");
	
	List<StoreItemBatchStock>batchList=new ArrayList<StoreItemBatchStock>();
	if(map.get("batchList")!=null){
		batchList=(List<StoreItemBatchStock>)map.get("batchList");
	}
	
	List<InjAppointmentDetails>injAppointmentDetails=new ArrayList<InjAppointmentDetails>();
	if(map.get("injAppointmentDetails")!=null){
		injAppointmentDetails=(List<InjAppointmentDetails>)map.get("injAppointmentDetails");
	}
	
	List<OpdVaccinationPlan>opdVaccinationPlanList=new ArrayList<OpdVaccinationPlan>();
	if(map.get("opdVaccinationPlanList")!=null){
		opdVaccinationPlanList=(List<OpdVaccinationPlan>)map.get("opdVaccinationPlanList");
	}
	%>

<script language="JavaScript">
	<% 
	if (!message.equals("")) { %>
		window.opener.document.getElementById('dmaHeaderId').value='<%=dmaHeaderId%>';
		self.close();
	<% } %>
	</script>



<script type="text/javascript">
	function cancelForm()
	{
		   window.close();
	   
   	}


</script>
<form name="issueProcedure" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>Procedure Details </h2>
</div>
<div class="Clear"></div>
<div class="Block">
<label>Injection Name</label>
<label class="valueAuto">&nbsp;<%=box.getString("injectionName")%></label>
<label>Frequency </label>
<label class="valueAuto">&nbsp;<%=box.getString("frequency")%></label>
<label>No Of Days </label>
<label class="valueAuto">&nbsp;<%=box.getString("noofDays")%></label>
<%
String AppointmentFlag="n";
int TotalRecordsForSameDay=0;
int nTotalProcedure =box.getInt("nTotalProcedure");
int frequencyCount = box.getInt("frequencyCount");
String currentRecordsDate ="";
String sd1="";
String sd2="";
Date d1= new Date();
Date d2= new Date();
for(InjAppointmentDetails listA : injAppointmentDetails)
		{
			sd1 = HMSUtil.convertDateToStringWithoutTime(d1);
			sd2 = HMSUtil.convertDateToStringWithoutTime(listA.getInjAppointmentDate()!=null?listA.getInjAppointmentDate():d2);
			currentRecordsDate = HMSUtil.convertDateToStringWithoutTime(listA.getInjAppointmentDate()!=null?listA.getInjAppointmentDate():d2);	
			
			if(sd1.equalsIgnoreCase(sd2))
			{
				TotalRecordsForSameDay++;
			}
		}

%>
<%
 
  if(frequencyCount == TotalRecordsForSameDay && injAppointmentDetails.size() != nTotalProcedure && sd1.equalsIgnoreCase(currentRecordsDate) )
  {
	   AppointmentFlag="y";
	  %>
	  	<label>Next Appointment Date </label>
		<input	type="text" name="appDate" id="appDate" validate="Appointment Date,string,yes" value="" class="date" readonly="readonly" MAXLENGTH="50"  />
		<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" 
		class="calender"	onClick="setdate('<%=date %>',document.issueProcedure.appDate,event)" /> 
	  <%
  }

%>


</div>
<div class="Clear paddingTop15"></div>


<input type="hidden" name="batchSize" id="batchSize" value="<%=batchList.size()%>"/>
<input type="hidden" name="storeFyDocumentNoId" id="storeFyDocumentNoId" value="" />
<input type="hidden" name="procedureDetailsId" id="procedureDetailsId" value="procedureDetailsId" />
<input type="hidden" name="nTotalProcedure" id="nTotalProcedure" value="<%=box.getInt("nTotalProcedure")%>" />
<table width="200" colspan="7" id="indentDetails" cellpadding="0" cellspacing="0">

<thead>
<tr>
<th width="10%">SL No</th>

	<th width="13%">Batch No</th>
	<th width="13%">Available Stock</th>
	<th width="13%">Issue Stock</th>
<th width="10%">Appointment Date</th>
<th width="10%">Injection Date/Time</th>
<th width="13%">Nursing Remarks</th>
<th width="13%">Action</th>
</tr>

	</thead>
	<tbody>
		<%
  					int i=1;
  					int count=0;
  				for(InjAppointmentDetails listA : injAppointmentDetails)
  					{
 			%>

		<tr>
			<td>
			
			
			<input type="text" id ="counter<%=i %>" name="counter<%= i%>" size="10" readonly="readonly" value="<%=i %>" />
			 <input type="hidden" name="immunizationInj<%=i %>" id="immunizationInj<%=i %>" value="<%=listA.getImmunizationInj()!=null ? listA.getImmunizationInj() : ""%>">
			<input type="hidden" name="vaccinId<%=i %>" id="vaccinId<%=i %>" value="<%=listA.getVaccinId()!=null ? listA.getVaccinId() : "0"%>">
			<input type="hidden" name="vaccinPlanId<%=i %>" id="vaccinPlanId<%=i%>" value="<%=opdVaccinationPlanList.size()!=0 ? opdVaccinationPlanList.get(0).getId() : "0"%>">
			
			 <input type="hidden" name="Id" value="<%=listA.getId()%>" >
			<input id="hinId" value="<%=listA.getInjAppointmentHeader().getHin().getId()%>" type="hidden" >
			</td>
			
			
			
			
			<td>
				<%if(listA.getBatchNo()!=null && listA.getStatus().equalsIgnoreCase("y")) {%>
			   			<input type="text" readonly="readonly"   value="<%=listA.getBatchNo()%>"/> 
			   	<%}else{%>
			   			
			   		<%-- 	<%if(batchList.size()==0){ %>
			   				<%if((listA.getAdministrator()==null ||  listA.getAdministrator().equalsIgnoreCase("n"))) {%>
				   				<input type="checkbox" class="radioCheckCol2" id ="adm<%=i %>" name="adm<%= i%>" size="10" /> Outside Injection
				   			<%}else{ %>
				   				<input type="checkbox" checked="checked" class="radioCheckCol2" disabled="disabled" /> Outside Injection
				   			<%} %>
					   <%}else{ %> --%>
					   		 <select id="itemBatchStock<%=i %>" onchange="showClosingStock(this.value,<%=i%>)">
								<option value="0">Select</option>
								<%for(StoreItemBatchStock str:batchList){ %>
									<option value="<%=str.getBatchNo() %>:<%=str.getId()%>:<%=str.getClosingStock()%>"><%=str.getBatchNo() %></option>
								<%} %>
							</select>
					  
					   
					   
					   
					   
			   			
			   	<%} %>
			</td>
<%-- 				<%if((listA.getFinalStatus()!=null && listA.getFinalStatus().equalsIgnoreCase("n"))) {%>
			   			<td><input type="text" readonly="readonly" /></td>
						<td><input type="text" readonly="readonly" value="<%=listA.getPatientPrescriptionDetails().getDosage() %>" /></td> 
			   	<%}else{%>
			   		  <%if(batchList.size()>0){ %>
						<td><input type="text" readonly="readonly" id ="availableStock<%=i %>"  name="availableStock<%= i%>" /></td>
						<td><input type="text" id ="issueStock<%=i %>" name="issueStock<%= i%>" value="<%=listA.getPatientPrescriptionDetails().getDosage() %>" readonly="readonly" /></td>
					   <%}%>
			   	<%} %> --%>
				
			   
						<td><input type="text" readonly="readonly" id ="availableStock<%=i %>"  name="availableStock<%= i%>" /></td>
						<td><input type="text" id ="issueStock<%=i %>" name="issueStock<%= i%>" value="<%=listA.getPatientPrescriptionDetails().getDosage() %>" readonly="readonly" /></td>
					
			
			
			<td><input type="text" id="appointmentDate<%=i %>" name="appointmentDate<%=i %>"	size="18" readonly="readonly" value="<%=(listA.getInjAppointmentDate()!=null? HMSUtil.convertDateToStringWithoutTime(listA.getInjAppointmentDate()): "") %>" /></td>
			<td>
			
			 <input type="text" id="injAppointmentDate<%=i %>" name="injAppointmentDate<%=i %>"	size="18" readonly="readonly" value="<%=(listA.getAppointmentTime()!=null? HMSUtil.convertDateToStringWithoutTime(listA.getInjAppointmentDate()): "") %>   <%=listA.getAppointmentTime()!=null? listA.getAppointmentTime(): "" %>" />
				 
			</td>
			
			
			<td><input type="text" name="remarks<%=listA.getId()%>" id="remarks<%=listA.getId()%>" value="<%=listA.getNursingRemark()!=null?listA.getNursingRemark():"" %>" tabindex="1" size="30" maxlength="200"/></td>
			<%
			
			if(listA.getStatus().equalsIgnoreCase("y"))
			{
				%>
					<td><input type="text" id ="status<%=i %>" name="status<%= i%>" size="30" readonly="readonly" value="<%=!listA.getStatus().equalsIgnoreCase("n")?"Completed":"Not Completed"%>" /></td>
				
				<%
			}
			else
			{
				
				
				
				//if(sd1.equalsIgnoreCase(HMSUtil.convertDateToStringWithoutTime(listA.getInjAppointmentDate()))){
					if(d1.compareTo(listA.getInjAppointmentDate())>=0){
				%>
				
					<td><input type="button" class="button" readonly="readonly" name="save<%=listA.getId()%>" id="save<%=listA.getId()%>" value="Save" onclick="saveNursingCareValues(<%=listA.getId() %>,<%=i %>);" />
				<%
				}
				else
				{
					System.out.println("h "+currentRecordsDate+ " b= "+sd1 + "c="+listA.getInjAppointmentDate());
				
					%>
					<td><input type="text" id ="status<%=i %>" name="status<%= i%>" size="30" readonly="readonly" value="Wait for next Appontment date" /></td>
				
					<%
				}
			}
			
			%>
			
			<input type="hidden" name="amount<%=i %>" id="amount<%= i%>" value="" /></td>
			
			</tr>
				<%
  	 	i++;
  	   }
  	 %>
   </tbody>
</table>
	<input type="hidden" name="hdb" value="<%=i %>" id="hdb" />
<script>
  
  </script>

<div id="edited"></div>
  <div class="clear"></div>
    <div class="division"></div>
      <div class="clear"></div>
  <input type="button" name="cancel" id="addbutton" value="Close" class="button" onClick="cancelForm();" accesskey="a" />
</form>
<script type="text/javascript">


<%
	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date1=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date1.length()<2){
		date1="0"+date1;
	}
%>
serverdate = '<%=date1+"/"+month1+"/"+year1%>'


function showClosingStock(val,count){
	if(val!=0){
		var str=val.split(":");
		var stockId=str[1];
		var closingStock=str[2];
		document.getElementById("availableStock"+count).value=closingStock;
		/* if(closingStock>0){
			document.getElementById("issueStock"+count).value=1;	
		}else{
			document.getElementById("issueStock"+count).value=0;
		} */
			
	}else{
		document.getElementById("availableStock"+count).value="";
	}
}

function saveNursingCare(Id)
{
	alert(Id);
	var b = true;
	if(document.getElementById('cDate'+Id).value == "")
	{
	  alert("Please enter the Procedure date.");
	  b=false;
	}
	if(document.getElementById('cTime'+Id).value == "")
	{
	  alert("Please enter the Procedure time.");
	  b=false;
	}
	
	if(!b)
		{
			saveNursingCareValues(Id);
		}
}

function saveNursingCareValues(Id,rowVal)
{
		//var adm=0;
		var data ="";
		var AppointmentFlag = '<%out.print(AppointmentFlag);%>';
	    var AppointmentDate = $("#appDate").val();
	    var remarks = document.getElementById('remarks'+Id).value;
	    
	/* 	if(document.getElementById("batchSize").value==0){
			adm=1;
			var data = "Id="+Id+"&remarks="+remarks+"&AppointmentFlag="+AppointmentFlag+"&AppointmentDate="+AppointmentDate+"&adm="+adm;
		}else{ */
			var itemBatchStock=document.getElementById("itemBatchStock"+rowVal).value;
			var availableStock=document.getElementById("availableStock"+rowVal).value;
			var issueStock=document.getElementById("issueStock"+rowVal).value;
			var immunizationInj=document.getElementById("immunizationInj"+rowVal).value;
			var vaccinId=document.getElementById("vaccinId"+rowVal).value;
			var vaccinPlanId=document.getElementById("vaccinPlanId"+rowVal).value;
			if(itemBatchStock==0)
			{
				alert("Select Batch No");
				return;
			}
			
			data = "Id="+Id+"&remarks="+remarks+"&AppointmentFlag="+AppointmentFlag+"&AppointmentDate="+AppointmentDate+"&batchNo="+itemBatchStock+"&issueStock="+issueStock
			+"&immunizationInj="+immunizationInj+"&vaccinId="+vaccinId+"&vaccinPlanId="+vaccinPlanId;
		//}
		
	    var url = "opd?method=submitNursingCare&hinId="+document.getElementById("hinId").value;
	    if(availableStock <= 0 ){
	    	alert("Select Stock!");
	    	return;
	    }
	    if(AppointmentFlag == 'y')
	    	{
	    		if($("#appDate").val() == "")
	    			{
	    				alert("Please enter next appointment date");
	    				return;
	    			}
	    		
	    		else
    			{
    			var today = new Date();
    			var currentDate = today.getDate() + '/' + (today.getMonth() + 1)+ '/' + today.getFullYear() ;
    			if($("#appDate").val() <= currentDate)
    				{
    				alert("Appointment cannot be scheduled for past date");
    				return;
    				
    				}
    			}
	    	}

	 	    
	    jQuery(function ($) {
	  
	    	$.ajax({
				type:"POST",
				url: url,
				data: data,	 							
				cache: false,
				success: function(msg)
				{									 
					$("#save"+Id).hide();
					alert("Records Saved Sucessfully");
					window.opener.location = window.opener.location;
					window.close();
					
				},
				error: function(msg)
				{					
					
					alert("An error has occurred while contacting the server");
					$("#save"+Id).hide();
				}
				
				
			});
	    });   
	 
		
	

}

function cancelForm()
{
	window.opener.location = window.opener.location;
    window.close();
 
}


</script>