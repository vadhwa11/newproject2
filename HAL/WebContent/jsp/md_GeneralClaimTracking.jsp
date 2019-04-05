<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MdContigentMedicalBillHd"%>
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
	List<MdContigentMedicalBillHd> contingentHdList = new ArrayList<MdContigentMedicalBillHd>();
	MdContigentMedicalBillHd contigentMedicalBillHd= new MdContigentMedicalBillHd();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");
	String userName="";
	int hospitalId=0;
	int contingenthdId=0;
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
		if(map.get("contingentHdList") != null){
			contingentHdList=(List)map.get("contingentHdList");
		}
		if(contingentHdList != null) {
			contigentMedicalBillHd = (MdContigentMedicalBillHd) contingentHdList.get(0);
				hinId =contigentMedicalBillHd.getHin().getId();
		}
		List<Patient> patientList = new ArrayList<Patient>();
		if(map.get("patientList") != null){
			patientList= (List<Patient>)map.get("patientList");
		}
		if(map.get("contingenthdId") != null){
			contingenthdId=(Integer)map.get("contingenthdId");
		}
%>
<form name="contingentBill" method="post" action="">
<div class="titlebg">
<h2>Bill Movement Status</h2>
</div>

<div class="Block" >

<label>Service No.</label> <label
	class="value"><%=contigentMedicalBillHd.getHin().getServiceNo()%></label>

<label>HIN</label> <label class="value"><%=contigentMedicalBillHd.getHin().getHinNo()%></label>


<label>First Name</label> <label class="value"><%=contigentMedicalBillHd.getHin().getPFirstName()%></label>

<div class="Clear"></div>
<label>Last Name</label>
<% if(contigentMedicalBillHd.getHin().getPLastName() !=null){ %>
<label class="value"><%=contigentMedicalBillHd.getHin().getPLastName()%></label>
<%}else{ %><label class="value"></label>
<%} %>


<label>Rank </label> <%if(contigentMedicalBillHd.getHin().getRank() !=null){ %>
<label class="value"><%=contigentMedicalBillHd.getHin().getRank().getRankName()%></label>
<%}else{ %> <label> - </label> <%} %>

<label>Unit </label> <%if(contigentMedicalBillHd.getHin().getUnit() !=null){ %>
<label class="value"><%=contigentMedicalBillHd.getHin().getUnit().getUnitName()%></label>
<%}else{ %> <label class="value"> - </label> <%} %> 

<div class="Clear"></div>

<label>Bill No </label>
<%if(contigentMedicalBillHd.getBillNo()!=null){ %> <label class="value"><%=contigentMedicalBillHd.getBillNo()%></label>
<%}else{ %> <label class="value"> - </label> <%} %> 

<label>Bill Date
</label> <%if(contigentMedicalBillHd.getBillDate()!=null){ %> <label class="value"><%=HMSUtil.convertDateToStringWithoutTime(contigentMedicalBillHd.getBillDate())%></label>
<%}else{ %> <label class="value"> - </label> <%} %>



<label>Bill Amount </label> <%if(contigentMedicalBillHd.getAmount()!=null){ %>
<label class="value"><%=contigentMedicalBillHd.getAmount()%></label> <%}else{ %>
<label class="value"> - </label> <%} %>
</div>
<div class="division"></div>
<%				
				if(contingentHdList.size() == 0){
				out.println(" No Record Found!");
							}else if(contingentHdList.size() > 0){
	%>
<div class="tableHolderAuto">

<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="chargeDetails">
	<thead>
		<tr>
			<th scope="col">Bill FWT To</th>
			<th scope="col">Bill FWT Date</th>
			<th scope="col">Document No</th>
		</tr>
	</thead>
	<tr>
		<td>
		<%if(contigentMedicalBillHd.getFwtTo()!=null ){ %>
		<input type="text"
			value="<%=contigentMedicalBillHd.getFwtTo().getAuthorityName()%>"
			name="<%=FWT_TO %>" readonly="readonly" />
			
			<%}else { %>
		<input type="text"
			value=""
			name="<%=FWT_TO %>" readonly="readonly" />	
			<%} %></td>
		<td><input type="text"
			value="<%=HMSUtil.convertDateToStringWithoutTime(contigentMedicalBillHd.getFwtDate())%>"
			name="<%=FWT_DATE %>" readonly="readonly" /></td>
		<td><input type="text"
			value="<%=contigentMedicalBillHd.getEntryNo()%>" name="<%=ENTRY_NO%>"
			readonly="readonly" /></td>
	</tr>
	<%} %>
</table>
</div>
</div>
</form>

