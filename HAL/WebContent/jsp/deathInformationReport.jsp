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


<h6>Death Information Report</h6>
<div class="Clear"></div>
<form name="fatalDocumentPanchnamaReport" target="_blank" method="post"
	action="">
<div class="blockFrame"><label>Service No.:</label> <input
	type="text" id="serviceNo." name="<%=SERVICE_NO%>" value=""
	MAXLENGTH="30"
	onblur="getHinNo('fatalDocumentPanchnamaReport','mis?method=getHinAdNoFatalPanchanama&flag=hin')" />

<div id="hinDiv"><label> Hin:</label> <input type="text"
	name="<%=HIN_NO%>" value="" MAXLENGTH="30" validate="Hin,,yes"
	onchange="submitProtoAjaxWithDivName('fatalDocumentPanchnamaReport','mis?method=getAdmissionNoList&flag=admission','testDiv')" />
</div>

<div id="testDiv"><label> Ad No:</label> <input type="text"
	id="frwSlno" name="<%=AD_NO%>" value="" MAXLENGTH="30" /></div>

<div class="Clear"></div>

<label>To:</label> <input type="text" id="to" name="<%=TO%>" value=""
	MAXLENGTH="30" /> <label> Certificate </label> <input type="radio"
	class="radio" name="<%=SELECTED_RADIO%>" value="airForce"
	checked="checked"> <label class="unit">Air Force</label> <input
	type="radio" class="radio" name="<%=SELECTED_RADIO %>" value="Army">
<label class="unit">Army</label> <input type="radio" class="radio"
	name="<%=SELECTED_RADIO %>" value="Navy"> <label class="unit">Navy</label>

<div class="Clear"></div>

<label>Info 1:</label> <input type="text" name="<%=INFO1%>" value="" />

<label>Channel 1:</label> <input type="text" name="<%=CHANNEL1%>"
	value="" />

<div class="Clear"></div>

<label>Info 2:</label> <input type="text" name="<%=INFO2%>" value="" />

<label>Channel 2:</label> <input type="text" name="<%=CHANNEL2%>"
	value="" />

<div class="Clear"></div>

<label>Info 3:</label> <input type="text" name="<%=INFO3%>" value="" />
<label>Channel 3:</label> <input type="text" name="<%=CHANNEL3%>"
	value="" />

<div class="Clear"></div>


<label> Rank </label> <input type="text" name="<%=RANK%>" value="">

<label> Name </label> <input type="text" name="<%=NAME%>" value="">

<label> Drafter Name </label> <input type="text"
	name="<%=DRAFTER_NAME%>" value="">

<div class="Clear"></div>

<label>NOK</label> <select name="nok">
	<option value="INFORMED">INFORMED</option>
	<option value="NOT INFORMED">NOT INFORMED</option>
</select></div>

<div class="Clear"></div>
<input type="button" name="OK" value="OK" class="button"
	onClick="submitForm('fatalDocumentPanchnamaReport','mis?method=showDeathInformation');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" /></form>
</div>





