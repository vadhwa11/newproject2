<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>

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
	</script> <%
 	Map<String, Object> utilMap = new HashMap<String, Object>();
 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
 	String currenDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");

	
	%>
	<div class="titleBg">
<h2>Medical Certificate</h2>
</div>
<div class="Clear"></div>

<form name="medicalCertificateReport" target="_blank" method="post"
	action="">
<div class="Block">

<label>Service No.<span>*</span></label> <input
	type="text" id="serviceNo." name="<%=SERVICE_NO%>" value=""
	MAXLENGTH="20" validate="Service No.,metachar,yes"
	onblur="getHinNo('medicalCertificateReport','adt?method=getAdmissionNoList&flag=hin&medical=yes')" />
<div id="hinDiv">

<label> HIN <span>*</span></label> <input type="text"
	name="<%=HIN_NO%>" value="" validate="HIN,metachar,yes" MAXLENGTH="50" />	<!-- onchange="submitProtoAjax('medicalCertificateReport','adt?method=getVisitDates')" --> 
</div>

<div class="Clear"></div>

<div id="testDiv">


<label> From Date</label> 
<input type="text"	id="fromDate" name="fromDate" tabindex="1" value=""	validate="From Date,string,yes"  MAXLENGTH="10" onkeyup="mask(this.value,this,'2,5','/');"	class="calDate"  /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.medicalCertificateReport.fromDate,event)" /> 


	
</select> 


<label> To Date</label> 

<input type="text"	id="toDate" name="toDate" tabindex="1" value=""	validate="To Date,string,yes"  MAXLENGTH="10" onkeyup="mask(this.value,this,'2,5','/');"	class="calDate"  /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.medicalCertificateReport.toDate,event)" /> 

	



</div>
<div class="Clear"></div>
<div id="diagnosisDiv">

<label>Diagnosis</label> <input
	type="text" name="<%=DIAGNOSIS_ID %>" value=""  /></div>
	
	
<label>Fit/Unfit for</label> <input type="text"
	name="<%=FIT_UNFIT_FOR%>" value="" MAXLENGTH="100" validate="Fit/Unfit for,alphanumeric,no"/>
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<input type="button" name="OK" value="OK" class="button"
	onClick="submitForm('medicalCertificateReport','adt?method=showMedicalCertificateReport');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" /></form>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>


</div>





