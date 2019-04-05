<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>

<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.ExpiryDetails"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.ExpiryDetails"%>
<%@page import="jkt.hms.masters.business.ShoBreakDown"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>

<%@page import="jkt.hms.masters.business.ShoAntiFilaria"%>


<%@page import="jkt.hms.masters.business.ShoConservancy"%>
<%@page import="jkt.hms.masters.business.ShoWorkService"%>
<%@page import="jkt.hms.util.Box"%><script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
	
<script type="text/javascript">
function ismaxlength(obj){
	var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""

	if (obj.getAttribute && obj.value.length>mlength)
	obj.value=obj.value.substring(0,mlength)
}
</script>
<script type="text/javascript" language="javascript">
<%
Calendar calendar=Calendar.getInstance();
String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
String getDate=String.valueOf(calendar.get(Calendar.DATE));
int year=calendar.get(calendar.YEAR);
if(month.length()<2){
month="0"+month;
}
if(getDate.length()<2){
getDate="0"+getDate;
}

%>
serverdate = '<%=getDate+"/"+month+"/"+year%>'
</script>
 <%
Map<String, Object> utilMap = new HashMap<String, Object>();
utilMap = (Map) HMSUtil.getCurrentDateAndTime();
String currenDate = (String) utilMap.get("currentDate");
String time = (String) utilMap.get("currentTime");
   
String userName="";
if(session.getAttribute("userName")!=null)
userName=(String)session.getAttribute("userName");


String currentDate = (String) utilMap.get("currentDate");

%>

<%
	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	}
	

	List<ShoWorkService> shoWorkServiceList = new ArrayList<ShoWorkService>();	
	if(map.get("shoWorkServiceList") != null)
	{
		shoWorkServiceList=(List<ShoWorkService>)map.get("shoWorkServiceList");
	}
	Box box = HMSUtil.getBox(request);

	

%>
<!--main content placeholder starts here-->
<form name="shoWorkService" action="" method="post">

<div class="titleBg">
<h2>Work Services</h2>
</div>



 <script type="text/javascript">
	   var icdArray=new Array();
	   var unitArray = new Array();

	</script> 
<div class="clear"></div>
<div class="Block">
<label>Current Date</label>

<input type="text" name="currentDate" id="currentDate"  readonly="readonly"  value="<%=currentDate%>" class="date" class="auto" size="11" validate="Date,date,yes" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" onclick="javascript:setdate('currentDate',document.shoWorkService.currentDate, event)"	validate="Pick a date"  />

<label>Last Updated Date</label>
<% 
Date lastDate =new Date();
if(shoWorkServiceList != null && shoWorkServiceList.size()>0){
for(ShoWorkService shoWorkService :shoWorkServiceList)
{	
	if(shoWorkService.getCurrentDate() != null){


   	  lastDate = (Date)shoWorkService.getCurrentDate();
    	  DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	  String updatedDate = sdf.format(lastDate);
    	  System.out.println(updatedDate);
     
  	%>
<input type="text" name="lastUpdatedDate" id="lastUpdatedDate" value="<%=updatedDate %>" />

<%} else{%>
<label class="value">-</label>
<%}}} else{%>
<label class="value">-</label>
<%}%>


</div>

<h4>Work Left Incomplete</h4>

<div class="Block">
<label>Adequacy of Medical and Nusing Staff</label>
<select name="nursingStaff" id="nursingStaff" onclick="showNursingStaffhi();">

<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>

<div id="nursingStaffId" style="display: none">

<label>Remarks</label>
<input type="text" name="nursingStaffRemarks" id="nursingStaffRemarks" MAXLENGTH="200" />

</div>

<div class="clear"></div>

<label>Arrangement of Specialist Cover</label>
<select name="specialistCover" id="specialistCover" onclick="showSpecialistCover();" >
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>

<div id="specialistCoverId" style="display: none">

<label>Remarks</label>
<input type="text" name="specialistCoverRemarks" id="specialistCoverRemarkss" MAXLENGTH="200" />

</div>

<div class="clear"></div>

<label>Adequacy of Medical Store</label>
<select name="medicalStore" id="medicalStore" onclick="showMedicalStore();">
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>

<div id="medicalStoreId" style="display: none">

<label>Remarks</label>
<input type="text" name="medicalStoreRemarks" id="medicalStoreRemarks" MAXLENGTH="200" />

</div>

<div class="clear"></div>

<label>Adequacy of Hygiene Chemical</label>
<select name="hygineChemical" id="hygineChemical" onclick="showHygineChemical();">
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>

<div id="hygineChemicalId" style="display: none">

<label>Remarks</label>
<input type="text" name="hygineChemicalRemarks" id="hygineChemicalRemarks"  MAXLENGTH="200"/>

</div>

<div class="clear"></div>

<label>Dental Arrangement</label>
<select name="dentalCarries" id="dentalCarries" onclick="showDentalArrangement();">
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>

<div id="dentalCarriesId" style="display: none">

<label>Remarks</label>
<input type="text" name="dentalCarriesRemarks" id="dentalCarriesRemarks" MAXLENGTH="200" />

</div>

</div>

<input type="button" name="Button" value="Submit" class="button" onclick="submitForm('shoWorkService','/hms/hms/mis?method=submitWorkService')"/>
<input type="reset" name="Reset" value="Reset" class="button" tabindex="1" onClick="submitFormForButton('shoWorkService','/hms/hms/mis?method=showWorkService');" accesskey="r" />

<div class="clear PaddingTop15"></div>

<div class="division"></div>

<div class="clear PaddingTop15"></div>

<div class="bottom">
<label>Changed By</label> 
<label class="value"><%=userName%></label>
<label>Changed Date</label> 
<label class="value"><%=currentDate%></label>
<label>Changed Time</label> 
<label class="value"><%=time%></label> 
<input	type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> 
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>


<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>


<script type="text/javascript">

function showNursingStaffhi(){
if(document.getElementById('nursingStaff').value == 'Yes'){
  	document.getElementById('nursingStaffId').style.display='inline';
}else if(document.getElementById('nursingStaff').value == 'No'){
	document.getElementById('nursingStaffId').style.display='none';
}
}

function showSpecialistCover(){
	if(document.getElementById('specialistCover').value == 'Yes'){
	  	document.getElementById('specialistCoverId').style.display='inline';
	}else if(document.getElementById('specialistCover').value == 'No'){
		document.getElementById('specialistCoverId').style.display='none';
	}
}



function showMedicalStore(){
	if(document.getElementById('medicalStore').value == 'Yes'){
	  	document.getElementById('medicalStoreId').style.display='inline';
	}else if(document.getElementById('medicalStore').value == 'No'){
		document.getElementById('medicalStoreId').style.display='none';
	}
}



function showHygineChemical(){
	if(document.getElementById('hygineChemical').value == 'Yes'){
	  	document.getElementById('hygineChemicalId').style.display='inline';
	}else if(document.getElementById('hygineChemical').value == 'No'){
		document.getElementById('hygineChemicalId').style.display='none';
	}
}


function showDentalArrangement(){
	if(document.getElementById('dentalCarries').value == 'Yes'){
	  	document.getElementById('dentalCarriesId').style.display='inline';
	}else if(document.getElementById('dentalCarries').value == 'No'){
		document.getElementById('dentalCarriesId').style.display='none';
	}
}
</script>
</form>