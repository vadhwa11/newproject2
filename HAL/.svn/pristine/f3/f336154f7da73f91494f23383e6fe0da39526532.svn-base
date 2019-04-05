<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="java.util.Calendar"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.HashMap"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
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
<div class="titleBg">
<h2>Medical Board Detail</h2>
</div>
<div class="clear"></div>

<form name="mb_medicalBoardDetail" action="" method="post">
<div class="clear"></div>
<div id="slide1">
<div class="Block">
<div class="clear"></div>
<label class="auto">Med Cat now Recommended</label>
<input name="medCatNowRecommend" id="medCatNowRecommend" maxlength="30" tabindex="1" type="text" maxlength="10" readonly="readonly"/>

<label>Duration</label>
<input tabindex="1" type="text" id="duration" name="duration" readonly="readonly" class="auto" size="5"	onkeyup="isNumber1(this)" />
<label >Place of Next Categorization Board</label>
<input type="text" name="placeNextCat" id="placeNextCat" maxlength="50"  readonly="readonly"/>
 <div class="clear"></div>
 <label>Date of Next Board</label>
<input tabindex="1" type="text"	name="dateNextBoard" id="dateNextBoard" maxlength="10"  class="calDate"
	onKeyUp="mask(this.value,this,'2,5','/');" validate="Dental Date,date,no" readonly="readonly"/>
<!--<img src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date"
	class="calender" onclick="setdate('',mbMedicalOfficerInitial.dateNextBoard,event);" />
--><div class="clear"></div>

<label >Opinion of Medical Board</label>
<input type="text" id="opinionMedicalBoard" name="opinionMedicalBoard"  maxlength="200" tabindex="1" class="auto" size="100" readonly="readonly" />
<div class="clear"></div>
<label >Dissent Notes</label>
<input type="text" id="dissentNotes" name="dissentNotes" readonly="readonly"  maxlength="200" tabindex="1" class="auto" size="100"/>

<div class="clear"></div>
 </div>
 </div>
 <div class="clear paddingTop15"></div>
<h4>Details of Present and Previous Disabilities <a href="javascript:animatedcollapse.toggle('slide1')"></a></h4>

<div class="clear"></div>
<div id="slide1">
<div class="Block">
<table width="50%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Sl. No.</th>
		<th scope="col">Disabilities(with ICD Code)</th>
		<th scope="col">Previous Disability %</th>
		<th scope="col">Past Disability %</th>
		<th scope="col">Reason for variation</th>
		<!--<th>Add</th>
        <th>Delete</th>
	--></tr>
	<tr>
	<%int in=0; %>
	<td>
	<input type="text" value="<%=in+1 %>" name="slNo" class="auto" size="2"  readonly="readonly"  /></td>
	<td>
	<input type="text" value="" readonly="readonly"  name="medicalBoardDisabilities" id="medicalBoardDisabilities" class="auto" size="25"
	maxlength="30"/></td>
	<td>
	<input type="text" value="" readonly="readonly"  name="prevDisabilities" id="prevDisabilities" class="auto" size="15"/></td>
	<td>
	<input type="text" readonly="readonly"  value="" name="pastDisabilities" id="pastDisabilities"class="auto" size="15"/></td>
	<td>
	<input type="text" readonly="readonly"  value="" name="variationReason" id="variationReason" class="auto" size="15" maxlength="50"/></td>
	<!--<td><input name="Button" type="button" class="buttonAdd" value="" onclick="addRowForInvestigation();" /></td>
	<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRowForInvestigation();" /></td>
-->
	</tr>
	</table>
</div>
</div>
<div class="clear paddingTop15"></div>
 <div class="clear"></div>
<div id="slide2">
<div class="Block">
<label>Composite%</label>
<input type="text" readonly="readonly"  name="composite" id="composite" value="" class="auto" size="91" />
<div class="clear"></div>
<label>Employability Restrictions</label>
<input type="text" name="empRestrictions" id="onset" value="" maxlength="50" readonly="readonly" />
<label>Instructions:</label>
<input type="text" name="instructions" id="instructions" value="" readonly="readonly"  />
</div>
</div>
<div class="clear"></div>
<div class="Clear paddingTop15"></div>
<input name="Close" type="button" value="Close" class="button" onclick="window.close()" tabindex="1" />
<div class="clear"></div>
</form>
<script>

function chkLength(field,maxLimit)
{
if(field.value.length > maxLimit)
	{
	 alert('Maximum Limit is '+maxLimit+' characters.');
	 var val=field.value.substring(0,maxLimit);
	 field.value=val;
}
}
</script>