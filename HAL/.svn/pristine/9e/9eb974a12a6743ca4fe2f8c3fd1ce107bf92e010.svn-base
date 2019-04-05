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
	
	<form name="nutritionExamination" action="" method="post">

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
	
	
<div class="titleBg"><h2>Nutrition Examination</h2>
</div>
<div class="Block">


<div class="clear"></div>
<label>Date</label>
<input type="text" name="examinationDate" id="examinationDate" vlaue=<%=currentDate%> 
readonly="readonly"  class="calDate" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" class="calender"
onClick="setdate('<%=currentDate %>',document.nutritionExamination.examinationDate,event)" />
<div class="clear"></div>
<label style="width: 300px">Quality of Ration</label>	
<input type="text" name="qualityofRation"   maxlength="49"   validate="name, string, no" id="qualityofRationId" value="" />
<label  style="width: 300px">state of personnel</label>	
<input  type="text" name="stateofPersonnel"    maxlength="49"   validate="name, string, no" id="nutritionstateId" value="" />
<div class="clear"></div>
<label style="width: 300px">Cooking and messing arrangement</label>	
<input  type="text" name="cookingandmessing"   maxlength="49"   validate="name, string, no" id="cookingandmessingId" value="" />

<label style="width: 300px">Unhygienic defects</label>	
<input  type="text" name="unhygienicDefects"   maxlength="49"   validate="name, string, no" id="unhygienicDefectsId" value="" />
<div class="clear"></div>
<label style="width: 300px">Meat Supply Source</label>	
<input  type="text" name="meatSupplySource"   maxlength="49"   validate="name, string, no" id="meatSupplySourceId" value="" />
<label style="width: 300px">Quality</label>	
<input  type="text" name="meatquality"  maxlength="49"    validate="name, string, no" id="qualityId" value="" />
<div class="clear"></div>
<label style="width: 300px">Milk Supply</label>	
<input  type="text" name="milkSupply" maxlength="49"   validate="name, string, no" id="milkSupplyId" value="" />

<label style="width: 300px">Quality</label>	
<input  type="text" name="milkquality" maxlength="49" validate="name, string, no" id="qualityId" value="" />
<div class="clear"></div>
<label style="width: 300px">Remarks</label>	
<input	tabindex="1" type="text" name="remarks" class="auto" size="122"	maxlength="49" value="" />
<div class="clear"></div>
<label style="width: 300px">Action Taken</label>
<input	tabindex="1" type="text" name="actionTaken" class="auto" size="122"	maxlength="49" value="" />	

<div class="clear"></div>
<input type="button" name="Submit"  onclick="submitForm('nutritionExamination','/hms/hms/mis?method=submitNutritionExamination');" class="button" value="Submit"  />
<!--<input type="button" name="Reset" onclick="submitForm('nutritionExamination','sHOmethod=showLowMedCatPsychiatricPatientCounelingEntry');" value="Reset" class="button"/>
<input type="button" name="edit" value="Back" class="button" />	
	-->
	</div>
<div class="clear"></div>
</form>








