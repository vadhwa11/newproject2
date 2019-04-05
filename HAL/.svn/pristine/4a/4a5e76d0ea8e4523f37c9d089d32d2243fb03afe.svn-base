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

<h6>Fatal Document Panchnama</h6>
<div class="Clear"></div>

<form name="fatalDocumentPanchnamaReport" target="_blank" method="post"
	action="">
<div class="blockFrame"><label>Service No.:</label> <input
	type="text" id="serviceNo." name="<%=SERVICE_NO%>" value="" class=""
	MAXLENGTH="30"
	onblur="getHinNo('fatalDocumentPanchnamaReport','mis?method=getHinAdNoFatalPanchanama&flag=hin')" />
<div id="hinDiv"><label>Hin No:</label> <input type="text"
	name="<%=HIN_NO%>" value="" class="" MAXLENGTH="30" validate="Hin,,yes"
	onchange="submitProtoAjaxWithDivName('fatalDocumentPanchnamaReport','mis?method=getAdmissionNoList&flag=admission','testDiv')" />
</div>
<div id="testDiv"><label>Ad No:</label> <input type="text"
	id="frwSlno" name="<%=AD_NO%>" value="" MAXLENGTH="30" /></div>
</div>
<div class="Clear"></div>

<input type="button" name="OK" value="OK" class="button"
	onClick="submitForm('fatalDocumentPanchnamaReport','mis?method=showFatalDocumentPanchnamaReport');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" /></form>
</div>





