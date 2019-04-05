<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.ExpiryDetails"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.ExpiryDetails"%>

<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
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
	
<div class="titleBg"><h2>Psy-Patient Counseling</h2>
</div>
<div class="Block">


<div class="clear"></div>

<label >S No.</label>	
<input " type="text" name="sNo"  validate="name, number,no" id="sNoId" value="" />
<label  >Rank</label>	
<input " type="text" name="rank" validate="name, string,no" id="rankId" value="" />

<label >Name</label>	
<input " type="text" name="name" validate="name, string,no" id="nameId" value="" />
<div class="clear"></div>
<label>Trade</label>	
<input " type="text" name="trade" validate="name, string,no" id="tradeId" value="" />
<label>Unit</label>	
<input " type="text" name="unit" validate="name, string,no" id="unitId" value="" />

<label>Diagnosis</label>	
<input " type="text" name=diagnosis" validate="name, string,no" id="diagnosisId" value="" />
<div class="clear"></div>
<label>Last Med Board</label>	
<input " type="text" name="lastMedBoard" validate="name, string,no" id="lastMedBoardId" value="" />
<label>Next MB Due</label>	
<input " type="text" name="nextMbDue" validate="name, string,no" id="nextMbDueId" value="" />


<label>Med Cat</label>	
<input " type="text" name="medCat" validate="name, string,no" id="medCatId" value="" />
<div class="clear"></div>
<label>Counseling Date</label>	

<input type="text"	id="commissionDateId" name="commissionDate" tabindex="1" value=""	readonly="readonly" validate="commission Date,date,no" MAXLENGTH="30"	class="calDate" onblur="calculateTotalService(this.value);" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"/>



<label>Remarks</label>
	
<input " type="text" name="remarks" validate="name, string,no" id="remarksId" value="" />

<div class="clear"></div>

<input type="button" name="edit" value="Submit" class="button" />
<input type="button" name="edit" value="Print" class="button" />
<input type="button" name="Reset" onclick="submitForm('lmcPsychiatricPatientCounseling','sHO?method=showLowMedCatPsychiatricPatientCounelingEntry');" value="Reset" class="button"/>
<input type="button" name="edit" value="Back" class="button" />	
	</div>
<div class="clear"></div>











