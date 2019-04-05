
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>
<%@page import="static jkt.hms.util.RequestConstants.CHANGED_BY"%>
<%@page import="static jkt.hms.util.RequestConstants.CHANGED_TIME"%>
<%@page import="static jkt.hms.util.RequestConstants.CHANGED_DATE"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.PatientDietIndoorDetail"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.IpdMedicineIssueDetails"%>
<%@page import="jkt.hms.masters.business.IpdMedicineIssueHeader"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>

<%@page import="jkt.hms.util.HMSUtil"%>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/controls.js?n=1"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>

<script type="text/javascript" language="javascript"	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>


<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
 <script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script> 



<%
Map map = new HashMap();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}
String userName = "";
if (session.getAttribute("userName") != null) {
	userName = (String) session.getAttribute("userName");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");  
String time = (String)utilMap.get("currentTime");
 
	String pageTitle = "";
    String message = "";
	
	if(map.get("message") != null){
		message = (String)map.get("message");
	}
	List<IpdMedicineIssueDetails> ipdMedicineIssueDetailsList= new ArrayList<IpdMedicineIssueDetails>();
	if(map.get("ipdMedicineIssueDetailsList") != null){
		ipdMedicineIssueDetailsList = (List<IpdMedicineIssueDetails>)map.get("ipdMedicineIssueDetailsList");
	}
	/* 
	List<DepartmentMedicineIssue> departmentMedicineIssueList= new ArrayList<DepartmentMedicineIssue>();
	if(map.get("departmentMedicineIssueList") != null){
		departmentMedicineIssueList = (List<DepartmentMedicineIssue>)map.get("departmentMedicineIssueList");
	} */
	

	List<StoreItemBatchStock> batchList= new ArrayList<StoreItemBatchStock>();
	if(map.get("batchList") != null){
		batchList = (List<StoreItemBatchStock>)map.get("batchList");
	}
	
	int remainingQty =0;
	if(map.get("remainingQty") != null){
		remainingQty = Integer.parseInt(map.get("remainingQty").toString());
	}
	
	PatientPrescriptionDetails ppd= new PatientPrescriptionDetails();
	if(map.get("ppd") != null){
		ppd = (PatientPrescriptionDetails)map.get("ppd");
	}
	
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate"); 	
	
	int hospitalId = 0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId =  (Integer)session.getAttribute("hospitalId");
	}
	int empId = 0;
	if(session.getAttribute("empId") != null){
		empId = (Integer)session.getAttribute("empId");
	}
	
	
	int deptId = 0;
	if (session.getAttribute("deptId") != null) {
		deptId =  (Integer)session.getAttribute("deptId");
	}
%>

<form name="getMedicineEntryPage" method="post" action="">
    <h4><%=message %></h4>
	<h4>Medicine Entry</h4>
	<!-- <body onunload="javascript:refreshParent()"> -->
	<body >
	<%
if(ppd!=null)
{ %>
   <div class="Block">
<label>No of Days</label><input type="text" readonly="readonly" value="<%=(ppd.getNoOfDays()!=null?ppd.getNoOfDays():"")%>"/>
<label>Frequency</label><input type="text" readonly="readonly" value="<%=(ppd.getFrequency()!=null?ppd.getFrequency().getFrequencyName():"")%>"/>
<label>Dosage</label><input type="text" id="dosage" readonly="readonly" value="<%=(ppd.getDosage()!=null?ppd.getDosage():"")%>"/>
<div class="clear"></div>
<label>Batch<span>*</span></label>
<%-- <select name="dmiId" validate="Batch,string,yes" id="dmiId" tabindex="1" >
	<option value="0">Select</option>
	<%
	for (DepartmentMedicineIssue departmentMedicineIssue : departmentMedicineIssueList) 
	{
	%>
	<option value="<%=departmentMedicineIssue.getId()%>"><%=departmentMedicineIssue.getStoreItemBatchStock().getBatchNo()+"("+departmentMedicineIssue.getQtyRemaining().intValueExact()+")"%></option>
	<%		
		}%>
</select>  --%>
<select name="dmiId" validate="Batch,string,yes" id="dmiId" tabindex="1" >
	<option value="0">Select</option>
	<%
	for (StoreItemBatchStock batch : batchList) 
	{
	%>
	<option value="<%=batch.getId()%>"><%=batch.getBatchNo()+"("+batch.getClosingStock()+")"%></option>
	<%		
		}%>
</select> 

<%-- <script type="text/javascript">
		<%
			int counter1 = 0;
			
				for (DepartmentMedicineIssue departmentMedicineIssue : departmentMedicineIssueList) 
				{
					
						
								%>
									itmeArray[<%=counter1%>] = new Array();
									itmeArray[<%=counter1%>][0]=<%=departmentMedicineIssue.getId()%>;
									itmeArray[<%=counter1%>][1] = <%=departmentMedicineIssue.getQtyRemaining()%>;									
								

								<%
								counter1++;
						
					
				}
			
			
		%>
</script>  --%>
</div>
<%} %>
	<div class="Block" style="padding-top: 20px;">
		
       
			<!-- <table class="tblSearchActions" cellspacing="0" cellpadding="0"
				border="0">
				<tr>
					<td class="SearchStatus" style="font-size: 13px;" align="left">Search
						Results</td>
					<td>
						<div id=resultnavigation></div>


					</td>
					<td style="width: 80px;"><input id="pageno" type="text"
						maxlength="4" name="pageno" style="width: 25px;"> <input
						class="button" type="button"
						onclick="goToPageForPatient(pageno.value)" value="Go" name="ok"
						style="width: 35px;"></td>
				</tr>
			</table> -->

			<table id="tblSearchResultsHeader" class="tblSearchResultsHeader"
				cellspacing="0" cellpadding="0" border="0">
				<tr>

					<th  >Date</th>
					<%int i=0;
					  int no_of_days =0;
					  String doseTime = "";
					  boolean doseflag=false;
					  String remarks ="";
					  String status = "";
					  int pendingIssueQty = 0;
					if(ppd!=null)
						{
						i=0;
						i= ppd.getFrequency().getFeq().intValue();
						for(int j=1; j<=i; j++)
						{
							
						
						%>
						<th >Dose<%=j%></th>	
						<%
						}}
						%>
									
					<th  >Remarks</th>


				</tr>
				<tbody id="tblListOfPatient">
				<%
				
				if(ppd!=null)
				{   String entryDate=HMSUtil.convertDateToStringWithoutTime(ppd.getPrescription().getPrescriptionDate());
			       
					no_of_days = ppd.getNoOfDays().intValue();
					for(int k =1; k<=no_of_days; k++)
					{
						
						
				%>
				<tr>
				
				<td>Day<%=k%>
				
				<input type="hidden"  name="date<%=k%>" id="date<%=k%>" readOnly="true" value="<%=entryDate%>"/>
				</td>
				 	<%
				 	entryDate = HMSUtil.convertDateToStringWithoutTime(HMSUtil.addDaysToDate(entryDate, 1));
					if(ppd!=null)
						{
						i=0;
						i= ppd.getFrequency().getFeq().intValue();
						status = ppd.getItemStopStatus();
						/* pendingIssueQty = (ipdMedicineIssueHeaderList.get(0).getPatientPrescriptionDetails().getQtyIssued() - ipdMedicineIssueHeaderList.get(0).getIssuedQuantity()); */
						for(int j=1; j<=i; j++)
						{
							System.out.println("ipdMedicineIssueDetailsList"+ipdMedicineIssueDetailsList.size());
							doseflag =false;
							remarks = "";
							for(IpdMedicineIssueDetails ipdMedicineIssueDetails: ipdMedicineIssueDetailsList)
							{
								
								if(ipdMedicineIssueDetails.getDose().trim().equals("dose"+k+j) && ipdMedicineIssueDetails.getIssued().trim().equalsIgnoreCase("y"))
								{
									doseflag=true;
									System.out.println("dose"+ipdMedicineIssueDetails.getDose());
									doseTime = ipdMedicineIssueDetails.getIssueTime();
									remarks = ipdMedicineIssueDetails.getRemarks();
								}
								
							}
							
							 if(doseflag)
							{
								%>
								<td><input type="checkbox" checked="true" name="dose<%=k%><%=j%>" id="dose<%=k%><%=j%>" value="y" disabled="true" style="margin:-2px 5px 0px 5px;"/><%=doseTime%>			
								</td>
								<%	
							}
							else if(status != null && status.trim().equalsIgnoreCase("y"))
							{
								%>
								<td><input type="checkbox"  name="dose<%=k%><%=j%>" id="dose<%=k%><%=j%>" value="y" disabled="true"/>	
											
								</td>
								<%	
							}
							
								else if(remainingQty<=0)
							{
								%>
								<td><input type="checkbox"  name="dose<%=k%><%=j%>" id="dose<%=k%><%=j%>" value="y" disabled="true"/>		
										
								</td>
								<%	
							}
							else 
							{
								%>
								<td><input type="checkbox"  name="dose<%=k%><%=j%>" id="dose<%=k%><%=j%>" value="y" style="margin-right: 5px;"/>		
								<input type="text" id="dose_time<%=k%><%=j%>" name="dose_time<%=k%><%=j%>" onblur="IsValidTime(this.value,this.id)" onkeyup="mask(this.value,this,'2',':');" style="width: 45px;" maxlength="5"/>		
								</td>
								<%	
							}
					
						}
						%>
						<input type="hidden" name="frequency" id="frequency" value="<%=i%>" />
						<%
						}
						%> 
				
				
				<td><textarea id="remarks<%=k%>" name="remarks<%=k%>" rows="" cols="" maxlength="500"><%=remarks %></textarea>
				</td>
				
				</tr>
				<%
				}%>
					<input type="hidden" name="no_of_days" id="no_of_days" value="<%=no_of_days%>" />
					<input type="hidden" name="headerId" id="headerId" value="<%=ppd.getId()%>" />
				<%	}
				
				%>
				

				</tbody>
			</table>
			<div class="clear"></div>
			<div class="clear"></div>

			
          <input type="hidden" value="<%=empId%>" name="approvedBy" /> 
          
          <div class="Clear"></div>
          <div class="division"></div>
          <div class="Clear"></div>

<input type="button" class="button" value="Submit " align="left"
	onClick="submitForm('getMedicineEntryPage','ipd?method=submitMedicineEntryPage','validateCheckBox');refreshParentWindow()" />
<!-- <input type="button" class="button" value="Back" align="left"
	onClick="submitForm('getMedicineEntryPage','ipd?method=showPatientListJsp');" /> -->
<input type="reset" name="reset" value="Reset" class="button" onclick="location.reload();"/>
		
		<!-- <div id="pageNavPosition"></div> -->

	</div>
	<div class="clear"></div>
<div class="division"></div>	
<div class="paddingTop15"></div>
	<div class="bottom">
<label>Changed By</label> 
<label class="value"><%=userName%></label>

<label>Changed Date</label> 
<label class="value"><%=currentDate%></label>

<label>Changed Time</label> 
<label class="value"><%=time%></label> 
<input	type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> 
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>
</body>
</form>
<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js?n=1"></script>

<script language="javascript">
	var nPageNo = 1;

	var $j = jQuery.noConflict();

	$j(document).ready(function() {
	

	});



	function validateCheckBox() {

		var flag = false;
		var issuedFlag = false;
		var totalDose = 0;
		var no_of_days = parseInt(document.getElementById("no_of_days").value);
		var frequency = parseInt(document.getElementById("frequency").value)
		
		var e = document.getElementById("dmiId");
        var selectedText = e.options[e.selectedIndex].text;

		/* alert(no_of_days);
		alert(frequency); */

		for (var i = 1; i <=no_of_days; i++) {
			for (var j = 1; j <=frequency; j++) {
			if (document.getElementById("dose"+i+j).checked == true) {
				if(!document.getElementById("dose"+i+j).disabled)
					{
					totalDose += parseInt(document.getElementById("dosage").value);
					flag = true;
					}
				
			} 
		}}
		if (!flag) {
			alert("Please select at least one checkbox.");
		}
		else if(selectedText != "Select" && (totalDose > parseInt(selectedText.split("(")[1].split(")")[0])))
			{
			flag = false;
			alert("Not Enough Stock.");
			}
		return flag;

	}
	function refreshParent() 
	{
		window.opener.location.reload(true);
	}
</script>

