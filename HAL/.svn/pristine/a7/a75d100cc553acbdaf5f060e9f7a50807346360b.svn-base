<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
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

<div class="titleBg"><h2>Update Patient Visit</h2></div>
<div class="Clear"></div>


<form name="search" method="post" action="">
<div class="Block">
<label>Service No.</label>
<input	type="text" id="serviceNo." name="<%=SERVICE_NO%>" value=""	MAXLENGTH="30"	onblur="getHinNo('search','registration?method=getHinNoForUpdateVisit&flag=visit')" />
<div id="hinDiv"><label> Patient Name</label> <input type="text"
	name="<%=HIN_NO%>" value="" MAXLENGTH="30"
	onchange="submitProtoAjax('search','opd?method=getPresVisitNo')"
	validate="Hin ,String,yes" /></div>

<label>Visit No. </label>
<div id="testDiv"><input type="text" name="<%=VISIT_NUMBER %>"
	value="" MAXLENGTH="30" readonly="readonly" /></div>
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<div class="division"></div>
<input type="button" name="Search" value="Search" class="button"
	onClick="submitForm('search','registration?method=showUpdateVisitJsp');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	accesskey="r" /></form>
	<div class="Clear"></div>
<div class="division"></div>






