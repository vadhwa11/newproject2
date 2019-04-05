
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.HrDutyMaster"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasEmployee;"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<!--main content placeholder starts here-->
<div id="contentHolder">
<h6>Duty Exemption Entry</h6>
<div class="Clear"></div>

<script type="text/javascript" language="javascript">
		<%
		
			Calendar calendar=Calendar.getInstance();
			String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
			String date=String.valueOf(calendar.get(Calendar.DATE));
			String time=String.valueOf(calendar.getTime());
			int year=calendar.get(calendar.YEAR);
			if(month.length()<2){
				month="0"+month;
			}
			if(date.length()<2){
				date="0"+date;
			}
				
		%>
			serverdate = '<%=date+"/"+month+"/"+year%>'
				<%
				Map<String, Object> map = new HashMap<String, Object>();
				Map<String, Object> employeeMap = new HashMap<String, Object>();
				BigDecimal totalAL=new BigDecimal("0");
				BigDecimal totalCL=new BigDecimal("0");
				BigDecimal totalSL=new BigDecimal("0");
				
				List<HrDutyMaster> dutyList = new ArrayList<HrDutyMaster>();
				List<MasEmployee>employeeList=new ArrayList<MasEmployee>();
				String entryNo="";
		
				if(request.getAttribute("map") != null){
					map = (Map<String, Object>)request.getAttribute("map");
				}
				if(map.get("employeeList") != null){
					employeeList= (List<MasEmployee>)map.get("employeeList");
				}
				if(map.get("dutyList") != null){
					dutyList= (List<HrDutyMaster>)map.get("dutyList");
				}
				if(map.get("entryNo") != null){
					entryNo= (String)map.get("entryNo");
				}
				if(map.get("message") != null){
					   String message = (String)map.get("message");
					   out.println(message);
				}
				String userName = "";
			 	if (session.getAttribute("userName") != null) {
			 		userName = (String) session.getAttribute("userName");
			 	}
			 	Map<String, Object> utilMap = new HashMap<String, Object>();
			 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			 	
			 	String currentDate = (String) utilMap.get("currentDate");
			 	String currentTime = (String) utilMap.get("currentTime");
			%>
		

				function removeRow()
				{
			 		 var tbl = document.getElementById('investigationGrid');
			 		 var lastRow = tbl.rows.length;
			 		 if (lastRow > 2) tbl.deleteRow(lastRow - 1);
				}
				
				function addRow(){
				
				  var tbl = document.getElementById('investigationGrid');
				  var lastRow = tbl.rows.length;
				 
				  // if there's no header row in the table, then iteration = lastRow + 1
				  var iteration = lastRow;
				  var row = tbl.insertRow(lastRow);
				  var hdb = document.getElementById('hiddenValue');
				  hdb.value=iteration
				  //alert("iteration row--"+iteration)
				 
				  var cellRightSel = row.insertCell(0);
				  cellRightSel.id='tdduty'+iteration;
				  
				  var sel = document.createElement('select');
			 	  sel.name = 'duty'+iteration;
			 	 sel.className = 'large';
			 	  sel.id='duty'+iteration;
			 	  sel.validate='DutyName,String,yes';
			  	  sel.options[0] = new Option('Select', '');
			  	  <% int counter=1; 
			  	  for(HrDutyMaster hrDutyMaster:dutyList){%>
			  	 	 sel.options[<%=counter%>] = new Option('<%=hrDutyMaster.getDutyName()%>', '<%= hrDutyMaster.getId()%>');
			  	 	<%counter++;}%>
			  	  cellRightSel.appendChild(sel);

				 
			  	 var cell2 = row.insertCell(1);
			  	 var e2 = document.createElement('input');
			  	 e2.type = 'text';
			  	 e2.readOnly = true;
			  	 e2.name='fromDate'+ iteration;
			  	 e2.id='fromDate'+iteration;
			  	 cell2.appendChild(e2); 
			  	  
			  	var cell3 = row.insertCell(2);
			  	 var eImg = document.createElement('img');
			  	 eImg.src = '/hms/jsp/images/cal.gif';
			  	 eImg.id = 'calId1'+iteration;
			  	 eImg.onclick = function(event){
			  	     setdate('',document.getElementById('fromDate'+iteration),event) };
			  	
			  	 cell3.appendChild(eImg);

			  	var cell4 = row.insertCell(3);
			  	 var e3 = document.createElement('input');
			  	 e3.type = 'text';
			  	 e3.readOnly = true;
			  	 e3.name='toDate'+ iteration;
			  	 e3.id='toDate'+iteration;
			  	cell4.appendChild(e3); 
			  	  
			  	 var cell5 = row.insertCell(4);
			  	 var eImg1 = document.createElement('img');
			  	 eImg1.src = '/hms/jsp/images/cal.gif';
			  	 eImg1.id = 'calId2'+iteration;
			  	 eImg1.onclick = function(event){
			  	     setdate('',document.getElementById('toDate'+iteration),event) };
			  	
			  	 cell5.appendChild(eImg1);
				
				  var cellRightSel = row.insertCell(5);
				  var e4 = document.createElement('input');
				  e4.type = 'text';
				  e4.name='remarks'+iteration;
				  e4.id='remarks'+iteration;
				  e4.size = '20';
				  e4.maxLength='30';
				  e4.validate='Remarks,String,yes';
				  cellRightSel.appendChild(e4);
				 
				 
				}
					
	</script>



<form name="dutyExemptionEntry" action="" method="post">

<div class="blockTitle">Employee Details</div>
<div class="blockTitleCurve"></div>

<div class="blockFrame">
<div class="Clear"></div>
<%for(MasEmployee masEmployee:employeeList){ %> <label>Service No.</label>
<input type="text" name="serviceNo" class="value" id="serviceNo"
	value="<%=masEmployee.getServiceNo()%>" readonly="readonly" /> <input
	type="hidden" name="empId" value="<%=masEmployee.getId()%>" /> <label>Rank</label>
<input type="text" name="rankName" class="value" id="rankName"
	value="<%=masEmployee.getRank().getRankName()%>" readonly="readonly" />

<label>Name</label> <input name="firstName" type="text" class="value"
	id="firstName"
	value="<%=masEmployee.getFirstName()%> <%=masEmployee.getLastName() %>"
	readonly="readonly" />
<div class="Clear"></div>

<label>Specialty</label> <%if(masEmployee.getSpeciality()!=null){ %> <input
	name="choice1" type="text" class="value" id="choice1"
	value="<%=masEmployee.getSpeciality().getSpecialistName() %>"
	readonly="readonly" /> <%}else{ %> <input name="choice1" type="text"
	class="value" id="choice1" value="" readonly="readonly" /> <%} %> <label>Classification</label>
<%if(masEmployee.getClassification()!=null){ %> <input name="choice2"
	type="text" class="value" id="choice2"
	value="<%=masEmployee.getClassification().getClassificationName() %>"
	readonly="readonly" /> <%}else{ %> <input name="choice2" type="text"
	class="value" id="choice2" value="" readonly="readonly" /> <%} %>
<div class="Clear"></div>
<%} %>
</div>
<div class="Clear"></div>
<div class="blockFrame"><label>Entry No.</label> <input
	name="entryNo" type="text" class="calDate" id="entryNo"
	value="<%=entryNo%>" readonly="readonly" /> <label>Entry Date</label> <input
	name="entryDate" type="text" class="calDate" id="entryDate"
	value="<%=currentDate%>" readonly="readonly" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate%>',document.dutyExemptionEntry.entryDate,event);" />
</div>
<div class="Clear"></div>
<div class="blockTitle">Duty Exemption Details</div>
<div class="blockTitleCurve"></div>

<div class="division"></div>

<div class="Clear"></div>
<input name="Add" type="button" class="cmnButton" value="Add"
	onclick="addRow()" /> <input name="Delete" type="button"
	class="cmnButton" value="Delete" onclick="removeRow()" />
<div class="Clear"></div>
<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="investigationGrid">
	<tr>
		<th scope="col">Duty Name</th>
		<th scope="col" colspan="2">From Date</th>
		<th scope="col" colspan="2">To Date</th>
		<th scope="col">Remarks</th>

	</tr>
	<tr>
		<td><select name="duty1" id="duty1"
			validate="Duty Name, String,yes" class="large">
			<option value="">Select</option>
			<%for(HrDutyMaster hrDutyMaster:dutyList){ %>
			<option value="<%=hrDutyMaster.getId()%>"><%=hrDutyMaster.getDutyName()%></option>
			<%} %>
		</select></td>
		<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />
		<td><input type="text" id="fromDate1" name="fromDate1" value=""
			MAXLENGTH="30" readonly="readonly" validate="From Date,String,yes" />
		</td>
		<td><img src="/hms/jsp/images/cal.gif" width="16" height="16"
			border="0" validate="Pick a date"
			onClick="setdate('<%=currentDate%>',document.dutyExemptionEntry.fromDate1,event);" /></td>
		<td><input type="text" id="toDate1" name="toDate1" value=""
			MAXLENGTH="30" readonly="readonly" validate="To Date,String,yes" />

		</td>
		<td><img src="/hms/jsp/images/cal.gif" width="16" height="16"
			border="0" validate="Pick a date"
			onClick="setdate('<%=currentDate%>',document.dutyExemptionEntry.toDate1,event);" /></td>
		<td><input type="text" name="remarks1" id="remarks1"
			MAXLENGTH="30" validate="Remarks,String,yes" /></td>
	</tr>
</table>

</div>
<div class="Clear"></div>

<!--table-->
<div class="division"></div>
<div class="bottom"><input name="submitButton" type="button"
	class="button" value="Submit"
	onclick="submitForm('dutyExemptionEntry','hrRelated?method=submitDutyExemptionEntry');" />
<input name="Button" type="reset" class="button" value="Reset" /> <input
	name="cancelButton" type="button" class="button" value="Cancel"
	onclick="submitForm('dutyExemptionEntry','hrRelated?method=showDutyExemptionSearchJsp');" />
<div class="division"></div>
<!--Bottom labels starts--> <label>Changed By</label> <label
	class="value"><%=userName %></label> <input type="hidden"
	value="<%=userName %>" name="changedBy" /> <label>Changed Date</label>
<label class="value"><%=currentDate %></label> <input type="hidden"
	value="<%=currentDate %>" name="changedDate" /> <label>Changed
Time</label> <label class="value"><%=currentTime %></label> <input type="hidden"
	value="<%=currentTime %>" name="changedTime" />
<div class="Clear"></div>

</div>
<!--Bottom labels starts--> <!--main content placeholder ends here--></form>
</div>

