<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MdContigentMedicalBillHd"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.MdCoveringLetterUnitDt"%>
<%@page import="jkt.hms.masters.business.MdCoveringLetterUnitHd"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<%@page import="java.net.URL"%>


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
	int coveringLetterId=0;
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
		List<MdCoveringLetterUnitHd> coveringLetterHdList = new ArrayList<MdCoveringLetterUnitHd>();
		 List<MdCoveringLetterUnitDt> coveringLetterDtList = new ArrayList<MdCoveringLetterUnitDt>();
		if(map.get("coveringLetterHdList") != null){
			coveringLetterHdList = (List<MdCoveringLetterUnitHd>)map.get("coveringLetterHdList");
		}
		if(map.get("coveringLetterDtList") != null){
			coveringLetterDtList = (List<MdCoveringLetterUnitDt>)map.get("coveringLetterDtList");
		}
		MdCoveringLetterUnitHd coveringLetterUnitHd = new MdCoveringLetterUnitHd();
		if(coveringLetterHdList != null && coveringLetterHdList.size()>0){
			coveringLetterUnitHd = coveringLetterHdList.get(0);	
		}
		if(map.get("patientList") != null){
			patientList= (List<Patient>)map.get("patientList");
		}
		if(map.get("coveringLetterId") != null){
			coveringLetterId=(Integer)map.get("coveringLetterId");
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
<div id="contentHolder">
<h6>Update Covering Letters to Unit</h6>
<div class="Clear"></div>
<div class="blockFrame" id="testDiv"><input type="hidden"
	name="pageNo" id="pageNo" value="<%=pageNo%>" /> <%
		String entrySeqNo="";
		if(map.get("entrySeqNo") != null){
			entrySeqNo = (String)map.get("entrySeqNo");
		}
%> <label>Entry No</label> <input id="entryNoId" type=hidden
	name="<%=ENTRY_NO %>" value="<%=coveringLetterUnitHd.getEntryNo() %>"
	title="Entry No" /> <label class="value"><%=coveringLetterUnitHd.getEntryNo() %></label>
<input type="hidden" id="coveringLetterId" name="coveringLetterId"
	value="<%= coveringLetterId%>" /> <label>Entry Date</label> <%if(coveringLetterUnitHd.getEntryDate() != null){ %>
<label><%= HMSUtil.convertDateToStringWithoutTime(coveringLetterUnitHd.getEntryDate()) %>
</label> <%}else{ %> <label> - </label> <%} %>
<div class="Clear"></div>
<label>Unit Name</label> <%if(coveringLetterUnitHd.getUnit() != null){ %>
<label><%=coveringLetterUnitHd.getUnit().getUnitName() %></label> <%}else{ %>
<label> --</label> <%} %> <label>Dispatch Date</label> <%if(coveringLetterUnitHd.getDispatchDate() != null){ %>
<input type="text" class="calDate" id="lastDateId"
	name="<%=DISPATCH_DATE %>"
	value="<%= HMSUtil.convertDateToStringWithoutTime(coveringLetterUnitHd.getDispatchDate()) %>"
	validate="Dispatch Date,date,no" MAXLENGTH="10" /> <%}else{ %> <input
	type="text" class="calDate" id="lastDateId" name="<%=DISPATCH_DATE %>"
	value="" validate="Dispatch Date,date,no" MAXLENGTH="10" /> <%} %> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.coveringLetterUnit.<%=DISPATCH_DATE%>,event)" />
<div class="Clear"></div>
<label> Unit Address</label> <input id="unitAddress"
	name="<%=UNIT_ADDRESS %>" type="text" value="" readonly="readonly" />



<input type="hidden" size="2" value="" name="noOfRecords"
	id="noOfRecords" /></div>

<div class="Clear"></div>
<div class="division"></div>
<div class="blockTitle">Reimbursement of medical claim pending for
dispatch</div>
<div class="blockTitleCurve"></div>

<div class="tableHolderAuto">

<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="chargeDetails">
	<thead>
		<tr>
			<th scope="col">Select</th>
			<th scope="col">Service No</th>
			<th scope="col">Rank</th>
			<th scope="col">Patient</th>
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
	for(MdCoveringLetterUnitDt mdContigentMedicalBillHd :coveringLetterDtList){
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
		amount=mdContigentMedicalBillHd.getContingentHd().getAmount();
		
		List<MdCoveringLetterUnitDt> coveringLetterDtList1= new ArrayList<MdCoveringLetterUnitDt>();
		if(map.get("coveringLetterDtList")!=null){
			coveringLetterDtList1=(List<MdCoveringLetterUnitDt>)	map.get("coveringLetterDtList");
		}
	     if(coveringLetterDtList1!= null && coveringLetterDtList1.size()>0){
	    	 for(MdCoveringLetterUnitDt coveringLetterUnitDt:coveringLetterDtList1){
			  inc++; 
	%>

		<tr>
			<td><input id="selectId<%=inc %>" name="<%=DISPATCH %>"
				type="checkBox" value="<%=mdContigentMedicalBillHd.getId()%>"
				class="check" /> <input id="serviceNo<%=inc %>"
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


		</tr>
		<%}}} %>

	</tbody>
</table>
<input type="hidden" value="<%=inc %>" name="hiddenValueCharge"
	id="hiddenValueCharge" /></div>
<div class="Height10"></div>
<div class="Clear"></div>
<!--Bottom labels starts-->
<div class="bottom">
<div class="division"></div>
<input type="button" class="button" value="Add"
	onclick="submitForm('coveringLetterUnit','mediClaim?method=submitCoveringletter');"
	align="right" /> <input type="reset" class="button" name="Reset"
	id="reset" value="Reset"
	onclick="resetClicked('coveringLetterUnit',<%=inc %>);" accesskey="r" />
<div class="division"></div>

<label>Changed By</label> <input type="hidden" value="<%=userName %>"
	name="CHANGED_BY" /> <label class="value"><%=userName%></label> <label>Changed
Date</label> <input type="hidden" value="<%=currentDate %>" name="CHANGED_DATE" />
<label class="value"><%=currentDate%></label> <label>Changed
Time</label> <input type="hidden" value="<%=time %>" name="CHANGED_TIME" /> <label
	class="value"><%=time%></label>

<div class="Clear"></div>
<input type="hidden" name="counter" value=""></div>
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