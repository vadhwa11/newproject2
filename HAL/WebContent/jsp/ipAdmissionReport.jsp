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
<script type="text/javascript"
	language="javascript">
/*
 * Code By Mukesh 
 * Date 14 Aug 2012
 * User for AlphaNumeric Service No
 */
function validateServiceNoAlfa(serviceNo){
	 if(trimAll(serviceNo) != ''){
	 	if(validateMetaCharacters(serviceNo)){
	 	var serNo = trimAll(serviceNo);
	 	
	 	if(serNo != 0){
	 		submitProtoAjax('ipAdmissionReport','adt?method=getAdmissionNoList&flag=admission');
	 		return true;
	 	}else{
	 			alert("Employee No. can not be 0.")
	 			document.getElementById('"serviceNo.').value = "";
	 			return false;
	 	}
	 	}else{
	 		alert("Employee No is not valid.")
	 		document.getElementById('"serviceNo.').value = "";
	 		return false;
	 	}
	 }
	 }

</script>
<h2>IP Admission Slip</h2>
<div class="Clear"></div>
<form name="ipAdmissionReport" target="_blank" method="post" action="">
<div class="Block"><label>Employee No. <span>*</span></label><input
	type="text" id="serviceNo." name="<%=SERVICE_NO%>" value="" validate="Employee No.,metachar,yes"
	MAXLENGTH="20"
	onblur="if(this.value!=''){validateServiceNoAlfa(this.value)}" />
<div id="testDiv"><label> A&D No. <span>*</span></label> <input type="text"
	id="frwSlno" name="<%=AD_NO%>" value="" MAXLENGTH="30"
	validate="A&D No.,metachar,yes" /></div>
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<input type="button" name="OK" value="OK" class="button"
	onClick="submitForm('ipAdmissionReport','adt?method=showIPAdmissionReport');" />
<input type="reset" name="Reset" value="Reset" class="button"
	onclick="location.reload();" accesskey="r" />
	</form>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
