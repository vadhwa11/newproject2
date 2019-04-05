<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
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

<div class="titleBg"><h2>Search Patient For IP MLC</h2></div>
<div class="Clear"></div>


<form name="search" method="post" action="">
<div class="Block">
<label>Service No.</label>
<input	type="text" id="serviceNo." name="<%=SERVICE_NO%>" value=""	MAXLENGTH="20"	onblur="getHinNo('search','adt?method=getAdmissionNoList&flag=hin')" />
<div id="hinDiv">
<label> HIN No.</label>
<input type="text"	name="<%=HIN_NO%>" value="" MAXLENGTH="50" onchange="submitProtoAjax('search','adt?method=getAdmissionNoList&flag=admission')" />
</div>
<div id="testDiv">
<label> A&D No.</label>
<input type="text"	id="frwSlno" name="<%=AD_NO%>" value="" MAXLENGTH="30" validate="Ad No,string,yes" />
</div>
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<div class="division"></div>
<input type="button" name="Search" value="Search" class="button"	onClick="submitForm('search','adt?method=showMedicoLegalCaseDetails&flag=ipMlc');" />
<input type="reset" name="Reset" value="Reset" class="button"	accesskey="r" />
<div class="Clear"></div>
<div class="division"></div>
</form>
<%  
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	 if(map.get("message") != null){
		   String message = (String)map.get("message");
		   %> <h4><%=message %></h4> <%
		  }
%>






