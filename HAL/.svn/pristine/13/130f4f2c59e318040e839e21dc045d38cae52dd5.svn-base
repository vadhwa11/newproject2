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

<h6 align="left">Update Patient Admission</h6>
<div class="Clear"></div>
<div class="blockFrame">
<form name="search" method="post" action=""><label
	class="bodytextB">Service No.:</label> <input type="text"
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
	MAXLENGTH="30" /></div>

</form>
</div>
<div class="Clear"></div>

<input type="button" name="Search" value="Search" class="button"
	onClick="submitForm('search','adt?method=showUpdateAdmissionJsp');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	accesskey="r" />
<div class="Clear"></div>
</div>





