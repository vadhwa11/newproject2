<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.ExpiryDetails"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.ExpiryDetails"%>
<%@page import="jkt.hms.masters.business.MasMedicalCategory"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="jkt.hms.masters.business.Category"%>
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
	<form name="monitoringofADSCases" action="" method="post">

   <% Map<String, Object> map = new HashMap<String, Object>();
		int hinId =0;
		List<Object[]> unitList = new ArrayList<Object[]>();
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(request.getParameter("hinId")!= null)
		{
			hinId = Integer.parseInt(request.getParameter("hinId"));
			
		}
		List<Category> categoryList= new ArrayList<Category>();
		if(map.get("categoryList") != null){
			categoryList = (List)map.get("categoryList");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");  
		String time = (String)utilMap.get("currentTime");%>
	
<div class="titleBg"><h2>Monitoring of ADS Cases</h2>
</div>
<div class="Block">


<div class="clear"></div>
<div id="srNoDiv">
<label>Service No.</label>	
<input type="text" name="<%=SERVICE_NO %>"    id="serviceNoId" value=""
    onblur="getPatientDetails(this.value);"  />
<label>Rank</label>	
<input  type="text" name="rank" validate="name, string, no" id="rankId" value="" />
<label>Name</label>	
<input  type="text" name="name" validate="name, string, no" id="nameId" value="" />
<div class="clear"></div>
<label>Trade</label>	
<input  type="text" name="trade" validate="name, string, no" id="tradeId" value="" />
<label>Unit</label>	
<input  type="text" name="unit" validate="name, string, no" id="unitId" value="" />
<label>Age</label>	
<input  type="text" name="age" validate="name, number, no" id="ageId" value="" />
<div class="clear"></div>
</div>
<label>Date of Diagnosis</label>	
<input type="text"	id="commissionDateId" name="diagnosisDate" tabindex="1" value="<%=currentDate %>"	readonly="readonly" validate="commission Date,date,no" MAXLENGTH="30"	class="calDate" onblur="calculateTotalService(this.value);" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"  onClick="setdate('<%=currentDate %>',document.monitoringofADSCases.diagnosisDate,event)" />

<label>Medical Category</label>	
<select  name="medicalCategory" validate="name, string, no" id="medicalCategoryId" value="" >
<option value="0">Select</option>
<%
for (Category category : categoryList) {
	String selected="";
	
	%>
<option value="<%=category.getCategoryid()%>" ><%=category.getCategories()%> </option>
<%}%>
</select>
<label>Last Med Board Date</label>	
<input type="text"	id="lastMedBoardDateId" name="lastMedBoardDate" tabindex="1" value=""	readonly="readonly" validate="commission Date,date,no" MAXLENGTH="30"	class="calDate" onblur="calculateTotalService(this.value);" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"
onClick="setdate('<%=currentDate %>',document.monitoringofADSCases.lastMedBoardDate,event)"/>

<div class="clear"></div>
<label>Counselling Date</label>
<input type="text"	id="counsellingDateId" name="counsellingDate" tabindex="1" value=""	readonly="readonly" validate="commission Date,date,no" MAXLENGTH="30"	class="calDate" onblur="calculateTotalService(this.value);" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"
onClick="setdate('<%=currentDate %>',document.monitoringofADSCases.counsellingDate,event)"/>

<label>Warning Letter</label>	
<input  type="text" name="warningLetter" validate="name, string, no" id="warningLetterId" value="" />


<label>Retention in Service</label>	
<input  type="text" name="retentioninService" validate="name, string, no" id="retentioninServiceId" value="" />
<div class="clear"></div>
<label>Date of Posting</label>	
<input type="text"	id="commissionDateId" name="postingDate" tabindex="1" value=""	readonly="readonly" validate="commission Date,date,no" MAXLENGTH="30"	class="calDate" onblur="calculateTotalService(this.value);" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"
 onClick="setdate('<%=currentDate %>',document.monitoringofADSCases.postingDate,event)"/>
<label>Case Type</label>	
<input  type="text" name="freshOld" validate="name, string, no" id="fresh/OldId" value="" />

<label>Remarks</label>
<input  type="text" name="remarks" validate="name, string, no" id="remarksId" value="" />
<div class="clear"></div>
<div class="clear"></div>
<input type="button" name="Submit"  class="button" onclick="submitForm('monitoringofADSCases','/hms/hms/mis?method=submitMonitoringofADS');" value="Submit" />
<!--<input type="button" name="edit" value="Print" class="button" />
--><input type="button" name="Reset" onclick="submitForm('lmcPsychiatricPatientCounseling','sHO?method=showLowMedCatPsychiatricPatientCounelingEntry');" value="Reset" class="button"/>
<input type="button" name="edit" value="Back" class="button" />	
	</div>
<div class="clear"></div>
</form>
<script type="text/javascript">
function getPatientDetails(val)
{   
	submitProtoAjaxforPatientDetails('monitoringofADSCases','/hms/hms/mis?method=getServiceNoDetailsForADS&serviceNo='+val);
}
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

</script>









