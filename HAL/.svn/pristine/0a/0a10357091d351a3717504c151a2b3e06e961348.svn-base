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
	
	<form name="MentalPhysicalRetardedChildren" action="" method="post">

   <% Map<String, Object> map = new HashMap<String, Object>();
		
		List<Object[]> unitList = new ArrayList<Object[]>();
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");  
		String time = (String)utilMap.get("currentTime");%>
	
	
<div class="titleBg"><h2>Mental Physical Retarded Children</h2>
</div>
<div class="Block">


<div class="clear"></div>
<label>Service No.</label>	
<input " type="text" name="serviceNo" validate="name, number,no" id="serviceNoId" value="" />
<label>Children Name</label>	
<input " type="text" name="childrenName" validate="name, string,no" id="childrenNameId" value="" />
<label>Relation</label>	
<input " type="text" name="relation" validate="name, string,no" id="relationId" value="" />

<div class="clear"></div>
<label>Rank</label>	
<input " type="text" name="rank" validate="name, string,no" id="rankId" value="" />
<label>Name</label>	
<input " type="text" name="name" validate="name, string,no" id="nameId" value="" />
<label>Branch/Trade</label>	
<input " type="text" name="branch/Trade" validate="name, string,no" id="branch/TradeId" value="" />
<div class="clear"></div>
<label>Unit</label>	
<input " type="text" name="unit" validate="name, string,no" id="unitId" value="" />
<label>Age</label>	
<input " type="text" name="age" validate="name, age,no" id="ageId" value="" />
<label>Diagnosis</label>	
<input " type="text" name="diagnosis" validate="name, string,no" id="diagnosisId" value="" />
<div class="clear"></div>
<label>Mental/Physical Retarded </label>	
<input " type="text" name="mental/PhysicalRetarded" validate="name, string,no" id="mental/PhysicalRetardedId" value="" />

<label>Hospital Name</label>	
<input " type="text" name="hospitalName" validate="name, string,no" id="hospitalNameId" value="" />

<label>Remarks</label>
	
<input " type="text" name="remarks" validate="name, string,no" id="remarksId" value="" />

<div class="clear"></div>

<input type="button" name="edit" value="Submit" class="button" />
<input type="button" name="edit" value="Print" class="button" />
<input type="button" name="Reset" onclick="submitForm('lmcPsychiatricPatientCounseling','sHO?method=showLowMedCatPsychiatricPatientCounelingEntry');" value="Reset" class="button"/>
<input type="button" name="edit" value="Back" class="button" />	
	</div>
<div class="clear"></div>
</form>










