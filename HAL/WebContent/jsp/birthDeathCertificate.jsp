<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="com.sun.org.apache.xpath.internal.functions.Function"%>

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
	function checkFormate(){
	var birth = document.getElementById('birth').check;
			
	}
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script>
<div class="titleBg">
<h2>Birth / Death Report and Certification</h2>
</div>

<div class="clear"></div>
<form name="bdReport" target="_blank" method="post" action="">
<div class="Block">
<label>Service No.</label> 
<input type="text" id="serviceNo." name="<%=SERVICE_NO%>" value="" class=""
	MAXLENGTH="30"
	onblur="getHinNo('bdReport','mis?method=getHiAdListForBD&serviceNo'+this.value+'&flag=hin')" />

<div id="hinDiv">
<label>Hin No. </label> 
<input type="text"
	name="<%=HIN_NO%>" value="" class="" MAXLENGTH="30" validate="Hin,,yes"
	onchange="submitProtoAjaxWithDivName('bdReport','mis?method=getAdmissionNoList&flag=admission&onlyReport=yes','testDiv')" />
</div>

<div id="testDiv">
<label>Ad No. </label> 
<input type="text"
	id="frwSlno" name="<%=AD_NO%>" value="" class="" MAXLENGTH="30" /></div>
<div class="clear"></div>
<label>Certificate</label> 
<label class="unit">Birth</label>
 <input
	type="radio" class="radioAuto" name="<%=SELECTED_RADIO%>" id="birth"
	value="birth" onclick="checkFormate()" checked="checked"> 
<label class="unit">Death</label> 
<input type="radio"
	name="<%=SELECTED_RADIO %>" class="radioAuto" value="death">

<div class="clear"></div>
<div id="bnew"><label>Format </label> 
<label class="unit" style="width:109px;">Old(pre 2009)</label> 
<input type="radio" name="formate" value="old" class="radioAuto"
	checked="checked"> 
<label class="unit">New</label> 
<input
	type="radio" name="formate" value="new" class="radioAuto">
</div>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="button" name="OK" value="OK" class="button"
	onClick="submitForm('bdReport','/hms/hms/mis?method=printBDCertificate');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" />
	<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
	
	</form>






