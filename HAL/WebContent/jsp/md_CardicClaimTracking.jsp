<%@page import="jkt.hms.masters.business.MdBillMovement"%>

<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>


<form name="contingentBill" method="post" action=""><script
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
	List<MdBillMovement> billMovementList = new ArrayList<MdBillMovement>();
	MdBillMovement billMovement= new MdBillMovement();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");
	String userName="";
	int hospitalId=0;
	int billMovementID=0;
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
		if(map.get("billMovementList") != null){
			billMovementList=(List)map.get("billMovementList");
		}
		if(billMovementList != null) {
			billMovement = (MdBillMovement) billMovementList.get(0);
				hinId =billMovement.getHin().getId();
		}
		List<Patient> patientList = new ArrayList<Patient>();
		if(map.get("patientList") != null){
			patientList= (List<Patient>)map.get("patientList");
		}
		if(map.get("billMovementID") != null){
			billMovementID=(Integer)map.get("billMovementID");
		}
%>
<div id="contentHolder">
<h6>Bill Detail Status</h6>
<div class="Clear"></div>
<div class="blockFrame" id="testDiv"><label>Service No.</label> <label
	class="value"><%=billMovement.getContingentHd().getHin().getServiceNo()%></label>

<label>HIN.</label> <label class="value"><%=billMovement.getContingentHd().getHin().getHinNo()%></label>

<div class="Clear"></div>

<label>First Name</label> <label class="value"><%=billMovement.getContingentHd().getHin().getPFirstName()%></label>

<label>Last Name</label> <%if(billMovement.getContingentHd().getHin() != null){ %>
<label class="value">&nbsp; <%=billMovement.getContingentHd().getHin().getPLastName()%></label>
<%}else{ %> <label> - </label> <%} %>

<div class="Clear"></div>

<label>Rank </label> <%if(billMovement.getContingentHd().getHin().getRank() !=null){ %>
<label class="value"><%=billMovement.getContingentHd().getHin().getRank().getRankName()%></label>
<%}else{ %> <label class="value"> - </label> <%} %> <label>Unit </label> <%if(billMovement.getContingentHd().getHin().getUnit() !=null){ %>
<label class="value"><%=billMovement.getContingentHd().getHin().getUnit().getUnitName()%></label>
<%}else{ %> <label class="value"> - </label> <%} %>

<div class="Clear"></div>
</div>

<div class="Clear"></div>
<div class="division"></div>
<div class="blockFrame"><label>Procedure Name</label> <%if(billMovement.getContingentHd().getCardicAdvance()!=null){ %>
<label class="valueNoWidth"><%=billMovement.getContingentHd().getCardicAdvance().getCdaName()%></label>
<%}else{ %> <label class="valueNoWidth"> - </label> <%} %> <label>Cost
of procedure</label> <%if(billMovement.getContingentHd().getCardicAdvance()!=null){ %>
<label class="value"><%=billMovement.getContingentHd().getCardicAdvance().getTreatmentDetail()%></label>
<%}else{ %> <label class="value">-</label> <%} %> <label>Name of
Hospital</label> <%if(billMovement.getContingentHd().getCardicAdvance() !=null){ %>
<label class="valueNoWidth"><%=billMovement.getContingentHd().getCardicAdvance().getPayableTo().getHospitalName()%></label>
<%}else{ %> <label class="valueNoWidth"> - </label> <%} %>
<div class="Clear"></div>
<label>FWD DGMS date</label> <%if(billMovement.getContingentHd().getCardicAdvance()!=null){ %>
<label class="valueNoWidth"><%= HMSUtil.convertDateToStringWithoutTime(billMovement.getContingentHd().getCardicAdvance().getDgmsDispatchDate()) %></label>
<%}else{ %> <label class="valueNoWidth"> - </label> <%} %> <label>FWD
CGA date</label> <%if(billMovement.getFwtDate()!=null){ %> <label class="value"><%= HMSUtil.convertDateToStringWithoutTime(billMovement.getFwtDate()) %></label>
<%}else{ %> <label class="value"> - </label> <%} %>
</div>

</div>
</form>

