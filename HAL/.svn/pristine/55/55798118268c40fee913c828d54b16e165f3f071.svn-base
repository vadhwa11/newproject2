<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MdContigentMedicalBillHd"%>
<%@page import="java.math.BigDecimal"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>


<form name="coveringLetterUnit" method="post" action=""><script
	type="text/javascript">
		history.forward();
</script> <script>
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
</script> <%
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
		List<Patient> patientList = new ArrayList<Patient>();
		List<MdContigentMedicalBillHd> continegentList = new ArrayList<MdContigentMedicalBillHd>();
		if(map.get("continegentList") != null){
			continegentList = (List<MdContigentMedicalBillHd>)map.get("continegentList");
		}
		if(map.get("patientList") != null){
			patientList= (List<Patient>)map.get("patientList");
		}
		
%>
<div id="contentHolder">
<h6>General Claim-Covering letter Amount > Rs. 10,000</h6>
<div class="Clear"></div>
<div class="blockFrame" id="testDiv"><input type="hidden"
	name="pageNo" id="pageNo" value="<%=pageNo%>" /> <%
		String entrySeqNo="";
		if(map.get("entrySeqNo") != null){
			entrySeqNo = (String)map.get("entrySeqNo");
		}
%> <label>Entry No</label> <input id="entryNoId" type=hidden
	name="<%=ENTRY_NO %>" value="<%=entrySeqNo %>" title="Entry No" /> <label
	class="value"><%=entrySeqNo %></label> <label><span>*</span>Entry
Date</label> <input type="text" class="calDate" id="fromDateId"
	name="<%=ENTRY_DATE %>" value="<%=currentDate %>" readonly="readonly"
	MAXLENGTH="30" validate="Entry Date,date,yes" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.coveringLetterUnit.<%=ENTRY_DATE%>,event)" />

<div class="Clear"></div>

<label><span>*</span>From</label> <textarea value="" name="<%=FROM%>"
	id="from" onkeyup="chkLength(this,50);" validate="From,string,yes"
	MAXLENGTH="50"></textarea> <label><span>*</span>To</label> <textarea
	value="" name="<%=TO%>" id="to" onkeyup="chkLength(this,50);"
	validate="To,string,yes" MAXLENGTH="50"></textarea>

<div class="Clear"></div>
<label><span>*</span>Dispatch Date</label> <input type="text"
	class="calDate" id="fromDateId" name="<%=DISPATCH_DATE %>"
	value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30"
	validate="Dispatch Date,date,yes" /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.coveringLetterUnit.<%=DISPATCH_DATE%>,event)" />

<input type="hidden" size="2" value="" name="noOfRecords"
	id="noOfRecords" /></div>

<div class="Clear"></div>
<div class="division"></div>
<%				
				if(continegentList.size() == 0){
				out.println("No Record!");
							}else{
	%>
<div class="tableHolderAuto">

<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="chargeDetails">
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
			<td><input id="despatchId<%=inc %>" name="dispatch"
				type="checkBox" value="y" class="check" /> <input
				id="contingentHdId<%=inc %>" name="<%=CONTINGENT_BILL_HD_ID %>"
				type="hidden" value="<%=mdContigentMedicalBillHd.getId()%>" /></td>
			<td><input id="hinId<%=inc %>" name="<%=HIN_ID %>" type="hidden"
				value="<%=hinId%>" /> <input id="serviceNo<%=inc %>"
				name="<%=SERVICE_NO %>" type="text" value="<%=serviceNo%>"
				readonly="readonly" /></td>
			<td><input id="rankId<%=inc %>" name="<%=RANK_NAME %>"
				type="text" value="<%=rankName%>" readonly="readonly" /></td>
			<td><input id="patientName<%=inc %>" name="<%=PATIENT_NAME %>"
				type="text"
				value="<%= mdContigentMedicalBillHd.getHin().getPFirstName()+" "+middleName+" "+lastName%>"
				readonly="readonly" /></td>
			<td><input id="amount<%=inc %>" name="<%=AMOUNT %>" type="text"
				value="<%=amount%>" readonly="readonly" /></td>

			<%} %>
		</tr>
		<input type="hidden" name="counter" value=<%=inc %>>
		<input type="hidden" value="<%=inc %>" name="hiddenValueCharge"
			id="hiddenValueCharge" />
		<% }%>
	</tbody>
</table>

<div class="Height10"></div>
<div class="Clear"></div>
<!--Bottom labels starts-->
<div class="bottom">
<div class="division"></div>
<%if(continegentList.size() >0){%> <input type="button" class="button"
	value="Submit"
	onclick="if(validateCollected())submitForm('coveringLetterUnit','mediClaim?method=submitGeneralCoveringletter');"
	align="right" /> <input type="reset" class="button" name="Reset"
	id="reset" value="Reset" onclick="resetClicked('coveringLetterUnit');"
	accesskey="r" /> <%} %>
<div class="division"></div>

<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=currentDate%></label> <label>Changed
Time</label> <label class="value"><%=time%></label>

<div class="Clear"></div>

</div>

</div>
</div>
</form>


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
	
	function chkLength(field,maxLimit)
	{
	if(field.value.length > maxLimit)
	{
	 alert('Maximum Limit is '+maxLimit+' characters.');
	 var val=field.value.substring(0,maxLimit);
	 field.value=val;
	}
}
	</script>