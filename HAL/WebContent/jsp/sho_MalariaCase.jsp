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
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.PatientFamilyHistory"%>
<%@page import="jkt.hms.masters.business.Category"%>

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
	Properties properties = new Properties();
	URL resourcePathHIC = Thread.currentThread()
			.getContextClassLoader().getResource(
					"hicDetails.properties");
	try {
		properties.load(resourcePathHIC.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	String urlForImportFromHIC = properties
			.getProperty("urlForImportFromHIC");
%> <%

//Properties properties = new Properties();
URL resourcePath = Thread.currentThread().getContextClassLoader()
.getResource("adt.properties");
try {
properties.load(resourcePath.openStream());
} catch (Exception e) {
e.printStackTrace();
}
String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
 	Map<String, Object> utilMap = new HashMap<String, Object>();
 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");
 	Map<String, Object> map = new HashMap<String, Object>();
 	if (request.getAttribute("map") != null) {
 		map = (Map<String, Object>) request.getAttribute("map");
 	}
 	List<MasEmployee> doctorList = null;

	if(map.get("doctorList") != null){
		doctorList=(List)map.get("doctorList");
		}
 	
	String userName = "";
	if (session.getAttribute("userName") != null) {
	userName = (String) session.getAttribute("userName");
	}
	Users user = new Users();
	if(session.getAttribute("users")!=null){
		user = (Users)session.getAttribute("users");
	}
	
 	List<MasAdministrativeSex> sexList = null;
 	List<MasDistrict> districtList = null;
 	List<MasState> stateList = null;

 	String administrativeSexMaleCode = properties
 			.getProperty("administrativeSexMaleCode");

 	if (map.get("sexList") != null) {
 		sexList = (List<MasAdministrativeSex>) map.get("sexList");
 	}
 	if (map.get("districtList") != null) {
 		districtList = (List<MasDistrict>) map.get("districtList");
 	}
 	if (map.get("stateList") != null) {
 		stateList = (List<MasState>) map.get("stateList");
 	}
 %>

<div class="titleBg">
<h2>Malaria Case</h2>
</div>
<div class="clear"></div>

<div class="Block">
<div id="srNoDiv">
<label>Service No.<span>*</span></label>
<input type="text" name="serviceNo"  value="" MAXLENGTH="30" validate="serviceNo,metachar,yes" id="serviceNo"
	onblur="if(validateMetaCharacters(this.value)){submitProtoAjaxWithDivName('malariaCase','mis?method=getHinNoForMalariaCase&flag=hin','srNoDiv')}"/>

<label>HIN</label> <input
	type="text" name="<%=HIN_NO%>" value=""	MAXLENGTH="30" onchange="submitProtoAjax('malariaCase','mis?method=getPatientDetailForMalaria','hinDiv')"/>
	</div>

<div id="hinDiv11">
<label>Rank</label>
<input type="text" name="rank" readonly="readonly" validate="Rank, number,no" id="rank/RateId" value="" />

<label>Name</label>
<input type="text" name="ServName" id="nameId" readonly="readonly" validate="name, string,no" value="" />


<label>Trade/ Branch</label>
<input type="text" name="trade" readonly="readonly" id="trade" value="" />

<label>Unit</label>
<input type="text" name="unit" readonly="readonly" id="unit" value="" />

<label>Relation</label>
<input type="text" name="relation" readonly="readonly" id="relation" value="" />


<label>Patient Name</label>
<input type="text" readonly="readonly" name="patientName" value="" />

<label>Gender</label>
<input type="text" readonly="readonly" name="gender" value="" />

<label>Age</label>
<input type="text" name="age" value="" readonly="readonly" />

<label>Address</label>
<input type="text" name="address" value="" readonly="readonly" />

<label>Contact</label>
<input type="text" name="contact" value="" readonly="readonly" />

<label>Date of Admission</label>
<input type="text" name="admissionDate" value="" MAXLENGTH="20"  id="toAppDate" readonly="readonly" />

</div>
</div>

<div class="clear paddingTop15"></div>

<div class="Block">

<label>Date of Onset</label>
<input type="text" name="onsetDate" value="<%=currentDate %>" MAXLENGTH="20" class="date" id="toAppDate" validate="Date,string,yes" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.malariaCase.onsetDate,event)" />

<!--<label>Date of Admission</label>
<input type="text" name="admissionDate" value="<%=currentDate %>" MAXLENGTH="20"  id="toAppDate" validate="Date,string,yes" />
--><!--<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.malariaCase.admissionDate,event)" />

-->
<label>Species</label>
<select name="species">
<option>Pf</option>
<option>Pv</option>
<option>Pm</option>
<option>Pq</option>
<option>Mixed</option>
</select>


<label>Type</label>
<select name="type">
<option>FI</option>
<option>FL</option>
<option>Relapse</option>
</select>
<div class="clear"></div>
<label>Transmission</label>
<select name="transmission">
<option>Local</option>
<option>Imported</option>
</select>
<label>ForwardTo</label>
<select name="forwardTo">
<%
int doctorId=0;
for(MasEmployee masEmployee : doctorList){
	doctorId = masEmployee.getId();
	if(masEmployee.getEmpCategory() != null){
		if(masEmployee.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor)){
			if(user.getEmployee().getId() == doctorId){
%>
<option value="<%=masEmployee.getId() %>" selected="selected"><%=masEmployee.getRank().getRankName()+" "+masEmployee.getFirstName()+" "+masEmployee.getLastName() %></option>
<%}else{ %>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getRank().getRankName()+" "+masEmployee.getFirstName()+" "+masEmployee.getLastName() %></option>
	<%				}
		}
	}
} %>
</select>

</div>

<div class="clear paddingTop10"></div>
<div class="division"></div>

<div class="clear paddingTop10"></div>
<input type="button" name="Submit11" id="addbutton"
	onclick="submitForm('malariaCase','/hms/hms/mis?method=submitSmoMalariaCase');"
	value="Forward" class="button" accesskey="a" />
<!--<input type="button" name="submit" onclick="submitForm('malariaCase','/hms/hms/mis?method=submitSmoMalariaCase');" class="button" value="Forward"  />

-->
<script>

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

