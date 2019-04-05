<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.EmpAfmsfDet"%>

<%@page import="jkt.hms.masters.business.MasMedicalCategory"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>


<script type="text/javascript">
	function checkAfmsfReceipt(){

	var errMsg ="";
	
		if(document.getElementById("name").value==""){
			errMsg="First Name should not be Blank\n"
		}
		if(document.getElementById("rankId").value==0)
		{
			errMsg=errMsg+"Select Rank \n"
		}
		
		if(document.getElementById("presentUnit").value==0){
			errMsg=errMsg+"Select posted from Unit \n"
		}
		
		if(document.getElementById("trade").value == 0){
		   errMsg=errMsg+"Select Trade \n"
		}
		
		if(document.getElementById("medicalCategory").value == 0){
		   errMsg=errMsg+"Select medicalCategory \n"
		}
		/*
		if(document.getElementById("Authority").value == ""){
		   errMsg=errMsg+"Authority of posting In should not be Blank \n"
		}
		
		if(document.getElementById("suffix").value == ""){
		  errMsg=errMsg+"Select suffix \n"
		}
		*/
		
		if(document.getElementById("lname").value==""){
			errMsg=errMsg+"Last Name should not be Blank\n"
		}
		/*
		if(document.getElementById("receiptLatterNo").value == "")
		{
		document.getElementById("docStatus").value = 'd';  
		}else{
		 document.getElementById("docStatus").value = 'e';
		}
		
		
		if(document.getElementById("afmsType").value == "OUT"){
		   errMsg=errMsg+"service person cleared this place you can't update the data \n"
		}
		*/
		if(errMsg == ""){
			return true
		}else{
			alert(errMsg)
			return false;
		}
	}
	/*
	function displayextrafields(){
				var medicalcatId = document.getElementById('medicalCategory').value;
				if(medicalcatId == 1){
				      document.getElementById('medDiv').style.display = 'none';
				}else if(medicalcatId != 1){
					  document.getElementById('medDiv').style.display = 'inline';
				}
  }
  
  function displayotherfields(){
              var fromunit = document.getElementById("lastUnit").value;
              if(fromunit == "Other"){
              document.getElementById('addUnitDiv').style.display = 'inline';
             // document.getElementById('newline').style.display = 'inline';
              }else{
              document.getElementById('addUnitDiv').style.display = 'none';
              }
  }
  */
 function openPopupWindowForUnit()
 {
  var url="/hms/hms/adt?method=showUnitSearchJsp";
  newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
 }
 /*
 function jsSetUnitData(unitId)
{
 for(var i=0;i<document.getElementById("lastUnit").length;i++)
 {
	 if (document.getElementById("lastUnit").options[i].value==unitId)
	 {
	 	document.getElementById("lastUnit").selectedIndex = i;
	 }
 }
 var check = document.getElementById("lastUnit").value;
     if(check != "Other"){
      document.getElementById('addUnitDiv').style.display = 'none';
     }
}
 */
 	</script> <script type="text/javascript" language="javascript">
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



<%
			 	String userName = "";
				String remarks="";
				String jspFlag="";
			 	if (session.getAttribute("userName") != null) {
			 		userName = (String) session.getAttribute("userName");
			 	}
			 	Map<String, Object> utilMap = new HashMap<String, Object>();
			 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			 	Box box = HMSUtil.getBox(request);
			 	
			 	String currentDate = (String) utilMap.get("currentDate");
			 	String time = (String) utilMap.get("currentTime");
			 	String hinNo=null;
			 	String serviceNo=null;

			 	Map<String, Object> map = new HashMap<String, Object>();
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
					 	
			 	List<Object> employeeList = null;
			 	List<MasRank>rankList=null;
				List<MasUnit>unitList=null;
				List<MasTrade>tradeList=null;
				List<MasMedicalCategory>masMedicalList=null;
			 		
			 	
			 	if (map.get("employeeList") != null) {
			 		employeeList = (List<Object>) map.get("employeeList");
			 	}
			 	if (map.get("rankList") != null) {
			 		rankList = (List<MasRank>) map.get("rankList");
			 	}
			 	if (map.get("unitList") != null) {
			 		unitList = (List<MasUnit>) map.get("unitList");
			 	}
			 	if (map.get("serviceNo") != null) {
			 		serviceNo = (String) map.get("serviceNo");
			 	}
			 	if (map.get("jspFlag") != null) {
			 		jspFlag = (String) map.get("jspFlag");
			 	}
				if (map.get("tradeList") != null) {
					tradeList = (List<MasTrade>) map.get("tradeList");
			 		
			 	}
				if (map.get("masMedicalList") != null) {
					masMedicalList = (List<MasMedicalCategory>) map.get("masMedicalList");
			 		
			 	}
			 				 
			 	if(map.get("message") != null){
					String message = (String)map.get("message");
					%> 
					<div class="Clear"></div>	
					<label class="noWidth"> <span> <%=message %> </span> </label>
					<div class="Clear"></div>	
					 <% } %>
<!--
jspFlag--- lmc : Low Med Cat Psychiatric Patient Counseling Entry
jspFlag -- cam : Cases of Alcoholism Monitoring Entry
-->
<script type="text/javascript" language="javascript">
<%
String screenName="";
String displayStyCamD="";
String displayStyLmc="";
if(jspFlag.equals("lmc")){
	screenName="Low Med Cat Psychiatric Patient Counseling Entry";
	displayStyCamD="none";
	displayStyLmc="inline";
%>
//document.getElementById('lmc').style.display = 'inline';
//document.getElementById('cam').style.display = 'none';
//document.getElementById('camD').style.display = 'none';
<%
}else if(jspFlag.equals("cam")){
	screenName="Cases of Alcoholism Monitoring Entry";
	displayStyCamD="inline";
	displayStyLmc="none";
	%>
	
	//document.getElementById('lmc').style.display = 'none';
	//document.getElementById('camD').style.display = 'inline';
	//document.getElementById('cam').style.display = 'inline';
	<%
}
//System.out.println("jspFlag--->"+jspFlag);
%>

</script>	

<div class="titleBg">
<h2><%=screenName%></h2>
</div>

<div class="Clear"></div>	
<div class="Block">

<form name="lmcPsychiatricPatientCounseling" method="post">
<input type="hidden" name="docStatus" value="" id="docStatus" />



<h4>Details</h4>



<label>Service No.</label> <input type="text" id="serviceNo" name="<%=SERVICE_NO%>"	title="Fill Service No. first." value="" MAXLENGTH="30"	onblur="submitProtoAjaxWithDivName('lmcPsychiatricPatientCounseling','/hms/hms/sHO?method=getHinNoForDiseaseSHO&respForm=<%=jspFlag%>&serviceNo='+this.value,'deficientId');" tabindex="1"/>

<label>Rank<span>*</span></label> 
<select name="<%=RANK_ID %>" id="rankId" tabindex="2">
<option value="0">Select</option>
<%
		for (MasRank masRank : rankList) {
%>
<option value="<%=masRank.getId() %>"><%=masRank.getRankName()%></option>
<%
		}
%>
</select>


<label>First Name<span>*</span></label> <input type="text"	name="<%=EMPLOYEE_FIRST_NAME %>" id="name" value="" MAXLENGTH="30"	validate="Name,String,Yes" tabindex="3"/>
<div class="Clear"></div>
<label>Last Name<span>*</span></label> <input type="text" name="<%=EMPLOYEE_LAST_NAME %>" id="lname" value="" MAXLENGTH="30" tabindex="4" /> 
	



<label>Trade<span>*</span></label> <!--  <input type="text"  name="<%="Trade" %>" id="Trade" value="" class="textbox_date" MAXLENGTH="30" validate="Name,String,Yes" />--> 
<select name="<%=TRADE%>" id="trade" tabindex="5">
	<option value="0">Select</option>
	<%
						for (MasTrade masTrade : tradeList) {
					%>
	<option value="<%=masTrade.getId()%>"><%=masTrade.getTradeName()%></option>
	<%
						}
					%>
</select> 


<label>Present Unit<span>*</span></label> <select name="<%=PRESENT_UNIT %>" id="presentUnit" tabindex="6">
	<%
	for (MasUnit masUnit : unitList) {
					%>
	<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>
	<%
						}
					%>
</select>
<div class="Clear"></div>
<label>Age<span>*</span></label> <input type="text"	name="<%=AGE%>" id="age" value="" tabindex="7" maxlength="3"/>
<label>Medical Category</label> <select name="<%=MEDICAL_CATEGORY %>" id="medicalCategory" tabindex="8">
	<!-- onchange="displayextrafields();" -->
	<option value="0">Select</option>
	<%
						for (MasMedicalCategory masMedical : masMedicalList) {
					%>
	<option value="<%=masMedical.getId()%>"><%=masMedical.getMedicalCategoryName()%></option>
	<%
						}
					%>
</select>




<label>Diagnosis<span>*</span></label> <input id="diagnosis" type="text" name="<%=DIAGNOSIS%>"	value="" validate="Diagnosis,string,no" maxlength="30" tabindex="9" />
<div class="Clear"></div>
<label>Last Med Board<span>*</span></label> <input type="text"	id="lastMedBoardDate" name="<%=LAST_MED_BOARD_DATE%>" value="<%=currentDate %>"	class="calDate" MAXLENGTH="30" readonly="readonly" /> <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate %>',document.lmcPsychiatricPatientCounseling.<%=LAST_MED_BOARD_DATE%>,event);" />



<label>Next MB Due<span>*</span></label> <input type="text"	id="nextreviewDate" name="<%=NEXT_REVIEW_DATE%>" value="<%=currentDate %>"	class="calDate" MAXLENGTH="30" readonly="readonly" /><img id="calendar"	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender"	onClick="setdate('<%=currentDate %>',document.lmcPsychiatricPatientCounseling.<%=NEXT_REVIEW_DATE%>,event);" />

<label>Counseling Date</label> <input type="text" id="counselingDate" name="<%=COUNSELING_DATE%>" value="<%=currentDate %>" class="calDate"	MAXLENGTH="30" readonly="readonly" /> <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"validate="Pick a date" class="calender"	onClick="setdate('<%=currentDate %>',document.lmcPsychiatricPatientCounseling.<%=COUNSELING_DATE%>,event);" />
<div id="camD" style="display: <%=displayStyCamD%>">
<div class="Clear"></div>
<label>Warning Letter<span>*</span></label> 
 <select
	name="<%=WARNING_LETTER%>" id="warningLetter" tabindex="8">
	<option value="NO">NO</option>
	<option value="YES">YES</option>
</select>

<label>Retention in Service</label> <input type="text"	id="retentionService" name="<%=RETENTION_SERVICE%>" value="" MAXLENGTH="20" validate="Retention in Service,String,NO"/>
<div class="Clear"></div>

<label>Date of Posting</label> <input type="text"	id="dateOfPosting" name="<%=DATE_OF_POSTING%>" value="<%=currentDate %>" class="calDate" MAXLENGTH="30" readonly="readonly" /> <img id="calendar"	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender"	onClick="setdate('<%=currentDate %>',document.lmcPsychiatricPatientCounseling.<%=DATE_OF_POSTING%>,event);" />
	
<label>Fresh/Old<span>*</span></label> 
 <select name="<%=CATEGORY_NAME%>" id="categoryName" tabindex="8">
	<!-- onchange="displayextrafields();" -->
	<option value="0">Select</option>
	<option value="Fresh">Fresh</option>
	<option value="Old">Old</option>
</select>

<div class="Clear"></div>
<label>Date of Diagnosis</label> <input type="text"	id="diagnosisDate" name="<%=DIAGNOSIS_DATE%>" value="<%=currentDate %>" class="calDate"	MAXLENGTH="30" readonly="readonly" /> <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate %>',document.lmcPsychiatricPatientCounseling.<%=DIAGNOSIS_DATE%>,event);" />

	</div>
<div class="Clear"></div>
	
<label>Remarks</label> <textarea name="<%=REMARKS%>" id="<%=REMARKS%>"	class="large" tabindex="10" onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"	maxlength=100 /> <%=remarks%></textarea>
</div>

<div class="Clear"></div>

<div class="division"></div>
<input type="hidden" name="<%=ENTRY_FLAG%>" value="<%=jspFlag%>" readonly="readonly" MAXLENGTH="8" /> 
<input type="hidden" name="<%= CHANGED_BY%>" value="<%=userName%>" readonly="readonly" MAXLENGTH="8" />
	<input type="hidden" name="<%= CHANGED_DATE %>" value="<%=currentDate%>" readonly="readonly"/> 
	<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" readonly="readonly"/> 
	
	<!-- 
	jspFlag--- lmc : Low Med Cat Psychiatric Patient Counseling Entry
	jspFlag -- cam : Cases of Alcoholism Monitoring Entry
	 -->
<input type="button" name="edit" value="Submit" class="button"	onClick="if(checkAfmsfReceipt()){submitForm('lmcPsychiatricPatientCounseling','sHO?method=editLowMedCatPsychiatricPatientCouneling&status=<%=jspFlag%>');}" tabindex="11"/>


<input type="button" name="Reset" onclick="submitForm('lmcPsychiatricPatientCounseling','sHO?method=showLowMedCatPsychiatricPatientCounelingEntry');" value="Reset" class="button"/>


	<div id="cam"  style="display: <%=displayStyCamD%>">
	<input type="button" name="Reset" onclick="submitForm('lmcPsychiatricPatientCounseling','sHO?method=showCaseOfAlcoholismMonitoringEntry');" value="Reset" class="button"/>
	</div>
	
<div class="Clear"></div>

<div id="edited"></div>



<script>
    //document.getElementById('nxtspace').style.display = 'inline';
 </script>


