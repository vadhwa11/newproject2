
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.HrDutyMaster"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.*"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
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
<h6>Update Arrival Service Personnel Details</h6>
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
				
				List<HrDutyMaster> dutyList = new ArrayList<HrDutyMaster>();
				List<MasEmployee>employeeList=new ArrayList<MasEmployee>();
				List<HrSpecialistMaster>specialityList=new ArrayList<HrSpecialistMaster>();
				List<HrClassMaster>classificationList=new ArrayList<HrClassMaster>();
				
				String entryNo="";
				int hospitalId=0;
				
				if (session.getAttribute("hospitalId") != null) 
				{
					Integer temp =  (Integer)session.getAttribute("hospitalId");
					hospitalId = temp.intValue();
				}
		
				if(request.getAttribute("map") != null){
					map = (Map<String, Object>)request.getAttribute("map");
				}
				if(map.get("employeeList") != null){
					employeeList= (List<MasEmployee>)map.get("employeeList");
				}
				if(map.get("dutyList") != null){
					dutyList= (List<HrDutyMaster>)map.get("dutyList");
				}
				if(map.get("specialityList") != null){
					specialityList= (List<HrSpecialistMaster>)map.get("specialityList");
				}
				if(map.get("classificationList") != null){
					classificationList= (List<HrClassMaster>)map.get("classificationList");
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
		

	</script>



<form name="updateArrivalEntry" action="" method="post">

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


<%} %>
</div>
<div class="division"></div>
<div class="blockFrame"><label><span>*</span> Speciality</label> <select
	name="specialityId" id="specialityId" validate="Speciality,String,yes">
	<option value="">Select</option>
	<%for(HrSpecialistMaster hrSpecialistMaster:specialityList){ %>
	<option value="<%=hrSpecialistMaster.getId()%>"><%=hrSpecialistMaster.getSpecialistName()%></option>
	<%} %>
</select> <label><span>*</span> Classification</label> <select
	name="classificationId" id="classificationId"
	validate="Classification,String,yes">
	<option value="">Select</option>
	<%for(HrClassMaster hrorderlyClassificationMaster:classificationList){ %>
	<option value="<%=hrorderlyClassificationMaster.getId()%>"><%=hrorderlyClassificationMaster.getClassName()%></option>
	<%} %>
</select></div>
<input type="hidden" name="hospitalId" value="<%=hospitalId%>" />
<div class="Clear"></div>

<!--table-->
<div class="division"></div>
<div class="bottom"><input name="submitButton" type="button"
	class="button" value="Submit"
	onclick="submitForm('updateArrivalEntry','hrRelated?method=submitUpdateArrivalEntry');" />
<input name="Button" type="reset" class="button" value="Reset" /> <input
	name="cancelButton" type="button" class="button" value="Cancel"
	onclick="submitForm('updateArrivalEntry','hrRelated?method=showUpdateArrivalSearchJsp');" />
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
<!--Bottom labels starts--></form>
<!--main content placeholder ends here--></div>




