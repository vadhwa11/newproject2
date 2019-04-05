
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<div id="contentHolder"><script type="text/javascript"
	language="javascript">
	<%
	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}
	String serviceNo="";
	if (map.get("serviceNo") != null) {
		serviceNo = (String) map.get("serviceNo");
	}
	
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
	</script> <script type="text/javascript" language="javascript">
	function checkForServiceNo(serviceNo){
	
	if(serviceNo==""){
		return true
	}else{
	getHinNo('search','adt?method=getAdmissionNoList&flag=hin')
	
	}
	}
	</script>
	<div class="titleBg">
<h2>SIL/DIL Form</h2>
</div>
<div class="Clear"></div>

<form name="search" target="_blank" method="post" action="">
<div class="Block"><label>Service No.</label> <input
	type="text" id="serviceNo." name="<%=SERVICE_NO%>"
	value="<%=serviceNo%>" MAXLENGTH="20"
	onblur="getHinNo('search','adt?method=getAdmissionNoList&flag=hin')" />
<div id="hinDiv"><label> HIN</label> <input type="text"
	name="<%=HIN_NO%>" value="" MAXLENGTH="50"
	onchange="submitProtoAjax('search','adt?method=getAdmissionNoList&flag=admission')" />
</div>
<div id="testDiv"><label> Ad No.</label> <input type="text"
	id="frwSlno" name="<%=AD_NO%>" value="" MAXLENGTH="30"
	validate="Ad No,string,yes" /></div>

<div class="Clear"></div>
</div>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<input type="button" name="OK" value="OK" class="button"
	onClick="submitForm('search','adt?method=showSiDiReport');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" />
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
</div>
</form>






