<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>


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

		function getPrescriptionPrint(){
		var hin_no = document.getElementsByName('hinNo')[0].value;
		document.getElementById('hinReport').value = hin_no
		document.getElementById('serviceReport').value = document.getElementById('serviceNo.').value
		document.getElementById('visitReport').value = document.getElementById('visitNoReport').value
		var check =true;
		if(document.getElementById('visitReport').value == ""){
		   alert("Please select visit no")
		   check = false;
	    }
	    if(check){
		submitForm('search','opd?method=showPatientPrescriptionReport','checkTargetForYes');
		checkTargetForNo();
		}
	}
	</script>

<div class="titleBg"><h2>Patient Prescription</h2></div>
<div class="clear"></div>
<form name="search" method="post" action="">
<input	name="<%=SERVICE_NO_FOR_REPORT%>" id="serviceReport" type="hidden"	value="" />
<input name="<%=VISIT_NUMBER_FOR_REPORT%>" id="visitReport"	type="hidden" value="" />
<input name="<%=HIN_NO_FOR_REPORT%>" id="hinReport" type="hidden" value="" />

<div class="Block">
<label>Service No.</label>
<input type="text" id="serviceNo." name="<%=SERVICE_NO%>" value=""	 MAXLENGTH="30"	onblur="getHinNo('search','opd?method=getHinNoForpatientpres&flag=visit')" />

<div id="hinDiv">
<label> Patient Name</label>
<input	type="text" name="<%=HIN_NO%>" value="" MAXLENGTH="30"	onchange="submitProtoAjax('search','opd?method=getPresVisitNo')"	validate="Hin ,String,yes" />
</div>

<label>Visit No. </label>
<div id="testDiv">
<input type="text" name="<%=VISIT_NUMBER%>"	value=""  MAXLENGTH="30" readonly="readonly" validate="Visit No ,String,yes" />
</div>
</div>

<div class="clear"></div>
<div class="division"></div>
<input type="button" name="Search" value="Search" class="button" onClick="submitForm('search','opd?method=showUpdatePatientPrescribtionVisitJsp');" />
<input type="reset" name="Reset" value="Cancel" class="button"	accesskey="r" />
<input type="button" name="Print" value="Print"	class="button" onClick="getPrescriptionPrint()" />
<div class="clear"></div>
<div class="division"></div>

</form>

