<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MdMasAuthority"%>
<%@page import="jkt.hms.masters.business.MdCardicContingentBillHd"%>
<%@page import="jkt.hms.masters.business.MdCardicContingentBillDt"%>
<%@page import="jkt.hms.masters.business.MdBillMovement"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<%@page import="java.net.URL"%>


<form name="cardicMovementBill" method="post" action=""><script
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
 	List<MdCardicContingentBillHd> cardicBillList = new ArrayList<MdCardicContingentBillHd>();
	List <MdMasAuthority> authorityList=new ArrayList<MdMasAuthority>();
	 List<MdBillMovement> billMovementList = new ArrayList<MdBillMovement>();
	List<Patient> patientList = new ArrayList<Patient>();
	
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");
	String userName="";
	int hospitalId=0;
	int contingentHdID=0;
	int hinId=0;
	
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
		if(detailsMap.get("cardicBillList") != null){
			cardicBillList=(List<MdCardicContingentBillHd>)detailsMap.get("cardicBillList");
		}
		
		if(map.get("authorityList") != null){
			authorityList=(List<MdMasAuthority>)map.get("authorityList");
		}
		
		MdCardicContingentBillHd cardicContingentBillHd= new MdCardicContingentBillHd();
		Set<MdCardicContingentBillDt> cardicContingentBillDtSet = new HashSet<MdCardicContingentBillDt>();
		if(cardicBillList.size() > 0) {
			cardicContingentBillHd = (MdCardicContingentBillHd) cardicBillList.get(0);
			
			hinId =cardicContingentBillHd.getHin().getId();
			cardicContingentBillDtSet = cardicContingentBillHd.getMdCardicContingentBillDts();
		}
		
		if(detailsMap.get("billMovementList") != null){
			billMovementList=(List<MdBillMovement>)detailsMap.get("billMovementList");
		}
		System.out.println("billMovementList in JSp  :"+billMovementList.size());
		if(map.get("contingentHdID") != null){
			contingentHdID=(Integer)map.get("contingentHdID");
		}
		
		contingentHdID=cardicContingentBillHd.getId() ;
%>
<div class="titlebg">
<h2>Contingent bill movement entry</h2>
</div>


<div class="Block">
<h4>Service Personnel Details</h4>

<div class="Clear"></div>

<input type="hidden"	name="serviceNo"	value="<%=cardicContingentBillHd.getHin().getServiceNo()%>"> <label>Service
No.</label> <label class="value"><%=cardicContingentBillHd.getHin().getServiceNo()%></label>

<label>HIN </label> <label class="value"><%=cardicContingentBillHd.getHin().getHinNo()%></label>

<label>First Name</label> <label class="value"><%=cardicContingentBillHd.getHin().getSFirstName() %></label>

<div class="Clear"></div>

<label>Last Name</label> <%if(cardicContingentBillHd.getHin() != null){%>
<label class="value">&nbsp;<%=cardicContingentBillHd.getHin().getSLastName() %></label>
<%}else{ %> 
<label class="value">-</label> <%} %> <label>Rank </label> <%if(cardicContingentBillHd.getHin().getRank() !=null){ %>
<label class="value"><%=cardicContingentBillHd.getHin().getRank().getRankName()%></label>
<%}else{ %> <label class="value"> - </label> <%} %> 


<label>Unit </label> <%if(cardicContingentBillHd.getHin().getUnit() !=null){ %>
<label class="value"><%=cardicContingentBillHd.getHin().getUnit().getUnitName()%></label>
<%}else{ %> <label class="value"> - </label> <%} %> <input type="hidden"
	value="<%=contingentHdID%>" name="<%=CONTINGENT_BILL_HD_ID %>" />
<div class="Clear"></div>
<%
			System.out.println("contingent id::"+contingentHdID);
			int inpatientId =0;
			String flag = "";
			Set<Inpatient> set = new HashSet<Inpatient>();
			set = cardicContingentBillHd.getHin().getInpatients();
			for(Inpatient inpatient : set){
				if(inpatient.getAdStatus().equals("A")){
					inpatientId = inpatient.getId();
				}
%> <input type="hidden" name="<%=INPATIENT_ID %>"
	value="<%=inpatient.getId()%>" /> <input type="hidden"
	name="<%=DEPARTMENT_ID %>"
	value="<%=inpatient.getDepartment().getId() %>" /> <input
	type="hidden" name="<%=HIN_ID %>"
	value="<%=cardicContingentBillHd.getHin().getId() %>" /> <%}%>
</div>



<div class="Clear"></div>

<h4>Bill Details</h4>

<div class="Block">


<label><span>*</span>Bill No</label> <select
	name="<%= BILL_NO %>" validate="Bill No,string,yes" tabindex=1
	onchange="fillBill(this.value);">
	<option value="">Select</option>
	<%				
					for(MdCardicContingentBillDt cardicContingentBillDt :cardicContingentBillDtSet){
						%>
	<option value="<%=cardicContingentBillDt.getId ()%>"><%=cardicContingentBillDt.getBillNo()%></option>
	<%}%>
</select> <script type="text/javascript">
				function fillBill(obj){
				
					<%	for(MdCardicContingentBillDt cardicContingentBillDt :cardicContingentBillDtSet){
										%>
										var invObj =<%= cardicContingentBillDt.getId()%>
										if(invObj == obj){
 								
 							document.getElementById('billDate').value="<%=HMSUtil.convertDateToStringWithoutTime(cardicContingentBillDt.getBillDate())%>"
 							document.getElementById('amount').value="<%=cardicContingentBillDt.getAmount()%>"
 							document.getElementById('contingentDtID').value="<%=cardicContingentBillDt.getId()%>"
 							}
 					<%
 						} %>	
 						}
 			</script> <label>Bill Date</label> <input type="text" id="billDate"
	name=<%=BILL_DATE %> value="" readonly="readonly" /> <input
	type="hidden" id="contingentDtID" name=<%=CONTINGENT_BILL_DT_ID %>
	value="" readonly="readonly" /> 
	
	
<label>Bill Amount</label> <input
	type="text" id="amount" name=<%=AMOUNT %> value="" readonly="readonly" />

</div>


<div class="Clear"></div>

<div class="cmntable">

<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="chargeDetails">
	<thead>
		<tr>
			<th scope="col">Bill FWT To</th>
			<th scope="col">Bill FWT Date</th>
		</tr>
	</thead>
	<tbody>

		<%
	if(billMovementList.size() > 0){
		for(MdBillMovement billMovement:billMovementList){
	
	%>

		<tr>
			<td><input type="text"
				value="<%=billMovement.getFwtTo().getAuthorityName() %>"
				name="<%=FWT_TO %>" id="authorityId" disabled="disabled" /></td>
			<td><input type="text"
				value="<%=HMSUtil.convertDateToStringWithoutTime(billMovement.getFwtDate()) %>"
				name="<%=FWT_DATE %>" id="fwtDate" disabled="disabled" /></td>

		</tr>
		<%	}
	}else{ %>
		<tr>
			<td><input type="text" value="" name="<%=FWT_TO %>"
				id="authorityId" disabled="disabled" /></td>
			<td><input type="text" value="" name="<%=FWT_DATE %>"
				id="fwtDate" disabled="disabled" /></td>

		</tr>
		<%} %>
	</tbody>
</table>
</div>


<div class="Clear"></div>

<div class="Block">

<label class=""><span>*</span>FWT To</label> 
<select name="<%= FWT_TO %>" validate="FWT To,string,yes"
	tabindex=1>
	<option value="">Select</option>
	<% 
				
				for (MdMasAuthority  masAuthority : authorityList){
				%>
	<option value="<%=masAuthority.getId ()%>"><%=masAuthority.getAuthorityName()%></option>

	<%}%>
</select> <label><span>*</span> FWT Date</label> <input type="text"
	class="calDate" id="fromDateId" name="<%=DATE %>"
	value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30"
	validate="FWT Date,date,yes" /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.cardicMovementBill.<%=DATE%>,event)" />



<label CLASS=""><span>*</span> Letter/document No.</label> <input
	type="text" id="documnetNo" name=<%=DOCUMENT_NO %> value=""
	validate="Letter/document No.,string,yes" maxlength="50" /> 
	
	
<div class="Clear"></div>
	
<label>Bill Status</label> <select name="<%= BILL_STATUS %>"
	validate="Bill Status,string,yes" tabindex=1>
	<option value="o">Open</option>
	<option value="c">Close</option>
</select>
<div class="Clear"></div>
</div>

<div class="Clear paddingTop15"></div>


<div class="division"></div>
<input type="button" class="button" value="Submit"
	onclick="submitForm('cardicMovementBill','mediClaim?method=submitCardicBillMovement');"
	align="right" /> <input type="reset" class="button" name="Reset"
	id="reset" value="Reset" onclick="resetClicked('cardicMovementBill');"
	accesskey="r" />
<div class="Clear paddingTop15"></div>
<div class="bottom">
<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=currentDate%></label> <label>Changed
Time</label> <label class="value"><%=time%></label>

<div class="Clear"></div>
</div>
</div>
</form>
<script>
function bill(obj){
var errorMessage= "" ;
	var billNo = 0;
	if(document.getElementById('billNo').value ==0)
	errorMessage=errorMessage+"Please Select Bill No \n"; 
	
	billNo=document.getElementById('billNo').value;
	billDate=document.getElementById('billDate').value;