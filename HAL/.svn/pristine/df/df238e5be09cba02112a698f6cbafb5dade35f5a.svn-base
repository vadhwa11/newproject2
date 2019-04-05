<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.ExpiryDetails"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Category"%>
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
	
<form name="familyHealthProgramme" action="" method="post">

   <% Map<String, Object> map = new HashMap<String, Object>();
		
   List<MasUnit> unitList = new ArrayList<MasUnit>();
				
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		
		if(map.get("unitList") != null){
			unitList = (List<MasUnit>)map.get("unitList");
		}
		
		
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");  
		String time = (String)utilMap.get("currentTime");%>
	
	
<div class="titleBg">
<h2>Family Health Programme</h2>
</div>
<div class="Block"><label>Current Date</label><input type="text" name="healthDate" id="healthDate"  readonly=""  value="<%=currentDate%>" class="date" class="auto" size="11" validate="Date,date,yes" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" onclick="javascript:setdate('healthDate',document.familyHealthProgramme.healthDate, event)"	validate="Pick a date"  />

<div class="clear"></div>

<label>Unit</label>

<select name="unitname">
<option value="0">Select</option>
<%if(unitList!=null && unitList.size() >0){
	 for(MasUnit unit : unitList){
	%>
	<option value="<%=unit.getId()%>"><%=unit.getUnitName()%></option>
	
<%}}%>
</select>

<label>Age Group</label>
<select name="ageGroup">
<option>select</option>
<option>20 - 30</option>
<option>30 - 40</option>
<option>40 - 50</option>
<option>50 - 60</option>
<option> > 60 </option>
</select>

<%
int currYear = Calendar.getInstance().get(Calendar.YEAR);
%>

<label class="medium">Year<span>*</span></label>
<!--<input type="text" value="<%=currYear%>" />-->
<select name="year" class="smallest" validate="Year,string,yes" >
<option>Select</option>
<%
int currentYear = 0;
for(currentYear=currYear; currentYear<=(currYear+5); currentYear++ ){ %>
<option value="<%=currentYear%>"><%=currentYear%></option>
<%} %>
</select>

<select name="halfYear" class="" validate="Half Year,string,yes">
<option>Select</option>
<option value="January - June">January - June</option>
<option value="July - December">July - December</option>
</select>

<div class="clear"></div>

<label>Total Strength of Spouse<span>*</span></label>
<input type="text" name="totalStrength" validate="Total Strength of Spouse,int,yes" />

<label class="">No. of Spouse examined in Half Year<span>*</span></label>
<input type="text" name="noSpouseExamined" validate="No. of Spouse examined in Half Year,int,yes" />

<label>Number Examined<span>*</span></label>
<input type="text" name="noExamined" validate="Number Examined,int,yes" />

</div>

<div class="clear PaddingTop10"></div>
<h4>Physical Examination</h4>
<div class="clear PaddingTop10"></div>
<h3>Over Weight & Obesity</h3>
<div class="Block">

<label>Over Weight</label>
<input type="text" name="overWeight" validate="Over Weight,int,no" />

</div>

<h3>Obesity</h3>
<div class="Block">

<label>Obese</label>
<input type="text" name="obese"  validate="Obese,int,no" />

</div>

<h3>Abdomen Examination</h3>
<div class="Block">

<label>Abdomen Examination</label>
<input type="text" name="abdomenExam"  validate="Abdomen Examination,int,no" />

</div>

<h3>Breast Examination</h3>
<div class="Block">

<label>Abnormality Detected</label>
<input type="text" name="breastExam"  validate="Abnormality Detected,int,no" />

</div>

<h3>Blood Pressure</h3>
<div class="Block">

<label>HTN</label>
<input type="text" name="htn"  validate="HTN,int,no" />

</div>

<h3>Clinical</h3>
<div class="Block">

<label>Cardiac Murmur/ Abnormality</label>
<input type="text" name="cardiacAbnormal"  validate="Cardiac Murmur,int,no" />

</div>

<h3>ECG</h3>
<div class="Block">

<label>ECG Abnormality</label>
<input type="text" name="ecgAbnormility"  validate="ECG Abnormality,int,no" />

</div>

<h3>Vision Test</h3>
<div class="Block">

<label>Refractory Error</label>
<input type="text" name="refractoryError"  validate="Refractory Error,int,no" />

</div>

<h3>Blood Hb%</h3>
<div class="Block">

<label>Anaemia Detected</label>
<input type="text" name="bloodAnaemia"  validate="Anaemia Detected,int,no" />

</div>

<h3>Blood Sugar</h3>
<div class="Block">

<label>Abnormality Detected</label>
<input type="text" name="bloodSugar"  validate="Abnormality Detected,int,no" />

</div>

<h3>T3, T4, TSH</h3>
<div class="Block">

<label>Thyroid Abnormality</label>
<input type="text" name="bloodThyroid"  validate="Thyroid Abnormality,int,no" />

</div>

<h3>Lipid Profile</h3>
<div class="Block">

<label>Dislipedaemia</label>
<input type="text" name="bloodLapid"  validate="Dislipedaemia,int,no" />

</div>


<h3>NIDDM</h3>
<div class="Block">

<label>Niddm</label>
<input type="text" name="niddm" validate="Niddm,int,no" />

</div>


<h3>DENTAL CARIES</h3>
<div class="Block">

<label>Dental Caries</label>
<input type="text" name="dentalCaries" validate="Dental Caries,int,no"/>

</div>
<div class="clear PaddingTop10"></div>
<div class="division"></div>
<input type="button" class="button" name="save" value="Submit" onclick="submitForm('familyHealthProgramme','/hms/hms/mis?method=submitFamilyHealthProgrammeJsp');" />
<div class="clear paddinfTop10"></div>
</form>	