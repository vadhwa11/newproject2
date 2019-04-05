<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
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
<div class="titleBg">
<h2>Medico Legal Report</h2>
</div>
<div class="Clear"></div>
<form name="search" target="_blank" method="post" action="">
<div class="Block"><label>Service No. <span>*</span></label>
<input	type="text" id="serviceNo." name="<%=SERVICE_NO%>" value=""	MAXLENGTH="20"	onblur="if(validateMetaCharacters(this.value)){getHinNo('search','adt?method=getAdmissionNoList&flag=hin&mlc=yes')}" validate="Service No.,metachar,yes"/>

<div id="hinDiv">
<label> HIN <span>*</span></label> 
<input type="text"	name="<%=HIN_NO%>" value="" MAXLENGTH="50"	onchange="submitProtoAjax('search','adt?method=getMlcNo')" validate="HIN,string,yes"/>

</div>
<div id="testDiv"><label> MLC No. <span>*</span></label> <input type="text"
	name="<%=MLC_NO%>" value="" MAXLENGTH="20" validate="Mlc No.,string,yes" />
</div>
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<input type="button" name="OK" value="OK" class="button"
	onClick="submitForm('search','adt?method=showMedicoLegalReport');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" /></form>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
</div>





