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



<script type="text/javascript" language="javascript">
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
<div id="contentHolder">
<h6>Update Patient Registration</h6>
<form name="search" method="post" action="">

<div class="Clear"></div>
<div class="blockFrame"><label>Service No.</label> <input
	type="text" id="serviceNo." name="<%=SERVICE_NO%>" value=""
	MAXLENGTH="30"
	onblur="getHinNo('search','registration?method=getHinNoForUpdateAdt&flag=registration')" />

<div id="hinDiv"><label>Hin:</label> <input type="text"
	name="<%=HIN_NO%>" value="" MAXLENGTH="30"
	onchange="submitProtoAjax('search','registration?method=getPatientName')"
	validate="Hin ,String,yes" /></div>
<div id="testDiv"></div>
<div class="Clear"></div>
</div>
<div class="Clear"></div>

<input type="button" name="Search" value="Search" class="button"
	onClick="submitForm('search','/hms/hms/registration?method=showUpdateRegistrationJsp');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	accesskey="r" /></form>


</div>





