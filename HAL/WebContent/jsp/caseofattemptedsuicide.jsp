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
	
	<form name="caseofAttemptedSuicide" action="" method="post">

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
	
	
<div class="titleBg"><h2>Case of Attempted Suicide</h2>
</div>
<div class="Block">
<div class="clear"></div>
<div id="srNoDiv">

<label>Service No.<span>*</span></label>
<input type="text" name="serviceNo" id="serviceNo"  value="" MAXLENGTH="30" validate="Service No,metachar,yes"
	onblur="getPatientDetails();"/>
<script>
function getPatientDetails()
{
var hinNo='';
hinNo=document.getElementById('serviceNo').value;

if(validateMetaCharacters(hinNo))
{
	submitProtoAjaxWithDivName('caseofAttemptedSuicide','/hms/hms/mis?method=getHinNoForAttemptSucide&flag='+hinNo,'hinDiv')
}
}
</script>
<div id="hinDiv">
<label>HIN</label> 
<input	type="text" name="<%=HIN_NO%>" value=""	MAXLENGTH="30" onchange="submitProtoAjax('notifiableDisease','mis?method=getPatientDetailForMalaria','hinDiv')"/>
</div>


<div id="hinDiv11">

<!--<label >Service No.<span>*</span></label>	
<input  type="text" name="serviceNo" validate="Service No,number,yes" id="serviceNoId" value=""
onblur="getPatientDetails(this.value);" />

-->

<label >Name</label>
<input  type="text" name="name" validate="name, string,no" id="nameId" value="" />



<label >Rank</label>
<input  type="text" name="rank" validate="name, string,no" id="rankId" value="" />

<label >Patient Name</label>
<input  type="text" name="patientName" validate="patientName, string,no" id="patientNameId" value="" />

<label >Relation</label>
<input  type="text" name="relation" validate="relation, string,no" id="relationid" value="" />

<div class="clear"></div>

<label >Age</label>
<input  type="text" name="age"  validate="name, number,no" id="ageId" value="" />

<label >Gender</label>
<input  type="text" name="sex" validate="name, string,no" id="sexId" value="" />

<label >Trade</label>
<input  type="text" name="trade" validate="name, string,no" id="tradeId" value="" />

<div class="clear"></div>

<label >Unit</label>	
<input  type="text" name="unit" validate="name, string,no" id="unitId" value="" />

</div>
<label >Date of Attempt<span>*</span></label>	
<input  type="text"	id="dateofAttemptId" name="dateofAttempt" tabindex="1" value=""	readonly="readonly" validate="Date of Attampt,date,yes" MAXLENGTH="30"	class="calDate" onblur="calculateTotalService(this.value);" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"
  onClick="setdate('<%=currentDate %>',document.caseofAttemptedSuicide.dateofAttempt,event)"/>

<label >Date of Death</label>	
<input  type="text"	id="" name="dateOfDeath" tabindex="1" value=""	 validate="Date of Death,date,no" MAXLENGTH="30" class="calDate" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"
  onClick="setdate('<%=currentDate %>',document.caseofAttemptedSuicide.dateOfDeath,event)"/> 

<label >Method of Suicides</label>	
<input  type="text"	id="" name="reason" tabindex="1" value="" class="large"	 validate="" MAXLENGTH="30" />


</div>
</div>
<div class="clear"></div>
<div class="division"></div>
<input type="button" name="Submit" value="Submit" class="button" onclick="submitForm('caseofAttemptedSuicide','/hms/hms/mis?method=submitCaseOfAttemptSuicideJsp');" />
<!--<input type="button" name="Reset" onclick="submitForm('lmcPsychiatricPatientCounseling','sHO?method=showLowMedCatPsychiatricPatientCounelingEntry');" value="Reset" class="button"/>
<input type="button" name="edit" value="Back" class="button" />	
-->
<div class="clear"></div>
<div class="division"></div>
</form>

<script type="text/javascript">
//function getPatientDetails(val)
//{  if(validateMetaCharacters(val)){
//	submitProtoAjaxforPatientDetails('caseofAttemptedSuicide','/hms/hms/mis?method=getServiceNoDetailsForAttemptSucide&serviceNo='+val);
//}
//}

function submitProtoAjaxforPatientDetails(formName,action){
	errorMsg = "";
	ob1 = true;
	ob2 = true;
	ob3 = true;
	obj = eval('document.'+formName)
	       	obj.action = action;
    	   	 var url=action+"&"+getNameAndData(formName)
        	
        	new Ajax.Updater('srNoDiv',url,
			   {asynchronous:false, evalScripts:true }); 
	       	return true;
    	}
function openYesField(val)
{  //alert("openYesField");
	if(document.getElementById('weatherIndiId').value = 'Yes')
	{
	
	document.getElementById('weatherIndDiv').style.display = 'block';
	}
	else{
     
     }
 
	
	}

</script>
