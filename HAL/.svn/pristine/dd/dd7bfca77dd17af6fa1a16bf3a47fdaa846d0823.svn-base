
<%@page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@page import="jkt.hms.masters.business.MbTypeOfEntryMaster"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@page import="jkt.hms.masters.business.MasRank"%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%><%@ page import="jkt.hms.util.HMSUtil"%>
<SCRIPT language=javascript src="/hms/jsp/js/common.js"
	type=text/javascript></SCRIPT>

<SCRIPT language=javascript src="/hms/jsp/js/hms.js"
	type=text/javascript></SCRIPT>

<SCRIPT language=javascript src="/hms/jsp/js/calendar.js"
	type=text/javascript></SCRIPT>


<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>

<SCRIPT>
	<%

		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String dateCal=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(dateCal.length()<2){
			dateCal="0"+dateCal;
		}
		Map<String, Object> utilMap = new HashMap<String, Object>();
		String userName="";
		if(session.getAttribute("userName")!=null)
		 userName=(String)session.getAttribute("userName");
		
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		//String Session=(String) utilMap.get("session");
		String time = (String) utilMap.get("currentTime");		
	%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>';
	
	</script>

<script type="text/javascript">

animatedcollapse.addDiv('jason', 'fade=1,height=80px')
animatedcollapse.addDiv('kelly', 'fade=1,height=100px')
animatedcollapse.addDiv('michael', 'fade=1,height=120px')

animatedcollapse.addDiv('slide1', 'fade=0,speed=400,group=pets')
animatedcollapse.addDiv('slide2', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide3', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide4', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide5', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide6', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide7', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide8', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide9', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide10', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide11', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide12', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide13', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.init()


</script>

<script type="text/javascript">
<%
Map<String, Object> map = new HashMap<String, Object>();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}
List<MbTypeOfEntryMaster> typeOfEntryMasterList = new ArrayList<MbTypeOfEntryMaster>();
List<MasUnit> masUnitList = new ArrayList<MasUnit>();
List<MasMaritalStatus> masMaritalStatusList = new ArrayList<MasMaritalStatus>();
List<MasRank> masRankList1 = new ArrayList<MasRank>();
String entryno="";
String entryno1="";
if(map.get("medicalEntryNo")!=null)
{
	entryno = (String) map.get("medicalEntryNo");

}
if(map.get("medicalEntryNo1")!=null)
{
	entryno1 = (String) map.get("medicalEntryNo1");

}

if(map.get("mbTypeOfEntryMaster")!=null)
{
	typeOfEntryMasterList = (List) map.get("mbTypeOfEntryMaster");

}
if(map.get("masUnitList")!=null)
{
	masUnitList = (List) map.get("masUnitList");

}
if(map.get("masMaritalStatusList")!=null)
{
	masMaritalStatusList = (List) map.get("masMaritalStatusList");

}


if(map.get("masRankList")!=null)
{
	masRankList1 = (List) map.get("masRankList");

}
String url="";
if(map.get("url") != null){
	url = (String)map.get("url");
}
%>
</script>
<% 
String message="";
if (map.get("message") != null) {
       message = (String) map.get("message");
      System.out.println("messssssss"+message);
   }
if(!message.equalsIgnoreCase("")){
	 System.out.println("messssssss bbbbbllllll"+message);
%>
<h2><%=message %></h2>
<%} %>


<!--main content placeholder starts here-->
<div id="contentHolder">
<h6>Medical Examination Report On Entry (AFMSF-2)</h6>
<div class="Clear"></div>
<form name="medicalBoardExaminationReport" action="" method="post">
<!--Block One Starts-->
<div class="blockFrame"><label>Yearly Serial No. <span>*</span>
</label> <label class="value"><%=entryno %></label> <input type="hidden"
	value="<%=entryno %>" name="<%=YEARLY_SERIAL_NO%>" tabindex="2" /> <label>Monthly
Serial No. <span>*</span> </label> <label class="value"><%=entryno1 %></label> <input
	type="hidden" value="<%=entryno1 %>" name="<%=MONTHLY_SERIAL_NO%>"
	tabindex="2" /> <label>Entry Date <span>*</span> </label> <input
	tabindex="1" name="<%=ENTRY_OF_DATE %>" option value="<%=date %>"
	validate="Entry Date,date,yes" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardExaminationReport.<%=ENTRY_OF_DATE%>,event);" />
<div class="Clear"></div>

<label>Type of Entry <span>*</span> </label> <select
	name="<%= TYPE_OF_ENTRY %>" tabindex=1
	validate="Type Of Entry,String,no">
	<option value="">Select</option>
	<%
		for (MbTypeOfEntryMaster mbTypeOfEntryMaster : typeOfEntryMasterList) {
	%>

	<option value="<%=mbTypeOfEntryMaster.getId()%>"><%=mbTypeOfEntryMaster.getTypeName()%></option>

	<%
		}
	%>
</select> <label>Batch No. <span>*</span> </label> <input tabindex="1"
	name="<%=BATCH1_NO %>" type="text" onkeyup="isAlpha(BATCH1_NO)"
	validate="Batch No,String,yes" maxlength="25" /> <label>Chest
No. <span>*</span> </label> <input tabindex="1" name="<%=CHEST_NO %>"
	type="text" validate="Chest No,String,yes" maxlength="25" />
<div class="Clear"></div>

<label>Roll No. <span>*</span> </label> <input tabindex="1"
	name="<%=ROLL_NO %>" type="text" onkeyup="isNumber(this)"
	maxlength="10" validate="Roll No,String,yes" /> <label>Medical
exam held <span>*</span> </label> <select name="<%= MEDICAL_EXAM_HELD_AT %>"
	tabindex=1 validate="Medical Exam Held At,String,yes">
	<option value="">Select</option>
	<%
		for (MasUnit masUnit : masUnitList) {
	%>

	<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>

	<%
		}
	%>
</select> <label>Medical Status <span>*</span> </label> <select
	name="<%= MEDICAL_STATUS %>" tabindex=1
	validate="Medical Status,String,yes">
	<option value="">Select</option>
	<option value="f">Fit</option>
	<option value="u">Unfit</option>
</select>
<div class="Clear"></div>

<label>Name in full <span>*</span> </label> <input tabindex="1"
	name="<%=FULL_NAME %>" type="text" validate="Full Name,String,yes"
	maxlength="25" /> <label>Date of Birth <span>*</span> </label> <input
	tabindex="1" name="<%=DATE_OF_BIRTH %>" option value="<%=date %>"
	class="calDate" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');"
	validate="Date Of Birth,date,yes" /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onclick="setdate('',medicalBoardExaminationReport.<%=DATE_OF_BIRTH%>,event);" />
<label>Martial Status <span>*</span> </label> <select
	name="<%= MARITIAL_STATUS %>" tabindex=1
	validate="Maritial Status,String,yes">
	<option value="">Select</option>
	<%
		for (MasMaritalStatus masMaritalStatus : masMaritalStatusList) {
	%>

	<option value="<%=masMaritalStatus.getId()%>"><%=masMaritalStatus.getMaritalStatusName()%></option>

	<%
		}
	%>
</select>
<div class="Clear"></div>

<label>Service <span>*</span> </label> <select tabindex="1"
	name="<%=SERVICE %>" validate="Service,String,yes">
	<option value="">Select one</option>
	<option value="A">ARMY</option>
	<option value="N">NAVY</option>
	<option value="F">AIR FORCE</option>
</select> <label>P. No.(Only for Ser)</label> <input tabindex="1"
	name="<%=P_NO %>" type="text" maxlength="1" /> <label>Rank(Only
for Ser.)</label> <input tabindex="1" type="text" name=<%=RANK%> maxlength="25" />



<div class="Clear"></div>

<label>Hours of flown</label> <input tabindex="1"
	name="<%=HOURS_OF_FLOWN %>" type="text" maxlength="10" /> <label>Permanent
Address</label> <textarea tabindex="1" name="<%=PERMANENT_ADDRESS %>"
	class="large" onkeyup="chkLength(this,100);"></textarea>

<div class="Clear"></div>
<div class="division"></div>

<label class="large">Identification Marks 1 <span>*</span> </label> <input
	tabindex="1" name="<%=IDENTIFICATION_MARKS1 %>" type="text"
	validate="Identification1,String,yes" maxlength="25" /> <label
	class="large">Arms Corps/Branch/Trade <span>*</span> </label> <input
	tabindex="1" name="<%=ARMS_CROPS %>" type="text"
	validate="Arms Crops,String,yes" maxlength="50" />

<div class="Clear"></div>

<label class="large">Identification Marks 2 <span>*</span> </label> <input
	tabindex="1" name="<%=IDENTIFICATION_MARKS2 %>" type="text"
	validate="Identification2,String,yes" maxlength="25" /> <label
	class="large">Date of reporting <span>*</span> </label> <input
	tabindex="1" name="<%=DATE_OF_REPORTING %>" class="calDate" option
	value="<%=date %>" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');"
	validate="Date Of reporting,date,yes" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardExaminationReport.<%=DATE_OF_REPORTING%>,event);" />

<div class="Clear"></div>

<label class="large">Date of Completion <span>*</span> </label> <input
	tabindex="1" name="<%=DATE_OF_COMPLETION %>" class="calDate" option
	value="<%=date %>" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');"
	validate="Date Of Completion,date,yes" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardExaminationReport.<%=DATE_OF_COMPLETION%>,event);" />


<label class="large">Document Forwarded Date</label> <input tabindex="1"
	name="<%=DOCUMENT_FORWARD_DATE1%>" class="calDate" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');"
	validate="Document Forward Date,date,no" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardExaminationReport.<%=DOCUMENT_FORWARD_DATE1%>,event);" />

<div class="Clear"></div>

<label class="large">Document Forwarded To</label> <input tabindex="1"
	name="<%=DOCUMENT_FORWARD_TO %>" type="text" maxlength="50" /> <label
	class="large">From where he report <span>*</span> </label> <input
	tabindex="1" name="<%=FROM_WHERE_HE_REPORT %>" type="text"
	validate="From where he report,String,yes" maxlength="30" />


<div class="Clear"></div>

</div>

<div class="Clear"></div>
<div class="division"></div>

<div class="blockTitleFixed">Personal Statement <a
	href="javascript:animatedcollapse.toggle('slide1')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div id="slide1"><input tabindex="1" type="button" name="service"
	class="cmnButton" value="Add"
	onclick="generateRowMdicalBoard1('amcDetailId');" /> <input
	tabindex="1" type="button" name="service" class="cmnButton"
	value="Remove" onclick="removeRowMedicalBoard1(this,'amcDetailId')" />
<input tabindex="1" type="hidden" size="2" value="1" name="noOfRecords"
	id="noOfRecords" />
<div class="Clear"></div>
<div class="tableHolderAuto">
<table width="100%" border="0" id="amcDetailId" cellspacing="0"
	cellpadding="0">
	<tr>
		<th rowspan="2" scope="col">Sr. No.</th>
		<th rowspan="2" scope="col">Relation <span>*</span></th>
		<th colspan="2" scope="col">If Alive</th>
		<th colspan="2" scope="col">If Expired</th>
	</tr>
	<tr>
		<th height="23" scope="col">Age (years)</th>
		<th scope="col">Health</th>
		<th scope="col">Cause of Death</th>
		<th scope="col">died (years)</th>
	</tr>


	<tbody>


		<tr>
			<td width="10%"><input tabindex="1" type="text" size="2"
				value="1" name="<%=SIRIAL_NO%>" id="<%=SIRIAL_NO%>"
				readonly="readonly" /></td>

			<td width="10%"><select tabindex="1" name="<%=RELATION%>"
				value="" id="<%=RELATION%>" validate="Relation,String,yes">

				<option value="Father">FATHER</option>
				<option value="Mother">MOTHER</option>
				<option value="Brother">BROTHER</option>
				<option value="Sister">SISTER</option>


			</select>
			<td width="10%"><input type="text" name="<%=AGE%>" tabindex="1"
				id="<%=AGE%>" onkeyup="isNumber(this)" maxlength="5" /></td>

			<td width="10%"><input tabindex="1" type="text"
				name="<%=HEALTH%>" id="<%=HEALTH %>" maxlength="25" /></td>
			<td width="10%"><input tabindex="1" type="text"
				name="<%=CAUSE_OF_DEATH%>" id="<%=CAUSE_OF_DEATH%>" maxlength="25" />


			</td>
			<td width="10%"><input type="text" name="<%=DIED%>" tabindex="2"
				id="<%=DIED%>" maxlength="5" /></td>
		</tr>



	</tbody>



</table>
</div>

<!--Block one Ends-->
<div class="Clear"></div>
<div class="blockFrame">
<h5>Any Family History of</h5>
<div class="Clear"></div>
<label class="noHeight">Hypertension</label> <input tabindex="1"
	type="checkbox" name="<%=HYPERTENSION%>" value="Y" class="radio2" /> <label
	class="noHeight">Heart Diseases</label> <input tabindex="1"
	type="checkbox" name="<%=HEAR_DISEASE%>" value="Y" class="radio2" /> <label
	class="noHeight">Diabetes</label> <input tabindex="1" type="checkbox"
	name="<%=DIABETES%>" value="Y" class="radio2" /> <label
	class="noHeight">Bleeding Disorder</label> <input tabindex="1"
	type="checkbox" name="<%=BLEEDING_DIORDER%>" value="Y" class="radio2" />

<label class="noHeight">Mental Diseases</label> <input tabindex="1"
	type="checkbox" name="<%=MENTAL_DISEASE%>" value="Y" class="radio2" />

<label class="noHeight">Night Blindness</label> <input tabindex="1"
	type="checkbox" name="<%=NIGHT_BLINDNESS%>" value="Y" class="radio2" />

<div class="Clear"></div>
<div class="Height10"></div>
</div>

<div class="Clear"></div>
<!--Block Four Ends-->

<div class="blockFrame">
<h5>Personal History- Have you ever suffered from any of the
following?</h5>
<div class="Clear"></div>
<label class="large">Chronic Bronchitis/Asthma</label> <label
	class="small">Yes</label> <input tabindex="1" type="radio"
	class="radio" name="<%=ASTHAMA %>" value="Y" checked="checked" /> <label
	class="small">No</label> <input tabindex="1" type="radio" class="radio"
	name="<%=ASTHAMA %>" value="N" /> <label class="large">Discharge
from ears</label> <label class="small">Yes</label> <input tabindex="1"
	type="radio" class="radio" name="<%=DISCHARGE_FROM %>" value="Y"
	checked="checked" /> <label class="small">No</label> <input
	tabindex="1" type="radio" class="radio" name="<%=DISCHARGE_FROM %>"
	value="N" />


<div class="Clear"></div>

<label class="large">Pleuisy/Tuberculosis</label> <label class="small">Yes</label>
<input tabindex="1" type="radio" class="radio" name="<%=PLEURISY %>"
	value="Y" checked="checked" /> <label class="small">No</label> <input
	tabindex="1" type="radio" class="radio" name="<%=PLEURISY %>" value="N" />


<label class="large">Any other ear disease</label> <label class="small">Yes</label>
<input tabindex="1" type="radio" class="radio" name="<%=EAR_DISEASE %>"
	value="Y" checked="checked" /> <label class="small">No</label> <input
	tabindex="1" type="radio" class="radio" name="<%=EAR_DISEASE %>"
	value="N" />

<div class="Clear"></div>

<label class="large">Rheumatism/Frequent sore throats</label> <label
	class="small">Yes</label> <input tabindex="1" type="radio"
	class="radio" name="<%=RHEUMATISM %>" value="Y" checked="checked" /> <label
	class="small">No</label> <input tabindex="1" type="radio" class="radio"
	name="<%=RHEUMATISM %>" value="N" /> <label class="large">Frequent
COUGH & Cold Sinusitis</label> <label class="small">Yes</label> <input
	tabindex="1" type="radio" class="radio" name="<%=FREQUENT_CAUGH %>"
	value="Y" checked="checked" /> <label class="small">No</label> <input
	tabindex="1" type="radio" class="radio" name="<%=FREQUENT_CAUGH %>"
	value="N" />

<div class="Clear"></div>

<label class="large">Chronic Indigestion</label> <label class="small">Yes</label>
<input tabindex="1" type="radio" class="radio"
	name="<%=CHRONIC_INDIGESTION %>" value="Y" checked="checked" /> <label
	class="small">No</label> <input tabindex="1" type="radio" class="radio"
	name="<%=CHRONIC_INDIGESTION %>" value="N" /> <label class="large">Nervous
Breakdown/Mental Illness</label> <label class="small">Yes</label> <input
	tabindex="1" type="radio" class="radio" name="<%=NERVOUS_BRAKDOWN %>"
	value="Y" /> <label class="small">No</label> <input tabindex="1"
	type="radio" class="radio" name="<%=NERVOUS_BRAKDOWN %>" value="N"
	checked="checked" />

<div class="Clear"></div>

<label class="large">Kidney/Bladder trouble</label> <label class="small">Yes</label>
<input tabindex="1" type="radio" class="radio"
	name="<%=KIDENY_BLADDER %>" value="Y" /> <label class="small">No</label>
<input tabindex="1" type="radio" class="radio"
	name="<%=KIDENY_BLADDER %>" value="N" checked="checked" /> <label
	class="large">Fits/Fainting Attacks</label> <label class="small">Yes</label>
<input tabindex="1" type="radio" class="radio"
	name="<%=FITS_FAINTING_ATTACKS %>" value="Y" /> <label class="small">No</label>
<input tabindex="1" type="radio" class="radio"
	name="<%=FITS_FAINTING_ATTACKS %>" value="N" checked="checked" />

<div class="Clear"></div>

<label class="large">STD</label> <label class="small">Yes</label> <input
	tabindex="1" type="radio" class="radio" name="<%=STD %>" value="Y" />
<label class="small">No</label> <input tabindex="1" type="radio"
	class="radio" name="<%=STD %>" value="N" checked="checked" /> <label
	class="large">Severe Head Injury</label> <label class="small">Yes</label>
<input tabindex="1" type="radio" class="radio"
	name="<%=SEVERE_HEAD_INJURY %>" value="Y" /> <label class="small">No</label>
<input tabindex="1" type="radio" class="radio"
	name="<%=SEVERE_HEAD_INJURY %>" value="N" checked="checked" />

<div class="Clear"></div>

<label class="large">Jaundice</label> <label class="small">Yes</label> <input
	tabindex="1" type="radio" class="radio" name="<%=JOUNDICE %>" value="Y" />
<label class="small">No</label> <input tabindex="1" type="radio"
	class="radio" name="<%=JOUNDICE %>" value="N" checked="checked" /> <label
	class="large">Air, Sea, Car, Train Sickness</label> <label
	class="small">Yes</label> <input tabindex="1" type="radio"
	class="radio" name="<%=SICKNESS %>" value="Y" /> <label class="small">No</label>
<input tabindex="1" type="radio" class="radio" name="<%=SICKNESS %>"
	value="N" checked="checked" />

<div class="Clear"></div>

<label class="large">Trachoma</label> <label class="small">Yes</label> <input
	tabindex="1" type="radio" class="radio" name="<%=TRACHOMA %>" value="Y" />
<label class="small">No</label> <input tabindex="1" type="radio"
	class="radio" name="<%=TRACHOMA %>" value="N" checked="checked" /> <label
	class="large">Night Blindness</label> <label class="small">Yes</label>
<input tabindex="1" type="radio" class="radio"
	name="<%=NIGHT_BINDNESS %>" value="Y" /> <label class="small">No</label>
<input tabindex="1" type="radio" class="radio"
	name="<%=NIGHT_BINDNESS %>" value="N" checked="checked" />

<div class="Clear"></div>

<label class="large">Laser Treatment/Surgery for eye</label> <label
	class="small">Yes</label> <input tabindex="1" type="radio"
	class="radio" name="<%=LASER_TREATEMENT %>" value="Y" /> <label
	class="small">No</label> <input tabindex="1" type="radio" class="radio"
	name="<%=LASER_TREATEMENT %>" value="N" checked="checked" /> <label
	class="large">Any other eye disease</label> <label class="small">Yes</label>
<input tabindex="1" type="radio" class="radio" name="<%=EYE_DISEASE %>"
	value="Y" /> <label class="small">No</label> <input tabindex="1"
	type="radio" class="radio" name="<%=EYE_DISEASE %>" value="N"
	checked="checked" />

<div class="Clear"></div>

<label class="valueNoWidth">(For Female Candidates Only)</label>
<div class="Clear"></div>

<label class="large">Breast disease/Discharge</label> <label
	class="small">Yes</label> <input tabindex="1" type="radio"
	class="radio" name="<%=BREAST_DISEASE %>" value="Y" /> <label
	class="small">No</label> <input tabindex="1" type="radio" class="radio"
	name="<%=BREAST_DISEASE %>" value="N" checked="checked" /> <label
	class="large">Amenonhoea/Dysmenonhoea</label> <label class="small">Yes</label>
<input tabindex="1" type="radio" class="radio" name="<%=AMENORRHOEA %>"
	value="Y" /> <label class="small">No</label> <input tabindex="1"
	type="radio" class="radio" name="<%=AMENORRHOEA %>" value="N"
	checked="checked" />

<div class="Clear"></div>

<label class="large">Menorrhagia</label> <label class="small">Yes</label>
<input tabindex="1" type="radio" class="radio" name="<%=MENORRHAGIA %>"
	value="Y" /> <label class="small">No</label> <input tabindex="1"
	type="radio" class="radio" name="<%=MENORRHAGIA %>" value="N"
	checked="checked" /> <label class="large">Pregnancy</label> <label
	class="small">Yes</label> <input tabindex="1" type="radio"
	class="radio" name="<%=PREGNANCY %>" value="Y" /> <label class="small">No</label>
<input tabindex="1" type="radio" class="radio" name="<%=PREGNANCY %>"
	value="N" checked="checked" />

<div class="Clear"></div>

<label class="large">Abortion</label> <label class="small">Yes</label> <input
	tabindex="1" type="radio" class="radio" name="<%=ABORTION %>" value="Y" />
<label class="small">No</label> <input tabindex="1" type="radio"
	class="radio" name="<%=ABORTION %>" value="N" checked="checked" />

<div class="Clear"></div>
<div class="division"></div>

<label class="large3">Have you ever been rejected as medically
unfit for any branch of the Armed forces?</label> <label class="small">Yes</label>
<input tabindex="1" type="radio" class="radio"
	name="<%=REJECTED_AS_UNFIT %>" value="Y" /> <label class="small">No</label>
<input tabindex="1" type="radio" class="radio"
	name="<%=REJECTED_AS_UNFIT %>" value="N" checked="checked" /> <label
	class="large3">Have you ever been Discharge as medically unfit
for any branch of the Armed forces?</label> <label class="small">Yes</label> <input
	tabindex="1" type="radio" class="radio"
	name="<%=DISCHARGE_MEDICALLY_UNFIT %>" value="Y" /> <label
	class="small">No</label> <input tabindex="1" type="radio" class="radio"
	name="<%=DISCHARGE_MEDICALLY_UNFIT %>" value="N" checked="checked" />
<div class="Clear"></div>
<label class="large3">Have you ever been Admitted in hospital
for any illness, operation or injury ? if also</label> <label class="small">Yes</label>
<input tabindex="1" type="radio" class="radio"
	name="<%=ADIMMITED_IN_HOSPITAL_FOR_ILLNESS %>" value="Y" /> <label
	class="small">No</label> <input tabindex="1" type="radio" class="radio"
	name="<%=ADIMMITED_IN_HOSPITAL_FOR_ILLNESS %>" value="N"
	checked="checked" />
<div class="Clear"></div>
<label class="large3">State the nature of the disease and
duration of stay in hospital</label> <input tabindex="1" type="text"
	name="<%=STATE_NATURE_OF_THE_DISEASE %>" class="large" maxlength="50" />
<div class="Clear"></div>
<label class="large3"> Any other information which you can give
about your health</label> <input tabindex="1" type="text"
	name="<%=OTHER_INFORMATION %>" class="large" maxlength="50" />



<div class="Clear"></div>

</div>
<div class="Clear"></div>
</div>


<div class="division"></div>
<!--Block Four Ends-->

<div class="blockTitleFixed">Medicine <a
	href="javascript:animatedcollapse.toggle('slide2')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div id="slide2">
<div class="blockFrame"><label class="large">Height
Without Shoes(cms)</label> <input tabindex="1" type="text" id="height"
	name="<%=HEIGHT_WITHOUT_SHOOSE %>" onkeyup="isNumber1(this)"
	maxlength="6" onblur="checkForWiegth(this.value,id);" /> <label
	class="large">Weight(Actual)Kg</label> <input tabindex="1" type="text"
	id="weight" name="<%=ACTUAL_WEIGHT %>" id="actualWeigth" maxlength="6"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" />

<div class="Clear"></div>
<label class="large">(Acceptable)kg</label> <input tabindex="1"
	type="text" id="accptablekg" name="<%=ACCEPTABLE_KG %>" class="medium"
	onkeyup="isNumber1(this)" maxlength="6"
	onblur="checkForWiegth(this.value,id);" /> <label class="large">Leg
Length(for pilots only)</label> <input tabindex="1" type="text" id="leglength"
	name="<%= LEG_LENGTH%>" class="medium" onkeyup="isNumber1(this)"
	maxlength="6" onblur="checkForWiegth(this.value,id);" />
<div class="Clear"></div>
</div>
</div>

<div class="Clear"></div>
<div class="division"></div>

<div class="blockTitleFixed">Urine Examination <a
	href="javascript:animatedcollapse.toggle('slide3')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div id="slide3">
<div class="blockFrame"><label class="medium">Appearance</label> <input
	tabindex="1" type="text" size="22" class="Auto" name="<%= APPEREANCE%>"
	maxlength="20" /> <label class="medium">Albumin</label> <input
	tabindex="1" type="text" size="22" class="Auto" name="<%= ALBUMIN%>"
	maxlength="20" /> <label class="medium">Sugar</label> <input
	tabindex="1" type="text" size="22" class="Auto" name="<%= SUGAR%>"
	maxlength="20" />

<div class="Clear"></div>

<label class="medium">Sp. Gravity</label> <input tabindex="1"
	type="text" size="22" class="Auto" name="<%= SP_GRAVITY%>"
	maxlength="20" />
<div class="Clear"></div>
</div>
</div>

<div class="Clear"></div>
<div class="division"></div>

<div class="blockTitleFixed">Blood Examination <a
	href="javascript:animatedcollapse.toggle('slide4')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div id="slide4">
<div class="blockFrame"><label class="medium">Hb%</label> <input
	tabindex="1" type="text" class="small" name="<%=HB_PERCENTAGE%>"
	maxlength="12" /> <label class="large">Any other inv carried
out</label> <input tabindex="1" type="text"
	name="<%= ANYOTHER_INV_CARRIED_OUT%>" maxlength="50" /> <label
	class="medium">Physique</label> <input tabindex="1" type="text"
	name="<%=PHYSIQUE %>" class="large" maxlength="50" />
<div class="Clear"></div>
<label class="medium">Skin</label> <input tabindex="1" type="text"
	name="<%=SKIN %>" class="large" maxlength="50" /> <label class="large">Abdomen(Liver
& Spleen)</label> <input tabindex="1" type="text" name="<%=ABDOMEN%>"
	class="large" maxlength="50" />
<div class="Clear"></div>
</div>
</div>

<div class="Clear"></div>
<div class="division"></div>

<div class="blockTitleFixed">Cardio Vascular System <a
	href="javascript:animatedcollapse.toggle('slide5')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div id="slide5">
<div class="blockFrame">
<div class="Clear"></div>
<label>Heart Size</label> <input tabindex="1" type="text"
	name="<%= HEART_SIZE%>" class="Auto" size="22" maxlength="20" /> <label>Sounds</label>
<input tabindex="1" type="text" name="<%= SOUND%>" class="Auto"
	size="22" maxlength="20" /> <label>Rhythm</label> <input tabindex="1"
	type="text" name="<%= RHYTHM%>" class="Auto" size="22" maxlength="20" />

<div class="Clear"></div>

<label>Arterial Walls</label> <input tabindex="1" type="text"
	name="<%= ARTERIAL_WALLS%>" class="Auto" size="22" maxlength="20" /> <label>Pulse
Rate</label> <input tabindex="1" type="text" name="<%=PULSE_RATES%>"
	class="Auto" size="22" maxlength="20" /> <label>BP</label> <input
	tabindex="1" type="text" name="<%= BP1%>" class="Auto" size="22"
	maxlength="20" /></div>
</div>

<div class="Clear"></div>
<div class="division"></div>

<div class="blockTitle">Respiratory System(Including X-Ray
Examination When applicable) <a
	href="javascript:animatedcollapse.toggle('slide6')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div id="slide6">
<div class="blockFrame">
<div class="Clear"></div>
<label class="medium"> </label> <input tabindex="1" type="text"
	name="<%=RESPIRATORY_SYSTEM %>" class="Auto" size="120" maxlength="100" />
<div class="Clear"></div>
</div>
</div>

<div class="Clear"></div>
<div class="division"></div>


<div class="blockTitleFixed">Chest Measurement <a
	href="javascript:animatedcollapse.toggle('slide7')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div id="slide7">
<div class="blockFrame"><label class="large">Full
expansion(cms)</label> <input tabindex="1" type="text"
	name="<%= FULL_EXPENSION%>" onKeyDown="limitText(this,40);"
	onKeyUp="limitText(this,40);"> <label class="large">Range
of Expansion(cms)</label> <input tabindex="1" type="text"
	name="<%=RANGE_OF_EXPENSION%>" maxlength="20" />
<div class="Clear"></div>
</div>
</div>

<div class="Clear"></div>
<div class="division"></div>

<div class="blockTitle">Control Nervous System (Reflexes, Tremors)
<a href="javascript:animatedcollapse.toggle('slide8')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div id="slide8">
<div class="blockFrame"><label>Self Balancing R</label> <input
	tabindex="1" type="text" name="<%= SELF_BALANCINF_R%>" maxlength="20" />
<label>Self Balancing l</label> <input tabindex="1" type="text"
	name="<%= SELF_BALANCING_L%>" maxlength="20" />
<div class="Clear"></div>
<label class="large2">Speech Mental Mental Capacity & Emotional
stability</label> <input tabindex="1" type="text" class="large"
	name="<%=SPEECH_MENTAL_CAPACITY %>" maxlength="20" />
<div class="Clear"></div>
<label class="large2">Endocrine Condition</label> <input tabindex="1"
	type="text" class="large" name="<%=ENDOCRINE_CONDITION %>"
	maxlength="20" />
<div class="Clear"></div>
<label class="large2">Any other abnormalities or condition
affecting capacity not already noted</label> <input tabindex="1" type="text"
	name="<%=OTHER_ABNORMALITIES %>" class="large" maxlength="20" />
<div class="Clear"></div>
<div class="division"></div>

<label class="large2">Remarks</label> <textarea
	name="<%=MEDICIN_REMARKS %>" class="large"
	onkeyup="chkLength(this,50);"></textarea> <label class="large2">Medicine
Exam Date <span>*</span> </label> <input tabindex="1" type="text"
	name="<%=MEDICIN_EXAM_DATE%>" class="calDate" value="<%=date %>"
	maxlength="10" onKeyUp="mask(this.value,this,'2,5','/');"
	validate="Medicin Exam Date,date,yes"> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardExaminationReport.<%=MEDICIN_EXAM_DATE%>,event);" />
<div class="Clear"></div>
</div>
</div>

<div class="Clear"></div>
<div class="division"></div>

<div class="blockTitleFixed">Surgery <a
	href="javascript:animatedcollapse.toggle('slide9')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div id="slide9">
<div class="blockFrame">
<h5>Upper Limbs</h5>
<div class="Clear"></div>
<label class="noheight">Fingers</label> <input tabindex="1"
	type="checkbox" name="<%=FINGER%>" value="Y" class="radio2" /> <label
	class="noheight">Hand</label> <input tabindex="1" type="checkbox"
	name="<%=HAND%>" value="Y" class="radio2" /> <label class="noheight">Wrist</label>
<input tabindex="1" type="checkbox" name="<%=WRIST%>" value="Y"
	class="radio2" /> <label class="noheight">Elbows</label> <input
	tabindex="1" type="checkbox" name="<%=ELBOWS%>" value="Y"
	class="radio2" /> <label class="noheight">Shoulder Girdles</label> <input
	tabindex="1" type="checkbox" name="<%=SHOULDER_GIRDLES%>" value="Y"
	class="radio2" /> <label class="noheight">Cervical</label> <input
	tabindex="1" type="checkbox" name="<%=CERCIVAL%>" value="Y"
	class="radio2" /> <label class="noheight">Dorsal vertebrate</label> <input
	tabindex="1" type="checkbox" name="<%=DORSAL_VERTEBRATE%>" value="Y"
	class="radio2" />
<div class="Clear"></div>
<h5>Lower Limbs</h5>
<div class="Clear"></div>
<label class="noheight">Hullux</label> <input tabindex="1"
	type="checkbox" name="<%=HULLUX%>" value="Y" class="radio2" /> <label
	class="noheight">Valgus</label> <input tabindex="1" type="checkbox"
	name="<%=VALGUS%>" value="Y" class="radio2" /> <label class="noheight">Rigigus</label>
<input tabindex="1" type="checkbox" name="<%=RIGGUS%>" value="Y"
	class="radio2" /> <label class="noheight">FlatFeet</label> <input
	tabindex="1" type="checkbox" name="<%=FLAT_FEET%>" value="Y"
	class="radio2" /> <label class="noheight">Joints</label> <input
	tabindex="1" type="checkbox" name="<%=JOINTS%>" value="Y"
	class="radio2" /> <label class="noheight">Pelvis</label> <input
	tabindex="1" type="checkbox" name="<%=PELVIS%>" value="Y"
	class="radio2" /> <label class="noheight">Gail</label> <input
	tabindex="1" type="checkbox" name="<%=GAIL%>" value="Y" class="radio2" />
<label class="noheight">Lumber and Sacral vertabrac</label> <input
	tabindex="1" type="checkbox" name="<%=LUMBER_SCALER_VERTABRAC%>"
	value="Y" class="radio2" /> <label class="noheight">Roccyx and
Varicose veins</label> <input tabindex="1" type="checkbox"
	name="<%=ROCCYX_VARICOSE_VENIS%>" value="Y" class="radio2" />
<div class="Clear"></div>
<h5>Genito-Urinary and Perineum</h5>
<div class="Clear"></div>
<label class="noheight">Hydrocele</label> <input tabindex="1"
	type="checkbox" name="<%=HYDROCELE%>" value="Y" class="radio2" /> <label
	class="noheight">Varicocele</label> <input tabindex="1" type="checkbox"
	name="<%=VARICOCELE%>" value="Y" class="radio2" /> <label
	class="noheight">Underscended testes</label> <input tabindex="1"
	type="checkbox" name="<%=UNDER_SCENDED_TESTES%>" value="Y"
	class="radio2" /> <label class="noheight">Hemorrhoids</label> <input
	tabindex="1" type="checkbox" name="<%=HEMONHOIDS%>" value="Y"
	class="radio2" /> <label class="noheight">Hernia & Musicle</label> <input
	tabindex="1" type="checkbox" name="<%=HERNIA_MUSCLE%>" value="Y"
	class="radio2" /> <label class="noheight">Breasts</label> <input
	tabindex="1" type="checkbox" name="<%=BREASTS%>" value="Y"
	class="radio2" />
<div class="Clear"></div>
<div class="division"></div>
<label>Remarks</label> <textarea name="<%=SURGERY_REMARKS %>" rows=""
	cols="" onkeyup="chkLength(this,50);"></textarea> <label>Surgery
Date</label> <input tabindex="1" type="text" name="<%=SURGERY_DATE%>"
	class="medium" value="<%=date %>" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');"> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardExaminationReport.<%=SURGERY_DATE%>,event);" />
</div>
</div>

<div class="Clear"></div>
<div class="division"></div>

<div class="blockTitleFixed">EYES <a
	href="javascript:animatedcollapse.toggle('slide10')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div id="slide10">
<div class="blockFrame">
<div class="Clear"></div>
<div class="Height10"></div>

<div class="tableHolderAuto">

<div class="Clear"></div>
<table width="50%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Distant Vision</th>
		<th scope="col">R</th>
		<th scope="col">L</th>
		<th scope="col">Near Vision</th>
		<th scope="col">R</th>
		<th scope="col">L</th>
		<th scope="col">CP</th>
	</tr>
	<tr>
		<td>Without Glasses</td>
		<td width="10%"><input tabindex="1" type="text"
			name="<%=WITHOUT_GLASSES_DISTANT_R %>" maxlength="10" /></td>
		<td width="10%"><input tabindex="1" type="text"
			name="<%=WITHOUT_GLASSES_DISTANT_L %>" maxlength="10" /></td>
		<td>Without Glasses</td>
		<td width="10%"><input tabindex="1" type="text"
			name="<%=WITHOUT_GLASSES_NEAR_R %>" maxlength="10" /></td>
		<td width="10%"><input tabindex="1" type="text"
			name="<%=WITHOUT_GLASSES_NEAR_L%>" maxlength="10" /></td>
		<td width="10%"><input tabindex="1" type="text"
			name="<%=WITHOUT_GLASSES_NEAR_CP %>" maxlength="10" /></td>
	</tr>
	<tr>
		<td>With Glasses</td>
		<td width="10%"><input tabindex="1" type="text"
			name="<%= WITH_GLASSES_DISTANT_R%>" maxlength="10" /></td>
		<td width="10%"><input tabindex="1" type="text"
			name="<%=WITH_GLASSES_DISTANT_L %>" maxlength="10" /></td>
		<td>With Glasses</td>
		<td width="10%"><input tabindex="1" type="text"
			name="<%=WITH_GLASSES_NEAR_R%>" maxlength="10"></td>
		<td width="10%"><input tabindex="1" type="text"
			name="<%=WITH_GLASSES_NEAR_L %>" maxlength="10" /></td>
		<td width="10%"><input tabindex="1" type="text"
			name="<%=WITH_GLASSES_NEAR_CP %>" maxlength="10" /></td>
	</tr>

</table>

<div class="Clear"></div>
</div>
<label class="large2">Any evidence of Trachoma/its complications
or any other disease</label> <textarea rows="" cols=""
	name="<%=ANY_EVIDENCE_OF_TRACHOMA %>" class="large"
	onkeyup="chkLength(this,30);"></textarea>
<div class="Clear"></div>
<label class="large2">Binocular vision & Grade</label> <input
	tabindex="1" type="text" name="<%=BINOCULAR_VISION_GRADE %>"
	class="large" maxlength="50" />
<div class="Clear"></div>
<h5>Special Examination When Applicable</h5>
<div class="Clear"></div>
<label class="large">Manifest Hypermetropia, Myopia R & L</label> <input
	tabindex="1" type="text" name="<%=MANIFEST_HYPERMETROPIA %>"
	maxlength="10" /> <label>Cover Test</label> <input tabindex="1"
	type="text" name="<%=COVER_TEST %>" maxlength="10" />

<div class="Clear"></div>

<label class="large">Diaphragm Test(PD M ddox Wing Test)</label> <input
	tabindex="1" type="text" name="<%=DIAPHRAGM_TEST %>" maxlength="10" />

<label>Fund & Media</label> <input tabindex="1" type="text"
	name="<%=FUND_MEDIA %>" maxlength="10" />

<div class="Clear"></div>

<label class="large">Fields</label> <input tabindex="1" type="text"
	name="<%=FIELDS %>" maxlength="10" /> <label>Night Visual
Capacity</label> <input tabindex="1" type="text"
	name="<%=NIGHT_VISUAL_CAPACITY %>" maxlength="10" />

<div class="Clear"></div>

<label class="large">Convergence C(cms)</label> <input tabindex="1"
	type="text" id="convergence" name="<%=CONVERGENCE_C%>"
	onkeyup="isNumber1(this)" maxlength="6"
	onblur="checkForWiegth(this.value,id);" /> <label>Convergence
SC(cms)</label> <input tabindex="1" type="text" id="convergencesc"
	name="<%=CONVERGENCE_SC %>" onkeyup="isNumber1(this)" maxlength="6"
	onblur="checkForWiegth(this.value,id);" />

<div class="Clear"></div>

<label class="large">Accommodation R</label> <input tabindex="1"
	type="text" name="<%=ACCOMMODATION_R %>" maxlength="20" /> <label>Accommodation
L</label> <input tabindex="1" type="text" name="<%=ACCOMMODATION_L %>"
	maxlength="20" />

<div class="Clear"></div>
<div class="division"></div>
<label class="large">Remarks</label> <input tabindex="1" type="text"
	name="<%=EYE_REMARKS %>" maxlength="50" /> <label>Date</label> <input
	tabindex="1" type="text" name="<%=EYE_DATE %>" class="calDate"
	maxlength="10" onKeyUp="mask(this.value,this,'2,5','/');"
	validate="EyeDate,date,no" /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onclick="setdate('',medicalBoardExaminationReport.<%=EYE_DATE%>,event);" />
</div>
</div>

<div class="Clear"></div>
<div class="division"></div>

<div class="blockTitleFixed">Ear & Nose & Throat <a
	href="javascript:animatedcollapse.toggle('slide11')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div id="slide11">
<div class="blockFrame">
<div class="Clear"></div>
<h5>14.a) Ear</h5>
<div class="Clear"></div>

<label>Hearing RFW(Cms)</label> <input tabindex="1" type="text"
	id="hrfw" name="<%=HEARING_R_F_W %>" onkeyup="isNumber1(this)"
	maxlength="6" onblur="checkForWiegth(this.value,id);" /> <label>Hearing
LFW(Cms)</label> <input tabindex="1" type="text" id="hlfw"
	name="<%=HEARING_L_F_W%>" onkeyup="isNumber1(this)" maxlength="6"
	onblur="checkForWiegth(this.value,id);" /> <label>Hearing both
FW(Cms)</label> <input tabindex="1" type="text" id="bothfw"
	name="<%=HEARING_BOTH_FW %>" onkeyup="isNumber1(this)" maxlength="6"
	onblur="checkForWiegth(this.value,id);" />

<div class="Clear"></div>

<label>Hearing RCV(Cms)</label> <input tabindex="1" type="text"
	id="hrcv" name="<%=HEARING_R_C_V %>" onkeyup="isNumber1(this)"
	maxlength="6" onblur="checkForWiegth(this.value,id);" /> <label>Hearing
LCV(Cms)</label> <input tabindex="1" type="text" id="hlcv"
	name="<%=HEARING_L_C_V %>" onkeyup="isNumber1(this)" maxlength="6"
	onblur="checkForWiegth(this.value,id);" /> <label>Hearing both
CV(Cms)</label> <input tabindex="1" type="text" id="bothcv"
	name="<%=HEARING_BOTH_CV %>" onkeyup="isNumber1(this)" maxlength="6"
	onblur="checkForWiegth(this.value,id);" />

<div class="Clear"></div>

<label>External Ear (Wax)R</label> <input tabindex="1" type="text"
	name="<%=EXTERNAL_EAR_R %>" maxlength="10" /> <label>External
Ear(Wax)L</label> <input tabindex="1" type="text" name="<%=EXTERNAL_EAR_L %>"
	maxlength="10" />

<div class="Clear"></div>
<div class="division"></div>

<label class="large2">Middle Ear(Tympanic Membrance &Eustachain
Tube)-R</label> <input tabindex="1" type="text" name="<%= MIDDLE_EAR_R%>"
	maxlength="10" /> <label class="large2">Middle Ear(Tympanic
Membrance &Eustachain Tube)-L</label> <input tabindex="1" type="text"
	name="<%=MIDDLE_EAR_L %>" maxlength="10" />

<div class="Clear"></div>

<label class="large2">Inner Ear(Cochlea & Vestibular
Apparatus)-R</label> <input tabindex="1" type="text" name="<%=INNER_EAR_R %>"
	maxlength="10" /> <label class="large2">Inner Ear(Cochlea &
Vestibular Apparatus)-L</label> <input tabindex="1" type="text"
	name="<%=INNER_EAR_L %>" maxlength="10" />

<div class="Clear"></div>

<label class="large2">Audiometry Record(Special exam when
applicable</label> <input tabindex="1" type="text"
	name="<%=AUDIOMETRY_RECORD %>" maxlength="10" />

<div class="Clear"></div>
<div class="division"></div>

<h5>b.) Nose</h5>
<div class="Clear"></div>
<label class="noWidth">&nbsp; </label> <textarea rows="" cols=""
	name="<%=NOSE %>" class="large" onkeyup="chkLength(this,50);"></textarea>

<div class="Clear"></div>
<div class="division"></div>

<h5>c.) Throat</h5>
<div class="Clear"></div>
<label class="noWidth">&nbsp;</label> <textarea rows="" cols=""
	name="<%=THROAT_EAR %>" class="large" onkeyup="chkLength(this,50);"></textarea>
<div class="Clear"></div>
<div class="division"></div>

<label class="medium">Remarks</label> <textarea rows="" cols=""
	name="<%=EAR_REMARKS %>" class="large" onkeyup="chkLength(this,50);"></textarea>
<label> Date </label> <input tabindex="1" type="text"
	name="<%=EAR_DATE%>" class="calDate" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');"
	validate="Surgery Date,date,no"> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardExaminationReport.<%=EAR_DATE%>,event);" />
</div>
</div>

<div class="Clear"></div>
<div class="division"></div>

<div class="blockTitleFixed">Dental <a
	href="javascript:animatedcollapse.toggle('slide12')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div id="slide12">
<div class="blockFrame">
<div class="Clear"></div>
<label class="large">Total no. of Teeth</label> <input tabindex="1"
	type="text" name="<%=TOTAL_NO_OF_TEETH %>" class="small"
	onKeyUp="isNumber(this)" maxlength="2" /> <label class="large">Missing/
Unserviceable Teeth</label> <input tabindex="1" type="text"
	name="<%=MISSING_TEETH %>" class="small" onKeyUp="isNumber(this);"
	maxlength="2" /><label class="valueNoWidth">/</label> <input
	tabindex="1" type="text" name="<%=MISSING_UNSERVICABLE_TEETH %>"
	class="small" onKeyUp="isNumber(this);" maxlength="2" />
<div class="Clear"></div>
<label class="large">Total no. of Dental Point</label> <input
	tabindex="1" type="text" name="<%=DENTSL_POINT %>"
	onKeyUp="isNumber(this);" maxlength="2" />

<div class="Clear"></div>
<div class="division"></div>

<h5>Total No. of Defective Teeth</h5>
<div class="Clear"></div>
<label class="medium">Upper Right</label>
<div class="Clear"></div>
<label class="small">8</label> <input tabindex="1" type="checkbox"
	name="<%=DUR_8%>" id="<%=DUR_8%>" value="" class="radio"
	onclick="chkValue(this);" /> <label class="small">7</label> <input
	tabindex="1" type="checkbox" name="<%=DUR_7%>" id="<%=DUR_7%>" value=""
	class="radio" onclick="chkValue(this);" /> <label class="small">6</label>
<input tabindex="1" type="checkbox" name="<%=DUR_6%>" id="<%=DUR_6%>"
	value="" class="radio" onclick="chkValue(this);" /> <label
	class="small">5</label> <input tabindex="1" type="checkbox"
	name="<%=DUR_5%>" id="<%=DUR_5%>" value="" class="radio"
	onclick="chkValue(this);" /> <label class="small">4</label> <input
	tabindex="1" type="checkbox" name="<%=DUR_4%>" id="<%=DUR_4%>" value=""
	class="radio" onclick="chkValue(this);" /> <label class="small">3</label>
<input tabindex="1" type="checkbox" name="<%=DUR_3%>" id="<%=DUR_3%>"
	value="" class="radio" onclick="chkValue(this);" /> <label
	class="small">2</label> <input tabindex="1" type="checkbox"
	name="<%=DUR_2%>" id="<%=DUR_2%>" value="" class="radio"
	onclick="chkValue(this);" /> <label class="small">1</label> <input
	tabindex="1" type="checkbox" name="<%=DUR_1%>" id="<%=DUR_1%>" value=""
	class="radio" onclick="chkValue(this);" />

<div class="Clear"></div>
<label class="medium">Upper Left</label>
<div class="Clear"></div>
<label class="small">8</label> <input tabindex="1" type="checkbox"
	name="<%=DUL_8%>" id="<%=DUL_8%>" value="" class="radio"
	onclick="chkValue(this);" /> <label class="small">7</label> <input
	tabindex="1" type="checkbox" name="<%=DUL_7%>" id="<%=DUL_7%>" value=""
	class="radio" onclick="chkValue(this);" /> <label class="small">6</label>
<input tabindex="1" type="checkbox" name="<%=DUL_6%>" id="<%=DUL_6%>"
	value="" class="radio" onclick="chkValue(this);" /> <label
	class="small">5</label> <input tabindex="1" type="checkbox"
	name="<%=DUL_5%>" id="<%=DUL_5%>" value="" class="radio"
	onclick="chkValue(this);" /> <label class="small">4</label> <input
	tabindex="1" type="checkbox" name="<%=DUL_4%>" id="<%=DUL_4%>" value=""
	class="radio" onclick="chkValue(this);" /> <label class="small">3</label>
<input tabindex="1" type="checkbox" name="<%=DUL_3%>" id="<%=DUL_3%>"
	value="" class="radio" onclick="chkValue(this);" /> <label
	class="small">2</label> <input tabindex="1" type="checkbox"
	name="<%=DUL_2%>" id="<%=DUL_2%>" value="" class="radio"
	onclick="chkValue(this);" /> <label class="small">1</label> <input
	tabindex="1" type="checkbox" name="<%=DUL_1%>" id="<%=DUL_1%>" value=""
	class="radio" onclick="chkValue(this);" />


<div class="Clear"></div>
<label class="medium">Lower Right</label>
<div class="Clear"></div>
<label class="small">8</label> <input tabindex="1" type="checkbox"
	name="<%=DLR_8%>" id="<%=DLR_8%>" value="" class="radio"
	onclick="chkValue(this);" /> <label class="small">7</label> <input
	tabindex="1" type="checkbox" name="<%=DLR_7%>" id="<%=DLR_7%>" value=""
	class="radio" onclick="chkValue(this);" /> <label class="small">6</label>
<input tabindex="1" type="checkbox" name="<%=DLR_6%>" id="<%=DLR_6%>"
	value="" class="radio" onclick="chkValue(this);" /> <label
	class="small">5</label> <input tabindex="1" type="checkbox"
	name="<%=DLR_5%>" id="<%=DLR_5%>" value="" class="radio"
	onclick="chkValue(this);" /> <label class="small">4</label> <input
	tabindex="1" type="checkbox" name="<%=DLR_4%>" id="<%=DLR_4%>" value=""
	class="radio" onclick="chkValue(this);" /> <label class="small">3</label>
<input tabindex="1" type="checkbox" name="<%=DLR_3%>" id="<%=DLR_3%>"
	value="" class="radio" onclick="chkValue(this);" /> <label
	class="small">2</label> <input tabindex="1" type="checkbox"
	name="<%=DLR_2%>" id="<%=DLR_2%>" value="" class="radio"
	onclick="chkValue(this);" /> <label class="small">1</label> <input
	tabindex="1" type="checkbox" name="<%=DLR_1%>" id="<%=DLR_1%>" value=""
	class="radio" onclick="chkValue(this);" />

<div class="Clear"></div>
<label class="medium">Lower Left</label>
<div class="Clear"></div>
<label class="small">8</label> <input tabindex="1" type="checkbox"
	name="<%=DLL_8%>" value="" id="<%=DLL_8%>" class="radio"
	onclick="chkValue(this);" /> <label class="small">7</label> <input
	tabindex="1" type="checkbox" name="<%=DLL_7%>" value="" id="<%=DLL_7%>"
	class="radio" onclick="chkValue(this);" /> <label class="small">6</label>
<input tabindex="1" type="checkbox" name="<%=DLL_6%>" value=""
	id="<%=DLL_6%>" class="radio" onclick="chkValue(this);" /> <label
	class="small">5</label> <input tabindex="1" type="checkbox"
	name="<%=DLL_5%>" value="" id="<%=DLL_5%>" class="radio"
	onclick="chkValue(this);" /> <label class="small">4</label> <input
	tabindex="1" type="checkbox" name="<%=DLL_4%>" value="" id="<%=DLL_4%>"
	class="radio" onclick="chkValue(this);" /> <label class="small">3</label>
<input tabindex="1" type="checkbox" name="<%=DLL_3%>" value=""
	id="<%=DLL_3%>" class="radio" onclick="chkValue(this);" /> <label
	class="small">2</label> <input tabindex="1" type="checkbox"
	name="<%=DLL_2%>" value="" id="<%=DLL_2%>" class="radio"
	onclick="chkValue(this);" /> <label class="small">1</label> <input
	tabindex="1" type="checkbox" name="<%=DLL_1%>" value="" id="<%=DLL_1%>"
	class="radio" onclick="chkValue(this);" />

<div class="division"></div>
<div class="Clear"></div>

<h5>Missing Teeth</h5>
<div class="Clear"></div>
<label class="medium">Upper Right</label>
<div class="Clear"></div>
<label class="small">8</label> <input tabindex="1" type="checkbox"
	name="<%=MUR_8%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">7</label> <input tabindex="1" type="checkbox"
	name="<%=MUR_7%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">6</label> <input tabindex="1" type="checkbox"
	name="<%=MUR_6%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">5</label> <input tabindex="1" type="checkbox"
	name="<%=MUR_5%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">4</label> <input tabindex="1" type="checkbox"
	name="<%=MUR_4%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">3</label> <input tabindex="1" type="checkbox"
	name="<%=MUR_3%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">2</label> <input tabindex="1" type="checkbox"
	name="<%=MUR_2%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">1</label> <input tabindex="1" type="checkbox"
	name="<%=MUR_1%>" value="" class="radio" onclick="chkValue(this);" />

<div class="Clear"></div>
<label class="medium">Upper Left</label>
<div class="Clear"></div>
<label class="small">8</label> <input tabindex="1" type="checkbox"
	name="<%=MUL_8%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">7</label> <input tabindex="1" type="checkbox"
	name="<%=MUL_7%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">6</label> <input tabindex="1" type="checkbox"
	name="<%=MUL_6%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">5</label> <input tabindex="1" type="checkbox"
	name="<%=MUL_5%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">4</label> <input tabindex="1" type="checkbox"
	name="<%=MUL_4%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">3</label> <input tabindex="1" type="checkbox"
	name="<%=MUL_3%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">2</label> <input tabindex="1" type="checkbox"
	name="<%=MUL_2%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">1</label> <input tabindex="1" type="checkbox"
	name="<%=MUL_1%>" value="" class="radio" onclick="chkValue(this);" />


<div class="Clear"></div>
<label class="medium">Lower Right</label>
<div class="Clear"></div>
<label class="small">8</label> <input tabindex="1" type="checkbox"
	name="<%=MLR_8%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">7</label> <input tabindex="1" type="checkbox"
	name="<%=MLR_7%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">6</label> <input tabindex="1" type="checkbox"
	name="<%=MLR_6%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">5</label> <input tabindex="1" type="checkbox"
	name="<%=MLR_5%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">4</label> <input tabindex="1" type="checkbox"
	name="<%=MLR_4%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">3</label> <input tabindex="1" type="checkbox"
	name="<%=MLR_3%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">2</label> <input tabindex="1" type="checkbox"
	name="<%=MLR_2%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">1</label> <input tabindex="1" type="checkbox"
	name="<%=MLR_1%>" value="" class="radio" onclick="chkValue(this);" />

<div class="Clear"></div>
<label class="medium">Lower Left</label>
<div class="Clear"></div>
<label class="small">8</label> <input tabindex="1" type="checkbox"
	name="<%=MLL_8%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">7</label> <input tabindex="1" type="checkbox"
	name="<%=MLL_7%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">6</label> <input tabindex="1" type="checkbox"
	name="<%=MLL_6%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">5</label> <input tabindex="1" type="checkbox"
	name="<%=MLL_5%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">4</label> <input tabindex="1" type="checkbox"
	name="<%=MLL_4%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">3</label> <input tabindex="1" type="checkbox"
	name="<%=MLL_3%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">2</label> <input tabindex="1" type="checkbox"
	name="<%=MLL_2%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">1</label> <input tabindex="1" type="checkbox"
	name="<%=MLL_1%>" value="" class="radio" onclick="chkValue(this);" />
<div class="Clear"></div>

<div class="division"></div>

<h5>Unserviceable Teeth</h5>
<div class="Clear"></div>
<label class="medium">Upper Right</label>
<div class="Clear"></div>
<label class="small">8</label> <input tabindex="1" type="checkbox"
	name="<%=UUR_8%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">7</label> <input tabindex="1" type="checkbox"
	name="<%=UUR_7%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">6</label> <input tabindex="1" type="checkbox"
	name="<%=UUR_6%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">5</label> <input tabindex="1" type="checkbox"
	name="<%=UUR_5%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">4</label> <input tabindex="1" type="checkbox"
	name="<%=UUR_4%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">3</label> <input tabindex="1" type="checkbox"
	name="<%=UUR_3%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">2</label> <input tabindex="1" type="checkbox"
	name="<%=UUR_2%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">1</label> <input tabindex="1" type="checkbox"
	name="<%=UUR_1%>" value="" class="radio" onclick="chkValue(this);" />

<div class="Clear"></div>
<label class="medium">Upper Left</label>
<div class="Clear"></div>
<label class="small">8</label> <input tabindex="1" type="checkbox"
	name="<%=UUL_8%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">7</label> <input tabindex="1" type="checkbox"
	name="<%=UUL_7%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">6</label> <input tabindex="1" type="checkbox"
	name="<%=UUL_6%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">5</label> <input tabindex="1" type="checkbox"
	name="<%=UUL_5%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">4</label> <input tabindex="1" type="checkbox"
	name="<%=UUL_4%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">3</label> <input tabindex="1" type="checkbox"
	name="<%=UUL_3%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">2</label> <input tabindex="1" type="checkbox"
	name="<%=UUL_2%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">1</label> <input tabindex="1" type="checkbox"
	name="<%=UUL_1%>" value="" class="radio" onclick="chkValue(this);" />


<div class="Clear"></div>
<label class="medium">Lower Right</label>
<div class="Clear"></div>
<label class="small">8</label> <input tabindex="1" type="checkbox"
	name="<%=ULR_8%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">7</label> <input tabindex="1" type="checkbox"
	name="<%=ULR_7%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">6</label> <input tabindex="1" type="checkbox"
	name="<%=ULR_6%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">5</label> <input tabindex="1" type="checkbox"
	name="<%=ULR_5%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">4</label> <input tabindex="1" type="checkbox"
	name="<%=ULR_4%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">3</label> <input tabindex="1" type="checkbox"
	name="<%=ULR_3%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">2</label> <input tabindex="1" type="checkbox"
	name="<%=ULR_2%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">1</label> <input tabindex="1" type="checkbox"
	name="<%=ULR_1%>" value="" class="radio" onclick="chkValue(this);" />

<div class="Clear"></div>
<label class="medium">Lower Left</label>
<div class="Clear"></div>
<label class="small">8</label> <input tabindex="1" type="checkbox"
	name="<%=ULL_8%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">7</label> <input tabindex="1" type="checkbox"
	name="<%=ULL_7%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">6</label> <input tabindex="1" type="checkbox"
	name="<%=ULL_6%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">5</label> <input tabindex="1" type="checkbox"
	name="<%=ULL_5%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">4</label> <input tabindex="1" type="checkbox"
	name="<%=ULL_4%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">3</label> <input tabindex="1" type="checkbox"
	name="<%=ULL_3%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">2</label> <input tabindex="1" type="checkbox"
	name="<%=ULL_2%>" value="" class="radio" onclick="chkValue(this);" />
<label class="small">1</label> <input tabindex="1" type="checkbox"
	name="<%=ULL_1%>" value="" class="radio" onclick="chkValue(this);" />
<div class="division"></div>
<div class="Clear"></div>
<label class="medium"> Remarks</label> <textarea rows="" cols=""
	name="<%=DENTAL_REMARKS %>" class="large" onkeyup="chkLength(this,50);"></textarea>
<label class="medium">Date</label> <input tabindex="1" type="text"
	name="<%=DENTAL_DATE %>" class="calDate" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');"
	validate="Dental Date,date,no" /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onclick="setdate('',medicalBoardExaminationReport.<%=DENTAL_DATE%>,event);" />
</div>
</div>

<div class="Clear"></div>
<div class="division"></div>

<div class="blockTitleFixed">GYNAECOLOGY <a
	href="javascript:animatedcollapse.toggle('slide13')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div id="slide13">
<div class="blockFrame">
<div class="Clear"></div>
<div class="Height10"></div>

<label class="large">Menstrual History</label> <input tabindex="1"
	type="text" name="<%=MENSTRUAL_HISTORY %>" maxlength="30" /> <label
	class="large">LMP</label> <input tabindex="1" type="text"
	name="<%=LMP %>" maxlength="10" />
<div class="Clear"></div>
<label class="large">No. of pregnancies</label> <input tabindex="1"
	type="text" name="<%=NO_OF_PREGNANCY %>" onKeyUp="isNumber(this);"
	maxlength="1" /> <label class="large">No of Abortions</label> <input
	tabindex="1" type="text" name="<%= NO_OF_ABORTION%>" maxlength="1"
	onKeyUp="isNumber(this);" />
<div class="Clear"></div>
<label class="large">No. of Children</label> <input tabindex="1"
	type="text" name="<%= NO_OF_CHILDREN%>" onKeyUp="isNumber(this);"
	maxlength="1" /> <label class="large">Date of last confinement</label>
<input tabindex="1" type="text" class="calDate" readonly="readonly "
	name="<%=DATE_OF_LASTCONFINEMENT %>" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');"
	validate="Dental Date,date,no" /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onclick="setdate('',medicalBoardExaminationReport.<%=DATE_OF_LASTCONFINEMENT%>,event);" />
<div class="Clear"></div>
<label class="large">Vaginal Discharge</label> <input tabindex="1"
	type="text" name="<%=VAGINAL_DISCHARGE %>" maxlength="10" /> <label
	class="large">Prolapse</label> <input tabindex="1" type="text"
	name="<%= PROLAPSE%>" maxlength="10" />
<div class="Clear"></div>
<label class="large">USG Abdomen</label> <input tabindex="1" type="text"
	name="<%=USG_ABORTION %>" maxlength="10" />
<div class="Clear"></div>
<div class="division"></div>

<label class="large">Remarks</label> <textarea rows="" cols=""
	name="<%=GYANAECOLOGY_RAMARKS %>" class="large"
	onkeyup="chkLength(this,30);"></textarea> <label class="medium">Date</label>
<input tabindex="1" type="text" class="calDate"
	name="<%=GYANAECOLOGY_DATE%>" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');"
	validate="Dental Date,date,no" /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onclick="setdate('',medicalBoardExaminationReport.<%=GYANAECOLOGY_DATE%>,event);" />
</div>
</div>

<div class="Clear"></div>
<div class="division"></div>
<div class="blockFrame"><label class="large">FINDING OF
MEDICAL BOARD/EXAMINATION</label> <textarea rows="" cols=""
	name="<%=MEDICAL_BOARD_EXAMINATION%>" class="large"
	onkeyup="chkLength(this,100);"></textarea>
<div class="Clear"></div>
<label class="large">Place</label> <select
	name="<%=MEDICAL_BOARD_EXAMINATION_PLACE %>" tabindex=1>
	<option value="0">Select</option>
	<%
		for (MasUnit masUnit1 : masUnitList) {
	%>

	<option value="<%=masUnit1.getId()%>"><%=masUnit1.getUnitName()%></option>

	<%
		}
	%>
</select> <label>Date</label> <input tabindex="1" type="text" class="calDate"
	name="<%=MEDICAL_BOARD_EXAMINATION_DATE %>" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');"
	validate="Medical Board Examination Place Date,date,no" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardExaminationReport.<%=MEDICAL_BOARD_EXAMINATION_DATE%>,event);" />
<div class="Clear"></div>
<label class="large">FINDING OF THE SUBSEQUENT MEDICAL
BOARD/EXAMINATION</label> <textarea rows="" cols=""
	name="<%=SUBSEQUENT_MEDICAL_BOARD_EXAMINATION %>" class="large"
	onkeyup="chkLength(this,100);"></textarea>
<div class="Clear"></div>
<label class="large">Place</label> <select
	name="<%=SUBSEQUENT_MEDICAL_BOARD_EXAMINATION_PLACE %>" tabindex=1>
	<option value="0">Select</option>
	<%
		for (MasUnit masUnit2 : masUnitList) {
	%>

	<option value="<%=masUnit2.getId()%>"><%=masUnit2.getUnitName()%></option>

	<%
		}
	%>
</select> <label>Date</label> <input tabindex="1" type="text" class="calDate"
	name="<%=SUBSEQUENT_MEDICAL_BOARD_EXAMINATION_DATE %>" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');"
	validate="subsequentMedical Date,date,no" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardExaminationReport.<%=SUBSEQUENT_MEDICAL_BOARD_EXAMINATION_DATE%>,event);" />

<div class="Clear"></div>
<label class="large">APPROVING AUTHORITY</label> <textarea rows=""
	cols="" name="<%=APPROVING_AUTHORITY %>" class="large"
	onkeyup="chkLength(this,100);"></textarea>
<div class="Clear"></div>
<label class="large">Place</label> <select
	name="<%=APPROVING_AUTHORITY_PLACE %>" tabindex=1>
	<option value="0">Select</option>
	<%
		for (MasUnit masUnit3 : masUnitList) {
	%>

	<option value="<%=masUnit3.getId()%>"><%=masUnit3.getUnitName()%></option>

	<%
		}
	%>
</select> <label>Date</label> <input tabindex="1" type="text" class="calDate"
	name="<%=APPROVING_AUTHORITY_DATE %>" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');"
	validate="Approving Authority  Date,date,no" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardExaminationReport.<%=APPROVING_AUTHORITY_DATE%>,event);" />
</div>

<div class="Clear"></div>
<div class="division"></div>
<div class="bottom"><input tabindex="1" name="Button"
	type="button" class="button" value="Submit"
	onClick="submitForm('medicalBoardExaminationReport','medicalExaminationBoard?method=addMedicalExaminationBoard');" />
<input tabindex="1" class=button id=reset accessKey=r
	onclick=resetCheck(); type=reset value=Reset name=Reset> <input
	tabindex="1" name="Button" type="button" class="button" value="Search"
	onClick="submitForMedicalBoard('medicalBoardExaminationReport');" />

<div class="division"></div>

<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label>
<div class="Clear"></div>
<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" /> <INPUT
	type=hidden value="<%=userName%>" name="<%=LAST_CHANGED_BY%>">
<INPUT type=hidden value="<%=date%>" name="<%=LAST_CHANGED_DATE%>">
<INPUT type=hidden value="<%=time%>" name="<%=LAST_CHANGED_TIME%>">


</div>
<!--Bottom labels starts--> <!--main content placeholder ends here--> <script
	type="text/javascript">
	function generateRowMdicalBoard1(idName) {
		 var d=document.getElementById(idName).getElementsByTagName("tr");
		
		lastTr = d[d.length-1]
		clone = lastTr.cloneNode(true);
		clone.id = parseInt(lastTr.id);
		lastTr.parentNode.insertBefore(clone,lastTr.nextSibling)
		var tblCtrl = d[d.length-1].getElementsByTagName("input"); 
		tblCtrl[0].value=d.length-2;
		document.getElementById('hiddenValue').value =d.length-2
		for(var i=4;i<tblCtrl.length;i++)
			tblCtrl[i].value="";
					
			
		}
    function removeRowMedicalBoard1()
	{
	  var tbl = document.getElementById('amcDetailId');
	 if(document.getElementById('hiddenValue').value >1){
	
	  document.getElementById('hiddenValue').value=document.getElementById('hiddenValue').value-1;
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2) tbl.deleteRow(lastRow - 1);
	  }
	}
	</script> <script type="text/javascript">
function limitText(limitField, limitNum) {
    if (limitField.value.length > limitNum) {
         
        limitField.value = limitField.value.substring(0, limitNum);
      
    } 
}

function chkValue(field)
{
	if(!field.checked)
	{
	
	field.value="N";
	}
	else{
	
	field.value="Y";
	
	}
	
}
function isAlpha(argvalue) {
argvalue = argvalue.toString();
var validChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

for (var n = 0; n < argvalue.length; n++) {
if (validChars.indexOf(argvalue.substring(n, n+1)) == -1)
return false;
}
return true;
}




</script> <script language="JavaScript" type="text/JavaScript"> 
function isNumber(field) { 
        var re = /^[0-9-'.'-',']*$/; 
        if (!re.test(field.value)) { 
            alert('please enter only numeric data'); 
            field.value = field.value.replace(/[^0-9-'.'-',']/g,""); 
        } 
    
    } 
  
    
</script> <script language="JavaScript" type="text/javascript">
  
  function isNumber1(field) { 
       var i=3;
        var re = /^[0-9-'.'-',']*$/; 
        if (!re.test(field.value)) { 
            alert('please enter only numeric data'); 
            field.value = field.value.replace(/[^0-9-'.'-',']/g,""); 
       
        } 
     var aa=field.value[1];
    if(field.value.indexOf(".")<4)
    {
 return true;
 }
 else
 {
     alert('please enter less than three digit before decimal point'+aa); 
		 field.value=''; 
 
	}




}

function checkForWiegth(val,id){
var index=val.indexOf(".");
if(index!=-1){
	var arr= val.split(".");
	if(arr[1].length>3){
	alert("pls check the decimal fractions");
	document.getElementById(id).value="";
	document.getElementById(id).focus();
	return false;
	}
	
	}
	else{
	
	if(val.length>3){
	alert("pls give the decimal point after three digit");
	document.getElementById(id).value="";
	document.getElementById(id).focus();
	return false;
	}
 
 }
 
 }
  function chkLength(field,maxLimit)
   {
   if(field.value.length > maxLimit)
   {
    alert('Maximum Limit is '+maxLimit+' characters.');
    var val=field.value.substring(0,maxLimit);
    field.value=val;
   }
}
  
</script></form>
</div>
