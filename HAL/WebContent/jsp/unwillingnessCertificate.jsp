<%@page import="java.util.Calendar"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<form name="unwillingnessCertificate" action="" method="post">

<script>
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

<div class="titleBg"><h2>Unwillingness Certificate</h2></div>
<div class="Clear"></div>
<div class="Block">
<label> Service No.</label> 
<input type="text" name="<%= SERVICE_NO %>" value=""  validate="Service No,metachar,no"  onblur="if(this.value!=''){submitProtoAjax('unwillingnessCertificate','/hms/hms/registration?method=getOpIpHinNo&flag=unwillingness')};" maxlength="20">

<label> HIN </label> 
<div id="testDiv">
<input type="text" name="<%= HIN_ID %>" value=""  validate="HIN No,stirng,no"  maxlength="20">
</div>
<label>Diagnosis</label> 
<input	type="text" name="<%=DIAGNOSIS%>" validate="Diagnosis,string,no" value="" MAXLENGTH="50"  />
<div class="Clear"></div>
<label>Treatment Refused</label> 
<input	type="text" name="treatmentRefused" validate="Treatment Refused,string,no" value="" MAXLENGTH="50"  />

<label>Reason</label> 
<input	type="text" name="reason" validate="Reason,string,no" value="" MAXLENGTH="50"  />
<div class="Clear"></div>
</div>

<div class="Clear"></div>
<div class="division"></div>
<input type="button" name="Submit11" id="addbutton"	onclick="submitForm('unwillingnessCertificate','/hms/hms/registration?method=saveUnwillingnessCertificate');"
	value="Submit" class="button" accesskey="a" />
<input type="reset" name ="Reset" value ="Reset" class="button" tabindex="1" accesskey="r" />
 

<div class="clear"></div>
<jsp:include page="currentUserDetails.jsp"></jsp:include>
</form>