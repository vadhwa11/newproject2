<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>



<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

<div id="contentHolder"><script type="text/javascript"
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
	</script>

<div class="floatLeft">
<h6>IP Billing</h6>
</div>
<div class="Clear"></div>
<form name="search" method="post" action=""><label>Service
No.</label> <input type="text" id="serviceNo" name="<%=SERVICE_NO%>" value=""
	MAXLENGTH="30"
	onblur="getHinNo('search','billing?method=getHinNoForBilling&flag=billing');" />
<div id="hinDiv"><label> Hin:</label> <input type="text"
	name="<%=HIN_NO%>" value="" MAXLENGTH="30"
	onblur="submitProtoAjax('search','billing?method=getAdNo&flag=billing');" />
</div>
<div id="testDiv"><label> Admission No:</label> <input type="text"
	name="<%=AD_NO%>" value="" MAXLENGTH="30"
	onblur="submitForm('search','billing?method=getPatientDetails');" /></div>
</form>
<div class="division"></div>

<%
			Map<String,Object> map = new HashMap<String,Object>();
			String includedJsp ="";
			if (request.getAttribute("map") != null) {
				map = (Map<String,Object>) request.getAttribute("map");
			}
			if(map.get("includedJsp") != null){
				includedJsp = (String)map.get("includedJsp");
			}
			
			if(!includedJsp.equals("")){
			%> <jsp:include page="<%=includedJsp%>" flush="true" /> <%} %>
</div>





