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

<h6>Search Patient For Expiry Details</h62>
<div class="Clear"></div>


<form name="search" target="_blank" method="post" action="">

<div class="blockTitle">Patient Search</div>
<div class="blockTitleCurve"></div>

<div class="blockFrame"><label>Service No.:</label> <input
	type="text" id="serviceNo." name="<%=SERVICE_NO%>" value=""
	MAXLENGTH="20"
	onblur="getHinNo('search','adt?method=getAdmissionNoList&flag=hin')" />
<div id="hinDiv"><label> Hin:</label> <input type="text"
	name="<%=HIN_NO%>" value="" MAXLENGTH="50"
	onchange="submitProtoAjax('search','adt?method=getAdmissionNoList&flag=admission')" />
</div>
<div id="testDiv"><label> Ad No:</label> <input type="text"
	id="frwSlno" name="<%=AD_NO%>" value="" MAXLENGTH="30"
	validate="Ad No,string,yes" /></div>
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<input type="button" name="Search" value="Search" class="button"
	onClick="submitForm('search','adt?method=showExpiryDetails&search=y');" />
<input type="reset" name="Reset" value="Reset" class="button"
	accesskey="r" />
<div class="Clear"></div>
</form>
<%  
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	 if(map.get("message") != null){
		   String message = (String)map.get("message");
		   %> <label class="noWidth"><span><%=message %></label></span> <%
		  }
%>

</div>





