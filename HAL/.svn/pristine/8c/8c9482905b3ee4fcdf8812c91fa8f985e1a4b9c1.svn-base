
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.ExpiryDetails"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
<%@page import="jkt.hms.masters.business.ExpiryDetails"%>
<%@page import="jkt.hms.masters.business.MasEmployeeDependent"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationDetail"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>

<%@page import="jkt.hms.masters.business.Visit"%><script type="text/javascript" language="javascript"
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
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
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
	
	
	<form name="medicalBoardForm44" action="" method="post">

   <% Map<String, Object> map = new HashMap<String, Object>();
		
   
		List<Object[]> unitList = new ArrayList<Object[]>();
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		
		List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
		List<Patient> patientList = new ArrayList<Patient>();
		
		List<Patient> dependentList = new ArrayList<Patient>();
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("dependentList")!= null)
		   {
			dependentList =(List<Patient>) map.get("dependentList");
		   }
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");  
		String time = (String)utilMap.get("currentTime");
		
		
		List<MasMedicalExaminationDetail> masMedicalExaminationDetailList = new ArrayList<MasMedicalExaminationDetail>();
		if(map.get("masMedicalExaminationDetailList") != null)
		{
			masMedicalExaminationDetailList = (List<MasMedicalExaminationDetail>)map.get("masMedicalExaminationDetailList");
		}
		
		List<OpdPatientDetails> opdPatientDetailsList = new ArrayList<OpdPatientDetails>();
		if(map.get("opdPatientDetailsList") != null )
		{
			opdPatientDetailsList = (List<OpdPatientDetails>)map.get("opdPatientDetailsList");
		}
		
		List<Visit> visitList = new ArrayList<Visit>();
		if(map.get("visit") != null )
		{
			visitList = (List<Visit>)map.get("visit");
		}
		int opdId=0;
		if(map.get("opdId") != null)
		{
			opdId=(Integer)map.get("opdId");
			System.out.println("opdId-->"+opdId);
		}
	
		
			
		//List<MasIcd> diagnosisList = new ArrayList<MasIcd>();
		//if(map.get("diagnosisList") != null )
		//{
		//	diagnosisList = (List<MasIcd>)map.get("diagnosisList");
		//}
		  String principal="";
		%>
		

<div class="titleBg">
<h2>AFMSF - 44</h2>
</div>

<div class="Block">
<%

if(visitList != null)
{
for(Visit visit : visitList) 
{ 
%>

<label>Service No.</label>
<input type="text" name="serviceNo" id="serviceNo"  MAXLENGTH="30" validate="serviceNo,metachar,yes" onblur=""
value="<%=visit.getHin().getServiceNo() %>" />

<input type="hidden" name="hinId" value="<%=visit.getHin().getId() %>" />
<input type="hidden" name="visitId" value="<%=visit.getId()%>" />


<div id="hinDiv11">

<label>Rank</label>
<input type="text" name="rank" readonly="readonly" validate="Rank, number,no" id="rank/RateId" value="<%=visit.getHin().getRank().getRankName() %>" tabindex="1" />

<label>Name & Initial</label>
<%
String patientName="";
if((visit.getHin().getPLastName())!=null){
patientName= visit.getHin().getPFirstName().concat(" ").concat(visit.getHin().getPLastName());
System.out.println("patientName--F_L->"+patientName);
}
else{
	patientName= visit.getHin().getPFirstName();
	System.out.println("patientName-L-->"+patientName);
}
%>
<input type="text" readonly="readonly" name="patientName" value="<%=patientName%>" tabindex="1" />

<div class="clear"></div>

<label>Trade/ Branch</label>
<input type="text" name="trade" readonly="readonly" id="unit" value="<%=visit.getHin().getUnit().getUnitName() %>" tabindex="1"  />

<label>Age</label>
<input type="text" readonly="readonly" name="age" value="<%=visit.getHin().getAge() %>" tabindex="1"  />

<label>Diagnosis</label>
<input type="text" tabindex="1" value="" id="clinical"  maxlength="100" name="clinical"	class=""  size="" onblur="" />

<label>Disposal</label>
<textarea name="disposal" class="auto" cols="88" rows="" onkeyup="chkLength(this,100);" onpaste="return checkOnPaste(this)"	tabindex="1"
oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)"></textarea>
</div>

<%}} %>

 	
<div class="Clear PaddingTop15"></div>

<input type="button" name="Submit11" id="addbutton" onclick="submitForm('medicalBoardForm44','/hms/hms/medicalBoard?method=submitMedicalBoardForm44');" value="Submit" class="button" accesskey="a" />

<input type="reset" name ="Reset" value ="Reset" class="button" tabindex="1" accesskey="r" onclick=resetCheck();/>

	
<div class="Clear"></div>
</form>
<script language="JavaScript" type="text/JavaScript">

 function chkLength(field,maxLimit)
   {
   if(field.value.length > maxLimit)
   {
    alert('Maximum Limit is '+maxLimit+' characters.');
    var val=field.value.substring(0,maxLimit);
    field.value=val;
   }
 }

function chkBlankTextbox()
{
	var tName=document.getElementById("typeAnswer");
	if(tName.value=="")
	{
		alert("Please type your Answer..");
		return false;
	}
	if(tName.value!="")
	{
		return true;
	}

}

 </script> 

