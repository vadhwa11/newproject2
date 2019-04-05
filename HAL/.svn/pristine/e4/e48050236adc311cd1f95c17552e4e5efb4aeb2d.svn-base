<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MdContigentMedicalBillHd"%>
<%@page import="java.math.BigDecimal"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script type="text/javascript">
		history.forward();
</script>
<script>
<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
	month="0"+month;
	}
	if(dateCal.length()<2){
	dateCal="0"+dateCal;
	}
%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script>

<%
	int pageNo=1;
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	Set<Inpatient> inpatientSet = new HashSet<Inpatient>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");
	String userName="";
	int hospitalId=0;
	int specialhdId=0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
		}
		if(map.get("detailsMap") != null){
		detailsMap = (Map<String,Object>)map.get("detailsMap");
		}
		if (session.getAttribute("userName") != null) {
			  userName = (String) session.getAttribute("userName");
			}
		if(map.get("pageNo") != null){
			pageNo=(Integer)map.get("pageNo");
		}
		List<MdContigentMedicalBillHd> continegentList = new ArrayList<MdContigentMedicalBillHd>();
		if(map.get("continegentList") != null){
			continegentList = (List<MdContigentMedicalBillHd>)map.get("continegentList");
		}
		if(map.get("specialhdId") != null){
			specialhdId=(Integer)map.get("specialhdId");
		}
		int deptId =0;
		if(session.getAttribute("deptId") != null){
			deptId = (Integer)session.getAttribute("deptId");
		}
		int unitId=0;
		MasUnit unit = null;
		String unitAddress="";
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		if(map.get("unitList") != null){
			unitList = (List<MasUnit>)map.get("unitList");
			for(MasUnit masUnit :unitList){
				unitId= masUnit.getId();
				unitAddress=masUnit.getUnitAddress();
			 }
			}
%>
<form name="coveringLetterUnit" method="post" action="">

<div class="titleBg">
<h2>Covering Letters to Unit</h2>
</div>

<div class="Block">
<div class="Clear"></div>
<input type="hidden" name="pageNo" id="pageNo" value="<%=pageNo%>" /> <%
		String entrySeqNo="";
		if(map.get("entrySeqNo") != null){
			entrySeqNo = (String)map.get("entrySeqNo");
		}
		
%> <label>Entry No.</label> <input id="entryNoId" type=hidden
	name="<%=ENTRY_NO %>" value="<%=entrySeqNo %>" title="Entry No" /> <label
	class="value"><%=entrySeqNo %></label> <input type="hidden"
	id="specialhdId" name="specialhdId" value="<%= specialhdId%>" /> <label>Entry
Date <span>*</span></label> <input type="text" class="calDate" id="fromDateId"
	name="<%=ENTRY_DATE %>" value="<%=currentDate %>" readonly="readonly"
	MAXLENGTH="30" validate="Entry Date,date,yes" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.coveringLetterUnit.<%=ENTRY_DATE%>,event)" />
<input type="hidden" id="<%=DEPARTMENT_ID %>" name="<%=DEPARTMENT_ID %>"
	value="<%=deptId %>" /> 
<label>Dispatch Date <span>*</span></label> <input type="text"
	class="calDate" id="lastDateId" name="<%=DISPATCH_DATE %>"
	value="<%=currentDate %>" validate="Dispatch Date,date,yes"
	MAXLENGTH="10" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.coveringLetterUnit.<%=DISPATCH_DATE%>,event)" />
<div id="unitAddId"><!-- <label> Unit Address</label>			
<input id="unitAddressId" type="text" name="unitAdd" value="" maxlength="50" disabled="disabled"/>-->
</div>

<input type="hidden" size="2" value="" name="noOfRecords"
	id="noOfRecords" />
<div class="Clear"></div>
</div>
<%				
				if(continegentList.size() == 0){
				out.println(" No Record Found!");
							}else{
	%>
	<div class="clear"></div>
<h4>Reimbursement of medical claim pending for dispatch</h4>


<table width="100%" border="0" cellspacing="0" cellpadding="0" class="cmntable"	id="chargeDetails">
	<thead>
		<tr>
			<th scope="col">Select</th>
			<th scope="col">Service No</th>
			<th scope="col">Rank</th>
			<th scope="col">Name</th>
			<th scope="col">Amount</th>
		</tr>
	</thead>

	<tbody>

		<%
		int inc = 1;
	String serviceNo="";
	String rankName="";
	int hinId=0;
	String patientName="";
	BigDecimal amount =null;
	for(MdContigentMedicalBillHd mdContigentMedicalBillHd :continegentList){
		serviceNo=mdContigentMedicalBillHd.getHin().getServiceNo();
		rankName=mdContigentMedicalBillHd.getHin().getRank().getRankName() ;
		hinId=mdContigentMedicalBillHd.getHin().getId();
		String middleName = "";
		String lastName = "";
		if(mdContigentMedicalBillHd.getHin().getPMiddleName() != null){
			middleName = mdContigentMedicalBillHd.getHin().getPMiddleName();
		}
		if(mdContigentMedicalBillHd.getHin().getPLastName() != null){
			lastName = mdContigentMedicalBillHd.getHin().getPLastName();
		}
		amount=mdContigentMedicalBillHd.getAmount();
	%>

		<tr>
			<td><input id="selectId<%=inc %>" name="dispatch"
				type="checkBox" value="<%=mdContigentMedicalBillHd.getId()%>"
				checked class="check" /> <input id="contingethdId<%=inc %>"
				name="<%=CONTINGENT_BILL_HD_ID %>" type="hidden"
				value="<%=mdContigentMedicalBillHd.getId()%>" /></td>
			<td><input id="hinId<%=inc %>" name="<%=HIN_ID %>" type="hidden"
				value="<%=hinId%>" readonly="readonly" /> <input
				id="serviceNo<%=inc %>" name="<%=SERVICE_NO %>" type="text"
				value="<%=serviceNo%>" readonly="readonly" /></td>
			<td><input id="rankId<%=inc %>" name="<%=RANK_NAME %>"
				type="text" value="<%=rankName%>" readonly="readonly" /></td>
			<td><input id="patientName<%=inc %>" name="<%=PATIENT_NAME %>"
				type="text"
				value="<%= mdContigentMedicalBillHd.getHin().getPFirstName()+" "+middleName+" "+lastName%>"
				readonly="readonly" /></td>
			<td><input id="amount<%=inc %>" name="<%=AMOUNT %>" type="text"
				value="<%=amount%>" readonly="readonly" /></td>



			<input type="hidden" name="counter" value=<%=inc %>>
			<input type="hidden" value="<%=inc %>" name="hiddenValueCharge"
				id="hiddenValueCharge" />
		</tr>
		<% }%>
	</tbody>
	<%} %>
</table>


<div class="clear paddingTop15"></div>

<%if(continegentList.size() >0){%> 


<input type="button" class="button"	value="Submit" 	onclick="if(validateCollected())submitForm('coveringLetterUnit','mediClaim?method=submitCoveringletter');"/>
	
<input type="button" class="button" name="Reset" id="reset" value="Reset" onclick="resetClicked('coveringLetterUnit');"
	accesskey="r" /> <%} %>

<div class="clear"></div>
<div class="division"></div>
<div class="bottom">
<label>Changed By</label>
<label class="value"><%=userName%></label>
<label>Changed Date</label>
<label class="value"><%=currentDate%></label>
<label>Changed Time</label>
<label class="value"><%=time%></label>
<div class="clear"></div>
<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />
<INPUT type=hidden value="<%=userName%>" name="<%=LAST_CHANGED_BY%>">
<INPUT type=hidden value="<%=currentDate%>" name="<%=LAST_CHANGED_DATE%>">
<INPUT type=hidden value="<%=time%>" name="<%=LAST_CHANGED_TIME%>">
</div>

<div class="Clear"></div>

</div>


</form>

<script type="text/javascript">

function fillUnitId(val){
		if(val != "")
		{
			var index1 = val.lastIndexOf("[");
			var indexForUnitName= index1;
			var index2 = val.lastIndexOf("]");
			index1++;
			var unitId = val.substring(index1,index2);
			var indexForUnitName = indexForUnitName--;
			var UnitName = val.substring(0,indexForUnitName);
			document.getElementById('unitId').value = unitId;
			
}
}
</script>
<script type="text/javascript">

function validateCollected(){
var msg="";
var count=document.getElementsByName('dispatch').length;
		 for(var i = 0; i < document.getElementsByName('dispatch').length; i++){
		 
			  if(document.getElementsByName('dispatch')[i].checked == true )
              { 
				count=count-1
				//alert("Please Collect atleast one Sample....")
				//return false;
			}		
  		}
  		 if(count == document.getElementsByName('dispatch').length )
              { 
				
				alert("Please Collect atleast one Record...")
				return false;
			}	
  		 if(msg != ""){
			 	alert(msg);
			 	return false;
		}
		return true;
		
	}
			function displayAddress(){
				var unit = document.getElementById('unitId').value;
				document.getElementById('unitAddId').style.display = 'inline';
				if(unit != 0){
				if(unit != 'Other'){
				
				<%
					 for(MasUnit masUnit : unitList){
				%>
						var unit1 = '<%=masUnit.getId()%>';
						if(unit == unit1){
						
							document.coveringLetterUnit.unitAdd.value = "<%=masUnit.getUnitAddress()%>"
						 }
			<%}%>}else if(unit == 'Other'){
						
						document.getElementById('unitAddId').style.display = 'none';
					}
				}
			}
		</script>