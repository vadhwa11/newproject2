<%@ page import="java.util.Calendar"%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.MasCountry"%>
<%@ page import="jkt.hms.masters.business.MasState"%>
<%@ page import="jkt.hms.masters.business.MasTitle"%>
<%@ page import="jkt.hms.masters.business.MasRelation"%>
<%@ page import="jkt.hms.masters.business.MasReligion"%>
<%@ page import="jkt.hms.masters.business.MasOccupation"%>
<%@ page import="jkt.hms.masters.business.MasDistrict"%>
<%@ page import="jkt.hms.masters.business.MasBlock"%>
<%@ page import="jkt.hms.masters.business.MasServiceType"%>
<%@ page import="jkt.hms.masters.business.MasRank"%>
<%@ page import="jkt.hms.masters.business.MasUnit"%>
<%@ page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@ page import="jkt.hms.masters.business.MasTrade"%>
<%@ page import="jkt.hms.masters.business.MasRecordOfficeAddress"%>
<%@ page import="jkt.hms.masters.business.MasBloodGroup"%>
<%@ page import="jkt.hms.masters.business.MasReference"%>
<%@ page import="jkt.hms.masters.business.MasComplaint"%>
<%@ page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="jkt.hms.masters.business.MasCaseType"%>
<%@ page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@ page import="jkt.hms.masters.business.MasDisposal"%>
<%@ page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@ page import="jkt.hms.masters.business.MasDepartment"%>
<%@ page import="jkt.hms.masters.business.Users"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.Visit"%>

<%@ page import="java.net.URL"%>
<%@ page import="java.util.Properties"%>
<%@page import="jkt.hms.masters.business.MasServiceStatus"%>
<%@page import="jkt.hms.masters.business.MasStation"%>
<%@page import="jkt.hms.masters.business.MasSection"%>
<%@page import="jkt.hms.masters.business.MasReporting"%>
<%@page import="jkt.hms.masters.business.MasCommand"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.PatientFamilyHistory"%>
<%@page import="jkt.hms.masters.business.Category"%>
<%@page import="jkt.hms.masters.business.MalariaCase"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<script	type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/switchcontent.js"></script>
<script type="text/javascript" src="/hms/jsp/js/switchicon.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<!-- Script for tab content -->
<script type="text/javascript" src="/hms/jsp/js/tabcontentIn.js">
/***********************************************
* Tab Content script v2.2- © Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/
</script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script>
	<%Calendar calendar = Calendar.getInstance();
			String month = String.valueOf((calendar.get(Calendar.MONTH)) + 1);
			String date = String.valueOf(calendar.get(Calendar.DATE));
			int year = calendar.get(calendar.YEAR);
			if (month.length() < 2) {
				month = "0" + month;
			}
			if (date.length() < 2) {
				date = "0" + date;
			}%>
		serverdate = '<%=date + "/" + month + "/" + year%>'
</script>
<form name="malariaCase" method="post" action="">


 <%


 	Map<String, Object> utilMap = new HashMap<String, Object>();
 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");
 	Map<String, Object> map = new HashMap<String, Object>();
 	if (request.getAttribute("map") != null) {
 		map = (Map<String, Object>) request.getAttribute("map");
 	}
 	List<MasEmployee> doctorList = null;
     int hinId = 0;
	 String serviceNo="";
	 String hinNo = "";
	 String rank ="";
	 String patientName = "";
	 String trade = "";
	 String unit = "";
	 String relation = "";
	 String ServicePersonName ="";
	 String gender ="";
	 String age= "";
	 String address ="";
	 String contact ="";
	 String dateOfOnset = "";
	 String dateOfAdmission = "";
	 String Species = "";
	 String type = "";
	 String transmission ="";
     List<MalariaCase> patientList = new ArrayList<MalariaCase>();  
     List<Inpatient> inpatientList = new ArrayList<Inpatient>();
     System.out.println("patientList====>>>"+map.get("patientList"));
    if (map.get("patientList") != null)
    {
  	   patientList = (List<MalariaCase>) map.get("patientList");
  	  
	 }
    if(map.get("inpatientList")!= null)
    {
    	inpatientList = (List<Inpatient>)map.get("inpatientList");
    }
	for(MalariaCase malariaCase : patientList)
	   {
		if(malariaCase.getServiceNo()!= null)
		{
		   serviceNo = malariaCase.getServiceNo();
		}
		if(malariaCase.getHinId().getHinNo()!= null)
		{
		hinNo = malariaCase.getHinId().getHinNo();
		}
		if(malariaCase.getHinId().getRank().getRankName()!= null)
		{
		rank = malariaCase.getHinId().getRank().getRankName();
		}
		if(malariaCase.getPatientName()!= null)
		{
		  patientName = malariaCase.getPatientName(); 
		}
		if(malariaCase.getHinId().getTrade().getTradeName()!= null)
		{
		trade = malariaCase.getHinId().getTrade().getTradeName();
		}
		if(malariaCase.getHinId().getUnit().getUnitName()!= null)
		{
		unit = malariaCase.getHinId().getUnit().getUnitName();
		}
		if(malariaCase.getHinId().getRelation().getRelationName()!= null)
		{
		relation = malariaCase.getHinId().getRelation().getRelationName();
		}
		if(malariaCase.getHinId().getSFirstName()!= null)
		{
		ServicePersonName = malariaCase.getHinId().getSFirstName();
		}
		if(malariaCase.getHinId().getSex().getAdministrativeSexName()!= null)
		  {
			gender = malariaCase.getHinId().getSex().getAdministrativeSexName();
		  }
		if(malariaCase.getHinId().getAge()!= null)
		   {
			age = malariaCase.getHinId().getAge();
		   }
		if(malariaCase.getHinId().getAddress()!= null)
		   {
			address = malariaCase.getHinId().getAddress(); 
		   }
		if(malariaCase.getHinId().getContactNo()!= null)
		   {
			contact = malariaCase.getHinId().getContactNo();
		   }
		if(malariaCase.getDateOfOnset()!= null)
		   {
			dateOfOnset = HMSUtil.changeDateToddMMyyyy(malariaCase.getDateOfOnset());
		   }
		if(malariaCase.getDateOfAdmission()!= null)
		   {
			dateOfAdmission = HMSUtil.changeDateToddMMyyyy(malariaCase.getDateOfAdmission());
			System.out.println("dateOfAdmission-->"+dateOfAdmission);
		   }
		if(malariaCase.getSpecies()!= null)
		{
			Species =  malariaCase.getSpecies(); 
		}
		if(malariaCase.getType()!= null)
		 {
			type = malariaCase.getType();
		 }
		if(malariaCase.getTransmission()!= null)
		  {
			transmission = malariaCase.getTransmission();
		  }
		//hinId =malariaCase.getHinId().getId();
		hinId =malariaCase.getId();
		
	   }
    
 	
 %>

<div class="titleBg">
<h2>Malaria Case</h2>
</div>
<div class="clear"></div>

<div class="Block">
<div id="srNoDiv">
<label>Service No.</label>
<input type="text" name="serviceNo"  value="<%=serviceNo%>" MAXLENGTH="30" />

<label class="bodytextB">HIN</label>
 <input	type="text" name="<%=HIN_NO%>" value="<%=hinNo %>" class="textbox_date"  readonly="readonly" MAXLENGTH="30" />
	</div>

<div id="hinDiv11">
<label>Rank</label>
<input type="text" name="rank"   id="rank/RateId" value="<%=rank %>" readonly="readonly" />
<div class="clear"></div>
<label>Name</label>
<input type="text" name="ServName" id="nameId"   value="<%=ServicePersonName %>" readonly="readonly" />


<label>Trade/ Branch</label>
<input type="text" name="trade" id="trade" value="<%=trade %>" readonly="readonly" />

<label>Unit</label>
<input type="text" name="unit" id="unit" value="<%=unit %>" readonly="readonly" />
<div class="clear"></div>
<label>Relation</label>
<input type="text" name="relation" id="relation" value="<%=relation %>" readonly="readonly" />



<label>Patient Name</label>
<input type="text" name="patientName" value="<%=patientName %>" readonly="readonly" />

<label>Gender</label>
<input type="text" name="gender" value="<%=gender %>" readonly="readonly" />
<div class="clear"></div>
<label>Age</label>
<input type="text" name="age" value="<%=age %>" readonly="readonly" />

<label>Address</label>
<input type="text" name="address" value="<%=address %>" readonly="readonly" />

<label>Contact</label>
<input type="text" name="contact" value="<%=contact %>"  readonly="readonly" validate="Contact,int,no" />
</div>
</div>

<div class="clear paddingTop15"></div>

<div class="Block">

<label>Date of Onset</label>
<input type="text" name="onsetDate" value="<%=dateOfOnset %>" MAXLENGTH="20" class="" id="toAppDate" validate="Date,string,yes" readonly="readonly" />
<!--<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.malariaCase.onsetDate,event)" />

-->
<label>Date of Admission</label>
<%if(dateOfAdmission!= null && !dateOfAdmission.equals("")){ %>
<input type="text" name="admissionDate" value="<%=dateOfAdmission%>" MAXLENGTH="20"  id="toAppDate" validate="Date,string,yes" readonly="readonly" readonly="readonly" />
<%}else{ %>
<input type="text" name="admissionDate" value="" />
<%} %>
<!--<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.malariaCase.admissionDate,event)" />

-->
<label>Species</label>
<input type="text" name="Species"  value="<%=Species %>" readonly="readonly" />
<div class="clear"></div>
<label>Type</label>
<input type="text" name="type"  value="<%=type %>"  readonly="readonly"  />

<label>Transmission</label>
<input type="text" name="transmission" value="<%=transmission %>" readonly="readonly" />
</div>
<div class="clear paddingTop10"></div>
<div class="division"></div>
<input type="hidden" name="hinId" value="<%= hinId%>" />
<div class="clear paddingTop10"></div>
<input type="button" name="Submit11" id="addbutton"
	onclick="submitForm('malariaCase','/hms/hms/mis?method=validateSmoMalariaCase');"
	value="Validate" class="button" accesskey="a" />
<!--<input type="button" name="submit" onclick="submitForm('malariaCase','/hms/hms/mis?method=submitSmoMalariaCase');" class="button" value="Forward"  />

--><script>

function openSmoMalariaCase(){
	//alert("Smo Malaria Case");
	var url="/hms/hms/sHO?method=showSmoMalariaCase";
   	newwindow=window.open(url,'smoMalariaCase','left=2,top=0,height=500,width=1010,status=1,scrollbars=1,resizable=1');
}

function submitProtoAjaxWithDivName(formName,action,divName){
	//alert("submitProtoAjaxWithDiv In Malaria Case");
	errorMsg = "";
	ob1 = true;
	ob2 = true;
	ob3 = true;
	//alert('::formName::-'+formName+'\n::action::-'+action+'\n::divName::-'+divName);
	obj = eval('document.'+formName)
	       	obj.action = action;
    	   	 var url=action+"&"+getNameAndData(formName)
        	if(divName == "defaultList"){
        	document.getElementById('defaultList').style.display = 'inline';
        	}
        	new Ajax.Updater(divName,url,
			   {asynchronous:true, evalScripts:true }); 
			
		
	       	return true;
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

</script>

</form>

