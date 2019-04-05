<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.ExpiryDetails"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.ExpiryDetails"%>
<%@page import="jkt.hms.masters.business.Inpatient" %>
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
	
	<form name="mortalityAmongstFamilies" action="" method="post">

   <% Map<String, Object> map = new HashMap<String, Object>();
		
		List<Object[]> unitList = new ArrayList<Object[]>();
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		
		int inpatientId = 0;
		Inpatient inpatient = null;
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");  
		String time = (String)utilMap.get("currentTime");
		
		try 
		{
			inpatientId = inpatient.getId().intValue();
		} 
		catch (Exception e) 
		{
			inpatientId = 0;
		}		
%>
	
	
<div class="titleBg"><h2>Mortality Amongst Families</h2>
</div>
<div class="Block">
<div class="clear"></div>

<label>Service No.<span>*</span></label>	
<input  type="text" name="serviceNo" validate="Service No,int,yes" id="serviceNoId" value=""
onblur="getPatientDetails(this.value)" />

<script type="text/javascript">
function getPatientDetails(val)
{  
	var hinNo='';
	hinNo=document.getElementById('serviceNoId').value;
	if(validateMetaCharacters(hinNo))
	{
		submitProtoAjaxWithDivName('mortalityAmongstFamilies','mis?method=getServiceNoDetailsForMortalityAmongstFamilies&flag='+hinNo,'mortalDiv');
	}
}
</script>

<div id="mortalDiv">
<label>HIN</label> 
<input	type="text" name="hinId" value=""	MAXLENGTH="30" onchange=""/>
</div>

<input type="hidden" name=<%=INPATIENT_ID%> value="<%=inpatientId%>">

<div id="DivMortality">

<label>Name</label>
<input  type="text" name="name" validate="name, string,no" id="nameId" value="" />

<div class="clear"></div>

<label>Rank</label>
<input  type="text" name="rank" validate="name, string,no" id="rankId" value="" />

<label>Patient Name</label>
<input  type="text" name="patientName" validate="patientName, string,no" id="patientNameId" value="" />

<label>Relation</label>
<input  type="text" name="relation" validate="relation,string,no" id="relationid" value="" />

<div class="clear"></div>

<label>Age</label>
<input  type="text" name="age"  validate="age,number,no" id="ageId" value="" />

<label> Diagnosis</label> 
<label class="value" name = "diagnosis"></label>

<label>Gender</label>
<input  type="text" name="sex" validate="gender,string,no" id="sexId" value="" />

<!--<select name="sex">
<option value="M">Male</option>
<option value="F">Female</option>
</select>
-->

<div class="clear"></div>

<label >Trade</label>
<input  type="text" name="trade" validate="name, string,no" id="tradeId" value="" />

<label >Unit</label>	
<input  type="text" name="unit" validate="name, string,no" id="unitId" value="" />
</div>
<div class="clear"></div>

<label>Date of Death<span>*</span></label>
<input  type="text"	id="dateOfDeath" name="dateOfDeath" tabindex="1" value=""	readonly="readonly" validate="Date of Death,date,yes" MAXLENGTH="30"	class="calDate" onblur="checkCurrentDate(this.value);" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"
 onClick="setdate('<%=currentDate %>',document.mortalityAmongstFamilies.dateOfDeath,event)"/>	


	
<!--<input  type="text"	id="" name="dateOfDeath" tabindex="1" value=""	 validate="" MAXLENGTH="30" class="calDate" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"
onClick="setdate('<%=currentDate %>',document.mortalityAmongstFamilies.dateOfDeath,event)"/> -->


<label >Place of Death</label>	
<input  type="text"	id="" name="placeOfDeath" tabindex="1" value="" class=""	 validate="" MAXLENGTH="30" />


<label>Cause of Death</label>	
<input  type="text"	id="" name="causeOfDeath" tabindex="1" value="" class=""  validate="" MAXLENGTH="200" />



</div>

<input type="hidden" name="presentCondition" value="Dead" />
</div>
<div class="clear"></div>
<div class="division"></div>
<input type="button" name="Submit" value="Submit" class="button" onclick="submitForm('mortalityAmongstFamilies','/hms/hms/mis?method=submitMortalityAmongstFamiliesJsp');" />
<div class="clear"></div>
<div class="division"></div>
</form>

<script type="text/javascript">


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
{ 
	if(document.getElementById('weatherIndiId').value = 'Yes')
	{
	
	document.getElementById('weatherIndDiv').style.display = 'block';
	}
	else{
     
     }
 
	
}


function checkCurrentDate(comDate)
{
	  if(comDate != "")
		{
		 var commissionDate = new Date(comDate.substring(6),(comDate.substring(3,5) - 1) ,comDate.substring(0,2));
		 currentDate = new Date();
		 var month = currentDate.getMonth() + 1
		 var day = currentDate.getDate()
		 var year = currentDate.getFullYear()
		 var seperator = "/"
		 currentDate = new Date(month + seperator + day + seperator + year);
		 if(commissionDate > currentDate )
		 {
			 alert("Date of Death should not be greater than current date.");
		 }	 
		}
}

</script>
