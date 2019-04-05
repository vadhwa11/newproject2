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
	
	<form name="SchoolInspectionEntry" action="" method="post">

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
	
	
<div class="titleBg"><h2>School Inspection Entry</h2>
</div>
<div class="Block">


<div class="clear"></div>

<label style="width: 300px">Date of Inspection</label>	
<input type="text"	id="inspectionDate" name="inspectionDate" tabindex="1" value="<%=currentDate %>"	readonly="readonly" validate="commission Date,date,no" MAXLENGTH="30"	class="calDate" onblur="calculateTotalService(this.value);" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"  onClick="setdate('<%=currentDate %>',document.SchoolInspectionEntry.inspectionDate,event)" />

<label style="width: 300px">Name of School</label>	
<input  type="text" name="nameofSchool"  maxlength="49"  validate="name , string,no" id="nameofSchoolId" value="" />
<div class="clear"></div>

<label style="width: 300px">Name of Inspecting Person</label>	
<input  type="text" name="nameofInspectingPerson"   maxlength="49" validate="name , string,no" id="nameofInspectingPersonId" value="" />
<label style="width: 300px">No. of Children Medically Examined</label>	
<input  type="text" name="noofChildrenMedicallyExamined"  maxlength="19"  validate="No Of Children,int,yes"  id="noofChildrenMedicallyExaminedId" value="" />
<div class="clear"></div>
<h4>Defects detected </h4>


<label style="width: 300px">Dental Carries </label>	
<input type="text" name="dentalCarries"  maxlength="49"  validate="name , string,no" id="dentalCarriesId" value="" />


<label style="width: 300px">Defective Vision </label>	
<input  type="text" name="defectiveVision"  maxlength="49"   validate="name , string,no" id="defectiveVisionId" value="" />
<div class="clear"></div>

<label style="width: 300px">Wax Ear </label>	
<input  type="text" name="waxEar" maxlength="49" validate="name , string,no" id="waxEar Id" value="" />

<label style="width: 300px">Enlarged Glands </label>	
<input type="text" name="enlargedGlands" maxlength="49" validate="name , string,no" id="enlargedGlandsId" value="" />
<div class="clear"></div>
<label style="width: 300px">Other </label>	
<input  type="text" name="other"   maxlength="49" validate="name , string,no" id="otherId" value="" />

<label style="width: 300px" >Action to rectify the defects </label>	
<input  type="text" name="actiontorectifythedefects"  maxlength="49" validate="name , string,no" id="actiontorectifythedefectsId" value="" />
<div class="clear"></div>

<label style="width: 300px" > Details of protection given to school children  </label>	
<input style="width: 630px"  type="text" name="detailsofprotective"  maxlength="49"  validate="name , string,no" id="otherId" value="" />

	</div>
<div class="clear paddingTop15"></div>

<input type="button" name="Submit" value="Submit" onClick="submitForm('SchoolInspectionEntry','/hms/hms/mis?method=submitSchoolInspectionEntry');" class="button" />
<!--<input type="button" name="edit" value="Print" class="button" />
-->
<!--<input type="button" name="Reset" onclick="submitForm('lmcPsychiatricPatientCounseling','sHO?method=showLowMedCatPsychiatricPatientCounelingEntry');" value="Reset" class="button"/>
<input type="button" name="edit" value="Back" class="button" />	
	-->

	
	
	<div class="clear"></div>
</form>













	