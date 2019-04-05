<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<br />
<div id="contentholder"><script type="text/javascript"
	language="javascript">
	<%
	
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
			
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script> <%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");	 
	String currentTime = (String)utilMap.get("currentTime");

	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	String message = "";
	if(map.get("message") != null){
		message = (String)map.get("message");
	}
	%> <%if(!message.equals("")){ %>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<label style="width: 100%; text-align: center;"><span><%=message%></span></label>
<div class="division"></div>
<%} %>
<form name="search" method="post" action="">
<h6 style="padding: 0px 0px 13px 0px;">Labour Room</h6>
<div class="Clear"></div>
<label class="bodytextB">Service No.:</label> <input type="text"
	id="serviceNo." name="<%=SERVICE_NO%>" value="" class="textbox_date"
	MAXLENGTH="30"
	onblur="getHinNo('search','registration?method=getHinNoForUpdateAdt&flag=admission')" />
<div id="hinDiv"><label class="bodytextB"> Hin:</label> <input
	type="text" name="<%=HIN_NO%>" value="" class="textbox_date"
	MAXLENGTH="30"
	onchange="submitProtoAjax('search','adt?method=getAdmissionNoList&flag=admission')" />
</div>
<div id="testDiv"><label class="bodytextB">Admission No: </label>
<input type="text" name="<%=AD_NO %>" value="" class="textbox_date"
	MAXLENGTH="30" validate="Admission No,String,yes" /></div>
<br />
<br />

<input type="button" name="Search" value="Search" class="cmnButton"
	onClick="submitForm('search','opd?method=showDetailsForLabourRoom');" />
<input type="reset" name="Reset" value="Cancel" class="cmnButton"
	accesskey="r" /></form>


</div>





