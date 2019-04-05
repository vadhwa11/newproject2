<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>


<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript"
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

<div class="titleBg">
<h2>Search Patient For OP MLC</h2>
</div>
<div class="clear"></div>

<form name="search" method="post" action="">


<h4>Patient Search</h4>
<div class="clear"></div>
<div class="Block">
<label><span>*</span>Service No.</label> 
<input type="text" id="serviceNo." name="<%=SERVICE_NO%>" value="" MAXLENGTH="20" onblur="getHinNo('search','registration?method=getHinNoForUpdateAdt&flag=visit')" />
<div id="hinDiv"><label> <span>*</span>HIN No. </label> 
<input type="text" name="<%=HIN_NO%>" value="" MAXLENGTH="50" onblur="submitProtoAjax('search','registration?method=getVisitNo')" validate="Service No.,String,yes" />
</div>

<label><span>*</span>Visit No. </label>
<div id="testDiv">
<input type="text" name="<%=VISIT_NUMBER %>" value="" MAXLENGTH="6" readonly="readonly" />
</div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="Search" value="Search" class="button" onClick="submitForm('search','adt?method=showMedicoLegalCaseDetails&flag=opMlc');" />
<input type="reset" name="Reset" value="Reset" class="button" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="clear"></div>
</form>

<%  
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	 if(map.get("message") != null){
		   String message = (String)map.get("message");
		   %> <h4><span><%=message %></span></h4> <%
		  }
%>
<div class="Clear"></div>





