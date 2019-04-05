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

<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasRelation"%><script type="text/javascript" language="javascript"
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
	
		if(errMsg == ""){
			return true
		}else{
			alert(errMsg)
			return false;
		}
	}
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
					 	
			 	List<MasRank> rankList=null;
				List<MasUnit> unitList=null;
				List<MasAdministrativeSex> masAdministrativeSexList=null;
				List<MasMedicalCategory> masMedicalList=null;
				List<MasRelation> relationList = null;
				if(map.get("relationList") != null){
					relationList = (List<MasRelation>)map.get("relationList");
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
				if (map.get("masAdministrativeSexList") != null) {
					masAdministrativeSexList = (List<MasAdministrativeSex>) map.get("masAdministrativeSexList");
			 		
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
<%
String screenName="Confirmed Cases (H1N1) Entry";
%>

<div class="titleBg">
<h2><%=screenName%></h2>
</div>
<div class="Block">
<div class="Clear"></div>				
<div class="Clear"></div>
<form name="confirmedCasesH1N1" method="post">
<div class="Clear"></div>
<div class="titleBg">
<h4>PERSONAL PARTICULARS</h4>
</div>
<div id="Block">
<div id="serviceAndHinDiv">
<label style=" width: 310px">Service No.</label> <input
	type="text" id="serviceNo" name="<%=SERVICE_NO%>" validate = "name ,number ,no"
	title="Fill Service No. first." value="" MAXLENGTH="30"
	onblur="submitProtoAjaxWithDivName('confirmedCasesH1N1','/hms/hms/sHO?method=getHinNoSHO&serviceNo='+this.value,'serviceAndHinDiv');" tabindex="1"/>
<label style=" width: 310px"> Hin No</label> <input
	type="text" name="<%=HIN_ID%>" value="" class="textbox_date" validate = "name ,number ,no"
	MAXLENGTH="30" tabindex="2"/>
	</div>
</div>
<div class="Clear"></div>
 <div id="deficientId">
 <label style=" width: 310px"><span>*</span> Patient Name</label> <input type="text"
	name="<%=P_FIRST_NAME %>" id="pFirstName" value="" MAXLENGTH="30"
	validate="Patient Name,String,Yes" tabindex="3"/> 
	
	<label style=" width: 310px"><span>*</span> Relation With Service Person</label> <select
	name="<%=RELATION_ID %>" id="relationId" tabindex="4">
	<option value="0">Select</option>
	<%
							for (MasRelation masRelation : relationList) {
						%>
	<option value="<%=masRelation.getId() %>"><%=masRelation.getRelationName()%></option>
	<%
						}
					%>
</select>
 <div class="Clear"></div>

 <label style=" width: 310px"><span>*</span> Rank</label> <select
	name="<%=RANK_ID %>" id="rankId" tabindex="5">
	<option value="0">Select</option>
	<%
							for (MasRank masRank : rankList) {
						%>
	<option value="<%=masRank.getId() %>"><%=masRank.getRankName()%></option>
	<%
						}
					%>
</select>
<label style=" width: 310px"><span>*</span> Service Person Name</label> <input type="text"
	name="<%=EMPLOYEE_FIRST_NAME %>" id="employeeFirstName" value="" MAXLENGTH="30"
	validate="Service Person Name,String,Yes" tabindex="6"/> 
	
<div class="Clear"></div>

	<label style=" width: 310px"><span>*</span> Unit</label> <select
	name="<%=PRESENT_UNIT %>" id="presentUnit" tabindex="7">
	<%
	for (MasUnit masUnit : unitList) {
					%>
	<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>
	<%
						}
					%>
</select>
<label style=" width: 310px"><span>*</span> Age</label> <input type="text"
	name="<%=AGE%>" id="age" value="" validate = "name ,number ,no" tabindex="8" maxlength="3"/>

<div class="Clear"></div>
<label style=" width: 310px"><span>*</span> Sex</label> 
<select name="<%=SEX%>" id="sex" tabindex="9">
	<option value="0">Select</option>
	<%
						for (MasAdministrativeSex administrativeSex : masAdministrativeSexList) {
					%>
	<option value="<%=administrativeSex.getId()%>"><%=administrativeSex.getAdministrativeSexName()%></option>
	<%
						}
					%>
</select> 



<div class="Clear"></div>
 </div>
<div class="titleBg">
<h4>DETAILS OF HEALTH CARE FACILITY</h4>
</div>
<div class="Clear"></div>
<label style=" width: 310px"><span>*</span>Medical Facility Where First Reported</label> 

<input id="medicalFacilityFirst" type="text" name="<%=MEDICAL_FACILITY_FIRST%>"
	value="" validate="Medical Facility Where First Reported,string,no" maxlength="50" tabindex="10" />

<label style=" width: 310px"><span>*</span>Medical Unit Where Admitted</label> 
<input id="medicalUnitFirstAdmitted" type="text" name="<%=MEDICAL_UNIT_FIRST_ADMITTED%>"
	value="" validate="Medical Unit Where Admitted,string,no" maxlength="50" tabindex="11" />
<div class="Clear"></div>
<label style=" width: 310px"><span>*</span> Date of Onset</label> <input type="text"
	id="dateOfOnset" name="<%=DATE_OF_ONSET%>" value="<%=currentDate %>"
	class="calDate" MAXLENGTH="30" readonly="readonly" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate %>',document.confirmedCasesH1N1.<%=DATE_OF_ONSET%>,event);" />

<label style=" width: 310px"><span>*</span> Date of Admission</label> <input type="text"
	id="dateOfAdmission" name="<%=DATE_OF_ADMISSION%>" value="<%=currentDate %>"
	class="calDate" MAXLENGTH="30" readonly="readonly" /><img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate %>',document.confirmedCasesH1N1.<%=DATE_OF_ADMISSION%>,event);" />
<div class="Clear"></div>
<div class="Clear"></div>
<div class="titleBg">
<h4>HISTORY (Please provide details)</h4>
</div>

<label style=" width: 310px"><span>*</span>Contact with cases</label> 
<input id="contact" type="text" name="<%=CONTACT%>"
	value="" validate="Contact with cases,string,no" maxlength="50" tabindex="12" />

<label style=" width: 310px"><span>*</span>Travel/Movement</label> 
<input id="travell" type="text" name="<%=TRAVELL%>"
	value="" validate="Travel/Movement,string,no" maxlength="50" tabindex="13" />
<div class="Clear"></div>
<label  style=" width: 310px"><span>*</span>Clinical Features </label> 
<select name="<%=CLINICAL_FEATURES%>" id="clinicalFeatures" tabindex="14" validate="Clinical Features,string,no">
	
	
	<option value="">Select</option>
	<option value="Fever">Fever</option>
	<option value="Cough">Cough</option>
	<option value="Soar Throat">Soar Throat</option>
	<option value="Rhinorrhoea">Rhinorrhoea</option>
	<option value="Myelgia">Myelgia</option>
	<option value="Other">Other</option>
</select>

<label  style=" width: 310px"><span>*</span>Respiratory distress situations</label> 
<input id="respairatorySystem" type="text" name="<%=RESPIRATORY_SYSTEM%>"
	value="" validate="Respiratory distress situations,string,no" maxlength="50" tabindex="15" />
<div class="Clear"></div>
<div class="titleBg">
<h4>DIAGNOSIS</h4></div>
<div class="Clear"></div>
<label style=" width: 310px"><span>*</span>Date Sample sent</label>  <input type="text"
	id="dateSampleSent" name="<%=DATE_SAMPLE_SENT%>" value="<%=currentDate %>"
	class="calDate" MAXLENGTH="30" readonly="readonly" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate %>',document.confirmedCasesH1N1.<%=DATE_SAMPLE_SENT%>,event);" />

<label style=" width: 310px"><span>*</span>Testing Laboratory</label> 
<input id="testingLaboratory" type="text" name="<%=TESTING_LABORATORY%>"
	value="" validate="Testing Laboratory,string,no" maxlength="50" tabindex="16" />
<div class="Clear"></div>
<label style=" width: 310px"><span>*</span> Date of Report</label> <input type="text"
	id="dateOfReport" name="<%=DATE_OF_REPORT%>" value="<%=currentDate %>"
	class="calDate" MAXLENGTH="30" readonly="readonly" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate %>',document.confirmedCasesH1N1.<%=DATE_OF_REPORT%>,event);" />

<label style=" width: 310px"><span>*</span> Result</label> <input id="result" type="text" name="<%=RESULT%>"
	value="" validate="Result,string,no" maxlength="50" tabindex="17" />
<div class="Clear"></div>
<label style=" width: 310px"><span>*</span>Treatment</label> 
<input id="treatment" type="text" name="<%=TREATMENT%>"
	value="" validate="TREATMENT,string,no" maxlength="50" tabindex="18" />


<label style=" width: 310px" ><span>*</span>Present Condition</label> 
<input id="presentCondition" type="text" name="<%=PRESENT_CONDITION%>"
	value="" validate="Present Condition,string,no" maxlength="50" tabindex="19" />
<div class="Clear"></div>
<input type="hidden" name="<%= CHANGED_BY%>" value="<%=userName%>" readonly="readonly" MAXLENGTH="8" />
	<input type="hidden" name="<%= CHANGED_DATE %>" value="<%=currentDate%>" readonly="readonly"/> 
	<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" readonly="readonly"/> 
	
	<!-- 
	jspFlag--- lmc : Low Med Cat Psychiatric Patient Counseling Entry
	jspFlag -- cam : Cases of Alcoholism Monitoring Entry
	 -->
	
		<input type="button" name="edit" value="Submit" class="button" 
	onClick="if(checkAfmsfReceipt()){submitForm('confirmedCasesH1N1','sHO?method=saveConfirmedCasesH1N1');}" tabindex="11"/>
	<input type="button" name="Reset" onclick="submitForm('confirmedCasesH1N1','sHO?method=showConfirmedCasesH1N1');" value="Reset" class="button"/>
	<input type="button" name="edit" value="Print" class="button" />
	<input type="button" name="edit" value="Back" class="button" />
	
<div class="Clear"></div>

<div id="edited"></div>
</form>
</div>


<script>
    //document.getElementById('nxtspace').style.display = 'inline';
 </script>


