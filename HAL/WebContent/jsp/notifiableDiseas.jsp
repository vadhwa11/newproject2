
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
	
	
	<form name="notifiableDisease" action="" method="post">

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
			//System.out.println("masMedicalExaminationDetailList-->"+masMedicalExaminationDetailList.size());
		}
		
		
		  String principal="";
		%>
		

<div class="titleBg">
<h2>Notifiable Disease</h2>
</div>

<div class="Block">


<label>Service No.</label>
<input type="text" name="serviceNo" id="serviceNo"  value="" MAXLENGTH="30" validate="serviceNo,metachar,yes"
	onblur="getHinNoForNotifiableDisease();"/>
<script>
function getHinNoForNotifiableDisease()
{
var hinNo='';
hinNo=document.getElementById('serviceNo').value;

if(validateMetaCharacters(hinNo))
{
	submitProtoAjaxWithDivName('notifiableDisease','mis?method=getHinNoForNotifiableDisease&flag='+hinNo,'hinDiv')
}
}
</script>
<div id="hinDiv">
<label>HIN</label> 
<input	type="text" name="<%=HIN_NO%>" value=""	MAXLENGTH="30" onchange="submitProtoAjax('notifiableDisease','mis?method=getPatientDetailForMalaria','hinDiv')"/>
</div>

<div class="clear"></div>
<div id="hinDiv11">

<label>Patient Name</label>
<input type="text" readonly="readonly" name="patientName" value="" tabindex="1" />

<label>Relation</label>
<input type="text" readonly="readonly" name="relation" value="" tabindex="1" />

<label>Rank</label>
<input type="text" name="rank" readonly="readonly" validate="Rank, number,no" id="rank/RateId" value="" tabindex="1" />

<div class="clear"></div>

<label>Name</label>
<input type="text" name="servicePersonName" id="nameId" readonly="readonly" validate="name, string,no" value="" tabindex="1" />

<!--<label>Relation</label>
<input type="text" name="relation" readonly="readonly" id="relation" value="" />
-->
<label>Age</label>
<input type="text" readonly="readonly" name="age" value="" tabindex="1"  />

<label>Gender</label>
<input type="text" readonly="readonly" name="gender" value="" tabindex="1"  />

<div class="clear"></div>

<label>Unit</label>
<input type="text" name="unit" readonly="readonly" id="unit" value="" tabindex="1"  />

</div>

<!--<div id="srNoDiv">

<div class="clear"></div> 
<label>Designation of Quarters, Residence or Naval Mess</label> 
<input type="text" name="residence" validate="unit , string,no" id="residence" value="" tabindex="1"  />
</div>

--><label>Date of Onset</label>
<input type="text"	id="dateOfOnset" name="<%=DATE_OF_ONSET%>" tabindex="1" value="<%=currentDate %>" 
readonly="readonly" validate="Date Of Onset,date,no" MAXLENGTH="30"	class="calDate" onblur="calculateTotalService(this.value);" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" class="calender"  
onClick="setdate('<%=currentDate %>',document.notifiableDisease.<%=DATE_OF_ONSET%>,event)" />


<label>Date of Reporting Sick</label>

<input type="text"	id="commissionDateId" name="<%=DATE_OF_REPORTING_SICK %>" tabindex="1" value="<%=currentDate %>"	
readonly="readonly" validate="Date of Reporting Sick,date,no" MAXLENGTH="30"	class="calDate" onblur="calculateTotalService(this.value);" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0"  class="calender" validate="Pick a date"
onClick="setdate('<%=currentDate %>',document.notifiableDisease.<%=DATE_OF_REPORTING_SICK %>,event)" />

<div class="clear"></div>
  
<label>Date of Admission</label>

<input type="text"	id="commissionDateId" name="<%=NOTIFIABLE_DATE%>" tabindex="1" value=""	
readonly="" validate="Date of Admission,date,no" MAXLENGTH="30"	class="calDate" onblur="calculateTotalService(this.value);" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" 
onClick="setdate('<%=currentDate %>',document.notifiableDisease.<%=NOTIFIABLE_DATE%>,event)"/>
<div class="clear"></div>
</div>

<div class="clear PaddingTop10"></div>
  
<h4>Basic of Diagnosis</h4>

<div class="clear"></div>

<div class="Block">

<label class="large">Clinical</label>

<% 

//if(masMedicalExaminationDetailList!=null && masMedicalExaminationDetailList.size()>0)
//{
for(MasMedicalExaminationDetail masMedicalExamDetails:masMedicalExaminationDetailList)
{
	if(masMedicalExamDetails.getParticular() !=null && masMedicalExamDetails.getParticular().equals(""))
	{
	%>
<%

 if(masMedicalExamDetails.getPrincipal()!=null){
	  principal=masMedicalExamDetails.getPrincipal();
	  
  }
  int icdId=0;
  String icdCode="";
	if(masMedicalExamDetails.getMasIcd()!=null){
		icdId=masMedicalExamDetails.getMasIcd().getId();
		icdCode=masMedicalExamDetails.getMasIcd().getIcdCode();
	}

	if(principal!=""){
		principal=principal+"["+icdCode+"]"+"["+icdId+"]";
	}
	}
}
  %>
 <input type="text" tabindex="1" value="" id="clinical"  maxlength="200" name="clinical"	class="auto"  size="122" onblur="checkDisability(this.value);" />


<div id="clinicalId"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">

		  
		  new Ajax.Autocompleter('clinical','clinicalId','opd?method=getICDForIdList',{parameters:'requiredField=clinical'});
		   
</script>



<div class="clear"></div>

<label class="large">Bacteriological</label>
<input type="text" tabindex="1"  class="auto" size="122" name="bacteriological" validate="bacteriological,string,no" id="bacteriological" value="" maxlength="200" />		

<div class="clear"></div>
 		
<label class="large">Suspected source of infection (including movement)</label>		
<input	tabindex="1" type="text" maxlength="200" name="suspectedsourceofinfection"	class="auto" size="122"   />

</div>

<div class="clear PaddingTop10"></div> 
<h4>Measures of Control</h4>		
<div class="clear"></div>

<div class="Block">
 
<label>Disinfection </label>		
<input tabindex="1" maxlength="50" type="text" name="disinfection"  validate="disinfection , string,no" id="disinfectionId" value="" />			

<label>Contact</label>	
<input tabindex="1"  type="text" name="contact" MAXLENGTH="12" validate="contact,int,yes"id="contactId"  value="" />		
<div class="clear"></div> 

<label class="large">Date of Preventive Inoculation or Vaccination</label>		
<input type="text"	id="commissionDateId" name="dateofPreventive" tabindex="1" value="<%=currentDate %>"	
readonly="readonly" validate="commission Date,date,no" MAXLENGTH="30"	class="calDate" onblur="calculateTotalService(this.value);" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" 
onClick="setdate('<%= currentDate %>',document.notifiableDisease.dateofPreventive,event)"/>
	<div class="Clear"></div>

<label>General Remarks </label>		
<!--<input type="text" name="genaralRemarks" validate="General Remarks, string,no"  id="genaralRemarksId" value="" size="80"/>	
-->
<input	tabindex="1" type="text" maxlength="50" name="genaralRemarks"	class="auto" size="155" maxlength="50"  />

</div>
 	
<div class="Clear PaddingTop15"></div>
<input type="button" name="Submit11" id="addbutton"
	onclick="submitForm('notifiableDisease','/hms/hms/mis?method=submitNotifiableDiseaseJsp');"
	value="Submit" class="button" accesskey="a" />
<input type="reset" name ="Reset" value ="Reset" class="button" tabindex="1" accesskey="r" onclick=resetCheck();/>

<!--<input type="button" name="Print" value="Print" class="button" tabindex="1" />

-->
<!--<input type="button" name="Back" value="Back" class="button" tabindex="1" onclick="submitForm('notifiableDisease','/hms/hms/login?method=showHomeJsp');" />	
	-->

	
	
<div class="Clear"></div>
</form>
<script type="text/javascript">
function getPatientDetails(val)
{

	if(trimAll(val) != '')
		{
		if(validateMetaCharacters(val))
			{
		var serNo = trimAll(val);
		
		if(serNo != 0)
			{
			submitProtoAjaxforPatientDetails('notifiableDisease','/hms/hms/mis?method=getServiceNoDetailsForSho&serviceNo='+val);
				
		}else
			{
				alert("Service No. can not be 0.")
				document.getElementById('serviceNoId').value = "";
		}
		}else
			{
		alert("Service No is not valid.")
		document.getElementById('serviceNoId').value = "";


		}
	}
	}

function getPatientDetails(val)
{  
	validateAlphaNumeric();
	
}
function submitProtoAjaxForHin(formName,action){
	
	errorMsg = "";
	ob1 = true;
	ob2 = true;
	ob3 = true;
	
	obj = eval('document.'+formName)
	       	obj.action = action;
    	   	 var url=action+"&"+getNameAndData(formName)
        	new Ajax.Updater('hinDiv11',url,
			   {asynchronous:true, evalScripts:true }); 
			return true;
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

function checkDisability(val)
{ 
	if(val != ""){
			
			var index1 = val.lastIndexOf("[");
			var index = index1;
			var index2 = val.lastIndexOf("]");
			index1++;
			var id = val.substring(index1,index2);
			var index = index--;
			var disability = val.substring(0,index);		
			if(id == "" )
				 {
				if(document.getElementById('clinical'))
					{
			      	document.getElementById('clinical').value="";
			      //	document.getElementById('origindate').value="";
			    	//document.getElementById('place').value="";
			   //  document.getElementById('presentMedicalCategory'+inc).value="0";
			    	//document.getElementById('medicalcatdate').value="";
			      //	document.getElementById('nextcatdate').value="";
			    //	document.getElementById('aggravation'+inc).value="";
			    	//if(document.getElementById('remarks'))
			    	//	document.getElementById('remarks').value="";
				}
		     return false;
			}		
	}
	}

</script>

