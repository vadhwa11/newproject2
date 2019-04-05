
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
	
	
	<form name="AntiMalariaFlyFilariaMeasuresEntry" action="" method="post">

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

	
<div class="titleBg"><h2>Anti Malaria/ Fly/ Filaria Measures Entry</h2>
</div>
<div class="Block">


<div class="clear"></div>
<h4> Details of anti malaria measures adopted </h4>
<label>Date</label>
<input type="text" id="antiMalariaDate" name="<%=DATE_OF_ANTIMALARIA%>" value="<%=currentDate %>" readonly="readonly" class="textbox_date"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"
   onClick="setdate('<%=currentDate %>',document.AntiMalariaFlyFilariaMeasuresEntry.<%=DATE_OF_ANTIMALARIA%>,event)" />
<div class="clear"></div>
<label style="width: 312px"> Insecticide Spray </label>
<input type="text" name="Number of rounds"  maxlength="49" validate="sevice no ,number,no" id="Number of rounds" value="" />

<label style="width: 312px">Personal Protective Measures </label>
<input type="text" name="Adoption" id="Adoption"  maxlength="49" validate="name, string,no" value="" />
<div class="Clear"></div>	

<label style="width: 312px">Anti Larval</label>
<input type="text" name="AntiLarval"  maxlength="49" validate="rank, number,no" id="AntiLarval" value="" />

<label style="width: 312px"> Anti Malaria meetings </label>
<input type="text" name="AntiMalariameetings" maxlength="49" validate="age , number,no" id="ntiMalariameetings" value="" />
<div class="Clear"></div>	
<label style="width: 312px"> Suppressive treatment </label>
<input type="text" name="Suppressivetreatment" maxlength="49"  validate="length of service , string,no" id="Suppressivetreatment" value="" />

<h4> No. of malaria  cases  during the year  </h4>
<div class="clear"></div>

<label style="width: 312px">Types of cases</label>
<input type="text" name="Typesofcases" maxlength="49" validate="unit , string,no" id="Typesofcases" value="" />

<label style="width: 312px"> Specimen of Plasmodium </label>
<input type="text" name="SpecimenofPlasmodium" maxlength="49" validate="unit , string,no" id="SpecimenofPlasmodium" value="" />
<div class="clear"></div> 

<label style="width: 312px">  Properly investigated cases  </label>
<input type="text" name="weatherInvestigated" maxlength="49" validate="unit , string,no" id="weatherInvestigated" value="" />

<label style="width: 312px"> Remedical  preventing further spread </label>
<input type="text" name="Remedicalspreventing" maxlength="49"  validate="unit , string,no" id="unit/ShipId" value="" />
<div class="clear"></div> 

<h4> Anti Malaria Measures</h4> 
<div class="clear"></div> 

<label style="width: 312px"> Fly proofing of kitchen and dining halls </label>		 
		
<input type="text"	id="commissionDateId" name="Flyproofing"  value=""/>
<label style="width: 312px"> Types </label>
<select name="DisposalRefuse" validate="basic of diagnosis , string,no" id="basicofDiagnosisId" value="" >	
<option>Disposal</option>
<option>Refuse</option>
<option>Garbage</option>
</select>	
<label style="width: 312px"> Insecticide spray frequency </label>

<input type="text" name="Frequencyofinsecticide" validate="clinical , string,no" id="clinical" value="" />		

<h4> Anti Filaria Measures </h4>		
	
<div class="clear"></div> 
<label style="width: 312px"> No. of detected case  </label>		
<input type="text" name="Numberofbloodslides"  maxlength="19" validate="disinfection , string,no" id="Numberofbloodslides" value="" />			

<label style="width: 312px"> Details of treatment  </label>	
<input type="text" name="Detailsoftreatment" MAXLENGTH="49" validate="contact, number,no"id="Detailsoftreatment"  value="" />		
<div class="clear"></div> 
<label style="width: 312px">Anti Filarial  adopted </label>		
<input type="text"	id="AntiFilarialMeasures" name="AntiFilarialMeasures" maxlength="49" value=""/>	
	<div class="Clear"></div>	


<input type="button" name="Submit" id="addbutton"
	onclick="submitForm('AntiMalariaFlyFilariaMeasuresEntry','/hms/hms/mis?method=submitAntiMalariaJsp');"
	value="Submit" class="button" accesskey="a" />
<input type="reset" name ="Reset" value ="Reset" class="button" tabindex="1" accesskey="r" />
<!--
<input type="button" name="Print" value="Print" class="button" tabindex="1" />-->

<!--<input type="button" name="Back" value="Back" class="button" tabindex="1" onclick="history.back()"/>	
	--></div>
	
	
<div class="Clear"></div>
</form>










