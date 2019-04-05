<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>



<%@page import="jkt.hms.masters.business.MasReligion"%>
<%@page import="jkt.hms.masters.business.MasCaste"%><script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<div id="contentHolder"><script type="text/javascript"
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
	
	
	<%
			Map<String, Object> utilMap = new HashMap<String, Object>();
		 	
			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		 	String currenDate = (String) utilMap.get("currentDate");
		
		 	Map<String,Object> map = new HashMap<String,Object>();
			if (request.getAttribute("map") != null) {
				map = (Map) request.getAttribute("map");
			}
			
		 	List<MasReligion> masReligionList = new ArrayList<MasReligion>();
		 	
		 	if(map.get("masReligionList")!=null)
		 		masReligionList = (List) map.get("masReligionList");
		 	
		 	
			List<MasCaste> masCasteList = new ArrayList<MasCaste>();
			if(map.get("masCasteList")!=null)
				masCasteList = (List) map.get("masCasteList");
	%>

<div class="titleBg">
<h2>Achievements by Socioeconomic Characteristics Report</h2>
</div>
<div class="Clear"></div>
<form name="achievementsBySocReport" target="_blank" method="post" action="">
<div class="Block">
<label> From Date</label> 
<input type="text" id="fromDateId" name="<%=FROM_DATE %>" value="<%=currenDate %>" class="caldate" readonly="readonly"	MAXLENGTH="30" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"	onClick="setdate('<%=currenDate %>',document.achievementsBySocReport.<%=FROM_DATE%>,event)" />

<label> To Date</label> <input type="text" id="ToDateId" name="<%=TO_DATE %>" value="<%=currenDate %>" class="calDate" readonly="readonly" MAXLENGTH="30" /> 
<img id="calendar" 	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender"	onClick="setdate('<%=currenDate %>',document.achievementsBySocReport.<%=TO_DATE%>,event)" />
<div class="Clear"></div>


<label> Religion</label> 
<select id="religionId" name="<%=RELIGION_ID%>"	validate="Religion,string,no">
<option value="0">Select</option>
	<%

				for (MasReligion masReligion :masReligionList ) {

				%>
<option value=<%=masReligion.getId()%>><%=masReligion.getReligionName()%>

	</option>
	<%
					}


				%>
</select>

<label> No. of Living Children</label>
<input type="text" id="noOflivingChildren" name="noOflivingChildren"/>



<div class="Clear"></div>

<label> From Age </label>
<input type="text" id="fromAge" name="fromAge"/>


<label> To Age</label>
<input type="text" id="toAge" name="toAge"/>


<div class="Clear"></div>

<label>Literacy Status of Husband </label>
<select id="literacyStatusOfHusband" name="literacyStatusOfHusband"	validate="Literacy Status Of Husband,string,no">
<option value="">Select</option>
<option value="Non Matric">Non Matric</option>
<option value="Matric">Matric</option>
<option value="Higher Education">Higher Education</option>
</select>



<label>Literacy Status of Wife </label>
<select id="literacyStatusOfWife" name="literacyStatusOfWife"	validate="Literacy Status Of Wife,string,no">
<option value="">Select</option>
<option value="Non Matric">Non Matric</option>
<option value="Matric">Matric</option>
<option value="Higher Education">Higher Education</option>
</select>


<div class="Clear"></div>



<label> Caste</label> 
<select id="casteId" name="<%=CASTE_ID%>"	validate="Caste,string,no">
<option value="0">Select</option>
	<%

				for (MasCaste masCaste :masCasteList ) {

				%>
<option value=<%=masCaste.getId()%>><%=masCaste.getCasteName()%>

	</option>
	<%
					}


				%>
</select>
</div>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<input type="button" name="OK" value="OK" class="button"
	onClick="submitForm('achievementsBySocReport','fwc?method=showAchievementsBySocReport');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" /></form>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
</div>





